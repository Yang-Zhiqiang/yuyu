package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.classification.C_NoinitYouhiKbn;
import yuyu.def.classification.C_ShrsakiSeikyuusyaKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.JT_KoudosgSateiChkInfo;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_NoinitUmuKbn;
import yuyu.def.db.type.UserType_C_NoinitYouhiKbn;
import yuyu.def.db.type.UserType_C_ShrsakiSeikyuusyaKbn;
import yuyu.def.db.type.UserType_C_YouhiKbn;

/**
 * 高度障害査定チェック情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_KoudosgSateiChkInfo extends AbstractExDBTable<JT_KoudosgSateiChkInfo> {

    public GenQJT_KoudosgSateiChkInfo() {
        this("JT_KoudosgSateiChkInfo");
    }

    public GenQJT_KoudosgSateiChkInfo(String pAlias) {
        super("JT_KoudosgSateiChkInfo", JT_KoudosgSateiChkInfo.class, pAlias);
    }

    public String JT_KoudosgSateiChkInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_KoudosgSateiChkInfo, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_KoudosgSateiChkInfo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<JT_KoudosgSateiChkInfo, Integer> seikyuurirekino = new ExDBFieldNumber<>("seikyuurirekino", this);

    public final ExDBFieldString<JT_KoudosgSateiChkInfo, C_NoinitUmuKbn> gengkumukbn = new ExDBFieldString<>("gengkumukbn", this, UserType_C_NoinitUmuKbn.class);

    public final ExDBFieldString<JT_KoudosgSateiChkInfo, BizDate> gengkymd = new ExDBFieldString<>("gengkymd", this, BizDateType.class);

    public final ExDBFieldString<JT_KoudosgSateiChkInfo, String> gengkcomment = new ExDBFieldString<>("gengkcomment", this);

    public final ExDBFieldString<JT_KoudosgSateiChkInfo, C_NoinitUmuKbn> skisinouryokuumukbn = new ExDBFieldString<>("skisinouryokuumukbn", this, UserType_C_NoinitUmuKbn.class);

    public final ExDBFieldString<JT_KoudosgSateiChkInfo, C_NoinitYouhiKbn> skisinouryokuttdktyuuikbn = new ExDBFieldString<>("skisinouryokuttdktyuuikbn", this, UserType_C_NoinitYouhiKbn.class);

    public final ExDBFieldString<JT_KoudosgSateiChkInfo, String> skisinouryokucomment = new ExDBFieldString<>("skisinouryokucomment", this);

    public final ExDBFieldString<JT_KoudosgSateiChkInfo, C_ShrsakiSeikyuusyaKbn> shrsakiseikyuusyakbn = new ExDBFieldString<>("shrsakiseikyuusyakbn", this, UserType_C_ShrsakiSeikyuusyaKbn.class);

    public final ExDBFieldString<JT_KoudosgSateiChkInfo, String> shrsakicomment = new ExDBFieldString<>("shrsakicomment", this);

    public final ExDBFieldString<JT_KoudosgSateiChkInfo, C_YouhiKbn> kyhkaisyuuyouhiikbn = new ExDBFieldString<>("kyhkaisyuuyouhiikbn", this, UserType_C_YouhiKbn.class);

    public final ExDBFieldString<JT_KoudosgSateiChkInfo, String> kyhkaisyuuyouhiicomment = new ExDBFieldString<>("kyhkaisyuuyouhiicomment", this);

    public final ExDBFieldString<JT_KoudosgSateiChkInfo, C_NoinitUmuKbn> danpozaikeiumukbn = new ExDBFieldString<>("danpozaikeiumukbn", this, UserType_C_NoinitUmuKbn.class);

    public final ExDBFieldString<JT_KoudosgSateiChkInfo, String> danpozaikeicomment = new ExDBFieldString<>("danpozaikeicomment", this);

    public final ExDBFieldString<JT_KoudosgSateiChkInfo, C_NoinitUmuKbn> bengosikenkaiumukbn = new ExDBFieldString<>("bengosikenkaiumukbn", this, UserType_C_NoinitUmuKbn.class);

    public final ExDBFieldString<JT_KoudosgSateiChkInfo, C_NoinitUmuKbn> kujyouumukbn = new ExDBFieldString<>("kujyouumukbn", this, UserType_C_NoinitUmuKbn.class);

    public final ExDBFieldString<JT_KoudosgSateiChkInfo, C_NoinitUmuKbn> jimumissumukbn = new ExDBFieldString<>("jimumissumukbn", this, UserType_C_NoinitUmuKbn.class);

    public final ExDBFieldString<JT_KoudosgSateiChkInfo, C_NoinitYouhiKbn> kyhgksitukaisouyouhikbn = new ExDBFieldString<>("kyhgksitukaisouyouhikbn", this, UserType_C_NoinitYouhiKbn.class);

    public final ExDBFieldString<JT_KoudosgSateiChkInfo, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_KoudosgSateiChkInfo, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_KoudosgSateiChkInfo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_KoudosgSateiChkInfo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
