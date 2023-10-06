package yuyu.batch.biz.bznayose.bztjtidounyitjhzntblsakujyo;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BT_TjtIdouNyKhItjhzn;
import yuyu.def.db.entity.BT_TjtIdouNyNkItjhzn;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
/**
 * 業務共通 名寄せ 当日異動内容一時保存TBL削除クラス
 */
public class BzTjtIdouNyItjhznTblSakujyoBatch implements Batch{

    private final String KH_ITJHZNTBL_SAKUJYO = "当日異動内容契約保全一時保存TBL削除";

    private final String SK_ITJHZNTBL_SAKUJYO = "当日異動内容新契約一時保存TBL削除";

    private final String NK_ITJHZNTBL_SAKUJYO = "当日異動内容年金支払一時保存TBL削除";

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
        BzTjtIdouNyItjhznTblSakujyoDao bzTjtIdouNyItjhznTblSakujyoDao =
            SWAKInjector.getInstance(BzTjtIdouNyItjhznTblSakujyoDao.class);

        List<BT_TjtIdouNyKhItjhzn> tjtIdouNyKhItjhznLst = bizDomManager.getAllTjtIdouNyKhItjhzn();
        hozenKensuu = tjtIdouNyKhItjhznLst.size();
        bizDomManager.delete(tjtIdouNyKhItjhznLst);

        sinkeiyakuKensuu = bzTjtIdouNyItjhznTblSakujyoDao.getCountByTableid("BT_TjtIdouNySkItjhzn");

        bzTjtIdouNyItjhznTblSakujyoDao.deleteByTableid("BT_TjtIdouNySkItjhzn");
        bzTjtIdouNyItjhznTblSakujyoDao.deleteByTableid("BT_IdouSkMeigiItjhzn");
        bzTjtIdouNyItjhznTblSakujyoDao.deleteByTableid("BT_IdouSkBosyuudrItjhzn");

        List<BT_TjtIdouNyNkItjhzn> tjtIdouNyNkItjhznLst = bizDomManager.getAllTjtIdouNyNkItjhzn();
        nenkinKensuu = tjtIdouNyNkItjhznLst.size();
        bizDomManager.delete(tjtIdouNyNkItjhznLst);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
            String.valueOf(hozenKensuu), KH_ITJHZNTBL_SAKUJYO));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
            String.valueOf(sinkeiyakuKensuu), SK_ITJHZNTBL_SAKUJYO));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
            String.valueOf(nenkinKensuu), NK_ITJHZNTBL_SAKUJYO));
    }
}
