package yuyu.batch.hozen.khansyuu.khdattaimikaisyoulistsks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khdattaimikaisyoulistsks.dba.KhDattaiMikaishoBean;
import yuyu.batch.hozen.khansyuu.khdattaimikaisyoulistsks.dba.KhDattaiMikaisyouListSksDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.BzHanteiSosikiUtil;
import yuyu.def.MessageId;
import yuyu.def.base.detacher.AM_UserDetacher;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_DattaiUktk;
import yuyu.def.hozen.bean.report.KhDattaiMikaisyouListBean;
import yuyu.def.hozen.bean.report.KhDattaiMikaisyouListDataSourceBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 案内収納 脱退未解消リスト作成
 */
public class KhDattaiMikaisyouListSksBatch implements Batch {

    private static final String TABLEID = IT_DattaiUktk.TABLE_NAME;

    private static final String FILTERID = "Kh001";

    private static final String ATESAKI_SOSIKICD1 = C_Tantositucd.SYUUNOUSV.getValue() + "0000";

    private static final String SAKUSEI_SOSIKICD = C_Tantositucd.SYUUNOUSV.getValue() + "0000";

    private static final String BATCHUSERNAME = "BatchSystem";

    private static final String TYOUKIMISYORIHYOUJI = "*";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private KhDattaiMikaisyouListSksDao khDattaiMikaisyouListSksDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

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
        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();
        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);
        int syoriKensu = 0;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            kakutyouJobCd));

        List<IReportDataSouceBean> dattaiMikaisyouListDsBeanLst = new ArrayList<>();
        KhDattaiMikaisyouListDataSourceBean dattaiMikaisyouListDsBean = null;

        try (ExDBResults<KhDattaiMikaishoBean> khDattaiMikaishoBeanLst =
            khDattaiMikaisyouListSksDao.getDattaiMikaishoBeans(kakutyouJobCd, syoriYmd.addDays(-14));) {

            for (KhDattaiMikaishoBean khDattaiMikaishoBean : khDattaiMikaishoBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khDattaiMikaishoBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khDattaiMikaishoBean.getSyono());

                String tyoukiMisyoriHyouji;
                String dattaiInputSosikiNm;
                String tntNm;

                if (BizDateUtil.compareYmd(khDattaiMikaishoBean.getSyoriYmd(), syoriYmd.addMonths(-1)) == BizDateUtil.COMPARE_LESSER
                    || BizDateUtil.compareYmd(khDattaiMikaishoBean.getSyoriYmd(), syoriYmd.addMonths(-1)) == BizDateUtil.COMPARE_EQUAL) {

                    tyoukiMisyoriHyouji = TYOUKIMISYORIHYOUJI;
                }
                else {

                    tyoukiMisyoriHyouji = "";
                }

                BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(khDattaiMikaishoBean.getSyorisosikicd());

                if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {

                    dattaiInputSosikiNm = bzGetSosikiDataBean.getKanjisosikinm20();
                }
                else {

                    dattaiInputSosikiNm = "";
                }

                if (BATCHUSERNAME.equals(khDattaiMikaishoBean.getGyoumuKousinsyaId())) {

                    tntNm = "";
                }
                else {
                    AM_User aMUser = baseDomManager.getUser(khDattaiMikaishoBean.getGyoumuKousinsyaId());

                    if (aMUser != null) {

                        aMUser = AM_UserDetacher.detachUsertouched(aMUser);

                        tntNm = aMUser.getUserNm();
                    }
                    else {

                        tntNm = "";
                    }
                }

                boolean result = BzHanteiSosikiUtil.isCallcenterKeySosikicd(khDattaiMikaishoBean.getSyorisosikicd());

                String atesakiSosikiNm = "";

                if (result) {

                    bzGetSosikiDataBean = bzGetSosikiData.exec(ATESAKI_SOSIKICD1);

                    if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {

                        atesakiSosikiNm = bzGetSosikiDataBean.getKanjisosikinm20();
                    }
                }
                else {

                    atesakiSosikiNm = dattaiInputSosikiNm;
                }

                dattaiMikaisyouListDsBean = SWAKInjector.getInstance(KhDattaiMikaisyouListDataSourceBean.class);

                dattaiMikaisyouListDsBean.setIrAtesakisosiki(atesakiSosikiNm);
                dattaiMikaisyouListDsBean.setIrTyoukimisyorihyouji(tyoukiMisyoriHyouji);
                dattaiMikaisyouListDsBean.setIrSyono(khDattaiMikaishoBean.getSyono());
                dattaiMikaisyouListDsBean.setIrSyoriymdbizdate(khDattaiMikaishoBean.getSyoriYmd());
                dattaiMikaisyouListDsBean.setIrDattaikeiro(khDattaiMikaishoBean.getDattaikeiro());
                dattaiMikaisyouListDsBean.setIrDattaiinputsosiki(dattaiInputSosikiNm);
                dattaiMikaisyouListDsBean.setIrTantnm(tntNm);
                dattaiMikaisyouListDsBean.setIrDattairiyuukbn(khDattaiMikaishoBean.getDattairiyuukbn());
                dattaiMikaisyouListDsBean.setIrComment124keta(khDattaiMikaishoBean.getComment124keta());
                dattaiMikaisyouListDsBean.setIrSyorisosikicd(khDattaiMikaishoBean.getSyorisosikicd());

                dattaiMikaisyouListDsBeanLst.add(dattaiMikaisyouListDsBean);

                syoriKensu = syoriKensu + 1;
            }
        }

        if (syoriKensu > 0) {

            dattaiMikaisyouListOutput(C_SyoruiCdKbn.AS_DATTAI_MIKAISYOULIST,
                syoriYmd,
                syoriKensu,
                SAKUSEI_SOSIKICD,
                dattaiMikaisyouListDsBeanLst);
        }


        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensu)));
    }

    private void dattaiMikaisyouListOutput(C_SyoruiCdKbn pSyoruiCdKbn, BizDate pSyoriYmd, Integer pSyorikensuu,
        String pSakuseiSosikiCd, List<IReportDataSouceBean> pDattaiMikaisyouListDsBeanLst) {

        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

        String sakuseiSosikiNm;

        BzGetSosikiDataBean bzGetSosikiDataBeanSakusei = bzGetSosikiData.exec(pSakuseiSosikiCd);

        if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBeanSakusei.getSosikimasterumukbn())) {

            sakuseiSosikiNm = bzGetSosikiDataBeanSakusei.getKanjisosikinm20();
        }
        else {

            sakuseiSosikiNm = "";
        }

        KhDattaiMikaisyouListBean khDattaiMikaisyouListBean = SWAKInjector.getInstance(KhDattaiMikaisyouListBean.class);

        khDattaiMikaisyouListBean.setIrSyoribi(pSyoriYmd);
        khDattaiMikaisyouListBean.setIrKensuu(pSyorikensuu);
        khDattaiMikaisyouListBean.setIrSakuseisosiki(sakuseiSosikiNm);


        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            pSyoruiCdKbn);

        reportServicesBean.addParamObjects(pDattaiMikaisyouListDsBeanLst, khDattaiMikaisyouListBean, pSyoriYmd);

        createReport.execNoCommit(reportServicesBean);

    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
