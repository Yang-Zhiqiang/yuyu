package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.db.entity.HT_ImusateiTokujyou;

import com.google.common.base.Predicate;

/**
 * 医務査定特条テーブル用 Predicate<br/>
 * 連番（一致）
 */
public class FilterImusateiTokujyouByRenno implements Predicate<HT_ImusateiTokujyou>{

    Integer renno;

    public FilterImusateiTokujyouByRenno(Integer pRenno){
        super();
        renno = pRenno;
    }

    @Override
    public boolean apply(HT_ImusateiTokujyou imusateiTokujyou) {

        if(renno.equals(imusateiTokujyou.getRenno())){
            return true;
        }
        return false;
    }


}
