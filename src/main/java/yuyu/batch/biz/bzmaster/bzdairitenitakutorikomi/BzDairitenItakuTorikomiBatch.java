package yuyu.batch.biz.bzmaster.bzdairitenitakutorikomi;

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
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SystemRenkeiSyoriHousikiKbn;
import yuyu.def.db.entity.BT_DairitenItakuSyouhn;
import yuyu.def.db.entity.ZT_DairitenItakuSyouhnRn;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 マスタ取込 マスタ取込（代理店委託商品情報テーブル）クラスです。
 */
public class BzDairitenItakuTorikomiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private ZdbDomManager zdbDomManager;

    @Inject
    private BzDairitenItakuTorikomiDao bzDairitenItakuTorikomiDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        Long dairitenItakuSyouhnRnCount = zdbDomManager.getDairitenItakuSyouhnRnCount();

        if (dairitenItakuSyouhnRnCount == 0) {

            throw new BizAppException(MessageId.EBF1001, "代理店委託商品情報用連動Ｆテーブル（連）");
        }

        deleteDairitenItakuSyouhnData();

        BzRenkeiHenkanUtil<BT_DairitenItakuSyouhn, BT_DairitenItakuSyouhn> bzRenkeiHenkanUtil = new BzRenkeiHenkanUtil<>();

        bzRenkeiHenkanUtil.initialize(BT_DairitenItakuSyouhn.class, C_SystemRenkeiSyoriHousikiKbn.KYOUYUU_DISC,
            C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY);

        dairitenItakuSyouhnRnCount = registDairitenItakuSyouhnData(bzRenkeiHenkanUtil);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(dairitenItakuSyouhnRnCount)));

    }

    @Transactional
    void deleteDairitenItakuSyouhnData() {

        bzDairitenItakuTorikomiDao.deleteDairitenItakuSyouhn();
    }

    @Transactional
    Long registDairitenItakuSyouhnData(BzRenkeiHenkanUtil<BT_DairitenItakuSyouhn, BT_DairitenItakuSyouhn> pBzRenkeiHenkanUtil) {

        Long syoriCount = 0L;

        try (ExDBResults<ZT_DairitenItakuSyouhnRn> dairitenItakuSyouhnRnLst = zdbDomManager.getAllDairitenItakuSyouhnRn();
            EntityInserter<BT_DairitenItakuSyouhn> entityInserter = new EntityInserter<>();) {

            BT_DairitenItakuSyouhn dairitenItakuSyouhn = null;

            for (ZT_DairitenItakuSyouhnRn dairitenItakuSyouhnRn : dairitenItakuSyouhnRnLst) {

                dairitenItakuSyouhn = createDairitenItakuSyouhnData(dairitenItakuSyouhnRn);

                dairitenItakuSyouhn = pBzRenkeiHenkanUtil.convDouituBean(dairitenItakuSyouhn);

                BizPropertyInitializer.initialize(dairitenItakuSyouhn);

                entityInserter.add(dairitenItakuSyouhn);

                syoriCount++;

            }
        }

        return syoriCount;
    }

    private BT_DairitenItakuSyouhn createDairitenItakuSyouhnData(ZT_DairitenItakuSyouhnRn pztDairitenItakuSyouhnRn) {

        BT_DairitenItakuSyouhn dairitenItakuSyouhn = new BT_DairitenItakuSyouhn();

        BzRenkeiHenkanUtil<?, ?> bzRenkeiHenkanUtil =
            SWAKInjector.getInstance(BzRenkeiHenkanUtil.class);

        dairitenItakuSyouhn.setDrtencd(pztDairitenItakuSyouhnRn.getZrndairitencd());
        dairitenItakuSyouhn.setDrtsyouhinsikibetukbnstr(pztDairitenItakuSyouhnRn.getZrndrtsyouhinsikibetukbnstr());
        dairitenItakuSyouhn.setDrthrkhouhoukbn(pztDairitenItakuSyouhnRn.getZrndrthrkhouhoukbn());
        dairitenItakuSyouhn.setDrtplannmkbn(pztDairitenItakuSyouhnRn.getZrndrtplannmkbn());
        bzRenkeiHenkanUtil.convYmdZeroToNull(pztDairitenItakuSyouhnRn.getZrnitakuhknhnbkaisiymd());
        dairitenItakuSyouhn.setItakuhknhnbkaisiymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        bzRenkeiHenkanUtil.convYmdZeroToNull(pztDairitenItakuSyouhnRn.getZrnitakuhknhnbsyuuryouymd());
        dairitenItakuSyouhn.setItakuhknhnbsyuuryouymd(bzRenkeiHenkanUtil.getConvYmdBizDate());

        return dairitenItakuSyouhn;

    }

}
