package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KzhuriSyuunouKekkaRn;
import yuyu.def.db.meta.QZT_KzhuriSyuunouKekkaRn;
import yuyu.def.zdb.comparator.OrderZT_KzhuriSyuunouKekkaRn;

public class SortZT_KzhuriSyuunouKekkaRn {

    
    public List<ZT_KzhuriSyuunouKekkaRn> OrderZT_KzhuriSyuunouKekkaRnByPkAsc(List<ZT_KzhuriSyuunouKekkaRn> pEntity) {
        List<SortCondition<ZT_KzhuriSyuunouKekkaRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KzhuriSyuunouKekkaRn()).zrnsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KzhuriSyuunouKekkaRn()).zrnjyuutouym, SortOrder.ASC));
        List<ZT_KzhuriSyuunouKekkaRn> copyList = new ArrayList<ZT_KzhuriSyuunouKekkaRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KzhuriSyuunouKekkaRn(orders));
        return copyList;
    }

    
    public List<ZT_KzhuriSyuunouKekkaRn> OrderZT_KzhuriSyuunouKekkaRnByPkDesc(List<ZT_KzhuriSyuunouKekkaRn> pEntity) {
        List<SortCondition<ZT_KzhuriSyuunouKekkaRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KzhuriSyuunouKekkaRn()).zrnsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KzhuriSyuunouKekkaRn()).zrnjyuutouym, SortOrder.DESC));
        List<ZT_KzhuriSyuunouKekkaRn> copyList = new ArrayList<ZT_KzhuriSyuunouKekkaRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KzhuriSyuunouKekkaRn(orders));
        return copyList;
    }
}
