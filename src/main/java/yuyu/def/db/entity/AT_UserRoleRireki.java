package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenAT_UserRoleRireki;


/**
 * ユーザーロール履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_UserRoleRireki} の JavaDoc を参照してください。<br />
 * @see     GenAT_UserRoleRireki<br />
 * @see     PKAT_UserRoleRireki<br />
 * @see     QAT_UserRoleRireki<br />
 * @see     GenQAT_UserRoleRireki<br />
 */
@Entity
public class AT_UserRoleRireki extends GenAT_UserRoleRireki {

    private static final long serialVersionUID = 1L;

    public AT_UserRoleRireki() {
    }

    public AT_UserRoleRireki(String pUniqueId) {
        super(pUniqueId);
    }



}

