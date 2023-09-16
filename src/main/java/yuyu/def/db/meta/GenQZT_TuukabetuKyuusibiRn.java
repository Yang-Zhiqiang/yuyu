package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_TuukabetuKyuusibiRn;

/**
 * 通貨別休止日取扱休止日Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_TuukabetuKyuusibiRn extends AbstractExDBTable<ZT_TuukabetuKyuusibiRn> {

    public GenQZT_TuukabetuKyuusibiRn() {
        this("ZT_TuukabetuKyuusibiRn");
    }

    public GenQZT_TuukabetuKyuusibiRn(String pAlias) {
        super("ZT_TuukabetuKyuusibiRn", ZT_TuukabetuKyuusibiRn.class, pAlias);
    }

    public String ZT_TuukabetuKyuusibiRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_TuukabetuKyuusibiRn, String> zrntekiyouymd = new ExDBFieldString<>("zrntekiyouymd", this);

    public final ExDBFieldString<ZT_TuukabetuKyuusibiRn, String> zrnenkyuusibikbn = new ExDBFieldString<>("zrnenkyuusibikbn", this);

    public final ExDBFieldString<ZT_TuukabetuKyuusibiRn, String> zrnbeidorukyuusibikbn = new ExDBFieldString<>("zrnbeidorukyuusibikbn", this);

    public final ExDBFieldString<ZT_TuukabetuKyuusibiRn, String> zrneurkyuusibikbn = new ExDBFieldString<>("zrneurkyuusibikbn", this);

    public final ExDBFieldString<ZT_TuukabetuKyuusibiRn, String> zrngoudorukyuusibikbn = new ExDBFieldString<>("zrngoudorukyuusibikbn", this);
}
