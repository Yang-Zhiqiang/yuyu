package yuyu.batch.suuri.srsuuritoukei.srkariwariatedmeisailistsks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.batch.suuri.srsuuritoukei.srkariwariatedmeisailistsks.dba.KariDMeisaiDataBean;
import yuyu.batch.suuri.srsuuritoukei.srkariwariatedmeisailistsks.dba.SrKariwariateDMeisaiListSksDao;
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
 * 数理 数理統計 仮割当配当金明細リスト作成クラス
 */
public class SrKariwariateDMeisaiListSksBatch implements Batch {

    private String kakutyoujobcd = "";

    private String kijyunym = "";

    private SrHaitoukinMeisaiListSubDataSourceBean emptyMeisaiyouSubDSBean = null;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SrKariwariateDMeisaiListSksBatchParam batchParam;

    @Inject
    private SrKariwariateDMeisaiListSksDao srKariwariateDMeisaiListSksDao;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(batchParam.getSyoriYmd())));

        if (SrKariwariateDMeisaiListSksBatchParam.RGKPM002.equals(batchParam.getIbKakutyoujobcd())) {
            kakutyoujobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN2_YUUKOUKYKHTJYNBKNDATA;
        }
        else if (SrKariwariateDMeisaiListSksBatchParam.RGKPM004.equals(batchParam.getIbKakutyoujobcd())) {
            kakutyoujobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIHONBAN_YUUKOUKYKHTJYNBKNDATA;
        }

        kijyunym = batchParam.getKijyunymd().getBizDateYM().toString();

        List<KariDMeisaiDataBean> kariDMeisaiDataBeanList = srKariwariateDMeisaiListSksDao.getKariDMeisai(kijyunym,
            kakutyoujobcd);

        if (kariDMeisaiDataBeanList.size() == 0) {
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(kariDMeisaiDataBeanList.size()),
                "仮割当配当金明細リスト"));
            return;
        }

        List<IReportDataSouceBean> reportList = new ArrayList<>();
        SrHaitoukinMeisaiListBean srHaitoukinMeisaiListBean = SWAKInjector.getInstance(SrHaitoukinMeisaiListBean.class);
        SrHaitoukinMeisaiListDataSourceBean srHaitoukinMeisaiListDataSourceBean = SWAKInjector
            .getInstance(SrHaitoukinMeisaiListDataSourceBean.class);
        List<SrHaitoukinMeisaiListSubDataSourceBean> srHaitoukinMeisaiListSubDSBeanList = new ArrayList<>();
        SrHaitoukinMeisaiListSubDataSourceBean srHaitoukinMeisaiListSubDSBean = SWAKInjector
            .getInstance(SrHaitoukinMeisaiListSubDataSourceBean.class);
        emptyMeisaiyouSubDSBean = SWAKInjector.getInstance(SrHaitoukinMeisaiListSubDataSourceBean.class);
        String kbnkeiriyousegmentkbn = "";
        String syukeiyakusyuruicd = "";
        int syuukeiptnkbnCount = SrCommonConstants.DEFAULT_INT_ITI;
        int meisaiBlockCount = SrCommonConstants.DEFAULT_INT_ITI;

        BizNumber goukeiKensuu = BizNumber.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        BizCurrency goukeiHsys = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        BizCurrency goukeiZnnndkrkskrwratdruigk = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        BizCurrency goukeiKariwariatedrisoku = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        BizCurrency goukeiTounendokariwariated = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        BizCurrency goukeiTndmatukrkskrwratdruigk = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);

        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);
        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(SrCommonConstants.SOSIKICD_SYUNOSERVICESITU);

        if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {

            String atesakibukanm = ViewReport.editOntyuu(bzGetSosikiDataBean.getKanjisosikinm20());

            srHaitoukinMeisaiListBean.setIrAtesakibukanm(atesakibukanm);
        }

        srHaitoukinMeisaiListBean.setIrSyoriymd(DateFormatUtil.dateKANJI(batchParam.getSyoriYmd()));
        srHaitoukinMeisaiListBean.setIrHozonkkn(ViewReport.getHozonKknTani(C_SyoruiCdKbn.SR_KARIWARIATEDMEISAILIS));

        for (int n = 0; n < kariDMeisaiDataBeanList.size(); n++) {
            KariDMeisaiDataBean kariDMeisaiDataBean = kariDMeisaiDataBeanList.get(n);

            if (n == 0) {
                kbnkeiriyousegmentkbn = kariDMeisaiDataBean.getKbnkeiriyousegmentkbn()
                    + kariDMeisaiDataBean.getKbnkeiriyourgnbnskkbn();
                syukeiyakusyuruicd = kariDMeisaiDataBean.getSyukeiyakusyuruicd();
            }

            if (!kbnkeiriyousegmentkbn.equals(kariDMeisaiDataBean.getKbnkeiriyousegmentkbn()
                + kariDMeisaiDataBean.getKbnkeiriyourgnbnskkbn())
                || !syukeiyakusyuruicd.equals(kariDMeisaiDataBean.getSyukeiyakusyuruicd())) {

                while (syuukeiptnkbnCount <= SrCommonConstants.HAITOUKINSYUUKEIPTNKBN_KBNCOUNT) {
                    srHaitoukinMeisaiListSubDSBeanList.add(emptyMeisaiyouSubDSBean);
                    syuukeiptnkbnCount++;
                }

                srHaitoukinMeisaiListSubDSBean = createMeisai(goukeiKensuu,
                    goukeiHsys,
                    goukeiZnnndkrkskrwratdruigk,
                    goukeiKariwariatedrisoku,
                    goukeiTounendokariwariated,
                    goukeiTndmatukrkskrwratdruigk);

                srHaitoukinMeisaiListSubDSBeanList.add(srHaitoukinMeisaiListSubDSBean);

                srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd(ConvertUtil.toZenNumeric(kbnkeiriyousegmentkbn));
                srHaitoukinMeisaiListDataSourceBean.setIrHknsyurui(SrCommonConstants.TYOUHYOUHYOUJINM_HOKENSYURUI);
                srHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd(syukeiyakusyuruicd);
                srHaitoukinMeisaiListDataSourceBean
                .setSrHaitoukinmeisailistsubdatasourcebeanList(srHaitoukinMeisaiListSubDSBeanList);

                reportList.add(srHaitoukinMeisaiListDataSourceBean);

                meisaiBlockCount++;
                syukeiyakusyuruicd = kariDMeisaiDataBean.getSyukeiyakusyuruicd();
                syuukeiptnkbnCount = SrCommonConstants.DEFAULT_INT_ITI;
                goukeiKensuu = BizNumber.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
                goukeiHsys = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
                goukeiZnnndkrkskrwratdruigk = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
                goukeiKariwariatedrisoku = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
                goukeiTounendokariwariated = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
                goukeiTndmatukrkskrwratdruigk = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
                srHaitoukinMeisaiListSubDSBeanList = new ArrayList<>();
                srHaitoukinMeisaiListDataSourceBean = SWAKInjector
                    .getInstance(SrHaitoukinMeisaiListDataSourceBean.class);
            }

            if (!kbnkeiriyousegmentkbn.equals(kariDMeisaiDataBean.getKbnkeiriyousegmentkbn()
                + kariDMeisaiDataBean.getKbnkeiriyourgnbnskkbn())) {
                srHaitoukinMeisaiListDataSourceBean = createSeggoukei(kbnkeiriyousegmentkbn.substring(0, 2),
                    kbnkeiriyousegmentkbn.substring(kbnkeiriyousegmentkbn.length() - 2));

                reportList.add(srHaitoukinMeisaiListDataSourceBean);

                meisaiBlockCount++;

                if (meisaiBlockCount % 2 == 0) {
                    srHaitoukinMeisaiListDataSourceBean = SWAKInjector
                        .getInstance(SrHaitoukinMeisaiListDataSourceBean.class);

                    srHaitoukinMeisaiListDataSourceBean = createEmptyBlock(kbnkeiriyousegmentkbn);

                    reportList.add(srHaitoukinMeisaiListDataSourceBean);

                    meisaiBlockCount++;
                }

                srHaitoukinMeisaiListSubDSBeanList = new ArrayList<>();
                srHaitoukinMeisaiListDataSourceBean = SWAKInjector
                    .getInstance(SrHaitoukinMeisaiListDataSourceBean.class);
                kbnkeiriyousegmentkbn = kariDMeisaiDataBean.getKbnkeiriyousegmentkbn()
                    + kariDMeisaiDataBean.getKbnkeiriyourgnbnskkbn();
            }

            if (kbnkeiriyousegmentkbn.equals(kariDMeisaiDataBean.getKbnkeiriyousegmentkbn()
                + kariDMeisaiDataBean.getKbnkeiriyourgnbnskkbn())
                && syukeiyakusyuruicd.equals(kariDMeisaiDataBean.getSyukeiyakusyuruicd())) {
                while (syuukeiptnkbnCount < Integer.valueOf(kariDMeisaiDataBean.getSrhaitoukinsyuukeiptnkbn()
                    .getValue())) {
                    srHaitoukinMeisaiListSubDSBeanList.add(emptyMeisaiyouSubDSBean);
                    syuukeiptnkbnCount++;
                }
            }

            srHaitoukinMeisaiListSubDSBean = createMeisai(kariDMeisaiDataBean.getKensuu(),
                kariDMeisaiDataBean.getHsys(),
                kariDMeisaiDataBean.getZnnndkrkskrwratdruigk(),
                kariDMeisaiDataBean.getKariwariatedrisoku(),
                kariDMeisaiDataBean.getTounendokariwariated(),
                kariDMeisaiDataBean.getTndmatukrkskrwratdruigk());

            srHaitoukinMeisaiListSubDSBeanList.add(srHaitoukinMeisaiListSubDSBean);

            syuukeiptnkbnCount++;

            goukeiKensuu = goukeiKensuu.add(nullToZerobyBizNumber(kariDMeisaiDataBean.getKensuu()));
            goukeiHsys = goukeiHsys.add(nullToZerobyBizCurrency(kariDMeisaiDataBean.getHsys()));
            goukeiZnnndkrkskrwratdruigk = goukeiZnnndkrkskrwratdruigk.add(nullToZerobyBizCurrency(kariDMeisaiDataBean
                .getZnnndkrkskrwratdruigk()));
            goukeiKariwariatedrisoku = goukeiKariwariatedrisoku.add(nullToZerobyBizCurrency(kariDMeisaiDataBean
                .getKariwariatedrisoku()));
            goukeiTounendokariwariated = goukeiTounendokariwariated.add(nullToZerobyBizCurrency(kariDMeisaiDataBean
                .getTounendokariwariated()));
            goukeiTndmatukrkskrwratdruigk = goukeiTndmatukrkskrwratdruigk
                .add(nullToZerobyBizCurrency(kariDMeisaiDataBean.getTndmatukrkskrwratdruigk()));
        }

        while (syuukeiptnkbnCount <= SrCommonConstants.HAITOUKINSYUUKEIPTNKBN_KBNCOUNT) {
            srHaitoukinMeisaiListSubDSBeanList.add(emptyMeisaiyouSubDSBean);
            syuukeiptnkbnCount++;
        }

        srHaitoukinMeisaiListSubDSBean = createMeisai(goukeiKensuu,
            goukeiHsys,
            goukeiZnnndkrkskrwratdruigk,
            goukeiKariwariatedrisoku,
            goukeiTounendokariwariated,
            goukeiTndmatukrkskrwratdruigk);

        srHaitoukinMeisaiListSubDSBeanList.add(srHaitoukinMeisaiListSubDSBean);

        srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd(ConvertUtil.toZenNumeric(kbnkeiriyousegmentkbn));
        srHaitoukinMeisaiListDataSourceBean.setIrHknsyurui(SrCommonConstants.TYOUHYOUHYOUJINM_HOKENSYURUI);
        srHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd(syukeiyakusyuruicd);
        srHaitoukinMeisaiListDataSourceBean
        .setSrHaitoukinmeisailistsubdatasourcebeanList(srHaitoukinMeisaiListSubDSBeanList);

        reportList.add(srHaitoukinMeisaiListDataSourceBean);

        meisaiBlockCount++;

        srHaitoukinMeisaiListSubDSBeanList = new ArrayList<>();
        srHaitoukinMeisaiListDataSourceBean = SWAKInjector.getInstance(SrHaitoukinMeisaiListDataSourceBean.class);

        srHaitoukinMeisaiListDataSourceBean = createSeggoukei(kbnkeiriyousegmentkbn.substring(0, 2),
            kbnkeiriyousegmentkbn.substring(kbnkeiriyousegmentkbn.length() - 2));

        reportList.add(srHaitoukinMeisaiListDataSourceBean);

        meisaiBlockCount++;

        if (meisaiBlockCount % 2 == 0) {
            srHaitoukinMeisaiListDataSourceBean = SWAKInjector.getInstance(SrHaitoukinMeisaiListDataSourceBean.class);

            srHaitoukinMeisaiListDataSourceBean = createEmptyBlock(kbnkeiriyousegmentkbn);

            reportList.add(srHaitoukinMeisaiListDataSourceBean);

            meisaiBlockCount++;
        }

        srHaitoukinMeisaiListSubDSBeanList = new ArrayList<>();
        srHaitoukinMeisaiListDataSourceBean = SWAKInjector.getInstance(SrHaitoukinMeisaiListDataSourceBean.class);
        syuukeiptnkbnCount = SrCommonConstants.DEFAULT_INT_ITI;
        goukeiKensuu = BizNumber.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        goukeiHsys = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        goukeiZnnndkrkskrwratdruigk = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        goukeiKariwariatedrisoku = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        goukeiTounendokariwariated = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        goukeiTndmatukrkskrwratdruigk = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);

        List<KariDMeisaiDataBean> kariwariateHaitoukinDataBeanList = srKariwariateDMeisaiListSksDao
            .getKariDZensyuGoukei(kijyunym, kakutyoujobcd);

        for (KariDMeisaiDataBean kariDMeisaiDataBean : kariwariateHaitoukinDataBeanList) {
            while (syuukeiptnkbnCount < Integer.valueOf(kariDMeisaiDataBean.getSrhaitoukinsyuukeiptnkbn().getValue())) {
                srHaitoukinMeisaiListSubDSBeanList.add(emptyMeisaiyouSubDSBean);
                syuukeiptnkbnCount++;
            }

            srHaitoukinMeisaiListSubDSBean = createMeisai(kariDMeisaiDataBean.getKensuu(),
                kariDMeisaiDataBean.getHsys(),
                kariDMeisaiDataBean.getZnnndkrkskrwratdruigk(),
                kariDMeisaiDataBean.getKariwariatedrisoku(),
                kariDMeisaiDataBean.getTounendokariwariated(),
                kariDMeisaiDataBean.getTndmatukrkskrwratdruigk());

            srHaitoukinMeisaiListSubDSBeanList.add(srHaitoukinMeisaiListSubDSBean);

            syuukeiptnkbnCount++;

            goukeiKensuu = goukeiKensuu.add(nullToZerobyBizNumber(kariDMeisaiDataBean.getKensuu()));
            goukeiHsys = goukeiHsys.add(nullToZerobyBizCurrency(kariDMeisaiDataBean.getHsys()));
            goukeiZnnndkrkskrwratdruigk = goukeiZnnndkrkskrwratdruigk.add(nullToZerobyBizCurrency(kariDMeisaiDataBean
                .getZnnndkrkskrwratdruigk()));
            goukeiKariwariatedrisoku = goukeiKariwariatedrisoku.add(nullToZerobyBizCurrency(kariDMeisaiDataBean
                .getKariwariatedrisoku()));
            goukeiTounendokariwariated = goukeiTounendokariwariated.add(nullToZerobyBizCurrency(kariDMeisaiDataBean
                .getTounendokariwariated()));
            goukeiTndmatukrkskrwratdruigk = goukeiTndmatukrkskrwratdruigk
                .add(nullToZerobyBizCurrency(kariDMeisaiDataBean.getTndmatukrkskrwratdruigk()));
        }

        while (syuukeiptnkbnCount <= SrCommonConstants.HAITOUKINSYUUKEIPTNKBN_KBNCOUNT) {
            srHaitoukinMeisaiListSubDSBeanList.add(emptyMeisaiyouSubDSBean);
            syuukeiptnkbnCount++;
        }

        srHaitoukinMeisaiListSubDSBean = createMeisai(goukeiKensuu,
            goukeiHsys,
            goukeiZnnndkrkskrwratdruigk,
            goukeiKariwariatedrisoku,
            goukeiTounendokariwariated,
            goukeiTndmatukrkskrwratdruigk);

        srHaitoukinMeisaiListSubDSBeanList.add(srHaitoukinMeisaiListSubDSBean);

        srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd(SrCommonConstants.TYOUHYOUHYOUJINM_ZENSYUGOUKEI);
        srHaitoukinMeisaiListDataSourceBean.setIrHknsyurui("");
        srHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd("");
        srHaitoukinMeisaiListDataSourceBean
        .setSrHaitoukinmeisailistsubdatasourcebeanList(srHaitoukinMeisaiListSubDSBeanList);

        reportList.add(srHaitoukinMeisaiListDataSourceBean);

        meisaiBlockCount = meisaiBlockCount + 1;
        if (meisaiBlockCount % 2 == 0) {
            srHaitoukinMeisaiListDataSourceBean = SWAKInjector.getInstance(SrHaitoukinMeisaiListDataSourceBean.class);

            srHaitoukinMeisaiListDataSourceBean = createEmptyBlock(SrCommonConstants.TYOUHYOUHYOUJINM_ZENSYUGOUKEI);

            reportList.add(srHaitoukinMeisaiListDataSourceBean);
        }

        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(),
            kinou.getCategoryId(),
            kinou.getKinouId(),
            C_SyoruiCdKbn.SR_KARIWARIATEDMEISAILIS);

        reportServicesBean.setSyoriYmd(batchParam.getSyoriYmd());
        reportServicesBean.addParamObjects(reportList, srHaitoukinMeisaiListBean);

        createReport.exec(reportServicesBean);

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(goukeiKensuu),
            "仮割当配当金明細リスト"));
    }

    private SrHaitoukinMeisaiListSubDataSourceBean createMeisai(
        BizNumber pKensuu,
        BizCurrency pHsys,
        BizCurrency pZnnndkrkskrwratdruigk,
        BizCurrency pKariwariatedrisoku,
        BizCurrency pTounendokariwariated,
        BizCurrency pTndmatukrkskrwratdruigk) {
        SrHaitoukinMeisaiListSubDataSourceBean srHaitoukinMeisaiListSubDSBean =
            SWAKInjector.getInstance(SrHaitoukinMeisaiListSubDataSourceBean.class);
        srHaitoukinMeisaiListSubDSBean.setIrKensuu(zeroToNullbyBizNumber(pKensuu));
        srHaitoukinMeisaiListSubDSBean.setIrHsys(zeroToNullbyBizCurrency(pHsys));
        srHaitoukinMeisaiListSubDSBean.setIrZennendokurikosid(zeroToNullbyBizCurrency(pZnnndkrkskrwratdruigk));
        srHaitoukinMeisaiListSubDSBean.setIrHaitoursk(zeroToNullbyBizCurrency(pKariwariatedrisoku));
        srHaitoukinMeisaiListSubDSBean.setIrTounendod(zeroToNullbyBizCurrency(pTounendokariwariated));
        srHaitoukinMeisaiListSubDSBean.setIrTounendomatud(zeroToNullbyBizCurrency(pTndmatukrkskrwratdruigk));

        return srHaitoukinMeisaiListSubDSBean;
    }

    private SrHaitoukinMeisaiListDataSourceBean createEmptyBlock(String pKbnkeiriyousegmentkbn) {

        SrHaitoukinMeisaiListDataSourceBean srHaitoukinMeisaiListDataSourceBean =
            SWAKInjector.getInstance(SrHaitoukinMeisaiListDataSourceBean.class);
        List<SrHaitoukinMeisaiListSubDataSourceBean> srHaitoukinMeisaiListSubDSBeanList = new ArrayList<>();
        int count = SrCommonConstants.DEFAULT_INT_ZERO;

        while (count <= SrCommonConstants.HAITOUKINSYUUKEIPTNKBN_KBNCOUNT) {
            srHaitoukinMeisaiListSubDSBeanList.add(emptyMeisaiyouSubDSBean);
            count++;
        }

        srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd(ConvertUtil.toZenNumeric(pKbnkeiriyousegmentkbn));
        srHaitoukinMeisaiListDataSourceBean.setIrHknsyurui("");
        srHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd("");
        srHaitoukinMeisaiListDataSourceBean
        .setSrHaitoukinmeisailistsubdatasourcebeanList(srHaitoukinMeisaiListSubDSBeanList);

        return srHaitoukinMeisaiListDataSourceBean;
    }

    private SrHaitoukinMeisaiListDataSourceBean createSeggoukei(
        String pKbnkeiriyousegmentkbn,
        String pKbnkeiriyourgnbnskkbn) {
        SrHaitoukinMeisaiListDataSourceBean srHaitoukinMeisaiListDataSourceBean = SWAKInjector
            .getInstance(SrHaitoukinMeisaiListDataSourceBean.class);
        List<SrHaitoukinMeisaiListSubDataSourceBean> srHaitoukinMeisaiListSubDSBeanList = new ArrayList<>();
        SrHaitoukinMeisaiListSubDataSourceBean srHaitoukinMeisaiListSubDSBean = SWAKInjector
            .getInstance(SrHaitoukinMeisaiListSubDataSourceBean.class);
        int syuukeiptnkbnCount = SrCommonConstants.DEFAULT_INT_ITI;

        BizNumber goukeiKensuu = BizNumber.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        BizCurrency goukeiHsys = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        BizCurrency goukeiZnnndkrkskrwratdruigk = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        BizCurrency goukeiKariwariatedrisoku = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        BizCurrency goukeiTounendokariwariated = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        BizCurrency goukeiTndmatukrkskrwratdruigk = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);

        List<KariDMeisaiDataBean> kariDMeisaiDataBeanList = srKariwariateDMeisaiListSksDao.getKariDSegmentGoukei(
            kijyunym,
            kakutyoujobcd,
            pKbnkeiriyousegmentkbn,
            pKbnkeiriyourgnbnskkbn);

        for (KariDMeisaiDataBean kariDMeisaiDataBean : kariDMeisaiDataBeanList) {
            while (syuukeiptnkbnCount < Integer.valueOf(kariDMeisaiDataBean.getSrhaitoukinsyuukeiptnkbn().getValue())) {
                srHaitoukinMeisaiListSubDSBeanList.add(emptyMeisaiyouSubDSBean);
                syuukeiptnkbnCount++;
            }

            srHaitoukinMeisaiListSubDSBean = createMeisai(kariDMeisaiDataBean.getKensuu(),
                kariDMeisaiDataBean.getHsys(),
                kariDMeisaiDataBean.getZnnndkrkskrwratdruigk(),
                kariDMeisaiDataBean.getKariwariatedrisoku(),
                kariDMeisaiDataBean.getTounendokariwariated(),
                kariDMeisaiDataBean.getTndmatukrkskrwratdruigk());

            srHaitoukinMeisaiListSubDSBeanList.add(srHaitoukinMeisaiListSubDSBean);

            syuukeiptnkbnCount++;

            goukeiKensuu = goukeiKensuu.add(nullToZerobyBizNumber(kariDMeisaiDataBean.getKensuu()));
            goukeiHsys = goukeiHsys.add(nullToZerobyBizCurrency(kariDMeisaiDataBean.getHsys()));
            goukeiZnnndkrkskrwratdruigk = goukeiZnnndkrkskrwratdruigk.add(nullToZerobyBizCurrency(kariDMeisaiDataBean
                .getZnnndkrkskrwratdruigk()));
            goukeiKariwariatedrisoku = goukeiKariwariatedrisoku.add(nullToZerobyBizCurrency(kariDMeisaiDataBean
                .getKariwariatedrisoku()));
            goukeiTounendokariwariated = goukeiTounendokariwariated.add(nullToZerobyBizCurrency(kariDMeisaiDataBean
                .getTounendokariwariated()));
            goukeiTndmatukrkskrwratdruigk = goukeiTndmatukrkskrwratdruigk
                .add(nullToZerobyBizCurrency(kariDMeisaiDataBean.getTndmatukrkskrwratdruigk()));
        }

        while (syuukeiptnkbnCount <= SrCommonConstants.HAITOUKINSYUUKEIPTNKBN_KBNCOUNT) {
            srHaitoukinMeisaiListSubDSBeanList.add(emptyMeisaiyouSubDSBean);
            syuukeiptnkbnCount++;
        }

        srHaitoukinMeisaiListSubDSBean = createMeisai(goukeiKensuu,
            goukeiHsys,
            goukeiZnnndkrkskrwratdruigk,
            goukeiKariwariatedrisoku,
            goukeiTounendokariwariated,
            goukeiTndmatukrkskrwratdruigk);

        srHaitoukinMeisaiListSubDSBeanList.add(srHaitoukinMeisaiListSubDSBean);

        srHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd(ConvertUtil.toZenNumeric(pKbnkeiriyousegmentkbn + pKbnkeiriyourgnbnskkbn));
        srHaitoukinMeisaiListDataSourceBean.setIrHknsyurui(SrCommonConstants.TYOUHYOUHYOUJINM_GOUKEI);
        srHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd("");
        srHaitoukinMeisaiListDataSourceBean
        .setSrHaitoukinmeisailistsubdatasourcebeanList(srHaitoukinMeisaiListSubDSBeanList);

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
