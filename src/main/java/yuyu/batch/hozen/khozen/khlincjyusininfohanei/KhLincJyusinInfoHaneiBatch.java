package yuyu.batch.hozen.khozen.khlincjyusininfohanei;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khozen.khlincjyusininfohanei.dba.KhLincJyusinInfoHaneiDao;
import yuyu.batch.hozen.khozen.khlincjyusininfohanei.dba.SkLincJyusinDataBean;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_LincsoujyusinsysKbn;
import yuyu.def.classification.C_SousinKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.HT_SkLincJyusinData;
import yuyu.def.db.entity.IT_KhLincKihon;
import yuyu.def.db.entity.IT_KhLincSousinData;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 契約保全 契約保全ＬＩＮＣ受信情報反映
 */
public class KhLincJyusinInfoHaneiBatch implements Batch {

    private static final String TYSYTTAISYOU_TABLE_ID = HT_SkLincJyusinData.TABLE_NAME;

    private static final String RECOVERY_FILTER_KBNID = "Sk008";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhLincJyusinInfoHaneiDao khLincJyusinInfoHaneiDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

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

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1018), kakutyoujobcd));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        String kinouId = khozenCommonParam.getFunctionId();

        String userId = khozenCommonParam.getUserID();

        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();

        long countKhLincKihon = 0;
        long countKhLincSousinData = 0;

        String syono = "";

        try (ExDBResults<SkLincJyusinDataBean> skLincJyusinDataLst = khLincJyusinInfoHaneiDao.
            getSkLincJyusinDataBySyoriYmdLincsoujyusinsysKbn(kakutyoujobcd, syoriYmd, C_LincsoujyusinsysKbn.HOZEN);

            EntityUpdater<IT_KykKihon> khKykKihonUpdLst = new EntityUpdater<>();) {

            for (SkLincJyusinDataBean skLincJyusinData : skLincJyusinDataLst) {
                syono = skLincJyusinData.getSyono();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(skLincJyusinData.getSyoriYmd().toString());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(skLincJyusinData.getLinckyknaiykekdatarenno());

                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);
                IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

                IT_KhLincKihon khLincKihon = kykKihon.createKhLincKihon();
                khLincKihon.setKykymd(kykSyouhn.getKykymd());
                khLincKihon.setLinckanyuusyano(skLincJyusinData.getLinckanyuusyano());
                khLincKihon.setGyoumuKousinKinou(kinouId);
                khLincKihon.setGyoumuKousinsyaId(userId);
                khLincKihon.setGyoumuKousinTime(sysDateTimeMilli);

                BizPropertyInitializer.initialize(khLincKihon);

                kykKihon.setKhLincKihon(khLincKihon);

                countKhLincKihon = countKhLincKihon + 1;

                List<IT_KhLincSousinData> khLincSousinDataLst = khLincJyusinInfoHaneiDao.
                    getKhLincSousinDataListBySyonoSousinKbn(syono, C_SousinKbn.MISOUSIN);

                if (khLincSousinDataLst == null || khLincSousinDataLst.size() == 0) {
                    continue;
                }

                IT_KhLincSousinData khLincSousinData1 = kykKihon.createKhLincSousinData();
                BeanUtil.copyProperties(khLincSousinData1, khLincSousinDataLst.get(0));
                khLincSousinData1.setSyoriYmd(syoriYmd.addBusinessDays(1));
                khLincSousinData1.setRenno(1);
                khLincSousinData1.setLincsousinkbn(C_SousinKbn.SOUSINMATI);
                khLincSousinData1.setLinckanyuusyano(skLincJyusinData.getLinckanyuusyano());
                khLincSousinData1.setGyoumuKousinKinou(kinouId);
                khLincSousinData1.setGyoumuKousinsyaId(userId);
                khLincSousinData1.setGyoumuKousinTime(sysDateTimeMilli);
                BizPropertyInitializer.initialize(khLincSousinData1);

                List<IT_KhLincSousinData> khLincSousinDataKousinLst = kykKihon.getKhLincSousinDatas();

                for(IT_KhLincSousinData khLincSousinData : khLincSousinDataKousinLst) {
                    if(C_SousinKbn.MISOUSIN.eq(khLincSousinData.getLincsousinkbn())){
                        khLincSousinData.setLincsousinkbn(C_SousinKbn.SOUSINHUYOU);
                        khLincSousinData.setGyoumuKousinKinou(kinouId);
                        khLincSousinData.setGyoumuKousinsyaId(userId);
                        khLincSousinData.setGyoumuKousinTime(sysDateTimeMilli);

                        countKhLincSousinData = countKhLincSousinData + 1;
                    }
                }

                khKykKihonUpdLst.add(kykKihon);
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IAC1001, "契約保全ＬＩＮＣ基本テーブル作成",
            String.valueOf(countKhLincKihon)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IAC1001, "契約保全ＬＩＮＣ送信データテーブル更新",
            String.valueOf(countKhLincSousinData)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
