enum Menu {
    
    ICEAMERICANO("차가운 아메리카노", 4500),
    HOTAMERICANO("따뜻한 아메리카노", 4500),
    ICECAFELATTE("차가운 카페라뗴", 5000),
    HOTCAFELATTE("따뜻한 카페라떼", 5000);
    
    private final String label;
    private final int price;
    
    Menu(String label, int price) {
        this.label = label;
        this.price = price;
    }
    
    public int getPrice() {
        return price;
    }
}


class Solution {
    public int solution(String[] order) {
        int answer = 0;
        
        Menu menu;
        
        for (String orderMenu : order) {
            menu = makeOrder(orderMenu);
            answer += menu.getPrice();
        }
        
        
        return answer;
    }
    
    public Menu makeOrder(String orderMenu) {
        if (orderMenu.equals("iceamericano")
            || orderMenu.equals("americanoice")
            || orderMenu.equals("americano")
            || orderMenu.equals("anything")
           ) {
            return Menu.ICEAMERICANO;
        } else if (orderMenu.equals("hotamericano")
            || orderMenu.equals("americanohot")
           ) {
            return Menu.HOTAMERICANO;
        } else if (orderMenu.equals("icecafelatte")
            || orderMenu.equals("cafelatteice")
            || orderMenu.equals("cafelatte")
           ) {
            return Menu.ICECAFELATTE;
        } else if (orderMenu.equals("hotcafelatte")
            || orderMenu.equals("cafelattehot")
           ) {
            return Menu.HOTCAFELATTE;
        } else {
            return null;
        }
    }
    
}