package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BM_TestSyonokanri;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;

/**
 * テスト用証券番号管理マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_TestSyonokanri extends AbstractExDBTable<BM_TestSyonokanri> {

    public GenQBM_TestSyonokanri() {
        this("BM_TestSyonokanri");
    }

    public GenQBM_TestSyonokanri(String pAlias) {
        super("BM_TestSyonokanri", BM_TestSyonokanri.class, pAlias);
    }

    public String BM_TestSyonokanri() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_TestSyonokanri, String> seirekinen2keta = new ExDBFieldString<>("seirekinen2keta", this);

    public final ExDBFieldString<BM_TestSyonokanri, String> bosyuusosikicd = new ExDBFieldString<>("bosyuusosikicd", this);

    public final ExDBFieldNumber<BM_TestSyonokanri, Integer> syonorenno = new ExDBFieldNumber<>("syonorenno", this);

    public final ExDBFieldString<BM_TestSyonokanri, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<BM_TestSyonokanri, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<BM_TestSyonokanri, BizDate> saibanymd = new ExDBFieldString<>("saibanymd", this, BizDateType.class);

    public final ExDBFieldString<BM_TestSyonokanri, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BM_TestSyonokanri, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
