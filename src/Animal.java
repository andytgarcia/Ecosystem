import com.sun.source.tree.InstanceOfTree;

public class Animal {
    private String symbol;
    private static River river;

    public Animal() {
        symbol = "A";
    }
    public Animal(String symbol) {
        this.symbol = symbol;
    }

    public static void setRiver(River river) {
        Animal.river = river;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void act(int index) {
        if (river == null)
            throw new IllegalStateException("Cannot Act - No River Set for Animals");

        int choice = (int) (1 + Math.random() * 100);
        if (choice <= 20) { //move left
            //make sure im nor at left end
            if (index == 0)
                return;
            //get the animal next to me
            Animal nextToMe = river.getAnimalAt(index - 1);
            if (nextToMe == null) { //if the empty space is empty, move it
                river.deleteAnimal(index);
                river.addAnimal(this, index - 1);
            } else {
                if (this instanceof Bear && nextToMe instanceof Bear) {
                    mate(new Bear());//if its the same animal
                }
                else if (this instanceof Fish && nextToMe instanceof Fish)
                    mate(new Fish());
                else if (this instanceof Bear && nextToMe instanceof Fish)
                    river.deleteAnimal(index - 1);
                else
                    river.deleteAnimal(index);
                                //add a new one of the SAME TYPE
                                //if its a different animal
                                 //delete the Fish, not the Bear

            }

        } else if (choice <= 40) { //move right
            if (index == river.river.length -1)
                return;
            Animal nextToMe = river.getAnimalAt(index + 1);
            if (nextToMe == null) {
                river.deleteAnimal(index);
                river.addAnimal(this, index + 1);
            } else {
                if (this instanceof Bear && nextToMe instanceof Bear) {
                    mate(new Bear());//if its the same animal
                } else if (this instanceof Fish && nextToMe instanceof Fish)
                    mate(new Fish());
                else if (this instanceof Bear && nextToMe instanceof Fish)
                    river.deleteAnimal(index + 1);
                else
                    river.deleteAnimal(index);
            }

        }
    }
 //take out for loop, have it keep going through random to find available spot
    public void mate(Animal a) { //adds animal passed in, close to original two animals
        int choice = (int)(Math.random() * river.river.length);
        if (river.addAnimal(a, choice)) //if the random location works, then add the animal to it
            river.addAnimal(a, choice);
        else
            for (int i = 0; i < river.river.length; i++) {      // if not, find the first available location where it could work
                if (river.river[i] == null) {
                    river.addAnimal(a, i);
                    return;
                }
            }

    }


}
