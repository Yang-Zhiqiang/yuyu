package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKHT_SkKouhuriUkTrkMihanei;
import yuyu.def.db.mapping.GenHT_SkKouhuriUkTrkMihanei;
import yuyu.def.db.meta.GenQHT_SkKouhuriUkTrkMihanei;
import yuyu.def.db.meta.QHT_SkKouhuriUkTrkMihanei;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDate;

/**
 * 新契約口振受付登録結果未反映テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_SkKouhuriUkTrkMihanei} の JavaDoc を参照してください。
 * @see     GenHT_SkKouhuriUkTrkMihanei
 * @see     PKHT_SkKouhuriUkTrkMihanei
 * @see     QHT_SkKouhuriUkTrkMihanei
 * @see     GenQHT_SkKouhuriUkTrkMihanei
 */
@Entity
public class HT_SkKouhuriUkTrkMihanei extends GenHT_SkKouhuriUkTrkMihanei {

    private static final long serialVersionUID = 1L;

    public HT_SkKouhuriUkTrkMihanei() {
    }

    public HT_SkKouhuriUkTrkMihanei(
        BizDate pSyoriYmd,
        String pSyukkncd,
        String pKinyuucd8keta,
        BizDate pKinyuukkntratkiymd,
        String pKinyuukkntratkitime,
        String pKouhuriokyakusamano
    ) {
        super(
            pSyoriYmd,
            pSyukkncd,
            pKinyuucd8keta,
            pKinyuukkntratkiymd,
            pKinyuukkntratkitime,
            pKouhuriokyakusamano
        );
    }

}
