package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;

import yuyu.infrext.encrypt.RayDbAes128Ecryptor;

/**
 * 業務共通　暗号化ユーティリティ
 */
public class BzEncryptUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(BzEncryptUtil.class);
    private RayDbAes128Ecryptor encryptor = null;

    private BzEncryptUtil() {

        encryptor = SWAKInjector.getInstance(RayDbAes128Ecryptor.class);

    }

    public static BzEncryptUtil getInstance() {
        return new BzEncryptUtil();
    }

    public String raydbEncrypt(String pValue) {

        LOGGER.debug("▽ 暗号化ユーティリティ 開始");

        if (BizUtil.isBlank(pValue)) {
            LOGGER.debug("△ 暗号化ユーティリティ 終了");
            return pValue;
        }

        byte[] data = pValue.getBytes();

        String encrypt = Base64.encodeBase64String(encryptor.encrypt(data));

        LOGGER.debug("△ 暗号化ユーティリティ 終了");

        return encrypt;
    }

    public String raydbDecrypt(String pValue) {

        LOGGER.debug("▽ 暗号化ユーティリティ 開始");

        if (BizUtil.isBlank(pValue)) {
            LOGGER.debug("△ 暗号化ユーティリティ 終了");
            return pValue;
        }

        byte[] data = encryptor.decrypt(Base64.decodeBase64(pValue));

        String decode = new String(data);

        LOGGER.debug("△ 暗号化ユーティリティ 終了");

        return decode;
    }
}