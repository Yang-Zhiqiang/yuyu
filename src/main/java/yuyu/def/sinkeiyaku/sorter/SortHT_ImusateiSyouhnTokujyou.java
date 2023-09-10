package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_SyouhnZokusei;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_ImusateiSyouhnTokujyou;
import yuyu.def.db.meta.QBM_SyouhnZokusei;
import yuyu.def.db.meta.QHT_ImusateiSyouhnTokujyou;
import yuyu.def.sinkeiyaku.comparator.OrderHT_ImusateiSyouhnTokujyou;

public class SortHT_ImusateiSyouhnTokujyou {

    
    public List<HT_ImusateiSyouhnTokujyou> OrderHT_ImusateiSyouhnTokujyouByPkAsc(List<HT_ImusateiSyouhnTokujyou> pEntity) {
        List<SortCondition<HT_ImusateiSyouhnTokujyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_ImusateiSyouhnTokujyou()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_ImusateiSyouhnTokujyou()).renno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_ImusateiSyouhnTokujyou()).syouhncd, SortOrder.ASC));
        List<HT_ImusateiSyouhnTokujyou> copyList = new ArrayList<HT_ImusateiSyouhnTokujyou>(pEntity);
        Collections.sort(copyList, new OrderHT_ImusateiSyouhnTokujyou(orders));
        return copyList;
    }

    
    public List<HT_ImusateiSyouhnTokujyou> OrderHT_ImusateiSyouhnTokujyouByPkDesc(List<HT_ImusateiSyouhnTokujyou> pEntity) {
        List<SortCondition<HT_ImusateiSyouhnTokujyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_ImusateiSyouhnTokujyou()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_ImusateiSyouhnTokujyou()).renno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_ImusateiSyouhnTokujyou()).syouhncd, SortOrder.DESC));
        List<HT_ImusateiSyouhnTokujyou> copyList = new ArrayList<HT_ImusateiSyouhnTokujyou>(pEntity);
        Collections.sort(copyList, new OrderHT_ImusateiSyouhnTokujyou(orders));
        return copyList;
    }

    
    public List<HT_ImusateiSyouhnTokujyou> OrderHT_ImusateiSyouhnTokujyouByBM_SyouhnZokuseiSyutkkbnSyohnsortnoAsc(List<HT_ImusateiSyouhnTokujyou> pEntity) {
        List<HT_ImusateiSyouhnTokujyou> copyList = new ArrayList<HT_ImusateiSyouhnTokujyou>(pEntity);
        Collections.sort(copyList, new OrderHT_ImusateiSyouhnTokujyouByBM_SyouhnZokuseiSyutkkbnSyohnsortno());
        return copyList;
    }

    
    class OrderHT_ImusateiSyouhnTokujyouByBM_SyouhnZokuseiSyutkkbnSyohnsortno implements Comparator<HT_ImusateiSyouhnTokujyou> {
        @Override
        public int compare(HT_ImusateiSyouhnTokujyou o1, HT_ImusateiSyouhnTokujyou o2) {
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

