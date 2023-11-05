package yuyu.common.hozen.khcommon;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import lombok.Getter;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;

/**
 * {@link EditSuiihyouTblNenkin3}のモッククラスです。<br />
 */
public class EditSuiihyouTblNenkin3MockForHozen extends EditSuiihyouTblNenkin3{

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    @Getter
    private Integer sisuuUpCount1 = 0;

    @Getter
    private Integer sisuuDownCount1 = 0;

    public EditSuiihyouTblNenkin3MockForHozen(){
        super();
    }

    @Override
    public void editTBL(KhozenCommonParam pKkanriCommonParam,
        IT_KykKihon pKykKihon,
        List<IT_KykSyouhn> pKykSyohnSyuLst,
        List<IT_KykSyouhn> pKykSyouhnLst,
        IT_HhknSya pHhknSya,
        BizDate pSyoriYmd,
        EditHokenSyoukenParam pEditHokenSyoukenParam,
        C_SinsaihkKbn pCSinsaihkKbn,
        BM_SyouhnZokusei pSyouhnZokusei,
        IT_KykSonotaTkyk pKykSonotaTkyk) {

        if (caller == EditSyoukenTbltest_editTBL.class ) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                sisuuUpCount1 = 3;
                sisuuDownCount1 = 4;
                return;
            }
        }
        super.editTBL(pKkanriCommonParam, pKykKihon, pKykSyohnSyuLst, pKykSyouhnLst, pHhknSya,
            pSyoriYmd, pEditHokenSyoukenParam, pCSinsaihkKbn, pSyouhnZokusei, pKykSonotaTkyk);
    }
}
