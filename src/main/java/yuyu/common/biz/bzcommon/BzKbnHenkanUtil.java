package yuyu.common.biz.bzcommon;

import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;

/**
 * <B>区分変換処理を実施するクラス</B><BR>
 * <BR>
 * 特定の条件に従って、変換対象の区分値を変換する。<BR>
 * <BR>
 * <BR>
 */
public class BzKbnHenkanUtil {

    public KbnInfoBean convKbn(String before,Class<?> clazz, C_SystemRenkeiHenkanHoukouKbn direction){

        KbnInfoBean kbnInfoBean = new KbnInfoBean();
        kbnInfoBean.setHenkanFlg(false);
        kbnInfoBean.setKbnData(before);

        if(!(before != null && clazz != null && direction != null)){
            return kbnInfoBean;
        }

        String kbnName = clazz.getSimpleName();

        try {
            switch(kbnName){
                case "C_Tdk" :
                    kbnInfoBean = getC_Tdk(before,direction);
                    break;
                case "C_HknkknsmnKbn" :
                    kbnInfoBean = getC_HknkknsmnKbn(before,direction);
                    break;
                case "C_HrkkknsmnKbn" :
                    kbnInfoBean = getC_HrkkknsmnKbn(before,direction);
                    break;
                case "C_Hhknsei" :
                    kbnInfoBean = getC_Hhknsei(before,direction);
                    break;
                case "C_Hrkkaisuu" :
                    kbnInfoBean = getC_Hrkkaisuu(before,direction);
                    break;
                case "C_Sdpd" :
                    kbnInfoBean = getC_Sdpd(before,direction);
                    break;
                case "C_HaitoukinuketorihouKbn" :
                    kbnInfoBean = getC_HaitoukinuketorihouKbn(before,direction);
                    break;
                case "C_StknsetKbn" :
                    kbnInfoBean = getC_StknsetKbn(before,direction);
                    break;
                case "C_HaitouKbn" :
                    kbnInfoBean = getC_HaitouKbn(before,direction);
                    break;
                case "C_Kyksei" :
                    kbnInfoBean = getC_Kyksei(before,direction);
                    break;
                case "C_UktKbn" :
                    kbnInfoBean = getC_UktKbn(before,direction);
                    break;
                case "C_HonninkakuninSyoruiKbn" :
                    kbnInfoBean = getC_HonninkakuninSyoruiKbn(before,direction);
                    break;
                case "C_YokinKbn" :
                    kbnInfoBean = getC_YokinKbn(before,direction);
                    break;
                case "C_Hrkkeiro" :
                    kbnInfoBean = getC_Hrkkeiro(before,direction);
                    break;
                case "C_Kykkaksyrui" :
                    kbnInfoBean = getC_Kykkaksyrui(before,direction);
                    break;
                case "C_FatcakakkekkaKbn" :
                    kbnInfoBean = getC_FatcakakkekkaKbn(before,direction);
                    break;
                case "C_Tuukasyu" :
                    kbnInfoBean = getC_Tuukasyu(before,direction);
                    break;
                case "C_TodouhukenKbn" :
                    kbnInfoBean = getC_TodouhukenKbn(before,direction);
                    break;
                case "C_Kykjyoutai" :
                    kbnInfoBean = getC_Kykjyoutai(before,direction);
                    break;
                case "C_Sisuukbn" :
                    kbnInfoBean = getC_Sisuukbn(before,direction);
                    break;
                case "C_NyknaiyouKbn" :
                    kbnInfoBean = getC_NyknaiyouKbn(before,direction);
                    break;
                case "C_Yuukoukakkekka" :
                    kbnInfoBean = getC_Yuukoukakkekka(before,direction);
                    break;
                case "C_CreditUriageNgJiyuuKbn" :
                    kbnInfoBean = getC_CreditUriageNgJiyuuKbn(before,direction);
                    break;
                case "C_AuthoriKbn" :
                    kbnInfoBean = getC_AuthoriKbn(before,direction);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kbnInfoBean;
    }
    private KbnInfoBean getC_Tdk(String before, C_SystemRenkeiHenkanHoukouKbn direction){

        boolean flg  = true;
        String after = null;
        KbnInfoBean kbnInfoBean = new KbnInfoBean();

        if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER)) {
            switch(before.toString()){
                case "1" :
                    after = "0";
                    break;
                case "2" :
                    after = "1";
                    break;
                case "4" :
                    after = "2";
                    break;
                case "3" :
                    after = "3";
                    break;
                case "7" :
                    after = "4";
                    break;
                case "5" :
                    after = "5";
                    break;
                case "6" :
                    after = "6";
                    break;
                case "8" :
                    after = "7";
                    break;
                case "9" :
                    after = "8";
                    break;
                case "99" :
                    after = "9";
                    break;
                default  :
                    after = before;
                    flg = false;
                    break;
            }
        } else if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY)) {

            switch(before.toString()){
                case "0" :
                    after = "1";
                    break;
                case "1" :
                    after = "2";
                    break;
                case "2" :
                    after = "4";
                    break;
                case "3" :
                    after = "3";
                    break;
                case "4" :
                    after = "7";
                    break;
                case "5" :
                    after = "5";
                    break;
                case "6" :
                    after = "6";
                    break;
                case "7" :
                    after = "8";
                    break;
                case "8" :
                    after = "9";
                    break;
                case "9" :
                    after = "99";
                    break;

                default  :
                    after = before;
                    flg = false;
                    break;
            }

        } else {
            after = before;
            flg = false;
        }

        kbnInfoBean.setHenkanFlg(flg);
        kbnInfoBean.setKbnData(after);

        return kbnInfoBean;
    }

    private KbnInfoBean getC_HknkknsmnKbn(String before, C_SystemRenkeiHenkanHoukouKbn direction){

        boolean flg  = true;
        String after = null;
        KbnInfoBean kbnInfoBean = new KbnInfoBean();

        if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER)) {
            switch(before.toString()){
                case "1" :
                    after = "1";
                    break;
                case "2" :
                    after = "0";
                    break;
                default  :
                    after = before;
                    flg = false;
                    break;
            }
        } else if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY)) {

            switch(before.toString()){
                case "1" :
                    after = "1";
                    break;
                case "0" :
                    after = "2";
                    break;

                default  :
                    after = before;
                    flg = false;
                    break;
            }

        } else {
            after = before;
            flg = false;
        }

        kbnInfoBean.setHenkanFlg(flg);
        kbnInfoBean.setKbnData(after);

        return kbnInfoBean;
    }

    private KbnInfoBean getC_HrkkknsmnKbn(String before, C_SystemRenkeiHenkanHoukouKbn direction){

        boolean flg  = true;
        String after = null;
        KbnInfoBean kbnInfoBean = new KbnInfoBean();

        if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER)) {
            switch(before.toString()){
                case "1" :
                    after = "1";
                    break;
                case "2" :
                    after = "0";
                    break;
                default  :
                    after = before;
                    flg = false;
                    break;
            }
        } else if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY)) {

            switch(before.toString()){
                case "1" :
                    after = "1";
                    break;
                case "0" :
                    after = "2";
                    break;

                default  :
                    after = before;
                    flg = false;
                    break;
            }

        } else {
            after = before;
            flg = false;
        }

        kbnInfoBean.setHenkanFlg(flg);
        kbnInfoBean.setKbnData(after);

        return kbnInfoBean;
    }

    private KbnInfoBean getC_Hhknsei(String before, C_SystemRenkeiHenkanHoukouKbn direction){

        boolean flg  = true;
        String after = null;
        KbnInfoBean kbnInfoBean = new KbnInfoBean();

        if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER)) {
            switch(before.toString()){
                case "1" :
                    after = "1";
                    break;
                case "2" :
                    after = "2";
                    break;
                case "0" :
                    after = "0";
                    break;
                default  :
                    after = before;
                    flg = false;
                    break;
            }
        } else if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY)) {

            switch(before.toString()){
                case "1" :
                    after = "1";
                    break;
                case "2" :
                    after = "2";
                    break;
                case "0" :
                    after = "0";
                    break;

                default  :
                    after = before;
                    flg = false;
                    break;
            }

        } else {
            after = before;
            flg = false;
        }

        kbnInfoBean.setHenkanFlg(flg);
        kbnInfoBean.setKbnData(after);

        return kbnInfoBean;
    }

    private KbnInfoBean getC_Hrkkaisuu(String before, C_SystemRenkeiHenkanHoukouKbn direction){

        boolean flg  = true;
        String after = null;
        KbnInfoBean kbnInfoBean = new KbnInfoBean();

        if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER)) {
            switch(before.toString()){
                case "99" :
                    after = "0";
                    break;
                case "12" :
                    after = "1";
                    break;
                case "6" :
                    after = "2";
                    break;
                case "1" :
                    after = "3";
                    break;
                default  :
                    after = before;
                    flg = false;
                    break;
            }
        } else if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY)) {

            switch(before.toString()){
                case "0" :
                    after = "99";
                    break;
                case "1" :
                    after = "12";
                    break;
                case "2" :
                    after = "6";
                    break;
                case "3" :
                    after = "1";
                    break;

                default  :
                    after = before;
                    flg = false;
                    break;
            }

        } else {
            after = before;
            flg = false;
        }

        kbnInfoBean.setHenkanFlg(flg);
        kbnInfoBean.setKbnData(after);

        return kbnInfoBean;
    }

    private KbnInfoBean getC_Sdpd(String before, C_SystemRenkeiHenkanHoukouKbn direction){

        boolean flg  = true;
        String after = null;
        KbnInfoBean kbnInfoBean = new KbnInfoBean();

        if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER)) {
            switch(before.toString()){
                case "1" :
                    after = "1";
                    break;
                case "2" :
                    after = "2";
                    break;
                default  :
                    after = before;
                    flg = false;
                    break;
            }
        } else if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY)) {

            switch(before.toString()){
                case "1" :
                    after = "1";
                    break;
                case "2" :
                    after = "2";
                    break;

                default  :
                    after = before;
                    flg = false;
                    break;
            }

        } else {
            after = before;
            flg = false;
        }

        kbnInfoBean.setHenkanFlg(flg);
        kbnInfoBean.setKbnData(after);

        return kbnInfoBean;
    }

    private KbnInfoBean getC_HaitoukinuketorihouKbn(String before, C_SystemRenkeiHenkanHoukouKbn direction){

        boolean flg  = true;
        String after = null;
        KbnInfoBean kbnInfoBean = new KbnInfoBean();

        if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER)) {
            switch(before.toString()){
                case "1" :
                    after = "1";
                    break;
                case "0" :
                    after = "0";
                    break;
                default  :
                    after = before;
                    flg = false;
                    break;
            }
        } else if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY)) {

            switch(before.toString()){
                case "1" :
                    after = "1";
                    break;
                case "0" :
                    after = "0";
                    break;

                default  :
                    after = before;
                    flg = false;
                    break;
            }

        } else {
            after = before;
            flg = false;
        }

        kbnInfoBean.setHenkanFlg(flg);
        kbnInfoBean.setKbnData(after);

        return kbnInfoBean;
    }

    private KbnInfoBean getC_StknsetKbn(String before, C_SystemRenkeiHenkanHoukouKbn direction){

        boolean flg  = true;
        String after = null;
        KbnInfoBean kbnInfoBean = new KbnInfoBean();

        if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER)) {
            switch(before.toString()){
                case "1" :
                    after = "1";
                    break;
                default  :
                    after = before;
                    flg = false;
                    break;
            }
        } else if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY)) {

            switch(before.toString()){
                case "1" :
                    after = "1";
                    break;

                default  :
                    after = before;
                    flg = false;
                    break;
            }

        } else {
            after = before;
            flg = false;
        }

        kbnInfoBean.setHenkanFlg(flg);
        kbnInfoBean.setKbnData(after);

        return kbnInfoBean;
    }

    private KbnInfoBean getC_HaitouKbn(String before, C_SystemRenkeiHenkanHoukouKbn direction){

        boolean flg  = true;
        String after = null;
        KbnInfoBean kbnInfoBean = new KbnInfoBean();

        if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER)) {
            switch(before.toString()){
                case "3" :
                    after = "1";
                    break;
                case "2" :
                    after = "2";
                    break;
                case "1" :
                    after = "3";
                    break;
                default  :
                    after = before;
                    flg = false;
                    break;
            }
        } else if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY)) {

            switch(before.toString()){
                case "1" :
                    after = "3";
                    break;
                case "2" :
                    after = "2";
                    break;
                case "3" :
                    after = "1";
                    break;

                default  :
                    after = before;
                    flg = false;
                    break;
            }

        } else {
            after = before;
            flg = false;
        }

        kbnInfoBean.setHenkanFlg(flg);
        kbnInfoBean.setKbnData(after);

        return kbnInfoBean;
    }

    private KbnInfoBean getC_Kyksei(String before, C_SystemRenkeiHenkanHoukouKbn direction){

        boolean flg  = true;
        String after = null;
        KbnInfoBean kbnInfoBean = new KbnInfoBean();

        if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER)) {
            switch(before.toString()){
                case "1" :
                    after = "1";
                    break;
                case "2" :
                    after = "2";
                    break;
                case "3" :
                    after = "3";
                    break;
                case "0" :
                    after = "0";
                    break;
                default  :
                    after = before;
                    flg = false;
                    break;
            }
        } else if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY)) {

            switch(before.toString()){
                case "1" :
                    after = "1";
                    break;
                case "2" :
                    after = "2";
                    break;
                case "3" :
                    after = "3";
                    break;
                case "0" :
                    after = "0";
                    break;

                default  :
                    after = before;
                    flg = false;
                    break;
            }

        } else {
            after = before;
            flg = false;
        }

        kbnInfoBean.setHenkanFlg(flg);
        kbnInfoBean.setKbnData(after);

        return kbnInfoBean;
    }

    private KbnInfoBean getC_UktKbn(String before, C_SystemRenkeiHenkanHoukouKbn direction){

        boolean flg  = true;
        String after = null;
        KbnInfoBean kbnInfoBean = new KbnInfoBean();

        if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER)) {
            switch(before.toString()){
                case "1" :
                    after = "2";
                    break;
                case "2" :
                    after = "1";
                    break;
                case "5" :
                    after = "3";
                    break;
                case "6" :
                    after = "5";
                    break;
                case "0" :
                    after = "0";
                    break;
                default  :
                    after = before;
                    flg = false;
                    break;
            }
        } else if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY)) {

            switch(before.toString()){
                case "2" :
                    after = "1";
                    break;
                case "1" :
                    after = "2";
                    break;
                case "3" :
                    after = "5";
                    break;
                case "5" :
                    after = "6";
                    break;
                case "0" :
                    after = "0";
                    break;

                default  :
                    after = before;
                    flg = false;
                    break;
            }

        } else {
            after = before;
            flg = false;
        }

        kbnInfoBean.setHenkanFlg(flg);
        kbnInfoBean.setKbnData(after);

        return kbnInfoBean;
    }

    private KbnInfoBean getC_HonninkakuninSyoruiKbn(String before, C_SystemRenkeiHenkanHoukouKbn direction){

        boolean flg  = true;
        String after = null;
        KbnInfoBean kbnInfoBean = new KbnInfoBean();

        if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER)) {
            switch(before.toString()){
                case "0" :
                    after = "00";
                    break;
                case "11" :
                    after = "01";
                    break;
                case "12" :
                    after = "02";
                    break;
                case "13" :
                    after = "03";
                    break;
                case "14" :
                    after = "04";
                    break;
                case "15" :
                    after = "05";
                    break;
                case "16" :
                    after = "06";
                    break;
                case "17" :
                    after = "07";
                    break;
                case "18" :
                    after = "08";
                    break;
                case "19" :
                    after = "09";
                    break;
                case "20" :
                    after = "10";
                    break;
                case "21" :
                    after = "11";
                    break;
                case "22" :
                    after = "12";
                    break;
                case "23" :
                    after = "13";
                    break;
                case "24" :
                    after = "14";
                    break;
                case "25" :
                    after = "15";
                    break;
                case "26" :
                    after = "16";
                    break;
                case "27" :
                    after = "17";
                    break;
                case "28" :
                    after = "18";
                    break;
                case "29" :
                    after = "19";
                    break;
                case "30" :
                    after = "20";
                    break;
                case "34" :
                    after = "21";
                    break;
                case "33" :
                    after = "23";
                    break;
                case "32" :
                    after = "24";
                    break;
                case "90" :
                    after = "90";
                    break;
                case "92" :
                    after = "92";
                    break;
                default  :
                    after = before;
                    flg = false;
                    break;
            }
        } else if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY)) {

            switch(before.toString()){
                case "00" :
                    after = "0";
                    break;
                case "01" :
                    after = "11";
                    break;
                case "02" :
                    after = "12";
                    break;
                case "03" :
                    after = "13";
                    break;
                case "04" :
                    after = "14";
                    break;
                case "05" :
                    after = "15";
                    break;
                case "06" :
                    after = "16";
                    break;
                case "07" :
                    after = "17";
                    break;
                case "08" :
                    after = "18";
                    break;
                case "09" :
                    after = "19";
                    break;
                case "10" :
                    after = "20";
                    break;
                case "11" :
                    after = "21";
                    break;
                case "12" :
                    after = "22";
                    break;
                case "13" :
                    after = "23";
                    break;
                case "14" :
                    after = "24";
                    break;
                case "15" :
                    after = "25";
                    break;
                case "16" :
                    after = "26";
                    break;
                case "17" :
                    after = "27";
                    break;
                case "18" :
                    after = "28";
                    break;
                case "19" :
                    after = "29";
                    break;
                case "20" :
                    after = "30";
                    break;
                case "21" :
                    after = "34";
                    break;
                case "23" :
                    after = "33";
                    break;
                case "24" :
                    after = "32";
                    break;
                case "90" :
                    after = "90";
                    break;
                case "92" :
                    after = "92";
                    break;

                default  :
                    after = before;
                    flg = false;
                    break;
            }

        } else {
            after = before;
            flg = false;
        }

        kbnInfoBean.setHenkanFlg(flg);
        kbnInfoBean.setKbnData(after);

        return kbnInfoBean;
    }

    private KbnInfoBean getC_YokinKbn(String before, C_SystemRenkeiHenkanHoukouKbn direction){

        boolean flg  = true;
        String after = null;
        KbnInfoBean kbnInfoBean = new KbnInfoBean();

        if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER)) {
            switch(before.toString()){
                case "1" :
                    after = "1";
                    break;
                case "2" :
                    after = "2";
                    break;
                case "4" :
                    after = "4";
                    break;
                case "9" :
                    after = "9";
                    break;
                default  :
                    after = before;
                    flg = false;
                    break;
            }
        } else if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY)) {

            switch(before.toString()){
                case "1" :
                    after = "1";
                    break;
                case "2" :
                    after = "2";
                    break;
                case "4" :
                    after = "4";
                    break;
                case "9" :
                    after = "9";
                    break;

                default  :
                    after = before;
                    flg = false;
                    break;
            }

        } else {
            after = before;
            flg = false;
        }

        kbnInfoBean.setHenkanFlg(flg);
        kbnInfoBean.setKbnData(after);

        return kbnInfoBean;
    }

    private KbnInfoBean getC_Hrkkeiro(String before, C_SystemRenkeiHenkanHoukouKbn direction){

        boolean flg  = true;
        String after = null;
        KbnInfoBean kbnInfoBean = new KbnInfoBean();

        if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER)) {
            switch(before.toString()){
                case "1" :
                    after = "1";
                    break;
                case "2" :
                    after = "2";
                    break;
                case "4" :
                    after = "4";
                    break;
                case "0" :
                    after = "";
                    break;
                case "6" :
                    after = "6";
                    break;
                default  :
                    after = before;
                    flg = false;
                    break;
            }
        } else if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY)) {

            switch(before.toString()){
                case "1" :
                    after = "1";
                    break;
                case "2" :
                    after = "2";
                    break;
                case "4" :
                    after = "4";
                    break;
                case "" :
                    after = "0";
                    break;
                case "6" :
                    after = "6";
                    break;

                default  :
                    after = before;
                    flg = false;
                    break;
            }

        } else {
            after = before;
            flg = false;
        }

        kbnInfoBean.setHenkanFlg(flg);
        kbnInfoBean.setKbnData(after);

        return kbnInfoBean;
    }

    private KbnInfoBean getC_Kykkaksyrui(String before, C_SystemRenkeiHenkanHoukouKbn direction){

        boolean flg  = true;
        String after = null;
        KbnInfoBean kbnInfoBean = new KbnInfoBean();

        if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER)) {
            switch(before.toString()){
                case "0" :
                    after = "00";
                    break;
                case "1" :
                    after = "01";
                    break;
                case "2" :
                    after = "12";
                    break;
                case "3" :
                    after = "21";
                    break;
                default  :
                    after = before;
                    flg = false;
                    break;
            }
        } else if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY)) {

            switch(before.toString()){
                case "00" :
                    after = "0";
                    break;
                case "01" :
                    after = "1";
                    break;
                case "12" :
                    after = "2";
                    break;
                case "21" :
                    after = "3";
                    break;

                default  :
                    after = before;
                    flg = false;
                    break;
            }

        } else {
            after = before;
            flg = false;
        }

        kbnInfoBean.setHenkanFlg(flg);
        kbnInfoBean.setKbnData(after);

        return kbnInfoBean;
    }

    private KbnInfoBean getC_FatcakakkekkaKbn(String before, C_SystemRenkeiHenkanHoukouKbn direction){

        boolean flg  = true;
        String after = null;
        KbnInfoBean kbnInfoBean = new KbnInfoBean();

        if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER)) {
            switch(before.toString()){
                case "0" :
                    after = "0";
                    break;
                case "1" :
                    after = "1";
                    break;
                case "2" :
                    after = "8";
                    break;
                case "3" :
                    after = "9";
                    break;
                default  :
                    after = before;
                    flg = false;
                    break;
            }
        } else if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY)) {

            switch(before.toString()){
                case "0" :
                    after = "0";
                    break;
                case "1" :
                    after = "1";
                    break;
                case "8" :
                    after = "2";
                    break;
                case "9" :
                    after = "3";
                    break;

                default  :
                    after = before;
                    flg = false;
                    break;
            }

        } else {
            after = before;
            flg = false;
        }

        kbnInfoBean.setHenkanFlg(flg);
        kbnInfoBean.setKbnData(after);

        return kbnInfoBean;
    }

    private KbnInfoBean getC_Tuukasyu(String before, C_SystemRenkeiHenkanHoukouKbn direction){

        boolean flg  = true;
        String after = null;
        KbnInfoBean kbnInfoBean = new KbnInfoBean();

        if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER)) {
            switch(before.toString()){
                case "0" :
                    after = "0";
                    break;
                case "JPY" :
                    after = "1";
                    break;
                case "USD" :
                    after = "2";
                    break;
                case "EUR" :
                    after = "3";
                    break;
                case "AUD" :
                    after = "4";
                    break;
                default  :
                    after = before;
                    flg = false;
                    break;
            }
        } else if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY)) {

            switch(before.toString()){
                case "0" :
                    after = "0";
                    break;
                case "1" :
                    after = "JPY";
                    break;
                case "2" :
                    after = "USD";
                    break;
                case "3" :
                    after = "EUR";
                    break;
                case "4" :
                    after = "AUD";
                    break;

                default  :
                    after = before;
                    flg = false;
                    break;
            }

        } else {
            after = before;
            flg = false;
        }

        kbnInfoBean.setHenkanFlg(flg);
        kbnInfoBean.setKbnData(after);

        return kbnInfoBean;
    }

    private KbnInfoBean getC_TodouhukenKbn(String before, C_SystemRenkeiHenkanHoukouKbn direction){

        boolean flg  = true;
        String after = null;
        KbnInfoBean kbnInfoBean = new KbnInfoBean();

        if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER)) {
            switch(before.toString()){
                case "0" :
                    after = "00";
                    break;
                case "1" :
                    after = "01";
                    break;
                case "2" :
                    after = "02";
                    break;
                case "3" :
                    after = "03";
                    break;
                case "4" :
                    after = "04";
                    break;
                case "5" :
                    after = "05";
                    break;
                case "6" :
                    after = "06";
                    break;
                case "7" :
                    after = "07";
                    break;
                case "8" :
                    after = "08";
                    break;
                case "9" :
                    after = "09";
                    break;
                case "10" :
                    after = "10";
                    break;
                case "11" :
                    after = "11";
                    break;
                case "12" :
                    after = "12";
                    break;
                case "13" :
                    after = "13";
                    break;
                case "14" :
                    after = "14";
                    break;
                case "15" :
                    after = "15";
                    break;
                case "16" :
                    after = "16";
                    break;
                case "17" :
                    after = "17";
                    break;
                case "18" :
                    after = "18";
                    break;
                case "19" :
                    after = "19";
                    break;
                case "20" :
                    after = "20";
                    break;
                case "21" :
                    after = "21";
                    break;
                case "22" :
                    after = "22";
                    break;
                case "23" :
                    after = "23";
                    break;
                case "24" :
                    after = "24";
                    break;
                case "25" :
                    after = "25";
                    break;
                case "26" :
                    after = "26";
                    break;
                case "27" :
                    after = "27";
                    break;
                case "28" :
                    after = "28";
                    break;
                case "29" :
                    after = "29";
                    break;
                case "30" :
                    after = "30";
                    break;
                case "31" :
                    after = "31";
                    break;
                case "32" :
                    after = "32";
                    break;
                case "33" :
                    after = "33";
                    break;
                case "34" :
                    after = "34";
                    break;
                case "35" :
                    after = "35";
                    break;
                case "36" :
                    after = "36";
                    break;
                case "37" :
                    after = "37";
                    break;
                case "38" :
                    after = "38";
                    break;
                case "39" :
                    after = "39";
                    break;
                case "40" :
                    after = "40";
                    break;
                case "41" :
                    after = "41";
                    break;
                case "42" :
                    after = "42";
                    break;
                case "43" :
                    after = "43";
                    break;
                case "44" :
                    after = "44";
                    break;
                case "45" :
                    after = "45";
                    break;
                case "46" :
                    after = "46";
                    break;
                case "47" :
                    after = "47";
                    break;
                default  :
                    after = before;
                    flg = false;
                    break;
            }
        } else if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY)) {

            switch(before.toString()){
                case "00" :
                    after = "0";
                    break;
                case "01" :
                    after = "1";
                    break;
                case "02" :
                    after = "2";
                    break;
                case "03" :
                    after = "3";
                    break;
                case "04" :
                    after = "4";
                    break;
                case "05" :
                    after = "5";
                    break;
                case "06" :
                    after = "6";
                    break;
                case "07" :
                    after = "7";
                    break;
                case "08" :
                    after = "8";
                    break;
                case "09" :
                    after = "9";
                    break;
                case "10" :
                    after = "10";
                    break;
                case "11" :
                    after = "11";
                    break;
                case "12" :
                    after = "12";
                    break;
                case "13" :
                    after = "13";
                    break;
                case "14" :
                    after = "14";
                    break;
                case "15" :
                    after = "15";
                    break;
                case "16" :
                    after = "16";
                    break;
                case "17" :
                    after = "17";
                    break;
                case "18" :
                    after = "18";
                    break;
                case "19" :
                    after = "19";
                    break;
                case "20" :
                    after = "20";
                    break;
                case "21" :
                    after = "21";
                    break;
                case "22" :
                    after = "22";
                    break;
                case "23" :
                    after = "23";
                    break;
                case "24" :
                    after = "24";
                    break;
                case "25" :
                    after = "25";
                    break;
                case "26" :
                    after = "26";
                    break;
                case "27" :
                    after = "27";
                    break;
                case "28" :
                    after = "28";
                    break;
                case "29" :
                    after = "29";
                    break;
                case "30" :
                    after = "30";
                    break;
                case "31" :
                    after = "31";
                    break;
                case "32" :
                    after = "32";
                    break;
                case "33" :
                    after = "33";
                    break;
                case "34" :
                    after = "34";
                    break;
                case "35" :
                    after = "35";
                    break;
                case "36" :
                    after = "36";
                    break;
                case "37" :
                    after = "37";
                    break;
                case "38" :
                    after = "38";
                    break;
                case "39" :
                    after = "39";
                    break;
                case "40" :
                    after = "40";
                    break;
                case "41" :
                    after = "41";
                    break;
                case "42" :
                    after = "42";
                    break;
                case "43" :
                    after = "43";
                    break;
                case "44" :
                    after = "44";
                    break;
                case "45" :
                    after = "45";
                    break;
                case "46" :
                    after = "46";
                    break;
                case "47" :
                    after = "47";
                    break;

                default  :
                    after = before;
                    flg = false;
                    break;
            }

        } else {
            after = before;
            flg = false;
        }

        kbnInfoBean.setHenkanFlg(flg);
        kbnInfoBean.setKbnData(after);

        return kbnInfoBean;
    }

    private KbnInfoBean getC_Kykjyoutai(String before, C_SystemRenkeiHenkanHoukouKbn direction){

        boolean flg  = true;
        String after = null;
        KbnInfoBean kbnInfoBean = new KbnInfoBean();

        if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER)) {
            switch(before.toString()){
                case "9" :
                    after = "01";
                    break;
                case "1" :
                    after = "00";
                    break;
                case "6" :
                    after = "07";
                    break;
                case "7" :
                    after = "09";
                    break;
                default  :
                    after = before;
                    flg = false;
                    break;
            }
        } else if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY)) {

            switch(before.toString()){
                case "01" :
                    after = "9";
                    break;
                case "00" :
                    after = "1";
                    break;
                case "07" :
                    after = "6";
                    break;
                case "09" :
                    after = "7";
                    break;

                default  :
                    after = before;
                    flg = false;
                    break;
            }

        } else {
            after = before;
            flg = false;
        }

        kbnInfoBean.setHenkanFlg(flg);
        kbnInfoBean.setKbnData(after);

        return kbnInfoBean;
    }

    private KbnInfoBean getC_Sisuukbn(String before, C_SystemRenkeiHenkanHoukouKbn direction){

        boolean flg  = true;
        String after = null;
        KbnInfoBean kbnInfoBean = new KbnInfoBean();

        if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER)) {
            switch(before.toString()){
                case "1" :
                    after = "1";
                    break;
                case "2" :
                    after = "2";
                    break;
                default  :
                    after = before;
                    flg = false;
                    break;
            }
        } else if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY)) {

            switch(before.toString()){
                case "1" :
                    after = "1";
                    break;
                case "2" :
                    after = "2";
                    break;

                default  :
                    after = before;
                    flg = false;
                    break;
            }

        } else {
            after = before;
            flg = false;
        }

        kbnInfoBean.setHenkanFlg(flg);
        kbnInfoBean.setKbnData(after);

        return kbnInfoBean;
    }

    private KbnInfoBean getC_NyknaiyouKbn(String before, C_SystemRenkeiHenkanHoukouKbn direction){

        boolean flg  = true;
        String after = null;
        KbnInfoBean kbnInfoBean = new KbnInfoBean();

        if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER)) {
            switch(before.toString()){
                case "1" :
                    after = "01";
                    break;
                case "10" :
                    after = "21";
                    break;
                case "11" :
                    after = "22";
                    break;
                default  :
                    after = before;
                    flg = false;
                    break;
            }
        } else if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY)) {

            switch(before.toString()){
                case "01" :
                    after = "1";
                    break;
                case "21" :
                    after = "10";
                    break;
                case "22" :
                    after = "11";
                    break;

                default  :
                    after = before;
                    flg = false;
                    break;
            }

        } else {
            after = before;
            flg = false;
        }

        kbnInfoBean.setHenkanFlg(flg);
        kbnInfoBean.setKbnData(after);

        return kbnInfoBean;
    }

    private KbnInfoBean getC_Yuukoukakkekka(String before, C_SystemRenkeiHenkanHoukouKbn direction){

        boolean flg  = true;
        String after = null;
        KbnInfoBean kbnInfoBean = new KbnInfoBean();

        if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER)) {
            switch(before.toString()){
                case "2" :
                    after = "1";
                    break;
                case "3" :
                    after = "2";
                    break;
                case "4" :
                    after = "3";
                    break;
                default  :
                    after = before;
                    flg = false;
                    break;
            }
        } else if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY)) {

            switch(before.toString()){
                case "1" :
                    after = "2";
                    break;
                case "2" :
                    after = "3";
                    break;
                case "3" :
                    after = "4";
                    break;

                default  :
                    after = before;
                    flg = false;
                    break;
            }

        } else {
            after = before;
            flg = false;
        }

        kbnInfoBean.setHenkanFlg(flg);
        kbnInfoBean.setKbnData(after);

        return kbnInfoBean;
    }

    private KbnInfoBean getC_CreditUriageNgJiyuuKbn(String before, C_SystemRenkeiHenkanHoukouKbn direction){

        boolean flg  = true;
        String after = null;
        KbnInfoBean kbnInfoBean = new KbnInfoBean();

        if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER)) {
            switch(before.toString()){
                case "99" :
                    after = "0";
                    break;
                case "1" :
                    after = "1";
                    break;
                case "2" :
                    after = "2";
                    break;
                case "5" :
                    after = "5";
                    break;
                case "8" :
                    after = "8";
                    break;
                case "9" :
                    after = "9";
                    break;
                default  :
                    after = before;
                    flg = false;
                    break;
            }
        } else if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY)) {

            switch(before.toString()){
                case "0" :
                    after = "99";
                    break;
                case "1" :
                    after = "1";
                    break;
                case "2" :
                    after = "2";
                    break;
                case "5" :
                    after = "5";
                    break;
                case "8" :
                    after = "8";
                    break;
                case "9" :
                    after = "9";
                    break;

                default  :
                    after = before;
                    flg = false;
                    break;
            }

        } else {
            after = before;
            flg = false;
        }

        kbnInfoBean.setHenkanFlg(flg);
        kbnInfoBean.setKbnData(after);

        return kbnInfoBean;
    }

    private KbnInfoBean getC_AuthoriKbn(String before, C_SystemRenkeiHenkanHoukouKbn direction){

        boolean flg  = true;
        String after = null;
        KbnInfoBean kbnInfoBean = new KbnInfoBean();

        if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER)) {
            switch(before.toString()){
                case "3" :
                    after = "0";
                    break;
                case "1" :
                    after = "1";
                    break;
                case "2" :
                    after = "2";
                    break;
                default  :
                    after = before;
                    flg = false;
                    break;
            }
        } else if(direction.eq(C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY)) {

            switch(before.toString()){
                case "0" :
                    after = "3";
                    break;
                case "1" :
                    after = "1";
                    break;
                case "2" :
                    after = "2";
                    break;

                default  :
                    after = before;
                    flg = false;
                    break;
            }

        } else {
            after = before;
            flg = false;
        }
        kbnInfoBean.setHenkanFlg(flg);
        kbnInfoBean.setKbnData(after);

        return kbnInfoBean;
    }

}
