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
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
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
import yuyu.def.classification.C_DseisansouhusakihnsyuKbn;
import yuyu.def.classification.C_DseisantetudukimeiKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.IT_DSeisanTuibaraiKanri;
import yuyu.def.db.id.PKIT_DSeisanTuibaraiKanri;
import yuyu.def.db.meta.GenQIT_DSeisanTuibaraiKanri;
import yuyu.def.db.meta.QIT_DSeisanTuibaraiKanri;
import yuyu.def.db.type.UserType_C_DseisansouhusakihnsyuKbn;
import yuyu.def.db.type.UserType_C_DseisantetudukimeiKbn;
import yuyu.def.db.type.UserType_C_InputShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_Kaiyakujiyuu;
import yuyu.def.db.type.UserType_C_KouzasyuruiKbn;
import yuyu.def.db.type.UserType_C_Kzdou;
import yuyu.def.db.type.UserType_C_ShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.def.db.type.UserType_C_YouhiKbn;
import yuyu.def.db.type.UserType_C_ZeitratkiKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * Ｄ精算追払管理テーブル テーブルのマッピング情報クラスで、 {@link IT_DSeisanTuibaraiKanri} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_DSeisanTuibaraiKanri}</td><td colspan="3">Ｄ精算追払管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_DSeisanTuibaraiKanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_DSeisanTuibaraiKanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHaitounendo haitounendo}</td><td>配当年度</td><td align="center">{@link PKIT_DSeisanTuibaraiKanri ○}</td><td align="center">V</td><td>BizDateY</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getShrhousiteikbn shrhousiteikbn}</td><td>支払方法指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ShrhousiteiKbn}</td></tr>
 *  <tr><td>{@link #getInputshrhousiteikbn inputshrhousiteikbn}</td><td>入力用支払方法指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_InputShrhousiteiKbn}</td></tr>
 *  <tr><td>{@link #getTuibaraiyouhikbn tuibaraiyouhikbn}</td><td>追払要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YouhiKbn}</td></tr>
 *  <tr><td>{@link #getTuutisakuseiyouhikbn tuutisakuseiyouhikbn}</td><td>通知作成要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YouhiKbn}</td></tr>
 *  <tr><td>{@link #getDseisansouhusakihnsyukbn dseisansouhusakihnsyukbn}</td><td>Ｄ精算送付先編集区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DseisansouhusakihnsyuKbn}</td></tr>
 *  <tr><td>{@link #getDseisantetudukimeikbn dseisantetudukimeikbn}</td><td>Ｄ精算手続名区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DseisantetudukimeiKbn}</td></tr>
 *  <tr><td>{@link #getShrymd shrymd}</td><td>支払日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrtienrskkisanymd shrtienrskkisanymd}</td><td>支払遅延利息起算日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTienrsknissuu tienrsknissuu}</td><td>遅延利息日数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyoruiukeymd syoruiukeymd}</td><td>書類受付日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKouryokuhasseiymd kouryokuhasseiymd}</td><td>効力発生日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrtuukasyu shrtuukasyu}</td><td>支払通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getGsbunritaisyou gsbunritaisyou}</td><td>源泉分離課税対象</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getYenshrtkumu yenshrtkumu}</td><td>円支払特約有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKzsyuruikbn kzsyuruikbn}</td><td>口座種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KouzasyuruiKbn}</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzdoukbn kzdoukbn}</td><td>口座名義人同一区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kzdou}</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGaikashrkwsratekjnymd gaikashrkwsratekjnymd}</td><td>外貨支払時為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGaikashrkwsrate gaikashrkwsrate}</td><td>外貨支払時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZeimukwsratekjnymd zeimukwsratekjnymd}</td><td>税務用為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZeimukwsrate zeimukwsrate}</td><td>税務用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getNztodouhukencd nztodouhukencd}</td><td>納税先都道府県コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYensynykngk yensynykngk}</td><td>円換算収入金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenhtykeihi yenhtykeihi}</td><td>円換算必要経費</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkztgk yenkztgk}</td><td>円換算課税対象額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenshrkykhtykeihi yenshrkykhtykeihi}</td><td>円換算支払時契約者必要経費</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKykhnkkaisuu kykhnkkaisuu}</td><td>契約者変更回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getShrtysykurikosiyouhi shrtysykurikosiyouhi}</td><td>支払調書繰越要否</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YouhiKbn}</td></tr>
 *  <tr><td>{@link #getSoukinsakinmkj soukinsakinmkj}</td><td>送金先氏名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSoukinsakiyno soukinsakiyno}</td><td>送金先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSoukinsakiadr1kj soukinsakiadr1kj}</td><td>送金先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSoukinsakiadr2kj soukinsakiadr2kj}</td><td>送金先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSoukinsakiadr3kj soukinsakiadr3kj}</td><td>送金先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKaiyakujiyuu kaiyakujiyuu}</td><td>解約事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kaiyakujiyuu}</td></tr>
 *  <tr><td>{@link #getShrtuukashrgkgoukei shrtuukashrgkgoukei}</td><td>支払通貨支払額合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrtuukagstszeigk shrtuukagstszeigk}</td><td>支払通貨源泉徴収税額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrtuukashrtienrsk shrtuukashrtienrsk}</td><td>支払通貨支払遅延利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrtuukasonotashrkngk shrtuukasonotashrkngk}</td><td>支払通貨その他支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkansanhaitoukin yenkansanhaitoukin}</td><td>円換算配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYensonotahaitoukin yensonotahaitoukin}</td><td>円換算その他配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenshrgkgoukei yenshrgkgoukei}</td><td>円換算支払額合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYengstszeigk yengstszeigk}</td><td>円換算源泉徴収税額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYengstszeigknationaltax yengstszeigknationaltax}</td><td>円換算源泉徴収税額（国税）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYengstszeigklocaltax yengstszeigklocaltax}</td><td>円換算源泉徴収税額（地方税）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenshrtienrsk yenshrtienrsk}</td><td>円換算支払遅延利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSonotashrkngkyen sonotashrkngkyen}</td><td>その他支払金額（円貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSonotashrkngksiteituuka sonotashrkngksiteituuka}</td><td>その他支払金額（指定通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZeitratkikbn zeitratkikbn}</td><td>税取扱区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ZeitratkiKbn}</td></tr>
 * </table>
 * @see     IT_DSeisanTuibaraiKanri
 * @see     PKIT_DSeisanTuibaraiKanri
 * @see     QIT_DSeisanTuibaraiKanri
 * @see     GenQIT_DSeisanTuibaraiKanri
 */
@MappedSuperclass
@Table(name=GenIT_DSeisanTuibaraiKanri.TABLE_NAME)
@IdClass(value=PKIT_DSeisanTuibaraiKanri.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYType", typeClass=BizDateYType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_DseisansouhusakihnsyuKbn", typeClass=UserType_C_DseisansouhusakihnsyuKbn.class),
    @TypeDef(name="UserType_C_DseisantetudukimeiKbn", typeClass=UserType_C_DseisantetudukimeiKbn.class),
    @TypeDef(name="UserType_C_InputShrhousiteiKbn", typeClass=UserType_C_InputShrhousiteiKbn.class),
    @TypeDef(name="UserType_C_Kaiyakujiyuu", typeClass=UserType_C_Kaiyakujiyuu.class),
    @TypeDef(name="UserType_C_KouzasyuruiKbn", typeClass=UserType_C_KouzasyuruiKbn.class),
    @TypeDef(name="UserType_C_Kzdou", typeClass=UserType_C_Kzdou.class),
    @TypeDef(name="UserType_C_ShrhousiteiKbn", typeClass=UserType_C_ShrhousiteiKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class),
    @TypeDef(name="UserType_C_YouhiKbn", typeClass=UserType_C_YouhiKbn.class),
    @TypeDef(name="UserType_C_ZeitratkiKbn", typeClass=UserType_C_ZeitratkiKbn.class)
})
public abstract class GenIT_DSeisanTuibaraiKanri extends AbstractExDBEntity<IT_DSeisanTuibaraiKanri, PKIT_DSeisanTuibaraiKanri> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_DSeisanTuibaraiKanri";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String HAITOUNENDO              = "haitounendo";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String KYKYMD                   = "kykymd";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String SHRHOUSITEIKBN           = "shrhousiteikbn";
    public static final String INPUTSHRHOUSITEIKBN      = "inputshrhousiteikbn";
    public static final String TUIBARAIYOUHIKBN         = "tuibaraiyouhikbn";
    public static final String TUUTISAKUSEIYOUHIKBN     = "tuutisakuseiyouhikbn";
    public static final String DSEISANSOUHUSAKIHNSYUKBN = "dseisansouhusakihnsyukbn";
    public static final String DSEISANTETUDUKIMEIKBN    = "dseisantetudukimeikbn";
    public static final String SHRYMD                   = "shrymd";
    public static final String SHRTIENRSKKISANYMD       = "shrtienrskkisanymd";
    public static final String TIENRSKNISSUU            = "tienrsknissuu";
    public static final String SYORUIUKEYMD             = "syoruiukeymd";
    public static final String KOURYOKUHASSEIYMD        = "kouryokuhasseiymd";
    public static final String SHRTUUKASYU              = "shrtuukasyu";
    public static final String GSBUNRITAISYOU           = "gsbunritaisyou";
    public static final String YENSHRTKUMU              = "yenshrtkumu";
    public static final String KZSYURUIKBN              = "kzsyuruikbn";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String KZDOUKBN                 = "kzdoukbn";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String GAIKASHRKWSRATEKJNYMD    = "gaikashrkwsratekjnymd";
    public static final String GAIKASHRKWSRATE          = "gaikashrkwsrate";
    public static final String ZEIMUKWSRATEKJNYMD       = "zeimukwsratekjnymd";
    public static final String ZEIMUKWSRATE             = "zeimukwsrate";
    public static final String NZTODOUHUKENCD           = "nztodouhukencd";
    public static final String YENSYNYKNGK              = "yensynykngk";
    public static final String YENHTYKEIHI              = "yenhtykeihi";
    public static final String YENKZTGK                 = "yenkztgk";
    public static final String YENSHRKYKHTYKEIHI        = "yenshrkykhtykeihi";
    public static final String KYKHNKKAISUU             = "kykhnkkaisuu";
    public static final String SHRTYSYKURIKOSIYOUHI     = "shrtysykurikosiyouhi";
    public static final String SOUKINSAKINMKJ           = "soukinsakinmkj";
    public static final String SOUKINSAKIYNO            = "soukinsakiyno";
    public static final String SOUKINSAKIADR1KJ         = "soukinsakiadr1kj";
    public static final String SOUKINSAKIADR2KJ         = "soukinsakiadr2kj";
    public static final String SOUKINSAKIADR3KJ         = "soukinsakiadr3kj";
    public static final String KAIYAKUJIYUU             = "kaiyakujiyuu";
    public static final String SHRTUUKASHRGKGOUKEI      = "shrtuukashrgkgoukei";
    public static final String SHRTUUKAGSTSZEIGK        = "shrtuukagstszeigk";
    public static final String SHRTUUKASHRTIENRSK       = "shrtuukashrtienrsk";
    public static final String SHRTUUKASONOTASHRKNGK    = "shrtuukasonotashrkngk";
    public static final String YENKANSANHAITOUKIN       = "yenkansanhaitoukin";
    public static final String YENSONOTAHAITOUKIN       = "yensonotahaitoukin";
    public static final String YENSHRGKGOUKEI           = "yenshrgkgoukei";
    public static final String YENGSTSZEIGK             = "yengstszeigk";
    public static final String YENGSTSZEIGKNATIONALTAX  = "yengstszeigknationaltax";
    public static final String YENGSTSZEIGKLOCALTAX     = "yengstszeigklocaltax";
    public static final String YENSHRTIENRSK            = "yenshrtienrsk";
    public static final String SONOTASHRKNGKYEN         = "sonotashrkngkyen";
    public static final String SONOTASHRKNGKSITEITUUKA  = "sonotashrkngksiteituuka";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String ZEITRATKIKBN             = "zeitratkikbn";

    private final PKIT_DSeisanTuibaraiKanri primaryKey;

    public GenIT_DSeisanTuibaraiKanri() {
        primaryKey = new PKIT_DSeisanTuibaraiKanri();
    }

    public GenIT_DSeisanTuibaraiKanri(
        String pKbnkey,
        String pSyono,
        BizDateY pHaitounendo
    ) {
        primaryKey = new PKIT_DSeisanTuibaraiKanri(
            pKbnkey,
            pSyono,
            pHaitounendo
        );
    }

    @Transient
    @Override
    public PKIT_DSeisanTuibaraiKanri getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_DSeisanTuibaraiKanri> getMetaClass() {
        return QIT_DSeisanTuibaraiKanri.class;
    }

    @Id
    @Column(name=GenIT_DSeisanTuibaraiKanri.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_DSeisanTuibaraiKanri.SYONO)
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
    @Type(type="BizDateYType")
    @Column(name=GenIT_DSeisanTuibaraiKanri.HAITOUNENDO)
    public BizDateY getHaitounendo() {
        return getPrimaryKey().getHaitounendo();
    }

    public void setHaitounendo(BizDateY pHaitounendo) {
        getPrimaryKey().setHaitounendo(pHaitounendo);
    }

    private String syouhncd;

    @Column(name=GenIT_DSeisanTuibaraiKanri.SYOUHNCD)
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

    @Column(name=GenIT_DSeisanTuibaraiKanri.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return syouhnsdno;
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        syouhnsdno = pSyouhnsdno;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_DSeisanTuibaraiKanri.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_DSeisanTuibaraiKanri.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private C_ShrhousiteiKbn shrhousiteikbn;

    @Type(type="UserType_C_ShrhousiteiKbn")
    @Column(name=GenIT_DSeisanTuibaraiKanri.SHRHOUSITEIKBN)
    public C_ShrhousiteiKbn getShrhousiteikbn() {
        return shrhousiteikbn;
    }

    public void setShrhousiteikbn(C_ShrhousiteiKbn pShrhousiteikbn) {
        shrhousiteikbn = pShrhousiteikbn;
    }

    private C_InputShrhousiteiKbn inputshrhousiteikbn;

    @Type(type="UserType_C_InputShrhousiteiKbn")
    @Column(name=GenIT_DSeisanTuibaraiKanri.INPUTSHRHOUSITEIKBN)
    public C_InputShrhousiteiKbn getInputshrhousiteikbn() {
        return inputshrhousiteikbn;
    }

    public void setInputshrhousiteikbn(C_InputShrhousiteiKbn pInputshrhousiteikbn) {
        inputshrhousiteikbn = pInputshrhousiteikbn;
    }

    private C_YouhiKbn tuibaraiyouhikbn;

    @Type(type="UserType_C_YouhiKbn")
    @Column(name=GenIT_DSeisanTuibaraiKanri.TUIBARAIYOUHIKBN)
    public C_YouhiKbn getTuibaraiyouhikbn() {
        return tuibaraiyouhikbn;
    }

    public void setTuibaraiyouhikbn(C_YouhiKbn pTuibaraiyouhikbn) {
        tuibaraiyouhikbn = pTuibaraiyouhikbn;
    }

    private C_YouhiKbn tuutisakuseiyouhikbn;

    @Type(type="UserType_C_YouhiKbn")
    @Column(name=GenIT_DSeisanTuibaraiKanri.TUUTISAKUSEIYOUHIKBN)
    public C_YouhiKbn getTuutisakuseiyouhikbn() {
        return tuutisakuseiyouhikbn;
    }

    public void setTuutisakuseiyouhikbn(C_YouhiKbn pTuutisakuseiyouhikbn) {
        tuutisakuseiyouhikbn = pTuutisakuseiyouhikbn;
    }

    private C_DseisansouhusakihnsyuKbn dseisansouhusakihnsyukbn;

    @Type(type="UserType_C_DseisansouhusakihnsyuKbn")
    @Column(name=GenIT_DSeisanTuibaraiKanri.DSEISANSOUHUSAKIHNSYUKBN)
    public C_DseisansouhusakihnsyuKbn getDseisansouhusakihnsyukbn() {
        return dseisansouhusakihnsyukbn;
    }

    public void setDseisansouhusakihnsyukbn(C_DseisansouhusakihnsyuKbn pDseisansouhusakihnsyukbn) {
        dseisansouhusakihnsyukbn = pDseisansouhusakihnsyukbn;
    }

    private C_DseisantetudukimeiKbn dseisantetudukimeikbn;

    @Type(type="UserType_C_DseisantetudukimeiKbn")
    @Column(name=GenIT_DSeisanTuibaraiKanri.DSEISANTETUDUKIMEIKBN)
    public C_DseisantetudukimeiKbn getDseisantetudukimeikbn() {
        return dseisantetudukimeikbn;
    }

    public void setDseisantetudukimeikbn(C_DseisantetudukimeiKbn pDseisantetudukimeikbn) {
        dseisantetudukimeikbn = pDseisantetudukimeikbn;
    }

    private BizDate shrymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_DSeisanTuibaraiKanri.SHRYMD)
    @ValidDate
    public BizDate getShrymd() {
        return shrymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrymd(BizDate pShrymd) {
        shrymd = pShrymd;
    }

    private BizDate shrtienrskkisanymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_DSeisanTuibaraiKanri.SHRTIENRSKKISANYMD)
    public BizDate getShrtienrskkisanymd() {
        return shrtienrskkisanymd;
    }

    public void setShrtienrskkisanymd(BizDate pShrtienrskkisanymd) {
        shrtienrskkisanymd = pShrtienrskkisanymd;
    }

    private Integer tienrsknissuu;

    @Column(name=GenIT_DSeisanTuibaraiKanri.TIENRSKNISSUU)
    @Range(min="0", max="99999")
    @NaturalNumber
    public Integer getTienrsknissuu() {
        return tienrsknissuu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTienrsknissuu(Integer pTienrsknissuu) {
        tienrsknissuu = pTienrsknissuu;
    }

    private BizDate syoruiukeymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_DSeisanTuibaraiKanri.SYORUIUKEYMD)
    @ValidDate
    public BizDate getSyoruiukeymd() {
        return syoruiukeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoruiukeymd(BizDate pSyoruiukeymd) {
        syoruiukeymd = pSyoruiukeymd;
    }

    private BizDate kouryokuhasseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_DSeisanTuibaraiKanri.KOURYOKUHASSEIYMD)
    public BizDate getKouryokuhasseiymd() {
        return kouryokuhasseiymd;
    }

    public void setKouryokuhasseiymd(BizDate pKouryokuhasseiymd) {
        kouryokuhasseiymd = pKouryokuhasseiymd;
    }

    private C_Tuukasyu shrtuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_DSeisanTuibaraiKanri.SHRTUUKASYU)
    public C_Tuukasyu getShrtuukasyu() {
        return shrtuukasyu;
    }

    public void setShrtuukasyu(C_Tuukasyu pShrtuukasyu) {
        shrtuukasyu = pShrtuukasyu;
    }

    private C_UmuKbn gsbunritaisyou;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_DSeisanTuibaraiKanri.GSBUNRITAISYOU)
    public C_UmuKbn getGsbunritaisyou() {
        return gsbunritaisyou;
    }

    public void setGsbunritaisyou(C_UmuKbn pGsbunritaisyou) {
        gsbunritaisyou = pGsbunritaisyou;
    }

    private C_UmuKbn yenshrtkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_DSeisanTuibaraiKanri.YENSHRTKUMU)
    public C_UmuKbn getYenshrtkumu() {
        return yenshrtkumu;
    }

    public void setYenshrtkumu(C_UmuKbn pYenshrtkumu) {
        yenshrtkumu = pYenshrtkumu;
    }

    private C_KouzasyuruiKbn kzsyuruikbn;

    @Type(type="UserType_C_KouzasyuruiKbn")
    @Column(name=GenIT_DSeisanTuibaraiKanri.KZSYURUIKBN)
    public C_KouzasyuruiKbn getKzsyuruikbn() {
        return kzsyuruikbn;
    }

    public void setKzsyuruikbn(C_KouzasyuruiKbn pKzsyuruikbn) {
        kzsyuruikbn = pKzsyuruikbn;
    }

    private String bankcd;

    @Column(name=GenIT_DSeisanTuibaraiKanri.BANKCD)
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

    private String sitencd;

    @Column(name=GenIT_DSeisanTuibaraiKanri.SITENCD)
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

    private C_YokinKbn yokinkbn;

    @Type(type="UserType_C_YokinKbn")
    @Column(name=GenIT_DSeisanTuibaraiKanri.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenIT_DSeisanTuibaraiKanri.KOUZANO)
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

    private C_Kzdou kzdoukbn;

    @Type(type="UserType_C_Kzdou")
    @Column(name=GenIT_DSeisanTuibaraiKanri.KZDOUKBN)
    public C_Kzdou getKzdoukbn() {
        return kzdoukbn;
    }

    public void setKzdoukbn(C_Kzdou pKzdoukbn) {
        kzdoukbn = pKzdoukbn;
    }

    private String kzmeiginmkn;

    @Column(name=GenIT_DSeisanTuibaraiKanri.KZMEIGINMKN)
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

    private BizDate gaikashrkwsratekjnymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_DSeisanTuibaraiKanri.GAIKASHRKWSRATEKJNYMD)
    public BizDate getGaikashrkwsratekjnymd() {
        return gaikashrkwsratekjnymd;
    }

    public void setGaikashrkwsratekjnymd(BizDate pGaikashrkwsratekjnymd) {
        gaikashrkwsratekjnymd = pGaikashrkwsratekjnymd;
    }

    private BizNumber gaikashrkwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_DSeisanTuibaraiKanri.GAIKASHRKWSRATE)
    public BizNumber getGaikashrkwsrate() {
        return gaikashrkwsrate;
    }

    public void setGaikashrkwsrate(BizNumber pGaikashrkwsrate) {
        gaikashrkwsrate = pGaikashrkwsrate;
    }

    private BizDate zeimukwsratekjnymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_DSeisanTuibaraiKanri.ZEIMUKWSRATEKJNYMD)
    public BizDate getZeimukwsratekjnymd() {
        return zeimukwsratekjnymd;
    }

    public void setZeimukwsratekjnymd(BizDate pZeimukwsratekjnymd) {
        zeimukwsratekjnymd = pZeimukwsratekjnymd;
    }

    private BizNumber zeimukwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_DSeisanTuibaraiKanri.ZEIMUKWSRATE)
    public BizNumber getZeimukwsrate() {
        return zeimukwsrate;
    }

    public void setZeimukwsrate(BizNumber pZeimukwsrate) {
        zeimukwsrate = pZeimukwsrate;
    }

    private String nztodouhukencd;

    @Column(name=GenIT_DSeisanTuibaraiKanri.NZTODOUHUKENCD)
    public String getNztodouhukencd() {
        return nztodouhukencd;
    }

    public void setNztodouhukencd(String pNztodouhukencd) {
        nztodouhukencd = pNztodouhukencd;
    }

    private BizCurrency yensynykngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYensynykngk() {
        return yensynykngk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYensynykngk(BizCurrency pYensynykngk) {
        yensynykngk = pYensynykngk;
        yensynykngkValue = null;
        yensynykngkType  = null;
    }

    transient private BigDecimal yensynykngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENSYNYKNGK, nullable=true)
    protected BigDecimal getYensynykngkValue() {
        if (yensynykngkValue == null && yensynykngk != null) {
            if (yensynykngk.isOptional()) return null;
            return yensynykngk.absolute();
        }
        return yensynykngkValue;
    }

    protected void setYensynykngkValue(BigDecimal value) {
        yensynykngkValue = value;
        yensynykngk = Optional.fromNullable(toCurrencyType(yensynykngkType))
            .transform(bizCurrencyTransformer(getYensynykngkValue()))
            .orNull();
    }

    transient private String yensynykngkType = null;

    @Column(name=YENSYNYKNGK + "$", nullable=true)
    protected String getYensynykngkType() {
        if (yensynykngkType == null && yensynykngk != null) return yensynykngk.getType().toString();
        if (yensynykngkType == null && getYensynykngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yensynykngk$' should not be NULL."));
        }
        return yensynykngkType;
    }

    protected void setYensynykngkType(String type) {
        yensynykngkType = type;
        yensynykngk = Optional.fromNullable(toCurrencyType(yensynykngkType))
            .transform(bizCurrencyTransformer(getYensynykngkValue()))
            .orNull();
    }

    private BizCurrency yenhtykeihi;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenhtykeihi() {
        return yenhtykeihi;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhtykeihi(BizCurrency pYenhtykeihi) {
        yenhtykeihi = pYenhtykeihi;
        yenhtykeihiValue = null;
        yenhtykeihiType  = null;
    }

    transient private BigDecimal yenhtykeihiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENHTYKEIHI, nullable=true)
    protected BigDecimal getYenhtykeihiValue() {
        if (yenhtykeihiValue == null && yenhtykeihi != null) {
            if (yenhtykeihi.isOptional()) return null;
            return yenhtykeihi.absolute();
        }
        return yenhtykeihiValue;
    }

    protected void setYenhtykeihiValue(BigDecimal value) {
        yenhtykeihiValue = value;
        yenhtykeihi = Optional.fromNullable(toCurrencyType(yenhtykeihiType))
            .transform(bizCurrencyTransformer(getYenhtykeihiValue()))
            .orNull();
    }

    transient private String yenhtykeihiType = null;

    @Column(name=YENHTYKEIHI + "$", nullable=true)
    protected String getYenhtykeihiType() {
        if (yenhtykeihiType == null && yenhtykeihi != null) return yenhtykeihi.getType().toString();
        if (yenhtykeihiType == null && getYenhtykeihiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenhtykeihi$' should not be NULL."));
        }
        return yenhtykeihiType;
    }

    protected void setYenhtykeihiType(String type) {
        yenhtykeihiType = type;
        yenhtykeihi = Optional.fromNullable(toCurrencyType(yenhtykeihiType))
            .transform(bizCurrencyTransformer(getYenhtykeihiValue()))
            .orNull();
    }

    private BizCurrency yenkztgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkztgk() {
        return yenkztgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkztgk(BizCurrency pYenkztgk) {
        yenkztgk = pYenkztgk;
        yenkztgkValue = null;
        yenkztgkType  = null;
    }

    transient private BigDecimal yenkztgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKZTGK, nullable=true)
    protected BigDecimal getYenkztgkValue() {
        if (yenkztgkValue == null && yenkztgk != null) {
            if (yenkztgk.isOptional()) return null;
            return yenkztgk.absolute();
        }
        return yenkztgkValue;
    }

    protected void setYenkztgkValue(BigDecimal value) {
        yenkztgkValue = value;
        yenkztgk = Optional.fromNullable(toCurrencyType(yenkztgkType))
            .transform(bizCurrencyTransformer(getYenkztgkValue()))
            .orNull();
    }

    transient private String yenkztgkType = null;

    @Column(name=YENKZTGK + "$", nullable=true)
    protected String getYenkztgkType() {
        if (yenkztgkType == null && yenkztgk != null) return yenkztgk.getType().toString();
        if (yenkztgkType == null && getYenkztgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkztgk$' should not be NULL."));
        }
        return yenkztgkType;
    }

    protected void setYenkztgkType(String type) {
        yenkztgkType = type;
        yenkztgk = Optional.fromNullable(toCurrencyType(yenkztgkType))
            .transform(bizCurrencyTransformer(getYenkztgkValue()))
            .orNull();
    }

    private BizCurrency yenshrkykhtykeihi;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenshrkykhtykeihi() {
        return yenshrkykhtykeihi;
    }

    public void setYenshrkykhtykeihi(BizCurrency pYenshrkykhtykeihi) {
        yenshrkykhtykeihi = pYenshrkykhtykeihi;
        yenshrkykhtykeihiValue = null;
        yenshrkykhtykeihiType  = null;
    }

    transient private BigDecimal yenshrkykhtykeihiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENSHRKYKHTYKEIHI, nullable=true)
    protected BigDecimal getYenshrkykhtykeihiValue() {
        if (yenshrkykhtykeihiValue == null && yenshrkykhtykeihi != null) {
            if (yenshrkykhtykeihi.isOptional()) return null;
            return yenshrkykhtykeihi.absolute();
        }
        return yenshrkykhtykeihiValue;
    }

    protected void setYenshrkykhtykeihiValue(BigDecimal value) {
        yenshrkykhtykeihiValue = value;
        yenshrkykhtykeihi = Optional.fromNullable(toCurrencyType(yenshrkykhtykeihiType))
            .transform(bizCurrencyTransformer(getYenshrkykhtykeihiValue()))
            .orNull();
    }

    transient private String yenshrkykhtykeihiType = null;

    @Column(name=YENSHRKYKHTYKEIHI + "$", nullable=true)
    protected String getYenshrkykhtykeihiType() {
        if (yenshrkykhtykeihiType == null && yenshrkykhtykeihi != null) return yenshrkykhtykeihi.getType().toString();
        if (yenshrkykhtykeihiType == null && getYenshrkykhtykeihiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenshrkykhtykeihi$' should not be NULL."));
        }
        return yenshrkykhtykeihiType;
    }

    protected void setYenshrkykhtykeihiType(String type) {
        yenshrkykhtykeihiType = type;
        yenshrkykhtykeihi = Optional.fromNullable(toCurrencyType(yenshrkykhtykeihiType))
            .transform(bizCurrencyTransformer(getYenshrkykhtykeihiValue()))
            .orNull();
    }

    private Integer kykhnkkaisuu;

    @Column(name=GenIT_DSeisanTuibaraiKanri.KYKHNKKAISUU)
    public Integer getKykhnkkaisuu() {
        return kykhnkkaisuu;
    }

    public void setKykhnkkaisuu(Integer pKykhnkkaisuu) {
        kykhnkkaisuu = pKykhnkkaisuu;
    }

    private C_YouhiKbn shrtysykurikosiyouhi;

    @Type(type="UserType_C_YouhiKbn")
    @Column(name=GenIT_DSeisanTuibaraiKanri.SHRTYSYKURIKOSIYOUHI)
    public C_YouhiKbn getShrtysykurikosiyouhi() {
        return shrtysykurikosiyouhi;
    }

    public void setShrtysykurikosiyouhi(C_YouhiKbn pShrtysykurikosiyouhi) {
        shrtysykurikosiyouhi = pShrtysykurikosiyouhi;
    }

    private String soukinsakinmkj;

    @Column(name=GenIT_DSeisanTuibaraiKanri.SOUKINSAKINMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getSoukinsakinmkj() {
        return soukinsakinmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSoukinsakinmkj(String pSoukinsakinmkj) {
        soukinsakinmkj = pSoukinsakinmkj;
    }

    private String soukinsakiyno;

    @Column(name=GenIT_DSeisanTuibaraiKanri.SOUKINSAKIYNO)
    @Digit
    @Length(length=7)
    public String getSoukinsakiyno() {
        return soukinsakiyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSoukinsakiyno(String pSoukinsakiyno) {
        soukinsakiyno = pSoukinsakiyno;
    }

    private String soukinsakiadr1kj;

    @Column(name=GenIT_DSeisanTuibaraiKanri.SOUKINSAKIADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getSoukinsakiadr1kj() {
        return soukinsakiadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSoukinsakiadr1kj(String pSoukinsakiadr1kj) {
        soukinsakiadr1kj = pSoukinsakiadr1kj;
    }

    private String soukinsakiadr2kj;

    @Column(name=GenIT_DSeisanTuibaraiKanri.SOUKINSAKIADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getSoukinsakiadr2kj() {
        return soukinsakiadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSoukinsakiadr2kj(String pSoukinsakiadr2kj) {
        soukinsakiadr2kj = pSoukinsakiadr2kj;
    }

    private String soukinsakiadr3kj;

    @Column(name=GenIT_DSeisanTuibaraiKanri.SOUKINSAKIADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getSoukinsakiadr3kj() {
        return soukinsakiadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSoukinsakiadr3kj(String pSoukinsakiadr3kj) {
        soukinsakiadr3kj = pSoukinsakiadr3kj;
    }

    private C_Kaiyakujiyuu kaiyakujiyuu;

    @Type(type="UserType_C_Kaiyakujiyuu")
    @Column(name=GenIT_DSeisanTuibaraiKanri.KAIYAKUJIYUU)
    public C_Kaiyakujiyuu getKaiyakujiyuu() {
        return kaiyakujiyuu;
    }

    public void setKaiyakujiyuu(C_Kaiyakujiyuu pKaiyakujiyuu) {
        kaiyakujiyuu = pKaiyakujiyuu;
    }

    private BizCurrency shrtuukashrgkgoukei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrtuukashrgkgoukei() {
        return shrtuukashrgkgoukei;
    }

    public void setShrtuukashrgkgoukei(BizCurrency pShrtuukashrgkgoukei) {
        shrtuukashrgkgoukei = pShrtuukashrgkgoukei;
        shrtuukashrgkgoukeiValue = null;
        shrtuukashrgkgoukeiType  = null;
    }

    transient private BigDecimal shrtuukashrgkgoukeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRTUUKASHRGKGOUKEI, nullable=true)
    protected BigDecimal getShrtuukashrgkgoukeiValue() {
        if (shrtuukashrgkgoukeiValue == null && shrtuukashrgkgoukei != null) {
            if (shrtuukashrgkgoukei.isOptional()) return null;
            return shrtuukashrgkgoukei.absolute();
        }
        return shrtuukashrgkgoukeiValue;
    }

    protected void setShrtuukashrgkgoukeiValue(BigDecimal value) {
        shrtuukashrgkgoukeiValue = value;
        shrtuukashrgkgoukei = Optional.fromNullable(toCurrencyType(shrtuukashrgkgoukeiType))
            .transform(bizCurrencyTransformer(getShrtuukashrgkgoukeiValue()))
            .orNull();
    }

    transient private String shrtuukashrgkgoukeiType = null;

    @Column(name=SHRTUUKASHRGKGOUKEI + "$", nullable=true)
    protected String getShrtuukashrgkgoukeiType() {
        if (shrtuukashrgkgoukeiType == null && shrtuukashrgkgoukei != null) return shrtuukashrgkgoukei.getType().toString();
        if (shrtuukashrgkgoukeiType == null && getShrtuukashrgkgoukeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrtuukashrgkgoukei$' should not be NULL."));
        }
        return shrtuukashrgkgoukeiType;
    }

    protected void setShrtuukashrgkgoukeiType(String type) {
        shrtuukashrgkgoukeiType = type;
        shrtuukashrgkgoukei = Optional.fromNullable(toCurrencyType(shrtuukashrgkgoukeiType))
            .transform(bizCurrencyTransformer(getShrtuukashrgkgoukeiValue()))
            .orNull();
    }

    private BizCurrency shrtuukagstszeigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrtuukagstszeigk() {
        return shrtuukagstszeigk;
    }

    public void setShrtuukagstszeigk(BizCurrency pShrtuukagstszeigk) {
        shrtuukagstszeigk = pShrtuukagstszeigk;
        shrtuukagstszeigkValue = null;
        shrtuukagstszeigkType  = null;
    }

    transient private BigDecimal shrtuukagstszeigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRTUUKAGSTSZEIGK, nullable=true)
    protected BigDecimal getShrtuukagstszeigkValue() {
        if (shrtuukagstszeigkValue == null && shrtuukagstszeigk != null) {
            if (shrtuukagstszeigk.isOptional()) return null;
            return shrtuukagstszeigk.absolute();
        }
        return shrtuukagstszeigkValue;
    }

    protected void setShrtuukagstszeigkValue(BigDecimal value) {
        shrtuukagstszeigkValue = value;
        shrtuukagstszeigk = Optional.fromNullable(toCurrencyType(shrtuukagstszeigkType))
            .transform(bizCurrencyTransformer(getShrtuukagstszeigkValue()))
            .orNull();
    }

    transient private String shrtuukagstszeigkType = null;

    @Column(name=SHRTUUKAGSTSZEIGK + "$", nullable=true)
    protected String getShrtuukagstszeigkType() {
        if (shrtuukagstszeigkType == null && shrtuukagstszeigk != null) return shrtuukagstszeigk.getType().toString();
        if (shrtuukagstszeigkType == null && getShrtuukagstszeigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrtuukagstszeigk$' should not be NULL."));
        }
        return shrtuukagstszeigkType;
    }

    protected void setShrtuukagstszeigkType(String type) {
        shrtuukagstszeigkType = type;
        shrtuukagstszeigk = Optional.fromNullable(toCurrencyType(shrtuukagstszeigkType))
            .transform(bizCurrencyTransformer(getShrtuukagstszeigkValue()))
            .orNull();
    }

    private BizCurrency shrtuukashrtienrsk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrtuukashrtienrsk() {
        return shrtuukashrtienrsk;
    }

    public void setShrtuukashrtienrsk(BizCurrency pShrtuukashrtienrsk) {
        shrtuukashrtienrsk = pShrtuukashrtienrsk;
        shrtuukashrtienrskValue = null;
        shrtuukashrtienrskType  = null;
    }

    transient private BigDecimal shrtuukashrtienrskValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRTUUKASHRTIENRSK, nullable=true)
    protected BigDecimal getShrtuukashrtienrskValue() {
        if (shrtuukashrtienrskValue == null && shrtuukashrtienrsk != null) {
            if (shrtuukashrtienrsk.isOptional()) return null;
            return shrtuukashrtienrsk.absolute();
        }
        return shrtuukashrtienrskValue;
    }

    protected void setShrtuukashrtienrskValue(BigDecimal value) {
        shrtuukashrtienrskValue = value;
        shrtuukashrtienrsk = Optional.fromNullable(toCurrencyType(shrtuukashrtienrskType))
            .transform(bizCurrencyTransformer(getShrtuukashrtienrskValue()))
            .orNull();
    }

    transient private String shrtuukashrtienrskType = null;

    @Column(name=SHRTUUKASHRTIENRSK + "$", nullable=true)
    protected String getShrtuukashrtienrskType() {
        if (shrtuukashrtienrskType == null && shrtuukashrtienrsk != null) return shrtuukashrtienrsk.getType().toString();
        if (shrtuukashrtienrskType == null && getShrtuukashrtienrskValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrtuukashrtienrsk$' should not be NULL."));
        }
        return shrtuukashrtienrskType;
    }

    protected void setShrtuukashrtienrskType(String type) {
        shrtuukashrtienrskType = type;
        shrtuukashrtienrsk = Optional.fromNullable(toCurrencyType(shrtuukashrtienrskType))
            .transform(bizCurrencyTransformer(getShrtuukashrtienrskValue()))
            .orNull();
    }

    private BizCurrency shrtuukasonotashrkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrtuukasonotashrkngk() {
        return shrtuukasonotashrkngk;
    }

    public void setShrtuukasonotashrkngk(BizCurrency pShrtuukasonotashrkngk) {
        shrtuukasonotashrkngk = pShrtuukasonotashrkngk;
        shrtuukasonotashrkngkValue = null;
        shrtuukasonotashrkngkType  = null;
    }

    transient private BigDecimal shrtuukasonotashrkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRTUUKASONOTASHRKNGK, nullable=true)
    protected BigDecimal getShrtuukasonotashrkngkValue() {
        if (shrtuukasonotashrkngkValue == null && shrtuukasonotashrkngk != null) {
            if (shrtuukasonotashrkngk.isOptional()) return null;
            return shrtuukasonotashrkngk.absolute();
        }
        return shrtuukasonotashrkngkValue;
    }

    protected void setShrtuukasonotashrkngkValue(BigDecimal value) {
        shrtuukasonotashrkngkValue = value;
        shrtuukasonotashrkngk = Optional.fromNullable(toCurrencyType(shrtuukasonotashrkngkType))
            .transform(bizCurrencyTransformer(getShrtuukasonotashrkngkValue()))
            .orNull();
    }

    transient private String shrtuukasonotashrkngkType = null;

    @Column(name=SHRTUUKASONOTASHRKNGK + "$", nullable=true)
    protected String getShrtuukasonotashrkngkType() {
        if (shrtuukasonotashrkngkType == null && shrtuukasonotashrkngk != null) return shrtuukasonotashrkngk.getType().toString();
        if (shrtuukasonotashrkngkType == null && getShrtuukasonotashrkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrtuukasonotashrkngk$' should not be NULL."));
        }
        return shrtuukasonotashrkngkType;
    }

    protected void setShrtuukasonotashrkngkType(String type) {
        shrtuukasonotashrkngkType = type;
        shrtuukasonotashrkngk = Optional.fromNullable(toCurrencyType(shrtuukasonotashrkngkType))
            .transform(bizCurrencyTransformer(getShrtuukasonotashrkngkValue()))
            .orNull();
    }

    private BizCurrency yenkansanhaitoukin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkansanhaitoukin() {
        return yenkansanhaitoukin;
    }

    public void setYenkansanhaitoukin(BizCurrency pYenkansanhaitoukin) {
        yenkansanhaitoukin = pYenkansanhaitoukin;
        yenkansanhaitoukinValue = null;
        yenkansanhaitoukinType  = null;
    }

    transient private BigDecimal yenkansanhaitoukinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKANSANHAITOUKIN, nullable=true)
    protected BigDecimal getYenkansanhaitoukinValue() {
        if (yenkansanhaitoukinValue == null && yenkansanhaitoukin != null) {
            if (yenkansanhaitoukin.isOptional()) return null;
            return yenkansanhaitoukin.absolute();
        }
        return yenkansanhaitoukinValue;
    }

    protected void setYenkansanhaitoukinValue(BigDecimal value) {
        yenkansanhaitoukinValue = value;
        yenkansanhaitoukin = Optional.fromNullable(toCurrencyType(yenkansanhaitoukinType))
            .transform(bizCurrencyTransformer(getYenkansanhaitoukinValue()))
            .orNull();
    }

    transient private String yenkansanhaitoukinType = null;

    @Column(name=YENKANSANHAITOUKIN + "$", nullable=true)
    protected String getYenkansanhaitoukinType() {
        if (yenkansanhaitoukinType == null && yenkansanhaitoukin != null) return yenkansanhaitoukin.getType().toString();
        if (yenkansanhaitoukinType == null && getYenkansanhaitoukinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkansanhaitoukin$' should not be NULL."));
        }
        return yenkansanhaitoukinType;
    }

    protected void setYenkansanhaitoukinType(String type) {
        yenkansanhaitoukinType = type;
        yenkansanhaitoukin = Optional.fromNullable(toCurrencyType(yenkansanhaitoukinType))
            .transform(bizCurrencyTransformer(getYenkansanhaitoukinValue()))
            .orNull();
    }

    private BizCurrency yensonotahaitoukin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYensonotahaitoukin() {
        return yensonotahaitoukin;
    }

    public void setYensonotahaitoukin(BizCurrency pYensonotahaitoukin) {
        yensonotahaitoukin = pYensonotahaitoukin;
        yensonotahaitoukinValue = null;
        yensonotahaitoukinType  = null;
    }

    transient private BigDecimal yensonotahaitoukinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENSONOTAHAITOUKIN, nullable=true)
    protected BigDecimal getYensonotahaitoukinValue() {
        if (yensonotahaitoukinValue == null && yensonotahaitoukin != null) {
            if (yensonotahaitoukin.isOptional()) return null;
            return yensonotahaitoukin.absolute();
        }
        return yensonotahaitoukinValue;
    }

    protected void setYensonotahaitoukinValue(BigDecimal value) {
        yensonotahaitoukinValue = value;
        yensonotahaitoukin = Optional.fromNullable(toCurrencyType(yensonotahaitoukinType))
            .transform(bizCurrencyTransformer(getYensonotahaitoukinValue()))
            .orNull();
    }

    transient private String yensonotahaitoukinType = null;

    @Column(name=YENSONOTAHAITOUKIN + "$", nullable=true)
    protected String getYensonotahaitoukinType() {
        if (yensonotahaitoukinType == null && yensonotahaitoukin != null) return yensonotahaitoukin.getType().toString();
        if (yensonotahaitoukinType == null && getYensonotahaitoukinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yensonotahaitoukin$' should not be NULL."));
        }
        return yensonotahaitoukinType;
    }

    protected void setYensonotahaitoukinType(String type) {
        yensonotahaitoukinType = type;
        yensonotahaitoukin = Optional.fromNullable(toCurrencyType(yensonotahaitoukinType))
            .transform(bizCurrencyTransformer(getYensonotahaitoukinValue()))
            .orNull();
    }

    private BizCurrency yenshrgkgoukei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenshrgkgoukei() {
        return yenshrgkgoukei;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenshrgkgoukei(BizCurrency pYenshrgkgoukei) {
        yenshrgkgoukei = pYenshrgkgoukei;
        yenshrgkgoukeiValue = null;
        yenshrgkgoukeiType  = null;
    }

    transient private BigDecimal yenshrgkgoukeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENSHRGKGOUKEI, nullable=true)
    protected BigDecimal getYenshrgkgoukeiValue() {
        if (yenshrgkgoukeiValue == null && yenshrgkgoukei != null) {
            if (yenshrgkgoukei.isOptional()) return null;
            return yenshrgkgoukei.absolute();
        }
        return yenshrgkgoukeiValue;
    }

    protected void setYenshrgkgoukeiValue(BigDecimal value) {
        yenshrgkgoukeiValue = value;
        yenshrgkgoukei = Optional.fromNullable(toCurrencyType(yenshrgkgoukeiType))
            .transform(bizCurrencyTransformer(getYenshrgkgoukeiValue()))
            .orNull();
    }

    transient private String yenshrgkgoukeiType = null;

    @Column(name=YENSHRGKGOUKEI + "$", nullable=true)
    protected String getYenshrgkgoukeiType() {
        if (yenshrgkgoukeiType == null && yenshrgkgoukei != null) return yenshrgkgoukei.getType().toString();
        if (yenshrgkgoukeiType == null && getYenshrgkgoukeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenshrgkgoukei$' should not be NULL."));
        }
        return yenshrgkgoukeiType;
    }

    protected void setYenshrgkgoukeiType(String type) {
        yenshrgkgoukeiType = type;
        yenshrgkgoukei = Optional.fromNullable(toCurrencyType(yenshrgkgoukeiType))
            .transform(bizCurrencyTransformer(getYenshrgkgoukeiValue()))
            .orNull();
    }

    private BizCurrency yengstszeigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYengstszeigk() {
        return yengstszeigk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYengstszeigk(BizCurrency pYengstszeigk) {
        yengstszeigk = pYengstszeigk;
        yengstszeigkValue = null;
        yengstszeigkType  = null;
    }

    transient private BigDecimal yengstszeigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENGSTSZEIGK, nullable=true)
    protected BigDecimal getYengstszeigkValue() {
        if (yengstszeigkValue == null && yengstszeigk != null) {
            if (yengstszeigk.isOptional()) return null;
            return yengstszeigk.absolute();
        }
        return yengstszeigkValue;
    }

    protected void setYengstszeigkValue(BigDecimal value) {
        yengstszeigkValue = value;
        yengstszeigk = Optional.fromNullable(toCurrencyType(yengstszeigkType))
            .transform(bizCurrencyTransformer(getYengstszeigkValue()))
            .orNull();
    }

    transient private String yengstszeigkType = null;

    @Column(name=YENGSTSZEIGK + "$", nullable=true)
    protected String getYengstszeigkType() {
        if (yengstszeigkType == null && yengstszeigk != null) return yengstszeigk.getType().toString();
        if (yengstszeigkType == null && getYengstszeigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yengstszeigk$' should not be NULL."));
        }
        return yengstszeigkType;
    }

    protected void setYengstszeigkType(String type) {
        yengstszeigkType = type;
        yengstszeigk = Optional.fromNullable(toCurrencyType(yengstszeigkType))
            .transform(bizCurrencyTransformer(getYengstszeigkValue()))
            .orNull();
    }

    private BizCurrency yengstszeigknationaltax;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYengstszeigknationaltax() {
        return yengstszeigknationaltax;
    }

    public void setYengstszeigknationaltax(BizCurrency pYengstszeigknationaltax) {
        yengstszeigknationaltax = pYengstszeigknationaltax;
        yengstszeigknationaltaxValue = null;
        yengstszeigknationaltaxType  = null;
    }

    transient private BigDecimal yengstszeigknationaltaxValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENGSTSZEIGKNATIONALTAX, nullable=true)
    protected BigDecimal getYengstszeigknationaltaxValue() {
        if (yengstszeigknationaltaxValue == null && yengstszeigknationaltax != null) {
            if (yengstszeigknationaltax.isOptional()) return null;
            return yengstszeigknationaltax.absolute();
        }
        return yengstszeigknationaltaxValue;
    }

    protected void setYengstszeigknationaltaxValue(BigDecimal value) {
        yengstszeigknationaltaxValue = value;
        yengstszeigknationaltax = Optional.fromNullable(toCurrencyType(yengstszeigknationaltaxType))
            .transform(bizCurrencyTransformer(getYengstszeigknationaltaxValue()))
            .orNull();
    }

    transient private String yengstszeigknationaltaxType = null;

    @Column(name=YENGSTSZEIGKNATIONALTAX + "$", nullable=true)
    protected String getYengstszeigknationaltaxType() {
        if (yengstszeigknationaltaxType == null && yengstszeigknationaltax != null) return yengstszeigknationaltax.getType().toString();
        if (yengstszeigknationaltaxType == null && getYengstszeigknationaltaxValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yengstszeigknationaltax$' should not be NULL."));
        }
        return yengstszeigknationaltaxType;
    }

    protected void setYengstszeigknationaltaxType(String type) {
        yengstszeigknationaltaxType = type;
        yengstszeigknationaltax = Optional.fromNullable(toCurrencyType(yengstszeigknationaltaxType))
            .transform(bizCurrencyTransformer(getYengstszeigknationaltaxValue()))
            .orNull();
    }

    private BizCurrency yengstszeigklocaltax;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYengstszeigklocaltax() {
        return yengstszeigklocaltax;
    }

    public void setYengstszeigklocaltax(BizCurrency pYengstszeigklocaltax) {
        yengstszeigklocaltax = pYengstszeigklocaltax;
        yengstszeigklocaltaxValue = null;
        yengstszeigklocaltaxType  = null;
    }

    transient private BigDecimal yengstszeigklocaltaxValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENGSTSZEIGKLOCALTAX, nullable=true)
    protected BigDecimal getYengstszeigklocaltaxValue() {
        if (yengstszeigklocaltaxValue == null && yengstszeigklocaltax != null) {
            if (yengstszeigklocaltax.isOptional()) return null;
            return yengstszeigklocaltax.absolute();
        }
        return yengstszeigklocaltaxValue;
    }

    protected void setYengstszeigklocaltaxValue(BigDecimal value) {
        yengstszeigklocaltaxValue = value;
        yengstszeigklocaltax = Optional.fromNullable(toCurrencyType(yengstszeigklocaltaxType))
            .transform(bizCurrencyTransformer(getYengstszeigklocaltaxValue()))
            .orNull();
    }

    transient private String yengstszeigklocaltaxType = null;

    @Column(name=YENGSTSZEIGKLOCALTAX + "$", nullable=true)
    protected String getYengstszeigklocaltaxType() {
        if (yengstszeigklocaltaxType == null && yengstszeigklocaltax != null) return yengstszeigklocaltax.getType().toString();
        if (yengstszeigklocaltaxType == null && getYengstszeigklocaltaxValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yengstszeigklocaltax$' should not be NULL."));
        }
        return yengstszeigklocaltaxType;
    }

    protected void setYengstszeigklocaltaxType(String type) {
        yengstszeigklocaltaxType = type;
        yengstszeigklocaltax = Optional.fromNullable(toCurrencyType(yengstszeigklocaltaxType))
            .transform(bizCurrencyTransformer(getYengstszeigklocaltaxValue()))
            .orNull();
    }

    private BizCurrency yenshrtienrsk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenshrtienrsk() {
        return yenshrtienrsk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenshrtienrsk(BizCurrency pYenshrtienrsk) {
        yenshrtienrsk = pYenshrtienrsk;
        yenshrtienrskValue = null;
        yenshrtienrskType  = null;
    }

    transient private BigDecimal yenshrtienrskValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENSHRTIENRSK, nullable=true)
    protected BigDecimal getYenshrtienrskValue() {
        if (yenshrtienrskValue == null && yenshrtienrsk != null) {
            if (yenshrtienrsk.isOptional()) return null;
            return yenshrtienrsk.absolute();
        }
        return yenshrtienrskValue;
    }

    protected void setYenshrtienrskValue(BigDecimal value) {
        yenshrtienrskValue = value;
        yenshrtienrsk = Optional.fromNullable(toCurrencyType(yenshrtienrskType))
            .transform(bizCurrencyTransformer(getYenshrtienrskValue()))
            .orNull();
    }

    transient private String yenshrtienrskType = null;

    @Column(name=YENSHRTIENRSK + "$", nullable=true)
    protected String getYenshrtienrskType() {
        if (yenshrtienrskType == null && yenshrtienrsk != null) return yenshrtienrsk.getType().toString();
        if (yenshrtienrskType == null && getYenshrtienrskValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenshrtienrsk$' should not be NULL."));
        }
        return yenshrtienrskType;
    }

    protected void setYenshrtienrskType(String type) {
        yenshrtienrskType = type;
        yenshrtienrsk = Optional.fromNullable(toCurrencyType(yenshrtienrskType))
            .transform(bizCurrencyTransformer(getYenshrtienrskValue()))
            .orNull();
    }

    private BizCurrency sonotashrkngkyen;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSonotashrkngkyen() {
        return sonotashrkngkyen;
    }

    public void setSonotashrkngkyen(BizCurrency pSonotashrkngkyen) {
        sonotashrkngkyen = pSonotashrkngkyen;
        sonotashrkngkyenValue = null;
        sonotashrkngkyenType  = null;
    }

    transient private BigDecimal sonotashrkngkyenValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SONOTASHRKNGKYEN, nullable=true)
    protected BigDecimal getSonotashrkngkyenValue() {
        if (sonotashrkngkyenValue == null && sonotashrkngkyen != null) {
            if (sonotashrkngkyen.isOptional()) return null;
            return sonotashrkngkyen.absolute();
        }
        return sonotashrkngkyenValue;
    }

    protected void setSonotashrkngkyenValue(BigDecimal value) {
        sonotashrkngkyenValue = value;
        sonotashrkngkyen = Optional.fromNullable(toCurrencyType(sonotashrkngkyenType))
            .transform(bizCurrencyTransformer(getSonotashrkngkyenValue()))
            .orNull();
    }

    transient private String sonotashrkngkyenType = null;

    @Column(name=SONOTASHRKNGKYEN + "$", nullable=true)
    protected String getSonotashrkngkyenType() {
        if (sonotashrkngkyenType == null && sonotashrkngkyen != null) return sonotashrkngkyen.getType().toString();
        if (sonotashrkngkyenType == null && getSonotashrkngkyenValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sonotashrkngkyen$' should not be NULL."));
        }
        return sonotashrkngkyenType;
    }

    protected void setSonotashrkngkyenType(String type) {
        sonotashrkngkyenType = type;
        sonotashrkngkyen = Optional.fromNullable(toCurrencyType(sonotashrkngkyenType))
            .transform(bizCurrencyTransformer(getSonotashrkngkyenValue()))
            .orNull();
    }

    private BizCurrency sonotashrkngksiteituuka;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSonotashrkngksiteituuka() {
        return sonotashrkngksiteituuka;
    }

    public void setSonotashrkngksiteituuka(BizCurrency pSonotashrkngksiteituuka) {
        sonotashrkngksiteituuka = pSonotashrkngksiteituuka;
        sonotashrkngksiteituukaValue = null;
        sonotashrkngksiteituukaType  = null;
    }

    transient private BigDecimal sonotashrkngksiteituukaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SONOTASHRKNGKSITEITUUKA, nullable=true)
    protected BigDecimal getSonotashrkngksiteituukaValue() {
        if (sonotashrkngksiteituukaValue == null && sonotashrkngksiteituuka != null) {
            if (sonotashrkngksiteituuka.isOptional()) return null;
            return sonotashrkngksiteituuka.absolute();
        }
        return sonotashrkngksiteituukaValue;
    }

    protected void setSonotashrkngksiteituukaValue(BigDecimal value) {
        sonotashrkngksiteituukaValue = value;
        sonotashrkngksiteituuka = Optional.fromNullable(toCurrencyType(sonotashrkngksiteituukaType))
            .transform(bizCurrencyTransformer(getSonotashrkngksiteituukaValue()))
            .orNull();
    }

    transient private String sonotashrkngksiteituukaType = null;

    @Column(name=SONOTASHRKNGKSITEITUUKA + "$", nullable=true)
    protected String getSonotashrkngksiteituukaType() {
        if (sonotashrkngksiteituukaType == null && sonotashrkngksiteituuka != null) return sonotashrkngksiteituuka.getType().toString();
        if (sonotashrkngksiteituukaType == null && getSonotashrkngksiteituukaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sonotashrkngksiteituuka$' should not be NULL."));
        }
        return sonotashrkngksiteituukaType;
    }

    protected void setSonotashrkngksiteituukaType(String type) {
        sonotashrkngksiteituukaType = type;
        sonotashrkngksiteituuka = Optional.fromNullable(toCurrencyType(sonotashrkngksiteituukaType))
            .transform(bizCurrencyTransformer(getSonotashrkngksiteituukaValue()))
            .orNull();
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_DSeisanTuibaraiKanri.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_DSeisanTuibaraiKanri.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_DSeisanTuibaraiKanri.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private C_ZeitratkiKbn zeitratkikbn;

    @Type(type="UserType_C_ZeitratkiKbn")
    @Column(name=GenIT_DSeisanTuibaraiKanri.ZEITRATKIKBN)
    public C_ZeitratkiKbn getZeitratkikbn() {
        return zeitratkikbn;
    }

    public void setZeitratkikbn(C_ZeitratkiKbn pZeitratkikbn) {
        zeitratkikbn = pZeitratkikbn;
    }
}