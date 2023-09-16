package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.IT_BAK_KoujyoSymKanri;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;

/**
 * 控除証明書管理バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_KoujyoSymKanri extends AbstractExDBTable<IT_BAK_KoujyoSymKanri> {

    public GenQIT_BAK_KoujyoSymKanri() {
        this("IT_BAK_KoujyoSymKanri");
    }

    public GenQIT_BAK_KoujyoSymKanri(String pAlias) {
        super("IT_BAK_KoujyoSymKanri", IT_BAK_KoujyoSymKanri.class, pAlias);
    }

    public String IT_BAK_KoujyoSymKanri() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_KoujyoSymKanri, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_KoujyoSymKanri, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_KoujyoSymKanri, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_KoujyoSymKanri, String> nendo = new ExDBFieldString<>("nendo", this);

    public final ExDBFieldString<IT_BAK_KoujyoSymKanri, BizDateYM> lastsyoumeiendym = new ExDBFieldString<>("lastsyoumeiendym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_BAK_KoujyoSymKanri, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_KoujyoSymKanri, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_KoujyoSymKanri, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
