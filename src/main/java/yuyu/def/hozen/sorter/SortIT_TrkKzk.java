package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_TrkKzk;
import yuyu.def.db.meta.QIT_TrkKzk;
import yuyu.def.hozen.comparator.OrderIT_TrkKzk;

public class SortIT_TrkKzk {

    public List<IT_TrkKzk> OrderIT_TrkKzkByPkAsc(List<IT_TrkKzk> pEntity) {
        List<SortCondition<IT_TrkKzk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_TrkKzk()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TrkKzk()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TrkKzk()).trkkzkkbn, SortOrder.ASC));
        List<IT_TrkKzk> copyList = new ArrayList<IT_TrkKzk>(pEntity);
        Collections.sort(copyList, new OrderIT_TrkKzk(orders));
        return copyList;
    }

    public List<IT_TrkKzk> OrderIT_TrkKzkByPkDesc(List<IT_TrkKzk> pEntity) {
        List<SortCondition<IT_TrkKzk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_TrkKzk()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TrkKzk()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TrkKzk()).trkkzkkbn, SortOrder.DESC));
        List<IT_TrkKzk> copyList = new ArrayList<IT_TrkKzk>(pEntity);
        Collections.sort(copyList, new OrderIT_TrkKzk(orders));
        return copyList;
    }
}
