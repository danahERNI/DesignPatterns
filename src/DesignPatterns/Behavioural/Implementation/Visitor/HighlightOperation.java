package DesignPatterns.Behavioural.Implementation.Visitor;

public class HighlightOperation implements Operation{

    @Override
    public void apply(HeadingNode heading) {
        System.out.println("Hightlight-heading");
    }

    @Override
    public void apply(AnchorNode anchor) {
        System.out.println("Hightlight-anchor");
    }

}
