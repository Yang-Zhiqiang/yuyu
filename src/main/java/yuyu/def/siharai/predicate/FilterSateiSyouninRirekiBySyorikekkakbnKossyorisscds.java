package yuyu.def.siharai.predicate;

import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.JT_SateiSyouninRireki;

import com.google.common.base.Predicate;
/**
 * 査定承認履歴テーブル用 Predicate<br/>
 * 処理結果区分（一致）、更新処理詳細コード（一致）
 */
public class FilterSateiSyouninRirekiBySyorikekkakbnKossyorisscds implements Predicate<JT_SateiSyouninRireki> {

    C_SyorikekkaKbn syorikekkakbn;
    String[] kossyorisscds;

    public FilterSateiSyouninRirekiBySyorikekkakbnKossyorisscds(C_SyorikekkaKbn pSyorikekkakbn, String[] pKossyorisscd) {
        super();
        syorikekkakbn = pSyorikekkakbn;
        kossyorisscds = pKossyorisscd;
    }

    @Override
    public boolean apply(JT_SateiSyouninRireki sateiSyouninRireki) {
        if (syorikekkakbn.eq(sateiSyouninRireki.getSyorikekkakbn())) {

            for (String kossyorisscd :kossyorisscds) {

                if (kossyorisscd.equals(sateiSyouninRireki.getKossyorisscd())) {

                    return true;
                }
            }
        }
        return false;
    }
}
