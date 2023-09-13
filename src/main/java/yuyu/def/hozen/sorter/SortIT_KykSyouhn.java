package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_SyouhnZokusei;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.meta.QBM_SyouhnZokusei;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.hozen.comparator.OrderIT_KykSyouhn;

public class SortIT_KykSyouhn {

    public List<IT_KykSyouhn> OrderIT_KykSyouhnByPkAsc(List<IT_KykSyouhn> pEntity) {
        List<SortCondition<IT_KykSyouhn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KykSyouhn()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykSyouhn()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykSyouhn()).syutkkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykSyouhn()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykSyouhn()).syouhnsdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykSyouhn()).kyksyouhnrenno, SortOrder.ASC));
        List<IT_KykSyouhn> copyList = new ArrayList<IT_KykSyouhn>(pEntity);
        Collections.sort(copyList, new OrderIT_KykSyouhn(orders));
        return copyList;
    }

    public List<IT_KykSyouhn> OrderIT_KykSyouhnByPkDesc(List<IT_KykSyouhn> pEntity) {
        List<SortCondition<IT_KykSyouhn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KykSyouhn()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KykSyouhn()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KykSyouhn()).syutkkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KykSyouhn()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KykSyouhn()).syouhnsdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KykSyouhn()).kyksyouhnrenno, SortOrder.DESC));
        List<IT_KykSyouhn> copyList = new ArrayList<IT_KykSyouhn>(pEntity);
        Collections.sort(copyList, new OrderIT_KykSyouhn(orders));
        return copyList;
    }

    public List<IT_KykSyouhn> OrderIT_KykSyouhnByBM_SyouhnZokuseiSyohnsortnoIT_KykSyouhnKyksyouhnrennoAsc(List<IT_KykSyouhn> pEntity) {
        List<IT_KykSyouhn> copyList = new ArrayList<IT_KykSyouhn>(pEntity);
        Collections.sort(copyList, new OrderIT_KykSyouhnByBM_SyouhnZokuseiSyohnsortnoIT_KykSyouhnKyksyouhnrenno());
        return copyList;
    }

    public List<IT_KykSyouhn> OrderIT_KykSyouhnBySyutkkbnSyouhncdKyhgndkatakbnSyouhnsdnoKyksyouhnrennoAsc(List<IT_KykSyouhn> pEntity) {
        List<SortCondition<IT_KykSyouhn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KykSyouhn()).syutkkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykSyouhn()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykSyouhn()).kyhgndkatakbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykSyouhn()).syouhnsdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykSyouhn()).kyksyouhnrenno, SortOrder.ASC));
        List<IT_KykSyouhn> copyList = new ArrayList<IT_KykSyouhn>(pEntity);
        Collections.sort(copyList, new OrderIT_KykSyouhn(orders));
        return copyList;
    }

    class OrderIT_KykSyouhnByBM_SyouhnZokuseiSyohnsortnoIT_KykSyouhnKyksyouhnrenno implements Comparator<IT_KykSyouhn> {
        @Override
        public int compare(IT_KykSyouhn o1, IT_KykSyouhn o2) {
            if(o1 == null || o2==null ) {
                return compareAsc(o1,o2);
            }
            List<SortCondition<BM_SyouhnZokusei>> orders = new ArrayList<>();
            orders.add(new SortCondition<>((new QBM_SyouhnZokusei()).syohnsortno, SortOrder.ASC));
            int compare = new OrderBM_SyouhnZokusei(orders).compare(o1.getSyouhnZokusei(), o2.getSyouhnZokusei());
            if(compare == 0){
                List<SortCondition<IT_KykSyouhn>> orders2 =  new ArrayList<>();
                orders2.add(new SortCondition<>((new QIT_KykSyouhn()).kyksyouhnrenno, SortOrder.ASC));
                compare = new OrderIT_KykSyouhn(orders2).compare(o1, o2);
            }
            return compare;
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

