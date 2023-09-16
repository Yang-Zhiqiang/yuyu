package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIW_KhTmttknitenWk;
import yuyu.def.db.mapping.GenIW_KhTmttknitenWk;
import yuyu.def.db.meta.GenQIW_KhTmttknitenWk;
import yuyu.def.db.meta.QIW_KhTmttknitenWk;

/**
 * 積立金移転ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIW_KhTmttknitenWk} の JavaDoc を参照してください。
 * @see     GenIW_KhTmttknitenWk
 * @see     PKIW_KhTmttknitenWk
 * @see     QIW_KhTmttknitenWk
 * @see     GenQIW_KhTmttknitenWk
 */
@Entity
public class IW_KhTmttknitenWk extends GenIW_KhTmttknitenWk {

    private static final long serialVersionUID = 1L;

    public IW_KhTmttknitenWk() {
    }

    public IW_KhTmttknitenWk(String pKouteikanriid) {
        super(pKouteikanriid);
    }

}
