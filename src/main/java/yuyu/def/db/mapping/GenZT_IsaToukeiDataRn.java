package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_IsaToukeiDataRn;
import yuyu.def.db.id.PKZT_IsaToukeiDataRn;
import yuyu.def.db.meta.GenQZT_IsaToukeiDataRn;
import yuyu.def.db.meta.QZT_IsaToukeiDataRn;

/**
 * 医査統計データテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_IsaToukeiDataRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_IsaToukeiDataRn}</td><td colspan="3">医査統計データテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnmosno zrnmosno}</td><td>（連携用）申込番号</td><td align="center">{@link PKZT_IsaToukeiDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhjykktkbn zrnhjykktkbn}</td><td>（連携用）報状告知区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruicd zrnhknsyuruicd}</td><td>（連携用）保険種類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkhuhukbn zrnhrkhuhukbn}</td><td>（連携用）払込方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmossyoumetukbn zrnmossyoumetukbn}</td><td>（連携用）申込消滅区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmusymd zrnmusymd}</td><td>（連携用）申込年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmosym zrnmosym}</td><td>（連携用）申込月度</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyym zrnbsyym}</td><td>（連携用）募集年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatukaisosikicd zrnaatukaisosikicd}</td><td>（連携用）Ａ扱者組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatukaikojincd zrnaatukaikojincd}</td><td>（連携用）Ａ扱者個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnen3 zrnhhknnen3}</td><td>（連携用）被保険者年令（３文字）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyktuuka zrnkyktuuka}</td><td>（連携用）契約通貨</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsibous7 zrnsibous7}</td><td>（連携用）死亡Ｓ（７桁）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrndakuhikettisyacd zrndakuhikettisyacd}</td><td>（連携用）諾否決定者コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndkhktiymd zrndkhktiymd}</td><td>（連携用）諾否決定年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhikettikekkacd zrndakuhikettikekkacd}</td><td>（連携用）諾否決定結果コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhiketteiriyuucdx1 zrndakuhiketteiriyuucdx1}</td><td>（連携用）諾否決定理由コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhiketteiriyuucdx2 zrndakuhiketteiriyuucdx2}</td><td>（連携用）諾否決定理由コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhiketteiriyuucdx3 zrndakuhiketteiriyuucdx3}</td><td>（連携用）諾否決定理由コード＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhiketteiriyuucdx4 zrndakuhiketteiriyuucdx4}</td><td>（連携用）諾否決定理由コード＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukykktkekkacd zrnsyukykktkekkacd}</td><td>（連携用）主契約決定結果コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsntyo3 zrnsntyo3}</td><td>（連携用）身長（３文字）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntijyuu3 zrntijyuu3}</td><td>（連携用）体重（３文字）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbmi zrnbmi}</td><td>（連携用）ＢＭＩ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsinsahouhou zrnsinsahouhou}</td><td>（連携用）診査方法</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoubyoucd1 zrnsyoubyoucd1}</td><td>（連携用）傷病コード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikanensuux1 zrnkeikanensuux1}</td><td>（連携用）経過年数＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoubyoucd2 zrnsyoubyoucd2}</td><td>（連携用）傷病コード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikanensuux2 zrnkeikanensuux2}</td><td>（連携用）経過年数＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokaiktisinsahouhou zrnsyokaiktisinsahouhou}</td><td>（連携用）初回決定時診査方法</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokaiktidkhktikekkacd zrnsyokaiktidkhktikekkacd}</td><td>（連携用）初回決定時諾否決定結果コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokaiktsyukykktkekkacd zrnsyokaiktsyukykktkekkacd}</td><td>（連携用）初回決定主契約決定結果コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhanbaikeirokbn zrnhanbaikeirokbn}</td><td>（連携用）販売経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjissituhosyous zrnjissituhosyous}</td><td>（連携用）実質保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnoyadairitencd zrnoyadairitencd}</td><td>（連携用）親代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnensyuukbn zrnnensyuukbn}</td><td>（連携用）年収区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykgycd zrnsykgycd}</td><td>（連携用）職業コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyksbyensitihsyutyhkumu zrnsyksbyensitihsyutyhkumu}</td><td>（連携用）初期死亡時円換算最低保証特約付加有無</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyudkaigomehrtkhkumu zrnjyudkaigomehrtkhkumu}</td><td>（連携用）重度介護前払特約付加有無</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnijitoukeizennoukbn zrnijitoukeizennoukbn}</td><td>（連携用）医事統計用前納区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1hknkkn zrndai1hknkkn}</td><td>（連携用）第１保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnijitoukeitikshrtkykkbn zrnijitoukeitikshrtkykkbn}</td><td>（連携用）医事統計用定期支払特約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteikisiharaikinmanen zrnteikisiharaikinmanen}</td><td>（連携用）定期支払金（万円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyobiv45 zrnyobiv45}</td><td>（連携用）予備項目Ｖ４５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_IsaToukeiDataRn
 * @see     PKZT_IsaToukeiDataRn
 * @see     QZT_IsaToukeiDataRn
 * @see     GenQZT_IsaToukeiDataRn
 */
@MappedSuperclass
@Table(name=GenZT_IsaToukeiDataRn.TABLE_NAME)
@IdClass(value=PKZT_IsaToukeiDataRn.class)
public abstract class GenZT_IsaToukeiDataRn extends AbstractExDBEntityForZDB<ZT_IsaToukeiDataRn, PKZT_IsaToukeiDataRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_IsaToukeiDataRn";
    public static final String ZRNMOSNO                 = "zrnmosno";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNHJYKKTKBN             = "zrnhjykktkbn";
    public static final String ZRNHKNSYURUICD           = "zrnhknsyuruicd";
    public static final String ZRNHRKHUHUKBN            = "zrnhrkhuhukbn";
    public static final String ZRNMOSSYOUMETUKBN        = "zrnmossyoumetukbn";
    public static final String ZRNMUSYMD                = "zrnmusymd";
    public static final String ZRNMOSYM                 = "zrnmosym";
    public static final String ZRNBSYYM                 = "zrnbsyym";
    public static final String ZRNAATUKAISOSIKICD       = "zrnaatukaisosikicd";
    public static final String ZRNAATUKAIKOJINCD        = "zrnaatukaikojincd";
    public static final String ZRNHHKNNEN3              = "zrnhhknnen3";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNKYKTUUKA              = "zrnkyktuuka";
    public static final String ZRNSIBOUS7               = "zrnsibous7";
    public static final String ZRNDAKUHIKETTISYACD      = "zrndakuhikettisyacd";
    public static final String ZRNDKHKTIYMD             = "zrndkhktiymd";
    public static final String ZRNDAKUHIKETTIKEKKACD    = "zrndakuhikettikekkacd";
    public static final String ZRNDAKUHIKETTEIRIYUUCDX1 = "zrndakuhiketteiriyuucdx1";
    public static final String ZRNDAKUHIKETTEIRIYUUCDX2 = "zrndakuhiketteiriyuucdx2";
    public static final String ZRNDAKUHIKETTEIRIYUUCDX3 = "zrndakuhiketteiriyuucdx3";
    public static final String ZRNDAKUHIKETTEIRIYUUCDX4 = "zrndakuhiketteiriyuucdx4";
    public static final String ZRNSYUKYKKTKEKKACD       = "zrnsyukykktkekkacd";
    public static final String ZRNSNTYO3                = "zrnsntyo3";
    public static final String ZRNTIJYUU3               = "zrntijyuu3";
    public static final String ZRNBMI                   = "zrnbmi";
    public static final String ZRNSINSAHOUHOU           = "zrnsinsahouhou";
    public static final String ZRNSYOUBYOUCD1           = "zrnsyoubyoucd1";
    public static final String ZRNKEIKANENSUUX1         = "zrnkeikanensuux1";
    public static final String ZRNSYOUBYOUCD2           = "zrnsyoubyoucd2";
    public static final String ZRNKEIKANENSUUX2         = "zrnkeikanensuux2";
    public static final String ZRNSYOKAIKTISINSAHOUHOU  = "zrnsyokaiktisinsahouhou";
    public static final String ZRNSYOKAIKTIDKHKTIKEKKACD = "zrnsyokaiktidkhktikekkacd";
    public static final String ZRNSYOKAIKTSYUKYKKTKEKKACD = "zrnsyokaiktsyukykktkekkacd";
    public static final String ZRNHANBAIKEIROKBN        = "zrnhanbaikeirokbn";
    public static final String ZRNJISSITUHOSYOUS        = "zrnjissituhosyous";
    public static final String ZRNOYADAIRITENCD         = "zrnoyadairitencd";
    public static final String ZRNNENSYUUKBN            = "zrnnensyuukbn";
    public static final String ZRNSYKGYCD               = "zrnsykgycd";
    public static final String ZRNSYKSBYENSITIHSYUTYHKUMU = "zrnsyksbyensitihsyutyhkumu";
    public static final String ZRNJYUDKAIGOMEHRTKHKUMU  = "zrnjyudkaigomehrtkhkumu";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNIJITOUKEIZENNOUKBN    = "zrnijitoukeizennoukbn";
    public static final String ZRNDAI1HKNKKN            = "zrndai1hknkkn";
    public static final String ZRNIJITOUKEITIKSHRTKYKKBN = "zrnijitoukeitikshrtkykkbn";
    public static final String ZRNTEIKISIHARAIKINMANEN  = "zrnteikisiharaikinmanen";
    public static final String ZRNYOBIV45               = "zrnyobiv45";

    private final PKZT_IsaToukeiDataRn primaryKey;

    public GenZT_IsaToukeiDataRn() {
        primaryKey = new PKZT_IsaToukeiDataRn();
    }

    public GenZT_IsaToukeiDataRn(String pZrnmosno) {
        primaryKey = new PKZT_IsaToukeiDataRn(pZrnmosno);
    }

    @Transient
    @Override
    public PKZT_IsaToukeiDataRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_IsaToukeiDataRn> getMetaClass() {
        return QZT_IsaToukeiDataRn.class;
    }

    @Id
    @Column(name=GenZT_IsaToukeiDataRn.ZRNMOSNO)
    public String getZrnmosno() {
        return getPrimaryKey().getZrnmosno();
    }

    public void setZrnmosno(String pZrnmosno) {
        getPrimaryKey().setZrnmosno(pZrnmosno);
    }

    private String zrnsyono;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNSYONO)
    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

    private String zrnhjykktkbn;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNHJYKKTKBN)
    public String getZrnhjykktkbn() {
        return zrnhjykktkbn;
    }

    public void setZrnhjykktkbn(String pZrnhjykktkbn) {
        zrnhjykktkbn = pZrnhjykktkbn;
    }

    private String zrnhknsyuruicd;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNHKNSYURUICD)
    public String getZrnhknsyuruicd() {
        return zrnhknsyuruicd;
    }

    public void setZrnhknsyuruicd(String pZrnhknsyuruicd) {
        zrnhknsyuruicd = pZrnhknsyuruicd;
    }

    private String zrnhrkhuhukbn;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNHRKHUHUKBN)
    public String getZrnhrkhuhukbn() {
        return zrnhrkhuhukbn;
    }

    public void setZrnhrkhuhukbn(String pZrnhrkhuhukbn) {
        zrnhrkhuhukbn = pZrnhrkhuhukbn;
    }

    private String zrnmossyoumetukbn;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNMOSSYOUMETUKBN)
    public String getZrnmossyoumetukbn() {
        return zrnmossyoumetukbn;
    }

    public void setZrnmossyoumetukbn(String pZrnmossyoumetukbn) {
        zrnmossyoumetukbn = pZrnmossyoumetukbn;
    }

    private String zrnmusymd;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNMUSYMD)
    public String getZrnmusymd() {
        return zrnmusymd;
    }

    public void setZrnmusymd(String pZrnmusymd) {
        zrnmusymd = pZrnmusymd;
    }

    private String zrnmosym;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNMOSYM)
    public String getZrnmosym() {
        return zrnmosym;
    }

    public void setZrnmosym(String pZrnmosym) {
        zrnmosym = pZrnmosym;
    }

    private String zrnbsyym;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNBSYYM)
    public String getZrnbsyym() {
        return zrnbsyym;
    }

    public void setZrnbsyym(String pZrnbsyym) {
        zrnbsyym = pZrnbsyym;
    }

    private String zrnaatukaisosikicd;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNAATUKAISOSIKICD)
    public String getZrnaatukaisosikicd() {
        return zrnaatukaisosikicd;
    }

    public void setZrnaatukaisosikicd(String pZrnaatukaisosikicd) {
        zrnaatukaisosikicd = pZrnaatukaisosikicd;
    }

    private String zrnaatukaikojincd;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNAATUKAIKOJINCD)
    public String getZrnaatukaikojincd() {
        return zrnaatukaikojincd;
    }

    public void setZrnaatukaikojincd(String pZrnaatukaikojincd) {
        zrnaatukaikojincd = pZrnaatukaikojincd;
    }

    private String zrnhhknnen3;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNHHKNNEN3)
    public String getZrnhhknnen3() {
        return zrnhhknnen3;
    }

    public void setZrnhhknnen3(String pZrnhhknnen3) {
        zrnhhknnen3 = pZrnhhknnen3;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnkyktuuka;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNKYKTUUKA)
    public String getZrnkyktuuka() {
        return zrnkyktuuka;
    }

    public void setZrnkyktuuka(String pZrnkyktuuka) {
        zrnkyktuuka = pZrnkyktuuka;
    }

    private Integer zrnsibous7;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNSIBOUS7)
    public Integer getZrnsibous7() {
        return zrnsibous7;
    }

    public void setZrnsibous7(Integer pZrnsibous7) {
        zrnsibous7 = pZrnsibous7;
    }

    private String zrndakuhikettisyacd;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNDAKUHIKETTISYACD)
    public String getZrndakuhikettisyacd() {
        return zrndakuhikettisyacd;
    }

    public void setZrndakuhikettisyacd(String pZrndakuhikettisyacd) {
        zrndakuhikettisyacd = pZrndakuhikettisyacd;
    }

    private String zrndkhktiymd;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNDKHKTIYMD)
    public String getZrndkhktiymd() {
        return zrndkhktiymd;
    }

    public void setZrndkhktiymd(String pZrndkhktiymd) {
        zrndkhktiymd = pZrndkhktiymd;
    }

    private String zrndakuhikettikekkacd;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNDAKUHIKETTIKEKKACD)
    public String getZrndakuhikettikekkacd() {
        return zrndakuhikettikekkacd;
    }

    public void setZrndakuhikettikekkacd(String pZrndakuhikettikekkacd) {
        zrndakuhikettikekkacd = pZrndakuhikettikekkacd;
    }

    private String zrndakuhiketteiriyuucdx1;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNDAKUHIKETTEIRIYUUCDX1)
    public String getZrndakuhiketteiriyuucdx1() {
        return zrndakuhiketteiriyuucdx1;
    }

    public void setZrndakuhiketteiriyuucdx1(String pZrndakuhiketteiriyuucdx1) {
        zrndakuhiketteiriyuucdx1 = pZrndakuhiketteiriyuucdx1;
    }

    private String zrndakuhiketteiriyuucdx2;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNDAKUHIKETTEIRIYUUCDX2)
    public String getZrndakuhiketteiriyuucdx2() {
        return zrndakuhiketteiriyuucdx2;
    }

    public void setZrndakuhiketteiriyuucdx2(String pZrndakuhiketteiriyuucdx2) {
        zrndakuhiketteiriyuucdx2 = pZrndakuhiketteiriyuucdx2;
    }

    private String zrndakuhiketteiriyuucdx3;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNDAKUHIKETTEIRIYUUCDX3)
    public String getZrndakuhiketteiriyuucdx3() {
        return zrndakuhiketteiriyuucdx3;
    }

    public void setZrndakuhiketteiriyuucdx3(String pZrndakuhiketteiriyuucdx3) {
        zrndakuhiketteiriyuucdx3 = pZrndakuhiketteiriyuucdx3;
    }

    private String zrndakuhiketteiriyuucdx4;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNDAKUHIKETTEIRIYUUCDX4)
    public String getZrndakuhiketteiriyuucdx4() {
        return zrndakuhiketteiriyuucdx4;
    }

    public void setZrndakuhiketteiriyuucdx4(String pZrndakuhiketteiriyuucdx4) {
        zrndakuhiketteiriyuucdx4 = pZrndakuhiketteiriyuucdx4;
    }

    private String zrnsyukykktkekkacd;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNSYUKYKKTKEKKACD)
    public String getZrnsyukykktkekkacd() {
        return zrnsyukykktkekkacd;
    }

    public void setZrnsyukykktkekkacd(String pZrnsyukykktkekkacd) {
        zrnsyukykktkekkacd = pZrnsyukykktkekkacd;
    }

    private String zrnsntyo3;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNSNTYO3)
    public String getZrnsntyo3() {
        return zrnsntyo3;
    }

    public void setZrnsntyo3(String pZrnsntyo3) {
        zrnsntyo3 = pZrnsntyo3;
    }

    private String zrntijyuu3;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNTIJYUU3)
    public String getZrntijyuu3() {
        return zrntijyuu3;
    }

    public void setZrntijyuu3(String pZrntijyuu3) {
        zrntijyuu3 = pZrntijyuu3;
    }

    private Integer zrnbmi;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNBMI)
    public Integer getZrnbmi() {
        return zrnbmi;
    }

    public void setZrnbmi(Integer pZrnbmi) {
        zrnbmi = pZrnbmi;
    }

    private String zrnsinsahouhou;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNSINSAHOUHOU)
    public String getZrnsinsahouhou() {
        return zrnsinsahouhou;
    }

    public void setZrnsinsahouhou(String pZrnsinsahouhou) {
        zrnsinsahouhou = pZrnsinsahouhou;
    }

    private String zrnsyoubyoucd1;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNSYOUBYOUCD1)
    public String getZrnsyoubyoucd1() {
        return zrnsyoubyoucd1;
    }

    public void setZrnsyoubyoucd1(String pZrnsyoubyoucd1) {
        zrnsyoubyoucd1 = pZrnsyoubyoucd1;
    }

    private String zrnkeikanensuux1;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNKEIKANENSUUX1)
    public String getZrnkeikanensuux1() {
        return zrnkeikanensuux1;
    }

    public void setZrnkeikanensuux1(String pZrnkeikanensuux1) {
        zrnkeikanensuux1 = pZrnkeikanensuux1;
    }

    private String zrnsyoubyoucd2;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNSYOUBYOUCD2)
    public String getZrnsyoubyoucd2() {
        return zrnsyoubyoucd2;
    }

    public void setZrnsyoubyoucd2(String pZrnsyoubyoucd2) {
        zrnsyoubyoucd2 = pZrnsyoubyoucd2;
    }

    private String zrnkeikanensuux2;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNKEIKANENSUUX2)
    public String getZrnkeikanensuux2() {
        return zrnkeikanensuux2;
    }

    public void setZrnkeikanensuux2(String pZrnkeikanensuux2) {
        zrnkeikanensuux2 = pZrnkeikanensuux2;
    }

    private String zrnsyokaiktisinsahouhou;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNSYOKAIKTISINSAHOUHOU)
    public String getZrnsyokaiktisinsahouhou() {
        return zrnsyokaiktisinsahouhou;
    }

    public void setZrnsyokaiktisinsahouhou(String pZrnsyokaiktisinsahouhou) {
        zrnsyokaiktisinsahouhou = pZrnsyokaiktisinsahouhou;
    }

    private String zrnsyokaiktidkhktikekkacd;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNSYOKAIKTIDKHKTIKEKKACD)
    public String getZrnsyokaiktidkhktikekkacd() {
        return zrnsyokaiktidkhktikekkacd;
    }

    public void setZrnsyokaiktidkhktikekkacd(String pZrnsyokaiktidkhktikekkacd) {
        zrnsyokaiktidkhktikekkacd = pZrnsyokaiktidkhktikekkacd;
    }

    private String zrnsyokaiktsyukykktkekkacd;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNSYOKAIKTSYUKYKKTKEKKACD)
    public String getZrnsyokaiktsyukykktkekkacd() {
        return zrnsyokaiktsyukykktkekkacd;
    }

    public void setZrnsyokaiktsyukykktkekkacd(String pZrnsyokaiktsyukykktkekkacd) {
        zrnsyokaiktsyukykktkekkacd = pZrnsyokaiktsyukykktkekkacd;
    }

    private String zrnhanbaikeirokbn;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNHANBAIKEIROKBN)
    public String getZrnhanbaikeirokbn() {
        return zrnhanbaikeirokbn;
    }

    public void setZrnhanbaikeirokbn(String pZrnhanbaikeirokbn) {
        zrnhanbaikeirokbn = pZrnhanbaikeirokbn;
    }

    private Integer zrnjissituhosyous;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNJISSITUHOSYOUS)
    public Integer getZrnjissituhosyous() {
        return zrnjissituhosyous;
    }

    public void setZrnjissituhosyous(Integer pZrnjissituhosyous) {
        zrnjissituhosyous = pZrnjissituhosyous;
    }

    private String zrnoyadairitencd;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNOYADAIRITENCD)
    public String getZrnoyadairitencd() {
        return zrnoyadairitencd;
    }

    public void setZrnoyadairitencd(String pZrnoyadairitencd) {
        zrnoyadairitencd = pZrnoyadairitencd;
    }

    private String zrnnensyuukbn;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNNENSYUUKBN)
    public String getZrnnensyuukbn() {
        return zrnnensyuukbn;
    }

    public void setZrnnensyuukbn(String pZrnnensyuukbn) {
        zrnnensyuukbn = pZrnnensyuukbn;
    }

    private String zrnsykgycd;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNSYKGYCD)
    public String getZrnsykgycd() {
        return zrnsykgycd;
    }

    public void setZrnsykgycd(String pZrnsykgycd) {
        zrnsykgycd = pZrnsykgycd;
    }

    private String zrnsyksbyensitihsyutyhkumu;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNSYKSBYENSITIHSYUTYHKUMU)
    public String getZrnsyksbyensitihsyutyhkumu() {
        return zrnsyksbyensitihsyutyhkumu;
    }

    public void setZrnsyksbyensitihsyutyhkumu(String pZrnsyksbyensitihsyutyhkumu) {
        zrnsyksbyensitihsyutyhkumu = pZrnsyksbyensitihsyutyhkumu;
    }

    private String zrnjyudkaigomehrtkhkumu;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNJYUDKAIGOMEHRTKHKUMU)
    public String getZrnjyudkaigomehrtkhkumu() {
        return zrnjyudkaigomehrtkhkumu;
    }

    public void setZrnjyudkaigomehrtkhkumu(String pZrnjyudkaigomehrtkhkumu) {
        zrnjyudkaigomehrtkhkumu = pZrnjyudkaigomehrtkhkumu;
    }

    private String zrnkykymd;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnijitoukeizennoukbn;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNIJITOUKEIZENNOUKBN)
    public String getZrnijitoukeizennoukbn() {
        return zrnijitoukeizennoukbn;
    }

    public void setZrnijitoukeizennoukbn(String pZrnijitoukeizennoukbn) {
        zrnijitoukeizennoukbn = pZrnijitoukeizennoukbn;
    }

    private String zrndai1hknkkn;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNDAI1HKNKKN)
    public String getZrndai1hknkkn() {
        return zrndai1hknkkn;
    }

    public void setZrndai1hknkkn(String pZrndai1hknkkn) {
        zrndai1hknkkn = pZrndai1hknkkn;
    }

    private String zrnijitoukeitikshrtkykkbn;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNIJITOUKEITIKSHRTKYKKBN)
    public String getZrnijitoukeitikshrtkykkbn() {
        return zrnijitoukeitikshrtkykkbn;
    }

    public void setZrnijitoukeitikshrtkykkbn(String pZrnijitoukeitikshrtkykkbn) {
        zrnijitoukeitikshrtkykkbn = pZrnijitoukeitikshrtkykkbn;
    }

    private Integer zrnteikisiharaikinmanen;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNTEIKISIHARAIKINMANEN)
    public Integer getZrnteikisiharaikinmanen() {
        return zrnteikisiharaikinmanen;
    }

    public void setZrnteikisiharaikinmanen(Integer pZrnteikisiharaikinmanen) {
        zrnteikisiharaikinmanen = pZrnteikisiharaikinmanen;
    }

    private String zrnyobiv45;

    @Column(name=GenZT_IsaToukeiDataRn.ZRNYOBIV45)
    public String getZrnyobiv45() {
        return zrnyobiv45;
    }

    public void setZrnyobiv45(String pZrnyobiv45) {
        zrnyobiv45 = pZrnyobiv45;
    }
}