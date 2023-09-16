package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_Aplkahi;
import yuyu.def.classification.C_Boskykjyoutai;
import yuyu.def.classification.C_DirectServiceMosKbn;
import yuyu.def.classification.C_DntryourituKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_HonninkakuninSyoruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KijiKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.classification.C_NkIkouzumiKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SinsaKbn;
import yuyu.def.classification.C_SkSyoukenSksKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TrhkjiKakKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YakkanJyuryouKbn;
import yuyu.def.classification.C_YnkHrkmgkAnniTuutiKbn;
import yuyu.def.db.entity.IT_KykKihon;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYType;
import yuyu.def.db.type.UserType_C_AisyoumeiKbn;
import yuyu.def.db.type.UserType_C_Aplkahi;
import yuyu.def.db.type.UserType_C_Boskykjyoutai;
import yuyu.def.db.type.UserType_C_DirectServiceMosKbn;
import yuyu.def.db.type.UserType_C_DntryourituKbn;
import yuyu.def.db.type.UserType_C_FstphrkkeiroKbn;
import yuyu.def.db.type.UserType_C_HaitouKbn;
import yuyu.def.db.type.UserType_C_HaitoukinuketorihouKbn;
import yuyu.def.db.type.UserType_C_HonninkakuninSyoruiKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_KijiKbn;
import yuyu.def.db.type.UserType_C_MosUketukeKbn;
import yuyu.def.db.type.UserType_C_NensyuuKbn;
import yuyu.def.db.type.UserType_C_NkIkouzumiKbn;
import yuyu.def.db.type.UserType_C_Sdpd;
import yuyu.def.db.type.UserType_C_SinsaKbn;
import yuyu.def.db.type.UserType_C_SkSyoukenSksKbn;
import yuyu.def.db.type.UserType_C_SntkhouKbn;
import yuyu.def.db.type.UserType_C_StknsetKbn;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_TrhkjiKakKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YakkanJyuryouKbn;
import yuyu.def.db.type.UserType_C_YnkHrkmgkAnniTuutiKbn;

/**
 * 契約基本テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KykKihon extends AbstractExDBTable<IT_KykKihon> {

    public GenQIT_KykKihon() {
        this("IT_KykKihon");
    }

    public GenQIT_KykKihon(String pAlias) {
        super("IT_KykKihon", IT_KykKihon.class, pAlias);
    }

    public String IT_KykKihon() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KykKihon, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_KykKihon, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KykKihon, String> aitesyono = new ExDBFieldString<>("aitesyono", this);

    public final ExDBFieldString<IT_KykKihon, C_HaitouKbn> haitoukbn = new ExDBFieldString<>("haitoukbn", this, UserType_C_HaitouKbn.class);

    public final ExDBFieldString<IT_KykKihon, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_KykKihon, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<IT_KykKihon, C_Sdpd> sdpdkbn = new ExDBFieldString<>("sdpdkbn", this, UserType_C_Sdpd.class);

    public final ExDBFieldString<IT_KykKihon, C_DntryourituKbn> dntryouritukbn = new ExDBFieldString<>("dntryouritukbn", this, UserType_C_DntryourituKbn.class);

    public final ExDBFieldString<IT_KykKihon, String> dntcd = new ExDBFieldString<>("dntcd", this);

    public final ExDBFieldString<IT_KykKihon, C_SntkhouKbn> sntkhoukbn = new ExDBFieldString<>("sntkhoukbn", this, UserType_C_SntkhouKbn.class);

    public final ExDBFieldString<IT_KykKihon, C_SinsaKbn> sinsakbn = new ExDBFieldString<>("sinsakbn", this, UserType_C_SinsaKbn.class);

    public final ExDBFieldString<IT_KykKihon, BizDate> mosymd = new ExDBFieldString<>("mosymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykKihon, BizDate> kktymd = new ExDBFieldString<>("kktymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykKihon, BizDate> fstpnyknymd = new ExDBFieldString<>("fstpnyknymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykKihon, BizDate> mosukeymd = new ExDBFieldString<>("mosukeymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykKihon, BizDate> mosjimosuktymd = new ExDBFieldString<>("mosjimosuktymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykKihon, BizDate> seirituymd = new ExDBFieldString<>("seirituymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykKihon, BizDate> itiprsymd = new ExDBFieldString<>("itiprsymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_KykKihon> hrkp = new ExDBFieldBizCurrency<>("hrkp", this);

    public final ExDBFieldString<IT_KykKihon, BizDateYM> bosyuuym = new ExDBFieldString<>("bosyuuym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_KykKihon, BizDateYM> seisekiym = new ExDBFieldString<>("seisekiym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_KykKihon, BizDateYM> skeikeijyouym = new ExDBFieldString<>("skeikeijyouym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_KykKihon, String> plancd = new ExDBFieldString<>("plancd", this);

    public final ExDBFieldNumber<IT_KykKihon, Integer> planrenno = new ExDBFieldNumber<>("planrenno", this);

    public final ExDBFieldString<IT_KykKihon, C_AisyoumeiKbn> aisyoumeikbn = new ExDBFieldString<>("aisyoumeikbn", this, UserType_C_AisyoumeiKbn.class);

    public final ExDBFieldString<IT_KykKihon, C_UmuKbn> syusaiumu = new ExDBFieldString<>("syusaiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KykKihon, C_StknsetKbn> stknsetkbn = new ExDBFieldString<>("stknsetkbn", this, UserType_C_StknsetKbn.class);

    public final ExDBFieldString<IT_KykKihon, C_UmuKbn> kykksykjyumu = new ExDBFieldString<>("kykksykjyumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KykKihon, C_UmuKbn> kykksumu = new ExDBFieldString<>("kykksumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KykKihon, C_Aplkahi> aplkahikbn = new ExDBFieldString<>("aplkahikbn", this, UserType_C_Aplkahi.class);

    public final ExDBFieldString<IT_KykKihon, C_UmuKbn> aplumu = new ExDBFieldString<>("aplumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KykKihon, C_FstphrkkeiroKbn> fstphrkkeirokbn = new ExDBFieldString<>("fstphrkkeirokbn", this, UserType_C_FstphrkkeiroKbn.class);

    public final ExDBFieldString<IT_KykKihon, BizDateY> haitounendo = new ExDBFieldString<>("haitounendo", this, BizDateYType.class);

    public final ExDBFieldString<IT_KykKihon, C_HaitoukinuketorihouKbn> haitoukinuketorihoukbn = new ExDBFieldString<>("haitoukinuketorihoukbn", this, UserType_C_HaitoukinuketorihouKbn.class);

    public final ExDBFieldString<IT_KykKihon, C_UmuKbn> tratkityuiumu = new ExDBFieldString<>("tratkityuiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KykKihon, String> tratkityuiuny = new ExDBFieldString<>("tratkityuiuny", this);

    public final ExDBFieldNumber<IT_KykKihon, Integer> sbuktnin = new ExDBFieldNumber<>("sbuktnin", this);

    public final ExDBFieldString<IT_KykKihon, String> gansindankakuteiymd = new ExDBFieldString<>("gansindankakuteiymd", this);

    public final ExDBFieldString<IT_KykKihon, C_MosUketukeKbn> mosuketukekbn = new ExDBFieldString<>("mosuketukekbn", this, UserType_C_MosUketukeKbn.class);

    public final ExDBFieldString<IT_KykKihon, C_KijiKbn> kijikbn = new ExDBFieldString<>("kijikbn", this, UserType_C_KijiKbn.class);

    public final ExDBFieldString<IT_KykKihon, String> hhknsykgycd = new ExDBFieldString<>("hhknsykgycd", this);

    public final ExDBFieldString<IT_KykKihon, C_NensyuuKbn> hhknnensyuukbn = new ExDBFieldString<>("hhknnensyuukbn", this, UserType_C_NensyuuKbn.class);

    public final ExDBFieldString<IT_KykKihon, String> drtenkanritodoufukencd = new ExDBFieldString<>("drtenkanritodoufukencd", this);

    public final ExDBFieldString<IT_KykKihon, String> cifcd = new ExDBFieldString<>("cifcd", this);

    public final ExDBFieldString<IT_KykKihon, String> smbckanriid = new ExDBFieldString<>("smbckanriid", this);

    public final ExDBFieldString<IT_KykKihon, C_UmuKbn> tsryhshrkykumukbn = new ExDBFieldString<>("tsryhshrkykumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KykKihon, C_HonninkakuninSyoruiKbn> kykhonninkakninsyoruikbn = new ExDBFieldString<>("kykhonninkakninsyoruikbn", this, UserType_C_HonninkakuninSyoruiKbn.class);

    public final ExDBFieldString<IT_KykKihon, C_HonninkakuninSyoruiKbn> skskknhonninkakninsyoruikbn = new ExDBFieldString<>("skskknhonninkakninsyoruikbn", this, UserType_C_HonninkakuninSyoruiKbn.class);

    public final ExDBFieldString<IT_KykKihon, C_Boskykjyoutai> boskykjyoutai = new ExDBFieldString<>("boskykjyoutai", this, UserType_C_Boskykjyoutai.class);

    public final ExDBFieldNumber<IT_KykKihon, Long> kanyuusyano = new ExDBFieldNumber<>("kanyuusyano", this);

    public final ExDBFieldString<IT_KykKihon, C_DirectServiceMosKbn> drctservicemoskbn = new ExDBFieldString<>("drctservicemoskbn", this, UserType_C_DirectServiceMosKbn.class);

    public final ExDBFieldString<IT_KykKihon, C_SkSyoukenSksKbn> sksyoukenskskbn = new ExDBFieldString<>("sksyoukenskskbn", this, UserType_C_SkSyoukenSksKbn.class);

    public final ExDBFieldString<IT_KykKihon, BizDate> sinkyksyokensakuseiymd = new ExDBFieldString<>("sinkyksyokensakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykKihon, BizDate> syoyousinkyksyohakkouymd = new ExDBFieldString<>("syoyousinkyksyohakkouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykKihon, String> skjmosno = new ExDBFieldString<>("skjmosno", this);

    public final ExDBFieldString<IT_KykKihon, C_NkIkouzumiKbn> nkuikosumikbn = new ExDBFieldString<>("nkuikosumikbn", this, UserType_C_NkIkouzumiKbn.class);

    public final ExDBFieldString<IT_KykKihon, BizDate> syhenkouymd = new ExDBFieldString<>("syhenkouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykKihon, BizDate> lastsyosaihkymd = new ExDBFieldString<>("lastsyosaihkymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykKihon, BizDate> lastmeihenymd = new ExDBFieldString<>("lastmeihenymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykKihon, BizDate> lastkykmeighnkymd = new ExDBFieldString<>("lastkykmeighnkymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykKihon, BizDate> lastsbukthenymd = new ExDBFieldString<>("lastsbukthenymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykKihon, BizDate> lastkyknmseiymdhenkouymd = new ExDBFieldString<>("lastkyknmseiymdhenkouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykKihon, BizDate> lastkyknmkanakjteiymd = new ExDBFieldString<>("lastkyknmkanakjteiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykKihon, BizDate> lasttsinynohenkouymd = new ExDBFieldString<>("lasttsinynohenkouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykKihon, BizDate> lastjyuuhenymd = new ExDBFieldString<>("lastjyuuhenymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykKihon, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KykKihon, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KykKihon, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IT_KykKihon, C_TrhkjiKakKbn> seiritujitrhkjikakkbn = new ExDBFieldString<>("seiritujitrhkjikakkbn", this, UserType_C_TrhkjiKakKbn.class);

    public final ExDBFieldString<IT_KykKihon, C_TkiktbrisyuruiKbn> tikiktbrisyuruikbn = new ExDBFieldString<>("tikiktbrisyuruikbn", this, UserType_C_TkiktbrisyuruiKbn.class);

    public final ExDBFieldString<IT_KykKihon, C_YakkanJyuryouKbn> yakkanjyuryouhoukbn = new ExDBFieldString<>("yakkanjyuryouhoukbn", this, UserType_C_YakkanJyuryouKbn.class);

    public final ExDBFieldString<IT_KykKihon, String> yakkanbunsyono = new ExDBFieldString<>("yakkanbunsyono", this);

    public final ExDBFieldString<IT_KykKihon, String> siorino = new ExDBFieldString<>("siorino", this);

    public final ExDBFieldString<IT_KykKihon, C_YnkHrkmgkAnniTuutiKbn> ynkhrkmgkannituutikbn = new ExDBFieldString<>("ynkhrkmgkannituutikbn", this, UserType_C_YnkHrkmgkAnniTuutiKbn.class);
}
