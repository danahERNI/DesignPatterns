package Plan.Flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flyweight {
    public static void main(String[] args) {
        var service = new PointService(new PointIconFactory());

        for(var point : service.getPoints()){
            point.draw();
        }
    }
}

class Point{
    private int x;
    private int y;
    private PointIcon icon;


    public Point(int x, int y, PointIcon icon) {
        this.x = x;
        this.y = y;
        this.icon = icon;
    }
    public void draw(){
        System.out.printf("%s at (%d, %d)", icon.getType(), x, y);
    }
}

enum PointType{
    HOSPITAL,
    CAFE,
    RESTAURANT
}

class PointService{
    private PointIconFactory iconFactory;

    public PointService(PointIconFactory iconFactory) {
        this.iconFactory = iconFactory;
    }

    public List<Point> getPoints(){
        List<Point> points = new ArrayList<>();

        var point = new Point(1,2,iconFactory.getPointIcon(PointType.CAFE));
        points.add(point);

        return points;
    }
}

class PointIcon{

    private final PointType type;
    private final byte[] icon;

    public PointIcon(PointType type, byte[] icon) {
        this.type = type;
        this.icon = icon;
    }

    public PointType getType() {
        return type;
    }


    public byte[] getIcon() {
        return icon;
    }
}

class PointIconFactory{
    private Map<PointType, PointIcon> icons = new HashMap<>();

    public PointIcon getPointIcon(PointType type){
        if (!icons.containsKey(type)){
            byte[] dummyIcon = new byte[]{1, 2, 3};
            var icon = new PointIcon(type, dummyIcon);
            icons.put(type, icon);
        }
        return icons.get(type);
    }
}