
package model;

import java.util.HashMap; 
import java.util.Map;
import model.Item;
public class Cart {
    private HashMap<Integer, Item> cartItems;

    public  Cart(){
        cartItems = new HashMap<>();
    }
    public Cart(HashMap<Integer,Item> cartItems){
        this.cartItems = cartItems;
    }
    public HashMap<Integer,Item> getCartItems(){
        return cartItems;
    }
    public void setCartItems(HashMap<Integer,Item> cartItems){
        this.cartItems = cartItems;
    }
    
    public void plusToCart(int key, Item item) {        
        boolean check = cartItems.containsKey(key);
        if(check){
            int quanlity_old = item.getQuantity();
            item.setQuantity(quanlity_old+1);
            cartItems.put(item.getProduct().getProductID(), item);
        }
        else{
            cartItems.put(item.getProduct().getProductID(), item);
        }
                
    }   

     public void subToCart(int key, Item item) {         
         boolean check = cartItems.containsKey(key);         
         if (check) {             
             int quantity_old = item.getQuantity();             
             if (quantity_old <= 1) {                 
                 cartItems.remove(key);             
             } 
             else {                 
                 item.setQuantity(quantity_old - 1);                 
                 cartItems.put(key, item);             
             }         
         }     
     } 
     
     // xóa sản phảm giỏ hàng
     public void removeToCart(int product) {         
         boolean bln = cartItems.containsKey(product);         
         if (bln) {             
             cartItems.remove(product);         
         } 
     }
     
     // phương thước tính đếm số sản phẩm có trong giỏ hàng
     public int countItem(){
         int count = 0 ;
         count = cartItems.size();
         return count ;
     }
     
     //Phương thức tính tổng số tiền
     public int total() { 
        int count = 0 ;             
        for(Map.Entry<Integer, Item> list : cartItems.entrySet()) {             
             count += list.getValue().getProduct().getProductPrice() * list.getValue().getQuantity();
        }         
        return count; 
     } 
    
    
   
}
