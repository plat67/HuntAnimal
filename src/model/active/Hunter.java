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
    private ArrayList<Animal> prison;
    private HunterDog dog = HunterDog.getInstance();

    private Hunter() {
        this.money = 0;
        this.asset = 0;
        this.increRange = 0;
        this.prison = new ArrayList<Animal>();
        this.getActionInfo().setName(null);
        this.getActionInfo().setDelay(40);
        this.getActionInfo().setBtnImg(null);//
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

    public ArrayList<Animal> getPrison() {
        return prison;
    }

    public void setPrison(ArrayList<Animal> prison) {
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

    public void sellAni(Animal ani) {
        this.prison.remove(ani);
        this.setMoney(this.money + ani.getPrice());
    }

    public void buyItem(Item it) {
        it.setCount(it.getCount() - 1);
        this.setMoney(this.money - it.getPrice());
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

    }

    public void catchAni(Animal ani, Forest forest) {
        if (ani instanceof Mushroom)
            ((Mushroom)ani).heal(this);

        else
            this.prison.add(ani);
    }
}
