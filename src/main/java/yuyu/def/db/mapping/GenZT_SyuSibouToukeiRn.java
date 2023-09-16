package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_SyuSibouToukeiRn;
import yuyu.def.db.id.PKZT_SyuSibouToukeiRn;
import yuyu.def.db.meta.GenQZT_SyuSibouToukeiRn;
import yuyu.def.db.meta.QZT_SyuSibouToukeiRn;

/**
 * 主契約死亡統計データテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SyuSibouToukeiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SyuSibouToukeiRn}</td><td colspan="3">主契約死亡統計データテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_SyuSibouToukeiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyurui2keta zrnhknsyurui2keta}</td><td>（連携用）保険種類（２桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatukaibetu zrnatukaibetu}</td><td>（連携用）扱別</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnen3 zrnhhknnen3}</td><td>（連携用）被保険者年令（３文字）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoutatunenrei zrntoutatunenrei}</td><td>（連携用）到達年齢</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykym zrnkykym}</td><td>（連携用）契約年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsymtym zrnsymtym}</td><td>（連携用）消滅年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoriymd zrnsyoriymd}</td><td>（連携用）処理年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyktuuka zrnkyktuuka}</td><td>（連携用）契約通貨</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnimustiyusbus zrnimustiyusbus}</td><td>（連携用）医務査定用死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsykgycd zrnsykgycd}</td><td>（連携用）職業コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkhuhukbn zrnhrkhuhukbn}</td><td>（連携用）払込方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsirajikykkbn zrnsirajikykkbn}</td><td>（連携用）白地契約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatukaisosikicd zrnaatukaisosikicd}</td><td>（連携用）Ａ扱者組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatukaikojincd zrnaatukaikojincd}</td><td>（連携用）Ａ扱者個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsinsahouhou zrnsinsahouhou}</td><td>（連携用）診査方法</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsinsasyacd zrnsinsasyacd}</td><td>（連携用）診査者コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketteikekkakbn zrnketteikekkakbn}</td><td>（連携用）決定結果区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhikettisyacd zrndakuhikettisyacd}</td><td>（連携用）諾否決定者コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoubyoutyuubunrui zrnsyoubyoutyuubunrui}</td><td>（連携用）傷病中分類１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoubyoucd1x5 zrnsyoubyoucd1x5}</td><td>（連携用）傷病コード１（５文字）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoubyoucd2x5 zrnsyoubyoucd2x5}</td><td>（連携用）傷病コード２（５文字）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndaisiincd zrndaisiincd}</td><td>（連携用）大死因コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyuusiincd zrntyuusiincd}</td><td>（連携用）中死因コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyousiincd zrnsyousiincd}</td><td>（連携用）小死因コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsoukisibouhyj zrnsoukisibouhyj}</td><td>（連携用）早期死亡表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikakikankbn zrnkeikakikankbn}</td><td>（連携用）経過期間区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkoudosyougaiarihyj zrnkoudosyougaiarihyj}</td><td>（連携用）高度障害有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaijyokbn zrnkaijyokbn}</td><td>（連携用）解除区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnensyuukbn zrnnensyuukbn}</td><td>（連携用）年収区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhanbaikeirokbn zrnhanbaikeirokbn}</td><td>（連携用）販売経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnoyadairitencd zrnoyadairitencd}</td><td>（連携用）親代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbyoumeicd zrnbyoumeicd}</td><td>（連携用）病名コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyksbyensitihsyutyhkumu zrnsyksbyensitihsyutyhkumu}</td><td>（連携用）初期死亡時円換算最低保証特約付加有無</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyudkaigomehrtkhkumu zrnjyudkaigomehrtkhkumu}</td><td>（連携用）重度介護前払特約付加有無</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnijitoukeizennoukbn zrnijitoukeizennoukbn}</td><td>（連携用）医事統計用前納区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1hknkkn zrndai1hknkkn}</td><td>（連携用）第１保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnijitoukeitikshrtkykkbn zrnijitoukeitikshrtkykkbn}</td><td>（連携用）医事統計用定期支払特約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteikisiharaikinmanen zrnteikisiharaikinmanen}</td><td>（連携用）定期支払金（万円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyobiv78 zrnyobiv78}</td><td>（連携用）予備項目Ｖ７８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SyuSibouToukeiRn
 * @see     PKZT_SyuSibouToukeiRn
 * @see     QZT_SyuSibouToukeiRn
 * @see     GenQZT_SyuSibouToukeiRn
 */
@MappedSuperclass
@Table(name=GenZT_SyuSibouToukeiRn.TABLE_NAME)
@IdClass(value=PKZT_SyuSibouToukeiRn.class)
public abstract class GenZT_SyuSibouToukeiRn extends AbstractExDBEntityForZDB<ZT_SyuSibouToukeiRn, PKZT_SyuSibouToukeiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SyuSibouToukeiRn";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNHKNSYURUI2KETA        = "zrnhknsyurui2keta";
    public static final String ZRNATUKAIBETU            = "zrnatukaibetu";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNHHKNNEN3              = "zrnhhknnen3";
    public static final String ZRNTOUTATUNENREI         = "zrntoutatunenrei";
    public static final String ZRNKYKYM                 = "zrnkykym";
    public static final String ZRNSYMTYM                = "zrnsymtym";
    public static final String ZRNSYORIYMD              = "zrnsyoriymd";
    public static final String ZRNKYKTUUKA              = "zrnkyktuuka";
    public static final String ZRNIMUSTIYUSBUS          = "zrnimustiyusbus";
    public static final String ZRNSYKGYCD               = "zrnsykgycd";
    public static final String ZRNHRKHUHUKBN            = "zrnhrkhuhukbn";
    public static final String ZRNSIRAJIKYKKBN          = "zrnsirajikykkbn";
    public static final String ZRNAATUKAISOSIKICD       = "zrnaatukaisosikicd";
    public static final String ZRNAATUKAIKOJINCD        = "zrnaatukaikojincd";
    public static final String ZRNSINSAHOUHOU           = "zrnsinsahouhou";
    public static final String ZRNSINSASYACD            = "zrnsinsasyacd";
    public static final String ZRNKETTEIKEKKAKBN        = "zrnketteikekkakbn";
    public static final String ZRNDAKUHIKETTISYACD      = "zrndakuhikettisyacd";
    public static final String ZRNSYOUBYOUTYUUBUNRUI    = "zrnsyoubyoutyuubunrui";
    public static final String ZRNSYOUBYOUCD1X5         = "zrnsyoubyoucd1x5";
    public static final String ZRNSYOUBYOUCD2X5         = "zrnsyoubyoucd2x5";
    public static final String ZRNDAISIINCD             = "zrndaisiincd";
    public static final String ZRNTYUUSIINCD            = "zrntyuusiincd";
    public static final String ZRNSYOUSIINCD            = "zrnsyousiincd";
    public static final String ZRNSOUKISIBOUHYJ         = "zrnsoukisibouhyj";
    public static final String ZRNKEIKAKIKANKBN         = "zrnkeikakikankbn";
    public static final String ZRNKOUDOSYOUGAIARIHYJ    = "zrnkoudosyougaiarihyj";
    public static final String ZRNKAIJYOKBN             = "zrnkaijyokbn";
    public static final String ZRNNENSYUUKBN            = "zrnnensyuukbn";
    public static final String ZRNHANBAIKEIROKBN        = "zrnhanbaikeirokbn";
    public static final String ZRNOYADAIRITENCD         = "zrnoyadairitencd";
    public static final String ZRNBYOUMEICD             = "zrnbyoumeicd";
    public static final String ZRNSYKSBYENSITIHSYUTYHKUMU = "zrnsyksbyensitihsyutyhkumu";
    public static final String ZRNJYUDKAIGOMEHRTKHKUMU  = "zrnjyudkaigomehrtkhkumu";
    public static final String ZRNIJITOUKEIZENNOUKBN    = "zrnijitoukeizennoukbn";
    public static final String ZRNDAI1HKNKKN            = "zrndai1hknkkn";
    public static final String ZRNIJITOUKEITIKSHRTKYKKBN = "zrnijitoukeitikshrtkykkbn";
    public static final String ZRNTEIKISIHARAIKINMANEN  = "zrnteikisiharaikinmanen";
    public static final String ZRNYOBIV78               = "zrnyobiv78";

    private final PKZT_SyuSibouToukeiRn primaryKey;

    public GenZT_SyuSibouToukeiRn() {
        primaryKey = new PKZT_SyuSibouToukeiRn();
    }

    public GenZT_SyuSibouToukeiRn(String pZrnsyono) {
        primaryKey = new PKZT_SyuSibouToukeiRn(pZrnsyono);
    }

    @Transient
    @Override
    public PKZT_SyuSibouToukeiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SyuSibouToukeiRn> getMetaClass() {
        return QZT_SyuSibouToukeiRn.class;
    }

    @Id
    @Column(name=GenZT_SyuSibouToukeiRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnhknsyurui2keta;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNHKNSYURUI2KETA)
    public String getZrnhknsyurui2keta() {
        return zrnhknsyurui2keta;
    }

    public void setZrnhknsyurui2keta(String pZrnhknsyurui2keta) {
        zrnhknsyurui2keta = pZrnhknsyurui2keta;
    }

    private String zrnatukaibetu;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNATUKAIBETU)
    public String getZrnatukaibetu() {
        return zrnatukaibetu;
    }

    public void setZrnatukaibetu(String pZrnatukaibetu) {
        zrnatukaibetu = pZrnatukaibetu;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnhhknnen3;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNHHKNNEN3)
    public String getZrnhhknnen3() {
        return zrnhhknnen3;
    }

    public void setZrnhhknnen3(String pZrnhhknnen3) {
        zrnhhknnen3 = pZrnhhknnen3;
    }

    private String zrntoutatunenrei;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNTOUTATUNENREI)
    public String getZrntoutatunenrei() {
        return zrntoutatunenrei;
    }

    public void setZrntoutatunenrei(String pZrntoutatunenrei) {
        zrntoutatunenrei = pZrntoutatunenrei;
    }

    private String zrnkykym;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNKYKYM)
    public String getZrnkykym() {
        return zrnkykym;
    }

    public void setZrnkykym(String pZrnkykym) {
        zrnkykym = pZrnkykym;
    }

    private String zrnsymtym;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNSYMTYM)
    public String getZrnsymtym() {
        return zrnsymtym;
    }

    public void setZrnsymtym(String pZrnsymtym) {
        zrnsymtym = pZrnsymtym;
    }

    private String zrnsyoriymd;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNSYORIYMD)
    public String getZrnsyoriymd() {
        return zrnsyoriymd;
    }

    public void setZrnsyoriymd(String pZrnsyoriymd) {
        zrnsyoriymd = pZrnsyoriymd;
    }

    private String zrnkyktuuka;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNKYKTUUKA)
    public String getZrnkyktuuka() {
        return zrnkyktuuka;
    }

    public void setZrnkyktuuka(String pZrnkyktuuka) {
        zrnkyktuuka = pZrnkyktuuka;
    }

    private Integer zrnimustiyusbus;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNIMUSTIYUSBUS)
    public Integer getZrnimustiyusbus() {
        return zrnimustiyusbus;
    }

    public void setZrnimustiyusbus(Integer pZrnimustiyusbus) {
        zrnimustiyusbus = pZrnimustiyusbus;
    }

    private String zrnsykgycd;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNSYKGYCD)
    public String getZrnsykgycd() {
        return zrnsykgycd;
    }

    public void setZrnsykgycd(String pZrnsykgycd) {
        zrnsykgycd = pZrnsykgycd;
    }

    private String zrnhrkhuhukbn;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNHRKHUHUKBN)
    public String getZrnhrkhuhukbn() {
        return zrnhrkhuhukbn;
    }

    public void setZrnhrkhuhukbn(String pZrnhrkhuhukbn) {
        zrnhrkhuhukbn = pZrnhrkhuhukbn;
    }

    private String zrnsirajikykkbn;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNSIRAJIKYKKBN)
    public String getZrnsirajikykkbn() {
        return zrnsirajikykkbn;
    }

    public void setZrnsirajikykkbn(String pZrnsirajikykkbn) {
        zrnsirajikykkbn = pZrnsirajikykkbn;
    }

    private String zrnaatukaisosikicd;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNAATUKAISOSIKICD)
    public String getZrnaatukaisosikicd() {
        return zrnaatukaisosikicd;
    }

    public void setZrnaatukaisosikicd(String pZrnaatukaisosikicd) {
        zrnaatukaisosikicd = pZrnaatukaisosikicd;
    }

    private String zrnaatukaikojincd;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNAATUKAIKOJINCD)
    public String getZrnaatukaikojincd() {
        return zrnaatukaikojincd;
    }

    public void setZrnaatukaikojincd(String pZrnaatukaikojincd) {
        zrnaatukaikojincd = pZrnaatukaikojincd;
    }

    private String zrnsinsahouhou;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNSINSAHOUHOU)
    public String getZrnsinsahouhou() {
        return zrnsinsahouhou;
    }

    public void setZrnsinsahouhou(String pZrnsinsahouhou) {
        zrnsinsahouhou = pZrnsinsahouhou;
    }

    private String zrnsinsasyacd;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNSINSASYACD)
    public String getZrnsinsasyacd() {
        return zrnsinsasyacd;
    }

    public void setZrnsinsasyacd(String pZrnsinsasyacd) {
        zrnsinsasyacd = pZrnsinsasyacd;
    }

    private String zrnketteikekkakbn;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNKETTEIKEKKAKBN)
    public String getZrnketteikekkakbn() {
        return zrnketteikekkakbn;
    }

    public void setZrnketteikekkakbn(String pZrnketteikekkakbn) {
        zrnketteikekkakbn = pZrnketteikekkakbn;
    }

    private String zrndakuhikettisyacd;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNDAKUHIKETTISYACD)
    public String getZrndakuhikettisyacd() {
        return zrndakuhikettisyacd;
    }

    public void setZrndakuhikettisyacd(String pZrndakuhikettisyacd) {
        zrndakuhikettisyacd = pZrndakuhikettisyacd;
    }

    private String zrnsyoubyoutyuubunrui;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNSYOUBYOUTYUUBUNRUI)
    public String getZrnsyoubyoutyuubunrui() {
        return zrnsyoubyoutyuubunrui;
    }

    public void setZrnsyoubyoutyuubunrui(String pZrnsyoubyoutyuubunrui) {
        zrnsyoubyoutyuubunrui = pZrnsyoubyoutyuubunrui;
    }

    private String zrnsyoubyoucd1x5;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNSYOUBYOUCD1X5)
    public String getZrnsyoubyoucd1x5() {
        return zrnsyoubyoucd1x5;
    }

    public void setZrnsyoubyoucd1x5(String pZrnsyoubyoucd1x5) {
        zrnsyoubyoucd1x5 = pZrnsyoubyoucd1x5;
    }

    private String zrnsyoubyoucd2x5;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNSYOUBYOUCD2X5)
    public String getZrnsyoubyoucd2x5() {
        return zrnsyoubyoucd2x5;
    }

    public void setZrnsyoubyoucd2x5(String pZrnsyoubyoucd2x5) {
        zrnsyoubyoucd2x5 = pZrnsyoubyoucd2x5;
    }

    private String zrndaisiincd;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNDAISIINCD)
    public String getZrndaisiincd() {
        return zrndaisiincd;
    }

    public void setZrndaisiincd(String pZrndaisiincd) {
        zrndaisiincd = pZrndaisiincd;
    }

    private String zrntyuusiincd;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNTYUUSIINCD)
    public String getZrntyuusiincd() {
        return zrntyuusiincd;
    }

    public void setZrntyuusiincd(String pZrntyuusiincd) {
        zrntyuusiincd = pZrntyuusiincd;
    }

    private String zrnsyousiincd;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNSYOUSIINCD)
    public String getZrnsyousiincd() {
        return zrnsyousiincd;
    }

    public void setZrnsyousiincd(String pZrnsyousiincd) {
        zrnsyousiincd = pZrnsyousiincd;
    }

    private String zrnsoukisibouhyj;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNSOUKISIBOUHYJ)
    public String getZrnsoukisibouhyj() {
        return zrnsoukisibouhyj;
    }

    public void setZrnsoukisibouhyj(String pZrnsoukisibouhyj) {
        zrnsoukisibouhyj = pZrnsoukisibouhyj;
    }

    private String zrnkeikakikankbn;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNKEIKAKIKANKBN)
    public String getZrnkeikakikankbn() {
        return zrnkeikakikankbn;
    }

    public void setZrnkeikakikankbn(String pZrnkeikakikankbn) {
        zrnkeikakikankbn = pZrnkeikakikankbn;
    }

    private String zrnkoudosyougaiarihyj;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNKOUDOSYOUGAIARIHYJ)
    public String getZrnkoudosyougaiarihyj() {
        return zrnkoudosyougaiarihyj;
    }

    public void setZrnkoudosyougaiarihyj(String pZrnkoudosyougaiarihyj) {
        zrnkoudosyougaiarihyj = pZrnkoudosyougaiarihyj;
    }

    private String zrnkaijyokbn;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNKAIJYOKBN)
    public String getZrnkaijyokbn() {
        return zrnkaijyokbn;
    }

    public void setZrnkaijyokbn(String pZrnkaijyokbn) {
        zrnkaijyokbn = pZrnkaijyokbn;
    }

    private String zrnnensyuukbn;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNNENSYUUKBN)
    public String getZrnnensyuukbn() {
        return zrnnensyuukbn;
    }

    public void setZrnnensyuukbn(String pZrnnensyuukbn) {
        zrnnensyuukbn = pZrnnensyuukbn;
    }

    private String zrnhanbaikeirokbn;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNHANBAIKEIROKBN)
    public String getZrnhanbaikeirokbn() {
        return zrnhanbaikeirokbn;
    }

    public void setZrnhanbaikeirokbn(String pZrnhanbaikeirokbn) {
        zrnhanbaikeirokbn = pZrnhanbaikeirokbn;
    }

    private String zrnoyadairitencd;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNOYADAIRITENCD)
    public String getZrnoyadairitencd() {
        return zrnoyadairitencd;
    }

    public void setZrnoyadairitencd(String pZrnoyadairitencd) {
        zrnoyadairitencd = pZrnoyadairitencd;
    }

    private String zrnbyoumeicd;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNBYOUMEICD)
    public String getZrnbyoumeicd() {
        return zrnbyoumeicd;
    }

    public void setZrnbyoumeicd(String pZrnbyoumeicd) {
        zrnbyoumeicd = pZrnbyoumeicd;
    }

    private String zrnsyksbyensitihsyutyhkumu;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNSYKSBYENSITIHSYUTYHKUMU)
    public String getZrnsyksbyensitihsyutyhkumu() {
        return zrnsyksbyensitihsyutyhkumu;
    }

    public void setZrnsyksbyensitihsyutyhkumu(String pZrnsyksbyensitihsyutyhkumu) {
        zrnsyksbyensitihsyutyhkumu = pZrnsyksbyensitihsyutyhkumu;
    }

    private String zrnjyudkaigomehrtkhkumu;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNJYUDKAIGOMEHRTKHKUMU)
    public String getZrnjyudkaigomehrtkhkumu() {
        return zrnjyudkaigomehrtkhkumu;
    }

    public void setZrnjyudkaigomehrtkhkumu(String pZrnjyudkaigomehrtkhkumu) {
        zrnjyudkaigomehrtkhkumu = pZrnjyudkaigomehrtkhkumu;
    }

    private String zrnijitoukeizennoukbn;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNIJITOUKEIZENNOUKBN)
    public String getZrnijitoukeizennoukbn() {
        return zrnijitoukeizennoukbn;
    }

    public void setZrnijitoukeizennoukbn(String pZrnijitoukeizennoukbn) {
        zrnijitoukeizennoukbn = pZrnijitoukeizennoukbn;
    }

    private String zrndai1hknkkn;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNDAI1HKNKKN)
    public String getZrndai1hknkkn() {
        return zrndai1hknkkn;
    }

    public void setZrndai1hknkkn(String pZrndai1hknkkn) {
        zrndai1hknkkn = pZrndai1hknkkn;
    }

    private String zrnijitoukeitikshrtkykkbn;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNIJITOUKEITIKSHRTKYKKBN)
    public String getZrnijitoukeitikshrtkykkbn() {
        return zrnijitoukeitikshrtkykkbn;
    }

    public void setZrnijitoukeitikshrtkykkbn(String pZrnijitoukeitikshrtkykkbn) {
        zrnijitoukeitikshrtkykkbn = pZrnijitoukeitikshrtkykkbn;
    }

    private Integer zrnteikisiharaikinmanen;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNTEIKISIHARAIKINMANEN)
    public Integer getZrnteikisiharaikinmanen() {
        return zrnteikisiharaikinmanen;
    }

    public void setZrnteikisiharaikinmanen(Integer pZrnteikisiharaikinmanen) {
        zrnteikisiharaikinmanen = pZrnteikisiharaikinmanen;
    }

    private String zrnyobiv78;

    @Column(name=GenZT_SyuSibouToukeiRn.ZRNYOBIV78)
    public String getZrnyobiv78() {
        return zrnyobiv78;
    }

    public void setZrnyobiv78(String pZrnyobiv78) {
        zrnyobiv78 = pZrnyobiv78;
    }
}