package Plan.Factory.Sharp;

import java.util.Map;

import Plan.Factory.Matcha.ViewEngine;

public class SharpViewEngine implements ViewEngine{

    @Override
    public String render(String viewName, Map<String, Object> context) {
        return "View rendered by Sharp";
    }

}
