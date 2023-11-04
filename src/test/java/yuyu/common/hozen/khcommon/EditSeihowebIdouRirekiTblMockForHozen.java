package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KykKihon;

/**
 * {@link EditSeihowebIdouRirekiTbl}のモッククラスです。<br />
 */
public class EditSeihowebIdouRirekiTblMockForHozen extends EditSeihowebIdouRirekiTbl{

    public static Class<?> caller = null;

    public static String SYORIPTN = "";

    public static final String TESTPATTERN1 = "1";

    public EditSeihowebIdouRirekiTblMockForHozen() {
        super();
    }

    @Override
    public void exec(BizDate pIdouhasseiymd,
        C_SyoriKbn pSyoriKbn,
        String pHenkousikibetukey,
        String pGyoumuKousinKinou,
        String pGyoumuKousinsyaId,
        String pGyoumuKousinTime,
        IT_KykKihon pKykKihon,
        IT_AnsyuKihon pAnsyuKihon) {

        if (caller == EditTtdkRirekiTblTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
        }
        super.exec(pIdouhasseiymd,
            pSyoriKbn,
            pHenkousikibetukey,
            pGyoumuKousinKinou,
            pGyoumuKousinsyaId,
            pGyoumuKousinTime,
            pKykKihon,
            pAnsyuKihon);
    }

}
