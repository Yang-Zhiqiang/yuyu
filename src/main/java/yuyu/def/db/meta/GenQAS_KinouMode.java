package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_YuukouKbn;
import yuyu.def.db.entity.AS_KinouMode;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_KahiKbn;
import yuyu.def.db.type.UserType_C_YuukouKbn;

/**
 * 機能モード基幹テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAS_KinouMode extends AbstractExDBTable<AS_KinouMode> {

    public GenQAS_KinouMode() {
        this("AS_KinouMode");
    }

    public GenQAS_KinouMode(String pAlias) {
        super("AS_KinouMode", AS_KinouMode.class, pAlias);
    }

    public String AS_KinouMode() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AS_KinouMode, String> kinouId = new ExDBFieldString<>("kinouId", this);

    public final ExDBFieldString<AS_KinouMode, String> kinouModeId = new ExDBFieldString<>("kinouModeId", this);

    public final ExDBFieldString<AS_KinouMode, String> kinouModeNm = new ExDBFieldString<>("kinouModeNm", this);

    public final ExDBFieldNumber<AS_KinouMode, Integer> sortNo = new ExDBFieldNumber<>("sortNo", this);

    public final ExDBFieldString<AS_KinouMode, C_YuukouKbn> yuukouKbn = new ExDBFieldString<>("yuukouKbn", this, UserType_C_YuukouKbn.class);

    public final ExDBFieldString<AS_KinouMode, BizDate> yuukouKaisiYmd = new ExDBFieldString<>("yuukouKaisiYmd", this, BizDateType.class);

    public final ExDBFieldString<AS_KinouMode, String> kadouTimeGroupCd = new ExDBFieldString<>("kadouTimeGroupCd", this);

    public final ExDBFieldString<AS_KinouMode, C_KahiKbn> batchHeisouKahiKbn = new ExDBFieldString<>("batchHeisouKahiKbn", this, UserType_C_KahiKbn.class);
}
