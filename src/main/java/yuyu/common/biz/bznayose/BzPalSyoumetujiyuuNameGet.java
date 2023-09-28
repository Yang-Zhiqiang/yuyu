package yuyu.common.biz.bznayose;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BetukutiKeiyakuKbn;
import yuyu.def.db.entity.BM_PalSyoumetujiyuu;

import com.google.common.base.Strings;

/**
 * 業務共通 名寄せ ＰＡＬ消滅事由名称取得クラス
 */
public class BzPalSyoumetujiyuuNameGet {

    private final String MASTER_SYUTOKU_HUKA_TOKI_MEISYOU = "その他";
    @Inject
    private static Logger logger;
    @Inject
    private BizDomManager bizDomManager;

    public String exec(String pPalSyoumetuCd, C_BetukutiKeiyakuKbn pBetukutiKeiyakuKbn) {
        logger.debug("▽ ＰＡＬ消滅事由名称取得 開始");
        String pPalSyoumetuCdConvert = Strings.padStart(pPalSyoumetuCd, 4, '0');
        BM_PalSyoumetujiyuu palSyoumetujiyuu = bizDomManager.getPalSyoumetujiyuu(pPalSyoumetuCdConvert,
                pBetukutiKeiyakuKbn);
        String syoumetujiyuuMeisyo = null;
        if (palSyoumetujiyuu != null) {
            syoumetujiyuuMeisyo = palSyoumetujiyuu.getSyoumetujiyuuname();
        }
        else {
            syoumetujiyuuMeisyo = MASTER_SYUTOKU_HUKA_TOKI_MEISYOU;
        }
        logger.debug("△ ＰＡＬ消滅事由名称取得 終了");
        return syoumetujiyuuMeisyo;
    }
}
