package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.resource.ResourceUtil;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;

/**
 * 保険金給付金支払 請求内容チェック 責任開始日チェック
 */
public class ChkSubSknnKaisiYmd {

    @Inject
    private static Logger logger;

    public ChkSubSknnKaisiYmd() {
        super();
    }

    public void exec(BizDate pHanteiKijyunYmd, BizDate pHkSknnKaisiYmd, JT_SiKykSyouhn pSiKykSyouhn,
            List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 責任開始日チェック 開始");

        if (null != pHanteiKijyunYmd) {
            chkSekininKaisibi(pHanteiKijyunYmd, pSiKykSyouhn.getSknnkaisiymd(),
                    pHkSknnKaisiYmd, pChkKekkaBeanLst);
        }

        logger.debug("△ 責任開始日チェック 終了");
    }

    private void chkSekininKaisibi(BizDate pHanteiKijyunYmd, BizDate pSknnKaisiYmd,
            BizDate pHkSknnKaisiYmd, List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (pHkSknnKaisiYmd == null) {
            if (BizDateUtil.compareYmd(pSknnKaisiYmd, pHanteiKijyunYmd) == BizDateUtil.COMPARE_GREATER) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKNNKAISIYMD_CHK);
                chkKekkaBean.setMsgHikisuu1(ResourceUtil.getApplicationResources().getString(
                        JT_SiKykSyouhn.SKNNKAISIYMD));
                pChkKekkaBeanLst.add(chkKekkaBean);
            }
        }
        else {
            if (BizDateUtil.compareYmd(pHkSknnKaisiYmd, pSknnKaisiYmd) == BizDateUtil.COMPARE_GREATER) {
                if (BizDateUtil.compareYmd(pHkSknnKaisiYmd, pHanteiKijyunYmd) == BizDateUtil.COMPARE_GREATER) {
                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKNNKAISIYMD_CHK);
                    chkKekkaBean.setMsgHikisuu1(ResourceUtil.getApplicationResources().getString(
                            JT_SiKykKihon.HKSKNNKAISIYMD));
                    pChkKekkaBeanLst.add(chkKekkaBean);
                }
            }
            else {
                if (BizDateUtil.compareYmd(pSknnKaisiYmd, pHanteiKijyunYmd) == BizDateUtil.COMPARE_GREATER) {
                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKNNKAISIYMD_CHK);
                    chkKekkaBean.setMsgHikisuu1(ResourceUtil.getApplicationResources().getString(
                            JT_SiKykSyouhn.SKNNKAISIYMD));
                    pChkKekkaBeanLst.add(chkKekkaBean);
                }
            }
        }
    }
}
