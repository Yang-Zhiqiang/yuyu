package yuyu.batch.biz.bzkaikei.bzkariukemeisailistsks;

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
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.bzkaikei.bzkariukemeisailistsks.dba.BzKariukeMeisaiListSksDao;
import yuyu.batch.biz.bzkaikei.bzkariukemeisailistsks.dba.HijynbrsikinidougkDataBean;
import yuyu.batch.biz.bzkaikei.bzkariukemeisailistsks.dba.ItijibrsikinidougkDataBean;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.def.MessageId;
import yuyu.def.base.detacher.AM_SosikiDetacher;
import yuyu.def.base.detacher.AS_KinouDetacher;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.base.sorter.SortAS_Kinou;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.bean.report.BzKariukeMeisaiListBean;
import yuyu.def.biz.bean.report.BzKariukeMeisaiListDataSourceBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.AM_Sosiki;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.Ordering;

/**
 * 業務共通 経理・会計 仮受計上明細リスト作成
 */
public class BzKariukeMeisaiListSksBatch implements Batch {

    private final String FILTERID = "Bz105";

    private static final C_TantouCdKbn TANTOUCDKY = C_TantouCdKbn.KAIYAKU;

    private static final String ZERO4KETA = "0000";

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private CreateReport createReport;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private BzKariukeMeisaiListSksDao bzKariukeMeisaiListSksDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        BM_TantouCd tantouCd = bizDomManager.getTantouCd(TANTOUCDKY);
        String sosikicdKeiyaku = tantouCd.getBusitucd() + ZERO4KETA;

        String tyouhyouKaijiSosikicd = null;
        String tyouhyouKaijiSosikicdMae = null;
        String syoricd = null;
        String tantoushitumei = "";
        String shorimei = "";
        int count = 0;
        List<IReportDataSouceBean> iReportDataSouceBeanLst1 = new ArrayList<>();
        List<IReportDataSouceBean> iReportDataSouceBeanLst2 = new ArrayList<>();
        List<IReportDataSouceBean> iReportDataSouceBeanLst21 = new ArrayList<>();
        List<IReportDataSouceBean> iReportDataSouceBeanLst22 = new ArrayList<>();
        List<IReportDataSouceBean> iReportDataSouceBeanLst23 = new ArrayList<>();
        List<IReportDataSouceBean> iReportDataSouceBeanLst3 = new ArrayList<>();
        List<IReportDataSouceBean> iReportDataSouceBeanLst4 = new ArrayList<>();
        List<IReportDataSouceBean> iReportDataSouceBeanLst5 = new ArrayList<>();
        List<IReportDataSouceBean> iReportDataSouceBeanLst6 = new ArrayList<>();
        Map<String, BizCurrency> hijynbrsikinidougkMap = new HashMap<>();
        Map<String, BizCurrency> itijibrsikinidougkMap = new HashMap<>();

        try (ExDBResults<BT_DenpyoData> denpyoDataLst =
            bizDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcdTaisyakukbnDensyskbn
            (bzBatchParam.getIbKakutyoujobcd(), bzBatchParam.getSyoriYmd())) {

            try (ExDBResults<HijynbrsikinidougkDataBean> hijynbrsikinidougkLst = bzKariukeMeisaiListSksDao.getHijynbrSikinidougk(
                bzBatchParam.getSyoriYmd())) {

                for (HijynbrsikinidougkDataBean hijynbrsikinidougkDataBean : hijynbrsikinidougkLst) {

                    String mapKey = hijynbrsikinidougkDataBean.getDenrenno();

                    hijynbrsikinidougkMap.put(mapKey, hijynbrsikinidougkDataBean.getHijynbrsikinidougk());
                }
            }

            try(ExDBResults<ItijibrsikinidougkDataBean> itijibrsikinidougkDataBeanLst = bzKariukeMeisaiListSksDao.
                getItijibrsikinidougkDataBeans(bzBatchParam.getSyoriYmd())) {

                for (ItijibrsikinidougkDataBean itijibrsikinidougkDataBean : itijibrsikinidougkDataBeanLst) {

                    String mapKey = itijibrsikinidougkDataBean.getDenrenno();

                    itijibrsikinidougkMap.put(mapKey, itijibrsikinidougkDataBean.getKeiyakutuukagk());
                }
            }

            for (BT_DenpyoData denpyoData : denpyoDataLst) {

                BzKariukeMeisaiListDataSourceBean bzKariukeMeisaiListBean =
                    SWAKInjector.getInstance(BzKariukeMeisaiListDataSourceBean.class);

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(BT_DenpyoData.TABLE_NAME);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(denpyoData.getDensyskbn().getValue());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(denpyoData.getDenrenno());

                if (C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_JPY.eq(denpyoData.getKanjyoukmkcd()) ||
                    C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_USD.eq(denpyoData.getKanjyoukmkcd()) ||
                    C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_AUD.eq(denpyoData.getKanjyoukmkcd()) ||
                    C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN.eq(denpyoData.getKanjyoukmkcd())) {

                    tyouhyouKaijiSosikicd = sosikicdKeiyaku;
                }
                else {

                    tyouhyouKaijiSosikicd = denpyoData.getSyorisosikicd();
                }

                if (tyouhyouKaijiSosikicdMae == null || !tyouhyouKaijiSosikicd.equals(tyouhyouKaijiSosikicdMae)) {

                    AM_Sosiki sosiki =
                        AM_SosikiDetacher.detachSosikitouched(baseDomManager.getSosiki(tyouhyouKaijiSosikicd));

                    tantoushitumei = sosiki.getKanjisosikinm20();
                }

                if (syoricd == null || !denpyoData.getSyoricd().equals(syoricd)) {

                    List<AS_Kinou> kinouLst =
                        AS_KinouDetacher.detachKinoutouched(baseDomManager.getKinousBySyoricd(denpyoData.getSyoricd()));

                    SortAS_Kinou sortASKinou = SWAKInjector.getInstance(SortAS_Kinou.class);

                    kinouLst = sortASKinou.OrderAS_KinouByPkAsc(kinouLst);

                    if (kinouLst.get(0).getKinouNm().length() > 15) {
                        shorimei = kinouLst.get(0).getKinouNm().substring(0, 15);
                    }else {
                        shorimei = kinouLst.get(0).getKinouNm();
                    }
                }

                bzKariukeMeisaiListBean.setIrTantousitucd(C_Tantositucd.valueOf(tyouhyouKaijiSosikicd.substring(0, 3)));
                bzKariukeMeisaiListBean.setIrTantousitunm(tantoushitumei);
                bzKariukeMeisaiListBean.setIrKanjyoukmkcd(denpyoData.getKanjyouKamoku().getDenkanjokamokucd());
                bzKariukeMeisaiListBean.setIrKanjyoukmknm(denpyoData.getKanjyouKamoku().getKanjyoukmknm());
                bzKariukeMeisaiListBean.setIrSyoricd(denpyoData.getSyoricd());
                bzKariukeMeisaiListBean.setIrSyorinm(shorimei);
                bzKariukeMeisaiListBean.setIrSyono(denpyoData.getKeirisyono());
                bzKariukeMeisaiListBean.setIrDenrenno(denpyoData.getDenrenno());
                bzKariukeMeisaiListBean.setIrEdano(denpyoData.getEdano());
                bzKariukeMeisaiListBean.setIrDengk(denpyoData.getDenyenkagk());
                bzKariukeMeisaiListBean.setIrShrtuukasyu(denpyoData.getTuukasyu());
                bzKariukeMeisaiListBean.setIrSiharaigk(denpyoData.getDengaikagk());

                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                bzKariukeMeisaiListBean.setIrSikinidoumeisaigk(BizCurrency.valueOf
                    (0,henkanTuuka.henkanTuukaKbnToType(denpyoData.getKyktuukasyu())));
                bzKariukeMeisaiListBean.setIrKyktuukasyu(denpyoData.getKyktuukasyu());

                if (C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO.eq(denpyoData.getKanjyoukmkcd())
                    && hijynbrsikinidougkMap.containsKey(denpyoData.getDenrenno())) {

                    bzKariukeMeisaiListBean.setIrSikinidoumeisaigk(
                        hijynbrsikinidougkMap.get(denpyoData.getDenrenno()));
                }
                else if(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO.eq(denpyoData.getKanjyoukmkcd())
                    && itijibrsikinidougkMap.containsKey(denpyoData.getDenrenno())){

                    bzKariukeMeisaiListBean.setIrSikinidoumeisaigk(
                        itijibrsikinidougkMap.get(denpyoData.getDenrenno()));
                }

                if (YuyuBizConfig.getInstance().getKariukesiharaisosikicd1().equals(tyouhyouKaijiSosikicd)) {

                    iReportDataSouceBeanLst1.add(bzKariukeMeisaiListBean);
                }
                else if (YuyuBizConfig.getInstance().getKariukesiharaisosikicd21().equals(tyouhyouKaijiSosikicd)) {

                    iReportDataSouceBeanLst21.add(bzKariukeMeisaiListBean);
                }
                else if (YuyuBizConfig.getInstance().getKariukesiharaisosikicd22().equals(tyouhyouKaijiSosikicd)) {

                    iReportDataSouceBeanLst22.add(bzKariukeMeisaiListBean);
                }
                else if (YuyuBizConfig.getInstance().getKariukesiharaisosikicd23().equals(tyouhyouKaijiSosikicd)) {

                    iReportDataSouceBeanLst23.add(bzKariukeMeisaiListBean);
                }
                else if (YuyuBizConfig.getInstance().getKariukesiharaisosikicd3().equals(tyouhyouKaijiSosikicd)) {

                    iReportDataSouceBeanLst3.add(bzKariukeMeisaiListBean);
                }
                else if (YuyuBizConfig.getInstance().getKariukesiharaisosikicd4().equals(tyouhyouKaijiSosikicd)) {

                    iReportDataSouceBeanLst4.add(bzKariukeMeisaiListBean);
                }
                else if (YuyuBizConfig.getInstance().getKariukesiharaisosikicd5().equals(tyouhyouKaijiSosikicd)) {

                    iReportDataSouceBeanLst5.add(bzKariukeMeisaiListBean);
                }
                else if (YuyuBizConfig.getInstance().getKariukesiharaisosikicd6().equals(tyouhyouKaijiSosikicd)) {

                    iReportDataSouceBeanLst6.add(bzKariukeMeisaiListBean);
                }

                else {

                    iReportDataSouceBeanLst1.add(bzKariukeMeisaiListBean);
                }

                syoricd = denpyoData.getSyoricd();
                tyouhyouKaijiSosikicdMae = tyouhyouKaijiSosikicd;
                count++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            Ordering<IReportDataSouceBean> ordering = Ordering.from(new BzKariukeMeisaiListDsBeanSortComparator());
            iReportDataSouceBeanLst1 = ordering.sortedCopy(iReportDataSouceBeanLst1);

            if (iReportDataSouceBeanLst1.size() > 0) {

                BzKariukeMeisaiListBean bzKariukeMeisaiListBean1 =
                    SWAKInjector.getInstance(BzKariukeMeisaiListBean.class);

                bzKariukeMeisaiListBean1.setIrSyoriymd(DateFormatUtil.dateKANJISeirekiNoZero(
                    bzBatchParam.getSyoriYmd()));

                createKariukekeijoumeisaiLst(C_SyoruiCdKbn.CM_KARIUKEMEISAI_1, bzBatchParam.getSyoriYmd(),
                    bzKariukeMeisaiListBean1, iReportDataSouceBeanLst1);
            }

            if (iReportDataSouceBeanLst21.size() > 0 ||
                iReportDataSouceBeanLst22.size() > 0 ||
                iReportDataSouceBeanLst23.size() > 0) {

                BzKariukeMeisaiListBean bzKariukeMeisaiListBean2 =
                    SWAKInjector.getInstance(BzKariukeMeisaiListBean.class);

                bzKariukeMeisaiListBean2.setIrSyoriymd(DateFormatUtil.dateKANJISeirekiNoZero(
                    bzBatchParam.getSyoriYmd()));

                iReportDataSouceBeanLst2.addAll(iReportDataSouceBeanLst21);
                iReportDataSouceBeanLst2.addAll(iReportDataSouceBeanLst22);
                iReportDataSouceBeanLst2.addAll(iReportDataSouceBeanLst23);

                createKariukekeijoumeisaiLst(C_SyoruiCdKbn.CM_KARIUKEMEISAI_2, bzBatchParam.getSyoriYmd(),
                    bzKariukeMeisaiListBean2, iReportDataSouceBeanLst2);
            }

            if (iReportDataSouceBeanLst3.size() > 0) {

                BzKariukeMeisaiListBean bzKariukeMeisaiListBean3 =
                    SWAKInjector.getInstance(BzKariukeMeisaiListBean.class);

                bzKariukeMeisaiListBean3.setIrSyoriymd(DateFormatUtil.dateKANJISeirekiNoZero(
                    bzBatchParam.getSyoriYmd()));

                createKariukekeijoumeisaiLst(C_SyoruiCdKbn.CM_KARIUKEMEISAI_3, bzBatchParam.getSyoriYmd(),
                    bzKariukeMeisaiListBean3, iReportDataSouceBeanLst3);
            }

            if (iReportDataSouceBeanLst4.size() > 0) {

                BzKariukeMeisaiListBean bzKariukeMeisaiListBean4 =
                    SWAKInjector.getInstance(BzKariukeMeisaiListBean.class);

                bzKariukeMeisaiListBean4.setIrSyoriymd(DateFormatUtil.dateKANJISeirekiNoZero(
                    bzBatchParam.getSyoriYmd()));

                createKariukekeijoumeisaiLst(C_SyoruiCdKbn.CM_KARIUKEMEISAI_4, bzBatchParam.getSyoriYmd(),
                    bzKariukeMeisaiListBean4, iReportDataSouceBeanLst4);
            }

            if (iReportDataSouceBeanLst5.size() > 0) {

                BzKariukeMeisaiListBean bzKariukeMeisaiListBean5 =
                    SWAKInjector.getInstance(BzKariukeMeisaiListBean.class);

                bzKariukeMeisaiListBean5.setIrSyoriymd(DateFormatUtil.dateKANJISeirekiNoZero(
                    bzBatchParam.getSyoriYmd()));

                createKariukekeijoumeisaiLst(C_SyoruiCdKbn.CM_KARIUKEMEISAI_5, bzBatchParam.getSyoriYmd(),
                    bzKariukeMeisaiListBean5, iReportDataSouceBeanLst5);
            }

            if (iReportDataSouceBeanLst6.size() > 0) {

                BzKariukeMeisaiListBean bzKariukeMeisaiListBean6 =
                    SWAKInjector.getInstance(BzKariukeMeisaiListBean.class);

                bzKariukeMeisaiListBean6.setIrSyoriymd(DateFormatUtil.dateKANJISeirekiNoZero(
                    bzBatchParam.getSyoriYmd()));

                createKariukekeijoumeisaiLst(C_SyoruiCdKbn.CM_KARIUKEMEISAI_6, bzBatchParam.getSyoriYmd(),
                    bzKariukeMeisaiListBean6, iReportDataSouceBeanLst6);
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(count)));
        }
    }

    private void createKariukekeijoumeisaiLst(C_SyoruiCdKbn pSyoruiCdKbn, BizDate pBizDate,
        BzKariukeMeisaiListBean pBzKariukeMeisaiListBean,
        List<IReportDataSouceBean> pBzKariukeMeisaiListBeanLst) {

        ReportServicesBean reportServicesBean =
            createReport.createNewReportServiceBean(kinou.getSubSystemId(), kinou.getCategoryId(),
                kinou.getKinouId(), pSyoruiCdKbn);

        reportServicesBean.setSyoriYmd(pBizDate);

        reportServicesBean.addParamObjects(pBzKariukeMeisaiListBeanLst, pBzKariukeMeisaiListBean);

        createReport.exec(reportServicesBean);

    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

}
