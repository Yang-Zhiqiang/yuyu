package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_UriageSeikyuuData;
import yuyu.def.db.meta.QIT_BAK_UriageSeikyuuData;
import yuyu.def.hozen.comparator.OrderIT_BAK_UriageSeikyuuData;

public class SortIT_BAK_UriageSeikyuuData {

    public List<IT_BAK_UriageSeikyuuData> OrderIT_BAK_UriageSeikyuuDataByPkAsc(List<IT_BAK_UriageSeikyuuData> pEntity) {
        List<SortCondition<IT_BAK_UriageSeikyuuData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_UriageSeikyuuData()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_UriageSeikyuuData()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_UriageSeikyuuData()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_UriageSeikyuuData()).creditkessaiyouno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_UriageSeikyuuData()).uriagenengappi, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_UriageSeikyuuData()).renno3keta, SortOrder.ASC));
        List<IT_BAK_UriageSeikyuuData> copyList = new ArrayList<IT_BAK_UriageSeikyuuData>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_UriageSeikyuuData(orders));
        return copyList;
    }

    public List<IT_BAK_UriageSeikyuuData> OrderIT_BAK_UriageSeikyuuDataByPkDesc(List<IT_BAK_UriageSeikyuuData> pEntity) {
        List<SortCondition<IT_BAK_UriageSeikyuuData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_UriageSeikyuuData()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_UriageSeikyuuData()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_UriageSeikyuuData()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_UriageSeikyuuData()).creditkessaiyouno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_UriageSeikyuuData()).uriagenengappi, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_UriageSeikyuuData()).renno3keta, SortOrder.DESC));
        List<IT_BAK_UriageSeikyuuData> copyList = new ArrayList<IT_BAK_UriageSeikyuuData>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_UriageSeikyuuData(orders));
        return copyList;
    }
}
