package yuyu.common.direct.dscommon;

import yuyu.app.dsweb.dwdsinfo.dwgetdskanyuukeiyakuitiran.DwGetDsKanyuuKeiyakuItiranTestException1_execPostForm;
import yuyu.app.dsweb.dwdsinfo.dwgetdskanyuukeiyakuitiran.DwGetDsKanyuuKeiyakuItiranTest_execPostForm;
import yuyu.app.dsweb.dwdsinfo.dwgetsoukinyoukouzainfo.DwGetSoukinyouKouzaInfoTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenhokenryohurikaekouzainfo.DwGetHozenHokenryoHurikaeKouzaInfoTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkeiyakuenitijisyusin.DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkeiyakusyousai.DwGetHozenKeiyakuSyousaiTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikhijynnnkn.DwGetHozenKiykGikHijynNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikitijinnkn.DwGetHozenKiykGikItijiNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkykenitijinnkn.DwGetHozenKykEnItijiNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkyksntkhijynsysn.DwGetHozenKykSntkHijynSysnImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozentrkkzkinfo.DwGetHozenTrkkzkInfoTest_execPostForm;
import yuyu.app.dsweb.dwhozentetuduki.dwkaiyakuuketuke.DwKaiyakuUketukeTest_execPostFormKadouhantei;
import yuyu.app.dsweb.dwhozentetuduki.dwkaiyakuuketuke.DwKaiyakuUketukeTest_execPostFormPrepare;
import yuyu.app.dsweb.dwhozentetuduki.dwkaiyakuuketuke.DwKaiyakuUketukeTest_execPostFormUpdate;
import yuyu.app.dsweb.dwhozentetuduki.dwmkhgkhenkouuketuke.DwMkhgkHenkouUketukeTest_execPostFormCheckInput;
import yuyu.app.dsweb.dwhozentetuduki.dwmkhgkhenkouuketuke.DwMkhgkHenkouUketukeTest_execPostFormCheckUktk;
import yuyu.app.dsweb.dwhozentetuduki.dwmkhgkhenkouuketuke.DwMkhgkHenkouUketukeTest_execPostFormInit;
import yuyu.app.dsweb.dwhozentetuduki.dwmkhgkhenkouuketuke.DwMkhgkHenkouUketukeTest_execPostFormUpdate;
import yuyu.app.dsweb.dwhozentetuduki.dwtumitatekinitenuketuke.DwTumitatekinItenUketukeTest_execPostFormKadouhantei;
import yuyu.app.dsweb.dwhozentetuduki.dwtumitatekinitenuketuke.DwTumitatekinItenUketukeTest_execPostFormPrepare;
import yuyu.app.dsweb.dwhozentetuduki.dwtumitatekinitenuketuke.DwTumitatekinItenUketukeTest_execPostFormUpdate;
import yuyu.app.dsweb.dwmail.dwrealtimemailsousin.DwRealTimeMailSousin_execPostFormPrepare;
import yuyu.app.dsweb.dwmail.dwrealtimemailsousin.DwRealTimeMailSousin_execPostFormUpdate;
import yuyu.app.dsweb.dwninsyou.dwlogin.DwLoginTest_execPostForm;
import yuyu.app.dsweb.dwninsyou.dwtktitrhkyuansyoubangouninsyou.DwTktiTrhkyuAnsyoubangouNinsyouImplTest_execPostForm;

/**
 * {@link DsDB2Util}のモッククラスです。<br />
 */
public class DsDB2UtilMockForDirect extends DsDB2Util{
    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    @Override
    public E_Result exec(Throwable pThrowable) {

        if (caller == DwGetHozenTrkkzkInfoTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            return E_Result.DEADLOCK;
        }else if(caller == DwGetHozenTrkkzkInfoTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN)){
            return E_Result.QUERY_TIMEOUT;
        }else if(caller == DwGetHozenTrkkzkInfoTest_execPostForm.class && TESTPATTERN3.equals(SYORIPTN)){
            return E_Result.OTHER;
        }

        if (caller == DwRealTimeMailSousin_execPostFormPrepare.class ||
            caller == DwRealTimeMailSousin_execPostFormUpdate.class) {
            if(TESTPATTERN1.equals(SYORIPTN)) {
                return E_Result.DEADLOCK;
            } else if(TESTPATTERN2.equals(SYORIPTN)){
                return E_Result.QUERY_TIMEOUT;

            } else if(TESTPATTERN3.equals(SYORIPTN)){
                return E_Result.OTHER;
            }
        }

        if (caller == DwGetHozenHokenryoHurikaeKouzaInfoTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return E_Result.DEADLOCK;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return E_Result.QUERY_TIMEOUT;
            } else if (TESTPATTERN3.equals(SYORIPTN)) {
                return E_Result.OTHER;
            }
        }

        if (caller == DwLoginTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return E_Result.DEADLOCK;
            }else if(TESTPATTERN2.equals(SYORIPTN)){
                return E_Result.QUERY_TIMEOUT;
            }else if(TESTPATTERN3.equals(SYORIPTN)){
                return E_Result.OTHER;
            }
        }

        if (caller == DwGetHozenKykEnItijiNnknImplTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return E_Result.DEADLOCK;
            }else if(TESTPATTERN2.equals(SYORIPTN)){
                return E_Result.QUERY_TIMEOUT;
            }else if(TESTPATTERN3.equals(SYORIPTN)){
                return E_Result.OTHER;
            }
        }

        if (caller == DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return E_Result.DEADLOCK;
            }else if(TESTPATTERN2.equals(SYORIPTN)){
                return E_Result.QUERY_TIMEOUT;
            }else if(TESTPATTERN3.equals(SYORIPTN)){
                return E_Result.OTHER;
            }
        }

        if (caller == DwGetHozenKeiyakuSyousaiTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return E_Result.DEADLOCK;
            }else if(TESTPATTERN2.equals(SYORIPTN)){
                return E_Result.QUERY_TIMEOUT;
            }else if(TESTPATTERN3.equals(SYORIPTN)){
                return E_Result.OTHER;
            }
        }
        if (caller == DwKaiyakuUketukeTest_execPostFormPrepare.class ||
            caller == DwKaiyakuUketukeTest_execPostFormUpdate.class ||
            caller == DwKaiyakuUketukeTest_execPostFormKadouhantei.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return E_Result.DEADLOCK;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return E_Result.QUERY_TIMEOUT;
            } else if (TESTPATTERN3.equals(SYORIPTN)) {
                return E_Result.OTHER;
            }
        }

        if (caller == DwMkhgkHenkouUketukeTest_execPostFormCheckInput.class ||
            caller == DwMkhgkHenkouUketukeTest_execPostFormCheckUktk.class ||
            caller == DwMkhgkHenkouUketukeTest_execPostFormInit.class ||
            caller == DwMkhgkHenkouUketukeTest_execPostFormUpdate.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return E_Result.DEADLOCK;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return E_Result.QUERY_TIMEOUT;
            } else if (TESTPATTERN3.equals(SYORIPTN)) {
                return E_Result.OTHER;
            }
        }

        if (caller == DwTumitatekinItenUketukeTest_execPostFormPrepare.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return E_Result.DEADLOCK;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return E_Result.QUERY_TIMEOUT;
            } else if (TESTPATTERN3.equals(SYORIPTN)) {
                return E_Result.OTHER;
            }
        }

        if (caller == DwTumitatekinItenUketukeTest_execPostFormUpdate.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return E_Result.DEADLOCK;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return E_Result.QUERY_TIMEOUT;
            } else if (TESTPATTERN3.equals(SYORIPTN)) {
                return E_Result.OTHER;
            }
        }

        if (caller == DwTumitatekinItenUketukeTest_execPostFormKadouhantei.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return E_Result.DEADLOCK;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return E_Result.QUERY_TIMEOUT;
            } else if (TESTPATTERN3.equals(SYORIPTN)) {
                return E_Result.OTHER;
            }
        }

        if (caller == DwTktiTrhkyuAnsyoubangouNinsyouImplTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return E_Result.DEADLOCK;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return E_Result.QUERY_TIMEOUT;
            } else if (TESTPATTERN3.equals(SYORIPTN)) {
                return E_Result.OTHER;
            }
        }

        if (caller == DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return E_Result.DEADLOCK;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return E_Result.QUERY_TIMEOUT;
            } else if (TESTPATTERN3.equals(SYORIPTN)) {
                return E_Result.OTHER;
            }
        }

        if (caller == DwGetSoukinyouKouzaInfoTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return E_Result.DEADLOCK;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return E_Result.QUERY_TIMEOUT;
            } else if (TESTPATTERN3.equals(SYORIPTN)) {
                return E_Result.OTHER;
            }
        }

        if (caller == DwGetDsKanyuuKeiyakuItiranTest_execPostForm.class ||
            caller == DwGetDsKanyuuKeiyakuItiranTestException1_execPostForm.class) {
            if(TESTPATTERN1.equals(SYORIPTN)){
                return E_Result.DEADLOCK;
            }
            else if(TESTPATTERN2.equals(SYORIPTN)){
                return E_Result.QUERY_TIMEOUT;
            }else if(TESTPATTERN3.equals(SYORIPTN)){
                return E_Result.OTHER;
            }
        }

        if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class) {

            if(TESTPATTERN1.equals(SYORIPTN)){
                return E_Result.DEADLOCK;
            }
            else if(TESTPATTERN2.equals(SYORIPTN)){
                return E_Result.QUERY_TIMEOUT;
            }else if(TESTPATTERN3.equals(SYORIPTN)){
                return E_Result.OTHER;
            }
        }

        if (DwGetHozenKykSntkHijynSysnImplTest_execPostForm.class == caller) {

            if(TESTPATTERN1.equals(SYORIPTN)){
                return E_Result.DEADLOCK;
            }
            else if(TESTPATTERN2.equals(SYORIPTN)){
                return E_Result.QUERY_TIMEOUT;
            }else if(TESTPATTERN3.equals(SYORIPTN)){
                return E_Result.OTHER;
            }
        }

        return super.exec(pThrowable);
    }
}
