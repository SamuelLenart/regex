package sk.kosickaakademia.lenart;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import sk.kosickaakademia.lenart.Util.util;
import sk.kosickaakademia.lenart.cart.Cart;
import sk.kosickaakademia.lenart.coupon.Coupons;
import sk.kosickaakademia.lenart.coupon.Reading;
import sk.kosickaakademia.lenart.fruit.Apple;
import sk.kosickaakademia.lenart.fruit.Pear;
import sk.kosickaakademia.lenart.fruit.Peanuts;
import sk.kosickaakademia.lenart.fruit.WeightItem;
import sk.kosickaakademia.lenart.goods.CountItem;
import sk.kosickaakademia.lenart.goods.Water;
import sk.kosickaakademia.lenart.service.Delivery;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cart cart = new Cart();
        Apple item1 = new Apple(1.00,"Evelina",1.5);
        Apple item5 = new Apple(1.20,"Fuji",2.3);
        Peanuts item2 = new Peanuts(0.50,"American peanuts", 0.75);
        Water item3 = new Water(1.39,"Monster Energy Drink", 3);
        Pear item4 = new Pear(0.60, "Red pears", 5.98);
        Apple item6 = new Apple(1.00,"Evelina",0.55);
        Item delivery = new Delivery(2.99);

        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        cart.addItem(item4);
        cart.addItem(delivery);
        cart.addItem(item5);
        cart.addItem(item6);

        double totalPrice = 0;

        cart.printCart();
        System.out.println("Do you have any coupon.txt (y/n) ?");
        Scanner scanner = new Scanner(System.in);
        String coupon;
        String input = scanner.nextLine().toLowerCase();
        if(input.charAt(0)=='y'){
            System.out.println("Enter coupon.txt code: ");
            coupon = scanner.nextLine();
            List<Coupons> list = Reading.getListOfCouponsFromFile();
            totalPrice = cart.getTotalPrice();
            for(Coupons temp:list){
                if(temp.getCode().equalsIgnoreCase(coupon)){
                    System.out.println("Coupon is valid");
                    totalPrice = totalPrice*(1-(double)temp.getValue()/100);
                    list.remove(temp);
                    break;
                }

            }
            Reading.updateCoupons(list);
        }
        System.out.println("\nTotal price: "+totalPrice);
        System.out.println("( Information price in SKK: "+ util.convertEurotoSKK(cart.getTotalPrice())+ " )");
    }
    public static void makeBill(Cart cart){
        String xmlFilePath = "D:\\Java\\shop.xml";
        Date today = new Date();
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            Element root = document.createElement("bill");
            document.appendChild(root);
            Element date = document.createElement("date");
            date.appendChild(document.createTextNode(sdf.format(today)));
            root.appendChild(date);
            Element time = document.createElement("time");
            time.appendChild(document.createTextNode(timeFormat.format(today)));
            root.appendChild(time);
            Element items = document.createElement("items");
            Attr count = document.createAttribute("count");
            count.setValue(String.valueOf(cart.getCountOfItemsInCart()));
            items.setAttributeNode(count);
            root.appendChild(items);
            for (Item itemCart : cart.getClass()){
                Element item = document.createElement("item");
                Attr type = document.createAttribute("type");
                if (itemCart instanceof WeightItem)
                    type.setValue("weight");
                else if (itemCart instanceof CountItem)
                    type.setValue("count");
                else if (itemCart instanceof Delivery)
                    type.setValue("service");
                item.setAttributeNode(type);
                items.appendChild(item);
                Element name = document.createElement("name");
                name.appendChild(document.createTextNode(itemCart.getName()));
                item.appendChild(name);
                if (itemCart instanceof WeightItem){
                    Element weight = document.createElement("weight");
                    weight.appendChild(document.createTextNode(String.valueOf(((WeightItem) itemCart).getWeight())));
                    item.appendChild(weight);
                    Element pricePerKg = document.createElement("pricePerKg");
                    pricePerKg.appendChild(document.createTextNode(String.valueOf(itemCart.getPrice())));
                    item.appendChild(pricePerKg);
                }
                else if (itemCart instanceof CountItem){
                    Element countItem = document.createElement("count");
                    countItem.appendChild(document.createTextNode(String.valueOf(((CountItem) itemCart).getCount())));
                    item.appendChild(countItem);
                    Element pricePerUnit = document.createElement("pricePerUnit");
                    pricePerUnit.appendChild(document.createTextNode(String.valueOf(itemCart.getPrice())));
                    item.appendChild(pricePerUnit);
                }
                Element price = document.createElement("price");
                Attr financial = document.createAttribute("unit");
                financial.setValue("eur");
                price.setAttributeNode(financial);
                price.appendChild(document.createTextNode(String.valueOf(itemCart.getItemPrice())));
                item.appendChild(price);
            }
            Element totalPrice = document.createElement("totalPrice");
            Attr financial = document.createAttribute("unit");
            financial.setValue("eur");
            totalPrice.setAttributeNode(financial);
            totalPrice.appendChild(document.createTextNode(String.valueOf(util.formatPrice(cart.getTotalPrice()))));
            root.appendChild(totalPrice);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));
            transformer.transform(domSource, streamResult);
        }catch(ParserConfigurationException pce) {
            pce.printStackTrace();
        }catch (TransformerException tfe){
            tfe.printStackTrace();
        }
    }
}
