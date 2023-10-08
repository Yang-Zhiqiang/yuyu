package yuyu.batch.biz.bzsystemhonbankensyou.bzkijitutouraikeiyakutyusyutusk;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 システム本番検証用 期日到来契約抽出（新契約）
 */
public class BzKijituTouraiKeiyakuTyusyutuSkBatch implements Batch {

    public static final String SUBSYSTEMID_SINKEIYAKU  = "sinkeiyaku";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    //    @Inject
    //    private BzKijituTouraiKeiyakuTyusyutuSkDao bzkijituTouraiKeiyakuTyusyutuSkDao;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));

        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();
        String kinouId = kinou.getKinouId();
        String userId = baseUserInfo.getUserId();
        int syoriCount = 0;
        int renno = 0;

        //        try (
        //            ExDBResults<BzKijituTouraiKeiyakuTyusyutuSkBean> kijituTouraiKeiyakuTyusyutuList =
        //            bzkijituTouraiKeiyakuTyusyutuSkDao.getKijituTouraiKeiyakuTyusyutuInfos();
        //            MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();) {
        //
        //            for (BzKijituTouraiKeiyakuTyusyutuSkBean kijituTouraiKeiyakuTyusyutuBean : kijituTouraiKeiyakuTyusyutuList) {
        //
        //                BT_KijituTouraiHonbanKensyou kijituTouraiHonbanKensyou = new BT_KijituTouraiHonbanKensyou();
        //                kijituTouraiHonbanKensyou.setSubSystemId(SUBSYSTEMID_SINKEIYAKU);
        //                kijituTouraiHonbanKensyou.setSyoriYmd(syoriYmd);
        //                kijituTouraiHonbanKensyou.setTysytno(++renno);
        //                kijituTouraiHonbanKensyou.setDatakanrino(kijituTouraiKeiyakuTyusyutuBean.getDatakanrino());
        //                kijituTouraiHonbanKensyou.setTysytnaiyou1(kijituTouraiKeiyakuTyusyutuBean.getTysytnaiyou1());
        //                kijituTouraiHonbanKensyou.setTysytnaiyou2(kijituTouraiKeiyakuTyusyutuBean.getTysytnaiyou2());
        //                kijituTouraiHonbanKensyou.setTysytnaiyou3(kijituTouraiKeiyakuTyusyutuBean.getTysytnaiyou3());
        //                kijituTouraiHonbanKensyou.setTysytnaiyou4(kijituTouraiKeiyakuTyusyutuBean.getTysytnaiyou4());
        //                kijituTouraiHonbanKensyou.setTysytnaiyou5(kijituTouraiKeiyakuTyusyutuBean.getTysytnaiyou5());
        //                kijituTouraiHonbanKensyou.setTysytnaiyou6(kijituTouraiKeiyakuTyusyutuBean.getTysytnaiyou6());
        //                kijituTouraiHonbanKensyou.setTysytnaiyou7(kijituTouraiKeiyakuTyusyutuBean.getTysytnaiyou7());
        //                kijituTouraiHonbanKensyou.setTysytnaiyou8(kijituTouraiKeiyakuTyusyutuBean.getTysytnaiyou8());
        //                kijituTouraiHonbanKensyou.setTysytnaiyou9(kijituTouraiKeiyakuTyusyutuBean.getTysytnaiyou9());
        //                kijituTouraiHonbanKensyou.setTysytnaiyou10(kijituTouraiKeiyakuTyusyutuBean.getTysytnaiyou10());
        //                kijituTouraiHonbanKensyou.setGyoumuKousinKinou(kinouId);
        //                kijituTouraiHonbanKensyou.setGyoumuKousinsyaId(userId);
        //                kijituTouraiHonbanKensyou.setGyoumuKousinTime(sysDateTimeMilli);
        //
        //                BizPropertyInitializer.initialize(kijituTouraiHonbanKensyou);
        //
        //                multipleEntityInserter.add(kijituTouraiHonbanKensyou);
        //
        //                syoriCount++;
        //            }
        //        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriCount), "新契約"));
    }

}
