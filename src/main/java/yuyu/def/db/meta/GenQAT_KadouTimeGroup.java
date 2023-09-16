package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AT_KadouTimeGroup;

/**
 * 稼働時間グループテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_KadouTimeGroup extends AbstractExDBTable<AT_KadouTimeGroup> {

    public GenQAT_KadouTimeGroup() {
        this("AT_KadouTimeGroup");
    }

    public GenQAT_KadouTimeGroup(String pAlias) {
        super("AT_KadouTimeGroup", AT_KadouTimeGroup.class, pAlias);
    }

    public String AT_KadouTimeGroup() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_KadouTimeGroup, String> kadouTimeGroupCd = new ExDBFieldString<>("kadouTimeGroupCd", this);

    public final ExDBFieldString<AT_KadouTimeGroup, String> kadouTimeGroupNm = new ExDBFieldString<>("kadouTimeGroupNm", this);

    public final ExDBFieldString<AT_KadouTimeGroup, String> kadouTimeGroupDescription = new ExDBFieldString<>("kadouTimeGroupDescription", this);

    public final ExDBFieldString<AT_KadouTimeGroup, String> holidayGroupCd = new ExDBFieldString<>("holidayGroupCd", this);
}
