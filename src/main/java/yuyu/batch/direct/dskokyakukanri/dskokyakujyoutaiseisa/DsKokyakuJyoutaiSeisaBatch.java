package yuyu.batch.direct.dskokyakukanri.dskokyakujyoutaiseisa;

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
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.direct.dscommon.DsSaibanSyori;
import yuyu.common.direct.dscommon.DsTetudukiRirekiTableEdit;
import yuyu.common.direct.dscommon.DsTetudukiRirekiTableEditParamImpl;
import yuyu.common.direct.dscommon.TableMaintenanceUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsMailDbSyoriKbn;
import yuyu.def.classification.C_DsMailSousinJyoutaiKbn;
import yuyu.def.classification.C_DsMailSousinTeisiRiyuuKbn;
import yuyu.def.classification.C_DsRendouTaisyouKbn;
import yuyu.def.classification.C_DsSyoriKbn;
import yuyu.def.classification.C_DsTeisiRiyuuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsMailAddress;
import yuyu.def.db.entity.MT_DsMailAddressSpiralYyk;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * ダイレクトサービス 顧客管理 顧客状態精査クラス
 */
public class DsKokyakuJyoutaiSeisaBatch implements Batch {

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

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(bzBatchParam.getSyoriYmd())));

        try (ExDBUpdatableResults<MT_DsKokyakuKanri> dsKokyakuKanriLst = directDomManager.
            getDsKokyakuKanrisByKakutyoujobcdDskokyakujtkbnSeisahuyouhyjDskykmukouhyj(
                bzBatchParam.getIbKakutyoujobcd());
            EntityInserter<MT_BAK_DsKokyakuKanri> bakDsKokyakuKanriInserter = new EntityInserter<>()) {

            String sysTime = BizDate.getSysDateTimeMilli();
            long dsKokyakuSyoumetuKensu = 0;
            DsTetudukiRirekiTableEditParamImpl dsTetudukiRirekiTableEditParamImpl=
                SWAKInjector.getInstance(DsTetudukiRirekiTableEditParamImpl.class);
            DsSaibanSyori dsSaibanSyori = SWAKInjector.getInstance(DsSaibanSyori.class);
            TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);
            DsTetudukiRirekiTableEdit editDSTtdkRirekiTbl = SWAKInjector.getInstance(DsTetudukiRirekiTableEdit.class);

            for (MT_DsKokyakuKanri dsKokyakuKanri : dsKokyakuKanriLst) {

                String dsKokyakuNo = dsKokyakuKanri.getDskokno();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(
                    bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(dsKokyakuNo);

                List<MT_DsMailAddress> dsMailAddressLst = dsKokyakuKanri.getDsMailAddresss();

                String dsHenkouSikibetukey = dsSaibanSyori.saibanDsHenkouSikibetukey();

                MT_BAK_DsKokyakuKanri bakDsKokyakuKanri = tableMaintenanceUtil.exec(dsKokyakuNo, dsHenkouSikibetukey);
                if (bakDsKokyakuKanri == null) {

                    throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EMA1009, dsKokyakuNo));
                }

                dsKokyakuKanri.setDskokyakujtkbn(C_DsKokyakuJtKbn.SEISA_SYOUMETU);
                dsKokyakuKanri.setDsteisiriyuukbn(C_DsTeisiRiyuuKbn.BLANK);
                dsKokyakuKanri.setDskokyakumukouymd(bzBatchParam.getSyoriYmd());
                dsKokyakuKanri.setGyoumuKousinKinou(kinou.getKinouId());
                dsKokyakuKanri.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                dsKokyakuKanri.setGyoumuKousinTime(sysTime);

                for (MT_DsMailAddress dsMailAddress : dsMailAddressLst) {
                    if (C_DsMailSousinJyoutaiKbn.YUUKOU.eq(dsMailAddress.getDsmailsousinjyoutaikbn())) {
                        dsMailAddress.setDsmailsousinjyoutaikbn(C_DsMailSousinJyoutaiKbn.TEISI);
                        dsMailAddress.setDsmailsousintisrykbn(C_DsMailSousinTeisiRiyuuKbn.KOKYAKUSYOUMETU);
                        dsMailAddress.setDskousinymdtime(sysTime);
                        dsMailAddress.setGyoumuKousinKinou(kinou.getKinouId());
                        dsMailAddress.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        dsMailAddress.setGyoumuKousinTime(sysTime);

                        MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk =
                            dsKokyakuKanri.getDsMailAddressSpiralYykByDsdatasakuseiymdDsmailaddressrenban(
                                bzBatchParam.getSyoriYmd(), dsMailAddress.getDsmailaddressrenban());

                        if (dsMailAddressSpiralYyk != null) {

                            if (C_DsMailDbSyoriKbn.TOUROKU.eq(dsMailAddressSpiralYyk.getDsmaildbsyorikbn())) {
                                dsKokyakuKanri.getDsMailAddressSpiralYyks().remove(dsMailAddressSpiralYyk);
                            }
                            else {
                                dsMailAddressSpiralYyk.setDsrendoutaisyoukbn(C_DsRendouTaisyouKbn.RENDOUTAISYOU);
                                dsMailAddressSpiralYyk.setDsmaildbsyorikbn(C_DsMailDbSyoriKbn.SAKUJYO);
                                dsMailAddressSpiralYyk.setGyoumuKousinKinou(kinou.getKinouId());
                                dsMailAddressSpiralYyk.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                                dsMailAddressSpiralYyk.setGyoumuKousinTime(sysTime);
                            }
                        }
                        else {
                            dsMailAddressSpiralYyk = dsKokyakuKanri.createDsMailAddressSpiralYyk();

                            dsMailAddressSpiralYyk.setDsdatasakuseiymd(bzBatchParam.getSyoriYmd());
                            dsMailAddressSpiralYyk.setDsmailaddressrenban(dsMailAddress.getDsmailaddressrenban());
                            dsMailAddressSpiralYyk.setDsmailaddress(dsMailAddress.getDsmailaddress());
                            dsMailAddressSpiralYyk.setDsrendoutaisyoukbn(C_DsRendouTaisyouKbn.RENDOUTAISYOU);
                            dsMailAddressSpiralYyk.setDsmaildbsyorikbn(C_DsMailDbSyoriKbn.SAKUJYO);
                            dsMailAddressSpiralYyk.setGyoumuKousinKinou(kinou.getKinouId());
                            dsMailAddressSpiralYyk.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                            dsMailAddressSpiralYyk.setGyoumuKousinTime(sysTime);

                            BizPropertyInitializer.initialize(dsMailAddressSpiralYyk);
                        }
                    }
                }

                dsTetudukiRirekiTableEditParamImpl.setDskokno(dsKokyakuNo);
                dsTetudukiRirekiTableEditParamImpl.setDsKokyakuKanri(dsKokyakuKanri);
                dsTetudukiRirekiTableEditParamImpl.setBakDsKokyakuKanri(bakDsKokyakuKanri);
                dsTetudukiRirekiTableEditParamImpl.setHenkousikibetukey(dsHenkouSikibetukey);
                dsTetudukiRirekiTableEditParamImpl.setSyoriYmd(bzBatchParam.getSyoriYmd());
                dsTetudukiRirekiTableEditParamImpl.setDssyorikbn(C_DsSyoriKbn.KOKYAKU_KANRI_SYOUMETU);
                dsTetudukiRirekiTableEditParamImpl.setHenkouRrkYouhi(C_YouhiKbn.YOU);
                editDSTtdkRirekiTbl.editDSTtdkRirekiTblBatch(dsTetudukiRirekiTableEditParamImpl);

                bakDsKokyakuKanriInserter.add(bakDsKokyakuKanri);
                dsKokyakuSyoumetuKensu++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(MessageId.IAC1001,
                MessageUtil.getMessage(MessageId.IMW1002),
                String.valueOf(dsKokyakuSyoumetuKensu)));
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
