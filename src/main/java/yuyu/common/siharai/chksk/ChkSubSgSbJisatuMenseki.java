package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.siharai.sicommon.SaigaiGaitouHantei;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_SkKihon;

/**
 * 保険金給付金支払 請求内容チェック 災害死亡自殺免責チェック
 */
public class ChkSubSgSbJisatuMenseki {

    private static final int JISATUMENSEKINENSUU = 3;

    @Inject
    private static Logger logger;

    public ChkSubSgSbJisatuMenseki() {
        super();
    }

    public void exec(BizDate pHanteiKijyunYmd, BizDate pHkSknnKaisiYmd, JT_SiKykSyouhn pSiKykSyouhn,
        C_GeninKbn pGeninKbn, List<String> pByoumeiTourokuNoLst, C_UmuKbn pSateiKakSaigaiKanouseiKbn,
        JT_SkKihon pSkKihon, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 災害死亡自殺免責チェック 開始");

        boolean hanteiKekkaFlag;

        if (pHanteiKijyunYmd == null || pSiKykSyouhn == null) {

            hanteiKekkaFlag = false;

        } else {

            hanteiKekkaFlag = false;

            if (pHkSknnKaisiYmd == null) {

                BizDate dateHikaku = pSiKykSyouhn.getSknnkaisiymd().addYears(JISATUMENSEKINENSUU);
                if (BizDateUtil.compareYmd(dateHikaku, pHanteiKijyunYmd) == BizDateUtil.COMPARE_GREATER) {
                    hanteiKekkaFlag = true;
                }

            } else {

                if (BizDateUtil.compareYmd(pHkSknnKaisiYmd, pSiKykSyouhn.getSknnkaisiymd()) == BizDateUtil.COMPARE_GREATER) {

                    BizDate dateHikaku = pHkSknnKaisiYmd.addYears(JISATUMENSEKINENSUU);
                    if (BizDateUtil.compareYmd(dateHikaku, pHanteiKijyunYmd) == BizDateUtil.COMPARE_GREATER) {
                        hanteiKekkaFlag = true;
                    }

                } else {

                    BizDate dateHikaku = pSiKykSyouhn.getSknnkaisiymd().addYears(JISATUMENSEKINENSUU);
                    if (BizDateUtil.compareYmd(dateHikaku, pHanteiKijyunYmd) == BizDateUtil.COMPARE_GREATER) {
                        hanteiKekkaFlag = true;
                    }

                }

            }
        }

        if(hanteiKekkaFlag) {

            SaigaiGaitouHantei saigaiGaitouHantei = SWAKInjector.getInstance(SaigaiGaitouHantei.class);

            if (saigaiGaitouHantei.chkGeninkbn(pGeninKbn)) {

                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_SGSBJISATUMENSEKI_GENINKBN);
                pChkKekkaBeanLst.add(chkKekkaBean);
                logger.debug("△ 災害死亡自殺免責チェック 終了");
                return;
            }

            if (saigaiGaitouHantei.chkByoumei(pByoumeiTourokuNoLst, C_SKNaiyouChkKbn.SATEICHK_SGSBJISATUMENSEKI_BYOUMEI)) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_SGSBJISATUMENSEKI_BYOUMEI);
                pChkKekkaBeanLst.add(chkKekkaBean);
                logger.debug("△ 災害死亡自殺免責チェック 終了");
                return;

            }

            if (saigaiGaitouHantei.chkSateikaisou(pSateiKakSaigaiKanouseiKbn)) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_SGSBJISATUMENSEKI_KSYOUHI);
                pChkKekkaBeanLst.add(chkKekkaBean);
                logger.debug("△ 災害死亡自殺免責チェック 終了");
                return;
            }

            if (saigaiGaitouHantei.chkKyuusyorui(pSkKihon)) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_SGSBJISATUMENSEKI_SKSYORUI);
                pChkKekkaBeanLst.add(chkKekkaBean);
            }
        }

        logger.debug("△ 災害死亡自殺免責チェック 終了");
    }
}