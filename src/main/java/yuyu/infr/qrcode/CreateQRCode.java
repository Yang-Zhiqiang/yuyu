package yuyu.infr.qrcode;

import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.imageio.ImageIO;

import jp.co.slcs.swak.SWAK;

import org.apache.commons.lang.StringUtils;

import yuyu.def.qrcode.configuration.YuyuQrcodeConfig;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * QRコード生成の実装クラス<br />
 */
public class CreateQRCode implements CreateQRCodeUtil {

    @Override
    public byte[] getQRCodeImgBytes(Map<String, Object> optionsMap) {

        setDefaultOptions(optionsMap);

        this.preCreateBinaryCheck(optionsMap);

        return this.createQRCodeBytes(optionsMap);
    }

    @Override
    public byte[] getQRCodeImgBytes(String pContens) {

        Map<String, Object> optionsMap = createDefaultOptionMap();
        optionsMap.put(QRConstants.OPTIONS_KEY_CONTENTS, pContens);
        return getQRCodeImgBytes(optionsMap);
    }

    @Override
    public void createQRCodeImg(byte[] imgBytes, Map<String, Object> optionsMap) {

        setDefaultOptions(optionsMap);

        this.preCreateImgFileCheck(optionsMap);

        if (null == imgBytes || imgBytes.length == 0) {
            throw new QRCodeCreateException(QRConstants.ERR_IMAGE_BYTES_IS_EMPTY);
        }

        try {
            BufferedImage bufImg = this.getBufferedImgByBytes(imgBytes);

            File imgFile = new File(SWAK.getApplicationRootFile() + YuyuQrcodeConfig.getInstance().getFilePath());
            imgFile.mkdir();

            String fileName = optionsMap.get(QRConstants.OPTIONS_KEY_IMAGEFILE_NAME) == null ? QRConstants.DEFAULT_QRCODE_FILE_NAME : optionsMap.get(QRConstants.OPTIONS_KEY_IMAGEFILE_NAME).toString();

            ImageIO.write(
                bufImg,
                optionsMap.get(QRConstants.OPTIONS_KEY_FILE_TYPE).toString(),
                new File(imgFile + "/" + fileName
                    + "."
                    + optionsMap.get(QRConstants.OPTIONS_KEY_FILE_TYPE).toString().toLowerCase()));
        } catch (IOException e) {
            throw new QRCodeCreateException(QRConstants.ERR_IMAGE_IO_EXCEPTION + "\r\n" + e.getMessage(), e);
        } catch (RasterFormatException e) {
            throw new QRCodeCreateException(QRConstants.ERR_RASTERFORMAT_EXCEPTION + "\r\n" + e.getMessage(), e);
        }
    }

    @Override
    public void createQRCodeImg(byte[] imgBytes) {
        Map<String, Object> optionsMap = createDefaultOptionMap();
        createQRCodeImg(imgBytes, optionsMap);
    }

    private Map<String,Object> createDefaultOptionMap() {
        YuyuQrcodeConfig qrCodeConfig = YuyuQrcodeConfig.getInstance();

        Map<String, Object> optionsMap = new HashMap<String,Object>();

        optionsMap.put(QRConstants.OPTIONS_KEY_ENCODE_TYPE, qrCodeConfig.getEncodeType());

        setErrCorrectLevel(optionsMap, qrCodeConfig.getErrorCorrectionLevel().toString());

        optionsMap.put(QRConstants.OPTIONS_KEY_FILE_TYPE, qrCodeConfig.getFileType());

        optionsMap.put(QRConstants.OPTIONS_KEY_IMAGEFILE_NAME, QRConstants.DEFAULT_QRCODE_FILE_NAME);

        optionsMap.put(QRConstants.OPTIONS_KEY_WIDTH, qrCodeConfig.getWidth());

        optionsMap.put(QRConstants.OPTIONS_KEY_HEIGHT, qrCodeConfig.getHeight());

        return optionsMap;
    }

    private byte[] createQRCodeBytes(Map<String, Object> optionsMap) {

        BufferedImage image = this.getBufferedImgByOptions(optionsMap);

        try {
            return this.getQRImgBytes(image, optionsMap.get(QRConstants.OPTIONS_KEY_FILE_TYPE).toString());
        } catch (IOException e) {
            throw new QRCodeCreateException(QRConstants.ERR_IMAGE_IO_EXCEPTION + "\r\n" + e.getMessage(), e);
        }
    }

    private byte[] getQRImgBytes(BufferedImage bufImg, String fileType) throws IOException {
        ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
        try (BufferedOutputStream bufOutStream = new BufferedOutputStream(byteOutStream) ){

            bufImg.flush();
            ImageIO.write(bufImg, fileType, bufOutStream);
            bufOutStream.flush();

        }

        return byteOutStream.toByteArray();
    }

    private BufferedImage getBufferedImgByBytes(byte[] imgBytes) {

        try {
            BufferedImage bufImage = ImageIO.read(new ByteArrayInputStream(imgBytes));
            return bufImage;
        } catch (IOException e) {
            throw new QRCodeCreateException(QRConstants.ERR_IMAGE_IO_EXCEPTION + "\r\n" + e.getMessage(), e);
        }
    }

    private BufferedImage getBufferedImgByOptions(Map<String, Object> optionsMap) {

        BarcodeFormat format = BarcodeFormat.QR_CODE;

        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.ERROR_CORRECTION, optionsMap.get(QRConstants.OPTIONS_KEY_ERROR_CORRECTION_LEVEL));
        hints.put(EncodeHintType.CHARACTER_SET, optionsMap.get(QRConstants.OPTIONS_KEY_ENCODE_TYPE));

        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix bitMatrix;

        try {
            bitMatrix = writer.encode(optionsMap.get(QRConstants.OPTIONS_KEY_CONTENTS).toString(),
                format,
                Integer.parseInt(optionsMap.get(QRConstants.OPTIONS_KEY_WIDTH).toString()),
                Integer.parseInt(optionsMap.get(QRConstants.OPTIONS_KEY_HEIGHT).toString()),
                hints);

            BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);

            return image;
        } catch (NumberFormatException e) {
            throw new QRCodeCreateException(QRConstants.ERR_CREATE_QRCODE_EXCEPTION + "\r\n" + e.getMessage(), e);
        } catch (WriterException e) {
            throw new QRCodeCreateException(QRConstants.ERR_IMAGE_WRITE_EXCEPTION + "\r\n" + e.getMessage(), e);
        }
    }

    private boolean preCreateBinaryCheck(Map<String, Object> optionsMap) {

        if (optionsMap.isEmpty()) {
            throw new QRCodeCreateException(QRConstants.ERR_OPTIONS_NOT_SET);
        }

        Object contentsObj = optionsMap.get(QRConstants.OPTIONS_KEY_CONTENTS);
        if (null == contentsObj || StringUtils.isEmpty(contentsObj.toString())) {
            throw new QRCodeCreateException(QRConstants.ERR_CONTENTS_NOT_SET);
        }

        if (contentsObj.toString().length() > 150) {
            throw new QRCodeCreateException(QRConstants.ERR_CONTENTS_MAX_SIZE);
        }

        if (optionsMap.containsKey(QRConstants.OPTIONS_KEY_ERROR_CORRECTION_LEVEL)) {
            Object level = optionsMap.get(QRConstants.OPTIONS_KEY_ERROR_CORRECTION_LEVEL);
            if (null == level || StringUtils.isEmpty(level.toString())) {
                throw new QRCodeCreateException(QRConstants.ERR_CORRECTION_LEVEL_NOT_SET);
            }

            if (!Arrays.asList(QRConstants.QRCODE_CORRECTION_LEVEL).contains(level.toString())) {
                throw new QRCodeCreateException(QRConstants.ERR_CORRECTION_LEVEL_NOT_CORRECT);
            }

            setErrCorrectLevel(optionsMap, level.toString());
        }

        if (optionsMap.containsKey(QRConstants.OPTIONS_KEY_WIDTH)) {
            Object width = optionsMap.get(QRConstants.OPTIONS_KEY_WIDTH);
            if (null == width || StringUtils.isEmpty(width.toString())) {
                throw new QRCodeCreateException(QRConstants.ERR_IMAGE_WIDTH_NOT_SET);
            }

            try {
                Integer.parseInt(width.toString());
            } catch (NumberFormatException e) {
                throw new QRCodeCreateException(QRConstants.ERR_IMAGE_WIDTH_IS_NOT_NUMBER, e);
            }
        }

        if (optionsMap.containsKey(QRConstants.OPTIONS_KEY_HEIGHT)) {
            Object height = optionsMap.get(QRConstants.OPTIONS_KEY_HEIGHT);
            if (null == height || StringUtils.isEmpty(height.toString())) {
                throw new QRCodeCreateException(QRConstants.ERR_IMAGE_HEIGHT_NOT_SET);
            }

            try {
                Integer.parseInt(height.toString());
            } catch (NumberFormatException e) {
                throw new QRCodeCreateException(QRConstants.ERR_IMAGE_HEIGHT_IS_NOT_NUMBER, e);
            }
        }
        return preCreateImgFileCheck(optionsMap);
    }


    private boolean preCreateImgFileCheck(Map<String, Object> optionsMap) {

        if (optionsMap.isEmpty()) {
            throw new QRCodeCreateException(QRConstants.ERR_OPTIONS_NOT_SET);
        }

        if (optionsMap.containsKey(QRConstants.OPTIONS_KEY_FILE_TYPE)) {
            Object fileTypeObj = optionsMap.get(QRConstants.OPTIONS_KEY_FILE_TYPE);

            if (null == fileTypeObj
                || !Arrays.asList(QRConstants.QRCODE_FILE_TYPE).contains(fileTypeObj.toString().toLowerCase())) {
                throw new QRCodeCreateException(QRConstants.ERR_FILE_TYPE_NOT_CORRECT);
            }
        }

        return true;
    }

    private Map<String, Object> setDefaultOptions(Map<String, Object> optionsMap) {

        YuyuQrcodeConfig qrCodeConfig = YuyuQrcodeConfig.getInstance();

        String correctLevel = qrCodeConfig.getErrorCorrectionLevel();

        String qrWidth = qrCodeConfig.getWidth();

        String qrHeight = qrCodeConfig.getHeight();

        String encodeType = qrCodeConfig.getEncodeType();

        String fileType = qrCodeConfig.getFileType();

        if (!optionsMap.containsKey(QRConstants.OPTIONS_KEY_ENCODE_TYPE)) {
            optionsMap.put(QRConstants.OPTIONS_KEY_ENCODE_TYPE, encodeType);
        }

        if (!optionsMap.containsKey(QRConstants.OPTIONS_KEY_ERROR_CORRECTION_LEVEL)) {
            setErrCorrectLevel(optionsMap, correctLevel);
        }

        if (!optionsMap.containsKey(QRConstants.OPTIONS_KEY_FILE_TYPE)) {
            optionsMap.put(QRConstants.OPTIONS_KEY_FILE_TYPE, fileType);
        }

        if (!optionsMap.containsKey(QRConstants.OPTIONS_KEY_IMAGEFILE_NAME)) {
            optionsMap.put(QRConstants.OPTIONS_KEY_IMAGEFILE_NAME, QRConstants.DEFAULT_QRCODE_FILE_NAME);
        }

        if (!optionsMap.containsKey(QRConstants.OPTIONS_KEY_WIDTH)) {
            optionsMap.put(QRConstants.OPTIONS_KEY_WIDTH, qrWidth);
        }

        if (!optionsMap.containsKey(QRConstants.OPTIONS_KEY_HEIGHT)) {
            optionsMap.put(QRConstants.OPTIONS_KEY_HEIGHT, qrHeight);
        }

        return optionsMap;
    }

    private void setErrCorrectLevel(Map<String, Object> optionsMap, String level) {

        if ("M".equals(level)) {
            optionsMap.put(QRConstants.OPTIONS_KEY_ERROR_CORRECTION_LEVEL, ErrorCorrectionLevel.M);
        } else if ("H".equals(level)) {
            optionsMap.put(QRConstants.OPTIONS_KEY_ERROR_CORRECTION_LEVEL, ErrorCorrectionLevel.H);
        } else if ("Q".equals(level)) {
            optionsMap.put(QRConstants.OPTIONS_KEY_ERROR_CORRECTION_LEVEL, ErrorCorrectionLevel.Q);
        } else if ("L".equals(level)) {
            optionsMap.put(QRConstants.OPTIONS_KEY_ERROR_CORRECTION_LEVEL, ErrorCorrectionLevel.L);
        }
    }
}