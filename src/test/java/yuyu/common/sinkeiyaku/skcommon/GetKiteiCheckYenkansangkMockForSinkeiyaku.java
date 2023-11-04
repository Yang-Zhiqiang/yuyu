package yuyu.common.sinkeiyaku.skcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.sinkeiyaku.moschk.CheckTblMosSyouhinTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckTuusanTest_exec;
import yuyu.common.sinkeiyaku.moschk.HandSateiKetteiHanteiTest_exec;
import yuyu.def.classification.C_Tuukasyu;

/**
 * {@link GetKiteiCheckYenkansangk}のモッククラスです。<br />
 */
public class GetKiteiCheckYenkansangkMockForSinkeiyaku extends GetKiteiCheckYenkansangk{

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    public static final String TESTPATTERN10 = "10";

    public static final String TESTPATTERN11 = "11";

    public static final String TESTPATTERN12 = "12";

    public static final String TESTPATTERN13 = "13";

    public static final String TESTPATTERN14 = "14";

    public static final String TESTPATTERN15 = "15";

    public static final String TESTPATTERN16 = "16";

    public static final String TESTPATTERN17 = "17";

    public static final String TESTPATTERN18 = "18";

    public static final String TESTPATTERN19 = "19";

    public static int LoopFlag = 0;
    @Override
    public BizCurrency exec(BizDate pKijyunYmd, BizCurrency pGaku, C_Tuukasyu pTuukaSyu) {

        if (caller == HandSateiKetteiHanteiTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(5000001);
            }

        }
        if (caller == CheckTuusanTest_exec.class) {

            if (SYORIPTN == TESTPATTERN1) {

                return BizCurrency.valueOf(251);
            } else if (SYORIPTN == TESTPATTERN2) {

                return BizCurrency.valueOf(250);
            } else if (SYORIPTN == TESTPATTERN3) {

                return BizCurrency.valueOf(249);
            } else if (SYORIPTN == TESTPATTERN4) {

                return BizCurrency.valueOf(0);
            } else if (SYORIPTN == TESTPATTERN5) {
                if (LoopFlag == 0){
                    LoopFlag ++;
                    return BizCurrency.valueOf(60);
                }else if(LoopFlag == 1){
                    LoopFlag = 0;
                    return BizCurrency.valueOf(70);
                }
            } else if (SYORIPTN == TESTPATTERN6) {
                if (LoopFlag == 0){
                    LoopFlag ++;
                    return BizCurrency.valueOf(190);
                }else if(LoopFlag == 1){
                    LoopFlag = 0;
                    return BizCurrency.valueOf(200);
                }
            } else if (SYORIPTN == TESTPATTERN7) {

                if (LoopFlag == 0){
                    LoopFlag ++;
                    return BizCurrency.valueOf(55);
                }else if(LoopFlag == 1){
                    LoopFlag = 0;
                    return BizCurrency.valueOf(56);
                }
            }
            else if (SYORIPTN == TESTPATTERN8) {
                if(LoopFlag == 0){
                    LoopFlag ++;
                    return BizCurrency.valueOf(170);
                }else if(LoopFlag == 1){
                    LoopFlag = 0;
                    return BizCurrency.valueOf(0);
                }
            }
            else if (SYORIPTN == TESTPATTERN9) {
                if(LoopFlag == 0){
                    LoopFlag ++;
                    return BizCurrency.valueOf(170);
                }else if(LoopFlag == 1){
                    LoopFlag ++;
                    return BizCurrency.valueOf(185);
                }else if(LoopFlag == 2){
                    LoopFlag = 0;
                    return BizCurrency.valueOf(191);
                }
            }else if (SYORIPTN == TESTPATTERN10) {
                if(LoopFlag == 0){
                    LoopFlag ++;
                    return BizCurrency.valueOf(170);
                }else if(LoopFlag == 1){
                    LoopFlag = 0;
                    return BizCurrency.valueOf(190);
                }
            }else if (SYORIPTN == TESTPATTERN11) {
                if(LoopFlag == 0){
                    LoopFlag ++;
                    return BizCurrency.valueOf(200);
                }else if(LoopFlag == 1){
                    LoopFlag = 0;
                    return BizCurrency.valueOf(190);
                }
            }else if (SYORIPTN == TESTPATTERN12) {
                if(LoopFlag == 0){
                    LoopFlag ++;
                    return BizCurrency.valueOf(200);
                }else if(LoopFlag == 1){
                    LoopFlag = 0;
                    return BizCurrency.valueOf(189);
                }
            }else if (SYORIPTN == TESTPATTERN13) {
                if(LoopFlag == 0){
                    LoopFlag ++;
                    return BizCurrency.valueOf(191);
                }else if(LoopFlag == 1){
                    LoopFlag = 0;
                    return BizCurrency.valueOf(0);

                }
            }else if (SYORIPTN == TESTPATTERN14) {
                if(LoopFlag == 0){
                    LoopFlag ++;
                    return BizCurrency.valueOf(191);
                }else if(LoopFlag == 1){
                    LoopFlag = 0;
                    return BizCurrency.valueOf(189);
                }
            } else if (SYORIPTN == TESTPATTERN15) {
                if(LoopFlag == 0){
                    LoopFlag ++;
                    return BizCurrency.valueOf(191);
                }else if(LoopFlag == 1){
                    LoopFlag = 0;
                    return BizCurrency.valueOf(190);
                }
            } else if (SYORIPTN == TESTPATTERN16) {
                if(LoopFlag == 0){
                    LoopFlag ++;
                    return BizCurrency.valueOf(191);
                }else if(LoopFlag == 1){
                    LoopFlag ++;
                    return BizCurrency.valueOf(192);
                }else if(LoopFlag == 2){
                    LoopFlag = 0;
                    return BizCurrency.valueOf(188);
                }
            } else if (SYORIPTN == TESTPATTERN17) {
                if(LoopFlag == 0){
                    LoopFlag ++;
                    return BizCurrency.valueOf(195);
                }else if(LoopFlag == 1){
                    LoopFlag ++;
                    return BizCurrency.valueOf(194);
                }else if(LoopFlag == 2){
                    LoopFlag ++;
                    return BizCurrency.valueOf(193);
                }else if(LoopFlag == 3){
                    LoopFlag = 0;
                    return BizCurrency.valueOf(190);
                }
            }
            else if (SYORIPTN == TESTPATTERN18) {
                if(LoopFlag == 0){
                    LoopFlag ++;
                    return BizCurrency.valueOf(60);
                }else if(LoopFlag == 1){
                    LoopFlag = 0;
                    return BizCurrency.valueOf(90);
                }
            }
            else if (SYORIPTN == TESTPATTERN19) {
                if(LoopFlag == 0){
                    LoopFlag ++;
                    return BizCurrency.valueOf(189);
                }else if(LoopFlag == 1){
                    LoopFlag ++;
                    return BizCurrency.valueOf(190);
                }
                else if(LoopFlag == 2){
                    LoopFlag ++;
                    return BizCurrency.valueOf(190);
                }
                else if(LoopFlag == 3){
                    LoopFlag ++;
                    return BizCurrency.valueOf(189);
                }
                else if(LoopFlag == 4){
                    LoopFlag ++;
                    return BizCurrency.valueOf(185);
                }
                else if(LoopFlag == 5){
                    LoopFlag ++;
                    return BizCurrency.valueOf(187);
                }
                else if(LoopFlag == 6){
                    LoopFlag ++;
                    return BizCurrency.valueOf(188);
                }
                else if(LoopFlag == 7){
                    LoopFlag ++;
                    return BizCurrency.valueOf(187);
                }
                else if(LoopFlag == 8){
                    LoopFlag ++;
                    return BizCurrency.valueOf(191);
                }
                else if(LoopFlag == 9){
                    LoopFlag ++;
                    return BizCurrency.valueOf(191);
                }
                else if(LoopFlag == 10){
                    LoopFlag ++;
                    return BizCurrency.valueOf(191);
                }
                else if(LoopFlag == 11){
                    LoopFlag ++;
                    return BizCurrency.valueOf(192);
                }
                else if(LoopFlag == 12){
                    LoopFlag ++;
                    return BizCurrency.valueOf(193);
                }
                else if(LoopFlag == 13){
                    LoopFlag ++;
                    return BizCurrency.valueOf(180);
                }
                return BizCurrency.valueOf(100);
            }
            else {
                return BizCurrency.valueOf(100);
            }

        }

        if (caller == CheckTblMosSyouhinTest_exec.class) {
            if (SYORIPTN.equals(TESTPATTERN1)) {
                return BizCurrency.valueOf(0);
            }
            else if (SYORIPTN.equals(TESTPATTERN2)) {

                return BizCurrency.valueOf(54999999);

            }
            else if (SYORIPTN.equals(TESTPATTERN3)) {

                return BizCurrency.valueOf(54999999000L);

            }
            else if (SYORIPTN.equals(TESTPATTERN4)) {

                return BizCurrency.valueOf(4063000);

            }
            else if (SYORIPTN.equals(TESTPATTERN5)) {

                return BizCurrency.valueOf(4062999);
            }
        }
        return super.exec(pKijyunYmd, pGaku, pTuukaSyu);

    }

}
