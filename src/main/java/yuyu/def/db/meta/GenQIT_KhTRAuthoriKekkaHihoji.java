package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AuthorijkKbn;
import yuyu.def.classification.C_CardBrandKbn;
import yuyu.def.db.entity.IT_KhTRAuthoriKekkaHihoji;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_AuthorijkKbn;
import yuyu.def.db.type.UserType_C_CardBrandKbn;

/**
 * オーソリ結果ＴＲ（クレカ非保持）テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KhTRAuthoriKekkaHihoji extends AbstractExDBTable<IT_KhTRAuthoriKekkaHihoji> {

    public GenQIT_KhTRAuthoriKekkaHihoji() {
        this("IT_KhTRAuthoriKekkaHihoji");
    }

    public GenQIT_KhTRAuthoriKekkaHihoji(String pAlias) {
        super("IT_KhTRAuthoriKekkaHihoji", IT_KhTRAuthoriKekkaHihoji.class, pAlias);
    }

    public String IT_KhTRAuthoriKekkaHihoji() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KhTRAuthoriKekkaHihoji, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);

    public final ExDBFieldString<IT_KhTRAuthoriKekkaHihoji, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhTRAuthoriKekkaHihoji, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KhTRAuthoriKekkaHihoji, C_CardBrandKbn> cardbrandkbn = new ExDBFieldString<>("cardbrandkbn", this, UserType_C_CardBrandKbn.class);

    public final ExDBFieldString<IT_KhTRAuthoriKekkaHihoji, String> creditkaiinnosimo4keta = new ExDBFieldString<>("creditkaiinnosimo4keta", this);

    public final ExDBFieldString<IT_KhTRAuthoriKekkaHihoji, C_AuthorijkKbn> authorijkkbn = new ExDBFieldString<>("authorijkkbn", this, UserType_C_AuthorijkKbn.class);

    public final ExDBFieldString<IT_KhTRAuthoriKekkaHihoji, String> datajyusinymd = new ExDBFieldString<>("datajyusinymd", this);

    public final ExDBFieldString<IT_KhTRAuthoriKekkaHihoji, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KhTRAuthoriKekkaHihoji, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KhTRAuthoriKekkaHihoji, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
