package yuyu.batch.biz.bzmaster.bztokuteikankeihoujintorikomi;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzRenkeiHenkanUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SystemRenkeiSyoriHousikiKbn;
import yuyu.def.db.entity.HM_TokuteiKankeiHoujin;
import yuyu.def.db.entity.ZT_TokuteiKankeiHoujinRn;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 連携用DB（特定関係法人マスタテーブル（連））を読み込み、特定関係法人マスタに反映するクラス
 */
public class BzTokuteiKankeiHoujinTorikomiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private ZdbDomManager zdbDomManager;

    @Inject
    private BzTokuteiKankeiHoujinTorikomiDao bzTokuteiKankeiHoujinTorikomiDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        Long tokuteiKankeiHoujinRnCount = zdbDomManager.getTokuteiKankeiHoujinRnCount();

        if (tokuteiKankeiHoujinRnCount == 0) {

            throw new BizAppException(MessageId.EBF1001, "特定関係法人マスタテーブル（連）");
        }

        deleteTokuteiKankeiHoujinData();

        BzRenkeiHenkanUtil<HM_TokuteiKankeiHoujin, HM_TokuteiKankeiHoujin> bzRenkeiHenkanUtil =
            new BzRenkeiHenkanUtil<>();

        bzRenkeiHenkanUtil.initialize(HM_TokuteiKankeiHoujin.class, C_SystemRenkeiSyoriHousikiKbn.KYOUYUU_DISC,
            C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY);

        tokuteiKankeiHoujinRnCount = registTokuteiKankeiHoujinData(bzRenkeiHenkanUtil);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(tokuteiKankeiHoujinRnCount)));

    }

    private void deleteTokuteiKankeiHoujinData() {

        bzTokuteiKankeiHoujinTorikomiDao.deleteTokuteiKankeiHoujin();

    }

    @Transactional
    Long registTokuteiKankeiHoujinData(BzRenkeiHenkanUtil<HM_TokuteiKankeiHoujin,
        HM_TokuteiKankeiHoujin> pBzRenkeiHenkanUtil) {

        Long syoriCount = 0L;

        try (ExDBResults<ZT_TokuteiKankeiHoujinRn> exDBResults = zdbDomManager.getAllTokuteiKankeiHoujinRn();
            EntityInserter<HM_TokuteiKankeiHoujin> entityInserter = new EntityInserter<>()) {

            HM_TokuteiKankeiHoujin hmTokuteiKankeiHoujin = null;
            for (ZT_TokuteiKankeiHoujinRn ztTokuteiKankeiHoujinRn : exDBResults) {

                hmTokuteiKankeiHoujin = createTokuteiKankeiHoujinData(ztTokuteiKankeiHoujinRn);

                hmTokuteiKankeiHoujin = pBzRenkeiHenkanUtil.convDouituBean(hmTokuteiKankeiHoujin);

                BizPropertyInitializer.initialize(hmTokuteiKankeiHoujin);

                entityInserter.add(hmTokuteiKankeiHoujin);

                syoriCount++;

            }
        }

        return syoriCount;
    }

    private HM_TokuteiKankeiHoujin createTokuteiKankeiHoujinData(ZT_TokuteiKankeiHoujinRn pZtTokuteiKankeiHoujinRn) {

        HM_TokuteiKankeiHoujin hmTokuteiKankeiHoujin = new HM_TokuteiKankeiHoujin();

        BzRenkeiHenkanUtil<?, ?> bzRenkeiHenkanUtil =
            SWAKInjector.getInstance(BzRenkeiHenkanUtil.class);

        hmTokuteiKankeiHoujin.setTkhjnkinyuucd(pZtTokuteiKankeiHoujinRn.getZrnkinyuukikancd());
        hmTokuteiKankeiHoujin.setMeisaino(BizNumber.valueOf(
            Integer.valueOf(pZtTokuteiKankeiHoujinRn.getZrnmeisaibangou())));
        hmTokuteiKankeiHoujin.setMarukinhyouji(pZtTokuteiKankeiHoujinRn.getZrnmarukinhyouji());
        hmTokuteiKankeiHoujin.setTkhjnkjdrtennm(pZtTokuteiKankeiHoujinRn.getZrntkhjnkjdrtennm());
        hmTokuteiKankeiHoujin.setDairitenbtno(Integer.valueOf(pZtTokuteiKankeiHoujinRn.getZrndairitenbetutuuban()));
        hmTokuteiKankeiHoujin.setTkhjnnmkj(pZtTokuteiKankeiHoujinRn.getZrnkanjitokuteikankeinm());
        hmTokuteiKankeiHoujin.setTkhjnnmkn(pZtTokuteiKankeiHoujinRn.getZrntokuteikankeihoujinnm());
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtTokuteiKankeiHoujinRn.getZrnkousinymd());
        hmTokuteiKankeiHoujin.setKosymd(bzRenkeiHenkanUtil.getConvYmdBizDate());

        return hmTokuteiKankeiHoujin;
    }

}
