package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_RinjiKadouTaisyoSosiki;
import yuyu.def.db.meta.QAT_RinjiKadouTaisyoSosiki;
import yuyu.def.zdb.comparator.OrderAT_RinjiKadouTaisyoSosiki;

public class SortAT_RinjiKadouTaisyoSosiki {

    
    public List<AT_RinjiKadouTaisyoSosiki> OrderAT_RinjiKadouTaisyoSosikiByPkAsc(List<AT_RinjiKadouTaisyoSosiki> pEntity) {
        List<SortCondition<AT_RinjiKadouTaisyoSosiki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_RinjiKadouTaisyoSosiki()).kadouSosikiCd, SortOrder.ASC));
        List<AT_RinjiKadouTaisyoSosiki> copyList = new ArrayList<AT_RinjiKadouTaisyoSosiki>(pEntity);
        Collections.sort(copyList, new OrderAT_RinjiKadouTaisyoSosiki(orders));
        return copyList;
    }

    
    public List<AT_RinjiKadouTaisyoSosiki> OrderAT_RinjiKadouTaisyoSosikiByPkDesc(List<AT_RinjiKadouTaisyoSosiki> pEntity) {
        List<SortCondition<AT_RinjiKadouTaisyoSosiki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_RinjiKadouTaisyoSosiki()).kadouSosikiCd, SortOrder.DESC));
        List<AT_RinjiKadouTaisyoSosiki> copyList = new ArrayList<AT_RinjiKadouTaisyoSosiki>(pEntity);
        Collections.sort(copyList, new OrderAT_RinjiKadouTaisyoSosiki(orders));
        return copyList;
    }
}
