package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBW_IdCardWk;
import yuyu.def.db.mapping.GenBW_IdCardWk;
import yuyu.def.db.meta.GenQBW_IdCardWk;
import yuyu.def.db.meta.QBW_IdCardWk;

/**
 * ＩＤカードマスタワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBW_IdCardWk} の JavaDoc を参照してください。
 * @see     GenBW_IdCardWk
 * @see     PKBW_IdCardWk
 * @see     QBW_IdCardWk
 * @see     GenQBW_IdCardWk
 */
@Entity
public class BW_IdCardWk extends GenBW_IdCardWk {

    private static final long serialVersionUID = 1L;

    public BW_IdCardWk() {
    }

    public BW_IdCardWk(String pIdkbn, String pIdcd) {
        super(pIdkbn, pIdcd);
    }

}
