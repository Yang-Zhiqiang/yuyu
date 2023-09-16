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
import yuyu.def.db.entity.BT_TuutirirekiMeisaiHokan;
import yuyu.def.db.id.PKBT_TuutirirekiMeisaiHokan;
import yuyu.def.db.meta.GenQBT_TuutirirekiMeisaiHokan;
import yuyu.def.db.meta.QBT_TuutirirekiMeisaiHokan;

/**
 * 通知履歴明細保管テーブル テーブルのマッピング情報クラスで、 {@link BT_TuutirirekiMeisaiHokan} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_TuutirirekiMeisaiHokan}</td><td colspan="3">通知履歴明細保管テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getTuutirirekirenno tuutirirekirenno}</td><td>通知履歴連番</td><td align="center">{@link PKBT_TuutirirekiMeisaiHokan ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTuutirirekino tuutirirekino}</td><td>通知履歴番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTuutisakuseiymd tuutisakuseiymd}</td><td>通知作成年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTuutisakuseino tuutisakuseino}</td><td>通知作成番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTuutisyuruicd tuutisyuruicd}</td><td>通知種類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiyoutuutisakuseiymd hyoujiyoutuutisakuseiymd}</td><td>表示用通知作成年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     BT_TuutirirekiMeisaiHokan
 * @see     PKBT_TuutirirekiMeisaiHokan
 * @see     QBT_TuutirirekiMeisaiHokan
 * @see     GenQBT_TuutirirekiMeisaiHokan
 */
@MappedSuperclass
@Table(name=GenBT_TuutirirekiMeisaiHokan.TABLE_NAME)
@IdClass(value=PKBT_TuutirirekiMeisaiHokan.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class)
})
public abstract class GenBT_TuutirirekiMeisaiHokan extends AbstractExDBEntity<BT_TuutirirekiMeisaiHokan, PKBT_TuutirirekiMeisaiHokan> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_TuutirirekiMeisaiHokan";
    public static final String TUUTIRIREKIRENNO         = "tuutirirekirenno";
    public static final String TUUTIRIREKINO            = "tuutirirekino";
    public static final String TUUTISAKUSEIYMD          = "tuutisakuseiymd";
    public static final String TUUTISAKUSEINO           = "tuutisakuseino";
    public static final String TUUTISYURUICD            = "tuutisyuruicd";
    public static final String HYOUJIYOUTUUTISAKUSEIYMD = "hyoujiyoutuutisakuseiymd";

    private final PKBT_TuutirirekiMeisaiHokan primaryKey;

    public GenBT_TuutirirekiMeisaiHokan() {
        primaryKey = new PKBT_TuutirirekiMeisaiHokan();
    }

    public GenBT_TuutirirekiMeisaiHokan(String pTuutirirekirenno) {
        primaryKey = new PKBT_TuutirirekiMeisaiHokan(pTuutirirekirenno);
    }

    @Transient
    @Override
    public PKBT_TuutirirekiMeisaiHokan getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_TuutirirekiMeisaiHokan> getMetaClass() {
        return QBT_TuutirirekiMeisaiHokan.class;
    }

    @Id
    @Column(name=GenBT_TuutirirekiMeisaiHokan.TUUTIRIREKIRENNO)
    public String getTuutirirekirenno() {
        return getPrimaryKey().getTuutirirekirenno();
    }

    public void setTuutirirekirenno(String pTuutirirekirenno) {
        getPrimaryKey().setTuutirirekirenno(pTuutirirekirenno);
    }

    private String tuutirirekino;

    @Column(name=GenBT_TuutirirekiMeisaiHokan.TUUTIRIREKINO)
    public String getTuutirirekino() {
        return tuutirirekino;
    }

    public void setTuutirirekino(String pTuutirirekino) {
        tuutirirekino = pTuutirirekino;
    }

    private BizDate tuutisakuseiymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_TuutirirekiMeisaiHokan.TUUTISAKUSEIYMD)
    public BizDate getTuutisakuseiymd() {
        return tuutisakuseiymd;
    }

    public void setTuutisakuseiymd(BizDate pTuutisakuseiymd) {
        tuutisakuseiymd = pTuutisakuseiymd;
    }

    private Integer tuutisakuseino;

    @Column(name=GenBT_TuutirirekiMeisaiHokan.TUUTISAKUSEINO)
    public Integer getTuutisakuseino() {
        return tuutisakuseino;
    }

    public void setTuutisakuseino(Integer pTuutisakuseino) {
        tuutisakuseino = pTuutisakuseino;
    }

    private String tuutisyuruicd;

    @Column(name=GenBT_TuutirirekiMeisaiHokan.TUUTISYURUICD)
    public String getTuutisyuruicd() {
        return tuutisyuruicd;
    }

    public void setTuutisyuruicd(String pTuutisyuruicd) {
        tuutisyuruicd = pTuutisyuruicd;
    }

    private BizDate hyoujiyoutuutisakuseiymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_TuutirirekiMeisaiHokan.HYOUJIYOUTUUTISAKUSEIYMD)
    public BizDate getHyoujiyoutuutisakuseiymd() {
        return hyoujiyoutuutisakuseiymd;
    }

    public void setHyoujiyoutuutisakuseiymd(BizDate pHyoujiyoutuutisakuseiymd) {
        hyoujiyoutuutisakuseiymd = pHyoujiyoutuutisakuseiymd;
    }
}