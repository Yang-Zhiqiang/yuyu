package yuyu.batch.hozen.khansyuu.khkariukekinseibitokusokulistsks;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khkariukekinseibitokusokulistsks.dba.KariukeTokusokuListSksTaisyouBean;
import yuyu.batch.hozen.khansyuu.khkariukekinseibitokusokulistsks.dba.KhKariukekinSeibiTokusokuListSksDao;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_KrkknSeibiTokusokuInfo;
import yuyu.def.hozen.bean.report.KhKrkknSeibiTokusokuListBean;
import yuyu.def.hozen.bean.report.KhKrkknSeibiTokusokuListDataSourceBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 案内収納 仮受金整備督促リスト作成
 */
public class KhKariukekinSeibiTokusokuListSksBatch implements Batch {

    private static final String TABLEID = IT_KrkknSeibiTokusokuInfo.TABLE_NAME;

    private static final String FILTERID = "Bz001";

    private static final String SAKUSEI_SOSIKICD = "5510000";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhKariukekinSeibiTokusokuListSksDao khKariukekinSeibiTokusokuListSksDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        long syoriKensu = 0;
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyouJobCd));

        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

        BzGetSosikiDataBean sakuseiSosikiDataBean = bzGetSosikiData.exec(SAKUSEI_SOSIKICD);

        String krkLstSakuseiSosikiNm;

        if (C_SosikimasterUmuKbn.ARI.eq(sakuseiSosikiDataBean.getSosikimasterumukbn())) {

            krkLstSakuseiSosikiNm = sakuseiSosikiDataBean.getKanjisosikinm20();
        }
        else {

            krkLstSakuseiSosikiNm = "";
        }

        List<IReportDataSouceBean> iReportDataSouceBeanLst = new ArrayList<>();
        KhKrkknSeibiTokusokuListDataSourceBean khKrkknSeibiTokusokuListDataSourceBean;
        LinkedHashMap<String, List<IReportDataSouceBean>> khKrkknSeibiTokusokuListInfoMap = new LinkedHashMap<>();
        try (ExDBResults<KariukeTokusokuListSksTaisyouBean> kariukeTokusokuListSksTaisyouBeanLst =
            khKariukekinSeibiTokusokuListSksDao.getKariukeTokusokuListSksTaisyouBeans(kakutyouJobCd);) {

            for (KariukeTokusokuListSksTaisyouBean kariukeTokusokuListSksTaisyouBean : kariukeTokusokuListSksTaisyouBeanLst) {

                String syoNo = kariukeTokusokuListSksTaisyouBean.getSyono();
                Integer krkNo = kariukeTokusokuListSksTaisyouBean.getKrkno();
                String atesakiSosikicd  = kariukeTokusokuListSksTaisyouBean.getAtesakiSosikicd();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(syoNo);

                String krkjHrkkaisuu;

                if (C_Hrkkaisuu.NEN.eq(kariukeTokusokuListSksTaisyouBean.getKrkjhrkkaisuu())) {

                    krkjHrkkaisuu = "年";

                }
                else if (C_Hrkkaisuu.HALFY.eq(kariukeTokusokuListSksTaisyouBean.getKrkjhrkkaisuu())) {

                    krkjHrkkaisuu = "半";

                }
                else if (C_Hrkkaisuu.TUKI.eq(kariukeTokusokuListSksTaisyouBean.getKrkjhrkkaisuu())) {

                    krkjHrkkaisuu = "月";

                }
                else {
                    krkjHrkkaisuu = "０";
                }

                String tyoukiMisyoriHyouji = "";

                if (C_UmuKbn.ARI.eq(kariukeTokusokuListSksTaisyouBean.getTyoukimiseibikrkumu())) {

                    tyoukiMisyoriHyouji = "*";
                }

                String hukusuuKrkariHyouji = "";

                if (C_UmuKbn.ARI.eq(kariukeTokusokuListSksTaisyouBean.getHukusuukrkumu())) {
                    hukusuuKrkariHyouji = "*";
                }

                String krkLstAtesakiSosiki;

                sakuseiSosikiDataBean = bzGetSosikiData.exec(atesakiSosikicd);

                if (C_SosikimasterUmuKbn.ARI.eq(sakuseiSosikiDataBean.getSosikimasterumukbn())) {

                    krkLstAtesakiSosiki = sakuseiSosikiDataBean.getKanjisosikinm20();
                }
                else {

                    krkLstAtesakiSosiki = "";
                }

                String jyuutouKaisuu = "";

                if (kariukeTokusokuListSksTaisyouBean.getJyutoukaisuuy() != 0) {

                    jyuutouKaisuu = kariukeTokusokuListSksTaisyouBean.getJyutoukaisuuy() + "年";
                }

                if (kariukeTokusokuListSksTaisyouBean.getJyutoukaisuum() != 0) {

                    jyuutouKaisuu = jyuutouKaisuu + kariukeTokusokuListSksTaisyouBean.getJyutoukaisuum() + "ヵ月";
                }

                khKrkknSeibiTokusokuListDataSourceBean =
                    SWAKInjector.getInstance(KhKrkknSeibiTokusokuListDataSourceBean.class);

                khKrkknSeibiTokusokuListDataSourceBean.setIrTantocd(kariukeTokusokuListSksTaisyouBean.getTantocd());
                khKrkknSeibiTokusokuListDataSourceBean.setIrAtesakisosiki(krkLstAtesakiSosiki);
                khKrkknSeibiTokusokuListDataSourceBean.setIrNykkeiro(kariukeTokusokuListSksTaisyouBean.getNykkeiro());
                khKrkknSeibiTokusokuListDataSourceBean.setIrTyoukimisyorihyouji(tyoukiMisyoriHyouji);
                khKrkknSeibiTokusokuListDataSourceBean.setIrKrkkeijyoymd(kariukeTokusokuListSksTaisyouBean.getKrkkeijyoymd());
                khKrkknSeibiTokusokuListDataSourceBean.setIrSyono(syoNo);
                khKrkknSeibiTokusokuListDataSourceBean.setIrKyknmkj(kariukeTokusokuListSksTaisyouBean.getKyknmkj());
                khKrkknSeibiTokusokuListDataSourceBean.setIrHukusuukrkarihyouji(hukusuuKrkariHyouji);
                khKrkknSeibiTokusokuListDataSourceBean.setIrKrkno(krkNo);
                khKrkknSeibiTokusokuListDataSourceBean.setIrKrkjhrkkaisuu(krkjHrkkaisuu);
                khKrkknSeibiTokusokuListDataSourceBean.setIrKrkriyuukbn(kariukeTokusokuListSksTaisyouBean.getKrkriyuukbn());
                khKrkknSeibiTokusokuListDataSourceBean.setIrNyknaiyoukbn(kariukeTokusokuListSksTaisyouBean.getNyknaiyoukbn());
                khKrkknSeibiTokusokuListDataSourceBean.setIrJyuutouym(kariukeTokusokuListSksTaisyouBean.getJyuutouym());
                khKrkknSeibiTokusokuListDataSourceBean.setIrJyutoukaisuuy(jyuutouKaisuu);
                khKrkknSeibiTokusokuListDataSourceBean.setIrKrkgk(kariukeTokusokuListSksTaisyouBean.getKrkgk());
                khKrkknSeibiTokusokuListDataSourceBean.setIrRyosyuymd(String.valueOf(kariukeTokusokuListSksTaisyouBean.getRyosyuymd()));
                if (!khKrkknSeibiTokusokuListInfoMap.containsKey(kariukeTokusokuListSksTaisyouBean.getAtesakiSosikicd())) {

                    iReportDataSouceBeanLst = new ArrayList<>();
                    khKrkknSeibiTokusokuListInfoMap.put(kariukeTokusokuListSksTaisyouBean.getAtesakiSosikicd(), iReportDataSouceBeanLst);

                }

                iReportDataSouceBeanLst.add(khKrkknSeibiTokusokuListDataSourceBean);

                khKrkknSeibiTokusokuListInfoMap.put(kariukeTokusokuListSksTaisyouBean.getAtesakiSosikicd(), iReportDataSouceBeanLst);

                syoriKensu = syoriKensu + 1;
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        if (syoriKensu > 0) {
            for (String mapKey : khKrkknSeibiTokusokuListInfoMap.keySet()) {

                String atesakiSosikicd = mapKey;
                iReportDataSouceBeanLst = khKrkknSeibiTokusokuListInfoMap.get(mapKey);

                KhKrkknSeibiTokusokuListBean khKrkknSeibiTokusokuListBean = SWAKInjector.getInstance(KhKrkknSeibiTokusokuListBean.class);
                khKrkknSeibiTokusokuListBean.setIrSakuseiymd(String.valueOf(syoriYmd));
                khKrkknSeibiTokusokuListBean.setIrSakuseisosiki(krkLstSakuseiSosikiNm);

                CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);
                C_SyoruiCdKbn syoruiCdKbn = C_SyoruiCdKbn.BLNK;

                if (atesakiSosikicd.equals(C_Tantositucd.HOZENHENKOUSV.getValue() + "0000")) {

                    syoruiCdKbn = C_SyoruiCdKbn.AS_KRKKN_SEIBITOKUSOKULIST_2;

                }
                else {

                    syoruiCdKbn = C_SyoruiCdKbn.AS_KRKKN_SEIBITOKUSOKULIST_1;
                }

                ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                    kinou.getSubSystemId(),
                    khozenCommonParam.getUserID(),
                    khozenCommonParam.getFunctionId(),
                    syoruiCdKbn);

                reportServicesBean.addParamObjects(iReportDataSouceBeanLst, khKrkknSeibiTokusokuListBean);
                reportServicesBean.setSyoriYmd(syoriYmd);
                createReport.execNoCommit(reportServicesBean);
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
