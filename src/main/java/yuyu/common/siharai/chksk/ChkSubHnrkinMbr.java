package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiUkt;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 保険金給付金支払 請求内容チェック 返戻金未払いチェック
 */
public class ChkSubHnrkinMbr {

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    public ChkSubHnrkinMbr() {
        super();
    }

    public void exec(JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 返戻金未払いチェック 開始");

        Long khHenreikinYendtMbrCount = hozenDomManager.getKhHenreikinYendtMbrCountBySyono(pSiKykKihon.getSyono());

        if (khHenreikinYendtMbrCount != 0) {
            if (pSiKykKihon.getSbuktnin() == 1) {
                for (JT_SiUkt siUkt : pSiKykKihon.getSiUkts()) {
                    if (C_Hkuktsyu.SBHKKUKT.eq(siUkt.getHkuktsyu()) && C_UktKbn.KYK.eq(siUkt.getUktkbn())) {

                        ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.HRMBRCHECK_KEIUKEDOU_CHK);
                        pChkKekkaBeanLst.add(chkKekkaBean);

                        logger.debug("△ 返戻金未払いチェック 終了");

                        return;

                    }
                }
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.HRMBRCHECK_KEIUKEBETU_CHK);
                pChkKekkaBeanLst.add(chkKekkaBean);

            }
            else {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.HRMBRCHECK_KEIUKEBETU_CHK);
                pChkKekkaBeanLst.add(chkKekkaBean);
            }
        }

        logger.debug("△ 返戻金未払いチェック 終了");

    }

}
