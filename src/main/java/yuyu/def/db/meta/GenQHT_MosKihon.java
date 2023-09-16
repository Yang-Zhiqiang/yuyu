package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_1pclriyouKbn;
import yuyu.def.classification.C_AeoisnsiKbn;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_Aplkahi;
import yuyu.def.classification.C_BikkjnssinfoKbn;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_Boskykjyoutai;
import yuyu.def.classification.C_DirectServiceMosKbn;
import yuyu.def.classification.C_DntryourituKbn;
import yuyu.def.classification.C_DsSyomenTtdkHyouji;
import yuyu.def.classification.C_FatcasnsiKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HjndaiykKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_HonninkakuninSyoruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KoureiKzkSetumeiHouKbn;
import yuyu.def.classification.C_KoureiMndnHukusuukaiKbn;
import yuyu.def.classification.C_KoureiTratkisyaIgiDskKbn;
import yuyu.def.classification.C_KoureisyaTaiouKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Kykymdtkrumu;
import yuyu.def.classification.C_KzktourokuserviceTourokuKbn;
import yuyu.def.classification.C_Livhukaumu;
import yuyu.def.classification.C_MobilebosyuuKbn;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.classification.C_NkgnsHosyourituKbn;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_PWaribikitekiyouKbn;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_PmnjtkhukaKbn;
import yuyu.def.classification.C_PplessrendoucreditkousouKbn;
import yuyu.def.classification.C_PplessrendoukouhurikousouKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_SknnkaisikitkKbn;
import yuyu.def.classification.C_SknnkaisikitkhukaKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_Tkkinyukkntkrumu;
import yuyu.def.classification.C_TrhkjiKakKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_TumitatekinHaibunWariKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YakkanJyuryouKbn;
import yuyu.def.classification.C_YnkHrkmgkAnniTuutiKbn;
import yuyu.def.classification.C_Znnhrkkai;
import yuyu.def.classification.C_Znnhrkkeiro;
import yuyu.def.db.entity.HT_MosKihon;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_1pclriyouKbn;
import yuyu.def.db.type.UserType_C_AeoisnsiKbn;
import yuyu.def.db.type.UserType_C_AisyoumeiKbn;
import yuyu.def.db.type.UserType_C_Aplkahi;
import yuyu.def.db.type.UserType_C_BikkjnssinfoKbn;
import yuyu.def.db.type.UserType_C_BlnktkumuKbn;
import yuyu.def.db.type.UserType_C_Boskykjyoutai;
import yuyu.def.db.type.UserType_C_DirectServiceMosKbn;
import yuyu.def.db.type.UserType_C_DntryourituKbn;
import yuyu.def.db.type.UserType_C_DsSyomenTtdkHyouji;
import yuyu.def.db.type.UserType_C_FatcasnsiKbn;
import yuyu.def.db.type.UserType_C_FstphrkkeiroKbn;
import yuyu.def.db.type.UserType_C_HaitouKbn;
import yuyu.def.db.type.UserType_C_HaitoukinuketorihouKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_HjndaiykKbn;
import yuyu.def.db.type.UserType_C_HknsyuruiNo;
import yuyu.def.db.type.UserType_C_HonninkakuninSyoruiKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_IkkatubaraiKaisuuKbn;
import yuyu.def.db.type.UserType_C_IkkatubaraiKbn;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_KoureiKzkSetumeiHouKbn;
import yuyu.def.db.type.UserType_C_KoureiMndnHukusuukaiKbn;
import yuyu.def.db.type.UserType_C_KoureiTratkisyaIgiDskKbn;
import yuyu.def.db.type.UserType_C_KoureisyaTaiouKbn;
import yuyu.def.db.type.UserType_C_KykKbn;
import yuyu.def.db.type.UserType_C_Kyksei;
import yuyu.def.db.type.UserType_C_Kykymdtkrumu;
import yuyu.def.db.type.UserType_C_KzktourokuserviceTourokuKbn;
import yuyu.def.db.type.UserType_C_Livhukaumu;
import yuyu.def.db.type.UserType_C_MobilebosyuuKbn;
import yuyu.def.db.type.UserType_C_NensyuuKbn;
import yuyu.def.db.type.UserType_C_NkgnsHosyourituKbn;
import yuyu.def.db.type.UserType_C_Nstknsyu;
import yuyu.def.db.type.UserType_C_PWaribikitekiyouKbn;
import yuyu.def.db.type.UserType_C_PmnjtkKbn;
import yuyu.def.db.type.UserType_C_PmnjtkhukaKbn;
import yuyu.def.db.type.UserType_C_PplessrendoucreditkousouKbn;
import yuyu.def.db.type.UserType_C_PplessrendoukouhurikousouKbn;
import yuyu.def.db.type.UserType_C_Sdpd;
import yuyu.def.db.type.UserType_C_Sisuukbn;
import yuyu.def.db.type.UserType_C_SknnkaisikitkKbn;
import yuyu.def.db.type.UserType_C_SknnkaisikitkhukaKbn;
import yuyu.def.db.type.UserType_C_SntkhouKbn;
import yuyu.def.db.type.UserType_C_StknsetKbn;
import yuyu.def.db.type.UserType_C_TargetTkKbn;
import yuyu.def.db.type.UserType_C_TargetTkMokuhyoutiKbn;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_Tkhukaumu;
import yuyu.def.db.type.UserType_C_Tkkinyukkntkrumu;
import yuyu.def.db.type.UserType_C_TrhkjiKakKbn;
import yuyu.def.db.type.UserType_C_TsindousiteiKbn;
import yuyu.def.db.type.UserType_C_TumitatekinHaibunWariKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YakkanJyuryouKbn;
import yuyu.def.db.type.UserType_C_YnkHrkmgkAnniTuutiKbn;
import yuyu.def.db.type.UserType_C_Znnhrkkai;
import yuyu.def.db.type.UserType_C_Znnhrkkeiro;

/**
 * 申込基本テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_MosKihon extends AbstractExDBTable<HT_MosKihon> {

    public GenQHT_MosKihon() {
        this("HT_MosKihon");
    }

    public GenQHT_MosKihon(String pAlias) {
        super("HT_MosKihon", HT_MosKihon.class, pAlias);
    }

    public String HT_MosKihon() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_MosKihon, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_MosKihon, String> aitemosno = new ExDBFieldString<>("aitemosno", this);

    public final ExDBFieldString<HT_MosKihon, String> doujikaiyakusyono = new ExDBFieldString<>("doujikaiyakusyono", this);

    public final ExDBFieldString<HT_MosKihon, String> sekno = new ExDBFieldString<>("sekno", this);

    public final ExDBFieldString<HT_MosKihon, BizDate> pykkigenymd = new ExDBFieldString<>("pykkigenymd", this, BizDateType.class);

    public final ExDBFieldString<HT_MosKihon, BizDate> mosymd = new ExDBFieldString<>("mosymd", this, BizDateType.class);

    public final ExDBFieldString<HT_MosKihon, BizDate> mossakuseiymd = new ExDBFieldString<>("mossakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_MosKihon, BizDate> moscalckijyunymd = new ExDBFieldString<>("moscalckijyunymd", this, BizDateType.class);

    public final ExDBFieldString<HT_MosKihon, BizDate> mosukeymd = new ExDBFieldString<>("mosukeymd", this, BizDateType.class);

    public final ExDBFieldString<HT_MosKihon, BizDate> mosjimosuktymd = new ExDBFieldString<>("mosjimosuktymd", this, BizDateType.class);

    public final ExDBFieldString<HT_MosKihon, BizDate> pplessmosukeymd = new ExDBFieldString<>("pplessmosukeymd", this, BizDateType.class);

    public final ExDBFieldString<HT_MosKihon, BizDateYM> mosym = new ExDBFieldString<>("mosym", this, BizDateYMType.class);

    public final ExDBFieldString<HT_MosKihon, BizDate> ssyukeymd = new ExDBFieldString<>("ssyukeymd", this, BizDateType.class);

    public final ExDBFieldString<HT_MosKihon, BizDate> kktymd = new ExDBFieldString<>("kktymd", this, BizDateType.class);

    public final ExDBFieldString<HT_MosKihon, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<HT_MosKihon, C_Kykymdtkrumu> kykymdtkrumu = new ExDBFieldString<>("kykymdtkrumu", this, UserType_C_Kykymdtkrumu.class);

    public final ExDBFieldString<HT_MosKihon, BizDate> skykymd = new ExDBFieldString<>("skykymd", this, BizDateType.class);

    public final ExDBFieldString<HT_MosKihon, BizDate> sknnkaisiymd = new ExDBFieldString<>("sknnkaisiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_MosKihon, BizDateYM> bosyuuym = new ExDBFieldString<>("bosyuuym", this, BizDateYMType.class);

    public final ExDBFieldString<HT_MosKihon, BizDateYM> seisekiym = new ExDBFieldString<>("seisekiym", this, BizDateYMType.class);

    public final ExDBFieldString<HT_MosKihon, BizDateYM> skeikeijyouym = new ExDBFieldString<>("skeikeijyouym", this, BizDateYMType.class);

    public final ExDBFieldString<HT_MosKihon, C_KykKbn> kykkbn = new ExDBFieldString<>("kykkbn", this, UserType_C_KykKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_HknsyuruiNo> hknsyuruino = new ExDBFieldString<>("hknsyuruino", this, UserType_C_HknsyuruiNo.class);

    public final ExDBFieldNumber<HT_MosKihon, Integer> hknsyuruinosd = new ExDBFieldNumber<>("hknsyuruinosd", this);

    public final ExDBFieldString<HT_MosKihon, C_AisyoumeiKbn> aisyoumeikbn = new ExDBFieldString<>("aisyoumeikbn", this, UserType_C_AisyoumeiKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_NkgnsHosyourituKbn> nkgnshosyouritukbn = new ExDBFieldString<>("nkgnshosyouritukbn", this, UserType_C_NkgnsHosyourituKbn.class);

    public final ExDBFieldBizCurrency<HT_MosKihon> nkgnshosyougk = new ExDBFieldBizCurrency<>("nkgnshosyougk", this);

    public final ExDBFieldString<HT_MosKihon, C_Livhukaumu> livhukaumu = new ExDBFieldString<>("livhukaumu", this, UserType_C_Livhukaumu.class);

    public final ExDBFieldString<HT_MosKihon, C_PmnjtkhukaKbn> pmnjtkhukakbn = new ExDBFieldString<>("pmnjtkhukakbn", this, UserType_C_PmnjtkhukaKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_PmnjtkKbn> pmnjtkkbn = new ExDBFieldString<>("pmnjtkkbn", this, UserType_C_PmnjtkKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_SknnkaisikitkhukaKbn> sknnkaisikitkhukakbn = new ExDBFieldString<>("sknnkaisikitkhukakbn", this, UserType_C_SknnkaisikitkhukaKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_SknnkaisikitkKbn> sknnkaisikitkkbn = new ExDBFieldString<>("sknnkaisikitkkbn", this, UserType_C_SknnkaisikitkKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_KzktourokuserviceTourokuKbn> kzktourokuservicetourokukbn = new ExDBFieldString<>("kzktourokuservicetourokukbn", this, UserType_C_KzktourokuserviceTourokuKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_Tkhukaumu> kykdrtkykhukakbn = new ExDBFieldString<>("kykdrtkykhukakbn", this, UserType_C_Tkhukaumu.class);

    public final ExDBFieldString<HT_MosKihon, C_Tkhukaumu> stdrsktkyhkkbn = new ExDBFieldString<>("stdrsktkyhkkbn", this, UserType_C_Tkhukaumu.class);

    public final ExDBFieldString<HT_MosKihon, C_Sdpd> sdpdkbn = new ExDBFieldString<>("sdpdkbn", this, UserType_C_Sdpd.class);

    public final ExDBFieldString<HT_MosKihon, C_SntkhouKbn> sntkhoukbn = new ExDBFieldString<>("sntkhoukbn", this, UserType_C_SntkhouKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_HaitouKbn> haitoukbn = new ExDBFieldString<>("haitoukbn", this, UserType_C_HaitouKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_HaitoukinuketorihouKbn> haitoukinuketorihoukbn = new ExDBFieldString<>("haitoukinuketorihoukbn", this, UserType_C_HaitoukinuketorihouKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<HT_MosKihon, C_Tuukasyu> hrktuukasyu = new ExDBFieldString<>("hrktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<HT_MosKihon, C_Tkhukaumu> yennykntkhkkbn = new ExDBFieldString<>("yennykntkhkkbn", this, UserType_C_Tkhukaumu.class);

    public final ExDBFieldString<HT_MosKihon, C_Tkhukaumu> gaikanykntkhkkbn = new ExDBFieldString<>("gaikanykntkhkkbn", this, UserType_C_Tkhukaumu.class);

    public final ExDBFieldString<HT_MosKihon, C_Tkhukaumu> yenshrtkhkkbn = new ExDBFieldString<>("yenshrtkhkkbn", this, UserType_C_Tkhukaumu.class);

    public final ExDBFieldBizCurrency<HT_MosKihon> mosheijyunp = new ExDBFieldBizCurrency<>("mosheijyunp", this);

    public final ExDBFieldBizCurrency<HT_MosKihon> heijyunp = new ExDBFieldBizCurrency<>("heijyunp", this);

    public final ExDBFieldBizCurrency<HT_MosKihon> heijyunpryoumasinasi = new ExDBFieldBizCurrency<>("heijyunpryoumasinasi", this);

    public final ExDBFieldBizCurrency<HT_MosKihon> hrktuukaheijyunp = new ExDBFieldBizCurrency<>("hrktuukaheijyunp", this);

    public final ExDBFieldString<HT_MosKihon, C_IkkatubaraiKbn> ikkatubaraikbn = new ExDBFieldString<>("ikkatubaraikbn", this, UserType_C_IkkatubaraiKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_IkkatubaraiKaisuuKbn> ikkatubaraikaisuu = new ExDBFieldString<>("ikkatubaraikaisuu", this, UserType_C_IkkatubaraiKaisuuKbn.class);

    public final ExDBFieldBizCurrency<HT_MosKihon> mosikkatup = new ExDBFieldBizCurrency<>("mosikkatup", this);

    public final ExDBFieldBizCurrency<HT_MosKihon> ikkatup = new ExDBFieldBizCurrency<>("ikkatup", this);

    public final ExDBFieldString<HT_MosKihon, C_UmuKbn> zennoumousideumu = new ExDBFieldString<>("zennoumousideumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_BlnktkumuKbn> zenkizennouumu = new ExDBFieldString<>("zenkizennouumu", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldNumber<HT_MosKihon, Integer> znnkai = new ExDBFieldNumber<>("znnkai", this);

    public final ExDBFieldBizCurrency<HT_MosKihon> moszennoupsyokaiari = new ExDBFieldBizCurrency<>("moszennoupsyokaiari", this);

    public final ExDBFieldBizCurrency<HT_MosKihon> zennoup = new ExDBFieldBizCurrency<>("zennoup", this);

    public final ExDBFieldBizCurrency<HT_MosKihon> zennoujyuutoup = new ExDBFieldBizCurrency<>("zennoujyuutoup", this);

    public final ExDBFieldString<HT_MosKihon, C_Znnhrkkai> znnhrkkai = new ExDBFieldString<>("znnhrkkai", this, UserType_C_Znnhrkkai.class);

    public final ExDBFieldString<HT_MosKihon, C_Znnhrkkeiro> znnhrkkeiro = new ExDBFieldString<>("znnhrkkeiro", this, UserType_C_Znnhrkkeiro.class);

    public final ExDBFieldBizCurrency<HT_MosKihon> mosfstpkei = new ExDBFieldBizCurrency<>("mosfstpkei", this);

    public final ExDBFieldBizCurrency<HT_MosKihon> hyouteip = new ExDBFieldBizCurrency<>("hyouteip", this);

    public final ExDBFieldBizCurrency<HT_MosKihon> seitoufstpkei = new ExDBFieldBizCurrency<>("seitoufstpkei", this);

    public final ExDBFieldBizCurrency<HT_MosKihon> fstphrkgk = new ExDBFieldBizCurrency<>("fstphrkgk", this);

    public final ExDBFieldBizCurrency<HT_MosKihon> hrktuukafstphrkgk = new ExDBFieldBizCurrency<>("hrktuukafstphrkgk", this);

    public final ExDBFieldBizCurrency<HT_MosKihon> pharaikomisougaku = new ExDBFieldBizCurrency<>("pharaikomisougaku", this);

    public final ExDBFieldBizCurrency<HT_MosKihon> sibouskei = new ExDBFieldBizCurrency<>("sibouskei", this);

    public final ExDBFieldString<HT_MosKihon, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<HT_MosKihon, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<HT_MosKihon, C_FstphrkkeiroKbn> fstphrkkeirokbn = new ExDBFieldString<>("fstphrkkeirokbn", this, UserType_C_FstphrkkeiroKbn.class);

    public final ExDBFieldNumber<HT_MosKihon, Integer> skjpjyuutoukaisuu = new ExDBFieldNumber<>("skjpjyuutoukaisuu", this);

    public final ExDBFieldString<HT_MosKihon, C_UmuKbn> ikkatuyoupumukbn = new ExDBFieldString<>("ikkatuyoupumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldNumber<HT_MosKihon, Integer> ikkatuyoupkaisuu = new ExDBFieldNumber<>("ikkatuyoupkaisuu", this);

    public final ExDBFieldString<HT_MosKihon, C_PWaribikitekiyouKbn> pwaribikitekiyoukbn = new ExDBFieldString<>("pwaribikitekiyoukbn", this, UserType_C_PWaribikitekiyouKbn.class);

    public final ExDBFieldBizCurrency<HT_MosKihon> ikkatuyoupgkkeizokup = new ExDBFieldBizCurrency<>("ikkatuyoupgkkeizokup", this);

    public final ExDBFieldString<HT_MosKihon, BizDate> keizokuptkykwsratekjymd = new ExDBFieldString<>("keizokuptkykwsratekjymd", this, BizDateType.class);

    public final ExDBFieldString<HT_MosKihon, BizNumber> keizokuptkykwsrate = new ExDBFieldString<>("keizokuptkykwsrate", this, BizNumberType.class);

    public final ExDBFieldString<HT_MosKihon, C_DntryourituKbn> dntryouritukbn = new ExDBFieldString<>("dntryouritukbn", this, UserType_C_DntryourituKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_Aplkahi> aplkahikbn = new ExDBFieldString<>("aplkahikbn", this, UserType_C_Aplkahi.class);

    public final ExDBFieldString<HT_MosKihon, C_1pclriyouKbn> itipclriyoukbn = new ExDBFieldString<>("itipclriyoukbn", this, UserType_C_1pclriyouKbn.class);

    public final ExDBFieldString<HT_MosKihon, BizDate> itiprsymd = new ExDBFieldString<>("itiprsymd", this, BizDateType.class);

    public final ExDBFieldString<HT_MosKihon, String> dntcd = new ExDBFieldString<>("dntcd", this);

    public final ExDBFieldString<HT_MosKihon, BizDate> massiseiymd = new ExDBFieldString<>("massiseiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_MosKihon, String> hhknnmkn = new ExDBFieldString<>("hhknnmkn", this);

    public final ExDBFieldString<HT_MosKihon, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<HT_MosKihon, C_KjkhukaKbn> hhknnmkjkhukakbn = new ExDBFieldString<>("hhknnmkjkhukakbn", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<HT_MosKihon, BizDate> hhknseiymd = new ExDBFieldString<>("hhknseiymd", this, BizDateType.class);

    public final ExDBFieldNumber<HT_MosKihon, Integer> hhknnen = new ExDBFieldNumber<>("hhknnen", this);

    public final ExDBFieldString<HT_MosKihon, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldString<HT_MosKihon, String> hhknsykgycd = new ExDBFieldString<>("hhknsykgycd", this);

    public final ExDBFieldString<HT_MosKihon, C_NensyuuKbn> hhknnensyuukbn = new ExDBFieldString<>("hhknnensyuukbn", this, UserType_C_NensyuuKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_TsindousiteiKbn> tsindousiteikbn = new ExDBFieldString<>("tsindousiteikbn", this, UserType_C_TsindousiteiKbn.class);

    public final ExDBFieldString<HT_MosKihon, String> hhknyno = new ExDBFieldString<>("hhknyno", this);

    public final ExDBFieldString<HT_MosKihon, String> hhknadr1kn = new ExDBFieldString<>("hhknadr1kn", this);

    public final ExDBFieldString<HT_MosKihon, String> hhknadr2kn = new ExDBFieldString<>("hhknadr2kn", this);

    public final ExDBFieldString<HT_MosKihon, String> hhknadr3kn = new ExDBFieldString<>("hhknadr3kn", this);

    public final ExDBFieldString<HT_MosKihon, String> hhknadr1kj = new ExDBFieldString<>("hhknadr1kj", this);

    public final ExDBFieldString<HT_MosKihon, String> hhknadr2kj = new ExDBFieldString<>("hhknadr2kj", this);

    public final ExDBFieldString<HT_MosKihon, String> hhknadr3kj = new ExDBFieldString<>("hhknadr3kj", this);

    public final ExDBFieldString<HT_MosKihon, String> hhkntelno = new ExDBFieldString<>("hhkntelno", this);

    public final ExDBFieldString<HT_MosKihon, String> hhknkinmusakinm = new ExDBFieldString<>("hhknkinmusakinm", this);

    public final ExDBFieldString<HT_MosKihon, String> kyknmkn = new ExDBFieldString<>("kyknmkn", this);

    public final ExDBFieldString<HT_MosKihon, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<HT_MosKihon, C_KjkhukaKbn> kyknmkjkhukakbn = new ExDBFieldString<>("kyknmkjkhukakbn", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<HT_MosKihon, BizDate> kykseiymd = new ExDBFieldString<>("kykseiymd", this, BizDateType.class);

    public final ExDBFieldNumber<HT_MosKihon, Integer> kyknen = new ExDBFieldNumber<>("kyknen", this);

    public final ExDBFieldString<HT_MosKihon, C_Kyksei> kyksei = new ExDBFieldString<>("kyksei", this, UserType_C_Kyksei.class);

    public final ExDBFieldString<HT_MosKihon, C_Tdk> kyktdk = new ExDBFieldString<>("kyktdk", this, UserType_C_Tdk.class);

    public final ExDBFieldString<HT_MosKihon, C_NensyuuKbn> kyknensyuukbn = new ExDBFieldString<>("kyknensyuukbn", this, UserType_C_NensyuuKbn.class);

    public final ExDBFieldString<HT_MosKihon, String> kykkinmusakinm = new ExDBFieldString<>("kykkinmusakinm", this);

    public final ExDBFieldString<HT_MosKihon, C_HjndaiykKbn> hjndaiykkbn = new ExDBFieldString<>("hjndaiykkbn", this, UserType_C_HjndaiykKbn.class);

    public final ExDBFieldString<HT_MosKihon, String> hjndainmkn = new ExDBFieldString<>("hjndainmkn", this);

    public final ExDBFieldString<HT_MosKihon, String> hjndainmkj = new ExDBFieldString<>("hjndainmkj", this);

    public final ExDBFieldString<HT_MosKihon, C_YakkanJyuryouKbn> yakkanjyuryouhoukbn = new ExDBFieldString<>("yakkanjyuryouhoukbn", this, UserType_C_YakkanJyuryouKbn.class);

    public final ExDBFieldString<HT_MosKihon, String> yakkanbunsyono = new ExDBFieldString<>("yakkanbunsyono", this);

    public final ExDBFieldString<HT_MosKihon, String> siorino = new ExDBFieldString<>("siorino", this);

    public final ExDBFieldString<HT_MosKihon, C_FatcasnsiKbn> fatcasnsikbn = new ExDBFieldString<>("fatcasnsikbn", this, UserType_C_FatcasnsiKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_BikkjnssinfoKbn> bikkjnssinfokbn = new ExDBFieldString<>("bikkjnssinfokbn", this, UserType_C_BikkjnssinfoKbn.class);

    public final ExDBFieldString<HT_MosKihon, String> bikknzsyno = new ExDBFieldString<>("bikknzsyno", this);

    public final ExDBFieldString<HT_MosKihon, BizDate> syomeiymd = new ExDBFieldString<>("syomeiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_MosKihon, C_AeoisnsiKbn> aeoisnsikbn = new ExDBFieldString<>("aeoisnsikbn", this, UserType_C_AeoisnsiKbn.class);

    public final ExDBFieldString<HT_MosKihon, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<HT_MosKihon, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<HT_MosKihon, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<HT_MosKihon, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<HT_MosKihon, String> tsinadr1kn = new ExDBFieldString<>("tsinadr1kn", this);

    public final ExDBFieldString<HT_MosKihon, String> tsinadr2kn = new ExDBFieldString<>("tsinadr2kn", this);

    public final ExDBFieldString<HT_MosKihon, String> tsinadr3kn = new ExDBFieldString<>("tsinadr3kn", this);

    public final ExDBFieldString<HT_MosKihon, String> tsintelno = new ExDBFieldString<>("tsintelno", this);

    public final ExDBFieldString<HT_MosKihon, String> dai2tsintelno = new ExDBFieldString<>("dai2tsintelno", this);

    public final ExDBFieldString<HT_MosKihon, String> syoshadr1kj = new ExDBFieldString<>("syoshadr1kj", this);

    public final ExDBFieldString<HT_MosKihon, String> syoshadr2kj = new ExDBFieldString<>("syoshadr2kj", this);

    public final ExDBFieldString<HT_MosKihon, String> syoshadr3kj = new ExDBFieldString<>("syoshadr3kj", this);

    public final ExDBFieldString<HT_MosKihon, String> syoshtelno = new ExDBFieldString<>("syoshtelno", this);

    public final ExDBFieldString<HT_MosKihon, String> syoshyno = new ExDBFieldString<>("syoshyno", this);

    public final ExDBFieldString<HT_MosKihon, C_Tkhukaumu> targettkhkkbn = new ExDBFieldString<>("targettkhkkbn", this, UserType_C_Tkhukaumu.class);

    public final ExDBFieldString<HT_MosKihon, C_TargetTkKbn> targettkkbn = new ExDBFieldString<>("targettkkbn", this, UserType_C_TargetTkKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_TargetTkMokuhyoutiKbn> targettkmkhtkbn = new ExDBFieldString<>("targettkmkhtkbn", this, UserType_C_TargetTkMokuhyoutiKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_Tkhukaumu> nstkhkkbn = new ExDBFieldString<>("nstkhkkbn", this, UserType_C_Tkhukaumu.class);

    public final ExDBFieldNumber<HT_MosKihon, Integer> nstkmnknsyu = new ExDBFieldNumber<>("nstkmnknsyu", this);

    public final ExDBFieldNumber<HT_MosKihon, Integer> nstkmnknkkn = new ExDBFieldNumber<>("nstkmnknkkn", this);

    public final ExDBFieldString<HT_MosKihon, C_Nstknsyu> nstksbnsyu = new ExDBFieldString<>("nstksbnsyu", this, UserType_C_Nstknsyu.class);

    public final ExDBFieldNumber<HT_MosKihon, Integer> nstksbnkkn = new ExDBFieldNumber<>("nstksbnkkn", this);

    public final ExDBFieldString<HT_MosKihon, C_Tkhukaumu> syksbyensitihsyutkhkkbn = new ExDBFieldString<>("syksbyensitihsyutkhkkbn", this, UserType_C_Tkhukaumu.class);

    public final ExDBFieldString<HT_MosKihon, C_Tkhukaumu> jyudkaigomehrtkhkkbn = new ExDBFieldString<>("jyudkaigomehrtkhkkbn", this, UserType_C_Tkhukaumu.class);

    public final ExDBFieldString<HT_MosKihon, C_Tkhukaumu> kjnnkpzeitekitkhukakbn = new ExDBFieldString<>("kjnnkpzeitekitkhukakbn", this, UserType_C_Tkhukaumu.class);

    public final ExDBFieldString<HT_MosKihon, C_Tkhukaumu> teikisiharaitkykhkkbn = new ExDBFieldString<>("teikisiharaitkykhkkbn", this, UserType_C_Tkhukaumu.class);

    public final ExDBFieldString<HT_MosKihon, String> saihocd = new ExDBFieldString<>("saihocd", this);

    public final ExDBFieldString<HT_MosKihon, C_StknsetKbn> stknsetkbn = new ExDBFieldString<>("stknsetkbn", this, UserType_C_StknsetKbn.class);

    public final ExDBFieldNumber<HT_MosKihon, Integer> sbuktnin = new ExDBFieldNumber<>("sbuktnin", this);

    public final ExDBFieldString<HT_MosKihon, C_HonninkakuninSyoruiKbn> kykhonninkakninsyoruikbn = new ExDBFieldString<>("kykhonninkakninsyoruikbn", this, UserType_C_HonninkakuninSyoruiKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_HonninkakuninSyoruiKbn> skskknhonninkakninsyoruikbn = new ExDBFieldString<>("skskknhonninkakninsyoruikbn", this, UserType_C_HonninkakuninSyoruiKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_KoureiKzkSetumeiHouKbn> koureikzksetumeihoukbn = new ExDBFieldString<>("koureikzksetumeihoukbn", this, UserType_C_KoureiKzkSetumeiHouKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_KoureiMndnHukusuukaiKbn> koureimndnhukusuukaikbn = new ExDBFieldString<>("koureimndnhukusuukaikbn", this, UserType_C_KoureiMndnHukusuukaiKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_KoureiTratkisyaIgiDskKbn> koureitratkisyaigidskkbn = new ExDBFieldString<>("koureitratkisyaigidskkbn", this, UserType_C_KoureiTratkisyaIgiDskKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_UmuKbn> daihituumukbn = new ExDBFieldString<>("daihituumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_UmuKbn> syotnshuyoupostumukbn = new ExDBFieldString<>("syotnshuyoupostumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_MosKihon, String> uktkid = new ExDBFieldString<>("uktkid", this);

    public final ExDBFieldString<HT_MosKihon, C_Boskykjyoutai> boskykjyoutai = new ExDBFieldString<>("boskykjyoutai", this, UserType_C_Boskykjyoutai.class);

    public final ExDBFieldString<HT_MosKihon, C_Tkkinyukkntkrumu> tkkinyukkntkrumu = new ExDBFieldString<>("tkkinyukkntkrumu", this, UserType_C_Tkkinyukkntkrumu.class);

    public final ExDBFieldString<HT_MosKihon, C_DirectServiceMosKbn> drctservicemoskbn = new ExDBFieldString<>("drctservicemoskbn", this, UserType_C_DirectServiceMosKbn.class);

    public final ExDBFieldString<HT_MosKihon, String> dskokno = new ExDBFieldString<>("dskokno", this);

    public final ExDBFieldString<HT_MosKihon, String> dsmailaddress = new ExDBFieldString<>("dsmailaddress", this);

    public final ExDBFieldString<HT_MosKihon, C_YnkHrkmgkAnniTuutiKbn> ynkhrkmgkannituutikbn = new ExDBFieldString<>("ynkhrkmgkannituutikbn", this, UserType_C_YnkHrkmgkAnniTuutiKbn.class);

    public final ExDBFieldString<HT_MosKihon, String> tokuteitrhkansyono = new ExDBFieldString<>("tokuteitrhkansyono", this);

    public final ExDBFieldString<HT_MosKihon, C_DsSyomenTtdkHyouji> pplessrenjidssymenttdkhyj = new ExDBFieldString<>("pplessrenjidssymenttdkhyj", this, UserType_C_DsSyomenTtdkHyouji.class);

    public final ExDBFieldString<HT_MosKihon, C_PplessrendoukouhurikousouKbn> pplsrendoukouhurikousoukbn = new ExDBFieldString<>("pplsrendoukouhurikousoukbn", this, UserType_C_PplessrendoukouhurikousouKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_PplessrendoucreditkousouKbn> pplessrendoucreditkousoukbn = new ExDBFieldString<>("pplessrendoucreditkousoukbn", this, UserType_C_PplessrendoucreditkousouKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_UmuKbn> hnsstjmmouumukbn = new ExDBFieldString<>("hnsstjmmouumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_UmuKbn> kjmeigihkhunouumukbn = new ExDBFieldString<>("kjmeigihkhunouumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_UmuKbn> tsryhshrkykumukbn = new ExDBFieldString<>("tsryhshrkykumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_UmuKbn> syosisyatodokeumukbn = new ExDBFieldString<>("syosisyatodokeumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_UmuKbn> kakukisyouryakukbumukbn = new ExDBFieldString<>("kakukisyouryakukbumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_UmuKbn> seiymdmosseitouumukbn = new ExDBFieldString<>("seiymdmosseitouumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_UmuKbn> ikokakninsyotokkijkumu = new ExDBFieldString<>("ikokakninsyotokkijkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_UmuKbn> trtkhoukokusyotokkijkumu = new ExDBFieldString<>("trtkhoukokusyotokkijkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_UmuKbn> hnnkakninhskjikouumukbn = new ExDBFieldString<>("hnnkakninhskjikouumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_UmuKbn> hnnkakninhsktkjikouumukbn = new ExDBFieldString<>("hnnkakninhsktkjikouumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_UmuKbn> skskakninhsktkjikouumukbn = new ExDBFieldString<>("skskakninhsktkjikouumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_BlnktkumuKbn> kouseiinkyktkjkumukbn = new ExDBFieldString<>("kouseiinkyktkjkumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<HT_MosKihon, String> koukankykkinmusakinm = new ExDBFieldString<>("koukankykkinmusakinm", this);

    public final ExDBFieldString<HT_MosKihon, String> koukankyksyokumunaiyou = new ExDBFieldString<>("koukankyksyokumunaiyou", this);

    public final ExDBFieldString<HT_MosKihon, C_BlnktkumuKbn> koukankyktkjkumukbn = new ExDBFieldString<>("koukankyktkjkumukbn", this, UserType_C_BlnktkumuKbn.class);

    public final ExDBFieldString<HT_MosKihon, String> khnchkcmnt = new ExDBFieldString<>("khnchkcmnt", this);

    public final ExDBFieldString<HT_MosKihon, C_MobilebosyuuKbn> mobilebosyuukbn = new ExDBFieldString<>("mobilebosyuukbn", this, UserType_C_MobilebosyuuKbn.class);

    public final ExDBFieldString<HT_MosKihon, String> jimuyoucd = new ExDBFieldString<>("jimuyoucd", this);

    public final ExDBFieldString<HT_MosKihon, C_TumitatekinHaibunWariKbn> teirituhaibunwarikbn = new ExDBFieldString<>("teirituhaibunwarikbn", this, UserType_C_TumitatekinHaibunWariKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_Sisuukbn> sisuukbn = new ExDBFieldString<>("sisuukbn", this, UserType_C_Sisuukbn.class);

    public final ExDBFieldString<HT_MosKihon, C_TumitatekinHaibunWariKbn> sisuuhaibunwarikbn = new ExDBFieldString<>("sisuuhaibunwarikbn", this, UserType_C_TumitatekinHaibunWariKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_TrhkjiKakKbn> trhkjikakkbn = new ExDBFieldString<>("trhkjikakkbn", this, UserType_C_TrhkjiKakKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_KoureisyaTaiouKbn> koureitaioukbn = new ExDBFieldString<>("koureitaioukbn", this, UserType_C_KoureisyaTaiouKbn.class);

    public final ExDBFieldString<HT_MosKihon, C_Tuukasyu> kyktuukasyu2 = new ExDBFieldString<>("kyktuukasyu2", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<HT_MosKihon, C_Tuukasyu> hrktuukasyu2 = new ExDBFieldString<>("hrktuukasyu2", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<HT_MosKihon> mosheijyunp2 = new ExDBFieldBizCurrency<>("mosheijyunp2", this);

    public final ExDBFieldBizCurrency<HT_MosKihon> mosikkatup2 = new ExDBFieldBizCurrency<>("mosikkatup2", this);

    public final ExDBFieldBizCurrency<HT_MosKihon> moszennoupsyokaiari2 = new ExDBFieldBizCurrency<>("moszennoupsyokaiari2", this);

    public final ExDBFieldString<HT_MosKihon, C_Tkhukaumu> kjnnkpzeitekitkhukakbn2 = new ExDBFieldString<>("kjnnkpzeitekitkhukakbn2", this, UserType_C_Tkhukaumu.class);

    public final ExDBFieldString<HT_MosKihon, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_MosKihon, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
