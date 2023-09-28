package yuyu.common.biz.keisan;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KyhgndkataKbn;

/**
 * 業務共通 計算 死亡保険金計算クラス
 */
public class KeisanSibouS {

//    @Inject
//    private KeisanV keisanV;

    public KeisanSibouS() {
        super();
    }

    public BizCurrency exec(
            String pSyouhncd,
            int pSyouhnSdno,
            C_KataKbn pKatakbn,
            C_KyhgndkataKbn pKyhgndKatakbn,
            C_HknkknsmnKbn pHknkknSmnkbn,
            int pHknkkn,
            C_HrkkknsmnKbn pHrkkknSmnkbn,
            int pHrkkkn,
            int pHhknNen,
            C_Hhknsei pHhknSei,
            BizCurrency pKihonS,
            BizDate pKykYmd,
            BizDate pCalckijyunYmd) {

//        BizCurrency sibouS = pKihonS;
//
//        BizCurrency tmpV = keisanV.exec(
//                pSyouhncd,
//                pSyouhnSdno,
//                pKatakbn,
//                pKyhgndKatakbn,
//                pHknkknSmnkbn,
//                pHknkkn,
//                pHrkkknSmnkbn,
//                pHrkkkn,
//                pHhknNen,
//                pHhknSei,
//                pKihonS,
//                pKykYmd,
//                pCalckijyunYmd,
//                KeisanV.JKIPJYTYM_ITIJIBR);
//
//        if (sibouS.compareTo(tmpV) < 0) {
//            sibouS = tmpV;
//        }
//
//        return sibouS;
        return null;
    }
}