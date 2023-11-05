package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiTy;

/**
 * {@link EditKykNaiyouOsirase2}のモッククラスです<br />
 */
public class EditKykNaiyouOsirase2Mock extends EditKykNaiyouOsirase2 {

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public ZT_GaikaKokyakuTuutiTy editInfo(
        IT_KykKihon pKykKihon,
        BizDate pSyoriYmd,
        BizDate pKykoutoubi,
        String pSyouhnHanmeiKbn,
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn) {

        if (caller == EditKykNaiyouOsiraseTest_editInfo.class) {

            pGaikaKokyakuTuutiTyn.setZtysyoruicd(C_SyoruiCdKbn.KK_DSHR_SKS.getValue().toUpperCase());
            pGaikaKokyakuTuutiTyn.setZtyosirasemsgcd1("Ztyosirasemsgcd11");
            pGaikaKokyakuTuutiTyn.setZtyosirasemsgcd2("Ztyosirasemsgcd22");

            return pGaikaKokyakuTuutiTyn;
        }

        return super.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pSyouhnHanmeiKbn, pGaikaKokyakuTuutiTyn);
    }
}
