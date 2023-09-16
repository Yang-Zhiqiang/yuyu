package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.BM_FundIndexKihon;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_UnitFundKbn;

/**
 * ファンドインデックス基本マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_FundIndexKihon extends AbstractExDBTable<BM_FundIndexKihon> {

    public GenQBM_FundIndexKihon() {
        this("BM_FundIndexKihon");
    }

    public GenQBM_FundIndexKihon(String pAlias) {
        super("BM_FundIndexKihon", BM_FundIndexKihon.class, pAlias);
    }

    public String BM_FundIndexKihon() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_FundIndexKihon, C_UnitFundKbn> unitfundkbn = new ExDBFieldString<>("unitfundkbn", this, UserType_C_UnitFundKbn.class);

    public final ExDBFieldString<BM_FundIndexKihon, BizDate> fundhyoukaymd = new ExDBFieldString<>("fundhyoukaymd", this, BizDateType.class);

    public final ExDBFieldString<BM_FundIndexKihon, BizDate> fundkaisetuymd = new ExDBFieldString<>("fundkaisetuymd", this, BizDateType.class);

    public final ExDBFieldNumber<BM_FundIndexKihon, Double> fundindex = new ExDBFieldNumber<>("fundindex", this);

    public final ExDBFieldString<BM_FundIndexKihon, String> fundindexkeisankbn = new ExDBFieldString<>("fundindexkeisankbn", this);

    public final ExDBFieldBizCurrency<BM_FundIndexKihon> unyoustartjisisankagaku = new ExDBFieldBizCurrency<>("unyoustartjisisankagaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexKihon> unyouendjisisankagaku = new ExDBFieldBizCurrency<>("unyouendjisisankagaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexKihon> cfkasangosisankagaku = new ExDBFieldBizCurrency<>("cfkasangosisankagaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexKihon> unyoustartjicfgaku = new ExDBFieldBizCurrency<>("unyoustartjicfgaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexKihon> unyoujisonekigaku = new ExDBFieldBizCurrency<>("unyoujisonekigaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexKihon> unyougocfgaku = new ExDBFieldBizCurrency<>("unyougocfgaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexKihon> saiteihosyounichigaku = new ExDBFieldBizCurrency<>("saiteihosyounichigaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexKihon> saiteihosyougekkangaku = new ExDBFieldBizCurrency<>("saiteihosyougekkangaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexKihon> gkunyoustartjisisankagaku = new ExDBFieldBizCurrency<>("gkunyoustartjisisankagaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexKihon> gkunyouendjisisankagaku = new ExDBFieldBizCurrency<>("gkunyouendjisisankagaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexKihon> gkcfkasangosisankagaku = new ExDBFieldBizCurrency<>("gkcfkasangosisankagaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexKihon> gkunyoustartjicfgaku = new ExDBFieldBizCurrency<>("gkunyoustartjicfgaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexKihon> gkunyoujisonekigaku = new ExDBFieldBizCurrency<>("gkunyoujisonekigaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexKihon> gkunyougocfgaku = new ExDBFieldBizCurrency<>("gkunyougocfgaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexKihon> starttousiganrigoukei = new ExDBFieldBizCurrency<>("starttousiganrigoukei", this);

    public final ExDBFieldBizCurrency<BM_FundIndexKihon> gkstarttousiganrigoukei = new ExDBFieldBizCurrency<>("gkstarttousiganrigoukei", this);

    public final ExDBFieldString<BM_FundIndexKihon, BizDate> saisinsyokitousisegymd = new ExDBFieldString<>("saisinsyokitousisegymd", this, BizDateType.class);

    public final ExDBFieldString<BM_FundIndexKihon, String> unyougocfmikakuteihyouji = new ExDBFieldString<>("unyougocfmikakuteihyouji", this);
}
