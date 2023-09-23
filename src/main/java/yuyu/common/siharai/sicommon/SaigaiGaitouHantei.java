package yuyu.common.siharai.sicommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BzGetImageProps;
import yuyu.common.biz.bzcommon.BzGetImagePropsInBean;
import yuyu.common.biz.bzcommon.BzGetImagePropsOutBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ByoumeiGaitouKbn2;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.JM_Byoumei;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.siharai.manager.SiharaiDomManager;

/**
 * 保険金給付金支払 保険金給付金支払共通 災害該当判定クラス
 */
public class SaigaiGaitouHantei {

    @Inject
    private static Logger logger;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private BizDomManager bizDomManager;

    public SaigaiGaitouHantei() {
        super();
    }

    public boolean chkGeninkbn(C_GeninKbn pGeninKbn) {

        logger.debug("▽ 災害該当判定（原因区分） 開始");

        if (pGeninKbn == null) {

            logger.debug("△ 災害該当判定（原因区分） 終了");
            return false;

        }

        if (C_GeninKbn.KTJK.eq(pGeninKbn) ||
            C_GeninKbn.TENTOU.eq(pGeninKbn) ||
            C_GeninKbn.DKS.eq(pGeninKbn) ||
            C_GeninKbn.KKOKS.eq(pGeninKbn) ||
            C_GeninKbn.TSK.eq(pGeninKbn) ||
            C_GeninKbn.TDK.eq(pGeninKbn) ||
            C_GeninKbn.SONOTAFR.eq(pGeninKbn) ||
            C_GeninKbn.TST.eq(pGeninKbn)) {

            logger.debug("△ 災害該当判定（原因区分） 終了");
            return true;
        }

        logger.debug("△ 災害該当判定（原因区分） 終了");
        return false;
    }

    public boolean chkByoumei(List<String> pByoumeiTourokuNoLst, C_SKNaiyouChkKbn pSKNaiyouChkKbn) {

        logger.debug("▽ 災害該当判定（病名） 開始");

        if (pByoumeiTourokuNoLst == null) {

            logger.debug("△ 災害該当判定（病名） 終了");
            return false;
        }

        for (String byoumeiTourokuNo : pByoumeiTourokuNoLst) {
            JM_Byoumei byoumei = siharaiDomManager.getByoumei(byoumeiTourokuNo);

            if (C_SKNaiyouChkKbn.SATEICHK_SGSBJISATUMENSEKI_BYOUMEI.eq(pSKNaiyouChkKbn)) {
                if (C_ByoumeiGaitouKbn2.SAIGAI.eq(byoumei.getGaitoukbn2())) {

                    logger.debug("△ 災害該当判定（病名） 終了");
                    return true;
                }

            } else if (C_SKNaiyouChkKbn.SATEICHK_SAIGAI_BYOUMEI.eq(pSKNaiyouChkKbn)) {
                if (C_ByoumeiGaitouKbn2.KANSENSYOU.eq(byoumei.getGaitoukbn2()) ||
                    C_ByoumeiGaitouKbn2.SAIGAI.eq(byoumei.getGaitoukbn2())) {

                    logger.debug("△ 災害該当判定（病名） 終了");
                    return true;
                }
            }
        }

        logger.debug("△ 災害該当判定（病名） 終了");
        return false;
    }

    public boolean chkSateikaisou(C_UmuKbn pSateiKakSaigaiKanouseiKbn) {

        logger.debug("▽ 災害該当判定（査定回送要否） 開始");

        if (pSateiKakSaigaiKanouseiKbn == null) {

            logger.debug("△ 災害該当判定（査定回送要否） 終了");
            return false;

        }

        if (C_UmuKbn.ARI.eq(pSateiKakSaigaiKanouseiKbn)) {

            logger.debug("△ 災害該当判定（査定回送要否） 終了");
            return true;
        }

        logger.debug("△ 災害該当判定（査定回送要否） 終了");
        return false;
    }

    public boolean chkKyuusyorui(JT_SkKihon pSkKihon) {

        logger.debug("▽ 災害該当判定（請求書類） 開始");

        if (pSkKihon == null) {

            logger.debug("△ 災害該当判定（請求書類） 終了");
            return false;

        }
        List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = bizDomManager.getGyoumuKouteiInfosByJimutetuzukicdSyonoSkno(
            TeisuuSiharai.JIMUTETUZUKICD_SISIBOU, pSkKihon.getSyono(), pSkKihon.getSkno());

        if (gyoumuKouteiInfoLst.size() > 0) {
            BzGetImageProps bzGetImageProps = SWAKInjector.getInstance(BzGetImageProps.class);
            BzGetImagePropsInBean bzGetImagePropsInBean = SWAKInjector.getInstance(BzGetImagePropsInBean.class);


            bzGetImagePropsInBean.setJimuTetuzukiCd(null);
            bzGetImagePropsInBean.setKouteiKanriId(gyoumuKouteiInfoLst.get(0).getKouteikanriid());
            bzGetImagePropsInBean.setSyoruiCd(C_SyoruiCdKbn.HK_KD_JIKOJKS);
            bzGetImagePropsInBean.setSyoruiTtykYmdTimeFrom(null);
            bzGetImagePropsInBean.setSyoruiTtykYmdTimeTo(null);
            bzGetImagePropsInBean.setKouteiKanriStatus(null);

            BzGetImagePropsOutBean bzGetImagePropsOutBean = bzGetImageProps.exec(bzGetImagePropsInBean);

            if (bzGetImagePropsOutBean.getBzGetImagePropsBeanLst() != null &&
                bzGetImagePropsOutBean.getBzGetImagePropsBeanLst().size() > 0) {

                logger.debug("△ 災害該当判定（請求書類） 終了");
                return true;
            }
        }

        logger.debug("△ 災害該当判定（請求書類） 終了");
        return false;
    }

}
