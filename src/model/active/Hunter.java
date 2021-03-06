package model.active;

import java.util.ArrayList;

import model.item.*;
import model.map.Forest;

public class Hunter implements Catchable {
    public static Hunter instance = null;
    private Active actionInfo = new Active();
    private int money;
    private int asset;
    private int increRange;
    private Item[] items = {Trap.getInstance(), Net.getInstance(), Gun.getInstance(), Feed.getIstance()};
    private ArrayList<String> btmImg;
    private ArrayList<Prey> prison;

    private int[] numAni = {0, 0, 0, 0}; //deer, rabbit, tiger, lion

    private HunterDog dog = HunterDog.getInstance();

    private Hunter() {
        this.money = 0;
        this.asset = 0;
        this.increRange = 0;
        this.prison = new ArrayList<Prey>();
        this.btmImg = new ArrayList<String>();
        this.btmImg.add(0, "./resourceFolder/image/hunter/tubeLeft1.png");
        this.btmImg.add(1, "./resourceFolder/image/hunter/tubeRight1.png");
        this.btmImg.add(2, "./resourceFolder/image/hunter/tubeNetLeft.png");
        this.btmImg.add(3, "./resourceFolder/image/hunter/tubeNetRight.png");
        this.btmImg.add(4, "./resourceFolder/image/hunter/tubeGunLeft.png");
        this.btmImg.add(5, "./resourceFolder/image/hunter/tubeGunRight.png");
        this.getActionInfo().setName(null);
        this.getActionInfo().setDelay(40);
    }

    public static Hunter getInstance() {
        if (instance == null)
            instance = new Hunter();
        return instance;
    }

    public Active getActionInfo() {
        return actionInfo;
    }

    public void setActionInfo(Active actionInfo) {
        this.actionInfo = actionInfo;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getAsset() {
        return asset;
    }

    public void setAsset(int asset) {
        this.asset = asset;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public String getBtmImg(int index) {
        return btmImg.get(index);
    }

    public void setBtmImg(String path) {
        this.btmImg.add(path);
    }

    public ArrayList<Prey> getPrison() {
        return prison;
    }

    public void setPrison(ArrayList<Prey> prison) {
        this.prison = prison;
    }

    public int getIncreRange() {
        return increRange;
    }

    public void setIncreRange(int increRange) {
        this.increRange = increRange;
    }

    public HunterDog getDog() {
        return dog;
    }

    public void setDog(HunterDog dog) {
        this.dog = dog;
    }

    public void checkAniNum() {
        numAni = new int[4];

        for (int i = 0; i < this.prison.size(); i++) {
            /* switch (this.prison.get(i).getActionInfo().getName()) {
                case "Dear":
                    this.numAni[0]++;
                    break;
                case "Rabbit":
                    this.numAni[1]++;
                    break;
                case "Tiger":
                    this.numAni[2]++;
                    break;
                case "Lion":
                    this.numAni[3]++;
                    break;
            } */

            if (this.prison.get(i).getActionInfo().getName().equals("Deer")) {
                this.numAni[0]++;
            }

            else if (this.prison.get(i).getActionInfo().getName().equals("Rabbit")) {
                this.numAni[1]++;
            }

            else if (this.prison.get(i).getActionInfo().getName().equals("Tiger")) {
                this.numAni[2]++;
            }

            else if (this.prison.get(i).getActionInfo().getName().equals("Lion")) {
                this.numAni[3]++;
            }
        }
    }

    public Animal sellAni(String name) {
        Animal ani;

        int idx = this.checkAni(name);

        if (idx >= 0) {
            ani = this.prison.get(idx);
            this.setMoney(this.money + ani.getPrice());

            System.out.println(this.money);

            this.prison.remove(idx);
            checkAniNum();
            return ani;
        }

        return null;
    }

    public void buyItem(Item it) {
        it.setCount(it.getCount() + 1);
        this.setMoney(this.money - it.getPrice());
    }

    public int checkAni(String name) {
        System.out.println("checkAni" + name);

        for (int i = 0; i < this.prison.size(); i++) {
            System.out.println(this.prison.get(i).getActionInfo().getName());

            if (this.prison.get(i).getActionInfo().getName().equals(name)) {
                System.out.println(i);
                return i;
            }

        }
        return -1;
    }

    public void useItem(Item i) {
        if (i == Trap.getInstance())
            Trap.getInstance().used();
        else if (i == Net.getInstance())
            Net.getInstance().used();
        else if (i == Gun.getInstance())
            Gun.getInstance().used();
        else if (i == Feed.getIstance()) {
            Feed.getIstance().used();
            Feed.getIstance().healDog(dog);
        }
    }

    @Override
    public void catchAni(Animal ani) {
        if (ani instanceof Mushroom)
            ((Mushroom) ani).heal(this);

        else {
            this.prison.add((Prey) ani);
            checkAniNum();
        }
    }

    public int[] getNumAni() {
        return numAni;
    }

    public void setNumAni(int[] numAni) {
        this.numAni = numAni;
    }

}
