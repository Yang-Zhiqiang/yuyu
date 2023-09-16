package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.HT_BosSyouhn;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
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
 * 募集商品テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_BosSyouhn extends AbstractExDBTable<HT_BosSyouhn> {

    public GenQHT_BosSyouhn() {
        this("HT_BosSyouhn");
    }

    public GenQHT_BosSyouhn(String pAlias) {
        super("HT_BosSyouhn", HT_BosSyouhn.class, pAlias);
    }

    public String HT_BosSyouhn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_BosSyouhn, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_BosSyouhn, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<HT_BosSyouhn, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldString<HT_BosSyouhn, String> ryouritusdno = new ExDBFieldString<>("ryouritusdno", this);

    public final ExDBFieldString<HT_BosSyouhn, C_SyutkKbn> syutkkbn = new ExDBFieldString<>("syutkkbn", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<HT_BosSyouhn, C_Sknenkinsyu> sknenkinsyu = new ExDBFieldString<>("sknenkinsyu", this, UserType_C_Sknenkinsyu.class);

    public final ExDBFieldBizCurrency<HT_BosSyouhn> kihons = new ExDBFieldBizCurrency<>("kihons", this);

    public final ExDBFieldBizCurrency<HT_BosSyouhn> seitoukihons = new ExDBFieldBizCurrency<>("seitoukihons", this);

    public final ExDBFieldBizCurrency<HT_BosSyouhn> syutkp = new ExDBFieldBizCurrency<>("syutkp", this);

    public final ExDBFieldBizCurrency<HT_BosSyouhn> hrktuukasyutkp = new ExDBFieldBizCurrency<>("hrktuukasyutkp", this);

    public final ExDBFieldBizCurrency<HT_BosSyouhn> tkjyp = new ExDBFieldBizCurrency<>("tkjyp", this);

    public final ExDBFieldString<HT_BosSyouhn, C_KataKbn> katakbn = new ExDBFieldString<>("katakbn", this, UserType_C_KataKbn.class);

    public final ExDBFieldString<HT_BosSyouhn, C_KyhgndkataKbn> kyhkatakbn = new ExDBFieldString<>("kyhkatakbn", this, UserType_C_KyhgndkataKbn.class);

    public final ExDBFieldString<HT_BosSyouhn, C_SyukyhkinkataKbn> syukyhkinkatakbn = new ExDBFieldString<>("syukyhkinkatakbn", this, UserType_C_SyukyhkinkataKbn.class);

    public final ExDBFieldString<HT_BosSyouhn, C_KhnkyhkgbairituKbn> khnkyhkgbairitukbn = new ExDBFieldString<>("khnkyhkgbairitukbn", this, UserType_C_KhnkyhkgbairituKbn.class);

    public final ExDBFieldString<HT_BosSyouhn, C_6daiLdKbn> rokudaildkbn = new ExDBFieldString<>("rokudaildkbn", this, UserType_C_6daiLdKbn.class);

    public final ExDBFieldNumber<HT_BosSyouhn, Integer> hknkkn = new ExDBFieldNumber<>("hknkkn", this);

    public final ExDBFieldNumber<HT_BosSyouhn, Integer> hrkkkn = new ExDBFieldNumber<>("hrkkkn", this);

    public final ExDBFieldString<HT_BosSyouhn, C_HknkknsmnKbn> hknkknsmnkbn = new ExDBFieldString<>("hknkknsmnkbn", this, UserType_C_HknkknsmnKbn.class);

    public final ExDBFieldString<HT_BosSyouhn, C_HrkkknsmnKbn> hrkkknsmnkbn = new ExDBFieldString<>("hrkkknsmnkbn", this, UserType_C_HrkkknsmnKbn.class);

    public final ExDBFieldNumber<HT_BosSyouhn, Integer> dai1hknkkn = new ExDBFieldNumber<>("dai1hknkkn", this);

    public final ExDBFieldString<HT_BosSyouhn, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_BosSyouhn, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
