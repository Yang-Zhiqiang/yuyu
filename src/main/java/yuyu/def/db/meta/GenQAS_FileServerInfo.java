package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_YesNoKbn;
import yuyu.def.db.entity.AS_FileServerInfo;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_YesNoKbn;

/**
 * ファイルサーバー情報基幹テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAS_FileServerInfo extends AbstractExDBTable<AS_FileServerInfo> {

    public GenQAS_FileServerInfo() {
        this("AS_FileServerInfo");
    }

    public GenQAS_FileServerInfo(String pAlias) {
        super("AS_FileServerInfo", AS_FileServerInfo.class, pAlias);
    }

    public String AS_FileServerInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<AS_FileServerInfo, Integer> setteiNo = new ExDBFieldNumber<>("setteiNo", this);

    public final ExDBFieldString<AS_FileServerInfo, BizDate> tekiyouYmdFrom = new ExDBFieldString<>("tekiyouYmdFrom", this, BizDateType.class);

    public final ExDBFieldString<AS_FileServerInfo, String> setteiNm = new ExDBFieldString<>("setteiNm", this);

    public final ExDBFieldString<AS_FileServerInfo, String> setuzokusakiDomain = new ExDBFieldString<>("setuzokusakiDomain", this);

    public final ExDBFieldString<AS_FileServerInfo, String> setuzokusakiIpAddress = new ExDBFieldString<>("setuzokusakiIpAddress", this);

    public final ExDBFieldString<AS_FileServerInfo, String> setuzokusakiPortNo = new ExDBFieldString<>("setuzokusakiPortNo", this);

    public final ExDBFieldString<AS_FileServerInfo, String> setuzokuUser = new ExDBFieldString<>("setuzokuUser", this);

    public final ExDBFieldString<AS_FileServerInfo, String> setuzokuPassword = new ExDBFieldString<>("setuzokuPassword", this);

    public final ExDBFieldString<AS_FileServerInfo, C_YesNoKbn> angoukaKbn = new ExDBFieldString<>("angoukaKbn", this, UserType_C_YesNoKbn.class);
}
