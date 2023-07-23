package yuyu.infr.report;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.crypto.AESEncryptor;
import jp.co.slcs.swak.util.crypto.Encryptor;

/**
 * 帳票暗号化クラス。<br />
 * SWAKの暗号化基盤を使用し、 帳票バイナリの暗号化・復号化を行います。<br />
 */
public class ReportEncryptor {

    @Inject
    private Encryptor encryptor = SWAKInjector.getInstance(AESEncryptor.class);

    private String encryptKey;

    public  ReportEncryptor() {
    }

    public void setKey(String pEncryptKey) {
        encryptKey = pEncryptKey;
    }

    public byte[] encode(byte[] pByte) {
        if (null != pByte){
            return encryptor.encode(pByte, encryptKey);
        }
        return null;
    }

    public byte[] decode(byte[] pByte) {
        if (null != pByte){
            return encryptor.decode(pByte, encryptKey);
        }
        return null;
    }
}