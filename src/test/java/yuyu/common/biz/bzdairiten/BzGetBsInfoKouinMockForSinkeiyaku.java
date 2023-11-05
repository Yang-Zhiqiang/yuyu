package yuyu.common.biz.bzdairiten;

import yuyu.common.sinkeiyaku.moschk.CheckTblMosDairitenTest_exec;

/**
 * 業務共通 代理店 募集人情報取得（行員コード指定）クラス
 */
public class BzGetBsInfoKouinMockForSinkeiyaku extends BzGetBsInfoKouin{

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    @Override
    public BzGetBsInfoBean exec(String pKinyuuCd, String pKouinCd) {
        if (caller == CheckTblMosDairitenTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                return null;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                BzGetBsInfoBean bzGetBsInfoBean = new BzGetBsInfoBean();
                bzGetBsInfoBean.setBosyuuCd("123456");
                bzGetBsInfoBean.setKouinCd("400001000006");
                bzGetBsInfoBean.setDairiten1Cd("2101080");

                return bzGetBsInfoBean;
            }
        }
        return super.exec(pKinyuuCd, pKouinCd);
    }
}
