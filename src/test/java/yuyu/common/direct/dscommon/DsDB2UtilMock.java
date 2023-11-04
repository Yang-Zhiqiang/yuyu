package yuyu.common.direct.dscommon;

import yuyu.app.dsweb.dwdsinfo.dwgetdskanyuukeiyakuitiran.DwGetDsKanyuuKeiyakuItiranTest_execPostForm;
import yuyu.app.dsweb.dwdsinfo.dwgetsoukinyoukouzainfo.DwGetSoukinyouKouzaInfoTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenhokenryohurikaekouzainfo.DwGetHozenHokenryoHurikaeKouzaInfoTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkeiyakuenitijisyusin.DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikitijinnkn.DwGetHozenKiykGikItijiNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkeiyakusyousai.DwGetHozenKeiyakuSyousaiTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikhijynnnkn.DwGetHozenKiykGikHijynNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkykenitijinnkn.DwGetHozenKykEnItijiNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozentetuduki.dwkaiyakuuketuke.DwKaiyakuUketukeTest_execPostFormKadouhantei;
import yuyu.app.dsweb.dwhozentetuduki.dwkaiyakuuketuke.DwKaiyakuUketukeTest_execPostFormPrepare;
import yuyu.app.dsweb.dwhozentetuduki.dwkaiyakuuketuke.DwKaiyakuUketukeTest_execPostFormUpdate;
import yuyu.app.dsweb.dwhozentetuduki.dwtumitatekinitenuketuke.DwTumitatekinItenUketukeTest_execPostFormKadouhantei;
import yuyu.app.dsweb.dwhozentetuduki.dwtumitatekinitenuketuke.DwTumitatekinItenUketukeTest_execPostFormPrepare;
import yuyu.app.dsweb.dwhozentetuduki.dwtumitatekinitenuketuke.DwTumitatekinItenUketukeTest_execPostFormUpdate;
import yuyu.app.dsweb.dwkokyakuinfo.dwgettuusinsakiinfo.DwGetTuusinsakiInfoTest_execPostForm;
import yuyu.app.dsweb.dwmail.dwrealtimemailsousin.DwRealTimeMailSousin_execPostFormPrepare;
import yuyu.app.dsweb.dwmail.dwrealtimemailsousin.DwRealTimeMailSousin_execPostFormUpdate;
import yuyu.app.dsweb.dwnetservicesousin.dwmailaddresshenkou.DwMailaddressHenkou_execPostFormForPrepare;
import yuyu.app.dsweb.dwnetservicesousin.dwmailaddresshenkou.DwMailaddressHenkou_execPostFormUpdate;
import yuyu.app.dsweb.dwninsyou.dwhonninkakunin.DwHonninKakuninTest_execPostForm;
import yuyu.app.dsweb.dwninsyou.dwlogin.DwLoginTest_execPostForm;
import yuyu.app.dsweb.dwninsyou.dwtktitrhkyuansyoubangouninsyou.DwTktiTrhkyuAnsyoubangouNinsyouImplTest_execPostForm;

/**
 * {@link DsDB2Util}のモッククラスです。<br />
 */
public class DsDB2UtilMock extends DsDB2Util{
    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    @Override
    public E_Result exec(Throwable pThrowable) {
        if (caller == DwLoginTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            return E_Result.DEADLOCK;
        }else if(caller == DwLoginTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN)){
            return E_Result.QUERY_TIMEOUT;
        }else if(caller == DwLoginTest_execPostForm.class && TESTPATTERN3.equals(SYORIPTN)){
            return E_Result.OTHER;
        }

        if (caller == DwHonninKakuninTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            return E_Result.DEADLOCK;
        }else if(caller == DwHonninKakuninTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN)){
            return E_Result.QUERY_TIMEOUT;
        }else if(caller == DwHonninKakuninTest_execPostForm.class && TESTPATTERN3.equals(SYORIPTN)){
            return E_Result.OTHER;
        }


        if (caller == DwGetDsKanyuuKeiyakuItiranTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            return E_Result.DEADLOCK;
        }else if(caller == DwGetDsKanyuuKeiyakuItiranTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN)){
            return E_Result.QUERY_TIMEOUT;
        }else if(caller == DwGetDsKanyuuKeiyakuItiranTest_execPostForm.class && TESTPATTERN3.equals(SYORIPTN)){
            return E_Result.OTHER;
        }

        if (caller == DwGetTuusinsakiInfoTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            return E_Result.DEADLOCK;
        }else if(caller == DwGetTuusinsakiInfoTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN)){
            return E_Result.QUERY_TIMEOUT;
        }else if(caller == DwGetTuusinsakiInfoTest_execPostForm.class && TESTPATTERN3.equals(SYORIPTN)){
            return E_Result.OTHER;
        }

        if (caller == DwGetHozenKeiyakuSyousaiTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            return E_Result.DEADLOCK;
        }else if(caller == DwGetHozenKeiyakuSyousaiTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN)){
            return E_Result.QUERY_TIMEOUT;
        }else if(caller == DwGetHozenKeiyakuSyousaiTest_execPostForm.class && TESTPATTERN3.equals(SYORIPTN)){
            return E_Result.OTHER;
        }

        if (caller == DwMailaddressHenkou_execPostFormForPrepare.class && TESTPATTERN1.equals(SYORIPTN)) {
            return E_Result.DEADLOCK;
        }else if(caller == DwMailaddressHenkou_execPostFormForPrepare.class && TESTPATTERN2.equals(SYORIPTN)){
            return E_Result.QUERY_TIMEOUT;
        }else if(caller == DwMailaddressHenkou_execPostFormForPrepare.class && TESTPATTERN3.equals(SYORIPTN)){
            return E_Result.OTHER;
        }

        if (caller == DwMailaddressHenkou_execPostFormUpdate.class && TESTPATTERN1.equals(SYORIPTN)) {
            return E_Result.DEADLOCK;
        }else if(caller == DwMailaddressHenkou_execPostFormUpdate.class && TESTPATTERN2.equals(SYORIPTN)){
            return E_Result.QUERY_TIMEOUT;
        }else if(caller == DwMailaddressHenkou_execPostFormUpdate.class && TESTPATTERN3.equals(SYORIPTN)){
            return E_Result.OTHER;
        }

        if (caller == DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            return E_Result.DEADLOCK;
        }else if(caller == DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN)){
            return E_Result.QUERY_TIMEOUT;
        }else if(caller == DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm.class && TESTPATTERN3.equals(SYORIPTN)){
            return E_Result.OTHER;
        }

        if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            return E_Result.DEADLOCK;
        }else if(caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN)){
            return E_Result.QUERY_TIMEOUT;
        }else if(caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class && TESTPATTERN3.equals(SYORIPTN)){
            return E_Result.OTHER;
        }

        if (caller == DwGetHozenKykEnItijiNnknImplTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            return E_Result.DEADLOCK;
        }else if(caller == DwGetHozenKykEnItijiNnknImplTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN)){
            return E_Result.QUERY_TIMEOUT;
        }else if(caller == DwGetHozenKykEnItijiNnknImplTest_execPostForm.class && TESTPATTERN3.equals(SYORIPTN)){
            return E_Result.OTHER;
        }

        if (caller == DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            return E_Result.DEADLOCK;
        }else if(caller == DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN)){
            return E_Result.QUERY_TIMEOUT;
        }else if(caller == DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class && TESTPATTERN3.equals(SYORIPTN)){
            return E_Result.OTHER;
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

        if (caller == DwKaiyakuUketukeTest_execPostFormPrepare.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return E_Result.DEADLOCK;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return E_Result.QUERY_TIMEOUT;
            } else if (TESTPATTERN3.equals(SYORIPTN)) {
                return E_Result.OTHER;
            }
        }

        if (caller == DwKaiyakuUketukeTest_execPostFormUpdate.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return E_Result.DEADLOCK;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return E_Result.QUERY_TIMEOUT;
            } else if (TESTPATTERN3.equals(SYORIPTN)) {
                return E_Result.OTHER;
            }
        }

        if (caller == DwKaiyakuUketukeTest_execPostFormKadouhantei.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return E_Result.DEADLOCK;
            } else if (TESTPATTERN2.equals(SYORIPTN)) {
                return E_Result.QUERY_TIMEOUT;
            } else if (TESTPATTERN3.equals(SYORIPTN)) {
                return E_Result.OTHER;
            }
        }

        if (caller == DwTktiTrhkyuAnsyoubangouNinsyouImplTest_execPostForm.class && TESTPATTERN1.equals(SYORIPTN)) {
            return E_Result.DEADLOCK;
        }else if(caller == DwTktiTrhkyuAnsyoubangouNinsyouImplTest_execPostForm.class && TESTPATTERN2.equals(SYORIPTN)){
            return E_Result.QUERY_TIMEOUT;
        }else if(caller == DwTktiTrhkyuAnsyoubangouNinsyouImplTest_execPostForm.class && TESTPATTERN3.equals(SYORIPTN)){
            return E_Result.OTHER;
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

        return super.exec(pThrowable);
    }
}
