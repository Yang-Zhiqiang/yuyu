package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_NyknsyubetuKbn;
import yuyu.def.db.entity.HT_Nyuukin;

import com.google.common.base.Predicate;

/**
 * 入金テーブル用 Predicate<br/>
 * 入金種別区分（一致）
 */
public class FilterNyuukinByNyknsyubetu implements Predicate<HT_Nyuukin> {

    C_NyknsyubetuKbn nyknsyubetuKbn;

    public FilterNyuukinByNyknsyubetu(C_NyknsyubetuKbn pNyknsyubetuKbn) {
        super();
        nyknsyubetuKbn = pNyknsyubetuKbn;
    }

    @Override
    public boolean apply(HT_Nyuukin nyuukin) {
        if(nyknsyubetuKbn.eq(nyuukin.getNyknsyubetu())) {
            return true;
        }
        return false;
    }

}
