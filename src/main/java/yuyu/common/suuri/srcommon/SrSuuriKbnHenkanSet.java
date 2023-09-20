package yuyu.common.suuri.srcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HokenSyuruiKigouSedaiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Kykkaksyrui;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_SrKbnHenkanKbn;
import yuyu.def.classification.C_SuuriKbnHenkanErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;

/**
 * 数理統計 数理共通 数理用区分変換設定
 */
public class SrSuuriKbnHenkanSet {

    @Inject
    private static Logger logger;

    private static final String NUMKETASUU = "^[\\d]{7}$";

    private SrSuuriKbnHenkanBean srSuuriKbnHenkanBean;

    public SrSuuriKbnHenkanSet() {
        super();
    }

    public SrSuuriKbnHenkanBean exec(C_SrKbnHenkanKbn pSrKbnHenkanKbn, String pHenkanMaeKbnVal) {

        logger.debug("▽ 数理用区分変換設定 開始");

        srSuuriKbnHenkanBean = SWAKInjector.getInstance(SrSuuriKbnHenkanBean.class);
        srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.OK);
        srSuuriKbnHenkanBean.setSuuriKbnHenkanErrorKbn(C_SuuriKbnHenkanErrorKbn.NONE);

        if (C_SrKbnHenkanKbn.BOSYU_KEITAI.eq(pSrKbnHenkanKbn)) {

            srSuuriKbnHenkanBean = setBoSyuKeiTai(pHenkanMaeKbnVal);
        }
        else if (C_SrKbnHenkanKbn.DAIRITENGYOUSYU.eq(pSrKbnHenkanKbn)) {

            srSuuriKbnHenkanBean = setDaiRiTenGyouSyu(pHenkanMaeKbnVal);
        }
        else if (C_SrKbnHenkanKbn.SEDAI.eq(pSrKbnHenkanKbn)) {

            srSuuriKbnHenkanBean = setSeDai(pHenkanMaeKbnVal);
        }
        else if (C_SrKbnHenkanKbn.SUURI_SIBOUHYOU.eq(pSrKbnHenkanKbn)) {

            srSuuriKbnHenkanBean = setSiBouyou(pHenkanMaeKbnVal);
        }
        else if (C_SrKbnHenkanKbn.SUURI_SIBOUHYOU2.eq(pSrKbnHenkanKbn)) {

            srSuuriKbnHenkanBean = setSiBouhyouKbn2(pHenkanMaeKbnVal);
        }
        else if (C_SrKbnHenkanKbn.SHITEI_DAIRININ.eq(pSrKbnHenkanKbn)) {

            srSuuriKbnHenkanBean = setShiTeiDaiRiNin(pHenkanMaeKbnVal);
        }
        else if (C_SrKbnHenkanKbn.KEIYAKU_HIHOKEN_DOU.eq(pSrKbnHenkanKbn)) {

            srSuuriKbnHenkanBean = setKeiYakuHiHoKen(pHenkanMaeKbnVal);
        }
        else if (C_SrKbnHenkanKbn.KETTEI_KEKKA.eq(pSrKbnHenkanKbn)) {

            srSuuriKbnHenkanBean = setKeTteiKeKka(pHenkanMaeKbnVal);
        }
        else if (C_SrKbnHenkanKbn.KEIYAKU_KAKUNI_SYU.eq(pSrKbnHenkanKbn)) {

            srSuuriKbnHenkanBean = setKeiYakuKakuNinSyu(pHenkanMaeKbnVal);
        }
        else if (C_SrKbnHenkanKbn.SHIIN.eq(pSrKbnHenkanKbn)) {

            srSuuriKbnHenkanBean = setShiIn(pHenkanMaeKbnVal);
        }
        else if (C_SrKbnHenkanKbn.SHIHARAI_HASSEI_JIYUU.eq(pSrKbnHenkanKbn)) {

            srSuuriKbnHenkanBean = setShiHaraiHaSseiJiYuu(pHenkanMaeKbnVal);
        }
        else if (C_SrKbnHenkanKbn.SHIHARAI_KAISUU.eq(pSrKbnHenkanKbn)) {

            srSuuriKbnHenkanBean = setShiHaraiKaiSuu(pHenkanMaeKbnVal);
        }
        else if (C_SrKbnHenkanKbn.NENKIN_D_UKETORI.eq(pSrKbnHenkanKbn)) {

            srSuuriKbnHenkanBean = setNenKinDUkeToRi(pHenkanMaeKbnVal);
        }
        else if (C_SrKbnHenkanKbn.SUURI_HAITOU.eq(pSrKbnHenkanKbn)) {

            srSuuriKbnHenkanBean = setHaitouKbn(pHenkanMaeKbnVal);
        }
        else if (C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA.eq(pSrKbnHenkanKbn)) {

            srSuuriKbnHenkanBean = setKeiyakudateTuukaKbn(pHenkanMaeKbnVal);
        }
        else if (C_SrKbnHenkanKbn.SUURI_NYUUSYUKKIN_TUUKA.eq(pSrKbnHenkanKbn)) {

            srSuuriKbnHenkanBean = setNyuusyukkinTuukaKbn(pHenkanMaeKbnVal);
        }
        else if (C_SrKbnHenkanKbn.TUUKA_SYU.eq(pSrKbnHenkanKbn)) {

            srSuuriKbnHenkanBean = setTuukasyu(pHenkanMaeKbnVal);
        }
        else if (C_SrKbnHenkanKbn.SUURI_SISUU.eq(pSrKbnHenkanKbn)) {

            srSuuriKbnHenkanBean = setSisuuKbn(pHenkanMaeKbnVal);
        }
        else if (C_SrKbnHenkanKbn.NENKINGATA.eq(pSrKbnHenkanKbn)) {

            srSuuriKbnHenkanBean = setNenKinGaTa(pHenkanMaeKbnVal);
        }
        else if (C_SrKbnHenkanKbn.HRK_KAISUU .eq(pSrKbnHenkanKbn)) {

            srSuuriKbnHenkanBean = setHaraikomiKaisuuKbn(pHenkanMaeKbnVal);
        }
        else if (C_SrKbnHenkanKbn.HRK_KEIRO.eq(pSrKbnHenkanKbn)) {

            srSuuriKbnHenkanBean = setHaraikomiKeiroKbn(pHenkanMaeKbnVal);
        }
        else if (C_SrKbnHenkanKbn.KYK_JYOUTAI.eq(pSrKbnHenkanKbn)) {

            srSuuriKbnHenkanBean = setKeiyakujyoutai(pHenkanMaeKbnVal);
        }
        else {

            srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
            srSuuriKbnHenkanBean.setSuuriKbnHenkanErrorKbn(C_SuuriKbnHenkanErrorKbn.TARGETERROR);
            srSuuriKbnHenkanBean.setHenkanAtoKbn("");
        }

        logger.debug("△ 数理用区分変換設定 終了");

        return srSuuriKbnHenkanBean;
    }

    public SrSuuriKbnHenkanBean exec2(
        C_SrKbnHenkanKbn pSrKbnHenkanKbn,
        String pHenkanMaeKbnVal1,
        String pHenkanMaeKbnVal2) {

        logger.debug("▽ 数理用区分変換設定（区分変換２） 開始");

        srSuuriKbnHenkanBean = SWAKInjector.getInstance(SrSuuriKbnHenkanBean.class);
        srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.OK);
        srSuuriKbnHenkanBean.setSuuriKbnHenkanErrorKbn(C_SuuriKbnHenkanErrorKbn.NONE);

        if (C_SrKbnHenkanKbn.SYOKEIYAKU.eq(pSrKbnHenkanKbn) || C_SrKbnHenkanKbn.SUURISYURUI.eq(pSrKbnHenkanKbn)) {

            srSuuriKbnHenkanBean = setSyuuKeiYakuSu(pHenkanMaeKbnVal1);

            if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

                srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.OK);
                srSuuriKbnHenkanBean.setSuuriKbnHenkanErrorKbn(C_SuuriKbnHenkanErrorKbn.NONE);

                srSuuriKbnHenkanBean = setSyuuKeiYakuSu2(pHenkanMaeKbnVal1, pHenkanMaeKbnVal2);
            }
        }
        else {

            srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
            srSuuriKbnHenkanBean.setSuuriKbnHenkanErrorKbn(C_SuuriKbnHenkanErrorKbn.TARGETERROR);
            srSuuriKbnHenkanBean.setHenkanAtoKbn("");
        }

        logger.debug("△ 数理用区分変換設定（区分変換２） 終了");

        return srSuuriKbnHenkanBean;
    }
    private SrSuuriKbnHenkanBean setBoSyuKeiTai(String pHenkanMaeKbnVal) {

        Boolean result = pHenkanMaeKbnVal.matches(NUMKETASUU);

        String dairiten2cd = "";

        if (result) {

            dairiten2cd = pHenkanMaeKbnVal.substring(0, 2);
        }
        else {

            srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
            srSuuriKbnHenkanBean.setSuuriKbnHenkanErrorKbn(C_SuuriKbnHenkanErrorKbn.INPUTERROR);
            srSuuriKbnHenkanBean.setHenkanAtoKbn("");

            return srSuuriKbnHenkanBean;
        }

        if (dairiten2cd.equals("51") || dairiten2cd.equals("52") || dairiten2cd.equals("53") ||
            dairiten2cd.equals("54") || dairiten2cd.equals("55") || dairiten2cd.equals("56") ||
            dairiten2cd.equals("57")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("21");
        }
        else if (dairiten2cd.equals("11") || dairiten2cd.equals("12") || dairiten2cd.equals("13") ||
            dairiten2cd.equals("14") || dairiten2cd.equals("15") || dairiten2cd.equals("16")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("22");
        }
        else if (dairiten2cd.equals("21")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("23");
        }
        else if (dairiten2cd.equals("27") || dairiten2cd.equals("28")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("24");
        }
        else if (dairiten2cd.equals("30")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("25");
        }
        else if (dairiten2cd.equals("40")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("26");
        }
        else if (dairiten2cd.equals("71")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("42");
        }
        else if (dairiten2cd.equals("72")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("41");
        }
        else if (dairiten2cd.equals("73")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("43");
        }
        else if (dairiten2cd.equals("74")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("44");
        }
        else {

            srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
            srSuuriKbnHenkanBean.setSuuriKbnHenkanErrorKbn(C_SuuriKbnHenkanErrorKbn.TARGETERROR);
            srSuuriKbnHenkanBean.setHenkanAtoKbn("");
        }

        return srSuuriKbnHenkanBean;
    }

    private SrSuuriKbnHenkanBean setDaiRiTenGyouSyu(String pHenkanMaeKbnVal) {

        Boolean result = pHenkanMaeKbnVal.matches(NUMKETASUU);

        String dairiten2cd = "";
        if (result) {

            dairiten2cd = pHenkanMaeKbnVal.substring(0, 2);
        }
        else {

            srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
            srSuuriKbnHenkanBean.setSuuriKbnHenkanErrorKbn(C_SuuriKbnHenkanErrorKbn.INPUTERROR);
            srSuuriKbnHenkanBean.setHenkanAtoKbn("");

            return srSuuriKbnHenkanBean;
        }

        if (dairiten2cd.equals("51") || dairiten2cd.equals("52") || dairiten2cd.equals("53") ||
            dairiten2cd.equals("54") || dairiten2cd.equals("55") || dairiten2cd.equals("56") ||
            dairiten2cd.equals("57")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("01");
        }
        else if (dairiten2cd.equals("11") || dairiten2cd.equals("12") || dairiten2cd.equals("13") ||
            dairiten2cd.equals("14") || dairiten2cd.equals("15") || dairiten2cd.equals("16")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("02");
        }
        else if (dairiten2cd.equals("21")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("03");
        }
        else if (dairiten2cd.equals("27") || dairiten2cd.equals("28")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("04");
        }
        else if (dairiten2cd.equals("30")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("05");
        }
        else if (dairiten2cd.equals("40")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("06");
        }
        else if (dairiten2cd.equals("71") || dairiten2cd.equals("72") ||
            dairiten2cd.equals("73") || dairiten2cd.equals("74")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("07");
        }
        else {

            srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
            srSuuriKbnHenkanBean.setSuuriKbnHenkanErrorKbn(C_SuuriKbnHenkanErrorKbn.TARGETERROR);
            srSuuriKbnHenkanBean.setHenkanAtoKbn("");
        }

        return srSuuriKbnHenkanBean;
    }

    private SrSuuriKbnHenkanBean setSeDai(String pHenkanMaeKbnVal) {

        if (C_HokenSyuruiKigouSedaiKbn.RYOU17.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("A170");
        }
        else if (C_HokenSyuruiKigouSedaiKbn.RYOU18_4.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("A180");
        }

        else if (pHenkanMaeKbnVal.equals("L")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("A181");
        }

        else {

            srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
            srSuuriKbnHenkanBean.setSuuriKbnHenkanErrorKbn(C_SuuriKbnHenkanErrorKbn.TARGETERROR);
            srSuuriKbnHenkanBean.setHenkanAtoKbn("");
        }

        return srSuuriKbnHenkanBean;
    }

    private SrSuuriKbnHenkanBean setSiBouyou(String pHenkanMaeKbnVal) {

        if (C_HokenSyuruiKigouSedaiKbn.RYOU17.getValue().equals(pHenkanMaeKbnVal)
            || C_HokenSyuruiKigouSedaiKbn.RYOU18_4.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("47");
        }
        else if (C_HokenSyuruiKigouSedaiKbn.RYOU18_8.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("56");
        }
        else {

            srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
            srSuuriKbnHenkanBean.setSuuriKbnHenkanErrorKbn(C_SuuriKbnHenkanErrorKbn.TARGETERROR);
            srSuuriKbnHenkanBean.setHenkanAtoKbn("");
        }

        return srSuuriKbnHenkanBean;
    }

    private SrSuuriKbnHenkanBean setSiBouhyouKbn2(String pHenkanMaeKbnVal) {

        if (C_HokenSyuruiKigouSedaiKbn.RYOU18_8.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("42");
        }
        else {

            srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
            srSuuriKbnHenkanBean.setSuuriKbnHenkanErrorKbn(C_SuuriKbnHenkanErrorKbn.TARGETERROR);
            srSuuriKbnHenkanBean.setHenkanAtoKbn("");
        }

        return srSuuriKbnHenkanBean;
    }

    private SrSuuriKbnHenkanBean setShiTeiDaiRiNin(String pHenkanMaeKbnVal) {

        if (C_UktKbn.BLNK.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("0");
        }
        else if (C_UktKbn.NASI.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("0");
        }
        else if (C_UktKbn.KYK.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("2");
        }
        else if (C_UktKbn.TOKUTEIMEIGI.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("5");
        }
        else if (C_UktKbn.SBUK.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("7");
        }
        else if (C_UktKbn.TOUROKUKAZOKU1.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("1");
        }
        else if (C_UktKbn.TOUROKUKAZOKU2.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("4");
        }
        else {

            srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
            srSuuriKbnHenkanBean.setSuuriKbnHenkanErrorKbn(C_SuuriKbnHenkanErrorKbn.TARGETERROR);
            srSuuriKbnHenkanBean.setHenkanAtoKbn("");
        }

        return srSuuriKbnHenkanBean;
    }

    private SrSuuriKbnHenkanBean setKeiYakuHiHoKen(String pHenkanMaeKbnVal) {

        if (C_KykKbn.KEIHI_BETU.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("0");
        }
        else if (C_KykKbn.KEIHI_DOUITU.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("1");
        }
        else {

            srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
            srSuuriKbnHenkanBean.setSuuriKbnHenkanErrorKbn(C_SuuriKbnHenkanErrorKbn.TARGETERROR);
            srSuuriKbnHenkanBean.setHenkanAtoKbn("");
        }

        return srSuuriKbnHenkanBean;
    }

    private SrSuuriKbnHenkanBean setKeTteiKeKka(String pHenkanMaeKbnVal) {

        if (C_Ketkekkacd.MUJYOUKEN.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("1");
        }
        else if (C_Ketkekkacd.GENKAITAI_SYOUDAKU.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("2");
        }
        else {

            srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
            srSuuriKbnHenkanBean.setSuuriKbnHenkanErrorKbn(C_SuuriKbnHenkanErrorKbn.TARGETERROR);
            srSuuriKbnHenkanBean.setHenkanAtoKbn("");
        }

        return srSuuriKbnHenkanBean;
    }

    private SrSuuriKbnHenkanBean setKeiYakuKakuNinSyu(String pHenkanMaeKbnVal) {

        if (C_Kykkaksyrui.BLNK.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("00");
        }
        else if (C_Kykkaksyrui.KETMAE.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("01");
        }
        else if (C_Kykkaksyrui.KETHORYU.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("12");
        }
        else if (C_Kykkaksyrui.SEIRITUGO.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("21");
        }
        else {

            srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
            srSuuriKbnHenkanBean.setSuuriKbnHenkanErrorKbn(C_SuuriKbnHenkanErrorKbn.TARGETERROR);
            srSuuriKbnHenkanBean.setHenkanAtoKbn("");
        }

        return srSuuriKbnHenkanBean;
    }

    private SrSuuriKbnHenkanBean setShiIn(String pHenkanMaeKbnVal) {

        if (C_SiinKbn.SG.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("1");
        }
        else if (C_SiinKbn.JS.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("2");
        }
        else if (C_SiinKbn.SP.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("3");
        }
        else {

            srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
            srSuuriKbnHenkanBean.setSuuriKbnHenkanErrorKbn(C_SuuriKbnHenkanErrorKbn.TARGETERROR);
            srSuuriKbnHenkanBean.setHenkanAtoKbn("");
        }

        return srSuuriKbnHenkanBean;
    }

    private SrSuuriKbnHenkanBean setSyuuKeiYakuSu(String pHenkanMaeKbnVal) {

        if (pHenkanMaeKbnVal.equals("ﾕｱ")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("0S");
        }
        else if (pHenkanMaeKbnVal.equals("ﾕｲ")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("0T");
        }
        else if (pHenkanMaeKbnVal.equals("ﾕｳ")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("0S");
        }
        else if (pHenkanMaeKbnVal.equals("ﾕｴ")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("0T");
        }
        else if (pHenkanMaeKbnVal.equals("ﾕｵ")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("0S");
        }
        else if (pHenkanMaeKbnVal.equals("ﾕｶ")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("0T");
        }
        else if (pHenkanMaeKbnVal.equals("ﾕｷ")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("0S");
        }
        else if (pHenkanMaeKbnVal.equals("ﾕｸ")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("0T");
        }
        else if (pHenkanMaeKbnVal.equals("ﾕｹ") ||
            pHenkanMaeKbnVal.equals("ﾕｺ") ||
            pHenkanMaeKbnVal.equals("ﾕｻ") ||
            pHenkanMaeKbnVal.equals("ﾕｼ")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("E7");
        }
        else if (pHenkanMaeKbnVal.equals("ﾕｽ") ||
            pHenkanMaeKbnVal.equals("ﾕｾ") ||
            pHenkanMaeKbnVal.equals("ﾕｿ") ||
            pHenkanMaeKbnVal.equals("ﾕﾀ")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("E8");
        }
        else if (pHenkanMaeKbnVal.equals("ﾕA")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("0U");
        }
        else if (pHenkanMaeKbnVal.equals("ﾕB") ||
            pHenkanMaeKbnVal.equals("ﾕC") ||
            pHenkanMaeKbnVal.equals("ﾕD") ||
            pHenkanMaeKbnVal.equals("ﾕE")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("E9");
        }
        else if (pHenkanMaeKbnVal.equals("ﾕﾁ") ||
            pHenkanMaeKbnVal.equals("ﾕﾂ") ||
            pHenkanMaeKbnVal.equals("ﾕﾃ") ||
            pHenkanMaeKbnVal.equals("ﾕﾄ")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("F0");
        }
        else if (pHenkanMaeKbnVal.equals("ﾕﾅ") ||
            pHenkanMaeKbnVal.equals("ﾕﾆ") ||
            pHenkanMaeKbnVal.equals("ﾕﾇ") ||
            pHenkanMaeKbnVal.equals("ﾕﾈ")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("F1");
        }
        else if (pHenkanMaeKbnVal.equals("ﾕﾉ")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("1C");
        }
        else if (pHenkanMaeKbnVal.equals("ﾕﾊ")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("1D");
        }
        else if (pHenkanMaeKbnVal.equals("ﾕﾋ")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("1C");
        }
        else if (pHenkanMaeKbnVal.equals("ﾕﾌ")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("1D");
        }

        else if (pHenkanMaeKbnVal.equals("ﾕﾍ") ||
            pHenkanMaeKbnVal.equals("ﾕﾎ") ||
            pHenkanMaeKbnVal.equals("ﾕﾏ") ||
            pHenkanMaeKbnVal.equals("ﾕﾐ")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("F2");
        }

        else if (pHenkanMaeKbnVal.equals("ﾕﾑ") ||
            pHenkanMaeKbnVal.equals("ﾕﾒ") ||
            pHenkanMaeKbnVal.equals("ﾕﾓ") ||
            pHenkanMaeKbnVal.equals("ﾕﾔ")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("F3");
        }

        else if (pHenkanMaeKbnVal.equals("ﾕﾕ") ||
            pHenkanMaeKbnVal.equals("ﾕﾖ") ||
            pHenkanMaeKbnVal.equals("ﾕﾗ") ||
            pHenkanMaeKbnVal.equals("ﾕﾘ")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("F4");
        }

        else if (pHenkanMaeKbnVal.equals("ﾕﾙ") ||
            pHenkanMaeKbnVal.equals("ﾕﾚ") ||
            pHenkanMaeKbnVal.equals("ﾕﾛ") ||
            pHenkanMaeKbnVal.equals("ﾕﾜ")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("F5");
        }
        else if (pHenkanMaeKbnVal.equals("ﾕF")) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("1E");
        }
        else {

            srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
            srSuuriKbnHenkanBean.setSuuriKbnHenkanErrorKbn(C_SuuriKbnHenkanErrorKbn.TARGETERROR);
            srSuuriKbnHenkanBean.setHenkanAtoKbn("");
        }

        return srSuuriKbnHenkanBean;
    }

    private SrSuuriKbnHenkanBean setSyuuKeiYakuSu2(String pHenkanMaeKbnVal1, String pHenkanMaeKbnVal2) {

        if (pHenkanMaeKbnVal1.equals("ﾆｱ") && C_Tuukasyu.JPY.getValue().equals(pHenkanMaeKbnVal2)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("1F");

            return srSuuriKbnHenkanBean;
        }
        else if (pHenkanMaeKbnVal1.equals("ﾆｱ") && C_Tuukasyu.USD.getValue().equals(pHenkanMaeKbnVal2)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("1G");

            return srSuuriKbnHenkanBean;
        }
        else {
            srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
            srSuuriKbnHenkanBean.setSuuriKbnHenkanErrorKbn(C_SuuriKbnHenkanErrorKbn.TARGETERROR);
            srSuuriKbnHenkanBean.setHenkanAtoKbn("");
        }

        return srSuuriKbnHenkanBean;
    }

    private SrSuuriKbnHenkanBean setShiHaraiHaSseiJiYuu(String pHenkanMaeKbnVal) {

        srSuuriKbnHenkanBean.setHenkanAtoKbn("");

        return srSuuriKbnHenkanBean;
    }

    private SrSuuriKbnHenkanBean setShiHaraiKaiSuu(String pHenkanMaeKbnVal) {

        srSuuriKbnHenkanBean.setHenkanAtoKbn("");

        return srSuuriKbnHenkanBean;
    }

    private SrSuuriKbnHenkanBean setNenKinDUkeToRi(String pHenkanMaeKbnVal) {

        srSuuriKbnHenkanBean.setHenkanAtoKbn("");

        return srSuuriKbnHenkanBean;
    }

    private SrSuuriKbnHenkanBean setTuukasyu(String pHenkanMaeKbnVal) {

        if (C_Tuukasyu.JPY.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("1");

            return srSuuriKbnHenkanBean;
        }
        else if (C_Tuukasyu.USD.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("2");

            return srSuuriKbnHenkanBean;
        }
        else if (C_Tuukasyu.EUR.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("3");

            return srSuuriKbnHenkanBean;
        }
        else if (C_Tuukasyu.AUD.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("4");

            return srSuuriKbnHenkanBean;
        }
        else {
            srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
            srSuuriKbnHenkanBean.setSuuriKbnHenkanErrorKbn(C_SuuriKbnHenkanErrorKbn.TARGETERROR);
            srSuuriKbnHenkanBean.setHenkanAtoKbn("");
        }

        return srSuuriKbnHenkanBean;
    }

    private SrSuuriKbnHenkanBean setHaitouKbn(String pHenkanMaeKbnVal) {

        if (C_HaitouKbn.YUUHAI.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("0");
        }
        else if (C_HaitouKbn.RISAHAI.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("1");
        }
        else if (C_HaitouKbn.NONE.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("2");
        }
        else {

            srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
            srSuuriKbnHenkanBean.setSuuriKbnHenkanErrorKbn(C_SuuriKbnHenkanErrorKbn.TARGETERROR);
            srSuuriKbnHenkanBean.setHenkanAtoKbn("");
        }

        return srSuuriKbnHenkanBean;
    }

    private SrSuuriKbnHenkanBean setKeiyakudateTuukaKbn(String pHenkanMaeKbnVal) {

        if (C_Tuukasyu.BLNK.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("0");
        }
        else if (C_Tuukasyu.JPY.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("0");
        }
        else if (C_Tuukasyu.USD.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("1");
        }
        else if (C_Tuukasyu.AUD.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("2");
        }
        else {

            srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
            srSuuriKbnHenkanBean.setSuuriKbnHenkanErrorKbn(C_SuuriKbnHenkanErrorKbn.TARGETERROR);
            srSuuriKbnHenkanBean.setHenkanAtoKbn("");
        }

        return srSuuriKbnHenkanBean;
    }

    private SrSuuriKbnHenkanBean setNyuusyukkinTuukaKbn(String pHenkanMaeKbnVal) {

        if (C_Tuukasyu.BLNK.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("0");
        }
        else if (C_Tuukasyu.JPY.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("1");
        }
        else if (C_Tuukasyu.USD.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("2");
        }
        else if (C_Tuukasyu.AUD.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("3");
        }
        else {

            srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
            srSuuriKbnHenkanBean.setSuuriKbnHenkanErrorKbn(C_SuuriKbnHenkanErrorKbn.TARGETERROR);
            srSuuriKbnHenkanBean.setHenkanAtoKbn("");
        }

        return srSuuriKbnHenkanBean;
    }

    private SrSuuriKbnHenkanBean setSisuuKbn(String pHenkanMaeKbnVal) {

        if (C_Sisuukbn.BLNK.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("00");
        }
        else if (C_Sisuukbn.BLCON1.getValue().equals(pHenkanMaeKbnVal) ||
            C_Sisuukbn.BLCON2.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("01");
        }
        else {

            srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
            srSuuriKbnHenkanBean.setSuuriKbnHenkanErrorKbn(C_SuuriKbnHenkanErrorKbn.TARGETERROR);
            srSuuriKbnHenkanBean.setHenkanAtoKbn("");
        }

        return srSuuriKbnHenkanBean;
    }

    private SrSuuriKbnHenkanBean setNenKinGaTa(String pHenkanMaeKbnVal) {

        if (C_Nenkinsyu.BLNK.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("0");
        }
        else if (C_Nenkinsyu.KAKUTEINENKIN.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("1");
        }
        else if (C_Nenkinsyu.SGKHSYSYSNNENKIN.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("3");
        }
        else if (C_Nenkinsyu.KAKUTEIDAI1NENKINBAIGK.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("7");
        }
        else {

            srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
            srSuuriKbnHenkanBean.setSuuriKbnHenkanErrorKbn(C_SuuriKbnHenkanErrorKbn.TARGETERROR);
            srSuuriKbnHenkanBean.setHenkanAtoKbn("");
        }

        return srSuuriKbnHenkanBean;
    }
    private SrSuuriKbnHenkanBean setHaraikomiKaisuuKbn(String pHenkanMaeKbnVal) {

        if (C_Hrkkaisuu.TUKI.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("3");
        }
        else if (C_Hrkkaisuu.HALFY.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("2");
        }
        else if (C_Hrkkaisuu.NEN.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("1");
        }
        else if (C_Hrkkaisuu.ITIJI.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("0");
        }
        else {

            srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
            srSuuriKbnHenkanBean.setSuuriKbnHenkanErrorKbn(C_SuuriKbnHenkanErrorKbn.TARGETERROR);
            srSuuriKbnHenkanBean.setHenkanAtoKbn("");
        }

        return srSuuriKbnHenkanBean;
    }
    private SrSuuriKbnHenkanBean setHaraikomiKeiroKbn(String pHenkanMaeKbnVal) {

        if (C_Hrkkeiro.BLNK.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("");
        }
        else if (C_Hrkkeiro.KOUHURI.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("1");
        }
        else if (C_Hrkkeiro.DANTAI.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("2");
        }
        else if (C_Hrkkeiro.SYUUDAN.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("6");
        }
        else if (C_Hrkkeiro.HURIKAE.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("4");
        }
        else if (C_Hrkkeiro.CREDIT.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("6");
        }
        else {

            srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
            srSuuriKbnHenkanBean.setSuuriKbnHenkanErrorKbn(C_SuuriKbnHenkanErrorKbn.TARGETERROR);
            srSuuriKbnHenkanBean.setHenkanAtoKbn("");
        }

        return srSuuriKbnHenkanBean;
    }
    private SrSuuriKbnHenkanBean setKeiyakujyoutai(String pHenkanMaeKbnVal) {

        if (C_Kykjyoutai.HRKMTYUU.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("0");
        }
        else if (C_Kykjyoutai.HARAIMAN.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("2");
        }
        else if (C_Kykjyoutai.HARAIZUMI.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("3");
        }
        else if (C_Kykjyoutai.ENTYOU.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("4");
        }
        else if (C_Kykjyoutai.PMEN.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("6");
        }
        else if (C_Kykjyoutai.ZENNOU.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("0");
        }
        else if (C_Kykjyoutai.IKKATUNK.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("0");
        }
        else if (C_Kykjyoutai.ITIJIBARAI.getValue().equals(pHenkanMaeKbnVal)) {

            srSuuriKbnHenkanBean.setHenkanAtoKbn("1");
        }
        else {

            srSuuriKbnHenkanBean.setKekkaKbn(C_ErrorKbn.ERROR);
            srSuuriKbnHenkanBean.setSuuriKbnHenkanErrorKbn(C_SuuriKbnHenkanErrorKbn.TARGETERROR);
            srSuuriKbnHenkanBean.setHenkanAtoKbn("");
        }

        return srSuuriKbnHenkanBean;
    }
}
