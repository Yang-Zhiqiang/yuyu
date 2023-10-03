package yuyu.batch.suuri.srmaster.srprate2torikomi;

import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.biz.detacher.BM_RateP2Detacher;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_RateP2;
import yuyu.def.db.entity.ZT_Ratep2Rn;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理 マスタ取込 マスタ取込（Ｐレートマスタ２）クラス
 */
public class SrPrate2TorikomiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private ZdbDomManager zdbDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        Long syoriCount = 0L;

        Long jyuuhukuCount = 0L;

        try (ExDBResults<ZT_Ratep2Rn> exDBResults = zdbDomManager.getAllRatep2Rn()) {

            Iterator<ZT_Ratep2Rn> iterator = exDBResults.iterator();

            if (!iterator.hasNext()) {

                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF1001, "Ｐレートテーブル２（連）"));

            }

            try (EntityInserter<BM_RateP2> entityInserter = new EntityInserter<>()) {

                BM_RateP2 bmRateP2 = null;
                BM_RateP2 bmRateP2Search = null;
                while (iterator.hasNext()) {

                    bmRateP2 = createRateP2Data(iterator.next());

                    bmRateP2Search = bizDomManager.getRateP2(bmRateP2.getPalhokensyuruikigou(),
                        bmRateP2.getPalhokensyuruikigousdicode(),
                        bmRateP2.getPalyoteiriritu(),
                        bmRateP2.getPalpmencode(),
                        bmRateP2.getPalharaikomikaisuu(),
                        bmRateP2.getPalhhknsei(),
                        bmRateP2.getPalkeiyakujihhknnen(),
                        bmRateP2.getPalsaimankihyouji(),
                        bmRateP2.getPalhokenkikan(),
                        bmRateP2.getPalpharaikomikikan(),
                        bmRateP2.getPalannaihuyouriyuukbn(),
                        bmRateP2.getRatetuukasyukbn(),
                        bmRateP2.getRatedai1hknkkn(),
                        bmRateP2.getPalryouritukbn());

                    bmRateP2Search = BM_RateP2Detacher.detachRateP2touched(bmRateP2Search);

                    if (bmRateP2Search != null) {

                        jyuuhukuCount++;

                        continue;
                    }

                    BizPropertyInitializer.initialize(bmRateP2);

                    entityInserter.add(bmRateP2);

                    syoriCount++;
                }
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriCount)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF1011, String.valueOf(jyuuhukuCount)));

    }

    private BM_RateP2 createRateP2Data(ZT_Ratep2Rn pZtRatep2Rn) {

        BM_RateP2 bmRateP2 = new BM_RateP2();

        bmRateP2.setPalhokensyuruikigou(pZtRatep2Rn.getZrnhknsyukigou());
        bmRateP2.setPalhokensyuruikigousdicode(pZtRatep2Rn.getZrnhknsyuruikigousedaikbn());
        bmRateP2.setPalyoteiriritu(pZtRatep2Rn.getZrnyoteiriritu());
        bmRateP2.setPalpmencode(pZtRatep2Rn.getZrnpmenkbn());
        bmRateP2.setPalharaikomikaisuu(pZtRatep2Rn.getZrnhrkkaisuukbn());
        bmRateP2.setPalhhknsei(pZtRatep2Rn.getZrnhhknsei());
        bmRateP2.setPalkeiyakujihhknnen(pZtRatep2Rn.getZrnkeiyakujihhknnen());
        bmRateP2.setPalsaimankihyouji(pZtRatep2Rn.getZrnsaimnkkykhyj());
        bmRateP2.setPalhokenkikan(pZtRatep2Rn.getZrnhknkkn());
        bmRateP2.setPalpharaikomikikan(pZtRatep2Rn.getZrnphrkkikn());
        bmRateP2.setPalannaihuyouriyuukbn(pZtRatep2Rn.getZrnannaifuyouriyuukbn());
        bmRateP2.setRatetuukasyukbn(pZtRatep2Rn.getZrntuukasyukbn());
        bmRateP2.setRatedai1hknkkn(pZtRatep2Rn.getZrndai1hknkkn());
        bmRateP2.setPalryouritukbn(pZtRatep2Rn.getZrnryouritukbn());
        bmRateP2.setPrate(BizNumber.valueOf(pZtRatep2Rn.getZrnprate()));
        bmRateP2.setPdatesrate(BizNumber.valueOf(pZtRatep2Rn.getZrnpdatesrate()));

        return bmRateP2;
    }

}
