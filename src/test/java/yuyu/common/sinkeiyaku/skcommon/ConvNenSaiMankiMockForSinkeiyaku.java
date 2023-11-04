package yuyu.common.sinkeiyaku.skcommon;

import yuyu.app.bosyuu.hbsksyoukai.hbseihowebmossyoukai.HbSeihoWebMosSyoukaiTest_execPostForm2;
import yuyu.common.sinkeiyaku.moschk.CheckTblMosSyouhinTest_exec5;
import yuyu.common.sinkeiyaku.moschk.SetKisoKoumokuTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;

/**
 * {@link ConvNenSaiManki}のモッククラスです。<br />
 */
public class ConvNenSaiMankiMockForSinkeiyaku extends ConvNenSaiManki {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    @Override
    public C_ErrorKbn convHrkkknNen(Integer pHrkkkn, C_HrkkknsmnKbn pHrkkknsmnkbn, Integer pHhknnen) {

        if (caller == SetKisoKoumokuTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }

        }

        if (caller == HbSeihoWebMosSyoukaiTest_execPostForm2.class) {

            if ( TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if ( TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        if (caller == CheckTblMosSyouhinTest_exec5.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }

        }

        return super.convHrkkknNen(pHrkkkn, pHrkkknsmnkbn, pHhknnen);
    }

    @Override
    public Integer getHrkkknNen() {

        if (caller == SetKisoKoumokuTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return 2;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return 0;
            }

            if (TESTPATTERN3.equals(SYORIPTN)) {
                return 2;
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return 1;
            }
        }

        if (caller == HbSeihoWebMosSyoukaiTest_execPostForm2.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return 2;
            }

            if (TESTPATTERN5.equals(SYORIPTN)) {
                return 0;
            }
        }

        if (caller == CheckTblMosSyouhinTest_exec5.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return 11;
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return 0;
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return 1;
            }

        }

        return super.getHrkkknNen();
    }

    @Override
    public C_ErrorKbn convHknkknNen(Integer pHknkkn, C_HknkknsmnKbn pHknkknsmnkbn, Integer pHhknnen) {

        return super.convHknkknNen(pHknkkn, pHknkknsmnkbn, pHhknnen);
    }

    @Override
    public Integer getHknkknNen() {

        return super.getHknkknNen();
    }

    @Override
    public C_ErrorKbn convHknkknSai(Integer pHknkkn, C_HknkknsmnKbn pHknkknsmnkbn, Integer pHhknnen) {

        return super.convHknkknSai(pHknkkn, pHknkknsmnkbn, pHhknnen);
    }

    @Override
    public Integer getHknkknSai() {

        return super.getHknkknSai();
    }
}