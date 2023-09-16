package yuyu.def.db.mapping;

import com.google.common.base.Optional;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.Pattern;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
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
import yuyu.def.db.entity.HT_MosKihonVrf;
import yuyu.def.db.id.PKHT_MosKihonVrf;
import yuyu.def.db.meta.GenQHT_MosKihonVrf;
import yuyu.def.db.meta.QHT_MosKihonVrf;
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
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 申込基本ベリファイテーブル テーブルのマッピング情報クラスで、 {@link HT_MosKihonVrf} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_MosKihonVrf}</td><td colspan="3">申込基本ベリファイテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_MosKihonVrf ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAitemosno aitemosno}</td><td>相手申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDoujikaiyakusyono doujikaiyakusyono}</td><td>同時解約証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSekno sekno}</td><td>設計書番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPykkigenymd pykkigenymd}</td><td>保険料有効期限年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMosymd mosymd}</td><td>申込日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMossakuseiymd mossakuseiymd}</td><td>申込書作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMoscalckijyunymd moscalckijyunymd}</td><td>申込書計算基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMosukeymd mosukeymd}</td><td>申込書受付日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMosjimosuktymd mosjimosuktymd}</td><td>申込時申込書受付日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getPplessmosukeymd pplessmosukeymd}</td><td>ペーパーレス申込書受付日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMosym mosym}</td><td>申込月度</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getSsyukeymd ssyukeymd}</td><td>支社受付日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKktymd kktymd}</td><td>告知日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykymdtkrumu kykymdtkrumu}</td><td>契約日特例有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kykymdtkrumu}</td></tr>
 *  <tr><td>{@link #getSkykymd skykymd}</td><td>指定契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSknnkaisiymd sknnkaisiymd}</td><td>責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBosyuuym bosyuuym}</td><td>募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getSeisekiym seisekiym}</td><td>成績計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getSkeikeijyouym skeikeijyouym}</td><td>新契約計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getKykkbn kykkbn}</td><td>契約者区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KykKbn}</td></tr>
 *  <tr><td>{@link #getHknsyuruino hknsyuruino}</td><td>保険種類番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HknsyuruiNo}</td></tr>
 *  <tr><td>{@link #getHknsyuruinosd hknsyuruinosd}</td><td>保険種類番号世代</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getAisyoumeikbn aisyoumeikbn}</td><td>愛称名区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AisyoumeiKbn}</td></tr>
 *  <tr><td>{@link #getNkgnshosyouritukbn nkgnshosyouritukbn}</td><td>年金原資最低保証率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NkgnsHosyourituKbn}</td></tr>
 *  <tr><td>{@link #getNkgnshosyougk nkgnshosyougk}</td><td>年金原資最低保証額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getLivhukaumu livhukaumu}</td><td>リビングニーズ付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Livhukaumu}</td></tr>
 *  <tr><td>{@link #getPmnjtkhukakbn pmnjtkhukakbn}</td><td>保険料免除特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_PmnjtkhukaKbn}</td></tr>
 *  <tr><td>{@link #getPmnjtkkbn pmnjtkkbn}</td><td>保険料免除特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_PmnjtkKbn}</td></tr>
 *  <tr><td>{@link #getSknnkaisikitkhukakbn sknnkaisikitkhukakbn}</td><td>責任開始期特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SknnkaisikitkhukaKbn}</td></tr>
 *  <tr><td>{@link #getSknnkaisikitkkbn sknnkaisikitkkbn}</td><td>責任開始期特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SknnkaisikitkKbn}</td></tr>
 *  <tr><td>{@link #getKzktourokuservicetourokukbn kzktourokuservicetourokukbn}</td><td>ご家族登録サービス登録区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KzktourokuserviceTourokuKbn}</td></tr>
 *  <tr><td>{@link #getKykdrtkykhukakbn kykdrtkykhukakbn}</td><td>契約者代理特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkhukaumu}</td></tr>
 *  <tr><td>{@link #getStdrsktkyhkkbn stdrsktkyhkkbn}</td><td>被保険者代理特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkhukaumu}</td></tr>
 *  <tr><td>{@link #getSdpdkbn sdpdkbn}</td><td>Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Sdpd}</td></tr>
 *  <tr><td>{@link #getSntkhoukbn sntkhoukbn}</td><td>選択方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SntkhouKbn}</td></tr>
 *  <tr><td>{@link #getHaitoukbn haitoukbn}</td><td>配当区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HaitouKbn}</td></tr>
 *  <tr><td>{@link #getHaitoukinuketorihoukbn haitoukinuketorihoukbn}</td><td>配当金受取方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HaitoukinuketorihouKbn}</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getHrktuukasyu hrktuukasyu}</td><td>払込通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getYennykntkhkkbn yennykntkhkkbn}</td><td>円入金特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkhukaumu}</td></tr>
 *  <tr><td>{@link #getGaikanykntkhkkbn gaikanykntkhkkbn}</td><td>外貨入金特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkhukaumu}</td></tr>
 *  <tr><td>{@link #getYenshrtkhkkbn yenshrtkhkkbn}</td><td>円支払特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkhukaumu}</td></tr>
 *  <tr><td>{@link #getMosheijyunp mosheijyunp}</td><td>申込平準払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHeijyunp heijyunp}</td><td>平準払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHeijyunpryoumasinasi heijyunpryoumasinasi}</td><td>平準払Ｐ（料増除）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHrktuukaheijyunp hrktuukaheijyunp}</td><td>払込通貨平準払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getIkkatubaraikbn ikkatubaraikbn}</td><td>一括払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_IkkatubaraiKbn}</td></tr>
 *  <tr><td>{@link #getIkkatubaraikaisuu ikkatubaraikaisuu}</td><td>一括払回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_IkkatubaraiKaisuuKbn}</td></tr>
 *  <tr><td>{@link #getMosikkatup mosikkatup}</td><td>申込一括払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getIkkatup ikkatup}</td><td>一括払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZennoumousideumu zennoumousideumu}</td><td>前納申出有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getZenkizennouumu zenkizennouumu}</td><td>全期前納有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getZnnkai znnkai}</td><td>前納回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getMoszennoupsyokaiari moszennoupsyokaiari}</td><td>申込前納Ｐ（初回含）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZennoup zennoup}</td><td>前納Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZennoujyuutoup zennoujyuutoup}</td><td>前納年払充当Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZnnhrkkai znnhrkkai}</td><td>前納後払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Znnhrkkai}</td></tr>
 *  <tr><td>{@link #getZnnhrkkeiro znnhrkkeiro}</td><td>前納後払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Znnhrkkeiro}</td></tr>
 *  <tr><td>{@link #getMosfstpkei mosfstpkei}</td><td>申込初回Ｐ合計金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHyouteip hyouteip}</td><td>表定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSeitoufstpkei seitoufstpkei}</td><td>正当初回Ｐ合計金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getFstphrkgk fstphrkgk}</td><td>初回Ｐ払込必要額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHrktuukafstphrkgk hrktuukafstphrkgk}</td><td>払込通貨初回Ｐ払込必要額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getPharaikomisougaku pharaikomisougaku}</td><td>保険料払込総額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSibouskei sibouskei}</td><td>死亡Ｓ合計金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getHrkkeiro hrkkeiro}</td><td>払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getFstphrkkeirokbn fstphrkkeirokbn}</td><td>初回保険料払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_FstphrkkeiroKbn}</td></tr>
 *  <tr><td>{@link #getSkjpjyuutoukaisuu skjpjyuutoukaisuu}</td><td>新契約時保険料充当回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getIkkatuyoupumukbn ikkatuyoupumukbn}</td><td>一括要Ｐ有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getIkkatuyoupkaisuu ikkatuyoupkaisuu}</td><td>一括要Ｐ回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getPwaribikitekiyoukbn pwaribikitekiyoukbn}</td><td>保険料割引適用区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_PWaribikitekiyouKbn}</td></tr>
 *  <tr><td>{@link #getIkkatuyoupgkkeizokup ikkatuyoupgkkeizokup}</td><td>一括要Ｐ必要額（継続Ｐ）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKeizokuptkykwsratekjymd keizokuptkykwsratekjymd}</td><td>継続Ｐ適用為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKeizokuptkykwsrate keizokuptkykwsrate}</td><td>継続Ｐ適用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDntryouritukbn dntryouritukbn}</td><td>団体料率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DntryourituKbn}</td></tr>
 *  <tr><td>{@link #getAplkahikbn aplkahikbn}</td><td>ＡＰＬ可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Aplkahi}</td></tr>
 *  <tr><td>{@link #getItipclriyoukbn itipclriyoukbn}</td><td>１ＰＣＬ利用区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_1pclriyouKbn}</td></tr>
 *  <tr><td>{@link #getItiprsymd itiprsymd}</td><td>１Ｐ領収予定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDntcd dntcd}</td><td>団体コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMassiseiymd massiseiymd}</td><td>末子生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHhknnmkn hhknnmkn}</td><td>被保険者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkj hhknnmkj}</td><td>被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkjkhukakbn hhknnmkjkhukakbn}</td><td>被保険者名漢字化不可区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KjkhukaKbn}</td></tr>
 *  <tr><td>{@link #getHhknseiymd hhknseiymd}</td><td>被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHhknnen hhknnen}</td><td>被保険者年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHhknsei hhknsei}</td><td>被保険者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hhknsei}</td></tr>
 *  <tr><td>{@link #getHhknsykgycd hhknsykgycd}</td><td>被保険者職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnensyuukbn hhknnensyuukbn}</td><td>被保険者年収区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NensyuuKbn}</td></tr>
 *  <tr><td>{@link #getTsindousiteikbn tsindousiteikbn}</td><td>通信先同一指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TsindousiteiKbn}</td></tr>
 *  <tr><td>{@link #getHhknyno hhknyno}</td><td>被保険者郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknadr1kn hhknadr1kn}</td><td>被保険者住所１（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknadr2kn hhknadr2kn}</td><td>被保険者住所２（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknadr3kn hhknadr3kn}</td><td>被保険者住所３（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknadr1kj hhknadr1kj}</td><td>被保険者住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknadr2kj hhknadr2kj}</td><td>被保険者住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknadr3kj hhknadr3kj}</td><td>被保険者住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhkntelno hhkntelno}</td><td>被保険者電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknkinmusakinm hhknkinmusakinm}</td><td>被保険者勤務先名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkn kyknmkn}</td><td>契約者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkjkhukakbn kyknmkjkhukakbn}</td><td>契約者名漢字化不可区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KjkhukaKbn}</td></tr>
 *  <tr><td>{@link #getKykseiymd kykseiymd}</td><td>契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyknen kyknen}</td><td>契約者年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyksei kyksei}</td><td>契約者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kyksei}</td></tr>
 *  <tr><td>{@link #getKyktdk kyktdk}</td><td>契約者続柄</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tdk}</td></tr>
 *  <tr><td>{@link #getKyknensyuukbn kyknensyuukbn}</td><td>契約者年収区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NensyuuKbn}</td></tr>
 *  <tr><td>{@link #getKykkinmusakinm kykkinmusakinm}</td><td>契約者勤務先名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHjndaiykkbn hjndaiykkbn}</td><td>法人代表者役職区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HjndaiykKbn}</td></tr>
 *  <tr><td>{@link #getHjndainmkn hjndainmkn}</td><td>法人代表者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHjndainmkj hjndainmkj}</td><td>法人代表者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYakkanjyuryouhoukbn yakkanjyuryouhoukbn}</td><td>約款受領方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YakkanJyuryouKbn}</td></tr>
 *  <tr><td>{@link #getYakkanbunsyono yakkanbunsyono}</td><td>約款文書番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiorino siorino}</td><td>しおり番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFatcasnsikbn fatcasnsikbn}</td><td>ＦＡＴＣＡ宣誓区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_FatcasnsiKbn}</td></tr>
 *  <tr><td>{@link #getBikkjnssinfokbn bikkjnssinfokbn}</td><td>米国人示唆情報区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BikkjnssinfoKbn}</td></tr>
 *  <tr><td>{@link #getBikknzsyno bikknzsyno}</td><td>米国納税者番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyomeiymd syomeiymd}</td><td>署名日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getAeoisnsikbn aeoisnsikbn}</td><td>ＡＥＯＩ宣誓区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AeoisnsiKbn}</td></tr>
 *  <tr><td>{@link #getTsinyno tsinyno}</td><td>通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr1kj tsinadr1kj}</td><td>通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr2kj tsinadr2kj}</td><td>通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr3kj tsinadr3kj}</td><td>通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr1kn tsinadr1kn}</td><td>通信先住所１（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr2kn tsinadr2kn}</td><td>通信先住所２（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr3kn tsinadr3kn}</td><td>通信先住所３（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsintelno tsintelno}</td><td>通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai2tsintelno dai2tsintelno}</td><td>第２通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoshadr1kj syoshadr1kj}</td><td>証券送付先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoshadr2kj syoshadr2kj}</td><td>証券送付先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoshadr3kj syoshadr3kj}</td><td>証券送付先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoshtelno syoshtelno}</td><td>証券送付先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoshyno syoshyno}</td><td>証券送付先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTargettkhkkbn targettkhkkbn}</td><td>ターゲット特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkhukaumu}</td></tr>
 *  <tr><td>{@link #getTargettkkbn targettkkbn}</td><td>ターゲット特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TargetTkKbn}</td></tr>
 *  <tr><td>{@link #getTargettkmkhtkbn targettkmkhtkbn}</td><td>ターゲット特約目標値区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TargetTkMokuhyoutiKbn}</td></tr>
 *  <tr><td>{@link #getNstkhkkbn nstkhkkbn}</td><td>年金支払特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkhukaumu}</td></tr>
 *  <tr><td>{@link #getNstkmnknsyu nstkmnknsyu}</td><td>年金支払特約満期年金種類</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNstkmnknkkn nstkmnknkkn}</td><td>年金支払特約満期年金期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNstksbnsyu nstksbnsyu}</td><td>年金支払特約死亡年金種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Nstknsyu}</td></tr>
 *  <tr><td>{@link #getNstksbnkkn nstksbnkkn}</td><td>年金支払特約死亡年金期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyksbyensitihsyutkhkkbn syksbyensitihsyutkhkkbn}</td><td>初期死亡時円換算最低保証特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkhukaumu}</td></tr>
 *  <tr><td>{@link #getJyudkaigomehrtkhkkbn jyudkaigomehrtkhkkbn}</td><td>重度介護前払特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkhukaumu}</td></tr>
 *  <tr><td>{@link #getKjnnkpzeitekitkhukakbn kjnnkpzeitekitkhukakbn}</td><td>個人年金保険料税制適格特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkhukaumu}</td></tr>
 *  <tr><td>{@link #getTeikisiharaitkykhkkbn teikisiharaitkykhkkbn}</td><td>定期支払特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkhukaumu}</td></tr>
 *  <tr><td>{@link #getSaihocd saihocd}</td><td>再保険会社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStknsetkbn stknsetkbn}</td><td>質権設定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_StknsetKbn}</td></tr>
 *  <tr><td>{@link #getSbuktnin sbuktnin}</td><td>死亡受取人人数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKykhonninkakninsyoruikbn kykhonninkakninsyoruikbn}</td><td>契約者本人確認書類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HonninkakuninSyoruiKbn}</td></tr>
 *  <tr><td>{@link #getSkskknhonninkakninsyoruikbn skskknhonninkakninsyoruikbn}</td><td>親権者後見人本人確認書類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HonninkakuninSyoruiKbn}</td></tr>
 *  <tr><td>{@link #getKoureikzksetumeihoukbn koureikzksetumeihoukbn}</td><td>高齢者ご家族等説明方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KoureiKzkSetumeiHouKbn}</td></tr>
 *  <tr><td>{@link #getKoureimndnhukusuukaikbn koureimndnhukusuukaikbn}</td><td>高齢者面談複数回実施区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KoureiMndnHukusuukaiKbn}</td></tr>
 *  <tr><td>{@link #getKoureitratkisyaigidskkbn koureitratkisyaigidskkbn}</td><td>高齢者取扱者以外同席区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KoureiTratkisyaIgiDskKbn}</td></tr>
 *  <tr><td>{@link #getDaihituumukbn daihituumukbn}</td><td>代筆有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSyotnshuyoupostumukbn syotnshuyoupostumukbn}</td><td>証券転送不要郵便有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getUktkid uktkid}</td><td>受付管理ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBoskykjyoutai boskykjyoutai}</td><td>募集契約状態</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Boskykjyoutai}</td></tr>
 *  <tr><td>{@link #getTkkinyukkntkrumu tkkinyukkntkrumu}</td><td>地域金融機関特例有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkkinyukkntkrumu}</td></tr>
 *  <tr><td>{@link #getDrctservicemoskbn drctservicemoskbn}</td><td>ダイレクトサービス申込区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DirectServiceMosKbn}</td></tr>
 *  <tr><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDsmailaddress dsmailaddress}</td><td>ＤＳメールアドレス</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYnkhrkmgkannituutikbn ynkhrkmgkannituutikbn}</td><td>円貨払込額案内通知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YnkHrkmgkAnniTuutiKbn}</td></tr>
 *  <tr><td>{@link #getTokuteitrhkansyono tokuteitrhkansyono}</td><td>特定取引用暗証番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPplessrenjidssymenttdkhyj pplessrenjidssymenttdkhyj}</td><td>ペーパーレス連動時ＤＳ書面手続表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DsSyomenTtdkHyouji}</td></tr>
 *  <tr><td>{@link #getPplsrendoukouhurikousoukbn pplsrendoukouhurikousoukbn}</td><td>ペーパーレス連動時口振申込書後送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_PplessrendoukouhurikousouKbn}</td></tr>
 *  <tr><td>{@link #getPplessrendoucreditkousoukbn pplessrendoucreditkousoukbn}</td><td>ペーパーレス連動時クレカ申込書後送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_PplessrendoucreditkousouKbn}</td></tr>
 *  <tr><td>{@link #getHnsstjmmouumukbn hnsstjmmouumukbn}</td><td>本社集中事務申込有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKjmeigihkhunouumukbn kjmeigihkhunouumukbn}</td><td>漢字名義変換不能有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTsryhshrkykumukbn tsryhshrkykumukbn}</td><td>手数料不支払契約有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSyosisyatodokeumukbn syosisyatodokeumukbn}</td><td>証券支社届有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKakukisyouryakukbumukbn kakukisyouryakukbumukbn}</td><td>カク基省略希望有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSeiymdmosseitouumukbn seiymdmosseitouumukbn}</td><td>生年月日申込書正当有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getIkokakninsyotokkijkumu ikokakninsyotokkijkumu}</td><td>意向確認書特記事項有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTrtkhoukokusyotokkijkumu trtkhoukokusyotokkijkumu}</td><td>取扱報告書特記事項有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHnnkakninhskjikouumukbn hnnkakninhskjikouumukbn}</td><td>本人確認補足事項有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHnnkakninhsktkjikouumukbn hnnkakninhsktkjikouumukbn}</td><td>本人確認補足特定事項有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSkskakninhsktkjikouumukbn skskakninhsktkjikouumukbn}</td><td>親権者確認補足特定事項有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKouseiinkyktkjkumukbn kouseiinkyktkjkumukbn}</td><td>構成員契約特記事項有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getKoukankykkinmusakinm koukankykkinmusakinm}</td><td>交換契約勤務先名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKoukankyksyokumunaiyou koukankyksyokumunaiyou}</td><td>交換契約職務内容</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKoukankyktkjkumukbn koukankyktkjkumukbn}</td><td>交換契約特記事項有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getKhnchkcmnt khnchkcmnt}</td><td>基本チェックコメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMobilebosyuukbn mobilebosyuukbn}</td><td>モバイル募集区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MobilebosyuuKbn}</td></tr>
 *  <tr><td>{@link #getJimuyoucd jimuyoucd}</td><td>事務用コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTeirituhaibunwarikbn teirituhaibunwarikbn}</td><td>定率部分配分割合区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TumitatekinHaibunWariKbn}</td></tr>
 *  <tr><td>{@link #getSisuukbn sisuukbn}</td><td>指数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Sisuukbn}</td></tr>
 *  <tr><td>{@link #getSisuuhaibunwarikbn sisuuhaibunwarikbn}</td><td>指数部分配分割合区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TumitatekinHaibunWariKbn}</td></tr>
 *  <tr><td>{@link #getTrhkjikakkbn trhkjikakkbn}</td><td>取引時確認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TrhkjiKakKbn}</td></tr>
 *  <tr><td>{@link #getKoureitaioukbn koureitaioukbn}</td><td>高齢者対応区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KoureisyaTaiouKbn}</td></tr>
 *  <tr><td>{@link #getKyktuukasyu2 kyktuukasyu2}</td><td>契約通貨種類＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getHrktuukasyu2 hrktuukasyu2}</td><td>払込通貨種類＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getMosheijyunp2 mosheijyunp2}</td><td>申込平準払Ｐ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMosikkatup2 mosikkatup2}</td><td>申込一括払Ｐ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMoszennoupsyokaiari2 moszennoupsyokaiari2}</td><td>申込前納Ｐ（初回含）＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKjnnkpzeitekitkhukakbn2 kjnnkpzeitekitkhukakbn2}</td><td>個人年金保険料税制適格特約付加区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkhukaumu}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_MosKihonVrf
 * @see     PKHT_MosKihonVrf
 * @see     QHT_MosKihonVrf
 * @see     GenQHT_MosKihonVrf
 */
@MappedSuperclass
@Table(name=GenHT_MosKihonVrf.TABLE_NAME)
@IdClass(value=PKHT_MosKihonVrf.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_1pclriyouKbn", typeClass=UserType_C_1pclriyouKbn.class),
    @TypeDef(name="UserType_C_AeoisnsiKbn", typeClass=UserType_C_AeoisnsiKbn.class),
    @TypeDef(name="UserType_C_AisyoumeiKbn", typeClass=UserType_C_AisyoumeiKbn.class),
    @TypeDef(name="UserType_C_Aplkahi", typeClass=UserType_C_Aplkahi.class),
    @TypeDef(name="UserType_C_BikkjnssinfoKbn", typeClass=UserType_C_BikkjnssinfoKbn.class),
    @TypeDef(name="UserType_C_BlnktkumuKbn", typeClass=UserType_C_BlnktkumuKbn.class),
    @TypeDef(name="UserType_C_Boskykjyoutai", typeClass=UserType_C_Boskykjyoutai.class),
    @TypeDef(name="UserType_C_DirectServiceMosKbn", typeClass=UserType_C_DirectServiceMosKbn.class),
    @TypeDef(name="UserType_C_DntryourituKbn", typeClass=UserType_C_DntryourituKbn.class),
    @TypeDef(name="UserType_C_DsSyomenTtdkHyouji", typeClass=UserType_C_DsSyomenTtdkHyouji.class),
    @TypeDef(name="UserType_C_FatcasnsiKbn", typeClass=UserType_C_FatcasnsiKbn.class),
    @TypeDef(name="UserType_C_FstphrkkeiroKbn", typeClass=UserType_C_FstphrkkeiroKbn.class),
    @TypeDef(name="UserType_C_HaitouKbn", typeClass=UserType_C_HaitouKbn.class),
    @TypeDef(name="UserType_C_HaitoukinuketorihouKbn", typeClass=UserType_C_HaitoukinuketorihouKbn.class),
    @TypeDef(name="UserType_C_Hhknsei", typeClass=UserType_C_Hhknsei.class),
    @TypeDef(name="UserType_C_HjndaiykKbn", typeClass=UserType_C_HjndaiykKbn.class),
    @TypeDef(name="UserType_C_HknsyuruiNo", typeClass=UserType_C_HknsyuruiNo.class),
    @TypeDef(name="UserType_C_HonninkakuninSyoruiKbn", typeClass=UserType_C_HonninkakuninSyoruiKbn.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_IkkatubaraiKaisuuKbn", typeClass=UserType_C_IkkatubaraiKaisuuKbn.class),
    @TypeDef(name="UserType_C_IkkatubaraiKbn", typeClass=UserType_C_IkkatubaraiKbn.class),
    @TypeDef(name="UserType_C_KjkhukaKbn", typeClass=UserType_C_KjkhukaKbn.class),
    @TypeDef(name="UserType_C_KoureiKzkSetumeiHouKbn", typeClass=UserType_C_KoureiKzkSetumeiHouKbn.class),
    @TypeDef(name="UserType_C_KoureiMndnHukusuukaiKbn", typeClass=UserType_C_KoureiMndnHukusuukaiKbn.class),
    @TypeDef(name="UserType_C_KoureiTratkisyaIgiDskKbn", typeClass=UserType_C_KoureiTratkisyaIgiDskKbn.class),
    @TypeDef(name="UserType_C_KoureisyaTaiouKbn", typeClass=UserType_C_KoureisyaTaiouKbn.class),
    @TypeDef(name="UserType_C_KykKbn", typeClass=UserType_C_KykKbn.class),
    @TypeDef(name="UserType_C_Kyksei", typeClass=UserType_C_Kyksei.class),
    @TypeDef(name="UserType_C_Kykymdtkrumu", typeClass=UserType_C_Kykymdtkrumu.class),
    @TypeDef(name="UserType_C_KzktourokuserviceTourokuKbn", typeClass=UserType_C_KzktourokuserviceTourokuKbn.class),
    @TypeDef(name="UserType_C_Livhukaumu", typeClass=UserType_C_Livhukaumu.class),
    @TypeDef(name="UserType_C_MobilebosyuuKbn", typeClass=UserType_C_MobilebosyuuKbn.class),
    @TypeDef(name="UserType_C_NensyuuKbn", typeClass=UserType_C_NensyuuKbn.class),
    @TypeDef(name="UserType_C_NkgnsHosyourituKbn", typeClass=UserType_C_NkgnsHosyourituKbn.class),
    @TypeDef(name="UserType_C_Nstknsyu", typeClass=UserType_C_Nstknsyu.class),
    @TypeDef(name="UserType_C_PWaribikitekiyouKbn", typeClass=UserType_C_PWaribikitekiyouKbn.class),
    @TypeDef(name="UserType_C_PmnjtkKbn", typeClass=UserType_C_PmnjtkKbn.class),
    @TypeDef(name="UserType_C_PmnjtkhukaKbn", typeClass=UserType_C_PmnjtkhukaKbn.class),
    @TypeDef(name="UserType_C_PplessrendoucreditkousouKbn", typeClass=UserType_C_PplessrendoucreditkousouKbn.class),
    @TypeDef(name="UserType_C_PplessrendoukouhurikousouKbn", typeClass=UserType_C_PplessrendoukouhurikousouKbn.class),
    @TypeDef(name="UserType_C_Sdpd", typeClass=UserType_C_Sdpd.class),
    @TypeDef(name="UserType_C_Sisuukbn", typeClass=UserType_C_Sisuukbn.class),
    @TypeDef(name="UserType_C_SknnkaisikitkKbn", typeClass=UserType_C_SknnkaisikitkKbn.class),
    @TypeDef(name="UserType_C_SknnkaisikitkhukaKbn", typeClass=UserType_C_SknnkaisikitkhukaKbn.class),
    @TypeDef(name="UserType_C_SntkhouKbn", typeClass=UserType_C_SntkhouKbn.class),
    @TypeDef(name="UserType_C_StknsetKbn", typeClass=UserType_C_StknsetKbn.class),
    @TypeDef(name="UserType_C_TargetTkKbn", typeClass=UserType_C_TargetTkKbn.class),
    @TypeDef(name="UserType_C_TargetTkMokuhyoutiKbn", typeClass=UserType_C_TargetTkMokuhyoutiKbn.class),
    @TypeDef(name="UserType_C_Tdk", typeClass=UserType_C_Tdk.class),
    @TypeDef(name="UserType_C_Tkhukaumu", typeClass=UserType_C_Tkhukaumu.class),
    @TypeDef(name="UserType_C_Tkkinyukkntkrumu", typeClass=UserType_C_Tkkinyukkntkrumu.class),
    @TypeDef(name="UserType_C_TrhkjiKakKbn", typeClass=UserType_C_TrhkjiKakKbn.class),
    @TypeDef(name="UserType_C_TsindousiteiKbn", typeClass=UserType_C_TsindousiteiKbn.class),
    @TypeDef(name="UserType_C_TumitatekinHaibunWariKbn", typeClass=UserType_C_TumitatekinHaibunWariKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YakkanJyuryouKbn", typeClass=UserType_C_YakkanJyuryouKbn.class),
    @TypeDef(name="UserType_C_YnkHrkmgkAnniTuutiKbn", typeClass=UserType_C_YnkHrkmgkAnniTuutiKbn.class),
    @TypeDef(name="UserType_C_Znnhrkkai", typeClass=UserType_C_Znnhrkkai.class),
    @TypeDef(name="UserType_C_Znnhrkkeiro", typeClass=UserType_C_Znnhrkkeiro.class)
})
public abstract class GenHT_MosKihonVrf extends AbstractExDBEntity<HT_MosKihonVrf, PKHT_MosKihonVrf> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_MosKihonVrf";
    public static final String MOSNO                    = "mosno";
    public static final String AITEMOSNO                = "aitemosno";
    public static final String DOUJIKAIYAKUSYONO        = "doujikaiyakusyono";
    public static final String SEKNO                    = "sekno";
    public static final String PYKKIGENYMD              = "pykkigenymd";
    public static final String MOSYMD                   = "mosymd";
    public static final String MOSSAKUSEIYMD            = "mossakuseiymd";
    public static final String MOSCALCKIJYUNYMD         = "moscalckijyunymd";
    public static final String MOSUKEYMD                = "mosukeymd";
    public static final String MOSJIMOSUKTYMD           = "mosjimosuktymd";
    public static final String PPLESSMOSUKEYMD          = "pplessmosukeymd";
    public static final String MOSYM                    = "mosym";
    public static final String SSYUKEYMD                = "ssyukeymd";
    public static final String KKTYMD                   = "kktymd";
    public static final String KYKYMD                   = "kykymd";
    public static final String KYKYMDTKRUMU             = "kykymdtkrumu";
    public static final String SKYKYMD                  = "skykymd";
    public static final String SKNNKAISIYMD             = "sknnkaisiymd";
    public static final String BOSYUUYM                 = "bosyuuym";
    public static final String SEISEKIYM                = "seisekiym";
    public static final String SKEIKEIJYOUYM            = "skeikeijyouym";
    public static final String KYKKBN                   = "kykkbn";
    public static final String HKNSYURUINO              = "hknsyuruino";
    public static final String HKNSYURUINOSD            = "hknsyuruinosd";
    public static final String AISYOUMEIKBN             = "aisyoumeikbn";
    public static final String NKGNSHOSYOURITUKBN       = "nkgnshosyouritukbn";
    public static final String NKGNSHOSYOUGK            = "nkgnshosyougk";
    public static final String LIVHUKAUMU               = "livhukaumu";
    public static final String PMNJTKHUKAKBN            = "pmnjtkhukakbn";
    public static final String PMNJTKKBN                = "pmnjtkkbn";
    public static final String SKNNKAISIKITKHUKAKBN     = "sknnkaisikitkhukakbn";
    public static final String SKNNKAISIKITKKBN         = "sknnkaisikitkkbn";
    public static final String KZKTOUROKUSERVICETOUROKUKBN = "kzktourokuservicetourokukbn";
    public static final String KYKDRTKYKHUKAKBN         = "kykdrtkykhukakbn";
    public static final String STDRSKTKYHKKBN           = "stdrsktkyhkkbn";
    public static final String SDPDKBN                  = "sdpdkbn";
    public static final String SNTKHOUKBN               = "sntkhoukbn";
    public static final String HAITOUKBN                = "haitoukbn";
    public static final String HAITOUKINUKETORIHOUKBN   = "haitoukinuketorihoukbn";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String HRKTUUKASYU              = "hrktuukasyu";
    public static final String YENNYKNTKHKKBN           = "yennykntkhkkbn";
    public static final String GAIKANYKNTKHKKBN         = "gaikanykntkhkkbn";
    public static final String YENSHRTKHKKBN            = "yenshrtkhkkbn";
    public static final String MOSHEIJYUNP              = "mosheijyunp";
    public static final String HEIJYUNP                 = "heijyunp";
    public static final String HEIJYUNPRYOUMASINASI     = "heijyunpryoumasinasi";
    public static final String HRKTUUKAHEIJYUNP         = "hrktuukaheijyunp";
    public static final String IKKATUBARAIKBN           = "ikkatubaraikbn";
    public static final String IKKATUBARAIKAISUU        = "ikkatubaraikaisuu";
    public static final String MOSIKKATUP               = "mosikkatup";
    public static final String IKKATUP                  = "ikkatup";
    public static final String ZENNOUMOUSIDEUMU         = "zennoumousideumu";
    public static final String ZENKIZENNOUUMU           = "zenkizennouumu";
    public static final String ZNNKAI                   = "znnkai";
    public static final String MOSZENNOUPSYOKAIARI      = "moszennoupsyokaiari";
    public static final String ZENNOUP                  = "zennoup";
    public static final String ZENNOUJYUUTOUP           = "zennoujyuutoup";
    public static final String ZNNHRKKAI                = "znnhrkkai";
    public static final String ZNNHRKKEIRO              = "znnhrkkeiro";
    public static final String MOSFSTPKEI               = "mosfstpkei";
    public static final String HYOUTEIP                 = "hyouteip";
    public static final String SEITOUFSTPKEI            = "seitoufstpkei";
    public static final String FSTPHRKGK                = "fstphrkgk";
    public static final String HRKTUUKAFSTPHRKGK        = "hrktuukafstphrkgk";
    public static final String PHARAIKOMISOUGAKU        = "pharaikomisougaku";
    public static final String SIBOUSKEI                = "sibouskei";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String HRKKEIRO                 = "hrkkeiro";
    public static final String FSTPHRKKEIROKBN          = "fstphrkkeirokbn";
    public static final String SKJPJYUUTOUKAISUU        = "skjpjyuutoukaisuu";
    public static final String IKKATUYOUPUMUKBN         = "ikkatuyoupumukbn";
    public static final String IKKATUYOUPKAISUU         = "ikkatuyoupkaisuu";
    public static final String PWARIBIKITEKIYOUKBN      = "pwaribikitekiyoukbn";
    public static final String IKKATUYOUPGKKEIZOKUP     = "ikkatuyoupgkkeizokup";
    public static final String KEIZOKUPTKYKWSRATEKJYMD  = "keizokuptkykwsratekjymd";
    public static final String KEIZOKUPTKYKWSRATE       = "keizokuptkykwsrate";
    public static final String DNTRYOURITUKBN           = "dntryouritukbn";
    public static final String APLKAHIKBN               = "aplkahikbn";
    public static final String ITIPCLRIYOUKBN           = "itipclriyoukbn";
    public static final String ITIPRSYMD                = "itiprsymd";
    public static final String DNTCD                    = "dntcd";
    public static final String MASSISEIYMD              = "massiseiymd";
    public static final String HHKNNMKN                 = "hhknnmkn";
    public static final String HHKNNMKJ                 = "hhknnmkj";
    public static final String HHKNNMKJKHUKAKBN         = "hhknnmkjkhukakbn";
    public static final String HHKNSEIYMD               = "hhknseiymd";
    public static final String HHKNNEN                  = "hhknnen";
    public static final String HHKNSEI                  = "hhknsei";
    public static final String HHKNSYKGYCD              = "hhknsykgycd";
    public static final String HHKNNENSYUUKBN           = "hhknnensyuukbn";
    public static final String TSINDOUSITEIKBN          = "tsindousiteikbn";
    public static final String HHKNYNO                  = "hhknyno";
    public static final String HHKNADR1KN               = "hhknadr1kn";
    public static final String HHKNADR2KN               = "hhknadr2kn";
    public static final String HHKNADR3KN               = "hhknadr3kn";
    public static final String HHKNADR1KJ               = "hhknadr1kj";
    public static final String HHKNADR2KJ               = "hhknadr2kj";
    public static final String HHKNADR3KJ               = "hhknadr3kj";
    public static final String HHKNTELNO                = "hhkntelno";
    public static final String HHKNKINMUSAKINM          = "hhknkinmusakinm";
    public static final String KYKNMKN                  = "kyknmkn";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String KYKNMKJKHUKAKBN          = "kyknmkjkhukakbn";
    public static final String KYKSEIYMD                = "kykseiymd";
    public static final String KYKNEN                   = "kyknen";
    public static final String KYKSEI                   = "kyksei";
    public static final String KYKTDK                   = "kyktdk";
    public static final String KYKNENSYUUKBN            = "kyknensyuukbn";
    public static final String KYKKINMUSAKINM           = "kykkinmusakinm";
    public static final String HJNDAIYKKBN              = "hjndaiykkbn";
    public static final String HJNDAINMKN               = "hjndainmkn";
    public static final String HJNDAINMKJ               = "hjndainmkj";
    public static final String YAKKANJYURYOUHOUKBN      = "yakkanjyuryouhoukbn";
    public static final String YAKKANBUNSYONO           = "yakkanbunsyono";
    public static final String SIORINO                  = "siorino";
    public static final String FATCASNSIKBN             = "fatcasnsikbn";
    public static final String BIKKJNSSINFOKBN          = "bikkjnssinfokbn";
    public static final String BIKKNZSYNO               = "bikknzsyno";
    public static final String SYOMEIYMD                = "syomeiymd";
    public static final String AEOISNSIKBN              = "aeoisnsikbn";
    public static final String TSINYNO                  = "tsinyno";
    public static final String TSINADR1KJ               = "tsinadr1kj";
    public static final String TSINADR2KJ               = "tsinadr2kj";
    public static final String TSINADR3KJ               = "tsinadr3kj";
    public static final String TSINADR1KN               = "tsinadr1kn";
    public static final String TSINADR2KN               = "tsinadr2kn";
    public static final String TSINADR3KN               = "tsinadr3kn";
    public static final String TSINTELNO                = "tsintelno";
    public static final String DAI2TSINTELNO            = "dai2tsintelno";
    public static final String SYOSHADR1KJ              = "syoshadr1kj";
    public static final String SYOSHADR2KJ              = "syoshadr2kj";
    public static final String SYOSHADR3KJ              = "syoshadr3kj";
    public static final String SYOSHTELNO               = "syoshtelno";
    public static final String SYOSHYNO                 = "syoshyno";
    public static final String TARGETTKHKKBN            = "targettkhkkbn";
    public static final String TARGETTKKBN              = "targettkkbn";
    public static final String TARGETTKMKHTKBN          = "targettkmkhtkbn";
    public static final String NSTKHKKBN                = "nstkhkkbn";
    public static final String NSTKMNKNSYU              = "nstkmnknsyu";
    public static final String NSTKMNKNKKN              = "nstkmnknkkn";
    public static final String NSTKSBNSYU               = "nstksbnsyu";
    public static final String NSTKSBNKKN               = "nstksbnkkn";
    public static final String SYKSBYENSITIHSYUTKHKKBN  = "syksbyensitihsyutkhkkbn";
    public static final String JYUDKAIGOMEHRTKHKKBN     = "jyudkaigomehrtkhkkbn";
    public static final String KJNNKPZEITEKITKHUKAKBN   = "kjnnkpzeitekitkhukakbn";
    public static final String TEIKISIHARAITKYKHKKBN    = "teikisiharaitkykhkkbn";
    public static final String SAIHOCD                  = "saihocd";
    public static final String STKNSETKBN               = "stknsetkbn";
    public static final String SBUKTNIN                 = "sbuktnin";
    public static final String KYKHONNINKAKNINSYORUIKBN = "kykhonninkakninsyoruikbn";
    public static final String SKSKKNHONNINKAKNINSYORUIKBN = "skskknhonninkakninsyoruikbn";
    public static final String KOUREIKZKSETUMEIHOUKBN   = "koureikzksetumeihoukbn";
    public static final String KOUREIMNDNHUKUSUUKAIKBN  = "koureimndnhukusuukaikbn";
    public static final String KOUREITRATKISYAIGIDSKKBN = "koureitratkisyaigidskkbn";
    public static final String DAIHITUUMUKBN            = "daihituumukbn";
    public static final String SYOTNSHUYOUPOSTUMUKBN    = "syotnshuyoupostumukbn";
    public static final String UKTKID                   = "uktkid";
    public static final String BOSKYKJYOUTAI            = "boskykjyoutai";
    public static final String TKKINYUKKNTKRUMU         = "tkkinyukkntkrumu";
    public static final String DRCTSERVICEMOSKBN        = "drctservicemoskbn";
    public static final String DSKOKNO                  = "dskokno";
    public static final String DSMAILADDRESS            = "dsmailaddress";
    public static final String YNKHRKMGKANNITUUTIKBN    = "ynkhrkmgkannituutikbn";
    public static final String TOKUTEITRHKANSYONO       = "tokuteitrhkansyono";
    public static final String PPLESSRENJIDSSYMENTTDKHYJ = "pplessrenjidssymenttdkhyj";
    public static final String PPLSRENDOUKOUHURIKOUSOUKBN = "pplsrendoukouhurikousoukbn";
    public static final String PPLESSRENDOUCREDITKOUSOUKBN = "pplessrendoucreditkousoukbn";
    public static final String HNSSTJMMOUUMUKBN         = "hnsstjmmouumukbn";
    public static final String KJMEIGIHKHUNOUUMUKBN     = "kjmeigihkhunouumukbn";
    public static final String TSRYHSHRKYKUMUKBN        = "tsryhshrkykumukbn";
    public static final String SYOSISYATODOKEUMUKBN     = "syosisyatodokeumukbn";
    public static final String KAKUKISYOURYAKUKBUMUKBN  = "kakukisyouryakukbumukbn";
    public static final String SEIYMDMOSSEITOUUMUKBN    = "seiymdmosseitouumukbn";
    public static final String IKOKAKNINSYOTOKKIJKUMU   = "ikokakninsyotokkijkumu";
    public static final String TRTKHOUKOKUSYOTOKKIJKUMU = "trtkhoukokusyotokkijkumu";
    public static final String HNNKAKNINHSKJIKOUUMUKBN  = "hnnkakninhskjikouumukbn";
    public static final String HNNKAKNINHSKTKJIKOUUMUKBN = "hnnkakninhsktkjikouumukbn";
    public static final String SKSKAKNINHSKTKJIKOUUMUKBN = "skskakninhsktkjikouumukbn";
    public static final String KOUSEIINKYKTKJKUMUKBN    = "kouseiinkyktkjkumukbn";
    public static final String KOUKANKYKKINMUSAKINM     = "koukankykkinmusakinm";
    public static final String KOUKANKYKSYOKUMUNAIYOU   = "koukankyksyokumunaiyou";
    public static final String KOUKANKYKTKJKUMUKBN      = "koukankyktkjkumukbn";
    public static final String KHNCHKCMNT               = "khnchkcmnt";
    public static final String MOBILEBOSYUUKBN          = "mobilebosyuukbn";
    public static final String JIMUYOUCD                = "jimuyoucd";
    public static final String TEIRITUHAIBUNWARIKBN     = "teirituhaibunwarikbn";
    public static final String SISUUKBN                 = "sisuukbn";
    public static final String SISUUHAIBUNWARIKBN       = "sisuuhaibunwarikbn";
    public static final String TRHKJIKAKKBN             = "trhkjikakkbn";
    public static final String KOUREITAIOUKBN           = "koureitaioukbn";
    public static final String KYKTUUKASYU2             = "kyktuukasyu2";
    public static final String HRKTUUKASYU2             = "hrktuukasyu2";
    public static final String MOSHEIJYUNP2             = "mosheijyunp2";
    public static final String MOSIKKATUP2              = "mosikkatup2";
    public static final String MOSZENNOUPSYOKAIARI2     = "moszennoupsyokaiari2";
    public static final String KJNNKPZEITEKITKHUKAKBN2  = "kjnnkpzeitekitkhukakbn2";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_MosKihonVrf primaryKey;

    public GenHT_MosKihonVrf() {
        primaryKey = new PKHT_MosKihonVrf();
    }

    public GenHT_MosKihonVrf(String pMosno) {
        primaryKey = new PKHT_MosKihonVrf(pMosno);
    }

    @Transient
    @Override
    public PKHT_MosKihonVrf getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_MosKihonVrf> getMetaClass() {
        return QHT_MosKihonVrf.class;
    }

    @Id
    @Column(name=GenHT_MosKihonVrf.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    private String aitemosno;

    @Column(name=GenHT_MosKihonVrf.AITEMOSNO)
    @MousikomiNo
    public String getAitemosno() {
        return aitemosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setAitemosno(String pAitemosno) {
        aitemosno = pAitemosno;
    }

    private String doujikaiyakusyono;

    @Column(name=GenHT_MosKihonVrf.DOUJIKAIYAKUSYONO)
    @SyoukenNo
    public String getDoujikaiyakusyono() {
        return doujikaiyakusyono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDoujikaiyakusyono(String pDoujikaiyakusyono) {
        doujikaiyakusyono = pDoujikaiyakusyono;
    }

    private String sekno;

    @Column(name=GenHT_MosKihonVrf.SEKNO)
    @MaxLength(max=20)
    @AlphaDigit
    public String getSekno() {
        return sekno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSekno(String pSekno) {
        sekno = pSekno;
    }

    private BizDate pykkigenymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_MosKihonVrf.PYKKIGENYMD)
    @ValidDate
    public BizDate getPykkigenymd() {
        return pykkigenymd;
    }

    public void setPykkigenymd(BizDate pPykkigenymd) {
        pykkigenymd = pPykkigenymd;
    }

    private BizDate mosymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_MosKihonVrf.MOSYMD)
    @ValidDate
    public BizDate getMosymd() {
        return mosymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosymd(BizDate pMosymd) {
        mosymd = pMosymd;
    }

    private BizDate mossakuseiymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_MosKihonVrf.MOSSAKUSEIYMD)
    @ValidDate
    public BizDate getMossakuseiymd() {
        return mossakuseiymd;
    }

    @Trim("both")
    public void setMossakuseiymd(BizDate pMossakuseiymd) {
        mossakuseiymd = pMossakuseiymd;
    }

    private BizDate moscalckijyunymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_MosKihonVrf.MOSCALCKIJYUNYMD)
    @ValidDate
    public BizDate getMoscalckijyunymd() {
        return moscalckijyunymd;
    }

    public void setMoscalckijyunymd(BizDate pMoscalckijyunymd) {
        moscalckijyunymd = pMoscalckijyunymd;
    }

    private BizDate mosukeymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_MosKihonVrf.MOSUKEYMD)
    @ValidDate
    public BizDate getMosukeymd() {
        return mosukeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosukeymd(BizDate pMosukeymd) {
        mosukeymd = pMosukeymd;
    }

    private BizDate mosjimosuktymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_MosKihonVrf.MOSJIMOSUKTYMD)
    public BizDate getMosjimosuktymd() {
        return mosjimosuktymd;
    }

    @Trim("both")
    public void setMosjimosuktymd(BizDate pMosjimosuktymd) {
        mosjimosuktymd = pMosjimosuktymd;
    }

    private BizDate pplessmosukeymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_MosKihonVrf.PPLESSMOSUKEYMD)
    @ValidDate
    public BizDate getPplessmosukeymd() {
        return pplessmosukeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPplessmosukeymd(BizDate pPplessmosukeymd) {
        pplessmosukeymd = pPplessmosukeymd;
    }

    private BizDateYM mosym;

    @Type(type="BizDateYMType")
    @Column(name=GenHT_MosKihonVrf.MOSYM)
    public BizDateYM getMosym() {
        return mosym;
    }

    public void setMosym(BizDateYM pMosym) {
        mosym = pMosym;
    }

    private BizDate ssyukeymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_MosKihonVrf.SSYUKEYMD)
    @ValidDate
    public BizDate getSsyukeymd() {
        return ssyukeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSsyukeymd(BizDate pSsyukeymd) {
        ssyukeymd = pSsyukeymd;
    }

    private BizDate kktymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_MosKihonVrf.KKTYMD)
    @ValidDate
    public BizDate getKktymd() {
        return kktymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKktymd(BizDate pKktymd) {
        kktymd = pKktymd;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_MosKihonVrf.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private C_Kykymdtkrumu kykymdtkrumu;

    @Type(type="UserType_C_Kykymdtkrumu")
    @Column(name=GenHT_MosKihonVrf.KYKYMDTKRUMU)
    public C_Kykymdtkrumu getKykymdtkrumu() {
        return kykymdtkrumu;
    }

    public void setKykymdtkrumu(C_Kykymdtkrumu pKykymdtkrumu) {
        kykymdtkrumu = pKykymdtkrumu;
    }

    private BizDate skykymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_MosKihonVrf.SKYKYMD)
    @ValidDate
    public BizDate getSkykymd() {
        return skykymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkykymd(BizDate pSkykymd) {
        skykymd = pSkykymd;
    }

    private BizDate sknnkaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_MosKihonVrf.SKNNKAISIYMD)
    public BizDate getSknnkaisiymd() {
        return sknnkaisiymd;
    }

    @Trim("both")
    public void setSknnkaisiymd(BizDate pSknnkaisiymd) {
        sknnkaisiymd = pSknnkaisiymd;
    }

    private BizDateYM bosyuuym;

    @Type(type="BizDateYMType")
    @Column(name=GenHT_MosKihonVrf.BOSYUUYM)
    @ValidDateYm
    public BizDateYM getBosyuuym() {
        return bosyuuym;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuuym(BizDateYM pBosyuuym) {
        bosyuuym = pBosyuuym;
    }

    private BizDateYM seisekiym;

    @Type(type="BizDateYMType")
    @Column(name=GenHT_MosKihonVrf.SEISEKIYM)
    public BizDateYM getSeisekiym() {
        return seisekiym;
    }

    @Trim("both")
    public void setSeisekiym(BizDateYM pSeisekiym) {
        seisekiym = pSeisekiym;
    }

    private BizDateYM skeikeijyouym;

    @Type(type="BizDateYMType")
    @Column(name=GenHT_MosKihonVrf.SKEIKEIJYOUYM)
    public BizDateYM getSkeikeijyouym() {
        return skeikeijyouym;
    }

    @Trim("both")
    public void setSkeikeijyouym(BizDateYM pSkeikeijyouym) {
        skeikeijyouym = pSkeikeijyouym;
    }

    private C_KykKbn kykkbn;

    @Type(type="UserType_C_KykKbn")
    @Column(name=GenHT_MosKihonVrf.KYKKBN)
    public C_KykKbn getKykkbn() {
        return kykkbn;
    }

    public void setKykkbn(C_KykKbn pKykkbn) {
        kykkbn = pKykkbn;
    }

    private C_HknsyuruiNo hknsyuruino;

    @Type(type="UserType_C_HknsyuruiNo")
    @Column(name=GenHT_MosKihonVrf.HKNSYURUINO)
    public C_HknsyuruiNo getHknsyuruino() {
        return hknsyuruino;
    }

    public void setHknsyuruino(C_HknsyuruiNo pHknsyuruino) {
        hknsyuruino = pHknsyuruino;
    }

    private Integer hknsyuruinosd;

    @Column(name=GenHT_MosKihonVrf.HKNSYURUINOSD)
    public Integer getHknsyuruinosd() {
        return hknsyuruinosd;
    }

    public void setHknsyuruinosd(Integer pHknsyuruinosd) {
        hknsyuruinosd = pHknsyuruinosd;
    }

    private C_AisyoumeiKbn aisyoumeikbn;

    @Type(type="UserType_C_AisyoumeiKbn")
    @Column(name=GenHT_MosKihonVrf.AISYOUMEIKBN)
    public C_AisyoumeiKbn getAisyoumeikbn() {
        return aisyoumeikbn;
    }

    public void setAisyoumeikbn(C_AisyoumeiKbn pAisyoumeikbn) {
        aisyoumeikbn = pAisyoumeikbn;
    }

    private C_NkgnsHosyourituKbn nkgnshosyouritukbn;

    @Type(type="UserType_C_NkgnsHosyourituKbn")
    @Column(name=GenHT_MosKihonVrf.NKGNSHOSYOURITUKBN)
    public C_NkgnsHosyourituKbn getNkgnshosyouritukbn() {
        return nkgnshosyouritukbn;
    }

    public void setNkgnshosyouritukbn(C_NkgnsHosyourituKbn pNkgnshosyouritukbn) {
        nkgnshosyouritukbn = pNkgnshosyouritukbn;
    }

    private BizCurrency nkgnshosyougk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNkgnshosyougk() {
        return nkgnshosyougk;
    }

    public void setNkgnshosyougk(BizCurrency pNkgnshosyougk) {
        nkgnshosyougk = pNkgnshosyougk;
        nkgnshosyougkValue = null;
        nkgnshosyougkType  = null;
    }

    transient private BigDecimal nkgnshosyougkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NKGNSHOSYOUGK, nullable=true)
    protected BigDecimal getNkgnshosyougkValue() {
        if (nkgnshosyougkValue == null && nkgnshosyougk != null) {
            if (nkgnshosyougk.isOptional()) return null;
            return nkgnshosyougk.absolute();
        }
        return nkgnshosyougkValue;
    }

    protected void setNkgnshosyougkValue(BigDecimal value) {
        nkgnshosyougkValue = value;
        nkgnshosyougk = Optional.fromNullable(toCurrencyType(nkgnshosyougkType))
            .transform(bizCurrencyTransformer(getNkgnshosyougkValue()))
            .orNull();
    }

    transient private String nkgnshosyougkType = null;

    @Column(name=NKGNSHOSYOUGK + "$", nullable=true)
    protected String getNkgnshosyougkType() {
        if (nkgnshosyougkType == null && nkgnshosyougk != null) return nkgnshosyougk.getType().toString();
        if (nkgnshosyougkType == null && getNkgnshosyougkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'nkgnshosyougk$' should not be NULL."));
        }
        return nkgnshosyougkType;
    }

    protected void setNkgnshosyougkType(String type) {
        nkgnshosyougkType = type;
        nkgnshosyougk = Optional.fromNullable(toCurrencyType(nkgnshosyougkType))
            .transform(bizCurrencyTransformer(getNkgnshosyougkValue()))
            .orNull();
    }

    private C_Livhukaumu livhukaumu;

    @Type(type="UserType_C_Livhukaumu")
    @Column(name=GenHT_MosKihonVrf.LIVHUKAUMU)
    public C_Livhukaumu getLivhukaumu() {
        return livhukaumu;
    }

    public void setLivhukaumu(C_Livhukaumu pLivhukaumu) {
        livhukaumu = pLivhukaumu;
    }

    private C_PmnjtkhukaKbn pmnjtkhukakbn;

    @Type(type="UserType_C_PmnjtkhukaKbn")
    @Column(name=GenHT_MosKihonVrf.PMNJTKHUKAKBN)
    public C_PmnjtkhukaKbn getPmnjtkhukakbn() {
        return pmnjtkhukakbn;
    }

    public void setPmnjtkhukakbn(C_PmnjtkhukaKbn pPmnjtkhukakbn) {
        pmnjtkhukakbn = pPmnjtkhukakbn;
    }

    private C_PmnjtkKbn pmnjtkkbn;

    @Type(type="UserType_C_PmnjtkKbn")
    @Column(name=GenHT_MosKihonVrf.PMNJTKKBN)
    public C_PmnjtkKbn getPmnjtkkbn() {
        return pmnjtkkbn;
    }

    public void setPmnjtkkbn(C_PmnjtkKbn pPmnjtkkbn) {
        pmnjtkkbn = pPmnjtkkbn;
    }

    private C_SknnkaisikitkhukaKbn sknnkaisikitkhukakbn;

    @Type(type="UserType_C_SknnkaisikitkhukaKbn")
    @Column(name=GenHT_MosKihonVrf.SKNNKAISIKITKHUKAKBN)
    public C_SknnkaisikitkhukaKbn getSknnkaisikitkhukakbn() {
        return sknnkaisikitkhukakbn;
    }

    public void setSknnkaisikitkhukakbn(C_SknnkaisikitkhukaKbn pSknnkaisikitkhukakbn) {
        sknnkaisikitkhukakbn = pSknnkaisikitkhukakbn;
    }

    private C_SknnkaisikitkKbn sknnkaisikitkkbn;

    @Type(type="UserType_C_SknnkaisikitkKbn")
    @Column(name=GenHT_MosKihonVrf.SKNNKAISIKITKKBN)
    public C_SknnkaisikitkKbn getSknnkaisikitkkbn() {
        return sknnkaisikitkkbn;
    }

    public void setSknnkaisikitkkbn(C_SknnkaisikitkKbn pSknnkaisikitkkbn) {
        sknnkaisikitkkbn = pSknnkaisikitkkbn;
    }

    private C_KzktourokuserviceTourokuKbn kzktourokuservicetourokukbn;

    @Type(type="UserType_C_KzktourokuserviceTourokuKbn")
    @Column(name=GenHT_MosKihonVrf.KZKTOUROKUSERVICETOUROKUKBN)
    public C_KzktourokuserviceTourokuKbn getKzktourokuservicetourokukbn() {
        return kzktourokuservicetourokukbn;
    }

    public void setKzktourokuservicetourokukbn(C_KzktourokuserviceTourokuKbn pKzktourokuservicetourokukbn) {
        kzktourokuservicetourokukbn = pKzktourokuservicetourokukbn;
    }

    private C_Tkhukaumu kykdrtkykhukakbn;

    @Type(type="UserType_C_Tkhukaumu")
    @Column(name=GenHT_MosKihonVrf.KYKDRTKYKHUKAKBN)
    public C_Tkhukaumu getKykdrtkykhukakbn() {
        return kykdrtkykhukakbn;
    }

    public void setKykdrtkykhukakbn(C_Tkhukaumu pKykdrtkykhukakbn) {
        kykdrtkykhukakbn = pKykdrtkykhukakbn;
    }

    private C_Tkhukaumu stdrsktkyhkkbn;

    @Type(type="UserType_C_Tkhukaumu")
    @Column(name=GenHT_MosKihonVrf.STDRSKTKYHKKBN)
    public C_Tkhukaumu getStdrsktkyhkkbn() {
        return stdrsktkyhkkbn;
    }

    public void setStdrsktkyhkkbn(C_Tkhukaumu pStdrsktkyhkkbn) {
        stdrsktkyhkkbn = pStdrsktkyhkkbn;
    }

    private C_Sdpd sdpdkbn;

    @Type(type="UserType_C_Sdpd")
    @Column(name=GenHT_MosKihonVrf.SDPDKBN)
    public C_Sdpd getSdpdkbn() {
        return sdpdkbn;
    }

    public void setSdpdkbn(C_Sdpd pSdpdkbn) {
        sdpdkbn = pSdpdkbn;
    }

    private C_SntkhouKbn sntkhoukbn;

    @Type(type="UserType_C_SntkhouKbn")
    @Column(name=GenHT_MosKihonVrf.SNTKHOUKBN)
    public C_SntkhouKbn getSntkhoukbn() {
        return sntkhoukbn;
    }

    public void setSntkhoukbn(C_SntkhouKbn pSntkhoukbn) {
        sntkhoukbn = pSntkhoukbn;
    }

    private C_HaitouKbn haitoukbn;

    @Type(type="UserType_C_HaitouKbn")
    @Column(name=GenHT_MosKihonVrf.HAITOUKBN)
    public C_HaitouKbn getHaitoukbn() {
        return haitoukbn;
    }

    public void setHaitoukbn(C_HaitouKbn pHaitoukbn) {
        haitoukbn = pHaitoukbn;
    }

    private C_HaitoukinuketorihouKbn haitoukinuketorihoukbn;

    @Type(type="UserType_C_HaitoukinuketorihouKbn")
    @Column(name=GenHT_MosKihonVrf.HAITOUKINUKETORIHOUKBN)
    public C_HaitoukinuketorihouKbn getHaitoukinuketorihoukbn() {
        return haitoukinuketorihoukbn;
    }

    public void setHaitoukinuketorihoukbn(C_HaitoukinuketorihouKbn pHaitoukinuketorihoukbn) {
        haitoukinuketorihoukbn = pHaitoukinuketorihoukbn;
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHT_MosKihonVrf.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private C_Tuukasyu hrktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHT_MosKihonVrf.HRKTUUKASYU)
    public C_Tuukasyu getHrktuukasyu() {
        return hrktuukasyu;
    }

    public void setHrktuukasyu(C_Tuukasyu pHrktuukasyu) {
        hrktuukasyu = pHrktuukasyu;
    }

    private C_Tkhukaumu yennykntkhkkbn;

    @Type(type="UserType_C_Tkhukaumu")
    @Column(name=GenHT_MosKihonVrf.YENNYKNTKHKKBN)
    public C_Tkhukaumu getYennykntkhkkbn() {
        return yennykntkhkkbn;
    }

    public void setYennykntkhkkbn(C_Tkhukaumu pYennykntkhkkbn) {
        yennykntkhkkbn = pYennykntkhkkbn;
    }

    private C_Tkhukaumu gaikanykntkhkkbn;

    @Type(type="UserType_C_Tkhukaumu")
    @Column(name=GenHT_MosKihonVrf.GAIKANYKNTKHKKBN)
    public C_Tkhukaumu getGaikanykntkhkkbn() {
        return gaikanykntkhkkbn;
    }

    public void setGaikanykntkhkkbn(C_Tkhukaumu pGaikanykntkhkkbn) {
        gaikanykntkhkkbn = pGaikanykntkhkkbn;
    }

    private C_Tkhukaumu yenshrtkhkkbn;

    @Type(type="UserType_C_Tkhukaumu")
    @Column(name=GenHT_MosKihonVrf.YENSHRTKHKKBN)
    public C_Tkhukaumu getYenshrtkhkkbn() {
        return yenshrtkhkkbn;
    }

    public void setYenshrtkhkkbn(C_Tkhukaumu pYenshrtkhkkbn) {
        yenshrtkhkkbn = pYenshrtkhkkbn;
    }

    private BizCurrency mosheijyunp;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getMosheijyunp() {
        return mosheijyunp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosheijyunp(BizCurrency pMosheijyunp) {
        mosheijyunp = pMosheijyunp;
        mosheijyunpValue = null;
        mosheijyunpType  = null;
    }

    transient private BigDecimal mosheijyunpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MOSHEIJYUNP, nullable=true)
    protected BigDecimal getMosheijyunpValue() {
        if (mosheijyunpValue == null && mosheijyunp != null) {
            if (mosheijyunp.isOptional()) return null;
            return mosheijyunp.absolute();
        }
        return mosheijyunpValue;
    }

    protected void setMosheijyunpValue(BigDecimal value) {
        mosheijyunpValue = value;
        mosheijyunp = Optional.fromNullable(toCurrencyType(mosheijyunpType))
            .transform(bizCurrencyTransformer(getMosheijyunpValue()))
            .orNull();
    }

    transient private String mosheijyunpType = null;

    @Column(name=MOSHEIJYUNP + "$", nullable=true)
    protected String getMosheijyunpType() {
        if (mosheijyunpType == null && mosheijyunp != null) return mosheijyunp.getType().toString();
        if (mosheijyunpType == null && getMosheijyunpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mosheijyunp$' should not be NULL."));
        }
        return mosheijyunpType;
    }

    protected void setMosheijyunpType(String type) {
        mosheijyunpType = type;
        mosheijyunp = Optional.fromNullable(toCurrencyType(mosheijyunpType))
            .transform(bizCurrencyTransformer(getMosheijyunpValue()))
            .orNull();
    }

    private BizCurrency heijyunp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHeijyunp() {
        return heijyunp;
    }

    public void setHeijyunp(BizCurrency pHeijyunp) {
        heijyunp = pHeijyunp;
        heijyunpValue = null;
        heijyunpType  = null;
    }

    transient private BigDecimal heijyunpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HEIJYUNP, nullable=true)
    protected BigDecimal getHeijyunpValue() {
        if (heijyunpValue == null && heijyunp != null) {
            if (heijyunp.isOptional()) return null;
            return heijyunp.absolute();
        }
        return heijyunpValue;
    }

    protected void setHeijyunpValue(BigDecimal value) {
        heijyunpValue = value;
        heijyunp = Optional.fromNullable(toCurrencyType(heijyunpType))
            .transform(bizCurrencyTransformer(getHeijyunpValue()))
            .orNull();
    }

    transient private String heijyunpType = null;

    @Column(name=HEIJYUNP + "$", nullable=true)
    protected String getHeijyunpType() {
        if (heijyunpType == null && heijyunp != null) return heijyunp.getType().toString();
        if (heijyunpType == null && getHeijyunpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'heijyunp$' should not be NULL."));
        }
        return heijyunpType;
    }

    protected void setHeijyunpType(String type) {
        heijyunpType = type;
        heijyunp = Optional.fromNullable(toCurrencyType(heijyunpType))
            .transform(bizCurrencyTransformer(getHeijyunpValue()))
            .orNull();
    }

    private BizCurrency heijyunpryoumasinasi;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHeijyunpryoumasinasi() {
        return heijyunpryoumasinasi;
    }

    public void setHeijyunpryoumasinasi(BizCurrency pHeijyunpryoumasinasi) {
        heijyunpryoumasinasi = pHeijyunpryoumasinasi;
        heijyunpryoumasinasiValue = null;
        heijyunpryoumasinasiType  = null;
    }

    transient private BigDecimal heijyunpryoumasinasiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HEIJYUNPRYOUMASINASI, nullable=true)
    protected BigDecimal getHeijyunpryoumasinasiValue() {
        if (heijyunpryoumasinasiValue == null && heijyunpryoumasinasi != null) {
            if (heijyunpryoumasinasi.isOptional()) return null;
            return heijyunpryoumasinasi.absolute();
        }
        return heijyunpryoumasinasiValue;
    }

    protected void setHeijyunpryoumasinasiValue(BigDecimal value) {
        heijyunpryoumasinasiValue = value;
        heijyunpryoumasinasi = Optional.fromNullable(toCurrencyType(heijyunpryoumasinasiType))
            .transform(bizCurrencyTransformer(getHeijyunpryoumasinasiValue()))
            .orNull();
    }

    transient private String heijyunpryoumasinasiType = null;

    @Column(name=HEIJYUNPRYOUMASINASI + "$", nullable=true)
    protected String getHeijyunpryoumasinasiType() {
        if (heijyunpryoumasinasiType == null && heijyunpryoumasinasi != null) return heijyunpryoumasinasi.getType().toString();
        if (heijyunpryoumasinasiType == null && getHeijyunpryoumasinasiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'heijyunpryoumasinasi$' should not be NULL."));
        }
        return heijyunpryoumasinasiType;
    }

    protected void setHeijyunpryoumasinasiType(String type) {
        heijyunpryoumasinasiType = type;
        heijyunpryoumasinasi = Optional.fromNullable(toCurrencyType(heijyunpryoumasinasiType))
            .transform(bizCurrencyTransformer(getHeijyunpryoumasinasiValue()))
            .orNull();
    }

    private BizCurrency hrktuukaheijyunp;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getHrktuukaheijyunp() {
        return hrktuukaheijyunp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHrktuukaheijyunp(BizCurrency pHrktuukaheijyunp) {
        hrktuukaheijyunp = pHrktuukaheijyunp;
        hrktuukaheijyunpValue = null;
        hrktuukaheijyunpType  = null;
    }

    transient private BigDecimal hrktuukaheijyunpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HRKTUUKAHEIJYUNP, nullable=true)
    protected BigDecimal getHrktuukaheijyunpValue() {
        if (hrktuukaheijyunpValue == null && hrktuukaheijyunp != null) {
            if (hrktuukaheijyunp.isOptional()) return null;
            return hrktuukaheijyunp.absolute();
        }
        return hrktuukaheijyunpValue;
    }

    protected void setHrktuukaheijyunpValue(BigDecimal value) {
        hrktuukaheijyunpValue = value;
        hrktuukaheijyunp = Optional.fromNullable(toCurrencyType(hrktuukaheijyunpType))
            .transform(bizCurrencyTransformer(getHrktuukaheijyunpValue()))
            .orNull();
    }

    transient private String hrktuukaheijyunpType = null;

    @Column(name=HRKTUUKAHEIJYUNP + "$", nullable=true)
    protected String getHrktuukaheijyunpType() {
        if (hrktuukaheijyunpType == null && hrktuukaheijyunp != null) return hrktuukaheijyunp.getType().toString();
        if (hrktuukaheijyunpType == null && getHrktuukaheijyunpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hrktuukaheijyunp$' should not be NULL."));
        }
        return hrktuukaheijyunpType;
    }

    protected void setHrktuukaheijyunpType(String type) {
        hrktuukaheijyunpType = type;
        hrktuukaheijyunp = Optional.fromNullable(toCurrencyType(hrktuukaheijyunpType))
            .transform(bizCurrencyTransformer(getHrktuukaheijyunpValue()))
            .orNull();
    }

    private C_IkkatubaraiKbn ikkatubaraikbn;

    @Type(type="UserType_C_IkkatubaraiKbn")
    @Column(name=GenHT_MosKihonVrf.IKKATUBARAIKBN)
    public C_IkkatubaraiKbn getIkkatubaraikbn() {
        return ikkatubaraikbn;
    }

    public void setIkkatubaraikbn(C_IkkatubaraiKbn pIkkatubaraikbn) {
        ikkatubaraikbn = pIkkatubaraikbn;
    }

    private C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu;

    @Type(type="UserType_C_IkkatubaraiKaisuuKbn")
    @Column(name=GenHT_MosKihonVrf.IKKATUBARAIKAISUU)
    public C_IkkatubaraiKaisuuKbn getIkkatubaraikaisuu() {
        return ikkatubaraikaisuu;
    }

    public void setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn pIkkatubaraikaisuu) {
        ikkatubaraikaisuu = pIkkatubaraikaisuu;
    }

    private BizCurrency mosikkatup;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getMosikkatup() {
        return mosikkatup;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosikkatup(BizCurrency pMosikkatup) {
        mosikkatup = pMosikkatup;
        mosikkatupValue = null;
        mosikkatupType  = null;
    }

    transient private BigDecimal mosikkatupValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MOSIKKATUP, nullable=true)
    protected BigDecimal getMosikkatupValue() {
        if (mosikkatupValue == null && mosikkatup != null) {
            if (mosikkatup.isOptional()) return null;
            return mosikkatup.absolute();
        }
        return mosikkatupValue;
    }

    protected void setMosikkatupValue(BigDecimal value) {
        mosikkatupValue = value;
        mosikkatup = Optional.fromNullable(toCurrencyType(mosikkatupType))
            .transform(bizCurrencyTransformer(getMosikkatupValue()))
            .orNull();
    }

    transient private String mosikkatupType = null;

    @Column(name=MOSIKKATUP + "$", nullable=true)
    protected String getMosikkatupType() {
        if (mosikkatupType == null && mosikkatup != null) return mosikkatup.getType().toString();
        if (mosikkatupType == null && getMosikkatupValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mosikkatup$' should not be NULL."));
        }
        return mosikkatupType;
    }

    protected void setMosikkatupType(String type) {
        mosikkatupType = type;
        mosikkatup = Optional.fromNullable(toCurrencyType(mosikkatupType))
            .transform(bizCurrencyTransformer(getMosikkatupValue()))
            .orNull();
    }

    private BizCurrency ikkatup;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getIkkatup() {
        return ikkatup;
    }

    public void setIkkatup(BizCurrency pIkkatup) {
        ikkatup = pIkkatup;
        ikkatupValue = null;
        ikkatupType  = null;
    }

    transient private BigDecimal ikkatupValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=IKKATUP, nullable=true)
    protected BigDecimal getIkkatupValue() {
        if (ikkatupValue == null && ikkatup != null) {
            if (ikkatup.isOptional()) return null;
            return ikkatup.absolute();
        }
        return ikkatupValue;
    }

    protected void setIkkatupValue(BigDecimal value) {
        ikkatupValue = value;
        ikkatup = Optional.fromNullable(toCurrencyType(ikkatupType))
            .transform(bizCurrencyTransformer(getIkkatupValue()))
            .orNull();
    }

    transient private String ikkatupType = null;

    @Column(name=IKKATUP + "$", nullable=true)
    protected String getIkkatupType() {
        if (ikkatupType == null && ikkatup != null) return ikkatup.getType().toString();
        if (ikkatupType == null && getIkkatupValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'ikkatup$' should not be NULL."));
        }
        return ikkatupType;
    }

    protected void setIkkatupType(String type) {
        ikkatupType = type;
        ikkatup = Optional.fromNullable(toCurrencyType(ikkatupType))
            .transform(bizCurrencyTransformer(getIkkatupValue()))
            .orNull();
    }

    private C_UmuKbn zennoumousideumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_MosKihonVrf.ZENNOUMOUSIDEUMU)
    public C_UmuKbn getZennoumousideumu() {
        return zennoumousideumu;
    }

    public void setZennoumousideumu(C_UmuKbn pZennoumousideumu) {
        zennoumousideumu = pZennoumousideumu;
    }

    private C_BlnktkumuKbn zenkizennouumu;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenHT_MosKihonVrf.ZENKIZENNOUUMU)
    public C_BlnktkumuKbn getZenkizennouumu() {
        return zenkizennouumu;
    }

    public void setZenkizennouumu(C_BlnktkumuKbn pZenkizennouumu) {
        zenkizennouumu = pZenkizennouumu;
    }

    private Integer znnkai;

    @Column(name=GenHT_MosKihonVrf.ZNNKAI)
    @Range(min="0", max="999")
    public Integer getZnnkai() {
        return znnkai;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZnnkai(Integer pZnnkai) {
        znnkai = pZnnkai;
    }

    private BizCurrency moszennoupsyokaiari;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getMoszennoupsyokaiari() {
        return moszennoupsyokaiari;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMoszennoupsyokaiari(BizCurrency pMoszennoupsyokaiari) {
        moszennoupsyokaiari = pMoszennoupsyokaiari;
        moszennoupsyokaiariValue = null;
        moszennoupsyokaiariType  = null;
    }

    transient private BigDecimal moszennoupsyokaiariValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MOSZENNOUPSYOKAIARI, nullable=true)
    protected BigDecimal getMoszennoupsyokaiariValue() {
        if (moszennoupsyokaiariValue == null && moszennoupsyokaiari != null) {
            if (moszennoupsyokaiari.isOptional()) return null;
            return moszennoupsyokaiari.absolute();
        }
        return moszennoupsyokaiariValue;
    }

    protected void setMoszennoupsyokaiariValue(BigDecimal value) {
        moszennoupsyokaiariValue = value;
        moszennoupsyokaiari = Optional.fromNullable(toCurrencyType(moszennoupsyokaiariType))
            .transform(bizCurrencyTransformer(getMoszennoupsyokaiariValue()))
            .orNull();
    }

    transient private String moszennoupsyokaiariType = null;

    @Column(name=MOSZENNOUPSYOKAIARI + "$", nullable=true)
    protected String getMoszennoupsyokaiariType() {
        if (moszennoupsyokaiariType == null && moszennoupsyokaiari != null) return moszennoupsyokaiari.getType().toString();
        if (moszennoupsyokaiariType == null && getMoszennoupsyokaiariValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'moszennoupsyokaiari$' should not be NULL."));
        }
        return moszennoupsyokaiariType;
    }

    protected void setMoszennoupsyokaiariType(String type) {
        moszennoupsyokaiariType = type;
        moszennoupsyokaiari = Optional.fromNullable(toCurrencyType(moszennoupsyokaiariType))
            .transform(bizCurrencyTransformer(getMoszennoupsyokaiariValue()))
            .orNull();
    }

    private BizCurrency zennoup;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZennoup() {
        return zennoup;
    }

    public void setZennoup(BizCurrency pZennoup) {
        zennoup = pZennoup;
        zennoupValue = null;
        zennoupType  = null;
    }

    transient private BigDecimal zennoupValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZENNOUP, nullable=true)
    protected BigDecimal getZennoupValue() {
        if (zennoupValue == null && zennoup != null) {
            if (zennoup.isOptional()) return null;
            return zennoup.absolute();
        }
        return zennoupValue;
    }

    protected void setZennoupValue(BigDecimal value) {
        zennoupValue = value;
        zennoup = Optional.fromNullable(toCurrencyType(zennoupType))
            .transform(bizCurrencyTransformer(getZennoupValue()))
            .orNull();
    }

    transient private String zennoupType = null;

    @Column(name=ZENNOUP + "$", nullable=true)
    protected String getZennoupType() {
        if (zennoupType == null && zennoup != null) return zennoup.getType().toString();
        if (zennoupType == null && getZennoupValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zennoup$' should not be NULL."));
        }
        return zennoupType;
    }

    protected void setZennoupType(String type) {
        zennoupType = type;
        zennoup = Optional.fromNullable(toCurrencyType(zennoupType))
            .transform(bizCurrencyTransformer(getZennoupValue()))
            .orNull();
    }

    private BizCurrency zennoujyuutoup;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZennoujyuutoup() {
        return zennoujyuutoup;
    }

    public void setZennoujyuutoup(BizCurrency pZennoujyuutoup) {
        zennoujyuutoup = pZennoujyuutoup;
        zennoujyuutoupValue = null;
        zennoujyuutoupType  = null;
    }

    transient private BigDecimal zennoujyuutoupValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZENNOUJYUUTOUP, nullable=true)
    protected BigDecimal getZennoujyuutoupValue() {
        if (zennoujyuutoupValue == null && zennoujyuutoup != null) {
            if (zennoujyuutoup.isOptional()) return null;
            return zennoujyuutoup.absolute();
        }
        return zennoujyuutoupValue;
    }

    protected void setZennoujyuutoupValue(BigDecimal value) {
        zennoujyuutoupValue = value;
        zennoujyuutoup = Optional.fromNullable(toCurrencyType(zennoujyuutoupType))
            .transform(bizCurrencyTransformer(getZennoujyuutoupValue()))
            .orNull();
    }

    transient private String zennoujyuutoupType = null;

    @Column(name=ZENNOUJYUUTOUP + "$", nullable=true)
    protected String getZennoujyuutoupType() {
        if (zennoujyuutoupType == null && zennoujyuutoup != null) return zennoujyuutoup.getType().toString();
        if (zennoujyuutoupType == null && getZennoujyuutoupValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zennoujyuutoup$' should not be NULL."));
        }
        return zennoujyuutoupType;
    }

    protected void setZennoujyuutoupType(String type) {
        zennoujyuutoupType = type;
        zennoujyuutoup = Optional.fromNullable(toCurrencyType(zennoujyuutoupType))
            .transform(bizCurrencyTransformer(getZennoujyuutoupValue()))
            .orNull();
    }

    private C_Znnhrkkai znnhrkkai;

    @Type(type="UserType_C_Znnhrkkai")
    @Column(name=GenHT_MosKihonVrf.ZNNHRKKAI)
    public C_Znnhrkkai getZnnhrkkai() {
        return znnhrkkai;
    }

    public void setZnnhrkkai(C_Znnhrkkai pZnnhrkkai) {
        znnhrkkai = pZnnhrkkai;
    }

    private C_Znnhrkkeiro znnhrkkeiro;

    @Type(type="UserType_C_Znnhrkkeiro")
    @Column(name=GenHT_MosKihonVrf.ZNNHRKKEIRO)
    public C_Znnhrkkeiro getZnnhrkkeiro() {
        return znnhrkkeiro;
    }

    public void setZnnhrkkeiro(C_Znnhrkkeiro pZnnhrkkeiro) {
        znnhrkkeiro = pZnnhrkkeiro;
    }

    private BizCurrency mosfstpkei;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getMosfstpkei() {
        return mosfstpkei;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosfstpkei(BizCurrency pMosfstpkei) {
        mosfstpkei = pMosfstpkei;
        mosfstpkeiValue = null;
        mosfstpkeiType  = null;
    }

    transient private BigDecimal mosfstpkeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MOSFSTPKEI, nullable=true)
    protected BigDecimal getMosfstpkeiValue() {
        if (mosfstpkeiValue == null && mosfstpkei != null) {
            if (mosfstpkei.isOptional()) return null;
            return mosfstpkei.absolute();
        }
        return mosfstpkeiValue;
    }

    protected void setMosfstpkeiValue(BigDecimal value) {
        mosfstpkeiValue = value;
        mosfstpkei = Optional.fromNullable(toCurrencyType(mosfstpkeiType))
            .transform(bizCurrencyTransformer(getMosfstpkeiValue()))
            .orNull();
    }

    transient private String mosfstpkeiType = null;

    @Column(name=MOSFSTPKEI + "$", nullable=true)
    protected String getMosfstpkeiType() {
        if (mosfstpkeiType == null && mosfstpkei != null) return mosfstpkei.getType().toString();
        if (mosfstpkeiType == null && getMosfstpkeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mosfstpkei$' should not be NULL."));
        }
        return mosfstpkeiType;
    }

    protected void setMosfstpkeiType(String type) {
        mosfstpkeiType = type;
        mosfstpkei = Optional.fromNullable(toCurrencyType(mosfstpkeiType))
            .transform(bizCurrencyTransformer(getMosfstpkeiValue()))
            .orNull();
    }

    private BizCurrency hyouteip;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHyouteip() {
        return hyouteip;
    }

    public void setHyouteip(BizCurrency pHyouteip) {
        hyouteip = pHyouteip;
        hyouteipValue = null;
        hyouteipType  = null;
    }

    transient private BigDecimal hyouteipValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HYOUTEIP, nullable=true)
    protected BigDecimal getHyouteipValue() {
        if (hyouteipValue == null && hyouteip != null) {
            if (hyouteip.isOptional()) return null;
            return hyouteip.absolute();
        }
        return hyouteipValue;
    }

    protected void setHyouteipValue(BigDecimal value) {
        hyouteipValue = value;
        hyouteip = Optional.fromNullable(toCurrencyType(hyouteipType))
            .transform(bizCurrencyTransformer(getHyouteipValue()))
            .orNull();
    }

    transient private String hyouteipType = null;

    @Column(name=HYOUTEIP + "$", nullable=true)
    protected String getHyouteipType() {
        if (hyouteipType == null && hyouteip != null) return hyouteip.getType().toString();
        if (hyouteipType == null && getHyouteipValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hyouteip$' should not be NULL."));
        }
        return hyouteipType;
    }

    protected void setHyouteipType(String type) {
        hyouteipType = type;
        hyouteip = Optional.fromNullable(toCurrencyType(hyouteipType))
            .transform(bizCurrencyTransformer(getHyouteipValue()))
            .orNull();
    }

    private BizCurrency seitoufstpkei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSeitoufstpkei() {
        return seitoufstpkei;
    }

    public void setSeitoufstpkei(BizCurrency pSeitoufstpkei) {
        seitoufstpkei = pSeitoufstpkei;
        seitoufstpkeiValue = null;
        seitoufstpkeiType  = null;
    }

    transient private BigDecimal seitoufstpkeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SEITOUFSTPKEI, nullable=true)
    protected BigDecimal getSeitoufstpkeiValue() {
        if (seitoufstpkeiValue == null && seitoufstpkei != null) {
            if (seitoufstpkei.isOptional()) return null;
            return seitoufstpkei.absolute();
        }
        return seitoufstpkeiValue;
    }

    protected void setSeitoufstpkeiValue(BigDecimal value) {
        seitoufstpkeiValue = value;
        seitoufstpkei = Optional.fromNullable(toCurrencyType(seitoufstpkeiType))
            .transform(bizCurrencyTransformer(getSeitoufstpkeiValue()))
            .orNull();
    }

    transient private String seitoufstpkeiType = null;

    @Column(name=SEITOUFSTPKEI + "$", nullable=true)
    protected String getSeitoufstpkeiType() {
        if (seitoufstpkeiType == null && seitoufstpkei != null) return seitoufstpkei.getType().toString();
        if (seitoufstpkeiType == null && getSeitoufstpkeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'seitoufstpkei$' should not be NULL."));
        }
        return seitoufstpkeiType;
    }

    protected void setSeitoufstpkeiType(String type) {
        seitoufstpkeiType = type;
        seitoufstpkei = Optional.fromNullable(toCurrencyType(seitoufstpkeiType))
            .transform(bizCurrencyTransformer(getSeitoufstpkeiValue()))
            .orNull();
    }

    private BizCurrency fstphrkgk;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getFstphrkgk() {
        return fstphrkgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setFstphrkgk(BizCurrency pFstphrkgk) {
        fstphrkgk = pFstphrkgk;
        fstphrkgkValue = null;
        fstphrkgkType  = null;
    }

    transient private BigDecimal fstphrkgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=FSTPHRKGK, nullable=true)
    protected BigDecimal getFstphrkgkValue() {
        if (fstphrkgkValue == null && fstphrkgk != null) {
            if (fstphrkgk.isOptional()) return null;
            return fstphrkgk.absolute();
        }
        return fstphrkgkValue;
    }

    protected void setFstphrkgkValue(BigDecimal value) {
        fstphrkgkValue = value;
        fstphrkgk = Optional.fromNullable(toCurrencyType(fstphrkgkType))
            .transform(bizCurrencyTransformer(getFstphrkgkValue()))
            .orNull();
    }

    transient private String fstphrkgkType = null;

    @Column(name=FSTPHRKGK + "$", nullable=true)
    protected String getFstphrkgkType() {
        if (fstphrkgkType == null && fstphrkgk != null) return fstphrkgk.getType().toString();
        if (fstphrkgkType == null && getFstphrkgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'fstphrkgk$' should not be NULL."));
        }
        return fstphrkgkType;
    }

    protected void setFstphrkgkType(String type) {
        fstphrkgkType = type;
        fstphrkgk = Optional.fromNullable(toCurrencyType(fstphrkgkType))
            .transform(bizCurrencyTransformer(getFstphrkgkValue()))
            .orNull();
    }

    private BizCurrency hrktuukafstphrkgk;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getHrktuukafstphrkgk() {
        return hrktuukafstphrkgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHrktuukafstphrkgk(BizCurrency pHrktuukafstphrkgk) {
        hrktuukafstphrkgk = pHrktuukafstphrkgk;
        hrktuukafstphrkgkValue = null;
        hrktuukafstphrkgkType  = null;
    }

    transient private BigDecimal hrktuukafstphrkgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HRKTUUKAFSTPHRKGK, nullable=true)
    protected BigDecimal getHrktuukafstphrkgkValue() {
        if (hrktuukafstphrkgkValue == null && hrktuukafstphrkgk != null) {
            if (hrktuukafstphrkgk.isOptional()) return null;
            return hrktuukafstphrkgk.absolute();
        }
        return hrktuukafstphrkgkValue;
    }

    protected void setHrktuukafstphrkgkValue(BigDecimal value) {
        hrktuukafstphrkgkValue = value;
        hrktuukafstphrkgk = Optional.fromNullable(toCurrencyType(hrktuukafstphrkgkType))
            .transform(bizCurrencyTransformer(getHrktuukafstphrkgkValue()))
            .orNull();
    }

    transient private String hrktuukafstphrkgkType = null;

    @Column(name=HRKTUUKAFSTPHRKGK + "$", nullable=true)
    protected String getHrktuukafstphrkgkType() {
        if (hrktuukafstphrkgkType == null && hrktuukafstphrkgk != null) return hrktuukafstphrkgk.getType().toString();
        if (hrktuukafstphrkgkType == null && getHrktuukafstphrkgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hrktuukafstphrkgk$' should not be NULL."));
        }
        return hrktuukafstphrkgkType;
    }

    protected void setHrktuukafstphrkgkType(String type) {
        hrktuukafstphrkgkType = type;
        hrktuukafstphrkgk = Optional.fromNullable(toCurrencyType(hrktuukafstphrkgkType))
            .transform(bizCurrencyTransformer(getHrktuukafstphrkgkValue()))
            .orNull();
    }

    private BizCurrency pharaikomisougaku;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getPharaikomisougaku() {
        return pharaikomisougaku;
    }

    public void setPharaikomisougaku(BizCurrency pPharaikomisougaku) {
        pharaikomisougaku = pPharaikomisougaku;
        pharaikomisougakuValue = null;
        pharaikomisougakuType  = null;
    }

    transient private BigDecimal pharaikomisougakuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=PHARAIKOMISOUGAKU, nullable=true)
    protected BigDecimal getPharaikomisougakuValue() {
        if (pharaikomisougakuValue == null && pharaikomisougaku != null) {
            if (pharaikomisougaku.isOptional()) return null;
            return pharaikomisougaku.absolute();
        }
        return pharaikomisougakuValue;
    }

    protected void setPharaikomisougakuValue(BigDecimal value) {
        pharaikomisougakuValue = value;
        pharaikomisougaku = Optional.fromNullable(toCurrencyType(pharaikomisougakuType))
            .transform(bizCurrencyTransformer(getPharaikomisougakuValue()))
            .orNull();
    }

    transient private String pharaikomisougakuType = null;

    @Column(name=PHARAIKOMISOUGAKU + "$", nullable=true)
    protected String getPharaikomisougakuType() {
        if (pharaikomisougakuType == null && pharaikomisougaku != null) return pharaikomisougaku.getType().toString();
        if (pharaikomisougakuType == null && getPharaikomisougakuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'pharaikomisougaku$' should not be NULL."));
        }
        return pharaikomisougakuType;
    }

    protected void setPharaikomisougakuType(String type) {
        pharaikomisougakuType = type;
        pharaikomisougaku = Optional.fromNullable(toCurrencyType(pharaikomisougakuType))
            .transform(bizCurrencyTransformer(getPharaikomisougakuValue()))
            .orNull();
    }

    private BizCurrency sibouskei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSibouskei() {
        return sibouskei;
    }

    public void setSibouskei(BizCurrency pSibouskei) {
        sibouskei = pSibouskei;
        sibouskeiValue = null;
        sibouskeiType  = null;
    }

    transient private BigDecimal sibouskeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SIBOUSKEI, nullable=true)
    protected BigDecimal getSibouskeiValue() {
        if (sibouskeiValue == null && sibouskei != null) {
            if (sibouskei.isOptional()) return null;
            return sibouskei.absolute();
        }
        return sibouskeiValue;
    }

    protected void setSibouskeiValue(BigDecimal value) {
        sibouskeiValue = value;
        sibouskei = Optional.fromNullable(toCurrencyType(sibouskeiType))
            .transform(bizCurrencyTransformer(getSibouskeiValue()))
            .orNull();
    }

    transient private String sibouskeiType = null;

    @Column(name=SIBOUSKEI + "$", nullable=true)
    protected String getSibouskeiType() {
        if (sibouskeiType == null && sibouskei != null) return sibouskei.getType().toString();
        if (sibouskeiType == null && getSibouskeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sibouskei$' should not be NULL."));
        }
        return sibouskeiType;
    }

    protected void setSibouskeiType(String type) {
        sibouskeiType = type;
        sibouskei = Optional.fromNullable(toCurrencyType(sibouskeiType))
            .transform(bizCurrencyTransformer(getSibouskeiValue()))
            .orNull();
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenHT_MosKihonVrf.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_Hrkkeiro hrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenHT_MosKihonVrf.HRKKEIRO)
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private C_FstphrkkeiroKbn fstphrkkeirokbn;

    @Type(type="UserType_C_FstphrkkeiroKbn")
    @Column(name=GenHT_MosKihonVrf.FSTPHRKKEIROKBN)
    public C_FstphrkkeiroKbn getFstphrkkeirokbn() {
        return fstphrkkeirokbn;
    }

    public void setFstphrkkeirokbn(C_FstphrkkeiroKbn pFstphrkkeirokbn) {
        fstphrkkeirokbn = pFstphrkkeirokbn;
    }

    private Integer skjpjyuutoukaisuu;

    @Column(name=GenHT_MosKihonVrf.SKJPJYUUTOUKAISUU)
    public Integer getSkjpjyuutoukaisuu() {
        return skjpjyuutoukaisuu;
    }

    public void setSkjpjyuutoukaisuu(Integer pSkjpjyuutoukaisuu) {
        skjpjyuutoukaisuu = pSkjpjyuutoukaisuu;
    }

    private C_UmuKbn ikkatuyoupumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_MosKihonVrf.IKKATUYOUPUMUKBN)
    public C_UmuKbn getIkkatuyoupumukbn() {
        return ikkatuyoupumukbn;
    }

    public void setIkkatuyoupumukbn(C_UmuKbn pIkkatuyoupumukbn) {
        ikkatuyoupumukbn = pIkkatuyoupumukbn;
    }

    private Integer ikkatuyoupkaisuu;

    @Column(name=GenHT_MosKihonVrf.IKKATUYOUPKAISUU)
    public Integer getIkkatuyoupkaisuu() {
        return ikkatuyoupkaisuu;
    }

    public void setIkkatuyoupkaisuu(Integer pIkkatuyoupkaisuu) {
        ikkatuyoupkaisuu = pIkkatuyoupkaisuu;
    }

    private C_PWaribikitekiyouKbn pwaribikitekiyoukbn;

    @Type(type="UserType_C_PWaribikitekiyouKbn")
    @Column(name=GenHT_MosKihonVrf.PWARIBIKITEKIYOUKBN)
    public C_PWaribikitekiyouKbn getPwaribikitekiyoukbn() {
        return pwaribikitekiyoukbn;
    }

    public void setPwaribikitekiyoukbn(C_PWaribikitekiyouKbn pPwaribikitekiyoukbn) {
        pwaribikitekiyoukbn = pPwaribikitekiyoukbn;
    }

    private BizCurrency ikkatuyoupgkkeizokup;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getIkkatuyoupgkkeizokup() {
        return ikkatuyoupgkkeizokup;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIkkatuyoupgkkeizokup(BizCurrency pIkkatuyoupgkkeizokup) {
        ikkatuyoupgkkeizokup = pIkkatuyoupgkkeizokup;
        ikkatuyoupgkkeizokupValue = null;
        ikkatuyoupgkkeizokupType  = null;
    }

    transient private BigDecimal ikkatuyoupgkkeizokupValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=IKKATUYOUPGKKEIZOKUP, nullable=true)
    protected BigDecimal getIkkatuyoupgkkeizokupValue() {
        if (ikkatuyoupgkkeizokupValue == null && ikkatuyoupgkkeizokup != null) {
            if (ikkatuyoupgkkeizokup.isOptional()) return null;
            return ikkatuyoupgkkeizokup.absolute();
        }
        return ikkatuyoupgkkeizokupValue;
    }

    protected void setIkkatuyoupgkkeizokupValue(BigDecimal value) {
        ikkatuyoupgkkeizokupValue = value;
        ikkatuyoupgkkeizokup = Optional.fromNullable(toCurrencyType(ikkatuyoupgkkeizokupType))
            .transform(bizCurrencyTransformer(getIkkatuyoupgkkeizokupValue()))
            .orNull();
    }

    transient private String ikkatuyoupgkkeizokupType = null;

    @Column(name=IKKATUYOUPGKKEIZOKUP + "$", nullable=true)
    protected String getIkkatuyoupgkkeizokupType() {
        if (ikkatuyoupgkkeizokupType == null && ikkatuyoupgkkeizokup != null) return ikkatuyoupgkkeizokup.getType().toString();
        if (ikkatuyoupgkkeizokupType == null && getIkkatuyoupgkkeizokupValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'ikkatuyoupgkkeizokup$' should not be NULL."));
        }
        return ikkatuyoupgkkeizokupType;
    }

    protected void setIkkatuyoupgkkeizokupType(String type) {
        ikkatuyoupgkkeizokupType = type;
        ikkatuyoupgkkeizokup = Optional.fromNullable(toCurrencyType(ikkatuyoupgkkeizokupType))
            .transform(bizCurrencyTransformer(getIkkatuyoupgkkeizokupValue()))
            .orNull();
    }

    private BizDate keizokuptkykwsratekjymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_MosKihonVrf.KEIZOKUPTKYKWSRATEKJYMD)
    public BizDate getKeizokuptkykwsratekjymd() {
        return keizokuptkykwsratekjymd;
    }

    public void setKeizokuptkykwsratekjymd(BizDate pKeizokuptkykwsratekjymd) {
        keizokuptkykwsratekjymd = pKeizokuptkykwsratekjymd;
    }

    private BizNumber keizokuptkykwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenHT_MosKihonVrf.KEIZOKUPTKYKWSRATE)
    public BizNumber getKeizokuptkykwsrate() {
        return keizokuptkykwsrate;
    }

    public void setKeizokuptkykwsrate(BizNumber pKeizokuptkykwsrate) {
        keizokuptkykwsrate = pKeizokuptkykwsrate;
    }

    private C_DntryourituKbn dntryouritukbn;

    @Type(type="UserType_C_DntryourituKbn")
    @Column(name=GenHT_MosKihonVrf.DNTRYOURITUKBN)
    public C_DntryourituKbn getDntryouritukbn() {
        return dntryouritukbn;
    }

    public void setDntryouritukbn(C_DntryourituKbn pDntryouritukbn) {
        dntryouritukbn = pDntryouritukbn;
    }

    private C_Aplkahi aplkahikbn;

    @Type(type="UserType_C_Aplkahi")
    @Column(name=GenHT_MosKihonVrf.APLKAHIKBN)
    public C_Aplkahi getAplkahikbn() {
        return aplkahikbn;
    }

    public void setAplkahikbn(C_Aplkahi pAplkahikbn) {
        aplkahikbn = pAplkahikbn;
    }

    private C_1pclriyouKbn itipclriyoukbn;

    @Type(type="UserType_C_1pclriyouKbn")
    @Column(name=GenHT_MosKihonVrf.ITIPCLRIYOUKBN)
    public C_1pclriyouKbn getItipclriyoukbn() {
        return itipclriyoukbn;
    }

    public void setItipclriyoukbn(C_1pclriyouKbn pItipclriyoukbn) {
        itipclriyoukbn = pItipclriyoukbn;
    }

    private BizDate itiprsymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_MosKihonVrf.ITIPRSYMD)
    @ValidDate
    public BizDate getItiprsymd() {
        return itiprsymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setItiprsymd(BizDate pItiprsymd) {
        itiprsymd = pItiprsymd;
    }

    private String dntcd;

    @Column(name=GenHT_MosKihonVrf.DNTCD)
    @MaxLength(max=8)
    @AlphaDigit
    public String getDntcd() {
        return dntcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDntcd(String pDntcd) {
        dntcd = pDntcd;
    }

    private BizDate massiseiymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_MosKihonVrf.MASSISEIYMD)
    @ValidDate
    public BizDate getMassiseiymd() {
        return massiseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMassiseiymd(BizDate pMassiseiymd) {
        massiseiymd = pMassiseiymd;
    }

    private String hhknnmkn;

    @Column(name=GenHT_MosKihonVrf.HHKNNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getHhknnmkn() {
        return hhknnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkn(String pHhknnmkn) {
        hhknnmkn = pHhknnmkn;
    }

    private String hhknnmkj;

    @Column(name=GenHT_MosKihonVrf.HHKNNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknnmkj() {
        return hhknnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkj(String pHhknnmkj) {
        hhknnmkj = pHhknnmkj;
    }

    private C_KjkhukaKbn hhknnmkjkhukakbn;

    @Type(type="UserType_C_KjkhukaKbn")
    @Column(name=GenHT_MosKihonVrf.HHKNNMKJKHUKAKBN)
    public C_KjkhukaKbn getHhknnmkjkhukakbn() {
        return hhknnmkjkhukakbn;
    }

    public void setHhknnmkjkhukakbn(C_KjkhukaKbn pHhknnmkjkhukakbn) {
        hhknnmkjkhukakbn = pHhknnmkjkhukakbn;
    }

    private BizDate hhknseiymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_MosKihonVrf.HHKNSEIYMD)
    @ValidDate
    public BizDate getHhknseiymd() {
        return hhknseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknseiymd(BizDate pHhknseiymd) {
        hhknseiymd = pHhknseiymd;
    }

    private Integer hhknnen;

    @Column(name=GenHT_MosKihonVrf.HHKNNEN)
    @NaturalNumber
    public Integer getHhknnen() {
        return hhknnen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknnen(Integer pHhknnen) {
        hhknnen = pHhknnen;
    }

    private C_Hhknsei hhknsei;

    @Type(type="UserType_C_Hhknsei")
    @Column(name=GenHT_MosKihonVrf.HHKNSEI)
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private String hhknsykgycd;

    @Column(name=GenHT_MosKihonVrf.HHKNSYKGYCD)
    @MaxLength(max=3)
    @AlphaDigit
    @HostInvalidCharacter
    public String getHhknsykgycd() {
        return hhknsykgycd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknsykgycd(String pHhknsykgycd) {
        hhknsykgycd = pHhknsykgycd;
    }

    private C_NensyuuKbn hhknnensyuukbn;

    @Type(type="UserType_C_NensyuuKbn")
    @Column(name=GenHT_MosKihonVrf.HHKNNENSYUUKBN)
    public C_NensyuuKbn getHhknnensyuukbn() {
        return hhknnensyuukbn;
    }

    public void setHhknnensyuukbn(C_NensyuuKbn pHhknnensyuukbn) {
        hhknnensyuukbn = pHhknnensyuukbn;
    }

    private C_TsindousiteiKbn tsindousiteikbn;

    @Type(type="UserType_C_TsindousiteiKbn")
    @Column(name=GenHT_MosKihonVrf.TSINDOUSITEIKBN)
    public C_TsindousiteiKbn getTsindousiteikbn() {
        return tsindousiteikbn;
    }

    public void setTsindousiteikbn(C_TsindousiteiKbn pTsindousiteikbn) {
        tsindousiteikbn = pTsindousiteikbn;
    }

    private String hhknyno;

    @Column(name=GenHT_MosKihonVrf.HHKNYNO)
    @Length(length=7)
    @SingleByteStrings
    @Digit
    public String getHhknyno() {
        return hhknyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknyno(String pHhknyno) {
        hhknyno = pHhknyno;
    }

    private String hhknadr1kn;

    @Column(name=GenHT_MosKihonVrf.HHKNADR1KN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknadr1kn() {
        return hhknadr1kn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknadr1kn(String pHhknadr1kn) {
        hhknadr1kn = pHhknadr1kn;
    }

    private String hhknadr2kn;

    @Column(name=GenHT_MosKihonVrf.HHKNADR2KN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknadr2kn() {
        return hhknadr2kn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknadr2kn(String pHhknadr2kn) {
        hhknadr2kn = pHhknadr2kn;
    }

    private String hhknadr3kn;

    @Column(name=GenHT_MosKihonVrf.HHKNADR3KN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknadr3kn() {
        return hhknadr3kn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknadr3kn(String pHhknadr3kn) {
        hhknadr3kn = pHhknadr3kn;
    }

    private String hhknadr1kj;

    @Column(name=GenHT_MosKihonVrf.HHKNADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknadr1kj() {
        return hhknadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknadr1kj(String pHhknadr1kj) {
        hhknadr1kj = pHhknadr1kj;
    }

    private String hhknadr2kj;

    @Column(name=GenHT_MosKihonVrf.HHKNADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknadr2kj() {
        return hhknadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknadr2kj(String pHhknadr2kj) {
        hhknadr2kj = pHhknadr2kj;
    }

    private String hhknadr3kj;

    @Column(name=GenHT_MosKihonVrf.HHKNADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknadr3kj() {
        return hhknadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknadr3kj(String pHhknadr3kj) {
        hhknadr3kj = pHhknadr3kj;
    }

    private String hhkntelno;

    @Column(name=GenHT_MosKihonVrf.HHKNTELNO)
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    public String getHhkntelno() {
        return hhkntelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhkntelno(String pHhkntelno) {
        hhkntelno = pHhkntelno;
    }

    private String hhknkinmusakinm;

    @Column(name=GenHT_MosKihonVrf.HHKNKINMUSAKINM)
    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknkinmusakinm() {
        return hhknkinmusakinm;
    }

    public void setHhknkinmusakinm(String pHhknkinmusakinm) {
        hhknkinmusakinm = pHhknkinmusakinm;
    }

    private String kyknmkn;

    @Column(name=GenHT_MosKihonVrf.KYKNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKyknmkn() {
        return kyknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkn(String pKyknmkn) {
        kyknmkn = pKyknmkn;
    }

    private String kyknmkj;

    @Column(name=GenHT_MosKihonVrf.KYKNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getKyknmkj() {
        return kyknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkj(String pKyknmkj) {
        kyknmkj = pKyknmkj;
    }

    private C_KjkhukaKbn kyknmkjkhukakbn;

    @Type(type="UserType_C_KjkhukaKbn")
    @Column(name=GenHT_MosKihonVrf.KYKNMKJKHUKAKBN)
    public C_KjkhukaKbn getKyknmkjkhukakbn() {
        return kyknmkjkhukakbn;
    }

    public void setKyknmkjkhukakbn(C_KjkhukaKbn pKyknmkjkhukakbn) {
        kyknmkjkhukakbn = pKyknmkjkhukakbn;
    }

    private BizDate kykseiymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_MosKihonVrf.KYKSEIYMD)
    @ValidDate
    public BizDate getKykseiymd() {
        return kykseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykseiymd(BizDate pKykseiymd) {
        kykseiymd = pKykseiymd;
    }

    private Integer kyknen;

    @Column(name=GenHT_MosKihonVrf.KYKNEN)
    public Integer getKyknen() {
        return kyknen;
    }

    public void setKyknen(Integer pKyknen) {
        kyknen = pKyknen;
    }

    private C_Kyksei kyksei;

    @Type(type="UserType_C_Kyksei")
    @Column(name=GenHT_MosKihonVrf.KYKSEI)
    public C_Kyksei getKyksei() {
        return kyksei;
    }

    public void setKyksei(C_Kyksei pKyksei) {
        kyksei = pKyksei;
    }

    private C_Tdk kyktdk;

    @Type(type="UserType_C_Tdk")
    @Column(name=GenHT_MosKihonVrf.KYKTDK)
    public C_Tdk getKyktdk() {
        return kyktdk;
    }

    public void setKyktdk(C_Tdk pKyktdk) {
        kyktdk = pKyktdk;
    }

    private C_NensyuuKbn kyknensyuukbn;

    @Type(type="UserType_C_NensyuuKbn")
    @Column(name=GenHT_MosKihonVrf.KYKNENSYUUKBN)
    public C_NensyuuKbn getKyknensyuukbn() {
        return kyknensyuukbn;
    }

    public void setKyknensyuukbn(C_NensyuuKbn pKyknensyuukbn) {
        kyknensyuukbn = pKyknensyuukbn;
    }

    private String kykkinmusakinm;

    @Column(name=GenHT_MosKihonVrf.KYKKINMUSAKINM)
    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    public String getKykkinmusakinm() {
        return kykkinmusakinm;
    }

    public void setKykkinmusakinm(String pKykkinmusakinm) {
        kykkinmusakinm = pKykkinmusakinm;
    }

    private C_HjndaiykKbn hjndaiykkbn;

    @Type(type="UserType_C_HjndaiykKbn")
    @Column(name=GenHT_MosKihonVrf.HJNDAIYKKBN)
    public C_HjndaiykKbn getHjndaiykkbn() {
        return hjndaiykkbn;
    }

    public void setHjndaiykkbn(C_HjndaiykKbn pHjndaiykkbn) {
        hjndaiykkbn = pHjndaiykkbn;
    }

    private String hjndainmkn;

    @Column(name=GenHT_MosKihonVrf.HJNDAINMKN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getHjndainmkn() {
        return hjndainmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHjndainmkn(String pHjndainmkn) {
        hjndainmkn = pHjndainmkn;
    }

    private String hjndainmkj;

    @Column(name=GenHT_MosKihonVrf.HJNDAINMKJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getHjndainmkj() {
        return hjndainmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHjndainmkj(String pHjndainmkj) {
        hjndainmkj = pHjndainmkj;
    }

    private C_YakkanJyuryouKbn yakkanjyuryouhoukbn;

    @Type(type="UserType_C_YakkanJyuryouKbn")
    @Column(name=GenHT_MosKihonVrf.YAKKANJYURYOUHOUKBN)
    public C_YakkanJyuryouKbn getYakkanjyuryouhoukbn() {
        return yakkanjyuryouhoukbn;
    }

    public void setYakkanjyuryouhoukbn(C_YakkanJyuryouKbn pYakkanjyuryouhoukbn) {
        yakkanjyuryouhoukbn = pYakkanjyuryouhoukbn;
    }

    private String yakkanbunsyono;

    @Column(name=GenHT_MosKihonVrf.YAKKANBUNSYONO)
    public String getYakkanbunsyono() {
        return yakkanbunsyono;
    }

    public void setYakkanbunsyono(String pYakkanbunsyono) {
        yakkanbunsyono = pYakkanbunsyono;
    }

    private String siorino;

    @Column(name=GenHT_MosKihonVrf.SIORINO)
    public String getSiorino() {
        return siorino;
    }

    public void setSiorino(String pSiorino) {
        siorino = pSiorino;
    }

    private C_FatcasnsiKbn fatcasnsikbn;

    @Type(type="UserType_C_FatcasnsiKbn")
    @Column(name=GenHT_MosKihonVrf.FATCASNSIKBN)
    public C_FatcasnsiKbn getFatcasnsikbn() {
        return fatcasnsikbn;
    }

    public void setFatcasnsikbn(C_FatcasnsiKbn pFatcasnsikbn) {
        fatcasnsikbn = pFatcasnsikbn;
    }

    private C_BikkjnssinfoKbn bikkjnssinfokbn;

    @Type(type="UserType_C_BikkjnssinfoKbn")
    @Column(name=GenHT_MosKihonVrf.BIKKJNSSINFOKBN)
    public C_BikkjnssinfoKbn getBikkjnssinfokbn() {
        return bikkjnssinfokbn;
    }

    public void setBikkjnssinfokbn(C_BikkjnssinfoKbn pBikkjnssinfokbn) {
        bikkjnssinfokbn = pBikkjnssinfokbn;
    }

    private String bikknzsyno;

    @Column(name=GenHT_MosKihonVrf.BIKKNZSYNO)
    @MaxLength(max=9)
    @SingleByteStrings
    @AlphaDigit
    public String getBikknzsyno() {
        return bikknzsyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBikknzsyno(String pBikknzsyno) {
        bikknzsyno = pBikknzsyno;
    }

    private BizDate syomeiymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_MosKihonVrf.SYOMEIYMD)
    @ValidDate
    public BizDate getSyomeiymd() {
        return syomeiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyomeiymd(BizDate pSyomeiymd) {
        syomeiymd = pSyomeiymd;
    }

    private C_AeoisnsiKbn aeoisnsikbn;

    @Type(type="UserType_C_AeoisnsiKbn")
    @Column(name=GenHT_MosKihonVrf.AEOISNSIKBN)
    public C_AeoisnsiKbn getAeoisnsikbn() {
        return aeoisnsikbn;
    }

    public void setAeoisnsikbn(C_AeoisnsiKbn pAeoisnsikbn) {
        aeoisnsikbn = pAeoisnsikbn;
    }

    private String tsinyno;

    @Column(name=GenHT_MosKihonVrf.TSINYNO)
    @Length(length=7)
    @SingleByteStrings
    @Digit
    public String getTsinyno() {
        return tsinyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTsinyno(String pTsinyno) {
        tsinyno = pTsinyno;
    }

    private String tsinadr1kj;

    @Column(name=GenHT_MosKihonVrf.TSINADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr1kj() {
        return tsinadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr1kj(String pTsinadr1kj) {
        tsinadr1kj = pTsinadr1kj;
    }

    private String tsinadr2kj;

    @Column(name=GenHT_MosKihonVrf.TSINADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr2kj() {
        return tsinadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr2kj(String pTsinadr2kj) {
        tsinadr2kj = pTsinadr2kj;
    }

    private String tsinadr3kj;

    @Column(name=GenHT_MosKihonVrf.TSINADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr3kj() {
        return tsinadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr3kj(String pTsinadr3kj) {
        tsinadr3kj = pTsinadr3kj;
    }

    private String tsinadr1kn;

    @Column(name=GenHT_MosKihonVrf.TSINADR1KN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr1kn() {
        return tsinadr1kn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr1kn(String pTsinadr1kn) {
        tsinadr1kn = pTsinadr1kn;
    }

    private String tsinadr2kn;

    @Column(name=GenHT_MosKihonVrf.TSINADR2KN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr2kn() {
        return tsinadr2kn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr2kn(String pTsinadr2kn) {
        tsinadr2kn = pTsinadr2kn;
    }

    private String tsinadr3kn;

    @Column(name=GenHT_MosKihonVrf.TSINADR3KN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr3kn() {
        return tsinadr3kn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr3kn(String pTsinadr3kn) {
        tsinadr3kn = pTsinadr3kn;
    }

    private String tsintelno;

    @Column(name=GenHT_MosKihonVrf.TSINTELNO)
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    public String getTsintelno() {
        return tsintelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTsintelno(String pTsintelno) {
        tsintelno = pTsintelno;
    }

    private String dai2tsintelno;

    @Column(name=GenHT_MosKihonVrf.DAI2TSINTELNO)
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    public String getDai2tsintelno() {
        return dai2tsintelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDai2tsintelno(String pDai2tsintelno) {
        dai2tsintelno = pDai2tsintelno;
    }

    private String syoshadr1kj;

    @Column(name=GenHT_MosKihonVrf.SYOSHADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getSyoshadr1kj() {
        return syoshadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyoshadr1kj(String pSyoshadr1kj) {
        syoshadr1kj = pSyoshadr1kj;
    }

    private String syoshadr2kj;

    @Column(name=GenHT_MosKihonVrf.SYOSHADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getSyoshadr2kj() {
        return syoshadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyoshadr2kj(String pSyoshadr2kj) {
        syoshadr2kj = pSyoshadr2kj;
    }

    private String syoshadr3kj;

    @Column(name=GenHT_MosKihonVrf.SYOSHADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getSyoshadr3kj() {
        return syoshadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyoshadr3kj(String pSyoshadr3kj) {
        syoshadr3kj = pSyoshadr3kj;
    }

    private String syoshtelno;

    @Column(name=GenHT_MosKihonVrf.SYOSHTELNO)
    @MaxLength(max=14)
    @SingleByteStrings
    public String getSyoshtelno() {
        return syoshtelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoshtelno(String pSyoshtelno) {
        syoshtelno = pSyoshtelno;
    }

    private String syoshyno;

    @Column(name=GenHT_MosKihonVrf.SYOSHYNO)
    @Length(length=7)
    @Digit
    public String getSyoshyno() {
        return syoshyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoshyno(String pSyoshyno) {
        syoshyno = pSyoshyno;
    }

    private C_Tkhukaumu targettkhkkbn;

    @Type(type="UserType_C_Tkhukaumu")
    @Column(name=GenHT_MosKihonVrf.TARGETTKHKKBN)
    public C_Tkhukaumu getTargettkhkkbn() {
        return targettkhkkbn;
    }

    public void setTargettkhkkbn(C_Tkhukaumu pTargettkhkkbn) {
        targettkhkkbn = pTargettkhkkbn;
    }

    private C_TargetTkKbn targettkkbn;

    @Type(type="UserType_C_TargetTkKbn")
    @Column(name=GenHT_MosKihonVrf.TARGETTKKBN)
    public C_TargetTkKbn getTargettkkbn() {
        return targettkkbn;
    }

    public void setTargettkkbn(C_TargetTkKbn pTargettkkbn) {
        targettkkbn = pTargettkkbn;
    }

    private C_TargetTkMokuhyoutiKbn targettkmkhtkbn;

    @Type(type="UserType_C_TargetTkMokuhyoutiKbn")
    @Column(name=GenHT_MosKihonVrf.TARGETTKMKHTKBN)
    public C_TargetTkMokuhyoutiKbn getTargettkmkhtkbn() {
        return targettkmkhtkbn;
    }

    public void setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn pTargettkmkhtkbn) {
        targettkmkhtkbn = pTargettkmkhtkbn;
    }

    private C_Tkhukaumu nstkhkkbn;

    @Type(type="UserType_C_Tkhukaumu")
    @Column(name=GenHT_MosKihonVrf.NSTKHKKBN)
    public C_Tkhukaumu getNstkhkkbn() {
        return nstkhkkbn;
    }

    public void setNstkhkkbn(C_Tkhukaumu pNstkhkkbn) {
        nstkhkkbn = pNstkhkkbn;
    }

    private Integer nstkmnknsyu;

    @Column(name=GenHT_MosKihonVrf.NSTKMNKNSYU)
    public Integer getNstkmnknsyu() {
        return nstkmnknsyu;
    }

    public void setNstkmnknsyu(Integer pNstkmnknsyu) {
        nstkmnknsyu = pNstkmnknsyu;
    }

    private Integer nstkmnknkkn;

    @Column(name=GenHT_MosKihonVrf.NSTKMNKNKKN)
    @Range(min="0", max="99")
    public Integer getNstkmnknkkn() {
        return nstkmnknkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNstkmnknkkn(Integer pNstkmnknkkn) {
        nstkmnknkkn = pNstkmnknkkn;
    }

    private C_Nstknsyu nstksbnsyu;

    @Type(type="UserType_C_Nstknsyu")
    @Column(name=GenHT_MosKihonVrf.NSTKSBNSYU)
    public C_Nstknsyu getNstksbnsyu() {
        return nstksbnsyu;
    }

    public void setNstksbnsyu(C_Nstknsyu pNstksbnsyu) {
        nstksbnsyu = pNstksbnsyu;
    }

    private Integer nstksbnkkn;

    @Column(name=GenHT_MosKihonVrf.NSTKSBNKKN)
    @Range(min="0", max="99")
    public Integer getNstksbnkkn() {
        return nstksbnkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNstksbnkkn(Integer pNstksbnkkn) {
        nstksbnkkn = pNstksbnkkn;
    }

    private C_Tkhukaumu syksbyensitihsyutkhkkbn;

    @Type(type="UserType_C_Tkhukaumu")
    @Column(name=GenHT_MosKihonVrf.SYKSBYENSITIHSYUTKHKKBN)
    public C_Tkhukaumu getSyksbyensitihsyutkhkkbn() {
        return syksbyensitihsyutkhkkbn;
    }

    public void setSyksbyensitihsyutkhkkbn(C_Tkhukaumu pSyksbyensitihsyutkhkkbn) {
        syksbyensitihsyutkhkkbn = pSyksbyensitihsyutkhkkbn;
    }

    private C_Tkhukaumu jyudkaigomehrtkhkkbn;

    @Type(type="UserType_C_Tkhukaumu")
    @Column(name=GenHT_MosKihonVrf.JYUDKAIGOMEHRTKHKKBN)
    public C_Tkhukaumu getJyudkaigomehrtkhkkbn() {
        return jyudkaigomehrtkhkkbn;
    }

    public void setJyudkaigomehrtkhkkbn(C_Tkhukaumu pJyudkaigomehrtkhkkbn) {
        jyudkaigomehrtkhkkbn = pJyudkaigomehrtkhkkbn;
    }

    private C_Tkhukaumu kjnnkpzeitekitkhukakbn;

    @Type(type="UserType_C_Tkhukaumu")
    @Column(name=GenHT_MosKihonVrf.KJNNKPZEITEKITKHUKAKBN)
    public C_Tkhukaumu getKjnnkpzeitekitkhukakbn() {
        return kjnnkpzeitekitkhukakbn;
    }

    public void setKjnnkpzeitekitkhukakbn(C_Tkhukaumu pKjnnkpzeitekitkhukakbn) {
        kjnnkpzeitekitkhukakbn = pKjnnkpzeitekitkhukakbn;
    }

    private C_Tkhukaumu teikisiharaitkykhkkbn;

    @Type(type="UserType_C_Tkhukaumu")
    @Column(name=GenHT_MosKihonVrf.TEIKISIHARAITKYKHKKBN)
    public C_Tkhukaumu getTeikisiharaitkykhkkbn() {
        return teikisiharaitkykhkkbn;
    }

    public void setTeikisiharaitkykhkkbn(C_Tkhukaumu pTeikisiharaitkykhkkbn) {
        teikisiharaitkykhkkbn = pTeikisiharaitkykhkkbn;
    }

    private String saihocd;

    @Column(name=GenHT_MosKihonVrf.SAIHOCD)
    public String getSaihocd() {
        return saihocd;
    }

    public void setSaihocd(String pSaihocd) {
        saihocd = pSaihocd;
    }

    private C_StknsetKbn stknsetkbn;

    @Type(type="UserType_C_StknsetKbn")
    @Column(name=GenHT_MosKihonVrf.STKNSETKBN)
    public C_StknsetKbn getStknsetkbn() {
        return stknsetkbn;
    }

    public void setStknsetkbn(C_StknsetKbn pStknsetkbn) {
        stknsetkbn = pStknsetkbn;
    }

    private Integer sbuktnin;

    @Column(name=GenHT_MosKihonVrf.SBUKTNIN)
    @Range(min="0", max="99")
    public Integer getSbuktnin() {
        return sbuktnin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktnin(Integer pSbuktnin) {
        sbuktnin = pSbuktnin;
    }

    private C_HonninkakuninSyoruiKbn kykhonninkakninsyoruikbn;

    @Type(type="UserType_C_HonninkakuninSyoruiKbn")
    @Column(name=GenHT_MosKihonVrf.KYKHONNINKAKNINSYORUIKBN)
    public C_HonninkakuninSyoruiKbn getKykhonninkakninsyoruikbn() {
        return kykhonninkakninsyoruikbn;
    }

    public void setKykhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn pKykhonninkakninsyoruikbn) {
        kykhonninkakninsyoruikbn = pKykhonninkakninsyoruikbn;
    }

    private C_HonninkakuninSyoruiKbn skskknhonninkakninsyoruikbn;

    @Type(type="UserType_C_HonninkakuninSyoruiKbn")
    @Column(name=GenHT_MosKihonVrf.SKSKKNHONNINKAKNINSYORUIKBN)
    public C_HonninkakuninSyoruiKbn getSkskknhonninkakninsyoruikbn() {
        return skskknhonninkakninsyoruikbn;
    }

    public void setSkskknhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn pSkskknhonninkakninsyoruikbn) {
        skskknhonninkakninsyoruikbn = pSkskknhonninkakninsyoruikbn;
    }

    private C_KoureiKzkSetumeiHouKbn koureikzksetumeihoukbn;

    @Type(type="UserType_C_KoureiKzkSetumeiHouKbn")
    @Column(name=GenHT_MosKihonVrf.KOUREIKZKSETUMEIHOUKBN)
    public C_KoureiKzkSetumeiHouKbn getKoureikzksetumeihoukbn() {
        return koureikzksetumeihoukbn;
    }

    public void setKoureikzksetumeihoukbn(C_KoureiKzkSetumeiHouKbn pKoureikzksetumeihoukbn) {
        koureikzksetumeihoukbn = pKoureikzksetumeihoukbn;
    }

    private C_KoureiMndnHukusuukaiKbn koureimndnhukusuukaikbn;

    @Type(type="UserType_C_KoureiMndnHukusuukaiKbn")
    @Column(name=GenHT_MosKihonVrf.KOUREIMNDNHUKUSUUKAIKBN)
    public C_KoureiMndnHukusuukaiKbn getKoureimndnhukusuukaikbn() {
        return koureimndnhukusuukaikbn;
    }

    public void setKoureimndnhukusuukaikbn(C_KoureiMndnHukusuukaiKbn pKoureimndnhukusuukaikbn) {
        koureimndnhukusuukaikbn = pKoureimndnhukusuukaikbn;
    }

    private C_KoureiTratkisyaIgiDskKbn koureitratkisyaigidskkbn;

    @Type(type="UserType_C_KoureiTratkisyaIgiDskKbn")
    @Column(name=GenHT_MosKihonVrf.KOUREITRATKISYAIGIDSKKBN)
    public C_KoureiTratkisyaIgiDskKbn getKoureitratkisyaigidskkbn() {
        return koureitratkisyaigidskkbn;
    }

    public void setKoureitratkisyaigidskkbn(C_KoureiTratkisyaIgiDskKbn pKoureitratkisyaigidskkbn) {
        koureitratkisyaigidskkbn = pKoureitratkisyaigidskkbn;
    }

    private C_UmuKbn daihituumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_MosKihonVrf.DAIHITUUMUKBN)
    public C_UmuKbn getDaihituumukbn() {
        return daihituumukbn;
    }

    public void setDaihituumukbn(C_UmuKbn pDaihituumukbn) {
        daihituumukbn = pDaihituumukbn;
    }

    private C_UmuKbn syotnshuyoupostumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_MosKihonVrf.SYOTNSHUYOUPOSTUMUKBN)
    public C_UmuKbn getSyotnshuyoupostumukbn() {
        return syotnshuyoupostumukbn;
    }

    public void setSyotnshuyoupostumukbn(C_UmuKbn pSyotnshuyoupostumukbn) {
        syotnshuyoupostumukbn = pSyotnshuyoupostumukbn;
    }

    private String uktkid;

    @Column(name=GenHT_MosKihonVrf.UKTKID)
    @Length(length=11)
    @AlphaDigit
    @HostInvalidCharacter
    public String getUktkid() {
        return uktkid;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktkid(String pUktkid) {
        uktkid = pUktkid;
    }

    private C_Boskykjyoutai boskykjyoutai;

    @Type(type="UserType_C_Boskykjyoutai")
    @Column(name=GenHT_MosKihonVrf.BOSKYKJYOUTAI)
    public C_Boskykjyoutai getBoskykjyoutai() {
        return boskykjyoutai;
    }

    public void setBoskykjyoutai(C_Boskykjyoutai pBoskykjyoutai) {
        boskykjyoutai = pBoskykjyoutai;
    }

    private C_Tkkinyukkntkrumu tkkinyukkntkrumu;

    @Type(type="UserType_C_Tkkinyukkntkrumu")
    @Column(name=GenHT_MosKihonVrf.TKKINYUKKNTKRUMU)
    public C_Tkkinyukkntkrumu getTkkinyukkntkrumu() {
        return tkkinyukkntkrumu;
    }

    public void setTkkinyukkntkrumu(C_Tkkinyukkntkrumu pTkkinyukkntkrumu) {
        tkkinyukkntkrumu = pTkkinyukkntkrumu;
    }

    private C_DirectServiceMosKbn drctservicemoskbn;

    @Type(type="UserType_C_DirectServiceMosKbn")
    @Column(name=GenHT_MosKihonVrf.DRCTSERVICEMOSKBN)
    public C_DirectServiceMosKbn getDrctservicemoskbn() {
        return drctservicemoskbn;
    }

    public void setDrctservicemoskbn(C_DirectServiceMosKbn pDrctservicemoskbn) {
        drctservicemoskbn = pDrctservicemoskbn;
    }

    private String dskokno;

    @Column(name=GenHT_MosKihonVrf.DSKOKNO)
    public String getDskokno() {
        return dskokno;
    }

    public void setDskokno(String pDskokno) {
        dskokno = pDskokno;
    }

    private String dsmailaddress;

    @Column(name=GenHT_MosKihonVrf.DSMAILADDRESS)
    @MaxLength(max=100)
    @SingleByteStrings
    @Pattern(message="{pattern.MailAddress.message}", regex="^[\\w!#$%&'*+/=?^_{}\\\\|~-][\\w!#$%&'*+/=?^_{}\\\\|~\\.-]{0,63}@([\\w][\\w-]*\\.)+[\\w][\\w-]*$")
    public String getDsmailaddress() {
        return dsmailaddress;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDsmailaddress(String pDsmailaddress) {
        dsmailaddress = pDsmailaddress;
    }

    private C_YnkHrkmgkAnniTuutiKbn ynkhrkmgkannituutikbn;

    @Type(type="UserType_C_YnkHrkmgkAnniTuutiKbn")
    @Column(name=GenHT_MosKihonVrf.YNKHRKMGKANNITUUTIKBN)
    public C_YnkHrkmgkAnniTuutiKbn getYnkhrkmgkannituutikbn() {
        return ynkhrkmgkannituutikbn;
    }

    public void setYnkhrkmgkannituutikbn(C_YnkHrkmgkAnniTuutiKbn pYnkhrkmgkannituutikbn) {
        ynkhrkmgkannituutikbn = pYnkhrkmgkannituutikbn;
    }

    private String tokuteitrhkansyono;

    @Column(name=GenHT_MosKihonVrf.TOKUTEITRHKANSYONO)
    public String getTokuteitrhkansyono() {
        return tokuteitrhkansyono;
    }

    public void setTokuteitrhkansyono(String pTokuteitrhkansyono) {
        tokuteitrhkansyono = pTokuteitrhkansyono;
    }

    private C_DsSyomenTtdkHyouji pplessrenjidssymenttdkhyj;

    @Type(type="UserType_C_DsSyomenTtdkHyouji")
    @Column(name=GenHT_MosKihonVrf.PPLESSRENJIDSSYMENTTDKHYJ)
    public C_DsSyomenTtdkHyouji getPplessrenjidssymenttdkhyj() {
        return pplessrenjidssymenttdkhyj;
    }

    public void setPplessrenjidssymenttdkhyj(C_DsSyomenTtdkHyouji pPplessrenjidssymenttdkhyj) {
        pplessrenjidssymenttdkhyj = pPplessrenjidssymenttdkhyj;
    }

    private C_PplessrendoukouhurikousouKbn pplsrendoukouhurikousoukbn;

    @Type(type="UserType_C_PplessrendoukouhurikousouKbn")
    @Column(name=GenHT_MosKihonVrf.PPLSRENDOUKOUHURIKOUSOUKBN)
    public C_PplessrendoukouhurikousouKbn getPplsrendoukouhurikousoukbn() {
        return pplsrendoukouhurikousoukbn;
    }

    public void setPplsrendoukouhurikousoukbn(C_PplessrendoukouhurikousouKbn pPplsrendoukouhurikousoukbn) {
        pplsrendoukouhurikousoukbn = pPplsrendoukouhurikousoukbn;
    }

    private C_PplessrendoucreditkousouKbn pplessrendoucreditkousoukbn;

    @Type(type="UserType_C_PplessrendoucreditkousouKbn")
    @Column(name=GenHT_MosKihonVrf.PPLESSRENDOUCREDITKOUSOUKBN)
    public C_PplessrendoucreditkousouKbn getPplessrendoucreditkousoukbn() {
        return pplessrendoucreditkousoukbn;
    }

    public void setPplessrendoucreditkousoukbn(C_PplessrendoucreditkousouKbn pPplessrendoucreditkousoukbn) {
        pplessrendoucreditkousoukbn = pPplessrendoucreditkousoukbn;
    }

    private C_UmuKbn hnsstjmmouumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_MosKihonVrf.HNSSTJMMOUUMUKBN)
    public C_UmuKbn getHnsstjmmouumukbn() {
        return hnsstjmmouumukbn;
    }

    public void setHnsstjmmouumukbn(C_UmuKbn pHnsstjmmouumukbn) {
        hnsstjmmouumukbn = pHnsstjmmouumukbn;
    }

    private C_UmuKbn kjmeigihkhunouumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_MosKihonVrf.KJMEIGIHKHUNOUUMUKBN)
    public C_UmuKbn getKjmeigihkhunouumukbn() {
        return kjmeigihkhunouumukbn;
    }

    public void setKjmeigihkhunouumukbn(C_UmuKbn pKjmeigihkhunouumukbn) {
        kjmeigihkhunouumukbn = pKjmeigihkhunouumukbn;
    }

    private C_UmuKbn tsryhshrkykumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_MosKihonVrf.TSRYHSHRKYKUMUKBN)
    public C_UmuKbn getTsryhshrkykumukbn() {
        return tsryhshrkykumukbn;
    }

    public void setTsryhshrkykumukbn(C_UmuKbn pTsryhshrkykumukbn) {
        tsryhshrkykumukbn = pTsryhshrkykumukbn;
    }

    private C_UmuKbn syosisyatodokeumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_MosKihonVrf.SYOSISYATODOKEUMUKBN)
    public C_UmuKbn getSyosisyatodokeumukbn() {
        return syosisyatodokeumukbn;
    }

    public void setSyosisyatodokeumukbn(C_UmuKbn pSyosisyatodokeumukbn) {
        syosisyatodokeumukbn = pSyosisyatodokeumukbn;
    }

    private C_UmuKbn kakukisyouryakukbumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_MosKihonVrf.KAKUKISYOURYAKUKBUMUKBN)
    public C_UmuKbn getKakukisyouryakukbumukbn() {
        return kakukisyouryakukbumukbn;
    }

    public void setKakukisyouryakukbumukbn(C_UmuKbn pKakukisyouryakukbumukbn) {
        kakukisyouryakukbumukbn = pKakukisyouryakukbumukbn;
    }

    private C_UmuKbn seiymdmosseitouumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_MosKihonVrf.SEIYMDMOSSEITOUUMUKBN)
    public C_UmuKbn getSeiymdmosseitouumukbn() {
        return seiymdmosseitouumukbn;
    }

    public void setSeiymdmosseitouumukbn(C_UmuKbn pSeiymdmosseitouumukbn) {
        seiymdmosseitouumukbn = pSeiymdmosseitouumukbn;
    }

    private C_UmuKbn ikokakninsyotokkijkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_MosKihonVrf.IKOKAKNINSYOTOKKIJKUMU)
    public C_UmuKbn getIkokakninsyotokkijkumu() {
        return ikokakninsyotokkijkumu;
    }

    public void setIkokakninsyotokkijkumu(C_UmuKbn pIkokakninsyotokkijkumu) {
        ikokakninsyotokkijkumu = pIkokakninsyotokkijkumu;
    }

    private C_UmuKbn trtkhoukokusyotokkijkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_MosKihonVrf.TRTKHOUKOKUSYOTOKKIJKUMU)
    public C_UmuKbn getTrtkhoukokusyotokkijkumu() {
        return trtkhoukokusyotokkijkumu;
    }

    public void setTrtkhoukokusyotokkijkumu(C_UmuKbn pTrtkhoukokusyotokkijkumu) {
        trtkhoukokusyotokkijkumu = pTrtkhoukokusyotokkijkumu;
    }

    private C_UmuKbn hnnkakninhskjikouumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_MosKihonVrf.HNNKAKNINHSKJIKOUUMUKBN)
    public C_UmuKbn getHnnkakninhskjikouumukbn() {
        return hnnkakninhskjikouumukbn;
    }

    public void setHnnkakninhskjikouumukbn(C_UmuKbn pHnnkakninhskjikouumukbn) {
        hnnkakninhskjikouumukbn = pHnnkakninhskjikouumukbn;
    }

    private C_UmuKbn hnnkakninhsktkjikouumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_MosKihonVrf.HNNKAKNINHSKTKJIKOUUMUKBN)
    public C_UmuKbn getHnnkakninhsktkjikouumukbn() {
        return hnnkakninhsktkjikouumukbn;
    }

    public void setHnnkakninhsktkjikouumukbn(C_UmuKbn pHnnkakninhsktkjikouumukbn) {
        hnnkakninhsktkjikouumukbn = pHnnkakninhsktkjikouumukbn;
    }

    private C_UmuKbn skskakninhsktkjikouumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenHT_MosKihonVrf.SKSKAKNINHSKTKJIKOUUMUKBN)
    public C_UmuKbn getSkskakninhsktkjikouumukbn() {
        return skskakninhsktkjikouumukbn;
    }

    public void setSkskakninhsktkjikouumukbn(C_UmuKbn pSkskakninhsktkjikouumukbn) {
        skskakninhsktkjikouumukbn = pSkskakninhsktkjikouumukbn;
    }

    private C_BlnktkumuKbn kouseiinkyktkjkumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenHT_MosKihonVrf.KOUSEIINKYKTKJKUMUKBN)
    public C_BlnktkumuKbn getKouseiinkyktkjkumukbn() {
        return kouseiinkyktkjkumukbn;
    }

    public void setKouseiinkyktkjkumukbn(C_BlnktkumuKbn pKouseiinkyktkjkumukbn) {
        kouseiinkyktkjkumukbn = pKouseiinkyktkjkumukbn;
    }

    private String koukankykkinmusakinm;

    @Column(name=GenHT_MosKihonVrf.KOUKANKYKKINMUSAKINM)
    @MaxLength(max=35)
    @MultiByteStrings
    @InvalidCharacter
    public String getKoukankykkinmusakinm() {
        return koukankykkinmusakinm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKoukankykkinmusakinm(String pKoukankykkinmusakinm) {
        koukankykkinmusakinm = pKoukankykkinmusakinm;
    }

    private String koukankyksyokumunaiyou;

    @Column(name=GenHT_MosKihonVrf.KOUKANKYKSYOKUMUNAIYOU)
    @MaxLength(max=35)
    @MultiByteStrings
    @InvalidCharacter
    public String getKoukankyksyokumunaiyou() {
        return koukankyksyokumunaiyou;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKoukankyksyokumunaiyou(String pKoukankyksyokumunaiyou) {
        koukankyksyokumunaiyou = pKoukankyksyokumunaiyou;
    }

    private C_BlnktkumuKbn koukankyktkjkumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenHT_MosKihonVrf.KOUKANKYKTKJKUMUKBN)
    public C_BlnktkumuKbn getKoukankyktkjkumukbn() {
        return koukankyktkjkumukbn;
    }

    public void setKoukankyktkjkumukbn(C_BlnktkumuKbn pKoukankyktkjkumukbn) {
        koukankyktkjkumukbn = pKoukankyktkjkumukbn;
    }

    private String khnchkcmnt;

    @Column(name=GenHT_MosKihonVrf.KHNCHKCMNT)
    @MultiByteStringsReturnable
    @InvalidCharacter
    @ValidTextArea(length=40, rows=10)
    public String getKhnchkcmnt() {
        return khnchkcmnt;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKhnchkcmnt(String pKhnchkcmnt) {
        khnchkcmnt = pKhnchkcmnt;
    }

    private C_MobilebosyuuKbn mobilebosyuukbn;

    @Type(type="UserType_C_MobilebosyuuKbn")
    @Column(name=GenHT_MosKihonVrf.MOBILEBOSYUUKBN)
    public C_MobilebosyuuKbn getMobilebosyuukbn() {
        return mobilebosyuukbn;
    }

    public void setMobilebosyuukbn(C_MobilebosyuuKbn pMobilebosyuukbn) {
        mobilebosyuukbn = pMobilebosyuukbn;
    }

    private String jimuyoucd;

    @Column(name=GenHT_MosKihonVrf.JIMUYOUCD)
    @Length(length=3)
    @SingleByteStrings
    @AlphaDigit
    public String getJimuyoucd() {
        return jimuyoucd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setJimuyoucd(String pJimuyoucd) {
        jimuyoucd = pJimuyoucd;
    }

    private C_TumitatekinHaibunWariKbn teirituhaibunwarikbn;

    @Type(type="UserType_C_TumitatekinHaibunWariKbn")
    @Column(name=GenHT_MosKihonVrf.TEIRITUHAIBUNWARIKBN)
    public C_TumitatekinHaibunWariKbn getTeirituhaibunwarikbn() {
        return teirituhaibunwarikbn;
    }

    public void setTeirituhaibunwarikbn(C_TumitatekinHaibunWariKbn pTeirituhaibunwarikbn) {
        teirituhaibunwarikbn = pTeirituhaibunwarikbn;
    }

    private C_Sisuukbn sisuukbn;

    @Type(type="UserType_C_Sisuukbn")
    @Column(name=GenHT_MosKihonVrf.SISUUKBN)
    public C_Sisuukbn getSisuukbn() {
        return sisuukbn;
    }

    public void setSisuukbn(C_Sisuukbn pSisuukbn) {
        sisuukbn = pSisuukbn;
    }

    private C_TumitatekinHaibunWariKbn sisuuhaibunwarikbn;

    @Type(type="UserType_C_TumitatekinHaibunWariKbn")
    @Column(name=GenHT_MosKihonVrf.SISUUHAIBUNWARIKBN)
    public C_TumitatekinHaibunWariKbn getSisuuhaibunwarikbn() {
        return sisuuhaibunwarikbn;
    }

    public void setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn pSisuuhaibunwarikbn) {
        sisuuhaibunwarikbn = pSisuuhaibunwarikbn;
    }

    private C_TrhkjiKakKbn trhkjikakkbn;

    @Type(type="UserType_C_TrhkjiKakKbn")
    @Column(name=GenHT_MosKihonVrf.TRHKJIKAKKBN)
    public C_TrhkjiKakKbn getTrhkjikakkbn() {
        return trhkjikakkbn;
    }

    public void setTrhkjikakkbn(C_TrhkjiKakKbn pTrhkjikakkbn) {
        trhkjikakkbn = pTrhkjikakkbn;
    }

    private C_KoureisyaTaiouKbn koureitaioukbn;

    @Type(type="UserType_C_KoureisyaTaiouKbn")
    @Column(name=GenHT_MosKihonVrf.KOUREITAIOUKBN)
    public C_KoureisyaTaiouKbn getKoureitaioukbn() {
        return koureitaioukbn;
    }

    public void setKoureitaioukbn(C_KoureisyaTaiouKbn pKoureitaioukbn) {
        koureitaioukbn = pKoureitaioukbn;
    }

    private C_Tuukasyu kyktuukasyu2;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHT_MosKihonVrf.KYKTUUKASYU2)
    public C_Tuukasyu getKyktuukasyu2() {
        return kyktuukasyu2;
    }

    public void setKyktuukasyu2(C_Tuukasyu pKyktuukasyu2) {
        kyktuukasyu2 = pKyktuukasyu2;
    }

    private C_Tuukasyu hrktuukasyu2;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHT_MosKihonVrf.HRKTUUKASYU2)
    public C_Tuukasyu getHrktuukasyu2() {
        return hrktuukasyu2;
    }

    public void setHrktuukasyu2(C_Tuukasyu pHrktuukasyu2) {
        hrktuukasyu2 = pHrktuukasyu2;
    }

    private BizCurrency mosheijyunp2;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getMosheijyunp2() {
        return mosheijyunp2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosheijyunp2(BizCurrency pMosheijyunp2) {
        mosheijyunp2 = pMosheijyunp2;
        mosheijyunp2Value = null;
        mosheijyunp2Type  = null;
    }

    transient private BigDecimal mosheijyunp2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MOSHEIJYUNP2, nullable=true)
    protected BigDecimal getMosheijyunp2Value() {
        if (mosheijyunp2Value == null && mosheijyunp2 != null) {
            if (mosheijyunp2.isOptional()) return null;
            return mosheijyunp2.absolute();
        }
        return mosheijyunp2Value;
    }

    protected void setMosheijyunp2Value(BigDecimal value) {
        mosheijyunp2Value = value;
        mosheijyunp2 = Optional.fromNullable(toCurrencyType(mosheijyunp2Type))
            .transform(bizCurrencyTransformer(getMosheijyunp2Value()))
            .orNull();
    }

    transient private String mosheijyunp2Type = null;

    @Column(name=MOSHEIJYUNP2 + "$", nullable=true)
    protected String getMosheijyunp2Type() {
        if (mosheijyunp2Type == null && mosheijyunp2 != null) return mosheijyunp2.getType().toString();
        if (mosheijyunp2Type == null && getMosheijyunp2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mosheijyunp2$' should not be NULL."));
        }
        return mosheijyunp2Type;
    }

    protected void setMosheijyunp2Type(String type) {
        mosheijyunp2Type = type;
        mosheijyunp2 = Optional.fromNullable(toCurrencyType(mosheijyunp2Type))
            .transform(bizCurrencyTransformer(getMosheijyunp2Value()))
            .orNull();
    }

    private BizCurrency mosikkatup2;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getMosikkatup2() {
        return mosikkatup2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosikkatup2(BizCurrency pMosikkatup2) {
        mosikkatup2 = pMosikkatup2;
        mosikkatup2Value = null;
        mosikkatup2Type  = null;
    }

    transient private BigDecimal mosikkatup2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MOSIKKATUP2, nullable=true)
    protected BigDecimal getMosikkatup2Value() {
        if (mosikkatup2Value == null && mosikkatup2 != null) {
            if (mosikkatup2.isOptional()) return null;
            return mosikkatup2.absolute();
        }
        return mosikkatup2Value;
    }

    protected void setMosikkatup2Value(BigDecimal value) {
        mosikkatup2Value = value;
        mosikkatup2 = Optional.fromNullable(toCurrencyType(mosikkatup2Type))
            .transform(bizCurrencyTransformer(getMosikkatup2Value()))
            .orNull();
    }

    transient private String mosikkatup2Type = null;

    @Column(name=MOSIKKATUP2 + "$", nullable=true)
    protected String getMosikkatup2Type() {
        if (mosikkatup2Type == null && mosikkatup2 != null) return mosikkatup2.getType().toString();
        if (mosikkatup2Type == null && getMosikkatup2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mosikkatup2$' should not be NULL."));
        }
        return mosikkatup2Type;
    }

    protected void setMosikkatup2Type(String type) {
        mosikkatup2Type = type;
        mosikkatup2 = Optional.fromNullable(toCurrencyType(mosikkatup2Type))
            .transform(bizCurrencyTransformer(getMosikkatup2Value()))
            .orNull();
    }

    private BizCurrency moszennoupsyokaiari2;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getMoszennoupsyokaiari2() {
        return moszennoupsyokaiari2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMoszennoupsyokaiari2(BizCurrency pMoszennoupsyokaiari2) {
        moszennoupsyokaiari2 = pMoszennoupsyokaiari2;
        moszennoupsyokaiari2Value = null;
        moszennoupsyokaiari2Type  = null;
    }

    transient private BigDecimal moszennoupsyokaiari2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=MOSZENNOUPSYOKAIARI2, nullable=true)
    protected BigDecimal getMoszennoupsyokaiari2Value() {
        if (moszennoupsyokaiari2Value == null && moszennoupsyokaiari2 != null) {
            if (moszennoupsyokaiari2.isOptional()) return null;
            return moszennoupsyokaiari2.absolute();
        }
        return moszennoupsyokaiari2Value;
    }

    protected void setMoszennoupsyokaiari2Value(BigDecimal value) {
        moszennoupsyokaiari2Value = value;
        moszennoupsyokaiari2 = Optional.fromNullable(toCurrencyType(moszennoupsyokaiari2Type))
            .transform(bizCurrencyTransformer(getMoszennoupsyokaiari2Value()))
            .orNull();
    }

    transient private String moszennoupsyokaiari2Type = null;

    @Column(name=MOSZENNOUPSYOKAIARI2 + "$", nullable=true)
    protected String getMoszennoupsyokaiari2Type() {
        if (moszennoupsyokaiari2Type == null && moszennoupsyokaiari2 != null) return moszennoupsyokaiari2.getType().toString();
        if (moszennoupsyokaiari2Type == null && getMoszennoupsyokaiari2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'moszennoupsyokaiari2$' should not be NULL."));
        }
        return moszennoupsyokaiari2Type;
    }

    protected void setMoszennoupsyokaiari2Type(String type) {
        moszennoupsyokaiari2Type = type;
        moszennoupsyokaiari2 = Optional.fromNullable(toCurrencyType(moszennoupsyokaiari2Type))
            .transform(bizCurrencyTransformer(getMoszennoupsyokaiari2Value()))
            .orNull();
    }

    private C_Tkhukaumu kjnnkpzeitekitkhukakbn2;

    @Type(type="UserType_C_Tkhukaumu")
    @Column(name=GenHT_MosKihonVrf.KJNNKPZEITEKITKHUKAKBN2)
    public C_Tkhukaumu getKjnnkpzeitekitkhukakbn2() {
        return kjnnkpzeitekitkhukakbn2;
    }

    public void setKjnnkpzeitekitkhukakbn2(C_Tkhukaumu pKjnnkpzeitekitkhukakbn2) {
        kjnnkpzeitekitkhukakbn2 = pKjnnkpzeitekitkhukakbn2;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_MosKihonVrf.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_MosKihonVrf.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}