package sk.kosickaakademia.lenart.coupon;

public class Coupons {
    private String code;
    private int value;

    public Coupons(String code, int value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public int getValue() {
        return value;
    }
}
