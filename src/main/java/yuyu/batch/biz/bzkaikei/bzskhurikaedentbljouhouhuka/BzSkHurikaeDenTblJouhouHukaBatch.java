package yuyu.batch.biz.bzkaikei.bzskhurikaedentbljouhouhuka;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.db.entity.BT_SinkeiyakuHurikaeDen;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 新契約振替伝票テーブル情報付加処理
 */
public class BzSkHurikaeDenTblJouhouHukaBatch implements Batch {

    private static final String TABLEID = "BT_SinkeiyakuHurikaeDen";

    private static final String FILTERID = "Bz105";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BzSkHurikaeDenTblJouhouHukaDao bzSkHurikaeDenTblJouhouHukaDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        try (ExDBUpdatableResults<BT_SinkeiyakuHurikaeDen> huriDenpyouLst =
            bzSkHurikaeDenTblJouhouHukaDao.getSinkeiyakuHurikaeDensByKakutyoujobcdSyoriYmd(bzBatchParam.getSyoriYmd(), bzBatchParam.getIbKakutyoujobcd())) {

            int torihikiIndex = 0;

            String torihikiMoji = "";

            BT_SinkeiyakuHurikaeDen maesyoriHuriDenpyou = null;

            String syoriMd = String.valueOf(bzBatchParam.getSyoriYmd().getBizDateMD());

            long syoriKensuu = 0;

            String torihikiBanngo = "";

            for (BT_SinkeiyakuHurikaeDen hurikaeDen: huriDenpyouLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(hurikaeDen.getDensyskbn().getValue());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(hurikaeDen.getDenrenno());

                boolean torihikiKasannKeka = isKasannTorihikino(maesyoriHuriDenpyou, hurikaeDen);

                if (torihikiKasannKeka) {
                    torihikiIndex++;
                    torihikiMoji = Strings.padStart(String.valueOf(torihikiIndex), 3, '0');
                    torihikiBanngo = syoriMd.concat(torihikiMoji);
                }

                hurikaeDen.setTorihikino(torihikiBanngo);
                hurikaeDen.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                hurikaeDen.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
                maesyoriHuriDenpyou = hurikaeDen;
                syoriKensuu++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
        }
    }

    public boolean isKasannTorihikino(BT_SinkeiyakuHurikaeDen prevHurikaeDen, BT_SinkeiyakuHurikaeDen currentHurikaeDen) {

        if (prevHurikaeDen == null || currentHurikaeDen == null) {
            return true;
        }

        boolean torihikiKeka;

        if (BizDateUtil.compareYmd(prevHurikaeDen.getDenymd(), currentHurikaeDen.getDenymd()) == BizDateUtil.COMPARE_EQUAL &&
            prevHurikaeDen.getHuridenatesakicd().equals(currentHurikaeDen.getHuridenatesakicd()) &&
            prevHurikaeDen.getHuridenpyoukyktuukakbn().eq(currentHurikaeDen.getHuridenpyoukyktuukakbn()) &&
            prevHurikaeDen.getTuukasyu().eq(currentHurikaeDen.getTuukasyu()) &&
            prevHurikaeDen.getDengyoumucd().equals(currentHurikaeDen.getDengyoumucd())) {
            torihikiKeka = false;
        }
        else {
            torihikiKeka = true;
        }
        return torihikiKeka;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
