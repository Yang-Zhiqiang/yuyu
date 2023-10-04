package yuyu.batch.hozen.khkessan.khmikeikaplistsks;

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
import yuyu.batch.hozen.khkessan.khmikeikaplistsks.dba.KhMikeikaPListSksDao;
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
import yuyu.def.hozen.bean.report.KhMikeikapHenkinListBean;
import yuyu.def.hozen.bean.report.KhMikeikapHenkinListDataSourceBean;
import yuyu.def.hozen.file.csv.KhMikeikapHenkinLstCsvfFile;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 決算 未経過Ｐ返金リスト作成
 */
public class KhMikeikaPListSksBatch implements Batch {

    private static final String TABLE_ID = IT_KhBikinkanri.TABLE_NAME;

    private static final String RECOVERY_FILTER_ID = "Bz001";

    private static final String LISTNM = "未経過Ｐ返金リスト（区分経理用）";

    private String kakutyoujobCd;

    private BizDate syoriYmd;

    private String tantousituNm = null;

    private List<IReportDataSouceBean> khMikeikapHenkinListDsBeanLst;

    private List<KhMikeikapHenkinLstCsvfFile> khMikeikapHenkinLstCsvfFileLst;

    private long khBikinKanriinfoOutKns = 0;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhMikeikaPListSksBatchParam khMikeikaPListSksBatchParam;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private KhMikeikaPListSksDao khMikeikaPListSksDao;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {

        return khMikeikaPListSksBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate kessanYmd = khMikeikaPListSksBatchParam.getKessanYmd();
        kakutyoujobCd = khMikeikaPListSksBatchParam.getIbKakutyoujobcd();
        syoriYmd = khMikeikaPListSksBatchParam.getSyoriYmd();
        khMikeikapHenkinListDsBeanLst = new ArrayList<>();
        khMikeikapHenkinLstCsvfFileLst = new ArrayList<>();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        String tyouhyouSakuseiYmd = DateFormatUtil.dateKANJINoEx(syoriYmd);

        String kessannnd = DateFormatUtil.dateYKANJISeirekiNendo(kessanYmd);

        SetBikinKessanKbn setBikinKessanKbn = SWAKInjector.getInstance(SetBikinKessanKbn.class);
        C_Bknkessankbn bknkessankbn = setBikinKessanKbn.exec(kessanYmd);

        List<IReportDataSouceBean> khMikeikapHenkinListDsBeanGengkLst = new ArrayList<IReportDataSouceBean>();
        List<IReportDataSouceBean> khMikeikapHenkinListDsBeanKaiyakuLst = new ArrayList<IReportDataSouceBean>();
        List<KhMikeikapHenkinLstCsvfFile> khMikeikapHenkinLstCsvfFileGengkLst =
            new ArrayList<KhMikeikapHenkinLstCsvfFile>();
        List<KhMikeikapHenkinLstCsvfFile> khMikeikapHenkinLstCsvfFileKaiyakuLst =
            new ArrayList<KhMikeikapHenkinLstCsvfFile>();

        ReportServicesBean reportServicesBeanGengk = null;
        ReportServicesBean reportServicesBeanKaiyaku = null;

        KhMikeikapHenkinListBean khMikeikapHenkinListBeanGengk = null;
        KhMikeikapHenkinListBean khMikeikapHenkinListBeanKaiyaku = null;

        long khBikinKanriinfoOutKnsGengk = 0;
        long khBikinKanriinfoOutKnsKaiyaku = 0;

        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

        try (ExDBResults<IT_KhBikinkanri> khBikinkanriGengkLst = khMikeikaPListSksDao.
            getKhBikinkanrisByKakutyoujobcdKessankijyunymdBkncdkbnBknrigikbnMikeikap(
                kakutyoujobCd, kessanYmd, C_BkncdKbn.GENGK)) {

            reportServicesBeanGengk = createReport.createNewReportServiceBean(
                kinou.getSubSystemId(),
                kinou.getCategoryId(),
                kinou.getKinouId(),
                C_SyoruiCdKbn.KK_MKKPHENKINLIST_GENGAKU);

            String busituCd = bizDomManager.getTantouCd(C_TantouCdKbn.KEIYAKUHENKOU).getBusitucd();

            BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

            BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(busituCd + "0000");

            if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())){

                tantousituNm = bzGetSosikiDataBean.getKanjisosikinm20();

            }

            String hozonKkn = ViewReport.getHozonKknTani(C_SyoruiCdKbn.KK_MKKPHENKINLIST_GENGAKU);

            khMikeikapHenkinListBeanGengk = SWAKInjector.getInstance(KhMikeikapHenkinListBean.class);
            khMikeikapHenkinListBeanGengk.setIrTantsitunmkj(tantousituNm);
            khMikeikapHenkinListBeanGengk.setIrKessannnd(kessannnd);
            khMikeikapHenkinListBeanGengk.setIrBknkessankbn(bknkessankbn);
            khMikeikapHenkinListBeanGengk.setIrTyouhyousakuseiymd(tyouhyouSakuseiYmd);
            khMikeikapHenkinListBeanGengk.setIrHozonkkn(hozonKkn);

            editMikeikaPListDetailLine(khBikinkanriGengkLst);

            khMikeikapHenkinListDsBeanGengkLst = khMikeikapHenkinListDsBeanLst;
            khMikeikapHenkinLstCsvfFileGengkLst = khMikeikapHenkinLstCsvfFileLst;
            khBikinKanriinfoOutKnsGengk = khBikinKanriinfoOutKns;
        }

        try (ExDBResults<IT_KhBikinkanri> khBikinkanriKaiyakuLst = khMikeikaPListSksDao.
            getKhBikinkanrisByKakutyoujobcdKessankijyunymdBkncdkbnBknrigikbnMikeikap(
                kakutyoujobCd, kessanYmd, C_BkncdKbn.KAIYAKU)) {

            reportServicesBeanKaiyaku = createReport.createNewReportServiceBean(
                kinou.getSubSystemId(),
                kinou.getCategoryId(),
                kinou.getKinouId(),
                C_SyoruiCdKbn.KK_MKKPHENKINLIST_KAIYAKU);

            String busituCd = bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU).getBusitucd();

            BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

            BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(busituCd + "0000");

            tantousituNm = null;

            if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())){

                tantousituNm = bzGetSosikiDataBean.getKanjisosikinm20();

            }

            String hozonKkn = ViewReport.getHozonKknTani(C_SyoruiCdKbn.KK_MKKPHENKINLIST_KAIYAKU);

            khMikeikapHenkinListBeanKaiyaku = SWAKInjector.getInstance(KhMikeikapHenkinListBean.class);
            khMikeikapHenkinListBeanKaiyaku.setIrTantsitunmkj(tantousituNm);
            khMikeikapHenkinListBeanKaiyaku.setIrKessannnd(kessannnd);
            khMikeikapHenkinListBeanKaiyaku.setIrBknkessankbn(bknkessankbn);
            khMikeikapHenkinListBeanKaiyaku.setIrTyouhyousakuseiymd(tyouhyouSakuseiYmd);
            khMikeikapHenkinListBeanKaiyaku.setIrHozonkkn(hozonKkn);

            editMikeikaPListDetailLine(khBikinkanriKaiyakuLst);

            khMikeikapHenkinListDsBeanKaiyakuLst = khMikeikapHenkinListDsBeanLst;
            khMikeikapHenkinLstCsvfFileKaiyakuLst = khMikeikapHenkinLstCsvfFileLst;
            khBikinKanriinfoOutKnsKaiyaku = khBikinKanriinfoOutKns;
        }

        reportServicesBeanGengk.addParamObjects(khMikeikapHenkinListDsBeanGengkLst, khMikeikapHenkinListBeanGengk);
        reportServicesBeanGengk.setSyoriYmd(syoriYmd);
        createReport.execNoCommit(reportServicesBeanGengk);

        reportServicesBeanKaiyaku.addParamObjects(khMikeikapHenkinListDsBeanKaiyakuLst, khMikeikapHenkinListBeanKaiyaku);
        reportServicesBeanKaiyaku.setSyoriYmd(syoriYmd);
        createReport.execNoCommit(reportServicesBeanKaiyaku);

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        C_ErrorKbn errorKbn1 = bzFileUploadUtil.exec(
            C_FileSyuruiCdKbn.KH_MIKEIKAPHENKINLSTCSVFGENGAKU,
            khMikeikapHenkinLstCsvfFileGengkLst,
            true);

        if (C_ErrorKbn.ERROR.eq(errorKbn1)) {
            throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
        }

        C_ErrorKbn errorKbn2 = bzFileUploadUtil.exec(
            C_FileSyuruiCdKbn.KH_MIKEIKAPHENKINLSTCSVFKAIYAKU,
            khMikeikapHenkinLstCsvfFileKaiyakuLst,
            true);

        if (C_ErrorKbn.ERROR.eq(errorKbn2)) {
            throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
        }

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(khBikinKanriinfoOutKnsGengk), "<<未経過Ｐ返金リスト作成（減額分）>>"));

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(khBikinKanriinfoOutKnsKaiyaku), "<<未経過Ｐ返金リスト作成（解約分）>>"));

    }

    private void editMikeikaPListBknKktiYmSyuukei(KhMikeikaPListSksBean pKhMikeikaPListSksBean) {

        KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListDsBean = (KhMikeikapHenkinListDataSourceBean)
            khMikeikapHenkinListDsBeanLst.get(khMikeikapHenkinListDsBeanLst.size() - 1);

        khMikeikapHenkinListDsBean.setIrHenkinkensuugoukei(pKhMikeikaPListSksBean.getHenkinKensuuGoukei());
        khMikeikapHenkinListDsBean.setIrHenkingakugoukei(pKhMikeikaPListSksBean.getHenkinGakuGoukei());
        khMikeikapHenkinListDsBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
    }

    private KhMikeikapHenkinListDataSourceBean editMikeikaPListBknKktiNndSyuukei(C_BkncdKbn pBkncdKbn,
        BizDateY pBknKktiNnd, KhMikeikaPListSksBean pKhMikeikaPListSksBean) {

        KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListDsBean = SWAKInjector.
            getInstance(KhMikeikapHenkinListDataSourceBean.class);

        khMikeikapHenkinListDsBean.setIrBkncd(pBkncdKbn.getValue());
        khMikeikapHenkinListDsBean.setIrHknsyruilevel("");
        khMikeikapHenkinListDsBean.setIrMikeikapkktiymd("");
        khMikeikapHenkinListDsBean.setIrSyono("");
        khMikeikapHenkinListDsBean.setIrMikeikap(BizCurrency.valueOf(0));
        khMikeikapHenkinListDsBean.setIrMikeikapkktinnd(DateFormatUtil.dateYKANJISeireki(pBknKktiNnd).concat("度"));
        khMikeikapHenkinListDsBean.setIrMikeikapkktiym("");
        khMikeikapHenkinListDsBean.setIrHenkinkensuugoukei(pKhMikeikaPListSksBean.getHenkinKensuuGoukei());
        khMikeikapHenkinListDsBean.setIrHenkingakugoukei(pKhMikeikaPListSksBean.getHenkinGakuGoukei());
        khMikeikapHenkinListDsBean.setIrGoukeiumukbn(C_UmuKbn.ARI);

        return khMikeikapHenkinListDsBean;
    }

    private KhMikeikapHenkinListDataSourceBean editMikeikaPListHknSyuruiSyuukei(C_BkncdKbn pBkncdKbn,
        C_Segcd pHknsyurui, BizDateY pBknKktiNnd, KhMikeikaPListSksBean pKhMikeikaPListSksBean) {

        KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListDsBean = SWAKInjector.
            getInstance(KhMikeikapHenkinListDataSourceBean.class);

        khMikeikapHenkinListDsBean.setIrBkncd(pBkncdKbn.getValue());
        khMikeikapHenkinListDsBean.setIrHknsyruilevel(pHknsyurui.getContent());
        khMikeikapHenkinListDsBean.setIrMikeikapkktiymd("");
        khMikeikapHenkinListDsBean.setIrSyono("");
        khMikeikapHenkinListDsBean.setIrMikeikap(BizCurrency.valueOf(0));
        khMikeikapHenkinListDsBean.setIrMikeikapkktinnd(DateFormatUtil.dateYKANJISeireki(pBknKktiNnd).concat("度"));
        khMikeikapHenkinListDsBean.setIrMikeikapkktiym("");
        khMikeikapHenkinListDsBean.setIrHenkinkensuugoukei(pKhMikeikaPListSksBean.getHenkinKensuuGoukei());
        khMikeikapHenkinListDsBean.setIrHenkingakugoukei(pKhMikeikaPListSksBean.getHenkinGakuGoukei());
        khMikeikapHenkinListDsBean.setIrGoukeiumukbn(C_UmuKbn.ARI);

        return khMikeikapHenkinListDsBean;
    }

    private void editMikeikaPListDetailLine(ExDBResults<IT_KhBikinkanri> pKhBikinkanriList) {

        long outKensuu = 0;
        int pageNo = 1;
        int itiPageCount = 0;
        String bknKktiYmKey = null;
        BizDateY bknKktiNndKey = null;
        C_Segcd hknSyuruiKey = null;
        C_BkncdKbn bknCdKey = null;
        khBikinKanriinfoOutKns = 0;
        khMikeikapHenkinListDsBeanLst = new ArrayList<>();
        khMikeikapHenkinLstCsvfFileLst = new ArrayList<>();

        KhMikeikaPListSksBean bknKktiYmSyuukeiBean = new KhMikeikaPListSksBean();
        KhMikeikaPListSksBean bknKktiNndSyuukeiBean = new KhMikeikaPListSksBean();
        KhMikeikaPListSksBean hknSyuruiSyuukeiBean = new KhMikeikaPListSksBean();

        for (IT_KhBikinkanri khBikinkanri : pKhBikinkanriList) {

            bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);

            bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);

            bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_ID);

            bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khBikinkanri.getSyono());

            String bknkktYmd = DateFormatUtil.dateKANJINoEx(khBikinkanri.getBknkktymd());

            SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);
            BizDate kessanNensibi = setKessanNensibi.exec(khBikinkanri.getBknkktymd());
            BizDateY kessanNensiY = kessanNensibi.getBizDateY();
            String bknkktiNnd = DateFormatUtil.dateYKANJISeireki(kessanNensibi.getBizDateY()).concat("度");

            String bknkktYm = DateFormatUtil.dateYmKANJINoEx(khBikinkanri.getBknkktymd().getBizDateYM());

            if (outKensuu == 0) {
                bknKktiYmKey = bknkktYm;
                bknKktiNndKey = kessanNensiY;
                hknSyuruiKey = khBikinkanri.getKbnkeirisegcd();
                bknCdKey = khBikinkanri.getBkncdkbn();
            }
            else {
                if (!bknKktiYmKey.equals(bknkktYm) || !hknSyuruiKey.eq(khBikinkanri.getKbnkeirisegcd())) {

                    editMikeikaPListBknKktiYmSyuukei(bknKktiYmSyuukeiBean);

                    bknKktiYmKey = bknkktYm;

                    pageNo = pageNo + 1;

                    itiPageCount = 0;

                    bknKktiYmSyuukeiBean = new KhMikeikaPListSksBean();
                }

                if (!hknSyuruiKey.eq(khBikinkanri.getKbnkeirisegcd())) {

                    KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListDsBean =
                        editMikeikaPListHknSyuruiSyuukei(bknCdKey, hknSyuruiKey, bknKktiNndKey, hknSyuruiSyuukeiBean);

                    khMikeikapHenkinListDsBeanLst.add(khMikeikapHenkinListDsBean);

                    hknSyuruiKey = khBikinkanri.getKbnkeirisegcd();

                    pageNo = pageNo + 1;

                    itiPageCount = 0;

                    hknSyuruiSyuukeiBean = new KhMikeikaPListSksBean();
                }

                if (itiPageCount == 34) {

                    pageNo = pageNo + 1;

                    itiPageCount = 0;
                }
            }

            outKensuu = outKensuu + 1;
            itiPageCount = itiPageCount + 1;

            bknKktiYmSyuukeiBean.setHenkinKensuuGoukei(bknKktiYmSyuukeiBean.getHenkinKensuuGoukei().add(
                BizNumber.valueOf(1)));
            bknKktiYmSyuukeiBean.setHenkinGakuGoukei(bknKktiYmSyuukeiBean.getHenkinGakuGoukei().add(
                khBikinkanri.getMikeikap()));

            bknKktiNndSyuukeiBean.setHenkinKensuuGoukei(bknKktiNndSyuukeiBean.getHenkinKensuuGoukei().add(
                BizNumber.valueOf(1)));
            bknKktiNndSyuukeiBean.setHenkinGakuGoukei(bknKktiNndSyuukeiBean.getHenkinGakuGoukei().add(
                khBikinkanri.getMikeikap()));

            hknSyuruiSyuukeiBean.setHenkinKensuuGoukei(hknSyuruiSyuukeiBean.getHenkinKensuuGoukei().add(
                BizNumber.valueOf(1)));
            hknSyuruiSyuukeiBean.setHenkinGakuGoukei(hknSyuruiSyuukeiBean.getHenkinGakuGoukei().add(
                khBikinkanri.getMikeikap()));

            KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListDsBean = SWAKInjector.
                getInstance(KhMikeikapHenkinListDataSourceBean.class);

            khMikeikapHenkinListDsBean.setIrBkncd(khBikinkanri.getBkncdkbn().getValue());
            khMikeikapHenkinListDsBean.setIrHknsyruilevel(khBikinkanri.getKbnkeirisegcd().getContent());
            khMikeikapHenkinListDsBean.setIrMikeikapkktiymd(bknkktYmd);
            khMikeikapHenkinListDsBean.setIrSyono(khBikinkanri.getSyono());
            khMikeikapHenkinListDsBean.setIrMikeikap(khBikinkanri.getMikeikap());
            khMikeikapHenkinListDsBean.setIrMikeikapkktinnd(bknkktiNnd);
            khMikeikapHenkinListDsBean.setIrMikeikapkktiym(bknkktYm);
            khMikeikapHenkinListDsBean.setIrHenkinkensuugoukei(null);
            khMikeikapHenkinListDsBean.setIrHenkingakugoukei(null);
            khMikeikapHenkinListDsBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

            khMikeikapHenkinListDsBeanLst.add(khMikeikapHenkinListDsBean);

            String hnsyuMaeKessanNnd = DateFormatUtil.dateYKANJISeirekiNendo(khBikinkanri.getKessankijyunymd());

            SetBikinKessanKbn setBikinKessanKbn = SWAKInjector.getInstance(SetBikinKessanKbn.class);
            C_Bknkessankbn yomikaeBknKessanKbn = setBikinKessanKbn.exec(khBikinkanri.getKessankijyunymd());

            String kessannnd = hnsyuMaeKessanNnd + yomikaeBknKessanKbn.getContent();

            String gaikashrkwsratekjnymd = null;

            if(!C_Tuukasyu.JPY.eq(khBikinkanri.getShrtuukasyu())){

                gaikashrkwsratekjnymd = DateFormatUtil.dateKANJINoEx(khBikinkanri.getGaikashrkwsratekjnymd());

            }

            String shrkwsratekjnymd = DateFormatUtil.dateKANJINoEx(khBikinkanri.getShrkwsratekjnymd());

            KhMikeikapHenkinLstCsvfFile khMikeikapHenkinLstCsvfFile = SWAKInjector.getInstance(
                KhMikeikapHenkinLstCsvfFile.class);

            khMikeikapHenkinLstCsvfFile.setIfcListnm(LISTNM);
            khMikeikapHenkinLstCsvfFile.setIfcAtesaki(tantousituNm);
            khMikeikapHenkinLstCsvfFile.setIfcSakuseiymdseireki(DateFormatUtil.dateKANJINoEx(syoriYmd));
            khMikeikapHenkinLstCsvfFile.setIfcPageno(String.valueOf(pageNo));
            khMikeikapHenkinLstCsvfFile.setIfcKessannnd(kessannnd);
            khMikeikapHenkinLstCsvfFile.setIfcSyoricd(khBikinkanri.getBkncdkbn().getValue());
            khMikeikapHenkinLstCsvfFile.setIfcSegcd(khBikinkanri.getKbnkeirisegcd().getValue());
            khMikeikapHenkinLstCsvfFile.setIfcHknsyuruilevel(khBikinkanri.getKbnkeirisegcd().getContent());
            khMikeikapHenkinLstCsvfFile.setIfcMikeikapkktiymd(bknkktYmd);
            khMikeikapHenkinLstCsvfFile.setIfcMikeikapkktinnd(bknkktiNnd);
            khMikeikapHenkinLstCsvfFile.setIfcMikeikapkktiym(bknkktYm);
            khMikeikapHenkinLstCsvfFile.setIfcSyono(khBikinkanri.getSyono());
            khMikeikapHenkinLstCsvfFile.setIfcMikeikap(khBikinkanri.getMikeikap().toString());
            khMikeikapHenkinLstCsvfFile.setIfcMissuhyj(null);
            khMikeikapHenkinLstCsvfFile.setIfcYenkamikeikapbizc(khBikinkanri.getYenkamikeikap());
            khMikeikapHenkinLstCsvfFile.setIfcGaikashrkwsratekjnymd(gaikashrkwsratekjnymd);
            khMikeikapHenkinLstCsvfFile.setIfcGaikashrkwsrate(khBikinkanri.getGaikashrkwsrate());
            khMikeikapHenkinLstCsvfFile.setIfcGaikamikeikap(khBikinkanri.getGaikamikeikap().toString());
            khMikeikapHenkinLstCsvfFile.setIfcShrkwsratekjnymdseireki(shrkwsratekjnymd);
            khMikeikapHenkinLstCsvfFile.setIfcShrkwsrate(khBikinkanri.getShrkwsrate());

            khMikeikapHenkinLstCsvfFileLst.add(khMikeikapHenkinLstCsvfFile);

            khBikinKanriinfoOutKns = khBikinKanriinfoOutKns + 1;
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        if (outKensuu > 0) {
            editMikeikaPListBknKktiYmSyuukei(bknKktiYmSyuukeiBean);

            KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListHknSyuruiDsBean =
                editMikeikaPListHknSyuruiSyuukei(bknCdKey, hknSyuruiKey, bknKktiNndKey, hknSyuruiSyuukeiBean);

            khMikeikapHenkinListDsBeanLst.add(khMikeikapHenkinListHknSyuruiDsBean);

            KhMikeikapHenkinListDataSourceBean khMikeikapHenkinListBknKktiNndDsBean =
                editMikeikaPListBknKktiNndSyuukei(bknCdKey, bknKktiNndKey, bknKktiNndSyuukeiBean);

            khMikeikapHenkinListDsBeanLst.add(khMikeikapHenkinListBknKktiNndDsBean);
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }

    class KhMikeikaPListSksBean {

        private BizNumber henkinKensuuGoukei;

        private BizCurrency henkinGakuGoukei;

        public KhMikeikaPListSksBean() {

            henkinKensuuGoukei = BizNumber.valueOf(0);

            henkinGakuGoukei = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        }

        public BizNumber getHenkinKensuuGoukei() {
            return henkinKensuuGoukei;
        }

        public void setHenkinKensuuGoukei(BizNumber pHenkinKensuuGoukei) {
            henkinKensuuGoukei = pHenkinKensuuGoukei;
        }

        public BizCurrency getHenkinGakuGoukei() {
            return henkinGakuGoukei;
        }

        public void setHenkinGakuGoukei(BizCurrency pHenkinGakuGoukei) {
            henkinGakuGoukei = pHenkinGakuGoukei;
        }
    }
}
