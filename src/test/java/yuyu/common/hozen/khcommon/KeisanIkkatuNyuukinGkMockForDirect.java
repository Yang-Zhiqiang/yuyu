package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikhijynnnkn.DwGetHozenKiykGikHijynNnknImplTest_execPostForm;
import yuyu.def.classification.C_ErrorKbn;

/**
 * {@link KeisanIkkatuNyuukinGk}のモッククラスです。<br />
 */
public class KeisanIkkatuNyuukinGkMockForDirect extends KeisanIkkatuNyuukinGk {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public int count = 0;

    @Override
    public BizCurrency getIktwaribikikgk() {
        return super.getIktwaribikikgk();
    }

    @Override
    public BizCurrency getWrbktkyokknp() {
        return super.getWrbktkyokknp();
    }

    @Override
    public Integer getWrbktkyokkntksu() {
        return super.getWrbktkyokkntksu();
    }

    @Override
    public BizCurrency getWrbktkyukkngip() {
        return super.getWrbktkyukkngip();
    }

    @Override
    public Integer getWrbktkyukkngitksu() {
        return super.getWrbktkyukkngitksu();
    }

    @Override
    public C_ErrorKbn exec(KeisanIkkatuNyuukinGkBean pKeisanIkkatuNyuukinGkBean, boolean pIktwaribikiFuyouFlg) {

        if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        return super.exec(pKeisanIkkatuNyuukinGkBean, pIktwaribikiFuyouFlg);
    }

    @Override
    public C_ErrorKbn exec(KeisanIkkatuNyuukinGkBean pKeisanIkkatuNyuukinGkBean, BizDate pRyosyuYmd,
        BizDateYM pJyuutouYm) {
        return super.exec(pKeisanIkkatuNyuukinGkBean, pRyosyuYmd, pJyuutouYm);
    }

    @Override
    public BizCurrency getIktnyknkgk() {

        if (caller == DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class) {

            return BizCurrency.valueOf(123456, BizCurrencyTypes.YEN);
        }

        return super.getIktnyknkgk();
    }
}
