package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIT_KyuukzAnnaimati;
import yuyu.def.db.mapping.GenIT_KyuukzAnnaimati;
import yuyu.def.db.meta.GenQIT_KyuukzAnnaimati;
import yuyu.def.db.meta.QIT_KyuukzAnnaimati;

/**
 * 旧口座案内待ちテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KyuukzAnnaimati} の JavaDoc を参照してください。
 * @see     GenIT_KyuukzAnnaimati
 * @see     PKIT_KyuukzAnnaimati
 * @see     QIT_KyuukzAnnaimati
 * @see     GenQIT_KyuukzAnnaimati
 */
@Entity
public class IT_KyuukzAnnaimati extends GenIT_KyuukzAnnaimati {

    private static final long serialVersionUID = 1L;

    public IT_KyuukzAnnaimati() {
    }

    public IT_KyuukzAnnaimati(String pKouteikanriid) {
        super(pKouteikanriid);
    }

}
