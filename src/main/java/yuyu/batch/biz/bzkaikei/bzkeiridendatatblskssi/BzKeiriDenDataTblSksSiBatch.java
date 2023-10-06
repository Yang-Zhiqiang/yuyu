package yuyu.batch.biz.bzkaikei.bzkeiridendatatblskssi;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.kaikei.BzHijynbrSikinIdouDataTysyt;
import yuyu.common.biz.kaikei.BzKeiriDenDataSksKyoutuu;
import yuyu.common.biz.kaikei.BzTaisyakuFuittiInfoBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.entity.JT_SiDenpyoData;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;

/**
 * 業務共通 経理･会計 経理伝票データテーブル作成処理(保険金)
 */
public class BzKeiriDenDataTblSksSiBatch implements Batch {

    private static final String TABLE_ID = "JT_SiDenpyoData";

    private static final String FILTER_ID = "Bz105";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private BizDomManager bizDomManager;

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
        BzKeiriDenDataSksKyoutuu bzKeiriDenDataSksKyoutuu = SWAKInjector.getInstance(BzKeiriDenDataSksKyoutuu.class);
        BzHijynbrSikinIdouDataTysyt bzHijynbrSikinIdouDataTysyt = SWAKInjector.getInstance(BzHijynbrSikinIdouDataTysyt.class);
        long syoriKensuu = 0;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            syoriYmd.toString()));

        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        bzHijynbrSikinIdouDataTysyt.getSiDenrenno();

        try (EntityInserter<BT_DenpyoData> denpyoDataInsLst = new EntityInserter<>()) {

            bzKeiriDenDataSksKyoutuu.init(syoriYmd, baseUserInfo);

            try (ExDBUpdatableResults<JT_SiDenpyoData> khDenpyoDataLst = siharaiDomManager.
                getSiDenpyoDatasByKakutyoujobcdSyoriYmd(bzBatchParam.getIbKakutyoujobcd(), syoriYmd)) {
                for (JT_SiDenpyoData siDenpyoData : khDenpyoDataLst) {
                    bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                    bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTER_ID);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(siDenpyoData.getDensyskbn().toString());
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(siDenpyoData.getDenrenno());

                    BT_DenpyoData denpyoData = bzKeiriDenDataSksKyoutuu.setKeiriDenpyoData(siDenpyoData);

                    bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(denpyoData);

                    if (C_Tuukasyu.USD.eq(denpyoData.getTuukasyu()) ||
                        C_Tuukasyu.AUD.eq(denpyoData.getTuukasyu()) ||
                        C_Tuukasyu.EUR.eq(denpyoData.getTuukasyu())) {

                        bzKeiriDenDataSksKyoutuu.changeGaikaData(denpyoData);
                        siDenpyoData.setDenyenkagk(denpyoData.getDenyenkagk());
                        siDenpyoData.setDenkawaserate(denpyoData.getDenkawaserate());
                    }
                    denpyoDataInsLst.add(denpyoData);

                    syoriKensuu = syoriKensuu + 1;
                }
                bzRecoveryDatasikibetuBean.initializeBlank();
            }
        }

        List<BzTaisyakuFuittiInfoBean> taisyakuInfoLst = Lists.newArrayList();
        taisyakuInfoLst = bzKeiriDenDataSksKyoutuu.getGaikaTaisyakuFuittiInfo();

        for (BzTaisyakuFuittiInfoBean taisyakuInfo: taisyakuInfoLst) {

            BT_DenpyoData btDenpyoData = bizDomManager.getDenpyoData(taisyakuInfo.getDensysKbn(), taisyakuInfo.getDenrenNo(), taisyakuInfo.getEdaNo());
            btDenpyoData.setDenyenkagk(taisyakuInfo.getKagk());
            bizDomManager.update(btDenpyoData);

            JT_SiDenpyoData siDenpyoData = siharaiDomManager.getSiDenpyoData(taisyakuInfo.getDenrenNo(), taisyakuInfo.getEdaNo());
            siDenpyoData.setDenyenkagk(taisyakuInfo.getKagk());
            siharaiDomManager.update(siDenpyoData);

        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}