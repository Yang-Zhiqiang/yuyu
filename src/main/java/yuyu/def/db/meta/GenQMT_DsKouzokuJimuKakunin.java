package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DsKzkJmKknHsJyKbn;
import yuyu.def.db.entity.MT_DsKouzokuJimuKakunin;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_DsKzkJmKknHsJyKbn;

/**
 * ＤＳ後続事務確認テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMT_DsKouzokuJimuKakunin extends AbstractExDBTable<MT_DsKouzokuJimuKakunin> {

    public GenQMT_DsKouzokuJimuKakunin() {
        this("MT_DsKouzokuJimuKakunin");
    }

    public GenQMT_DsKouzokuJimuKakunin(String pAlias) {
        super("MT_DsKouzokuJimuKakunin", MT_DsKouzokuJimuKakunin.class, pAlias);
    }

    public String MT_DsKouzokuJimuKakunin() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MT_DsKouzokuJimuKakunin, BizDate> hasseiymd = new ExDBFieldString<>("hasseiymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsKouzokuJimuKakunin, C_DsKzkJmKknHsJyKbn> dskzkjmkknhsjykbn = new ExDBFieldString<>("dskzkjmkknhsjykbn", this, UserType_C_DsKzkJmKknHsJyKbn.class);

    public final ExDBFieldString<MT_DsKouzokuJimuKakunin, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<MT_DsKouzokuJimuKakunin, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<MT_DsKouzokuJimuKakunin, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<MT_DsKouzokuJimuKakunin, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
