package yuyu.batch.siharai.sikessan.simakebikinjikou;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.google.common.collect.Lists;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
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
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_Bknkessankbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.siharai.bean.report.SiBikinjikouListBean;
import yuyu.def.siharai.bean.report.SiBikinjikouListDataSourceBean;
import yuyu.def.siharai.configuration.YuyuSiharaiConfig;
import yuyu.def.siharai.file.csv.SiBikinjikouListLayoutFile;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 保険金給付金支払 決算 保険金給付金備金時効リスト作成
 */
public class SiMakeBikinJikouBatch implements Batch {

    private static final String TUSTTISUTABLEID = "JT_SiBikinkanri";

    private static final String RIKABARIFILEKUBUNID = "Si001";

    private BizDate kessanKijyunYmd;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam batchParam;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private CreateReport createReport;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {
        BizDate syoriYmd = batchParam.getSyoriYmd();

        String ibKakutyoujobcd = batchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        String tuhuyuAtsk = ViewReport.editOntyuu(YuyuSiharaiConfig.getInstance().getTantousitu() + "－" +
            ConvertUtil.toZenAlphabet(C_TantouCdKbn.SIBOUTETUZUKI.getValue(), 0));

        if (syoriYmd.getDay() <= 15) {

            kessanKijyunYmd = syoriYmd.getPreviousMonth().getBizDateYM().getLastDay();
        }

        else {

            kessanKijyunYmd = syoriYmd.getBizDateYM().getLastDay();
        }

        C_Bknkessankbn bknkessankbn = C_Bknkessankbn.BLNK;

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

        long syuturyokuKensuu = 0;
        List<SiBikinjikouListLayoutFile> siBikinjikouListLayoutFileLst = Lists.newArrayList();
        List<IReportDataSouceBean> iReportDataSouceBeanLst = Lists.newArrayList();

        try (ExDBResults<JT_SiBikinkanri> siBikinkanriLst =
            siharaiDomManager.getSiBikinkanrisByKakutyoujobcdItems(ibKakutyoujobcd, kessanKijyunYmd, C_BknrigiKbn.DEL)) {

            Iterator<JT_SiBikinkanri> siBikinkanriIter = siBikinkanriLst.iterator();
            if (siBikinkanriIter.hasNext()) {

                Integer pageNum = 1;
                long pageGyousuu１ = 0;
                String hokenSyorui = null;
                String siharaiHyouji = null;
                String sinsaHyouji = null;
                String soukiHyouji = null;
                BikinJikouListSyuukeiNaibuBean bikinKktiNengetuSyuukeiNaibuBean = SWAKInjector.
                    getInstance(BikinJikouListSyuukeiNaibuBean.class);
                BikinJikouListSyuukeiNaibuBean bikinKktiNendoSyuukeiNaibuBean = SWAKInjector.
                    getInstance(BikinJikouListSyuukeiNaibuBean.class);
                BikinJikouListSyuukeiNaibuBean hokenSyoruiSyuukeiNaibuBean = SWAKInjector.
                    getInstance(BikinJikouListSyuukeiNaibuBean.class);
                BikinJikouListSyuukeiNaibuBean kyhSyuruiSyuukeiNaibuBean = SWAKInjector.
                    getInstance(BikinJikouListSyuukeiNaibuBean.class);
                BikinJikouListSyuukeiNaibuBean bikinCodeSyuukeiNaibuBean = SWAKInjector.
                    getInstance(BikinJikouListSyuukeiNaibuBean.class);
                String bikinKktiNengetuBreakkey = null;
                String bikinKktiNendoBreakkey = null;
                String hokenSyoruiBreakkey = null;
                String kyhSyuruiBreakkey = null;
                String bikinCodeBreakkey = null;

                while (siBikinkanriIter.hasNext()) {

                    JT_SiBikinkanri siBikinkanri = siBikinkanriIter.next();
                    bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobcd);
                    bzRecoveryDatasikibetuBean.setIbTableid(TUSTTISUTABLEID);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RIKABARIFILEKUBUNID);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(siBikinkanri.getSyono());
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(siBikinkanri.getSkno());

                    if (syuturyokuKensuu == 0) {
                        bikinKktiNengetuBreakkey = String.valueOf(siBikinkanri.getBknkktiym());

                        bikinKktiNendoBreakkey = siBikinkanri.getBknkktinnd();

                        hokenSyoruiBreakkey = siBikinkanri.getKbnkeirisegcd().getValue();

                        kyhSyuruiBreakkey = siBikinkanri.getHokenkinsyuruikbn().getValue();

                        bikinCodeBreakkey = siBikinkanri.getSyuukeiyoubkncdkbn().getValue();
                    }
                    else {
                        if (!siBikinkanri.getSyuukeiyoubkncdkbn().getValue().equals(bikinCodeBreakkey)) {
                            pageNum = pageNum + 1;

                            iReportDataSouceBeanLst.add(getBikinjikouListYm(bikinCodeBreakkey, kyhSyuruiBreakkey,
                                hokenSyoruiBreakkey, bikinKktiNendoBreakkey, bikinKktiNengetuBreakkey,
                                bikinKktiNengetuSyuukeiNaibuBean, pageNum));

                            pageNum = pageNum + 1;

                            iReportDataSouceBeanLst.add(getBikinjikouListY(bikinCodeBreakkey, kyhSyuruiBreakkey,
                                hokenSyoruiBreakkey, bikinKktiNendoBreakkey, bikinKktiNendoSyuukeiNaibuBean, pageNum));

                            pageNum = pageNum + 1;

                            iReportDataSouceBeanLst.add(getBikinjikouListHoｋenSyurui(bikinCodeBreakkey,
                                kyhSyuruiBreakkey, hokenSyoruiBreakkey, hokenSyoruiSyuukeiNaibuBean, pageNum));

                            pageNum = pageNum + 1;

                            if (!C_BkncdKbn.MENSEKI.getValue().equals(bikinCodeBreakkey)
                                && !C_BkncdKbn.SIBOUKAIJYO.getValue().equals(bikinCodeBreakkey)) {

                                iReportDataSouceBeanLst.add(getBikinjikouListKyhSyurui(bikinCodeBreakkey,
                                    kyhSyuruiBreakkey, kyhSyuruiSyuukeiNaibuBean, pageNum));

                                pageNum = pageNum + 1;
                            }

                            iReportDataSouceBeanLst.add(getBikinjikouListBikinCode(bikinCodeBreakkey,
                                bikinCodeSyuukeiNaibuBean, pageNum));

                            pageNum = pageNum + 1;

                            bikinKktiNengetuBreakkey = String.valueOf(siBikinkanri.getBknkktiym());

                            bikinKktiNendoBreakkey = siBikinkanri.getBknkktinnd();

                            hokenSyoruiBreakkey = siBikinkanri.getKbnkeirisegcd().getValue();

                            kyhSyuruiBreakkey = siBikinkanri.getHokenkinsyuruikbn().getValue();

                            bikinCodeBreakkey = siBikinkanri.getSyuukeiyoubkncdkbn().getValue();

                            pageGyousuu１ = 0;

                            bikinKktiNengetuSyuukeiNaibuBean = SWAKInjector.
                                getInstance(BikinJikouListSyuukeiNaibuBean.class);
                            bikinKktiNendoSyuukeiNaibuBean = SWAKInjector.
                                getInstance(BikinJikouListSyuukeiNaibuBean.class);
                            hokenSyoruiSyuukeiNaibuBean = SWAKInjector.
                                getInstance(BikinJikouListSyuukeiNaibuBean.class);
                            kyhSyuruiSyuukeiNaibuBean = SWAKInjector.
                                getInstance(BikinJikouListSyuukeiNaibuBean.class);
                            bikinCodeSyuukeiNaibuBean = SWAKInjector.
                                getInstance(BikinJikouListSyuukeiNaibuBean.class);
                        }
                        else if (!siBikinkanri.getHokenkinsyuruikbn().getValue().equals(kyhSyuruiBreakkey)) {
                            pageNum = pageNum + 1;

                            iReportDataSouceBeanLst.add(getBikinjikouListYm(bikinCodeBreakkey, kyhSyuruiBreakkey,
                                hokenSyoruiBreakkey, bikinKktiNendoBreakkey, bikinKktiNengetuBreakkey,
                                bikinKktiNengetuSyuukeiNaibuBean, pageNum));

                            pageNum = pageNum + 1;

                            iReportDataSouceBeanLst.add(getBikinjikouListY(bikinCodeBreakkey, kyhSyuruiBreakkey,
                                hokenSyoruiBreakkey, bikinKktiNendoBreakkey, bikinKktiNendoSyuukeiNaibuBean, pageNum));

                            pageNum = pageNum + 1;

                            iReportDataSouceBeanLst.add(getBikinjikouListHoｋenSyurui(bikinCodeBreakkey,
                                kyhSyuruiBreakkey, hokenSyoruiBreakkey, hokenSyoruiSyuukeiNaibuBean, pageNum));

                            pageNum = pageNum + 1;

                            if (!C_BkncdKbn.MENSEKI.getValue().equals(bikinCodeBreakkey)
                                && !C_BkncdKbn.SIBOUKAIJYO.getValue().equals(bikinCodeBreakkey)) {

                                iReportDataSouceBeanLst.add(getBikinjikouListKyhSyurui(bikinCodeBreakkey,
                                    kyhSyuruiBreakkey, kyhSyuruiSyuukeiNaibuBean, pageNum));

                                pageNum = pageNum + 1;
                            }

                            bikinKktiNengetuBreakkey = String.valueOf(siBikinkanri.getBknkktiym());

                            bikinKktiNendoBreakkey = siBikinkanri.getBknkktinnd();

                            hokenSyoruiBreakkey = siBikinkanri.getKbnkeirisegcd().getValue();

                            kyhSyuruiBreakkey = siBikinkanri.getHokenkinsyuruikbn().getValue();

                            pageGyousuu１ = 0;

                            bikinKktiNengetuSyuukeiNaibuBean = SWAKInjector.
                                getInstance(BikinJikouListSyuukeiNaibuBean.class);
                            bikinKktiNendoSyuukeiNaibuBean = SWAKInjector.
                                getInstance(BikinJikouListSyuukeiNaibuBean.class);
                            hokenSyoruiSyuukeiNaibuBean = SWAKInjector.
                                getInstance(BikinJikouListSyuukeiNaibuBean.class);
                            kyhSyuruiSyuukeiNaibuBean = SWAKInjector.
                                getInstance(BikinJikouListSyuukeiNaibuBean.class);
                        }
                        else if (!siBikinkanri.getKbnkeirisegcd().getValue().equals(hokenSyoruiBreakkey)) {
                            pageNum = pageNum + 1;

                            iReportDataSouceBeanLst.add(getBikinjikouListYm(bikinCodeBreakkey, kyhSyuruiBreakkey,
                                hokenSyoruiBreakkey, bikinKktiNendoBreakkey, bikinKktiNengetuBreakkey,
                                bikinKktiNengetuSyuukeiNaibuBean, pageNum));

                            pageNum = pageNum + 1;

                            iReportDataSouceBeanLst.add(getBikinjikouListY(bikinCodeBreakkey, kyhSyuruiBreakkey,
                                hokenSyoruiBreakkey, bikinKktiNendoBreakkey, bikinKktiNendoSyuukeiNaibuBean, pageNum));

                            pageNum = pageNum + 1;

                            iReportDataSouceBeanLst.add(getBikinjikouListHoｋenSyurui(bikinCodeBreakkey,
                                kyhSyuruiBreakkey, hokenSyoruiBreakkey, hokenSyoruiSyuukeiNaibuBean, pageNum));

                            pageNum = pageNum + 1;

                            bikinKktiNengetuBreakkey = String.valueOf(siBikinkanri.getBknkktiym());

                            bikinKktiNendoBreakkey = siBikinkanri.getBknkktinnd();

                            hokenSyoruiBreakkey = siBikinkanri.getKbnkeirisegcd().getValue();

                            pageGyousuu１ = 0;

                            bikinKktiNengetuSyuukeiNaibuBean = SWAKInjector.
                                getInstance(BikinJikouListSyuukeiNaibuBean.class);
                            bikinKktiNendoSyuukeiNaibuBean = SWAKInjector.
                                getInstance(BikinJikouListSyuukeiNaibuBean.class);
                            hokenSyoruiSyuukeiNaibuBean = SWAKInjector.
                                getInstance(BikinJikouListSyuukeiNaibuBean.class);
                        }
                        else if (!siBikinkanri.getBknkktinnd().equals(bikinKktiNendoBreakkey)) {
                            pageNum = pageNum + 1;

                            iReportDataSouceBeanLst.add(getBikinjikouListYm(bikinCodeBreakkey, kyhSyuruiBreakkey,
                                hokenSyoruiBreakkey, bikinKktiNendoBreakkey, bikinKktiNengetuBreakkey,
                                bikinKktiNengetuSyuukeiNaibuBean, pageNum));

                            pageNum = pageNum + 1;

                            iReportDataSouceBeanLst.add(getBikinjikouListY(bikinCodeBreakkey, kyhSyuruiBreakkey,
                                hokenSyoruiBreakkey, bikinKktiNendoBreakkey, bikinKktiNendoSyuukeiNaibuBean, pageNum));

                            pageNum = pageNum + 1;

                            bikinKktiNengetuBreakkey = String.valueOf(siBikinkanri.getBknkktiym());

                            bikinKktiNendoBreakkey = siBikinkanri.getBknkktinnd();

                            pageGyousuu１ = 0;

                            bikinKktiNengetuSyuukeiNaibuBean = SWAKInjector.
                                getInstance(BikinJikouListSyuukeiNaibuBean.class);
                            bikinKktiNendoSyuukeiNaibuBean = SWAKInjector.
                                getInstance(BikinJikouListSyuukeiNaibuBean.class);
                        }
                        else if (!String.valueOf(siBikinkanri.getBknkktiym()).equals(bikinKktiNengetuBreakkey)) {
                            pageNum = pageNum + 1;

                            iReportDataSouceBeanLst.add(getBikinjikouListYm(bikinCodeBreakkey, kyhSyuruiBreakkey,
                                hokenSyoruiBreakkey, bikinKktiNendoBreakkey, bikinKktiNengetuBreakkey,
                                bikinKktiNengetuSyuukeiNaibuBean, pageNum));

                            pageNum = pageNum + 1;

                            bikinKktiNengetuBreakkey = String.valueOf(siBikinkanri.getBknkktiym());

                            pageGyousuu１ = 0;

                            bikinKktiNengetuSyuukeiNaibuBean = SWAKInjector.
                                getInstance(BikinJikouListSyuukeiNaibuBean.class);
                        }
                        else {
                            if (pageGyousuu１ == 37) {
                                pageNum = pageNum + 1;

                                pageGyousuu１ = 0;
                            }
                        }
                    }

                    syuturyokuKensuu = syuturyokuKensuu + 1;

                    pageGyousuu１ = pageGyousuu１ + 1;

                    bikinKktiNengetuSyuukeiNaibuBean.setKensuu1(bikinKktiNengetuSyuukeiNaibuBean.getKensuu1() + 1);

                    bikinKktiNengetuSyuukeiNaibuBean.setKingaku1(bikinKktiNengetuSyuukeiNaibuBean.getKingaku1().
                        add(siBikinkanri.getBkngk()));

                    bikinKktiNendoSyuukeiNaibuBean.setKensuu1(bikinKktiNendoSyuukeiNaibuBean.getKensuu1() + 1);

                    bikinKktiNendoSyuukeiNaibuBean.setKingaku1(bikinKktiNendoSyuukeiNaibuBean.getKingaku1().
                        add(siBikinkanri.getBkngk()));

                    hokenSyoruiSyuukeiNaibuBean.setKensuu1(hokenSyoruiSyuukeiNaibuBean.getKensuu1() + 1);

                    hokenSyoruiSyuukeiNaibuBean.setKingaku1(hokenSyoruiSyuukeiNaibuBean.getKingaku1().
                        add(siBikinkanri.getBkngk()));

                    kyhSyuruiSyuukeiNaibuBean.setKensuu1(kyhSyuruiSyuukeiNaibuBean.getKensuu1() + 1);

                    kyhSyuruiSyuukeiNaibuBean.setKingaku1(kyhSyuruiSyuukeiNaibuBean.getKingaku1().
                        add(siBikinkanri.getBkngk()));

                    bikinCodeSyuukeiNaibuBean.setKensuu1(bikinCodeSyuukeiNaibuBean.getKensuu1() + 1);

                    bikinCodeSyuukeiNaibuBean.setKingaku1(bikinCodeSyuukeiNaibuBean.getKingaku1().
                        add(siBikinkanri.getBkngk()));

                    hokenSyorui = C_Segcd.valueOf(siBikinkanri.getKbnkeirisegcd().getValue()).getContent();

                    if (C_UmuKbn.ARI.eq(siBikinkanri.getShrumu())) {
                        siharaiHyouji = "*";
                    }
                    else {
                        siharaiHyouji = "";
                    }

                    if (C_UmuKbn.ARI.eq(siBikinkanri.getSinsaumukbn())) {
                        sinsaHyouji = "*";
                    }
                    else {
                        sinsaHyouji = "";
                    }

                    if (C_UmuKbn.ARI.eq(siBikinkanri.getSoukiumukbn())) {
                        soukiHyouji = "*";
                    }
                    else {
                        soukiHyouji = "";
                    }

                    BizDate syoruiukeymd = siBikinkanri.getSyoruiukeymd();
                    if (siBikinkanri.getHubikanryouymd() != null) {
                        syoruiukeymd = siBikinkanri.getHubikanryouymd();
                    }

                    String yenukthyoji = C_Tuukasyu.JPY.eq(siBikinkanri.getShrtuukasyu()) ? "*" : "";

                    BizCurrency siteituukahokenkngk;
                    BizCurrency yenkasaiteihsygk;
                    if (C_BknrigiKbn.ADD.eq(siBikinkanri.getBknrigikbn())) {
                        siteituukahokenkngk = null;
                        yenkasaiteihsygk = null;
                    } else {
                        siteituukahokenkngk = siBikinkanri.getShrgk();
                        if (BizUtil.isZero(siBikinkanri.getInitsbjiyenkasaiteihsygk())) {
                            yenkasaiteihsygk = null;
                        } else {
                            yenkasaiteihsygk = siBikinkanri.getInitsbjiyenkasaiteihsygk();
                        }
                    }

                    String syoumetuumu = C_UmuKbn.ARI.eq(siBikinkanri.getSyoumetuumukbn()) ? "*" : "";

                    String kyhsyurui = siBikinkanri.getHokenkinsyuruikbn().getContent(
                        C_HokenkinsyuruiKbn.PATTERN_KYHSYURUI);

                    String bikinkbn = siBikinkanri.getHokenkinsyuruikbn().getContent(
                        C_HokenkinsyuruiKbn.PATTERN_REPORT);

                    String irknsnkijyunymd;
                    String ifcknsnkijyunymd;
                    BizNumber yenkansantkykwsrate;
                    String ptumitatekin;
                    String kaiyakuhr;
                    BizCurrency hikakuseisankgk;
                    String seisankgk;

                    if (C_Tuukasyu.JPY.eq(siBikinkanri.getKyktuukasyu())) {
                        yenukthyoji = "";
                        irknsnkijyunymd = "";
                        ifcknsnkijyunymd = "";
                        yenkansantkykwsrate = null;
                        siteituukahokenkngk = null;
                        yenkasaiteihsygk = null;
                        ptumitatekin = siBikinkanri.getTutakngk().toString();
                        kaiyakuhr = siBikinkanri.getKaiyakuhr().toString();
                        hikakuseisankgk = siBikinkanri.getSeisankgk();
                    } else {
                        irknsnkijyunymd = DateFormatUtil.dateDOT(siBikinkanri.getShrkwsratekjnymd());
                        ifcknsnkijyunymd = FixedDateFormatter.formatYMDSeirekiSlashZeroFill(siBikinkanri.getShrkwsratekjnymd());
                        yenkansantkykwsrate = siBikinkanri.getShrkwsrate();
                        ptumitatekin = siBikinkanri.getYentutakngk().toString();
                        kaiyakuhr = siBikinkanri.getYenkaiyakuhr().toString();
                        hikakuseisankgk = siBikinkanri.getYenkaseisankgk();
                    }

                    if (hikakuseisankgk.equalsValue(BizCurrency.valueOf(0, hikakuseisankgk.getType()))) {
                        seisankgk = "";
                    } else {
                        seisankgk = hikakuseisankgk.toString();
                    }

                    SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBean = SWAKInjector.
                        getInstance(SiBikinjikouListDataSourceBean.class);

                    siBikinjikouListDataSourceBean.setIrHknsyurui(hokenSyorui);
                    siBikinjikouListDataSourceBean.setIrBkncd(siBikinkanri.getBkncdkbn().getValue());
                    siBikinjikouListDataSourceBean.setIrSiharaiumu(siharaiHyouji);
                    siBikinjikouListDataSourceBean.setIrBknkktiymd(
                        DateFormatUtil.dateDOT(siBikinkanri.getBknkktymd()));
                    siBikinjikouListDataSourceBean.setIrCalckijyunymd(
                        DateFormatUtil.dateDOT(siBikinkanri.getCalckijyunymd()));
                    siBikinjikouListDataSourceBean.setIrSisyacd(siBikinkanri.getSisyacd());
                    siBikinjikouListDataSourceBean.setIrKigou(siBikinkanri.getSyouhncd().substring(0, 2));
                    siBikinjikouListDataSourceBean.setIrSyono(siBikinkanri.getSyono());
                    siBikinjikouListDataSourceBean.setIrBkngk(siBikinkanri.getBkngk());
                    if (syoruiukeymd != null) {
                        siBikinjikouListDataSourceBean.setIrSyoruiukeymd(DateFormatUtil.dateDOT(syoruiukeymd));
                    } else {
                        siBikinjikouListDataSourceBean.setIrSyoruiukeymd("");
                    }
                    siBikinjikouListDataSourceBean.setIrYenukthyoji(yenukthyoji);
                    siBikinjikouListDataSourceBean.setIrKnsnkijyunymd(irknsnkijyunymd);
                    siBikinjikouListDataSourceBean.setIrYenkansantkykwsrate(yenkansantkykwsrate);
                    if (siteituukahokenkngk != null) {
                        siBikinjikouListDataSourceBean.setIrSiteituukahokenkngk(ViewReport.editCommaTuuka(
                            siteituukahokenkngk, BizUtil.ZERO_FILL));
                    } else {
                        siBikinjikouListDataSourceBean.setIrSiteituukahokenkngk("");
                    }
                    if (yenkasaiteihsygk != null) {
                        siBikinjikouListDataSourceBean
                        .setIrYenkasaiteihsygk(BizUtil.comma(yenkasaiteihsygk.toString()));
                    } else {
                        siBikinjikouListDataSourceBean.setIrYenkasaiteihsygk("");
                    }
                    siBikinjikouListDataSourceBean.setIrKihons(siBikinkanri.getKihons());
                    siBikinjikouListDataSourceBean.setIrTks(null);
                    siBikinjikouListDataSourceBean.setIrTkkigou("");
                    siBikinjikouListDataSourceBean.setIrKata("");
                    siBikinjikouListDataSourceBean.setIrSaisiumu("");
                    siBikinjikouListDataSourceBean.setIrSinsaumu(sinsaHyouji);
                    siBikinjikouListDataSourceBean.setIrSoukiumu(soukiHyouji);
                    siBikinjikouListDataSourceBean.setIrSakugenumu("");
                    siBikinjikouListDataSourceBean.setIrTenkanumu("");
                    siBikinjikouListDataSourceBean.setIrSyuukeiinfo1("");
                    siBikinjikouListDataSourceBean.setIrSyuukeiinfo2("");
                    siBikinjikouListDataSourceBean.setIrSyuukeiinfo3("");
                    siBikinjikouListDataSourceBean.setIrSyuukeiinfo4("");
                    siBikinjikouListDataSourceBean.setIrSyuukeiinfo5("");
                    siBikinjikouListDataSourceBean.setIrUtiwake1("");
                    siBikinjikouListDataSourceBean.setIrKensuu1(null);
                    siBikinjikouListDataSourceBean.setIrKingaku1(null);
                    siBikinjikouListDataSourceBean.setIrBikinjikoulistgoukeitani("");
                    siBikinjikouListDataSourceBean.setIrBikinjikoulistgoukeicount(null);
                    siBikinjikouListDataSourceBean.setIrKingakugoukei(null);
                    siBikinjikouListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
                    siBikinjikouListDataSourceBean.setIrPageno(pageNum);

                    iReportDataSouceBeanLst.add(siBikinjikouListDataSourceBean);
                    SiBikinjikouListLayoutFile siBikinjikouListLayoutFile = SWAKInjector.
                        getInstance(SiBikinjikouListLayoutFile.class);

                    siBikinjikouListLayoutFile.setIfcListnm("備金時効リスト");
                    siBikinjikouListLayoutFile.setIfcAtesaki(YuyuSiharaiConfig.getInstance().getTantousitu());
                    siBikinjikouListLayoutFile.setIfcSakuseiymdseireki(FixedDateFormatter.formatYMDSeirekiSlashZeroFill(syoriYmd));
                    siBikinjikouListLayoutFile.setIfcPageno(pageNum.toString());
                    siBikinjikouListLayoutFile.setIfcHknsyruilevelcd(siBikinkanri.getKbnkeirisegcd().getValue());
                    siBikinjikouListLayoutFile.setIfcHknsyurui(hokenSyorui);
                    siBikinjikouListLayoutFile.setIfcKessannnd(csvKsnNendo);
                    siBikinjikouListLayoutFile.setIfcBkncd(siBikinkanri.getBkncdkbn().getValue());
                    siBikinjikouListLayoutFile.setIfcKyhsyurui(kyhsyurui);
                    siBikinjikouListLayoutFile.setIfcHknknsyruiname(bikinkbn);
                    siBikinjikouListLayoutFile.setIfcShrhyj(siharaiHyouji);
                    siBikinjikouListLayoutFile.setIfcBknkktiymdseireki(
                        FixedDateFormatter.formatYMDSeirekiSlashZeroFill(siBikinkanri.getBknkktymd()));
                    siBikinjikouListLayoutFile.setIfcCalckijyunymd(
                        FixedDateFormatter.formatYMDSeirekiSlashZeroFill(siBikinkanri.getCalckijyunymd()));
                    siBikinjikouListLayoutFile.setIfcSisyacd(siBikinkanri.getSisyacd());
                    siBikinjikouListLayoutFile.setIfcKigou(siBikinkanri.getSyouhncd().substring(0, 2));
                    siBikinjikouListLayoutFile.setIfcSyono(siBikinkanri.getSyono());
                    siBikinjikouListLayoutFile.setIfcBkngk(siBikinkanri.getBkngk().toString());
                    if (syoruiukeymd != null) {
                        siBikinjikouListLayoutFile.setIfcSyoruiukeymdseireki(
                            FixedDateFormatter.formatYMDSeirekiSlashZeroFill(syoruiukeymd));
                    } else {
                        siBikinjikouListLayoutFile.setIfcSyoruiukeymdseireki("");
                    }
                    siBikinjikouListLayoutFile.setIfcYenukthyoji(yenukthyoji);
                    siBikinjikouListLayoutFile.setIfcKnsnkijyunymd(ifcknsnkijyunymd);
                    if (yenkansantkykwsrate != null) {
                        siBikinjikouListLayoutFile.setIfcYenkansantkykwsrate(yenkansantkykwsrate.toString());
                    } else {
                        siBikinjikouListLayoutFile.setIfcYenkansantkykwsrate("");
                    }
                    if (siteituukahokenkngk != null) {
                        siBikinjikouListLayoutFile.setIfcSiteituukahokenkngk(siteituukahokenkngk.toString());
                    } else {
                        siBikinjikouListLayoutFile.setIfcSiteituukahokenkngk("");
                    }
                    if (yenkasaiteihsygk != null) {
                        siBikinjikouListLayoutFile.setIfcYenkasaiteihsygk(yenkasaiteihsygk.toString());
                    } else {
                        siBikinjikouListLayoutFile.setIfcYenkasaiteihsygk("");
                    }
                    siBikinjikouListLayoutFile.setIfcKihons(siBikinkanri.getKihons().toString());
                    siBikinjikouListLayoutFile.setIfcTks("");
                    siBikinjikouListLayoutFile.setIfcTkkigou("");
                    siBikinjikouListLayoutFile.setIfcKata("");
                    siBikinjikouListLayoutFile.setIfcSaisikbn("");
                    siBikinjikouListLayoutFile.setIfcSinsahyj(sinsaHyouji);
                    siBikinjikouListLayoutFile.setIfcSoukihyj(soukiHyouji);
                    siBikinjikouListLayoutFile.setIfcSkgnhyj("");
                    siBikinjikouListLayoutFile.setIfcTnknhyj("");
                    siBikinjikouListLayoutFile.setIfcKihonstuukasyurui(siBikinkanri.getKyktuukasyu().toString());
                    siBikinjikouListLayoutFile.setIfcGenzaikoutei(siBikinkanri.getKinoussnm());
                    if (siBikinkanri.getShrsyoriymd() != null) {
                        siBikinjikouListLayoutFile.setIfcKessaiymdsatei(
                            FixedDateFormatter.formatYMDSeirekiSlashZeroFill(siBikinkanri.getShrsyoriymd()));
                    }
                    siBikinjikouListLayoutFile.setIfcShrkekkakbn(siBikinkanri.getShrkekkakbn());
                    siBikinjikouListLayoutFile.setIfcHushrgeninkbn(siBikinkanri.getHushrgeninkbn());
                    siBikinjikouListLayoutFile.setIfcSiinkbn(siBikinkanri.getSiinkbn());
                    siBikinjikouListLayoutFile.setIfcSuketorihouhoukbn(siBikinkanri.getSuketorihouhoukbn());
                    siBikinjikouListLayoutFile.setIfcPtumitatekin(ptumitatekin);
                    siBikinjikouListLayoutFile.setIfcKaiyakuhr(kaiyakuhr);
                    siBikinjikouListLayoutFile.setIfcBknjkukbn(siBikinkanri.getBknjkukbn());
                    siBikinjikouListLayoutFile.setIfcGengkumukbn(siBikinkanri.getGengkumukbn());
                    if (siBikinkanri.getGengkymd() != null) {
                        siBikinjikouListLayoutFile.setIfcGengksyoriymd(
                            FixedDateFormatter.formatYMDSeirekiSlashZeroFill(siBikinkanri.getGengkymd()));
                    }
                    siBikinjikouListLayoutFile.setIfcSyoumetuumu(syoumetuumu);
                    siBikinjikouListLayoutFile.setIfcSeisankgk(seisankgk);

                    siBikinjikouListLayoutFileLst.add(siBikinjikouListLayoutFile);
                }

                bzRecoveryDatasikibetuBean.initializeBlank();

                pageNum = pageNum + 1;

                iReportDataSouceBeanLst.add(getBikinjikouListYm(bikinCodeBreakkey, kyhSyuruiBreakkey,
                    hokenSyoruiBreakkey, bikinKktiNendoBreakkey, bikinKktiNengetuBreakkey,
                    bikinKktiNengetuSyuukeiNaibuBean, pageNum));

                pageNum = pageNum + 1;

                iReportDataSouceBeanLst.add(getBikinjikouListY(bikinCodeBreakkey, kyhSyuruiBreakkey,
                    hokenSyoruiBreakkey, bikinKktiNendoBreakkey, bikinKktiNendoSyuukeiNaibuBean, pageNum));

                pageNum = pageNum + 1;

                iReportDataSouceBeanLst.add(getBikinjikouListHoｋenSyurui(bikinCodeBreakkey, kyhSyuruiBreakkey,
                    hokenSyoruiBreakkey, hokenSyoruiSyuukeiNaibuBean, pageNum));

                pageNum = pageNum + 1;

                if (!C_BkncdKbn.MENSEKI.getValue().equals(bikinCodeBreakkey)
                    && !C_BkncdKbn.SIBOUKAIJYO.getValue().equals(bikinCodeBreakkey)) {

                    iReportDataSouceBeanLst.add(getBikinjikouListKyhSyurui(bikinCodeBreakkey,
                        kyhSyuruiBreakkey, kyhSyuruiSyuukeiNaibuBean, pageNum));

                    pageNum = pageNum + 1;
                }

                iReportDataSouceBeanLst.add(getBikinjikouListBikinCode(bikinCodeBreakkey,
                    bikinCodeSyuukeiNaibuBean, pageNum));

                pageNum = pageNum + 1;


            }

            String hozonKknTani = ViewReport.getHozonKknTani(C_SyoruiCdKbn.HK_BIKINJIKOUKIST);

            SiBikinjikouListBean siBikinjikouListBean = SWAKInjector.getInstance(SiBikinjikouListBean.class);

            siBikinjikouListBean.setIrAtesaki(tuhuyuAtsk);
            siBikinjikouListBean.setIrKessannnd(ksnNendo);
            siBikinjikouListBean.setIrBknkessankbn(bknkessankbn);
            siBikinjikouListBean.setIrTyouhyousakuseiymd(DateFormatUtil.dateKANJISeirekiNoZero(syoriYmd));
            siBikinjikouListBean.setIrHozonkkn(hozonKknTani);

            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                TeisuuSiharai.SUBSYSTEMID_SIHARAI,
                kinou.getCategoryId(),
                kinou.getKinouId(),
                C_SyoruiCdKbn.HK_BIKINJIKOUKIST);

            reportServicesBean.setSyoriYmd(syoriYmd);

            reportServicesBean.addParamObjects(C_SyoruiCdKbn.HK_BIKINJIKOUKIST, iReportDataSouceBeanLst,
                siBikinjikouListBean);

            createReport.execNoCommit(reportServicesBean);

            BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

            C_ErrorKbn errorKbn = bzFileUploadUtil.exec(
                C_FileSyuruiCdKbn.SI_BIKINJIKOULSTCSVFHKN,
                siBikinjikouListLayoutFileLst,
                true);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syuturyokuKensuu),
            kinou.getKinouNm()));
    }

    private SiBikinjikouListDataSourceBean getBikinjikouListYm(
        String pBikinCode,
        String pKyhSyurui,
        String pHokenSyorui,
        String pBikinKktiNendo,
        String pBikinKktiNengetu,
        BikinJikouListSyuukeiNaibuBean pBikinJikouListSyuukeiNaibuBean,
        Integer pPageno) {
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBeanYm = SWAKInjector.
            getInstance(SiBikinjikouListDataSourceBean.class);

        siBikinjikouListDataSourceBeanYm.setIrHknsyurui("");
        siBikinjikouListDataSourceBeanYm.setIrBkncd("");
        siBikinjikouListDataSourceBeanYm.setIrSiharaiumu("");
        siBikinjikouListDataSourceBeanYm.setIrBknkktiymd("");
        siBikinjikouListDataSourceBeanYm.setIrCalckijyunymd("");
        siBikinjikouListDataSourceBeanYm.setIrSisyacd("");
        siBikinjikouListDataSourceBeanYm.setIrKigou("");
        siBikinjikouListDataSourceBeanYm.setIrSyono("");
        siBikinjikouListDataSourceBeanYm.setIrBkngk(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBeanYm.setIrSyoruiukeymd(null);
        siBikinjikouListDataSourceBeanYm.setIrYenukthyoji("");
        siBikinjikouListDataSourceBeanYm.setIrKnsnkijyunymd(null);
        siBikinjikouListDataSourceBeanYm.setIrYenkansantkykwsrate(null);
        siBikinjikouListDataSourceBeanYm.setIrSiteituukahokenkngk("");
        siBikinjikouListDataSourceBeanYm.setIrYenkasaiteihsygk("");
        siBikinjikouListDataSourceBeanYm.setIrKihons(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBeanYm.setIrTks(null);
        siBikinjikouListDataSourceBeanYm.setIrTkkigou("");
        siBikinjikouListDataSourceBeanYm.setIrKata("");
        siBikinjikouListDataSourceBeanYm.setIrSaisiumu("");
        siBikinjikouListDataSourceBeanYm.setIrSinsaumu("");
        siBikinjikouListDataSourceBeanYm.setIrSoukiumu("");
        siBikinjikouListDataSourceBeanYm.setIrSakugenumu("");
        siBikinjikouListDataSourceBeanYm.setIrTenkanumu("");
        siBikinjikouListDataSourceBeanYm.setIrSyuukeiinfo1(pBikinCode);
        siBikinjikouListDataSourceBeanYm.setIrSyuukeiinfo2(C_HokenkinsyuruiKbn.valueOf(pKyhSyurui).getContent(
            C_HokenkinsyuruiKbn.PATTERN_KYHSYURUI));
        siBikinjikouListDataSourceBeanYm.setIrSyuukeiinfo3(C_Segcd.valueOf(pHokenSyorui).getContent());
        siBikinjikouListDataSourceBeanYm.setIrSyuukeiinfo4(ConvertUtil.
            toZenNumeric(DateFormatUtil.dateYKANJISeireki(pBikinKktiNendo).concat("度")));
        siBikinjikouListDataSourceBeanYm.setIrSyuukeiinfo5(ConvertUtil.
            toZenNumeric(DateFormatUtil.dateYmKANJI(pBikinKktiNengetu)));
        siBikinjikouListDataSourceBeanYm.setIrUtiwake1("主契約");
        siBikinjikouListDataSourceBeanYm.setIrKensuu1(BizNumber.valueOf(pBikinJikouListSyuukeiNaibuBean.getKensuu1()));
        siBikinjikouListDataSourceBeanYm.setIrKingaku1(pBikinJikouListSyuukeiNaibuBean.getKingaku1());
        siBikinjikouListDataSourceBeanYm.setIrBikinjikoulistgoukeitani(ConvertUtil.
            toZenNumeric(DateFormatUtil.dateYmKANJI(pBikinKktiNengetu)));
        siBikinjikouListDataSourceBeanYm.setIrBikinjikoulistgoukeicount(BizNumber.
            valueOf(pBikinJikouListSyuukeiNaibuBean.getKensuu1()));
        siBikinjikouListDataSourceBeanYm.setIrKingakugoukei(pBikinJikouListSyuukeiNaibuBean.getKingaku1());
        siBikinjikouListDataSourceBeanYm.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siBikinjikouListDataSourceBeanYm.setIrPageno(pPageno);

        return siBikinjikouListDataSourceBeanYm;
    }

    private SiBikinjikouListDataSourceBean getBikinjikouListY(
        String pBikinCode,
        String pKyhSyurui,
        String pHokenSyorui,
        String pBikinKktiNendo,
        BikinJikouListSyuukeiNaibuBean pBikinJikouListSyuukeiNaibuBean,
        Integer pPageno) {
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBeanNendo = SWAKInjector.
            getInstance(SiBikinjikouListDataSourceBean.class);

        siBikinjikouListDataSourceBeanNendo.setIrHknsyurui("");
        siBikinjikouListDataSourceBeanNendo.setIrBkncd("");
        siBikinjikouListDataSourceBeanNendo.setIrSiharaiumu("");
        siBikinjikouListDataSourceBeanNendo.setIrBknkktiymd("");
        siBikinjikouListDataSourceBeanNendo.setIrCalckijyunymd("");
        siBikinjikouListDataSourceBeanNendo.setIrSisyacd("");
        siBikinjikouListDataSourceBeanNendo.setIrKigou("");
        siBikinjikouListDataSourceBeanNendo.setIrSyono("");
        siBikinjikouListDataSourceBeanNendo.setIrBkngk(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBeanNendo.setIrSyoruiukeymd(null);
        siBikinjikouListDataSourceBeanNendo.setIrYenukthyoji("");
        siBikinjikouListDataSourceBeanNendo.setIrKnsnkijyunymd(null);
        siBikinjikouListDataSourceBeanNendo.setIrYenkansantkykwsrate(null);
        siBikinjikouListDataSourceBeanNendo.setIrSiteituukahokenkngk("");
        siBikinjikouListDataSourceBeanNendo.setIrYenkasaiteihsygk("");
        siBikinjikouListDataSourceBeanNendo.setIrKihons(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBeanNendo.setIrTks(null);
        siBikinjikouListDataSourceBeanNendo.setIrTkkigou("");
        siBikinjikouListDataSourceBeanNendo.setIrKata("");
        siBikinjikouListDataSourceBeanNendo.setIrSaisiumu("");
        siBikinjikouListDataSourceBeanNendo.setIrSinsaumu("");
        siBikinjikouListDataSourceBeanNendo.setIrSoukiumu("");
        siBikinjikouListDataSourceBeanNendo.setIrSakugenumu("");
        siBikinjikouListDataSourceBeanNendo.setIrTenkanumu("");
        siBikinjikouListDataSourceBeanNendo.setIrSyuukeiinfo1(pBikinCode);
        siBikinjikouListDataSourceBeanNendo.setIrSyuukeiinfo2(C_HokenkinsyuruiKbn.valueOf(pKyhSyurui).getContent(
            C_HokenkinsyuruiKbn.PATTERN_KYHSYURUI));
        siBikinjikouListDataSourceBeanNendo.setIrSyuukeiinfo3(C_Segcd.valueOf(pHokenSyorui).getContent());
        siBikinjikouListDataSourceBeanNendo.setIrSyuukeiinfo4(ConvertUtil.
            toZenNumeric(DateFormatUtil.dateYKANJISeireki(pBikinKktiNendo).concat("度")));
        siBikinjikouListDataSourceBeanNendo.setIrSyuukeiinfo5("");
        siBikinjikouListDataSourceBeanNendo.setIrUtiwake1("主契約");
        siBikinjikouListDataSourceBeanNendo.setIrKensuu1(BizNumber.
            valueOf(pBikinJikouListSyuukeiNaibuBean.getKensuu1()));
        siBikinjikouListDataSourceBeanNendo.setIrKingaku1(pBikinJikouListSyuukeiNaibuBean.getKingaku1());
        siBikinjikouListDataSourceBeanNendo.setIrBikinjikoulistgoukeitani(ConvertUtil.
            toZenNumeric(DateFormatUtil.dateYKANJISeireki(pBikinKktiNendo).concat("度")));
        siBikinjikouListDataSourceBeanNendo.setIrBikinjikoulistgoukeicount(BizNumber.
            valueOf(pBikinJikouListSyuukeiNaibuBean.getKensuu1()));
        siBikinjikouListDataSourceBeanNendo.setIrKingakugoukei(pBikinJikouListSyuukeiNaibuBean.getKingaku1());
        siBikinjikouListDataSourceBeanNendo.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siBikinjikouListDataSourceBeanNendo.setIrPageno(pPageno);

        return siBikinjikouListDataSourceBeanNendo;
    }

    private SiBikinjikouListDataSourceBean getBikinjikouListHoｋenSyurui(
        String pBikinCode,
        String pKyhSyurui,
        String pHokenSyorui,
        BikinJikouListSyuukeiNaibuBean pBikinJikouListSyuukeiNaibuBean,
        Integer pPageno) {
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBeanSri = SWAKInjector.
            getInstance(SiBikinjikouListDataSourceBean.class);

        siBikinjikouListDataSourceBeanSri.setIrHknsyurui("");
        siBikinjikouListDataSourceBeanSri.setIrBkncd("");
        siBikinjikouListDataSourceBeanSri.setIrSiharaiumu("");
        siBikinjikouListDataSourceBeanSri.setIrBknkktiymd("");
        siBikinjikouListDataSourceBeanSri.setIrCalckijyunymd("");
        siBikinjikouListDataSourceBeanSri.setIrSisyacd("");
        siBikinjikouListDataSourceBeanSri.setIrKigou("");
        siBikinjikouListDataSourceBeanSri.setIrSyono("");
        siBikinjikouListDataSourceBeanSri.setIrBkngk(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBeanSri.setIrSyoruiukeymd(null);
        siBikinjikouListDataSourceBeanSri.setIrYenukthyoji("");
        siBikinjikouListDataSourceBeanSri.setIrKnsnkijyunymd(null);
        siBikinjikouListDataSourceBeanSri.setIrYenkansantkykwsrate(null);
        siBikinjikouListDataSourceBeanSri.setIrSiteituukahokenkngk("");
        siBikinjikouListDataSourceBeanSri.setIrYenkasaiteihsygk("");
        siBikinjikouListDataSourceBeanSri.setIrKihons(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBeanSri.setIrTks(null);
        siBikinjikouListDataSourceBeanSri.setIrTkkigou("");
        siBikinjikouListDataSourceBeanSri.setIrKata("");
        siBikinjikouListDataSourceBeanSri.setIrSaisiumu("");
        siBikinjikouListDataSourceBeanSri.setIrSinsaumu("");
        siBikinjikouListDataSourceBeanSri.setIrSoukiumu("");
        siBikinjikouListDataSourceBeanSri.setIrSakugenumu("");
        siBikinjikouListDataSourceBeanSri.setIrTenkanumu("");
        siBikinjikouListDataSourceBeanSri.setIrSyuukeiinfo1(pBikinCode);
        siBikinjikouListDataSourceBeanSri.setIrSyuukeiinfo2(C_HokenkinsyuruiKbn.valueOf(pKyhSyurui).getContent(
            C_HokenkinsyuruiKbn.PATTERN_KYHSYURUI));
        siBikinjikouListDataSourceBeanSri.setIrSyuukeiinfo3(C_Segcd.valueOf(pHokenSyorui).getContent());
        siBikinjikouListDataSourceBeanSri.setIrSyuukeiinfo4("");
        siBikinjikouListDataSourceBeanSri.setIrSyuukeiinfo5("");
        siBikinjikouListDataSourceBeanSri.setIrUtiwake1("主契約");
        siBikinjikouListDataSourceBeanSri.setIrKensuu1(BizNumber.
            valueOf(pBikinJikouListSyuukeiNaibuBean.getKensuu1()));
        siBikinjikouListDataSourceBeanSri.setIrKingaku1(pBikinJikouListSyuukeiNaibuBean.getKingaku1());
        siBikinjikouListDataSourceBeanSri.setIrBikinjikoulistgoukeitani(C_Segcd.valueOf(pHokenSyorui).getContent());
        siBikinjikouListDataSourceBeanSri.setIrBikinjikoulistgoukeicount(BizNumber.
            valueOf(pBikinJikouListSyuukeiNaibuBean.getKensuu1()));
        siBikinjikouListDataSourceBeanSri.setIrKingakugoukei(pBikinJikouListSyuukeiNaibuBean.getKingaku1());
        siBikinjikouListDataSourceBeanSri.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siBikinjikouListDataSourceBeanSri.setIrPageno(pPageno);

        return siBikinjikouListDataSourceBeanSri;
    }

    private SiBikinjikouListDataSourceBean getBikinjikouListKyhSyurui(
        String pBikinCode,
        String pKyhSyurui,
        BikinJikouListSyuukeiNaibuBean pBikinJikouListSyuukeiNaibuBean,
        Integer pPageno) {
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBeanSri = SWAKInjector.
            getInstance(SiBikinjikouListDataSourceBean.class);

        siBikinjikouListDataSourceBeanSri.setIrHknsyurui("");
        siBikinjikouListDataSourceBeanSri.setIrBkncd("");
        siBikinjikouListDataSourceBeanSri.setIrSiharaiumu("");
        siBikinjikouListDataSourceBeanSri.setIrBknkktiymd("");
        siBikinjikouListDataSourceBeanSri.setIrCalckijyunymd("");
        siBikinjikouListDataSourceBeanSri.setIrSisyacd("");
        siBikinjikouListDataSourceBeanSri.setIrKigou("");
        siBikinjikouListDataSourceBeanSri.setIrSyono("");
        siBikinjikouListDataSourceBeanSri.setIrBkngk(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBeanSri.setIrSyoruiukeymd(null);
        siBikinjikouListDataSourceBeanSri.setIrYenukthyoji("");
        siBikinjikouListDataSourceBeanSri.setIrKnsnkijyunymd(null);
        siBikinjikouListDataSourceBeanSri.setIrYenkansantkykwsrate(null);
        siBikinjikouListDataSourceBeanSri.setIrSiteituukahokenkngk("");
        siBikinjikouListDataSourceBeanSri.setIrYenkasaiteihsygk("");
        siBikinjikouListDataSourceBeanSri.setIrKihons(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBeanSri.setIrTks(null);
        siBikinjikouListDataSourceBeanSri.setIrTkkigou("");
        siBikinjikouListDataSourceBeanSri.setIrKata("");
        siBikinjikouListDataSourceBeanSri.setIrSaisiumu("");
        siBikinjikouListDataSourceBeanSri.setIrSinsaumu("");
        siBikinjikouListDataSourceBeanSri.setIrSoukiumu("");
        siBikinjikouListDataSourceBeanSri.setIrSakugenumu("");
        siBikinjikouListDataSourceBeanSri.setIrTenkanumu("");
        siBikinjikouListDataSourceBeanSri.setIrSyuukeiinfo1(pBikinCode);
        siBikinjikouListDataSourceBeanSri.setIrSyuukeiinfo2(C_HokenkinsyuruiKbn.valueOf(pKyhSyurui).getContent(
            C_HokenkinsyuruiKbn.PATTERN_KYHSYURUI));
        siBikinjikouListDataSourceBeanSri.setIrSyuukeiinfo3("");
        siBikinjikouListDataSourceBeanSri.setIrSyuukeiinfo4("");
        siBikinjikouListDataSourceBeanSri.setIrSyuukeiinfo5("");
        siBikinjikouListDataSourceBeanSri.setIrUtiwake1("主契約");
        siBikinjikouListDataSourceBeanSri.setIrKensuu1(BizNumber.
            valueOf(pBikinJikouListSyuukeiNaibuBean.getKensuu1()));
        siBikinjikouListDataSourceBeanSri.setIrKingaku1(pBikinJikouListSyuukeiNaibuBean.getKingaku1());
        siBikinjikouListDataSourceBeanSri.setIrBikinjikoulistgoukeitani(C_HokenkinsyuruiKbn.valueOf(pKyhSyurui).getContent(
            C_HokenkinsyuruiKbn.PATTERN_KYHSYURUI));
        siBikinjikouListDataSourceBeanSri.setIrBikinjikoulistgoukeicount(BizNumber.
            valueOf(pBikinJikouListSyuukeiNaibuBean.getKensuu1()));
        siBikinjikouListDataSourceBeanSri.setIrKingakugoukei(pBikinJikouListSyuukeiNaibuBean.getKingaku1());
        siBikinjikouListDataSourceBeanSri.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siBikinjikouListDataSourceBeanSri.setIrPageno(pPageno);

        return siBikinjikouListDataSourceBeanSri;
    }

    private SiBikinjikouListDataSourceBean getBikinjikouListBikinCode(
        String pBikinCode,
        BikinJikouListSyuukeiNaibuBean pBikinJikouListSyuukeiNaibuBean,
        Integer pPageno) {
        SiBikinjikouListDataSourceBean siBikinjikouListDataSourceBeanCode = SWAKInjector.
            getInstance(SiBikinjikouListDataSourceBean.class);

        siBikinjikouListDataSourceBeanCode.setIrHknsyurui("");
        siBikinjikouListDataSourceBeanCode.setIrBkncd("");
        siBikinjikouListDataSourceBeanCode.setIrSiharaiumu("");
        siBikinjikouListDataSourceBeanCode.setIrBknkktiymd("");
        siBikinjikouListDataSourceBeanCode.setIrCalckijyunymd("");
        siBikinjikouListDataSourceBeanCode.setIrSisyacd("");
        siBikinjikouListDataSourceBeanCode.setIrKigou("");
        siBikinjikouListDataSourceBeanCode.setIrSyono("");
        siBikinjikouListDataSourceBeanCode.setIrBkngk(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBeanCode.setIrSyoruiukeymd(null);
        siBikinjikouListDataSourceBeanCode.setIrYenukthyoji("");
        siBikinjikouListDataSourceBeanCode.setIrKnsnkijyunymd(null);
        siBikinjikouListDataSourceBeanCode.setIrYenkansantkykwsrate(null);
        siBikinjikouListDataSourceBeanCode.setIrSiteituukahokenkngk("");
        siBikinjikouListDataSourceBeanCode.setIrYenkasaiteihsygk("");
        siBikinjikouListDataSourceBeanCode.setIrKihons(BizCurrency.valueOf(0));
        siBikinjikouListDataSourceBeanCode.setIrTks(null);
        siBikinjikouListDataSourceBeanCode.setIrTkkigou("");
        siBikinjikouListDataSourceBeanCode.setIrKata("");
        siBikinjikouListDataSourceBeanCode.setIrSaisiumu("");
        siBikinjikouListDataSourceBeanCode.setIrSinsaumu("");
        siBikinjikouListDataSourceBeanCode.setIrSoukiumu("");
        siBikinjikouListDataSourceBeanCode.setIrSakugenumu("");
        siBikinjikouListDataSourceBeanCode.setIrTenkanumu("");
        siBikinjikouListDataSourceBeanCode.setIrSyuukeiinfo1(pBikinCode);
        siBikinjikouListDataSourceBeanCode.setIrSyuukeiinfo2("");
        siBikinjikouListDataSourceBeanCode.setIrSyuukeiinfo3("");
        siBikinjikouListDataSourceBeanCode.setIrSyuukeiinfo4("");
        siBikinjikouListDataSourceBeanCode.setIrSyuukeiinfo5("");
        siBikinjikouListDataSourceBeanCode.setIrUtiwake1("主契約");
        siBikinjikouListDataSourceBeanCode.setIrKensuu1(BizNumber.
            valueOf(pBikinJikouListSyuukeiNaibuBean.getKensuu1()));
        siBikinjikouListDataSourceBeanCode.setIrKingaku1(pBikinJikouListSyuukeiNaibuBean.getKingaku1());
        siBikinjikouListDataSourceBeanCode.setIrBikinjikoulistgoukeitani(pBikinCode);
        siBikinjikouListDataSourceBeanCode.setIrBikinjikoulistgoukeicount(BizNumber.
            valueOf(pBikinJikouListSyuukeiNaibuBean.getKensuu1()));
        siBikinjikouListDataSourceBeanCode.setIrKingakugoukei(pBikinJikouListSyuukeiNaibuBean.getKingaku1());
        siBikinjikouListDataSourceBeanCode.setIrGoukeiumukbn(C_UmuKbn.ARI);
        siBikinjikouListDataSourceBeanCode.setIrPageno(pPageno);

        return siBikinjikouListDataSourceBeanCode;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();

    }
}
