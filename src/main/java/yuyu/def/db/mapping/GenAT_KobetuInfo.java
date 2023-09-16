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
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.AT_KobetuInfo;
import yuyu.def.db.id.PKAT_KobetuInfo;
import yuyu.def.db.meta.GenQAT_KobetuInfo;
import yuyu.def.db.meta.QAT_KobetuInfo;

/**
 * 個別情報テーブル テーブルのマッピング情報クラスで、 {@link AT_KobetuInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_KobetuInfo}</td><td colspan="3">個別情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getUserId userId}</td><td>ユーザーＩＤ</td><td align="center">{@link PKAT_KobetuInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getInfoSeqNo infoSeqNo}</td><td>情報連番</td><td align="center">{@link PKAT_KobetuInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiYmdFrom hyoujiYmdFrom}</td><td>表示年月日（自）</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHyoujiYmdTo hyoujiYmdTo}</td><td>表示年月日（至）</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHyoujiNaiyou hyoujiNaiyou}</td><td>表示内容</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getInfoSikibetuId infoSikibetuId}</td><td>情報識別ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_KobetuInfo
 * @see     PKAT_KobetuInfo
 * @see     QAT_KobetuInfo
 * @see     GenQAT_KobetuInfo
 */
@MappedSuperclass
@Table(name=GenAT_KobetuInfo.TABLE_NAME)
@IdClass(value=PKAT_KobetuInfo.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class)
})
public abstract class GenAT_KobetuInfo extends AbstractExDBEntity<AT_KobetuInfo, PKAT_KobetuInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_KobetuInfo";
    public static final String USERID                   = "userId";
    public static final String INFOSEQNO                = "infoSeqNo";
    public static final String HYOUJIYMDFROM            = "hyoujiYmdFrom";
    public static final String HYOUJIYMDTO              = "hyoujiYmdTo";
    public static final String HYOUJINAIYOU             = "hyoujiNaiyou";
    public static final String INFOSIKIBETUID           = "infoSikibetuId";

    private final PKAT_KobetuInfo primaryKey;

    public GenAT_KobetuInfo() {
        primaryKey = new PKAT_KobetuInfo();
    }

    public GenAT_KobetuInfo(String pUserId, String pInfoSeqNo) {
        primaryKey = new PKAT_KobetuInfo(pUserId, pInfoSeqNo);
    }

    @Transient
    @Override
    public PKAT_KobetuInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_KobetuInfo> getMetaClass() {
        return QAT_KobetuInfo.class;
    }

    @Id
    @Column(name=GenAT_KobetuInfo.USERID)
    @MaxLength(max=30)
    @AlphaDigit
    public String getUserId() {
        return getPrimaryKey().getUserId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUserId(String pUserId) {
        getPrimaryKey().setUserId(pUserId);
    }

    @Id
    @Column(name=GenAT_KobetuInfo.INFOSEQNO)
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
    @Column(name=GenAT_KobetuInfo.HYOUJIYMDFROM)
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
    @Column(name=GenAT_KobetuInfo.HYOUJIYMDTO)
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

    @Column(name=GenAT_KobetuInfo.HYOUJINAIYOU)
    public String getHyoujiNaiyou() {
        return hyoujiNaiyou;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setHyoujiNaiyou(String pHyoujiNaiyou) {
        hyoujiNaiyou = pHyoujiNaiyou;
    }

    private String infoSikibetuId;

    @Column(name=GenAT_KobetuInfo.INFOSIKIBETUID)
    public String getInfoSikibetuId() {
        return infoSikibetuId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setInfoSikibetuId(String pInfoSikibetuId) {
        infoSikibetuId = pInfoSikibetuId;
    }
}
