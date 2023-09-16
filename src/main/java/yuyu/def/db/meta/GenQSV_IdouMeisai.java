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
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.SV_IdouMeisai;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_HaitoukinuketorihouKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_Ketkekkacd;
import yuyu.def.db.type.UserType_C_Sdpd;
import yuyu.def.db.type.UserType_C_SeikyuuSyubetu;
import yuyu.def.db.type.UserType_C_ShrKekkaKbn;
import yuyu.def.db.type.UserType_C_SiinKbn;
import yuyu.def.db.type.UserType_C_SyoriKbn;
import yuyu.def.db.type.UserType_C_Syoumetujiyuu;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 異動明細情報ビュー のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQSV_IdouMeisai extends AbstractExDBTable<SV_IdouMeisai> {

    public GenQSV_IdouMeisai() {
        this("SV_IdouMeisai");
    }

    public GenQSV_IdouMeisai(String pAlias) {
        super("SV_IdouMeisai", SV_IdouMeisai.class, pAlias);
    }

    public String SV_IdouMeisai() {
        return getAliasExpression();
    }

    public final ExDBFieldString<SV_IdouMeisai, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<SV_IdouMeisai, C_Sdpd> sdpdkbn = new ExDBFieldString<>("sdpdkbn", this, UserType_C_Sdpd.class);

    public final ExDBFieldBizCurrency<SV_IdouMeisai> hrkp = new ExDBFieldBizCurrency<>("hrkp", this);

    public final ExDBFieldString<SV_IdouMeisai, BizDateYM> bosyuuym = new ExDBFieldString<>("bosyuuym", this, BizDateYMType.class);

    public final ExDBFieldString<SV_IdouMeisai, BizDateYM> skeikeijyouym = new ExDBFieldString<>("skeikeijyouym", this, BizDateYMType.class);

    public final ExDBFieldString<SV_IdouMeisai, String> hhknsykgycd = new ExDBFieldString<>("hhknsykgycd", this);

    public final ExDBFieldString<SV_IdouMeisai, String> drtenkanritodoufukencd = new ExDBFieldString<>("drtenkanritodoufukencd", this);

    public final ExDBFieldString<SV_IdouMeisai, String> cifcd = new ExDBFieldString<>("cifcd", this);

    public final ExDBFieldString<SV_IdouMeisai, BizDate> fstpnyknymd = new ExDBFieldString<>("fstpnyknymd", this, BizDateType.class);

    public final ExDBFieldString<SV_IdouMeisai, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<SV_IdouMeisai, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<SV_IdouMeisai, BizDate> seirituymd = new ExDBFieldString<>("seirituymd", this, BizDateType.class);

    public final ExDBFieldString<SV_IdouMeisai, C_HaitoukinuketorihouKbn> haitoukinuketorihoukbn = new ExDBFieldString<>("haitoukinuketorihoukbn", this, UserType_C_HaitoukinuketorihouKbn.class);

    public final ExDBFieldString<SV_IdouMeisai, C_TkiktbrisyuruiKbn> tikiktbrisyuruikbn = new ExDBFieldString<>("tikiktbrisyuruikbn", this, UserType_C_TkiktbrisyuruiKbn.class);

    public final ExDBFieldString<SV_IdouMeisai, C_SyutkKbn> syutkkbn = new ExDBFieldString<>("syutkkbn", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<SV_IdouMeisai, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<SV_IdouMeisai, C_Syoumetujiyuu> syoumetujiyuu = new ExDBFieldString<>("syoumetujiyuu", this, UserType_C_Syoumetujiyuu.class);

    public final ExDBFieldString<SV_IdouMeisai, BizDate> yendthnkymd = new ExDBFieldString<>("yendthnkymd", this, BizDateType.class);

    public final ExDBFieldString<SV_IdouMeisai, String> drtencd = new ExDBFieldString<>("drtencd", this);

    public final ExDBFieldString<SV_IdouMeisai, String> drtenkanrisosikicd = new ExDBFieldString<>("drtenkanrisosikicd", this);

    public final ExDBFieldString<SV_IdouMeisai, String> daibosyuucd = new ExDBFieldString<>("daibosyuucd", this);

    public final ExDBFieldString<SV_IdouMeisai, C_UmuKbn> drtenbunumu = new ExDBFieldString<>("drtenbunumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_IdouMeisai, String> kyksakuinmeino = new ExDBFieldString<>("kyksakuinmeino", this);

    public final ExDBFieldString<SV_IdouMeisai, C_Tdk> kkkyktdk = new ExDBFieldString<>("kkkyktdk", this, UserType_C_Tdk.class);

    public final ExDBFieldString<SV_IdouMeisai, BizDate> kykseiymd = new ExDBFieldString<>("kykseiymd", this, BizDateType.class);

    public final ExDBFieldString<SV_IdouMeisai, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<SV_IdouMeisai, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<SV_IdouMeisai, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<SV_IdouMeisai, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<SV_IdouMeisai, C_ShrKekkaKbn> shrkekkakbn = new ExDBFieldString<>("shrkekkakbn", this, UserType_C_ShrKekkaKbn.class);

    public final ExDBFieldString<SV_IdouMeisai, C_SyoriKbn> syorikbn = new ExDBFieldString<>("syorikbn", this, UserType_C_SyoriKbn.class);

    public final ExDBFieldBizCurrency<SV_IdouMeisai> syushrgkkei = new ExDBFieldBizCurrency<>("syushrgkkei", this);

    public final ExDBFieldString<SV_IdouMeisai, BizDate> tyakkinymd = new ExDBFieldString<>("tyakkinymd", this, BizDateType.class);

    public final ExDBFieldString<SV_IdouMeisai, BizDate> syoruiukeymd = new ExDBFieldString<>("syoruiukeymd", this, BizDateType.class);

    public final ExDBFieldString<SV_IdouMeisai, BizDate> hubikanryouymd = new ExDBFieldString<>("hubikanryouymd", this, BizDateType.class);

    public final ExDBFieldString<SV_IdouMeisai, BizDate> kouryokuhasseiymd = new ExDBFieldString<>("kouryokuhasseiymd", this, BizDateType.class);

    public final ExDBFieldString<SV_IdouMeisai, C_Tuukasyu> shrtuukasyu = new ExDBFieldString<>("shrtuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<SV_IdouMeisai, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<SV_IdouMeisai, C_SeikyuuSyubetu> seikyuusyubetu = new ExDBFieldString<>("seikyuusyubetu", this, UserType_C_SeikyuuSyubetu.class);

    public final ExDBFieldString<SV_IdouMeisai, C_Ketkekkacd> ketkekkacd = new ExDBFieldString<>("ketkekkacd", this, UserType_C_Ketkekkacd.class);

    public final ExDBFieldString<SV_IdouMeisai, String> palketsyacd = new ExDBFieldString<>("palketsyacd", this);

    public final ExDBFieldString<SV_IdouMeisai, C_UmuKbn> stdrsktkyhkumu = new ExDBFieldString<>("stdrsktkyhkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_IdouMeisai, BizDate> stdrsktkyhkymd = new ExDBFieldString<>("stdrsktkyhkymd", this, BizDateType.class);

    public final ExDBFieldString<SV_IdouMeisai, C_UmuKbn> yenshrtkhkumu = new ExDBFieldString<>("yenshrtkhkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_IdouMeisai, C_UmuKbn> initsbjiyensitihsytkhukaumu = new ExDBFieldString<>("initsbjiyensitihsytkhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldBizCurrency<SV_IdouMeisai> initsbjiyenkasaiteihsygk = new ExDBFieldBizCurrency<>("initsbjiyenkasaiteihsygk", this);

    public final ExDBFieldString<SV_IdouMeisai, C_UmuKbn> jyudkaigomeharaitkhukaumu = new ExDBFieldString<>("jyudkaigomeharaitkhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_IdouMeisai, C_UmuKbn> targettkhkumu = new ExDBFieldString<>("targettkhkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_IdouMeisai, BizDate> targettkykkykhenkoymd = new ExDBFieldString<>("targettkykkykhenkoymd", this, BizDateType.class);

    public final ExDBFieldNumber<SV_IdouMeisai, Integer> targettkmokuhyouti = new ExDBFieldNumber<>("targettkmokuhyouti", this);

    public final ExDBFieldBizCurrency<SV_IdouMeisai> targettkykkijyungk = new ExDBFieldBizCurrency<>("targettkykkijyungk", this);

    public final ExDBFieldString<SV_IdouMeisai, C_UmuKbn> kykdrtkykhukaumu = new ExDBFieldString<>("kykdrtkykhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_IdouMeisai, BizDate> kykdrtkykhukaymd = new ExDBFieldString<>("kykdrtkykhukaymd", this, BizDateType.class);

    public final ExDBFieldString<SV_IdouMeisai, BizDate> kykdrtkykkaiyakuymd = new ExDBFieldString<>("kykdrtkykkaiyakuymd", this, BizDateType.class);

    public final ExDBFieldString<SV_IdouMeisai, C_UmuKbn> teikishrtkykhukaumu = new ExDBFieldString<>("teikishrtkykhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_IdouMeisai, C_SiinKbn> siinkbn = new ExDBFieldString<>("siinkbn", this, UserType_C_SiinKbn.class);

    public final ExDBFieldBizCurrency<SV_IdouMeisai> sitihsyutkyumaeyenhknkngk = new ExDBFieldBizCurrency<>("sitihsyutkyumaeyenhknkngk", this);

    public final ExDBFieldString<SV_IdouMeisai, BizDateYM> jkipjytym = new ExDBFieldString<>("jkipjytym", this, BizDateYMType.class);

    public final ExDBFieldString<SV_IdouMeisai, BizDate> zennoukaisiymd = new ExDBFieldString<>("zennoukaisiymd", this, BizDateType.class);

    public final ExDBFieldString<SV_IdouMeisai, String> zennoukikan = new ExDBFieldString<>("zennoukikan", this);
}
