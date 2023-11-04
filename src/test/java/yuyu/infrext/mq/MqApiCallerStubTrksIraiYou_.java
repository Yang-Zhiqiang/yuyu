package yuyu.infrext.mq;

import yuyu.app.bosyuu.hbsksyoukai.hbseihowebmossyoukai.HbSeihoWebMosSyoukaiTest_execPostForm;
import yuyu.common.biz.bzdairiten.DairitenTesuuryouInfoSyutokuTest_exec;
import yuyu.common.biz.bznayose.BzKykNaiyouHaneiMqTest_exec1;
import yuyu.common.biz.bznayose.BzKykNaiyouHaneiMqTest_exec2;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiMqTest_exec;
import yuyu.common.biz.bznayose.BzTrksIraiMqTest_exec1;
import yuyu.common.biz.bznayose.BzTrksIraiMqTest_exec2;
import yuyu.infrext.exception.MqFailedException;

/**
 * MQ用MqApiCall基盤スタブクラス
 */
public class MqApiCallerStubTrksIraiYou_ extends MqApiCaller {

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

    public static final String TESTPATTERN20 = "20";

    @Override
    public String call(String SyoriCd, String UserData, String SosikiCd, String OperatorId) {

        String testData = "";

        if (caller == BzTrksIraiMqTest_exec2.class
            && (SYORIPTN.equals(TESTPATTERN1))) {

            StringBuffer sbTestYou = new StringBuffer();

            sbTestYou.append("4545");
            sbTestYou.append("1");

            testData = sbTestYou.toString();
        }
        else if (caller == BzTrksIraiMqTest_exec2.class
            && (SYORIPTN.equals(TESTPATTERN2)
                || SYORIPTN.equals(TESTPATTERN3)
                || SYORIPTN.equals(TESTPATTERN4)
                || SYORIPTN.equals(TESTPATTERN5)
                || SYORIPTN.equals(TESTPATTERN6)
                || SYORIPTN.equals(TESTPATTERN7))) {

            StringBuffer sbTestYou = new StringBuffer();

            sbTestYou.append("0000");
            if (SYORIPTN.equals(TESTPATTERN2)) {

                sbTestYou.append("3");
            }
            else if (SYORIPTN.equals(TESTPATTERN3)) {

                sbTestYou.append("0");
            }
            else if (SYORIPTN.equals(TESTPATTERN4)) {

                sbTestYou.append("2");
            }
            else if (SYORIPTN.equals(TESTPATTERN5)) {

                sbTestYou.append("4");
            }
            else if (SYORIPTN.equals(TESTPATTERN6)) {

                sbTestYou.append("9");
            }
            else if (SYORIPTN.equals(TESTPATTERN7)) {

                sbTestYou.append(" ");
            }

            testData = sbTestYou.toString();
        }
        else if (caller == BzKykNaiyouHaneiMqTest_exec2.class
            && (SYORIPTN.equals(TESTPATTERN1))) {

            StringBuffer sbTestYou = new StringBuffer();

            sbTestYou.append("5434");
            sbTestYou.append(" ");
            sbTestYou.append(" ");
            sbTestYou.append("          ");
            sbTestYou.append(" ");
            sbTestYou.append("          ");
            sbTestYou.append(" ");
            sbTestYou.append("          ");
            sbTestYou.append("                  ");

            testData = sbTestYou.toString();
        }

        else if (caller == BzSakuinTsnSyoukaiMqTest_exec.class
            && (SYORIPTN.equals(TESTPATTERN5)
                || SYORIPTN.equals(TESTPATTERN6))) {

            StringBuffer sbTestYou = new StringBuffer();

            setSakuinTsnSyoukaiDataA(sbTestYou);

            sbTestYou.append("1");
            sbTestYou.append("2");
            sbTestYou.append("0");
            sbTestYou.append("1");
            sbTestYou.append("1");
            sbTestYou.append("1");
            sbTestYou.append("1");
            sbTestYou.append("1");

            setKykMfList(sbTestYou);
            setMosfList(sbTestYou);
            setSntkList(sbTestYou);
            setSueokiList(sbTestYou);
            setSnfList(sbTestYou);
            setKhList(sbTestYou);
            setSkList(sbTestYou, 1);
            setNkShrList(sbTestYou);

            if (SYORIPTN.equals(TESTPATTERN6)) {

                setSakuinTsnSyoukaiDataB3(sbTestYou);
            }
            else {
                setSakuinTsnSyoukaiDataB2(sbTestYou);
            }

            testData = sbTestYou.toString();
        }
        else if (caller == BzSakuinTsnSyoukaiMqTest_exec.class
            && (SYORIPTN.equals(TESTPATTERN4))) {

            StringBuffer sbTestYou = new StringBuffer();

            setSakuinTsnSyoukaiDataA(sbTestYou);

            sbTestYou.append("1");
            sbTestYou.append("1");
            sbTestYou.append("1");
            sbTestYou.append("1");
            sbTestYou.append("1");
            sbTestYou.append("1");
            sbTestYou.append("1");
            sbTestYou.append("1");

            setKykMfList(sbTestYou);
            setMosfList(sbTestYou);
            setSntkList(sbTestYou);
            setSueokiList(sbTestYou);
            setSnfList(sbTestYou);
            setKhList(sbTestYou);
            setSkList(sbTestYou, 0);
            setNkShrList(sbTestYou);

            setSakuinTsnSyoukaiDataB1(sbTestYou);

            testData = sbTestYou.toString();
        }
        else if (caller == BzSakuinTsnSyoukaiMqTest_exec.class
            && (SYORIPTN.equals(TESTPATTERN7))) {

            StringBuffer sbTestYou = new StringBuffer();

            setSakuinTsnSyoukaiDataNull(sbTestYou);

            sbTestYou.append(" ");
            sbTestYou.append(" ");
            sbTestYou.append(" ");
            sbTestYou.append(" ");
            sbTestYou.append(" ");
            sbTestYou.append(" ");
            sbTestYou.append(" ");
            sbTestYou.append(" ");

            setKykMfListNull(sbTestYou);
            setMosfListNull(sbTestYou);
            setSntkListNull(sbTestYou);
            setSueokiListNull(sbTestYou);
            setSnfListNull(sbTestYou);
            setKhListNull(sbTestYou);
            setSkListNull(sbTestYou);
            setNkShrListNull(sbTestYou);

            setSakuinTsnSyoukaiDataB4(sbTestYou);

            testData = sbTestYou.toString();
        }

        else if (caller == BzSakuinTsnSyoukaiMqTest_exec.class
            && (SYORIPTN.equals(TESTPATTERN8))) {

            StringBuffer sbTestYou = new StringBuffer();

            setSakuinTsnSyoukaiDataA1(sbTestYou);

            sbTestYou.append(" ");
            sbTestYou.append(" ");
            sbTestYou.append(" ");
            sbTestYou.append(" ");
            sbTestYou.append(" ");
            sbTestYou.append(" ");
            sbTestYou.append(" ");
            sbTestYou.append(" ");

            setKykMfListNull(sbTestYou);
            setMosfListNull(sbTestYou);
            setSntkListNull(sbTestYou);
            setSueokiListNull(sbTestYou);
            setSnfListNull(sbTestYou);
            setKhListNull(sbTestYou);
            setSkListNull(sbTestYou);
            setNkShrListNull(sbTestYou);

            setSakuinTsnSyoukaiDataB4(sbTestYou);

            testData = sbTestYou.toString();
        }
        return testData;
    }

    @Override
    public String call(String SyoriCd, String UserData) {
        String testData = "";

        if (caller == BzTrksIraiMqTest_exec1.class
            && (SYORIPTN.equals(TESTPATTERN1)
                || SYORIPTN.equals(TESTPATTERN2))) {

            StringBuffer sbTestYou = new StringBuffer();

            sbTestYou.append("4545");
            sbTestYou.append("1");

            testData = sbTestYou.toString();
        }
        else if (caller == BzTrksIraiMqTest_exec1.class
            && (SYORIPTN.equals(TESTPATTERN3)
                || SYORIPTN.equals(TESTPATTERN4)
                || SYORIPTN.equals(TESTPATTERN5)
                || SYORIPTN.equals(TESTPATTERN6)
                || SYORIPTN.equals(TESTPATTERN7))) {

            StringBuffer sbTestYou = new StringBuffer();

            sbTestYou.append("0000");

            if (SYORIPTN.equals(TESTPATTERN3)
                || SYORIPTN.equals(TESTPATTERN4)
                || SYORIPTN.equals(TESTPATTERN5)) {

                sbTestYou.append("8");
            }
            else if (SYORIPTN.equals(TESTPATTERN6)) {

                sbTestYou.append("3");
            }
            else if (SYORIPTN.equals(TESTPATTERN7)) {

                sbTestYou.append("1");
            }

            testData = sbTestYou.toString();
        }
        else if ((caller == BzTrksIraiMqTest_exec1.class
            || caller == BzKykNaiyouHaneiMqTest_exec1.class
            || caller == BzSakuinTsnSyoukaiMqTest_exec.class)
            && (SYORIPTN.equals("error1"))) {

            throw new MqFailedException(1);
        }
        else if ((caller == BzTrksIraiMqTest_exec1.class
            || caller == BzKykNaiyouHaneiMqTest_exec1.class
            || caller == BzSakuinTsnSyoukaiMqTest_exec.class)
            && (SYORIPTN.equals("error2"))) {

            throw new MqFailedException(2);
        }
        else if ((caller == BzTrksIraiMqTest_exec1.class
            || caller == BzKykNaiyouHaneiMqTest_exec1.class
            || caller == BzSakuinTsnSyoukaiMqTest_exec.class)
            && (SYORIPTN.equals("error3"))) {

            throw new MqFailedException(3);
        }
        else if ((caller == BzTrksIraiMqTest_exec1.class
            || caller == BzKykNaiyouHaneiMqTest_exec1.class
            || caller == BzSakuinTsnSyoukaiMqTest_exec.class)
            && (SYORIPTN.equals("error4"))) {

            throw new MqFailedException(4);
        }
        else if (caller == BzKykNaiyouHaneiMqTest_exec2.class
            && (SYORIPTN.equals(TESTPATTERN2)
                || SYORIPTN.equals(TESTPATTERN3)
                || SYORIPTN.equals(TESTPATTERN4))) {

            StringBuffer sbTestYou = new StringBuffer();

            sbTestYou.append("0000");
            sbTestYou.append("0");
            sbTestYou.append("2");
            sbTestYou.append("0000000000");
            sbTestYou.append("3");
            sbTestYou.append("1234567890");
            sbTestYou.append("1");
            sbTestYou.append("2234567890");
            sbTestYou.append("000000000000000010");

            testData = sbTestYou.toString();
        }
        else if (caller == BzKykNaiyouHaneiMqTest_exec2.class
            && (SYORIPTN.equals(TESTPATTERN5))) {

            StringBuffer sbTestYou = new StringBuffer();

            sbTestYou.append("0000");
            sbTestYou.append("2");
            sbTestYou.append("2");
            sbTestYou.append("0000000000");
            sbTestYou.append("3");
            sbTestYou.append("1234567890");
            sbTestYou.append("1");
            sbTestYou.append("2234567890");
            sbTestYou.append("000000000000000010");

            testData = sbTestYou.toString();
        }
        else if (caller == BzKykNaiyouHaneiMqTest_exec2.class
            && (SYORIPTN.equals(TESTPATTERN6))) {

            StringBuffer sbTestYou = new StringBuffer();

            sbTestYou.append("5434");
            sbTestYou.append(" ");
            sbTestYou.append(" ");
            sbTestYou.append("          ");
            sbTestYou.append(" ");
            sbTestYou.append("          ");
            sbTestYou.append(" ");
            sbTestYou.append("          ");
            sbTestYou.append("                  ");

            testData = sbTestYou.toString();
        }
        else if (caller == BzKykNaiyouHaneiMqTest_exec2.class
            && (SYORIPTN.equals(TESTPATTERN7))) {

            StringBuffer sbTestYou = new StringBuffer();

            sbTestYou.append("0000");
            sbTestYou.append("0");
            sbTestYou.append(" ");
            sbTestYou.append("0000000000");
            sbTestYou.append(" ");
            sbTestYou.append("1234567890");
            sbTestYou.append(" ");
            sbTestYou.append("2234567890");
            sbTestYou.append("000000000000000010");

            testData = sbTestYou.toString();
        }

        else if (caller == BzSakuinTsnSyoukaiMqTest_exec.class
            && (SYORIPTN.equals(TESTPATTERN2))) {

            StringBuffer sbTestYou = new StringBuffer();

            sbTestYou.append("5434");

            testData = sbTestYou.toString();
        }

        else if (caller == BzSakuinTsnSyoukaiMqTest_exec.class
            && (SYORIPTN.equals(TESTPATTERN3))) {

            StringBuffer sbTestYou = new StringBuffer();

            setSakuinTsnSyoukaiDataA(sbTestYou);

            sbTestYou.append("1");
            sbTestYou.append("1");
            sbTestYou.append("1");
            sbTestYou.append("1");
            sbTestYou.append("1");
            sbTestYou.append("1");
            sbTestYou.append("1");
            sbTestYou.append("1");

            setKykMfList(sbTestYou);
            setMosfList(sbTestYou);
            setSntkList(sbTestYou);
            setSueokiList(sbTestYou);
            setSnfList(sbTestYou);
            setKhList(sbTestYou);
            setSkList(sbTestYou, 1);
            setNkShrList(sbTestYou);

            setSakuinTsnSyoukaiDataB1(sbTestYou);

            testData = sbTestYou.toString();
        }

        else if (caller == DairitenTesuuryouInfoSyutokuTest_exec.class && (SYORIPTN.equals(TESTPATTERN1))) {
            throw new MqFailedException(1);
        }
        else if (caller == DairitenTesuuryouInfoSyutokuTest_exec.class && (SYORIPTN.equals(TESTPATTERN2))) {
            throw new MqFailedException(2);
        }
        else if (caller == DairitenTesuuryouInfoSyutokuTest_exec.class && (SYORIPTN.equals(TESTPATTERN3))) {
            throw new MqFailedException(3);
        }
        else if (caller == DairitenTesuuryouInfoSyutokuTest_exec.class && (SYORIPTN.equals(TESTPATTERN4))) {
            throw new MqFailedException(4);
        }
        else if (caller == DairitenTesuuryouInfoSyutokuTest_exec.class && (SYORIPTN.equals(TESTPATTERN5))) {
            StringBuffer sbTestYou = new StringBuffer();

            sbTestYou.append("0000");
            sbTestYou.append("12345678");
            sbTestYou.append("0");
            sbTestYou.append("0");
            sbTestYou.append("00000011000");
            sbTestYou.append("00000012000");
            sbTestYou.append("00000013000");
            sbTestYou.append("1234567");
            sbTestYou.append("123456789012345678901234567890123456789012345678901234567890");
            sbTestYou.append("201606");
            sbTestYou.append("1234");

            testData = sbTestYou.toString();
        }
        else if (caller == DairitenTesuuryouInfoSyutokuTest_exec.class && (SYORIPTN.equals(TESTPATTERN6))) {
            StringBuffer sbTestYou = new StringBuffer();
            sbTestYou.append("0000");
            sbTestYou.append("12345678");
            sbTestYou.append("1");
            sbTestYou.append("1");
            sbTestYou.append("00000011000");
            sbTestYou.append("00000012000");
            sbTestYou.append("00000013000");
            sbTestYou.append("1234567");
            sbTestYou.append("123456789012345678901234567890123456789012345678901234567890");
            sbTestYou.append("201606");
            sbTestYou.append("1234");

            testData = sbTestYou.toString();
        }
        else if (caller == HbSeihoWebMosSyoukaiTest_execPostForm.class) {
            StringBuffer sbTestYou = new StringBuffer();
            sbTestYou.append("0000");
            sbTestYou.append("12345678");
            sbTestYou.append("1");
            sbTestYou.append("1");
            sbTestYou.append("00000011000");
            sbTestYou.append("00000012000");
            sbTestYou.append("00000013000");
            sbTestYou.append("1234567");
            sbTestYou.append("123456789012345678901234567890123456789012345678901234567890");
            sbTestYou.append("201606");
            sbTestYou.append("1234");

            testData = sbTestYou.toString();
        }

        return testData;
    }

    private void setSakuinTsnSyoukaiDataA(StringBuffer psbTestStr) {

        psbTestStr.append("0000");
        psbTestStr.append("1");
        psbTestStr.append("0");
        psbTestStr.append("2");
        psbTestStr.append("1");
        psbTestStr.append("1");
        psbTestStr.append("1");
        psbTestStr.append("1");
        psbTestStr.append("1");
        psbTestStr.append("1");
        psbTestStr.append("2");
        psbTestStr.append("1234567890");
        psbTestStr.append("    ");
        psbTestStr.append("10");
        psbTestStr.append("10");
        psbTestStr.append("10");
        psbTestStr.append("10");
        psbTestStr.append("10");
        psbTestStr.append("10");
        psbTestStr.append("10");
        psbTestStr.append("10");
    }

    private void setSakuinTsnSyoukaiDataNull(StringBuffer psbTestStr) {

        psbTestStr.append("0000");
        psbTestStr.append(" ");
        psbTestStr.append(" ");
        psbTestStr.append(" ");
        psbTestStr.append(" ");
        psbTestStr.append(" ");
        psbTestStr.append(" ");
        psbTestStr.append(" ");
        psbTestStr.append(" ");
        psbTestStr.append(" ");
        psbTestStr.append(" ");
        psbTestStr.append("0000000000");
        psbTestStr.append("    ");
        psbTestStr.append("10");
        psbTestStr.append("10");
        psbTestStr.append("10");
        psbTestStr.append("10");
        psbTestStr.append("10");
        psbTestStr.append("10");
        psbTestStr.append("10");
        psbTestStr.append("10");
    }

    private void setSakuinTsnSyoukaiDataA1(StringBuffer psbTestStr) {

        psbTestStr.append("0000");
        psbTestStr.append(" ");
        psbTestStr.append(" ");
        psbTestStr.append(" ");
        psbTestStr.append(" ");
        psbTestStr.append(" ");
        psbTestStr.append(" ");
        psbTestStr.append(" ");
        psbTestStr.append(" ");
        psbTestStr.append(" ");
        psbTestStr.append(" ");
        psbTestStr.append("          ");
        psbTestStr.append("    ");
        psbTestStr.append("  ");
        psbTestStr.append("  ");
        psbTestStr.append("  ");
        psbTestStr.append("  ");
        psbTestStr.append("  ");
        psbTestStr.append("  ");
        psbTestStr.append("  ");
        psbTestStr.append("  ");
    }

    private void setSakuinTsnSyoukaiDataB1(StringBuffer psbTestStr) {

        psbTestStr.append("1");
        psbTestStr.append("1");
        psbTestStr.append("1");
        psbTestStr.append("1");
        psbTestStr.append("1");
        psbTestStr.append("12345678901");
        psbTestStr.append("12345678902");
        psbTestStr.append("12345678903");
        psbTestStr.append("12345678904");
        psbTestStr.append("12345678905");
        psbTestStr.append("12345678906");
        psbTestStr.append("12345678907");
        psbTestStr.append("12345678908");
        psbTestStr.append("12345678909");
        psbTestStr.append("12345678900");
        psbTestStr.append("22345678900");
        psbTestStr.append("32345678900");
        psbTestStr.append("32345678901");
        psbTestStr.append("32345678902");
        psbTestStr.append("32345678903");
        psbTestStr.append("1");
        psbTestStr.append("42345678900");
        psbTestStr.append("1");
        psbTestStr.append("0");
        psbTestStr.append("1");
        psbTestStr.append("0");
        psbTestStr.append("1");
        psbTestStr.append("1");
        psbTestStr.append("2");
        psbTestStr.append("1");
        psbTestStr.append("1");
    }

    private void setSakuinTsnSyoukaiDataB2(StringBuffer psbTestStr) {

        psbTestStr.append("1");
        psbTestStr.append("1");
        psbTestStr.append("1");
        psbTestStr.append("1");
        psbTestStr.append("0");
        psbTestStr.append("12345678901");
        psbTestStr.append("12345678902");
        psbTestStr.append("12345678903");
        psbTestStr.append("12345678904");
        psbTestStr.append("12345678905");
        psbTestStr.append("12345678906");
        psbTestStr.append("12345678907");
        psbTestStr.append("12345678908");
        psbTestStr.append("12345678909");
        psbTestStr.append("12345678900");
        psbTestStr.append("22345678900");
        psbTestStr.append("32345678900");
        psbTestStr.append("32345678901");
        psbTestStr.append("32345678902");
        psbTestStr.append("32345678903");
        psbTestStr.append("0");
        psbTestStr.append("42345678900");
        psbTestStr.append("1");
        psbTestStr.append("2");
        psbTestStr.append("2");
        psbTestStr.append("1");
        psbTestStr.append("1");
        psbTestStr.append("0");
        psbTestStr.append("1");
        psbTestStr.append("1");
        psbTestStr.append("1");
    }

    private void setSakuinTsnSyoukaiDataB3(StringBuffer psbTestStr) {

        psbTestStr.append("1");
        psbTestStr.append("1");
        psbTestStr.append("1");
        psbTestStr.append("1");
        psbTestStr.append("2");
        psbTestStr.append("12345678901");
        psbTestStr.append("12345678902");
        psbTestStr.append("12345678903");
        psbTestStr.append("12345678904");
        psbTestStr.append("12345678905");
        psbTestStr.append("12345678906");
        psbTestStr.append("12345678907");
        psbTestStr.append("12345678908");
        psbTestStr.append("12345678909");
        psbTestStr.append("12345678900");
        psbTestStr.append("22345678900");
        psbTestStr.append("32345678900");
        psbTestStr.append("32345678901");
        psbTestStr.append("32345678902");
        psbTestStr.append("32345678903");
        psbTestStr.append("1");
        psbTestStr.append("42345678900");
        psbTestStr.append("0");
        psbTestStr.append("2");
        psbTestStr.append("0");
        psbTestStr.append("1");
        psbTestStr.append("1");
        psbTestStr.append("1");
        psbTestStr.append("1");
        psbTestStr.append("1");
        psbTestStr.append("1");
    }

    private void setSakuinTsnSyoukaiDataB4(StringBuffer psbTestStr) {

        psbTestStr.append(" ");
        psbTestStr.append(" ");
        psbTestStr.append(" ");
        psbTestStr.append(" ");
        psbTestStr.append(" ");
        psbTestStr.append("           ");
        psbTestStr.append("           ");
        psbTestStr.append("           ");
        psbTestStr.append("           ");
        psbTestStr.append("           ");
        psbTestStr.append("           ");
        psbTestStr.append("           ");
        psbTestStr.append("           ");
        psbTestStr.append("           ");
        psbTestStr.append("           ");
        psbTestStr.append("           ");
        psbTestStr.append("           ");
        psbTestStr.append("           ");
        psbTestStr.append("           ");
        psbTestStr.append("           ");
        psbTestStr.append("           ");
        psbTestStr.append("           ");
        psbTestStr.append(" ");
        psbTestStr.append(" ");
        psbTestStr.append(" ");
        psbTestStr.append(" ");
        psbTestStr.append(" ");
        psbTestStr.append(" ");
        psbTestStr.append(" ");
        psbTestStr.append(" ");
        psbTestStr.append(" ");
    }

    private void setKykMfList(StringBuffer psbTestStr) {

        for (int i = 0; i < 10; i++) {

            psbTestStr.append("11807111129");
            psbTestStr.append("02");
            psbTestStr.append("01");
            psbTestStr.append("1");
            psbTestStr.append("199" + i + "0311");
            psbTestStr.append("Sm0" + i);
            psbTestStr.append("199" + i + "1004");
            psbTestStr.append("200" + i + "10");
            psbTestStr.append("199" + i + "1024");
        }
    }

    private void setKykMfListNull(StringBuffer psbTestStr) {

        for (int i = 0; i < 10; i++) {

            psbTestStr.append("11807111129");
            psbTestStr.append("  ");
            psbTestStr.append("  ");
            psbTestStr.append(" ");
            psbTestStr.append("        ");
            psbTestStr.append("    ");
            psbTestStr.append("        ");
            psbTestStr.append("      ");
            psbTestStr.append("        ");
        }
    }

    private void setMosfList(StringBuffer psbTestStr) {

        for (int i = 0; i < 10; i++) {

            psbTestStr.append("791112220");
            psbTestStr.append("01");
            psbTestStr.append("01");
            psbTestStr.append("1");
            psbTestStr.append("199" + i + "1112");
            psbTestStr.append("199" + i + "1201");
            psbTestStr.append("1");
            psbTestStr.append("199" + i + "0105");
            psbTestStr.append("199" + i + "03");
            psbTestStr.append("198" + i + "1206");
        }
    }

    private void setMosfListNull(StringBuffer psbTestStr) {

        for (int i = 0; i < 10; i++) {

            psbTestStr.append("791112220");
            psbTestStr.append("  ");
            psbTestStr.append("  ");
            psbTestStr.append("1");
            psbTestStr.append("        ");
            psbTestStr.append("        ");
            psbTestStr.append(" ");
            psbTestStr.append("        ");
            psbTestStr.append("      ");
            psbTestStr.append("        ");
        }
    }

    private void setSntkList(StringBuffer psbTestStr) {

        for (int i = 0; i < 10; i++) {

            psbTestStr.append("10000000003");
            psbTestStr.append("01");
            psbTestStr.append("02");
            psbTestStr.append("20");
            psbTestStr.append("2001031" + i);
            psbTestStr.append("1");
            psbTestStr.append("1");
            psbTestStr.append("1");
            psbTestStr.append("1");
            psbTestStr.append("1");
            psbTestStr.append("1");
            psbTestStr.append("1");
            psbTestStr.append("1");
            psbTestStr.append("1");
            psbTestStr.append("1");
            psbTestStr.append("1");
            psbTestStr.append("1");
            psbTestStr.append("1");
            psbTestStr.append("1");
            psbTestStr.append("1");
            psbTestStr.append("1");
        }
    }

    private void setSntkListNull(StringBuffer psbTestStr) {

        for (int i = 0; i < 10; i++) {

            psbTestStr.append("10000000003");
            psbTestStr.append("  ");
            psbTestStr.append("  ");
            psbTestStr.append("  ");
            psbTestStr.append("        ");
            psbTestStr.append(" ");
            psbTestStr.append(" ");
            psbTestStr.append(" ");
            psbTestStr.append(" ");
            psbTestStr.append(" ");
            psbTestStr.append(" ");
            psbTestStr.append(" ");
            psbTestStr.append(" ");
            psbTestStr.append(" ");
            psbTestStr.append(" ");
            psbTestStr.append(" ");
            psbTestStr.append(" ");
            psbTestStr.append(" ");
            psbTestStr.append(" ");
            psbTestStr.append(" ");
            psbTestStr.append(" ");
        }
    }

    private void setSueokiList(StringBuffer psbTestStr) {

        for (int i = 0; i < 10; i++) {

            psbTestStr.append("11807111174");
            psbTestStr.append("01");
            psbTestStr.append("01");
            psbTestStr.append("2");
            psbTestStr.append("200" + i + "0327");
            psbTestStr.append("12");
            psbTestStr.append("199" + i + "0127");
        }
    }

    private void setSueokiListNull(StringBuffer psbTestStr) {

        for (int i = 0; i < 10; i++) {

            psbTestStr.append("11807111174");
            psbTestStr.append("  ");
            psbTestStr.append("  ");
            psbTestStr.append(" ");
            psbTestStr.append("        ");
            psbTestStr.append("  ");
            psbTestStr.append("        ");
        }
    }

    private void setSnfList(StringBuffer psbTestStr) {

        for (int i = 0; i < 10; i++) {

            psbTestStr.append("11807111211");
            psbTestStr.append("20");
            psbTestStr.append("04");
            psbTestStr.append("1");
            psbTestStr.append("2002122" + i);
            psbTestStr.append("2002112" + i);
            psbTestStr.append("11");
            psbTestStr.append("2001041" + i);
            psbTestStr.append("1994061" + i);
        }
    }

    private void setSnfListNull(StringBuffer psbTestStr) {

        for (int i = 0; i < 10; i++) {

            psbTestStr.append("11807111211");
            psbTestStr.append("  ");
            psbTestStr.append("  ");
            psbTestStr.append(" ");
            psbTestStr.append("        ");
            psbTestStr.append("        ");
            psbTestStr.append("  ");
            psbTestStr.append("        ");
            psbTestStr.append("        ");
        }
    }

    private void setKhList(StringBuffer psbTestStr) {

        for (int i = 0; i < 10; i++) {
            psbTestStr.append("11807111163");
            psbTestStr.append("01");
            psbTestStr.append("05");
            psbTestStr.append("2");
            psbTestStr.append("09");
            psbTestStr.append("2003101" + i);
            psbTestStr.append("12");
            psbTestStr.append("200" + i + "0401");
            psbTestStr.append("kh");
            psbTestStr.append("199" + i + "08");
            psbTestStr.append("1989051" + i);
            psbTestStr.append("1" + i);
        }
    }

    private void setKhListNull(StringBuffer psbTestStr) {

        for (int i = 0; i < 10; i++) {
            psbTestStr.append("11807111163");
            psbTestStr.append("  ");
            psbTestStr.append("  ");
            psbTestStr.append(" ");
            psbTestStr.append("  ");
            psbTestStr.append("        ");
            psbTestStr.append("  ");
            psbTestStr.append("        ");
            psbTestStr.append("  ");
            psbTestStr.append("      ");
            psbTestStr.append("        ");
            psbTestStr.append("  ");
        }
    }

    private void setSkList(StringBuffer psbTestStr, int str) {

        if (str != 0) {
            for (int i = 0; i < 10; i++) {

                psbTestStr.append("791112402");
                psbTestStr.append("02");
                psbTestStr.append("03");
                psbTestStr.append("1");
                psbTestStr.append("199" + i + "0509");
                psbTestStr.append("1997061" + i);
                psbTestStr.append("1");
                psbTestStr.append("1997101" + i);
                psbTestStr.append("sk");
                psbTestStr.append("199" + i + "09");
                psbTestStr.append("2");
                psbTestStr.append("000000003" + i);
                psbTestStr.append("1988111" + i);
                psbTestStr.append("2"+i);
            }
        } else {

            for (int i = 0; i < 10; i++) {
                psbTestStr.append("791112402");
                psbTestStr.append("02");
                psbTestStr.append("03");
                psbTestStr.append("1");
                psbTestStr.append("199" + i + "0509");
                psbTestStr.append("199" + i + "0619");
                psbTestStr.append("1");
                psbTestStr.append("1997101" + i);
                psbTestStr.append("sk");
                psbTestStr.append("000000");
                psbTestStr.append("2");
                psbTestStr.append("0000000000");
                psbTestStr.append("00000000");
                psbTestStr.append("2"+i);
            }
        }
    }

    private void setSkListNull(StringBuffer psbTestStr) {

        for (int i = 0; i < 10; i++) {
            psbTestStr.append("791112402");
            psbTestStr.append("  ");
            psbTestStr.append("  ");
            psbTestStr.append("0");
            psbTestStr.append("        ");
            psbTestStr.append("        ");
            psbTestStr.append(" ");
            psbTestStr.append("        ");
            psbTestStr.append("  ");
            psbTestStr.append("      ");
            psbTestStr.append(" ");
            psbTestStr.append("          ");
            psbTestStr.append("        ");
            psbTestStr.append("  ");
        }
    }

    private void setNkShrList(StringBuffer psbTestStr) {

        for (int i = 0; i < 10; i++) {

            psbTestStr.append("11807111222");
            psbTestStr.append("01");
            psbTestStr.append("05");
            psbTestStr.append("200" + i + "0402");
            psbTestStr.append("200" + i + "0409");
            psbTestStr.append("40");
            psbTestStr.append("2005051" + i);
            psbTestStr.append("nk");
            psbTestStr.append("01");
            psbTestStr.append("1978041" + i);
            psbTestStr.append("3" + i);
        }
    }

    private void setNkShrListNull(StringBuffer psbTestStr) {

        for (int i = 0; i < 10; i++) {

            psbTestStr.append("11807111222");
            psbTestStr.append("  ");
            psbTestStr.append("  ");
            psbTestStr.append("        ");
            psbTestStr.append("        ");
            psbTestStr.append("  ");
            psbTestStr.append("        ");
            psbTestStr.append("  ");
            psbTestStr.append("  ");
            psbTestStr.append("        ");
            psbTestStr.append("  ");
        }
    }
}