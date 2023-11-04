package yuyu.common.sinkeiyaku.skcommon;

import yuyu.app.bosyuu.hbsksyoukai.hbseihowebmossyoukai.HbSeihoWebMosSyoukaiTest_execPostForm2;
import yuyu.common.sinkeiyaku.moschk.CheckYakkanJyuryouHouhouTest_exec;
import yuyu.def.classification.C_AisyoumeiChannelKbn;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_HknsyuruiNo;

/**
 * {@link GetHknsyuruinm}のモッククラスです。<br />
 */
public class GetHknsyuruinmMockForSinkeiyaku extends GetHknsyuruinm{

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public HknsyuruinmBean setAisyoumeikbn(String pHknsyuruino,
        Integer pHknsyuruinosd, C_AisyoumeiChannelKbn pAisyoumeiChannelKbn, String pSyouhncd) {

        if (caller == CheckYakkanJyuryouHouhouTest_exec.class ) {

            if(TESTPATTERN1.equals(SYORIPTN)){

                HknsyuruinmBean hknsyuruinmBean = new HknsyuruinmBean();
                hknsyuruinmBean.setAisyoumeikbn(C_AisyoumeiKbn.GAIKARIRITUHENDOUNK_MDHN);

                return hknsyuruinmBean;
            }

        }
        return super.setAisyoumeikbn(pHknsyuruino, pHknsyuruinosd, pAisyoumeiChannelKbn, pSyouhncd);
    }

    @Override
    public HknsyuruinmBean getHknsyuruinm(C_HknsyuruiNo pHknnsyuruiNo,
        Integer PHknsyuruinosd, C_AisyoumeiKbn pAisyoumeikbn) {
        if (caller == HbSeihoWebMosSyoukaiTest_execPostForm2.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                HknsyuruinmBean hknsyuruinmBean = new HknsyuruinmBean();
                hknsyuruinmBean.setAisyoumei("愛称名");
                hknsyuruinmBean.setKokyakuhknnsyuruinmtwogyou2("顧客用保険種類名２");
                hknsyuruinmBean.setKokyakuhknnsyuruinmtwogyou1("顧客用保険種類名１");

                return hknsyuruinmBean;
            }
        }

        return super.getHknsyuruinm(pHknnsyuruiNo, PHknsyuruinosd, pAisyoumeikbn);
    }

}
