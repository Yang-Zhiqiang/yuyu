package yuyu.batch.biz.bzmaster.bzdairitensyougoutorikomi;

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
import yuyu.def.db.entity.BM_DairitenSyougou;
import yuyu.def.db.entity.ZT_DairitenSyougouRn;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 連携用DB（代理店法人商号連動ULFテーブル（連））を読み込み、代理店法人商号マスタに反映するクラス
 */
public class BzDairitenSyougouTorikomiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private ZdbDomManager zdbDomManager;

    @Inject
    private BzDairitenSyougouTorikomiDao bzDairitenSyougouTorikomiDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        Long dairitenSyougouRnCount = zdbDomManager.getDairitenSyougouRnCount();

        if (dairitenSyougouRnCount == 0) {

            throw new BizAppException(MessageId.EBF1001, "代理店法人商号連動ULFテーブル（連）");
        }

        deleteDairitenSyougouData();

        BzRenkeiHenkanUtil<BM_DairitenSyougou, BM_DairitenSyougou> bzRenkeiHenkanUtil = new BzRenkeiHenkanUtil<>();

        bzRenkeiHenkanUtil.initialize(BM_DairitenSyougou.class, C_SystemRenkeiSyoriHousikiKbn.KYOUYUU_DISC,
            C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY);

        dairitenSyougouRnCount = registDairitenSyougouData(bzRenkeiHenkanUtil);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(dairitenSyougouRnCount)));
    }

    private void deleteDairitenSyougouData() {

        bzDairitenSyougouTorikomiDao.deleteDairitenSyougou();
    }

    @Transactional
    Long registDairitenSyougouData(
        BzRenkeiHenkanUtil<BM_DairitenSyougou, BM_DairitenSyougou> pBzRenkeiHenkanUtil) {

        Long syoriCount = 0L;

        try (EntityInserter<BM_DairitenSyougou> entityInserter = new EntityInserter<>();
            ExDBResults<ZT_DairitenSyougouRn> exDBResults = zdbDomManager.getAllDairitenSyougouRn()) {

            BM_DairitenSyougou dairitenSyougou = null;
            for (ZT_DairitenSyougouRn ztDairitenSyougouRn : exDBResults) {

                dairitenSyougou = createDairitenSyougouData(ztDairitenSyougouRn);

                dairitenSyougou = pBzRenkeiHenkanUtil.convDouituBean(dairitenSyougou);

                BizPropertyInitializer.initialize(dairitenSyougou);

                entityInserter.add(dairitenSyougou);

                syoriCount++;
            }

        }

        return syoriCount;
    }

    private BM_DairitenSyougou createDairitenSyougouData(ZT_DairitenSyougouRn pZtDairitenSyougouRn) {

        BM_DairitenSyougou dairitenSyougou = new BM_DairitenSyougou();

        dairitenSyougou.setDrtencd(pZtDairitenSyougouRn.getZrndairitencd());

        dairitenSyougou.setKanjihoujinsyougou(pZtDairitenSyougouRn.getZrnkanjihoujinsyougou());

        return dairitenSyougou;
    }

}
