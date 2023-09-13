package yuyu.def.hozen.predicate;

import yuyu.def.db.entity.IT_KykSyouhnRireki;

import com.google.common.base.Predicate;

/**
 * 契約商品履歴テーブル用 Predicate<br/>
 * 商品コード、商品世代番号（一致）
 */
public class FilterKykSyouhnRirekiBySyouhncdSyouhnsdno implements Predicate<IT_KykSyouhnRireki> {

    String syouhncd;
    Integer syouhnsdno;

    public FilterKykSyouhnRirekiBySyouhncdSyouhnsdno(String pSyouhncd,Integer pSyouhnsdno) {
        super();
        syouhncd = pSyouhncd;
        syouhnsdno = pSyouhnsdno;
    }

    @Override
    public boolean apply(IT_KykSyouhnRireki kykSyouhnRireki) {
        if (syouhncd.equals(kykSyouhnRireki.getSyouhncd()) && syouhnsdno.equals(kykSyouhnRireki.getSyouhnsdno())) {
            return true;
        }
        return false;
    }

}
