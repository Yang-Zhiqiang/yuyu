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
import yuyu.def.classification.C_YesNoKbn;
import yuyu.def.db.entity.AS_FileServerInfo;
import yuyu.def.db.id.PKAS_FileServerInfo;
import yuyu.def.db.meta.GenQAS_FileServerInfo;
import yuyu.def.db.meta.QAS_FileServerInfo;
import yuyu.def.db.type.UserType_C_YesNoKbn;

/**
 * ファイルサーバー情報基幹テーブル テーブルのマッピング情報クラスで、 {@link AS_FileServerInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AS_FileServerInfo}</td><td colspan="3">ファイルサーバー情報基幹テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSetteiNo setteiNo}</td><td>設定番号</td><td align="center">{@link PKAS_FileServerInfo ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTekiyouYmdFrom tekiyouYmdFrom}</td><td>適用年月日（自）</td><td align="center">{@link PKAS_FileServerInfo ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSetteiNm setteiNm}</td><td>設定名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSetuzokusakiDomain setuzokusakiDomain}</td><td>接続先ドメイン</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSetuzokusakiIpAddress setuzokusakiIpAddress}</td><td>接続先ＩＰアドレス</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSetuzokusakiPortNo setuzokusakiPortNo}</td><td>接続先ポート番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSetuzokuUser setuzokuUser}</td><td>接続ユーザー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSetuzokuPassword setuzokuPassword}</td><td>接続先パスワード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAngoukaKbn angoukaKbn}</td><td>暗号化区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YesNoKbn}</td></tr>
 * </table>
 * @see     AS_FileServerInfo
 * @see     PKAS_FileServerInfo
 * @see     QAS_FileServerInfo
 * @see     GenQAS_FileServerInfo
 */
@MappedSuperclass
@Table(name=GenAS_FileServerInfo.TABLE_NAME)
@IdClass(value=PKAS_FileServerInfo.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_YesNoKbn", typeClass=UserType_C_YesNoKbn.class)
})
public abstract class GenAS_FileServerInfo extends AbstractExDBEntity<AS_FileServerInfo, PKAS_FileServerInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AS_FileServerInfo";
    public static final String SETTEINO                 = "setteiNo";
    public static final String TEKIYOUYMDFROM           = "tekiyouYmdFrom";
    public static final String SETTEINM                 = "setteiNm";
    public static final String SETUZOKUSAKIDOMAIN       = "setuzokusakiDomain";
    public static final String SETUZOKUSAKIIPADDRESS    = "setuzokusakiIpAddress";
    public static final String SETUZOKUSAKIPORTNO       = "setuzokusakiPortNo";
    public static final String SETUZOKUUSER             = "setuzokuUser";
    public static final String SETUZOKUPASSWORD         = "setuzokuPassword";
    public static final String ANGOUKAKBN               = "angoukaKbn";

    private final PKAS_FileServerInfo primaryKey;

    public GenAS_FileServerInfo() {
        primaryKey = new PKAS_FileServerInfo();
    }

    public GenAS_FileServerInfo(Integer pSetteiNo, BizDate pTekiyouYmdFrom) {
        primaryKey = new PKAS_FileServerInfo(pSetteiNo, pTekiyouYmdFrom);
    }

    @Transient
    @Override
    public PKAS_FileServerInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAS_FileServerInfo> getMetaClass() {
        return QAS_FileServerInfo.class;
    }

    @Id
    @Column(name=GenAS_FileServerInfo.SETTEINO)
    public Integer getSetteiNo() {
        return getPrimaryKey().getSetteiNo();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSetteiNo(Integer pSetteiNo) {
        getPrimaryKey().setSetteiNo(pSetteiNo);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenAS_FileServerInfo.TEKIYOUYMDFROM)
    @ValidDate
    public BizDate getTekiyouYmdFrom() {
        return getPrimaryKey().getTekiyouYmdFrom();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTekiyouYmdFrom(BizDate pTekiyouYmdFrom) {
        getPrimaryKey().setTekiyouYmdFrom(pTekiyouYmdFrom);
    }

    private String setteiNm;

    @Column(name=GenAS_FileServerInfo.SETTEINM)
    public String getSetteiNm() {
        return setteiNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSetteiNm(String pSetteiNm) {
        setteiNm = pSetteiNm;
    }

    private String setuzokusakiDomain;

    @Column(name=GenAS_FileServerInfo.SETUZOKUSAKIDOMAIN)
    public String getSetuzokusakiDomain() {
        return setuzokusakiDomain;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSetuzokusakiDomain(String pSetuzokusakiDomain) {
        setuzokusakiDomain = pSetuzokusakiDomain;
    }

    private String setuzokusakiIpAddress;

    @Column(name=GenAS_FileServerInfo.SETUZOKUSAKIIPADDRESS)
    public String getSetuzokusakiIpAddress() {
        return setuzokusakiIpAddress;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSetuzokusakiIpAddress(String pSetuzokusakiIpAddress) {
        setuzokusakiIpAddress = pSetuzokusakiIpAddress;
    }

    private String setuzokusakiPortNo;

    @Column(name=GenAS_FileServerInfo.SETUZOKUSAKIPORTNO)
    public String getSetuzokusakiPortNo() {
        return setuzokusakiPortNo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSetuzokusakiPortNo(String pSetuzokusakiPortNo) {
        setuzokusakiPortNo = pSetuzokusakiPortNo;
    }

    private String setuzokuUser;

    @Column(name=GenAS_FileServerInfo.SETUZOKUUSER)
    public String getSetuzokuUser() {
        return setuzokuUser;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSetuzokuUser(String pSetuzokuUser) {
        setuzokuUser = pSetuzokuUser;
    }

    private String setuzokuPassword;

    @Column(name=GenAS_FileServerInfo.SETUZOKUPASSWORD)
    public String getSetuzokuPassword() {
        return setuzokuPassword;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSetuzokuPassword(String pSetuzokuPassword) {
        setuzokuPassword = pSetuzokuPassword;
    }

    private C_YesNoKbn angoukaKbn;

    @Type(type="UserType_C_YesNoKbn")
    @Column(name=GenAS_FileServerInfo.ANGOUKAKBN)
    public C_YesNoKbn getAngoukaKbn() {
        return angoukaKbn;
    }

    public void setAngoukaKbn(C_YesNoKbn pAngoukaKbn) {
        angoukaKbn = pAngoukaKbn;
    }
}
