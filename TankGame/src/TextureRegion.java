import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TextureRegion {

    public void paint (int x, int y, String img, Graphics g) {
        Image image = null;
        try {
            image = ImageIO.read(new File(img));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(image, x, y, null);
    }
}
