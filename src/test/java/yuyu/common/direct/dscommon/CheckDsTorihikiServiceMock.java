package yuyu.common.direct.dscommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.app.dsweb.dwhozentetuduki.dwkaiyakuuketuke.DwKaiyakuUketukeTest_execPostFormPrepare;
import yuyu.app.dsweb.dwhozentetuduki.dwkaiyakuuketuke.DwKaiyakuUketukeTest_execPostFormUpdate;
import yuyu.common.hozen.khcommon.EditSouhuannaiTblTest_editBean;
import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_SoukinyoukzchkkekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;

/**
 * {@link CheckDsTorihikiService}のモッククラスです。<br />
 */
public class CheckDsTorihikiServiceMock extends CheckDsTorihikiService {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    @Override
    public CheckSoukinyoukzResultBean checkSoukinyoukz(C_Tuukasyu pShrtuukasyu, String pBankCd, String pSitenCd,
        String pKzmeiginmKn, C_Kzdou pKzdouKbn, String pKyknmKn) {

        if (caller == DwKaiyakuUketukeTest_execPostFormPrepare.class ){
            CheckSoukinyoukzResultBean checkSoukinyoukzResultBean = SWAKInjector.getInstance(CheckSoukinyoukzResultBean.class);
            checkSoukinyoukzResultBean.setChkkekkaKbn(C_ChkkekkaKbn.ERROR);
            if (TESTPATTERN1.equals(SYORIPTN)) {
                checkSoukinyoukzResultBean.setSoukinyoukzchkkekkaKbn(C_SoukinyoukzchkkekkaKbn.GINKOUMASTERSONZAI);
                return checkSoukinyoukzResultBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                checkSoukinyoukzResultBean.setSoukinyoukzchkkekkaKbn(C_SoukinyoukzchkkekkaKbn.GINKOUYUUKOUHANTEI);
                return checkSoukinyoukzResultBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                checkSoukinyoukzResultBean.setSoukinyoukzchkkekkaKbn(C_SoukinyoukzchkkekkaKbn.YUUTYOGINKOUSOUKINKAHI);
                return checkSoukinyoukzResultBean;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                checkSoukinyoukzResultBean.setSoukinyoukzchkkekkaKbn(C_SoukinyoukzchkkekkaKbn.GAIKAKOUZASOUKINKAHI);
                return checkSoukinyoukzResultBean;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                checkSoukinyoukzResultBean.setSoukinyoukzchkkekkaKbn(C_SoukinyoukzchkkekkaKbn.KOUZAMEIGININ);
                return checkSoukinyoukzResultBean;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                checkSoukinyoukzResultBean.setSoukinyoukzchkkekkaKbn(C_SoukinyoukzchkkekkaKbn.BLNK);
                return checkSoukinyoukzResultBean;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                checkSoukinyoukzResultBean.setChkkekkaKbn(C_ChkkekkaKbn.SEIJYOU);
                return checkSoukinyoukzResultBean;
            }
        }

        if (caller == CheckKaiyakuUketukeTest_kaiyakusyokaiChk.class ){
            CheckSoukinyoukzResultBean checkSoukinyoukzResultBean = SWAKInjector.getInstance(CheckSoukinyoukzResultBean.class);
            checkSoukinyoukzResultBean.setChkkekkaKbn(C_ChkkekkaKbn.ERROR);
            if (TESTPATTERN1.equals(SYORIPTN)) {
                checkSoukinyoukzResultBean.setSoukinyoukzchkkekkaKbn(C_SoukinyoukzchkkekkaKbn.GINKOUMASTERSONZAI);
                return checkSoukinyoukzResultBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                checkSoukinyoukzResultBean.setSoukinyoukzchkkekkaKbn(C_SoukinyoukzchkkekkaKbn.GINKOUYUUKOUHANTEI);
                return checkSoukinyoukzResultBean;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                checkSoukinyoukzResultBean.setSoukinyoukzchkkekkaKbn(C_SoukinyoukzchkkekkaKbn.YUUTYOGINKOUSOUKINKAHI);
                return checkSoukinyoukzResultBean;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                checkSoukinyoukzResultBean.setSoukinyoukzchkkekkaKbn(C_SoukinyoukzchkkekkaKbn.GAIKAKOUZASOUKINKAHI);
                return checkSoukinyoukzResultBean;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                checkSoukinyoukzResultBean.setSoukinyoukzchkkekkaKbn(C_SoukinyoukzchkkekkaKbn.KOUZAMEIGININ);
                return checkSoukinyoukzResultBean;
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                checkSoukinyoukzResultBean.setSoukinyoukzchkkekkaKbn(C_SoukinyoukzchkkekkaKbn.BLNK);
                return checkSoukinyoukzResultBean;
            }
            else if (TESTPATTERN7.equals(SYORIPTN)) {
                checkSoukinyoukzResultBean.setChkkekkaKbn(C_ChkkekkaKbn.SEIJYOU);
                return checkSoukinyoukzResultBean;
            }
        }

        if (caller == DwKaiyakuUketukeTest_execPostFormUpdate.class ){
            if (TESTPATTERN1.equals(SYORIPTN)) {
                CheckSoukinyoukzResultBean checkSoukinyoukzResultBean = SWAKInjector.getInstance(CheckSoukinyoukzResultBean.class);
                checkSoukinyoukzResultBean.setChkkekkaKbn(C_ChkkekkaKbn.SEIJYOU);
                return checkSoukinyoukzResultBean;
            }
        }

        return super.checkSoukinyoukz(pShrtuukasyu, pBankCd, pSitenCd, pKzmeiginmKn, pKzdouKbn, pKyknmKn);
    }

    @Override
    public GetTrhkServiceTourokuJyoukyouBean getTrhkServiceTourokuJyoukyou(String pSyono){

        if(caller == EditSouhuannaiTblTest_editBean.class){

            if(TESTPATTERN1.equals(SYORIPTN)){
                GetTrhkServiceTourokuJyoukyouBean getTrhkServiceTourokuJyoukyou =
                    SWAKInjector.getInstance(GetTrhkServiceTourokuJyoukyouBean.class);

                getTrhkServiceTourokuJyoukyou.setDsKaiykServiceTourokuUmu(C_UmuKbn.ARI);
                return getTrhkServiceTourokuJyoukyou;
            }
            else if(TESTPATTERN2.equals(SYORIPTN)){
                GetTrhkServiceTourokuJyoukyouBean getTrhkServiceTourokuJyoukyou =
                    SWAKInjector.getInstance(GetTrhkServiceTourokuJyoukyouBean.class);

                getTrhkServiceTourokuJyoukyou.setDsKaiykServiceTourokuUmu(C_UmuKbn.NONE);
                return getTrhkServiceTourokuJyoukyou;

            }
        }
        return super.getTrhkServiceTourokuJyoukyou(pSyono);
    }
}
