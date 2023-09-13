package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_SeihowebMizuhoMinyuuDtl;
import yuyu.def.db.meta.QIT_SeihowebMizuhoMinyuuDtl;
import yuyu.def.hozen.comparator.OrderIT_SeihowebMizuhoMinyuuDtl;

public class SortIT_SeihowebMizuhoMinyuuDtl {

    public List<IT_SeihowebMizuhoMinyuuDtl> OrderIT_SeihowebMizuhoMinyuuDtlByPkAsc(List<IT_SeihowebMizuhoMinyuuDtl> pEntity) {
        List<SortCondition<IT_SeihowebMizuhoMinyuuDtl>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_SeihowebMizuhoMinyuuDtl()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SeihowebMizuhoMinyuuDtl()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SeihowebMizuhoMinyuuDtl()).drtencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SeihowebMizuhoMinyuuDtl()).bosyuucd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SeihowebMizuhoMinyuuDtl()).syoriym, SortOrder.ASC));
        List<IT_SeihowebMizuhoMinyuuDtl> copyList = new ArrayList<IT_SeihowebMizuhoMinyuuDtl>(pEntity);
        Collections.sort(copyList, new OrderIT_SeihowebMizuhoMinyuuDtl(orders));
        return copyList;
    }

    public List<IT_SeihowebMizuhoMinyuuDtl> OrderIT_SeihowebMizuhoMinyuuDtlByPkDesc(List<IT_SeihowebMizuhoMinyuuDtl> pEntity) {
        List<SortCondition<IT_SeihowebMizuhoMinyuuDtl>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_SeihowebMizuhoMinyuuDtl()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SeihowebMizuhoMinyuuDtl()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SeihowebMizuhoMinyuuDtl()).drtencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SeihowebMizuhoMinyuuDtl()).bosyuucd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SeihowebMizuhoMinyuuDtl()).syoriym, SortOrder.DESC));
        List<IT_SeihowebMizuhoMinyuuDtl> copyList = new ArrayList<IT_SeihowebMizuhoMinyuuDtl>(pEntity);
        Collections.sort(copyList, new OrderIT_SeihowebMizuhoMinyuuDtl(orders));
        return copyList;
    }
}
