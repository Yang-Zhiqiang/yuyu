package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ZennouTumitateRitu;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 前納積立率マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ZennouTumitateRitu extends AbstractExDBTable<BM_ZennouTumitateRitu> {

    public GenQBM_ZennouTumitateRitu() {
        this("BM_ZennouTumitateRitu");
    }

    public GenQBM_ZennouTumitateRitu(String pAlias) {
        super("BM_ZennouTumitateRitu", BM_ZennouTumitateRitu.class, pAlias);
    }

    public String BM_ZennouTumitateRitu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ZennouTumitateRitu, String> tekiyoukknfrom = new ExDBFieldString<>("tekiyoukknfrom", this);

    public final ExDBFieldString<BM_ZennouTumitateRitu, String> tekiyoukknkto = new ExDBFieldString<>("tekiyoukknkto", this);

    public final ExDBFieldString<BM_ZennouTumitateRitu, BizNumber> zennoutumitateritu = new ExDBFieldString<>("zennoutumitateritu", this, BizNumberType.class);

    public final ExDBFieldString<BM_ZennouTumitateRitu, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<BM_ZennouTumitateRitu, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BM_ZennouTumitateRitu, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
