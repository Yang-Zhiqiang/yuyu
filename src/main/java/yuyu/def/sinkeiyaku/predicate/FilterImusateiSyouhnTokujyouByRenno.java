package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.db.entity.HT_ImusateiSyouhnTokujyou;

import com.google.common.base.Predicate;

/**
 * 医務査定商品別特条条件付テーブル用 Predicate<br/>
 * 連番（一致）
 */
public class FilterImusateiSyouhnTokujyouByRenno implements Predicate<HT_ImusateiSyouhnTokujyou> {

    Integer renno;

    public FilterImusateiSyouhnTokujyouByRenno(Integer pRenno) {
        super();
        renno = pRenno;
    }

    @Override
    public boolean apply(HT_ImusateiSyouhnTokujyou hT_ImusateiSyouhnTokujyou) {
        if(renno.equals(hT_ImusateiSyouhnTokujyou.getRenno())){
            return true;
        }
        return false;
    }
}
