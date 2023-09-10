package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_SyouhnZokusei;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_SyouhnTokujyouRireki;
import yuyu.def.db.meta.QBM_SyouhnZokusei;
import yuyu.def.db.meta.QHT_SyouhnTokujyouRireki;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SyouhnTokujyouRireki;

public class SortHT_SyouhnTokujyouRireki {

    
    public List<HT_SyouhnTokujyouRireki> OrderHT_SyouhnTokujyouRirekiByPkAsc(List<HT_SyouhnTokujyouRireki> pEntity) {
        List<SortCondition<HT_SyouhnTokujyouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SyouhnTokujyouRireki()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SyouhnTokujyouRireki()).dakuhiktrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SyouhnTokujyouRireki()).syouhncd, SortOrder.ASC));
        List<HT_SyouhnTokujyouRireki> copyList = new ArrayList<HT_SyouhnTokujyouRireki>(pEntity);
        Collections.sort(copyList, new OrderHT_SyouhnTokujyouRireki(orders));
        return copyList;
    }

    
    public List<HT_SyouhnTokujyouRireki> OrderHT_SyouhnTokujyouRirekiByPkDesc(List<HT_SyouhnTokujyouRireki> pEntity) {
        List<SortCondition<HT_SyouhnTokujyouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SyouhnTokujyouRireki()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SyouhnTokujyouRireki()).dakuhiktrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SyouhnTokujyouRireki()).syouhncd, SortOrder.DESC));
        List<HT_SyouhnTokujyouRireki> copyList = new ArrayList<HT_SyouhnTokujyouRireki>(pEntity);
        Collections.sort(copyList, new OrderHT_SyouhnTokujyouRireki(orders));
        return copyList;
    }

    
    public List<HT_SyouhnTokujyouRireki> OrderHT_SyouhnTokujyouRirekiByBM_SyouhnZokuseiSyutkkbnSyohnsortnoAsc(List<HT_SyouhnTokujyouRireki> pEntity) {
        List<HT_SyouhnTokujyouRireki> copyList = new ArrayList<HT_SyouhnTokujyouRireki>(pEntity);
        Collections.sort(copyList, new OrderHT_SyouhnTokujyouRirekiByBM_SyouhnZokuseiSyutkkbnSyohnsortno());
        return copyList;
    }

    
    class OrderHT_SyouhnTokujyouRirekiByBM_SyouhnZokuseiSyutkkbnSyohnsortno implements Comparator<HT_SyouhnTokujyouRireki> {
        @Override
        public int compare(HT_SyouhnTokujyouRireki o1, HT_SyouhnTokujyouRireki o2) {
            if(o1 == null || o2==null ) {
                return compareAsc(o1,o2);
            }
            List<SortCondition<BM_SyouhnZokusei>> orders = new ArrayList<>();
            orders.add(new SortCondition<>((new QBM_SyouhnZokusei()).syutkkbn, SortOrder.ASC));
            orders.add(new SortCondition<>((new QBM_SyouhnZokusei()).syohnsortno, SortOrder.ASC));
            return new OrderBM_SyouhnZokusei(orders).compare(o1.getSyouhnZokusei(), o2.getSyouhnZokusei());
        }
    }

    
    static int compareAsc(Object o1,Object o2){
        
        if(o1 == null && o2 == null){
            return 0;
        }else if(o1 == null){
            return 1;
        }else if(o2 == null){
            return -1;
        }
        return 0;
    }

}

