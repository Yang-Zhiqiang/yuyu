package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DsKanyuuKeiroKbn;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsTeisiRiyuuKbn;
import yuyu.def.classification.C_SeisaHuyouHyj;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_DsKanyuuKeiroKbn;
import yuyu.def.db.type.UserType_C_DsKokyakuJtKbn;
import yuyu.def.db.type.UserType_C_DsTeisiRiyuuKbn;
import yuyu.def.db.type.UserType_C_SeisaHuyouHyj;

/**
 * ＤＳ顧客管理テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMT_DsKokyakuKanri extends AbstractExDBTable<MT_DsKokyakuKanri> {

    public GenQMT_DsKokyakuKanri() {
        this("MT_DsKokyakuKanri");
    }

    public GenQMT_DsKokyakuKanri(String pAlias) {
        super("MT_DsKokyakuKanri", MT_DsKokyakuKanri.class, pAlias);
    }

    public String MT_DsKokyakuKanri() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MT_DsKokyakuKanri, String> dskokno = new ExDBFieldString<>("dskokno", this);

    public final ExDBFieldString<MT_DsKokyakuKanri, C_DsKokyakuJtKbn> dskokyakujtkbn = new ExDBFieldString<>("dskokyakujtkbn", this, UserType_C_DsKokyakuJtKbn.class);

    public final ExDBFieldString<MT_DsKokyakuKanri, BizDate> dskokyakusakuseiymd = new ExDBFieldString<>("dskokyakusakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsKokyakuKanri, C_DsTeisiRiyuuKbn> dsteisiriyuukbn = new ExDBFieldString<>("dsteisiriyuukbn", this, UserType_C_DsTeisiRiyuuKbn.class);

    public final ExDBFieldString<MT_DsKokyakuKanri, BizDate> dskokyakumukouymd = new ExDBFieldString<>("dskokyakumukouymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsKokyakuKanri, C_SeisaHuyouHyj> seisahuyouhyj = new ExDBFieldString<>("seisahuyouhyj", this, UserType_C_SeisaHuyouHyj.class);

    public final ExDBFieldString<MT_DsKokyakuKanri, String> dskokyakunmkn = new ExDBFieldString<>("dskokyakunmkn", this);

    public final ExDBFieldString<MT_DsKokyakuKanri, String> dskokyakunmkj = new ExDBFieldString<>("dskokyakunmkj", this);

    public final ExDBFieldString<MT_DsKokyakuKanri, BizDate> dskokyakuseiymd = new ExDBFieldString<>("dskokyakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsKokyakuKanri, String> dskokyakuyno = new ExDBFieldString<>("dskokyakuyno", this);

    public final ExDBFieldString<MT_DsKokyakuKanri, C_DsKanyuuKeiroKbn> dskanyuukeirokbn = new ExDBFieldString<>("dskanyuukeirokbn", this, UserType_C_DsKanyuuKeiroKbn.class);

    public final ExDBFieldString<MT_DsKokyakuKanri, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<MT_DsKokyakuKanri, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<MT_DsKokyakuKanri, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);
}
