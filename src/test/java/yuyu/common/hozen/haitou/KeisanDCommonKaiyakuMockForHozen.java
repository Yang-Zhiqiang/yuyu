package yuyu.common.hozen.haitou;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyakuTest_keisanKaiyakuseisankin;
import yuyu.common.suuri.srcommon.EditDshrTukiDKoumokuBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;

/**
 * 配当共通計算（解約）{@link KeisanDCommonKaiyaku}のモッククラスです。<br />
 */
public class KeisanDCommonKaiyakuMockForHozen extends KeisanDCommonKaiyaku {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_ErrorKbn calcDShrgk(String pSyono, BizDate pCalckijyunymd, BizDate pSyoriYmd, BizDateYM pJkipjytym) {
        if (KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
        }
        return super.calcDShrgk(pSyono, pCalckijyunymd, pSyoriYmd, pJkipjytym);
    }

    @Override
    public BizCurrency getDShrkn() {
        if (KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizCurrency.valueOf(1001);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return BizCurrency.valueOf(1002);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                return BizCurrency.valueOf(1003);
            }
        }
        return super.getDShrkn();
    }

    @Override
    public BizCurrency getKariwariateDGanrikinForDShrkn() {
        if (KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizCurrency.valueOf(1001);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return BizCurrency.valueOf(1002);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                return BizCurrency.valueOf(1003);
            }
        }
        return super.getKariwariateDGanrikinForDShrkn();
    }

    @Override
    public C_NaiteiKakuteiKbn getKhHaitouKanriNaiteiKakuteiKbn() {
        if (KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_NaiteiKakuteiKbn.BLNK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return C_NaiteiKakuteiKbn.KAKUTEI;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                return C_NaiteiKakuteiKbn.NAITEI;
            }
        }
        return super.getKhHaitouKanriNaiteiKakuteiKbn();
    }

    @Override
    public EditDshrTukiDKoumokuBean getEditDshrTukiDKoumokuBean() {
        if (KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean = new EditDshrTukiDKoumokuBean();
                editDshrTukiDKoumokuBean.setCalckijyunYmd(BizDate.valueOf("20180129"));
                editDshrTukiDKoumokuBean.setDkeisanhaitouKin(BizCurrency.valueOf(100));
                editDshrTukiDKoumokuBean.setDkeisannaiteikakuteiKbn(C_NaiteiKakuteiKbn.KAKUTEI);

                return editDshrTukiDKoumokuBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean = new EditDshrTukiDKoumokuBean();
                editDshrTukiDKoumokuBean.setCalckijyunYmd(BizDate.valueOf("20180129"));
                editDshrTukiDKoumokuBean.setDkeisanhaitouKin(BizCurrency.valueOf(100));
                editDshrTukiDKoumokuBean.setDkeisannaiteikakuteiKbn(C_NaiteiKakuteiKbn.NAITEI);

                return editDshrTukiDKoumokuBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean = new EditDshrTukiDKoumokuBean();
                editDshrTukiDKoumokuBean.setCalckijyunYmd(BizDate.valueOf("20180129"));
                editDshrTukiDKoumokuBean.setDkeisanhaitouKin(BizCurrency.valueOf(100));
                editDshrTukiDKoumokuBean.setDkeisannaiteikakuteiKbn(C_NaiteiKakuteiKbn.BLNK);

                return editDshrTukiDKoumokuBean;
            }
        }
        return super.getEditDshrTukiDKoumokuBean();
    }

    @Override
    public BizCurrency getTumitateDGanrikin() {

        if (KeisanCommonKaiyakuTest_keisanKaiyakuseisankin.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizCurrency.valueOf(100);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return BizCurrency.valueOf(100);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                return BizCurrency.valueOf(100);
            }
        }
        return super.getTumitateDGanrikin();
    }
}
