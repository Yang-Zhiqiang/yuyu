package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_BosKihon;
import yuyu.def.db.mapping.GenHT_BosKihon;
import yuyu.def.db.meta.GenQHT_BosKihon;
import yuyu.def.db.meta.QHT_BosKihon;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 募集基本テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_BosKihon}</td><td colspan="3">募集基本テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>aitemosno</td><td>相手申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>doujikaiyakusyono</td><td>同時解約証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sekno</td><td>設計書番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mosuketukekbn</td><td>申込受付区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MosUketukeKbn C_MosUketukeKbn}</td></tr>
 *  <tr><td>mosymd</td><td>申込日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>mossakuseiymd</td><td>申込書作成日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>pplessmosukeymd</td><td>ペーパーレス申込書受付日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>pykkigenymd</td><td>保険料有効期限年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kktymd</td><td>告知日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>moscalckijyunymd</td><td>申込書計算基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kykymdtkrumu</td><td>契約日特例有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kykymdtkrumu C_Kykymdtkrumu}</td></tr>
 *  <tr><td>skykymd</td><td>指定契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kykkbn</td><td>契約者区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KykKbn C_KykKbn}</td></tr>
 *  <tr><td>hhknnmkn</td><td>被保険者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnmkj</td><td>被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnmkjkhukakbn</td><td>被保険者名漢字化不可区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KjkhukaKbn C_KjkhukaKbn}</td></tr>
 *  <tr><td>hhknseiymd</td><td>被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hhknnen</td><td>被保険者年齢</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hhknsei</td><td>被保険者性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hhknsei C_Hhknsei}</td></tr>
 *  <tr><td>hhknsykgycd</td><td>被保険者職業コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnensyuukbn</td><td>被保険者年収区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NensyuuKbn C_NensyuuKbn}</td></tr>
 *  <tr><td>tsindousiteikbn</td><td>通信先同一指定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TsindousiteiKbn C_TsindousiteiKbn}</td></tr>
 *  <tr><td>hhknyno</td><td>被保険者郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknadr1kj</td><td>被保険者住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknadr2kj</td><td>被保険者住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknadr3kj</td><td>被保険者住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhkntelno</td><td>被保険者電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknkinmusakinm</td><td>被保険者勤務先名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknmkn</td><td>契約者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknmkj</td><td>契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknmkjkhukakbn</td><td>契約者名漢字化不可区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KjkhukaKbn C_KjkhukaKbn}</td></tr>
 *  <tr><td>kykseiymd</td><td>契約者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kyknen</td><td>契約者年齢</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kyksei</td><td>契約者性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kyksei C_Kyksei}</td></tr>
 *  <tr><td>kyktdk</td><td>契約者続柄</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tdk C_Tdk}</td></tr>
 *  <tr><td>kyknensyuukbn</td><td>契約者年収区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NensyuuKbn C_NensyuuKbn}</td></tr>
 *  <tr><td>kykkinmusakinm</td><td>契約者勤務先名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hjndaiykkbn</td><td>法人代表者役職区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HjndaiykKbn C_HjndaiykKbn}</td></tr>
 *  <tr><td>hjndainmkn</td><td>法人代表者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hjndainmkj</td><td>法人代表者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinyno</td><td>通信先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr1kj</td><td>通信先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr2kj</td><td>通信先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr3kj</td><td>通信先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsintelno</td><td>通信先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dai2tsintelno</td><td>第２通信先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yakkanjyuryouhoukbn</td><td>約款受領方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YakkanJyuryouKbn C_YakkanJyuryouKbn}</td></tr>
 *  <tr><td>yakkanbunsyono</td><td>約款文書番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>fatcasnsikbn</td><td>ＦＡＴＣＡ宣誓区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_FatcasnsiKbn C_FatcasnsiKbn}</td></tr>
 *  <tr><td>bikkjnssinfokbn</td><td>米国人示唆情報区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BikkjnssinfoKbn C_BikkjnssinfoKbn}</td></tr>
 *  <tr><td>aeoisnsikbn</td><td>ＡＥＯＩ宣誓区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AeoisnsiKbn C_AeoisnsiKbn}</td></tr>
 *  <tr><td>hknsyuruino</td><td>保険種類番号</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HknsyuruiNo C_HknsyuruiNo}</td></tr>
 *  <tr><td>hknsyuruinosd</td><td>保険種類番号世代</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>nkgnshosyouritukbn</td><td>年金原資最低保証率区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NkgnsHosyourituKbn C_NkgnsHosyourituKbn}</td></tr>
 *  <tr><td>livhukaumu</td><td>リビングニーズ付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Livhukaumu C_Livhukaumu}</td></tr>
 *  <tr><td>pmnjtkhukakbn</td><td>保険料免除特約付加区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_PmnjtkhukaKbn C_PmnjtkhukaKbn}</td></tr>
 *  <tr><td>pmnjtkkbn</td><td>保険料免除特約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_PmnjtkKbn C_PmnjtkKbn}</td></tr>
 *  <tr><td>kzktourokuservicetourokukbn</td><td>ご家族登録サービス登録区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KzktourokuserviceTourokuKbn C_KzktourokuserviceTourokuKbn}</td></tr>
 *  <tr><td>kykdrtkykhukakbn</td><td>契約者代理特約付加区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tkhukaumu C_Tkhukaumu}</td></tr>
 *  <tr><td>stdrsktkyhkkbn</td><td>被保険者代理特約付加区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tkhukaumu C_Tkhukaumu}</td></tr>
 *  <tr><td>sdpdkbn</td><td>Ｓ建Ｐ建区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Sdpd C_Sdpd}</td></tr>
 *  <tr><td>sntkhoukbn</td><td>選択方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SntkhouKbn C_SntkhouKbn}</td></tr>
 *  <tr><td>haitoukbn</td><td>配当区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HaitouKbn C_HaitouKbn}</td></tr>
 *  <tr><td>haitoukinuketorihoukbn</td><td>配当金受取方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HaitoukinuketorihouKbn C_HaitoukinuketorihouKbn}</td></tr>
 *  <tr><td>kyktuukasyu</td><td>契約通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>hrktuukasyu</td><td>払込通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>yennykntkhkkbn</td><td>円入金特約付加区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tkhukaumu C_Tkhukaumu}</td></tr>
 *  <tr><td>gaikanykntkhkkbn</td><td>外貨入金特約付加区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tkhukaumu C_Tkhukaumu}</td></tr>
 *  <tr><td>yenshrtkhkkbn</td><td>円支払特約付加区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tkhukaumu C_Tkhukaumu}</td></tr>
 *  <tr><td>mosheijyunp</td><td>申込平準払Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>ikkatubaraikbn</td><td>一括払区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_IkkatubaraiKbn C_IkkatubaraiKbn}</td></tr>
 *  <tr><td>ikkatubaraikaisuu</td><td>一括払回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_IkkatubaraiKaisuuKbn C_IkkatubaraiKaisuuKbn}</td></tr>
 *  <tr><td>mosikkatup</td><td>申込一括払Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syutkpkei</td><td>主契約・特約Ｐ合計金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>fsthrkpkei</td><td>初回払込Ｐ合計金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hrkkaisuu</td><td>払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>hrkkeiro</td><td>払込経路</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkeiro C_Hrkkeiro}</td></tr>
 *  <tr><td>fstphrkkeirokbn</td><td>初回保険料払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_FstphrkkeiroKbn C_FstphrkkeiroKbn}</td></tr>
 *  <tr><td>zennoumousideumu</td><td>前納申出有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>zenkizennouumu</td><td>全期前納有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>znnkai</td><td>前納回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>moszennoupsyokaiari</td><td>申込前納Ｐ（初回含）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>targettkhkkbn</td><td>ターゲット特約付加区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tkhukaumu C_Tkhukaumu}</td></tr>
 *  <tr><td>targettkkbn</td><td>ターゲット特約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TargetTkKbn C_TargetTkKbn}</td></tr>
 *  <tr><td>targettkmkhtkbn</td><td>ターゲット特約目標値区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TargetTkMokuhyoutiKbn C_TargetTkMokuhyoutiKbn}</td></tr>
 *  <tr><td>nstkhkkbn</td><td>年金支払特約付加区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tkhukaumu C_Tkhukaumu}</td></tr>
 *  <tr><td>nstkmnknsyu</td><td>年金支払特約満期年金種類</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>nstkmnknkkn</td><td>年金支払特約満期年金期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>nstksbnsyu</td><td>年金支払特約死亡年金種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Nstknsyu C_Nstknsyu}</td></tr>
 *  <tr><td>nstksbnkkn</td><td>年金支払特約死亡年金期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syksbyensitihsyutkhkkbn</td><td>初期死亡時円換算最低保証特約付加区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tkhukaumu C_Tkhukaumu}</td></tr>
 *  <tr><td>jyudkaigomehrtkhkkbn</td><td>重度介護前払特約付加区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tkhukaumu C_Tkhukaumu}</td></tr>
 *  <tr><td>kjnnkpzeitekitkhukakbn</td><td>個人年金保険料税制適格特約付加区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tkhukaumu C_Tkhukaumu}</td></tr>
 *  <tr><td>teikisiharaitkykhkkbn</td><td>定期支払特約付加区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tkhukaumu C_Tkhukaumu}</td></tr>
 *  <tr><td>sbuktnin</td><td>死亡受取人人数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kykhonninkakninsyoruikbn</td><td>契約者本人確認書類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HonninkakuninSyoruiKbn C_HonninkakuninSyoruiKbn}</td></tr>
 *  <tr><td>skskknhonninkakninsyoruikbn</td><td>親権者後見人本人確認書類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HonninkakuninSyoruiKbn C_HonninkakuninSyoruiKbn}</td></tr>
 *  <tr><td>koureikzksetumeihoukbn</td><td>高齢者ご家族等説明方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KoureiKzkSetumeiHouKbn C_KoureiKzkSetumeiHouKbn}</td></tr>
 *  <tr><td>koureimndnhukusuukaikbn</td><td>高齢者面談複数回実施区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KoureiMndnHukusuukaiKbn C_KoureiMndnHukusuukaiKbn}</td></tr>
 *  <tr><td>koureitratkisyaigidskkbn</td><td>高齢者取扱者以外同席区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KoureiTratkisyaIgiDskKbn C_KoureiTratkisyaIgiDskKbn}</td></tr>
 *  <tr><td>daihituumukbn</td><td>代筆有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>uktkid</td><td>受付管理ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drctservicemoskbn</td><td>ダイレクトサービス申込区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DirectServiceMosKbn C_DirectServiceMosKbn}</td></tr>
 *  <tr><td>dsmailaddress</td><td>ＤＳメールアドレス</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tokuteitrhkansyono</td><td>特定取引用暗証番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>pplessrenjidssymenttdkhyj</td><td>ペーパーレス連動時ＤＳ書面手続表示</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DsSyomenTtdkHyouji C_DsSyomenTtdkHyouji}</td></tr>
 *  <tr><td>pplsrendoukouhurikousoukbn</td><td>ペーパーレス連動時口振申込書後送区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_PplessrendoukouhurikousouKbn C_PplessrendoukouhurikousouKbn}</td></tr>
 *  <tr><td>pplessrendoucreditkousoukbn</td><td>ペーパーレス連動時クレカ申込書後送区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_PplessrendoucreditkousouKbn C_PplessrendoucreditkousouKbn}</td></tr>
 *  <tr><td>ynkhrkmgkannituutikbn</td><td>円貨払込額案内通知区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YnkHrkmgkAnniTuutiKbn C_YnkHrkmgkAnniTuutiKbn}</td></tr>
 *  <tr><td>hnsstjmmouumukbn</td><td>本社集中事務申込有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kjmeigihkhunouumukbn</td><td>漢字名義変換不能有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>tsryhshrkykumukbn</td><td>手数料不支払契約有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>syosisyatodokeumukbn</td><td>証券支社届有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kakukisyouryakukbumukbn</td><td>カク基省略希望有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>seiymdmosseitouumukbn</td><td>生年月日申込書正当有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>ikokakninsyotokkijkumu</td><td>意向確認書特記事項有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>trtkhoukokusyotokkijkumu</td><td>取扱報告書特記事項有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>hnnkakninhskjikouumukbn</td><td>本人確認補足事項有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>hnnkakninhsktkjikouumukbn</td><td>本人確認補足特定事項有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>skskakninhsktkjikouumukbn</td><td>親権者確認補足特定事項有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>khnchkcmnt</td><td>基本チェックコメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mostourokujyoukyoukbn</td><td>申込情報登録状況区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MosTourokuJyoukyouKbn C_MosTourokuJyoukyouKbn}</td></tr>
 *  <tr><td>pplessdatasousinumukbn</td><td>ペーパーレスデータ送信有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>mobilebosyuukbn</td><td>モバイル募集区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MobilebosyuuKbn C_MobilebosyuuKbn}</td></tr>
 *  <tr><td>teirituhaibunwarikbn</td><td>定率部分配分割合区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TumitatekinHaibunWariKbn C_TumitatekinHaibunWariKbn}</td></tr>
 *  <tr><td>sisuukbn</td><td>指数区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Sisuukbn C_Sisuukbn}</td></tr>
 *  <tr><td>sisuuhaibunwarikbn</td><td>指数部分配分割合区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TumitatekinHaibunWariKbn C_TumitatekinHaibunWariKbn}</td></tr>
 *  <tr><td>trhkjikakkbn</td><td>取引時確認区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TrhkjiKakKbn C_TrhkjiKakKbn}</td></tr>
 *  <tr><td>koureitaioukbn</td><td>高齢者対応区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KoureisyaTaiouKbn C_KoureisyaTaiouKbn}</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_BosKihon
 * @see     GenHT_BosKihon
 * @see     QHT_BosKihon
 * @see     GenQHT_BosKihon
 */
public class PKHT_BosKihon extends AbstractExDBPrimaryKey<HT_BosKihon, PKHT_BosKihon> {

    private static final long serialVersionUID = 1L;

    public PKHT_BosKihon() {
    }

    public PKHT_BosKihon(String pMosno) {
        mosno = pMosno;
    }

    @Transient
    @Override
    public Class<HT_BosKihon> getEntityClass() {
        return HT_BosKihon.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

}