package yuyu.common.direct.dscommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.app.dsweb.dwhozentetuduki.dwdenwakaiyakuuketuke.DwDenwaKaiyakuUketukeTest_execPostForm;
import yuyu.app.dsweb.dwmail.dwrealtimemailsousin.DwRealTimeMailSousin_execPostFormPrepare;

/**
 * {@link DsSaibanSyori}のモッククラスです。<br />
 */
public class DsSaibanSyoriMock extends DsSaibanSyori{
    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    @Override
    public String saibanDsKokno() {
        return super.saibanDsKokno();
    }

    @Override
    public String saibanDsHenkouSikibetukey() {
        return super.saibanDsHenkouSikibetukey();
    }

    @Override
    public String saibanDsSousinNoRenban() {
        return super.saibanDsSousinNoRenban();
    }

    @Override
    public String saibanRealTimeMailDsSousinNoRenban(String pKey) {

        String dsSousinNoRenban = "00000001";

        if (caller == DwRealTimeMailSousin_execPostFormPrepare.class) {
            if(TESTPATTERN1.equals(SYORIPTN)) {
                return dsSousinNoRenban;
            }
        }

        return super.saibanRealTimeMailDsSousinNoRenban(pKey);
    }

    @Override
    public String saibanDsTetuzukiSikibetuId(BizDate pDate) {

        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return "1810170120";
            }
        }
        return super.saibanDsTetuzukiSikibetuId(pDate);
    }

}
