package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.BM_SyoruiKtg;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;

/**
 * 書類結合マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_SyoruiKtg extends AbstractExDBTable<BM_SyoruiKtg> {

    public GenQBM_SyoruiKtg() {
        this("BM_SyoruiKtg");
    }

    public GenQBM_SyoruiKtg(String pAlias) {
        super("BM_SyoruiKtg", BM_SyoruiKtg.class, pAlias);
    }

    public String BM_SyoruiKtg() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_SyoruiKtg, C_SyoruiCdKbn> syoruiCd = new ExDBFieldString<>("syoruiCd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<BM_SyoruiKtg, String> ktgsyoruicd = new ExDBFieldString<>("ktgsyoruicd", this);

    public final ExDBFieldNumber<BM_SyoruiKtg, Integer> sortNo = new ExDBFieldNumber<>("sortNo", this);
}
