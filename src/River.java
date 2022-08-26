
public class River {
    Animal river[];

    public River() {
        river = new Animal[100];

    }

    public River(int num) {
        river = new Animal[num];
    }
    //return boolean so we can return false is out of bounds or index is full
    public boolean addAnimal(Animal a, int index) {
        if (index < 0 || index >= river.length)
            return false;

        Animal temp = getAnimalAt(index);
        if (temp != null) {
            return false;
        }
        else {
            river[index] = a;
            return true;
        }

    }

    public Animal getAnimalAt(int index) {
        if (index < 0 || index >= river.length) {
            throw new ArrayIndexOutOfBoundsException("Index not valid");
        }
        return river[index];
    }


    public String toString() {
        String output = "";

        for (Animal a: river) {
            if (a == null)
                output += "~";
            else
                output += a.getSymbol();
        }
        return output;
    }

    public void stepSim() {
        for (int i = 0; i < river.length; i++) {
            Animal current = getAnimalAt(i);
            if (current != null) {
                current.act(i);
            }
        }
    }
    public void deleteAnimal(int index) {
        river[index] = null;
    }



}
