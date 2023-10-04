package yuyu.batch.hozen.khansyuu.khgentumiskmikomirituulfsks;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khgentumiskmikomirituulfsks.dba.GentumiSkMikomirituULFBean;
import yuyu.batch.hozen.khansyuu.khgentumiskmikomirituulfsks.dba.KhGentumiSkMikomirituULFSksDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.ZT_GentumiSkMikomirituULFTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 案内収納  限積用失効見込率算出用ＵＬＦ作成
 */
public class KhGentumiSkMikomirituULFSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhGentumiSkMikomirituULFSksDao KhGentumiSkMikomirituULFSksDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        long syoriKensuu = 0;

        try (ExDBResults<GentumiSkMikomirituULFBean> gentumiSkMikomirituULFBeanLst =
            KhGentumiSkMikomirituULFSksDao.getGentumiSkMikomirituULFBeans();

            EntityInserter<ZT_GentumiSkMikomirituULFTy> gentumiSkMikomirituULFTyInserter = new EntityInserter<>();) {

            for (GentumiSkMikomirituULFBean gentumiSkMikomirituULFBean : gentumiSkMikomirituULFBeanLst) {

                ZT_GentumiSkMikomirituULFTy gentumiSkMikomirituULFTy = new ZT_GentumiSkMikomirituULFTy();

                gentumiSkMikomirituULFTy.setZtyraysystemhyj(C_UmuKbn.ARI.getValue());
                gentumiSkMikomirituULFTy.setZtydatakanrino(gentumiSkMikomirituULFBean.getSyono());
                gentumiSkMikomirituULFTy.setZtykhsyoumetujiyuu(gentumiSkMikomirituULFBean.getSyoumetujiyuu().getValue());
                gentumiSkMikomirituULFTy.setZtysymtymd(gentumiSkMikomirituULFBean.getSyoumetuymd().toString());

                BizPropertyInitializer.initialize(gentumiSkMikomirituULFTy);

                gentumiSkMikomirituULFTyInserter.add(gentumiSkMikomirituULFTy);

                syoriKensuu++;
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }
}