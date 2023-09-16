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
import yuyu.def.db.entity.ZT_TumitateYosokuRn;
import yuyu.def.db.id.PKZT_TumitateYosokuRn;
import yuyu.def.db.meta.GenQZT_TumitateYosokuRn;
import yuyu.def.db.meta.QZT_TumitateYosokuRn;

/**
 * 積立金額予測ファイルテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_TumitateYosokuRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TumitateYosokuRn}</td><td colspan="3">積立金額予測ファイルテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">{@link PKZT_TumitateYosokuRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakuymd zrnkeiyakuymd}</td><td>（連携用）契約日</td><td align="center">{@link PKZT_TumitateYosokuRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntysytymd zrntysytymd}</td><td>（連携用）抽出日</td><td align="center">{@link PKZT_TumitateYosokuRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyktuukasyu zrnkyktuukasyu}</td><td>（連携用）契約通貨種類</td><td align="center">{@link PKZT_TumitateYosokuRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknkkn zrnhknkkn}</td><td>（連携用）保険期間</td><td align="center">{@link PKZT_TumitateYosokuRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknsyuruikbn zrntmttknsyuruikbn}</td><td>（連携用）積立金種類区分</td><td align="center">{@link PKZT_TumitateYosokuRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuukbn zrnsisuukbn}</td><td>（連携用）指数区分</td><td align="center">{@link PKZT_TumitateYosokuRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknysktaisyoukensuu zrntmttknysktaisyoukensuu}</td><td>（連携用）積立金予測対象件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnkyktuukakyktmttkngk zrnkyktuukakyktmttkngk}</td><td>（連携用）契約通貨建契約時積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkyktuukakisitmttkngk zrnkyktuukakisitmttkngk}</td><td>（連携用）契約通貨建期始積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkyktuukaysktmttkngk zrnkyktuukaysktmttkngk}</td><td>（連携用）契約通貨建予測積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     ZT_TumitateYosokuRn
 * @see     PKZT_TumitateYosokuRn
 * @see     QZT_TumitateYosokuRn
 * @see     GenQZT_TumitateYosokuRn
 */
@MappedSuperclass
@Table(name=GenZT_TumitateYosokuRn.TABLE_NAME)
@IdClass(value=PKZT_TumitateYosokuRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_TumitateYosokuRn extends AbstractExDBEntityForZDB<ZT_TumitateYosokuRn, PKZT_TumitateYosokuRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_TumitateYosokuRn";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNKEIYAKUYMD            = "zrnkeiyakuymd";
    public static final String ZRNTYSYTYMD              = "zrntysytymd";
    public static final String ZRNKYKTUUKASYU           = "zrnkyktuukasyu";
    public static final String ZRNHKNKKN                = "zrnhknkkn";
    public static final String ZRNTMTTKNSYURUIKBN       = "zrntmttknsyuruikbn";
    public static final String ZRNSISUUKBN              = "zrnsisuukbn";
    public static final String ZRNTMTTKNYSKTAISYOUKENSUU = "zrntmttknysktaisyoukensuu";
    public static final String ZRNKYKTUUKAKYKTMTTKNGK   = "zrnkyktuukakyktmttkngk";
    public static final String ZRNKYKTUUKAKISITMTTKNGK  = "zrnkyktuukakisitmttkngk";
    public static final String ZRNKYKTUUKAYSKTMTTKNGK   = "zrnkyktuukaysktmttkngk";

    private final PKZT_TumitateYosokuRn primaryKey;

    public GenZT_TumitateYosokuRn() {
        primaryKey = new PKZT_TumitateYosokuRn();
    }

    public GenZT_TumitateYosokuRn(
        String pZrnhknsyukigou,
        String pZrnkeiyakuymd,
        String pZrntysytymd,
        String pZrnkyktuukasyu,
        String pZrnhknkkn,
        String pZrntmttknsyuruikbn,
        String pZrnsisuukbn
    ) {
        primaryKey = new PKZT_TumitateYosokuRn(
            pZrnhknsyukigou,
            pZrnkeiyakuymd,
            pZrntysytymd,
            pZrnkyktuukasyu,
            pZrnhknkkn,
            pZrntmttknsyuruikbn,
            pZrnsisuukbn
        );
    }

    @Transient
    @Override
    public PKZT_TumitateYosokuRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_TumitateYosokuRn> getMetaClass() {
        return QZT_TumitateYosokuRn.class;
    }

    @Id
    @Column(name=GenZT_TumitateYosokuRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return getPrimaryKey().getZrnhknsyukigou();
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        getPrimaryKey().setZrnhknsyukigou(pZrnhknsyukigou);
    }

    @Id
    @Column(name=GenZT_TumitateYosokuRn.ZRNKEIYAKUYMD)
    public String getZrnkeiyakuymd() {
        return getPrimaryKey().getZrnkeiyakuymd();
    }

    public void setZrnkeiyakuymd(String pZrnkeiyakuymd) {
        getPrimaryKey().setZrnkeiyakuymd(pZrnkeiyakuymd);
    }

    @Id
    @Column(name=GenZT_TumitateYosokuRn.ZRNTYSYTYMD)
    public String getZrntysytymd() {
        return getPrimaryKey().getZrntysytymd();
    }

    public void setZrntysytymd(String pZrntysytymd) {
        getPrimaryKey().setZrntysytymd(pZrntysytymd);
    }

    @Id
    @Column(name=GenZT_TumitateYosokuRn.ZRNKYKTUUKASYU)
    public String getZrnkyktuukasyu() {
        return getPrimaryKey().getZrnkyktuukasyu();
    }

    public void setZrnkyktuukasyu(String pZrnkyktuukasyu) {
        getPrimaryKey().setZrnkyktuukasyu(pZrnkyktuukasyu);
    }

    @Id
    @Column(name=GenZT_TumitateYosokuRn.ZRNHKNKKN)
    public String getZrnhknkkn() {
        return getPrimaryKey().getZrnhknkkn();
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhknkkn(String pZrnhknkkn) {
        getPrimaryKey().setZrnhknkkn(pZrnhknkkn);
    }

    @Id
    @Column(name=GenZT_TumitateYosokuRn.ZRNTMTTKNSYURUIKBN)
    public String getZrntmttknsyuruikbn() {
        return getPrimaryKey().getZrntmttknsyuruikbn();
    }

    public void setZrntmttknsyuruikbn(String pZrntmttknsyuruikbn) {
        getPrimaryKey().setZrntmttknsyuruikbn(pZrntmttknsyuruikbn);
    }

    @Id
    @Column(name=GenZT_TumitateYosokuRn.ZRNSISUUKBN)
    public String getZrnsisuukbn() {
        return getPrimaryKey().getZrnsisuukbn();
    }

    public void setZrnsisuukbn(String pZrnsisuukbn) {
        getPrimaryKey().setZrnsisuukbn(pZrnsisuukbn);
    }

    private Integer zrntmttknysktaisyoukensuu;

    @Column(name=GenZT_TumitateYosokuRn.ZRNTMTTKNYSKTAISYOUKENSUU)
    public Integer getZrntmttknysktaisyoukensuu() {
        return zrntmttknysktaisyoukensuu;
    }

    public void setZrntmttknysktaisyoukensuu(Integer pZrntmttknysktaisyoukensuu) {
        zrntmttknysktaisyoukensuu = pZrntmttknysktaisyoukensuu;
    }

    private BizNumber zrnkyktuukakyktmttkngk;

    @Type(type="BizNumberType")
    @Column(name=GenZT_TumitateYosokuRn.ZRNKYKTUUKAKYKTMTTKNGK)
    public BizNumber getZrnkyktuukakyktmttkngk() {
        return zrnkyktuukakyktmttkngk;
    }

    public void setZrnkyktuukakyktmttkngk(BizNumber pZrnkyktuukakyktmttkngk) {
        zrnkyktuukakyktmttkngk = pZrnkyktuukakyktmttkngk;
    }

    private BizNumber zrnkyktuukakisitmttkngk;

    @Type(type="BizNumberType")
    @Column(name=GenZT_TumitateYosokuRn.ZRNKYKTUUKAKISITMTTKNGK)
    public BizNumber getZrnkyktuukakisitmttkngk() {
        return zrnkyktuukakisitmttkngk;
    }

    public void setZrnkyktuukakisitmttkngk(BizNumber pZrnkyktuukakisitmttkngk) {
        zrnkyktuukakisitmttkngk = pZrnkyktuukakisitmttkngk;
    }

    private BizNumber zrnkyktuukaysktmttkngk;

    @Type(type="BizNumberType")
    @Column(name=GenZT_TumitateYosokuRn.ZRNKYKTUUKAYSKTMTTKNGK)
    public BizNumber getZrnkyktuukaysktmttkngk() {
        return zrnkyktuukaysktmttkngk;
    }

    public void setZrnkyktuukaysktmttkngk(BizNumber pZrnkyktuukaysktmttkngk) {
        zrnkyktuukaysktmttkngk = pZrnkyktuukaysktmttkngk;
    }
}