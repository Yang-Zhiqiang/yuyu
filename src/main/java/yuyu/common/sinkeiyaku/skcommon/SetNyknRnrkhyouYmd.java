package yuyu.common.sinkeiyaku.skcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HrkmnykndatarenmotoKbn;

/**
 * 入金連絡票日付設定クラス。<br />
 * 振込入金データ連携元区分、入金データ連動日に応じた入金連絡票日付を返却する。
 */
public class SetNyknRnrkhyouYmd {

    public SetNyknRnrkhyouYmd() {
        super();
    }

    public BizDate exec(C_HrkmnykndatarenmotoKbn pHrkmNykndataRenmotoKbn, BizDate pNykndataRendouYmd) {
        BizDate nyknRenrakuhyouYmd = null;

        if (pHrkmNykndataRenmotoKbn == null || pNykndataRendouYmd == null) {
            return nyknRenrakuhyouYmd;
        }

        if (pHrkmNykndataRenmotoKbn.eq(C_HrkmnykndatarenmotoKbn.NYKNMEISAI)) {
            nyknRenrakuhyouYmd = pNykndataRendouYmd.addBusinessDays(1);

            return nyknRenrakuhyouYmd;
        }
        else if (pHrkmNykndataRenmotoKbn.eq(C_HrkmnykndatarenmotoKbn.IKKATUTORIKOMI)) {
            return nyknRenrakuhyouYmd;
        }
        else if (pHrkmNykndataRenmotoKbn.eq(C_HrkmnykndatarenmotoKbn.ONLINE)) {
            nyknRenrakuhyouYmd = pNykndataRendouYmd;

            return nyknRenrakuhyouYmd;
        }
        else {
            return nyknRenrakuhyouYmd;
        }
    }

}