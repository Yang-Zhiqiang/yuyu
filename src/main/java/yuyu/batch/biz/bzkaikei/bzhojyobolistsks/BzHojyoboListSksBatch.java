package yuyu.batch.biz.bzkaikei.bzhojyobolistsks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.def.MessageId;
import yuyu.def.base.detacher.AM_SosikiDetacher;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.bean.report.BzHojyobolistBean;
import yuyu.def.biz.bean.report.BzHojyobolistDataSourceBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.detacher.BT_HjybruikeigakuDetacher;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AM_Sosiki;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_KanjyouKamoku;
import yuyu.def.db.entity.BT_Hjyblist;
import yuyu.def.db.entity.BT_Hjybruikeigaku;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 業務共通 経理・会計 補助簿リスト作成処理クラス
 */
public class BzHojyoboListSksBatch implements Batch {

    private final String ZEROSANKETA = "000";

    private final String ZEROFOURKETA = "0000";

    private final String HJYBLIST = "BT_Hjyblist";

    private final String HJYBLISTFILTERID = "Bz106";

    private final String SANKOU = "　＜参考＞";

    private BizCurrency karikatagkSum;

    private BizCurrency kasikatagkSum;

    private BizCurrency karikataRuigk;

    private BizCurrency kasikataRuigk;

    private String hjybtantosituNm;

    private String syorisyokantantNm;

    private List<IReportDataSouceBean> hjyblistDataSouceBeanLst1;

    private List<IReportDataSouceBean> hjyblistDataSouceBeanLst2;

    private List<IReportDataSouceBean> hjyblistDataSouceBeanLst3;

    private List<IReportDataSouceBean> hjyblistDataSouceBeanLst4;

    private List<IReportDataSouceBean> hjyblistDataSouceBeanLst5;

    private List<IReportDataSouceBean> hjyblistDataSouceBeanLst6;

    private List<IReportDataSouceBean> hjyblistDataSouceBeanLst7;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private CreateReport createReport;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        karikatagkSum = BizCurrency.valueOf(0);
        kasikatagkSum = BizCurrency.valueOf(0);
        karikataRuigk = BizCurrency.valueOf(0);
        kasikataRuigk = BizCurrency.valueOf(0);
        hjyblistDataSouceBeanLst1 = new ArrayList<>();
        hjyblistDataSouceBeanLst2 = new ArrayList<>();
        hjyblistDataSouceBeanLst3 = new ArrayList<>();
        hjyblistDataSouceBeanLst4 = new ArrayList<>();
        hjyblistDataSouceBeanLst5 = new ArrayList<>();
        hjyblistDataSouceBeanLst6 = new ArrayList<>();
        hjyblistDataSouceBeanLst7 = new ArrayList<>();
        long syoriKensuu = 0;
        BizDateYM ruikeiSyoriYm;
        BT_Hjyblist bthjybList = null;
        BT_Hjyblist previousHjyblist = null;
        BzHojyobolistDataSourceBean preBzHojyobolistDataSourceBean = null;
        BT_Hjybruikeigaku hjybruiKeigaku = null;
        boolean aprHojyobolistFlag;
        if (syoriYmd.getMonth() == 5) {
            aprHojyobolistFlag = true;
        }
        else {
            aprHojyobolistFlag = false;
        }

        if(aprHojyobolistFlag){
            ruikeiSyoriYm = syoriYmd.addMonths(-1).getBizDateYM();
        }
        else{
            ruikeiSyoriYm = syoriYmd.addMonths(-2).getBizDateYM();
        }

        try (ExDBResults<BT_Hjyblist> hjyblistLst = bizDomManager.getHjyblistsByKakutyoujobcdDenymdFromDenymdTo(
            bzBatchParam.getIbKakutyoujobcd(),
            syoriYmd.getBizDateYM().getPreviousMonth().getFirstDay(),
            syoriYmd.getBizDateYM().getPreviousMonth().getLastDay());
            EntityInserter<BT_Hjybruikeigaku> hjybruikeigakuEntityInserter = new EntityInserter<>();
            EntityUpdater<BT_Hjybruikeigaku> hjybruikeigakuEntityUpdater = new EntityUpdater<>();) {

            Iterator<BT_Hjyblist> hjyblistIter = hjyblistLst.iterator();
            while (hjyblistIter.hasNext()) {

                bthjybList = hjyblistIter.next();
                BM_KanjyouKamoku kanjyouKamoku = bthjybList.getKanjyouKamoku();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(HJYBLIST);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(HJYBLISTFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(bthjybList.getHjybtantositucd());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(bthjybList.getKanjyoukmkcd().getValue());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey3(bthjybList.getSyorisyokantantcd());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey4(String.valueOf(bthjybList.getDenymd()));

                if (previousHjyblist == null) {

                    List<BT_Hjybruikeigaku> hjybruiKeigakuList = bizDomManager.getHjybruikeigakusByPK(
                        bthjybList.getHjybtantositucd(), bthjybList.getKanjyoukmkcd(), ruikeiSyoriYm);

                    if (!hjybruiKeigakuList.isEmpty()){
                        hjybruiKeigakuList = BT_HjybruikeigakuDetacher.detachHjybruikeigakutouched(hjybruiKeigakuList);

                        hjybruiKeigaku = hjybruiKeigakuList.iterator().next();

                        karikataRuigk = hjybruiKeigaku.getKarikataruigk();

                        kasikataRuigk = hjybruiKeigaku.getKasikataruigk();
                    }

                    getListInjiSosikiInfo(bthjybList.getHjybtantositucd(), bthjybList.getSyorisyokantantcd());
                }
                else {

                    if (!previousHjyblist.getHjybtantositucd().equals(bthjybList.getHjybtantositucd()) ||
                        !previousHjyblist.getKanjyoukmkcd().eq(bthjybList.getKanjyoukmkcd()) ||
                        !previousHjyblist.getSyorisyokantantcd().equals(bthjybList.getSyorisyokantantcd())) {

                        if (!previousHjyblist.getHjybtantositucd().equals(bthjybList.getHjybtantositucd()) ||
                            !previousHjyblist.getKanjyoukmkcd().eq(bthjybList.getKanjyoukmkcd())) {

                            karikataRuigk = karikataRuigk.add(karikatagkSum);

                            kasikataRuigk = kasikataRuigk.add(kasikatagkSum);

                            setKkeigkForDsbean(previousHjyblist.getHjybtantositucd(), preBzHojyobolistDataSourceBean);

                            BT_Hjybruikeigaku bthjybruiKeigaku = null;

                            if (aprHojyobolistFlag) {
                                bthjybruiKeigaku = bizDomManager.getHjybruikeigaku(previousHjyblist.getHjybtantositucd(),
                                    previousHjyblist.getKanjyoukmkcd(), previousHjyblist.getDenymd().getBizDateYM());
                            }
                            if (bthjybruiKeigaku == null) {
                                BT_Hjybruikeigaku btHjybruiKeigaku = new BT_Hjybruikeigaku();
                                btHjybruiKeigaku.setHjybtantositucd(previousHjyblist.getHjybtantositucd());
                                btHjybruiKeigaku.setKanjyoukmkcd(previousHjyblist.getKanjyoukmkcd());
                                if (previousHjyblist.getDenymd() != null) {

                                    btHjybruiKeigaku.setDenym(previousHjyblist.getDenymd().getBizDateYM());
                                }
                                btHjybruiKeigaku.setKarikatakmkkeigk(karikatagkSum);
                                btHjybruiKeigaku.setKasikatakmkkeigk(kasikatagkSum);
                                btHjybruiKeigaku.setKarikataruigk(karikataRuigk);
                                btHjybruiKeigaku.setKasikataruigk(kasikataRuigk);
                                BizPropertyInitializer.initialize(btHjybruiKeigaku);
                                hjybruikeigakuEntityInserter.add(btHjybruiKeigaku);
                            }
                            else {
                                bthjybruiKeigaku.setKarikatakmkkeigk(karikatagkSum);
                                bthjybruiKeigaku.setKasikatakmkkeigk(kasikatagkSum);
                                bthjybruiKeigaku.setKarikataruigk(karikataRuigk);
                                bthjybruiKeigaku.setKasikataruigk(kasikataRuigk);
                                hjybruikeigakuEntityUpdater.add(bthjybruiKeigaku);
                            }

                            karikatagkSum = BizCurrency.valueOf(0);
                            kasikatagkSum = BizCurrency.valueOf(0);
                            karikataRuigk = BizCurrency.valueOf(0);
                            kasikataRuigk = BizCurrency.valueOf(0);

                            List<BT_Hjybruikeigaku> hjybruiKeigakuList = bizDomManager.getHjybruikeigakusByPK(
                                bthjybList.getHjybtantositucd(), bthjybList.getKanjyoukmkcd(), ruikeiSyoriYm);

                            if (!hjybruiKeigakuList.isEmpty()){
                                hjybruiKeigakuList = BT_HjybruikeigakuDetacher.detachHjybruikeigakutouched(hjybruiKeigakuList);

                                hjybruiKeigaku = hjybruiKeigakuList.iterator().next();

                                karikataRuigk = hjybruiKeigaku.getKarikataruigk();

                                kasikataRuigk = hjybruiKeigaku.getKasikataruigk();
                            }
                        }

                        getListInjiSosikiInfo(bthjybList.getHjybtantositucd(), bthjybList.getSyorisyokantantcd());
                    }
                }

                BzHojyobolistDataSourceBean bzHojyobolistDataSourceBean = SWAKInjector.getInstance(
                    BzHojyobolistDataSourceBean.class);

                bzHojyobolistDataSourceBean.setIrHjybtantositunm(hjybtantosituNm);
                bzHojyobolistDataSourceBean.setIrKanjyoukmkcd(bthjybList.getKanjyoukmkcd().getValue());
                if (null != kanjyouKamoku) {

                    bzHojyobolistDataSourceBean.setIrKanjyoukmknm(getKanjyoukmknm(kanjyouKamoku));
                }
                if(!ZEROSANKETA.equals(bthjybList.getSyorisyokantantcd())) {
                    bzHojyobolistDataSourceBean.setIrSyorisyokantantcd(bthjybList.getSyorisyokantantcd());
                }
                bzHojyobolistDataSourceBean.setIrSyorisyokantantnm(syorisyokantantNm);
                if (bthjybList.getDenymd() != null) {

                    bzHojyobolistDataSourceBean.setIrDenymd(DateFormatUtil.dateKANJI(bthjybList.getDenymd()));
                }
                bzHojyobolistDataSourceBean.setIrKarikatagk(bthjybList.getKarikatagk());
                bzHojyobolistDataSourceBean.setIrKasikatagk(bthjybList.getKasikatagk());

                YuyuBizConfig yuyuBizConfig = YuyuBizConfig.getInstance();

                if (bthjybList.getHjybtantositucd().equals(yuyuBizConfig.getHjybtantositucd1())) {

                    hjyblistDataSouceBeanLst1.add(bzHojyobolistDataSourceBean);
                }

                else if (bthjybList.getHjybtantositucd().equals(yuyuBizConfig.getHjybtantositucd2())) {


                    hjyblistDataSouceBeanLst2.add(bzHojyobolistDataSourceBean);
                }

                else if (bthjybList.getHjybtantositucd().equals(yuyuBizConfig.getHjybtantositucd3())) {

                    hjyblistDataSouceBeanLst3.add(bzHojyobolistDataSourceBean);
                }

                else if (bthjybList.getHjybtantositucd().equals(yuyuBizConfig.getHjybtantositucd4())) {

                    hjyblistDataSouceBeanLst4.add(bzHojyobolistDataSourceBean);
                }

                else if (bthjybList.getHjybtantositucd().equals(yuyuBizConfig.getHjybtantositucd5())) {

                    hjyblistDataSouceBeanLst5.add(bzHojyobolistDataSourceBean);
                }

                else if (bthjybList.getHjybtantositucd().equals(yuyuBizConfig.getHjybtantositucd6())) {

                    hjyblistDataSouceBeanLst6.add(bzHojyobolistDataSourceBean);
                }

                else if (bthjybList.getHjybtantositucd().equals(yuyuBizConfig.getHjybtantositucd7())) {

                    hjyblistDataSouceBeanLst7.add(bzHojyobolistDataSourceBean);
                }

                previousHjyblist = bthjybList;
                preBzHojyobolistDataSourceBean = bzHojyobolistDataSourceBean;
                karikatagkSum = karikatagkSum.add(bthjybList.getKarikatagk());
                kasikatagkSum = kasikatagkSum.add(bthjybList.getKasikatagk());
                syoriKensuu++;
            }

            if (syoriKensuu > 0) {

                karikataRuigk = karikataRuigk.add(karikatagkSum);

                kasikataRuigk = kasikataRuigk.add(kasikatagkSum);

                setKkeigkForDsbean(previousHjyblist.getHjybtantositucd(), preBzHojyobolistDataSourceBean);

                BT_Hjybruikeigaku bthjybruiKeigaku = null;

                if (aprHojyobolistFlag) {
                    bthjybruiKeigaku = bizDomManager.getHjybruikeigaku(bthjybList.getHjybtantositucd(),
                        bthjybList.getKanjyoukmkcd(), bthjybList.getDenymd().getBizDateYM());
                }
                if (bthjybruiKeigaku == null) {
                    BT_Hjybruikeigaku btHjybruiKeigaku = new BT_Hjybruikeigaku();
                    btHjybruiKeigaku.setHjybtantositucd(previousHjyblist.getHjybtantositucd());
                    btHjybruiKeigaku.setKanjyoukmkcd(previousHjyblist.getKanjyoukmkcd());
                    if (previousHjyblist.getDenymd() != null) {

                        btHjybruiKeigaku.setDenym(previousHjyblist.getDenymd().getBizDateYM());
                    }
                    btHjybruiKeigaku.setKarikatakmkkeigk(karikatagkSum);
                    btHjybruiKeigaku.setKasikatakmkkeigk(kasikatagkSum);
                    btHjybruiKeigaku.setKarikataruigk(karikataRuigk);
                    btHjybruiKeigaku.setKasikataruigk(kasikataRuigk);
                    BizPropertyInitializer.initialize(btHjybruiKeigaku);
                    hjybruikeigakuEntityInserter.add(btHjybruiKeigaku);
                }
                else {
                    bthjybruiKeigaku.setKarikatakmkkeigk(karikatagkSum);
                    bthjybruiKeigaku.setKasikatakmkkeigk(kasikatagkSum);
                    bthjybruiKeigaku.setKarikataruigk(karikataRuigk);
                    bthjybruiKeigaku.setKasikataruigk(kasikataRuigk);
                    hjybruikeigakuEntityUpdater.add(bthjybruiKeigaku);
                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            if (hjyblistDataSouceBeanLst1.size() > 0) {

                BzHojyobolistBean bzHojyobolistBean1 = SWAKInjector.getInstance(BzHojyobolistBean.class);

                bzHojyobolistBean1.setIrSyoriymd(DateFormatUtil.dateKANJI(syoriYmd));
                bzHojyobolistBean1.setIrDenym(DateFormatUtil.dateYmKANJI(syoriYmd.getPreviousMonth().getBizDateYM()));

                outputBzHojyobolist(
                    C_SyoruiCdKbn.CM_HOJYOBOLIST_1, syoriYmd, bzHojyobolistBean1, hjyblistDataSouceBeanLst1);
            }

            if (hjyblistDataSouceBeanLst2.size() > 0) {

                BzHojyobolistBean bzHojyobolistBean2 = SWAKInjector.getInstance(BzHojyobolistBean.class);

                bzHojyobolistBean2.setIrSyoriymd(DateFormatUtil.dateKANJI(syoriYmd));
                bzHojyobolistBean2.setIrDenym(DateFormatUtil.dateYmKANJI(syoriYmd.getPreviousMonth().getBizDateYM()));

                outputBzHojyobolist(
                    C_SyoruiCdKbn.CM_HOJYOBOLIST_2, syoriYmd, bzHojyobolistBean2, hjyblistDataSouceBeanLst2);
            }

            if (hjyblistDataSouceBeanLst3.size() > 0) {

                BzHojyobolistBean bzHojyobolistBean3 = SWAKInjector.getInstance(BzHojyobolistBean.class);

                bzHojyobolistBean3.setIrSyoriymd(DateFormatUtil.dateKANJI(syoriYmd));
                bzHojyobolistBean3.setIrDenym(DateFormatUtil.dateYmKANJI(syoriYmd.getPreviousMonth().getBizDateYM()));

                outputBzHojyobolist(
                    C_SyoruiCdKbn.CM_HOJYOBOLIST_3, syoriYmd, bzHojyobolistBean3, hjyblistDataSouceBeanLst3);
            }

            if (hjyblistDataSouceBeanLst4.size() > 0) {

                BzHojyobolistBean bzHojyobolistBean4 = SWAKInjector.getInstance(BzHojyobolistBean.class);

                bzHojyobolistBean4.setIrSyoriymd(DateFormatUtil.dateKANJI(syoriYmd));
                bzHojyobolistBean4.setIrDenym(DateFormatUtil.dateYmKANJI(syoriYmd.getPreviousMonth().getBizDateYM()));

                outputBzHojyobolist(
                    C_SyoruiCdKbn.CM_HOJYOBOLIST_4, syoriYmd, bzHojyobolistBean4, hjyblistDataSouceBeanLst4);
            }

            if (hjyblistDataSouceBeanLst5.size() > 0) {

                BzHojyobolistBean bzHojyobolistBean5 = SWAKInjector.getInstance(BzHojyobolistBean.class);

                bzHojyobolistBean5.setIrSyoriymd(DateFormatUtil.dateKANJI(syoriYmd));
                bzHojyobolistBean5.setIrDenym(DateFormatUtil.dateYmKANJI(syoriYmd.getPreviousMonth().getBizDateYM()));

                outputBzHojyobolist(
                    C_SyoruiCdKbn.CM_HOJYOBOLIST_5, syoriYmd, bzHojyobolistBean5, hjyblistDataSouceBeanLst5);
            }

            if (hjyblistDataSouceBeanLst6.size() > 0) {

                BzHojyobolistBean bzHojyobolistBean6 = SWAKInjector.getInstance(BzHojyobolistBean.class);

                bzHojyobolistBean6.setIrSyoriymd(DateFormatUtil.dateKANJI(syoriYmd));
                bzHojyobolistBean6.setIrDenym(DateFormatUtil.dateYmKANJI(syoriYmd.getPreviousMonth().getBizDateYM()));

                outputBzHojyobolist(
                    C_SyoruiCdKbn.CM_HOJYOBOLIST_6, syoriYmd, bzHojyobolistBean6, hjyblistDataSouceBeanLst6);
            }

            if (hjyblistDataSouceBeanLst7.size() > 0) {

                BzHojyobolistBean bzHojyobolistBean7 = SWAKInjector.getInstance(BzHojyobolistBean.class);

                bzHojyobolistBean7.setIrSyoriymd(DateFormatUtil.dateKANJI(syoriYmd));
                bzHojyobolistBean7.setIrDenym(DateFormatUtil.dateYmKANJI(syoriYmd.getPreviousMonth().getBizDateYM()));

                outputBzHojyobolist(
                    C_SyoruiCdKbn.CM_HOJYOBOLIST_7, syoriYmd, bzHojyobolistBean7, hjyblistDataSouceBeanLst7);
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    private void getListInjiSosikiInfo(String pHjybtantositucd, String pSyorisyokantantcd) {

        hjybtantosituNm = "";
        syorisyokantantNm = "";

        AM_Sosiki sosiki = baseDomManager.getSosiki(pHjybtantositucd.concat(ZEROFOURKETA));
        sosiki = AM_SosikiDetacher.detachSosikitouched(sosiki);

        hjybtantosituNm = sosiki.getKanjisosikinm20();

        if (!ZEROSANKETA.equals(pSyorisyokantantcd)) {

            sosiki = baseDomManager.getSosiki(pSyorisyokantantcd.concat(ZEROFOURKETA));
            sosiki = AM_SosikiDetacher.detachSosikitouched(sosiki);

            syorisyokantantNm = sosiki.getKanjisosikinm20();
        }
    }

    private void setKkeigkForDsbean(String pHjybtantositucd, BzHojyobolistDataSourceBean pBzHojyobolistDataSourceBean) {

        pBzHojyobolistDataSourceBean.setIrKarikatakmkkeigk(karikatagkSum);
        pBzHojyobolistDataSourceBean.setIrKasikatakmkkeigk(kasikatagkSum);
        pBzHojyobolistDataSourceBean.setIrKarikataruigk(karikataRuigk);
        pBzHojyobolistDataSourceBean.setIrKasikataruigk(kasikataRuigk);

        YuyuBizConfig yuyuBizConfig = YuyuBizConfig.getInstance();

        if (pHjybtantositucd.equals(yuyuBizConfig.getHjybtantositucd1())) {

            hjyblistDataSouceBeanLst1.set(hjyblistDataSouceBeanLst1.size() - 1, pBzHojyobolistDataSourceBean);
        }

        else if (pHjybtantositucd.equals(yuyuBizConfig.getHjybtantositucd2())) {


            hjyblistDataSouceBeanLst2.set(hjyblistDataSouceBeanLst2.size() - 1, pBzHojyobolistDataSourceBean);
        }

        else if (pHjybtantositucd.equals(yuyuBizConfig.getHjybtantositucd3())) {

            hjyblistDataSouceBeanLst3.set(hjyblistDataSouceBeanLst3.size() - 1, pBzHojyobolistDataSourceBean);
        }

        else if (pHjybtantositucd.equals(yuyuBizConfig.getHjybtantositucd4())) {

            hjyblistDataSouceBeanLst4.set(hjyblistDataSouceBeanLst4.size() - 1, pBzHojyobolistDataSourceBean);
        }

        else if (pHjybtantositucd.equals(yuyuBizConfig.getHjybtantositucd5())) {

            hjyblistDataSouceBeanLst5.set(hjyblistDataSouceBeanLst5.size() - 1, pBzHojyobolistDataSourceBean);
        }

        else if (pHjybtantositucd.equals(yuyuBizConfig.getHjybtantositucd6())) {

            hjyblistDataSouceBeanLst6.set(hjyblistDataSouceBeanLst6.size() - 1, pBzHojyobolistDataSourceBean);
        }

        else if (pHjybtantositucd.equals(yuyuBizConfig.getHjybtantositucd7())) {

            hjyblistDataSouceBeanLst7.set(hjyblistDataSouceBeanLst7.size() - 1, pBzHojyobolistDataSourceBean);
        }
    }

    private void outputBzHojyobolist(C_SyoruiCdKbn pSyoruiCdKbn, BizDate pSyoriYmd,
        BzHojyobolistBean pBzHojyobolistBean, List<IReportDataSouceBean> pIReportDataSouceBeanLst) {

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            pSyoruiCdKbn);

        reportServicesBean.setSyoriYmd(pSyoriYmd);

        reportServicesBean.addParamObjects(pIReportDataSouceBeanLst, pBzHojyobolistBean);

        createReport.execNoCommit(reportServicesBean);
    }

    private String getKanjyoukmknm(BM_KanjyouKamoku pKanjyouKamoku) {

        String kanjyoukmknm = pKanjyouKamoku.getKanjyoukmknm();

        if (C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_SYUUNOU.equals(pKanjyouKamoku.getKanjyoukmkcd()) ||
            C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_HURIKAE.equals(pKanjyouKamoku.getKanjyoukmkcd())
            || C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_KURE.equals(pKanjyouKamoku.getKanjyoukmkcd())) {

            kanjyoukmknm = kanjyoukmknm + SANKOU;
        }

        return kanjyoukmknm;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
