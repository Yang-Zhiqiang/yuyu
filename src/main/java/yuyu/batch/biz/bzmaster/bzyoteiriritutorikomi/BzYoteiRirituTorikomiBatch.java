package yuyu.batch.biz.bzmaster.bzyoteiriritutorikomi;

import java.util.ArrayList;
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
import yuyu.def.db.entity.BM_YoteiRiritu3;
import yuyu.def.db.entity.BM_YoteiRirituRendouSeigyo;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 商品コードごとの契約日自、至、利率を設定し、予定利率マスタに反映するクラス
 */
public class BzYoteiRirituTorikomiBatch implements Batch {

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
            .exec(C_RirituSyuruiKbn.YOTEIRIRITU);

        List<BM_YoteiRiritu3> bmYoteiRirituList = bzSetMasterTorikomiRirituBean.getYoteiRirituList();

        String day = bzBatchParam.getSyoriYmd().toString().substring(6);

        List<BM_YoteiRirituRendouSeigyo> bM_YoteiRirituRendouSeigyo =
            bizDomManager.getYoteiRirituRendouSeigyosByYoteirirituhanteid(day);

        List<String> syouHnCdLst = new ArrayList<String>();
        for (BM_YoteiRirituRendouSeigyo bM_YoteiRirituRendouSeigyoLst : bM_YoteiRirituRendouSeigyo){
            syouHnCdLst.add(bM_YoteiRirituRendouSeigyoLst.getSyouhncd());
        }

        List<BM_YoteiRiritu3> bmYoteiRirituList2 = new ArrayList<>();
        for (BM_YoteiRiritu3 tmpYoteiRirituList3 : bmYoteiRirituList){
            if (syouHnCdLst.contains(tmpYoteiRirituList3.getSyouhncd())){
                bmYoteiRirituList2.add(tmpYoteiRirituList3);
            }
        }

        bizDomManager.insert(bmYoteiRirituList2);

        syoriCount = bmYoteiRirituList2.size();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriCount)));
    }
}