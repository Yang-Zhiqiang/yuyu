package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.db.entity.IT_KhHubiMikaisyouList;
import yuyu.def.hozen.bean.report.KhHubimikaiBean;
import yuyu.def.hozen.bean.report.KhHubimikaiDataSourceBean;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.def.workflow.sorter.SortDM_Jimutetuzuki;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 契約保全共通 不備未解消リストPDF作成
 */
public class EditPdfHubiMikai {

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private CreateReport createReport;

    public EditPdfHubiMikai() {

        super();
    }

    public int exec(BizDate pSyoriYmd, String pCategoryId, String pKinouId, String pKakutyouJobCd) {


        int totalCount = 0;


        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);


        List<DM_Jimutetuzuki> jimutetuzukiList =
            workflowDomManager.getJimutetuzukisBySubSystemId(IKhozenCommonConstants.SUBSYSTEMID_HOZEN);

        SortDM_Jimutetuzuki sortDM_Jimutetuzuki = new SortDM_Jimutetuzuki();


        List<DM_Jimutetuzuki> jimutetuzukiListSortAfter =
            sortDM_Jimutetuzuki.OrderDM_JimutetuzukiByHyoujijyunAsc(jimutetuzukiList);



        String tyouhyouYmd = DateFormatUtil.dateKANJI(pSyoriYmd);


        String subSystemNm = baseDomManager.
            getSubSystem(IKhozenCommonConstants.SUBSYSTEMID_HOZEN).getSubSystemNm();

        int kensuu = jimutetuzukiListSortAfter.size();



        List<ReportServicesBean> reportServicesBeanList = new ArrayList<>();

        int jimuTetuzukiCdKensuu = 0;


        for (int i = 0; i < kensuu; i++){


            List<IReportDataSouceBean> reportDataSouceBeanLst = new ArrayList<>();


            try(ExDBResults<IT_KhHubiMikaisyouList> khhubimikaisyouList =
                hozenDomManager.getKhHubiMikaisyouListsByKakutyoujobcdJimutetuzukicd(pKakutyouJobCd,
                    jimutetuzukiListSortAfter.get(i).getJimutetuzukicd())) {

                BzRecoveryDatasikibetuBean recoveryDatasikibetuBean =
                    SWAKInjector.getInstance(BzRecoveryDatasikibetuBean.class);


                for (IT_KhHubiMikaisyouList khhubimikaisyou : khhubimikaisyouList){


                    recoveryDatasikibetuBean.setIbKakutyoujobcd(pKakutyouJobCd);

                    recoveryDatasikibetuBean.setIbTableid("IT_KhHubiMikaisyouList");

                    recoveryDatasikibetuBean.setIbRecoveryfilterid("Kh002");


                    recoveryDatasikibetuBean.setIbRecoveryfilterkey1(khhubimikaisyou.getJimutetuzukicd());

                    recoveryDatasikibetuBean.setIbRecoveryfilterkey2(khhubimikaisyou.getSyono());


                    recoveryDatasikibetuBean.setIbRecoveryfilterkey3(khhubimikaisyou.getHassinsakikbn().getValue());


                    totalCount += 1;

                    jimuTetuzukiCdKensuu += 1;


                    C_UmuKbn tyoukiHubiUmu = C_UmuKbn.NONE;

                    KhHubimikaiDataSourceBean khHubimikaiDataSourceBean =
                        SWAKInjector.getInstance(KhHubimikaiDataSourceBean.class);

                    String sksreadYmd = DateFormatUtil.dateKANJI(khhubimikaisyou.getSksreadymd());

                    String fstHubbiHasinYmd =
                        DateFormatUtil.dateKANJI(khhubimikaisyou.getFsthubbihasinymd());

                    String lastHubbiHasinYmd =
                        DateFormatUtil.dateKANJI(khhubimikaisyou.getLasthubbihasinymd());


                    if (khhubimikaisyou.getLasthubbihasinymd().addDays(30).compareTo(pSyoriYmd) < 0) {

                        tyoukiHubiUmu =  C_UmuKbn.ARI;
                    }


                    String hassinsaki = C_HassinsakiKbn.getContentByValue(
                        C_HassinsakiKbn.PATTERN_SELECT, khhubimikaisyou.getHassinsakikbn().getValue());


                    khHubimikaiDataSourceBean.setIrRenno(jimuTetuzukiCdKensuu);

                    khHubimikaiDataSourceBean.setIrSyono(khhubimikaisyou.getSyono());


                    khHubimikaiDataSourceBean.setIrKyknmkj(khhubimikaisyou.getKyknmkj());

                    khHubimikaiDataSourceBean.setIrSksreadymd(sksreadYmd);


                    khHubimikaiDataSourceBean.setIrHassinsaki(hassinsaki);


                    khHubimikaiDataSourceBean.setIrGenponhnkykumu(khhubimikaisyou.getGenponhnkykumu());

                    khHubimikaiDataSourceBean.setIrTrksyanm(khhubimikaisyou.getHubitourokuktntnm());

                    khHubimikaiDataSourceBean.setIrSyouninsyanm(khhubimikaisyou.getHubisyouninktntnm());

                    khHubimikaiDataSourceBean.setIrHassinkaisuu(khhubimikaisyou.getHassinkaisuu());

                    khHubimikaiDataSourceBean.setIrFsthubihasinymd(fstHubbiHasinYmd);

                    khHubimikaiDataSourceBean.setIrLasthubihasinymd(lastHubbiHasinYmd);

                    khHubimikaiDataSourceBean.setIrTyoukihubiumu(tyoukiHubiUmu);

                    reportDataSouceBeanLst.add(khHubimikaiDataSourceBean);
                }
            }


            KhHubimikaiBean khHubimikaiBean = SWAKInjector.getInstance(KhHubimikaiBean.class);


            khHubimikaiBean.setIrSubsystemnm(subSystemNm);

            khHubimikaiBean.setIrTyouhyousakuseiymd(tyouhyouYmd);

            khHubimikaiBean.setIrKensuu(jimuTetuzukiCdKensuu);

            khHubimikaiBean.setIrJimutetuzukinm(jimutetuzukiListSortAfter.get(i).getJimutetuzukinm());


            C_SyoruiCdKbn syoruiCd = getSyoruiCdKbn(jimutetuzukiListSortAfter.get(i).getJimutetuzukicd());


            ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
                IKhozenCommonConstants.SUBSYSTEMID_HOZEN,
                pCategoryId,
                pKinouId,
                syoruiCd);


            reportServicesBean.setSyoriYmd(pSyoriYmd);


            reportServicesBean.addParamObjects(reportDataSouceBeanLst, khHubimikaiBean);

            reportServicesBeanList.add(reportServicesBean);


            jimuTetuzukiCdKensuu = 0;
        }



        createReport.execNoCommit(reportServicesBeanList);

        return totalCount;
    }

    private C_SyoruiCdKbn getSyoruiCdKbn(String pJimuTetuzukiCd) {


        C_SyoruiCdKbn syoruiCdKbn = null;


        if (IKhozenCommonConstants.JIMUTETUZUKICD_JYUUSYOHENKOU.equals(pJimuTetuzukiCd)) {


            syoruiCdKbn = C_SyoruiCdKbn.KK_ADRHNK_HBLIST;
        }

        else if (IKhozenCommonConstants.JIMUTETUZUKICD_MEIGIHENKOU.equals(pJimuTetuzukiCd)) {


            syoruiCdKbn = C_SyoruiCdKbn.KK_MEIGIHNK_HBLIST;
        }

        else if (IKhozenCommonConstants.JIMUTETUZUKICD_STDRSKYTKYKTYTHK.equals(pJimuTetuzukiCd)) {


            syoruiCdKbn = C_SyoruiCdKbn.KK_STDRHNK_HBLIST;
        }

        else if (IKhozenCommonConstants.JIMUTETUZUKICD_SEINEGAPPISEITS.equals(pJimuTetuzukiCd)) {


            syoruiCdKbn = C_SyoruiCdKbn.KK_SEINENGAPPISEI_HBLIST;
        }

        else if (IKhozenCommonConstants.JIMUTETUZUKICD_GENGAKU.equals(pJimuTetuzukiCd)) {


            syoruiCdKbn = C_SyoruiCdKbn.KK_GENGAKU_HBLIST;
        }

        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KAIYAKU.equals(pJimuTetuzukiCd)) {


            syoruiCdKbn = C_SyoruiCdKbn.KK_KAIYAKU_HBLIST;
        }

        else if (IKhozenCommonConstants.JIMUTETUZUKICD_SYOUKENSAIHAKKOU.equals(pJimuTetuzukiCd)) {


            syoruiCdKbn = C_SyoruiCdKbn.KK_SYOSAIHK_HBLIST;
        }

        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KEIYAKUTORIKESI.equals(pJimuTetuzukiCd)) {


            syoruiCdKbn = C_SyoruiCdKbn.KK_KYKTORIKESI_HBLIST;
        }

        else if (IKhozenCommonConstants.JIMUTETUZUKICD_COOLINGOFF.equals(pJimuTetuzukiCd)) {


            syoruiCdKbn = C_SyoruiCdKbn.KK_CLGOFF_HBLIST;
        }

        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KAIJYO.equals(pJimuTetuzukiCd)) {


            syoruiCdKbn = C_SyoruiCdKbn.KK_KAIJYO_HBLIST;
        }

        else if (IKhozenCommonConstants.JIMUTETUZUKICD_MUKOU.equals(pJimuTetuzukiCd)) {


            syoruiCdKbn = C_SyoruiCdKbn.KK_MUKOU_HBLIST;
        }

        else if (IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUKAIJYO.equals(pJimuTetuzukiCd)) {


            syoruiCdKbn = C_SyoruiCdKbn.KK_SBKAIJYO_HBLIST;
        }

        else if (IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMNSK.equals(pJimuTetuzukiCd)) {


            syoruiCdKbn = C_SyoruiCdKbn.KK_SBMENSEKI_HBLIST;
        }

        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KAIGOMAEBARAITKHENKOU.equals(pJimuTetuzukiCd)) {


            syoruiCdKbn = C_SyoruiCdKbn.KK_KAIGOMAETKHNK_HBLIST;
        }

        else if (IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMUKOUKBRPARI.equals(pJimuTetuzukiCd)) {


            syoruiCdKbn = C_SyoruiCdKbn.KK_SBMUKOU_HBLIST;
        }

        else if (IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMUKOUSHRNASI.equals(pJimuTetuzukiCd)) {


            syoruiCdKbn = C_SyoruiCdKbn.KK_SBMUKOUNOSHR_HBLIST;
        }

        else if (IKhozenCommonConstants.JIMUTETUZUKICD_SIBOUMNSKSHRNASI.equals(pJimuTetuzukiCd)) {


            syoruiCdKbn = C_SyoruiCdKbn.KK_SBMENSEKINOSHR_HBLIST;
        }

        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KHMKHGKHENKOU.equals(pJimuTetuzukiCd)) {


            syoruiCdKbn = C_SyoruiCdKbn.KK_MKHGKHNK_HBLIST;
        }

        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KHYENDTHNKHRSHR.equals(pJimuTetuzukiCd)) {


            syoruiCdKbn = C_SyoruiCdKbn.KK_YENDTHNKHNRKN_HBLIST;
        }

        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KHTMTTKINITEN.equals(pJimuTetuzukiCd)) {


            syoruiCdKbn = C_SyoruiCdKbn.KK_TUMITATEKINITEN_HBLIST;
        }

        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KHDSHR.equals(pJimuTetuzukiCd)) {


            syoruiCdKbn = C_SyoruiCdKbn.KK_DSHR_HBLIST;
        }

        else if (IKhozenCommonConstants.JIMUTETUZUKICD_HARAIKATAHENKOU.equals(pJimuTetuzukiCd)) {


            syoruiCdKbn = C_SyoruiCdKbn.AS_HRHN_HBLIST;
        }

        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KHYENDTHNKUKTKNINI.equals(pJimuTetuzukiCd)) {


            syoruiCdKbn = C_SyoruiCdKbn.KK_YENDTHNK_NINI_HBLIST;
        }


        else if (IKhozenCommonConstants.JIMUTETUZUKICD_KHKZKTRKKYKDRHNK.equals(pJimuTetuzukiCd)) {


            syoruiCdKbn = C_SyoruiCdKbn.KK_KZKTRK_KYKDRTKYKHNK_HBLIST;
        }

        return syoruiCdKbn;
    }
}
