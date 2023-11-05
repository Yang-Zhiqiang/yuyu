package yuyu.common.direct.dscommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.hozen.khcommon.EditSouhuannaiTblTest_editBean;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;

/**
 * ダイレクトサービス ダイレクトサービス共通 ＤＳ取引サービス共通チェック
 */
public class CheckDsTorihikiServiceMockForHozen extends CheckDsTorihikiService{

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    @Override
    public CheckSoukinyoukzResultBean checkSoukinyoukz(C_Tuukasyu pShrtuukasyu, String pBankCd, String pSitenCd,
        String pKzmeiginmKn, C_Kzdou pKzdouKbn, String pKyknmKn) {

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
            if(TESTPATTERN2.equals(SYORIPTN)){
                GetTrhkServiceTourokuJyoukyouBean getTrhkServiceTourokuJyoukyou =
                    SWAKInjector.getInstance(GetTrhkServiceTourokuJyoukyouBean.class);

                getTrhkServiceTourokuJyoukyou.setDsKaiykServiceTourokuUmu(C_UmuKbn.NONE);
                return getTrhkServiceTourokuJyoukyou;

            }
        }
        return super.getTrhkServiceTourokuJyoukyou(pSyono);
    }
}
