package yuyu.batch.direct.dshozentetuduki.dstmttknitenuktkyykrndu;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityDeleter;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.direct.dshozentetuduki.dstmttknitenuktkyykrndu.dba.DsTmttknItenUktkYykRnduDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.entity.MT_KhHenkouUktkYyk;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * ダイレクトサービス 保全手続 ＤＳ積立金移転受付予約連動<br />
 *
 */
public class DsTmttknItenUktkYykRnduBatch implements Batch{

    private static final String KHHENKOUUKTK = "契約保全変更受付テーブル";

    private static final String RECOVERY_FILTER_KBNID = "Ds004";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private DsTmttknItenUktkYykRnduDao dsTmttknItenUktkYykRnduDao;

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
        long tmttknitenukeSyoriCount = 0;
        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(
            MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
                String.valueOf(syoriYmd)));

        try (
            EntityInserter<IT_KhHenkouUktk> entityInserter = new EntityInserter<>();
            EntityDeleter<MT_KhHenkouUktkYyk> entityDeleter = new EntityDeleter<>();
            ExDBUpdatableResults<MT_KhHenkouUktkYyk> mtKhHenkouUktkYykList =
                dsTmttknItenUktkYykRnduDao.getKhHenkouUktkYykInfosByKakutyoujobcd(kakutyouJobCd);) {

            for (MT_KhHenkouUktkYyk khHenkouUktkYyk : mtKhHenkouUktkYykList) {

                IT_KhHenkouUktk iT_KhHenkouUktk = new IT_KhHenkouUktk(khHenkouUktkYyk.getSyono(),
                    khHenkouUktkYyk.getHozenhenkouuktkrenno());

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(MT_KhHenkouUktkYyk.TABLE_NAME);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khHenkouUktkYyk.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khHenkouUktkYyk.getSyono());

                iT_KhHenkouUktk.setUktkymd(khHenkouUktkYyk.getUktkymd());

                iT_KhHenkouUktk.setTourokuroute(khHenkouUktkYyk.getTourokuroute());

                iT_KhHenkouUktk.setUktksyorikbn(khHenkouUktkYyk.getUktksyorikbn());

                iT_KhHenkouUktk.setKouryokuhasseiymd(khHenkouUktkYyk.getKouryokuhasseiymd());

                iT_KhHenkouUktk.setSyoriyoteiymd(khHenkouUktkYyk.getSyoriyoteiymd());

                iT_KhHenkouUktk.setUktkjyoutaikbn(khHenkouUktkYyk.getUktkjyoutaikbn());

                iT_KhHenkouUktk.setGyoumuKousinKinou(khHenkouUktkYyk.getGyoumuKousinKinou());

                iT_KhHenkouUktk.setGyoumuKousinsyaId(khHenkouUktkYyk.getGyoumuKousinsyaId());

                iT_KhHenkouUktk.setGyoumuKousinTime(khHenkouUktkYyk.getGyoumuKousinTime());

                BizPropertyInitializer.initialize(iT_KhHenkouUktk);

                entityInserter.add(iT_KhHenkouUktk);

                entityDeleter.add(khHenkouUktkYyk);

                tmttknitenukeSyoriCount = tmttknitenukeSyoriCount + 1;
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(tmttknitenukeSyoriCount), KHHENKOUUKTK));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

}
