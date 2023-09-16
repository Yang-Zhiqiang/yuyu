package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BT_NenkinInfoRendou;
import yuyu.def.db.mapping.GenBT_NenkinInfoRendou;
import yuyu.def.db.meta.GenQBT_NenkinInfoRendou;
import yuyu.def.db.meta.QBT_NenkinInfoRendou;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 年金情報連動テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_NenkinInfoRendou}</td><td colspan="3">年金情報連動テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>nksysynonosaibanyhkbn</td><td>年金証書番号採番要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YouhiKbn C_YouhiKbn}</td></tr>
 *  <tr><td>datatorikomikbn</td><td>データ取込区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DatatorikomiKbn C_DatatorikomiKbn}</td></tr>
 *  <tr><td>firstmiseikyuukbn</td><td>初回年金未請求区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_FirstmiseikyuuKbn C_FirstmiseikyuuKbn}</td></tr>
 *  <tr><td>suketorihouhoukbn</td><td>保険金受取方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SUketoriHouhouKbn C_SUketoriHouhouKbn}</td></tr>
 *  <tr><td>hukusuuuketoriflg</td><td>複数受取フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>nkkknsetymd</td><td>年金基金設定日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nkshrstartymd</td><td>年金支払開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>bnshrkaisuu</td><td>分割支払回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Bnshrkaisuu C_Bnshrkaisuu}</td></tr>
 *  <tr><td>nkukthou</td><td>年金受取方法</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Nkukthou C_Nkukthou}</td></tr>
 *  <tr><td>nkshrhsijiyuu</td><td>年金支払発生事由</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Nkshrhsijiyuu C_Nkshrhsijiyuu}</td></tr>
 *  <tr><td>nkshrtkykjkghkkbn</td><td>年金支払特約事故後付加区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hknhouskkbn</td><td>保険法施行区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HknhouskKbn C_HknhouskKbn}</td></tr>
 *  <tr><td>motosyono</td><td>元証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhncd</td><td>商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnsdno</td><td>商品世代番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>aisyoumeikbn</td><td>愛称名区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AisyoumeiKbn C_AisyoumeiKbn}</td></tr>
 *  <tr><td>hrkkaisuu</td><td>払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>oyadairitencd1</td><td>親代理店コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dairitencd1</td><td>代理店コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bosyuucd1</td><td>募集人コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dairitenbuntanwariai1</td><td>代理店分担割合１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>oyadairitencd2</td><td>親代理店コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dairitencd2</td><td>代理店コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bosyuucd2</td><td>募集人コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dairitenbuntanwariai2</td><td>代理店分担割合２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>drtenkanrisosikicd1</td><td>代理店管理組織コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtenkanritodoufukencd</td><td>代理店管理都道府県コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>cifcd</td><td>ＣＩＦコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zeitratkikbn</td><td>税取扱区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ZeitratkiKbn C_ZeitratkiKbn}</td></tr>
 *  <tr><td>kyknmkn</td><td>契約者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknmkj</td><td>契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykadr</td><td>契約者住所</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnmkn</td><td>被保険者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnmkj</td><td>被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknseiymd</td><td>被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hhknnen</td><td>被保険者年齢</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hhknsei</td><td>被保険者性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hhknsei C_Hhknsei}</td></tr>
 *  <tr><td>hhknadrkj</td><td>被保険者住所（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknsakuinmeino</td><td>被保険者索引名番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uktnmkn</td><td>受取人名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uktnmkj</td><td>受取人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>keiukedoukbn</td><td>契受同一区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KeiukeDouKbn C_KeiukeDouKbn}</td></tr>
 *  <tr><td>ukehidouitukbn</td><td>受被同一区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UkehiDouKbn C_UkehiDouKbn}</td></tr>
 *  <tr><td>uktseiymd</td><td>受取人生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>uktsei</td><td>受取人性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Uktsei C_Uktsei}</td></tr>
 *  <tr><td>tsinyno</td><td>通信先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr1kj</td><td>通信先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr2kj</td><td>通信先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr3kj</td><td>通信先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsintelno</td><td>通信先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kgkyojusikibetukbn</td><td>海外居住者識別区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KgkyojusikibetuKbn C_KgkyojusikibetuKbn}</td></tr>
 *  <tr><td>nkuktsakuinnmno</td><td>年金受取人索引名番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>skskknnmkn</td><td>親権者後見人名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>skskknnmkj</td><td>親権者後見人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>skskknsyubetu</td><td>親権者後見人種別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SkskknsyubetuKbn C_SkskknsyubetuKbn}</td></tr>
 *  <tr><td>shrhou</td><td>支払方法</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Shrhou C_Shrhou}</td></tr>
 *  <tr><td>bankcd</td><td>銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitencd</td><td>支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yokinkbn</td><td>預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YokinKbn C_YokinKbn}</td></tr>
 *  <tr><td>kouzano</td><td>口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzmeiginmkn</td><td>口座名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>seisikakymd</td><td>生死確認日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>seikyuunaiyou</td><td>請求内容</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Seikyuunaiyou C_Seikyuunaiyou}</td></tr>
 *  <tr><td>shrhousiteikbn</td><td>支払方法指定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ShrhousiteiKbn C_ShrhousiteiKbn}</td></tr>
 *  <tr><td>syoruiukeymd</td><td>書類受付日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sinsagendokknkbn</td><td>審査限度期間区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SinsaGendoKknKbn C_SinsaGendoKknKbn}</td></tr>
 *  <tr><td>rikoukityuutuudannissuu</td><td>履行期中断日数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>yenshrtkumukbn</td><td>円支払特約有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>keizknenkinuktsiteitk</td><td>継続年金受取人指定特約</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>keizknenkinuktkbn</td><td>継続年金受取人区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UktKbn C_UktKbn}</td></tr>
 *  <tr><td>keizknenkinuktnmkana</td><td>継続年金受取人名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>keizknenkinuktnmkanji</td><td>継続年金受取人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>keizknenkiuktseiymd</td><td>継続年金受取人生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>stdrsktky</td><td>指定代理請求特約</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>stdrsktkyhkymd</td><td>指定代理請求特約付加日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>stdrskstkbn</td><td>指定代理請求人指定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_StdrskstKbn C_StdrskstKbn}</td></tr>
 *  <tr><td>stdrsknmkn</td><td>指定代理請求人名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stdrsknmkj</td><td>指定代理請求人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stdruktkbn</td><td>指定代理受取人区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UktKbn C_UktKbn}</td></tr>
 *  <tr><td>kktyuitakbn</td><td>契約管理注意取扱区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KktyuitaKbn C_KktyuitaKbn}</td></tr>
 *  <tr><td>nkttdktyuuinaiyou1</td><td>年金手続注意内容１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkttdktyuuinaiyou2</td><td>年金手続注意内容２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkttdktyuuinaiyou3</td><td>年金手続注意内容３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkttdktyuuinaiyou4</td><td>年金手続注意内容４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkttdktyuuinaiyou5</td><td>年金手続注意内容５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkttdktyuuinaiyou6</td><td>年金手続注意内容６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkttdktyuuinaiyou7</td><td>年金手続注意内容７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkttdktyuuinaiyou8</td><td>年金手続注意内容８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkttdktyuuinaiyou9</td><td>年金手続注意内容９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkttdktyuuinaiyou10</td><td>年金手続注意内容１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkttdktyuuinaiyou11</td><td>年金手続注意内容１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkttdktyuuinaiyou12</td><td>年金手続注意内容１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkttdktyuuinaiyou13</td><td>年金手続注意内容１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkttdktyuuinaiyou14</td><td>年金手続注意内容１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkttdktyuuinaiyou15</td><td>年金手続注意内容１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkttdktyuuinaiyou16</td><td>年金手続注意内容１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkttdktyuuinaiyou17</td><td>年金手続注意内容１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkttdktyuuinaiyou18</td><td>年金手続注意内容１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>teisyutkykbn</td><td>定額年金主契約特約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyutkKbn C_SyutkKbn}</td></tr>
 *  <tr><td>teinksyu</td><td>定額年金年金種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>teinksyuruiversion</td><td>定額年金年金種類バージョン</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nenkinkigousedaikbn</td><td>年金記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NenkinKigouSedaiKbn C_NenkinKigouSedaiKbn}</td></tr>
 *  <tr><td>teinkspan</td><td>定額年金年金期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyktuukasyu</td><td>契約通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>teikihongk</td><td>定額年金基本年金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>teihitukeihiyen</td><td>定額年金必要経費（円貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>teihitukeihigaika</td><td>定額年金必要経費（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>teinkkikingken</td><td>定額年金年金基金額（円貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>teinkkikingkgaika</td><td>定額年金年金基金額（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>nenkinkaisigoyoteiriritukbn</td><td>年金開始後予定利率区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nenkinjimutesuuryoukbn</td><td>年金事務手数料区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NenkinJimuTesuuryouKbn C_NenkinJimuTesuuryouKbn}</td></tr>
 *  <tr><td>nenreicalckbn</td><td>年齢計算区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NenreiCalcKbn C_NenreiCalcKbn}</td></tr>
 *  <tr><td>tyoukankseigk</td><td>超過年金精算額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>ksnnkgk</td><td>加算年金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>ksnnkkkngk</td><td>加算年金基金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>nkzeiseikbn</td><td>年金税制区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NkzeiseiKbn C_NkzeiseiKbn}</td></tr>
 *  <tr><td>kykkstkkn</td><td>契約者貸付金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>jhurikstkkn</td><td>自動振替貸付金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>misyuup</td><td>未収保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>nkhaitoukinuketorihoukbn</td><td>年金配当金受取方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NkHaitoukinuketorihouKbn C_NkHaitoukinuketorihouKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_NenkinInfoRendou
 * @see     GenBT_NenkinInfoRendou
 * @see     QBT_NenkinInfoRendou
 * @see     GenQBT_NenkinInfoRendou
 */
public class PKBT_NenkinInfoRendou extends AbstractExDBPrimaryKey<BT_NenkinInfoRendou, PKBT_NenkinInfoRendou> {

    private static final long serialVersionUID = 1L;

    public PKBT_NenkinInfoRendou() {
    }

    public PKBT_NenkinInfoRendou(
        BizDate pSyoriYmd,
        String pSyono,
        Integer pRenno
    ) {
        syoriYmd = pSyoriYmd;
        syono = pSyono;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<BT_NenkinInfoRendou> getEntityClass() {
        return BT_NenkinInfoRendou.class;
    }

    private BizDate syoriYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}