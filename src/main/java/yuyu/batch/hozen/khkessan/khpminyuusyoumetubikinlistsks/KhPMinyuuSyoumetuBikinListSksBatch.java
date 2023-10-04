package yuyu.batch.hozen.khkessan.khpminyuusyoumetubikinlistsks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khkessan.khpminyuusyoumetubikinlistsks.dba.KhPMinyuuSyoumetuBikinListSksDao;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.report.ViewReport;
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
import yuyu.def.db.entity.IT_AsBikinkanri;
import yuyu.def.hozen.bean.report.KhPmnySymtjHnrknBknListBean;
import yuyu.def.hozen.bean.report.KhPmnySymtjHnrknBknListDataSourceBean;
import yuyu.def.hozen.file.csv.KhPmnySymtjHnrknBknListCsvFile;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 決算 Ｐ未入消滅備金時効リスト作成
 */
public class KhPMinyuuSyoumetuBikinListSksBatch implements Batch {

    private static final String TABLE_ID = IT_AsBikinkanri.TABLE_NAME;

    private static final String RECOVERY_FILTER_ID = "Bz001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhPMinyuuSyoumetuBikinListSksBatchParam batchParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private KhPMinyuuSyoumetuBikinListSksDao khPMinyuuSyoumetuBikinListSksDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    private List<IReportDataSouceBean> khPmnySymtjHnrknBknListDsBeanLst;

    @Override
    public BatchParam getParam() {

        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = batchParam.getSyoriYmd();
        BizDate kessanYmd = batchParam.getKessanYmd();
        String kakutyoujobCd = batchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1020),
            String.valueOf(kessanYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyoujobCd));

        try (ExDBResults<IT_AsBikinkanri> asBikinkanriLst = khPMinyuuSyoumetuBikinListSksDao.
            getAsBikinkanriInfosByKakutyoujobcdKsnbiymdBikincdkbn(kakutyoujobCd, kessanYmd, C_BkncdKbn.PMINYUUSYOUMETU)) {

            CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                kinou.getSubSystemId(),
                kinou.getCategoryId(),
                kinou.getKinouId(),
                C_SyoruiCdKbn.AS_PMINYUUSYOUMETUHRBKNLIST);

            String tyouhyouYmd = DateFormatUtil.dateKANJINoEx(syoriYmd);

            String busituCd = bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU).getBusitucd();

            BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

            BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(busituCd + "0000");

            String tantsituNm = "";
            if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {
                tantsituNm = bzGetSosikiDataBean.getKanjisosikinm20();
            }

            String kessanNnd = DateFormatUtil.dateYKANJISeirekiNendo(kessanYmd);

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

            String hozonKkn = ViewReport.getHozonKknTani(C_SyoruiCdKbn.AS_PMINYUUSYOUMETUHRBKNLIST);

            KhPmnySymtjHnrknBknListBean khPmnySymtjHnrknBknListBean = SWAKInjector.
                getInstance(KhPmnySymtjHnrknBknListBean.class);
            khPmnySymtjHnrknBknListBean.setIrTantsitunmkj(tantsituNm);
            khPmnySymtjHnrknBknListBean.setIrKessannnd(kessanNnd);
            khPmnySymtjHnrknBknListBean.setIrBknkessankbn(bknkessanKbn);
            khPmnySymtjHnrknBknListBean.setIrTyouhyousakuseiymd(tyouhyouYmd);
            khPmnySymtjHnrknBknListBean.setIrHozonkkn(hozonKkn);

            long pMinyuuSyoumetuHrbknLstOutKns = 0;
            int pageNo = 1;
            int itiPageCount = 0;
            String bknKktiNnd = "";
            C_BkncdKbn bknCdKey = null;
            C_Segcd hknSyuruiKey = null;
            String bknKktiNndKey = "";

            PMinyuuSyoumetuHrbknlistBean bknKktiNndSyuukeiBean = new PMinyuuSyoumetuHrbknlistBean();
            PMinyuuSyoumetuHrbknlistBean hknSyuruiSyuukeiBean = new PMinyuuSyoumetuHrbknlistBean();
            PMinyuuSyoumetuHrbknlistBean bknCdListSksBean = new PMinyuuSyoumetuHrbknlistBean();

            khPmnySymtjHnrknBknListDsBeanLst = new ArrayList<IReportDataSouceBean>();

            List<KhPmnySymtjHnrknBknListCsvFile> khPmnySymtjHnrknBknListCsvFileLst =
                new ArrayList<KhPmnySymtjHnrknBknListCsvFile>();

            for (IT_AsBikinkanri asBikinkanri : asBikinkanriLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(asBikinkanri.getSyono());

                String bknkktYmd = DateFormatUtil.dateKANJINoEx(asBikinkanri.getBknkktymd());

                bknKktiNnd = DateFormatUtil.dateYKANJISeirekiNendo(asBikinkanri.getBknkktymd());

                if (pMinyuuSyoumetuHrbknLstOutKns == 0) {
                    bknCdKey = asBikinkanri.getBkncdkbn();
                    hknSyuruiKey = asBikinkanri.getKbnkeirisegcd();
                    bknKktiNndKey = bknKktiNnd;
                }
                else {
                    if (!bknKktiNndKey.equals(bknKktiNnd) ||
                        !asBikinkanri.getKbnkeirisegcd().eq(hknSyuruiKey)) {

                        editPMinyuuSyoumetuHrbknlistBknkktinndSyuukei(bknKktiNndKey, bknKktiNndSyuukeiBean);

                        bknKktiNndKey = bknKktiNnd;

                        pageNo = pageNo + 1;
                        itiPageCount = 0;

                        bknKktiNndSyuukeiBean = new PMinyuuSyoumetuHrbknlistBean();
                    }

                    if (!asBikinkanri.getKbnkeirisegcd().eq(hknSyuruiKey)) {

                        KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListDsBean =
                            editPMinyuuSyoumetuHrbknlistHknsyuruiSyuukei(bknCdKey, hknSyuruiKey, hknSyuruiSyuukeiBean);

                        khPmnySymtjHnrknBknListDsBeanLst.add(khPmnySymtjHnrknBknListDsBean);

                        hknSyuruiKey = asBikinkanri.getKbnkeirisegcd();

                        pageNo = pageNo + 1;
                        itiPageCount = 0;

                        hknSyuruiSyuukeiBean = new PMinyuuSyoumetuHrbknlistBean();
                    }

                    if (itiPageCount == 30) {
                        pageNo = pageNo + 1;
                        itiPageCount = 0;
                    }
                }

                itiPageCount = itiPageCount + 1;

                bknKktiNndSyuukeiBean.setBikinKensuuGouke(bknKktiNndSyuukeiBean.getBikinKensuuGoukei().add(
                    BizNumber.valueOf(1)));
                bknKktiNndSyuukeiBean.setBikingakugoukei(bknKktiNndSyuukeiBean.getBikingakugoukei().add(
                    asBikinkanri.getBkngk()));

                hknSyuruiSyuukeiBean.setBikinKensuuGouke(hknSyuruiSyuukeiBean.getBikinKensuuGoukei().add(
                    BizNumber.valueOf(1)));
                hknSyuruiSyuukeiBean.setBikingakugoukei(hknSyuruiSyuukeiBean.getBikingakugoukei().add(
                    asBikinkanri.getBkngk()));

                bknCdListSksBean.setBikinKensuuGouke(bknCdListSksBean.getBikinKensuuGoukei().add(
                    BizNumber.valueOf(1)));
                bknCdListSksBean.setBikingakugoukei(bknCdListSksBean.getBikingakugoukei().add(
                    asBikinkanri.getBkngk()));

                KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListsBean = SWAKInjector.
                    getInstance(KhPmnySymtjHnrknBknListDataSourceBean.class);

                khPmnySymtjHnrknBknListsBean.setIrBkncd(asBikinkanri.getBkncdkbn().getValue());
                khPmnySymtjHnrknBknListsBean.setIrKbnkeirihknsyuruinm(asBikinkanri.getKbnkeirisegcd());
                khPmnySymtjHnrknBknListsBean.setIrBknkktinnd(bknKktiNnd);
                khPmnySymtjHnrknBknListsBean.setIrBknkktiymd(bknkktYmd);
                khPmnySymtjHnrknBknListsBean.setIrSisyacd(asBikinkanri.getSisyacd());
                khPmnySymtjHnrknBknListsBean.setIrKigou(asBikinkanri.getSyouhncd().substring(0, 2));
                khPmnySymtjHnrknBknListsBean.setIrSyono(asBikinkanri.getSyono());
                khPmnySymtjHnrknBknListsBean.setIrBkngk(asBikinkanri.getBkngk());
                khPmnySymtjHnrknBknListsBean.setIrGoukeitani("");
                khPmnySymtjHnrknBknListsBean.setIrBikinkensuugoukei(null);
                khPmnySymtjHnrknBknListsBean.setIrBikingakugoukei(null);
                khPmnySymtjHnrknBknListsBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

                khPmnySymtjHnrknBknListDsBeanLst.add(khPmnySymtjHnrknBknListsBean);

                String kwsratekjymd = DateFormatUtil.dateKANJINoEx(asBikinkanri.getKwsratekjymd());

                KhPmnySymtjHnrknBknListCsvFile khPmnySymtjHnrknBknListCsvFile = SWAKInjector.getInstance(
                    KhPmnySymtjHnrknBknListCsvFile.class);

                khPmnySymtjHnrknBknListCsvFile.setIfcListnm("Ｐ未入消滅時返戻金備金リスト（区分経理用）");
                khPmnySymtjHnrknBknListCsvFile.setIfcAtesaki(tantsituNm);
                khPmnySymtjHnrknBknListCsvFile.setIfcSakuseiymdseireki(tyouhyouYmd);
                khPmnySymtjHnrknBknListCsvFile.setIfcPageno(String.valueOf(pageNo));
                khPmnySymtjHnrknBknListCsvFile.setIfcKessannnd(kessanNnd + bknkessanKbn.getContent());
                khPmnySymtjHnrknBknListCsvFile.setIfcHknsyuruinm(asBikinkanri.getKbnkeirisegcd().getContent());
                khPmnySymtjHnrknBknListCsvFile.setIfcBkncd(asBikinkanri.getBkncdkbn().getValue());
                khPmnySymtjHnrknBknListCsvFile.setIfcBknkktiymdseireki(bknkktYmd);
                khPmnySymtjHnrknBknListCsvFile.setIfcUktksisya(asBikinkanri.getSisyacd());
                khPmnySymtjHnrknBknListCsvFile.setIfcHknsyuruikigou(asBikinkanri.getSyouhncd().substring(0, 2));
                khPmnySymtjHnrknBknListCsvFile.setIfcSyono(asBikinkanri.getSyono());
                khPmnySymtjHnrknBknListCsvFile.setIfcBkngk(asBikinkanri.getBkngk().toString());
                khPmnySymtjHnrknBknListCsvFile.setIfcKbnkeirisegcd(asBikinkanri.getKbnkeirisegcd().getValue());
                khPmnySymtjHnrknBknListCsvFile.setIfcSyoriumukbn(asBikinkanri.getSyoriumukbn().getValue());
                khPmnySymtjHnrknBknListCsvFile.setIfcBknjkukbn(asBikinkanri.getBknjkukbn());
                khPmnySymtjHnrknBknListCsvFile.setIfcKaiyakuhrkngaika(asBikinkanri.getKaiyakuhrgaika().toString());
                khPmnySymtjHnrknBknListCsvFile.setIfcKyktuukasyu(asBikinkanri.getKyktuukasyu().getValue());
                khPmnySymtjHnrknBknListCsvFile.setIfcShrtuukasyu(asBikinkanri.getShrtuukasyu());
                khPmnySymtjHnrknBknListCsvFile.setIfcKwsratekjymd(kwsratekjymd);
                khPmnySymtjHnrknBknListCsvFile.setIfcKawaserate(asBikinkanri.getKawaserate().toString());

                khPmnySymtjHnrknBknListCsvFileLst.add(khPmnySymtjHnrknBknListCsvFile);

                pMinyuuSyoumetuHrbknLstOutKns = pMinyuuSyoumetuHrbknLstOutKns + 1;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            if (pMinyuuSyoumetuHrbknLstOutKns > 0) {

                editPMinyuuSyoumetuHrbknlistBknkktinndSyuukei(bknKktiNnd, bknKktiNndSyuukeiBean);

                KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListDsBean =
                    editPMinyuuSyoumetuHrbknlistHknsyuruiSyuukei(bknCdKey, hknSyuruiKey, hknSyuruiSyuukeiBean);
                khPmnySymtjHnrknBknListDsBeanLst.add(khPmnySymtjHnrknBknListDsBean);

                KhPmnySymtjHnrknBknListDataSourceBean khKhPmnySymtjHnrknBknListBknCdDsBean =
                    editKhPmnySymtjHnrknBknListBkncdkbnSyuukei(bknCdKey, bknCdListSksBean);
                khPmnySymtjHnrknBknListDsBeanLst.add(khKhPmnySymtjHnrknBknListBknCdDsBean);
            }

            reportServicesBean.addParamObjects(khPmnySymtjHnrknBknListDsBeanLst, khPmnySymtjHnrknBknListBean);
            reportServicesBean.setSyoriYmd(syoriYmd);
            createReport.execNoCommit(reportServicesBean);

            BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);
            C_ErrorKbn errorKbn = bzFileUploadUtil.exec(
                C_FileSyuruiCdKbn.AS_PMINYUUSYOUMETUHRBKNLIST,
                khPmnySymtjHnrknBknListCsvFileLst,
                true);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
            }

            batchLogger.info(MessageUtil.getMessage(
                MessageId.IBF0002, String.valueOf(pMinyuuSyoumetuHrbknLstOutKns), "Ｐ未入消滅時返戻金備金リスト"));

        }
    }

    private void editPMinyuuSyoumetuHrbknlistBknkktinndSyuukei(String pBknkktiNnd,
        PMinyuuSyoumetuHrbknlistBean pPMinyuuSyoumetuHrbknlistBean) {

        KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListDsBean = (KhPmnySymtjHnrknBknListDataSourceBean)
            khPmnySymtjHnrknBknListDsBeanLst.get(khPmnySymtjHnrknBknListDsBeanLst.size() -1);

        khPmnySymtjHnrknBknListDsBean.setIrBikinkensuugoukei(pPMinyuuSyoumetuHrbknlistBean.getBikinKensuuGoukei());
        khPmnySymtjHnrknBknListDsBean.setIrBikingakugoukei(pPMinyuuSyoumetuHrbknlistBean.getBikingakugoukei());
        khPmnySymtjHnrknBknListDsBean.setIrGoukeitani(pBknkktiNnd);
        khPmnySymtjHnrknBknListDsBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
    }

    private KhPmnySymtjHnrknBknListDataSourceBean editPMinyuuSyoumetuHrbknlistHknsyuruiSyuukei(C_BkncdKbn pBknCd,
        C_Segcd pHknSyurui, PMinyuuSyoumetuHrbknlistBean pPMinyuuSyoumetuHrbknlistBean) {

        KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListDsBean = SWAKInjector.
            getInstance(KhPmnySymtjHnrknBknListDataSourceBean.class);

        khPmnySymtjHnrknBknListDsBean.setIrBkncd(pBknCd.getValue());
        khPmnySymtjHnrknBknListDsBean.setIrKbnkeirihknsyuruinm(pHknSyurui);
        khPmnySymtjHnrknBknListDsBean.setIrBknkktinnd("");
        khPmnySymtjHnrknBknListDsBean.setIrBknkktiymd("");
        khPmnySymtjHnrknBknListDsBean.setIrSisyacd("");
        khPmnySymtjHnrknBknListDsBean.setIrKigou("");
        khPmnySymtjHnrknBknListDsBean.setIrSyono("");
        khPmnySymtjHnrknBknListDsBean.setIrBkngk(BizCurrency.valueOf(0));
        khPmnySymtjHnrknBknListDsBean.setIrGoukeitani(pHknSyurui.getContent());
        khPmnySymtjHnrknBknListDsBean.setIrBikinkensuugoukei(pPMinyuuSyoumetuHrbknlistBean.getBikinKensuuGoukei());
        khPmnySymtjHnrknBknListDsBean.setIrBikingakugoukei(pPMinyuuSyoumetuHrbknlistBean.getBikingakugoukei());
        khPmnySymtjHnrknBknListDsBean.setIrGoukeiumukbn(C_UmuKbn.ARI);
        return khPmnySymtjHnrknBknListDsBean;
    }

    private KhPmnySymtjHnrknBknListDataSourceBean editKhPmnySymtjHnrknBknListBkncdkbnSyuukei(C_BkncdKbn pBkncd,
        PMinyuuSyoumetuHrbknlistBean pPMinyuuSyoumetuHrbknlistBean) {

        KhPmnySymtjHnrknBknListDataSourceBean khPmnySymtjHnrknBknListDsBean = SWAKInjector.
            getInstance(KhPmnySymtjHnrknBknListDataSourceBean.class);

        khPmnySymtjHnrknBknListDsBean.setIrBkncd(pBkncd.getValue());
        khPmnySymtjHnrknBknListDsBean.setIrKbnkeirihknsyuruinm(C_Segcd.BLNK);
        khPmnySymtjHnrknBknListDsBean.setIrBknkktinnd("");
        khPmnySymtjHnrknBknListDsBean.setIrBknkktiymd("");
        khPmnySymtjHnrknBknListDsBean.setIrSisyacd("");
        khPmnySymtjHnrknBknListDsBean.setIrKigou("");
        khPmnySymtjHnrknBknListDsBean.setIrSyono("");
        khPmnySymtjHnrknBknListDsBean.setIrBkngk(BizCurrency.valueOf(0));
        khPmnySymtjHnrknBknListDsBean.setIrGoukeitani(pBkncd.getValue());
        khPmnySymtjHnrknBknListDsBean.setIrBikinkensuugoukei(pPMinyuuSyoumetuHrbknlistBean.getBikinKensuuGoukei());
        khPmnySymtjHnrknBknListDsBean.setIrBikingakugoukei(pPMinyuuSyoumetuHrbknlistBean.getBikingakugoukei());
        khPmnySymtjHnrknBknListDsBean.setIrGoukeiumukbn(C_UmuKbn.ARI);
        return khPmnySymtjHnrknBknListDsBean;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }

    class PMinyuuSyoumetuHrbknlistBean {

        private BizNumber bikinKensuuGoukei;

        private BizCurrency bikingakuGoukei;

        public PMinyuuSyoumetuHrbknlistBean() {

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
