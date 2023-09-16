package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.IT_KoujyoSymKanri;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;

/**
 * 控除証明書管理テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KoujyoSymKanri extends AbstractExDBTable<IT_KoujyoSymKanri> {

    public GenQIT_KoujyoSymKanri() {
        this("IT_KoujyoSymKanri");
    }

    public GenQIT_KoujyoSymKanri(String pAlias) {
        super("IT_KoujyoSymKanri", IT_KoujyoSymKanri.class, pAlias);
    }

    public String IT_KoujyoSymKanri() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KoujyoSymKanri, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_KoujyoSymKanri, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KoujyoSymKanri, String> nendo = new ExDBFieldString<>("nendo", this);

    public final ExDBFieldString<IT_KoujyoSymKanri, BizDateYM> lastsyoumeiendym = new ExDBFieldString<>("lastsyoumeiendym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_KoujyoSymKanri, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KoujyoSymKanri, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KoujyoSymKanri, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
