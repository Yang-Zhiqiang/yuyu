package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_SyuSibouToukeiTy;
import yuyu.def.db.id.PKZT_SyuSibouToukeiTy;
import yuyu.def.db.meta.GenQZT_SyuSibouToukeiTy;
import yuyu.def.db.meta.QZT_SyuSibouToukeiTy;

/**
 * 主契約死亡統計データテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_SyuSibouToukeiTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SyuSibouToukeiTy}</td><td colspan="3">主契約死亡統計データテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_SyuSibouToukeiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyurui2keta ztyhknsyurui2keta}</td><td>（中継用）保険種類（２桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatukaibetu ztyatukaibetu}</td><td>（中継用）扱別</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnen3 ztyhhknnen3}</td><td>（中継用）被保険者年令（３文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoutatunenrei ztytoutatunenrei}</td><td>（中継用）到達年齢</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykym ztykykym}</td><td>（中継用）契約年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysymtym ztysymtym}</td><td>（中継用）消滅年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoriymd ztysyoriymd}</td><td>（中継用）処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyktuuka ztykyktuuka}</td><td>（中継用）契約通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyimustiyusbus ztyimustiyusbus}</td><td>（中継用）医務査定用死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysykgycd ztysykgycd}</td><td>（中継用）職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkhuhukbn ztyhrkhuhukbn}</td><td>（中継用）払込方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysirajikykkbn ztysirajikykkbn}</td><td>（中継用）白地契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatukaisosikicd ztyaatukaisosikicd}</td><td>（中継用）Ａ扱者組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatukaikojincd ztyaatukaikojincd}</td><td>（中継用）Ａ扱者個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysinsahouhou ztysinsahouhou}</td><td>（中継用）診査方法</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysinsasyacd ztysinsasyacd}</td><td>（中継用）診査者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketteikekkakbn ztyketteikekkakbn}</td><td>（中継用）決定結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhikettisyacd ztydakuhikettisyacd}</td><td>（中継用）諾否決定者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoubyoutyuubunrui ztysyoubyoutyuubunrui}</td><td>（中継用）傷病中分類１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoubyoucd1x5 ztysyoubyoucd1x5}</td><td>（中継用）傷病コード１（５文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoubyoucd2x5 ztysyoubyoucd2x5}</td><td>（中継用）傷病コード２（５文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydaisiincd ztydaisiincd}</td><td>（中継用）大死因コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyuusiincd ztytyuusiincd}</td><td>（中継用）中死因コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyousiincd ztysyousiincd}</td><td>（中継用）小死因コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysoukisibouhyj ztysoukisibouhyj}</td><td>（中継用）早期死亡表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikakikankbn ztykeikakikankbn}</td><td>（中継用）経過期間区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykoudosyougaiarihyj ztykoudosyougaiarihyj}</td><td>（中継用）高度障害有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaijyokbn ztykaijyokbn}</td><td>（中継用）解除区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynensyuukbn ztynensyuukbn}</td><td>（中継用）年収区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhanbaikeirokbn ztyhanbaikeirokbn}</td><td>（中継用）販売経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyoyadairitencd ztyoyadairitencd}</td><td>（中継用）親代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybyoumeicd ztybyoumeicd}</td><td>（中継用）病名コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyksbyensitihsyutyhkumu ztysyksbyensitihsyutyhkumu}</td><td>（中継用）初期死亡時円換算最低保証特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyudkaigomehrtkhkumu ztyjyudkaigomehrtkhkumu}</td><td>（中継用）重度介護前払特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyijitoukeizennoukbn ztyijitoukeizennoukbn}</td><td>（中継用）医事統計用前納区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1hknkkn ztydai1hknkkn}</td><td>（中継用）第１保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyijitoukeitikshrtkykkbn ztyijitoukeitikshrtkykkbn}</td><td>（中継用）医事統計用定期支払特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteikisiharaikinmanen ztyteikisiharaikinmanen}</td><td>（中継用）定期支払金（万円）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyobiv78 ztyyobiv78}</td><td>（中継用）予備項目Ｖ７８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SyuSibouToukeiTy
 * @see     PKZT_SyuSibouToukeiTy
 * @see     QZT_SyuSibouToukeiTy
 * @see     GenQZT_SyuSibouToukeiTy
 */
@MappedSuperclass
@Table(name=GenZT_SyuSibouToukeiTy.TABLE_NAME)
@IdClass(value=PKZT_SyuSibouToukeiTy.class)
public abstract class GenZT_SyuSibouToukeiTy extends AbstractExDBEntity<ZT_SyuSibouToukeiTy, PKZT_SyuSibouToukeiTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SyuSibouToukeiTy";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYHKNSYURUI2KETA        = "ztyhknsyurui2keta";
    public static final String ZTYATUKAIBETU            = "ztyatukaibetu";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYHHKNNEN3              = "ztyhhknnen3";
    public static final String ZTYTOUTATUNENREI         = "ztytoutatunenrei";
    public static final String ZTYKYKYM                 = "ztykykym";
    public static final String ZTYSYMTYM                = "ztysymtym";
    public static final String ZTYSYORIYMD              = "ztysyoriymd";
    public static final String ZTYKYKTUUKA              = "ztykyktuuka";
    public static final String ZTYIMUSTIYUSBUS          = "ztyimustiyusbus";
    public static final String ZTYSYKGYCD               = "ztysykgycd";
    public static final String ZTYHRKHUHUKBN            = "ztyhrkhuhukbn";
    public static final String ZTYSIRAJIKYKKBN          = "ztysirajikykkbn";
    public static final String ZTYAATUKAISOSIKICD       = "ztyaatukaisosikicd";
    public static final String ZTYAATUKAIKOJINCD        = "ztyaatukaikojincd";
    public static final String ZTYSINSAHOUHOU           = "ztysinsahouhou";
    public static final String ZTYSINSASYACD            = "ztysinsasyacd";
    public static final String ZTYKETTEIKEKKAKBN        = "ztyketteikekkakbn";
    public static final String ZTYDAKUHIKETTISYACD      = "ztydakuhikettisyacd";
    public static final String ZTYSYOUBYOUTYUUBUNRUI    = "ztysyoubyoutyuubunrui";
    public static final String ZTYSYOUBYOUCD1X5         = "ztysyoubyoucd1x5";
    public static final String ZTYSYOUBYOUCD2X5         = "ztysyoubyoucd2x5";
    public static final String ZTYDAISIINCD             = "ztydaisiincd";
    public static final String ZTYTYUUSIINCD            = "ztytyuusiincd";
    public static final String ZTYSYOUSIINCD            = "ztysyousiincd";
    public static final String ZTYSOUKISIBOUHYJ         = "ztysoukisibouhyj";
    public static final String ZTYKEIKAKIKANKBN         = "ztykeikakikankbn";
    public static final String ZTYKOUDOSYOUGAIARIHYJ    = "ztykoudosyougaiarihyj";
    public static final String ZTYKAIJYOKBN             = "ztykaijyokbn";
    public static final String ZTYNENSYUUKBN            = "ztynensyuukbn";
    public static final String ZTYHANBAIKEIROKBN        = "ztyhanbaikeirokbn";
    public static final String ZTYOYADAIRITENCD         = "ztyoyadairitencd";
    public static final String ZTYBYOUMEICD             = "ztybyoumeicd";
    public static final String ZTYSYKSBYENSITIHSYUTYHKUMU = "ztysyksbyensitihsyutyhkumu";
    public static final String ZTYJYUDKAIGOMEHRTKHKUMU  = "ztyjyudkaigomehrtkhkumu";
    public static final String ZTYIJITOUKEIZENNOUKBN    = "ztyijitoukeizennoukbn";
    public static final String ZTYDAI1HKNKKN            = "ztydai1hknkkn";
    public static final String ZTYIJITOUKEITIKSHRTKYKKBN = "ztyijitoukeitikshrtkykkbn";
    public static final String ZTYTEIKISIHARAIKINMANEN  = "ztyteikisiharaikinmanen";
    public static final String ZTYYOBIV78               = "ztyyobiv78";

    private final PKZT_SyuSibouToukeiTy primaryKey;

    public GenZT_SyuSibouToukeiTy() {
        primaryKey = new PKZT_SyuSibouToukeiTy();
    }

    public GenZT_SyuSibouToukeiTy(String pZtysyono) {
        primaryKey = new PKZT_SyuSibouToukeiTy(pZtysyono);
    }

    @Transient
    @Override
    public PKZT_SyuSibouToukeiTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SyuSibouToukeiTy> getMetaClass() {
        return QZT_SyuSibouToukeiTy.class;
    }

    @Id
    @Column(name=GenZT_SyuSibouToukeiTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztyhknsyurui2keta;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYHKNSYURUI2KETA)
    public String getZtyhknsyurui2keta() {
        return ztyhknsyurui2keta;
    }

    public void setZtyhknsyurui2keta(String pZtyhknsyurui2keta) {
        ztyhknsyurui2keta = pZtyhknsyurui2keta;
    }

    private String ztyatukaibetu;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYATUKAIBETU)
    public String getZtyatukaibetu() {
        return ztyatukaibetu;
    }

    public void setZtyatukaibetu(String pZtyatukaibetu) {
        ztyatukaibetu = pZtyatukaibetu;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztyhhknnen3;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYHHKNNEN3)
    public String getZtyhhknnen3() {
        return ztyhhknnen3;
    }

    public void setZtyhhknnen3(String pZtyhhknnen3) {
        ztyhhknnen3 = pZtyhhknnen3;
    }

    private String ztytoutatunenrei;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYTOUTATUNENREI)
    public String getZtytoutatunenrei() {
        return ztytoutatunenrei;
    }

    public void setZtytoutatunenrei(String pZtytoutatunenrei) {
        ztytoutatunenrei = pZtytoutatunenrei;
    }

    private String ztykykym;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYKYKYM)
    public String getZtykykym() {
        return ztykykym;
    }

    public void setZtykykym(String pZtykykym) {
        ztykykym = pZtykykym;
    }

    private String ztysymtym;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYSYMTYM)
    public String getZtysymtym() {
        return ztysymtym;
    }

    public void setZtysymtym(String pZtysymtym) {
        ztysymtym = pZtysymtym;
    }

    private String ztysyoriymd;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYSYORIYMD)
    public String getZtysyoriymd() {
        return ztysyoriymd;
    }

    public void setZtysyoriymd(String pZtysyoriymd) {
        ztysyoriymd = pZtysyoriymd;
    }

    private String ztykyktuuka;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYKYKTUUKA)
    public String getZtykyktuuka() {
        return ztykyktuuka;
    }

    public void setZtykyktuuka(String pZtykyktuuka) {
        ztykyktuuka = pZtykyktuuka;
    }

    private Integer ztyimustiyusbus;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYIMUSTIYUSBUS)
    public Integer getZtyimustiyusbus() {
        return ztyimustiyusbus;
    }

    public void setZtyimustiyusbus(Integer pZtyimustiyusbus) {
        ztyimustiyusbus = pZtyimustiyusbus;
    }

    private String ztysykgycd;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYSYKGYCD)
    public String getZtysykgycd() {
        return ztysykgycd;
    }

    public void setZtysykgycd(String pZtysykgycd) {
        ztysykgycd = pZtysykgycd;
    }

    private String ztyhrkhuhukbn;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYHRKHUHUKBN)
    public String getZtyhrkhuhukbn() {
        return ztyhrkhuhukbn;
    }

    public void setZtyhrkhuhukbn(String pZtyhrkhuhukbn) {
        ztyhrkhuhukbn = pZtyhrkhuhukbn;
    }

    private String ztysirajikykkbn;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYSIRAJIKYKKBN)
    public String getZtysirajikykkbn() {
        return ztysirajikykkbn;
    }

    public void setZtysirajikykkbn(String pZtysirajikykkbn) {
        ztysirajikykkbn = pZtysirajikykkbn;
    }

    private String ztyaatukaisosikicd;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYAATUKAISOSIKICD)
    public String getZtyaatukaisosikicd() {
        return ztyaatukaisosikicd;
    }

    public void setZtyaatukaisosikicd(String pZtyaatukaisosikicd) {
        ztyaatukaisosikicd = pZtyaatukaisosikicd;
    }

    private String ztyaatukaikojincd;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYAATUKAIKOJINCD)
    public String getZtyaatukaikojincd() {
        return ztyaatukaikojincd;
    }

    public void setZtyaatukaikojincd(String pZtyaatukaikojincd) {
        ztyaatukaikojincd = pZtyaatukaikojincd;
    }

    private String ztysinsahouhou;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYSINSAHOUHOU)
    public String getZtysinsahouhou() {
        return ztysinsahouhou;
    }

    public void setZtysinsahouhou(String pZtysinsahouhou) {
        ztysinsahouhou = pZtysinsahouhou;
    }

    private String ztysinsasyacd;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYSINSASYACD)
    public String getZtysinsasyacd() {
        return ztysinsasyacd;
    }

    public void setZtysinsasyacd(String pZtysinsasyacd) {
        ztysinsasyacd = pZtysinsasyacd;
    }

    private String ztyketteikekkakbn;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYKETTEIKEKKAKBN)
    public String getZtyketteikekkakbn() {
        return ztyketteikekkakbn;
    }

    public void setZtyketteikekkakbn(String pZtyketteikekkakbn) {
        ztyketteikekkakbn = pZtyketteikekkakbn;
    }

    private String ztydakuhikettisyacd;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYDAKUHIKETTISYACD)
    public String getZtydakuhikettisyacd() {
        return ztydakuhikettisyacd;
    }

    public void setZtydakuhikettisyacd(String pZtydakuhikettisyacd) {
        ztydakuhikettisyacd = pZtydakuhikettisyacd;
    }

    private String ztysyoubyoutyuubunrui;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYSYOUBYOUTYUUBUNRUI)
    public String getZtysyoubyoutyuubunrui() {
        return ztysyoubyoutyuubunrui;
    }

    public void setZtysyoubyoutyuubunrui(String pZtysyoubyoutyuubunrui) {
        ztysyoubyoutyuubunrui = pZtysyoubyoutyuubunrui;
    }

    private String ztysyoubyoucd1x5;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYSYOUBYOUCD1X5)
    public String getZtysyoubyoucd1x5() {
        return ztysyoubyoucd1x5;
    }

    public void setZtysyoubyoucd1x5(String pZtysyoubyoucd1x5) {
        ztysyoubyoucd1x5 = pZtysyoubyoucd1x5;
    }

    private String ztysyoubyoucd2x5;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYSYOUBYOUCD2X5)
    public String getZtysyoubyoucd2x5() {
        return ztysyoubyoucd2x5;
    }

    public void setZtysyoubyoucd2x5(String pZtysyoubyoucd2x5) {
        ztysyoubyoucd2x5 = pZtysyoubyoucd2x5;
    }

    private String ztydaisiincd;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYDAISIINCD)
    public String getZtydaisiincd() {
        return ztydaisiincd;
    }

    public void setZtydaisiincd(String pZtydaisiincd) {
        ztydaisiincd = pZtydaisiincd;
    }

    private String ztytyuusiincd;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYTYUUSIINCD)
    public String getZtytyuusiincd() {
        return ztytyuusiincd;
    }

    public void setZtytyuusiincd(String pZtytyuusiincd) {
        ztytyuusiincd = pZtytyuusiincd;
    }

    private String ztysyousiincd;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYSYOUSIINCD)
    public String getZtysyousiincd() {
        return ztysyousiincd;
    }

    public void setZtysyousiincd(String pZtysyousiincd) {
        ztysyousiincd = pZtysyousiincd;
    }

    private String ztysoukisibouhyj;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYSOUKISIBOUHYJ)
    public String getZtysoukisibouhyj() {
        return ztysoukisibouhyj;
    }

    public void setZtysoukisibouhyj(String pZtysoukisibouhyj) {
        ztysoukisibouhyj = pZtysoukisibouhyj;
    }

    private String ztykeikakikankbn;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYKEIKAKIKANKBN)
    public String getZtykeikakikankbn() {
        return ztykeikakikankbn;
    }

    public void setZtykeikakikankbn(String pZtykeikakikankbn) {
        ztykeikakikankbn = pZtykeikakikankbn;
    }

    private String ztykoudosyougaiarihyj;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYKOUDOSYOUGAIARIHYJ)
    public String getZtykoudosyougaiarihyj() {
        return ztykoudosyougaiarihyj;
    }

    public void setZtykoudosyougaiarihyj(String pZtykoudosyougaiarihyj) {
        ztykoudosyougaiarihyj = pZtykoudosyougaiarihyj;
    }

    private String ztykaijyokbn;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYKAIJYOKBN)
    public String getZtykaijyokbn() {
        return ztykaijyokbn;
    }

    public void setZtykaijyokbn(String pZtykaijyokbn) {
        ztykaijyokbn = pZtykaijyokbn;
    }

    private String ztynensyuukbn;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYNENSYUUKBN)
    public String getZtynensyuukbn() {
        return ztynensyuukbn;
    }

    public void setZtynensyuukbn(String pZtynensyuukbn) {
        ztynensyuukbn = pZtynensyuukbn;
    }

    private String ztyhanbaikeirokbn;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYHANBAIKEIROKBN)
    public String getZtyhanbaikeirokbn() {
        return ztyhanbaikeirokbn;
    }

    public void setZtyhanbaikeirokbn(String pZtyhanbaikeirokbn) {
        ztyhanbaikeirokbn = pZtyhanbaikeirokbn;
    }

    private String ztyoyadairitencd;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYOYADAIRITENCD)
    public String getZtyoyadairitencd() {
        return ztyoyadairitencd;
    }

    public void setZtyoyadairitencd(String pZtyoyadairitencd) {
        ztyoyadairitencd = pZtyoyadairitencd;
    }

    private String ztybyoumeicd;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYBYOUMEICD)
    public String getZtybyoumeicd() {
        return ztybyoumeicd;
    }

    public void setZtybyoumeicd(String pZtybyoumeicd) {
        ztybyoumeicd = pZtybyoumeicd;
    }

    private String ztysyksbyensitihsyutyhkumu;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYSYKSBYENSITIHSYUTYHKUMU)
    public String getZtysyksbyensitihsyutyhkumu() {
        return ztysyksbyensitihsyutyhkumu;
    }

    public void setZtysyksbyensitihsyutyhkumu(String pZtysyksbyensitihsyutyhkumu) {
        ztysyksbyensitihsyutyhkumu = pZtysyksbyensitihsyutyhkumu;
    }

    private String ztyjyudkaigomehrtkhkumu;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYJYUDKAIGOMEHRTKHKUMU)
    public String getZtyjyudkaigomehrtkhkumu() {
        return ztyjyudkaigomehrtkhkumu;
    }

    public void setZtyjyudkaigomehrtkhkumu(String pZtyjyudkaigomehrtkhkumu) {
        ztyjyudkaigomehrtkhkumu = pZtyjyudkaigomehrtkhkumu;
    }

    private String ztyijitoukeizennoukbn;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYIJITOUKEIZENNOUKBN)
    public String getZtyijitoukeizennoukbn() {
        return ztyijitoukeizennoukbn;
    }

    public void setZtyijitoukeizennoukbn(String pZtyijitoukeizennoukbn) {
        ztyijitoukeizennoukbn = pZtyijitoukeizennoukbn;
    }

    private String ztydai1hknkkn;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYDAI1HKNKKN)
    public String getZtydai1hknkkn() {
        return ztydai1hknkkn;
    }

    public void setZtydai1hknkkn(String pZtydai1hknkkn) {
        ztydai1hknkkn = pZtydai1hknkkn;
    }

    private String ztyijitoukeitikshrtkykkbn;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYIJITOUKEITIKSHRTKYKKBN)
    public String getZtyijitoukeitikshrtkykkbn() {
        return ztyijitoukeitikshrtkykkbn;
    }

    public void setZtyijitoukeitikshrtkykkbn(String pZtyijitoukeitikshrtkykkbn) {
        ztyijitoukeitikshrtkykkbn = pZtyijitoukeitikshrtkykkbn;
    }

    private Integer ztyteikisiharaikinmanen;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYTEIKISIHARAIKINMANEN)
    public Integer getZtyteikisiharaikinmanen() {
        return ztyteikisiharaikinmanen;
    }

    public void setZtyteikisiharaikinmanen(Integer pZtyteikisiharaikinmanen) {
        ztyteikisiharaikinmanen = pZtyteikisiharaikinmanen;
    }

    private String ztyyobiv78;

    @Column(name=GenZT_SyuSibouToukeiTy.ZTYYOBIV78)
    public String getZtyyobiv78() {
        return ztyyobiv78;
    }

    public void setZtyyobiv78(String pZtyyobiv78) {
        ztyyobiv78 = pZtyyobiv78;
    }
}