package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKAM_UserGroup;
import yuyu.def.db.mapping.GenAM_UserGroup;
import yuyu.def.db.meta.GenQAM_UserGroup;
import yuyu.def.db.meta.QAM_UserGroup;

/**
 * ユーザーグループマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAM_UserGroup} の JavaDoc を参照してください。
 * @see     GenAM_UserGroup
 * @see     PKAM_UserGroup
 * @see     QAM_UserGroup
 * @see     GenQAM_UserGroup
 */
@Entity
public class AM_UserGroup extends GenAM_UserGroup {

    private static final long serialVersionUID = 1L;

    public AM_UserGroup() {
    }

    public AM_UserGroup(String pUserGroupCd) {
        super(pUserGroupCd);
    }

}