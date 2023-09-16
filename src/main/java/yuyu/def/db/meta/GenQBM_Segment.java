package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Segcd;
import yuyu.def.db.entity.BM_Segment;
import yuyu.def.db.type.UserType_C_Segcd;

/**
 * セグメントマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_Segment extends AbstractExDBTable<BM_Segment> {

    public GenQBM_Segment() {
        this("BM_Segment");
    }

    public GenQBM_Segment(String pAlias) {
        super("BM_Segment", BM_Segment.class, pAlias);
    }

    public String BM_Segment() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_Segment, C_Segcd> segcd = new ExDBFieldString<>("segcd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<BM_Segment, String> segnm = new ExDBFieldString<>("segnm", this);

    public final ExDBFieldString<BM_Segment, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BM_Segment, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
