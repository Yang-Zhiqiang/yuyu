package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_TRDattai;
import yuyu.def.db.meta.QIT_TRDattai;
import yuyu.def.hozen.comparator.OrderIT_TRDattai;

public class SortIT_TRDattai {

    public List<IT_TRDattai> OrderIT_TRDattaiByPkAsc(List<IT_TRDattai> pEntity) {
        List<SortCondition<IT_TRDattai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_TRDattai()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TRDattai()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TRDattai()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TRDattai()).dattaitrrenno, SortOrder.ASC));
        List<IT_TRDattai> copyList = new ArrayList<IT_TRDattai>(pEntity);
        Collections.sort(copyList, new OrderIT_TRDattai(orders));
        return copyList;
    }

    public List<IT_TRDattai> OrderIT_TRDattaiByPkDesc(List<IT_TRDattai> pEntity) {
        List<SortCondition<IT_TRDattai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_TRDattai()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TRDattai()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TRDattai()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TRDattai()).dattaitrrenno, SortOrder.DESC));
        List<IT_TRDattai> copyList = new ArrayList<IT_TRDattai>(pEntity);
        Collections.sort(copyList, new OrderIT_TRDattai(orders));
        return copyList;
    }
}
