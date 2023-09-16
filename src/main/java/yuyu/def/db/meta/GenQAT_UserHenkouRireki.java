package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KyokaKbn;
import yuyu.def.classification.C_PasswordYuukouKikanKbn;
import yuyu.def.classification.C_RirekiSyuruiKbn;
import yuyu.def.classification.C_SpecialUserKbn;
import yuyu.def.classification.C_YoukyuuKbn;
import yuyu.def.db.entity.AT_UserHenkouRireki;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_KyokaKbn;
import yuyu.def.db.type.UserType_C_PasswordYuukouKikanKbn;
import yuyu.def.db.type.UserType_C_RirekiSyuruiKbn;
import yuyu.def.db.type.UserType_C_SpecialUserKbn;
import yuyu.def.db.type.UserType_C_YoukyuuKbn;

/**
 * ユーザー変更履歴テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_UserHenkouRireki extends AbstractExDBTable<AT_UserHenkouRireki> {

    public GenQAT_UserHenkouRireki() {
        this("AT_UserHenkouRireki");
    }

    public GenQAT_UserHenkouRireki(String pAlias) {
        super("AT_UserHenkouRireki", AT_UserHenkouRireki.class, pAlias);
    }

    public String AT_UserHenkouRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_UserHenkouRireki, String> uniqueId = new ExDBFieldString<>("uniqueId", this);

    public final ExDBFieldString<AT_UserHenkouRireki, String> userId = new ExDBFieldString<>("userId", this);

    public final ExDBFieldString<AT_UserHenkouRireki, C_RirekiSyuruiKbn> rirekiSyuruiKbn = new ExDBFieldString<>("rirekiSyuruiKbn", this, UserType_C_RirekiSyuruiKbn.class);

    public final ExDBFieldString<AT_UserHenkouRireki, String> userNm = new ExDBFieldString<>("userNm", this);

    public final ExDBFieldString<AT_UserHenkouRireki, C_SpecialUserKbn> specialUserKbn = new ExDBFieldString<>("specialUserKbn", this, UserType_C_SpecialUserKbn.class);

    public final ExDBFieldString<AT_UserHenkouRireki, String> password = new ExDBFieldString<>("password", this);

    public final ExDBFieldString<AT_UserHenkouRireki, BizDate> passwordSetteiYmd = new ExDBFieldString<>("passwordSetteiYmd", this, BizDateType.class);

    public final ExDBFieldString<AT_UserHenkouRireki, BizDate> passwordYuukouKigenYmd = new ExDBFieldString<>("passwordYuukouKigenYmd", this, BizDateType.class);

    public final ExDBFieldNumber<AT_UserHenkouRireki, Integer> passwordYuukouCountY = new ExDBFieldNumber<>("passwordYuukouCountY", this);

    public final ExDBFieldNumber<AT_UserHenkouRireki, Integer> passwordYuukouCountM = new ExDBFieldNumber<>("passwordYuukouCountM", this);

    public final ExDBFieldNumber<AT_UserHenkouRireki, Integer> passwordYuukouCountD = new ExDBFieldNumber<>("passwordYuukouCountD", this);

    public final ExDBFieldString<AT_UserHenkouRireki, C_PasswordYuukouKikanKbn> passwordYuukouKikanKbn = new ExDBFieldString<>("passwordYuukouKikanKbn", this, UserType_C_PasswordYuukouKikanKbn.class);

    public final ExDBFieldString<AT_UserHenkouRireki, C_KyokaKbn> passwordHenkouKyokaKbn = new ExDBFieldString<>("passwordHenkouKyokaKbn", this, UserType_C_KyokaKbn.class);

    public final ExDBFieldString<AT_UserHenkouRireki, C_YoukyuuKbn> passwordHenkouYoukyuuKbn = new ExDBFieldString<>("passwordHenkouYoukyuuKbn", this, UserType_C_YoukyuuKbn.class);

    public final ExDBFieldString<AT_UserHenkouRireki, C_KyokaKbn> loginKyokaKbn = new ExDBFieldString<>("loginKyokaKbn", this, UserType_C_KyokaKbn.class);

    public final ExDBFieldNumber<AT_UserHenkouRireki, Integer> loginErrorCount = new ExDBFieldNumber<>("loginErrorCount", this);
}
