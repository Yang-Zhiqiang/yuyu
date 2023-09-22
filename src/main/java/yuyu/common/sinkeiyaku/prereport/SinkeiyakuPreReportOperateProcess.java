package yuyu.common.sinkeiyaku.prereport;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.koutei.BzOutputProcessRecord;
import yuyu.common.biz.prereport.PreReportOperateProcess;
import yuyu.common.sinkeiyaku.koutei.SkProcessCreate;
import yuyu.common.sinkeiyaku.koutei.SkProcessCreateInBean;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst.WSGetTorikomiSyoruiMstResponse.TorikomiSyoruiBean;
import yuyu.def.classification.C_KouteiSakuseiKeikiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.BM_TorikomiSyoruiHukaInfo;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 新契約 帳票前処理 新契約帳票作成前工程操作処理
 */
public class SinkeiyakuPreReportOperateProcess extends PreReportOperateProcess{

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private SinkeiyakuPreReportRenkeiBean skPreReportRenkeiBean;

    @Override
    public String operateProcess(TorikomiSyoruiBean pTorikomiSyoruiMstBean,
        BM_TorikomiSyoruiHukaInfo pTorikomiSyoruiHukaInfoBean, ReportServicesBean pRsBean) {

        String kouteiKanriId = "";

        if (!C_KouteiSakuseiKeikiKbn.SYORUI_SAKUSEIJI.eq(pTorikomiSyoruiHukaInfoBean.getKouteisakuseikeiki())) {

            return kouteiKanriId;
        }

        if (BizUtil.isBlank(skPreReportRenkeiBean.getSakuseizumiKouteikanriId())) {

            BzGetProcessSummaryInBean bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();
            bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
            bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
            bzGetProcessSummaryInBean.setMosNo(skPreReportRenkeiBean.getMosNo());

            BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
            List<BzGetProcessSummaryOutBean> bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);

            if (bzGetProcessSummaryOutBeanLst.isEmpty()) {
                HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(skPreReportRenkeiBean.getMosNo());

                if (syoriCTL != null) {
                    bzGetProcessSummaryInBean = new BzGetProcessSummaryInBean();

                    bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
                    bzGetProcessSummaryInBean.setSyoNo(syoriCTL.getSyono());

                    bzGetProcessSummaryOutBeanLst = bzGetProcessSummary.exec(bzGetProcessSummaryInBean);
                }
            }

            if (bzGetProcessSummaryOutBeanLst.isEmpty()) {

                return kouteiKanriId;
            }

            BzGetProcessSummaryOutBean bzGetProcessSummaryOutBean = bzGetProcessSummaryOutBeanLst.get(0);

            kouteiKanriId = bzGetProcessSummaryOutBean.getKouteiKanriId();

            String jimuTetuzukiCd = getJimuTetuzukiCd(pTorikomiSyoruiHukaInfoBean.getSyoruiCd());
            String taskNm = getTaskNm(pTorikomiSyoruiMstBean.getTorikomisyoruinm(), jimuTetuzukiCd);

            SkProcessCreateInBean skProcessCreateInBean = new SkProcessCreateInBean();
            skProcessCreateInBean.setSkeiJimuKbn(bzGetProcessSummaryOutBean.getSkeijimuKbn());
            skProcessCreateInBean.setMosUketukeKbn(bzGetProcessSummaryOutBean.getMosUketukeKbn());
            skProcessCreateInBean.setHknSyuruiNo(bzGetProcessSummaryOutBean.getHknsyuruiNo());
            skProcessCreateInBean.setDairitenCd1(bzGetProcessSummaryOutBean.getDairitencd1());
            skProcessCreateInBean.setDairitenCd2(bzGetProcessSummaryOutBean.getDairitencd2());
            skProcessCreateInBean.setJimuyouCd(bzGetProcessSummaryOutBean.getJimuyoucd());
            skProcessCreateInBean.setJmycdMisetteiKbn(bzGetProcessSummaryOutBean.getJmycdMisetteiKbn());
            skProcessCreateInBean.setDoujimosUmu(bzGetProcessSummaryOutBean.getDoujimosumu());
            skProcessCreateInBean.setMosYmd(bzGetProcessSummaryOutBean.getMosymd());
            skProcessCreateInBean.setJimuStartYmd(bzGetProcessSummaryOutBean.getJimuStartYmdTime());
            skProcessCreateInBean.setSyoNo(bzGetProcessSummaryOutBean.getSkNo());
            skProcessCreateInBean.setMosNo(bzGetProcessSummaryOutBean.getMosNo());
            skProcessCreateInBean.setJimuTetuzukiCd(jimuTetuzukiCd);

            SkProcessCreate skProcessCreate = SWAKInjector.getInstance(SkProcessCreate.class);
            skProcessCreate.exec(skProcessCreateInBean);

            BzOutputProcessRecord bzOutputProcessRecord = SWAKInjector.getInstance(BzOutputProcessRecord.class);
            bzOutputProcessRecord.exec(bzGetProcessSummaryOutBean.getKouteiKanriId(),
                bzGetProcessSummaryOutBean.getJimuTetuzukiCd(),
                skPreReportRenkeiBean.getSyoriComment(),
                taskNm,
                C_SyorikekkaKbn.KANRYOU);

            skPreReportRenkeiBean.setSakuseizumiKouteikanriId(kouteiKanriId);
        }
        else {
            kouteiKanriId = skPreReportRenkeiBean.getSakuseizumiKouteikanriId();
        }

        return kouteiKanriId;
    }

    private String getJimuTetuzukiCd(C_SyoruiCdKbn pSyoruiCdKbn) {
        String jimuTetuzukiCd = "";

        if (C_SyoruiCdKbn.SK_HUBITUUTI.eq(pSyoruiCdKbn)) {

            jimuTetuzukiCd = ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU;
        }
        else if (C_SyoruiCdKbn.SK_KYKKAKUNINIRAISYO.eq(pSyoruiCdKbn)) {

            jimuTetuzukiCd = ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN;
        }
        else if (C_SyoruiCdKbn.SK_TRKSSEIKYU.eq(pSyoruiCdKbn)) {

            jimuTetuzukiCd = ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI;
        }
        else if (C_SyoruiCdKbn.SK_HENKINIRAISYO.eq(pSyoruiCdKbn)) {

            jimuTetuzukiCd = ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN;
        }

        return jimuTetuzukiCd;
    }

    private String getTaskNm(String pSyoruiNm, String pJimuTetuzukiCd) {
        String taskNm = "";

        if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU.equals(pJimuTetuzukiCd)) {

            taskNm = pSyoruiNm + "作成";
        }
        else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN.equals(pJimuTetuzukiCd)) {

            taskNm = pSyoruiNm + "作成";
        }
        else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI.equals(pJimuTetuzukiCd)) {

            taskNm = pSyoruiNm + "作成";
        }
        else if (ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN.equals(pJimuTetuzukiCd)) {

            taskNm = pSyoruiNm + "作成";
        }

        return taskNm;
    }
}
