package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_UriageSeikyuuKkErrorList;
import yuyu.def.db.meta.QIT_UriageSeikyuuKkErrorList;
import yuyu.def.hozen.comparator.OrderIT_UriageSeikyuuKkErrorList;

public class SortIT_UriageSeikyuuKkErrorList {

    public List<IT_UriageSeikyuuKkErrorList> OrderIT_UriageSeikyuuKkErrorListByPkAsc(List<IT_UriageSeikyuuKkErrorList> pEntity) {
        List<SortCondition<IT_UriageSeikyuuKkErrorList>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_UriageSeikyuuKkErrorList()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_UriageSeikyuuKkErrorList()).creditkessaiyouno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_UriageSeikyuuKkErrorList()).uriagenengappi, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_UriageSeikyuuKkErrorList()).renno3keta, SortOrder.ASC));
        List<IT_UriageSeikyuuKkErrorList> copyList = new ArrayList<IT_UriageSeikyuuKkErrorList>(pEntity);
        Collections.sort(copyList, new OrderIT_UriageSeikyuuKkErrorList(orders));
        return copyList;
    }

    public List<IT_UriageSeikyuuKkErrorList> OrderIT_UriageSeikyuuKkErrorListByPkDesc(List<IT_UriageSeikyuuKkErrorList> pEntity) {
        List<SortCondition<IT_UriageSeikyuuKkErrorList>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_UriageSeikyuuKkErrorList()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_UriageSeikyuuKkErrorList()).creditkessaiyouno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_UriageSeikyuuKkErrorList()).uriagenengappi, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_UriageSeikyuuKkErrorList()).renno3keta, SortOrder.DESC));
        List<IT_UriageSeikyuuKkErrorList> copyList = new ArrayList<IT_UriageSeikyuuKkErrorList>(pEntity);
        Collections.sort(copyList, new OrderIT_UriageSeikyuuKkErrorList(orders));
        return copyList;
    }
}
