package yuyu.common.biz.bzcommon;

import java.math.RoundingMode;

import jp.co.slcs.swak.number.BizNumber;

/**
 * 計算ユーティリティクラスです。<br />
 */
public class MathUtil
{

    public static BizNumber powDecimal(BizNumber pbdBase,
            BizNumber pbdExponent,
            int piScale,
            int piRoundingMode){
        double dBase = 0;
        double dExponent = 0;
        double dKekka = 0;
        BizNumber bdKekka = null;


        dBase = Double.parseDouble(pbdBase.toString());
        dExponent = Double.parseDouble(pbdExponent.toString());

        dKekka = Math.pow(dBase, dExponent);

        bdKekka = BizNumber.valueOf(dKekka);

        bdKekka = bdKekka.round(piScale, RoundingMode.valueOf(piRoundingMode));

        return bdKekka;
    }
}
