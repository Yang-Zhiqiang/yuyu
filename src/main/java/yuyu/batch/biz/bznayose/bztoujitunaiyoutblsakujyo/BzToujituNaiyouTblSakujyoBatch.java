package yuyu.batch.biz.bznayose.bztoujitunaiyoutblsakujyo;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BT_TjtIdouNyKh;
import yuyu.def.db.entity.BT_TjtIdouNyNk;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
/**
 * 業務共通 名寄せ 当日異動内容TBL削除クラス
 */
public class BzToujituNaiyouTblSakujyoBatch implements Batch {

    private final String KH_TBL_SAKUJYO = "当日異動内容契約保全TBL削除";

    private final String SK_TBL_SAKUJYO = "当日異動内容新契約TBL削除";

    private final String NK_TBL_SAKUJYO = "当日異動内容年金支払TBL削除";

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

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        long hozenKensuu = 0;
        long sinkeiyakuKensuu = 0;
        long nenkinKensuu = 0;
        BzToujituNaiyouTblSakujyoDao bzToujituNaiyouTblSakujyoDao =
            SWAKInjector.getInstance(BzToujituNaiyouTblSakujyoDao.class);

        List<BT_TjtIdouNyKh> tjtIdouNyKhLst = bizDomManager.getAllTjtIdouNyKh();
        hozenKensuu = tjtIdouNyKhLst.size();
        bizDomManager.delete(tjtIdouNyKhLst);

        sinkeiyakuKensuu = bzToujituNaiyouTblSakujyoDao.getCountByTableid("BT_TjtIdouNySk");

        bzToujituNaiyouTblSakujyoDao.deleteByTableid("BT_TjtIdouNySk");
        bzToujituNaiyouTblSakujyoDao.deleteByTableid("BT_IdouSkMeigi");
        bzToujituNaiyouTblSakujyoDao.deleteByTableid("BT_IdouSkBosyuudr");

        List<BT_TjtIdouNyNk> tjtIdouNyNkLst = bizDomManager.getAllTjtIdouNyNk();
        nenkinKensuu = tjtIdouNyNkLst.size();
        bizDomManager.delete(tjtIdouNyNkLst);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(hozenKensuu), KH_TBL_SAKUJYO));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(sinkeiyakuKensuu), SK_TBL_SAKUJYO));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(nenkinKensuu), NK_TBL_SAKUJYO));

    }
}
