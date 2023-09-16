package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_CfKbn;
import yuyu.def.classification.C_DenpyouKbn;
import yuyu.def.classification.C_HasseiKbn;
import yuyu.def.classification.C_HasseiRiyuuKbn;
import yuyu.def.classification.C_HengakuDenpyourecdKbn;
import yuyu.def.classification.C_HengakuSyuruiKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TkbtKanjyouUnitFundKbn;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.BT_HengakuEpsilonDenpyo;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_CfKbn;
import yuyu.def.db.type.UserType_C_DenpyouKbn;
import yuyu.def.db.type.UserType_C_HasseiKbn;
import yuyu.def.db.type.UserType_C_HasseiRiyuuKbn;
import yuyu.def.db.type.UserType_C_HengakuDenpyourecdKbn;
import yuyu.def.db.type.UserType_C_HengakuSyuruiKbn;
import yuyu.def.db.type.UserType_C_TaisyakuKbn;
import yuyu.def.db.type.UserType_C_TkbtKanjyouUnitFundKbn;
import yuyu.def.db.type.UserType_C_UnitFundKbn;

/**
 * 変額イプシロン伝票テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_HengakuEpsilonDenpyo extends AbstractExDBTable<BT_HengakuEpsilonDenpyo> {

    public GenQBT_HengakuEpsilonDenpyo() {
        this("BT_HengakuEpsilonDenpyo");
    }

    public GenQBT_HengakuEpsilonDenpyo(String pAlias) {
        super("BT_HengakuEpsilonDenpyo", BT_HengakuEpsilonDenpyo.class, pAlias);
    }

    public String BT_HengakuEpsilonDenpyo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_HengakuEpsilonDenpyo, C_HengakuDenpyourecdKbn> hengakudenpyourecdkbn = new ExDBFieldString<>("hengakudenpyourecdkbn", this, UserType_C_HengakuDenpyourecdKbn.class);

    public final ExDBFieldString<BT_HengakuEpsilonDenpyo, C_HengakuSyuruiKbn> hengakusyuruikbn = new ExDBFieldString<>("hengakusyuruikbn", this, UserType_C_HengakuSyuruiKbn.class);

    public final ExDBFieldString<BT_HengakuEpsilonDenpyo, C_UnitFundKbn> unitfundkbn = new ExDBFieldString<>("unitfundkbn", this, UserType_C_UnitFundKbn.class);

    public final ExDBFieldString<BT_HengakuEpsilonDenpyo, C_TkbtKanjyouUnitFundKbn> tkbtkanjyouunitfundkbn = new ExDBFieldString<>("tkbtkanjyouunitfundkbn", this, UserType_C_TkbtKanjyouUnitFundKbn.class);

    public final ExDBFieldString<BT_HengakuEpsilonDenpyo, String> kacd = new ExDBFieldString<>("kacd", this);

    public final ExDBFieldString<BT_HengakuEpsilonDenpyo, BizDate> denymd = new ExDBFieldString<>("denymd", this, BizDateType.class);

    public final ExDBFieldString<BT_HengakuEpsilonDenpyo, C_DenpyouKbn> denpyoukbn = new ExDBFieldString<>("denpyoukbn", this, UserType_C_DenpyouKbn.class);

    public final ExDBFieldString<BT_HengakuEpsilonDenpyo, C_TaisyakuKbn> taisyakukbn = new ExDBFieldString<>("taisyakukbn", this, UserType_C_TaisyakuKbn.class);

    public final ExDBFieldString<BT_HengakuEpsilonDenpyo, String> kamokucd = new ExDBFieldString<>("kamokucd", this);

    public final ExDBFieldString<BT_HengakuEpsilonDenpyo, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<BT_HengakuEpsilonDenpyo, String> fundsyoricd = new ExDBFieldString<>("fundsyoricd", this);

    public final ExDBFieldString<BT_HengakuEpsilonDenpyo, C_CfKbn> cfkbn = new ExDBFieldString<>("cfkbn", this, UserType_C_CfKbn.class);

    public final ExDBFieldString<BT_HengakuEpsilonDenpyo, C_HasseiRiyuuKbn> hasseiriyuukbn = new ExDBFieldString<>("hasseiriyuukbn", this, UserType_C_HasseiRiyuuKbn.class);

    public final ExDBFieldString<BT_HengakuEpsilonDenpyo, C_HasseiKbn> hasseikbn = new ExDBFieldString<>("hasseikbn", this, UserType_C_HasseiKbn.class);

    public final ExDBFieldBizCurrency<BT_HengakuEpsilonDenpyo> fundkingaku = new ExDBFieldBizCurrency<>("fundkingaku", this);
}
