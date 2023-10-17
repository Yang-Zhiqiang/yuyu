package yuyu.batch.biz.bzkaikei.bzkbtkarikanjyouzndksykilstsks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.bzkaikei.bzkbtkarikanjyouzndksykilstsks.dba.BzKbtKarikanjyouZndksykilstSksDao;
import yuyu.batch.biz.bzkaikei.bzkbtkarikanjyouzndksykilstsks.dba.KbtKarikanjyouDataBean;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.bean.report.BzKbtKarikanjyouZndksyukilistBean;
import yuyu.def.biz.bean.report.BzKbtKarikanjyouZndksyukilistDataSourceBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 業務共通 経理・会計 個別仮勘定残高集計リスト作成クラス
 */
public class BzKbtKarikanjyouZndksykilstSksBatch implements Batch {

    private final String ZERO_FOUR_KETA = "0000";

    private final String SOUKATU = "－A";

    private List<IReportDataSouceBean> bzKbtKarikjyZndksyukilistDSBeanLst;

    private HashMap<String, KbtKarikanjyouDataBean> gekkanGoukeiDataBeanMap;

    private HashMap<String, KbtKarikanjyouDataBean> kanjyoukamokuGoukeiDataBeanMap;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzKbtKarikanjyouZndksykilstSksDao bzKbtKarikanjyouZndksykilstSksDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        bzKbtKarikjyZndksyukilistDSBeanLst = null;
        gekkanGoukeiDataBeanMap = null;
        kanjyoukamokuGoukeiDataBeanMap = null;
        List<BzKbtKarikanjyouZndksykilstSksBean> bzKbtKarikjZndksyukilistSksBeanLst = null;
        BzKbtKarikanjyouZndksyukilistDataSourceBean bzKbtKarikanjyouZndksyukilistDSBean = null;
        String atesakibukanm = "";
        String atesakicdMae = "";
        C_Kanjyoukmkcd kanjyoukmkcdMae = C_Kanjyoukmkcd.BLNK;
        BizDate denymdMae = null;
        long syoriKensuu = 0;
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        BizDateYM syoriYmdPreMon = syoriYmd.getBizDateYM().getPreviousMonth();
        BizDate syoriYmdPreMonLastDay = syoriYmdPreMon.getLastDay();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(syoriYmd)));

        try (
            ExDBResults<KbtKarikanjyouDataBean> zndkSyuukeilistDataLst = bzKbtKarikanjyouZndksykilstSksDao.
            getKbtKarikanjyouZndksyukilistByDenymd(syoriYmdPreMonLastDay);

            ExDBResults<KbtKarikanjyouDataBean> gekkanGoukeiDataLst = bzKbtKarikanjyouZndksykilstSksDao.
                getKbtKarikanjyouZndksyukilistGekkangkByDenymd(syoriYmdPreMonLastDay);

            ExDBResults<KbtKarikanjyouDataBean> kanjyoukamokuGoukeiDataLst = bzKbtKarikanjyouZndksykilstSksDao.
                getKbtKarikanjyouZndksyukilistKmkbetugkByDenymd(syoriYmdPreMonLastDay);){
            gekkanGoukeiDataBeanMap = new HashMap<>();
            kanjyoukamokuGoukeiDataBeanMap = new HashMap<>();

            for (KbtKarikanjyouDataBean kbtKarikanjyouDataBean : gekkanGoukeiDataLst) {

                String mapKey = kbtKarikanjyouDataBean.getHuridenatesakicd() +
                    kbtKarikanjyouDataBean.getKanjyoukmkcd().getValue() +
                    kbtKarikanjyouDataBean.getTaisyakuKbn().getValue();

                gekkanGoukeiDataBeanMap.put(mapKey, kbtKarikanjyouDataBean);
            }

            for (KbtKarikanjyouDataBean kbtKarikanjyouDataBean : kanjyoukamokuGoukeiDataLst) {

                String mapKey = kbtKarikanjyouDataBean.getKanjyoukmkcd().getValue() +
                    kbtKarikanjyouDataBean.getTaisyakuKbn().getValue();

                kanjyoukamokuGoukeiDataBeanMap.put(mapKey, kbtKarikanjyouDataBean);
            }

            bzKbtKarikjZndksyukilistSksBeanLst = new ArrayList<>();

            for (KbtKarikanjyouDataBean kbtKarikanjyouDataBean : zndkSyuukeilistDataLst) {

                if (!kbtKarikanjyouDataBean.getHuridenatesakicd().equals(atesakicdMae) ||
                    !kbtKarikanjyouDataBean.getKanjyoukmkcd().eq(kanjyoukmkcdMae) ||
                    (kbtKarikanjyouDataBean.getHuridenatesakicd().equals(atesakicdMae) &&
                        kbtKarikanjyouDataBean.getKanjyoukmkcd().eq(kanjyoukmkcdMae) &&
                        !kbtKarikanjyouDataBean.getDenymd().equals(denymdMae))) {

                    BzKbtKarikanjyouZndksykilstSksBean bzKbtKarikanjyouZndksyukilistSksBean =
                        SWAKInjector.getInstance(BzKbtKarikanjyouZndksykilstSksBean.class);


                    String kanjyoukmknm = bizDomManager.getKanjyouKamoku(kbtKarikanjyouDataBean.getKanjyoukmkcd()).
                        getKanjyoukmknm();

                    bzKbtKarikanjyouZndksyukilistSksBean.setHuridenatesakicd(kbtKarikanjyouDataBean.getHuridenatesakicd());
                    bzKbtKarikanjyouZndksyukilistSksBean.setKanjyoukmkcd(kbtKarikanjyouDataBean.getKanjyoukmkcd());
                    bzKbtKarikanjyouZndksyukilistSksBean.setKanjyoukmknm(kanjyoukmknm);
                    bzKbtKarikanjyouZndksyukilistSksBean.setDenymd(kbtKarikanjyouDataBean.getDenymd());

                    if (C_TaisyakuKbn.KARIKATA.eq(kbtKarikanjyouDataBean.getTaisyakuKbn())) {

                        bzKbtKarikanjyouZndksyukilistSksBean.setKarikatamsgk(kbtKarikanjyouDataBean.getDenyenkagk());
                        bzKbtKarikanjyouZndksyukilistSksBean.setKarikatamsks(kbtKarikanjyouDataBean.getKensuu());
                    }
                    else {

                        bzKbtKarikanjyouZndksyukilistSksBean.setKasikatamsgk(kbtKarikanjyouDataBean.getDenyenkagk());
                        bzKbtKarikanjyouZndksyukilistSksBean.setKasikatamsks(kbtKarikanjyouDataBean.getKensuu());
                    }

                    bzKbtKarikjZndksyukilistSksBeanLst.add(bzKbtKarikanjyouZndksyukilistSksBean);
                }

                else if (kbtKarikanjyouDataBean.getHuridenatesakicd().equals(atesakicdMae) &&
                    kbtKarikanjyouDataBean.getKanjyoukmkcd().eq(kanjyoukmkcdMae) &&
                    kbtKarikanjyouDataBean.getDenymd().equals(denymdMae)) {

                    BzKbtKarikanjyouZndksykilstSksBean bzKbtKarikanjyouZndksyukilistSksBean =
                        bzKbtKarikjZndksyukilistSksBeanLst.get(bzKbtKarikjZndksyukilistSksBeanLst.size() - 1);
                    bzKbtKarikanjyouZndksyukilistSksBean.setKasikatamsgk(kbtKarikanjyouDataBean.getDenyenkagk());
                    bzKbtKarikanjyouZndksyukilistSksBean.setKasikatamsks(kbtKarikanjyouDataBean.getKensuu());
                }
                atesakicdMae = kbtKarikanjyouDataBean.getHuridenatesakicd();
                kanjyoukmkcdMae = kbtKarikanjyouDataBean.getKanjyoukmkcd();
                denymdMae = kbtKarikanjyouDataBean.getDenymd();
                syoriKensuu++;
            }

            atesakibukanm = getListinjiAtesakibukanm();

            atesakicdMae = "";
            kanjyoukmkcdMae = C_Kanjyoukmkcd.BLNK;
            bzKbtKarikjyZndksyukilistDSBeanLst = new ArrayList<>();

            for (BzKbtKarikanjyouZndksykilstSksBean bzKbtKarikanjyouZndksyukilistSksBean :
                bzKbtKarikjZndksyukilistSksBeanLst) {

                bzKbtKarikanjyouZndksyukilistDSBean =
                    SWAKInjector.getInstance(BzKbtKarikanjyouZndksyukilistDataSourceBean.class);

                bzKbtKarikanjyouZndksyukilistDSBean.setIrKbtkkjzndksklstatskbkcd(
                    bzKbtKarikanjyouZndksyukilistSksBean.getHuridenatesakicd());
                bzKbtKarikanjyouZndksyukilistDSBean.setIrKbtkkjzndksklstatskbknm(atesakibukanm);
                bzKbtKarikanjyouZndksyukilistDSBean.setIrKanjyoukmkcd(
                    bzKbtKarikanjyouZndksyukilistSksBean.getKanjyoukmkcd().getValue());
                bzKbtKarikanjyouZndksyukilistDSBean.setIrKanjyoukmknm(
                    bzKbtKarikanjyouZndksyukilistSksBean.getKanjyoukmknm());
                bzKbtKarikanjyouZndksyukilistDSBean.setIrDenymd(
                    DateFormatUtil.dateKANJISeirekiNoZero(bzKbtKarikanjyouZndksyukilistSksBean.getDenymd()));

                bzKbtKarikanjyouZndksyukilistDSBean.setIrKarikatamsgk(
                    bzKbtKarikanjyouZndksyukilistSksBean.getKarikatamsgk());

                if (bzKbtKarikanjyouZndksyukilistSksBean.getKarikatamsks() != 0) {
                    bzKbtKarikanjyouZndksyukilistDSBean.setIrKarikatamsks(
                        (int)bzKbtKarikanjyouZndksyukilistSksBean.getKarikatamsks());
                }

                bzKbtKarikanjyouZndksyukilistDSBean.setIrKasikatamsgk(
                    bzKbtKarikanjyouZndksyukilistSksBean.getKasikatamsgk());

                if (bzKbtKarikanjyouZndksyukilistSksBean.getKasikatamsks() != 0) {
                    bzKbtKarikanjyouZndksyukilistDSBean.setIrKasikatamsks(
                        (int)bzKbtKarikanjyouZndksyukilistSksBean.getKasikatamsks());
                }

                if (!BizUtil.isBlank(atesakicdMae) &&
                    !C_Kanjyoukmkcd.BLNK.eq(kanjyoukmkcdMae) &&
                    (!bzKbtKarikanjyouZndksyukilistSksBean.getHuridenatesakicd().equals(atesakicdMae) ||
                        !bzKbtKarikanjyouZndksyukilistSksBean.getKanjyoukmkcd().eq(kanjyoukmkcdMae))) {

                    setReportdsbeanGoukeigaku(atesakicdMae, kanjyoukmkcdMae);
                }

                bzKbtKarikjyZndksyukilistDSBeanLst.add(bzKbtKarikanjyouZndksyukilistDSBean);

                atesakicdMae = bzKbtKarikanjyouZndksyukilistSksBean.getHuridenatesakicd();
                kanjyoukmkcdMae = bzKbtKarikanjyouZndksyukilistSksBean.getKanjyoukmkcd();
            }

            setReportdsbeanGoukeigaku(atesakicdMae, kanjyoukmkcdMae);

            if (bzKbtKarikjyZndksyukilistDSBeanLst.size() >= 1) {

                BzKbtKarikanjyouZndksyukilistBean bzKbtKarikanjyouZndksyukilistBean =
                    SWAKInjector.getInstance(BzKbtKarikanjyouZndksyukilistBean.class);

                bzKbtKarikanjyouZndksyukilistBean.setIrSyoriymd(DateFormatUtil.dateKANJISeirekiNoZero(syoriYmd));
                bzKbtKarikanjyouZndksyukilistBean.setIrDenym(DateFormatUtil.dateYmKANJI(syoriYmdPreMon));

                printKbtKarikanjyouZndksyukiList(C_SyoruiCdKbn.CM_KBTKARIKANJYOUZNDKSYUKILIST,
                    syoriYmd, bzKbtKarikanjyouZndksyukilistBean, bzKbtKarikjyZndksyukilistDSBeanLst);
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
        }
    }

    private String getListinjiAtesakibukanm() {

        String busitucd = bizDomManager.getTantouCd(C_TantouCdKbn.SOUKATU).getBusitucd();

        String atesakibukanm = baseDomManager.getSosiki(busitucd + ZERO_FOUR_KETA).getKanjisosikinm20() + SOUKATU;

        return atesakibukanm;
    }

    private void setReportdsbeanGoukeigaku(String pAtesakicd, C_Kanjyoukmkcd pKanjyoukmkcd) {

        String mapKeyGekkanGoukeiKarikata = pAtesakicd + pKanjyoukmkcd.getValue() + C_TaisyakuKbn.KARIKATA.getValue();
        String mapKeyGekkanGoukeiKasikata = pAtesakicd + pKanjyoukmkcd.getValue() + C_TaisyakuKbn.KASIKATA.getValue();
        String mapKeyKanjyoukamokuGoukeiKarikata = pKanjyoukmkcd.getValue() + C_TaisyakuKbn.KARIKATA.getValue();
        String mapKeyKanjyoukamokuGoukeiKasikata = pKanjyoukmkcd.getValue() + C_TaisyakuKbn.KASIKATA.getValue();

        if (gekkanGoukeiDataBeanMap.containsKey(mapKeyGekkanGoukeiKarikata)) {

            KbtKarikanjyouDataBean gekkanGoukeiDataBean = gekkanGoukeiDataBeanMap.get(mapKeyGekkanGoukeiKarikata);

            BzKbtKarikanjyouZndksyukilistDataSourceBean bzKbtKarikanjyouZndksyukilistDataSourceBean =
                (BzKbtKarikanjyouZndksyukilistDataSourceBean)bzKbtKarikjyZndksyukilistDSBeanLst.
                get(bzKbtKarikjyZndksyukilistDSBeanLst.size() - 1);

            bzKbtKarikanjyouZndksyukilistDataSourceBean.setIrKarikatagekkangkkei(gekkanGoukeiDataBean.getDenyenkagk());
            bzKbtKarikanjyouZndksyukilistDataSourceBean.setIrKarikatagekkankskei(
                (int)gekkanGoukeiDataBean.getKensuu());
        }

        if (gekkanGoukeiDataBeanMap.containsKey(mapKeyGekkanGoukeiKasikata)) {

            KbtKarikanjyouDataBean gekkanGoukeiDataBean = gekkanGoukeiDataBeanMap.get(mapKeyGekkanGoukeiKasikata);

            BzKbtKarikanjyouZndksyukilistDataSourceBean bzKbtKarikanjyouZndksyukilistDataSourceBean =
                (BzKbtKarikanjyouZndksyukilistDataSourceBean)bzKbtKarikjyZndksyukilistDSBeanLst.
                get(bzKbtKarikjyZndksyukilistDSBeanLst.size() - 1);

            bzKbtKarikanjyouZndksyukilistDataSourceBean.setIrKasikatagekkangkkei(gekkanGoukeiDataBean.getDenyenkagk());
            bzKbtKarikanjyouZndksyukilistDataSourceBean.setIrKasikatagekkankskei(
                (int)gekkanGoukeiDataBean.getKensuu());
        }

        if (kanjyoukamokuGoukeiDataBeanMap.containsKey(mapKeyKanjyoukamokuGoukeiKarikata)) {

            KbtKarikanjyouDataBean kanjyoukamokuGoukeiDataBean = kanjyoukamokuGoukeiDataBeanMap.
                get(mapKeyKanjyoukamokuGoukeiKarikata);

            BzKbtKarikanjyouZndksyukilistDataSourceBean bzKbtKarikanjyouZndksyukilistDataSourceBean =
                (BzKbtKarikanjyouZndksyukilistDataSourceBean)bzKbtKarikjyZndksyukilistDSBeanLst.
                get(bzKbtKarikjyZndksyukilistDSBeanLst.size() - 1);

            bzKbtKarikanjyouZndksyukilistDataSourceBean.setIrKarikatakmkgkkei(kanjyoukamokuGoukeiDataBean.
                getDenyenkagk());
            bzKbtKarikanjyouZndksyukilistDataSourceBean.setIrKarikatakmkkskei(
                (int)kanjyoukamokuGoukeiDataBean.getKensuu());
        }

        if (kanjyoukamokuGoukeiDataBeanMap.containsKey(mapKeyKanjyoukamokuGoukeiKasikata)) {

            KbtKarikanjyouDataBean kanjyoukamokuGoukeiDataBean = kanjyoukamokuGoukeiDataBeanMap.
                get(mapKeyKanjyoukamokuGoukeiKasikata);

            BzKbtKarikanjyouZndksyukilistDataSourceBean bzKbtKarikanjyouZndksyukilistDataSourceBean =
                (BzKbtKarikanjyouZndksyukilistDataSourceBean)bzKbtKarikjyZndksyukilistDSBeanLst.
                get(bzKbtKarikjyZndksyukilistDSBeanLst.size() - 1);

            bzKbtKarikanjyouZndksyukilistDataSourceBean.setIrKasikatakmkgkkei(kanjyoukamokuGoukeiDataBean.
                getDenyenkagk());
            bzKbtKarikanjyouZndksyukilistDataSourceBean.setIrKasikatakmkkskei(
                (int)kanjyoukamokuGoukeiDataBean.getKensuu());
        }
    }

    private void printKbtKarikanjyouZndksyukiList(C_SyoruiCdKbn pSyoruiCdKbn,
        BizDate pSyoriYmd,
        BzKbtKarikanjyouZndksyukilistBean pBzKbtKarikanjyouZndksyukilistBean,
        List<IReportDataSouceBean> pBzKbtKarikjyZndksyukilistDSBeanLst) {

        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

        ReportServicesBean reportServicesBean =
            createReport.createNewReportServiceBean(kinou.getSubSystemId(),
                kinou.getCategoryId(),
                kinou.getKinouId(),
                pSyoruiCdKbn);

        reportServicesBean.addParamObjects(pBzKbtKarikjyZndksyukilistDSBeanLst,
            pBzKbtKarikanjyouZndksyukilistBean,
            pSyoriYmd);

        createReport.execNoCommit(reportServicesBean);
    }

}
