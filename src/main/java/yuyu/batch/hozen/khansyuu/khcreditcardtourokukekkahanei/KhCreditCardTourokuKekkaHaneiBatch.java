package yuyu.batch.hozen.khansyuu.khcreditcardtourokukekkahanei;

import java.util.ArrayList;
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
import yuyu.batch.hozen.khansyuu.khcreditcardtourokukekkahanei.dba.AuthoriKekkaTrBean;
import yuyu.batch.hozen.khansyuu.khcreditcardtourokukekkahanei.dba.KhCreditCardTourokuKekkaHaneiDao;
import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.hozen.khcommon.EditJimuRenrakusyuunou;
import yuyu.common.hozen.khcommon.EditJimuRenrakusyuunouParam;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_HrhnCreditCardTouroku;
import yuyu.def.db.entity.IT_KhTRAuthoriKekkaHihoji;
import yuyu.def.hozen.bean.report.KhCreditTourokuKensuuListBean;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 案内収納 クレジットカード情報登録結果反映
 */
public class KhCreditCardTourokuKekkaHaneiBatch implements Batch {

    private static final String TABLEID = IT_KhTRAuthoriKekkaHihoji.TABLE_NAME;

    private static final String FILTERID = "Kh004";

    private static final String SAKUSEISOSIKICD = "5510000";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhCreditCardTourokuKekkaHaneiDao khCreditCardTourokuKekkaHaneiDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        String kakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyoujobCd));

        Integer syoriKensuu = 0;
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String kinouID = khozenCommonParam.getFunctionId();
        String userID = khozenCommonParam.getUserID();
        String sysDateTime = BizDate.getSysDateTimeMilli();
        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);
        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);
        KhCreditTourokuKensuuListBean khCreditTourokuKensuuListBean = SWAKInjector
            .getInstance(KhCreditTourokuKensuuListBean.class);
        EditJimuRenrakusyuunou editJimuRenrakusyuunou = SWAKInjector
            .getInstance(EditJimuRenrakusyuunou.class);

        try (ExDBResults<AuthoriKekkaTrBean> authoriKekkaTrBeanList =
            khCreditCardTourokuKekkaHaneiDao.getAuthoriKekkaTrBeans(kakutyoujobCd);
            EntityUpdater<IT_HrhnCreditCardTouroku> entityUpdater = new EntityUpdater<IT_HrhnCreditCardTouroku>();
            EntityDeleter<IT_KhTRAuthoriKekkaHihoji> entityDeleter = new EntityDeleter<IT_KhTRAuthoriKekkaHihoji>();) {

            for (AuthoriKekkaTrBean authoriKekkaTrBean : authoriKekkaTrBeanList) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(authoriKekkaTrBean.getCreditkessaiyouno());

                IT_HrhnCreditCardTouroku hrhnCreditCardTouroku = hozenDomManager
                    .getHrhnCreditCardTouroku(authoriKekkaTrBean.getCreditkessaiyouno());

                if (hrhnCreditCardTouroku != null) {

                    hrhnCreditCardTouroku.setAuthorijkkbn(authoriKekkaTrBean.getAuthorijkkbn());
                    hrhnCreditCardTouroku.setCardbrandkbn(authoriKekkaTrBean.getCardbrandkbn());
                    hrhnCreditCardTouroku.setCreditkaiinnosimo4keta(authoriKekkaTrBean.getCreditkaiinnosimo4keta());
                    hrhnCreditCardTouroku.setGyoumuKousinKinou(kinouID);
                    hrhnCreditCardTouroku.setGyoumuKousinsyaId(userID);
                    hrhnCreditCardTouroku.setGyoumuKousinTime(sysDateTime);
                }
                else {

                    List<String> jimuRenrakuHyouMsgList = new ArrayList<String>();
                    EditJimuRenrakusyuunouParam editJimuRenrakusyuunouParam = SWAKInjector
                        .getInstance(EditJimuRenrakusyuunouParam.class);

                    BizDate syoriDate = BizDate.valueOf(authoriKekkaTrBean.getDatajyusinymd().substring(0, 8));

                    jimuRenrakuHyouMsgList.add("契約ＭＦなし");
                    jimuRenrakuHyouMsgList.add("");
                    jimuRenrakuHyouMsgList.add("決済用番号：" + authoriKekkaTrBean.getCreditkessaiyouno());
                    jimuRenrakuHyouMsgList.add("処理日　　：" + DefaultDateFormatter.formatYMDKanji(syoriDate));

                    editJimuRenrakusyuunouParam.setJimurenrakuMsgList(jimuRenrakuHyouMsgList);

                    ReportServicesBean reportServicesBean = editJimuRenrakusyuunou.exec(
                        khozenCommonParam,
                        authoriKekkaTrBean.getSyono(),
                        C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU,
                        editJimuRenrakusyuunouParam,
                        syoriYmd);

                    createReport.execNoCommit(reportServicesBean);
                }

                syoriKensuu++;

                if (hrhnCreditCardTouroku != null) {
                    entityUpdater.add(hrhnCreditCardTouroku);
                }

                IT_KhTRAuthoriKekkaHihoji khTRAuthoriKekkaHihoji = hozenDomManager.getKhTRAuthoriKekkaHihoji(
                    authoriKekkaTrBean.getCreditkessaiyouno(), authoriKekkaTrBean.getSyoriymd());

                entityDeleter.add(khTRAuthoriKekkaHihoji);
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        if (syoriKensuu > 0) {
            String crdtTrkCntLstSksSskNm = "";

            BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(SAKUSEISOSIKICD);

            if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {
                crdtTrkCntLstSksSskNm = bzGetSosikiDataBean.getKanjisosikinm20();
            }

            khCreditTourokuKensuuListBean.setIrAtesakisosiki(crdtTrkCntLstSksSskNm);
            khCreditTourokuKensuuListBean.setIrSakuseiymd(String.valueOf(syoriYmd));
            khCreditTourokuKensuuListBean.setIrCredittourokukensuubpo(syoriKensuu);

            ReportServicesBean creditReportServicesBean = createReport.createNewReportServiceBean(kinou.getSubSystemId(),
                kinou.getCategoryId(), kinou.getKinouId(), C_SyoruiCdKbn.AS_CREDITTOUROKUKENSUULIST);

            creditReportServicesBean.addParamObjects(khCreditTourokuKensuuListBean);
            creditReportServicesBean.setSyoriYmd(syoriYmd);

            createReport.execNoCommit(creditReportServicesBean);
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, syoriKensuu.toString()));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
