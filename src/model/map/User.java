package model.map;

public class User {
    private String id;
    private String pw;
    private int money;
    private int[] animal;
    private int hunterDog;
    private int[] items;
    private int asset;

    public User() {
    }

    public User(String id, String pw, int money, int[] animal, int hunterDog, int[] items, int asset) {
        this.id = id;
        this.pw = pw;
        this.money = money;
        this.animal = animal;
        this.hunterDog = hunterDog;
        this.items = items;
        this.asset = asset;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int[] getAnimal() {
        return animal;
    }

    public void setAnimal(int[] animal) {
        this.animal = animal;
    }

    public int getHunterDog() {
        return hunterDog;
    }

    public void setHunterDog(int hunterDog) {
        this.hunterDog = hunterDog;
    }

    public int[] getItems() {
        return items;
    }

    public void setItems(int[] items) {
        this.items = items;
    }

    public int getAsset() {
        return asset;
    }

    public void setAsset(int asset) {
        this.asset = asset;
    }
}
