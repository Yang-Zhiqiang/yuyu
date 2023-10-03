package yuyu.batch.suuri.srmaster.srpratetorikomi;

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
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_RateP;
import yuyu.def.db.entity.ZT_RatepRn;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 連携用DB（Ｐレートファイルテーブル（連））を読み込み、Ｐレートマスタに反映するクラス
 */
public class SrPrateTorikomiBatch implements Batch {

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

        try (ExDBResults<ZT_RatepRn> exDBResults = zdbDomManager.getAllRatepRn()) {

            Iterator<ZT_RatepRn> iterator = exDBResults.iterator();

            if (!iterator.hasNext()) {

                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF1001, "Ｐレートテーブル（連）"));

            }

            try (EntityInserter<BM_RateP> entityInserter = new EntityInserter<>()) {

                BM_RateP bmRateP = null;
                BM_RateP bmRatePSearch = null;
                while (iterator.hasNext()) {

                    bmRateP = createRatePData(iterator.next());

                    bmRatePSearch = bizDomManager.getRateP(bmRateP.getPalhokensyuruikigou(),
                        bmRateP.getPalhokensyuruikigousdicode(),
                        bmRateP.getPalyoteiriritu(),
                        bmRateP.getPalpmencode(),
                        bmRateP.getPalharaikomikaisuu(),
                        bmRateP.getPalhhknsei(),
                        bmRateP.getPalkeiyakujihhknnen(),
                        bmRateP.getPalsaimankihyouji(),
                        bmRateP.getPalhokenkikan(),
                        bmRateP.getPalpharaikomikikan());

                    if (bmRatePSearch != null) {

                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBA1007,
                            bmRateP.getPalhokensyuruikigou().
                            concat(bmRateP.getPalhokensyuruikigousdicode()).
                            concat(bmRateP.getPalyoteiriritu()).
                            concat(bmRateP.getPalpmencode()).
                            concat(bmRateP.getPalharaikomikaisuu()).
                            concat(bmRateP.getPalhhknsei()).
                            concat(bmRateP.getPalkeiyakujihhknnen()).
                            concat(bmRateP.getPalsaimankihyouji()).
                            concat(bmRateP.getPalhokenkikan()).
                            concat(bmRateP.getPalpharaikomikikan()),
                            "Ｐレートマスタ"));

                    }

                    BizPropertyInitializer.initialize(bmRateP);

                    entityInserter.add(bmRateP);

                    syoriCount++;
                }
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriCount)));

    }

    private BM_RateP createRatePData(ZT_RatepRn pZtRatepRn) {

        BM_RateP bmRateP = new BM_RateP();

        bmRateP.setPalhokensyuruikigou(pZtRatepRn.getZrnhknsyukigou());
        bmRateP.setPalhokensyuruikigousdicode(pZtRatepRn.getZrnhknsyuruikigousedaikbn());
        bmRateP.setPalyoteiriritu(pZtRatepRn.getZrnyoteiriritu());
        bmRateP.setPalpmencode(pZtRatepRn.getZrnpmenkbn());
        bmRateP.setPalharaikomikaisuu(pZtRatepRn.getZrnhrkkaisuukbn());
        bmRateP.setPalhhknsei(pZtRatepRn.getZrnhhknsei());
        bmRateP.setPalkeiyakujihhknnen(pZtRatepRn.getZrnkeiyakujihhknnen());
        bmRateP.setPalsaimankihyouji(pZtRatepRn.getZrnsaimnkkykhyj());
        bmRateP.setPalhokenkikan(pZtRatepRn.getZrnhknkkn());
        bmRateP.setPalpharaikomikikan(pZtRatepRn.getZrnphrkkikn());
        bmRateP.setPrate(BizNumber.valueOf(pZtRatepRn.getZrnprate()));
        bmRateP.setPdatesrate(BizNumber.valueOf(pZtRatepRn.getZrnpdatesrate()));

        return bmRateP;
    }

}
