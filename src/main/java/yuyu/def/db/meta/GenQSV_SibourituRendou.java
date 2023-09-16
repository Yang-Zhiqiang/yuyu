package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_Ketriyuucd;
import yuyu.def.classification.C_Kykkaksyrui;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.SV_SibourituRendou;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_HaitouKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_Ketkekkacd;
import yuyu.def.db.type.UserType_C_Ketriyuucd;
import yuyu.def.db.type.UserType_C_Kykkaksyrui;
import yuyu.def.db.type.UserType_C_NensyuuKbn;
import yuyu.def.db.type.UserType_C_SeirituKbn;
import yuyu.def.db.type.UserType_C_SntkhouKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 死亡率用連動情報ビュー のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQSV_SibourituRendou extends AbstractExDBTable<SV_SibourituRendou> {

    public GenQSV_SibourituRendou() {
        this("SV_SibourituRendou");
    }

    public GenQSV_SibourituRendou(String pAlias) {
        super("SV_SibourituRendou", SV_SibourituRendou.class, pAlias);
    }

    public String SV_SibourituRendou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<SV_SibourituRendou, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<SV_SibourituRendou, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<SV_SibourituRendou, C_SeirituKbn> seiritukbn = new ExDBFieldString<>("seiritukbn", this, UserType_C_SeirituKbn.class);

    public final ExDBFieldString<SV_SibourituRendou, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<SV_SibourituRendou, BizDate> sknnkaisiymd = new ExDBFieldString<>("sknnkaisiymd", this, BizDateType.class);

    public final ExDBFieldString<SV_SibourituRendou, BizDateYM> bosyuuym = new ExDBFieldString<>("bosyuuym", this, BizDateYMType.class);

    public final ExDBFieldString<SV_SibourituRendou, C_SntkhouKbn> sntkhoukbn = new ExDBFieldString<>("sntkhoukbn", this, UserType_C_SntkhouKbn.class);

    public final ExDBFieldString<SV_SibourituRendou, C_HaitouKbn> haitoukbn = new ExDBFieldString<>("haitoukbn", this, UserType_C_HaitouKbn.class);

    public final ExDBFieldString<SV_SibourituRendou, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<SV_SibourituRendou, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<SV_SibourituRendou, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<SV_SibourituRendou, BizDate> hhknseiymd = new ExDBFieldString<>("hhknseiymd", this, BizDateType.class);

    public final ExDBFieldNumber<SV_SibourituRendou, Integer> hhknnen = new ExDBFieldNumber<>("hhknnen", this);

    public final ExDBFieldString<SV_SibourituRendou, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldString<SV_SibourituRendou, String> hhknsykgycd = new ExDBFieldString<>("hhknsykgycd", this);

    public final ExDBFieldString<SV_SibourituRendou, C_NensyuuKbn> hhknnensyuukbn = new ExDBFieldString<>("hhknnensyuukbn", this, UserType_C_NensyuuKbn.class);

    public final ExDBFieldBizCurrency<SV_SibourituRendou> pharaikomisougaku = new ExDBFieldBizCurrency<>("pharaikomisougaku", this);

    public final ExDBFieldNumber<SV_SibourituRendou, Integer> sintyou = new ExDBFieldNumber<>("sintyou", this);

    public final ExDBFieldNumber<SV_SibourituRendou, Integer> taijyuu = new ExDBFieldNumber<>("taijyuu", this);

    public final ExDBFieldString<SV_SibourituRendou, String> oyadrtencd = new ExDBFieldString<>("oyadrtencd", this);

    public final ExDBFieldString<SV_SibourituRendou, String> tratkiagcd = new ExDBFieldString<>("tratkiagcd", this);

    public final ExDBFieldString<SV_SibourituRendou, String> daibosyuucd = new ExDBFieldString<>("daibosyuucd", this);

    public final ExDBFieldString<SV_SibourituRendou, String> drtenkanrisosikicd = new ExDBFieldString<>("drtenkanrisosikicd", this);

    public final ExDBFieldString<SV_SibourituRendou, BizNumber> bunwari = new ExDBFieldString<>("bunwari", this, BizNumberType.class);

    public final ExDBFieldString<SV_SibourituRendou, C_Kykkaksyrui> kykkaksyrui = new ExDBFieldString<>("kykkaksyrui", this, UserType_C_Kykkaksyrui.class);

    public final ExDBFieldString<SV_SibourituRendou, C_Ketkekkacd> ketkekkacd = new ExDBFieldString<>("ketkekkacd", this, UserType_C_Ketkekkacd.class);

    public final ExDBFieldString<SV_SibourituRendou, C_Ketriyuucd> ketriyuucd1 = new ExDBFieldString<>("ketriyuucd1", this, UserType_C_Ketriyuucd.class);

    public final ExDBFieldString<SV_SibourituRendou, C_Ketriyuucd> ketriyuucd2 = new ExDBFieldString<>("ketriyuucd2", this, UserType_C_Ketriyuucd.class);

    public final ExDBFieldString<SV_SibourituRendou, C_Ketriyuucd> ketriyuucd3 = new ExDBFieldString<>("ketriyuucd3", this, UserType_C_Ketriyuucd.class);

    public final ExDBFieldString<SV_SibourituRendou, C_Ketriyuucd> ketriyuucd4 = new ExDBFieldString<>("ketriyuucd4", this, UserType_C_Ketriyuucd.class);

    public final ExDBFieldString<SV_SibourituRendou, String> palketsyacd = new ExDBFieldString<>("palketsyacd", this);

    public final ExDBFieldString<SV_SibourituRendou, String> hhkntodouhukencd = new ExDBFieldString<>("hhkntodouhukencd", this);

    public final ExDBFieldString<SV_SibourituRendou, C_UmuKbn> initsbjiyensitihsytkhukaumu = new ExDBFieldString<>("initsbjiyensitihsytkhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldBizCurrency<SV_SibourituRendou> initsbjiyenkasaiteihsygk = new ExDBFieldBizCurrency<>("initsbjiyenkasaiteihsygk", this);
}
