package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_LincJyusinTr;
import yuyu.def.db.mapping.GenZT_LincJyusinTr;
import yuyu.def.db.meta.GenQZT_LincJyusinTr;
import yuyu.def.db.meta.QZT_LincJyusinTr;

/**
 * ＬＩＮＣ受信内容反映テーブル（取） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_LincJyusinTr}</td><td colspan="3">ＬＩＮＣ受信内容反映テーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztrheadergyoumusyubetu</td><td>（取込用）ヘッダ業務種別</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrheaderrecordkbn</td><td>（取込用）ヘッダレコード区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrheaderkaisyacd</td><td>（取込用）ヘッダ会社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrheadersousinymd</td><td>（取込用）ヘッダ送信日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrheaderdatasyubetu</td><td>（取込用）ヘッダデータ種別</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrheaderkaitoukurikosi</td><td>（取込用）ヘッダ回答繰越</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrheadersyusindatasyubetu</td><td>（取込用）ヘッダ集信データ種別</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrheadersyusincircleno</td><td>（取込用）ヘッダ集信サイクル番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrsyoriymd ztrsyoriymd}</td><td>（取込用）処理年月日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrrenno10 ztrrenno10}</td><td>（取込用）連番１０桁</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv54</td><td>（取込用）予備項目Ｖ５４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrdatakbn</td><td>（取込用）データ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrrecordsyubetukbn</td><td>（取込用）レコード種別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrhenkoutype</td><td>（取込用）変更タイプ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsyorikekkacd</td><td>（取込用）処理結果コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsyorikekkaerrjiyuu</td><td>（取込用）処理結果エラー事由</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsyorikekkaerrno</td><td>（取込用）処理結果エラー項番</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrnayoserecordsuu</td><td>（取込用）名寄せレコード数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkanyuusyano</td><td>（取込用）加入者番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkyoukaisiyouknnm</td><td>（取込用）協会使用カナ氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrhhknseikbn</td><td>（取込用）被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrhhknseiymd</td><td>（取込用）被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkykymd</td><td>（取込用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkyksyhhknsydouituhyouji</td><td>（取込用）契約者被保険者同一表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsousinmotokaisyacd</td><td>（取込用）送信元会社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrhhknadrkn</td><td>（取込用）被保険者住所（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsiginyuintkykntgkstr</td><td>（取込用）災害入院特約日額（文字列）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsppinyuintkykntgkstr</td><td>（取込用）疾病入院特約日額（文字列）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsijnbyutkykntgkstr</td><td>（取込用）成人病特約日額（文字列）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsonotatokuyakuntgkstr</td><td>（取込用）その他特約日額（文字列）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrtrkmousideymd</td><td>（取込用）登録申出年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrlincsyoriymd</td><td>（取込用）ＬＩＮＣ処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryuyusiyouknnm</td><td>（取込用）住友使用カナ氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkykkanrino</td><td>（取込用）契約管理番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrhozenymd</td><td>（取込用）保全年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkykknnm</td><td>（取込用）契約者カナ氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrhutuusbsstr</td><td>（取込用）普通死亡保険金額（文字列）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsgsbstr</td><td>（取込用）災害死亡保険金額（文字列）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkakusyasiyouran</td><td>（取込用）各社使用欄</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrmousideflg</td><td>（取込用）申出フラグ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrmousideflgsetymd</td><td>（取込用）申出フラグ設定年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrmousideflgkaijyoymd</td><td>（取込用）申出フラグ解除年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrjgyhknflg</td><td>（取込用）事業保険フラグ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrtnknflg</td><td>（取込用）転換フラグ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkyksyaseikbn</td><td>（取込用）契約者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkyksyaseiymd</td><td>（取込用）契約者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkykadrkn</td><td>（取込用）契約者住所（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv17</td><td>（取込用）予備項目Ｖ１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrknjhhknmei30</td><td>（取込用）漢字被保険者名（３０桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkjkyknm30</td><td>（取込用）漢字契約者名（３０桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztr15sai1000manflg</td><td>（取込用）１５歳未満１０００万超フラグ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkjhngflg</td><td>（取込用）漢字範囲外フラグ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkykytymd</td><td>（取込用）契約予定年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrhozenytymd</td><td>（取込用）保全予定年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztr15mimantkhukaymd</td><td>（取込用）１５歳未満特約中途付加年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztr15mimantkhukayoteiymd</td><td>（取込用）１５歳未満特約中途付加予定日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv46</td><td>（取込用）予備項目Ｖ４６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_LincJyusinTr
 * @see     GenZT_LincJyusinTr
 * @see     QZT_LincJyusinTr
 * @see     GenQZT_LincJyusinTr
 */
public class PKZT_LincJyusinTr extends AbstractExDBPrimaryKey<ZT_LincJyusinTr, PKZT_LincJyusinTr> {

    private static final long serialVersionUID = 1L;

    public PKZT_LincJyusinTr() {
    }

    public PKZT_LincJyusinTr(String pZtrsyoriymd, String pZtrrenno10) {
        ztrsyoriymd = pZtrsyoriymd;
        ztrrenno10 = pZtrrenno10;
    }

    @Transient
    @Override
    public Class<ZT_LincJyusinTr> getEntityClass() {
        return ZT_LincJyusinTr.class;
    }

    private String ztrsyoriymd;

    public String getZtrsyoriymd() {
        return ztrsyoriymd;
    }

    public void setZtrsyoriymd(String pZtrsyoriymd) {
        ztrsyoriymd = pZtrsyoriymd;
    }
    private String ztrrenno10;

    public String getZtrrenno10() {
        return ztrrenno10;
    }

    public void setZtrrenno10(String pZtrrenno10) {
        ztrrenno10 = pZtrrenno10;
    }

}