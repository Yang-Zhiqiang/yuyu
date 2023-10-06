package yuyu.batch.biz.bzkaikei.bzhtkinsikinidouwktblsakujyo;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.bzkaikei.bzhtkinsikinidouwktblsakujyo.dba.BzHtkinSikinIdouWkTblSakujyoDao;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 経理･会計 配当金資金移動ワークテーブル削除
 */
public class BzHtkinSikinIdouWkTblSakujyoBatch implements Batch{

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzHtkinSikinIdouWkTblSakujyoDao bzHtkinSikinIdouWkTblSakujyoDao;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYMD = bzBatchParam.getSyoriYmd();
        int syoriKensuu = 0;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(syoriYMD)));

        syoriKensuu = bzHtkinSikinIdouWkTblSakujyoDao.delAllHtkinSikinIdouWk();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));

    }

}
