package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.app.bosyuu.hbsekmos.hbseihowebnenkinkaiyakuhrsuii.HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm;
import yuyu.common.hozen.khcommon.EditKykNaiyouOsirase2Test_editInfo;
import yuyu.common.hozen.khcommon.EditSuiihyouTblTest_editTBL;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_YouhiKbn;

/**
 * 業務共通 業務共通 指数取得<br />
 * {@link GetSisuuMock}のモッククラスです。<br />
 */
public class GetSisuuMock extends GetSisuu {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    private BizNumber sisuu;

    private BizDate sisuushutokuymd;

    @Override
    public C_ErrorKbn exec(C_Sisuukbn pSisuukbn, BizDate pSisuushutokuymd, C_YouhiKbn pYouhiKbn) {
        if (caller == EditSuiihyouTblTest_editTBL.class && TESTPATTERN1.equals(SYORIPTN)) {
            sisuu = BizNumber.valueOf(2);
            return C_ErrorKbn.OK;
        }
        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class && SYORIPTN == TESTPATTERN4) {
            return C_ErrorKbn.OK;
        }
        else if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class && SYORIPTN == TESTPATTERN1) {
            return C_ErrorKbn.ERROR;
        }
        return super.exec(pSisuukbn, pSisuushutokuymd, pYouhiKbn);
    }

    @Override
    public BizNumber getSisuu() {

        if (caller == EditSuiihyouTblTest_editTBL.class && TESTPATTERN1.equals(SYORIPTN)) {
            return sisuu;
        }
        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class && SYORIPTN == TESTPATTERN4) {
            return BizNumber.valueOf(123);
        }
        if (EditKykNaiyouOsirase2Test_editInfo.class == caller) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return BizNumber.valueOf(123.11);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return BizNumber.valueOf(123.15);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return BizNumber.valueOf(123.17);
            }
            else {
                return BizNumber.valueOf(123);
            }
        }
        return super.getSisuu();
    }

    @Override
    public BizDate getSisuushutokuymd() {

        if (caller == EditSuiihyouTblTest_editTBL.class && TESTPATTERN1.equals(SYORIPTN)) {
            return sisuushutokuymd;
        }
        return super.getSisuushutokuymd();
    }
}