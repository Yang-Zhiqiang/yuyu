package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.JM_TokusyuKyuHantei;

/**
 * 特定給付判定マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJM_TokusyuKyuHantei extends AbstractExDBTable<JM_TokusyuKyuHantei> {

    public GenQJM_TokusyuKyuHantei() {
        this("JM_TokusyuKyuHantei");
    }

    public GenQJM_TokusyuKyuHantei(String pAlias) {
        super("JM_TokusyuKyuHantei", JM_TokusyuKyuHantei.class, pAlias);
    }

    public String JM_TokusyuKyuHantei() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JM_TokusyuKyuHantei, String> byoumeitourokuno = new ExDBFieldString<>("byoumeitourokuno", this);

    public final ExDBFieldString<JM_TokusyuKyuHantei, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<JM_TokusyuKyuHantei, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldString<JM_TokusyuKyuHantei, String> tekiyoukknfrom = new ExDBFieldString<>("tekiyoukknfrom", this);

    public final ExDBFieldString<JM_TokusyuKyuHantei, String> tekiyoukknkto = new ExDBFieldString<>("tekiyoukknkto", this);

    public final ExDBFieldString<JM_TokusyuKyuHantei, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JM_TokusyuKyuHantei, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
