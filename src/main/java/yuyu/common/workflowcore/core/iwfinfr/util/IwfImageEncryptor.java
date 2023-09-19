package yuyu.common.workflowcore.core.iwfinfr.util;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.crypto.AESEncryptor;
import jp.co.slcs.swak.util.crypto.Encryptor;

/**
 * イメージ暗号化クラス。<br />
 * SWAKの暗号化基盤を使用し、 イメージde-ta の暗号化・復号化を行います。<br />
 */
public class IwfImageEncryptor {

    @Inject
    private Encryptor encryptor = SWAKInjector.getInstance(AESEncryptor.class);

    private String encryptKey;

    public  IwfImageEncryptor() {
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