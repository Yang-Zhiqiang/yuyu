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
import yuyu.def.db.entity.BT_IdouKhBosyuudr;
import yuyu.def.db.id.PKBT_IdouKhBosyuudr;
import yuyu.def.db.meta.GenQBT_IdouKhBosyuudr;
import yuyu.def.db.meta.QBT_IdouKhBosyuudr;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 異動契約保全募集代理店テーブル テーブルのマッピング情報クラスで、 {@link BT_IdouKhBosyuudr} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_IdouKhBosyuudr}</td><td colspan="3">異動契約保全募集代理店テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKBT_IdouKhBosyuudr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">{@link PKBT_IdouKhBosyuudr ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDairitencd1 dairitencd1}</td><td>代理店コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBunwari1 bunwari1}</td><td>分担割合１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDairitencd2 dairitencd2}</td><td>代理店コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBunwari2 bunwari2}</td><td>分担割合２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKanrisosikicd1 kanrisosikicd1}</td><td>管理組織コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKanrisosikicd2 kanrisosikicd2}</td><td>管理組織コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_IdouKhBosyuudr
 * @see     PKBT_IdouKhBosyuudr
 * @see     QBT_IdouKhBosyuudr
 * @see     GenQBT_IdouKhBosyuudr
 */
@MappedSuperclass
@Table(name=GenBT_IdouKhBosyuudr.TABLE_NAME)
@IdClass(value=PKBT_IdouKhBosyuudr.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenBT_IdouKhBosyuudr extends AbstractExDBEntity<BT_IdouKhBosyuudr, PKBT_IdouKhBosyuudr> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_IdouKhBosyuudr";
    public static final String SYONO                    = "syono";
    public static final String RENNO3KETA               = "renno3keta";
    public static final String DAIRITENCD1              = "dairitencd1";
    public static final String BUNWARI1                 = "bunwari1";
    public static final String DAIRITENCD2              = "dairitencd2";
    public static final String BUNWARI2                 = "bunwari2";
    public static final String KANRISOSIKICD1           = "kanrisosikicd1";
    public static final String KANRISOSIKICD2           = "kanrisosikicd2";

    private final PKBT_IdouKhBosyuudr primaryKey;

    public GenBT_IdouKhBosyuudr() {
        primaryKey = new PKBT_IdouKhBosyuudr();
    }

    public GenBT_IdouKhBosyuudr(String pSyono, Integer pRenno3keta) {
        primaryKey = new PKBT_IdouKhBosyuudr(pSyono, pRenno3keta);
    }

    @Transient
    @Override
    public PKBT_IdouKhBosyuudr getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_IdouKhBosyuudr> getMetaClass() {
        return QBT_IdouKhBosyuudr.class;
    }

    @Id
    @Column(name=GenBT_IdouKhBosyuudr.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    @Id
    @Column(name=GenBT_IdouKhBosyuudr.RENNO3KETA)
    public Integer getRenno3keta() {
        return getPrimaryKey().getRenno3keta();
    }

    public void setRenno3keta(Integer pRenno3keta) {
        getPrimaryKey().setRenno3keta(pRenno3keta);
    }

    private String dairitencd1;

    @Column(name=GenBT_IdouKhBosyuudr.DAIRITENCD1)
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
    @Column(name=GenBT_IdouKhBosyuudr.BUNWARI1)
    public BizNumber getBunwari1() {
        return bunwari1;
    }

    public void setBunwari1(BizNumber pBunwari1) {
        bunwari1 = pBunwari1;
    }

    private String dairitencd2;

    @Column(name=GenBT_IdouKhBosyuudr.DAIRITENCD2)
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
    @Column(name=GenBT_IdouKhBosyuudr.BUNWARI2)
    public BizNumber getBunwari2() {
        return bunwari2;
    }

    public void setBunwari2(BizNumber pBunwari2) {
        bunwari2 = pBunwari2;
    }

    private String kanrisosikicd1;

    @Column(name=GenBT_IdouKhBosyuudr.KANRISOSIKICD1)
    public String getKanrisosikicd1() {
        return kanrisosikicd1;
    }

    public void setKanrisosikicd1(String pKanrisosikicd1) {
        kanrisosikicd1 = pKanrisosikicd1;
    }

    private String kanrisosikicd2;

    @Column(name=GenBT_IdouKhBosyuudr.KANRISOSIKICD2)
    public String getKanrisosikicd2() {
        return kanrisosikicd2;
    }

    public void setKanrisosikicd2(String pKanrisosikicd2) {
        kanrisosikicd2 = pKanrisosikicd2;
    }
}