package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_UriageSeikyuuData;
import yuyu.def.db.meta.QIT_UriageSeikyuuData;
import yuyu.def.hozen.comparator.OrderIT_UriageSeikyuuData;

public class SortIT_UriageSeikyuuData {

    public List<IT_UriageSeikyuuData> OrderIT_UriageSeikyuuDataByPkAsc(List<IT_UriageSeikyuuData> pEntity) {
        List<SortCondition<IT_UriageSeikyuuData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_UriageSeikyuuData()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_UriageSeikyuuData()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_UriageSeikyuuData()).creditkessaiyouno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_UriageSeikyuuData()).uriagenengappi, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_UriageSeikyuuData()).renno3keta, SortOrder.ASC));
        List<IT_UriageSeikyuuData> copyList = new ArrayList<IT_UriageSeikyuuData>(pEntity);
        Collections.sort(copyList, new OrderIT_UriageSeikyuuData(orders));
        return copyList;
    }

    public List<IT_UriageSeikyuuData> OrderIT_UriageSeikyuuDataByPkDesc(List<IT_UriageSeikyuuData> pEntity) {
        List<SortCondition<IT_UriageSeikyuuData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_UriageSeikyuuData()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_UriageSeikyuuData()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_UriageSeikyuuData()).creditkessaiyouno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_UriageSeikyuuData()).uriagenengappi, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_UriageSeikyuuData()).renno3keta, SortOrder.DESC));
        List<IT_UriageSeikyuuData> copyList = new ArrayList<IT_UriageSeikyuuData>(pEntity);
        Collections.sort(copyList, new OrderIT_UriageSeikyuuData(orders));
        return copyList;
    }
}
