package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.classification.C_NoinitYouhiKbn;
import yuyu.def.db.entity.JT_SibouSateiChkInfo;
import yuyu.def.db.type.UserType_C_NoinitUmuKbn;
import yuyu.def.db.type.UserType_C_NoinitYouhiKbn;

/**
 * 死亡査定チェック情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SibouSateiChkInfo extends AbstractExDBTable<JT_SibouSateiChkInfo> {

    public GenQJT_SibouSateiChkInfo() {
        this("JT_SibouSateiChkInfo");
    }

    public GenQJT_SibouSateiChkInfo(String pAlias) {
        super("JT_SibouSateiChkInfo", JT_SibouSateiChkInfo.class, pAlias);
    }

    public String JT_SibouSateiChkInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SibouSateiChkInfo, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_SibouSateiChkInfo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<JT_SibouSateiChkInfo, Integer> seikyuurirekino = new ExDBFieldNumber<>("seikyuurirekino", this);

    public final ExDBFieldString<JT_SibouSateiChkInfo, C_NoinitUmuKbn> bengosikenkaiumukbn = new ExDBFieldString<>("bengosikenkaiumukbn", this, UserType_C_NoinitUmuKbn.class);

    public final ExDBFieldString<JT_SibouSateiChkInfo, C_NoinitUmuKbn> kujyouumukbn = new ExDBFieldString<>("kujyouumukbn", this, UserType_C_NoinitUmuKbn.class);

    public final ExDBFieldString<JT_SibouSateiChkInfo, C_NoinitUmuKbn> jimumissumukbn = new ExDBFieldString<>("jimumissumukbn", this, UserType_C_NoinitUmuKbn.class);

    public final ExDBFieldString<JT_SibouSateiChkInfo, C_NoinitYouhiKbn> kyhgksitukaisouyouhikbn = new ExDBFieldString<>("kyhgksitukaisouyouhikbn", this, UserType_C_NoinitYouhiKbn.class);

    public final ExDBFieldString<JT_SibouSateiChkInfo, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_SibouSateiChkInfo, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_SibouSateiChkInfo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_SibouSateiChkInfo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
