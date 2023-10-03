package yuyu.batch.suuri.srsuuritoukei.srtmttdmeisailistsks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.batch.suuri.srsuuritoukei.srtmttdmeisailistsks.dba.SrTmttDMeisaiListSksDao;
import yuyu.batch.suuri.srsuuritoukei.srtmttdmeisailistsks.dba.TmttDMeisaiDataBean;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.suuri.bean.report.SrHaitoukinMeisaiListBean;
import yuyu.def.suuri.bean.report.SrHaitoukinMeisaiListDataSourceBean;
import yuyu.def.suuri.bean.report.SrHaitoukinMeisaiListSubDataSourceBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 数理統計 数理統計 積立配当金明細リスト作成クラス
 */
public class SrTmttDMeisaiListSksBatch implements Batch {

    @Inject
    private SrTmttDMeisaiListSksBatchParam batchParam;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private CreateReport createReport;

    @Inject
    private SrTmttDMeisaiListSksDao srTmttDMeisaiListSksDao;

    private String kakutyoujobcd;

    private String kijyunYM;

    private SrHaitoukinMeisaiListSubDataSourceBean emptyMeisaiListSubDataSourceBean;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = batchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(syoriYmd)));

        if (SrTmttDMeisaiListSksBatchParam.RGKMM002.equals(batchParam.getIbKakutyoujobcd())) {

            kakutyoujobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN2_YUUKOUKYKHTJYNBKNDATA;

        }
        else if (SrTmttDMeisaiListSksBatchParam.RGKMM004.equals(batchParam.getIbKakutyoujobcd())) {

            kakutyoujobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIHONBAN_YUUKOUKYKHTJYNBKNDATA;
        }

        kijyunYM = batchParam.getKijyunymd().getBizDateYM().toString();

        List<TmttDMeisaiDataBean> tmttDMeisaiDataBeanList = srTmttDMeisaiListSksDao.getTmttDMeisai(
            kijyunYM, kakutyoujobcd);

        if (tmttDMeisaiDataBeanList.size() == 0) {

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(tmttDMeisaiDataBeanList.size()),
                "積立配当金明細リスト"));

            return;
        }

        List<IReportDataSouceBean> iReportDataSouceBeanList = new ArrayList<>();
        SrHaitoukinMeisaiListBean srHaitoukinMeisaiListBean = SWAKInjector.getInstance(SrHaitoukinMeisaiListBean.class);
        SrHaitoukinMeisaiListDataSourceBean srHaitoukinMeisaiListDataSourceBean =
            SWAKInjector.getInstance(SrHaitoukinMeisaiListDataSourceBean.class);
        List<SrHaitoukinMeisaiListSubDataSourceBean> srHaitoukinMeisaiListSubDataSourceBeanList = new ArrayList<>();
        SrHaitoukinMeisaiListSubDataSourceBean srHaitoukinMeisaiListSubDataSourceBean =
            SWAKInjector.getInstance(SrHaitoukinMeisaiListSubDataSourceBean.class);
        emptyMeisaiListSubDataSourceBean = SWAKInjector.getInstance(SrHaitoukinMeisaiListSubDataSourceBean.class);

        String breakkeyKbnkeirisegcd = "";
        String breakkeySyukeiyakusyuruicd = "";
        int syuukeiptnkbnCount = SrCommonConstants.DEFAULT_INT_ITI;
        int meisaiBlockCount = SrCommonConstants.DEFAULT_INT_ITI;
        BizNumber goukeiKensuu = BizNumber.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        BizCurrency goukeihsys = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        BizCurrency goukeizennendkurikosid = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        BizCurrency goukeiHaitoursk = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        BizCurrency goukeitounendod = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        BizCurrency goukeiTounendomatud = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);

        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(SrCommonConstants.SOSIKICD_SYUNOSERVICESITU);

        if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {

            String atesakibukanm = ViewReport.editOntyuu(bzGetSosikiDataBean.getKanjisosikinm20());

            srHaitoukinMeisaiListBean.setIrAtesakibukanm(atesakibukanm);
        }

        srHaitoukinMeisaiListBean.setIrSyoriymd(DateFormatUtil.dateKANJI(syoriYmd));

        srHaitoukinMeisaiListBean.setIrHozonkkn(ViewReport.getHozonKknTani(C_SyoruiCdKbn.SR_TMTTDMEISAILIST));

        for (int n = 0; n < tmttDMeisaiDataBeanList.size(); n++) {

            TmttDMeisaiDataBean tmttDMeisaiDataBean = tmttDMeisaiDataBeanList.get(n);

            if (n == 0) {

                breakkeyKbnkeirisegcd = tmttDMeisaiDataBean.getKbnkeiriyousegmentkbn()
                    + tmttDMeisaiDataBean.getKbnkeiriyourgnbnskkbn();

                breakkeySyukeiyakusyuruicd = tmttDMeisaiDataBean.getSyukeiyakusyuruicd();
            }

            String kbnKeiriyousegmentCd = tmttDMeisaiDataBean.getKbnkeiriyousegmentkbn()
                + tmttDMeisaiDataBean.getKbnkeiriyourgnbnskkbn();

            if (!breakkeyKbnkeirisegcd.equals(kbnKeiriyousegmentCd) ||
                !breakkeySyukeiyakusyuruicd.equals(tmttDMeisaiDataBean.getSyukeiyakusyuruicd())) {

                while (syuukeiptnkbnCount <= SrCommonConstants.HAITOUKINSYUUKEIPTNKBN_KBNCOUNT) {

                    srHaitoukinMeisaiListSubDataSourceBeanList.add(emptyMeisaiListSubDataSourceBean);

                    syuukeiptnkbnCount = syuukeiptnkbnCount + 1;
                }

                srHaitoukinMeisaiListSubDataSourceBean = setMeisai(goukeiKensuu, goukeihsys,
                    goukeizennendkurikosid, goukeiHaitoursk, goukeitounendod, goukeiTounendomatud);

                srHaitoukinMeisaiListSubDataSourceBeanList.add(srHaitoukinMeisaiListSubDataSourceBean);

                srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd(ConvertUtil.toZenNumeric(breakkeyKbnkeirisegcd));
                srHaitoukinMeisaiListDataSourceBean.setIrHknsyurui(SrCommonConstants.TYOUHYOUHYOUJINM_HOKENSYURUI);
                srHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd(breakkeySyukeiyakusyuruicd);
                srHaitoukinMeisaiListDataSourceBean.setSrHaitoukinmeisailistsubdatasourcebeanList(
                    srHaitoukinMeisaiListSubDataSourceBeanList);

                iReportDataSouceBeanList.add(srHaitoukinMeisaiListDataSourceBean);

                meisaiBlockCount = meisaiBlockCount + 1;
                breakkeySyukeiyakusyuruicd = tmttDMeisaiDataBean.getSyukeiyakusyuruicd();
                syuukeiptnkbnCount = SrCommonConstants.DEFAULT_INT_ITI;
                goukeiKensuu = BizNumber.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
                goukeihsys = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
                goukeizennendkurikosid = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
                goukeiHaitoursk = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
                goukeitounendod = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
                goukeiTounendomatud = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);

                srHaitoukinMeisaiListSubDataSourceBeanList = new ArrayList<>();

                srHaitoukinMeisaiListDataSourceBean = SWAKInjector
                    .getInstance(SrHaitoukinMeisaiListDataSourceBean.class);
            }

            if (!breakkeyKbnkeirisegcd.equals(kbnKeiriyousegmentCd)) {

                srHaitoukinMeisaiListDataSourceBean = setSegGokei(breakkeyKbnkeirisegcd.substring(0, 2),
                    breakkeyKbnkeirisegcd.substring(breakkeyKbnkeirisegcd.length() - 2));

                iReportDataSouceBeanList.add(srHaitoukinMeisaiListDataSourceBean);

                meisaiBlockCount = meisaiBlockCount + 1;

                if (meisaiBlockCount % 2 == 0) {

                    srHaitoukinMeisaiListDataSourceBean =
                        SWAKInjector.getInstance(SrHaitoukinMeisaiListDataSourceBean.class);

                    srHaitoukinMeisaiListDataSourceBean = setBlankBlock(breakkeyKbnkeirisegcd);

                    iReportDataSouceBeanList.add(srHaitoukinMeisaiListDataSourceBean);

                    meisaiBlockCount = meisaiBlockCount + 1;
                }

                srHaitoukinMeisaiListSubDataSourceBeanList = new ArrayList<>();

                srHaitoukinMeisaiListDataSourceBean = SWAKInjector
                    .getInstance(SrHaitoukinMeisaiListDataSourceBean.class);

                breakkeyKbnkeirisegcd = kbnKeiriyousegmentCd;
            }

            if (breakkeyKbnkeirisegcd.equals(kbnKeiriyousegmentCd) &&
                breakkeySyukeiyakusyuruicd.equals(tmttDMeisaiDataBean.getSyukeiyakusyuruicd())) {

                while (syuukeiptnkbnCount < Integer.valueOf(tmttDMeisaiDataBean.getSrhaitoukinsyuukeiptnkbn()
                    .getValue())) {

                    srHaitoukinMeisaiListSubDataSourceBeanList.add(emptyMeisaiListSubDataSourceBean);

                    syuukeiptnkbnCount = syuukeiptnkbnCount + 1;
                }
            }

            srHaitoukinMeisaiListSubDataSourceBean = setMeisai(tmttDMeisaiDataBean.getKensuu(),
                tmttDMeisaiDataBean.getHsys(), tmttDMeisaiDataBean.getZennendkurikosid(),
                tmttDMeisaiDataBean.getTumitaterisoku(), tmttDMeisaiDataBean.getTounendod(),
                tmttDMeisaiDataBean.getTndmatutumitated());

            srHaitoukinMeisaiListSubDataSourceBeanList.add(srHaitoukinMeisaiListSubDataSourceBean);

            syuukeiptnkbnCount = syuukeiptnkbnCount + 1;

            goukeiKensuu = goukeiKensuu.add(nullToZerobyBizNumber(tmttDMeisaiDataBean.getKensuu()));
            goukeihsys = goukeihsys.add(nullToZerobyBizCurrency(tmttDMeisaiDataBean.getHsys()));
            goukeizennendkurikosid = goukeizennendkurikosid.add(nullToZerobyBizCurrency(
                tmttDMeisaiDataBean.getZennendkurikosid()));
            goukeiHaitoursk = goukeiHaitoursk.add(nullToZerobyBizCurrency(tmttDMeisaiDataBean.getTumitaterisoku()));
            goukeitounendod = goukeitounendod.add(nullToZerobyBizCurrency(tmttDMeisaiDataBean.getTounendod()));
            goukeiTounendomatud = goukeiTounendomatud.add(nullToZerobyBizCurrency(
                tmttDMeisaiDataBean.getTndmatutumitated()));
        }

        while (syuukeiptnkbnCount <= SrCommonConstants.HAITOUKINSYUUKEIPTNKBN_KBNCOUNT) {

            srHaitoukinMeisaiListSubDataSourceBeanList.add(emptyMeisaiListSubDataSourceBean);

            syuukeiptnkbnCount = syuukeiptnkbnCount + 1;
        }

        srHaitoukinMeisaiListSubDataSourceBean = setMeisai(goukeiKensuu, goukeihsys, goukeizennendkurikosid,
            goukeiHaitoursk, goukeitounendod, goukeiTounendomatud);

        srHaitoukinMeisaiListSubDataSourceBeanList.add(srHaitoukinMeisaiListSubDataSourceBean);

        srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd(ConvertUtil.toZenNumeric(breakkeyKbnkeirisegcd));
        srHaitoukinMeisaiListDataSourceBean.setIrHknsyurui(SrCommonConstants.TYOUHYOUHYOUJINM_HOKENSYURUI);
        srHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd(breakkeySyukeiyakusyuruicd);
        srHaitoukinMeisaiListDataSourceBean.setSrHaitoukinmeisailistsubdatasourcebeanList(
            srHaitoukinMeisaiListSubDataSourceBeanList);

        iReportDataSouceBeanList.add(srHaitoukinMeisaiListDataSourceBean);

        meisaiBlockCount = meisaiBlockCount + 1;

        srHaitoukinMeisaiListSubDataSourceBeanList = new ArrayList<>();

        srHaitoukinMeisaiListDataSourceBean = SWAKInjector.getInstance(SrHaitoukinMeisaiListDataSourceBean.class);

        srHaitoukinMeisaiListDataSourceBean = setSegGokei(breakkeyKbnkeirisegcd.substring(0, 2),
            breakkeyKbnkeirisegcd.substring(breakkeyKbnkeirisegcd.length() - 2));

        iReportDataSouceBeanList.add(srHaitoukinMeisaiListDataSourceBean);

        meisaiBlockCount = meisaiBlockCount + 1;

        if (meisaiBlockCount % 2 == 0) {

            srHaitoukinMeisaiListDataSourceBean = new SrHaitoukinMeisaiListDataSourceBean();

            srHaitoukinMeisaiListDataSourceBean = setBlankBlock(breakkeyKbnkeirisegcd);

            iReportDataSouceBeanList.add(srHaitoukinMeisaiListDataSourceBean);

            meisaiBlockCount = meisaiBlockCount + 1;
        }

        srHaitoukinMeisaiListSubDataSourceBeanList = new ArrayList<>();

        srHaitoukinMeisaiListDataSourceBean = SWAKInjector.getInstance(SrHaitoukinMeisaiListDataSourceBean.class);

        syuukeiptnkbnCount = SrCommonConstants.DEFAULT_INT_ITI;
        goukeiKensuu = BizNumber.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        goukeihsys = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        goukeizennendkurikosid = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        goukeiHaitoursk = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        goukeitounendod = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        goukeiTounendomatud = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);

        List<TmttDMeisaiDataBean> tmtthtkinZensyuDataBeanList = srTmttDMeisaiListSksDao
            .getTmttDZensyuGoukei(kijyunYM, kakutyoujobcd);

        for (TmttDMeisaiDataBean tmtthtkinZensyuDataBean : tmtthtkinZensyuDataBeanList) {

            while (syuukeiptnkbnCount < Integer.valueOf(tmtthtkinZensyuDataBean.getSrhaitoukinsyuukeiptnkbn()
                .getValue())) {

                srHaitoukinMeisaiListSubDataSourceBeanList.add(emptyMeisaiListSubDataSourceBean);

                syuukeiptnkbnCount = syuukeiptnkbnCount + 1;
            }

            srHaitoukinMeisaiListSubDataSourceBean = setMeisai(tmtthtkinZensyuDataBean.getKensuu(),
                tmtthtkinZensyuDataBean.getHsys(), tmtthtkinZensyuDataBean.getZennendkurikosid(),
                tmtthtkinZensyuDataBean.getTumitaterisoku(), tmtthtkinZensyuDataBean.getTounendod(),
                tmtthtkinZensyuDataBean.getTndmatutumitated());

            srHaitoukinMeisaiListSubDataSourceBeanList.add(srHaitoukinMeisaiListSubDataSourceBean);

            syuukeiptnkbnCount = syuukeiptnkbnCount + 1;

            goukeiKensuu = goukeiKensuu.add(nullToZerobyBizNumber(tmtthtkinZensyuDataBean.getKensuu()));
            goukeihsys = goukeihsys.add(nullToZerobyBizCurrency(tmtthtkinZensyuDataBean.getHsys()));
            goukeizennendkurikosid = goukeizennendkurikosid.add(
                nullToZerobyBizCurrency(tmtthtkinZensyuDataBean.getZennendkurikosid()));
            goukeiHaitoursk = goukeiHaitoursk.add(nullToZerobyBizCurrency(tmtthtkinZensyuDataBean.getTumitaterisoku()));
            goukeitounendod = goukeitounendod.add(nullToZerobyBizCurrency(tmtthtkinZensyuDataBean.getTounendod()));
            goukeiTounendomatud = goukeiTounendomatud.add(
                nullToZerobyBizCurrency(tmtthtkinZensyuDataBean.getTndmatutumitated()));
        }

        while (syuukeiptnkbnCount <= SrCommonConstants.HAITOUKINSYUUKEIPTNKBN_KBNCOUNT) {

            srHaitoukinMeisaiListSubDataSourceBeanList.add(emptyMeisaiListSubDataSourceBean);

            syuukeiptnkbnCount = syuukeiptnkbnCount + 1;
        }

        srHaitoukinMeisaiListSubDataSourceBean = setMeisai(goukeiKensuu, goukeihsys, goukeizennendkurikosid,
            goukeiHaitoursk, goukeitounendod, goukeiTounendomatud);

        srHaitoukinMeisaiListSubDataSourceBeanList.add(srHaitoukinMeisaiListSubDataSourceBean);

        srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd(SrCommonConstants.TYOUHYOUHYOUJINM_ZENSYUGOUKEI);
        srHaitoukinMeisaiListDataSourceBean.setIrHknsyurui("");
        srHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd("");
        srHaitoukinMeisaiListDataSourceBean.setSrHaitoukinmeisailistsubdatasourcebeanList(
            srHaitoukinMeisaiListSubDataSourceBeanList);

        iReportDataSouceBeanList.add(srHaitoukinMeisaiListDataSourceBean);

        meisaiBlockCount = meisaiBlockCount + 1;

        if (meisaiBlockCount % 2 == 0) {

            srHaitoukinMeisaiListDataSourceBean = SWAKInjector.getInstance(SrHaitoukinMeisaiListDataSourceBean.class);

            srHaitoukinMeisaiListDataSourceBean = setBlankBlock(SrCommonConstants.TYOUHYOUHYOUJINM_ZENSYUGOUKEI);

            iReportDataSouceBeanList.add(srHaitoukinMeisaiListDataSourceBean);
        }

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(kinou.getSubSystemId(),
            kinou.getCategoryId(), kinou.getKinouId(), C_SyoruiCdKbn.SR_TMTTDMEISAILIST);

        reportServicesBean.setSyoriYmd(syoriYmd);

        reportServicesBean.addParamObjects(iReportDataSouceBeanList, srHaitoukinMeisaiListBean);

        createReport.exec(reportServicesBean);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(goukeiKensuu),
            "積立配当金明細リスト"));
    }

    private SrHaitoukinMeisaiListSubDataSourceBean setMeisai(BizNumber pKensuu, BizCurrency pHsys,
        BizCurrency pZennendkurikosid, BizCurrency pHaitoursk, BizCurrency pTounendod, BizCurrency pTounendomatud) {

        SrHaitoukinMeisaiListSubDataSourceBean srHaitoukinMeisaiListSubDataSourceBean =
            SWAKInjector.getInstance(SrHaitoukinMeisaiListSubDataSourceBean.class);

        srHaitoukinMeisaiListSubDataSourceBean.setIrKensuu(zeroToNullbyBizNumber(pKensuu));
        srHaitoukinMeisaiListSubDataSourceBean.setIrHsys(zeroToNullbyBizCurrency(pHsys));
        srHaitoukinMeisaiListSubDataSourceBean.setIrZennendokurikosid(zeroToNullbyBizCurrency(pZennendkurikosid));
        srHaitoukinMeisaiListSubDataSourceBean.setIrHaitoursk(zeroToNullbyBizCurrency(pHaitoursk));
        srHaitoukinMeisaiListSubDataSourceBean.setIrTounendod(zeroToNullbyBizCurrency(pTounendod));
        srHaitoukinMeisaiListSubDataSourceBean.setIrTounendomatud(zeroToNullbyBizCurrency(pTounendomatud));

        return srHaitoukinMeisaiListSubDataSourceBean;
    }

    private SrHaitoukinMeisaiListDataSourceBean setBlankBlock(String pKbnkeirisegcd) {

        SrHaitoukinMeisaiListDataSourceBean srHaitoukinMeisaiListDataSourceBean =
            SWAKInjector.getInstance(SrHaitoukinMeisaiListDataSourceBean.class);

        List<SrHaitoukinMeisaiListSubDataSourceBean> srHaitoukinMeisaiListDataSourceBeanList = new ArrayList<>();

        int count = SrCommonConstants.DEFAULT_INT_ZERO;

        while (count <= SrCommonConstants.HAITOUKINSYUUKEIPTNKBN_KBNCOUNT) {

            srHaitoukinMeisaiListDataSourceBeanList.add(emptyMeisaiListSubDataSourceBean);

            count = count + 1;
        }

        srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd(ConvertUtil.toZenNumeric(pKbnkeirisegcd));
        srHaitoukinMeisaiListDataSourceBean.setIrHknsyurui("");
        srHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd("");
        srHaitoukinMeisaiListDataSourceBean.setSrHaitoukinmeisailistsubdatasourcebeanList(
            srHaitoukinMeisaiListDataSourceBeanList);

        return srHaitoukinMeisaiListDataSourceBean;
    }

    private SrHaitoukinMeisaiListDataSourceBean setSegGokei(String pKbnkeiriyousegmentkbn,
        String pKbnkeiriyourgnbnskkbn) {

        SrHaitoukinMeisaiListDataSourceBean srHaitoukinMeisaiListDataSourceBean =
            SWAKInjector.getInstance(SrHaitoukinMeisaiListDataSourceBean.class);

        List<SrHaitoukinMeisaiListSubDataSourceBean> srHaitoukinMeisaiListSubDataSourceBeanList = new ArrayList<>();

        SrHaitoukinMeisaiListSubDataSourceBean srHaitoukinMeisaiListSubDataSourceBean =
            SWAKInjector.getInstance(SrHaitoukinMeisaiListSubDataSourceBean.class);

        int syuukeiptnkbnCount = SrCommonConstants.DEFAULT_INT_ITI;
        BizNumber goukeiKensuu = BizNumber.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        BizCurrency goukeihsys = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        BizCurrency goukeizennendkurikosid = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        BizCurrency goukeiHaitoursk = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        BizCurrency goukeitounendod = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        BizCurrency goukeiTounendomatud = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);

        List<TmttDMeisaiDataBean> tmttDSegcdDataBeanList = srTmttDMeisaiListSksDao.getTmttDSegmentGoukei(
            kijyunYM, kakutyoujobcd, pKbnkeiriyousegmentkbn, pKbnkeiriyourgnbnskkbn);

        for (TmttDMeisaiDataBean tmttDSegcdDataBean : tmttDSegcdDataBeanList) {

            while (syuukeiptnkbnCount < Integer.valueOf(tmttDSegcdDataBean.getSrhaitoukinsyuukeiptnkbn().getValue())) {

                srHaitoukinMeisaiListSubDataSourceBeanList.add(emptyMeisaiListSubDataSourceBean);

                syuukeiptnkbnCount = syuukeiptnkbnCount + 1;
            }

            srHaitoukinMeisaiListSubDataSourceBean = setMeisai(tmttDSegcdDataBean.getKensuu(),
                tmttDSegcdDataBean.getHsys(), tmttDSegcdDataBean.getZennendkurikosid(),
                tmttDSegcdDataBean.getTumitaterisoku(), tmttDSegcdDataBean.getTounendod(),
                tmttDSegcdDataBean.getTndmatutumitated());

            srHaitoukinMeisaiListSubDataSourceBeanList.add(srHaitoukinMeisaiListSubDataSourceBean);

            syuukeiptnkbnCount = syuukeiptnkbnCount + 1;

            goukeiKensuu = goukeiKensuu.add(nullToZerobyBizNumber(tmttDSegcdDataBean.getKensuu()));
            goukeihsys = goukeihsys.add(nullToZerobyBizCurrency(tmttDSegcdDataBean.getHsys()));
            goukeizennendkurikosid = goukeizennendkurikosid.add(
                nullToZerobyBizCurrency(tmttDSegcdDataBean.getZennendkurikosid()));
            goukeiHaitoursk = goukeiHaitoursk.add(nullToZerobyBizCurrency(tmttDSegcdDataBean.getTumitaterisoku()));
            goukeitounendod = goukeitounendod.add(nullToZerobyBizCurrency(tmttDSegcdDataBean.getTounendod()));
            goukeiTounendomatud = goukeiTounendomatud.add(
                nullToZerobyBizCurrency(tmttDSegcdDataBean.getTndmatutumitated()));
        }

        while (syuukeiptnkbnCount <= SrCommonConstants.HAITOUKINSYUUKEIPTNKBN_KBNCOUNT) {

            srHaitoukinMeisaiListSubDataSourceBeanList.add(emptyMeisaiListSubDataSourceBean);

            syuukeiptnkbnCount = syuukeiptnkbnCount + 1;
        }

        srHaitoukinMeisaiListSubDataSourceBean = setMeisai(goukeiKensuu, goukeihsys, goukeizennendkurikosid,
            goukeiHaitoursk, goukeitounendod, goukeiTounendomatud);

        srHaitoukinMeisaiListSubDataSourceBeanList.add(srHaitoukinMeisaiListSubDataSourceBean);

        srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd(ConvertUtil.toZenNumeric(pKbnkeiriyousegmentkbn + pKbnkeiriyourgnbnskkbn));
        srHaitoukinMeisaiListDataSourceBean.setIrHknsyurui(SrCommonConstants.TYOUHYOUHYOUJINM_GOUKEI);
        srHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd("");
        srHaitoukinMeisaiListDataSourceBean.setSrHaitoukinmeisailistsubdatasourcebeanList(
            srHaitoukinMeisaiListSubDataSourceBeanList);

        return srHaitoukinMeisaiListDataSourceBean;
    }

    private Integer zeroToNullbyBizNumber(BizNumber pBizNumber) {

        if (pBizNumber == null ||
            pBizNumber.compareTo(BizNumber.valueOf(0)) == 0) {

            return null;
        }

        return Integer.valueOf(pBizNumber.toString());
    }

    private BizCurrency zeroToNullbyBizCurrency(BizCurrency pBizCurrency) {

        if (pBizCurrency == null ||
            pBizCurrency.compareTo(BizCurrency.valueOf(0, pBizCurrency.getType())) == 0) {

            return null;
        }

        return pBizCurrency;
    }

    private BizNumber nullToZerobyBizNumber(BizNumber pBizNumber) {

        if (pBizNumber == null) {

            return BizNumber.valueOf(0);
        }

        return pBizNumber;
    }

    private BizCurrency nullToZerobyBizCurrency(BizCurrency pBizCurrency) {

        if (pBizCurrency == null) {

            return BizCurrency.valueOf(0);
        }

        return pBizCurrency;
    }
}
