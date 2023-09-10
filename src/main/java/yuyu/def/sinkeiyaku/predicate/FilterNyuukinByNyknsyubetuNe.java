package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_NyknsyubetuKbn;
import yuyu.def.db.entity.HT_Nyuukin;

import com.google.common.base.Predicate;

/**
 * 入金テーブル用 Predicate<br/>
 */
public class FilterNyuukinByNyknsyubetuNe implements Predicate<HT_Nyuukin> {

    C_NyknsyubetuKbn nyknsyubetu;

    public FilterNyuukinByNyknsyubetuNe (C_NyknsyubetuKbn pNyknsyubetuKbn) {

        super();

        this.nyknsyubetu = pNyknsyubetuKbn;

    }

    @Override
    public boolean apply(HT_Nyuukin pNyuukin) {

        if (!nyknsyubetu.eq(pNyuukin.getNyknsyubetu())) {

            return true;
        }
        return false;
    }
}
