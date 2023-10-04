package yuyu.batch.hozen.khozen.khcifcdikkatuhenkou;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityUpdater;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khozen.khcifcdikkatuhenkou.dba.KhCifcdIkkatuHenkouDao;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IW_CifcdIktHnkWk;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 契約保全 ＣＩＦコード一括変更クラスです。<br />
 */
public class KhCifcdIkkatuHenkouBatch implements Batch{

    private static final String TYSYTTAISYOU_TABLE_ID = IW_CifcdIktHnkWk.TABLE_NAME;

    private static final String RECOVERY_FILTER_KBNID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private KhCifcdIkkatuHenkouDao khCifcdIkkatuHenkouDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        String ibKakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1018), ibKakutyoujobCd));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        long syoriKensuu = 0;

        String kinouId = khozenCommonParam.getFunctionId();

        String userId = khozenCommonParam.getUserID();

        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();

        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);

        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

        String syono = "";

        String sikibetuKey = "";

        try (
            ExDBResults<IW_CifcdIktHnkWk> cifcdIktHnkWkLst = khCifcdIkkatuHenkouDao.getAllCifcdIktHnkWkByKakutyoujobcd(ibKakutyoujobCd);
            MultipleEntityUpdater multipleEntityUpdater = new MultipleEntityUpdater();) {

            for (IW_CifcdIktHnkWk cifcdIktHnkWk: cifcdIktHnkWkLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(cifcdIktHnkWk.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(cifcdIktHnkWk.getSyono());

                syono = cifcdIktHnkWk.getSyono();

                khozenCommonParam.setSikibetuKey(null);

                sikibetuKey = khozenCommonParam.getSikibetuKey(syono);

                tableMaintenanceUtil.backUp(syono, sikibetuKey);

                khozenCommonParam.setBatchBakKykKihon(tableMaintenanceUtil.getBakKykKihon());

                khozenCommonParam.setBatchBakAnsyuKihon(tableMaintenanceUtil.getBakAnsyuKihon());

                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);

                kykKihon.setCifcd(cifcdIktHnkWk.getCifcd());
                kykKihon.setSyhenkouymd(syoriYmd);
                kykKihon.setGyoumuKousinKinou(kinouId);
                kykKihon.setGyoumuKousinsyaId(userId);
                kykKihon.setGyoumuKousinTime(sysDateTimeMilli);

                IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syono);

                khozenCommonParam.setBatchKeiyakuKihon(kykKihon);

                khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

                IT_KhTtdkRireki khTtdkRireki = kykKihon.createKhTtdkRireki();

                khTtdkRireki.setHenkousikibetukey(sikibetuKey);

                EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);

                editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
                editTtdkRirekiTblParam.setSyoNo(syono);
                editTtdkRirekiTblParam.setSyoriYmd(syoriYmd);
                editTtdkRirekiTblParam.setSysTime(sysDateTimeMilli);
                editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);

                editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

                multipleEntityUpdater.add(kykKihon);

                syoriKensuu = syoriKensuu + 1;
            }
            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        khCifcdIkkatuHenkouDao.deleteCifcdIktHnkWk();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }
}
