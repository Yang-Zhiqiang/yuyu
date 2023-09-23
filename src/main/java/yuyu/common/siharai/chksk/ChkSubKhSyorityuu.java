package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryComparatorWorkListHyoujijun;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JM_ChkSiJimuttdk;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.siharai.manager.SiharaiDomManager;

/**
 * 保険金給付金支払 請求内容チェック 契約保全処理中チェック
 */
public class ChkSubKhSyorityuu {

    @Inject
    private static Logger logger;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private BzGetProcessSummaryComparatorWorkListHyoujijun bzGetProcessSummaryComparatorWorkListHyoujijun;

    public ChkSubKhSyorityuu() {
        super();
    }

    public void exec(JT_SiKykKihon pSiKykKihon, String pKinouId, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 契約保全処理中チェック 開始");

        chkKeiyakuhozenSyorityuu(pSiKykKihon.getSyono(), pKinouId, pChkKekkaBeanLst);

        logger.debug("△ 契約保全処理中チェック 終了");

    }

    private void chkKeiyakuhozenSyorityuu(String pSyoNo, String pKinouId, List<ChkKekkaBean> pChkKekkaBeanLst) {

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setSyoNo(pSyoNo);
        bzGetProcessSummaryInBean.setSubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);
        bzGetProcessSummaryInBean.setSyukouteiSiborikomiUmu(C_UmuKbn.NONE);
        bzGetProcessSummaryInBean.setBzGetProcessSummaryComparator(bzGetProcessSummaryComparatorWorkListHyoujijun);
        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);

        for (BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean : bzGetProcessSummaryOutBeanLst) {

            JM_ChkSiJimuttdk chkSiJimuttdk = siharaiDomManager.getChkSiJimuttdk(pKinouId,
                bzGetProcessSummaryOutBean.getJimuTetuzukiCd());

            if (chkSiJimuttdk != null) {
                if (bzGetProcessSummaryOutBean.getJimuStartYmd() != null) {

                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);

                    chkKekkaBean.setSKNaiyouChkKbn(chkSiJimuttdk.getSknaiyouchkkbn());
                    chkKekkaBean.setMsgHikisuu1(bzGetProcessSummaryOutBean.getJimuTetuzukiNm());

                    pChkKekkaBeanLst.add(chkKekkaBean);
                }
            }
        }

    }
}
