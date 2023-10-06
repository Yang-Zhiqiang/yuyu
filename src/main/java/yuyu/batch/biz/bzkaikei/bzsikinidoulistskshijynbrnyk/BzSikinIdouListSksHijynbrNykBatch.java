package yuyu.batch.biz.bzkaikei.bzsikinidoulistskshijynbrnyk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.bzkaikei.bzsikinidoulistskshijynbrnyk.dba.BzSikinIdouListSksHijynbrNykDao;
import yuyu.batch.biz.bzkaikei.bzsikinidoulistskshijynbrnyk.dba.HijynNykGkSikinIdouDataBean;
import yuyu.batch.biz.bzkaikei.bzsikinidoulistskshijynbrnyk.dba.HijynNykSikinIdouDataBean;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.kaikei.BzSikinIdouListCsvFSksTblTrk;
import yuyu.common.hozen.khcommon.KeisanGaikaP;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.bean.report.BzSikinIdouListHijynbrNykBean;
import yuyu.def.biz.bean.report.BzSikinIdouListHijynbrNykDataSourceBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_SikinidouJtKbn;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_SikinidoumeisaiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_HijynNykSikinIdouListSks;
import yuyu.def.db.entity.BT_HijynNykSiknIdouLstSksGk;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.Ordering;

/**
 * 業務共通 経理・会計 資金移動リスト作成(平準払入金用)
 */
public class BzSikinIdouListSksHijynbrNykBatch implements Batch {

    private static final String TYSYTTAISYOU_TABLE_ID = "IT_KykKihon";

    private static final String RECOVERY_FILTER_KBNID = "Bz001";

    private static final String TYUUKIMSG = "入金取消が発生した場合は、指定通貨額を外貨本口座から円本口座へ資金移動";

    private static final String NYUUKINTORIKESI = "入金取消分";

    private HashMap<String, SikinIdouListSksHijynbrNykDataBean> hijynNykSikinIdouDataMap = new HashMap<String, SikinIdouListSksHijynbrNykDataBean>();

    private int count = 0;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzSikinIdouListSksHijynbrNykDao bzSikinIdouListSksHijynbrNykDao;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private CreateReport createReport;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        String kakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        List<IReportDataSouceBean> ireportDataSouceBeanLst = new ArrayList<>();

        bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobcd);
        bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLE_ID);
        bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);

        try (ExDBResults<HijynNykSikinIdouDataBean> hijynNykSikinIdouDataBeanLst = bzSikinIdouListSksHijynbrNykDao
            .getHijynbrNykDatasSk(kakutyoujobcd)) {
            hijynNykSikinIdouDataSyuukei(hijynNykSikinIdouDataBeanLst);
        }

        BizDate syoriTukizueYmd = syoriYmd.getBizDateYM().getLastDay();

        if (!syoriTukizueYmd.isBusinessDay()) {
            syoriTukizueYmd = syoriTukizueYmd.getBusinessDay(CHolidayAdjustingMode.PREVIOUS);
        }

        BizDateYM syoriYM = null;

        if (BizDateUtil.compareYmd(syoriYmd, syoriTukizueYmd) == BizDateUtil.COMPARE_EQUAL) {

            syoriYM = syoriYmd.getNextMonth().getBizDateYM();
        }
        else {

            syoriYM = syoriYmd.getBizDateYM();
        }

        try (ExDBResults<HijynNykSikinIdouDataBean> hijynNykSikinIdouDataBeanLst = bzSikinIdouListSksHijynbrNykDao
            .getHijynbrNykDatasKeizokup(kakutyoujobcd, syoriYM)) {
            hijynNykSikinIdouDataSyuukei(hijynNykSikinIdouDataBeanLst);
        }

        try (ExDBResults<HijynNykSikinIdouDataBean> hijynNykSikinIdouDataBeanLst = bzSikinIdouListSksHijynbrNykDao
            .getHijynbrNyktrksDatas(kakutyoujobcd)) {
            hijynNykSikinIdouDataSyuukei(hijynNykSikinIdouDataBeanLst);
        }

        try (ExDBResults<HijynNykSikinIdouDataBean> hijynNykSikinIdouDataBeanLst = bzSikinIdouListSksHijynbrNykDao
            .getHijynbrNykDatasSyoumetu(kakutyoujobcd, syoriYM, syoriYmd)) {
            hijynNykSikinIdouDataSyuukei(hijynNykSikinIdouDataBeanLst);
        }

        try (ExDBResults<HijynNykGkSikinIdouDataBean> hijynNykGkSikinIdouDataBeanLst = bzSikinIdouListSksHijynbrNykDao
            .getHijynbrNykGkDatas(kakutyoujobcd, syoriYmd)) {
            hijynNykGkSikinIdouDataSyuukei(hijynNykGkSikinIdouDataBeanLst);
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        List<SikinIdouListSksHijynbrNykDataBean> sikinIdouListSksHijynbrNykDataBeanLst = new ArrayList<>();

        for (Map.Entry<String, SikinIdouListSksHijynbrNykDataBean> tempMap : hijynNykSikinIdouDataMap.entrySet()) {

            sikinIdouListSksHijynbrNykDataBeanLst.add(tempMap.getValue());
        }

        List<SikinIdouListSksHijynbrNykDataBean> hijynNykSikinIdouDataBeanLstSorted = Ordering.from(
            new BzSikinIdouListSksHijynbrNykComparator()).sortedCopy(sikinIdouListSksHijynbrNykDataBeanLst);

        ireportDataSouceBeanLst = hijynNykSikinIdouLstDSBEAN(hijynNykSikinIdouDataBeanLstSorted);

        if (ireportDataSouceBeanLst.size() > 0) {

            BzSikinIdouListHijynbrNykBean bzSikinIdouListHijynbrNykBean = SWAKInjector
                .getInstance(BzSikinIdouListHijynbrNykBean.class);
            bzSikinIdouListHijynbrNykBean.setIrSyoriymd(DateFormatUtil.dateKANJI(syoriYmd));

            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(kinou.getSubSystemId(),
                kinou.getCategoryId(), kinou.getKinouId(), C_SyoruiCdKbn.CM_SIKINIDOULIST_HIJYNNYK);

            reportServicesBean.setSyoriYmd(syoriYmd);

            reportServicesBean.addParamObjects(ireportDataSouceBeanLst, bzSikinIdouListHijynbrNykBean);

            createReport.execNoCommit(reportServicesBean);

            BzSikinIdouListCsvFSksTblTrk bzSikinIdouListCsvFSksTblTrk = SWAKInjector.getInstance(BzSikinIdouListCsvFSksTblTrk.class);

            bzSikinIdouListCsvFSksTblTrk.exec(syoriYmd, ireportDataSouceBeanLst);
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(count)));
    }

    private void hijynNykSikinIdouDataSyuukei(ExDBResults<HijynNykSikinIdouDataBean> pHijynNykSikinIdouDataBeanLst) {
        try (EntityUpdater<BT_HijynNykSikinIdouListSks> hijynNykSikinIdouListSksUpdater = new EntityUpdater<>();){
            for (HijynNykSikinIdouDataBean hijynNykSikinIdouDataBean : pHijynNykSikinIdouDataBeanLst) {

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(hijynNykSikinIdouDataBean.getSyono());

                if (hijynNykSikinIdouDataBean.getSyoumetuymd() != null &&
                    C_SikinidouJtKbn.SIKINIDOUMIRYOU.eq(hijynNykSikinIdouDataBean.getSikinidoujtkbn())) {
                    boolean hantei = syoumetujiListOutputHantei(hijynNykSikinIdouDataBean);

                    if (!hantei) {
                        continue;
                    }
                }

                if (C_SikinidoumeisaiKbn.NYUUKINTORIKESI.eq(hijynNykSikinIdouDataBean.getSikinidoumeisaikbn())) {
                    hijynNykSikinIdouDataBean.setSikinidoukbnnm(NYUUKINTORIKESI);
                }
                else {
                    hijynNykSikinIdouDataBean.setSikinidoukbnnm("");
                }

                String mapKey = hijynNykSikinIdouDataBean.getSikinidougroupkbn().getValue()
                    + hijynNykSikinIdouDataBean.getSiteituuka().getValue()
                    + hijynNykSikinIdouDataBean.getSikinidoukbnnm()
                    + hijynNykSikinIdouDataBean.getSeg1cd().getValue()
                    + hijynNykSikinIdouDataBean.getSikinidoumeisaikbn().getValue();

                if(hijynNykSikinIdouDataBean.getSikinidoukawaserate().compareTo(BizNumber.ZERO) == 0){

                    KeisanGaikaP keisanGaikaP = SWAKInjector.getInstance(KeisanGaikaP.class);

                    C_ErrorKbn errorKbn = keisanGaikaP.exec(hijynNykSikinIdouDataBean.getTrhktuukagk(),
                        hijynNykSikinIdouDataBean.getSiteituuka(),
                        hijynNykSikinIdouDataBean.getSikinidoupjytym(),
                        hijynNykSikinIdouDataBean.getKykymd(),
                        hijynNykSikinIdouDataBean.getFstpnyknymd());

                    if(C_ErrorKbn.OK.eq(errorKbn)){
                        hijynNykSikinIdouDataBean.setSiteituukagk(keisanGaikaP.getP());
                        hijynNykSikinIdouDataBean.setSikinidoukawaserate(keisanGaikaP.getKawaseRate());
                    }
                }

                if (hijynNykSikinIdouDataMap.containsKey(mapKey)) {

                    SikinIdouListSksHijynbrNykDataBean syuukeiyouSikinIdouDataBean = hijynNykSikinIdouDataMap.get(mapKey);
                    syuukeiyouSikinIdouDataBean.setTrhktuukagk(syuukeiyouSikinIdouDataBean.getTrhktuukagk().add(
                        hijynNykSikinIdouDataBean.getTrhktuukagk()));
                    syuukeiyouSikinIdouDataBean.setSiteituukagk(syuukeiyouSikinIdouDataBean.getSiteituukagk().add(
                        hijynNykSikinIdouDataBean.getSiteituukagk()));

                    hijynNykSikinIdouDataMap.put(mapKey, syuukeiyouSikinIdouDataBean);

                }
                else {

                    SikinIdouListSksHijynbrNykDataBean syuukeiyouSikinIdouDataBean = SWAKInjector
                        .getInstance(SikinIdouListSksHijynbrNykDataBean.class);

                    syuukeiyouSikinIdouDataBean.setSikinidougroupkbn(hijynNykSikinIdouDataBean.getSikinidougroupkbn());
                    syuukeiyouSikinIdouDataBean.setTrhktuuka(hijynNykSikinIdouDataBean.getTrhktuuka());
                    syuukeiyouSikinIdouDataBean.setTrhktuukagk(hijynNykSikinIdouDataBean.getTrhktuukagk());
                    syuukeiyouSikinIdouDataBean.setSiteituuka(hijynNykSikinIdouDataBean.getSiteituuka());
                    syuukeiyouSikinIdouDataBean.setSeg1cd(hijynNykSikinIdouDataBean.getSeg1cd());
                    syuukeiyouSikinIdouDataBean.setSiteituukagk(hijynNykSikinIdouDataBean.getSiteituukagk());
                    syuukeiyouSikinIdouDataBean.setSikinidoumeisaikbn(hijynNykSikinIdouDataBean.getSikinidoumeisaikbn());
                    syuukeiyouSikinIdouDataBean.setSikinidoukbnnm(hijynNykSikinIdouDataBean.getSikinidoukbnnm());

                    hijynNykSikinIdouDataMap.put(mapKey, syuukeiyouSikinIdouDataBean);
                }

                BT_HijynNykSikinIdouListSks hijynNykSikinIdouListSks = bizDomManager.getHijynNykSikinIdouListSks(
                    hijynNykSikinIdouDataBean.getSyono(), hijynNykSikinIdouDataBean.getSikinidoupjytym());

                if (C_SikinidouJtKbn.SIKINIDOUMIRYOU.eq(hijynNykSikinIdouListSks.getSikinidoujtkbn())) {

                    hijynNykSikinIdouListSks.setSikinidoujtkbn(C_SikinidouJtKbn.SIKINIDOUKANRYOU);
                }
                else if (C_SikinidouJtKbn.SIKINIDOUTORIKESI.eq(hijynNykSikinIdouListSks.getSikinidoujtkbn())) {

                    hijynNykSikinIdouListSks.setSikinidoujtkbn(C_SikinidouJtKbn.SIKINIDOUTORIKESIKANRYOU);
                }

                if(hijynNykSikinIdouListSks.getSikinidoukawaserate().compareTo(BizNumber.ZERO) == 0){
                    hijynNykSikinIdouListSks.setSiteituukagk(hijynNykSikinIdouDataBean.getSiteituukagk());
                    hijynNykSikinIdouListSks.setSikinidoukawaserate(hijynNykSikinIdouDataBean.getSikinidoukawaserate());
                }

                hijynNykSikinIdouListSksUpdater.add(hijynNykSikinIdouListSks);

                count++;
            }
        }
    }

    private void hijynNykGkSikinIdouDataSyuukei(ExDBResults<HijynNykGkSikinIdouDataBean> pHijynNykGkSikinIdouDataBeanLst) {

        try (EntityUpdater<BT_HijynNykSiknIdouLstSksGk> hijynNykSiknIdouLstSksGkUpdater = new EntityUpdater<>();){
            for (HijynNykGkSikinIdouDataBean hijynNykGkSikinIdouDataBean : pHijynNykGkSikinIdouDataBeanLst) {

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(hijynNykGkSikinIdouDataBean.getSyono());

                if (C_SikinidoumeisaiKbn.NYUUKINTORIKESI.eq(hijynNykGkSikinIdouDataBean.getSikinidoumeisaikbn())) {
                    hijynNykGkSikinIdouDataBean.setSikinidoukbnnm(NYUUKINTORIKESI);
                }
                else {
                    hijynNykGkSikinIdouDataBean.setSikinidoukbnnm("");
                }

                String mapKey = hijynNykGkSikinIdouDataBean.getSikinidougroupkbn().getValue()
                    + hijynNykGkSikinIdouDataBean.getSiteituuka().getValue()
                    + hijynNykGkSikinIdouDataBean.getSikinidoukbnnm()
                    + hijynNykGkSikinIdouDataBean.getSeg1cd().getValue()
                    + hijynNykGkSikinIdouDataBean.getSikinidoumeisaikbn().getValue();


                if (hijynNykSikinIdouDataMap.containsKey(mapKey)) {

                    SikinIdouListSksHijynbrNykDataBean syuukeiyouSikinIdouDataBean = hijynNykSikinIdouDataMap.get(mapKey);
                    syuukeiyouSikinIdouDataBean.setTrhktuukagk(syuukeiyouSikinIdouDataBean.getTrhktuukagk().add(
                        hijynNykGkSikinIdouDataBean.getTrhktuukagk()));
                    syuukeiyouSikinIdouDataBean.setSiteituukagk(syuukeiyouSikinIdouDataBean.getSiteituukagk().add(
                        hijynNykGkSikinIdouDataBean.getSiteituukagk()));

                    hijynNykSikinIdouDataMap.put(mapKey, syuukeiyouSikinIdouDataBean);

                }
                else {

                    SikinIdouListSksHijynbrNykDataBean syuukeiyouSikinIdouDataBean = SWAKInjector
                        .getInstance(SikinIdouListSksHijynbrNykDataBean.class);

                    syuukeiyouSikinIdouDataBean.setSikinidougroupkbn(hijynNykGkSikinIdouDataBean.getSikinidougroupkbn());
                    syuukeiyouSikinIdouDataBean.setTrhktuuka(hijynNykGkSikinIdouDataBean.getTrhktuuka());
                    syuukeiyouSikinIdouDataBean.setTrhktuukagk(hijynNykGkSikinIdouDataBean.getTrhktuukagk());
                    syuukeiyouSikinIdouDataBean.setSiteituuka(hijynNykGkSikinIdouDataBean.getSiteituuka());
                    syuukeiyouSikinIdouDataBean.setSeg1cd(hijynNykGkSikinIdouDataBean.getSeg1cd());
                    syuukeiyouSikinIdouDataBean.setSiteituukagk(hijynNykGkSikinIdouDataBean.getSiteituukagk());
                    syuukeiyouSikinIdouDataBean.setSikinidoumeisaikbn(hijynNykGkSikinIdouDataBean.getSikinidoumeisaikbn());
                    syuukeiyouSikinIdouDataBean.setSikinidoukbnnm(hijynNykGkSikinIdouDataBean.getSikinidoukbnnm());

                    hijynNykSikinIdouDataMap.put(mapKey, syuukeiyouSikinIdouDataBean);
                }


                BT_HijynNykSiknIdouLstSksGk hijynNykSiknIdouLstSksGk = bizDomManager.getHijynNykSiknIdouLstSksGk(
                    hijynNykGkSikinIdouDataBean.getSyoriYmd(),
                    hijynNykGkSikinIdouDataBean.getSikinidoupkbn(),
                    hijynNykGkSikinIdouDataBean.getSyono(),
                    hijynNykGkSikinIdouDataBean.getRenno());

                if (C_SikinidouJtKbn.SIKINIDOUMIRYOU.eq(hijynNykSiknIdouLstSksGk.getSikinidoujtkbn())) {

                    hijynNykSiknIdouLstSksGk.setSikinidoujtkbn(C_SikinidouJtKbn.SIKINIDOUKANRYOU);
                }
                else if (C_SikinidouJtKbn.SIKINIDOUTORIKESI.eq(hijynNykSiknIdouLstSksGk.getSikinidoujtkbn())) {

                    hijynNykSiknIdouLstSksGk.setSikinidoujtkbn(C_SikinidouJtKbn.SIKINIDOUTORIKESIKANRYOU);
                }

                hijynNykSiknIdouLstSksGkUpdater.add(hijynNykSiknIdouLstSksGk);

                count++;
            }
        }
    }

    private List<IReportDataSouceBean> hijynNykSikinIdouLstDSBEAN(
        List<SikinIdouListSksHijynbrNykDataBean> pHijynNykSikinIdouDataBeanLst) {

        BizCurrency trhktuukaGoukeiGk = BizCurrency.valueOf(0);
        BizCurrency siteituukaGoukeiGk = BizCurrency.valueOf(0);
        C_SikinidougroupKbn sikinIdouGroupKbnBefore = null;
        C_Tuukasyu siteituukaBefore = null;
        String sikinIdouKbnNmBefore = null;
        List<IReportDataSouceBean> ireportDataSouceBeanLst = new ArrayList<>();
        boolean Hijynnyksknidoutyuukimsgflag = false;

        for (SikinIdouListSksHijynbrNykDataBean sikinIdouListSksHijynbrNykDataBean : pHijynNykSikinIdouDataBeanLst) {

            BzSikinIdouListHijynbrNykDataSourceBean bzSikinIdouListHijynbrNykDataSourceBean = SWAKInjector
                .getInstance(BzSikinIdouListHijynbrNykDataSourceBean.class);

            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisikinidougroupno(sikinIdouListSksHijynbrNykDataBean
                .getSikinidougroupkbn());
            bzSikinIdouListHijynbrNykDataSourceBean.setIrSikinidoukbnnm(sikinIdouListSksHijynbrNykDataBean
                .getSikinidoukbnnm());
            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeiritrhktuukasyu(sikinIdouListSksHijynbrNykDataBean
                .getTrhktuuka());
            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeiritrhktuukagk(sikinIdouListSksHijynbrNykDataBean
                .getTrhktuukagk());
            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisiteituukasyu(sikinIdouListSksHijynbrNykDataBean
                .getSiteituuka());
            bzSikinIdouListHijynbrNykDataSourceBean.setIrSeg1cd(sikinIdouListSksHijynbrNykDataBean.getSeg1cd());
            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisiteituukagkgaika(sikinIdouListSksHijynbrNykDataBean
                .getSiteituukagk());
            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisikinidoumeisaikbnnm("");
            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeiritrhktuukagkkei(BizCurrency.valueOf(0));
            bzSikinIdouListHijynbrNykDataSourceBean.setIrKeirisiteituukagkkei(BizCurrency.valueOf(0));
            bzSikinIdouListHijynbrNykDataSourceBean.setIrHijynnyksknidoutyuukimsg("");

            if (C_SikinidoumeisaiKbn.NYUUKINTORIKESI.eq(sikinIdouListSksHijynbrNykDataBean.getSikinidoumeisaikbn())) {

                bzSikinIdouListHijynbrNykDataSourceBean
                .setIrKeirisikinidoumeisaikbnnm(C_SikinidoumeisaiKbn.NYUUKINTORIKESI.getContent());
            }

            if (sikinIdouGroupKbnBefore == null && siteituukaBefore == null && sikinIdouKbnNmBefore == null) {

                trhktuukaGoukeiGk = BizCurrency.valueOf(0);
                siteituukaGoukeiGk = BizCurrency.valueOf(0, sikinIdouListSksHijynbrNykDataBean.getSiteituukagk().getType());
                Hijynnyksknidoutyuukimsgflag = false;
            }
            else {

                if (!sikinIdouListSksHijynbrNykDataBean.getSikinidougroupkbn().eq(sikinIdouGroupKbnBefore)
                    || !sikinIdouListSksHijynbrNykDataBean.getSiteituuka().eq(siteituukaBefore)
                    || !sikinIdouListSksHijynbrNykDataBean.getSikinidoukbnnm().equals(sikinIdouKbnNmBefore)) {

                    BzSikinIdouListHijynbrNykDataSourceBean bzSikinIdouListHijynbrNykDataSourceBeanLast =
                        (BzSikinIdouListHijynbrNykDataSourceBean)ireportDataSouceBeanLst.get(ireportDataSouceBeanLst.size() - 1);
                    bzSikinIdouListHijynbrNykDataSourceBeanLast.setIrKeiritrhktuukagkkei(trhktuukaGoukeiGk);
                    bzSikinIdouListHijynbrNykDataSourceBeanLast.setIrKeirisiteituukagkkei(siteituukaGoukeiGk);

                    if ( Hijynnyksknidoutyuukimsgflag == true ){
                        bzSikinIdouListHijynbrNykDataSourceBeanLast.setIrHijynnyksknidoutyuukimsg(TYUUKIMSG);
                    }

                    trhktuukaGoukeiGk = BizCurrency.valueOf(0);
                    siteituukaGoukeiGk = BizCurrency.valueOf(0, sikinIdouListSksHijynbrNykDataBean.getSiteituukagk().getType());
                    Hijynnyksknidoutyuukimsgflag = false;
                }
            }

            trhktuukaGoukeiGk = trhktuukaGoukeiGk.add(sikinIdouListSksHijynbrNykDataBean.getTrhktuukagk());
            siteituukaGoukeiGk = siteituukaGoukeiGk.add(sikinIdouListSksHijynbrNykDataBean.getSiteituukagk());

            if (NYUUKINTORIKESI.equals(sikinIdouListSksHijynbrNykDataBean.getSikinidoukbnnm())) {
                Hijynnyksknidoutyuukimsgflag = true;
            }

            sikinIdouGroupKbnBefore = sikinIdouListSksHijynbrNykDataBean.getSikinidougroupkbn();
            siteituukaBefore = sikinIdouListSksHijynbrNykDataBean.getSiteituuka();
            sikinIdouKbnNmBefore = sikinIdouListSksHijynbrNykDataBean.getSikinidoukbnnm();

            ireportDataSouceBeanLst.add(bzSikinIdouListHijynbrNykDataSourceBean);
        }

        if (ireportDataSouceBeanLst.size() > 0) {

            BzSikinIdouListHijynbrNykDataSourceBean bzSikinIdouListHijynbrNykDataSourceBeanLast =
                (BzSikinIdouListHijynbrNykDataSourceBean)ireportDataSouceBeanLst.get(ireportDataSouceBeanLst.size() - 1);

            bzSikinIdouListHijynbrNykDataSourceBeanLast.setIrKeiritrhktuukagkkei(trhktuukaGoukeiGk);
            bzSikinIdouListHijynbrNykDataSourceBeanLast.setIrKeirisiteituukagkkei(siteituukaGoukeiGk);

            if ( Hijynnyksknidoutyuukimsgflag == true ){

                bzSikinIdouListHijynbrNykDataSourceBeanLast.setIrHijynnyksknidoutyuukimsg(TYUUKIMSG);
            }
        }


        return ireportDataSouceBeanLst;
    }


    private boolean syoumetujiListOutputHantei(HijynNykSikinIdouDataBean pHijynNykSikinIdouDataBean) {

        boolean listOutputFlg = false;
        BizDateYM syoumetuYM = pHijynNykSikinIdouDataBean.getSyoumetuymd().getBizDateYM();

        if (pHijynNykSikinIdouDataBean.getSikinidoupjytym().compareTo(syoumetuYM) < 1) {
            listOutputFlg = true;
        }

        return listOutputFlg;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}