package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_SyouhnZokusei;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.meta.QBM_SyouhnZokusei;
import yuyu.def.db.meta.QHT_MosSyouhn;
import yuyu.def.sinkeiyaku.comparator.OrderHT_MosSyouhn;

public class SortHT_MosSyouhn {

    
    public List<HT_MosSyouhn> OrderHT_MosSyouhnByPkAsc(List<HT_MosSyouhn> pEntity) {
        List<SortCondition<HT_MosSyouhn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_MosSyouhn()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_MosSyouhn()).syouhncd, SortOrder.ASC));
        List<HT_MosSyouhn> copyList = new ArrayList<HT_MosSyouhn>(pEntity);
        Collections.sort(copyList, new OrderHT_MosSyouhn(orders));
        return copyList;
    }

    
    public List<HT_MosSyouhn> OrderHT_MosSyouhnByPkDesc(List<HT_MosSyouhn> pEntity) {
        List<SortCondition<HT_MosSyouhn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_MosSyouhn()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_MosSyouhn()).syouhncd, SortOrder.DESC));
        List<HT_MosSyouhn> copyList = new ArrayList<HT_MosSyouhn>(pEntity);
        Collections.sort(copyList, new OrderHT_MosSyouhn(orders));
        return copyList;
    }

    
    public List<HT_MosSyouhn> OrderHT_MosSyouhnByBM_SyouhnZokuseiSyutkkbnSyohnsortnoAsc(List<HT_MosSyouhn> pEntity) {
        List<HT_MosSyouhn> copyList = new ArrayList<HT_MosSyouhn>(pEntity);
        Collections.sort(copyList, new OrderHT_MosSyouhnByBM_SyouhnZokuseiSyutkkbnSyohnsortno());
        return copyList;
    }
    
    public List<HT_MosSyouhn> OrderHT_MosSyouhnByBM_SyouhnZokuseiSyohnsortnoAsc(List<HT_MosSyouhn> pEntity) {
        List<HT_MosSyouhn> copyList = new ArrayList<HT_MosSyouhn>(pEntity);
        Collections.sort(copyList, new OrderHT_MosSyouhnByBM_SyouhnZokuseiSyohnsortno());
        return copyList;
    }
    
    public List<HT_MosSyouhn> OrderHT_MosSyouhnBySyutkkbnAsc(List<HT_MosSyouhn> pEntity) {
        List<SortCondition<HT_MosSyouhn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_MosSyouhn()).syutkkbn, SortOrder.ASC));
        List<HT_MosSyouhn> copyList = new ArrayList<HT_MosSyouhn>(pEntity);
        Collections.sort(copyList, new OrderHT_MosSyouhn(orders));
        return copyList;
    }



    
    class OrderHT_MosSyouhnByBM_SyouhnZokuseiSyutkkbnSyohnsortno implements Comparator<HT_MosSyouhn> {
        @Override
        public int compare(HT_MosSyouhn o1, HT_MosSyouhn o2) {
            if(o1 == null || o2==null ) {
                return compareAsc(o1,o2);
            }
            List<SortCondition<BM_SyouhnZokusei>> orders = new ArrayList<>();
            orders.add(new SortCondition<>((new QBM_SyouhnZokusei()).syutkkbn, SortOrder.ASC));
            orders.add(new SortCondition<>((new QBM_SyouhnZokusei()).syohnsortno, SortOrder.ASC));
            return new OrderBM_SyouhnZokusei(orders).compare(o1.getSyouhnZokusei(), o2.getSyouhnZokusei());
        }
    }


    
    class OrderHT_MosSyouhnByBM_SyouhnZokuseiSyohnsortno implements Comparator<HT_MosSyouhn> {
        @Override
        public int compare(HT_MosSyouhn o1, HT_MosSyouhn o2) {
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

