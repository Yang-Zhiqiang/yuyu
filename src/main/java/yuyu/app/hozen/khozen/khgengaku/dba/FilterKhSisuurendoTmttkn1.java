package yuyu.app.hozen.khozen.khgengaku.dba;

import jp.co.slcs.swak.date.BizDateYM;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;

import com.google.common.base.Predicate;

/**
 * 契約保全 契約保全 指数連動積増型年金積立金テーブル用Predicateクラス１
 */
public class FilterKhSisuurendoTmttkn1 implements Predicate<IT_KhSisuurendoTmttkn>{

    BizDateYM tmttkntaisyouym;

    public FilterKhSisuurendoTmttkn1(BizDateYM pTmttkntaisyouym) {
        super();
        tmttkntaisyouym = pTmttkntaisyouym;
    }

    @Override
    public boolean apply(IT_KhSisuurendoTmttkn pKhSisuurendoTmttkn) {
        if (BizDateUtil.compareYm(tmttkntaisyouym, pKhSisuurendoTmttkn.getTmttkntaisyouym()) == BizDateUtil.COMPARE_EQUAL) {
            return true;
        }

        return false;
    }
}
