package Plan.Factory.Sharp;

import Plan.Factory.Matcha.Controller;
import Plan.Factory.Matcha.ViewEngine;

public class SharpController extends Controller{

    @Override
    protected ViewEngine createViewEngine(){
        return new SharpViewEngine();
    }
}
