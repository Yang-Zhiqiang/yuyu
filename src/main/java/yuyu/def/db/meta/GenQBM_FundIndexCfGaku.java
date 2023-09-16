package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.BM_FundIndexCfGaku;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_UnitFundKbn;

/**
 * ファンドインデックスＣＦ額マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_FundIndexCfGaku extends AbstractExDBTable<BM_FundIndexCfGaku> {

    public GenQBM_FundIndexCfGaku() {
        this("BM_FundIndexCfGaku");
    }

    public GenQBM_FundIndexCfGaku(String pAlias) {
        super("BM_FundIndexCfGaku", BM_FundIndexCfGaku.class, pAlias);
    }

    public String BM_FundIndexCfGaku() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_FundIndexCfGaku, C_UnitFundKbn> unitfundkbn = new ExDBFieldString<>("unitfundkbn", this, UserType_C_UnitFundKbn.class);

    public final ExDBFieldString<BM_FundIndexCfGaku, BizDate> fundhyoukaymd = new ExDBFieldString<>("fundhyoukaymd", this, BizDateType.class);

    public final ExDBFieldString<BM_FundIndexCfGaku, String> segkey = new ExDBFieldString<>("segkey", this);

    public final ExDBFieldBizCurrency<BM_FundIndexCfGaku> cfgaku = new ExDBFieldBizCurrency<>("cfgaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexCfGaku> gkcfgaku = new ExDBFieldBizCurrency<>("gkcfgaku", this);
}
