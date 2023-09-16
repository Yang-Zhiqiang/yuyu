package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.SV_BikinIdouMeisai;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_BknJkuKbn;
import yuyu.def.db.type.UserType_C_BkncdKbn;
import yuyu.def.db.type.UserType_C_BknrigiKbn;
import yuyu.def.db.type.UserType_C_HaitoukinuketorihouKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_Ketkekkacd;
import yuyu.def.db.type.UserType_C_Sdpd;
import yuyu.def.db.type.UserType_C_SiinKbn;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 備金異動明細情報ビュー のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQSV_BikinIdouMeisai extends AbstractExDBTable<SV_BikinIdouMeisai> {

    public GenQSV_BikinIdouMeisai() {
        this("SV_BikinIdouMeisai");
    }

    public GenQSV_BikinIdouMeisai(String pAlias) {
        super("SV_BikinIdouMeisai", SV_BikinIdouMeisai.class, pAlias);
    }

    public String SV_BikinIdouMeisai() {
        return getAliasExpression();
    }

    public final ExDBFieldString<SV_BikinIdouMeisai, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<SV_BikinIdouMeisai, C_Sdpd> sdpdkbn = new ExDBFieldString<>("sdpdkbn", this, UserType_C_Sdpd.class);

    public final ExDBFieldBizCurrency<SV_BikinIdouMeisai> hrkp = new ExDBFieldBizCurrency<>("hrkp", this);

    public final ExDBFieldString<SV_BikinIdouMeisai, BizDateYM> bosyuuym = new ExDBFieldString<>("bosyuuym", this, BizDateYMType.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, BizDateYM> skeikeijyouym = new ExDBFieldString<>("skeikeijyouym", this, BizDateYMType.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, String> hhknsykgycd = new ExDBFieldString<>("hhknsykgycd", this);

    public final ExDBFieldString<SV_BikinIdouMeisai, String> drtenkanritodoufukencd = new ExDBFieldString<>("drtenkanritodoufukencd", this);

    public final ExDBFieldString<SV_BikinIdouMeisai, String> cifcd = new ExDBFieldString<>("cifcd", this);

    public final ExDBFieldString<SV_BikinIdouMeisai, BizDate> fstpnyknymd = new ExDBFieldString<>("fstpnyknymd", this, BizDateType.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, C_HaitoukinuketorihouKbn> haitoukinuketorihoukbn = new ExDBFieldString<>("haitoukinuketorihoukbn", this, UserType_C_HaitoukinuketorihouKbn.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, C_TkiktbrisyuruiKbn> tikiktbrisyuruikbn = new ExDBFieldString<>("tikiktbrisyuruikbn", this, UserType_C_TkiktbrisyuruiKbn.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, String> drtencd = new ExDBFieldString<>("drtencd", this);

    public final ExDBFieldString<SV_BikinIdouMeisai, String> drtenkanrisosikicd = new ExDBFieldString<>("drtenkanrisosikicd", this);

    public final ExDBFieldString<SV_BikinIdouMeisai, String> daibosyuucd = new ExDBFieldString<>("daibosyuucd", this);

    public final ExDBFieldString<SV_BikinIdouMeisai, C_UmuKbn> drtenbunumu = new ExDBFieldString<>("drtenbunumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, String> kyksakuinmeino = new ExDBFieldString<>("kyksakuinmeino", this);

    public final ExDBFieldString<SV_BikinIdouMeisai, C_Tdk> kkkyktdk = new ExDBFieldString<>("kkkyktdk", this, UserType_C_Tdk.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, BizDate> kykseiymd = new ExDBFieldString<>("kykseiymd", this, BizDateType.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, C_Ketkekkacd> ketkekkacd = new ExDBFieldString<>("ketkekkacd", this, UserType_C_Ketkekkacd.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, String> palketsyacd = new ExDBFieldString<>("palketsyacd", this);

    public final ExDBFieldString<SV_BikinIdouMeisai, C_UmuKbn> stdrsktkyhkumu = new ExDBFieldString<>("stdrsktkyhkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, BizDate> stdrsktkyhkymd = new ExDBFieldString<>("stdrsktkyhkymd", this, BizDateType.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, C_UmuKbn> initsbjiyensitihsytkhukaumu = new ExDBFieldString<>("initsbjiyensitihsytkhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldBizCurrency<SV_BikinIdouMeisai> initsbjiyenkasaiteihsygk = new ExDBFieldBizCurrency<>("initsbjiyenkasaiteihsygk", this);

    public final ExDBFieldString<SV_BikinIdouMeisai, C_UmuKbn> jyudkaigomeharaitkhukaumu = new ExDBFieldString<>("jyudkaigomeharaitkhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, C_UmuKbn> targettkhkumu = new ExDBFieldString<>("targettkhkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, BizDate> targettkykkykhenkoymd = new ExDBFieldString<>("targettkykkykhenkoymd", this, BizDateType.class);

    public final ExDBFieldNumber<SV_BikinIdouMeisai, Integer> targettkmokuhyouti = new ExDBFieldNumber<>("targettkmokuhyouti", this);

    public final ExDBFieldBizCurrency<SV_BikinIdouMeisai> targettkykkijyungk = new ExDBFieldBizCurrency<>("targettkykkijyungk", this);

    public final ExDBFieldString<SV_BikinIdouMeisai, C_UmuKbn> kykdrtkykhukaumu = new ExDBFieldString<>("kykdrtkykhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, BizDate> kykdrtkykhukaymd = new ExDBFieldString<>("kykdrtkykhukaymd", this, BizDateType.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, BizDate> kykdrtkykkaiyakuymd = new ExDBFieldString<>("kykdrtkykkaiyakuymd", this, BizDateType.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, C_UmuKbn> teikishrtkykhukaumu = new ExDBFieldString<>("teikishrtkykhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, BizDate> kessankijyunymd = new ExDBFieldString<>("kessankijyunymd", this, BizDateType.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, C_BkncdKbn> bkncdkbn = new ExDBFieldString<>("bkncdkbn", this, UserType_C_BkncdKbn.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, BizDate> bknkktymd = new ExDBFieldString<>("bknkktymd", this, BizDateType.class);

    public final ExDBFieldNumber<SV_BikinIdouMeisai, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<SV_BikinIdouMeisai, C_BknrigiKbn> bknrigikbn = new ExDBFieldString<>("bknrigikbn", this, UserType_C_BknrigiKbn.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<SV_BikinIdouMeisai, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<SV_BikinIdouMeisai, BizDate> calckijyunymd = new ExDBFieldString<>("calckijyunymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<SV_BikinIdouMeisai> bkngk = new ExDBFieldBizCurrency<>("bkngk", this);

    public final ExDBFieldString<SV_BikinIdouMeisai, C_BknJkuKbn> bknjkukbn = new ExDBFieldString<>("bknjkukbn", this, UserType_C_BknJkuKbn.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, BizDate> shrsyoriymd = new ExDBFieldString<>("shrsyoriymd", this, BizDateType.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, BizDate> tyakkinymd = new ExDBFieldString<>("tyakkinymd", this, BizDateType.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, C_Tuukasyu> shrtuukasyu = new ExDBFieldString<>("shrtuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, BizDate> shrkwsratekjnymd = new ExDBFieldString<>("shrkwsratekjnymd", this, BizDateType.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, BizNumber> shrkwsrate = new ExDBFieldString<>("shrkwsrate", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<SV_BikinIdouMeisai> sitihsyutkyumaeyenhknkngk = new ExDBFieldBizCurrency<>("sitihsyutkyumaeyenhknkngk", this);

    public final ExDBFieldString<SV_BikinIdouMeisai, C_SiinKbn> siinkbn = new ExDBFieldString<>("siinkbn", this, UserType_C_SiinKbn.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, BizDateYM> jkipjytym = new ExDBFieldString<>("jkipjytym", this, BizDateYMType.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, BizDate> zennoukaisiymd = new ExDBFieldString<>("zennoukaisiymd", this, BizDateType.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, String> zennoukikan = new ExDBFieldString<>("zennoukikan", this);

    public final ExDBFieldString<SV_BikinIdouMeisai, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<SV_BikinIdouMeisai, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<SV_BikinIdouMeisai, BizDate> syoruiukeymd = new ExDBFieldString<>("syoruiukeymd", this, BizDateType.class);

    public final ExDBFieldString<SV_BikinIdouMeisai, BizDate> yendthnkymd = new ExDBFieldString<>("yendthnkymd", this, BizDateType.class);
}
