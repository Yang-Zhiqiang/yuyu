package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_Ratep2Rn;
import yuyu.def.db.id.PKZT_Ratep2Rn;
import yuyu.def.db.meta.GenQZT_Ratep2Rn;
import yuyu.def.db.meta.QZT_Ratep2Rn;

/**
 * Ｐレートテーブル２（連） テーブルのマッピング情報クラスで、 {@link ZT_Ratep2Rn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_Ratep2Rn}</td><td colspan="3">Ｐレートテーブル２（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">{@link PKZT_Ratep2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruikigousedaikbn zrnhknsyuruikigousedaikbn}</td><td>（連携用）保険種類記号世代区分</td><td align="center">{@link PKZT_Ratep2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritu zrnyoteiriritu}</td><td>（連携用）予定利率</td><td align="center">{@link PKZT_Ratep2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmenkbn zrnpmenkbn}</td><td>（連携用）Ｐ免区分</td><td align="center">{@link PKZT_Ratep2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">{@link PKZT_Ratep2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknsei zrnhhknsei}</td><td>（連携用）被保険者性別</td><td align="center">{@link PKZT_Ratep2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakujihhknnen zrnkeiyakujihhknnen}</td><td>（連携用）契約時被保険者年令</td><td align="center">{@link PKZT_Ratep2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaimnkkykhyj zrnsaimnkkykhyj}</td><td>（連携用）才満期契約表示</td><td align="center">{@link PKZT_Ratep2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknkkn zrnhknkkn}</td><td>（連携用）保険期間</td><td align="center">{@link PKZT_Ratep2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkkikn zrnphrkkikn}</td><td>（連携用）Ｐ払込期間</td><td align="center">{@link PKZT_Ratep2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaifuyouriyuukbn zrnannaifuyouriyuukbn}</td><td>（連携用）案内不要理由区分</td><td align="center">{@link PKZT_Ratep2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuukasyukbn zrntuukasyukbn}</td><td>（連携用）通貨種類区分</td><td align="center">{@link PKZT_Ratep2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1hknkkn zrndai1hknkkn}</td><td>（連携用）第１保険期間</td><td align="center">{@link PKZT_Ratep2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnryouritukbn zrnryouritukbn}</td><td>（連携用）料率区分</td><td align="center">{@link PKZT_Ratep2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnprate zrnprate}</td><td>（連携用）Ｐレート</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnpdatesrate zrnpdatesrate}</td><td>（連携用）Ｐ建Ｓレート</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 * </table>
 * @see     ZT_Ratep2Rn
 * @see     PKZT_Ratep2Rn
 * @see     QZT_Ratep2Rn
 * @see     GenQZT_Ratep2Rn
 */
@MappedSuperclass
@Table(name=GenZT_Ratep2Rn.TABLE_NAME)
@IdClass(value=PKZT_Ratep2Rn.class)
public abstract class GenZT_Ratep2Rn extends AbstractExDBEntityForZDB<ZT_Ratep2Rn, PKZT_Ratep2Rn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_Ratep2Rn";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNHKNSYURUIKIGOUSEDAIKBN = "zrnhknsyuruikigousedaikbn";
    public static final String ZRNYOTEIRIRITU           = "zrnyoteiriritu";
    public static final String ZRNPMENKBN               = "zrnpmenkbn";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNHHKNSEI               = "zrnhhknsei";
    public static final String ZRNKEIYAKUJIHHKNNEN      = "zrnkeiyakujihhknnen";
    public static final String ZRNSAIMNKKYKHYJ          = "zrnsaimnkkykhyj";
    public static final String ZRNHKNKKN                = "zrnhknkkn";
    public static final String ZRNPHRKKIKN              = "zrnphrkkikn";
    public static final String ZRNANNAIFUYOURIYUUKBN    = "zrnannaifuyouriyuukbn";
    public static final String ZRNTUUKASYUKBN           = "zrntuukasyukbn";
    public static final String ZRNDAI1HKNKKN            = "zrndai1hknkkn";
    public static final String ZRNRYOURITUKBN           = "zrnryouritukbn";
    public static final String ZRNPRATE                 = "zrnprate";
    public static final String ZRNPDATESRATE            = "zrnpdatesrate";

    private final PKZT_Ratep2Rn primaryKey;

    public GenZT_Ratep2Rn() {
        primaryKey = new PKZT_Ratep2Rn();
    }

    public GenZT_Ratep2Rn(
        String pZrnhknsyukigou,
        String pZrnhknsyuruikigousedaikbn,
        String pZrnyoteiriritu,
        String pZrnpmenkbn,
        String pZrnhrkkaisuukbn,
        String pZrnhhknsei,
        String pZrnkeiyakujihhknnen,
        String pZrnsaimnkkykhyj,
        String pZrnhknkkn,
        String pZrnphrkkikn,
        String pZrnannaifuyouriyuukbn,
        String pZrntuukasyukbn,
        String pZrndai1hknkkn,
        String pZrnryouritukbn
    ) {
        primaryKey = new PKZT_Ratep2Rn(
            pZrnhknsyukigou,
            pZrnhknsyuruikigousedaikbn,
            pZrnyoteiriritu,
            pZrnpmenkbn,
            pZrnhrkkaisuukbn,
            pZrnhhknsei,
            pZrnkeiyakujihhknnen,
            pZrnsaimnkkykhyj,
            pZrnhknkkn,
            pZrnphrkkikn,
            pZrnannaifuyouriyuukbn,
            pZrntuukasyukbn,
            pZrndai1hknkkn,
            pZrnryouritukbn
        );
    }

    @Transient
    @Override
    public PKZT_Ratep2Rn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_Ratep2Rn> getMetaClass() {
        return QZT_Ratep2Rn.class;
    }

    @Id
    @Column(name=GenZT_Ratep2Rn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return getPrimaryKey().getZrnhknsyukigou();
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        getPrimaryKey().setZrnhknsyukigou(pZrnhknsyukigou);
    }

    @Id
    @Column(name=GenZT_Ratep2Rn.ZRNHKNSYURUIKIGOUSEDAIKBN)
    public String getZrnhknsyuruikigousedaikbn() {
        return getPrimaryKey().getZrnhknsyuruikigousedaikbn();
    }

    public void setZrnhknsyuruikigousedaikbn(String pZrnhknsyuruikigousedaikbn) {
        getPrimaryKey().setZrnhknsyuruikigousedaikbn(pZrnhknsyuruikigousedaikbn);
    }

    @Id
    @Column(name=GenZT_Ratep2Rn.ZRNYOTEIRIRITU)
    public String getZrnyoteiriritu() {
        return getPrimaryKey().getZrnyoteiriritu();
    }

    public void setZrnyoteiriritu(String pZrnyoteiriritu) {
        getPrimaryKey().setZrnyoteiriritu(pZrnyoteiriritu);
    }

    @Id
    @Column(name=GenZT_Ratep2Rn.ZRNPMENKBN)
    public String getZrnpmenkbn() {
        return getPrimaryKey().getZrnpmenkbn();
    }

    public void setZrnpmenkbn(String pZrnpmenkbn) {
        getPrimaryKey().setZrnpmenkbn(pZrnpmenkbn);
    }

    @Id
    @Column(name=GenZT_Ratep2Rn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return getPrimaryKey().getZrnhrkkaisuukbn();
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        getPrimaryKey().setZrnhrkkaisuukbn(pZrnhrkkaisuukbn);
    }

    @Id
    @Column(name=GenZT_Ratep2Rn.ZRNHHKNSEI)
    public String getZrnhhknsei() {
        return getPrimaryKey().getZrnhhknsei();
    }

    public void setZrnhhknsei(String pZrnhhknsei) {
        getPrimaryKey().setZrnhhknsei(pZrnhhknsei);
    }

    @Id
    @Column(name=GenZT_Ratep2Rn.ZRNKEIYAKUJIHHKNNEN)
    public String getZrnkeiyakujihhknnen() {
        return getPrimaryKey().getZrnkeiyakujihhknnen();
    }

    public void setZrnkeiyakujihhknnen(String pZrnkeiyakujihhknnen) {
        getPrimaryKey().setZrnkeiyakujihhknnen(pZrnkeiyakujihhknnen);
    }

    @Id
    @Column(name=GenZT_Ratep2Rn.ZRNSAIMNKKYKHYJ)
    public String getZrnsaimnkkykhyj() {
        return getPrimaryKey().getZrnsaimnkkykhyj();
    }

    public void setZrnsaimnkkykhyj(String pZrnsaimnkkykhyj) {
        getPrimaryKey().setZrnsaimnkkykhyj(pZrnsaimnkkykhyj);
    }

    @Id
    @Column(name=GenZT_Ratep2Rn.ZRNHKNKKN)
    public String getZrnhknkkn() {
        return getPrimaryKey().getZrnhknkkn();
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhknkkn(String pZrnhknkkn) {
        getPrimaryKey().setZrnhknkkn(pZrnhknkkn);
    }

    @Id
    @Column(name=GenZT_Ratep2Rn.ZRNPHRKKIKN)
    public String getZrnphrkkikn() {
        return getPrimaryKey().getZrnphrkkikn();
    }

    public void setZrnphrkkikn(String pZrnphrkkikn) {
        getPrimaryKey().setZrnphrkkikn(pZrnphrkkikn);
    }

    @Id
    @Column(name=GenZT_Ratep2Rn.ZRNANNAIFUYOURIYUUKBN)
    public String getZrnannaifuyouriyuukbn() {
        return getPrimaryKey().getZrnannaifuyouriyuukbn();
    }

    public void setZrnannaifuyouriyuukbn(String pZrnannaifuyouriyuukbn) {
        getPrimaryKey().setZrnannaifuyouriyuukbn(pZrnannaifuyouriyuukbn);
    }

    @Id
    @Column(name=GenZT_Ratep2Rn.ZRNTUUKASYUKBN)
    public String getZrntuukasyukbn() {
        return getPrimaryKey().getZrntuukasyukbn();
    }

    public void setZrntuukasyukbn(String pZrntuukasyukbn) {
        getPrimaryKey().setZrntuukasyukbn(pZrntuukasyukbn);
    }

    @Id
    @Column(name=GenZT_Ratep2Rn.ZRNDAI1HKNKKN)
    public String getZrndai1hknkkn() {
        return getPrimaryKey().getZrndai1hknkkn();
    }

    public void setZrndai1hknkkn(String pZrndai1hknkkn) {
        getPrimaryKey().setZrndai1hknkkn(pZrndai1hknkkn);
    }

    @Id
    @Column(name=GenZT_Ratep2Rn.ZRNRYOURITUKBN)
    public String getZrnryouritukbn() {
        return getPrimaryKey().getZrnryouritukbn();
    }

    public void setZrnryouritukbn(String pZrnryouritukbn) {
        getPrimaryKey().setZrnryouritukbn(pZrnryouritukbn);
    }

    private Double zrnprate;

    @Column(name=GenZT_Ratep2Rn.ZRNPRATE)
    public Double getZrnprate() {
        return zrnprate;
    }

    public void setZrnprate(Double pZrnprate) {
        zrnprate = pZrnprate;
    }

    private Double zrnpdatesrate;

    @Column(name=GenZT_Ratep2Rn.ZRNPDATESRATE)
    public Double getZrnpdatesrate() {
        return zrnpdatesrate;
    }

    public void setZrnpdatesrate(Double pZrnpdatesrate) {
        zrnpdatesrate = pZrnpdatesrate;
    }
}