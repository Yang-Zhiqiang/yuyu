package yuyu.batch.sinkeiyaku.sknyuukin.skkhrtrkkekkamihaneilistsks;

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
import yuyu.batch.sinkeiyaku.sknyuukin.skkhrtrkkekkamihaneilistsks.dba.SkKhrTrkKekkaMihaneilistSksDao;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_SkKouhuriUkTrkMihanei;
import yuyu.def.sinkeiyaku.bean.report.SkKouhuriUkTrkMihaneilistDataSourceBean;
import yuyu.def.sinkeiyaku.bean.report.SkSyanailistheaderBean;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 新契約 入金 口振受付登録結果未反映リスト作成
 */
public class SkKhrTrkKekkaMihaneilistSksBatch implements Batch {

    private static final String TYSYTTAISYOU_TABLE_ID = HT_SkKouhuriUkTrkMihanei.TABLE_NAME;

    private static final String RECOVERY_FILTER_KBNID = "Bz114";

    private static final String BANKCD_YTGINKOU = "9900";

    private static final String BANKCD_YTGINKOUKZHURISERVICE_KINYUUCDUKE = "9900";

    private static final String BANKCD_YTGINKOUKZHURISERVICE_WEBUKE = "9901";

    private static final String BANKCD_YTGINKOUSKJHURISERVICE = "9902";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SkKhrTrkKekkaMihaneilistSksDao skKhrTrkKekkaMihaneilistSksDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private CreateReport createReport;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BzBatchParam getParam() {
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

        long syoriKensuu = 0;
        String dispAtesaki = "";
        String dispSakuseiymd = "";
        String dispKouzahrketrkymd = "";
        String dispDatajyusinymd = "";
        List<IReportDataSouceBean> khrUktTrkMhneMosnrkmrDataList =  new ArrayList<>();
        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);
        SkSyanailistheaderBean khrUktTrkMhneMosnrkmrHeader =  SWAKInjector.getInstance(SkSyanailistheaderBean.class);

        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(
            YuyuSinkeiyakuConfig.getInstance().getDairitenkyksosikicd(), null);

        if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {

            dispAtesaki = ViewReport.editOntyuu(bzGetSosikiDataBean.getKanjisosikinm20());
        }

        dispSakuseiymd = DateFormatUtil.dateKANJI(syoriYmd);

        khrUktTrkMhneMosnrkmrHeader.setIrAtesakisosiki(dispAtesaki);

        khrUktTrkMhneMosnrkmrHeader.setIrTyouhyousakuseiymd(dispSakuseiymd);

        try (
            ExDBResults<HT_SkKouhuriUkTrkMihanei> skKouhuriUkTrkMihaneiList = skKhrTrkKekkaMihaneilistSksDao.
            getSkKouhuriUkTrkMihaneiByKinyuukkntratkiymdKakutyoujobcd(kakutyoujobCd, syoriYmd.addDays(-90));) {

            for (HT_SkKouhuriUkTrkMihanei skKouhuriUkTrkMihanei : skKouhuriUkTrkMihaneiList) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(skKouhuriUkTrkMihanei.getKouhuriokyakusamano());

                syoriKensuu = syoriKensuu + 1;
                dispKouzahrketrkymd = skKouhuriUkTrkMihanei.getKinyuukkntratkiymd().toString();
                dispDatajyusinymd = skKouhuriUkTrkMihanei.getSyoriYmd().toString();

                SkKouhuriUkTrkMihaneilistDataSourceBean skKouhuriUkTrkMihaneilistDsBean =
                    new SkKouhuriUkTrkMihaneilistDataSourceBean();

                skKouhuriUkTrkMihaneilistDsBean.setIrKouzahrketrkymd(dispKouzahrketrkymd);
                skKouhuriUkTrkMihaneilistDsBean.setIrDatajyusinymd(dispDatajyusinymd);
                skKouhuriUkTrkMihaneilistDsBean.setIrMosno(skKouhuriUkTrkMihanei.getNykmosno());
                skKouhuriUkTrkMihaneilistDsBean.setIrOkyakusamano(skKouhuriUkTrkMihanei.getKouhuriokyakusamano());

                if (BANKCD_YTGINKOUKZHURISERVICE_KINYUUCDUKE.equals(skKouhuriUkTrkMihanei.getBankcd())
                    || BANKCD_YTGINKOUKZHURISERVICE_WEBUKE.equals(skKouhuriUkTrkMihanei.getBankcd())
                    || BANKCD_YTGINKOUSKJHURISERVICE.equals(skKouhuriUkTrkMihanei.getBankcd())) {
                    skKouhuriUkTrkMihaneilistDsBean.setIrKinyuucd(BANKCD_YTGINKOU);
                }
                else {
                    skKouhuriUkTrkMihaneilistDsBean.setIrKinyuucd(skKouhuriUkTrkMihanei.getBankcd());
                }
                skKouhuriUkTrkMihaneilistDsBean.setIrSitencd(skKouhuriUkTrkMihanei.getSitencd5keta().substring(
                    skKouhuriUkTrkMihanei.getSitencd5keta().length() - 3));

                if (YuyuSinkeiyakuConfig.getInstance().getBankcdYokinkbnEditList().contains(skKouhuriUkTrkMihanei.getBankcd())) {
                    skKouhuriUkTrkMihaneilistDsBean.setIrYokinkbn(C_YokinKbn.HUTUU);
                }
                else {
                    skKouhuriUkTrkMihaneilistDsBean.setIrYokinkbn(skKouhuriUkTrkMihanei.getYokinkbn());
                }
                skKouhuriUkTrkMihaneilistDsBean.setIrKouzano(skKouhuriUkTrkMihanei.getKouzano8keta().substring(
                    skKouhuriUkTrkMihanei.getKouzano8keta().length() - 7));
                skKouhuriUkTrkMihaneilistDsBean.setIrKzmeiginmkn(skKouhuriUkTrkMihanei.getKzmeiginmkn());

                khrUktTrkMhneMosnrkmrDataList.add(skKouhuriUkTrkMihaneilistDsBean);
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            C_SyoruiCdKbn.SK_KOUFURITOUROKUMIHANEILIST);

        reportServicesBean.setSyoriYmd(syoriYmd);

        reportServicesBean.addParamObjects(
            C_SyoruiCdKbn.SK_KOUFURITOUROKUMIHANEILIST,
            khrUktTrkMhneMosnrkmrDataList,
            khrUktTrkMhneMosnrkmrHeader);

        createReport.execNoCommit(reportServicesBean);

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(syoriKensuu), "口振受付登録結果未反映リスト作成"));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
