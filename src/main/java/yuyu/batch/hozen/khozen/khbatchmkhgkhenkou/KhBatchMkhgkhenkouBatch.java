package yuyu.batch.hozen.khozen.khbatchmkhgkhenkou;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khozen.khbatchmkhgkhenkou.dba.KhBatchMkhgkhenkouDao;
import yuyu.batch.hozen.khozen.khbatchmkhgkhenkou.dba.KhHenkouUktkBean;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiParam;
import yuyu.common.hozen.khcommon.EditKhMisslstParam;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtl;
import yuyu.common.hozen.khcommon.MkhgkhenkouDBUpdate;
import yuyu.common.hozen.khcommon.MkhgkhenkouDBUpdateBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_Dbhanei;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.entity.IT_KhHenkouUktkMkhgkHnk;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 契約保全 バッチ目標額変更クラス
 */
public class KhBatchMkhgkhenkouBatch implements Batch {

    private static final String TYSYTTAISYOU_TABLE_ID = IT_KhHenkouUktk.TABLE_NAME;

    private static final String RECOVERY_FILTER_KBNID = "Kh001";

    private KhozenCommonParam khozenCommonParam;

    private List<EditKhMisslstParam> editKhMisslstParamLst;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhBatchMkhgkhenkouDao khBatchMkhgkhenkouDao;

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

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        editKhMisslstParamLst = new ArrayList<>();
        int inputKensuu = 0;
        int syoriKensuu = 0;
        int henkouNsKensuu = 0;
        int missListKensuu = 0;
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String ibKakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();
        String kinouId = khozenCommonParam.getFunctionId();
        String userId = khozenCommonParam.getUserID();
        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1018), ibKakutyoujobCd));

        try (
            ExDBResults<KhHenkouUktkBean> khHenkouUktkBeanList = khBatchMkhgkhenkouDao.
            getKhHenkouUktkBeans(ibKakutyoujobCd, syoriYmd);) {

            for (KhHenkouUktkBean khHenkouUktkBean : khHenkouUktkBeanList) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khHenkouUktkBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khHenkouUktkBean.getSyono());

                inputKensuu++;
                String misslistMsg = "";

                khozenCommonParam.setSikibetuKey(null);

                IT_KykKihon kykKihon = hozenDomManager.getKykKihon(khHenkouUktkBean.getSyono());

                IT_KhHenkouUktk khHenkouUktk = hozenDomManager.getKhHenkouUktk(khHenkouUktkBean.getSyono(),
                    khHenkouUktkBean.getHozenhenkouuktkrenno());

                IT_KhHenkouUktkMkhgkHnk khHenkouUktkMkhgkHnk = khHenkouUktk.getKhHenkouUktkMkhgkHnk();

                IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

                if ("999".equals(String.valueOf(khHenkouUktkMkhgkHnk.getTargettkmokuhyouti()))) {
                    if ("0".equals(String.valueOf(kykSonotaTkyk.getTargettkmokuhyouti()))) {

                        khHenkouUktk.setUktkjyoutaikbn(C_UktkJyoutaiKbn.TORIKESI);
                        khHenkouUktk.setGyoumuKousinKinou(kinouId);
                        khHenkouUktk.setGyoumuKousinsyaId(userId);
                        khHenkouUktk.setGyoumuKousinTime(sysDateTimeMilli);

                        henkouNsKensuu++;

                        hozenDomManager.update(khHenkouUktk);

                        continue;
                    }
                }
                else {
                    if (khHenkouUktkMkhgkHnk.getTargettkmokuhyouti().equals(kykSonotaTkyk.getTargettkmokuhyouti())) {

                        khHenkouUktk.setUktkjyoutaikbn(C_UktkJyoutaiKbn.TORIKESI);
                        khHenkouUktk.setGyoumuKousinKinou(kinouId);
                        khHenkouUktk.setGyoumuKousinsyaId(userId);
                        khHenkouUktk.setGyoumuKousinTime(sysDateTimeMilli);

                        henkouNsKensuu++;

                        hozenDomManager.update(khHenkouUktk);

                        continue;
                    }
                }
                CheckYuukouJyoutai checkYuukouJyoutai= SWAKInjector.getInstance(CheckYuukouJyoutai.class);
                CheckYuukouJyoutaiParam checkYuukouJyoutaiParam = SWAKInjector.getInstance(CheckYuukouJyoutaiParam.class);

                checkYuukouJyoutaiParam.setSyono(khHenkouUktkBean.getSyono());

                C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam, checkYuukouJyoutaiParam);

                if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {

                    missListKensuu++;

                    misslistMsg = MessageUtil.getMessage(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());

                    EditKhMisslstParam editKhMisslstParam = SWAKInjector.getInstance(EditKhMisslstParam.class);

                    editKhMisslstParam.setDataNo(missListKensuu);
                    editKhMisslstParam.setSeqNo(missListKensuu);
                    editKhMisslstParam.setMisslistMsg(misslistMsg);
                    editKhMisslstParam.setDBhaneikbn(C_Dbhanei.NONE);
                    editKhMisslstParam.setSyoNo(khHenkouUktkBean.getSyono());

                    editKhMisslstParamLst.add(editKhMisslstParam);

                    khHenkouUktk.setUktkjyoutaikbn(C_UktkJyoutaiKbn.ERROR);
                    khHenkouUktk.setGyoumuKousinKinou(kinouId);
                    khHenkouUktk.setGyoumuKousinsyaId(userId);
                    khHenkouUktk.setGyoumuKousinTime(sysDateTimeMilli);

                    hozenDomManager.update(khHenkouUktk);

                    continue;
                }

                HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);

                C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(khozenCommonParam, khHenkouUktkBean.getSyono());

                if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {

                    missListKensuu++;

                    misslistMsg = MessageUtil.getMessage(MessageId.EIA1006, hanteiTetuduki.getMessageParam());

                    EditKhMisslstParam editKhMisslstParam = SWAKInjector.getInstance(EditKhMisslstParam.class);

                    editKhMisslstParam.setDataNo(missListKensuu);
                    editKhMisslstParam.setSeqNo(missListKensuu);
                    editKhMisslstParam.setMisslistMsg(misslistMsg);
                    editKhMisslstParam.setDBhaneikbn(C_Dbhanei.NONE);
                    editKhMisslstParam.setSyoNo(khHenkouUktkBean.getSyono());

                    editKhMisslstParamLst.add(editKhMisslstParam);

                    khHenkouUktk.setUktkjyoutaikbn(C_UktkJyoutaiKbn.ERROR);
                    khHenkouUktk.setGyoumuKousinKinou(kinouId);
                    khHenkouUktk.setGyoumuKousinsyaId(userId);
                    khHenkouUktk.setGyoumuKousinTime(sysDateTimeMilli);

                    hozenDomManager.update(khHenkouUktk);

                    continue;
                }

                syoriKensuu++;

                MkhgkhenkouDBUpdate mkhgkhenkouDBUpdate = SWAKInjector.getInstance(MkhgkhenkouDBUpdate.class);
                MkhgkhenkouDBUpdateBean mkhgkhenkouDBUpdateBean = SWAKInjector.getInstance(MkhgkhenkouDBUpdateBean.class);

                C_TargetTkMokuhyoutiKbn targetTkMokuhyoutiKbn = C_TargetTkMokuhyoutiKbn.valueOf(
                    String.valueOf(khHenkouUktkMkhgkHnk.getTargettkmokuhyouti()));

                mkhgkhenkouDBUpdateBean.setKykKihon(kykKihon);
                mkhgkhenkouDBUpdateBean.setKhHenkouUktk(khHenkouUktk);
                mkhgkhenkouDBUpdateBean.setTargetTkKykhenkoymd(khHenkouUktk.getUktkymd());
                mkhgkhenkouDBUpdateBean.setTargettkMkhtkbn(targetTkMokuhyoutiKbn);
                mkhgkhenkouDBUpdateBean.setKhCommonParam(khozenCommonParam);
                mkhgkhenkouDBUpdateBean.setHassouKbn(C_HassouKbn.TYOKUSOU);
                mkhgkhenkouDBUpdateBean.setSyoriYmd(syoriYmd);

                mkhgkhenkouDBUpdate.exec(mkhgkhenkouDBUpdateBean);
                hozenDomManager.update(mkhgkhenkouDBUpdateBean.getKykKihon());
                hozenDomManager.update(mkhgkhenkouDBUpdateBean.getKhHenkouUktk());
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        if (editKhMisslstParamLst.size() > 0) {

            KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

            khozenTyouhyouCtl.setEditKkMisslstParam(editKhMisslstParamLst);
            khozenTyouhyouCtl.setSyoriYmd(syoriYmd);

            khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam,
                new C_SyoruiCdKbn[] { C_SyoruiCdKbn.KK_BATCHMKHGKHENKOU_MISSLIST }, C_YouhiKbn.HUYOU);
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0020, String.valueOf(inputKensuu)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));

        if (henkouNsKensuu > 0) {
            batchLogger.info(MessageUtil.getMessage(MessageId.IAC1001, "変更なし", String.valueOf(henkouNsKensuu)));
        }

        if (editKhMisslstParamLst.size() > 0) {
            batchLogger.info(MessageUtil.getMessage(MessageId.IAC1001, "ミスリスト",
                String.valueOf(editKhMisslstParamLst.size())));
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }
}
