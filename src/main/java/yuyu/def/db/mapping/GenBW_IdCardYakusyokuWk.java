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
import yuyu.def.db.entity.BW_IdCardYakusyokuWk;
import yuyu.def.db.id.PKBW_IdCardYakusyokuWk;
import yuyu.def.db.meta.GenQBW_IdCardYakusyokuWk;
import yuyu.def.db.meta.QBW_IdCardYakusyokuWk;

/**
 * ＩＤカード役職マスタワークテーブル テーブルのマッピング情報クラスで、 {@link BW_IdCardYakusyokuWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BW_IdCardYakusyokuWk}</td><td colspan="3">ＩＤカード役職マスタワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getIdkbn idkbn}</td><td>ＩＤ区分</td><td align="center">{@link PKBW_IdCardYakusyokuWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIdcd idcd}</td><td>ＩＤコード</td><td align="center">{@link PKBW_IdCardYakusyokuWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYakusyokuhatureiymd yakusyokuhatureiymd}</td><td>役職発令年月日</td><td align="center">{@link PKBW_IdCardYakusyokuWk ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getYakusyokuhatureino yakusyokuhatureino}</td><td>役職発令番号</td><td align="center">{@link PKBW_IdCardYakusyokuWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYakusyokuhatureisosikicd yakusyokuhatureisosikicd}</td><td>役職発令組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYakusyokucd yakusyokucd}</td><td>役職コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BW_IdCardYakusyokuWk
 * @see     PKBW_IdCardYakusyokuWk
 * @see     QBW_IdCardYakusyokuWk
 * @see     GenQBW_IdCardYakusyokuWk
 */
@MappedSuperclass
@Table(name=GenBW_IdCardYakusyokuWk.TABLE_NAME)
@IdClass(value=PKBW_IdCardYakusyokuWk.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class)
})
public abstract class GenBW_IdCardYakusyokuWk extends AbstractExDBEntity<BW_IdCardYakusyokuWk, PKBW_IdCardYakusyokuWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BW_IdCardYakusyokuWk";
    public static final String IDKBN                    = "idkbn";
    public static final String IDCD                     = "idcd";
    public static final String YAKUSYOKUHATUREIYMD      = "yakusyokuhatureiymd";
    public static final String YAKUSYOKUHATUREINO       = "yakusyokuhatureino";
    public static final String YAKUSYOKUHATUREISOSIKICD = "yakusyokuhatureisosikicd";
    public static final String YAKUSYOKUCD              = "yakusyokucd";

    private final PKBW_IdCardYakusyokuWk primaryKey;

    public GenBW_IdCardYakusyokuWk() {
        primaryKey = new PKBW_IdCardYakusyokuWk();
    }

    public GenBW_IdCardYakusyokuWk(
        String pIdkbn,
        String pIdcd,
        BizDate pYakusyokuhatureiymd,
        String pYakusyokuhatureino
    ) {
        primaryKey = new PKBW_IdCardYakusyokuWk(
            pIdkbn,
            pIdcd,
            pYakusyokuhatureiymd,
            pYakusyokuhatureino
        );
    }

    @Transient
    @Override
    public PKBW_IdCardYakusyokuWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBW_IdCardYakusyokuWk> getMetaClass() {
        return QBW_IdCardYakusyokuWk.class;
    }

    @Id
    @Column(name=GenBW_IdCardYakusyokuWk.IDKBN)
    public String getIdkbn() {
        return getPrimaryKey().getIdkbn();
    }

    public void setIdkbn(String pIdkbn) {
        getPrimaryKey().setIdkbn(pIdkbn);
    }

    @Id
    @Column(name=GenBW_IdCardYakusyokuWk.IDCD)
    public String getIdcd() {
        return getPrimaryKey().getIdcd();
    }

    public void setIdcd(String pIdcd) {
        getPrimaryKey().setIdcd(pIdcd);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBW_IdCardYakusyokuWk.YAKUSYOKUHATUREIYMD)
    public BizDate getYakusyokuhatureiymd() {
        return getPrimaryKey().getYakusyokuhatureiymd();
    }

    public void setYakusyokuhatureiymd(BizDate pYakusyokuhatureiymd) {
        getPrimaryKey().setYakusyokuhatureiymd(pYakusyokuhatureiymd);
    }

    @Id
    @Column(name=GenBW_IdCardYakusyokuWk.YAKUSYOKUHATUREINO)
    public String getYakusyokuhatureino() {
        return getPrimaryKey().getYakusyokuhatureino();
    }

    public void setYakusyokuhatureino(String pYakusyokuhatureino) {
        getPrimaryKey().setYakusyokuhatureino(pYakusyokuhatureino);
    }

    private String yakusyokuhatureisosikicd;

    @Column(name=GenBW_IdCardYakusyokuWk.YAKUSYOKUHATUREISOSIKICD)
    public String getYakusyokuhatureisosikicd() {
        return yakusyokuhatureisosikicd;
    }

    public void setYakusyokuhatureisosikicd(String pYakusyokuhatureisosikicd) {
        yakusyokuhatureisosikicd = pYakusyokuhatureisosikicd;
    }

    private String yakusyokucd;

    @Column(name=GenBW_IdCardYakusyokuWk.YAKUSYOKUCD)
    public String getYakusyokucd() {
        return yakusyokucd;
    }

    public void setYakusyokucd(String pYakusyokucd) {
        yakusyokucd = pYakusyokucd;
    }
}