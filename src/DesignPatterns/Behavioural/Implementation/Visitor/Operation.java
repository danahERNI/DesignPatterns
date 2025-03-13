package DesignPatterns.Behavioural.Implementation.Visitor;

public interface Operation {
    void apply(HeadingNode heading);
    void apply(AnchorNode anchor); 

}
