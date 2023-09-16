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
import yuyu.def.classification.C_ToriatukaibiKbn;
import yuyu.def.db.entity.BM_TuukabetuKyuusibi;
import yuyu.def.db.id.PKBM_TuukabetuKyuusibi;
import yuyu.def.db.meta.GenQBM_TuukabetuKyuusibi;
import yuyu.def.db.meta.QBM_TuukabetuKyuusibi;
import yuyu.def.db.type.UserType_C_ToriatukaibiKbn;

/**
 * 通貨別取扱休止日マスタ テーブルのマッピング情報クラスで、 {@link BM_TuukabetuKyuusibi} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_TuukabetuKyuusibi}</td><td colspan="3">通貨別取扱休止日マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getTuukatoriatukaiymd tuukatoriatukaiymd}</td><td>通貨取扱年月日</td><td align="center">{@link PKBM_TuukabetuKyuusibi ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyuusijpykbn kyuusijpykbn}</td><td>円休止区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ToriatukaibiKbn}</td></tr>
 *  <tr><td>{@link #getKyuusiusdkbn kyuusiusdkbn}</td><td>米ドル休止区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ToriatukaibiKbn}</td></tr>
 *  <tr><td>{@link #getKyuusieurkbn kyuusieurkbn}</td><td>ユーロ休止区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ToriatukaibiKbn}</td></tr>
 *  <tr><td>{@link #getKyuusiaudkbn kyuusiaudkbn}</td><td>豪ドル休止区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ToriatukaibiKbn}</td></tr>
 * </table>
 * @see     BM_TuukabetuKyuusibi
 * @see     PKBM_TuukabetuKyuusibi
 * @see     QBM_TuukabetuKyuusibi
 * @see     GenQBM_TuukabetuKyuusibi
 */
@MappedSuperclass
@Table(name=GenBM_TuukabetuKyuusibi.TABLE_NAME)
@IdClass(value=PKBM_TuukabetuKyuusibi.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_ToriatukaibiKbn", typeClass=UserType_C_ToriatukaibiKbn.class)
})
public abstract class GenBM_TuukabetuKyuusibi extends AbstractExDBEntity<BM_TuukabetuKyuusibi, PKBM_TuukabetuKyuusibi> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_TuukabetuKyuusibi";
    public static final String TUUKATORIATUKAIYMD       = "tuukatoriatukaiymd";
    public static final String KYUUSIJPYKBN             = "kyuusijpykbn";
    public static final String KYUUSIUSDKBN             = "kyuusiusdkbn";
    public static final String KYUUSIEURKBN             = "kyuusieurkbn";
    public static final String KYUUSIAUDKBN             = "kyuusiaudkbn";

    private final PKBM_TuukabetuKyuusibi primaryKey;

    public GenBM_TuukabetuKyuusibi() {
        primaryKey = new PKBM_TuukabetuKyuusibi();
    }

    public GenBM_TuukabetuKyuusibi(BizDate pTuukatoriatukaiymd) {
        primaryKey = new PKBM_TuukabetuKyuusibi(pTuukatoriatukaiymd);
    }

    @Transient
    @Override
    public PKBM_TuukabetuKyuusibi getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_TuukabetuKyuusibi> getMetaClass() {
        return QBM_TuukabetuKyuusibi.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBM_TuukabetuKyuusibi.TUUKATORIATUKAIYMD)
    public BizDate getTuukatoriatukaiymd() {
        return getPrimaryKey().getTuukatoriatukaiymd();
    }

    public void setTuukatoriatukaiymd(BizDate pTuukatoriatukaiymd) {
        getPrimaryKey().setTuukatoriatukaiymd(pTuukatoriatukaiymd);
    }

    private C_ToriatukaibiKbn kyuusijpykbn;

    @Type(type="UserType_C_ToriatukaibiKbn")
    @Column(name=GenBM_TuukabetuKyuusibi.KYUUSIJPYKBN)
    public C_ToriatukaibiKbn getKyuusijpykbn() {
        return kyuusijpykbn;
    }

    public void setKyuusijpykbn(C_ToriatukaibiKbn pKyuusijpykbn) {
        kyuusijpykbn = pKyuusijpykbn;
    }

    private C_ToriatukaibiKbn kyuusiusdkbn;

    @Type(type="UserType_C_ToriatukaibiKbn")
    @Column(name=GenBM_TuukabetuKyuusibi.KYUUSIUSDKBN)
    public C_ToriatukaibiKbn getKyuusiusdkbn() {
        return kyuusiusdkbn;
    }

    public void setKyuusiusdkbn(C_ToriatukaibiKbn pKyuusiusdkbn) {
        kyuusiusdkbn = pKyuusiusdkbn;
    }

    private C_ToriatukaibiKbn kyuusieurkbn;

    @Type(type="UserType_C_ToriatukaibiKbn")
    @Column(name=GenBM_TuukabetuKyuusibi.KYUUSIEURKBN)
    public C_ToriatukaibiKbn getKyuusieurkbn() {
        return kyuusieurkbn;
    }

    public void setKyuusieurkbn(C_ToriatukaibiKbn pKyuusieurkbn) {
        kyuusieurkbn = pKyuusieurkbn;
    }

    private C_ToriatukaibiKbn kyuusiaudkbn;

    @Type(type="UserType_C_ToriatukaibiKbn")
    @Column(name=GenBM_TuukabetuKyuusibi.KYUUSIAUDKBN)
    public C_ToriatukaibiKbn getKyuusiaudkbn() {
        return kyuusiaudkbn;
    }

    public void setKyuusiaudkbn(C_ToriatukaibiKbn pKyuusiaudkbn) {
        kyuusiaudkbn = pKyuusiaudkbn;
    }
}
