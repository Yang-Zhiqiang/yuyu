package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIW_KhJyudKigmaebriTkykHnkWk;
import yuyu.def.db.mapping.GenIW_KhJyudKigmaebriTkykHnkWk;
import yuyu.def.db.meta.GenQIW_KhJyudKigmaebriTkykHnkWk;
import yuyu.def.db.meta.QIW_KhJyudKigmaebriTkykHnkWk;

/**
 * 重度介護前払特約変更ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIW_KhJyudKigmaebriTkykHnkWk} の JavaDoc を参照してください。
 * @see     GenIW_KhJyudKigmaebriTkykHnkWk
 * @see     PKIW_KhJyudKigmaebriTkykHnkWk
 * @see     QIW_KhJyudKigmaebriTkykHnkWk
 * @see     GenQIW_KhJyudKigmaebriTkykHnkWk
 */
@Entity
public class IW_KhJyudKigmaebriTkykHnkWk extends GenIW_KhJyudKigmaebriTkykHnkWk {

    private static final long serialVersionUID = 1L;

    public IW_KhJyudKigmaebriTkykHnkWk() {
    }

    public IW_KhJyudKigmaebriTkykHnkWk(String pKouteikanriid) {
        super(pKouteikanriid);
    }

}
