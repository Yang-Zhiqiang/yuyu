package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIW_KhYendtHnkUktkNiniWk;
import yuyu.def.db.mapping.GenIW_KhYendtHnkUktkNiniWk;
import yuyu.def.db.meta.GenQIW_KhYendtHnkUktkNiniWk;
import yuyu.def.db.meta.QIW_KhYendtHnkUktkNiniWk;

/**
 * 円建変更受付（任意請求）ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIW_KhYendtHnkUktkNiniWk} の JavaDoc を参照してください。
 * @see     GenIW_KhYendtHnkUktkNiniWk
 * @see     PKIW_KhYendtHnkUktkNiniWk
 * @see     QIW_KhYendtHnkUktkNiniWk
 * @see     GenQIW_KhYendtHnkUktkNiniWk
 */
@Entity
public class IW_KhYendtHnkUktkNiniWk extends GenIW_KhYendtHnkUktkNiniWk {

    private static final long serialVersionUID = 1L;

    public IW_KhYendtHnkUktkNiniWk() {
    }

    public IW_KhYendtHnkUktkNiniWk(String pKouteikanriid) {
        super(pKouteikanriid);
    }

}
