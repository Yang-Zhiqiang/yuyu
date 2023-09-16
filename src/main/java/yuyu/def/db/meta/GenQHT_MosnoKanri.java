package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.db.entity.HT_MosnoKanri;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_KahiKbn;

/**
 * 申込番号管理テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_MosnoKanri extends AbstractExDBTable<HT_MosnoKanri> {

    public GenQHT_MosnoKanri() {
        this("HT_MosnoKanri");
    }

    public GenQHT_MosnoKanri(String pAlias) {
        super("HT_MosnoKanri", HT_MosnoKanri.class, pAlias);
    }

    public String HT_MosnoKanri() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_MosnoKanri, String> mosno8keta = new ExDBFieldString<>("mosno8keta", this);

    public final ExDBFieldString<HT_MosnoKanri, C_KahiKbn> saibankahikbn = new ExDBFieldString<>("saibankahikbn", this, UserType_C_KahiKbn.class);

    public final ExDBFieldString<HT_MosnoKanri, BizDate> mossykykyoteiymd = new ExDBFieldString<>("mossykykyoteiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_MosnoKanri, BizDate> saibanymd = new ExDBFieldString<>("saibanymd", this, BizDateType.class);

    public final ExDBFieldString<HT_MosnoKanri, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_MosnoKanri, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
