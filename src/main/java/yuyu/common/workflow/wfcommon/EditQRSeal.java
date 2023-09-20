package yuyu.common.workflow.wfcommon;

import java.util.HashMap;
import java.util.Map;

import yuyu.infr.qrcode.CreateQRCode;
import yuyu.infr.qrcode.QRConstants;


/***
 * QRシール用紙作成 機能の帳票編集クラスです。<br/>
 */
public class EditQRSeal {

    public static String editQRCodeImg(Object qrByte, String workflowDocumentId) throws Exception {
        CreateQRCode createQRCode = new CreateQRCode();

        byte[] qrBytes = (byte[]) qrByte;

        String qrFileNm = "barcode_" + workflowDocumentId;

        Map<String, Object> optionsMap = new HashMap<String,Object>();
        optionsMap.put(QRConstants.OPTIONS_KEY_IMAGEFILE_NAME, qrFileNm);

        createQRCode.createQRCodeImg(qrBytes, optionsMap);

        return qrFileNm + ".gif";
    }
}
