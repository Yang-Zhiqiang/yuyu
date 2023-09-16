package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBT_Hjybruikeigaku;
import yuyu.def.db.mapping.GenBT_Hjybruikeigaku;
import yuyu.def.db.meta.GenQBT_Hjybruikeigaku;
import yuyu.def.db.meta.QBT_Hjybruikeigaku;
import yuyu.def.classification.C_Kanjyoukmkcd;
import jp.co.slcs.swak.date.BizDateYM;

/**
 * 補助簿累計額テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_Hjybruikeigaku} の JavaDoc を参照してください。
 * @see     GenBT_Hjybruikeigaku
 * @see     PKBT_Hjybruikeigaku
 * @see     QBT_Hjybruikeigaku
 * @see     GenQBT_Hjybruikeigaku
 */
@Entity
public class BT_Hjybruikeigaku extends GenBT_Hjybruikeigaku {

    private static final long serialVersionUID = 1L;

    public BT_Hjybruikeigaku() {
    }

    public BT_Hjybruikeigaku(
        String pHjybtantositucd,
        C_Kanjyoukmkcd pKanjyoukmkcd,
        BizDateYM pDenym
    ) {
        super(
            pHjybtantositucd,
            pKanjyoukmkcd,
            pDenym
        );
    }

}
