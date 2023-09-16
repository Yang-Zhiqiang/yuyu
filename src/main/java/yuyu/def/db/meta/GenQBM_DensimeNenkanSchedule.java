package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BM_DensimeNenkanSchedule;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;

/**
 * 伝票締切日年間スケジュールマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_DensimeNenkanSchedule extends AbstractExDBTable<BM_DensimeNenkanSchedule> {

    public GenQBM_DensimeNenkanSchedule() {
        this("BM_DensimeNenkanSchedule");
    }

    public GenQBM_DensimeNenkanSchedule(String pAlias) {
        super("BM_DensimeNenkanSchedule", BM_DensimeNenkanSchedule.class, pAlias);
    }

    public String BM_DensimeNenkanSchedule() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_DensimeNenkanSchedule, BizDateYM> syoriym = new ExDBFieldString<>("syoriym", this, BizDateYMType.class);

    public final ExDBFieldString<BM_DensimeNenkanSchedule, BizDate> zengetudensimeymd = new ExDBFieldString<>("zengetudensimeymd", this, BizDateType.class);
}
