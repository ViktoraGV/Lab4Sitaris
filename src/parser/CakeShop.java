package parser;

import java.util.ArrayList;

public class CakeShop {
    public static int cakes_amount = 0;
    private ArrayList<Cake> cakes;

    CakeShop(){
        cakes = new ArrayList<>();
    }

    CakeShop(ArrayList<Cake> cakes){
        this.cakes = cakes;
        cakes_amount = this.cakes.size();
    }
    public void addСake(Cake cake){
        cakes.add(cake);
        cakes_amount++;
    }
    public void showСakesData(){
        for (int i = 0; i < cakes_amount; i++) {
            System.out.println("\t\t--> Сake № " + (i + 1) + " <--");
            System.out.println("Сake name: " + cakes.get(i).getName());
            System.out.println("Сake confectioner: " + cakes.get(i).getConfectioner());
            System.out.println("Сake price: " + cakes.get(i).getPrice());
            System.out.println("Biscuits amount: " + cakes.get(i).getBiscuits());
        }
    }
    public int countTotalCost(){
        int total_cost = 0;
        for (Cake b: cakes) {
            total_cost += b.getPrice();
        }
        return total_cost;
    }
}
