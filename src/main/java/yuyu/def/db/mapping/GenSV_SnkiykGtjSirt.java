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
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
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
import yuyu.def.db.entity.SV_SnkiykGtjSirt;
import yuyu.def.db.id.PKSV_SnkiykGtjSirt;
import yuyu.def.db.meta.GenQSV_SnkiykGtjSirt;
import yuyu.def.db.meta.QSV_SnkiykGtjSirt;
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
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 新契約決算ベース月次成立情報ビュー テーブルのマッピング情報クラスで、 {@link SV_SnkiykGtjSirt} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link SV_SnkiykGtjSirt}</td><td colspan="3">新契約決算ベース月次成立情報ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKSV_SnkiykGtjSirt ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMosnrkymd mosnrkymd}</td><td>申込書入力日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNyknkwsrate nyknkwsrate}</td><td>入金用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSeiritukbn seiritukbn}</td><td>成立区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SeirituKbn}</td></tr>
 *  <tr><td>{@link #getSrsyoriymd srsyoriymd}</td><td>成立処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMosymd mosymd}</td><td>申込日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMossakuseiymd mossakuseiymd}</td><td>申込書作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMosym mosym}</td><td>申込月度</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSkykymd skykymd}</td><td>指定契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSknnkaisiymd sknnkaisiymd}</td><td>責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSeisekiym seisekiym}</td><td>成績計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getSkeikeijyouym skeikeijyouym}</td><td>新契約計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getKykkbn kykkbn}</td><td>契約者区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KykKbn}</td></tr>
 *  <tr><td>{@link #getKykdrtkykhukakbn kykdrtkykhukakbn}</td><td>契約者代理特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkhukaumu}</td></tr>
 *  <tr><td>{@link #getStdrsktkyhkkbn stdrsktkyhkkbn}</td><td>被保険者代理特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkhukaumu}</td></tr>
 *  <tr><td>{@link #getSdpdkbn sdpdkbn}</td><td>Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Sdpd}</td></tr>
 *  <tr><td>{@link #getSntkhoukbn sntkhoukbn}</td><td>選択方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SntkhouKbn}</td></tr>
 *  <tr><td>{@link #getHaitoukbn haitoukbn}</td><td>配当区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HaitouKbn}</td></tr>
 *  <tr><td>{@link #getHaitoukinuketorihoukbn haitoukinuketorihoukbn}</td><td>配当金受取方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HaitoukinuketorihouKbn}</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getHrktuukasyu hrktuukasyu}</td><td>払込通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getZnnkai znnkai}</td><td>前納回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHyouteip hyouteip}</td><td>表定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getHrkkeiro hrkkeiro}</td><td>払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getHhknnmkn hhknnmkn}</td><td>被保険者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkj hhknnmkj}</td><td>被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknseiymd hhknseiymd}</td><td>被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHhknnen hhknnen}</td><td>被保険者年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHhknsei hhknsei}</td><td>被保険者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hhknsei}</td></tr>
 *  <tr><td>{@link #getHhknsykgycd hhknsykgycd}</td><td>被保険者職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkn kyknmkn}</td><td>契約者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykseiymd kykseiymd}</td><td>契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyknen kyknen}</td><td>契約者年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyksei kyksei}</td><td>契約者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kyksei}</td></tr>
 *  <tr><td>{@link #getTsinyno tsinyno}</td><td>通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykhonninkakninsyoruikbn kykhonninkakninsyoruikbn}</td><td>契約者本人確認書類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HonninkakuninSyoruiKbn}</td></tr>
 *  <tr><td>{@link #getZennoumousideumu zennoumousideumu}</td><td>前納申出有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHeijyunp heijyunp}</td><td>平準払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getIkkatubaraikaisuu ikkatubaraikaisuu}</td><td>一括払回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_IkkatubaraiKaisuuKbn}</td></tr>
 *  <tr><td>{@link #getKktymd kktymd}</td><td>告知日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykkaksyrui kykkaksyrui}</td><td>契約確認種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kykkaksyrui}</td></tr>
 *  <tr><td>{@link #getSpgndtknkbn spgndtknkbn}</td><td>ＳＰ限度特認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SpgndtknKbn}</td></tr>
 *  <tr><td>{@link #getNenkkntknkbn nenkkntknkbn}</td><td>年齢期間特認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NenkkntknKbn}</td></tr>
 *  <tr><td>{@link #getTsngndtknkbn tsngndtknkbn}</td><td>通算限度特認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TsngndtknKbn}</td></tr>
 *  <tr><td>{@link #getSentakuinfotknkbn sentakuinfotknkbn}</td><td>選択情報特認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SentakuinfotknKbn}</td></tr>
 *  <tr><td>{@link #getKakoymdkyytknkbn kakoymdkyytknkbn}</td><td>過去日付許容特認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KakoymdkyytknKbn}</td></tr>
 *  <tr><td>{@link #getSaiteiptknkbn saiteiptknkbn}</td><td>最低P特認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SaiteiptknKbn}</td></tr>
 *  <tr><td>{@link #getSignalkaihikbn signalkaihikbn}</td><td>シグナル回避区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SignalkaihiKbn}</td></tr>
 *  <tr><td>{@link #getSonotatknkbn sonotatknkbn}</td><td>その他特認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SonotaTokuninKbn}</td></tr>
 *  <tr><td>{@link #getDrtenkanritodoufukencd drtenkanritodoufukencd}</td><td>代理店管理都道府県コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYenshrtkhkumu yenshrtkhkumu}</td><td>円支払特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getInitsbjiyensitihsytkhukaumu initsbjiyensitihsytkhukaumu}</td><td>初期死亡時円換算最低保証特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getInitsbjiyenkasaiteihsygk initsbjiyenkasaiteihsygk}</td><td>初期死亡時円換算最低保証額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getJyudkaigomeharaitkhukaumu jyudkaigomeharaitkhukaumu}</td><td>重度介護前払特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTargettkhkumu targettkhkumu}</td><td>ターゲット特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTargettkykkykhenkoymd targettkykkykhenkoymd}</td><td>ターゲット特約契約変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTargettkmokuhyouti targettkmokuhyouti}</td><td>ターゲット特約目標値</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTargettkykkijyungk targettkykkijyungk}</td><td>ターゲット特約基準金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTeikishrtkykhukaumu teikishrtkykhukaumu}</td><td>定期支払特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSisuuhaibunwarikbn sisuuhaibunwarikbn}</td><td>指数部分配分割合区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TumitatekinHaibunWariKbn}</td></tr>
 *  <tr><td>{@link #getSisuukbn sisuukbn}</td><td>指数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Sisuukbn}</td></tr>
 * </table>
 * @see     SV_SnkiykGtjSirt
 * @see     PKSV_SnkiykGtjSirt
 * @see     QSV_SnkiykGtjSirt
 * @see     GenQSV_SnkiykGtjSirt
 */
@MappedSuperclass
@Table(name=GenSV_SnkiykGtjSirt.TABLE_NAME)
@IdClass(value=PKSV_SnkiykGtjSirt.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_HaitouKbn", typeClass=UserType_C_HaitouKbn.class),
    @TypeDef(name="UserType_C_HaitoukinuketorihouKbn", typeClass=UserType_C_HaitoukinuketorihouKbn.class),
    @TypeDef(name="UserType_C_Hhknsei", typeClass=UserType_C_Hhknsei.class),
    @TypeDef(name="UserType_C_HonninkakuninSyoruiKbn", typeClass=UserType_C_HonninkakuninSyoruiKbn.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_IkkatubaraiKaisuuKbn", typeClass=UserType_C_IkkatubaraiKaisuuKbn.class),
    @TypeDef(name="UserType_C_KakoymdkyytknKbn", typeClass=UserType_C_KakoymdkyytknKbn.class),
    @TypeDef(name="UserType_C_KykKbn", typeClass=UserType_C_KykKbn.class),
    @TypeDef(name="UserType_C_Kykkaksyrui", typeClass=UserType_C_Kykkaksyrui.class),
    @TypeDef(name="UserType_C_Kyksei", typeClass=UserType_C_Kyksei.class),
    @TypeDef(name="UserType_C_NenkkntknKbn", typeClass=UserType_C_NenkkntknKbn.class),
    @TypeDef(name="UserType_C_SaiteiptknKbn", typeClass=UserType_C_SaiteiptknKbn.class),
    @TypeDef(name="UserType_C_Sdpd", typeClass=UserType_C_Sdpd.class),
    @TypeDef(name="UserType_C_SeirituKbn", typeClass=UserType_C_SeirituKbn.class),
    @TypeDef(name="UserType_C_SentakuinfotknKbn", typeClass=UserType_C_SentakuinfotknKbn.class),
    @TypeDef(name="UserType_C_SignalkaihiKbn", typeClass=UserType_C_SignalkaihiKbn.class),
    @TypeDef(name="UserType_C_Sisuukbn", typeClass=UserType_C_Sisuukbn.class),
    @TypeDef(name="UserType_C_SntkhouKbn", typeClass=UserType_C_SntkhouKbn.class),
    @TypeDef(name="UserType_C_SonotaTokuninKbn", typeClass=UserType_C_SonotaTokuninKbn.class),
    @TypeDef(name="UserType_C_SpgndtknKbn", typeClass=UserType_C_SpgndtknKbn.class),
    @TypeDef(name="UserType_C_Tkhukaumu", typeClass=UserType_C_Tkhukaumu.class),
    @TypeDef(name="UserType_C_TsngndtknKbn", typeClass=UserType_C_TsngndtknKbn.class),
    @TypeDef(name="UserType_C_TumitatekinHaibunWariKbn", typeClass=UserType_C_TumitatekinHaibunWariKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenSV_SnkiykGtjSirt extends AbstractExDBEntity<SV_SnkiykGtjSirt, PKSV_SnkiykGtjSirt> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "SV_SnkiykGtjSirt";
    public static final String MOSNO                    = "mosno";
    public static final String SYONO                    = "syono";
    public static final String MOSNRKYMD                = "mosnrkymd";
    public static final String NYKNKWSRATE              = "nyknkwsrate";
    public static final String SEIRITUKBN               = "seiritukbn";
    public static final String SRSYORIYMD               = "srsyoriymd";
    public static final String MOSYMD                   = "mosymd";
    public static final String MOSSAKUSEIYMD            = "mossakuseiymd";
    public static final String MOSYM                    = "mosym";
    public static final String KYKYMD                   = "kykymd";
    public static final String SKYKYMD                  = "skykymd";
    public static final String SKNNKAISIYMD             = "sknnkaisiymd";
    public static final String SEISEKIYM                = "seisekiym";
    public static final String SKEIKEIJYOUYM            = "skeikeijyouym";
    public static final String KYKKBN                   = "kykkbn";
    public static final String KYKDRTKYKHUKAKBN         = "kykdrtkykhukakbn";
    public static final String STDRSKTKYHKKBN           = "stdrsktkyhkkbn";
    public static final String SDPDKBN                  = "sdpdkbn";
    public static final String SNTKHOUKBN               = "sntkhoukbn";
    public static final String HAITOUKBN                = "haitoukbn";
    public static final String HAITOUKINUKETORIHOUKBN   = "haitoukinuketorihoukbn";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String HRKTUUKASYU              = "hrktuukasyu";
    public static final String ZNNKAI                   = "znnkai";
    public static final String HYOUTEIP                 = "hyouteip";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String HRKKEIRO                 = "hrkkeiro";
    public static final String HHKNNMKN                 = "hhknnmkn";
    public static final String HHKNNMKJ                 = "hhknnmkj";
    public static final String HHKNSEIYMD               = "hhknseiymd";
    public static final String HHKNNEN                  = "hhknnen";
    public static final String HHKNSEI                  = "hhknsei";
    public static final String HHKNSYKGYCD              = "hhknsykgycd";
    public static final String KYKNMKN                  = "kyknmkn";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String KYKSEIYMD                = "kykseiymd";
    public static final String KYKNEN                   = "kyknen";
    public static final String KYKSEI                   = "kyksei";
    public static final String TSINYNO                  = "tsinyno";
    public static final String KYKHONNINKAKNINSYORUIKBN = "kykhonninkakninsyoruikbn";
    public static final String ZENNOUMOUSIDEUMU         = "zennoumousideumu";
    public static final String HEIJYUNP                 = "heijyunp";
    public static final String IKKATUBARAIKAISUU        = "ikkatubaraikaisuu";
    public static final String KKTYMD                   = "kktymd";
    public static final String KYKKAKSYRUI              = "kykkaksyrui";
    public static final String SPGNDTKNKBN              = "spgndtknkbn";
    public static final String NENKKNTKNKBN             = "nenkkntknkbn";
    public static final String TSNGNDTKNKBN             = "tsngndtknkbn";
    public static final String SENTAKUINFOTKNKBN        = "sentakuinfotknkbn";
    public static final String KAKOYMDKYYTKNKBN         = "kakoymdkyytknkbn";
    public static final String SAITEIPTKNKBN            = "saiteiptknkbn";
    public static final String SIGNALKAIHIKBN           = "signalkaihikbn";
    public static final String SONOTATKNKBN             = "sonotatknkbn";
    public static final String DRTENKANRITODOUFUKENCD   = "drtenkanritodoufukencd";
    public static final String YENSHRTKHKUMU            = "yenshrtkhkumu";
    public static final String INITSBJIYENSITIHSYTKHUKAUMU = "initsbjiyensitihsytkhukaumu";
    public static final String INITSBJIYENKASAITEIHSYGK = "initsbjiyenkasaiteihsygk";
    public static final String JYUDKAIGOMEHARAITKHUKAUMU = "jyudkaigomeharaitkhukaumu";
    public static final String TARGETTKHKUMU            = "targettkhkumu";
    public static final String TARGETTKYKKYKHENKOYMD    = "targettkykkykhenkoymd";
    public static final String TARGETTKMOKUHYOUTI       = "targettkmokuhyouti";
    public static final String TARGETTKYKKIJYUNGK       = "targettkykkijyungk";
    public static final String TEIKISHRTKYKHUKAUMU      = "teikishrtkykhukaumu";
    public static final String SISUUHAIBUNWARIKBN       = "sisuuhaibunwarikbn";
    public static final String SISUUKBN                 = "sisuukbn";

    private final PKSV_SnkiykGtjSirt primaryKey;

    public GenSV_SnkiykGtjSirt() {
        primaryKey = new PKSV_SnkiykGtjSirt();
    }

    public GenSV_SnkiykGtjSirt(String pMosno) {
        primaryKey = new PKSV_SnkiykGtjSirt(pMosno);
    }

    @Transient
    @Override
    public PKSV_SnkiykGtjSirt getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QSV_SnkiykGtjSirt> getMetaClass() {
        return QSV_SnkiykGtjSirt.class;
    }

    @Id
    @Column(name=GenSV_SnkiykGtjSirt.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    private String syono;

    @Column(name=GenSV_SnkiykGtjSirt.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private BizDate mosnrkymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_SnkiykGtjSirt.MOSNRKYMD)
    public BizDate getMosnrkymd() {
        return mosnrkymd;
    }

    public void setMosnrkymd(BizDate pMosnrkymd) {
        mosnrkymd = pMosnrkymd;
    }

    private BizNumber nyknkwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenSV_SnkiykGtjSirt.NYKNKWSRATE)
    public BizNumber getNyknkwsrate() {
        return nyknkwsrate;
    }

    public void setNyknkwsrate(BizNumber pNyknkwsrate) {
        nyknkwsrate = pNyknkwsrate;
    }

    private C_SeirituKbn seiritukbn;

    @Type(type="UserType_C_SeirituKbn")
    @Column(name=GenSV_SnkiykGtjSirt.SEIRITUKBN)
    public C_SeirituKbn getSeiritukbn() {
        return seiritukbn;
    }

    public void setSeiritukbn(C_SeirituKbn pSeiritukbn) {
        seiritukbn = pSeiritukbn;
    }

    private BizDate srsyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_SnkiykGtjSirt.SRSYORIYMD)
    public BizDate getSrsyoriymd() {
        return srsyoriymd;
    }

    public void setSrsyoriymd(BizDate pSrsyoriymd) {
        srsyoriymd = pSrsyoriymd;
    }

    private BizDate mosymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_SnkiykGtjSirt.MOSYMD)
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
    @Column(name=GenSV_SnkiykGtjSirt.MOSSAKUSEIYMD)
    @ValidDate
    public BizDate getMossakuseiymd() {
        return mossakuseiymd;
    }

    @Trim("both")
    public void setMossakuseiymd(BizDate pMossakuseiymd) {
        mossakuseiymd = pMossakuseiymd;
    }

    private BizDateYM mosym;

    @Type(type="BizDateYMType")
    @Column(name=GenSV_SnkiykGtjSirt.MOSYM)
    public BizDateYM getMosym() {
        return mosym;
    }

    public void setMosym(BizDateYM pMosym) {
        mosym = pMosym;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_SnkiykGtjSirt.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private BizDate skykymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_SnkiykGtjSirt.SKYKYMD)
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
    @Column(name=GenSV_SnkiykGtjSirt.SKNNKAISIYMD)
    public BizDate getSknnkaisiymd() {
        return sknnkaisiymd;
    }

    @Trim("both")
    public void setSknnkaisiymd(BizDate pSknnkaisiymd) {
        sknnkaisiymd = pSknnkaisiymd;
    }

    private BizDateYM seisekiym;

    @Type(type="BizDateYMType")
    @Column(name=GenSV_SnkiykGtjSirt.SEISEKIYM)
    public BizDateYM getSeisekiym() {
        return seisekiym;
    }

    @Trim("both")
    public void setSeisekiym(BizDateYM pSeisekiym) {
        seisekiym = pSeisekiym;
    }

    private BizDateYM skeikeijyouym;

    @Type(type="BizDateYMType")
    @Column(name=GenSV_SnkiykGtjSirt.SKEIKEIJYOUYM)
    public BizDateYM getSkeikeijyouym() {
        return skeikeijyouym;
    }

    @Trim("both")
    public void setSkeikeijyouym(BizDateYM pSkeikeijyouym) {
        skeikeijyouym = pSkeikeijyouym;
    }

    private C_KykKbn kykkbn;

    @Type(type="UserType_C_KykKbn")
    @Column(name=GenSV_SnkiykGtjSirt.KYKKBN)
    public C_KykKbn getKykkbn() {
        return kykkbn;
    }

    public void setKykkbn(C_KykKbn pKykkbn) {
        kykkbn = pKykkbn;
    }

    private C_Tkhukaumu kykdrtkykhukakbn;

    @Type(type="UserType_C_Tkhukaumu")
    @Column(name=GenSV_SnkiykGtjSirt.KYKDRTKYKHUKAKBN)
    public C_Tkhukaumu getKykdrtkykhukakbn() {
        return kykdrtkykhukakbn;
    }

    public void setKykdrtkykhukakbn(C_Tkhukaumu pKykdrtkykhukakbn) {
        kykdrtkykhukakbn = pKykdrtkykhukakbn;
    }

    private C_Tkhukaumu stdrsktkyhkkbn;

    @Type(type="UserType_C_Tkhukaumu")
    @Column(name=GenSV_SnkiykGtjSirt.STDRSKTKYHKKBN)
    public C_Tkhukaumu getStdrsktkyhkkbn() {
        return stdrsktkyhkkbn;
    }

    public void setStdrsktkyhkkbn(C_Tkhukaumu pStdrsktkyhkkbn) {
        stdrsktkyhkkbn = pStdrsktkyhkkbn;
    }

    private C_Sdpd sdpdkbn;

    @Type(type="UserType_C_Sdpd")
    @Column(name=GenSV_SnkiykGtjSirt.SDPDKBN)
    public C_Sdpd getSdpdkbn() {
        return sdpdkbn;
    }

    public void setSdpdkbn(C_Sdpd pSdpdkbn) {
        sdpdkbn = pSdpdkbn;
    }

    private C_SntkhouKbn sntkhoukbn;

    @Type(type="UserType_C_SntkhouKbn")
    @Column(name=GenSV_SnkiykGtjSirt.SNTKHOUKBN)
    public C_SntkhouKbn getSntkhoukbn() {
        return sntkhoukbn;
    }

    public void setSntkhoukbn(C_SntkhouKbn pSntkhoukbn) {
        sntkhoukbn = pSntkhoukbn;
    }

    private C_HaitouKbn haitoukbn;

    @Type(type="UserType_C_HaitouKbn")
    @Column(name=GenSV_SnkiykGtjSirt.HAITOUKBN)
    public C_HaitouKbn getHaitoukbn() {
        return haitoukbn;
    }

    public void setHaitoukbn(C_HaitouKbn pHaitoukbn) {
        haitoukbn = pHaitoukbn;
    }

    private C_HaitoukinuketorihouKbn haitoukinuketorihoukbn;

    @Type(type="UserType_C_HaitoukinuketorihouKbn")
    @Column(name=GenSV_SnkiykGtjSirt.HAITOUKINUKETORIHOUKBN)
    public C_HaitoukinuketorihouKbn getHaitoukinuketorihoukbn() {
        return haitoukinuketorihoukbn;
    }

    public void setHaitoukinuketorihoukbn(C_HaitoukinuketorihouKbn pHaitoukinuketorihoukbn) {
        haitoukinuketorihoukbn = pHaitoukinuketorihoukbn;
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenSV_SnkiykGtjSirt.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private C_Tuukasyu hrktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenSV_SnkiykGtjSirt.HRKTUUKASYU)
    public C_Tuukasyu getHrktuukasyu() {
        return hrktuukasyu;
    }

    public void setHrktuukasyu(C_Tuukasyu pHrktuukasyu) {
        hrktuukasyu = pHrktuukasyu;
    }

    private Integer znnkai;

    @Column(name=GenSV_SnkiykGtjSirt.ZNNKAI)
    @Range(min="0", max="999")
    public Integer getZnnkai() {
        return znnkai;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZnnkai(Integer pZnnkai) {
        znnkai = pZnnkai;
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

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenSV_SnkiykGtjSirt.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_Hrkkeiro hrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenSV_SnkiykGtjSirt.HRKKEIRO)
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private String hhknnmkn;

    @Column(name=GenSV_SnkiykGtjSirt.HHKNNMKN)
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

    @Column(name=GenSV_SnkiykGtjSirt.HHKNNMKJ)
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

    private BizDate hhknseiymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_SnkiykGtjSirt.HHKNSEIYMD)
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

    @Column(name=GenSV_SnkiykGtjSirt.HHKNNEN)
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
    @Column(name=GenSV_SnkiykGtjSirt.HHKNSEI)
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private String hhknsykgycd;

    @Column(name=GenSV_SnkiykGtjSirt.HHKNSYKGYCD)
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

    private String kyknmkn;

    @Column(name=GenSV_SnkiykGtjSirt.KYKNMKN)
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

    @Column(name=GenSV_SnkiykGtjSirt.KYKNMKJ)
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

    private BizDate kykseiymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_SnkiykGtjSirt.KYKSEIYMD)
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

    @Column(name=GenSV_SnkiykGtjSirt.KYKNEN)
    public Integer getKyknen() {
        return kyknen;
    }

    public void setKyknen(Integer pKyknen) {
        kyknen = pKyknen;
    }

    private C_Kyksei kyksei;

    @Type(type="UserType_C_Kyksei")
    @Column(name=GenSV_SnkiykGtjSirt.KYKSEI)
    public C_Kyksei getKyksei() {
        return kyksei;
    }

    public void setKyksei(C_Kyksei pKyksei) {
        kyksei = pKyksei;
    }

    private String tsinyno;

    @Column(name=GenSV_SnkiykGtjSirt.TSINYNO)
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

    private C_HonninkakuninSyoruiKbn kykhonninkakninsyoruikbn;

    @Type(type="UserType_C_HonninkakuninSyoruiKbn")
    @Column(name=GenSV_SnkiykGtjSirt.KYKHONNINKAKNINSYORUIKBN)
    public C_HonninkakuninSyoruiKbn getKykhonninkakninsyoruikbn() {
        return kykhonninkakninsyoruikbn;
    }

    public void setKykhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn pKykhonninkakninsyoruikbn) {
        kykhonninkakninsyoruikbn = pKykhonninkakninsyoruikbn;
    }

    private C_UmuKbn zennoumousideumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_SnkiykGtjSirt.ZENNOUMOUSIDEUMU)
    public C_UmuKbn getZennoumousideumu() {
        return zennoumousideumu;
    }

    public void setZennoumousideumu(C_UmuKbn pZennoumousideumu) {
        zennoumousideumu = pZennoumousideumu;
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

    private C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu;

    @Type(type="UserType_C_IkkatubaraiKaisuuKbn")
    @Column(name=GenSV_SnkiykGtjSirt.IKKATUBARAIKAISUU)
    public C_IkkatubaraiKaisuuKbn getIkkatubaraikaisuu() {
        return ikkatubaraikaisuu;
    }

    public void setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn pIkkatubaraikaisuu) {
        ikkatubaraikaisuu = pIkkatubaraikaisuu;
    }

    private BizDate kktymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_SnkiykGtjSirt.KKTYMD)
    @ValidDate
    public BizDate getKktymd() {
        return kktymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKktymd(BizDate pKktymd) {
        kktymd = pKktymd;
    }

    private C_Kykkaksyrui kykkaksyrui;

    @Type(type="UserType_C_Kykkaksyrui")
    @Column(name=GenSV_SnkiykGtjSirt.KYKKAKSYRUI)
    public C_Kykkaksyrui getKykkaksyrui() {
        return kykkaksyrui;
    }

    public void setKykkaksyrui(C_Kykkaksyrui pKykkaksyrui) {
        kykkaksyrui = pKykkaksyrui;
    }

    private C_SpgndtknKbn spgndtknkbn;

    @Type(type="UserType_C_SpgndtknKbn")
    @Column(name=GenSV_SnkiykGtjSirt.SPGNDTKNKBN)
    public C_SpgndtknKbn getSpgndtknkbn() {
        return spgndtknkbn;
    }

    public void setSpgndtknkbn(C_SpgndtknKbn pSpgndtknkbn) {
        spgndtknkbn = pSpgndtknkbn;
    }

    private C_NenkkntknKbn nenkkntknkbn;

    @Type(type="UserType_C_NenkkntknKbn")
    @Column(name=GenSV_SnkiykGtjSirt.NENKKNTKNKBN)
    public C_NenkkntknKbn getNenkkntknkbn() {
        return nenkkntknkbn;
    }

    public void setNenkkntknkbn(C_NenkkntknKbn pNenkkntknkbn) {
        nenkkntknkbn = pNenkkntknkbn;
    }

    private C_TsngndtknKbn tsngndtknkbn;

    @Type(type="UserType_C_TsngndtknKbn")
    @Column(name=GenSV_SnkiykGtjSirt.TSNGNDTKNKBN)
    public C_TsngndtknKbn getTsngndtknkbn() {
        return tsngndtknkbn;
    }

    public void setTsngndtknkbn(C_TsngndtknKbn pTsngndtknkbn) {
        tsngndtknkbn = pTsngndtknkbn;
    }

    private C_SentakuinfotknKbn sentakuinfotknkbn;

    @Type(type="UserType_C_SentakuinfotknKbn")
    @Column(name=GenSV_SnkiykGtjSirt.SENTAKUINFOTKNKBN)
    public C_SentakuinfotknKbn getSentakuinfotknkbn() {
        return sentakuinfotknkbn;
    }

    public void setSentakuinfotknkbn(C_SentakuinfotknKbn pSentakuinfotknkbn) {
        sentakuinfotknkbn = pSentakuinfotknkbn;
    }

    private C_KakoymdkyytknKbn kakoymdkyytknkbn;

    @Type(type="UserType_C_KakoymdkyytknKbn")
    @Column(name=GenSV_SnkiykGtjSirt.KAKOYMDKYYTKNKBN)
    public C_KakoymdkyytknKbn getKakoymdkyytknkbn() {
        return kakoymdkyytknkbn;
    }

    public void setKakoymdkyytknkbn(C_KakoymdkyytknKbn pKakoymdkyytknkbn) {
        kakoymdkyytknkbn = pKakoymdkyytknkbn;
    }

    private C_SaiteiptknKbn saiteiptknkbn;

    @Type(type="UserType_C_SaiteiptknKbn")
    @Column(name=GenSV_SnkiykGtjSirt.SAITEIPTKNKBN)
    public C_SaiteiptknKbn getSaiteiptknkbn() {
        return saiteiptknkbn;
    }

    public void setSaiteiptknkbn(C_SaiteiptknKbn pSaiteiptknkbn) {
        saiteiptknkbn = pSaiteiptknkbn;
    }

    private C_SignalkaihiKbn signalkaihikbn;

    @Type(type="UserType_C_SignalkaihiKbn")
    @Column(name=GenSV_SnkiykGtjSirt.SIGNALKAIHIKBN)
    public C_SignalkaihiKbn getSignalkaihikbn() {
        return signalkaihikbn;
    }

    public void setSignalkaihikbn(C_SignalkaihiKbn pSignalkaihikbn) {
        signalkaihikbn = pSignalkaihikbn;
    }

    private C_SonotaTokuninKbn sonotatknkbn;

    @Type(type="UserType_C_SonotaTokuninKbn")
    @Column(name=GenSV_SnkiykGtjSirt.SONOTATKNKBN)
    public C_SonotaTokuninKbn getSonotatknkbn() {
        return sonotatknkbn;
    }

    public void setSonotatknkbn(C_SonotaTokuninKbn pSonotatknkbn) {
        sonotatknkbn = pSonotatknkbn;
    }

    private String drtenkanritodoufukencd;

    @Column(name=GenSV_SnkiykGtjSirt.DRTENKANRITODOUFUKENCD)
    public String getDrtenkanritodoufukencd() {
        return drtenkanritodoufukencd;
    }

    public void setDrtenkanritodoufukencd(String pDrtenkanritodoufukencd) {
        drtenkanritodoufukencd = pDrtenkanritodoufukencd;
    }

    private C_UmuKbn yenshrtkhkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_SnkiykGtjSirt.YENSHRTKHKUMU)
    public C_UmuKbn getYenshrtkhkumu() {
        return yenshrtkhkumu;
    }

    public void setYenshrtkhkumu(C_UmuKbn pYenshrtkhkumu) {
        yenshrtkhkumu = pYenshrtkhkumu;
    }

    private C_UmuKbn initsbjiyensitihsytkhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_SnkiykGtjSirt.INITSBJIYENSITIHSYTKHUKAUMU)
    public C_UmuKbn getInitsbjiyensitihsytkhukaumu() {
        return initsbjiyensitihsytkhukaumu;
    }

    public void setInitsbjiyensitihsytkhukaumu(C_UmuKbn pInitsbjiyensitihsytkhukaumu) {
        initsbjiyensitihsytkhukaumu = pInitsbjiyensitihsytkhukaumu;
    }

    private BizCurrency initsbjiyenkasaiteihsygk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getInitsbjiyenkasaiteihsygk() {
        return initsbjiyenkasaiteihsygk;
    }

    public void setInitsbjiyenkasaiteihsygk(BizCurrency pInitsbjiyenkasaiteihsygk) {
        initsbjiyenkasaiteihsygk = pInitsbjiyenkasaiteihsygk;
        initsbjiyenkasaiteihsygkValue = null;
        initsbjiyenkasaiteihsygkType  = null;
    }

    transient private BigDecimal initsbjiyenkasaiteihsygkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=INITSBJIYENKASAITEIHSYGK, nullable=true)
    protected BigDecimal getInitsbjiyenkasaiteihsygkValue() {
        if (initsbjiyenkasaiteihsygkValue == null && initsbjiyenkasaiteihsygk != null) {
            if (initsbjiyenkasaiteihsygk.isOptional()) return null;
            return initsbjiyenkasaiteihsygk.absolute();
        }
        return initsbjiyenkasaiteihsygkValue;
    }

    protected void setInitsbjiyenkasaiteihsygkValue(BigDecimal value) {
        initsbjiyenkasaiteihsygkValue = value;
        initsbjiyenkasaiteihsygk = Optional.fromNullable(toCurrencyType(initsbjiyenkasaiteihsygkType))
            .transform(bizCurrencyTransformer(getInitsbjiyenkasaiteihsygkValue()))
            .orNull();
    }

    transient private String initsbjiyenkasaiteihsygkType = null;

    @Column(name=INITSBJIYENKASAITEIHSYGK + "$", nullable=true)
    protected String getInitsbjiyenkasaiteihsygkType() {
        if (initsbjiyenkasaiteihsygkType == null && initsbjiyenkasaiteihsygk != null) return initsbjiyenkasaiteihsygk.getType().toString();
        if (initsbjiyenkasaiteihsygkType == null && getInitsbjiyenkasaiteihsygkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'initsbjiyenkasaiteihsygk$' should not be NULL."));
        }
        return initsbjiyenkasaiteihsygkType;
    }

    protected void setInitsbjiyenkasaiteihsygkType(String type) {
        initsbjiyenkasaiteihsygkType = type;
        initsbjiyenkasaiteihsygk = Optional.fromNullable(toCurrencyType(initsbjiyenkasaiteihsygkType))
            .transform(bizCurrencyTransformer(getInitsbjiyenkasaiteihsygkValue()))
            .orNull();
    }

    private C_UmuKbn jyudkaigomeharaitkhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_SnkiykGtjSirt.JYUDKAIGOMEHARAITKHUKAUMU)
    public C_UmuKbn getJyudkaigomeharaitkhukaumu() {
        return jyudkaigomeharaitkhukaumu;
    }

    public void setJyudkaigomeharaitkhukaumu(C_UmuKbn pJyudkaigomeharaitkhukaumu) {
        jyudkaigomeharaitkhukaumu = pJyudkaigomeharaitkhukaumu;
    }

    private C_UmuKbn targettkhkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_SnkiykGtjSirt.TARGETTKHKUMU)
    public C_UmuKbn getTargettkhkumu() {
        return targettkhkumu;
    }

    public void setTargettkhkumu(C_UmuKbn pTargettkhkumu) {
        targettkhkumu = pTargettkhkumu;
    }

    private BizDate targettkykkykhenkoymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_SnkiykGtjSirt.TARGETTKYKKYKHENKOYMD)
    @ValidDate
    public BizDate getTargettkykkykhenkoymd() {
        return targettkykkykhenkoymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTargettkykkykhenkoymd(BizDate pTargettkykkykhenkoymd) {
        targettkykkykhenkoymd = pTargettkykkykhenkoymd;
    }

    private Integer targettkmokuhyouti;

    @Column(name=GenSV_SnkiykGtjSirt.TARGETTKMOKUHYOUTI)
    public Integer getTargettkmokuhyouti() {
        return targettkmokuhyouti;
    }

    public void setTargettkmokuhyouti(Integer pTargettkmokuhyouti) {
        targettkmokuhyouti = pTargettkmokuhyouti;
    }

    private BizCurrency targettkykkijyungk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTargettkykkijyungk() {
        return targettkykkijyungk;
    }

    public void setTargettkykkijyungk(BizCurrency pTargettkykkijyungk) {
        targettkykkijyungk = pTargettkykkijyungk;
        targettkykkijyungkValue = null;
        targettkykkijyungkType  = null;
    }

    transient private BigDecimal targettkykkijyungkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TARGETTKYKKIJYUNGK, nullable=true)
    protected BigDecimal getTargettkykkijyungkValue() {
        if (targettkykkijyungkValue == null && targettkykkijyungk != null) {
            if (targettkykkijyungk.isOptional()) return null;
            return targettkykkijyungk.absolute();
        }
        return targettkykkijyungkValue;
    }

    protected void setTargettkykkijyungkValue(BigDecimal value) {
        targettkykkijyungkValue = value;
        targettkykkijyungk = Optional.fromNullable(toCurrencyType(targettkykkijyungkType))
            .transform(bizCurrencyTransformer(getTargettkykkijyungkValue()))
            .orNull();
    }

    transient private String targettkykkijyungkType = null;

    @Column(name=TARGETTKYKKIJYUNGK + "$", nullable=true)
    protected String getTargettkykkijyungkType() {
        if (targettkykkijyungkType == null && targettkykkijyungk != null) return targettkykkijyungk.getType().toString();
        if (targettkykkijyungkType == null && getTargettkykkijyungkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'targettkykkijyungk$' should not be NULL."));
        }
        return targettkykkijyungkType;
    }

    protected void setTargettkykkijyungkType(String type) {
        targettkykkijyungkType = type;
        targettkykkijyungk = Optional.fromNullable(toCurrencyType(targettkykkijyungkType))
            .transform(bizCurrencyTransformer(getTargettkykkijyungkValue()))
            .orNull();
    }

    private C_UmuKbn teikishrtkykhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_SnkiykGtjSirt.TEIKISHRTKYKHUKAUMU)
    public C_UmuKbn getTeikishrtkykhukaumu() {
        return teikishrtkykhukaumu;
    }

    public void setTeikishrtkykhukaumu(C_UmuKbn pTeikishrtkykhukaumu) {
        teikishrtkykhukaumu = pTeikishrtkykhukaumu;
    }

    private C_TumitatekinHaibunWariKbn sisuuhaibunwarikbn;

    @Type(type="UserType_C_TumitatekinHaibunWariKbn")
    @Column(name=GenSV_SnkiykGtjSirt.SISUUHAIBUNWARIKBN)
    public C_TumitatekinHaibunWariKbn getSisuuhaibunwarikbn() {
        return sisuuhaibunwarikbn;
    }

    public void setSisuuhaibunwarikbn(C_TumitatekinHaibunWariKbn pSisuuhaibunwarikbn) {
        sisuuhaibunwarikbn = pSisuuhaibunwarikbn;
    }

    private C_Sisuukbn sisuukbn;

    @Type(type="UserType_C_Sisuukbn")
    @Column(name=GenSV_SnkiykGtjSirt.SISUUKBN)
    public C_Sisuukbn getSisuukbn() {
        return sisuukbn;
    }

    public void setSisuukbn(C_Sisuukbn pSisuukbn) {
        sisuukbn = pSisuukbn;
    }
}