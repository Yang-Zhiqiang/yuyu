package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_HknkykIdouInfoRn;
import yuyu.def.db.id.PKZT_HknkykIdouInfoRn;
import yuyu.def.db.meta.GenQZT_HknkykIdouInfoRn;
import yuyu.def.db.meta.QZT_HknkykIdouInfoRn;

/**
 * 保険契約異動情報テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_HknkykIdouInfoRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_HknkykIdouInfoRn}</td><td colspan="3">保険契約異動情報テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnkyktuukasyu zrnkyktuukasyu}</td><td>（連携用）契約通貨種類</td><td align="center">{@link PKZT_HknkykIdouInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnidouymd zrnidouymd}</td><td>（連携用）異動日</td><td align="center">{@link PKZT_HknkykIdouInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnidoujiyuukbnzfi zrnidoujiyuukbnzfi}</td><td>（連携用）異動事由区分（資産運用）</td><td align="center">{@link PKZT_HknkykIdouInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakanrino zrndatakanrino}</td><td>（連携用）データ管理番号</td><td align="center">{@link PKZT_HknkykIdouInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrenno zrnrenno}</td><td>（連携用）連番</td><td align="center">{@link PKZT_HknkykIdouInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakuymd zrnkeiyakuymd}</td><td>（連携用）契約日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnen2 zrnhhknnen2}</td><td>（連携用）被保険者年齢Ｃ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknsei zrnhhknsei}</td><td>（連携用）被保険者性別</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaisyoumeikbn zrnaisyoumeikbn}</td><td>（連携用）愛称名区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzougenkbn zrnzougenkbn}</td><td>（連携用）増減区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokenkngk13 zrnhokenkngk13}</td><td>（連携用）保険金額Ｎ１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnp13 zrnp13}</td><td>（連携用）保険料Ｎ１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnptumitatekin13 zrnptumitatekin13}</td><td>（連携用）保険料積立金Ｎ１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkiykhnrikn13 zrnkiykhnrikn13}</td><td>（連携用）解約返戻金Ｎ１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnidouhokenkngk zrnidouhokenkngk}</td><td>（連携用）異動保険金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnidoup zrnidoup}</td><td>（連携用）異動保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnidouptumitatekin zrnidouptumitatekin}</td><td>（連携用）異動保険料積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnidoukiykhnrikn zrnidoukiykhnrikn}</td><td>（連携用）異動解約返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnhknkkn zrnhknkkn}</td><td>（連携用）保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritun5 zrnyoteiriritun5}</td><td>（連携用）予定利率Ｎ５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntumitatekinkbn zrntumitatekinkbn}</td><td>（連携用）積立金区分</td><td align="center">{@link PKZT_HknkykIdouInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnharaikatakbnkykidou zrnharaikatakbnkykidou}</td><td>（連携用）払方区分（保険契約異動情報）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_HknkykIdouInfoRn
 * @see     PKZT_HknkykIdouInfoRn
 * @see     QZT_HknkykIdouInfoRn
 * @see     GenQZT_HknkykIdouInfoRn
 */
@MappedSuperclass
@Table(name=GenZT_HknkykIdouInfoRn.TABLE_NAME)
@IdClass(value=PKZT_HknkykIdouInfoRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_HknkykIdouInfoRn extends AbstractExDBEntityForZDB<ZT_HknkykIdouInfoRn, PKZT_HknkykIdouInfoRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_HknkykIdouInfoRn";
    public static final String ZRNKYKTUUKASYU           = "zrnkyktuukasyu";
    public static final String ZRNIDOUYMD               = "zrnidouymd";
    public static final String ZRNIDOUJIYUUKBNZFI       = "zrnidoujiyuukbnzfi";
    public static final String ZRNDATAKANRINO           = "zrndatakanrino";
    public static final String ZRNRENNO                 = "zrnrenno";
    public static final String ZRNKEIYAKUYMD            = "zrnkeiyakuymd";
    public static final String ZRNHHKNNEN2              = "zrnhhknnen2";
    public static final String ZRNHHKNSEI               = "zrnhhknsei";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNAISYOUMEIKBN          = "zrnaisyoumeikbn";
    public static final String ZRNZOUGENKBN             = "zrnzougenkbn";
    public static final String ZRNHOKENKNGK13           = "zrnhokenkngk13";
    public static final String ZRNP13                   = "zrnp13";
    public static final String ZRNPTUMITATEKIN13        = "zrnptumitatekin13";
    public static final String ZRNKIYKHNRIKN13          = "zrnkiykhnrikn13";
    public static final String ZRNIDOUHOKENKNGK         = "zrnidouhokenkngk";
    public static final String ZRNIDOUP                 = "zrnidoup";
    public static final String ZRNIDOUPTUMITATEKIN      = "zrnidouptumitatekin";
    public static final String ZRNIDOUKIYKHNRIKN        = "zrnidoukiykhnrikn";
    public static final String ZRNHKNKKN                = "zrnhknkkn";
    public static final String ZRNYOTEIRIRITUN5         = "zrnyoteiriritun5";
    public static final String ZRNTUMITATEKINKBN        = "zrntumitatekinkbn";
    public static final String ZRNHARAIKATAKBNKYKIDOU   = "zrnharaikatakbnkykidou";

    private final PKZT_HknkykIdouInfoRn primaryKey;

    public GenZT_HknkykIdouInfoRn() {
        primaryKey = new PKZT_HknkykIdouInfoRn();
    }

    public GenZT_HknkykIdouInfoRn(
        String pZrnkyktuukasyu,
        String pZrnidouymd,
        String pZrnidoujiyuukbnzfi,
        String pZrndatakanrino,
        String pZrnrenno,
        String pZrntumitatekinkbn
    ) {
        primaryKey = new PKZT_HknkykIdouInfoRn(
            pZrnkyktuukasyu,
            pZrnidouymd,
            pZrnidoujiyuukbnzfi,
            pZrndatakanrino,
            pZrnrenno,
            pZrntumitatekinkbn
        );
    }

    @Transient
    @Override
    public PKZT_HknkykIdouInfoRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_HknkykIdouInfoRn> getMetaClass() {
        return QZT_HknkykIdouInfoRn.class;
    }

    @Id
    @Column(name=GenZT_HknkykIdouInfoRn.ZRNKYKTUUKASYU)
    public String getZrnkyktuukasyu() {
        return getPrimaryKey().getZrnkyktuukasyu();
    }

    public void setZrnkyktuukasyu(String pZrnkyktuukasyu) {
        getPrimaryKey().setZrnkyktuukasyu(pZrnkyktuukasyu);
    }

    @Id
    @Column(name=GenZT_HknkykIdouInfoRn.ZRNIDOUYMD)
    public String getZrnidouymd() {
        return getPrimaryKey().getZrnidouymd();
    }

    public void setZrnidouymd(String pZrnidouymd) {
        getPrimaryKey().setZrnidouymd(pZrnidouymd);
    }

    @Id
    @Column(name=GenZT_HknkykIdouInfoRn.ZRNIDOUJIYUUKBNZFI)
    public String getZrnidoujiyuukbnzfi() {
        return getPrimaryKey().getZrnidoujiyuukbnzfi();
    }

    public void setZrnidoujiyuukbnzfi(String pZrnidoujiyuukbnzfi) {
        getPrimaryKey().setZrnidoujiyuukbnzfi(pZrnidoujiyuukbnzfi);
    }

    @Id
    @Column(name=GenZT_HknkykIdouInfoRn.ZRNDATAKANRINO)
    public String getZrndatakanrino() {
        return getPrimaryKey().getZrndatakanrino();
    }

    public void setZrndatakanrino(String pZrndatakanrino) {
        getPrimaryKey().setZrndatakanrino(pZrndatakanrino);
    }

    @Id
    @Column(name=GenZT_HknkykIdouInfoRn.ZRNRENNO)
    public String getZrnrenno() {
        return getPrimaryKey().getZrnrenno();
    }

    public void setZrnrenno(String pZrnrenno) {
        getPrimaryKey().setZrnrenno(pZrnrenno);
    }

    private String zrnkeiyakuymd;

    @Column(name=GenZT_HknkykIdouInfoRn.ZRNKEIYAKUYMD)
    public String getZrnkeiyakuymd() {
        return zrnkeiyakuymd;
    }

    public void setZrnkeiyakuymd(String pZrnkeiyakuymd) {
        zrnkeiyakuymd = pZrnkeiyakuymd;
    }

    private String zrnhhknnen2;

    @Column(name=GenZT_HknkykIdouInfoRn.ZRNHHKNNEN2)
    public String getZrnhhknnen2() {
        return zrnhhknnen2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhhknnen2(String pZrnhhknnen2) {
        zrnhhknnen2 = pZrnhhknnen2;
    }

    private String zrnhhknsei;

    @Column(name=GenZT_HknkykIdouInfoRn.ZRNHHKNSEI)
    public String getZrnhhknsei() {
        return zrnhhknsei;
    }

    public void setZrnhhknsei(String pZrnhhknsei) {
        zrnhhknsei = pZrnhhknsei;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_HknkykIdouInfoRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnaisyoumeikbn;

    @Column(name=GenZT_HknkykIdouInfoRn.ZRNAISYOUMEIKBN)
    public String getZrnaisyoumeikbn() {
        return zrnaisyoumeikbn;
    }

    public void setZrnaisyoumeikbn(String pZrnaisyoumeikbn) {
        zrnaisyoumeikbn = pZrnaisyoumeikbn;
    }

    private String zrnzougenkbn;

    @Column(name=GenZT_HknkykIdouInfoRn.ZRNZOUGENKBN)
    public String getZrnzougenkbn() {
        return zrnzougenkbn;
    }

    public void setZrnzougenkbn(String pZrnzougenkbn) {
        zrnzougenkbn = pZrnzougenkbn;
    }

    private BizNumber zrnhokenkngk13;

    @Type(type="BizNumberType")
    @Column(name=GenZT_HknkykIdouInfoRn.ZRNHOKENKNGK13)
    public BizNumber getZrnhokenkngk13() {
        return zrnhokenkngk13;
    }

    public void setZrnhokenkngk13(BizNumber pZrnhokenkngk13) {
        zrnhokenkngk13 = pZrnhokenkngk13;
    }

    private BizNumber zrnp13;

    @Type(type="BizNumberType")
    @Column(name=GenZT_HknkykIdouInfoRn.ZRNP13)
    public BizNumber getZrnp13() {
        return zrnp13;
    }

    public void setZrnp13(BizNumber pZrnp13) {
        zrnp13 = pZrnp13;
    }

    private BizNumber zrnptumitatekin13;

    @Type(type="BizNumberType")
    @Column(name=GenZT_HknkykIdouInfoRn.ZRNPTUMITATEKIN13)
    public BizNumber getZrnptumitatekin13() {
        return zrnptumitatekin13;
    }

    public void setZrnptumitatekin13(BizNumber pZrnptumitatekin13) {
        zrnptumitatekin13 = pZrnptumitatekin13;
    }

    private BizNumber zrnkiykhnrikn13;

    @Type(type="BizNumberType")
    @Column(name=GenZT_HknkykIdouInfoRn.ZRNKIYKHNRIKN13)
    public BizNumber getZrnkiykhnrikn13() {
        return zrnkiykhnrikn13;
    }

    public void setZrnkiykhnrikn13(BizNumber pZrnkiykhnrikn13) {
        zrnkiykhnrikn13 = pZrnkiykhnrikn13;
    }

    private BizNumber zrnidouhokenkngk;

    @Type(type="BizNumberType")
    @Column(name=GenZT_HknkykIdouInfoRn.ZRNIDOUHOKENKNGK)
    public BizNumber getZrnidouhokenkngk() {
        return zrnidouhokenkngk;
    }

    public void setZrnidouhokenkngk(BizNumber pZrnidouhokenkngk) {
        zrnidouhokenkngk = pZrnidouhokenkngk;
    }

    private BizNumber zrnidoup;

    @Type(type="BizNumberType")
    @Column(name=GenZT_HknkykIdouInfoRn.ZRNIDOUP)
    public BizNumber getZrnidoup() {
        return zrnidoup;
    }

    public void setZrnidoup(BizNumber pZrnidoup) {
        zrnidoup = pZrnidoup;
    }

    private BizNumber zrnidouptumitatekin;

    @Type(type="BizNumberType")
    @Column(name=GenZT_HknkykIdouInfoRn.ZRNIDOUPTUMITATEKIN)
    public BizNumber getZrnidouptumitatekin() {
        return zrnidouptumitatekin;
    }

    public void setZrnidouptumitatekin(BizNumber pZrnidouptumitatekin) {
        zrnidouptumitatekin = pZrnidouptumitatekin;
    }

    private BizNumber zrnidoukiykhnrikn;

    @Type(type="BizNumberType")
    @Column(name=GenZT_HknkykIdouInfoRn.ZRNIDOUKIYKHNRIKN)
    public BizNumber getZrnidoukiykhnrikn() {
        return zrnidoukiykhnrikn;
    }

    public void setZrnidoukiykhnrikn(BizNumber pZrnidoukiykhnrikn) {
        zrnidoukiykhnrikn = pZrnidoukiykhnrikn;
    }

    private String zrnhknkkn;

    @Column(name=GenZT_HknkykIdouInfoRn.ZRNHKNKKN)
    public String getZrnhknkkn() {
        return zrnhknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhknkkn(String pZrnhknkkn) {
        zrnhknkkn = pZrnhknkkn;
    }

    private BizNumber zrnyoteiriritun5;

    @Type(type="BizNumberType")
    @Column(name=GenZT_HknkykIdouInfoRn.ZRNYOTEIRIRITUN5)
    public BizNumber getZrnyoteiriritun5() {
        return zrnyoteiriritun5;
    }

    public void setZrnyoteiriritun5(BizNumber pZrnyoteiriritun5) {
        zrnyoteiriritun5 = pZrnyoteiriritun5;
    }

    @Id
    @Column(name=GenZT_HknkykIdouInfoRn.ZRNTUMITATEKINKBN)
    public String getZrntumitatekinkbn() {
        return getPrimaryKey().getZrntumitatekinkbn();
    }

    public void setZrntumitatekinkbn(String pZrntumitatekinkbn) {
        getPrimaryKey().setZrntumitatekinkbn(pZrntumitatekinkbn);
    }

    private String zrnharaikatakbnkykidou;

    @Column(name=GenZT_HknkykIdouInfoRn.ZRNHARAIKATAKBNKYKIDOU)
    public String getZrnharaikatakbnkykidou() {
        return zrnharaikatakbnkykidou;
    }

    public void setZrnharaikatakbnkykidou(String pZrnharaikatakbnkykidou) {
        zrnharaikatakbnkykidou = pZrnharaikatakbnkykidou;
    }
}