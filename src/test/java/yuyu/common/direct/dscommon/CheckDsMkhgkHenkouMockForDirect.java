package yuyu.common.direct.dscommon;

import yuyu.app.dsweb.dwhozentetuduki.dwmkhgkhenkouuketuke.DwMkhgkHenkouUketukeTest_execPostFormCheckInput;
import yuyu.app.dsweb.dwhozentetuduki.dwmkhgkhenkouuketuke.DwMkhgkHenkouUketukeTest_execPostFormCheckUktk;
import yuyu.app.dsweb.dwhozentetuduki.dwmkhgkhenkouuketuke.DwMkhgkHenkouUketukeTest_execPostFormInit;
import yuyu.app.dsweb.dwhozentetuduki.dwmkhgkhenkouuketuke.DwMkhgkHenkouUketukeTest_execPostFormUpdate;
import yuyu.def.classification.C_CheckDsMkhgkHenkouKekkaKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KahiKbn;

/**
 * {@link CheckDsMkhgkHenkou}のモッククラスです。<br />
 */
public class CheckDsMkhgkHenkouMockForDirect extends CheckDsMkhgkHenkou {

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

    @Override
    public C_KahiKbn getMkhgkHenkoukykKahiKbn() {

        if (caller == DwMkhgkHenkouUketukeTest_execPostFormInit.class){
            return C_KahiKbn.HUKA;

            }

        else if (caller == DwMkhgkHenkouUketukeTest_execPostFormCheckUktk.class){
            return C_KahiKbn.HUKA;

            }

        else if (caller == DwMkhgkHenkouUketukeTest_execPostFormCheckInput.class){
            return C_KahiKbn.HUKA;

            }

        else if (caller == DwMkhgkHenkouUketukeTest_execPostFormUpdate.class){
            return C_KahiKbn.HUKA;

            }
        return super.getMkhgkHenkoukykKahiKbn();
    }

    @Override
    public C_CheckDsMkhgkHenkouKekkaKbn getCheckDsMkhgkHenkouKekkaKbn() {

        if (caller == DwMkhgkHenkouUketukeTest_execPostFormInit.class){
                if (TESTPATTERN2.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.KADOUZIKANGAI;
                }else if (TESTPATTERN3.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.TARGETTKYK;
                }else if (TESTPATTERN4.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.TEIKISHIHARAITKYK;
                }else if (TESTPATTERN5.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.KEIYAKUYMDMAE;
                }else if (TESTPATTERN6.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.DSDATAMAINTENANCE;
                }else if (TESTPATTERN7.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.MFHUSEIGOU;
                }else if (TESTPATTERN8.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.BLANK;
                }

            }
        if (caller == DwMkhgkHenkouUketukeTest_execPostFormCheckUktk.class){
                if (TESTPATTERN2.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.KADOUZIKANGAI;
                }else if (TESTPATTERN3.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.TARGETTKYK;
                }else if (TESTPATTERN4.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.TEIKISHIHARAITKYK;
                }else if (TESTPATTERN5.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.KEIYAKUYMDMAE;
                }else if (TESTPATTERN6.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.DSDATAMAINTENANCE;
                }else if (TESTPATTERN7.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.MKHGKHNKKANOUKIKANGAI;
                }else if (TESTPATTERN8.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.HOZENYUUKOUJYOUTAI;
                }else if (TESTPATTERN9.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.TETUDUKITYUUI;
                }else if (TESTPATTERN10.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.MFHUSEIGOU;
                }else if (TESTPATTERN11.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.BLANK;
                }

            }
        if (caller == DwMkhgkHenkouUketukeTest_execPostFormCheckInput.class){
                if (TESTPATTERN2.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.KADOUZIKANGAI;
                }else if (TESTPATTERN3.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.MKHGKWARIGENZAIHENKOUNASHI;
                }else if (TESTPATTERN4.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.MKHGKWARITETUDUKITYUUHENKOUNASHI;
                }else if (TESTPATTERN5.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.MKHGKWARISEIGOUSEI;
                }else if (TESTPATTERN6.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.MFHUSEIGOU;
                }else if (TESTPATTERN7.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.BLANK;
                }

            }
        if (caller == DwMkhgkHenkouUketukeTest_execPostFormUpdate.class){
                if (TESTPATTERN2.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.KADOUZIKANGAI;
                }else if (TESTPATTERN3.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.TARGETTKYK;
                }else if (TESTPATTERN4.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.TEIKISHIHARAITKYK;
                }else if (TESTPATTERN5.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.KEIYAKUYMDMAE;
                }else if (TESTPATTERN6.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.DSDATAMAINTENANCE;
                }else if (TESTPATTERN7.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.MKHGKHNKKANOUKIKANGAI;
                }else if (TESTPATTERN8.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.HOZENYUUKOUJYOUTAI;
                }else if (TESTPATTERN9.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.TETUDUKITYUUI;
                }else if (TESTPATTERN10.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.MKHGKWARISEIGOUSEI;
                }else if (TESTPATTERN11.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.MFHUSEIGOU;
                }else if (TESTPATTERN12.equals(SYORIPTN)) {
                    return C_CheckDsMkhgkHenkouKekkaKbn.BLANK;
                }

            }
        return super.getCheckDsMkhgkHenkouKekkaKbn();

    }

    @Override
    public C_ErrorKbn chkMkhgkHnkSyoriKahi(String pSyono) {

        if (caller == DwMkhgkHenkouUketukeTest_execPostFormInit.class) {
            if(SYORIPTN.equals(TESTPATTERN1)) {
                return C_ErrorKbn.OK;
            } else {
                return C_ErrorKbn.ERROR;
            }
        }
        return super.chkMkhgkHnkSyoriKahi(pSyono);
    }
    @Override
    public C_ErrorKbn chkMkhgkHnkUktkNaiyou(String pSyono) {
      if (caller == DwMkhgkHenkouUketukeTest_execPostFormCheckUktk.class) {
              if(SYORIPTN.equals(TESTPATTERN1)) {
                  return C_ErrorKbn.OK;
              } else {
                  return C_ErrorKbn.ERROR;
              }
      }
      return super.chkMkhgkHnkUktkNaiyou(pSyono);
    }

    @Override
    public C_ErrorKbn chkMkhgkHnkInputNaiyou(String pSyono, Integer pHnkgoMkhgkWari) {

        if (caller == DwMkhgkHenkouUketukeTest_execPostFormCheckInput.class) {
                if(SYORIPTN.equals(TESTPATTERN1)) {
                    return C_ErrorKbn.OK;
                } else {
                    return C_ErrorKbn.ERROR;
                }
        }
        return super.chkMkhgkHnkInputNaiyou(pSyono, pHnkgoMkhgkWari);

    }

    @Override
    public C_ErrorKbn chkMkhgkHnkUktkDataUpd(String pSyono, Integer pHnkgoMkhgkWari) {

        if (caller == DwMkhgkHenkouUketukeTest_execPostFormUpdate.class) {
                if(SYORIPTN.equals(TESTPATTERN1)) {
                    return C_ErrorKbn.OK;
                } else {
                    return C_ErrorKbn.ERROR;
                }
        }
        return super.chkMkhgkHnkUktkDataUpd(pSyono, pHnkgoMkhgkWari);
    }
}
