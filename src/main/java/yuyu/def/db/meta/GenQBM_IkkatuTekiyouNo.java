package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BM_IkkatuTekiyouNo;

/**
 * 一括払適用番号マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_IkkatuTekiyouNo extends AbstractExDBTable<BM_IkkatuTekiyouNo> {

    public GenQBM_IkkatuTekiyouNo() {
        this("BM_IkkatuTekiyouNo");
    }

    public GenQBM_IkkatuTekiyouNo(String pAlias) {
        super("BM_IkkatuTekiyouNo", BM_IkkatuTekiyouNo.class, pAlias);
    }

    public String BM_IkkatuTekiyouNo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_IkkatuTekiyouNo, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<BM_IkkatuTekiyouNo, String> ryouritusdno = new ExDBFieldString<>("ryouritusdno", this);

    public final ExDBFieldNumber<BM_IkkatuTekiyouNo, Integer> ikttekiyouno = new ExDBFieldNumber<>("ikttekiyouno", this);
}
