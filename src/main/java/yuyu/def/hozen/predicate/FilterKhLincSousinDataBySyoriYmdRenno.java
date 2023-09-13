package yuyu.def.hozen.predicate;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.db.entity.IT_KhLincSousinData;

import com.google.common.base.Predicate;

/**
 * 契約保全ＬＩＮＣ送信データテーブル用 Predicate<br/>
 * 処理年月日、連番（一致）
 */
public class FilterKhLincSousinDataBySyoriYmdRenno implements Predicate<IT_KhLincSousinData> {

    BizDate syoriYmd;
    Integer renno;

    public FilterKhLincSousinDataBySyoriYmdRenno(BizDate pSyoriYmd, Integer pRenno) {
        super();
        syoriYmd = pSyoriYmd;
        renno = pRenno;
    }

    @Override
    public boolean apply(IT_KhLincSousinData pKhLincSousinData) {
        if (BizDateUtil.compareYmd(syoriYmd, pKhLincSousinData.getSyoriYmd()) == BizDateUtil.COMPARE_EQUAL &&
            renno == pKhLincSousinData.getRenno()) {
            return true;
        }
        return false;
    }

}
