package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HonninkakuninSyoruiKbn;
import yuyu.def.classification.C_KakoymdkyytknKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kykkaksyrui;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_NenkkntknKbn;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_SaiteiptknKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SentakuinfotknKbn;
import yuyu.def.classification.C_SignalkaihiKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SonotaTokuninKbn;
import yuyu.def.classification.C_SpgndtknKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TsngndtknKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.SV_SnkiykGtjSirtData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_HaitouKbn;
import yuyu.def.db.type.UserType_C_HaitoukinuketorihouKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_HknkknsmnKbn;
import yuyu.def.db.type.UserType_C_HonninkakuninSyoruiKbn;
import yuyu.def.db.type.UserType_C_KakoymdkyytknKbn;
import yuyu.def.db.type.UserType_C_KykKbn;
import yuyu.def.db.type.UserType_C_Kykkaksyrui;
import yuyu.def.db.type.UserType_C_Kyksei;
import yuyu.def.db.type.UserType_C_NenkkntknKbn;
import yuyu.def.db.type.UserType_C_Nstknsyu;
import yuyu.def.db.type.UserType_C_SaiteiptknKbn;
import yuyu.def.db.type.UserType_C_Sdpd;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_SeirituKbn;
import yuyu.def.db.type.UserType_C_SentakuinfotknKbn;
import yuyu.def.db.type.UserType_C_SignalkaihiKbn;
import yuyu.def.db.type.UserType_C_SntkhouKbn;
import yuyu.def.db.type.UserType_C_SonotaTokuninKbn;
import yuyu.def.db.type.UserType_C_SpgndtknKbn;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_TsngndtknKbn;
import yuyu.def.db.type.UserType_C_UktKbn;
import yuyu.def.db.type.UserType_C_UktsyuKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 新契約決算ベース月次成立情報ビュー のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQSV_SnkiykGtjSirtData extends AbstractExDBTable<SV_SnkiykGtjSirtData> {

    public GenQSV_SnkiykGtjSirtData() {
        this("SV_SnkiykGtjSirtData");
    }

    public GenQSV_SnkiykGtjSirtData(String pAlias) {
        super("SV_SnkiykGtjSirtData", SV_SnkiykGtjSirtData.class, pAlias);
    }

    public String SV_SnkiykGtjSirtData() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<SV_SnkiykGtjSirtData, Integer> renno8keta = new ExDBFieldNumber<>("renno8keta", this);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, BizDate> mosnrkymd = new ExDBFieldString<>("mosnrkymd", this, BizDateType.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, C_SeirituKbn> seiritukbn = new ExDBFieldString<>("seiritukbn", this, UserType_C_SeirituKbn.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, BizDate> srsyoriymd = new ExDBFieldString<>("srsyoriymd", this, BizDateType.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, BizDate> mosymd = new ExDBFieldString<>("mosymd", this, BizDateType.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, BizDate> mossakuseiymd = new ExDBFieldString<>("mossakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, BizDateYM> mosym = new ExDBFieldString<>("mosym", this, BizDateYMType.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, BizDate> kktymd = new ExDBFieldString<>("kktymd", this, BizDateType.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, BizDate> skykymd = new ExDBFieldString<>("skykymd", this, BizDateType.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, BizDate> sknnkaisiymd = new ExDBFieldString<>("sknnkaisiymd", this, BizDateType.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, BizDateYM> seisekiym = new ExDBFieldString<>("seisekiym", this, BizDateYMType.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, BizDateYM> skeikeijyouym = new ExDBFieldString<>("skeikeijyouym", this, BizDateYMType.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, C_KykKbn> kykkbn = new ExDBFieldString<>("kykkbn", this, UserType_C_KykKbn.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, C_UmuKbn> stdrsktkyhkumu = new ExDBFieldString<>("stdrsktkyhkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, C_Sdpd> sdpdkbn = new ExDBFieldString<>("sdpdkbn", this, UserType_C_Sdpd.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, C_SntkhouKbn> sntkhoukbn = new ExDBFieldString<>("sntkhoukbn", this, UserType_C_SntkhouKbn.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, C_HaitouKbn> haitoukbn = new ExDBFieldString<>("haitoukbn", this, UserType_C_HaitouKbn.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, C_HaitoukinuketorihouKbn> haitoukinuketorihoukbn = new ExDBFieldString<>("haitoukinuketorihoukbn", this, UserType_C_HaitoukinuketorihouKbn.class);

    public final ExDBFieldBizCurrency<SV_SnkiykGtjSirtData> fstphrkgk = new ExDBFieldBizCurrency<>("fstphrkgk", this);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, String> hhknnmkn = new ExDBFieldString<>("hhknnmkn", this);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, BizDate> hhknseiymd = new ExDBFieldString<>("hhknseiymd", this, BizDateType.class);

    public final ExDBFieldNumber<SV_SnkiykGtjSirtData, Integer> hhknnen = new ExDBFieldNumber<>("hhknnen", this);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, String> hhknsykgycd = new ExDBFieldString<>("hhknsykgycd", this);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, String> kyknmkn = new ExDBFieldString<>("kyknmkn", this);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, BizDate> kykseiymd = new ExDBFieldString<>("kykseiymd", this, BizDateType.class);

    public final ExDBFieldNumber<SV_SnkiykGtjSirtData, Integer> kyknen = new ExDBFieldNumber<>("kyknen", this);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, C_Kyksei> kyksei = new ExDBFieldString<>("kyksei", this, UserType_C_Kyksei.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, C_Nstknsyu> nstksbnsyu = new ExDBFieldString<>("nstksbnsyu", this, UserType_C_Nstknsyu.class);

    public final ExDBFieldNumber<SV_SnkiykGtjSirtData, Integer> nstksbnkkn = new ExDBFieldNumber<>("nstksbnkkn", this);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, C_HonninkakuninSyoruiKbn> kykhonninkakninsyoruikbn = new ExDBFieldString<>("kykhonninkakninsyoruikbn", this, UserType_C_HonninkakuninSyoruiKbn.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, String> ryouritusdno = new ExDBFieldString<>("ryouritusdno", this);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, C_SyutkKbn> syutkkbn = new ExDBFieldString<>("syutkkbn", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, BizNumber> yoteiriritu = new ExDBFieldString<>("yoteiriritu", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<SV_SnkiykGtjSirtData> seitoukihons = new ExDBFieldBizCurrency<>("seitoukihons", this);

    public final ExDBFieldBizCurrency<SV_SnkiykGtjSirtData> syutkp = new ExDBFieldBizCurrency<>("syutkp", this);

    public final ExDBFieldNumber<SV_SnkiykGtjSirtData, Integer> hknkkn = new ExDBFieldNumber<>("hknkkn", this);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, C_HknkknsmnKbn> hknkknsmnkbn = new ExDBFieldString<>("hknkknsmnkbn", this, UserType_C_HknkknsmnKbn.class);

    public final ExDBFieldNumber<SV_SnkiykGtjSirtData, Integer> mosdairitentblrenno = new ExDBFieldNumber<>("mosdairitentblrenno", this);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, String> cifcd = new ExDBFieldString<>("cifcd", this);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, String> drtencd = new ExDBFieldString<>("drtencd", this);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, String> bosyuucd = new ExDBFieldString<>("bosyuucd", this);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, String> daibosyuucd = new ExDBFieldString<>("daibosyuucd", this);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, String> drtenkanrisosikicd = new ExDBFieldString<>("drtenkanrisosikicd", this);

    public final ExDBFieldNumber<SV_SnkiykGtjSirtData, Integer> kykKaktblrenno = new ExDBFieldNumber<>("kykKaktblrenno", this);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, C_Kykkaksyrui> kykkaksyrui = new ExDBFieldString<>("kykkaksyrui", this, UserType_C_Kykkaksyrui.class);

    public final ExDBFieldNumber<SV_SnkiykGtjSirtData, Integer> nyuukintblrenno = new ExDBFieldNumber<>("nyuukintblrenno", this);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, BizDate> ryosyuymd = new ExDBFieldString<>("ryosyuymd", this, BizDateType.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, C_SpgndtknKbn> spgndtknkbn = new ExDBFieldString<>("spgndtknkbn", this, UserType_C_SpgndtknKbn.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, C_NenkkntknKbn> nenkkntknkbn = new ExDBFieldString<>("nenkkntknkbn", this, UserType_C_NenkkntknKbn.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, C_TsngndtknKbn> tsngndtknkbn = new ExDBFieldString<>("tsngndtknkbn", this, UserType_C_TsngndtknKbn.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, C_SentakuinfotknKbn> sentakuinfotknkbn = new ExDBFieldString<>("sentakuinfotknkbn", this, UserType_C_SentakuinfotknKbn.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, C_KakoymdkyytknKbn> kakoymdkyytknkbn = new ExDBFieldString<>("kakoymdkyytknkbn", this, UserType_C_KakoymdkyytknKbn.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, C_SaiteiptknKbn> saiteiptknkbn = new ExDBFieldString<>("saiteiptknkbn", this, UserType_C_SaiteiptknKbn.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, C_SignalkaihiKbn> signalkaihikbn = new ExDBFieldString<>("signalkaihikbn", this, UserType_C_SignalkaihiKbn.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, C_SonotaTokuninKbn> sonotatknkbn = new ExDBFieldString<>("sonotatknkbn", this, UserType_C_SonotaTokuninKbn.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, String> drtenkanritodoufukencd = new ExDBFieldString<>("drtenkanritodoufukencd", this);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, C_UktsyuKbn> uktsyukbn = new ExDBFieldString<>("uktsyukbn", this, UserType_C_UktsyuKbn.class);

    public final ExDBFieldNumber<SV_SnkiykGtjSirtData, Integer> uktsyurenno = new ExDBFieldNumber<>("uktsyurenno", this);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, C_UktKbn> uktkbn = new ExDBFieldString<>("uktkbn", this, UserType_C_UktKbn.class);

    public final ExDBFieldString<SV_SnkiykGtjSirtData, C_Segcd> seg1cd = new ExDBFieldString<>("seg1cd", this, UserType_C_Segcd.class);
}
