package yuyu.def.hozen.predicate;

import yuyu.def.db.entity.IT_KykSyouhn;

import com.google.common.base.Predicate;

/**
 * 契約商品テーブル用 Predicate<br/>
 * 商品コード、商品世代番号（一致）<br/>
 */
public class FilterKykSyouhnBySyouhncdSyouhnsdno implements Predicate<IT_KykSyouhn>{

    String  syouhncd;
    Integer syouhnsdno;

    public FilterKykSyouhnBySyouhncdSyouhnsdno(String pSyouhncd,Integer pSyouhnsdno) {
        super();
        syouhncd = pSyouhncd;
        syouhnsdno = pSyouhnsdno;

    }

    @Override
    public boolean apply(IT_KykSyouhn kykSyouhn) {
        if (syouhncd.equals(kykSyouhn.getSyouhncd()) && syouhnsdno.equals(kykSyouhn.getSyouhnsdno())) {
            return true;
        }
        return false;
    }
}
