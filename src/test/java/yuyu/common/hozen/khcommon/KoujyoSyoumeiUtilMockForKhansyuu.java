package yuyu.common.hozen.khcommon;

import java.util.List;

import yuyu.def.db.entity.IT_KykKihon;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;

/**
 * {@link KoujyoSyoumeiUtil}のモッククラスです<br />
 */
public class KoujyoSyoumeiUtilMockForKhansyuu extends KoujyoSyoumeiUtil {
    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public String chkTkZennouStkkntySeisan(IT_KykKihon pKykKihon, BizDateYM pSyoumeistartYm, BizDateYM pSyoumeiendYm,
        Integer pKihrkpSeisanRenno, BizDateYM pKihrkpSeisanJytYm) {

        if(caller == EditKoujyonaiyouTblZeitekiTest_exec.class) {

            if (SYORIPTN == TESTPATTERN1){

                return "RY01";
            } else if (SYORIPTN == TESTPATTERN2){

                return "";
            }

        }
        if(caller == EditKoujyonaiyouTblTest_exec.class) {

            if (SYORIPTN == TESTPATTERN1){

                return "RY01";
            } else if (SYORIPTN == TESTPATTERN2){

                return "";
            }
        }
        return super.chkTkZennouStkkntySeisan(pKykKihon,pSyoumeistartYm, pSyoumeiendYm,
            pKihrkpSeisanRenno, pKihrkpSeisanJytYm);
    }

    @Override
    public BizCurrency sumSyouhnp(List<KykSyouhnCommonParam> pKykSyouhnCommonParamLst) {

        if(caller == EditKoujyonaiyouTblZeitekiTest_exec.class) {

            if (SYORIPTN == TESTPATTERN1){

                return BizCurrency.valueOf(208000);
            }else if (SYORIPTN == TESTPATTERN2){

                return BizCurrency.valueOf(350000);
            }
        }
        return super.sumSyouhnp(pKykSyouhnCommonParamLst);
    }


}
