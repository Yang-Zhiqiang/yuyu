package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBW_UserRoleWk;
import yuyu.def.db.mapping.GenBW_UserRoleWk;
import yuyu.def.db.meta.GenQBW_UserRoleWk;
import yuyu.def.db.meta.QBW_UserRoleWk;

/**
 * ユーザーロールワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBW_UserRoleWk} の JavaDoc を参照してください。
 * @see     GenBW_UserRoleWk
 * @see     PKBW_UserRoleWk
 * @see     QBW_UserRoleWk
 * @see     GenQBW_UserRoleWk
 */
@Entity
public class BW_UserRoleWk extends GenBW_UserRoleWk {

    private static final long serialVersionUID = 1L;

    public BW_UserRoleWk() {
    }

    public BW_UserRoleWk(String pUserId, String pRoleCd) {
        super(pUserId, pRoleCd);
    }

}
