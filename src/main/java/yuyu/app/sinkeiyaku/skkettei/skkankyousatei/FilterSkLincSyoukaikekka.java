package yuyu.app.sinkeiyaku.skkettei.skkankyousatei;

import yuyu.def.db.entity.HT_SkLincSyoukaikekka;

import com.google.common.base.Predicate;

/**
 * ＬＩＮＣ受信ＴＲ連番が指定されていて、
 * ＬＩＮＣ受信ＴＲ連番が同一の場合に一致するデータをフィルタリングする。
 */
public class FilterSkLincSyoukaikekka implements Predicate<HT_SkLincSyoukaikekka>{

    String lincjyusintrrenno;

    FilterSkLincSyoukaikekka(String pLincjyusintrrenno){
        this.lincjyusintrrenno = pLincjyusintrrenno;
    }

    @Override
    public boolean apply(HT_SkLincSyoukaikekka pSkLincSyoukaikekka) {

        if(lincjyusintrrenno.equals(pSkLincSyoukaikekka.getLincjyusintrrenno())){
            return true;
        }

        return false;
    }

}