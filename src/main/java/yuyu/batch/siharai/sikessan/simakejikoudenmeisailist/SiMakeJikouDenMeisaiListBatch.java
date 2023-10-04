package yuyu.batch.siharai.sikessan.simakejikoudenmeisailist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.MessageId;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.JT_SiKekka;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.siharai.bean.report.SiJikouDenMeisaiListBean;
import yuyu.def.siharai.bean.report.SiJikouDenMeisaiListDataSourceBean;
import yuyu.def.siharai.configuration.YuyuSiharaiConfig;
import yuyu.def.siharai.file.csv.SiJikouDenMeisaiListLayoutFile;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
/**
 * 保険金給付金支払 決算 時効伝票明細リスト
 */
public class SiMakeJikouDenMeisaiListBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam batchParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private CreateReport createReport;

    private static final Integer MAXLINECOUNT = 34;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = batchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        long outputCount = 0;
        BizDate kessanKijyunYmd = null;
        List<SiJikouDenMeisaiListLayoutFile> siJikouDenMeisaiListLayoutFileList = new ArrayList<>();
        SiJikouDenMeisaiListBean siJikouDenMeisaiListBean = SWAKInjector.getInstance(SiJikouDenMeisaiListBean.class);
        List<IReportDataSouceBean> siJikouDenMeisaiListDataSourceBeanList = new ArrayList<>();
        String tuhuyuAtsk = YuyuSiharaiConfig.getInstance().getTantousitu() + "－" +
            ConvertUtil.toZenAlphabet(C_TantouCdKbn.SIBOUTETUZUKI.getValue(), 0);

        if (syoriYmd.getDay() <= 15) {

            kessanKijyunYmd = syoriYmd.getPreviousMonth().getBizDateYM().getLastDay();
        }
        else {

            kessanKijyunYmd = syoriYmd.getBizDateYM().getLastDay();
        }
        String ksnNendo = DateFormatUtil.dateYKANJISeirekiNendo(kessanKijyunYmd);

        try(ExDBResults<JT_SiBikinkanri> siBikinkanriList = siharaiDomManager.
            getSiBikinkanrisByKsnYmdBknJkuKbnBknrigikbnEx(kessanKijyunYmd, C_BknJkuKbn.JIKOU, C_BknrigiKbn.DEL);){

            Iterator<JT_SiBikinkanri> siBikinkanriIter = siBikinkanriList.iterator();
            if (siBikinkanriIter.hasNext()) {

                Integer pageNo = 1;
                long lineCount = 0;
                JikouDenMeisaiListSyukeiBean bubunSyukeiBean = SWAKInjector.getInstance(JikouDenMeisaiListSyukeiBean.class);
                JikouDenMeisaiListSyukeiBean zenkenSyukeiBean = SWAKInjector.getInstance(JikouDenMeisaiListSyukeiBean.class);
                String hokensyuruiKey = null;
                String bikinCdKey = null;

                while (siBikinkanriIter.hasNext()) {

                    JT_SiBikinkanri siBikinkanri = siBikinkanriIter.next();
                    String syono = siBikinkanri.getSyono();

                    List<JT_SiKekka> siKekkaList =
                        siharaiDomManager.getSiKekkasBySyonoSyoumetujiyuuNe(syono, C_Syoumetujiyuu.JIKOU);
                    if (siKekkaList.size() != 0) {

                        continue;
                    }
                    KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);
                    KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);
                    keiyakuPrm.setSyono(syono);
                    keiyakuPrm.setINayoseyh(C_NayoseYouhi.HUYOU);
                    keiyakuInfoSyutoku.getInfos(keiyakuPrm);
                    JT_SiKykKihon siKykKihon = keiyakuInfoSyutoku.getKykKihons().get(0);

                    BizCurrency krkkgk = siKykKihon.getKrkgk();
                    BizCurrency zatusyunyukgk = krkkgk;
                    if (zatusyunyukgk.isZeroOrOptional()) {

                        continue;
                    }
                    if (outputCount == 0) {
                        hokensyuruiKey = siBikinkanri.getKbnkeirisegcd().getValue();
                        bikinCdKey = siBikinkanri.getSyuukeiyoubkncdkbn().getValue();
                    }
                    else {
                        if (!hokensyuruiKey.equals(siBikinkanri.getKbnkeirisegcd().getValue()) ||
                            !bikinCdKey.equals(siBikinkanri.getSyuukeiyoubkncdkbn().getValue())) {

                            SiJikouDenMeisaiListDataSourceBean siJikouDenMeisaiListDataSourceBean_last =
                                (SiJikouDenMeisaiListDataSourceBean) siJikouDenMeisaiListDataSourceBeanList.
                                get(siJikouDenMeisaiListDataSourceBeanList.size() - 1);
                            siJikouDenMeisaiListDataSourceBean_last.setIrGoukeibkncd(bikinCdKey);
                            siJikouDenMeisaiListDataSourceBean_last.setIrGoukeikrkgk(String.valueOf(
                                bubunSyukeiBean.getGoukeikrkgk()));
                            siJikouDenMeisaiListDataSourceBean_last.setIrGoukeizatusyunyukgk(String.valueOf(
                                bubunSyukeiBean.getGoukeizatusyunyukgk()));
                            siJikouDenMeisaiListDataSourceBean_last.setIrGoukeiumukbn(C_UmuKbn.ARI);
                            siJikouDenMeisaiListDataSourceBean_last.setIrSougoukeiumukbn(C_UmuKbn.NONE);

                            zenkenSyukeiBean.setGoukeikrkgk(
                                zenkenSyukeiBean.getGoukeikrkgk().add(bubunSyukeiBean.getGoukeikrkgk()));
                            zenkenSyukeiBean.setGoukeizatusyunyukgk(
                                zenkenSyukeiBean.getGoukeizatusyunyukgk().add(bubunSyukeiBean.getGoukeizatusyunyukgk()));

                            pageNo = pageNo + 1;

                            hokensyuruiKey = siBikinkanri.getKbnkeirisegcd().getValue();
                            bikinCdKey = siBikinkanri.getSyuukeiyoubkncdkbn().getValue();

                            lineCount = 0;

                            bubunSyukeiBean = SWAKInjector.getInstance(JikouDenMeisaiListSyukeiBean.class);
                        }
                        else {
                            if (lineCount >= MAXLINECOUNT) {

                                pageNo = pageNo + 1;
                                lineCount = 0;
                            }
                        }
                    }
                    outputCount = outputCount + 1;
                    lineCount = lineCount + 1;
                    bubunSyukeiBean.setGoukeikrkgk(bubunSyukeiBean.getGoukeikrkgk().add(krkkgk));
                    bubunSyukeiBean.setGoukeizatusyunyukgk(bubunSyukeiBean.getGoukeizatusyunyukgk().add(zatusyunyukgk));
                    String hokenSyuri = siBikinkanri.getKbnkeirisegcd().getContent();

                    SiJikouDenMeisaiListDataSourceBean siJikouDenMeisaiListDataSourceBean =
                        SWAKInjector.getInstance(SiJikouDenMeisaiListDataSourceBean.class);
                    siJikouDenMeisaiListDataSourceBean.setIrGoukeihknsyruilevel(siBikinkanri.getKbnkeirisegcd().getContent());
                    siJikouDenMeisaiListDataSourceBean.setIrBkncd(siBikinkanri.getBkncdkbn().getValue());
                    siJikouDenMeisaiListDataSourceBean.setIrSyono(syono);
                    siJikouDenMeisaiListDataSourceBean.setIrKrkgkstr(String.valueOf(krkkgk));
                    siJikouDenMeisaiListDataSourceBean.setIrZatusyunyukgk(String.valueOf(zatusyunyukgk));
                    siJikouDenMeisaiListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
                    siJikouDenMeisaiListDataSourceBean.setIrSougoukeiumukbn(C_UmuKbn.NONE);
                    siJikouDenMeisaiListDataSourceBean.setIrPageno(pageNo);
                    siJikouDenMeisaiListDataSourceBeanList.add(siJikouDenMeisaiListDataSourceBean);

                    SiJikouDenMeisaiListLayoutFile siJikouDenMeisaiListLayoutFile =
                        SWAKInjector.getInstance(SiJikouDenMeisaiListLayoutFile.class);
                    siJikouDenMeisaiListLayoutFile.setIfcListnm("時効伝票明細リスト");
                    siJikouDenMeisaiListLayoutFile.setIfcAtesaki(YuyuSiharaiConfig.getInstance().getTantousitu());
                    siJikouDenMeisaiListLayoutFile.setIfcSakuseiymdseireki(
                        FixedDateFormatter.formatYMDSeirekiSlashZeroFill(syoriYmd));
                    siJikouDenMeisaiListLayoutFile.setIfcPageno(String.valueOf(pageNo));
                    siJikouDenMeisaiListLayoutFile.setIfcKessannnd(ksnNendo);
                    siJikouDenMeisaiListLayoutFile.setIfcKbnkeirisegcd(siBikinkanri.getKbnkeirisegcd().getValue());
                    siJikouDenMeisaiListLayoutFile.setIfcHknsyruilevelcd(hokenSyuri);
                    siJikouDenMeisaiListLayoutFile.setIfcSyoricd(siBikinkanri.getBkncdkbn().getValue());
                    siJikouDenMeisaiListLayoutFile.setIfcSyono(syono);
                    siJikouDenMeisaiListLayoutFile.setIfcBknkktiymdseireki(
                        FixedDateFormatter.formatYMDSeirekiSlashZeroFill(siBikinkanri.getBknkktymd()));
                    siJikouDenMeisaiListLayoutFile.setIfcKasitukekgk("0");
                    siJikouDenMeisaiListLayoutFile.setIfcTatekaekgk("0");
                    siJikouDenMeisaiListLayoutFile.setIfcKrkgk(String.valueOf(krkkgk));
                    siJikouDenMeisaiListLayoutFile.setIfcKaribaraikgk("0");
                    siJikouDenMeisaiListLayoutFile.setIfcZatusyunyukgk(String.valueOf(zatusyunyukgk));
                    siJikouDenMeisaiListLayoutFile.setIfcHkgk("0");
                    siJikouDenMeisaiListLayoutFile.setIfcBikou1("");
                    siJikouDenMeisaiListLayoutFileList.add(siJikouDenMeisaiListLayoutFile);
                }

                if (!siJikouDenMeisaiListDataSourceBeanList.isEmpty()) {

                    SiJikouDenMeisaiListDataSourceBean siJikouDenMeisaiListDataSourceBean_last =
                        (SiJikouDenMeisaiListDataSourceBean) siJikouDenMeisaiListDataSourceBeanList.
                        get(siJikouDenMeisaiListDataSourceBeanList.size() - 1);
                    siJikouDenMeisaiListDataSourceBean_last.setIrGoukeibkncd(bikinCdKey);
                    siJikouDenMeisaiListDataSourceBean_last.setIrGoukeikrkgk(String.valueOf(
                        bubunSyukeiBean.getGoukeikrkgk()));
                    siJikouDenMeisaiListDataSourceBean_last.setIrGoukeizatusyunyukgk(String.valueOf(
                        bubunSyukeiBean.getGoukeizatusyunyukgk()));
                    siJikouDenMeisaiListDataSourceBean_last.setIrGoukeiumukbn(C_UmuKbn.ARI);
                    siJikouDenMeisaiListDataSourceBean_last.setIrSougoukeiumukbn(C_UmuKbn.NONE);

                    zenkenSyukeiBean.setGoukeikrkgk(
                        zenkenSyukeiBean.getGoukeikrkgk().add(bubunSyukeiBean.getGoukeikrkgk()));
                    zenkenSyukeiBean.setGoukeizatusyunyukgk(
                        zenkenSyukeiBean.getGoukeizatusyunyukgk().add(bubunSyukeiBean.getGoukeizatusyunyukgk()));
                    pageNo = pageNo + 1;
                }

                SiJikouDenMeisaiListDataSourceBean siJikouDenMeisaiListDataSourceBean =
                    SWAKInjector.getInstance(SiJikouDenMeisaiListDataSourceBean.class);
                siJikouDenMeisaiListDataSourceBean.setIrBkncd("");
                siJikouDenMeisaiListDataSourceBean.setIrSyono("");
                siJikouDenMeisaiListDataSourceBean.setIrKrkgkstr("");
                siJikouDenMeisaiListDataSourceBean.setIrZatusyunyukgk("");
                siJikouDenMeisaiListDataSourceBean.setIrGoukeihknsyruilevel("");
                siJikouDenMeisaiListDataSourceBean.setIrGoukeibkncd("総合計");
                siJikouDenMeisaiListDataSourceBean.setIrGoukeikrkgk(String.valueOf(
                    zenkenSyukeiBean.getGoukeikrkgk()));
                siJikouDenMeisaiListDataSourceBean.setIrGoukeizatusyunyukgk(String.valueOf(
                    zenkenSyukeiBean.getGoukeizatusyunyukgk()));
                siJikouDenMeisaiListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.ARI);
                siJikouDenMeisaiListDataSourceBean.setIrSougoukeiumukbn(C_UmuKbn.ARI);
                siJikouDenMeisaiListDataSourceBean.setIrPageno(pageNo);
                siJikouDenMeisaiListDataSourceBeanList.add(siJikouDenMeisaiListDataSourceBean);

            }
            String hozonKknInfo = ViewReport.getHozonKknTani(C_SyoruiCdKbn.HK_JIKOUDENMEISAILIST);

            siJikouDenMeisaiListBean.setIrAtesaki(tuhuyuAtsk);
            siJikouDenMeisaiListBean.setIrKessannnd(ksnNendo);
            siJikouDenMeisaiListBean.setIrTyouhyousakuseiymd(String.valueOf(syoriYmd));
            siJikouDenMeisaiListBean.setIrHozonkkn(hozonKknInfo);

            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                TeisuuSiharai.SUBSYSTEMID_SIHARAI,
                kinou.getCategoryId(),
                kinou.getKinouId(),
                C_SyoruiCdKbn.HK_JIKOUDENMEISAILIST);

            reportServicesBean.setSyoriYmd(syoriYmd);

            reportServicesBean.addParamObjects(
                C_SyoruiCdKbn.HK_JIKOUDENMEISAILIST,
                siJikouDenMeisaiListDataSourceBeanList,
                siJikouDenMeisaiListBean);

            createReport.execNoCommit(reportServicesBean);

            BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

            C_ErrorKbn errorKbn = bzFileUploadUtil.exec(
                C_FileSyuruiCdKbn.SI_JIKOUDENMEISAILISTCSVF,
                siJikouDenMeisaiListLayoutFileList,
                true);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
            }
        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(outputCount),
            kinou.getKinouNm()));
    }
}
