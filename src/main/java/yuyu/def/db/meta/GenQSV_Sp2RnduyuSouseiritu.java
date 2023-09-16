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
import yuyu.def.classification.C_HonninkakuninSyoruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_KakoymdkyytknKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kykkaksyrui;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_NenkkntknKbn;
import yuyu.def.classification.C_SaiteiptknKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SentakuinfotknKbn;
import yuyu.def.classification.C_SignalkaihiKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SonotaTokuninKbn;
import yuyu.def.classification.C_SpgndtknKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TsngndtknKbn;
import yuyu.def.classification.C_TumitatekinHaibunWariKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.SV_Sp2RnduyuSouseiritu;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_HaitouKbn;
import yuyu.def.db.type.UserType_C_HaitoukinuketorihouKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_HonninkakuninSyoruiKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_IkkatubaraiKaisuuKbn;
import yuyu.def.db.type.UserType_C_KakoymdkyytknKbn;
import yuyu.def.db.type.UserType_C_KykKbn;
import yuyu.def.db.type.UserType_C_Kykkaksyrui;
import yuyu.def.db.type.UserType_C_Kyksei;
import yuyu.def.db.type.UserType_C_NenkkntknKbn;
import yuyu.def.db.type.UserType_C_SaiteiptknKbn;
import yuyu.def.db.type.UserType_C_Sdpd;
import yuyu.def.db.type.UserType_C_SeirituKbn;
import yuyu.def.db.type.UserType_C_SentakuinfotknKbn;
import yuyu.def.db.type.UserType_C_SignalkaihiKbn;
import yuyu.def.db.type.UserType_C_Sisuukbn;
import yuyu.def.db.type.UserType_C_SntkhouKbn;
import yuyu.def.db.type.UserType_C_SonotaTokuninKbn;
import yuyu.def.db.type.UserType_C_SpgndtknKbn;
import yuyu.def.db.type.UserType_C_Tkhukaumu;
import yuyu.def.db.type.UserType_C_TsngndtknKbn;
import yuyu.def.db.type.UserType_C_TumitatekinHaibunWariKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * ＳＰ２連動用総成立情報ビュー のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQSV_Sp2RnduyuSouseiritu extends AbstractExDBTable<SV_Sp2RnduyuSouseiritu> {

    public GenQSV_Sp2RnduyuSouseiritu() {
        this("SV_Sp2RnduyuSouseiritu");
    }

    public GenQSV_Sp2RnduyuSouseiritu(String pAlias) {
        super("SV_Sp2RnduyuSouseiritu", SV_Sp2RnduyuSouseiritu.class, pAlias);
    }

    public String SV_Sp2RnduyuSouseiritu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, BizDate> mosnrkymd = new ExDBFieldString<>("mosnrkymd", this, BizDateType.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, BizNumber> nyknkwsrate = new ExDBFieldString<>("nyknkwsrate", this, BizNumberType.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_SeirituKbn> seiritukbn = new ExDBFieldString<>("seiritukbn", this, UserType_C_SeirituKbn.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, BizDate> srsyoriymd = new ExDBFieldString<>("srsyoriymd", this, BizDateType.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, BizDate> mosymd = new ExDBFieldString<>("mosymd", this, BizDateType.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, BizDate> mossakuseiymd = new ExDBFieldString<>("mossakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, BizDateYM> mosym = new ExDBFieldString<>("mosym", this, BizDateYMType.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, BizDate> skykymd = new ExDBFieldString<>("skykymd", this, BizDateType.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, BizDate> sknnkaisiymd = new ExDBFieldString<>("sknnkaisiymd", this, BizDateType.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, BizDateYM> seisekiym = new ExDBFieldString<>("seisekiym", this, BizDateYMType.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, BizDateYM> skeikeijyouym = new ExDBFieldString<>("skeikeijyouym", this, BizDateYMType.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_KykKbn> kykkbn = new ExDBFieldString<>("kykkbn", this, UserType_C_KykKbn.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_Tkhukaumu> kykdrtkykhukakbn = new ExDBFieldString<>("kykdrtkykhukakbn", this, UserType_C_Tkhukaumu.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_Tkhukaumu> stdrsktkyhkkbn = new ExDBFieldString<>("stdrsktkyhkkbn", this, UserType_C_Tkhukaumu.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_Sdpd> sdpdkbn = new ExDBFieldString<>("sdpdkbn", this, UserType_C_Sdpd.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_SntkhouKbn> sntkhoukbn = new ExDBFieldString<>("sntkhoukbn", this, UserType_C_SntkhouKbn.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_HaitouKbn> haitoukbn = new ExDBFieldString<>("haitoukbn", this, UserType_C_HaitouKbn.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_HaitoukinuketorihouKbn> haitoukinuketorihoukbn = new ExDBFieldString<>("haitoukinuketorihoukbn", this, UserType_C_HaitoukinuketorihouKbn.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_Tuukasyu> hrktuukasyu = new ExDBFieldString<>("hrktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldNumber<SV_Sp2RnduyuSouseiritu, Integer> znnkai = new ExDBFieldNumber<>("znnkai", this);

    public final ExDBFieldBizCurrency<SV_Sp2RnduyuSouseiritu> hyouteip = new ExDBFieldBizCurrency<>("hyouteip", this);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, String> hhknnmkn = new ExDBFieldString<>("hhknnmkn", this);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, BizDate> hhknseiymd = new ExDBFieldString<>("hhknseiymd", this, BizDateType.class);

    public final ExDBFieldNumber<SV_Sp2RnduyuSouseiritu, Integer> hhknnen = new ExDBFieldNumber<>("hhknnen", this);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, String> hhknsykgycd = new ExDBFieldString<>("hhknsykgycd", this);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, String> kyknmkn = new ExDBFieldString<>("kyknmkn", this);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, BizDate> kykseiymd = new ExDBFieldString<>("kykseiymd", this, BizDateType.class);

    public final ExDBFieldNumber<SV_Sp2RnduyuSouseiritu, Integer> kyknen = new ExDBFieldNumber<>("kyknen", this);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_Kyksei> kyksei = new ExDBFieldString<>("kyksei", this, UserType_C_Kyksei.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_HonninkakuninSyoruiKbn> kykhonninkakninsyoruikbn = new ExDBFieldString<>("kykhonninkakninsyoruikbn", this, UserType_C_HonninkakuninSyoruiKbn.class);

    public final ExDBFieldBizCurrency<SV_Sp2RnduyuSouseiritu> heijyunp = new ExDBFieldBizCurrency<>("heijyunp", this);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_IkkatubaraiKaisuuKbn> ikkatubaraikaisuu = new ExDBFieldString<>("ikkatubaraikaisuu", this, UserType_C_IkkatubaraiKaisuuKbn.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, BizDate> kktymd = new ExDBFieldString<>("kktymd", this, BizDateType.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_Kykkaksyrui> kykkaksyrui = new ExDBFieldString<>("kykkaksyrui", this, UserType_C_Kykkaksyrui.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_SpgndtknKbn> spgndtknkbn = new ExDBFieldString<>("spgndtknkbn", this, UserType_C_SpgndtknKbn.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_NenkkntknKbn> nenkkntknkbn = new ExDBFieldString<>("nenkkntknkbn", this, UserType_C_NenkkntknKbn.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_TsngndtknKbn> tsngndtknkbn = new ExDBFieldString<>("tsngndtknkbn", this, UserType_C_TsngndtknKbn.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_SentakuinfotknKbn> sentakuinfotknkbn = new ExDBFieldString<>("sentakuinfotknkbn", this, UserType_C_SentakuinfotknKbn.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_KakoymdkyytknKbn> kakoymdkyytknkbn = new ExDBFieldString<>("kakoymdkyytknkbn", this, UserType_C_KakoymdkyytknKbn.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_SaiteiptknKbn> saiteiptknkbn = new ExDBFieldString<>("saiteiptknkbn", this, UserType_C_SaiteiptknKbn.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_SignalkaihiKbn> signalkaihikbn = new ExDBFieldString<>("signalkaihikbn", this, UserType_C_SignalkaihiKbn.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_SonotaTokuninKbn> sonotatknkbn = new ExDBFieldString<>("sonotatknkbn", this, UserType_C_SonotaTokuninKbn.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, String> drtenkanritodoufukencd = new ExDBFieldString<>("drtenkanritodoufukencd", this);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_UmuKbn> yenshrtkhkumu = new ExDBFieldString<>("yenshrtkhkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_UmuKbn> initsbjiyensitihsytkhukaumu = new ExDBFieldString<>("initsbjiyensitihsytkhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldBizCurrency<SV_Sp2RnduyuSouseiritu> initsbjiyenkasaiteihsygk = new ExDBFieldBizCurrency<>("initsbjiyenkasaiteihsygk", this);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_UmuKbn> jyudkaigomeharaitkhukaumu = new ExDBFieldString<>("jyudkaigomeharaitkhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_UmuKbn> targettkhkumu = new ExDBFieldString<>("targettkhkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, BizDate> targettkykkykhenkoymd = new ExDBFieldString<>("targettkykkykhenkoymd", this, BizDateType.class);

    public final ExDBFieldNumber<SV_Sp2RnduyuSouseiritu, Integer> targettkmokuhyouti = new ExDBFieldNumber<>("targettkmokuhyouti", this);

    public final ExDBFieldBizCurrency<SV_Sp2RnduyuSouseiritu> targettkykkijyungk = new ExDBFieldBizCurrency<>("targettkykkijyungk", this);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_UmuKbn> teikishrtkykhukaumu = new ExDBFieldString<>("teikishrtkykhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_TumitatekinHaibunWariKbn> sisuuhaibunwarikbn = new ExDBFieldString<>("sisuuhaibunwarikbn", this, UserType_C_TumitatekinHaibunWariKbn.class);

    public final ExDBFieldString<SV_Sp2RnduyuSouseiritu, C_Sisuukbn> sisuukbn = new ExDBFieldString<>("sisuukbn", this, UserType_C_Sisuukbn.class);
}
