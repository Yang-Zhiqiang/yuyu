package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.AT_RinjiKadouTaisyoSosiki;
import yuyu.def.db.id.PKAT_RinjiKadouTaisyoSosiki;
import yuyu.def.db.meta.GenQAT_RinjiKadouTaisyoSosiki;
import yuyu.def.db.meta.QAT_RinjiKadouTaisyoSosiki;

/**
 * 臨時稼働対象組織テーブル テーブルのマッピング情報クラスで、 {@link AT_RinjiKadouTaisyoSosiki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_RinjiKadouTaisyoSosiki}</td><td colspan="3">臨時稼働対象組織テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKadouSosikiCd kadouSosikiCd}</td><td>稼働組織コード</td><td align="center">{@link PKAT_RinjiKadouTaisyoSosiki ○}</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_RinjiKadouTaisyoSosiki
 * @see     PKAT_RinjiKadouTaisyoSosiki
 * @see     QAT_RinjiKadouTaisyoSosiki
 * @see     GenQAT_RinjiKadouTaisyoSosiki
 */
@MappedSuperclass
@Table(name=GenAT_RinjiKadouTaisyoSosiki.TABLE_NAME)
@IdClass(value=PKAT_RinjiKadouTaisyoSosiki.class)
public abstract class GenAT_RinjiKadouTaisyoSosiki extends AbstractExDBEntity<AT_RinjiKadouTaisyoSosiki, PKAT_RinjiKadouTaisyoSosiki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_RinjiKadouTaisyoSosiki";
    public static final String KADOUSOSIKICD            = "kadouSosikiCd";

    private final PKAT_RinjiKadouTaisyoSosiki primaryKey;

    public GenAT_RinjiKadouTaisyoSosiki() {
        primaryKey = new PKAT_RinjiKadouTaisyoSosiki();
    }

    public GenAT_RinjiKadouTaisyoSosiki(String pKadouSosikiCd) {
        primaryKey = new PKAT_RinjiKadouTaisyoSosiki(pKadouSosikiCd);
    }

    @Transient
    @Override
    public PKAT_RinjiKadouTaisyoSosiki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_RinjiKadouTaisyoSosiki> getMetaClass() {
        return QAT_RinjiKadouTaisyoSosiki.class;
    }

    @Id
    @Column(name=GenAT_RinjiKadouTaisyoSosiki.KADOUSOSIKICD)
    public String getKadouSosikiCd() {
        return getPrimaryKey().getKadouSosikiCd();
    }

    public void setKadouSosikiCd(String pKadouSosikiCd) {
        getPrimaryKey().setKadouSosikiCd(pKadouSosikiCd);
    }
}
