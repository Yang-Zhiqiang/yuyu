package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_TmttHaitoukinMeisaiRn;
import yuyu.def.db.meta.QZT_TmttHaitoukinMeisaiRn;
import yuyu.def.zdb.comparator.OrderZT_TmttHaitoukinMeisaiRn;

public class SortZT_TmttHaitoukinMeisaiRn {

    
    public List<ZT_TmttHaitoukinMeisaiRn> OrderZT_TmttHaitoukinMeisaiRnByPkAsc(List<ZT_TmttHaitoukinMeisaiRn> pEntity) {
        List<SortCondition<ZT_TmttHaitoukinMeisaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TmttHaitoukinMeisaiRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_TmttHaitoukinMeisaiRn> copyList = new ArrayList<ZT_TmttHaitoukinMeisaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TmttHaitoukinMeisaiRn(orders));
        return copyList;
    }

    
    public List<ZT_TmttHaitoukinMeisaiRn> OrderZT_TmttHaitoukinMeisaiRnByPkDesc(List<ZT_TmttHaitoukinMeisaiRn> pEntity) {
        List<SortCondition<ZT_TmttHaitoukinMeisaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_TmttHaitoukinMeisaiRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_TmttHaitoukinMeisaiRn> copyList = new ArrayList<ZT_TmttHaitoukinMeisaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_TmttHaitoukinMeisaiRn(orders));
        return copyList;
    }
}
