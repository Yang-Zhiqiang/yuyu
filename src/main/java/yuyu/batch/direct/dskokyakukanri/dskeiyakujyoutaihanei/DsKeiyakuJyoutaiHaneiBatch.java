package yuyu.batch.direct.dskokyakukanri.dskeiyakujyoutaihanei;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.direct.dscommon.DsSaibanSyori;
import yuyu.common.direct.dscommon.DsTetudukiRirekiTableEdit;
import yuyu.common.direct.dscommon.DsTetudukiRirekiTableEditParamImpl;
import yuyu.common.direct.dscommon.HozenKeiyakuIdouJyoutaiSyutoku;
import yuyu.common.direct.dscommon.TableMaintenanceUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_DsSyoriKbn;
import yuyu.def.classification.C_DsTrhkserviceRiyoujkKbn;
import yuyu.def.classification.C_DsTrhkserviceTeisiRiyuuKbn;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukshantkekKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsTorihikiServiceKanri;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * ダイレクトサービス 顧客管理 契約状態反映クラス
 */
public class DsKeiyakuJyoutaiHaneiBatch implements Batch {

    private final String TABLE_ID = "MT_DsKokyakuKanri";

    private final String RECOVERY_FILTER_ID = "Ds001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private DirectDomManager directDomManager;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        try (ExDBUpdatableResults<MT_DsKokyakuKanri> dsKokyakuKanriLst = directDomManager.
            getDsKokyakuKanrisByKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
            EntityInserter<MT_BAK_DsKokyakuKanri> bakDsKokyakuKanriInserter = new EntityInserter<>()) {

            BizDate syoriYmd = bzBatchParam.getSyoriYmd();

            long keiyakusyoukensu = 0;

            long trhkServiceSyoukensu = 0;

            DsTetudukiRirekiTableEditParamImpl dsTetudukiRirekiTableEditParamImpl=
                SWAKInjector.getInstance(DsTetudukiRirekiTableEditParamImpl.class);
            DsTetudukiRirekiTableEdit editDSTtdkRirekiTbl = SWAKInjector.getInstance(DsTetudukiRirekiTableEdit.class);

            DsSaibanSyori dsSaibanSyori = SWAKInjector.getInstance(DsSaibanSyori.class);

            TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);

            HozenKeiyakuIdouJyoutaiSyutoku keiyakuIdouJyoutaiSyutoku = SWAKInjector.getInstance(
                HozenKeiyakuIdouJyoutaiSyutoku.class);

            String sysTime = BizDate.getSysDateTimeMilli();

            for (MT_DsKokyakuKanri dsKokyakuKanri : dsKokyakuKanriLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(dsKokyakuKanri.getDskokno());

                String dskokNo = dsKokyakuKanri.getDskokno();

                List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuLst = dsKokyakuKanri.getDsKokyakuKeiyakus();

                String dsHenkouSikibetukey = dsSaibanSyori.saibanDsHenkouSikibetukey();

                MT_BAK_DsKokyakuKanri bakDsKokyakuKanri = tableMaintenanceUtil.exec(dskokNo, dsHenkouSikibetukey);
                if (bakDsKokyakuKanri == null) {

                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EMA1009, dskokNo));
                }

                for (MT_DsKokyakuKeiyaku dsKokyakuKeiyaku : dsKokyakuKeiyakuLst) {

                    if (!C_MukouHyj.MUKOU.eq(dsKokyakuKeiyaku.getDskykmukouhyj())) {

                        C_YuukshantkekKbn yuukshantkekKbn = keiyakuIdouJyoutaiSyutoku.keiyakuJyoutaiYuukouseiHantei(
                            dsKokyakuKeiyaku.getSyono());

                        if (C_YuukshantkekKbn.ERROR.eq(yuukshantkekKbn)) {

                            throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EBF0129,
                                MessageUtil.getMessage(MessageId.EMW1008)));
                        }

                        else if (!C_YuukshantkekKbn.OK.eq(yuukshantkekKbn)) {

                            dsKokyakuKeiyaku.setDskykmukouhyj(C_MukouHyj.MUKOU);
                            dsKokyakuKeiyaku.setDskykmukouymd(syoriYmd);
                            dsKokyakuKeiyaku.setGyoumuKousinKinou(kinou.getKinouId());
                            dsKokyakuKeiyaku.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                            dsKokyakuKeiyaku.setGyoumuKousinTime(sysTime);

                            MT_DsTorihikiServiceKanri dsTrhkServiceKanri = dsKokyakuKeiyaku.getDsTorihikiServiceKanri();

                            if (dsTrhkServiceKanri != null) {
                                if (C_DsTrhkserviceRiyoujkKbn.RIYOU_KA.eq(dsTrhkServiceKanri.getDstrhkserviceriyoujkkbn())) {

                                    dsTrhkServiceKanri.setDstrhkserviceriyoujkkbn(C_DsTrhkserviceRiyoujkKbn.RIYOU_HUKA);
                                    dsTrhkServiceKanri.setDstrhkserviceteisiriyuukbn(C_DsTrhkserviceTeisiRiyuuKbn.SYOUMETU);
                                    dsTrhkServiceKanri.setDstrhkservicemukouymd(syoriYmd);
                                    dsTrhkServiceKanri.setGyoumuKousinKinou(kinou.getKinouId());
                                    dsTrhkServiceKanri.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                                    dsTrhkServiceKanri.setGyoumuKousinTime(sysTime);

                                    trhkServiceSyoukensu++;
                                }
                            }
                            keiyakusyoukensu++;
                        }
                    }
                }

                dsTetudukiRirekiTableEditParamImpl.setDskokno(dskokNo);
                dsTetudukiRirekiTableEditParamImpl.setDsKokyakuKanri(dsKokyakuKanri);
                dsTetudukiRirekiTableEditParamImpl.setBakDsKokyakuKanri(bakDsKokyakuKanri);
                dsTetudukiRirekiTableEditParamImpl.setHenkousikibetukey(dsHenkouSikibetukey);
                dsTetudukiRirekiTableEditParamImpl.setSyoriYmd(syoriYmd);
                dsTetudukiRirekiTableEditParamImpl.setDssyorikbn(C_DsSyoriKbn.KOKYAKU_KEIYAKU_SYOUMETU);
                dsTetudukiRirekiTableEditParamImpl.setHenkouRrkYouhi(C_YouhiKbn.YOU);
                editDSTtdkRirekiTbl.editDSTtdkRirekiTblBatch(dsTetudukiRirekiTableEditParamImpl);

                bakDsKokyakuKanriInserter.add(bakDsKokyakuKanri);
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(MessageId.IAC1001, MessageUtil.getMessage(MessageId.IMW1001),
                String.valueOf(keiyakusyoukensu)));

            batchLogger.info(MessageUtil.getMessage(MessageId.IAC1001, MessageUtil.getMessage(MessageId.IMW1008),
                String.valueOf(trhkServiceSyoukensu)));
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
