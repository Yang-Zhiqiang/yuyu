package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SystemRenkeiFileSyubetuKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SystemRenkeiSyoriHousikiKbn;
import yuyu.def.db.entity.BT_SystemRenkei;
import yuyu.def.db.id.PKBT_SystemRenkei;
import yuyu.def.db.meta.GenQBT_SystemRenkei;
import yuyu.def.db.meta.QBT_SystemRenkei;
import yuyu.def.db.type.UserType_C_SystemRenkeiFileSyubetuKbn;
import yuyu.def.db.type.UserType_C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.db.type.UserType_C_SystemRenkeiSyoriHousikiKbn;

/**
 * システム間連携制御テーブル テーブルのマッピング情報クラスで、 {@link BT_SystemRenkei} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_SystemRenkei}</td><td colspan="3">システム間連携制御テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getInterfaceid interfaceid}</td><td>インターフェースＩＤ</td><td align="center">{@link PKBT_SystemRenkei ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyorihousiki syorihousiki}</td><td>処理方式</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SystemRenkeiSyoriHousikiKbn}</td></tr>
 *  <tr><td>{@link #getHenkanhoukou henkanhoukou}</td><td>変換方向</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SystemRenkeiHenkanHoukouKbn}</td></tr>
 *  <tr><td>{@link #getHenkanmaelayoutid henkanmaelayoutid}</td><td>変換前レイアウトＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkanmaelayoutname henkanmaelayoutname}</td><td>変換前レイアウト名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkangolayoutid henkangolayoutid}</td><td>変換後レイアウトＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkangolayoutname henkangolayoutname}</td><td>変換後レイアウト名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenkeifiledirectory renkeifiledirectory}</td><td>連携ファイル格納ディレクトリ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenkeifilenm renkeifilenm}</td><td>連携ファイル名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenkeifiletype renkeifiletype}</td><td>連携ファイル種別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SystemRenkeiFileSyubetuKbn}</td></tr>
 * </table>
 * @see     BT_SystemRenkei
 * @see     PKBT_SystemRenkei
 * @see     QBT_SystemRenkei
 * @see     GenQBT_SystemRenkei
 */
@MappedSuperclass
@Table(name=GenBT_SystemRenkei.TABLE_NAME)
@IdClass(value=PKBT_SystemRenkei.class)
@TypeDefs({
    @TypeDef(name="UserType_C_SystemRenkeiFileSyubetuKbn", typeClass=UserType_C_SystemRenkeiFileSyubetuKbn.class),
    @TypeDef(name="UserType_C_SystemRenkeiHenkanHoukouKbn", typeClass=UserType_C_SystemRenkeiHenkanHoukouKbn.class),
    @TypeDef(name="UserType_C_SystemRenkeiSyoriHousikiKbn", typeClass=UserType_C_SystemRenkeiSyoriHousikiKbn.class)
})
public abstract class GenBT_SystemRenkei extends AbstractExDBEntity<BT_SystemRenkei, PKBT_SystemRenkei> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_SystemRenkei";
    public static final String INTERFACEID              = "interfaceid";
    public static final String SYORIHOUSIKI             = "syorihousiki";
    public static final String HENKANHOUKOU             = "henkanhoukou";
    public static final String HENKANMAELAYOUTID        = "henkanmaelayoutid";
    public static final String HENKANMAELAYOUTNAME      = "henkanmaelayoutname";
    public static final String HENKANGOLAYOUTID         = "henkangolayoutid";
    public static final String HENKANGOLAYOUTNAME       = "henkangolayoutname";
    public static final String SUBSYSTEMID              = "subSystemId";
    public static final String RENKEIFILEDIRECTORY      = "renkeifiledirectory";
    public static final String RENKEIFILENM             = "renkeifilenm";
    public static final String RENKEIFILETYPE           = "renkeifiletype";

    private final PKBT_SystemRenkei primaryKey;

    public GenBT_SystemRenkei() {
        primaryKey = new PKBT_SystemRenkei();
    }

    public GenBT_SystemRenkei(String pInterfaceid) {
        primaryKey = new PKBT_SystemRenkei(pInterfaceid);
    }

    @Transient
    @Override
    public PKBT_SystemRenkei getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_SystemRenkei> getMetaClass() {
        return QBT_SystemRenkei.class;
    }

    @Id
    @Column(name=GenBT_SystemRenkei.INTERFACEID)
    public String getInterfaceid() {
        return getPrimaryKey().getInterfaceid();
    }

    public void setInterfaceid(String pInterfaceid) {
        getPrimaryKey().setInterfaceid(pInterfaceid);
    }

    private C_SystemRenkeiSyoriHousikiKbn syorihousiki;

    @Type(type="UserType_C_SystemRenkeiSyoriHousikiKbn")
    @Column(name=GenBT_SystemRenkei.SYORIHOUSIKI)
    public C_SystemRenkeiSyoriHousikiKbn getSyorihousiki() {
        return syorihousiki;
    }

    public void setSyorihousiki(C_SystemRenkeiSyoriHousikiKbn pSyorihousiki) {
        syorihousiki = pSyorihousiki;
    }

    private C_SystemRenkeiHenkanHoukouKbn henkanhoukou;

    @Type(type="UserType_C_SystemRenkeiHenkanHoukouKbn")
    @Column(name=GenBT_SystemRenkei.HENKANHOUKOU)
    public C_SystemRenkeiHenkanHoukouKbn getHenkanhoukou() {
        return henkanhoukou;
    }

    public void setHenkanhoukou(C_SystemRenkeiHenkanHoukouKbn pHenkanhoukou) {
        henkanhoukou = pHenkanhoukou;
    }

    private String henkanmaelayoutid;

    @Column(name=GenBT_SystemRenkei.HENKANMAELAYOUTID)
    public String getHenkanmaelayoutid() {
        return henkanmaelayoutid;
    }

    public void setHenkanmaelayoutid(String pHenkanmaelayoutid) {
        henkanmaelayoutid = pHenkanmaelayoutid;
    }

    private String henkanmaelayoutname;

    @Column(name=GenBT_SystemRenkei.HENKANMAELAYOUTNAME)
    public String getHenkanmaelayoutname() {
        return henkanmaelayoutname;
    }

    public void setHenkanmaelayoutname(String pHenkanmaelayoutname) {
        henkanmaelayoutname = pHenkanmaelayoutname;
    }

    private String henkangolayoutid;

    @Column(name=GenBT_SystemRenkei.HENKANGOLAYOUTID)
    public String getHenkangolayoutid() {
        return henkangolayoutid;
    }

    public void setHenkangolayoutid(String pHenkangolayoutid) {
        henkangolayoutid = pHenkangolayoutid;
    }

    private String henkangolayoutname;

    @Column(name=GenBT_SystemRenkei.HENKANGOLAYOUTNAME)
    public String getHenkangolayoutname() {
        return henkangolayoutname;
    }

    public void setHenkangolayoutname(String pHenkangolayoutname) {
        henkangolayoutname = pHenkangolayoutname;
    }

    private String subSystemId;

    @Column(name=GenBT_SystemRenkei.SUBSYSTEMID)
    public String getSubSystemId() {
        return subSystemId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }

    private String renkeifiledirectory;

    @Column(name=GenBT_SystemRenkei.RENKEIFILEDIRECTORY)
    public String getRenkeifiledirectory() {
        return renkeifiledirectory;
    }

    public void setRenkeifiledirectory(String pRenkeifiledirectory) {
        renkeifiledirectory = pRenkeifiledirectory;
    }

    private String renkeifilenm;

    @Column(name=GenBT_SystemRenkei.RENKEIFILENM)
    public String getRenkeifilenm() {
        return renkeifilenm;
    }

    public void setRenkeifilenm(String pRenkeifilenm) {
        renkeifilenm = pRenkeifilenm;
    }

    private C_SystemRenkeiFileSyubetuKbn renkeifiletype;

    @Type(type="UserType_C_SystemRenkeiFileSyubetuKbn")
    @Column(name=GenBT_SystemRenkei.RENKEIFILETYPE)
    public C_SystemRenkeiFileSyubetuKbn getRenkeifiletype() {
        return renkeifiletype;
    }

    public void setRenkeifiletype(C_SystemRenkeiFileSyubetuKbn pRenkeifiletype) {
        renkeifiletype = pRenkeifiletype;
    }
}
