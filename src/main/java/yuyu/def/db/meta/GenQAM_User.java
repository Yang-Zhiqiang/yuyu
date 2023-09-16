package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KyokaKbn;
import yuyu.def.classification.C_PasswordYuukouKikanKbn;
import yuyu.def.classification.C_SpecialUserKbn;
import yuyu.def.classification.C_YoukyuuKbn;
import yuyu.def.db.entity.AM_User;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_KyokaKbn;
import yuyu.def.db.type.UserType_C_PasswordYuukouKikanKbn;
import yuyu.def.db.type.UserType_C_SpecialUserKbn;
import yuyu.def.db.type.UserType_C_YoukyuuKbn;

/**
 * ユーザーマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAM_User extends AbstractExDBTable<AM_User> {

    public GenQAM_User() {
        this("AM_User");
    }

    public GenQAM_User(String pAlias) {
        super("AM_User", AM_User.class, pAlias);
    }

    public String AM_User() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AM_User, String> userId = new ExDBFieldString<>("userId", this);

    public final ExDBFieldString<AM_User, String> userNm = new ExDBFieldString<>("userNm", this);

    public final ExDBFieldString<AM_User, String> userGroupCd = new ExDBFieldString<>("userGroupCd", this);

    public final ExDBFieldString<AM_User, C_SpecialUserKbn> specialUserKbn = new ExDBFieldString<>("specialUserKbn", this, UserType_C_SpecialUserKbn.class);

    public final ExDBFieldString<AM_User, String> password = new ExDBFieldString<>("password", this);

    public final ExDBFieldString<AM_User, BizDate> passwordSetteiYmd = new ExDBFieldString<>("passwordSetteiYmd", this, BizDateType.class);

    public final ExDBFieldString<AM_User, BizDate> passwordYuukouKigenYmd = new ExDBFieldString<>("passwordYuukouKigenYmd", this, BizDateType.class);

    public final ExDBFieldNumber<AM_User, Integer> passwordYuukouCountY = new ExDBFieldNumber<>("passwordYuukouCountY", this);

    public final ExDBFieldNumber<AM_User, Integer> passwordYuukouCountM = new ExDBFieldNumber<>("passwordYuukouCountM", this);

    public final ExDBFieldNumber<AM_User, Integer> passwordYuukouCountD = new ExDBFieldNumber<>("passwordYuukouCountD", this);

    public final ExDBFieldString<AM_User, C_PasswordYuukouKikanKbn> passwordYuukouKikanKbn = new ExDBFieldString<>("passwordYuukouKikanKbn", this, UserType_C_PasswordYuukouKikanKbn.class);

    public final ExDBFieldString<AM_User, C_KyokaKbn> passwordHenkouKyokaKbn = new ExDBFieldString<>("passwordHenkouKyokaKbn", this, UserType_C_KyokaKbn.class);

    public final ExDBFieldString<AM_User, C_YoukyuuKbn> passwordHenkouYoukyuuKbn = new ExDBFieldString<>("passwordHenkouYoukyuuKbn", this, UserType_C_YoukyuuKbn.class);

    public final ExDBFieldString<AM_User, C_KyokaKbn> loginKyokaKbn = new ExDBFieldString<>("loginKyokaKbn", this, UserType_C_KyokaKbn.class);

    public final ExDBFieldNumber<AM_User, Integer> loginErrorCount = new ExDBFieldNumber<>("loginErrorCount", this);

    public final ExDBFieldString<AM_User, String> lastLoginTime = new ExDBFieldString<>("lastLoginTime", this);
}
