package yuyu.common.siharai.chksk;

import java.util.List;

import yuyu.common.siharai.sicommon.SiSiharaiKingakuKeisanTest_exec;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SikinouModeIdKbn;
import yuyu.def.classification.C_YouhiKbn;

/**
 * {@link SiSKNaiyouChkkekkaSettei}のモッククラスです。<br />
 */
public class SiSKNaiyouChkkekkaSetteiMock extends SiSKNaiyouChkkekkaSettei {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public void exec(C_SeikyuuSyubetu pSeikyuuSyubetu,
        String pYobidasiMotoKinouID,
        C_SikinouModeIdKbn pYobidasiMotoTaskID,
        CheckSbSkNaiyouKekkaBean pCheckSbSkNaiyouKekkaBean,
        CheckKdSkNaiyouKekkaBean pCheckKdSkNaiyouKekkaBean,
        CheckSbkrSkNaiyouKekkaBean pCheckSbkrSkNaiyouKekkaBean,
        CheckSdsSkNaiyouKekkaBean pCheckSdsSkNaiyouKekkaBean,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (CheckSbSkNaiyouTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                pCheckSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.YOU);
                pCheckSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("010201");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");

                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("010301");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");

                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("010401");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");

                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("010601");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");

                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("010801");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");

                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("010901");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");

                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("020101");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("消滅");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");

                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("020201");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("17809000023");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");

                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("020301");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("AAAA");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");

                pCheckSbSkNaiyouKekkaBean.getErrorMessageCollector().addMessage("010101", "", "受取人本人", "", "", "");

                return;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {

                pCheckSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
                pCheckSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

                pCheckSbSkNaiyouKekkaBean.getErrorMessageCollector().addMessage("020401", "復活責任開始日", "", "", "", "");

                return;
            }

            if (TESTPATTERN3.equals(SYORIPTN)) {

                pCheckSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
                pCheckSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

                pCheckSbSkNaiyouKekkaBean.getErrorMessageCollector().addMessage("020401", "責任開始日", "", "", "", "");

                return;
            }

            if (TESTPATTERN4.equals(SYORIPTN)) {

                pCheckSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(C_YouhiKbn.HUYOU);
                pCheckSbSkNaiyouKekkaBean.setKeisanKahiKbn(C_KahiKbn.KA);

                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("010201");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");

                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("010701");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");

                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("020501");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");

                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("021101");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");

                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("021201");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");

                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("021401");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");

                return;

            }
        }
        if (SiSiharaiKingakuKeisanTest_exec.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("WJA1034");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");

                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("WJA1036");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("契約者ＭＮ名義番号");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");

                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("WJA1036");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("受取人ＭＮ名義番号");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                return;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("WJA1044");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                return;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("WBF0162");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("受取人ＭＮ名義番号");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");

                return;
            }

            if (TESTPATTERN4.equals(SYORIPTN)) {

                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("WJA1054");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");

                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("WJA1055");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");

                return;

            }
            if (TESTPATTERN5.equals(SYORIPTN)) {

                pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add("WJA1034");
                pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add("");

                pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add("WJA1044");
                pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add("");

                pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add("WBF0162");
                pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add("受取人ＭＮ名義番号");
                pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add("");

                pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add("WJA1054");
                pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add("");
                return;
            }

            if (TESTPATTERN6.equals(SYORIPTN)) {
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("WJA1036");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("契約者ＭＮ名義番号");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                return;
            }
            if (TESTPATTERN7.equals(SYORIPTN)) {
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("WBF0162");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("契約者ＭＮ名義番号");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                return;
            }
            if (TESTPATTERN8.equals(SYORIPTN)) {
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("WJA1055");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add("");
                return;
            }

            if (TESTPATTERN9.equals(SYORIPTN)) {
                pCheckSbSkNaiyouKekkaBean.getErrorMessageCollector().addMessage(
                    "EXX9999",
                    "",
                    "",
                    "",
                    "",
                    "");

                return;
            }
        }

        super.exec(pSeikyuuSyubetu, pYobidasiMotoKinouID, pYobidasiMotoTaskID, pCheckSbSkNaiyouKekkaBean,
            pCheckKdSkNaiyouKekkaBean, pCheckSbkrSkNaiyouKekkaBean, pCheckSdsSkNaiyouKekkaBean, pChkKekkaBeanLst);;

    }

}
