package yuyu.batch.hozen.khinterf.khkzhurisyuunoukekkafiletrkm;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khkzhurisyuunoukekkafiletrkm.dba.KhKzhuriSyuunouKekkaFileTrkmDao;
import yuyu.batch.hozen.khinterf.khkzhurisyuunoukekkafiletrkm.dba.KzhuriSyuunouKekkaDataBean;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_KhSyuunouKekkaData;
import yuyu.def.db.entity.ZT_KzhuriSyuunouKekkaTr;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 口座振替収納結果Ｆ取込
 */
public class KhKzhuriSyuunouKekkaFileTrkmBatch implements Batch {

    private static final String TABLEID = ZT_KzhuriSyuunouKekkaTr.TABLE_NAME;

    private static final String FILTERID = "Bz004";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhKzhuriSyuunouKekkaFileTrkmDao khKzhuriSyuunouKekkaFileTorikomiDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        long syoriKensuu = 0;
        String kakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();
        String kinouID = khozenCommonParam.getFunctionId();
        String kosID = khozenCommonParam.getUserID();
        String kosTime = BizDate.getSysDateTimeMilli();
        BizDate syoriYMD = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(syoriYMD)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW1018), kakutyoujobCd));

        khKzhuriSyuunouKekkaFileTorikomiDao.deleteKhSyuunouKekkaData();

        try (ExDBResults<KzhuriSyuunouKekkaDataBean> kzhuriSyuunouKekkaDataBeanLst = khKzhuriSyuunouKekkaFileTorikomiDao
            .getKzhuriSyuunouKekkaDataBeans(kakutyoujobCd);

            EntityInserter<IT_KhSyuunouKekkaData> khSyuunouKekkaDataInserter = new EntityInserter<IT_KhSyuunouKekkaData>();) {

            for (KzhuriSyuunouKekkaDataBean kzhuriSyuunouKekkaDataBean : kzhuriSyuunouKekkaDataBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(kzhuriSyuunouKekkaDataBean.getZtrsyono());

                IT_KhSyuunouKekkaData khSyuunouKekkaData = new IT_KhSyuunouKekkaData(C_AnsyuusysKbn.HOZEN,syoriYMD,kzhuriSyuunouKekkaDataBean.getZtrsyono(),BizDateYM.valueOf(kzhuriSyuunouKekkaDataBean.getZtrjyuutouym()));

                C_HurihunoKbn hurihunoKbn = C_HurihunoKbn.valueOf(kzhuriSyuunouKekkaDataBean.getZtrhurikaekekkakbn());

                BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);

                String nyknaiyouKbn = bzKbnHenkanUtil.convKbn(kzhuriSyuunouKekkaDataBean.getZtrnyknaiyoukbn(),
                    C_NyknaiyouKbn.class, C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY).getKbnData();

                String hrkkaisuu = bzKbnHenkanUtil.convKbn(kzhuriSyuunouKekkaDataBean.getZtrhrkkaisuukbn(),
                    C_Hrkkaisuu.class, C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY).getKbnData();

                C_Syuudaikocd syuudaikoCd = C_Syuudaikocd.BLNK;

                if ("1".equals(kzhuriSyuunouKekkaDataBean.getZtrkzhurisyuudaikokbn())) {

                    syuudaikoCd = C_Syuudaikocd.CSS;
                }
                else {

                    syuudaikoCd = C_Syuudaikocd.SIS;
                }

                khSyuunouKekkaData.setBankcd(kzhuriSyuunouKekkaDataBean.getZtrkzhurikaebankcd());
                khSyuunouKekkaData.setSitencd(kzhuriSyuunouKekkaDataBean.getZtrkzhurikaesitencd());
                khSyuunouKekkaData.setYokinkbn(C_YokinKbn.valueOf(kzhuriSyuunouKekkaDataBean.getZtrkzhurikaeyokinkbn()));
                khSyuunouKekkaData.setKouzano(kzhuriSyuunouKekkaDataBean.getZtrkzhurikaekouzano());
                khSyuunouKekkaData.setHurikaeymd(BizDate.valueOf(kzhuriSyuunouKekkaDataBean.getZtrhurikaeymd()));
                khSyuunouKekkaData.setRsgaku(BizCurrency.valueOf(kzhuriSyuunouKekkaDataBean.getZtrrsgaku()));
                khSyuunouKekkaData.setJyutoukaisuuy(Integer.valueOf(kzhuriSyuunouKekkaDataBean.getZtrjyuutounensuu()));
                khSyuunouKekkaData.setJyutoukaisuum(Integer.valueOf(kzhuriSyuunouKekkaDataBean.getZtrjyuutoutukisuu()));
                khSyuunouKekkaData.setDantaikobetukbn(kzhuriSyuunouKekkaDataBean.getZtrdantaikobetukbn());
                khSyuunouKekkaData.setNyknaiyoukbn(C_NyknaiyouKbn.valueOf(nyknaiyouKbn));
                khSyuunouKekkaData.setHrkkaisuu(C_Hrkkaisuu.valueOf(hrkkaisuu));
                khSyuunouKekkaData.setKzhurikaetkbtannaihyj(kzhuriSyuunouKekkaDataBean.getZtrkzhurikaetkbtannaihyj());
                khSyuunouKekkaData.setHurihunokbn(hurihunoKbn);
                khSyuunouKekkaData.setGyoumuKousinKinou(kinouID);
                khSyuunouKekkaData.setGyoumuKousinsyaId(kosID);
                khSyuunouKekkaData.setGyoumuKousinTime(kosTime);
                khSyuunouKekkaData.setSyuudaikocd(syuudaikoCd);

                BizPropertyInitializer.initialize(khSyuunouKekkaData);

                khKzhuriSyuunouKekkaFileTorikomiDao.addInsertEntity(khSyuunouKekkaDataInserter, khSyuunouKekkaData);

                syoriKensuu = syoriKensuu + 1;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
