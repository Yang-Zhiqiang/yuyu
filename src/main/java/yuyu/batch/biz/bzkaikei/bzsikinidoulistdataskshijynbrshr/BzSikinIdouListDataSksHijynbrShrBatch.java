package yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrshr;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrshr.dba.BzSikinIdouListDataSksHijynbrShrDao;
import yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrshr.dba.GengakuIdouDataBean;
import yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrshr.dba.GengkKaisiYmZengoPTysytBean;
import yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrshr.dba.PMinyuuSymtJidouSkHukaBean;
import yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrshr.dba.SikinIdouListDataHijynbrShrBean;
import yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrshr.dba.SikinIdougkTysytBean;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_SikinIdouKbn;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_SikinidoumeisaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_SikinIdouListSks;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 業務共通 経理･会計 資金移動リストデータ作成（平準払支払用）バッチクラスです。
 */
public class BzSikinIdouListDataSksHijynbrShrBatch implements Batch {

    private static final String TABLE_ID = IT_KykKihon.TABLE_NAME;

    private static final String FILTER_ID = "Bz001";

    private static final String KYKIHONTABLE_ID = IT_KykKihon.TABLE_NAME;

    private static final String KYKIHONTABLE_HRKP = "hrkp";

    private static final String GENGAKU = "gengk";

    private static final String PMINYUUSYMT = "pmny";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzSikinIdouListDataSksHijynbrShrDao bzSikinIdouListDataSksHijynbrShrDao;

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

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();
        long syoriKensuu = 0;

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));

        HeijyunShrkInfoBean heijyunShrkInfoBean = SWAKInjector.getInstance(HeijyunShrkInfoBean.class);

        try (ExDBResults<SikinIdouListDataHijynbrShrBean> sikinIdouListDataHijynbrShrBeanLst = bzSikinIdouListDataSksHijynbrShrDao
            .getSikinIdouListDataSksHijynbrShrByKakutyoujobcdSyoriYmd(kakutyouJobCd, syoriYmd);
            ExDBResults<SikinIdouListDataHijynbrShrBean> skDenpyoDataBeanLst = bzSikinIdouListDataSksHijynbrShrDao
                .getSikinIdouListDataSksHijynbrShrSkBySyoriYmd(syoriYmd);
            ExDBResults<GengakuIdouDataBean> gengakuIdouDataBeanLst = bzSikinIdouListDataSksHijynbrShrDao
                .getSikinIdouListDataSksHijynbrShrByKakutyoujobcdSyoriYmdGengaku(kakutyouJobCd, syoriYmd,
                    IKhozenCommonConstants.KINOUID_GENGAKU);
            ExDBResults<PMinyuuSymtJidouSkHukaBean> pMinyuuSymtJidouSkHukaBeanLst = bzSikinIdouListDataSksHijynbrShrDao
                .getPMinyuuSymtJidouSkHukaBeans(kakutyouJobCd, syoriYmd);

            EntityInserter<BT_SikinIdouListSks> entityInserter = new EntityInserter<>();) {

            for (SikinIdouListDataHijynbrShrBean sikinIdouListDataHijynbrShrBean : sikinIdouListDataHijynbrShrBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(sikinIdouListDataHijynbrShrBean.getSyono());

                if (heijyunShrkInfoBean.getDenSysKbn() == null) {
                    heijyunShrkInfoBean.setSyoriYmd(syoriYmd);
                    heijyunShrkInfoBean.setDenSysKbn(sikinIdouListDataHijynbrShrBean.getDensyskbn());
                    heijyunShrkInfoBean.setDenRenno(sikinIdouListDataHijynbrShrBean.getDenrenno());
                    heijyunShrkInfoBean.addDenpyouData(sikinIdouListDataHijynbrShrBean);
                }
                else {
                    if (heijyunShrkInfoBean.getDenSysKbn().eq(sikinIdouListDataHijynbrShrBean.getDensyskbn())
                        && heijyunShrkInfoBean.getDenRenno().equals(sikinIdouListDataHijynbrShrBean.getDenrenno())) {
                        heijyunShrkInfoBean.addDenpyouData(sikinIdouListDataHijynbrShrBean);
                    }
                    else {
                        List<BT_SikinIdouListSks> sikinIdouListSksLst = heijyunShrkInfoBean.editSikinIdouListData();

                        for (BT_SikinIdouListSks sikinIdouListSks : sikinIdouListSksLst) {
                            entityInserter.add(sikinIdouListSks);
                        }
                        heijyunShrkInfoBean.clear();

                        heijyunShrkInfoBean.setSyoriYmd(syoriYmd);
                        heijyunShrkInfoBean.setDenSysKbn(sikinIdouListDataHijynbrShrBean.getDensyskbn());
                        heijyunShrkInfoBean.setDenRenno(sikinIdouListDataHijynbrShrBean.getDenrenno());
                        heijyunShrkInfoBean.addDenpyouData(sikinIdouListDataHijynbrShrBean);

                    }
                }
                syoriKensuu++;
            }

            List<BT_SikinIdouListSks> sikinIdouListSksLst = heijyunShrkInfoBean.editSikinIdouListData();
            for (BT_SikinIdouListSks sikinIdouListSks : sikinIdouListSksLst) {
                entityInserter.add(sikinIdouListSks);
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            heijyunShrkInfoBean = SWAKInjector.getInstance(HeijyunShrkInfoBean.class);


            for (SikinIdouListDataHijynbrShrBean skDenpyoDataBean : skDenpyoDataBeanLst) {

                if (heijyunShrkInfoBean.getDenSysKbn() == null) {
                    heijyunShrkInfoBean.setSyoriYmd(syoriYmd);
                    heijyunShrkInfoBean.setDenSysKbn(skDenpyoDataBean.getDensyskbn());
                    heijyunShrkInfoBean.setDenRenno(skDenpyoDataBean.getDenrenno());
                    heijyunShrkInfoBean.addDenpyouData(skDenpyoDataBean);
                }
                else {
                    if (heijyunShrkInfoBean.getDenSysKbn().eq(skDenpyoDataBean.getDensyskbn())
                        && heijyunShrkInfoBean.getDenRenno().equals(skDenpyoDataBean.getDenrenno())) {
                        heijyunShrkInfoBean.addDenpyouData(skDenpyoDataBean);
                    }
                    else {
                        List<BT_SikinIdouListSks> sikinIdouListSksSkLst = heijyunShrkInfoBean.editSikinIdouListData();

                        for (BT_SikinIdouListSks sikinIdouListSks : sikinIdouListSksSkLst) {
                            entityInserter.add(sikinIdouListSks);
                        }
                        heijyunShrkInfoBean.clear();

                        heijyunShrkInfoBean.setSyoriYmd(syoriYmd);
                        heijyunShrkInfoBean.setDenSysKbn(skDenpyoDataBean.getDensyskbn());
                        heijyunShrkInfoBean.setDenRenno(skDenpyoDataBean.getDenrenno());
                        heijyunShrkInfoBean.addDenpyouData(skDenpyoDataBean);

                    }
                }
                syoriKensuu++;
            }

            List<BT_SikinIdouListSks> sikinIdouListSksSkLst = heijyunShrkInfoBean.editSikinIdouListData();
            for (BT_SikinIdouListSks sikinIdouListSks : sikinIdouListSksSkLst) {
                entityInserter.add(sikinIdouListSks);
            }

            String sikibetumoji = GENGAKU;
            int renban = 1;

            for (GengakuIdouDataBean gengakuIdouDataBean : gengakuIdouDataBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(gengakuIdouDataBean.getSyono());

                BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);

                SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(
                    gengakuIdouDataBean.getSyouhnCd(), gengakuIdouDataBean.getKyktuukasyu());

                if (C_ErrorKbn.ERROR.eq(syouhinbetuSegmentBean.getErrorKbn())) {
                    throw new BizLogicException(MessageId.EBA0048, kinou.getKinouNm());
                }

                gengakuIdouDataBean.setSeg1cd(syouhinbetuSegmentBean.getSegcd1());

                GengkKaisiYmZengoPTysytBean gengkKaisiYmZengoPTysytBean = bzSikinIdouListDataSksHijynbrShrDao
                    .getGengkKaisiYmZengoPTysytBean(gengakuIdouDataBean.getSyono(), syoriYmd,
                        IKhozenCommonConstants.KINOUID_GENGAKU, KYKIHONTABLE_ID, KYKIHONTABLE_HRKP);

                BizCurrency gengakuZenP = BizCurrency.valueOf(
                    Double.valueOf(gengkKaisiYmZengoPTysytBean.getBfrNaiyou()), BizCurrencyTypes.YEN);
                BizCurrency gengakuAtoP = BizCurrency.valueOf(
                    Double.valueOf(gengkKaisiYmZengoPTysytBean.getNewNaiyou()), BizCurrencyTypes.YEN);
                BizCurrency sabenPYen = gengakuZenP.subtract(gengakuAtoP);
                BizDateYM gengakuKaisiYm = gengkKaisiYmZengoPTysytBean.getTmttknTaisyouYm();

                List<SikinIdougkTysytBean> sikinIdougkTysytBeanLst = bzSikinIdouListDataSksHijynbrShrDao
                    .getSikinIdougkTysytBeans(gengakuIdouDataBean.getSyono(), gengakuKaisiYm);

                if (sikinIdougkTysytBeanLst.size() == 0) {

                    continue;
                }

                HenkanTuuka henkanTuuka =SWAKInjector.getInstance(HenkanTuuka.class);

                BizCurrency hijynbrSikinIdouGk = BizCurrency.valueOf(0,
                    henkanTuuka.henkanTuukaKbnToType(gengakuIdouDataBean.getKyktuukasyu()));

                for (SikinIdougkTysytBean sikinIdougkTysytBean : sikinIdougkTysytBeanLst) {

                    KeisanGaikakanzan keisanGaikakanzan =SWAKInjector.getInstance(KeisanGaikakanzan.class);

                    BizCurrency kanzanGaku = keisanGaikakanzan.execDivide(gengakuIdouDataBean.getKyktuukasyu(),
                        sabenPYen, sikinIdougkTysytBean.getSikinidouKawaserate(), C_HasuusyoriKbn.AGE);

                    hijynbrSikinIdouGk = hijynbrSikinIdouGk.add(kanzanGaku);
                }

                BT_SikinIdouListSks sikinIdouListSks = new BT_SikinIdouListSks(C_DensysKbn.HOZEN, syoriYmd
                    + sikibetumoji + Strings.padStart(String.valueOf(renban), 4, '0'), 99);

                sikinIdouListSks.setSyoriYmd(syoriYmd);
                sikinIdouListSks.setSeg1cd(gengakuIdouDataBean.getSeg1cd());
                sikinIdouListSks.setKyktuukasyu(gengakuIdouDataBean.getKyktuukasyu());
                sikinIdouListSks.setKeiyakutuukagk(hijynbrSikinIdouGk);
                sikinIdouListSks.setShrtuukasyu(C_Tuukasyu.JPY);
                sikinIdouListSks.setSikinidoukbn(C_SikinIdouKbn.BLNK);
                sikinIdouListSks.setSikinidougroupkbn(C_SikinidougroupKbn.BLNK);
                sikinIdouListSks.setSikinidoumeisaikbn(C_SikinidoumeisaiKbn.BLNK);

                BizPropertyInitializer.initialize(sikinIdouListSks);

                entityInserter.add(sikinIdouListSks);

                renban++;

                syoriKensuu++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            sikibetumoji = PMINYUUSYMT;
            renban = 1;

            for (PMinyuuSymtJidouSkHukaBean pMinyuuSymtJidouSkHukaBean : pMinyuuSymtJidouSkHukaBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(pMinyuuSymtJidouSkHukaBean.getSyono());

                BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);

                SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(
                    pMinyuuSymtJidouSkHukaBean.getSyouhnCd(), pMinyuuSymtJidouSkHukaBean.getKyktuukasyu());

                if (C_ErrorKbn.ERROR.eq(syouhinbetuSegmentBean.getErrorKbn())) {
                    throw new BizLogicException(MessageId.EBA0048, kinou.getKinouNm());
                }

                pMinyuuSymtJidouSkHukaBean.setSeg1cd(syouhinbetuSegmentBean.getSegcd1());

                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

                CurrencyType tuukasyuType = henkanTuuka.henkanTuukaKbnToType(
                    pMinyuuSymtJidouSkHukaBean.getKyktuukasyu());

                BizCurrency jidouSkHukaKyktuukaGk = BizCurrency.valueOf(0, tuukasyuType);

                jidouSkHukaKyktuukaGk = jidouSkHukaKyktuukaGk.add(pMinyuuSymtJidouSkHukaBean.getKaiyakuhrknsiteituuka());

                jidouSkHukaKyktuukaGk = jidouSkHukaKyktuukaGk.add(pMinyuuSymtJidouSkHukaBean
                    .getZitkazukarikingksiteituuka());

                BT_SikinIdouListSks sikinIdouListSks = new BT_SikinIdouListSks(C_DensysKbn.HOZEN, syoriYmd
                    + sikibetumoji + Strings.padStart(String.valueOf(renban), 5, '0'), 98);

                sikinIdouListSks.setSyoriYmd(syoriYmd);
                sikinIdouListSks.setSeg1cd(pMinyuuSymtJidouSkHukaBean.getSeg1cd());
                sikinIdouListSks.setKyktuukasyu(pMinyuuSymtJidouSkHukaBean.getKyktuukasyu());
                sikinIdouListSks.setKeiyakutuukagk(jidouSkHukaKyktuukaGk);
                sikinIdouListSks.setShrtuukasyu(C_Tuukasyu.JPY);
                sikinIdouListSks.setSikinidoukbn(C_SikinIdouKbn.BLNK);
                sikinIdouListSks.setSikinidougroupkbn(C_SikinidougroupKbn.BLNK);
                sikinIdouListSks.setSikinidoumeisaikbn(C_SikinidoumeisaiKbn.BLNK);

                BizPropertyInitializer.initialize(sikinIdouListSks);

                entityInserter.add(sikinIdouListSks);

                renban++;

                syoriKensuu++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {
        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }
}