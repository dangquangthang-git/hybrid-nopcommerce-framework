package phuongHoaXuan;

import zmq.socket.pubsub.Pub;

public class DinhBoLinh {
    //private chi dung duoc trong class chua no
    //Variable/Property
    private String espresso;
    //Getter/Setter
    //Method/Function

    private String getEspresso() {
        return espresso;
    }

    //default (cac class trong cung package moi truy cap duoc)
    String cappuchino;

    String getCappuchino() {
        return cappuchino;
    }

    //protected (chi ke thua moi dung duoc)
    protected String cherry;

    protected String getCherry() {
        return cherry;
    }

    //public (dung duoc het)
    public String catimor;

    public String getCatimor() {
        return catimor;
    }
    public static String monokai="b";
    public static void main(String[] args) {
        DinhBoLinh dinhbolinh = new DinhBoLinh();
        System.out.println(dinhbolinh.getEspresso());
        dinhbolinh.getCherry();
        dinhbolinh.catimor = "catimor";
    }

}
