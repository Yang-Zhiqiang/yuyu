package yuyu.common.hozen.khcommon.dba4editkoujyonaiyoutbl;

import yuyu.def.db.entity.IT_KoujyoSymNaiyou;

import com.google.common.base.Predicate;

/**
 * 控除証明内容テーブル用 Predicateクラス１<br/>
 * 商品コード（一致）<br/>
 */
public class FilterKoujyoSymNaiyou1 implements Predicate<IT_KoujyoSymNaiyou>{

    String shouhncd;

    public FilterKoujyoSymNaiyou1(String pSyouhncd) {
        super();
        shouhncd = pSyouhncd;
    }

    @Override
    public boolean apply(IT_KoujyoSymNaiyou pKoujyoSymNaiyou) {
        if (shouhncd.equals(pKoujyoSymNaiyou.getSyouhncd())) {
            return true;
        }
        return false;
    }
}
