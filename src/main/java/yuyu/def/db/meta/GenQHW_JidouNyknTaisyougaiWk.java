package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HW_JidouNyknTaisyougaiWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_NyktyhyoutKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 自動入金対象外ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHW_JidouNyknTaisyougaiWk extends AbstractExDBTable<HW_JidouNyknTaisyougaiWk> {

    public GenQHW_JidouNyknTaisyougaiWk() {
        this("HW_JidouNyknTaisyougaiWk");
    }

    public GenQHW_JidouNyknTaisyougaiWk(String pAlias) {
        super("HW_JidouNyknTaisyougaiWk", HW_JidouNyknTaisyougaiWk.class, pAlias);
    }

    public String HW_JidouNyknTaisyougaiWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HW_JidouNyknTaisyougaiWk, BizDate> nyksyoriymd = new ExDBFieldString<>("nyksyoriymd", this, BizDateType.class);

    public final ExDBFieldString<HW_JidouNyknTaisyougaiWk, String> itirenno = new ExDBFieldString<>("itirenno", this);

    public final ExDBFieldString<HW_JidouNyknTaisyougaiWk, String> nykmosno = new ExDBFieldString<>("nykmosno", this);

    public final ExDBFieldString<HW_JidouNyknTaisyougaiWk, String> oyadrtencd = new ExDBFieldString<>("oyadrtencd", this);

    public final ExDBFieldBizCurrency<HW_JidouNyknTaisyougaiWk> trhkkgk = new ExDBFieldBizCurrency<>("trhkkgk", this);

    public final ExDBFieldString<HW_JidouNyknTaisyougaiWk, C_Tuukasyu> rstuukasyu = new ExDBFieldString<>("rstuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<HW_JidouNyknTaisyougaiWk, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<HW_JidouNyknTaisyougaiWk, C_NyktyhyoutKbn> nyktyhyoutkbn = new ExDBFieldString<>("nyktyhyoutkbn", this, UserType_C_NyktyhyoutKbn.class);

    public final ExDBFieldString<HW_JidouNyknTaisyougaiWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HW_JidouNyknTaisyougaiWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
