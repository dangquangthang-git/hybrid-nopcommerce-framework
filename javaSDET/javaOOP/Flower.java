package javaOOP;

public class Flower extends Tree {
    @Override
    void setTreeName() {

    }

    @Override
    void cutTree() {
        super.cutTree();
    }

    public static void main(String[] args) {
        Flower flower=new Flower();
        flower.cutTree();
    }
}
