package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ZennouTumitateRitu2;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 前納積立率マスタ２ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ZennouTumitateRitu2 extends AbstractExDBTable<BM_ZennouTumitateRitu2> {

    public GenQBM_ZennouTumitateRitu2() {
        this("BM_ZennouTumitateRitu2");
    }

    public GenQBM_ZennouTumitateRitu2(String pAlias) {
        super("BM_ZennouTumitateRitu2", BM_ZennouTumitateRitu2.class, pAlias);
    }

    public String BM_ZennouTumitateRitu2() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ZennouTumitateRitu2, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<BM_ZennouTumitateRitu2, String> zennoutkybr1 = new ExDBFieldString<>("zennoutkybr1", this);

    public final ExDBFieldString<BM_ZennouTumitateRitu2, String> zennoutkybr2 = new ExDBFieldString<>("zennoutkybr2", this);

    public final ExDBFieldString<BM_ZennouTumitateRitu2, String> zennoutkybr3 = new ExDBFieldString<>("zennoutkybr3", this);

    public final ExDBFieldString<BM_ZennouTumitateRitu2, String> tekiyoukknfrom = new ExDBFieldString<>("tekiyoukknfrom", this);

    public final ExDBFieldString<BM_ZennouTumitateRitu2, String> tekiyoukknkto = new ExDBFieldString<>("tekiyoukknkto", this);

    public final ExDBFieldString<BM_ZennouTumitateRitu2, BizNumber> zennoutumitateritu = new ExDBFieldString<>("zennoutumitateritu", this, BizNumberType.class);

    public final ExDBFieldString<BM_ZennouTumitateRitu2, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<BM_ZennouTumitateRitu2, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BM_ZennouTumitateRitu2, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
