package yuyu.batch.hozen.khinterf.khuriageseikyuukekkafiletrkm;

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
import yuyu.batch.hozen.khinterf.khuriageseikyuukekkafiletrkm.dba.KhUriageKekkaDataBean;
import yuyu.batch.hozen.khinterf.khuriageseikyuukekkafiletrkm.dba.KhUriageSeikyuuKekkaFileTrkmDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_AuthoriKbn;
import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.db.entity.IT_KhUriageSeikyuuKekkaData;
import yuyu.def.db.mapping.GenZT_UriageKekkaTr;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 売上請求結果F取込のバッチクラスです。
 */
public class KhUriageSeikyuuKekkaFileTrkmBatch implements Batch {

    private static final String TABLEID = GenZT_UriageKekkaTr.TABLE_NAME;

    private static final String FILTERID = "Bz004";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhUriageSeikyuuKekkaFileTrkmDao khUriageSeikyuuKekkaFileTrkmDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoribiYmd = bzBatchParam.getSyoriYmd();
        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoribiYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyouJobCd));

        Long count = 0L;
        String syoNo = "";
        String creditcardKessaiyouNo = "";
        String uriagenengappi = "";
        int renno = 0;
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String functionId = khozenCommonParam.getFunctionId();
        String sousasyaCd = khozenCommonParam.getUserID();
        String systemYmdTime = BizDate.getSysDateTimeMilli();
        BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);

        khUriageSeikyuuKekkaFileTrkmDao.deleteKhUriageSeikyuuKekkaData();

        try (ExDBResults<KhUriageKekkaDataBean> khUriageSeikyuuKekkaFileTrkmBeanList =
            khUriageSeikyuuKekkaFileTrkmDao.getKhUriageKekkaDataBeans(kakutyouJobCd);
            EntityInserter<IT_KhUriageSeikyuuKekkaData> entityInserter = new EntityInserter<>();) {

            for (KhUriageKekkaDataBean khUriageKekkaDataBean :
                khUriageSeikyuuKekkaFileTrkmBeanList) {
                String authorikbn = "";
                String creditUriageNgjiyuu = "";
                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khUriageKekkaDataBean.getZtrsyono());

                KbnInfoBean authorikbnkbnInfoBean = bzKbnHenkanUtil.convKbn(
                    khUriageKekkaDataBean.getZtrauthorikbn(),
                    C_AuthoriKbn.class,
                    C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY);

                authorikbn = authorikbnkbnInfoBean.getKbnData();

                KbnInfoBean creditUriageNgjiyuukbnInfoBean = bzKbnHenkanUtil.convKbn(
                    khUriageKekkaDataBean.getZtrhurikaekekkacd(),
                    C_CreditUriageNgJiyuuKbn.class,
                    C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY);

                creditUriageNgjiyuu = creditUriageNgjiyuukbnInfoBean.getKbnData();

                if (syoNo.equals(khUriageKekkaDataBean.getZtrsyono())
                    && creditcardKessaiyouNo.equals(khUriageKekkaDataBean.getZtrcreditkessaiyouno())
                    && uriagenengappi.equals(khUriageKekkaDataBean.getZtruriageymd6keta().toString())) {
                    renno ++;
                }
                else {
                    renno = 1;
                }

                IT_KhUriageSeikyuuKekkaData khUriageSeikyuuKekkaData = new IT_KhUriageSeikyuuKekkaData(
                    khUriageKekkaDataBean.getZtrsyono(),
                    khUriageKekkaDataBean.getZtrcreditkessaiyouno(),
                    BizDate.valueOf("20" + khUriageKekkaDataBean.getZtruriageymd6keta()),
                    renno);

                khUriageSeikyuuKekkaData.setRecordno(khUriageKekkaDataBean.getZtrrecordno());
                khUriageSeikyuuKekkaData.setSyoriYmd(syoribiYmd);
                khUriageSeikyuuKekkaData.setAuthorikbn(C_AuthoriKbn.valueOf(authorikbn));
                if (khUriageKekkaDataBean.getZtruriageseikyuutorihikicd() != null) {
                    khUriageSeikyuuKekkaData.setUriageseikyuutorihikicd(String.valueOf(
                        khUriageKekkaDataBean.getZtruriageseikyuutorihikicd()));
                }
                if (!BizUtil.isBlank(khUriageKekkaDataBean.getZtruriagetaisyouym())) {
                    khUriageSeikyuuKekkaData.setJyuutouym(BizDateYM.valueOf(
                        khUriageKekkaDataBean.getZtruriagetaisyouym()));
                }
                khUriageSeikyuuKekkaData.setCredityuukoukigen(khUriageKekkaDataBean.getZtrcardyuukoukigen());
                khUriageSeikyuuKekkaData.setCredituriagegk(
                    BizCurrency.valueOf(khUriageKekkaDataBean.getZtrseikyuukngk()));
                khUriageSeikyuuKekkaData.setCreditkaiinnokami6keta(
                    khUriageKekkaDataBean.getZtrcreditkaiinnokami6keta());
                khUriageSeikyuuKekkaData.setCreditkaiinnosimo4keta(
                    khUriageKekkaDataBean.getZtrcreditkaiinnosimo4keta());
                khUriageSeikyuuKekkaData.setUriageseikyuuerrorcd(khUriageKekkaDataBean.getZtruriageseikyuuerrorcd());
                khUriageSeikyuuKekkaData.setCredituriagengjiyuu(
                    C_CreditUriageNgJiyuuKbn.valueOf(creditUriageNgjiyuu));
                khUriageSeikyuuKekkaData.setFukusuukameitennokey(
                    khUriageKekkaDataBean.getZtrfukusuukameitennokey());
                khUriageSeikyuuKekkaData.setGyoumuKousinKinou(functionId);
                khUriageSeikyuuKekkaData.setGyoumuKousinsyaId(sousasyaCd);
                khUriageSeikyuuKekkaData.setGyoumuKousinTime(systemYmdTime);

                BizPropertyInitializer.initialize(khUriageSeikyuuKekkaData);

                entityInserter.add(khUriageSeikyuuKekkaData);

                syoNo = khUriageKekkaDataBean.getZtrsyono();
                creditcardKessaiyouNo = khUriageKekkaDataBean.getZtrcreditkessaiyouno();
                uriagenengappi = khUriageKekkaDataBean.getZtruriageymd6keta().toString();
                count = count + 1;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(count)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

}
