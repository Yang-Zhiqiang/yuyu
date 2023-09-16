package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_OnlineLincSousinRn;
import yuyu.def.db.mapping.GenZT_OnlineLincSousinRn;
import yuyu.def.db.meta.GenQZT_OnlineLincSousinRn;
import yuyu.def.db.meta.QZT_OnlineLincSousinRn;

/**
 * オンラインＬＩＮＣ送信ファイルテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_OnlineLincSousinRn}</td><td colspan="3">オンラインＬＩＮＣ送信ファイルテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrndatakbn</td><td>（連携用）データ区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnrecordsyubetukbn zrnrecordsyubetukbn}</td><td>（連携用）レコード種別区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhenkoutype</td><td>（連携用）変更タイプ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyorikekkacd</td><td>（連携用）処理結果コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyorikekkaerrjiyuu</td><td>（連携用）処理結果エラー事由</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyorikekkaerrno</td><td>（連携用）処理結果エラー項番</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnayoserecordsuu</td><td>（連携用）名寄せレコード数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanyuusyano</td><td>（連携用）加入者番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyoukaisiyouknnm</td><td>（連携用）協会使用カナ氏名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknseikbn</td><td>（連携用）被保険者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknseiymd</td><td>（連携用）被保険者生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykymd</td><td>（連携用）契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyhhknsydouituhyouji</td><td>（連携用）契約者被保険者同一表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsousinmotokaisyacd</td><td>（連携用）送信元会社コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknadrkn</td><td>（連携用）被保険者住所（カナ）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiginyuintkykntgkstr</td><td>（連携用）災害入院特約日額（文字列）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsppinyuintkykntgkstr</td><td>（連携用）疾病入院特約日額（文字列）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsijnbyutkykntgkstr</td><td>（連携用）成人病特約日額（文字列）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsonotatokuyakuntgkstr</td><td>（連携用）その他特約日額（文字列）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntrkmousideymd</td><td>（連携用）登録申出年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnlincsyoriymd</td><td>（連携用）ＬＩＮＣ処理年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyuyusiyouknnm</td><td>（連携用）住友使用カナ氏名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkykkanrino zrnkykkanrino}</td><td>（連携用）契約管理番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhozenymd</td><td>（連携用）保全年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykknnm</td><td>（連携用）契約者カナ氏名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhutuusbsstr</td><td>（連携用）普通死亡保険金額</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsgsbstr</td><td>（連携用）災害死亡保険金額</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkakusyasiyouran</td><td>（連携用）各社使用欄</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmousideflg</td><td>（連携用）申出フラグ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmousideflgsetymd</td><td>（連携用）申出フラグ設定年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmousideflgkaijyoymd</td><td>（連携用）申出フラグ解除年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjgyhknflg</td><td>（連携用）事業保険フラグ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntnknflg</td><td>（連携用）転換フラグ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyaseikbn</td><td>（連携用）契約者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyaseiymd</td><td>（連携用）契約者生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykadrkn</td><td>（連携用）契約者住所（カナ）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv17</td><td>（連携用）予備項目Ｖ１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknjhhknmei30</td><td>（連携用）漢字被保険者名（３０桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkjkyknm30</td><td>（連携用）漢字契約者名（３０桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrn15sai1000manflg</td><td>（連携用）１５歳未満１０００万超フラグ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjhngflg</td><td>（連携用）漢字範囲外フラグ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykytymd</td><td>（連携用）契約予定年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhozenytymd</td><td>（連携用）保全予定年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrn15mimantkhukaymd</td><td>（連携用）１５歳未満特約中途付加年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrn15mimantkhukayoteiymd</td><td>（連携用）１５歳未満特約中途付加予定日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv46</td><td>（連携用）予備項目Ｖ４６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_OnlineLincSousinRn
 * @see     GenZT_OnlineLincSousinRn
 * @see     QZT_OnlineLincSousinRn
 * @see     GenQZT_OnlineLincSousinRn
 */
public class PKZT_OnlineLincSousinRn extends AbstractExDBPrimaryKey<ZT_OnlineLincSousinRn, PKZT_OnlineLincSousinRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_OnlineLincSousinRn() {
    }

    public PKZT_OnlineLincSousinRn(String pZrnrecordsyubetukbn, String pZrnkykkanrino) {
        zrnrecordsyubetukbn = pZrnrecordsyubetukbn;
        zrnkykkanrino = pZrnkykkanrino;
    }

    @Transient
    @Override
    public Class<ZT_OnlineLincSousinRn> getEntityClass() {
        return ZT_OnlineLincSousinRn.class;
    }

    private String zrnrecordsyubetukbn;

    public String getZrnrecordsyubetukbn() {
        return zrnrecordsyubetukbn;
    }

    public void setZrnrecordsyubetukbn(String pZrnrecordsyubetukbn) {
        zrnrecordsyubetukbn = pZrnrecordsyubetukbn;
    }
    private String zrnkykkanrino;

    public String getZrnkykkanrino() {
        return zrnkykkanrino;
    }

    public void setZrnkykkanrino(String pZrnkykkanrino) {
        zrnkykkanrino = pZrnkykkanrino;
    }

}