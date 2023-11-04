package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import yuyu.common.sinkeiyaku.moschk.CheckTblMosKihonTest_exec1;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_UktKbn;

/**
 * {@link CheckZeiseiTkkkTkykHukaJyouken}のモッククラスです。<br />
 */
public class CheckZeiseiTkkkTkykHukaJyoukenMock extends CheckZeiseiTkkkTkykHukaJyouken{

    private boolean htZeiseiTkkkTkykHukaJk = false;

    @Override
    public boolean getHtZeiseiTkkkTkykHukaJk() {
        return htZeiseiTkkkTkykHukaJk;
    }

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN11 = "11";

    public static final String TESTPATTERN12 = "12";

    public static final String TESTPATTERN13 = "13";

    public static final String TESTPATTERN14 = "14";

    public static final String TESTPATTERN15 = "15";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn checkZeiseiTkkkTkykHukaJk(C_Tdk pKykTdk, C_UktKbn pNenkinuktKbn, int pHhknNen,
        C_HrkkknsmnKbn pHrkkknSmnKbn, int pHrkkkn, C_HknkknsmnKbn pHknkknSmnkbn, int pHknkkn, C_Nenkinsyu pNksyuKbn,
        int pNenkinKkn) {

        if (caller == CheckTblMosKihonTest_exec1.class && TESTPATTERN1.equals(SYORIPTN)) {

            htZeiseiTkkkTkykHukaJk = false;
            return C_ErrorKbn.ERROR;
        }
        else if (caller == CheckTblMosKihonTest_exec1.class &&
                 (TESTPATTERN11.equals(SYORIPTN) || TESTPATTERN12.equals(SYORIPTN) || TESTPATTERN13.equals(SYORIPTN) ||
                  TESTPATTERN14.equals(SYORIPTN) || TESTPATTERN15.equals(SYORIPTN))) {

            htZeiseiTkkkTkykHukaJk = false;
            return C_ErrorKbn.ERROR;
        }
        else if (caller == CheckTblMosKihonTest_exec1.class && TESTPATTERN2.equals(SYORIPTN)) {

            htZeiseiTkkkTkykHukaJk = true;
            return C_ErrorKbn.OK;
        }
        else {
            return super.checkZeiseiTkkkTkykHukaJk(pKykTdk, pNenkinuktKbn, pHhknNen, pHrkkknSmnKbn, pHrkkkn,
                pHknkknSmnkbn, pHknkkn, pNksyuKbn, pNenkinKkn);
        }
    }

    @Override
    public List<Integer> getErrorCodeList() {
        List<Integer> mockErrorCodeList = new ArrayList<>();

        if(caller == CheckTblMosKihonTest_exec1.class){
            if (TESTPATTERN11.equals(SYORIPTN)) {
                mockErrorCodeList.add(CheckZeiseiTkkkTkykHukaJyouken.NENKINUKETORININ_HONNIN_HUBIERROR);
            }
            else if (TESTPATTERN12.equals(SYORIPTN)) {
                mockErrorCodeList.add(CheckZeiseiTkkkTkykHukaJyouken.NENKINUKETORININ_DAISANSYA_HUBIERROR);
            }
            else if (TESTPATTERN13.equals(SYORIPTN)) {
                mockErrorCodeList.add(CheckZeiseiTkkkTkykHukaJyouken.HOKENHARAIKOMIKIKAN_HUBIERROR);
            }
            else if (TESTPATTERN14.equals(SYORIPTN)) {
                mockErrorCodeList.add(CheckZeiseiTkkkTkykHukaJyouken.NENKINSIHARAIKIKAN_HUBIERROR);
            }
            else if (TESTPATTERN15.equals(SYORIPTN)) {
                mockErrorCodeList.add(CheckZeiseiTkkkTkykHukaJyouken.NENKINKAISINENREI_HUBIERROR);
            }
        }

        if(mockErrorCodeList.size() > 0){
            return mockErrorCodeList;
        }else{
            return super.getErrorCodeList();
        }
    }
}
