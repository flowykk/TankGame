public class Main {

    public static void main(String[] args) {

        ImageHelper.loadTexture("sprite.png");
        ImageHelper.cropImage(0, 2, Map.GROUND);
        ImageHelper.cropImage(0, 3, Map.WATER);

        ImageHelper.cropImage(1, 1, Map.BRICK);
        ImageHelper.cropImage(1, 0, Map.WALL);

        ImageHelper.cropImage(1, 1, Map.BRICK);
        ImageHelper.cropImage(1, 0, Map.WALL);

        ImageHelper.cropImage(1, 2, Map.PURPLE);
        ImageHelper.cropImage(1, 3, Map.LIGHTPURPLE);
        ImageHelper.cropImage(1, 4, Map.HIGHWALL);
        ImageHelper.cropImage(0, 1, Map.ORANGEGROUND);
        ImageHelper.cropImage(0, 0, Map.GRAYGROUND);
        ImageHelper.cropImage(4, 3, Map.SUPERBULLET);
        ImageHelper.cropImage(4, 2, Map.MANYBULLETS);
        ImageHelper.cropImage(1, 6, Map.BROKEN_BRICK);

        ImageHelper.cropImage(7, 0, Map.TABLO1);
        ImageHelper.cropImage(7, 1, Map.TABLO2);
        ImageHelper.cropImage(7, 2, Map.TABLO3);
        ImageHelper.cropImage(7, 3, Map.TABLO4);
        ImageHelper.cropImage(6, 3, Map.TREE);

        ImageHelper.cropImage(1, 7, Map.BROKEN_TANK);

        /*  public static final int PURPLE      = 5;
            public static final int LIGHTPURPLE = 6;
            public static final int HIGHWALL    = 7;
            public static final int ORANGEGROUND= 8;
            public static final int GRAYGROUND  = 9;
            public static final int SUPERBULLET  = 10;
            public static final int MANYBULLETS  = 11;*/

        Map.generate(100, 100);

        new Window();

    }
}
