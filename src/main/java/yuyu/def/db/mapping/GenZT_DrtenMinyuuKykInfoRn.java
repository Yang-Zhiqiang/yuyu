package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_DrtenMinyuuKykInfoRn;
import yuyu.def.db.id.PKZT_DrtenMinyuuKykInfoRn;
import yuyu.def.db.meta.GenQZT_DrtenMinyuuKykInfoRn;
import yuyu.def.db.meta.QZT_DrtenMinyuuKykInfoRn;

/**
 * 代理店未入契約情報Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_DrtenMinyuuKykInfoRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DrtenMinyuuKykInfoRn}</td><td colspan="3">代理店未入契約情報Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_DrtenMinyuuKykInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyym zrnbsyym}</td><td>（連携用）募集年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirokbn zrnhrkkeirokbn}</td><td>（連携用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuukeikbn zrnsyuukeikbn}</td><td>（連携用）集計区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnminyukaisuu zrnminyukaisuu}</td><td>（連携用）未入回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmisyuup zrnmisyuup}</td><td>（連携用）未収Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhsys zrnhsys}</td><td>（連携用）保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyuuseis zrnsyuuseis}</td><td>（連携用）修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnfukkatutyuuikbn zrnfukkatutyuuikbn}</td><td>（連携用）復活注意区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmrarihyj zrnmrarihyj}</td><td>（連携用）ＭＲ有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfsttatekaekykhyj zrnfsttatekaekykhyj}</td><td>（連携用）初回立替契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntatekaekjrenzokukaisu zrntatekaekjrenzokukaisu}</td><td>（連携用）立替計上連続回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeizokutyuuihyouji zrnkeizokutyuuihyouji}</td><td>（連携用）継続注意表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyouhinbunruikbn zrnsyouhinbunruikbn}</td><td>（連携用）商品分類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyouhnnmkbn zrnsyouhnnmkbn}</td><td>（連携用）商品名称区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjikaipjyuutouym zrnjikaipjyuutouym}</td><td>（連携用）次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaehurihunokbn zrnkzhurikaehurihunokbn}</td><td>（連携用）口座振替振替不能理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnautocalltaisyoukykhyj zrnautocalltaisyoukykhyj}</td><td>（連携用）オートコール対象契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsudirtnatkikeitaikbn zrnbsudirtnatkikeitaikbn}</td><td>（連携用）募集代理店扱形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsydrtencdx1 zrnbsydrtencdx1}</td><td>（連携用）募集代理店コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsydrtencdx2 zrnbsydrtencdx2}</td><td>（連携用）募集代理店コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnikkatubaraikbn zrnikkatubaraikbn}</td><td>（連携用）一括払区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnikkatubaraikaisuu zrnikkatubaraikaisuu}</td><td>（連携用）一括払回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv34 zrnyobiv34}</td><td>（連携用）予備項目Ｖ３４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_DrtenMinyuuKykInfoRn
 * @see     PKZT_DrtenMinyuuKykInfoRn
 * @see     QZT_DrtenMinyuuKykInfoRn
 * @see     GenQZT_DrtenMinyuuKykInfoRn
 */
@MappedSuperclass
@Table(name=GenZT_DrtenMinyuuKykInfoRn.TABLE_NAME)
@IdClass(value=PKZT_DrtenMinyuuKykInfoRn.class)
public abstract class GenZT_DrtenMinyuuKykInfoRn extends AbstractExDBEntityForZDB<ZT_DrtenMinyuuKykInfoRn, PKZT_DrtenMinyuuKykInfoRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DrtenMinyuuKykInfoRn";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNBSYYM                 = "zrnbsyym";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNHRKKEIROKBN           = "zrnhrkkeirokbn";
    public static final String ZRNSYUUKEIKBN            = "zrnsyuukeikbn";
    public static final String ZRNMINYUKAISUU           = "zrnminyukaisuu";
    public static final String ZRNMISYUUP               = "zrnmisyuup";
    public static final String ZRNHSYS                  = "zrnhsys";
    public static final String ZRNSYUUSEIS              = "zrnsyuuseis";
    public static final String ZRNFUKKATUTYUUIKBN       = "zrnfukkatutyuuikbn";
    public static final String ZRNMRARIHYJ              = "zrnmrarihyj";
    public static final String ZRNFSTTATEKAEKYKHYJ      = "zrnfsttatekaekykhyj";
    public static final String ZRNTATEKAEKJRENZOKUKAISU = "zrntatekaekjrenzokukaisu";
    public static final String ZRNKEIZOKUTYUUIHYOUJI    = "zrnkeizokutyuuihyouji";
    public static final String ZRNSYOUHINBUNRUIKBN      = "zrnsyouhinbunruikbn";
    public static final String ZRNSYOUHNNMKBN           = "zrnsyouhnnmkbn";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNJIKAIPJYUUTOUYM       = "zrnjikaipjyuutouym";
    public static final String ZRNKZHURIKAEHURIHUNOKBN  = "zrnkzhurikaehurihunokbn";
    public static final String ZRNAUTOCALLTAISYOUKYKHYJ = "zrnautocalltaisyoukykhyj";
    public static final String ZRNBSUDIRTNATKIKEITAIKBN = "zrnbsudirtnatkikeitaikbn";
    public static final String ZRNBSYDRTENCDX1          = "zrnbsydrtencdx1";
    public static final String ZRNBSYDRTENCDX2          = "zrnbsydrtencdx2";
    public static final String ZRNIKKATUBARAIKBN        = "zrnikkatubaraikbn";
    public static final String ZRNIKKATUBARAIKAISUU     = "zrnikkatubaraikaisuu";
    public static final String ZRNYOBIV34               = "zrnyobiv34";

    private final PKZT_DrtenMinyuuKykInfoRn primaryKey;

    public GenZT_DrtenMinyuuKykInfoRn() {
        primaryKey = new PKZT_DrtenMinyuuKykInfoRn();
    }

    public GenZT_DrtenMinyuuKykInfoRn(String pZrnsyono) {
        primaryKey = new PKZT_DrtenMinyuuKykInfoRn(pZrnsyono);
    }

    @Transient
    @Override
    public PKZT_DrtenMinyuuKykInfoRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DrtenMinyuuKykInfoRn> getMetaClass() {
        return QZT_DrtenMinyuuKykInfoRn.class;
    }

    @Id
    @Column(name=GenZT_DrtenMinyuuKykInfoRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnkykymd;

    @Column(name=GenZT_DrtenMinyuuKykInfoRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnbsyym;

    @Column(name=GenZT_DrtenMinyuuKykInfoRn.ZRNBSYYM)
    public String getZrnbsyym() {
        return zrnbsyym;
    }

    public void setZrnbsyym(String pZrnbsyym) {
        zrnbsyym = pZrnbsyym;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_DrtenMinyuuKykInfoRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private String zrnhrkkeirokbn;

    @Column(name=GenZT_DrtenMinyuuKykInfoRn.ZRNHRKKEIROKBN)
    public String getZrnhrkkeirokbn() {
        return zrnhrkkeirokbn;
    }

    public void setZrnhrkkeirokbn(String pZrnhrkkeirokbn) {
        zrnhrkkeirokbn = pZrnhrkkeirokbn;
    }

    private String zrnsyuukeikbn;

    @Column(name=GenZT_DrtenMinyuuKykInfoRn.ZRNSYUUKEIKBN)
    public String getZrnsyuukeikbn() {
        return zrnsyuukeikbn;
    }

    public void setZrnsyuukeikbn(String pZrnsyuukeikbn) {
        zrnsyuukeikbn = pZrnsyuukeikbn;
    }

    private String zrnminyukaisuu;

    @Column(name=GenZT_DrtenMinyuuKykInfoRn.ZRNMINYUKAISUU)
    public String getZrnminyukaisuu() {
        return zrnminyukaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnminyukaisuu(String pZrnminyukaisuu) {
        zrnminyukaisuu = pZrnminyukaisuu;
    }

    private Long zrnmisyuup;

    @Column(name=GenZT_DrtenMinyuuKykInfoRn.ZRNMISYUUP)
    public Long getZrnmisyuup() {
        return zrnmisyuup;
    }

    public void setZrnmisyuup(Long pZrnmisyuup) {
        zrnmisyuup = pZrnmisyuup;
    }

    private Long zrnhsys;

    @Column(name=GenZT_DrtenMinyuuKykInfoRn.ZRNHSYS)
    public Long getZrnhsys() {
        return zrnhsys;
    }

    public void setZrnhsys(Long pZrnhsys) {
        zrnhsys = pZrnhsys;
    }

    private Long zrnsyuuseis;

    @Column(name=GenZT_DrtenMinyuuKykInfoRn.ZRNSYUUSEIS)
    public Long getZrnsyuuseis() {
        return zrnsyuuseis;
    }

    public void setZrnsyuuseis(Long pZrnsyuuseis) {
        zrnsyuuseis = pZrnsyuuseis;
    }

    private String zrnfukkatutyuuikbn;

    @Column(name=GenZT_DrtenMinyuuKykInfoRn.ZRNFUKKATUTYUUIKBN)
    public String getZrnfukkatutyuuikbn() {
        return zrnfukkatutyuuikbn;
    }

    public void setZrnfukkatutyuuikbn(String pZrnfukkatutyuuikbn) {
        zrnfukkatutyuuikbn = pZrnfukkatutyuuikbn;
    }

    private String zrnmrarihyj;

    @Column(name=GenZT_DrtenMinyuuKykInfoRn.ZRNMRARIHYJ)
    public String getZrnmrarihyj() {
        return zrnmrarihyj;
    }

    public void setZrnmrarihyj(String pZrnmrarihyj) {
        zrnmrarihyj = pZrnmrarihyj;
    }

    private String zrnfsttatekaekykhyj;

    @Column(name=GenZT_DrtenMinyuuKykInfoRn.ZRNFSTTATEKAEKYKHYJ)
    public String getZrnfsttatekaekykhyj() {
        return zrnfsttatekaekykhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnfsttatekaekykhyj(String pZrnfsttatekaekykhyj) {
        zrnfsttatekaekykhyj = pZrnfsttatekaekykhyj;
    }

    private String zrntatekaekjrenzokukaisu;

    @Column(name=GenZT_DrtenMinyuuKykInfoRn.ZRNTATEKAEKJRENZOKUKAISU)
    public String getZrntatekaekjrenzokukaisu() {
        return zrntatekaekjrenzokukaisu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntatekaekjrenzokukaisu(String pZrntatekaekjrenzokukaisu) {
        zrntatekaekjrenzokukaisu = pZrntatekaekjrenzokukaisu;
    }

    private String zrnkeizokutyuuihyouji;

    @Column(name=GenZT_DrtenMinyuuKykInfoRn.ZRNKEIZOKUTYUUIHYOUJI)
    public String getZrnkeizokutyuuihyouji() {
        return zrnkeizokutyuuihyouji;
    }

    public void setZrnkeizokutyuuihyouji(String pZrnkeizokutyuuihyouji) {
        zrnkeizokutyuuihyouji = pZrnkeizokutyuuihyouji;
    }

    private String zrnsyouhinbunruikbn;

    @Column(name=GenZT_DrtenMinyuuKykInfoRn.ZRNSYOUHINBUNRUIKBN)
    public String getZrnsyouhinbunruikbn() {
        return zrnsyouhinbunruikbn;
    }

    public void setZrnsyouhinbunruikbn(String pZrnsyouhinbunruikbn) {
        zrnsyouhinbunruikbn = pZrnsyouhinbunruikbn;
    }

    private String zrnsyouhnnmkbn;

    @Column(name=GenZT_DrtenMinyuuKykInfoRn.ZRNSYOUHNNMKBN)
    public String getZrnsyouhnnmkbn() {
        return zrnsyouhnnmkbn;
    }

    public void setZrnsyouhnnmkbn(String pZrnsyouhnnmkbn) {
        zrnsyouhnnmkbn = pZrnsyouhnnmkbn;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_DrtenMinyuuKykInfoRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnjikaipjyuutouym;

    @Column(name=GenZT_DrtenMinyuuKykInfoRn.ZRNJIKAIPJYUUTOUYM)
    public String getZrnjikaipjyuutouym() {
        return zrnjikaipjyuutouym;
    }

    public void setZrnjikaipjyuutouym(String pZrnjikaipjyuutouym) {
        zrnjikaipjyuutouym = pZrnjikaipjyuutouym;
    }

    private String zrnkzhurikaehurihunokbn;

    @Column(name=GenZT_DrtenMinyuuKykInfoRn.ZRNKZHURIKAEHURIHUNOKBN)
    public String getZrnkzhurikaehurihunokbn() {
        return zrnkzhurikaehurihunokbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzhurikaehurihunokbn(String pZrnkzhurikaehurihunokbn) {
        zrnkzhurikaehurihunokbn = pZrnkzhurikaehurihunokbn;
    }

    private String zrnautocalltaisyoukykhyj;

    @Column(name=GenZT_DrtenMinyuuKykInfoRn.ZRNAUTOCALLTAISYOUKYKHYJ)
    public String getZrnautocalltaisyoukykhyj() {
        return zrnautocalltaisyoukykhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnautocalltaisyoukykhyj(String pZrnautocalltaisyoukykhyj) {
        zrnautocalltaisyoukykhyj = pZrnautocalltaisyoukykhyj;
    }

    private String zrnbsudirtnatkikeitaikbn;

    @Column(name=GenZT_DrtenMinyuuKykInfoRn.ZRNBSUDIRTNATKIKEITAIKBN)
    public String getZrnbsudirtnatkikeitaikbn() {
        return zrnbsudirtnatkikeitaikbn;
    }

    public void setZrnbsudirtnatkikeitaikbn(String pZrnbsudirtnatkikeitaikbn) {
        zrnbsudirtnatkikeitaikbn = pZrnbsudirtnatkikeitaikbn;
    }

    private String zrnbsydrtencdx1;

    @Column(name=GenZT_DrtenMinyuuKykInfoRn.ZRNBSYDRTENCDX1)
    public String getZrnbsydrtencdx1() {
        return zrnbsydrtencdx1;
    }

    public void setZrnbsydrtencdx1(String pZrnbsydrtencdx1) {
        zrnbsydrtencdx1 = pZrnbsydrtencdx1;
    }

    private String zrnbsydrtencdx2;

    @Column(name=GenZT_DrtenMinyuuKykInfoRn.ZRNBSYDRTENCDX2)
    public String getZrnbsydrtencdx2() {
        return zrnbsydrtencdx2;
    }

    public void setZrnbsydrtencdx2(String pZrnbsydrtencdx2) {
        zrnbsydrtencdx2 = pZrnbsydrtencdx2;
    }

    private String zrnikkatubaraikbn;

    @Column(name=GenZT_DrtenMinyuuKykInfoRn.ZRNIKKATUBARAIKBN)
    public String getZrnikkatubaraikbn() {
        return zrnikkatubaraikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnikkatubaraikbn(String pZrnikkatubaraikbn) {
        zrnikkatubaraikbn = pZrnikkatubaraikbn;
    }

    private String zrnikkatubaraikaisuu;

    @Column(name=GenZT_DrtenMinyuuKykInfoRn.ZRNIKKATUBARAIKAISUU)
    public String getZrnikkatubaraikaisuu() {
        return zrnikkatubaraikaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnikkatubaraikaisuu(String pZrnikkatubaraikaisuu) {
        zrnikkatubaraikaisuu = pZrnikkatubaraikaisuu;
    }

    private String zrnyobiv34;

    @Column(name=GenZT_DrtenMinyuuKykInfoRn.ZRNYOBIV34)
    public String getZrnyobiv34() {
        return zrnyobiv34;
    }

    public void setZrnyobiv34(String pZrnyobiv34) {
        zrnyobiv34 = pZrnyobiv34;
    }
}