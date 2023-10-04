package yuyu.batch.hozen.khinterf.khuriagesousinfilesks;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khuriagesousinfilesks.dba.KhUriageSeikyuuDataBean;
import yuyu.batch.hozen.khinterf.khuriagesousinfilesks.dba.KhUriageSousinFileSksDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_AuthoriKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.db.entity.ZT_UriageSousinTy;
import yuyu.def.db.mapping.GenIT_UriageSeikyuuData;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 売上送信Ｆ作成のバッチクラスです。
 */
public class KhUriageSousinFileSksBatch implements Batch {

    private static final String TABLEID = GenIT_UriageSeikyuuData.TABLE_NAME;

    private static final String FILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhUriageSousinFileSksBatchParam khUriageSousinFileSksBatchParam;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private KhUriageSousinFileSksDao KhUriageSousinFileSksDao;

    @Override
    public BatchParam getParam() {
        return khUriageSousinFileSksBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = khUriageSousinFileSksBatchParam.getSyoriYmd();

        String kakutyouJobcd = khUriageSousinFileSksBatchParam.getIbKakutyoujobcd();

        String heisoukbn = khUriageSousinFileSksBatchParam.getHeisoukbn();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyouJobcd));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBC1025, heisoukbn));

        long syoriKensuu = 0;

        BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);

        try (
            ExDBResults<KhUriageSeikyuuDataBean> khUriageSeikyuuDataBeanList = KhUriageSousinFileSksDao
            .getUriageSeikyuuDataBeans(kakutyouJobcd,syoriYmd,heisoukbn);
            EntityInserter<ZT_UriageSousinTy> entityInserter = new EntityInserter<>();
            ) {
            for (KhUriageSeikyuuDataBean khUriageSeikyuuDataBean : khUriageSeikyuuDataBeanList ) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khUriageSeikyuuDataBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khUriageSeikyuuDataBean.getSyono());

                ZT_UriageSousinTy uriageSousinTy = new ZT_UriageSousinTy();
                String authorikbn = "";
                KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(
                    khUriageSeikyuuDataBean.getAuthorikbn().getValue(),
                    C_AuthoriKbn.class,
                    C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER );
                authorikbn = kbnInfoBean.getKbnData();

                uriageSousinTy.setZtycreditkessaiyouno(khUriageSeikyuuDataBean.getCreditkessaiyouno());
                uriageSousinTy.setZtyauthorikbn(authorikbn);
                uriageSousinTy.setZtyuriageseikyuuymd(String.valueOf(khUriageSeikyuuDataBean.getUriagenengappi()));
                uriageSousinTy.setZtyrsgaku(new BigDecimal(khUriageSeikyuuDataBean.getCredituriagegk().
                    toAdsoluteString()).longValue());
                uriageSousinTy.setZtyfukusuukameitennokey(khUriageSeikyuuDataBean.getFukusuukameitennokey());
                uriageSousinTy.setZtysyono(khUriageSeikyuuDataBean.getSyono());
                uriageSousinTy.setZtyrecordno(khUriageSeikyuuDataBean.getRecordno());
                if (khUriageSeikyuuDataBean.getJyuutouym() != null) {
                    uriageSousinTy.setZtyuriagetaisyouym(String.valueOf(khUriageSeikyuuDataBean.getJyuutouym()));
                }else{
                    uriageSousinTy.setZtyuriagetaisyouym("");
                }
                BizPropertyInitializer.initialize(uriageSousinTy);

                entityInserter.add(uriageSousinTy);

                syoriKensuu = syoriKensuu + 1;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(MessageId.IBC1026, heisoukbn));

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
        }

    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
