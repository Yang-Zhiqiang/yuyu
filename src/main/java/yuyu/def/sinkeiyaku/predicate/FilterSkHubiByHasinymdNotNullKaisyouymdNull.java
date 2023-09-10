package yuyu.def.sinkeiyaku.predicate;

import java.util.List;

import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.entity.HT_SkHubiDetail;

import com.google.common.base.Predicate;

/**
 * 新契約不備テーブル用 Predicate<br/>
 * 発信日（非空）、解消日（空）
 */
public class FilterSkHubiByHasinymdNotNullKaisyouymdNull implements Predicate<HT_SkHubi> {

    public FilterSkHubiByHasinymdNotNullKaisyouymdNull() {

        super();
    }

    @Override
    public boolean apply(HT_SkHubi pSkHubi) {

        List<HT_SkHubiDetail> hT_SkHubiDetailLst = pSkHubi.getSkHubiDetails();

        for(int i = 0 ;i < hT_SkHubiDetailLst.size() ;i++) {

            if(hT_SkHubiDetailLst.get(i).getHasinymd() != null
                    && hT_SkHubiDetailLst.get(i).getKaisyouymd() == null) {

                return true;
            }
        }

        return false;
    }
}