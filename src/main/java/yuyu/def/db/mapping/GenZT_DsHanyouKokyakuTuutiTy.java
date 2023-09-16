package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_DsHanyouKokyakuTuutiTy;
import yuyu.def.db.id.PKZT_DsHanyouKokyakuTuutiTy;
import yuyu.def.db.meta.GenQZT_DsHanyouKokyakuTuutiTy;
import yuyu.def.db.meta.QZT_DsHanyouKokyakuTuutiTy;

/**
 * ＤＳ汎用顧客宛通知テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_DsHanyouKokyakuTuutiTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DsHanyouKokyakuTuutiTy}</td><td colspan="3">ＤＳ汎用顧客宛通知テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtydshanyoukokatetuutikey ztydshanyoukokatetuutikey}</td><td>（中継用）ＤＳ汎用顧客宛通知キー</td><td align="center">{@link PKZT_DsHanyouKokyakuTuutiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydskokno ztydskokno}</td><td>（中継用）ＤＳ顧客番号</td><td align="center">{@link PKZT_DsHanyouKokyakuTuutiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydstuutikbn ztydstuutikbn}</td><td>（中継用）ＤＳ通知区分</td><td align="center">{@link PKZT_DsHanyouKokyakuTuutiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatesakiyno ztyatesakiyno}</td><td>（中継用）宛先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatesakiadr1 ztyatesakiadr1}</td><td>（中継用）宛先住所１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatesakiadr2 ztyatesakiadr2}</td><td>（中継用）宛先住所２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatesakiadr3 ztyatesakiadr3}</td><td>（中継用）宛先住所３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatena1 ztyatena1}</td><td>（中継用）宛名１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatena2 ztyatena2}</td><td>（中継用）宛名２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatesakiynobarcode ztyatesakiynobarcode}</td><td>（中継用）宛先郵便番号バーコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syoukaifreearea11 ztydai1syoukaifreearea11}</td><td>（中継用）第１照会先フリーエリア１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syoukaifreearea12 ztydai1syoukaifreearea12}</td><td>（中継用）第１照会先フリーエリア１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syoukaifreearea13 ztydai1syoukaifreearea13}</td><td>（中継用）第１照会先フリーエリア１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syoukaifreearea14 ztydai1syoukaifreearea14}</td><td>（中継用）第１照会先フリーエリア１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syoukaifreearea15 ztydai1syoukaifreearea15}</td><td>（中継用）第１照会先フリーエリア１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyscdai2syoukaifreearea1 ztyscdai2syoukaifreearea1}</td><td>（中継用）ＳＣ第２照会先フリ－エリア１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyscdai2syoukaifreearea2 ztyscdai2syoukaifreearea2}</td><td>（中継用）ＳＣ第２照会先フリ－エリア２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyscdai2syoukaifreearea3 ztyscdai2syoukaifreearea3}</td><td>（中継用）ＳＣ第２照会先フリ－エリア３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyscdai2syoukaifreearea4 ztyscdai2syoukaifreearea4}</td><td>（中継用）ＳＣ第２照会先フリ－エリア４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyscdai2syoukaifreearea5 ztyscdai2syoukaifreearea5}</td><td>（中継用）ＳＣ第２照会先フリ－エリア５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysakuseimd ztysakuseimd}</td><td>（中継用）作成月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysclakadskokno ztysclakadskokno}</td><td>（中継用）スクランブル化ＤＳ顧客番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyreigaisyorihyj ztyreigaisyorihyj}</td><td>（中継用）例外処理表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysakuseino ztysakuseino}</td><td>（中継用）作成No</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycode ztycode}</td><td>（中継用）コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuutimei ztytuutimei}</td><td>（中継用）通知名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea11 ztyfreearea11}</td><td>（中継用）フリーエリア１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea12 ztyfreearea12}</td><td>（中継用）フリーエリア１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea13 ztyfreearea13}</td><td>（中継用）フリーエリア１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea14 ztyfreearea14}</td><td>（中継用）フリーエリア１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea15 ztyfreearea15}</td><td>（中継用）フリーエリア１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea16 ztyfreearea16}</td><td>（中継用）フリーエリア１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea17 ztyfreearea17}</td><td>（中継用）フリーエリア１＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea18 ztyfreearea18}</td><td>（中継用）フリーエリア１＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea19 ztyfreearea19}</td><td>（中継用）フリーエリア１＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea110 ztyfreearea110}</td><td>（中継用）フリーエリア１＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea111 ztyfreearea111}</td><td>（中継用）フリーエリア１＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea112 ztyfreearea112}</td><td>（中継用）フリーエリア１＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea113 ztyfreearea113}</td><td>（中継用）フリーエリア１＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea114 ztyfreearea114}</td><td>（中継用）フリーエリア１＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea115 ztyfreearea115}</td><td>（中継用）フリーエリア１＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea116 ztyfreearea116}</td><td>（中継用）フリーエリア１＿１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea117 ztyfreearea117}</td><td>（中継用）フリーエリア１＿１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea118 ztyfreearea118}</td><td>（中継用）フリーエリア１＿１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea119 ztyfreearea119}</td><td>（中継用）フリーエリア１＿１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea120 ztyfreearea120}</td><td>（中継用）フリーエリア１＿２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea121 ztyfreearea121}</td><td>（中継用）フリーエリア１＿２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea122 ztyfreearea122}</td><td>（中継用）フリーエリア１＿２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea123 ztyfreearea123}</td><td>（中継用）フリーエリア１＿２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea124 ztyfreearea124}</td><td>（中継用）フリーエリア１＿２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea125 ztyfreearea125}</td><td>（中継用）フリーエリア１＿２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea126 ztyfreearea126}</td><td>（中継用）フリーエリア１＿２６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea127 ztyfreearea127}</td><td>（中継用）フリーエリア１＿２７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea128 ztyfreearea128}</td><td>（中継用）フリーエリア１＿２８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea21 ztyfreearea21}</td><td>（中継用）フリーエリア２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea22 ztyfreearea22}</td><td>（中継用）フリーエリア２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea23 ztyfreearea23}</td><td>（中継用）フリーエリア２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea24 ztyfreearea24}</td><td>（中継用）フリーエリア２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea25 ztyfreearea25}</td><td>（中継用）フリーエリア２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea26 ztyfreearea26}</td><td>（中継用）フリーエリア２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea27 ztyfreearea27}</td><td>（中継用）フリーエリア２＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea28 ztyfreearea28}</td><td>（中継用）フリーエリア２＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea29 ztyfreearea29}</td><td>（中継用）フリーエリア２＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea210 ztyfreearea210}</td><td>（中継用）フリーエリア２＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea211 ztyfreearea211}</td><td>（中継用）フリーエリア２＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea212 ztyfreearea212}</td><td>（中継用）フリーエリア２＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea213 ztyfreearea213}</td><td>（中継用）フリーエリア２＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea214 ztyfreearea214}</td><td>（中継用）フリーエリア２＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea215 ztyfreearea215}</td><td>（中継用）フリーエリア２＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea216 ztyfreearea216}</td><td>（中継用）フリーエリア２＿１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea217 ztyfreearea217}</td><td>（中継用）フリーエリア２＿１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea218 ztyfreearea218}</td><td>（中継用）フリーエリア２＿１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea219 ztyfreearea219}</td><td>（中継用）フリーエリア２＿１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea220 ztyfreearea220}</td><td>（中継用）フリーエリア２＿２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea221 ztyfreearea221}</td><td>（中継用）フリーエリア２＿２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea222 ztyfreearea222}</td><td>（中継用）フリーエリア２＿２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea223 ztyfreearea223}</td><td>（中継用）フリーエリア２＿２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea224 ztyfreearea224}</td><td>（中継用）フリーエリア２＿２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea225 ztyfreearea225}</td><td>（中継用）フリーエリア２＿２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea226 ztyfreearea226}</td><td>（中継用）フリーエリア２＿２６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea227 ztyfreearea227}</td><td>（中継用）フリーエリア２＿２７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfreearea228 ztyfreearea228}</td><td>（中継用）フリーエリア２＿２８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_DsHanyouKokyakuTuutiTy
 * @see     PKZT_DsHanyouKokyakuTuutiTy
 * @see     QZT_DsHanyouKokyakuTuutiTy
 * @see     GenQZT_DsHanyouKokyakuTuutiTy
 */
@MappedSuperclass
@Table(name=GenZT_DsHanyouKokyakuTuutiTy.TABLE_NAME)
@IdClass(value=PKZT_DsHanyouKokyakuTuutiTy.class)
public abstract class GenZT_DsHanyouKokyakuTuutiTy extends AbstractExDBEntity<ZT_DsHanyouKokyakuTuutiTy, PKZT_DsHanyouKokyakuTuutiTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DsHanyouKokyakuTuutiTy";
    public static final String ZTYDSHANYOUKOKATETUUTIKEY = "ztydshanyoukokatetuutikey";
    public static final String ZTYDSKOKNO               = "ztydskokno";
    public static final String ZTYDSTUUTIKBN            = "ztydstuutikbn";
    public static final String ZTYATESAKIYNO            = "ztyatesakiyno";
    public static final String ZTYATESAKIADR1           = "ztyatesakiadr1";
    public static final String ZTYATESAKIADR2           = "ztyatesakiadr2";
    public static final String ZTYATESAKIADR3           = "ztyatesakiadr3";
    public static final String ZTYATENA1                = "ztyatena1";
    public static final String ZTYATENA2                = "ztyatena2";
    public static final String ZTYATESAKIYNOBARCODE     = "ztyatesakiynobarcode";
    public static final String ZTYDAI1SYOUKAIFREEAREA11 = "ztydai1syoukaifreearea11";
    public static final String ZTYDAI1SYOUKAIFREEAREA12 = "ztydai1syoukaifreearea12";
    public static final String ZTYDAI1SYOUKAIFREEAREA13 = "ztydai1syoukaifreearea13";
    public static final String ZTYDAI1SYOUKAIFREEAREA14 = "ztydai1syoukaifreearea14";
    public static final String ZTYDAI1SYOUKAIFREEAREA15 = "ztydai1syoukaifreearea15";
    public static final String ZTYSCDAI2SYOUKAIFREEAREA1 = "ztyscdai2syoukaifreearea1";
    public static final String ZTYSCDAI2SYOUKAIFREEAREA2 = "ztyscdai2syoukaifreearea2";
    public static final String ZTYSCDAI2SYOUKAIFREEAREA3 = "ztyscdai2syoukaifreearea3";
    public static final String ZTYSCDAI2SYOUKAIFREEAREA4 = "ztyscdai2syoukaifreearea4";
    public static final String ZTYSCDAI2SYOUKAIFREEAREA5 = "ztyscdai2syoukaifreearea5";
    public static final String ZTYSAKUSEIMD             = "ztysakuseimd";
    public static final String ZTYSCLAKADSKOKNO         = "ztysclakadskokno";
    public static final String ZTYREIGAISYORIHYJ        = "ztyreigaisyorihyj";
    public static final String ZTYSAKUSEINO             = "ztysakuseino";
    public static final String ZTYCODE                  = "ztycode";
    public static final String ZTYTUUTIMEI              = "ztytuutimei";
    public static final String ZTYFREEAREA11            = "ztyfreearea11";
    public static final String ZTYFREEAREA12            = "ztyfreearea12";
    public static final String ZTYFREEAREA13            = "ztyfreearea13";
    public static final String ZTYFREEAREA14            = "ztyfreearea14";
    public static final String ZTYFREEAREA15            = "ztyfreearea15";
    public static final String ZTYFREEAREA16            = "ztyfreearea16";
    public static final String ZTYFREEAREA17            = "ztyfreearea17";
    public static final String ZTYFREEAREA18            = "ztyfreearea18";
    public static final String ZTYFREEAREA19            = "ztyfreearea19";
    public static final String ZTYFREEAREA110           = "ztyfreearea110";
    public static final String ZTYFREEAREA111           = "ztyfreearea111";
    public static final String ZTYFREEAREA112           = "ztyfreearea112";
    public static final String ZTYFREEAREA113           = "ztyfreearea113";
    public static final String ZTYFREEAREA114           = "ztyfreearea114";
    public static final String ZTYFREEAREA115           = "ztyfreearea115";
    public static final String ZTYFREEAREA116           = "ztyfreearea116";
    public static final String ZTYFREEAREA117           = "ztyfreearea117";
    public static final String ZTYFREEAREA118           = "ztyfreearea118";
    public static final String ZTYFREEAREA119           = "ztyfreearea119";
    public static final String ZTYFREEAREA120           = "ztyfreearea120";
    public static final String ZTYFREEAREA121           = "ztyfreearea121";
    public static final String ZTYFREEAREA122           = "ztyfreearea122";
    public static final String ZTYFREEAREA123           = "ztyfreearea123";
    public static final String ZTYFREEAREA124           = "ztyfreearea124";
    public static final String ZTYFREEAREA125           = "ztyfreearea125";
    public static final String ZTYFREEAREA126           = "ztyfreearea126";
    public static final String ZTYFREEAREA127           = "ztyfreearea127";
    public static final String ZTYFREEAREA128           = "ztyfreearea128";
    public static final String ZTYFREEAREA21            = "ztyfreearea21";
    public static final String ZTYFREEAREA22            = "ztyfreearea22";
    public static final String ZTYFREEAREA23            = "ztyfreearea23";
    public static final String ZTYFREEAREA24            = "ztyfreearea24";
    public static final String ZTYFREEAREA25            = "ztyfreearea25";
    public static final String ZTYFREEAREA26            = "ztyfreearea26";
    public static final String ZTYFREEAREA27            = "ztyfreearea27";
    public static final String ZTYFREEAREA28            = "ztyfreearea28";
    public static final String ZTYFREEAREA29            = "ztyfreearea29";
    public static final String ZTYFREEAREA210           = "ztyfreearea210";
    public static final String ZTYFREEAREA211           = "ztyfreearea211";
    public static final String ZTYFREEAREA212           = "ztyfreearea212";
    public static final String ZTYFREEAREA213           = "ztyfreearea213";
    public static final String ZTYFREEAREA214           = "ztyfreearea214";
    public static final String ZTYFREEAREA215           = "ztyfreearea215";
    public static final String ZTYFREEAREA216           = "ztyfreearea216";
    public static final String ZTYFREEAREA217           = "ztyfreearea217";
    public static final String ZTYFREEAREA218           = "ztyfreearea218";
    public static final String ZTYFREEAREA219           = "ztyfreearea219";
    public static final String ZTYFREEAREA220           = "ztyfreearea220";
    public static final String ZTYFREEAREA221           = "ztyfreearea221";
    public static final String ZTYFREEAREA222           = "ztyfreearea222";
    public static final String ZTYFREEAREA223           = "ztyfreearea223";
    public static final String ZTYFREEAREA224           = "ztyfreearea224";
    public static final String ZTYFREEAREA225           = "ztyfreearea225";
    public static final String ZTYFREEAREA226           = "ztyfreearea226";
    public static final String ZTYFREEAREA227           = "ztyfreearea227";
    public static final String ZTYFREEAREA228           = "ztyfreearea228";

    private final PKZT_DsHanyouKokyakuTuutiTy primaryKey;

    public GenZT_DsHanyouKokyakuTuutiTy() {
        primaryKey = new PKZT_DsHanyouKokyakuTuutiTy();
    }

    public GenZT_DsHanyouKokyakuTuutiTy(
        String pZtydshanyoukokatetuutikey,
        String pZtydskokno,
        String pZtydstuutikbn
    ) {
        primaryKey = new PKZT_DsHanyouKokyakuTuutiTy(
            pZtydshanyoukokatetuutikey,
            pZtydskokno,
            pZtydstuutikbn
        );
    }

    @Transient
    @Override
    public PKZT_DsHanyouKokyakuTuutiTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DsHanyouKokyakuTuutiTy> getMetaClass() {
        return QZT_DsHanyouKokyakuTuutiTy.class;
    }

    @Id
    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYDSHANYOUKOKATETUUTIKEY)
    public String getZtydshanyoukokatetuutikey() {
        return getPrimaryKey().getZtydshanyoukokatetuutikey();
    }

    public void setZtydshanyoukokatetuutikey(String pZtydshanyoukokatetuutikey) {
        getPrimaryKey().setZtydshanyoukokatetuutikey(pZtydshanyoukokatetuutikey);
    }

    @Id
    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYDSKOKNO)
    public String getZtydskokno() {
        return getPrimaryKey().getZtydskokno();
    }

    public void setZtydskokno(String pZtydskokno) {
        getPrimaryKey().setZtydskokno(pZtydskokno);
    }

    @Id
    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYDSTUUTIKBN)
    public String getZtydstuutikbn() {
        return getPrimaryKey().getZtydstuutikbn();
    }

    public void setZtydstuutikbn(String pZtydstuutikbn) {
        getPrimaryKey().setZtydstuutikbn(pZtydstuutikbn);
    }

    private String ztyatesakiyno;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYATESAKIYNO)
    public String getZtyatesakiyno() {
        return ztyatesakiyno;
    }

    public void setZtyatesakiyno(String pZtyatesakiyno) {
        ztyatesakiyno = pZtyatesakiyno;
    }

    private String ztyatesakiadr1;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYATESAKIADR1)
    public String getZtyatesakiadr1() {
        return ztyatesakiadr1;
    }

    public void setZtyatesakiadr1(String pZtyatesakiadr1) {
        ztyatesakiadr1 = pZtyatesakiadr1;
    }

    private String ztyatesakiadr2;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYATESAKIADR2)
    public String getZtyatesakiadr2() {
        return ztyatesakiadr2;
    }

    public void setZtyatesakiadr2(String pZtyatesakiadr2) {
        ztyatesakiadr2 = pZtyatesakiadr2;
    }

    private String ztyatesakiadr3;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYATESAKIADR3)
    public String getZtyatesakiadr3() {
        return ztyatesakiadr3;
    }

    public void setZtyatesakiadr3(String pZtyatesakiadr3) {
        ztyatesakiadr3 = pZtyatesakiadr3;
    }

    private String ztyatena1;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYATENA1)
    public String getZtyatena1() {
        return ztyatena1;
    }

    public void setZtyatena1(String pZtyatena1) {
        ztyatena1 = pZtyatena1;
    }

    private String ztyatena2;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYATENA2)
    public String getZtyatena2() {
        return ztyatena2;
    }

    public void setZtyatena2(String pZtyatena2) {
        ztyatena2 = pZtyatena2;
    }

    private String ztyatesakiynobarcode;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYATESAKIYNOBARCODE)
    public String getZtyatesakiynobarcode() {
        return ztyatesakiynobarcode;
    }

    public void setZtyatesakiynobarcode(String pZtyatesakiynobarcode) {
        ztyatesakiynobarcode = pZtyatesakiynobarcode;
    }

    private String ztydai1syoukaifreearea11;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYDAI1SYOUKAIFREEAREA11)
    public String getZtydai1syoukaifreearea11() {
        return ztydai1syoukaifreearea11;
    }

    public void setZtydai1syoukaifreearea11(String pZtydai1syoukaifreearea11) {
        ztydai1syoukaifreearea11 = pZtydai1syoukaifreearea11;
    }

    private String ztydai1syoukaifreearea12;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYDAI1SYOUKAIFREEAREA12)
    public String getZtydai1syoukaifreearea12() {
        return ztydai1syoukaifreearea12;
    }

    public void setZtydai1syoukaifreearea12(String pZtydai1syoukaifreearea12) {
        ztydai1syoukaifreearea12 = pZtydai1syoukaifreearea12;
    }

    private String ztydai1syoukaifreearea13;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYDAI1SYOUKAIFREEAREA13)
    public String getZtydai1syoukaifreearea13() {
        return ztydai1syoukaifreearea13;
    }

    public void setZtydai1syoukaifreearea13(String pZtydai1syoukaifreearea13) {
        ztydai1syoukaifreearea13 = pZtydai1syoukaifreearea13;
    }

    private String ztydai1syoukaifreearea14;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYDAI1SYOUKAIFREEAREA14)
    public String getZtydai1syoukaifreearea14() {
        return ztydai1syoukaifreearea14;
    }

    public void setZtydai1syoukaifreearea14(String pZtydai1syoukaifreearea14) {
        ztydai1syoukaifreearea14 = pZtydai1syoukaifreearea14;
    }

    private String ztydai1syoukaifreearea15;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYDAI1SYOUKAIFREEAREA15)
    public String getZtydai1syoukaifreearea15() {
        return ztydai1syoukaifreearea15;
    }

    public void setZtydai1syoukaifreearea15(String pZtydai1syoukaifreearea15) {
        ztydai1syoukaifreearea15 = pZtydai1syoukaifreearea15;
    }

    private String ztyscdai2syoukaifreearea1;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYSCDAI2SYOUKAIFREEAREA1)
    public String getZtyscdai2syoukaifreearea1() {
        return ztyscdai2syoukaifreearea1;
    }

    public void setZtyscdai2syoukaifreearea1(String pZtyscdai2syoukaifreearea1) {
        ztyscdai2syoukaifreearea1 = pZtyscdai2syoukaifreearea1;
    }

    private String ztyscdai2syoukaifreearea2;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYSCDAI2SYOUKAIFREEAREA2)
    public String getZtyscdai2syoukaifreearea2() {
        return ztyscdai2syoukaifreearea2;
    }

    public void setZtyscdai2syoukaifreearea2(String pZtyscdai2syoukaifreearea2) {
        ztyscdai2syoukaifreearea2 = pZtyscdai2syoukaifreearea2;
    }

    private String ztyscdai2syoukaifreearea3;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYSCDAI2SYOUKAIFREEAREA3)
    public String getZtyscdai2syoukaifreearea3() {
        return ztyscdai2syoukaifreearea3;
    }

    public void setZtyscdai2syoukaifreearea3(String pZtyscdai2syoukaifreearea3) {
        ztyscdai2syoukaifreearea3 = pZtyscdai2syoukaifreearea3;
    }

    private String ztyscdai2syoukaifreearea4;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYSCDAI2SYOUKAIFREEAREA4)
    public String getZtyscdai2syoukaifreearea4() {
        return ztyscdai2syoukaifreearea4;
    }

    public void setZtyscdai2syoukaifreearea4(String pZtyscdai2syoukaifreearea4) {
        ztyscdai2syoukaifreearea4 = pZtyscdai2syoukaifreearea4;
    }

    private String ztyscdai2syoukaifreearea5;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYSCDAI2SYOUKAIFREEAREA5)
    public String getZtyscdai2syoukaifreearea5() {
        return ztyscdai2syoukaifreearea5;
    }

    public void setZtyscdai2syoukaifreearea5(String pZtyscdai2syoukaifreearea5) {
        ztyscdai2syoukaifreearea5 = pZtyscdai2syoukaifreearea5;
    }

    private String ztysakuseimd;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYSAKUSEIMD)
    public String getZtysakuseimd() {
        return ztysakuseimd;
    }

    public void setZtysakuseimd(String pZtysakuseimd) {
        ztysakuseimd = pZtysakuseimd;
    }

    private String ztysclakadskokno;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYSCLAKADSKOKNO)
    public String getZtysclakadskokno() {
        return ztysclakadskokno;
    }

    public void setZtysclakadskokno(String pZtysclakadskokno) {
        ztysclakadskokno = pZtysclakadskokno;
    }

    private String ztyreigaisyorihyj;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYREIGAISYORIHYJ)
    public String getZtyreigaisyorihyj() {
        return ztyreigaisyorihyj;
    }

    public void setZtyreigaisyorihyj(String pZtyreigaisyorihyj) {
        ztyreigaisyorihyj = pZtyreigaisyorihyj;
    }

    private String ztysakuseino;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYSAKUSEINO)
    public String getZtysakuseino() {
        return ztysakuseino;
    }

    public void setZtysakuseino(String pZtysakuseino) {
        ztysakuseino = pZtysakuseino;
    }

    private String ztycode;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYCODE)
    public String getZtycode() {
        return ztycode;
    }

    public void setZtycode(String pZtycode) {
        ztycode = pZtycode;
    }

    private String ztytuutimei;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYTUUTIMEI)
    public String getZtytuutimei() {
        return ztytuutimei;
    }

    public void setZtytuutimei(String pZtytuutimei) {
        ztytuutimei = pZtytuutimei;
    }

    private String ztyfreearea11;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA11)
    public String getZtyfreearea11() {
        return ztyfreearea11;
    }

    public void setZtyfreearea11(String pZtyfreearea11) {
        ztyfreearea11 = pZtyfreearea11;
    }

    private String ztyfreearea12;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA12)
    public String getZtyfreearea12() {
        return ztyfreearea12;
    }

    public void setZtyfreearea12(String pZtyfreearea12) {
        ztyfreearea12 = pZtyfreearea12;
    }

    private String ztyfreearea13;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA13)
    public String getZtyfreearea13() {
        return ztyfreearea13;
    }

    public void setZtyfreearea13(String pZtyfreearea13) {
        ztyfreearea13 = pZtyfreearea13;
    }

    private String ztyfreearea14;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA14)
    public String getZtyfreearea14() {
        return ztyfreearea14;
    }

    public void setZtyfreearea14(String pZtyfreearea14) {
        ztyfreearea14 = pZtyfreearea14;
    }

    private String ztyfreearea15;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA15)
    public String getZtyfreearea15() {
        return ztyfreearea15;
    }

    public void setZtyfreearea15(String pZtyfreearea15) {
        ztyfreearea15 = pZtyfreearea15;
    }

    private String ztyfreearea16;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA16)
    public String getZtyfreearea16() {
        return ztyfreearea16;
    }

    public void setZtyfreearea16(String pZtyfreearea16) {
        ztyfreearea16 = pZtyfreearea16;
    }

    private String ztyfreearea17;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA17)
    public String getZtyfreearea17() {
        return ztyfreearea17;
    }

    public void setZtyfreearea17(String pZtyfreearea17) {
        ztyfreearea17 = pZtyfreearea17;
    }

    private String ztyfreearea18;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA18)
    public String getZtyfreearea18() {
        return ztyfreearea18;
    }

    public void setZtyfreearea18(String pZtyfreearea18) {
        ztyfreearea18 = pZtyfreearea18;
    }

    private String ztyfreearea19;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA19)
    public String getZtyfreearea19() {
        return ztyfreearea19;
    }

    public void setZtyfreearea19(String pZtyfreearea19) {
        ztyfreearea19 = pZtyfreearea19;
    }

    private String ztyfreearea110;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA110)
    public String getZtyfreearea110() {
        return ztyfreearea110;
    }

    public void setZtyfreearea110(String pZtyfreearea110) {
        ztyfreearea110 = pZtyfreearea110;
    }

    private String ztyfreearea111;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA111)
    public String getZtyfreearea111() {
        return ztyfreearea111;
    }

    public void setZtyfreearea111(String pZtyfreearea111) {
        ztyfreearea111 = pZtyfreearea111;
    }

    private String ztyfreearea112;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA112)
    public String getZtyfreearea112() {
        return ztyfreearea112;
    }

    public void setZtyfreearea112(String pZtyfreearea112) {
        ztyfreearea112 = pZtyfreearea112;
    }

    private String ztyfreearea113;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA113)
    public String getZtyfreearea113() {
        return ztyfreearea113;
    }

    public void setZtyfreearea113(String pZtyfreearea113) {
        ztyfreearea113 = pZtyfreearea113;
    }

    private String ztyfreearea114;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA114)
    public String getZtyfreearea114() {
        return ztyfreearea114;
    }

    public void setZtyfreearea114(String pZtyfreearea114) {
        ztyfreearea114 = pZtyfreearea114;
    }

    private String ztyfreearea115;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA115)
    public String getZtyfreearea115() {
        return ztyfreearea115;
    }

    public void setZtyfreearea115(String pZtyfreearea115) {
        ztyfreearea115 = pZtyfreearea115;
    }

    private String ztyfreearea116;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA116)
    public String getZtyfreearea116() {
        return ztyfreearea116;
    }

    public void setZtyfreearea116(String pZtyfreearea116) {
        ztyfreearea116 = pZtyfreearea116;
    }

    private String ztyfreearea117;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA117)
    public String getZtyfreearea117() {
        return ztyfreearea117;
    }

    public void setZtyfreearea117(String pZtyfreearea117) {
        ztyfreearea117 = pZtyfreearea117;
    }

    private String ztyfreearea118;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA118)
    public String getZtyfreearea118() {
        return ztyfreearea118;
    }

    public void setZtyfreearea118(String pZtyfreearea118) {
        ztyfreearea118 = pZtyfreearea118;
    }

    private String ztyfreearea119;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA119)
    public String getZtyfreearea119() {
        return ztyfreearea119;
    }

    public void setZtyfreearea119(String pZtyfreearea119) {
        ztyfreearea119 = pZtyfreearea119;
    }

    private String ztyfreearea120;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA120)
    public String getZtyfreearea120() {
        return ztyfreearea120;
    }

    public void setZtyfreearea120(String pZtyfreearea120) {
        ztyfreearea120 = pZtyfreearea120;
    }

    private String ztyfreearea121;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA121)
    public String getZtyfreearea121() {
        return ztyfreearea121;
    }

    public void setZtyfreearea121(String pZtyfreearea121) {
        ztyfreearea121 = pZtyfreearea121;
    }

    private String ztyfreearea122;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA122)
    public String getZtyfreearea122() {
        return ztyfreearea122;
    }

    public void setZtyfreearea122(String pZtyfreearea122) {
        ztyfreearea122 = pZtyfreearea122;
    }

    private String ztyfreearea123;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA123)
    public String getZtyfreearea123() {
        return ztyfreearea123;
    }

    public void setZtyfreearea123(String pZtyfreearea123) {
        ztyfreearea123 = pZtyfreearea123;
    }

    private String ztyfreearea124;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA124)
    public String getZtyfreearea124() {
        return ztyfreearea124;
    }

    public void setZtyfreearea124(String pZtyfreearea124) {
        ztyfreearea124 = pZtyfreearea124;
    }

    private String ztyfreearea125;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA125)
    public String getZtyfreearea125() {
        return ztyfreearea125;
    }

    public void setZtyfreearea125(String pZtyfreearea125) {
        ztyfreearea125 = pZtyfreearea125;
    }

    private String ztyfreearea126;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA126)
    public String getZtyfreearea126() {
        return ztyfreearea126;
    }

    public void setZtyfreearea126(String pZtyfreearea126) {
        ztyfreearea126 = pZtyfreearea126;
    }

    private String ztyfreearea127;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA127)
    public String getZtyfreearea127() {
        return ztyfreearea127;
    }

    public void setZtyfreearea127(String pZtyfreearea127) {
        ztyfreearea127 = pZtyfreearea127;
    }

    private String ztyfreearea128;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA128)
    public String getZtyfreearea128() {
        return ztyfreearea128;
    }

    public void setZtyfreearea128(String pZtyfreearea128) {
        ztyfreearea128 = pZtyfreearea128;
    }

    private String ztyfreearea21;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA21)
    public String getZtyfreearea21() {
        return ztyfreearea21;
    }

    public void setZtyfreearea21(String pZtyfreearea21) {
        ztyfreearea21 = pZtyfreearea21;
    }

    private String ztyfreearea22;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA22)
    public String getZtyfreearea22() {
        return ztyfreearea22;
    }

    public void setZtyfreearea22(String pZtyfreearea22) {
        ztyfreearea22 = pZtyfreearea22;
    }

    private String ztyfreearea23;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA23)
    public String getZtyfreearea23() {
        return ztyfreearea23;
    }

    public void setZtyfreearea23(String pZtyfreearea23) {
        ztyfreearea23 = pZtyfreearea23;
    }

    private String ztyfreearea24;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA24)
    public String getZtyfreearea24() {
        return ztyfreearea24;
    }

    public void setZtyfreearea24(String pZtyfreearea24) {
        ztyfreearea24 = pZtyfreearea24;
    }

    private String ztyfreearea25;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA25)
    public String getZtyfreearea25() {
        return ztyfreearea25;
    }

    public void setZtyfreearea25(String pZtyfreearea25) {
        ztyfreearea25 = pZtyfreearea25;
    }

    private String ztyfreearea26;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA26)
    public String getZtyfreearea26() {
        return ztyfreearea26;
    }

    public void setZtyfreearea26(String pZtyfreearea26) {
        ztyfreearea26 = pZtyfreearea26;
    }

    private String ztyfreearea27;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA27)
    public String getZtyfreearea27() {
        return ztyfreearea27;
    }

    public void setZtyfreearea27(String pZtyfreearea27) {
        ztyfreearea27 = pZtyfreearea27;
    }

    private String ztyfreearea28;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA28)
    public String getZtyfreearea28() {
        return ztyfreearea28;
    }

    public void setZtyfreearea28(String pZtyfreearea28) {
        ztyfreearea28 = pZtyfreearea28;
    }

    private String ztyfreearea29;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA29)
    public String getZtyfreearea29() {
        return ztyfreearea29;
    }

    public void setZtyfreearea29(String pZtyfreearea29) {
        ztyfreearea29 = pZtyfreearea29;
    }

    private String ztyfreearea210;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA210)
    public String getZtyfreearea210() {
        return ztyfreearea210;
    }

    public void setZtyfreearea210(String pZtyfreearea210) {
        ztyfreearea210 = pZtyfreearea210;
    }

    private String ztyfreearea211;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA211)
    public String getZtyfreearea211() {
        return ztyfreearea211;
    }

    public void setZtyfreearea211(String pZtyfreearea211) {
        ztyfreearea211 = pZtyfreearea211;
    }

    private String ztyfreearea212;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA212)
    public String getZtyfreearea212() {
        return ztyfreearea212;
    }

    public void setZtyfreearea212(String pZtyfreearea212) {
        ztyfreearea212 = pZtyfreearea212;
    }

    private String ztyfreearea213;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA213)
    public String getZtyfreearea213() {
        return ztyfreearea213;
    }

    public void setZtyfreearea213(String pZtyfreearea213) {
        ztyfreearea213 = pZtyfreearea213;
    }

    private String ztyfreearea214;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA214)
    public String getZtyfreearea214() {
        return ztyfreearea214;
    }

    public void setZtyfreearea214(String pZtyfreearea214) {
        ztyfreearea214 = pZtyfreearea214;
    }

    private String ztyfreearea215;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA215)
    public String getZtyfreearea215() {
        return ztyfreearea215;
    }

    public void setZtyfreearea215(String pZtyfreearea215) {
        ztyfreearea215 = pZtyfreearea215;
    }

    private String ztyfreearea216;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA216)
    public String getZtyfreearea216() {
        return ztyfreearea216;
    }

    public void setZtyfreearea216(String pZtyfreearea216) {
        ztyfreearea216 = pZtyfreearea216;
    }

    private String ztyfreearea217;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA217)
    public String getZtyfreearea217() {
        return ztyfreearea217;
    }

    public void setZtyfreearea217(String pZtyfreearea217) {
        ztyfreearea217 = pZtyfreearea217;
    }

    private String ztyfreearea218;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA218)
    public String getZtyfreearea218() {
        return ztyfreearea218;
    }

    public void setZtyfreearea218(String pZtyfreearea218) {
        ztyfreearea218 = pZtyfreearea218;
    }

    private String ztyfreearea219;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA219)
    public String getZtyfreearea219() {
        return ztyfreearea219;
    }

    public void setZtyfreearea219(String pZtyfreearea219) {
        ztyfreearea219 = pZtyfreearea219;
    }

    private String ztyfreearea220;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA220)
    public String getZtyfreearea220() {
        return ztyfreearea220;
    }

    public void setZtyfreearea220(String pZtyfreearea220) {
        ztyfreearea220 = pZtyfreearea220;
    }

    private String ztyfreearea221;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA221)
    public String getZtyfreearea221() {
        return ztyfreearea221;
    }

    public void setZtyfreearea221(String pZtyfreearea221) {
        ztyfreearea221 = pZtyfreearea221;
    }

    private String ztyfreearea222;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA222)
    public String getZtyfreearea222() {
        return ztyfreearea222;
    }

    public void setZtyfreearea222(String pZtyfreearea222) {
        ztyfreearea222 = pZtyfreearea222;
    }

    private String ztyfreearea223;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA223)
    public String getZtyfreearea223() {
        return ztyfreearea223;
    }

    public void setZtyfreearea223(String pZtyfreearea223) {
        ztyfreearea223 = pZtyfreearea223;
    }

    private String ztyfreearea224;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA224)
    public String getZtyfreearea224() {
        return ztyfreearea224;
    }

    public void setZtyfreearea224(String pZtyfreearea224) {
        ztyfreearea224 = pZtyfreearea224;
    }

    private String ztyfreearea225;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA225)
    public String getZtyfreearea225() {
        return ztyfreearea225;
    }

    public void setZtyfreearea225(String pZtyfreearea225) {
        ztyfreearea225 = pZtyfreearea225;
    }

    private String ztyfreearea226;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA226)
    public String getZtyfreearea226() {
        return ztyfreearea226;
    }

    public void setZtyfreearea226(String pZtyfreearea226) {
        ztyfreearea226 = pZtyfreearea226;
    }

    private String ztyfreearea227;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA227)
    public String getZtyfreearea227() {
        return ztyfreearea227;
    }

    public void setZtyfreearea227(String pZtyfreearea227) {
        ztyfreearea227 = pZtyfreearea227;
    }

    private String ztyfreearea228;

    @Column(name=GenZT_DsHanyouKokyakuTuutiTy.ZTYFREEAREA228)
    public String getZtyfreearea228() {
        return ztyfreearea228;
    }

    public void setZtyfreearea228(String pZtyfreearea228) {
        ztyfreearea228 = pZtyfreearea228;
    }
}