package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_IsaToukeiDataTy;
import yuyu.def.db.id.PKZT_IsaToukeiDataTy;
import yuyu.def.db.meta.GenQZT_IsaToukeiDataTy;
import yuyu.def.db.meta.QZT_IsaToukeiDataTy;

/**
 * 医査統計データテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_IsaToukeiDataTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_IsaToukeiDataTy}</td><td colspan="3">医査統計データテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtymosno ztymosno}</td><td>（中継用）申込番号</td><td align="center">{@link PKZT_IsaToukeiDataTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhjykktkbn ztyhjykktkbn}</td><td>（中継用）報状告知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyuruicd ztyhknsyuruicd}</td><td>（中継用）保険種類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkhuhukbn ztyhrkhuhukbn}</td><td>（中継用）払込方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymossyoumetukbn ztymossyoumetukbn}</td><td>（中継用）申込消滅区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymusymd ztymusymd}</td><td>（中継用）申込年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymosym ztymosym}</td><td>（中継用）申込月度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyym ztybsyym}</td><td>（中継用）募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatukaisosikicd ztyaatukaisosikicd}</td><td>（中継用）Ａ扱者組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatukaikojincd ztyaatukaikojincd}</td><td>（中継用）Ａ扱者個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnen3 ztyhhknnen3}</td><td>（中継用）被保険者年令（３文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyktuuka ztykyktuuka}</td><td>（中継用）契約通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysibous7 ztysibous7}</td><td>（中継用）死亡Ｓ（７桁）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtydakuhikettisyacd ztydakuhikettisyacd}</td><td>（中継用）諾否決定者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydkhktiymd ztydkhktiymd}</td><td>（中継用）諾否決定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhikettikekkacd ztydakuhikettikekkacd}</td><td>（中継用）諾否決定結果コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhiketteiriyuucdx1 ztydakuhiketteiriyuucdx1}</td><td>（中継用）諾否決定理由コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhiketteiriyuucdx2 ztydakuhiketteiriyuucdx2}</td><td>（中継用）諾否決定理由コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhiketteiriyuucdx3 ztydakuhiketteiriyuucdx3}</td><td>（中継用）諾否決定理由コード＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhiketteiriyuucdx4 ztydakuhiketteiriyuucdx4}</td><td>（中継用）諾否決定理由コード＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukykktkekkacd ztysyukykktkekkacd}</td><td>（中継用）主契約決定結果コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysntyo3 ztysntyo3}</td><td>（中継用）身長（３文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytijyuu3 ztytijyuu3}</td><td>（中継用）体重（３文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybmi ztybmi}</td><td>（中継用）ＢＭＩ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysinsahouhou ztysinsahouhou}</td><td>（中継用）診査方法</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoubyoucd1 ztysyoubyoucd1}</td><td>（中継用）傷病コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikanensuux1 ztykeikanensuux1}</td><td>（中継用）経過年数＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoubyoucd2 ztysyoubyoucd2}</td><td>（中継用）傷病コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikanensuux2 ztykeikanensuux2}</td><td>（中継用）経過年数＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokaiktisinsahouhou ztysyokaiktisinsahouhou}</td><td>（中継用）初回決定時診査方法</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokaiktidkhktikekkacd ztysyokaiktidkhktikekkacd}</td><td>（中継用）初回決定時諾否決定結果コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokaiktsyukykktkekkacd ztysyokaiktsyukykktkekkacd}</td><td>（中継用）初回決定主契約決定結果コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhanbaikeirokbn ztyhanbaikeirokbn}</td><td>（中継用）販売経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjissituhosyous ztyjissituhosyous}</td><td>（中継用）実質保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyoyadairitencd ztyoyadairitencd}</td><td>（中継用）親代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynensyuukbn ztynensyuukbn}</td><td>（中継用）年収区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykgycd ztysykgycd}</td><td>（中継用）職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyksbyensitihsyutyhkumu ztysyksbyensitihsyutyhkumu}</td><td>（中継用）初期死亡時円換算最低保証特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyudkaigomehrtkhkumu ztyjyudkaigomehrtkhkumu}</td><td>（中継用）重度介護前払特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyijitoukeizennoukbn ztyijitoukeizennoukbn}</td><td>（中継用）医事統計用前納区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1hknkkn ztydai1hknkkn}</td><td>（中継用）第１保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyijitoukeitikshrtkykkbn ztyijitoukeitikshrtkykkbn}</td><td>（中継用）医事統計用定期支払特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteikisiharaikinmanen ztyteikisiharaikinmanen}</td><td>（中継用）定期支払金（万円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyobiv45 ztyyobiv45}</td><td>（中継用）予備項目Ｖ４５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_IsaToukeiDataTy
 * @see     PKZT_IsaToukeiDataTy
 * @see     QZT_IsaToukeiDataTy
 * @see     GenQZT_IsaToukeiDataTy
 */
@MappedSuperclass
@Table(name=GenZT_IsaToukeiDataTy.TABLE_NAME)
@IdClass(value=PKZT_IsaToukeiDataTy.class)
public abstract class GenZT_IsaToukeiDataTy extends AbstractExDBEntity<ZT_IsaToukeiDataTy, PKZT_IsaToukeiDataTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_IsaToukeiDataTy";
    public static final String ZTYMOSNO                 = "ztymosno";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYHJYKKTKBN             = "ztyhjykktkbn";
    public static final String ZTYHKNSYURUICD           = "ztyhknsyuruicd";
    public static final String ZTYHRKHUHUKBN            = "ztyhrkhuhukbn";
    public static final String ZTYMOSSYOUMETUKBN        = "ztymossyoumetukbn";
    public static final String ZTYMUSYMD                = "ztymusymd";
    public static final String ZTYMOSYM                 = "ztymosym";
    public static final String ZTYBSYYM                 = "ztybsyym";
    public static final String ZTYAATUKAISOSIKICD       = "ztyaatukaisosikicd";
    public static final String ZTYAATUKAIKOJINCD        = "ztyaatukaikojincd";
    public static final String ZTYHHKNNEN3              = "ztyhhknnen3";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYKYKTUUKA              = "ztykyktuuka";
    public static final String ZTYSIBOUS7               = "ztysibous7";
    public static final String ZTYDAKUHIKETTISYACD      = "ztydakuhikettisyacd";
    public static final String ZTYDKHKTIYMD             = "ztydkhktiymd";
    public static final String ZTYDAKUHIKETTIKEKKACD    = "ztydakuhikettikekkacd";
    public static final String ZTYDAKUHIKETTEIRIYUUCDX1 = "ztydakuhiketteiriyuucdx1";
    public static final String ZTYDAKUHIKETTEIRIYUUCDX2 = "ztydakuhiketteiriyuucdx2";
    public static final String ZTYDAKUHIKETTEIRIYUUCDX3 = "ztydakuhiketteiriyuucdx3";
    public static final String ZTYDAKUHIKETTEIRIYUUCDX4 = "ztydakuhiketteiriyuucdx4";
    public static final String ZTYSYUKYKKTKEKKACD       = "ztysyukykktkekkacd";
    public static final String ZTYSNTYO3                = "ztysntyo3";
    public static final String ZTYTIJYUU3               = "ztytijyuu3";
    public static final String ZTYBMI                   = "ztybmi";
    public static final String ZTYSINSAHOUHOU           = "ztysinsahouhou";
    public static final String ZTYSYOUBYOUCD1           = "ztysyoubyoucd1";
    public static final String ZTYKEIKANENSUUX1         = "ztykeikanensuux1";
    public static final String ZTYSYOUBYOUCD2           = "ztysyoubyoucd2";
    public static final String ZTYKEIKANENSUUX2         = "ztykeikanensuux2";
    public static final String ZTYSYOKAIKTISINSAHOUHOU  = "ztysyokaiktisinsahouhou";
    public static final String ZTYSYOKAIKTIDKHKTIKEKKACD = "ztysyokaiktidkhktikekkacd";
    public static final String ZTYSYOKAIKTSYUKYKKTKEKKACD = "ztysyokaiktsyukykktkekkacd";
    public static final String ZTYHANBAIKEIROKBN        = "ztyhanbaikeirokbn";
    public static final String ZTYJISSITUHOSYOUS        = "ztyjissituhosyous";
    public static final String ZTYOYADAIRITENCD         = "ztyoyadairitencd";
    public static final String ZTYNENSYUUKBN            = "ztynensyuukbn";
    public static final String ZTYSYKGYCD               = "ztysykgycd";
    public static final String ZTYSYKSBYENSITIHSYUTYHKUMU = "ztysyksbyensitihsyutyhkumu";
    public static final String ZTYJYUDKAIGOMEHRTKHKUMU  = "ztyjyudkaigomehrtkhkumu";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYIJITOUKEIZENNOUKBN    = "ztyijitoukeizennoukbn";
    public static final String ZTYDAI1HKNKKN            = "ztydai1hknkkn";
    public static final String ZTYIJITOUKEITIKSHRTKYKKBN = "ztyijitoukeitikshrtkykkbn";
    public static final String ZTYTEIKISIHARAIKINMANEN  = "ztyteikisiharaikinmanen";
    public static final String ZTYYOBIV45               = "ztyyobiv45";

    private final PKZT_IsaToukeiDataTy primaryKey;

    public GenZT_IsaToukeiDataTy() {
        primaryKey = new PKZT_IsaToukeiDataTy();
    }

    public GenZT_IsaToukeiDataTy(String pZtymosno) {
        primaryKey = new PKZT_IsaToukeiDataTy(pZtymosno);
    }

    @Transient
    @Override
    public PKZT_IsaToukeiDataTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_IsaToukeiDataTy> getMetaClass() {
        return QZT_IsaToukeiDataTy.class;
    }

    @Id
    @Column(name=GenZT_IsaToukeiDataTy.ZTYMOSNO)
    public String getZtymosno() {
        return getPrimaryKey().getZtymosno();
    }

    public void setZtymosno(String pZtymosno) {
        getPrimaryKey().setZtymosno(pZtymosno);
    }

    private String ztysyono;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYSYONO)
    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

    private String ztyhjykktkbn;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYHJYKKTKBN)
    public String getZtyhjykktkbn() {
        return ztyhjykktkbn;
    }

    public void setZtyhjykktkbn(String pZtyhjykktkbn) {
        ztyhjykktkbn = pZtyhjykktkbn;
    }

    private String ztyhknsyuruicd;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYHKNSYURUICD)
    public String getZtyhknsyuruicd() {
        return ztyhknsyuruicd;
    }

    public void setZtyhknsyuruicd(String pZtyhknsyuruicd) {
        ztyhknsyuruicd = pZtyhknsyuruicd;
    }

    private String ztyhrkhuhukbn;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYHRKHUHUKBN)
    public String getZtyhrkhuhukbn() {
        return ztyhrkhuhukbn;
    }

    public void setZtyhrkhuhukbn(String pZtyhrkhuhukbn) {
        ztyhrkhuhukbn = pZtyhrkhuhukbn;
    }

    private String ztymossyoumetukbn;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYMOSSYOUMETUKBN)
    public String getZtymossyoumetukbn() {
        return ztymossyoumetukbn;
    }

    public void setZtymossyoumetukbn(String pZtymossyoumetukbn) {
        ztymossyoumetukbn = pZtymossyoumetukbn;
    }

    private String ztymusymd;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYMUSYMD)
    public String getZtymusymd() {
        return ztymusymd;
    }

    public void setZtymusymd(String pZtymusymd) {
        ztymusymd = pZtymusymd;
    }

    private String ztymosym;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYMOSYM)
    public String getZtymosym() {
        return ztymosym;
    }

    public void setZtymosym(String pZtymosym) {
        ztymosym = pZtymosym;
    }

    private String ztybsyym;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYBSYYM)
    public String getZtybsyym() {
        return ztybsyym;
    }

    public void setZtybsyym(String pZtybsyym) {
        ztybsyym = pZtybsyym;
    }

    private String ztyaatukaisosikicd;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYAATUKAISOSIKICD)
    public String getZtyaatukaisosikicd() {
        return ztyaatukaisosikicd;
    }

    public void setZtyaatukaisosikicd(String pZtyaatukaisosikicd) {
        ztyaatukaisosikicd = pZtyaatukaisosikicd;
    }

    private String ztyaatukaikojincd;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYAATUKAIKOJINCD)
    public String getZtyaatukaikojincd() {
        return ztyaatukaikojincd;
    }

    public void setZtyaatukaikojincd(String pZtyaatukaikojincd) {
        ztyaatukaikojincd = pZtyaatukaikojincd;
    }

    private String ztyhhknnen3;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYHHKNNEN3)
    public String getZtyhhknnen3() {
        return ztyhhknnen3;
    }

    public void setZtyhhknnen3(String pZtyhhknnen3) {
        ztyhhknnen3 = pZtyhhknnen3;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztykyktuuka;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYKYKTUUKA)
    public String getZtykyktuuka() {
        return ztykyktuuka;
    }

    public void setZtykyktuuka(String pZtykyktuuka) {
        ztykyktuuka = pZtykyktuuka;
    }

    private Integer ztysibous7;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYSIBOUS7)
    public Integer getZtysibous7() {
        return ztysibous7;
    }

    public void setZtysibous7(Integer pZtysibous7) {
        ztysibous7 = pZtysibous7;
    }

    private String ztydakuhikettisyacd;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYDAKUHIKETTISYACD)
    public String getZtydakuhikettisyacd() {
        return ztydakuhikettisyacd;
    }

    public void setZtydakuhikettisyacd(String pZtydakuhikettisyacd) {
        ztydakuhikettisyacd = pZtydakuhikettisyacd;
    }

    private String ztydkhktiymd;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYDKHKTIYMD)
    public String getZtydkhktiymd() {
        return ztydkhktiymd;
    }

    public void setZtydkhktiymd(String pZtydkhktiymd) {
        ztydkhktiymd = pZtydkhktiymd;
    }

    private String ztydakuhikettikekkacd;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYDAKUHIKETTIKEKKACD)
    public String getZtydakuhikettikekkacd() {
        return ztydakuhikettikekkacd;
    }

    public void setZtydakuhikettikekkacd(String pZtydakuhikettikekkacd) {
        ztydakuhikettikekkacd = pZtydakuhikettikekkacd;
    }

    private String ztydakuhiketteiriyuucdx1;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYDAKUHIKETTEIRIYUUCDX1)
    public String getZtydakuhiketteiriyuucdx1() {
        return ztydakuhiketteiriyuucdx1;
    }

    public void setZtydakuhiketteiriyuucdx1(String pZtydakuhiketteiriyuucdx1) {
        ztydakuhiketteiriyuucdx1 = pZtydakuhiketteiriyuucdx1;
    }

    private String ztydakuhiketteiriyuucdx2;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYDAKUHIKETTEIRIYUUCDX2)
    public String getZtydakuhiketteiriyuucdx2() {
        return ztydakuhiketteiriyuucdx2;
    }

    public void setZtydakuhiketteiriyuucdx2(String pZtydakuhiketteiriyuucdx2) {
        ztydakuhiketteiriyuucdx2 = pZtydakuhiketteiriyuucdx2;
    }

    private String ztydakuhiketteiriyuucdx3;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYDAKUHIKETTEIRIYUUCDX3)
    public String getZtydakuhiketteiriyuucdx3() {
        return ztydakuhiketteiriyuucdx3;
    }

    public void setZtydakuhiketteiriyuucdx3(String pZtydakuhiketteiriyuucdx3) {
        ztydakuhiketteiriyuucdx3 = pZtydakuhiketteiriyuucdx3;
    }

    private String ztydakuhiketteiriyuucdx4;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYDAKUHIKETTEIRIYUUCDX4)
    public String getZtydakuhiketteiriyuucdx4() {
        return ztydakuhiketteiriyuucdx4;
    }

    public void setZtydakuhiketteiriyuucdx4(String pZtydakuhiketteiriyuucdx4) {
        ztydakuhiketteiriyuucdx4 = pZtydakuhiketteiriyuucdx4;
    }

    private String ztysyukykktkekkacd;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYSYUKYKKTKEKKACD)
    public String getZtysyukykktkekkacd() {
        return ztysyukykktkekkacd;
    }

    public void setZtysyukykktkekkacd(String pZtysyukykktkekkacd) {
        ztysyukykktkekkacd = pZtysyukykktkekkacd;
    }

    private String ztysntyo3;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYSNTYO3)
    public String getZtysntyo3() {
        return ztysntyo3;
    }

    public void setZtysntyo3(String pZtysntyo3) {
        ztysntyo3 = pZtysntyo3;
    }

    private String ztytijyuu3;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYTIJYUU3)
    public String getZtytijyuu3() {
        return ztytijyuu3;
    }

    public void setZtytijyuu3(String pZtytijyuu3) {
        ztytijyuu3 = pZtytijyuu3;
    }

    private Integer ztybmi;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYBMI)
    public Integer getZtybmi() {
        return ztybmi;
    }

    public void setZtybmi(Integer pZtybmi) {
        ztybmi = pZtybmi;
    }

    private String ztysinsahouhou;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYSINSAHOUHOU)
    public String getZtysinsahouhou() {
        return ztysinsahouhou;
    }

    public void setZtysinsahouhou(String pZtysinsahouhou) {
        ztysinsahouhou = pZtysinsahouhou;
    }

    private String ztysyoubyoucd1;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYSYOUBYOUCD1)
    public String getZtysyoubyoucd1() {
        return ztysyoubyoucd1;
    }

    public void setZtysyoubyoucd1(String pZtysyoubyoucd1) {
        ztysyoubyoucd1 = pZtysyoubyoucd1;
    }

    private String ztykeikanensuux1;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYKEIKANENSUUX1)
    public String getZtykeikanensuux1() {
        return ztykeikanensuux1;
    }

    public void setZtykeikanensuux1(String pZtykeikanensuux1) {
        ztykeikanensuux1 = pZtykeikanensuux1;
    }

    private String ztysyoubyoucd2;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYSYOUBYOUCD2)
    public String getZtysyoubyoucd2() {
        return ztysyoubyoucd2;
    }

    public void setZtysyoubyoucd2(String pZtysyoubyoucd2) {
        ztysyoubyoucd2 = pZtysyoubyoucd2;
    }

    private String ztykeikanensuux2;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYKEIKANENSUUX2)
    public String getZtykeikanensuux2() {
        return ztykeikanensuux2;
    }

    public void setZtykeikanensuux2(String pZtykeikanensuux2) {
        ztykeikanensuux2 = pZtykeikanensuux2;
    }

    private String ztysyokaiktisinsahouhou;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYSYOKAIKTISINSAHOUHOU)
    public String getZtysyokaiktisinsahouhou() {
        return ztysyokaiktisinsahouhou;
    }

    public void setZtysyokaiktisinsahouhou(String pZtysyokaiktisinsahouhou) {
        ztysyokaiktisinsahouhou = pZtysyokaiktisinsahouhou;
    }

    private String ztysyokaiktidkhktikekkacd;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYSYOKAIKTIDKHKTIKEKKACD)
    public String getZtysyokaiktidkhktikekkacd() {
        return ztysyokaiktidkhktikekkacd;
    }

    public void setZtysyokaiktidkhktikekkacd(String pZtysyokaiktidkhktikekkacd) {
        ztysyokaiktidkhktikekkacd = pZtysyokaiktidkhktikekkacd;
    }

    private String ztysyokaiktsyukykktkekkacd;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYSYOKAIKTSYUKYKKTKEKKACD)
    public String getZtysyokaiktsyukykktkekkacd() {
        return ztysyokaiktsyukykktkekkacd;
    }

    public void setZtysyokaiktsyukykktkekkacd(String pZtysyokaiktsyukykktkekkacd) {
        ztysyokaiktsyukykktkekkacd = pZtysyokaiktsyukykktkekkacd;
    }

    private String ztyhanbaikeirokbn;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYHANBAIKEIROKBN)
    public String getZtyhanbaikeirokbn() {
        return ztyhanbaikeirokbn;
    }

    public void setZtyhanbaikeirokbn(String pZtyhanbaikeirokbn) {
        ztyhanbaikeirokbn = pZtyhanbaikeirokbn;
    }

    private Integer ztyjissituhosyous;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYJISSITUHOSYOUS)
    public Integer getZtyjissituhosyous() {
        return ztyjissituhosyous;
    }

    public void setZtyjissituhosyous(Integer pZtyjissituhosyous) {
        ztyjissituhosyous = pZtyjissituhosyous;
    }

    private String ztyoyadairitencd;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYOYADAIRITENCD)
    public String getZtyoyadairitencd() {
        return ztyoyadairitencd;
    }

    public void setZtyoyadairitencd(String pZtyoyadairitencd) {
        ztyoyadairitencd = pZtyoyadairitencd;
    }

    private String ztynensyuukbn;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYNENSYUUKBN)
    public String getZtynensyuukbn() {
        return ztynensyuukbn;
    }

    public void setZtynensyuukbn(String pZtynensyuukbn) {
        ztynensyuukbn = pZtynensyuukbn;
    }

    private String ztysykgycd;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYSYKGYCD)
    public String getZtysykgycd() {
        return ztysykgycd;
    }

    public void setZtysykgycd(String pZtysykgycd) {
        ztysykgycd = pZtysykgycd;
    }

    private String ztysyksbyensitihsyutyhkumu;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYSYKSBYENSITIHSYUTYHKUMU)
    public String getZtysyksbyensitihsyutyhkumu() {
        return ztysyksbyensitihsyutyhkumu;
    }

    public void setZtysyksbyensitihsyutyhkumu(String pZtysyksbyensitihsyutyhkumu) {
        ztysyksbyensitihsyutyhkumu = pZtysyksbyensitihsyutyhkumu;
    }

    private String ztyjyudkaigomehrtkhkumu;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYJYUDKAIGOMEHRTKHKUMU)
    public String getZtyjyudkaigomehrtkhkumu() {
        return ztyjyudkaigomehrtkhkumu;
    }

    public void setZtyjyudkaigomehrtkhkumu(String pZtyjyudkaigomehrtkhkumu) {
        ztyjyudkaigomehrtkhkumu = pZtyjyudkaigomehrtkhkumu;
    }

    private String ztykykymd;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztyijitoukeizennoukbn;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYIJITOUKEIZENNOUKBN)
    public String getZtyijitoukeizennoukbn() {
        return ztyijitoukeizennoukbn;
    }

    public void setZtyijitoukeizennoukbn(String pZtyijitoukeizennoukbn) {
        ztyijitoukeizennoukbn = pZtyijitoukeizennoukbn;
    }

    private String ztydai1hknkkn;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYDAI1HKNKKN)
    public String getZtydai1hknkkn() {
        return ztydai1hknkkn;
    }

    public void setZtydai1hknkkn(String pZtydai1hknkkn) {
        ztydai1hknkkn = pZtydai1hknkkn;
    }

    private String ztyijitoukeitikshrtkykkbn;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYIJITOUKEITIKSHRTKYKKBN)
    public String getZtyijitoukeitikshrtkykkbn() {
        return ztyijitoukeitikshrtkykkbn;
    }

    public void setZtyijitoukeitikshrtkykkbn(String pZtyijitoukeitikshrtkykkbn) {
        ztyijitoukeitikshrtkykkbn = pZtyijitoukeitikshrtkykkbn;
    }

    private Integer ztyteikisiharaikinmanen;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYTEIKISIHARAIKINMANEN)
    public Integer getZtyteikisiharaikinmanen() {
        return ztyteikisiharaikinmanen;
    }

    public void setZtyteikisiharaikinmanen(Integer pZtyteikisiharaikinmanen) {
        ztyteikisiharaikinmanen = pZtyteikisiharaikinmanen;
    }

    private String ztyyobiv45;

    @Column(name=GenZT_IsaToukeiDataTy.ZTYYOBIV45)
    public String getZtyyobiv45() {
        return ztyyobiv45;
    }

    public void setZtyyobiv45(String pZtyyobiv45) {
        ztyyobiv45 = pZtyyobiv45;
    }
}