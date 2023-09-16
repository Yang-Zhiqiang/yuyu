package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_3daiSippeiKbn;
import yuyu.def.classification.C_7daiSippeiKbn;
import yuyu.def.classification.C_GanKbn;
import yuyu.def.classification.C_KansensyouKbn;
import yuyu.def.db.entity.JT_SkByoumei;
import yuyu.def.db.type.UserType_C_3daiSippeiKbn;
import yuyu.def.db.type.UserType_C_7daiSippeiKbn;
import yuyu.def.db.type.UserType_C_GanKbn;
import yuyu.def.db.type.UserType_C_KansensyouKbn;

/**
 * 請求病名テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SkByoumei extends AbstractExDBTable<JT_SkByoumei> {

    public GenQJT_SkByoumei() {
        this("JT_SkByoumei");
    }

    public GenQJT_SkByoumei(String pAlias) {
        super("JT_SkByoumei", JT_SkByoumei.class, pAlias);
    }

    public String JT_SkByoumei() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SkByoumei, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_SkByoumei, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<JT_SkByoumei, Integer> seikyuurirekino = new ExDBFieldNumber<>("seikyuurirekino", this);

    public final ExDBFieldNumber<JT_SkByoumei, Integer> uketukeno = new ExDBFieldNumber<>("uketukeno", this);

    public final ExDBFieldNumber<JT_SkByoumei, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<JT_SkByoumei, String> byoumeitourokuno = new ExDBFieldString<>("byoumeitourokuno", this);

    public final ExDBFieldString<JT_SkByoumei, String> byoumeikn = new ExDBFieldString<>("byoumeikn", this);

    public final ExDBFieldString<JT_SkByoumei, String> byoumeikj = new ExDBFieldString<>("byoumeikj", this);

    public final ExDBFieldString<JT_SkByoumei, C_GanKbn> gankbn = new ExDBFieldString<>("gankbn", this, UserType_C_GanKbn.class);

    public final ExDBFieldString<JT_SkByoumei, C_3daiSippeiKbn> sandaisippeikbn = new ExDBFieldString<>("sandaisippeikbn", this, UserType_C_3daiSippeiKbn.class);

    public final ExDBFieldString<JT_SkByoumei, C_7daiSippeiKbn> nanadaisippeikbn = new ExDBFieldString<>("nanadaisippeikbn", this, UserType_C_7daiSippeiKbn.class);

    public final ExDBFieldString<JT_SkByoumei, C_KansensyouKbn> kansensyoukbn = new ExDBFieldString<>("kansensyoukbn", this, UserType_C_KansensyouKbn.class);

    public final ExDBFieldString<JT_SkByoumei, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_SkByoumei, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_SkByoumei, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_SkByoumei, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
