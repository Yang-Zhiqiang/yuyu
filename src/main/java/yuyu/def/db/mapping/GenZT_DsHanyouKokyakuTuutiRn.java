package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_DsHanyouKokyakuTuutiRn;
import yuyu.def.db.id.PKZT_DsHanyouKokyakuTuutiRn;
import yuyu.def.db.meta.GenQZT_DsHanyouKokyakuTuutiRn;
import yuyu.def.db.meta.QZT_DsHanyouKokyakuTuutiRn;

/**
 * ＤＳ汎用顧客宛通知テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_DsHanyouKokyakuTuutiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DsHanyouKokyakuTuutiRn}</td><td colspan="3">ＤＳ汎用顧客宛通知テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrndshanyoukokatetuutikey zrndshanyoukokatetuutikey}</td><td>（連携用）ＤＳ汎用顧客宛通知キー</td><td align="center">{@link PKZT_DsHanyouKokyakuTuutiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndskokno zrndskokno}</td><td>（連携用）ＤＳ顧客番号</td><td align="center">{@link PKZT_DsHanyouKokyakuTuutiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndstuutikbn zrndstuutikbn}</td><td>（連携用）ＤＳ通知区分</td><td align="center">{@link PKZT_DsHanyouKokyakuTuutiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatesakiyno zrnatesakiyno}</td><td>（連携用）宛先郵便番号</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatesakiadr1 zrnatesakiadr1}</td><td>（連携用）宛先住所１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatesakiadr2 zrnatesakiadr2}</td><td>（連携用）宛先住所２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatesakiadr3 zrnatesakiadr3}</td><td>（連携用）宛先住所３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatena1 zrnatena1}</td><td>（連携用）宛名１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatena2 zrnatena2}</td><td>（連携用）宛名２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatesakiynobarcode zrnatesakiynobarcode}</td><td>（連携用）宛先郵便番号バーコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syoukaifreearea11 zrndai1syoukaifreearea11}</td><td>（連携用）第１照会先フリーエリア１＿１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syoukaifreearea12 zrndai1syoukaifreearea12}</td><td>（連携用）第１照会先フリーエリア１＿２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syoukaifreearea13 zrndai1syoukaifreearea13}</td><td>（連携用）第１照会先フリーエリア１＿３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syoukaifreearea14 zrndai1syoukaifreearea14}</td><td>（連携用）第１照会先フリーエリア１＿４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syoukaifreearea15 zrndai1syoukaifreearea15}</td><td>（連携用）第１照会先フリーエリア１＿５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnscdai2syoukaifreearea1 zrnscdai2syoukaifreearea1}</td><td>（連携用）ＳＣ第２照会先フリ－エリア１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnscdai2syoukaifreearea2 zrnscdai2syoukaifreearea2}</td><td>（連携用）ＳＣ第２照会先フリ－エリア２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnscdai2syoukaifreearea3 zrnscdai2syoukaifreearea3}</td><td>（連携用）ＳＣ第２照会先フリ－エリア３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnscdai2syoukaifreearea4 zrnscdai2syoukaifreearea4}</td><td>（連携用）ＳＣ第２照会先フリ－エリア４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnscdai2syoukaifreearea5 zrnscdai2syoukaifreearea5}</td><td>（連携用）ＳＣ第２照会先フリ－エリア５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsakuseimd zrnsakuseimd}</td><td>（連携用）作成月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsclakadskokno zrnsclakadskokno}</td><td>（連携用）スクランブル化ＤＳ顧客番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnreigaisyorihyj zrnreigaisyorihyj}</td><td>（連携用）例外処理表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsakuseino zrnsakuseino}</td><td>（連携用）作成No</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncode zrncode}</td><td>（連携用）コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuutimei zrntuutimei}</td><td>（連携用）通知名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea11 zrnfreearea11}</td><td>（連携用）フリーエリア１＿１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea12 zrnfreearea12}</td><td>（連携用）フリーエリア１＿２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea13 zrnfreearea13}</td><td>（連携用）フリーエリア１＿３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea14 zrnfreearea14}</td><td>（連携用）フリーエリア１＿４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea15 zrnfreearea15}</td><td>（連携用）フリーエリア１＿５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea16 zrnfreearea16}</td><td>（連携用）フリーエリア１＿６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea17 zrnfreearea17}</td><td>（連携用）フリーエリア１＿７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea18 zrnfreearea18}</td><td>（連携用）フリーエリア１＿８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea19 zrnfreearea19}</td><td>（連携用）フリーエリア１＿９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea110 zrnfreearea110}</td><td>（連携用）フリーエリア１＿１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea111 zrnfreearea111}</td><td>（連携用）フリーエリア１＿１１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea112 zrnfreearea112}</td><td>（連携用）フリーエリア１＿１２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea113 zrnfreearea113}</td><td>（連携用）フリーエリア１＿１３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea114 zrnfreearea114}</td><td>（連携用）フリーエリア１＿１４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea115 zrnfreearea115}</td><td>（連携用）フリーエリア１＿１５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea116 zrnfreearea116}</td><td>（連携用）フリーエリア１＿１６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea117 zrnfreearea117}</td><td>（連携用）フリーエリア１＿１７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea118 zrnfreearea118}</td><td>（連携用）フリーエリア１＿１８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea119 zrnfreearea119}</td><td>（連携用）フリーエリア１＿１９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea120 zrnfreearea120}</td><td>（連携用）フリーエリア１＿２０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea121 zrnfreearea121}</td><td>（連携用）フリーエリア１＿２１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea122 zrnfreearea122}</td><td>（連携用）フリーエリア１＿２２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea123 zrnfreearea123}</td><td>（連携用）フリーエリア１＿２３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea124 zrnfreearea124}</td><td>（連携用）フリーエリア１＿２４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea125 zrnfreearea125}</td><td>（連携用）フリーエリア１＿２５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea126 zrnfreearea126}</td><td>（連携用）フリーエリア１＿２６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea127 zrnfreearea127}</td><td>（連携用）フリーエリア１＿２７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea128 zrnfreearea128}</td><td>（連携用）フリーエリア１＿２８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea21 zrnfreearea21}</td><td>（連携用）フリーエリア２＿１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea22 zrnfreearea22}</td><td>（連携用）フリーエリア２＿２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea23 zrnfreearea23}</td><td>（連携用）フリーエリア２＿３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea24 zrnfreearea24}</td><td>（連携用）フリーエリア２＿４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea25 zrnfreearea25}</td><td>（連携用）フリーエリア２＿５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea26 zrnfreearea26}</td><td>（連携用）フリーエリア２＿６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea27 zrnfreearea27}</td><td>（連携用）フリーエリア２＿７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea28 zrnfreearea28}</td><td>（連携用）フリーエリア２＿８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea29 zrnfreearea29}</td><td>（連携用）フリーエリア２＿９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea210 zrnfreearea210}</td><td>（連携用）フリーエリア２＿１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea211 zrnfreearea211}</td><td>（連携用）フリーエリア２＿１１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea212 zrnfreearea212}</td><td>（連携用）フリーエリア２＿１２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea213 zrnfreearea213}</td><td>（連携用）フリーエリア２＿１３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea214 zrnfreearea214}</td><td>（連携用）フリーエリア２＿１４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea215 zrnfreearea215}</td><td>（連携用）フリーエリア２＿１５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea216 zrnfreearea216}</td><td>（連携用）フリーエリア２＿１６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea217 zrnfreearea217}</td><td>（連携用）フリーエリア２＿１７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea218 zrnfreearea218}</td><td>（連携用）フリーエリア２＿１８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea219 zrnfreearea219}</td><td>（連携用）フリーエリア２＿１９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea220 zrnfreearea220}</td><td>（連携用）フリーエリア２＿２０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea221 zrnfreearea221}</td><td>（連携用）フリーエリア２＿２１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea222 zrnfreearea222}</td><td>（連携用）フリーエリア２＿２２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea223 zrnfreearea223}</td><td>（連携用）フリーエリア２＿２３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea224 zrnfreearea224}</td><td>（連携用）フリーエリア２＿２４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea225 zrnfreearea225}</td><td>（連携用）フリーエリア２＿２５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea226 zrnfreearea226}</td><td>（連携用）フリーエリア２＿２６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea227 zrnfreearea227}</td><td>（連携用）フリーエリア２＿２７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfreearea228 zrnfreearea228}</td><td>（連携用）フリーエリア２＿２８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 * </table>
 * @see     ZT_DsHanyouKokyakuTuutiRn
 * @see     PKZT_DsHanyouKokyakuTuutiRn
 * @see     QZT_DsHanyouKokyakuTuutiRn
 * @see     GenQZT_DsHanyouKokyakuTuutiRn
 */
@MappedSuperclass
@Table(name=GenZT_DsHanyouKokyakuTuutiRn.TABLE_NAME)
@IdClass(value=PKZT_DsHanyouKokyakuTuutiRn.class)
public abstract class GenZT_DsHanyouKokyakuTuutiRn extends AbstractExDBEntityForZDB<ZT_DsHanyouKokyakuTuutiRn, PKZT_DsHanyouKokyakuTuutiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DsHanyouKokyakuTuutiRn";
    public static final String ZRNDSHANYOUKOKATETUUTIKEY = "zrndshanyoukokatetuutikey";
    public static final String ZRNDSKOKNO               = "zrndskokno";
    public static final String ZRNDSTUUTIKBN            = "zrndstuutikbn";
    public static final String ZRNATESAKIYNO            = "zrnatesakiyno";
    public static final String ZRNATESAKIADR1           = "zrnatesakiadr1";
    public static final String ZRNATESAKIADR2           = "zrnatesakiadr2";
    public static final String ZRNATESAKIADR3           = "zrnatesakiadr3";
    public static final String ZRNATENA1                = "zrnatena1";
    public static final String ZRNATENA2                = "zrnatena2";
    public static final String ZRNATESAKIYNOBARCODE     = "zrnatesakiynobarcode";
    public static final String ZRNDAI1SYOUKAIFREEAREA11 = "zrndai1syoukaifreearea11";
    public static final String ZRNDAI1SYOUKAIFREEAREA12 = "zrndai1syoukaifreearea12";
    public static final String ZRNDAI1SYOUKAIFREEAREA13 = "zrndai1syoukaifreearea13";
    public static final String ZRNDAI1SYOUKAIFREEAREA14 = "zrndai1syoukaifreearea14";
    public static final String ZRNDAI1SYOUKAIFREEAREA15 = "zrndai1syoukaifreearea15";
    public static final String ZRNSCDAI2SYOUKAIFREEAREA1 = "zrnscdai2syoukaifreearea1";
    public static final String ZRNSCDAI2SYOUKAIFREEAREA2 = "zrnscdai2syoukaifreearea2";
    public static final String ZRNSCDAI2SYOUKAIFREEAREA3 = "zrnscdai2syoukaifreearea3";
    public static final String ZRNSCDAI2SYOUKAIFREEAREA4 = "zrnscdai2syoukaifreearea4";
    public static final String ZRNSCDAI2SYOUKAIFREEAREA5 = "zrnscdai2syoukaifreearea5";
    public static final String ZRNSAKUSEIMD             = "zrnsakuseimd";
    public static final String ZRNSCLAKADSKOKNO         = "zrnsclakadskokno";
    public static final String ZRNREIGAISYORIHYJ        = "zrnreigaisyorihyj";
    public static final String ZRNSAKUSEINO             = "zrnsakuseino";
    public static final String ZRNCODE                  = "zrncode";
    public static final String ZRNTUUTIMEI              = "zrntuutimei";
    public static final String ZRNFREEAREA11            = "zrnfreearea11";
    public static final String ZRNFREEAREA12            = "zrnfreearea12";
    public static final String ZRNFREEAREA13            = "zrnfreearea13";
    public static final String ZRNFREEAREA14            = "zrnfreearea14";
    public static final String ZRNFREEAREA15            = "zrnfreearea15";
    public static final String ZRNFREEAREA16            = "zrnfreearea16";
    public static final String ZRNFREEAREA17            = "zrnfreearea17";
    public static final String ZRNFREEAREA18            = "zrnfreearea18";
    public static final String ZRNFREEAREA19            = "zrnfreearea19";
    public static final String ZRNFREEAREA110           = "zrnfreearea110";
    public static final String ZRNFREEAREA111           = "zrnfreearea111";
    public static final String ZRNFREEAREA112           = "zrnfreearea112";
    public static final String ZRNFREEAREA113           = "zrnfreearea113";
    public static final String ZRNFREEAREA114           = "zrnfreearea114";
    public static final String ZRNFREEAREA115           = "zrnfreearea115";
    public static final String ZRNFREEAREA116           = "zrnfreearea116";
    public static final String ZRNFREEAREA117           = "zrnfreearea117";
    public static final String ZRNFREEAREA118           = "zrnfreearea118";
    public static final String ZRNFREEAREA119           = "zrnfreearea119";
    public static final String ZRNFREEAREA120           = "zrnfreearea120";
    public static final String ZRNFREEAREA121           = "zrnfreearea121";
    public static final String ZRNFREEAREA122           = "zrnfreearea122";
    public static final String ZRNFREEAREA123           = "zrnfreearea123";
    public static final String ZRNFREEAREA124           = "zrnfreearea124";
    public static final String ZRNFREEAREA125           = "zrnfreearea125";
    public static final String ZRNFREEAREA126           = "zrnfreearea126";
    public static final String ZRNFREEAREA127           = "zrnfreearea127";
    public static final String ZRNFREEAREA128           = "zrnfreearea128";
    public static final String ZRNFREEAREA21            = "zrnfreearea21";
    public static final String ZRNFREEAREA22            = "zrnfreearea22";
    public static final String ZRNFREEAREA23            = "zrnfreearea23";
    public static final String ZRNFREEAREA24            = "zrnfreearea24";
    public static final String ZRNFREEAREA25            = "zrnfreearea25";
    public static final String ZRNFREEAREA26            = "zrnfreearea26";
    public static final String ZRNFREEAREA27            = "zrnfreearea27";
    public static final String ZRNFREEAREA28            = "zrnfreearea28";
    public static final String ZRNFREEAREA29            = "zrnfreearea29";
    public static final String ZRNFREEAREA210           = "zrnfreearea210";
    public static final String ZRNFREEAREA211           = "zrnfreearea211";
    public static final String ZRNFREEAREA212           = "zrnfreearea212";
    public static final String ZRNFREEAREA213           = "zrnfreearea213";
    public static final String ZRNFREEAREA214           = "zrnfreearea214";
    public static final String ZRNFREEAREA215           = "zrnfreearea215";
    public static final String ZRNFREEAREA216           = "zrnfreearea216";
    public static final String ZRNFREEAREA217           = "zrnfreearea217";
    public static final String ZRNFREEAREA218           = "zrnfreearea218";
    public static final String ZRNFREEAREA219           = "zrnfreearea219";
    public static final String ZRNFREEAREA220           = "zrnfreearea220";
    public static final String ZRNFREEAREA221           = "zrnfreearea221";
    public static final String ZRNFREEAREA222           = "zrnfreearea222";
    public static final String ZRNFREEAREA223           = "zrnfreearea223";
    public static final String ZRNFREEAREA224           = "zrnfreearea224";
    public static final String ZRNFREEAREA225           = "zrnfreearea225";
    public static final String ZRNFREEAREA226           = "zrnfreearea226";
    public static final String ZRNFREEAREA227           = "zrnfreearea227";
    public static final String ZRNFREEAREA228           = "zrnfreearea228";

    private final PKZT_DsHanyouKokyakuTuutiRn primaryKey;

    public GenZT_DsHanyouKokyakuTuutiRn() {
        primaryKey = new PKZT_DsHanyouKokyakuTuutiRn();
    }

    public GenZT_DsHanyouKokyakuTuutiRn(
        String pZrndshanyoukokatetuutikey,
        String pZrndskokno,
        String pZrndstuutikbn
    ) {
        primaryKey = new PKZT_DsHanyouKokyakuTuutiRn(
            pZrndshanyoukokatetuutikey,
            pZrndskokno,
            pZrndstuutikbn
        );
    }

    @Transient
    @Override
    public PKZT_DsHanyouKokyakuTuutiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DsHanyouKokyakuTuutiRn> getMetaClass() {
        return QZT_DsHanyouKokyakuTuutiRn.class;
    }

    @Id
    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNDSHANYOUKOKATETUUTIKEY)
    public String getZrndshanyoukokatetuutikey() {
        return getPrimaryKey().getZrndshanyoukokatetuutikey();
    }

    public void setZrndshanyoukokatetuutikey(String pZrndshanyoukokatetuutikey) {
        getPrimaryKey().setZrndshanyoukokatetuutikey(pZrndshanyoukokatetuutikey);
    }

    @Id
    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNDSKOKNO)
    public String getZrndskokno() {
        return getPrimaryKey().getZrndskokno();
    }

    public void setZrndskokno(String pZrndskokno) {
        getPrimaryKey().setZrndskokno(pZrndskokno);
    }

    @Id
    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNDSTUUTIKBN)
    public String getZrndstuutikbn() {
        return getPrimaryKey().getZrndstuutikbn();
    }

    public void setZrndstuutikbn(String pZrndstuutikbn) {
        getPrimaryKey().setZrndstuutikbn(pZrndstuutikbn);
    }

    private String zrnatesakiyno;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNATESAKIYNO)
    public String getZrnatesakiyno() {
        return zrnatesakiyno;
    }

    @DataConvert("toMultiByte")
    public void setZrnatesakiyno(String pZrnatesakiyno) {
        zrnatesakiyno = pZrnatesakiyno;
    }

    private String zrnatesakiadr1;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNATESAKIADR1)
    public String getZrnatesakiadr1() {
        return zrnatesakiadr1;
    }

    @DataConvert("toMultiByte")
    public void setZrnatesakiadr1(String pZrnatesakiadr1) {
        zrnatesakiadr1 = pZrnatesakiadr1;
    }

    private String zrnatesakiadr2;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNATESAKIADR2)
    public String getZrnatesakiadr2() {
        return zrnatesakiadr2;
    }

    @DataConvert("toMultiByte")
    public void setZrnatesakiadr2(String pZrnatesakiadr2) {
        zrnatesakiadr2 = pZrnatesakiadr2;
    }

    private String zrnatesakiadr3;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNATESAKIADR3)
    public String getZrnatesakiadr3() {
        return zrnatesakiadr3;
    }

    @DataConvert("toMultiByte")
    public void setZrnatesakiadr3(String pZrnatesakiadr3) {
        zrnatesakiadr3 = pZrnatesakiadr3;
    }

    private String zrnatena1;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNATENA1)
    public String getZrnatena1() {
        return zrnatena1;
    }

    @DataConvert("toMultiByte")
    public void setZrnatena1(String pZrnatena1) {
        zrnatena1 = pZrnatena1;
    }

    private String zrnatena2;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNATENA2)
    public String getZrnatena2() {
        return zrnatena2;
    }

    @DataConvert("toMultiByte")
    public void setZrnatena2(String pZrnatena2) {
        zrnatena2 = pZrnatena2;
    }

    private String zrnatesakiynobarcode;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNATESAKIYNOBARCODE)
    public String getZrnatesakiynobarcode() {
        return zrnatesakiynobarcode;
    }

    public void setZrnatesakiynobarcode(String pZrnatesakiynobarcode) {
        zrnatesakiynobarcode = pZrnatesakiynobarcode;
    }

    private String zrndai1syoukaifreearea11;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNDAI1SYOUKAIFREEAREA11)
    public String getZrndai1syoukaifreearea11() {
        return zrndai1syoukaifreearea11;
    }

    @DataConvert("toMultiByte")
    public void setZrndai1syoukaifreearea11(String pZrndai1syoukaifreearea11) {
        zrndai1syoukaifreearea11 = pZrndai1syoukaifreearea11;
    }

    private String zrndai1syoukaifreearea12;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNDAI1SYOUKAIFREEAREA12)
    public String getZrndai1syoukaifreearea12() {
        return zrndai1syoukaifreearea12;
    }

    @DataConvert("toMultiByte")
    public void setZrndai1syoukaifreearea12(String pZrndai1syoukaifreearea12) {
        zrndai1syoukaifreearea12 = pZrndai1syoukaifreearea12;
    }

    private String zrndai1syoukaifreearea13;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNDAI1SYOUKAIFREEAREA13)
    public String getZrndai1syoukaifreearea13() {
        return zrndai1syoukaifreearea13;
    }

    @DataConvert("toMultiByte")
    public void setZrndai1syoukaifreearea13(String pZrndai1syoukaifreearea13) {
        zrndai1syoukaifreearea13 = pZrndai1syoukaifreearea13;
    }

    private String zrndai1syoukaifreearea14;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNDAI1SYOUKAIFREEAREA14)
    public String getZrndai1syoukaifreearea14() {
        return zrndai1syoukaifreearea14;
    }

    @DataConvert("toMultiByte")
    public void setZrndai1syoukaifreearea14(String pZrndai1syoukaifreearea14) {
        zrndai1syoukaifreearea14 = pZrndai1syoukaifreearea14;
    }

    private String zrndai1syoukaifreearea15;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNDAI1SYOUKAIFREEAREA15)
    public String getZrndai1syoukaifreearea15() {
        return zrndai1syoukaifreearea15;
    }

    @DataConvert("toMultiByte")
    public void setZrndai1syoukaifreearea15(String pZrndai1syoukaifreearea15) {
        zrndai1syoukaifreearea15 = pZrndai1syoukaifreearea15;
    }

    private String zrnscdai2syoukaifreearea1;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNSCDAI2SYOUKAIFREEAREA1)
    public String getZrnscdai2syoukaifreearea1() {
        return zrnscdai2syoukaifreearea1;
    }

    @DataConvert("toMultiByte")
    public void setZrnscdai2syoukaifreearea1(String pZrnscdai2syoukaifreearea1) {
        zrnscdai2syoukaifreearea1 = pZrnscdai2syoukaifreearea1;
    }

    private String zrnscdai2syoukaifreearea2;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNSCDAI2SYOUKAIFREEAREA2)
    public String getZrnscdai2syoukaifreearea2() {
        return zrnscdai2syoukaifreearea2;
    }

    @DataConvert("toMultiByte")
    public void setZrnscdai2syoukaifreearea2(String pZrnscdai2syoukaifreearea2) {
        zrnscdai2syoukaifreearea2 = pZrnscdai2syoukaifreearea2;
    }

    private String zrnscdai2syoukaifreearea3;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNSCDAI2SYOUKAIFREEAREA3)
    public String getZrnscdai2syoukaifreearea3() {
        return zrnscdai2syoukaifreearea3;
    }

    @DataConvert("toMultiByte")
    public void setZrnscdai2syoukaifreearea3(String pZrnscdai2syoukaifreearea3) {
        zrnscdai2syoukaifreearea3 = pZrnscdai2syoukaifreearea3;
    }

    private String zrnscdai2syoukaifreearea4;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNSCDAI2SYOUKAIFREEAREA4)
    public String getZrnscdai2syoukaifreearea4() {
        return zrnscdai2syoukaifreearea4;
    }

    @DataConvert("toMultiByte")
    public void setZrnscdai2syoukaifreearea4(String pZrnscdai2syoukaifreearea4) {
        zrnscdai2syoukaifreearea4 = pZrnscdai2syoukaifreearea4;
    }

    private String zrnscdai2syoukaifreearea5;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNSCDAI2SYOUKAIFREEAREA5)
    public String getZrnscdai2syoukaifreearea5() {
        return zrnscdai2syoukaifreearea5;
    }

    @DataConvert("toMultiByte")
    public void setZrnscdai2syoukaifreearea5(String pZrnscdai2syoukaifreearea5) {
        zrnscdai2syoukaifreearea5 = pZrnscdai2syoukaifreearea5;
    }

    private String zrnsakuseimd;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNSAKUSEIMD)
    public String getZrnsakuseimd() {
        return zrnsakuseimd;
    }

    public void setZrnsakuseimd(String pZrnsakuseimd) {
        zrnsakuseimd = pZrnsakuseimd;
    }

    private String zrnsclakadskokno;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNSCLAKADSKOKNO)
    public String getZrnsclakadskokno() {
        return zrnsclakadskokno;
    }

    public void setZrnsclakadskokno(String pZrnsclakadskokno) {
        zrnsclakadskokno = pZrnsclakadskokno;
    }

    private String zrnreigaisyorihyj;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNREIGAISYORIHYJ)
    public String getZrnreigaisyorihyj() {
        return zrnreigaisyorihyj;
    }

    public void setZrnreigaisyorihyj(String pZrnreigaisyorihyj) {
        zrnreigaisyorihyj = pZrnreigaisyorihyj;
    }

    private String zrnsakuseino;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNSAKUSEINO)
    public String getZrnsakuseino() {
        return zrnsakuseino;
    }

    public void setZrnsakuseino(String pZrnsakuseino) {
        zrnsakuseino = pZrnsakuseino;
    }

    private String zrncode;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNCODE)
    public String getZrncode() {
        return zrncode;
    }

    public void setZrncode(String pZrncode) {
        zrncode = pZrncode;
    }

    private String zrntuutimei;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNTUUTIMEI)
    public String getZrntuutimei() {
        return zrntuutimei;
    }

    @DataConvert("toMultiByte")
    public void setZrntuutimei(String pZrntuutimei) {
        zrntuutimei = pZrntuutimei;
    }

    private String zrnfreearea11;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA11)
    public String getZrnfreearea11() {
        return zrnfreearea11;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea11(String pZrnfreearea11) {
        zrnfreearea11 = pZrnfreearea11;
    }

    private String zrnfreearea12;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA12)
    public String getZrnfreearea12() {
        return zrnfreearea12;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea12(String pZrnfreearea12) {
        zrnfreearea12 = pZrnfreearea12;
    }

    private String zrnfreearea13;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA13)
    public String getZrnfreearea13() {
        return zrnfreearea13;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea13(String pZrnfreearea13) {
        zrnfreearea13 = pZrnfreearea13;
    }

    private String zrnfreearea14;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA14)
    public String getZrnfreearea14() {
        return zrnfreearea14;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea14(String pZrnfreearea14) {
        zrnfreearea14 = pZrnfreearea14;
    }

    private String zrnfreearea15;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA15)
    public String getZrnfreearea15() {
        return zrnfreearea15;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea15(String pZrnfreearea15) {
        zrnfreearea15 = pZrnfreearea15;
    }

    private String zrnfreearea16;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA16)
    public String getZrnfreearea16() {
        return zrnfreearea16;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea16(String pZrnfreearea16) {
        zrnfreearea16 = pZrnfreearea16;
    }

    private String zrnfreearea17;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA17)
    public String getZrnfreearea17() {
        return zrnfreearea17;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea17(String pZrnfreearea17) {
        zrnfreearea17 = pZrnfreearea17;
    }

    private String zrnfreearea18;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA18)
    public String getZrnfreearea18() {
        return zrnfreearea18;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea18(String pZrnfreearea18) {
        zrnfreearea18 = pZrnfreearea18;
    }

    private String zrnfreearea19;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA19)
    public String getZrnfreearea19() {
        return zrnfreearea19;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea19(String pZrnfreearea19) {
        zrnfreearea19 = pZrnfreearea19;
    }

    private String zrnfreearea110;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA110)
    public String getZrnfreearea110() {
        return zrnfreearea110;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea110(String pZrnfreearea110) {
        zrnfreearea110 = pZrnfreearea110;
    }

    private String zrnfreearea111;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA111)
    public String getZrnfreearea111() {
        return zrnfreearea111;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea111(String pZrnfreearea111) {
        zrnfreearea111 = pZrnfreearea111;
    }

    private String zrnfreearea112;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA112)
    public String getZrnfreearea112() {
        return zrnfreearea112;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea112(String pZrnfreearea112) {
        zrnfreearea112 = pZrnfreearea112;
    }

    private String zrnfreearea113;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA113)
    public String getZrnfreearea113() {
        return zrnfreearea113;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea113(String pZrnfreearea113) {
        zrnfreearea113 = pZrnfreearea113;
    }

    private String zrnfreearea114;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA114)
    public String getZrnfreearea114() {
        return zrnfreearea114;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea114(String pZrnfreearea114) {
        zrnfreearea114 = pZrnfreearea114;
    }

    private String zrnfreearea115;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA115)
    public String getZrnfreearea115() {
        return zrnfreearea115;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea115(String pZrnfreearea115) {
        zrnfreearea115 = pZrnfreearea115;
    }

    private String zrnfreearea116;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA116)
    public String getZrnfreearea116() {
        return zrnfreearea116;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea116(String pZrnfreearea116) {
        zrnfreearea116 = pZrnfreearea116;
    }

    private String zrnfreearea117;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA117)
    public String getZrnfreearea117() {
        return zrnfreearea117;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea117(String pZrnfreearea117) {
        zrnfreearea117 = pZrnfreearea117;
    }

    private String zrnfreearea118;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA118)
    public String getZrnfreearea118() {
        return zrnfreearea118;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea118(String pZrnfreearea118) {
        zrnfreearea118 = pZrnfreearea118;
    }

    private String zrnfreearea119;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA119)
    public String getZrnfreearea119() {
        return zrnfreearea119;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea119(String pZrnfreearea119) {
        zrnfreearea119 = pZrnfreearea119;
    }

    private String zrnfreearea120;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA120)
    public String getZrnfreearea120() {
        return zrnfreearea120;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea120(String pZrnfreearea120) {
        zrnfreearea120 = pZrnfreearea120;
    }

    private String zrnfreearea121;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA121)
    public String getZrnfreearea121() {
        return zrnfreearea121;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea121(String pZrnfreearea121) {
        zrnfreearea121 = pZrnfreearea121;
    }

    private String zrnfreearea122;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA122)
    public String getZrnfreearea122() {
        return zrnfreearea122;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea122(String pZrnfreearea122) {
        zrnfreearea122 = pZrnfreearea122;
    }

    private String zrnfreearea123;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA123)
    public String getZrnfreearea123() {
        return zrnfreearea123;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea123(String pZrnfreearea123) {
        zrnfreearea123 = pZrnfreearea123;
    }

    private String zrnfreearea124;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA124)
    public String getZrnfreearea124() {
        return zrnfreearea124;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea124(String pZrnfreearea124) {
        zrnfreearea124 = pZrnfreearea124;
    }

    private String zrnfreearea125;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA125)
    public String getZrnfreearea125() {
        return zrnfreearea125;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea125(String pZrnfreearea125) {
        zrnfreearea125 = pZrnfreearea125;
    }

    private String zrnfreearea126;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA126)
    public String getZrnfreearea126() {
        return zrnfreearea126;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea126(String pZrnfreearea126) {
        zrnfreearea126 = pZrnfreearea126;
    }

    private String zrnfreearea127;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA127)
    public String getZrnfreearea127() {
        return zrnfreearea127;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea127(String pZrnfreearea127) {
        zrnfreearea127 = pZrnfreearea127;
    }

    private String zrnfreearea128;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA128)
    public String getZrnfreearea128() {
        return zrnfreearea128;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea128(String pZrnfreearea128) {
        zrnfreearea128 = pZrnfreearea128;
    }

    private String zrnfreearea21;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA21)
    public String getZrnfreearea21() {
        return zrnfreearea21;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea21(String pZrnfreearea21) {
        zrnfreearea21 = pZrnfreearea21;
    }

    private String zrnfreearea22;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA22)
    public String getZrnfreearea22() {
        return zrnfreearea22;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea22(String pZrnfreearea22) {
        zrnfreearea22 = pZrnfreearea22;
    }

    private String zrnfreearea23;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA23)
    public String getZrnfreearea23() {
        return zrnfreearea23;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea23(String pZrnfreearea23) {
        zrnfreearea23 = pZrnfreearea23;
    }

    private String zrnfreearea24;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA24)
    public String getZrnfreearea24() {
        return zrnfreearea24;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea24(String pZrnfreearea24) {
        zrnfreearea24 = pZrnfreearea24;
    }

    private String zrnfreearea25;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA25)
    public String getZrnfreearea25() {
        return zrnfreearea25;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea25(String pZrnfreearea25) {
        zrnfreearea25 = pZrnfreearea25;
    }

    private String zrnfreearea26;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA26)
    public String getZrnfreearea26() {
        return zrnfreearea26;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea26(String pZrnfreearea26) {
        zrnfreearea26 = pZrnfreearea26;
    }

    private String zrnfreearea27;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA27)
    public String getZrnfreearea27() {
        return zrnfreearea27;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea27(String pZrnfreearea27) {
        zrnfreearea27 = pZrnfreearea27;
    }

    private String zrnfreearea28;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA28)
    public String getZrnfreearea28() {
        return zrnfreearea28;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea28(String pZrnfreearea28) {
        zrnfreearea28 = pZrnfreearea28;
    }

    private String zrnfreearea29;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA29)
    public String getZrnfreearea29() {
        return zrnfreearea29;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea29(String pZrnfreearea29) {
        zrnfreearea29 = pZrnfreearea29;
    }

    private String zrnfreearea210;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA210)
    public String getZrnfreearea210() {
        return zrnfreearea210;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea210(String pZrnfreearea210) {
        zrnfreearea210 = pZrnfreearea210;
    }

    private String zrnfreearea211;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA211)
    public String getZrnfreearea211() {
        return zrnfreearea211;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea211(String pZrnfreearea211) {
        zrnfreearea211 = pZrnfreearea211;
    }

    private String zrnfreearea212;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA212)
    public String getZrnfreearea212() {
        return zrnfreearea212;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea212(String pZrnfreearea212) {
        zrnfreearea212 = pZrnfreearea212;
    }

    private String zrnfreearea213;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA213)
    public String getZrnfreearea213() {
        return zrnfreearea213;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea213(String pZrnfreearea213) {
        zrnfreearea213 = pZrnfreearea213;
    }

    private String zrnfreearea214;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA214)
    public String getZrnfreearea214() {
        return zrnfreearea214;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea214(String pZrnfreearea214) {
        zrnfreearea214 = pZrnfreearea214;
    }

    private String zrnfreearea215;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA215)
    public String getZrnfreearea215() {
        return zrnfreearea215;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea215(String pZrnfreearea215) {
        zrnfreearea215 = pZrnfreearea215;
    }

    private String zrnfreearea216;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA216)
    public String getZrnfreearea216() {
        return zrnfreearea216;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea216(String pZrnfreearea216) {
        zrnfreearea216 = pZrnfreearea216;
    }

    private String zrnfreearea217;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA217)
    public String getZrnfreearea217() {
        return zrnfreearea217;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea217(String pZrnfreearea217) {
        zrnfreearea217 = pZrnfreearea217;
    }

    private String zrnfreearea218;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA218)
    public String getZrnfreearea218() {
        return zrnfreearea218;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea218(String pZrnfreearea218) {
        zrnfreearea218 = pZrnfreearea218;
    }

    private String zrnfreearea219;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA219)
    public String getZrnfreearea219() {
        return zrnfreearea219;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea219(String pZrnfreearea219) {
        zrnfreearea219 = pZrnfreearea219;
    }

    private String zrnfreearea220;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA220)
    public String getZrnfreearea220() {
        return zrnfreearea220;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea220(String pZrnfreearea220) {
        zrnfreearea220 = pZrnfreearea220;
    }

    private String zrnfreearea221;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA221)
    public String getZrnfreearea221() {
        return zrnfreearea221;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea221(String pZrnfreearea221) {
        zrnfreearea221 = pZrnfreearea221;
    }

    private String zrnfreearea222;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA222)
    public String getZrnfreearea222() {
        return zrnfreearea222;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea222(String pZrnfreearea222) {
        zrnfreearea222 = pZrnfreearea222;
    }

    private String zrnfreearea223;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA223)
    public String getZrnfreearea223() {
        return zrnfreearea223;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea223(String pZrnfreearea223) {
        zrnfreearea223 = pZrnfreearea223;
    }

    private String zrnfreearea224;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA224)
    public String getZrnfreearea224() {
        return zrnfreearea224;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea224(String pZrnfreearea224) {
        zrnfreearea224 = pZrnfreearea224;
    }

    private String zrnfreearea225;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA225)
    public String getZrnfreearea225() {
        return zrnfreearea225;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea225(String pZrnfreearea225) {
        zrnfreearea225 = pZrnfreearea225;
    }

    private String zrnfreearea226;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA226)
    public String getZrnfreearea226() {
        return zrnfreearea226;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea226(String pZrnfreearea226) {
        zrnfreearea226 = pZrnfreearea226;
    }

    private String zrnfreearea227;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA227)
    public String getZrnfreearea227() {
        return zrnfreearea227;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea227(String pZrnfreearea227) {
        zrnfreearea227 = pZrnfreearea227;
    }

    private String zrnfreearea228;

    @Column(name=GenZT_DsHanyouKokyakuTuutiRn.ZRNFREEAREA228)
    public String getZrnfreearea228() {
        return zrnfreearea228;
    }

    @DataConvert("toMultiByte")
    public void setZrnfreearea228(String pZrnfreearea228) {
        zrnfreearea228 = pZrnfreearea228;
    }
}