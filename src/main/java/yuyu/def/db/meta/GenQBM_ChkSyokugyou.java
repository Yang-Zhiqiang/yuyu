package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BM_ChkSyokugyou;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;

/**
 * 職業制限チェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkSyokugyou extends AbstractExDBTable<BM_ChkSyokugyou> {

    public GenQBM_ChkSyokugyou() {
        this("BM_ChkSyokugyou");
    }

    public GenQBM_ChkSyokugyou(String pAlias) {
        super("BM_ChkSyokugyou", BM_ChkSyokugyou.class, pAlias);
    }

    public String BM_ChkSyokugyou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkSyokugyou, String> syokugyoucd = new ExDBFieldString<>("syokugyoucd", this);

    public final ExDBFieldBizCurrency<BM_ChkSyokugyou> gndntgk = new ExDBFieldBizCurrency<>("gndntgk", this);

    public final ExDBFieldBizCurrency<BM_ChkSyokugyou> gnds = new ExDBFieldBizCurrency<>("gnds", this);
}
