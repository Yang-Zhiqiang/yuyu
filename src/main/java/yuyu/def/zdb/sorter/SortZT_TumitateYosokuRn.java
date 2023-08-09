package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_TumitateYosokuRn;
import yuyu.def.db.meta.QZT_TumitateYosokuRn;
import yuyu.def.zdb.comparator.OrderZT_TumitateYosokuRn;

public class SortZT_TumitateYosokuRn {

    
    public List<ZT_TumitateYosokuRn> OrderZT_TumitateYosokuRnByPkAsc(List<ZT_TumitateYosokuRn> pEntity) {
        List<SortCondition<ZT_TumitateYosokuRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TumitateYosokuRn()).zrnhknsyukigou, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TumitateYosokuRn()).zrnkeiyakuymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TumitateYosokuRn()).zrntysytymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TumitateYosokuRn()).zrnkyktuukasyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TumitateYosokuRn()).zrnhknkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TumitateYosokuRn()).zrntmttknsyuruikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_TumitateYosokuRn()).zrnsisuukbn, SortOrder.ASC));
        List<ZT_TumitateYosokuRn> copyList = new ArrayList<ZT_TumitateYosokuRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TumitateYosokuRn(orders));
        return copyList;
    }

    
    public List<ZT_TumitateYosokuRn> OrderZT_TumitateYosokuRnByPkDesc(List<ZT_TumitateYosokuRn> pEntity) {
        List<SortCondition<ZT_TumitateYosokuRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TumitateYosokuRn()).zrnhknsyukigou, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TumitateYosokuRn()).zrnkeiyakuymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TumitateYosokuRn()).zrntysytymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TumitateYosokuRn()).zrnkyktuukasyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TumitateYosokuRn()).zrnhknkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TumitateYosokuRn()).zrntmttknsyuruikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_TumitateYosokuRn()).zrnsisuukbn, SortOrder.DESC));
        List<ZT_TumitateYosokuRn> copyList = new ArrayList<ZT_TumitateYosokuRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TumitateYosokuRn(orders));
        return copyList;
    }
}
