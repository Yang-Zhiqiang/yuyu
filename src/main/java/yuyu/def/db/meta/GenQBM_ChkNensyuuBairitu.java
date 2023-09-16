package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.db.entity.BM_ChkNensyuuBairitu;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import yuyu.def.db.type.UserType_C_NensyuuKbn;

/**
 * 年収倍率チェックマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_ChkNensyuuBairitu extends AbstractExDBTable<BM_ChkNensyuuBairitu> {

    public GenQBM_ChkNensyuuBairitu() {
        this("BM_ChkNensyuuBairitu");
    }

    public GenQBM_ChkNensyuuBairitu(String pAlias) {
        super("BM_ChkNensyuuBairitu", BM_ChkNensyuuBairitu.class, pAlias);
    }

    public String BM_ChkNensyuuBairitu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_ChkNensyuuBairitu, C_NensyuuKbn> nensyuukbn = new ExDBFieldString<>("nensyuukbn", this, UserType_C_NensyuuKbn.class);

    public final ExDBFieldBizCurrency<BM_ChkNensyuuBairitu> gndntgk = new ExDBFieldBizCurrency<>("gndntgk", this);

    public final ExDBFieldBizCurrency<BM_ChkNensyuuBairitu> gnds = new ExDBFieldBizCurrency<>("gnds", this);
}
