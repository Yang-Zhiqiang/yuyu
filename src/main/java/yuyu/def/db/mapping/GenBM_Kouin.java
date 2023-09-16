package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.BM_Kouin;
import yuyu.def.db.id.PKBM_Kouin;
import yuyu.def.db.meta.GenQBM_Kouin;
import yuyu.def.db.meta.QBM_Kouin;

/**
 * 行員マスタ テーブルのマッピング情報クラスで、 {@link BM_Kouin} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Kouin}</td><td colspan="3">行員マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKinyuucd kinyuucd}</td><td>金融機関コード</td><td align="center">{@link PKBM_Kouin ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKouincd kouincd}</td><td>行員コード</td><td align="center">{@link PKBM_Kouin ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBosyuucd bosyuucd}</td><td>募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_Kouin
 * @see     PKBM_Kouin
 * @see     QBM_Kouin
 * @see     GenQBM_Kouin
 */
@MappedSuperclass
@Table(name=GenBM_Kouin.TABLE_NAME)
@IdClass(value=PKBM_Kouin.class)
public abstract class GenBM_Kouin extends AbstractExDBEntity<BM_Kouin, PKBM_Kouin> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_Kouin";
    public static final String KINYUUCD                 = "kinyuucd";
    public static final String KOUINCD                  = "kouincd";
    public static final String BOSYUUCD                 = "bosyuucd";

    private final PKBM_Kouin primaryKey;

    public GenBM_Kouin() {
        primaryKey = new PKBM_Kouin();
    }

    public GenBM_Kouin(String pKinyuucd, String pKouincd) {
        primaryKey = new PKBM_Kouin(pKinyuucd, pKouincd);
    }

    @Transient
    @Override
    public PKBM_Kouin getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_Kouin> getMetaClass() {
        return QBM_Kouin.class;
    }

    @Id
    @Column(name=GenBM_Kouin.KINYUUCD)
    public String getKinyuucd() {
        return getPrimaryKey().getKinyuucd();
    }

    public void setKinyuucd(String pKinyuucd) {
        getPrimaryKey().setKinyuucd(pKinyuucd);
    }

    @Id
    @Column(name=GenBM_Kouin.KOUINCD)
    public String getKouincd() {
        return getPrimaryKey().getKouincd();
    }

    public void setKouincd(String pKouincd) {
        getPrimaryKey().setKouincd(pKouincd);
    }

    private String bosyuucd;

    @Column(name=GenBM_Kouin.BOSYUUCD)
    @MaxLength(max=6)
    @AlphaDigit
    public String getBosyuucd() {
        return bosyuucd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuucd(String pBosyuucd) {
        bosyuucd = pBosyuucd;
    }
}