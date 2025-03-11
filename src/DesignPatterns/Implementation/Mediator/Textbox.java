package DesignPatterns.Implementation.Mediator;

public class Textbox extends UIControl{
    public Textbox(DialogBox owner) {
        super(owner);
    }
    
        private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        owner.changed(this);
    }
}
