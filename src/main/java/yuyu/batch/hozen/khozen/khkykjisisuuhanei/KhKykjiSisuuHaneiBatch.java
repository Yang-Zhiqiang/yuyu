package yuyu.batch.hozen.khozen.khkykjisisuuhanei;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khozen.khkykjisisuuhanei.dba.KhKykjiSisuuHaneiDao;
import yuyu.batch.hozen.khozen.khkykjisisuuhanei.dba.SisuuHaneiBean;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.GetSisuu;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 契約保全 契約時指数反映クラス
 */
public class KhKykjiSisuuHaneiBatch implements Batch {

    private static final String TYSYTTAISYOU_TABLE_ID = IT_KykKihon.TABLE_NAME;

    private static final String RECOVERY_FILTER_KBNID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private KhKykjiSisuuHaneiDao khKykjiSisuuHaneiDao;

    @Inject
    private HozenDomManager hozenDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        String kakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        long count = 0;

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1018), kakutyoujobcd));

        try (EntityUpdater<IT_KykKihon> dataUpd = new EntityUpdater<>();
            ExDBResults<SisuuHaneiBean> sisuuHaneiBeanLst =
                khKykjiSisuuHaneiDao.getSisuuHanei(syoriYmd.addBusinessDays(1),
                    kakutyoujobcd)) {

            for (SisuuHaneiBean sisuuHaneiBean : sisuuHaneiBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(sisuuHaneiBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(sisuuHaneiBean.getSyono());

                GetSisuu getSisuu = SWAKInjector.getInstance(GetSisuu.class);

                C_ErrorKbn errorKbn = getSisuu.exec(sisuuHaneiBean.getSisuukbn(), sisuuHaneiBean.getKykymd()
                    .addBusinessDays(-1), C_YouhiKbn.HUYOU);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBS0005, "指数マスタ",
                        "指数区分", String.valueOf(sisuuHaneiBean.getSisuukbn()), "指数公表日",
                        String.valueOf(sisuuHaneiBean.getKykymd().addBusinessDays(-1))));
                }

                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(sisuuHaneiBean.getSyono());

                IT_KhSisuurendoTmttkn khSisuurendoTmttkn = khKykjiSisuuHaneiDao
                    .getKhSisuurendoTmttknByTmttkntaisyouymRenno(kykKihon, sisuuHaneiBean.getTmttkntaisyouym(),
                        sisuuHaneiBean.getRenno());

                khSisuurendoTmttkn.setTmttknhaneitmmshanteiymd(getSisuu.getSisuushutokuymd());
                khSisuurendoTmttkn.setTmttknhaneisisuu(getSisuu.getSisuu());
                khSisuurendoTmttkn.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                khSisuurendoTmttkn.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                khSisuurendoTmttkn.setGyoumuKousinTime(sysDateTimeMilli);

                dataUpd.add(kykKihon);

                count = count + 1;
            }
            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(count),
            "指数連動積増型年金積立金テーブル"));

    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
