package yuyu.batch.suuri.srsuuritoukei.srbikinkykseisandlistsks;

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
import yuyu.batch.suuri.srsuuritoukei.srbikinkykseisandlistsks.dba.BknKykSisnDDataBean;
import yuyu.batch.suuri.srsuuritoukei.srbikinkykseisandlistsks.dba.SrBikinKykSeisanDListSksDao;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.suuri.bean.report.SrBknHaitoukinMeisaiListBean;
import yuyu.def.suuri.bean.report.SrBknHaitoukinMeisaiListDataSourceBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 数理 数理統計 備金契約精算Ｄ集計リスト作成クラス
 */
public class SrBikinKykSeisanDListSksBatch implements Batch  {

    private String kakutyoujobcd;
    private String kijyunym;
    private SrBknHaitoukinMeisaiListDataSourceBean srBknHaitoukinMeisaiListDataSourceBean;
    private List<IReportDataSouceBean> iReportDataSouceBeanList;

    private BizNumber nendoGoukeiKensuu;
    private BizCurrency nendoGoukeiRsk;
    private BizCurrency nendoGoukeiHaitoukin;

    private BizNumber meisaiGoukeiKensuusbkds;
    private BizCurrency meisaiGoukeiRsksbkds;
    private BizCurrency meisaiGoukeiHaitoukinsbkds;

    private BizNumber meisaiGoukeiKensuumnk;
    private BizCurrency meisaiGoukeiRskmnk;
    private BizCurrency meisaiGoukeiHaitoukinmnk;

    private BizNumber meisaiGoukeiKensuukaiyaku;
    private BizCurrency meisaiGoukeiRskkaiyaku;
    private BizCurrency meisaiGoukeiHaitoukinkaiyaku;

    private BizNumber meisaiGoukeiKensuusikkou;
    private BizCurrency meisaiGoukeiRsksikkou;
    private BizCurrency meisaiGoukeiHaitoukinsikkou;

    private BizNumber meisaiGoukeiKensuuetc;
    private BizCurrency meisaiGoukeiRsketc;
    private BizCurrency meisaiGoukeiHaitoukinetc;

    private BizNumber meisaiGoukeiKensuugoukei;
    private BizCurrency meisaiGoukeiRskgoukei;
    private BizCurrency meisaiGoukeiHaitoukingoukei;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SrBikinKykSeisanDListSksBatchParam srBikinKykSeisanDListSksBatchParam;

    @Inject
    private SrBikinKykSeisanDListSksDao srBikinKykSeisanDListSksDao;

    @Inject
    private CreateReport createReport;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {

        return srBikinKykSeisanDListSksBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYMD = srBikinKykSeisanDListSksBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(syoriYMD)));

        if (SrBikinKykSeisanDListSksBatchParam.RGKSM002.equals(
            srBikinKykSeisanDListSksBatchParam.getIbKakutyoujobcd())) {

            kakutyoujobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN2_BKNKYKHTJYNBKNDATA;
        }
        else if (SrBikinKykSeisanDListSksBatchParam.RGKSM004.equals(
            srBikinKykSeisanDListSksBatchParam.getIbKakutyoujobcd())) {

            kakutyoujobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIHONBAN_BKNKYKHTJYNBKNDATA;
        }

        kijyunym = srBikinKykSeisanDListSksBatchParam.getKijyunymd().getBizDateYM().toString();

        List<BknKykSisnDDataBean> bknKykSisnDDataBeanList =
            srBikinKykSeisanDListSksDao.getBknKykSisnD(kijyunym, kakutyoujobcd);

        if (bknKykSisnDDataBeanList.size() == 0) {

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(bknKykSisnDDataBeanList.size()), "備金契約精算Ｄ集計リスト"));

            return;
        }

        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);
        SrBknHaitoukinMeisaiListBean srBknHaitoukinMeisaiListBean =
            SWAKInjector.getInstance(SrBknHaitoukinMeisaiListBean.class);
        srBknHaitoukinMeisaiListDataSourceBean =
            SWAKInjector.getInstance(SrBknHaitoukinMeisaiListDataSourceBean.class);
        iReportDataSouceBeanList = new ArrayList<IReportDataSouceBean>();

        nendoGoukeiKensuu = BizNumber.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        nendoGoukeiRsk = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        nendoGoukeiHaitoukin = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);

        String breakKeyKbnkeirisegcd = "";
        String breakKeySyukeiyakusyuruicd = "";
        String breakKeyBikinnendokbn  = "";
        String breakKeyZensyuGukiBikinnendokbn = "";
        int bikinNendoKbnCount = SrCommonConstants.DEFAULT_INT_ITI;

        initMeisaiGoukei();

        BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(SrCommonConstants.SOSIKICD_SYUNOSERVICESITU);

        if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {

            srBknHaitoukinMeisaiListBean.setIrAtesakibukanm(bzGetSosikiDataBean.getKanjisosikinm20());
        }

        srBknHaitoukinMeisaiListBean.setIrSyoriymd(DateFormatUtil.dateKANJI(syoriYMD));

        srBknHaitoukinMeisaiListBean.setIrHozonkkn(ViewReport.getHozonKknTani(C_SyoruiCdKbn.SR_BIKINKYKSEISANDLIST));

        for (int n = 0; n < bknKykSisnDDataBeanList.size(); n++) {

            BknKykSisnDDataBean bknKykSisnDDataBean = bknKykSisnDDataBeanList.get(n);

            if (n == 0) {

                breakKeyKbnkeirisegcd =
                    bknKykSisnDDataBean.getKbnkeiriyousegmentkbn() + bknKykSisnDDataBean.getKbnkeiriyourgnbnskkbn();
                breakKeySyukeiyakusyuruicd = bknKykSisnDDataBean.getSyukeiyakusyuruicd();
                breakKeyBikinnendokbn  = bknKykSisnDDataBean.getBikinnendokbn();
            }

            if (!breakKeyKbnkeirisegcd.equals(
                bknKykSisnDDataBean.getKbnkeiriyousegmentkbn() + bknKykSisnDDataBean.getKbnkeiriyourgnbnskkbn()) ||
                !breakKeySyukeiyakusyuruicd.equals(bknKykSisnDDataBean.getSyukeiyakusyuruicd()) ||
                !breakKeyBikinnendokbn.equals(bknKykSisnDDataBean.getBikinnendokbn())) {

                srBknHaitoukinMeisaiListDataSourceBean.setIrKensuugoukei12(zeroToNullbyBizNumber(nendoGoukeiKensuu));
                srBknHaitoukinMeisaiListDataSourceBean.setIrRskgoukei(zeroToNullbyBizCurrency(nendoGoukeiRsk));
                srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukingoukei(zeroToNullbyBizCurrency(nendoGoukeiHaitoukin));

                iReportDataSouceBeanList.add(srBknHaitoukinMeisaiListDataSourceBean);

                srBknHaitoukinMeisaiListDataSourceBean =
                    SWAKInjector.getInstance(SrBknHaitoukinMeisaiListDataSourceBean.class);

                nendoGoukeiKensuu = BizNumber.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
                nendoGoukeiRsk = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
                nendoGoukeiHaitoukin = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);

                if (breakKeyKbnkeirisegcd.equals(
                    bknKykSisnDDataBean.getKbnkeiriyousegmentkbn() + bknKykSisnDDataBean.getKbnkeiriyourgnbnskkbn()) &&
                    breakKeySyukeiyakusyuruicd.equals(bknKykSisnDDataBean.getSyukeiyakusyuruicd()) &&
                    !breakKeyBikinnendokbn.equals(bknKykSisnDDataBean.getBikinnendokbn())) {

                    breakKeyBikinnendokbn = bknKykSisnDDataBean.getBikinnendokbn();
                    bikinNendoKbnCount = bikinNendoKbnCount + 1;
                }
            }

            if (!breakKeyKbnkeirisegcd.equals(
                bknKykSisnDDataBean.getKbnkeiriyousegmentkbn() + bknKykSisnDDataBean.getKbnkeiriyourgnbnskkbn()) ||
                !breakKeySyukeiyakusyuruicd.equals(bknKykSisnDDataBean.getSyukeiyakusyuruicd())) {

                if (bikinNendoKbnCount < SrCommonConstants.BIKINNENDOKBN_KBNCOUNT) {

                    while (bikinNendoKbnCount < SrCommonConstants.BIKINNENDOKBN_KBNCOUNT) {

                        setEmptyMeisai(breakKeyKbnkeirisegcd, breakKeySyukeiyakusyuruicd, 0);

                        bikinNendoKbnCount = bikinNendoKbnCount + 1;
                    }
                }

                setMeisaiGoukei(breakKeyKbnkeirisegcd, breakKeySyukeiyakusyuruicd, 0);

                srBknHaitoukinMeisaiListDataSourceBean =
                    SWAKInjector.getInstance(SrBknHaitoukinMeisaiListDataSourceBean.class);
                nendoGoukeiKensuu = BizNumber.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
                nendoGoukeiRsk = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
                nendoGoukeiHaitoukin = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
                breakKeySyukeiyakusyuruicd = bknKykSisnDDataBean.getSyukeiyakusyuruicd();
                breakKeyBikinnendokbn = bknKykSisnDDataBean.getBikinnendokbn();
                bikinNendoKbnCount = SrCommonConstants.DEFAULT_INT_ITI;

                initMeisaiGoukei();
            }

            if (!breakKeyKbnkeirisegcd.equals(
                bknKykSisnDDataBean.getKbnkeiriyousegmentkbn() + bknKykSisnDDataBean.getKbnkeiriyourgnbnskkbn())) {

                setSegmentGoukei(breakKeyKbnkeirisegcd);

                srBknHaitoukinMeisaiListDataSourceBean =
                    SWAKInjector.getInstance(SrBknHaitoukinMeisaiListDataSourceBean.class);
                nendoGoukeiKensuu = BizNumber.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
                nendoGoukeiRsk = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
                nendoGoukeiHaitoukin = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);

                initMeisaiGoukei();

                breakKeyKbnkeirisegcd =
                    bknKykSisnDDataBean.getKbnkeiriyousegmentkbn() + bknKykSisnDDataBean.getKbnkeiriyourgnbnskkbn();
            }

            if (breakKeyKbnkeirisegcd.equals(
                bknKykSisnDDataBean.getKbnkeiriyousegmentkbn() + bknKykSisnDDataBean.getKbnkeiriyourgnbnskkbn()) &&
                breakKeySyukeiyakusyuruicd.equals(bknKykSisnDDataBean.getSyukeiyakusyuruicd()) &&
                bikinNendoKbnCount < Integer.valueOf(bknKykSisnDDataBean.getBikinnendokbn())) {

                while (bikinNendoKbnCount < Integer.valueOf(bknKykSisnDDataBean.getBikinnendokbn())) {

                    setEmptyMeisai(breakKeyKbnkeirisegcd, breakKeySyukeiyakusyuruicd, 0);

                    bikinNendoKbnCount = bikinNendoKbnCount + 1;
                }
            }

            setMeisaiInfo(
                bknKykSisnDDataBean.getKbnkeiriyousegmentkbn() + bknKykSisnDDataBean.getKbnkeiriyourgnbnskkbn(),
                bknKykSisnDDataBean.getSyukeiyakusyuruicd(),
                bknKykSisnDDataBean.getBikinkbn(),
                bknKykSisnDDataBean.getKensuu(),
                bknKykSisnDDataBean.getTumitaterisoku(),
                bknKykSisnDDataBean.getSeisand(),
                0);
        }

        srBknHaitoukinMeisaiListDataSourceBean.setIrKensuugoukei12(zeroToNullbyBizNumber(nendoGoukeiKensuu));
        srBknHaitoukinMeisaiListDataSourceBean.setIrRskgoukei(zeroToNullbyBizCurrency(nendoGoukeiRsk));
        srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukingoukei(zeroToNullbyBizCurrency(nendoGoukeiHaitoukin));

        iReportDataSouceBeanList.add(srBknHaitoukinMeisaiListDataSourceBean);

        if (bikinNendoKbnCount < SrCommonConstants.BIKINNENDOKBN_KBNCOUNT) {

            while (bikinNendoKbnCount < SrCommonConstants.BIKINNENDOKBN_KBNCOUNT) {

                setEmptyMeisai(breakKeyKbnkeirisegcd, breakKeySyukeiyakusyuruicd, 0);

                bikinNendoKbnCount = bikinNendoKbnCount + 1;
            }
        }

        setMeisaiGoukei(breakKeyKbnkeirisegcd, breakKeySyukeiyakusyuruicd, 0);

        srBknHaitoukinMeisaiListDataSourceBean =
            SWAKInjector.getInstance(SrBknHaitoukinMeisaiListDataSourceBean.class);
        nendoGoukeiKensuu = BizNumber.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        nendoGoukeiRsk = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        nendoGoukeiHaitoukin = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);

        initMeisaiGoukei();

        setSegmentGoukei(breakKeyKbnkeirisegcd);

        srBknHaitoukinMeisaiListDataSourceBean =
            SWAKInjector.getInstance(SrBknHaitoukinMeisaiListDataSourceBean.class);
        nendoGoukeiKensuu = BizNumber.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        nendoGoukeiRsk = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        nendoGoukeiHaitoukin = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);

        initMeisaiGoukei();

        List<BknKykSisnDDataBean> bknKykSisnDZensyuGukiDataBeanList =
            srBikinKykSeisanDListSksDao.getBknKykSisnDZensyuGoukei(kijyunym, kakutyoujobcd);

        for (int n = 0; n < bknKykSisnDZensyuGukiDataBeanList.size(); n++) {

            BknKykSisnDDataBean bknKykSisnDZensyuGukiDataBean = bknKykSisnDZensyuGukiDataBeanList.get(n);

            if (n ==0) {

                breakKeyZensyuGukiBikinnendokbn = bknKykSisnDZensyuGukiDataBean.getBikinnendokbn();
                bikinNendoKbnCount = SrCommonConstants.DEFAULT_INT_ITI;
            }

            if (!breakKeyZensyuGukiBikinnendokbn.equals(bknKykSisnDZensyuGukiDataBean.getBikinnendokbn())) {

                srBknHaitoukinMeisaiListDataSourceBean.setIrKensuugoukei12(zeroToNullbyBizNumber(nendoGoukeiKensuu));
                srBknHaitoukinMeisaiListDataSourceBean.setIrRskgoukei(zeroToNullbyBizCurrency(nendoGoukeiRsk));
                srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukingoukei(zeroToNullbyBizCurrency(nendoGoukeiHaitoukin));

                iReportDataSouceBeanList.add(srBknHaitoukinMeisaiListDataSourceBean);

                srBknHaitoukinMeisaiListDataSourceBean =
                    SWAKInjector.getInstance(SrBknHaitoukinMeisaiListDataSourceBean.class);
                nendoGoukeiKensuu = BizNumber.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
                nendoGoukeiRsk = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
                nendoGoukeiHaitoukin = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
                breakKeyZensyuGukiBikinnendokbn = bknKykSisnDZensyuGukiDataBean.getBikinnendokbn();
                bikinNendoKbnCount = bikinNendoKbnCount + 1;
            }

            if (bikinNendoKbnCount < Integer.valueOf(bknKykSisnDZensyuGukiDataBean.getBikinnendokbn())) {

                while (bikinNendoKbnCount < Integer.valueOf(bknKykSisnDZensyuGukiDataBean.getBikinnendokbn())) {

                    setEmptyMeisai(null, null, 2);

                    bikinNendoKbnCount = bikinNendoKbnCount + 1;
                }
            }

            setMeisaiInfo(
                null,
                null,
                bknKykSisnDZensyuGukiDataBean.getBikinkbn(),
                bknKykSisnDZensyuGukiDataBean.getKensuu(),
                bknKykSisnDZensyuGukiDataBean.getTumitaterisoku(),
                bknKykSisnDZensyuGukiDataBean.getSeisand(),
                2);
        }

        srBknHaitoukinMeisaiListDataSourceBean.setIrKensuugoukei12(zeroToNullbyBizNumber(nendoGoukeiKensuu));
        srBknHaitoukinMeisaiListDataSourceBean.setIrRskgoukei(zeroToNullbyBizCurrency(nendoGoukeiRsk));
        srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukingoukei(zeroToNullbyBizCurrency(nendoGoukeiHaitoukin));

        iReportDataSouceBeanList.add(srBknHaitoukinMeisaiListDataSourceBean);

        if (bikinNendoKbnCount < SrCommonConstants.BIKINNENDOKBN_KBNCOUNT) {

            while (bikinNendoKbnCount < SrCommonConstants.BIKINNENDOKBN_KBNCOUNT) {

                setEmptyMeisai(null, null, 2);

                bikinNendoKbnCount = bikinNendoKbnCount + 1;
            }
        }

        setMeisaiGoukei(null, null, 2);

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            kinou.getSubSystemId(), kinou.getCategoryId(), kinou.getKinouId(), C_SyoruiCdKbn.SR_BIKINKYKSEISANDLIST);

        reportServicesBean.setSyoriYmd(syoriYMD);

        reportServicesBean.addParamObjects(iReportDataSouceBeanList, srBknHaitoukinMeisaiListBean);

        createReport.exec(reportServicesBean);

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(meisaiGoukeiKensuugoukei), "備金契約精算Ｄ集計リスト"));
    }

    private void initMeisaiGoukei() {

        meisaiGoukeiKensuusbkds = BizNumber.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        meisaiGoukeiRsksbkds = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        meisaiGoukeiHaitoukinsbkds = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);

        meisaiGoukeiKensuumnk = BizNumber.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        meisaiGoukeiRskmnk = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        meisaiGoukeiHaitoukinmnk = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);

        meisaiGoukeiKensuukaiyaku = BizNumber.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        meisaiGoukeiRskkaiyaku = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        meisaiGoukeiHaitoukinkaiyaku = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);

        meisaiGoukeiKensuusikkou = BizNumber.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        meisaiGoukeiRsksikkou = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        meisaiGoukeiHaitoukinsikkou = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);

        meisaiGoukeiKensuuetc = BizNumber.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        meisaiGoukeiRsketc = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        meisaiGoukeiHaitoukinetc = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);

        meisaiGoukeiKensuugoukei = BizNumber.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        meisaiGoukeiRskgoukei = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        meisaiGoukeiHaitoukingoukei = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
    }

    private void setEmptyMeisai(String pKbnkeirisegcd, String pSyukeiyakusyuruicd, int pMeisaikbn) {

        SrBknHaitoukinMeisaiListDataSourceBean srBknHaitoukinMeisaiListDataSourceBeanEmpty =
            SWAKInjector.getInstance(SrBknHaitoukinMeisaiListDataSourceBean.class);

        srBknHaitoukinMeisaiListDataSourceBeanEmpty = setMeisaiKytInfo(
            srBknHaitoukinMeisaiListDataSourceBeanEmpty, pKbnkeirisegcd, pSyukeiyakusyuruicd, pMeisaikbn);

        iReportDataSouceBeanList.add(srBknHaitoukinMeisaiListDataSourceBeanEmpty);

    }

    private SrBknHaitoukinMeisaiListDataSourceBean setMeisaiKytInfo(
        SrBknHaitoukinMeisaiListDataSourceBean pSrBknHaitoukinMeisaiListDataSourceBean, String pKbnkeirisegcd,
        String pSyukeiyakusyuruicd, int pMeisaikbn) {

        if (pMeisaikbn == 0 || pMeisaikbn == 1) {

            pSrBknHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd(ConvertUtil.toZenNumeric(pKbnkeirisegcd));
        }

        else if (pMeisaikbn == 2) {

            pSrBknHaitoukinMeisaiListDataSourceBean.setIrKbnkeirisegcd(SrCommonConstants.TYOUHYOUHYOUJINM_ZENSYUGOUKEI);
        }

        if (pMeisaikbn == 0) {

            pSrBknHaitoukinMeisaiListDataSourceBean.setIrHknsyurui(SrCommonConstants.TYOUHYOUHYOUJINM_HOKENSYURUI);
        }
        else if (pMeisaikbn == 1) {

            pSrBknHaitoukinMeisaiListDataSourceBean.setIrHknsyurui(SrCommonConstants.TYOUHYOUHYOUJINM_GOUKEI);
        }
        else if (pMeisaikbn == 2) {

            pSrBknHaitoukinMeisaiListDataSourceBean.setIrHknsyurui("");
        }

        if (pMeisaikbn == 0) {

            pSrBknHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd(pSyukeiyakusyuruicd);
        }
        else if (pMeisaikbn == 1 || pMeisaikbn == 2) {

            pSrBknHaitoukinMeisaiListDataSourceBean.setIrSyukeiyakusyuruicd("");
        }

        return pSrBknHaitoukinMeisaiListDataSourceBean;

    }


    private void setMeisaiInfo(String pKbnkeirisegcd, String pSyukeiyakusyuruicd, String pBikinkbn,
        BizNumber pKensuu, BizCurrency pRsk, BizCurrency pHaitoukin, int pMeisaikbn) {

        srBknHaitoukinMeisaiListDataSourceBean = setMeisaiKytInfo(
            srBknHaitoukinMeisaiListDataSourceBean, pKbnkeirisegcd, pSyukeiyakusyuruicd, pMeisaikbn);

        if (SrCommonConstants.BIKINKBN_SIBOU_KOUDOSG.equals(pBikinkbn)) {

            srBknHaitoukinMeisaiListDataSourceBean.setIrKensuusbkds(zeroToNullbyBizNumber(pKensuu));
            srBknHaitoukinMeisaiListDataSourceBean.setIrRsksbkds(zeroToNullbyBizCurrency(pRsk));
            srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinsbkds(zeroToNullbyBizCurrency(pHaitoukin));

            meisaiGoukeiKensuusbkds = meisaiGoukeiKensuusbkds.add(nullToZerobyBizNumber(pKensuu));
            meisaiGoukeiRsksbkds = meisaiGoukeiRsksbkds.add(nullToZerobyBizCurrency(pRsk));
            meisaiGoukeiHaitoukinsbkds = meisaiGoukeiHaitoukinsbkds.add(nullToZerobyBizCurrency(pHaitoukin));
        }

        else if (SrCommonConstants.BIKINKBN_MANKI.equals(pBikinkbn)) {

            srBknHaitoukinMeisaiListDataSourceBean.setIrKensuumnk(zeroToNullbyBizNumber(pKensuu));
            srBknHaitoukinMeisaiListDataSourceBean.setIrRskmnk(zeroToNullbyBizCurrency(pRsk));
            srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinmnk(zeroToNullbyBizCurrency(pHaitoukin));

            meisaiGoukeiKensuumnk = meisaiGoukeiKensuumnk.add(nullToZerobyBizNumber(pKensuu));
            meisaiGoukeiRskmnk = meisaiGoukeiRskmnk.add(nullToZerobyBizCurrency(pRsk));
            meisaiGoukeiHaitoukinmnk = meisaiGoukeiHaitoukinmnk.add(nullToZerobyBizCurrency(pHaitoukin));
        }

        else if (SrCommonConstants.BIKINKBN_KAIYAKU.equals(pBikinkbn)) {

            srBknHaitoukinMeisaiListDataSourceBean.setIrKensuukaiyaku(zeroToNullbyBizNumber(pKensuu));
            srBknHaitoukinMeisaiListDataSourceBean.setIrRskkaiyaku(zeroToNullbyBizCurrency(pRsk));
            srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinkaiyaku(zeroToNullbyBizCurrency(pHaitoukin));

            meisaiGoukeiKensuukaiyaku = meisaiGoukeiKensuukaiyaku.add(nullToZerobyBizNumber(pKensuu));
            meisaiGoukeiRskkaiyaku = meisaiGoukeiRskkaiyaku.add(nullToZerobyBizCurrency(pRsk));
            meisaiGoukeiHaitoukinkaiyaku = meisaiGoukeiHaitoukinkaiyaku.add(nullToZerobyBizCurrency(pHaitoukin));
        }

        else if (SrCommonConstants.BIKINKBN_SIKKOU.equals(pBikinkbn)) {

            srBknHaitoukinMeisaiListDataSourceBean.setIrKensuusikkou(zeroToNullbyBizNumber(pKensuu));
            srBknHaitoukinMeisaiListDataSourceBean.setIrRsksikkou(zeroToNullbyBizCurrency(pRsk));
            srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinsikkou(zeroToNullbyBizCurrency(pHaitoukin));

            meisaiGoukeiKensuusikkou = meisaiGoukeiKensuusikkou.add(nullToZerobyBizNumber(pKensuu));
            meisaiGoukeiRsksikkou = meisaiGoukeiRsksikkou.add(nullToZerobyBizCurrency(pRsk));
            meisaiGoukeiHaitoukinsikkou = meisaiGoukeiHaitoukinsikkou.add(nullToZerobyBizCurrency(pHaitoukin));
        }

        else if (SrCommonConstants.BIKINKBN_SONOTA.equals(pBikinkbn)) {

            srBknHaitoukinMeisaiListDataSourceBean.setIrKensuuetc(zeroToNullbyBizNumber(pKensuu));
            srBknHaitoukinMeisaiListDataSourceBean.setIrRsketc(zeroToNullbyBizCurrency(pRsk));
            srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukinetc(zeroToNullbyBizCurrency(pHaitoukin));

            meisaiGoukeiKensuuetc = meisaiGoukeiKensuuetc.add(nullToZerobyBizNumber(pKensuu));
            meisaiGoukeiRsketc = meisaiGoukeiRsketc.add(nullToZerobyBizCurrency(pRsk));
            meisaiGoukeiHaitoukinetc = meisaiGoukeiHaitoukinetc.add(nullToZerobyBizCurrency(pHaitoukin));
        }

        nendoGoukeiKensuu = nendoGoukeiKensuu.add(nullToZerobyBizNumber(pKensuu));
        nendoGoukeiRsk = nendoGoukeiRsk.add(nullToZerobyBizCurrency(pRsk));
        nendoGoukeiHaitoukin = nendoGoukeiHaitoukin.add(nullToZerobyBizCurrency(pHaitoukin));

        meisaiGoukeiKensuugoukei = meisaiGoukeiKensuugoukei.add(nullToZerobyBizNumber(pKensuu));
        meisaiGoukeiRskgoukei = meisaiGoukeiRskgoukei.add(nullToZerobyBizCurrency(pRsk));
        meisaiGoukeiHaitoukingoukei = meisaiGoukeiHaitoukingoukei.add(nullToZerobyBizCurrency(pHaitoukin));

    }

    private void setMeisaiGoukei(String pKbnkeirisegcd, String pSyukeiyakusyuruicd, int pMeisaikbn) {

        SrBknHaitoukinMeisaiListDataSourceBean srBknHaitoukinMeisaiListDataSourceBeanGoukei =
            SWAKInjector.getInstance(SrBknHaitoukinMeisaiListDataSourceBean.class);

        srBknHaitoukinMeisaiListDataSourceBeanGoukei = setMeisaiKytInfo(
            srBknHaitoukinMeisaiListDataSourceBeanGoukei, pKbnkeirisegcd, pSyukeiyakusyuruicd, pMeisaikbn);

        srBknHaitoukinMeisaiListDataSourceBeanGoukei.setIrKensuusbkds(zeroToNullbyBizNumber(meisaiGoukeiKensuusbkds));
        srBknHaitoukinMeisaiListDataSourceBeanGoukei.setIrRsksbkds(zeroToNullbyBizCurrency(meisaiGoukeiRsksbkds));
        srBknHaitoukinMeisaiListDataSourceBeanGoukei.setIrHaitoukinsbkds(
            zeroToNullbyBizCurrency(meisaiGoukeiHaitoukinsbkds));

        srBknHaitoukinMeisaiListDataSourceBeanGoukei.setIrKensuumnk(zeroToNullbyBizNumber(meisaiGoukeiKensuumnk));
        srBknHaitoukinMeisaiListDataSourceBeanGoukei.setIrRskmnk(zeroToNullbyBizCurrency(meisaiGoukeiRskmnk));
        srBknHaitoukinMeisaiListDataSourceBeanGoukei.setIrHaitoukinmnk(
            zeroToNullbyBizCurrency(meisaiGoukeiHaitoukinmnk));

        srBknHaitoukinMeisaiListDataSourceBeanGoukei.setIrKensuukaiyaku(zeroToNullbyBizNumber(meisaiGoukeiKensuukaiyaku));
        srBknHaitoukinMeisaiListDataSourceBeanGoukei.setIrRskkaiyaku(zeroToNullbyBizCurrency(meisaiGoukeiRskkaiyaku));
        srBknHaitoukinMeisaiListDataSourceBeanGoukei.setIrHaitoukinkaiyaku(
            zeroToNullbyBizCurrency(meisaiGoukeiHaitoukinkaiyaku));

        srBknHaitoukinMeisaiListDataSourceBeanGoukei.setIrKensuusikkou(zeroToNullbyBizNumber(meisaiGoukeiKensuusikkou));
        srBknHaitoukinMeisaiListDataSourceBeanGoukei.setIrRsksikkou(zeroToNullbyBizCurrency(meisaiGoukeiRsksikkou));
        srBknHaitoukinMeisaiListDataSourceBeanGoukei.setIrHaitoukinsikkou(
            zeroToNullbyBizCurrency(meisaiGoukeiHaitoukinsikkou));

        srBknHaitoukinMeisaiListDataSourceBeanGoukei.setIrKensuuetc(zeroToNullbyBizNumber(meisaiGoukeiKensuuetc));
        srBknHaitoukinMeisaiListDataSourceBeanGoukei.setIrRsketc(zeroToNullbyBizCurrency(meisaiGoukeiRsketc));
        srBknHaitoukinMeisaiListDataSourceBeanGoukei.setIrHaitoukinetc(
            zeroToNullbyBizCurrency(meisaiGoukeiHaitoukinetc));

        srBknHaitoukinMeisaiListDataSourceBeanGoukei.setIrKensuugoukei12(zeroToNullbyBizNumber(meisaiGoukeiKensuugoukei));
        srBknHaitoukinMeisaiListDataSourceBeanGoukei.setIrRskgoukei(zeroToNullbyBizCurrency(meisaiGoukeiRskgoukei));
        srBknHaitoukinMeisaiListDataSourceBeanGoukei.setIrHaitoukingoukei(
            zeroToNullbyBizCurrency(meisaiGoukeiHaitoukingoukei));

        iReportDataSouceBeanList.add(srBknHaitoukinMeisaiListDataSourceBeanGoukei);
    }

    private void setSegmentGoukei(String pKbnkeirisegcd) {

        List<BknKykSisnDDataBean> bknKykSisnDSegmentGukiDataBeanList =
            srBikinKykSeisanDListSksDao.getBknKykSisnDSegmentGoukei(kijyunym, kakutyoujobcd,
                pKbnkeirisegcd.substring(0, 2), pKbnkeirisegcd.substring(pKbnkeirisegcd.length() - 2));

        String breakKeySegmentGukiBikinnendokbn = "";
        int bikinNendoKbnCount = SrCommonConstants.DEFAULT_INT_ITI;

        for (int n = 0; n < bknKykSisnDSegmentGukiDataBeanList.size(); n++) {

            BknKykSisnDDataBean bknKykSisnDSegmentGukiDataBean = bknKykSisnDSegmentGukiDataBeanList.get(n);

            if (n ==0) {

                breakKeySegmentGukiBikinnendokbn = bknKykSisnDSegmentGukiDataBean.getBikinnendokbn();
                bikinNendoKbnCount = SrCommonConstants.DEFAULT_INT_ITI;
            }

            if (!breakKeySegmentGukiBikinnendokbn.equals(bknKykSisnDSegmentGukiDataBean.getBikinnendokbn())) {

                srBknHaitoukinMeisaiListDataSourceBean.setIrKensuugoukei12(zeroToNullbyBizNumber(nendoGoukeiKensuu));
                srBknHaitoukinMeisaiListDataSourceBean.setIrRskgoukei(zeroToNullbyBizCurrency(nendoGoukeiRsk));
                srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukingoukei(zeroToNullbyBizCurrency(nendoGoukeiHaitoukin));

                iReportDataSouceBeanList.add(srBknHaitoukinMeisaiListDataSourceBean);

                srBknHaitoukinMeisaiListDataSourceBean =
                    SWAKInjector.getInstance(SrBknHaitoukinMeisaiListDataSourceBean.class);

                nendoGoukeiKensuu = BizNumber.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
                nendoGoukeiRsk = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
                nendoGoukeiHaitoukin = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);

                breakKeySegmentGukiBikinnendokbn = bknKykSisnDSegmentGukiDataBean.getBikinnendokbn();
                bikinNendoKbnCount = bikinNendoKbnCount + 1;
            }

            if (bikinNendoKbnCount < Integer.valueOf(bknKykSisnDSegmentGukiDataBean.getBikinnendokbn())) {

                while (bikinNendoKbnCount < Integer.valueOf(bknKykSisnDSegmentGukiDataBean.getBikinnendokbn())) {

                    setEmptyMeisai(pKbnkeirisegcd, null, 1);

                    bikinNendoKbnCount = bikinNendoKbnCount + 1;
                }
            }

            setMeisaiInfo(
                bknKykSisnDSegmentGukiDataBean.getKbnkeiriyousegmentkbn() +
                bknKykSisnDSegmentGukiDataBean.getKbnkeiriyourgnbnskkbn(),
                null,
                bknKykSisnDSegmentGukiDataBean.getBikinkbn(),
                bknKykSisnDSegmentGukiDataBean.getKensuu(),
                bknKykSisnDSegmentGukiDataBean.getTumitaterisoku(),
                bknKykSisnDSegmentGukiDataBean.getSeisand(),
                1);
        }

        srBknHaitoukinMeisaiListDataSourceBean.setIrKensuugoukei12(zeroToNullbyBizNumber(nendoGoukeiKensuu));
        srBknHaitoukinMeisaiListDataSourceBean.setIrRskgoukei(zeroToNullbyBizCurrency(nendoGoukeiRsk));
        srBknHaitoukinMeisaiListDataSourceBean.setIrHaitoukingoukei(zeroToNullbyBizCurrency(nendoGoukeiHaitoukin));

        iReportDataSouceBeanList.add(srBknHaitoukinMeisaiListDataSourceBean);

        if (bikinNendoKbnCount < SrCommonConstants.BIKINNENDOKBN_KBNCOUNT) {

            while (bikinNendoKbnCount < SrCommonConstants.BIKINNENDOKBN_KBNCOUNT) {

                setEmptyMeisai(pKbnkeirisegcd, null, 1);

                bikinNendoKbnCount = bikinNendoKbnCount + 1;
            }
        }

        setMeisaiGoukei(pKbnkeirisegcd, null, 1);
    }

    private BizNumber zeroToNullbyBizNumber(BizNumber pBizNumber) {

        if (pBizNumber == null ||
            pBizNumber.compareTo(BizNumber.valueOf(0)) == 0) {

            return null;
        }

        return pBizNumber;
    }

    private BizCurrency zeroToNullbyBizCurrency(BizCurrency pBizCurrency) {

        if (pBizCurrency ==null ||
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
