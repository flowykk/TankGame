import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class Map {

    public static int [][] matrix;
    public static int [][] matrix_layer2;
    private static Random r;

    public static final int GROUND      = 0;
    public static final int BRICK       = 1;
    public static final int WALL        = 2;
    public static final int WATER       = 3;
    public static final int EMPTY       = 4;
    public static final int PURPLE      = 5;
    public static final int LIGHTPURPLE = 6;
    public static final int HIGHWALL    = 7;
    public static final int ORANGEGROUND= 8;
    public static final int GRAYGROUND  = 9;
    public static final int SUPERBULLET  = 10;
    public static final int MANYBULLETS  = 11;
    public static final int BROKEN_BRICK  = 12;
    public static final int TABLO1= 13;
    public static final int TABLO2 = 14;
    public static final int TABLO3 = 15;
    public static final int TABLO4 = 16;
    public static final int TREE = 17;
    public static final int BROKEN_TANK = 18;
    public static final int BLOCK_SIZE  = 32;

    private Map () {

    }

    static {
        r = new Random();
    }

    public static void generate(int r, int c) {
        matrix = new int[r][c];
        matrix_layer2 = new int[r][c];
        Random rand = new Random();
       // int vers = 6;
        int vers = rand.nextInt(8);
        int st1 = rand.nextInt(r);
        int st2 = rand.nextInt(r);
        int st3 = rand.nextInt(r);
        int st4 = rand.nextInt(r);
        int st5 = rand.nextInt(r);
        int st6 = rand.nextInt(r);
        int st7 = rand.nextInt(r);
        int cc = rand.nextInt(6);
        int st8 = rand.nextInt(6);
        int st9 = rand.nextInt(6);
        int strok = rand.nextInt(2);

        for(int i = 0; i < matrix.length; i++) {
            matrix[rand.nextInt(r)][rand.nextInt(c)] = WATER;
        }

        for(int j = 1; j < matrix.length-1; j++) {
            for(int k = 1; k < matrix[j].length -1 ; k+=2) {
                if(matrix[j][k] == WATER) {
                    matrix[j][k + 1] = WATER;
                    matrix[j - 1][k + 1] = WATER;
                    matrix[j - 1][k - 1] = WATER;
                    matrix[j + 1][k + 1] = WATER;
                }
            }
        }
        if(vers == 0) {
            for(int i = 0; i < matrix.length-1; i++) {
                matrix[i][0] = WALL;
                int cc1 = cc+2;
                matrix[0][i] = WALL;
                matrix[1][cc] = BRICK;
                matrix[1][matrix.length-(cc + 8)] = BRICK;
                matrix[2][cc] = BRICK;
                matrix[2][matrix.length-(cc + 8)] = BRICK;
                matrix[3][cc+1] = BRICK;
                matrix[3][matrix.length-(cc + 9)] = BRICK;

                while(cc1 < matrix.length-(cc + 9)) {
                    matrix[4][cc1] = BRICK;
                    cc1++;
                }
                // matrix[rand.nextInt(r)][rand.nextInt(c)] = WALL;
                matrix[rand.nextInt(r)][rand.nextInt(c)] = BRICK;
            }
        } else if(vers == 1) {
            int cc2 = cc+2;
            int cc3 = cc+3;
            int cc4 = cc+2;
            Arrays.fill(matrix[0], WALL);
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = WALL;
                matrix[i][matrix.length-1] = WALL;
                matrix[cc+1][matrix.length-2] = WALL;
                matrix[matrix.length-(cc + 6)][matrix.length-2] = WALL;
                matrix[cc+2][matrix.length-3] = BRICK;
                matrix[matrix.length-(cc + 7)][matrix.length-3] = BRICK;
                matrix[cc+2][matrix.length-4] = BRICK;
                matrix[matrix.length-(cc + 7)][matrix.length-4] = BRICK;
                while(cc3 < matrix.length-(cc + 7)) {
                    matrix[cc3][matrix.length-5] = WALL;
                    cc3++;
                }
                matrix[cc][1] = BRICK;
                matrix[matrix.length-(cc + 5)][1] = BRICK;
                matrix[cc][2] = BRICK;
                matrix[matrix.length-(cc + 5)][2] = BRICK;
                matrix[cc+1][3] = WALL;
                matrix[matrix.length-(cc + 6)][3] = WALL;
                while(cc4 < matrix.length-(cc + 6)) {
                    matrix[cc4][4] = WALL;
                    cc4++;
                }
                matrix[matrix.length-1][i] = WALL;
                matrix[matrix.length-2][cc+1] = WALL;
                matrix[matrix.length-2][matrix.length-(cc + 9)] = WALL;
                while(cc2 < matrix.length-(cc + 9)) {
                    matrix[matrix.length-3][cc2 ] = WALL;
                    cc2++;
                }
            }
        }else if(vers == 2) {
            for (int col = 0; col < matrix.length; col++ ) {
                int cc1 = cc+2;
                int cc2 = cc+2;
                matrix[0][col] = WALL;
                matrix[1][cc] = WALL;
                matrix[1][matrix.length-(cc + 8)] = WALL;
                matrix[2][cc+1] = WALL;
                matrix[2][matrix.length-(cc + 9)] = WALL;
                while(cc1 < matrix.length-(cc + 9)) {
                    matrix[3][cc1] = WALL;
                    cc1++;
                }
                matrix[matrix.length-1 - st1][rand.nextInt(c)] = BRICK;
                matrix[matrix.length-1 - st1][rand.nextInt(c)] = WALL;
                //  matrix[matrix.length-1 - st2][rand.nextInt(c)] = WALL;
                //   matrix[matrix.length-1 - st2][rand.nextInt(c)] = BRICK;
                matrix[matrix.length-1][col] = WALL;
                matrix[matrix.length-1][cc] = WALL;
                matrix[matrix.length-1][matrix.length-(cc + 8)] = WALL;
                matrix[matrix.length-2][cc+1] = WALL;
                matrix[matrix.length-2][matrix.length-(cc + 9)] = WALL;
                while(cc2 < matrix.length-(cc + 9)) {
                    matrix[matrix.length-3][cc2 ] = WALL;
                    cc2++;
                }
            }
        }else if(vers == 3) {
            int cc2 = cc+2;
            int cc1 = cc+6;
            for (int col = 0; col < matrix.length; col++ ) {
                matrix[0][col] = WALL;
                matrix[matrix.length - 1][col] = WALL;

                // matrix[0][col] = WALL;
                matrix[1][cc+4] = BRICK;
                matrix[1][matrix.length-(cc + 12)] = BRICK;
                matrix[2][cc+4] = BRICK;
                matrix[2][matrix.length-(cc + 12)] = BRICK;
                matrix[3][cc+5] = BRICK;
                matrix[3][matrix.length-(cc + 13)] = BRICK;

                matrix[matrix.length-2][cc+1] = WALL;
                matrix[matrix.length-2][matrix.length-(cc + 9)] = WALL;
                while(cc2 < matrix.length-(cc + 9)) {
                    matrix[matrix.length-3][cc2 ] = WALL;
                    cc2++;
                }

                while(cc1 < matrix.length-(cc + 13)) {
                    matrix[4][cc1] = BRICK;
                    cc1++;
                }
                if (strok == 0) {
                    matrix[col][col] = BRICK;
                } else {
                    matrix[matrix.length - col - 1][col] = BRICK;
                }
            }
        }else if(vers == 4) {
            int cc5 = 8;

            for (int col = 0; col < matrix.length; col++ ) {
                matrix[matrix.length - 1][col] = WALL;
                matrix[col][0] = WALL;
                int cc1 = cc+4;
                matrix[0][col] = WALL;
                matrix[1][cc+3] = WALL;
                matrix[2][cc+3] = WALL;
                matrix[1][matrix.length-(cc + 11)] = WALL;
                matrix[2][matrix.length-(cc + 11)] = WALL;
                matrix[3][cc+4] = WALL;
                matrix[3][matrix.length-(cc + 12)] = WALL;
                matrix[4][cc+4] = WALL;
                matrix[4][matrix.length-(cc + 12)] = WALL;
                while(cc1 < matrix.length-(cc + 13)) {
                    matrix[5][cc1+1] = WALL;
                    cc1++;
                }

                while(cc5 < matrix.length-8) {
                    if(strok == 1) {
                        matrix[matrix.length - cc5 -3 + st8][cc5 + st9-3] = BRICK;
                    } else {
                        matrix[cc5 -3 + st8][cc5 + st9-3] = BRICK;
                    }
                    cc5++;
                }
            }
        } else if(vers == 5) {
            for (int col = 0; col < matrix.length; col++ ) {
                matrix[col][rand.nextInt(2)] = WALL;
                matrix[0][col] = WALL;
                matrix[rand.nextInt(r)][rand.nextInt(c)] = WALL;
                matrix[rand.nextInt(r)][rand.nextInt(c)] = BRICK;
            }
        } else if(vers == 6) {
            for (int col = 0; col < matrix.length; col++ ) {
                matrix[rand.nextInt(r)][rand.nextInt(c)] = BRICK;
                matrix[rand.nextInt(r)][rand.nextInt(c)] = BRICK;
                matrix[matrix.length - 1][col] = WALL;
                matrix[0][col] = WALL;
                matrix[col][matrix.length - 1] = WALL;
                matrix[col][0] = WALL;
            }

            for(int j = 1; j < matrix.length-1; j++) {
                for(int k = 1; k < matrix[j].length -1 ; k+=2) {
                    if(matrix[j][k] == BRICK) {
                        //   matrix[j][k + 1] = BRICK;
                        //   matrix[j - 1][k + 1] = BRICK;
                        // matrix[j - 1][k - 1] = BRICK;
                        matrix[j + 1][k + 1] = BRICK;
                    }
                }
            }

        } else {
            for (int col = 0; col < matrix.length; col++ ) {
                int cc3 = cc+ 3;
                int cc5 = 8;
                matrix[col][rand.nextInt(2)] = WALL;
                matrix[0][rand.nextInt(5)+c-5] = WALL;
                matrix[0][rand.nextInt(5)] = WALL;
                matrix[matrix.length - 1][col] = WALL;
                matrix[col][0] = WALL;
                matrix[col][matrix.length-1] = WALL;
                matrix[cc+1][matrix.length-2] = WALL;
                matrix[matrix.length-(cc + 6)][matrix.length-2] = WALL;
                matrix[cc+2][matrix.length-3] = BRICK;
                matrix[matrix.length-(cc + 7)][matrix.length-3] = BRICK;
                matrix[cc+2][matrix.length-4] = BRICK;
                matrix[matrix.length-(cc + 7)][matrix.length-4] = BRICK;
                while(cc3 < matrix.length-(cc + 7)) {
                    matrix[cc3][matrix.length-5] = WALL;
                    cc3++;
                }

                while(cc5 < matrix.length-8) {
                    if(strok == 1) {
                        matrix[matrix.length - cc5 -3 + st8][cc5 + st9-3] = WALL;
                    } else {
                        matrix[cc5 -3 + st8][cc5 + st9-3] = WALL;
                    }
                    cc5++;
                }
            }
        }


       /* matrix = new int[r][c];

        matrix [2][1] = WATER;


        int block = WALL;
        for (int col = 0; col < matrix[0].length; col++ ) {
            matrix[0][col] = WALL;
            matrix[matrix.length - 1][col] = WALL;

            matrix[col][col] = block;
            block++;
            block = block % 4;
        }*/
        for(int i = 0; i < matrix_layer2.length; i++) {
            for(int j = 0; j < matrix_layer2.length; j++) {
                matrix_layer2[i][j] = EMPTY;
            }
        }
        matrix[0][0] = GROUND;
        matrix[1][0] = GROUND;
        matrix[0][1] = GROUND;
        matrix[1][1] = GROUND;
    }

    public static int getBlock (int row, int col) {
        return matrix[row][col];
    }
    public static int getBlock_layer2 (int row, int col) {
        return matrix_layer2[row][col];
    }

    public static int getRowByY (double yW) {
        return (int)yW / BLOCK_SIZE;
    }
    public static int getColByX (double xW) {
        return (int)xW / BLOCK_SIZE;
    }

    public static void paint(Graphics g) {

        int row1, row2, col1, col2;

        row1 = getRowByY (Camera.getY());
        col1 = getColByX(Camera.getX());

        row2 = row1 + 50;
        col2 = col1 + 50;

        int x, y;
        for (int row = row1; row <= row2; row++) {
            for (int col = col1; col <= col2; col++) {
                int block = getBlock(row, col);
                /*if (block == EMPTY) {
                    continue;
                }*/
                x = BLOCK_SIZE * col;
                y = BLOCK_SIZE * row;
                ImageHelper.paint(g, block, Camera.getScreenX(x) , Camera.getScreenY(y) );

            }
        }

        for (int row = row1; row <= row2; row++) {
            for (int col = col1; col <= col2; col++) {
                int block = getBlock_layer2(row, col);
                /*if (block == EMPTY) {
                    continue;
                }*/
                x = BLOCK_SIZE * col;
                y = BLOCK_SIZE * row;
                ImageHelper.paint(g, block, Camera.getScreenX(x) , Camera.getScreenY(y) );

            }
        }


    }




}
