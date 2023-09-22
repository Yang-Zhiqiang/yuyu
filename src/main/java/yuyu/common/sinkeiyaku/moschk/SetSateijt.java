package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約 申込内容チェック 査定状態設定
 */
public class SetSateijt {

    @Inject
    private static Logger logger;

    public SetSateijt() {
        super();
    }

    public void exec(MosnaiCheckParam pMp) {

        HT_SyoriCTL syoriCtl = pMp.getDataSyoriControl();

        if(logger.isDebugEnabled()) {
            logger.debug("▽ 査定状態設定 開始");
            logger.debug("｜MP処理コントロールTBL・査定状態区分 = " + syoriCtl.getSateijtkbn());
        }
        C_SateijtKbn sateiJtKbn = syoriCtl.getSateijtkbn();
        C_KetteiKbn ketteiKbn = syoriCtl.getKetteikbn();
        C_UmuKbn seirituHubiKbn = syoriCtl.getSrhhbkbn();
        C_SeirituKbn seirituKbn = syoriCtl.getSeiritukbn();

        if (C_SateijtKbn.SATEI_SUMI.eq(sateiJtKbn)) {
            if (C_KetteiKbn.NONE.eq(ketteiKbn) ||
                C_KetteiKbn.KETTEI_MATI.eq(ketteiKbn)) {
                syoriCtl.setSateijtkbn(C_SateijtKbn.SATEI_TYUU);
                syoriCtl.setSateizumiymd(null);
            }
        }
        else {
            if (C_SateijtKbn.TKJYSYDK_MATI.eq(sateiJtKbn)  &&
                (C_KetteiKbn.NONE.eq(ketteiKbn) || C_KetteiKbn.KETTEI_MATI.eq(ketteiKbn))) {
                syoriCtl.setSateijtkbn(C_SateijtKbn.SATEI_TYUU);
            }
            else if (C_KetteiKbn.TKJYSYDK_MATI.eq(ketteiKbn)) {
                syoriCtl.setSateijtkbn(C_SateijtKbn.TKJYSYDK_MATI);
            }
            else if (C_KetteiKbn.KETTEI_SUMI.eq(ketteiKbn) &&
                (C_UmuKbn.NONE.eq(seirituHubiKbn) || C_SeirituKbn.HUSEIRITU.eq(seirituKbn))) {
                syoriCtl.setSateijtkbn(C_SateijtKbn.SATEI_SUMI);
                syoriCtl.setSateizumiymd(pMp.getSysDate());
            }
            else {
                syoriCtl.setSateijtkbn(C_SateijtKbn.SATEI_TYUU);
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 査定状態設定 終了");
        }
    }
}
