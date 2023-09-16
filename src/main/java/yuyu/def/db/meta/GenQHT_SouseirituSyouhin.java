package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.HT_SouseirituSyouhin;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_6daiLdKbn;
import yuyu.def.db.type.UserType_C_HknkknsmnKbn;
import yuyu.def.db.type.UserType_C_HrkkknsmnKbn;
import yuyu.def.db.type.UserType_C_KataKbn;
import yuyu.def.db.type.UserType_C_KhnkyhkgbairituKbn;
import yuyu.def.db.type.UserType_C_KyhgndkataKbn;
import yuyu.def.db.type.UserType_C_Sknenkinsyu;
import yuyu.def.db.type.UserType_C_SyukyhkinkataKbn;
import yuyu.def.db.type.UserType_C_SyutkKbn;

/**
 * 総成立商品テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_SouseirituSyouhin extends AbstractExDBTable<HT_SouseirituSyouhin> {

    public GenQHT_SouseirituSyouhin() {
        this("HT_SouseirituSyouhin");
    }

    public GenQHT_SouseirituSyouhin(String pAlias) {
        super("HT_SouseirituSyouhin", HT_SouseirituSyouhin.class, pAlias);
    }

    public String HT_SouseirituSyouhin() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_SouseirituSyouhin, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<HT_SouseirituSyouhin, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<HT_SouseirituSyouhin, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldString<HT_SouseirituSyouhin, String> ryouritusdno = new ExDBFieldString<>("ryouritusdno", this);

    public final ExDBFieldString<HT_SouseirituSyouhin, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_SouseirituSyouhin, C_SyutkKbn> syutkkbn = new ExDBFieldString<>("syutkkbn", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<HT_SouseirituSyouhin, BizNumber> yoteiriritu = new ExDBFieldString<>("yoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<HT_SouseirituSyouhin, C_Sknenkinsyu> sknenkinsyu = new ExDBFieldString<>("sknenkinsyu", this, UserType_C_Sknenkinsyu.class);

    public final ExDBFieldBizCurrency<HT_SouseirituSyouhin> kihons = new ExDBFieldBizCurrency<>("kihons", this);

    public final ExDBFieldBizCurrency<HT_SouseirituSyouhin> seitoukihons = new ExDBFieldBizCurrency<>("seitoukihons", this);

    public final ExDBFieldBizCurrency<HT_SouseirituSyouhin> syutkp = new ExDBFieldBizCurrency<>("syutkp", this);

    public final ExDBFieldBizCurrency<HT_SouseirituSyouhin> hrktuukasyutkp = new ExDBFieldBizCurrency<>("hrktuukasyutkp", this);

    public final ExDBFieldBizCurrency<HT_SouseirituSyouhin> tkjyp = new ExDBFieldBizCurrency<>("tkjyp", this);

    public final ExDBFieldString<HT_SouseirituSyouhin, C_KataKbn> katakbn = new ExDBFieldString<>("katakbn", this, UserType_C_KataKbn.class);

    public final ExDBFieldString<HT_SouseirituSyouhin, C_KyhgndkataKbn> kyhkatakbn = new ExDBFieldString<>("kyhkatakbn", this, UserType_C_KyhgndkataKbn.class);

    public final ExDBFieldString<HT_SouseirituSyouhin, C_SyukyhkinkataKbn> syukyhkinkatakbn = new ExDBFieldString<>("syukyhkinkatakbn", this, UserType_C_SyukyhkinkataKbn.class);

    public final ExDBFieldString<HT_SouseirituSyouhin, C_KhnkyhkgbairituKbn> khnkyhkgbairitukbn = new ExDBFieldString<>("khnkyhkgbairitukbn", this, UserType_C_KhnkyhkgbairituKbn.class);

    public final ExDBFieldString<HT_SouseirituSyouhin, C_6daiLdKbn> rokudaildkbn = new ExDBFieldString<>("rokudaildkbn", this, UserType_C_6daiLdKbn.class);

    public final ExDBFieldNumber<HT_SouseirituSyouhin, Integer> hknkkn = new ExDBFieldNumber<>("hknkkn", this);

    public final ExDBFieldNumber<HT_SouseirituSyouhin, Integer> hrkkkn = new ExDBFieldNumber<>("hrkkkn", this);

    public final ExDBFieldString<HT_SouseirituSyouhin, C_HknkknsmnKbn> hknkknsmnkbn = new ExDBFieldString<>("hknkknsmnkbn", this, UserType_C_HknkknsmnKbn.class);

    public final ExDBFieldString<HT_SouseirituSyouhin, C_HrkkknsmnKbn> hrkkknsmnkbn = new ExDBFieldString<>("hrkkknsmnkbn", this, UserType_C_HrkkknsmnKbn.class);

    public final ExDBFieldNumber<HT_SouseirituSyouhin, Integer> dai1hknkkn = new ExDBFieldNumber<>("dai1hknkkn", this);

    public final ExDBFieldString<HT_SouseirituSyouhin, BizNumber> tumitateriritu = new ExDBFieldString<>("tumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<HT_SouseirituSyouhin, BizNumber> tmttknzoukaritujygn = new ExDBFieldString<>("tmttknzoukaritujygn", this, BizNumberType.class);

    public final ExDBFieldString<HT_SouseirituSyouhin, BizNumber> setteibairitu = new ExDBFieldString<>("setteibairitu", this, BizNumberType.class);

    public final ExDBFieldString<HT_SouseirituSyouhin, BizNumber> rendouritu = new ExDBFieldString<>("rendouritu", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<HT_SouseirituSyouhin> teikisiharaikin = new ExDBFieldBizCurrency<>("teikisiharaikin", this);

    public final ExDBFieldString<HT_SouseirituSyouhin, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_SouseirituSyouhin, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
