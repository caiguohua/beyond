package designpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 策略模式
 */

interface PaymentStrategy{
    boolean pay(float amount);
}

class  CreditCardStrategy implements PaymentStrategy{  //信用卡支付

    private String cardNumber; //卡号
    private String cvv;
    private String name;
    private String dateOfExpiry; //过期日期

    public CreditCardStrategy(String cardNumber, String cvv, String name, String dateOfExpiry) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.name = name;
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public boolean pay(float amount) {
        System.out.println(amount + " paid with credit card");
        return true;
    }
}

class WechatStrategy implements PaymentStrategy{  //微信支付

    private String qrCode; //二维码

    public WechatStrategy(String qrCode) {
        this.qrCode = qrCode;
    }

    @Override
    public boolean pay(float amount) {
        System.out.println(amount + " paid with WeChat");
        return true;
    }
}

class Item{
    private String upcCode;
    private float price;

    public Item(String upcCode, float price) {
        this.upcCode = upcCode;
        this.price = price;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public float getPrice() {
        return price;
    }
}

class Cart{
    List<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void removItem(Item item){
        this.items.remove(item);
    }

    public void pay(PaymentStrategy paymentStrategy){
        if(this.items.size() > 0){
            float total = calculateTotal();
            boolean isSuccess = paymentStrategy.pay(total);
            if(isSuccess){
                this.items.clear();
            }else{
                System.out.println("payment failed");
            }
        }else{
            System.out.println("Please select your favorite items");
        }

    }

    private float calculateTotal() {
        float totalPrice = 0f;
        for (Item item : items)
        {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        Cart cart = new Cart();

        Item apple = new Item("iphone xs Max",100);
        Item banana = new Item("Banana",23.6f);
        Item noddle = new Item("InstantNoddle",120f);

        cart.addItem(apple);
        cart.addItem(banana);
        cart.addItem(noddle);

        cart.pay(new WechatStrategy("666"));
        cart.pay(new CreditCardStrategy("666","011","san","2018-12-31"));

    }
}
