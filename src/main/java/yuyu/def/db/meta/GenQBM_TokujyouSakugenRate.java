package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Tkjyskgnkkn;
import yuyu.def.db.entity.BM_TokujyouSakugenRate;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Tkjyskgnkkn;

/**
 * 特条削減率マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_TokujyouSakugenRate extends AbstractExDBTable<BM_TokujyouSakugenRate> {

    public GenQBM_TokujyouSakugenRate() {
        this("BM_TokujyouSakugenRate");
    }

    public GenQBM_TokujyouSakugenRate(String pAlias) {
        super("BM_TokujyouSakugenRate", BM_TokujyouSakugenRate.class, pAlias);
    }

    public String BM_TokujyouSakugenRate() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_TokujyouSakugenRate, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<BM_TokujyouSakugenRate, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldString<BM_TokujyouSakugenRate, C_Tkjyskgnkkn> tkjyskgnkkn = new ExDBFieldString<>("tkjyskgnkkn", this, UserType_C_Tkjyskgnkkn.class);

    public final ExDBFieldString<BM_TokujyouSakugenRate, BizNumber> dai1hknnndskgnsrate = new ExDBFieldString<>("dai1hknnndskgnsrate", this, BizNumberType.class);

    public final ExDBFieldString<BM_TokujyouSakugenRate, BizNumber> dai2hknnndskgnsrate = new ExDBFieldString<>("dai2hknnndskgnsrate", this, BizNumberType.class);

    public final ExDBFieldString<BM_TokujyouSakugenRate, BizNumber> dai3hknnndskgnsrate = new ExDBFieldString<>("dai3hknnndskgnsrate", this, BizNumberType.class);

    public final ExDBFieldString<BM_TokujyouSakugenRate, BizNumber> dai4hknnndskgnsrate = new ExDBFieldString<>("dai4hknnndskgnsrate", this, BizNumberType.class);

    public final ExDBFieldString<BM_TokujyouSakugenRate, BizNumber> dai5hknnndskgnsrate = new ExDBFieldString<>("dai5hknnndskgnsrate", this, BizNumberType.class);

    public final ExDBFieldString<BM_TokujyouSakugenRate, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<BM_TokujyouSakugenRate, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BM_TokujyouSakugenRate, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
