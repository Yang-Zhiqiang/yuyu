package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_DsKariPasswordTuutiRn;
import yuyu.def.db.mapping.GenZT_DsKariPasswordTuutiRn;
import yuyu.def.db.meta.GenQZT_DsKariPasswordTuutiRn;
import yuyu.def.db.meta.QZT_DsKariPasswordTuutiRn;

/**
 * 仮パスワード通知テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DsKariPasswordTuutiRn}</td><td colspan="3">仮パスワード通知テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkrpasswordtuutikey zrnkrpasswordtuutikey}</td><td>（連携用）仮パスワード通知キー</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndskokno</td><td>（連携用）ＤＳ顧客番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnatesakiyno</td><td>（連携用）宛先郵便番号</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnatesakiynobarcode</td><td>（連携用）宛先郵便番号バーコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsakuseimd</td><td>（連携用）作成月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsclakadskokno</td><td>（連携用）スクランブル化ＤＳ顧客番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnreigaisyorihyj</td><td>（連携用）例外処理表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyuubinbutukanpusakiyno</td><td>（連携用）郵便物還付先郵便番号</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyuubinbutukanpusakiadr</td><td>（連携用）郵便物還付先住所</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnatesakiadr1</td><td>（連携用）宛先住所１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnatesakiadr2</td><td>（連携用）宛先住所２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnatesakiadr3</td><td>（連携用）宛先住所３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnatena1</td><td>（連携用）宛名１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnatena2</td><td>（連携用）宛名２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndai1syoukaisakifreearea1</td><td>（連携用）第１照会先フリーエリア１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndai1syoukaisakifreearea2</td><td>（連携用）第１照会先フリーエリア２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndai1syoukaisakifreearea3</td><td>（連携用）第１照会先フリーエリア３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndai1syoukaisakifreearea4</td><td>（連携用）第１照会先フリーエリア４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndai1syoukaisakifreearea5</td><td>（連携用）第１照会先フリーエリア５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsakuseino</td><td>（連携用）作成No</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnokyakusamanm</td><td>（連携用）お客様氏名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhkymd</td><td>（連携用）発行日</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndskrhnnkakcdyoken</td><td>（連携用）ＤＳ仮本人確認コード与件</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkrpasswordyuukouymd</td><td>（連携用）仮パスワード有効年月日</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea1</td><td>（連携用）フリーエリア１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea2</td><td>（連携用）フリーエリア２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea3</td><td>（連携用）フリーエリア３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea4</td><td>（連携用）フリーエリア４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnfreearea5</td><td>（連携用）フリーエリア５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntyuuijikou1</td><td>（連携用）注意事項欄１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntyuuijikou2</td><td>（連携用）注意事項欄２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntyuuijikou3</td><td>（連携用）注意事項欄３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntyuuijikou4</td><td>（連携用）注意事項欄４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntyuuijikou5</td><td>（連携用）注意事項欄５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntyuuijikou6</td><td>（連携用）注意事項欄６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntyuuijikou7</td><td>（連携用）注意事項欄７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 * </table>
 * @see     ZT_DsKariPasswordTuutiRn
 * @see     GenZT_DsKariPasswordTuutiRn
 * @see     QZT_DsKariPasswordTuutiRn
 * @see     GenQZT_DsKariPasswordTuutiRn
 */
public class PKZT_DsKariPasswordTuutiRn extends AbstractExDBPrimaryKey<ZT_DsKariPasswordTuutiRn, PKZT_DsKariPasswordTuutiRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_DsKariPasswordTuutiRn() {
    }

    public PKZT_DsKariPasswordTuutiRn(String pZrnkrpasswordtuutikey) {
        zrnkrpasswordtuutikey = pZrnkrpasswordtuutikey;
    }

    @Transient
    @Override
    public Class<ZT_DsKariPasswordTuutiRn> getEntityClass() {
        return ZT_DsKariPasswordTuutiRn.class;
    }

    private String zrnkrpasswordtuutikey;

    public String getZrnkrpasswordtuutikey() {
        return zrnkrpasswordtuutikey;
    }

    public void setZrnkrpasswordtuutikey(String pZrnkrpasswordtuutikey) {
        zrnkrpasswordtuutikey = pZrnkrpasswordtuutikey;
    }

}