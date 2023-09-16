package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.MT_DsTorihikiyouAnsyono;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;

/**
 * ＤＳ特定取引用暗証番号テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMT_DsTorihikiyouAnsyono extends AbstractExDBTable<MT_DsTorihikiyouAnsyono> {

    public GenQMT_DsTorihikiyouAnsyono() {
        this("MT_DsTorihikiyouAnsyono");
    }

    public GenQMT_DsTorihikiyouAnsyono(String pAlias) {
        super("MT_DsTorihikiyouAnsyono", MT_DsTorihikiyouAnsyono.class, pAlias);
    }

    public String MT_DsTorihikiyouAnsyono() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MT_DsTorihikiyouAnsyono, String> dskokno = new ExDBFieldString<>("dskokno", this);

    public final ExDBFieldString<MT_DsTorihikiyouAnsyono, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<MT_DsTorihikiyouAnsyono, String> tokuteitrhkansyono = new ExDBFieldString<>("tokuteitrhkansyono", this);

    public final ExDBFieldNumber<MT_DsTorihikiyouAnsyono, Integer> tktrhkansyonoerrorkaisuu = new ExDBFieldNumber<>("tktrhkansyonoerrorkaisuu", this);

    public final ExDBFieldString<MT_DsTorihikiyouAnsyono, BizDate> setymd = new ExDBFieldString<>("setymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsTorihikiyouAnsyono, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<MT_DsTorihikiyouAnsyono, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<MT_DsTorihikiyouAnsyono, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
