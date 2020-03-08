package com.zhang.application.utill;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class ImageToIO {
    public static void getIO(String filePath, OutputStream os) throws IOException {

        File out = new File(filePath);
        //将图片写入ImageIO流

            BufferedImage img = ImageIO.read(out);
            ImageIO.write(img, "jpg", os);



    }
}
