package yuyu.batch.biz.bzkaikei.bzgkfbsoukinlistsks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.google.common.collect.Ordering;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.bzkaikei.bzgkfbsoukinlistsks.dba.BzGkFBSoukinListSksDao;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.bean.report.BzGkFbHurikomiGoukeiListBean;
import yuyu.def.biz.bean.report.BzGkFbHurikomiGoukeiListDataSourceBean;
import yuyu.def.biz.bean.report.BzGkFbSoukinMeisaiListBean;
import yuyu.def.biz.bean.report.BzGkFbSoukinMeisaiListDataSourceBean;
import yuyu.def.biz.bean.report.BzGkOnlineFbSoukinMeisaiListBean;
import yuyu.def.biz.bean.report.BzGkOnlineFbSoukinMeisaiListDataSourceBean;
import yuyu.def.biz.detacher.BM_TantouCdDetacher;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.AM_Sosiki;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_FBSoukinListKanri;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.entity.BT_GkFBSoukinData;
import yuyu.def.db.entity.BT_GkFBSoukinHukaInfo;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 業務共通 経理・会計 外貨ＦＢ送金リスト作成クラス
 */
public class BzGkFBSoukinListSksBatch implements Batch {

    private static final String ONLINE = "RGEHD000";

    private static final String FILTERID = "Bz107";

    private static final String ZEROFOUR = "0000";

    private static final int ZERO = 0;

    private static final int KETA_START= 0;

    private static final int KETA_END= 15;

    private Long meisaiKensuu ;

    private String tantouNm ;

    private List<CreatGKFBSoukinLstBean> creatGKFBSoukinLstBeanLst = new ArrayList<>() ;

    private List<IReportDataSouceBean> bzOnlineFbSoukinMeisaiListDataSourceBeanLst = new ArrayList<>();

    private List<IReportDataSouceBean> bzFbSoukinMeisaiListDataSourceBeanLst = new ArrayList<>();

    private List<IReportDataSouceBean> bzFbHurikomiGoukeiListDataSourceBeanLst = new ArrayList<>();

    private List<BzGkFBSoukinListDataBean> bzGkFBSoukinListDataBeanList = new ArrayList<>();

    private String syorisosikiCd;

    private Long atesakihumeiKensuu;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private CreateReport createReport;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private BzGkFBSoukinListSksDao bzGkFBSoukinListSksDao;

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
        tantouNm = "";
        BT_GkFBSoukinData btGKFBSoukinDataBefore = null;
        BM_FBSoukinListKanri bmFBSoukinListKanriBefore = null;
        creatGKFBSoukinLstBeanLst = new ArrayList<>();
        syorisosikiCd = "";

        try (ExDBResults<BT_GkFBSoukinData> btGkFBSoukinDataList =
            bzGkFBSoukinListSksDao.getAtesakiAriGkFBSoukinListSksDatas(bzBatchParam.getIbKakutyoujobcd(),
                bzBatchParam.getSyoriYmd())) {

            Iterator<BT_GkFBSoukinData> iterator = btGkFBSoukinDataList.iterator();

            if (!iterator.hasNext()) {
                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(meisaiKensuu)));
                return;
            }

            while (iterator.hasNext()) {

                BT_GkFBSoukinData btGKFBSoukinData = iterator.next();
                BT_GkFBSoukinHukaInfo btFBSoukinHukaInfo = btGKFBSoukinData.getGkFBSoukinHukaInfo();
                BM_FBSoukinListKanri bmFBSoukinListKanri = btGKFBSoukinData.getFBSoukinListKanri();
                syorisosikiCd = btGKFBSoukinData.getSyorisosikicd();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(BT_GkFBSoukinData.TABLE_NAME);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(btGKFBSoukinData.getFbsoukindatasikibetukey());

                if(btGKFBSoukinDataBefore == null) {

                    AM_Sosiki AM_Sosiki = baseDomManager.getSosiki(bmFBSoukinListKanri.getTantositucd() + ZEROFOUR);

                    tantouNm = AM_Sosiki.getKanjisosikinm20();

                    createGKsumListData(btGKFBSoukinData, btFBSoukinHukaInfo, bmFBSoukinListKanri);

                }
                else {

                    if(!bmFBSoukinListKanriBefore.getTantositucd().eq(bmFBSoukinListKanri.getTantositucd())) {

                        AM_Sosiki AM_Sosiki = baseDomManager.getSosiki(bmFBSoukinListKanri.getTantositucd() + ZEROFOUR);

                        tantouNm = AM_Sosiki.getKanjisosikinm20();
                    }

                    if(!bmFBSoukinListKanriBefore.getGkfbmeisaisyoruicd().
                        eq(bmFBSoukinListKanri.getGkfbmeisaisyoruicd()) ||
                        !bmFBSoukinListKanriBefore.getTantositucd().eq(bmFBSoukinListKanri.getTantositucd()) ||
                        !btGKFBSoukinDataBefore.getShrhousiteikbn().eq(btGKFBSoukinData.getShrhousiteikbn()) ||
                        !btGKFBSoukinDataBefore.getGkgyoumucd().eq(btGKFBSoukinData.getGkgyoumucd()) ||
                        !btGKFBSoukinDataBefore.getDenymd().equals(btGKFBSoukinData.getDenymd()) ||
                        !btGKFBSoukinDataBefore.getShrtuukasyu().equals(btGKFBSoukinData.getShrtuukasyu())) {

                        createGKsumListData(btGKFBSoukinData, btFBSoukinHukaInfo, bmFBSoukinListKanri );

                    }
                    else {

                        creatGKFBSoukinLstBeanLst.get(creatGKFBSoukinLstBeanLst.size() - 1).setIrHrkmkensu(
                            creatGKFBSoukinLstBeanLst.get(creatGKFBSoukinLstBeanLst.size() - 1).
                            getIrHrkmkensu().add(BizNumber.ONE));

                        creatGKFBSoukinLstBeanLst.get(creatGKFBSoukinLstBeanLst.size() - 1).setIrHrkmgkkei(
                            creatGKFBSoukinLstBeanLst.get(creatGKFBSoukinLstBeanLst.size() - 1).getIrHrkmgkkei().
                            add(btGKFBSoukinData.getGaikashrgk()));

                        creatGKFBSoukinLstBeanLst.get(creatGKFBSoukinLstBeanLst.size() - 1).setDenpyogkkei(
                            creatGKFBSoukinLstBeanLst.get(creatGKFBSoukinLstBeanLst.size() - 1).getDenpyogkkei().
                            add(btFBSoukinHukaInfo.getDengk()));

                    }

                    if(!bmFBSoukinListKanriBefore.getGkfbmeisaisyoruicd().eq(
                        bmFBSoukinListKanri.getGkfbmeisaisyoruicd())) {

                        outputGKDetailList(bmFBSoukinListKanriBefore.getGkfbmeisaisyoruicd());
                    }

                }

                AS_Kinou asKinou = baseDomManager.getKinousBySyoricd(btGKFBSoukinData.getSyoricd()).get(ZERO);

                createGKDetailListDSBean(btGKFBSoukinData, btFBSoukinHukaInfo, bmFBSoukinListKanri, asKinou);

                btGKFBSoukinDataBefore = btGKFBSoukinData;
                bmFBSoukinListKanriBefore = bmFBSoukinListKanri;
            }

            outputGKDetailList(bmFBSoukinListKanriBefore.getGkfbmeisaisyoruicd());

            bzRecoveryDatasikibetuBean.initializeBlank();

            if (createAtesakiHumeiGkFBSoukinListData()) {

                createAtesakiHumeiListData();
            }

            CreatGKFBSoukinLstBean creatFBSoukinLstBeanBefore = null;

            Ordering<CreatGKFBSoukinLstBean> ordering = Ordering.from(new CreatGKFBSoukinLstBeanSortComparator());
            creatGKFBSoukinLstBeanLst = ordering.sortedCopy(creatGKFBSoukinLstBeanLst);


            for (CreatGKFBSoukinLstBean creatFBSoukinLstBean : creatGKFBSoukinLstBeanLst) {

                if(creatFBSoukinLstBeanBefore == null) {

                    BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean =
                        SWAKInjector.getInstance(BzGkFbHurikomiGoukeiListDataSourceBean.class);

                    bzFbHurikomiGoukeiListDataSourceBean.setIrTantousitucd(creatFBSoukinLstBean.getTantositucd());
                    bzFbHurikomiGoukeiListDataSourceBean.setIrTantousitunm(creatFBSoukinLstBean.getIrTantousitunm());
                    bzFbHurikomiGoukeiListDataSourceBean.setIrShrhousiteikbn(creatFBSoukinLstBean.getShrhousiteikbn());
                    bzFbHurikomiGoukeiListDataSourceBean.
                    setIrHrkmsiteiymd(DateFormatUtil.dateKANJISeirekiNoZero(creatFBSoukinLstBean.getDenYmd()));
                    bzFbHurikomiGoukeiListDataSourceBean.setIrGkgyoumucd(creatFBSoukinLstBean.getIrGyoumucd());
                    bzFbHurikomiGoukeiListDataSourceBean.setIrShrtuukasyu(creatFBSoukinLstBean.getTuukasyu());
                    bzFbHurikomiGoukeiListDataSourceBean.setIrHrkmkensu(creatFBSoukinLstBean.getIrHrkmkensu());
                    bzFbHurikomiGoukeiListDataSourceBean.setIrHrkmgkkei(creatFBSoukinLstBean.getIrHrkmgkkei());
                    bzFbHurikomiGoukeiListDataSourceBean.setIrDenpyogkkei(creatFBSoukinLstBean.getDenpyogkkei());

                    bzFbHurikomiGoukeiListDataSourceBeanLst.add(bzFbHurikomiGoukeiListDataSourceBean);

                }
                else {

                    if(!creatFBSoukinLstBeanBefore.getSyoruiCdKbn().eq(creatFBSoukinLstBean.getSyoruiCdKbn())) {

                        outputGKSumList(creatFBSoukinLstBeanBefore.getSyoruiCdKbn());
                    }
                    if( !creatFBSoukinLstBeanBefore.getSyoruiCdKbn().eq(creatFBSoukinLstBean.getSyoruiCdKbn()) ||
                        !creatFBSoukinLstBeanBefore.getShrhousiteikbn().eq(creatFBSoukinLstBean.getShrhousiteikbn()) ||
                        !creatFBSoukinLstBeanBefore.getDenYmd().equals(creatFBSoukinLstBean.getDenYmd()) ||
                        !creatFBSoukinLstBeanBefore.getIrGyoumucd().eq(creatFBSoukinLstBean.getIrGyoumucd()) ||
                        !creatFBSoukinLstBeanBefore.getTuukasyu().eq(creatFBSoukinLstBean.getTuukasyu())) {

                        BzGkFbHurikomiGoukeiListDataSourceBean bzFbHurikomiGoukeiListDataSourceBean =
                            SWAKInjector.getInstance(BzGkFbHurikomiGoukeiListDataSourceBean.class);

                        bzFbHurikomiGoukeiListDataSourceBean.
                        setIrTantousitucd(creatFBSoukinLstBean.getTantositucd());
                        bzFbHurikomiGoukeiListDataSourceBean.
                        setIrTantousitunm(creatFBSoukinLstBean.getIrTantousitunm());
                        bzFbHurikomiGoukeiListDataSourceBean.
                        setIrShrhousiteikbn(creatFBSoukinLstBean.getShrhousiteikbn());
                        bzFbHurikomiGoukeiListDataSourceBean.
                        setIrHrkmsiteiymd(DateFormatUtil.dateKANJISeirekiNoZero(creatFBSoukinLstBean.getDenYmd()));
                        bzFbHurikomiGoukeiListDataSourceBean.setIrGkgyoumucd(creatFBSoukinLstBean.getIrGyoumucd());
                        bzFbHurikomiGoukeiListDataSourceBean.setIrShrtuukasyu(creatFBSoukinLstBean.getTuukasyu());
                        bzFbHurikomiGoukeiListDataSourceBean.setIrHrkmkensu(creatFBSoukinLstBean.getIrHrkmkensu());
                        bzFbHurikomiGoukeiListDataSourceBean.setIrHrkmgkkei(creatFBSoukinLstBean.getIrHrkmgkkei());
                        bzFbHurikomiGoukeiListDataSourceBean.
                        setIrDenpyogkkei(creatFBSoukinLstBean.getDenpyogkkei());

                        bzFbHurikomiGoukeiListDataSourceBeanLst.add(bzFbHurikomiGoukeiListDataSourceBean);

                    }
                    else {

                        ((BzGkFbHurikomiGoukeiListDataSourceBean)bzFbHurikomiGoukeiListDataSourceBeanLst.
                            get(bzFbHurikomiGoukeiListDataSourceBeanLst.size() - 1)).setIrHrkmkensu((
                                (BzGkFbHurikomiGoukeiListDataSourceBean)bzFbHurikomiGoukeiListDataSourceBeanLst.
                                get(bzFbHurikomiGoukeiListDataSourceBeanLst.size() - 1)).
                                getIrHrkmkensu().add(creatFBSoukinLstBean.getIrHrkmkensu()));

                        ((BzGkFbHurikomiGoukeiListDataSourceBean)bzFbHurikomiGoukeiListDataSourceBeanLst.
                            get(bzFbHurikomiGoukeiListDataSourceBeanLst.size() - 1)).setIrHrkmgkkei((
                                (BzGkFbHurikomiGoukeiListDataSourceBean)bzFbHurikomiGoukeiListDataSourceBeanLst.
                                get(bzFbHurikomiGoukeiListDataSourceBeanLst.size() - 1)).
                                getIrHrkmgkkei().add(creatFBSoukinLstBean.getIrHrkmgkkei()));

                        ((BzGkFbHurikomiGoukeiListDataSourceBean)bzFbHurikomiGoukeiListDataSourceBeanLst.
                            get(bzFbHurikomiGoukeiListDataSourceBeanLst.size() - 1)).setIrDenpyogkkei((
                                (BzGkFbHurikomiGoukeiListDataSourceBean)bzFbHurikomiGoukeiListDataSourceBeanLst.
                                get(bzFbHurikomiGoukeiListDataSourceBeanLst.size() - 1)).
                                getIrDenpyogkkei().add(creatFBSoukinLstBean.getDenpyogkkei()));

                    }
                }

                creatFBSoukinLstBeanBefore = creatFBSoukinLstBean;

            }
            outputGKSumList(creatFBSoukinLstBeanBefore.getSyoruiCdKbn());

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(meisaiKensuu)));
        }
    }

    private void createGKsumListData(BT_GkFBSoukinData pBtGKFBSoukinData, BT_GkFBSoukinHukaInfo pBtGkFBSoukinHukaInfo,
        BM_FBSoukinListKanri pBmFBSoukinListKanri) {

        CreatGKFBSoukinLstBean creatGKFBSoukinLstBean = SWAKInjector.getInstance(CreatGKFBSoukinLstBean.class);

        C_TantouCdKbn  cTantouCdKbn = null;

        if(pBtGKFBSoukinData.getGkgyoumucd().eq(C_Gkgyoumucd .GK_GKSOUKIN_SK)) {

            cTantouCdKbn = C_TantouCdKbn.DAIRITENJIMUKANRI;

        }
        else {
            cTantouCdKbn = C_TantouCdKbn.KAIYAKU;
        }

        BM_TantouCd bMTantouCd = bizDomManager.getTantouCd(cTantouCdKbn);

        bMTantouCd = BM_TantouCdDetacher.detachTantouCdtouched(bMTantouCd);

        AM_Sosiki amSosiki = baseDomManager.getSosiki(bMTantouCd.getBusitucd() + ZEROFOUR);

        creatGKFBSoukinLstBean.setSyoruiCdKbn(pBmFBSoukinListKanri.getGkfbgoukeisyoruicd());
        creatGKFBSoukinLstBean.setTantositucd(C_Tantositucd.valueOf(bMTantouCd.getBusitucd()));
        creatGKFBSoukinLstBean.setIrTantousitunm(amSosiki.getKanjisosikinm20());
        creatGKFBSoukinLstBean.setShrhousiteikbn(pBtGKFBSoukinData.getShrhousiteikbn());
        creatGKFBSoukinLstBean.setIrGyoumucd(pBtGKFBSoukinData.getGkgyoumucd());
        creatGKFBSoukinLstBean.setTuukasyu(pBtGKFBSoukinData.getShrtuukasyu());
        creatGKFBSoukinLstBean.setDenYmd(pBtGKFBSoukinData.getDenymd());
        creatGKFBSoukinLstBean.setIrHrkmkensu(BizNumber.ONE);
        creatGKFBSoukinLstBean.setIrHrkmgkkei(pBtGKFBSoukinData.getGaikashrgk());
        creatGKFBSoukinLstBean.setDenpyogkkei(pBtGkFBSoukinHukaInfo.getDengk());

        creatGKFBSoukinLstBeanLst.add(creatGKFBSoukinLstBean);
    }

    private void createGKDetailListDSBean(BT_GkFBSoukinData pBtFBSoukinData,
        BT_GkFBSoukinHukaInfo pBtGKFBSoukinHukaInfo, BM_FBSoukinListKanri pBmFBSoukinListKanri, AS_Kinou pAsKinou) {

        if(ONLINE.equals(bzBatchParam.getIbKakutyoujobcd())) {

            BzGkOnlineFbSoukinMeisaiListDataSourceBean bzOnlineFbSoukinMeisaiListDataSourceBean = SWAKInjector
                .getInstance(BzGkOnlineFbSoukinMeisaiListDataSourceBean.class);

            bzOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(
                pBmFBSoukinListKanri.getTantositucd());
            bzOnlineFbSoukinMeisaiListDataSourceBean.setIrTantousitunm(tantouNm);
            bzOnlineFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(
                pBtFBSoukinData.getShrhousiteikbn());
            bzOnlineFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd(
                DateFormatUtil.dateKANJISeirekiNoZero(pBtFBSoukinData.getDenymd()));
            bzOnlineFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(pBtFBSoukinData.getGkgyoumucd());
            bzOnlineFbSoukinMeisaiListDataSourceBean.setIrSyoricd(pBtFBSoukinData.getSyoricd());
            if (pAsKinou.getKinouNm().length() > KETA_END) {
                bzOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorinm(pAsKinou.getKinouNm().substring(KETA_START, KETA_END));
            } else {
                bzOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorinm(pAsKinou.getKinouNm());
            }
            bzOnlineFbSoukinMeisaiListDataSourceBean.setIrSyorisosikicd(syorisosikiCd);
            bzOnlineFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd(pBtGKFBSoukinHukaInfo.getFbtrhksyoukaino());
            bzOnlineFbSoukinMeisaiListDataSourceBean.setIrBankcd(pBtFBSoukinData.getBankcd());
            bzOnlineFbSoukinMeisaiListDataSourceBean.setIrBanknmej(pBtFBSoukinData.getBanknmej());
            bzOnlineFbSoukinMeisaiListDataSourceBean.setIrSitencd(pBtFBSoukinData.getSitencd());
            bzOnlineFbSoukinMeisaiListDataSourceBean.setIrSitennmej(pBtFBSoukinData.getSitennmej());
            bzOnlineFbSoukinMeisaiListDataSourceBean.setIrKouzano(pBtFBSoukinData.getKouzano());
            bzOnlineFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej(pBtFBSoukinData.getKzmeiginmei());
            bzOnlineFbSoukinMeisaiListDataSourceBean.setIrSyono(pBtFBSoukinData.getKeirisyono());
            bzOnlineFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(pBtFBSoukinData.getShrtuukasyu());
            bzOnlineFbSoukinMeisaiListDataSourceBean.setIrSoukingk(pBtFBSoukinData.getGaikashrgk());

            bzOnlineFbSoukinMeisaiListDataSourceBeanLst.add(bzOnlineFbSoukinMeisaiListDataSourceBean);

        }
        else {

            BzGkFbSoukinMeisaiListDataSourceBean bzFbSoukinMeisaiListDataSourceBean = SWAKInjector
                .getInstance(BzGkFbSoukinMeisaiListDataSourceBean.class);

            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitucd(pBmFBSoukinListKanri.getTantositucd());
            bzFbSoukinMeisaiListDataSourceBean.setIrTantousitunm(tantouNm);
            bzFbSoukinMeisaiListDataSourceBean.setIrShrhousiteikbn(pBtFBSoukinData.getShrhousiteikbn());
            bzFbSoukinMeisaiListDataSourceBean.setIrHrkmsiteiymd(
                DateFormatUtil.dateKANJISeirekiNoZero(pBtFBSoukinData.getDenymd()));
            bzFbSoukinMeisaiListDataSourceBean.setIrGkgyoumucd(pBtFBSoukinData.getGkgyoumucd());
            bzFbSoukinMeisaiListDataSourceBean.setIrGkkokyakucd(pBtGKFBSoukinHukaInfo.getFbtrhksyoukaino());
            bzFbSoukinMeisaiListDataSourceBean.setIrBankcd(pBtFBSoukinData.getBankcd());
            bzFbSoukinMeisaiListDataSourceBean.setIrBanknmej(pBtFBSoukinData.getBanknmej());
            bzFbSoukinMeisaiListDataSourceBean.setIrSitencd(pBtFBSoukinData.getSitencd());
            bzFbSoukinMeisaiListDataSourceBean.setIrSitennmej(pBtFBSoukinData.getSitennmej());
            bzFbSoukinMeisaiListDataSourceBean.setIrKouzano(pBtFBSoukinData.getKouzano());
            bzFbSoukinMeisaiListDataSourceBean.setIrKzmeiginmej(pBtFBSoukinData.getKzmeiginmei());
            bzFbSoukinMeisaiListDataSourceBean.setIrSyono(pBtFBSoukinData.getKeirisyono());
            bzFbSoukinMeisaiListDataSourceBean.setIrShrtuukasyu(pBtFBSoukinData.getShrtuukasyu());
            bzFbSoukinMeisaiListDataSourceBean.setIrSoukingk(pBtFBSoukinData.getGaikashrgk());

            bzFbSoukinMeisaiListDataSourceBeanLst.add(bzFbSoukinMeisaiListDataSourceBean);
        }

        meisaiKensuu++;
    }

    private void outputGKDetailList(C_SyoruiCdKbn pCSyoruiCdKbn) {

        if(ONLINE.equals(bzBatchParam.getIbKakutyoujobcd())) {

            BzGkOnlineFbSoukinMeisaiListBean bzOnlineFbSoukinMeisaiListBean = SWAKInjector
                .getInstance(BzGkOnlineFbSoukinMeisaiListBean.class);

            bzOnlineFbSoukinMeisaiListBean.setIrSyoriymd(DateFormatUtil.dateKANJISeirekiNoZero(bzBatchParam
                .getSyoriYmd()));

            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                kinou.getSubSystemId(), kinou.getCategoryId(), kinou.getKinouId(), pCSyoruiCdKbn);

            reportServicesBean.setSyoriYmd(bzBatchParam.getSyoriYmd());

            reportServicesBean.addParamObjects(bzOnlineFbSoukinMeisaiListDataSourceBeanLst,
                bzOnlineFbSoukinMeisaiListBean);

            createReport.exec(reportServicesBean);

            bzOnlineFbSoukinMeisaiListDataSourceBeanLst = new ArrayList<>();

        }
        else {

            BzGkFbSoukinMeisaiListBean bzFbSoukinMeisaiListBean = SWAKInjector
                .getInstance(BzGkFbSoukinMeisaiListBean.class);

            bzFbSoukinMeisaiListBean.setIrSyoriymd(DateFormatUtil.dateKANJISeirekiNoZero(bzBatchParam.getSyoriYmd()));

            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(kinou.getSubSystemId(),
                kinou.getCategoryId(), kinou.getKinouId(), pCSyoruiCdKbn);

            reportServicesBean.setSyoriYmd(bzBatchParam.getSyoriYmd());

            reportServicesBean.addParamObjects(bzFbSoukinMeisaiListDataSourceBeanLst, bzFbSoukinMeisaiListBean);

            createReport.exec(reportServicesBean);

            bzFbSoukinMeisaiListDataSourceBeanLst = new ArrayList<>();
        }
    }

    private void outputGKSumList(C_SyoruiCdKbn pCSyoruiCdKbn) {

        BzGkFbHurikomiGoukeiListBean bzFbHurikomiGoukeiListBean =
            SWAKInjector.getInstance(BzGkFbHurikomiGoukeiListBean.class);

        bzFbHurikomiGoukeiListBean.setIrSyoriymd(DateFormatUtil.dateKANJISeirekiNoZero(bzBatchParam.getSyoriYmd()));

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(kinou.getSubSystemId(),
            kinou.getCategoryId(), kinou.getKinouId(), pCSyoruiCdKbn);

        reportServicesBean.setSyoriYmd(bzBatchParam.getSyoriYmd());

        reportServicesBean.addParamObjects(bzFbHurikomiGoukeiListDataSourceBeanLst, bzFbHurikomiGoukeiListBean);

        createReport.exec(reportServicesBean);

        bzFbHurikomiGoukeiListDataSourceBeanLst = new ArrayList<>();

    }

    private boolean createAtesakiHumeiGkFBSoukinListData() {

        try (ExDBResults<BT_GkFBSoukinData> btGkFBSoukinDataList = bzGkFBSoukinListSksDao.
            getAtesakiHumeiGkFBSoukinListSksDatas(bzBatchParam.getIbKakutyoujobcd(), bzBatchParam.getSyoriYmd())) {

            Iterator<BT_GkFBSoukinData> iterator = btGkFBSoukinDataList.iterator();

            if (!iterator.hasNext()) {

                return false;
            }

            bzGkFBSoukinListDataBeanList = new ArrayList<>();

            syorisosikiCd = "";

            atesakihumeiKensuu = 0L;

            while (iterator.hasNext()) {

                BT_GkFBSoukinData btGKFBSoukinData = iterator.next();

                BT_GkFBSoukinHukaInfo btGkFBSoukinHukaInfo = btGKFBSoukinData.getGkFBSoukinHukaInfo();

                BzGkFBSoukinListDataBean bzGkFBSoukinListDataBean = SWAKInjector.getInstance(
                    BzGkFBSoukinListDataBean.class);

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(BT_GkFBSoukinData.TABLE_NAME);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(btGKFBSoukinData.getFbsoukindatasikibetukey());

                atesakihumeiKensuu++;

                C_TantouCdKbn tantocd = bizDomManager.getSyoritanto(btGKFBSoukinData.getSyoricd()).getTantocd();

                syorisosikiCd = bizDomManager.getTantouCd(tantocd).getBusitucd() + ZEROFOUR;

                bzGkFBSoukinListDataBean.setBtGkFBSoukinData(btGKFBSoukinData);

                bzGkFBSoukinListDataBean.setBtGkFBSoukinHukaInfo(btGkFBSoukinHukaInfo);

                bzGkFBSoukinListDataBean.setBmFBSoukinListKanri(
                    bizDomManager.getFBSoukinListKanri(btGKFBSoukinData.getSyoricd(), syorisosikiCd));

                bzGkFBSoukinListDataBean.setSyorisosikiCd(syorisosikiCd);

                bzGkFBSoukinListDataBeanList.add(bzGkFBSoukinListDataBean);
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            Ordering<BzGkFBSoukinListDataBean> ordering = Ordering
                .from(new CreatBzGkFBSoukinListDataBeanSortComparator());
            bzGkFBSoukinListDataBeanList = ordering.sortedCopy(bzGkFBSoukinListDataBeanList);

            return true;
        }
    }

    private void createAtesakiHumeiListData() {

        tantouNm = "";

        syorisosikiCd = "";

        BT_GkFBSoukinData btGKFBSoukinDataBefore = null;

        BM_FBSoukinListKanri bmFBSoukinListKanriBefore = null;

        for (BzGkFBSoukinListDataBean bzGkFBSoukinListDataBean : bzGkFBSoukinListDataBeanList) {

            BT_GkFBSoukinData btGkFBSoukinData = bzGkFBSoukinListDataBean.getBtGkFBSoukinData();

            BT_GkFBSoukinHukaInfo btGkFBSoukinHukaInfo = bzGkFBSoukinListDataBean.getBtGkFBSoukinHukaInfo();

            BM_FBSoukinListKanri bmFBSoukinListKanri = bzGkFBSoukinListDataBean.getBmFBSoukinListKanri();

            syorisosikiCd = bzGkFBSoukinListDataBean.getSyorisosikiCd();

            bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
            bzRecoveryDatasikibetuBean.setIbTableid(BT_GkFBSoukinData.TABLE_NAME);
            bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
            bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(btGkFBSoukinData.getFbsoukindatasikibetukey());

            if (btGKFBSoukinDataBefore == null) {

                AM_Sosiki amSosiki = baseDomManager.getSosiki(bmFBSoukinListKanri.getTantositucd() + ZEROFOUR);

                tantouNm = amSosiki.getKanjisosikinm20();

                createGKsumListData(btGkFBSoukinData, btGkFBSoukinHukaInfo, bmFBSoukinListKanri);
            }
            else {

                if (!bmFBSoukinListKanriBefore.getTantositucd().eq(bmFBSoukinListKanri.getTantositucd())) {

                    AM_Sosiki amSosiki = baseDomManager.getSosiki(bmFBSoukinListKanri.getTantositucd() + ZEROFOUR);

                    tantouNm = amSosiki.getKanjisosikinm20();
                }

                if (!bmFBSoukinListKanriBefore.getGkfbmeisaisyoruicd().eq(bmFBSoukinListKanri.getGkfbmeisaisyoruicd()) ||
                    !bmFBSoukinListKanriBefore.getTantositucd().eq(bmFBSoukinListKanri.getTantositucd()) ||
                    !btGKFBSoukinDataBefore.getShrhousiteikbn().eq(btGkFBSoukinData.getShrhousiteikbn()) ||
                    !btGKFBSoukinDataBefore.getDenymd().equals(btGkFBSoukinData.getDenymd()) ||
                    !btGKFBSoukinDataBefore.getGkgyoumucd().eq(btGkFBSoukinData.getGkgyoumucd())||
                    !btGKFBSoukinDataBefore.getShrtuukasyu().eq(btGkFBSoukinData.getShrtuukasyu())) {

                    createGKsumListData(btGkFBSoukinData, btGkFBSoukinHukaInfo, bmFBSoukinListKanri);
                }
                else {

                    creatGKFBSoukinLstBeanLst.get(creatGKFBSoukinLstBeanLst.size() - 1).setIrHrkmkensu(
                        creatGKFBSoukinLstBeanLst.get(creatGKFBSoukinLstBeanLst.size() - 1).getIrHrkmkensu().add(
                            BizNumber.ONE));

                    creatGKFBSoukinLstBeanLst.get(creatGKFBSoukinLstBeanLst.size() - 1).setIrHrkmgkkei(
                        creatGKFBSoukinLstBeanLst.get(creatGKFBSoukinLstBeanLst.size() - 1).getIrHrkmgkkei().
                        add(btGkFBSoukinData.getGaikashrgk()));

                    creatGKFBSoukinLstBeanLst.get(creatGKFBSoukinLstBeanLst.size() - 1).setDenpyogkkei(
                        creatGKFBSoukinLstBeanLst.get(creatGKFBSoukinLstBeanLst.size() - 1).getDenpyogkkei().
                        add(btGkFBSoukinHukaInfo.getDengk()));

                }

                if (!bmFBSoukinListKanriBefore.getGkfbmeisaisyoruicd().eq(bmFBSoukinListKanri.getGkfbmeisaisyoruicd())) {

                    outputGKDetailList(bmFBSoukinListKanriBefore.getGkfbmeisaisyoruicd());
                }
            }

            List<AS_Kinou> asKinouList = baseDomManager.getKinousBySyoricd(btGkFBSoukinData.getSyoricd());

            AS_Kinou asKinou = asKinouList.get(0);

            createGKDetailListDSBean(btGkFBSoukinData, btGkFBSoukinHukaInfo, bmFBSoukinListKanri, asKinou);

            btGKFBSoukinDataBefore = btGkFBSoukinData;

            bmFBSoukinListKanriBefore = bmFBSoukinListKanri;
        }

        outputGKDetailList(bmFBSoukinListKanriBefore.getGkfbmeisaisyoruicd());

        bzRecoveryDatasikibetuBean.initializeBlank();
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}