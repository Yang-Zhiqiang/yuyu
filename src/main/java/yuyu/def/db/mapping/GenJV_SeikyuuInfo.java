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
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidTextArea;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_SaigaiHigaitouKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.JV_SeikyuuInfo;
import yuyu.def.db.id.PKJV_SeikyuuInfo;
import yuyu.def.db.meta.GenQJV_SeikyuuInfo;
import yuyu.def.db.meta.QJV_SeikyuuInfo;
import yuyu.def.db.type.UserType_C_GeninKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_InputShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_SaigaiHigaitouKbn;
import yuyu.def.db.type.UserType_C_SaisateiKbn;
import yuyu.def.db.type.UserType_C_SeikyuuSyubetu;
import yuyu.def.db.type.UserType_C_SeikyuusyaKbn;
import yuyu.def.db.type.UserType_C_ShrKekkaKbn;
import yuyu.def.db.type.UserType_C_SiinKbn;
import yuyu.def.db.type.UserType_C_TtdktyuuiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UktKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_ZeitratkiKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 請求情報ビュー テーブルのマッピング情報クラスで、 {@link JV_SeikyuuInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JV_SeikyuuInfo}</td><td colspan="3">請求情報ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJV_SeikyuuInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJV_SeikyuuInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuusyubetu seikyuusyubetu}</td><td>請求種別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SeikyuuSyubetu}</td></tr>
 *  <tr><td>{@link #getSaisateikbn saisateikbn}</td><td>再査定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SaisateiKbn}</td></tr>
 *  <tr><td>{@link #getSiboukaritrkymd siboukaritrkymd}</td><td>死亡仮受付登録日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSibouymd sibouymd}</td><td>死亡日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGeninkbn geninkbn}</td><td>原因区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_GeninKbn}</td></tr>
 *  <tr><td>{@link #getSiinkbn siinkbn}</td><td>死因区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SiinKbn}</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkn kyknmkn}</td><td>契約者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkj hhknnmkj}</td><td>被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkn hhknnmkn}</td><td>被保険者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknseiymd hhknseiymd}</td><td>被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHhknsei hhknsei}</td><td>被保険者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hhknsei}</td></tr>
 *  <tr><td>{@link #getSbuktnin sbuktnin}</td><td>死亡受取人人数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getUktkbn uktkbn}</td><td>受取人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UktKbn}</td></tr>
 *  <tr><td>{@link #getUktnmkj uktnmkj}</td><td>受取人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktseiymd uktseiymd}</td><td>受取人生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getUktbnwari uktbnwari}</td><td>受取人分割割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getInitsbjiyensitihsytkhukaumu initsbjiyensitihsytkhukaumu}</td><td>初期死亡時円換算最低保証特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTtdktyuuinaiyou1 ttdktyuuinaiyou1}</td><td>手続注意内容１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdktyuuinaiyou2 ttdktyuuinaiyou2}</td><td>手続注意内容２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdktyuuinaiyou3 ttdktyuuinaiyou3}</td><td>手続注意内容３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbn1 ttdktyuuikbn1}</td><td>手続注意区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbnhsknaiyou1 ttdktyuuikbnhsknaiyou1}</td><td>手続注意区分補足内容１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbnsetymd1 ttdktyuuikbnsetymd1}</td><td>手続注意区分設定日１</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbn2 ttdktyuuikbn2}</td><td>手続注意区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbnhsknaiyou2 ttdktyuuikbnhsknaiyou2}</td><td>手続注意区分補足内容２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbnsetymd2 ttdktyuuikbnsetymd2}</td><td>手続注意区分設定日２</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbn3 ttdktyuuikbn3}</td><td>手続注意区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbnhsknaiyou3 ttdktyuuikbnhsknaiyou3}</td><td>手続注意区分補足内容３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbnsetymd3 ttdktyuuikbnsetymd3}</td><td>手続注意区分設定日３</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbn4 ttdktyuuikbn4}</td><td>手続注意区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbnhsknaiyou4 ttdktyuuikbnhsknaiyou4}</td><td>手続注意区分補足内容４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbnsetymd4 ttdktyuuikbnsetymd4}</td><td>手続注意区分設定日４</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbn5 ttdktyuuikbn5}</td><td>手続注意区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbnhsknaiyou5 ttdktyuuikbnhsknaiyou5}</td><td>手続注意区分補足内容５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdktyuuikbnsetymd5 ttdktyuuikbnsetymd5}</td><td>手続注意区分設定日５</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSeikyuusyakbn seikyuusyakbn}</td><td>請求者区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SeikyuusyaKbn}</td></tr>
 *  <tr><td>{@link #getSeikyuusyanmkn seikyuusyanmkn}</td><td>請求者（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuusyanmkj seikyuusyanmkj}</td><td>請求者（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinyno tsinyno}</td><td>通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr1kj tsinadr1kj}</td><td>通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr2kj tsinadr2kj}</td><td>通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr3kj tsinadr3kj}</td><td>通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruiukeymd syoruiukeymd}</td><td>書類受付日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHubikanryouymd hubikanryouymd}</td><td>不備完了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrkekkakbn shrkekkakbn}</td><td>支払結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ShrKekkaKbn}</td></tr>
 *  <tr><td>{@link #getSaigaihigaitoukbn saigaihigaitoukbn}</td><td>災害非該当区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SaigaiHigaitouKbn}</td></tr>
 *  <tr><td>{@link #getShrsyoriymd shrsyoriymd}</td><td>支払処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTyakkinymd tyakkinymd}</td><td>着金日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrgkkei shrgkkei}</td><td>支払額合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrtuukasyu shrtuukasyu}</td><td>支払通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getShrkwsrate shrkwsrate}</td><td>支払時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getShrkwsratekjnymd shrkwsratekjnymd}</td><td>支払時為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGaikaknsnkwsrate gaikaknsnkwsrate}</td><td>外貨換算為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getGaikaknsnkwsratekjymd gaikaknsnkwsratekjymd}</td><td>外貨換算為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHokenkngkgoukei hokenkngkgoukei}</td><td>保険金額合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHaitoukin haitoukin}</td><td>配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSonotahaitoukin sonotahaitoukin}</td><td>その他配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMisyuup misyuup}</td><td>未収保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMikeikap mikeikap}</td><td>未経過保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZennouseisankgk zennouseisankgk}</td><td>前納精算金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getAzukarikingk azukarikingk}</td><td>預り金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKrkgk krkgk}</td><td>仮受金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrtienrsk shrtienrsk}</td><td>支払遅延利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenshrgk yenshrgk}</td><td>円換算支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenhkgkgoukei yenhkgkgoukei}</td><td>円換算保険金額合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkahaitoukin yenkahaitoukin}</td><td>円貨配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkasonotahaitoukin yenkasonotahaitoukin}</td><td>円貨その他配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkamisyuup yenkamisyuup}</td><td>円貨未収保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkamikeikap yenkamikeikap}</td><td>円貨未経過保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkazennouseisankgk yenkazennouseisankgk}</td><td>円貨前納精算金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkaazukarikingk yenkaazukarikingk}</td><td>円貨預り金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkakrkgk yenkakrkgk}</td><td>円貨仮受金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenshrtienrsk yenshrtienrsk}</td><td>円換算支払遅延利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZitkazukarikingksiteituuka zitkazukarikingksiteituuka}</td><td>税適預り金額（指定通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZitkazukarikingkyen zitkazukarikingkyen}</td><td>税適預り金額（円貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGaikaknsntkgk gaikaknsntkgk}</td><td>外貨換算対象金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGaikaknsnkekkakgk gaikaknsnkekkakgk}</td><td>外貨換算結果金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkaknsntkgk yenkaknsntkgk}</td><td>円貨換算対象金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkaknsnkekkakgk yenkaknsnkekkakgk}</td><td>円貨換算結果金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getInputshrhousiteikbn inputshrhousiteikbn}</td><td>入力用支払方法指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_InputShrhousiteiKbn}</td></tr>
 *  <tr><td>{@link #getZeimukwsrate zeimukwsrate}</td><td>税務用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZeimukwsratekjnymd zeimukwsratekjnymd}</td><td>税務用為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZeitratkikbn zeitratkikbn}</td><td>税取扱区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ZeitratkiKbn}</td></tr>
 * </table>
 * @see     JV_SeikyuuInfo
 * @see     PKJV_SeikyuuInfo
 * @see     QJV_SeikyuuInfo
 * @see     GenQJV_SeikyuuInfo
 */
@MappedSuperclass
@Table(name=GenJV_SeikyuuInfo.TABLE_NAME)
@IdClass(value=PKJV_SeikyuuInfo.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_GeninKbn", typeClass=UserType_C_GeninKbn.class),
    @TypeDef(name="UserType_C_Hhknsei", typeClass=UserType_C_Hhknsei.class),
    @TypeDef(name="UserType_C_InputShrhousiteiKbn", typeClass=UserType_C_InputShrhousiteiKbn.class),
    @TypeDef(name="UserType_C_SaigaiHigaitouKbn", typeClass=UserType_C_SaigaiHigaitouKbn.class),
    @TypeDef(name="UserType_C_SaisateiKbn", typeClass=UserType_C_SaisateiKbn.class),
    @TypeDef(name="UserType_C_SeikyuuSyubetu", typeClass=UserType_C_SeikyuuSyubetu.class),
    @TypeDef(name="UserType_C_SeikyuusyaKbn", typeClass=UserType_C_SeikyuusyaKbn.class),
    @TypeDef(name="UserType_C_ShrKekkaKbn", typeClass=UserType_C_ShrKekkaKbn.class),
    @TypeDef(name="UserType_C_SiinKbn", typeClass=UserType_C_SiinKbn.class),
    @TypeDef(name="UserType_C_TtdktyuuiKbn", typeClass=UserType_C_TtdktyuuiKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UktKbn", typeClass=UserType_C_UktKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_ZeitratkiKbn", typeClass=UserType_C_ZeitratkiKbn.class)
})
public abstract class GenJV_SeikyuuInfo extends AbstractExDBEntity<JV_SeikyuuInfo, PKJV_SeikyuuInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JV_SeikyuuInfo";
    public static final String SYONO                    = "syono";
    public static final String SKNO                     = "skno";
    public static final String SEIKYUUSYUBETU           = "seikyuusyubetu";
    public static final String SAISATEIKBN              = "saisateikbn";
    public static final String SIBOUKARITRKYMD          = "siboukaritrkymd";
    public static final String SIBOUYMD                 = "sibouymd";
    public static final String GENINKBN                 = "geninkbn";
    public static final String SIINKBN                  = "siinkbn";
    public static final String KYKYMD                   = "kykymd";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String KYKNMKN                  = "kyknmkn";
    public static final String HHKNNMKJ                 = "hhknnmkj";
    public static final String HHKNNMKN                 = "hhknnmkn";
    public static final String HHKNSEIYMD               = "hhknseiymd";
    public static final String HHKNSEI                  = "hhknsei";
    public static final String SBUKTNIN                 = "sbuktnin";
    public static final String UKTKBN                   = "uktkbn";
    public static final String UKTNMKJ                  = "uktnmkj";
    public static final String UKTSEIYMD                = "uktseiymd";
    public static final String UKTBNWARI                = "uktbnwari";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String INITSBJIYENSITIHSYTKHUKAUMU = "initsbjiyensitihsytkhukaumu";
    public static final String TTDKTYUUINAIYOU1         = "ttdktyuuinaiyou1";
    public static final String TTDKTYUUINAIYOU2         = "ttdktyuuinaiyou2";
    public static final String TTDKTYUUINAIYOU3         = "ttdktyuuinaiyou3";
    public static final String TTDKTYUUIKBN1            = "ttdktyuuikbn1";
    public static final String TTDKTYUUIKBNHSKNAIYOU1   = "ttdktyuuikbnhsknaiyou1";
    public static final String TTDKTYUUIKBNSETYMD1      = "ttdktyuuikbnsetymd1";
    public static final String TTDKTYUUIKBN2            = "ttdktyuuikbn2";
    public static final String TTDKTYUUIKBNHSKNAIYOU2   = "ttdktyuuikbnhsknaiyou2";
    public static final String TTDKTYUUIKBNSETYMD2      = "ttdktyuuikbnsetymd2";
    public static final String TTDKTYUUIKBN3            = "ttdktyuuikbn3";
    public static final String TTDKTYUUIKBNHSKNAIYOU3   = "ttdktyuuikbnhsknaiyou3";
    public static final String TTDKTYUUIKBNSETYMD3      = "ttdktyuuikbnsetymd3";
    public static final String TTDKTYUUIKBN4            = "ttdktyuuikbn4";
    public static final String TTDKTYUUIKBNHSKNAIYOU4   = "ttdktyuuikbnhsknaiyou4";
    public static final String TTDKTYUUIKBNSETYMD4      = "ttdktyuuikbnsetymd4";
    public static final String TTDKTYUUIKBN5            = "ttdktyuuikbn5";
    public static final String TTDKTYUUIKBNHSKNAIYOU5   = "ttdktyuuikbnhsknaiyou5";
    public static final String TTDKTYUUIKBNSETYMD5      = "ttdktyuuikbnsetymd5";
    public static final String SEIKYUUSYAKBN            = "seikyuusyakbn";
    public static final String SEIKYUUSYANMKN           = "seikyuusyanmkn";
    public static final String SEIKYUUSYANMKJ           = "seikyuusyanmkj";
    public static final String TSINYNO                  = "tsinyno";
    public static final String TSINADR1KJ               = "tsinadr1kj";
    public static final String TSINADR2KJ               = "tsinadr2kj";
    public static final String TSINADR3KJ               = "tsinadr3kj";
    public static final String SYORUIUKEYMD             = "syoruiukeymd";
    public static final String HUBIKANRYOUYMD           = "hubikanryouymd";
    public static final String SHRKEKKAKBN              = "shrkekkakbn";
    public static final String SAIGAIHIGAITOUKBN        = "saigaihigaitoukbn";
    public static final String SHRSYORIYMD              = "shrsyoriymd";
    public static final String TYAKKINYMD               = "tyakkinymd";
    public static final String SHRGKKEI                 = "shrgkkei";
    public static final String SHRTUUKASYU              = "shrtuukasyu";
    public static final String SHRKWSRATE               = "shrkwsrate";
    public static final String SHRKWSRATEKJNYMD         = "shrkwsratekjnymd";
    public static final String GAIKAKNSNKWSRATE         = "gaikaknsnkwsrate";
    public static final String GAIKAKNSNKWSRATEKJYMD    = "gaikaknsnkwsratekjymd";
    public static final String HOKENKNGKGOUKEI          = "hokenkngkgoukei";
    public static final String HAITOUKIN                = "haitoukin";
    public static final String SONOTAHAITOUKIN          = "sonotahaitoukin";
    public static final String MISYUUP                  = "misyuup";
    public static final String MIKEIKAP                 = "mikeikap";
    public static final String ZENNOUSEISANKGK          = "zennouseisankgk";
    public static final String AZUKARIKINGK             = "azukarikingk";
    public static final String KRKGK                    = "krkgk";
    public static final String SHRTIENRSK               = "shrtienrsk";
    public static final String YENSHRGK                 = "yenshrgk";
    public static final String YENHKGKGOUKEI            = "yenhkgkgoukei";
    public static final String YENKAHAITOUKIN           = "yenkahaitoukin";
    public static final String YENKASONOTAHAITOUKIN     = "yenkasonotahaitoukin";
    public static final String YENKAMISYUUP             = "yenkamisyuup";
    public static final String YENKAMIKEIKAP            = "yenkamikeikap";
    public static final String YENKAZENNOUSEISANKGK     = "yenkazennouseisankgk";
    public static final String YENKAAZUKARIKINGK        = "yenkaazukarikingk";
    public static final String YENKAKRKGK               = "yenkakrkgk";
    public static final String YENSHRTIENRSK            = "yenshrtienrsk";
    public static final String ZITKAZUKARIKINGKSITEITUUKA = "zitkazukarikingksiteituuka";
    public static final String ZITKAZUKARIKINGKYEN      = "zitkazukarikingkyen";
    public static final String GAIKAKNSNTKGK            = "gaikaknsntkgk";
    public static final String GAIKAKNSNKEKKAKGK        = "gaikaknsnkekkakgk";
    public static final String YENKAKNSNTKGK            = "yenkaknsntkgk";
    public static final String YENKAKNSNKEKKAKGK        = "yenkaknsnkekkakgk";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String INPUTSHRHOUSITEIKBN      = "inputshrhousiteikbn";
    public static final String ZEIMUKWSRATE             = "zeimukwsrate";
    public static final String ZEIMUKWSRATEKJNYMD       = "zeimukwsratekjnymd";
    public static final String ZEITRATKIKBN             = "zeitratkikbn";

    private final PKJV_SeikyuuInfo primaryKey;

    public GenJV_SeikyuuInfo() {
        primaryKey = new PKJV_SeikyuuInfo();
    }

    public GenJV_SeikyuuInfo(String pSyono, String pSkno) {
        primaryKey = new PKJV_SeikyuuInfo(pSyono, pSkno);
    }

    @Transient
    @Override
    public PKJV_SeikyuuInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJV_SeikyuuInfo> getMetaClass() {
        return QJV_SeikyuuInfo.class;
    }

    @Id
    @Column(name=GenJV_SeikyuuInfo.SYONO)
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
    @Column(name=GenJV_SeikyuuInfo.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    private C_SeikyuuSyubetu seikyuusyubetu;

    @Type(type="UserType_C_SeikyuuSyubetu")
    @Column(name=GenJV_SeikyuuInfo.SEIKYUUSYUBETU)
    public C_SeikyuuSyubetu getSeikyuusyubetu() {
        return seikyuusyubetu;
    }

    public void setSeikyuusyubetu(C_SeikyuuSyubetu pSeikyuusyubetu) {
        seikyuusyubetu = pSeikyuusyubetu;
    }

    private C_SaisateiKbn saisateikbn;

    @Type(type="UserType_C_SaisateiKbn")
    @Column(name=GenJV_SeikyuuInfo.SAISATEIKBN)
    public C_SaisateiKbn getSaisateikbn() {
        return saisateikbn;
    }

    public void setSaisateikbn(C_SaisateiKbn pSaisateikbn) {
        saisateikbn = pSaisateikbn;
    }

    private BizDate siboukaritrkymd;

    @Type(type="BizDateType")
    @Column(name=GenJV_SeikyuuInfo.SIBOUKARITRKYMD)
    @ValidDate
    public BizDate getSiboukaritrkymd() {
        return siboukaritrkymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSiboukaritrkymd(BizDate pSiboukaritrkymd) {
        siboukaritrkymd = pSiboukaritrkymd;
    }

    private BizDate sibouymd;

    @Type(type="BizDateType")
    @Column(name=GenJV_SeikyuuInfo.SIBOUYMD)
    @ValidDate
    public BizDate getSibouymd() {
        return sibouymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSibouymd(BizDate pSibouymd) {
        sibouymd = pSibouymd;
    }

    private C_GeninKbn geninkbn;

    @Type(type="UserType_C_GeninKbn")
    @Column(name=GenJV_SeikyuuInfo.GENINKBN)
    public C_GeninKbn getGeninkbn() {
        return geninkbn;
    }

    public void setGeninkbn(C_GeninKbn pGeninkbn) {
        geninkbn = pGeninkbn;
    }

    private C_SiinKbn siinkbn;

    @Type(type="UserType_C_SiinKbn")
    @Column(name=GenJV_SeikyuuInfo.SIINKBN)
    public C_SiinKbn getSiinkbn() {
        return siinkbn;
    }

    public void setSiinkbn(C_SiinKbn pSiinkbn) {
        siinkbn = pSiinkbn;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenJV_SeikyuuInfo.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private String kyknmkj;

    @Column(name=GenJV_SeikyuuInfo.KYKNMKJ)
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

    private String kyknmkn;

    @Column(name=GenJV_SeikyuuInfo.KYKNMKN)
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

    private String hhknnmkj;

    @Column(name=GenJV_SeikyuuInfo.HHKNNMKJ)
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

    private String hhknnmkn;

    @Column(name=GenJV_SeikyuuInfo.HHKNNMKN)
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

    private BizDate hhknseiymd;

    @Type(type="BizDateType")
    @Column(name=GenJV_SeikyuuInfo.HHKNSEIYMD)
    @ValidDate
    public BizDate getHhknseiymd() {
        return hhknseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknseiymd(BizDate pHhknseiymd) {
        hhknseiymd = pHhknseiymd;
    }

    private C_Hhknsei hhknsei;

    @Type(type="UserType_C_Hhknsei")
    @Column(name=GenJV_SeikyuuInfo.HHKNSEI)
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private Integer sbuktnin;

    @Column(name=GenJV_SeikyuuInfo.SBUKTNIN)
    @Range(min="0", max="99")
    public Integer getSbuktnin() {
        return sbuktnin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktnin(Integer pSbuktnin) {
        sbuktnin = pSbuktnin;
    }

    private C_UktKbn uktkbn;

    @Type(type="UserType_C_UktKbn")
    @Column(name=GenJV_SeikyuuInfo.UKTKBN)
    public C_UktKbn getUktkbn() {
        return uktkbn;
    }

    public void setUktkbn(C_UktKbn pUktkbn) {
        uktkbn = pUktkbn;
    }

    private String uktnmkj;

    @Column(name=GenJV_SeikyuuInfo.UKTNMKJ)
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

    private BizDate uktseiymd;

    @Type(type="BizDateType")
    @Column(name=GenJV_SeikyuuInfo.UKTSEIYMD)
    @ValidDate
    public BizDate getUktseiymd() {
        return uktseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktseiymd(BizDate pUktseiymd) {
        uktseiymd = pUktseiymd;
    }

    private BizNumber uktbnwari;

    @Type(type="BizNumberType")
    @Column(name=GenJV_SeikyuuInfo.UKTBNWARI)
    public BizNumber getUktbnwari() {
        return uktbnwari;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktbnwari(BizNumber pUktbnwari) {
        uktbnwari = pUktbnwari;
    }

    private String syouhncd;

    @Column(name=GenJV_SeikyuuInfo.SYOUHNCD)
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

    private C_UmuKbn initsbjiyensitihsytkhukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJV_SeikyuuInfo.INITSBJIYENSITIHSYTKHUKAUMU)
    public C_UmuKbn getInitsbjiyensitihsytkhukaumu() {
        return initsbjiyensitihsytkhukaumu;
    }

    public void setInitsbjiyensitihsytkhukaumu(C_UmuKbn pInitsbjiyensitihsytkhukaumu) {
        initsbjiyensitihsytkhukaumu = pInitsbjiyensitihsytkhukaumu;
    }

    private String ttdktyuuinaiyou1;

    @Column(name=GenJV_SeikyuuInfo.TTDKTYUUINAIYOU1)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getTtdktyuuinaiyou1() {
        return ttdktyuuinaiyou1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTtdktyuuinaiyou1(String pTtdktyuuinaiyou1) {
        ttdktyuuinaiyou1 = pTtdktyuuinaiyou1;
    }

    private String ttdktyuuinaiyou2;

    @Column(name=GenJV_SeikyuuInfo.TTDKTYUUINAIYOU2)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getTtdktyuuinaiyou2() {
        return ttdktyuuinaiyou2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTtdktyuuinaiyou2(String pTtdktyuuinaiyou2) {
        ttdktyuuinaiyou2 = pTtdktyuuinaiyou2;
    }

    private String ttdktyuuinaiyou3;

    @Column(name=GenJV_SeikyuuInfo.TTDKTYUUINAIYOU3)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getTtdktyuuinaiyou3() {
        return ttdktyuuinaiyou3;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTtdktyuuinaiyou3(String pTtdktyuuinaiyou3) {
        ttdktyuuinaiyou3 = pTtdktyuuinaiyou3;
    }

    private C_TtdktyuuiKbn ttdktyuuikbn1;

    @Type(type="UserType_C_TtdktyuuiKbn")
    @Column(name=GenJV_SeikyuuInfo.TTDKTYUUIKBN1)
    public C_TtdktyuuiKbn getTtdktyuuikbn1() {
        return ttdktyuuikbn1;
    }

    public void setTtdktyuuikbn1(C_TtdktyuuiKbn pTtdktyuuikbn1) {
        ttdktyuuikbn1 = pTtdktyuuikbn1;
    }

    private String ttdktyuuikbnhsknaiyou1;

    @Column(name=GenJV_SeikyuuInfo.TTDKTYUUIKBNHSKNAIYOU1)
    @ValidTextArea(length=30, rows=3)
    @MultiByteStringsReturnable
    @InvalidCharacter
    public String getTtdktyuuikbnhsknaiyou1() {
        return ttdktyuuikbnhsknaiyou1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTtdktyuuikbnhsknaiyou1(String pTtdktyuuikbnhsknaiyou1) {
        ttdktyuuikbnhsknaiyou1 = pTtdktyuuikbnhsknaiyou1;
    }

    private BizDate ttdktyuuikbnsetymd1;

    @Type(type="BizDateType")
    @Column(name=GenJV_SeikyuuInfo.TTDKTYUUIKBNSETYMD1)
    @ValidDate
    public BizDate getTtdktyuuikbnsetymd1() {
        return ttdktyuuikbnsetymd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTtdktyuuikbnsetymd1(BizDate pTtdktyuuikbnsetymd1) {
        ttdktyuuikbnsetymd1 = pTtdktyuuikbnsetymd1;
    }

    private C_TtdktyuuiKbn ttdktyuuikbn2;

    @Type(type="UserType_C_TtdktyuuiKbn")
    @Column(name=GenJV_SeikyuuInfo.TTDKTYUUIKBN2)
    public C_TtdktyuuiKbn getTtdktyuuikbn2() {
        return ttdktyuuikbn2;
    }

    public void setTtdktyuuikbn2(C_TtdktyuuiKbn pTtdktyuuikbn2) {
        ttdktyuuikbn2 = pTtdktyuuikbn2;
    }

    private String ttdktyuuikbnhsknaiyou2;

    @Column(name=GenJV_SeikyuuInfo.TTDKTYUUIKBNHSKNAIYOU2)
    @ValidTextArea(length=30, rows=3)
    @MultiByteStringsReturnable
    @InvalidCharacter
    public String getTtdktyuuikbnhsknaiyou2() {
        return ttdktyuuikbnhsknaiyou2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTtdktyuuikbnhsknaiyou2(String pTtdktyuuikbnhsknaiyou2) {
        ttdktyuuikbnhsknaiyou2 = pTtdktyuuikbnhsknaiyou2;
    }

    private BizDate ttdktyuuikbnsetymd2;

    @Type(type="BizDateType")
    @Column(name=GenJV_SeikyuuInfo.TTDKTYUUIKBNSETYMD2)
    @ValidDate
    public BizDate getTtdktyuuikbnsetymd2() {
        return ttdktyuuikbnsetymd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTtdktyuuikbnsetymd2(BizDate pTtdktyuuikbnsetymd2) {
        ttdktyuuikbnsetymd2 = pTtdktyuuikbnsetymd2;
    }

    private C_TtdktyuuiKbn ttdktyuuikbn3;

    @Type(type="UserType_C_TtdktyuuiKbn")
    @Column(name=GenJV_SeikyuuInfo.TTDKTYUUIKBN3)
    public C_TtdktyuuiKbn getTtdktyuuikbn3() {
        return ttdktyuuikbn3;
    }

    public void setTtdktyuuikbn3(C_TtdktyuuiKbn pTtdktyuuikbn3) {
        ttdktyuuikbn3 = pTtdktyuuikbn3;
    }

    private String ttdktyuuikbnhsknaiyou3;

    @Column(name=GenJV_SeikyuuInfo.TTDKTYUUIKBNHSKNAIYOU3)
    @ValidTextArea(length=30, rows=3)
    @MultiByteStringsReturnable
    @InvalidCharacter
    public String getTtdktyuuikbnhsknaiyou3() {
        return ttdktyuuikbnhsknaiyou3;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTtdktyuuikbnhsknaiyou3(String pTtdktyuuikbnhsknaiyou3) {
        ttdktyuuikbnhsknaiyou3 = pTtdktyuuikbnhsknaiyou3;
    }

    private BizDate ttdktyuuikbnsetymd3;

    @Type(type="BizDateType")
    @Column(name=GenJV_SeikyuuInfo.TTDKTYUUIKBNSETYMD3)
    @ValidDate
    public BizDate getTtdktyuuikbnsetymd3() {
        return ttdktyuuikbnsetymd3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTtdktyuuikbnsetymd3(BizDate pTtdktyuuikbnsetymd3) {
        ttdktyuuikbnsetymd3 = pTtdktyuuikbnsetymd3;
    }

    private C_TtdktyuuiKbn ttdktyuuikbn4;

    @Type(type="UserType_C_TtdktyuuiKbn")
    @Column(name=GenJV_SeikyuuInfo.TTDKTYUUIKBN4)
    public C_TtdktyuuiKbn getTtdktyuuikbn4() {
        return ttdktyuuikbn4;
    }

    public void setTtdktyuuikbn4(C_TtdktyuuiKbn pTtdktyuuikbn4) {
        ttdktyuuikbn4 = pTtdktyuuikbn4;
    }

    private String ttdktyuuikbnhsknaiyou4;

    @Column(name=GenJV_SeikyuuInfo.TTDKTYUUIKBNHSKNAIYOU4)
    @ValidTextArea(length=30, rows=3)
    @MultiByteStringsReturnable
    @InvalidCharacter
    public String getTtdktyuuikbnhsknaiyou4() {
        return ttdktyuuikbnhsknaiyou4;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTtdktyuuikbnhsknaiyou4(String pTtdktyuuikbnhsknaiyou4) {
        ttdktyuuikbnhsknaiyou4 = pTtdktyuuikbnhsknaiyou4;
    }

    private BizDate ttdktyuuikbnsetymd4;

    @Type(type="BizDateType")
    @Column(name=GenJV_SeikyuuInfo.TTDKTYUUIKBNSETYMD4)
    @ValidDate
    public BizDate getTtdktyuuikbnsetymd4() {
        return ttdktyuuikbnsetymd4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTtdktyuuikbnsetymd4(BizDate pTtdktyuuikbnsetymd4) {
        ttdktyuuikbnsetymd4 = pTtdktyuuikbnsetymd4;
    }

    private C_TtdktyuuiKbn ttdktyuuikbn5;

    @Type(type="UserType_C_TtdktyuuiKbn")
    @Column(name=GenJV_SeikyuuInfo.TTDKTYUUIKBN5)
    public C_TtdktyuuiKbn getTtdktyuuikbn5() {
        return ttdktyuuikbn5;
    }

    public void setTtdktyuuikbn5(C_TtdktyuuiKbn pTtdktyuuikbn5) {
        ttdktyuuikbn5 = pTtdktyuuikbn5;
    }

    private String ttdktyuuikbnhsknaiyou5;

    @Column(name=GenJV_SeikyuuInfo.TTDKTYUUIKBNHSKNAIYOU5)
    @ValidTextArea(length=30, rows=3)
    @MultiByteStringsReturnable
    @InvalidCharacter
    public String getTtdktyuuikbnhsknaiyou5() {
        return ttdktyuuikbnhsknaiyou5;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTtdktyuuikbnhsknaiyou5(String pTtdktyuuikbnhsknaiyou5) {
        ttdktyuuikbnhsknaiyou5 = pTtdktyuuikbnhsknaiyou5;
    }

    private BizDate ttdktyuuikbnsetymd5;

    @Type(type="BizDateType")
    @Column(name=GenJV_SeikyuuInfo.TTDKTYUUIKBNSETYMD5)
    @ValidDate
    public BizDate getTtdktyuuikbnsetymd5() {
        return ttdktyuuikbnsetymd5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTtdktyuuikbnsetymd5(BizDate pTtdktyuuikbnsetymd5) {
        ttdktyuuikbnsetymd5 = pTtdktyuuikbnsetymd5;
    }

    private C_SeikyuusyaKbn seikyuusyakbn;

    @Type(type="UserType_C_SeikyuusyaKbn")
    @Column(name=GenJV_SeikyuuInfo.SEIKYUUSYAKBN)
    public C_SeikyuusyaKbn getSeikyuusyakbn() {
        return seikyuusyakbn;
    }

    public void setSeikyuusyakbn(C_SeikyuusyaKbn pSeikyuusyakbn) {
        seikyuusyakbn = pSeikyuusyakbn;
    }

    private String seikyuusyanmkn;

    @Column(name=GenJV_SeikyuuInfo.SEIKYUUSYANMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getSeikyuusyanmkn() {
        return seikyuusyanmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSeikyuusyanmkn(String pSeikyuusyanmkn) {
        seikyuusyanmkn = pSeikyuusyanmkn;
    }

    private String seikyuusyanmkj;

    @Column(name=GenJV_SeikyuuInfo.SEIKYUUSYANMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getSeikyuusyanmkj() {
        return seikyuusyanmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSeikyuusyanmkj(String pSeikyuusyanmkj) {
        seikyuusyanmkj = pSeikyuusyanmkj;
    }

    private String tsinyno;

    @Column(name=GenJV_SeikyuuInfo.TSINYNO)
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

    @Column(name=GenJV_SeikyuuInfo.TSINADR1KJ)
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

    @Column(name=GenJV_SeikyuuInfo.TSINADR2KJ)
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

    @Column(name=GenJV_SeikyuuInfo.TSINADR3KJ)
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

    private BizDate syoruiukeymd;

    @Type(type="BizDateType")
    @Column(name=GenJV_SeikyuuInfo.SYORUIUKEYMD)
    @ValidDate
    public BizDate getSyoruiukeymd() {
        return syoruiukeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoruiukeymd(BizDate pSyoruiukeymd) {
        syoruiukeymd = pSyoruiukeymd;
    }

    private BizDate hubikanryouymd;

    @Type(type="BizDateType")
    @Column(name=GenJV_SeikyuuInfo.HUBIKANRYOUYMD)
    @ValidDate
    public BizDate getHubikanryouymd() {
        return hubikanryouymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHubikanryouymd(BizDate pHubikanryouymd) {
        hubikanryouymd = pHubikanryouymd;
    }

    private C_ShrKekkaKbn shrkekkakbn;

    @Type(type="UserType_C_ShrKekkaKbn")
    @Column(name=GenJV_SeikyuuInfo.SHRKEKKAKBN)
    public C_ShrKekkaKbn getShrkekkakbn() {
        return shrkekkakbn;
    }

    public void setShrkekkakbn(C_ShrKekkaKbn pShrkekkakbn) {
        shrkekkakbn = pShrkekkakbn;
    }

    private C_SaigaiHigaitouKbn saigaihigaitoukbn;

    @Type(type="UserType_C_SaigaiHigaitouKbn")
    @Column(name=GenJV_SeikyuuInfo.SAIGAIHIGAITOUKBN)
    public C_SaigaiHigaitouKbn getSaigaihigaitoukbn() {
        return saigaihigaitoukbn;
    }

    public void setSaigaihigaitoukbn(C_SaigaiHigaitouKbn pSaigaihigaitoukbn) {
        saigaihigaitoukbn = pSaigaihigaitoukbn;
    }

    private BizDate shrsyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenJV_SeikyuuInfo.SHRSYORIYMD)
    @ValidDate
    public BizDate getShrsyoriymd() {
        return shrsyoriymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrsyoriymd(BizDate pShrsyoriymd) {
        shrsyoriymd = pShrsyoriymd;
    }

    private BizDate tyakkinymd;

    @Type(type="BizDateType")
    @Column(name=GenJV_SeikyuuInfo.TYAKKINYMD)
    @ValidDate
    public BizDate getTyakkinymd() {
        return tyakkinymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyakkinymd(BizDate pTyakkinymd) {
        tyakkinymd = pTyakkinymd;
    }

    private BizCurrency shrgkkei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrgkkei() {
        return shrgkkei;
    }

    public void setShrgkkei(BizCurrency pShrgkkei) {
        shrgkkei = pShrgkkei;
        shrgkkeiValue = null;
        shrgkkeiType  = null;
    }

    transient private BigDecimal shrgkkeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRGKKEI, nullable=true)
    protected BigDecimal getShrgkkeiValue() {
        if (shrgkkeiValue == null && shrgkkei != null) {
            if (shrgkkei.isOptional()) return null;
            return shrgkkei.absolute();
        }
        return shrgkkeiValue;
    }

    protected void setShrgkkeiValue(BigDecimal value) {
        shrgkkeiValue = value;
        shrgkkei = Optional.fromNullable(toCurrencyType(shrgkkeiType))
            .transform(bizCurrencyTransformer(getShrgkkeiValue()))
            .orNull();
    }

    transient private String shrgkkeiType = null;

    @Column(name=SHRGKKEI + "$", nullable=true)
    protected String getShrgkkeiType() {
        if (shrgkkeiType == null && shrgkkei != null) return shrgkkei.getType().toString();
        if (shrgkkeiType == null && getShrgkkeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrgkkei$' should not be NULL."));
        }
        return shrgkkeiType;
    }

    protected void setShrgkkeiType(String type) {
        shrgkkeiType = type;
        shrgkkei = Optional.fromNullable(toCurrencyType(shrgkkeiType))
            .transform(bizCurrencyTransformer(getShrgkkeiValue()))
            .orNull();
    }

    private C_Tuukasyu shrtuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenJV_SeikyuuInfo.SHRTUUKASYU)
    public C_Tuukasyu getShrtuukasyu() {
        return shrtuukasyu;
    }

    public void setShrtuukasyu(C_Tuukasyu pShrtuukasyu) {
        shrtuukasyu = pShrtuukasyu;
    }

    private BizNumber shrkwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenJV_SeikyuuInfo.SHRKWSRATE)
    public BizNumber getShrkwsrate() {
        return shrkwsrate;
    }

    public void setShrkwsrate(BizNumber pShrkwsrate) {
        shrkwsrate = pShrkwsrate;
    }

    private BizDate shrkwsratekjnymd;

    @Type(type="BizDateType")
    @Column(name=GenJV_SeikyuuInfo.SHRKWSRATEKJNYMD)
    public BizDate getShrkwsratekjnymd() {
        return shrkwsratekjnymd;
    }

    public void setShrkwsratekjnymd(BizDate pShrkwsratekjnymd) {
        shrkwsratekjnymd = pShrkwsratekjnymd;
    }

    private BizNumber gaikaknsnkwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenJV_SeikyuuInfo.GAIKAKNSNKWSRATE)
    public BizNumber getGaikaknsnkwsrate() {
        return gaikaknsnkwsrate;
    }

    public void setGaikaknsnkwsrate(BizNumber pGaikaknsnkwsrate) {
        gaikaknsnkwsrate = pGaikaknsnkwsrate;
    }

    private BizDate gaikaknsnkwsratekjymd;

    @Type(type="BizDateType")
    @Column(name=GenJV_SeikyuuInfo.GAIKAKNSNKWSRATEKJYMD)
    public BizDate getGaikaknsnkwsratekjymd() {
        return gaikaknsnkwsratekjymd;
    }

    public void setGaikaknsnkwsratekjymd(BizDate pGaikaknsnkwsratekjymd) {
        gaikaknsnkwsratekjymd = pGaikaknsnkwsratekjymd;
    }

    private BizCurrency hokenkngkgoukei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHokenkngkgoukei() {
        return hokenkngkgoukei;
    }

    public void setHokenkngkgoukei(BizCurrency pHokenkngkgoukei) {
        hokenkngkgoukei = pHokenkngkgoukei;
        hokenkngkgoukeiValue = null;
        hokenkngkgoukeiType  = null;
    }

    transient private BigDecimal hokenkngkgoukeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HOKENKNGKGOUKEI, nullable=true)
    protected BigDecimal getHokenkngkgoukeiValue() {
        if (hokenkngkgoukeiValue == null && hokenkngkgoukei != null) {
            if (hokenkngkgoukei.isOptional()) return null;
            return hokenkngkgoukei.absolute();
        }
        return hokenkngkgoukeiValue;
    }

    protected void setHokenkngkgoukeiValue(BigDecimal value) {
        hokenkngkgoukeiValue = value;
        hokenkngkgoukei = Optional.fromNullable(toCurrencyType(hokenkngkgoukeiType))
            .transform(bizCurrencyTransformer(getHokenkngkgoukeiValue()))
            .orNull();
    }

    transient private String hokenkngkgoukeiType = null;

    @Column(name=HOKENKNGKGOUKEI + "$", nullable=true)
    protected String getHokenkngkgoukeiType() {
        if (hokenkngkgoukeiType == null && hokenkngkgoukei != null) return hokenkngkgoukei.getType().toString();
        if (hokenkngkgoukeiType == null && getHokenkngkgoukeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hokenkngkgoukei$' should not be NULL."));
        }
        return hokenkngkgoukeiType;
    }

    protected void setHokenkngkgoukeiType(String type) {
        hokenkngkgoukeiType = type;
        hokenkngkgoukei = Optional.fromNullable(toCurrencyType(hokenkngkgoukeiType))
            .transform(bizCurrencyTransformer(getHokenkngkgoukeiValue()))
            .orNull();
    }

    private BizCurrency haitoukin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHaitoukin() {
        return haitoukin;
    }

    public void setHaitoukin(BizCurrency pHaitoukin) {
        haitoukin = pHaitoukin;
        haitoukinValue = null;
        haitoukinType  = null;
    }

    transient private BigDecimal haitoukinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HAITOUKIN, nullable=true)
    protected BigDecimal getHaitoukinValue() {
        if (haitoukinValue == null && haitoukin != null) {
            if (haitoukin.isOptional()) return null;
            return haitoukin.absolute();
        }
        return haitoukinValue;
    }

    protected void setHaitoukinValue(BigDecimal value) {
        haitoukinValue = value;
        haitoukin = Optional.fromNullable(toCurrencyType(haitoukinType))
            .transform(bizCurrencyTransformer(getHaitoukinValue()))
            .orNull();
    }

    transient private String haitoukinType = null;

    @Column(name=HAITOUKIN + "$", nullable=true)
    protected String getHaitoukinType() {
        if (haitoukinType == null && haitoukin != null) return haitoukin.getType().toString();
        if (haitoukinType == null && getHaitoukinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'haitoukin$' should not be NULL."));
        }
        return haitoukinType;
    }

    protected void setHaitoukinType(String type) {
        haitoukinType = type;
        haitoukin = Optional.fromNullable(toCurrencyType(haitoukinType))
            .transform(bizCurrencyTransformer(getHaitoukinValue()))
            .orNull();
    }

    private BizCurrency sonotahaitoukin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSonotahaitoukin() {
        return sonotahaitoukin;
    }

    public void setSonotahaitoukin(BizCurrency pSonotahaitoukin) {
        sonotahaitoukin = pSonotahaitoukin;
        sonotahaitoukinValue = null;
        sonotahaitoukinType  = null;
    }

    transient private BigDecimal sonotahaitoukinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SONOTAHAITOUKIN, nullable=true)
    protected BigDecimal getSonotahaitoukinValue() {
        if (sonotahaitoukinValue == null && sonotahaitoukin != null) {
            if (sonotahaitoukin.isOptional()) return null;
            return sonotahaitoukin.absolute();
        }
        return sonotahaitoukinValue;
    }

    protected void setSonotahaitoukinValue(BigDecimal value) {
        sonotahaitoukinValue = value;
        sonotahaitoukin = Optional.fromNullable(toCurrencyType(sonotahaitoukinType))
            .transform(bizCurrencyTransformer(getSonotahaitoukinValue()))
            .orNull();
    }

    transient private String sonotahaitoukinType = null;

    @Column(name=SONOTAHAITOUKIN + "$", nullable=true)
    protected String getSonotahaitoukinType() {
        if (sonotahaitoukinType == null && sonotahaitoukin != null) return sonotahaitoukin.getType().toString();
        if (sonotahaitoukinType == null && getSonotahaitoukinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sonotahaitoukin$' should not be NULL."));
        }
        return sonotahaitoukinType;
    }

    protected void setSonotahaitoukinType(String type) {
        sonotahaitoukinType = type;
        sonotahaitoukin = Optional.fromNullable(toCurrencyType(sonotahaitoukinType))
            .transform(bizCurrencyTransformer(getSonotahaitoukinValue()))
            .orNull();
    }

    private BizCurrency misyuup;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMisyuup() {
        return misyuup;
    }

    public void setMisyuup(BizCurrency pMisyuup) {
        misyuup = pMisyuup;
        misyuupValue = null;
        misyuupType  = null;
    }

    transient private BigDecimal misyuupValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MISYUUP, nullable=true)
    protected BigDecimal getMisyuupValue() {
        if (misyuupValue == null && misyuup != null) {
            if (misyuup.isOptional()) return null;
            return misyuup.absolute();
        }
        return misyuupValue;
    }

    protected void setMisyuupValue(BigDecimal value) {
        misyuupValue = value;
        misyuup = Optional.fromNullable(toCurrencyType(misyuupType))
            .transform(bizCurrencyTransformer(getMisyuupValue()))
            .orNull();
    }

    transient private String misyuupType = null;

    @Column(name=MISYUUP + "$", nullable=true)
    protected String getMisyuupType() {
        if (misyuupType == null && misyuup != null) return misyuup.getType().toString();
        if (misyuupType == null && getMisyuupValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'misyuup$' should not be NULL."));
        }
        return misyuupType;
    }

    protected void setMisyuupType(String type) {
        misyuupType = type;
        misyuup = Optional.fromNullable(toCurrencyType(misyuupType))
            .transform(bizCurrencyTransformer(getMisyuupValue()))
            .orNull();
    }

    private BizCurrency mikeikap;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMikeikap() {
        return mikeikap;
    }

    public void setMikeikap(BizCurrency pMikeikap) {
        mikeikap = pMikeikap;
        mikeikapValue = null;
        mikeikapType  = null;
    }

    transient private BigDecimal mikeikapValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MIKEIKAP, nullable=true)
    protected BigDecimal getMikeikapValue() {
        if (mikeikapValue == null && mikeikap != null) {
            if (mikeikap.isOptional()) return null;
            return mikeikap.absolute();
        }
        return mikeikapValue;
    }

    protected void setMikeikapValue(BigDecimal value) {
        mikeikapValue = value;
        mikeikap = Optional.fromNullable(toCurrencyType(mikeikapType))
            .transform(bizCurrencyTransformer(getMikeikapValue()))
            .orNull();
    }

    transient private String mikeikapType = null;

    @Column(name=MIKEIKAP + "$", nullable=true)
    protected String getMikeikapType() {
        if (mikeikapType == null && mikeikap != null) return mikeikap.getType().toString();
        if (mikeikapType == null && getMikeikapValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mikeikap$' should not be NULL."));
        }
        return mikeikapType;
    }

    protected void setMikeikapType(String type) {
        mikeikapType = type;
        mikeikap = Optional.fromNullable(toCurrencyType(mikeikapType))
            .transform(bizCurrencyTransformer(getMikeikapValue()))
            .orNull();
    }

    private BizCurrency zennouseisankgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZennouseisankgk() {
        return zennouseisankgk;
    }

    public void setZennouseisankgk(BizCurrency pZennouseisankgk) {
        zennouseisankgk = pZennouseisankgk;
        zennouseisankgkValue = null;
        zennouseisankgkType  = null;
    }

    transient private BigDecimal zennouseisankgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZENNOUSEISANKGK, nullable=true)
    protected BigDecimal getZennouseisankgkValue() {
        if (zennouseisankgkValue == null && zennouseisankgk != null) {
            if (zennouseisankgk.isOptional()) return null;
            return zennouseisankgk.absolute();
        }
        return zennouseisankgkValue;
    }

    protected void setZennouseisankgkValue(BigDecimal value) {
        zennouseisankgkValue = value;
        zennouseisankgk = Optional.fromNullable(toCurrencyType(zennouseisankgkType))
            .transform(bizCurrencyTransformer(getZennouseisankgkValue()))
            .orNull();
    }

    transient private String zennouseisankgkType = null;

    @Column(name=ZENNOUSEISANKGK + "$", nullable=true)
    protected String getZennouseisankgkType() {
        if (zennouseisankgkType == null && zennouseisankgk != null) return zennouseisankgk.getType().toString();
        if (zennouseisankgkType == null && getZennouseisankgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zennouseisankgk$' should not be NULL."));
        }
        return zennouseisankgkType;
    }

    protected void setZennouseisankgkType(String type) {
        zennouseisankgkType = type;
        zennouseisankgk = Optional.fromNullable(toCurrencyType(zennouseisankgkType))
            .transform(bizCurrencyTransformer(getZennouseisankgkValue()))
            .orNull();
    }

    private BizCurrency azukarikingk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getAzukarikingk() {
        return azukarikingk;
    }

    public void setAzukarikingk(BizCurrency pAzukarikingk) {
        azukarikingk = pAzukarikingk;
        azukarikingkValue = null;
        azukarikingkType  = null;
    }

    transient private BigDecimal azukarikingkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=AZUKARIKINGK, nullable=true)
    protected BigDecimal getAzukarikingkValue() {
        if (azukarikingkValue == null && azukarikingk != null) {
            if (azukarikingk.isOptional()) return null;
            return azukarikingk.absolute();
        }
        return azukarikingkValue;
    }

    protected void setAzukarikingkValue(BigDecimal value) {
        azukarikingkValue = value;
        azukarikingk = Optional.fromNullable(toCurrencyType(azukarikingkType))
            .transform(bizCurrencyTransformer(getAzukarikingkValue()))
            .orNull();
    }

    transient private String azukarikingkType = null;

    @Column(name=AZUKARIKINGK + "$", nullable=true)
    protected String getAzukarikingkType() {
        if (azukarikingkType == null && azukarikingk != null) return azukarikingk.getType().toString();
        if (azukarikingkType == null && getAzukarikingkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'azukarikingk$' should not be NULL."));
        }
        return azukarikingkType;
    }

    protected void setAzukarikingkType(String type) {
        azukarikingkType = type;
        azukarikingk = Optional.fromNullable(toCurrencyType(azukarikingkType))
            .transform(bizCurrencyTransformer(getAzukarikingkValue()))
            .orNull();
    }

    private BizCurrency krkgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKrkgk() {
        return krkgk;
    }

    public void setKrkgk(BizCurrency pKrkgk) {
        krkgk = pKrkgk;
        krkgkValue = null;
        krkgkType  = null;
    }

    transient private BigDecimal krkgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KRKGK, nullable=true)
    protected BigDecimal getKrkgkValue() {
        if (krkgkValue == null && krkgk != null) {
            if (krkgk.isOptional()) return null;
            return krkgk.absolute();
        }
        return krkgkValue;
    }

    protected void setKrkgkValue(BigDecimal value) {
        krkgkValue = value;
        krkgk = Optional.fromNullable(toCurrencyType(krkgkType))
            .transform(bizCurrencyTransformer(getKrkgkValue()))
            .orNull();
    }

    transient private String krkgkType = null;

    @Column(name=KRKGK + "$", nullable=true)
    protected String getKrkgkType() {
        if (krkgkType == null && krkgk != null) return krkgk.getType().toString();
        if (krkgkType == null && getKrkgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'krkgk$' should not be NULL."));
        }
        return krkgkType;
    }

    protected void setKrkgkType(String type) {
        krkgkType = type;
        krkgk = Optional.fromNullable(toCurrencyType(krkgkType))
            .transform(bizCurrencyTransformer(getKrkgkValue()))
            .orNull();
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

    private BizCurrency yenshrgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenshrgk() {
        return yenshrgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenshrgk(BizCurrency pYenshrgk) {
        yenshrgk = pYenshrgk;
        yenshrgkValue = null;
        yenshrgkType  = null;
    }

    transient private BigDecimal yenshrgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENSHRGK, nullable=true)
    protected BigDecimal getYenshrgkValue() {
        if (yenshrgkValue == null && yenshrgk != null) {
            if (yenshrgk.isOptional()) return null;
            return yenshrgk.absolute();
        }
        return yenshrgkValue;
    }

    protected void setYenshrgkValue(BigDecimal value) {
        yenshrgkValue = value;
        yenshrgk = Optional.fromNullable(toCurrencyType(yenshrgkType))
            .transform(bizCurrencyTransformer(getYenshrgkValue()))
            .orNull();
    }

    transient private String yenshrgkType = null;

    @Column(name=YENSHRGK + "$", nullable=true)
    protected String getYenshrgkType() {
        if (yenshrgkType == null && yenshrgk != null) return yenshrgk.getType().toString();
        if (yenshrgkType == null && getYenshrgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenshrgk$' should not be NULL."));
        }
        return yenshrgkType;
    }

    protected void setYenshrgkType(String type) {
        yenshrgkType = type;
        yenshrgk = Optional.fromNullable(toCurrencyType(yenshrgkType))
            .transform(bizCurrencyTransformer(getYenshrgkValue()))
            .orNull();
    }

    private BizCurrency yenhkgkgoukei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenhkgkgoukei() {
        return yenhkgkgoukei;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenhkgkgoukei(BizCurrency pYenhkgkgoukei) {
        yenhkgkgoukei = pYenhkgkgoukei;
        yenhkgkgoukeiValue = null;
        yenhkgkgoukeiType  = null;
    }

    transient private BigDecimal yenhkgkgoukeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENHKGKGOUKEI, nullable=true)
    protected BigDecimal getYenhkgkgoukeiValue() {
        if (yenhkgkgoukeiValue == null && yenhkgkgoukei != null) {
            if (yenhkgkgoukei.isOptional()) return null;
            return yenhkgkgoukei.absolute();
        }
        return yenhkgkgoukeiValue;
    }

    protected void setYenhkgkgoukeiValue(BigDecimal value) {
        yenhkgkgoukeiValue = value;
        yenhkgkgoukei = Optional.fromNullable(toCurrencyType(yenhkgkgoukeiType))
            .transform(bizCurrencyTransformer(getYenhkgkgoukeiValue()))
            .orNull();
    }

    transient private String yenhkgkgoukeiType = null;

    @Column(name=YENHKGKGOUKEI + "$", nullable=true)
    protected String getYenhkgkgoukeiType() {
        if (yenhkgkgoukeiType == null && yenhkgkgoukei != null) return yenhkgkgoukei.getType().toString();
        if (yenhkgkgoukeiType == null && getYenhkgkgoukeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenhkgkgoukei$' should not be NULL."));
        }
        return yenhkgkgoukeiType;
    }

    protected void setYenhkgkgoukeiType(String type) {
        yenhkgkgoukeiType = type;
        yenhkgkgoukei = Optional.fromNullable(toCurrencyType(yenhkgkgoukeiType))
            .transform(bizCurrencyTransformer(getYenhkgkgoukeiValue()))
            .orNull();
    }

    private BizCurrency yenkahaitoukin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkahaitoukin() {
        return yenkahaitoukin;
    }

    public void setYenkahaitoukin(BizCurrency pYenkahaitoukin) {
        yenkahaitoukin = pYenkahaitoukin;
        yenkahaitoukinValue = null;
        yenkahaitoukinType  = null;
    }

    transient private BigDecimal yenkahaitoukinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKAHAITOUKIN, nullable=true)
    protected BigDecimal getYenkahaitoukinValue() {
        if (yenkahaitoukinValue == null && yenkahaitoukin != null) {
            if (yenkahaitoukin.isOptional()) return null;
            return yenkahaitoukin.absolute();
        }
        return yenkahaitoukinValue;
    }

    protected void setYenkahaitoukinValue(BigDecimal value) {
        yenkahaitoukinValue = value;
        yenkahaitoukin = Optional.fromNullable(toCurrencyType(yenkahaitoukinType))
            .transform(bizCurrencyTransformer(getYenkahaitoukinValue()))
            .orNull();
    }

    transient private String yenkahaitoukinType = null;

    @Column(name=YENKAHAITOUKIN + "$", nullable=true)
    protected String getYenkahaitoukinType() {
        if (yenkahaitoukinType == null && yenkahaitoukin != null) return yenkahaitoukin.getType().toString();
        if (yenkahaitoukinType == null && getYenkahaitoukinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkahaitoukin$' should not be NULL."));
        }
        return yenkahaitoukinType;
    }

    protected void setYenkahaitoukinType(String type) {
        yenkahaitoukinType = type;
        yenkahaitoukin = Optional.fromNullable(toCurrencyType(yenkahaitoukinType))
            .transform(bizCurrencyTransformer(getYenkahaitoukinValue()))
            .orNull();
    }

    private BizCurrency yenkasonotahaitoukin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkasonotahaitoukin() {
        return yenkasonotahaitoukin;
    }

    public void setYenkasonotahaitoukin(BizCurrency pYenkasonotahaitoukin) {
        yenkasonotahaitoukin = pYenkasonotahaitoukin;
        yenkasonotahaitoukinValue = null;
        yenkasonotahaitoukinType  = null;
    }

    transient private BigDecimal yenkasonotahaitoukinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKASONOTAHAITOUKIN, nullable=true)
    protected BigDecimal getYenkasonotahaitoukinValue() {
        if (yenkasonotahaitoukinValue == null && yenkasonotahaitoukin != null) {
            if (yenkasonotahaitoukin.isOptional()) return null;
            return yenkasonotahaitoukin.absolute();
        }
        return yenkasonotahaitoukinValue;
    }

    protected void setYenkasonotahaitoukinValue(BigDecimal value) {
        yenkasonotahaitoukinValue = value;
        yenkasonotahaitoukin = Optional.fromNullable(toCurrencyType(yenkasonotahaitoukinType))
            .transform(bizCurrencyTransformer(getYenkasonotahaitoukinValue()))
            .orNull();
    }

    transient private String yenkasonotahaitoukinType = null;

    @Column(name=YENKASONOTAHAITOUKIN + "$", nullable=true)
    protected String getYenkasonotahaitoukinType() {
        if (yenkasonotahaitoukinType == null && yenkasonotahaitoukin != null) return yenkasonotahaitoukin.getType().toString();
        if (yenkasonotahaitoukinType == null && getYenkasonotahaitoukinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkasonotahaitoukin$' should not be NULL."));
        }
        return yenkasonotahaitoukinType;
    }

    protected void setYenkasonotahaitoukinType(String type) {
        yenkasonotahaitoukinType = type;
        yenkasonotahaitoukin = Optional.fromNullable(toCurrencyType(yenkasonotahaitoukinType))
            .transform(bizCurrencyTransformer(getYenkasonotahaitoukinValue()))
            .orNull();
    }

    private BizCurrency yenkamisyuup;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkamisyuup() {
        return yenkamisyuup;
    }

    public void setYenkamisyuup(BizCurrency pYenkamisyuup) {
        yenkamisyuup = pYenkamisyuup;
        yenkamisyuupValue = null;
        yenkamisyuupType  = null;
    }

    transient private BigDecimal yenkamisyuupValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKAMISYUUP, nullable=true)
    protected BigDecimal getYenkamisyuupValue() {
        if (yenkamisyuupValue == null && yenkamisyuup != null) {
            if (yenkamisyuup.isOptional()) return null;
            return yenkamisyuup.absolute();
        }
        return yenkamisyuupValue;
    }

    protected void setYenkamisyuupValue(BigDecimal value) {
        yenkamisyuupValue = value;
        yenkamisyuup = Optional.fromNullable(toCurrencyType(yenkamisyuupType))
            .transform(bizCurrencyTransformer(getYenkamisyuupValue()))
            .orNull();
    }

    transient private String yenkamisyuupType = null;

    @Column(name=YENKAMISYUUP + "$", nullable=true)
    protected String getYenkamisyuupType() {
        if (yenkamisyuupType == null && yenkamisyuup != null) return yenkamisyuup.getType().toString();
        if (yenkamisyuupType == null && getYenkamisyuupValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkamisyuup$' should not be NULL."));
        }
        return yenkamisyuupType;
    }

    protected void setYenkamisyuupType(String type) {
        yenkamisyuupType = type;
        yenkamisyuup = Optional.fromNullable(toCurrencyType(yenkamisyuupType))
            .transform(bizCurrencyTransformer(getYenkamisyuupValue()))
            .orNull();
    }

    private BizCurrency yenkamikeikap;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkamikeikap() {
        return yenkamikeikap;
    }

    public void setYenkamikeikap(BizCurrency pYenkamikeikap) {
        yenkamikeikap = pYenkamikeikap;
        yenkamikeikapValue = null;
        yenkamikeikapType  = null;
    }

    transient private BigDecimal yenkamikeikapValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKAMIKEIKAP, nullable=true)
    protected BigDecimal getYenkamikeikapValue() {
        if (yenkamikeikapValue == null && yenkamikeikap != null) {
            if (yenkamikeikap.isOptional()) return null;
            return yenkamikeikap.absolute();
        }
        return yenkamikeikapValue;
    }

    protected void setYenkamikeikapValue(BigDecimal value) {
        yenkamikeikapValue = value;
        yenkamikeikap = Optional.fromNullable(toCurrencyType(yenkamikeikapType))
            .transform(bizCurrencyTransformer(getYenkamikeikapValue()))
            .orNull();
    }

    transient private String yenkamikeikapType = null;

    @Column(name=YENKAMIKEIKAP + "$", nullable=true)
    protected String getYenkamikeikapType() {
        if (yenkamikeikapType == null && yenkamikeikap != null) return yenkamikeikap.getType().toString();
        if (yenkamikeikapType == null && getYenkamikeikapValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkamikeikap$' should not be NULL."));
        }
        return yenkamikeikapType;
    }

    protected void setYenkamikeikapType(String type) {
        yenkamikeikapType = type;
        yenkamikeikap = Optional.fromNullable(toCurrencyType(yenkamikeikapType))
            .transform(bizCurrencyTransformer(getYenkamikeikapValue()))
            .orNull();
    }

    private BizCurrency yenkazennouseisankgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkazennouseisankgk() {
        return yenkazennouseisankgk;
    }

    public void setYenkazennouseisankgk(BizCurrency pYenkazennouseisankgk) {
        yenkazennouseisankgk = pYenkazennouseisankgk;
        yenkazennouseisankgkValue = null;
        yenkazennouseisankgkType  = null;
    }

    transient private BigDecimal yenkazennouseisankgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKAZENNOUSEISANKGK, nullable=true)
    protected BigDecimal getYenkazennouseisankgkValue() {
        if (yenkazennouseisankgkValue == null && yenkazennouseisankgk != null) {
            if (yenkazennouseisankgk.isOptional()) return null;
            return yenkazennouseisankgk.absolute();
        }
        return yenkazennouseisankgkValue;
    }

    protected void setYenkazennouseisankgkValue(BigDecimal value) {
        yenkazennouseisankgkValue = value;
        yenkazennouseisankgk = Optional.fromNullable(toCurrencyType(yenkazennouseisankgkType))
            .transform(bizCurrencyTransformer(getYenkazennouseisankgkValue()))
            .orNull();
    }

    transient private String yenkazennouseisankgkType = null;

    @Column(name=YENKAZENNOUSEISANKGK + "$", nullable=true)
    protected String getYenkazennouseisankgkType() {
        if (yenkazennouseisankgkType == null && yenkazennouseisankgk != null) return yenkazennouseisankgk.getType().toString();
        if (yenkazennouseisankgkType == null && getYenkazennouseisankgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkazennouseisankgk$' should not be NULL."));
        }
        return yenkazennouseisankgkType;
    }

    protected void setYenkazennouseisankgkType(String type) {
        yenkazennouseisankgkType = type;
        yenkazennouseisankgk = Optional.fromNullable(toCurrencyType(yenkazennouseisankgkType))
            .transform(bizCurrencyTransformer(getYenkazennouseisankgkValue()))
            .orNull();
    }

    private BizCurrency yenkaazukarikingk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkaazukarikingk() {
        return yenkaazukarikingk;
    }

    public void setYenkaazukarikingk(BizCurrency pYenkaazukarikingk) {
        yenkaazukarikingk = pYenkaazukarikingk;
        yenkaazukarikingkValue = null;
        yenkaazukarikingkType  = null;
    }

    transient private BigDecimal yenkaazukarikingkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKAAZUKARIKINGK, nullable=true)
    protected BigDecimal getYenkaazukarikingkValue() {
        if (yenkaazukarikingkValue == null && yenkaazukarikingk != null) {
            if (yenkaazukarikingk.isOptional()) return null;
            return yenkaazukarikingk.absolute();
        }
        return yenkaazukarikingkValue;
    }

    protected void setYenkaazukarikingkValue(BigDecimal value) {
        yenkaazukarikingkValue = value;
        yenkaazukarikingk = Optional.fromNullable(toCurrencyType(yenkaazukarikingkType))
            .transform(bizCurrencyTransformer(getYenkaazukarikingkValue()))
            .orNull();
    }

    transient private String yenkaazukarikingkType = null;

    @Column(name=YENKAAZUKARIKINGK + "$", nullable=true)
    protected String getYenkaazukarikingkType() {
        if (yenkaazukarikingkType == null && yenkaazukarikingk != null) return yenkaazukarikingk.getType().toString();
        if (yenkaazukarikingkType == null && getYenkaazukarikingkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkaazukarikingk$' should not be NULL."));
        }
        return yenkaazukarikingkType;
    }

    protected void setYenkaazukarikingkType(String type) {
        yenkaazukarikingkType = type;
        yenkaazukarikingk = Optional.fromNullable(toCurrencyType(yenkaazukarikingkType))
            .transform(bizCurrencyTransformer(getYenkaazukarikingkValue()))
            .orNull();
    }

    private BizCurrency yenkakrkgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkakrkgk() {
        return yenkakrkgk;
    }

    public void setYenkakrkgk(BizCurrency pYenkakrkgk) {
        yenkakrkgk = pYenkakrkgk;
        yenkakrkgkValue = null;
        yenkakrkgkType  = null;
    }

    transient private BigDecimal yenkakrkgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKAKRKGK, nullable=true)
    protected BigDecimal getYenkakrkgkValue() {
        if (yenkakrkgkValue == null && yenkakrkgk != null) {
            if (yenkakrkgk.isOptional()) return null;
            return yenkakrkgk.absolute();
        }
        return yenkakrkgkValue;
    }

    protected void setYenkakrkgkValue(BigDecimal value) {
        yenkakrkgkValue = value;
        yenkakrkgk = Optional.fromNullable(toCurrencyType(yenkakrkgkType))
            .transform(bizCurrencyTransformer(getYenkakrkgkValue()))
            .orNull();
    }

    transient private String yenkakrkgkType = null;

    @Column(name=YENKAKRKGK + "$", nullable=true)
    protected String getYenkakrkgkType() {
        if (yenkakrkgkType == null && yenkakrkgk != null) return yenkakrkgk.getType().toString();
        if (yenkakrkgkType == null && getYenkakrkgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkakrkgk$' should not be NULL."));
        }
        return yenkakrkgkType;
    }

    protected void setYenkakrkgkType(String type) {
        yenkakrkgkType = type;
        yenkakrkgk = Optional.fromNullable(toCurrencyType(yenkakrkgkType))
            .transform(bizCurrencyTransformer(getYenkakrkgkValue()))
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

    private BizCurrency zitkazukarikingksiteituuka;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZitkazukarikingksiteituuka() {
        return zitkazukarikingksiteituuka;
    }

    public void setZitkazukarikingksiteituuka(BizCurrency pZitkazukarikingksiteituuka) {
        zitkazukarikingksiteituuka = pZitkazukarikingksiteituuka;
        zitkazukarikingksiteituukaValue = null;
        zitkazukarikingksiteituukaType  = null;
    }

    transient private BigDecimal zitkazukarikingksiteituukaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZITKAZUKARIKINGKSITEITUUKA, nullable=true)
    protected BigDecimal getZitkazukarikingksiteituukaValue() {
        if (zitkazukarikingksiteituukaValue == null && zitkazukarikingksiteituuka != null) {
            if (zitkazukarikingksiteituuka.isOptional()) return null;
            return zitkazukarikingksiteituuka.absolute();
        }
        return zitkazukarikingksiteituukaValue;
    }

    protected void setZitkazukarikingksiteituukaValue(BigDecimal value) {
        zitkazukarikingksiteituukaValue = value;
        zitkazukarikingksiteituuka = Optional.fromNullable(toCurrencyType(zitkazukarikingksiteituukaType))
            .transform(bizCurrencyTransformer(getZitkazukarikingksiteituukaValue()))
            .orNull();
    }

    transient private String zitkazukarikingksiteituukaType = null;

    @Column(name=ZITKAZUKARIKINGKSITEITUUKA + "$", nullable=true)
    protected String getZitkazukarikingksiteituukaType() {
        if (zitkazukarikingksiteituukaType == null && zitkazukarikingksiteituuka != null) return zitkazukarikingksiteituuka.getType().toString();
        if (zitkazukarikingksiteituukaType == null && getZitkazukarikingksiteituukaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zitkazukarikingksiteituuka$' should not be NULL."));
        }
        return zitkazukarikingksiteituukaType;
    }

    protected void setZitkazukarikingksiteituukaType(String type) {
        zitkazukarikingksiteituukaType = type;
        zitkazukarikingksiteituuka = Optional.fromNullable(toCurrencyType(zitkazukarikingksiteituukaType))
            .transform(bizCurrencyTransformer(getZitkazukarikingksiteituukaValue()))
            .orNull();
    }

    private BizCurrency zitkazukarikingkyen;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZitkazukarikingkyen() {
        return zitkazukarikingkyen;
    }

    public void setZitkazukarikingkyen(BizCurrency pZitkazukarikingkyen) {
        zitkazukarikingkyen = pZitkazukarikingkyen;
        zitkazukarikingkyenValue = null;
        zitkazukarikingkyenType  = null;
    }

    transient private BigDecimal zitkazukarikingkyenValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZITKAZUKARIKINGKYEN, nullable=true)
    protected BigDecimal getZitkazukarikingkyenValue() {
        if (zitkazukarikingkyenValue == null && zitkazukarikingkyen != null) {
            if (zitkazukarikingkyen.isOptional()) return null;
            return zitkazukarikingkyen.absolute();
        }
        return zitkazukarikingkyenValue;
    }

    protected void setZitkazukarikingkyenValue(BigDecimal value) {
        zitkazukarikingkyenValue = value;
        zitkazukarikingkyen = Optional.fromNullable(toCurrencyType(zitkazukarikingkyenType))
            .transform(bizCurrencyTransformer(getZitkazukarikingkyenValue()))
            .orNull();
    }

    transient private String zitkazukarikingkyenType = null;

    @Column(name=ZITKAZUKARIKINGKYEN + "$", nullable=true)
    protected String getZitkazukarikingkyenType() {
        if (zitkazukarikingkyenType == null && zitkazukarikingkyen != null) return zitkazukarikingkyen.getType().toString();
        if (zitkazukarikingkyenType == null && getZitkazukarikingkyenValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zitkazukarikingkyen$' should not be NULL."));
        }
        return zitkazukarikingkyenType;
    }

    protected void setZitkazukarikingkyenType(String type) {
        zitkazukarikingkyenType = type;
        zitkazukarikingkyen = Optional.fromNullable(toCurrencyType(zitkazukarikingkyenType))
            .transform(bizCurrencyTransformer(getZitkazukarikingkyenValue()))
            .orNull();
    }

    private BizCurrency gaikaknsntkgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGaikaknsntkgk() {
        return gaikaknsntkgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGaikaknsntkgk(BizCurrency pGaikaknsntkgk) {
        gaikaknsntkgk = pGaikaknsntkgk;
        gaikaknsntkgkValue = null;
        gaikaknsntkgkType  = null;
    }

    transient private BigDecimal gaikaknsntkgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GAIKAKNSNTKGK, nullable=true)
    protected BigDecimal getGaikaknsntkgkValue() {
        if (gaikaknsntkgkValue == null && gaikaknsntkgk != null) {
            if (gaikaknsntkgk.isOptional()) return null;
            return gaikaknsntkgk.absolute();
        }
        return gaikaknsntkgkValue;
    }

    protected void setGaikaknsntkgkValue(BigDecimal value) {
        gaikaknsntkgkValue = value;
        gaikaknsntkgk = Optional.fromNullable(toCurrencyType(gaikaknsntkgkType))
            .transform(bizCurrencyTransformer(getGaikaknsntkgkValue()))
            .orNull();
    }

    transient private String gaikaknsntkgkType = null;

    @Column(name=GAIKAKNSNTKGK + "$", nullable=true)
    protected String getGaikaknsntkgkType() {
        if (gaikaknsntkgkType == null && gaikaknsntkgk != null) return gaikaknsntkgk.getType().toString();
        if (gaikaknsntkgkType == null && getGaikaknsntkgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gaikaknsntkgk$' should not be NULL."));
        }
        return gaikaknsntkgkType;
    }

    protected void setGaikaknsntkgkType(String type) {
        gaikaknsntkgkType = type;
        gaikaknsntkgk = Optional.fromNullable(toCurrencyType(gaikaknsntkgkType))
            .transform(bizCurrencyTransformer(getGaikaknsntkgkValue()))
            .orNull();
    }

    private BizCurrency gaikaknsnkekkakgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGaikaknsnkekkakgk() {
        return gaikaknsnkekkakgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGaikaknsnkekkakgk(BizCurrency pGaikaknsnkekkakgk) {
        gaikaknsnkekkakgk = pGaikaknsnkekkakgk;
        gaikaknsnkekkakgkValue = null;
        gaikaknsnkekkakgkType  = null;
    }

    transient private BigDecimal gaikaknsnkekkakgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GAIKAKNSNKEKKAKGK, nullable=true)
    protected BigDecimal getGaikaknsnkekkakgkValue() {
        if (gaikaknsnkekkakgkValue == null && gaikaknsnkekkakgk != null) {
            if (gaikaknsnkekkakgk.isOptional()) return null;
            return gaikaknsnkekkakgk.absolute();
        }
        return gaikaknsnkekkakgkValue;
    }

    protected void setGaikaknsnkekkakgkValue(BigDecimal value) {
        gaikaknsnkekkakgkValue = value;
        gaikaknsnkekkakgk = Optional.fromNullable(toCurrencyType(gaikaknsnkekkakgkType))
            .transform(bizCurrencyTransformer(getGaikaknsnkekkakgkValue()))
            .orNull();
    }

    transient private String gaikaknsnkekkakgkType = null;

    @Column(name=GAIKAKNSNKEKKAKGK + "$", nullable=true)
    protected String getGaikaknsnkekkakgkType() {
        if (gaikaknsnkekkakgkType == null && gaikaknsnkekkakgk != null) return gaikaknsnkekkakgk.getType().toString();
        if (gaikaknsnkekkakgkType == null && getGaikaknsnkekkakgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gaikaknsnkekkakgk$' should not be NULL."));
        }
        return gaikaknsnkekkakgkType;
    }

    protected void setGaikaknsnkekkakgkType(String type) {
        gaikaknsnkekkakgkType = type;
        gaikaknsnkekkakgk = Optional.fromNullable(toCurrencyType(gaikaknsnkekkakgkType))
            .transform(bizCurrencyTransformer(getGaikaknsnkekkakgkValue()))
            .orNull();
    }

    private BizCurrency yenkaknsntkgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkaknsntkgk() {
        return yenkaknsntkgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkaknsntkgk(BizCurrency pYenkaknsntkgk) {
        yenkaknsntkgk = pYenkaknsntkgk;
        yenkaknsntkgkValue = null;
        yenkaknsntkgkType  = null;
    }

    transient private BigDecimal yenkaknsntkgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKAKNSNTKGK, nullable=true)
    protected BigDecimal getYenkaknsntkgkValue() {
        if (yenkaknsntkgkValue == null && yenkaknsntkgk != null) {
            if (yenkaknsntkgk.isOptional()) return null;
            return yenkaknsntkgk.absolute();
        }
        return yenkaknsntkgkValue;
    }

    protected void setYenkaknsntkgkValue(BigDecimal value) {
        yenkaknsntkgkValue = value;
        yenkaknsntkgk = Optional.fromNullable(toCurrencyType(yenkaknsntkgkType))
            .transform(bizCurrencyTransformer(getYenkaknsntkgkValue()))
            .orNull();
    }

    transient private String yenkaknsntkgkType = null;

    @Column(name=YENKAKNSNTKGK + "$", nullable=true)
    protected String getYenkaknsntkgkType() {
        if (yenkaknsntkgkType == null && yenkaknsntkgk != null) return yenkaknsntkgk.getType().toString();
        if (yenkaknsntkgkType == null && getYenkaknsntkgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkaknsntkgk$' should not be NULL."));
        }
        return yenkaknsntkgkType;
    }

    protected void setYenkaknsntkgkType(String type) {
        yenkaknsntkgkType = type;
        yenkaknsntkgk = Optional.fromNullable(toCurrencyType(yenkaknsntkgkType))
            .transform(bizCurrencyTransformer(getYenkaknsntkgkValue()))
            .orNull();
    }

    private BizCurrency yenkaknsnkekkakgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkaknsnkekkakgk() {
        return yenkaknsnkekkakgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkaknsnkekkakgk(BizCurrency pYenkaknsnkekkakgk) {
        yenkaknsnkekkakgk = pYenkaknsnkekkakgk;
        yenkaknsnkekkakgkValue = null;
        yenkaknsnkekkakgkType  = null;
    }

    transient private BigDecimal yenkaknsnkekkakgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKAKNSNKEKKAKGK, nullable=true)
    protected BigDecimal getYenkaknsnkekkakgkValue() {
        if (yenkaknsnkekkakgkValue == null && yenkaknsnkekkakgk != null) {
            if (yenkaknsnkekkakgk.isOptional()) return null;
            return yenkaknsnkekkakgk.absolute();
        }
        return yenkaknsnkekkakgkValue;
    }

    protected void setYenkaknsnkekkakgkValue(BigDecimal value) {
        yenkaknsnkekkakgkValue = value;
        yenkaknsnkekkakgk = Optional.fromNullable(toCurrencyType(yenkaknsnkekkakgkType))
            .transform(bizCurrencyTransformer(getYenkaknsnkekkakgkValue()))
            .orNull();
    }

    transient private String yenkaknsnkekkakgkType = null;

    @Column(name=YENKAKNSNKEKKAKGK + "$", nullable=true)
    protected String getYenkaknsnkekkakgkType() {
        if (yenkaknsnkekkakgkType == null && yenkaknsnkekkakgk != null) return yenkaknsnkekkakgk.getType().toString();
        if (yenkaknsnkekkakgkType == null && getYenkaknsnkekkakgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkaknsnkekkakgk$' should not be NULL."));
        }
        return yenkaknsnkekkakgkType;
    }

    protected void setYenkaknsnkekkakgkType(String type) {
        yenkaknsnkekkakgkType = type;
        yenkaknsnkekkakgk = Optional.fromNullable(toCurrencyType(yenkaknsnkekkakgkType))
            .transform(bizCurrencyTransformer(getYenkaknsnkekkakgkValue()))
            .orNull();
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenJV_SeikyuuInfo.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private C_InputShrhousiteiKbn inputshrhousiteikbn;

    @Type(type="UserType_C_InputShrhousiteiKbn")
    @Column(name=GenJV_SeikyuuInfo.INPUTSHRHOUSITEIKBN)
    public C_InputShrhousiteiKbn getInputshrhousiteikbn() {
        return inputshrhousiteikbn;
    }

    public void setInputshrhousiteikbn(C_InputShrhousiteiKbn pInputshrhousiteikbn) {
        inputshrhousiteikbn = pInputshrhousiteikbn;
    }

    private BizNumber zeimukwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenJV_SeikyuuInfo.ZEIMUKWSRATE)
    public BizNumber getZeimukwsrate() {
        return zeimukwsrate;
    }

    public void setZeimukwsrate(BizNumber pZeimukwsrate) {
        zeimukwsrate = pZeimukwsrate;
    }

    private BizDate zeimukwsratekjnymd;

    @Type(type="BizDateType")
    @Column(name=GenJV_SeikyuuInfo.ZEIMUKWSRATEKJNYMD)
    public BizDate getZeimukwsratekjnymd() {
        return zeimukwsratekjnymd;
    }

    public void setZeimukwsratekjnymd(BizDate pZeimukwsratekjnymd) {
        zeimukwsratekjnymd = pZeimukwsratekjnymd;
    }

    private C_ZeitratkiKbn zeitratkikbn;

    @Type(type="UserType_C_ZeitratkiKbn")
    @Column(name=GenJV_SeikyuuInfo.ZEITRATKIKBN)
    public C_ZeitratkiKbn getZeitratkikbn() {
        return zeitratkikbn;
    }

    public void setZeitratkikbn(C_ZeitratkiKbn pZeitratkikbn) {
        zeitratkikbn = pZeitratkikbn;
    }
}