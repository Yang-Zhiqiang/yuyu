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
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_BosyuuDairitenAtkiKeitaiKbn;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_IjitoukeiKaijyoKbn;
import yuyu.def.classification.C_IjitoukeiTikShrTkykKbn;
import yuyu.def.classification.C_IjitoukeiZennouKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_KituenKbn;
import yuyu.def.classification.C_KokutiKbn;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.classification.C_SirajiKykKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_IjitoukeiMeisai;
import yuyu.def.db.id.PKHT_IjitoukeiMeisai;
import yuyu.def.db.meta.GenQHT_IjitoukeiMeisai;
import yuyu.def.db.meta.QHT_IjitoukeiMeisai;
import yuyu.def.db.type.UserType_C_BosyuuDairitenAtkiKeitaiKbn;
import yuyu.def.db.type.UserType_C_HaitoukinuketorihouKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_IjitoukeiKaijyoKbn;
import yuyu.def.db.type.UserType_C_IjitoukeiTikShrTkykKbn;
import yuyu.def.db.type.UserType_C_IjitoukeiZennouKbn;
import yuyu.def.db.type.UserType_C_Ketkekkacd;
import yuyu.def.db.type.UserType_C_KituenKbn;
import yuyu.def.db.type.UserType_C_KokutiKbn;
import yuyu.def.db.type.UserType_C_NensyuuKbn;
import yuyu.def.db.type.UserType_C_SirajiKykKbn;
import yuyu.def.db.type.UserType_C_SkeijimuKbn;
import yuyu.def.db.type.UserType_C_SntkhouKbn;
import yuyu.def.db.type.UserType_C_Tkhukaumu;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 医事統計明細テーブル テーブルのマッピング情報クラスで、 {@link HT_IjitoukeiMeisai} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_IjitoukeiMeisai}</td><td colspan="3">医事統計明細テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKHT_IjitoukeiMeisai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno8keta renno8keta}</td><td>連番（８桁）</td><td align="center">{@link PKHT_IjitoukeiMeisai ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getBosyuuym bosyuuym}</td><td>募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSknnkaisiymd sknnkaisiymd}</td><td>責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyoumetuymd syoumetuymd}</td><td>消滅日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrymd shrymd}</td><td>支払日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getIdousyoriymd idousyoriymd}</td><td>異動処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSntkhoukbn sntkhoukbn}</td><td>選択方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SntkhouKbn}</td></tr>
 *  <tr><td>{@link #getKokutikbn kokutikbn}</td><td>告知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KokutiKbn}</td></tr>
 *  <tr><td>{@link #getSkeijimukbn skeijimukbn}</td><td>新契約事務区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SkeijimuKbn}</td></tr>
 *  <tr><td>{@link #getSirajikykkbn sirajikykkbn}</td><td>白地契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SirajiKykKbn}</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getHaitoukinuketorihoukbn haitoukinuketorihoukbn}</td><td>配当金受取方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HaitoukinuketorihouKbn}</td></tr>
 *  <tr><td>{@link #getOyadrtencd oyadrtencd}</td><td>親代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAatsukaishasoshikicd aatsukaishasoshikicd}</td><td>Ａ扱者組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAatukaikojincd aatukaikojincd}</td><td>Ａ扱者個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTratkiagcd tratkiagcd}</td><td>取扱代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuudairitenatkikeitaikbn bosyuudairitenatkikeitaikbn}</td><td>募集代理店扱形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BosyuuDairitenAtkiKeitaiKbn}</td></tr>
 *  <tr><td>{@link #getHhknnen hhknnen}</td><td>被保険者年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHhknsei hhknsei}</td><td>被保険者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hhknsei}</td></tr>
 *  <tr><td>{@link #getHhknyno hhknyno}</td><td>被保険者郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhkntodouhukencd hhkntodouhukencd}</td><td>被保険者都道府県コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnensyuukbn hhknnensyuukbn}</td><td>被保険者年収区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NensyuuKbn}</td></tr>
 *  <tr><td>{@link #getHhknsykgycd hhknsykgycd}</td><td>被保険者職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSintyou sintyou}</td><td>身長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTaijyuu taijyuu}</td><td>体重</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKituenkbn kituenkbn}</td><td>喫煙区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KituenKbn}</td></tr>
 *  <tr><td>{@link #getKituenhon kituenhon}</td><td>喫煙本数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getHrktuukasyu hrktuukasyu}</td><td>払込通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSeitoukihons seitoukihons}</td><td>正当基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSeitoukihonsmanen seitoukihonsmanen}</td><td>正当基本Ｓ（万円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyutkp syutkp}</td><td>主契約・特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyutkpmanen syutkpmanen}</td><td>主契約・特約Ｐ（万円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getImustiyusbus imustiyusbus}</td><td>医務査定用死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getImustiyusbusmanen imustiyusbusmanen}</td><td>医務査定用死亡Ｓ（万円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkansantkykwsrate yenkansantkykwsrate}</td><td>円換算適用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSyoubyoucd1 syoubyoucd1}</td><td>傷病コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoubyoucd2 syoubyoucd2}</td><td>傷病コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDakuhiktkekkacd dakuhiktkekkacd}</td><td>諾否決定結果コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Ketkekkacd}</td></tr>
 *  <tr><td>{@link #getDakuhiketsyacd dakuhiketsyacd}</td><td>諾否決定者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPalketsyacd palketsyacd}</td><td>ＰＡＬ決定者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyksbyensitihsyutkhkkbn syksbyensitihsyutkhkkbn}</td><td>初期死亡時円換算最低保証特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkhukaumu}</td></tr>
 *  <tr><td>{@link #getJyudkaigomehrtkhkkbn jyudkaigomehrtkhkkbn}</td><td>重度介護前払特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkhukaumu}</td></tr>
 *  <tr><td>{@link #getSymtgenincd symtgenincd}</td><td>消滅原因コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getSiincd siincd}</td><td>死因コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIjitoukeikaijyokbn ijitoukeikaijyokbn}</td><td>医事統計解除区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_IjitoukeiKaijyoKbn}</td></tr>
 *  <tr><td>{@link #getSysnikoujiym sysnikoujiym}</td><td>終身移行時年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getIjitoukeizennoukbn ijitoukeizennoukbn}</td><td>医事統計用前納区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_IjitoukeiZennouKbn}</td></tr>
 *  <tr><td>{@link #getHrkkeiro hrkkeiro}</td><td>払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getTikiktbrisyuruikbn tikiktbrisyuruikbn}</td><td>定期一括払種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>{@link #getJissituhosyous jissituhosyous}</td><td>実質保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getJissituhosyousmanen jissituhosyousmanen}</td><td>実質保障Ｓ（万円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1hknkkn dai1hknkkn}</td><td>第１保険期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getIjitoukeitikshrtkykkbn ijitoukeitikshrtkykkbn}</td><td>医事統計用定期支払特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_IjitoukeiTikShrTkykKbn}</td></tr>
 *  <tr><td>{@link #getTeikisiharaikin teikisiharaikin}</td><td>定期支払金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTeikisiharaikinmanen teikisiharaikinmanen}</td><td>定期支払金（万円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_IjitoukeiMeisai
 * @see     PKHT_IjitoukeiMeisai
 * @see     QHT_IjitoukeiMeisai
 * @see     GenQHT_IjitoukeiMeisai
 */
@MappedSuperclass
@Table(name=GenHT_IjitoukeiMeisai.TABLE_NAME)
@IdClass(value=PKHT_IjitoukeiMeisai.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_BosyuuDairitenAtkiKeitaiKbn", typeClass=UserType_C_BosyuuDairitenAtkiKeitaiKbn.class),
    @TypeDef(name="UserType_C_HaitoukinuketorihouKbn", typeClass=UserType_C_HaitoukinuketorihouKbn.class),
    @TypeDef(name="UserType_C_Hhknsei", typeClass=UserType_C_Hhknsei.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_IjitoukeiKaijyoKbn", typeClass=UserType_C_IjitoukeiKaijyoKbn.class),
    @TypeDef(name="UserType_C_IjitoukeiTikShrTkykKbn", typeClass=UserType_C_IjitoukeiTikShrTkykKbn.class),
    @TypeDef(name="UserType_C_IjitoukeiZennouKbn", typeClass=UserType_C_IjitoukeiZennouKbn.class),
    @TypeDef(name="UserType_C_Ketkekkacd", typeClass=UserType_C_Ketkekkacd.class),
    @TypeDef(name="UserType_C_KituenKbn", typeClass=UserType_C_KituenKbn.class),
    @TypeDef(name="UserType_C_KokutiKbn", typeClass=UserType_C_KokutiKbn.class),
    @TypeDef(name="UserType_C_NensyuuKbn", typeClass=UserType_C_NensyuuKbn.class),
    @TypeDef(name="UserType_C_SirajiKykKbn", typeClass=UserType_C_SirajiKykKbn.class),
    @TypeDef(name="UserType_C_SkeijimuKbn", typeClass=UserType_C_SkeijimuKbn.class),
    @TypeDef(name="UserType_C_SntkhouKbn", typeClass=UserType_C_SntkhouKbn.class),
    @TypeDef(name="UserType_C_Tkhukaumu", typeClass=UserType_C_Tkhukaumu.class),
    @TypeDef(name="UserType_C_TkiktbrisyuruiKbn", typeClass=UserType_C_TkiktbrisyuruiKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenHT_IjitoukeiMeisai extends AbstractExDBEntity<HT_IjitoukeiMeisai, PKHT_IjitoukeiMeisai> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_IjitoukeiMeisai";
    public static final String SYONO                    = "syono";
    public static final String RENNO8KETA               = "renno8keta";
    public static final String BOSYUUYM                 = "bosyuuym";
    public static final String KYKYMD                   = "kykymd";
    public static final String SKNNKAISIYMD             = "sknnkaisiymd";
    public static final String SYOUMETUYMD              = "syoumetuymd";
    public static final String SHRYMD                   = "shrymd";
    public static final String IDOUSYORIYMD             = "idousyoriymd";
    public static final String SNTKHOUKBN               = "sntkhoukbn";
    public static final String KOKUTIKBN                = "kokutikbn";
    public static final String SKEIJIMUKBN              = "skeijimukbn";
    public static final String SIRAJIKYKKBN             = "sirajikykkbn";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String HAITOUKINUKETORIHOUKBN   = "haitoukinuketorihoukbn";
    public static final String OYADRTENCD               = "oyadrtencd";
    public static final String AATSUKAISHASOSHIKICD     = "aatsukaishasoshikicd";
    public static final String AATUKAIKOJINCD           = "aatukaikojincd";
    public static final String TRATKIAGCD               = "tratkiagcd";
    public static final String BOSYUUDAIRITENATKIKEITAIKBN = "bosyuudairitenatkikeitaikbn";
    public static final String HHKNNEN                  = "hhknnen";
    public static final String HHKNSEI                  = "hhknsei";
    public static final String HHKNYNO                  = "hhknyno";
    public static final String HHKNTODOUHUKENCD         = "hhkntodouhukencd";
    public static final String HHKNNENSYUUKBN           = "hhknnensyuukbn";
    public static final String HHKNSYKGYCD              = "hhknsykgycd";
    public static final String SINTYOU                  = "sintyou";
    public static final String TAIJYUU                  = "taijyuu";
    public static final String KITUENKBN                = "kituenkbn";
    public static final String KITUENHON                = "kituenhon";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String HRKTUUKASYU              = "hrktuukasyu";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String SEITOUKIHONS             = "seitoukihons";
    public static final String SEITOUKIHONSMANEN        = "seitoukihonsmanen";
    public static final String SYUTKP                   = "syutkp";
    public static final String SYUTKPMANEN              = "syutkpmanen";
    public static final String IMUSTIYUSBUS             = "imustiyusbus";
    public static final String IMUSTIYUSBUSMANEN        = "imustiyusbusmanen";
    public static final String YENKANSANTKYKWSRATE      = "yenkansantkykwsrate";
    public static final String SYOUBYOUCD1              = "syoubyoucd1";
    public static final String SYOUBYOUCD2              = "syoubyoucd2";
    public static final String DAKUHIKTKEKKACD          = "dakuhiktkekkacd";
    public static final String DAKUHIKETSYACD           = "dakuhiketsyacd";
    public static final String PALKETSYACD              = "palketsyacd";
    public static final String SYKSBYENSITIHSYUTKHKKBN  = "syksbyensitihsyutkhkkbn";
    public static final String JYUDKAIGOMEHRTKHKKBN     = "jyudkaigomehrtkhkkbn";
    public static final String SYMTGENINCD              = "symtgenincd";
    public static final String SIINCD                   = "siincd";
    public static final String IJITOUKEIKAIJYOKBN       = "ijitoukeikaijyokbn";
    public static final String SYSNIKOUJIYM             = "sysnikoujiym";
    public static final String IJITOUKEIZENNOUKBN       = "ijitoukeizennoukbn";
    public static final String HRKKEIRO                 = "hrkkeiro";
    public static final String TIKIKTBRISYURUIKBN       = "tikiktbrisyuruikbn";
    public static final String JISSITUHOSYOUS           = "jissituhosyous";
    public static final String JISSITUHOSYOUSMANEN      = "jissituhosyousmanen";
    public static final String DAI1HKNKKN               = "dai1hknkkn";
    public static final String IJITOUKEITIKSHRTKYKKBN   = "ijitoukeitikshrtkykkbn";
    public static final String TEIKISIHARAIKIN          = "teikisiharaikin";
    public static final String TEIKISIHARAIKINMANEN     = "teikisiharaikinmanen";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_IjitoukeiMeisai primaryKey;

    public GenHT_IjitoukeiMeisai() {
        primaryKey = new PKHT_IjitoukeiMeisai();
    }

    public GenHT_IjitoukeiMeisai(String pSyono, Integer pRenno8keta) {
        primaryKey = new PKHT_IjitoukeiMeisai(pSyono, pRenno8keta);
    }

    @Transient
    @Override
    public PKHT_IjitoukeiMeisai getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_IjitoukeiMeisai> getMetaClass() {
        return QHT_IjitoukeiMeisai.class;
    }

    @Id
    @Column(name=GenHT_IjitoukeiMeisai.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    @Id
    @Column(name=GenHT_IjitoukeiMeisai.RENNO8KETA)
    public Integer getRenno8keta() {
        return getPrimaryKey().getRenno8keta();
    }

    public void setRenno8keta(Integer pRenno8keta) {
        getPrimaryKey().setRenno8keta(pRenno8keta);
    }

    private BizDateYM bosyuuym;

    @Type(type="BizDateYMType")
    @Column(name=GenHT_IjitoukeiMeisai.BOSYUUYM)
    @ValidDateYm
    public BizDateYM getBosyuuym() {
        return bosyuuym;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuuym(BizDateYM pBosyuuym) {
        bosyuuym = pBosyuuym;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_IjitoukeiMeisai.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private BizDate sknnkaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_IjitoukeiMeisai.SKNNKAISIYMD)
    public BizDate getSknnkaisiymd() {
        return sknnkaisiymd;
    }

    @Trim("both")
    public void setSknnkaisiymd(BizDate pSknnkaisiymd) {
        sknnkaisiymd = pSknnkaisiymd;
    }

    private BizDate syoumetuymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_IjitoukeiMeisai.SYOUMETUYMD)
    public BizDate getSyoumetuymd() {
        return syoumetuymd;
    }

    @Trim("both")
    public void setSyoumetuymd(BizDate pSyoumetuymd) {
        syoumetuymd = pSyoumetuymd;
    }

    private BizDate shrymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_IjitoukeiMeisai.SHRYMD)
    @ValidDate
    public BizDate getShrymd() {
        return shrymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrymd(BizDate pShrymd) {
        shrymd = pShrymd;
    }

    private BizDate idousyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_IjitoukeiMeisai.IDOUSYORIYMD)
    @ValidDate
    public BizDate getIdousyoriymd() {
        return idousyoriymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setIdousyoriymd(BizDate pIdousyoriymd) {
        idousyoriymd = pIdousyoriymd;
    }

    private C_SntkhouKbn sntkhoukbn;

    @Type(type="UserType_C_SntkhouKbn")
    @Column(name=GenHT_IjitoukeiMeisai.SNTKHOUKBN)
    public C_SntkhouKbn getSntkhoukbn() {
        return sntkhoukbn;
    }

    public void setSntkhoukbn(C_SntkhouKbn pSntkhoukbn) {
        sntkhoukbn = pSntkhoukbn;
    }

    private C_KokutiKbn kokutikbn;

    @Type(type="UserType_C_KokutiKbn")
    @Column(name=GenHT_IjitoukeiMeisai.KOKUTIKBN)
    public C_KokutiKbn getKokutikbn() {
        return kokutikbn;
    }

    public void setKokutikbn(C_KokutiKbn pKokutikbn) {
        kokutikbn = pKokutikbn;
    }

    private C_SkeijimuKbn skeijimukbn;

    @Type(type="UserType_C_SkeijimuKbn")
    @Column(name=GenHT_IjitoukeiMeisai.SKEIJIMUKBN)
    public C_SkeijimuKbn getSkeijimukbn() {
        return skeijimukbn;
    }

    public void setSkeijimukbn(C_SkeijimuKbn pSkeijimukbn) {
        skeijimukbn = pSkeijimukbn;
    }

    private C_SirajiKykKbn sirajikykkbn;

    @Type(type="UserType_C_SirajiKykKbn")
    @Column(name=GenHT_IjitoukeiMeisai.SIRAJIKYKKBN)
    public C_SirajiKykKbn getSirajikykkbn() {
        return sirajikykkbn;
    }

    public void setSirajikykkbn(C_SirajiKykKbn pSirajikykkbn) {
        sirajikykkbn = pSirajikykkbn;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenHT_IjitoukeiMeisai.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_HaitoukinuketorihouKbn haitoukinuketorihoukbn;

    @Type(type="UserType_C_HaitoukinuketorihouKbn")
    @Column(name=GenHT_IjitoukeiMeisai.HAITOUKINUKETORIHOUKBN)
    public C_HaitoukinuketorihouKbn getHaitoukinuketorihoukbn() {
        return haitoukinuketorihoukbn;
    }

    public void setHaitoukinuketorihoukbn(C_HaitoukinuketorihouKbn pHaitoukinuketorihoukbn) {
        haitoukinuketorihoukbn = pHaitoukinuketorihoukbn;
    }

    private String oyadrtencd;

    @Column(name=GenHT_IjitoukeiMeisai.OYADRTENCD)
    @SingleByteStrings
    @AlphaDigit
    public String getOyadrtencd() {
        return oyadrtencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOyadrtencd(String pOyadrtencd) {
        oyadrtencd = pOyadrtencd;
    }

    private String aatsukaishasoshikicd;

    @Column(name=GenHT_IjitoukeiMeisai.AATSUKAISHASOSHIKICD)
    public String getAatsukaishasoshikicd() {
        return aatsukaishasoshikicd;
    }

    public void setAatsukaishasoshikicd(String pAatsukaishasoshikicd) {
        aatsukaishasoshikicd = pAatsukaishasoshikicd;
    }

    private String aatukaikojincd;

    @Column(name=GenHT_IjitoukeiMeisai.AATUKAIKOJINCD)
    public String getAatukaikojincd() {
        return aatukaikojincd;
    }

    public void setAatukaikojincd(String pAatukaikojincd) {
        aatukaikojincd = pAatukaikojincd;
    }

    private String tratkiagcd;

    @Column(name=GenHT_IjitoukeiMeisai.TRATKIAGCD)
    public String getTratkiagcd() {
        return tratkiagcd;
    }

    public void setTratkiagcd(String pTratkiagcd) {
        tratkiagcd = pTratkiagcd;
    }

    private C_BosyuuDairitenAtkiKeitaiKbn bosyuudairitenatkikeitaikbn;

    @Type(type="UserType_C_BosyuuDairitenAtkiKeitaiKbn")
    @Column(name=GenHT_IjitoukeiMeisai.BOSYUUDAIRITENATKIKEITAIKBN)
    public C_BosyuuDairitenAtkiKeitaiKbn getBosyuudairitenatkikeitaikbn() {
        return bosyuudairitenatkikeitaikbn;
    }

    public void setBosyuudairitenatkikeitaikbn(C_BosyuuDairitenAtkiKeitaiKbn pBosyuudairitenatkikeitaikbn) {
        bosyuudairitenatkikeitaikbn = pBosyuudairitenatkikeitaikbn;
    }

    private Integer hhknnen;

    @Column(name=GenHT_IjitoukeiMeisai.HHKNNEN)
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
    @Column(name=GenHT_IjitoukeiMeisai.HHKNSEI)
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private String hhknyno;

    @Column(name=GenHT_IjitoukeiMeisai.HHKNYNO)
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

    private String hhkntodouhukencd;

    @Column(name=GenHT_IjitoukeiMeisai.HHKNTODOUHUKENCD)
    public String getHhkntodouhukencd() {
        return hhkntodouhukencd;
    }

    public void setHhkntodouhukencd(String pHhkntodouhukencd) {
        hhkntodouhukencd = pHhkntodouhukencd;
    }

    private C_NensyuuKbn hhknnensyuukbn;

    @Type(type="UserType_C_NensyuuKbn")
    @Column(name=GenHT_IjitoukeiMeisai.HHKNNENSYUUKBN)
    public C_NensyuuKbn getHhknnensyuukbn() {
        return hhknnensyuukbn;
    }

    public void setHhknnensyuukbn(C_NensyuuKbn pHhknnensyuukbn) {
        hhknnensyuukbn = pHhknnensyuukbn;
    }

    private String hhknsykgycd;

    @Column(name=GenHT_IjitoukeiMeisai.HHKNSYKGYCD)
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

    private Integer sintyou;

    @Column(name=GenHT_IjitoukeiMeisai.SINTYOU)
    @Range(min="0", max="999")
    public Integer getSintyou() {
        return sintyou;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSintyou(Integer pSintyou) {
        sintyou = pSintyou;
    }

    private Integer taijyuu;

    @Column(name=GenHT_IjitoukeiMeisai.TAIJYUU)
    @Range(min="0", max="999")
    public Integer getTaijyuu() {
        return taijyuu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTaijyuu(Integer pTaijyuu) {
        taijyuu = pTaijyuu;
    }

    private C_KituenKbn kituenkbn;

    @Type(type="UserType_C_KituenKbn")
    @Column(name=GenHT_IjitoukeiMeisai.KITUENKBN)
    public C_KituenKbn getKituenkbn() {
        return kituenkbn;
    }

    public void setKituenkbn(C_KituenKbn pKituenkbn) {
        kituenkbn = pKituenkbn;
    }

    private Integer kituenhon;

    @Column(name=GenHT_IjitoukeiMeisai.KITUENHON)
    @Range(min="0", max="99")
    public Integer getKituenhon() {
        return kituenhon;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKituenhon(Integer pKituenhon) {
        kituenhon = pKituenhon;
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHT_IjitoukeiMeisai.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private C_Tuukasyu hrktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHT_IjitoukeiMeisai.HRKTUUKASYU)
    public C_Tuukasyu getHrktuukasyu() {
        return hrktuukasyu;
    }

    public void setHrktuukasyu(C_Tuukasyu pHrktuukasyu) {
        hrktuukasyu = pHrktuukasyu;
    }

    private String syouhncd;

    @Column(name=GenHT_IjitoukeiMeisai.SYOUHNCD)
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

    private Integer syouhnsdno;

    @Column(name=GenHT_IjitoukeiMeisai.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return syouhnsdno;
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        syouhnsdno = pSyouhnsdno;
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

    private BizCurrency seitoukihonsmanen;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSeitoukihonsmanen() {
        return seitoukihonsmanen;
    }

    public void setSeitoukihonsmanen(BizCurrency pSeitoukihonsmanen) {
        seitoukihonsmanen = pSeitoukihonsmanen;
        seitoukihonsmanenValue = null;
        seitoukihonsmanenType  = null;
    }

    transient private BigDecimal seitoukihonsmanenValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SEITOUKIHONSMANEN, nullable=true)
    protected BigDecimal getSeitoukihonsmanenValue() {
        if (seitoukihonsmanenValue == null && seitoukihonsmanen != null) {
            if (seitoukihonsmanen.isOptional()) return null;
            return seitoukihonsmanen.absolute();
        }
        return seitoukihonsmanenValue;
    }

    protected void setSeitoukihonsmanenValue(BigDecimal value) {
        seitoukihonsmanenValue = value;
        seitoukihonsmanen = Optional.fromNullable(toCurrencyType(seitoukihonsmanenType))
            .transform(bizCurrencyTransformer(getSeitoukihonsmanenValue()))
            .orNull();
    }

    transient private String seitoukihonsmanenType = null;

    @Column(name=SEITOUKIHONSMANEN + "$", nullable=true)
    protected String getSeitoukihonsmanenType() {
        if (seitoukihonsmanenType == null && seitoukihonsmanen != null) return seitoukihonsmanen.getType().toString();
        if (seitoukihonsmanenType == null && getSeitoukihonsmanenValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'seitoukihonsmanen$' should not be NULL."));
        }
        return seitoukihonsmanenType;
    }

    protected void setSeitoukihonsmanenType(String type) {
        seitoukihonsmanenType = type;
        seitoukihonsmanen = Optional.fromNullable(toCurrencyType(seitoukihonsmanenType))
            .transform(bizCurrencyTransformer(getSeitoukihonsmanenValue()))
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

    private BizCurrency syutkpmanen;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSyutkpmanen() {
        return syutkpmanen;
    }

    public void setSyutkpmanen(BizCurrency pSyutkpmanen) {
        syutkpmanen = pSyutkpmanen;
        syutkpmanenValue = null;
        syutkpmanenType  = null;
    }

    transient private BigDecimal syutkpmanenValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SYUTKPMANEN, nullable=true)
    protected BigDecimal getSyutkpmanenValue() {
        if (syutkpmanenValue == null && syutkpmanen != null) {
            if (syutkpmanen.isOptional()) return null;
            return syutkpmanen.absolute();
        }
        return syutkpmanenValue;
    }

    protected void setSyutkpmanenValue(BigDecimal value) {
        syutkpmanenValue = value;
        syutkpmanen = Optional.fromNullable(toCurrencyType(syutkpmanenType))
            .transform(bizCurrencyTransformer(getSyutkpmanenValue()))
            .orNull();
    }

    transient private String syutkpmanenType = null;

    @Column(name=SYUTKPMANEN + "$", nullable=true)
    protected String getSyutkpmanenType() {
        if (syutkpmanenType == null && syutkpmanen != null) return syutkpmanen.getType().toString();
        if (syutkpmanenType == null && getSyutkpmanenValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'syutkpmanen$' should not be NULL."));
        }
        return syutkpmanenType;
    }

    protected void setSyutkpmanenType(String type) {
        syutkpmanenType = type;
        syutkpmanen = Optional.fromNullable(toCurrencyType(syutkpmanenType))
            .transform(bizCurrencyTransformer(getSyutkpmanenValue()))
            .orNull();
    }

    private BizCurrency imustiyusbus;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getImustiyusbus() {
        return imustiyusbus;
    }

    public void setImustiyusbus(BizCurrency pImustiyusbus) {
        imustiyusbus = pImustiyusbus;
        imustiyusbusValue = null;
        imustiyusbusType  = null;
    }

    transient private BigDecimal imustiyusbusValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=IMUSTIYUSBUS, nullable=true)
    protected BigDecimal getImustiyusbusValue() {
        if (imustiyusbusValue == null && imustiyusbus != null) {
            if (imustiyusbus.isOptional()) return null;
            return imustiyusbus.absolute();
        }
        return imustiyusbusValue;
    }

    protected void setImustiyusbusValue(BigDecimal value) {
        imustiyusbusValue = value;
        imustiyusbus = Optional.fromNullable(toCurrencyType(imustiyusbusType))
            .transform(bizCurrencyTransformer(getImustiyusbusValue()))
            .orNull();
    }

    transient private String imustiyusbusType = null;

    @Column(name=IMUSTIYUSBUS + "$", nullable=true)
    protected String getImustiyusbusType() {
        if (imustiyusbusType == null && imustiyusbus != null) return imustiyusbus.getType().toString();
        if (imustiyusbusType == null && getImustiyusbusValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'imustiyusbus$' should not be NULL."));
        }
        return imustiyusbusType;
    }

    protected void setImustiyusbusType(String type) {
        imustiyusbusType = type;
        imustiyusbus = Optional.fromNullable(toCurrencyType(imustiyusbusType))
            .transform(bizCurrencyTransformer(getImustiyusbusValue()))
            .orNull();
    }

    private BizCurrency imustiyusbusmanen;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getImustiyusbusmanen() {
        return imustiyusbusmanen;
    }

    public void setImustiyusbusmanen(BizCurrency pImustiyusbusmanen) {
        imustiyusbusmanen = pImustiyusbusmanen;
        imustiyusbusmanenValue = null;
        imustiyusbusmanenType  = null;
    }

    transient private BigDecimal imustiyusbusmanenValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=IMUSTIYUSBUSMANEN, nullable=true)
    protected BigDecimal getImustiyusbusmanenValue() {
        if (imustiyusbusmanenValue == null && imustiyusbusmanen != null) {
            if (imustiyusbusmanen.isOptional()) return null;
            return imustiyusbusmanen.absolute();
        }
        return imustiyusbusmanenValue;
    }

    protected void setImustiyusbusmanenValue(BigDecimal value) {
        imustiyusbusmanenValue = value;
        imustiyusbusmanen = Optional.fromNullable(toCurrencyType(imustiyusbusmanenType))
            .transform(bizCurrencyTransformer(getImustiyusbusmanenValue()))
            .orNull();
    }

    transient private String imustiyusbusmanenType = null;

    @Column(name=IMUSTIYUSBUSMANEN + "$", nullable=true)
    protected String getImustiyusbusmanenType() {
        if (imustiyusbusmanenType == null && imustiyusbusmanen != null) return imustiyusbusmanen.getType().toString();
        if (imustiyusbusmanenType == null && getImustiyusbusmanenValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'imustiyusbusmanen$' should not be NULL."));
        }
        return imustiyusbusmanenType;
    }

    protected void setImustiyusbusmanenType(String type) {
        imustiyusbusmanenType = type;
        imustiyusbusmanen = Optional.fromNullable(toCurrencyType(imustiyusbusmanenType))
            .transform(bizCurrencyTransformer(getImustiyusbusmanenValue()))
            .orNull();
    }

    private BizNumber yenkansantkykwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenHT_IjitoukeiMeisai.YENKANSANTKYKWSRATE)
    public BizNumber getYenkansantkykwsrate() {
        return yenkansantkykwsrate;
    }

    public void setYenkansantkykwsrate(BizNumber pYenkansantkykwsrate) {
        yenkansantkykwsrate = pYenkansantkykwsrate;
    }

    private String syoubyoucd1;

    @Column(name=GenHT_IjitoukeiMeisai.SYOUBYOUCD1)
    @MaxLength(max=6)
    @AlphaDigit
    @HostInvalidCharacter
    public String getSyoubyoucd1() {
        return syoubyoucd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoubyoucd1(String pSyoubyoucd1) {
        syoubyoucd1 = pSyoubyoucd1;
    }

    private String syoubyoucd2;

    @Column(name=GenHT_IjitoukeiMeisai.SYOUBYOUCD2)
    @MaxLength(max=6)
    @AlphaDigit
    @HostInvalidCharacter
    public String getSyoubyoucd2() {
        return syoubyoucd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoubyoucd2(String pSyoubyoucd2) {
        syoubyoucd2 = pSyoubyoucd2;
    }

    private C_Ketkekkacd dakuhiktkekkacd;

    @Type(type="UserType_C_Ketkekkacd")
    @Column(name=GenHT_IjitoukeiMeisai.DAKUHIKTKEKKACD)
    public C_Ketkekkacd getDakuhiktkekkacd() {
        return dakuhiktkekkacd;
    }

    public void setDakuhiktkekkacd(C_Ketkekkacd pDakuhiktkekkacd) {
        dakuhiktkekkacd = pDakuhiktkekkacd;
    }

    private String dakuhiketsyacd;

    @Column(name=GenHT_IjitoukeiMeisai.DAKUHIKETSYACD)
    public String getDakuhiketsyacd() {
        return dakuhiketsyacd;
    }

    public void setDakuhiketsyacd(String pDakuhiketsyacd) {
        dakuhiketsyacd = pDakuhiketsyacd;
    }

    private String palketsyacd;

    @Column(name=GenHT_IjitoukeiMeisai.PALKETSYACD)
    @Length(length=2)
    @SingleByteStrings
    @Digit
    @HostInvalidCharacter
    public String getPalketsyacd() {
        return palketsyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPalketsyacd(String pPalketsyacd) {
        palketsyacd = pPalketsyacd;
    }

    private C_Tkhukaumu syksbyensitihsyutkhkkbn;

    @Type(type="UserType_C_Tkhukaumu")
    @Column(name=GenHT_IjitoukeiMeisai.SYKSBYENSITIHSYUTKHKKBN)
    public C_Tkhukaumu getSyksbyensitihsyutkhkkbn() {
        return syksbyensitihsyutkhkkbn;
    }

    public void setSyksbyensitihsyutkhkkbn(C_Tkhukaumu pSyksbyensitihsyutkhkkbn) {
        syksbyensitihsyutkhkkbn = pSyksbyensitihsyutkhkkbn;
    }

    private C_Tkhukaumu jyudkaigomehrtkhkkbn;

    @Type(type="UserType_C_Tkhukaumu")
    @Column(name=GenHT_IjitoukeiMeisai.JYUDKAIGOMEHRTKHKKBN)
    public C_Tkhukaumu getJyudkaigomehrtkhkkbn() {
        return jyudkaigomehrtkhkkbn;
    }

    public void setJyudkaigomehrtkhkkbn(C_Tkhukaumu pJyudkaigomehrtkhkkbn) {
        jyudkaigomehrtkhkkbn = pJyudkaigomehrtkhkkbn;
    }

    private String symtgenincd;

    @Column(name=GenHT_IjitoukeiMeisai.SYMTGENINCD)
    public String getSymtgenincd() {
        return symtgenincd;
    }

    public void setSymtgenincd(String pSymtgenincd) {
        symtgenincd = pSymtgenincd;
    }

    private String siincd;

    @Column(name=GenHT_IjitoukeiMeisai.SIINCD)
    public String getSiincd() {
        return siincd;
    }

    public void setSiincd(String pSiincd) {
        siincd = pSiincd;
    }

    private C_IjitoukeiKaijyoKbn ijitoukeikaijyokbn;

    @Type(type="UserType_C_IjitoukeiKaijyoKbn")
    @Column(name=GenHT_IjitoukeiMeisai.IJITOUKEIKAIJYOKBN)
    public C_IjitoukeiKaijyoKbn getIjitoukeikaijyokbn() {
        return ijitoukeikaijyokbn;
    }

    public void setIjitoukeikaijyokbn(C_IjitoukeiKaijyoKbn pIjitoukeikaijyokbn) {
        ijitoukeikaijyokbn = pIjitoukeikaijyokbn;
    }

    private BizDateYM sysnikoujiym;

    @Type(type="BizDateYMType")
    @Column(name=GenHT_IjitoukeiMeisai.SYSNIKOUJIYM)
    @ValidDateYm
    public BizDateYM getSysnikoujiym() {
        return sysnikoujiym;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSysnikoujiym(BizDateYM pSysnikoujiym) {
        sysnikoujiym = pSysnikoujiym;
    }

    private C_IjitoukeiZennouKbn ijitoukeizennoukbn;

    @Type(type="UserType_C_IjitoukeiZennouKbn")
    @Column(name=GenHT_IjitoukeiMeisai.IJITOUKEIZENNOUKBN)
    public C_IjitoukeiZennouKbn getIjitoukeizennoukbn() {
        return ijitoukeizennoukbn;
    }

    public void setIjitoukeizennoukbn(C_IjitoukeiZennouKbn pIjitoukeizennoukbn) {
        ijitoukeizennoukbn = pIjitoukeizennoukbn;
    }

    private C_Hrkkeiro hrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenHT_IjitoukeiMeisai.HRKKEIRO)
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    @Type(type="UserType_C_TkiktbrisyuruiKbn")
    @Column(name=GenHT_IjitoukeiMeisai.TIKIKTBRISYURUIKBN)
    public C_TkiktbrisyuruiKbn getTikiktbrisyuruikbn() {
        return tikiktbrisyuruikbn;
    }

    public void setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn) {
        tikiktbrisyuruikbn = pTikiktbrisyuruikbn;
    }

    private BizCurrency jissituhosyous;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getJissituhosyous() {
        return jissituhosyous;
    }

    public void setJissituhosyous(BizCurrency pJissituhosyous) {
        jissituhosyous = pJissituhosyous;
        jissituhosyousValue = null;
        jissituhosyousType  = null;
    }

    transient private BigDecimal jissituhosyousValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=JISSITUHOSYOUS, nullable=true)
    protected BigDecimal getJissituhosyousValue() {
        if (jissituhosyousValue == null && jissituhosyous != null) {
            if (jissituhosyous.isOptional()) return null;
            return jissituhosyous.absolute();
        }
        return jissituhosyousValue;
    }

    protected void setJissituhosyousValue(BigDecimal value) {
        jissituhosyousValue = value;
        jissituhosyous = Optional.fromNullable(toCurrencyType(jissituhosyousType))
            .transform(bizCurrencyTransformer(getJissituhosyousValue()))
            .orNull();
    }

    transient private String jissituhosyousType = null;

    @Column(name=JISSITUHOSYOUS + "$", nullable=true)
    protected String getJissituhosyousType() {
        if (jissituhosyousType == null && jissituhosyous != null) return jissituhosyous.getType().toString();
        if (jissituhosyousType == null && getJissituhosyousValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'jissituhosyous$' should not be NULL."));
        }
        return jissituhosyousType;
    }

    protected void setJissituhosyousType(String type) {
        jissituhosyousType = type;
        jissituhosyous = Optional.fromNullable(toCurrencyType(jissituhosyousType))
            .transform(bizCurrencyTransformer(getJissituhosyousValue()))
            .orNull();
    }

    private BizCurrency jissituhosyousmanen;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getJissituhosyousmanen() {
        return jissituhosyousmanen;
    }

    public void setJissituhosyousmanen(BizCurrency pJissituhosyousmanen) {
        jissituhosyousmanen = pJissituhosyousmanen;
        jissituhosyousmanenValue = null;
        jissituhosyousmanenType  = null;
    }

    transient private BigDecimal jissituhosyousmanenValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=JISSITUHOSYOUSMANEN, nullable=true)
    protected BigDecimal getJissituhosyousmanenValue() {
        if (jissituhosyousmanenValue == null && jissituhosyousmanen != null) {
            if (jissituhosyousmanen.isOptional()) return null;
            return jissituhosyousmanen.absolute();
        }
        return jissituhosyousmanenValue;
    }

    protected void setJissituhosyousmanenValue(BigDecimal value) {
        jissituhosyousmanenValue = value;
        jissituhosyousmanen = Optional.fromNullable(toCurrencyType(jissituhosyousmanenType))
            .transform(bizCurrencyTransformer(getJissituhosyousmanenValue()))
            .orNull();
    }

    transient private String jissituhosyousmanenType = null;

    @Column(name=JISSITUHOSYOUSMANEN + "$", nullable=true)
    protected String getJissituhosyousmanenType() {
        if (jissituhosyousmanenType == null && jissituhosyousmanen != null) return jissituhosyousmanen.getType().toString();
        if (jissituhosyousmanenType == null && getJissituhosyousmanenValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'jissituhosyousmanen$' should not be NULL."));
        }
        return jissituhosyousmanenType;
    }

    protected void setJissituhosyousmanenType(String type) {
        jissituhosyousmanenType = type;
        jissituhosyousmanen = Optional.fromNullable(toCurrencyType(jissituhosyousmanenType))
            .transform(bizCurrencyTransformer(getJissituhosyousmanenValue()))
            .orNull();
    }

    private Integer dai1hknkkn;

    @Column(name=GenHT_IjitoukeiMeisai.DAI1HKNKKN)
    @Range(min="0", max="99")
    public Integer getDai1hknkkn() {
        return dai1hknkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDai1hknkkn(Integer pDai1hknkkn) {
        dai1hknkkn = pDai1hknkkn;
    }

    private C_IjitoukeiTikShrTkykKbn ijitoukeitikshrtkykkbn;

    @Type(type="UserType_C_IjitoukeiTikShrTkykKbn")
    @Column(name=GenHT_IjitoukeiMeisai.IJITOUKEITIKSHRTKYKKBN)
    public C_IjitoukeiTikShrTkykKbn getIjitoukeitikshrtkykkbn() {
        return ijitoukeitikshrtkykkbn;
    }

    public void setIjitoukeitikshrtkykkbn(C_IjitoukeiTikShrTkykKbn pIjitoukeitikshrtkykkbn) {
        ijitoukeitikshrtkykkbn = pIjitoukeitikshrtkykkbn;
    }

    private BizCurrency teikisiharaikin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTeikisiharaikin() {
        return teikisiharaikin;
    }

    public void setTeikisiharaikin(BizCurrency pTeikisiharaikin) {
        teikisiharaikin = pTeikisiharaikin;
        teikisiharaikinValue = null;
        teikisiharaikinType  = null;
    }

    transient private BigDecimal teikisiharaikinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TEIKISIHARAIKIN, nullable=true)
    protected BigDecimal getTeikisiharaikinValue() {
        if (teikisiharaikinValue == null && teikisiharaikin != null) {
            if (teikisiharaikin.isOptional()) return null;
            return teikisiharaikin.absolute();
        }
        return teikisiharaikinValue;
    }

    protected void setTeikisiharaikinValue(BigDecimal value) {
        teikisiharaikinValue = value;
        teikisiharaikin = Optional.fromNullable(toCurrencyType(teikisiharaikinType))
            .transform(bizCurrencyTransformer(getTeikisiharaikinValue()))
            .orNull();
    }

    transient private String teikisiharaikinType = null;

    @Column(name=TEIKISIHARAIKIN + "$", nullable=true)
    protected String getTeikisiharaikinType() {
        if (teikisiharaikinType == null && teikisiharaikin != null) return teikisiharaikin.getType().toString();
        if (teikisiharaikinType == null && getTeikisiharaikinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'teikisiharaikin$' should not be NULL."));
        }
        return teikisiharaikinType;
    }

    protected void setTeikisiharaikinType(String type) {
        teikisiharaikinType = type;
        teikisiharaikin = Optional.fromNullable(toCurrencyType(teikisiharaikinType))
            .transform(bizCurrencyTransformer(getTeikisiharaikinValue()))
            .orNull();
    }

    private BizCurrency teikisiharaikinmanen;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTeikisiharaikinmanen() {
        return teikisiharaikinmanen;
    }

    public void setTeikisiharaikinmanen(BizCurrency pTeikisiharaikinmanen) {
        teikisiharaikinmanen = pTeikisiharaikinmanen;
        teikisiharaikinmanenValue = null;
        teikisiharaikinmanenType  = null;
    }

    transient private BigDecimal teikisiharaikinmanenValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TEIKISIHARAIKINMANEN, nullable=true)
    protected BigDecimal getTeikisiharaikinmanenValue() {
        if (teikisiharaikinmanenValue == null && teikisiharaikinmanen != null) {
            if (teikisiharaikinmanen.isOptional()) return null;
            return teikisiharaikinmanen.absolute();
        }
        return teikisiharaikinmanenValue;
    }

    protected void setTeikisiharaikinmanenValue(BigDecimal value) {
        teikisiharaikinmanenValue = value;
        teikisiharaikinmanen = Optional.fromNullable(toCurrencyType(teikisiharaikinmanenType))
            .transform(bizCurrencyTransformer(getTeikisiharaikinmanenValue()))
            .orNull();
    }

    transient private String teikisiharaikinmanenType = null;

    @Column(name=TEIKISIHARAIKINMANEN + "$", nullable=true)
    protected String getTeikisiharaikinmanenType() {
        if (teikisiharaikinmanenType == null && teikisiharaikinmanen != null) return teikisiharaikinmanen.getType().toString();
        if (teikisiharaikinmanenType == null && getTeikisiharaikinmanenValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'teikisiharaikinmanen$' should not be NULL."));
        }
        return teikisiharaikinmanenType;
    }

    protected void setTeikisiharaikinmanenType(String type) {
        teikisiharaikinmanenType = type;
        teikisiharaikinmanen = Optional.fromNullable(toCurrencyType(teikisiharaikinmanenType))
            .transform(bizCurrencyTransformer(getTeikisiharaikinmanenValue()))
            .orNull();
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_IjitoukeiMeisai.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}