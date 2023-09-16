package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HrkmnykndatarenmotoKbn;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HW_HrkmNyknTaisyouWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HrkmnykndatarenmotoKbn;
import yuyu.def.db.type.UserType_C_NyktyhyoutKbn;
import yuyu.def.db.type.UserType_C_Syorizumiflg;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 振込入金対象ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHW_HrkmNyknTaisyouWk extends AbstractExDBTable<HW_HrkmNyknTaisyouWk> {

    public GenQHW_HrkmNyknTaisyouWk() {
        this("HW_HrkmNyknTaisyouWk");
    }

    public GenQHW_HrkmNyknTaisyouWk(String pAlias) {
        super("HW_HrkmNyknTaisyouWk", HW_HrkmNyknTaisyouWk.class, pAlias);
    }

    public String HW_HrkmNyknTaisyouWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HW_HrkmNyknTaisyouWk, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<HW_HrkmNyknTaisyouWk, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldNumber<HW_HrkmNyknTaisyouWk, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<HW_HrkmNyknTaisyouWk, String> oyadrtencd = new ExDBFieldString<>("oyadrtencd", this);

    public final ExDBFieldString<HW_HrkmNyknTaisyouWk, BizDate> ryosyuymd = new ExDBFieldString<>("ryosyuymd", this, BizDateType.class);

    public final ExDBFieldString<HW_HrkmNyknTaisyouWk, String> hrkmirninnm = new ExDBFieldString<>("hrkmirninnm", this);

    public final ExDBFieldBizCurrency<HW_HrkmNyknTaisyouWk> rsgaku = new ExDBFieldBizCurrency<>("rsgaku", this);

    public final ExDBFieldString<HW_HrkmNyknTaisyouWk, C_Tuukasyu> rstuukasyu = new ExDBFieldString<>("rstuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<HW_HrkmNyknTaisyouWk> rsgakuen = new ExDBFieldBizCurrency<>("rsgakuen", this);

    public final ExDBFieldBizCurrency<HW_HrkmNyknTaisyouWk> hrkmtsry = new ExDBFieldBizCurrency<>("hrkmtsry", this);

    public final ExDBFieldString<HW_HrkmNyknTaisyouWk, BizDate> nyksyoriymd = new ExDBFieldString<>("nyksyoriymd", this, BizDateType.class);

    public final ExDBFieldString<HW_HrkmNyknTaisyouWk, C_HrkmnykndatarenmotoKbn> hrkmnykndatarenmotoKbn = new ExDBFieldString<>("hrkmnykndatarenmotoKbn", this, UserType_C_HrkmnykndatarenmotoKbn.class);

    public final ExDBFieldString<HW_HrkmNyknTaisyouWk, C_NyktyhyoutKbn> nyktyhyoutkbn = new ExDBFieldString<>("nyktyhyoutkbn", this, UserType_C_NyktyhyoutKbn.class);

    public final ExDBFieldString<HW_HrkmNyknTaisyouWk, C_Syorizumiflg> syorizumiflg = new ExDBFieldString<>("syorizumiflg", this, UserType_C_Syorizumiflg.class);

    public final ExDBFieldString<HW_HrkmNyknTaisyouWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HW_HrkmNyknTaisyouWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
