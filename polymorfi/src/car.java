public abstract class car {

    private String _color;

    public car(String color) {
        _color = color;
    }

    public String getColor(){
        return _color;
    }

    public abstract void CarMaxSpeed();

    public abstract void CarEngine();

}
