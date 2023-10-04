package yuyu.batch.hozen.khinterf.khginkoumdhnmisyuuinfofilesks;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khginkoumdhnmisyuuinfofilesks.dba.KhGinkouMdhnMisyuuInfoBean;
import yuyu.batch.hozen.khinterf.khginkoumdhnmisyuuinfofilesks.dba.KhGinkouMdhnMisyuuInfoFileSksDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.db.entity.IT_KhGinkouMdhnMisyuuInfo;
import yuyu.def.db.entity.ZT_GinkouMdhnMisyuuInfoFTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 銀行窓販未収情報Ｆ作成クラス
 */
public class KhGinkouMdhnMisyuuInfoFileSksBatch implements Batch {

    private static final String TYSYTTAISYOU_TABLEID = IT_KhGinkouMdhnMisyuuInfo.TABLE_NAME;

    private static final String RECOVERY_FILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhGinkouMdhnMisyuuInfoFileSksDao khGinkouMdhnMisyuuInfoFileSksDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        String kakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyoujobCd));

        long syoriKns = 0;

        try (
            ExDBResults<KhGinkouMdhnMisyuuInfoBean> khGinkouMdhnMisyuuInfoBeanLst =
            khGinkouMdhnMisyuuInfoFileSksDao.getGinkouMdhnMisyuuInfoBeans(kakutyoujobCd, syoriYmd);
            EntityInserter<ZT_GinkouMdhnMisyuuInfoFTy> entityInserter = new EntityInserter<>()) {

            for (KhGinkouMdhnMisyuuInfoBean khHruikaeYousiFSksBean : khGinkouMdhnMisyuuInfoBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khHruikaeYousiFSksBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khHruikaeYousiFSksBean.getSyono());

                ZT_GinkouMdhnMisyuuInfoFTy ginkouMdhnMisyuuInfoFTy = new ZT_GinkouMdhnMisyuuInfoFTy();

                ginkouMdhnMisyuuInfoFTy.setZtybsydrtencd(khHruikaeYousiFSksBean.getGwbsydrtencd());
                ginkouMdhnMisyuuInfoFTy.setZtydatakbn(khHruikaeYousiFSksBean.getGwdatakbn());
                ginkouMdhnMisyuuInfoFTy.setZtydatasakuseiymd(khHruikaeYousiFSksBean.getGwdatasakuseiymd());
                ginkouMdhnMisyuuInfoFTy.setZtyhknkaisyacd(khHruikaeYousiFSksBean.getGwhknkaisyacd());
                ginkouMdhnMisyuuInfoFTy.setZtyhknsyuruicd(khHruikaeYousiFSksBean.getGwhknsyuruicd());
                ginkouMdhnMisyuuInfoFTy.setZtysyonosyuban(khHruikaeYousiFSksBean.getGwsyonosyuban());
                ginkouMdhnMisyuuInfoFTy.setZtymisyuutatekaekbn(khHruikaeYousiFSksBean.getGwmisyuutatekaekbn());
                ginkouMdhnMisyuuInfoFTy.setZtymisyuutatekaeym(khHruikaeYousiFSksBean.getGwmisyuutatekaeym());
                ginkouMdhnMisyuuInfoFTy.setZtymisyuukg(khHruikaeYousiFSksBean.getGwmisyuukg());
                ginkouMdhnMisyuuInfoFTy.setZtybnkaisuu(khHruikaeYousiFSksBean.getGwbnkaisuu());
                ginkouMdhnMisyuuInfoFTy.setZtymisyuujiyuu(khHruikaeYousiFSksBean.getGwmisyuujiyuu());
                ginkouMdhnMisyuuInfoFTy.setZtyjikaidatakousinymd(khHruikaeYousiFSksBean.getGwjikaidatakousinymd());
                ginkouMdhnMisyuuInfoFTy.setZtyikkatubaraikbn(String.valueOf(khHruikaeYousiFSksBean.getIkkatubaraikbn()));
                ginkouMdhnMisyuuInfoFTy.setZtyikkatubaraikaisuu(String.valueOf(khHruikaeYousiFSksBean.getIkkatubaraikaisuukbn()));

                BizPropertyInitializer.initialize(ginkouMdhnMisyuuInfoFTy);

                entityInserter.add(ginkouMdhnMisyuuInfoFTy);

                syoriKns++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKns)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
