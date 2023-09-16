package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BT_BuntanInfo;
import yuyu.def.db.id.PKBT_BuntanInfo;
import yuyu.def.db.meta.GenQBT_BuntanInfo;
import yuyu.def.db.meta.QBT_BuntanInfo;

/**
 * 分担情報テーブル テーブルのマッピング情報クラスで、 {@link BT_BuntanInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_BuntanInfo}</td><td colspan="3">分担情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDrtencd drtencd}</td><td>代理店コード</td><td align="center">{@link PKBT_BuntanInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDairitensyouhincd dairitensyouhincd}</td><td>代理店商品コード</td><td align="center">{@link PKBT_BuntanInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTesuuryoubuntandrtencd tesuuryoubuntandrtencd}</td><td>手数料分担相手代理店コード</td><td align="center">{@link PKBT_BuntanInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTesuuryoubuntanstartym tesuuryoubuntanstartym}</td><td>手数料分担開始年月</td><td align="center">{@link PKBT_BuntanInfo ○}</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getTesuuryoubuntanendym tesuuryoubuntanendym}</td><td>手数料分担終了年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getTesuuryoubuntanwariai tesuuryoubuntanwariai}</td><td>手数料分担割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BT_BuntanInfo
 * @see     PKBT_BuntanInfo
 * @see     QBT_BuntanInfo
 * @see     GenQBT_BuntanInfo
 */
@MappedSuperclass
@Table(name=GenBT_BuntanInfo.TABLE_NAME)
@IdClass(value=PKBT_BuntanInfo.class)
@TypeDefs({
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenBT_BuntanInfo extends AbstractExDBEntity<BT_BuntanInfo, PKBT_BuntanInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_BuntanInfo";
    public static final String DRTENCD                  = "drtencd";
    public static final String DAIRITENSYOUHINCD        = "dairitensyouhincd";
    public static final String TESUURYOUBUNTANDRTENCD   = "tesuuryoubuntandrtencd";
    public static final String TESUURYOUBUNTANSTARTYM   = "tesuuryoubuntanstartym";
    public static final String TESUURYOUBUNTANENDYM     = "tesuuryoubuntanendym";
    public static final String TESUURYOUBUNTANWARIAI    = "tesuuryoubuntanwariai";

    private final PKBT_BuntanInfo primaryKey;

    public GenBT_BuntanInfo() {
        primaryKey = new PKBT_BuntanInfo();
    }

    public GenBT_BuntanInfo(
        String pDrtencd,
        String pDairitensyouhincd,
        String pTesuuryoubuntandrtencd,
        BizDateYM pTesuuryoubuntanstartym
    ) {
        primaryKey = new PKBT_BuntanInfo(
            pDrtencd,
            pDairitensyouhincd,
            pTesuuryoubuntandrtencd,
            pTesuuryoubuntanstartym
        );
    }

    @Transient
    @Override
    public PKBT_BuntanInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_BuntanInfo> getMetaClass() {
        return QBT_BuntanInfo.class;
    }

    @Id
    @Column(name=GenBT_BuntanInfo.DRTENCD)
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
    @Column(name=GenBT_BuntanInfo.DAIRITENSYOUHINCD)
    public String getDairitensyouhincd() {
        return getPrimaryKey().getDairitensyouhincd();
    }

    public void setDairitensyouhincd(String pDairitensyouhincd) {
        getPrimaryKey().setDairitensyouhincd(pDairitensyouhincd);
    }

    @Id
    @Column(name=GenBT_BuntanInfo.TESUURYOUBUNTANDRTENCD)
    public String getTesuuryoubuntandrtencd() {
        return getPrimaryKey().getTesuuryoubuntandrtencd();
    }

    public void setTesuuryoubuntandrtencd(String pTesuuryoubuntandrtencd) {
        getPrimaryKey().setTesuuryoubuntandrtencd(pTesuuryoubuntandrtencd);
    }

    @Id
    @Type(type="BizDateYMType")
    @Column(name=GenBT_BuntanInfo.TESUURYOUBUNTANSTARTYM)
    public BizDateYM getTesuuryoubuntanstartym() {
        return getPrimaryKey().getTesuuryoubuntanstartym();
    }

    public void setTesuuryoubuntanstartym(BizDateYM pTesuuryoubuntanstartym) {
        getPrimaryKey().setTesuuryoubuntanstartym(pTesuuryoubuntanstartym);
    }

    private BizDateYM tesuuryoubuntanendym;

    @Type(type="BizDateYMType")
    @Column(name=GenBT_BuntanInfo.TESUURYOUBUNTANENDYM)
    public BizDateYM getTesuuryoubuntanendym() {
        return tesuuryoubuntanendym;
    }

    public void setTesuuryoubuntanendym(BizDateYM pTesuuryoubuntanendym) {
        tesuuryoubuntanendym = pTesuuryoubuntanendym;
    }

    private BizNumber tesuuryoubuntanwariai;

    @Type(type="BizNumberType")
    @Column(name=GenBT_BuntanInfo.TESUURYOUBUNTANWARIAI)
    public BizNumber getTesuuryoubuntanwariai() {
        return tesuuryoubuntanwariai;
    }

    public void setTesuuryoubuntanwariai(BizNumber pTesuuryoubuntanwariai) {
        tesuuryoubuntanwariai = pTesuuryoubuntanwariai;
    }
}
