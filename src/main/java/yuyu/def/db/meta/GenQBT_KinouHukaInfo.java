package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.db.entity.BT_KinouHukaInfo;
import yuyu.def.db.type.UserType_C_KahiKbn;

/**
 * 機能付加情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_KinouHukaInfo extends AbstractExDBTable<BT_KinouHukaInfo> {

    public GenQBT_KinouHukaInfo() {
        this("BT_KinouHukaInfo");
    }

    public GenQBT_KinouHukaInfo(String pAlias) {
        super("BT_KinouHukaInfo", BT_KinouHukaInfo.class, pAlias);
    }

    public String BT_KinouHukaInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_KinouHukaInfo, String> kinouId = new ExDBFieldString<>("kinouId", this);

    public final ExDBFieldString<BT_KinouHukaInfo, C_KahiKbn> tjttrkskahi = new ExDBFieldString<>("tjttrkskahi", this, UserType_C_KahiKbn.class);

    public final ExDBFieldNumber<BT_KinouHukaInfo, Integer> kensuuhyoujijyun = new ExDBFieldNumber<>("kensuuhyoujijyun", this);
}
