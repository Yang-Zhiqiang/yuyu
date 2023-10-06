package yuyu.batch.biz.bzmaster.bzbosyuunintorikomi;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzRenkeiHenkanUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_BosyuuKbn;
import yuyu.def.classification.C_BsKahiKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SystemRenkeiSyoriHousikiKbn;
import yuyu.def.db.entity.BM_Bosyuunin;
import yuyu.def.db.entity.ZT_BosyuuninRn;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 連携用DB（募集人ＰＲＴ用連動Ｆテーブル（連））を読み込み、募集人マスタに反映するクラス
 */
public class BzBosyuuninTorikomiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private ZdbDomManager zdbDomManager;

    @Inject
    private BzBosyuuninTorikomiDao bzBosyuuninTorikomiDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    public void execute() {

        Long bosyuuninRnCount = zdbDomManager.getBosyuuninRnCount();

        if (bosyuuninRnCount == 0) {

            throw new BizAppException(MessageId.EBF1001, "募集人ＰＲＴ用連動Ｆテーブル（連）");

        }

        deleteBosyuuninData();

        BzRenkeiHenkanUtil<BM_Bosyuunin, BM_Bosyuunin> bzRenkeiHenkanUtil = new BzRenkeiHenkanUtil<>();
        Long goukeiSyoriCount = 0L;

        bzRenkeiHenkanUtil.initialize(BM_Bosyuunin.class, C_SystemRenkeiSyoriHousikiKbn.KYOUYUU_DISC,
            C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY);

        for (int n = 0; n < 10; n++){
            goukeiSyoriCount += registBosyuuninData(bzRenkeiHenkanUtil,n);
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(goukeiSyoriCount)));
    }

    @Transactional
    void deleteBosyuuninData() {

        bzBosyuuninTorikomiDao.deleteBosyuunin();
    }

    @Transactional
    Long registBosyuuninData(BzRenkeiHenkanUtil<BM_Bosyuunin, BM_Bosyuunin> pBzRenkeiHenkanUtil,int pBunkatuKensakuti) {

        Long syoriCount = 0L;

        try (EntityInserter<BM_Bosyuunin> entityInserter = new EntityInserter<>();
            ExDBResults<ZT_BosyuuninRn> exDBResults =
                zdbDomManager.getBosyuuninRnsByZrnbosyuunincdKeta6(String.valueOf(pBunkatuKensakuti))) {

            BM_Bosyuunin bmBosyuunin = null;
            for (ZT_BosyuuninRn ztBosyuuninRn : exDBResults) {

                bmBosyuunin = createBosyuuninData(ztBosyuuninRn);

                bmBosyuunin = pBzRenkeiHenkanUtil.convDouituBean(bmBosyuunin);

                BizPropertyInitializer.initialize(bmBosyuunin);

                entityInserter.add(bmBosyuunin);

                syoriCount++;
            }
        }

        return syoriCount;
    }

    private BM_Bosyuunin createBosyuuninData(ZT_BosyuuninRn pZtBosyuuninRn) {

        BM_Bosyuunin bmBosyuunin = new BM_Bosyuunin();

        BzRenkeiHenkanUtil<?, ?> bzRenkeiHenkanUtil =
            SWAKInjector.getInstance(BzRenkeiHenkanUtil.class);

        bmBosyuunin.setBosyuucd(pZtBosyuuninRn.getZrnbosyuunincd());
        bmBosyuunin.setBosyuunm(pZtBosyuuninRn.getZrnbosyuuninnm());
        bmBosyuunin.setKanjibosyuuninnm(pZtBosyuuninRn.getZrnkanjibosyuuninnm());
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtBosyuuninRn.getZrnitakuymd());
        bmBosyuunin.setItakuymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        bmBosyuunin.setDairiten1cd(pZtBosyuuninRn.getZrndairitencd1());
        bmBosyuunin.setDairiten2cd(pZtBosyuuninRn.getZrndairitencd2());
        bmBosyuunin.setDairiten3cd(pZtBosyuuninRn.getZrndairitencd3());
        bmBosyuunin.setDairitenkanrisosikicd1(pZtBosyuuninRn.getZrndairitenkanrisskcd1());
        bmBosyuunin.setDairitenkanrisosikicd2(BizUtil.zero2blank(pZtBosyuuninRn.getZrndairitenkanrisskcd2()));
        bmBosyuunin.setDairitenkanrisosikicd3(BizUtil.zero2blank(pZtBosyuuninRn.getZrndairitenkanrisskcd3()));
        bmBosyuunin.setBosyuukbn(C_BosyuuKbn.valueOf(pZtBosyuuninRn.getZrnbosyuukbn()));
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtBosyuuninRn.getZrnbosyuunintourokuymd());
        bmBosyuunin.setBosyuunintourokuymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        bmBosyuunin.setBosyuukahikbn(C_BsKahiKbn.valueOf(pZtBosyuuninRn.getZrnbosyuuninkahikbn()));
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtBosyuuninRn.getZrnbosyuuningyouhaiymd());
        bmBosyuunin.setBosyuuningyouhaiymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtBosyuuninRn.getZrnhengakutourokuymd());
        bmBosyuunin.setHngkhknskktrkymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtBosyuuninRn.getZrnhengakumassyouymd());
        bmBosyuunin.setHngkhknskktrkmsuymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtBosyuuninRn.getZrnbosyuuseiymd());
        bmBosyuunin.setBosyuuseiymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtBosyuuninRn.getZrnitakukaiyakuymd());
        bmBosyuunin.setItakukaiyakuymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        bmBosyuunin.setDaibosyuucd(pZtBosyuuninRn.getZrndaihyoubosyuunincd());
        bmBosyuunin.setBosyuutrkno(pZtBosyuuninRn.getZrnbosyuutourokuno());

        return bmBosyuunin;
    }

}
