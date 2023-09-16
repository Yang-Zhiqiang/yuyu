package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_Tuuka;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 通貨マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_Tuuka extends AbstractExDBTable<BM_Tuuka> {

    public GenQBM_Tuuka() {
        this("BM_Tuuka");
    }

    public GenQBM_Tuuka(String pAlias) {
        super("BM_Tuuka", BM_Tuuka.class, pAlias);
    }

    public String BM_Tuuka() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_Tuuka, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldNumber<BM_Tuuka, Integer> ssketasuu = new ExDBFieldNumber<>("ssketasuu", this);

    public final ExDBFieldString<BM_Tuuka, String> tuukasyumei = new ExDBFieldString<>("tuukasyumei", this);

    public final ExDBFieldString<BM_Tuuka, String> tuukasyuryk = new ExDBFieldString<>("tuukasyuryk", this);

    public final ExDBFieldString<BM_Tuuka, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<BM_Tuuka, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BM_Tuuka, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
