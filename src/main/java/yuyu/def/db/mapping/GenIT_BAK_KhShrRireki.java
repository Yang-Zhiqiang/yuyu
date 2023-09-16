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
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SoukinsakisiteiKbn;
import yuyu.def.classification.C_SyuShrgkSyoukeiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.IT_BAK_KhShrRireki;
import yuyu.def.db.id.PKIT_BAK_KhShrRireki;
import yuyu.def.db.meta.GenQIT_BAK_KhShrRireki;
import yuyu.def.db.meta.QIT_BAK_KhShrRireki;
import yuyu.def.db.type.UserType_C_HtsiryosyuKbn;
import yuyu.def.db.type.UserType_C_InputShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_KouzasyuruiKbn;
import yuyu.def.db.type.UserType_C_Kzdou;
import yuyu.def.db.type.UserType_C_ShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_ShrsyoriKbn;
import yuyu.def.db.type.UserType_C_SinsaGendoKknKbn;
import yuyu.def.db.type.UserType_C_SoukinsakisiteiKbn;
import yuyu.def.db.type.UserType_C_SyuShrgkSyoukeiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.def.db.type.UserType_C_YouhiKbn;
import yuyu.def.db.type.UserType_C_ZeitratkiKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全支払履歴バックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_KhShrRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_KhShrRireki}</td><td colspan="3">契約保全支払履歴バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_KhShrRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_KhShrRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_KhShrRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">{@link PKIT_BAK_KhShrRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShrymd shrymd}</td><td>支払日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrsyoriymd shrsyoriymd}</td><td>支払処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrsyorikbn shrsyorikbn}</td><td>支払処理区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ShrsyoriKbn}</td></tr>
 *  <tr><td>{@link #getTorikesiflg torikesiflg}</td><td>取消フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTorikesiymd torikesiymd}</td><td>取消日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyoruiukeymd syoruiukeymd}</td><td>書類受付日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKouryokuhasseiymd kouryokuhasseiymd}</td><td>効力発生日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrtienrskkisanymd shrtienrskkisanymd}</td><td>支払遅延利息起算日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTienrsknissuu tienrsknissuu}</td><td>遅延利息日数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSinsagendokknkbn sinsagendokknkbn}</td><td>審査限度期間区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SinsaGendoKknKbn}</td></tr>
 *  <tr><td>{@link #getRikoukityuutuudannissuu rikoukityuutuudannissuu}</td><td>履行期中断日数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZeitratkikbn zeitratkikbn}</td><td>税取扱区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ZeitratkiKbn}</td></tr>
 *  <tr><td>{@link #getGsbunritaisyou gsbunritaisyou}</td><td>源泉分離課税対象</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getYenshrtkumu yenshrtkumu}</td><td>円支払特約有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getShrgkkei shrgkkei}</td><td>支払額合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyushrgkkeisyukbn syushrgkkeisyukbn}</td><td>主たる支払額小計種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyuShrgkSyoukeiKbn}</td></tr>
 *  <tr><td>{@link #getSyushrgkkei syushrgkkei}</td><td>主たる支払額小計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMikeikap mikeikap}</td><td>未経過保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHaitoukin haitoukin}</td><td>配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSonotaseisangk sonotaseisangk}</td><td>その他精算額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGstszeigk gstszeigk}</td><td>源泉徴収税額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrtienrsk shrtienrsk}</td><td>支払遅延利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrtuukasyu shrtuukasyu}</td><td>支払通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getShrtuukashrgkgoukei shrtuukashrgkgoukei}</td><td>支払通貨支払額合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrtuukasyushrgkkei shrtuukasyushrgkkei}</td><td>支払通貨主たる支払額小計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrtuukahaitoukin shrtuukahaitoukin}</td><td>支払通貨配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrtuukasonotaseisangk shrtuukasonotaseisangk}</td><td>支払通貨その他精算額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrtuukagstszeigk shrtuukagstszeigk}</td><td>支払通貨源泉徴収税額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrtuukashrtienrsk shrtuukashrtienrsk}</td><td>支払通貨支払遅延利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenshrgkgoukei yenshrgkgoukei}</td><td>円換算支払額合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYensyushrgkkei yensyushrgkkei}</td><td>円換算主たる支払額小計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkansanhaitoukin yenkansanhaitoukin}</td><td>円換算配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkansansonotaseisangk yenkansansonotaseisangk}</td><td>円換算その他精算額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenmikeikap yenmikeikap}</td><td>円換算未経過保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYengstszeigk yengstszeigk}</td><td>円換算源泉徴収税額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYengstszeigknationaltax yengstszeigknationaltax}</td><td>円換算源泉徴収税額（国税）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYengstszeigklocaltax yengstszeigklocaltax}</td><td>円換算源泉徴収税額（地方税）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNztodouhukencd nztodouhukencd}</td><td>納税先都道府県コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYenshrtienrsk yenshrtienrsk}</td><td>円換算支払遅延利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHtykeihi htykeihi}</td><td>必要経費</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKztgk kztgk}</td><td>課税対象額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenhtykeihi yenhtykeihi}</td><td>円換算必要経費</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkztgk yenkztgk}</td><td>円換算課税対象額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrkwsratekjnymd shrkwsratekjnymd}</td><td>支払時為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrkwsrate shrkwsrate}</td><td>支払時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZeimukwsratekjnymd zeimukwsratekjnymd}</td><td>税務用為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZeimukwsrate zeimukwsrate}</td><td>税務用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSoukinsakisiteikbn soukinsakisiteikbn}</td><td>送金先指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SoukinsakisiteiKbn}</td></tr>
 *  <tr><td>{@link #getSoukinsakinmkn soukinsakinmkn}</td><td>送金先氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSoukinsakinmkj soukinsakinmkj}</td><td>送金先氏名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSoukinsakiyno soukinsakiyno}</td><td>送金先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSoukinsakiadr1kj soukinsakiadr1kj}</td><td>送金先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSoukinsakiadr2kj soukinsakiadr2kj}</td><td>送金先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSoukinsakiadr3kj soukinsakiadr3kj}</td><td>送金先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyksyaszknmkn kyksyaszknmkn}</td><td>契約者相続人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyksyaszknmkj kyksyaszknmkj}</td><td>契約者相続人氏名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyksyaszkyno kyksyaszkyno}</td><td>契約者相続人郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyksyaszkadr1kj kyksyaszkadr1kj}</td><td>契約者相続人住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyksyaszkadr2kj kyksyaszkadr2kj}</td><td>契約者相続人住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyksyaszkadr3kj kyksyaszkadr3kj}</td><td>契約者相続人住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSaikennmkj saikennmkj}</td><td>債権者氏名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSaikennyno saikennyno}</td><td>債権者郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSaikenadr1kj saikenadr1kj}</td><td>債権者住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSaikenadr2kj saikenadr2kj}</td><td>債権者住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSaikenadr3kj saikenadr3kj}</td><td>債権者住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getInputshrhousiteikbn inputshrhousiteikbn}</td><td>入力用支払方法指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_InputShrhousiteiKbn}</td></tr>
 *  <tr><td>{@link #getShrhousiteikbn shrhousiteikbn}</td><td>支払方法指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ShrhousiteiKbn}</td></tr>
 *  <tr><td>{@link #getKzsyuruikbn kzsyuruikbn}</td><td>口座種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KouzasyuruiKbn}</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzdoukbn kzdoukbn}</td><td>口座名義人同一区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kzdou}</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykmnmeigibangou kykmnmeigibangou}</td><td>契約者ＭＮ名義番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktmnmeigibangou uktmnmeigibangou}</td><td>受取人ＭＮ名義番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShrtysysyuruikbn shrtysysyuruikbn}</td><td>支払調書種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HtsiryosyuKbn}</td></tr>
 *  <tr><td>{@link #getDenrenno denrenno}</td><td>伝票データ連番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYenshrkykhtykeihi yenshrkykhtykeihi}</td><td>円換算支払時契約者必要経費</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKykhnkkaisuu kykhnkkaisuu}</td><td>契約者変更回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getShrmikeikap shrmikeikap}</td><td>支払通貨未経過保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZennomikeikap zennomikeikap}</td><td>前納未経過保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrzennomikeikap shrzennomikeikap}</td><td>支払通貨前納未経過保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenzennomikeikap yenzennomikeikap}</td><td>円換算前納未経過保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZitkazukarikingksiteituuka zitkazukarikingksiteituuka}</td><td>税適預り金額（指定通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZitkazukarikingkyen zitkazukarikingkyen}</td><td>税適預り金額（円貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrazukarikingk shrazukarikingk}</td><td>支払通貨預り金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenazukarikingk yenazukarikingk}</td><td>円換算預り金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSonotahaitoukin sonotahaitoukin}</td><td>その他配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrtuukasonotahaitoukin shrtuukasonotahaitoukin}</td><td>支払通貨その他配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYensonotahaitoukin yensonotahaitoukin}</td><td>円換算その他配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKrkgk krkgk}</td><td>仮受金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrkrkgk shrkrkgk}</td><td>支払通貨仮受金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkrkgk yenkrkgk}</td><td>円換算仮受金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZeitekiazukarikinkjumu zeitekiazukarikinkjumu}</td><td>税適預り金計上有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getGaikashrkwsratekjnymd gaikashrkwsratekjnymd}</td><td>外貨支払時為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGaikashrkwsrate gaikashrkwsrate}</td><td>外貨支払時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKaiyakuhrkngkkeisiteituuka kaiyakuhrkngkkeisiteituuka}</td><td>解約返戻金額合計（指定通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrtuukakaiyakuhrkngkkei shrtuukakaiyakuhrkngkkei}</td><td>支払通貨解約返戻金額合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaiyakuhrkngkkeiyen kaiyakuhrkngkkeiyen}</td><td>解約返戻金額合計（円貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSonotashrkngksiteituuka sonotashrkngksiteituuka}</td><td>その他支払金額（指定通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrtuukasonotashrkngk shrtuukasonotashrkngk}</td><td>支払通貨その他支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSonotashrkngkyen sonotashrkngkyen}</td><td>その他支払金額（円貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYensynykngk yensynykngk}</td><td>円換算収入金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrtysykurikosiyouhi shrtysykurikosiyouhi}</td><td>支払調書繰越要否</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YouhiKbn}</td></tr>
 * </table>
 * @see     IT_BAK_KhShrRireki
 * @see     PKIT_BAK_KhShrRireki
 * @see     QIT_BAK_KhShrRireki
 * @see     GenQIT_BAK_KhShrRireki
 */
@MappedSuperclass
@Table(name=GenIT_BAK_KhShrRireki.TABLE_NAME)
@IdClass(value=PKIT_BAK_KhShrRireki.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_HtsiryosyuKbn", typeClass=UserType_C_HtsiryosyuKbn.class),
    @TypeDef(name="UserType_C_InputShrhousiteiKbn", typeClass=UserType_C_InputShrhousiteiKbn.class),
    @TypeDef(name="UserType_C_KouzasyuruiKbn", typeClass=UserType_C_KouzasyuruiKbn.class),
    @TypeDef(name="UserType_C_Kzdou", typeClass=UserType_C_Kzdou.class),
    @TypeDef(name="UserType_C_ShrhousiteiKbn", typeClass=UserType_C_ShrhousiteiKbn.class),
    @TypeDef(name="UserType_C_ShrsyoriKbn", typeClass=UserType_C_ShrsyoriKbn.class),
    @TypeDef(name="UserType_C_SinsaGendoKknKbn", typeClass=UserType_C_SinsaGendoKknKbn.class),
    @TypeDef(name="UserType_C_SoukinsakisiteiKbn", typeClass=UserType_C_SoukinsakisiteiKbn.class),
    @TypeDef(name="UserType_C_SyuShrgkSyoukeiKbn", typeClass=UserType_C_SyuShrgkSyoukeiKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class),
    @TypeDef(name="UserType_C_YouhiKbn", typeClass=UserType_C_YouhiKbn.class),
    @TypeDef(name="UserType_C_ZeitratkiKbn", typeClass=UserType_C_ZeitratkiKbn.class)
})
public abstract class GenIT_BAK_KhShrRireki extends AbstractExDBEntity<IT_BAK_KhShrRireki, PKIT_BAK_KhShrRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_KhShrRireki";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String SHRYMD                   = "shrymd";
    public static final String SHRSYORIYMD              = "shrsyoriymd";
    public static final String SHRSYORIKBN              = "shrsyorikbn";
    public static final String TORIKESIFLG              = "torikesiflg";
    public static final String TORIKESIYMD              = "torikesiymd";
    public static final String SYORUIUKEYMD             = "syoruiukeymd";
    public static final String KOURYOKUHASSEIYMD        = "kouryokuhasseiymd";
    public static final String SHRTIENRSKKISANYMD       = "shrtienrskkisanymd";
    public static final String TIENRSKNISSUU            = "tienrsknissuu";
    public static final String SINSAGENDOKKNKBN         = "sinsagendokknkbn";
    public static final String RIKOUKITYUUTUUDANNISSUU  = "rikoukityuutuudannissuu";
    public static final String ZEITRATKIKBN             = "zeitratkikbn";
    public static final String GSBUNRITAISYOU           = "gsbunritaisyou";
    public static final String YENSHRTKUMU              = "yenshrtkumu";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String SHRGKKEI                 = "shrgkkei";
    public static final String SYUSHRGKKEISYUKBN        = "syushrgkkeisyukbn";
    public static final String SYUSHRGKKEI              = "syushrgkkei";
    public static final String MIKEIKAP                 = "mikeikap";
    public static final String HAITOUKIN                = "haitoukin";
    public static final String SONOTASEISANGK           = "sonotaseisangk";
    public static final String GSTSZEIGK                = "gstszeigk";
    public static final String SHRTIENRSK               = "shrtienrsk";
    public static final String SHRTUUKASYU              = "shrtuukasyu";
    public static final String SHRTUUKASHRGKGOUKEI      = "shrtuukashrgkgoukei";
    public static final String SHRTUUKASYUSHRGKKEI      = "shrtuukasyushrgkkei";
    public static final String SHRTUUKAHAITOUKIN        = "shrtuukahaitoukin";
    public static final String SHRTUUKASONOTASEISANGK   = "shrtuukasonotaseisangk";
    public static final String SHRTUUKAGSTSZEIGK        = "shrtuukagstszeigk";
    public static final String SHRTUUKASHRTIENRSK       = "shrtuukashrtienrsk";
    public static final String YENSHRGKGOUKEI           = "yenshrgkgoukei";
    public static final String YENSYUSHRGKKEI           = "yensyushrgkkei";
    public static final String YENKANSANHAITOUKIN       = "yenkansanhaitoukin";
    public static final String YENKANSANSONOTASEISANGK  = "yenkansansonotaseisangk";
    public static final String YENMIKEIKAP              = "yenmikeikap";
    public static final String YENGSTSZEIGK             = "yengstszeigk";
    public static final String YENGSTSZEIGKNATIONALTAX  = "yengstszeigknationaltax";
    public static final String YENGSTSZEIGKLOCALTAX     = "yengstszeigklocaltax";
    public static final String NZTODOUHUKENCD           = "nztodouhukencd";
    public static final String YENSHRTIENRSK            = "yenshrtienrsk";
    public static final String HTYKEIHI                 = "htykeihi";
    public static final String KZTGK                    = "kztgk";
    public static final String YENHTYKEIHI              = "yenhtykeihi";
    public static final String YENKZTGK                 = "yenkztgk";
    public static final String SHRKWSRATEKJNYMD         = "shrkwsratekjnymd";
    public static final String SHRKWSRATE               = "shrkwsrate";
    public static final String ZEIMUKWSRATEKJNYMD       = "zeimukwsratekjnymd";
    public static final String ZEIMUKWSRATE             = "zeimukwsrate";
    public static final String SOUKINSAKISITEIKBN       = "soukinsakisiteikbn";
    public static final String SOUKINSAKINMKN           = "soukinsakinmkn";
    public static final String SOUKINSAKINMKJ           = "soukinsakinmkj";
    public static final String SOUKINSAKIYNO            = "soukinsakiyno";
    public static final String SOUKINSAKIADR1KJ         = "soukinsakiadr1kj";
    public static final String SOUKINSAKIADR2KJ         = "soukinsakiadr2kj";
    public static final String SOUKINSAKIADR3KJ         = "soukinsakiadr3kj";
    public static final String KYKSYASZKNMKN            = "kyksyaszknmkn";
    public static final String KYKSYASZKNMKJ            = "kyksyaszknmkj";
    public static final String KYKSYASZKYNO             = "kyksyaszkyno";
    public static final String KYKSYASZKADR1KJ          = "kyksyaszkadr1kj";
    public static final String KYKSYASZKADR2KJ          = "kyksyaszkadr2kj";
    public static final String KYKSYASZKADR3KJ          = "kyksyaszkadr3kj";
    public static final String SAIKENNMKJ               = "saikennmkj";
    public static final String SAIKENNYNO               = "saikennyno";
    public static final String SAIKENADR1KJ             = "saikenadr1kj";
    public static final String SAIKENADR2KJ             = "saikenadr2kj";
    public static final String SAIKENADR3KJ             = "saikenadr3kj";
    public static final String INPUTSHRHOUSITEIKBN      = "inputshrhousiteikbn";
    public static final String SHRHOUSITEIKBN           = "shrhousiteikbn";
    public static final String KZSYURUIKBN              = "kzsyuruikbn";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String KZDOUKBN                 = "kzdoukbn";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String KYKMNMEIGIBANGOU         = "kykmnmeigibangou";
    public static final String UKTMNMEIGIBANGOU         = "uktmnmeigibangou";
    public static final String SHRTYSYSYURUIKBN         = "shrtysysyuruikbn";
    public static final String DENRENNO                 = "denrenno";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String YENSHRKYKHTYKEIHI        = "yenshrkykhtykeihi";
    public static final String KYKHNKKAISUU             = "kykhnkkaisuu";
    public static final String SHRMIKEIKAP              = "shrmikeikap";
    public static final String ZENNOMIKEIKAP            = "zennomikeikap";
    public static final String SHRZENNOMIKEIKAP         = "shrzennomikeikap";
    public static final String YENZENNOMIKEIKAP         = "yenzennomikeikap";
    public static final String ZITKAZUKARIKINGKSITEITUUKA = "zitkazukarikingksiteituuka";
    public static final String ZITKAZUKARIKINGKYEN      = "zitkazukarikingkyen";
    public static final String SHRAZUKARIKINGK          = "shrazukarikingk";
    public static final String YENAZUKARIKINGK          = "yenazukarikingk";
    public static final String SONOTAHAITOUKIN          = "sonotahaitoukin";
    public static final String SHRTUUKASONOTAHAITOUKIN  = "shrtuukasonotahaitoukin";
    public static final String YENSONOTAHAITOUKIN       = "yensonotahaitoukin";
    public static final String KRKGK                    = "krkgk";
    public static final String SHRKRKGK                 = "shrkrkgk";
    public static final String YENKRKGK                 = "yenkrkgk";
    public static final String ZEITEKIAZUKARIKINKJUMU   = "zeitekiazukarikinkjumu";
    public static final String GAIKASHRKWSRATEKJNYMD    = "gaikashrkwsratekjnymd";
    public static final String GAIKASHRKWSRATE          = "gaikashrkwsrate";
    public static final String KAIYAKUHRKNGKKEISITEITUUKA = "kaiyakuhrkngkkeisiteituuka";
    public static final String SHRTUUKAKAIYAKUHRKNGKKEI = "shrtuukakaiyakuhrkngkkei";
    public static final String KAIYAKUHRKNGKKEIYEN      = "kaiyakuhrkngkkeiyen";
    public static final String SONOTASHRKNGKSITEITUUKA  = "sonotashrkngksiteituuka";
    public static final String SHRTUUKASONOTASHRKNGK    = "shrtuukasonotashrkngk";
    public static final String SONOTASHRKNGKYEN         = "sonotashrkngkyen";
    public static final String YENSYNYKNGK              = "yensynykngk";
    public static final String SHRTYSYKURIKOSIYOUHI     = "shrtysykurikosiyouhi";

    private final PKIT_BAK_KhShrRireki primaryKey;

    public GenIT_BAK_KhShrRireki() {
        primaryKey = new PKIT_BAK_KhShrRireki();
    }

    public GenIT_BAK_KhShrRireki(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        String pHenkousikibetukey
    ) {
        primaryKey = new PKIT_BAK_KhShrRireki(
            pKbnkey,
            pSyono,
            pTrkssikibetukey,
            pHenkousikibetukey
        );
    }

    @Transient
    @Override
    public PKIT_BAK_KhShrRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_KhShrRireki> getMetaClass() {
        return QIT_BAK_KhShrRireki.class;
    }

    @Id
    @Column(name=GenIT_BAK_KhShrRireki.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_KhShrRireki.SYONO)
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
    @Column(name=GenIT_BAK_KhShrRireki.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    @Id
    @Column(name=GenIT_BAK_KhShrRireki.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return getPrimaryKey().getHenkousikibetukey();
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        getPrimaryKey().setHenkousikibetukey(pHenkousikibetukey);
    }

    private BizDate shrymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KhShrRireki.SHRYMD)
    @ValidDate
    public BizDate getShrymd() {
        return shrymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrymd(BizDate pShrymd) {
        shrymd = pShrymd;
    }

    private BizDate shrsyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KhShrRireki.SHRSYORIYMD)
    @ValidDate
    public BizDate getShrsyoriymd() {
        return shrsyoriymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrsyoriymd(BizDate pShrsyoriymd) {
        shrsyoriymd = pShrsyoriymd;
    }

    private C_ShrsyoriKbn shrsyorikbn;

    @Type(type="UserType_C_ShrsyoriKbn")
    @Column(name=GenIT_BAK_KhShrRireki.SHRSYORIKBN)
    public C_ShrsyoriKbn getShrsyorikbn() {
        return shrsyorikbn;
    }

    public void setShrsyorikbn(C_ShrsyoriKbn pShrsyorikbn) {
        shrsyorikbn = pShrsyorikbn;
    }

    private C_UmuKbn torikesiflg;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_BAK_KhShrRireki.TORIKESIFLG)
    public C_UmuKbn getTorikesiflg() {
        return torikesiflg;
    }

    public void setTorikesiflg(C_UmuKbn pTorikesiflg) {
        torikesiflg = pTorikesiflg;
    }

    private BizDate torikesiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KhShrRireki.TORIKESIYMD)
    public BizDate getTorikesiymd() {
        return torikesiymd;
    }

    @Trim("both")
    public void setTorikesiymd(BizDate pTorikesiymd) {
        torikesiymd = pTorikesiymd;
    }

    private BizDate syoruiukeymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KhShrRireki.SYORUIUKEYMD)
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
    @Column(name=GenIT_BAK_KhShrRireki.KOURYOKUHASSEIYMD)
    public BizDate getKouryokuhasseiymd() {
        return kouryokuhasseiymd;
    }

    public void setKouryokuhasseiymd(BizDate pKouryokuhasseiymd) {
        kouryokuhasseiymd = pKouryokuhasseiymd;
    }

    private BizDate shrtienrskkisanymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KhShrRireki.SHRTIENRSKKISANYMD)
    public BizDate getShrtienrskkisanymd() {
        return shrtienrskkisanymd;
    }

    public void setShrtienrskkisanymd(BizDate pShrtienrskkisanymd) {
        shrtienrskkisanymd = pShrtienrskkisanymd;
    }

    private Integer tienrsknissuu;

    @Column(name=GenIT_BAK_KhShrRireki.TIENRSKNISSUU)
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

    private C_SinsaGendoKknKbn sinsagendokknkbn;

    @Type(type="UserType_C_SinsaGendoKknKbn")
    @Column(name=GenIT_BAK_KhShrRireki.SINSAGENDOKKNKBN)
    public C_SinsaGendoKknKbn getSinsagendokknkbn() {
        return sinsagendokknkbn;
    }

    public void setSinsagendokknkbn(C_SinsaGendoKknKbn pSinsagendokknkbn) {
        sinsagendokknkbn = pSinsagendokknkbn;
    }

    private Integer rikoukityuutuudannissuu;

    @Column(name=GenIT_BAK_KhShrRireki.RIKOUKITYUUTUUDANNISSUU)
    @Range(min="0", max="999")
    public Integer getRikoukityuutuudannissuu() {
        return rikoukityuutuudannissuu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRikoukityuutuudannissuu(Integer pRikoukityuutuudannissuu) {
        rikoukityuutuudannissuu = pRikoukityuutuudannissuu;
    }

    private C_ZeitratkiKbn zeitratkikbn;

    @Type(type="UserType_C_ZeitratkiKbn")
    @Column(name=GenIT_BAK_KhShrRireki.ZEITRATKIKBN)
    public C_ZeitratkiKbn getZeitratkikbn() {
        return zeitratkikbn;
    }

    public void setZeitratkikbn(C_ZeitratkiKbn pZeitratkikbn) {
        zeitratkikbn = pZeitratkikbn;
    }

    private C_UmuKbn gsbunritaisyou;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_BAK_KhShrRireki.GSBUNRITAISYOU)
    public C_UmuKbn getGsbunritaisyou() {
        return gsbunritaisyou;
    }

    public void setGsbunritaisyou(C_UmuKbn pGsbunritaisyou) {
        gsbunritaisyou = pGsbunritaisyou;
    }

    private C_UmuKbn yenshrtkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_BAK_KhShrRireki.YENSHRTKUMU)
    public C_UmuKbn getYenshrtkumu() {
        return yenshrtkumu;
    }

    public void setYenshrtkumu(C_UmuKbn pYenshrtkumu) {
        yenshrtkumu = pYenshrtkumu;
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_KhShrRireki.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
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

    private C_SyuShrgkSyoukeiKbn syushrgkkeisyukbn;

    @Type(type="UserType_C_SyuShrgkSyoukeiKbn")
    @Column(name=GenIT_BAK_KhShrRireki.SYUSHRGKKEISYUKBN)
    public C_SyuShrgkSyoukeiKbn getSyushrgkkeisyukbn() {
        return syushrgkkeisyukbn;
    }

    public void setSyushrgkkeisyukbn(C_SyuShrgkSyoukeiKbn pSyushrgkkeisyukbn) {
        syushrgkkeisyukbn = pSyushrgkkeisyukbn;
    }

    private BizCurrency syushrgkkei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSyushrgkkei() {
        return syushrgkkei;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyushrgkkei(BizCurrency pSyushrgkkei) {
        syushrgkkei = pSyushrgkkei;
        syushrgkkeiValue = null;
        syushrgkkeiType  = null;
    }

    transient private BigDecimal syushrgkkeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SYUSHRGKKEI, nullable=true)
    protected BigDecimal getSyushrgkkeiValue() {
        if (syushrgkkeiValue == null && syushrgkkei != null) {
            if (syushrgkkei.isOptional()) return null;
            return syushrgkkei.absolute();
        }
        return syushrgkkeiValue;
    }

    protected void setSyushrgkkeiValue(BigDecimal value) {
        syushrgkkeiValue = value;
        syushrgkkei = Optional.fromNullable(toCurrencyType(syushrgkkeiType))
            .transform(bizCurrencyTransformer(getSyushrgkkeiValue()))
            .orNull();
    }

    transient private String syushrgkkeiType = null;

    @Column(name=SYUSHRGKKEI + "$", nullable=true)
    protected String getSyushrgkkeiType() {
        if (syushrgkkeiType == null && syushrgkkei != null) return syushrgkkei.getType().toString();
        if (syushrgkkeiType == null && getSyushrgkkeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'syushrgkkei$' should not be NULL."));
        }
        return syushrgkkeiType;
    }

    protected void setSyushrgkkeiType(String type) {
        syushrgkkeiType = type;
        syushrgkkei = Optional.fromNullable(toCurrencyType(syushrgkkeiType))
            .transform(bizCurrencyTransformer(getSyushrgkkeiValue()))
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

    private BizCurrency sonotaseisangk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSonotaseisangk() {
        return sonotaseisangk;
    }

    public void setSonotaseisangk(BizCurrency pSonotaseisangk) {
        sonotaseisangk = pSonotaseisangk;
        sonotaseisangkValue = null;
        sonotaseisangkType  = null;
    }

    transient private BigDecimal sonotaseisangkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SONOTASEISANGK, nullable=true)
    protected BigDecimal getSonotaseisangkValue() {
        if (sonotaseisangkValue == null && sonotaseisangk != null) {
            if (sonotaseisangk.isOptional()) return null;
            return sonotaseisangk.absolute();
        }
        return sonotaseisangkValue;
    }

    protected void setSonotaseisangkValue(BigDecimal value) {
        sonotaseisangkValue = value;
        sonotaseisangk = Optional.fromNullable(toCurrencyType(sonotaseisangkType))
            .transform(bizCurrencyTransformer(getSonotaseisangkValue()))
            .orNull();
    }

    transient private String sonotaseisangkType = null;

    @Column(name=SONOTASEISANGK + "$", nullable=true)
    protected String getSonotaseisangkType() {
        if (sonotaseisangkType == null && sonotaseisangk != null) return sonotaseisangk.getType().toString();
        if (sonotaseisangkType == null && getSonotaseisangkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sonotaseisangk$' should not be NULL."));
        }
        return sonotaseisangkType;
    }

    protected void setSonotaseisangkType(String type) {
        sonotaseisangkType = type;
        sonotaseisangk = Optional.fromNullable(toCurrencyType(sonotaseisangkType))
            .transform(bizCurrencyTransformer(getSonotaseisangkValue()))
            .orNull();
    }

    private BizCurrency gstszeigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGstszeigk() {
        return gstszeigk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGstszeigk(BizCurrency pGstszeigk) {
        gstszeigk = pGstszeigk;
        gstszeigkValue = null;
        gstszeigkType  = null;
    }

    transient private BigDecimal gstszeigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GSTSZEIGK, nullable=true)
    protected BigDecimal getGstszeigkValue() {
        if (gstszeigkValue == null && gstszeigk != null) {
            if (gstszeigk.isOptional()) return null;
            return gstszeigk.absolute();
        }
        return gstszeigkValue;
    }

    protected void setGstszeigkValue(BigDecimal value) {
        gstszeigkValue = value;
        gstszeigk = Optional.fromNullable(toCurrencyType(gstszeigkType))
            .transform(bizCurrencyTransformer(getGstszeigkValue()))
            .orNull();
    }

    transient private String gstszeigkType = null;

    @Column(name=GSTSZEIGK + "$", nullable=true)
    protected String getGstszeigkType() {
        if (gstszeigkType == null && gstszeigk != null) return gstszeigk.getType().toString();
        if (gstszeigkType == null && getGstszeigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gstszeigk$' should not be NULL."));
        }
        return gstszeigkType;
    }

    protected void setGstszeigkType(String type) {
        gstszeigkType = type;
        gstszeigk = Optional.fromNullable(toCurrencyType(gstszeigkType))
            .transform(bizCurrencyTransformer(getGstszeigkValue()))
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

    private C_Tuukasyu shrtuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_KhShrRireki.SHRTUUKASYU)
    public C_Tuukasyu getShrtuukasyu() {
        return shrtuukasyu;
    }

    public void setShrtuukasyu(C_Tuukasyu pShrtuukasyu) {
        shrtuukasyu = pShrtuukasyu;
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

    private BizCurrency shrtuukasyushrgkkei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrtuukasyushrgkkei() {
        return shrtuukasyushrgkkei;
    }

    public void setShrtuukasyushrgkkei(BizCurrency pShrtuukasyushrgkkei) {
        shrtuukasyushrgkkei = pShrtuukasyushrgkkei;
        shrtuukasyushrgkkeiValue = null;
        shrtuukasyushrgkkeiType  = null;
    }

    transient private BigDecimal shrtuukasyushrgkkeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRTUUKASYUSHRGKKEI, nullable=true)
    protected BigDecimal getShrtuukasyushrgkkeiValue() {
        if (shrtuukasyushrgkkeiValue == null && shrtuukasyushrgkkei != null) {
            if (shrtuukasyushrgkkei.isOptional()) return null;
            return shrtuukasyushrgkkei.absolute();
        }
        return shrtuukasyushrgkkeiValue;
    }

    protected void setShrtuukasyushrgkkeiValue(BigDecimal value) {
        shrtuukasyushrgkkeiValue = value;
        shrtuukasyushrgkkei = Optional.fromNullable(toCurrencyType(shrtuukasyushrgkkeiType))
            .transform(bizCurrencyTransformer(getShrtuukasyushrgkkeiValue()))
            .orNull();
    }

    transient private String shrtuukasyushrgkkeiType = null;

    @Column(name=SHRTUUKASYUSHRGKKEI + "$", nullable=true)
    protected String getShrtuukasyushrgkkeiType() {
        if (shrtuukasyushrgkkeiType == null && shrtuukasyushrgkkei != null) return shrtuukasyushrgkkei.getType().toString();
        if (shrtuukasyushrgkkeiType == null && getShrtuukasyushrgkkeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrtuukasyushrgkkei$' should not be NULL."));
        }
        return shrtuukasyushrgkkeiType;
    }

    protected void setShrtuukasyushrgkkeiType(String type) {
        shrtuukasyushrgkkeiType = type;
        shrtuukasyushrgkkei = Optional.fromNullable(toCurrencyType(shrtuukasyushrgkkeiType))
            .transform(bizCurrencyTransformer(getShrtuukasyushrgkkeiValue()))
            .orNull();
    }

    private BizCurrency shrtuukahaitoukin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrtuukahaitoukin() {
        return shrtuukahaitoukin;
    }

    public void setShrtuukahaitoukin(BizCurrency pShrtuukahaitoukin) {
        shrtuukahaitoukin = pShrtuukahaitoukin;
        shrtuukahaitoukinValue = null;
        shrtuukahaitoukinType  = null;
    }

    transient private BigDecimal shrtuukahaitoukinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRTUUKAHAITOUKIN, nullable=true)
    protected BigDecimal getShrtuukahaitoukinValue() {
        if (shrtuukahaitoukinValue == null && shrtuukahaitoukin != null) {
            if (shrtuukahaitoukin.isOptional()) return null;
            return shrtuukahaitoukin.absolute();
        }
        return shrtuukahaitoukinValue;
    }

    protected void setShrtuukahaitoukinValue(BigDecimal value) {
        shrtuukahaitoukinValue = value;
        shrtuukahaitoukin = Optional.fromNullable(toCurrencyType(shrtuukahaitoukinType))
            .transform(bizCurrencyTransformer(getShrtuukahaitoukinValue()))
            .orNull();
    }

    transient private String shrtuukahaitoukinType = null;

    @Column(name=SHRTUUKAHAITOUKIN + "$", nullable=true)
    protected String getShrtuukahaitoukinType() {
        if (shrtuukahaitoukinType == null && shrtuukahaitoukin != null) return shrtuukahaitoukin.getType().toString();
        if (shrtuukahaitoukinType == null && getShrtuukahaitoukinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrtuukahaitoukin$' should not be NULL."));
        }
        return shrtuukahaitoukinType;
    }

    protected void setShrtuukahaitoukinType(String type) {
        shrtuukahaitoukinType = type;
        shrtuukahaitoukin = Optional.fromNullable(toCurrencyType(shrtuukahaitoukinType))
            .transform(bizCurrencyTransformer(getShrtuukahaitoukinValue()))
            .orNull();
    }

    private BizCurrency shrtuukasonotaseisangk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrtuukasonotaseisangk() {
        return shrtuukasonotaseisangk;
    }

    public void setShrtuukasonotaseisangk(BizCurrency pShrtuukasonotaseisangk) {
        shrtuukasonotaseisangk = pShrtuukasonotaseisangk;
        shrtuukasonotaseisangkValue = null;
        shrtuukasonotaseisangkType  = null;
    }

    transient private BigDecimal shrtuukasonotaseisangkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRTUUKASONOTASEISANGK, nullable=true)
    protected BigDecimal getShrtuukasonotaseisangkValue() {
        if (shrtuukasonotaseisangkValue == null && shrtuukasonotaseisangk != null) {
            if (shrtuukasonotaseisangk.isOptional()) return null;
            return shrtuukasonotaseisangk.absolute();
        }
        return shrtuukasonotaseisangkValue;
    }

    protected void setShrtuukasonotaseisangkValue(BigDecimal value) {
        shrtuukasonotaseisangkValue = value;
        shrtuukasonotaseisangk = Optional.fromNullable(toCurrencyType(shrtuukasonotaseisangkType))
            .transform(bizCurrencyTransformer(getShrtuukasonotaseisangkValue()))
            .orNull();
    }

    transient private String shrtuukasonotaseisangkType = null;

    @Column(name=SHRTUUKASONOTASEISANGK + "$", nullable=true)
    protected String getShrtuukasonotaseisangkType() {
        if (shrtuukasonotaseisangkType == null && shrtuukasonotaseisangk != null) return shrtuukasonotaseisangk.getType().toString();
        if (shrtuukasonotaseisangkType == null && getShrtuukasonotaseisangkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrtuukasonotaseisangk$' should not be NULL."));
        }
        return shrtuukasonotaseisangkType;
    }

    protected void setShrtuukasonotaseisangkType(String type) {
        shrtuukasonotaseisangkType = type;
        shrtuukasonotaseisangk = Optional.fromNullable(toCurrencyType(shrtuukasonotaseisangkType))
            .transform(bizCurrencyTransformer(getShrtuukasonotaseisangkValue()))
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

    private BizCurrency yensyushrgkkei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYensyushrgkkei() {
        return yensyushrgkkei;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYensyushrgkkei(BizCurrency pYensyushrgkkei) {
        yensyushrgkkei = pYensyushrgkkei;
        yensyushrgkkeiValue = null;
        yensyushrgkkeiType  = null;
    }

    transient private BigDecimal yensyushrgkkeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENSYUSHRGKKEI, nullable=true)
    protected BigDecimal getYensyushrgkkeiValue() {
        if (yensyushrgkkeiValue == null && yensyushrgkkei != null) {
            if (yensyushrgkkei.isOptional()) return null;
            return yensyushrgkkei.absolute();
        }
        return yensyushrgkkeiValue;
    }

    protected void setYensyushrgkkeiValue(BigDecimal value) {
        yensyushrgkkeiValue = value;
        yensyushrgkkei = Optional.fromNullable(toCurrencyType(yensyushrgkkeiType))
            .transform(bizCurrencyTransformer(getYensyushrgkkeiValue()))
            .orNull();
    }

    transient private String yensyushrgkkeiType = null;

    @Column(name=YENSYUSHRGKKEI + "$", nullable=true)
    protected String getYensyushrgkkeiType() {
        if (yensyushrgkkeiType == null && yensyushrgkkei != null) return yensyushrgkkei.getType().toString();
        if (yensyushrgkkeiType == null && getYensyushrgkkeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yensyushrgkkei$' should not be NULL."));
        }
        return yensyushrgkkeiType;
    }

    protected void setYensyushrgkkeiType(String type) {
        yensyushrgkkeiType = type;
        yensyushrgkkei = Optional.fromNullable(toCurrencyType(yensyushrgkkeiType))
            .transform(bizCurrencyTransformer(getYensyushrgkkeiValue()))
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

    private BizCurrency yenkansansonotaseisangk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkansansonotaseisangk() {
        return yenkansansonotaseisangk;
    }

    public void setYenkansansonotaseisangk(BizCurrency pYenkansansonotaseisangk) {
        yenkansansonotaseisangk = pYenkansansonotaseisangk;
        yenkansansonotaseisangkValue = null;
        yenkansansonotaseisangkType  = null;
    }

    transient private BigDecimal yenkansansonotaseisangkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKANSANSONOTASEISANGK, nullable=true)
    protected BigDecimal getYenkansansonotaseisangkValue() {
        if (yenkansansonotaseisangkValue == null && yenkansansonotaseisangk != null) {
            if (yenkansansonotaseisangk.isOptional()) return null;
            return yenkansansonotaseisangk.absolute();
        }
        return yenkansansonotaseisangkValue;
    }

    protected void setYenkansansonotaseisangkValue(BigDecimal value) {
        yenkansansonotaseisangkValue = value;
        yenkansansonotaseisangk = Optional.fromNullable(toCurrencyType(yenkansansonotaseisangkType))
            .transform(bizCurrencyTransformer(getYenkansansonotaseisangkValue()))
            .orNull();
    }

    transient private String yenkansansonotaseisangkType = null;

    @Column(name=YENKANSANSONOTASEISANGK + "$", nullable=true)
    protected String getYenkansansonotaseisangkType() {
        if (yenkansansonotaseisangkType == null && yenkansansonotaseisangk != null) return yenkansansonotaseisangk.getType().toString();
        if (yenkansansonotaseisangkType == null && getYenkansansonotaseisangkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkansansonotaseisangk$' should not be NULL."));
        }
        return yenkansansonotaseisangkType;
    }

    protected void setYenkansansonotaseisangkType(String type) {
        yenkansansonotaseisangkType = type;
        yenkansansonotaseisangk = Optional.fromNullable(toCurrencyType(yenkansansonotaseisangkType))
            .transform(bizCurrencyTransformer(getYenkansansonotaseisangkValue()))
            .orNull();
    }

    private BizCurrency yenmikeikap;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenmikeikap() {
        return yenmikeikap;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenmikeikap(BizCurrency pYenmikeikap) {
        yenmikeikap = pYenmikeikap;
        yenmikeikapValue = null;
        yenmikeikapType  = null;
    }

    transient private BigDecimal yenmikeikapValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENMIKEIKAP, nullable=true)
    protected BigDecimal getYenmikeikapValue() {
        if (yenmikeikapValue == null && yenmikeikap != null) {
            if (yenmikeikap.isOptional()) return null;
            return yenmikeikap.absolute();
        }
        return yenmikeikapValue;
    }

    protected void setYenmikeikapValue(BigDecimal value) {
        yenmikeikapValue = value;
        yenmikeikap = Optional.fromNullable(toCurrencyType(yenmikeikapType))
            .transform(bizCurrencyTransformer(getYenmikeikapValue()))
            .orNull();
    }

    transient private String yenmikeikapType = null;

    @Column(name=YENMIKEIKAP + "$", nullable=true)
    protected String getYenmikeikapType() {
        if (yenmikeikapType == null && yenmikeikap != null) return yenmikeikap.getType().toString();
        if (yenmikeikapType == null && getYenmikeikapValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenmikeikap$' should not be NULL."));
        }
        return yenmikeikapType;
    }

    protected void setYenmikeikapType(String type) {
        yenmikeikapType = type;
        yenmikeikap = Optional.fromNullable(toCurrencyType(yenmikeikapType))
            .transform(bizCurrencyTransformer(getYenmikeikapValue()))
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

    private String nztodouhukencd;

    @Column(name=GenIT_BAK_KhShrRireki.NZTODOUHUKENCD)
    public String getNztodouhukencd() {
        return nztodouhukencd;
    }

    public void setNztodouhukencd(String pNztodouhukencd) {
        nztodouhukencd = pNztodouhukencd;
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

    private BizCurrency htykeihi;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHtykeihi() {
        return htykeihi;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHtykeihi(BizCurrency pHtykeihi) {
        htykeihi = pHtykeihi;
        htykeihiValue = null;
        htykeihiType  = null;
    }

    transient private BigDecimal htykeihiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HTYKEIHI, nullable=true)
    protected BigDecimal getHtykeihiValue() {
        if (htykeihiValue == null && htykeihi != null) {
            if (htykeihi.isOptional()) return null;
            return htykeihi.absolute();
        }
        return htykeihiValue;
    }

    protected void setHtykeihiValue(BigDecimal value) {
        htykeihiValue = value;
        htykeihi = Optional.fromNullable(toCurrencyType(htykeihiType))
            .transform(bizCurrencyTransformer(getHtykeihiValue()))
            .orNull();
    }

    transient private String htykeihiType = null;

    @Column(name=HTYKEIHI + "$", nullable=true)
    protected String getHtykeihiType() {
        if (htykeihiType == null && htykeihi != null) return htykeihi.getType().toString();
        if (htykeihiType == null && getHtykeihiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'htykeihi$' should not be NULL."));
        }
        return htykeihiType;
    }

    protected void setHtykeihiType(String type) {
        htykeihiType = type;
        htykeihi = Optional.fromNullable(toCurrencyType(htykeihiType))
            .transform(bizCurrencyTransformer(getHtykeihiValue()))
            .orNull();
    }

    private BizCurrency kztgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKztgk() {
        return kztgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKztgk(BizCurrency pKztgk) {
        kztgk = pKztgk;
        kztgkValue = null;
        kztgkType  = null;
    }

    transient private BigDecimal kztgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KZTGK, nullable=true)
    protected BigDecimal getKztgkValue() {
        if (kztgkValue == null && kztgk != null) {
            if (kztgk.isOptional()) return null;
            return kztgk.absolute();
        }
        return kztgkValue;
    }

    protected void setKztgkValue(BigDecimal value) {
        kztgkValue = value;
        kztgk = Optional.fromNullable(toCurrencyType(kztgkType))
            .transform(bizCurrencyTransformer(getKztgkValue()))
            .orNull();
    }

    transient private String kztgkType = null;

    @Column(name=KZTGK + "$", nullable=true)
    protected String getKztgkType() {
        if (kztgkType == null && kztgk != null) return kztgk.getType().toString();
        if (kztgkType == null && getKztgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kztgk$' should not be NULL."));
        }
        return kztgkType;
    }

    protected void setKztgkType(String type) {
        kztgkType = type;
        kztgk = Optional.fromNullable(toCurrencyType(kztgkType))
            .transform(bizCurrencyTransformer(getKztgkValue()))
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

    private BizDate shrkwsratekjnymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KhShrRireki.SHRKWSRATEKJNYMD)
    public BizDate getShrkwsratekjnymd() {
        return shrkwsratekjnymd;
    }

    public void setShrkwsratekjnymd(BizDate pShrkwsratekjnymd) {
        shrkwsratekjnymd = pShrkwsratekjnymd;
    }

    private BizNumber shrkwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_KhShrRireki.SHRKWSRATE)
    public BizNumber getShrkwsrate() {
        return shrkwsrate;
    }

    public void setShrkwsrate(BizNumber pShrkwsrate) {
        shrkwsrate = pShrkwsrate;
    }

    private BizDate zeimukwsratekjnymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KhShrRireki.ZEIMUKWSRATEKJNYMD)
    public BizDate getZeimukwsratekjnymd() {
        return zeimukwsratekjnymd;
    }

    public void setZeimukwsratekjnymd(BizDate pZeimukwsratekjnymd) {
        zeimukwsratekjnymd = pZeimukwsratekjnymd;
    }

    private BizNumber zeimukwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_KhShrRireki.ZEIMUKWSRATE)
    public BizNumber getZeimukwsrate() {
        return zeimukwsrate;
    }

    public void setZeimukwsrate(BizNumber pZeimukwsrate) {
        zeimukwsrate = pZeimukwsrate;
    }

    private C_SoukinsakisiteiKbn soukinsakisiteikbn;

    @Type(type="UserType_C_SoukinsakisiteiKbn")
    @Column(name=GenIT_BAK_KhShrRireki.SOUKINSAKISITEIKBN)
    public C_SoukinsakisiteiKbn getSoukinsakisiteikbn() {
        return soukinsakisiteikbn;
    }

    public void setSoukinsakisiteikbn(C_SoukinsakisiteiKbn pSoukinsakisiteikbn) {
        soukinsakisiteikbn = pSoukinsakisiteikbn;
    }

    private String soukinsakinmkn;

    @Column(name=GenIT_BAK_KhShrRireki.SOUKINSAKINMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getSoukinsakinmkn() {
        return soukinsakinmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSoukinsakinmkn(String pSoukinsakinmkn) {
        soukinsakinmkn = pSoukinsakinmkn;
    }

    private String soukinsakinmkj;

    @Column(name=GenIT_BAK_KhShrRireki.SOUKINSAKINMKJ)
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

    @Column(name=GenIT_BAK_KhShrRireki.SOUKINSAKIYNO)
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

    @Column(name=GenIT_BAK_KhShrRireki.SOUKINSAKIADR1KJ)
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

    @Column(name=GenIT_BAK_KhShrRireki.SOUKINSAKIADR2KJ)
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

    @Column(name=GenIT_BAK_KhShrRireki.SOUKINSAKIADR3KJ)
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

    private String kyksyaszknmkn;

    @Column(name=GenIT_BAK_KhShrRireki.KYKSYASZKNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKyksyaszknmkn() {
        return kyksyaszknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyksyaszknmkn(String pKyksyaszknmkn) {
        kyksyaszknmkn = pKyksyaszknmkn;
    }

    private String kyksyaszknmkj;

    @Column(name=GenIT_BAK_KhShrRireki.KYKSYASZKNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getKyksyaszknmkj() {
        return kyksyaszknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyksyaszknmkj(String pKyksyaszknmkj) {
        kyksyaszknmkj = pKyksyaszknmkj;
    }

    private String kyksyaszkyno;

    @Column(name=GenIT_BAK_KhShrRireki.KYKSYASZKYNO)
    @Digit
    @Length(length=7)
    public String getKyksyaszkyno() {
        return kyksyaszkyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKyksyaszkyno(String pKyksyaszkyno) {
        kyksyaszkyno = pKyksyaszkyno;
    }

    private String kyksyaszkadr1kj;

    @Column(name=GenIT_BAK_KhShrRireki.KYKSYASZKADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getKyksyaszkadr1kj() {
        return kyksyaszkadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyksyaszkadr1kj(String pKyksyaszkadr1kj) {
        kyksyaszkadr1kj = pKyksyaszkadr1kj;
    }

    private String kyksyaszkadr2kj;

    @Column(name=GenIT_BAK_KhShrRireki.KYKSYASZKADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getKyksyaszkadr2kj() {
        return kyksyaszkadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyksyaszkadr2kj(String pKyksyaszkadr2kj) {
        kyksyaszkadr2kj = pKyksyaszkadr2kj;
    }

    private String kyksyaszkadr3kj;

    @Column(name=GenIT_BAK_KhShrRireki.KYKSYASZKADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getKyksyaszkadr3kj() {
        return kyksyaszkadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyksyaszkadr3kj(String pKyksyaszkadr3kj) {
        kyksyaszkadr3kj = pKyksyaszkadr3kj;
    }

    private String saikennmkj;

    @Column(name=GenIT_BAK_KhShrRireki.SAIKENNMKJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getSaikennmkj() {
        return saikennmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSaikennmkj(String pSaikennmkj) {
        saikennmkj = pSaikennmkj;
    }

    private String saikennyno;

    @Column(name=GenIT_BAK_KhShrRireki.SAIKENNYNO)
    @Length(length=7)
    @Digit
    public String getSaikennyno() {
        return saikennyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSaikennyno(String pSaikennyno) {
        saikennyno = pSaikennyno;
    }

    private String saikenadr1kj;

    @Column(name=GenIT_BAK_KhShrRireki.SAIKENADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getSaikenadr1kj() {
        return saikenadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSaikenadr1kj(String pSaikenadr1kj) {
        saikenadr1kj = pSaikenadr1kj;
    }

    private String saikenadr2kj;

    @Column(name=GenIT_BAK_KhShrRireki.SAIKENADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getSaikenadr2kj() {
        return saikenadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSaikenadr2kj(String pSaikenadr2kj) {
        saikenadr2kj = pSaikenadr2kj;
    }

    private String saikenadr3kj;

    @Column(name=GenIT_BAK_KhShrRireki.SAIKENADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getSaikenadr3kj() {
        return saikenadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSaikenadr3kj(String pSaikenadr3kj) {
        saikenadr3kj = pSaikenadr3kj;
    }

    private C_InputShrhousiteiKbn inputshrhousiteikbn;

    @Type(type="UserType_C_InputShrhousiteiKbn")
    @Column(name=GenIT_BAK_KhShrRireki.INPUTSHRHOUSITEIKBN)
    public C_InputShrhousiteiKbn getInputshrhousiteikbn() {
        return inputshrhousiteikbn;
    }

    public void setInputshrhousiteikbn(C_InputShrhousiteiKbn pInputshrhousiteikbn) {
        inputshrhousiteikbn = pInputshrhousiteikbn;
    }

    private C_ShrhousiteiKbn shrhousiteikbn;

    @Type(type="UserType_C_ShrhousiteiKbn")
    @Column(name=GenIT_BAK_KhShrRireki.SHRHOUSITEIKBN)
    public C_ShrhousiteiKbn getShrhousiteikbn() {
        return shrhousiteikbn;
    }

    public void setShrhousiteikbn(C_ShrhousiteiKbn pShrhousiteikbn) {
        shrhousiteikbn = pShrhousiteikbn;
    }

    private C_KouzasyuruiKbn kzsyuruikbn;

    @Type(type="UserType_C_KouzasyuruiKbn")
    @Column(name=GenIT_BAK_KhShrRireki.KZSYURUIKBN)
    public C_KouzasyuruiKbn getKzsyuruikbn() {
        return kzsyuruikbn;
    }

    public void setKzsyuruikbn(C_KouzasyuruiKbn pKzsyuruikbn) {
        kzsyuruikbn = pKzsyuruikbn;
    }

    private String bankcd;

    @Column(name=GenIT_BAK_KhShrRireki.BANKCD)
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

    @Column(name=GenIT_BAK_KhShrRireki.SITENCD)
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
    @Column(name=GenIT_BAK_KhShrRireki.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenIT_BAK_KhShrRireki.KOUZANO)
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
    @Column(name=GenIT_BAK_KhShrRireki.KZDOUKBN)
    public C_Kzdou getKzdoukbn() {
        return kzdoukbn;
    }

    public void setKzdoukbn(C_Kzdou pKzdoukbn) {
        kzdoukbn = pKzdoukbn;
    }

    private String kzmeiginmkn;

    @Column(name=GenIT_BAK_KhShrRireki.KZMEIGINMKN)
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

    private String kykmnmeigibangou;

    @Column(name=GenIT_BAK_KhShrRireki.KYKMNMEIGIBANGOU)
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

    @Column(name=GenIT_BAK_KhShrRireki.UKTMNMEIGIBANGOU)
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

    private C_HtsiryosyuKbn shrtysysyuruikbn;

    @Type(type="UserType_C_HtsiryosyuKbn")
    @Column(name=GenIT_BAK_KhShrRireki.SHRTYSYSYURUIKBN)
    public C_HtsiryosyuKbn getShrtysysyuruikbn() {
        return shrtysysyuruikbn;
    }

    public void setShrtysysyuruikbn(C_HtsiryosyuKbn pShrtysysyuruikbn) {
        shrtysysyuruikbn = pShrtysysyuruikbn;
    }

    private String denrenno;

    @Column(name=GenIT_BAK_KhShrRireki.DENRENNO)
    public String getDenrenno() {
        return denrenno;
    }

    public void setDenrenno(String pDenrenno) {
        denrenno = pDenrenno;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_KhShrRireki.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_KhShrRireki.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_KhShrRireki.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
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

    @Column(name=GenIT_BAK_KhShrRireki.KYKHNKKAISUU)
    public Integer getKykhnkkaisuu() {
        return kykhnkkaisuu;
    }

    public void setKykhnkkaisuu(Integer pKykhnkkaisuu) {
        kykhnkkaisuu = pKykhnkkaisuu;
    }

    private BizCurrency shrmikeikap;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrmikeikap() {
        return shrmikeikap;
    }

    public void setShrmikeikap(BizCurrency pShrmikeikap) {
        shrmikeikap = pShrmikeikap;
        shrmikeikapValue = null;
        shrmikeikapType  = null;
    }

    transient private BigDecimal shrmikeikapValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRMIKEIKAP, nullable=true)
    protected BigDecimal getShrmikeikapValue() {
        if (shrmikeikapValue == null && shrmikeikap != null) {
            if (shrmikeikap.isOptional()) return null;
            return shrmikeikap.absolute();
        }
        return shrmikeikapValue;
    }

    protected void setShrmikeikapValue(BigDecimal value) {
        shrmikeikapValue = value;
        shrmikeikap = Optional.fromNullable(toCurrencyType(shrmikeikapType))
            .transform(bizCurrencyTransformer(getShrmikeikapValue()))
            .orNull();
    }

    transient private String shrmikeikapType = null;

    @Column(name=SHRMIKEIKAP + "$", nullable=true)
    protected String getShrmikeikapType() {
        if (shrmikeikapType == null && shrmikeikap != null) return shrmikeikap.getType().toString();
        if (shrmikeikapType == null && getShrmikeikapValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrmikeikap$' should not be NULL."));
        }
        return shrmikeikapType;
    }

    protected void setShrmikeikapType(String type) {
        shrmikeikapType = type;
        shrmikeikap = Optional.fromNullable(toCurrencyType(shrmikeikapType))
            .transform(bizCurrencyTransformer(getShrmikeikapValue()))
            .orNull();
    }

    private BizCurrency zennomikeikap;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZennomikeikap() {
        return zennomikeikap;
    }

    public void setZennomikeikap(BizCurrency pZennomikeikap) {
        zennomikeikap = pZennomikeikap;
        zennomikeikapValue = null;
        zennomikeikapType  = null;
    }

    transient private BigDecimal zennomikeikapValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZENNOMIKEIKAP, nullable=true)
    protected BigDecimal getZennomikeikapValue() {
        if (zennomikeikapValue == null && zennomikeikap != null) {
            if (zennomikeikap.isOptional()) return null;
            return zennomikeikap.absolute();
        }
        return zennomikeikapValue;
    }

    protected void setZennomikeikapValue(BigDecimal value) {
        zennomikeikapValue = value;
        zennomikeikap = Optional.fromNullable(toCurrencyType(zennomikeikapType))
            .transform(bizCurrencyTransformer(getZennomikeikapValue()))
            .orNull();
    }

    transient private String zennomikeikapType = null;

    @Column(name=ZENNOMIKEIKAP + "$", nullable=true)
    protected String getZennomikeikapType() {
        if (zennomikeikapType == null && zennomikeikap != null) return zennomikeikap.getType().toString();
        if (zennomikeikapType == null && getZennomikeikapValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zennomikeikap$' should not be NULL."));
        }
        return zennomikeikapType;
    }

    protected void setZennomikeikapType(String type) {
        zennomikeikapType = type;
        zennomikeikap = Optional.fromNullable(toCurrencyType(zennomikeikapType))
            .transform(bizCurrencyTransformer(getZennomikeikapValue()))
            .orNull();
    }

    private BizCurrency shrzennomikeikap;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrzennomikeikap() {
        return shrzennomikeikap;
    }

    public void setShrzennomikeikap(BizCurrency pShrzennomikeikap) {
        shrzennomikeikap = pShrzennomikeikap;
        shrzennomikeikapValue = null;
        shrzennomikeikapType  = null;
    }

    transient private BigDecimal shrzennomikeikapValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRZENNOMIKEIKAP, nullable=true)
    protected BigDecimal getShrzennomikeikapValue() {
        if (shrzennomikeikapValue == null && shrzennomikeikap != null) {
            if (shrzennomikeikap.isOptional()) return null;
            return shrzennomikeikap.absolute();
        }
        return shrzennomikeikapValue;
    }

    protected void setShrzennomikeikapValue(BigDecimal value) {
        shrzennomikeikapValue = value;
        shrzennomikeikap = Optional.fromNullable(toCurrencyType(shrzennomikeikapType))
            .transform(bizCurrencyTransformer(getShrzennomikeikapValue()))
            .orNull();
    }

    transient private String shrzennomikeikapType = null;

    @Column(name=SHRZENNOMIKEIKAP + "$", nullable=true)
    protected String getShrzennomikeikapType() {
        if (shrzennomikeikapType == null && shrzennomikeikap != null) return shrzennomikeikap.getType().toString();
        if (shrzennomikeikapType == null && getShrzennomikeikapValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrzennomikeikap$' should not be NULL."));
        }
        return shrzennomikeikapType;
    }

    protected void setShrzennomikeikapType(String type) {
        shrzennomikeikapType = type;
        shrzennomikeikap = Optional.fromNullable(toCurrencyType(shrzennomikeikapType))
            .transform(bizCurrencyTransformer(getShrzennomikeikapValue()))
            .orNull();
    }

    private BizCurrency yenzennomikeikap;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenzennomikeikap() {
        return yenzennomikeikap;
    }

    public void setYenzennomikeikap(BizCurrency pYenzennomikeikap) {
        yenzennomikeikap = pYenzennomikeikap;
        yenzennomikeikapValue = null;
        yenzennomikeikapType  = null;
    }

    transient private BigDecimal yenzennomikeikapValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENZENNOMIKEIKAP, nullable=true)
    protected BigDecimal getYenzennomikeikapValue() {
        if (yenzennomikeikapValue == null && yenzennomikeikap != null) {
            if (yenzennomikeikap.isOptional()) return null;
            return yenzennomikeikap.absolute();
        }
        return yenzennomikeikapValue;
    }

    protected void setYenzennomikeikapValue(BigDecimal value) {
        yenzennomikeikapValue = value;
        yenzennomikeikap = Optional.fromNullable(toCurrencyType(yenzennomikeikapType))
            .transform(bizCurrencyTransformer(getYenzennomikeikapValue()))
            .orNull();
    }

    transient private String yenzennomikeikapType = null;

    @Column(name=YENZENNOMIKEIKAP + "$", nullable=true)
    protected String getYenzennomikeikapType() {
        if (yenzennomikeikapType == null && yenzennomikeikap != null) return yenzennomikeikap.getType().toString();
        if (yenzennomikeikapType == null && getYenzennomikeikapValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenzennomikeikap$' should not be NULL."));
        }
        return yenzennomikeikapType;
    }

    protected void setYenzennomikeikapType(String type) {
        yenzennomikeikapType = type;
        yenzennomikeikap = Optional.fromNullable(toCurrencyType(yenzennomikeikapType))
            .transform(bizCurrencyTransformer(getYenzennomikeikapValue()))
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

    private BizCurrency shrazukarikingk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrazukarikingk() {
        return shrazukarikingk;
    }

    public void setShrazukarikingk(BizCurrency pShrazukarikingk) {
        shrazukarikingk = pShrazukarikingk;
        shrazukarikingkValue = null;
        shrazukarikingkType  = null;
    }

    transient private BigDecimal shrazukarikingkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRAZUKARIKINGK, nullable=true)
    protected BigDecimal getShrazukarikingkValue() {
        if (shrazukarikingkValue == null && shrazukarikingk != null) {
            if (shrazukarikingk.isOptional()) return null;
            return shrazukarikingk.absolute();
        }
        return shrazukarikingkValue;
    }

    protected void setShrazukarikingkValue(BigDecimal value) {
        shrazukarikingkValue = value;
        shrazukarikingk = Optional.fromNullable(toCurrencyType(shrazukarikingkType))
            .transform(bizCurrencyTransformer(getShrazukarikingkValue()))
            .orNull();
    }

    transient private String shrazukarikingkType = null;

    @Column(name=SHRAZUKARIKINGK + "$", nullable=true)
    protected String getShrazukarikingkType() {
        if (shrazukarikingkType == null && shrazukarikingk != null) return shrazukarikingk.getType().toString();
        if (shrazukarikingkType == null && getShrazukarikingkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrazukarikingk$' should not be NULL."));
        }
        return shrazukarikingkType;
    }

    protected void setShrazukarikingkType(String type) {
        shrazukarikingkType = type;
        shrazukarikingk = Optional.fromNullable(toCurrencyType(shrazukarikingkType))
            .transform(bizCurrencyTransformer(getShrazukarikingkValue()))
            .orNull();
    }

    private BizCurrency yenazukarikingk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenazukarikingk() {
        return yenazukarikingk;
    }

    public void setYenazukarikingk(BizCurrency pYenazukarikingk) {
        yenazukarikingk = pYenazukarikingk;
        yenazukarikingkValue = null;
        yenazukarikingkType  = null;
    }

    transient private BigDecimal yenazukarikingkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENAZUKARIKINGK, nullable=true)
    protected BigDecimal getYenazukarikingkValue() {
        if (yenazukarikingkValue == null && yenazukarikingk != null) {
            if (yenazukarikingk.isOptional()) return null;
            return yenazukarikingk.absolute();
        }
        return yenazukarikingkValue;
    }

    protected void setYenazukarikingkValue(BigDecimal value) {
        yenazukarikingkValue = value;
        yenazukarikingk = Optional.fromNullable(toCurrencyType(yenazukarikingkType))
            .transform(bizCurrencyTransformer(getYenazukarikingkValue()))
            .orNull();
    }

    transient private String yenazukarikingkType = null;

    @Column(name=YENAZUKARIKINGK + "$", nullable=true)
    protected String getYenazukarikingkType() {
        if (yenazukarikingkType == null && yenazukarikingk != null) return yenazukarikingk.getType().toString();
        if (yenazukarikingkType == null && getYenazukarikingkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenazukarikingk$' should not be NULL."));
        }
        return yenazukarikingkType;
    }

    protected void setYenazukarikingkType(String type) {
        yenazukarikingkType = type;
        yenazukarikingk = Optional.fromNullable(toCurrencyType(yenazukarikingkType))
            .transform(bizCurrencyTransformer(getYenazukarikingkValue()))
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

    private BizCurrency shrtuukasonotahaitoukin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrtuukasonotahaitoukin() {
        return shrtuukasonotahaitoukin;
    }

    public void setShrtuukasonotahaitoukin(BizCurrency pShrtuukasonotahaitoukin) {
        shrtuukasonotahaitoukin = pShrtuukasonotahaitoukin;
        shrtuukasonotahaitoukinValue = null;
        shrtuukasonotahaitoukinType  = null;
    }

    transient private BigDecimal shrtuukasonotahaitoukinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRTUUKASONOTAHAITOUKIN, nullable=true)
    protected BigDecimal getShrtuukasonotahaitoukinValue() {
        if (shrtuukasonotahaitoukinValue == null && shrtuukasonotahaitoukin != null) {
            if (shrtuukasonotahaitoukin.isOptional()) return null;
            return shrtuukasonotahaitoukin.absolute();
        }
        return shrtuukasonotahaitoukinValue;
    }

    protected void setShrtuukasonotahaitoukinValue(BigDecimal value) {
        shrtuukasonotahaitoukinValue = value;
        shrtuukasonotahaitoukin = Optional.fromNullable(toCurrencyType(shrtuukasonotahaitoukinType))
            .transform(bizCurrencyTransformer(getShrtuukasonotahaitoukinValue()))
            .orNull();
    }

    transient private String shrtuukasonotahaitoukinType = null;

    @Column(name=SHRTUUKASONOTAHAITOUKIN + "$", nullable=true)
    protected String getShrtuukasonotahaitoukinType() {
        if (shrtuukasonotahaitoukinType == null && shrtuukasonotahaitoukin != null) return shrtuukasonotahaitoukin.getType().toString();
        if (shrtuukasonotahaitoukinType == null && getShrtuukasonotahaitoukinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrtuukasonotahaitoukin$' should not be NULL."));
        }
        return shrtuukasonotahaitoukinType;
    }

    protected void setShrtuukasonotahaitoukinType(String type) {
        shrtuukasonotahaitoukinType = type;
        shrtuukasonotahaitoukin = Optional.fromNullable(toCurrencyType(shrtuukasonotahaitoukinType))
            .transform(bizCurrencyTransformer(getShrtuukasonotahaitoukinValue()))
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

    private BizCurrency shrkrkgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrkrkgk() {
        return shrkrkgk;
    }

    public void setShrkrkgk(BizCurrency pShrkrkgk) {
        shrkrkgk = pShrkrkgk;
        shrkrkgkValue = null;
        shrkrkgkType  = null;
    }

    transient private BigDecimal shrkrkgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRKRKGK, nullable=true)
    protected BigDecimal getShrkrkgkValue() {
        if (shrkrkgkValue == null && shrkrkgk != null) {
            if (shrkrkgk.isOptional()) return null;
            return shrkrkgk.absolute();
        }
        return shrkrkgkValue;
    }

    protected void setShrkrkgkValue(BigDecimal value) {
        shrkrkgkValue = value;
        shrkrkgk = Optional.fromNullable(toCurrencyType(shrkrkgkType))
            .transform(bizCurrencyTransformer(getShrkrkgkValue()))
            .orNull();
    }

    transient private String shrkrkgkType = null;

    @Column(name=SHRKRKGK + "$", nullable=true)
    protected String getShrkrkgkType() {
        if (shrkrkgkType == null && shrkrkgk != null) return shrkrkgk.getType().toString();
        if (shrkrkgkType == null && getShrkrkgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrkrkgk$' should not be NULL."));
        }
        return shrkrkgkType;
    }

    protected void setShrkrkgkType(String type) {
        shrkrkgkType = type;
        shrkrkgk = Optional.fromNullable(toCurrencyType(shrkrkgkType))
            .transform(bizCurrencyTransformer(getShrkrkgkValue()))
            .orNull();
    }

    private BizCurrency yenkrkgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkrkgk() {
        return yenkrkgk;
    }

    public void setYenkrkgk(BizCurrency pYenkrkgk) {
        yenkrkgk = pYenkrkgk;
        yenkrkgkValue = null;
        yenkrkgkType  = null;
    }

    transient private BigDecimal yenkrkgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKRKGK, nullable=true)
    protected BigDecimal getYenkrkgkValue() {
        if (yenkrkgkValue == null && yenkrkgk != null) {
            if (yenkrkgk.isOptional()) return null;
            return yenkrkgk.absolute();
        }
        return yenkrkgkValue;
    }

    protected void setYenkrkgkValue(BigDecimal value) {
        yenkrkgkValue = value;
        yenkrkgk = Optional.fromNullable(toCurrencyType(yenkrkgkType))
            .transform(bizCurrencyTransformer(getYenkrkgkValue()))
            .orNull();
    }

    transient private String yenkrkgkType = null;

    @Column(name=YENKRKGK + "$", nullable=true)
    protected String getYenkrkgkType() {
        if (yenkrkgkType == null && yenkrkgk != null) return yenkrkgk.getType().toString();
        if (yenkrkgkType == null && getYenkrkgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkrkgk$' should not be NULL."));
        }
        return yenkrkgkType;
    }

    protected void setYenkrkgkType(String type) {
        yenkrkgkType = type;
        yenkrkgk = Optional.fromNullable(toCurrencyType(yenkrkgkType))
            .transform(bizCurrencyTransformer(getYenkrkgkValue()))
            .orNull();
    }

    private C_UmuKbn zeitekiazukarikinkjumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_BAK_KhShrRireki.ZEITEKIAZUKARIKINKJUMU)
    public C_UmuKbn getZeitekiazukarikinkjumu() {
        return zeitekiazukarikinkjumu;
    }

    public void setZeitekiazukarikinkjumu(C_UmuKbn pZeitekiazukarikinkjumu) {
        zeitekiazukarikinkjumu = pZeitekiazukarikinkjumu;
    }

    private BizDate gaikashrkwsratekjnymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_KhShrRireki.GAIKASHRKWSRATEKJNYMD)
    public BizDate getGaikashrkwsratekjnymd() {
        return gaikashrkwsratekjnymd;
    }

    public void setGaikashrkwsratekjnymd(BizDate pGaikashrkwsratekjnymd) {
        gaikashrkwsratekjnymd = pGaikashrkwsratekjnymd;
    }

    private BizNumber gaikashrkwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_KhShrRireki.GAIKASHRKWSRATE)
    public BizNumber getGaikashrkwsrate() {
        return gaikashrkwsrate;
    }

    public void setGaikashrkwsrate(BizNumber pGaikashrkwsrate) {
        gaikashrkwsrate = pGaikashrkwsrate;
    }

    private BizCurrency kaiyakuhrkngkkeisiteituuka;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaiyakuhrkngkkeisiteituuka() {
        return kaiyakuhrkngkkeisiteituuka;
    }

    public void setKaiyakuhrkngkkeisiteituuka(BizCurrency pKaiyakuhrkngkkeisiteituuka) {
        kaiyakuhrkngkkeisiteituuka = pKaiyakuhrkngkkeisiteituuka;
        kaiyakuhrkngkkeisiteituukaValue = null;
        kaiyakuhrkngkkeisiteituukaType  = null;
    }

    transient private BigDecimal kaiyakuhrkngkkeisiteituukaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIYAKUHRKNGKKEISITEITUUKA, nullable=true)
    protected BigDecimal getKaiyakuhrkngkkeisiteituukaValue() {
        if (kaiyakuhrkngkkeisiteituukaValue == null && kaiyakuhrkngkkeisiteituuka != null) {
            if (kaiyakuhrkngkkeisiteituuka.isOptional()) return null;
            return kaiyakuhrkngkkeisiteituuka.absolute();
        }
        return kaiyakuhrkngkkeisiteituukaValue;
    }

    protected void setKaiyakuhrkngkkeisiteituukaValue(BigDecimal value) {
        kaiyakuhrkngkkeisiteituukaValue = value;
        kaiyakuhrkngkkeisiteituuka = Optional.fromNullable(toCurrencyType(kaiyakuhrkngkkeisiteituukaType))
            .transform(bizCurrencyTransformer(getKaiyakuhrkngkkeisiteituukaValue()))
            .orNull();
    }

    transient private String kaiyakuhrkngkkeisiteituukaType = null;

    @Column(name=KAIYAKUHRKNGKKEISITEITUUKA + "$", nullable=true)
    protected String getKaiyakuhrkngkkeisiteituukaType() {
        if (kaiyakuhrkngkkeisiteituukaType == null && kaiyakuhrkngkkeisiteituuka != null) return kaiyakuhrkngkkeisiteituuka.getType().toString();
        if (kaiyakuhrkngkkeisiteituukaType == null && getKaiyakuhrkngkkeisiteituukaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaiyakuhrkngkkeisiteituuka$' should not be NULL."));
        }
        return kaiyakuhrkngkkeisiteituukaType;
    }

    protected void setKaiyakuhrkngkkeisiteituukaType(String type) {
        kaiyakuhrkngkkeisiteituukaType = type;
        kaiyakuhrkngkkeisiteituuka = Optional.fromNullable(toCurrencyType(kaiyakuhrkngkkeisiteituukaType))
            .transform(bizCurrencyTransformer(getKaiyakuhrkngkkeisiteituukaValue()))
            .orNull();
    }

    private BizCurrency shrtuukakaiyakuhrkngkkei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrtuukakaiyakuhrkngkkei() {
        return shrtuukakaiyakuhrkngkkei;
    }

    public void setShrtuukakaiyakuhrkngkkei(BizCurrency pShrtuukakaiyakuhrkngkkei) {
        shrtuukakaiyakuhrkngkkei = pShrtuukakaiyakuhrkngkkei;
        shrtuukakaiyakuhrkngkkeiValue = null;
        shrtuukakaiyakuhrkngkkeiType  = null;
    }

    transient private BigDecimal shrtuukakaiyakuhrkngkkeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRTUUKAKAIYAKUHRKNGKKEI, nullable=true)
    protected BigDecimal getShrtuukakaiyakuhrkngkkeiValue() {
        if (shrtuukakaiyakuhrkngkkeiValue == null && shrtuukakaiyakuhrkngkkei != null) {
            if (shrtuukakaiyakuhrkngkkei.isOptional()) return null;
            return shrtuukakaiyakuhrkngkkei.absolute();
        }
        return shrtuukakaiyakuhrkngkkeiValue;
    }

    protected void setShrtuukakaiyakuhrkngkkeiValue(BigDecimal value) {
        shrtuukakaiyakuhrkngkkeiValue = value;
        shrtuukakaiyakuhrkngkkei = Optional.fromNullable(toCurrencyType(shrtuukakaiyakuhrkngkkeiType))
            .transform(bizCurrencyTransformer(getShrtuukakaiyakuhrkngkkeiValue()))
            .orNull();
    }

    transient private String shrtuukakaiyakuhrkngkkeiType = null;

    @Column(name=SHRTUUKAKAIYAKUHRKNGKKEI + "$", nullable=true)
    protected String getShrtuukakaiyakuhrkngkkeiType() {
        if (shrtuukakaiyakuhrkngkkeiType == null && shrtuukakaiyakuhrkngkkei != null) return shrtuukakaiyakuhrkngkkei.getType().toString();
        if (shrtuukakaiyakuhrkngkkeiType == null && getShrtuukakaiyakuhrkngkkeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrtuukakaiyakuhrkngkkei$' should not be NULL."));
        }
        return shrtuukakaiyakuhrkngkkeiType;
    }

    protected void setShrtuukakaiyakuhrkngkkeiType(String type) {
        shrtuukakaiyakuhrkngkkeiType = type;
        shrtuukakaiyakuhrkngkkei = Optional.fromNullable(toCurrencyType(shrtuukakaiyakuhrkngkkeiType))
            .transform(bizCurrencyTransformer(getShrtuukakaiyakuhrkngkkeiValue()))
            .orNull();
    }

    private BizCurrency kaiyakuhrkngkkeiyen;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaiyakuhrkngkkeiyen() {
        return kaiyakuhrkngkkeiyen;
    }

    public void setKaiyakuhrkngkkeiyen(BizCurrency pKaiyakuhrkngkkeiyen) {
        kaiyakuhrkngkkeiyen = pKaiyakuhrkngkkeiyen;
        kaiyakuhrkngkkeiyenValue = null;
        kaiyakuhrkngkkeiyenType  = null;
    }

    transient private BigDecimal kaiyakuhrkngkkeiyenValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIYAKUHRKNGKKEIYEN, nullable=true)
    protected BigDecimal getKaiyakuhrkngkkeiyenValue() {
        if (kaiyakuhrkngkkeiyenValue == null && kaiyakuhrkngkkeiyen != null) {
            if (kaiyakuhrkngkkeiyen.isOptional()) return null;
            return kaiyakuhrkngkkeiyen.absolute();
        }
        return kaiyakuhrkngkkeiyenValue;
    }

    protected void setKaiyakuhrkngkkeiyenValue(BigDecimal value) {
        kaiyakuhrkngkkeiyenValue = value;
        kaiyakuhrkngkkeiyen = Optional.fromNullable(toCurrencyType(kaiyakuhrkngkkeiyenType))
            .transform(bizCurrencyTransformer(getKaiyakuhrkngkkeiyenValue()))
            .orNull();
    }

    transient private String kaiyakuhrkngkkeiyenType = null;

    @Column(name=KAIYAKUHRKNGKKEIYEN + "$", nullable=true)
    protected String getKaiyakuhrkngkkeiyenType() {
        if (kaiyakuhrkngkkeiyenType == null && kaiyakuhrkngkkeiyen != null) return kaiyakuhrkngkkeiyen.getType().toString();
        if (kaiyakuhrkngkkeiyenType == null && getKaiyakuhrkngkkeiyenValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaiyakuhrkngkkeiyen$' should not be NULL."));
        }
        return kaiyakuhrkngkkeiyenType;
    }

    protected void setKaiyakuhrkngkkeiyenType(String type) {
        kaiyakuhrkngkkeiyenType = type;
        kaiyakuhrkngkkeiyen = Optional.fromNullable(toCurrencyType(kaiyakuhrkngkkeiyenType))
            .transform(bizCurrencyTransformer(getKaiyakuhrkngkkeiyenValue()))
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

    private C_YouhiKbn shrtysykurikosiyouhi;

    @Type(type="UserType_C_YouhiKbn")
    @Column(name=GenIT_BAK_KhShrRireki.SHRTYSYKURIKOSIYOUHI)
    public C_YouhiKbn getShrtysykurikosiyouhi() {
        return shrtysykurikosiyouhi;
    }

    public void setShrtysykurikosiyouhi(C_YouhiKbn pShrtysykurikosiyouhi) {
        shrtysykurikosiyouhi = pShrtysykurikosiyouhi;
    }
}