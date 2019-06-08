package model.active;

import model.item.Useable;

public class HunterDog extends Animal implements Useable, Catchable {
	public static HunterDog instance=null;
	private int level;
    private int hp;
    private int record;
    private boolean flag;
    final int levelUpPoint;

    private HunterDog(){
    	this.level=0;
    	this.hp=100;
    	this.record=0;
    	this.levelUpPoint=10;
    	this.setPrice(1000000);
    	this.actionInfo.setName("��ɰ�");
    	this.actionInfo.setDelay(35);
    	this.actionInfo.setBtnImg(null);//
    }

    public static HunterDog getInstance(){
    	if(instance==null)
            instance=new HunterDog();
          return instance;
    }
    
    public int getLevel(){
        return this.level;
    }

    public void setLevel(int level){
    	this.level=level;
    }

    public int getHp(){
        return this.hp;
    }

    public void setHp(int hp){
    	if(hp>100)
    		this.hp=100;
    	else if(hp<0)
    		this.hp=0;
    	else
    		this.hp=hp;
    }

    public int getRecord(){
        return this.record;
    }

    public void setRecord(int record){
    	this.record=record;
    }

    public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public void catchAni(Animal ani) {
    }
    
    public void catchAni(Animal ani, Hunter hunter) {
    	this.setRecord(this.record+1);
    	if(this.record>=this.levelUpPoint) {
    		this.setLevel(this.level+1);
    		this.setRecord(0);
    		if(level>=10)
    			this.setHp(100);
    	}
    	this.used();
    	hunter.catchAni(ani);
    	this.setHp(this.hp-5);//forest1�� �� -10, forest2�� �� -15
    }
    
    public void used() {
    	if(this.hp>0)
    		this.flag=true;
    	else
    		this.flag=false;
    }
}