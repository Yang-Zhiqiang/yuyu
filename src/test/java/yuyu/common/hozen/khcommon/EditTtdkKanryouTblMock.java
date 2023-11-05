package yuyu.common.hozen.khcommon;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhHasseijiKazeiRireki;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_TtdkKan;

/**
 * {@link EditTtdkKanryouTbl}のモッククラスです。<br />
 */
public class EditTtdkKanryouTblMock extends EditTtdkKanryouTbl {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static String mode = "1";

    public EditTtdkKanryouTblMock() {
        super();
    }

    @Override
    public IT_TtdkKan editTBL(KhozenCommonParam pKcp,
        IT_KykKihon pKykKihon,
        List<IT_KykSyouhn> pKykSyouhnLst,
        IT_KykSya pKykSya,
        IT_HhknSya pHhknSya,
        EditTtdkKanryouParam pParam,
        IT_KhShrRireki pKhShrRireki,
        IT_KhHasseijiKazeiRireki pKhHasseijiKazeiRireki,
        IT_KykSonotaTkyk pKykSonotaTkyk,
        BizDate pDispsyoriymd,
        C_HassouKbn pHassouKbn,
        C_SyoruiCdKbn pSyoruiCd) {

        if (caller == KhozenTyouhyouCtlTest_createTyouhyouTBL.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                IT_TtdkKan ttdkKan = pKykKihon.createTtdkKan();

                ttdkKan.setHenkousikibetukey("00000000001");

                BizPropertyInitializer.initialize(ttdkKan);

                return ttdkKan;
            }

            else if (TESTPATTERN2.equals(SYORIPTN)) {

                return null;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {

                IT_TtdkKan ttdkKan = pKykKihon.createTtdkKan();
                String henkousikibetukey = "10000000001";

                if ("1".equals(mode)) {
                    mode = "2";
                } else {
                    henkousikibetukey = "10000000002";
                    mode = "1";
                }
                ttdkKan.setHenkousikibetukey(henkousikibetukey);

                BizPropertyInitializer.initialize(ttdkKan);

                return ttdkKan;
            }
        }

        return super.editTBL(pKcp, pKykKihon, pKykSyouhnLst, pKykSya,pHhknSya, pParam, pKhShrRireki, pKhHasseijiKazeiRireki, pKykSonotaTkyk, pDispsyoriymd, pHassouKbn, pSyoruiCd);
    }
}
