package yuyu.batch.biz.bzmaster.bzidcardtorikomi;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzRenkeiHenkanUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SyoukaiKanouHyj;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SystemRenkeiSyoriHousikiKbn;
import yuyu.def.db.entity.BW_IdCardWk;
import yuyu.def.db.entity.ZT_IdCardKihonRn;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 連携用DB（IDカードF基本テーブル（連））を読み込み、ＩＤカードマスタワークテーブルに反映するクラスです。
 */
public class BzIdCardTorikomiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private ZdbDomManager zdbDomManager;

    @Inject
    private BzIdCardTorikomiDao bzIdCardTorikomiDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    public void execute() {

        Long idCardKihonRnCount = zdbDomManager.getIdCardKihonRnCount();

        if (idCardKihonRnCount == 0) {

            throw new BizAppException(MessageId.EBF1001, "IDカードF基本テーブル（連）");
        }

        deleteIdCardWkData();

        BzRenkeiHenkanUtil<BW_IdCardWk, BW_IdCardWk> bzRenkeiHenkanUtil = new BzRenkeiHenkanUtil<>();
        Long goukeiSyoriCount = 0L;

        bzRenkeiHenkanUtil.initialize(BW_IdCardWk.class, C_SystemRenkeiSyoriHousikiKbn.KYOUYUU_DISC,
            C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY);

        for (int n = 0; n < 10; n++){
            goukeiSyoriCount += registIdCardWkData(bzRenkeiHenkanUtil,n);
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(goukeiSyoriCount)));

    }

    @Transactional
    void deleteIdCardWkData() {

        bzIdCardTorikomiDao.deleteIdCardWk();

    }

    @Transactional
    Long registIdCardWkData(BzRenkeiHenkanUtil<BW_IdCardWk, BW_IdCardWk> pBzRenkeiHenkanUtil, int pBunkatuKensakuti) {

        Long syoriCount = 0L;

        try (ExDBResults<ZT_IdCardKihonRn> exDBResults =
            zdbDomManager.getIdCardKihonRnsByZrnidcdKeta6(String.valueOf(pBunkatuKensakuti))) {

            try (EntityInserter<BW_IdCardWk> entityInserter = new EntityInserter<>()) {

                BW_IdCardWk bwIdCardWk = null;
                for (ZT_IdCardKihonRn ztIdCardKihonRn : exDBResults) {

                    bwIdCardWk = createIdCardWkData(ztIdCardKihonRn);

                    bwIdCardWk = pBzRenkeiHenkanUtil.convDouituBean(bwIdCardWk);

                    BizPropertyInitializer.initialize(bwIdCardWk);

                    entityInserter.add(bwIdCardWk);

                    syoriCount++;
                }

            }
        }

        return syoriCount;
    }

    private BW_IdCardWk createIdCardWkData(ZT_IdCardKihonRn pZtIdCardKihonRn) {

        BW_IdCardWk bwIdCardWk = new BW_IdCardWk();

        BzRenkeiHenkanUtil<?, ?> bzRenkeiHenkanUtil =
            SWAKInjector.getInstance(BzRenkeiHenkanUtil.class);

        bwIdCardWk.setIdkbn(pZtIdCardKihonRn.getZrnidkbn());
        bwIdCardWk.setIdcd(pZtIdCardKihonRn.getZrnidcd());
        bwIdCardWk.setTanmatusiyoukbn(pZtIdCardKihonRn.getZrntanmatusiyoukbn());
        bwIdCardWk.setAccesskbn(pZtIdCardKihonRn.getZrnaccesskbn());
        bwIdCardWk.setIdnyuuryokusyanm(pZtIdCardKihonRn.getZrnidnyuuryokusyanm());
        bwIdCardWk.setKanjiidnyuuryokusyanm(pZtIdCardKihonRn.getZrnkanjiidnyuuryokusyanm());
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtIdCardKihonRn.getZrnidnyuuryokusyaseiymd());
        bwIdCardWk.setIdnyuuryokusyaseiymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtIdCardKihonRn.getZrnidnyuuryokusyanyuusyaymd());
        bwIdCardWk.setIdnyuuryokusyanyuusyaymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        bwIdCardWk.setSyozokusosikicd(pZtIdCardKihonRn.getZrnsyozokusosikicd());
        bwIdCardWk.setSyozokusisyacd(pZtIdCardKihonRn.getZrnsyozokusisyacd());
        bwIdCardWk.setSyozokusibucd(pZtIdCardKihonRn.getZrnsyozokusibucd());
        bwIdCardWk.setIdnyuuryokusyasikakucd(pZtIdCardKihonRn.getZrnidnyuuryokusyasikakucd());
        bwIdCardWk.setIdsdpsouhuhyouji(pZtIdCardKihonRn.getZrnidsdpsouhuhyouji());
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtIdCardKihonRn.getZrnidcardsaisyuukousinymd());
        bwIdCardWk.setIdcardsaisyuukousinymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtIdCardKihonRn.getZrnidcardmukouymd());
        bwIdCardWk.setIdcardmukouymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        bwIdCardWk.setKaikeitantousyakbn(pZtIdCardKihonRn.getZrnkaikeitantousyakbn());
        bwIdCardWk.setSyanaiyokintantousyakbn(pZtIdCardKihonRn.getZrnsyanaiyokintantousyakbn());
        bwIdCardWk.setJinjimynosyoukaihyj(C_SyoukaiKanouHyj.valueOf(pZtIdCardKihonRn.getZrnjinjimynosyoukaihyj()));
        bwIdCardWk.setEisyokumynosyoukaihyj(C_SyoukaiKanouHyj.valueOf(pZtIdCardKihonRn.getZrneisyokumynosyoukaihyj()));
        bwIdCardWk.setHudousanmynosyoukaihyj(C_SyoukaiKanouHyj.valueOf(pZtIdCardKihonRn.getZrnhudousanmynosyoukaihyj()));
        bwIdCardWk.setKohomynosyoukaihyj(C_SyoukaiKanouHyj.valueOf(pZtIdCardKihonRn.getZrnkohomynosyoukaihyj()));
        bwIdCardWk.setKihomynosyoukaihyj(C_SyoukaiKanouHyj.valueOf(pZtIdCardKihonRn.getZrnkihomynosyoukaihyj()));
        bwIdCardWk.setKikantantoukbn(pZtIdCardKihonRn.getZrnkikantantoukbn());

        return bwIdCardWk;
    }

}
