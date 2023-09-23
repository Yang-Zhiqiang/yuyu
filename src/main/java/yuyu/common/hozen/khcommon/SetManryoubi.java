package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_KknsmnKbn;


/**
 * 契約保全 契約保全共通 期間満了日設定
 */
public class SetManryoubi {

    private static final int SYSN = 99;

    private static final int ITIJIBARAI = 0;

    private static final BizDate MAXYMD = BizDate.MAX_VALID_DATE;

    private static final BizDate MINYMD = BizDate.MIN_VALUE;

    public SetManryoubi() {
        super();
    }

    public BizDate exec(BizDate pKykYmd, int pHhknNen, int pKikan, C_KknsmnKbn pKknsmnKbn) {

        BizDate kikanManryouYmd = null;

        if (pKikan == SYSN) {
            kikanManryouYmd = MAXYMD;
        }
        else if (pKikan == ITIJIBARAI) {
            kikanManryouYmd = MINYMD;
        }
        else if (C_KknsmnKbn.NEN.eq(pKknsmnKbn)) {
            kikanManryouYmd = pKykYmd.addYears(pKikan).getRekijyou();
        }
        else if (C_KknsmnKbn.SAI.eq(pKknsmnKbn)) {
            kikanManryouYmd = pKykYmd.addYears(pKikan - pHhknNen).getRekijyou();
        }
        else if (C_KknsmnKbn.BLNK.eq(pKknsmnKbn)) {
            kikanManryouYmd = null;
        }
        return kikanManryouYmd;
    }
}
