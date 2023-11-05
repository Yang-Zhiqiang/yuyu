package yuyu.common.hozen.haitou;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.common.siharai.sicommon.SiSiharaiKingakuKeisanTest_exec;
import yuyu.common.suuri.srcommon.EditDshrTukiDKoumokuBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;

/**
 * {@link SetHokenNnd}のモッククラスです。<br />
 */
public class KeisanDCommonSibouMockForSiharai extends KeisanDCommonSibou {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private BizCurrency dShrkn;

    private BizCurrency tokubetuHaitou;

    @Override
    public C_ErrorKbn calcDShrgk(String pSyono, BizDate pCalckijyunymd, BizDate pSyoriYmd) {

        if (caller == SiSiharaiKingakuKeisanTest_exec.class ) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
        }
        return super.calcDShrgk(pSyono, pCalckijyunymd, pSyoriYmd);
    }

    @Override
    public BizCurrency getDShrkn() {

        if (caller == SiSiharaiKingakuKeisanTest_exec.class ) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                dShrkn = null;
                return dShrkn;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                dShrkn = BizCurrency.valueOf(1000, BizCurrencyTypes.YEN);
                return dShrkn;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                dShrkn = BizCurrency.valueOf(1001, BizCurrencyTypes.YEN);
                return dShrkn;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                dShrkn = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                return dShrkn;
            }
        }
        return super.getDShrkn();
    }

    @Override
    public BizCurrency getTkbtD() {

        if (caller == SiSiharaiKingakuKeisanTest_exec.class ) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1030);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1040);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizCurrency.valueOf(1050, BizCurrencyTypes.YEN);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
            }
        }
        return super.getTkbtD();
    }

    @Override
    public C_NaiteiKakuteiKbn getKhHaitouKanriNaiteiKakuteiKbn() {

        if (caller == SiSiharaiKingakuKeisanTest_exec.class ) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_NaiteiKakuteiKbn.BLNK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_NaiteiKakuteiKbn.NAITEI;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_NaiteiKakuteiKbn.KAKUTEI;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return null;
            }
        }
        return super.getKhHaitouKanriNaiteiKakuteiKbn();
    }

    @Override
    public EditDshrTukiDKoumokuBean getEditDshrTukiDKoumokuBean() {

        if (caller == SiSiharaiKingakuKeisanTest_exec.class ) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean = SWAKInjector.getInstance(EditDshrTukiDKoumokuBean.class);
                editDshrTukiDKoumokuBean.setCalckijyunYmd(BizDate.valueOf("20190609"));
                editDshrTukiDKoumokuBean.setSyoriYmd2(BizDate.valueOf("20190612"));
                editDshrTukiDKoumokuBean.setHaitoushrKin(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
                return editDshrTukiDKoumokuBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean = SWAKInjector.getInstance(EditDshrTukiDKoumokuBean.class);
                editDshrTukiDKoumokuBean.setCalckijyunYmd(BizDate.valueOf("20190609"));
                editDshrTukiDKoumokuBean.setSyoriYmd2(BizDate.valueOf("20190612"));
                editDshrTukiDKoumokuBean.setHaitoushrKin(BizCurrency.valueOf(1001, BizCurrencyTypes.YEN));
                return editDshrTukiDKoumokuBean;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean = SWAKInjector.getInstance(EditDshrTukiDKoumokuBean.class);
                editDshrTukiDKoumokuBean.setCalckijyunYmd(null);
                editDshrTukiDKoumokuBean.setSyoriYmd2(null);
                editDshrTukiDKoumokuBean.setHaitoushrKin(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
                return editDshrTukiDKoumokuBean;
            }
        }
        return super.getEditDshrTukiDKoumokuBean();
    }
}