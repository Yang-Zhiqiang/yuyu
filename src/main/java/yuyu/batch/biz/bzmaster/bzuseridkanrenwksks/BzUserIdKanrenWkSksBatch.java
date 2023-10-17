package yuyu.batch.biz.bzmaster.bzuseridkanrenwksks;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BW_IdCardWk;
import yuyu.def.db.entity.BW_UserIdKanrenWk;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 マスタ取込 ユーザーID関連ワークテーブル作成DAOクラスです。
 */
public class BzUserIdKanrenWkSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzUserIdKanrenWkSksDao bzUserIdKanrenWkSksDao;

    @Inject
    private BizDomManager bizDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        long idCardWkKensuu = bizDomManager.getIdCardWkCount();

        if (idCardWkKensuu == 0) {

            batchLogger.error(MessageUtil.getMessage(MessageId.EBA0024, "ＩＤカードマスタワークテーブルのデータ"));

            return;
        }

        try {
            bzUserIdKanrenWkSksDao.lockUserIdKanrenWk();
        } catch (Exception e) {
        }

        bzUserIdKanrenWkSksDao.deleteUserIdKanrenWk();

        int userIdKanrenWkInsertCount = 0;

        try (ExDBResults<BW_IdCardWk> idCardWkList = bizDomManager.getIdCardWks();

            EntityInserter<BW_UserIdKanrenWk> userIdKanrenWkEntityInserter = new EntityInserter<>();) {

            for (BW_IdCardWk idCardWkL : idCardWkList) {

                BW_UserIdKanrenWk userIdKanrenWk = new BW_UserIdKanrenWk();

                userIdKanrenWk.setIdkbn(idCardWkL.getIdkbn());
                userIdKanrenWk.setIdcd(idCardWkL.getIdcd());
                userIdKanrenWk.setUserId(idCardWkL.getIdkbn() + idCardWkL.getIdcd());

                BizPropertyInitializer.initialize(userIdKanrenWk);

                userIdKanrenWkEntityInserter.add(userIdKanrenWk);

                userIdKanrenWkInsertCount++;
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
            String.valueOf(userIdKanrenWkInsertCount), "ユーザーＩＤ関連ワークテーブル　追加件数"));
    }
}
