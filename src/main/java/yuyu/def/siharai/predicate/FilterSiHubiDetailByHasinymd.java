package yuyu.def.siharai.predicate;

import yuyu.def.db.entity.JT_SiHubiDetail;

import com.google.common.base.Predicate;

/**
 * 支払不備詳細テーブル 用 Predicate<br/>
 * 発信日 IS NOT NULL<br/>
 */
public class FilterSiHubiDetailByHasinymd implements Predicate<JT_SiHubiDetail> {

    public FilterSiHubiDetailByHasinymd() {
        super();
    }

    @Override
    public boolean apply(JT_SiHubiDetail pJT_SiHubiDetail) {
        if(pJT_SiHubiDetail.getHasinymd() != null){
            return true;
        }
        return false;
    }


}
