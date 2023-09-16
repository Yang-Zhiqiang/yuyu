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
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_FirstGanSindanKyhKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KanryotuutioutKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_SbjiShrKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_SiHonninKakninKekkaKbn;
import yuyu.def.classification.C_SiharaiTuukaKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SindansyoRyouShrYouhiKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SkskknsyubetuKbn;
import yuyu.def.classification.C_SouhusakiKbn;
import yuyu.def.classification.C_SoukinsakiKbn;
import yuyu.def.classification.C_SyuhiYouhi;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKyksyaTdk;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.id.PKJT_Sk;
import yuyu.def.db.meta.GenQJT_Sk;
import yuyu.def.db.meta.QJT_Sk;
import yuyu.def.db.type.UserType_C_BlnktkumuKbn;
import yuyu.def.db.type.UserType_C_FirstGanSindanKyhKbn;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_InputShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_KanryotuutioutKbn;
import yuyu.def.db.type.UserType_C_Kzdou;
import yuyu.def.db.type.UserType_C_NaiteiKakuteiKbn;
import yuyu.def.db.type.UserType_C_SUketoriHouhouKbn;
import yuyu.def.db.type.UserType_C_SbjiShrKbn;
import yuyu.def.db.type.UserType_C_Seibetu;
import yuyu.def.db.type.UserType_C_SeikyuusyaKbn;
import yuyu.def.db.type.UserType_C_SiHonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_SiharaiTuukaKbn;
import yuyu.def.db.type.UserType_C_SiinKbn;
import yuyu.def.db.type.UserType_C_SindansyoRyouShrYouhiKbn;
import yuyu.def.db.type.UserType_C_SinsaGendoKknKbn;
import yuyu.def.db.type.UserType_C_SkskknsyubetuKbn;
import yuyu.def.db.type.UserType_C_SouhusakiKbn;
import yuyu.def.db.type.UserType_C_SoukinsakiKbn;
import yuyu.def.db.type.UserType_C_SyuhiYouhi;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_Tkhukaumu;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UktKyksyaTdk;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.def.db.type.UserType_C_YouhiKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 請求テーブル テーブルのマッピング情報クラスで、 {@link JT_Sk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_Sk}</td><td colspan="3">請求テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_Sk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_Sk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">{@link PKJT_Sk ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyoruiukeymd syoruiukeymd}</td><td>書類受付日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHubikanryouymd hubikanryouymd}</td><td>不備完了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSeikyuusyakbn seikyuusyakbn}</td><td>請求者区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SeikyuusyaKbn}</td></tr>
 *  <tr><td>{@link #getSyuhiyouhi syuhiyouhi}</td><td>守秘要否</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyuhiYouhi}</td></tr>
 *  <tr><td>{@link #getSeikyuusyanmkn seikyuusyanmkn}</td><td>請求者（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuusyanmkj seikyuusyanmkj}</td><td>請求者（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuusyaseiymd seikyuusyaseiymd}</td><td>請求者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSeikyuusyasei seikyuusyasei}</td><td>請求者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Seibetu}</td></tr>
 *  <tr><td>{@link #getSihonninkakninkbn sihonninkakninkbn}</td><td>保険金本人確認結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SiHonninKakninKekkaKbn}</td></tr>
 *  <tr><td>{@link #getSeikyuusyatdk seikyuusyatdk}</td><td>請求者続柄</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tdk}</td></tr>
 *  <tr><td>{@link #getSbjishrkbn sbjishrkbn}</td><td>死亡時支払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SbjiShrKbn}</td></tr>
 *  <tr><td>{@link #getUktkyksyatdk uktkyksyatdk}</td><td>受取人契約者続柄</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UktKyksyaTdk}</td></tr>
 *  <tr><td>{@link #getSouhusakikbn souhusakikbn}</td><td>送付先区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SouhusakiKbn}</td></tr>
 *  <tr><td>{@link #getTsinyno tsinyno}</td><td>通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr1kj tsinadr1kj}</td><td>通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr2kj tsinadr2kj}</td><td>通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr3kj tsinadr3kj}</td><td>通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsintelno tsintelno}</td><td>通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSaikennmkj saikennmkj}</td><td>債権者氏名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSaikennyno saikennyno}</td><td>債権者郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSaikenadr1kj saikenadr1kj}</td><td>債権者住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSaikenadr2kj saikenadr2kj}</td><td>債権者住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSaikenadr3kj saikenadr3kj}</td><td>債権者住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkskknnmkn skskknnmkn}</td><td>親権者後見人名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkskknnmkj skskknnmkj}</td><td>親権者後見人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkskknsyubetu skskknsyubetu}</td><td>親権者後見人種別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SkskknsyubetuKbn}</td></tr>
 *  <tr><td>{@link #getSoukinsakikbn soukinsakikbn}</td><td>送金先区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SoukinsakiKbn}</td></tr>
 *  <tr><td>{@link #getInputshrhousiteikbn inputshrhousiteikbn}</td><td>入力用支払方法指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_InputShrhousiteiKbn}</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzdoukbn kzdoukbn}</td><td>口座名義人同一区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kzdou}</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSuketorihouhoukbn suketorihouhoukbn}</td><td>保険金受取方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SUketoriHouhouKbn}</td></tr>
 *  <tr><td>{@link #getSiharaituukakbn siharaituukakbn}</td><td>支払通貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SiharaiTuukaKbn}</td></tr>
 *  <tr><td>{@link #getNstkhukaumukbn nstkhukaumukbn}</td><td>年金支払特約付加有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkhukaumu}</td></tr>
 *  <tr><td>{@link #getNkkknjyutougk nkkknjyutougk}</td><td>年金基金充当金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSateikaksaigaikanouseikbn sateikaksaigaikanouseikbn}</td><td>査定回送要否確認（災害可能性）区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSateikakmeigihnkkbn sateikakmeigihnkkbn}</td><td>査定回送要否確認（名義変更査定）区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YouhiKbn}</td></tr>
 *  <tr><td>{@link #getSateikakkaigaisbkbn sateikakkaigaisbkbn}</td><td>査定回送要否確認（海外死亡）区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSateikakhusyousikbn sateikakhusyousikbn}</td><td>査定回送要否確認（不詳の死）区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSateikakkaigaikbn sateikakkaigaikbn}</td><td>査定回送要否確認（海外）区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getShrdtlsyooutkbn shrdtlsyooutkbn}</td><td>支払明細書出力区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KanryotuutioutKbn}</td></tr>
 *  <tr><td>{@link #getHassoukbn hassoukbn}</td><td>発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassouKbn}</td></tr>
 *  <tr><td>{@link #getUktmnmeigibangou uktmnmeigibangou}</td><td>受取人ＭＮ名義番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykmnmeigibangou kykmnmeigibangou}</td><td>契約者ＭＮ名義番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiinkbn siinkbn}</td><td>死因区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SiinKbn}</td></tr>
 *  <tr><td>{@link #getMisyuupjyuutouym misyuupjyuutouym}</td><td>未収保険料充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getMisyuupjyuutoukaisuuy misyuupjyuutoukaisuuy}</td><td>未収保険料充当回数（年）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getMisyuupjyuutoukaisuum misyuupjyuutoukaisuum}</td><td>未収保険料充当回数（月）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSaigaimousideumukbn saigaimousideumukbn}</td><td>災害申出有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BlnktkumuKbn}</td></tr>
 *  <tr><td>{@link #getSindansyoryoushryouhikbn sindansyoryoushryouhikbn}</td><td>診断書料支払要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SindansyoRyouShrYouhiKbn}</td></tr>
 *  <tr><td>{@link #getSindansyomaisuu sindansyomaisuu}</td><td>診断書枚数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSinsagendokknkbn sinsagendokknkbn}</td><td>審査限度期間区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SinsaGendoKknKbn}</td></tr>
 *  <tr><td>{@link #getRikoukityuutuudannissuu rikoukityuutuudannissuu}</td><td>履行期中断日数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTienrisokukisanymd tienrisokukisanymd}</td><td>遅延利息起算日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTienrsknissuu tienrsknissuu}</td><td>遅延利息日数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getShrtuukasyu shrtuukasyu}</td><td>支払通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getShrkwsratekjnymd shrkwsratekjnymd}</td><td>支払時為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrkwsrate shrkwsrate}</td><td>支払時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZeimukwsratekjnymd zeimukwsratekjnymd}</td><td>税務用為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZeimukwsrate zeimukwsrate}</td><td>税務用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getGaikaknsnkwsratekjymd gaikaknsnkwsratekjymd}</td><td>外貨換算為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGaikaknsnkwsrate gaikaknsnkwsrate}</td><td>外貨換算為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getShrgk shrgk}</td><td>支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKyhkngkgoukei kyhkngkgoukei}</td><td>給付金額合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHokenkngkgoukei hokenkngkgoukei}</td><td>保険金額合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHaitoukin haitoukin}</td><td>配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSonotahaitoukin sonotahaitoukin}</td><td>その他配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMisyuup misyuup}</td><td>未収保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMikeikap mikeikap}</td><td>未経過保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZennouseisankgk zennouseisankgk}</td><td>前納精算金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getAzukarikingk azukarikingk}</td><td>預り金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSonotaseisangk sonotaseisangk}</td><td>その他精算額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKrkgk krkgk}</td><td>仮受金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrtienrsk shrtienrsk}</td><td>支払遅延利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenshrgk yenshrgk}</td><td>円換算支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkyhgkgoukei yenkyhgkgoukei}</td><td>円換算給付金額合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenhkgkgoukei yenhkgkgoukei}</td><td>円換算保険金額合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkahaitoukin yenkahaitoukin}</td><td>円貨配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkasonotahaitoukin yenkasonotahaitoukin}</td><td>円貨その他配当金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkamisyuup yenkamisyuup}</td><td>円貨未収保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkamikeikap yenkamikeikap}</td><td>円貨未経過保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkazennouseisankgk yenkazennouseisankgk}</td><td>円貨前納精算金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkaazukarikingk yenkaazukarikingk}</td><td>円貨預り金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkasonotaseisangk yenkasonotaseisangk}</td><td>円貨その他精算額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkakrkgk yenkakrkgk}</td><td>円貨仮受金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenshrtienrsk yenshrtienrsk}</td><td>円換算支払遅延利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZitkazukarikingksiteituuka zitkazukarikingksiteituuka}</td><td>税適預り金額（指定通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZitkazukarikingkyen zitkazukarikingkyen}</td><td>税適預り金額（円貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGaikaknsntkgk gaikaknsntkgk}</td><td>外貨換算対象金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGaikaknsnkekkakgk gaikaknsnkekkakgk}</td><td>外貨換算結果金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkaknsntkgk yenkaknsntkgk}</td><td>円貨換算対象金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkaknsnkekkakgk yenkaknsnkekkakgk}</td><td>円貨換算結果金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMisyuusyonendojikaiikoup misyuusyonendojikaiikoup}</td><td>未収初年度次回以降Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMisyuujinendoikoup misyuujinendoikoup}</td><td>未収次年度以降Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getPmkouryokuhasseiymd pmkouryokuhasseiymd}</td><td>Ｐ免効力発生日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMikeikapjyuutouym mikeikapjyuutouym}</td><td>未経過保険料充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getMikeikapjyuutoukaisuuy mikeikapjyuutoukaisuuy}</td><td>未経過保険料充当回数（年）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getMikeikapjyuutoukaisuum mikeikapjyuutoukaisuum}</td><td>未経過保険料充当回数（月）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTokusyushrkbn tokusyushrkbn}</td><td>特殊支払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getFirstgansindankyhkbn firstgansindankyhkbn}</td><td>初回がん診断給付区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_FirstGanSindanKyhKbn}</td></tr>
 *  <tr><td>{@link #getGoukeihituyoukeihi goukeihituyoukeihi}</td><td>合計必要経費</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKykhnkkaisuu kykhnkkaisuu}</td><td>契約者変更回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getShrkykhtykeihi shrkykhtykeihi}</td><td>支払時契約者必要経費</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKijitumitouraimikeikap kijitumitouraimikeikap}</td><td>期日未到来未経過保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKyhknshrtyousyomisyuup kyhknshrtyousyomisyuup}</td><td>給付金支払調書未収保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKyhknshrtyousyomikeikap kyhknshrtyousyomikeikap}</td><td>給付金支払調書未経過保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKyhknshrtysykjtmitrmikeikap kyhknshrtysykjtmitrmikeikap}</td><td>給付金支払調書期日未到来未経過保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getVhtnaiteikakuteikbn vhtnaiteikakuteikbn}</td><td>（配当金情報）内定確定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NaiteiKakuteiKbn}</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_Sk
 * @see     PKJT_Sk
 * @see     QJT_Sk
 * @see     GenQJT_Sk
 */
@MappedSuperclass
@Table(name=GenJT_Sk.TABLE_NAME)
@IdClass(value=PKJT_Sk.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_BlnktkumuKbn", typeClass=UserType_C_BlnktkumuKbn.class),
    @TypeDef(name="UserType_C_FirstGanSindanKyhKbn", typeClass=UserType_C_FirstGanSindanKyhKbn.class),
    @TypeDef(name="UserType_C_HassouKbn", typeClass=UserType_C_HassouKbn.class),
    @TypeDef(name="UserType_C_InputShrhousiteiKbn", typeClass=UserType_C_InputShrhousiteiKbn.class),
    @TypeDef(name="UserType_C_KanryotuutioutKbn", typeClass=UserType_C_KanryotuutioutKbn.class),
    @TypeDef(name="UserType_C_Kzdou", typeClass=UserType_C_Kzdou.class),
    @TypeDef(name="UserType_C_NaiteiKakuteiKbn", typeClass=UserType_C_NaiteiKakuteiKbn.class),
    @TypeDef(name="UserType_C_SUketoriHouhouKbn", typeClass=UserType_C_SUketoriHouhouKbn.class),
    @TypeDef(name="UserType_C_SbjiShrKbn", typeClass=UserType_C_SbjiShrKbn.class),
    @TypeDef(name="UserType_C_Seibetu", typeClass=UserType_C_Seibetu.class),
    @TypeDef(name="UserType_C_SeikyuusyaKbn", typeClass=UserType_C_SeikyuusyaKbn.class),
    @TypeDef(name="UserType_C_SiHonninKakninKekkaKbn", typeClass=UserType_C_SiHonninKakninKekkaKbn.class),
    @TypeDef(name="UserType_C_SiharaiTuukaKbn", typeClass=UserType_C_SiharaiTuukaKbn.class),
    @TypeDef(name="UserType_C_SiinKbn", typeClass=UserType_C_SiinKbn.class),
    @TypeDef(name="UserType_C_SindansyoRyouShrYouhiKbn", typeClass=UserType_C_SindansyoRyouShrYouhiKbn.class),
    @TypeDef(name="UserType_C_SinsaGendoKknKbn", typeClass=UserType_C_SinsaGendoKknKbn.class),
    @TypeDef(name="UserType_C_SkskknsyubetuKbn", typeClass=UserType_C_SkskknsyubetuKbn.class),
    @TypeDef(name="UserType_C_SouhusakiKbn", typeClass=UserType_C_SouhusakiKbn.class),
    @TypeDef(name="UserType_C_SoukinsakiKbn", typeClass=UserType_C_SoukinsakiKbn.class),
    @TypeDef(name="UserType_C_SyuhiYouhi", typeClass=UserType_C_SyuhiYouhi.class),
    @TypeDef(name="UserType_C_Tdk", typeClass=UserType_C_Tdk.class),
    @TypeDef(name="UserType_C_Tkhukaumu", typeClass=UserType_C_Tkhukaumu.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UktKyksyaTdk", typeClass=UserType_C_UktKyksyaTdk.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class),
    @TypeDef(name="UserType_C_YouhiKbn", typeClass=UserType_C_YouhiKbn.class)
})
public abstract class GenJT_Sk extends AbstractExDBEntity<JT_Sk, PKJT_Sk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_Sk";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String SEIKYUURIREKINO          = "seikyuurirekino";
    public static final String SYORUIUKEYMD             = "syoruiukeymd";
    public static final String HUBIKANRYOUYMD           = "hubikanryouymd";
    public static final String SEIKYUUSYAKBN            = "seikyuusyakbn";
    public static final String SYUHIYOUHI               = "syuhiyouhi";
    public static final String SEIKYUUSYANMKN           = "seikyuusyanmkn";
    public static final String SEIKYUUSYANMKJ           = "seikyuusyanmkj";
    public static final String SEIKYUUSYASEIYMD         = "seikyuusyaseiymd";
    public static final String SEIKYUUSYASEI            = "seikyuusyasei";
    public static final String SIHONNINKAKNINKBN        = "sihonninkakninkbn";
    public static final String SEIKYUUSYATDK            = "seikyuusyatdk";
    public static final String SBJISHRKBN               = "sbjishrkbn";
    public static final String UKTKYKSYATDK             = "uktkyksyatdk";
    public static final String SOUHUSAKIKBN             = "souhusakikbn";
    public static final String TSINYNO                  = "tsinyno";
    public static final String TSINADR1KJ               = "tsinadr1kj";
    public static final String TSINADR2KJ               = "tsinadr2kj";
    public static final String TSINADR3KJ               = "tsinadr3kj";
    public static final String TSINTELNO                = "tsintelno";
    public static final String SAIKENNMKJ               = "saikennmkj";
    public static final String SAIKENNYNO               = "saikennyno";
    public static final String SAIKENADR1KJ             = "saikenadr1kj";
    public static final String SAIKENADR2KJ             = "saikenadr2kj";
    public static final String SAIKENADR3KJ             = "saikenadr3kj";
    public static final String SKSKKNNMKN               = "skskknnmkn";
    public static final String SKSKKNNMKJ               = "skskknnmkj";
    public static final String SKSKKNSYUBETU            = "skskknsyubetu";
    public static final String SOUKINSAKIKBN            = "soukinsakikbn";
    public static final String INPUTSHRHOUSITEIKBN      = "inputshrhousiteikbn";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String KZDOUKBN                 = "kzdoukbn";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String SUKETORIHOUHOUKBN        = "suketorihouhoukbn";
    public static final String SIHARAITUUKAKBN          = "siharaituukakbn";
    public static final String NSTKHUKAUMUKBN           = "nstkhukaumukbn";
    public static final String NKKKNJYUTOUGK            = "nkkknjyutougk";
    public static final String SATEIKAKSAIGAIKANOUSEIKBN = "sateikaksaigaikanouseikbn";
    public static final String SATEIKAKMEIGIHNKKBN      = "sateikakmeigihnkkbn";
    public static final String SATEIKAKKAIGAISBKBN      = "sateikakkaigaisbkbn";
    public static final String SATEIKAKHUSYOUSIKBN      = "sateikakhusyousikbn";
    public static final String SATEIKAKKAIGAIKBN        = "sateikakkaigaikbn";
    public static final String SHRDTLSYOOUTKBN          = "shrdtlsyooutkbn";
    public static final String HASSOUKBN                = "hassoukbn";
    public static final String UKTMNMEIGIBANGOU         = "uktmnmeigibangou";
    public static final String KYKMNMEIGIBANGOU         = "kykmnmeigibangou";
    public static final String SIINKBN                  = "siinkbn";
    public static final String MISYUUPJYUUTOUYM         = "misyuupjyuutouym";
    public static final String MISYUUPJYUUTOUKAISUUY    = "misyuupjyuutoukaisuuy";
    public static final String MISYUUPJYUUTOUKAISUUM    = "misyuupjyuutoukaisuum";
    public static final String SAIGAIMOUSIDEUMUKBN      = "saigaimousideumukbn";
    public static final String SINDANSYORYOUSHRYOUHIKBN = "sindansyoryoushryouhikbn";
    public static final String SINDANSYOMAISUU          = "sindansyomaisuu";
    public static final String SINSAGENDOKKNKBN         = "sinsagendokknkbn";
    public static final String RIKOUKITYUUTUUDANNISSUU  = "rikoukityuutuudannissuu";
    public static final String TIENRISOKUKISANYMD       = "tienrisokukisanymd";
    public static final String TIENRSKNISSUU            = "tienrsknissuu";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String SHRTUUKASYU              = "shrtuukasyu";
    public static final String SHRKWSRATEKJNYMD         = "shrkwsratekjnymd";
    public static final String SHRKWSRATE               = "shrkwsrate";
    public static final String ZEIMUKWSRATEKJNYMD       = "zeimukwsratekjnymd";
    public static final String ZEIMUKWSRATE             = "zeimukwsrate";
    public static final String GAIKAKNSNKWSRATEKJYMD    = "gaikaknsnkwsratekjymd";
    public static final String GAIKAKNSNKWSRATE         = "gaikaknsnkwsrate";
    public static final String SHRGK                    = "shrgk";
    public static final String KYHKNGKGOUKEI            = "kyhkngkgoukei";
    public static final String HOKENKNGKGOUKEI          = "hokenkngkgoukei";
    public static final String HAITOUKIN                = "haitoukin";
    public static final String SONOTAHAITOUKIN          = "sonotahaitoukin";
    public static final String MISYUUP                  = "misyuup";
    public static final String MIKEIKAP                 = "mikeikap";
    public static final String ZENNOUSEISANKGK          = "zennouseisankgk";
    public static final String AZUKARIKINGK             = "azukarikingk";
    public static final String SONOTASEISANGK           = "sonotaseisangk";
    public static final String KRKGK                    = "krkgk";
    public static final String SHRTIENRSK               = "shrtienrsk";
    public static final String YENSHRGK                 = "yenshrgk";
    public static final String YENKYHGKGOUKEI           = "yenkyhgkgoukei";
    public static final String YENHKGKGOUKEI            = "yenhkgkgoukei";
    public static final String YENKAHAITOUKIN           = "yenkahaitoukin";
    public static final String YENKASONOTAHAITOUKIN     = "yenkasonotahaitoukin";
    public static final String YENKAMISYUUP             = "yenkamisyuup";
    public static final String YENKAMIKEIKAP            = "yenkamikeikap";
    public static final String YENKAZENNOUSEISANKGK     = "yenkazennouseisankgk";
    public static final String YENKAAZUKARIKINGK        = "yenkaazukarikingk";
    public static final String YENKASONOTASEISANGK      = "yenkasonotaseisangk";
    public static final String YENKAKRKGK               = "yenkakrkgk";
    public static final String YENSHRTIENRSK            = "yenshrtienrsk";
    public static final String ZITKAZUKARIKINGKSITEITUUKA = "zitkazukarikingksiteituuka";
    public static final String ZITKAZUKARIKINGKYEN      = "zitkazukarikingkyen";
    public static final String GAIKAKNSNTKGK            = "gaikaknsntkgk";
    public static final String GAIKAKNSNKEKKAKGK        = "gaikaknsnkekkakgk";
    public static final String YENKAKNSNTKGK            = "yenkaknsntkgk";
    public static final String YENKAKNSNKEKKAKGK        = "yenkaknsnkekkakgk";
    public static final String MISYUUSYONENDOJIKAIIKOUP = "misyuusyonendojikaiikoup";
    public static final String MISYUUJINENDOIKOUP       = "misyuujinendoikoup";
    public static final String PMKOURYOKUHASSEIYMD      = "pmkouryokuhasseiymd";
    public static final String MIKEIKAPJYUUTOUYM        = "mikeikapjyuutouym";
    public static final String MIKEIKAPJYUUTOUKAISUUY   = "mikeikapjyuutoukaisuuy";
    public static final String MIKEIKAPJYUUTOUKAISUUM   = "mikeikapjyuutoukaisuum";
    public static final String TOKUSYUSHRKBN            = "tokusyushrkbn";
    public static final String FIRSTGANSINDANKYHKBN     = "firstgansindankyhkbn";
    public static final String GOUKEIHITUYOUKEIHI       = "goukeihituyoukeihi";
    public static final String KYKHNKKAISUU             = "kykhnkkaisuu";
    public static final String SHRKYKHTYKEIHI           = "shrkykhtykeihi";
    public static final String KIJITUMITOURAIMIKEIKAP   = "kijitumitouraimikeikap";
    public static final String KYHKNSHRTYOUSYOMISYUUP   = "kyhknshrtyousyomisyuup";
    public static final String KYHKNSHRTYOUSYOMIKEIKAP  = "kyhknshrtyousyomikeikap";
    public static final String KYHKNSHRTYSYKJTMITRMIKEIKAP = "kyhknshrtysykjtmitrmikeikap";
    public static final String VHTNAITEIKAKUTEIKBN      = "vhtnaiteikakuteikbn";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_Sk primaryKey;

    public GenJT_Sk() {
        primaryKey = new PKJT_Sk();
    }

    public GenJT_Sk(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino
    ) {
        primaryKey = new PKJT_Sk(
            pSkno,
            pSyono,
            pSeikyuurirekino
        );
    }

    @Transient
    @Override
    public PKJT_Sk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_Sk> getMetaClass() {
        return QJT_Sk.class;
    }

    @Id
    @Column(name=GenJT_Sk.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_Sk.SYONO)
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
    @Column(name=GenJT_Sk.SEIKYUURIREKINO)
    public Integer getSeikyuurirekino() {
        return getPrimaryKey().getSeikyuurirekino();
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        getPrimaryKey().setSeikyuurirekino(pSeikyuurirekino);
    }

    private BizDate syoruiukeymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_Sk.SYORUIUKEYMD)
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
    @Column(name=GenJT_Sk.HUBIKANRYOUYMD)
    @ValidDate
    public BizDate getHubikanryouymd() {
        return hubikanryouymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHubikanryouymd(BizDate pHubikanryouymd) {
        hubikanryouymd = pHubikanryouymd;
    }

    private C_SeikyuusyaKbn seikyuusyakbn;

    @Type(type="UserType_C_SeikyuusyaKbn")
    @Column(name=GenJT_Sk.SEIKYUUSYAKBN)
    public C_SeikyuusyaKbn getSeikyuusyakbn() {
        return seikyuusyakbn;
    }

    public void setSeikyuusyakbn(C_SeikyuusyaKbn pSeikyuusyakbn) {
        seikyuusyakbn = pSeikyuusyakbn;
    }

    private C_SyuhiYouhi syuhiyouhi;

    @Type(type="UserType_C_SyuhiYouhi")
    @Column(name=GenJT_Sk.SYUHIYOUHI)
    public C_SyuhiYouhi getSyuhiyouhi() {
        return syuhiyouhi;
    }

    public void setSyuhiyouhi(C_SyuhiYouhi pSyuhiyouhi) {
        syuhiyouhi = pSyuhiyouhi;
    }

    private String seikyuusyanmkn;

    @Column(name=GenJT_Sk.SEIKYUUSYANMKN)
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

    @Column(name=GenJT_Sk.SEIKYUUSYANMKJ)
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

    private BizDate seikyuusyaseiymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_Sk.SEIKYUUSYASEIYMD)
    @ValidDate
    public BizDate getSeikyuusyaseiymd() {
        return seikyuusyaseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSeikyuusyaseiymd(BizDate pSeikyuusyaseiymd) {
        seikyuusyaseiymd = pSeikyuusyaseiymd;
    }

    private C_Seibetu seikyuusyasei;

    @Type(type="UserType_C_Seibetu")
    @Column(name=GenJT_Sk.SEIKYUUSYASEI)
    public C_Seibetu getSeikyuusyasei() {
        return seikyuusyasei;
    }

    public void setSeikyuusyasei(C_Seibetu pSeikyuusyasei) {
        seikyuusyasei = pSeikyuusyasei;
    }

    private C_SiHonninKakninKekkaKbn sihonninkakninkbn;

    @Type(type="UserType_C_SiHonninKakninKekkaKbn")
    @Column(name=GenJT_Sk.SIHONNINKAKNINKBN)
    public C_SiHonninKakninKekkaKbn getSihonninkakninkbn() {
        return sihonninkakninkbn;
    }

    public void setSihonninkakninkbn(C_SiHonninKakninKekkaKbn pSihonninkakninkbn) {
        sihonninkakninkbn = pSihonninkakninkbn;
    }

    private C_Tdk seikyuusyatdk;

    @Type(type="UserType_C_Tdk")
    @Column(name=GenJT_Sk.SEIKYUUSYATDK)
    public C_Tdk getSeikyuusyatdk() {
        return seikyuusyatdk;
    }

    public void setSeikyuusyatdk(C_Tdk pSeikyuusyatdk) {
        seikyuusyatdk = pSeikyuusyatdk;
    }

    private C_SbjiShrKbn sbjishrkbn;

    @Type(type="UserType_C_SbjiShrKbn")
    @Column(name=GenJT_Sk.SBJISHRKBN)
    public C_SbjiShrKbn getSbjishrkbn() {
        return sbjishrkbn;
    }

    public void setSbjishrkbn(C_SbjiShrKbn pSbjishrkbn) {
        sbjishrkbn = pSbjishrkbn;
    }

    private C_UktKyksyaTdk uktkyksyatdk;

    @Type(type="UserType_C_UktKyksyaTdk")
    @Column(name=GenJT_Sk.UKTKYKSYATDK)
    public C_UktKyksyaTdk getUktkyksyatdk() {
        return uktkyksyatdk;
    }

    public void setUktkyksyatdk(C_UktKyksyaTdk pUktkyksyatdk) {
        uktkyksyatdk = pUktkyksyatdk;
    }

    private C_SouhusakiKbn souhusakikbn;

    @Type(type="UserType_C_SouhusakiKbn")
    @Column(name=GenJT_Sk.SOUHUSAKIKBN)
    public C_SouhusakiKbn getSouhusakikbn() {
        return souhusakikbn;
    }

    public void setSouhusakikbn(C_SouhusakiKbn pSouhusakikbn) {
        souhusakikbn = pSouhusakikbn;
    }

    private String tsinyno;

    @Column(name=GenJT_Sk.TSINYNO)
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

    @Column(name=GenJT_Sk.TSINADR1KJ)
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

    @Column(name=GenJT_Sk.TSINADR2KJ)
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

    @Column(name=GenJT_Sk.TSINADR3KJ)
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

    private String tsintelno;

    @Column(name=GenJT_Sk.TSINTELNO)
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

    private String saikennmkj;

    @Column(name=GenJT_Sk.SAIKENNMKJ)
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

    @Column(name=GenJT_Sk.SAIKENNYNO)
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

    @Column(name=GenJT_Sk.SAIKENADR1KJ)
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

    @Column(name=GenJT_Sk.SAIKENADR2KJ)
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

    @Column(name=GenJT_Sk.SAIKENADR3KJ)
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

    private String skskknnmkn;

    @Column(name=GenJT_Sk.SKSKKNNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getSkskknnmkn() {
        return skskknnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSkskknnmkn(String pSkskknnmkn) {
        skskknnmkn = pSkskknnmkn;
    }

    private String skskknnmkj;

    @Column(name=GenJT_Sk.SKSKKNNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getSkskknnmkj() {
        return skskknnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSkskknnmkj(String pSkskknnmkj) {
        skskknnmkj = pSkskknnmkj;
    }

    private C_SkskknsyubetuKbn skskknsyubetu;

    @Type(type="UserType_C_SkskknsyubetuKbn")
    @Column(name=GenJT_Sk.SKSKKNSYUBETU)
    public C_SkskknsyubetuKbn getSkskknsyubetu() {
        return skskknsyubetu;
    }

    public void setSkskknsyubetu(C_SkskknsyubetuKbn pSkskknsyubetu) {
        skskknsyubetu = pSkskknsyubetu;
    }

    private C_SoukinsakiKbn soukinsakikbn;

    @Type(type="UserType_C_SoukinsakiKbn")
    @Column(name=GenJT_Sk.SOUKINSAKIKBN)
    public C_SoukinsakiKbn getSoukinsakikbn() {
        return soukinsakikbn;
    }

    public void setSoukinsakikbn(C_SoukinsakiKbn pSoukinsakikbn) {
        soukinsakikbn = pSoukinsakikbn;
    }

    private C_InputShrhousiteiKbn inputshrhousiteikbn;

    @Type(type="UserType_C_InputShrhousiteiKbn")
    @Column(name=GenJT_Sk.INPUTSHRHOUSITEIKBN)
    public C_InputShrhousiteiKbn getInputshrhousiteikbn() {
        return inputshrhousiteikbn;
    }

    public void setInputshrhousiteikbn(C_InputShrhousiteiKbn pInputshrhousiteikbn) {
        inputshrhousiteikbn = pInputshrhousiteikbn;
    }

    private String bankcd;

    @Column(name=GenJT_Sk.BANKCD)
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

    @Column(name=GenJT_Sk.SITENCD)
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
    @Column(name=GenJT_Sk.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenJT_Sk.KOUZANO)
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
    @Column(name=GenJT_Sk.KZDOUKBN)
    public C_Kzdou getKzdoukbn() {
        return kzdoukbn;
    }

    public void setKzdoukbn(C_Kzdou pKzdoukbn) {
        kzdoukbn = pKzdoukbn;
    }

    private String kzmeiginmkn;

    @Column(name=GenJT_Sk.KZMEIGINMKN)
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

    private C_SUketoriHouhouKbn suketorihouhoukbn;

    @Type(type="UserType_C_SUketoriHouhouKbn")
    @Column(name=GenJT_Sk.SUKETORIHOUHOUKBN)
    public C_SUketoriHouhouKbn getSuketorihouhoukbn() {
        return suketorihouhoukbn;
    }

    public void setSuketorihouhoukbn(C_SUketoriHouhouKbn pSuketorihouhoukbn) {
        suketorihouhoukbn = pSuketorihouhoukbn;
    }

    private C_SiharaiTuukaKbn siharaituukakbn;

    @Type(type="UserType_C_SiharaiTuukaKbn")
    @Column(name=GenJT_Sk.SIHARAITUUKAKBN)
    public C_SiharaiTuukaKbn getSiharaituukakbn() {
        return siharaituukakbn;
    }

    public void setSiharaituukakbn(C_SiharaiTuukaKbn pSiharaituukakbn) {
        siharaituukakbn = pSiharaituukakbn;
    }

    private C_Tkhukaumu nstkhukaumukbn;

    @Type(type="UserType_C_Tkhukaumu")
    @Column(name=GenJT_Sk.NSTKHUKAUMUKBN)
    public C_Tkhukaumu getNstkhukaumukbn() {
        return nstkhukaumukbn;
    }

    public void setNstkhukaumukbn(C_Tkhukaumu pNstkhukaumukbn) {
        nstkhukaumukbn = pNstkhukaumukbn;
    }

    private BizCurrency nkkknjyutougk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNkkknjyutougk() {
        return nkkknjyutougk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNkkknjyutougk(BizCurrency pNkkknjyutougk) {
        nkkknjyutougk = pNkkknjyutougk;
        nkkknjyutougkValue = null;
        nkkknjyutougkType  = null;
    }

    transient private BigDecimal nkkknjyutougkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NKKKNJYUTOUGK, nullable=true)
    protected BigDecimal getNkkknjyutougkValue() {
        if (nkkknjyutougkValue == null && nkkknjyutougk != null) {
            if (nkkknjyutougk.isOptional()) return null;
            return nkkknjyutougk.absolute();
        }
        return nkkknjyutougkValue;
    }

    protected void setNkkknjyutougkValue(BigDecimal value) {
        nkkknjyutougkValue = value;
        nkkknjyutougk = Optional.fromNullable(toCurrencyType(nkkknjyutougkType))
            .transform(bizCurrencyTransformer(getNkkknjyutougkValue()))
            .orNull();
    }

    transient private String nkkknjyutougkType = null;

    @Column(name=NKKKNJYUTOUGK + "$", nullable=true)
    protected String getNkkknjyutougkType() {
        if (nkkknjyutougkType == null && nkkknjyutougk != null) return nkkknjyutougk.getType().toString();
        if (nkkknjyutougkType == null && getNkkknjyutougkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'nkkknjyutougk$' should not be NULL."));
        }
        return nkkknjyutougkType;
    }

    protected void setNkkknjyutougkType(String type) {
        nkkknjyutougkType = type;
        nkkknjyutougk = Optional.fromNullable(toCurrencyType(nkkknjyutougkType))
            .transform(bizCurrencyTransformer(getNkkknjyutougkValue()))
            .orNull();
    }

    private C_UmuKbn sateikaksaigaikanouseikbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_Sk.SATEIKAKSAIGAIKANOUSEIKBN)
    public C_UmuKbn getSateikaksaigaikanouseikbn() {
        return sateikaksaigaikanouseikbn;
    }

    public void setSateikaksaigaikanouseikbn(C_UmuKbn pSateikaksaigaikanouseikbn) {
        sateikaksaigaikanouseikbn = pSateikaksaigaikanouseikbn;
    }

    private C_YouhiKbn sateikakmeigihnkkbn;

    @Type(type="UserType_C_YouhiKbn")
    @Column(name=GenJT_Sk.SATEIKAKMEIGIHNKKBN)
    public C_YouhiKbn getSateikakmeigihnkkbn() {
        return sateikakmeigihnkkbn;
    }

    public void setSateikakmeigihnkkbn(C_YouhiKbn pSateikakmeigihnkkbn) {
        sateikakmeigihnkkbn = pSateikakmeigihnkkbn;
    }

    private C_UmuKbn sateikakkaigaisbkbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_Sk.SATEIKAKKAIGAISBKBN)
    public C_UmuKbn getSateikakkaigaisbkbn() {
        return sateikakkaigaisbkbn;
    }

    public void setSateikakkaigaisbkbn(C_UmuKbn pSateikakkaigaisbkbn) {
        sateikakkaigaisbkbn = pSateikakkaigaisbkbn;
    }

    private C_UmuKbn sateikakhusyousikbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_Sk.SATEIKAKHUSYOUSIKBN)
    public C_UmuKbn getSateikakhusyousikbn() {
        return sateikakhusyousikbn;
    }

    public void setSateikakhusyousikbn(C_UmuKbn pSateikakhusyousikbn) {
        sateikakhusyousikbn = pSateikakhusyousikbn;
    }

    private C_UmuKbn sateikakkaigaikbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_Sk.SATEIKAKKAIGAIKBN)
    public C_UmuKbn getSateikakkaigaikbn() {
        return sateikakkaigaikbn;
    }

    public void setSateikakkaigaikbn(C_UmuKbn pSateikakkaigaikbn) {
        sateikakkaigaikbn = pSateikakkaigaikbn;
    }

    private C_KanryotuutioutKbn shrdtlsyooutkbn;

    @Type(type="UserType_C_KanryotuutioutKbn")
    @Column(name=GenJT_Sk.SHRDTLSYOOUTKBN)
    public C_KanryotuutioutKbn getShrdtlsyooutkbn() {
        return shrdtlsyooutkbn;
    }

    public void setShrdtlsyooutkbn(C_KanryotuutioutKbn pShrdtlsyooutkbn) {
        shrdtlsyooutkbn = pShrdtlsyooutkbn;
    }

    private C_HassouKbn hassoukbn;

    @Type(type="UserType_C_HassouKbn")
    @Column(name=GenJT_Sk.HASSOUKBN)
    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    private String uktmnmeigibangou;

    @Column(name=GenJT_Sk.UKTMNMEIGIBANGOU)
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

    private String kykmnmeigibangou;

    @Column(name=GenJT_Sk.KYKMNMEIGIBANGOU)
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

    private C_SiinKbn siinkbn;

    @Type(type="UserType_C_SiinKbn")
    @Column(name=GenJT_Sk.SIINKBN)
    public C_SiinKbn getSiinkbn() {
        return siinkbn;
    }

    public void setSiinkbn(C_SiinKbn pSiinkbn) {
        siinkbn = pSiinkbn;
    }

    private BizDateYM misyuupjyuutouym;

    @Type(type="BizDateYMType")
    @Column(name=GenJT_Sk.MISYUUPJYUUTOUYM)
    public BizDateYM getMisyuupjyuutouym() {
        return misyuupjyuutouym;
    }

    public void setMisyuupjyuutouym(BizDateYM pMisyuupjyuutouym) {
        misyuupjyuutouym = pMisyuupjyuutouym;
    }

    private Integer misyuupjyuutoukaisuuy;

    @Column(name=GenJT_Sk.MISYUUPJYUUTOUKAISUUY)
    public Integer getMisyuupjyuutoukaisuuy() {
        return misyuupjyuutoukaisuuy;
    }

    public void setMisyuupjyuutoukaisuuy(Integer pMisyuupjyuutoukaisuuy) {
        misyuupjyuutoukaisuuy = pMisyuupjyuutoukaisuuy;
    }

    private Integer misyuupjyuutoukaisuum;

    @Column(name=GenJT_Sk.MISYUUPJYUUTOUKAISUUM)
    public Integer getMisyuupjyuutoukaisuum() {
        return misyuupjyuutoukaisuum;
    }

    public void setMisyuupjyuutoukaisuum(Integer pMisyuupjyuutoukaisuum) {
        misyuupjyuutoukaisuum = pMisyuupjyuutoukaisuum;
    }

    private C_BlnktkumuKbn saigaimousideumukbn;

    @Type(type="UserType_C_BlnktkumuKbn")
    @Column(name=GenJT_Sk.SAIGAIMOUSIDEUMUKBN)
    public C_BlnktkumuKbn getSaigaimousideumukbn() {
        return saigaimousideumukbn;
    }

    public void setSaigaimousideumukbn(C_BlnktkumuKbn pSaigaimousideumukbn) {
        saigaimousideumukbn = pSaigaimousideumukbn;
    }

    private C_SindansyoRyouShrYouhiKbn sindansyoryoushryouhikbn;

    @Type(type="UserType_C_SindansyoRyouShrYouhiKbn")
    @Column(name=GenJT_Sk.SINDANSYORYOUSHRYOUHIKBN)
    public C_SindansyoRyouShrYouhiKbn getSindansyoryoushryouhikbn() {
        return sindansyoryoushryouhikbn;
    }

    public void setSindansyoryoushryouhikbn(C_SindansyoRyouShrYouhiKbn pSindansyoryoushryouhikbn) {
        sindansyoryoushryouhikbn = pSindansyoryoushryouhikbn;
    }

    private Integer sindansyomaisuu;

    @Column(name=GenJT_Sk.SINDANSYOMAISUU)
    @Range(min="0", max="99")
    public Integer getSindansyomaisuu() {
        return sindansyomaisuu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSindansyomaisuu(Integer pSindansyomaisuu) {
        sindansyomaisuu = pSindansyomaisuu;
    }

    private C_SinsaGendoKknKbn sinsagendokknkbn;

    @Type(type="UserType_C_SinsaGendoKknKbn")
    @Column(name=GenJT_Sk.SINSAGENDOKKNKBN)
    public C_SinsaGendoKknKbn getSinsagendokknkbn() {
        return sinsagendokknkbn;
    }

    public void setSinsagendokknkbn(C_SinsaGendoKknKbn pSinsagendokknkbn) {
        sinsagendokknkbn = pSinsagendokknkbn;
    }

    private Integer rikoukityuutuudannissuu;

    @Column(name=GenJT_Sk.RIKOUKITYUUTUUDANNISSUU)
    @Range(min="0", max="999")
    public Integer getRikoukityuutuudannissuu() {
        return rikoukityuutuudannissuu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRikoukityuutuudannissuu(Integer pRikoukityuutuudannissuu) {
        rikoukityuutuudannissuu = pRikoukityuutuudannissuu;
    }

    private BizDate tienrisokukisanymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_Sk.TIENRISOKUKISANYMD)
    @ValidDate
    public BizDate getTienrisokukisanymd() {
        return tienrisokukisanymd;
    }

    @Trim("both")
    public void setTienrisokukisanymd(BizDate pTienrisokukisanymd) {
        tienrisokukisanymd = pTienrisokukisanymd;
    }

    private Integer tienrsknissuu;

    @Column(name=GenJT_Sk.TIENRSKNISSUU)
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

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenJT_Sk.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private C_Tuukasyu shrtuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenJT_Sk.SHRTUUKASYU)
    public C_Tuukasyu getShrtuukasyu() {
        return shrtuukasyu;
    }

    public void setShrtuukasyu(C_Tuukasyu pShrtuukasyu) {
        shrtuukasyu = pShrtuukasyu;
    }

    private BizDate shrkwsratekjnymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_Sk.SHRKWSRATEKJNYMD)
    public BizDate getShrkwsratekjnymd() {
        return shrkwsratekjnymd;
    }

    public void setShrkwsratekjnymd(BizDate pShrkwsratekjnymd) {
        shrkwsratekjnymd = pShrkwsratekjnymd;
    }

    private BizNumber shrkwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenJT_Sk.SHRKWSRATE)
    public BizNumber getShrkwsrate() {
        return shrkwsrate;
    }

    public void setShrkwsrate(BizNumber pShrkwsrate) {
        shrkwsrate = pShrkwsrate;
    }

    private BizDate zeimukwsratekjnymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_Sk.ZEIMUKWSRATEKJNYMD)
    public BizDate getZeimukwsratekjnymd() {
        return zeimukwsratekjnymd;
    }

    public void setZeimukwsratekjnymd(BizDate pZeimukwsratekjnymd) {
        zeimukwsratekjnymd = pZeimukwsratekjnymd;
    }

    private BizNumber zeimukwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenJT_Sk.ZEIMUKWSRATE)
    public BizNumber getZeimukwsrate() {
        return zeimukwsrate;
    }

    public void setZeimukwsrate(BizNumber pZeimukwsrate) {
        zeimukwsrate = pZeimukwsrate;
    }

    private BizDate gaikaknsnkwsratekjymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_Sk.GAIKAKNSNKWSRATEKJYMD)
    public BizDate getGaikaknsnkwsratekjymd() {
        return gaikaknsnkwsratekjymd;
    }

    public void setGaikaknsnkwsratekjymd(BizDate pGaikaknsnkwsratekjymd) {
        gaikaknsnkwsratekjymd = pGaikaknsnkwsratekjymd;
    }

    private BizNumber gaikaknsnkwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenJT_Sk.GAIKAKNSNKWSRATE)
    public BizNumber getGaikaknsnkwsrate() {
        return gaikaknsnkwsrate;
    }

    public void setGaikaknsnkwsrate(BizNumber pGaikaknsnkwsrate) {
        gaikaknsnkwsrate = pGaikaknsnkwsrate;
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

    private BizCurrency kyhkngkgoukei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKyhkngkgoukei() {
        return kyhkngkgoukei;
    }

    public void setKyhkngkgoukei(BizCurrency pKyhkngkgoukei) {
        kyhkngkgoukei = pKyhkngkgoukei;
        kyhkngkgoukeiValue = null;
        kyhkngkgoukeiType  = null;
    }

    transient private BigDecimal kyhkngkgoukeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KYHKNGKGOUKEI, nullable=true)
    protected BigDecimal getKyhkngkgoukeiValue() {
        if (kyhkngkgoukeiValue == null && kyhkngkgoukei != null) {
            if (kyhkngkgoukei.isOptional()) return null;
            return kyhkngkgoukei.absolute();
        }
        return kyhkngkgoukeiValue;
    }

    protected void setKyhkngkgoukeiValue(BigDecimal value) {
        kyhkngkgoukeiValue = value;
        kyhkngkgoukei = Optional.fromNullable(toCurrencyType(kyhkngkgoukeiType))
            .transform(bizCurrencyTransformer(getKyhkngkgoukeiValue()))
            .orNull();
    }

    transient private String kyhkngkgoukeiType = null;

    @Column(name=KYHKNGKGOUKEI + "$", nullable=true)
    protected String getKyhkngkgoukeiType() {
        if (kyhkngkgoukeiType == null && kyhkngkgoukei != null) return kyhkngkgoukei.getType().toString();
        if (kyhkngkgoukeiType == null && getKyhkngkgoukeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kyhkngkgoukei$' should not be NULL."));
        }
        return kyhkngkgoukeiType;
    }

    protected void setKyhkngkgoukeiType(String type) {
        kyhkngkgoukeiType = type;
        kyhkngkgoukei = Optional.fromNullable(toCurrencyType(kyhkngkgoukeiType))
            .transform(bizCurrencyTransformer(getKyhkngkgoukeiValue()))
            .orNull();
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

    private BizCurrency yenkyhgkgoukei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkyhgkgoukei() {
        return yenkyhgkgoukei;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkyhgkgoukei(BizCurrency pYenkyhgkgoukei) {
        yenkyhgkgoukei = pYenkyhgkgoukei;
        yenkyhgkgoukeiValue = null;
        yenkyhgkgoukeiType  = null;
    }

    transient private BigDecimal yenkyhgkgoukeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKYHGKGOUKEI, nullable=true)
    protected BigDecimal getYenkyhgkgoukeiValue() {
        if (yenkyhgkgoukeiValue == null && yenkyhgkgoukei != null) {
            if (yenkyhgkgoukei.isOptional()) return null;
            return yenkyhgkgoukei.absolute();
        }
        return yenkyhgkgoukeiValue;
    }

    protected void setYenkyhgkgoukeiValue(BigDecimal value) {
        yenkyhgkgoukeiValue = value;
        yenkyhgkgoukei = Optional.fromNullable(toCurrencyType(yenkyhgkgoukeiType))
            .transform(bizCurrencyTransformer(getYenkyhgkgoukeiValue()))
            .orNull();
    }

    transient private String yenkyhgkgoukeiType = null;

    @Column(name=YENKYHGKGOUKEI + "$", nullable=true)
    protected String getYenkyhgkgoukeiType() {
        if (yenkyhgkgoukeiType == null && yenkyhgkgoukei != null) return yenkyhgkgoukei.getType().toString();
        if (yenkyhgkgoukeiType == null && getYenkyhgkgoukeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkyhgkgoukei$' should not be NULL."));
        }
        return yenkyhgkgoukeiType;
    }

    protected void setYenkyhgkgoukeiType(String type) {
        yenkyhgkgoukeiType = type;
        yenkyhgkgoukei = Optional.fromNullable(toCurrencyType(yenkyhgkgoukeiType))
            .transform(bizCurrencyTransformer(getYenkyhgkgoukeiValue()))
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

    private BizCurrency yenkasonotaseisangk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkasonotaseisangk() {
        return yenkasonotaseisangk;
    }

    public void setYenkasonotaseisangk(BizCurrency pYenkasonotaseisangk) {
        yenkasonotaseisangk = pYenkasonotaseisangk;
        yenkasonotaseisangkValue = null;
        yenkasonotaseisangkType  = null;
    }

    transient private BigDecimal yenkasonotaseisangkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKASONOTASEISANGK, nullable=true)
    protected BigDecimal getYenkasonotaseisangkValue() {
        if (yenkasonotaseisangkValue == null && yenkasonotaseisangk != null) {
            if (yenkasonotaseisangk.isOptional()) return null;
            return yenkasonotaseisangk.absolute();
        }
        return yenkasonotaseisangkValue;
    }

    protected void setYenkasonotaseisangkValue(BigDecimal value) {
        yenkasonotaseisangkValue = value;
        yenkasonotaseisangk = Optional.fromNullable(toCurrencyType(yenkasonotaseisangkType))
            .transform(bizCurrencyTransformer(getYenkasonotaseisangkValue()))
            .orNull();
    }

    transient private String yenkasonotaseisangkType = null;

    @Column(name=YENKASONOTASEISANGK + "$", nullable=true)
    protected String getYenkasonotaseisangkType() {
        if (yenkasonotaseisangkType == null && yenkasonotaseisangk != null) return yenkasonotaseisangk.getType().toString();
        if (yenkasonotaseisangkType == null && getYenkasonotaseisangkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkasonotaseisangk$' should not be NULL."));
        }
        return yenkasonotaseisangkType;
    }

    protected void setYenkasonotaseisangkType(String type) {
        yenkasonotaseisangkType = type;
        yenkasonotaseisangk = Optional.fromNullable(toCurrencyType(yenkasonotaseisangkType))
            .transform(bizCurrencyTransformer(getYenkasonotaseisangkValue()))
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

    private BizCurrency misyuusyonendojikaiikoup;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMisyuusyonendojikaiikoup() {
        return misyuusyonendojikaiikoup;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMisyuusyonendojikaiikoup(BizCurrency pMisyuusyonendojikaiikoup) {
        misyuusyonendojikaiikoup = pMisyuusyonendojikaiikoup;
        misyuusyonendojikaiikoupValue = null;
        misyuusyonendojikaiikoupType  = null;
    }

    transient private BigDecimal misyuusyonendojikaiikoupValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MISYUUSYONENDOJIKAIIKOUP, nullable=true)
    protected BigDecimal getMisyuusyonendojikaiikoupValue() {
        if (misyuusyonendojikaiikoupValue == null && misyuusyonendojikaiikoup != null) {
            if (misyuusyonendojikaiikoup.isOptional()) return null;
            return misyuusyonendojikaiikoup.absolute();
        }
        return misyuusyonendojikaiikoupValue;
    }

    protected void setMisyuusyonendojikaiikoupValue(BigDecimal value) {
        misyuusyonendojikaiikoupValue = value;
        misyuusyonendojikaiikoup = Optional.fromNullable(toCurrencyType(misyuusyonendojikaiikoupType))
            .transform(bizCurrencyTransformer(getMisyuusyonendojikaiikoupValue()))
            .orNull();
    }

    transient private String misyuusyonendojikaiikoupType = null;

    @Column(name=MISYUUSYONENDOJIKAIIKOUP + "$", nullable=true)
    protected String getMisyuusyonendojikaiikoupType() {
        if (misyuusyonendojikaiikoupType == null && misyuusyonendojikaiikoup != null) return misyuusyonendojikaiikoup.getType().toString();
        if (misyuusyonendojikaiikoupType == null && getMisyuusyonendojikaiikoupValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'misyuusyonendojikaiikoup$' should not be NULL."));
        }
        return misyuusyonendojikaiikoupType;
    }

    protected void setMisyuusyonendojikaiikoupType(String type) {
        misyuusyonendojikaiikoupType = type;
        misyuusyonendojikaiikoup = Optional.fromNullable(toCurrencyType(misyuusyonendojikaiikoupType))
            .transform(bizCurrencyTransformer(getMisyuusyonendojikaiikoupValue()))
            .orNull();
    }

    private BizCurrency misyuujinendoikoup;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMisyuujinendoikoup() {
        return misyuujinendoikoup;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMisyuujinendoikoup(BizCurrency pMisyuujinendoikoup) {
        misyuujinendoikoup = pMisyuujinendoikoup;
        misyuujinendoikoupValue = null;
        misyuujinendoikoupType  = null;
    }

    transient private BigDecimal misyuujinendoikoupValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MISYUUJINENDOIKOUP, nullable=true)
    protected BigDecimal getMisyuujinendoikoupValue() {
        if (misyuujinendoikoupValue == null && misyuujinendoikoup != null) {
            if (misyuujinendoikoup.isOptional()) return null;
            return misyuujinendoikoup.absolute();
        }
        return misyuujinendoikoupValue;
    }

    protected void setMisyuujinendoikoupValue(BigDecimal value) {
        misyuujinendoikoupValue = value;
        misyuujinendoikoup = Optional.fromNullable(toCurrencyType(misyuujinendoikoupType))
            .transform(bizCurrencyTransformer(getMisyuujinendoikoupValue()))
            .orNull();
    }

    transient private String misyuujinendoikoupType = null;

    @Column(name=MISYUUJINENDOIKOUP + "$", nullable=true)
    protected String getMisyuujinendoikoupType() {
        if (misyuujinendoikoupType == null && misyuujinendoikoup != null) return misyuujinendoikoup.getType().toString();
        if (misyuujinendoikoupType == null && getMisyuujinendoikoupValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'misyuujinendoikoup$' should not be NULL."));
        }
        return misyuujinendoikoupType;
    }

    protected void setMisyuujinendoikoupType(String type) {
        misyuujinendoikoupType = type;
        misyuujinendoikoup = Optional.fromNullable(toCurrencyType(misyuujinendoikoupType))
            .transform(bizCurrencyTransformer(getMisyuujinendoikoupValue()))
            .orNull();
    }

    private BizDate pmkouryokuhasseiymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_Sk.PMKOURYOKUHASSEIYMD)
    public BizDate getPmkouryokuhasseiymd() {
        return pmkouryokuhasseiymd;
    }

    public void setPmkouryokuhasseiymd(BizDate pPmkouryokuhasseiymd) {
        pmkouryokuhasseiymd = pPmkouryokuhasseiymd;
    }

    private BizDateYM mikeikapjyuutouym;

    @Type(type="BizDateYMType")
    @Column(name=GenJT_Sk.MIKEIKAPJYUUTOUYM)
    public BizDateYM getMikeikapjyuutouym() {
        return mikeikapjyuutouym;
    }

    public void setMikeikapjyuutouym(BizDateYM pMikeikapjyuutouym) {
        mikeikapjyuutouym = pMikeikapjyuutouym;
    }

    private Integer mikeikapjyuutoukaisuuy;

    @Column(name=GenJT_Sk.MIKEIKAPJYUUTOUKAISUUY)
    public Integer getMikeikapjyuutoukaisuuy() {
        return mikeikapjyuutoukaisuuy;
    }

    public void setMikeikapjyuutoukaisuuy(Integer pMikeikapjyuutoukaisuuy) {
        mikeikapjyuutoukaisuuy = pMikeikapjyuutoukaisuuy;
    }

    private Integer mikeikapjyuutoukaisuum;

    @Column(name=GenJT_Sk.MIKEIKAPJYUUTOUKAISUUM)
    public Integer getMikeikapjyuutoukaisuum() {
        return mikeikapjyuutoukaisuum;
    }

    public void setMikeikapjyuutoukaisuum(Integer pMikeikapjyuutoukaisuum) {
        mikeikapjyuutoukaisuum = pMikeikapjyuutoukaisuum;
    }

    private C_UmuKbn tokusyushrkbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_Sk.TOKUSYUSHRKBN)
    public C_UmuKbn getTokusyushrkbn() {
        return tokusyushrkbn;
    }

    public void setTokusyushrkbn(C_UmuKbn pTokusyushrkbn) {
        tokusyushrkbn = pTokusyushrkbn;
    }

    private C_FirstGanSindanKyhKbn firstgansindankyhkbn;

    @Type(type="UserType_C_FirstGanSindanKyhKbn")
    @Column(name=GenJT_Sk.FIRSTGANSINDANKYHKBN)
    public C_FirstGanSindanKyhKbn getFirstgansindankyhkbn() {
        return firstgansindankyhkbn;
    }

    public void setFirstgansindankyhkbn(C_FirstGanSindanKyhKbn pFirstgansindankyhkbn) {
        firstgansindankyhkbn = pFirstgansindankyhkbn;
    }

    private BizCurrency goukeihituyoukeihi;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGoukeihituyoukeihi() {
        return goukeihituyoukeihi;
    }

    public void setGoukeihituyoukeihi(BizCurrency pGoukeihituyoukeihi) {
        goukeihituyoukeihi = pGoukeihituyoukeihi;
        goukeihituyoukeihiValue = null;
        goukeihituyoukeihiType  = null;
    }

    transient private BigDecimal goukeihituyoukeihiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GOUKEIHITUYOUKEIHI, nullable=true)
    protected BigDecimal getGoukeihituyoukeihiValue() {
        if (goukeihituyoukeihiValue == null && goukeihituyoukeihi != null) {
            if (goukeihituyoukeihi.isOptional()) return null;
            return goukeihituyoukeihi.absolute();
        }
        return goukeihituyoukeihiValue;
    }

    protected void setGoukeihituyoukeihiValue(BigDecimal value) {
        goukeihituyoukeihiValue = value;
        goukeihituyoukeihi = Optional.fromNullable(toCurrencyType(goukeihituyoukeihiType))
            .transform(bizCurrencyTransformer(getGoukeihituyoukeihiValue()))
            .orNull();
    }

    transient private String goukeihituyoukeihiType = null;

    @Column(name=GOUKEIHITUYOUKEIHI + "$", nullable=true)
    protected String getGoukeihituyoukeihiType() {
        if (goukeihituyoukeihiType == null && goukeihituyoukeihi != null) return goukeihituyoukeihi.getType().toString();
        if (goukeihituyoukeihiType == null && getGoukeihituyoukeihiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'goukeihituyoukeihi$' should not be NULL."));
        }
        return goukeihituyoukeihiType;
    }

    protected void setGoukeihituyoukeihiType(String type) {
        goukeihituyoukeihiType = type;
        goukeihituyoukeihi = Optional.fromNullable(toCurrencyType(goukeihituyoukeihiType))
            .transform(bizCurrencyTransformer(getGoukeihituyoukeihiValue()))
            .orNull();
    }

    private Integer kykhnkkaisuu;

    @Column(name=GenJT_Sk.KYKHNKKAISUU)
    public Integer getKykhnkkaisuu() {
        return kykhnkkaisuu;
    }

    public void setKykhnkkaisuu(Integer pKykhnkkaisuu) {
        kykhnkkaisuu = pKykhnkkaisuu;
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

    private BizCurrency kijitumitouraimikeikap;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKijitumitouraimikeikap() {
        return kijitumitouraimikeikap;
    }

    public void setKijitumitouraimikeikap(BizCurrency pKijitumitouraimikeikap) {
        kijitumitouraimikeikap = pKijitumitouraimikeikap;
        kijitumitouraimikeikapValue = null;
        kijitumitouraimikeikapType  = null;
    }

    transient private BigDecimal kijitumitouraimikeikapValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIJITUMITOURAIMIKEIKAP, nullable=true)
    protected BigDecimal getKijitumitouraimikeikapValue() {
        if (kijitumitouraimikeikapValue == null && kijitumitouraimikeikap != null) {
            if (kijitumitouraimikeikap.isOptional()) return null;
            return kijitumitouraimikeikap.absolute();
        }
        return kijitumitouraimikeikapValue;
    }

    protected void setKijitumitouraimikeikapValue(BigDecimal value) {
        kijitumitouraimikeikapValue = value;
        kijitumitouraimikeikap = Optional.fromNullable(toCurrencyType(kijitumitouraimikeikapType))
            .transform(bizCurrencyTransformer(getKijitumitouraimikeikapValue()))
            .orNull();
    }

    transient private String kijitumitouraimikeikapType = null;

    @Column(name=KIJITUMITOURAIMIKEIKAP + "$", nullable=true)
    protected String getKijitumitouraimikeikapType() {
        if (kijitumitouraimikeikapType == null && kijitumitouraimikeikap != null) return kijitumitouraimikeikap.getType().toString();
        if (kijitumitouraimikeikapType == null && getKijitumitouraimikeikapValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kijitumitouraimikeikap$' should not be NULL."));
        }
        return kijitumitouraimikeikapType;
    }

    protected void setKijitumitouraimikeikapType(String type) {
        kijitumitouraimikeikapType = type;
        kijitumitouraimikeikap = Optional.fromNullable(toCurrencyType(kijitumitouraimikeikapType))
            .transform(bizCurrencyTransformer(getKijitumitouraimikeikapValue()))
            .orNull();
    }

    private BizCurrency kyhknshrtyousyomisyuup;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKyhknshrtyousyomisyuup() {
        return kyhknshrtyousyomisyuup;
    }

    public void setKyhknshrtyousyomisyuup(BizCurrency pKyhknshrtyousyomisyuup) {
        kyhknshrtyousyomisyuup = pKyhknshrtyousyomisyuup;
        kyhknshrtyousyomisyuupValue = null;
        kyhknshrtyousyomisyuupType  = null;
    }

    transient private BigDecimal kyhknshrtyousyomisyuupValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KYHKNSHRTYOUSYOMISYUUP, nullable=true)
    protected BigDecimal getKyhknshrtyousyomisyuupValue() {
        if (kyhknshrtyousyomisyuupValue == null && kyhknshrtyousyomisyuup != null) {
            if (kyhknshrtyousyomisyuup.isOptional()) return null;
            return kyhknshrtyousyomisyuup.absolute();
        }
        return kyhknshrtyousyomisyuupValue;
    }

    protected void setKyhknshrtyousyomisyuupValue(BigDecimal value) {
        kyhknshrtyousyomisyuupValue = value;
        kyhknshrtyousyomisyuup = Optional.fromNullable(toCurrencyType(kyhknshrtyousyomisyuupType))
            .transform(bizCurrencyTransformer(getKyhknshrtyousyomisyuupValue()))
            .orNull();
    }

    transient private String kyhknshrtyousyomisyuupType = null;

    @Column(name=KYHKNSHRTYOUSYOMISYUUP + "$", nullable=true)
    protected String getKyhknshrtyousyomisyuupType() {
        if (kyhknshrtyousyomisyuupType == null && kyhknshrtyousyomisyuup != null) return kyhknshrtyousyomisyuup.getType().toString();
        if (kyhknshrtyousyomisyuupType == null && getKyhknshrtyousyomisyuupValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kyhknshrtyousyomisyuup$' should not be NULL."));
        }
        return kyhknshrtyousyomisyuupType;
    }

    protected void setKyhknshrtyousyomisyuupType(String type) {
        kyhknshrtyousyomisyuupType = type;
        kyhknshrtyousyomisyuup = Optional.fromNullable(toCurrencyType(kyhknshrtyousyomisyuupType))
            .transform(bizCurrencyTransformer(getKyhknshrtyousyomisyuupValue()))
            .orNull();
    }

    private BizCurrency kyhknshrtyousyomikeikap;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKyhknshrtyousyomikeikap() {
        return kyhknshrtyousyomikeikap;
    }

    public void setKyhknshrtyousyomikeikap(BizCurrency pKyhknshrtyousyomikeikap) {
        kyhknshrtyousyomikeikap = pKyhknshrtyousyomikeikap;
        kyhknshrtyousyomikeikapValue = null;
        kyhknshrtyousyomikeikapType  = null;
    }

    transient private BigDecimal kyhknshrtyousyomikeikapValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KYHKNSHRTYOUSYOMIKEIKAP, nullable=true)
    protected BigDecimal getKyhknshrtyousyomikeikapValue() {
        if (kyhknshrtyousyomikeikapValue == null && kyhknshrtyousyomikeikap != null) {
            if (kyhknshrtyousyomikeikap.isOptional()) return null;
            return kyhknshrtyousyomikeikap.absolute();
        }
        return kyhknshrtyousyomikeikapValue;
    }

    protected void setKyhknshrtyousyomikeikapValue(BigDecimal value) {
        kyhknshrtyousyomikeikapValue = value;
        kyhknshrtyousyomikeikap = Optional.fromNullable(toCurrencyType(kyhknshrtyousyomikeikapType))
            .transform(bizCurrencyTransformer(getKyhknshrtyousyomikeikapValue()))
            .orNull();
    }

    transient private String kyhknshrtyousyomikeikapType = null;

    @Column(name=KYHKNSHRTYOUSYOMIKEIKAP + "$", nullable=true)
    protected String getKyhknshrtyousyomikeikapType() {
        if (kyhknshrtyousyomikeikapType == null && kyhknshrtyousyomikeikap != null) return kyhknshrtyousyomikeikap.getType().toString();
        if (kyhknshrtyousyomikeikapType == null && getKyhknshrtyousyomikeikapValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kyhknshrtyousyomikeikap$' should not be NULL."));
        }
        return kyhknshrtyousyomikeikapType;
    }

    protected void setKyhknshrtyousyomikeikapType(String type) {
        kyhknshrtyousyomikeikapType = type;
        kyhknshrtyousyomikeikap = Optional.fromNullable(toCurrencyType(kyhknshrtyousyomikeikapType))
            .transform(bizCurrencyTransformer(getKyhknshrtyousyomikeikapValue()))
            .orNull();
    }

    private BizCurrency kyhknshrtysykjtmitrmikeikap;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKyhknshrtysykjtmitrmikeikap() {
        return kyhknshrtysykjtmitrmikeikap;
    }

    public void setKyhknshrtysykjtmitrmikeikap(BizCurrency pKyhknshrtysykjtmitrmikeikap) {
        kyhknshrtysykjtmitrmikeikap = pKyhknshrtysykjtmitrmikeikap;
        kyhknshrtysykjtmitrmikeikapValue = null;
        kyhknshrtysykjtmitrmikeikapType  = null;
    }

    transient private BigDecimal kyhknshrtysykjtmitrmikeikapValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KYHKNSHRTYSYKJTMITRMIKEIKAP, nullable=true)
    protected BigDecimal getKyhknshrtysykjtmitrmikeikapValue() {
        if (kyhknshrtysykjtmitrmikeikapValue == null && kyhknshrtysykjtmitrmikeikap != null) {
            if (kyhknshrtysykjtmitrmikeikap.isOptional()) return null;
            return kyhknshrtysykjtmitrmikeikap.absolute();
        }
        return kyhknshrtysykjtmitrmikeikapValue;
    }

    protected void setKyhknshrtysykjtmitrmikeikapValue(BigDecimal value) {
        kyhknshrtysykjtmitrmikeikapValue = value;
        kyhknshrtysykjtmitrmikeikap = Optional.fromNullable(toCurrencyType(kyhknshrtysykjtmitrmikeikapType))
            .transform(bizCurrencyTransformer(getKyhknshrtysykjtmitrmikeikapValue()))
            .orNull();
    }

    transient private String kyhknshrtysykjtmitrmikeikapType = null;

    @Column(name=KYHKNSHRTYSYKJTMITRMIKEIKAP + "$", nullable=true)
    protected String getKyhknshrtysykjtmitrmikeikapType() {
        if (kyhknshrtysykjtmitrmikeikapType == null && kyhknshrtysykjtmitrmikeikap != null) return kyhknshrtysykjtmitrmikeikap.getType().toString();
        if (kyhknshrtysykjtmitrmikeikapType == null && getKyhknshrtysykjtmitrmikeikapValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kyhknshrtysykjtmitrmikeikap$' should not be NULL."));
        }
        return kyhknshrtysykjtmitrmikeikapType;
    }

    protected void setKyhknshrtysykjtmitrmikeikapType(String type) {
        kyhknshrtysykjtmitrmikeikapType = type;
        kyhknshrtysykjtmitrmikeikap = Optional.fromNullable(toCurrencyType(kyhknshrtysykjtmitrmikeikapType))
            .transform(bizCurrencyTransformer(getKyhknshrtysykjtmitrmikeikapValue()))
            .orNull();
    }

    private C_NaiteiKakuteiKbn vhtnaiteikakuteikbn;

    @Type(type="UserType_C_NaiteiKakuteiKbn")
    @Column(name=GenJT_Sk.VHTNAITEIKAKUTEIKBN)
    public C_NaiteiKakuteiKbn getVhtnaiteikakuteikbn() {
        return vhtnaiteikakuteikbn;
    }

    public void setVhtnaiteikakuteikbn(C_NaiteiKakuteiKbn pVhtnaiteikakuteikbn) {
        vhtnaiteikakuteikbn = pVhtnaiteikakuteikbn;
    }

    private String kossyoricd;

    @Column(name=GenJT_Sk.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_Sk.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_Sk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_Sk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}