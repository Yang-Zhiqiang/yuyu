package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMosTest_execPostForm;
import yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos.HbSeihoWebSekMosTest_execPostForm2;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyouriritu;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyourirituBean;
import yuyu.def.classification.C_ErrorKbn;

/**
 * {@link GetSjkkktyouseiyouriritu}のモッククラスです<br />
 */
public class GetSjkkktyouseiyourirituMockForSinkeiyaku extends GetSjkkktyouseiyouriritu {
    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private BizNumber sjkkktyouseiyouriritu;

    @Override
    public BizNumber getSjkkktyouseiyouriritu() {
        if (caller == HbSeihoWebSekMosTest_execPostForm.class) {
            return sjkkktyouseiyouriritu;
        }
        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {
            return sjkkktyouseiyouriritu;
        }

        return super.getSjkkktyouseiyouriritu();
    }

    @Override
    public C_ErrorKbn execKykji(GetSjkkktyouseiyourirituBean pGetSjkkktyouseiyourirituBean) {

        if (caller == HbSeihoWebSekMosTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                sjkkktyouseiyouriritu = BizNumber.valueOf(0.125);
                return C_ErrorKbn.OK;
            }else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }else if (TESTPATTERN3.equals(SYORIPTN)) {
                pGetSjkkktyouseiyourirituBean.setSknnkaisiymd(BizDate.valueOf("20181255"));
                pGetSjkkktyouseiyourirituBean.setKykymd(BizDate.valueOf(""));
                return super.execKykji(pGetSjkkktyouseiyourirituBean);
            }
        }
        if (caller == HbSeihoWebSekMosTest_execPostForm2.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                sjkkktyouseiyouriritu = BizNumber.valueOf(0.125);
                return C_ErrorKbn.OK;
            }else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }else if (TESTPATTERN3.equals(SYORIPTN)) {
                sjkkktyouseiyouriritu = BizNumber.valueOf(-0.5);
                return C_ErrorKbn.OK;
            }
        }
        return super.execKykji(pGetSjkkktyouseiyourirituBean);
    }
}
