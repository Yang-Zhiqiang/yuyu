package yuyu.batch.hozen.khkessan.khzennouseisankinlistsks;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.google.common.collect.Lists;

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
import yuyu.batch.hozen.khkessan.khzennouseisankinlistsks.dba.KhZennouseisankinListSksDao;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.hozen.khcommon.SetBikinKessanKbn;
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
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.hozen.bean.report.KhZennouseisankinMeisaiListBean;
import yuyu.def.hozen.bean.report.KhZennouseisankinMeisaiListDataSourceBean;
import yuyu.def.hozen.file.csv.KhZennouseisankinMeisaiLstCsvfFile;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 決算 前納精算金明細リスト作成
 */
public class KhZennouseisankinListSksBatch implements Batch {

    private static final String TABLE_ID = IT_KhBikinkanri.TABLE_NAME;

    private static final String RECOVERY_FILTER_ID = "Bz001";

    private String kakutyoujobCd;

    private BizDate syoriYmd;

    private String tantousituNm;

    private List<IReportDataSouceBean> khzennouSeisanKgkMeisaiListDataSourceBeanLst;

    private List<KhZennouseisankinMeisaiLstCsvfFile> khZennouseisankinMeisaiLstCsvfFileLst;

    private long khBikinKanriinfoOutKns;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhZennouseisankinListSksBatchParam khMakeZennouseisankinBatchParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private KhZennouseisankinListSksDao khZennouseisankinListSksDao;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {

        return khMakeZennouseisankinBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        syoriYmd = khMakeZennouseisankinBatchParam.getSyoriYmd();
        kakutyoujobCd = khMakeZennouseisankinBatchParam.getIbKakutyoujobcd();
        tantousituNm = null;
        khBikinKanriinfoOutKns = 0;
        khzennouSeisanKgkMeisaiListDataSourceBeanLst = Lists.newArrayList();
        khZennouseisankinMeisaiLstCsvfFileLst = Lists.newArrayList();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(syoriYmd)));

        String tyouhyouYmd = DateFormatUtil.dateKANJINoEx(syoriYmd);
        BizDate kessanYmd = khMakeZennouseisankinBatchParam.getKessanYmd();

        String kessanNnd = DateFormatUtil.dateYKANJISeirekiNendo(kessanYmd);

        SetBikinKessanKbn setBikinKessanKbn = SWAKInjector.getInstance(SetBikinKessanKbn.class);
        C_Bknkessankbn bknkessankbn  = setBikinKessanKbn.exec(kessanYmd);

        List<IReportDataSouceBean> khZennouseisaSiBikinjikouListDataSourceBeanGengkLst = Lists.newArrayList();

        List<KhZennouseisankinMeisaiLstCsvfFile> khZennouseisankinMeisaiLstCsvfFileGengkLst = Lists.newArrayList();

        List<IReportDataSouceBean> khZennouseisaSiBikinjikouListDataSourceBeanKaiykLst = Lists.newArrayList();

        List<KhZennouseisankinMeisaiLstCsvfFile> khZennouseisankinMeisaiLstCsvfFileKaiykLst = Lists.newArrayList();

        try (ExDBResults<IT_KhBikinkanri> khBikinkanriGengkLst = khZennouseisankinListSksDao.
            getKhBikinkanrisByKakutyoujobcdKessankijyunymdBkncdkbnBknrigikbnZennouseisankgk(kakutyoujobCd, kessanYmd, C_BkncdKbn.GENGK)) {

            CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

            ReportServicesBean reportServicesGengkBean = createReport.createNewReportServiceBean(
                kinou.getSubSystemId(),
                kinou.getCategoryId(),
                kinou.getKinouId(),
                C_SyoruiCdKbn.KK_ZENNOUSEISANKINMEISAILIST_GENGAKU);

            String busituCd = bizDomManager.getTantouCd(C_TantouCdKbn.KEIYAKUHENKOU).getBusitucd();

            BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

            BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(busituCd + "0000");

            if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())){

                tantousituNm = bzGetSosikiDataBean.getKanjisosikinm20();

            }

            String hozonKkn = ViewReport.getHozonKknTani(C_SyoruiCdKbn.KK_ZENNOUSEISANKINMEISAILIST_GENGAKU);

            KhZennouseisankinMeisaiListBean khZennouseisankinMeisaiListBeanGengk = SWAKInjector.
                getInstance(KhZennouseisankinMeisaiListBean.class);

            khZennouseisankinMeisaiListBeanGengk.setIrTantsitunmkj(tantousituNm);

            khZennouseisankinMeisaiListBeanGengk.setIrKessannnd(kessanNnd);

            khZennouseisankinMeisaiListBeanGengk.setIrBknkessankbn(bknkessankbn);

            khZennouseisankinMeisaiListBeanGengk.setIrTyouhyousakuseiymd(tyouhyouYmd);

            khZennouseisankinMeisaiListBeanGengk.setIrHozonkkn(hozonKkn);

            editZennouseisanMeisaiListMeisaigyou(khBikinkanriGengkLst);

            khZennouseisaSiBikinjikouListDataSourceBeanGengkLst = khzennouSeisanKgkMeisaiListDataSourceBeanLst;

            khZennouseisankinMeisaiLstCsvfFileGengkLst = khZennouseisankinMeisaiLstCsvfFileLst;

            long khBikinKanriinfoOutKnsGengk = khBikinKanriinfoOutKns;

            long khBikinKanriinfoOutKnsKaiyk = Long.valueOf(0);

            KhZennouseisankinMeisaiListBean khZennouseisankinMeisaiListBeanKaiyk = SWAKInjector.
                getInstance(KhZennouseisankinMeisaiListBean.class);

            try (ExDBResults<IT_KhBikinkanri> khBikinkanriKaiyakuLst = khZennouseisankinListSksDao.
                getKhBikinkanrisByKakutyoujobcdKessankijyunymdBkncdkbnBknrigikbnZennouseisankgk(kakutyoujobCd, kessanYmd, C_BkncdKbn.KAIYAKU)) {

                ReportServicesBean reportServicesKaiyakuBean = createReport.createNewReportServiceBean(
                    kinou.getSubSystemId(),
                    kinou.getCategoryId(),
                    kinou.getKinouId(),
                    C_SyoruiCdKbn.KK_ZENNOUSEISANKINMEISAILIST_KAIYAKU);

                busituCd = bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU).getBusitucd();

                bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

                bzGetSosikiDataBean = bzGetSosikiData.exec(busituCd + "0000");

                tantousituNm = null;

                if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())){

                    tantousituNm = bzGetSosikiDataBean.getKanjisosikinm20();

                }

                hozonKkn = ViewReport.getHozonKknTani(C_SyoruiCdKbn.KK_ZENNOUSEISANKINMEISAILIST_KAIYAKU);

                khZennouseisankinMeisaiListBeanKaiyk.setIrTantsitunmkj(tantousituNm);

                khZennouseisankinMeisaiListBeanKaiyk.setIrKessannnd(kessanNnd);

                khZennouseisankinMeisaiListBeanKaiyk.setIrBknkessankbn(bknkessankbn);

                khZennouseisankinMeisaiListBeanKaiyk.setIrTyouhyousakuseiymd(tyouhyouYmd);

                khZennouseisankinMeisaiListBeanKaiyk.setIrHozonkkn(hozonKkn);

                editZennouseisanMeisaiListMeisaigyou(khBikinkanriKaiyakuLst);

                khZennouseisaSiBikinjikouListDataSourceBeanKaiykLst = khzennouSeisanKgkMeisaiListDataSourceBeanLst;

                khZennouseisankinMeisaiLstCsvfFileKaiykLst = khZennouseisankinMeisaiLstCsvfFileLst;

                khBikinKanriinfoOutKnsKaiyk = khBikinKanriinfoOutKns;

                reportServicesKaiyakuBean.addParamObjects(khZennouseisaSiBikinjikouListDataSourceBeanKaiykLst, khZennouseisankinMeisaiListBeanKaiyk);
                reportServicesKaiyakuBean.setSyoriYmd(syoriYmd);
                createReport.execNoCommit(reportServicesKaiyakuBean);

            }

            reportServicesGengkBean.addParamObjects(khZennouseisaSiBikinjikouListDataSourceBeanGengkLst, khZennouseisankinMeisaiListBeanGengk);
            reportServicesGengkBean.setSyoriYmd(syoriYmd);
            createReport.execNoCommit(reportServicesGengkBean);

            BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);
            C_ErrorKbn errorKbn = bzFileUploadUtil.exec(
                C_FileSyuruiCdKbn.KH_ZENNOUSEISANKINDTLLSTCSVFGENGAKU,
                khZennouseisankinMeisaiLstCsvfFileGengkLst,
                true);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
            }

            errorKbn = bzFileUploadUtil.exec(
                C_FileSyuruiCdKbn.KH_ZENNOUSEISANKINDTLLSTCSVFKAIYAKU,
                khZennouseisankinMeisaiLstCsvfFileKaiykLst,
                true);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
            }

            batchLogger.info(MessageUtil.getMessage(
                MessageId.IBF0002, String.valueOf(khBikinKanriinfoOutKnsGengk), "<<前納精算金リスト作成（減額分）>>"));
            batchLogger.info(MessageUtil.getMessage(
                MessageId.IBF0002, String.valueOf(khBikinKanriinfoOutKnsKaiyk), "<<前納精算金リスト作成（解約分）>>"));
        }
    }

    private void editZennouseisanMeisaiListBknkktiymSyuukei(
        ZennouseisanMeisaiListSyuukeiBean pZennouseisanMeisaiListSyuukeiBean) {

        KhZennouseisankinMeisaiListDataSourceBean khZennouseisankinMeisaiListDataSourceBean = (KhZennouseisankinMeisaiListDataSourceBean)
            khzennouSeisanKgkMeisaiListDataSourceBeanLst.get(khzennouSeisanKgkMeisaiListDataSourceBeanLst.size() -1);

        khZennouseisankinMeisaiListDataSourceBean.setIrSeisankinkensuugoukei(
            pZennouseisanMeisaiListSyuukeiBean.getSeisankinKensuuGoukei());
        khZennouseisankinMeisaiListDataSourceBean.setIrSeisankingakugoukei(
            pZennouseisanMeisaiListSyuukeiBean.getSeisankgkGoukei());
        khZennouseisankinMeisaiListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

    }

    private KhZennouseisankinMeisaiListDataSourceBean editZennouseisanMeisaiListBknkktiNndSyuukei(String pBkncd,
        String pBknkktiNnd, ZennouseisanMeisaiListSyuukeiBean pZennouseisanMeisaiListSyuukeiBean) {

        KhZennouseisankinMeisaiListDataSourceBean khZennouseisankinMeisaiListDataSourceBean = SWAKInjector.
            getInstance(KhZennouseisankinMeisaiListDataSourceBean.class);

        khZennouseisankinMeisaiListDataSourceBean.setIrBkncd(pBkncd);
        khZennouseisankinMeisaiListDataSourceBean.setIrHknsyruilevel("");
        khZennouseisankinMeisaiListDataSourceBean.setIrBknkktiymd("");
        khZennouseisankinMeisaiListDataSourceBean.setIrSyono("");
        khZennouseisankinMeisaiListDataSourceBean.setIrYenseisankin(BizCurrency.valueOf(0));
        khZennouseisankinMeisaiListDataSourceBean.setIrBknkktinnd(DateFormatUtil.dateYKANJISeireki(pBknkktiNnd) + "度");
        khZennouseisankinMeisaiListDataSourceBean.setIrBknkktiym("");
        khZennouseisankinMeisaiListDataSourceBean.setIrSeisankinkensuugoukei(pZennouseisanMeisaiListSyuukeiBean.getSeisankinKensuuGoukei());
        khZennouseisankinMeisaiListDataSourceBean.setIrSeisankingakugoukei(pZennouseisanMeisaiListSyuukeiBean.getSeisankgkGoukei());
        khZennouseisankinMeisaiListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.ARI);

        return khZennouseisankinMeisaiListDataSourceBean;
    }

    private KhZennouseisankinMeisaiListDataSourceBean editZennouseisanMeisaiListHknsyuruiSyuukei(String pBkncd,
        C_Segcd pHknsyurui, String pBknkktiNnd, ZennouseisanMeisaiListSyuukeiBean pZennouseisanMeisaiListSyuukeiBean) {

        KhZennouseisankinMeisaiListDataSourceBean khZennouseisankinMeisaiListDataSourceBean = SWAKInjector.
            getInstance(KhZennouseisankinMeisaiListDataSourceBean.class);

        khZennouseisankinMeisaiListDataSourceBean.setIrBkncd(pBkncd);
        khZennouseisankinMeisaiListDataSourceBean.setIrHknsyruilevel(pHknsyurui.getContent());
        khZennouseisankinMeisaiListDataSourceBean.setIrBknkktiymd("");
        khZennouseisankinMeisaiListDataSourceBean.setIrSyono("");
        khZennouseisankinMeisaiListDataSourceBean.setIrYenseisankin(BizCurrency.valueOf(0));
        khZennouseisankinMeisaiListDataSourceBean.setIrBknkktinnd(DateFormatUtil.dateYKANJISeireki(pBknkktiNnd) + "度");
        khZennouseisankinMeisaiListDataSourceBean.setIrBknkktiym("");
        khZennouseisankinMeisaiListDataSourceBean.setIrSeisankinkensuugoukei(pZennouseisanMeisaiListSyuukeiBean.getSeisankinKensuuGoukei());
        khZennouseisankinMeisaiListDataSourceBean.setIrSeisankingakugoukei(pZennouseisanMeisaiListSyuukeiBean.getSeisankgkGoukei());
        khZennouseisankinMeisaiListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.ARI);

        return khZennouseisankinMeisaiListDataSourceBean;
    }

    private void editZennouseisanMeisaiListMeisaigyou(ExDBResults<IT_KhBikinkanri> pKhBikinkanriLst) {

        long outCount = 0;
        int pageNo = 1;
        int itiPageCount = 0;
        String bknkktiNngetuKey = null;
        BizDateY bknkktiNndKey = null;
        C_Segcd hknsyuruiKey = C_Segcd.BLNK;
        C_BkncdKbn bkncdKey = C_BkncdKbn.BLNK;
        khBikinKanriinfoOutKns = 0;

        khzennouSeisanKgkMeisaiListDataSourceBeanLst  = Lists.newArrayList();
        khZennouseisankinMeisaiLstCsvfFileLst = Lists.newArrayList();

        ZennouseisanMeisaiListSyuukeiBean bknkktiNngetuSyuukeiBean =
            new ZennouseisanMeisaiListSyuukeiBean();
        ZennouseisanMeisaiListSyuukeiBean bknkktiNndSyuukeiBean =
            new ZennouseisanMeisaiListSyuukeiBean();
        ZennouseisanMeisaiListSyuukeiBean hknsyuruiSyuukeiBean =
            new ZennouseisanMeisaiListSyuukeiBean();

        for (IT_KhBikinkanri khBikinkanri : pKhBikinkanriLst) {
            bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
            bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
            bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_ID);
            bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khBikinkanri.getSyono());


            String bknkktYmd = DateFormatUtil.dateKANJINoEx(khBikinkanri.getBknkktymd());
            SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);
            BizDate kessanNensibi = setKessanNensibi.exec(khBikinkanri.getBknkktymd());
            String bknkktNnd = DateFormatUtil.dateYKANJISeireki(kessanNensibi.getBizDateY()) + "度";
            BizDateY sksBknkktNnd = kessanNensibi.getBizDateY();
            String bknkktYm = DateFormatUtil.dateYmKANJINoEx(khBikinkanri.getBknkktymd().getBizDateYM());

            KhZennouseisankinMeisaiListDataSourceBean khZennouseisankinMeisaiListDataSourceBean =
                SWAKInjector.getInstance(KhZennouseisankinMeisaiListDataSourceBean.class);
            if (outCount == 0) {
                bknkktiNngetuKey = bknkktYm;
                bknkktiNndKey = sksBknkktNnd;
                hknsyuruiKey = khBikinkanri.getKbnkeirisegcd();
                bkncdKey = khBikinkanri.getBkncdkbn();
            }
            else {
                if (!bknkktYm.equals(bknkktiNngetuKey) || !khBikinkanri.getKbnkeirisegcd().eq(hknsyuruiKey)) {
                    editZennouseisanMeisaiListBknkktiymSyuukei(bknkktiNngetuSyuukeiBean);

                    bknkktiNngetuKey = bknkktYm;
                    pageNo = pageNo + 1;
                    itiPageCount = 0;
                    bknkktiNngetuSyuukeiBean = new ZennouseisanMeisaiListSyuukeiBean();
                }
                if (!khBikinkanri.getKbnkeirisegcd().eq(hknsyuruiKey)) {
                    khZennouseisankinMeisaiListDataSourceBean = editZennouseisanMeisaiListHknsyuruiSyuukei(String.valueOf(bkncdKey),
                        hknsyuruiKey, String.valueOf(bknkktiNndKey), hknsyuruiSyuukeiBean);

                    khzennouSeisanKgkMeisaiListDataSourceBeanLst.add(khZennouseisankinMeisaiListDataSourceBean);
                    hknsyuruiKey = khBikinkanri.getKbnkeirisegcd();
                    pageNo = pageNo + 1;
                    itiPageCount = 0;
                    hknsyuruiSyuukeiBean = new ZennouseisanMeisaiListSyuukeiBean();
                }
                if (itiPageCount == 34) {
                    pageNo = pageNo + 1;
                    itiPageCount = 0;
                }
            }

            outCount = outCount + 1;
            itiPageCount = itiPageCount + 1;

            bknkktiNngetuSyuukeiBean.setSeisankinKensuuGoukei(bknkktiNngetuSyuukeiBean.getSeisankinKensuuGoukei().add(BizNumber.ONE));
            bknkktiNngetuSyuukeiBean.setSeisankgkGoukei(bknkktiNngetuSyuukeiBean.getSeisankgkGoukei().add(khBikinkanri.getZennouseisankgk()));

            bknkktiNndSyuukeiBean.setSeisankinKensuuGoukei(bknkktiNndSyuukeiBean.getSeisankinKensuuGoukei().add(BizNumber.ONE));
            bknkktiNndSyuukeiBean.setSeisankgkGoukei(bknkktiNndSyuukeiBean.getSeisankgkGoukei().add(khBikinkanri.getZennouseisankgk()));

            hknsyuruiSyuukeiBean.setSeisankinKensuuGoukei(hknsyuruiSyuukeiBean.getSeisankinKensuuGoukei().add(BizNumber.ONE));
            hknsyuruiSyuukeiBean.setSeisankgkGoukei(hknsyuruiSyuukeiBean.getSeisankgkGoukei().add(khBikinkanri.getZennouseisankgk()));

            khZennouseisankinMeisaiListDataSourceBean =
                SWAKInjector.getInstance(KhZennouseisankinMeisaiListDataSourceBean.class);

            khZennouseisankinMeisaiListDataSourceBean.setIrBkncd(khBikinkanri.getBkncdkbn().toString());
            khZennouseisankinMeisaiListDataSourceBean.setIrHknsyruilevel(khBikinkanri.getKbnkeirisegcd().getContent());
            khZennouseisankinMeisaiListDataSourceBean.setIrBknkktiymd(bknkktYmd);
            khZennouseisankinMeisaiListDataSourceBean.setIrSyono(khBikinkanri.getSyono());
            khZennouseisankinMeisaiListDataSourceBean.setIrYenseisankin(khBikinkanri.getZennouseisankgk());
            khZennouseisankinMeisaiListDataSourceBean.setIrBknkktinnd(bknkktNnd);
            khZennouseisankinMeisaiListDataSourceBean.setIrBknkktiym(bknkktYm);
            khZennouseisankinMeisaiListDataSourceBean.setIrSeisankinkensuugoukei(null);
            khZennouseisankinMeisaiListDataSourceBean.setIrSeisankingakugoukei(null);
            khZennouseisankinMeisaiListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

            khzennouSeisanKgkMeisaiListDataSourceBeanLst.add(khZennouseisankinMeisaiListDataSourceBean);

            String syoriYmdTemp = DateFormatUtil.dateKANJINoEx(syoriYmd);

            String gaikashrkwsratekjnymd = null;

            if(!C_Tuukasyu.JPY.eq(khBikinkanri.getShrtuukasyu())){

                gaikashrkwsratekjnymd = DateFormatUtil.dateKANJINoEx(khBikinkanri.getGaikashrkwsratekjnymd());

            }

            String shrkwsratekjnymd = DateFormatUtil.dateKANJINoEx(khBikinkanri.getShrkwsratekjnymd());

            String editBeforeKessannnd = DateFormatUtil.dateYKANJISeirekiNendo(khBikinkanri.getKessankijyunymd());

            SetBikinKessanKbn setBikinKessanKbn = SWAKInjector.getInstance(SetBikinKessanKbn.class);

            String yomikaeBknkessanKbn = setBikinKessanKbn.exec(khBikinkanri.getKessankijyunymd()).getContent();

            String kessannnd = editBeforeKessannnd + yomikaeBknkessanKbn;

            KhZennouseisankinMeisaiLstCsvfFile khZennouseisankinMeisaiLstCsvfFile =
                SWAKInjector.getInstance(KhZennouseisankinMeisaiLstCsvfFile.class);

            khZennouseisankinMeisaiLstCsvfFile.setIfcListnm("前納精算金明細リスト（区分経理用）");
            khZennouseisankinMeisaiLstCsvfFile.setIfcAtesaki(tantousituNm);
            khZennouseisankinMeisaiLstCsvfFile.setIfcSakuseiymdseireki(syoriYmdTemp);
            khZennouseisankinMeisaiLstCsvfFile.setIfcPageno(String.valueOf(pageNo));
            khZennouseisankinMeisaiLstCsvfFile.setIfcKessannnd(kessannnd);
            khZennouseisankinMeisaiLstCsvfFile.setIfcSyoricd(khBikinkanri.getBkncdkbn().getValue());
            khZennouseisankinMeisaiLstCsvfFile.setIfcSegcd(khBikinkanri.getKbnkeirisegcd().getValue());
            khZennouseisankinMeisaiLstCsvfFile.setIfcHknsyuruilevel(khBikinkanri.getKbnkeirisegcd().getContent());
            khZennouseisankinMeisaiLstCsvfFile.setIfcBknkktiymdseireki(bknkktYmd);
            khZennouseisankinMeisaiLstCsvfFile.setIfcSyono(khBikinkanri.getSyono());
            khZennouseisankinMeisaiLstCsvfFile.setIfcZennouseisankin(khBikinkanri.getZennouseisankgk().toString());
            khZennouseisankinMeisaiLstCsvfFile.setIfcMissuhyj(null);
            khZennouseisankinMeisaiLstCsvfFile.setIfcBikou(null);
            khZennouseisankinMeisaiLstCsvfFile.setIfcYenkazennouseisankgkbizc(khBikinkanri.getYenkazennouseisankgk());
            khZennouseisankinMeisaiLstCsvfFile.setIfcGaikashrkwsratekjnymd(gaikashrkwsratekjnymd);
            khZennouseisankinMeisaiLstCsvfFile.setIfcGaikashrkwsrate(khBikinkanri.getGaikashrkwsrate());
            khZennouseisankinMeisaiLstCsvfFile.setIfcGaikazennouseisankin(khBikinkanri.getGaikazennouseisankgk().toString());
            khZennouseisankinMeisaiLstCsvfFile.setIfcShrkwsratekjnymdseireki(shrkwsratekjnymd);
            khZennouseisankinMeisaiLstCsvfFile.setIfcShrkwsrate(khBikinkanri.getShrkwsrate());
            khZennouseisankinMeisaiLstCsvfFileLst.add(khZennouseisankinMeisaiLstCsvfFile);
            khBikinKanriinfoOutKns = khBikinKanriinfoOutKns + 1;
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        if (outCount > 0) {
            editZennouseisanMeisaiListBknkktiymSyuukei(bknkktiNngetuSyuukeiBean);
            khzennouSeisanKgkMeisaiListDataSourceBeanLst.add(
                editZennouseisanMeisaiListHknsyuruiSyuukei(String.valueOf(bkncdKey), hknsyuruiKey,
                    String.valueOf(bknkktiNndKey), hknsyuruiSyuukeiBean));
            khzennouSeisanKgkMeisaiListDataSourceBeanLst.add(
                editZennouseisanMeisaiListBknkktiNndSyuukei(String.valueOf(bkncdKey), String.valueOf(bknkktiNndKey), bknkktiNndSyuukeiBean));

        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }

    class ZennouseisanMeisaiListSyuukeiBean {

        private BizNumber seisankinKensuuGoukei;

        private BizCurrency seisankgkGoukei;

        public ZennouseisanMeisaiListSyuukeiBean() {

            seisankinKensuuGoukei = BizNumber.valueOf(0);

            seisankgkGoukei = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        }

        public BizNumber getSeisankinKensuuGoukei() {
            return seisankinKensuuGoukei;
        }

        public void setSeisankinKensuuGoukei(BizNumber pSeisankinKensuuGoukei) {
            seisankinKensuuGoukei = pSeisankinKensuuGoukei;
        }

        public BizCurrency getSeisankgkGoukei() {
            return seisankgkGoukei;
        }

        public void setSeisankgkGoukei(BizCurrency pSeisankgkGoukei) {
            seisankgkGoukei = pSeisankgkGoukei;
        }
    }

}

