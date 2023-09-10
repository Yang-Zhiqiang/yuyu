package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_JidouSyuunouMeisai2;
import yuyu.def.db.meta.QHT_JidouSyuunouMeisai2;
import yuyu.def.sinkeiyaku.comparator.OrderHT_JidouSyuunouMeisai2;

public class SortHT_JidouSyuunouMeisai2 {

    
    public List<HT_JidouSyuunouMeisai2> OrderHT_JidouSyuunouMeisai2ByPkAsc(List<HT_JidouSyuunouMeisai2> pEntity) {
        List<SortCondition<HT_JidouSyuunouMeisai2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_JidouSyuunouMeisai2()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_JidouSyuunouMeisai2()).kessankbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_JidouSyuunouMeisai2()).rstuukasyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_JidouSyuunouMeisai2()).nyktyhyoutkbn, SortOrder.ASC));
        List<HT_JidouSyuunouMeisai2> copyList = new ArrayList<HT_JidouSyuunouMeisai2>(pEntity);
        Collections.sort(copyList, new OrderHT_JidouSyuunouMeisai2(orders));
        return copyList;
    }

    
    public List<HT_JidouSyuunouMeisai2> OrderHT_JidouSyuunouMeisai2ByPkDesc(List<HT_JidouSyuunouMeisai2> pEntity) {
        List<SortCondition<HT_JidouSyuunouMeisai2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_JidouSyuunouMeisai2()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_JidouSyuunouMeisai2()).kessankbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_JidouSyuunouMeisai2()).rstuukasyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_JidouSyuunouMeisai2()).nyktyhyoutkbn, SortOrder.DESC));
        List<HT_JidouSyuunouMeisai2> copyList = new ArrayList<HT_JidouSyuunouMeisai2>(pEntity);
        Collections.sort(copyList, new OrderHT_JidouSyuunouMeisai2(orders));
        return copyList;
    }
}
