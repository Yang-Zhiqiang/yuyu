package yuyu.common.hozen.khcommon.dba4credituriageseikyuudatasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_UriageSeikyuuData;
import yuyu.def.db.meta.QIT_UriageSeikyuuData;
import yuyu.def.hozen.comparator.OrderIT_UriageSeikyuuData;

/**
 * Sorterクラス
 */
public class SortUriageSeikyuuData {

    public List<IT_UriageSeikyuuData> OrderIT_UriageSeikyuuData(List<IT_UriageSeikyuuData> pEntity) {
        List<SortCondition<IT_UriageSeikyuuData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_UriageSeikyuuData()).recordno, SortOrder.DESC));
        List<IT_UriageSeikyuuData> copyList = new ArrayList<IT_UriageSeikyuuData>(pEntity);
        Collections.sort(copyList, new OrderIT_UriageSeikyuuData(orders));
        return copyList;
    }
}