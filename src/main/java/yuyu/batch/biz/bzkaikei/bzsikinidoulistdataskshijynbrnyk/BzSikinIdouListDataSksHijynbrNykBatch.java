package yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrnyk;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityDeleter;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrnyk.dba.BzSikinIdouListDataSksHijynbrNykDao;
import yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrnyk.dba.HijynbrGengakuDataBean;
import yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrnyk.dba.HijynbrNykDataBean;
import yuyu.batch.biz.bzkaikei.bzsikinidoulistdataskshijynbrnyk.dba.SikinIdouListSkshijynbrNykDataBean;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanGaikaP;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SikinidouJtKbn;
import yuyu.def.classification.C_SikinidouPKbn;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_SikinidoumeisaiKbn;
import yuyu.def.db.entity.BM_SikinIdouGroup;
import yuyu.def.db.entity.BT_HijynNykSikinIdouListSks;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 経理･会計 資金移動リストデータ作成(平準払入金用)のバッチクラスです。
 */
public class BzSikinIdouListDataSksHijynbrNykBatch implements Batch {

    private static final String TABLE_ID = "IT_KykKihon";

    private static final String FILTER_ID = "Bz001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzSikinIdouListDataSksHijynbrNykDao bzSikinIdouListDataSksHijynbrNykDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    private BizDate syoriYmd = null;

    private long syoriKensuu = 0;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        syoriYmd = bzBatchParam.getSyoriYmd();

        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(
            MessageUtil.getMessage(MessageId.IBA0016,
                MessageUtil.getMessage(MessageId.IBW0003),
                String.valueOf(syoriYmd)));

        BizDateYM jyuutouym = null;

        BizDateYM gengkstartym = null;

        int jyutoukaisuu = 0;

        String syono = "";

        BizCurrency kanzanmaegkYen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        try (
            ExDBResults<HijynbrNykDataBean> hijynbrNykDataBeanLst =
            bzSikinIdouListDataSksHijynbrNykDao.getHijynbrNykDataBeans(
                kakutyouJobCd,
                syoriYmd);

            EntityInserter<BT_HijynNykSikinIdouListSks> hijynNykSikinIdouListSksInsLst = new EntityInserter<>();

            EntityUpdater<BT_HijynNykSikinIdouListSks> hijynNykSikinIdouListSksUpdLst = new EntityUpdater<>();

            EntityDeleter<BT_HijynNykSikinIdouListSks> hijynNykSikinIdouListSksDelLst = new EntityDeleter<>()) {

            for (HijynbrNykDataBean hijynbrNykDataBean : hijynbrNykDataBeanLst) {

                List<BT_HijynNykSikinIdouListSks> hijynNykSikinIdouListSksLst = null;
                BizDateYM sikinidoupjytym = null;
                C_SikinidouJtKbn sikinidouJtKbn = null;

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(hijynbrNykDataBean.getSyono());

                SikinIdouListSkshijynbrNykDataBean sikinIdouListSkshijynbrNykDataBean =
                    bzSikinIdouListDataSksHijynbrNykDao.getHijynNykSikinIdouListSksBySyono(
                        hijynbrNykDataBean.getSyono());

                if (sikinIdouListSkshijynbrNykDataBean == null) {

                    sikinidoupjytym = null;
                    sikinidouJtKbn = C_SikinidouJtKbn.BLNK;
                }
                else {

                    sikinidoupjytym = sikinIdouListSkshijynbrNykDataBean.getSikinidoupjytym();
                    sikinidouJtKbn = sikinIdouListSkshijynbrNykDataBean.getSikinidoujtkbn();
                }

                if (C_NyknaiyouKbn.SYOKAIP.eq(hijynbrNykDataBean.getNyknaiyoukbn())
                    || (!C_NyknaiyouKbn.SYOKAIP.eq(hijynbrNykDataBean.getNyknaiyoukbn())
                        && sikinidoupjytym == null)) {

                    jyutoukaisuu = hijynbrNykDataBean.getJyutoukaisuum();

                    hijynNykSikinIdouListSksLst = InsHijynNykSikinIdouListSksLst(
                        hijynbrNykDataBean,
                        hijynbrNykDataBean.getJyutouendym(),
                        jyutoukaisuu);

                    for (int n = 0; n < hijynNykSikinIdouListSksLst.size(); n++) {

                        BT_HijynNykSikinIdouListSks hijynNykSikinIdouListSks = hijynNykSikinIdouListSksLst.get(n);

                        hijynNykSikinIdouListSksInsLst.add(hijynNykSikinIdouListSks);

                        syoriKensuu++;
                    }
                }
                else {
                    if (!syono.equals(hijynbrNykDataBean.getSyono())) {

                        jyuutouym = hijynbrNykDataBean.getJkipjytym().getPreviousMonth();

                        if (BizDateUtil.compareYm(jyuutouym, sikinidoupjytym) == BizDateUtil.COMPARE_GREATER) {

                            hijynNykSikinIdouListSksLst = InsHijynNykSikinIdouListSksLst(
                                hijynbrNykDataBean,
                                sikinidoupjytym.getNextMonth(),
                                BizDateUtil.calcDifferenceMonths(jyuutouym, sikinidoupjytym));

                            for (int n = 0; n < hijynNykSikinIdouListSksLst.size(); n++) {

                                BT_HijynNykSikinIdouListSks hijynNykSikinIdouListSks = hijynNykSikinIdouListSksLst.get(n);

                                BT_HijynNykSikinIdouListSks sikinidouTorikesiKanRyoData =
                                    bzSikinIdouListDataSksHijynbrNykDao.getSikinidouTorikesiKanryouData(
                                        hijynNykSikinIdouListSks.getSyono(),
                                        hijynNykSikinIdouListSks.getSikinidoupjytym());

                                if (sikinidouTorikesiKanRyoData == null) {

                                    hijynNykSikinIdouListSksInsLst.add(hijynNykSikinIdouListSks);
                                }
                                else {
                                    sikinidouTorikesiKanRyoData.setSyoriYmd(hijynNykSikinIdouListSks.getSyoriYmd());

                                    sikinidouTorikesiKanRyoData.setSiteituuka(hijynNykSikinIdouListSks.getSiteituuka());

                                    sikinidouTorikesiKanRyoData.setSiteituukagk(hijynNykSikinIdouListSks.getSiteituukagk());

                                    sikinidouTorikesiKanRyoData.setTrhktuuka(hijynNykSikinIdouListSks.getTrhktuuka());

                                    sikinidouTorikesiKanRyoData.setTrhktuukagk(hijynNykSikinIdouListSks.getTrhktuukagk());

                                    sikinidouTorikesiKanRyoData.setSeg1cd(hijynNykSikinIdouListSks.getSeg1cd());

                                    sikinidouTorikesiKanRyoData.setSikinidougroupkbn(hijynNykSikinIdouListSks.getSikinidougroupkbn());

                                    sikinidouTorikesiKanRyoData.setSikinidoumeisaikbn(hijynNykSikinIdouListSks.getSikinidoumeisaikbn());

                                    sikinidouTorikesiKanRyoData.setSikinidoujtkbn(hijynNykSikinIdouListSks.getSikinidoujtkbn());

                                    sikinidouTorikesiKanRyoData.setSikinidoukawaserate(hijynNykSikinIdouListSks.getSikinidoukawaserate());

                                    sikinidouTorikesiKanRyoData.setSikinidoupkbn(hijynNykSikinIdouListSks.getSikinidoupkbn());

                                    hijynNykSikinIdouListSksUpdLst.add(sikinidouTorikesiKanRyoData);
                                }

                                syoriKensuu++;
                            }
                        }
                        else if (BizDateUtil.compareYm(jyuutouym, sikinidoupjytym) == BizDateUtil.COMPARE_LESSER) {

                            hijynNykSikinIdouListSksLst =
                                bzSikinIdouListDataSksHijynbrNykDao.getTrksHijynNykSikinIdouListDataBeans(
                                    hijynbrNykDataBean.getSyono(),
                                    hijynbrNykDataBean.getJkipjytym(),
                                    sikinidoupjytym);

                            for (int n = 0; n < hijynNykSikinIdouListSksLst.size(); n++) {

                                BT_HijynNykSikinIdouListSks hijynNykSikinIdouListSks =
                                    hijynNykSikinIdouListSksLst.get(n);

                                if (C_SikinidouJtKbn.SIKINIDOUKANRYOU.eq(hijynNykSikinIdouListSks.getSikinidoujtkbn())) {

                                    hijynNykSikinIdouListSks.setSikinidoujtkbn(C_SikinidouJtKbn.SIKINIDOUTORIKESI);

                                    hijynNykSikinIdouListSks.setSikinidoumeisaikbn(C_SikinidoumeisaiKbn.NYUUKINTORIKESI);

                                    hijynNykSikinIdouListSksUpdLst.add(hijynNykSikinIdouListSks);
                                }
                                else if (C_SikinidouJtKbn.SIKINIDOUMIRYOU.eq(hijynNykSikinIdouListSks.getSikinidoujtkbn())) {

                                    hijynNykSikinIdouListSksDelLst.add(hijynNykSikinIdouListSks);
                                }

                                syoriKensuu++;
                            }
                        }

                        syono = hijynbrNykDataBean.getSyono();
                    }
                }
            }
        }

        bizDomManager.flush();

        try(
            ExDBResults<HijynbrGengakuDataBean> hijynbrGengakuDataBeanLst =
            bzSikinIdouListDataSksHijynbrNykDao.getHijynbrGengakuDataBeans(
                kakutyouJobCd,
                syoriYmd,
                IKhozenCommonConstants.KINOUID_GENGAKU,
                IT_KykKihon.TABLE_NAME,
                IT_KykKihon.HRKP);

            EntityUpdater<BT_HijynNykSikinIdouListSks> hijynNykSikinIdouListSksUpdLst = new EntityUpdater<>()) {

            for (HijynbrGengakuDataBean hijynbrGengakuDataBean : hijynbrGengakuDataBeanLst) {

                List<BT_HijynNykSikinIdouListSks> hijynNykSikinIdouListSksLst = null;

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(hijynbrGengakuDataBean.getSyono());

                gengkstartym = bzSikinIdouListDataSksHijynbrNykDao.getHokenryouTmttknTmttknTaisyouym(
                    hijynbrGengakuDataBean.getSyono(),
                    IKhozenCommonConstants.KINOUID_GENGAKU);

                hijynNykSikinIdouListSksLst =
                    bzSikinIdouListDataSksHijynbrNykDao.getGengakuHijynNykSikinIdouListData(
                        hijynbrGengakuDataBean.getSyono(),
                        gengkstartym);

                BizCurrency gengkmaegk = BizCurrency.valueOf(
                    Long.parseLong(hijynbrGengakuDataBean.getBfrnaiyou()), BizCurrencyTypes.YEN);

                BizCurrency gengkkougk = BizCurrency.valueOf(
                    Long.parseLong(hijynbrGengakuDataBean.getNewnaiyou()), BizCurrencyTypes.YEN);

                for (int n = 0; n < hijynNykSikinIdouListSksLst.size(); n++) {

                    BT_HijynNykSikinIdouListSks hijynNykSikinIdouListSks = hijynNykSikinIdouListSksLst
                        .get(n);

                    if (C_SikinidouJtKbn.SIKINIDOUMIRYOU.eq(hijynNykSikinIdouListSks.getSikinidoujtkbn())) {

                        if (BizDateUtil.compareYm(
                            hijynNykSikinIdouListSks.getSikinidoupjytym(), gengkstartym) == BizDateUtil.COMPARE_GREATER ||
                            BizDateUtil.compareYm(
                                hijynNykSikinIdouListSks.getSikinidoupjytym(), gengkstartym) == BizDateUtil.COMPARE_EQUAL) {

                            kanzanmaegkYen = gengkkougk;
                        }
                        else {

                            kanzanmaegkYen = gengkmaegk;
                        }
                    }
                    else if (C_SikinidouJtKbn.SIKINIDOUKANRYOU.eq(hijynNykSikinIdouListSks.getSikinidoujtkbn())) {

                        kanzanmaegkYen = gengkkougk;
                    }

                    hijynNykSikinIdouListSks.setTrhktuukagk(kanzanmaegkYen);

                    if (hijynNykSikinIdouListSks.getSikinidoukawaserate().compareTo(BizNumber.ZERO) > 0) {
                        KeisanGaikakanzan keisanGaikakanzan =SWAKInjector.getInstance(KeisanGaikakanzan.class);

                        BizCurrency kanzanGaku = keisanGaikakanzan.execDivide(
                            hijynNykSikinIdouListSks.getSiteituuka(),
                            kanzanmaegkYen,
                            hijynNykSikinIdouListSks.getSikinidoukawaserate(),
                            C_HasuusyoriKbn.AGE);

                        hijynNykSikinIdouListSks.setSiteituukagk(kanzanGaku);
                    }
                    BizPropertyInitializer.initialize(hijynNykSikinIdouListSks);

                    hijynNykSikinIdouListSksUpdLst.add(hijynNykSikinIdouListSks);

                    syoriKensuu++;
                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            bizDomManager.flush();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    private List<BT_HijynNykSikinIdouListSks> InsHijynNykSikinIdouListSksLst(
        HijynbrNykDataBean pHijynbrNykDataBean,
        BizDateYM pJyutouendym,
        int pJyutoukaisuu) {

        List<BT_HijynNykSikinIdouListSks> hijynNykSikinIdouListSksLst = new ArrayList<BT_HijynNykSikinIdouListSks>();

        C_SikinidougroupKbn sikinidougroupKbn;

        C_SikinidouPKbn sikinidouPKbn;

        BM_SikinIdouGroup sikinIdouGroup = bizDomManager.getSikinIdouGroup(pHijynbrNykDataBean.getSegcd());

        if (sikinIdouGroup == null) {

            sikinidougroupKbn = C_SikinidougroupKbn.BLNK;
        }
        else {

            sikinidougroupKbn = sikinIdouGroup.getSikinidougroupkbn();
        }

        C_SikinidoumeisaiKbn sikinidoumeisaiKbn = C_SikinidoumeisaiKbn.BLNK;

        BizDateYM sikinidoupjytym = pJyutouendym;

        if (C_NyknaiyouKbn.SYOKAIP.eq(pHijynbrNykDataBean.getNyknaiyoukbn())) {

            sikinidouPKbn = C_SikinidouPKbn.FSTP;
        }
        else {

            sikinidouPKbn = C_SikinidouPKbn.KEIZOKUP;
        }

        C_SikinidouJtKbn sikinidouJtKbn = C_SikinidouJtKbn.SIKINIDOUMIRYOU;

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        for (int i = 0; i < pJyutoukaisuu; i++) {

            BT_HijynNykSikinIdouListSks hijynNykSikinIdouListSks = new BT_HijynNykSikinIdouListSks();

            BizCurrency pkyktuuka = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(pHijynbrNykDataBean.getKyktuukasyu()));

            BizNumber kawaserate = BizNumber.valueOf(0);

            KeisanGaikaP keisanGaikaP = SWAKInjector.getInstance(KeisanGaikaP.class);

            C_ErrorKbn errkbn = keisanGaikaP.exec(
                pHijynbrNykDataBean.getHrkp(),
                pHijynbrNykDataBean.getKyktuukasyu(),
                sikinidoupjytym,
                pHijynbrNykDataBean.getKykymd(),
                pHijynbrNykDataBean.getFstpnyknymd());

            if (C_ErrorKbn.OK.eq(errkbn)) {
                pkyktuuka = keisanGaikaP.getP();

                kawaserate = keisanGaikaP.getKawaseRate();
            }

            hijynNykSikinIdouListSks.setSyono(pHijynbrNykDataBean.getSyono());

            hijynNykSikinIdouListSks.setSikinidoupjytym(sikinidoupjytym);

            hijynNykSikinIdouListSks.setSyoriYmd(syoriYmd);

            hijynNykSikinIdouListSks.setSiteituuka(pHijynbrNykDataBean.getKyktuukasyu());

            hijynNykSikinIdouListSks.setSiteituukagk(pkyktuuka);

            hijynNykSikinIdouListSks.setTrhktuuka(pHijynbrNykDataBean.getRstuukasyu());

            hijynNykSikinIdouListSks.setTrhktuukagk(pHijynbrNykDataBean.getHrkp());

            hijynNykSikinIdouListSks.setSeg1cd(pHijynbrNykDataBean.getSegcd());

            hijynNykSikinIdouListSks.setSikinidougroupkbn(sikinidougroupKbn);

            hijynNykSikinIdouListSks.setSikinidoumeisaikbn(sikinidoumeisaiKbn);

            hijynNykSikinIdouListSks.setSikinidoujtkbn(sikinidouJtKbn);

            hijynNykSikinIdouListSks.setSikinidoukawaserate(kawaserate);

            hijynNykSikinIdouListSks.setSikinidoupkbn(sikinidouPKbn);

            hijynNykSikinIdouListSksLst.add(hijynNykSikinIdouListSks);

            sikinidoupjytym = sikinidoupjytym.getNextMonth();

            sikinidouPKbn = C_SikinidouPKbn.KEIZOKUP;
        }

        return hijynNykSikinIdouListSksLst;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}