package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.mapping.GenHT_SyoriCTL;
import yuyu.def.db.meta.GenQHT_SyoriCTL;
import yuyu.def.db.meta.QHT_SyoriCTL;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 処理コントロールテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SyoriCTL}</td><td colspan="3">処理コントロールテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kaisyacd</td><td>会社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mosuketukekbn</td><td>申込受付区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MosUketukeKbn C_MosUketukeKbn}</td></tr>
 *  <tr><td>mosuktkerrkbn</td><td>申込受付エラー区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MosUktkErrKbn C_MosUktkErrKbn}</td></tr>
 *  <tr><td>skeijimukbn</td><td>新契約事務区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SkeijimuKbn C_SkeijimuKbn}</td></tr>
 *  <tr><td>mosnrkumu</td><td>申込書入力有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>mosnrkvrfjkkbn</td><td>申込書入力ベリファイ状況区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_VrfjkKbn C_VrfjkKbn}</td></tr>
 *  <tr><td>mosnrkymd</td><td>申込書入力日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kznrkumu</td><td>口座情報入力有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kznrkhbumu</td><td>口座情報入力不備有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kznrkvrfjkkbn</td><td>口座情報入力ベリファイ状況区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_VrfjkKbn C_VrfjkKbn}</td></tr>
 *  <tr><td>dntnrkumu</td><td>団体承認書入力有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sdnnrkumu</td><td>集団扱加入申込書入力有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kktnrkumu</td><td>告知書入力有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kktnrkhbumu</td><td>告知書入力不備有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kktnrkvrfjkkbn</td><td>告知書入力ベリファイ状況区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_VrfjkKbn C_VrfjkKbn}</td></tr>
 *  <tr><td>kktymd</td><td>告知日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hjynrkumu</td><td>報状入力有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>hjynrkhbumu</td><td>報状入力不備有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>nyknnrkumu</td><td>入金入力有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>nyuukinjoutaikbn</td><td>入金状態区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NyuukinjyoutaiKbn C_NyuukinjyoutaiKbn}</td></tr>
 *  <tr><td>ryosyuymd</td><td>領収日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nyknkwsratekijyunymd</td><td>入金用為替レート基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nyknkwsrate</td><td>入金用為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>authorikakymd</td><td>オーソリ確認日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>uriagesousinkbn</td><td>売上送信区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UriagesousinKbn C_UriagesousinKbn}</td></tr>
 *  <tr><td>credittrkjkkbn</td><td>クレジットカード登録状況区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_CreditTrkjkKbn C_CreditTrkjkKbn}</td></tr>
 *  <tr><td>credityuukoukakkbn</td><td>クレジットカード有効確認区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_CreditYuukoukakKbn C_CreditYuukoukakKbn}</td></tr>
 *  <tr><td>mostenken1jiyhkbn</td><td>申込点検（１次）要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MostenkenyhKbn C_MostenkenyhKbn}</td></tr>
 *  <tr><td>mostenken2jiyhkbn</td><td>申込点検（２次）要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MostenkenyhKbn C_MostenkenyhKbn}</td></tr>
 *  <tr><td>mostenken3jiyhkbn</td><td>申込点検（３次）要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MostenkenyhKbn C_MostenkenyhKbn}</td></tr>
 *  <tr><td>mostenkenrrkumu</td><td>申込点検履歴有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>mostenkenjoukbn</td><td>申込点検状態区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MostenkenjyouKbn C_MostenkenjyouKbn}</td></tr>
 *  <tr><td>knkysatei1jiyhkbn</td><td>環境査定（１次）要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Knkysatei1jiyhKbn C_Knkysatei1jiyhKbn}</td></tr>
 *  <tr><td>knkysatei2jiyhkbn</td><td>環境査定（２次）要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Knkysatei2jiyhKbn C_Knkysatei2jiyhKbn}</td></tr>
 *  <tr><td>knkysateirrkumu</td><td>環境査定履歴有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>knkysateijyoukbn</td><td>環境査定状態区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KnkysateijyouKbn C_KnkysateijyouKbn}</td></tr>
 *  <tr><td>imusateikaniyhkbn</td><td>医務査定（簡易）要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ImusateikaniyhKbn C_ImusateikaniyhKbn}</td></tr>
 *  <tr><td>imusateirrkumu</td><td>医務査定履歴有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>imusateijyoukbn</td><td>医務査定状態区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ImusateijyouKbn C_ImusateijyouKbn}</td></tr>
 *  <tr><td>mihassinhubiumu</td><td>未発信不備有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>hubikaisyoujoutaikbn</td><td>不備解消状態区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HubikaisyoujoutaiKbn C_HubikaisyoujoutaiKbn}</td></tr>
 *  <tr><td>kthhbkbn</td><td>決定保留不備区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>srhhbkbn</td><td>成立保留不備区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>khnhbkbn</td><td>基本不備区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kykkakjkkbn</td><td>契約確認状況区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KykkakjkKbn C_KykkakjkKbn}</td></tr>
 *  <tr><td>ketteikbn</td><td>決定状態区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KetteiKbn C_KetteiKbn}</td></tr>
 *  <tr><td>sateijtkbn</td><td>査定状態区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SateijtKbn C_SateijtKbn}</td></tr>
 *  <tr><td>sateizumiymd</td><td>査定済日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>doujimosumu</td><td>同時申込有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>paldoujimosumu</td><td>ＰＡＬ同時申込有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>raydoujimosumu</td><td>ＲＡＹ同時申込有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>lincgthtkekkbn</td><td>ＬＩＮＣ該当判定結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_LincgthtkekKbn C_LincgthtkekKbn}</td></tr>
 *  <tr><td>lincjkkbn</td><td>ＬＩＮＣ状況区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_LincjkKbn C_LincjkKbn}</td></tr>
 *  <tr><td>lincsousinflg</td><td>ＬＩＮＣ送信済フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Lincsousinflg C_Lincsousinflg}</td></tr>
 *  <tr><td>linckknnjkkbn</td><td>ＬＩＮＣ確認状況区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_LinckknnjkKbn C_LinckknnjkKbn}</td></tr>
 *  <tr><td>lincdatasousinkbn</td><td>ＬＩＮＣデータ送信区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_LincdatasousinKbn C_LincdatasousinKbn}</td></tr>
 *  <tr><td>uktkakkbn</td><td>受取人確認区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UktkakKbn C_UktkakKbn}</td></tr>
 *  <tr><td>tkhjnkbn</td><td>特定関係法人区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TkhjnKbn C_TkhjnKbn}</td></tr>
 *  <tr><td>tktkhjnkakuninyouhikbn</td><td>特定関係法人確認要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YouhiKbn C_YouhiKbn}</td></tr>
 *  <tr><td>kouseiinkykkbn</td><td>構成員契約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KouseiinkykKbn C_KouseiinkykKbn}</td></tr>
 *  <tr><td>koukankykkbn</td><td>交換契約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KoukankykKbn C_KoukankykKbn}</td></tr>
 *  <tr><td>fatcakakkekkakbn</td><td>ＦＡＴＣＡ確認結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_FatcakakkekkaKbn C_FatcakakkekkaKbn}</td></tr>
 *  <tr><td>aeoikekkakbn</td><td>ＡＥＯＩ結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AeoiKekkaKbn C_AeoiKekkaKbn}</td></tr>
 *  <tr><td>tkhsyouryakuumukbn</td><td>通計保留省略有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kykksktkankbn</td><td>契約者強制決定判定完了区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KsktkanKbn C_KsktkanKbn}</td></tr>
 *  <tr><td>hhknksktkankbn</td><td>被保険者強制決定判定完了区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KsktkanKbn C_KsktkanKbn}</td></tr>
 *  <tr><td>seiritukbn</td><td>成立区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SeirituKbn C_SeirituKbn}</td></tr>
 *  <tr><td>srsyoriymd</td><td>成立処理日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>minyknkurikosiumu</td><td>未入金繰越有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kettienkurikosiumu</td><td>決定遅延繰越有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>srhkurikosiumu</td><td>成立保留繰越有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>daimosno</td><td>代表申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mfrenflg</td><td>ＭＦ連動済フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Mfrenflg C_Mfrenflg}</td></tr>
 *  <tr><td>mfrenymd</td><td>ＭＦ連動日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>jimusrhkbn</td><td>事務成立保留区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_JimusrhKbn C_JimusrhKbn}</td></tr>
 *  <tr><td>syssrhkbn</td><td>システム成立保留区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyssrhKbn C_SyssrhKbn}</td></tr>
 *  <tr><td>annaisakuseikbn</td><td>送付案内作成状況区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TyhysakuseiKbn C_TyhysakuseiKbn}</td></tr>
 *  <tr><td>annaikaisuu</td><td>案内回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tkbtkktumu</td><td>特別告知有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kansyoutuutiyhkbn</td><td>勧奨通知作成要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YouhiKbn C_YouhiKbn}</td></tr>
 *  <tr><td>lastkossyoricd</td><td>最終更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yoteirirituhenkourenrakuymd</td><td>予定利率変更連絡日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     HT_SyoriCTL
 * @see     GenHT_SyoriCTL
 * @see     QHT_SyoriCTL
 * @see     GenQHT_SyoriCTL
 */
public class PKHT_SyoriCTL extends AbstractExDBPrimaryKey<HT_SyoriCTL, PKHT_SyoriCTL> {

    private static final long serialVersionUID = 1L;

    public PKHT_SyoriCTL() {
    }

    public PKHT_SyoriCTL(String pMosno) {
        mosno = pMosno;
    }

    @Transient
    @Override
    public Class<HT_SyoriCTL> getEntityClass() {
        return HT_SyoriCTL.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

}