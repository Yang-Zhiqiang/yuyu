package yuyu.batch.sinkeiyaku.skmaster.sktokuteikankeihjnnmtotugou;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.sinkeiyaku.skcommon.CheckTkhjn;
import yuyu.def.MessageId;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.HM_TokuteiKankeiHjnNmTotugou;
import yuyu.def.db.entity.HM_TokuteiKankeiHoujin;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 新契約 マスタメンテナンス 特定関係法人名突合マスタ反映
 */
public class SkTokuteikankeihjnnmTotugouBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private SkTokuteikankeihjnnmTotugouDao skTokuteikankeihjnnmTotugouDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        long syoriKesuu = 0;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), bzBatchParam.getSyoriYmd().toString()));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1018), bzBatchParam.getIbKakutyoujobcd()));

        CheckTkhjn checkTkhjn = SWAKInjector.getInstance(CheckTkhjn.class);

        skTokuteikankeihjnnmTotugouDao.deleteTokuteiKankeiHjnNmTotugou();

        try(ExDBResults<HM_TokuteiKankeiHoujin> tokuteiKankeiHoujinLst = sinkeiyakuDomManager.getTokuteiKankeiHoujins()){
            Iterator<HM_TokuteiKankeiHoujin> tokuteiKankeiHoujin = tokuteiKankeiHoujinLst.iterator();

            if (!tokuteiKankeiHoujin.hasNext()) {

                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKesuu), "特定関係法人名突合マスタ反映"));
                return ;

            }

            try(EntityInserter<HM_TokuteiKankeiHjnNmTotugou> tokuteiKankeiHjnNmTotugouLstIns = new EntityInserter<>()){

                String checkTkhjnkinYuucd = "";
                C_YouhiKbn checkYouhiKbn = C_YouhiKbn.HUYOU;
                String tkhjnkinYuucd = "";
                List<String> checkTaisyouLst = new ArrayList<>();
                Integer renNo = 0;

                while (tokuteiKankeiHoujin.hasNext()) {

                    HM_TokuteiKankeiHoujin tokuteiKankeiHoujinWk = tokuteiKankeiHoujin.next();
                    tkhjnkinYuucd = tokuteiKankeiHoujinWk.getTkhjnkinyuucd();

                    if (!checkTkhjnkinYuucd.equals(tkhjnkinYuucd)) {

                        checkTkhjnkinYuucd = tkhjnkinYuucd;
                        checkYouhiKbn = checkTkhjn.hanteiCheckYouhi(tkhjnkinYuucd);

                    }

                    if (C_YouhiKbn.YOU.eq(checkYouhiKbn)) {

                        checkTaisyouLst = checkTkhjn.crtCheckTaisyouLst(tokuteiKankeiHoujinWk.getTkhjnnmkj());
                        renNo = 1;

                        for (String checkTaisyou : checkTaisyouLst) {

                            HM_TokuteiKankeiHjnNmTotugou tokuteiKankeiHjnNmTotugou = new HM_TokuteiKankeiHjnNmTotugou();
                            tokuteiKankeiHjnNmTotugou.setTkhjnkinyuucd(tkhjnkinYuucd);
                            tokuteiKankeiHjnNmTotugou.setMeisaino(tokuteiKankeiHoujinWk.getMeisaino());
                            tokuteiKankeiHjnNmTotugou.setRenno(renNo);
                            tokuteiKankeiHjnNmTotugou.setTotugoutkhjnnmkj(checkTaisyou);

                            BizPropertyInitializer.initialize(tokuteiKankeiHjnNmTotugou);

                            tokuteiKankeiHjnNmTotugouLstIns.add(tokuteiKankeiHjnNmTotugou);

                            syoriKesuu++;
                            renNo++;
                        }

                    }

                }

            }

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKesuu), "特定関係法人名突合マスタ反映"));

        }

    }

}
