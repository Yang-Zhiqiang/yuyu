package yuyu.infr.qrcode;

import java.util.HashMap;
import java.util.Map;

import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.slf4j.Logger;

public class CreateQRCodeTestData {

    private static Logger logger = LoggerFactory.getLogger(CreateQRCodeUtil.class);

    public Map<String, Object> setDataTest10() {
        Map<String, Object> optionsMap = new HashMap<String, Object>();

        logger.info("オプションマップ(test_10)の設定を開始");

        optionsMap.put("Contents", "YUYU20101113132806683");
        optionsMap.put("Width", "160");
        optionsMap.put("Height", "160");
        optionsMap.put("ErrorCorrectionLevel", "H");

        logger.info("オプションマップ(test_10)の設定を終了");

        return optionsMap;
    }

    public Map<String, Object> setDataTest11() {
        Map<String, Object> optionsMap = new HashMap<String, Object>();

        logger.info("オプションマップ(test_11)の設定を開始");

        StringBuilder strB = new StringBuilder("");
        for (int i = 0; i < 15; i++) {
            strB.append("1234567890");
        }

        optionsMap.put("Contents", strB.toString());

        logger.info("オプションマップ(test_11)の設定を終了");

        return optionsMap;
    }

    public Map<String, Object> setDataTest13() {
        Map<String, Object> optionsMap = new HashMap<String, Object>();

        logger.info("オプションマップ(test_11)の設定を開始");

        StringBuilder strB = new StringBuilder("");
        for (int i = 0; i < 15; i++) {
            strB.append("1234567890");
        }

        optionsMap.put("Contents", strB.toString());
        optionsMap.put("FileType","JPEG");

        logger.info("オプションマップ(test_11)の設定を終了");

        return optionsMap;
    }

    public Map<String, Object> setDataTest14() {
        Map<String, Object> optionsMap = new HashMap<String, Object>();

        logger.info("オプションマップ(test_10)の設定を開始");

        optionsMap.put("Contents", "YUYU20101113132806683");
        optionsMap.put("Width", "160");
        optionsMap.put("Height", "160");
        optionsMap.put("ErrorCorrectionLevel", "H");

        logger.info("オプションマップ(test_10)の設定を終了");

        return optionsMap;
    }

    public Map<String, Object> setDataTest15() {
        Map<String, Object> optionsMap = new HashMap<String, Object>();

        logger.info("オプションマップ(test_10)の設定を開始");

        optionsMap.put("Contents", "YUYU20101113132806683");
        optionsMap.put("Width", "500");
        optionsMap.put("Height", "500");
        optionsMap.put("ErrorCorrectionLevel", "H");

        logger.info("オプションマップ(test_10)の設定を終了");

        return optionsMap;
    }

    public Map<String, Object> setDataTest16() {
        Map<String, Object> optionsMap = new HashMap<String, Object>();

        logger.info("オプションマップ(test_16)の設定を開始");

        optionsMap.put("Contents", "YUYU20101113132806683");
        optionsMap.put("ErrorCorrectionLevel", "H");
        optionsMap.put(QRConstants.OPTIONS_KEY_IMAGEFILE_NAME,"test123");

        logger.info("オプションマップ(test_16)の設定を終了");

        return optionsMap;
    }

    public Map<String, Object> setDataTest20() {
        Map<String, Object> optionsMap = new HashMap<String, Object>();

        logger.info("オプションマップ(test_20)の設定を開始");
        logger.info("オプションマップ(test_20)の設定を終了");
        return optionsMap;
    }

    public Map<String, Object> setDataTest21() {
        Map<String, Object> optionsMap = new HashMap<String, Object>();

        logger.info("オプションマップ(test_21)の設定を開始");

        optionsMap.put("Contents", "");

        logger.info("オプションマップ(test_21)の設定を終了");
        return optionsMap;
    }

    public Map<String, Object> setDataTest22() {
        Map<String, Object> optionsMap = new HashMap<String, Object>();

        logger.info("オプションマップ(test_22)の設定を開始");

        StringBuilder strB = new StringBuilder("Y");
        for (int i = 0; i < 15; i++) {
            strB.append("1234567890");
        }

        optionsMap.put("Contents", strB.toString());
        logger.info("オプションマップ(test_22)の設定を終了");
        return optionsMap;
    }

    public Map<String, Object> setDataTest23() {
        Map<String, Object> optionsMap = new HashMap<String, Object>();

        logger.info("オプションマップ(test_23)の設定を開始");

        optionsMap.put("Contents", "YUYU20101113132806683");
        optionsMap.put("ErrorCorrectionLevel", "T");

        logger.info("オプションマップ(test_23)の設定を終了");
        return optionsMap;
    }

    public byte[] setDataTest24() {

        logger.info("オプションマップ(test_24)の設定を開始");
        byte[] emptyData = new byte[0];
        logger.info("オプションマップ(test_24)の設定を終了");

        return emptyData;
    }

    public Map<String, Object> setDataTest25() {
        Map<String, Object> optionsMap = new HashMap<String, Object>();

        logger.info("オプションマップ(test_25)の設定を開始");

        optionsMap.put("Contents", "YUYU20101113132806683");
        optionsMap.put("Width", "100");
        optionsMap.put("Height", "xz");

        logger.info("オプションマップ(test_25)の設定を終了");
        return optionsMap;
    }

}