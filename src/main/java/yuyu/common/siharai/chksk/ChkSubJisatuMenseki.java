package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.siharai.sicommon.JisatuMensekiKikanHantei;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.entity.JT_SiKykSyouhn;

/**
 * 保険金給付金支払 請求内容チェック 自殺免責チェック
 */
public class ChkSubJisatuMenseki {

    @Inject
    private static Logger logger;

    public ChkSubJisatuMenseki() {
        super();
    }

    public void exec(BizDate pHanteiKijyunYmd, C_GeninKbn pGeninKbn, BizDate pHkSknnKaisiYmd,
        JT_SiKykSyouhn pSiKykSyouhn, JM_SiSyouhnZokusei pSiSyouhnZokusei,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 自殺免責チェック 開始");

        if (C_GeninKbn.JS.eq(pGeninKbn)) {

            JisatuMensekiKikanHantei jisatuMensekiKikanHantei = SWAKInjector
                .getInstance(JisatuMensekiKikanHantei.class);

            boolean hanteiKekkaFlag = jisatuMensekiKikanHantei.exec(pHanteiKijyunYmd, pHkSknnKaisiYmd, pSiKykSyouhn,
                pSiSyouhnZokusei);

            if (hanteiKekkaFlag) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_JISATUMENSEKI);
                pChkKekkaBeanLst.add(chkKekkaBean);
            }

        }

        logger.debug("△ 自殺免責チェック 終了");
    }

}