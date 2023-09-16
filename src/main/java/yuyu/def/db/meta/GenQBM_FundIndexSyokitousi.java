package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.BM_FundIndexSyokitousi;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_UnitFundKbn;

/**
 * ファンドインデックス初期投資マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_FundIndexSyokitousi extends AbstractExDBTable<BM_FundIndexSyokitousi> {

    public GenQBM_FundIndexSyokitousi() {
        this("BM_FundIndexSyokitousi");
    }

    public GenQBM_FundIndexSyokitousi(String pAlias) {
        super("BM_FundIndexSyokitousi", BM_FundIndexSyokitousi.class, pAlias);
    }

    public String BM_FundIndexSyokitousi() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_FundIndexSyokitousi, C_UnitFundKbn> unitfundkbn = new ExDBFieldString<>("unitfundkbn", this, UserType_C_UnitFundKbn.class);

    public final ExDBFieldString<BM_FundIndexSyokitousi, BizDate> fundhyoukaymd = new ExDBFieldString<>("fundhyoukaymd", this, BizDateType.class);

    public final ExDBFieldString<BM_FundIndexSyokitousi, String> segkey = new ExDBFieldString<>("segkey", this);

    public final ExDBFieldString<BM_FundIndexSyokitousi, String> syokisegsakuseijiyuu = new ExDBFieldString<>("syokisegsakuseijiyuu", this);

    public final ExDBFieldBizCurrency<BM_FundIndexSyokitousi> syokitousisetteigaku = new ExDBFieldBizCurrency<>("syokitousisetteigaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexSyokitousi> syokigoukeihensaigaku = new ExDBFieldBizCurrency<>("syokigoukeihensaigaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexSyokitousi> syokirisokuhensaigaku = new ExDBFieldBizCurrency<>("syokirisokuhensaigaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexSyokitousi> syokigankinhensaigaku = new ExDBFieldBizCurrency<>("syokigankinhensaigaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexSyokitousi> syokitousirisoku = new ExDBFieldBizCurrency<>("syokitousirisoku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexSyokitousi> syokigankinkuriiregaku = new ExDBFieldBizCurrency<>("syokigankinkuriiregaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexSyokitousi> gksyokitousisetteigaku = new ExDBFieldBizCurrency<>("gksyokitousisetteigaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexSyokitousi> gksyokigoukeihensaigaku = new ExDBFieldBizCurrency<>("gksyokigoukeihensaigaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexSyokitousi> gksyokirisokuhensaigaku = new ExDBFieldBizCurrency<>("gksyokirisokuhensaigaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexSyokitousi> gksyokigankinhensaigaku = new ExDBFieldBizCurrency<>("gksyokigankinhensaigaku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexSyokitousi> gksyokitousirisoku = new ExDBFieldBizCurrency<>("gksyokitousirisoku", this);

    public final ExDBFieldBizCurrency<BM_FundIndexSyokitousi> gksyokigankinkuriiregaku = new ExDBFieldBizCurrency<>("gksyokigankinkuriiregaku", this);

    public final ExDBFieldString<BM_FundIndexSyokitousi, String> syokitousigankinkrirkbn = new ExDBFieldString<>("syokitousigankinkrirkbn", this);

    public final ExDBFieldString<BM_FundIndexSyokitousi, BizDate> zenkaistsegsakuseiymd = new ExDBFieldString<>("zenkaistsegsakuseiymd", this, BizDateType.class);
}
