package yuyu.batch.biz.bzkaikei.bzhjybruigakuteiseitblsakujyo;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.bzkaikei.bzhjybruigakuteiseitblsakujyo.dba.BzHjybRuigakuTeiseiTblSakujyoDao;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 経理･会計 補助簿累計額訂正テーブル削除クラス
 */
public class BzHjybRuigakuTeiseiTblSakujyoBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzHjybRuigakuTeiseiTblSakujyoDao bzHjybRuigakuTeiseiTblSakujyoDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        int syoriKensuu = 0;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        syoriKensuu = bzHjybRuigakuTeiseiTblSakujyoDao.delAllBzHjybRuikeigakuTeisei();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));

    }
}