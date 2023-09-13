package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_MinyuList;
import yuyu.def.db.meta.QIT_MinyuList;
import yuyu.def.hozen.comparator.OrderIT_MinyuList;

public class SortIT_MinyuList {

    public List<IT_MinyuList> OrderIT_MinyuListByPkAsc(List<IT_MinyuList> pEntity) {
        List<SortCondition<IT_MinyuList>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_MinyuList()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_MinyuList()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_MinyuList()).tyouhyouymd, SortOrder.ASC));
        List<IT_MinyuList> copyList = new ArrayList<IT_MinyuList>(pEntity);
        Collections.sort(copyList, new OrderIT_MinyuList(orders));
        return copyList;
    }

    public List<IT_MinyuList> OrderIT_MinyuListByPkDesc(List<IT_MinyuList> pEntity) {
        List<SortCondition<IT_MinyuList>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_MinyuList()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_MinyuList()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_MinyuList()).tyouhyouymd, SortOrder.DESC));
        List<IT_MinyuList> copyList = new ArrayList<IT_MinyuList>(pEntity);
        Collections.sort(copyList, new OrderIT_MinyuList(orders));
        return copyList;
    }

}

