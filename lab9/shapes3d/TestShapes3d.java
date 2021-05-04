package shapes3d;

public class TestShapes3d {
    public static void main(String[] args){
        Cylinder cy= new Cylinder(5,10);
        System.out.println(cy);
        System.out.println("Cylinder Area = " + cy.area());
        System.out.println("Cylinder Volume = " + cy.volume());

        Cube cb = new Cube(4);
        System.out.println(cb);
        System.out.println("Cube Volume = " + cb.area());
        System.out.println("Cube Area = " + cb.volume());
    }

}
