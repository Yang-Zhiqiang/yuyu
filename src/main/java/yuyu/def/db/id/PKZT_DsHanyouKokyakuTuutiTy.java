package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_DsHanyouKokyakuTuutiTy;
import yuyu.def.db.mapping.GenZT_DsHanyouKokyakuTuutiTy;
import yuyu.def.db.meta.GenQZT_DsHanyouKokyakuTuutiTy;
import yuyu.def.db.meta.QZT_DsHanyouKokyakuTuutiTy;

/**
 * ＤＳ汎用顧客宛通知テーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DsHanyouKokyakuTuutiTy}</td><td colspan="3">ＤＳ汎用顧客宛通知テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtydshanyoukokatetuutikey ztydshanyoukokatetuutikey}</td><td>（中継用）ＤＳ汎用顧客宛通知キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtydskokno ztydskokno}</td><td>（中継用）ＤＳ顧客番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtydstuutikbn ztydstuutikbn}</td><td>（中継用）ＤＳ通知区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatesakiyno</td><td>（中継用）宛先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatesakiadr1</td><td>（中継用）宛先住所１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatesakiadr2</td><td>（中継用）宛先住所２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatesakiadr3</td><td>（中継用）宛先住所３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatena1</td><td>（中継用）宛名１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatena2</td><td>（中継用）宛名２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatesakiynobarcode</td><td>（中継用）宛先郵便番号バーコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai1syoukaifreearea11</td><td>（中継用）第１照会先フリーエリア１＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai1syoukaifreearea12</td><td>（中継用）第１照会先フリーエリア１＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai1syoukaifreearea13</td><td>（中継用）第１照会先フリーエリア１＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai1syoukaifreearea14</td><td>（中継用）第１照会先フリーエリア１＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai1syoukaifreearea15</td><td>（中継用）第１照会先フリーエリア１＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyscdai2syoukaifreearea1</td><td>（中継用）ＳＣ第２照会先フリ－エリア１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyscdai2syoukaifreearea2</td><td>（中継用）ＳＣ第２照会先フリ－エリア２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyscdai2syoukaifreearea3</td><td>（中継用）ＳＣ第２照会先フリ－エリア３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyscdai2syoukaifreearea4</td><td>（中継用）ＳＣ第２照会先フリ－エリア４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyscdai2syoukaifreearea5</td><td>（中継用）ＳＣ第２照会先フリ－エリア５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysakuseimd</td><td>（中継用）作成月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysclakadskokno</td><td>（中継用）スクランブル化ＤＳ顧客番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyreigaisyorihyj</td><td>（中継用）例外処理表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysakuseino</td><td>（中継用）作成No</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycode</td><td>（中継用）コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytuutimei</td><td>（中継用）通知名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea11</td><td>（中継用）フリーエリア１＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea12</td><td>（中継用）フリーエリア１＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea13</td><td>（中継用）フリーエリア１＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea14</td><td>（中継用）フリーエリア１＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea15</td><td>（中継用）フリーエリア１＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea16</td><td>（中継用）フリーエリア１＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea17</td><td>（中継用）フリーエリア１＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea18</td><td>（中継用）フリーエリア１＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea19</td><td>（中継用）フリーエリア１＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea110</td><td>（中継用）フリーエリア１＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea111</td><td>（中継用）フリーエリア１＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea112</td><td>（中継用）フリーエリア１＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea113</td><td>（中継用）フリーエリア１＿１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea114</td><td>（中継用）フリーエリア１＿１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea115</td><td>（中継用）フリーエリア１＿１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea116</td><td>（中継用）フリーエリア１＿１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea117</td><td>（中継用）フリーエリア１＿１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea118</td><td>（中継用）フリーエリア１＿１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea119</td><td>（中継用）フリーエリア１＿１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea120</td><td>（中継用）フリーエリア１＿２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea121</td><td>（中継用）フリーエリア１＿２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea122</td><td>（中継用）フリーエリア１＿２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea123</td><td>（中継用）フリーエリア１＿２３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea124</td><td>（中継用）フリーエリア１＿２４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea125</td><td>（中継用）フリーエリア１＿２５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea126</td><td>（中継用）フリーエリア１＿２６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea127</td><td>（中継用）フリーエリア１＿２７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea128</td><td>（中継用）フリーエリア１＿２８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea21</td><td>（中継用）フリーエリア２＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea22</td><td>（中継用）フリーエリア２＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea23</td><td>（中継用）フリーエリア２＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea24</td><td>（中継用）フリーエリア２＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea25</td><td>（中継用）フリーエリア２＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea26</td><td>（中継用）フリーエリア２＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea27</td><td>（中継用）フリーエリア２＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea28</td><td>（中継用）フリーエリア２＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea29</td><td>（中継用）フリーエリア２＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea210</td><td>（中継用）フリーエリア２＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea211</td><td>（中継用）フリーエリア２＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea212</td><td>（中継用）フリーエリア２＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea213</td><td>（中継用）フリーエリア２＿１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea214</td><td>（中継用）フリーエリア２＿１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea215</td><td>（中継用）フリーエリア２＿１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea216</td><td>（中継用）フリーエリア２＿１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea217</td><td>（中継用）フリーエリア２＿１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea218</td><td>（中継用）フリーエリア２＿１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea219</td><td>（中継用）フリーエリア２＿１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea220</td><td>（中継用）フリーエリア２＿２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea221</td><td>（中継用）フリーエリア２＿２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea222</td><td>（中継用）フリーエリア２＿２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea223</td><td>（中継用）フリーエリア２＿２３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea224</td><td>（中継用）フリーエリア２＿２４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea225</td><td>（中継用）フリーエリア２＿２５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea226</td><td>（中継用）フリーエリア２＿２６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea227</td><td>（中継用）フリーエリア２＿２７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfreearea228</td><td>（中継用）フリーエリア２＿２８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_DsHanyouKokyakuTuutiTy
 * @see     GenZT_DsHanyouKokyakuTuutiTy
 * @see     QZT_DsHanyouKokyakuTuutiTy
 * @see     GenQZT_DsHanyouKokyakuTuutiTy
 */
public class PKZT_DsHanyouKokyakuTuutiTy extends AbstractExDBPrimaryKey<ZT_DsHanyouKokyakuTuutiTy, PKZT_DsHanyouKokyakuTuutiTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_DsHanyouKokyakuTuutiTy() {
    }

    public PKZT_DsHanyouKokyakuTuutiTy(
        String pZtydshanyoukokatetuutikey,
        String pZtydskokno,
        String pZtydstuutikbn
    ) {
        ztydshanyoukokatetuutikey = pZtydshanyoukokatetuutikey;
        ztydskokno = pZtydskokno;
        ztydstuutikbn = pZtydstuutikbn;
    }

    @Transient
    @Override
    public Class<ZT_DsHanyouKokyakuTuutiTy> getEntityClass() {
        return ZT_DsHanyouKokyakuTuutiTy.class;
    }

    private String ztydshanyoukokatetuutikey;

    public String getZtydshanyoukokatetuutikey() {
        return ztydshanyoukokatetuutikey;
    }

    public void setZtydshanyoukokatetuutikey(String pZtydshanyoukokatetuutikey) {
        ztydshanyoukokatetuutikey = pZtydshanyoukokatetuutikey;
    }
    private String ztydskokno;

    public String getZtydskokno() {
        return ztydskokno;
    }

    public void setZtydskokno(String pZtydskokno) {
        ztydskokno = pZtydskokno;
    }
    private String ztydstuutikbn;

    public String getZtydstuutikbn() {
        return ztydstuutikbn;
    }

    public void setZtydstuutikbn(String pZtydstuutikbn) {
        ztydstuutikbn = pZtydstuutikbn;
    }

}