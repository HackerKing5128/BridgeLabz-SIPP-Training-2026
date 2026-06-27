// CouponValidator interface
interface CouponValidator {
    boolean validateCoupon(String code);

    static boolean isLengthValid(String code) {
        return code != null && code.length() >= 5;
    }
}

// ShoppingCart class implementing CouponValidator interface
public class ShoppingCart implements CouponValidator {
    public boolean validateCoupon(String code) {
        if (!CouponValidator.isLengthValid(code)) {
            return false;
        }

        String coupon = code.toUpperCase();
        return coupon.startsWith("SAVE") || coupon.startsWith("OFF") || coupon.startsWith("DEAL");
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        String[] couponCodes = {"SAVE10", "OFF20", "HELLO", "DEAL50", "A1"};

        for (int i = 0; i < couponCodes.length; i++) {
            String code = couponCodes[i];
            if (cart.validateCoupon(code)) {
                System.out.println(code + " is valid");
            } else {
                System.out.println(code + " is invalid");
            }
        }
    }
}
