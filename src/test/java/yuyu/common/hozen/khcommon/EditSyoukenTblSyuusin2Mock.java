package yuyu.common.hozen.khcommon;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;

/**
 * {@link EditSyoukenTblSyuusin2Mock}のモッククラスです。<br />
 */
public class EditSyoukenTblSyuusin2Mock extends EditSyoukenTblSyuusin2{

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public EditSyoukenTblSyuusin2Mock() {
        super();
    }

    @Override
    public void editTBL(IT_HokenSyouken pHokenSyouken, IT_KykKihon pKykKihon,
        IT_KykSya pKykSya, IT_HhknSya pHhknSya,
        List<IT_KykSyouhn> pSyuKykSyouhnLst,
        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst,
        IT_KykSonotaTkyk pKykSonotaTkyk, IT_KykUkt pSiteiDairi,
        List<IT_KykUkt> pSibouhokenLst, EditHokenSyoukenParam pEditHokenSyoukenParam, BizDate pSyoriYmd,
        C_KjkhukaKbn pSbUktNmKjHukaKbn, C_UmuKbn pGengakuExistsCheck,
        int pSksyoukenskskbn, int pSinkykjyoutai, BM_SyouhnZokusei pSyouhnZokusei, C_SyoriKbn pYendthnkSyoriKbn) {

        if (caller == EditSyoukenTbltest_editTBL.class && TESTPATTERN1.equals(SYORIPTN)) {
            return;
        }

        super.editTBL(pHokenSyouken, pKykKihon, pKykSya, pHhknSya, pSyuKykSyouhnLst, pNyknJissekiRirekiLst, pKykSonotaTkyk,
            pSiteiDairi, pSibouhokenLst, pEditHokenSyoukenParam, pSyoriYmd, pSbUktNmKjHukaKbn, pGengakuExistsCheck,
            pSksyoukenskskbn, pSinkykjyoutai, pSyouhnZokusei, pYendthnkSyoriKbn);
    }
}
