package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SyuHukugouSikkanDataTy;
import yuyu.def.db.meta.QZT_SyuHukugouSikkanDataTy;
import yuyu.def.zdb.comparator.OrderZT_SyuHukugouSikkanDataTy;

public class SortZT_SyuHukugouSikkanDataTy {

    
    public List<ZT_SyuHukugouSikkanDataTy> OrderZT_SyuHukugouSikkanDataTyByPkAsc(List<ZT_SyuHukugouSikkanDataTy> pEntity) {
        List<SortCondition<ZT_SyuHukugouSikkanDataTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyijitoukeidaihyousyurui, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztykeiyakunendo, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyhknnendo, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyhhknseikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztykykage, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztytoutatunenrei, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyatukaibetu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztysinsahouhou, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyketteikekkakbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztysibousrank, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyjissituhosyousrank, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztysirajikykkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyhrkhuhukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyhknsyurui2keta, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztydaisiincd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztytyuusiincd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztysyousiincd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztynenreihousikikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztysykgycd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztytodouhukencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztybotaisisyaeigyouhonbu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztysisyaeigyoubu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyaatukaisosikicd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztynensyuukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyhanbaikeirokbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyoyadairitencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztytratkidrtencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztybsudirtnatkikeitaikbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztykyktuuka, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyhrktuuka, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyhknsyukigou, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztysyksbyensitihsyutyhkumu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyjyudkaigomehrtkhkumu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyijitoukeizennoukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztydai1hknkkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyijitoukeitikshrtkykkbn, SortOrder.ASC));
        List<ZT_SyuHukugouSikkanDataTy> copyList = new ArrayList<ZT_SyuHukugouSikkanDataTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SyuHukugouSikkanDataTy(orders));
        return copyList;
    }

    
    public List<ZT_SyuHukugouSikkanDataTy> OrderZT_SyuHukugouSikkanDataTyByPkDesc(List<ZT_SyuHukugouSikkanDataTy> pEntity) {
        List<SortCondition<ZT_SyuHukugouSikkanDataTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyijitoukeidaihyousyurui, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztykeiyakunendo, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyhknnendo, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyhhknseikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztykykage, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztytoutatunenrei, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyatukaibetu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztysinsahouhou, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyketteikekkakbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztysibousrank, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyjissituhosyousrank, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztysirajikykkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyhrkhuhukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyhknsyurui2keta, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztydaisiincd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztytyuusiincd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztysyousiincd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztynenreihousikikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztysykgycd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztytodouhukencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztybotaisisyaeigyouhonbu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztysisyaeigyoubu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyaatukaisosikicd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztynensyuukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyhanbaikeirokbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyoyadairitencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztytratkidrtencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztybsudirtnatkikeitaikbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztykyktuuka, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyhrktuuka, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyhknsyukigou, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztysyksbyensitihsyutyhkumu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyjyudkaigomehrtkhkumu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyijitoukeizennoukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztydai1hknkkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyuHukugouSikkanDataTy()).ztyijitoukeitikshrtkykkbn, SortOrder.DESC));
        List<ZT_SyuHukugouSikkanDataTy> copyList = new ArrayList<ZT_SyuHukugouSikkanDataTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SyuHukugouSikkanDataTy(orders));
        return copyList;
    }
}
