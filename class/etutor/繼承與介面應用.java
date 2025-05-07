interface Common {
    double area();

    double perimeter();
}

abstract class Shape implements Common {
    private String shapeType;

    Shape(String type) {
        shapeType = type;
    }
}

public class 繼承與介面應用 {

}
