package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_IkkatuTekiyouNo2;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 一括払適用番号マスタ２ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_IkkatuTekiyouNo2 extends AbstractExDBTable<BM_IkkatuTekiyouNo2> {

    public GenQBM_IkkatuTekiyouNo2() {
        this("BM_IkkatuTekiyouNo2");
    }

    public GenQBM_IkkatuTekiyouNo2(String pAlias) {
        super("BM_IkkatuTekiyouNo2", BM_IkkatuTekiyouNo2.class, pAlias);
    }

    public String BM_IkkatuTekiyouNo2() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_IkkatuTekiyouNo2, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<BM_IkkatuTekiyouNo2, String> ryouritusdno = new ExDBFieldString<>("ryouritusdno", this);

    public final ExDBFieldString<BM_IkkatuTekiyouNo2, BizNumber> yoteiriritu = new ExDBFieldString<>("yoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<BM_IkkatuTekiyouNo2, String> ikttekiyoubr1 = new ExDBFieldString<>("ikttekiyoubr1", this);

    public final ExDBFieldString<BM_IkkatuTekiyouNo2, String> ikttekiyoubr2 = new ExDBFieldString<>("ikttekiyoubr2", this);

    public final ExDBFieldString<BM_IkkatuTekiyouNo2, String> ikttekiyoubr3 = new ExDBFieldString<>("ikttekiyoubr3", this);

    public final ExDBFieldNumber<BM_IkkatuTekiyouNo2, Integer> ikttekiyouno = new ExDBFieldNumber<>("ikttekiyouno", this);
}
