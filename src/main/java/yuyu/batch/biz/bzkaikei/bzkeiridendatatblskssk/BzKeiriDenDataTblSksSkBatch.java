package yuyu.batch.biz.bzkaikei.bzkeiridendatatblskssk;

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
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;

/**
 * 業務共通 経理･会計 経理伝票データテーブル作成（新契約）
 */
public class BzKeiriDenDataTblSksSkBatch implements Batch {

    private static final String TABLE_ID = "HT_SkDenpyoData";

    private static final String FILTER_ID = "Bz105";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

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

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003), syoriYmd.toString()));

        bzHijynbrSikinIdouDataTysyt.init(syoriYmd);

        bzHijynbrSikinIdouDataTysyt.getSkDenrenno();

        try (EntityInserter<BT_DenpyoData> denpyoDataInsLst = new EntityInserter<>()) {

            bzKeiriDenDataSksKyoutuu.init(syoriYmd, baseUserInfo);

            try (ExDBUpdatableResults<HT_SkDenpyoData> skDenpyoDataLst = sinkeiyakuDomManager.getSkDenpyoDatasByKakutyoujobcdSyoriYmd(bzBatchParam.getIbKakutyoujobcd(), syoriYmd)) {

                for (HT_SkDenpyoData skDenpyoData: skDenpyoDataLst) {

                    bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                    bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTER_ID);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(skDenpyoData.getDensyskbn().toString());
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(skDenpyoData.getDenrenno());

                    BT_DenpyoData denpyoData = bzKeiriDenDataSksKyoutuu.setSkKeiriDenpyoData(skDenpyoData);

                    bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(denpyoData);

                    if (C_Tuukasyu.USD.eq(denpyoData.getTuukasyu()) ||
                        C_Tuukasyu.AUD.eq(denpyoData.getTuukasyu()) ||
                        C_Tuukasyu.EUR.eq(denpyoData.getTuukasyu())) {

                        bzKeiriDenDataSksKyoutuu.changeGaikaData(denpyoData);

                        skDenpyoData.setDenyenkagk(denpyoData.getDenyenkagk());
                        skDenpyoData.setDenkawaserate(denpyoData.getDenkawaserate());
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

            HT_SkDenpyoData skDenpyoData = sinkeiyakuDomManager.getSkDenpyoData(taisyakuInfo.getDenrenNo(), taisyakuInfo.getEdaNo());
            skDenpyoData.setDenyenkagk(taisyakuInfo.getKagk());
            sinkeiyakuDomManager.update(skDenpyoData);

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