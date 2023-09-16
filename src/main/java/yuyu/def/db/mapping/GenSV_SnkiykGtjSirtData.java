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
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.Pattern;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HonninkakuninSyoruiKbn;
import yuyu.def.classification.C_KakoymdkyytknKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kykkaksyrui;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_NenkkntknKbn;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_SaiteiptknKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SentakuinfotknKbn;
import yuyu.def.classification.C_SignalkaihiKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_SonotaTokuninKbn;
import yuyu.def.classification.C_SpgndtknKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TsngndtknKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.SV_SnkiykGtjSirtData;
import yuyu.def.db.id.PKSV_SnkiykGtjSirtData;
import yuyu.def.db.meta.GenQSV_SnkiykGtjSirtData;
import yuyu.def.db.meta.QSV_SnkiykGtjSirtData;
import yuyu.def.db.type.UserType_C_HaitouKbn;
import yuyu.def.db.type.UserType_C_HaitoukinuketorihouKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_HknkknsmnKbn;
import yuyu.def.db.type.UserType_C_HonninkakuninSyoruiKbn;
import yuyu.def.db.type.UserType_C_KakoymdkyytknKbn;
import yuyu.def.db.type.UserType_C_KykKbn;
import yuyu.def.db.type.UserType_C_Kykkaksyrui;
import yuyu.def.db.type.UserType_C_Kyksei;
import yuyu.def.db.type.UserType_C_NenkkntknKbn;
import yuyu.def.db.type.UserType_C_Nstknsyu;
import yuyu.def.db.type.UserType_C_SaiteiptknKbn;
import yuyu.def.db.type.UserType_C_Sdpd;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_SeirituKbn;
import yuyu.def.db.type.UserType_C_SentakuinfotknKbn;
import yuyu.def.db.type.UserType_C_SignalkaihiKbn;
import yuyu.def.db.type.UserType_C_SntkhouKbn;
import yuyu.def.db.type.UserType_C_SonotaTokuninKbn;
import yuyu.def.db.type.UserType_C_SpgndtknKbn;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_TsngndtknKbn;
import yuyu.def.db.type.UserType_C_UktKbn;
import yuyu.def.db.type.UserType_C_UktsyuKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 新契約決算ベース月次成立情報ビュー テーブルのマッピング情報クラスで、 {@link SV_SnkiykGtjSirtData} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link SV_SnkiykGtjSirtData}</td><td colspan="3">新契約決算ベース月次成立情報ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getRenno8keta renno8keta}</td><td>連番（８桁）</td><td align="center">{@link PKSV_SnkiykGtjSirtData ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMosnrkymd mosnrkymd}</td><td>申込書入力日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSeiritukbn seiritukbn}</td><td>成立区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SeirituKbn}</td></tr>
 *  <tr><td>{@link #getSrsyoriymd srsyoriymd}</td><td>成立処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMosymd mosymd}</td><td>申込日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMossakuseiymd mossakuseiymd}</td><td>申込書作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMosym mosym}</td><td>申込月度</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getKktymd kktymd}</td><td>告知日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSkykymd skykymd}</td><td>指定契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSknnkaisiymd sknnkaisiymd}</td><td>責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSeisekiym seisekiym}</td><td>成績計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getSkeikeijyouym skeikeijyouym}</td><td>新契約計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getKykkbn kykkbn}</td><td>契約者区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KykKbn}</td></tr>
 *  <tr><td>{@link #getStdrsktkyhkumu stdrsktkyhkumu}</td><td>指定代理請求特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSdpdkbn sdpdkbn}</td><td>Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Sdpd}</td></tr>
 *  <tr><td>{@link #getSntkhoukbn sntkhoukbn}</td><td>選択方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SntkhouKbn}</td></tr>
 *  <tr><td>{@link #getHaitoukbn haitoukbn}</td><td>配当区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HaitouKbn}</td></tr>
 *  <tr><td>{@link #getHaitoukinuketorihoukbn haitoukinuketorihoukbn}</td><td>配当金受取方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HaitoukinuketorihouKbn}</td></tr>
 *  <tr><td>{@link #getFstphrkgk fstphrkgk}</td><td>初回Ｐ払込必要額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
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
 *  <tr><td>{@link #getNstksbnsyu nstksbnsyu}</td><td>年金支払特約死亡年金種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Nstknsyu}</td></tr>
 *  <tr><td>{@link #getNstksbnkkn nstksbnkkn}</td><td>年金支払特約死亡年金期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKykhonninkakninsyoruikbn kykhonninkakninsyoruikbn}</td><td>契約者本人確認書類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HonninkakuninSyoruiKbn}</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRyouritusdno ryouritusdno}</td><td>料率世代番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyutkkbn syutkkbn}</td><td>主契約特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr><td>{@link #getYoteiriritu yoteiriritu}</td><td>予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSeitoukihons seitoukihons}</td><td>正当基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyutkp syutkp}</td><td>主契約・特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHknkkn hknkkn}</td><td>保険期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHknkknsmnkbn hknkknsmnkbn}</td><td>保険期間歳満期区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HknkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getMosdairitentblrenno mosdairitentblrenno}</td><td>申込代理店テーブル連番</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getCifcd cifcd}</td><td>ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtencd drtencd}</td><td>代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuucd bosyuucd}</td><td>募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDaibosyuucd daibosyuucd}</td><td>代表募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtenkanrisosikicd drtenkanrisosikicd}</td><td>代理店管理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykKaktblrenno kykKaktblrenno}</td><td>契約確認テーブル連番</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKykkaksyrui kykkaksyrui}</td><td>契約確認種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kykkaksyrui}</td></tr>
 *  <tr><td>{@link #getNyuukintblrenno nyuukintblrenno}</td><td>入金テーブル連番</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getRyosyuymd ryosyuymd}</td><td>領収日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSpgndtknkbn spgndtknkbn}</td><td>ＳＰ限度特認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SpgndtknKbn}</td></tr>
 *  <tr><td>{@link #getNenkkntknkbn nenkkntknkbn}</td><td>年齢期間特認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NenkkntknKbn}</td></tr>
 *  <tr><td>{@link #getTsngndtknkbn tsngndtknkbn}</td><td>通算限度特認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TsngndtknKbn}</td></tr>
 *  <tr><td>{@link #getSentakuinfotknkbn sentakuinfotknkbn}</td><td>選択情報特認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SentakuinfotknKbn}</td></tr>
 *  <tr><td>{@link #getKakoymdkyytknkbn kakoymdkyytknkbn}</td><td>過去日付許容特認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KakoymdkyytknKbn}</td></tr>
 *  <tr><td>{@link #getSaiteiptknkbn saiteiptknkbn}</td><td>最低P特認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SaiteiptknKbn}</td></tr>
 *  <tr><td>{@link #getSignalkaihikbn signalkaihikbn}</td><td>シグナル回避区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SignalkaihiKbn}</td></tr>
 *  <tr><td>{@link #getSonotatknkbn sonotatknkbn}</td><td>その他特認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SonotaTokuninKbn}</td></tr>
 *  <tr><td>{@link #getDrtenkanritodoufukencd drtenkanritodoufukencd}</td><td>代理店管理都道府県コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktsyukbn uktsyukbn}</td><td>受取人種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UktsyuKbn}</td></tr>
 *  <tr><td>{@link #getUktsyurenno uktsyurenno}</td><td>受取人種類別連番</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getUktkbn uktkbn}</td><td>受取人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UktKbn}</td></tr>
 *  <tr><td>{@link #getSeg1cd seg1cd}</td><td>セグメント１コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 * </table>
 * @see     SV_SnkiykGtjSirtData
 * @see     PKSV_SnkiykGtjSirtData
 * @see     QSV_SnkiykGtjSirtData
 * @see     GenQSV_SnkiykGtjSirtData
 */
@MappedSuperclass
@Table(name=GenSV_SnkiykGtjSirtData.TABLE_NAME)
@IdClass(value=PKSV_SnkiykGtjSirtData.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_HaitouKbn", typeClass=UserType_C_HaitouKbn.class),
    @TypeDef(name="UserType_C_HaitoukinuketorihouKbn", typeClass=UserType_C_HaitoukinuketorihouKbn.class),
    @TypeDef(name="UserType_C_Hhknsei", typeClass=UserType_C_Hhknsei.class),
    @TypeDef(name="UserType_C_HknkknsmnKbn", typeClass=UserType_C_HknkknsmnKbn.class),
    @TypeDef(name="UserType_C_HonninkakuninSyoruiKbn", typeClass=UserType_C_HonninkakuninSyoruiKbn.class),
    @TypeDef(name="UserType_C_KakoymdkyytknKbn", typeClass=UserType_C_KakoymdkyytknKbn.class),
    @TypeDef(name="UserType_C_KykKbn", typeClass=UserType_C_KykKbn.class),
    @TypeDef(name="UserType_C_Kykkaksyrui", typeClass=UserType_C_Kykkaksyrui.class),
    @TypeDef(name="UserType_C_Kyksei", typeClass=UserType_C_Kyksei.class),
    @TypeDef(name="UserType_C_NenkkntknKbn", typeClass=UserType_C_NenkkntknKbn.class),
    @TypeDef(name="UserType_C_Nstknsyu", typeClass=UserType_C_Nstknsyu.class),
    @TypeDef(name="UserType_C_SaiteiptknKbn", typeClass=UserType_C_SaiteiptknKbn.class),
    @TypeDef(name="UserType_C_Sdpd", typeClass=UserType_C_Sdpd.class),
    @TypeDef(name="UserType_C_Segcd", typeClass=UserType_C_Segcd.class),
    @TypeDef(name="UserType_C_SeirituKbn", typeClass=UserType_C_SeirituKbn.class),
    @TypeDef(name="UserType_C_SentakuinfotknKbn", typeClass=UserType_C_SentakuinfotknKbn.class),
    @TypeDef(name="UserType_C_SignalkaihiKbn", typeClass=UserType_C_SignalkaihiKbn.class),
    @TypeDef(name="UserType_C_SntkhouKbn", typeClass=UserType_C_SntkhouKbn.class),
    @TypeDef(name="UserType_C_SonotaTokuninKbn", typeClass=UserType_C_SonotaTokuninKbn.class),
    @TypeDef(name="UserType_C_SpgndtknKbn", typeClass=UserType_C_SpgndtknKbn.class),
    @TypeDef(name="UserType_C_SyutkKbn", typeClass=UserType_C_SyutkKbn.class),
    @TypeDef(name="UserType_C_TsngndtknKbn", typeClass=UserType_C_TsngndtknKbn.class),
    @TypeDef(name="UserType_C_UktKbn", typeClass=UserType_C_UktKbn.class),
    @TypeDef(name="UserType_C_UktsyuKbn", typeClass=UserType_C_UktsyuKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenSV_SnkiykGtjSirtData extends AbstractExDBEntity<SV_SnkiykGtjSirtData, PKSV_SnkiykGtjSirtData> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "SV_SnkiykGtjSirtData";
    public static final String RENNO8KETA               = "renno8keta";
    public static final String MOSNO                    = "mosno";
    public static final String SYONO                    = "syono";
    public static final String MOSNRKYMD                = "mosnrkymd";
    public static final String SEIRITUKBN               = "seiritukbn";
    public static final String SRSYORIYMD               = "srsyoriymd";
    public static final String MOSYMD                   = "mosymd";
    public static final String MOSSAKUSEIYMD            = "mossakuseiymd";
    public static final String MOSYM                    = "mosym";
    public static final String KKTYMD                   = "kktymd";
    public static final String KYKYMD                   = "kykymd";
    public static final String SKYKYMD                  = "skykymd";
    public static final String SKNNKAISIYMD             = "sknnkaisiymd";
    public static final String SEISEKIYM                = "seisekiym";
    public static final String SKEIKEIJYOUYM            = "skeikeijyouym";
    public static final String KYKKBN                   = "kykkbn";
    public static final String STDRSKTKYHKUMU           = "stdrsktkyhkumu";
    public static final String SDPDKBN                  = "sdpdkbn";
    public static final String SNTKHOUKBN               = "sntkhoukbn";
    public static final String HAITOUKBN                = "haitoukbn";
    public static final String HAITOUKINUKETORIHOUKBN   = "haitoukinuketorihoukbn";
    public static final String FSTPHRKGK                = "fstphrkgk";
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
    public static final String NSTKSBNSYU               = "nstksbnsyu";
    public static final String NSTKSBNKKN               = "nstksbnkkn";
    public static final String KYKHONNINKAKNINSYORUIKBN = "kykhonninkakninsyoruikbn";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String RYOURITUSDNO             = "ryouritusdno";
    public static final String SYUTKKBN                 = "syutkkbn";
    public static final String YOTEIRIRITU              = "yoteiriritu";
    public static final String SEITOUKIHONS             = "seitoukihons";
    public static final String SYUTKP                   = "syutkp";
    public static final String HKNKKN                   = "hknkkn";
    public static final String HKNKKNSMNKBN             = "hknkknsmnkbn";
    public static final String MOSDAIRITENTBLRENNO      = "mosdairitentblrenno";
    public static final String CIFCD                    = "cifcd";
    public static final String DRTENCD                  = "drtencd";
    public static final String BOSYUUCD                 = "bosyuucd";
    public static final String DAIBOSYUUCD              = "daibosyuucd";
    public static final String DRTENKANRISOSIKICD       = "drtenkanrisosikicd";
    public static final String KYKKAKTBLRENNO           = "kykKaktblrenno";
    public static final String KYKKAKSYRUI              = "kykkaksyrui";
    public static final String NYUUKINTBLRENNO          = "nyuukintblrenno";
    public static final String RYOSYUYMD                = "ryosyuymd";
    public static final String SPGNDTKNKBN              = "spgndtknkbn";
    public static final String NENKKNTKNKBN             = "nenkkntknkbn";
    public static final String TSNGNDTKNKBN             = "tsngndtknkbn";
    public static final String SENTAKUINFOTKNKBN        = "sentakuinfotknkbn";
    public static final String KAKOYMDKYYTKNKBN         = "kakoymdkyytknkbn";
    public static final String SAITEIPTKNKBN            = "saiteiptknkbn";
    public static final String SIGNALKAIHIKBN           = "signalkaihikbn";
    public static final String SONOTATKNKBN             = "sonotatknkbn";
    public static final String DRTENKANRITODOUFUKENCD   = "drtenkanritodoufukencd";
    public static final String UKTSYUKBN                = "uktsyukbn";
    public static final String UKTSYURENNO              = "uktsyurenno";
    public static final String UKTKBN                   = "uktkbn";
    public static final String SEG1CD                   = "seg1cd";

    private final PKSV_SnkiykGtjSirtData primaryKey;

    public GenSV_SnkiykGtjSirtData() {
        primaryKey = new PKSV_SnkiykGtjSirtData();
    }

    public GenSV_SnkiykGtjSirtData(Integer pRenno8keta) {
        primaryKey = new PKSV_SnkiykGtjSirtData(pRenno8keta);
    }

    @Transient
    @Override
    public PKSV_SnkiykGtjSirtData getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QSV_SnkiykGtjSirtData> getMetaClass() {
        return QSV_SnkiykGtjSirtData.class;
    }

    @Id
    @Column(name=GenSV_SnkiykGtjSirtData.RENNO8KETA)
    public Integer getRenno8keta() {
        return getPrimaryKey().getRenno8keta();
    }

    public void setRenno8keta(Integer pRenno8keta) {
        getPrimaryKey().setRenno8keta(pRenno8keta);
    }

    private String mosno;

    @Column(name=GenSV_SnkiykGtjSirtData.MOSNO)
    @Pattern(message="{pattern.MousikomiNo.message}", regex="^[a-zA-Z0-9]{1,11}$")
    public String getMosno() {
        return mosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

    private String syono;

    @Column(name=GenSV_SnkiykGtjSirtData.SYONO)
    @Pattern(message="{pattern.SyoukenNo.message}", regex="^[a-zA-Z0-9]{1,11}$")
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
    @Column(name=GenSV_SnkiykGtjSirtData.MOSNRKYMD)
    public BizDate getMosnrkymd() {
        return mosnrkymd;
    }

    public void setMosnrkymd(BizDate pMosnrkymd) {
        mosnrkymd = pMosnrkymd;
    }

    private C_SeirituKbn seiritukbn;

    @Type(type="UserType_C_SeirituKbn")
    @Column(name=GenSV_SnkiykGtjSirtData.SEIRITUKBN)
    public C_SeirituKbn getSeiritukbn() {
        return seiritukbn;
    }

    public void setSeiritukbn(C_SeirituKbn pSeiritukbn) {
        seiritukbn = pSeiritukbn;
    }

    private BizDate srsyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_SnkiykGtjSirtData.SRSYORIYMD)
    public BizDate getSrsyoriymd() {
        return srsyoriymd;
    }

    public void setSrsyoriymd(BizDate pSrsyoriymd) {
        srsyoriymd = pSrsyoriymd;
    }

    private BizDate mosymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_SnkiykGtjSirtData.MOSYMD)
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
    @Column(name=GenSV_SnkiykGtjSirtData.MOSSAKUSEIYMD)
    public BizDate getMossakuseiymd() {
        return mossakuseiymd;
    }

    @Trim("both")
    public void setMossakuseiymd(BizDate pMossakuseiymd) {
        mossakuseiymd = pMossakuseiymd;
    }

    private BizDateYM mosym;

    @Type(type="BizDateYMType")
    @Column(name=GenSV_SnkiykGtjSirtData.MOSYM)
    public BizDateYM getMosym() {
        return mosym;
    }

    public void setMosym(BizDateYM pMosym) {
        mosym = pMosym;
    }

    private BizDate kktymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_SnkiykGtjSirtData.KKTYMD)
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
    @Column(name=GenSV_SnkiykGtjSirtData.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private BizDate skykymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_SnkiykGtjSirtData.SKYKYMD)
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
    @Column(name=GenSV_SnkiykGtjSirtData.SKNNKAISIYMD)
    public BizDate getSknnkaisiymd() {
        return sknnkaisiymd;
    }

    @Trim("both")
    public void setSknnkaisiymd(BizDate pSknnkaisiymd) {
        sknnkaisiymd = pSknnkaisiymd;
    }

    private BizDateYM seisekiym;

    @Type(type="BizDateYMType")
    @Column(name=GenSV_SnkiykGtjSirtData.SEISEKIYM)
    public BizDateYM getSeisekiym() {
        return seisekiym;
    }

    @Trim("both")
    public void setSeisekiym(BizDateYM pSeisekiym) {
        seisekiym = pSeisekiym;
    }

    private BizDateYM skeikeijyouym;

    @Type(type="BizDateYMType")
    @Column(name=GenSV_SnkiykGtjSirtData.SKEIKEIJYOUYM)
    public BizDateYM getSkeikeijyouym() {
        return skeikeijyouym;
    }

    @Trim("both")
    public void setSkeikeijyouym(BizDateYM pSkeikeijyouym) {
        skeikeijyouym = pSkeikeijyouym;
    }

    private C_KykKbn kykkbn;

    @Type(type="UserType_C_KykKbn")
    @Column(name=GenSV_SnkiykGtjSirtData.KYKKBN)
    public C_KykKbn getKykkbn() {
        return kykkbn;
    }

    public void setKykkbn(C_KykKbn pKykkbn) {
        kykkbn = pKykkbn;
    }

    private C_UmuKbn stdrsktkyhkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenSV_SnkiykGtjSirtData.STDRSKTKYHKUMU)
    public C_UmuKbn getStdrsktkyhkumu() {
        return stdrsktkyhkumu;
    }

    public void setStdrsktkyhkumu(C_UmuKbn pStdrsktkyhkumu) {
        stdrsktkyhkumu = pStdrsktkyhkumu;
    }

    private C_Sdpd sdpdkbn;

    @Type(type="UserType_C_Sdpd")
    @Column(name=GenSV_SnkiykGtjSirtData.SDPDKBN)
    public C_Sdpd getSdpdkbn() {
        return sdpdkbn;
    }

    public void setSdpdkbn(C_Sdpd pSdpdkbn) {
        sdpdkbn = pSdpdkbn;
    }

    private C_SntkhouKbn sntkhoukbn;

    @Type(type="UserType_C_SntkhouKbn")
    @Column(name=GenSV_SnkiykGtjSirtData.SNTKHOUKBN)
    public C_SntkhouKbn getSntkhoukbn() {
        return sntkhoukbn;
    }

    public void setSntkhoukbn(C_SntkhouKbn pSntkhoukbn) {
        sntkhoukbn = pSntkhoukbn;
    }

    private C_HaitouKbn haitoukbn;

    @Type(type="UserType_C_HaitouKbn")
    @Column(name=GenSV_SnkiykGtjSirtData.HAITOUKBN)
    public C_HaitouKbn getHaitoukbn() {
        return haitoukbn;
    }

    public void setHaitoukbn(C_HaitouKbn pHaitoukbn) {
        haitoukbn = pHaitoukbn;
    }

    private C_HaitoukinuketorihouKbn haitoukinuketorihoukbn;

    @Type(type="UserType_C_HaitoukinuketorihouKbn")
    @Column(name=GenSV_SnkiykGtjSirtData.HAITOUKINUKETORIHOUKBN)
    public C_HaitoukinuketorihouKbn getHaitoukinuketorihoukbn() {
        return haitoukinuketorihoukbn;
    }

    public void setHaitoukinuketorihoukbn(C_HaitoukinuketorihouKbn pHaitoukinuketorihoukbn) {
        haitoukinuketorihoukbn = pHaitoukinuketorihoukbn;
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

    private String hhknnmkn;

    @Column(name=GenSV_SnkiykGtjSirtData.HHKNNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknnmkn() {
        return hhknnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkn(String pHhknnmkn) {
        hhknnmkn = pHhknnmkn;
    }

    private String hhknnmkj;

    @Column(name=GenSV_SnkiykGtjSirtData.HHKNNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknnmkj() {
        return hhknnmkj;
    }

    @Trim("right")
    public void setHhknnmkj(String pHhknnmkj) {
        hhknnmkj = pHhknnmkj;
    }

    private BizDate hhknseiymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_SnkiykGtjSirtData.HHKNSEIYMD)
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

    @Column(name=GenSV_SnkiykGtjSirtData.HHKNNEN)
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
    @Column(name=GenSV_SnkiykGtjSirtData.HHKNSEI)
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private String hhknsykgycd;

    @Column(name=GenSV_SnkiykGtjSirtData.HHKNSYKGYCD)
    @MaxLength(max=3)
    @AlphaDigit
    public String getHhknsykgycd() {
        return hhknsykgycd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknsykgycd(String pHhknsykgycd) {
        hhknsykgycd = pHhknsykgycd;
    }

    private String kyknmkn;

    @Column(name=GenSV_SnkiykGtjSirtData.KYKNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    public String getKyknmkn() {
        return kyknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkn(String pKyknmkn) {
        kyknmkn = pKyknmkn;
    }

    private String kyknmkj;

    @Column(name=GenSV_SnkiykGtjSirtData.KYKNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getKyknmkj() {
        return kyknmkj;
    }

    @Trim("right")
    public void setKyknmkj(String pKyknmkj) {
        kyknmkj = pKyknmkj;
    }

    private BizDate kykseiymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_SnkiykGtjSirtData.KYKSEIYMD)
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

    @Column(name=GenSV_SnkiykGtjSirtData.KYKNEN)
    public Integer getKyknen() {
        return kyknen;
    }

    public void setKyknen(Integer pKyknen) {
        kyknen = pKyknen;
    }

    private C_Kyksei kyksei;

    @Type(type="UserType_C_Kyksei")
    @Column(name=GenSV_SnkiykGtjSirtData.KYKSEI)
    public C_Kyksei getKyksei() {
        return kyksei;
    }

    public void setKyksei(C_Kyksei pKyksei) {
        kyksei = pKyksei;
    }

    private String tsinyno;

    @Column(name=GenSV_SnkiykGtjSirtData.TSINYNO)
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

    private C_Nstknsyu nstksbnsyu;

    @Type(type="UserType_C_Nstknsyu")
    @Column(name=GenSV_SnkiykGtjSirtData.NSTKSBNSYU)
    public C_Nstknsyu getNstksbnsyu() {
        return nstksbnsyu;
    }

    public void setNstksbnsyu(C_Nstknsyu pNstksbnsyu) {
        nstksbnsyu = pNstksbnsyu;
    }

    private Integer nstksbnkkn;

    @Column(name=GenSV_SnkiykGtjSirtData.NSTKSBNKKN)
    @Range(min="0", max="99")
    public Integer getNstksbnkkn() {
        return nstksbnkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNstksbnkkn(Integer pNstksbnkkn) {
        nstksbnkkn = pNstksbnkkn;
    }

    private C_HonninkakuninSyoruiKbn kykhonninkakninsyoruikbn;

    @Type(type="UserType_C_HonninkakuninSyoruiKbn")
    @Column(name=GenSV_SnkiykGtjSirtData.KYKHONNINKAKNINSYORUIKBN)
    public C_HonninkakuninSyoruiKbn getKykhonninkakninsyoruikbn() {
        return kykhonninkakninsyoruikbn;
    }

    public void setKykhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn pKykhonninkakninsyoruikbn) {
        kykhonninkakninsyoruikbn = pKykhonninkakninsyoruikbn;
    }

    private String syouhncd;

    @Column(name=GenSV_SnkiykGtjSirtData.SYOUHNCD)
    @MaxLength(max=4)
    @SingleByteStrings
    public String getSyouhncd() {
        return syouhncd;
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }

    private String ryouritusdno;

    @Column(name=GenSV_SnkiykGtjSirtData.RYOURITUSDNO)
    public String getRyouritusdno() {
        return ryouritusdno;
    }

    public void setRyouritusdno(String pRyouritusdno) {
        ryouritusdno = pRyouritusdno;
    }

    private C_SyutkKbn syutkkbn;

    @Type(type="UserType_C_SyutkKbn")
    @Column(name=GenSV_SnkiykGtjSirtData.SYUTKKBN)
    public C_SyutkKbn getSyutkkbn() {
        return syutkkbn;
    }

    public void setSyutkkbn(C_SyutkKbn pSyutkkbn) {
        syutkkbn = pSyutkkbn;
    }

    private BizNumber yoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenSV_SnkiykGtjSirtData.YOTEIRIRITU)
    public BizNumber getYoteiriritu() {
        return yoteiriritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYoteiriritu(BizNumber pYoteiriritu) {
        yoteiriritu = pYoteiriritu;
    }

    private BizCurrency seitoukihons;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSeitoukihons() {
        return seitoukihons;
    }

    public void setSeitoukihons(BizCurrency pSeitoukihons) {
        seitoukihons = pSeitoukihons;
        seitoukihonsValue = null;
        seitoukihonsType  = null;
    }

    transient private BigDecimal seitoukihonsValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SEITOUKIHONS, nullable=true)
    protected BigDecimal getSeitoukihonsValue() {
        if (seitoukihonsValue == null && seitoukihons != null) {
            if (seitoukihons.isOptional()) return null;
            return seitoukihons.absolute();
        }
        return seitoukihonsValue;
    }

    protected void setSeitoukihonsValue(BigDecimal value) {
        seitoukihonsValue = value;
        seitoukihons = Optional.fromNullable(toCurrencyType(seitoukihonsType))
            .transform(bizCurrencyTransformer(getSeitoukihonsValue()))
            .orNull();
    }

    transient private String seitoukihonsType = null;

    @Column(name=SEITOUKIHONS + "$", nullable=true)
    protected String getSeitoukihonsType() {
        if (seitoukihonsType == null && seitoukihons != null) return seitoukihons.getType().toString();
        if (seitoukihonsType == null && getSeitoukihonsValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'seitoukihons$' should not be NULL."));
        }
        return seitoukihonsType;
    }

    protected void setSeitoukihonsType(String type) {
        seitoukihonsType = type;
        seitoukihons = Optional.fromNullable(toCurrencyType(seitoukihonsType))
            .transform(bizCurrencyTransformer(getSeitoukihonsValue()))
            .orNull();
    }

    private BizCurrency syutkp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSyutkp() {
        return syutkp;
    }

    public void setSyutkp(BizCurrency pSyutkp) {
        syutkp = pSyutkp;
        syutkpValue = null;
        syutkpType  = null;
    }

    transient private BigDecimal syutkpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SYUTKP, nullable=true)
    protected BigDecimal getSyutkpValue() {
        if (syutkpValue == null && syutkp != null) {
            if (syutkp.isOptional()) return null;
            return syutkp.absolute();
        }
        return syutkpValue;
    }

    protected void setSyutkpValue(BigDecimal value) {
        syutkpValue = value;
        syutkp = Optional.fromNullable(toCurrencyType(syutkpType))
            .transform(bizCurrencyTransformer(getSyutkpValue()))
            .orNull();
    }

    transient private String syutkpType = null;

    @Column(name=SYUTKP + "$", nullable=true)
    protected String getSyutkpType() {
        if (syutkpType == null && syutkp != null) return syutkp.getType().toString();
        if (syutkpType == null && getSyutkpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'syutkp$' should not be NULL."));
        }
        return syutkpType;
    }

    protected void setSyutkpType(String type) {
        syutkpType = type;
        syutkp = Optional.fromNullable(toCurrencyType(syutkpType))
            .transform(bizCurrencyTransformer(getSyutkpValue()))
            .orNull();
    }

    private Integer hknkkn;

    @Column(name=GenSV_SnkiykGtjSirtData.HKNKKN)
    @Range(min="0", max="99")
    public Integer getHknkkn() {
        return hknkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHknkkn(Integer pHknkkn) {
        hknkkn = pHknkkn;
    }

    private C_HknkknsmnKbn hknkknsmnkbn;

    @Type(type="UserType_C_HknkknsmnKbn")
    @Column(name=GenSV_SnkiykGtjSirtData.HKNKKNSMNKBN)
    public C_HknkknsmnKbn getHknkknsmnkbn() {
        return hknkknsmnkbn;
    }

    public void setHknkknsmnkbn(C_HknkknsmnKbn pHknkknsmnkbn) {
        hknkknsmnkbn = pHknkknsmnkbn;
    }

    private Integer mosdairitentblrenno;

    @Column(name=GenSV_SnkiykGtjSirtData.MOSDAIRITENTBLRENNO)
    public Integer getMosdairitentblrenno() {
        return mosdairitentblrenno;
    }

    public void setMosdairitentblrenno(Integer pMosdairitentblrenno) {
        mosdairitentblrenno = pMosdairitentblrenno;
    }

    private String cifcd;

    @Column(name=GenSV_SnkiykGtjSirtData.CIFCD)
    @MaxLength(max=15)
    @AlphaDigit
    public String getCifcd() {
        return cifcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCifcd(String pCifcd) {
        cifcd = pCifcd;
    }

    private String drtencd;

    @Column(name=GenSV_SnkiykGtjSirtData.DRTENCD)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDrtencd() {
        return drtencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtencd(String pDrtencd) {
        drtencd = pDrtencd;
    }

    private String bosyuucd;

    @Column(name=GenSV_SnkiykGtjSirtData.BOSYUUCD)
    @MaxLength(max=6)
    @AlphaDigit
    public String getBosyuucd() {
        return bosyuucd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuucd(String pBosyuucd) {
        bosyuucd = pBosyuucd;
    }

    private String daibosyuucd;

    @Column(name=GenSV_SnkiykGtjSirtData.DAIBOSYUUCD)
    public String getDaibosyuucd() {
        return daibosyuucd;
    }

    public void setDaibosyuucd(String pDaibosyuucd) {
        daibosyuucd = pDaibosyuucd;
    }

    private String drtenkanrisosikicd;

    @Column(name=GenSV_SnkiykGtjSirtData.DRTENKANRISOSIKICD)
    public String getDrtenkanrisosikicd() {
        return drtenkanrisosikicd;
    }

    public void setDrtenkanrisosikicd(String pDrtenkanrisosikicd) {
        drtenkanrisosikicd = pDrtenkanrisosikicd;
    }

    private Integer kykKaktblrenno;

    @Column(name=GenSV_SnkiykGtjSirtData.KYKKAKTBLRENNO)
    public Integer getKykKaktblrenno() {
        return kykKaktblrenno;
    }

    public void setKykKaktblrenno(Integer pKykKaktblrenno) {
        kykKaktblrenno = pKykKaktblrenno;
    }

    private C_Kykkaksyrui kykkaksyrui;

    @Type(type="UserType_C_Kykkaksyrui")
    @Column(name=GenSV_SnkiykGtjSirtData.KYKKAKSYRUI)
    public C_Kykkaksyrui getKykkaksyrui() {
        return kykkaksyrui;
    }

    public void setKykkaksyrui(C_Kykkaksyrui pKykkaksyrui) {
        kykkaksyrui = pKykkaksyrui;
    }

    private Integer nyuukintblrenno;

    @Column(name=GenSV_SnkiykGtjSirtData.NYUUKINTBLRENNO)
    public Integer getNyuukintblrenno() {
        return nyuukintblrenno;
    }

    public void setNyuukintblrenno(Integer pNyuukintblrenno) {
        nyuukintblrenno = pNyuukintblrenno;
    }

    private BizDate ryosyuymd;

    @Type(type="BizDateType")
    @Column(name=GenSV_SnkiykGtjSirtData.RYOSYUYMD)
    @ValidDate
    public BizDate getRyosyuymd() {
        return ryosyuymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRyosyuymd(BizDate pRyosyuymd) {
        ryosyuymd = pRyosyuymd;
    }

    private C_SpgndtknKbn spgndtknkbn;

    @Type(type="UserType_C_SpgndtknKbn")
    @Column(name=GenSV_SnkiykGtjSirtData.SPGNDTKNKBN)
    public C_SpgndtknKbn getSpgndtknkbn() {
        return spgndtknkbn;
    }

    public void setSpgndtknkbn(C_SpgndtknKbn pSpgndtknkbn) {
        spgndtknkbn = pSpgndtknkbn;
    }

    private C_NenkkntknKbn nenkkntknkbn;

    @Type(type="UserType_C_NenkkntknKbn")
    @Column(name=GenSV_SnkiykGtjSirtData.NENKKNTKNKBN)
    public C_NenkkntknKbn getNenkkntknkbn() {
        return nenkkntknkbn;
    }

    public void setNenkkntknkbn(C_NenkkntknKbn pNenkkntknkbn) {
        nenkkntknkbn = pNenkkntknkbn;
    }

    private C_TsngndtknKbn tsngndtknkbn;

    @Type(type="UserType_C_TsngndtknKbn")
    @Column(name=GenSV_SnkiykGtjSirtData.TSNGNDTKNKBN)
    public C_TsngndtknKbn getTsngndtknkbn() {
        return tsngndtknkbn;
    }

    public void setTsngndtknkbn(C_TsngndtknKbn pTsngndtknkbn) {
        tsngndtknkbn = pTsngndtknkbn;
    }

    private C_SentakuinfotknKbn sentakuinfotknkbn;

    @Type(type="UserType_C_SentakuinfotknKbn")
    @Column(name=GenSV_SnkiykGtjSirtData.SENTAKUINFOTKNKBN)
    public C_SentakuinfotknKbn getSentakuinfotknkbn() {
        return sentakuinfotknkbn;
    }

    public void setSentakuinfotknkbn(C_SentakuinfotknKbn pSentakuinfotknkbn) {
        sentakuinfotknkbn = pSentakuinfotknkbn;
    }

    private C_KakoymdkyytknKbn kakoymdkyytknkbn;

    @Type(type="UserType_C_KakoymdkyytknKbn")
    @Column(name=GenSV_SnkiykGtjSirtData.KAKOYMDKYYTKNKBN)
    public C_KakoymdkyytknKbn getKakoymdkyytknkbn() {
        return kakoymdkyytknkbn;
    }

    public void setKakoymdkyytknkbn(C_KakoymdkyytknKbn pKakoymdkyytknkbn) {
        kakoymdkyytknkbn = pKakoymdkyytknkbn;
    }

    private C_SaiteiptknKbn saiteiptknkbn;

    @Type(type="UserType_C_SaiteiptknKbn")
    @Column(name=GenSV_SnkiykGtjSirtData.SAITEIPTKNKBN)
    public C_SaiteiptknKbn getSaiteiptknkbn() {
        return saiteiptknkbn;
    }

    public void setSaiteiptknkbn(C_SaiteiptknKbn pSaiteiptknkbn) {
        saiteiptknkbn = pSaiteiptknkbn;
    }

    private C_SignalkaihiKbn signalkaihikbn;

    @Type(type="UserType_C_SignalkaihiKbn")
    @Column(name=GenSV_SnkiykGtjSirtData.SIGNALKAIHIKBN)
    public C_SignalkaihiKbn getSignalkaihikbn() {
        return signalkaihikbn;
    }

    public void setSignalkaihikbn(C_SignalkaihiKbn pSignalkaihikbn) {
        signalkaihikbn = pSignalkaihikbn;
    }

    private C_SonotaTokuninKbn sonotatknkbn;

    @Type(type="UserType_C_SonotaTokuninKbn")
    @Column(name=GenSV_SnkiykGtjSirtData.SONOTATKNKBN)
    public C_SonotaTokuninKbn getSonotatknkbn() {
        return sonotatknkbn;
    }

    public void setSonotatknkbn(C_SonotaTokuninKbn pSonotatknkbn) {
        sonotatknkbn = pSonotatknkbn;
    }

    private String drtenkanritodoufukencd;

    @Column(name=GenSV_SnkiykGtjSirtData.DRTENKANRITODOUFUKENCD)
    public String getDrtenkanritodoufukencd() {
        return drtenkanritodoufukencd;
    }

    public void setDrtenkanritodoufukencd(String pDrtenkanritodoufukencd) {
        drtenkanritodoufukencd = pDrtenkanritodoufukencd;
    }

    private C_UktsyuKbn uktsyukbn;

    @Type(type="UserType_C_UktsyuKbn")
    @Column(name=GenSV_SnkiykGtjSirtData.UKTSYUKBN)
    public C_UktsyuKbn getUktsyukbn() {
        return uktsyukbn;
    }

    public void setUktsyukbn(C_UktsyuKbn pUktsyukbn) {
        uktsyukbn = pUktsyukbn;
    }

    private Integer uktsyurenno;

    @Column(name=GenSV_SnkiykGtjSirtData.UKTSYURENNO)
    public Integer getUktsyurenno() {
        return uktsyurenno;
    }

    public void setUktsyurenno(Integer pUktsyurenno) {
        uktsyurenno = pUktsyurenno;
    }

    private C_UktKbn uktkbn;

    @Type(type="UserType_C_UktKbn")
    @Column(name=GenSV_SnkiykGtjSirtData.UKTKBN)
    public C_UktKbn getUktkbn() {
        return uktkbn;
    }

    public void setUktkbn(C_UktKbn pUktkbn) {
        uktkbn = pUktkbn;
    }

    private C_Segcd seg1cd;

    @Type(type="UserType_C_Segcd")
    @Column(name=GenSV_SnkiykGtjSirtData.SEG1CD)
    public C_Segcd getSeg1cd() {
        return seg1cd;
    }

    public void setSeg1cd(C_Segcd pSeg1cd) {
        seg1cd = pSeg1cd;
    }
}
