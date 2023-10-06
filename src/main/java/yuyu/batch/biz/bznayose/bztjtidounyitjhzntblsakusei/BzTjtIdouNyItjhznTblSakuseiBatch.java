package yuyu.batch.biz.bznayose.bztjtidounyitjhzntblsakusei;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BT_IdouKhBosyuudr;
import yuyu.def.db.entity.BT_IdouKhBosyuudrItjhzn;
import yuyu.def.db.entity.BT_IdouKhMeigi;
import yuyu.def.db.entity.BT_IdouKhMeigiItjhzn;
import yuyu.def.db.entity.BT_IdouNkBosyuudr;
import yuyu.def.db.entity.BT_IdouNkBosyuudrItjhzn;
import yuyu.def.db.entity.BT_IdouNkMeigi;
import yuyu.def.db.entity.BT_IdouNkMeigiItjhzn;
import yuyu.def.db.entity.BT_IdouSkBosyuudr;
import yuyu.def.db.entity.BT_IdouSkBosyuudrItjhzn;
import yuyu.def.db.entity.BT_IdouSkMeigi;
import yuyu.def.db.entity.BT_IdouSkMeigiItjhzn;
import yuyu.def.db.entity.BT_TjtIdouNyKh;
import yuyu.def.db.entity.BT_TjtIdouNyKhItjhzn;
import yuyu.def.db.entity.BT_TjtIdouNyNk;
import yuyu.def.db.entity.BT_TjtIdouNyNkItjhzn;
import yuyu.def.db.entity.BT_TjtIdouNySk;
import yuyu.def.db.entity.BT_TjtIdouNySkItjhzn;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 名寄せ 当日異動内容一時保存TBL作成クラス
 */
public class BzTjtIdouNyItjhznTblSakuseiBatch implements Batch {

    private final String KH_ITJHZNTBL_SAKUSEI = "当日異動内容契約保全一時保存TBL作成";

    private final String SK_ITJHZNTBL_SAKUSEI = "当日異動内容新契約一時保存TBL作成";

    private final String NK_ITJHZNTBL_SAKUSEI = "当日異動内容年金支払一時保存TBL作成";

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


        long hozenkensuu = 0;

        try (ExDBResults<BT_TjtIdouNyKh> tjtIdouNyKhLst = bizDomManager.getTjtIdouNyKhs();
            EntityInserter<BT_TjtIdouNyKhItjhzn> tjtIdouNyKhItjhznInserter = new EntityInserter<>()) {

            for (BT_TjtIdouNyKh tjtIdouNyKh : tjtIdouNyKhLst) {

                BT_TjtIdouNyKhItjhzn tjtIdouNyKhItjhzn = new BT_TjtIdouNyKhItjhzn();
                BeanUtil.copyProperties(tjtIdouNyKhItjhzn, tjtIdouNyKh);

                BT_IdouKhMeigi idouKhMeigi = tjtIdouNyKh.getIdouKhMeigi();
                BT_IdouKhMeigiItjhzn idouKhMeigiItjhzn = tjtIdouNyKhItjhzn.createIdouKhMeigiItjhzn();
                BeanUtil.copyProperties(idouKhMeigiItjhzn, idouKhMeigi);

                BT_IdouKhBosyuudr idouKhBosyuudr = tjtIdouNyKh.getIdouKhBosyuudr();
                BT_IdouKhBosyuudrItjhzn idouKhBosyuudrItjhzn = tjtIdouNyKhItjhzn.createIdouKhBosyuudrItjhzn();
                BeanUtil.copyProperties(idouKhBosyuudrItjhzn, idouKhBosyuudr);

                tjtIdouNyKhItjhznInserter.add(tjtIdouNyKhItjhzn);
                hozenkensuu++;
            }
        }


        long sinkeiyakukensuu = 0;

        try (ExDBResults<BT_TjtIdouNySk> tjtIdouNySkLst = bizDomManager.getTjtIdouNySks();
            EntityInserter<BT_TjtIdouNySkItjhzn> tjtIdouNySkItjhznInserter = new EntityInserter<>()) {

            for (BT_TjtIdouNySk tjtIdouNySk : tjtIdouNySkLst) {

                BT_TjtIdouNySkItjhzn tjtIdouNySkItjhzn = new BT_TjtIdouNySkItjhzn();
                BeanUtil.copyProperties(tjtIdouNySkItjhzn, tjtIdouNySk);

                BT_IdouSkMeigi idouSkMeigi = tjtIdouNySk.getIdouSkMeigi();
                BT_IdouSkMeigiItjhzn idouSkMeigiItjhzn = tjtIdouNySkItjhzn.createIdouSkMeigiItjhzn();
                BeanUtil.copyProperties(idouSkMeigiItjhzn, idouSkMeigi);

                BT_IdouSkBosyuudr idouSkBosyuudr = tjtIdouNySk.getIdouSkBosyuudr();
                BT_IdouSkBosyuudrItjhzn idouSkBosyuudrItjhzn = tjtIdouNySkItjhzn.createIdouSkBosyuudrItjhzn();
                BeanUtil.copyProperties(idouSkBosyuudrItjhzn, idouSkBosyuudr);

                tjtIdouNySkItjhznInserter.add(tjtIdouNySkItjhzn);
                sinkeiyakukensuu++;
            }

        }


        long nenkinkensuu = 0;

        try (ExDBResults<BT_TjtIdouNyNk> tjtIdouNyNkLst = bizDomManager.getTjtIdouNyNks();
            EntityInserter<BT_TjtIdouNyNkItjhzn> tjtIdouNyNkItjhznInserter = new EntityInserter<>()) {

            for (BT_TjtIdouNyNk tjtIdouNyNk : tjtIdouNyNkLst) {

                BT_TjtIdouNyNkItjhzn tjtIdouNyNkItjhzn = new BT_TjtIdouNyNkItjhzn();
                BeanUtil.copyProperties(tjtIdouNyNkItjhzn, tjtIdouNyNk);

                BT_IdouNkMeigi idouNkMeigi = tjtIdouNyNk.getIdouNkMeigi();
                BT_IdouNkMeigiItjhzn idouNkMeigiItjhzn = tjtIdouNyNkItjhzn.createIdouNkMeigiItjhzn();
                BeanUtil.copyProperties(idouNkMeigiItjhzn, idouNkMeigi);

                BT_IdouNkBosyuudr idouNkBosyuudr = tjtIdouNyNk.getIdouNkBosyuudr();
                BT_IdouNkBosyuudrItjhzn idouNkBosyuudrItjhzn = tjtIdouNyNkItjhzn.createIdouNkBosyuudrItjhzn();
                BeanUtil.copyProperties(idouNkBosyuudrItjhzn, idouNkBosyuudr);

                tjtIdouNyNkItjhznInserter.add(tjtIdouNyNkItjhzn);
                nenkinkensuu++;
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
            String.valueOf(hozenkensuu), KH_ITJHZNTBL_SAKUSEI));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
            String.valueOf(sinkeiyakukensuu), SK_ITJHZNTBL_SAKUSEI));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
            String.valueOf(nenkinkensuu), NK_ITJHZNTBL_SAKUSEI));
    }
}
