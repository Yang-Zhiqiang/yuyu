package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.SV_SnkiykSyunyupData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_HaitouKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_HknkknsmnKbn;
import yuyu.def.db.type.UserType_C_Sdpd;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_SeirituKbn;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 新契約収入P統計情報ビュー のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQSV_SnkiykSyunyupData extends AbstractExDBTable<SV_SnkiykSyunyupData> {

    public GenQSV_SnkiykSyunyupData() {
        this("SV_SnkiykSyunyupData");
    }

    public GenQSV_SnkiykSyunyupData(String pAlias) {
        super("SV_SnkiykSyunyupData", SV_SnkiykSyunyupData.class, pAlias);
    }

    public String SV_SnkiykSyunyupData() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<SV_SnkiykSyunyupData, Integer> renno8keta = new ExDBFieldNumber<>("renno8keta", this);

    public final ExDBFieldString<SV_SnkiykSyunyupData, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<SV_SnkiykSyunyupData, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<SV_SnkiykSyunyupData, C_SeirituKbn> seiritukbn = new ExDBFieldString<>("seiritukbn", this, UserType_C_SeirituKbn.class);

    public final ExDBFieldString<SV_SnkiykSyunyupData, BizDate> srsyoriymd = new ExDBFieldString<>("srsyoriymd", this, BizDateType.class);

    public final ExDBFieldString<SV_SnkiykSyunyupData, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<SV_SnkiykSyunyupData, BizDateYM> seisekiym = new ExDBFieldString<>("seisekiym", this, BizDateYMType.class);

    public final ExDBFieldString<SV_SnkiykSyunyupData, BizDateYM> skeikeijyouym = new ExDBFieldString<>("skeikeijyouym", this, BizDateYMType.class);

    public final ExDBFieldString<SV_SnkiykSyunyupData, C_Sdpd> sdpdkbn = new ExDBFieldString<>("sdpdkbn", this, UserType_C_Sdpd.class);

    public final ExDBFieldString<SV_SnkiykSyunyupData, C_HaitouKbn> haitoukbn = new ExDBFieldString<>("haitoukbn", this, UserType_C_HaitouKbn.class);

    public final ExDBFieldBizCurrency<SV_SnkiykSyunyupData> hyouteip = new ExDBFieldBizCurrency<>("hyouteip", this);

    public final ExDBFieldBizCurrency<SV_SnkiykSyunyupData> fstphrkgk = new ExDBFieldBizCurrency<>("fstphrkgk", this);

    public final ExDBFieldString<SV_SnkiykSyunyupData, BizDate> hhknseiymd = new ExDBFieldString<>("hhknseiymd", this, BizDateType.class);

    public final ExDBFieldNumber<SV_SnkiykSyunyupData, Integer> hhknnen = new ExDBFieldNumber<>("hhknnen", this);

    public final ExDBFieldString<SV_SnkiykSyunyupData, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldString<SV_SnkiykSyunyupData, BizDate> kykseiymd = new ExDBFieldString<>("kykseiymd", this, BizDateType.class);

    public final ExDBFieldNumber<SV_SnkiykSyunyupData, Integer> kyknen = new ExDBFieldNumber<>("kyknen", this);

    public final ExDBFieldString<SV_SnkiykSyunyupData, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<SV_SnkiykSyunyupData, String> ryouritusdno = new ExDBFieldString<>("ryouritusdno", this);

    public final ExDBFieldString<SV_SnkiykSyunyupData, C_SyutkKbn> syutkkbn = new ExDBFieldString<>("syutkkbn", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldBizCurrency<SV_SnkiykSyunyupData> seitoukihons = new ExDBFieldBizCurrency<>("seitoukihons", this);

    public final ExDBFieldBizCurrency<SV_SnkiykSyunyupData> syutkp = new ExDBFieldBizCurrency<>("syutkp", this);

    public final ExDBFieldNumber<SV_SnkiykSyunyupData, Integer> hknkkn = new ExDBFieldNumber<>("hknkkn", this);

    public final ExDBFieldString<SV_SnkiykSyunyupData, C_HknkknsmnKbn> hknkknsmnkbn = new ExDBFieldString<>("hknkknsmnkbn", this, UserType_C_HknkknsmnKbn.class);

    public final ExDBFieldNumber<SV_SnkiykSyunyupData, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<SV_SnkiykSyunyupData, String> drtencd = new ExDBFieldString<>("drtencd", this);

    public final ExDBFieldString<SV_SnkiykSyunyupData, String> daibosyuucd = new ExDBFieldString<>("daibosyuucd", this);

    public final ExDBFieldString<SV_SnkiykSyunyupData, String> drtenkanrisosikicd = new ExDBFieldString<>("drtenkanrisosikicd", this);

    public final ExDBFieldString<SV_SnkiykSyunyupData, C_UmuKbn> hengakuumu = new ExDBFieldString<>("hengakuumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_SnkiykSyunyupData, C_Segcd> seg1cd = new ExDBFieldString<>("seg1cd", this, UserType_C_Segcd.class);
}
