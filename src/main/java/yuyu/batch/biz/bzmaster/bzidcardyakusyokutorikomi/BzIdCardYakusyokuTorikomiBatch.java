package yuyu.batch.biz.bzmaster.bzidcardyakusyokutorikomi;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzRenkeiHenkanUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SystemRenkeiSyoriHousikiKbn;
import yuyu.def.db.entity.BW_IdCardYakusyokuWk;
import yuyu.def.db.entity.ZT_IdCardYakusyokuRn;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 連携用DB（IDカードF役職テーブル（連））を読み込み、IDカード役職マスタワークテーブルに反映するクラス
 */
public class BzIdCardYakusyokuTorikomiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private ZdbDomManager zdbDomManager;

    @Inject
    private BzIdCardYakusyokuTorikomiDao bzIdCardYakusyokuTorikomiDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        Long idCardYakusyokuRnCount = zdbDomManager.getIdCardYakusyokuRnCount();

        if (idCardYakusyokuRnCount == 0) {

            throw new BizAppException(MessageId.EBF1001, "IDカードF役職テーブル（連）");
        }

        deleteIdCardYakusyokuWkData();

        BzRenkeiHenkanUtil<BW_IdCardYakusyokuWk, BW_IdCardYakusyokuWk> bzRenkeiHenkanUtil = new BzRenkeiHenkanUtil<>();

        bzRenkeiHenkanUtil.initialize(BW_IdCardYakusyokuWk.class, C_SystemRenkeiSyoriHousikiKbn.KYOUYUU_DISC,
            C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY);

        idCardYakusyokuRnCount = registIdCardYakusyokuWkData(bzRenkeiHenkanUtil);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(idCardYakusyokuRnCount)));

    }

    private void deleteIdCardYakusyokuWkData() {

        bzIdCardYakusyokuTorikomiDao.deleteIdCardYakusyokuWk();

    }

    @Transactional
    Long registIdCardYakusyokuWkData(BzRenkeiHenkanUtil<BW_IdCardYakusyokuWk,
        BW_IdCardYakusyokuWk> pBzRenkeiHenkanUtil) {

        Long syoriCount = 0L;

        try (ExDBResults<ZT_IdCardYakusyokuRn> exDBResults = zdbDomManager.getAllIdCardYakusyokuRn();
            EntityInserter<BW_IdCardYakusyokuWk> entityInserter = new EntityInserter<>()) {

            BW_IdCardYakusyokuWk bwIdCardYakusyokuWk = null;
            for (ZT_IdCardYakusyokuRn ztIdCardYakusyokuRn : exDBResults) {

                bwIdCardYakusyokuWk = createIdCardYakusyokuWkData(ztIdCardYakusyokuRn);

                bwIdCardYakusyokuWk = pBzRenkeiHenkanUtil.convDouituBean(bwIdCardYakusyokuWk);

                BizPropertyInitializer.initialize(bwIdCardYakusyokuWk);

                entityInserter.add(bwIdCardYakusyokuWk);

                syoriCount++;

            }
        }

        return syoriCount;
    }

    private BW_IdCardYakusyokuWk createIdCardYakusyokuWkData(ZT_IdCardYakusyokuRn pZtIdCardYakusyokuRn) {

        BW_IdCardYakusyokuWk bwIdCardYakusyokuWK = new BW_IdCardYakusyokuWk();

        BzRenkeiHenkanUtil<?, ?> bzRenkeiHenkanUtil =
            SWAKInjector.getInstance(BzRenkeiHenkanUtil.class);

        bwIdCardYakusyokuWK.setIdkbn(pZtIdCardYakusyokuRn.getZrnidkbn());
        bwIdCardYakusyokuWK.setIdcd(pZtIdCardYakusyokuRn.getZrnidcd());
        bzRenkeiHenkanUtil.convYmdZeroToNull(pZtIdCardYakusyokuRn.getZrnyakusyokuhatureiymd());
        bwIdCardYakusyokuWK.setYakusyokuhatureiymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
        bwIdCardYakusyokuWK.setYakusyokuhatureino(pZtIdCardYakusyokuRn.getZrnyakusyokuhatureino());
        bwIdCardYakusyokuWK.setYakusyokuhatureisosikicd(pZtIdCardYakusyokuRn.getZrnyakusyokuhatureisosikicd());
        bwIdCardYakusyokuWK.setYakusyokucd(pZtIdCardYakusyokuRn.getZrnyakusyokucd());

        return bwIdCardYakusyokuWK;
    }

}
