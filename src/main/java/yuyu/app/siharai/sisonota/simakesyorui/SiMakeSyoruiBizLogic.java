package yuyu.app.siharai.sisonota.simakesyorui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.SWAK;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import com.lowagie.text.pdf.PdfReader;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoKekkaBean;
import yuyu.common.biz.bzcommon.BzHanteiSosikiUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryOutBean;
import yuyu.common.biz.prereport.GetQRCode;
import yuyu.common.biz.prereport.SyoruiToutyakuYoteiTouroku;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.common.siharai.prereport.SiharaiPreReportRenkeiBean;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.common.siharai.siedittyouhyou.EditDaihyousennintodoke;
import yuyu.common.siharai.siedittyouhyou.EditDaihyousennintodokeBean;
import yuyu.common.siharai.siedittyouhyou.EditJikojyokyouhoukokusyo;
import yuyu.common.siharai.siedittyouhyou.EditJikojyokyouhoukokusyoBean;
import yuyu.common.siharai.siedittyouhyou.EditMynumberC;
import yuyu.common.siharai.siedittyouhyou.EditMynumberCBean;
import yuyu.common.siharai.siedittyouhyou.EditSeikyuusyo;
import yuyu.common.siharai.siedittyouhyou.EditSeikyuusyoBean;
import yuyu.common.siharai.siedittyouhyou.EditSeisankinhurikomiiraisyo;
import yuyu.common.siharai.siedittyouhyou.EditSeisankinhurikomiiraisyoBean;
import yuyu.common.siharai.siedittyouhyou.SeikyuusyaInfoBean;
import yuyu.common.siharai.siedittyouhyou.SiTyouhyouHensyuuCommonBean;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SiSyoruisakuseiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.siharai.configuration.YuyuSiharaiConfig;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.DBAOutputReport;
import yuyu.infr.report.OutputReport;
import yuyu.infr.report.PdfBuilder;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 保険金給付金書類作成 のビジネスロジックです。
 */
public class SiMakeSyoruiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SiMakeSyoruiUiBean uiBean;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SiharaiPreReportRenkeiBean siharaiPreReportRenkeiBean;

    @Inject
    private CreateReport createReport;

    @Inject
    private DBAOutputReport dbaOutputReport;

    @Inject
    private OutputReport outputReport;

    void init() {
        String toritugisyaKojinCd = null;
        String toritugisyaKojinNm = null;
        String toritugisyaSosikiNm = null;

        String tntSosikiCd = baseUserInfo.getTmSosikiCd();
        boolean ccFlag = BzHanteiSosikiUtil.isCallcenterKeySosikicd(tntSosikiCd);
        if (ccFlag) {

            toritugisyaKojinCd = SiMakeSyoruiConstants.BLNK;
            toritugisyaKojinNm = SiMakeSyoruiConstants.BLNK;
            toritugisyaSosikiNm = baseUserInfo.getTmSosikiNm();

        } else {
            BzGetSosikiMadogutiInfo getSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);
            BzGetSosikiMadogutiInfoKekkaBean bzGetSosikiMadogutiInfoKekkaBean = getSosikiMadogutiInfo.exec(tntSosikiCd);

            toritugisyaKojinCd = baseUserInfo.getUserId();
            toritugisyaKojinNm = baseUserInfo.getUserNm();
            if (bzGetSosikiMadogutiInfoKekkaBean != null) {
                toritugisyaSosikiNm = bzGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm();
            }

        }

        uiBean.setToritugisyaKojinCd(toritugisyaKojinCd);
        uiBean.setToritugisyaKojinNm(toritugisyaKojinNm);
        uiBean.setToritugisyaSosikiNm(toritugisyaSosikiNm);
    }

    void searchBtnBL() {
        uiBean.setAnkenSearchResultList(null);

        String jimuTetuzukiCd = null;
        if (C_SeikyuuSyubetu.SB.eq(uiBean.getSeikyuusyubetu())) {
            jimuTetuzukiCd = TeisuuSiharai.JIMUTETUZUKICD_SISIBOU;
        }


        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = SWAKInjector.getInstance(BzGetProcessSummaryInBean.class);

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(jimuTetuzukiCd);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU, C_Kouteikanristatus.KANRYOU);
        bzGetProcessSummaryInBean.setSyoNo(uiBean.getSyono());

        BzGetProcessSummary bzGetProcessSummary = SWAKInjector.getInstance(BzGetProcessSummary.class);
        List<BzGetProcessSummaryOutBean> processSummaryOutBeanList = bzGetProcessSummary
            .exec(bzGetProcessSummaryInBean);

        if (processSummaryOutBeanList.size() == 0) {
            messageManager.addMessageId(MessageId.EBA0048);
            return;
        }

        KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);
        KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);

        keiyakuPrm.setSyono(uiBean.getSyono());
        keiyakuPrm.setINayoseyh(C_NayoseYouhi.HUYOU);

        keiyakuInfoSyutoku.getInfos(keiyakuPrm);

        JT_SiKykKihon siKykKihon = keiyakuInfoSyutoku.getKykKihons().get(0);
        List<JT_SiKykSyouhn> siKykSyouhnList = siKykKihon.getSiKykSyouhns();
        JT_SiKykSyouhn siKykSyouhnSyu = new JT_SiKykSyouhn();
        for (JT_SiKykSyouhn siKykSyouhn : siKykSyouhnList) {
            if (C_SyutkKbn.SYU.eq(siKykSyouhn.getSyutkkbn())) {
                BeanUtil.copyProperties(siKykSyouhnSyu, siKykSyouhn);
                break;
            }
        }
        C_Tuukasyu kykTuukasyu = siKykSyouhnSyu.getKyktuukasyu();

        BM_SyouhnZokusei syouhnZokuseiSyu = bizDomManager.getSyouhnZokusei(siKykSyouhnSyu.getSyouhncd(),
            siKykSyouhnSyu.getSyouhnsdno());

        List<AnkenSearchResultListDataSourceBean> resultList = new ArrayList<AnkenSearchResultListDataSourceBean>();
        for (BzGetProcessSummaryOutBean summaryOutBean : processSummaryOutBeanList) {
            AnkenSearchResultListDataSourceBean dataSourceBean = new AnkenSearchResultListDataSourceBean();

            dataSourceBean.setDispjimutetuzukinm(summaryOutBean.getJimuTetuzukiNm());
            dataSourceBean.setDispkouteikanristatus(summaryOutBean.getKouteiKanriStatus());
            dataSourceBean.setDispkouteikaisiymd(summaryOutBean.getKouteiStartYmd());
            dataSourceBean.setDispjimustartymd(summaryOutBean.getJimuStartYmd());
            dataSourceBean.setDispkouteikanymd(summaryOutBean.getKouteEndYmd());
            dataSourceBean.setSyoruisakuseilink(MessageUtil.getMessage(MessageId.IBW1023));
            dataSourceBean.setKouteiKnrId(summaryOutBean.getKouteiKanriId());

            resultList.add(dataSourceBean);
        }
        uiBean.setAnkenSearchResultList(resultList);

        uiBean.setKykTuukasyu(kykTuukasyu);
        uiBean.setSiKykkihon(siKykKihon);
        uiBean.setSiKykSyouhnSyu(siKykSyouhnSyu);
        uiBean.setSyouhnZokusei(syouhnZokuseiSyu);
        uiBean.setResultSyono(uiBean.getSyono());
        uiBean.setResultSeikyuusyubetu(uiBean.getSeikyuusyubetu());
    }

    void syoruisakuseilinkBL() {
        uiBean.setSisyoruisakuseikbn(C_SiSyoruisakuseiKbn.BLNK);

        AnkenSearchResultListDataSourceBean selectData = uiBean.getAnkenSearchResultListDataSource().getSelectedBean();

        List<SakuseiTaisyouAnkenListDataSourceBean> sakuseiTaisyouList = new ArrayList<SakuseiTaisyouAnkenListDataSourceBean>();
        SakuseiTaisyouAnkenListDataSourceBean dataSourceBean = new SakuseiTaisyouAnkenListDataSourceBean();
        dataSourceBean.setDispjimutetuzukinm(selectData.getDispjimutetuzukinm());
        dataSourceBean.setDispkouteikanristatus(selectData.getDispkouteikanristatus());
        dataSourceBean.setDispkouteikaisiymd(selectData.getDispkouteikaisiymd());
        dataSourceBean.setDispjimustartymd(selectData.getDispjimustartymd());
        dataSourceBean.setDispkouteikanymd(selectData.getDispkouteikanymd());
        dataSourceBean.setSyoruisakuseilink(SiMakeSyoruiConstants.BLNK);
        sakuseiTaisyouList.add(dataSourceBean);

        uiBean.setSyono(uiBean.getResultSyono());
        uiBean.setSeikyuusyubetu(uiBean.getResultSeikyuusyubetu());
        uiBean.setSakuseiTaisyouAnkenList(sakuseiTaisyouList);
        if (C_SeikyuuSyubetu.SB.eq(uiBean.getSeikyuusyubetu())) {
            uiBean.setPatternsisyoruisakuseikbn(C_SiSyoruisakuseiKbn.PATTERN_SB);
        }

        uiBean.setKouteiKnrId(selectData.getKouteiKnrId());
    }

    void kakuninBtnBL() {
        messageManager.addMessageId(MessageId.QBA0001);
    }

    @Transactional
    void kakuteiBtnBL() {
        Map<String, String> sakuseizumiKouteikanriIdMp = new HashMap<>();
        sakuseizumiKouteikanriIdMp.put(uiBean.getSyono(), uiBean.getKouteiKnrId());
        siharaiPreReportRenkeiBean.setSakuseizumiKouteikanriIdMp(sakuseizumiKouteikanriIdMp);

        ReportServicesBean reportServicesBean = makePdf();

        String reportKey = createReport.execNoCommit(reportServicesBean);
        uiBean.setReportKey(reportKey);

        messageManager.addMessageId(MessageId.IAC0009);
    }

    void syoruisiteigamenhebtnBL() {
        uiBean.setSisyoruisakuseikbn(C_SiSyoruisakuseiKbn.BLNK);
    }

    void printReport() {
        PdfBuilder pdfBuilder = new PdfBuilder();

        try {
            if (C_SiSyoruisakuseiKbn.SB_HOKEN_SKS.eq(uiBean.getSisyoruisakuseikbn())) {

                if (C_Tuukasyu.JPY.eq(uiBean.getKykTuukasyu())) {
                    pdfBuilder = pdfJoin(pdfBuilder, SiMakeSyoruiConstants.PDFSOURCE_TBL_KOTEIPDF,
                        uiBean.getReportKey(),
                        YuyuSiharaiConfig.getInstance().getPdfpathSamplesisksyendt());
                    pdfBuilder = pdfJoin(pdfBuilder, SiMakeSyoruiConstants.PDFSOURCE_KOTEIPDF, null, YuyuSiharaiConfig
                        .getInstance().getPdfpathSamplesibouzeimuyendt());

                } else {
                    pdfBuilder = pdfJoin(pdfBuilder, SiMakeSyoruiConstants.PDFSOURCE_TBL_KOTEIPDF,
                        uiBean.getReportKey(),
                        YuyuSiharaiConfig.getInstance().getPdfpathSamplesisks());
                    pdfBuilder = pdfJoin(pdfBuilder, SiMakeSyoruiConstants.PDFSOURCE_KOTEIPDF, null, YuyuSiharaiConfig
                        .getInstance().getPdfpathSamplesibouzeimu());
                }

            } else if (C_SiSyoruisakuseiKbn.SEISANKINHRKM_IRAIS.eq(uiBean.getSisyoruisakuseikbn())) {

                if (C_Tuukasyu.JPY.eq(uiBean.getKykTuukasyu())) {
                    pdfBuilder = pdfJoin(pdfBuilder, SiMakeSyoruiConstants.PDFSOURCE_TBL_KOTEIPDF,
                        uiBean.getReportKey(),
                        YuyuSiharaiConfig.getInstance().getPdfpathSampleseisansksyendt());
                    pdfBuilder = pdfJoin(pdfBuilder, SiMakeSyoruiConstants.PDFSOURCE_KOTEIPDF, null, YuyuSiharaiConfig
                        .getInstance().getPdfpathSamplesibouzeimuyendt());

                } else {
                    pdfBuilder = pdfJoin(pdfBuilder, SiMakeSyoruiConstants.PDFSOURCE_TBL_KOTEIPDF,
                        uiBean.getReportKey(),
                        YuyuSiharaiConfig.getInstance().getPdfpathSampleseisansks());
                    pdfBuilder = pdfJoin(pdfBuilder, SiMakeSyoruiConstants.PDFSOURCE_KOTEIPDF, null, YuyuSiharaiConfig
                        .getInstance().getPdfpathSamplesibouzeimu());
                }

            } else if (C_SiSyoruisakuseiKbn.SB_DAIHYOU.eq(uiBean.getSisyoruisakuseikbn())) {

                pdfBuilder = pdfJoin(pdfBuilder, SiMakeSyoruiConstants.PDFSOURCE_TBL, uiBean.getReportKey(), null);

            } else if (C_SiSyoruisakuseiKbn.KD_JIKOJKS.eq(uiBean.getSisyoruisakuseikbn())) {

                pdfBuilder = pdfJoin(pdfBuilder, SiMakeSyoruiConstants.PDFSOURCE_TBL_KOTEIPDF, uiBean.getReportKey(),
                    YuyuSiharaiConfig.getInstance().getPdfpathSamplejikojyokyou());

            } else if (isMynumberCHyou(uiBean.getSisyoruisakuseikbn())) {

                String myNumberTkyrPdfPath = SiMakeSyoruiConstants.BLNK;
                if (C_SiSyoruisakuseiKbn.MYNUMBER_CHYOU_MENSEKI.eq(uiBean.getSisyoruisakuseikbn())) {
                    myNumberTkyrPdfPath = YuyuSiharaiConfig.getInstance().getPdfpathMynumberTkyrMenseki();

                } else if (C_SiSyoruisakuseiKbn.MYNUMBER_CHYOU_SOUZOKU.eq(uiBean.getSisyoruisakuseikbn())) {
                    myNumberTkyrPdfPath = YuyuSiharaiConfig.getInstance().getPdfpathMynumberTkyrSouzoku();

                } else if (C_SiSyoruisakuseiKbn.MYNUMBER_CHYOU_SYOTOKU.eq(uiBean.getSisyoruisakuseikbn())) {
                    myNumberTkyrPdfPath = YuyuSiharaiConfig.getInstance().getPdfpathMynumberTkyrSyotoku();

                } else if (C_SiSyoruisakuseiKbn.MYNUMBER_CHYOU_ZOUYO.eq(uiBean.getSisyoruisakuseikbn())) {
                    myNumberTkyrPdfPath = YuyuSiharaiConfig.getInstance().getPdfpathMynumberTkyrZouyo();

                } else if (C_SiSyoruisakuseiKbn.MYNUMBER_CHYOU_HUKUSUU.eq(uiBean.getSisyoruisakuseikbn())) {
                    myNumberTkyrPdfPath = YuyuSiharaiConfig.getInstance().getPdfpathMynumberTkyrHukusuu();

                }

                pdfBuilder = pdfJoin(pdfBuilder, SiMakeSyoruiConstants.PDFSOURCE_KOTEIPDF, null, myNumberTkyrPdfPath);
                pdfBuilder = pdfJoin(pdfBuilder, SiMakeSyoruiConstants.PDFSOURCE_TBL, uiBean.getReportKey(), null);

            }

            byte[] joinedReport = pdfBuilder.toByteArray();
            outputReport.outputJoinedPDFByBinary(joinedReport, uiBean.getReportKey());
        } catch (Exception e) {
            throw new CommonBizAppException(e, MessageUtil.getMessage(MessageId.EAS0019));
        }
    }

    void clear() {
    }

    private ReportServicesBean makePdf() {
        ReportServicesBean reportServicesBean = null;

        if (C_SiSyoruisakuseiKbn.SB_HOKEN_SKS.eq(uiBean.getSisyoruisakuseikbn())) {

            String wkQrCode = GetQRCode.execGetQRCode(C_SyoruiCdKbn.HK_SB_HOKEN_SKS.getValue());
            SyoruiToutyakuYoteiTouroku.execSyoruiToutyakuYoteiTouroku(C_SyoruiCdKbn.HK_SB_HOKEN_SKS.getValue(),
                uiBean.getKouteiKnrId(), wkQrCode);

            SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
                .getInstance(SiTyouhyouHensyuuCommonBean.class);
            siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.getSysDate());
            siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SB_HOKEN_SKS);

            EditSeikyuusyoBean editSeikyuusyoBean = SWAKInjector.getInstance(EditSeikyuusyoBean.class);
            editSeikyuusyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
            SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
            editSeikyuusyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
            editSeikyuusyoBean.setSyono(uiBean.getSyono());
            editSeikyuusyoBean.setSeikyuusyubetu(uiBean.getSeikyuusyubetu());
            editSeikyuusyoBean.setUktKbn(C_UktKbn.BLNK);
            editSeikyuusyoBean.setToritsugisyakjncd(uiBean.getToritugisyaKojinCd());
            editSeikyuusyoBean.setToritsugisyaKjnmei(uiBean.getToritugisyaKojinNm());
            editSeikyuusyoBean.setToritsugisyaSosikimei(uiBean.getToritugisyaSosikiNm());
            editSeikyuusyoBean.setTuukasyu(uiBean.getKykTuukasyu());

            EditSeikyuusyo editSeikyuusyo = SWAKInjector.getInstance(EditSeikyuusyo.class);
            reportServicesBean = editSeikyuusyo.exec(editSeikyuusyoBean);

            reportServicesBean.setKensakuKeys(uiBean.getSyono());
            reportServicesBean.setQrCode(wkQrCode);

        } else if (C_SiSyoruisakuseiKbn.SEISANKINHRKM_IRAIS.eq(uiBean.getSisyoruisakuseikbn())) {

            String wkQrCode = GetQRCode.execGetQRCode(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS.getValue());
            SyoruiToutyakuYoteiTouroku.execSyoruiToutyakuYoteiTouroku(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS.getValue(),
                uiBean.getKouteiKnrId(), wkQrCode);

            SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
                .getInstance(SiTyouhyouHensyuuCommonBean.class);
            siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.getSysDate());
            siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);

            BizDate sknnkaisiYmd;
            if (uiBean.getSiKykkihon().getHksknnkaisiymd() != null) {
                sknnkaisiYmd = uiBean.getSiKykkihon().getHksknnkaisiymd();
            } else {
                sknnkaisiYmd = uiBean.getSiKykSyouhnSyu().getSknnkaisiymd();
            }

            String uktnmkj = SiMakeSyoruiConstants.BLNK;
            C_HokenkinsyuruiKbn hokenkinsyuruikbn = C_HokenkinsyuruiKbn.BLNK;
            if (C_UmuKbn.ARI.eq(uiBean.getSyouhnZokusei().getSbhkuktumu())) {
                uktnmkj = MessageUtil.getMessage(MessageId.IJW1103);
                hokenkinsyuruikbn = C_HokenkinsyuruiKbn.SBHOKENKIN;
            } else if (C_UmuKbn.ARI.eq(uiBean.getSyouhnZokusei().getSbkyuuhukinuktumu())) {
                uktnmkj = MessageUtil.getMessage(MessageId.IJW1104);
                hokenkinsyuruikbn = C_HokenkinsyuruiKbn.SBKYUUHUKIN;
            }

            EditSeisankinhurikomiiraisyoBean editSeisankinhurikomiiraisyoBean = SWAKInjector
                .getInstance(EditSeisankinhurikomiiraisyoBean.class);
            editSeisankinhurikomiiraisyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
            SeikyuusyaInfoBean seikyuusyaInfoBean = SWAKInjector.getInstance(SeikyuusyaInfoBean.class);
            editSeisankinhurikomiiraisyoBean.setSeikyuusyaInfoBean(seikyuusyaInfoBean);
            editSeisankinhurikomiiraisyoBean.setUktnmkj(uktnmkj);
            editSeisankinhurikomiiraisyoBean.setSyono(uiBean.getSyono());
            editSeisankinhurikomiiraisyoBean.setHhknNmkj(uiBean.getSiKykkihon().getHhknnmkj());
            editSeisankinhurikomiiraisyoBean.setKykYmd(uiBean.getSiKykSyouhnSyu().getKykymd());
            editSeisankinhurikomiiraisyoBean.setSknnkaisiYmd(sknnkaisiYmd);
            editSeisankinhurikomiiraisyoBean.setKyksyasibouumukbn(C_KyksyaSibouUmuKbn.KYKSBARI);
            editSeisankinhurikomiiraisyoBean.setToritsugisyakjncd(uiBean.getToritugisyaKojinCd());
            editSeisankinhurikomiiraisyoBean.setToritsugisyaKjnmei(uiBean.getToritugisyaKojinNm());
            editSeisankinhurikomiiraisyoBean.setToritsugisyaSosikimei(uiBean.getToritugisyaSosikiNm());
            editSeisankinhurikomiiraisyoBean.setKyktuukasyu(uiBean.getKykTuukasyu());
            editSeisankinhurikomiiraisyoBean.setHokenkinsyuruikbn(hokenkinsyuruikbn);
            editSeisankinhurikomiiraisyoBean.setSyouhncd(uiBean.getSiKykSyouhnSyu().getSyouhncd());

            EditSeisankinhurikomiiraisyo editSeisankinhurikomiiraisyo = SWAKInjector
                .getInstance(EditSeisankinhurikomiiraisyo.class);
            reportServicesBean = editSeisankinhurikomiiraisyo.exec(editSeisankinhurikomiiraisyoBean);

            reportServicesBean.setKensakuKeys(uiBean.getSyono());
            reportServicesBean.setQrCode(wkQrCode);

        } else if (C_SiSyoruisakuseiKbn.SB_DAIHYOU.eq(uiBean.getSisyoruisakuseikbn())) {

            String wkQrCode = GetQRCode.execGetQRCode(C_SyoruiCdKbn.HK_SB_DAIHYOU.getValue());
            SyoruiToutyakuYoteiTouroku.execSyoruiToutyakuYoteiTouroku(C_SyoruiCdKbn.HK_SB_DAIHYOU.getValue(),
                uiBean.getKouteiKnrId(), wkQrCode);

            SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
                .getInstance(SiTyouhyouHensyuuCommonBean.class);
            siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.getSysDate());
            siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_SB_DAIHYOU);

            EditDaihyousennintodokeBean editDaihyousennintodokeBean = SWAKInjector
                .getInstance(EditDaihyousennintodokeBean.class);
            editDaihyousennintodokeBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
            editDaihyousennintodokeBean.setSyoNo(uiBean.getSyono());

            EditDaihyousennintodoke editDaihyousennintodoke = SWAKInjector.getInstance(EditDaihyousennintodoke.class);
            reportServicesBean = editDaihyousennintodoke.exec(editDaihyousennintodokeBean);

            reportServicesBean.setKensakuKeys(uiBean.getSyono());
            reportServicesBean.setQrCode(wkQrCode);

        } else if (C_SiSyoruisakuseiKbn.KD_JIKOJKS.eq(uiBean.getSisyoruisakuseikbn())) {

            String wkQrCode = GetQRCode.execGetQRCode(C_SyoruiCdKbn.HK_KD_JIKOJKS.getValue());
            SyoruiToutyakuYoteiTouroku.execSyoruiToutyakuYoteiTouroku(C_SyoruiCdKbn.HK_KD_JIKOJKS.getValue(),
                uiBean.getKouteiKnrId(), wkQrCode);

            SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
                .getInstance(SiTyouhyouHensyuuCommonBean.class);
            siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.getSysDate());
            siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_KD_JIKOJKS);

            EditJikojyokyouhoukokusyoBean editJikojyokyouhoukokusyoBean = SWAKInjector
                .getInstance(EditJikojyokyouhoukokusyoBean.class);
            editJikojyokyouhoukokusyoBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);

            EditJikojyokyouhoukokusyo editJikojyokyouhoukokusyo = SWAKInjector
                .getInstance(EditJikojyokyouhoukokusyo.class);
            reportServicesBean = editJikojyokyouhoukokusyo.exec(editJikojyokyouhoukokusyoBean);

            reportServicesBean.setKensakuKeys(uiBean.getSyono());
            reportServicesBean.setQrCode(wkQrCode);

        } else if (isMynumberCHyou(uiBean.getSisyoruisakuseikbn())) {

            String wkQrCode = GetQRCode.execGetQRCode(C_SyoruiCdKbn.HK_MYNUMBER_CHYOU.getValue());
            SyoruiToutyakuYoteiTouroku.execSyoruiToutyakuYoteiTouroku(C_SyoruiCdKbn.HK_MYNUMBER_CHYOU.getValue(),
                uiBean.getKouteiKnrId(), wkQrCode);

            SiTyouhyouHensyuuCommonBean siTyouhyouHensyuuCommonBean = SWAKInjector
                .getInstance(SiTyouhyouHensyuuCommonBean.class);
            siTyouhyouHensyuuCommonBean.setSyoriYmd(BizDate.getSysDate());
            siTyouhyouHensyuuCommonBean.setSyoruiCd(C_SyoruiCdKbn.HK_MYNUMBER_CHYOU);

            String mnTyouhyouPtn = SiMakeSyoruiConstants.BLNK;
            if (C_SiSyoruisakuseiKbn.MYNUMBER_CHYOU_MENSEKI.eq(uiBean.getSisyoruisakuseikbn())) {
                mnTyouhyouPtn = TeisuuSiharai.MNTYOUHYOUPTN_MENSEKI;

            } else if (C_SiSyoruisakuseiKbn.MYNUMBER_CHYOU_SOUZOKU.eq(uiBean.getSisyoruisakuseikbn())) {
                mnTyouhyouPtn = TeisuuSiharai.MNTYOUHYOUPTN_SOUZOKUZEI;

            } else if (C_SiSyoruisakuseiKbn.MYNUMBER_CHYOU_SYOTOKU.eq(uiBean.getSisyoruisakuseikbn())) {
                mnTyouhyouPtn = TeisuuSiharai.MNTYOUHYOUPTN_SYOTOKUZEI;

            } else if (C_SiSyoruisakuseiKbn.MYNUMBER_CHYOU_ZOUYO.eq(uiBean.getSisyoruisakuseikbn())) {
                mnTyouhyouPtn = TeisuuSiharai.MNTYOUHYOUPTN_ZOUYOZEI;

            } else if (C_SiSyoruisakuseiKbn.MYNUMBER_CHYOU_HUKUSUU.eq(uiBean.getSisyoruisakuseikbn())) {
                mnTyouhyouPtn = TeisuuSiharai.MNTYOUHYOUPTN_UKETORININHUKUSUU;

            }

            EditMynumberCBean editMynumberCBean = SWAKInjector.getInstance(EditMynumberCBean.class);
            editMynumberCBean.setSiTyouhyouHensyuuCommonBean(siTyouhyouHensyuuCommonBean);
            editMynumberCBean.setSyono(uiBean.getSyono());
            editMynumberCBean.setMntyouhyouptn(mnTyouhyouPtn);

            EditMynumberC editMynumberC = SWAKInjector.getInstance(EditMynumberC.class);
            reportServicesBean = editMynumberC.exec(editMynumberCBean);

            reportServicesBean.setKensakuKeys(uiBean.getSyono());
            reportServicesBean.setQrCode(wkQrCode);

        }

        return reportServicesBean;
    }

    private boolean isMynumberCHyou(C_SiSyoruisakuseiKbn pSiSyoruisakuseiKbn) {
        return C_SiSyoruisakuseiKbn.MYNUMBER_CHYOU_MENSEKI.eq(pSiSyoruisakuseiKbn) ||
            C_SiSyoruisakuseiKbn.MYNUMBER_CHYOU_SOUZOKU.eq(pSiSyoruisakuseiKbn) ||
            C_SiSyoruisakuseiKbn.MYNUMBER_CHYOU_SYOTOKU.eq(pSiSyoruisakuseiKbn) ||
            C_SiSyoruisakuseiKbn.MYNUMBER_CHYOU_ZOUYO.eq(pSiSyoruisakuseiKbn) ||
            C_SiSyoruisakuseiKbn.MYNUMBER_CHYOU_HUKUSUU.eq(pSiSyoruisakuseiKbn);
    }

    private PdfBuilder pdfJoin(PdfBuilder pPdfBuilder, int pPdfSource, String pReportKey, String pPdfPath) {

        PdfBuilder pdfBuilder = pPdfBuilder;

        try {
            if (pPdfSource == SiMakeSyoruiConstants.PDFSOURCE_TBL) {
                PdfReader pdfReader = new PdfReader(dbaOutputReport.getPdfImages(new String[] { pReportKey }));
                pdfBuilder.append(pdfReader);

            } else if (pPdfSource == SiMakeSyoruiConstants.PDFSOURCE_KOTEIPDF) {
                PdfReader pdfReader = new PdfReader(SWAK.getApplicationRootPath() + pPdfPath);
                pdfBuilder.append(pdfReader);

            } else if (pPdfSource == SiMakeSyoruiConstants.PDFSOURCE_TBL_KOTEIPDF) {
                PdfReader pdfReader1 = new PdfReader(dbaOutputReport.getPdfImages(new String[] { pReportKey }));
                pdfBuilder.append(pdfReader1);
                PdfReader pdfReader2 = new PdfReader(SWAK.getApplicationRootPath() + pPdfPath);
                pdfBuilder.append(pdfReader2);
            }

        } catch (Exception e) {
            throw new CommonBizAppException(e, MessageUtil.getMessage(MessageId.EAS0019));
        }

        return pdfBuilder;
    }
}
