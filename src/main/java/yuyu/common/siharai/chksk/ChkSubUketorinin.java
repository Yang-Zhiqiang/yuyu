package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiUkt;


/**
 * 保険金給付金支払 請求内容チェック 受取人チェック
 */
public class ChkSubUketorinin {

    @Inject
    private static Logger logger;

    public ChkSubUketorinin() {
        super();
    }

    public void exec(C_SeikyuusyaKbn pSeikyuusyaKbn, String pSeikyusya, JT_SiKykKihon pSiKykKihon,
        List<ChkKekkaBean> pChkKekkaBeanList) {

        logger.debug("▽ 受取人チェック 開始");

        for (JT_SiUkt pSiUkt : pSiKykKihon.getSiUkts()) {
            if ((C_Hkuktsyu.SBHKKUKT.eq(pSiUkt.getHkuktsyu()) || C_Hkuktsyu.SBKYFKUKT.eq(pSiUkt.getHkuktsyu()))
                && C_UktKbn.KYK.eq(pSiUkt.getUktkbn())) {
                if (!C_SeikyuusyaKbn.UKTHONNIN.eq(pSeikyuusyaKbn) && !C_SeikyuusyaKbn.KYKDAIRININ.eq(pSeikyuusyaKbn)
                    && !pSiKykKihon.getKyknmkn().equals(pSeikyusya)) {
                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);

                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.UKT_CHK);

                    pChkKekkaBeanList.add(chkKekkaBean);

                    break;
                }
            }
        }

        logger.debug("△ 受取人チェック 終了");
    }

}
