package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_JidouSyuunouMeisai;
import yuyu.def.db.meta.QHT_JidouSyuunouMeisai;
import yuyu.def.sinkeiyaku.comparator.OrderHT_JidouSyuunouMeisai;

public class SortHT_JidouSyuunouMeisai {

    
    public List<HT_JidouSyuunouMeisai> OrderHT_JidouSyuunouMeisaiByPkAsc(List<HT_JidouSyuunouMeisai> pEntity) {
        List<SortCondition<HT_JidouSyuunouMeisai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_JidouSyuunouMeisai()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_JidouSyuunouMeisai()).kessankbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_JidouSyuunouMeisai()).rstuukasyu, SortOrder.ASC));
        List<HT_JidouSyuunouMeisai> copyList = new ArrayList<HT_JidouSyuunouMeisai>(pEntity);
        Collections.sort(copyList, new OrderHT_JidouSyuunouMeisai(orders));
        return copyList;
    }

    
    public List<HT_JidouSyuunouMeisai> OrderHT_JidouSyuunouMeisaiByPkDesc(List<HT_JidouSyuunouMeisai> pEntity) {
        List<SortCondition<HT_JidouSyuunouMeisai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_JidouSyuunouMeisai()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_JidouSyuunouMeisai()).kessankbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_JidouSyuunouMeisai()).rstuukasyu, SortOrder.DESC));
        List<HT_JidouSyuunouMeisai> copyList = new ArrayList<HT_JidouSyuunouMeisai>(pEntity);
        Collections.sort(copyList, new OrderHT_JidouSyuunouMeisai(orders));
        return copyList;
    }

}

