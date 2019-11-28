 public class main {

    public static void main(String[] args) {

        car[] cars = { new honda(""), new audi(""), new benz("") };

        for (car bilen: cars) {
            bilen.CarEngine();
            bilen.CarMaxSpeed();
            bilen.getColor();
        }
    }
}
