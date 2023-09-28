public class Camera {

    private static double x = 0, y = 0;
    private static int w, h;

    Player b = new Player();

    public static double getX() {
        return x;
    }

    public static double getY() {
        return y;
    }

    public static int getW() {
        return w;
    }

    public static void setW(int w) {
        Camera.w = w;
    }

    public static int getH() {
        return h;
    }

    public static void setH(int h) {
        Camera.h = h;
    }

    public static int getScreenY(double yW) {
        return (int)(yW - y);
    }

    public static int getScreenX(double xW) {
        return (int)(xW - x);
    }

    public static void moveright (double dx, double dy) {
        setPosition(x + dx, y);
    }

    public static void moveleft (double dx, double dy) {
        setPosition(x - dx, y);
    }

    public static void moveup (double dx, double dy) {
        setPosition(x, y - dy);
    }

    public static void movedown (double dx, double dy) {
        setPosition(x, y + dy);
    }

    public static void setPosition(double x, double y) {
        Camera.x = x;
        Camera.y = y;

        if(Camera.x < 0) {
            Camera.x = 0;
        }
        if(Camera.y < 0) {
            Camera.y = 0;
        }
        if(Camera.x >= 1568) {
            Camera.x = 1568;
        }
        if(Camera.y >= 1568) {
            Camera.y = 1568;
        }
        System.out.println("x:  " + Camera.getX() + "  y:   " + Camera.y);


    }
}