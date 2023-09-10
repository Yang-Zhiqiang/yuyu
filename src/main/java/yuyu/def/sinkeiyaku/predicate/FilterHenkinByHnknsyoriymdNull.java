package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.db.entity.HT_Henkin;

import com.google.common.base.Predicate;

/**
 * 返金テーブル用 Predicate<br/>
 * 返金処理日 ＝ null<br/>
 */
public class FilterHenkinByHnknsyoriymdNull implements Predicate<HT_Henkin> {

    public FilterHenkinByHnknsyoriymdNull(){

        super();
    }

    @Override
    public boolean apply(HT_Henkin pHenkin) {

        if (pHenkin.getHnknsyoriymd() == null) {

            return true;
        }

        return false;
    }
}
