package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.AM_IdCardYakusyoku;
import yuyu.def.db.id.PKAM_IdCardYakusyoku;
import yuyu.def.db.meta.GenQAM_IdCardYakusyoku;
import yuyu.def.db.meta.QAM_IdCardYakusyoku;

/**
 * ＩＤカード役職マスタ テーブルのマッピング情報クラスで、 {@link AM_IdCardYakusyoku} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AM_IdCardYakusyoku}</td><td colspan="3">ＩＤカード役職マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getIdkbn idkbn}</td><td>ＩＤ区分</td><td align="center">{@link PKAM_IdCardYakusyoku ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIdcd idcd}</td><td>ＩＤコード</td><td align="center">{@link PKAM_IdCardYakusyoku ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYakusyokuhatureiymd yakusyokuhatureiymd}</td><td>役職発令年月日</td><td align="center">{@link PKAM_IdCardYakusyoku ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getYakusyokuhatureino yakusyokuhatureino}</td><td>役職発令番号</td><td align="center">{@link PKAM_IdCardYakusyoku ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYakusyokuhatureisosikicd yakusyokuhatureisosikicd}</td><td>役職発令組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYakusyokucd yakusyokucd}</td><td>役職コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AM_IdCardYakusyoku
 * @see     PKAM_IdCardYakusyoku
 * @see     QAM_IdCardYakusyoku
 * @see     GenQAM_IdCardYakusyoku
 */
@MappedSuperclass
@Table(name=GenAM_IdCardYakusyoku.TABLE_NAME)
@IdClass(value=PKAM_IdCardYakusyoku.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class)
})
public abstract class GenAM_IdCardYakusyoku extends AbstractExDBEntity<AM_IdCardYakusyoku, PKAM_IdCardYakusyoku> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AM_IdCardYakusyoku";
    public static final String IDKBN                    = "idkbn";
    public static final String IDCD                     = "idcd";
    public static final String YAKUSYOKUHATUREIYMD      = "yakusyokuhatureiymd";
    public static final String YAKUSYOKUHATUREINO       = "yakusyokuhatureino";
    public static final String YAKUSYOKUHATUREISOSIKICD = "yakusyokuhatureisosikicd";
    public static final String YAKUSYOKUCD              = "yakusyokucd";

    private final PKAM_IdCardYakusyoku primaryKey;

    public GenAM_IdCardYakusyoku() {
        primaryKey = new PKAM_IdCardYakusyoku();
    }

    public GenAM_IdCardYakusyoku(
        String pIdkbn,
        String pIdcd,
        BizDate pYakusyokuhatureiymd,
        String pYakusyokuhatureino
    ) {
        primaryKey = new PKAM_IdCardYakusyoku(
            pIdkbn,
            pIdcd,
            pYakusyokuhatureiymd,
            pYakusyokuhatureino
        );
    }

    @Transient
    @Override
    public PKAM_IdCardYakusyoku getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAM_IdCardYakusyoku> getMetaClass() {
        return QAM_IdCardYakusyoku.class;
    }

    @Id
    @Column(name=GenAM_IdCardYakusyoku.IDKBN)
    public String getIdkbn() {
        return getPrimaryKey().getIdkbn();
    }

    public void setIdkbn(String pIdkbn) {
        getPrimaryKey().setIdkbn(pIdkbn);
    }

    @Id
    @Column(name=GenAM_IdCardYakusyoku.IDCD)
    public String getIdcd() {
        return getPrimaryKey().getIdcd();
    }

    public void setIdcd(String pIdcd) {
        getPrimaryKey().setIdcd(pIdcd);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenAM_IdCardYakusyoku.YAKUSYOKUHATUREIYMD)
    public BizDate getYakusyokuhatureiymd() {
        return getPrimaryKey().getYakusyokuhatureiymd();
    }

    public void setYakusyokuhatureiymd(BizDate pYakusyokuhatureiymd) {
        getPrimaryKey().setYakusyokuhatureiymd(pYakusyokuhatureiymd);
    }

    @Id
    @Column(name=GenAM_IdCardYakusyoku.YAKUSYOKUHATUREINO)
    public String getYakusyokuhatureino() {
        return getPrimaryKey().getYakusyokuhatureino();
    }

    public void setYakusyokuhatureino(String pYakusyokuhatureino) {
        getPrimaryKey().setYakusyokuhatureino(pYakusyokuhatureino);
    }

    private String yakusyokuhatureisosikicd;

    @Column(name=GenAM_IdCardYakusyoku.YAKUSYOKUHATUREISOSIKICD)
    public String getYakusyokuhatureisosikicd() {
        return yakusyokuhatureisosikicd;
    }

    public void setYakusyokuhatureisosikicd(String pYakusyokuhatureisosikicd) {
        yakusyokuhatureisosikicd = pYakusyokuhatureisosikicd;
    }

    private String yakusyokucd;

    @Column(name=GenAM_IdCardYakusyoku.YAKUSYOKUCD)
    public String getYakusyokucd() {
        return yakusyokucd;
    }

    public void setYakusyokucd(String pYakusyokucd) {
        yakusyokucd = pYakusyokucd;
    }
}