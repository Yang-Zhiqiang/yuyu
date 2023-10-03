package yuyu.batch.suuri.srsuuritoukei.srkbnkeiriyoutmttdmeisailistsks;

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
import yuyu.batch.suuri.srsuuritoukei.srkbnkeiriyoutmttdmeisailistsks.dba.KbnKeiriyouTmttDMeisaiDataBean;
import yuyu.batch.suuri.srsuuritoukei.srkbnkeiriyoutmttdmeisailistsks.dba.SrKbnKeiriyouTmttDMeisaiListSksDao;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.def.MessageId;
import yuyu.def.classification.C_Segcd;
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
 * 数理統計 数理統計 区分経理用積立配当金明細リスト作成クラス
 */
public class SrKbnKeiriyouTmttDMeisaiListSksBatch implements Batch{

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SrKbnKeiriyouTmttDMeisaiListSksBatchParam batchParam;

    @Inject
    private SrKbnKeiriyouTmttDMeisaiListSksDao srKbnKeiriyouTmttDMeisaiListSksDao;

    @Inject
    private CreateReport createReport;

    @Inject
    private AS_Kinou kinou;

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

        if (SrKbnKeiriyouTmttDMeisaiListSksBatchParam.RGKNM002.equals(batchParam.getIbKakutyoujobcd())) {

            kakutyoujobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN2_YUUKOUKYKHTJYNBKNDATA;

        }
        else if (SrKbnKeiriyouTmttDMeisaiListSksBatchParam.RGKNM004.equals(batchParam.getIbKakutyoujobcd())) {

            kakutyoujobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIHONBAN_YUUKOUKYKHTJYNBKNDATA;
        }

        kijyunYM = batchParam.getKijyunymd().getBizDateYM().toString();

        List<KbnKeiriyouTmttDMeisaiDataBean> kbnKeiriyouTmttDMeisaiDataBeanList = srKbnKeiriyouTmttDMeisaiListSksDao
            .getKbnKeiriyouTmttDMeisai(kijyunYM, kakutyoujobcd);


        if (kbnKeiriyouTmttDMeisaiDataBeanList.size() == 0) {

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(kbnKeiriyouTmttDMeisaiDataBeanList.size()),
                "区分経理用積立配当金明細リスト"));

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
        int syuukeiptnkbnCount = SrCommonConstants.DEFAULT_INT_ITI;
        int meisaiBlockCount = SrCommonConstants.DEFAULT_INT_ITI;
        BizNumber goukeiKensuu = BizNumber.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        BizCurrency goukeiHsys = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        BizCurrency goukeiZennendkurikosid = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        BizCurrency goukeiHaitoursk = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        BizCurrency goukeiTounendod = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        BizCurrency goukeiTounendomatud = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);

        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);

        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(SrCommonConstants.SOSIKICD_SYUNOSERVICESITU);

        if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {

            String atesakibukanm = ViewReport.editOntyuu(bzGetSosikiDataBean.getKanjisosikinm20());

            srHaitoukinMeisaiListBean.setIrAtesakibukanm(atesakibukanm);
        }

        srHaitoukinMeisaiListBean.setIrSyoriymd(DateFormatUtil.dateKANJI(syoriYmd));

        srHaitoukinMeisaiListBean.setIrHozonkkn(ViewReport.getHozonKknTani(C_SyoruiCdKbn.SR_KBNKEIRIYOUTMTTDMEISAILIST));

        for (int n = 0; n < kbnKeiriyouTmttDMeisaiDataBeanList.size(); n++) {

            KbnKeiriyouTmttDMeisaiDataBean kbnKeiriyouTmttDMeisaiDataBean = kbnKeiriyouTmttDMeisaiDataBeanList.get(n);

            if (n == 0) {

                breakkeyKbnkeirisegcd = kbnKeiriyouTmttDMeisaiDataBean.getKbnkeiriyousegmentkbn()
                    + kbnKeiriyouTmttDMeisaiDataBean.getKbnkeiriyourgnbnskkbn();
            }

            if (!breakkeyKbnkeirisegcd.equals(kbnKeiriyouTmttDMeisaiDataBean.getKbnkeiriyousegmentkbn()
                + kbnKeiriyouTmttDMeisaiDataBean.getKbnkeiriyourgnbnskkbn())) {

                while (syuukeiptnkbnCount <= SrCommonConstants.HAITOUKINSYUUKEIPTNKBN_KBNCOUNT) {

                    srHaitoukinMeisaiListSubDataSourceBeanList.add(emptyMeisaiListSubDataSourceBean);

                    syuukeiptnkbnCount = syuukeiptnkbnCount + 1;
                }

                srHaitoukinMeisaiListSubDataSourceBean = setMeisai(goukeiKensuu, goukeiHsys, goukeiZennendkurikosid,
                    goukeiHaitoursk, goukeiTounendod, goukeiTounendomatud);

                srHaitoukinMeisaiListSubDataSourceBeanList.add(srHaitoukinMeisaiListSubDataSourceBean);

                srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd(ConvertUtil.toZenNumeric(breakkeyKbnkeirisegcd));
                srHaitoukinMeisaiListDataSourceBean.setIrSeg(C_Segcd.valueOf(breakkeyKbnkeirisegcd).getContent());

                srHaitoukinMeisaiListDataSourceBean.setSrHaitoukinmeisailistsubdatasourcebeanList(
                    srHaitoukinMeisaiListSubDataSourceBeanList);

                iReportDataSouceBeanList.add(srHaitoukinMeisaiListDataSourceBean);

                meisaiBlockCount = meisaiBlockCount + 1;
                syuukeiptnkbnCount = SrCommonConstants.DEFAULT_INT_ITI;
                goukeiKensuu = BizNumber.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
                goukeiHsys = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
                goukeiZennendkurikosid = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
                goukeiHaitoursk = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
                goukeiTounendod = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
                goukeiTounendomatud = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);

                srHaitoukinMeisaiListSubDataSourceBeanList = new ArrayList<>();
                srHaitoukinMeisaiListDataSourceBean = SWAKInjector
                    .getInstance(SrHaitoukinMeisaiListDataSourceBean.class);

                breakkeyKbnkeirisegcd = kbnKeiriyouTmttDMeisaiDataBean.getKbnkeiriyousegmentkbn()
                    + kbnKeiriyouTmttDMeisaiDataBean.getKbnkeiriyourgnbnskkbn();
            }
            if (breakkeyKbnkeirisegcd.equals(kbnKeiriyouTmttDMeisaiDataBean.getKbnkeiriyousegmentkbn()
                + kbnKeiriyouTmttDMeisaiDataBean.getKbnkeiriyourgnbnskkbn())) {

                while (syuukeiptnkbnCount < Integer.valueOf(kbnKeiriyouTmttDMeisaiDataBean.getSrhaitoukinsyuukeiptnkbn()
                    .getValue())) {

                    srHaitoukinMeisaiListSubDataSourceBeanList.add(emptyMeisaiListSubDataSourceBean);

                    syuukeiptnkbnCount = syuukeiptnkbnCount + 1;
                }
            }

            srHaitoukinMeisaiListSubDataSourceBean = setMeisai(kbnKeiriyouTmttDMeisaiDataBean.getKensuu(),
                kbnKeiriyouTmttDMeisaiDataBean.getHsys(), kbnKeiriyouTmttDMeisaiDataBean.getZennendkurikosid(),
                kbnKeiriyouTmttDMeisaiDataBean.getTumitaterisoku(), kbnKeiriyouTmttDMeisaiDataBean.getTounendod(),
                kbnKeiriyouTmttDMeisaiDataBean.getTndmatutumitated());

            srHaitoukinMeisaiListSubDataSourceBeanList.add(srHaitoukinMeisaiListSubDataSourceBean);

            syuukeiptnkbnCount = syuukeiptnkbnCount + 1;

            goukeiKensuu = goukeiKensuu.add(nullToZerobyBizNumber(kbnKeiriyouTmttDMeisaiDataBean.getKensuu()));
            goukeiHsys = goukeiHsys.add(nullToZerobyBizCurrency(kbnKeiriyouTmttDMeisaiDataBean.getHsys()));
            goukeiZennendkurikosid = goukeiZennendkurikosid.add(nullToZerobyBizCurrency(
                kbnKeiriyouTmttDMeisaiDataBean.getZennendkurikosid()));
            goukeiHaitoursk = goukeiHaitoursk.add(nullToZerobyBizCurrency(kbnKeiriyouTmttDMeisaiDataBean.getTumitaterisoku()));
            goukeiTounendod = goukeiTounendod.add(nullToZerobyBizCurrency(kbnKeiriyouTmttDMeisaiDataBean.getTounendod()));
            goukeiTounendomatud = goukeiTounendomatud.add(nullToZerobyBizCurrency(
                kbnKeiriyouTmttDMeisaiDataBean.getTndmatutumitated()));
        }

        while (syuukeiptnkbnCount <= SrCommonConstants.HAITOUKINSYUUKEIPTNKBN_KBNCOUNT) {

            srHaitoukinMeisaiListSubDataSourceBeanList.add(emptyMeisaiListSubDataSourceBean);

            syuukeiptnkbnCount = syuukeiptnkbnCount + 1;
        }

        srHaitoukinMeisaiListSubDataSourceBean = setMeisai(goukeiKensuu, goukeiHsys, goukeiZennendkurikosid,
            goukeiHaitoursk, goukeiTounendod, goukeiTounendomatud);

        srHaitoukinMeisaiListSubDataSourceBeanList.add(srHaitoukinMeisaiListSubDataSourceBean);

        srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd(ConvertUtil.toZenNumeric(breakkeyKbnkeirisegcd));
        srHaitoukinMeisaiListDataSourceBean.setIrSeg(C_Segcd.valueOf(breakkeyKbnkeirisegcd).getContent());

        srHaitoukinMeisaiListDataSourceBean.setSrHaitoukinmeisailistsubdatasourcebeanList(
            srHaitoukinMeisaiListSubDataSourceBeanList);

        iReportDataSouceBeanList.add(srHaitoukinMeisaiListDataSourceBean);

        meisaiBlockCount = meisaiBlockCount + 1;

        srHaitoukinMeisaiListSubDataSourceBeanList = new ArrayList<>();

        srHaitoukinMeisaiListDataSourceBean = SWAKInjector.getInstance(SrHaitoukinMeisaiListDataSourceBean.class);

        if (meisaiBlockCount % 2 == 0){

            srHaitoukinMeisaiListDataSourceBean = SWAKInjector.getInstance(SrHaitoukinMeisaiListDataSourceBean.class);

            srHaitoukinMeisaiListDataSourceBean = setBlankBlock();

            iReportDataSouceBeanList.add(srHaitoukinMeisaiListDataSourceBean);

            meisaiBlockCount = meisaiBlockCount + 1;
        }

        srHaitoukinMeisaiListSubDataSourceBeanList = new ArrayList<>();
        srHaitoukinMeisaiListDataSourceBean = SWAKInjector.getInstance(SrHaitoukinMeisaiListDataSourceBean.class);

        syuukeiptnkbnCount = SrCommonConstants.DEFAULT_INT_ITI;
        goukeiKensuu = BizNumber.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        goukeiHsys = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        goukeiZennendkurikosid = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        goukeiHaitoursk = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        goukeiTounendod = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        goukeiTounendomatud = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);

        List<KbnKeiriyouTmttDMeisaiDataBean> kbnKeiriyouTmttZensyuDataBeanList = srKbnKeiriyouTmttDMeisaiListSksDao
            .getKbnKeiriyouTmttDZensyuGoukei(kijyunYM, kakutyoujobcd);

        for (KbnKeiriyouTmttDMeisaiDataBean kbnKeiriyouTmttZensyuDataBean : kbnKeiriyouTmttZensyuDataBeanList) {

            while (syuukeiptnkbnCount < Integer.valueOf(kbnKeiriyouTmttZensyuDataBean.getSrhaitoukinsyuukeiptnkbn()
                .getValue())) {

                srHaitoukinMeisaiListSubDataSourceBeanList.add(emptyMeisaiListSubDataSourceBean);

                syuukeiptnkbnCount = syuukeiptnkbnCount + 1;
            }

            srHaitoukinMeisaiListSubDataSourceBean = setMeisai(kbnKeiriyouTmttZensyuDataBean.getKensuu(),
                kbnKeiriyouTmttZensyuDataBean.getHsys(), kbnKeiriyouTmttZensyuDataBean.getZennendkurikosid(),
                kbnKeiriyouTmttZensyuDataBean.getTumitaterisoku(), kbnKeiriyouTmttZensyuDataBean.getTounendod(),
                kbnKeiriyouTmttZensyuDataBean.getTndmatutumitated());

            srHaitoukinMeisaiListSubDataSourceBeanList.add(srHaitoukinMeisaiListSubDataSourceBean);

            syuukeiptnkbnCount = syuukeiptnkbnCount + 1;

            goukeiKensuu = goukeiKensuu.add(nullToZerobyBizNumber(kbnKeiriyouTmttZensyuDataBean.getKensuu()));
            goukeiHsys = goukeiHsys.add(nullToZerobyBizCurrency(kbnKeiriyouTmttZensyuDataBean.getHsys()));
            goukeiZennendkurikosid = goukeiZennendkurikosid.add(nullToZerobyBizCurrency(
                kbnKeiriyouTmttZensyuDataBean.getZennendkurikosid()));
            goukeiHaitoursk = goukeiHaitoursk.add(nullToZerobyBizCurrency(kbnKeiriyouTmttZensyuDataBean.getTumitaterisoku()));
            goukeiTounendod = goukeiTounendod.add(nullToZerobyBizCurrency(kbnKeiriyouTmttZensyuDataBean.getTounendod()));
            goukeiTounendomatud = goukeiTounendomatud.add(nullToZerobyBizCurrency(
                kbnKeiriyouTmttZensyuDataBean.getTndmatutumitated()));
        }

        while (syuukeiptnkbnCount <= SrCommonConstants.HAITOUKINSYUUKEIPTNKBN_KBNCOUNT) {

            srHaitoukinMeisaiListSubDataSourceBeanList.add(emptyMeisaiListSubDataSourceBean);

            syuukeiptnkbnCount = syuukeiptnkbnCount + 1;
        }

        srHaitoukinMeisaiListSubDataSourceBean = setMeisai(goukeiKensuu, goukeiHsys, goukeiZennendkurikosid,
            goukeiHaitoursk, goukeiTounendod, goukeiTounendomatud);

        srHaitoukinMeisaiListSubDataSourceBeanList.add(srHaitoukinMeisaiListSubDataSourceBean);

        srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd("");
        srHaitoukinMeisaiListDataSourceBean.setIrSeg(SrCommonConstants.TYOUHYOUHYOUJINM_ZENSYUGOUKEI);
        srHaitoukinMeisaiListDataSourceBean.setSrHaitoukinmeisailistsubdatasourcebeanList(
            srHaitoukinMeisaiListSubDataSourceBeanList);

        iReportDataSouceBeanList.add(srHaitoukinMeisaiListDataSourceBean);

        srHaitoukinMeisaiListDataSourceBean = new SrHaitoukinMeisaiListDataSourceBean();

        srHaitoukinMeisaiListDataSourceBean = setBlankBlock();

        iReportDataSouceBeanList.add(srHaitoukinMeisaiListDataSourceBean);

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(kinou.getSubSystemId(),
            kinou.getCategoryId(), kinou.getKinouId(), C_SyoruiCdKbn.SR_KBNKEIRIYOUTMTTDMEISAILIST);

        reportServicesBean.setSyoriYmd(syoriYmd);

        reportServicesBean.addParamObjects(iReportDataSouceBeanList, srHaitoukinMeisaiListBean);

        createReport.exec(reportServicesBean);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(goukeiKensuu),
            "区分経理用積立配当金明細リスト"));
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

    private SrHaitoukinMeisaiListDataSourceBean setBlankBlock() {

        SrHaitoukinMeisaiListDataSourceBean srHaitoukinMeisaiListDataSourceBean =
            SWAKInjector.getInstance(SrHaitoukinMeisaiListDataSourceBean.class);

        List<SrHaitoukinMeisaiListSubDataSourceBean> srHaitoukinMeisaiListDataSourceBeanList = new ArrayList<>();

        int count = SrCommonConstants.DEFAULT_INT_ZERO;

        while (count <= SrCommonConstants.HAITOUKINSYUUKEIPTNKBN_KBNCOUNT) {

            srHaitoukinMeisaiListDataSourceBeanList.add(emptyMeisaiListSubDataSourceBean);

            count = count + 1;
        }

        srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd("");
        srHaitoukinMeisaiListDataSourceBean.setIrSeg("");
        srHaitoukinMeisaiListDataSourceBean.setSrHaitoukinmeisailistsubdatasourcebeanList(
            srHaitoukinMeisaiListDataSourceBeanList);

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
