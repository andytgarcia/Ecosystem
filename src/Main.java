import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        River myRiver = new River();
        System.out.println(myRiver);

        Animal.setRiver(myRiver);

        myRiver.addAnimal(new Bear(), 10);
        myRiver.addAnimal(new Fish(), 35);
        myRiver.addAnimal(new Fish(), 40);
        myRiver.addAnimal(new Fish(), 60);
        myRiver.addAnimal(new Bear(), 80);
        myRiver.addAnimal(new Fish(), 99);
        myRiver.addAnimal(new Fish(), 85);





        while (true) {
            myRiver.stepSim();
            System.out.println(myRiver);
            Thread.sleep(400);
        }

    }
}
