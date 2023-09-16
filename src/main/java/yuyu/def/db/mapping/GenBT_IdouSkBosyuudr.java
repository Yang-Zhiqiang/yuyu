package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BT_IdouSkBosyuudr;
import yuyu.def.db.id.PKBT_IdouSkBosyuudr;
import yuyu.def.db.meta.GenQBT_IdouSkBosyuudr;
import yuyu.def.db.meta.QBT_IdouSkBosyuudr;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 異動新契約募集代理店テーブル テーブルのマッピング情報クラスで、 {@link BT_IdouSkBosyuudr} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_IdouSkBosyuudr}</td><td colspan="3">異動新契約募集代理店テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKBT_IdouSkBosyuudr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">{@link PKBT_IdouSkBosyuudr ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDairitencd1 dairitencd1}</td><td>代理店コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBunwari1 bunwari1}</td><td>分担割合１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDairitencd2 dairitencd2}</td><td>代理店コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBunwari2 bunwari2}</td><td>分担割合２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKanrisosikicd1 kanrisosikicd1}</td><td>管理組織コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKanrisosikicd2 kanrisosikicd2}</td><td>管理組織コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_IdouSkBosyuudr
 * @see     PKBT_IdouSkBosyuudr
 * @see     QBT_IdouSkBosyuudr
 * @see     GenQBT_IdouSkBosyuudr
 */
@MappedSuperclass
@Table(name=GenBT_IdouSkBosyuudr.TABLE_NAME)
@IdClass(value=PKBT_IdouSkBosyuudr.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenBT_IdouSkBosyuudr extends AbstractExDBEntity<BT_IdouSkBosyuudr, PKBT_IdouSkBosyuudr> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_IdouSkBosyuudr";
    public static final String MOSNO                    = "mosno";
    public static final String RENNO3KETA               = "renno3keta";
    public static final String DAIRITENCD1              = "dairitencd1";
    public static final String BUNWARI1                 = "bunwari1";
    public static final String DAIRITENCD2              = "dairitencd2";
    public static final String BUNWARI2                 = "bunwari2";
    public static final String KANRISOSIKICD1           = "kanrisosikicd1";
    public static final String KANRISOSIKICD2           = "kanrisosikicd2";

    private final PKBT_IdouSkBosyuudr primaryKey;

    public GenBT_IdouSkBosyuudr() {
        primaryKey = new PKBT_IdouSkBosyuudr();
    }

    public GenBT_IdouSkBosyuudr(String pMosno, Integer pRenno3keta) {
        primaryKey = new PKBT_IdouSkBosyuudr(pMosno, pRenno3keta);
    }

    @Transient
    @Override
    public PKBT_IdouSkBosyuudr getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_IdouSkBosyuudr> getMetaClass() {
        return QBT_IdouSkBosyuudr.class;
    }

    @Id
    @Column(name=GenBT_IdouSkBosyuudr.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    @Id
    @Column(name=GenBT_IdouSkBosyuudr.RENNO3KETA)
    public Integer getRenno3keta() {
        return getPrimaryKey().getRenno3keta();
    }

    public void setRenno3keta(Integer pRenno3keta) {
        getPrimaryKey().setRenno3keta(pRenno3keta);
    }

    private String dairitencd1;

    @Column(name=GenBT_IdouSkBosyuudr.DAIRITENCD1)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDairitencd1() {
        return dairitencd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitencd1(String pDairitencd1) {
        dairitencd1 = pDairitencd1;
    }

    private BizNumber bunwari1;

    @Type(type="BizNumberType")
    @Column(name=GenBT_IdouSkBosyuudr.BUNWARI1)
    public BizNumber getBunwari1() {
        return bunwari1;
    }

    public void setBunwari1(BizNumber pBunwari1) {
        bunwari1 = pBunwari1;
    }

    private String dairitencd2;

    @Column(name=GenBT_IdouSkBosyuudr.DAIRITENCD2)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDairitencd2() {
        return dairitencd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDairitencd2(String pDairitencd2) {
        dairitencd2 = pDairitencd2;
    }

    private BizNumber bunwari2;

    @Type(type="BizNumberType")
    @Column(name=GenBT_IdouSkBosyuudr.BUNWARI2)
    public BizNumber getBunwari2() {
        return bunwari2;
    }

    public void setBunwari2(BizNumber pBunwari2) {
        bunwari2 = pBunwari2;
    }

    private String kanrisosikicd1;

    @Column(name=GenBT_IdouSkBosyuudr.KANRISOSIKICD1)
    public String getKanrisosikicd1() {
        return kanrisosikicd1;
    }

    public void setKanrisosikicd1(String pKanrisosikicd1) {
        kanrisosikicd1 = pKanrisosikicd1;
    }

    private String kanrisosikicd2;

    @Column(name=GenBT_IdouSkBosyuudr.KANRISOSIKICD2)
    public String getKanrisosikicd2() {
        return kanrisosikicd2;
    }

    public void setKanrisosikicd2(String pKanrisosikicd2) {
        kanrisosikicd2 = pKanrisosikicd2;
    }
}