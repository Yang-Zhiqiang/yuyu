package yuyu.common.hozen.ascommon;

import yuyu.common.hozen.khcommon.CommonNyuukinTest_exec;
import yuyu.common.hozen.khcommon.CommonNyuukinTest_exec1;
import yuyu.common.hozen.khcommon.CommonNyuukinTest_exec3;
import yuyu.common.hozen.khcommon.CommonNyuukinTest_exec4;
import yuyu.common.hozen.khcommon.CommonNyuukinTest_exec6;
import yuyu.common.hozen.khcommon.CommonNyuukinTest_exec7;
import yuyu.common.hozen.khcommon.CommonNyuukinTest_exec8;
import yuyu.common.hozen.khcommon.EditKoujyonaiyouTblTest_exec;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;

/**
 * {@link GetasPRsTuuka}のモッククラスです。<br />
 */
public class GetasPRsTuukaMockForKhansyuu extends GetasPRsTuuka {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    @Override
    public C_ErrorKbn exec(String pSyono) {

        if (caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec6.class ||
            caller == CommonNyuukinTest_exec7.class ||
            caller == CommonNyuukinTest_exec8.class) {

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

        return super.exec(pSyono);
    }

    @Override
    public C_Tuukasyu getRstuukasyu() {

        if (caller == CommonNyuukinTest_exec.class ||
            caller == CommonNyuukinTest_exec1.class ||
            caller == CommonNyuukinTest_exec3.class ||
            caller == CommonNyuukinTest_exec4.class ||
            caller == CommonNyuukinTest_exec6.class ||
            caller == CommonNyuukinTest_exec7.class ||
            caller == CommonNyuukinTest_exec8.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_Tuukasyu.JPY;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                return C_Tuukasyu.USD;
            }
        }

        if(caller == EditKoujyonaiyouTblTest_exec.class) {

            if (SYORIPTN == TESTPATTERN1){

                return C_Tuukasyu.JPY;
            }
            else if (SYORIPTN == TESTPATTERN2){

                return C_Tuukasyu.USD;
            }
        }
        return super.getRstuukasyu();
    }

    @Override
    public C_ErrorKbn editRyousyuuTuukaSyuruiHantei(C_Tuukasyu pKyktuukasyu, C_UmuKbn pYennykntkhkumu, C_UmuKbn pGaikanykntkhkumu) {

        if(caller == EditKoujyonaiyouTblTest_exec.class) {

            if (SYORIPTN == TESTPATTERN1){

                return C_ErrorKbn.OK;
            }
        }
        return super.editRyousyuuTuukaSyuruiHantei(pKyktuukasyu, pYennykntkhkumu, pGaikanykntkhkumu);
    }

}
