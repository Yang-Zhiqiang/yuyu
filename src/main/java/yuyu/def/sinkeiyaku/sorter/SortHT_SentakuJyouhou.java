package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_SentakuJyouhou;
import yuyu.def.db.meta.QHT_SentakuJyouhou;
import yuyu.def.sinkeiyaku.comparator.OrderHT_SentakuJyouhou;

public class SortHT_SentakuJyouhou {

    
    public List<HT_SentakuJyouhou> OrderHT_SentakuJyouhouByPkAsc(List<HT_SentakuJyouhou> pEntity) {
        List<SortCondition<HT_SentakuJyouhou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SentakuJyouhou()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SentakuJyouhou()).sntkinfotaisyousyakbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SentakuJyouhou()).edano, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SentakuJyouhou()).sntkinfono, SortOrder.ASC));
        List<HT_SentakuJyouhou> copyList = new ArrayList<HT_SentakuJyouhou>(pEntity);
        Collections.sort(copyList, new OrderHT_SentakuJyouhou(orders));
        return copyList;
    }

    
    public List<HT_SentakuJyouhou> OrderHT_SentakuJyouhouByPkDesc(List<HT_SentakuJyouhou> pEntity) {
        List<SortCondition<HT_SentakuJyouhou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SentakuJyouhou()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SentakuJyouhou()).sntkinfotaisyousyakbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SentakuJyouhou()).edano, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_SentakuJyouhou()).sntkinfono, SortOrder.DESC));
        List<HT_SentakuJyouhou> copyList = new ArrayList<HT_SentakuJyouhou>(pEntity);
        Collections.sort(copyList, new OrderHT_SentakuJyouhou(orders));
        return copyList;
    }

    
    public List<HT_SentakuJyouhou> OrderHT_SentakuJyouhouBySntkinfotaisyousyakbnSntkinfonoSyscdkbnAsc(List<HT_SentakuJyouhou> pEntity) {
        List<SortCondition<HT_SentakuJyouhou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SentakuJyouhou()).sntkinfotaisyousyakbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SentakuJyouhou()).sntkinfono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SentakuJyouhou()).syscdkbn, SortOrder.ASC));
        List<HT_SentakuJyouhou> copyList = new ArrayList<HT_SentakuJyouhou>(pEntity);
        Collections.sort(copyList, new OrderHT_SentakuJyouhou(orders));
        return copyList;
    }
    
    public List<HT_SentakuJyouhou> OrderHT_SentakuJyouhouBySntkinfotaisyousyakbnEdanoSntkinfonoSyscdkbnAsc(List<HT_SentakuJyouhou> pEntity) {
        List<SortCondition<HT_SentakuJyouhou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_SentakuJyouhou()).sntkinfotaisyousyakbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SentakuJyouhou()).edano, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SentakuJyouhou()).sntkinfono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_SentakuJyouhou()).syscdkbn, SortOrder.ASC));
        List<HT_SentakuJyouhou> copyList = new ArrayList<HT_SentakuJyouhou>(pEntity);
        Collections.sort(copyList, new OrderHT_SentakuJyouhou(orders));
        return copyList;
    }

}

