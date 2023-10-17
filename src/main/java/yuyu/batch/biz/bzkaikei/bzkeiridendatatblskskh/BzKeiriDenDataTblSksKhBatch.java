package yuyu.batch.biz.bzkaikei.bzkeiridendatatblskskh;

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
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;

/**
 * 業務共通 経理･会計 経理伝票データテーブル作成（保全）
 */
public class BzKeiriDenDataTblSksKhBatch implements Batch {

    private static final String TABLE_ID = "IT_KhDenpyoData";

    private static final String FILTER_ID = "Bz105";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private HozenDomManager hozenDomManager;

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

        bzHijynbrSikinIdouDataTysyt.getKhDenrenno();

        try (EntityInserter<BT_DenpyoData> denpyoDataInsLst = new EntityInserter<>()) {

            bzKeiriDenDataSksKyoutuu.init(syoriYmd, baseUserInfo);

            try (ExDBUpdatableResults<IT_KhDenpyoData> khDenpyoDataLst = hozenDomManager.
                getKhDenpyoDatasByKakutyoujobcdSyoriYmd(bzBatchParam.getIbKakutyoujobcd(), syoriYmd)) {
                for (IT_KhDenpyoData khDenpyoData : khDenpyoDataLst) {
                    bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                    bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTER_ID);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khDenpyoData.getDensyskbn().toString());
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khDenpyoData.getDenrenno());

                    BT_DenpyoData btDenpyoData = bzKeiriDenDataSksKyoutuu.setKeiriDenpyoData(khDenpyoData);

                    bzHijynbrSikinIdouDataTysyt.keisanHijynbrSikinIdougk(btDenpyoData);

                    if (C_Tuukasyu.USD.eq(btDenpyoData.getTuukasyu()) ||
                        C_Tuukasyu.AUD.eq(btDenpyoData.getTuukasyu()) ||
                        C_Tuukasyu.EUR.eq(btDenpyoData.getTuukasyu())) {

                        bzKeiriDenDataSksKyoutuu.changeGaikaData(btDenpyoData);
                        khDenpyoData.setDenyenkagk(btDenpyoData.getDenyenkagk());
                        khDenpyoData.setDenkawaserate(btDenpyoData.getDenkawaserate());
                    }
                    denpyoDataInsLst.add(btDenpyoData);

                    syoriKensuu++;
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

            IT_KhDenpyoData khDenpyoData = hozenDomManager.getKhDenpyoData(taisyakuInfo.getDenrenNo(), taisyakuInfo.getEdaNo());
            khDenpyoData.setDenyenkagk(taisyakuInfo.getKagk());
            hozenDomManager.update(khDenpyoData);

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