package Plan.Mediator;

public class ArticlesDialogBox extends DialogBox{
    private ListBox articlesListBox = new ListBox(this);
    private Textbox titleTextbox = new Textbox(this);
    private Button saveButton = new Button(this);
    
    public void simulateUserInteraction(){
        articlesListBox.setSelection("Article 1");
        titleTextbox.setContent("");
        titleTextbox.setContent("Article 2");
        System.out.println("Textbox: " + titleTextbox.getContent());
        System.out.println("Button: " + saveButton.isEnabled());
    }

    @Override
    public void changed(UIControl control) {
        if(control == articlesListBox){
            articlesSelected();
        }else if(control == titleTextbox){
            titleChanged();
        }
    }
    private void articlesSelected(){
        titleTextbox.setContent(articlesListBox.getSelection());
        saveButton.setEnabled(true);
    }
    private void titleChanged(){
        var content = titleTextbox.getContent();
        var isEmpty = (content == null || content.isEmpty());
        saveButton .setEnabled(!isEmpty);
    }

}
