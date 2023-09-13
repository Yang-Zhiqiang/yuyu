package yuyu.def.direct.predicate;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.MT_DsHaisinErrorList;

import com.google.common.base.Predicate;

/**
 * ＤＳ配信エラーリストテーブル用 Predicate<br/>
 * ＤＳデータ作成日<br/>
 */
public class FilterDsHaisinErrorListByDsdatasakuseiymd implements Predicate<MT_DsHaisinErrorList>{

    BizDate dsdatasakuseiymd;

    public FilterDsHaisinErrorListByDsdatasakuseiymd(BizDate pDsdatasakuseiymd) {

        super();

        dsdatasakuseiymd = pDsdatasakuseiymd;
    }

    @Override
    public boolean apply(MT_DsHaisinErrorList pDsHaisinErrorList) {

        if (dsdatasakuseiymd.compareTo(pDsHaisinErrorList.getDsdatasakuseiymd()) == 0) {

            return true;
        }

        return false;
    }
}
