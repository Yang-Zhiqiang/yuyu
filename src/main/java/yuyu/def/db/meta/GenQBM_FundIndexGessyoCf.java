package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.BM_FundIndexGessyoCf;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_UnitFundKbn;

/**
 * ファンドインデックス月初ＣＦマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_FundIndexGessyoCf extends AbstractExDBTable<BM_FundIndexGessyoCf> {

    public GenQBM_FundIndexGessyoCf() {
        this("BM_FundIndexGessyoCf");
    }

    public GenQBM_FundIndexGessyoCf(String pAlias) {
        super("BM_FundIndexGessyoCf", BM_FundIndexGessyoCf.class, pAlias);
    }

    public String BM_FundIndexGessyoCf() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_FundIndexGessyoCf, C_UnitFundKbn> unitfundkbn = new ExDBFieldString<>("unitfundkbn", this, UserType_C_UnitFundKbn.class);

    public final ExDBFieldString<BM_FundIndexGessyoCf, BizDate> fundhyoukaymd = new ExDBFieldString<>("fundhyoukaymd", this, BizDateType.class);

    public final ExDBFieldString<BM_FundIndexGessyoCf, String> segkey = new ExDBFieldString<>("segkey", this);

    public final ExDBFieldBizCurrency<BM_FundIndexGessyoCf> gscfhkkkgahurikaegaku = new ExDBFieldBizCurrency<>("gscfhkkkgahurikaegaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexGessyoCf> gkgscfhkkkgahurikaegaku = new ExDBFieldBizCurrency<>("gkgscfhkkkgahurikaegaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexGessyoCf> gscfhkkksahurikaegaku = new ExDBFieldBizCurrency<>("gscfhkkksahurikaegaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexGessyoCf> gkgscfhkkksahurikaegaku = new ExDBFieldBizCurrency<>("gkgscfhkkksahurikaegaku", this);
}
