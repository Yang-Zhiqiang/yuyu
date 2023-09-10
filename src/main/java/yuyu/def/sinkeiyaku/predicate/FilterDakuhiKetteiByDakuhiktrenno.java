package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.db.entity.HT_DakuhiKettei;

import com.google.common.base.Predicate;

/**
 * 諾否決定テーブル用 Predicate<br/>
 * 諾否決定連番（一致）
 */
public class FilterDakuhiKetteiByDakuhiktrenno implements Predicate<HT_DakuhiKettei>{

    Integer dakuhiktrenno;

    public FilterDakuhiKetteiByDakuhiktrenno(Integer pDakuhiktrenno){
        super();
        dakuhiktrenno = pDakuhiktrenno;
    }

    @Override
    public boolean apply(HT_DakuhiKettei pDakuhiKettei) {
        if(dakuhiktrenno.equals(pDakuhiKettei.getDakuhiktrenno())){
            return true;
        }
        return false;
    }


}
