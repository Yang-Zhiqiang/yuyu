package yuyu.batch.siharai.sikessan.simakebikinsagyou;

import java.util.ArrayList;
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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_Bknkessankbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.siharai.bean.report.SiBikinsagyouListBean;
import yuyu.def.siharai.bean.report.SiBikinsagyouListDataSourceBean;
import yuyu.def.siharai.configuration.YuyuSiharaiConfig;
import yuyu.def.siharai.file.csv.SiBikinsagyouListLayoutFile;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 保険金給付金支払 決算 保険金給付金備金作業リスト作成
 */
public class SiMakeBikinSagyouBatch implements Batch {

    private final String TYSYTTAISYOUTABLEID = "JT_SiBikinkanri";

    private final String RECOVERYFILTERIDKBNID = "Si001";

    private final String SYUKEIYAKU = "主契約";

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

        String kakutyouJobcd = batchParam.getIbKakutyoujobcd();

        List<SiBikinsagyouListLayoutFile> siBikinSagyouListLayoutFileLst = new ArrayList<SiBikinsagyouListLayoutFile>();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        String thyouAtesaki =
            ViewReport.editOntyuu(YuyuSiharaiConfig.getInstance().getTantousitu() + "－" + ConvertUtil.toZenAlphabet(C_TantouCdKbn.SIBOUTETUZUKI.getValue(), 0));

        if (syoriYmd.getDay() <= 15) {

            kessanKijyunYmd = syoriYmd.getPreviousMonth().getBizDateYM().getLastDay();
        }

        else {

            kessanKijyunYmd = syoriYmd.getBizDateYM().getLastDay();
        }

        String kessanNendo = DateFormatUtil.dateYKANJISeirekiNendo(kessanKijyunYmd);

        C_Bknkessankbn bknKessanKbn = C_Bknkessankbn.BLNK;

        if (kessanKijyunYmd.getMonth() == 3) {

            bknKessanKbn = C_Bknkessankbn.KESSAN;
        }

        else if (kessanKijyunYmd.getMonth() == 6) {

            bknKessanKbn = C_Bknkessankbn.SHNK;

        }

        else if (kessanKijyunYmd.getMonth() == 9) {

            bknKessanKbn = C_Bknkessankbn.HNK;

        }

        else if (kessanKijyunYmd.getMonth() == 12) {

            bknKessanKbn = C_Bknkessankbn.SHNK;
        }

        String csvKessanNendo = kessanNendo + bknKessanKbn.getContent();

        long totalCnt = 0;

        try (ExDBResults<JT_SiBikinkanri> siBikinkanriExDBResults =
            siharaiDomManager.getSiBikinkanrisByKakutyoujobcdItems(kakutyouJobcd, kessanKijyunYmd, C_BknrigiKbn.DEL)) {

            Iterator<JT_SiBikinkanri> siBikinkanriIter = siBikinkanriExDBResults.iterator();

            List<IReportDataSouceBean> siBikinSagyouDsBeanLst = Lists.newArrayList();

            if (siBikinkanriIter.hasNext()) {

                Integer pageNo = 1;

                Integer pageLine = 0;

                SiBikinsagyouListNayibuBean bknkktiymSyuukeiBean = new SiBikinsagyouListNayibuBean();

                SiBikinsagyouListNayibuBean bknkktinndSyuukeiBean = new SiBikinsagyouListNayibuBean();

                SiBikinsagyouListNayibuBean hknsyuSyuukeiBean = new SiBikinsagyouListNayibuBean();

                SiBikinsagyouListNayibuBean bkncdSyuukeiBean = new SiBikinsagyouListNayibuBean();

                String bknkktiymBreak = null;

                String bknkktinndBreak = null;

                String hknsyuBreak = null;

                String bkncdBreak = null;

                int i = 0;

                while (siBikinkanriIter.hasNext()) {


                    JT_SiBikinkanri siBikinkanri = siBikinkanriIter.next();

                    bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobcd);

                    bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);

                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERIDKBNID);

                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(siBikinkanri.getSyono());

                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(siBikinkanri.getSkno());

                    if (totalCnt == 0) {

                        bknkktiymBreak = siBikinkanri.getBknkktiym().toString();

                        bknkktinndBreak = siBikinkanri.getBknkktinnd();

                        hknsyuBreak = siBikinkanri.getKbnkeirisegcd().getValue();

                        bkncdBreak = siBikinkanri.getSyuukeiyoubkncdkbn().getValue();
                    }
                    else {

                        if (!siBikinkanri.getSyuukeiyoubkncdkbn().getValue().equals(bkncdBreak)) {

                            ((SiBikinsagyouListDataSourceBean)siBikinSagyouDsBeanLst.get(i-1)).setIrGoukeitani(
                                DateFormatUtil.dateYmKANJI(bknkktiymBreak));

                            ((SiBikinsagyouListDataSourceBean)siBikinSagyouDsBeanLst.get(i-1)).setIrGoukeikbn1(SYUKEIYAKU);

                            ((SiBikinsagyouListDataSourceBean)siBikinSagyouDsBeanLst.get(i-1)).setIrGoukeikensuu1(
                                bknkktiymSyuukeiBean.getKensuu1());

                            ((SiBikinsagyouListDataSourceBean)siBikinSagyouDsBeanLst.get(i-1)).setIrGoukeibikingk1(
                                bknkktiymSyuukeiBean.getKingaku1());

                            pageNo = pageNo + 1;


                            siBikinSagyouDsBeanLst.add(getBikinSagyouLstNdSyukei(bknkktinndBreak, bknkktinndSyuukeiBean, pageNo));

                            pageNo = pageNo + 1;

                            i++ ;

                            siBikinSagyouDsBeanLst.add(getBikinSagyouLstHknSyuruiSyukei(
                                C_Segcd.valueOf(hknsyuBreak), hknsyuSyuukeiBean, pageNo));

                            pageNo = pageNo + 1;

                            i++ ;

                            siBikinSagyouDsBeanLst.add(getBikinSagyouLstBknCdSyukei(bkncdBreak, bkncdSyuukeiBean, pageNo));

                            pageNo = pageNo + 1;

                            i++ ;

                            bknkktiymBreak = siBikinkanri.getBknkktiym().toString();

                            bknkktinndBreak = siBikinkanri.getBknkktinnd();

                            hknsyuBreak = siBikinkanri.getKbnkeirisegcd().getValue();

                            bkncdBreak = siBikinkanri.getSyuukeiyoubkncdkbn().getValue();

                            pageLine = 0;

                            bknkktiymSyuukeiBean = SWAKInjector.getInstance(SiBikinsagyouListNayibuBean.class);

                            bknkktinndSyuukeiBean = SWAKInjector.getInstance(SiBikinsagyouListNayibuBean.class);

                            hknsyuSyuukeiBean = SWAKInjector.getInstance(SiBikinsagyouListNayibuBean.class);

                            bkncdSyuukeiBean = SWAKInjector.getInstance(SiBikinsagyouListNayibuBean.class);
                        }
                        else if (!siBikinkanri.getKbnkeirisegcd().getValue().equals(hknsyuBreak)) {

                            ((SiBikinsagyouListDataSourceBean)siBikinSagyouDsBeanLst.get(i-1)).setIrGoukeitani(
                                DateFormatUtil.dateYmKANJI(bknkktiymBreak));

                            ((SiBikinsagyouListDataSourceBean)siBikinSagyouDsBeanLst.get(i-1)).setIrGoukeikbn1(SYUKEIYAKU);

                            ((SiBikinsagyouListDataSourceBean)siBikinSagyouDsBeanLst.get(i-1)).setIrGoukeikensuu1(
                                bknkktiymSyuukeiBean.getKensuu1());

                            ((SiBikinsagyouListDataSourceBean)siBikinSagyouDsBeanLst.get(i-1)).setIrGoukeibikingk1(
                                bknkktiymSyuukeiBean.getKingaku1());

                            pageNo = pageNo + 1;


                            siBikinSagyouDsBeanLst.add(getBikinSagyouLstNdSyukei(bknkktinndBreak, bknkktinndSyuukeiBean, pageNo));

                            pageNo = pageNo + 1;

                            i++ ;

                            siBikinSagyouDsBeanLst.add(getBikinSagyouLstHknSyuruiSyukei(
                                C_Segcd.valueOf(hknsyuBreak), hknsyuSyuukeiBean, pageNo));

                            pageNo = pageNo + 1;

                            i++ ;

                            bknkktiymBreak = siBikinkanri.getBknkktiym().toString();

                            bknkktinndBreak = siBikinkanri.getBknkktinnd();

                            hknsyuBreak = siBikinkanri.getKbnkeirisegcd().getValue();

                            pageLine = 0;

                            bknkktiymSyuukeiBean = SWAKInjector.getInstance(SiBikinsagyouListNayibuBean.class);

                            bknkktinndSyuukeiBean = SWAKInjector.getInstance(SiBikinsagyouListNayibuBean.class);

                            hknsyuSyuukeiBean = SWAKInjector.getInstance(SiBikinsagyouListNayibuBean.class);

                        }
                        else if (!siBikinkanri.getBknkktinnd().equals(bknkktinndBreak)) {

                            ((SiBikinsagyouListDataSourceBean)siBikinSagyouDsBeanLst.get(i-1)).setIrGoukeitani(
                                DateFormatUtil.dateYmKANJI(bknkktiymBreak));

                            ((SiBikinsagyouListDataSourceBean)siBikinSagyouDsBeanLst.get(i-1)).setIrGoukeikbn1(SYUKEIYAKU);

                            ((SiBikinsagyouListDataSourceBean)siBikinSagyouDsBeanLst.get(i-1)).setIrGoukeikensuu1(
                                bknkktiymSyuukeiBean.getKensuu1());

                            ((SiBikinsagyouListDataSourceBean)siBikinSagyouDsBeanLst.get(i-1)).setIrGoukeibikingk1(
                                bknkktiymSyuukeiBean.getKingaku1());

                            pageNo = pageNo + 1;

                            siBikinSagyouDsBeanLst.add(getBikinSagyouLstNdSyukei(bknkktinndBreak, bknkktinndSyuukeiBean, pageNo));

                            pageNo = pageNo + 1;

                            i++ ;

                            bknkktiymBreak = siBikinkanri.getBknkktiym().toString();

                            bknkktinndBreak = siBikinkanri.getBknkktinnd();

                            pageLine = 0;

                            bknkktiymSyuukeiBean = SWAKInjector.getInstance(SiBikinsagyouListNayibuBean.class);

                            bknkktinndSyuukeiBean = SWAKInjector.getInstance(SiBikinsagyouListNayibuBean.class);
                        }

                        else if (BizDateUtil.compareYm(siBikinkanri.getBknkktiym(), BizDateYM.valueOf(bknkktiymBreak)) != BizDateUtil.COMPARE_EQUAL) {

                            ((SiBikinsagyouListDataSourceBean)siBikinSagyouDsBeanLst.get(i-1)).setIrGoukeitani(
                                DateFormatUtil.dateYmKANJI(bknkktiymBreak));

                            ((SiBikinsagyouListDataSourceBean)siBikinSagyouDsBeanLst.get(i-1)).setIrGoukeikbn1(SYUKEIYAKU);

                            ((SiBikinsagyouListDataSourceBean)siBikinSagyouDsBeanLst.get(i-1)).setIrGoukeikensuu1(
                                bknkktiymSyuukeiBean.getKensuu1());

                            ((SiBikinsagyouListDataSourceBean)siBikinSagyouDsBeanLst.get(i-1)).setIrGoukeibikingk1(
                                bknkktiymSyuukeiBean.getKingaku1());

                            pageNo = pageNo + 1;

                            bknkktiymBreak = siBikinkanri.getBknkktiym().toString();

                            pageLine = 0;

                            bknkktiymSyuukeiBean = SWAKInjector.getInstance(SiBikinsagyouListNayibuBean.class);
                        }

                        else {

                            if (pageLine == 19) {

                                pageNo = pageNo + 1;

                                pageLine = 0;

                            }
                        }
                    }

                    totalCnt = totalCnt + 1;

                    pageLine = pageLine + 1;

                    bknkktiymSyuukeiBean.setKensuu1(bknkktiymSyuukeiBean.getKensuu1().add(BizNumber.ONE));

                    bknkktiymSyuukeiBean.setKingaku1(bknkktiymSyuukeiBean.getKingaku1().add(siBikinkanri.getBkngk()));

                    bknkktinndSyuukeiBean.setKensuu1(bknkktinndSyuukeiBean.getKensuu1().add(BizNumber.ONE));

                    bknkktinndSyuukeiBean.setKingaku1(bknkktinndSyuukeiBean.getKingaku1().add(siBikinkanri.getBkngk()));

                    hknsyuSyuukeiBean.setKensuu1(hknsyuSyuukeiBean.getKensuu1().add(BizNumber.ONE));

                    hknsyuSyuukeiBean.setKingaku1(hknsyuSyuukeiBean.getKingaku1().add(siBikinkanri.getBkngk()));

                    bkncdSyuukeiBean.setKensuu1(bkncdSyuukeiBean.getKensuu1().add(BizNumber.ONE));

                    bkncdSyuukeiBean.setKingaku1(bkncdSyuukeiBean.getKingaku1().add(siBikinkanri.getBkngk()));

                    String hknsyuRyaku = siBikinkanri.getKbnkeirisegcd().getContent(C_Segcd.PATTERN_RYAKUSYOU);

                    String soukiHyouji = "";

                    if (C_UmuKbn.ARI.eq(siBikinkanri.getSoukiumukbn())) {

                        soukiHyouji = "*";
                    }

                    else {

                        soukiHyouji = "";
                    }

                    String syoumetuUmuKbn = "";

                    if (C_UmuKbn.ARI.eq(siBikinkanri.getSyoumetuumukbn())) {

                        syoumetuUmuKbn = "*";
                    }

                    else {

                        syoumetuUmuKbn = "";
                    }

                    SiBikinsagyouListDataSourceBean siBikinsagyouListDsBean = SWAKInjector.getInstance(
                        SiBikinsagyouListDataSourceBean.class);

                    siBikinsagyouListDsBean.setIrBkncd(siBikinkanri.getBkncdkbn().getValue());

                    siBikinsagyouListDsBean.setIrHknsyuruinmryaku(hknsyuRyaku);

                    siBikinsagyouListDsBean.setIrBknkktiymd(
                        DateFormatUtil.dateKANJISeirekiNoZero(siBikinkanri.getBknkktymd()));

                    siBikinsagyouListDsBean.setIrCalckijyunymd(
                        DateFormatUtil.dateKANJISeirekiNoZero(siBikinkanri.getCalckijyunymd()));

                    siBikinsagyouListDsBean.setIrSisyacd(siBikinkanri.getSisyacd());

                    siBikinsagyouListDsBean.setIrKigou(siBikinkanri.getSyouhncd().substring(0, 2));

                    siBikinsagyouListDsBean.setIrSyono(siBikinkanri.getSyono());

                    siBikinsagyouListDsBean.setIrBkngk(siBikinkanri.getBkngk());

                    siBikinsagyouListDsBean.setIrKihons(siBikinkanri.getKihons());

                    siBikinsagyouListDsBean.setIrTks(null);

                    siBikinsagyouListDsBean.setIrTkkigou("");

                    siBikinsagyouListDsBean.setIrKatazenkaku("");

                    siBikinsagyouListDsBean.setIrSaisi("");

                    siBikinsagyouListDsBean.setIrDoujibkn("");

                    siBikinsagyouListDsBean.setIrSokyuuumu("");

                    siBikinsagyouListDsBean.setIrSoukiumu(soukiHyouji);

                    siBikinsagyouListDsBean.setIrBknsgulisterrormsg("");

                    siBikinsagyouListDsBean.setIrSakugenumu("");

                    siBikinsagyouListDsBean.setIrNkumu("");

                    siBikinsagyouListDsBean.setIrTenkanumu("");

                    siBikinsagyouListDsBean.setIrKeimaeumu("");

                    siBikinsagyouListDsBean.setIrSaihoumu("");

                    siBikinsagyouListDsBean.setIrSzouumu("");

                    siBikinsagyouListDsBean.setIrGoukeitani("");

                    siBikinsagyouListDsBean.setIrGoukeikbn1("");

                    siBikinsagyouListDsBean.setIrGoukeikensuu1(null);

                    siBikinsagyouListDsBean.setIrGoukeibikingk1(null);

                    siBikinsagyouListDsBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

                    siBikinsagyouListDsBean.setIrPageno(pageNo);

                    siBikinSagyouDsBeanLst.add(siBikinsagyouListDsBean);

                    SiBikinsagyouListLayoutFile siBikinsagyouListLayoutFile = SWAKInjector.getInstance(
                        SiBikinsagyouListLayoutFile.class);

                    siBikinsagyouListLayoutFile.setIfcListnm("備金作業リスト");

                    siBikinsagyouListLayoutFile.setIfcAtesaki(YuyuSiharaiConfig.getInstance().getTantousitu());

                    siBikinsagyouListLayoutFile.setIfcSakuseiymdseireki(FixedDateFormatter.formatYMDSeirekiSlashZeroFill(syoriYmd));

                    siBikinsagyouListLayoutFile.setIfcPageno(String.valueOf(pageNo));

                    siBikinsagyouListLayoutFile.setIfcKessannnd(csvKessanNendo);

                    siBikinsagyouListLayoutFile.setIfcBkncd(siBikinkanri.getBkncdkbn().getValue());

                    siBikinsagyouListLayoutFile.setIfcHknsyurui(hknsyuRyaku);

                    siBikinsagyouListLayoutFile.setIfcBknkktiymdseireki(
                        FixedDateFormatter.formatYMDSeirekiSlashZeroFill(siBikinkanri.getBknkktymd()));

                    siBikinsagyouListLayoutFile.setIfcCalckijyunymd(
                        FixedDateFormatter.formatYMDSeirekiSlashZeroFill(siBikinkanri.getCalckijyunymd()));

                    siBikinsagyouListLayoutFile.setIfcSisyacd(siBikinkanri.getSisyacd());

                    siBikinsagyouListLayoutFile.setIfcKigou(siBikinkanri.getSyouhncd().substring(0, 2));

                    siBikinsagyouListLayoutFile.setIfcSyono(siBikinkanri.getSyono());

                    siBikinsagyouListLayoutFile.setIfcBkngk(siBikinkanri.getBkngk().toString());

                    siBikinsagyouListLayoutFile.setIfcKihons(siBikinkanri.getKihons().toString());

                    siBikinsagyouListLayoutFile.setIfcTks("");

                    siBikinsagyouListLayoutFile.setIfcTkkigou("");

                    siBikinsagyouListLayoutFile.setIfcKatakbn("");

                    siBikinsagyouListLayoutFile.setIfcSaisikbn("");

                    siBikinsagyouListLayoutFile.setIfcDoujibkn1("");

                    siBikinsagyouListLayoutFile.setIfcDoujibkn2("");

                    siBikinsagyouListLayoutFile.setIfcDoujibkn3("");

                    siBikinsagyouListLayoutFile.setIfcDoujibkn4("");

                    siBikinsagyouListLayoutFile.setIfcSokyuukbn("");

                    siBikinsagyouListLayoutFile.setIfcSoukihyj(soukiHyouji);

                    siBikinsagyouListLayoutFile.setIfcErrormsg("");

                    siBikinsagyouListLayoutFile.setIfcSkgnhyj("");

                    siBikinsagyouListLayoutFile.setIfcNkhyj("");

                    siBikinsagyouListLayoutFile.setIfcTnknhyj("");

                    siBikinsagyouListLayoutFile.setIfcKykmaehyj("");

                    siBikinsagyouListLayoutFile.setIfcSihknhyj("");

                    siBikinsagyouListLayoutFile.setIfcSzoutysihyj("");

                    siBikinsagyouListLayoutFile.setIfcKihonstuukasyurui(siBikinkanri.getKyktuukasyu().toString());

                    siBikinsagyouListLayoutFile.setIfcSyoumetuumu(syoumetuUmuKbn);

                    siBikinSagyouListLayoutFileLst.add(siBikinsagyouListLayoutFile);

                    i++ ;
                }

                bzRecoveryDatasikibetuBean.initializeBlank();

                ((SiBikinsagyouListDataSourceBean)siBikinSagyouDsBeanLst.get(i-1)).setIrGoukeitani(
                    DateFormatUtil.dateYmKANJI(bknkktiymBreak));

                ((SiBikinsagyouListDataSourceBean)siBikinSagyouDsBeanLst.get(i-1)).setIrGoukeikbn1(SYUKEIYAKU);

                ((SiBikinsagyouListDataSourceBean)siBikinSagyouDsBeanLst.get(i-1)).setIrGoukeikensuu1(
                    bknkktiymSyuukeiBean.getKensuu1());

                ((SiBikinsagyouListDataSourceBean)siBikinSagyouDsBeanLst.get(i-1)).setIrGoukeibikingk1(
                    bknkktiymSyuukeiBean.getKingaku1());

                pageNo = pageNo + 1;

                siBikinSagyouDsBeanLst.add(getBikinSagyouLstNdSyukei(bknkktinndBreak, bknkktinndSyuukeiBean, pageNo));

                pageNo = pageNo + 1;

                siBikinSagyouDsBeanLst.add(getBikinSagyouLstHknSyuruiSyukei
                    (C_Segcd.valueOf(hknsyuBreak), hknsyuSyuukeiBean, pageNo));

                pageNo = pageNo + 1;

                siBikinSagyouDsBeanLst.add(getBikinSagyouLstBknCdSyukei(bkncdBreak, bkncdSyuukeiBean, pageNo));

                pageNo = pageNo + 1;

            }

            String hozonKikanInfo = ViewReport.getHozonKknTani(C_SyoruiCdKbn.HK_BIKINSAGYOULIST);

            SiBikinsagyouListBean siBikinsagyouListBean = SWAKInjector.getInstance(
                SiBikinsagyouListBean.class);

            siBikinsagyouListBean.setIrAtesaki(thyouAtesaki);

            siBikinsagyouListBean.setIrKessannnd(kessanNendo);

            siBikinsagyouListBean.setIrBknkessankbn(bknKessanKbn);

            siBikinsagyouListBean.setIrTyouhyousakuseiymd(DateFormatUtil.dateKANJISeirekiNoZero(syoriYmd));

            siBikinsagyouListBean.setIrHozonkkn(hozonKikanInfo);

            ReportServicesBean reportServicesBean =
                createReport.createNewReportServiceBean(
                    TeisuuSiharai.SUBSYSTEMID_SIHARAI,
                    kinou.getCategoryId(),
                    kinou.getKinouId(),
                    C_SyoruiCdKbn.HK_BIKINSAGYOULIST);

            reportServicesBean.setSyoriYmd(syoriYmd);

            reportServicesBean.addParamObjects(C_SyoruiCdKbn.HK_BIKINSAGYOULIST, siBikinSagyouDsBeanLst, siBikinsagyouListBean);

            createReport.execNoCommit(reportServicesBean);

            BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

            C_ErrorKbn result =
                bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SI_BIKINSGYLSTCSVFHKN, siBikinSagyouListLayoutFileLst, true);

            if (C_ErrorKbn.ERROR.eq(result)) {
                throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(totalCnt), kinou.getKinouNm()));
    }

    private SiBikinsagyouListDataSourceBean getBikinSagyouLstNdSyukei (
        String pBknKktinNd, SiBikinsagyouListNayibuBean pBiKinSagyouLstSyuukeiBean, Integer pPageNo) {

        SiBikinsagyouListDataSourceBean bikinSagyouListDSBean = SWAKInjector
            .getInstance(SiBikinsagyouListDataSourceBean.class);

        bikinSagyouListDSBean.setIrBkncd("");

        bikinSagyouListDSBean.setIrHknsyuruinmryaku("");

        bikinSagyouListDSBean.setIrBknkktiymd("");

        bikinSagyouListDSBean.setIrCalckijyunymd("");

        bikinSagyouListDSBean.setIrSisyacd("");

        bikinSagyouListDSBean.setIrKigou("");

        bikinSagyouListDSBean.setIrSyono("");

        bikinSagyouListDSBean.setIrBkngk(null);

        bikinSagyouListDSBean.setIrKihons(null);

        bikinSagyouListDSBean.setIrTks(null);

        bikinSagyouListDSBean.setIrTkkigou("");

        bikinSagyouListDSBean.setIrKatazenkaku("");

        bikinSagyouListDSBean.setIrSaisi("");

        bikinSagyouListDSBean.setIrDoujibkn("");

        bikinSagyouListDSBean.setIrSokyuuumu("");

        bikinSagyouListDSBean.setIrSoukiumu("");

        bikinSagyouListDSBean.setIrBknsgulisterrormsg("");

        bikinSagyouListDSBean.setIrSakugenumu("");

        bikinSagyouListDSBean.setIrNkumu("");

        bikinSagyouListDSBean.setIrTenkanumu("");

        bikinSagyouListDSBean.setIrKeimaeumu("");

        bikinSagyouListDSBean.setIrSaihoumu("");

        bikinSagyouListDSBean.setIrSzouumu("");

        bikinSagyouListDSBean.setIrGoukeitani(DateFormatUtil.dateYKANJISeireki(pBknKktinNd).concat("度"));

        bikinSagyouListDSBean.setIrGoukeikbn1(SYUKEIYAKU);

        bikinSagyouListDSBean.setIrGoukeikensuu1(pBiKinSagyouLstSyuukeiBean.getKensuu1());

        bikinSagyouListDSBean.setIrGoukeibikingk1(pBiKinSagyouLstSyuukeiBean.getKingaku1());

        bikinSagyouListDSBean.setIrGoukeiumukbn(C_UmuKbn.ARI);

        bikinSagyouListDSBean.setIrPageno(pPageNo);

        return bikinSagyouListDSBean;
    }

    private SiBikinsagyouListDataSourceBean getBikinSagyouLstHknSyuruiSyukei(
        C_Segcd pSegcd, SiBikinsagyouListNayibuBean pBiKinSagyouLstSyuukeiBean, Integer pPageNo) {

        SiBikinsagyouListDataSourceBean bikinsagyouListDsBean = SWAKInjector
            .getInstance(SiBikinsagyouListDataSourceBean.class);

        bikinsagyouListDsBean.setIrBkncd("");

        bikinsagyouListDsBean.setIrHknsyuruinmryaku("");

        bikinsagyouListDsBean.setIrBknkktiymd("");

        bikinsagyouListDsBean.setIrCalckijyunymd("");

        bikinsagyouListDsBean.setIrSisyacd("");

        bikinsagyouListDsBean.setIrKigou("");

        bikinsagyouListDsBean.setIrSyono("");

        bikinsagyouListDsBean.setIrBkngk(null);

        bikinsagyouListDsBean.setIrKihons(null);

        bikinsagyouListDsBean.setIrTks(null);

        bikinsagyouListDsBean.setIrTkkigou("");

        bikinsagyouListDsBean.setIrKatazenkaku("");

        bikinsagyouListDsBean.setIrSaisi("");

        bikinsagyouListDsBean.setIrDoujibkn("");

        bikinsagyouListDsBean.setIrSokyuuumu("");

        bikinsagyouListDsBean.setIrSoukiumu("");

        bikinsagyouListDsBean.setIrBknsgulisterrormsg("");

        bikinsagyouListDsBean.setIrSakugenumu("");

        bikinsagyouListDsBean.setIrNkumu("");

        bikinsagyouListDsBean.setIrTenkanumu("");

        bikinsagyouListDsBean.setIrKeimaeumu("");

        bikinsagyouListDsBean.setIrSaihoumu("");

        bikinsagyouListDsBean.setIrSzouumu("");

        bikinsagyouListDsBean.setIrGoukeitani(pSegcd.getContent());

        bikinsagyouListDsBean.setIrGoukeikbn1(SYUKEIYAKU);

        bikinsagyouListDsBean.setIrGoukeikensuu1(pBiKinSagyouLstSyuukeiBean.getKensuu1());

        bikinsagyouListDsBean.setIrGoukeibikingk1(pBiKinSagyouLstSyuukeiBean.getKingaku1());

        bikinsagyouListDsBean.setIrGoukeiumukbn(C_UmuKbn.ARI);

        bikinsagyouListDsBean.setIrPageno(pPageNo);

        return bikinsagyouListDsBean;
    }

    private SiBikinsagyouListDataSourceBean getBikinSagyouLstBknCdSyukei(
        String pBkncd, SiBikinsagyouListNayibuBean pBiKinSagyouLstSyuukeiBean, Integer pPageNo) {

        SiBikinsagyouListDataSourceBean bikinSagyouListDsBean = SWAKInjector
            .getInstance(SiBikinsagyouListDataSourceBean.class);

        bikinSagyouListDsBean.setIrBkncd("");

        bikinSagyouListDsBean.setIrHknsyuruinmryaku("");

        bikinSagyouListDsBean.setIrBknkktiymd("");

        bikinSagyouListDsBean.setIrCalckijyunymd("");

        bikinSagyouListDsBean.setIrSisyacd("");

        bikinSagyouListDsBean.setIrKigou("");

        bikinSagyouListDsBean.setIrSyono("");

        bikinSagyouListDsBean.setIrBkngk(null);

        bikinSagyouListDsBean.setIrKihons(null);

        bikinSagyouListDsBean.setIrTks(null);

        bikinSagyouListDsBean.setIrTkkigou("");

        bikinSagyouListDsBean.setIrKatazenkaku("");

        bikinSagyouListDsBean.setIrSaisi("");

        bikinSagyouListDsBean.setIrDoujibkn("");

        bikinSagyouListDsBean.setIrSokyuuumu("");

        bikinSagyouListDsBean.setIrSoukiumu("");

        bikinSagyouListDsBean.setIrBknsgulisterrormsg("");

        bikinSagyouListDsBean.setIrSakugenumu("");

        bikinSagyouListDsBean.setIrNkumu("");

        bikinSagyouListDsBean.setIrTenkanumu("");

        bikinSagyouListDsBean.setIrKeimaeumu("");

        bikinSagyouListDsBean.setIrSaihoumu("");

        bikinSagyouListDsBean.setIrSzouumu("");

        bikinSagyouListDsBean.setIrGoukeitani(pBkncd);

        bikinSagyouListDsBean.setIrGoukeikbn1(SYUKEIYAKU);

        bikinSagyouListDsBean.setIrGoukeikensuu1(pBiKinSagyouLstSyuukeiBean.getKensuu1());

        bikinSagyouListDsBean.setIrGoukeibikingk1(pBiKinSagyouLstSyuukeiBean.getKingaku1());

        bikinSagyouListDsBean.setIrGoukeiumukbn(C_UmuKbn.ARI);

        bikinSagyouListDsBean.setIrPageno(pPageNo);

        return bikinSagyouListDsBean;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();

    }
}
