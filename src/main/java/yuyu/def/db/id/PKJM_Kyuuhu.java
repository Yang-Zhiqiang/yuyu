package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JM_Kyuuhu;
import yuyu.def.db.mapping.GenJM_Kyuuhu;
import yuyu.def.db.meta.GenQJM_Kyuuhu;
import yuyu.def.db.meta.QJM_Kyuuhu;

/**
 * 給付マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JM_Kyuuhu}</td><td colspan="3">給付マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKyuuhucd kyuuhucd}</td><td>給付コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>seikyuusyubetu</td><td>請求種別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SeikyuuSyubetu C_SeikyuuSyubetu}</td></tr>
 *  <tr><td>kyuuhuname</td><td>給付名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyuuhunamegamen</td><td>給付名（画面用）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyuuhunamereport</td><td>給付名（帳票用）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujijyun</td><td>表示順</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>geninkbn</td><td>原因区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_GeninKbn C_GeninKbn}</td></tr>
 *  <tr><td>saigaisippeinyuinumukbn</td><td>災害疾病入院有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kyuuhukbn</td><td>給付区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KyuuhuKbn C_KyuuhuKbn}</td></tr>
 *  <tr><td>hokenkinsyuruikbn</td><td>保険金種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HokenkinsyuruiKbn C_HokenkinsyuruiKbn}</td></tr>
 *  <tr><td>kanjyoukmkcd</td><td>勘定科目コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kanjyoukmkcd C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>uktsyukbn</td><td>受取人種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UktsyuKbn C_UktsyuKbn}</td></tr>
 *  <tr><td>sateirankcd</td><td>査定ランクコード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Sateirank C_Sateirank}</td></tr>
 *  <tr><td>seikyuusyainfocheck</td><td>請求者情報チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sinkensyainfocheck</td><td>親権者情報チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>souhusakiinfocheck</td><td>送付先情報チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>soukinsakiinfocheck</td><td>送金先情報チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>uketorihouhoucheck</td><td>受取方法チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>nkseikyuucheck</td><td>年金請求チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>hassoukbncheck</td><td>発送区分チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>honninkaknincheck</td><td>本人確認チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>saigaigtkanouseicheck</td><td>災害該当可能性チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>saikeninfocheck</td><td>債権者情報チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>saisateicheck</td><td>再査定チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kijyunymdcheck</td><td>基準日チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>geninkbncheck</td><td>原因区分チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>syuhiyoucheck</td><td>守秘要チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>syoumetucheck</td><td>消滅チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>doujisksyoricheck</td><td>同時請求処理中チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>khsyoricheck</td><td>契約保全処理中チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sknnkaisiymdcheck</td><td>責任開始日チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>hknkkncheck</td><td>保険期間チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>phrkyuuyokkncheck</td><td>保険料払込猶予期間チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>fstphrkyuuyokkntyoukacheck</td><td>初回保険料払込猶予期間超過チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>tokkoudosghtnpcheck</td><td>特定高度障害不担保チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>hokenkinshrskgnkkncheck</td><td>保険金支払削減期間チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>nkkiteicheck</td><td>年金規定チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>ttdktyuuicheck</td><td>手続注意チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>uktcheck</td><td>受取人チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>firstpminyuucheck</td><td>初回保険料未入チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sinsatyuuicheck</td><td>審査注意チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sateijisatumensekicheck</td><td>査定項目＿自殺免責チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sateisknnkaisiymdcheck</td><td>査定項目＿責任開始日チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sateigengkcheck</td><td>査定項目＿減額チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sateimeigihnkcheck</td><td>査定項目＿名義変更チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sateistknsetcheck</td><td>査定項目＿質権設定チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sateisaikenkaiyakumcheck</td><td>査定項目＿債権者解約申出チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sateihasantosancheck</td><td>査定項目＿破産および倒産チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sateisasiosaecheck</td><td>査定項目＿差押チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sateisousasyoukaicheck</td><td>査定項目＿捜査照会チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sateihusyousicheck</td><td>査定項目＿不詳の死チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sateikaigaisbcheck</td><td>査定項目＿海外死亡チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sateikaigaicheck</td><td>査定項目＿海外チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sateimrinfocheck</td><td>査定項目＿ＭＲ情報チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sateihigaitoucheck</td><td>査定項目＿非該当チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sateihnsycheck</td><td>査定項目＿反社チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sateiseikyuusyoruicheck</td><td>査定項目＿請求書類チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sateisaigaigtkanouseicheck</td><td>査定項目＿災害該当可能性チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sateisaisateicheck</td><td>査定項目＿再査定チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>calcsyoruiukeymdcheck</td><td>支払金額計算後＿書類受付日チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>calchonninkakunincheck</td><td>支払金額計算後＿本人確認チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>calcmnmeigibangoucheck</td><td>支払金額計算後＿ＭＮ名義番号チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>calcsyksbyensitihsyucheck</td><td>支払金額計算後＿初期死亡時円換算最低保証適用チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>hokenkngkhyoujikbn</td><td>保険金額表示区分</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hokenkngkhyoujimsg1</td><td>保険金額表示メッセージ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hokenkngkhyoujimsg2</td><td>保険金額表示メッセージ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mrfkouzatratkicheck</td><td>ＭＲＦ口座取扱チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>keiyakusyahnkcheck</td><td>契約者変更チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>dskaiyakusyoricheck</td><td>ＤＳ解約処理中チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kykymdcheck</td><td>契約日チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>endthnkymdcheck</td><td>円建変更日チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>hrmbrcheck</td><td>返戻金未払いチェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>haitoukincheck</td><td>配当金チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>tmttknjyoutaicheck</td><td>積立金状態チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sateisgsbjisatumensekicheck</td><td>査定項目＿災害死亡自殺免責チェック</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>bkntyousafsyorikbn</td><td>備金調査ファイル処理区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BknTyousaFSyoriKbn C_BknTyousaFSyoriKbn}</td></tr>
 * </table>
 * @see     JM_Kyuuhu
 * @see     GenJM_Kyuuhu
 * @see     QJM_Kyuuhu
 * @see     GenQJM_Kyuuhu
 */
public class PKJM_Kyuuhu extends AbstractExDBPrimaryKey<JM_Kyuuhu, PKJM_Kyuuhu> {

    private static final long serialVersionUID = 1L;

    public PKJM_Kyuuhu() {
    }

    public PKJM_Kyuuhu(String pKyuuhucd) {
        kyuuhucd = pKyuuhucd;
    }

    @Transient
    @Override
    public Class<JM_Kyuuhu> getEntityClass() {
        return JM_Kyuuhu.class;
    }

    private String kyuuhucd;

    public String getKyuuhucd() {
        return kyuuhucd;
    }

    public void setKyuuhucd(String pKyuuhucd) {
        kyuuhucd = pKyuuhucd;
    }

}