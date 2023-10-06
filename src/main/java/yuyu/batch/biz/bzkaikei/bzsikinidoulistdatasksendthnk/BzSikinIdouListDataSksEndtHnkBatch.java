package yuyu.batch.biz.bzkaikei.bzsikinidoulistdatasksendthnk;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import yuyu.batch.biz.bzkaikei.bzsikinidoulistdatasksendthnk.dba.BzSikinIdouListDataSksEndtHnkDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KeiriyendthnkKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.db.entity.BM_SikinIdouGroup;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_YendthnkSikinIdouData;
import yuyu.def.db.entity.BT_YendthnkSikinIdouListSks;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 経理･会計 資金移動リストデータ作成（円建変更）バッチクラスです。
 */
public class BzSikinIdouListDataSksEndtHnkBatch implements Batch {

    private static final String TABLE_ID = BT_YendthnkSikinIdouData.TABLE_NAME;

    private static final String FILTER_ID = "Bz109";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private BzSikinIdouListDataSksEndtHnkDao bzSikinIdouListDataSksEndtHnkDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();
        long syoriKensuu = 0;

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));

        try (
            ExDBResults<BT_YendthnkSikinIdouData> yendthnkSikinIdouDataList = bzSikinIdouListDataSksEndtHnkDao.
            getYendthnkSikinIdouDataByKakutyoujobcdSyoriYmd(kakutyouJobCd, syoriYmd);

            EntityInserter<BT_YendthnkSikinIdouListSks> yendthnkSikinIdouListSksInsList = new EntityInserter<>()) {

            for (BT_YendthnkSikinIdouData yendthnkSikinIdouData : yendthnkSikinIdouDataList) {
                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(yendthnkSikinIdouData.getSyono());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(yendthnkSikinIdouData.getKeiriyendthnkkbn().getValue());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey3(yendthnkSikinIdouData.getSyoriYmd().toString());

                String syouhnCd;
                Integer syouhnsdNo;
                C_Tuukasyu siteiTuuka;
                BizCurrency siteiTuukaGk;
                C_Tuukasyu trhkTuuka;
                BizCurrency trhkTuukaGk;
                C_SikinidougroupKbn sikinidougroupKbn;

                if (C_KeiriyendthnkKbn.TORIKESI.eq(yendthnkSikinIdouData.getKeiriyendthnkkbn())) {
                    List<BT_YendthnkSikinIdouData> yendthnkSikinIdouDataHosokuList = bzSikinIdouListDataSksEndtHnkDao.
                        getYendthnkSikinIdouDataBySyonoSyoriYmd(yendthnkSikinIdouData.getSyono(), syoriYmd);

                    syouhnCd = yendthnkSikinIdouDataHosokuList.get(0).getSyouhncd();
                    syouhnsdNo = yendthnkSikinIdouDataHosokuList.get(0).getSyouhnsdno();
                    siteiTuuka = yendthnkSikinIdouDataHosokuList.get(0).getSiteituuka();
                    siteiTuukaGk = yendthnkSikinIdouDataHosokuList.get(0).getSiteituukagk();
                    trhkTuuka = yendthnkSikinIdouDataHosokuList.get(0).getTrhktuuka();
                    trhkTuukaGk = yendthnkSikinIdouDataHosokuList.get(0).getTrhktuukagk();
                }
                else {
                    syouhnCd = yendthnkSikinIdouData.getSyouhncd();
                    syouhnsdNo = yendthnkSikinIdouData.getSyouhnsdno();
                    siteiTuuka = yendthnkSikinIdouData.getSiteituuka();
                    siteiTuukaGk = yendthnkSikinIdouData.getSiteituukagk();
                    trhkTuuka = yendthnkSikinIdouData.getTrhktuuka();
                    trhkTuukaGk = yendthnkSikinIdouData.getTrhktuukagk();
                }

                BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
                SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(syouhnCd, siteiTuuka);

               if (syouhinbetuSegmentBean.getErrorKbn().eq(C_ErrorKbn.ERROR)) {
                  throw new BizAppException(MessageUtil.getMessage(MessageId.EBA0048));
                }

                C_Segcd kbnKeiriSegcd = syouhinbetuSegmentBean.getSegcd1();

                BM_SikinIdouGroup sikinIdouGroup = bizDomManager.getSikinIdouGroup(kbnKeiriSegcd);

                if (sikinIdouGroup == null) {
                    sikinidougroupKbn = C_SikinidougroupKbn.BLNK;
                }
                else {
                    sikinidougroupKbn = sikinIdouGroup.getSikinidougroupkbn();
                }

                BT_YendthnkSikinIdouListSks yendthnkSikinIdouListSks = new BT_YendthnkSikinIdouListSks();

                yendthnkSikinIdouListSks.setSyono(yendthnkSikinIdouData.getSyono());
                yendthnkSikinIdouListSks.setKeiriyendthnkkbn(yendthnkSikinIdouData.getKeiriyendthnkkbn());
                yendthnkSikinIdouListSks.setSyoriYmd(syoriYmd);
                yendthnkSikinIdouListSks.setSiteituuka(siteiTuuka);
                yendthnkSikinIdouListSks.setSiteituukagk(siteiTuukaGk);
                yendthnkSikinIdouListSks.setTrhktuuka(trhkTuuka);
                yendthnkSikinIdouListSks.setTrhktuukagk(trhkTuukaGk);
                yendthnkSikinIdouListSks.setKbnkeirisegcd(kbnKeiriSegcd);
                yendthnkSikinIdouListSks.setSikinidougroupkbn(sikinidougroupKbn);

                BizPropertyInitializer.initialize(yendthnkSikinIdouListSks);

                yendthnkSikinIdouListSksInsList.add(yendthnkSikinIdouListSks);

                syoriKensuu++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {
        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }
}