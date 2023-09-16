package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HrkmnykndatarenmotoKbn;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HW_MosMatiKknKeikaWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HrkmnykndatarenmotoKbn;
import yuyu.def.db.type.UserType_C_NyktyhyoutKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 申込書入力待期間経過ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHW_MosMatiKknKeikaWk extends AbstractExDBTable<HW_MosMatiKknKeikaWk> {

    public GenQHW_MosMatiKknKeikaWk() {
        this("HW_MosMatiKknKeikaWk");
    }

    public GenQHW_MosMatiKknKeikaWk(String pAlias) {
        super("HW_MosMatiKknKeikaWk", HW_MosMatiKknKeikaWk.class, pAlias);
    }

    public String HW_MosMatiKknKeikaWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HW_MosMatiKknKeikaWk, BizDate> nyksyoriymd = new ExDBFieldString<>("nyksyoriymd", this, BizDateType.class);

    public final ExDBFieldString<HW_MosMatiKknKeikaWk, String> itirenno = new ExDBFieldString<>("itirenno", this);

    public final ExDBFieldString<HW_MosMatiKknKeikaWk, String> oyadrtencd = new ExDBFieldString<>("oyadrtencd", this);

    public final ExDBFieldString<HW_MosMatiKknKeikaWk, BizDate> knjyymd = new ExDBFieldString<>("knjyymd", this, BizDateType.class);

    public final ExDBFieldString<HW_MosMatiKknKeikaWk, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HW_MosMatiKknKeikaWk, String> hrkmirninnm = new ExDBFieldString<>("hrkmirninnm", this);

    public final ExDBFieldBizCurrency<HW_MosMatiKknKeikaWk> trhkkgk = new ExDBFieldBizCurrency<>("trhkkgk", this);

    public final ExDBFieldString<HW_MosMatiKknKeikaWk, C_Tuukasyu> rstuukasyu = new ExDBFieldString<>("rstuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<HW_MosMatiKknKeikaWk, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<HW_MosMatiKknKeikaWk, String> nyuukinoyadrtennm = new ExDBFieldString<>("nyuukinoyadrtennm", this);

    public final ExDBFieldString<HW_MosMatiKknKeikaWk, C_HrkmnykndatarenmotoKbn> hrkmnykndatarenmotoKbn = new ExDBFieldString<>("hrkmnykndatarenmotoKbn", this, UserType_C_HrkmnykndatarenmotoKbn.class);

    public final ExDBFieldString<HW_MosMatiKknKeikaWk, C_NyktyhyoutKbn> nyktyhyoutkbn = new ExDBFieldString<>("nyktyhyoutkbn", this, UserType_C_NyktyhyoutKbn.class);

    public final ExDBFieldString<HW_MosMatiKknKeikaWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HW_MosMatiKknKeikaWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
