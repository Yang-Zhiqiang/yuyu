package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiTy;

/**
 * {@link EditKykNaiyouOsirase6}のモッククラスです<br />
 */
public class EditKykNaiyouOsirase6MockForHozen extends EditKykNaiyouOsirase6 {

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public ZT_GaikaKokyakuTuutiTy editInfo(
        IT_KykKihon pKykKihon,
        BizDate pSyoriYmd,
        BizDate pKykoutoubi,
        KawaseRateBean pKawaseRateBean,
        ZT_GaikaKokyakuTuutiTy pGaikaKokyakuTuutiTyn) {

        if (caller == EditKykNaiyouOsiraseTest_editInfo.class) {

            pGaikaKokyakuTuutiTyn.setZtysyoruicd(C_SyoruiCdKbn.KK_GAIKA_KOKYAKUTUUTI.getValue().toUpperCase());
            pGaikaKokyakuTuutiTyn.setZtyosirasemsgcd1("08012");
            pGaikaKokyakuTuutiTyn.setZtyaisatumsgcd1("03004");
            //            pGaikaKokyakuTuutiTyn.setZtyosirasemsgcd2("Ztyosirasemsgcd62");

            return pGaikaKokyakuTuutiTyn;
        }

        return super.editInfo(pKykKihon, pSyoriYmd, pKykoutoubi, pKawaseRateBean, pGaikaKokyakuTuutiTyn);
    }
}
