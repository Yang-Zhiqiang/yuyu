package yuyu.batch.biz.bzkaikei.bzhojyoboruikeigakuteisei;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.bzkaikei.bzhojyoboruikeigakuteisei.dba.BzHojyoboRuikeigakuTeiseiDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BT_Hjybruikeigaku;
import yuyu.def.db.entity.BV_HjybruikeigakuData;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 経理・会計 補助簿累計額訂正
 */
public class BzHojyoboRuikeigakuTeiseiBatch implements Batch {

    private static final String TABLE_ID = "BV_HjybruikeigakuData";

    private static final String RECOVERY_FILTER_KBNID = "Bz108";

    private static final String APRIL = "04";

    private static final BizCurrency ZERO_YEN = BizCurrency.valueOf(0);

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private BzHojyoboRuikeigakuTeiseiDao bzHojyoboRuikeigakuTeiseiDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        int count = 0;
        BizDateYM denYm = BizDateYM.valueOf(bzBatchParam.getSyoriYmd().getYear() + APRIL);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            bzBatchParam.getSyoriYmd().toString()));

        try (EntityInserter<BT_Hjybruikeigaku> hjybruikeigakuListEntityInserter = new EntityInserter<>();
            ExDBResults<BV_HjybruikeigakuData> hjybruikeigakuDataLst =
                bzHojyoboRuikeigakuTeiseiDao.getHjybruikeigakuData(bzBatchParam.getIbKakutyoujobcd())) {

            for (BV_HjybruikeigakuData hjybruikeigakuData : hjybruikeigakuDataLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(hjybruikeigakuData.getHjybtantositucd());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(hjybruikeigakuData.getKanjyoukmkcd().getValue());

                if (hjybruikeigakuData.getKarikatateiseigk() != null ||
                    hjybruikeigakuData.getKasikatateiseigk() != null) {
                    BT_Hjybruikeigaku hjybruikeigaku = getHjybruikeigaku(hjybruikeigakuData.getHjybtantositucd(),
                        hjybruikeigakuData.getKanjyoukmkcd(), denYm, hjybruikeigakuData.getKarikatateiseigk(),
                        hjybruikeigakuData.getKasikatateiseigk());

                    hjybruikeigakuListEntityInserter.add(hjybruikeigaku);
                }
                else {
                    if (C_UmuKbn.NONE.eq(hjybruikeigakuData.getHjybruigkteiseiumukbn())) {
                        BT_Hjybruikeigaku hjybruikeigaku = getHjybruikeigaku(hjybruikeigakuData.getHjybtantositucd(),
                            hjybruikeigakuData.getKanjyoukmkcd(), denYm, ZERO_YEN, ZERO_YEN);

                        hjybruikeigakuListEntityInserter.add(hjybruikeigaku);
                    }
                }

                count++;
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(count)));
    }

    private BT_Hjybruikeigaku getHjybruikeigaku(String pHjybtantositucd, C_Kanjyoukmkcd pKanjyoukmkcd,
        BizDateYM pDenym, BizCurrency pKarikataruigk, BizCurrency pKasikataruigk) {

        BT_Hjybruikeigaku hjybruikeigaku = new BT_Hjybruikeigaku();

        hjybruikeigaku.setHjybtantositucd(pHjybtantositucd);
        hjybruikeigaku.setKanjyoukmkcd(pKanjyoukmkcd);
        hjybruikeigaku.setDenym(pDenym);
        hjybruikeigaku.setKarikataruigk(pKarikataruigk);
        hjybruikeigaku.setKasikataruigk(pKasikataruigk);

        BizPropertyInitializer.initialize(hjybruikeigaku);

        return hjybruikeigaku;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
