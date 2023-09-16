package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BM_Syonokanri;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;

/**
 * 証券番号管理マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_Syonokanri extends AbstractExDBTable<BM_Syonokanri> {

    public GenQBM_Syonokanri() {
        this("BM_Syonokanri");
    }

    public GenQBM_Syonokanri(String pAlias) {
        super("BM_Syonokanri", BM_Syonokanri.class, pAlias);
    }

    public String BM_Syonokanri() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_Syonokanri, String> seirekinen2keta = new ExDBFieldString<>("seirekinen2keta", this);

    public final ExDBFieldString<BM_Syonokanri, String> bosyuusosikicd = new ExDBFieldString<>("bosyuusosikicd", this);

    public final ExDBFieldNumber<BM_Syonokanri, Integer> syonorenno = new ExDBFieldNumber<>("syonorenno", this);

    public final ExDBFieldString<BM_Syonokanri, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<BM_Syonokanri, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<BM_Syonokanri, BizDate> saibanymd = new ExDBFieldString<>("saibanymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Syonokanri, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BM_Syonokanri, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
