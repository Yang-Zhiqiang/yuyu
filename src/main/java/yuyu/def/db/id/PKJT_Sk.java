package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.mapping.GenJT_Sk;
import yuyu.def.db.meta.GenQJT_Sk;
import yuyu.def.db.meta.QJT_Sk;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 請求テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_Sk}</td><td colspan="3">請求テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syoruiukeymd</td><td>書類受付日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hubikanryouymd</td><td>不備完了日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>seikyuusyakbn</td><td>請求者区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SeikyuusyaKbn C_SeikyuusyaKbn}</td></tr>
 *  <tr><td>syuhiyouhi</td><td>守秘要否</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyuhiYouhi C_SyuhiYouhi}</td></tr>
 *  <tr><td>seikyuusyanmkn</td><td>請求者（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>seikyuusyanmkj</td><td>請求者（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>seikyuusyaseiymd</td><td>請求者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>seikyuusyasei</td><td>請求者性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Seibetu C_Seibetu}</td></tr>
 *  <tr><td>sihonninkakninkbn</td><td>保険金本人確認結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SiHonninKakninKekkaKbn C_SiHonninKakninKekkaKbn}</td></tr>
 *  <tr><td>seikyuusyatdk</td><td>請求者続柄</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tdk C_Tdk}</td></tr>
 *  <tr><td>sbjishrkbn</td><td>死亡時支払区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SbjiShrKbn C_SbjiShrKbn}</td></tr>
 *  <tr><td>uktkyksyatdk</td><td>受取人契約者続柄</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UktKyksyaTdk C_UktKyksyaTdk}</td></tr>
 *  <tr><td>souhusakikbn</td><td>送付先区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SouhusakiKbn C_SouhusakiKbn}</td></tr>
 *  <tr><td>tsinyno</td><td>通信先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr1kj</td><td>通信先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr2kj</td><td>通信先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr3kj</td><td>通信先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsintelno</td><td>通信先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>saikennmkj</td><td>債権者氏名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>saikennyno</td><td>債権者郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>saikenadr1kj</td><td>債権者住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>saikenadr2kj</td><td>債権者住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>saikenadr3kj</td><td>債権者住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>skskknnmkn</td><td>親権者後見人名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>skskknnmkj</td><td>親権者後見人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>skskknsyubetu</td><td>親権者後見人種別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SkskknsyubetuKbn C_SkskknsyubetuKbn}</td></tr>
 *  <tr><td>soukinsakikbn</td><td>送金先区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SoukinsakiKbn C_SoukinsakiKbn}</td></tr>
 *  <tr><td>inputshrhousiteikbn</td><td>入力用支払方法指定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_InputShrhousiteiKbn C_InputShrhousiteiKbn}</td></tr>
 *  <tr><td>bankcd</td><td>銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitencd</td><td>支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yokinkbn</td><td>預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YokinKbn C_YokinKbn}</td></tr>
 *  <tr><td>kouzano</td><td>口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzdoukbn</td><td>口座名義人同一区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kzdou C_Kzdou}</td></tr>
 *  <tr><td>kzmeiginmkn</td><td>口座名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>suketorihouhoukbn</td><td>保険金受取方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SUketoriHouhouKbn C_SUketoriHouhouKbn}</td></tr>
 *  <tr><td>siharaituukakbn</td><td>支払通貨区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SiharaiTuukaKbn C_SiharaiTuukaKbn}</td></tr>
 *  <tr><td>nstkhukaumukbn</td><td>年金支払特約付加有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tkhukaumu C_Tkhukaumu}</td></tr>
 *  <tr><td>nkkknjyutougk</td><td>年金基金充当金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>sateikaksaigaikanouseikbn</td><td>査定回送要否確認（災害可能性）区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sateikakmeigihnkkbn</td><td>査定回送要否確認（名義変更査定）区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YouhiKbn C_YouhiKbn}</td></tr>
 *  <tr><td>sateikakkaigaisbkbn</td><td>査定回送要否確認（海外死亡）区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sateikakhusyousikbn</td><td>査定回送要否確認（不詳の死）区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sateikakkaigaikbn</td><td>査定回送要否確認（海外）区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>shrdtlsyooutkbn</td><td>支払明細書出力区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KanryotuutioutKbn C_KanryotuutioutKbn}</td></tr>
 *  <tr><td>hassoukbn</td><td>発送区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HassouKbn C_HassouKbn}</td></tr>
 *  <tr><td>uktmnmeigibangou</td><td>受取人ＭＮ名義番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykmnmeigibangou</td><td>契約者ＭＮ名義番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siinkbn</td><td>死因区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SiinKbn C_SiinKbn}</td></tr>
 *  <tr><td>misyuupjyuutouym</td><td>未収保険料充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>misyuupjyuutoukaisuuy</td><td>未収保険料充当回数（年）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>misyuupjyuutoukaisuum</td><td>未収保険料充当回数（月）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>saigaimousideumukbn</td><td>災害申出有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BlnktkumuKbn C_BlnktkumuKbn}</td></tr>
 *  <tr><td>sindansyoryoushryouhikbn</td><td>診断書料支払要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SindansyoRyouShrYouhiKbn C_SindansyoRyouShrYouhiKbn}</td></tr>
 *  <tr><td>sindansyomaisuu</td><td>診断書枚数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>sinsagendokknkbn</td><td>審査限度期間区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SinsaGendoKknKbn C_SinsaGendoKknKbn}</td></tr>
 *  <tr><td>rikoukityuutuudannissuu</td><td>履行期中断日数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tienrisokukisanymd</td><td>遅延利息起算日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>tienrsknissuu</td><td>遅延利息日数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kyktuukasyu</td><td>契約通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>shrtuukasyu</td><td>支払通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>shrkwsratekjnymd</td><td>支払時為替レート基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>shrkwsrate</td><td>支払時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zeimukwsratekjnymd</td><td>税務用為替レート基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>zeimukwsrate</td><td>税務用為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>gaikaknsnkwsratekjymd</td><td>外貨換算為替レート基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gaikaknsnkwsrate</td><td>外貨換算為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>shrgk</td><td>支払金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kyhkngkgoukei</td><td>給付金額合計</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hokenkngkgoukei</td><td>保険金額合計</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>haitoukin</td><td>配当金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>sonotahaitoukin</td><td>その他配当金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>misyuup</td><td>未収保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mikeikap</td><td>未経過保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>zennouseisankgk</td><td>前納精算金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>azukarikingk</td><td>預り金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>sonotaseisangk</td><td>その他精算額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>krkgk</td><td>仮受金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>shrtienrsk</td><td>支払遅延利息</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenshrgk</td><td>円換算支払金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkyhgkgoukei</td><td>円換算給付金額合計</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenhkgkgoukei</td><td>円換算保険金額合計</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkahaitoukin</td><td>円貨配当金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkasonotahaitoukin</td><td>円貨その他配当金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkamisyuup</td><td>円貨未収保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkamikeikap</td><td>円貨未経過保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkazennouseisankgk</td><td>円貨前納精算金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkaazukarikingk</td><td>円貨預り金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkasonotaseisangk</td><td>円貨その他精算額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkakrkgk</td><td>円貨仮受金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenshrtienrsk</td><td>円換算支払遅延利息</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>zitkazukarikingksiteituuka</td><td>税適預り金額（指定通貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>zitkazukarikingkyen</td><td>税適預り金額（円貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gaikaknsntkgk</td><td>外貨換算対象金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gaikaknsnkekkakgk</td><td>外貨換算結果金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkaknsntkgk</td><td>円貨換算対象金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkaknsnkekkakgk</td><td>円貨換算結果金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>misyuusyonendojikaiikoup</td><td>未収初年度次回以降Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>misyuujinendoikoup</td><td>未収次年度以降Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>pmkouryokuhasseiymd</td><td>Ｐ免効力発生日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>mikeikapjyuutouym</td><td>未経過保険料充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>mikeikapjyuutoukaisuuy</td><td>未経過保険料充当回数（年）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>mikeikapjyuutoukaisuum</td><td>未経過保険料充当回数（月）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tokusyushrkbn</td><td>特殊支払区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>firstgansindankyhkbn</td><td>初回がん診断給付区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_FirstGanSindanKyhKbn C_FirstGanSindanKyhKbn}</td></tr>
 *  <tr><td>goukeihituyoukeihi</td><td>合計必要経費</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kykhnkkaisuu</td><td>契約者変更回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>shrkykhtykeihi</td><td>支払時契約者必要経費</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kijitumitouraimikeikap</td><td>期日未到来未経過保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kyhknshrtyousyomisyuup</td><td>給付金支払調書未収保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kyhknshrtyousyomikeikap</td><td>給付金支払調書未経過保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kyhknshrtysykjtmitrmikeikap</td><td>給付金支払調書期日未到来未経過保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>vhtnaiteikakuteikbn</td><td>（配当金情報）内定確定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NaiteiKakuteiKbn C_NaiteiKakuteiKbn}</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_Sk
 * @see     GenJT_Sk
 * @see     QJT_Sk
 * @see     GenQJT_Sk
 */
public class PKJT_Sk extends AbstractExDBPrimaryKey<JT_Sk, PKJT_Sk> {

    private static final long serialVersionUID = 1L;

    public PKJT_Sk() {
    }

    public PKJT_Sk(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino
    ) {
        skno = pSkno;
        syono = pSyono;
        seikyuurirekino = pSeikyuurirekino;
    }

    @Transient
    @Override
    public Class<JT_Sk> getEntityClass() {
        return JT_Sk.class;
    }

    private String skno;

    public String getSkno() {
        return skno;
    }

    public void setSkno(String pSkno) {
        skno = pSkno;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private Integer seikyuurirekino;

    public Integer getSeikyuurirekino() {
        return seikyuurirekino;
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        seikyuurirekino = pSeikyuurirekino;
    }

}