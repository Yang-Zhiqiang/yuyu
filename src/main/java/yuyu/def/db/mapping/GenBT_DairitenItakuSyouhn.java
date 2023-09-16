package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BT_DairitenItakuSyouhn;
import yuyu.def.db.id.PKBT_DairitenItakuSyouhn;
import yuyu.def.db.meta.GenQBT_DairitenItakuSyouhn;
import yuyu.def.db.meta.QBT_DairitenItakuSyouhn;

/**
 * 代理店委託商品情報テーブル テーブルのマッピング情報クラスで、 {@link BT_DairitenItakuSyouhn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_DairitenItakuSyouhn}</td><td colspan="3">代理店委託商品情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDrtencd drtencd}</td><td>代理店コード</td><td align="center">{@link PKBT_DairitenItakuSyouhn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtsyouhinsikibetukbnstr drtsyouhinsikibetukbnstr}</td><td>代理店商品識別区分（文字列）</td><td align="center">{@link PKBT_DairitenItakuSyouhn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrthrkhouhoukbn drthrkhouhoukbn}</td><td>代理店払込方法区分</td><td align="center">{@link PKBT_DairitenItakuSyouhn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtplannmkbn drtplannmkbn}</td><td>代理店プラン名区分</td><td align="center">{@link PKBT_DairitenItakuSyouhn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getItakuhknhnbkaisiymd itakuhknhnbkaisiymd}</td><td>委託保険販売開始年月日</td><td align="center">{@link PKBT_DairitenItakuSyouhn ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getItakuhknhnbsyuuryouymd itakuhknhnbsyuuryouymd}</td><td>委託保険販売終了年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     BT_DairitenItakuSyouhn
 * @see     PKBT_DairitenItakuSyouhn
 * @see     QBT_DairitenItakuSyouhn
 * @see     GenQBT_DairitenItakuSyouhn
 */
@MappedSuperclass
@Table(name=GenBT_DairitenItakuSyouhn.TABLE_NAME)
@IdClass(value=PKBT_DairitenItakuSyouhn.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class)
})
public abstract class GenBT_DairitenItakuSyouhn extends AbstractExDBEntity<BT_DairitenItakuSyouhn, PKBT_DairitenItakuSyouhn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_DairitenItakuSyouhn";
    public static final String DRTENCD                  = "drtencd";
    public static final String DRTSYOUHINSIKIBETUKBNSTR = "drtsyouhinsikibetukbnstr";
    public static final String DRTHRKHOUHOUKBN          = "drthrkhouhoukbn";
    public static final String DRTPLANNMKBN             = "drtplannmkbn";
    public static final String ITAKUHKNHNBKAISIYMD      = "itakuhknhnbkaisiymd";
    public static final String ITAKUHKNHNBSYUURYOUYMD   = "itakuhknhnbsyuuryouymd";

    private final PKBT_DairitenItakuSyouhn primaryKey;

    public GenBT_DairitenItakuSyouhn() {
        primaryKey = new PKBT_DairitenItakuSyouhn();
    }

    public GenBT_DairitenItakuSyouhn(
        String pDrtencd,
        String pDrtsyouhinsikibetukbnstr,
        String pDrthrkhouhoukbn,
        String pDrtplannmkbn,
        BizDate pItakuhknhnbkaisiymd
    ) {
        primaryKey = new PKBT_DairitenItakuSyouhn(
            pDrtencd,
            pDrtsyouhinsikibetukbnstr,
            pDrthrkhouhoukbn,
            pDrtplannmkbn,
            pItakuhknhnbkaisiymd
        );
    }

    @Transient
    @Override
    public PKBT_DairitenItakuSyouhn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_DairitenItakuSyouhn> getMetaClass() {
        return QBT_DairitenItakuSyouhn.class;
    }

    @Id
    @Column(name=GenBT_DairitenItakuSyouhn.DRTENCD)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDrtencd() {
        return getPrimaryKey().getDrtencd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtencd(String pDrtencd) {
        getPrimaryKey().setDrtencd(pDrtencd);
    }

    @Id
    @Column(name=GenBT_DairitenItakuSyouhn.DRTSYOUHINSIKIBETUKBNSTR)
    public String getDrtsyouhinsikibetukbnstr() {
        return getPrimaryKey().getDrtsyouhinsikibetukbnstr();
    }

    public void setDrtsyouhinsikibetukbnstr(String pDrtsyouhinsikibetukbnstr) {
        getPrimaryKey().setDrtsyouhinsikibetukbnstr(pDrtsyouhinsikibetukbnstr);
    }

    @Id
    @Column(name=GenBT_DairitenItakuSyouhn.DRTHRKHOUHOUKBN)
    public String getDrthrkhouhoukbn() {
        return getPrimaryKey().getDrthrkhouhoukbn();
    }

    public void setDrthrkhouhoukbn(String pDrthrkhouhoukbn) {
        getPrimaryKey().setDrthrkhouhoukbn(pDrthrkhouhoukbn);
    }

    @Id
    @Column(name=GenBT_DairitenItakuSyouhn.DRTPLANNMKBN)
    public String getDrtplannmkbn() {
        return getPrimaryKey().getDrtplannmkbn();
    }

    public void setDrtplannmkbn(String pDrtplannmkbn) {
        getPrimaryKey().setDrtplannmkbn(pDrtplannmkbn);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBT_DairitenItakuSyouhn.ITAKUHKNHNBKAISIYMD)
    public BizDate getItakuhknhnbkaisiymd() {
        return getPrimaryKey().getItakuhknhnbkaisiymd();
    }

    public void setItakuhknhnbkaisiymd(BizDate pItakuhknhnbkaisiymd) {
        getPrimaryKey().setItakuhknhnbkaisiymd(pItakuhknhnbkaisiymd);
    }

    private BizDate itakuhknhnbsyuuryouymd;

    @Type(type="BizDateType")
    @Column(name=GenBT_DairitenItakuSyouhn.ITAKUHKNHNBSYUURYOUYMD)
    public BizDate getItakuhknhnbsyuuryouymd() {
        return itakuhknhnbsyuuryouymd;
    }

    public void setItakuhknhnbsyuuryouymd(BizDate pItakuhknhnbsyuuryouymd) {
        itakuhknhnbsyuuryouymd = pItakuhknhnbsyuuryouymd;
    }
}