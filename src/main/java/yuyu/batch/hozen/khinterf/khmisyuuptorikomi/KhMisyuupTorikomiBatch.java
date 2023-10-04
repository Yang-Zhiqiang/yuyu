package yuyu.batch.hozen.khinterf.khmisyuuptorikomi;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.db.MultipleEntityUpdater;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khmisyuuptorikomi.dba.KhMisyuupTorikomiDao;
import yuyu.batch.hozen.khinterf.khmisyuuptorikomi.dba.MisyuupRendoBean;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.SaibanBiz;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_TRNyuukin;
import yuyu.def.db.entity.JT_MisyuupRendo;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 未収Ｐ情報取込
 */
public class KhMisyuupTorikomiBatch implements Batch {

    private static final String TABLEID = JT_MisyuupRendo.TABLE_NAME;

    private static final String FILTERID = "Bz001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam khMisyuupTorikomiParam;

    @Inject
    private KhMisyuupTorikomiDao khMisyuupTorikomiDao;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return khMisyuupTorikomiParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = khMisyuupTorikomiParam.getSyoriYmd();

        String kakutyouJobcd = khMisyuupTorikomiParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW1018), kakutyouJobcd));

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        long kensu = 0;

        String misyuupRendoSyono = "";

        String sikibetuKey = "";

        String sysDateTime = BizDate.getSysDateTimeMilli();

        try (MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();

            MultipleEntityUpdater multipleEntityUpdater = new MultipleEntityUpdater();

            ExDBResults<MisyuupRendoBean> misyuupRendoBeanList =
                khMisyuupTorikomiDao.getMisyuupRendoBean(kakutyouJobcd, syoriYmd);) {

            for (MisyuupRendoBean misyuupRendoBean : misyuupRendoBeanList) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobcd);

                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);

                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(misyuupRendoBean.getSyono());

                khozenCommonParam.setSikibetuKey(null);

                IT_KykKihon kykKihon = null;

                if (!misyuupRendoSyono.equals(misyuupRendoBean.getSyono())) {

                    kykKihon = hozenDomManager.getKykKihon(misyuupRendoBean.getSyono());

                    IT_KhTtdkRireki khTtdkRireki = kykKihon.createKhTtdkRireki();

                    khTtdkRireki.setHenkousikibetukey(khozenCommonParam.getSikibetuKey(misyuupRendoBean.getSyono()));

                    khozenCommonParam.setBatchKeiyakuKihon(kykKihon);

                    EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector
                        .getInstance(EditTtdkRirekiTblParam.class);

                    EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);

                    editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);

                    editTtdkRirekiTblParam.setSyoNo(misyuupRendoBean.getSyono());

                    editTtdkRirekiTblParam.setSyoriYmd(syoriYmd);

                    editTtdkRirekiTblParam.setSysTime(sysDateTime);

                    editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

                    kykKihon.setSyhenkouymd(syoriYmd);

                    kykKihon.setGyoumuKousinKinou(kinou.getKinouId());

                    kykKihon.setGyoumuKousinsyaId(baseUserInfo.getUserId());

                    kykKihon.setGyoumuKousinTime(sysDateTime);

                    sikibetuKey = SaibanBiz.getNyukinTRRenban(syoriYmd.toString());

                    misyuupRendoSyono = misyuupRendoBean.getSyono();
                }

                IT_TRNyuukin tRNyuukin = new IT_TRNyuukin(misyuupRendoBean.getSyono(),
                    syoriYmd, sikibetuKey, misyuupRendoBean.getDatarenno());

                tRNyuukin.setNykkeiro(misyuupRendoBean.getNykkeiro());

                tRNyuukin.setHrkkaisuu(misyuupRendoBean.getHrkkaisuu());

                tRNyuukin.setNyknaiyoukbn(misyuupRendoBean.getNyknaiyoukbn());

                tRNyuukin.setIktnyuukinnumu(misyuupRendoBean.getIktnyuukinnumu());

                tRNyuukin.setJyuutouym(misyuupRendoBean.getMisyuupjyuutouym());

                tRNyuukin.setJyutoukaisuuy(misyuupRendoBean.getMisyuupjyuutoukaisuuy());

                tRNyuukin.setJyutoukaisuum(misyuupRendoBean.getMisyuupjyuutoukaisuum());

                tRNyuukin.setRsgaku(misyuupRendoBean.getMisyuup());

                tRNyuukin.setRyosyuymd(misyuupRendoBean.getRyosyuymd());

                tRNyuukin.setNykdenymd(misyuupRendoBean.getDenymd());

                tRNyuukin.setTikiktbrisyuruikbn(misyuupRendoBean.getTikiktbrisyuruikbn());

                tRNyuukin.setRstuukasyu(misyuupRendoBean.getShrtuukasyu());

                tRNyuukin.setNyknkwsratekijyunymd(misyuupRendoBean.getNyknkwsratekijyunymd());

                tRNyuukin.setGyoumuKousinKinou(kinou.getKinouId());

                tRNyuukin.setGyoumuKousinsyaId(baseUserInfo.getUserId());

                tRNyuukin.setGyoumuKousinTime(sysDateTime);

                BizPropertyInitializer.initialize(tRNyuukin);

                kensu = kensu + 1;

                if (kykKihon != null) {
                    multipleEntityUpdater.add(kykKihon);
                }

                multipleEntityInserter.add(tRNyuukin);

            }
            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(kensu)));
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}