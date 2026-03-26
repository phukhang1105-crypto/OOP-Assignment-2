public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distance(Coordinates p) {
        int dx = this.x - p.x;
        int dy = this.y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }


    public void scale(int factor, boolean sign) {
        if (sign) {
            this.x *= factor;
            this.y *= factor;
        } else {
            this.x /= factor;
            this.y /= factor;
        }
    }


    public String display() {
        String msg = "X = " + x + ",Y = " + y;
        if (x< 0 || y < 0){
            msg +="\nNote: Negative X or Y, Coordinates are out of zone.\n";
        }
        return msg;
    }

    /*public static void main(String[] args) {
        Coordinates c1 = new Coordinates(2,3);
        Coordinates c2 = new Coordinates(4,5);
        System.out.println(c1.distance(c2));
        System.out.println(c1.display());
    }*/
}