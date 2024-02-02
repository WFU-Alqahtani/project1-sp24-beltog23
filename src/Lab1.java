import java.util.ArrayList; //import ArrayList
import java.util.InputMismatchException;

public class Lab1 {
    public static Item[] setupStore() { //method makes arbitrary array of items that compose the store's selection
       Item[] store = new Item[6];
       store[0] = new Item("Bread", 2.99);
       store[1] = new Item("Cheese", 4.99);
       store[2] = new Item("Beef", 6.99);
       store[3] = new Item("Cola", 2.99);
       store[4] = new Item("Candy", 1.99);
       store[5] = new Item("Mixed Vegetables", 3.99);
        return store;
    }
    public static ArrayList<Item> createCart(String [] cmdLine) { //input corresponds to command line input / will be used to read command line and add corresponding item
        ArrayList<Item> cart = new ArrayList<Item>(); //creates arraylist
        Item[] options = setupStore(); //creates selection of items within method. This works as the store selection stays constant
               for (int i = 0; i < cmdLine.length; i++) {
                   try {
                       int target = Integer.parseInt(cmdLine[i]);
                       cart.add(options[target]);
               }   catch (NumberFormatException e) {
                       System.out.println(cmdLine[i]+" is not a valid integer");
                   } catch (IndexOutOfBoundsException e) {
                       System.out.println("Index: "+cmdLine[i]+" exceeds the limits of the store");
                   }
               }
        return cart;
    }
    public static void PrintReceiptInOrder(ArrayList<Item> cart) {
        ArrayList<Item> sortedCart = new ArrayList<Item>();
        int cycles = cart.size();
            for (int i=0; i<cycles; i++) {
                int ind = 0;
                for (int j = 0; j < cart.size(); j++) {
                    if (cart.get(j).getItemPrice() > cart.get(ind).getItemPrice()) {
                        ind = j;
                    }
                }

                sortedCart.add(cart.get(ind));
                cart.remove(ind);
            }

            for (int z=0;z< cart.size();z++) {
                System.out.println(cart.get(z).getItemName());
            }
            for (int y=0; y< sortedCart.size();y++){
                cart.add(sortedCart.get(y));
            }
            double subtotal=0;
            for (int n=0;n<cart.size(); n++) {
                System.out.println(cart.get(n).getItemName()+" $"+cart.get(n).getItemPrice());
                subtotal+=cart.get(n).getItemPrice();
            }
            System.out.println("Subtotal: $"+subtotal);
            double salesTax = 0.05*subtotal;
            System.out.println("Sales tax: $"+salesTax);
            double total = salesTax+subtotal;
            System.out.println("Total: $"+total);
    }
    public static void emptyCartReverseOrder(ArrayList<Item> cart) {
        System.out.println("Removing items from cart in reverse order...");
        while (cart.size()>0) {
            System.out.println("Removing item: "+cart.get(cart.size()-1).getItemName());
            cart.remove(cart.size()-1);
        }
        System.out.println("Cart has been emptied");
    }
    public static void main(String[] args) {
        String[] data = args;
        ArrayList<Item> rCart = new ArrayList<Item>();
        rCart=createCart(data);
        PrintReceiptInOrder(rCart);
        //System.out.println(rCart.get(0).getItemName());
        emptyCartReverseOrder(rCart);
    }
}