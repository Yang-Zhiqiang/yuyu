package yuyu.common.workflowcore.core.iwfinfr.util;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.d_project.qrcode.QRCode;

/**
 * QRコードを生成用のユーティリティクラスです。
 * <pre>
 *   ■使用例
 *     BufferedImage image = createQR(UniqIDGeneratorUtils.generateUniqID(), 2, 3, ErrorCorrectLevel.H);
 *     try {
 *         ImageIO.write(image, "png", new File("C:/test.png"));
 *     } catch (IOException e) {
 *         e.printStackTrace();
 *     }
 * </pre>
 */
public class IwfQRUtils {

    public enum ImageFormat{
        PNG("png"),
        JPEG("jpg"),
        ;
        private String filetype;
        ImageFormat(String filetype){
            this.filetype = filetype;
        }

        public String getName(){
            return this.filetype;
        }
    }

    private static byte[] getImageBytes(BufferedImage image, ImageFormat imageFormat) {
        if(image == null){
            return null;
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        BufferedOutputStream os = new BufferedOutputStream(bos);
        image.flush();
        try {
            ImageIO.write(image, imageFormat.getName(), os);
            os.flush();
            os.close();
        } catch (Exception e) {

            return null;
        }
        return bos.toByteArray();
    }
    public static byte[] createQRImage(String data, ImageFormat type, int imageSize, int typeNumber, int errorCorrectLevel) {

        return getImageBytes(createQRImage(data, imageSize, typeNumber,  errorCorrectLevel), type);
    }
    public static void createQR(String data, File file, ImageFormat type, int size, int typeNumber, int  errorCorrectLevel) throws IOException {
        if(file != null && file.isFile()){
            ImageIO.write(createQRImage(data, size, typeNumber,  errorCorrectLevel), type.getName(), file);
        }
    }
    public static BufferedImage createQRImage(String data, int size, int typeNumber, int errorCorrectLevel) {

        QRCode qr = new QRCode();
        qr.setTypeNumber(typeNumber);
        qr.setErrorCorrectLevel(errorCorrectLevel);
        qr.addData(data);
        qr.make();

        BufferedImage image = null;
        try {
            image = qr.createImage(size, 10);
        } catch (IOException e1) {

            image = null;
        }
        return image;
    }
}
