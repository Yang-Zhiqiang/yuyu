package yuyu.common.siharai.koutei;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BzGetProcessRecord;
import yuyu.common.biz.bzcommon.BzGetProcessRecordBean;
import yuyu.common.biz.bzcommon.BzGetProcessRecordInputBean;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzProcessForward;
import yuyu.common.biz.koutei.BzProcessForwardInBean;
import yuyu.common.biz.koutei.CheckTaskKengen;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.classification.C_SikinouModeIdKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 保険金給付金支払 工程 支払工程遷移
 */
public class SiProcessForward {

    @Inject
    private BaseUserInfo userInfo;

    @Inject
    private BzProcessForward bzProcessForward;

    public SiProcessForward() {
        super();
    }

    public void exec(String pKouteiKanriId, String pJimuTetuzukiCd, String pKouteiLockKey,
        String pSyoriComment, SiRuleBean pSiRuleBean, String pTnsUserId) {

        String saiwariateUserId;

        if (C_SyorikekkaKbn.HORYUU.eq(pSiRuleBean.getSyoriKekkaKbn())) {
            saiwariateUserId = userInfo.getUserId();
        }
        else if (C_SyorikekkaKbn.TENSOU.eq(pSiRuleBean.getSyoriKekkaKbn())) {
            saiwariateUserId = pTnsUserId;
        }
        else {
            saiwariateUserId = "";
        }

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();

        bzGetProcessSummaryInBean.setKouteiKanriId(pKouteiKanriId);
        bzGetProcessSummaryInBean.setSyukouteiSiborikomiUmu(C_UmuKbn.NONE);

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);

        C_SikinouModeIdKbn hbBackName = null;
        if ((C_SyorikekkaKbn.HUSYOUNIN.eq(pSiRuleBean.getSyoriKekkaKbn()) || C_SyorikekkaKbn.SASIMODOSI.eq(pSiRuleBean
            .getSyoriKekkaKbn()))
            || C_SikinouModeIdKbn.HUBIKANRITYUU.toString().equals(bzGetProcessSummaryOutBeanLst.get(0).getNowNodoId())) {

            BzGetProcessRecord bzGetProcessRecord = SWAKInjector.getInstance(BzGetProcessRecord.class);
            BzGetProcessRecordInputBean bzGetProcessRecordInputBean = SWAKInjector
                .getInstance(BzGetProcessRecordInputBean.class);
            bzGetProcessRecordInputBean.setKouteiKanriId(bzGetProcessSummaryOutBeanLst.get(0).getKouteiKanriId());
            bzGetProcessRecordInputBean.setRirekiKbn(C_RirekiKbn.GYOUMU);
            List<BzGetProcessRecordBean> bzGetProcessRecordBeanLst = bzGetProcessRecord.exec(
                bzGetProcessRecordInputBean).getBzGetKouteiRirekiBeanLstLst();
            hbBackName = C_SikinouModeIdKbn.DEFAULT;
            C_SikinouModeIdKbn sikinouModeId = C_SikinouModeIdKbn.DEFAULT;

            if (C_SyorikekkaKbn.HUSYOUNIN.eq(pSiRuleBean.getSyoriKekkaKbn())
                || C_SyorikekkaKbn.SASIMODOSI.eq(pSiRuleBean.getSyoriKekkaKbn())) {
                if (C_SikinouModeIdKbn.SATEI2.toString().equals(bzGetProcessSummaryOutBeanLst.get(0).getNowNodoId())
                    ||
                    C_SikinouModeIdKbn.SATEI3.toString().equals(bzGetProcessSummaryOutBeanLst.get(0).getNowNodoId())
                    ||
                    C_SikinouModeIdKbn.SATEI4.toString().equals(bzGetProcessSummaryOutBeanLst.get(0).getNowNodoId())
                    ||
                    C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.toString().equals(bzGetProcessSummaryOutBeanLst.get(0).getNowNodoId())) {
                    sikinouModeId = C_SikinouModeIdKbn.SATEI1;
                }
                else if(C_SikinouModeIdKbn.TENKEN.toString().equals(bzGetProcessSummaryOutBeanLst.get(0).getNowNodoId())){
                    sikinouModeId = C_SikinouModeIdKbn.INPUT;
                }

                else if (C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.toString().equals(bzGetProcessSummaryOutBeanLst.get(0).getNowNodoId())) {
                    sikinouModeId = C_SikinouModeIdKbn.TETUDUKI_SATEIYOU;

                }
                else if (C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU.toString().equals(bzGetProcessSummaryOutBeanLst.get(0).getNowNodoId())
                    ||
                    C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU.toString().equals(bzGetProcessSummaryOutBeanLst.get(0).getNowNodoId())) {
                    sikinouModeId = C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU;

                }
                else if (C_SikinouModeIdKbn.SESSYOU2.toString().equals(bzGetProcessSummaryOutBeanLst.get(0).getNowNodoId())) {
                    sikinouModeId = C_SikinouModeIdKbn.SESSYOU1;

                }
                else if (C_SikinouModeIdKbn.HUBISYOUNIN.toString().equals(bzGetProcessSummaryOutBeanLst.get(0).getNowNodoId())) {
                    sikinouModeId = C_SikinouModeIdKbn.HUBITOUROKU;

                }

                saiwariateUserId = getSasimodosisakiKojinTaskUserId(bzGetProcessRecordBeanLst, sikinouModeId);

                CheckTaskKengen checkTaskKengen = SWAKInjector.getInstance(CheckTaskKengen.class);
                if (!checkTaskKengen.exec(saiwariateUserId, pJimuTetuzukiCd, sikinouModeId.toString())){
                    saiwariateUserId = "";
                }

            }
            else if (C_SikinouModeIdKbn.HUBIKANRITYUU.toString().equals(bzGetProcessSummaryOutBeanLst.get(0).getNowNodoId())) {

                sikinouModeId = getFubiModorijiModosisakiNodeId(bzGetProcessRecordBeanLst);
                hbBackName = sikinouModeId;

            }
        }

        SiIwfApiRuleBean siIwfApiRuleBean = new SiIwfApiRuleBean();
        siIwfApiRuleBean.setSyoriKekkaNaiyou(pSiRuleBean.getSyoriKekkaKbn().getContent());
        siIwfApiRuleBean.setSateiYhNaiyou(pSiRuleBean.getSateiYhKbn().getContent());
        siIwfApiRuleBean.setSessyouYhNaiyou(pSiRuleBean.getSessyouYhKbn().getContent());
        siIwfApiRuleBean.setSateiSanjiKaisouUmuNaiyou(pSiRuleBean.getSateiSanjiKaisouUmuKbn().getContent());
        if (hbBackName != null) {
            siIwfApiRuleBean.setHubiModorijiSenisakiNodeNm(hbBackName.getContent());

        }

        BzProcessForwardInBean bzProcessForwardInBean = new BzProcessForwardInBean();
        bzProcessForwardInBean.setKouteiKanriId(pKouteiKanriId);
        bzProcessForwardInBean.setJimuTetuzukiCd(pJimuTetuzukiCd);
        bzProcessForwardInBean.setKouteiLockKey(pKouteiLockKey);
        bzProcessForwardInBean.setSyoriComment(pSyoriComment);
        bzProcessForwardInBean.setIwfApiRuleBean(siIwfApiRuleBean);
        bzProcessForwardInBean.setSyorikekkaKbn(pSiRuleBean.getSyoriKekkaKbn());
        bzProcessForwardInBean.setSaiwariateUserId(saiwariateUserId);

        bzProcessForward.exec(bzProcessForwardInBean);

    }

    private C_SikinouModeIdKbn getFubiModorijiModosisakiNodeId(List<BzGetProcessRecordBean> pBzGetProcessRecordBeanLst) {

        C_SikinouModeIdKbn sikinouModeIdKbn = C_SikinouModeIdKbn.DEFAULT;

        if (pBzGetProcessRecordBeanLst.size() > 1) {
            for (BzGetProcessRecordBean bzGetProcessRecordBean : pBzGetProcessRecordBeanLst) {
                if (!C_SikinouModeIdKbn.HUBIKANRITYUU.eq(C_SikinouModeIdKbn.valueOf(bzGetProcessRecordBean
                    .getTasknmId()))) {
                    if (C_SikinouModeIdKbn.SATEI1.eq(C_SikinouModeIdKbn.valueOf(bzGetProcessRecordBean
                        .getTasknmId()))
                        ||
                        C_SikinouModeIdKbn.SATEI2.eq(C_SikinouModeIdKbn.valueOf(bzGetProcessRecordBean
                            .getTasknmId()))
                        ) {
                        sikinouModeIdKbn = C_SikinouModeIdKbn.SATEI1;

                    }
                    else if (C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.eq(C_SikinouModeIdKbn
                        .valueOf(bzGetProcessRecordBean.getTasknmId()))
                        ) {
                        sikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIYOU;

                    }
                    else if (C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU.eq(C_SikinouModeIdKbn
                        .valueOf(bzGetProcessRecordBean.getTasknmId()))) {
                        sikinouModeIdKbn = C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU;

                    }
                    break;
                }
            }
        }
        return sikinouModeIdKbn;
    }

    private String getSasimodosisakiKojinTaskUserId(List<BzGetProcessRecordBean> pBzGetProcessRecordBeanLst,
        C_SikinouModeIdKbn pSikinouModeId) {
        String accountId = "";

        List<String> sikinouModeIds = new ArrayList<String>();
        sikinouModeIds.add(pSikinouModeId.toString());
        if(C_SikinouModeIdKbn.INPUT.eq(pSikinouModeId) || C_SikinouModeIdKbn.HUBITOUROKU.eq(pSikinouModeId)){
            sikinouModeIds.add(TeisuuSiharai.NODEID_START);
        }

        for (BzGetProcessRecordBean bzGetProcessRecordBean : pBzGetProcessRecordBeanLst) {
            if (sikinouModeIds.contains(bzGetProcessRecordBean.getTasknmId())) {
                accountId = bzGetProcessRecordBean.getUserId();
                break;
            }
        }
        return accountId;
    }
}
