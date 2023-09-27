package yuyu.common.bosyuu.hbcommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.string.ConvertUtil;
import jp.co.slcs.swak.util.string.StringUtil;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzGetBsInfo;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBean;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebSekMosInputBean;
import yuyu.def.bosyuu.configuration.YuyuBosyuuConfig;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_MdhnSchemeDrtenHyouji;
import yuyu.def.classification.C_SeihowebkengenKbn;
import yuyu.def.classification.C_SeihowebsousasyaKbn;

import com.google.common.base.Strings;

/**
 * 保険募集 保険募集共通 生保Ｗｅｂ権限判定
 */

public class HbSeihoWebHanteiKengen {

    private static final String NYUURYOKUSYAIDKBN_SOUGOUSYOKUINIPPANSYOKUINNADO = "01";

    private static final String NYUURYOKUSYAIDKBN_DAIRITENBOSYUUNIN = "05";

    private static final String NYUURYOKUSYAIDKBN_BERU24_DAIRITENSUPPORTDESK = "56";

    private static final String NYUURYOKUSYAIDKBN_MEDICARESUPPORTDESK = "59";

    private static final String DRTENCD_TIBABANKHONTEN = "5200024";

    private static List<String> ATKISYADRTENHENKAN_IBABANKKJNCD = new ArrayList<String>();

    static {
        ATKISYADRTENHENKAN_IBABANKKJNCD.add("105555");
        ATKISYADRTENHENKAN_IBABANKKJNCD.add("113398");
    }

    private static final String SYORISOSIKIKENGEN_CCSUKYANAYOMIKOMIYOUTANMATU = "6628";

    private static final String SYORISOSIKIKENGEN_MEDEKEASEIMEI_SOSIKICD = "7380000";

    private static List<String> TANMATUKENGEN_KYKSINSABUMON_SOSIKICD3 = new ArrayList<String>();

    static {
        TANMATUKENGEN_KYKSINSABUMON_SOSIKICD3.add("543");
        TANMATUKENGEN_KYKSINSABUMON_SOSIKICD3.add("750");
        TANMATUKENGEN_KYKSINSABUMON_SOSIKICD3.add("540");
        TANMATUKENGEN_KYKSINSABUMON_SOSIKICD3.add("565");
    }

    private static List<String> SIYOUSYAKENGEN_TANMATUSIYOUKBN = new ArrayList<String>();

    static {
        SIYOUSYAKENGEN_TANMATUSIYOUKBN.add("1");
        SIYOUSYAKENGEN_TANMATUSIYOUKBN.add("2");
        SIYOUSYAKENGEN_TANMATUSIYOUKBN.add("6");
        SIYOUSYAKENGEN_TANMATUSIYOUKBN.add("7");
        SIYOUSYAKENGEN_TANMATUSIYOUKBN.add("8");
    }

    private static List<String> KRKAISYAKENGEN_NYUURYOKUSYAIDKBN = new ArrayList<String>();

    static {
        KRKAISYAKENGEN_NYUURYOKUSYAIDKBN.add("01");
        KRKAISYAKENGEN_NYUURYOKUSYAIDKBN.add("02");
        KRKAISYAKENGEN_NYUURYOKUSYAIDKBN.add("03");
        KRKAISYAKENGEN_NYUURYOKUSYAIDKBN.add("05");
        KRKAISYAKENGEN_NYUURYOKUSYAIDKBN.add("07");
        KRKAISYAKENGEN_NYUURYOKUSYAIDKBN.add("08");
        KRKAISYAKENGEN_NYUURYOKUSYAIDKBN.add("10");
        KRKAISYAKENGEN_NYUURYOKUSYAIDKBN.add("11");
        KRKAISYAKENGEN_NYUURYOKUSYAIDKBN.add("21");
        KRKAISYAKENGEN_NYUURYOKUSYAIDKBN.add("22");
        KRKAISYAKENGEN_NYUURYOKUSYAIDKBN.add("23");
        KRKAISYAKENGEN_NYUURYOKUSYAIDKBN.add("47");
        KRKAISYAKENGEN_NYUURYOKUSYAIDKBN.add("90");
        KRKAISYAKENGEN_NYUURYOKUSYAIDKBN.add("56");
        KRKAISYAKENGEN_NYUURYOKUSYAIDKBN.add("59");
    }

    private static List<String> ATKISYAHANTEI_SAPODE_SOSIKICD3 = new ArrayList<String>();

    static {
        ATKISYAHANTEI_SAPODE_SOSIKICD3.add("744");
        ATKISYAHANTEI_SAPODE_SOSIKICD3.add("897");
        ATKISYAHANTEI_SAPODE_SOSIKICD3.add("910");
        ATKISYAHANTEI_SAPODE_SOSIKICD3.add("615");
        ATKISYAHANTEI_SAPODE_SOSIKICD3.add("890");
    }

    private static List<String> ATKISYAHANTEI_KONSARUTENGUDESUKU_NYUURYOKUSYAIDKBN = new ArrayList<String>();

    static {
        ATKISYAHANTEI_KONSARUTENGUDESUKU_NYUURYOKUSYAIDKBN.add("22");
        ATKISYAHANTEI_KONSARUTENGUDESUKU_NYUURYOKUSYAIDKBN.add("23");
    }

    private static String FORMAT_KYKADRDATA = "^手数料確認用住所（[０-９]{7}）$";

    private String nyuuryokusyaIdKbn = null;

    private String nyuuryokusyaIdCd = null;

    //  private String hakkouNo = null;

    private String tanmatuSiyouKbn = null;

    //  private String tanmatuGroupKbn = null;

    private String sosikiCd = null;

    public HbSeihoWebHanteiKengen() {
        super();
    }

    public C_SeihowebkengenKbn execChkTanmatuKengen(WsBzWebserviceReqParamBean pWsBzWebserviceReqParamBean) {

        paramSplit(pWsBzWebserviceReqParamBean);

        if (SYORISOSIKIKENGEN_MEDEKEASEIMEI_SOSIKICD.equals(sosikiCd)) {

            return C_SeihowebkengenKbn.TANMATUERROR;
        }

        if (SYORISOSIKIKENGEN_CCSUKYANAYOMIKOMIYOUTANMATU.equals(sosikiCd.substring(0, 4))) {

            return C_SeihowebkengenKbn.TANMATUERROR;
        }

        String sosikiCd4Byte = sosikiCd.substring(3, 4);

        C_SeihowebkengenKbn kengenKbn = C_SeihowebkengenKbn.ARI;

        if (!sosikiCd4Byte.equals("8")) {

            String sosikiCd3 = sosikiCd.substring(0, 3);

            if (!TANMATUKENGEN_KYKSINSABUMON_SOSIKICD3.contains(sosikiCd3)) {

                return C_SeihowebkengenKbn.TANMATUERROR;
            }
        }

        if (!SIYOUSYAKENGEN_TANMATUSIYOUKBN.contains(tanmatuSiyouKbn)) {

            return C_SeihowebkengenKbn.SIYOUSHAERROR;
        }

        if (!KRKAISYAKENGEN_NYUURYOKUSYAIDKBN.contains(nyuuryokusyaIdKbn)) {

            kengenKbn = C_SeihowebkengenKbn.TANMATUERROR;
        }

        return kengenKbn;
    }

    public C_SeihowebkengenKbn execChkDairitenKengen(WsBzWebserviceReqParamBean pWsBzWebserviceReqParamBean,
        List<BzGetAgInfoBean> pBzGetAgInfoBeanLstA,
        List<BzGetAgInfoBean> pBzGetAgInfoBeanLstB) {

        paramSplit(pWsBzWebserviceReqParamBean);

        String aAtkisyaOyadrtenCd = "";
        String bAtkisyaOyadrtenCd = "";
        String sousasyaOyadrtenCd = "";
        C_MdhnSchemeDrtenHyouji mdhnSchemeDrtenHyouji = C_MdhnSchemeDrtenHyouji.BLNK;

        if (pBzGetAgInfoBeanLstA != null && pBzGetAgInfoBeanLstA.size() > 0) {

            for (BzGetAgInfoBean bzGetAgInfoBean: pBzGetAgInfoBeanLstA) {

                if (C_DiritenjyouhouKbn.KEISYOUOYA.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {

                    aAtkisyaOyadrtenCd = bzGetAgInfoBean.getDrtenCd();
                    mdhnSchemeDrtenHyouji = bzGetAgInfoBean.getMdhnSchemeDrtenHyouji();

                    break;
                }
            }
        }

        if (pBzGetAgInfoBeanLstB != null && pBzGetAgInfoBeanLstB.size() > 0) {

            for (BzGetAgInfoBean bzGetAgInfoBean: pBzGetAgInfoBeanLstB) {

                if (C_DiritenjyouhouKbn.KEISYOUOYA.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {

                    bAtkisyaOyadrtenCd = bzGetAgInfoBean.getDrtenCd();

                    break;
                }
            }
        }

        if(Strings.isNullOrEmpty(aAtkisyaOyadrtenCd)) {

            return C_SeihowebkengenKbn.DRTENSYOUKAERROR;
        }

        List<String> syoukaiKanouDrtnCdList = YuyuBosyuuConfig.getInstance().getSyoukaiKanouDrtnCdList();

        if(!mdhnSchemeDrtenHyouji.eq(C_MdhnSchemeDrtenHyouji.MDHNSCHEME) &&
            !syoukaiKanouDrtnCdList.contains(aAtkisyaOyadrtenCd)) {

            return C_SeihowebkengenKbn.KEIYAKUERROR;
        }

        if (nyuuryokusyaIdKbn.equals(NYUURYOKUSYAIDKBN_DAIRITENBOSYUUNIN)) {

            BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);

            BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfo.exec(nyuuryokusyaIdCd);

            if(bzGetBsInfoBean == null) {

                return C_SeihowebkengenKbn.DRTENSYOUKAERROR;
            }
            else if (bzGetBsInfoBean.getBosyuuTrkNo() == null) {

                return C_SeihowebkengenKbn.DRTENSYOUKAERROR;
            }
            else {

                BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
                List<BzGetAgInfoBean> bzGetAgInfoList = bzGetAgInfo.exec(bzGetBsInfoBean.getDairiten1Cd());

                for (BzGetAgInfoBean bzGetAgInfoBean: bzGetAgInfoList) {

                    if (C_DiritenjyouhouKbn.KEISYOUOYA.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {

                        sousasyaOyadrtenCd = bzGetAgInfoBean.getDrtenCd();

                        break;
                    }
                }
            }

            C_SeihowebkengenKbn sousasyaOyadrtenCk = C_SeihowebkengenKbn.DRTENSYOUKAERROR;

            if (sousasyaOyadrtenCd.equals(aAtkisyaOyadrtenCd)) {

                sousasyaOyadrtenCk = C_SeihowebkengenKbn.ARI;
            }
            else if (sousasyaOyadrtenCd.equals(bAtkisyaOyadrtenCd)) {

                sousasyaOyadrtenCk = C_SeihowebkengenKbn.ARI;
            }

            return sousasyaOyadrtenCk;
        }
        else {
            if(NYUURYOKUSYAIDKBN_SOUGOUSYOKUINIPPANSYOKUINNADO.equals(nyuuryokusyaIdKbn) ||
                NYUURYOKUSYAIDKBN_BERU24_DAIRITENSUPPORTDESK.equals(nyuuryokusyaIdKbn) ||
                NYUURYOKUSYAIDKBN_MEDICARESUPPORTDESK.equals(nyuuryokusyaIdKbn) ){
                return C_SeihowebkengenKbn.ARI;
            }
            else {
                return C_SeihowebkengenKbn.DRTENSYOUKAERROR;
            }
        }
    }

    public C_SeihowebsousasyaKbn getSeihowebUserKbn(WsBzWebserviceReqParamBean pWsBzWebserviceReqParamBean, String pAAtukaikojinCd) {

        paramSplit(pWsBzWebserviceReqParamBean);

        if (ATKISYAHANTEI_SAPODE_SOSIKICD3.contains(sosikiCd.substring(0, 3))) {

            return C_SeihowebsousasyaKbn.SUPPORTDESK;
        }

        if(!NYUURYOKUSYAIDKBN_DAIRITENBOSYUUNIN.equals(nyuuryokusyaIdKbn)) {

            return C_SeihowebsousasyaKbn.SUPPORTDESK;
        }

        return C_SeihowebsousasyaKbn.DIRTNBSYNN;
    }

    public String convDairiten(WsBzWebserviceReqParamBean pWsBzWebserviceReqParamBean, String pConvDrtencd) {

        paramSplit(pWsBzWebserviceReqParamBean);

        if (NYUURYOKUSYAIDKBN_SOUGOUSYOKUINIPPANSYOKUINNADO.equals(nyuuryokusyaIdKbn) &&
            ATKISYADRTENHENKAN_IBABANKKJNCD.contains(nyuuryokusyaIdCd)) {

            return DRTENCD_TIBABANKHONTEN;
        }

        return pConvDrtencd;
    }

    public String convAddressToDairiten(WsHbSeihoWebSekMosInputBean pWsHbSeihoWebSekMosInputBean, String pConvDrtencd) {

        String kykAdrData = pWsHbSeihoWebSekMosInputBean.getIwsKanjitsinkaiadr();
        String henkanDrtencd = "";

        kykAdrData = StringUtil.lrTrim(kykAdrData);


        if (kykAdrData != null && kykAdrData.matches(FORMAT_KYKADRDATA)) {
            henkanDrtencd = ConvertUtil.fromZenNumeric(kykAdrData.substring(kykAdrData.indexOf("（") + 1,
                kykAdrData.indexOf("）")));
        }
        else {
            henkanDrtencd = pConvDrtencd;
        }

        return henkanDrtencd;
    }

    private void paramSplit(WsBzWebserviceReqParamBean pWsBzWebserviceReqParamBean) {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = pWsBzWebserviceReqParamBean;

        nyuuryokusyaIdKbn = wsBzWebserviceReqParamBean.getOperatorId().substring(0, 2);

        nyuuryokusyaIdCd = wsBzWebserviceReqParamBean.getOperatorId().substring(2, 8);

        //      hakkouNo = wsBzWebserviceReqParamBean.getOperatorId().substring(8, 10);

        tanmatuSiyouKbn = wsBzWebserviceReqParamBean.getOperatorId().substring(10, 11);

        //      tanmatuGroupKbn = wsBzWebserviceReqParamBean.getOperatorId().substring(11);

        sosikiCd = wsBzWebserviceReqParamBean.getOrgCode();
    }
}
