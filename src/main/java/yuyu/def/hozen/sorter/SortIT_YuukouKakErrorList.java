package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_YuukouKakErrorList;
import yuyu.def.db.meta.QIT_YuukouKakErrorList;
import yuyu.def.hozen.comparator.OrderIT_YuukouKakErrorList;

public class SortIT_YuukouKakErrorList {

    public List<IT_YuukouKakErrorList> OrderIT_YuukouKakErrorListByPkAsc(List<IT_YuukouKakErrorList> pEntity) {
        List<SortCondition<IT_YuukouKakErrorList>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_YuukouKakErrorList()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_YuukouKakErrorList()).creditkessaiyouno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_YuukouKakErrorList()).syoriym, SortOrder.ASC));
        List<IT_YuukouKakErrorList> copyList = new ArrayList<IT_YuukouKakErrorList>(pEntity);
        Collections.sort(copyList, new OrderIT_YuukouKakErrorList(orders));
        return copyList;
    }

    public List<IT_YuukouKakErrorList> OrderIT_YuukouKakErrorListByPkDesc(List<IT_YuukouKakErrorList> pEntity) {
        List<SortCondition<IT_YuukouKakErrorList>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_YuukouKakErrorList()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_YuukouKakErrorList()).creditkessaiyouno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_YuukouKakErrorList()).syoriym, SortOrder.DESC));
        List<IT_YuukouKakErrorList> copyList = new ArrayList<IT_YuukouKakErrorList>(pEntity);
        Collections.sort(copyList, new OrderIT_YuukouKakErrorList(orders));
        return copyList;
    }
}
