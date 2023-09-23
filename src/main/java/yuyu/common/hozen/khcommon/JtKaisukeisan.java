package yuyu.common.hozen.khcommon;

import yuyu.def.classification.C_Hrkkaisuu;

/**
 * 契約保全 契約保全共通 充当回数計算
 */
public class JtKaisukeisan {

    private int jyutouKaisuu;

    private int hasuuTuki;

    public JtKaisukeisan() {
        super();
    }

    public int getJyutoukaisuu() {

        return jyutouKaisuu;
    }

    public int getHasuutuki() {

        return hasuuTuki;
    }

    public void exec(int pIJtNensuu,
            int          pIJtGesuu,
            C_Hrkkaisuu  pIHhrkkaisuu) {

        jyutouKaisuu = 0;
        hasuuTuki = 0;

        if (C_Hrkkaisuu.ITIJI.eq(pIHhrkkaisuu)) {
            jyutouKaisuu = 1;
            hasuuTuki = 0;
            return;
        }

        int jtGessu = 0;

        if(pIJtNensuu > 0) {
            jtGessu  = pIJtNensuu * 12;
        }

        if(pIJtGesuu > 0) {
            jtGessu  = jtGessu + pIJtGesuu;
        }

        jyutouKaisuu = jtGessu /Integer.valueOf(pIHhrkkaisuu.getValue());

        hasuuTuki = jtGessu % Integer.valueOf(pIHhrkkaisuu.getValue());
    }

}
