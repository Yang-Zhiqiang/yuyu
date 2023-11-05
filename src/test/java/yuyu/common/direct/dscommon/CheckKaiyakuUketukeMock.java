package yuyu.common.direct.dscommon;

import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.app.dsweb.dwhozentetuduki.dwdenwakaiyakuuketuke.DwDenwaKaiyakuUketukeTest_execPostForm;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;

/**
 * {@link CheckKaiyakuUketuke}のモッククラスです。<br />
 */
public class CheckKaiyakuUketukeMock extends CheckKaiyakuUketuke {

    @Override
    public String getMessage() {
        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return MessageUtil.getMessage(MessageId.EMF1027);
            }
            if (TESTPATTERN2.equals(SYORIPTN)) {

                return MessageUtil.getMessage(MessageId.EMF1028, "テスト");
            }
            if (TESTPATTERN3.equals(SYORIPTN)) {

                return "";
            }
            if (TESTPATTERN4.equals(SYORIPTN)) {

                return "";
            }
            if (TESTPATTERN5.equals(SYORIPTN)) {

                return "";
            }
            if (TESTPATTERN6.equals(SYORIPTN)) {

                return MessageUtil.getMessage(MessageId.EMF1029);
            }
            if (TESTPATTERN7.equals(SYORIPTN)) {

                return MessageUtil.getMessage(MessageId.EMF1053);
            }
            if (TESTPATTERN99.equals(SYORIPTN)) {

                return MessageUtil.getMessage(MessageId.EMF1029);
            }
        }
        return super.getMessage();
    }

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN99 = "99";


    @Override
    public C_ErrorKbn telkaiyakuKadoutimeChk() {

        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN99.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            return C_ErrorKbn.OK;
        }

        return super.telkaiyakuKadoutimeChk();

    }

    @Override
    public C_ErrorKbn dskokyakujtChk(String pSyoNo) {

        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }
        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        return super.dskokyakujtChk(pSyoNo);

    }

    @Override
    public C_ErrorKbn kawaserateExistChk(C_Tuukasyu pTuukasyu) {

        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN7.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        return super.kawaserateExistChk(pTuukasyu);
    }

    @Override
    public C_ErrorKbn kykymdMaeChk(String pSyoNo) {

        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN7.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        return super.kykymdMaeChk(pSyoNo);
    }

    @Override
    public C_ErrorKbn dsDataMaintenanceChk(String pSyoNo) {

        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN7.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        return super.dsDataMaintenanceChk(pSyoNo);
    }

    @Override
    public C_ErrorKbn tokuteitrhkkzYuukoujtChk(String pSyoNo, String pDskokNo) {
        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN6.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;

            }
        }
        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        return super.tokuteitrhkkzYuukoujtChk(pSyoNo, pDskokNo);

    }

    @Override
    public C_ErrorKbn tokuteitrhkkzMstExistChk(String pSyoNo, String pDskokNo, C_KouzasyuruiKbn pKouzasyuruiKbn) {
        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }
        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        return super.tokuteitrhkkzMstExistChk(pSyoNo, pDskokNo, pKouzasyuruiKbn);
    }

    @Override
    public C_ErrorKbn dskaiyakuChk(String pSyoNo) {
        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }
        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN7.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        return super.dskaiyakuChk(pSyoNo);
    }

    @Override
    public C_ErrorKbn tokuteitrhkkzChk(String pSyoNo, String pDskokNo, C_KouzasyuruiKbn pKouzasyuruiKbn) {

        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN3.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }
        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        return super.tokuteitrhkkzChk(pSyoNo, pDskokNo, pKouzasyuruiKbn);

    }

    @Override
    public C_ErrorKbn dskaiyakuukeumuChk(String pSyoNo) {

        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }
        if (caller == DwDenwaKaiyakuUketukeTest_execPostForm.class) {
            if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }
        return super.dskaiyakuukeumuChk(pSyoNo);

    }
}
