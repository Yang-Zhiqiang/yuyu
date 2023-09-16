package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SskmdHassouKbn;
import yuyu.def.db.entity.BM_SosikiMadoguti;
import yuyu.def.db.id.PKBM_SosikiMadoguti;
import yuyu.def.db.meta.GenQBM_SosikiMadoguti;
import yuyu.def.db.meta.QBM_SosikiMadoguti;
import yuyu.def.db.type.UserType_C_SskmdHassouKbn;

/**
 * 組織窓口情報マスタ テーブルのマッピング情報クラスで、 {@link BM_SosikiMadoguti} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_SosikiMadoguti}</td><td colspan="3">組織窓口情報マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSskmdsosikicd sskmdsosikicd}</td><td>組織窓口用組織コード</td><td align="center">{@link PKBM_SosikiMadoguti ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSskmdhassoukbn sskmdhassoukbn}</td><td>組織窓口用発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SskmdHassouKbn}</td></tr>
 *  <tr><td>{@link #getSskmdkanjisosikinm sskmdkanjisosikinm}</td><td>組織窓口用漢字組織名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSskmdkanjisosikiadr1 sskmdkanjisosikiadr1}</td><td>組織窓口用漢字組織住所１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSskmdkanjisosikiadr2 sskmdkanjisosikiadr2}</td><td>組織窓口用漢字組織住所２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSskmdkanjisosikiadr3 sskmdkanjisosikiadr3}</td><td>組織窓口用漢字組織住所３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSskmdpostalcd sskmdpostalcd}</td><td>組織窓口用郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSskmdtelno sskmdtelno}</td><td>組織窓口用電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSskmdfaxno sskmdfaxno}</td><td>組織窓口用ＦＡＸ番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSskmdsisyaharaidasikznm sskmdsisyaharaidasikznm}</td><td>組織窓口用支社払出口座名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSskmdkouzanocd sskmdkouzanocd}</td><td>組織窓口用口座番号ＣＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSskmdsisyaharaidasikouzano sskmdsisyaharaidasikouzano}</td><td>組織窓口用支社払出口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSskmdsosikikbnnm sskmdsosikikbnnm}</td><td>組織窓口用組織区分名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_SosikiMadoguti
 * @see     PKBM_SosikiMadoguti
 * @see     QBM_SosikiMadoguti
 * @see     GenQBM_SosikiMadoguti
 */
@MappedSuperclass
@Table(name=GenBM_SosikiMadoguti.TABLE_NAME)
@IdClass(value=PKBM_SosikiMadoguti.class)
@TypeDefs({
    @TypeDef(name="UserType_C_SskmdHassouKbn", typeClass=UserType_C_SskmdHassouKbn.class)
})
public abstract class GenBM_SosikiMadoguti extends AbstractExDBEntity<BM_SosikiMadoguti, PKBM_SosikiMadoguti> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_SosikiMadoguti";
    public static final String SSKMDSOSIKICD            = "sskmdsosikicd";
    public static final String SSKMDHASSOUKBN           = "sskmdhassoukbn";
    public static final String SSKMDKANJISOSIKINM       = "sskmdkanjisosikinm";
    public static final String SSKMDKANJISOSIKIADR1     = "sskmdkanjisosikiadr1";
    public static final String SSKMDKANJISOSIKIADR2     = "sskmdkanjisosikiadr2";
    public static final String SSKMDKANJISOSIKIADR3     = "sskmdkanjisosikiadr3";
    public static final String SSKMDPOSTALCD            = "sskmdpostalcd";
    public static final String SSKMDTELNO               = "sskmdtelno";
    public static final String SSKMDFAXNO               = "sskmdfaxno";
    public static final String SSKMDSISYAHARAIDASIKZNM  = "sskmdsisyaharaidasikznm";
    public static final String SSKMDKOUZANOCD           = "sskmdkouzanocd";
    public static final String SSKMDSISYAHARAIDASIKOUZANO = "sskmdsisyaharaidasikouzano";
    public static final String SSKMDSOSIKIKBNNM         = "sskmdsosikikbnnm";

    private final PKBM_SosikiMadoguti primaryKey;

    public GenBM_SosikiMadoguti() {
        primaryKey = new PKBM_SosikiMadoguti();
    }

    public GenBM_SosikiMadoguti(String pSskmdsosikicd) {
        primaryKey = new PKBM_SosikiMadoguti(pSskmdsosikicd);
    }

    @Transient
    @Override
    public PKBM_SosikiMadoguti getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_SosikiMadoguti> getMetaClass() {
        return QBM_SosikiMadoguti.class;
    }

    @Id
    @Column(name=GenBM_SosikiMadoguti.SSKMDSOSIKICD)
    public String getSskmdsosikicd() {
        return getPrimaryKey().getSskmdsosikicd();
    }

    public void setSskmdsosikicd(String pSskmdsosikicd) {
        getPrimaryKey().setSskmdsosikicd(pSskmdsosikicd);
    }

    private C_SskmdHassouKbn sskmdhassoukbn;

    @Type(type="UserType_C_SskmdHassouKbn")
    @Column(name=GenBM_SosikiMadoguti.SSKMDHASSOUKBN)
    public C_SskmdHassouKbn getSskmdhassoukbn() {
        return sskmdhassoukbn;
    }

    public void setSskmdhassoukbn(C_SskmdHassouKbn pSskmdhassoukbn) {
        sskmdhassoukbn = pSskmdhassoukbn;
    }

    private String sskmdkanjisosikinm;

    @Column(name=GenBM_SosikiMadoguti.SSKMDKANJISOSIKINM)
    public String getSskmdkanjisosikinm() {
        return sskmdkanjisosikinm;
    }

    public void setSskmdkanjisosikinm(String pSskmdkanjisosikinm) {
        sskmdkanjisosikinm = pSskmdkanjisosikinm;
    }

    private String sskmdkanjisosikiadr1;

    @Column(name=GenBM_SosikiMadoguti.SSKMDKANJISOSIKIADR1)
    public String getSskmdkanjisosikiadr1() {
        return sskmdkanjisosikiadr1;
    }

    public void setSskmdkanjisosikiadr1(String pSskmdkanjisosikiadr1) {
        sskmdkanjisosikiadr1 = pSskmdkanjisosikiadr1;
    }

    private String sskmdkanjisosikiadr2;

    @Column(name=GenBM_SosikiMadoguti.SSKMDKANJISOSIKIADR2)
    public String getSskmdkanjisosikiadr2() {
        return sskmdkanjisosikiadr2;
    }

    public void setSskmdkanjisosikiadr2(String pSskmdkanjisosikiadr2) {
        sskmdkanjisosikiadr2 = pSskmdkanjisosikiadr2;
    }

    private String sskmdkanjisosikiadr3;

    @Column(name=GenBM_SosikiMadoguti.SSKMDKANJISOSIKIADR3)
    public String getSskmdkanjisosikiadr3() {
        return sskmdkanjisosikiadr3;
    }

    public void setSskmdkanjisosikiadr3(String pSskmdkanjisosikiadr3) {
        sskmdkanjisosikiadr3 = pSskmdkanjisosikiadr3;
    }

    private String sskmdpostalcd;

    @Column(name=GenBM_SosikiMadoguti.SSKMDPOSTALCD)
    public String getSskmdpostalcd() {
        return sskmdpostalcd;
    }

    public void setSskmdpostalcd(String pSskmdpostalcd) {
        sskmdpostalcd = pSskmdpostalcd;
    }

    private String sskmdtelno;

    @Column(name=GenBM_SosikiMadoguti.SSKMDTELNO)
    public String getSskmdtelno() {
        return sskmdtelno;
    }

    public void setSskmdtelno(String pSskmdtelno) {
        sskmdtelno = pSskmdtelno;
    }

    private String sskmdfaxno;

    @Column(name=GenBM_SosikiMadoguti.SSKMDFAXNO)
    public String getSskmdfaxno() {
        return sskmdfaxno;
    }

    public void setSskmdfaxno(String pSskmdfaxno) {
        sskmdfaxno = pSskmdfaxno;
    }

    private String sskmdsisyaharaidasikznm;

    @Column(name=GenBM_SosikiMadoguti.SSKMDSISYAHARAIDASIKZNM)
    public String getSskmdsisyaharaidasikznm() {
        return sskmdsisyaharaidasikznm;
    }

    public void setSskmdsisyaharaidasikznm(String pSskmdsisyaharaidasikznm) {
        sskmdsisyaharaidasikznm = pSskmdsisyaharaidasikznm;
    }

    private String sskmdkouzanocd;

    @Column(name=GenBM_SosikiMadoguti.SSKMDKOUZANOCD)
    public String getSskmdkouzanocd() {
        return sskmdkouzanocd;
    }

    public void setSskmdkouzanocd(String pSskmdkouzanocd) {
        sskmdkouzanocd = pSskmdkouzanocd;
    }

    private String sskmdsisyaharaidasikouzano;

    @Column(name=GenBM_SosikiMadoguti.SSKMDSISYAHARAIDASIKOUZANO)
    public String getSskmdsisyaharaidasikouzano() {
        return sskmdsisyaharaidasikouzano;
    }

    public void setSskmdsisyaharaidasikouzano(String pSskmdsisyaharaidasikouzano) {
        sskmdsisyaharaidasikouzano = pSskmdsisyaharaidasikouzano;
    }

    private String sskmdsosikikbnnm;

    @Column(name=GenBM_SosikiMadoguti.SSKMDSOSIKIKBNNM)
    public String getSskmdsosikikbnnm() {
        return sskmdsosikikbnnm;
    }

    public void setSskmdsosikikbnnm(String pSskmdsosikikbnnm) {
        sskmdsosikikbnnm = pSskmdsosikikbnnm;
    }
}
