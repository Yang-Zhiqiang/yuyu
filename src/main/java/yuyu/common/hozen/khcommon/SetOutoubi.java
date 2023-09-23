package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_TykzentykgoKbn;

/**
 * 契約保全 契約保全共通 直前直後応当日設定

 */
public class SetOutoubi {

    public SetOutoubi() {
        super();
    }

    public BizDate exec(C_TykzentykgoKbn pTykzenTykgoKbn, BizDate pKijyunYmd,
            C_Hrkkaisuu pHhrkkaisuu, BizDate pHanteiYmd) {

        BizDate outouYmd = null;
        BizDate nenOutouYmd = null;
        BizDate tykzenOutouYmd = null;
        BizDate tykgoOutouYmd = null;


        if (C_Hrkkaisuu.BLNK.eq(pHhrkkaisuu) || C_Hrkkaisuu.ITIJI.eq(pHhrkkaisuu)) {
            return outouYmd;
        }

        BizDate hoseiKijyunYmd = BizDate.valueOf(pHanteiYmd.getYear(), pKijyunYmd.getBizDateMD()).getRekijyou();


        if (C_TykzentykgoKbn.TYKGO.eq(pTykzenTykgoKbn)) {


            if (hoseiKijyunYmd.compareTo(pHanteiYmd) <= 0) {
                nenOutouYmd = BizDate.valueOf(pHanteiYmd.getYear() + 1, pKijyunYmd.getBizDateMD()).getRekijyou();
            }

            else {
                nenOutouYmd = hoseiKijyunYmd;
            }


            if (C_Hrkkaisuu.NEN.eq(pHhrkkaisuu)) {
                outouYmd = nenOutouYmd;
            }

            else {
                tykzenOutouYmd = nenOutouYmd;
                tykgoOutouYmd =  nenOutouYmd;
                while (tykzenOutouYmd.compareTo(pHanteiYmd) > 0) {
                    tykgoOutouYmd = tykzenOutouYmd;
                    tykzenOutouYmd = BizDate.valueOf(tykgoOutouYmd.getBizDateYM().addMonths(
                            -Integer.parseInt(pHhrkkaisuu.getValue())), pKijyunYmd.getDay()).getRekijyou();
                }
                outouYmd = tykgoOutouYmd;
            }
        }

        else {


            if (hoseiKijyunYmd.compareTo(pHanteiYmd) <= 0)  {
                nenOutouYmd = hoseiKijyunYmd;
            }

            else {
                nenOutouYmd = BizDate.valueOf(pHanteiYmd.getYear() - 1, pKijyunYmd.getBizDateMD()).getRekijyou();
            }


            if (C_Hrkkaisuu.NEN.eq(pHhrkkaisuu)) {
                outouYmd = nenOutouYmd;
            }

            else {
                tykzenOutouYmd = nenOutouYmd;
                tykgoOutouYmd =  nenOutouYmd;

                while (tykgoOutouYmd.compareTo(pHanteiYmd) <= 0) {
                    tykzenOutouYmd = tykgoOutouYmd;
                    tykgoOutouYmd = BizDate.valueOf(tykzenOutouYmd.getBizDateYM().addMonths(
                            Integer.parseInt(pHhrkkaisuu.getValue())), pKijyunYmd.getDay()).getRekijyou();
                }
                outouYmd = tykzenOutouYmd;
            }
        }

        return outouYmd;

    }

}