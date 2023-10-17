package yuyu.batch.biz.bzmaster.bzsisuutorikomi;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.BzRenkeiHenkanUtil;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.db.entity.BM_Sisuu;
import yuyu.def.db.entity.ZT_SisuuRendouRn;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 連携用DB（指数連動Ｆテーブル（連））を読み込み、指数マスタに反映するクラス
 */
public class BzSisuuTorikomiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private ZdbDomManager zdbDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzSisuuTorikomiDao bzSisuuTorikomiDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    public void execute() {

        Long sisuuRendouRnCount = bzSisuuTorikomiDao.getSisuuRendouRnCount();

        if (sisuuRendouRnCount == 0) {

            throw new BizAppException(MessageId.EBF1001, "指数連動Ｆテーブル（連）");

        }

        Long goukeiSyoriCount = registSisuuData();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(goukeiSyoriCount)));
    }

    @Transactional
    Long registSisuuData() {

        Long syoriCount = 0L;

        try (ExDBResults<ZT_SisuuRendouRn> exDBResults = zdbDomManager.getAllSisuuRendouRn();
            EntityInserter<BM_Sisuu> entityInserter = new EntityInserter<>()) {
            BM_Sisuu bmSisuu = null;
            BzRenkeiHenkanUtil<?, ?> bzRenkeiHenkanUtil =
                SWAKInjector.getInstance(BzRenkeiHenkanUtil.class);
            BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);
            for (ZT_SisuuRendouRn ztSisuuRendouRn : exDBResults) {
                KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(ztSisuuRendouRn.getZrntorikomiyousisuukbn(),
                    C_Sisuukbn.class, C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY);
                C_Sisuukbn sisuuKbn = C_Sisuukbn.valueOf(kbnInfoBean.getKbnData());
                bzRenkeiHenkanUtil.convYmdZeroToNull(ztSisuuRendouRn.getZrnsisuukouhyouymd());
                BizDate sisuukouhyouYmd = bzRenkeiHenkanUtil.getConvYmdBizDate();

                BM_Sisuu sisuuTbl = bizDomManager.getSisuu(sisuuKbn, sisuukouhyouYmd);
                if (sisuuTbl != null) {
                    throw new BizAppException(MessageId.EBF1027, sisuuKbn.getValue(), sisuukouhyouYmd.toString());
                }
                bmSisuu = new BM_Sisuu();
                bmSisuu.setSisuukbn(sisuuKbn);
                bmSisuu.setSisuukouhyouymd(sisuukouhyouYmd);
                bmSisuu.setSisuu(BizNumber.valueOf(ztSisuuRendouRn.getZrntorikomiyousisuu()));
                bzRenkeiHenkanUtil.convYmdZeroToNull(ztSisuuRendouRn.getZrnsisuucalckijyunymd());
                bmSisuu.setSisuucalckijyunymd(bzRenkeiHenkanUtil.getConvYmdBizDate());
                BizPropertyInitializer.initialize(bmSisuu);

                entityInserter.add(bmSisuu);

                syoriCount++;
            }
        }
        return syoriCount;
    }

}
