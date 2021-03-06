package model.map;

import java.util.ArrayList;
import java.util.Random;

import model.active.Prey;
import model.active.Animal;

public class Forest extends Map {
    private ArrayList<Animal> prey;
    private int maxAniNum=6;

    public Forest() {
        this.prey = null;
        this.setName(null);
        this.setBackgroundImg(null);
    }

    public Forest(String name) {
        this.prey = null;
        this.setName(name);
        this.setBackgroundImg(null);
    }

    public void setPrey(ArrayList<Animal> prey) {
        this.prey = prey;
    }

    public ArrayList<Animal> getPrey() {
        return this.prey;
    }

    public ArrayList<Animal> enter() {
        return null;
    }

    public void enter(int num) {
        Random r = new Random();
        int preyNum = r.nextInt(6) + 1;

        if (num == 1) {
            for (int i = 0; i < preyNum; i++)
                prey.add(new Prey(45, 5, "Deer", "./resourceFolder/image/animal/DeerLeft.png", "./resourceFolder/image/animal/DeerRight.png"));
            for (int i = 0; i < this.maxAniNum - preyNum; i++)
                prey.add(new Prey(40, 5, "Rabbit", "./resourceFolder/image/animal/RabbitLeft.png", "./resourceFolder/image/animal/RabbitRight.png"));
        }
        if (num == 2) {
            for (int i = 0; i < preyNum; i++) 
                prey.add(new Prey(35, 10, "Tiger", "./resourceFolder/image/animal/TigerLeft.png", "./resourceFolder/image/animal/TigerRight.png"));
            for (int i = 0; i < this.maxAniNum - preyNum; i++)
                prey.add(new Prey(35, 10, "Lion", "./resourceFolder/image/animal/LionLeft.png", "./resourceFolder/image/animal/LionRight.png"));
        }
    }
}
