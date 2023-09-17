package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAS_KinouMode;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.def.db.meta.QAS_KinouMode;

public class SortAS_KinouMode {

    public List<AS_KinouMode> OrderAS_KinouModeByPkAsc(List<AS_KinouMode> pEntity) {
        List<SortCondition<AS_KinouMode>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAS_KinouMode()).kinouId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAS_KinouMode()).kinouModeId, SortOrder.ASC));
        List<AS_KinouMode> copyList = new ArrayList<AS_KinouMode>(pEntity);
        Collections.sort(copyList, new OrderAS_KinouMode(orders));
        return copyList;
    }

    public List<AS_KinouMode> OrderAS_KinouModeByPkDesc(List<AS_KinouMode> pEntity) {
        List<SortCondition<AS_KinouMode>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAS_KinouMode()).kinouId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAS_KinouMode()).kinouModeId, SortOrder.DESC));
        List<AS_KinouMode> copyList = new ArrayList<AS_KinouMode>(pEntity);
        Collections.sort(copyList, new OrderAS_KinouMode(orders));
        return copyList;
    }
}
