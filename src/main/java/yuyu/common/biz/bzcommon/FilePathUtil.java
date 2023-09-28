package yuyu.common.biz.bzcommon;

import yuyu.def.base.configuration.YuyuBaseConfig;

/**
 * ファイル、フォルダのパスに関連する処理を行うユーティリティクラスです。
 */
public class FilePathUtil {

    public static String getBatchInDataPath() {

        YuyuBaseConfig config = YuyuBaseConfig.getInstance();

        String batchFileIn = config.getBatchInputDir();

        return batchFileIn;
    }

    public static String getBatchOutDataPath() {

        YuyuBaseConfig config = YuyuBaseConfig.getInstance();

        String batchFileOut = config.getBatchOutputDir();

        return batchFileOut;
    }

}
