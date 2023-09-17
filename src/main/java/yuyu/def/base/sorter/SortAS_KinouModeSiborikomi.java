package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAS_KinouModeSiborikomi;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AS_KinouModeSiborikomi;
import yuyu.def.db.meta.QAS_KinouModeSiborikomi;

public class SortAS_KinouModeSiborikomi {

    public List<AS_KinouModeSiborikomi> OrderAS_KinouModeSiborikomiByPkAsc(List<AS_KinouModeSiborikomi> pEntity) {
        List<SortCondition<AS_KinouModeSiborikomi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAS_KinouModeSiborikomi()).kinouId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAS_KinouModeSiborikomi()).kinouModeId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAS_KinouModeSiborikomi()).siborikomiId, SortOrder.ASC));
        List<AS_KinouModeSiborikomi> copyList = new ArrayList<AS_KinouModeSiborikomi>(pEntity);
        Collections.sort(copyList, new OrderAS_KinouModeSiborikomi(orders));
        return copyList;
    }

    public List<AS_KinouModeSiborikomi> OrderAS_KinouModeSiborikomiByPkDesc(List<AS_KinouModeSiborikomi> pEntity) {
        List<SortCondition<AS_KinouModeSiborikomi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAS_KinouModeSiborikomi()).kinouId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAS_KinouModeSiborikomi()).kinouModeId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAS_KinouModeSiborikomi()).siborikomiId, SortOrder.DESC));
        List<AS_KinouModeSiborikomi> copyList = new ArrayList<AS_KinouModeSiborikomi>(pEntity);
        Collections.sort(copyList, new OrderAS_KinouModeSiborikomi(orders));
        return copyList;
    }
}
