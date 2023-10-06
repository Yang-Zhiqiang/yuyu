package yuyu.batch.biz.bzmaster.bzkouintorikomi;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzRenkeiHenkanUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SystemRenkeiSyoriHousikiKbn;
import yuyu.def.db.entity.BM_Kouin;
import yuyu.def.db.entity.ZT_HonyakuYouKouinRn;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 連携用DB（翻訳用行員Ｆ用連動Ｆテーブル（連））を読み込み、行員マスタに反映するクラス
 */
public class BzKouinTorikomiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private ZdbDomManager zdbDomManager;

    @Inject
    private BzKouinTorikomiDao bzKouinTorikomiDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    public void execute() {

        Long honyakuYouKouinRnCount = zdbDomManager.getHonyakuYouKouinRnCount();

        if (honyakuYouKouinRnCount == 0) {

            throw new BizAppException(MessageId.EBF1001, "翻訳用行員Ｆ用連動Ｆテーブル（連）");

        }

        deleteKouinData();

        BzRenkeiHenkanUtil<BM_Kouin, BM_Kouin> bzRenkeiHenkanUtil = new BzRenkeiHenkanUtil<>();
        Long goukeiSyoriCount = 0L;

        bzRenkeiHenkanUtil.initialize(BM_Kouin.class, C_SystemRenkeiSyoriHousikiKbn.KYOUYUU_DISC,
            C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY);

        for (int n = 0; n < 10; n++){
            goukeiSyoriCount += registKouinData(bzRenkeiHenkanUtil,n);
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(goukeiSyoriCount)));
    }

    @Transactional
    void deleteKouinData() {

        bzKouinTorikomiDao.deleteKouin();
    }

    @Transactional
    Long registKouinData(BzRenkeiHenkanUtil<BM_Kouin, BM_Kouin> pBzRenkeiHenkanUtil,int pBunkatuKensakuti) {

        Long syoriCount = 0L;

        try (EntityInserter<BM_Kouin> entityInserter = new EntityInserter<>();
            ExDBResults<ZT_HonyakuYouKouinRn> exDBResults =
                zdbDomManager.getHonyakuYouKouinRnsByZrnkinyuukikancdKeta4(String.valueOf(pBunkatuKensakuti))) {

            BM_Kouin bmKouin = null;
            for (ZT_HonyakuYouKouinRn ztHonyakuYouKouinRn : exDBResults) {

                bmKouin = createKouinData(ztHonyakuYouKouinRn);

                bmKouin = pBzRenkeiHenkanUtil.convDouituBean(bmKouin);

                BizPropertyInitializer.initialize(bmKouin);

                entityInserter.add(bmKouin);

                syoriCount++;

            }
        }

        return syoriCount;
    }

    private BM_Kouin createKouinData(ZT_HonyakuYouKouinRn pZtHonyakuYouKouinRn) {

        BM_Kouin bmKouin = new BM_Kouin();

        bmKouin.setKinyuucd(pZtHonyakuYouKouinRn.getZrnkinyuukikancd());
        bmKouin.setKouincd(pZtHonyakuYouKouinRn.getZrnkouincd());
        bmKouin.setBosyuucd(pZtHonyakuYouKouinRn.getZrnbosyuunincd());

        return bmKouin;
    }

}
