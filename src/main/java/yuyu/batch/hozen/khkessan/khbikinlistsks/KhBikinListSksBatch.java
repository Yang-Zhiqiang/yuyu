package yuyu.batch.hozen.khkessan.khbikinlistsks;

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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
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
import yuyu.def.hozen.bean.report.KhKhBikinListBean;
import yuyu.def.hozen.bean.report.KhKhBikinListDataSourceBean;
import yuyu.def.hozen.file.csv.KhBikinSgyLstCsvfGengakuFile;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 決算 契約保全備金リスト作成（減額）
 */
public class KhBikinListSksBatch implements Batch {

    private final String RECOVERY_FILTER_ID  = "Bz001";

    private final String TABLE_ID = "IT_KhBikinkanri";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private KhBikinListSksBatchParam khBikinListSksBatchParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private BizDomManager bizDomManager;


    @Override
    public BatchParam getParam() {
        return khBikinListSksBatchParam;
    }

    @Execute
    @Transactional
    public void Execute(){

        BizDate syoriYmd = khBikinListSksBatchParam.getSyoriYmd();

        BizDate ksnbiYmd = khBikinListSksBatchParam.getKessanYmd();

        String kakutyoujobCd = khBikinListSksBatchParam.getIbKakutyoujobcd();

        List<KhBikinSgyLstCsvfGengakuFile> khBikinSgyLstCsvfGengakuFileList =
            new ArrayList<KhBikinSgyLstCsvfGengakuFile>();

        List<IReportDataSouceBean> khKhBikinListDataSourceBeanList = new ArrayList<>();

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, "<<バッチ処理年月日>>", syoriYmd.toString()));

        try (ExDBResults<IT_KhBikinkanri> khBikinkanriList = hozenDomManager.
            getKhBikinkanrisByKakutyoujobcdKessankijyunymdBkncdkbnBknrigikbn(kakutyoujobCd, ksnbiYmd)) {

            CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                kinou.getSubSystemId(), kinou.getCategoryId(), kinou.getKinouId(), C_SyoruiCdKbn.KK_KH_BIKINLIST);

            String tyouhyouSakuseiYmd = DateFormatUtil.dateKANJINoEx(syoriYmd);

            String busituCd =bizDomManager.getTantouCd(C_TantouCdKbn.KEIYAKUHENKOU).getBusitucd();

            BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

            String busituNm = "";

            BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(busituCd + "0000");

            if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())){

                busituNm = bzGetSosikiDataBean.getKanjisosikinm20();

            }

            SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);

            BizDate kessanNensiYmd = setKessanNensibi.exec(ksnbiYmd);

            String kessanNendo = DateFormatUtil.dateYKANJISeireki(kessanNensiYmd.getBizDateY()).concat("度");

            C_Bknkessankbn bknkessanKbn = C_Bknkessankbn.BLNK;

            if (ksnbiYmd.getMonth() == 3) {

                bknkessanKbn = C_Bknkessankbn.KESSAN;
            }
            else if (ksnbiYmd.getMonth() == 6) {

                bknkessanKbn = C_Bknkessankbn.SHNK;

            }
            else if (ksnbiYmd.getMonth() == 9) {

                bknkessanKbn = C_Bknkessankbn.HNK;

            }
            else if (ksnbiYmd.getMonth() == 12) {

                bknkessanKbn = C_Bknkessankbn.SHNK;

            }

            String hozonKkn = ViewReport.getHozonKknTani(C_SyoruiCdKbn.KK_KH_BIKINLIST);

            KhKhBikinListBean khKhBikinListBean = SWAKInjector.getInstance(KhKhBikinListBean.class);

            khKhBikinListBean.setIrTantsitunmkj(busituNm);

            khKhBikinListBean.setIrKessannnd(kessanNendo);

            khKhBikinListBean.setIrBknkessankbn(bknkessanKbn);

            khKhBikinListBean.setIrTyouhyousakuseiymdwareki(tyouhyouSakuseiYmd);

            khKhBikinListBean.setIrHozonkkn(hozonKkn);

            long outKensuu = 0;

            int pageNo = 1;

            int  pageCount  = 0;

            BizDateYM bknkktiYmKey = null;

            BizDateY bknkktiNndKey = null;

            C_Segcd hknsyruiKey = null;

            C_BkncdKbn bkncdKey = null;

            KhKhBikinBean khBikinListSksYM = new KhKhBikinBean();

            KhKhBikinBean khBikinListSksY = new KhKhBikinBean();

            KhKhBikinBean khBikinListSksBX = new KhKhBikinBean();

            for (IT_KhBikinkanri khBikinkanri : khBikinkanriList) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);

                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_ID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khBikinkanri.getSyono());

                String bknkktYmd = DateFormatUtil.dateKANJINoEx(khBikinkanri.getBknkktymd());

                kessanNensiYmd = setKessanNensibi.exec(khBikinkanri.getBknkktymd());

                String bknkktiNnd = DateFormatUtil.dateYKANJISeireki(kessanNensiYmd.getBizDateY()).concat("度");

                BizDateY jbknkktiNnd = kessanNensiYmd.getBizDateY();

                String bknkktiYm = DateFormatUtil.dateYmKANJINoEx(BizDate.valueOf(bknkktYmd).getBizDateYM());

                if (outKensuu == 0) {

                    bknkktiYmKey = khBikinkanri.getBknkktymd().getBizDateYM();

                    bknkktiNndKey = jbknkktiNnd;

                    hknsyruiKey = khBikinkanri.getKbnkeirisegcd();

                    bkncdKey = khBikinkanri.getBkncdkbn();

                }

                else  {

                    boolean flag = false;

                    if (BizDateUtil.compareYm(bknkktiYmKey, khBikinkanri.getBknkktymd().getBizDateYM()) !=
                        BizDateUtil.COMPARE_EQUAL || !(khBikinkanri.getKbnkeirisegcd().eq(hknsyruiKey))){

                        editKhBikinListYM(khBikinListSksYM, khKhBikinListDataSourceBeanList);
                        bknkktiYmKey = khBikinkanri.getBknkktymd().getBizDateYM();

                        pageNo = pageNo + 1;

                        pageCount = 0;

                        khBikinListSksYM = new KhKhBikinBean();

                        flag = true;
                    }

                    if (!(khBikinkanri.getKbnkeirisegcd().eq(hknsyruiKey))) {

                        KhKhBikinListDataSourceBean khBikinListDataSourceBean = editKhBikinListInsurance(
                            bkncdKey, hknsyruiKey, bknkktiNndKey ,khBikinListSksBX);

                        khKhBikinListDataSourceBeanList.add(khBikinListDataSourceBean);

                        hknsyruiKey = khBikinkanri.getKbnkeirisegcd();

                        pageNo = pageNo + 1;

                        pageCount = 0;

                        khBikinListSksBX = new KhKhBikinBean();

                        flag = true;
                    }

                    if(!flag){

                        if (pageCount == 30) {

                            pageNo = pageNo + 1;

                            pageCount = 0;
                        }
                    }
                }

                outKensuu = outKensuu + 1;

                pageCount = pageCount + 1;

                khBikinListSksYM.setBikinKensuuGoukei(khBikinListSksYM.getBikinKensuuGoukei().add(BizNumber.valueOf(1)));

                khBikinListSksYM.setBikingakuGoukei(khBikinListSksYM.getBikingakuGoukei().add(khBikinkanri.getBkngk()));

                if (khBikinkanri.getGngkkiykumukbn().eq(C_UmuKbn.ARI)) {
                    khBikinListSksYM.setGengakuTkykkaiyakuKensuu(
                        khBikinListSksYM.getGengakuTkykkaiyakuKensuu().add(BizNumber.valueOf(1)));

                }

                khBikinListSksY.setBikinKensuuGoukei(khBikinListSksY.getBikinKensuuGoukei().add(BizNumber.valueOf(1)));

                khBikinListSksY.setBikingakuGoukei(khBikinListSksY.getBikingakuGoukei().add(khBikinkanri.getBkngk()));

                if (khBikinkanri.getGngkkiykumukbn().eq(C_UmuKbn.ARI)) {
                    khBikinListSksY.setGengakuTkykkaiyakuKensuu(
                        khBikinListSksY.getGengakuTkykkaiyakuKensuu().add(BizNumber.valueOf(1)));
                }

                khBikinListSksBX.setBikinKensuuGoukei(khBikinListSksBX.getBikinKensuuGoukei().add(BizNumber.valueOf(1)));

                khBikinListSksBX.setBikingakuGoukei(khBikinListSksBX.getBikingakuGoukei().add(khBikinkanri.getBkngk()));

                if (khBikinkanri.getGngkkiykumukbn().eq(C_UmuKbn.ARI)) {
                    khBikinListSksBX.setGengakuTkykkaiyakuKensuu(
                        khBikinListSksBX.getGengakuTkykkaiyakuKensuu().add(BizNumber.valueOf(1)));
                }

                KhKhBikinListDataSourceBean khKhBikinListDataSourceBean =
                    SWAKInjector.getInstance(KhKhBikinListDataSourceBean.class);

                khKhBikinListDataSourceBean.setIrBkncd(khBikinkanri.getBkncdkbn().toString());

                khKhBikinListDataSourceBean.setIrBknkktiymdwareki(bknkktYmd);

                khKhBikinListDataSourceBean.setIrSisyacd(khBikinkanri.getSisyacd());

                khKhBikinListDataSourceBean.setIrKigou(khBikinkanri.getSyouhncd().substring(0, 2));

                khKhBikinListDataSourceBean.setIrSyono(khBikinkanri.getSyono());

                khKhBikinListDataSourceBean.setIrBkngk(khBikinkanri.getBkngk());

                khKhBikinListDataSourceBean.setIrTkykfkhnkuumukbn(C_UmuKbn.NONE);

                khKhBikinListDataSourceBean.setIrGngktkykkiykumukbn(khBikinkanri.getGngkkiykumukbn());

                khKhBikinListDataSourceBean.setIrTnjsstmumukbn(C_UmuKbn.NONE);

                khKhBikinListDataSourceBean.setIrKknsrihnkuumukbn(C_UmuKbn.NONE);

                khKhBikinListDataSourceBean.setIrKbnkeirihknsyuruinm(khBikinkanri.getKbnkeirisegcd());

                khKhBikinListDataSourceBean.setIrBknkktinnd(bknkktiNnd);

                khKhBikinListDataSourceBean.setIrBknkktiym(bknkktiYm);

                khKhBikinListDataSourceBean.setIrBikinkensuugoukei(null);

                khKhBikinListDataSourceBean.setIrBikingakugoukei(null);

                khKhBikinListDataSourceBean.setIrTokuyakuhukahenkoukensuu(null);

                khKhBikinListDataSourceBean.setIrGengakutkykkaiyakukensuu(null);

                khKhBikinListDataSourceBean.setIrTyenjisystemkensuu(null);

                khKhBikinListDataSourceBean.setIrKikansyuruihenkoukensuu(null);

                khKhBikinListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);

                khKhBikinListDataSourceBeanList.add(khKhBikinListDataSourceBean);

                String syoriYmdKanji = DateFormatUtil.dateKANJINoEx(syoriYmd);

                kessanNensiYmd = setKessanNensibi.exec(khBikinkanri.getKessankijyunymd());
                String kessanNendoMae = DateFormatUtil.dateYKANJISeireki(kessanNensiYmd.getBizDateY()).concat("度");

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

                kessanNendo = kessanNendoMae + dbknkessanKbn;

                KhBikinSgyLstCsvfGengakuFile khBikinSgyLstCsvfGengakuFile =
                    SWAKInjector.getInstance(KhBikinSgyLstCsvfGengakuFile.class);

                khBikinSgyLstCsvfGengakuFile.setIfcListnm("契約変更備金リスト（区分経理用）解約返戻金");

                khBikinSgyLstCsvfGengakuFile.setIfcAtesaki(busituNm);

                khBikinSgyLstCsvfGengakuFile.setIfcSakuseiymdwareki(syoriYmdKanji);

                khBikinSgyLstCsvfGengakuFile.setIfcPageno(String.valueOf(pageNo));

                khBikinSgyLstCsvfGengakuFile.setIfcKessannnd(kessanNendo);

                khBikinSgyLstCsvfGengakuFile.setIfcBkncd(khBikinkanri.getBkncdkbn().toString());

                khBikinSgyLstCsvfGengakuFile.setIfcHknsyuruinm(khBikinkanri.getKbnkeirisegcd().getContent());

                khBikinSgyLstCsvfGengakuFile.setIfcBknkktiymdwareki(bknkktYmd);

                khBikinSgyLstCsvfGengakuFile.setIfcUktksisya(khBikinkanri.getSisyacd());

                khBikinSgyLstCsvfGengakuFile.setIfcHknsyuruikigou(khBikinkanri.getSyouhncd().substring(0, 2));

                khBikinSgyLstCsvfGengakuFile.setIfcSyono(khBikinkanri.getSyono());

                khBikinSgyLstCsvfGengakuFile.setIfcBkngk(khBikinkanri.getBkngk().toString());

                khBikinSgyLstCsvfGengakuFile.setIfcTkykfkhnku("");

                if (khBikinkanri.getGngkkiykumukbn().eq(C_UmuKbn.ARI)) {
                    khBikinSgyLstCsvfGengakuFile.setIfcGngktkykkiyk("*");
                }

                else if (khBikinkanri.getGngkkiykumukbn().eq(C_UmuKbn.NONE)) {
                    khBikinSgyLstCsvfGengakuFile.setIfcGngktkykkiyk("");
                }

                khBikinSgyLstCsvfGengakuFile.setIfcTnjsstm("");

                khBikinSgyLstCsvfGengakuFile.setIfcKiknsyuhenkou("");

                khBikinSgyLstCsvfGengakuFileList.add(khBikinSgyLstCsvfGengakuFile);

            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            if (outKensuu > 0) {
                editKhBikinListYM(khBikinListSksYM, khKhBikinListDataSourceBeanList);

                KhKhBikinListDataSourceBean khKhBikinListDataSourceBeanI = editKhBikinListInsurance(
                    bkncdKey, hknsyruiKey, bknkktiNndKey ,khBikinListSksBX);

                khKhBikinListDataSourceBeanList.add(khKhBikinListDataSourceBeanI);

                KhKhBikinListDataSourceBean khKhBikinListDataSourceBeanY = editKhBikinListY(
                    bkncdKey, bknkktiNndKey, khBikinListSksY);

                khKhBikinListDataSourceBeanList.add(khKhBikinListDataSourceBeanY);

            }

            reportServicesBean.addParamObjects(khKhBikinListDataSourceBeanList, khKhBikinListBean);
            reportServicesBean.setSyoriYmd(syoriYmd);
            createReport.execNoCommit(reportServicesBean);

            C_ErrorKbn errorKbn = bzFileUploadUtil.exec(
                C_FileSyuruiCdKbn.KH_BIKINSGYLSTCSVFGENGAKU, khBikinSgyLstCsvfGengakuFileList, true);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
            }

            batchLogger.info(MessageUtil.getMessage(
                MessageId.IBF0002, String.valueOf(outKensuu), "<<契約変更備金リスト>>"));

        }
    }

    private void editKhBikinListYM(KhKhBikinBean pKhKhBikinBean,
        List<IReportDataSouceBean> pKhKhBikinListDsbeanList) {

        KhKhBikinListDataSourceBean khBikinListDataSourceBean =
            (KhKhBikinListDataSourceBean)pKhKhBikinListDsbeanList.get(pKhKhBikinListDsbeanList.size() - 1);

        khBikinListDataSourceBean.setIrBikinkensuugoukei(pKhKhBikinBean.getBikinKensuuGoukei());

        khBikinListDataSourceBean.setIrBikingakugoukei(pKhKhBikinBean.getBikingakuGoukei());

        khBikinListDataSourceBean.setIrTokuyakuhukahenkoukensuu(BizNumber.valueOf(0));

        khBikinListDataSourceBean.setIrGengakutkykkaiyakukensuu(pKhKhBikinBean.getGengakuTkykkaiyakuKensuu());

        khBikinListDataSourceBean.setIrTyenjisystemkensuu(BizNumber.valueOf(0));

        khBikinListDataSourceBean.setIrKikansyuruihenkoukensuu(BizNumber.valueOf(0));

        khBikinListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.NONE);
    }

    private KhKhBikinListDataSourceBean editKhBikinListY(C_BkncdKbn pBkncdKbn ,
        BizDateY pBknkktiNnd ,KhKhBikinBean pKhKhBikinBean) {

        KhKhBikinListDataSourceBean khBikinListDataSourceBean = SWAKInjector.getInstance(KhKhBikinListDataSourceBean.class);
        String bknkktiNnd = DateFormatUtil.dateYKANJISeireki(pBknkktiNnd).concat("度");

        khBikinListDataSourceBean.setIrBkncd(pBkncdKbn.toString());

        khBikinListDataSourceBean.setIrBknkktiymdwareki("");

        khBikinListDataSourceBean.setIrSisyacd("");

        khBikinListDataSourceBean.setIrKigou("");

        khBikinListDataSourceBean.setIrSyono("");

        khBikinListDataSourceBean.setIrBkngk(BizCurrency.valueOf(0));

        khBikinListDataSourceBean.setIrTkykfkhnkuumukbn(C_UmuKbn.NONE);

        khBikinListDataSourceBean.setIrGngktkykkiykumukbn(C_UmuKbn.NONE);

        khBikinListDataSourceBean.setIrTnjsstmumukbn(C_UmuKbn.NONE);

        khBikinListDataSourceBean.setIrKknsrihnkuumukbn(C_UmuKbn.NONE);

        khBikinListDataSourceBean.setIrKbnkeirihknsyuruinm(C_Segcd.BLNK);

        khBikinListDataSourceBean.setIrBknkktinnd(bknkktiNnd);

        khBikinListDataSourceBean.setIrBknkktiym("");

        khBikinListDataSourceBean.setIrBikinkensuugoukei(pKhKhBikinBean.getBikinKensuuGoukei());

        khBikinListDataSourceBean.setIrBikingakugoukei(pKhKhBikinBean.getBikingakuGoukei());

        khBikinListDataSourceBean.setIrTokuyakuhukahenkoukensuu(BizNumber.valueOf(0));

        khBikinListDataSourceBean.setIrGengakutkykkaiyakukensuu(pKhKhBikinBean.getGengakuTkykkaiyakuKensuu());

        khBikinListDataSourceBean.setIrTyenjisystemkensuu(BizNumber.valueOf(0));

        khBikinListDataSourceBean.setIrKikansyuruihenkoukensuu(BizNumber.valueOf(0));

        khBikinListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.ARI);

        return khBikinListDataSourceBean;
    }

    private KhKhBikinListDataSourceBean editKhBikinListInsurance(C_BkncdKbn pBkncdKbn,
        C_Segcd pHknsyrui, BizDateY pBknkktiNnd, KhKhBikinBean pKhKhBikinBean) {

        KhKhBikinListDataSourceBean khBikinListDataSourceBean = SWAKInjector.getInstance(KhKhBikinListDataSourceBean.class);

        String bknkktiNnd = DateFormatUtil.dateYKANJISeireki(pBknkktiNnd).concat("度");

        khBikinListDataSourceBean.setIrBkncd(pBkncdKbn.toString());

        khBikinListDataSourceBean.setIrBknkktiymdwareki("");

        khBikinListDataSourceBean.setIrSisyacd("");

        khBikinListDataSourceBean.setIrKigou("");

        khBikinListDataSourceBean.setIrSyono("");

        khBikinListDataSourceBean.setIrBkngk(BizCurrency.valueOf(0));

        khBikinListDataSourceBean.setIrTkykfkhnkuumukbn(C_UmuKbn.NONE);

        khBikinListDataSourceBean.setIrGngktkykkiykumukbn(C_UmuKbn.NONE);

        khBikinListDataSourceBean.setIrTnjsstmumukbn(C_UmuKbn.NONE);

        khBikinListDataSourceBean.setIrKknsrihnkuumukbn(C_UmuKbn.NONE);

        khBikinListDataSourceBean.setIrKbnkeirihknsyuruinm(pHknsyrui);

        khBikinListDataSourceBean.setIrBknkktinnd(bknkktiNnd);

        khBikinListDataSourceBean.setIrBknkktiym("");

        khBikinListDataSourceBean.setIrBikinkensuugoukei(pKhKhBikinBean.getBikinKensuuGoukei());

        khBikinListDataSourceBean.setIrBikingakugoukei(pKhKhBikinBean.getBikingakuGoukei());

        khBikinListDataSourceBean.setIrTokuyakuhukahenkoukensuu(BizNumber.valueOf(0));

        khBikinListDataSourceBean.setIrGengakutkykkaiyakukensuu(pKhKhBikinBean.getGengakuTkykkaiyakuKensuu());

        khBikinListDataSourceBean.setIrTyenjisystemkensuu(BizNumber.valueOf(0));

        khBikinListDataSourceBean.setIrKikansyuruihenkoukensuu(BizNumber.valueOf(0));

        khBikinListDataSourceBean.setIrGoukeiumukbn(C_UmuKbn.ARI);

        return khBikinListDataSourceBean;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate()  {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }

    class KhKhBikinBean{

        public KhKhBikinBean() {

            bikinKensuuGoukei = BizNumber.valueOf(0);

            bikingakuGoukei = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);


            gengakuTkykkaiyakuKensuu = BizNumber.valueOf(0);


        }

        private BizNumber bikinKensuuGoukei;

        public BizNumber getBikinKensuuGoukei() {
            return bikinKensuuGoukei;
        }

        public void setBikinKensuuGoukei(BizNumber pBikinKensuuGoukei) {
            bikinKensuuGoukei = pBikinKensuuGoukei;
        }

        private BizCurrency bikingakuGoukei;

        public BizCurrency getBikingakuGoukei() {
            return bikingakuGoukei;
        }

        public void setBikingakuGoukei(BizCurrency pBikingakuGoukei) {
            bikingakuGoukei = pBikingakuGoukei;
        }

        //private BizNumber tokuyakuHukahenkouKensuu;

        //public BizNumber getTokuyakuHukahenkouKensuu() {
        //    return tokuyakuHukahenkouKensuu;
        //}

        //public void setTokuyakuHukahenkouKensuu(BizNumber pTokuyakuHukahenkouKensuu) {
        //    tokuyakuHukahenkouKensuu = pTokuyakuHukahenkouKensuu;
        //}

        private BizNumber gengakuTkykkaiyakuKensuu;

        public BizNumber getGengakuTkykkaiyakuKensuu() {
            return gengakuTkykkaiyakuKensuu;
        }

        public void setGengakuTkykkaiyakuKensuu(BizNumber pGengakuTkykkaiyakuKensuu) {
            gengakuTkykkaiyakuKensuu = pGengakuTkykkaiyakuKensuu;
        }

        //private BizNumber tyenjiSystemKensuu;

        //public BizNumber getTyenjiSystemKensuu() {
        //    return tyenjiSystemKensuu;
        //}

        //public void setTyenjiSystemKensuu(BizNumber pTyenjiSystemKensuu) {
        //    tyenjiSystemKensuu = pTyenjiSystemKensuu;
        //}

        //private BizNumber kikanSyuruihenkouKensuu;

        //public BizNumber getKikanSyuruihenkouKensuu() {
        //    return kikanSyuruihenkouKensuu;
        //}

        //public void setKikanSyuruihenkouKensuu(BizNumber pKikanSyuruihenkouKensuu) {
        //    kikanSyuruihenkouKensuu = pKikanSyuruihenkouKensuu;
        //}

    }

}