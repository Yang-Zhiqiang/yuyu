package yuyu.batch.biz.bzmaster.bzbyoumeitorikomi;

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
import yuyu.def.classification.C_ByoumeiGaitouKbn2;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SystemRenkeiSyoriHousikiKbn;
import yuyu.def.db.entity.JM_Byoumei;
import yuyu.def.db.entity.ZT_AiKyuubuByoumeiRn;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 連携用DB（あいキューブ病名マスタ送信データテーブル（連））を読み込み、病名マスタに反映するクラス
 */
public class BzByoumeiTorikomiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private ZdbDomManager zdbDomManager;

    @Inject
    private BzByoumeiTorikomiDao bzByoumeiTorikomiDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        Long aiKyuubuByoumeiRnCount = zdbDomManager.getAiKyuubuByoumeiRnCount();

        if (aiKyuubuByoumeiRnCount == 0) {

            throw new BizAppException(MessageId.EBF1001, "あいキューブ病名マスタ送信データテーブル（連）");

        }

        deleteByoumeiData();

        BzRenkeiHenkanUtil<JM_Byoumei, JM_Byoumei> bzRenkeiHenkanUtil = new BzRenkeiHenkanUtil<>();

        bzRenkeiHenkanUtil.initialize(JM_Byoumei.class, C_SystemRenkeiSyoriHousikiKbn.KYOUYUU_DISC,
            C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY);

        aiKyuubuByoumeiRnCount = registByoumeiData(bzRenkeiHenkanUtil);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(aiKyuubuByoumeiRnCount)));
    }

    private void deleteByoumeiData() {

        bzByoumeiTorikomiDao.deleteByoumei();
    }

    @Transactional
    Long registByoumeiData(BzRenkeiHenkanUtil<JM_Byoumei, JM_Byoumei> pBzRenkeiHenkanUtil) {

        Long syoriCount = 0L;

        try (EntityInserter<JM_Byoumei> entityInserter = new EntityInserter<>();
            ExDBResults<ZT_AiKyuubuByoumeiRn> exDBResults = zdbDomManager.getAllAiKyuubuByoumeiRn()) {

            JM_Byoumei jmByoumei = null;
            for (ZT_AiKyuubuByoumeiRn ztAiKyuubuByoumeiRn : exDBResults) {

                jmByoumei = createByoumeiData(ztAiKyuubuByoumeiRn);

                jmByoumei = pBzRenkeiHenkanUtil.convDouituBean(jmByoumei);

                BizPropertyInitializer.initialize(jmByoumei);

                entityInserter.add(jmByoumei);

                syoriCount++;

            }
        }

        return syoriCount;
    }

    private JM_Byoumei createByoumeiData(ZT_AiKyuubuByoumeiRn pZtAiKyuubuByoumeiRn) {

        JM_Byoumei jmByoumei = new JM_Byoumei();

        jmByoumei.setByoumeitourokuno(pZtAiKyuubuByoumeiRn.getZrnbyoumeitourokuno());
        jmByoumei.setByoumeikj(pZtAiKyuubuByoumeiRn.getZrnbyoumeizenkaku());
        jmByoumei.setByoumeizenkaku(pZtAiKyuubuByoumeiRn.getZrnbyoumeizenkaku());
        jmByoumei.setByoumeikn(pZtAiKyuubuByoumeiRn.getZrnbyoumeihuriganakensaku());
        jmByoumei.setByoumeiknkensaku(pZtAiKyuubuByoumeiRn.getZrnbyoumeihuriganakensaku());
        jmByoumei.setByoumeicd(pZtAiKyuubuByoumeiRn.getZrnbyoumeicd());
        jmByoumei.setGaitoukbn1(pZtAiKyuubuByoumeiRn.getZrngaitoukbn1());
        jmByoumei.setGaitoukbn2(C_ByoumeiGaitouKbn2.valueOf(pZtAiKyuubuByoumeiRn.getZrngaitoukbn2()));
        jmByoumei.setGaitoukbn3(pZtAiKyuubuByoumeiRn.getZrngaitoukbn3());
        jmByoumei.setGaitoukbn4(pZtAiKyuubuByoumeiRn.getZrngaitoukbn4());
        jmByoumei.setGaitoukbn5(pZtAiKyuubuByoumeiRn.getZrngaitoukbn5());
        jmByoumei.setTyuuimongon(pZtAiKyuubuByoumeiRn.getZrntyuuimongon());

        return jmByoumei;
    }

}
