package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Obj_chest extends SuperObject{
    public Obj_chest(){
        name="Chest";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/object/chest.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
