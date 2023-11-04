package yuyu.common.hozen.khcommon;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_SyouhnTokujou;

/**
 * {@link EditSyoukenTbl}のモッククラスです。<br />
 */
public class EditSyoukenTblMock extends EditSyoukenTbl {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    private C_HassouKbn hassoukbn;

    @Override
    public C_HassouKbn getHassoukbn() {

        if (caller == KhozenTyouhyouCtlTest_createTyouhyouTBL.class && TESTPATTERN1.equals(SYORIPTN)) {
            return hassoukbn;
        }
        return super.getHassoukbn();
    }

    public void setHassoukbn(C_HassouKbn hassoukbn) {
        this.hassoukbn = hassoukbn;
    }

    public EditSyoukenTblMock() {
        super();
    }

    @Override
    public void editTBL(KhozenCommonParam pKCParm,
        IT_KykKihon pKykKihon,
        List<IT_KykSyouhn> pSyuKykSyouhnLst,
        IT_KykSonotaTkyk pKykSonotaTkyk,
        List<IT_KykSyouhn> pTkKykSyouhnLst,
        IT_SyouhnTokujou pSyhnTkjouSyu,
        IT_KykSya pKykSya,
        IT_HhknSya pHhknSya,
        IT_KykUkt pSibouHenkan,
        IT_KykUkt pSiteiDairi,
        List<IT_KykDairiten> pKykDairitenLst,
        IT_KhTtdkTyuui pKhTtdkTyuui,
        List<IT_KykUkt> pSibouhokenLst,
        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst,
        EditHokenSyoukenParam pEditHokenSyoukenParam,
        BizDate pSyoriYmd,
        C_SinsaihkKbn pSinsaihkKbn,
        C_TetudukisyuKbn pTetudukisyuKbn,
        C_HassouKbn pHassouKbn) {

        if (caller == KhozenTyouhyouCtlTest_createTyouhyouTBL.class && TESTPATTERN1.equals(SYORIPTN)) {

            setHassoukbn(pHassouKbn);
            return;

        }
        else if ((caller == EditSyoukenTblTest_editTBL_A1.class || caller == EditSyoukenTblTest_editTBL_A2.class ||
            caller == EditSyoukenTblTest_editTBL_A3.class || caller == EditSyoukenTblTest_editTBL_A4.class ||
            caller == EditSyoukenTblTest_editTBL_A5.class || caller == EditSyoukenTbltest_editTBL.class) &&
            TESTPATTERN1.equals(SYORIPTN)) {
            return;
        }

        super.editTBL(pKCParm, pKykKihon, pSyuKykSyouhnLst, pKykSonotaTkyk,pTkKykSyouhnLst, pSyhnTkjouSyu, pKykSya,
            pHhknSya, pSibouHenkan, pSiteiDairi, pKykDairitenLst, pKhTtdkTyuui, pSibouhokenLst, pNyknJissekiRirekiLst,
            pEditHokenSyoukenParam, pSyoriYmd, pSinsaihkKbn, pTetudukisyuKbn, pHassouKbn);

    }

}
