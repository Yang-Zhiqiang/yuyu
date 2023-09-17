package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAS_Category;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AS_Category;
import yuyu.def.db.meta.QAS_Category;

public class SortAS_Category {

    public List<AS_Category> OrderAS_CategoryByPkAsc(List<AS_Category> pEntity) {
        List<SortCondition<AS_Category>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAS_Category()).categoryId, SortOrder.ASC));
        List<AS_Category> copyList = new ArrayList<AS_Category>(pEntity);
        Collections.sort(copyList, new OrderAS_Category(orders));
        return copyList;
    }

    public List<AS_Category> OrderAS_CategoryByPkDesc(List<AS_Category> pEntity) {
        List<SortCondition<AS_Category>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAS_Category()).categoryId, SortOrder.DESC));
        List<AS_Category> copyList = new ArrayList<AS_Category>(pEntity);
        Collections.sort(copyList, new OrderAS_Category(orders));
        return copyList;
    }
}
