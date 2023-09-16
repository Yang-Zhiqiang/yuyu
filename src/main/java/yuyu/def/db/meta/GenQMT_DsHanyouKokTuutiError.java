package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DsHagakiSouhuJyoukyouKbn;
import yuyu.def.classification.C_DsHanyouKokyakuateTuutiKbn;
import yuyu.def.db.entity.MT_DsHanyouKokTuutiError;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_DsHagakiSouhuJyoukyouKbn;
import yuyu.def.db.type.UserType_C_DsHanyouKokyakuateTuutiKbn;

/**
 * ＤＳ汎用顧客宛通知エラーテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMT_DsHanyouKokTuutiError extends AbstractExDBTable<MT_DsHanyouKokTuutiError> {

    public GenQMT_DsHanyouKokTuutiError() {
        this("MT_DsHanyouKokTuutiError");
    }

    public GenQMT_DsHanyouKokTuutiError(String pAlias) {
        super("MT_DsHanyouKokTuutiError", MT_DsHanyouKokTuutiError.class, pAlias);
    }

    public String MT_DsHanyouKokTuutiError() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MT_DsHanyouKokTuutiError, BizDate> dsdatasakuseiymd = new ExDBFieldString<>("dsdatasakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsHanyouKokTuutiError, String> dskoktuutirenno = new ExDBFieldString<>("dskoktuutirenno", this);

    public final ExDBFieldString<MT_DsHanyouKokTuutiError, String> dskokno = new ExDBFieldString<>("dskokno", this);

    public final ExDBFieldString<MT_DsHanyouKokTuutiError, C_DsHanyouKokyakuateTuutiKbn> dshanyoukokyakuatetuutikbn = new ExDBFieldString<>("dshanyoukokyakuatetuutikbn", this, UserType_C_DsHanyouKokyakuateTuutiKbn.class);

    public final ExDBFieldString<MT_DsHanyouKokTuutiError, C_DsHagakiSouhuJyoukyouKbn> dshagakisouhujyoukyoukbn = new ExDBFieldString<>("dshagakisouhujyoukyoukbn", this, UserType_C_DsHagakiSouhuJyoukyouKbn.class);

    public final ExDBFieldString<MT_DsHanyouKokTuutiError, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<MT_DsHanyouKokTuutiError, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<MT_DsHanyouKokTuutiError, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
