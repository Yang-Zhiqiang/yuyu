package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_Ratep2Rn;
import yuyu.def.db.mapping.GenZT_Ratep2Rn;
import yuyu.def.db.meta.GenQZT_Ratep2Rn;
import yuyu.def.db.meta.QZT_Ratep2Rn;

/**
 * Ｐレートテーブル２（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_Ratep2Rn}</td><td colspan="3">Ｐレートテーブル２（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnhknsyuruikigousedaikbn zrnhknsyuruikigousedaikbn}</td><td>（連携用）保険種類記号世代区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnyoteiriritu zrnyoteiriritu}</td><td>（連携用）予定利率</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnpmenkbn zrnpmenkbn}</td><td>（連携用）Ｐ免区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnhhknsei zrnhhknsei}</td><td>（連携用）被保険者性別</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkeiyakujihhknnen zrnkeiyakujihhknnen}</td><td>（連携用）契約時被保険者年令</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsaimnkkykhyj zrnsaimnkkykhyj}</td><td>（連携用）才満期契約表示</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnhknkkn zrnhknkkn}</td><td>（連携用）保険期間</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnphrkkikn zrnphrkkikn}</td><td>（連携用）Ｐ払込期間</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnannaifuyouriyuukbn zrnannaifuyouriyuukbn}</td><td>（連携用）案内不要理由区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntuukasyukbn zrntuukasyukbn}</td><td>（連携用）通貨種類区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrndai1hknkkn zrndai1hknkkn}</td><td>（連携用）第１保険期間</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnryouritukbn zrnryouritukbn}</td><td>（連携用）料率区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnprate</td><td>（連携用）Ｐレート</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnpdatesrate</td><td>（連携用）Ｐ建Ｓレート</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 * </table>
 * @see     ZT_Ratep2Rn
 * @see     GenZT_Ratep2Rn
 * @see     QZT_Ratep2Rn
 * @see     GenQZT_Ratep2Rn
 */
public class PKZT_Ratep2Rn extends AbstractExDBPrimaryKey<ZT_Ratep2Rn, PKZT_Ratep2Rn> {

    private static final long serialVersionUID = 1L;

    public PKZT_Ratep2Rn() {
    }

    public PKZT_Ratep2Rn(
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
        zrnhknsyukigou = pZrnhknsyukigou;
        zrnhknsyuruikigousedaikbn = pZrnhknsyuruikigousedaikbn;
        zrnyoteiriritu = pZrnyoteiriritu;
        zrnpmenkbn = pZrnpmenkbn;
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
        zrnhhknsei = pZrnhhknsei;
        zrnkeiyakujihhknnen = pZrnkeiyakujihhknnen;
        zrnsaimnkkykhyj = pZrnsaimnkkykhyj;
        zrnhknkkn = pZrnhknkkn;
        zrnphrkkikn = pZrnphrkkikn;
        zrnannaifuyouriyuukbn = pZrnannaifuyouriyuukbn;
        zrntuukasyukbn = pZrntuukasyukbn;
        zrndai1hknkkn = pZrndai1hknkkn;
        zrnryouritukbn = pZrnryouritukbn;
    }

    @Transient
    @Override
    public Class<ZT_Ratep2Rn> getEntityClass() {
        return ZT_Ratep2Rn.class;
    }

    private String zrnhknsyukigou;

    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }
    private String zrnhknsyuruikigousedaikbn;

    public String getZrnhknsyuruikigousedaikbn() {
        return zrnhknsyuruikigousedaikbn;
    }

    public void setZrnhknsyuruikigousedaikbn(String pZrnhknsyuruikigousedaikbn) {
        zrnhknsyuruikigousedaikbn = pZrnhknsyuruikigousedaikbn;
    }
    private String zrnyoteiriritu;

    public String getZrnyoteiriritu() {
        return zrnyoteiriritu;
    }

    public void setZrnyoteiriritu(String pZrnyoteiriritu) {
        zrnyoteiriritu = pZrnyoteiriritu;
    }
    private String zrnpmenkbn;

    public String getZrnpmenkbn() {
        return zrnpmenkbn;
    }

    public void setZrnpmenkbn(String pZrnpmenkbn) {
        zrnpmenkbn = pZrnpmenkbn;
    }
    private String zrnhrkkaisuukbn;

    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }
    private String zrnhhknsei;

    public String getZrnhhknsei() {
        return zrnhhknsei;
    }

    public void setZrnhhknsei(String pZrnhhknsei) {
        zrnhhknsei = pZrnhhknsei;
    }
    private String zrnkeiyakujihhknnen;

    public String getZrnkeiyakujihhknnen() {
        return zrnkeiyakujihhknnen;
    }

    public void setZrnkeiyakujihhknnen(String pZrnkeiyakujihhknnen) {
        zrnkeiyakujihhknnen = pZrnkeiyakujihhknnen;
    }
    private String zrnsaimnkkykhyj;

    public String getZrnsaimnkkykhyj() {
        return zrnsaimnkkykhyj;
    }

    public void setZrnsaimnkkykhyj(String pZrnsaimnkkykhyj) {
        zrnsaimnkkykhyj = pZrnsaimnkkykhyj;
    }
    private String zrnhknkkn;

    public String getZrnhknkkn() {
        return zrnhknkkn;
    }

    public void setZrnhknkkn(String pZrnhknkkn) {
        zrnhknkkn = pZrnhknkkn;
    }
    private String zrnphrkkikn;

    public String getZrnphrkkikn() {
        return zrnphrkkikn;
    }

    public void setZrnphrkkikn(String pZrnphrkkikn) {
        zrnphrkkikn = pZrnphrkkikn;
    }
    private String zrnannaifuyouriyuukbn;

    public String getZrnannaifuyouriyuukbn() {
        return zrnannaifuyouriyuukbn;
    }

    public void setZrnannaifuyouriyuukbn(String pZrnannaifuyouriyuukbn) {
        zrnannaifuyouriyuukbn = pZrnannaifuyouriyuukbn;
    }
    private String zrntuukasyukbn;

    public String getZrntuukasyukbn() {
        return zrntuukasyukbn;
    }

    public void setZrntuukasyukbn(String pZrntuukasyukbn) {
        zrntuukasyukbn = pZrntuukasyukbn;
    }
    private String zrndai1hknkkn;

    public String getZrndai1hknkkn() {
        return zrndai1hknkkn;
    }

    public void setZrndai1hknkkn(String pZrndai1hknkkn) {
        zrndai1hknkkn = pZrndai1hknkkn;
    }
    private String zrnryouritukbn;

    public String getZrnryouritukbn() {
        return zrnryouritukbn;
    }

    public void setZrnryouritukbn(String pZrnryouritukbn) {
        zrnryouritukbn = pZrnryouritukbn;
    }

}