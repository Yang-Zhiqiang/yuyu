package yuyu.common.hozen.khcommon;

import java.util.List;

import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;

/**
 * {@link EditSyoukenTblNenkin}のモッククラスです。<br />
 */
public class EditSyoukenTblNenkinMockForHozen extends EditSyoukenTblNenkin{

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public EditSyoukenTblNenkinMockForHozen() {
        super();
    }

    @Override
    public void editTBL(
        IT_HokenSyouken pHokenSyouken,
        IT_KykKihon pKykKihon,
        EditHokenSyoukenParam pEditHokenSyoukenParam,
        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst,
        IT_KykSya pKykSya,
        List<IT_KykSyouhn> pSyuKykSyouhnLst,
        IT_KykSonotaTkyk pKykSonotaTkyk,
        List<IT_KykUkt> pSibouhokenLst,
        IT_KykUkt pSiteiDairi,
        int pSksyoukenskskbn,
        int pSinkykjyoutai,
        C_UmuKbn pGengakuExistsCheck,
        C_KjkhukaKbn pSbUktNmKjHukaKbn,
        C_SyoriKbn pYendthnkSyoriKbn) {

        if (caller == EditSyoukenTbltest_editTBL.class && TESTPATTERN1.equals(SYORIPTN)) {
            return;
        }

        super.editTBL(pHokenSyouken, pKykKihon, pEditHokenSyoukenParam, pNyknJissekiRirekiLst, pKykSya, pSyuKykSyouhnLst,
            pKykSonotaTkyk, pSibouhokenLst, pSiteiDairi, pSksyoukenskskbn, pSinkykjyoutai, pGengakuExistsCheck, pSbUktNmKjHukaKbn, pYendthnkSyoriKbn);
    }
}
