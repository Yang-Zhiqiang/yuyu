package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import yuyu.def.db.entity.IT_TRGinkouTouhaigou;
import yuyu.def.db.id.PKIT_TRGinkouTouhaigou;
import yuyu.def.db.meta.GenQIT_TRGinkouTouhaigou;
import yuyu.def.db.meta.QIT_TRGinkouTouhaigou;

/**
 * 銀行統廃合ＴＲテーブル テーブルのマッピング情報クラスで、 {@link IT_TRGinkouTouhaigou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_TRGinkouTouhaigou}</td><td colspan="3">銀行統廃合ＴＲテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getBfrikkatuseibibankcd bfrikkatuseibibankcd}</td><td>（変更前）一括整備用銀行コード</td><td align="center">{@link PKIT_TRGinkouTouhaigou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBfrikkatuseibisitencd bfrikkatuseibisitencd}</td><td>（変更前）一括整備用支店コード</td><td align="center">{@link PKIT_TRGinkouTouhaigou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNewikkatuseibibankcd newikkatuseibibankcd}</td><td>（変更後）一括整備用銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNewikkatuseibisitencd newikkatuseibisitencd}</td><td>（変更後）一括整備用支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_TRGinkouTouhaigou
 * @see     PKIT_TRGinkouTouhaigou
 * @see     QIT_TRGinkouTouhaigou
 * @see     GenQIT_TRGinkouTouhaigou
 */
@MappedSuperclass
@Table(name=GenIT_TRGinkouTouhaigou.TABLE_NAME)
@IdClass(value=PKIT_TRGinkouTouhaigou.class)
public abstract class GenIT_TRGinkouTouhaigou extends AbstractExDBEntity<IT_TRGinkouTouhaigou, PKIT_TRGinkouTouhaigou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_TRGinkouTouhaigou";
    public static final String BFRIKKATUSEIBIBANKCD     = "bfrikkatuseibibankcd";
    public static final String BFRIKKATUSEIBISITENCD    = "bfrikkatuseibisitencd";
    public static final String NEWIKKATUSEIBIBANKCD     = "newikkatuseibibankcd";
    public static final String NEWIKKATUSEIBISITENCD    = "newikkatuseibisitencd";

    private final PKIT_TRGinkouTouhaigou primaryKey;

    public GenIT_TRGinkouTouhaigou() {
        primaryKey = new PKIT_TRGinkouTouhaigou();
    }

    public GenIT_TRGinkouTouhaigou(String pBfrikkatuseibibankcd, String pBfrikkatuseibisitencd) {
        primaryKey = new PKIT_TRGinkouTouhaigou(pBfrikkatuseibibankcd, pBfrikkatuseibisitencd);
    }

    @Transient
    @Override
    public PKIT_TRGinkouTouhaigou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_TRGinkouTouhaigou> getMetaClass() {
        return QIT_TRGinkouTouhaigou.class;
    }

    @Id
    @Column(name=GenIT_TRGinkouTouhaigou.BFRIKKATUSEIBIBANKCD)
    @Length(length=4)
    @Digit
    public String getBfrikkatuseibibankcd() {
        return getPrimaryKey().getBfrikkatuseibibankcd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBfrikkatuseibibankcd(String pBfrikkatuseibibankcd) {
        getPrimaryKey().setBfrikkatuseibibankcd(pBfrikkatuseibibankcd);
    }

    @Id
    @Column(name=GenIT_TRGinkouTouhaigou.BFRIKKATUSEIBISITENCD)
    @Length(length=3)
    @Digit
    public String getBfrikkatuseibisitencd() {
        return getPrimaryKey().getBfrikkatuseibisitencd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBfrikkatuseibisitencd(String pBfrikkatuseibisitencd) {
        getPrimaryKey().setBfrikkatuseibisitencd(pBfrikkatuseibisitencd);
    }

    private String newikkatuseibibankcd;

    @Column(name=GenIT_TRGinkouTouhaigou.NEWIKKATUSEIBIBANKCD)
    @Length(length=4)
    @Digit
    public String getNewikkatuseibibankcd() {
        return newikkatuseibibankcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewikkatuseibibankcd(String pNewikkatuseibibankcd) {
        newikkatuseibibankcd = pNewikkatuseibibankcd;
    }

    private String newikkatuseibisitencd;

    @Column(name=GenIT_TRGinkouTouhaigou.NEWIKKATUSEIBISITENCD)
    @Length(length=3)
    @Digit
    public String getNewikkatuseibisitencd() {
        return newikkatuseibisitencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNewikkatuseibisitencd(String pNewikkatuseibisitencd) {
        newikkatuseibisitencd = pNewikkatuseibisitencd;
    }
}