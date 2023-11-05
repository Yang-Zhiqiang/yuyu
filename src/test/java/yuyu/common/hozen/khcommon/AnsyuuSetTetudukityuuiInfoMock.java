package yuyu.common.hozen.khcommon;

import yuyu.def.classification.C_KktyuitaKbn;

/**
 * 案内収納用注意情報設定のモッククラスです。<br />
 */
public class AnsyuuSetTetudukityuuiInfoMock extends AnsyuuSetTetudukityuuiInfo {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public C_KktyuitaKbn exec(String pSyono) {

        if (caller == EditHrhnKanryoTuutiTest_editTBL.class && TESTPATTERN1.equals(SYORIPTN)) {

            return C_KktyuitaKbn.DNGNMEMOARI;
        }
        if (caller == EditHrhnKanryoTuutiTest_editTBL.class && TESTPATTERN2.equals(SYORIPTN)) {

            return C_KktyuitaKbn.DNGNMEMONASI;
        }

        return super.exec(pSyono);
    }

}
