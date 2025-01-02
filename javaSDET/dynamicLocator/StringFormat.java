package dynamicLocator;

public class StringFormat {
    public static void main(String[] args) {
        String dynamic_Var = "dynamicVar %s";
        String dynamic_Country = "dynamicCountry A %s " + "dynamicCountry B %s";
        clickToDeleteIcon(dynamic_Var, "222");
        System.out.println(String.format("Automation test %s", "AI"));
        System.out.println(String.format("Automation test %s", "BI"));
        System.out.println(String.format("Automation test %s", "CI"));
        System.out.println(String.format(dynamic_Country, "CA", "CB"));

        String textString = "Vị trí 1 là %s, vị trí 2 là %s, vị trí 3 là %s, vị trí 4 là %s, vị trí 5 là %s";
        clickToDeleteIcon(textString, "1", "2", "3", "4", "5");
        clickToDeleteIcon(dynamic_Country,"con vịt","con gà");
    }

//    public static void clickToDeleteIcon(String textFormat, String text) {
//        System.out.println("click to delete: " + String.format(textFormat, text));
//    }
//
//    public static void clickToDeleteIcon(String textFormat, String country, String text, String gender) {
//        System.out.println("click to delete: " + String.format(textFormat, country, text));
//    }
//
//    public static void clickToDeleteIcon(String textFormat, String country, String text, String gender, String name) {
//        System.out.println("click to delete: " + String.format(textFormat, country, text));
//    }
//
//    public static void clickToDeleteIcon(String textFormat, String country, String text, String gender, String name, String age) {
//        System.out.println("click to delete: " + String.format(textFormat, country, text));
//    }

    public static void clickToDeleteIcon(String textFormat, String... resParameter) {
        System.out.println("click to delete: " + String.format(textFormat, (Object[]) resParameter));
    }

    public static void clickToDelete(String text, String a) {
        System.out.println("Delete: " + String.format(text, a));
    }
}
