package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.AS_SubSystem;
import yuyu.def.db.id.PKAS_SubSystem;
import yuyu.def.db.meta.GenQAS_SubSystem;
import yuyu.def.db.meta.QAS_SubSystem;

/**
 * サブシステム基幹テーブル テーブルのマッピング情報クラスで、 {@link AS_SubSystem} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AS_SubSystem}</td><td colspan="3">サブシステム基幹テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">{@link PKAS_SubSystem ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSubSystemNm subSystemNm}</td><td>サブシステム名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSortNo sortNo}</td><td>ソート番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLinkImage linkImage}</td><td>リンクイメージ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoudaiImage hyoudaiImage}</td><td>表題イメージ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AS_SubSystem
 * @see     PKAS_SubSystem
 * @see     QAS_SubSystem
 * @see     GenQAS_SubSystem
 */
@MappedSuperclass
@Table(name=GenAS_SubSystem.TABLE_NAME)
@IdClass(value=PKAS_SubSystem.class)
public abstract class GenAS_SubSystem extends AbstractExDBEntity<AS_SubSystem, PKAS_SubSystem> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AS_SubSystem";
    public static final String SUBSYSTEMID              = "subSystemId";
    public static final String SUBSYSTEMNM              = "subSystemNm";
    public static final String SORTNO                   = "sortNo";
    public static final String LINKIMAGE                = "linkImage";
    public static final String HYOUDAIIMAGE             = "hyoudaiImage";

    private final PKAS_SubSystem primaryKey;

    public GenAS_SubSystem() {
        primaryKey = new PKAS_SubSystem();
    }

    public GenAS_SubSystem(String pSubSystemId) {
        primaryKey = new PKAS_SubSystem(pSubSystemId);
    }

    @Transient
    @Override
    public PKAS_SubSystem getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAS_SubSystem> getMetaClass() {
        return QAS_SubSystem.class;
    }

    @Id
    @Column(name=GenAS_SubSystem.SUBSYSTEMID)
    public String getSubSystemId() {
        return getPrimaryKey().getSubSystemId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSubSystemId(String pSubSystemId) {
        getPrimaryKey().setSubSystemId(pSubSystemId);
    }

    private String subSystemNm;

    @Column(name=GenAS_SubSystem.SUBSYSTEMNM)
    public String getSubSystemNm() {
        return subSystemNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSubSystemNm(String pSubSystemNm) {
        subSystemNm = pSubSystemNm;
    }

    private Integer sortNo;

    @Column(name=GenAS_SubSystem.SORTNO)
    public Integer getSortNo() {
        return sortNo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSortNo(Integer pSortNo) {
        sortNo = pSortNo;
    }

    private String linkImage;

    @Column(name=GenAS_SubSystem.LINKIMAGE)
    public String getLinkImage() {
        return linkImage;
    }

    @Trim("both")
    public void setLinkImage(String pLinkImage) {
        linkImage = pLinkImage;
    }

    private String hyoudaiImage;

    @Column(name=GenAS_SubSystem.HYOUDAIIMAGE)
    public String getHyoudaiImage() {
        return hyoudaiImage;
    }

    @Trim("both")
    public void setHyoudaiImage(String pHyoudaiImage) {
        hyoudaiImage = pHyoudaiImage;
    }
}
