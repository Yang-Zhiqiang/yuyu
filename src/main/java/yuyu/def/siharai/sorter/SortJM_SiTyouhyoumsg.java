package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JM_SiTyouhyoumsg;
import yuyu.def.db.meta.QJM_SiTyouhyoumsg;
import yuyu.def.siharai.comparator.OrderJM_SiTyouhyoumsg;

public class SortJM_SiTyouhyoumsg {

    
    public List<JM_SiTyouhyoumsg> OrderJM_SiTyouhyoumsgByPkAsc(List<JM_SiTyouhyoumsg> pEntity) {
        List<SortCondition<JM_SiTyouhyoumsg>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJM_SiTyouhyoumsg()).bunrui1, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJM_SiTyouhyoumsg()).bunrui2, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJM_SiTyouhyoumsg()).tyouhyoulineno, SortOrder.ASC));
        List<JM_SiTyouhyoumsg> copyList = new ArrayList<JM_SiTyouhyoumsg>(pEntity);
        Collections.sort(copyList, new OrderJM_SiTyouhyoumsg(orders));
        return copyList;
    }

    
    public List<JM_SiTyouhyoumsg> OrderJM_SiTyouhyoumsgByPkDesc(List<JM_SiTyouhyoumsg> pEntity) {
        List<SortCondition<JM_SiTyouhyoumsg>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJM_SiTyouhyoumsg()).bunrui1, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJM_SiTyouhyoumsg()).bunrui2, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJM_SiTyouhyoumsg()).tyouhyoulineno, SortOrder.DESC));
        List<JM_SiTyouhyoumsg> copyList = new ArrayList<JM_SiTyouhyoumsg>(pEntity);
        Collections.sort(copyList, new OrderJM_SiTyouhyoumsg(orders));
        return copyList;
    }

}

