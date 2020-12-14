package parser;

public class Cake {
    private String name;
    private String confectioner;
    private int biscuits;
    private int price;
    Cake(){ }
    Cake(String name, String confectioner, int biscuits, int price){
        this.name = name;
        this.confectioner = confectioner;
        this.biscuits = biscuits;
        this.price = price;
    }
    public void setName(String name){

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setBiscuits(int biscuits) {

        this.biscuits = biscuits;
    }

    public int getBiscuits() {

        return biscuits;
    }

    public void setConfectioner(String confectioner) {

        this.confectioner = confectioner;
    }

    public String getConfectioner() {

        return confectioner;
    }

    public void setPrice(int price) {

        this.price = price;
    }

    public int getPrice() {

        return price;
    }

    public void info(){
        System.out.println("--------");
        System.out.println("Confectioner: " + confectioner);
        System.out.println("Name: " + name);
        System.out.println("Biscuits: " + biscuits);
        System.out.println("Price: " + price);
    }
}
