package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBV_HjybruikeigakuData;
import yuyu.def.db.mapping.GenBV_HjybruikeigakuData;
import yuyu.def.db.meta.GenQBV_HjybruikeigakuData;
import yuyu.def.db.meta.QBV_HjybruikeigakuData;
import yuyu.def.classification.C_Kanjyoukmkcd;

/**
 * 補助簿累計額情報ビュー エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBV_HjybruikeigakuData} の JavaDoc を参照してください。
 * @see     GenBV_HjybruikeigakuData
 * @see     PKBV_HjybruikeigakuData
 * @see     QBV_HjybruikeigakuData
 * @see     GenQBV_HjybruikeigakuData
 */
@Entity
public class BV_HjybruikeigakuData extends GenBV_HjybruikeigakuData {

    private static final long serialVersionUID = 1L;

    public BV_HjybruikeigakuData() {
    }

    public BV_HjybruikeigakuData(String pHjybtantositucd, C_Kanjyoukmkcd pKanjyoukmkcd) {
        super(pHjybtantositucd, pKanjyoukmkcd);
    }

}
