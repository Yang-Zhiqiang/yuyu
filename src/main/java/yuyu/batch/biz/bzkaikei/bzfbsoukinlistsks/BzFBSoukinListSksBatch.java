package yuyu.batch.biz.bzkaikei.bzfbsoukinlistsks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.bzkaikei.bzfbsoukinlistsks.dba.BzFBSoukinListSksDao;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.bean.report.BzFbHurikomiGoukeiListBean;
import yuyu.def.biz.bean.report.BzFbHurikomiGoukeiListDataSourceBean;
import yuyu.def.biz.bean.report.BzFbSoukinMeisaiListBean;
import yuyu.def.biz.bean.report.BzFbSoukinMeisaiListDataSourceBean;
import yuyu.def.biz.detacher.BM_TantouCdDetacher;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BankmasterUmuKbn;
import yuyu.def.classification.C_FbSoukinBatchKbn;
import yuyu.def.classification.C_Gyoumucd;
import yuyu.def.classification.C_Kokunaikwskameihyj;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AM_Sosiki;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_FBSoukinListKanri;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.entity.BT_FBSoukinData;
import yuyu.def.db.entity.BT_FBSoukinHukaInfo;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.Ordering;

/**
 * 業務共通 経理・会計 ＦＢ送金リスト作成クラス
 */
public class BzFBSoukinListSksBatch implements Batch {

    private static final String TABLEID = BT_FBSoukinData.TABLE_NAME;

    private static final String FILTERID = "Bz107";

    private static final String ZEROFOUR = "0000";

    private static final int ZERO = 0;

    private static final String SOUKINHUKABANK = "【送金不可銀行分】";

    private BizCurrency soukingk;

    private Long meisaiKensuu;

    private String cTantouNm;

    private String syoriSosikiCd;

    private Long atesakiHumeiKensuu;

    private List<CreatFBSoukinLstBean> creatFBSoukinLstBeanLst = new ArrayList<>();

    private  List<BzFBSoukinDataAtesakiHumeiBean> bzFBSoukinDataAtesakiHumeiBeanLst = new ArrayList<>();

    private List<IReportDataSouceBean> bzFbSoukinMeisaiListDataSourceBeanLst = new ArrayList<>();

    private List<IReportDataSouceBean> bzFbHurikomiGoukeiListDataSourceBeanLst = new ArrayList<>();

    private List<BzFBSoukinDataBean> sortBzFBSoukinDataBeanLst = new ArrayList<>();

    private String soukinhukabank;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private CreateReport createReport;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private BzFBSoukinListSksDao bzFBSoukinListSksDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            bzBatchParam.getSyoriYmd().toString()));

        meisaiKensuu = 0L;
        soukingk = BizCurrency.valueOf(0);
        cTantouNm = "";
        syoriSosikiCd = "";
        BT_FBSoukinData btFBSoukinDataBefore = null;
        BM_FBSoukinListKanri bmFBSoukinListKanriBefore = null;
        creatFBSoukinLstBeanLst = new ArrayList<>();
        sortBzFBSoukinDataBeanLst = new ArrayList<>();

        try (ExDBResults<BT_FBSoukinData> btFBSoukinDataList =
            bzFBSoukinListSksDao.getAtesakiAriFBSoukinListSksDatas(
                bzBatchParam.getIbKakutyoujobcd(), bzBatchParam.getSyoriYmd());) {

            Iterator<BT_FBSoukinData> iterator = btFBSoukinDataList.iterator();

            if (!iterator.hasNext()) {
                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(meisaiKensuu)));
                return;
            }

            while (iterator.hasNext()) {
                BT_FBSoukinData btFBSoukinData = iterator.next();
                BT_FBSoukinHukaInfo btFBSoukinHukaInfo = btFBSoukinData.getFBSoukinHukaInfo();
                BM_FBSoukinListKanri bmFBSoukinListKanri = btFBSoukinData.getFBSoukinListKanri();
                BzFBSoukinDataBean bzFBSoukinDataBean = SWAKInjector.getInstance(BzFBSoukinDataBean.class);

                bzFBSoukinDataBean.setFBSoukinData(btFBSoukinData);
                bzFBSoukinDataBean.setFBSoukinHukaInfo(btFBSoukinHukaInfo);
                bzFBSoukinDataBean.setFBSoukinListKanri(bmFBSoukinListKanri);

                String soukinHukaBank = getSoukinhukabank(btFBSoukinData);
                bzFBSoukinDataBean.setSoukinHukaBank(soukinHukaBank);

                sortBzFBSoukinDataBeanLst.add(bzFBSoukinDataBean);
            }

            Ordering<BzFBSoukinDataBean> orderingFBSoukinData = Ordering.from(new BzFBSoukinDataBeanSortComparator());
            sortBzFBSoukinDataBeanLst = orderingFBSoukinData.sortedCopy(sortBzFBSoukinDataBeanLst);

            for (BzFBSoukinDataBean sortBzFBSoukinDataBean : sortBzFBSoukinDataBeanLst) {

                BT_FBSoukinData btFBSoukinData = sortBzFBSoukinDataBean.getFBSoukinData();
                BT_FBSoukinHukaInfo btFBSoukinHukaInfo = sortBzFBSoukinDataBean.getFBSoukinHukaInfo();
                BM_FBSoukinListKanri bmFBSoukinListKanri = sortBzFBSoukinDataBean.getFBSoukinListKanri();
                syoriSosikiCd = btFBSoukinData.getSyorisosikicd();
                soukinhukabank = sortBzFBSoukinDataBean.getSoukinHukaBank();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(btFBSoukinData.getFbsoukindatasikibetukey());

                if (btFBSoukinDataBefore == null) {

                    AM_Sosiki AM_Sosiki = baseDomManager.getSosiki(bmFBSoukinListKanri.getTantositucd() + ZEROFOUR);

                    cTantouNm = AM_Sosiki.getKanjisosikinm20();

                    soukingk = btFBSoukinData.getSoukingk();

                    if (!bmFBSoukinListKanri.getFbgoukeisyoruicd().equals(C_SyoruiCdKbn.BLNK)) {
                        createSumListData(btFBSoukinData, bmFBSoukinListKanri);
                    }

                }
                else {

                    if (!bmFBSoukinListKanriBefore.getTantositucd().eq(bmFBSoukinListKanri.getTantositucd())) {

                        AM_Sosiki AM_Sosiki = baseDomManager.getSosiki(bmFBSoukinListKanri.getTantositucd() + ZEROFOUR);

                        cTantouNm = AM_Sosiki.getKanjisosikinm20();
                    }

                    if (!bmFBSoukinListKanri.getFbgoukeisyoruicd().equals(C_SyoruiCdKbn.BLNK)) {
                        if (!bmFBSoukinListKanriBefore.getFbmeisaisyoruicd().
                            eq(bmFBSoukinListKanri.getFbmeisaisyoruicd()) ||
                            !bmFBSoukinListKanriBefore.getTantositucd().eq(bmFBSoukinListKanri.getTantositucd()) ||
                            !btFBSoukinDataBefore.getShrhousiteikbn().eq(btFBSoukinData.getShrhousiteikbn()) ||
                            !btFBSoukinDataBefore.getGyoumucd().eq(btFBSoukinData.getGyoumucd())) {

                            createSumListData(btFBSoukinData, bmFBSoukinListKanri);
                        }
                        else {
                            creatFBSoukinLstBeanLst.get(creatFBSoukinLstBeanLst.size() - 1).setIrHrkmkensu(
                                creatFBSoukinLstBeanLst.get(creatFBSoukinLstBeanLst.size() - 1).
                                getIrHrkmkensu().add(BizNumber.ONE));

                            creatFBSoukinLstBeanLst.get(creatFBSoukinLstBeanLst.size() - 1).setIrHrkmgkkei(
                                creatFBSoukinLstBeanLst.get(creatFBSoukinLstBeanLst.size() - 1).getIrHrkmgkkei()
                                .add(btFBSoukinData.getSoukingk()));

                            if (C_Tuukasyu.JPY.eq(btFBSoukinData.getKyktuukasyu())) {

                                creatFBSoukinLstBeanLst.get(creatFBSoukinLstBeanLst.size() - 1).setIrYkdtkykHrkmkensu(
                                    creatFBSoukinLstBeanLst.get(creatFBSoukinLstBeanLst.size() - 1).
                                    getIrYkdtkykHrkmkensu().add(BizNumber.ONE));

                                creatFBSoukinLstBeanLst.get(creatFBSoukinLstBeanLst.size() - 1).setIrYkdtkykHrkmgkkei(
                                    creatFBSoukinLstBeanLst.get(creatFBSoukinLstBeanLst.size() - 1).getIrYkdtkykHrkmgkkei()
                                    .add(btFBSoukinData.getSoukingk()));

                            }

                            else {
                                creatFBSoukinLstBeanLst.get(creatFBSoukinLstBeanLst.size() - 1).setIrGkdtkykHrkmkensu(
                                    creatFBSoukinLstBeanLst.get(creatFBSoukinLstBeanLst.size() - 1).
                                    getIrGkdtkykHrkmkensu().add(BizNumber.ONE));

                                creatFBSoukinLstBeanLst.get(creatFBSoukinLstBeanLst.size() - 1).setIrGkdtkykHrkmgkkei(
                                    creatFBSoukinLstBeanLst.get(creatFBSoukinLstBeanLst.size() - 1).getIrGkdtkykHrkmgkkei()
                                    .add(btFBSoukinData.getSoukingk()));
                            }

                        }
                    }

                    if (!bmFBSoukinListKanriBefore.getFbmeisaisyoruicd().
                        eq(bmFBSoukinListKanri.getFbmeisaisyoruicd()) ||
                        !bmFBSoukinListKanriBefore.getTantositucd().eq(bmFBSoukinListKanri.getTantositucd()) ||
                        !btFBSoukinDataBefore.getShrhousiteikbn().eq(btFBSoukinData.getShrhousiteikbn()) ||
                        !btFBSoukinDataBefore.getGyoumucd().eq(btFBSoukinData.getGyoumucd()) ||
                        !btFBSoukinDataBefore.getBankcd().equals(btFBSoukinData.getBankcd()) ||
                        !btFBSoukinDataBefore.getSitencd().equals(btFBSoukinData.getSitencd()) ||
                        !btFBSoukinDataBefore.getYokinkbn().eq(btFBSoukinData.getYokinkbn()) ||
                        !btFBSoukinDataBefore.getKouzano().equals(btFBSoukinData.getKouzano()) ||
                        !btFBSoukinDataBefore.getKzmeiginmkn().equals(btFBSoukinData.getKzmeiginmkn())) {

                        setDetailListSumValue();

                        soukingk = btFBSoukinData.getSoukingk();
                    }
                    else {

                        soukingk = soukingk.add(btFBSoukinData.getSoukingk());
                    }

                    if (!bmFBSoukinListKanriBefore.getFbmeisaisyoruicd().
                        eq(bmFBSoukinListKanri.getFbmeisaisyoruicd())) {

                        outputDetailList(bzBatchParam.getSyoriYmd(), bmFBSoukinListKanriBefore.getFbmeisaisyoruicd());
                    }

                }
                AS_Kinou asKinou = baseDomManager.getKinousBySyoricd(btFBSoukinData.getSyoricd()).get(ZERO);

                createDetailListDSBean(btFBSoukinData, btFBSoukinHukaInfo, bmFBSoukinListKanri, asKinou);

                btFBSoukinDataBefore = btFBSoukinData;
                bmFBSoukinListKanriBefore = bmFBSoukinListKanri;
            }

            setDetailListSumValue();

            outputDetailList(bzBatchParam.getSyoriYmd(), bmFBSoukinListKanriBefore.getFbmeisaisyoruicd());

            bzRecoveryDatasikibetuBean.initializeBlank();

            if (createAtesakiHumeiFBSoukinData()) {

                createAtesakiHumeiDetailList();
            }

            CreatFBSoukinLstBean creatFBSoukinLstBeanBefore = null;

            Ordering<CreatFBSoukinLstBean> ordering = Ordering.from(new CreatFBSoukinLstBeanSortComparator());
            creatFBSoukinLstBeanLst = ordering.sortedCopy(creatFBSoukinLstBeanLst);

            for (CreatFBSoukinLstBean creatFBSoukinLstBean : creatFBSoukinLstBeanLst) {

                if (creatFBSoukinLstBeanBefore == null) {

                    BzFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean =
                        SWAKInjector.getInstance(BzFbHurikomiGoukeiListDataSourceBean.class);

                    bzFbHurikomiGoukeiListDataSourceBean.setIrTantousitucd(creatFBSoukinLstBean.getTantositucd());
                    bzFbHurikomiGoukeiListDataSourceBean.setIrTantousitunm(creatFBSoukinLstBean.getIrTantousitunm());
                    bzFbHurikomiGoukeiListDataSourceBean.setIrShrhousiteikbn(creatFBSoukinLstBean.getShrhousiteikbn());
                    bzFbHurikomiGoukeiListDataSourceBean.
                    setIrHrkmsiteiymd(DateFormatUtil.dateKANJISeirekiNoZero((creatFBSoukinLstBean.getDenYmd())));
                    bzFbHurikomiGoukeiListDataSourceBean.setIrGyoumucd(creatFBSoukinLstBean.getIrGyoumucd());
                    bzFbHurikomiGoukeiListDataSourceBean.setIrHrkmkensu(creatFBSoukinLstBean.getIrHrkmkensu());
                    bzFbHurikomiGoukeiListDataSourceBean.setIrYkdtkykhrkmkensu(creatFBSoukinLstBean.getIrYkdtkykHrkmkensu());
                    bzFbHurikomiGoukeiListDataSourceBean.setIrGkdtkykhrkmkensu(creatFBSoukinLstBean.getIrGkdtkykHrkmkensu());
                    bzFbHurikomiGoukeiListDataSourceBean.setIrHrkmgkkei(creatFBSoukinLstBean.getIrHrkmgkkei());
                    bzFbHurikomiGoukeiListDataSourceBean.setIrYkdtkykhrkmgkkei(creatFBSoukinLstBean.getIrYkdtkykHrkmgkkei());
                    bzFbHurikomiGoukeiListDataSourceBean.setIrGkdtkykhrkmgkkei(creatFBSoukinLstBean.getIrGkdtkykHrkmgkkei());

                    bzFbHurikomiGoukeiListDataSourceBeanLst.add(bzFbHurikomiGoukeiListDataSourceBean);

                }
                else {

                    if (!creatFBSoukinLstBeanBefore.getSyoruiCdKbn().eq(creatFBSoukinLstBean.getSyoruiCdKbn())) {

                        outputSumList(bzBatchParam.getSyoriYmd(), creatFBSoukinLstBeanBefore.getSyoruiCdKbn());
                    }

                    if (!creatFBSoukinLstBeanBefore.getSyoruiCdKbn().eq(creatFBSoukinLstBean.getSyoruiCdKbn())
                        || !creatFBSoukinLstBeanBefore.getShrhousiteikbn().eq(creatFBSoukinLstBean.getShrhousiteikbn())
                        || !creatFBSoukinLstBeanBefore.getIrGyoumucd().eq(creatFBSoukinLstBean.getIrGyoumucd())) {

                        BzFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean =
                            SWAKInjector.getInstance(BzFbHurikomiGoukeiListDataSourceBean.class);

                        bzFbHurikomiGoukeiListDataSourceBean.setIrTantousitucd(creatFBSoukinLstBean.getTantositucd());
                        bzFbHurikomiGoukeiListDataSourceBean.
                        setIrTantousitunm(creatFBSoukinLstBean.getIrTantousitunm());
                        bzFbHurikomiGoukeiListDataSourceBean.
                        setIrShrhousiteikbn(creatFBSoukinLstBean.getShrhousiteikbn());
                        bzFbHurikomiGoukeiListDataSourceBean.
                        setIrHrkmsiteiymd(DateFormatUtil.dateKANJISeirekiNoZero(creatFBSoukinLstBean.getDenYmd()));
                        bzFbHurikomiGoukeiListDataSourceBean.setIrGyoumucd(creatFBSoukinLstBean.getIrGyoumucd());
                        bzFbHurikomiGoukeiListDataSourceBean.setIrHrkmkensu(creatFBSoukinLstBean.getIrHrkmkensu());
                        bzFbHurikomiGoukeiListDataSourceBean.setIrYkdtkykhrkmkensu(creatFBSoukinLstBean.getIrYkdtkykHrkmkensu());
                        bzFbHurikomiGoukeiListDataSourceBean.setIrGkdtkykhrkmkensu(creatFBSoukinLstBean.getIrGkdtkykHrkmkensu());
                        bzFbHurikomiGoukeiListDataSourceBean.setIrHrkmgkkei(creatFBSoukinLstBean.getIrHrkmgkkei());
                        bzFbHurikomiGoukeiListDataSourceBean.setIrYkdtkykhrkmgkkei(creatFBSoukinLstBean.getIrYkdtkykHrkmgkkei());
                        bzFbHurikomiGoukeiListDataSourceBean.setIrGkdtkykhrkmgkkei(creatFBSoukinLstBean.getIrGkdtkykHrkmgkkei());

                        bzFbHurikomiGoukeiListDataSourceBeanLst.add(bzFbHurikomiGoukeiListDataSourceBean);

                    }
                    else {

                        ((BzFbHurikomiGoukeiListDataSourceBean) bzFbHurikomiGoukeiListDataSourceBeanLst.
                            get(bzFbHurikomiGoukeiListDataSourceBeanLst.size() - 1)).setIrHrkmkensu((
                                (BzFbHurikomiGoukeiListDataSourceBean) bzFbHurikomiGoukeiListDataSourceBeanLst.
                                get(bzFbHurikomiGoukeiListDataSourceBeanLst.size() - 1)).
                                getIrHrkmkensu().add(creatFBSoukinLstBean.getIrHrkmkensu()));

                        ((BzFbHurikomiGoukeiListDataSourceBean) bzFbHurikomiGoukeiListDataSourceBeanLst.
                            get(bzFbHurikomiGoukeiListDataSourceBeanLst.size() - 1)).setIrYkdtkykhrkmkensu((
                                (BzFbHurikomiGoukeiListDataSourceBean) bzFbHurikomiGoukeiListDataSourceBeanLst.
                                get(bzFbHurikomiGoukeiListDataSourceBeanLst.size() - 1)).
                                getIrYkdtkykhrkmkensu().add(creatFBSoukinLstBean.getIrYkdtkykHrkmkensu()));

                        ((BzFbHurikomiGoukeiListDataSourceBean) bzFbHurikomiGoukeiListDataSourceBeanLst.
                            get(bzFbHurikomiGoukeiListDataSourceBeanLst.size() - 1)).setIrGkdtkykhrkmkensu((
                                (BzFbHurikomiGoukeiListDataSourceBean) bzFbHurikomiGoukeiListDataSourceBeanLst.
                                get(bzFbHurikomiGoukeiListDataSourceBeanLst.size() - 1)).
                                getIrGkdtkykhrkmkensu().add(creatFBSoukinLstBean.getIrGkdtkykHrkmkensu()));

                        ((BzFbHurikomiGoukeiListDataSourceBean) bzFbHurikomiGoukeiListDataSourceBeanLst.
                            get(bzFbHurikomiGoukeiListDataSourceBeanLst.size() - 1)).setIrHrkmgkkei((
                                (BzFbHurikomiGoukeiListDataSourceBean) bzFbHurikomiGoukeiListDataSourceBeanLst.
                                get(bzFbHurikomiGoukeiListDataSourceBeanLst.size() - 1)).
                                getIrHrkmgkkei().add(creatFBSoukinLstBean.getIrHrkmgkkei()));

                        ((BzFbHurikomiGoukeiListDataSourceBean) bzFbHurikomiGoukeiListDataSourceBeanLst.
                            get(bzFbHurikomiGoukeiListDataSourceBeanLst.size() - 1)).setIrYkdtkykhrkmgkkei((
                                (BzFbHurikomiGoukeiListDataSourceBean) bzFbHurikomiGoukeiListDataSourceBeanLst.
                                get(bzFbHurikomiGoukeiListDataSourceBeanLst.size() - 1)).
                                getIrYkdtkykhrkmgkkei().add(creatFBSoukinLstBean.getIrYkdtkykHrkmgkkei()));

                        ((BzFbHurikomiGoukeiListDataSourceBean) bzFbHurikomiGoukeiListDataSourceBeanLst.
                            get(bzFbHurikomiGoukeiListDataSourceBeanLst.size() - 1)).setIrGkdtkykhrkmgkkei((
                                (BzFbHurikomiGoukeiListDataSourceBean) bzFbHurikomiGoukeiListDataSourceBeanLst.
                                get(bzFbHurikomiGoukeiListDataSourceBeanLst.size() - 1)).
                                getIrGkdtkykhrkmgkkei().add(creatFBSoukinLstBean.getIrGkdtkykHrkmgkkei()));

                    }

                }
                creatFBSoukinLstBeanBefore = creatFBSoukinLstBean;
            }

            if (creatFBSoukinLstBeanLst.size() > 0) {
                outputSumList(bzBatchParam.getSyoriYmd(), creatFBSoukinLstBeanBefore.getSyoruiCdKbn());
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(meisaiKensuu)));
        }
    }

    private void createSumListData(BT_FBSoukinData pBtFBSoukinData, BM_FBSoukinListKanri pBmFBSoukinListKanri) {

        CreatFBSoukinLstBean creatFBSoukinLstBean = SWAKInjector.getInstance(CreatFBSoukinLstBean.class);

        C_TantouCdKbn cTantouCdKbn = null;

        if (pBtFBSoukinData.getGyoumucd().eq(C_Gyoumucd.GK_YENSOUKIN_SK)) {

            cTantouCdKbn = C_TantouCdKbn.DAIRITENJIMUKANRI;
        }
        else if (pBtFBSoukinData.getGyoumucd().eq(C_Gyoumucd.GK_YENSOUKIN_KH_SI) ||
            pBtFBSoukinData.getGyoumucd().eq(C_Gyoumucd.GK_YENSOUKIN_NK_SHR) ||
            pBtFBSoukinData.getGyoumucd().eq(C_Gyoumucd.GK_YENSOUKIN_HAITOU_TUIBARAI_KH)) {

            cTantouCdKbn = C_TantouCdKbn.KAIYAKU;
        }
        else if (pBtFBSoukinData.getGyoumucd().eq(C_Gyoumucd.GK_YENSOUKIN_HAITOU_TUIBARAI_SI)) {

            cTantouCdKbn = C_TantouCdKbn.SIBOUTETUZUKI;
        }
        else {
            cTantouCdKbn = C_TantouCdKbn.DS;
        }

        BM_TantouCd bMTantouCd = bizDomManager.getTantouCd(cTantouCdKbn);

        bMTantouCd = BM_TantouCdDetacher.detachTantouCdtouched(bMTantouCd);

        AM_Sosiki amSosiki = baseDomManager.getSosiki(bMTantouCd.getBusitucd() + ZEROFOUR);

        creatFBSoukinLstBean.setSyoruiCdKbn(pBmFBSoukinListKanri.getFbgoukeisyoruicd());
        creatFBSoukinLstBean.setTantositucd(C_Tantositucd.valueOf(bMTantouCd.getBusitucd()));
        creatFBSoukinLstBean.setIrTantousitunm(amSosiki.getKanjisosikinm20());
        creatFBSoukinLstBean.setShrhousiteikbn(pBtFBSoukinData.getShrhousiteikbn());
        creatFBSoukinLstBean.setIrGyoumucd(pBtFBSoukinData.getGyoumucd());
        creatFBSoukinLstBean.setDenYmd(pBtFBSoukinData.getDenymd());
        creatFBSoukinLstBean.setIrHrkmkensu(BizNumber.ONE);
        creatFBSoukinLstBean.setIrHrkmgkkei(pBtFBSoukinData.getSoukingk());

        if (C_Tuukasyu.JPY.eq(pBtFBSoukinData.getKyktuukasyu())) {
            creatFBSoukinLstBean.setIrYkdtkykHrkmkensu(BizNumber.ONE);
            creatFBSoukinLstBean.setIrGkdtkykHrkmkensu(BizNumber.ZERO);
            creatFBSoukinLstBean.setIrYkdtkykHrkmgkkei(pBtFBSoukinData.getSoukingk());
            creatFBSoukinLstBean.setIrGkdtkykHrkmgkkei(BizCurrency.valueOf(0));

        }
        else {
            creatFBSoukinLstBean.setIrYkdtkykHrkmkensu(BizNumber.ZERO);
            creatFBSoukinLstBean.setIrGkdtkykHrkmkensu(BizNumber.ONE);
            creatFBSoukinLstBean.setIrYkdtkykHrkmgkkei(BizCurrency.valueOf(0));
            creatFBSoukinLstBean.setIrGkdtkykHrkmgkkei(pBtFBSoukinData.getSoukingk());
        }

        creatFBSoukinLstBeanLst.add(creatFBSoukinLstBean);

    }

    private void setDetailListSumValue() {

        ((BzFbSoukinMeisaiListDataSourceBean) bzFbSoukinMeisaiListDataSourceBeanLst.
            get(bzFbSoukinMeisaiListDataSourceBeanLst.size() - 1)).setIrSoukingkkei(soukingk);

    }

    private void createDetailListDSBean(BT_FBSoukinData pBtFBSoukinData
        , BT_FBSoukinHukaInfo pBtFBSoukinHukaInfo, BM_FBSoukinListKanri pBmFBSoukinListKanri, AS_Kinou pAsKinou) {

        BzFbSoukinMeisaiListDataSourceBean bzFbSoukinMeisaiListDataSourceBean = SWAKInjector
            .getInstance(BzFbSoukinMeisaiListDataSourceBean.class);

        bzFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(pBmFBSoukinListKanri.getTantositucd());
        bzFbSoukinMeisaiListDataSourceBean.setIrTantousitunm(cTantouNm);
        bzFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(pBtFBSoukinData.getShrhousiteikbn());
        bzFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd(
            DateFormatUtil.dateKANJISeirekiNoZero(pBtFBSoukinData.getDenymd()));
        bzFbSoukinMeisaiListDataSourceBean.setIrSoukinhukabank(soukinhukabank);
        bzFbSoukinMeisaiListDataSourceBean.setIrGyoumucd(pBtFBSoukinData.getGyoumucd());
        bzFbSoukinMeisaiListDataSourceBean.setIrSyoricd(pBtFBSoukinData.getSyoricd());
        if (pAsKinou.getKinouNm().length() > 15) {

            bzFbSoukinMeisaiListDataSourceBean.setIrSyorinm(pAsKinou.getKinouNm().substring(0,15));
        }
        else {

            bzFbSoukinMeisaiListDataSourceBean.setIrSyorinm(pAsKinou.getKinouNm());
        }
        bzFbSoukinMeisaiListDataSourceBean.setIrSyorisosikicd(syoriSosikiCd);
        bzFbSoukinMeisaiListDataSourceBean.setIrKokyakucd(pBtFBSoukinHukaInfo.getKokcd1());
        bzFbSoukinMeisaiListDataSourceBean.setIrBankcd(pBtFBSoukinData.getBankcd());
        bzFbSoukinMeisaiListDataSourceBean.setIrSitencd(pBtFBSoukinData.getSitencd());
        bzFbSoukinMeisaiListDataSourceBean.setIrYokinkbn(pBtFBSoukinData.getYokinkbn());
        bzFbSoukinMeisaiListDataSourceBean.setIrKouzano(pBtFBSoukinData.getKouzano());
        bzFbSoukinMeisaiListDataSourceBean.setIrKznmkn(pBtFBSoukinData.getKzmeiginmkn());
        bzFbSoukinMeisaiListDataSourceBean.setIrSyono(pBtFBSoukinData.getKeirisyono());
        bzFbSoukinMeisaiListDataSourceBean.setIrSoukingk(pBtFBSoukinData.getSoukingk());

        bzFbSoukinMeisaiListDataSourceBeanLst.add(bzFbSoukinMeisaiListDataSourceBean);

        meisaiKensuu++;
    }

    private void outputDetailList(BizDate pSyoriYmd, C_SyoruiCdKbn pCSyoruiCdKbn) {

        BzFbSoukinMeisaiListBean bzFbSoukinMeisaiListBean = SWAKInjector
            .getInstance(BzFbSoukinMeisaiListBean.class);

        bzFbSoukinMeisaiListBean.setIrSyoriymd(DateFormatUtil.dateKANJISeirekiNoZero(pSyoriYmd));

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(kinou.getSubSystemId(),
            kinou.getCategoryId(), kinou.getKinouId(), pCSyoruiCdKbn);

        reportServicesBean.setSyoriYmd(pSyoriYmd);

        reportServicesBean.addParamObjects(bzFbSoukinMeisaiListDataSourceBeanLst,
            bzFbSoukinMeisaiListBean);

        createReport.exec(reportServicesBean);

        bzFbSoukinMeisaiListDataSourceBeanLst = new ArrayList<>();
    }

    private void outputSumList(BizDate pSyoriYmd, C_SyoruiCdKbn pCSyoruiCdKbn) {

        BzFbHurikomiGoukeiListBean bzFbHurikomiGoukeiListBean = SWAKInjector
            .getInstance(BzFbHurikomiGoukeiListBean.class);

        bzFbHurikomiGoukeiListBean.setIrSyoriymd(DateFormatUtil.dateKANJISeirekiNoZero(pSyoriYmd));

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(kinou.getSubSystemId(),
            kinou.getCategoryId(), kinou.getKinouId(), pCSyoruiCdKbn);

        reportServicesBean.setSyoriYmd(pSyoriYmd);

        reportServicesBean.addParamObjects(bzFbHurikomiGoukeiListDataSourceBeanLst, bzFbHurikomiGoukeiListBean);

        createReport.exec(reportServicesBean);

        bzFbHurikomiGoukeiListDataSourceBeanLst = new ArrayList<>();
    }

    private boolean createAtesakiHumeiFBSoukinData() {

        bzFBSoukinDataAtesakiHumeiBeanLst = new ArrayList<>();
        syoriSosikiCd = "";
        atesakiHumeiKensuu = 0L;

        try (ExDBResults<BT_FBSoukinData> btFBSoukinDataListAtesakiHumei =
            bzFBSoukinListSksDao.getAtesakiHumeiFBSoukinListSksDatas(
                bzBatchParam.getIbKakutyoujobcd(), bzBatchParam.getSyoriYmd());) {

            Iterator<BT_FBSoukinData> iterator = btFBSoukinDataListAtesakiHumei.iterator();

            if (!iterator.hasNext()) {
                return false;
            }

            while (iterator.hasNext()) {
                BT_FBSoukinData btFBSoukinDataAtesakiHumei = iterator.next();
                BT_FBSoukinHukaInfo btFBSoukinHukaInfoAtesakiHumei = btFBSoukinDataAtesakiHumei.getFBSoukinHukaInfo();
                BzFBSoukinDataAtesakiHumeiBean bzFBSoukinDataAtesakiHumeiBean = SWAKInjector.getInstance(BzFBSoukinDataAtesakiHumeiBean.class);

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(btFBSoukinDataAtesakiHumei.getFbsoukindatasikibetukey());

                atesakiHumeiKensuu++;

                C_TantouCdKbn cTantouCdKbn = bizDomManager.getSyoritanto(btFBSoukinDataAtesakiHumei.getSyoricd()).getTantocd();

                syoriSosikiCd = bizDomManager.getTantouCd(cTantouCdKbn).getBusitucd() + ZEROFOUR;

                bzFBSoukinDataAtesakiHumeiBean.setFBSoukinDataAtesakiHumei(btFBSoukinDataAtesakiHumei);
                bzFBSoukinDataAtesakiHumeiBean.setFBSoukinHukaInfoAtesakiHumei(btFBSoukinHukaInfoAtesakiHumei);
                bzFBSoukinDataAtesakiHumeiBean.setFBSoukinListKanriAtesakiHumei(
                    bizDomManager.getFBSoukinListKanri(btFBSoukinDataAtesakiHumei.getSyoricd(), syoriSosikiCd));
                bzFBSoukinDataAtesakiHumeiBean.setSyoriSosikiCd(syoriSosikiCd);

                String soukinHukaBank = getSoukinhukabank(btFBSoukinDataAtesakiHumei);
                bzFBSoukinDataAtesakiHumeiBean.setSoukinHukaBank(soukinHukaBank);

                bzFBSoukinDataAtesakiHumeiBeanLst.add(bzFBSoukinDataAtesakiHumeiBean);
            }
            bzRecoveryDatasikibetuBean.initializeBlank();

            Ordering<BzFBSoukinDataAtesakiHumeiBean> ordering = Ordering.from(new BzFBSoukinDataAtesakiHumeiBeanSortComparator());
            bzFBSoukinDataAtesakiHumeiBeanLst = ordering.sortedCopy(bzFBSoukinDataAtesakiHumeiBeanLst);
        }
        return true;
    }

    private void createAtesakiHumeiDetailList() {

        soukingk = BizCurrency.valueOf(0);
        cTantouNm = "";
        syoriSosikiCd = "";
        BT_FBSoukinData btFBSoukinDataBefore = null;
        BM_FBSoukinListKanri bmFBSoukinListKanriBefore = null;

        for (BzFBSoukinDataAtesakiHumeiBean bzFBSoukinDataAtesakiHumeiBean  : bzFBSoukinDataAtesakiHumeiBeanLst) {

            BT_FBSoukinData btFBSoukinData = bzFBSoukinDataAtesakiHumeiBean.getFBSoukinDataAtesakiHumei();
            BT_FBSoukinHukaInfo btFBSoukinHukaInfo = bzFBSoukinDataAtesakiHumeiBean.getFBSoukinHukaInfoAtesakiHumei();
            BM_FBSoukinListKanri bmFBSoukinListKanri = bzFBSoukinDataAtesakiHumeiBean.getFBSoukinListKanriAtesakiHumei();
            syoriSosikiCd = bzFBSoukinDataAtesakiHumeiBean.getSyoriSosikiCd();

            bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
            bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
            bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
            bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(btFBSoukinData.getFbsoukindatasikibetukey());

            if (btFBSoukinDataBefore == null) {

                AM_Sosiki amSosiki = baseDomManager.getSosiki(bmFBSoukinListKanri.getTantositucd() + ZEROFOUR);

                cTantouNm = amSosiki.getKanjisosikinm20();

                soukingk = btFBSoukinData.getSoukingk();

                if (!bmFBSoukinListKanri.getFbgoukeisyoruicd().equals(C_SyoruiCdKbn.BLNK)) {
                    createSumListData(btFBSoukinData, bmFBSoukinListKanri);
                }

            }
            else {

                if (!bmFBSoukinListKanriBefore.getTantositucd().eq(bmFBSoukinListKanri.getTantositucd())) {

                    AM_Sosiki amSosiki = baseDomManager.getSosiki(bmFBSoukinListKanri.getTantositucd() + ZEROFOUR);

                    cTantouNm = amSosiki.getKanjisosikinm20();
                }

                if (!bmFBSoukinListKanri.getFbgoukeisyoruicd().equals(C_SyoruiCdKbn.BLNK)) {
                    if (!bmFBSoukinListKanriBefore.getFbmeisaisyoruicd().
                        eq(bmFBSoukinListKanri.getFbmeisaisyoruicd()) ||
                        !bmFBSoukinListKanriBefore.getTantositucd().eq(bmFBSoukinListKanri.getTantositucd()) ||
                        !btFBSoukinDataBefore.getShrhousiteikbn().eq(btFBSoukinData.getShrhousiteikbn()) ||
                        !btFBSoukinDataBefore.getGyoumucd().eq(btFBSoukinData.getGyoumucd())) {

                        createSumListData(btFBSoukinData, bmFBSoukinListKanri);
                    }
                    else {
                        creatFBSoukinLstBeanLst.get(creatFBSoukinLstBeanLst.size() - 1).setIrHrkmkensu(
                            creatFBSoukinLstBeanLst.get(creatFBSoukinLstBeanLst.size() - 1).
                            getIrHrkmkensu().add(BizNumber.ONE));

                        creatFBSoukinLstBeanLst.get(creatFBSoukinLstBeanLst.size() - 1).setIrHrkmgkkei(
                            creatFBSoukinLstBeanLst.get(creatFBSoukinLstBeanLst.size() - 1).getIrHrkmgkkei()
                            .add(btFBSoukinData.getSoukingk()));

                        if (C_Tuukasyu.JPY.eq(btFBSoukinData.getKyktuukasyu())) {

                            creatFBSoukinLstBeanLst.get(creatFBSoukinLstBeanLst.size() - 1).setIrYkdtkykHrkmkensu(
                                creatFBSoukinLstBeanLst.get(creatFBSoukinLstBeanLst.size() - 1).
                                getIrYkdtkykHrkmkensu().add(BizNumber.ONE));

                            creatFBSoukinLstBeanLst.get(creatFBSoukinLstBeanLst.size() - 1).setIrYkdtkykHrkmgkkei(
                                creatFBSoukinLstBeanLst.get(creatFBSoukinLstBeanLst.size() - 1).getIrYkdtkykHrkmgkkei()
                                .add(btFBSoukinData.getSoukingk()));

                        }

                        else {
                            creatFBSoukinLstBeanLst.get(creatFBSoukinLstBeanLst.size() - 1).setIrGkdtkykHrkmkensu(
                                creatFBSoukinLstBeanLst.get(creatFBSoukinLstBeanLst.size() - 1).
                                getIrGkdtkykHrkmkensu().add(BizNumber.ONE));

                            creatFBSoukinLstBeanLst.get(creatFBSoukinLstBeanLst.size() - 1).setIrGkdtkykHrkmgkkei(
                                creatFBSoukinLstBeanLst.get(creatFBSoukinLstBeanLst.size() - 1).getIrGkdtkykHrkmgkkei()
                                .add(btFBSoukinData.getSoukingk()));
                        }
                    }
                }

                if (!bmFBSoukinListKanriBefore.getFbmeisaisyoruicd().
                    eq(bmFBSoukinListKanri.getFbmeisaisyoruicd()) ||
                    !bmFBSoukinListKanriBefore.getTantositucd().eq(bmFBSoukinListKanri.getTantositucd()) ||
                    !btFBSoukinDataBefore.getShrhousiteikbn().eq(btFBSoukinData.getShrhousiteikbn()) ||
                    !btFBSoukinDataBefore.getGyoumucd().eq(btFBSoukinData.getGyoumucd()) ||
                    !btFBSoukinDataBefore.getBankcd().equals(btFBSoukinData.getBankcd()) ||
                    !btFBSoukinDataBefore.getSitencd().equals(btFBSoukinData.getSitencd()) ||
                    !btFBSoukinDataBefore.getYokinkbn().eq(btFBSoukinData.getYokinkbn()) ||
                    !btFBSoukinDataBefore.getKouzano().equals(btFBSoukinData.getKouzano()) ||
                    !btFBSoukinDataBefore.getKzmeiginmkn().equals(btFBSoukinData.getKzmeiginmkn())) {

                    setDetailListSumValue();

                    soukingk = btFBSoukinData.getSoukingk();
                }
                else {

                    soukingk = soukingk.add(btFBSoukinData.getSoukingk());
                }

                if (!bmFBSoukinListKanriBefore.getFbmeisaisyoruicd().
                    eq(bmFBSoukinListKanri.getFbmeisaisyoruicd())) {

                    outputDetailList(bzBatchParam.getSyoriYmd(), bmFBSoukinListKanriBefore.getFbmeisaisyoruicd());
                }
            }
            AS_Kinou asKinou = baseDomManager.getKinousBySyoricd(btFBSoukinData.getSyoricd()).get(ZERO);

            createDetailListDSBean(btFBSoukinData, btFBSoukinHukaInfo, bmFBSoukinListKanri, asKinou);

            btFBSoukinDataBefore = btFBSoukinData;
            bmFBSoukinListKanriBefore = bmFBSoukinListKanri;
        }
        setDetailListSumValue();

        outputDetailList(bzBatchParam.getSyoriYmd(), bmFBSoukinListKanriBefore.getFbmeisaisyoruicd());

        bzRecoveryDatasikibetuBean.initializeBlank();

    }

    private String getSoukinhukabank(BT_FBSoukinData pBtFBSoukinData) {

        String soukinhukabank = "";
        if (C_FbSoukinBatchKbn.BATCH.eq(pBtFBSoukinData.getFbsoukinbatchkbn())) {
            BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);

            BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(pBtFBSoukinData.getBankcd(),
                pBtFBSoukinData.getSitencd());

            if (C_BankmasterUmuKbn.NONE.eq(bzGetBankDataBean.getBankmasterUmuKbn()) ||
                C_Kokunaikwskameihyj.MIKAMEI.eq(bzGetBankDataBean.getKokunaikwskameihyj())) {
                soukinhukabank = SOUKINHUKABANK;
            }
        }

        return soukinhukabank;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}