package yuyu.batch.biz.bzmaster.bzbuntaninfotorikomi;

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
import yuyu.def.db.entity.BT_BuntanInfo;
import yuyu.def.db.entity.ZT_DairitenBuntanInfoRn;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 連携用DB（代理店手数料分担情報Ｆテーブル（連））を読み込み、分担情報テーブルに反映するクラス
 */
public class BzBuntanInfoTorikomiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private ZdbDomManager zdbDomManager;

    @Inject
    private BzBuntanInfoTorikomiDao bzBuntanInfoTorikomiDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        Long dairitenBuntanInfoRnCount = zdbDomManager.getDairitenBuntanInfoRnCount();

        if (dairitenBuntanInfoRnCount == 0) {

            throw new BizAppException(MessageId.EBF1001, "代理店手数料分担情報Ｆテーブル（連）");
        }

        deleteBuntanInfoData();

        BzRenkeiHenkanUtil<BT_BuntanInfo, BT_BuntanInfo> bzRenkeiHenkanUtil = new BzRenkeiHenkanUtil<>();

        bzRenkeiHenkanUtil.initialize(BT_BuntanInfo.class, C_SystemRenkeiSyoriHousikiKbn.KYOUYUU_DISC,
            C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY);

        dairitenBuntanInfoRnCount = registBuntanInfoData(bzRenkeiHenkanUtil);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(dairitenBuntanInfoRnCount)));

    }

    private void deleteBuntanInfoData() {

        bzBuntanInfoTorikomiDao.deleteBuntanInfo();

    }

    @Transactional
    Long registBuntanInfoData(BzRenkeiHenkanUtil<BT_BuntanInfo, BT_BuntanInfo> pBzRenkeiHenkanUtil) {

        Long syoriCount = 0L;

        try (ExDBResults<ZT_DairitenBuntanInfoRn> exDBResults = zdbDomManager.getAllDairitenBuntanInfoRn();
            EntityInserter<BT_BuntanInfo> entityInserter = new EntityInserter<>()) {

            BT_BuntanInfo btBuntanInfo = null;
            for (ZT_DairitenBuntanInfoRn ztDairitenBuntanInfoRn : exDBResults) {

                btBuntanInfo = createBuntanInfoData(ztDairitenBuntanInfoRn);

                btBuntanInfo = pBzRenkeiHenkanUtil.convDouituBean(btBuntanInfo);

                BizPropertyInitializer.initialize(btBuntanInfo);

                entityInserter.add(btBuntanInfo);

                syoriCount++;

            }
        }

        return syoriCount;
    }

    private BT_BuntanInfo createBuntanInfoData(ZT_DairitenBuntanInfoRn pZtDairitenBuntanInfoRn) {

        BT_BuntanInfo btBuntanInfo = new BT_BuntanInfo();

        BzRenkeiHenkanUtil<?, ?> bzRenkeiHenkanUtil =
            SWAKInjector.getInstance(BzRenkeiHenkanUtil.class);

        btBuntanInfo.setDrtencd(pZtDairitenBuntanInfoRn.getZrndairitencd());
        btBuntanInfo.setDairitensyouhincd(pZtDairitenBuntanInfoRn.getZrndairitensyouhincd());
        btBuntanInfo.setTesuuryoubuntandrtencd(pZtDairitenBuntanInfoRn.getZrntesuuryoubuntandrtencd());
        bzRenkeiHenkanUtil.convYmZeroToNull(pZtDairitenBuntanInfoRn.getZrntesuuryoubuntanstartym());
        btBuntanInfo.setTesuuryoubuntanstartym(bzRenkeiHenkanUtil.getConvYmBizDate());
        bzRenkeiHenkanUtil.convYmZeroToNull(pZtDairitenBuntanInfoRn.getZrntesuuryoubuntanendym());
        btBuntanInfo.setTesuuryoubuntanendym(bzRenkeiHenkanUtil.getConvYmBizDate());
        btBuntanInfo.setTesuuryoubuntanwariai(BizNumber.valueOf(pZtDairitenBuntanInfoRn.getZrntesuuryoubuntanwariai()));

        return btBuntanInfo;
    }

}
