package yuyu.batch.hozen.khansyuu.khuriageseikyuudel;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityDeleter;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khuriageseikyuudel.dba.KhUriageSeikyuuDelDao;
import yuyu.batch.hozen.khansyuu.khuriageseikyuudel.dba.UriageSeikyuuDataBean;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_UriageSeikyuuData;
import yuyu.def.db.entity.IT_UriageSkDataSyuKnr;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 案内収納 売上請求データ削除
 */
public class KhUriageSeikyuuDelBatch implements Batch {

    private static final String TABLEID = IT_UriageSkDataSyuKnr.TABLE_NAME;

    private static final String FILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhUriageSeikyuuDelDao khUriageSeikyuuDelDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        long syoriKensuu = 0;
        BizDate syoriYMD = bzBatchParam.getSyoriYmd();
        String kakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(syoriYMD)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW1018), kakutyoujobCd));

        BizDate creditUriageKekkaHaneiYmd = syoriYMD.getPreviousMonth().getRekijyou();

        try (ExDBResults<UriageSeikyuuDataBean> uriageSeikyuuDataBeanList =
            khUriageSeikyuuDelDao.getUriageSeikyuuData(kakutyoujobCd, creditUriageKekkaHaneiYmd);

            EntityUpdater<IT_AnsyuKihon> entityUpdater = new EntityUpdater<IT_AnsyuKihon>();
            EntityDeleter<IT_UriageSkDataSyuKnr> entityDeleter = new EntityDeleter<IT_UriageSkDataSyuKnr>();) {

            for (UriageSeikyuuDataBean uriageSeikyuuDataBean : uriageSeikyuuDataBeanList) {

                IT_AnsyuKihon ansyukihon = null;

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(uriageSeikyuuDataBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(uriageSeikyuuDataBean.getSyono());

                if (uriageSeikyuuDataBean.getUriageseikyuudatasyono() != null) {

                    ansyukihon = hozenDomManager.getAnsyuKihon(uriageSeikyuuDataBean.getUriageseikyuudatasyono());

                    List<IT_UriageSeikyuuData> uriageseikyuudataList = ansyukihon.getUriageSeikyuuDatas();

                    for (int i = uriageseikyuudataList.size() - 1; i >= 0; i--) {
                        if (uriageseikyuudataList.get(i).getCreditkessaiyouno().equals(uriageSeikyuuDataBean.getCreditkessaiyouno()) &&
                            uriageseikyuudataList.get(i).getUriagenengappi().equals(uriageSeikyuuDataBean.getUriagenengappi()) &&
                            uriageseikyuudataList.get(i).getRenno3keta().equals(uriageSeikyuuDataBean.getRenno3keta())) {
                            uriageseikyuudataList.remove(i);
                        }
                    }
                }

                IT_UriageSkDataSyuKnr uriageskdatasyuknr = khUriageSeikyuuDelDao.
                    getUriageSkDataSyuKnr(uriageSeikyuuDataBean.getSyono(), uriageSeikyuuDataBean.getCreditkessaiyouno()
                        , uriageSeikyuuDataBean.getUriagenengappi(), uriageSeikyuuDataBean.getRenno3keta());


                if (ansyukihon!= null) {
                    entityUpdater.add(ansyukihon);
                }

                entityDeleter.add(uriageskdatasyuknr);

                syoriKensuu++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
