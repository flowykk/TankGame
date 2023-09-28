import java.awt.*;

public class AnimationV2 {

    private String[] cards;
    private int x, y;
    private int betweenTime;
    private int elapsedTime;
    private int currentStep;
    private boolean isAnimating = false;
    private int pictureSize;
    private TextureRegion textureRegion;

    public static final int STRAIGHT  = 0;
    public static final int REVERSED  = 1;
    public static final int PING_PONG = 2;
    public static final int PLAYED_ONCE = 3;

    public AnimationV2(String[] cards, TextureRegion textureRegion, int betweenTime, int x, int y) {
        this.cards         = cards;
        this.pictureSize = cards.length;
        this.textureRegion = textureRegion;
        this.betweenTime   = betweenTime;
        this.x             = x;
        this.y             = y;
    }

    public void paint (Graphics g) {
        textureRegion.paint(x, y, cards[currentStep], g);

    }

    public void update (int ms, int currentStep1) {
        elapsedTime += ms;
        if(elapsedTime >= betweenTime) {
            nextImage(currentStep1);
            elapsedTime = 0;
        }
    }

    public  void nextImage (int mode) {
        if (mode == PING_PONG) {
            if (currentStep == 0 || currentStep == pictureSize - 1) {
                isAnimating = !isAnimating;
            }

            if (isAnimating) {
                currentStep = (currentStep + 1) % pictureSize;
            } else currentStep = (currentStep - 1) % pictureSize;

        }

        if (mode == STRAIGHT) {
            currentStep = (currentStep + 1) % pictureSize;
        }

        if (mode == REVERSED) {
            currentStep = (pictureSize + currentStep - 1) % pictureSize;
        }
        if (mode == PLAYED_ONCE) {
            if (currentStep == 0 || currentStep == pictureSize - 1) {
                isAnimating = !isAnimating;
            }

            if (isAnimating) {
                currentStep = (currentStep + 1) % pictureSize;
            }
        }
    }
}
