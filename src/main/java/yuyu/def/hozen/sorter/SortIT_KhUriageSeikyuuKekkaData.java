package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhUriageSeikyuuKekkaData;
import yuyu.def.db.meta.QIT_KhUriageSeikyuuKekkaData;
import yuyu.def.hozen.comparator.OrderIT_KhUriageSeikyuuKekkaData;

public class SortIT_KhUriageSeikyuuKekkaData {

    public List<IT_KhUriageSeikyuuKekkaData> OrderIT_KhUriageSeikyuuKekkaDataByPkAsc(List<IT_KhUriageSeikyuuKekkaData> pEntity) {
        List<SortCondition<IT_KhUriageSeikyuuKekkaData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhUriageSeikyuuKekkaData()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhUriageSeikyuuKekkaData()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhUriageSeikyuuKekkaData()).creditkessaiyouno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhUriageSeikyuuKekkaData()).uriagenengappi, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhUriageSeikyuuKekkaData()).renno3keta, SortOrder.ASC));
        List<IT_KhUriageSeikyuuKekkaData> copyList = new ArrayList<IT_KhUriageSeikyuuKekkaData>(pEntity);
        Collections.sort(copyList, new OrderIT_KhUriageSeikyuuKekkaData(orders));
        return copyList;
    }

    public List<IT_KhUriageSeikyuuKekkaData> OrderIT_KhUriageSeikyuuKekkaDataByPkDesc(List<IT_KhUriageSeikyuuKekkaData> pEntity) {
        List<SortCondition<IT_KhUriageSeikyuuKekkaData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhUriageSeikyuuKekkaData()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhUriageSeikyuuKekkaData()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhUriageSeikyuuKekkaData()).creditkessaiyouno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhUriageSeikyuuKekkaData()).uriagenengappi, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhUriageSeikyuuKekkaData()).renno3keta, SortOrder.DESC));
        List<IT_KhUriageSeikyuuKekkaData> copyList = new ArrayList<IT_KhUriageSeikyuuKekkaData>(pEntity);
        Collections.sort(copyList, new OrderIT_KhUriageSeikyuuKekkaData(orders));
        return copyList;
    }
}
