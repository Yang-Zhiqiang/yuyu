package yuyu.common.biz.bzdairiten;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.sinkeiyaku.moschk.CheckTblMosDairitenTest_exec;
import yuyu.def.classification.C_BsKahiKbn;

/**
 * 業務共通 代理店 募集人情報取得（募集人登録番号指定）のモッククラスです。<br />
 */
public class BzGetBsInfoBstrknoMockForSinkeiyaku extends BzGetBsInfoBstrkno{

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    @Override
    public BzGetBsInfoBean exec(String pBosyuutrkno) {

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
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                BzGetBsInfoBean bzGetBsInfoBean = new BzGetBsInfoBean();
                bzGetBsInfoBean.setBosyuuCd("010011");
                bzGetBsInfoBean.setBosyuuKahiKbn(C_BsKahiKbn.BOSYUUHUKA);
                bzGetBsInfoBean.setBosyuuninTourokuYmd(BizDate.valueOf("20180713"));
                return bzGetBsInfoBean;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {

                BzGetBsInfoBean bzGetBsInfoBean = new BzGetBsInfoBean();
                bzGetBsInfoBean.setBosyuuCd("010012");
                bzGetBsInfoBean.setBosyuuKahiKbn(C_BsKahiKbn.BOSYUUKA);
                bzGetBsInfoBean.setBosyuuninTourokuYmd(null);
                return bzGetBsInfoBean;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {

                BzGetBsInfoBean bzGetBsInfoBean = new BzGetBsInfoBean();
                bzGetBsInfoBean.setBosyuuCd("010013");
                bzGetBsInfoBean.setBosyuuKahiKbn(C_BsKahiKbn.BOSYUUKA);
                bzGetBsInfoBean.setBosyuuninTourokuYmd(BizDate.valueOf("20180713"));
                return bzGetBsInfoBean;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {

                BzGetBsInfoBean bzGetBsInfoBean = new BzGetBsInfoBean();
                bzGetBsInfoBean.setBosyuuCd("010013");
                bzGetBsInfoBean.setBosyuuKahiKbn(C_BsKahiKbn.BOSYUUKA);
                bzGetBsInfoBean.setBosyuuninTourokuYmd(BizDate.valueOf("20180713"));
                bzGetBsInfoBean.setBosyuuninGyouhaiYmd(BizDate.valueOf("20180713"));
                return bzGetBsInfoBean;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {

                BzGetBsInfoBean bzGetBsInfoBean = new BzGetBsInfoBean();
                bzGetBsInfoBean.setBosyuuCd("010013");
                bzGetBsInfoBean.setBosyuuKahiKbn(C_BsKahiKbn.BOSYUUKA);
                bzGetBsInfoBean.setBosyuuninTourokuYmd(BizDate.valueOf("20180713"));
                bzGetBsInfoBean.setBosyuuninGyouhaiYmd(BizDate.valueOf("20180715"));
                return bzGetBsInfoBean;
            }

        }
        return super.exec(pBosyuutrkno);
    }
}
