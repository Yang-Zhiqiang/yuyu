package yuyu.def.siharai.predicate;

import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.JT_SateiSyouninRireki;

import com.google.common.base.Predicate;
/**
 * 査定承認履歴テーブル用 Predicate
 * 処理結果区分（一致）、更新処理詳細コード（一致）
 */
public class FilterSateiSyouninRirekiByKossyorisscdSyorikekkakbns implements Predicate<JT_SateiSyouninRireki> {

    String kossyorisscd;
    C_SyorikekkaKbn[] syorikekkakbns;

    public FilterSateiSyouninRirekiByKossyorisscdSyorikekkakbns(String pKossyorisscd, C_SyorikekkaKbn... pSyorikekkakbn) {
        super();
        kossyorisscd = pKossyorisscd;
        syorikekkakbns = pSyorikekkakbn;
    }

    @Override
    public boolean apply(JT_SateiSyouninRireki pSateiSyouninRireki) {
        if (kossyorisscd.equals(pSateiSyouninRireki.getKossyorisscd())) {

            for (C_SyorikekkaKbn syorikekkakbn: syorikekkakbns) {

                if (syorikekkakbn.eq(pSateiSyouninRireki.getSyorikekkakbn())) {

                    return true;
                }
            }
        }
        return false;
    }
}
