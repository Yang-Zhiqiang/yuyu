package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MW_DsNeugokiHanteiKekkaWk;
import yuyu.def.db.meta.QMW_DsNeugokiHanteiKekkaWk;
import yuyu.def.direct.comparator.OrderMW_DsNeugokiHanteiKekkaWk;

public class SortMW_DsNeugokiHanteiKekkaWk {

    public List<MW_DsNeugokiHanteiKekkaWk> OrderMW_DsNeugokiHanteiKekkaWkByPkAsc(List<MW_DsNeugokiHanteiKekkaWk> pEntity) {
        List<SortCondition<MW_DsNeugokiHanteiKekkaWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMW_DsNeugokiHanteiKekkaWk()).dsdatasakuseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMW_DsNeugokiHanteiKekkaWk()).syono, SortOrder.ASC));
        List<MW_DsNeugokiHanteiKekkaWk> copyList = new ArrayList<MW_DsNeugokiHanteiKekkaWk>(pEntity);
        Collections.sort(copyList, new OrderMW_DsNeugokiHanteiKekkaWk(orders));
        return copyList;
    }

    public List<MW_DsNeugokiHanteiKekkaWk> OrderMW_DsNeugokiHanteiKekkaWkByPkDesc(List<MW_DsNeugokiHanteiKekkaWk> pEntity) {
        List<SortCondition<MW_DsNeugokiHanteiKekkaWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMW_DsNeugokiHanteiKekkaWk()).dsdatasakuseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMW_DsNeugokiHanteiKekkaWk()).syono, SortOrder.DESC));
        List<MW_DsNeugokiHanteiKekkaWk> copyList = new ArrayList<MW_DsNeugokiHanteiKekkaWk>(pEntity);
        Collections.sort(copyList, new OrderMW_DsNeugokiHanteiKekkaWk(orders));
        return copyList;
    }
}
