package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_DrtenMinyuuKykInfoTy;
import yuyu.def.db.id.PKZT_DrtenMinyuuKykInfoTy;
import yuyu.def.db.meta.GenQZT_DrtenMinyuuKykInfoTy;
import yuyu.def.db.meta.QZT_DrtenMinyuuKykInfoTy;

/**
 * 代理店未入契約情報Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_DrtenMinyuuKykInfoTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DrtenMinyuuKykInfoTy}</td><td colspan="3">代理店未入契約情報Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_DrtenMinyuuKykInfoTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyym ztybsyym}</td><td>（中継用）募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirokbn ztyhrkkeirokbn}</td><td>（中継用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuukeikbn ztysyuukeikbn}</td><td>（中継用）集計区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyminyukaisuu ztyminyukaisuu}</td><td>（中継用）未入回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymisyuup ztymisyuup}</td><td>（中継用）未収Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhsys ztyhsys}</td><td>（中継用）保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyuuseis ztysyuuseis}</td><td>（中継用）修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyfukkatutyuuikbn ztyfukkatutyuuikbn}</td><td>（中継用）復活注意区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymrarihyj ztymrarihyj}</td><td>（中継用）ＭＲ有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfsttatekaekykhyj ztyfsttatekaekykhyj}</td><td>（中継用）初回立替契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytatekaekjrenzokukaisu ztytatekaekjrenzokukaisu}</td><td>（中継用）立替計上連続回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeizokutyuuihyouji ztykeizokutyuuihyouji}</td><td>（中継用）継続注意表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyouhinbunruikbn ztysyouhinbunruikbn}</td><td>（中継用）商品分類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyouhnnmkbn ztysyouhnnmkbn}</td><td>（中継用）商品名称区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjikaipjyuutouym ztyjikaipjyuutouym}</td><td>（中継用）次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaehurihunokbn ztykzhurikaehurihunokbn}</td><td>（中継用）口座振替振替不能理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyautocalltaisyoukykhyj ztyautocalltaisyoukykhyj}</td><td>（中継用）オートコール対象契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsudirtnatkikeitaikbn ztybsudirtnatkikeitaikbn}</td><td>（中継用）募集代理店扱形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsydrtencdx1 ztybsydrtencdx1}</td><td>（中継用）募集代理店コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsydrtencdx2 ztybsydrtencdx2}</td><td>（中継用）募集代理店コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyikkatubaraikbn ztyikkatubaraikbn}</td><td>（中継用）一括払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyikkatubaraikaisuu ztyikkatubaraikaisuu}</td><td>（中継用）一括払回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv34 ztyyobiv34}</td><td>（中継用）予備項目Ｖ３４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_DrtenMinyuuKykInfoTy
 * @see     PKZT_DrtenMinyuuKykInfoTy
 * @see     QZT_DrtenMinyuuKykInfoTy
 * @see     GenQZT_DrtenMinyuuKykInfoTy
 */
@MappedSuperclass
@Table(name=GenZT_DrtenMinyuuKykInfoTy.TABLE_NAME)
@IdClass(value=PKZT_DrtenMinyuuKykInfoTy.class)
public abstract class GenZT_DrtenMinyuuKykInfoTy extends AbstractExDBEntity<ZT_DrtenMinyuuKykInfoTy, PKZT_DrtenMinyuuKykInfoTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DrtenMinyuuKykInfoTy";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYBSYYM                 = "ztybsyym";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYHRKKEIROKBN           = "ztyhrkkeirokbn";
    public static final String ZTYSYUUKEIKBN            = "ztysyuukeikbn";
    public static final String ZTYMINYUKAISUU           = "ztyminyukaisuu";
    public static final String ZTYMISYUUP               = "ztymisyuup";
    public static final String ZTYHSYS                  = "ztyhsys";
    public static final String ZTYSYUUSEIS              = "ztysyuuseis";
    public static final String ZTYFUKKATUTYUUIKBN       = "ztyfukkatutyuuikbn";
    public static final String ZTYMRARIHYJ              = "ztymrarihyj";
    public static final String ZTYFSTTATEKAEKYKHYJ      = "ztyfsttatekaekykhyj";
    public static final String ZTYTATEKAEKJRENZOKUKAISU = "ztytatekaekjrenzokukaisu";
    public static final String ZTYKEIZOKUTYUUIHYOUJI    = "ztykeizokutyuuihyouji";
    public static final String ZTYSYOUHINBUNRUIKBN      = "ztysyouhinbunruikbn";
    public static final String ZTYSYOUHNNMKBN           = "ztysyouhnnmkbn";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYJIKAIPJYUUTOUYM       = "ztyjikaipjyuutouym";
    public static final String ZTYKZHURIKAEHURIHUNOKBN  = "ztykzhurikaehurihunokbn";
    public static final String ZTYAUTOCALLTAISYOUKYKHYJ = "ztyautocalltaisyoukykhyj";
    public static final String ZTYBSUDIRTNATKIKEITAIKBN = "ztybsudirtnatkikeitaikbn";
    public static final String ZTYBSYDRTENCDX1          = "ztybsydrtencdx1";
    public static final String ZTYBSYDRTENCDX2          = "ztybsydrtencdx2";
    public static final String ZTYIKKATUBARAIKBN        = "ztyikkatubaraikbn";
    public static final String ZTYIKKATUBARAIKAISUU     = "ztyikkatubaraikaisuu";
    public static final String ZTYYOBIV34               = "ztyyobiv34";

    private final PKZT_DrtenMinyuuKykInfoTy primaryKey;

    public GenZT_DrtenMinyuuKykInfoTy() {
        primaryKey = new PKZT_DrtenMinyuuKykInfoTy();
    }

    public GenZT_DrtenMinyuuKykInfoTy(String pZtysyono) {
        primaryKey = new PKZT_DrtenMinyuuKykInfoTy(pZtysyono);
    }

    @Transient
    @Override
    public PKZT_DrtenMinyuuKykInfoTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DrtenMinyuuKykInfoTy> getMetaClass() {
        return QZT_DrtenMinyuuKykInfoTy.class;
    }

    @Id
    @Column(name=GenZT_DrtenMinyuuKykInfoTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztykykymd;

    @Column(name=GenZT_DrtenMinyuuKykInfoTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztybsyym;

    @Column(name=GenZT_DrtenMinyuuKykInfoTy.ZTYBSYYM)
    public String getZtybsyym() {
        return ztybsyym;
    }

    public void setZtybsyym(String pZtybsyym) {
        ztybsyym = pZtybsyym;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_DrtenMinyuuKykInfoTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztyhrkkeirokbn;

    @Column(name=GenZT_DrtenMinyuuKykInfoTy.ZTYHRKKEIROKBN)
    public String getZtyhrkkeirokbn() {
        return ztyhrkkeirokbn;
    }

    public void setZtyhrkkeirokbn(String pZtyhrkkeirokbn) {
        ztyhrkkeirokbn = pZtyhrkkeirokbn;
    }

    private String ztysyuukeikbn;

    @Column(name=GenZT_DrtenMinyuuKykInfoTy.ZTYSYUUKEIKBN)
    public String getZtysyuukeikbn() {
        return ztysyuukeikbn;
    }

    public void setZtysyuukeikbn(String pZtysyuukeikbn) {
        ztysyuukeikbn = pZtysyuukeikbn;
    }

    private String ztyminyukaisuu;

    @Column(name=GenZT_DrtenMinyuuKykInfoTy.ZTYMINYUKAISUU)
    public String getZtyminyukaisuu() {
        return ztyminyukaisuu;
    }

    public void setZtyminyukaisuu(String pZtyminyukaisuu) {
        ztyminyukaisuu = pZtyminyukaisuu;
    }

    private Long ztymisyuup;

    @Column(name=GenZT_DrtenMinyuuKykInfoTy.ZTYMISYUUP)
    public Long getZtymisyuup() {
        return ztymisyuup;
    }

    public void setZtymisyuup(Long pZtymisyuup) {
        ztymisyuup = pZtymisyuup;
    }

    private Long ztyhsys;

    @Column(name=GenZT_DrtenMinyuuKykInfoTy.ZTYHSYS)
    public Long getZtyhsys() {
        return ztyhsys;
    }

    public void setZtyhsys(Long pZtyhsys) {
        ztyhsys = pZtyhsys;
    }

    private Long ztysyuuseis;

    @Column(name=GenZT_DrtenMinyuuKykInfoTy.ZTYSYUUSEIS)
    public Long getZtysyuuseis() {
        return ztysyuuseis;
    }

    public void setZtysyuuseis(Long pZtysyuuseis) {
        ztysyuuseis = pZtysyuuseis;
    }

    private String ztyfukkatutyuuikbn;

    @Column(name=GenZT_DrtenMinyuuKykInfoTy.ZTYFUKKATUTYUUIKBN)
    public String getZtyfukkatutyuuikbn() {
        return ztyfukkatutyuuikbn;
    }

    public void setZtyfukkatutyuuikbn(String pZtyfukkatutyuuikbn) {
        ztyfukkatutyuuikbn = pZtyfukkatutyuuikbn;
    }

    private String ztymrarihyj;

    @Column(name=GenZT_DrtenMinyuuKykInfoTy.ZTYMRARIHYJ)
    public String getZtymrarihyj() {
        return ztymrarihyj;
    }

    public void setZtymrarihyj(String pZtymrarihyj) {
        ztymrarihyj = pZtymrarihyj;
    }

    private String ztyfsttatekaekykhyj;

    @Column(name=GenZT_DrtenMinyuuKykInfoTy.ZTYFSTTATEKAEKYKHYJ)
    public String getZtyfsttatekaekykhyj() {
        return ztyfsttatekaekykhyj;
    }

    public void setZtyfsttatekaekykhyj(String pZtyfsttatekaekykhyj) {
        ztyfsttatekaekykhyj = pZtyfsttatekaekykhyj;
    }

    private String ztytatekaekjrenzokukaisu;

    @Column(name=GenZT_DrtenMinyuuKykInfoTy.ZTYTATEKAEKJRENZOKUKAISU)
    public String getZtytatekaekjrenzokukaisu() {
        return ztytatekaekjrenzokukaisu;
    }

    public void setZtytatekaekjrenzokukaisu(String pZtytatekaekjrenzokukaisu) {
        ztytatekaekjrenzokukaisu = pZtytatekaekjrenzokukaisu;
    }

    private String ztykeizokutyuuihyouji;

    @Column(name=GenZT_DrtenMinyuuKykInfoTy.ZTYKEIZOKUTYUUIHYOUJI)
    public String getZtykeizokutyuuihyouji() {
        return ztykeizokutyuuihyouji;
    }

    public void setZtykeizokutyuuihyouji(String pZtykeizokutyuuihyouji) {
        ztykeizokutyuuihyouji = pZtykeizokutyuuihyouji;
    }

    private String ztysyouhinbunruikbn;

    @Column(name=GenZT_DrtenMinyuuKykInfoTy.ZTYSYOUHINBUNRUIKBN)
    public String getZtysyouhinbunruikbn() {
        return ztysyouhinbunruikbn;
    }

    public void setZtysyouhinbunruikbn(String pZtysyouhinbunruikbn) {
        ztysyouhinbunruikbn = pZtysyouhinbunruikbn;
    }

    private String ztysyouhnnmkbn;

    @Column(name=GenZT_DrtenMinyuuKykInfoTy.ZTYSYOUHNNMKBN)
    public String getZtysyouhnnmkbn() {
        return ztysyouhnnmkbn;
    }

    public void setZtysyouhnnmkbn(String pZtysyouhnnmkbn) {
        ztysyouhnnmkbn = pZtysyouhnnmkbn;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_DrtenMinyuuKykInfoTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztyjikaipjyuutouym;

    @Column(name=GenZT_DrtenMinyuuKykInfoTy.ZTYJIKAIPJYUUTOUYM)
    public String getZtyjikaipjyuutouym() {
        return ztyjikaipjyuutouym;
    }

    public void setZtyjikaipjyuutouym(String pZtyjikaipjyuutouym) {
        ztyjikaipjyuutouym = pZtyjikaipjyuutouym;
    }

    private String ztykzhurikaehurihunokbn;

    @Column(name=GenZT_DrtenMinyuuKykInfoTy.ZTYKZHURIKAEHURIHUNOKBN)
    public String getZtykzhurikaehurihunokbn() {
        return ztykzhurikaehurihunokbn;
    }

    public void setZtykzhurikaehurihunokbn(String pZtykzhurikaehurihunokbn) {
        ztykzhurikaehurihunokbn = pZtykzhurikaehurihunokbn;
    }

    private String ztyautocalltaisyoukykhyj;

    @Column(name=GenZT_DrtenMinyuuKykInfoTy.ZTYAUTOCALLTAISYOUKYKHYJ)
    public String getZtyautocalltaisyoukykhyj() {
        return ztyautocalltaisyoukykhyj;
    }

    public void setZtyautocalltaisyoukykhyj(String pZtyautocalltaisyoukykhyj) {
        ztyautocalltaisyoukykhyj = pZtyautocalltaisyoukykhyj;
    }

    private String ztybsudirtnatkikeitaikbn;

    @Column(name=GenZT_DrtenMinyuuKykInfoTy.ZTYBSUDIRTNATKIKEITAIKBN)
    public String getZtybsudirtnatkikeitaikbn() {
        return ztybsudirtnatkikeitaikbn;
    }

    public void setZtybsudirtnatkikeitaikbn(String pZtybsudirtnatkikeitaikbn) {
        ztybsudirtnatkikeitaikbn = pZtybsudirtnatkikeitaikbn;
    }

    private String ztybsydrtencdx1;

    @Column(name=GenZT_DrtenMinyuuKykInfoTy.ZTYBSYDRTENCDX1)
    public String getZtybsydrtencdx1() {
        return ztybsydrtencdx1;
    }

    public void setZtybsydrtencdx1(String pZtybsydrtencdx1) {
        ztybsydrtencdx1 = pZtybsydrtencdx1;
    }

    private String ztybsydrtencdx2;

    @Column(name=GenZT_DrtenMinyuuKykInfoTy.ZTYBSYDRTENCDX2)
    public String getZtybsydrtencdx2() {
        return ztybsydrtencdx2;
    }

    public void setZtybsydrtencdx2(String pZtybsydrtencdx2) {
        ztybsydrtencdx2 = pZtybsydrtencdx2;
    }

    private String ztyikkatubaraikbn;

    @Column(name=GenZT_DrtenMinyuuKykInfoTy.ZTYIKKATUBARAIKBN)
    public String getZtyikkatubaraikbn() {
        return ztyikkatubaraikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyikkatubaraikbn(String pZtyikkatubaraikbn) {
        ztyikkatubaraikbn = pZtyikkatubaraikbn;
    }

    private String ztyikkatubaraikaisuu;

    @Column(name=GenZT_DrtenMinyuuKykInfoTy.ZTYIKKATUBARAIKAISUU)
    public String getZtyikkatubaraikaisuu() {
        return ztyikkatubaraikaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyikkatubaraikaisuu(String pZtyikkatubaraikaisuu) {
        ztyikkatubaraikaisuu = pZtyikkatubaraikaisuu;
    }

    private String ztyyobiv34;

    @Column(name=GenZT_DrtenMinyuuKykInfoTy.ZTYYOBIV34)
    public String getZtyyobiv34() {
        return ztyyobiv34;
    }

    public void setZtyyobiv34(String pZtyyobiv34) {
        ztyyobiv34 = pZtyyobiv34;
    }
}