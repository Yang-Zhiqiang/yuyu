package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_IkkatuKeisuu;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 一括払係数マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_IkkatuKeisuu extends AbstractExDBTable<BM_IkkatuKeisuu> {

    public GenQBM_IkkatuKeisuu() {
        this("BM_IkkatuKeisuu");
    }

    public GenQBM_IkkatuKeisuu(String pAlias) {
        super("BM_IkkatuKeisuu", BM_IkkatuKeisuu.class, pAlias);
    }

    public String BM_IkkatuKeisuu() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<BM_IkkatuKeisuu, Integer> ikttekiyouno = new ExDBFieldNumber<>("ikttekiyouno", this);

    public final ExDBFieldNumber<BM_IkkatuKeisuu, Integer> nen1nen2baraihyouji = new ExDBFieldNumber<>("nen1nen2baraihyouji", this);

    public final ExDBFieldNumber<BM_IkkatuKeisuu, Integer> keikatukisuu = new ExDBFieldNumber<>("keikatukisuu", this);

    public final ExDBFieldString<BM_IkkatuKeisuu, BizNumber> iktkeisuu = new ExDBFieldString<>("iktkeisuu", this, BizNumberType.class);
}
