package yuyu.def.hozen.predicate;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.db.entity.IT_KhHubiDetail;

import com.google.common.base.Predicate;

/**
 * 契約保全不備テーブル用 Predicate<br />
 * 発信日（一致）、発信先区分（一致）<br />
 */
public class FilterKhHubiDetailsByHasinymdHassinsakikbn implements Predicate<IT_KhHubiDetail> {

    BizDate hasinymd;
    C_HassinsakiKbn hassinsakikbn;

    public FilterKhHubiDetailsByHasinymdHassinsakikbn(BizDate pHasinymd, C_HassinsakiKbn pHassinsakikbn) {

        super();

        hasinymd = pHasinymd;
        hassinsakikbn = pHassinsakikbn;
    }

    @Override
    public boolean apply(IT_KhHubiDetail pKhHubiDetail) {

        if (hasinymd.equals(pKhHubiDetail.getHasinymd()) && hassinsakikbn.eq(pKhHubiDetail.getHassinsakikbn())) {

            return true;
        }

        return false;
    }
}