package yuyu.batch.hozen.khzeimu.khsiharaityousyosyuuseifsks;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khzeimu.khsiharaityousyosyuuseifsks.dba.KhSiharaiTyousyoSyuuseiFSksBean;
import yuyu.batch.hozen.khzeimu.khsiharaityousyosyuuseifsks.dba.KhSiharaiTyousyoSyuuseiFSksDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.db.entity.ZT_DSeisanShrTysySyuseiTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 税務 契約保全支払調書修正Ｆ作成
 */
public class KhSiharaiTyousyoSyuuseiFSksBatch implements Batch {

    private static final String TYSYTTAISYOUTABLEID = "IT_DSeisanShrTysySyusei";

    private static final String RECOVERYFILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhSiharaiTyousyoSyuuseiFSksDao khSiharaiTyousyoSyuuseiFSksDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String ibKakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            ibKakutyoujobcd));

        long nyuuryokuKensuu = 0;
        long outKensuu = 0;

        try (
            EntityInserter<ZT_DSeisanShrTysySyuseiTy> khSiharaiTyousyoSyuuseiTyInserter = new EntityInserter<>();

            ExDBResults<KhSiharaiTyousyoSyuuseiFSksBean> khSiharaiTyousyoSyuuseiFSksBeanLst =
                khSiharaiTyousyoSyuuseiFSksDao.getDSeisanShrTysySyuseiBySyoriYmd(ibKakutyoujobcd, syoriYmd);) {

            for (KhSiharaiTyousyoSyuuseiFSksBean khSiharaiTyousyoSyuuseiFSksBean : khSiharaiTyousyoSyuuseiFSksBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khSiharaiTyousyoSyuuseiFSksBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khSiharaiTyousyoSyuuseiFSksBean.getSyono());

                nyuuryokuKensuu = nyuuryokuKensuu + 1;

                ZT_DSeisanShrTysySyuseiTy  dSeisanShrTysySyuseiTy = new ZT_DSeisanShrTysySyuseiTy();

                dSeisanShrTysySyuseiTy.setZtysyono(khSiharaiTyousyoSyuuseiFSksBean.getSyono());
                dSeisanShrTysySyuseiTy.setZtyseisandshrymd(khSiharaiTyousyoSyuuseiFSksBean.getSeisandshrymd().toString());
                dSeisanShrTysySyuseiTy.setZtyseisandkgk11(Long.valueOf(khSiharaiTyousyoSyuuseiFSksBean.getSeisand().toString()));
                dSeisanShrTysySyuseiTy.setZtytyouseidkgk11(Long.valueOf(khSiharaiTyousyoSyuuseiFSksBean.getTyouseid().toString()));

                BizPropertyInitializer.initialize(dSeisanShrTysySyuseiTy);
                khSiharaiTyousyoSyuuseiTyInserter.add(dSeisanShrTysySyuseiTy);

                outKensuu = outKensuu + 1;

            }

            bzRecoveryDatasikibetuBean.initializeBlank();

        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(nyuuryokuKensuu),"Ｄ精算支払調書修正テーブル"));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(outKensuu),"Ｄ精算支払調書修正テーブル（中）"));

    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector.getInstance(
            BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
