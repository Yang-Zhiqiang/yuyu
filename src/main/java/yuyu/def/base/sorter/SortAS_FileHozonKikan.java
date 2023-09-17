package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAS_FileHozonKikan;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AS_FileHozonKikan;
import yuyu.def.db.meta.QAS_FileHozonKikan;

public class SortAS_FileHozonKikan {

    public List<AS_FileHozonKikan> OrderAS_FileHozonKikanByPkAsc(List<AS_FileHozonKikan> pEntity) {
        List<SortCondition<AS_FileHozonKikan>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAS_FileHozonKikan()).fileSyuruiCd, SortOrder.ASC));
        List<AS_FileHozonKikan> copyList = new ArrayList<AS_FileHozonKikan>(pEntity);
        Collections.sort(copyList, new OrderAS_FileHozonKikan(orders));
        return copyList;
    }

    public List<AS_FileHozonKikan> OrderAS_FileHozonKikanByPkDesc(List<AS_FileHozonKikan> pEntity) {
        List<SortCondition<AS_FileHozonKikan>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAS_FileHozonKikan()).fileSyuruiCd, SortOrder.DESC));
        List<AS_FileHozonKikan> copyList = new ArrayList<AS_FileHozonKikan>(pEntity);
        Collections.sort(copyList, new OrderAS_FileHozonKikan(orders));
        return copyList;
    }
}
