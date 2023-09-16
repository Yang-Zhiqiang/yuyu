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
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.NaturalNumberBizCalcable;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.RangeBizCalcable;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_Bnshrkaisuu;
import yuyu.def.classification.C_DatatorikomiKbn;
import yuyu.def.classification.C_FirstmiseikyuuKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknhouskKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KeiukeDouKbn;
import yuyu.def.classification.C_KgkyojusikibetuKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_NenkinJimuTesuuryouKbn;
import yuyu.def.classification.C_NenkinKigouSedaiKbn;
import yuyu.def.classification.C_NenreiCalcKbn;
import yuyu.def.classification.C_NkHaitoukinuketorihouKbn;
import yuyu.def.classification.C_Nkshrhsijiyuu;
import yuyu.def.classification.C_Nkukthou;
import yuyu.def.classification.C_NkzeiseiKbn;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_Seikyuunaiyou;
import yuyu.def.classification.C_Shrhou;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SkskknsyubetuKbn;
import yuyu.def.classification.C_StdrskstKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UkehiDouKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_Uktsei;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.BT_NenkinInfoRendou;
import yuyu.def.db.id.PKBT_NenkinInfoRendou;
import yuyu.def.db.meta.GenQBT_NenkinInfoRendou;
import yuyu.def.db.meta.QBT_NenkinInfoRendou;
import yuyu.def.db.type.UserType_C_AisyoumeiKbn;
import yuyu.def.db.type.UserType_C_Bnshrkaisuu;
import yuyu.def.db.type.UserType_C_DatatorikomiKbn;
import yuyu.def.db.type.UserType_C_FirstmiseikyuuKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_HknhouskKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_KeiukeDouKbn;
import yuyu.def.db.type.UserType_C_KgkyojusikibetuKbn;
import yuyu.def.db.type.UserType_C_KktyuitaKbn;
import yuyu.def.db.type.UserType_C_NenkinJimuTesuuryouKbn;
import yuyu.def.db.type.UserType_C_NenkinKigouSedaiKbn;
import yuyu.def.db.type.UserType_C_NenreiCalcKbn;
import yuyu.def.db.type.UserType_C_NkHaitoukinuketorihouKbn;
import yuyu.def.db.type.UserType_C_Nkshrhsijiyuu;
import yuyu.def.db.type.UserType_C_Nkukthou;
import yuyu.def.db.type.UserType_C_NkzeiseiKbn;
import yuyu.def.db.type.UserType_C_SUketoriHouhouKbn;
import yuyu.def.db.type.UserType_C_Seikyuunaiyou;
import yuyu.def.db.type.UserType_C_Shrhou;
import yuyu.def.db.type.UserType_C_ShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_SinsaGendoKknKbn;
import yuyu.def.db.type.UserType_C_SkskknsyubetuKbn;
import yuyu.def.db.type.UserType_C_StdrskstKbn;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UkehiDouKbn;
import yuyu.def.db.type.UserType_C_UktKbn;
import yuyu.def.db.type.UserType_C_Uktsei;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.def.db.type.UserType_C_YouhiKbn;
import yuyu.def.db.type.UserType_C_ZeitratkiKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 年金情報連動テーブル テーブルのマッピング情報クラスで、 {@link BT_NenkinInfoRendou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_NenkinInfoRendou}</td><td colspan="3">年金情報連動テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKBT_NenkinInfoRendou ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKBT_NenkinInfoRendou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKBT_NenkinInfoRendou ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNksysynonosaibanyhkbn nksysynonosaibanyhkbn}</td><td>年金証書番号採番要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YouhiKbn}</td></tr>
 *  <tr><td>{@link #getDatatorikomikbn datatorikomikbn}</td><td>データ取込区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DatatorikomiKbn}</td></tr>
 *  <tr><td>{@link #getFirstmiseikyuukbn firstmiseikyuukbn}</td><td>初回年金未請求区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_FirstmiseikyuuKbn}</td></tr>
 *  <tr><td>{@link #getSuketorihouhoukbn suketorihouhoukbn}</td><td>保険金受取方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SUketoriHouhouKbn}</td></tr>
 *  <tr><td>{@link #getHukusuuuketoriflg hukusuuuketoriflg}</td><td>複数受取フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getNkkknsetymd nkkknsetymd}</td><td>年金基金設定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNkshrstartymd nkshrstartymd}</td><td>年金支払開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBnshrkaisuu bnshrkaisuu}</td><td>分割支払回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Bnshrkaisuu}</td></tr>
 *  <tr><td>{@link #getNkukthou nkukthou}</td><td>年金受取方法</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Nkukthou}</td></tr>
 *  <tr><td>{@link #getNkshrhsijiyuu nkshrhsijiyuu}</td><td>年金支払発生事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Nkshrhsijiyuu}</td></tr>
 *  <tr><td>{@link #getNkshrtkykjkghkkbn nkshrtkykjkghkkbn}</td><td>年金支払特約事故後付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHknhouskkbn hknhouskkbn}</td><td>保険法施行区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HknhouskKbn}</td></tr>
 *  <tr><td>{@link #getMotosyono motosyono}</td><td>元証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getAisyoumeikbn aisyoumeikbn}</td><td>愛称名区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AisyoumeiKbn}</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getOyadairitencd1 oyadairitencd1}</td><td>親代理店コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDairitencd1 dairitencd1}</td><td>代理店コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuucd1 bosyuucd1}</td><td>募集人コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDairitenbuntanwariai1 dairitenbuntanwariai1}</td><td>代理店分担割合１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getOyadairitencd2 oyadairitencd2}</td><td>親代理店コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDairitencd2 dairitencd2}</td><td>代理店コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuucd2 bosyuucd2}</td><td>募集人コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDairitenbuntanwariai2 dairitenbuntanwariai2}</td><td>代理店分担割合２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrtenkanrisosikicd1 drtenkanrisosikicd1}</td><td>代理店管理組織コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtenkanritodoufukencd drtenkanritodoufukencd}</td><td>代理店管理都道府県コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCifcd cifcd}</td><td>ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZeitratkikbn zeitratkikbn}</td><td>税取扱区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ZeitratkiKbn}</td></tr>
 *  <tr><td>{@link #getKyknmkn kyknmkn}</td><td>契約者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykadr kykadr}</td><td>契約者住所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkn hhknnmkn}</td><td>被保険者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkj hhknnmkj}</td><td>被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknseiymd hhknseiymd}</td><td>被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHhknnen hhknnen}</td><td>被保険者年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHhknsei hhknsei}</td><td>被保険者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hhknsei}</td></tr>
 *  <tr><td>{@link #getHhknadrkj hhknadrkj}</td><td>被保険者住所（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknsakuinmeino hhknsakuinmeino}</td><td>被保険者索引名番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktnmkn uktnmkn}</td><td>受取人名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktnmkj uktnmkj}</td><td>受取人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKeiukedoukbn keiukedoukbn}</td><td>契受同一区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KeiukeDouKbn}</td></tr>
 *  <tr><td>{@link #getUkehidouitukbn ukehidouitukbn}</td><td>受被同一区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UkehiDouKbn}</td></tr>
 *  <tr><td>{@link #getUktseiymd uktseiymd}</td><td>受取人生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getUktsei uktsei}</td><td>受取人性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Uktsei}</td></tr>
 *  <tr><td>{@link #getTsinyno tsinyno}</td><td>通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr1kj tsinadr1kj}</td><td>通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr2kj tsinadr2kj}</td><td>通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr3kj tsinadr3kj}</td><td>通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsintelno tsintelno}</td><td>通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKgkyojusikibetukbn kgkyojusikibetukbn}</td><td>海外居住者識別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KgkyojusikibetuKbn}</td></tr>
 *  <tr><td>{@link #getNkuktsakuinnmno nkuktsakuinnmno}</td><td>年金受取人索引名番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkskknnmkn skskknnmkn}</td><td>親権者後見人名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkskknnmkj skskknnmkj}</td><td>親権者後見人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkskknsyubetu skskknsyubetu}</td><td>親権者後見人種別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SkskknsyubetuKbn}</td></tr>
 *  <tr><td>{@link #getShrhou shrhou}</td><td>支払方法</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Shrhou}</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeisikakymd seisikakymd}</td><td>生死確認日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSeikyuunaiyou seikyuunaiyou}</td><td>請求内容</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Seikyuunaiyou}</td></tr>
 *  <tr><td>{@link #getShrhousiteikbn shrhousiteikbn}</td><td>支払方法指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ShrhousiteiKbn}</td></tr>
 *  <tr><td>{@link #getSyoruiukeymd syoruiukeymd}</td><td>書類受付日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSinsagendokknkbn sinsagendokknkbn}</td><td>審査限度期間区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SinsaGendoKknKbn}</td></tr>
 *  <tr><td>{@link #getRikoukityuutuudannissuu rikoukityuutuudannissuu}</td><td>履行期中断日数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getYenshrtkumukbn yenshrtkumukbn}</td><td>円支払特約有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKeizknenkinuktsiteitk keizknenkinuktsiteitk}</td><td>継続年金受取人指定特約</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKeizknenkinuktkbn keizknenkinuktkbn}</td><td>継続年金受取人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UktKbn}</td></tr>
 *  <tr><td>{@link #getKeizknenkinuktnmkana keizknenkinuktnmkana}</td><td>継続年金受取人名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKeizknenkinuktnmkanji keizknenkinuktnmkanji}</td><td>継続年金受取人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKeizknenkiuktseiymd keizknenkiuktseiymd}</td><td>継続年金受取人生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getStdrsktky stdrsktky}</td><td>指定代理請求特約</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getStdrsktkyhkymd stdrsktkyhkymd}</td><td>指定代理請求特約付加日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getStdrskstkbn stdrskstkbn}</td><td>指定代理請求人指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_StdrskstKbn}</td></tr>
 *  <tr><td>{@link #getStdrsknmkn stdrsknmkn}</td><td>指定代理請求人名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStdrsknmkj stdrsknmkj}</td><td>指定代理請求人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStdruktkbn stdruktkbn}</td><td>指定代理受取人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UktKbn}</td></tr>
 *  <tr><td>{@link #getKktyuitakbn kktyuitakbn}</td><td>契約管理注意取扱区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KktyuitaKbn}</td></tr>
 *  <tr><td>{@link #getNkttdktyuuinaiyou1 nkttdktyuuinaiyou1}</td><td>年金手続注意内容１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkttdktyuuinaiyou2 nkttdktyuuinaiyou2}</td><td>年金手続注意内容２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkttdktyuuinaiyou3 nkttdktyuuinaiyou3}</td><td>年金手続注意内容３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkttdktyuuinaiyou4 nkttdktyuuinaiyou4}</td><td>年金手続注意内容４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkttdktyuuinaiyou5 nkttdktyuuinaiyou5}</td><td>年金手続注意内容５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkttdktyuuinaiyou6 nkttdktyuuinaiyou6}</td><td>年金手続注意内容６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkttdktyuuinaiyou7 nkttdktyuuinaiyou7}</td><td>年金手続注意内容７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkttdktyuuinaiyou8 nkttdktyuuinaiyou8}</td><td>年金手続注意内容８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkttdktyuuinaiyou9 nkttdktyuuinaiyou9}</td><td>年金手続注意内容９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkttdktyuuinaiyou10 nkttdktyuuinaiyou10}</td><td>年金手続注意内容１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkttdktyuuinaiyou11 nkttdktyuuinaiyou11}</td><td>年金手続注意内容１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkttdktyuuinaiyou12 nkttdktyuuinaiyou12}</td><td>年金手続注意内容１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkttdktyuuinaiyou13 nkttdktyuuinaiyou13}</td><td>年金手続注意内容１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkttdktyuuinaiyou14 nkttdktyuuinaiyou14}</td><td>年金手続注意内容１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkttdktyuuinaiyou15 nkttdktyuuinaiyou15}</td><td>年金手続注意内容１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkttdktyuuinaiyou16 nkttdktyuuinaiyou16}</td><td>年金手続注意内容１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkttdktyuuinaiyou17 nkttdktyuuinaiyou17}</td><td>年金手続注意内容１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkttdktyuuinaiyou18 nkttdktyuuinaiyou18}</td><td>年金手続注意内容１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTeisyutkykbn teisyutkykbn}</td><td>定額年金主契約特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr><td>{@link #getTeinksyu teinksyu}</td><td>定額年金年金種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTeinksyuruiversion teinksyuruiversion}</td><td>定額年金年金種類バージョン</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkigousedaikbn nenkinkigousedaikbn}</td><td>年金記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NenkinKigouSedaiKbn}</td></tr>
 *  <tr><td>{@link #getTeinkspan teinkspan}</td><td>定額年金年金期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getTeikihongk teikihongk}</td><td>定額年金基本年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTeihitukeihiyen teihitukeihiyen}</td><td>定額年金必要経費（円貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTeihitukeihigaika teihitukeihigaika}</td><td>定額年金必要経費（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTeinkkikingken teinkkikingken}</td><td>定額年金年金基金額（円貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTeinkkikingkgaika teinkkikingkgaika}</td><td>定額年金年金基金額（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNenkinkaisigoyoteiriritukbn nenkinkaisigoyoteiriritukbn}</td><td>年金開始後予定利率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinjimutesuuryoukbn nenkinjimutesuuryoukbn}</td><td>年金事務手数料区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NenkinJimuTesuuryouKbn}</td></tr>
 *  <tr><td>{@link #getNenreicalckbn nenreicalckbn}</td><td>年齢計算区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NenreiCalcKbn}</td></tr>
 *  <tr><td>{@link #getTyoukankseigk tyoukankseigk}</td><td>超過年金精算額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKsnnkgk ksnnkgk}</td><td>加算年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKsnnkkkngk ksnnkkkngk}</td><td>加算年金基金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNkzeiseikbn nkzeiseikbn}</td><td>年金税制区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NkzeiseiKbn}</td></tr>
 *  <tr><td>{@link #getKykkstkkn kykkstkkn}</td><td>契約者貸付金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getJhurikstkkn jhurikstkkn}</td><td>自動振替貸付金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMisyuup misyuup}</td><td>未収保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNkhaitoukinuketorihoukbn nkhaitoukinuketorihoukbn}</td><td>年金配当金受取方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NkHaitoukinuketorihouKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_NenkinInfoRendou
 * @see     PKBT_NenkinInfoRendou
 * @see     QBT_NenkinInfoRendou
 * @see     GenQBT_NenkinInfoRendou
 */
@MappedSuperclass
@Table(name=GenBT_NenkinInfoRendou.TABLE_NAME)
@IdClass(value=PKBT_NenkinInfoRendou.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_AisyoumeiKbn", typeClass=UserType_C_AisyoumeiKbn.class),
    @TypeDef(name="UserType_C_Bnshrkaisuu", typeClass=UserType_C_Bnshrkaisuu.class),
    @TypeDef(name="UserType_C_DatatorikomiKbn", typeClass=UserType_C_DatatorikomiKbn.class),
    @TypeDef(name="UserType_C_FirstmiseikyuuKbn", typeClass=UserType_C_FirstmiseikyuuKbn.class),
    @TypeDef(name="UserType_C_Hhknsei", typeClass=UserType_C_Hhknsei.class),
    @TypeDef(name="UserType_C_HknhouskKbn", typeClass=UserType_C_HknhouskKbn.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_KeiukeDouKbn", typeClass=UserType_C_KeiukeDouKbn.class),
    @TypeDef(name="UserType_C_KgkyojusikibetuKbn", typeClass=UserType_C_KgkyojusikibetuKbn.class),
    @TypeDef(name="UserType_C_KktyuitaKbn", typeClass=UserType_C_KktyuitaKbn.class),
    @TypeDef(name="UserType_C_NenkinJimuTesuuryouKbn", typeClass=UserType_C_NenkinJimuTesuuryouKbn.class),
    @TypeDef(name="UserType_C_NenkinKigouSedaiKbn", typeClass=UserType_C_NenkinKigouSedaiKbn.class),
    @TypeDef(name="UserType_C_NenreiCalcKbn", typeClass=UserType_C_NenreiCalcKbn.class),
    @TypeDef(name="UserType_C_NkHaitoukinuketorihouKbn", typeClass=UserType_C_NkHaitoukinuketorihouKbn.class),
    @TypeDef(name="UserType_C_Nkshrhsijiyuu", typeClass=UserType_C_Nkshrhsijiyuu.class),
    @TypeDef(name="UserType_C_Nkukthou", typeClass=UserType_C_Nkukthou.class),
    @TypeDef(name="UserType_C_NkzeiseiKbn", typeClass=UserType_C_NkzeiseiKbn.class),
    @TypeDef(name="UserType_C_SUketoriHouhouKbn", typeClass=UserType_C_SUketoriHouhouKbn.class),
    @TypeDef(name="UserType_C_Seikyuunaiyou", typeClass=UserType_C_Seikyuunaiyou.class),
    @TypeDef(name="UserType_C_Shrhou", typeClass=UserType_C_Shrhou.class),
    @TypeDef(name="UserType_C_ShrhousiteiKbn", typeClass=UserType_C_ShrhousiteiKbn.class),
    @TypeDef(name="UserType_C_SinsaGendoKknKbn", typeClass=UserType_C_SinsaGendoKknKbn.class),
    @TypeDef(name="UserType_C_SkskknsyubetuKbn", typeClass=UserType_C_SkskknsyubetuKbn.class),
    @TypeDef(name="UserType_C_StdrskstKbn", typeClass=UserType_C_StdrskstKbn.class),
    @TypeDef(name="UserType_C_SyutkKbn", typeClass=UserType_C_SyutkKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UkehiDouKbn", typeClass=UserType_C_UkehiDouKbn.class),
    @TypeDef(name="UserType_C_UktKbn", typeClass=UserType_C_UktKbn.class),
    @TypeDef(name="UserType_C_Uktsei", typeClass=UserType_C_Uktsei.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class),
    @TypeDef(name="UserType_C_YouhiKbn", typeClass=UserType_C_YouhiKbn.class),
    @TypeDef(name="UserType_C_ZeitratkiKbn", typeClass=UserType_C_ZeitratkiKbn.class)
})
public abstract class GenBT_NenkinInfoRendou extends AbstractExDBEntity<BT_NenkinInfoRendou, PKBT_NenkinInfoRendou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_NenkinInfoRendou";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SYONO                    = "syono";
    public static final String RENNO                    = "renno";
    public static final String NKSYSYNONOSAIBANYHKBN    = "nksysynonosaibanyhkbn";
    public static final String DATATORIKOMIKBN          = "datatorikomikbn";
    public static final String FIRSTMISEIKYUUKBN        = "firstmiseikyuukbn";
    public static final String SUKETORIHOUHOUKBN        = "suketorihouhoukbn";
    public static final String HUKUSUUUKETORIFLG        = "hukusuuuketoriflg";
    public static final String NKKKNSETYMD              = "nkkknsetymd";
    public static final String NKSHRSTARTYMD            = "nkshrstartymd";
    public static final String BNSHRKAISUU              = "bnshrkaisuu";
    public static final String NKUKTHOU                 = "nkukthou";
    public static final String NKSHRHSIJIYUU            = "nkshrhsijiyuu";
    public static final String NKSHRTKYKJKGHKKBN        = "nkshrtkykjkghkkbn";
    public static final String KYKYMD                   = "kykymd";
    public static final String HKNHOUSKKBN              = "hknhouskkbn";
    public static final String MOTOSYONO                = "motosyono";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String AISYOUMEIKBN             = "aisyoumeikbn";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String OYADAIRITENCD1           = "oyadairitencd1";
    public static final String DAIRITENCD1              = "dairitencd1";
    public static final String BOSYUUCD1                = "bosyuucd1";
    public static final String DAIRITENBUNTANWARIAI1    = "dairitenbuntanwariai1";
    public static final String OYADAIRITENCD2           = "oyadairitencd2";
    public static final String DAIRITENCD2              = "dairitencd2";
    public static final String BOSYUUCD2                = "bosyuucd2";
    public static final String DAIRITENBUNTANWARIAI2    = "dairitenbuntanwariai2";
    public static final String DRTENKANRISOSIKICD1      = "drtenkanrisosikicd1";
    public static final String DRTENKANRITODOUFUKENCD   = "drtenkanritodoufukencd";
    public static final String CIFCD                    = "cifcd";
    public static final String ZEITRATKIKBN             = "zeitratkikbn";
    public static final String KYKNMKN                  = "kyknmkn";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String KYKADR                   = "kykadr";
    public static final String HHKNNMKN                 = "hhknnmkn";
    public static final String HHKNNMKJ                 = "hhknnmkj";
    public static final String HHKNSEIYMD               = "hhknseiymd";
    public static final String HHKNNEN                  = "hhknnen";
    public static final String HHKNSEI                  = "hhknsei";
    public static final String HHKNADRKJ                = "hhknadrkj";
    public static final String HHKNSAKUINMEINO          = "hhknsakuinmeino";
    public static final String UKTNMKN                  = "uktnmkn";
    public static final String UKTNMKJ                  = "uktnmkj";
    public static final String KEIUKEDOUKBN             = "keiukedoukbn";
    public static final String UKEHIDOUITUKBN           = "ukehidouitukbn";
    public static final String UKTSEIYMD                = "uktseiymd";
    public static final String UKTSEI                   = "uktsei";
    public static final String TSINYNO                  = "tsinyno";
    public static final String TSINADR1KJ               = "tsinadr1kj";
    public static final String TSINADR2KJ               = "tsinadr2kj";
    public static final String TSINADR3KJ               = "tsinadr3kj";
    public static final String TSINTELNO                = "tsintelno";
    public static final String KGKYOJUSIKIBETUKBN       = "kgkyojusikibetukbn";
    public static final String NKUKTSAKUINNMNO          = "nkuktsakuinnmno";
    public static final String SKSKKNNMKN               = "skskknnmkn";
    public static final String SKSKKNNMKJ               = "skskknnmkj";
    public static final String SKSKKNSYUBETU            = "skskknsyubetu";
    public static final String SHRHOU                   = "shrhou";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String SEISIKAKYMD              = "seisikakymd";
    public static final String SEIKYUUNAIYOU            = "seikyuunaiyou";
    public static final String SHRHOUSITEIKBN           = "shrhousiteikbn";
    public static final String SYORUIUKEYMD             = "syoruiukeymd";
    public static final String SINSAGENDOKKNKBN         = "sinsagendokknkbn";
    public static final String RIKOUKITYUUTUUDANNISSUU  = "rikoukityuutuudannissuu";
    public static final String YENSHRTKUMUKBN           = "yenshrtkumukbn";
    public static final String KEIZKNENKINUKTSITEITK    = "keizknenkinuktsiteitk";
    public static final String KEIZKNENKINUKTKBN        = "keizknenkinuktkbn";
    public static final String KEIZKNENKINUKTNMKANA     = "keizknenkinuktnmkana";
    public static final String KEIZKNENKINUKTNMKANJI    = "keizknenkinuktnmkanji";
    public static final String KEIZKNENKIUKTSEIYMD      = "keizknenkiuktseiymd";
    public static final String STDRSKTKY                = "stdrsktky";
    public static final String STDRSKTKYHKYMD           = "stdrsktkyhkymd";
    public static final String STDRSKSTKBN              = "stdrskstkbn";
    public static final String STDRSKNMKN               = "stdrsknmkn";
    public static final String STDRSKNMKJ               = "stdrsknmkj";
    public static final String STDRUKTKBN               = "stdruktkbn";
    public static final String KKTYUITAKBN              = "kktyuitakbn";
    public static final String NKTTDKTYUUINAIYOU1       = "nkttdktyuuinaiyou1";
    public static final String NKTTDKTYUUINAIYOU2       = "nkttdktyuuinaiyou2";
    public static final String NKTTDKTYUUINAIYOU3       = "nkttdktyuuinaiyou3";
    public static final String NKTTDKTYUUINAIYOU4       = "nkttdktyuuinaiyou4";
    public static final String NKTTDKTYUUINAIYOU5       = "nkttdktyuuinaiyou5";
    public static final String NKTTDKTYUUINAIYOU6       = "nkttdktyuuinaiyou6";
    public static final String NKTTDKTYUUINAIYOU7       = "nkttdktyuuinaiyou7";
    public static final String NKTTDKTYUUINAIYOU8       = "nkttdktyuuinaiyou8";
    public static final String NKTTDKTYUUINAIYOU9       = "nkttdktyuuinaiyou9";
    public static final String NKTTDKTYUUINAIYOU10      = "nkttdktyuuinaiyou10";
    public static final String NKTTDKTYUUINAIYOU11      = "nkttdktyuuinaiyou11";
    public static final String NKTTDKTYUUINAIYOU12      = "nkttdktyuuinaiyou12";
    public static final String NKTTDKTYUUINAIYOU13      = "nkttdktyuuinaiyou13";
    public static final String NKTTDKTYUUINAIYOU14      = "nkttdktyuuinaiyou14";
    public static final String NKTTDKTYUUINAIYOU15      = "nkttdktyuuinaiyou15";
    public static final String NKTTDKTYUUINAIYOU16      = "nkttdktyuuinaiyou16";
    public static final String NKTTDKTYUUINAIYOU17      = "nkttdktyuuinaiyou17";
    public static final String NKTTDKTYUUINAIYOU18      = "nkttdktyuuinaiyou18";
    public static final String TEISYUTKYKBN             = "teisyutkykbn";
    public static final String TEINKSYU                 = "teinksyu";
    public static final String TEINKSYURUIVERSION       = "teinksyuruiversion";
    public static final String NENKINKIGOUSEDAIKBN      = "nenkinkigousedaikbn";
    public static final String TEINKSPAN                = "teinkspan";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String TEIKIHONGK               = "teikihongk";
    public static final String TEIHITUKEIHIYEN          = "teihitukeihiyen";
    public static final String TEIHITUKEIHIGAIKA        = "teihitukeihigaika";
    public static final String TEINKKIKINGKEN           = "teinkkikingken";
    public static final String TEINKKIKINGKGAIKA        = "teinkkikingkgaika";
    public static final String NENKINKAISIGOYOTEIRIRITUKBN = "nenkinkaisigoyoteiriritukbn";
    public static final String NENKINJIMUTESUURYOUKBN   = "nenkinjimutesuuryoukbn";
    public static final String NENREICALCKBN            = "nenreicalckbn";
    public static final String TYOUKANKSEIGK            = "tyoukankseigk";
    public static final String KSNNKGK                  = "ksnnkgk";
    public static final String KSNNKKKNGK               = "ksnnkkkngk";
    public static final String NKZEISEIKBN              = "nkzeiseikbn";
    public static final String KYKKSTKKN                = "kykkstkkn";
    public static final String JHURIKSTKKN              = "jhurikstkkn";
    public static final String MISYUUP                  = "misyuup";
    public static final String NKHAITOUKINUKETORIHOUKBN = "nkhaitoukinuketorihoukbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKBT_NenkinInfoRendou primaryKey;

    public GenBT_NenkinInfoRendou() {
        primaryKey = new PKBT_NenkinInfoRendou();
    }

    public GenBT_NenkinInfoRendou(
        BizDate pSyoriYmd,
        String pSyono,
        Integer pRenno
    ) {
        primaryKey = new PKBT_NenkinInfoRendou(
            pSyoriYmd,
            pSyono,
            pRenno
        );
    }

    @Transient
    @Override
    public PKBT_NenkinInfoRendou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_NenkinInfoRendou> getMetaClass() {
        return QBT_NenkinInfoRendou.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBT_NenkinInfoRendou.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return getPrimaryKey().getSyoriYmd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        getPrimaryKey().setSyoriYmd(pSyoriYmd);
    }

    @Id
    @Column(name=GenBT_NenkinInfoRendou.SYONO)
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
    @Column(name=GenBT_NenkinInfoRendou.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private C_YouhiKbn nksysynonosaibanyhkbn;

    @Type(type="UserType_C_YouhiKbn")
    @Column(name=GenBT_NenkinInfoRendou.NKSYSYNONOSAIBANYHKBN)
    public C_YouhiKbn getNksysynonosaibanyhkbn() {
        return nksysynonosaibanyhkbn;
    }

    public void setNksysynonosaibanyhkbn(C_YouhiKbn pNksysynonosaibanyhkbn) {
        nksysynonosaibanyhkbn = pNksysynonosaibanyhkbn;
    }

    private C_DatatorikomiKbn datatorikomikbn;

    @Type(type="UserType_C_DatatorikomiKbn")
    @Column(name=GenBT_NenkinInfoRendou.DATATORIKOMIKBN)
    public C_DatatorikomiKbn getDatatorikomikbn() {
        return datatorikomikbn;
    }

    public void setDatatorikomikbn(C_DatatorikomiKbn pDatatorikomikbn) {
        datatorikomikbn = pDatatorikomikbn;
    }

    private C_FirstmiseikyuuKbn firstmiseikyuukbn;

    @Type(type="UserType_C_FirstmiseikyuuKbn")
    @Column(name=GenBT_NenkinInfoRendou.FIRSTMISEIKYUUKBN)
    public C_FirstmiseikyuuKbn getFirstmiseikyuukbn() {
        return firstmiseikyuukbn;
    }

    public void setFirstmiseikyuukbn(C_FirstmiseikyuuKbn pFirstmiseikyuukbn) {
        firstmiseikyuukbn = pFirstmiseikyuukbn;
    }

    private C_SUketoriHouhouKbn suketorihouhoukbn;

    @Type(type="UserType_C_SUketoriHouhouKbn")
    @Column(name=GenBT_NenkinInfoRendou.SUKETORIHOUHOUKBN)
    public C_SUketoriHouhouKbn getSuketorihouhoukbn() {
        return suketorihouhoukbn;
    }

    public void setSuketorihouhoukbn(C_SUketoriHouhouKbn pSuketorihouhoukbn) {
        suketorihouhoukbn = pSuketorihouhoukbn;
    }

    private C_UmuKbn hukusuuuketoriflg;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBT_NenkinInfoRendou.HUKUSUUUKETORIFLG)
    public C_UmuKbn getHukusuuuketoriflg() {
        return hukusuuuketoriflg;
    }

    public void setHukusuuuketoriflg(C_UmuKbn pHukusuuuketoriflg) {
        hukusuuuketoriflg = pHukusuuuketoriflg;
    }

    private BizDate nkkknsetymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_NenkinInfoRendou.NKKKNSETYMD)
    @ValidDate
    public BizDate getNkkknsetymd() {
        return nkkknsetymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNkkknsetymd(BizDate pNkkknsetymd) {
        nkkknsetymd = pNkkknsetymd;
    }

    private BizDate nkshrstartymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_NenkinInfoRendou.NKSHRSTARTYMD)
    public BizDate getNkshrstartymd() {
        return nkshrstartymd;
    }

    @Trim("both")
    public void setNkshrstartymd(BizDate pNkshrstartymd) {
        nkshrstartymd = pNkshrstartymd;
    }

    private C_Bnshrkaisuu bnshrkaisuu;

    @Type(type="UserType_C_Bnshrkaisuu")
    @Column(name=GenBT_NenkinInfoRendou.BNSHRKAISUU)
    public C_Bnshrkaisuu getBnshrkaisuu() {
        return bnshrkaisuu;
    }

    public void setBnshrkaisuu(C_Bnshrkaisuu pBnshrkaisuu) {
        bnshrkaisuu = pBnshrkaisuu;
    }

    private C_Nkukthou nkukthou;

    @Type(type="UserType_C_Nkukthou")
    @Column(name=GenBT_NenkinInfoRendou.NKUKTHOU)
    public C_Nkukthou getNkukthou() {
        return nkukthou;
    }

    public void setNkukthou(C_Nkukthou pNkukthou) {
        nkukthou = pNkukthou;
    }

    private C_Nkshrhsijiyuu nkshrhsijiyuu;

    @Type(type="UserType_C_Nkshrhsijiyuu")
    @Column(name=GenBT_NenkinInfoRendou.NKSHRHSIJIYUU)
    public C_Nkshrhsijiyuu getNkshrhsijiyuu() {
        return nkshrhsijiyuu;
    }

    public void setNkshrhsijiyuu(C_Nkshrhsijiyuu pNkshrhsijiyuu) {
        nkshrhsijiyuu = pNkshrhsijiyuu;
    }

    private C_UmuKbn nkshrtkykjkghkkbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBT_NenkinInfoRendou.NKSHRTKYKJKGHKKBN)
    public C_UmuKbn getNkshrtkykjkghkkbn() {
        return nkshrtkykjkghkkbn;
    }

    public void setNkshrtkykjkghkkbn(C_UmuKbn pNkshrtkykjkghkkbn) {
        nkshrtkykjkghkkbn = pNkshrtkykjkghkkbn;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_NenkinInfoRendou.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private C_HknhouskKbn hknhouskkbn;

    @Type(type="UserType_C_HknhouskKbn")
    @Column(name=GenBT_NenkinInfoRendou.HKNHOUSKKBN)
    public C_HknhouskKbn getHknhouskkbn() {
        return hknhouskkbn;
    }

    public void setHknhouskkbn(C_HknhouskKbn pHknhouskkbn) {
        hknhouskkbn = pHknhouskkbn;
    }

    private String motosyono;

    @Column(name=GenBT_NenkinInfoRendou.MOTOSYONO)
    @SyoukenNo
    public String getMotosyono() {
        return motosyono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMotosyono(String pMotosyono) {
        motosyono = pMotosyono;
    }

    private String syouhncd;

    @Column(name=GenBT_NenkinInfoRendou.SYOUHNCD)
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

    @Column(name=GenBT_NenkinInfoRendou.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return syouhnsdno;
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        syouhnsdno = pSyouhnsdno;
    }

    private C_AisyoumeiKbn aisyoumeikbn;

    @Type(type="UserType_C_AisyoumeiKbn")
    @Column(name=GenBT_NenkinInfoRendou.AISYOUMEIKBN)
    public C_AisyoumeiKbn getAisyoumeikbn() {
        return aisyoumeikbn;
    }

    public void setAisyoumeikbn(C_AisyoumeiKbn pAisyoumeikbn) {
        aisyoumeikbn = pAisyoumeikbn;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenBT_NenkinInfoRendou.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private String oyadairitencd1;

    @Column(name=GenBT_NenkinInfoRendou.OYADAIRITENCD1)
    @MaxLength(max=7)
    @AlphaDigit
    public String getOyadairitencd1() {
        return oyadairitencd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOyadairitencd1(String pOyadairitencd1) {
        oyadairitencd1 = pOyadairitencd1;
    }

    private String dairitencd1;

    @Column(name=GenBT_NenkinInfoRendou.DAIRITENCD1)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDairitencd1() {
        return dairitencd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitencd1(String pDairitencd1) {
        dairitencd1 = pDairitencd1;
    }

    private String bosyuucd1;

    @Column(name=GenBT_NenkinInfoRendou.BOSYUUCD1)
    @MaxLength(max=6)
    @AlphaDigit
    @HostInvalidCharacter
    public String getBosyuucd1() {
        return bosyuucd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuucd1(String pBosyuucd1) {
        bosyuucd1 = pBosyuucd1;
    }

    private BizNumber dairitenbuntanwariai1;

    @Type(type="BizNumberType")
    @Column(name=GenBT_NenkinInfoRendou.DAIRITENBUNTANWARIAI1)
    @RangeBizCalcable(min="0", max="100")
    @NaturalNumberBizCalcable
    public BizNumber getDairitenbuntanwariai1() {
        return dairitenbuntanwariai1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitenbuntanwariai1(BizNumber pDairitenbuntanwariai1) {
        dairitenbuntanwariai1 = pDairitenbuntanwariai1;
    }

    private String oyadairitencd2;

    @Column(name=GenBT_NenkinInfoRendou.OYADAIRITENCD2)
    @MaxLength(max=7)
    @AlphaDigit
    public String getOyadairitencd2() {
        return oyadairitencd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOyadairitencd2(String pOyadairitencd2) {
        oyadairitencd2 = pOyadairitencd2;
    }

    private String dairitencd2;

    @Column(name=GenBT_NenkinInfoRendou.DAIRITENCD2)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDairitencd2() {
        return dairitencd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitencd2(String pDairitencd2) {
        dairitencd2 = pDairitencd2;
    }

    private String bosyuucd2;

    @Column(name=GenBT_NenkinInfoRendou.BOSYUUCD2)
    @MaxLength(max=6)
    @AlphaDigit
    @HostInvalidCharacter
    public String getBosyuucd2() {
        return bosyuucd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuucd2(String pBosyuucd2) {
        bosyuucd2 = pBosyuucd2;
    }

    private BizNumber dairitenbuntanwariai2;

    @Type(type="BizNumberType")
    @Column(name=GenBT_NenkinInfoRendou.DAIRITENBUNTANWARIAI2)
    @RangeBizCalcable(min="0", max="100")
    @NaturalNumberBizCalcable
    public BizNumber getDairitenbuntanwariai2() {
        return dairitenbuntanwariai2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitenbuntanwariai2(BizNumber pDairitenbuntanwariai2) {
        dairitenbuntanwariai2 = pDairitenbuntanwariai2;
    }

    private String drtenkanrisosikicd1;

    @Column(name=GenBT_NenkinInfoRendou.DRTENKANRISOSIKICD1)
    @MaxLength(max=7)
    @SingleByteStrings
    public String getDrtenkanrisosikicd1() {
        return drtenkanrisosikicd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtenkanrisosikicd1(String pDrtenkanrisosikicd1) {
        drtenkanrisosikicd1 = pDrtenkanrisosikicd1;
    }

    private String drtenkanritodoufukencd;

    @Column(name=GenBT_NenkinInfoRendou.DRTENKANRITODOUFUKENCD)
    public String getDrtenkanritodoufukencd() {
        return drtenkanritodoufukencd;
    }

    public void setDrtenkanritodoufukencd(String pDrtenkanritodoufukencd) {
        drtenkanritodoufukencd = pDrtenkanritodoufukencd;
    }

    private String cifcd;

    @Column(name=GenBT_NenkinInfoRendou.CIFCD)
    @MaxLength(max=15)
    @AlphaDigit
    @HostInvalidCharacter
    public String getCifcd() {
        return cifcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCifcd(String pCifcd) {
        cifcd = pCifcd;
    }

    private C_ZeitratkiKbn zeitratkikbn;

    @Type(type="UserType_C_ZeitratkiKbn")
    @Column(name=GenBT_NenkinInfoRendou.ZEITRATKIKBN)
    public C_ZeitratkiKbn getZeitratkikbn() {
        return zeitratkikbn;
    }

    public void setZeitratkikbn(C_ZeitratkiKbn pZeitratkikbn) {
        zeitratkikbn = pZeitratkikbn;
    }

    private String kyknmkn;

    @Column(name=GenBT_NenkinInfoRendou.KYKNMKN)
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

    @Column(name=GenBT_NenkinInfoRendou.KYKNMKJ)
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

    private String kykadr;

    @Column(name=GenBT_NenkinInfoRendou.KYKADR)
    @MaxLength(max=62)
    @MultiByteStrings
    @InvalidCharacter
    public String getKykadr() {
        return kykadr;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKykadr(String pKykadr) {
        kykadr = pKykadr;
    }

    private String hhknnmkn;

    @Column(name=GenBT_NenkinInfoRendou.HHKNNMKN)
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

    @Column(name=GenBT_NenkinInfoRendou.HHKNNMKJ)
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
    @Column(name=GenBT_NenkinInfoRendou.HHKNSEIYMD)
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

    @Column(name=GenBT_NenkinInfoRendou.HHKNNEN)
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
    @Column(name=GenBT_NenkinInfoRendou.HHKNSEI)
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private String hhknadrkj;

    @Column(name=GenBT_NenkinInfoRendou.HHKNADRKJ)
    @MaxLength(max=62)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknadrkj() {
        return hhknadrkj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setHhknadrkj(String pHhknadrkj) {
        hhknadrkj = pHhknadrkj;
    }

    private String hhknsakuinmeino;

    @Column(name=GenBT_NenkinInfoRendou.HHKNSAKUINMEINO)
    public String getHhknsakuinmeino() {
        return hhknsakuinmeino;
    }

    public void setHhknsakuinmeino(String pHhknsakuinmeino) {
        hhknsakuinmeino = pHhknsakuinmeino;
    }

    private String uktnmkn;

    @Column(name=GenBT_NenkinInfoRendou.UKTNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getUktnmkn() {
        return uktnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setUktnmkn(String pUktnmkn) {
        uktnmkn = pUktnmkn;
    }

    private String uktnmkj;

    @Column(name=GenBT_NenkinInfoRendou.UKTNMKJ)
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

    private C_KeiukeDouKbn keiukedoukbn;

    @Type(type="UserType_C_KeiukeDouKbn")
    @Column(name=GenBT_NenkinInfoRendou.KEIUKEDOUKBN)
    public C_KeiukeDouKbn getKeiukedoukbn() {
        return keiukedoukbn;
    }

    public void setKeiukedoukbn(C_KeiukeDouKbn pKeiukedoukbn) {
        keiukedoukbn = pKeiukedoukbn;
    }

    private C_UkehiDouKbn ukehidouitukbn;

    @Type(type="UserType_C_UkehiDouKbn")
    @Column(name=GenBT_NenkinInfoRendou.UKEHIDOUITUKBN)
    public C_UkehiDouKbn getUkehidouitukbn() {
        return ukehidouitukbn;
    }

    public void setUkehidouitukbn(C_UkehiDouKbn pUkehidouitukbn) {
        ukehidouitukbn = pUkehidouitukbn;
    }

    private BizDate uktseiymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_NenkinInfoRendou.UKTSEIYMD)
    @ValidDate
    public BizDate getUktseiymd() {
        return uktseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUktseiymd(BizDate pUktseiymd) {
        uktseiymd = pUktseiymd;
    }

    private C_Uktsei uktsei;

    @Type(type="UserType_C_Uktsei")
    @Column(name=GenBT_NenkinInfoRendou.UKTSEI)
    public C_Uktsei getUktsei() {
        return uktsei;
    }

    public void setUktsei(C_Uktsei pUktsei) {
        uktsei = pUktsei;
    }

    private String tsinyno;

    @Column(name=GenBT_NenkinInfoRendou.TSINYNO)
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

    @Column(name=GenBT_NenkinInfoRendou.TSINADR1KJ)
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

    @Column(name=GenBT_NenkinInfoRendou.TSINADR2KJ)
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

    @Column(name=GenBT_NenkinInfoRendou.TSINADR3KJ)
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

    @Column(name=GenBT_NenkinInfoRendou.TSINTELNO)
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

    private C_KgkyojusikibetuKbn kgkyojusikibetukbn;

    @Type(type="UserType_C_KgkyojusikibetuKbn")
    @Column(name=GenBT_NenkinInfoRendou.KGKYOJUSIKIBETUKBN)
    public C_KgkyojusikibetuKbn getKgkyojusikibetukbn() {
        return kgkyojusikibetukbn;
    }

    public void setKgkyojusikibetukbn(C_KgkyojusikibetuKbn pKgkyojusikibetukbn) {
        kgkyojusikibetukbn = pKgkyojusikibetukbn;
    }

    private String nkuktsakuinnmno;

    @Column(name=GenBT_NenkinInfoRendou.NKUKTSAKUINNMNO)
    @MaxLength(max=10)
    @SingleByteStrings
    public String getNkuktsakuinnmno() {
        return nkuktsakuinnmno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNkuktsakuinnmno(String pNkuktsakuinnmno) {
        nkuktsakuinnmno = pNkuktsakuinnmno;
    }

    private String skskknnmkn;

    @Column(name=GenBT_NenkinInfoRendou.SKSKKNNMKN)
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

    @Column(name=GenBT_NenkinInfoRendou.SKSKKNNMKJ)
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
    @Column(name=GenBT_NenkinInfoRendou.SKSKKNSYUBETU)
    public C_SkskknsyubetuKbn getSkskknsyubetu() {
        return skskknsyubetu;
    }

    public void setSkskknsyubetu(C_SkskknsyubetuKbn pSkskknsyubetu) {
        skskknsyubetu = pSkskknsyubetu;
    }

    private C_Shrhou shrhou;

    @Type(type="UserType_C_Shrhou")
    @Column(name=GenBT_NenkinInfoRendou.SHRHOU)
    public C_Shrhou getShrhou() {
        return shrhou;
    }

    public void setShrhou(C_Shrhou pShrhou) {
        shrhou = pShrhou;
    }

    private String bankcd;

    @Column(name=GenBT_NenkinInfoRendou.BANKCD)
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

    @Column(name=GenBT_NenkinInfoRendou.SITENCD)
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
    @Column(name=GenBT_NenkinInfoRendou.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenBT_NenkinInfoRendou.KOUZANO)
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

    @Column(name=GenBT_NenkinInfoRendou.KZMEIGINMKN)
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

    private BizDate seisikakymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_NenkinInfoRendou.SEISIKAKYMD)
    @ValidDate
    public BizDate getSeisikakymd() {
        return seisikakymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSeisikakymd(BizDate pSeisikakymd) {
        seisikakymd = pSeisikakymd;
    }

    private C_Seikyuunaiyou seikyuunaiyou;

    @Type(type="UserType_C_Seikyuunaiyou")
    @Column(name=GenBT_NenkinInfoRendou.SEIKYUUNAIYOU)
    public C_Seikyuunaiyou getSeikyuunaiyou() {
        return seikyuunaiyou;
    }

    public void setSeikyuunaiyou(C_Seikyuunaiyou pSeikyuunaiyou) {
        seikyuunaiyou = pSeikyuunaiyou;
    }

    private C_ShrhousiteiKbn shrhousiteikbn;

    @Type(type="UserType_C_ShrhousiteiKbn")
    @Column(name=GenBT_NenkinInfoRendou.SHRHOUSITEIKBN)
    public C_ShrhousiteiKbn getShrhousiteikbn() {
        return shrhousiteikbn;
    }

    public void setShrhousiteikbn(C_ShrhousiteiKbn pShrhousiteikbn) {
        shrhousiteikbn = pShrhousiteikbn;
    }

    private BizDate syoruiukeymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_NenkinInfoRendou.SYORUIUKEYMD)
    @ValidDate
    public BizDate getSyoruiukeymd() {
        return syoruiukeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoruiukeymd(BizDate pSyoruiukeymd) {
        syoruiukeymd = pSyoruiukeymd;
    }

    private C_SinsaGendoKknKbn sinsagendokknkbn;

    @Type(type="UserType_C_SinsaGendoKknKbn")
    @Column(name=GenBT_NenkinInfoRendou.SINSAGENDOKKNKBN)
    public C_SinsaGendoKknKbn getSinsagendokknkbn() {
        return sinsagendokknkbn;
    }

    public void setSinsagendokknkbn(C_SinsaGendoKknKbn pSinsagendokknkbn) {
        sinsagendokknkbn = pSinsagendokknkbn;
    }

    private Integer rikoukityuutuudannissuu;

    @Column(name=GenBT_NenkinInfoRendou.RIKOUKITYUUTUUDANNISSUU)
    @Range(min="0", max="999")
    public Integer getRikoukityuutuudannissuu() {
        return rikoukityuutuudannissuu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRikoukityuutuudannissuu(Integer pRikoukityuutuudannissuu) {
        rikoukityuutuudannissuu = pRikoukityuutuudannissuu;
    }

    private C_UmuKbn yenshrtkumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBT_NenkinInfoRendou.YENSHRTKUMUKBN)
    public C_UmuKbn getYenshrtkumukbn() {
        return yenshrtkumukbn;
    }

    public void setYenshrtkumukbn(C_UmuKbn pYenshrtkumukbn) {
        yenshrtkumukbn = pYenshrtkumukbn;
    }

    private C_UmuKbn keizknenkinuktsiteitk;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBT_NenkinInfoRendou.KEIZKNENKINUKTSITEITK)
    public C_UmuKbn getKeizknenkinuktsiteitk() {
        return keizknenkinuktsiteitk;
    }

    public void setKeizknenkinuktsiteitk(C_UmuKbn pKeizknenkinuktsiteitk) {
        keizknenkinuktsiteitk = pKeizknenkinuktsiteitk;
    }

    private C_UktKbn keizknenkinuktkbn;

    @Type(type="UserType_C_UktKbn")
    @Column(name=GenBT_NenkinInfoRendou.KEIZKNENKINUKTKBN)
    public C_UktKbn getKeizknenkinuktkbn() {
        return keizknenkinuktkbn;
    }

    public void setKeizknenkinuktkbn(C_UktKbn pKeizknenkinuktkbn) {
        keizknenkinuktkbn = pKeizknenkinuktkbn;
    }

    private String keizknenkinuktnmkana;

    @Column(name=GenBT_NenkinInfoRendou.KEIZKNENKINUKTNMKANA)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKeizknenkinuktnmkana() {
        return keizknenkinuktnmkana;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKeizknenkinuktnmkana(String pKeizknenkinuktnmkana) {
        keizknenkinuktnmkana = pKeizknenkinuktnmkana;
    }

    private String keizknenkinuktnmkanji;

    @Column(name=GenBT_NenkinInfoRendou.KEIZKNENKINUKTNMKANJI)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getKeizknenkinuktnmkanji() {
        return keizknenkinuktnmkanji;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKeizknenkinuktnmkanji(String pKeizknenkinuktnmkanji) {
        keizknenkinuktnmkanji = pKeizknenkinuktnmkanji;
    }

    private BizDate keizknenkiuktseiymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_NenkinInfoRendou.KEIZKNENKIUKTSEIYMD)
    @ValidDate
    public BizDate getKeizknenkiuktseiymd() {
        return keizknenkiuktseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKeizknenkiuktseiymd(BizDate pKeizknenkiuktseiymd) {
        keizknenkiuktseiymd = pKeizknenkiuktseiymd;
    }

    private C_UmuKbn stdrsktky;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBT_NenkinInfoRendou.STDRSKTKY)
    public C_UmuKbn getStdrsktky() {
        return stdrsktky;
    }

    public void setStdrsktky(C_UmuKbn pStdrsktky) {
        stdrsktky = pStdrsktky;
    }

    private BizDate stdrsktkyhkymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_NenkinInfoRendou.STDRSKTKYHKYMD)
    public BizDate getStdrsktkyhkymd() {
        return stdrsktkyhkymd;
    }

    @Trim("both")
    public void setStdrsktkyhkymd(BizDate pStdrsktkyhkymd) {
        stdrsktkyhkymd = pStdrsktkyhkymd;
    }

    private C_StdrskstKbn stdrskstkbn;

    @Type(type="UserType_C_StdrskstKbn")
    @Column(name=GenBT_NenkinInfoRendou.STDRSKSTKBN)
    public C_StdrskstKbn getStdrskstkbn() {
        return stdrskstkbn;
    }

    public void setStdrskstkbn(C_StdrskstKbn pStdrskstkbn) {
        stdrskstkbn = pStdrskstkbn;
    }

    private String stdrsknmkn;

    @Column(name=GenBT_NenkinInfoRendou.STDRSKNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getStdrsknmkn() {
        return stdrsknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setStdrsknmkn(String pStdrsknmkn) {
        stdrsknmkn = pStdrsknmkn;
    }

    private String stdrsknmkj;

    @Column(name=GenBT_NenkinInfoRendou.STDRSKNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getStdrsknmkj() {
        return stdrsknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setStdrsknmkj(String pStdrsknmkj) {
        stdrsknmkj = pStdrsknmkj;
    }

    private C_UktKbn stdruktkbn;

    @Type(type="UserType_C_UktKbn")
    @Column(name=GenBT_NenkinInfoRendou.STDRUKTKBN)
    public C_UktKbn getStdruktkbn() {
        return stdruktkbn;
    }

    public void setStdruktkbn(C_UktKbn pStdruktkbn) {
        stdruktkbn = pStdruktkbn;
    }

    private C_KktyuitaKbn kktyuitakbn;

    @Type(type="UserType_C_KktyuitaKbn")
    @Column(name=GenBT_NenkinInfoRendou.KKTYUITAKBN)
    public C_KktyuitaKbn getKktyuitakbn() {
        return kktyuitakbn;
    }

    public void setKktyuitakbn(C_KktyuitaKbn pKktyuitakbn) {
        kktyuitakbn = pKktyuitakbn;
    }

    private String nkttdktyuuinaiyou1;

    @Column(name=GenBT_NenkinInfoRendou.NKTTDKTYUUINAIYOU1)
    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    public String getNkttdktyuuinaiyou1() {
        return nkttdktyuuinaiyou1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNkttdktyuuinaiyou1(String pNkttdktyuuinaiyou1) {
        nkttdktyuuinaiyou1 = pNkttdktyuuinaiyou1;
    }

    private String nkttdktyuuinaiyou2;

    @Column(name=GenBT_NenkinInfoRendou.NKTTDKTYUUINAIYOU2)
    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    public String getNkttdktyuuinaiyou2() {
        return nkttdktyuuinaiyou2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNkttdktyuuinaiyou2(String pNkttdktyuuinaiyou2) {
        nkttdktyuuinaiyou2 = pNkttdktyuuinaiyou2;
    }

    private String nkttdktyuuinaiyou3;

    @Column(name=GenBT_NenkinInfoRendou.NKTTDKTYUUINAIYOU3)
    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    public String getNkttdktyuuinaiyou3() {
        return nkttdktyuuinaiyou3;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNkttdktyuuinaiyou3(String pNkttdktyuuinaiyou3) {
        nkttdktyuuinaiyou3 = pNkttdktyuuinaiyou3;
    }

    private String nkttdktyuuinaiyou4;

    @Column(name=GenBT_NenkinInfoRendou.NKTTDKTYUUINAIYOU4)
    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    public String getNkttdktyuuinaiyou4() {
        return nkttdktyuuinaiyou4;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNkttdktyuuinaiyou4(String pNkttdktyuuinaiyou4) {
        nkttdktyuuinaiyou4 = pNkttdktyuuinaiyou4;
    }

    private String nkttdktyuuinaiyou5;

    @Column(name=GenBT_NenkinInfoRendou.NKTTDKTYUUINAIYOU5)
    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    public String getNkttdktyuuinaiyou5() {
        return nkttdktyuuinaiyou5;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNkttdktyuuinaiyou5(String pNkttdktyuuinaiyou5) {
        nkttdktyuuinaiyou5 = pNkttdktyuuinaiyou5;
    }

    private String nkttdktyuuinaiyou6;

    @Column(name=GenBT_NenkinInfoRendou.NKTTDKTYUUINAIYOU6)
    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    public String getNkttdktyuuinaiyou6() {
        return nkttdktyuuinaiyou6;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNkttdktyuuinaiyou6(String pNkttdktyuuinaiyou6) {
        nkttdktyuuinaiyou6 = pNkttdktyuuinaiyou6;
    }

    private String nkttdktyuuinaiyou7;

    @Column(name=GenBT_NenkinInfoRendou.NKTTDKTYUUINAIYOU7)
    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    public String getNkttdktyuuinaiyou7() {
        return nkttdktyuuinaiyou7;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNkttdktyuuinaiyou7(String pNkttdktyuuinaiyou7) {
        nkttdktyuuinaiyou7 = pNkttdktyuuinaiyou7;
    }

    private String nkttdktyuuinaiyou8;

    @Column(name=GenBT_NenkinInfoRendou.NKTTDKTYUUINAIYOU8)
    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    public String getNkttdktyuuinaiyou8() {
        return nkttdktyuuinaiyou8;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNkttdktyuuinaiyou8(String pNkttdktyuuinaiyou8) {
        nkttdktyuuinaiyou8 = pNkttdktyuuinaiyou8;
    }

    private String nkttdktyuuinaiyou9;

    @Column(name=GenBT_NenkinInfoRendou.NKTTDKTYUUINAIYOU9)
    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    public String getNkttdktyuuinaiyou9() {
        return nkttdktyuuinaiyou9;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNkttdktyuuinaiyou9(String pNkttdktyuuinaiyou9) {
        nkttdktyuuinaiyou9 = pNkttdktyuuinaiyou9;
    }

    private String nkttdktyuuinaiyou10;

    @Column(name=GenBT_NenkinInfoRendou.NKTTDKTYUUINAIYOU10)
    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    public String getNkttdktyuuinaiyou10() {
        return nkttdktyuuinaiyou10;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNkttdktyuuinaiyou10(String pNkttdktyuuinaiyou10) {
        nkttdktyuuinaiyou10 = pNkttdktyuuinaiyou10;
    }

    private String nkttdktyuuinaiyou11;

    @Column(name=GenBT_NenkinInfoRendou.NKTTDKTYUUINAIYOU11)
    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    public String getNkttdktyuuinaiyou11() {
        return nkttdktyuuinaiyou11;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNkttdktyuuinaiyou11(String pNkttdktyuuinaiyou11) {
        nkttdktyuuinaiyou11 = pNkttdktyuuinaiyou11;
    }

    private String nkttdktyuuinaiyou12;

    @Column(name=GenBT_NenkinInfoRendou.NKTTDKTYUUINAIYOU12)
    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    public String getNkttdktyuuinaiyou12() {
        return nkttdktyuuinaiyou12;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNkttdktyuuinaiyou12(String pNkttdktyuuinaiyou12) {
        nkttdktyuuinaiyou12 = pNkttdktyuuinaiyou12;
    }

    private String nkttdktyuuinaiyou13;

    @Column(name=GenBT_NenkinInfoRendou.NKTTDKTYUUINAIYOU13)
    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    public String getNkttdktyuuinaiyou13() {
        return nkttdktyuuinaiyou13;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNkttdktyuuinaiyou13(String pNkttdktyuuinaiyou13) {
        nkttdktyuuinaiyou13 = pNkttdktyuuinaiyou13;
    }

    private String nkttdktyuuinaiyou14;

    @Column(name=GenBT_NenkinInfoRendou.NKTTDKTYUUINAIYOU14)
    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    public String getNkttdktyuuinaiyou14() {
        return nkttdktyuuinaiyou14;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNkttdktyuuinaiyou14(String pNkttdktyuuinaiyou14) {
        nkttdktyuuinaiyou14 = pNkttdktyuuinaiyou14;
    }

    private String nkttdktyuuinaiyou15;

    @Column(name=GenBT_NenkinInfoRendou.NKTTDKTYUUINAIYOU15)
    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    public String getNkttdktyuuinaiyou15() {
        return nkttdktyuuinaiyou15;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNkttdktyuuinaiyou15(String pNkttdktyuuinaiyou15) {
        nkttdktyuuinaiyou15 = pNkttdktyuuinaiyou15;
    }

    private String nkttdktyuuinaiyou16;

    @Column(name=GenBT_NenkinInfoRendou.NKTTDKTYUUINAIYOU16)
    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    public String getNkttdktyuuinaiyou16() {
        return nkttdktyuuinaiyou16;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNkttdktyuuinaiyou16(String pNkttdktyuuinaiyou16) {
        nkttdktyuuinaiyou16 = pNkttdktyuuinaiyou16;
    }

    private String nkttdktyuuinaiyou17;

    @Column(name=GenBT_NenkinInfoRendou.NKTTDKTYUUINAIYOU17)
    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    public String getNkttdktyuuinaiyou17() {
        return nkttdktyuuinaiyou17;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNkttdktyuuinaiyou17(String pNkttdktyuuinaiyou17) {
        nkttdktyuuinaiyou17 = pNkttdktyuuinaiyou17;
    }

    private String nkttdktyuuinaiyou18;

    @Column(name=GenBT_NenkinInfoRendou.NKTTDKTYUUINAIYOU18)
    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    public String getNkttdktyuuinaiyou18() {
        return nkttdktyuuinaiyou18;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setNkttdktyuuinaiyou18(String pNkttdktyuuinaiyou18) {
        nkttdktyuuinaiyou18 = pNkttdktyuuinaiyou18;
    }

    private C_SyutkKbn teisyutkykbn;

    @Type(type="UserType_C_SyutkKbn")
    @Column(name=GenBT_NenkinInfoRendou.TEISYUTKYKBN)
    public C_SyutkKbn getTeisyutkykbn() {
        return teisyutkykbn;
    }

    public void setTeisyutkykbn(C_SyutkKbn pTeisyutkykbn) {
        teisyutkykbn = pTeisyutkykbn;
    }

    private String teinksyu;

    @Column(name=GenBT_NenkinInfoRendou.TEINKSYU)
    public String getTeinksyu() {
        return teinksyu;
    }

    public void setTeinksyu(String pTeinksyu) {
        teinksyu = pTeinksyu;
    }

    private String teinksyuruiversion;

    @Column(name=GenBT_NenkinInfoRendou.TEINKSYURUIVERSION)
    public String getTeinksyuruiversion() {
        return teinksyuruiversion;
    }

    public void setTeinksyuruiversion(String pTeinksyuruiversion) {
        teinksyuruiversion = pTeinksyuruiversion;
    }

    private C_NenkinKigouSedaiKbn nenkinkigousedaikbn;

    @Type(type="UserType_C_NenkinKigouSedaiKbn")
    @Column(name=GenBT_NenkinInfoRendou.NENKINKIGOUSEDAIKBN)
    public C_NenkinKigouSedaiKbn getNenkinkigousedaikbn() {
        return nenkinkigousedaikbn;
    }

    public void setNenkinkigousedaikbn(C_NenkinKigouSedaiKbn pNenkinkigousedaikbn) {
        nenkinkigousedaikbn = pNenkinkigousedaikbn;
    }

    private String teinkspan;

    @Column(name=GenBT_NenkinInfoRendou.TEINKSPAN)
    public String getTeinkspan() {
        return teinkspan;
    }

    public void setTeinkspan(String pTeinkspan) {
        teinkspan = pTeinkspan;
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBT_NenkinInfoRendou.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private BizCurrency teikihongk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTeikihongk() {
        return teikihongk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTeikihongk(BizCurrency pTeikihongk) {
        teikihongk = pTeikihongk;
        teikihongkValue = null;
        teikihongkType  = null;
    }

    transient private BigDecimal teikihongkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TEIKIHONGK, nullable=true)
    protected BigDecimal getTeikihongkValue() {
        if (teikihongkValue == null && teikihongk != null) {
            if (teikihongk.isOptional()) return null;
            return teikihongk.absolute();
        }
        return teikihongkValue;
    }

    protected void setTeikihongkValue(BigDecimal value) {
        teikihongkValue = value;
        teikihongk = Optional.fromNullable(toCurrencyType(teikihongkType))
            .transform(bizCurrencyTransformer(getTeikihongkValue()))
            .orNull();
    }

    transient private String teikihongkType = null;

    @Column(name=TEIKIHONGK + "$", nullable=true)
    protected String getTeikihongkType() {
        if (teikihongkType == null && teikihongk != null) return teikihongk.getType().toString();
        if (teikihongkType == null && getTeikihongkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'teikihongk$' should not be NULL."));
        }
        return teikihongkType;
    }

    protected void setTeikihongkType(String type) {
        teikihongkType = type;
        teikihongk = Optional.fromNullable(toCurrencyType(teikihongkType))
            .transform(bizCurrencyTransformer(getTeikihongkValue()))
            .orNull();
    }

    private BizCurrency teihitukeihiyen;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTeihitukeihiyen() {
        return teihitukeihiyen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTeihitukeihiyen(BizCurrency pTeihitukeihiyen) {
        teihitukeihiyen = pTeihitukeihiyen;
        teihitukeihiyenValue = null;
        teihitukeihiyenType  = null;
    }

    transient private BigDecimal teihitukeihiyenValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TEIHITUKEIHIYEN, nullable=true)
    protected BigDecimal getTeihitukeihiyenValue() {
        if (teihitukeihiyenValue == null && teihitukeihiyen != null) {
            if (teihitukeihiyen.isOptional()) return null;
            return teihitukeihiyen.absolute();
        }
        return teihitukeihiyenValue;
    }

    protected void setTeihitukeihiyenValue(BigDecimal value) {
        teihitukeihiyenValue = value;
        teihitukeihiyen = Optional.fromNullable(toCurrencyType(teihitukeihiyenType))
            .transform(bizCurrencyTransformer(getTeihitukeihiyenValue()))
            .orNull();
    }

    transient private String teihitukeihiyenType = null;

    @Column(name=TEIHITUKEIHIYEN + "$", nullable=true)
    protected String getTeihitukeihiyenType() {
        if (teihitukeihiyenType == null && teihitukeihiyen != null) return teihitukeihiyen.getType().toString();
        if (teihitukeihiyenType == null && getTeihitukeihiyenValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'teihitukeihiyen$' should not be NULL."));
        }
        return teihitukeihiyenType;
    }

    protected void setTeihitukeihiyenType(String type) {
        teihitukeihiyenType = type;
        teihitukeihiyen = Optional.fromNullable(toCurrencyType(teihitukeihiyenType))
            .transform(bizCurrencyTransformer(getTeihitukeihiyenValue()))
            .orNull();
    }

    private BizCurrency teihitukeihigaika;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTeihitukeihigaika() {
        return teihitukeihigaika;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTeihitukeihigaika(BizCurrency pTeihitukeihigaika) {
        teihitukeihigaika = pTeihitukeihigaika;
        teihitukeihigaikaValue = null;
        teihitukeihigaikaType  = null;
    }

    transient private BigDecimal teihitukeihigaikaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TEIHITUKEIHIGAIKA, nullable=true)
    protected BigDecimal getTeihitukeihigaikaValue() {
        if (teihitukeihigaikaValue == null && teihitukeihigaika != null) {
            if (teihitukeihigaika.isOptional()) return null;
            return teihitukeihigaika.absolute();
        }
        return teihitukeihigaikaValue;
    }

    protected void setTeihitukeihigaikaValue(BigDecimal value) {
        teihitukeihigaikaValue = value;
        teihitukeihigaika = Optional.fromNullable(toCurrencyType(teihitukeihigaikaType))
            .transform(bizCurrencyTransformer(getTeihitukeihigaikaValue()))
            .orNull();
    }

    transient private String teihitukeihigaikaType = null;

    @Column(name=TEIHITUKEIHIGAIKA + "$", nullable=true)
    protected String getTeihitukeihigaikaType() {
        if (teihitukeihigaikaType == null && teihitukeihigaika != null) return teihitukeihigaika.getType().toString();
        if (teihitukeihigaikaType == null && getTeihitukeihigaikaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'teihitukeihigaika$' should not be NULL."));
        }
        return teihitukeihigaikaType;
    }

    protected void setTeihitukeihigaikaType(String type) {
        teihitukeihigaikaType = type;
        teihitukeihigaika = Optional.fromNullable(toCurrencyType(teihitukeihigaikaType))
            .transform(bizCurrencyTransformer(getTeihitukeihigaikaValue()))
            .orNull();
    }

    private BizCurrency teinkkikingken;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTeinkkikingken() {
        return teinkkikingken;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTeinkkikingken(BizCurrency pTeinkkikingken) {
        teinkkikingken = pTeinkkikingken;
        teinkkikingkenValue = null;
        teinkkikingkenType  = null;
    }

    transient private BigDecimal teinkkikingkenValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TEINKKIKINGKEN, nullable=true)
    protected BigDecimal getTeinkkikingkenValue() {
        if (teinkkikingkenValue == null && teinkkikingken != null) {
            if (teinkkikingken.isOptional()) return null;
            return teinkkikingken.absolute();
        }
        return teinkkikingkenValue;
    }

    protected void setTeinkkikingkenValue(BigDecimal value) {
        teinkkikingkenValue = value;
        teinkkikingken = Optional.fromNullable(toCurrencyType(teinkkikingkenType))
            .transform(bizCurrencyTransformer(getTeinkkikingkenValue()))
            .orNull();
    }

    transient private String teinkkikingkenType = null;

    @Column(name=TEINKKIKINGKEN + "$", nullable=true)
    protected String getTeinkkikingkenType() {
        if (teinkkikingkenType == null && teinkkikingken != null) return teinkkikingken.getType().toString();
        if (teinkkikingkenType == null && getTeinkkikingkenValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'teinkkikingken$' should not be NULL."));
        }
        return teinkkikingkenType;
    }

    protected void setTeinkkikingkenType(String type) {
        teinkkikingkenType = type;
        teinkkikingken = Optional.fromNullable(toCurrencyType(teinkkikingkenType))
            .transform(bizCurrencyTransformer(getTeinkkikingkenValue()))
            .orNull();
    }

    private BizCurrency teinkkikingkgaika;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTeinkkikingkgaika() {
        return teinkkikingkgaika;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTeinkkikingkgaika(BizCurrency pTeinkkikingkgaika) {
        teinkkikingkgaika = pTeinkkikingkgaika;
        teinkkikingkgaikaValue = null;
        teinkkikingkgaikaType  = null;
    }

    transient private BigDecimal teinkkikingkgaikaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TEINKKIKINGKGAIKA, nullable=true)
    protected BigDecimal getTeinkkikingkgaikaValue() {
        if (teinkkikingkgaikaValue == null && teinkkikingkgaika != null) {
            if (teinkkikingkgaika.isOptional()) return null;
            return teinkkikingkgaika.absolute();
        }
        return teinkkikingkgaikaValue;
    }

    protected void setTeinkkikingkgaikaValue(BigDecimal value) {
        teinkkikingkgaikaValue = value;
        teinkkikingkgaika = Optional.fromNullable(toCurrencyType(teinkkikingkgaikaType))
            .transform(bizCurrencyTransformer(getTeinkkikingkgaikaValue()))
            .orNull();
    }

    transient private String teinkkikingkgaikaType = null;

    @Column(name=TEINKKIKINGKGAIKA + "$", nullable=true)
    protected String getTeinkkikingkgaikaType() {
        if (teinkkikingkgaikaType == null && teinkkikingkgaika != null) return teinkkikingkgaika.getType().toString();
        if (teinkkikingkgaikaType == null && getTeinkkikingkgaikaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'teinkkikingkgaika$' should not be NULL."));
        }
        return teinkkikingkgaikaType;
    }

    protected void setTeinkkikingkgaikaType(String type) {
        teinkkikingkgaikaType = type;
        teinkkikingkgaika = Optional.fromNullable(toCurrencyType(teinkkikingkgaikaType))
            .transform(bizCurrencyTransformer(getTeinkkikingkgaikaValue()))
            .orNull();
    }

    private String nenkinkaisigoyoteiriritukbn;

    @Column(name=GenBT_NenkinInfoRendou.NENKINKAISIGOYOTEIRIRITUKBN)
    public String getNenkinkaisigoyoteiriritukbn() {
        return nenkinkaisigoyoteiriritukbn;
    }

    public void setNenkinkaisigoyoteiriritukbn(String pNenkinkaisigoyoteiriritukbn) {
        nenkinkaisigoyoteiriritukbn = pNenkinkaisigoyoteiriritukbn;
    }

    private C_NenkinJimuTesuuryouKbn nenkinjimutesuuryoukbn;

    @Type(type="UserType_C_NenkinJimuTesuuryouKbn")
    @Column(name=GenBT_NenkinInfoRendou.NENKINJIMUTESUURYOUKBN)
    public C_NenkinJimuTesuuryouKbn getNenkinjimutesuuryoukbn() {
        return nenkinjimutesuuryoukbn;
    }

    public void setNenkinjimutesuuryoukbn(C_NenkinJimuTesuuryouKbn pNenkinjimutesuuryoukbn) {
        nenkinjimutesuuryoukbn = pNenkinjimutesuuryoukbn;
    }

    private C_NenreiCalcKbn nenreicalckbn;

    @Type(type="UserType_C_NenreiCalcKbn")
    @Column(name=GenBT_NenkinInfoRendou.NENREICALCKBN)
    public C_NenreiCalcKbn getNenreicalckbn() {
        return nenreicalckbn;
    }

    public void setNenreicalckbn(C_NenreiCalcKbn pNenreicalckbn) {
        nenreicalckbn = pNenreicalckbn;
    }

    private BizCurrency tyoukankseigk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTyoukankseigk() {
        return tyoukankseigk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyoukankseigk(BizCurrency pTyoukankseigk) {
        tyoukankseigk = pTyoukankseigk;
        tyoukankseigkValue = null;
        tyoukankseigkType  = null;
    }

    transient private BigDecimal tyoukankseigkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TYOUKANKSEIGK, nullable=true)
    protected BigDecimal getTyoukankseigkValue() {
        if (tyoukankseigkValue == null && tyoukankseigk != null) {
            if (tyoukankseigk.isOptional()) return null;
            return tyoukankseigk.absolute();
        }
        return tyoukankseigkValue;
    }

    protected void setTyoukankseigkValue(BigDecimal value) {
        tyoukankseigkValue = value;
        tyoukankseigk = Optional.fromNullable(toCurrencyType(tyoukankseigkType))
            .transform(bizCurrencyTransformer(getTyoukankseigkValue()))
            .orNull();
    }

    transient private String tyoukankseigkType = null;

    @Column(name=TYOUKANKSEIGK + "$", nullable=true)
    protected String getTyoukankseigkType() {
        if (tyoukankseigkType == null && tyoukankseigk != null) return tyoukankseigk.getType().toString();
        if (tyoukankseigkType == null && getTyoukankseigkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tyoukankseigk$' should not be NULL."));
        }
        return tyoukankseigkType;
    }

    protected void setTyoukankseigkType(String type) {
        tyoukankseigkType = type;
        tyoukankseigk = Optional.fromNullable(toCurrencyType(tyoukankseigkType))
            .transform(bizCurrencyTransformer(getTyoukankseigkValue()))
            .orNull();
    }

    private BizCurrency ksnnkgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKsnnkgk() {
        return ksnnkgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKsnnkgk(BizCurrency pKsnnkgk) {
        ksnnkgk = pKsnnkgk;
        ksnnkgkValue = null;
        ksnnkgkType  = null;
    }

    transient private BigDecimal ksnnkgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KSNNKGK, nullable=true)
    protected BigDecimal getKsnnkgkValue() {
        if (ksnnkgkValue == null && ksnnkgk != null) {
            if (ksnnkgk.isOptional()) return null;
            return ksnnkgk.absolute();
        }
        return ksnnkgkValue;
    }

    protected void setKsnnkgkValue(BigDecimal value) {
        ksnnkgkValue = value;
        ksnnkgk = Optional.fromNullable(toCurrencyType(ksnnkgkType))
            .transform(bizCurrencyTransformer(getKsnnkgkValue()))
            .orNull();
    }

    transient private String ksnnkgkType = null;

    @Column(name=KSNNKGK + "$", nullable=true)
    protected String getKsnnkgkType() {
        if (ksnnkgkType == null && ksnnkgk != null) return ksnnkgk.getType().toString();
        if (ksnnkgkType == null && getKsnnkgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'ksnnkgk$' should not be NULL."));
        }
        return ksnnkgkType;
    }

    protected void setKsnnkgkType(String type) {
        ksnnkgkType = type;
        ksnnkgk = Optional.fromNullable(toCurrencyType(ksnnkgkType))
            .transform(bizCurrencyTransformer(getKsnnkgkValue()))
            .orNull();
    }

    private BizCurrency ksnnkkkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKsnnkkkngk() {
        return ksnnkkkngk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKsnnkkkngk(BizCurrency pKsnnkkkngk) {
        ksnnkkkngk = pKsnnkkkngk;
        ksnnkkkngkValue = null;
        ksnnkkkngkType  = null;
    }

    transient private BigDecimal ksnnkkkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KSNNKKKNGK, nullable=true)
    protected BigDecimal getKsnnkkkngkValue() {
        if (ksnnkkkngkValue == null && ksnnkkkngk != null) {
            if (ksnnkkkngk.isOptional()) return null;
            return ksnnkkkngk.absolute();
        }
        return ksnnkkkngkValue;
    }

    protected void setKsnnkkkngkValue(BigDecimal value) {
        ksnnkkkngkValue = value;
        ksnnkkkngk = Optional.fromNullable(toCurrencyType(ksnnkkkngkType))
            .transform(bizCurrencyTransformer(getKsnnkkkngkValue()))
            .orNull();
    }

    transient private String ksnnkkkngkType = null;

    @Column(name=KSNNKKKNGK + "$", nullable=true)
    protected String getKsnnkkkngkType() {
        if (ksnnkkkngkType == null && ksnnkkkngk != null) return ksnnkkkngk.getType().toString();
        if (ksnnkkkngkType == null && getKsnnkkkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'ksnnkkkngk$' should not be NULL."));
        }
        return ksnnkkkngkType;
    }

    protected void setKsnnkkkngkType(String type) {
        ksnnkkkngkType = type;
        ksnnkkkngk = Optional.fromNullable(toCurrencyType(ksnnkkkngkType))
            .transform(bizCurrencyTransformer(getKsnnkkkngkValue()))
            .orNull();
    }

    private C_NkzeiseiKbn nkzeiseikbn;

    @Type(type="UserType_C_NkzeiseiKbn")
    @Column(name=GenBT_NenkinInfoRendou.NKZEISEIKBN)
    public C_NkzeiseiKbn getNkzeiseikbn() {
        return nkzeiseikbn;
    }

    public void setNkzeiseikbn(C_NkzeiseiKbn pNkzeiseikbn) {
        nkzeiseikbn = pNkzeiseikbn;
    }

    private BizCurrency kykkstkkn;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKykkstkkn() {
        return kykkstkkn;
    }

    public void setKykkstkkn(BizCurrency pKykkstkkn) {
        kykkstkkn = pKykkstkkn;
        kykkstkknValue = null;
        kykkstkknType  = null;
    }

    transient private BigDecimal kykkstkknValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KYKKSTKKN, nullable=true)
    protected BigDecimal getKykkstkknValue() {
        if (kykkstkknValue == null && kykkstkkn != null) {
            if (kykkstkkn.isOptional()) return null;
            return kykkstkkn.absolute();
        }
        return kykkstkknValue;
    }

    protected void setKykkstkknValue(BigDecimal value) {
        kykkstkknValue = value;
        kykkstkkn = Optional.fromNullable(toCurrencyType(kykkstkknType))
            .transform(bizCurrencyTransformer(getKykkstkknValue()))
            .orNull();
    }

    transient private String kykkstkknType = null;

    @Column(name=KYKKSTKKN + "$", nullable=true)
    protected String getKykkstkknType() {
        if (kykkstkknType == null && kykkstkkn != null) return kykkstkkn.getType().toString();
        if (kykkstkknType == null && getKykkstkknValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kykkstkkn$' should not be NULL."));
        }
        return kykkstkknType;
    }

    protected void setKykkstkknType(String type) {
        kykkstkknType = type;
        kykkstkkn = Optional.fromNullable(toCurrencyType(kykkstkknType))
            .transform(bizCurrencyTransformer(getKykkstkknValue()))
            .orNull();
    }

    private BizCurrency jhurikstkkn;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getJhurikstkkn() {
        return jhurikstkkn;
    }

    public void setJhurikstkkn(BizCurrency pJhurikstkkn) {
        jhurikstkkn = pJhurikstkkn;
        jhurikstkknValue = null;
        jhurikstkknType  = null;
    }

    transient private BigDecimal jhurikstkknValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=JHURIKSTKKN, nullable=true)
    protected BigDecimal getJhurikstkknValue() {
        if (jhurikstkknValue == null && jhurikstkkn != null) {
            if (jhurikstkkn.isOptional()) return null;
            return jhurikstkkn.absolute();
        }
        return jhurikstkknValue;
    }

    protected void setJhurikstkknValue(BigDecimal value) {
        jhurikstkknValue = value;
        jhurikstkkn = Optional.fromNullable(toCurrencyType(jhurikstkknType))
            .transform(bizCurrencyTransformer(getJhurikstkknValue()))
            .orNull();
    }

    transient private String jhurikstkknType = null;

    @Column(name=JHURIKSTKKN + "$", nullable=true)
    protected String getJhurikstkknType() {
        if (jhurikstkknType == null && jhurikstkkn != null) return jhurikstkkn.getType().toString();
        if (jhurikstkknType == null && getJhurikstkknValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'jhurikstkkn$' should not be NULL."));
        }
        return jhurikstkknType;
    }

    protected void setJhurikstkknType(String type) {
        jhurikstkknType = type;
        jhurikstkkn = Optional.fromNullable(toCurrencyType(jhurikstkknType))
            .transform(bizCurrencyTransformer(getJhurikstkknValue()))
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

    private C_NkHaitoukinuketorihouKbn nkhaitoukinuketorihoukbn;

    @Type(type="UserType_C_NkHaitoukinuketorihouKbn")
    @Column(name=GenBT_NenkinInfoRendou.NKHAITOUKINUKETORIHOUKBN)
    public C_NkHaitoukinuketorihouKbn getNkhaitoukinuketorihoukbn() {
        return nkhaitoukinuketorihoukbn;
    }

    public void setNkhaitoukinuketorihoukbn(C_NkHaitoukinuketorihouKbn pNkhaitoukinuketorihoukbn) {
        nkhaitoukinuketorihoukbn = pNkhaitoukinuketorihoukbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenBT_NenkinInfoRendou.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBT_NenkinInfoRendou.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBT_NenkinInfoRendou.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}