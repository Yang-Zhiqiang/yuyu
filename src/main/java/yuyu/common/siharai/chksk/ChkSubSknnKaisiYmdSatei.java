package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.siharai.configuration.YuyuSiharaiConfig;

/**
 * 保険金給付金支払 請求内容チェック 査定項目＿責任開始日チェック
 */
public class ChkSubSknnKaisiYmdSatei {
    @Inject
    private static Logger logger;

    public ChkSubSknnKaisiYmdSatei() {
        super();
    }

    public void exec(BizDate pHanteiKijyunYmd, JT_SiKykSyouhn pSiKykSyouhn, List<ChkKekkaBean> pChkKekkaBeanLst) {
        logger.debug("▽ 査定項目＿責任開始日チェック 開始");

        if (pHanteiKijyunYmd != null) {
            BizDate hizeke = pSiKykSyouhn.getSknnkaisiymd().addYears(
                YuyuSiharaiConfig.getInstance().getSoukiKyhNensuu());

            if (BizDateUtil.compareYmd(hizeke, pHanteiKijyunYmd) == BizDateUtil.COMPARE_GREATER) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);

                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_SKNNKAISIYMD);

                pChkKekkaBeanLst.add(chkKekkaBean);
            }
        }

        logger.debug("△ 査定項目＿責任開始日チェック 終了");

    }

}
