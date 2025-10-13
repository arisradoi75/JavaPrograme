package Lab3_ex1;

public class Parabola {
    public int a;
    public int b;
    public int c;

    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] calcVirfParabola() {
        double Xa;
        double Yb;
        double[] varfParabola = new double[2];

        Xa = -(b/(2*a));
        Yb =  (-(b*b)+4*a*c)/(4*a);
        varfParabola[0] = Xa;
        varfParabola[1] = Yb;

        return varfParabola;
    }

    @Override
    public String toString() {
        return "f(x) = " + a + "x² + " + b + "x" + " + " + c;
    }
    public double[] mijlocParabola(Parabola parabola){
        double[] varfP1 = this.calcVirfParabola();
        double[] varfP2 =  parabola.calcVirfParabola();

        double mijlocX = (varfP1[0] + varfP2[0])/2;
        double mijlocY = (varfP1[1] + varfP2[1])/2;

        return new double[] {mijlocY , mijlocY};
    }
    public double lungimeParabola(Parabola p){
        double[] varfP1 = this.calcVirfParabola();
        double[] varfP2 =  p.calcVirfParabola();
        double rez = (Math.pow(varfP1[0] - varfP2[0], 2)+Math.pow(varfP1[1] - varfP2[1], 2));
        double rad = Math.sqrt(rez);
        return rad;
    }
    public static double lungimeParabola(Parabola p1, Parabola p2){
        double[] varfP1 = p1.calcVirfParabola();
        double[] varfP2 =  p2.calcVirfParabola();
        return Math.hypot(varfP1[0] - varfP2[0], varfP1[1] - varfP2[1]);
    }

}
