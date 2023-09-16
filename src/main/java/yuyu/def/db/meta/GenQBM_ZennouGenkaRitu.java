package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ZennouGenkaRitu;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 前納現価率マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ZennouGenkaRitu extends AbstractExDBTable<BM_ZennouGenkaRitu> {

    public GenQBM_ZennouGenkaRitu() {
        this("BM_ZennouGenkaRitu");
    }

    public GenQBM_ZennouGenkaRitu(String pAlias) {
        super("BM_ZennouGenkaRitu", BM_ZennouGenkaRitu.class, pAlias);
    }

    public String BM_ZennouGenkaRitu() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<BM_ZennouGenkaRitu, Integer> zennounensuu = new ExDBFieldNumber<>("zennounensuu", this);

    public final ExDBFieldString<BM_ZennouGenkaRitu, String> tekiyoukknfrom = new ExDBFieldString<>("tekiyoukknfrom", this);

    public final ExDBFieldString<BM_ZennouGenkaRitu, String> tekiyoukknkto = new ExDBFieldString<>("tekiyoukknkto", this);

    public final ExDBFieldString<BM_ZennouGenkaRitu, BizNumber> zennougenkaritu = new ExDBFieldString<>("zennougenkaritu", this, BizNumberType.class);

    public final ExDBFieldString<BM_ZennouGenkaRitu, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<BM_ZennouGenkaRitu, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BM_ZennouGenkaRitu, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
