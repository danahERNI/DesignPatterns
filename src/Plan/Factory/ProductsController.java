package Plan.Factory;
import Plan.Factory.Matcha.Controller;
import Plan.Factory.Matcha.MatchaViewEngine;
import Plan.Factory.Matcha.ViewEngine;
import Plan.Factory.Sharp.SharpController;

import java.util.HashMap;
import java.util.Map;

public class ProductsController extends SharpController{
    public void listProducts(){

        // get product from a database
        Map<String, Object> context = new HashMap<>();
        render("products.html", context);
    }
}
