package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_UriageSousinTy;

/**
 * 売上送信Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_UriageSousinTy extends AbstractExDBTable<ZT_UriageSousinTy> {

    public GenQZT_UriageSousinTy() {
        this("ZT_UriageSousinTy");
    }

    public GenQZT_UriageSousinTy(String pAlias) {
        super("ZT_UriageSousinTy", ZT_UriageSousinTy.class, pAlias);
    }

    public String ZT_UriageSousinTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_UriageSousinTy, String> ztycreditkessaiyouno = new ExDBFieldString<>("ztycreditkessaiyouno", this);

    public final ExDBFieldString<ZT_UriageSousinTy, String> ztyauthorikbn = new ExDBFieldString<>("ztyauthorikbn", this);

    public final ExDBFieldString<ZT_UriageSousinTy, String> ztyuriageseikyuuymd = new ExDBFieldString<>("ztyuriageseikyuuymd", this);

    public final ExDBFieldNumber<ZT_UriageSousinTy, Long> ztyrsgaku = new ExDBFieldNumber<>("ztyrsgaku", this);

    public final ExDBFieldString<ZT_UriageSousinTy, String> ztyfukusuukameitennokey = new ExDBFieldString<>("ztyfukusuukameitennokey", this);

    public final ExDBFieldString<ZT_UriageSousinTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_UriageSousinTy, String> ztyrecordno = new ExDBFieldString<>("ztyrecordno", this);

    public final ExDBFieldString<ZT_UriageSousinTy, String> ztyuriagetaisyouym = new ExDBFieldString<>("ztyuriagetaisyouym", this);

    public final ExDBFieldString<ZT_UriageSousinTy, String> ztyyobiv33 = new ExDBFieldString<>("ztyyobiv33", this);
}
