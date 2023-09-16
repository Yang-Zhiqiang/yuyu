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
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.AT_KyoutuuInfo;
import yuyu.def.db.id.PKAT_KyoutuuInfo;
import yuyu.def.db.meta.GenQAT_KyoutuuInfo;
import yuyu.def.db.meta.QAT_KyoutuuInfo;

/**
 * 共通情報テーブル テーブルのマッピング情報クラスで、 {@link AT_KyoutuuInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_KyoutuuInfo}</td><td colspan="3">共通情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCategoryId categoryId}</td><td>カテゴリＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">{@link PKAT_KyoutuuInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getInfoSeqNo infoSeqNo}</td><td>情報連番</td><td align="center">{@link PKAT_KyoutuuInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiYmdFrom hyoujiYmdFrom}</td><td>表示年月日（自）</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHyoujiYmdTo hyoujiYmdTo}</td><td>表示年月日（至）</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHyoujiNaiyou hyoujiNaiyou}</td><td>表示内容</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getInfoSikibetuId infoSikibetuId}</td><td>情報識別ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_KyoutuuInfo
 * @see     PKAT_KyoutuuInfo
 * @see     QAT_KyoutuuInfo
 * @see     GenQAT_KyoutuuInfo
 */
@MappedSuperclass
@Table(name=GenAT_KyoutuuInfo.TABLE_NAME)
@IdClass(value=PKAT_KyoutuuInfo.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class)
})
public abstract class GenAT_KyoutuuInfo extends AbstractExDBEntity<AT_KyoutuuInfo, PKAT_KyoutuuInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_KyoutuuInfo";
    public static final String SUBSYSTEMID              = "subSystemId";
    public static final String CATEGORYID               = "categoryId";
    public static final String KINOUID                  = "kinouId";
    public static final String INFOSEQNO                = "infoSeqNo";
    public static final String HYOUJIYMDFROM            = "hyoujiYmdFrom";
    public static final String HYOUJIYMDTO              = "hyoujiYmdTo";
    public static final String HYOUJINAIYOU             = "hyoujiNaiyou";
    public static final String INFOSIKIBETUID           = "infoSikibetuId";

    private final PKAT_KyoutuuInfo primaryKey;

    public GenAT_KyoutuuInfo() {
        primaryKey = new PKAT_KyoutuuInfo();
    }

    public GenAT_KyoutuuInfo(String pKinouId, String pInfoSeqNo) {
        primaryKey = new PKAT_KyoutuuInfo(pKinouId, pInfoSeqNo);
    }

    @Transient
    @Override
    public PKAT_KyoutuuInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_KyoutuuInfo> getMetaClass() {
        return QAT_KyoutuuInfo.class;
    }

    private String subSystemId;

    @Column(name=GenAT_KyoutuuInfo.SUBSYSTEMID)
    public String getSubSystemId() {
        return subSystemId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }

    private String categoryId;

    @Column(name=GenAT_KyoutuuInfo.CATEGORYID)
    public String getCategoryId() {
        return categoryId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCategoryId(String pCategoryId) {
        categoryId = pCategoryId;
    }

    @Id
    @Column(name=GenAT_KyoutuuInfo.KINOUID)
    public String getKinouId() {
        return getPrimaryKey().getKinouId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouId(String pKinouId) {
        getPrimaryKey().setKinouId(pKinouId);
    }

    @Id
    @Column(name=GenAT_KyoutuuInfo.INFOSEQNO)
    public String getInfoSeqNo() {
        return getPrimaryKey().getInfoSeqNo();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setInfoSeqNo(String pInfoSeqNo) {
        getPrimaryKey().setInfoSeqNo(pInfoSeqNo);
    }

    private BizDate hyoujiYmdFrom;

    @Type(type="BizDateType")
    @Column(name=GenAT_KyoutuuInfo.HYOUJIYMDFROM)
    @ValidDate
    public BizDate getHyoujiYmdFrom() {
        return hyoujiYmdFrom;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHyoujiYmdFrom(BizDate pHyoujiYmdFrom) {
        hyoujiYmdFrom = pHyoujiYmdFrom;
    }

    private BizDate hyoujiYmdTo;

    @Type(type="BizDateType")
    @Column(name=GenAT_KyoutuuInfo.HYOUJIYMDTO)
    @ValidDate
    public BizDate getHyoujiYmdTo() {
        return hyoujiYmdTo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHyoujiYmdTo(BizDate pHyoujiYmdTo) {
        hyoujiYmdTo = pHyoujiYmdTo;
    }

    private String hyoujiNaiyou;

    @Column(name=GenAT_KyoutuuInfo.HYOUJINAIYOU)
    public String getHyoujiNaiyou() {
        return hyoujiNaiyou;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setHyoujiNaiyou(String pHyoujiNaiyou) {
        hyoujiNaiyou = pHyoujiNaiyou;
    }

    private String infoSikibetuId;

    @Column(name=GenAT_KyoutuuInfo.INFOSIKIBETUID)
    public String getInfoSikibetuId() {
        return infoSikibetuId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setInfoSikibetuId(String pInfoSikibetuId) {
        infoSikibetuId = pInfoSikibetuId;
    }
}
