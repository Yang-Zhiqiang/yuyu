package yuyu.batch.direct.dshozentetuduki.dskaiyakuuktkyykrndu;

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
import yuyu.batch.direct.dshozentetuduki.dskaiyakuuktkyykrndu.dba.DsKaiyakuUktkYykRnduDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.entity.IT_KhHenkouUktkKaiyaku;
import yuyu.def.db.entity.MT_KhHenkouUktkYyk;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * ダイレクトサービス 保全手続 ＤＳ解約受付予約連動<br />
 *
 */
public class DsKaiyakuUktkYykRnduBatch implements Batch{

    private static final String TABLE_ID = MT_KhHenkouUktkYyk.TABLE_NAME;

    private static final String RECOVERY_FILTER_ID = "Ds004";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private DsKaiyakuUktkYykRnduDao dsKaiyakuUktkYykRnduDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        int kaiyakuUketukeSyoriCount = 0;
        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(
            MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
                String.valueOf(syoriYmd)));

        try (

            ExDBUpdatableResults<MT_KhHenkouUktkYyk> mtKhHenkouUktkYykList =
            dsKaiyakuUktkYykRnduDao.getKhHenkouUktkYykInfosByKakutyoujobcd(kakutyouJobCd);

            EntityInserter<IT_KhHenkouUktk> entityInserter = new EntityInserter<>();
            EntityDeleter<MT_KhHenkouUktkYyk> entityDeleter   = new EntityDeleter<>(); ) {

            for (MT_KhHenkouUktkYyk khHenkouUktkYyk : mtKhHenkouUktkYykList) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khHenkouUktkYyk.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khHenkouUktkYyk.getSyono());


                IT_KhHenkouUktk iT_KhHenkouUktk = new IT_KhHenkouUktk(khHenkouUktkYyk.getSyono(),
                    khHenkouUktkYyk.getHozenhenkouuktkrenno());

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

                IT_KhHenkouUktkKaiyaku iT_KhHenkouUktkKaiyaku = iT_KhHenkouUktk.createKhHenkouUktkKaiyaku();

                iT_KhHenkouUktkKaiyaku.setInputshrhousiteikbn(khHenkouUktkYyk.getKhHenkouUktkKaiyakuYyk().getInputshrhousiteikbn());

                iT_KhHenkouUktkKaiyaku.setYenshrtkhkumu(khHenkouUktkYyk.getKhHenkouUktkKaiyakuYyk().getYenshrtkhkumu());

                iT_KhHenkouUktkKaiyaku.setBankcd(khHenkouUktkYyk.getKhHenkouUktkKaiyakuYyk().getBankcd());

                iT_KhHenkouUktkKaiyaku.setSitencd(khHenkouUktkYyk.getKhHenkouUktkKaiyakuYyk().getSitencd());

                iT_KhHenkouUktkKaiyaku.setYokinkbn(khHenkouUktkYyk.getKhHenkouUktkKaiyakuYyk().getYokinkbn());

                iT_KhHenkouUktkKaiyaku.setKouzano(khHenkouUktkYyk.getKhHenkouUktkKaiyakuYyk().getKouzano());

                iT_KhHenkouUktkKaiyaku.setKzdoukbn(khHenkouUktkYyk.getKhHenkouUktkKaiyakuYyk().getKzdoukbn());

                iT_KhHenkouUktkKaiyaku.setKzmeiginmkn(khHenkouUktkYyk.getKhHenkouUktkKaiyakuYyk().getKzmeiginmkn());


                iT_KhHenkouUktkKaiyaku.setGyoumuKousinKinou(khHenkouUktkYyk.getKhHenkouUktkKaiyakuYyk().getGyoumuKousinKinou());


                iT_KhHenkouUktkKaiyaku.setGyoumuKousinsyaId(khHenkouUktkYyk.getKhHenkouUktkKaiyakuYyk().getGyoumuKousinsyaId());


                iT_KhHenkouUktkKaiyaku.setGyoumuKousinTime(khHenkouUktkYyk.getKhHenkouUktkKaiyakuYyk().getGyoumuKousinTime());

                BizPropertyInitializer.initialize(iT_KhHenkouUktkKaiyaku);


                entityInserter.add(iT_KhHenkouUktk);

                entityDeleter.add(khHenkouUktkYyk);

                kaiyakuUketukeSyoriCount = kaiyakuUketukeSyoriCount + 1;
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(kaiyakuUketukeSyoriCount), "契約保全変更受付テーブル"));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

}
