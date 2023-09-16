package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBT_HjybruikeigakuTeisei;
import yuyu.def.db.mapping.GenBT_HjybruikeigakuTeisei;
import yuyu.def.db.meta.GenQBT_HjybruikeigakuTeisei;
import yuyu.def.db.meta.QBT_HjybruikeigakuTeisei;
import yuyu.def.classification.C_Kanjyoukmkcd;

/**
 * 補助簿累計額訂正テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_HjybruikeigakuTeisei} の JavaDoc を参照してください。
 * @see     GenBT_HjybruikeigakuTeisei
 * @see     PKBT_HjybruikeigakuTeisei
 * @see     QBT_HjybruikeigakuTeisei
 * @see     GenQBT_HjybruikeigakuTeisei
 */
@Entity
public class BT_HjybruikeigakuTeisei extends GenBT_HjybruikeigakuTeisei {

    private static final long serialVersionUID = 1L;

    public BT_HjybruikeigakuTeisei() {
    }

    public BT_HjybruikeigakuTeisei(String pHjybruigkteiseitantositucd, C_Kanjyoukmkcd pKanjyoukmkcd) {
        super(pHjybruigkteiseitantositucd, pKanjyoukmkcd);
    }

}
