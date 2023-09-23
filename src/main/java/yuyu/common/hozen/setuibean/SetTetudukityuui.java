package yuyu.common.hozen.setuibean;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_BikkjnssinfoKbn;
import yuyu.def.classification.C_FatcahankeiiKbn;
import yuyu.def.classification.C_FatcakekKbn;
import yuyu.def.classification.C_FatcasnsiKbn;
import yuyu.def.classification.C_FatcatgKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.db.entity.IT_FatcaInfo;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KykKihon;

/**
 * 契約保全 UiBean設定 手続注意情報設定
 */
public class SetTetudukityuui {

    private static final String BLANK = "";

    public static boolean exec(KhozenCommonParam pKhCParm, SetTetudukityuuiExecUiBeanParam pUiBean) {

        String syono = pUiBean.getSyono();

        IT_KhTtdkTyuui khTtdkTyuui = pKhCParm.getKkTetudukiTyuui(syono);
        List<IT_FatcaInfo> fatcaInfoLst = pKhCParm.getFatcaInfo(syono);
        IT_KykKihon kykKihon = pKhCParm.getKeiyakuKihon(syono);

        List<TtdktyuuikbnInfoDataSourceBeanCommonParam> beanLst = new ArrayList<>();

        if (khTtdkTyuui == null) {
            pUiBean.setVtdktkktyuitakbn(C_KktyuitaKbn.BLNK);
            pUiBean.setVtdktttdktyuuinaiyou1(BLANK);
            pUiBean.setVtdktttdktyuuinaiyou2(BLANK);
            pUiBean.setVtdktttdktyuuinaiyou3(BLANK);
            pUiBean.convertTtdktyuuikbnInfoForCommonParam(beanLst);
        }
        else {

            BzGetSosikiData sosikiData= SWAKInjector.getInstance(BzGetSosikiData.class);

            if (!C_TtdktyuuiKbn.BLNK.eq(khTtdkTyuui.getTtdktyuuikbn1())) {
                String setSosikinm1 = sosikiData.exec(khTtdkTyuui.getSetsosikicd1(), null).getKanjisosikinm20();
                TtdktyuuikbnInfoDataSourceBeanCommonParam ttdktyuuikbnInfoDataSourceBeanCommonParam1 =
                    pUiBean.createTtdktyuuikbnInfoDataSourceBean();
                ttdktyuuikbnInfoDataSourceBeanCommonParam1.setVtdktttdktyuuikbn(khTtdkTyuui.getTtdktyuuikbn1());
                ttdktyuuikbnInfoDataSourceBeanCommonParam1.setVtdktttdktyikbnhsknaiyou(
                    khTtdkTyuui.getTtdktyuuikbnhsknaiyou1());
                ttdktyuuikbnInfoDataSourceBeanCommonParam1.setVtdktttdktyuuikbnsetymd(
                    khTtdkTyuui.getTtdktyuuikbnsetymd1());
                ttdktyuuikbnInfoDataSourceBeanCommonParam1.setVtdktsetsosikinm(setSosikinm1);
                beanLst.add(ttdktyuuikbnInfoDataSourceBeanCommonParam1);
            }

            if (!C_TtdktyuuiKbn.BLNK.eq(khTtdkTyuui.getTtdktyuuikbn2())) {
                String setSosikinm2 = sosikiData.exec(khTtdkTyuui.getSetsosikicd2(), null).getKanjisosikinm20();
                TtdktyuuikbnInfoDataSourceBeanCommonParam ttdktyuuikbnInfoDataSourceBeanCommonParam2 =
                    pUiBean.createTtdktyuuikbnInfoDataSourceBean();
                ttdktyuuikbnInfoDataSourceBeanCommonParam2.setVtdktttdktyuuikbn(khTtdkTyuui.getTtdktyuuikbn2());
                ttdktyuuikbnInfoDataSourceBeanCommonParam2.setVtdktttdktyikbnhsknaiyou(
                    khTtdkTyuui.getTtdktyuuikbnhsknaiyou2());
                ttdktyuuikbnInfoDataSourceBeanCommonParam2.setVtdktttdktyuuikbnsetymd(
                    khTtdkTyuui.getTtdktyuuikbnsetymd2());
                ttdktyuuikbnInfoDataSourceBeanCommonParam2.setVtdktsetsosikinm(setSosikinm2);
                beanLst.add(ttdktyuuikbnInfoDataSourceBeanCommonParam2);
            }

            if (!C_TtdktyuuiKbn.BLNK.eq(khTtdkTyuui.getTtdktyuuikbn3())) {
                String setSosikinm3 = sosikiData.exec(khTtdkTyuui.getSetsosikicd3(), null).getKanjisosikinm20();
                TtdktyuuikbnInfoDataSourceBeanCommonParam ttdktyuuikbnInfoDataSourceBeanCommonParam3 =
                    pUiBean.createTtdktyuuikbnInfoDataSourceBean();
                ttdktyuuikbnInfoDataSourceBeanCommonParam3.setVtdktttdktyuuikbn(khTtdkTyuui.getTtdktyuuikbn3());
                ttdktyuuikbnInfoDataSourceBeanCommonParam3.setVtdktttdktyikbnhsknaiyou(
                    khTtdkTyuui.getTtdktyuuikbnhsknaiyou3());
                ttdktyuuikbnInfoDataSourceBeanCommonParam3.setVtdktttdktyuuikbnsetymd(
                    khTtdkTyuui.getTtdktyuuikbnsetymd3());
                ttdktyuuikbnInfoDataSourceBeanCommonParam3.setVtdktsetsosikinm(setSosikinm3);
                beanLst.add(ttdktyuuikbnInfoDataSourceBeanCommonParam3);
            }

            if (!C_TtdktyuuiKbn.BLNK.eq(khTtdkTyuui.getTtdktyuuikbn4())) {
                String setSosikinm4 = sosikiData.exec(khTtdkTyuui.getSetsosikicd4(), null).getKanjisosikinm20();
                TtdktyuuikbnInfoDataSourceBeanCommonParam ttdktyuuikbnInfoDataSourceBeanCommonParam4 =
                    pUiBean.createTtdktyuuikbnInfoDataSourceBean();
                ttdktyuuikbnInfoDataSourceBeanCommonParam4.setVtdktttdktyuuikbn(khTtdkTyuui.getTtdktyuuikbn4());
                ttdktyuuikbnInfoDataSourceBeanCommonParam4.setVtdktttdktyikbnhsknaiyou(
                    khTtdkTyuui.getTtdktyuuikbnhsknaiyou4());
                ttdktyuuikbnInfoDataSourceBeanCommonParam4.setVtdktttdktyuuikbnsetymd(
                    khTtdkTyuui.getTtdktyuuikbnsetymd4());
                ttdktyuuikbnInfoDataSourceBeanCommonParam4.setVtdktsetsosikinm(setSosikinm4);
                beanLst.add(ttdktyuuikbnInfoDataSourceBeanCommonParam4);
            }

            if (!C_TtdktyuuiKbn.BLNK.eq(khTtdkTyuui.getTtdktyuuikbn5())) {
                String setSosikinm5 = sosikiData.exec(khTtdkTyuui.getSetsosikicd5(), null).getKanjisosikinm20();
                TtdktyuuikbnInfoDataSourceBeanCommonParam ttdktyuuikbnInfoDataSourceBeanCommonParam5 =
                    pUiBean.createTtdktyuuikbnInfoDataSourceBean();
                ttdktyuuikbnInfoDataSourceBeanCommonParam5.setVtdktttdktyuuikbn(khTtdkTyuui.getTtdktyuuikbn5());
                ttdktyuuikbnInfoDataSourceBeanCommonParam5.setVtdktttdktyikbnhsknaiyou(
                    khTtdkTyuui.getTtdktyuuikbnhsknaiyou5());
                ttdktyuuikbnInfoDataSourceBeanCommonParam5.setVtdktttdktyuuikbnsetymd(
                    khTtdkTyuui.getTtdktyuuikbnsetymd5());
                ttdktyuuikbnInfoDataSourceBeanCommonParam5.setVtdktsetsosikinm(setSosikinm5);
                beanLst.add(ttdktyuuikbnInfoDataSourceBeanCommonParam5);
            }

            pUiBean.convertTtdktyuuikbnInfoForCommonParam(beanLst);
            pUiBean.setVtdktkktyuitakbn(khTtdkTyuui.getKktyuitakbn());
            pUiBean.setVtdktttdktyuuinaiyou1(khTtdkTyuui.getTtdktyuuinaiyou1());
            pUiBean.setVtdktttdktyuuinaiyou2(khTtdkTyuui.getTtdktyuuinaiyou2());
            pUiBean.setVtdktttdktyuuinaiyou3(khTtdkTyuui.getTtdktyuuinaiyou3());

        }

        if (kykKihon != null) {
            pUiBean.setVtdktstknsetkbn(kykKihon.getStknsetkbn());
        }
        else {
            pUiBean.setVtdktstknsetkbn(C_StknsetKbn.BLNK);
        }

        if (fatcaInfoLst == null ) {
            pUiBean.setVtdktdispsyoriymd1(null);
            pUiBean.setVtdktdispfatcasnsikbn1(C_FatcasnsiKbn.BLNK);
            pUiBean.setVtdktdispbikkjnssinfokbn1(C_BikkjnssinfoKbn.BLNK);
            pUiBean.setVtdktdispfatcakekkbn1(C_FatcakekKbn.BLNK);
            pUiBean.setVtdktdispfatcahankeiikbn1(C_FatcahankeiiKbn.BLNK);
            pUiBean.setVtdktdispbikknzsyno1(BLANK);
            pUiBean.setVtdktdispsyomeiymd1(null);
            pUiBean.setVtdktdispfatcatgkbn1(C_FatcatgKbn.BLNK);
            pUiBean.setVtdktdispnmkn1(BLANK);
            pUiBean.setVtdktdispnmkj1(BLANK);
            pUiBean.setVtdktdispseiymd1(null);
            pUiBean.setVtdktdispsei1(C_Seibetu.BLNK);
            pUiBean.setVtdktdispkouryokuendymd1(null);
            pUiBean.setVtdktdispsyoriymd2(null);
            pUiBean.setVtdktdispfatcasnsikbn2(C_FatcasnsiKbn.BLNK);
            pUiBean.setVtdktdispbikkjnssinfokbn2(C_BikkjnssinfoKbn.BLNK);
            pUiBean.setVtdktdispfatcakekkbn2(C_FatcakekKbn.BLNK);
            pUiBean.setVtdktdispfatcahankeiikbn2(C_FatcahankeiiKbn.BLNK);
            pUiBean.setVtdktdispbikknzsyno2(BLANK);
            pUiBean.setVtdktdispsyomeiymd2(null);
            pUiBean.setVtdktdispfatcatgkbn2(C_FatcatgKbn.BLNK);
            pUiBean.setVtdktdispnmkn2(BLANK);
            pUiBean.setVtdktdispnmkj2(BLANK);
            pUiBean.setVtdktdispseiymd2(null);
            pUiBean.setVtdktdispsei2(C_Seibetu.BLNK);
            pUiBean.setVtdktdispkouryokuendymd2(null);
            pUiBean.setVtdktdispsyoriymd3(null);
            pUiBean.setVtdktdispfatcasnsikbn3(C_FatcasnsiKbn.BLNK);
            pUiBean.setVtdktdispbikkjnssinfokbn3(C_BikkjnssinfoKbn.BLNK);
            pUiBean.setVtdktdispfatcakekkbn3(C_FatcakekKbn.BLNK);
            pUiBean.setVtdktdispfatcahankeiikbn3(C_FatcahankeiiKbn.BLNK);
            pUiBean.setVtdktdispbikknzsyno3(BLANK);
            pUiBean.setVtdktdispsyomeiymd3(null);
            pUiBean.setVtdktdispfatcatgkbn3(C_FatcatgKbn.BLNK);
            pUiBean.setVtdktdispnmkn3(BLANK);
            pUiBean.setVtdktdispnmkj3(BLANK);
            pUiBean.setVtdktdispseiymd3(null);
            pUiBean.setVtdktdispsei3(C_Seibetu.BLNK);
            pUiBean.setVtdktdispkouryokuendymd3(null);
            pUiBean.setVtdktdispsyoriymd4(null);
            pUiBean.setVtdktdispfatcasnsikbn4(C_FatcasnsiKbn.BLNK);
            pUiBean.setVtdktdispbikkjnssinfokbn4(C_BikkjnssinfoKbn.BLNK);
            pUiBean.setVtdktdispfatcakekkbn4(C_FatcakekKbn.BLNK);
            pUiBean.setVtdktdispfatcahankeiikbn4(C_FatcahankeiiKbn.BLNK);
            pUiBean.setVtdktdispbikknzsyno4(BLANK);
            pUiBean.setVtdktdispsyomeiymd4(null);
            pUiBean.setVtdktdispfatcatgkbn4(C_FatcatgKbn.BLNK);
            pUiBean.setVtdktdispnmkn4(BLANK);
            pUiBean.setVtdktdispnmkj4(BLANK);
            pUiBean.setVtdktdispseiymd4(null);
            pUiBean.setVtdktdispsei4(C_Seibetu.BLNK);
            pUiBean.setVtdktdispkouryokuendymd4(null);
            pUiBean.setVtdktdispsyoriymd5(null);
            pUiBean.setVtdktdispfatcasnsikbn5(C_FatcasnsiKbn.BLNK);
            pUiBean.setVtdktdispbikkjnssinfokbn5(C_BikkjnssinfoKbn.BLNK);
            pUiBean.setVtdktdispfatcakekkbn5(C_FatcakekKbn.BLNK);
            pUiBean.setVtdktdispfatcahankeiikbn5(C_FatcahankeiiKbn.BLNK);
            pUiBean.setVtdktdispbikknzsyno5(BLANK);
            pUiBean.setVtdktdispsyomeiymd5(null);
            pUiBean.setVtdktdispfatcatgkbn5(C_FatcatgKbn.BLNK);
            pUiBean.setVtdktdispnmkn5(BLANK);
            pUiBean.setVtdktdispnmkj5(BLANK);
            pUiBean.setVtdktdispseiymd5(null);
            pUiBean.setVtdktdispsei5(C_Seibetu.BLNK);
            pUiBean.setVtdktdispkouryokuendymd5(null);
        }
        else {
            for (int idx = 0; idx < fatcaInfoLst.size(); idx++) {
                if (idx == 0) {
                    pUiBean.setVtdktdispsyoriymd1(fatcaInfoLst.get(idx).getSyoriYmd());
                    pUiBean.setVtdktdispfatcasnsikbn1(fatcaInfoLst.get(idx).getFatcasnsikbn());
                    pUiBean.setVtdktdispbikkjnssinfokbn1(fatcaInfoLst.get(idx).getBikkjnssinfokbn());
                    pUiBean.setVtdktdispfatcakekkbn1(fatcaInfoLst.get(idx).getFatcakekkbn());
                    pUiBean.setVtdktdispfatcahankeiikbn1(fatcaInfoLst.get(idx).getFatcahankeiikbn());
                    pUiBean.setVtdktdispbikknzsyno1(fatcaInfoLst.get(idx).getBikknzsyno());
                    pUiBean.setVtdktdispsyomeiymd1(fatcaInfoLst.get(idx).getSyomeiymd());
                    pUiBean.setVtdktdispfatcatgkbn1(fatcaInfoLst.get(idx).getFatcatgkbn());
                    pUiBean.setVtdktdispnmkn1(fatcaInfoLst.get(idx).getNmkn());
                    pUiBean.setVtdktdispnmkj1(fatcaInfoLst.get(idx).getNmkj());
                    pUiBean.setVtdktdispseiymd1(fatcaInfoLst.get(idx).getSeiymd());
                    pUiBean.setVtdktdispsei1(fatcaInfoLst.get(idx).getSeibetu());
                    pUiBean.setVtdktdispkouryokuendymd1(fatcaInfoLst.get(idx).getKouryokuendymd());
                }
                else if (idx == 1) {
                    pUiBean.setVtdktdispsyoriymd2(fatcaInfoLst.get(idx).getSyoriYmd());
                    pUiBean.setVtdktdispfatcasnsikbn2(fatcaInfoLst.get(idx).getFatcasnsikbn());
                    pUiBean.setVtdktdispbikkjnssinfokbn2(fatcaInfoLst.get(idx).getBikkjnssinfokbn());
                    pUiBean.setVtdktdispfatcakekkbn2(fatcaInfoLst.get(idx).getFatcakekkbn());
                    pUiBean.setVtdktdispfatcahankeiikbn2(fatcaInfoLst.get(idx).getFatcahankeiikbn());
                    pUiBean.setVtdktdispbikknzsyno2(fatcaInfoLst.get(idx).getBikknzsyno());
                    pUiBean.setVtdktdispsyomeiymd2(fatcaInfoLst.get(idx).getSyomeiymd());
                    pUiBean.setVtdktdispfatcatgkbn2(fatcaInfoLst.get(idx).getFatcatgkbn());
                    pUiBean.setVtdktdispnmkn2(fatcaInfoLst.get(idx).getNmkn());
                    pUiBean.setVtdktdispnmkj2(fatcaInfoLst.get(idx).getNmkj());
                    pUiBean.setVtdktdispseiymd2(fatcaInfoLst.get(idx).getSeiymd());
                    pUiBean.setVtdktdispsei2(fatcaInfoLst.get(idx).getSeibetu());
                    pUiBean.setVtdktdispkouryokuendymd2(fatcaInfoLst.get(idx).getKouryokuendymd());
                }
                else if (idx == 2) {
                    pUiBean.setVtdktdispsyoriymd3(fatcaInfoLst.get(idx).getSyoriYmd());
                    pUiBean.setVtdktdispfatcasnsikbn3(fatcaInfoLst.get(idx).getFatcasnsikbn());
                    pUiBean.setVtdktdispbikkjnssinfokbn3(fatcaInfoLst.get(idx).getBikkjnssinfokbn());
                    pUiBean.setVtdktdispfatcakekkbn3(fatcaInfoLst.get(idx).getFatcakekkbn());
                    pUiBean.setVtdktdispfatcahankeiikbn3(fatcaInfoLst.get(idx).getFatcahankeiikbn());
                    pUiBean.setVtdktdispbikknzsyno3(fatcaInfoLst.get(idx).getBikknzsyno());
                    pUiBean.setVtdktdispsyomeiymd3(fatcaInfoLst.get(idx).getSyomeiymd());
                    pUiBean.setVtdktdispfatcatgkbn3(fatcaInfoLst.get(idx).getFatcatgkbn());
                    pUiBean.setVtdktdispnmkn3(fatcaInfoLst.get(idx).getNmkn());
                    pUiBean.setVtdktdispnmkj3(fatcaInfoLst.get(idx).getNmkj());
                    pUiBean.setVtdktdispseiymd3(fatcaInfoLst.get(idx).getSeiymd());
                    pUiBean.setVtdktdispsei3(fatcaInfoLst.get(idx).getSeibetu());
                    pUiBean.setVtdktdispkouryokuendymd3(fatcaInfoLst.get(idx).getKouryokuendymd());
                }
                else if (idx == 3) {
                    pUiBean.setVtdktdispsyoriymd4(fatcaInfoLst.get(idx).getSyoriYmd());
                    pUiBean.setVtdktdispfatcasnsikbn4(fatcaInfoLst.get(idx).getFatcasnsikbn());
                    pUiBean.setVtdktdispbikkjnssinfokbn4(fatcaInfoLst.get(idx).getBikkjnssinfokbn());
                    pUiBean.setVtdktdispfatcakekkbn4(fatcaInfoLst.get(idx).getFatcakekkbn());
                    pUiBean.setVtdktdispfatcahankeiikbn4(fatcaInfoLst.get(idx).getFatcahankeiikbn());
                    pUiBean.setVtdktdispbikknzsyno4(fatcaInfoLst.get(idx).getBikknzsyno());
                    pUiBean.setVtdktdispsyomeiymd4(fatcaInfoLst.get(idx).getSyomeiymd());
                    pUiBean.setVtdktdispfatcatgkbn4(fatcaInfoLst.get(idx).getFatcatgkbn());
                    pUiBean.setVtdktdispnmkn4(fatcaInfoLst.get(idx).getNmkn());
                    pUiBean.setVtdktdispnmkj4(fatcaInfoLst.get(idx).getNmkj());
                    pUiBean.setVtdktdispseiymd4(fatcaInfoLst.get(idx).getSeiymd());
                    pUiBean.setVtdktdispsei4(fatcaInfoLst.get(idx).getSeibetu());
                    pUiBean.setVtdktdispkouryokuendymd4(fatcaInfoLst.get(idx).getKouryokuendymd());
                }
                else if (idx == 4) {
                    pUiBean.setVtdktdispsyoriymd5(fatcaInfoLst.get(idx).getSyoriYmd());
                    pUiBean.setVtdktdispfatcasnsikbn5(fatcaInfoLst.get(idx).getFatcasnsikbn());
                    pUiBean.setVtdktdispbikkjnssinfokbn5(fatcaInfoLst.get(idx).getBikkjnssinfokbn());
                    pUiBean.setVtdktdispfatcakekkbn5(fatcaInfoLst.get(idx).getFatcakekkbn());
                    pUiBean.setVtdktdispfatcahankeiikbn5(fatcaInfoLst.get(idx).getFatcahankeiikbn());
                    pUiBean.setVtdktdispbikknzsyno5(fatcaInfoLst.get(idx).getBikknzsyno());
                    pUiBean.setVtdktdispsyomeiymd5(fatcaInfoLst.get(idx).getSyomeiymd());
                    pUiBean.setVtdktdispfatcatgkbn5(fatcaInfoLst.get(idx).getFatcatgkbn());
                    pUiBean.setVtdktdispnmkn5(fatcaInfoLst.get(idx).getNmkn());
                    pUiBean.setVtdktdispnmkj5(fatcaInfoLst.get(idx).getNmkj());
                    pUiBean.setVtdktdispseiymd5(fatcaInfoLst.get(idx).getSeiymd());
                    pUiBean.setVtdktdispsei5(fatcaInfoLst.get(idx).getSeibetu());
                    pUiBean.setVtdktdispkouryokuendymd5(fatcaInfoLst.get(idx).getKouryokuendymd());
                }
            }
        }

        return true;
    }

    public static void init(SetTetudukityuuiExecUiBeanParam pUiBean) {
        pUiBean.setVtdktkktyuitakbn(C_KktyuitaKbn.BLNK);
        pUiBean.setVtdktttdktyuuinaiyou1(BLANK);
        pUiBean.setVtdktttdktyuuinaiyou2(BLANK);
        pUiBean.setVtdktttdktyuuinaiyou3(BLANK);
        pUiBean.setVtdktstknsetkbn(C_StknsetKbn.BLNK);
        pUiBean.setVtdktdispsyoriymd1(null);
        pUiBean.setVtdktdispfatcasnsikbn1(C_FatcasnsiKbn.BLNK);
        pUiBean.setVtdktdispbikkjnssinfokbn1(C_BikkjnssinfoKbn.BLNK);
        pUiBean.setVtdktdispfatcakekkbn1(C_FatcakekKbn.BLNK);
        pUiBean.setVtdktdispfatcahankeiikbn1(C_FatcahankeiiKbn.BLNK);
        pUiBean.setVtdktdispbikknzsyno1(BLANK);
        pUiBean.setVtdktdispsyomeiymd1(null);
        pUiBean.setVtdktdispfatcatgkbn1(C_FatcatgKbn.BLNK);
        pUiBean.setVtdktdispnmkn1(BLANK);
        pUiBean.setVtdktdispnmkj1(BLANK);
        pUiBean.setVtdktdispseiymd1(null);
        pUiBean.setVtdktdispsei1(C_Seibetu.BLNK);
        pUiBean.setVtdktdispkouryokuendymd1(null);
        pUiBean.setVtdktdispsyoriymd2(null);
        pUiBean.setVtdktdispfatcasnsikbn2(C_FatcasnsiKbn.BLNK);
        pUiBean.setVtdktdispbikkjnssinfokbn2(C_BikkjnssinfoKbn.BLNK);
        pUiBean.setVtdktdispfatcakekkbn2(C_FatcakekKbn.BLNK);
        pUiBean.setVtdktdispfatcahankeiikbn2(C_FatcahankeiiKbn.BLNK);
        pUiBean.setVtdktdispbikknzsyno2(BLANK);
        pUiBean.setVtdktdispsyomeiymd2(null);
        pUiBean.setVtdktdispfatcatgkbn2(C_FatcatgKbn.BLNK);
        pUiBean.setVtdktdispnmkn2(BLANK);
        pUiBean.setVtdktdispnmkj2(BLANK);
        pUiBean.setVtdktdispseiymd2(null);
        pUiBean.setVtdktdispsei2(C_Seibetu.BLNK);
        pUiBean.setVtdktdispkouryokuendymd2(null);
        pUiBean.setVtdktdispsyoriymd3(null);
        pUiBean.setVtdktdispfatcasnsikbn3(C_FatcasnsiKbn.BLNK);
        pUiBean.setVtdktdispbikkjnssinfokbn3(C_BikkjnssinfoKbn.BLNK);
        pUiBean.setVtdktdispfatcakekkbn3(C_FatcakekKbn.BLNK);
        pUiBean.setVtdktdispfatcahankeiikbn3(C_FatcahankeiiKbn.BLNK);
        pUiBean.setVtdktdispbikknzsyno3(BLANK);
        pUiBean.setVtdktdispsyomeiymd3(null);
        pUiBean.setVtdktdispfatcatgkbn3(C_FatcatgKbn.BLNK);
        pUiBean.setVtdktdispnmkn3(BLANK);
        pUiBean.setVtdktdispnmkj3(BLANK);
        pUiBean.setVtdktdispseiymd3(null);
        pUiBean.setVtdktdispsei3(C_Seibetu.BLNK);
        pUiBean.setVtdktdispkouryokuendymd3(null);
        pUiBean.setVtdktdispsyoriymd4(null);
        pUiBean.setVtdktdispfatcasnsikbn4(C_FatcasnsiKbn.BLNK);
        pUiBean.setVtdktdispbikkjnssinfokbn4(C_BikkjnssinfoKbn.BLNK);
        pUiBean.setVtdktdispfatcakekkbn4(C_FatcakekKbn.BLNK);
        pUiBean.setVtdktdispfatcahankeiikbn4(C_FatcahankeiiKbn.BLNK);
        pUiBean.setVtdktdispbikknzsyno4(BLANK);
        pUiBean.setVtdktdispsyomeiymd4(null);
        pUiBean.setVtdktdispfatcatgkbn4(C_FatcatgKbn.BLNK);
        pUiBean.setVtdktdispnmkn4(BLANK);
        pUiBean.setVtdktdispnmkj4(BLANK);
        pUiBean.setVtdktdispseiymd4(null);
        pUiBean.setVtdktdispsei4(C_Seibetu.BLNK);
        pUiBean.setVtdktdispkouryokuendymd4(null);
        pUiBean.setVtdktdispsyoriymd5(null);
        pUiBean.setVtdktdispfatcasnsikbn5(C_FatcasnsiKbn.BLNK);
        pUiBean.setVtdktdispbikkjnssinfokbn5(C_BikkjnssinfoKbn.BLNK);
        pUiBean.setVtdktdispfatcakekkbn5(C_FatcakekKbn.BLNK);
        pUiBean.setVtdktdispfatcahankeiikbn5(C_FatcahankeiiKbn.BLNK);
        pUiBean.setVtdktdispbikknzsyno5(BLANK);
        pUiBean.setVtdktdispsyomeiymd5(null);
        pUiBean.setVtdktdispfatcatgkbn5(C_FatcatgKbn.BLNK);
        pUiBean.setVtdktdispnmkn5(BLANK);
        pUiBean.setVtdktdispnmkj5(BLANK);
        pUiBean.setVtdktdispseiymd5(null);
        pUiBean.setVtdktdispsei5(C_Seibetu.BLNK);
        pUiBean.setVtdktdispkouryokuendymd5(null);
        List<TtdktyuuikbnInfoDataSourceBeanCommonParam> beanLst = new ArrayList<>();
        pUiBean.convertTtdktyuuikbnInfoForCommonParam(beanLst);
    }
}

