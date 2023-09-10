package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.db.entity.HT_Henkin;

import com.google.common.base.Predicate;

/**
 * 返金テーブル用 Predicate<br/>
 * 返金入力連番（一致）
 */
public class FilterHenkinByHnkninputrenno implements Predicate<HT_Henkin>{

    String hnkninputrenno;

    public FilterHenkinByHnkninputrenno(String pHnkninputrenno){
        super();

        hnkninputrenno = pHnkninputrenno;
    }

    @Override
    public boolean apply(HT_Henkin pHenkin) {
        if (hnkninputrenno.equals(pHenkin.getHnkninputrenno())) {

            return true;
        }
        return false;
    }

}
