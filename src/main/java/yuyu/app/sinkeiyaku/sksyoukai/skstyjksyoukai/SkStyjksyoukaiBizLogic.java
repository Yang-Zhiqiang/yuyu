package yuyu.app.sinkeiyaku.sksyoukai.skstyjksyoukai;

import static yuyu.app.sinkeiyaku.sksyoukai.skstyjksyoukai.SkStyjksyoukaiConstants.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;

import org.slf4j.Logger;

import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetProcessRecord;
import yuyu.common.biz.bzcommon.BzGetProcessRecordBean;
import yuyu.common.biz.bzcommon.BzGetProcessRecordInputBean;
import yuyu.common.biz.bzcommon.BzGetProcessRecordOutputBean;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.def.MessageId;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_JimusrhKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.db.entity.DM_JimutetuzukiTask;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHT_SkHubiDetail;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.def.workflow.sorter.SortDM_JimutetuzukiTask;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 * 進捗状況照会 のビジネスロジックです。
 */
public class SkStyjksyoukaiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SkStyjksyoukaiUiBean uiBean;

    @Inject
    private WorkflowDomManager workflowDomManager;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    void init() {

        BizPropertyInitializer.initialize(uiBean);

        DM_Jimutetuzuki jimutetuzuki = workflowDomManager.getJimutetuzuki(
            ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN,ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU);

        List<DM_JimutetuzukiTask> jimutetuzukiTaskLst = jimutetuzuki.getJimutetuzukiTasks();

        SortDM_JimutetuzukiTask sortDM_JimutetuzukiTask = SWAKInjector.getInstance(SortDM_JimutetuzukiTask.class);

        List<DM_JimutetuzukiTask> newJimutetuzukiTaskLst =
            sortDM_JimutetuzukiTask.OrderDM_JimutetuzukiTaskByJimutetuzukicdHyoujijyunAsc(jimutetuzukiTaskLst);


        UserDefsList srchNowkinoussNmLst = new UserDefsList();
        LabelValuePair pair = new LabelValuePair();
        pair.setLabel("");
        pair.setValue("");
        srchNowkinoussNmLst.add(pair);

        for (DM_JimutetuzukiTask jimutetuzukiTask : newJimutetuzukiTaskLst) {
            pair = new LabelValuePair();

            pair.setLabel(jimutetuzukiTask.getWorkflowTskNm());
            pair.setValue(jimutetuzukiTask.getWorkflowTskId());

            srchNowkinoussNmLst.add(pair);
        }

        uiBean.setSrchnowkinoussnmOptionBeanList(srchNowkinoussNmLst);
    }

    void clear() {
    }

    void pushSearchBL() {

        if (uiBean.getSrchjimustartymdfrom() != null  && uiBean.getSrchjimustartymdto() != null) {
            if (BizDateUtil.compareYmd(uiBean.getSrchjimustartymdfrom(),
                uiBean.getSrchjimustartymdto()) == BizDateUtil.COMPARE_GREATER) {
                throw new BizLogicException(MessageId.EHA0301,MESSAGE_JIMU_START_YMD_FROM,MESSAGE_JIMU_START_YMD_TO);
            }
        }

        List<BzGetProcessSummaryOutBean> getProcessSummaryOutBeanLst = getSkstyjksyoukaiLst();

        List<SearchResultsDataSourceBean> sourceBeanLst = Lists.newArrayList();
        String dispTratkiagCd = null;
        String dispTratkiagNm = null;
        String dispOyadrtenCd = null;
        String dispOyadrtenNm = null;
        C_UmuKbn dispHubiumu = null;
        BizDate dispTrkYmd = null;
        BizDate dispHassinYmd = null;
        BizDate dispKaisyouYmd = null;
        C_UmuKbn dispNyknumuKbn = null;
        C_Hrkkeiro dispHrkkeiro = null;
        C_JimusrhKbn dispJimusrhKbn = null;
        BizDate dispLastkosYmd = null;
        String dispLastkosSyori = null;


        for (BzGetProcessSummaryOutBean summaryOutBean : getProcessSummaryOutBeanLst) {
            dispTratkiagCd = "";
            dispTratkiagNm = "";
            dispOyadrtenCd = "";
            dispOyadrtenNm = "";
            dispHubiumu = C_UmuKbn.NONE;
            dispTrkYmd = null;
            dispHassinYmd = null;
            dispKaisyouYmd = null;
            dispNyknumuKbn = C_UmuKbn.NONE;
            dispHrkkeiro = C_Hrkkeiro.BLNK;
            dispJimusrhKbn = C_JimusrhKbn.NONE;
            dispLastkosYmd = null;
            dispLastkosSyori = "";

            BzGetProcessRecordBean getProcessRecordBean = getProcessHistory(summaryOutBean.getKouteiKanriId());

            if (getProcessRecordBean != null) {
                dispLastkosYmd = BizDate.valueOf(getProcessRecordBean.getSyoriTime().substring(0, 8));
                dispLastkosSyori = getProcessRecordBean.getTasknm();
            }

            HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(summaryOutBean.getMosNo());

            if (syoriCTL != null) {
                if (C_UmuKbn.ARI.eq(syoriCTL.getKthhbkbn()) ||
                    C_UmuKbn.ARI.eq(syoriCTL.getSrhhbkbn()) ||
                    C_UmuKbn.ARI.eq(syoriCTL.getKhnhbkbn())) {

                    dispHubiumu = C_UmuKbn.ARI;
                }

                dispNyknumuKbn = syoriCTL.getNyknnrkumu();
                dispJimusrhKbn = syoriCTL.getJimusrhkbn();

                HT_MosKihon mosKihon = syoriCTL.getMosKihon();

                if (mosKihon != null) {
                    dispHrkkeiro = mosKihon.getHrkkeiro();
                }

                HT_MosDairiten mosDairiten = syoriCTL.getMosDairitenByRenno(1);

                if (mosDairiten != null) {

                    BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

                    List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(mosDairiten.getTratkiagcd());

                    for (BzGetAgInfoBean infoBean : bzGetAgInfoBeanList) {
                        if (C_DiritenjyouhouKbn.KEISYOUKO.eq(infoBean.getDiritenJyouhouKbn())) {
                            dispTratkiagCd = infoBean.getDrtenCd();
                            dispTratkiagNm = infoBean.getKanjiDairitenNm();
                        }
                        else if (C_DiritenjyouhouKbn.KEISYOUOYA.eq(infoBean.getDiritenJyouhouKbn())) {
                            dispOyadrtenCd = infoBean.getDrtenCd();
                            dispOyadrtenNm = infoBean.getKanjiDairitenNm();
                        }
                    }
                }

                BzGetProcessSummaryInBean getProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

                getProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBITOUROKU);
                getProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
                getProcessSummaryInBean.setMosNo(summaryOutBean.getMosNo());

                BzGetProcessSummary getProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

                List<BzGetProcessSummaryOutBean> summaryOutBeanLst = getProcessSummary.exec(getProcessSummaryInBean);

                if (summaryOutBeanLst.size() != 0) {
                    HT_SkHubi skHubi = syoriCTL.getSkHubiByHubisikibetukey(summaryOutBeanLst.get(0).getKouteiKanriId());

                    if (skHubi != null) {
                        List<HT_SkHubiDetail> skHubiDetailLst = skHubi.getSkHubiDetailsByTrkymdNotNull();

                        if (skHubiDetailLst != null && skHubiDetailLst.size() > 0) {

                            SortHT_SkHubiDetail sortHT_SkHubiDetail = SWAKInjector.getInstance(SortHT_SkHubiDetail.class);

                            List<HT_SkHubiDetail> sortDetailLst = sortHT_SkHubiDetail.OrderHT_SkHubiDetailByPkDesc(skHubiDetailLst);

                            dispTrkYmd = sortDetailLst.get(0).getTrkymd();
                            dispHassinYmd = sortDetailLst.get(0).getHasinymd();
                            dispKaisyouYmd = sortDetailLst.get(0).getKaisyouymd();
                        }
                    }
                }
            }

            SearchResultsDataSourceBean sourceBean = SWAKInjector.getInstance(SearchResultsDataSourceBean.class);

            sourceBean.setDispjimustartymdtime(summaryOutBean.getJimuStartYmdTime());
            sourceBean.setDispmosno(summaryOutBean.getMosNo());
            sourceBean.setDispkinoussnm(summaryOutBean.getNowNodoNm());
            sourceBean.setDisptratkiagcd(dispTratkiagCd);
            sourceBean.setDisptratkiagnm(dispTratkiagNm);
            sourceBean.setDispoyadrtencd(dispOyadrtenCd);
            sourceBean.setDispoyadrtennm(dispOyadrtenNm);
            sourceBean.setDisphubiumu(dispHubiumu);
            sourceBean.setDisptrkymd(dispTrkYmd);
            sourceBean.setDisphassinymd(dispHassinYmd);
            sourceBean.setDispkaisyouymd(dispKaisyouYmd);
            sourceBean.setDispnyknumukbn(dispNyknumuKbn);
            sourceBean.setDisphrkkeiro(dispHrkkeiro);
            sourceBean.setDispketteikbn(summaryOutBean.getKetteiKbn());
            sourceBean.setDispjimusrhkbn(dispJimusrhKbn);
            sourceBean.setDispseiritukbn(summaryOutBean.getSeirituKbn());
            sourceBean.setDispsyoriymd(dispLastkosYmd);
            sourceBean.setDisplastkossyori(dispLastkosSyori);

            sourceBeanLst.add(sourceBean);
        }

        Ordering<SearchResultsDataSourceBean> ordering = Ordering.from(new SelectDataListComparator());
        sourceBeanLst = ordering.sortedCopy(sourceBeanLst);

        List<SearchResultsDataSourceBean> newSourceBeanLst = Lists.newArrayList();

        for (SearchResultsDataSourceBean sourceBean : sourceBeanLst) {

            SearchResultsDataSourceBean newSourceBean = SWAKInjector.getInstance(SearchResultsDataSourceBean.class);

            BeanUtil.copyProperties(newSourceBean, sourceBean);

            String dispjimustartymdtime = "";

            try {

                dispjimustartymdtime = DefaultDateFormatter.formatYMDHMSZeroFill(sourceBean.getDispjimustartymdtime());

            } catch (BizAppException exception) {
            }

            newSourceBean.setDispjimustartymdtime(dispjimustartymdtime);

            newSourceBeanLst.add(newSourceBean);

        }

        uiBean.setSearchResults(newSourceBeanLst);
    }



    private List<BzGetProcessSummaryOutBean> getSkstyjksyoukaiLst() {

        List<BzGetProcessSummaryOutBean> getProcessSummaryOutBeanLst = Lists.newArrayList();

        String srchJimuStartYmdFrom = null;
        String srchJimuStartYmdTo = null;

        if (uiBean.getSrchjimustartymdfrom() != null || uiBean.getSrchjimustartymdto() != null) {
            if (uiBean.getSrchjimustartymdfrom() == null) {
                srchJimuStartYmdFrom = "19700101";
                srchJimuStartYmdTo = uiBean.getSrchjimustartymdto().toString();
            }
            else if (uiBean.getSrchjimustartymdto() == null) {
                srchJimuStartYmdFrom = uiBean.getSrchjimustartymdfrom().toString();
                srchJimuStartYmdTo = "99991231";
            }
            else {
                srchJimuStartYmdFrom = uiBean.getSrchjimustartymdfrom().toString();
                srchJimuStartYmdTo = uiBean.getSrchjimustartymdto().toString();
            }
        }

        String taskId = null;

        if (!BizUtil.isBlank(uiBean.getSrchnowkinoussnm())) {
            taskId =uiBean.getSrchnowkinoussnm();
        }

        BzGetProcessSummaryInBean getProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        getProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        getProcessSummaryInBean.setJimuKaisiYmdFrom(srchJimuStartYmdFrom);
        getProcessSummaryInBean.setJimuKaisiYmdTo(srchJimuStartYmdTo);
        getProcessSummaryInBean.setTaskIds(null);
        getProcessSummaryInBean.setTaskId(taskId);
        getProcessSummaryInBean.setMosNo(uiBean.getSrchmosno());
        getProcessSummaryInBean.setSubSystemId(ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU);
        getProcessSummaryInBean.setKetteiKbn(uiBean.getSrchketteikbn());
        getProcessSummaryInBean.setSeirituKbn(uiBean.getSrchseiritukbn());
        if (uiBean.getSrchlincjkjknumu()) {
            C_LincjkKbn [] lincjkKbn = {
                C_LincjkKbn.MIHANTEI,
                C_LincjkKbn.SYOUKAITAISYOUGAI,
                C_LincjkKbn.SYOUKAIMATI,
                C_LincjkKbn.KAITOARI_TASYANASI,
                C_LincjkKbn.KAITOARI_TASYAARI
            };
            getProcessSummaryInBean.setLincjkKbn(lincjkKbn);
        }
        getProcessSummaryInBean.setKekkajyougenkensu(String.valueOf(DATA_LIMIT_COUNT));

        BzGetProcessSummary getProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);

        try {

            getProcessSummaryOutBeanLst = getProcessSummary.exec(getProcessSummaryInBean);

        } catch (BizAppException exception) {

            if (MessageUtil.getMessage(MessageId.EBS1010).equals(exception.getLocalizedMessage())) {

                throw new BizLogicException(MessageId.EHA0361,String.valueOf(DATA_LIMIT_COUNT));
            }

            throw exception;
        }

        if (getProcessSummaryOutBeanLst.size() == 0) {

            throw new BizLogicException(MessageId.EBA0090);
        }

        return getProcessSummaryOutBeanLst;
    }


    private BzGetProcessRecordBean getProcessHistory (String pKouteikanriId) {

        BzGetProcessRecordBean getProcessRecordBean = null;

        BzGetProcessRecordInputBean getProcessRecordInputBean = SWAKInjector.getInstance(BzGetProcessRecordInputBean.class);

        getProcessRecordInputBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        getProcessRecordInputBean.setKouteiKanriId(pKouteikanriId);
        getProcessRecordInputBean.setRirekiKbn(C_RirekiKbn.GYOUMU);

        BzGetProcessRecord getProcessRecord = SWAKInjector.getInstance(BzGetProcessRecord.class);

        BzGetProcessRecordOutputBean getProcessRecordOutputBean = getProcessRecord.exec(getProcessRecordInputBean);

        List<BzGetProcessRecordBean> getProcessRecordBeanLst = getProcessRecordOutputBean.getBzGetKouteiRirekiBeanLstLst();

        if (getProcessRecordBeanLst.size() != 0) {
            getProcessRecordBean = getProcessRecordBeanLst.get(0);
        }

        return getProcessRecordBean;
    }
}
