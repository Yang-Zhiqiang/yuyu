package yuyu.def.direct.predicate;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.MT_DsMailHaisinRireki;

import com.google.common.base.Predicate;
/**
 * ＤＳメール配信履歴テーブル用 Predicate<br/>
 * ＤＳデータ作成日<br/>
 */
public class FilterDsMailHaisinRirekiByDsdatasakuseiymd implements Predicate<MT_DsMailHaisinRireki> {
    BizDate dsdatasakuseiymd;

    public FilterDsMailHaisinRirekiByDsdatasakuseiymd(BizDate pDsdatasakuseiymd) {

        super();

        dsdatasakuseiymd = pDsdatasakuseiymd;
    }

    @Override
    public boolean apply(MT_DsMailHaisinRireki pDsMailHaisinRireki) {

        if (dsdatasakuseiymd.compareTo(pDsMailHaisinRireki.getDsdatasakuseiymd()) == 0) {

            return true;
        }

        return false;
    }
}
