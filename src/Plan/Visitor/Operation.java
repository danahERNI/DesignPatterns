package Plan.Visitor;

public interface Operation {
    void apply(HeadingNode heading);
    void apply(AnchorNode anchor); 

}
