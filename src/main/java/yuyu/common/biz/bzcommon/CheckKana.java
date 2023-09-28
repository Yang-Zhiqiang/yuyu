package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.util.string.ConvertUtil;

import yuyu.def.biz.configuration.YuyuBizConfig;

/**
 * 業務共通 共通 カナ入力チェック
 */
public class CheckKana {

    public CheckKana() {
        super();
    }

    public static boolean isKyokaMoji(String pKanaNm) {

        return CheckMeigininNmKana.isPALCheckOK(pKanaNm, null);

    }

    public static boolean isKyoyouKetaHankaku(String pKanaNm, int pKeta) {

        String hankaku = "";

        if (pKanaNm == null || pKanaNm.length() == 0) {
            return true;
        }

        hankaku = ConvertUtil.toHanAll(pKanaNm, 0, 0);

        if (hankaku.length() > pKeta) {
            return false;
        }

        return true;
    }

    public static boolean isKyoyouKetaHankaku_Kouza(String pKanaNm) {

        String hankaku = "";

        if (pKanaNm == null || pKanaNm.length() == 0) {
            return true;
        }

        hankaku = ConvertUtil.toHanAll(pKanaNm, 0, 0);

        int ketasuu = YuyuBizConfig.getInstance().getKzmeigiKanaNmKyoyou();

        if (hankaku.length() > ketasuu) {
            return false;
        }

        return true;
    }
}
