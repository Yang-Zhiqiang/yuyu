package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.db.entity.HT_SkLincSyoukaikekka;

import com.google.common.base.Predicate;

/**
 * 新契約ＬＩＮＣ他社照会結果テーブル用 Predicate<br/>
 * ＬＩＮＣ受信ＴＲ連番（一致）<br/>
 * 連番（一致）<br/>
 */
public class FilterSkLincSyoukaikekkaByLincjyusintrrennoRenno implements Predicate <HT_SkLincSyoukaikekka> {

    String lincjyusintrrenno;

    Integer renno;

    public FilterSkLincSyoukaikekkaByLincjyusintrrennoRenno(String pLincjyusintrrenno, Integer pRenno) {
        super();
        lincjyusintrrenno = pLincjyusintrrenno;
        renno = pRenno;
    }

    @Override
    public boolean apply(HT_SkLincSyoukaikekka pSkLincSyoukaikekka) {

        if (lincjyusintrrenno.equals(pSkLincSyoukaikekka.getLincjyusintrrenno()) &&
            pSkLincSyoukaikekka.getRenno().equals(renno)) {

            return true;
        }
        return false;
    }
}
