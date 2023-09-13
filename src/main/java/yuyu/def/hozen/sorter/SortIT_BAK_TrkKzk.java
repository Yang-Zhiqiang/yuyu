package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_TrkKzk;
import yuyu.def.db.meta.QIT_BAK_TrkKzk;
import yuyu.def.hozen.comparator.OrderIT_BAK_TrkKzk;

public class SortIT_BAK_TrkKzk {

    public List<IT_BAK_TrkKzk> OrderIT_BAK_TrkKzkByPkAsc(List<IT_BAK_TrkKzk> pEntity) {
        List<SortCondition<IT_BAK_TrkKzk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_TrkKzk()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_TrkKzk()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_TrkKzk()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_TrkKzk()).trkkzkkbn, SortOrder.ASC));
        List<IT_BAK_TrkKzk> copyList = new ArrayList<IT_BAK_TrkKzk>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_TrkKzk(orders));
        return copyList;
    }

    public List<IT_BAK_TrkKzk> OrderIT_BAK_TrkKzkByPkDesc(List<IT_BAK_TrkKzk> pEntity) {
        List<SortCondition<IT_BAK_TrkKzk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_TrkKzk()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_TrkKzk()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_TrkKzk()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_TrkKzk()).trkkzkkbn, SortOrder.DESC));
        List<IT_BAK_TrkKzk> copyList = new ArrayList<IT_BAK_TrkKzk>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_TrkKzk(orders));
        return copyList;
    }
}
