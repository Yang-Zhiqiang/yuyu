package yuyu.batch.hozen.khkessan.khyendthnkbikinlistsks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khkessan.khyendthnkbikinlistsks.dba.KhYendtHnkBikinListSksDao;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.hozen.khcommon.SetKessanNensibi;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_Bknkessankbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.hozen.bean.report.KhYendthnkHrBikinListBean;
import yuyu.def.hozen.bean.report.KhYendthnkHrBikinListDataSourceBean;
import yuyu.def.hozen.file.csv.KhBikinSgyLstCsvfYendthnkHrFile;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 決算 円建変更時返戻金備金リスト作成
 */
public class KhYendtHnkBikinListSksBatch implements Batch {

    private final String TABLE_ID = IT_KhBikinkanri.TABLE_NAME;

    private final String RECOVERY_FILTER_ID = "Bz001";

    private  List<IReportDataSouceBean> khYendthnkHrBikinListDataSourceBeanLst;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhYendtHnkBikinListSksBatchParam khYendtHnkBikinListSksBatchParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private KhYendtHnkBikinListSksDao khYendtHnkBikinListSksDao;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {

        return khYendtHnkBikinListSksBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = khYendtHnkBikinListSksBatchParam.getSyoriYmd();

        BizDate kessanYmd = khYendtHnkBikinListSksBatchParam.getKessanYmd();

        String kakutyoujobCd = khYendtHnkBikinListSksBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, "<<バッチ処理年月日>>", String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, "<<決算日>>", String.valueOf(kessanYmd)));

        try (ExDBResults<IT_KhBikinkanri> khBikinkanriLst = khYendtHnkBikinListSksDao.
            getKhBikinkanrisByKakutyoujobcdKessankijyunymdBkncdkbn(kakutyoujobCd, kessanYmd, C_BkncdKbn.YENDTHNKHR)) {

            CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                kinou.getSubSystemId(),
                kinou.getCategoryId(),
                kinou.getKinouId(),
                C_SyoruiCdKbn.KK_YENDTHNK_BIKINLIST);

            String tyouhyouSakuseiYmd = DateFormatUtil.dateKANJINoEx(syoriYmd);

            String busituCd = bizDomManager.getTantouCd(C_TantouCdKbn.DAIRITENJIMUHOZEN).getBusitucd();

            BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

            BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(busituCd + "0000");

            String tantsituNm = "";

            if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {

                tantsituNm = bzGetSosikiDataBean.getKanjisosikinm20();
            }

            SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);

            BizDate kessanNensibi = setKessanNensibi.exec(kessanYmd);

            String kessanNnd = DateFormatUtil.dateYKANJISeireki(kessanNensibi.getBizDateY()).concat("度");

            C_Bknkessankbn bknkessanKbn = C_Bknkessankbn.BLNK;

            if (kessanYmd.getMonth() == 3) {

                bknkessanKbn = C_Bknkessankbn.KESSAN;

            }
            else if (kessanYmd.getMonth() == 6) {

                bknkessanKbn = C_Bknkessankbn.SHNK;

            }
            else if (kessanYmd.getMonth() == 9) {

                bknkessanKbn = C_Bknkessankbn.HNK;

            }
            else if (kessanYmd.getMonth() == 12) {

                bknkessanKbn = C_Bknkessankbn.SHNK;

            }

            String hozonKkn = ViewReport.getHozonKknTani(C_SyoruiCdKbn.KK_YENDTHNK_BIKINLIST);

            KhYendthnkHrBikinListBean khYendthnkHrBikinListBean = SWAKInjector.
                getInstance(KhYendthnkHrBikinListBean.class);

            khYendthnkHrBikinListBean.setIrTantsitunmkj(tantsituNm);

            khYendthnkHrBikinListBean.setIrKessannnd(kessanNnd);

            khYendthnkHrBikinListBean.setIrBknkessankbn(bknkessanKbn);

            khYendthnkHrBikinListBean.setIrTyouhyousakuseiymdwareki(tyouhyouSakuseiYmd);

            khYendthnkHrBikinListBean.setIrHozonkkn(hozonKkn);


            long khBikinKanriinfoOutKns = 0;

            int pageNo = 1;

            int itiPageCount = 0;

            String bknkktiNnd = null;

            BizDateY bknkktiNndKey = null;

            C_Segcd hknsyuruiKey = null;

            C_BkncdKbn bkncdKey = null;


            KhYendtHnkBikinListSksBean bknkktiNndListSksBean = new KhYendtHnkBikinListSksBean();

            KhYendtHnkBikinListSksBean hknsyuruiListSksBean = new KhYendtHnkBikinListSksBean();

            KhYendtHnkBikinListSksBean bkncdListSksBean = new KhYendtHnkBikinListSksBean();

            khYendthnkHrBikinListDataSourceBeanLst = new ArrayList<>();

            List<KhBikinSgyLstCsvfYendthnkHrFile> khBikinSgyLstCsvfYendthnkHrFileLst =
                new ArrayList<KhBikinSgyLstCsvfYendthnkHrFile>();

            for (IT_KhBikinkanri khBikinkanri : khBikinkanriLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);

                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_ID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khBikinkanri.getSyono());

                String bknkktYmd = DateFormatUtil.dateKANJINoEx(khBikinkanri.getBknkktymd());

                BizDateY kessanNensiY = setKessanNensibi.exec(khBikinkanri.getBknkktymd()).getBizDateY();

                bknkktiNnd = DateFormatUtil.dateYKANJISeireki(kessanNensiY).concat("度");

                if (khBikinKanriinfoOutKns == 0) {

                    bkncdKey = khBikinkanri.getBkncdkbn();

                    hknsyuruiKey = khBikinkanri.getKbnkeirisegcd();

                    bknkktiNndKey = kessanNensiY;

                }
                else {

                    if (kessanNensiY.compareTo(bknkktiNndKey) != 0 ||
                        !khBikinkanri.getKbnkeirisegcd().eq(hknsyuruiKey)) {

                        String bknkktiNndGoukeitani = DateFormatUtil.dateYKANJISeireki(bknkktiNndKey).concat("度");

                        editKhYendtHnkBikinListSksBknkktinndSyuukei(bknkktiNndGoukeitani, bknkktiNndListSksBean);

                        bknkktiNndKey = kessanNensiY;

                        pageNo = pageNo + 1;

                        itiPageCount = 0;

                        bknkktiNndListSksBean = new KhYendtHnkBikinListSksBean();

                    }

                    if (!khBikinkanri.getKbnkeirisegcd().eq(hknsyuruiKey)) {

                        KhYendthnkHrBikinListDataSourceBean khYendthnkHrBikinListDataSourceBean =
                            editKhYendtHnkBikinListInsuranceSyuukei(bkncdKey, hknsyuruiKey, hknsyuruiListSksBean);

                        khYendthnkHrBikinListDataSourceBeanLst.add(khYendthnkHrBikinListDataSourceBean);

                        hknsyuruiKey = khBikinkanri.getKbnkeirisegcd();

                        pageNo = pageNo + 1;

                        itiPageCount = 0;

                        hknsyuruiListSksBean = new KhYendtHnkBikinListSksBean();
                    }

                    if (itiPageCount == 30) {

                        pageNo = pageNo + 1;

                        itiPageCount = 0;

                    }
                }

                itiPageCount = itiPageCount + 1;


                bknkktiNndListSksBean.setBikinKensuuGouke(bknkktiNndListSksBean.getBikinKensuuGoukei().add(
                    BizNumber.valueOf(1)));

                bknkktiNndListSksBean.setBikingakugoukei(bknkktiNndListSksBean.getBikingakugoukei().add(
                    khBikinkanri.getBkngk()));

                hknsyuruiListSksBean.setBikinKensuuGouke(hknsyuruiListSksBean.getBikinKensuuGoukei().add(
                    BizNumber.valueOf(1)));

                hknsyuruiListSksBean.setBikingakugoukei(hknsyuruiListSksBean.getBikingakugoukei().add(
                    khBikinkanri.getBkngk()));

                bkncdListSksBean.setBikinKensuuGouke(bkncdListSksBean.getBikinKensuuGoukei().add(
                    BizNumber.valueOf(1)));

                bkncdListSksBean.setBikingakugoukei(bkncdListSksBean.getBikingakugoukei().add(
                    khBikinkanri.getBkngk()));

                KhYendthnkHrBikinListDataSourceBean khYendthnkHrBikinListDataSourceBean = SWAKInjector.
                    getInstance(KhYendthnkHrBikinListDataSourceBean.class);

                khYendthnkHrBikinListDataSourceBean.setIrBkncd(khBikinkanri.getBkncdkbn().toString());

                khYendthnkHrBikinListDataSourceBean.setIrBknkktiymdwareki(bknkktYmd);

                khYendthnkHrBikinListDataSourceBean.setIrSisyacd(khBikinkanri.getSisyacd());

                khYendthnkHrBikinListDataSourceBean.setIrKigou(khBikinkanri.getSyouhncd().substring(0, 2));

                khYendthnkHrBikinListDataSourceBean.setIrSyono(khBikinkanri.getSyono());

                khYendthnkHrBikinListDataSourceBean.setIrBkngk(khBikinkanri.getBkngk());

                khYendthnkHrBikinListDataSourceBean.setIrKbnkeirihknsyuruinm(khBikinkanri.getKbnkeirisegcd());

                khYendthnkHrBikinListDataSourceBean.setIrBknkktinnd(bknkktiNnd);

                khYendthnkHrBikinListDataSourceBean.setIrBikinkensuugoukei(null);

                khYendthnkHrBikinListDataSourceBean.setIrBikingakugoukei(null);

                khYendthnkHrBikinListDataSourceBean.setIrGoukeitani("");

                khYendthnkHrBikinListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

                khYendthnkHrBikinListDataSourceBeanLst.add(khYendthnkHrBikinListDataSourceBean);

                String syoriDate = DateFormatUtil.dateKANJINoEx(syoriYmd);

                String kessanNendoMae = DateFormatUtil.dateYKANJISeireki(
                    setKessanNensibi.exec(khBikinkanri.getKessankijyunymd()).getBizDateY()).concat("度");

                String dbknkessanKbn = "";

                if (khBikinkanri.getKessankijyunymd().getMonth() == 3) {

                    dbknkessanKbn = "決算";

                }
                else if (khBikinkanri.getKessankijyunymd().getMonth() == 6) {

                    dbknkessanKbn = "四半期";

                }
                else if (khBikinkanri.getKessankijyunymd().getMonth() == 9) {

                    dbknkessanKbn = "半期";

                }
                else if (khBikinkanri.getKessankijyunymd().getMonth() == 12) {

                    dbknkessanKbn = "四半期";

                }
                kessanNnd = kessanNendoMae + dbknkessanKbn;

                KhBikinSgyLstCsvfYendthnkHrFile khBikinSgyLstCsvfYendthnkHrFile = SWAKInjector.getInstance(
                    KhBikinSgyLstCsvfYendthnkHrFile.class);

                khBikinSgyLstCsvfYendthnkHrFile.setIfcListnm("円建変更時返戻金備金リスト（区分経理用）");

                khBikinSgyLstCsvfYendthnkHrFile.setIfcAtesaki(tantsituNm);

                khBikinSgyLstCsvfYendthnkHrFile.setIfcSakuseiymdwareki(syoriDate);

                khBikinSgyLstCsvfYendthnkHrFile.setIfcPageno(String.valueOf(pageNo));

                khBikinSgyLstCsvfYendthnkHrFile.setIfcKessannnd(kessanNnd);

                khBikinSgyLstCsvfYendthnkHrFile.setIfcHknsyuruinm(khBikinkanri.getKbnkeirisegcd().getContent());

                khBikinSgyLstCsvfYendthnkHrFile.setIfcBkncd(khBikinkanri.getBkncdkbn().toString());

                khBikinSgyLstCsvfYendthnkHrFile.setIfcBknkktiymdwareki(bknkktYmd);

                khBikinSgyLstCsvfYendthnkHrFile.setIfcUktksisya(khBikinkanri.getSisyacd());

                khBikinSgyLstCsvfYendthnkHrFile.setIfcHknsyuruikigou(khBikinkanri.getSyouhncd().substring(0, 2));

                khBikinSgyLstCsvfYendthnkHrFile.setIfcSyono(khBikinkanri.getSyono());

                khBikinSgyLstCsvfYendthnkHrFile.setIfcBkngk(khBikinkanri.getBkngk().toString());

                khBikinSgyLstCsvfYendthnkHrFileLst.add(khBikinSgyLstCsvfYendthnkHrFile);

                khBikinKanriinfoOutKns = khBikinKanriinfoOutKns + 1;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            if (khBikinKanriinfoOutKns > 0) {

                editKhYendtHnkBikinListSksBknkktinndSyuukei(bknkktiNnd, bknkktiNndListSksBean);

                KhYendthnkHrBikinListDataSourceBean khYendthnkHrBikinListDataSourceBean =
                    editKhYendtHnkBikinListInsuranceSyuukei(bkncdKey, hknsyuruiKey, hknsyuruiListSksBean);

                khYendthnkHrBikinListDataSourceBeanLst.add(khYendthnkHrBikinListDataSourceBean);

                KhYendthnkHrBikinListDataSourceBean khYendthnkHrBikinListbkncdDataSourceBean =
                    editKhYendtHnkBikinListBkncdkbnSyuukei(bkncdKey, bkncdListSksBean);

                khYendthnkHrBikinListDataSourceBeanLst.add(khYendthnkHrBikinListbkncdDataSourceBean);

            }
            reportServicesBean.addParamObjects(khYendthnkHrBikinListDataSourceBeanLst, khYendthnkHrBikinListBean);
            reportServicesBean.setSyoriYmd(syoriYmd);
            createReport.execNoCommit(reportServicesBean);

            BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);
            C_ErrorKbn errorKbn = bzFileUploadUtil.exec(
                C_FileSyuruiCdKbn.KH_BIKINLSTCSVFYENDTHNKHR,
                khBikinSgyLstCsvfYendthnkHrFileLst,
                true);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
            }

            batchLogger.info(MessageUtil.getMessage(
                MessageId.IBF0002, String.valueOf(khBikinKanriinfoOutKns), "<<円建変更時返戻金備金リスト>>"));

        }
    }

    private void editKhYendtHnkBikinListSksBknkktinndSyuukei(String pBknkktiNnd,
        KhYendtHnkBikinListSksBean pKhYendtHnkBikinListSksBean) {

        KhYendthnkHrBikinListDataSourceBean khYendthnkHrBikinListDataSourceBean = SWAKInjector.
            getInstance(KhYendthnkHrBikinListDataSourceBean.class);

        khYendthnkHrBikinListDataSourceBean = (KhYendthnkHrBikinListDataSourceBean)
            khYendthnkHrBikinListDataSourceBeanLst.get(khYendthnkHrBikinListDataSourceBeanLst.size() - 1);

        khYendthnkHrBikinListDataSourceBean.setIrBikinkensuugoukei(pKhYendtHnkBikinListSksBean.getBikinKensuuGoukei());
        khYendthnkHrBikinListDataSourceBean.setIrBikingakugoukei(pKhYendtHnkBikinListSksBean.getBikingakugoukei());
        khYendthnkHrBikinListDataSourceBean.setIrGoukeitani(pBknkktiNnd);
        khYendthnkHrBikinListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
    }

    private KhYendthnkHrBikinListDataSourceBean editKhYendtHnkBikinListInsuranceSyuukei(C_BkncdKbn pBkncd,
        C_Segcd pHknsyurui, KhYendtHnkBikinListSksBean pKhYendtHnkBikinListSksBean) {

        KhYendthnkHrBikinListDataSourceBean khYendthnkHrBikinListDataSourceBean = SWAKInjector.
            getInstance(KhYendthnkHrBikinListDataSourceBean.class);

        khYendthnkHrBikinListDataSourceBean.setIrBkncd(pBkncd.toString());

        khYendthnkHrBikinListDataSourceBean.setIrBknkktiymdwareki("");

        khYendthnkHrBikinListDataSourceBean.setIrSisyacd("");

        khYendthnkHrBikinListDataSourceBean.setIrKigou("");

        khYendthnkHrBikinListDataSourceBean.setIrSyono("");

        khYendthnkHrBikinListDataSourceBean.setIrBkngk(BizCurrency.valueOf(0));

        khYendthnkHrBikinListDataSourceBean.setIrKbnkeirihknsyuruinm(pHknsyurui);

        khYendthnkHrBikinListDataSourceBean.setIrBknkktinnd("");

        khYendthnkHrBikinListDataSourceBean.setIrBikinkensuugoukei(pKhYendtHnkBikinListSksBean.getBikinKensuuGoukei());

        khYendthnkHrBikinListDataSourceBean.setIrBikingakugoukei(pKhYendtHnkBikinListSksBean.getBikingakugoukei());

        khYendthnkHrBikinListDataSourceBean.setIrGoukeitani(pHknsyurui.getContent());

        khYendthnkHrBikinListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.ARI);

        return khYendthnkHrBikinListDataSourceBean;
    }

    private KhYendthnkHrBikinListDataSourceBean editKhYendtHnkBikinListBkncdkbnSyuukei(C_BkncdKbn pBkncd,
        KhYendtHnkBikinListSksBean pKhYendtHnkBikinListSksBean) {

        KhYendthnkHrBikinListDataSourceBean khYendthnkHrBikinListDataSourceBean = SWAKInjector.
            getInstance(KhYendthnkHrBikinListDataSourceBean.class);

        khYendthnkHrBikinListDataSourceBean.setIrBkncd(pBkncd.toString());

        khYendthnkHrBikinListDataSourceBean.setIrBknkktiymdwareki("");

        khYendthnkHrBikinListDataSourceBean.setIrSisyacd("");

        khYendthnkHrBikinListDataSourceBean.setIrKigou("");

        khYendthnkHrBikinListDataSourceBean.setIrSyono("");

        khYendthnkHrBikinListDataSourceBean.setIrBkngk(BizCurrency.valueOf(0));

        khYendthnkHrBikinListDataSourceBean.setIrKbnkeirihknsyuruinm(C_Segcd.BLNK);

        khYendthnkHrBikinListDataSourceBean.setIrBknkktinnd("");

        khYendthnkHrBikinListDataSourceBean.setIrBikinkensuugoukei(pKhYendtHnkBikinListSksBean.getBikinKensuuGoukei());

        khYendthnkHrBikinListDataSourceBean.setIrBikingakugoukei(pKhYendtHnkBikinListSksBean.getBikingakugoukei());

        khYendthnkHrBikinListDataSourceBean.setIrGoukeitani(pBkncd.getValue());

        khYendthnkHrBikinListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.ARI);

        return khYendthnkHrBikinListDataSourceBean;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }

    class KhYendtHnkBikinListSksBean {

        private BizNumber bikinKensuuGoukei;

        private BizCurrency bikingakuGoukei;

        public KhYendtHnkBikinListSksBean() {

            bikinKensuuGoukei = BizNumber.valueOf(0);

            bikingakuGoukei = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        }

        public BizNumber getBikinKensuuGoukei() {
            return bikinKensuuGoukei;
        }

        public void setBikinKensuuGouke(BizNumber pBikinKensuuGouke) {
            bikinKensuuGoukei = pBikinKensuuGouke;
        }

        public BizCurrency getBikingakugoukei() {
            return bikingakuGoukei;
        }

        public void setBikingakugoukei(BizCurrency pBikingakuGoukei) {
            bikingakuGoukei = pBikingakuGoukei;
        }
    }
}
