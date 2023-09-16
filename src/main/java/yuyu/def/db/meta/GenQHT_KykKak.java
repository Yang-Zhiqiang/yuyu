package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KykkakkekKbn;
import yuyu.def.classification.C_Kykkaksyrui;
import yuyu.def.db.entity.HT_KykKak;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_KykkakkekKbn;
import yuyu.def.db.type.UserType_C_Kykkaksyrui;

/**
 * 契約確認テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_KykKak extends AbstractExDBTable<HT_KykKak> {

    public GenQHT_KykKak() {
        this("HT_KykKak");
    }

    public GenQHT_KykKak(String pAlias) {
        super("HT_KykKak", HT_KykKak.class, pAlias);
    }

    public String HT_KykKak() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_KykKak, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldNumber<HT_KykKak, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<HT_KykKak, C_Kykkaksyrui> kykkaksyrui = new ExDBFieldString<>("kykkaksyrui", this, UserType_C_Kykkaksyrui.class);

    public final ExDBFieldString<HT_KykKak, String> kykkaktantcd = new ExDBFieldString<>("kykkaktantcd", this);

    public final ExDBFieldString<HT_KykKak, String> kykkakkaisyacd = new ExDBFieldString<>("kykkakkaisyacd", this);

    public final ExDBFieldString<HT_KykKak, BizDate> kykkakiraiymd = new ExDBFieldString<>("kykkakiraiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_KykKak, BizDate> kykkakkanytymd = new ExDBFieldString<>("kykkakkanytymd", this, BizDateType.class);

    public final ExDBFieldString<HT_KykKak, C_KykkakkekKbn> kykkakkekkbn = new ExDBFieldString<>("kykkakkekkbn", this, UserType_C_KykkakkekKbn.class);

    public final ExDBFieldString<HT_KykKak, BizDate> kykkakkanymd = new ExDBFieldString<>("kykkakkanymd", this, BizDateType.class);

    public final ExDBFieldString<HT_KykKak, String> kykkakcomment = new ExDBFieldString<>("kykkakcomment", this);

    public final ExDBFieldString<HT_KykKak, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_KykKak, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
