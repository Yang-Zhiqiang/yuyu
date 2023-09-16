package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DsTrhkserviceKanyukeiroKbn;
import yuyu.def.classification.C_DsTrhkserviceRiyoujkKbn;
import yuyu.def.classification.C_DsTrhkserviceTeisiRiyuuKbn;
import yuyu.def.db.entity.MT_DsTorihikiServiceKanri;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_DsTrhkserviceKanyukeiroKbn;
import yuyu.def.db.type.UserType_C_DsTrhkserviceRiyoujkKbn;
import yuyu.def.db.type.UserType_C_DsTrhkserviceTeisiRiyuuKbn;

/**
 * ＤＳ取引サービス管理テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMT_DsTorihikiServiceKanri extends AbstractExDBTable<MT_DsTorihikiServiceKanri> {

    public GenQMT_DsTorihikiServiceKanri() {
        this("MT_DsTorihikiServiceKanri");
    }

    public GenQMT_DsTorihikiServiceKanri(String pAlias) {
        super("MT_DsTorihikiServiceKanri", MT_DsTorihikiServiceKanri.class, pAlias);
    }

    public String MT_DsTorihikiServiceKanri() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MT_DsTorihikiServiceKanri, String> dskokno = new ExDBFieldString<>("dskokno", this);

    public final ExDBFieldString<MT_DsTorihikiServiceKanri, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<MT_DsTorihikiServiceKanri, C_DsTrhkserviceRiyoujkKbn> dstrhkserviceriyoujkkbn = new ExDBFieldString<>("dstrhkserviceriyoujkkbn", this, UserType_C_DsTrhkserviceRiyoujkKbn.class);

    public final ExDBFieldString<MT_DsTorihikiServiceKanri, C_DsTrhkserviceTeisiRiyuuKbn> dstrhkserviceteisiriyuukbn = new ExDBFieldString<>("dstrhkserviceteisiriyuukbn", this, UserType_C_DsTrhkserviceTeisiRiyuuKbn.class);

    public final ExDBFieldString<MT_DsTorihikiServiceKanri, BizDate> dstrhkservicetourokuymd = new ExDBFieldString<>("dstrhkservicetourokuymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsTorihikiServiceKanri, BizDate> dstrhkservicemukouymd = new ExDBFieldString<>("dstrhkservicemukouymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsTorihikiServiceKanri, C_DsTrhkserviceKanyukeiroKbn> dstrhkservicekanyukeirokbn = new ExDBFieldString<>("dstrhkservicekanyukeirokbn", this, UserType_C_DsTrhkserviceKanyukeiroKbn.class);

    public final ExDBFieldString<MT_DsTorihikiServiceKanri, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<MT_DsTorihikiServiceKanri, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<MT_DsTorihikiServiceKanri, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
