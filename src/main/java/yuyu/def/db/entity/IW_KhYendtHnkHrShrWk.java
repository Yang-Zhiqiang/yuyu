package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIW_KhYendtHnkHrShrWk;
import yuyu.def.db.mapping.GenIW_KhYendtHnkHrShrWk;
import yuyu.def.db.meta.GenQIW_KhYendtHnkHrShrWk;
import yuyu.def.db.meta.QIW_KhYendtHnkHrShrWk;

/**
 * 円建変更時返戻金支払ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIW_KhYendtHnkHrShrWk} の JavaDoc を参照してください。
 * @see     GenIW_KhYendtHnkHrShrWk
 * @see     PKIW_KhYendtHnkHrShrWk
 * @see     QIW_KhYendtHnkHrShrWk
 * @see     GenQIW_KhYendtHnkHrShrWk
 */
@Entity
public class IW_KhYendtHnkHrShrWk extends GenIW_KhYendtHnkHrShrWk {

    private static final long serialVersionUID = 1L;

    public IW_KhYendtHnkHrShrWk() {
    }

    public IW_KhYendtHnkHrShrWk(String pKouteikanriid) {
        super(pKouteikanriid);
    }

}
