package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IW_KhKzkPYokuJyuutouYoteiWk;
import yuyu.def.db.meta.QIW_KhKzkPYokuJyuutouYoteiWk;
import yuyu.def.hozen.comparator.OrderIW_KhKzkPYokuJyuutouYoteiWk;

public class SortIW_KhKzkPYokuJyuutouYoteiWk {

    public List<IW_KhKzkPYokuJyuutouYoteiWk> OrderIW_KhKzkPYokuJyuutouYoteiWkByPkAsc(List<IW_KhKzkPYokuJyuutouYoteiWk> pEntity) {
        List<SortCondition<IW_KhKzkPYokuJyuutouYoteiWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhKzkPYokuJyuutouYoteiWk()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIW_KhKzkPYokuJyuutouYoteiWk()).syono, SortOrder.ASC));
        List<IW_KhKzkPYokuJyuutouYoteiWk> copyList = new ArrayList<IW_KhKzkPYokuJyuutouYoteiWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhKzkPYokuJyuutouYoteiWk(orders));
        return copyList;
    }

    public List<IW_KhKzkPYokuJyuutouYoteiWk> OrderIW_KhKzkPYokuJyuutouYoteiWkByPkDesc(List<IW_KhKzkPYokuJyuutouYoteiWk> pEntity) {
        List<SortCondition<IW_KhKzkPYokuJyuutouYoteiWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIW_KhKzkPYokuJyuutouYoteiWk()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIW_KhKzkPYokuJyuutouYoteiWk()).syono, SortOrder.DESC));
        List<IW_KhKzkPYokuJyuutouYoteiWk> copyList = new ArrayList<IW_KhKzkPYokuJyuutouYoteiWk>(pEntity);
        Collections.sort(copyList, new OrderIW_KhKzkPYokuJyuutouYoteiWk(orders));
        return copyList;
    }
}
