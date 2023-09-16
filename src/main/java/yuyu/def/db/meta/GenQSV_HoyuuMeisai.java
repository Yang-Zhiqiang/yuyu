package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.SV_HoyuuMeisai;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_HaitoukinuketorihouKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_Ketkekkacd;
import yuyu.def.db.type.UserType_C_Sdpd;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 保有明細情報ビュー のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQSV_HoyuuMeisai extends AbstractExDBTable<SV_HoyuuMeisai> {

    public GenQSV_HoyuuMeisai() {
        this("SV_HoyuuMeisai");
    }

    public GenQSV_HoyuuMeisai(String pAlias) {
        super("SV_HoyuuMeisai", SV_HoyuuMeisai.class, pAlias);
    }

    public String SV_HoyuuMeisai() {
        return getAliasExpression();
    }

    public final ExDBFieldString<SV_HoyuuMeisai, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<SV_HoyuuMeisai, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<SV_HoyuuMeisai, C_Sdpd> sdpdkbn = new ExDBFieldString<>("sdpdkbn", this, UserType_C_Sdpd.class);

    public final ExDBFieldBizCurrency<SV_HoyuuMeisai> hrkp = new ExDBFieldBizCurrency<>("hrkp", this);

    public final ExDBFieldString<SV_HoyuuMeisai, BizDateYM> bosyuuym = new ExDBFieldString<>("bosyuuym", this, BizDateYMType.class);

    public final ExDBFieldString<SV_HoyuuMeisai, BizDateYM> skeikeijyouym = new ExDBFieldString<>("skeikeijyouym", this, BizDateYMType.class);

    public final ExDBFieldString<SV_HoyuuMeisai, String> hhknsykgycd = new ExDBFieldString<>("hhknsykgycd", this);

    public final ExDBFieldString<SV_HoyuuMeisai, String> drtenkanritodoufukencd = new ExDBFieldString<>("drtenkanritodoufukencd", this);

    public final ExDBFieldString<SV_HoyuuMeisai, String> cifcd = new ExDBFieldString<>("cifcd", this);

    public final ExDBFieldString<SV_HoyuuMeisai, BizDate> fstpnyknymd = new ExDBFieldString<>("fstpnyknymd", this, BizDateType.class);

    public final ExDBFieldString<SV_HoyuuMeisai, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<SV_HoyuuMeisai, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<SV_HoyuuMeisai, C_HaitoukinuketorihouKbn> haitoukinuketorihoukbn = new ExDBFieldString<>("haitoukinuketorihoukbn", this, UserType_C_HaitoukinuketorihouKbn.class);

    public final ExDBFieldString<SV_HoyuuMeisai, C_TkiktbrisyuruiKbn> tikiktbrisyuruikbn = new ExDBFieldString<>("tikiktbrisyuruikbn", this, UserType_C_TkiktbrisyuruiKbn.class);

    public final ExDBFieldString<SV_HoyuuMeisai, String> drtencd = new ExDBFieldString<>("drtencd", this);

    public final ExDBFieldString<SV_HoyuuMeisai, String> drtenkanrisosikicd = new ExDBFieldString<>("drtenkanrisosikicd", this);

    public final ExDBFieldString<SV_HoyuuMeisai, String> daibosyuucd = new ExDBFieldString<>("daibosyuucd", this);

    public final ExDBFieldString<SV_HoyuuMeisai, C_UmuKbn> drtenbunumu = new ExDBFieldString<>("drtenbunumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_HoyuuMeisai, String> kyksakuinmeino = new ExDBFieldString<>("kyksakuinmeino", this);

    public final ExDBFieldString<SV_HoyuuMeisai, C_Tdk> kkkyktdk = new ExDBFieldString<>("kkkyktdk", this, UserType_C_Tdk.class);

    public final ExDBFieldString<SV_HoyuuMeisai, BizDate> kykseiymd = new ExDBFieldString<>("kykseiymd", this, BizDateType.class);

    public final ExDBFieldString<SV_HoyuuMeisai, C_Ketkekkacd> ketkekkacd = new ExDBFieldString<>("ketkekkacd", this, UserType_C_Ketkekkacd.class);

    public final ExDBFieldString<SV_HoyuuMeisai, String> palketsyacd = new ExDBFieldString<>("palketsyacd", this);

    public final ExDBFieldString<SV_HoyuuMeisai, C_UmuKbn> stdrsktkyhkumu = new ExDBFieldString<>("stdrsktkyhkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_HoyuuMeisai, BizDate> stdrsktkyhkymd = new ExDBFieldString<>("stdrsktkyhkymd", this, BizDateType.class);

    public final ExDBFieldString<SV_HoyuuMeisai, C_UmuKbn> yenshrtkhkumu = new ExDBFieldString<>("yenshrtkhkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_HoyuuMeisai, C_UmuKbn> initsbjiyensitihsytkhukaumu = new ExDBFieldString<>("initsbjiyensitihsytkhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldBizCurrency<SV_HoyuuMeisai> initsbjiyenkasaiteihsygk = new ExDBFieldBizCurrency<>("initsbjiyenkasaiteihsygk", this);

    public final ExDBFieldString<SV_HoyuuMeisai, C_UmuKbn> jyudkaigomeharaitkhukaumu = new ExDBFieldString<>("jyudkaigomeharaitkhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_HoyuuMeisai, C_UmuKbn> targettkhkumu = new ExDBFieldString<>("targettkhkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_HoyuuMeisai, BizDate> targettkykkykhenkoymd = new ExDBFieldString<>("targettkykkykhenkoymd", this, BizDateType.class);

    public final ExDBFieldNumber<SV_HoyuuMeisai, Integer> targettkmokuhyouti = new ExDBFieldNumber<>("targettkmokuhyouti", this);

    public final ExDBFieldBizCurrency<SV_HoyuuMeisai> targettkykkijyungk = new ExDBFieldBizCurrency<>("targettkykkijyungk", this);

    public final ExDBFieldString<SV_HoyuuMeisai, C_UmuKbn> kykdrtkykhukaumu = new ExDBFieldString<>("kykdrtkykhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_HoyuuMeisai, BizDate> kykdrtkykhukaymd = new ExDBFieldString<>("kykdrtkykhukaymd", this, BizDateType.class);

    public final ExDBFieldString<SV_HoyuuMeisai, BizDate> kykdrtkykkaiyakuymd = new ExDBFieldString<>("kykdrtkykkaiyakuymd", this, BizDateType.class);

    public final ExDBFieldString<SV_HoyuuMeisai, C_UmuKbn> teikishrtkykhukaumu = new ExDBFieldString<>("teikishrtkykhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_HoyuuMeisai, BizDate> yendthnkymd = new ExDBFieldString<>("yendthnkymd", this, BizDateType.class);

    public final ExDBFieldString<SV_HoyuuMeisai, BizDateYM> jkipjytym = new ExDBFieldString<>("jkipjytym", this, BizDateYMType.class);

    public final ExDBFieldString<SV_HoyuuMeisai, BizDate> zennoukaisiymd = new ExDBFieldString<>("zennoukaisiymd", this, BizDateType.class);

    public final ExDBFieldString<SV_HoyuuMeisai, String> zennoukikan = new ExDBFieldString<>("zennoukikan", this);
}
