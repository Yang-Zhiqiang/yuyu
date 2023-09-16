package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIW_KhDShrWk;
import yuyu.def.db.mapping.GenIW_KhDShrWk;
import yuyu.def.db.meta.GenQIW_KhDShrWk;
import yuyu.def.db.meta.QIW_KhDShrWk;

/**
 * 配当金支払ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIW_KhDShrWk} の JavaDoc を参照してください。
 * @see     GenIW_KhDShrWk
 * @see     PKIW_KhDShrWk
 * @see     QIW_KhDShrWk
 * @see     GenQIW_KhDShrWk
 */
@Entity
public class IW_KhDShrWk extends GenIW_KhDShrWk {

    private static final long serialVersionUID = 1L;

    public IW_KhDShrWk() {
    }

    public IW_KhDShrWk(String pKouteikanriid) {
        super(pKouteikanriid);
    }

}
