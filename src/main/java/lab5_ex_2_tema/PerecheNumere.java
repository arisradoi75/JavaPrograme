package lab5_ex_2_tema;

public class PerecheNumere {
    private int a;
    private int b;

    public PerecheNumere(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public PerecheNumere(){}

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public double cmmmc(int a , int b){
        int produs = a * b;
        while(b != 0){
            int r =  a % b;
            a = b;
            b = r;
        }
        int cmmdc = a;
        return produs/cmmdc;

    }

    public boolean suntConsecutiveFibonacci() {
        int x = 0, y = 1;

        while (y <= Math.max(a, b)) {
            if ((x == a && y == b) || (x == b && y == a)) {
                return true;
            }

            int next = x + y;
            x = y;
            y = next;
        }

        return false;
    }

    @Override
    public String toString() {
        return "PerecheNumere{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

}
