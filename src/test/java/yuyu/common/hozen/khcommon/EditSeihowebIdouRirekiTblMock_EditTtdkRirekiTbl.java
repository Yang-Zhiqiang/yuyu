package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KykKihon;

/**
 * {@link EditSeihowebIdouRirekiTbl}のモッククラスです。<br />
 */
public class EditSeihowebIdouRirekiTblMock_EditTtdkRirekiTbl extends EditSeihowebIdouRirekiTbl {

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public EditSeihowebIdouRirekiTblMock_EditTtdkRirekiTbl() {
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

        if (TESTPATTERN1.equals(SYORIPTN)) {

            return;
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
