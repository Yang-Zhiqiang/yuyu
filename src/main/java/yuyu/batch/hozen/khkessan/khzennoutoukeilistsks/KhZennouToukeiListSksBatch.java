package yuyu.batch.hozen.khkessan.khzennoutoukeilistsks;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khkessan.khzennoutoukeilistsks.dba.KhZennouToukeiListSksDao;
import yuyu.batch.hozen.khkessan.khzennoutoukeilistsks.dba.ZennouToukeiListSksTaisyouBean;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.def.MessageId;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_ZennouKbn;
import yuyu.def.classification.C_ZennouToukeiListKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.hozen.bean.report.KhZennouToukeiListBean;
import yuyu.def.hozen.bean.report.KhZennouToukeiListDataSourceBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

import com.google.common.collect.Lists;

/**
 * 契約保全 決算 前納統計リスト作成
 */
public class KhZennouToukeiListSksBatch implements Batch {

    private int syorikensuu;

    private C_Segcd maeRcdKbnkeirisegcd;

    private C_ZennouKbn maeRcdZennoukbn;

    private C_ZennouToukeiListKbn maeRcdZennouToukeiListKbn;

    private  int kensuSyoukeiSeg;

    private BizCurrency zennoukaisijizndkSyoukeiSeg;

    private BizCurrency tndmatuzndkSyoukeiSeg;

    private BizCurrency zennoukaisijizndkgaikaSyoukeiSeg;

    private BizCurrency tndmatuzndkgaikaSyoukeiSeg;

    private int kensuSyoukeiZennoukbn;

    private BizCurrency zennoukaisijizndkSyoukeiZennoukbn;

    private BizCurrency tndmatuzndkSyoukeiZennoukbn;

    private BizCurrency zennoukaisijizndkgaikaSyoukeiZennoukbn;

    private BizCurrency tndmatuzndkgaikaSyoukeiZennoukbn;

    private int kensuSyoukeiLstkbn;

    private BizCurrency zennoukaisijizndkSyoukeiLstkbn;

    private BizCurrency tndmatuzndkSyoukeiLstkbn;

    private BizCurrency zennoukaisijizndkgaikaSyoukeiLstkbn;

    private BizCurrency tndmatuzndkgaikaSyoukeiLstkbn;

    private int[] kensuSokei = new int[4];

    private BizCurrency[] zennoukaisijizndkSokei = new BizCurrency[4];

    private BizCurrency[] tndmatuzndkSokei = new BizCurrency[4];

    private BizCurrency[] zennoukaisijizndkgaikaSokei = new BizCurrency[4];

    private BizCurrency[] tndmatuzndkgaikaSokei = new BizCurrency[4];

    private List<IReportDataSouceBean> zennouToukeiListDataSourceBeanLst;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private KhZennouToukeiListSksDao khZennouToukeiListSksDao;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        syorikensuu = 0;
        maeRcdKbnkeirisegcd = C_Segcd.BLNK;
        maeRcdZennoukbn = C_ZennouKbn.BLNK;
        maeRcdZennouToukeiListKbn = C_ZennouToukeiListKbn.OTHER;
        kensuSyoukeiSeg = 0;
        zennoukaisijizndkSyoukeiSeg = BizCurrency.valueOf(0);
        tndmatuzndkSyoukeiSeg = BizCurrency.valueOf(0);
        zennoukaisijizndkgaikaSyoukeiSeg = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
        tndmatuzndkgaikaSyoukeiSeg = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
        kensuSyoukeiZennoukbn = 0;
        zennoukaisijizndkSyoukeiZennoukbn = BizCurrency.valueOf(0);
        tndmatuzndkSyoukeiZennoukbn = BizCurrency.valueOf(0);
        zennoukaisijizndkgaikaSyoukeiZennoukbn = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
        tndmatuzndkgaikaSyoukeiZennoukbn = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
        kensuSyoukeiLstkbn = 0;
        zennoukaisijizndkSyoukeiLstkbn = BizCurrency.valueOf(0);
        tndmatuzndkSyoukeiLstkbn = BizCurrency.valueOf(0);
        zennoukaisijizndkgaikaSyoukeiLstkbn = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
        tndmatuzndkgaikaSyoukeiLstkbn = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
        for (int i = 0; i < 4; i++) {
            kensuSokei[i] = 0;
            zennoukaisijizndkSokei[i] = BizCurrency.valueOf(0);
            tndmatuzndkSokei[i] = BizCurrency.valueOf(0);
            zennoukaisijizndkgaikaSokei[i] = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
            tndmatuzndkgaikaSokei[i] = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
        }
        zennouToukeiListDataSourceBeanLst = Lists.newArrayList();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(bzBatchParam.getSyoriYmd())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW1018), String.valueOf(bzBatchParam.getIbKakutyoujobcd())));

        ZennouToukeiListSksTaisyouBean zennouToukeiListSksTaisyouBean = null;

        try (ExDBResults<ZennouToukeiListSksTaisyouBean> zennouToukeiListSksTaisyouLst = khZennouToukeiListSksDao.
            getZennouToukeiListSksTaisyouBeans(bzBatchParam.getSyoriYmd().toString())) {

            for (ZennouToukeiListSksTaisyouBean zennouToukeiListSksTaisyou : zennouToukeiListSksTaisyouLst) {
                if (syorikensuu == 0) {
                    maeRcdKbnkeirisegcd = zennouToukeiListSksTaisyou.getKbnkeirisegcd();
                    maeRcdZennoukbn = zennouToukeiListSksTaisyou.getZennoukbn();
                    maeRcdZennouToukeiListKbn = zennouToukeiListSksTaisyou.getZennoutoukeilistkbn();
                    zennouToukeiListSksTaisyouBean = zennouToukeiListSksTaisyou;
                }
                if (syorikensuu != 0 && (!maeRcdKbnkeirisegcd.eq(zennouToukeiListSksTaisyou.getKbnkeirisegcd()) ||
                    !maeRcdZennoukbn.eq(zennouToukeiListSksTaisyou.getZennoukbn()) ||
                    !maeRcdZennouToukeiListKbn.eq(zennouToukeiListSksTaisyou.getZennoutoukeilistkbn()))) {
                    keyBreak(zennouToukeiListSksTaisyou, "0");
                }

                KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean =
                    SWAKInjector.getInstance(KhZennouToukeiListDataSourceBean.class);

                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

                BizCurrency zennoukaisijizndk;
                BizCurrency mkkp;
                BizCurrency zennoukaisizndkgaika;
                BizCurrency mkkpgaika;

                C_Tuukasyu calcTuukaSyu = henkanTuuka.henkanTuukaTypeToKbn(
                    zennouToukeiListSksTaisyou.getZennoukaisijizndk().getType());

                if (C_Tuukasyu.JPY.eq(calcTuukaSyu)) {

                    zennoukaisijizndk = zennouToukeiListSksTaisyou.getZennoukaisijizndk();
                    mkkp = zennouToukeiListSksTaisyou.getTndmatuzndk();
                    zennoukaisizndkgaika = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
                    mkkpgaika = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);

                }
                else {
                    zennoukaisijizndk = zennouToukeiListSksTaisyou.getZennoukaisijizndktkmatu();
                    mkkp = zennouToukeiListSksTaisyou.getTndmatuzndktkmatu();
                    zennoukaisizndkgaika = zennouToukeiListSksTaisyou.getZennoukaisijizndk();
                    mkkpgaika = zennouToukeiListSksTaisyou.getTndmatuzndk();
                }

                khZennouToukeiListDataSourceBean.setIrZennoutoukeilistkbn(zennouToukeiListSksTaisyou.getZennoutoukeilistkbn().getValue());
                if (C_ZennouToukeiListKbn.ZENNOU_MKKP.eq(zennouToukeiListSksTaisyou.getZennoutoukeilistkbn())) {
                    khZennouToukeiListDataSourceBean.setIrZennoutoukeilisttitle("＊＊＊前納未経過Ｐリスト＊＊＊");
                }
                else if (C_ZennouToukeiListKbn.MANRYOUBUN_MKKP.eq(zennouToukeiListSksTaisyou.getZennoutoukeilistkbn())) {
                    khZennouToukeiListDataSourceBean.setIrZennoutoukeilisttitle("＊＊＊前納満了区分　未経過Ｐリスト＊＊＊");
                }
                khZennouToukeiListDataSourceBean.setIrListkbnbtsyuukei("");
                khZennouToukeiListDataSourceBean.setIrZennoukbnbtsyuukei("");
                khZennouToukeiListDataSourceBean.setIrSegbetusyuukei("");
                khZennouToukeiListDataSourceBean.setIrZennoukbn(zennouToukeiListSksTaisyou.getZennoukbn().getValue());
                khZennouToukeiListDataSourceBean.setIrKbnkeirisegcd(zennouToukeiListSksTaisyou.getKbnkeirisegcd().getValue());
                khZennouToukeiListDataSourceBean.setIrZennoukaisiym(zennouToukeiListSksTaisyou.getZennoustartym());
                khZennouToukeiListDataSourceBean.setIrZennoutoukeilist((int)zennouToukeiListSksTaisyou.getCnt());
                khZennouToukeiListDataSourceBean.setIrZennoukaisizndk(zennoukaisijizndk);
                khZennouToukeiListDataSourceBean.setIrMkkp(mkkp);
                khZennouToukeiListDataSourceBean.setIrZennoukaisizndkgaika(zennoukaisizndkgaika);
                khZennouToukeiListDataSourceBean.setIrMkkpgaika(mkkpgaika);

                zennouToukeiListDataSourceBeanLst.add(khZennouToukeiListDataSourceBean);

                kensuSyoukeiSeg = kensuSyoukeiSeg + (int)zennouToukeiListSksTaisyou.getCnt();
                zennoukaisijizndkSyoukeiSeg = zennoukaisijizndkSyoukeiSeg.add(zennoukaisijizndk);
                tndmatuzndkSyoukeiSeg = tndmatuzndkSyoukeiSeg.add(mkkp);
                zennoukaisijizndkgaikaSyoukeiSeg = zennoukaisijizndkgaikaSyoukeiSeg.add(zennoukaisizndkgaika);
                tndmatuzndkgaikaSyoukeiSeg = tndmatuzndkgaikaSyoukeiSeg.add(mkkpgaika);
                kensuSyoukeiZennoukbn = kensuSyoukeiZennoukbn + (int)zennouToukeiListSksTaisyou.getCnt();
                zennoukaisijizndkSyoukeiZennoukbn = zennoukaisijizndkSyoukeiZennoukbn.add(zennoukaisijizndk);
                tndmatuzndkSyoukeiZennoukbn = tndmatuzndkSyoukeiZennoukbn.add(mkkp);
                zennoukaisijizndkgaikaSyoukeiZennoukbn = zennoukaisijizndkgaikaSyoukeiZennoukbn.add(zennoukaisizndkgaika);
                tndmatuzndkgaikaSyoukeiZennoukbn = tndmatuzndkgaikaSyoukeiZennoukbn.add(mkkpgaika);
                kensuSyoukeiLstkbn = kensuSyoukeiLstkbn + (int)zennouToukeiListSksTaisyou.getCnt();
                zennoukaisijizndkSyoukeiLstkbn = zennoukaisijizndkSyoukeiLstkbn.add(zennoukaisijizndk);
                tndmatuzndkSyoukeiLstkbn = tndmatuzndkSyoukeiLstkbn.add(mkkp);
                zennoukaisijizndkgaikaSyoukeiLstkbn = zennoukaisijizndkgaikaSyoukeiLstkbn.add(zennoukaisizndkgaika);
                tndmatuzndkgaikaSyoukeiLstkbn = tndmatuzndkgaikaSyoukeiLstkbn.add(mkkpgaika);
                syorikensuu = syorikensuu + (int)zennouToukeiListSksTaisyou.getCnt();
            }

            if (zennouToukeiListSksTaisyouBean != null) {
                keyBreak(zennouToukeiListSksTaisyouBean, "1");
            }

            for (int i = 0; i < 4; i++) {

                KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean =
                    SWAKInjector.getInstance(KhZennouToukeiListDataSourceBean.class);

                khZennouToukeiListDataSourceBean.setIrZennoutoukeilistkbn(C_ZennouToukeiListKbn.OTHER.getValue());
                khZennouToukeiListDataSourceBean.setIrZennoutoukeilisttitle("＊＊＊リスト区分別集計結果＊＊＊");
                if (i == 3) {
                    khZennouToukeiListDataSourceBean.setIrListkbnbtsyuukei("総合計");
                } else {
                    khZennouToukeiListDataSourceBean.setIrListkbnbtsyuukei(i + 1 + "合計");
                }
                khZennouToukeiListDataSourceBean.setIrZennoukbnbtsyuukei("");
                khZennouToukeiListDataSourceBean.setIrSegbetusyuukei("");
                khZennouToukeiListDataSourceBean.setIrZennoukbn("");
                khZennouToukeiListDataSourceBean.setIrKbnkeirisegcd("");
                khZennouToukeiListDataSourceBean.setIrZennoukaisiym(null);
                khZennouToukeiListDataSourceBean.setIrZennoutoukeilist(kensuSokei[i]);
                khZennouToukeiListDataSourceBean.setIrZennoukaisizndk(zennoukaisijizndkSokei[i]);
                khZennouToukeiListDataSourceBean.setIrMkkp(tndmatuzndkSokei[i]);
                khZennouToukeiListDataSourceBean.setIrZennoukaisizndkgaika(zennoukaisijizndkgaikaSokei[i]);
                khZennouToukeiListDataSourceBean.setIrMkkpgaika(tndmatuzndkgaikaSokei[i]);

                zennouToukeiListDataSourceBeanLst.add(khZennouToukeiListDataSourceBean);
            }
        }

        KhZennouToukeiListBean khZennouToukeiListBean = SWAKInjector.getInstance(KhZennouToukeiListBean.class);
        khZennouToukeiListBean.setIrSakuseiymd(bzBatchParam.getSyoriYmd().toString());

        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            C_SyoruiCdKbn.AS_ZENNOUTOUKEILIST);

        reportServicesBean.addParamObjects(zennouToukeiListDataSourceBeanLst, khZennouToukeiListBean);
        reportServicesBean.setSyoriYmd(bzBatchParam.getSyoriYmd());
        createReport.execNoCommit(reportServicesBean);

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0001, String.valueOf(syorikensuu)));
    }

    private void keyBreak(ZennouToukeiListSksTaisyouBean pZennouToukeiListSksTaisyouBean, String pEndKbn) {

        if ("1".equals(pEndKbn) || !maeRcdZennouToukeiListKbn.eq(pZennouToukeiListSksTaisyouBean.getZennoutoukeilistkbn())) {
            keyBreak1(pZennouToukeiListSksTaisyouBean);
            keyBreak2(pZennouToukeiListSksTaisyouBean);
            keyBreak3(pZennouToukeiListSksTaisyouBean);
        } else if (!maeRcdZennoukbn.eq(pZennouToukeiListSksTaisyouBean.getZennoukbn())) {
            keyBreak1(pZennouToukeiListSksTaisyouBean);
            keyBreak2(pZennouToukeiListSksTaisyouBean);
        } else if (!maeRcdKbnkeirisegcd.eq(pZennouToukeiListSksTaisyouBean.getKbnkeirisegcd())) {
            keyBreak1(pZennouToukeiListSksTaisyouBean);
        }
    }

    private void keyBreak1(ZennouToukeiListSksTaisyouBean pZennouToukeiListSksTaisyouBean) {

        KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean =
            SWAKInjector.getInstance(KhZennouToukeiListDataSourceBean.class);

        khZennouToukeiListDataSourceBean.setIrZennoutoukeilistkbn(maeRcdZennouToukeiListKbn.getValue());
        if (C_ZennouToukeiListKbn.ZENNOU_MKKP.eq(maeRcdZennouToukeiListKbn)) {
            khZennouToukeiListDataSourceBean.setIrZennoutoukeilisttitle("＊＊＊前納未経過Ｐリスト＊＊＊");
        }
        else if (C_ZennouToukeiListKbn.MANRYOUBUN_MKKP.eq(maeRcdZennouToukeiListKbn)) {
            khZennouToukeiListDataSourceBean.setIrZennoutoukeilisttitle("＊＊＊前納満了区分　未経過Ｐリスト＊＊＊");
        }
        khZennouToukeiListDataSourceBean.setIrListkbnbtsyuukei("");
        khZennouToukeiListDataSourceBean.setIrZennoukbnbtsyuukei("");
        khZennouToukeiListDataSourceBean.setIrSegbetusyuukei(maeRcdKbnkeirisegcd.getValue() + "合計");
        khZennouToukeiListDataSourceBean.setIrZennoukbn("");
        khZennouToukeiListDataSourceBean.setIrKbnkeirisegcd("");
        khZennouToukeiListDataSourceBean.setIrZennoukaisiym(null);
        khZennouToukeiListDataSourceBean.setIrZennoutoukeilist(kensuSyoukeiSeg);
        khZennouToukeiListDataSourceBean.setIrZennoukaisizndk(zennoukaisijizndkSyoukeiSeg);
        khZennouToukeiListDataSourceBean.setIrMkkp(tndmatuzndkSyoukeiSeg);
        khZennouToukeiListDataSourceBean.setIrZennoukaisizndkgaika(zennoukaisijizndkgaikaSyoukeiSeg);
        khZennouToukeiListDataSourceBean.setIrMkkpgaika(tndmatuzndkgaikaSyoukeiSeg);

        zennouToukeiListDataSourceBeanLst.add(khZennouToukeiListDataSourceBean);

        maeRcdKbnkeirisegcd = pZennouToukeiListSksTaisyouBean.getKbnkeirisegcd();
        kensuSyoukeiSeg = 0;
        zennoukaisijizndkSyoukeiSeg = BizCurrency.valueOf(0);
        tndmatuzndkSyoukeiSeg = BizCurrency.valueOf(0);
        zennoukaisijizndkgaikaSyoukeiSeg = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
        tndmatuzndkgaikaSyoukeiSeg = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);

    }

    private void keyBreak2(ZennouToukeiListSksTaisyouBean pZennouToukeiListSksTaisyouBean) {

        KhZennouToukeiListDataSourceBean khZennouToukeiListDataSourceBean =
            SWAKInjector.getInstance(KhZennouToukeiListDataSourceBean.class);

        khZennouToukeiListDataSourceBean.setIrZennoutoukeilistkbn(maeRcdZennouToukeiListKbn.getValue());
        if (C_ZennouToukeiListKbn.ZENNOU_MKKP.eq(maeRcdZennouToukeiListKbn)) {
            khZennouToukeiListDataSourceBean.setIrZennoutoukeilisttitle("＊＊＊前納未経過Ｐリスト＊＊＊");
        }
        else if (C_ZennouToukeiListKbn.MANRYOUBUN_MKKP.eq(maeRcdZennouToukeiListKbn)) {
            khZennouToukeiListDataSourceBean.setIrZennoutoukeilisttitle("＊＊＊前納満了区分　未経過Ｐリスト＊＊＊");
        }
        khZennouToukeiListDataSourceBean.setIrListkbnbtsyuukei("");
        khZennouToukeiListDataSourceBean.setIrZennoukbnbtsyuukei(maeRcdZennoukbn.getValue() + "合計");
        khZennouToukeiListDataSourceBean.setIrSegbetusyuukei("");
        khZennouToukeiListDataSourceBean.setIrZennoukbn("");
        khZennouToukeiListDataSourceBean.setIrKbnkeirisegcd("");
        khZennouToukeiListDataSourceBean.setIrZennoukaisiym(null);
        khZennouToukeiListDataSourceBean.setIrZennoutoukeilist(kensuSyoukeiZennoukbn);
        khZennouToukeiListDataSourceBean.setIrZennoukaisizndk(zennoukaisijizndkSyoukeiZennoukbn);
        khZennouToukeiListDataSourceBean.setIrMkkp(tndmatuzndkSyoukeiZennoukbn);
        khZennouToukeiListDataSourceBean.setIrZennoukaisizndkgaika(zennoukaisijizndkgaikaSyoukeiZennoukbn);
        khZennouToukeiListDataSourceBean.setIrMkkpgaika(tndmatuzndkgaikaSyoukeiZennoukbn);

        zennouToukeiListDataSourceBeanLst.add(khZennouToukeiListDataSourceBean);

        maeRcdZennoukbn = pZennouToukeiListSksTaisyouBean.getZennoukbn();
        kensuSyoukeiZennoukbn = 0;
        zennoukaisijizndkSyoukeiZennoukbn = BizCurrency.valueOf(0);
        tndmatuzndkSyoukeiZennoukbn = BizCurrency.valueOf(0);
        zennoukaisijizndkgaikaSyoukeiZennoukbn = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
        tndmatuzndkgaikaSyoukeiZennoukbn = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);

    }

    private void keyBreak3(ZennouToukeiListSksTaisyouBean pZennouToukeiListSksTaisyouBean) {
        kensuSokei[Integer.valueOf(maeRcdZennouToukeiListKbn.getValue()) - 1] = kensuSyoukeiLstkbn;
        zennoukaisijizndkSokei[Integer.valueOf(maeRcdZennouToukeiListKbn.getValue()) - 1] = zennoukaisijizndkSyoukeiLstkbn;
        tndmatuzndkSokei[Integer.valueOf(maeRcdZennouToukeiListKbn.getValue()) - 1] = tndmatuzndkSyoukeiLstkbn;
        zennoukaisijizndkgaikaSokei[Integer.valueOf(maeRcdZennouToukeiListKbn.getValue()) - 1] = zennoukaisijizndkgaikaSyoukeiLstkbn;
        tndmatuzndkgaikaSokei[Integer.valueOf(maeRcdZennouToukeiListKbn.getValue()) - 1] = tndmatuzndkgaikaSyoukeiLstkbn;

        kensuSokei[3] = kensuSokei[3] + kensuSyoukeiLstkbn;
        zennoukaisijizndkSokei[3] = zennoukaisijizndkSokei[3].add(zennoukaisijizndkSyoukeiLstkbn);
        tndmatuzndkSokei[3] = tndmatuzndkSokei[3].add(tndmatuzndkSyoukeiLstkbn);
        zennoukaisijizndkgaikaSokei[3] = zennoukaisijizndkgaikaSokei[3].add(zennoukaisijizndkgaikaSyoukeiLstkbn);
        tndmatuzndkgaikaSokei[3] = tndmatuzndkgaikaSokei[3].add(tndmatuzndkgaikaSyoukeiLstkbn);

        maeRcdZennouToukeiListKbn = pZennouToukeiListSksTaisyouBean.getZennoutoukeilistkbn();
        kensuSyoukeiLstkbn = 0;
        zennoukaisijizndkSyoukeiLstkbn = BizCurrency.valueOf(0);
        tndmatuzndkSyoukeiLstkbn = BizCurrency.valueOf(0);
        zennoukaisijizndkgaikaSyoukeiLstkbn = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
        tndmatuzndkgaikaSyoukeiLstkbn = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
    }
}
