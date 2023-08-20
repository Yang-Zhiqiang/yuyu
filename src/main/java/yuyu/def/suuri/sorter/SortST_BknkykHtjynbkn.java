package yuyu.def.suuri.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ST_BknkykHtjynbkn;
import yuyu.def.db.meta.QST_BknkykHtjynbkn;
import yuyu.def.suuri.comparator.OrderST_BknkykHtjynbkn;

public class SortST_BknkykHtjynbkn {

    
    public List<ST_BknkykHtjynbkn> OrderST_BknkykHtjynbknByPkAsc(List<ST_BknkykHtjynbkn> pEntity) {
        List<SortCondition<ST_BknkykHtjynbkn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QST_BknkykHtjynbkn()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_BknkykHtjynbkn()).kakutyoujobcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_BknkykHtjynbkn()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_BknkykHtjynbkn()).srkijyunym, SortOrder.ASC));
        List<ST_BknkykHtjynbkn> copyList = new ArrayList<ST_BknkykHtjynbkn>(pEntity);
        Collections.sort(copyList, new OrderST_BknkykHtjynbkn(orders));
        return copyList;
    }

    
    public List<ST_BknkykHtjynbkn> OrderST_BknkykHtjynbknByPkDesc(List<ST_BknkykHtjynbkn> pEntity) {
        List<SortCondition<ST_BknkykHtjynbkn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QST_BknkykHtjynbkn()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_BknkykHtjynbkn()).kakutyoujobcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_BknkykHtjynbkn()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_BknkykHtjynbkn()).srkijyunym, SortOrder.DESC));
        List<ST_BknkykHtjynbkn> copyList = new ArrayList<ST_BknkykHtjynbkn>(pEntity);
        Collections.sort(copyList, new OrderST_BknkykHtjynbkn(orders));
        return copyList;
    }
}
