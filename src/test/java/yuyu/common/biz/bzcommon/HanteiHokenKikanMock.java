package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.bosyuu.hbkeiyakusyoukai.HbKeiyakuSyoukaiTest_exec;
import yuyu.common.direct.dscommon.DsGetKeiyakuSyousaiTest_exec;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase1Test_editInfo;
import yuyu.common.hozen.khcommon.EditSyoukenTblSyuusinTest_editTBL;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A1;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A2;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A3;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A4;
import yuyu.common.hozen.khcommon.EditSyoukenTblTest_editTBL_A5;
import yuyu.common.hozen.setuibean.SetHosyouTest_exec;
import yuyu.common.siharai.chksk.ChkSubSaigaiGaitouTest_exec;
import yuyu.common.siharai.sicommon.CalcHkShrKngkTest_exec;
import yuyu.def.classification.C_HknKknKbn;

/**
 * 業務共通 共通 保険期間判定<br />
 * {@link HanteiHokenKikan}のモッククラスです。<br />
 */
public class HanteiHokenKikanMock extends HanteiHokenKikan {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public HanteiHokenKikanMock() {
        super();
    }

    @Override
    public C_HknKknKbn exec(HanteiHokenKikanBean pHanteiHokenKikanBean) {

        if (caller == EditSyoukenTblTest_editTBL_A1.class || caller == EditSyoukenTblTest_editTBL_A2.class ||
            caller == EditSyoukenTblTest_editTBL_A3.class || caller == EditSyoukenTblTest_editTBL_A4.class ||
            caller == EditSyoukenTblTest_editTBL_A5.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_HknKknKbn.DAI1HKNKKN;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_HknKknKbn.DAI2HKNKKN;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_HknKknKbn.DAI3HKNKKN;
            }
        }

        if (caller == CalcHkShrKngkTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_HknKknKbn.DAI1HKNKKN;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_HknKknKbn.DAI2HKNKKN;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_HknKknKbn.DAI3HKNKKN;
            }else if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_HknKknKbn.BLNK;
            }
        }

        else if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return C_HknKknKbn.BLNK;
        }
        else if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return C_HknKknKbn.DAI1HKNKKN;
        }
        else if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            return C_HknKknKbn.DAI2HKNKKN;
        }
        else if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {
            return C_HknKknKbn.DAI3HKNKKN;
        }

        else if (caller == ChkSubSaigaiGaitouTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return C_HknKknKbn.DAI1HKNKKN;
        }
        else if (caller == ChkSubSaigaiGaitouTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return C_HknKknKbn.DAI2HKNKKN;
        }

        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return C_HknKknKbn.DAI1HKNKKN;
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return C_HknKknKbn.DAI2HKNKKN;
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            return C_HknKknKbn.DAI2HKNKKN;
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {
            return C_HknKknKbn.DAI1HKNKKN;
        }

        else if (caller == EditSyoukenTblSyuusinTest_editTBL.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_HknKknKbn.DAI1HKNKKN;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_HknKknKbn.DAI2HKNKKN;
            }

            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_HknKknKbn.DAI3HKNKKN;
            }
        }

        else if (caller == SetHosyouTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_HknKknKbn.DAI1HKNKKN;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_HknKknKbn.DAI2HKNKKN;
            }

            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_HknKknKbn.DAI3HKNKKN;
            }
        }

        return super.exec(pHanteiHokenKikanBean);
    }

    @Override
    public BizDate getDai2HknkknStartYmd() {
        if (caller == EditSyoukenTblTest_editTBL_A1.class || caller == EditSyoukenTblTest_editTBL_A2.class ||
            caller == EditSyoukenTblTest_editTBL_A3.class || caller == EditSyoukenTblTest_editTBL_A4.class ||
            caller == EditSyoukenTblTest_editTBL_A5.class) {
            return BizDate.valueOf(20170901);
        }

        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizDate.valueOf("20170301");
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return BizDate.valueOf("20131101");
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            return BizDate.valueOf("20131101");
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {
            return BizDate.valueOf("20210301");
        }

        else if (caller == EditSyoukenTblSyuusinTest_editTBL.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizDate.valueOf("20170301");
        }
        else if (caller == EditSyoukenTblSyuusinTest_editTBL.class && TESTPATTERN2.equals(SYORIPTN)) {
            return BizDate.valueOf("20131101");
        }
        else if (caller == EditSyoukenTblSyuusinTest_editTBL.class && TESTPATTERN3.equals(SYORIPTN)) {
            return BizDate.valueOf("20131101");
        }

        else if (caller == EditKykNaiyouOsirase1Test_editInfo.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizDate.valueOf("20170301");
        }

        return super.getDai2HknkknStartYmd();
    }

    @Override
    public BizDate getDai3HknkknStartYmd() {

        if (caller == EditSyoukenTblTest_editTBL_A1.class || caller == EditSyoukenTblTest_editTBL_A2.class ||
            caller == EditSyoukenTblTest_editTBL_A3.class || caller == EditSyoukenTblTest_editTBL_A4.class ||
            caller == EditSyoukenTblTest_editTBL_A5.class) {
            return BizDate.valueOf(20220901);
        }
        if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return BizDate.valueOf("20170901");
        }
        else if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            return BizDate.valueOf("20170902");
        }
        else if (caller == HbKeiyakuSyoukaiTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {
            return BizDate.valueOf("20170902");
        }

        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizDate.valueOf("20210301");
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN2.equals(SYORIPTN)) {
            return BizDate.valueOf("20181101");
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            return BizDate.valueOf("20191101");
        }
        else if (caller == DsGetKeiyakuSyousaiTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {
            return BizDate.valueOf("20270301");
        }

        else if (caller == EditSyoukenTblSyuusinTest_editTBL.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizDate.valueOf("20210301");
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizDate.valueOf("20181101");
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizDate.valueOf("20191101");
            }

        }

        else if (caller == EditKykNaiyouOsirase1Test_editInfo.class && TESTPATTERN1.equals(SYORIPTN)) {
            return BizDate.valueOf("20270301");
        }

        return super.getDai3HknkknStartYmd();
    }
}