package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ZennouRiritu;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 前納利率マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ZennouRiritu extends AbstractExDBTable<BM_ZennouRiritu> {

    public GenQBM_ZennouRiritu() {
        this("BM_ZennouRiritu");
    }

    public GenQBM_ZennouRiritu(String pAlias) {
        super("BM_ZennouRiritu", BM_ZennouRiritu.class, pAlias);
    }

    public String BM_ZennouRiritu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ZennouRiritu, String> tekiyoukknfrom = new ExDBFieldString<>("tekiyoukknfrom", this);

    public final ExDBFieldString<BM_ZennouRiritu, String> tekiyoukknkto = new ExDBFieldString<>("tekiyoukknkto", this);

    public final ExDBFieldString<BM_ZennouRiritu, BizNumber> zennouriritu = new ExDBFieldString<>("zennouriritu", this, BizNumberType.class);

    public final ExDBFieldString<BM_ZennouRiritu, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<BM_ZennouRiritu, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BM_ZennouRiritu, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
