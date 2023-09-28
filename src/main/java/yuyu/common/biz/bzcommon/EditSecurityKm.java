package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.util.crypto.AESEncryptor;
import jp.co.slcs.swak.util.crypto.Encryptor;

import org.slf4j.Logger;

import yuyu.def.base.configuration.YuyuBaseConfig;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_EncryptKbn;

/**
 * 業務共通 共通 セキュリティ項目編集
 */
public class EditSecurityKm {

    public static final int ENCRYPT_MODE = 0;
    public static final int DECRYPT_MODE = 1;
    private static final Logger LOGGER = LoggerFactory.getLogger(EditSecurityKm.class);
    public static final int OUTPUT_LOG_NONE = 0;
    public static final int OUTPUT_LOG_ENCRYPT = 1;
    public static final int OUTPUT_LOG_ALL = 2;

    private Encryptor encryptorUtil = null;

    private static boolean decodeRunFlag = false;
    private int logOutputKbn = 0;
    private static C_EncryptKbn encryptKbn;
    private String key = "";

    private EditSecurityKm() {

        if (encryptKbn == null) {
            getEncryptKbn();
        }

        boolean debugModeflag = getDebugModeFlag();
        decodeRunFlag = getDebugRunFlag(encryptKbn, debugModeflag);
        logOutputKbn = getLogOutputKbn(encryptKbn, debugModeflag);

        encryptorUtil = SWAKInjector.getInstance(AESEncryptor.class);
    }

    public static EditSecurityKm getInstance() {
        return new EditSecurityKm();
    }

    public void init(String pKey) {
        key = pKey;
    }

    public String encode(String pValue) {

        if (BizUtil.isBlank(pValue) || !decodeRunFlag) {

            outputLog(logOutputKbn, ENCRYPT_MODE, pValue, pValue);
            return pValue;
        }

        String encode = encryptorUtil.encode(pValue, key);
        outputLog(logOutputKbn, ENCRYPT_MODE, pValue, encode);

        return encode;
    }

    public static String getEncodeData(String pKey, String pValue) {

        if (encryptKbn == null) {
            getEncryptKbn();
        }

        boolean debugModeflag = getDebugModeFlag();
        boolean debugRunFlag = getDebugRunFlag(encryptKbn, debugModeflag);
        int tempLogOutputKbn = getLogOutputKbn(encryptKbn, debugModeflag);

        if (BizUtil.isBlank(pValue) || !debugRunFlag) {

            outputLog(tempLogOutputKbn, ENCRYPT_MODE, pValue, pValue);
            return pValue;
        }

        Encryptor cipherUtil = SWAKInjector.getInstance(AESEncryptor.class);
        String encode = cipherUtil.encode(pValue, pKey);
        outputLog(tempLogOutputKbn, ENCRYPT_MODE, pValue, encode);

        return encode;
    }

    public String decode(String pValue) {

        if (BizUtil.isBlank(pValue) || !decodeRunFlag) {

            outputLog(logOutputKbn, DECRYPT_MODE, pValue, pValue);
            return pValue;
        }

        String decode = encryptorUtil.decode(pValue, key);
        outputLog(logOutputKbn, DECRYPT_MODE, pValue, decode);

        return decode;
    }

    public static String getDecodeData(String pKey, String pValue) {

        if (encryptKbn == null) {
            getEncryptKbn();
        }

        boolean debugModeflag = getDebugModeFlag();
        boolean debugRunFlag  = getDebugRunFlag(encryptKbn, debugModeflag);
        int tempLogOutputKbn = getLogOutputKbn(encryptKbn, debugModeflag);

        if (BizUtil.isBlank(pValue) || !debugRunFlag) {

            outputLog(tempLogOutputKbn, DECRYPT_MODE, pValue, pValue);
            return pValue;
        }

        Encryptor cipherUtil = SWAKInjector.getInstance(AESEncryptor.class);
        String decode = cipherUtil.decode(pValue, pKey);
        outputLog(tempLogOutputKbn, DECRYPT_MODE, pValue, decode);

        return decode;
    }

    private static void getEncryptKbn() {

        C_EncryptKbn configEncryptKbn = YuyuBizConfig.getInstance().getEncryptKbn();
        encryptKbn = configEncryptKbn;
    }

    private static boolean getDebugModeFlag() {
        return YuyuBaseConfig.getInstance().isDebugMode();
    }

    private static boolean getDebugRunFlag(C_EncryptKbn pEncryptKbn, boolean pDebugModeflag) {

        if (C_EncryptKbn.SINAI.eq(pEncryptKbn) && pDebugModeflag) {
            return false;
        }
        return true;
    }

    private static int getLogOutputKbn(C_EncryptKbn pEncryptKbn, boolean pDebugRunFlag) {

        if (pDebugRunFlag) {
            if (C_EncryptKbn.SURU.eq(pEncryptKbn) && LOGGER.isDebugEnabled()) {
                return OUTPUT_LOG_ALL;
            }
        }
        else {
            if (LOGGER.isDebugEnabled()) {
                return OUTPUT_LOG_ENCRYPT;
            }
        }

        return OUTPUT_LOG_NONE;
    }

    private static void outputLog(int pLogOutputKbn,
            int pEditMode,
            String pInputValue,
            String pOutputValue) {

        switch (pLogOutputKbn) {
            case OUTPUT_LOG_ENCRYPT:
                switch (pEditMode) {
                    case ENCRYPT_MODE:
                        LOGGER.debug("▽ 暗号化処理 開始");
                        LOGGER.debug("｜ 暗号文 = " + pOutputValue);
                        LOGGER.debug("△ 暗号化処理 終了");
                        return;
                    case DECRYPT_MODE:
                        LOGGER.debug("▽ 復号化処理 開始");
                        LOGGER.debug("｜ 暗号文 = " + pInputValue);
                        LOGGER.debug("△ 復号化処理 終了");
                        return;
                    default:
                        return;
                }
            case OUTPUT_LOG_ALL:
                switch (pEditMode) {
                    case ENCRYPT_MODE:
                        LOGGER.debug("▽ 暗号化処理 開始");
                        LOGGER.debug("｜ 平文 = " + pInputValue);
                        LOGGER.debug("｜ 暗号文= " + pOutputValue);
                        LOGGER.debug("△ 暗号化処理 終了");
                        return;

                    case DECRYPT_MODE:
                        LOGGER.debug("▽ 復号化処理 開始");
                        LOGGER.debug("｜ 平文 = " + pOutputValue);
                        LOGGER.debug("｜ 暗号文= " + pInputValue);
                        LOGGER.debug("△ 復号化処理 終了");
                        return;

                    default:
                        return;
                }

            default:
                return;
        }
    }
}