package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_BosyuuninRn;
import yuyu.def.db.id.PKZT_BosyuuninRn;
import yuyu.def.db.meta.GenQZT_BosyuuninRn;
import yuyu.def.db.meta.QZT_BosyuuninRn;

/**
 * 募集人ＰＲＴ用連動Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_BosyuuninRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_BosyuuninRn}</td><td colspan="3">募集人ＰＲＴ用連動Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnbosyuunincd zrnbosyuunincd}</td><td>（連携用）募集人コード</td><td align="center">{@link PKZT_BosyuuninRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuuninnm zrnbosyuuninnm}</td><td>（連携用）募集人名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanjibosyuuninnm zrnkanjibosyuuninnm}</td><td>（連携用）漢字募集人名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitakuymd zrnitakuymd}</td><td>（連携用）委託年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitencd1 zrndairitencd1}</td><td>（連携用）代理店コード（１）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitencd2 zrndairitencd2}</td><td>（連携用）代理店コード（２）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitencd3 zrndairitencd3}</td><td>（連携用）代理店コード（３）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitenkanrisskcd1 zrndairitenkanrisskcd1}</td><td>（連携用）代理店管理組織コード（１）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitenkanrisskcd2 zrndairitenkanrisskcd2}</td><td>（連携用）代理店管理組織コード（２）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitenkanrisskcd3 zrndairitenkanrisskcd3}</td><td>（連携用）代理店管理組織コード（３）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuukbn zrnbosyuukbn}</td><td>（連携用）募集人区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuunintourokuymd zrnbosyuunintourokuymd}</td><td>（連携用）募集人登録年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuuninkahikbn zrnbosyuuninkahikbn}</td><td>（連携用）募集可否区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuuningyouhaiymd zrnbosyuuningyouhaiymd}</td><td>（連携用）募集人業廃年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhengakutourokuymd zrnhengakutourokuymd}</td><td>（連携用）変額保険資格登録年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhengakumassyouymd zrnhengakumassyouymd}</td><td>（連携用）変額保険資格登録抹消年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuuseiymd zrnbosyuuseiymd}</td><td>（連携用）募集人生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitakukaiyakuymd zrnitakukaiyakuymd}</td><td>（連携用）委託解約日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndaihyoubosyuunincd zrndaihyoubosyuunincd}</td><td>（連携用）代表募集人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuutourokuno zrnbosyuutourokuno}</td><td>（連携用）募集人登録番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv5 zrnyobiv5}</td><td>（連携用）予備項目Ｖ５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_BosyuuninRn
 * @see     PKZT_BosyuuninRn
 * @see     QZT_BosyuuninRn
 * @see     GenQZT_BosyuuninRn
 */
@MappedSuperclass
@Table(name=GenZT_BosyuuninRn.TABLE_NAME)
@IdClass(value=PKZT_BosyuuninRn.class)
public abstract class GenZT_BosyuuninRn extends AbstractExDBEntityForZDB<ZT_BosyuuninRn, PKZT_BosyuuninRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_BosyuuninRn";
    public static final String ZRNBOSYUUNINCD           = "zrnbosyuunincd";
    public static final String ZRNBOSYUUNINNM           = "zrnbosyuuninnm";
    public static final String ZRNKANJIBOSYUUNINNM      = "zrnkanjibosyuuninnm";
    public static final String ZRNITAKUYMD              = "zrnitakuymd";
    public static final String ZRNDAIRITENCD1           = "zrndairitencd1";
    public static final String ZRNDAIRITENCD2           = "zrndairitencd2";
    public static final String ZRNDAIRITENCD3           = "zrndairitencd3";
    public static final String ZRNDAIRITENKANRISSKCD1   = "zrndairitenkanrisskcd1";
    public static final String ZRNDAIRITENKANRISSKCD2   = "zrndairitenkanrisskcd2";
    public static final String ZRNDAIRITENKANRISSKCD3   = "zrndairitenkanrisskcd3";
    public static final String ZRNBOSYUUKBN             = "zrnbosyuukbn";
    public static final String ZRNBOSYUUNINTOUROKUYMD   = "zrnbosyuunintourokuymd";
    public static final String ZRNBOSYUUNINKAHIKBN      = "zrnbosyuuninkahikbn";
    public static final String ZRNBOSYUUNINGYOUHAIYMD   = "zrnbosyuuningyouhaiymd";
    public static final String ZRNHENGAKUTOUROKUYMD     = "zrnhengakutourokuymd";
    public static final String ZRNHENGAKUMASSYOUYMD     = "zrnhengakumassyouymd";
    public static final String ZRNBOSYUUSEIYMD          = "zrnbosyuuseiymd";
    public static final String ZRNITAKUKAIYAKUYMD       = "zrnitakukaiyakuymd";
    public static final String ZRNDAIHYOUBOSYUUNINCD    = "zrndaihyoubosyuunincd";
    public static final String ZRNBOSYUUTOUROKUNO       = "zrnbosyuutourokuno";
    public static final String ZRNYOBIV5                = "zrnyobiv5";

    private final PKZT_BosyuuninRn primaryKey;

    public GenZT_BosyuuninRn() {
        primaryKey = new PKZT_BosyuuninRn();
    }

    public GenZT_BosyuuninRn(String pZrnbosyuunincd) {
        primaryKey = new PKZT_BosyuuninRn(pZrnbosyuunincd);
    }

    @Transient
    @Override
    public PKZT_BosyuuninRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_BosyuuninRn> getMetaClass() {
        return QZT_BosyuuninRn.class;
    }

    @Id
    @Column(name=GenZT_BosyuuninRn.ZRNBOSYUUNINCD)
    public String getZrnbosyuunincd() {
        return getPrimaryKey().getZrnbosyuunincd();
    }

    public void setZrnbosyuunincd(String pZrnbosyuunincd) {
        getPrimaryKey().setZrnbosyuunincd(pZrnbosyuunincd);
    }

    private String zrnbosyuuninnm;

    @Column(name=GenZT_BosyuuninRn.ZRNBOSYUUNINNM)
    public String getZrnbosyuuninnm() {
        return zrnbosyuuninnm;
    }

    public void setZrnbosyuuninnm(String pZrnbosyuuninnm) {
        zrnbosyuuninnm = pZrnbosyuuninnm;
    }

    private String zrnkanjibosyuuninnm;

    @Column(name=GenZT_BosyuuninRn.ZRNKANJIBOSYUUNINNM)
    public String getZrnkanjibosyuuninnm() {
        return zrnkanjibosyuuninnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkanjibosyuuninnm(String pZrnkanjibosyuuninnm) {
        zrnkanjibosyuuninnm = pZrnkanjibosyuuninnm;
    }

    private String zrnitakuymd;

    @Column(name=GenZT_BosyuuninRn.ZRNITAKUYMD)
    public String getZrnitakuymd() {
        return zrnitakuymd;
    }

    public void setZrnitakuymd(String pZrnitakuymd) {
        zrnitakuymd = pZrnitakuymd;
    }

    private String zrndairitencd1;

    @Column(name=GenZT_BosyuuninRn.ZRNDAIRITENCD1)
    public String getZrndairitencd1() {
        return zrndairitencd1;
    }

    public void setZrndairitencd1(String pZrndairitencd1) {
        zrndairitencd1 = pZrndairitencd1;
    }

    private String zrndairitencd2;

    @Column(name=GenZT_BosyuuninRn.ZRNDAIRITENCD2)
    public String getZrndairitencd2() {
        return zrndairitencd2;
    }

    public void setZrndairitencd2(String pZrndairitencd2) {
        zrndairitencd2 = pZrndairitencd2;
    }

    private String zrndairitencd3;

    @Column(name=GenZT_BosyuuninRn.ZRNDAIRITENCD3)
    public String getZrndairitencd3() {
        return zrndairitencd3;
    }

    public void setZrndairitencd3(String pZrndairitencd3) {
        zrndairitencd3 = pZrndairitencd3;
    }

    private String zrndairitenkanrisskcd1;

    @Column(name=GenZT_BosyuuninRn.ZRNDAIRITENKANRISSKCD1)
    public String getZrndairitenkanrisskcd1() {
        return zrndairitenkanrisskcd1;
    }

    public void setZrndairitenkanrisskcd1(String pZrndairitenkanrisskcd1) {
        zrndairitenkanrisskcd1 = pZrndairitenkanrisskcd1;
    }

    private String zrndairitenkanrisskcd2;

    @Column(name=GenZT_BosyuuninRn.ZRNDAIRITENKANRISSKCD2)
    public String getZrndairitenkanrisskcd2() {
        return zrndairitenkanrisskcd2;
    }

    public void setZrndairitenkanrisskcd2(String pZrndairitenkanrisskcd2) {
        zrndairitenkanrisskcd2 = pZrndairitenkanrisskcd2;
    }

    private String zrndairitenkanrisskcd3;

    @Column(name=GenZT_BosyuuninRn.ZRNDAIRITENKANRISSKCD3)
    public String getZrndairitenkanrisskcd3() {
        return zrndairitenkanrisskcd3;
    }

    public void setZrndairitenkanrisskcd3(String pZrndairitenkanrisskcd3) {
        zrndairitenkanrisskcd3 = pZrndairitenkanrisskcd3;
    }

    private String zrnbosyuukbn;

    @Column(name=GenZT_BosyuuninRn.ZRNBOSYUUKBN)
    public String getZrnbosyuukbn() {
        return zrnbosyuukbn;
    }

    public void setZrnbosyuukbn(String pZrnbosyuukbn) {
        zrnbosyuukbn = pZrnbosyuukbn;
    }

    private String zrnbosyuunintourokuymd;

    @Column(name=GenZT_BosyuuninRn.ZRNBOSYUUNINTOUROKUYMD)
    public String getZrnbosyuunintourokuymd() {
        return zrnbosyuunintourokuymd;
    }

    public void setZrnbosyuunintourokuymd(String pZrnbosyuunintourokuymd) {
        zrnbosyuunintourokuymd = pZrnbosyuunintourokuymd;
    }

    private String zrnbosyuuninkahikbn;

    @Column(name=GenZT_BosyuuninRn.ZRNBOSYUUNINKAHIKBN)
    public String getZrnbosyuuninkahikbn() {
        return zrnbosyuuninkahikbn;
    }

    public void setZrnbosyuuninkahikbn(String pZrnbosyuuninkahikbn) {
        zrnbosyuuninkahikbn = pZrnbosyuuninkahikbn;
    }

    private String zrnbosyuuningyouhaiymd;

    @Column(name=GenZT_BosyuuninRn.ZRNBOSYUUNINGYOUHAIYMD)
    public String getZrnbosyuuningyouhaiymd() {
        return zrnbosyuuningyouhaiymd;
    }

    public void setZrnbosyuuningyouhaiymd(String pZrnbosyuuningyouhaiymd) {
        zrnbosyuuningyouhaiymd = pZrnbosyuuningyouhaiymd;
    }

    private String zrnhengakutourokuymd;

    @Column(name=GenZT_BosyuuninRn.ZRNHENGAKUTOUROKUYMD)
    public String getZrnhengakutourokuymd() {
        return zrnhengakutourokuymd;
    }

    public void setZrnhengakutourokuymd(String pZrnhengakutourokuymd) {
        zrnhengakutourokuymd = pZrnhengakutourokuymd;
    }

    private String zrnhengakumassyouymd;

    @Column(name=GenZT_BosyuuninRn.ZRNHENGAKUMASSYOUYMD)
    public String getZrnhengakumassyouymd() {
        return zrnhengakumassyouymd;
    }

    public void setZrnhengakumassyouymd(String pZrnhengakumassyouymd) {
        zrnhengakumassyouymd = pZrnhengakumassyouymd;
    }

    private String zrnbosyuuseiymd;

    @Column(name=GenZT_BosyuuninRn.ZRNBOSYUUSEIYMD)
    public String getZrnbosyuuseiymd() {
        return zrnbosyuuseiymd;
    }

    public void setZrnbosyuuseiymd(String pZrnbosyuuseiymd) {
        zrnbosyuuseiymd = pZrnbosyuuseiymd;
    }

    private String zrnitakukaiyakuymd;

    @Column(name=GenZT_BosyuuninRn.ZRNITAKUKAIYAKUYMD)
    public String getZrnitakukaiyakuymd() {
        return zrnitakukaiyakuymd;
    }

    public void setZrnitakukaiyakuymd(String pZrnitakukaiyakuymd) {
        zrnitakukaiyakuymd = pZrnitakukaiyakuymd;
    }

    private String zrndaihyoubosyuunincd;

    @Column(name=GenZT_BosyuuninRn.ZRNDAIHYOUBOSYUUNINCD)
    public String getZrndaihyoubosyuunincd() {
        return zrndaihyoubosyuunincd;
    }

    public void setZrndaihyoubosyuunincd(String pZrndaihyoubosyuunincd) {
        zrndaihyoubosyuunincd = pZrndaihyoubosyuunincd;
    }

    private String zrnbosyuutourokuno;

    @Column(name=GenZT_BosyuuninRn.ZRNBOSYUUTOUROKUNO)
    public String getZrnbosyuutourokuno() {
        return zrnbosyuutourokuno;
    }

    public void setZrnbosyuutourokuno(String pZrnbosyuutourokuno) {
        zrnbosyuutourokuno = pZrnbosyuutourokuno;
    }

    private String zrnyobiv5;

    @Column(name=GenZT_BosyuuninRn.ZRNYOBIV5)
    public String getZrnyobiv5() {
        return zrnyobiv5;
    }

    public void setZrnyobiv5(String pZrnyobiv5) {
        zrnyobiv5 = pZrnyobiv5;
    }
}