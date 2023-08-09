package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SkeisynyptoukeiksnRn;
import yuyu.def.db.meta.QZT_SkeisynyptoukeiksnRn;
import yuyu.def.zdb.comparator.OrderZT_SkeisynyptoukeiksnRn;

public class SortZT_SkeisynyptoukeiksnRn {

    
    public List<ZT_SkeisynyptoukeiksnRn> OrderZT_SkeisynyptoukeiksnRnByPkAsc(List<ZT_SkeisynyptoukeiksnRn> pEntity) {
        List<SortCondition<ZT_SkeisynyptoukeiksnRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkeisynyptoukeiksnRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_SkeisynyptoukeiksnRn> copyList = new ArrayList<ZT_SkeisynyptoukeiksnRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SkeisynyptoukeiksnRn(orders));
        return copyList;
    }

    
    public List<ZT_SkeisynyptoukeiksnRn> OrderZT_SkeisynyptoukeiksnRnByPkDesc(List<ZT_SkeisynyptoukeiksnRn> pEntity) {
        List<SortCondition<ZT_SkeisynyptoukeiksnRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkeisynyptoukeiksnRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_SkeisynyptoukeiksnRn> copyList = new ArrayList<ZT_SkeisynyptoukeiksnRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SkeisynyptoukeiksnRn(orders));
        return copyList;
    }
}
