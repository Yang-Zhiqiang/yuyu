package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Aplkahi;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_Saihoum;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_Aplkahi;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_KykdrknHtdjytKbn;
import yuyu.def.db.type.UserType_C_Kykjyoutai;
import yuyu.def.db.type.UserType_C_Kyksei;
import yuyu.def.db.type.UserType_C_Nstknsyu;
import yuyu.def.db.type.UserType_C_Saihoum;
import yuyu.def.db.type.UserType_C_Sdpd;
import yuyu.def.db.type.UserType_C_ShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_SntkhouKbn;
import yuyu.def.db.type.UserType_C_StknsetKbn;
import yuyu.def.db.type.UserType_C_Syoumetujiyuu;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_TtdktyuuiKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.def.db.type.UserType_C_YuukousyoumetuKbn;

/**
 * 支払契約基本テーブル（物理テーブルなし） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SiKykKihon extends AbstractExDBTable<JT_SiKykKihon> {

    public GenQJT_SiKykKihon() {
        this("JT_SiKykKihon");
    }

    public GenQJT_SiKykKihon(String pAlias) {
        super("JT_SiKykKihon", JT_SiKykKihon.class, pAlias);
    }

    public String JT_SiKykKihon() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SiKykKihon, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<JT_SiKykKihon, String> aitesyono = new ExDBFieldString<>("aitesyono", this);

    public final ExDBFieldString<JT_SiKykKihon, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<JT_SiKykKihon, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<JT_SiKykKihon, C_SntkhouKbn> sntkhoukbn = new ExDBFieldString<>("sntkhoukbn", this, UserType_C_SntkhouKbn.class);

    public final ExDBFieldString<JT_SiKykKihon, BizDate> mosymd = new ExDBFieldString<>("mosymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiKykKihon, BizDate> kktymd = new ExDBFieldString<>("kktymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiKykKihon, C_YuukousyoumetuKbn> yuukousyoumetukbn = new ExDBFieldString<>("yuukousyoumetukbn", this, UserType_C_YuukousyoumetuKbn.class);

    public final ExDBFieldString<JT_SiKykKihon, C_Kykjyoutai> kykjyoutai = new ExDBFieldString<>("kykjyoutai", this, UserType_C_Kykjyoutai.class);

    public final ExDBFieldString<JT_SiKykKihon, BizDateYM> nexthrkym = new ExDBFieldString<>("nexthrkym", this, BizDateYMType.class);

    public final ExDBFieldString<JT_SiKykKihon, BizDate> yykknmnryymd = new ExDBFieldString<>("yykknmnryymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<JT_SiKykKihon> keip = new ExDBFieldBizCurrency<>("keip", this);

    public final ExDBFieldString<JT_SiKykKihon, BizDate> sykyknyhenkouymd = new ExDBFieldString<>("sykyknyhenkouymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiKykKihon, BizDate> lasthkhenkouymd = new ExDBFieldString<>("lasthkhenkouymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiKykKihon, C_Syoumetujiyuu> syoumetujiyuu = new ExDBFieldString<>("syoumetujiyuu", this, UserType_C_Syoumetujiyuu.class);

    public final ExDBFieldString<JT_SiKykKihon, BizDate> syoumetuymd = new ExDBFieldString<>("syoumetuymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiKykKihon, BizDate> hrketykouryokuhasseiymd = new ExDBFieldString<>("hrketykouryokuhasseiymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiKykKihon, C_StknsetKbn> stknsetkbn = new ExDBFieldString<>("stknsetkbn", this, UserType_C_StknsetKbn.class);

    public final ExDBFieldString<JT_SiKykKihon, C_Aplkahi> aplkahikbn = new ExDBFieldString<>("aplkahikbn", this, UserType_C_Aplkahi.class);

    public final ExDBFieldNumber<JT_SiKykKihon, Integer> sbuktnin = new ExDBFieldNumber<>("sbuktnin", this);

    public final ExDBFieldString<JT_SiKykKihon, C_Saihoum> saihoum = new ExDBFieldString<>("saihoum", this, UserType_C_Saihoum.class);

    public final ExDBFieldString<JT_SiKykKihon, BizDate> hksknnkaisiymd = new ExDBFieldString<>("hksknnkaisiymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiKykKihon, BizDate> gnkykfksknnkaisiymd = new ExDBFieldString<>("gnkykfksknnkaisiymd", this, BizDateType.class);

    public final ExDBFieldNumber<JT_SiKykKihon, Integer> jidouupdatekahi = new ExDBFieldNumber<>("jidouupdatekahi", this);

    public final ExDBFieldBizCurrency<JT_SiKykKihon> jidouupdategop = new ExDBFieldBizCurrency<>("jidouupdategop", this);

    public final ExDBFieldString<JT_SiKykKihon, C_UmuKbn> livingneedshukaumu = new ExDBFieldString<>("livingneedshukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SiKykKihon, C_UmuKbn> nstkhkumu = new ExDBFieldString<>("nstkhkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SiKykKihon, C_Nstknsyu> nkshrtkyknksyukbn = new ExDBFieldString<>("nkshrtkyknksyukbn", this, UserType_C_Nstknsyu.class);

    public final ExDBFieldNumber<JT_SiKykKihon, Integer> nkshrtkyknksyukkn = new ExDBFieldNumber<>("nkshrtkyknksyukkn", this);

    public final ExDBFieldString<JT_SiKykKihon, String> hhkntodouhukencd = new ExDBFieldString<>("hhkntodouhukencd", this);

    public final ExDBFieldString<JT_SiKykKihon, C_UmuKbn> tratkityuiumu = new ExDBFieldString<>("tratkityuiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SiKykKihon, String> tratkityuiuny = new ExDBFieldString<>("tratkityuiuny", this);

    public final ExDBFieldString<JT_SiKykKihon, String> kyknmkn = new ExDBFieldString<>("kyknmkn", this);

    public final ExDBFieldString<JT_SiKykKihon, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<JT_SiKykKihon, C_Kyksei> kyksei = new ExDBFieldString<>("kyksei", this, UserType_C_Kyksei.class);

    public final ExDBFieldString<JT_SiKykKihon, BizDate> kykseiymd = new ExDBFieldString<>("kykseiymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiKykKihon, String> kykyno = new ExDBFieldString<>("kykyno", this);

    public final ExDBFieldString<JT_SiKykKihon, C_Tdk> kkkyktdk = new ExDBFieldString<>("kkkyktdk", this, UserType_C_Tdk.class);

    public final ExDBFieldNumber<JT_SiKykKihon, Integer> kykhnkkaisuu = new ExDBFieldNumber<>("kykhnkkaisuu", this);

    public final ExDBFieldString<JT_SiKykKihon, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<JT_SiKykKihon, String> tsinadr1kn = new ExDBFieldString<>("tsinadr1kn", this);

    public final ExDBFieldString<JT_SiKykKihon, String> tsinadr2kn = new ExDBFieldString<>("tsinadr2kn", this);

    public final ExDBFieldString<JT_SiKykKihon, String> tsinadr3kn = new ExDBFieldString<>("tsinadr3kn", this);

    public final ExDBFieldString<JT_SiKykKihon, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<JT_SiKykKihon, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<JT_SiKykKihon, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<JT_SiKykKihon, String> tsintelno = new ExDBFieldString<>("tsintelno", this);

    public final ExDBFieldString<JT_SiKykKihon, String> hhknnmkn = new ExDBFieldString<>("hhknnmkn", this);

    public final ExDBFieldString<JT_SiKykKihon, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<JT_SiKykKihon, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldString<JT_SiKykKihon, BizDate> hhknseiymd = new ExDBFieldString<>("hhknseiymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiKykKihon, String> hhknyno = new ExDBFieldString<>("hhknyno", this);

    public final ExDBFieldString<JT_SiKykKihon, String> hhknadr1kn = new ExDBFieldString<>("hhknadr1kn", this);

    public final ExDBFieldString<JT_SiKykKihon, String> hhknadr2kn = new ExDBFieldString<>("hhknadr2kn", this);

    public final ExDBFieldString<JT_SiKykKihon, String> hhknadr3kn = new ExDBFieldString<>("hhknadr3kn", this);

    public final ExDBFieldString<JT_SiKykKihon, String> hhknadr1kj = new ExDBFieldString<>("hhknadr1kj", this);

    public final ExDBFieldString<JT_SiKykKihon, String> hhknadr2kj = new ExDBFieldString<>("hhknadr2kj", this);

    public final ExDBFieldString<JT_SiKykKihon, String> hhknadr3kj = new ExDBFieldString<>("hhknadr3kj", this);

    public final ExDBFieldString<JT_SiKykKihon, String> hhkntelno = new ExDBFieldString<>("hhkntelno", this);

    public final ExDBFieldString<JT_SiKykKihon, C_UmuKbn> stdrsktkyhkumu = new ExDBFieldString<>("stdrsktkyhkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SiKykKihon, String> siteidruktnmkn = new ExDBFieldString<>("siteidruktnmkn", this);

    public final ExDBFieldString<JT_SiKykKihon, String> siteidruktnmkj = new ExDBFieldString<>("siteidruktnmkj", this);

    public final ExDBFieldString<JT_SiKykKihon, C_Tdk> siteidrukttdk = new ExDBFieldString<>("siteidrukttdk", this, UserType_C_Tdk.class);

    public final ExDBFieldString<JT_SiKykKihon, C_UmuKbn> kykdrtkykhukaumu = new ExDBFieldString<>("kykdrtkykhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SiKykKihon, C_KykdrknHtdjytKbn> kykdrknhatudoujyoutai = new ExDBFieldString<>("kykdrknhatudoujyoutai", this, UserType_C_KykdrknHtdjytKbn.class);

    public final ExDBFieldString<JT_SiKykKihon, String> kykdairinmkj = new ExDBFieldString<>("kykdairinmkj", this);

    public final ExDBFieldString<JT_SiKykKihon, String> kykdairinmkn = new ExDBFieldString<>("kykdairinmkn", this);

    public final ExDBFieldString<JT_SiKykKihon, C_KjkhukaKbn> kykdrnmkjkhukakbn = new ExDBFieldString<>("kykdrnmkjkhukakbn", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<JT_SiKykKihon, String> kykdryno = new ExDBFieldString<>("kykdryno", this);

    public final ExDBFieldString<JT_SiKykKihon, String> kykdradr1kj = new ExDBFieldString<>("kykdradr1kj", this);

    public final ExDBFieldString<JT_SiKykKihon, String> kykdradr2kj = new ExDBFieldString<>("kykdradr2kj", this);

    public final ExDBFieldString<JT_SiKykKihon, String> kykdradr3kj = new ExDBFieldString<>("kykdradr3kj", this);

    public final ExDBFieldString<JT_SiKykKihon, BizDate> kykdrseiymd = new ExDBFieldString<>("kykdrseiymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiKykKihon, String> kykdrtelno = new ExDBFieldString<>("kykdrtelno", this);

    public final ExDBFieldString<JT_SiKykKihon, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<JT_SiKykKihon, C_ShrhousiteiKbn> shrhousiteikbn = new ExDBFieldString<>("shrhousiteikbn", this, UserType_C_ShrhousiteiKbn.class);

    public final ExDBFieldString<JT_SiKykKihon, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<JT_SiKykKihon, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<JT_SiKykKihon, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<JT_SiKykKihon, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<JT_SiKykKihon, String> drtencd = new ExDBFieldString<>("drtencd", this);

    public final ExDBFieldString<JT_SiKykKihon, String> oyadrtencd = new ExDBFieldString<>("oyadrtencd", this);

    public final ExDBFieldString<JT_SiKykKihon, String> drtenkanrisosikicd = new ExDBFieldString<>("drtenkanrisosikicd", this);

    public final ExDBFieldString<JT_SiKykKihon, String> bosyuucd = new ExDBFieldString<>("bosyuucd", this);

    public final ExDBFieldBizCurrency<JT_SiKykKihon> misyuup = new ExDBFieldBizCurrency<>("misyuup", this);

    public final ExDBFieldString<JT_SiKykKihon, BizDateYM> misyuupjyuutouym = new ExDBFieldString<>("misyuupjyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<JT_SiKykKihon, Integer> misyuupjytkaisuu = new ExDBFieldNumber<>("misyuupjytkaisuu", this);

    public final ExDBFieldBizCurrency<JT_SiKykKihon> mikeikap = new ExDBFieldBizCurrency<>("mikeikap", this);

    public final ExDBFieldString<JT_SiKykKihon, BizDateYM> mikeikapjyuutouym = new ExDBFieldString<>("mikeikapjyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<JT_SiKykKihon, Integer> mikeikapjytkaisuu = new ExDBFieldNumber<>("mikeikapjytkaisuu", this);

    public final ExDBFieldBizCurrency<JT_SiKykKihon> htykeihi = new ExDBFieldBizCurrency<>("htykeihi", this);

    public final ExDBFieldBizCurrency<JT_SiKykKihon> yenhtykeihi = new ExDBFieldBizCurrency<>("yenhtykeihi", this);

    public final ExDBFieldBizCurrency<JT_SiKykKihon> shrkykhtykeihi = new ExDBFieldBizCurrency<>("shrkykhtykeihi", this);

    public final ExDBFieldBizCurrency<JT_SiKykKihon> krkgk = new ExDBFieldBizCurrency<>("krkgk", this);

    public final ExDBFieldString<JT_SiKykKihon, BizDate> lastsyosaihkymd = new ExDBFieldString<>("lastsyosaihkymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiKykKihon, BizDate> lastmeihenymd = new ExDBFieldString<>("lastmeihenymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiKykKihon, BizDate> lastsbukthenymd = new ExDBFieldString<>("lastsbukthenymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiKykKihon, C_TtdktyuuiKbn> ttdktyuuikbn1 = new ExDBFieldString<>("ttdktyuuikbn1", this, UserType_C_TtdktyuuiKbn.class);

    public final ExDBFieldString<JT_SiKykKihon, C_TtdktyuuiKbn> ttdktyuuikbn2 = new ExDBFieldString<>("ttdktyuuikbn2", this, UserType_C_TtdktyuuiKbn.class);

    public final ExDBFieldString<JT_SiKykKihon, C_TtdktyuuiKbn> ttdktyuuikbn3 = new ExDBFieldString<>("ttdktyuuikbn3", this, UserType_C_TtdktyuuiKbn.class);

    public final ExDBFieldString<JT_SiKykKihon, C_TtdktyuuiKbn> ttdktyuuikbn4 = new ExDBFieldString<>("ttdktyuuikbn4", this, UserType_C_TtdktyuuiKbn.class);

    public final ExDBFieldString<JT_SiKykKihon, C_TtdktyuuiKbn> ttdktyuuikbn5 = new ExDBFieldString<>("ttdktyuuikbn5", this, UserType_C_TtdktyuuiKbn.class);

    public final ExDBFieldString<JT_SiKykKihon, C_UmuKbn> initsbjiyensitihsytkhukaumu = new ExDBFieldString<>("initsbjiyensitihsytkhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldBizCurrency<JT_SiKykKihon> initsbjiyenkasaiteihsygk = new ExDBFieldBizCurrency<>("initsbjiyenkasaiteihsygk", this);

    public final ExDBFieldString<JT_SiKykKihon, BizDate> fstpnyknymd = new ExDBFieldString<>("fstpnyknymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiKykKihon, BizDate> zennouryosyuymd = new ExDBFieldString<>("zennouryosyuymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiKykKihon, C_Sdpd> sdpdkbn = new ExDBFieldString<>("sdpdkbn", this, UserType_C_Sdpd.class);

    public final ExDBFieldString<JT_SiKykKihon, C_TkiktbrisyuruiKbn> tikiktbrisyuruikbn = new ExDBFieldString<>("tikiktbrisyuruikbn", this, UserType_C_TkiktbrisyuruiKbn.class);

    public final ExDBFieldString<JT_SiKykKihon, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_SiKykKihon, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_SiKykKihon, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_SiKykKihon, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
