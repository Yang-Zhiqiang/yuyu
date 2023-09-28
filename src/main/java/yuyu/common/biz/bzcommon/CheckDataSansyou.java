package yuyu.common.biz.bzcommon;

import yuyu.def.classification.C_KengenSyoriKbn;
import yuyu.def.classification.C_SansyoukngnumuKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 業務共通 共通 データ参照権限チェック
 */
public class CheckDataSansyou {

    public CheckDataSansyou() {
        super();
    }

    public static C_SansyoukngnumuKbn execCheck(String pSyoukenNo, C_KengenSyoriKbn pSyoriKbn) {

        C_UmuKbn zenSskSyoriKngnUmu = C_UmuKbn.ARI;
        C_UmuKbn zenSskSyoukaiKngnUmu = C_UmuKbn.ARI;

        if (C_KengenSyoriKbn.SYORI.eq(pSyoriKbn)) {
            if (C_UmuKbn.ARI.eq(zenSskSyoriKngnUmu)) {
                return C_SansyoukngnumuKbn.ARI;
            }
        }
        else if (C_KengenSyoriKbn.SYOUKAI.eq(pSyoriKbn)) {
            if (C_UmuKbn.ARI.eq(zenSskSyoukaiKngnUmu)) {
                return C_SansyoukngnumuKbn.ARI;
            }
        }

        return C_SansyoukngnumuKbn.ARI;
    }
}