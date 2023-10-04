package yuyu.batch.hozen.khozen.khkanryoutuutijigosgylistsks;

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
import yuyu.batch.hozen.khozen.khkanryoutuutijigosgylistsks.dba.KhKanryouTuutiJigoSgyListSksDao;
import yuyu.batch.hozen.khozen.khkanryoutuutijigosgylistsks.dba.TtdkKanBean;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TokusyuSyoriNaiyouKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_TtdkKan;
import yuyu.def.hozen.bean.report.KhKanryouTuutiJigoSgyListBean;
import yuyu.def.hozen.bean.report.KhKanryouTuutiJigoSgyListDataSourceBean;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 契約保全 完了通知事後作業リスト作成
 */
public class KhKanryouTuutiJigoSgyListSksBatch implements Batch {

    private static final String TYSYTTAISYOU_TABLE_ID = IT_TtdkKan.TABLE_NAME;

    private static final String RECOVERY_FILTER_KBNID = "Kh001";

    private static final String JIGOSAGYOUNAIYOU_SYOUKEN = "証券＊";

    private static final String JIGOSAGYOUNAIYOU_BIKOU = "事後作業リスト８件以上該当";

    private BizDate syoriYmd;

    private String syoritaisyouSyono;

    private List<IReportDataSouceBean> kanryouTuutiJigoSgyListDsBeanLst;

    private List<C_TokusyuSyoriNaiyouKbn> tokusyusyorinaiyouLst;

    private List<String> tokusyusyorinaiyouHnykLst;

    private String jigosagyounaiyouBikou;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private KhKanryouTuutiJigoSgyListSksDao khKanryouTuutiJigoSgyListSksDao;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmdWK = bzBatchParam.getSyoriYmd();
        String kakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmdWK)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1018), kakutyoujobcd));

        long syoriKensuu = 0;
        syoriYmd = bzBatchParam.getSyoriYmd();
        syoritaisyouSyono = null;

        KhKanryouTuutiJigoSgyListBean kanryouTuutiJigoSgyListBean = editMidasi();

        kanryouTuutiJigoSgyListDsBeanLst = new ArrayList<>();

        try (
            ExDBResults<TtdkKanBean> ttdkKanBeanLst = khKanryouTuutiJigoSgyListSksDao.getTtdkKanryouInfo(kakutyoujobcd,
                syoriYmd, C_SyoruiCdKbn.KK_KZKTRKSKEI_TTDKKR, C_HassouKbn.HONSYAKAISOU)) {

            for (TtdkKanBean ttdkKanBean : ttdkKanBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(ttdkKanBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(ttdkKanBean.getSyono());

                editMeisai(ttdkKanBean);

                syoriKensuu = syoriKensuu + 1;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

        ReportServicesBean reportServicesBean =
            createReport.createNewReportServiceBean(
                kinou.getSubSystemId(),
                kinou.getCategoryId(),
                kinou.getKinouId(),
                C_SyoruiCdKbn.KK_TRKKZKKNRTUUTISAGYOULIST);

        reportServicesBean.setSyoriYmd(syoriYmd);
        reportServicesBean.addParamObjects(kanryouTuutiJigoSgyListDsBeanLst, kanryouTuutiJigoSgyListBean);

        createReport.execNoCommit(reportServicesBean);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    private KhKanryouTuutiJigoSgyListBean editMidasi() {

        String tantousitunm = "";

        String sosikiCd = bizDomManager.getTantouCd(C_TantouCdKbn.DAIRITENJIMUKANRI).getBusitucd() + "0000";

        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(sosikiCd);

        if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {

            tantousitunm = bzGetSosikiDataBean.getKanjisosikinm20();
        }

        String syoriYmdseirek = DateFormatUtil.dateKANJINoEx(syoriYmd);

        String hozonKkn = ViewReport.getHozonKknTani(C_SyoruiCdKbn.KK_TRKKZKKNRTUUTISAGYOULIST);

        KhKanryouTuutiJigoSgyListBean listBean = SWAKInjector.getInstance(KhKanryouTuutiJigoSgyListBean.class);
        listBean.setIrTantsitunmkj(tantousitunm);
        listBean.setIrSyoriymd(syoriYmdseirek);
        listBean.setIrHozonkkn(hozonKkn);

        return listBean;
    }

    private void editMeisai(TtdkKanBean pTtdkKanBean) {

        if (syoritaisyouSyono == null ||
            !syoritaisyouSyono.equals(pTtdkKanBean.getSyono())) {

            tokusyusyorinaiyouLst = new ArrayList<>();
            tokusyusyorinaiyouHnykLst = new ArrayList<>();
            jigosagyounaiyouBikou = "";

            syoritaisyouSyono = pTtdkKanBean.getSyono();

            IT_KykKihon kykKihonTmp1 = hozenDomManager.getKykKihon(pTtdkKanBean.getSyono());
            kykKihonTmp1 = IT_KykKihonDetacher.detachHokenSyoukentouched(kykKihonTmp1);
            IT_HokenSyouken hokenSyouken = kykKihonTmp1.getHokenSyoukenByTyouhyouymd(syoriYmd);

            if (hokenSyouken != null) {

                if (!C_TokusyuSyoriNaiyouKbn.BLNK.eq(hokenSyouken.getTokusyusyorinaiyoukbn1())) {
                    tokusyusyorinaiyouLst.add(hokenSyouken.getTokusyusyorinaiyoukbn1());
                }

                if (!C_TokusyuSyoriNaiyouKbn.BLNK.eq(hokenSyouken.getTokusyusyorinaiyoukbn2())) {
                    tokusyusyorinaiyouLst.add(hokenSyouken.getTokusyusyorinaiyoukbn2());
                }

                if (!C_TokusyuSyoriNaiyouKbn.BLNK.eq(hokenSyouken.getTokusyusyorinaiyoukbn3())) {
                    tokusyusyorinaiyouLst.add(hokenSyouken.getTokusyusyorinaiyoukbn3());
                }

                if (!C_TokusyuSyoriNaiyouKbn.BLNK.eq(hokenSyouken.getTokusyusyorinaiyoukbn4())) {
                    tokusyusyorinaiyouLst.add(hokenSyouken.getTokusyusyorinaiyoukbn4());
                }

                if (!C_TokusyuSyoriNaiyouKbn.BLNK.eq(hokenSyouken.getTokusyusyorinaiyoukbn5())) {
                    tokusyusyorinaiyouLst.add(hokenSyouken.getTokusyusyorinaiyoukbn5());
                }

                if (!C_TokusyuSyoriNaiyouKbn.BLNK.eq(hokenSyouken.getTokusyusyorinaiyoukbn6())) {
                    tokusyusyorinaiyouLst.add(hokenSyouken.getTokusyusyorinaiyoukbn6());
                }

                if (!C_TokusyuSyoriNaiyouKbn.BLNK.eq(hokenSyouken.getTokusyusyorinaiyoukbn7())) {
                    tokusyusyorinaiyouLst.add(hokenSyouken.getTokusyusyorinaiyoukbn7());
                }

                if (!C_TokusyuSyoriNaiyouKbn.BLNK.eq(hokenSyouken.getTokusyusyorinaiyoukbn8())) {
                    tokusyusyorinaiyouLst.add(hokenSyouken.getTokusyusyorinaiyoukbn8());
                }

                for (int i = 0; i < tokusyusyorinaiyouLst.size(); i++) {

                    tokusyusyorinaiyouHnykLst.add(tokusyusyorinaiyouLst.get(i).getContent(C_TokusyuSyoriNaiyouKbn.PATTERN_SINKI));

                    if (C_TokusyuSyoriNaiyouKbn.SBUKKANJIMEINASI_FUKUSUU.eq(tokusyusyorinaiyouLst.get(i))) {

                        IT_KykKihon kykKihonTmp2 = hozenDomManager.getKykKihon(pTtdkKanBean.getSyono());
                        kykKihonTmp2 = IT_KykKihonDetacher.detachKykUkttouched(kykKihonTmp2);
                        List<IT_KykUkt> sbUktLst = kykKihonTmp2.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);
                        int sbuktkjninsuu = 0;

                        for (IT_KykUkt kykUkt : sbUktLst) {

                            if (C_UktKbn.TOKUTEIMEIGI.eq(kykUkt.getUktkbn()) &&
                                C_KjkhukaKbn.KJKHUKA.eq(kykUkt.getUktnmkjkhukakbn())) {
                                sbuktkjninsuu = sbuktkjninsuu + 1;
                            }
                        }

                        tokusyusyorinaiyouHnykLst.set(i, tokusyusyorinaiyouHnykLst.get(i).replace(
                            "＠", String.valueOf(sbuktkjninsuu)));
                    }

                    if (C_TokusyuSyoriNaiyouKbn.SBUKFUKUSUU.eq(tokusyusyorinaiyouLst.get(i))) {

                        int sbuktninsuu = 0;

                        if (pTtdkKanBean.getSbuktnin() > 4) {
                            sbuktninsuu = pTtdkKanBean.getSbuktnin();
                        }

                        tokusyusyorinaiyouHnykLst.set(i, tokusyusyorinaiyouHnykLst.get(i).replace(
                            "＠", String.valueOf(sbuktninsuu)));
                    }

                    if (!C_TokusyuSyoriNaiyouKbn.HONBANKAKUNINTAISYO.eq(tokusyusyorinaiyouLst.get(i))) {
                        tokusyusyorinaiyouHnykLst.set(i, JIGOSAGYOUNAIYOU_SYOUKEN + tokusyusyorinaiyouHnykLst.get(i));
                    }
                }
            }

            if (tokusyusyorinaiyouLst.size() > 7) {
                jigosagyounaiyouBikou = JIGOSAGYOUNAIYOU_BIKOU;
            }
        }

        KhKanryouTuutiJigoSgyListDataSourceBean dsBean =
            SWAKInjector.getInstance(KhKanryouTuutiJigoSgyListDataSourceBean.class);

        dsBean.setIrSyono(pTtdkKanBean.getSyono());
        dsBean.setIrShsnmkj(pTtdkKanBean.getShsnmkj());
        dsBean.setIrKyknmkj(pTtdkKanBean.getKyknmkj());

        dsBean.setIrJigosagyounaiyou1("");
        dsBean.setIrJigosagyounaiyou2("");
        dsBean.setIrJigosagyounaiyou3("");
        dsBean.setIrJigosagyounaiyou4("");
        dsBean.setIrJigosagyounaiyou5("");
        dsBean.setIrJigosagyounaiyou6("");
        dsBean.setIrJigosagyounaiyou7("");
        dsBean.setIrJigosagyounaiyou8("");

        if (tokusyusyorinaiyouHnykLst.size() > 0) {
            dsBean.setIrJigosagyounaiyou1(tokusyusyorinaiyouHnykLst.get(0));
        }

        if (tokusyusyorinaiyouHnykLst.size() > 1) {
            dsBean.setIrJigosagyounaiyou2(tokusyusyorinaiyouHnykLst.get(1));
        }

        if (tokusyusyorinaiyouHnykLst.size() > 2) {
            dsBean.setIrJigosagyounaiyou3(tokusyusyorinaiyouHnykLst.get(2));
        }

        if (tokusyusyorinaiyouHnykLst.size() > 3) {
            dsBean.setIrJigosagyounaiyou4(tokusyusyorinaiyouHnykLst.get(3));
        }

        if (tokusyusyorinaiyouHnykLst.size() > 4) {
            dsBean.setIrJigosagyounaiyou5(tokusyusyorinaiyouHnykLst.get(4));
        }

        if (tokusyusyorinaiyouHnykLst.size() > 5) {
            dsBean.setIrJigosagyounaiyou6(tokusyusyorinaiyouHnykLst.get(5));
        }

        if (tokusyusyorinaiyouHnykLst.size() > 6) {
            dsBean.setIrJigosagyounaiyou7(tokusyusyorinaiyouHnykLst.get(6));
        }

        if (tokusyusyorinaiyouHnykLst.size() > 7) {
            dsBean.setIrJigosagyounaiyou8(tokusyusyorinaiyouHnykLst.get(7));
        }

        dsBean.setIrJigosagyounaiyoubikou(jigosagyounaiyouBikou);

        kanryouTuutiJigoSgyListDsBeanLst.add(dsBean);
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
