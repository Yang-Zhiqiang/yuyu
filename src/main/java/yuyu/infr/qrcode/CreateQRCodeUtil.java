package yuyu.infr.qrcode;

import java.util.Map;

/**
 * QRコード生成 インターフェース<br />
 */
public interface CreateQRCodeUtil {

    byte[] getQRCodeImgBytes(Map<String, Object> optionsMap) throws QRCodeCreateException;

    byte[] getQRCodeImgBytes(String pContens) throws QRCodeCreateException;

    void createQRCodeImg(byte[] imgBytes, Map<String, Object> optionsMap) throws QRCodeCreateException;

    void createQRCodeImg(byte[] imgBytes) throws QRCodeCreateException;

}