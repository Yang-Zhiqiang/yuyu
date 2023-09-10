package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_SyouhnZokusei;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_SyouhnTokujyou;
import yuyu.def.db.meta.QBM_SyouhnZokusei;
import yuyu.def.db.meta.QHT_SyouhnTokujyou;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SyouhnTokujyou;

public class SortHT_SyouhnTokujyou {

    
    public List<HT_SyouhnTokujyou> OrderHT_SyouhnTokujyouByPkAsc(List<HT_SyouhnTokujyou> pEntity) {
        List<SortCondition<HT_SyouhnTokujyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SyouhnTokujyou()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SyouhnTokujyou()).syouhncd, SortOrder.ASC));
        List<HT_SyouhnTokujyou> copyList = new ArrayList<HT_SyouhnTokujyou>(pEntity);
        Collections.sort(copyList, new OrderHT_SyouhnTokujyou(orders));
        return copyList;
    }

    
    public List<HT_SyouhnTokujyou> OrderHT_SyouhnTokujyouByPkDesc(List<HT_SyouhnTokujyou> pEntity) {
        List<SortCondition<HT_SyouhnTokujyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SyouhnTokujyou()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SyouhnTokujyou()).syouhncd, SortOrder.DESC));
        List<HT_SyouhnTokujyou> copyList = new ArrayList<HT_SyouhnTokujyou>(pEntity);
        Collections.sort(copyList, new OrderHT_SyouhnTokujyou(orders));
        return copyList;
    }

    
    public List<HT_SyouhnTokujyou> OrderHT_SyouhnTokujyouByBM_SyouhnZokuseiSyohnsortnoAsc(List<HT_SyouhnTokujyou> pEntity) {
        List<HT_SyouhnTokujyou> copyList = new ArrayList<HT_SyouhnTokujyou>(pEntity);
        Collections.sort(copyList, new OrderHT_SyouhnTokujyouByBM_SyouhnZokuseiSyohnsortno());
        return copyList;
    }

    
    class OrderHT_SyouhnTokujyouByBM_SyouhnZokuseiSyohnsortno implements Comparator<HT_SyouhnTokujyou> {
        @Override
        public int compare(HT_SyouhnTokujyou o1, HT_SyouhnTokujyou o2) {
            if(o1 == null || o2==null ) {
                return compareAsc(o1,o2);
            }
            List<SortCondition<BM_SyouhnZokusei>> orders = new ArrayList<>();
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

