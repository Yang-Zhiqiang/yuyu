package yuyu.common.direct.dscommon;

import javax.inject.Inject;

import org.slf4j.Logger;

/**
 * ダイレクトサービス ダイレクトサービス共通 ＤＳ環境依存文字変換ユーティリティ
 */
public class DsKankyouizonmojiHenkanUtil {

    @Inject
    private static Logger logger;

    public DsKankyouizonmojiHenkanUtil() {
        super();
    }

    public String henkanRomesuuji(String pHenkanStr) {

        logger.debug("▽ ＤＳ環境依存文字変換ユーティリティ 開始");

        String henkangoStr = pHenkanStr.replaceAll("Ⅱ", "II");

        logger.debug("△ ＤＳ環境依存文字変換ユーティリティ 終了");

        return henkangoStr;
    }
}
