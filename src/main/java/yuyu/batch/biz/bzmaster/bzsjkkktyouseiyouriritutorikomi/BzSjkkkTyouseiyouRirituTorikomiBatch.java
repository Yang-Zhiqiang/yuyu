package yuyu.batch.biz.bzmaster.bzsjkkktyouseiyouriritutorikomi;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzSetMasterTorikomiRiritu;
import yuyu.common.biz.bzcommon.BzSetMasterTorikomiRirituBean;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_RirituSyuruiKbn;
import yuyu.def.db.entity.BM_SjkkkTyouseiyouRiritu2;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 商品コードごとの契約日自、至、利率を設定し、市場価格調整用利率マスタに反映するクラス
 */
public class BzSjkkkTyouseiyouRirituTorikomiBatch implements Batch {

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

        long syoriCount = 0;

        BzSetMasterTorikomiRiritu bzSetMasterTorikomiRiritu = SWAKInjector.getInstance(BzSetMasterTorikomiRiritu.class);

        BzSetMasterTorikomiRirituBean bzSetMasterTorikomiRirituBean = bzSetMasterTorikomiRiritu
            .exec(C_RirituSyuruiKbn.SJKKKTYOUSEIYOURIRITU);

        List<BM_SjkkkTyouseiyouRiritu2> bmSjkkkTyouseiyouRirituList = bzSetMasterTorikomiRirituBean.getSjkkkTyouseiyouRirituList();

        bizDomManager.insert(bmSjkkkTyouseiyouRirituList);

        syoriCount = bmSjkkkTyouseiyouRirituList.size();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriCount)));
    }
}