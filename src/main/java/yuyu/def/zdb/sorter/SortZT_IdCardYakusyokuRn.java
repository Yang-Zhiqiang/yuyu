package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_IdCardYakusyokuRn;
import yuyu.def.db.meta.QZT_IdCardYakusyokuRn;
import yuyu.def.zdb.comparator.OrderZT_IdCardYakusyokuRn;

public class SortZT_IdCardYakusyokuRn {

    
    public List<ZT_IdCardYakusyokuRn> OrderZT_IdCardYakusyokuRnByPkAsc(List<ZT_IdCardYakusyokuRn> pEntity) {
        List<SortCondition<ZT_IdCardYakusyokuRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_IdCardYakusyokuRn()).zrnidkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_IdCardYakusyokuRn()).zrnidcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_IdCardYakusyokuRn()).zrnyakusyokuhatureiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_IdCardYakusyokuRn()).zrnyakusyokuhatureino, SortOrder.ASC));
        List<ZT_IdCardYakusyokuRn> copyList = new ArrayList<ZT_IdCardYakusyokuRn>(pEntity);
        Collections.sort(copyList, new OrderZT_IdCardYakusyokuRn(orders));
        return copyList;
    }

    
    public List<ZT_IdCardYakusyokuRn> OrderZT_IdCardYakusyokuRnByPkDesc(List<ZT_IdCardYakusyokuRn> pEntity) {
        List<SortCondition<ZT_IdCardYakusyokuRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_IdCardYakusyokuRn()).zrnidkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_IdCardYakusyokuRn()).zrnidcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_IdCardYakusyokuRn()).zrnyakusyokuhatureiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_IdCardYakusyokuRn()).zrnyakusyokuhatureino, SortOrder.DESC));
        List<ZT_IdCardYakusyokuRn> copyList = new ArrayList<ZT_IdCardYakusyokuRn>(pEntity);
        Collections.sort(copyList, new OrderZT_IdCardYakusyokuRn(orders));
        return copyList;
    }
}
