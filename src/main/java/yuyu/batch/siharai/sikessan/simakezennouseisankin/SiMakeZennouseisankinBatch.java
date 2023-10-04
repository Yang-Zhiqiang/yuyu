package yuyu.batch.siharai.sikessan.simakezennouseisankin;

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
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.MessageId;
import yuyu.def.classification.C_Bknkessankbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SeisankinKanritukaKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.siharai.bean.report.SiZennouseisankinMeisaiListBean;
import yuyu.def.siharai.bean.report.SiZennouseisankinMeisaiListDataSourceBean;
import yuyu.def.siharai.configuration.YuyuSiharaiConfig;
import yuyu.def.siharai.file.csv.SiZennouseisankinMeisaiListLayoutFile;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.Lists;

/**
 * 保険金給付金支払 決算 前納精算金明細リスト作成
 */
public class SiMakeZennouseisankinBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam batchParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(batchParam.getSyoriYmd())));

        long outKensuu = 0;
        BizDate kessanKijyunYmd = null;
        C_Bknkessankbn bknkessankbn = C_Bknkessankbn.BLNK;
        List<SiZennouseisankinMeisaiListLayoutFile> siZennouseisankinMeisaiListLayoutFileLst = Lists.newArrayList();
        List<IReportDataSouceBean> iReportDataSouceBeanLst = Lists.newArrayList();

        String tuhuyuAtsk = YuyuSiharaiConfig.getInstance().getTantousitu() + "－" +
            ConvertUtil.toZenAlphabet(C_TantouCdKbn.SIBOUTETUZUKI.getValue(), 0);

        if (batchParam.getSyoriYmd().getDay() <= 15) {

            kessanKijyunYmd = batchParam.getSyoriYmd().getPreviousMonth().getBizDateYM().getLastDay();
        }

        else {

            kessanKijyunYmd = batchParam.getSyoriYmd().getBizDateYM().getLastDay();
        }

        String ksnNendo = DateFormatUtil.dateYKANJISeirekiNendo(kessanKijyunYmd);

        if (kessanKijyunYmd.getMonth() == 3) {

            bknkessankbn = C_Bknkessankbn.KESSAN;
        }
        else if (kessanKijyunYmd.getMonth() == 6) {

            bknkessankbn = C_Bknkessankbn.SHNK;
        }
        else if (kessanKijyunYmd.getMonth() == 9) {

            bknkessankbn = C_Bknkessankbn.HNK;
        }
        else if (kessanKijyunYmd.getMonth() == 12) {

            bknkessankbn = C_Bknkessankbn.SHNK;
        }

        String csvKsnNendo = ksnNendo + bknkessankbn.getContent();

        try (ExDBResults<JT_SiBikinkanri> siBikinkanriLst = siharaiDomManager.getSiBikinkanrisByZennouseisankin(
            kessanKijyunYmd, C_UmuKbn.ARI, C_ShrKekkaKbn.HSHR, C_BknrigiKbn.DEL)) {

            Iterator<JT_SiBikinkanri> siBikinkanriIter = siBikinkanriLst.iterator();
            if (siBikinkanriIter.hasNext()) {

                Integer pageNum = 1;
                long pageGyousuu1 = 0;
                ZennouseisankinMeisaiLstSumNaibuBean bikinKktiNengetuSumBean = new ZennouseisankinMeisaiLstSumNaibuBean();
                ZennouseisankinMeisaiLstSumNaibuBean bikinKktiNendoSumBean = new ZennouseisankinMeisaiLstSumNaibuBean();
                ZennouseisankinMeisaiLstSumNaibuBean hokenSyuruiSumBean = new ZennouseisankinMeisaiLstSumNaibuBean();
                ZennouseisankinMeisaiLstSumNaibuBean bikinCodeSumBean = new ZennouseisankinMeisaiLstSumNaibuBean();
                String bikinKktiNengetuBreakkey = null;
                String bikinKktiNendoBreakkey = null;
                String hokenSyoruiBreakkey = null;
                String bikinCodeBreakkey = null;

                while (siBikinkanriIter.hasNext()) {

                    JT_SiBikinkanri siBikinkanri = siBikinkanriIter.next();

                    if (outKensuu == 0) {
                        bikinKktiNengetuBreakkey = String.valueOf(siBikinkanri.getBknkktiym());

                        bikinKktiNendoBreakkey = siBikinkanri.getBknkktinnd();

                        hokenSyoruiBreakkey = siBikinkanri.getKbnkeirisegcd().getValue();

                        bikinCodeBreakkey = siBikinkanri.getSyuukeiyoubkncdkbn().getValue();
                    }
                    else {
                        if (!siBikinkanri.getSyuukeiyoubkncdkbn().getValue().equals(bikinCodeBreakkey)) {

                            SiZennouseisankinMeisaiListDataSourceBean siZennouseisankinMeisaiListDataSourceBean =
                                (SiZennouseisankinMeisaiListDataSourceBean) iReportDataSouceBeanLst
                                .get(iReportDataSouceBeanLst.size() - 1);

                            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktiym(DateFormatUtil
                                .dateYmKANJI(bikinKktiNengetuBreakkey));
                            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktinnd(DateFormatUtil
                                .dateYKANJISeireki(bikinKktiNendoBreakkey).concat("度"));
                            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeihknsyruilevel(C_Segcd
                                .getContentByValue(C_Segcd.PATTERN_DEFAULT, hokenSyoruiBreakkey));
                            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibkncd(bikinCodeBreakkey);
                            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeikensuu1(BizNumber
                                .valueOf(bikinKktiNengetuSumBean.getSumkns()));
                            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeiseisankin(bikinKktiNengetuSumBean
                                .getSumseisankin().toFormatString());

                            pageNum = pageNum + 1;

                            iReportDataSouceBeanLst.add(getZennouseisankinLstNendoSum(bikinKktiNendoBreakkey,
                                hokenSyoruiBreakkey, bikinCodeBreakkey, bikinKktiNendoSumBean, pageNum));

                            pageNum = pageNum + 1;

                            iReportDataSouceBeanLst.add(getZennouseisankinLstHksyuruiSum(hokenSyoruiBreakkey,
                                bikinCodeBreakkey, hokenSyuruiSumBean, pageNum));

                            pageNum = pageNum + 1;

                            iReportDataSouceBeanLst.add(getZennouseisankinLstBkcodeSum(bikinCodeBreakkey,
                                bikinCodeSumBean, pageNum));

                            pageNum = pageNum + 1;

                            bikinKktiNengetuBreakkey = String.valueOf(siBikinkanri.getBknkktiym());

                            bikinKktiNendoBreakkey = siBikinkanri.getBknkktinnd();

                            hokenSyoruiBreakkey = siBikinkanri.getKbnkeirisegcd().getValue();

                            bikinCodeBreakkey = siBikinkanri.getSyuukeiyoubkncdkbn().getValue();

                            pageGyousuu1 = 0 ;

                            bikinKktiNengetuSumBean = new ZennouseisankinMeisaiLstSumNaibuBean();
                            bikinKktiNendoSumBean = new ZennouseisankinMeisaiLstSumNaibuBean();
                            hokenSyuruiSumBean = new ZennouseisankinMeisaiLstSumNaibuBean();
                            bikinCodeSumBean = new ZennouseisankinMeisaiLstSumNaibuBean();
                        }
                        else if (!siBikinkanri.getKbnkeirisegcd().getValue().equals(hokenSyoruiBreakkey)) {

                            SiZennouseisankinMeisaiListDataSourceBean siZennouseisankinMeisaiListDataSourceBean =
                                (SiZennouseisankinMeisaiListDataSourceBean) iReportDataSouceBeanLst
                                .get(iReportDataSouceBeanLst.size() - 1);

                            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktiym(DateFormatUtil
                                .dateYmKANJI(bikinKktiNengetuBreakkey));
                            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktinnd(DateFormatUtil
                                .dateYKANJISeireki(bikinKktiNendoBreakkey).concat("度"));
                            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeihknsyruilevel(C_Segcd
                                .getContentByValue(C_Segcd.PATTERN_DEFAULT, hokenSyoruiBreakkey));
                            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibkncd(bikinCodeBreakkey);
                            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeikensuu1(BizNumber
                                .valueOf(bikinKktiNengetuSumBean.getSumkns()));
                            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeiseisankin(bikinKktiNengetuSumBean
                                .getSumseisankin().toFormatString());

                            pageNum = pageNum + 1;

                            iReportDataSouceBeanLst.add(getZennouseisankinLstNendoSum(bikinKktiNendoBreakkey,
                                hokenSyoruiBreakkey, bikinCodeBreakkey, bikinKktiNendoSumBean, pageNum));

                            pageNum = pageNum + 1;

                            iReportDataSouceBeanLst.add(getZennouseisankinLstHksyuruiSum(hokenSyoruiBreakkey,
                                bikinCodeBreakkey, hokenSyuruiSumBean, pageNum));

                            pageNum = pageNum + 1;

                            bikinKktiNengetuBreakkey = String.valueOf(siBikinkanri.getBknkktiym());

                            bikinKktiNendoBreakkey = siBikinkanri.getBknkktinnd();

                            hokenSyoruiBreakkey = siBikinkanri.getKbnkeirisegcd().getValue();

                            pageGyousuu1 = 0 ;

                            bikinKktiNengetuSumBean = new ZennouseisankinMeisaiLstSumNaibuBean();
                            bikinKktiNendoSumBean = new ZennouseisankinMeisaiLstSumNaibuBean();
                            hokenSyuruiSumBean = new ZennouseisankinMeisaiLstSumNaibuBean();
                        }
                        else if (!siBikinkanri.getBknkktinnd().equals(bikinKktiNendoBreakkey)) {

                            SiZennouseisankinMeisaiListDataSourceBean siZennouseisankinMeisaiListDataSourceBean =
                                (SiZennouseisankinMeisaiListDataSourceBean) iReportDataSouceBeanLst
                                .get(iReportDataSouceBeanLst.size() - 1);

                            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktiym(DateFormatUtil
                                .dateYmKANJI(bikinKktiNengetuBreakkey));
                            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktinnd(DateFormatUtil
                                .dateYKANJISeireki(bikinKktiNendoBreakkey).concat("度"));
                            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeihknsyruilevel(C_Segcd
                                .getContentByValue(C_Segcd.PATTERN_DEFAULT, hokenSyoruiBreakkey));
                            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibkncd(bikinCodeBreakkey);
                            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeikensuu1(BizNumber
                                .valueOf(bikinKktiNengetuSumBean.getSumkns()));
                            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeiseisankin(bikinKktiNengetuSumBean
                                .getSumseisankin().toFormatString());

                            pageNum = pageNum + 1;

                            iReportDataSouceBeanLst.add(getZennouseisankinLstNendoSum(bikinKktiNendoBreakkey,
                                hokenSyoruiBreakkey, bikinCodeBreakkey, bikinKktiNendoSumBean, pageNum));

                            pageNum = pageNum + 1;

                            bikinKktiNengetuBreakkey = String.valueOf(siBikinkanri.getBknkktiym());

                            bikinKktiNendoBreakkey = siBikinkanri.getBknkktinnd();

                            pageGyousuu1 = 0 ;

                            bikinKktiNengetuSumBean = new ZennouseisankinMeisaiLstSumNaibuBean();
                            bikinKktiNendoSumBean = new ZennouseisankinMeisaiLstSumNaibuBean();
                        }
                        else if (!String.valueOf(siBikinkanri.getBknkktiym()).equals(bikinKktiNengetuBreakkey)) {

                            SiZennouseisankinMeisaiListDataSourceBean siZennouseisankinMeisaiListDataSourceBean =
                                (SiZennouseisankinMeisaiListDataSourceBean) iReportDataSouceBeanLst
                                .get(iReportDataSouceBeanLst.size() - 1);

                            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktiym(DateFormatUtil
                                .dateYmKANJI(bikinKktiNengetuBreakkey));
                            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktinnd(DateFormatUtil
                                .dateYKANJISeireki(bikinKktiNendoBreakkey).concat("度"));
                            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeihknsyruilevel(C_Segcd
                                .getContentByValue(C_Segcd.PATTERN_DEFAULT, hokenSyoruiBreakkey));
                            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibkncd(bikinCodeBreakkey);
                            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeikensuu1(BizNumber
                                .valueOf(bikinKktiNengetuSumBean.getSumkns()));
                            siZennouseisankinMeisaiListDataSourceBean.setIrGoukeiseisankin(bikinKktiNengetuSumBean
                                .getSumseisankin().toFormatString());

                            pageNum = pageNum + 1;

                            bikinKktiNengetuBreakkey = String.valueOf(siBikinkanri.getBknkktiym());

                            pageGyousuu1 = 0 ;

                            bikinKktiNengetuSumBean = new ZennouseisankinMeisaiLstSumNaibuBean();
                        }
                        else {
                            if (pageGyousuu1 == 34) {

                                pageNum = pageNum + 1;

                                pageGyousuu1 = 0;
                            }
                        }
                    }

                    outKensuu = outKensuu + 1;

                    pageGyousuu1 = pageGyousuu1 + 1;

                    BizCurrency zennouseisankin = BizCurrency.valueOf(0);

                    if (C_Tuukasyu.JPY.eq(siBikinkanri.getKyktuukasyu())) {

                        zennouseisankin = siBikinkanri.getZennouseisankgk();
                    }
                    else {

                        zennouseisankin = siBikinkanri.getYenkazennouseisankgk();
                    }

                    bikinKktiNengetuSumBean.setSumkns(bikinKktiNengetuSumBean.getSumkns() + 1);
                    bikinKktiNengetuSumBean.setSumseisankin(bikinKktiNengetuSumBean.getSumseisankin().add(
                        zennouseisankin));

                    bikinKktiNendoSumBean.setSumkns(bikinKktiNendoSumBean.getSumkns() + 1);
                    bikinKktiNendoSumBean.setSumseisankin(bikinKktiNendoSumBean.getSumseisankin().add(zennouseisankin));

                    hokenSyuruiSumBean.setSumkns(hokenSyuruiSumBean.getSumkns() + 1);
                    hokenSyuruiSumBean.setSumseisankin(hokenSyuruiSumBean.getSumseisankin().add(zennouseisankin));

                    bikinCodeSumBean.setSumkns(bikinCodeSumBean.getSumkns() + 1);
                    bikinCodeSumBean.setSumseisankin(bikinCodeSumBean.getSumseisankin().add(zennouseisankin));

                    String hknsyurui = C_Segcd.getContentByValue(C_Segcd.PATTERN_DEFAULT, siBikinkanri
                        .getKbnkeirisegcd().getValue());

                    BizDate syoruiukeymd = siBikinkanri.getSyoruiukeymd();

                    if(siBikinkanri.getHubikanryouymd() != null){

                        syoruiukeymd = siBikinkanri.getHubikanryouymd();
                    }

                    String gaikaukthyoji;
                    String gkdtzennouseisankin;
                    String yenkansanreto;

                    if (C_Tuukasyu.JPY.eq(siBikinkanri.getShrtuukasyu())
                        || C_Tuukasyu.BLNK.eq(siBikinkanri.getShrtuukasyu())) {

                        gaikaukthyoji = "";
                    }
                    else {

                        gaikaukthyoji = "*";
                    }

                    if (C_Tuukasyu.JPY.eq(siBikinkanri.getKyktuukasyu())) {

                        gkdtzennouseisankin = "";
                        yenkansanreto = "";
                    }
                    else {

                        if (C_SeisankinKanritukaKbn.SITEITUUKA.eq(siBikinkanri.getZnnusisnkinknrtuukakbn())) {

                            gkdtzennouseisankin = siBikinkanri.getZennouseisankgk().toString();
                            yenkansanreto = siBikinkanri.getShrkwsrate().toString();
                        }
                        else {

                            if (C_Tuukasyu.JPY.eq(siBikinkanri.getShrtuukasyu()) ||
                                C_Tuukasyu.BLNK.eq(siBikinkanri.getShrtuukasyu())) {

                                gkdtzennouseisankin = "";
                                yenkansanreto = "";
                            }
                            else {

                                gkdtzennouseisankin = siBikinkanri.getZennouseisankgk().toString();
                                yenkansanreto = siBikinkanri.getShrkwsrate().toString();
                            }
                        }
                    }

                    SiZennouseisankinMeisaiListDataSourceBean siZennouseisankinMeisaiListDataSourceBean = SWAKInjector.
                        getInstance(SiZennouseisankinMeisaiListDataSourceBean.class);

                    siZennouseisankinMeisaiListDataSourceBean.setIrBkncd(siBikinkanri.getBkncdkbn().getValue());
                    siZennouseisankinMeisaiListDataSourceBean.setIrHknsyruilevel(hknsyurui);
                    siZennouseisankinMeisaiListDataSourceBean.setIrBknkktiymd(DateFormatUtil
                        .dateKANJISeirekiNoZero(siBikinkanri.getBknkktymd()));
                    siZennouseisankinMeisaiListDataSourceBean.setIrSyono(siBikinkanri.getSyono());
                    siZennouseisankinMeisaiListDataSourceBean.setIrZennouseisankin(zennouseisankin.toFormatString());
                    siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibkncd("");
                    siZennouseisankinMeisaiListDataSourceBean.setIrGoukeihknsyruilevel("");
                    siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktinnd("");
                    siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktiym("");
                    siZennouseisankinMeisaiListDataSourceBean.setIrGoukeikensuu1(null);
                    siZennouseisankinMeisaiListDataSourceBean.setIrGoukeiseisankin(null);
                    siZennouseisankinMeisaiListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
                    siZennouseisankinMeisaiListDataSourceBean.setIrPageno(pageNum);

                    iReportDataSouceBeanLst.add(siZennouseisankinMeisaiListDataSourceBean);

                    SiZennouseisankinMeisaiListLayoutFile siZennouseisankinMeisaiListLayoutFile = SWAKInjector
                        .getInstance(SiZennouseisankinMeisaiListLayoutFile.class);

                    siZennouseisankinMeisaiListLayoutFile.setIfcListnm("前納精算金明細リスト");
                    siZennouseisankinMeisaiListLayoutFile
                    .setIfcAtesaki(YuyuSiharaiConfig.getInstance().getTantousitu());
                    siZennouseisankinMeisaiListLayoutFile.setIfcSakuseiymdseireki(FixedDateFormatter
                        .formatYMDSeirekiSlashZeroFill(batchParam.getSyoriYmd()));
                    siZennouseisankinMeisaiListLayoutFile.setIfcPageno(pageNum.toString());
                    siZennouseisankinMeisaiListLayoutFile.setIfcKessannnd(csvKsnNendo);
                    siZennouseisankinMeisaiListLayoutFile.setIfcSyoricd(siBikinkanri.getBkncdkbn().getValue());
                    siZennouseisankinMeisaiListLayoutFile.setIfcKbnkeirisegcd(siBikinkanri.getKbnkeirisegcd()
                        .getValue());
                    siZennouseisankinMeisaiListLayoutFile.setIfcHknsyruilevelcd(hknsyurui);
                    siZennouseisankinMeisaiListLayoutFile.setIfcBknkktiymdseireki(FixedDateFormatter
                        .formatYMDSeirekiSlashZeroFill(siBikinkanri.getBknkktymd()));
                    siZennouseisankinMeisaiListLayoutFile.setIfcBknkktinnd(siBikinkanri.getBknkktinnd());
                    siZennouseisankinMeisaiListLayoutFile.setIfcBknkktiym(siBikinkanri.getBknkktiym().toString());
                    siZennouseisankinMeisaiListLayoutFile.setIfcSyono(siBikinkanri.getSyono());
                    siZennouseisankinMeisaiListLayoutFile.setIfcZennouseisankin(zennouseisankin.toString());

                    if (syoruiukeymd != null) {

                        siZennouseisankinMeisaiListLayoutFile.setIfcSyoruiukeymdseireki(FixedDateFormatter
                            .formatYMDSeirekiSlashZeroFill(syoruiukeymd));
                    }
                    else {

                        siZennouseisankinMeisaiListLayoutFile.setIfcSyoruiukeymdseireki("");
                    }
                    siZennouseisankinMeisaiListLayoutFile.setIfcGaikaukthyoji(gaikaukthyoji);
                    siZennouseisankinMeisaiListLayoutFile.setIfcGkdtzennouseisankin(gkdtzennouseisankin);
                    siZennouseisankinMeisaiListLayoutFile.setIfcKawaserate(yenkansanreto);
                    siZennouseisankinMeisaiListLayoutFile.setIfcMissuhyj("");
                    siZennouseisankinMeisaiListLayoutFile.setIfcBikou1("");

                    siZennouseisankinMeisaiListLayoutFileLst.add(siZennouseisankinMeisaiListLayoutFile);
                }

                SiZennouseisankinMeisaiListDataSourceBean siZennouseisankinMeisaiListDataSourceBean =
                    (SiZennouseisankinMeisaiListDataSourceBean) iReportDataSouceBeanLst
                    .get(iReportDataSouceBeanLst.size() - 1);

                siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktiym(DateFormatUtil
                    .dateYmKANJI(bikinKktiNengetuBreakkey));
                siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktinnd(DateFormatUtil
                    .dateYKANJISeireki(bikinKktiNendoBreakkey).concat("度"));
                siZennouseisankinMeisaiListDataSourceBean.setIrGoukeihknsyruilevel(C_Segcd
                    .getContentByValue(C_Segcd.PATTERN_DEFAULT, hokenSyoruiBreakkey));
                siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibkncd(bikinCodeBreakkey);
                siZennouseisankinMeisaiListDataSourceBean.setIrGoukeikensuu1(BizNumber
                    .valueOf(bikinKktiNengetuSumBean.getSumkns()));
                siZennouseisankinMeisaiListDataSourceBean.setIrGoukeiseisankin(bikinKktiNengetuSumBean
                    .getSumseisankin().toFormatString());

                pageNum = pageNum + 1;

                iReportDataSouceBeanLst.add(getZennouseisankinLstNendoSum(bikinKktiNendoBreakkey,
                    hokenSyoruiBreakkey, bikinCodeBreakkey, bikinKktiNendoSumBean, pageNum));

                pageNum = pageNum + 1;

                iReportDataSouceBeanLst.add(getZennouseisankinLstHksyuruiSum(hokenSyoruiBreakkey,
                    bikinCodeBreakkey, hokenSyuruiSumBean, pageNum));

                pageNum = pageNum + 1;

                iReportDataSouceBeanLst.add(getZennouseisankinLstBkcodeSum(bikinCodeBreakkey,
                    bikinCodeSumBean, pageNum));

                pageNum = pageNum + 1;
            }

            String hozonKknTani = ViewReport.getHozonKknTani(C_SyoruiCdKbn.HK_ZENNOUSEISANKINMEISAILIST);

            SiZennouseisankinMeisaiListBean siZennouseisankinMeisaiListBean = SWAKInjector
                .getInstance(SiZennouseisankinMeisaiListBean.class);

            siZennouseisankinMeisaiListBean.setIrAtesaki(tuhuyuAtsk);
            siZennouseisankinMeisaiListBean.setIrKessannnd(ksnNendo);
            siZennouseisankinMeisaiListBean.setIrBknkessankbn(bknkessankbn);
            siZennouseisankinMeisaiListBean.setIrTyouhyousakuseiymd(DateFormatUtil.dateKANJISeirekiNoZero(batchParam
                .getSyoriYmd()));
            siZennouseisankinMeisaiListBean.setIrHozonkkn(hozonKknTani);

            CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                TeisuuSiharai.SUBSYSTEMID_SIHARAI,
                kinou.getCategoryId(),
                kinou.getKinouId(),
                C_SyoruiCdKbn.HK_ZENNOUSEISANKINMEISAILIST);

            reportServicesBean.setSyoriYmd(batchParam.getSyoriYmd());

            reportServicesBean.addParamObjects(C_SyoruiCdKbn.HK_ZENNOUSEISANKINMEISAILIST, iReportDataSouceBeanLst,
                siZennouseisankinMeisaiListBean);

            createReport.execNoCommit(reportServicesBean);

            BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

            C_ErrorKbn errorKbn = bzFileUploadUtil.exec(
                C_FileSyuruiCdKbn.SI_ZENNOUSEISANKINMEISAIFILE,
                siZennouseisankinMeisaiListLayoutFileLst,
                true);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(outKensuu),
            kinou.getKinouNm()));
    }

    private SiZennouseisankinMeisaiListDataSourceBean getZennouseisankinLstNendoSum(String pBknkktinnd,
        String pKbnkeirisegcd, String pBkncd,
        ZennouseisankinMeisaiLstSumNaibuBean pZennouseisankinMeisaiLstSumNaibuBean, Integer pPageno) {

        SiZennouseisankinMeisaiListDataSourceBean siZennouseisankinMeisaiListDataSourceBean = SWAKInjector.
            getInstance(SiZennouseisankinMeisaiListDataSourceBean.class);

        siZennouseisankinMeisaiListDataSourceBean.setIrBkncd("");
        siZennouseisankinMeisaiListDataSourceBean.setIrHknsyruilevel("");
        siZennouseisankinMeisaiListDataSourceBean.setIrBknkktiymd("");
        siZennouseisankinMeisaiListDataSourceBean.setIrSyono("");
        siZennouseisankinMeisaiListDataSourceBean.setIrZennouseisankin("");
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibkncd(pBkncd);
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeihknsyruilevel(C_Segcd.getContentByValue(
            C_Segcd.PATTERN_DEFAULT, pKbnkeirisegcd));
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktinnd(DateFormatUtil.dateYKANJISeireki(pBknkktinnd)
            .concat("度"));
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktiym("");
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeikensuu1(BizNumber
            .valueOf(pZennouseisankinMeisaiLstSumNaibuBean.getSumkns()));
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeiseisankin(pZennouseisankinMeisaiLstSumNaibuBean
            .getSumseisankin().toFormatString());
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siZennouseisankinMeisaiListDataSourceBean.setIrPageno(pPageno);

        return siZennouseisankinMeisaiListDataSourceBean;
    }

    private SiZennouseisankinMeisaiListDataSourceBean getZennouseisankinLstHksyuruiSum(String pKbnkeirisegcd,
        String pBkncd, ZennouseisankinMeisaiLstSumNaibuBean pZennouseisankinMeisaiLstSumNaibuBean, Integer pPageno) {

        SiZennouseisankinMeisaiListDataSourceBean siZennouseisankinMeisaiListDataSourceBean = SWAKInjector.
            getInstance(SiZennouseisankinMeisaiListDataSourceBean.class);

        siZennouseisankinMeisaiListDataSourceBean.setIrBkncd("");
        siZennouseisankinMeisaiListDataSourceBean.setIrHknsyruilevel("");
        siZennouseisankinMeisaiListDataSourceBean.setIrBknkktiymd("");
        siZennouseisankinMeisaiListDataSourceBean.setIrSyono("");
        siZennouseisankinMeisaiListDataSourceBean.setIrZennouseisankin("");
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibkncd(pBkncd);
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeihknsyruilevel(C_Segcd.getContentByValue(
            C_Segcd.PATTERN_DEFAULT, pKbnkeirisegcd));
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktinnd("");
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktiym("");
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeikensuu1(BizNumber
            .valueOf(pZennouseisankinMeisaiLstSumNaibuBean.getSumkns()));
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeiseisankin(pZennouseisankinMeisaiLstSumNaibuBean
            .getSumseisankin().toFormatString());
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siZennouseisankinMeisaiListDataSourceBean.setIrPageno(pPageno);

        return siZennouseisankinMeisaiListDataSourceBean;
    }

    private SiZennouseisankinMeisaiListDataSourceBean getZennouseisankinLstBkcodeSum(String pBkncd,
        ZennouseisankinMeisaiLstSumNaibuBean pZennouseisankinMeisaiLstSumNaibuBean, Integer pPageno) {

        SiZennouseisankinMeisaiListDataSourceBean siZennouseisankinMeisaiListDataSourceBean = SWAKInjector.
            getInstance(SiZennouseisankinMeisaiListDataSourceBean.class);

        siZennouseisankinMeisaiListDataSourceBean.setIrBkncd("");
        siZennouseisankinMeisaiListDataSourceBean.setIrHknsyruilevel("");
        siZennouseisankinMeisaiListDataSourceBean.setIrBknkktiymd("");
        siZennouseisankinMeisaiListDataSourceBean.setIrSyono("");
        siZennouseisankinMeisaiListDataSourceBean.setIrZennouseisankin("");
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibkncd(pBkncd);
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeihknsyruilevel("");
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktinnd("");
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeibknkktiym("");
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeikensuu1(BizNumber
            .valueOf(pZennouseisankinMeisaiLstSumNaibuBean.getSumkns()));
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeiseisankin(pZennouseisankinMeisaiLstSumNaibuBean
            .getSumseisankin().toFormatString());
        siZennouseisankinMeisaiListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siZennouseisankinMeisaiListDataSourceBean.setIrPageno(pPageno);

        return siZennouseisankinMeisaiListDataSourceBean;
    }

    class ZennouseisankinMeisaiLstSumNaibuBean  {

        private long sumkns;

        private BizCurrency sumseisankin;

        protected ZennouseisankinMeisaiLstSumNaibuBean() {

            sumkns = 0;
            sumseisankin = BizCurrency.valueOf(0);
        }

        public long getSumkns() {
            return sumkns;
        }

        protected void setSumkns(long pSumkns) {
            sumkns = pSumkns;
        }

        public BizCurrency getSumseisankin() {
            return sumseisankin;
        }

        protected void setSumseisankin(BizCurrency pSumseisankin) {
            sumseisankin = pSumseisankin;
        }
    }
}
