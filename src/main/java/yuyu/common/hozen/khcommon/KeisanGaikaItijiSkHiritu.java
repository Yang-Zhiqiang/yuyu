package yuyu.common.hozen.khcommon;

import java.math.RoundingMode;

import jp.co.slcs.swak.number.BizNumber;

/**
 * 契約保全 契約保全共通 外貨終身一時払用予定新契約比率計算
 */
public class KeisanGaikaItijiSkHiritu {

    public KeisanGaikaItijiSkHiritu() {
        super();
    }

    public BizNumber exec(BizNumber pYoteiRiritu, int pHhknNen) {

        BizNumber yoteiSinkykhiRitu = BizNumber.ZERO;

        BizNumber wkYoteiRiritu = BizNumber.ZERO;

        BizNumber wk80MadeKikan = BizNumber.ZERO;

        BizNumber wkYoteiRirituHikakuKekka1 = BizNumber.ZERO;

        BizNumber wkKikanHikakuKekka1 = BizNumber.ZERO;

        BizNumber wkYoteiRirituHikakuKekka2 = BizNumber.ZERO;

        BizNumber wkKikanHikakuKekka2 = BizNumber.ZERO;

        BizNumber wkJyougenHikakuKekka = BizNumber.ZERO;

        BizNumber wkSaisyuuHikakuKekka = BizNumber.ZERO;

        BizNumber wkKeisanKekka1 = BizNumber.ZERO;

        BizNumber wkKeisanKekka2 = BizNumber.ZERO;

        BizNumber wkKeisanKekka3 = BizNumber.ZERO;

        wkYoteiRiritu = pYoteiRiritu.multiply(BizNumber.valueOf(100));

        if (wkYoteiRiritu.compareTo(BizNumber.valueOf(1)) > 0) {
            wkYoteiRirituHikakuKekka1 = wkYoteiRiritu;
        }
        else {
            wkYoteiRirituHikakuKekka1 = BizNumber.valueOf(1);
        }

        wk80MadeKikan = BizNumber.valueOf(80).subtract(BizNumber.valueOf(pHhknNen));

        if (wk80MadeKikan.compareTo(BizNumber.valueOf(0)) > 0) {
            wkKikanHikakuKekka1 = wk80MadeKikan;
        }
        else {
            wkKikanHikakuKekka1 = BizNumber.valueOf(0);
        }

        if (wkYoteiRiritu.compareTo(BizNumber.valueOf(1)) > 0) {
            wkYoteiRirituHikakuKekka2 = BizNumber.valueOf(1);
        }
        else {
            wkYoteiRirituHikakuKekka2 = wkYoteiRiritu;
        }

        if (wkKikanHikakuKekka1.compareTo(BizNumber.valueOf(10)) > 0) {
            wkKikanHikakuKekka2 = BizNumber.valueOf(10);
        }
        else {
            wkKikanHikakuKekka2 = wkKikanHikakuKekka1;
        }

        wkKeisanKekka1 = wkYoteiRirituHikakuKekka1.subtract(BizNumber.valueOf(1.5));

        wkKeisanKekka2 = wkKikanHikakuKekka2.multiply(BizNumber.valueOf(0.125));

        wkKeisanKekka3 = (wkKeisanKekka1.multiply(BizNumber.valueOf(2.5)).add(BizNumber.valueOf(1.5)).add(wkKeisanKekka2));

        if (wkKeisanKekka3.compareTo(BizNumber.valueOf(4)) > 0) {
            wkJyougenHikakuKekka = BizNumber.valueOf(4);
        } else {
            wkJyougenHikakuKekka = wkKeisanKekka3;
        }

        if (wkJyougenHikakuKekka.compareTo(BizNumber.valueOf(1)) > 0) {
            wkSaisyuuHikakuKekka = wkJyougenHikakuKekka.multiply(wkYoteiRirituHikakuKekka2);
        } else {
            wkSaisyuuHikakuKekka = wkYoteiRirituHikakuKekka2.multiply(BizNumber.valueOf(1));
        }

        yoteiSinkykhiRitu = wkSaisyuuHikakuKekka.round(5, RoundingMode.DOWN);

        return yoteiSinkykhiRitu;
    }
}