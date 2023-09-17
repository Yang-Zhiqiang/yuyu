package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAS_Sequence;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AS_Sequence;
import yuyu.def.db.meta.QAS_Sequence;

public class SortAS_Sequence {

    public List<AS_Sequence> OrderAS_SequenceByPkAsc(List<AS_Sequence> pEntity) {
        List<SortCondition<AS_Sequence>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAS_Sequence()).id, SortOrder.ASC));
        List<AS_Sequence> copyList = new ArrayList<AS_Sequence>(pEntity);
        Collections.sort(copyList, new OrderAS_Sequence(orders));
        return copyList;
    }

    public List<AS_Sequence> OrderAS_SequenceByPkDesc(List<AS_Sequence> pEntity) {
        List<SortCondition<AS_Sequence>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAS_Sequence()).id, SortOrder.DESC));
        List<AS_Sequence> copyList = new ArrayList<AS_Sequence>(pEntity);
        Collections.sort(copyList, new OrderAS_Sequence(orders));
        return copyList;
    }
}
