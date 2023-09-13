package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_DSeisanShrTysySyusei;
import yuyu.def.db.meta.QIT_DSeisanShrTysySyusei;
import yuyu.def.hozen.comparator.OrderIT_DSeisanShrTysySyusei;

public class SortIT_DSeisanShrTysySyusei {

    public List<IT_DSeisanShrTysySyusei> OrderIT_DSeisanShrTysySyuseiByPkAsc(List<IT_DSeisanShrTysySyusei> pEntity) {
        List<SortCondition<IT_DSeisanShrTysySyusei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_DSeisanShrTysySyusei()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_DSeisanShrTysySyusei()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_DSeisanShrTysySyusei()).syoriYmd, SortOrder.ASC));
        List<IT_DSeisanShrTysySyusei> copyList = new ArrayList<IT_DSeisanShrTysySyusei>(pEntity);
        Collections.sort(copyList, new OrderIT_DSeisanShrTysySyusei(orders));
        return copyList;
    }

    public List<IT_DSeisanShrTysySyusei> OrderIT_DSeisanShrTysySyuseiByPkDesc(List<IT_DSeisanShrTysySyusei> pEntity) {
        List<SortCondition<IT_DSeisanShrTysySyusei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_DSeisanShrTysySyusei()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_DSeisanShrTysySyusei()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_DSeisanShrTysySyusei()).syoriYmd, SortOrder.DESC));
        List<IT_DSeisanShrTysySyusei> copyList = new ArrayList<IT_DSeisanShrTysySyusei>(pEntity);
        Collections.sort(copyList, new OrderIT_DSeisanShrTysySyusei(orders));
        return copyList;
    }
}
