package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KyokaKbn;
import yuyu.def.classification.C_PasswordYuukouKikanKbn;
import yuyu.def.classification.C_SpecialUserKbn;
import yuyu.def.classification.C_YoukyuuKbn;
import yuyu.def.db.entity.BW_UserWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_KyokaKbn;
import yuyu.def.db.type.UserType_C_PasswordYuukouKikanKbn;
import yuyu.def.db.type.UserType_C_SpecialUserKbn;
import yuyu.def.db.type.UserType_C_YoukyuuKbn;

/**
 * ユーザーマスタワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBW_UserWk extends AbstractExDBTable<BW_UserWk> {

    public GenQBW_UserWk() {
        this("BW_UserWk");
    }

    public GenQBW_UserWk(String pAlias) {
        super("BW_UserWk", BW_UserWk.class, pAlias);
    }

    public String BW_UserWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BW_UserWk, String> userId = new ExDBFieldString<>("userId", this);

    public final ExDBFieldString<BW_UserWk, String> userNm = new ExDBFieldString<>("userNm", this);

    public final ExDBFieldString<BW_UserWk, String> userGroupCd = new ExDBFieldString<>("userGroupCd", this);

    public final ExDBFieldString<BW_UserWk, C_SpecialUserKbn> specialUserKbn = new ExDBFieldString<>("specialUserKbn", this, UserType_C_SpecialUserKbn.class);

    public final ExDBFieldString<BW_UserWk, String> password = new ExDBFieldString<>("password", this);

    public final ExDBFieldString<BW_UserWk, BizDate> passwordSetteiYmd = new ExDBFieldString<>("passwordSetteiYmd", this, BizDateType.class);

    public final ExDBFieldString<BW_UserWk, BizDate> passwordYuukouKigenYmd = new ExDBFieldString<>("passwordYuukouKigenYmd", this, BizDateType.class);

    public final ExDBFieldNumber<BW_UserWk, Integer> passwordYuukouCountY = new ExDBFieldNumber<>("passwordYuukouCountY", this);

    public final ExDBFieldNumber<BW_UserWk, Integer> passwordYuukouCountM = new ExDBFieldNumber<>("passwordYuukouCountM", this);

    public final ExDBFieldNumber<BW_UserWk, Integer> passwordYuukouCountD = new ExDBFieldNumber<>("passwordYuukouCountD", this);

    public final ExDBFieldString<BW_UserWk, C_PasswordYuukouKikanKbn> passwordYuukouKikanKbn = new ExDBFieldString<>("passwordYuukouKikanKbn", this, UserType_C_PasswordYuukouKikanKbn.class);

    public final ExDBFieldString<BW_UserWk, C_KyokaKbn> passwordHenkouKyokaKbn = new ExDBFieldString<>("passwordHenkouKyokaKbn", this, UserType_C_KyokaKbn.class);

    public final ExDBFieldString<BW_UserWk, C_YoukyuuKbn> passwordHenkouYoukyuuKbn = new ExDBFieldString<>("passwordHenkouYoukyuuKbn", this, UserType_C_YoukyuuKbn.class);

    public final ExDBFieldString<BW_UserWk, C_KyokaKbn> loginKyokaKbn = new ExDBFieldString<>("loginKyokaKbn", this, UserType_C_KyokaKbn.class);

    public final ExDBFieldNumber<BW_UserWk, Integer> loginErrorCount = new ExDBFieldNumber<>("loginErrorCount", this);

    public final ExDBFieldString<BW_UserWk, String> lastLoginTime = new ExDBFieldString<>("lastLoginTime", this);
}
