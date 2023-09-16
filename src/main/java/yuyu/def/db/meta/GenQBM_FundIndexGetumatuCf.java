package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.BM_FundIndexGetumatuCf;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_UnitFundKbn;

/**
 * ファンドインデックス月末ＣＦマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_FundIndexGetumatuCf extends AbstractExDBTable<BM_FundIndexGetumatuCf> {

    public GenQBM_FundIndexGetumatuCf() {
        this("BM_FundIndexGetumatuCf");
    }

    public GenQBM_FundIndexGetumatuCf(String pAlias) {
        super("BM_FundIndexGetumatuCf", BM_FundIndexGetumatuCf.class, pAlias);
    }

    public String BM_FundIndexGetumatuCf() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_FundIndexGetumatuCf, C_UnitFundKbn> unitfundkbn = new ExDBFieldString<>("unitfundkbn", this, UserType_C_UnitFundKbn.class);

    public final ExDBFieldString<BM_FundIndexGetumatuCf, BizDate> fundhyoukaymd = new ExDBFieldString<>("fundhyoukaymd", this, BizDateType.class);

    public final ExDBFieldString<BM_FundIndexGetumatuCf, String> segkey = new ExDBFieldString<>("segkey", this);

    public final ExDBFieldBizCurrency<BM_FundIndexGetumatuCf> gmcfhknknkigahurikaegaku = new ExDBFieldBizCurrency<>("gmcfhknknkigahurikaegaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexGetumatuCf> gkgmcfhknknkigahurikaegaku = new ExDBFieldBizCurrency<>("gkgmcfhknknkigahurikaegaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexGetumatuCf> gmcfsakanrihigahurikaegaku = new ExDBFieldBizCurrency<>("gmcfsakanrihigahurikaegaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexGetumatuCf> gmsthscstgahurikaegaku = new ExDBFieldBizCurrency<>("gmsthscstgahurikaegaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexGetumatuCf> gmroanfundgahurikaegaku = new ExDBFieldBizCurrency<>("gmroanfundgahurikaegaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexGetumatuCf> gmcfhkkksahurikaegaku = new ExDBFieldBizCurrency<>("gmcfhkkksahurikaegaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexGetumatuCf> gkgmcfhkkksahurikaegaku = new ExDBFieldBizCurrency<>("gkgmcfhkkksahurikaegaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexGetumatuCf> gmroanfundsahurikaegaku = new ExDBFieldBizCurrency<>("gmroanfundsahurikaegaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexGetumatuCf> gmhokencvgoukeigaku = new ExDBFieldBizCurrency<>("gmhokencvgoukeigaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexGetumatuCf> gkgmhokencvgoukeigaku = new ExDBFieldBizCurrency<>("gkgmhokencvgoukeigaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexGetumatuCf> gmsktsganrigoukeizandaka = new ExDBFieldBizCurrency<>("gmsktsganrigoukeizandaka", this);

    public final ExDBFieldBizCurrency<BM_FundIndexGetumatuCf> gkgmsktsganrigoukeizandaka = new ExDBFieldBizCurrency<>("gkgmsktsganrigoukeizandaka", this);

    public final ExDBFieldBizCurrency<BM_FundIndexGetumatuCf> gmmihurikaesousatugaku = new ExDBFieldBizCurrency<>("gmmihurikaesousatugaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexGetumatuCf> gkgmmihurikaesousatugaku = new ExDBFieldBizCurrency<>("gkgmmihurikaesousatugaku", this);
}
