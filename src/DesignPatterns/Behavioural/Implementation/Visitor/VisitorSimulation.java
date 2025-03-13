package DesignPatterns.Behavioural.Implementation.Visitor;

public class VisitorSimulation {
    public static void main(String[] args) {
        var document = new HtmlDocument();   
        document.add(new HeadingNode());
        document.add(new AnchorNode());
        document.execute(new PlaintTextOperation());
    }
}
