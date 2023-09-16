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
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_ShrtysyhknsyuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.JT_SiTyousyo;
import yuyu.def.db.id.PKJT_SiTyousyo;
import yuyu.def.db.meta.GenQJT_SiTyousyo;
import yuyu.def.db.meta.QJT_SiTyousyo;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_ShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_ShrtysyhknsyuKbn;
import yuyu.def.db.type.UserType_C_TantouCdKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 保険金給付金支払調書テーブル テーブルのマッピング情報クラスで、 {@link JT_SiTyousyo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SiTyousyo}</td><td colspan="3">保険金給付金支払調書テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_SiTyousyo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">{@link PKJT_SiTyousyo ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrtysyrenno shrtysyrenno}</td><td>支払調書連番</td><td align="center">{@link PKJT_SiTyousyo ○}</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getKacd kacd}</td><td>課コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTantocd tantocd}</td><td>担当コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TantouCdKbn}</td></tr>
 *  <tr><td>{@link #getHknsyukigou hknsyukigou}</td><td>保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHknkkn hknkkn}</td><td>保険期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHrkkkn hrkkkn}</td><td>払込期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHhknnen hhknnen}</td><td>被保険者年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyknen kyknen}</td><td>契約者年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHhknsei hhknsei}</td><td>被保険者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hhknsei}</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getHrkkeiro hrkkeiro}</td><td>払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getAnnaihuyouriyuukbn annaihuyouriyuukbn}</td><td>案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkp hrkp}</td><td>払込保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKouryokuhasseiymd kouryokuhasseiymd}</td><td>効力発生日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMfadrsiyouhyouji mfadrsiyouhyouji}</td><td>ＭＦ住所使用表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKihrpdmiseibidisp kihrpdmiseibidisp}</td><td>既払ＰＤ未整備表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKihrpseibiyoudisp kihrpseibiyoudisp}</td><td>既払込Ｐ整備要表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShrgk shrgk}</td><td>支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getWarimsishrgkbizc warimsishrgkbizc}</td><td>割増支払金額（業務通貨型）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZnnphrbizc znnphrbizc}</td><td>前納Ｐ等返戻金（業務通貨型）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTtkekstkganribizc ttkekstkganribizc}</td><td>立替貸付元利金（業務通貨型）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSshkdbizc sshkdbizc}</td><td>差引Ｄ（業務通貨型）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSshkshrgk sshkshrgk}</td><td>差引支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMihrkmpbizc mihrkmpbizc}</td><td>未払込Ｐ（業務通貨型）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrymd shrymd}</td><td>支払日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyorisosikicd syorisosikicd}</td><td>処理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoritaisyoukbn syoritaisyoukbn}</td><td>処理対象区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShrtysytsinyno shrtysytsinyno}</td><td>支払調書郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShrtysyadr1kj shrtysyadr1kj}</td><td>支払調書住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShrtysyadr2kj shrtysyadr2kj}</td><td>支払調書住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShrtysyadr3kj shrtysyadr3kj}</td><td>支払調書住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkj hhknnmkj}</td><td>被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktnmkj uktnmkj}</td><td>受取人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKjdaihyouuktnm kjdaihyouuktnm}</td><td>漢字代表受取人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShrtienrsk shrtienrsk}</td><td>支払遅延利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKihons kihons}</td><td>基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrtysysyuruicd shrtysysyuruicd}</td><td>支払調書種類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTeknjikihrpseibidisp teknjikihrpseibidisp}</td><td>転換時既払込Ｐ未整備表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKihrkmp kihrkmp}</td><td>既払込保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getOnlinecentercutkbn onlinecentercutkbn}</td><td>オンラインセンターカット区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShrhousiteikbn shrhousiteikbn}</td><td>支払方法指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ShrhousiteiKbn}</td></tr>
 *  <tr><td>{@link #getHtykeihihnsyukbn htykeihihnsyukbn}</td><td>必要経費編集区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyuseijtshrdbizc syuseijtshrdbizc}</td><td>修正後実支払Ｄ（業務通貨型）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTouduketorihouhoukbn touduketorihouhoukbn}</td><td>当Ｄ受取方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkkn nenkinkkn}</td><td>年金期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBanknmkn banknmkn}</td><td>銀行名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitennmkn sitennmkn}</td><td>支店名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getYokinknmkn yokinknmkn}</td><td>預金口座種目名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSakuseiymd sakuseiymd}</td><td>作成年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykmnmeigibangou kykmnmeigibangou}</td><td>契約者ＭＮ名義番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktmnmeigibangou uktmnmeigibangou}</td><td>受取人ＭＮ名義番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJigyoukykmndantaicd jigyoukykmndantaicd}</td><td>事業契約用ＭＮ団体コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMnsaiannaihnskakbn mnsaiannaihnskakbn}</td><td>ＭＮ再案内本社回送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHuho2kykdisp huho2kykdisp}</td><td>普保Ⅱ契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShrtysyhknsyukbn shrtysyhknsyukbn}</td><td>支払調書保険種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ShrtysyhknsyuKbn}</td></tr>
 *  <tr><td>{@link #getShrtysykurikosidisp shrtysykurikosidisp}</td><td>支払調書繰越表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinyno tsinyno}</td><td>通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr1kj tsinadr1kj}</td><td>通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr2kj tsinadr2kj}</td><td>通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr3kj tsinadr3kj}</td><td>通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSynyhsjykykndisp synyhsjykykndisp}</td><td>収入保障年金受給権表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTblsakuseihunodisp tblsakuseihunodisp}</td><td>テープ作成不能表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDaihyouktkbn daihyouktkbn}</td><td>代表受取人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOldtsinyno oldtsinyno}</td><td>（旧）通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOldtsinadr1kj oldtsinadr1kj}</td><td>（旧）通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOldtsinadr2kj oldtsinadr2kj}</td><td>（旧）通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOldtsinadr3kj oldtsinadr3kj}</td><td>（旧）通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOldkyknmkj oldkyknmkj}</td><td>（旧）契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykhnkkaisuu kykhnkkaisuu}</td><td>契約者変更回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getShrkykhtykeihiyouhyj shrkykhtykeihiyouhyj}</td><td>支払時契約者必要経費要表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShrkykhtykeihi shrkykhtykeihi}</td><td>支払時契約者必要経費</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     JT_SiTyousyo
 * @see     PKJT_SiTyousyo
 * @see     QJT_SiTyousyo
 * @see     GenQJT_SiTyousyo
 */
@MappedSuperclass
@Table(name=GenJT_SiTyousyo.TABLE_NAME)
@IdClass(value=PKJT_SiTyousyo.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_Hhknsei", typeClass=UserType_C_Hhknsei.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_ShrhousiteiKbn", typeClass=UserType_C_ShrhousiteiKbn.class),
    @TypeDef(name="UserType_C_ShrtysyhknsyuKbn", typeClass=UserType_C_ShrtysyhknsyuKbn.class),
    @TypeDef(name="UserType_C_TantouCdKbn", typeClass=UserType_C_TantouCdKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenJT_SiTyousyo extends AbstractExDBEntity<JT_SiTyousyo, PKJT_SiTyousyo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_SiTyousyo";
    public static final String SYONO                    = "syono";
    public static final String TYOUHYOUYMD              = "tyouhyouymd";
    public static final String SHRTYSYRENNO             = "shrtysyrenno";
    public static final String KACD                     = "kacd";
    public static final String TANTOCD                  = "tantocd";
    public static final String HKNSYUKIGOU              = "hknsyukigou";
    public static final String HKNKKN                   = "hknkkn";
    public static final String HRKKKN                   = "hrkkkn";
    public static final String HHKNNEN                  = "hhknnen";
    public static final String KYKNEN                   = "kyknen";
    public static final String KYKYMD                   = "kykymd";
    public static final String HHKNSEI                  = "hhknsei";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String HRKKEIRO                 = "hrkkeiro";
    public static final String ANNAIHUYOURIYUUKBN       = "annaihuyouriyuukbn";
    public static final String HRKP                     = "hrkp";
    public static final String KOURYOKUHASSEIYMD        = "kouryokuhasseiymd";
    public static final String MFADRSIYOUHYOUJI         = "mfadrsiyouhyouji";
    public static final String KIHRPDMISEIBIDISP        = "kihrpdmiseibidisp";
    public static final String KIHRPSEIBIYOUDISP        = "kihrpseibiyoudisp";
    public static final String SHRGK                    = "shrgk";
    public static final String WARIMSISHRGKBIZC         = "warimsishrgkbizc";
    public static final String ZNNPHRBIZC               = "znnphrbizc";
    public static final String TTKEKSTKGANRIBIZC        = "ttkekstkganribizc";
    public static final String SSHKDBIZC                = "sshkdbizc";
    public static final String SSHKSHRGK                = "sshkshrgk";
    public static final String MIHRKMPBIZC              = "mihrkmpbizc";
    public static final String SHRYMD                   = "shrymd";
    public static final String SYORISOSIKICD            = "syorisosikicd";
    public static final String SYORITAISYOUKBN          = "syoritaisyoukbn";
    public static final String SHRTYSYTSINYNO           = "shrtysytsinyno";
    public static final String SHRTYSYADR1KJ            = "shrtysyadr1kj";
    public static final String SHRTYSYADR2KJ            = "shrtysyadr2kj";
    public static final String SHRTYSYADR3KJ            = "shrtysyadr3kj";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String HHKNNMKJ                 = "hhknnmkj";
    public static final String UKTNMKJ                  = "uktnmkj";
    public static final String KJDAIHYOUUKTNM           = "kjdaihyouuktnm";
    public static final String SHRTIENRSK               = "shrtienrsk";
    public static final String KIHONS                   = "kihons";
    public static final String SHRTYSYSYURUICD          = "shrtysysyuruicd";
    public static final String TEKNJIKIHRPSEIBIDISP     = "teknjikihrpseibidisp";
    public static final String KIHRKMP                  = "kihrkmp";
    public static final String ONLINECENTERCUTKBN       = "onlinecentercutkbn";
    public static final String SHRHOUSITEIKBN           = "shrhousiteikbn";
    public static final String HTYKEIHIHNSYUKBN         = "htykeihihnsyukbn";
    public static final String SYUSEIJTSHRDBIZC         = "syuseijtshrdbizc";
    public static final String TOUDUKETORIHOUHOUKBN     = "touduketorihouhoukbn";
    public static final String NENKINKKN                = "nenkinkkn";
    public static final String BANKCD                   = "bankcd";
    public static final String BANKNMKN                 = "banknmkn";
    public static final String SITENCD                  = "sitencd";
    public static final String SITENNMKN                = "sitennmkn";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String YOKINKNMKN               = "yokinknmkn";
    public static final String KOUZANO                  = "kouzano";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String SAKUSEIYMD               = "sakuseiymd";
    public static final String KYKMNMEIGIBANGOU         = "kykmnmeigibangou";
    public static final String UKTMNMEIGIBANGOU         = "uktmnmeigibangou";
    public static final String JIGYOUKYKMNDANTAICD      = "jigyoukykmndantaicd";
    public static final String MNSAIANNAIHNSKAKBN       = "mnsaiannaihnskakbn";
    public static final String HUHO2KYKDISP             = "huho2kykdisp";
    public static final String SHRTYSYHKNSYUKBN         = "shrtysyhknsyukbn";
    public static final String SHRTYSYKURIKOSIDISP      = "shrtysykurikosidisp";
    public static final String TSINYNO                  = "tsinyno";
    public static final String TSINADR1KJ               = "tsinadr1kj";
    public static final String TSINADR2KJ               = "tsinadr2kj";
    public static final String TSINADR3KJ               = "tsinadr3kj";
    public static final String SYNYHSJYKYKNDISP         = "synyhsjykykndisp";
    public static final String TBLSAKUSEIHUNODISP       = "tblsakuseihunodisp";
    public static final String DAIHYOUKTKBN             = "daihyouktkbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String OLDTSINYNO               = "oldtsinyno";
    public static final String OLDTSINADR1KJ            = "oldtsinadr1kj";
    public static final String OLDTSINADR2KJ            = "oldtsinadr2kj";
    public static final String OLDTSINADR3KJ            = "oldtsinadr3kj";
    public static final String OLDKYKNMKJ               = "oldkyknmkj";
    public static final String KYKHNKKAISUU             = "kykhnkkaisuu";
    public static final String SHRKYKHTYKEIHIYOUHYJ     = "shrkykhtykeihiyouhyj";
    public static final String SHRKYKHTYKEIHI           = "shrkykhtykeihi";

    private final PKJT_SiTyousyo primaryKey;

    public GenJT_SiTyousyo() {
        primaryKey = new PKJT_SiTyousyo();
    }

    public GenJT_SiTyousyo(
        String pSyono,
        BizDate pTyouhyouymd,
        Long pShrtysyrenno
    ) {
        primaryKey = new PKJT_SiTyousyo(
            pSyono,
            pTyouhyouymd,
            pShrtysyrenno
        );
    }

    @Transient
    @Override
    public PKJT_SiTyousyo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_SiTyousyo> getMetaClass() {
        return QJT_SiTyousyo.class;
    }

    @Id
    @Column(name=GenJT_SiTyousyo.SYONO)
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
    @Type(type="BizDateType")
    @Column(name=GenJT_SiTyousyo.TYOUHYOUYMD)
    @ValidDate
    public BizDate getTyouhyouymd() {
        return getPrimaryKey().getTyouhyouymd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        getPrimaryKey().setTyouhyouymd(pTyouhyouymd);
    }

    @Id
    @Column(name=GenJT_SiTyousyo.SHRTYSYRENNO)
    public Long getShrtysyrenno() {
        return getPrimaryKey().getShrtysyrenno();
    }

    public void setShrtysyrenno(Long pShrtysyrenno) {
        getPrimaryKey().setShrtysyrenno(pShrtysyrenno);
    }

    private String kacd;

    @Column(name=GenJT_SiTyousyo.KACD)
    public String getKacd() {
        return kacd;
    }

    public void setKacd(String pKacd) {
        kacd = pKacd;
    }

    private C_TantouCdKbn tantocd;

    @Type(type="UserType_C_TantouCdKbn")
    @Column(name=GenJT_SiTyousyo.TANTOCD)
    public C_TantouCdKbn getTantocd() {
        return tantocd;
    }

    public void setTantocd(C_TantouCdKbn pTantocd) {
        tantocd = pTantocd;
    }

    private String hknsyukigou;

    @Column(name=GenJT_SiTyousyo.HKNSYUKIGOU)
    public String getHknsyukigou() {
        return hknsyukigou;
    }

    public void setHknsyukigou(String pHknsyukigou) {
        hknsyukigou = pHknsyukigou;
    }

    private Integer hknkkn;

    @Column(name=GenJT_SiTyousyo.HKNKKN)
    @Range(min="0", max="99")
    public Integer getHknkkn() {
        return hknkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHknkkn(Integer pHknkkn) {
        hknkkn = pHknkkn;
    }

    private Integer hrkkkn;

    @Column(name=GenJT_SiTyousyo.HRKKKN)
    @Range(min="0", max="99")
    public Integer getHrkkkn() {
        return hrkkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHrkkkn(Integer pHrkkkn) {
        hrkkkn = pHrkkkn;
    }

    private Integer hhknnen;

    @Column(name=GenJT_SiTyousyo.HHKNNEN)
    @NaturalNumber
    public Integer getHhknnen() {
        return hhknnen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknnen(Integer pHhknnen) {
        hhknnen = pHhknnen;
    }

    private Integer kyknen;

    @Column(name=GenJT_SiTyousyo.KYKNEN)
    public Integer getKyknen() {
        return kyknen;
    }

    public void setKyknen(Integer pKyknen) {
        kyknen = pKyknen;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiTyousyo.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private C_Hhknsei hhknsei;

    @Type(type="UserType_C_Hhknsei")
    @Column(name=GenJT_SiTyousyo.HHKNSEI)
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenJT_SiTyousyo.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_Hrkkeiro hrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenJT_SiTyousyo.HRKKEIRO)
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private String annaihuyouriyuukbn;

    @Column(name=GenJT_SiTyousyo.ANNAIHUYOURIYUUKBN)
    public String getAnnaihuyouriyuukbn() {
        return annaihuyouriyuukbn;
    }

    public void setAnnaihuyouriyuukbn(String pAnnaihuyouriyuukbn) {
        annaihuyouriyuukbn = pAnnaihuyouriyuukbn;
    }

    private BizCurrency hrkp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHrkp() {
        return hrkp;
    }

    public void setHrkp(BizCurrency pHrkp) {
        hrkp = pHrkp;
        hrkpValue = null;
        hrkpType  = null;
    }

    transient private BigDecimal hrkpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HRKP, nullable=true)
    protected BigDecimal getHrkpValue() {
        if (hrkpValue == null && hrkp != null) {
            if (hrkp.isOptional()) return null;
            return hrkp.absolute();
        }
        return hrkpValue;
    }

    protected void setHrkpValue(BigDecimal value) {
        hrkpValue = value;
        hrkp = Optional.fromNullable(toCurrencyType(hrkpType))
            .transform(bizCurrencyTransformer(getHrkpValue()))
            .orNull();
    }

    transient private String hrkpType = null;

    @Column(name=HRKP + "$", nullable=true)
    protected String getHrkpType() {
        if (hrkpType == null && hrkp != null) return hrkp.getType().toString();
        if (hrkpType == null && getHrkpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hrkp$' should not be NULL."));
        }
        return hrkpType;
    }

    protected void setHrkpType(String type) {
        hrkpType = type;
        hrkp = Optional.fromNullable(toCurrencyType(hrkpType))
            .transform(bizCurrencyTransformer(getHrkpValue()))
            .orNull();
    }

    private BizDate kouryokuhasseiymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiTyousyo.KOURYOKUHASSEIYMD)
    public BizDate getKouryokuhasseiymd() {
        return kouryokuhasseiymd;
    }

    public void setKouryokuhasseiymd(BizDate pKouryokuhasseiymd) {
        kouryokuhasseiymd = pKouryokuhasseiymd;
    }

    private String mfadrsiyouhyouji;

    @Column(name=GenJT_SiTyousyo.MFADRSIYOUHYOUJI)
    public String getMfadrsiyouhyouji() {
        return mfadrsiyouhyouji;
    }

    public void setMfadrsiyouhyouji(String pMfadrsiyouhyouji) {
        mfadrsiyouhyouji = pMfadrsiyouhyouji;
    }

    private String kihrpdmiseibidisp;

    @Column(name=GenJT_SiTyousyo.KIHRPDMISEIBIDISP)
    public String getKihrpdmiseibidisp() {
        return kihrpdmiseibidisp;
    }

    public void setKihrpdmiseibidisp(String pKihrpdmiseibidisp) {
        kihrpdmiseibidisp = pKihrpdmiseibidisp;
    }

    private String kihrpseibiyoudisp;

    @Column(name=GenJT_SiTyousyo.KIHRPSEIBIYOUDISP)
    public String getKihrpseibiyoudisp() {
        return kihrpseibiyoudisp;
    }

    public void setKihrpseibiyoudisp(String pKihrpseibiyoudisp) {
        kihrpseibiyoudisp = pKihrpseibiyoudisp;
    }

    private BizCurrency shrgk;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getShrgk() {
        return shrgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrgk(BizCurrency pShrgk) {
        shrgk = pShrgk;
        shrgkValue = null;
        shrgkType  = null;
    }

    transient private BigDecimal shrgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRGK, nullable=true)
    protected BigDecimal getShrgkValue() {
        if (shrgkValue == null && shrgk != null) {
            if (shrgk.isOptional()) return null;
            return shrgk.absolute();
        }
        return shrgkValue;
    }

    protected void setShrgkValue(BigDecimal value) {
        shrgkValue = value;
        shrgk = Optional.fromNullable(toCurrencyType(shrgkType))
            .transform(bizCurrencyTransformer(getShrgkValue()))
            .orNull();
    }

    transient private String shrgkType = null;

    @Column(name=SHRGK + "$", nullable=true)
    protected String getShrgkType() {
        if (shrgkType == null && shrgk != null) return shrgk.getType().toString();
        if (shrgkType == null && getShrgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrgk$' should not be NULL."));
        }
        return shrgkType;
    }

    protected void setShrgkType(String type) {
        shrgkType = type;
        shrgk = Optional.fromNullable(toCurrencyType(shrgkType))
            .transform(bizCurrencyTransformer(getShrgkValue()))
            .orNull();
    }

    private BizCurrency warimsishrgkbizc;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getWarimsishrgkbizc() {
        return warimsishrgkbizc;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setWarimsishrgkbizc(BizCurrency pWarimsishrgkbizc) {
        warimsishrgkbizc = pWarimsishrgkbizc;
        warimsishrgkbizcValue = null;
        warimsishrgkbizcType  = null;
    }

    transient private BigDecimal warimsishrgkbizcValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=WARIMSISHRGKBIZC, nullable=true)
    protected BigDecimal getWarimsishrgkbizcValue() {
        if (warimsishrgkbizcValue == null && warimsishrgkbizc != null) {
            if (warimsishrgkbizc.isOptional()) return null;
            return warimsishrgkbizc.absolute();
        }
        return warimsishrgkbizcValue;
    }

    protected void setWarimsishrgkbizcValue(BigDecimal value) {
        warimsishrgkbizcValue = value;
        warimsishrgkbizc = Optional.fromNullable(toCurrencyType(warimsishrgkbizcType))
            .transform(bizCurrencyTransformer(getWarimsishrgkbizcValue()))
            .orNull();
    }

    transient private String warimsishrgkbizcType = null;

    @Column(name=WARIMSISHRGKBIZC + "$", nullable=true)
    protected String getWarimsishrgkbizcType() {
        if (warimsishrgkbizcType == null && warimsishrgkbizc != null) return warimsishrgkbizc.getType().toString();
        if (warimsishrgkbizcType == null && getWarimsishrgkbizcValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'warimsishrgkbizc$' should not be NULL."));
        }
        return warimsishrgkbizcType;
    }

    protected void setWarimsishrgkbizcType(String type) {
        warimsishrgkbizcType = type;
        warimsishrgkbizc = Optional.fromNullable(toCurrencyType(warimsishrgkbizcType))
            .transform(bizCurrencyTransformer(getWarimsishrgkbizcValue()))
            .orNull();
    }

    private BizCurrency znnphrbizc;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZnnphrbizc() {
        return znnphrbizc;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZnnphrbizc(BizCurrency pZnnphrbizc) {
        znnphrbizc = pZnnphrbizc;
        znnphrbizcValue = null;
        znnphrbizcType  = null;
    }

    transient private BigDecimal znnphrbizcValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZNNPHRBIZC, nullable=true)
    protected BigDecimal getZnnphrbizcValue() {
        if (znnphrbizcValue == null && znnphrbizc != null) {
            if (znnphrbizc.isOptional()) return null;
            return znnphrbizc.absolute();
        }
        return znnphrbizcValue;
    }

    protected void setZnnphrbizcValue(BigDecimal value) {
        znnphrbizcValue = value;
        znnphrbizc = Optional.fromNullable(toCurrencyType(znnphrbizcType))
            .transform(bizCurrencyTransformer(getZnnphrbizcValue()))
            .orNull();
    }

    transient private String znnphrbizcType = null;

    @Column(name=ZNNPHRBIZC + "$", nullable=true)
    protected String getZnnphrbizcType() {
        if (znnphrbizcType == null && znnphrbizc != null) return znnphrbizc.getType().toString();
        if (znnphrbizcType == null && getZnnphrbizcValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'znnphrbizc$' should not be NULL."));
        }
        return znnphrbizcType;
    }

    protected void setZnnphrbizcType(String type) {
        znnphrbizcType = type;
        znnphrbizc = Optional.fromNullable(toCurrencyType(znnphrbizcType))
            .transform(bizCurrencyTransformer(getZnnphrbizcValue()))
            .orNull();
    }

    private BizCurrency ttkekstkganribizc;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTtkekstkganribizc() {
        return ttkekstkganribizc;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTtkekstkganribizc(BizCurrency pTtkekstkganribizc) {
        ttkekstkganribizc = pTtkekstkganribizc;
        ttkekstkganribizcValue = null;
        ttkekstkganribizcType  = null;
    }

    transient private BigDecimal ttkekstkganribizcValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TTKEKSTKGANRIBIZC, nullable=true)
    protected BigDecimal getTtkekstkganribizcValue() {
        if (ttkekstkganribizcValue == null && ttkekstkganribizc != null) {
            if (ttkekstkganribizc.isOptional()) return null;
            return ttkekstkganribizc.absolute();
        }
        return ttkekstkganribizcValue;
    }

    protected void setTtkekstkganribizcValue(BigDecimal value) {
        ttkekstkganribizcValue = value;
        ttkekstkganribizc = Optional.fromNullable(toCurrencyType(ttkekstkganribizcType))
            .transform(bizCurrencyTransformer(getTtkekstkganribizcValue()))
            .orNull();
    }

    transient private String ttkekstkganribizcType = null;

    @Column(name=TTKEKSTKGANRIBIZC + "$", nullable=true)
    protected String getTtkekstkganribizcType() {
        if (ttkekstkganribizcType == null && ttkekstkganribizc != null) return ttkekstkganribizc.getType().toString();
        if (ttkekstkganribizcType == null && getTtkekstkganribizcValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'ttkekstkganribizc$' should not be NULL."));
        }
        return ttkekstkganribizcType;
    }

    protected void setTtkekstkganribizcType(String type) {
        ttkekstkganribizcType = type;
        ttkekstkganribizc = Optional.fromNullable(toCurrencyType(ttkekstkganribizcType))
            .transform(bizCurrencyTransformer(getTtkekstkganribizcValue()))
            .orNull();
    }

    private BizCurrency sshkdbizc;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSshkdbizc() {
        return sshkdbizc;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSshkdbizc(BizCurrency pSshkdbizc) {
        sshkdbizc = pSshkdbizc;
        sshkdbizcValue = null;
        sshkdbizcType  = null;
    }

    transient private BigDecimal sshkdbizcValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SSHKDBIZC, nullable=true)
    protected BigDecimal getSshkdbizcValue() {
        if (sshkdbizcValue == null && sshkdbizc != null) {
            if (sshkdbizc.isOptional()) return null;
            return sshkdbizc.absolute();
        }
        return sshkdbizcValue;
    }

    protected void setSshkdbizcValue(BigDecimal value) {
        sshkdbizcValue = value;
        sshkdbizc = Optional.fromNullable(toCurrencyType(sshkdbizcType))
            .transform(bizCurrencyTransformer(getSshkdbizcValue()))
            .orNull();
    }

    transient private String sshkdbizcType = null;

    @Column(name=SSHKDBIZC + "$", nullable=true)
    protected String getSshkdbizcType() {
        if (sshkdbizcType == null && sshkdbizc != null) return sshkdbizc.getType().toString();
        if (sshkdbizcType == null && getSshkdbizcValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sshkdbizc$' should not be NULL."));
        }
        return sshkdbizcType;
    }

    protected void setSshkdbizcType(String type) {
        sshkdbizcType = type;
        sshkdbizc = Optional.fromNullable(toCurrencyType(sshkdbizcType))
            .transform(bizCurrencyTransformer(getSshkdbizcValue()))
            .orNull();
    }

    private BizCurrency sshkshrgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSshkshrgk() {
        return sshkshrgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSshkshrgk(BizCurrency pSshkshrgk) {
        sshkshrgk = pSshkshrgk;
        sshkshrgkValue = null;
        sshkshrgkType  = null;
    }

    transient private BigDecimal sshkshrgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SSHKSHRGK, nullable=true)
    protected BigDecimal getSshkshrgkValue() {
        if (sshkshrgkValue == null && sshkshrgk != null) {
            if (sshkshrgk.isOptional()) return null;
            return sshkshrgk.absolute();
        }
        return sshkshrgkValue;
    }

    protected void setSshkshrgkValue(BigDecimal value) {
        sshkshrgkValue = value;
        sshkshrgk = Optional.fromNullable(toCurrencyType(sshkshrgkType))
            .transform(bizCurrencyTransformer(getSshkshrgkValue()))
            .orNull();
    }

    transient private String sshkshrgkType = null;

    @Column(name=SSHKSHRGK + "$", nullable=true)
    protected String getSshkshrgkType() {
        if (sshkshrgkType == null && sshkshrgk != null) return sshkshrgk.getType().toString();
        if (sshkshrgkType == null && getSshkshrgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sshkshrgk$' should not be NULL."));
        }
        return sshkshrgkType;
    }

    protected void setSshkshrgkType(String type) {
        sshkshrgkType = type;
        sshkshrgk = Optional.fromNullable(toCurrencyType(sshkshrgkType))
            .transform(bizCurrencyTransformer(getSshkshrgkValue()))
            .orNull();
    }

    private BizCurrency mihrkmpbizc;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMihrkmpbizc() {
        return mihrkmpbizc;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMihrkmpbizc(BizCurrency pMihrkmpbizc) {
        mihrkmpbizc = pMihrkmpbizc;
        mihrkmpbizcValue = null;
        mihrkmpbizcType  = null;
    }

    transient private BigDecimal mihrkmpbizcValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MIHRKMPBIZC, nullable=true)
    protected BigDecimal getMihrkmpbizcValue() {
        if (mihrkmpbizcValue == null && mihrkmpbizc != null) {
            if (mihrkmpbizc.isOptional()) return null;
            return mihrkmpbizc.absolute();
        }
        return mihrkmpbizcValue;
    }

    protected void setMihrkmpbizcValue(BigDecimal value) {
        mihrkmpbizcValue = value;
        mihrkmpbizc = Optional.fromNullable(toCurrencyType(mihrkmpbizcType))
            .transform(bizCurrencyTransformer(getMihrkmpbizcValue()))
            .orNull();
    }

    transient private String mihrkmpbizcType = null;

    @Column(name=MIHRKMPBIZC + "$", nullable=true)
    protected String getMihrkmpbizcType() {
        if (mihrkmpbizcType == null && mihrkmpbizc != null) return mihrkmpbizc.getType().toString();
        if (mihrkmpbizcType == null && getMihrkmpbizcValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mihrkmpbizc$' should not be NULL."));
        }
        return mihrkmpbizcType;
    }

    protected void setMihrkmpbizcType(String type) {
        mihrkmpbizcType = type;
        mihrkmpbizc = Optional.fromNullable(toCurrencyType(mihrkmpbizcType))
            .transform(bizCurrencyTransformer(getMihrkmpbizcValue()))
            .orNull();
    }

    private BizDate shrymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiTyousyo.SHRYMD)
    @ValidDate
    public BizDate getShrymd() {
        return shrymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrymd(BizDate pShrymd) {
        shrymd = pShrymd;
    }

    private String syorisosikicd;

    @Column(name=GenJT_SiTyousyo.SYORISOSIKICD)
    public String getSyorisosikicd() {
        return syorisosikicd;
    }

    public void setSyorisosikicd(String pSyorisosikicd) {
        syorisosikicd = pSyorisosikicd;
    }

    private String syoritaisyoukbn;

    @Column(name=GenJT_SiTyousyo.SYORITAISYOUKBN)
    public String getSyoritaisyoukbn() {
        return syoritaisyoukbn;
    }

    public void setSyoritaisyoukbn(String pSyoritaisyoukbn) {
        syoritaisyoukbn = pSyoritaisyoukbn;
    }

    private String shrtysytsinyno;

    @Column(name=GenJT_SiTyousyo.SHRTYSYTSINYNO)
    public String getShrtysytsinyno() {
        return shrtysytsinyno;
    }

    public void setShrtysytsinyno(String pShrtysytsinyno) {
        shrtysytsinyno = pShrtysytsinyno;
    }

    private String shrtysyadr1kj;

    @Column(name=GenJT_SiTyousyo.SHRTYSYADR1KJ)
    public String getShrtysyadr1kj() {
        return shrtysyadr1kj;
    }

    public void setShrtysyadr1kj(String pShrtysyadr1kj) {
        shrtysyadr1kj = pShrtysyadr1kj;
    }

    private String shrtysyadr2kj;

    @Column(name=GenJT_SiTyousyo.SHRTYSYADR2KJ)
    public String getShrtysyadr2kj() {
        return shrtysyadr2kj;
    }

    public void setShrtysyadr2kj(String pShrtysyadr2kj) {
        shrtysyadr2kj = pShrtysyadr2kj;
    }

    private String shrtysyadr3kj;

    @Column(name=GenJT_SiTyousyo.SHRTYSYADR3KJ)
    public String getShrtysyadr3kj() {
        return shrtysyadr3kj;
    }

    public void setShrtysyadr3kj(String pShrtysyadr3kj) {
        shrtysyadr3kj = pShrtysyadr3kj;
    }

    private String kyknmkj;

    @Column(name=GenJT_SiTyousyo.KYKNMKJ)
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

    private String hhknnmkj;

    @Column(name=GenJT_SiTyousyo.HHKNNMKJ)
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

    private String uktnmkj;

    @Column(name=GenJT_SiTyousyo.UKTNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getUktnmkj() {
        return uktnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setUktnmkj(String pUktnmkj) {
        uktnmkj = pUktnmkj;
    }

    private String kjdaihyouuktnm;

    @Column(name=GenJT_SiTyousyo.KJDAIHYOUUKTNM)
    public String getKjdaihyouuktnm() {
        return kjdaihyouuktnm;
    }

    public void setKjdaihyouuktnm(String pKjdaihyouuktnm) {
        kjdaihyouuktnm = pKjdaihyouuktnm;
    }

    private BizCurrency shrtienrsk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrtienrsk() {
        return shrtienrsk;
    }

    public void setShrtienrsk(BizCurrency pShrtienrsk) {
        shrtienrsk = pShrtienrsk;
        shrtienrskValue = null;
        shrtienrskType  = null;
    }

    transient private BigDecimal shrtienrskValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRTIENRSK, nullable=true)
    protected BigDecimal getShrtienrskValue() {
        if (shrtienrskValue == null && shrtienrsk != null) {
            if (shrtienrsk.isOptional()) return null;
            return shrtienrsk.absolute();
        }
        return shrtienrskValue;
    }

    protected void setShrtienrskValue(BigDecimal value) {
        shrtienrskValue = value;
        shrtienrsk = Optional.fromNullable(toCurrencyType(shrtienrskType))
            .transform(bizCurrencyTransformer(getShrtienrskValue()))
            .orNull();
    }

    transient private String shrtienrskType = null;

    @Column(name=SHRTIENRSK + "$", nullable=true)
    protected String getShrtienrskType() {
        if (shrtienrskType == null && shrtienrsk != null) return shrtienrsk.getType().toString();
        if (shrtienrskType == null && getShrtienrskValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrtienrsk$' should not be NULL."));
        }
        return shrtienrskType;
    }

    protected void setShrtienrskType(String type) {
        shrtienrskType = type;
        shrtienrsk = Optional.fromNullable(toCurrencyType(shrtienrskType))
            .transform(bizCurrencyTransformer(getShrtienrskValue()))
            .orNull();
    }

    private BizCurrency kihons;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    public BizCurrency getKihons() {
        return kihons;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihons(BizCurrency pKihons) {
        kihons = pKihons;
        kihonsValue = null;
        kihonsType  = null;
    }

    transient private BigDecimal kihonsValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIHONS, nullable=true)
    protected BigDecimal getKihonsValue() {
        if (kihonsValue == null && kihons != null) {
            if (kihons.isOptional()) return null;
            return kihons.absolute();
        }
        return kihonsValue;
    }

    protected void setKihonsValue(BigDecimal value) {
        kihonsValue = value;
        kihons = Optional.fromNullable(toCurrencyType(kihonsType))
            .transform(bizCurrencyTransformer(getKihonsValue()))
            .orNull();
    }

    transient private String kihonsType = null;

    @Column(name=KIHONS + "$", nullable=true)
    protected String getKihonsType() {
        if (kihonsType == null && kihons != null) return kihons.getType().toString();
        if (kihonsType == null && getKihonsValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kihons$' should not be NULL."));
        }
        return kihonsType;
    }

    protected void setKihonsType(String type) {
        kihonsType = type;
        kihons = Optional.fromNullable(toCurrencyType(kihonsType))
            .transform(bizCurrencyTransformer(getKihonsValue()))
            .orNull();
    }

    private String shrtysysyuruicd;

    @Column(name=GenJT_SiTyousyo.SHRTYSYSYURUICD)
    public String getShrtysysyuruicd() {
        return shrtysysyuruicd;
    }

    public void setShrtysysyuruicd(String pShrtysysyuruicd) {
        shrtysysyuruicd = pShrtysysyuruicd;
    }

    private String teknjikihrpseibidisp;

    @Column(name=GenJT_SiTyousyo.TEKNJIKIHRPSEIBIDISP)
    public String getTeknjikihrpseibidisp() {
        return teknjikihrpseibidisp;
    }

    public void setTeknjikihrpseibidisp(String pTeknjikihrpseibidisp) {
        teknjikihrpseibidisp = pTeknjikihrpseibidisp;
    }

    private BizCurrency kihrkmp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKihrkmp() {
        return kihrkmp;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihrkmp(BizCurrency pKihrkmp) {
        kihrkmp = pKihrkmp;
        kihrkmpValue = null;
        kihrkmpType  = null;
    }

    transient private BigDecimal kihrkmpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIHRKMP, nullable=true)
    protected BigDecimal getKihrkmpValue() {
        if (kihrkmpValue == null && kihrkmp != null) {
            if (kihrkmp.isOptional()) return null;
            return kihrkmp.absolute();
        }
        return kihrkmpValue;
    }

    protected void setKihrkmpValue(BigDecimal value) {
        kihrkmpValue = value;
        kihrkmp = Optional.fromNullable(toCurrencyType(kihrkmpType))
            .transform(bizCurrencyTransformer(getKihrkmpValue()))
            .orNull();
    }

    transient private String kihrkmpType = null;

    @Column(name=KIHRKMP + "$", nullable=true)
    protected String getKihrkmpType() {
        if (kihrkmpType == null && kihrkmp != null) return kihrkmp.getType().toString();
        if (kihrkmpType == null && getKihrkmpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kihrkmp$' should not be NULL."));
        }
        return kihrkmpType;
    }

    protected void setKihrkmpType(String type) {
        kihrkmpType = type;
        kihrkmp = Optional.fromNullable(toCurrencyType(kihrkmpType))
            .transform(bizCurrencyTransformer(getKihrkmpValue()))
            .orNull();
    }

    private String onlinecentercutkbn;

    @Column(name=GenJT_SiTyousyo.ONLINECENTERCUTKBN)
    public String getOnlinecentercutkbn() {
        return onlinecentercutkbn;
    }

    public void setOnlinecentercutkbn(String pOnlinecentercutkbn) {
        onlinecentercutkbn = pOnlinecentercutkbn;
    }

    private C_ShrhousiteiKbn shrhousiteikbn;

    @Type(type="UserType_C_ShrhousiteiKbn")
    @Column(name=GenJT_SiTyousyo.SHRHOUSITEIKBN)
    public C_ShrhousiteiKbn getShrhousiteikbn() {
        return shrhousiteikbn;
    }

    public void setShrhousiteikbn(C_ShrhousiteiKbn pShrhousiteikbn) {
        shrhousiteikbn = pShrhousiteikbn;
    }

    private String htykeihihnsyukbn;

    @Column(name=GenJT_SiTyousyo.HTYKEIHIHNSYUKBN)
    public String getHtykeihihnsyukbn() {
        return htykeihihnsyukbn;
    }

    public void setHtykeihihnsyukbn(String pHtykeihihnsyukbn) {
        htykeihihnsyukbn = pHtykeihihnsyukbn;
    }

    private BizCurrency syuseijtshrdbizc;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSyuseijtshrdbizc() {
        return syuseijtshrdbizc;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyuseijtshrdbizc(BizCurrency pSyuseijtshrdbizc) {
        syuseijtshrdbizc = pSyuseijtshrdbizc;
        syuseijtshrdbizcValue = null;
        syuseijtshrdbizcType  = null;
    }

    transient private BigDecimal syuseijtshrdbizcValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SYUSEIJTSHRDBIZC, nullable=true)
    protected BigDecimal getSyuseijtshrdbizcValue() {
        if (syuseijtshrdbizcValue == null && syuseijtshrdbizc != null) {
            if (syuseijtshrdbizc.isOptional()) return null;
            return syuseijtshrdbizc.absolute();
        }
        return syuseijtshrdbizcValue;
    }

    protected void setSyuseijtshrdbizcValue(BigDecimal value) {
        syuseijtshrdbizcValue = value;
        syuseijtshrdbizc = Optional.fromNullable(toCurrencyType(syuseijtshrdbizcType))
            .transform(bizCurrencyTransformer(getSyuseijtshrdbizcValue()))
            .orNull();
    }

    transient private String syuseijtshrdbizcType = null;

    @Column(name=SYUSEIJTSHRDBIZC + "$", nullable=true)
    protected String getSyuseijtshrdbizcType() {
        if (syuseijtshrdbizcType == null && syuseijtshrdbizc != null) return syuseijtshrdbizc.getType().toString();
        if (syuseijtshrdbizcType == null && getSyuseijtshrdbizcValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'syuseijtshrdbizc$' should not be NULL."));
        }
        return syuseijtshrdbizcType;
    }

    protected void setSyuseijtshrdbizcType(String type) {
        syuseijtshrdbizcType = type;
        syuseijtshrdbizc = Optional.fromNullable(toCurrencyType(syuseijtshrdbizcType))
            .transform(bizCurrencyTransformer(getSyuseijtshrdbizcValue()))
            .orNull();
    }

    private String touduketorihouhoukbn;

    @Column(name=GenJT_SiTyousyo.TOUDUKETORIHOUHOUKBN)
    public String getTouduketorihouhoukbn() {
        return touduketorihouhoukbn;
    }

    public void setTouduketorihouhoukbn(String pTouduketorihouhoukbn) {
        touduketorihouhoukbn = pTouduketorihouhoukbn;
    }

    private Integer nenkinkkn;

    @Column(name=GenJT_SiTyousyo.NENKINKKN)
    public Integer getNenkinkkn() {
        return nenkinkkn;
    }

    public void setNenkinkkn(Integer pNenkinkkn) {
        nenkinkkn = pNenkinkkn;
    }

    private String bankcd;

    @Column(name=GenJT_SiTyousyo.BANKCD)
    @Length(length=4)
    @Digit
    public String getBankcd() {
        return bankcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBankcd(String pBankcd) {
        bankcd = pBankcd;
    }

    private String banknmkn;

    @Column(name=GenJT_SiTyousyo.BANKNMKN)
    @MaxLength(max=25)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getBanknmkn() {
        return banknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBanknmkn(String pBanknmkn) {
        banknmkn = pBanknmkn;
    }

    private String sitencd;

    @Column(name=GenJT_SiTyousyo.SITENCD)
    @Length(length=3)
    @Digit
    public String getSitencd() {
        return sitencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSitencd(String pSitencd) {
        sitencd = pSitencd;
    }

    private String sitennmkn;

    @Column(name=GenJT_SiTyousyo.SITENNMKN)
    @MaxLength(max=25)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getSitennmkn() {
        return sitennmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSitennmkn(String pSitennmkn) {
        sitennmkn = pSitennmkn;
    }

    private C_YokinKbn yokinkbn;

    @Type(type="UserType_C_YokinKbn")
    @Column(name=GenJT_SiTyousyo.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String yokinknmkn;

    @Column(name=GenJT_SiTyousyo.YOKINKNMKN)
    @HostInvalidCharacter
    public String getYokinknmkn() {
        return yokinknmkn;
    }

    public void setYokinknmkn(String pYokinknmkn) {
        yokinknmkn = pYokinknmkn;
    }

    private String kouzano;

    @Column(name=GenJT_SiTyousyo.KOUZANO)
    @MaxLength(max=12)
    @HostInvalidCharacter
    public String getKouzano() {
        return kouzano;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKouzano(String pKouzano) {
        kouzano = pKouzano;
    }

    private String kzmeiginmkn;

    @Column(name=GenJT_SiTyousyo.KZMEIGINMKN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKzmeiginmkn() {
        return kzmeiginmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKzmeiginmkn(String pKzmeiginmkn) {
        kzmeiginmkn = pKzmeiginmkn;
    }

    private BizDate sakuseiymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiTyousyo.SAKUSEIYMD)
    @ValidDate
    public BizDate getSakuseiymd() {
        return sakuseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSakuseiymd(BizDate pSakuseiymd) {
        sakuseiymd = pSakuseiymd;
    }

    private String kykmnmeigibangou;

    @Column(name=GenJT_SiTyousyo.KYKMNMEIGIBANGOU)
    @Length(length=3)
    @Digit
    public String getKykmnmeigibangou() {
        return kykmnmeigibangou;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykmnmeigibangou(String pKykmnmeigibangou) {
        kykmnmeigibangou = pKykmnmeigibangou;
    }

    private String uktmnmeigibangou;

    @Column(name=GenJT_SiTyousyo.UKTMNMEIGIBANGOU)
    @Length(length=3)
    @Digit
    public String getUktmnmeigibangou() {
        return uktmnmeigibangou;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktmnmeigibangou(String pUktmnmeigibangou) {
        uktmnmeigibangou = pUktmnmeigibangou;
    }

    private String jigyoukykmndantaicd;

    @Column(name=GenJT_SiTyousyo.JIGYOUKYKMNDANTAICD)
    public String getJigyoukykmndantaicd() {
        return jigyoukykmndantaicd;
    }

    public void setJigyoukykmndantaicd(String pJigyoukykmndantaicd) {
        jigyoukykmndantaicd = pJigyoukykmndantaicd;
    }

    private String mnsaiannaihnskakbn;

    @Column(name=GenJT_SiTyousyo.MNSAIANNAIHNSKAKBN)
    public String getMnsaiannaihnskakbn() {
        return mnsaiannaihnskakbn;
    }

    public void setMnsaiannaihnskakbn(String pMnsaiannaihnskakbn) {
        mnsaiannaihnskakbn = pMnsaiannaihnskakbn;
    }

    private String huho2kykdisp;

    @Column(name=GenJT_SiTyousyo.HUHO2KYKDISP)
    public String getHuho2kykdisp() {
        return huho2kykdisp;
    }

    public void setHuho2kykdisp(String pHuho2kykdisp) {
        huho2kykdisp = pHuho2kykdisp;
    }

    private C_ShrtysyhknsyuKbn shrtysyhknsyukbn;

    @Type(type="UserType_C_ShrtysyhknsyuKbn")
    @Column(name=GenJT_SiTyousyo.SHRTYSYHKNSYUKBN)
    public C_ShrtysyhknsyuKbn getShrtysyhknsyukbn() {
        return shrtysyhknsyukbn;
    }

    public void setShrtysyhknsyukbn(C_ShrtysyhknsyuKbn pShrtysyhknsyukbn) {
        shrtysyhknsyukbn = pShrtysyhknsyukbn;
    }

    private String shrtysykurikosidisp;

    @Column(name=GenJT_SiTyousyo.SHRTYSYKURIKOSIDISP)
    public String getShrtysykurikosidisp() {
        return shrtysykurikosidisp;
    }

    public void setShrtysykurikosidisp(String pShrtysykurikosidisp) {
        shrtysykurikosidisp = pShrtysykurikosidisp;
    }

    private String tsinyno;

    @Column(name=GenJT_SiTyousyo.TSINYNO)
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

    @Column(name=GenJT_SiTyousyo.TSINADR1KJ)
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

    @Column(name=GenJT_SiTyousyo.TSINADR2KJ)
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

    @Column(name=GenJT_SiTyousyo.TSINADR3KJ)
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

    private String synyhsjykykndisp;

    @Column(name=GenJT_SiTyousyo.SYNYHSJYKYKNDISP)
    public String getSynyhsjykykndisp() {
        return synyhsjykykndisp;
    }

    public void setSynyhsjykykndisp(String pSynyhsjykykndisp) {
        synyhsjykykndisp = pSynyhsjykykndisp;
    }

    private String tblsakuseihunodisp;

    @Column(name=GenJT_SiTyousyo.TBLSAKUSEIHUNODISP)
    public String getTblsakuseihunodisp() {
        return tblsakuseihunodisp;
    }

    public void setTblsakuseihunodisp(String pTblsakuseihunodisp) {
        tblsakuseihunodisp = pTblsakuseihunodisp;
    }

    private String daihyouktkbn;

    @Column(name=GenJT_SiTyousyo.DAIHYOUKTKBN)
    public String getDaihyouktkbn() {
        return daihyouktkbn;
    }

    public void setDaihyouktkbn(String pDaihyouktkbn) {
        daihyouktkbn = pDaihyouktkbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenJT_SiTyousyo.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_SiTyousyo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_SiTyousyo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private String oldtsinyno;

    @Column(name=GenJT_SiTyousyo.OLDTSINYNO)
    public String getOldtsinyno() {
        return oldtsinyno;
    }

    public void setOldtsinyno(String pOldtsinyno) {
        oldtsinyno = pOldtsinyno;
    }

    private String oldtsinadr1kj;

    @Column(name=GenJT_SiTyousyo.OLDTSINADR1KJ)
    public String getOldtsinadr1kj() {
        return oldtsinadr1kj;
    }

    public void setOldtsinadr1kj(String pOldtsinadr1kj) {
        oldtsinadr1kj = pOldtsinadr1kj;
    }

    private String oldtsinadr2kj;

    @Column(name=GenJT_SiTyousyo.OLDTSINADR2KJ)
    public String getOldtsinadr2kj() {
        return oldtsinadr2kj;
    }

    public void setOldtsinadr2kj(String pOldtsinadr2kj) {
        oldtsinadr2kj = pOldtsinadr2kj;
    }

    private String oldtsinadr3kj;

    @Column(name=GenJT_SiTyousyo.OLDTSINADR3KJ)
    public String getOldtsinadr3kj() {
        return oldtsinadr3kj;
    }

    public void setOldtsinadr3kj(String pOldtsinadr3kj) {
        oldtsinadr3kj = pOldtsinadr3kj;
    }

    private String oldkyknmkj;

    @Column(name=GenJT_SiTyousyo.OLDKYKNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getOldkyknmkj() {
        return oldkyknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setOldkyknmkj(String pOldkyknmkj) {
        oldkyknmkj = pOldkyknmkj;
    }

    private Integer kykhnkkaisuu;

    @Column(name=GenJT_SiTyousyo.KYKHNKKAISUU)
    public Integer getKykhnkkaisuu() {
        return kykhnkkaisuu;
    }

    public void setKykhnkkaisuu(Integer pKykhnkkaisuu) {
        kykhnkkaisuu = pKykhnkkaisuu;
    }

    private String shrkykhtykeihiyouhyj;

    @Column(name=GenJT_SiTyousyo.SHRKYKHTYKEIHIYOUHYJ)
    public String getShrkykhtykeihiyouhyj() {
        return shrkykhtykeihiyouhyj;
    }

    public void setShrkykhtykeihiyouhyj(String pShrkykhtykeihiyouhyj) {
        shrkykhtykeihiyouhyj = pShrkykhtykeihiyouhyj;
    }

    private BizCurrency shrkykhtykeihi;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrkykhtykeihi() {
        return shrkykhtykeihi;
    }

    public void setShrkykhtykeihi(BizCurrency pShrkykhtykeihi) {
        shrkykhtykeihi = pShrkykhtykeihi;
        shrkykhtykeihiValue = null;
        shrkykhtykeihiType  = null;
    }

    transient private BigDecimal shrkykhtykeihiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRKYKHTYKEIHI, nullable=true)
    protected BigDecimal getShrkykhtykeihiValue() {
        if (shrkykhtykeihiValue == null && shrkykhtykeihi != null) {
            if (shrkykhtykeihi.isOptional()) return null;
            return shrkykhtykeihi.absolute();
        }
        return shrkykhtykeihiValue;
    }

    protected void setShrkykhtykeihiValue(BigDecimal value) {
        shrkykhtykeihiValue = value;
        shrkykhtykeihi = Optional.fromNullable(toCurrencyType(shrkykhtykeihiType))
            .transform(bizCurrencyTransformer(getShrkykhtykeihiValue()))
            .orNull();
    }

    transient private String shrkykhtykeihiType = null;

    @Column(name=SHRKYKHTYKEIHI + "$", nullable=true)
    protected String getShrkykhtykeihiType() {
        if (shrkykhtykeihiType == null && shrkykhtykeihi != null) return shrkykhtykeihi.getType().toString();
        if (shrkykhtykeihiType == null && getShrkykhtykeihiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrkykhtykeihi$' should not be NULL."));
        }
        return shrkykhtykeihiType;
    }

    protected void setShrkykhtykeihiType(String type) {
        shrkykhtykeihiType = type;
        shrkykhtykeihi = Optional.fromNullable(toCurrencyType(shrkykhtykeihiType))
            .transform(bizCurrencyTransformer(getShrkykhtykeihiValue()))
            .orNull();
    }
}