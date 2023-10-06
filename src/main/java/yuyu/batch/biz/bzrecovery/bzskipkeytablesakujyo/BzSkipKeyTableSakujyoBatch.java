package yuyu.batch.biz.bzrecovery.bzskipkeytablesakujyo;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 リカバリ対応 スキップキーテーブル削除処理
 */
public class BzSkipKeyTableSakujyoBatch implements Batch{

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BizDomManager bizDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        long syoriKensuu = 0;

        List<BT_SkipKey> skipKeyList = bizDomManager.getAllSkipKey();

        if (skipKeyList.size() > 0) {

            for (BT_SkipKey skipKey: skipKeyList) {


                String recoverySikibetukey = skipKey.getRecoverysikibetukey();

                String ibKakutyoujobcd = skipKey.getKakutyoujobcd();

                String ibTableid = skipKey.getTableid();

                String ibRecoveryfilterid = skipKey.getRecoveryfilterid();

                String ibRecoveryfilterkey1 = skipKey.getRecoveryfilterkey1();

                String ibRecoveryfilterkey2 = skipKey.getRecoveryfilterkey2();

                String ibRecoveryfilterkey3 = skipKey.getRecoveryfilterkey3();

                String ibRecoveryfilterkey4 = skipKey.getRecoveryfilterkey4();

                String ibRecoveryfilterkey5 = skipKey.getRecoveryfilterkey5();

                batchLogger.info(MessageUtil.getMessage(MessageId.IBF1002, recoverySikibetukey, ibKakutyoujobcd, ibTableid,
                    ibRecoveryfilterid, ibRecoveryfilterkey1, ibRecoveryfilterkey2, ibRecoveryfilterkey3, ibRecoveryfilterkey4,
                    ibRecoveryfilterkey5));

                syoriKensuu = syoriKensuu + 1;
            }

            bizDomManager.delete(skipKeyList);
        }
        else {

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF1001, "スキップキーテーブル"));
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }
}
