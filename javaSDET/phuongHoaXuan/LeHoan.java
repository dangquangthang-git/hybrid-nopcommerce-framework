package phuongHoaXuan;

public class LeHoan extends DinhBoLinh {
    public static void main(String[] args) {
        DinhBoLinh dinhBoLinh = new DinhBoLinh();
        dinhBoLinh.cappuchino = "Le Hoan";
        System.out.println(dinhBoLinh.getCappuchino());
        dinhBoLinh.getCherry();
        System.out.println(dinhBoLinh.getCatimor());

    }
}
