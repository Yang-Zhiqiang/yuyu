package yuyu.def.hozen.predicate;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.db.entity.IT_KhLincSousinData;

import com.google.common.base.Predicate;

/**
 * 契約保全ＬＩＮＣ送信データテーブル用 Predicate<br/>
 * 処理年月日（一致）<br/>
 */
public class FilterKhLincSousinDatasBySyoriYmd implements Predicate <IT_KhLincSousinData> {

    BizDate syoriYmd;

    public FilterKhLincSousinDatasBySyoriYmd(BizDate pSyoriYmd) {
        super();
        syoriYmd = pSyoriYmd;
    }

    @Override
    public boolean apply(IT_KhLincSousinData pKhLincSousinData) {
        if (BizDateUtil.compareYmd(syoriYmd, pKhLincSousinData.getSyoriYmd()) == BizDateUtil.COMPARE_EQUAL) {
            return true;
        }
        return false;
    }
}
