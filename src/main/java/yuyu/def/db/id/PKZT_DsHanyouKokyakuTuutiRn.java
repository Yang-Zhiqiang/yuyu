package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_DsHanyouKokyakuTuutiRn;
import yuyu.def.db.mapping.GenZT_DsHanyouKokyakuTuutiRn;
import yuyu.def.db.meta.GenQZT_DsHanyouKokyakuTuutiRn;
import yuyu.def.db.meta.QZT_DsHanyouKokyakuTuutiRn;

/**
 * ＤＳ汎用顧客宛通知テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DsHanyouKokyakuTuutiRn}</td><td colspan="3">ＤＳ汎用顧客宛通知テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrndshanyoukokatetuutikey zrndshanyoukokatetuutikey}</td><td>（連携用）ＤＳ汎用顧客宛通知キー</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrndskokno zrndskokno}</td><td>（連携用）ＤＳ顧客番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrndstuutikbn zrndstuutikbn}</td><td>（連携用）ＤＳ通知区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnatesakiyno</td><td>（連携用）宛先郵便番号</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnatesakiadr1</td><td>（連携用）宛先住所１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnatesakiadr2</td><td>（連携用）宛先住所２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnatesakiadr3</td><td>（連携用）宛先住所３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnatena1</td><td>（連携用）宛名１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnatena2</td><td>（連携用）宛名２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnatesakiynobarcode</td><td>（連携用）宛先郵便番号バーコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai1syoukaifreearea11</td><td>（連携用）第１照会先フリーエリア１＿１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndai1syoukaifreearea12</td><td>（連携用）第１照会先フリーエリア１＿２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndai1syoukaifreearea13</td><td>（連携用）第１照会先フリーエリア１＿３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndai1syoukaifreearea14</td><td>（連携用）第１照会先フリーエリア１＿４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndai1syoukaifreearea15</td><td>（連携用）第１照会先フリーエリア１＿５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnscdai2syoukaifreearea1</td><td>（連携用）ＳＣ第２照会先フリ－エリア１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnscdai2syoukaifreearea2</td><td>（連携用）ＳＣ第２照会先フリ－エリア２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnscdai2syoukaifreearea3</td><td>（連携用）ＳＣ第２照会先フリ－エリア３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnscdai2syoukaifreearea4</td><td>（連携用）ＳＣ第２照会先フリ－エリア４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnscdai2syoukaifreearea5</td><td>（連携用）ＳＣ第２照会先フリ－エリア５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsakuseimd</td><td>（連携用）作成月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsclakadskokno</td><td>（連携用）スクランブル化ＤＳ顧客番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnreigaisyorihyj</td><td>（連携用）例外処理表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsakuseino</td><td>（連携用）作成No</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncode</td><td>（連携用）コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntuutimei</td><td>（連携用）通知名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea11</td><td>（連携用）フリーエリア１＿１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea12</td><td>（連携用）フリーエリア１＿２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea13</td><td>（連携用）フリーエリア１＿３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea14</td><td>（連携用）フリーエリア１＿４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea15</td><td>（連携用）フリーエリア１＿５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea16</td><td>（連携用）フリーエリア１＿６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea17</td><td>（連携用）フリーエリア１＿７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea18</td><td>（連携用）フリーエリア１＿８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea19</td><td>（連携用）フリーエリア１＿９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea110</td><td>（連携用）フリーエリア１＿１０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea111</td><td>（連携用）フリーエリア１＿１１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea112</td><td>（連携用）フリーエリア１＿１２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea113</td><td>（連携用）フリーエリア１＿１３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea114</td><td>（連携用）フリーエリア１＿１４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea115</td><td>（連携用）フリーエリア１＿１５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea116</td><td>（連携用）フリーエリア１＿１６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea117</td><td>（連携用）フリーエリア１＿１７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea118</td><td>（連携用）フリーエリア１＿１８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea119</td><td>（連携用）フリーエリア１＿１９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea120</td><td>（連携用）フリーエリア１＿２０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea121</td><td>（連携用）フリーエリア１＿２１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea122</td><td>（連携用）フリーエリア１＿２２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea123</td><td>（連携用）フリーエリア１＿２３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea124</td><td>（連携用）フリーエリア１＿２４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea125</td><td>（連携用）フリーエリア１＿２５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea126</td><td>（連携用）フリーエリア１＿２６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea127</td><td>（連携用）フリーエリア１＿２７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea128</td><td>（連携用）フリーエリア１＿２８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea21</td><td>（連携用）フリーエリア２＿１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea22</td><td>（連携用）フリーエリア２＿２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea23</td><td>（連携用）フリーエリア２＿３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea24</td><td>（連携用）フリーエリア２＿４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea25</td><td>（連携用）フリーエリア２＿５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea26</td><td>（連携用）フリーエリア２＿６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea27</td><td>（連携用）フリーエリア２＿７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea28</td><td>（連携用）フリーエリア２＿８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea29</td><td>（連携用）フリーエリア２＿９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea210</td><td>（連携用）フリーエリア２＿１０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea211</td><td>（連携用）フリーエリア２＿１１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea212</td><td>（連携用）フリーエリア２＿１２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea213</td><td>（連携用）フリーエリア２＿１３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea214</td><td>（連携用）フリーエリア２＿１４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea215</td><td>（連携用）フリーエリア２＿１５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea216</td><td>（連携用）フリーエリア２＿１６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea217</td><td>（連携用）フリーエリア２＿１７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea218</td><td>（連携用）フリーエリア２＿１８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea219</td><td>（連携用）フリーエリア２＿１９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea220</td><td>（連携用）フリーエリア２＿２０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea221</td><td>（連携用）フリーエリア２＿２１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea222</td><td>（連携用）フリーエリア２＿２２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea223</td><td>（連携用）フリーエリア２＿２３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea224</td><td>（連携用）フリーエリア２＿２４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea225</td><td>（連携用）フリーエリア２＿２５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea226</td><td>（連携用）フリーエリア２＿２６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea227</td><td>（連携用）フリーエリア２＿２７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea228</td><td>（連携用）フリーエリア２＿２８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 * </table>
 * @see     ZT_DsHanyouKokyakuTuutiRn
 * @see     GenZT_DsHanyouKokyakuTuutiRn
 * @see     QZT_DsHanyouKokyakuTuutiRn
 * @see     GenQZT_DsHanyouKokyakuTuutiRn
 */
public class PKZT_DsHanyouKokyakuTuutiRn extends AbstractExDBPrimaryKey<ZT_DsHanyouKokyakuTuutiRn, PKZT_DsHanyouKokyakuTuutiRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_DsHanyouKokyakuTuutiRn() {
    }

    public PKZT_DsHanyouKokyakuTuutiRn(
        String pZrndshanyoukokatetuutikey,
        String pZrndskokno,
        String pZrndstuutikbn
    ) {
        zrndshanyoukokatetuutikey = pZrndshanyoukokatetuutikey;
        zrndskokno = pZrndskokno;
        zrndstuutikbn = pZrndstuutikbn;
    }

    @Transient
    @Override
    public Class<ZT_DsHanyouKokyakuTuutiRn> getEntityClass() {
        return ZT_DsHanyouKokyakuTuutiRn.class;
    }

    private String zrndshanyoukokatetuutikey;

    public String getZrndshanyoukokatetuutikey() {
        return zrndshanyoukokatetuutikey;
    }

    public void setZrndshanyoukokatetuutikey(String pZrndshanyoukokatetuutikey) {
        zrndshanyoukokatetuutikey = pZrndshanyoukokatetuutikey;
    }
    private String zrndskokno;

    public String getZrndskokno() {
        return zrndskokno;
    }

    public void setZrndskokno(String pZrndskokno) {
        zrndskokno = pZrndskokno;
    }
    private String zrndstuutikbn;

    public String getZrndstuutikbn() {
        return zrndstuutikbn;
    }

    public void setZrndstuutikbn(String pZrndstuutikbn) {
        zrndstuutikbn = pZrndstuutikbn;
    }

}