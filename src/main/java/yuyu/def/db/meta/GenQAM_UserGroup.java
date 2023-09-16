package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AM_UserGroup;

/**
 * ユーザーグループマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAM_UserGroup extends AbstractExDBTable<AM_UserGroup> {

    public GenQAM_UserGroup() {
        this("AM_UserGroup");
    }

    public GenQAM_UserGroup(String pAlias) {
        super("AM_UserGroup", AM_UserGroup.class, pAlias);
    }

    public String AM_UserGroup() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AM_UserGroup, String> userGroupCd = new ExDBFieldString<>("userGroupCd", this);

    public final ExDBFieldString<AM_UserGroup, String> userGroupNm = new ExDBFieldString<>("userGroupNm", this);

    public final ExDBFieldString<AM_UserGroup, String> userGroupSetumei = new ExDBFieldString<>("userGroupSetumei", this);
}
