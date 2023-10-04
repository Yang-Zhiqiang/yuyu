package yuyu.batch.hozen.khkessan.khazukarikinbikinlistsks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
import lombok.Getter;
import lombok.Setter;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.hozen.khcommon.SetKessanNensibi;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_AzukarikinBknkessanKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AzukarikinKessankanri;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.bean.report.KhAzukarikinBikinLstBean;
import yuyu.def.hozen.bean.report.KhAzukarikinBikinLstDataSourceBean;
import yuyu.def.hozen.file.csv.KhAzukarikinBikinLstCsvfFile;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 決算 預り金備金リスト作成
 */
public class KhAzukarikinBikinListSksBatch implements Batch {

    private static final String TABLE_ID = IT_AzukarikinKessankanri.TABLE_NAME;

    private static final String RECOVERY_FILTER_ID = "Bz001";

    private static final String LISTNM = "税制適格特約による預り金　備金計上リスト";

    private static final boolean GOUKEI_FLG_ON = true;

    private static final boolean GOUKEI_FLG_OFF = false;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhAzukarikinBikinListSksBatchParam khAzukarikinBikinListSksBatchParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {

        return khAzukarikinBikinListSksBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(khAzukarikinBikinListSksBatchParam.getSyoriYmd())));

        KhAzukarikinBikinLstBean khAzukarikinBikinLstBean = editKhAzukarikinBikinHeadReport(khAzukarikinBikinListSksBatchParam.getKessanYmd());

        Map<String, Map<String, Map<String, List<KhAzukarikinBikinLstDataSourceBean>>>> tyouhyouDsMap =
            new HashMap<String, Map<String, Map<String, List<KhAzukarikinBikinLstDataSourceBean>>>>();
        Map<String, Map<String, Map<String, KhAzukarikinBikinListSksNaibuBean>>> tyouhyouSyuukeiMap =
            new HashMap<String, Map<String, Map<String, KhAzukarikinBikinListSksNaibuBean>>>();

        Map<String, Map<String, List<KhAzukarikinBikinLstDataSourceBean>>> goukeiTyouhyouDsMap =
            new TreeMap<String, Map<String, List<KhAzukarikinBikinLstDataSourceBean>>>();
        Map<String, Map<String, KhAzukarikinBikinListSksNaibuBean>> goukeiTyouhyouSyuukeiMap =
            new HashMap<String, Map<String, KhAzukarikinBikinListSksNaibuBean>>();

        Map<String,String> gaikaInfoMap = new HashMap<String,String>();

        Map<String, String> kyktuukawaseRate = new HashMap<String, String>();

        List<KhAzukarikinBikinLstCsvfFile> khAzukarikinBikinLstCsvfFileLst = new ArrayList<KhAzukarikinBikinLstCsvfFile>();

        long syoriKensuu = 0;

        try (
            ExDBResults<IT_AzukarikinKessankanri> azukarikinKessankanriLst =
            hozenDomManager.getKhAzukarikinBikinKessankanrisByKakutyoujobcdKessankijyunymd(
                khAzukarikinBikinListSksBatchParam.getIbKakutyoujobcd(), khAzukarikinBikinListSksBatchParam.getKessanYmd())) {

            List<String> syoNoLst = hozenDomManager.getKhAzukarikinBikinYenGaikaTyoufukuSyonosByKessankijyunymd(
                khAzukarikinBikinListSksBatchParam.getKessanYmd());

            for (IT_AzukarikinKessankanri azukarikinKessankanri : azukarikinKessankanriLst) {

                String kbnkeiriSegcd = azukarikinKessankanri.getKbnkeirisegcd().getValue();
                String tuukasyu = azukarikinKessankanri.getTuukasyu().getValue();
                String bknjkuKbn = azukarikinKessankanri.getBknjkukbn().getValue();

                if (!gaikaInfoMap.containsKey(kbnkeiriSegcd)) {
                    IT_KykKihon kykKihon = hozenDomManager.getKykKihon(azukarikinKessankanri.getSyono());

                    List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

                    C_Tuukasyu kyktuukasyu= kykSyouhnList.get(0).getKyktuukasyu();

                    GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

                    getKawaseRate.exec(
                        khAzukarikinBikinListSksBatchParam.getKessanYmd(),
                        C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                        kyktuukasyu,
                        C_Tuukasyu.JPY,
                        C_KawasetekiyoKbn.TTM,
                        C_KawasetsryKbn.JISSEIRATE,
                        C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                        C_YouhiKbn.HUYOU);

                    kyktuukawaseRate.put(kbnkeiriSegcd, getKawaseRate.getKawaserate().toString());

                    gaikaInfoMap.put(kbnkeiriSegcd, kyktuukasyu.toString());
                }

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(khAzukarikinBikinListSksBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(azukarikinKessankanri.getSyono());

                if (!tyouhyouDsMap.containsKey(kbnkeiriSegcd)) {
                    tyouhyouDsMap.put(kbnkeiriSegcd, new TreeMap<String, Map<String, List<KhAzukarikinBikinLstDataSourceBean>>>());
                    tyouhyouSyuukeiMap.put(kbnkeiriSegcd, new HashMap<String, Map<String, KhAzukarikinBikinListSksNaibuBean>>());
                }
                if (!tyouhyouDsMap.get(kbnkeiriSegcd).containsKey(tuukasyu)) {
                    tyouhyouDsMap.get(kbnkeiriSegcd).put(tuukasyu, new HashMap<String, List<KhAzukarikinBikinLstDataSourceBean>>());
                    tyouhyouSyuukeiMap.get(kbnkeiriSegcd).put(tuukasyu, new HashMap<String, KhAzukarikinBikinListSksNaibuBean>());
                }
                if (!tyouhyouDsMap.get(kbnkeiriSegcd).get(tuukasyu).containsKey(bknjkuKbn)) {
                    tyouhyouDsMap.get(kbnkeiriSegcd).get(tuukasyu).put(bknjkuKbn, new ArrayList<KhAzukarikinBikinLstDataSourceBean>());
                    tyouhyouSyuukeiMap.get(kbnkeiriSegcd).get(tuukasyu).put(bknjkuKbn, new KhAzukarikinBikinListSksNaibuBean());
                }

                if (!goukeiTyouhyouDsMap.containsKey(kbnkeiriSegcd)) {
                    goukeiTyouhyouDsMap.put(kbnkeiriSegcd, new LinkedHashMap<String, List<KhAzukarikinBikinLstDataSourceBean>>());
                    goukeiTyouhyouSyuukeiMap.put(kbnkeiriSegcd, new HashMap<String, KhAzukarikinBikinListSksNaibuBean>());
                }
                if (!goukeiTyouhyouDsMap.get(kbnkeiriSegcd).containsKey(bknjkuKbn)) {
                    goukeiTyouhyouDsMap.get(kbnkeiriSegcd).put(bknjkuKbn, new ArrayList<KhAzukarikinBikinLstDataSourceBean>());
                    goukeiTyouhyouSyuukeiMap.get(kbnkeiriSegcd).put(bknjkuKbn, new KhAzukarikinBikinListSksNaibuBean());
                }

                String syoNo;
                long kensuu;
                if (C_Tuukasyu.JPY.eq(azukarikinKessankanri.getTuukasyu()) &&
                    syoNoLst.contains(azukarikinKessankanri.getSyono())) {
                    syoNo = azukarikinKessankanri.getSyono() + "*";
                    kensuu = 0;
                }
                else {
                    syoNo = azukarikinKessankanri.getSyono();
                    kensuu = 1;
                }

                KhAzukarikinBikinLstDataSourceBean khAzukarikinBikinLstDataSourceBean =
                    editKhAzukarikinBikinDsReport(azukarikinKessankanri, syoNo, kyktuukawaseRate.get(kbnkeiriSegcd), GOUKEI_FLG_OFF);
                tyouhyouDsMap.get(kbnkeiriSegcd).get(tuukasyu).get(bknjkuKbn).add(khAzukarikinBikinLstDataSourceBean);

                KhAzukarikinBikinListSksNaibuBean khAzukarikinBikinListSksNaibuBean =
                    tyouhyouSyuukeiMap.get(kbnkeiriSegcd).get(tuukasyu).get(bknjkuKbn);
                khAzukarikinBikinListSksNaibuBean.setGoukei(
                    khAzukarikinBikinListSksNaibuBean.getGoukei().add(azukarikinKessankanri.getAzukariganrikin()));
                khAzukarikinBikinListSksNaibuBean.setKensuu(khAzukarikinBikinListSksNaibuBean.getKensuu() + kensuu);
                khAzukarikinBikinListSksNaibuBean.setHknsyruilevel(khAzukarikinBikinLstDataSourceBean.getIrHknsyruilevel());
                khAzukarikinBikinListSksNaibuBean.setAzukarikintuukasyu(khAzukarikinBikinLstDataSourceBean.getIrAzukarikintuukasyu());
                khAzukarikinBikinListSksNaibuBean.setKawaserate(khAzukarikinBikinLstDataSourceBean.getIrKawaserate());

                KhAzukarikinBikinLstDataSourceBean khAzukarikinBikinLstDataSourceBeanGoukei =
                    editKhAzukarikinBikinDsReport(azukarikinKessankanri, syoNo, kyktuukawaseRate.get(kbnkeiriSegcd), GOUKEI_FLG_ON);
                goukeiTyouhyouDsMap.get(kbnkeiriSegcd).get(bknjkuKbn).add(khAzukarikinBikinLstDataSourceBeanGoukei);

                KhAzukarikinBikinListSksNaibuBean khAzukarikinBikinListSksNaibuBeanGoukei =
                    goukeiTyouhyouSyuukeiMap.get(kbnkeiriSegcd).get(bknjkuKbn);
                khAzukarikinBikinListSksNaibuBeanGoukei.setGoukei(
                    khAzukarikinBikinListSksNaibuBeanGoukei.getGoukei().add(azukarikinKessankanri.getAzukariganrikin()));
                khAzukarikinBikinListSksNaibuBeanGoukei.setKensuu(khAzukarikinBikinListSksNaibuBeanGoukei.getKensuu() + kensuu);
                khAzukarikinBikinListSksNaibuBeanGoukei.setHknsyruilevel(khAzukarikinBikinLstDataSourceBeanGoukei.getIrHknsyruilevel());
                khAzukarikinBikinListSksNaibuBeanGoukei.setAzukarikintuukasyu(khAzukarikinBikinLstDataSourceBeanGoukei.getIrAzukarikintuukasyu());
                khAzukarikinBikinListSksNaibuBeanGoukei.setKawaserate(khAzukarikinBikinLstDataSourceBeanGoukei.getIrKawaserate());

                khAzukarikinBikinLstCsvfFileLst.add(editAzukarikinKessankanriCsvInfo(azukarikinKessankanri, syoNo, kensuu));
                syoriKensuu = syoriKensuu + 1;
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        List<IReportDataSouceBean> khAzukarikinBikinLstDataSourceBeanLst = new ArrayList<>();

        if (syoriKensuu > 0) {

            for (String kbnkeiriSegcd : goukeiTyouhyouDsMap.keySet()) {
                List<KhAzukarikinBikinLstDataSourceBean> yenDsBeanLst = new ArrayList<KhAzukarikinBikinLstDataSourceBean>();
                List<KhAzukarikinBikinLstDataSourceBean> gaikaDsBeanLst = new ArrayList<KhAzukarikinBikinLstDataSourceBean>();
                List<KhAzukarikinBikinLstDataSourceBean> goukeiDsBeanLst = new ArrayList<KhAzukarikinBikinLstDataSourceBean>();

                for (String bknjkuKbn : goukeiTyouhyouDsMap.get(kbnkeiriSegcd).keySet()) {
                    if (tyouhyouDsMap.get(kbnkeiriSegcd).containsKey(C_Tuukasyu.JPY.getValue())) {
                        List<KhAzukarikinBikinLstDataSourceBean> tyouhyouDsBeanLstYen =
                            tyouhyouDsMap.get(kbnkeiriSegcd).get(C_Tuukasyu.JPY.getValue()).get(bknjkuKbn);
                        if (tyouhyouDsBeanLstYen != null) {
                            yenDsBeanLst.addAll(tyouhyouDsBeanLstYen);

                            KhAzukarikinBikinListSksNaibuBean tyouhyouSyuukeiBean =
                                tyouhyouSyuukeiMap.get(kbnkeiriSegcd).get(C_Tuukasyu.JPY.getValue()).get(bknjkuKbn);
                            KhAzukarikinBikinLstDataSourceBean khAzukarikinBikinLstDataSourceBean =
                                editKhAzukarikinBikinDsReportKensuugoukei(tyouhyouSyuukeiBean);
                            yenDsBeanLst.add(khAzukarikinBikinLstDataSourceBean);
                        }
                    }

                    if (tyouhyouDsMap.get(kbnkeiriSegcd).containsKey(gaikaInfoMap.get(kbnkeiriSegcd))) {
                        List<KhAzukarikinBikinLstDataSourceBean> tyouhyouDsBeanLstGai =
                            tyouhyouDsMap.get(kbnkeiriSegcd).get(gaikaInfoMap.get(kbnkeiriSegcd)).get(bknjkuKbn);
                        if (tyouhyouDsBeanLstGai != null) {
                            gaikaDsBeanLst.addAll(tyouhyouDsBeanLstGai);

                            KhAzukarikinBikinListSksNaibuBean tyouhyouSyuukeiBean =
                                tyouhyouSyuukeiMap.get(kbnkeiriSegcd).get(gaikaInfoMap.get(kbnkeiriSegcd)).get(bknjkuKbn);
                            KhAzukarikinBikinLstDataSourceBean khAzukarikinBikinLstDataSourceBean =
                                editKhAzukarikinBikinDsReportKensuugoukei(tyouhyouSyuukeiBean);
                            gaikaDsBeanLst.add(khAzukarikinBikinLstDataSourceBean);
                        }
                    }

                    List<KhAzukarikinBikinLstDataSourceBean> tyouhyouDsBeanLst =
                        goukeiTyouhyouDsMap.get(kbnkeiriSegcd).get(bknjkuKbn);
                    goukeiDsBeanLst.addAll(tyouhyouDsBeanLst);

                    KhAzukarikinBikinListSksNaibuBean tyouhyouSyuukeiBean =
                        goukeiTyouhyouSyuukeiMap.get(kbnkeiriSegcd).get(bknjkuKbn);
                    KhAzukarikinBikinLstDataSourceBean khAzukarikinBikinLstDataSourceBean =
                        editKhAzukarikinBikinDsReportKensuugoukei(tyouhyouSyuukeiBean);
                    goukeiDsBeanLst.add(khAzukarikinBikinLstDataSourceBean);
                }

                if (yenDsBeanLst.size() == 0) {
                    KhAzukarikinBikinListSksNaibuBean tyouhyouSyuukeiBean = new KhAzukarikinBikinListSksNaibuBean();
                    tyouhyouSyuukeiBean.setHknsyruilevel(C_Segcd.valueOf(kbnkeiriSegcd).getContent());
                    tyouhyouSyuukeiBean.setAzukarikintuukasyu("円建分");
                    tyouhyouSyuukeiBean.setKawaserate("");
                    KhAzukarikinBikinLstDataSourceBean khAzukarikinBikinLstDataSourceBean =
                        editKhAzukarikinBikinDsReportKensuugoukei(tyouhyouSyuukeiBean);
                    yenDsBeanLst.add(khAzukarikinBikinLstDataSourceBean);
                }
                khAzukarikinBikinLstDataSourceBeanLst.addAll(yenDsBeanLst);

                if (gaikaDsBeanLst.size() == 0) {
                    KhAzukarikinBikinListSksNaibuBean tyouhyouSyuukeiBean = new KhAzukarikinBikinListSksNaibuBean();
                    tyouhyouSyuukeiBean.setHknsyruilevel(C_Segcd.valueOf(kbnkeiriSegcd).getContent());
                    tyouhyouSyuukeiBean.setAzukarikintuukasyu(C_Tuukasyu.valueOf(gaikaInfoMap.get(kbnkeiriSegcd)).getContent() + "建分");
                    tyouhyouSyuukeiBean.setKawaserate(kyktuukawaseRate.get(kbnkeiriSegcd) + " 円");
                    KhAzukarikinBikinLstDataSourceBean khAzukarikinBikinLstDataSourceBean =
                        editKhAzukarikinBikinDsReportKensuugoukei(tyouhyouSyuukeiBean);
                    gaikaDsBeanLst.add(khAzukarikinBikinLstDataSourceBean);
                }
                khAzukarikinBikinLstDataSourceBeanLst.addAll(gaikaDsBeanLst);

                khAzukarikinBikinLstDataSourceBeanLst.addAll(goukeiDsBeanLst);
            }
        }

        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            C_SyoruiCdKbn.KK_AZUKARIKIN_BIKINLIST);

        reportServicesBean.addParamObjects(khAzukarikinBikinLstDataSourceBeanLst, khAzukarikinBikinLstBean);
        reportServicesBean.setSyoriYmd(BizDate.getSysDate());

        createReport.execNoCommit(reportServicesBean);

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);
        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(
            C_FileSyuruiCdKbn.KH_AZUKARIKINBIKINLSTCSVF,
            khAzukarikinBikinLstCsvfFileLst,
            true);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
        }

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(syoriKensuu), "<<預り金備金リスト作成>>"));

    }

    private KhAzukarikinBikinLstBean editKhAzukarikinBikinHeadReport(BizDate pKessankijyunymd) {

        String tyouhyouYmd = DateFormatUtil.dateKANJINoEx(BizDate.getSysDate());
        SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);
        BizDate kessanNensibi = setKessanNensibi.exec(pKessankijyunymd);
        String kessanNendo = DateFormatUtil.dateYKANJISeireki(kessanNensibi.getBizDateY()) + "度";

        C_AzukarikinBknkessanKbn azukarikinBknkessanKbn = C_AzukarikinBknkessanKbn.BLNK;
        if (pKessankijyunymd.getMonth() == 3) {
            azukarikinBknkessanKbn = C_AzukarikinBknkessanKbn.KESSAN;
        }
        else if (pKessankijyunymd.getMonth() == 6) {
            azukarikinBknkessanKbn = C_AzukarikinBknkessanKbn.DAI1SHNK;
        }
        else if (pKessankijyunymd.getMonth() == 9) {
            azukarikinBknkessanKbn = C_AzukarikinBknkessanKbn.HNK;
        }
        else if (pKessankijyunymd.getMonth() == 12) {
            azukarikinBknkessanKbn = C_AzukarikinBknkessanKbn.DAI3SHNK;
        }

        String hozonKkn = ViewReport.getHozonKknTani(C_SyoruiCdKbn.KK_AZUKARIKIN_BIKINLIST);

        KhAzukarikinBikinLstBean khAzukarikinBikinLstBean = SWAKInjector.
            getInstance(KhAzukarikinBikinLstBean.class);

        khAzukarikinBikinLstBean.setIrTyouhyousakuseiymd(tyouhyouYmd);
        khAzukarikinBikinLstBean.setIrKessannnd(kessanNendo);
        khAzukarikinBikinLstBean.setIrAzukarikinbknkessankbn(azukarikinBknkessanKbn);
        khAzukarikinBikinLstBean.setIrHozonkkn(hozonKkn);

        return khAzukarikinBikinLstBean;
    }

    private KhAzukarikinBikinLstDataSourceBean editKhAzukarikinBikinDsReport(
        IT_AzukarikinKessankanri pAzukarikinKessankanri, String pSyoNo, String pkawaseRate,boolean pGoukeiFlg) {

        String azukariTuukasyu = "";
        if (!pGoukeiFlg) {
            if (!C_Tuukasyu.BLNK.eq(pAzukarikinKessankanri.getTuukasyu())) {
                azukariTuukasyu = pAzukarikinKessankanri.getTuukasyu().getContent() + "建分";
            }
        } else {
            azukariTuukasyu = "合計分";
        }

        String kawaseRate = "";
        if (!C_Tuukasyu.JPY.eq(pAzukarikinKessankanri.getTuukasyu()) || pGoukeiFlg) {
            kawaseRate = pkawaseRate + " 円";
        }

        KhAzukarikinBikinLstDataSourceBean khAzukarikinBikinLstDataSourceBean = SWAKInjector.
            getInstance(KhAzukarikinBikinLstDataSourceBean.class);

        khAzukarikinBikinLstDataSourceBean.setIrHknsyruilevel(pAzukarikinKessankanri.getKbnkeirisegcd().getContent());
        khAzukarikinBikinLstDataSourceBean.setIrAzukarikintuukasyu(azukariTuukasyu);
        khAzukarikinBikinLstDataSourceBean.setIrKawaserate(kawaseRate);
        khAzukarikinBikinLstDataSourceBean.setIrSyono(pSyoNo);
        khAzukarikinBikinLstDataSourceBean.setIrBkncdkbn(pAzukarikinKessankanri.getBkncdkbn());
        khAzukarikinBikinLstDataSourceBean.setIrBikinkeijyouymd(pAzukarikinKessankanri.getBikinkeiymd().toString());
        khAzukarikinBikinLstDataSourceBean.setIrBknjkukbn(pAzukarikinKessankanri.getBknjkukbn());
        khAzukarikinBikinLstDataSourceBean.setIrTounendgankin(
            BizUtil.comma(pAzukarikinKessankanri.getTounendgankin().toString()) + " 円");
        khAzukarikinBikinLstDataSourceBean.setIrTounendrsk(
            BizUtil.comma(pAzukarikinKessankanri.getTounendrsk().toString()) + " 円");
        khAzukarikinBikinLstDataSourceBean.setIrAzukariganrikin(
            BizUtil.comma(pAzukarikinKessankanri.getAzukariganrikin().toString()) + " 円");
        khAzukarikinBikinLstDataSourceBean.setIrAzukarikinhsiymd(pAzukarikinKessankanri.getAzukarikinhsiymd().toString());
        khAzukarikinBikinLstDataSourceBean.setIrAzukarikinbknkensuugoukei(null);
        khAzukarikinBikinLstDataSourceBean.setIrAzukarikinbkngoukei("");

        return khAzukarikinBikinLstDataSourceBean;
    }

    private KhAzukarikinBikinLstDataSourceBean editKhAzukarikinBikinDsReportKensuugoukei(
        KhAzukarikinBikinListSksNaibuBean pKhAzukarikinBikinListSksNaibuBean) {

        KhAzukarikinBikinLstDataSourceBean khAzukarikinBikinLstDataSourceBean = SWAKInjector.
            getInstance(KhAzukarikinBikinLstDataSourceBean.class);

        khAzukarikinBikinLstDataSourceBean.setIrHknsyruilevel(pKhAzukarikinBikinListSksNaibuBean.getHknsyruilevel());
        khAzukarikinBikinLstDataSourceBean.setIrAzukarikintuukasyu(pKhAzukarikinBikinListSksNaibuBean.getAzukarikintuukasyu());
        khAzukarikinBikinLstDataSourceBean.setIrKawaserate(pKhAzukarikinBikinListSksNaibuBean.getKawaserate());
        khAzukarikinBikinLstDataSourceBean.setIrSyono("");
        khAzukarikinBikinLstDataSourceBean.setIrBkncdkbn(null);
        khAzukarikinBikinLstDataSourceBean.setIrBikinkeijyouymd("");
        khAzukarikinBikinLstDataSourceBean.setIrBknjkukbn(null);
        khAzukarikinBikinLstDataSourceBean.setIrTounendgankin("");
        khAzukarikinBikinLstDataSourceBean.setIrTounendrsk("");
        khAzukarikinBikinLstDataSourceBean.setIrAzukariganrikin("");
        khAzukarikinBikinLstDataSourceBean.setIrAzukarikinhsiymd("");
        khAzukarikinBikinLstDataSourceBean.setIrAzukarikinbknkensuugoukei(BizNumber.valueOf(pKhAzukarikinBikinListSksNaibuBean.getKensuu()));
        khAzukarikinBikinLstDataSourceBean.setIrAzukarikinbkngoukei(BizUtil.comma(pKhAzukarikinBikinListSksNaibuBean.getGoukei().toString()) + " 円");

        return khAzukarikinBikinLstDataSourceBean;
    }

    private KhAzukarikinBikinLstCsvfFile editAzukarikinKessankanriCsvInfo(
        IT_AzukarikinKessankanri pAzukarikinKessankanri, String pSyoNo, long pKensuu) {

        SetKessanNensibi setKessanNensibi = SWAKInjector.getInstance(SetKessanNensibi.class);
        BizDate kessanNensibi = setKessanNensibi.exec(pAzukarikinKessankanri.getKessankijyunymd());
        String kessanNendo = DateFormatUtil.dateYKANJISeireki(kessanNensibi.getBizDateY()) + "度";

        KhAzukarikinBikinLstCsvfFile khAzukarikinBikinLstCsvfFile = SWAKInjector.
            getInstance(KhAzukarikinBikinLstCsvfFile.class);
        khAzukarikinBikinLstCsvfFile.setIfcListnm(LISTNM);
        khAzukarikinBikinLstCsvfFile.setIfcKessannnd(kessanNendo);
        khAzukarikinBikinLstCsvfFile.setIfcSegcd(pAzukarikinKessankanri.getKbnkeirisegcd().getValue());
        khAzukarikinBikinLstCsvfFile.setIfcHknsyuruilevel(pAzukarikinKessankanri.getKbnkeirisegcd().getContent());
        khAzukarikinBikinLstCsvfFile.setIfcTuukasyu(pAzukarikinKessankanri.getTuukasyu().getValue());
        khAzukarikinBikinLstCsvfFile.setIfcKawaserate(pAzukarikinKessankanri.getKawaserate().toString());
        khAzukarikinBikinLstCsvfFile.setIfcSyono(pSyoNo);
        khAzukarikinBikinLstCsvfFile.setIfcBkncd(pAzukarikinKessankanri.getBkncdkbn().getValue());
        khAzukarikinBikinLstCsvfFile.setIfcBknkeiymd(convertDateFormat(pAzukarikinKessankanri.getBikinkeiymd()));
        khAzukarikinBikinLstCsvfFile.setIfcHnykbknjkukbn(pAzukarikinKessankanri.getBknjkukbn().getContent());
        khAzukarikinBikinLstCsvfFile.setIfcTounendgankin(
            BizUtil.comma(pAzukarikinKessankanri.getTounendgankin().toString()));
        khAzukarikinBikinLstCsvfFile.setIfcTounendrsk(
            BizUtil.comma(pAzukarikinKessankanri.getTounendrsk().toString()));
        khAzukarikinBikinLstCsvfFile.setIfcAzukariganrikin(
            BizUtil.comma(pAzukarikinKessankanri.getAzukariganrikin().toString()));
        khAzukarikinBikinLstCsvfFile.setIfcAzukarikinhsiymd(convertDateFormat(pAzukarikinKessankanri.getAzukarikinhsiymd()));
        khAzukarikinBikinLstCsvfFile.setIfcKensuu(String.valueOf(pKensuu));
        khAzukarikinBikinLstCsvfFile.setIfcGoukeikingk(
            BizUtil.comma(pAzukarikinKessankanri.getAzukariganrikin().toString()));
        khAzukarikinBikinLstCsvfFile.setIfcGaikatounendgankin(
            BizUtil.comma(pAzukarikinKessankanri.getGaikatounendgankin().toString(), BizUtil.ZERO_FILL_LAST_ONLY, 2));
        khAzukarikinBikinLstCsvfFile.setIfcGaikatounendrsk(
            BizUtil.comma(pAzukarikinKessankanri.getGaikatounendrsk().toString(), BizUtil.ZERO_FILL_LAST_ONLY, 2));
        khAzukarikinBikinLstCsvfFile.setIfcGaikaazukariganrikin(
            BizUtil.comma(pAzukarikinKessankanri.getGaikaazukariganrikin().toString(), BizUtil.ZERO_FILL_LAST_ONLY, 2));
        khAzukarikinBikinLstCsvfFile.setIfcGaikashrkwsratekjnymd(convertDateFormat(pAzukarikinKessankanri.getGaikashrkwsratekjnymd()));
        khAzukarikinBikinLstCsvfFile.setIfcGaikashrkwsrate(pAzukarikinKessankanri.getGaikashrkwsrate());
        khAzukarikinBikinLstCsvfFile.setIfcGkknsnmaetounendgankin(
            BizUtil.comma(pAzukarikinKessankanri.getGaikaknsnmaetounendgankin().toString()));
        khAzukarikinBikinLstCsvfFile.setIfcGkknsnmaetounendrsk(
            BizUtil.comma(pAzukarikinKessankanri.getGaikaknsnmaetounendrsk().toString()));
        khAzukarikinBikinLstCsvfFile.setIfcGkknsnmaeazukariganrikin(
            BizUtil.comma(pAzukarikinKessankanri.getGaikaknsnmaeazukariganrikin().toString()));

        return khAzukarikinBikinLstCsvfFile;
    }

    private String convertDateFormat(BizDate pHenkanMaeYmd) {

        String henkanGoYmd = "";

        if (pHenkanMaeYmd != null) {
            henkanGoYmd = DateFormatUtil.dateKANJISeirekiNoZero(pHenkanMaeYmd);
        }

        return henkanGoYmd;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate()  {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }

    class KhAzukarikinBikinListSksNaibuBean {

        @Getter@Setter
        private long kensuu;

        @Getter@Setter
        private BizCurrency goukei;

        @Getter@Setter
        private String hknsyruilevel;

        @Getter@Setter
        private String azukarikintuukasyu;

        @Getter@Setter
        private String kawaserate;

        public KhAzukarikinBikinListSksNaibuBean() {
            kensuu = 0;
            goukei = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            hknsyruilevel = "";
            azukarikintuukasyu = "";
            kawaserate = "";
        }
    }

}
