package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ZennouKeikaRiritu2;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 前納経過利率マスタ２ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ZennouKeikaRiritu2 extends AbstractExDBTable<BM_ZennouKeikaRiritu2> {

    public GenQBM_ZennouKeikaRiritu2() {
        this("BM_ZennouKeikaRiritu2");
    }

    public GenQBM_ZennouKeikaRiritu2(String pAlias) {
        super("BM_ZennouKeikaRiritu2", BM_ZennouKeikaRiritu2.class, pAlias);
    }

    public String BM_ZennouKeikaRiritu2() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ZennouKeikaRiritu2, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<BM_ZennouKeikaRiritu2, String> zennoutkybr1 = new ExDBFieldString<>("zennoutkybr1", this);

    public final ExDBFieldString<BM_ZennouKeikaRiritu2, String> zennoutkybr2 = new ExDBFieldString<>("zennoutkybr2", this);

    public final ExDBFieldString<BM_ZennouKeikaRiritu2, String> zennoutkybr3 = new ExDBFieldString<>("zennoutkybr3", this);

    public final ExDBFieldNumber<BM_ZennouKeikaRiritu2, Integer> keikatukisuu = new ExDBFieldNumber<>("keikatukisuu", this);

    public final ExDBFieldString<BM_ZennouKeikaRiritu2, String> tekiyoukknfrom = new ExDBFieldString<>("tekiyoukknfrom", this);

    public final ExDBFieldString<BM_ZennouKeikaRiritu2, String> tekiyoukknkto = new ExDBFieldString<>("tekiyoukknkto", this);

    public final ExDBFieldString<BM_ZennouKeikaRiritu2, BizNumber> zennoukeikariritu = new ExDBFieldString<>("zennoukeikariritu", this, BizNumberType.class);

    public final ExDBFieldString<BM_ZennouKeikaRiritu2, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<BM_ZennouKeikaRiritu2, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BM_ZennouKeikaRiritu2, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
