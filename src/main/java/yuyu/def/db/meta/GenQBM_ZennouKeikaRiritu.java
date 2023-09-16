package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ZennouKeikaRiritu;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 前納経過利率マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ZennouKeikaRiritu extends AbstractExDBTable<BM_ZennouKeikaRiritu> {

    public GenQBM_ZennouKeikaRiritu() {
        this("BM_ZennouKeikaRiritu");
    }

    public GenQBM_ZennouKeikaRiritu(String pAlias) {
        super("BM_ZennouKeikaRiritu", BM_ZennouKeikaRiritu.class, pAlias);
    }

    public String BM_ZennouKeikaRiritu() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<BM_ZennouKeikaRiritu, Integer> keikatukisuu = new ExDBFieldNumber<>("keikatukisuu", this);

    public final ExDBFieldString<BM_ZennouKeikaRiritu, String> tekiyoukknfrom = new ExDBFieldString<>("tekiyoukknfrom", this);

    public final ExDBFieldString<BM_ZennouKeikaRiritu, String> tekiyoukknkto = new ExDBFieldString<>("tekiyoukknkto", this);

    public final ExDBFieldString<BM_ZennouKeikaRiritu, BizNumber> zennoukeikariritu = new ExDBFieldString<>("zennoukeikariritu", this, BizNumberType.class);

    public final ExDBFieldString<BM_ZennouKeikaRiritu, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<BM_ZennouKeikaRiritu, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BM_ZennouKeikaRiritu, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
