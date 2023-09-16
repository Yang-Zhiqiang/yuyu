package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_LincJyusinRn;
import yuyu.def.db.mapping.GenZT_LincJyusinRn;
import yuyu.def.db.meta.GenQZT_LincJyusinRn;
import yuyu.def.db.meta.QZT_LincJyusinRn;

/**
 * ＬＩＮＣ受信内容反映テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_LincJyusinRn}</td><td colspan="3">ＬＩＮＣ受信内容反映テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrnheadergyoumusyubetu</td><td>（連携用）ヘッダ業務種別</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnheaderrecordkbn</td><td>（連携用）ヘッダレコード区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnheaderkaisyacd</td><td>（連携用）ヘッダ会社コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnheadersousinymd</td><td>（連携用）ヘッダ送信日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnheaderdatasyubetu</td><td>（連携用）ヘッダデータ種別</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnheaderkaitoukurikosi</td><td>（連携用）ヘッダ回答繰越</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnheadersyusindatasyubetu</td><td>（連携用）ヘッダ集信データ種別</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnheadersyusincircleno</td><td>（連携用）ヘッダ集信サイクル番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyoriymd zrnsyoriymd}</td><td>（連携用）処理年月日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnrenno10 zrnrenno10}</td><td>（連携用）連番１０桁</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv54</td><td>（連携用）予備項目Ｖ５４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndatakbn</td><td>（連携用）データ区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnrecordsyubetukbn</td><td>（連携用）レコード種別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
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
 *  <tr><td>zrnkykkanrino</td><td>（連携用）契約管理番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
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
 * @see     ZT_LincJyusinRn
 * @see     GenZT_LincJyusinRn
 * @see     QZT_LincJyusinRn
 * @see     GenQZT_LincJyusinRn
 */
public class PKZT_LincJyusinRn extends AbstractExDBPrimaryKey<ZT_LincJyusinRn, PKZT_LincJyusinRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_LincJyusinRn() {
    }

    public PKZT_LincJyusinRn(String pZrnsyoriymd, String pZrnrenno10) {
        zrnsyoriymd = pZrnsyoriymd;
        zrnrenno10 = pZrnrenno10;
    }

    @Transient
    @Override
    public Class<ZT_LincJyusinRn> getEntityClass() {
        return ZT_LincJyusinRn.class;
    }

    private String zrnsyoriymd;

    public String getZrnsyoriymd() {
        return zrnsyoriymd;
    }

    public void setZrnsyoriymd(String pZrnsyoriymd) {
        zrnsyoriymd = pZrnsyoriymd;
    }
    private String zrnrenno10;

    public String getZrnrenno10() {
        return zrnrenno10;
    }

    public void setZrnrenno10(String pZrnrenno10) {
        zrnrenno10 = pZrnrenno10;
    }

}