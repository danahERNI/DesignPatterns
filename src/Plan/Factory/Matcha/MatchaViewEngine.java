package Plan.Factory.Matcha;

import java.util.Map;

public class MatchaViewEngine implements ViewEngine {
    @Override
    public String render(String viewName, Map<String,Object> context){
        return "View rendered by Matcha";
    }
}
