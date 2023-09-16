package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DsHanyouKokyakuateTuutiKbn;
import yuyu.def.db.entity.MT_DsHanyouKokyakuateTuuti2;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_DsHanyouKokyakuateTuutiKbn;

/**
 * ＤＳ汎用顧客宛通知２テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMT_DsHanyouKokyakuateTuuti2 extends AbstractExDBTable<MT_DsHanyouKokyakuateTuuti2> {

    public GenQMT_DsHanyouKokyakuateTuuti2() {
        this("MT_DsHanyouKokyakuateTuuti2");
    }

    public GenQMT_DsHanyouKokyakuateTuuti2(String pAlias) {
        super("MT_DsHanyouKokyakuateTuuti2", MT_DsHanyouKokyakuateTuuti2.class, pAlias);
    }

    public String MT_DsHanyouKokyakuateTuuti2() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MT_DsHanyouKokyakuateTuuti2, BizDate> dsdatasakuseiymd = new ExDBFieldString<>("dsdatasakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsHanyouKokyakuateTuuti2, String> dskoktuutirenno = new ExDBFieldString<>("dskoktuutirenno", this);

    public final ExDBFieldString<MT_DsHanyouKokyakuateTuuti2, String> dskokno = new ExDBFieldString<>("dskokno", this);

    public final ExDBFieldString<MT_DsHanyouKokyakuateTuuti2, C_DsHanyouKokyakuateTuutiKbn> dshanyoukokyakuatetuutikbn = new ExDBFieldString<>("dshanyoukokyakuatetuutikbn", this, UserType_C_DsHanyouKokyakuateTuutiKbn.class);

    public final ExDBFieldString<MT_DsHanyouKokyakuateTuuti2, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<MT_DsHanyouKokyakuateTuuti2, String> dssousinno = new ExDBFieldString<>("dssousinno", this);

    public final ExDBFieldString<MT_DsHanyouKokyakuateTuuti2, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<MT_DsHanyouKokyakuateTuuti2, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<MT_DsHanyouKokyakuateTuuti2, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
