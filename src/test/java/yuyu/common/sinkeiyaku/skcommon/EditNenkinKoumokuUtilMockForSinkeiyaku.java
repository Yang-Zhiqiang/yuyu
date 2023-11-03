package yuyu.common.sinkeiyaku.skcommon;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.app.bosyuu.hbsekmos.hbseihowebnenkinkaiyakuhrsuii.HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm;
import yuyu.app.bosyuu.hbsksyoukai.hbseihowebmossyoukai.HbSeihoWebMosSyoukaiTest_execPostForm2;
import yuyu.common.sinkeiyaku.moschk.CheckTblMosSyouhinTest_exec;
import yuyu.common.sinkeiyaku.moschk.CheckTblMosSyouhinTest_exec5;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;

/**
 * {@link EditNenkinKoumokuUtil}のモッククラスです。<br />
 */

public class EditNenkinKoumokuUtilMockForSinkeiyaku extends EditNenkinKoumokuUtil {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    private Integer nenkinSiharaiKaisiNenrei = 0;

    private Integer nenkinSueokikikan = 0;

    @Override
    public BizCurrency getNkgnsKijyunGk() {
        if(caller == SkToujituIdounaiyouEditTest_setSkIdounaiyouBefore.class ||
            caller == SkToujituIdounaiyouEditTest_skIdounaiyouHenkouCheck.class ||
            caller == SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit.class ||
            caller == SkToujituIdounaiyouEditTest_skIdounaiyouFileEdit.class
            ){
            return getSkNkgnsKijyunGk(null,null,null);
        }
        return super.getNkgnsKijyunGk();
    }

    @Override
    public BizCurrency getSkNkgnsKijyunGk(BM_SyouhnZokusei pSyouhnZokusei, HT_MosKihon pMosKihon,
        HT_MosSyouhn pMosSyouhn) {

        if (caller == SkToujituIdounaiyouEditTest_setSkIdounaiyouBefore.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizCurrency.valueOf(1000);
            }
        }
        if (caller == SkToujituIdounaiyouEditTest_skIdounaiyouHenkouCheck.class ) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizCurrency.valueOf(400);
            }
        }
        if (caller == SkToujituIdounaiyouEditTest_skIdounaiyouMQEdit.class ) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizCurrency.valueOf(400);
            }
        }
        if (caller == SkToujituIdounaiyouEditTest_skIdounaiyouFileEdit.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return BizCurrency.valueOf(400);
            }
        }
        if (caller == SkToujituIdounaiyouEditTest_skIdounaiyouFileEdit.class ) {

            if (TESTPATTERN2.equals(SYORIPTN)) {

                return BizCurrency.valueOf(400, BizCurrencyTypes.DOLLAR);
            }
        }
        if (caller == SkToujituIdounaiyouEditTest_skIdounaiyouFileEdit.class ) {

            if (TESTPATTERN3.equals(SYORIPTN)) {

                return BizCurrency.valueOf(400, BizCurrencyTypes.AU_DOLLAR);
            }
        }

        return super.getSkNkgnsKijyunGk(pSyouhnZokusei, pMosKihon, pMosSyouhn) ;
    }

    @Override
    public C_ErrorKbn editNenkinSiharaiKaisiNenrei(Integer pHknkkn, C_HknkknsmnKbn pHknkknsmnKbn, Integer pHhknnen) {

        if (caller == HbSeihoWebMosSyoukaiTest_execPostForm2.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                nenkinSiharaiKaisiNenrei = 100;
                return C_ErrorKbn.OK;
            }
        }
        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
        }

        return super.editNenkinSiharaiKaisiNenrei(pHknkkn, pHknkknsmnKbn, pHhknnen) ;
    }

    @Override
    public C_ErrorKbn editNenkinSueokikikan(Integer pHknkkn, C_HknkknsmnKbn pHknkknsmnKbn,
        Integer pHrkkkn, C_HrkkknsmnKbn pHrkkknsmnKbn, Integer pHhknnen) {

        if (caller == HbSeihoWebMosSyoukaiTest_execPostForm2.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        if ((caller == CheckTblMosSyouhinTest_exec.class || caller == CheckTblMosSyouhinTest_exec5.class)) {
            if (TESTPATTERN1.equals(SYORIPTN)||TESTPATTERN4.equals(SYORIPTN)) {
                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }
        return super.editNenkinSueokikikan(pHknkkn,pHknkknsmnKbn,pHrkkkn,pHrkkknsmnKbn,pHhknnen);
    }

    @Override
    public Integer getNenkinSiharaiKaisiNenrei() {

        if (caller == HbSeihoWebMosSyoukaiTest_execPostForm2.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                nenkinSiharaiKaisiNenrei = 5;
                return nenkinSiharaiKaisiNenrei;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                nenkinSiharaiKaisiNenrei = 100;
                return nenkinSiharaiKaisiNenrei;
            }

        }

        if ((caller == CheckTblMosSyouhinTest_exec.class || caller == CheckTblMosSyouhinTest_exec5.class)) {

            if (TESTPATTERN4.equals(SYORIPTN)) {
                nenkinSiharaiKaisiNenrei = 0;
                return nenkinSiharaiKaisiNenrei;
            }
        }

        if (caller == HbSeihoWebNenkinKaiyakuhrSuiiTest_execPostForm.class) {

            if (TESTPATTERN5.equals(SYORIPTN)) {
                nenkinSiharaiKaisiNenrei = 5;
                return nenkinSiharaiKaisiNenrei;
            }
        }

        return super.getNenkinSiharaiKaisiNenrei();
    }

    @Override
    public Integer getNenkinSueokikikan() {

        if (caller == HbSeihoWebMosSyoukaiTest_execPostForm2.class &&TESTPATTERN1.equals(SYORIPTN)) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                nenkinSueokikikan = 10;
                return nenkinSueokikikan;
            }
        }

        if (caller == CheckTblMosSyouhinTest_exec5.class) {
            if (TESTPATTERN4.equals(SYORIPTN)) {
                nenkinSueokikikan = 5;
                return nenkinSueokikikan;
            }
        }
        return super.getNenkinSueokikikan();
    }
}
