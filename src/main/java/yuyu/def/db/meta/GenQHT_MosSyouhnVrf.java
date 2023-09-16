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
import yuyu.def.db.entity.HT_MosSyouhnVrf;
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
 * 申込商品ベリファイテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_MosSyouhnVrf extends AbstractExDBTable<HT_MosSyouhnVrf> {

    public GenQHT_MosSyouhnVrf() {
        this("HT_MosSyouhnVrf");
    }

    public GenQHT_MosSyouhnVrf(String pAlias) {
        super("HT_MosSyouhnVrf", HT_MosSyouhnVrf.class, pAlias);
    }

    public String HT_MosSyouhnVrf() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_MosSyouhnVrf, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_MosSyouhnVrf, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<HT_MosSyouhnVrf, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldString<HT_MosSyouhnVrf, String> ryouritusdno = new ExDBFieldString<>("ryouritusdno", this);

    public final ExDBFieldString<HT_MosSyouhnVrf, C_SyutkKbn> syutkkbn = new ExDBFieldString<>("syutkkbn", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<HT_MosSyouhnVrf, BizNumber> yoteiriritu = new ExDBFieldString<>("yoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<HT_MosSyouhnVrf, C_Sknenkinsyu> sknenkinsyu = new ExDBFieldString<>("sknenkinsyu", this, UserType_C_Sknenkinsyu.class);

    public final ExDBFieldBizCurrency<HT_MosSyouhnVrf> kihons = new ExDBFieldBizCurrency<>("kihons", this);

    public final ExDBFieldBizCurrency<HT_MosSyouhnVrf> seitoukihons = new ExDBFieldBizCurrency<>("seitoukihons", this);

    public final ExDBFieldBizCurrency<HT_MosSyouhnVrf> syutkp = new ExDBFieldBizCurrency<>("syutkp", this);

    public final ExDBFieldBizCurrency<HT_MosSyouhnVrf> hrktuukasyutkp = new ExDBFieldBizCurrency<>("hrktuukasyutkp", this);

    public final ExDBFieldBizCurrency<HT_MosSyouhnVrf> tkjyp = new ExDBFieldBizCurrency<>("tkjyp", this);

    public final ExDBFieldString<HT_MosSyouhnVrf, C_KataKbn> katakbn = new ExDBFieldString<>("katakbn", this, UserType_C_KataKbn.class);

    public final ExDBFieldString<HT_MosSyouhnVrf, C_KyhgndkataKbn> kyhkatakbn = new ExDBFieldString<>("kyhkatakbn", this, UserType_C_KyhgndkataKbn.class);

    public final ExDBFieldString<HT_MosSyouhnVrf, C_SyukyhkinkataKbn> syukyhkinkatakbn = new ExDBFieldString<>("syukyhkinkatakbn", this, UserType_C_SyukyhkinkataKbn.class);

    public final ExDBFieldString<HT_MosSyouhnVrf, C_KhnkyhkgbairituKbn> khnkyhkgbairitukbn = new ExDBFieldString<>("khnkyhkgbairitukbn", this, UserType_C_KhnkyhkgbairituKbn.class);

    public final ExDBFieldString<HT_MosSyouhnVrf, C_6daiLdKbn> rokudaildkbn = new ExDBFieldString<>("rokudaildkbn", this, UserType_C_6daiLdKbn.class);

    public final ExDBFieldNumber<HT_MosSyouhnVrf, Integer> hknkkn = new ExDBFieldNumber<>("hknkkn", this);

    public final ExDBFieldNumber<HT_MosSyouhnVrf, Integer> hrkkkn = new ExDBFieldNumber<>("hrkkkn", this);

    public final ExDBFieldString<HT_MosSyouhnVrf, C_HknkknsmnKbn> hknkknsmnkbn = new ExDBFieldString<>("hknkknsmnkbn", this, UserType_C_HknkknsmnKbn.class);

    public final ExDBFieldString<HT_MosSyouhnVrf, C_HrkkknsmnKbn> hrkkknsmnkbn = new ExDBFieldString<>("hrkkknsmnkbn", this, UserType_C_HrkkknsmnKbn.class);

    public final ExDBFieldNumber<HT_MosSyouhnVrf, Integer> dai1hknkkn = new ExDBFieldNumber<>("dai1hknkkn", this);

    public final ExDBFieldString<HT_MosSyouhnVrf, BizNumber> tumitateriritu = new ExDBFieldString<>("tumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<HT_MosSyouhnVrf, BizNumber> tmttknzoukaritujygn = new ExDBFieldString<>("tmttknzoukaritujygn", this, BizNumberType.class);

    public final ExDBFieldString<HT_MosSyouhnVrf, BizNumber> setteibairitu = new ExDBFieldString<>("setteibairitu", this, BizNumberType.class);

    public final ExDBFieldString<HT_MosSyouhnVrf, BizNumber> rendouritu = new ExDBFieldString<>("rendouritu", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<HT_MosSyouhnVrf> teikisiharaikin = new ExDBFieldBizCurrency<>("teikisiharaikin", this);

    public final ExDBFieldString<HT_MosSyouhnVrf, BizNumber> loadinghnkgtumitateriritu = new ExDBFieldString<>("loadinghnkgtumitateriritu", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<HT_MosSyouhnVrf> kihons2 = new ExDBFieldBizCurrency<>("kihons2", this);

    public final ExDBFieldBizCurrency<HT_MosSyouhnVrf> hrktuukasyutkp2 = new ExDBFieldBizCurrency<>("hrktuukasyutkp2", this);

    public final ExDBFieldString<HT_MosSyouhnVrf, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_MosSyouhnVrf, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
