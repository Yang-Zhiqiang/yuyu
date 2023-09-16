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
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.Pattern;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DsMailDbSyoriKbn;
import yuyu.def.classification.C_DsRendouTaisyouKbn;
import yuyu.def.db.entity.MT_DsMailAddressSpiralYyk;
import yuyu.def.db.id.PKMT_DsMailAddressSpiralYyk;
import yuyu.def.db.meta.GenQMT_DsMailAddressSpiralYyk;
import yuyu.def.db.meta.QMT_DsMailAddressSpiralYyk;
import yuyu.def.db.type.UserType_C_DsMailDbSyoriKbn;
import yuyu.def.db.type.UserType_C_DsRendouTaisyouKbn;

/**
 * ＤＳメールアドレスＳＰＩＲＡＬ反映予約テーブル テーブルのマッピング情報クラスで、 {@link MT_DsMailAddressSpiralYyk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsMailAddressSpiralYyk}</td><td colspan="3">ＤＳメールアドレスＳＰＩＲＡＬ反映予約テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDsdatasakuseiymd dsdatasakuseiymd}</td><td>ＤＳデータ作成日</td><td align="center">{@link PKMT_DsMailAddressSpiralYyk ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">{@link PKMT_DsMailAddressSpiralYyk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDsmailaddressrenban dsmailaddressrenban}</td><td>ＤＳメールアドレス連番</td><td align="center">{@link PKMT_DsMailAddressSpiralYyk ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDsmailaddress dsmailaddress}</td><td>ＤＳメールアドレス</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDsrendoutaisyoukbn dsrendoutaisyoukbn}</td><td>ＤＳ連動対象区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DsRendouTaisyouKbn}</td></tr>
 *  <tr><td>{@link #getDsmaildbsyorikbn dsmaildbsyorikbn}</td><td>ＤＳメールＤＢ処理区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DsMailDbSyoriKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsMailAddressSpiralYyk
 * @see     PKMT_DsMailAddressSpiralYyk
 * @see     QMT_DsMailAddressSpiralYyk
 * @see     GenQMT_DsMailAddressSpiralYyk
 */
@MappedSuperclass
@Table(name=GenMT_DsMailAddressSpiralYyk.TABLE_NAME)
@IdClass(value=PKMT_DsMailAddressSpiralYyk.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_DsMailDbSyoriKbn", typeClass=UserType_C_DsMailDbSyoriKbn.class),
    @TypeDef(name="UserType_C_DsRendouTaisyouKbn", typeClass=UserType_C_DsRendouTaisyouKbn.class)
})
public abstract class GenMT_DsMailAddressSpiralYyk extends AbstractExDBEntity<MT_DsMailAddressSpiralYyk, PKMT_DsMailAddressSpiralYyk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MT_DsMailAddressSpiralYyk";
    public static final String DSDATASAKUSEIYMD         = "dsdatasakuseiymd";
    public static final String DSKOKNO                  = "dskokno";
    public static final String DSMAILADDRESSRENBAN      = "dsmailaddressrenban";
    public static final String DSMAILADDRESS            = "dsmailaddress";
    public static final String DSRENDOUTAISYOUKBN       = "dsrendoutaisyoukbn";
    public static final String DSMAILDBSYORIKBN         = "dsmaildbsyorikbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKMT_DsMailAddressSpiralYyk primaryKey;

    public GenMT_DsMailAddressSpiralYyk() {
        primaryKey = new PKMT_DsMailAddressSpiralYyk();
    }

    public GenMT_DsMailAddressSpiralYyk(
        BizDate pDsdatasakuseiymd,
        String pDskokno,
        Integer pDsmailaddressrenban
    ) {
        primaryKey = new PKMT_DsMailAddressSpiralYyk(
            pDsdatasakuseiymd,
            pDskokno,
            pDsmailaddressrenban
        );
    }

    @Transient
    @Override
    public PKMT_DsMailAddressSpiralYyk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMT_DsMailAddressSpiralYyk> getMetaClass() {
        return QMT_DsMailAddressSpiralYyk.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenMT_DsMailAddressSpiralYyk.DSDATASAKUSEIYMD)
    public BizDate getDsdatasakuseiymd() {
        return getPrimaryKey().getDsdatasakuseiymd();
    }

    public void setDsdatasakuseiymd(BizDate pDsdatasakuseiymd) {
        getPrimaryKey().setDsdatasakuseiymd(pDsdatasakuseiymd);
    }

    @Id
    @Column(name=GenMT_DsMailAddressSpiralYyk.DSKOKNO)
    public String getDskokno() {
        return getPrimaryKey().getDskokno();
    }

    public void setDskokno(String pDskokno) {
        getPrimaryKey().setDskokno(pDskokno);
    }

    @Id
    @Column(name=GenMT_DsMailAddressSpiralYyk.DSMAILADDRESSRENBAN)
    public Integer getDsmailaddressrenban() {
        return getPrimaryKey().getDsmailaddressrenban();
    }

    public void setDsmailaddressrenban(Integer pDsmailaddressrenban) {
        getPrimaryKey().setDsmailaddressrenban(pDsmailaddressrenban);
    }

    private String dsmailaddress;

    @Column(name=GenMT_DsMailAddressSpiralYyk.DSMAILADDRESS)
    @MaxLength(max=100)
    @SingleByteStrings
    @Pattern(message="{pattern.MailAddress.message}", regex="^[\\w!#$%&'*+/=?^_{}\\\\|~-][\\w!#$%&'*+/=?^_{}\\\\|~\\.-]{0,63}@([\\w][\\w-]*\\.)+[\\w][\\w-]*$")
    public String getDsmailaddress() {
        return dsmailaddress;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDsmailaddress(String pDsmailaddress) {
        dsmailaddress = pDsmailaddress;
    }

    private C_DsRendouTaisyouKbn dsrendoutaisyoukbn;

    @Type(type="UserType_C_DsRendouTaisyouKbn")
    @Column(name=GenMT_DsMailAddressSpiralYyk.DSRENDOUTAISYOUKBN)
    public C_DsRendouTaisyouKbn getDsrendoutaisyoukbn() {
        return dsrendoutaisyoukbn;
    }

    public void setDsrendoutaisyoukbn(C_DsRendouTaisyouKbn pDsrendoutaisyoukbn) {
        dsrendoutaisyoukbn = pDsrendoutaisyoukbn;
    }

    private C_DsMailDbSyoriKbn dsmaildbsyorikbn;

    @Type(type="UserType_C_DsMailDbSyoriKbn")
    @Column(name=GenMT_DsMailAddressSpiralYyk.DSMAILDBSYORIKBN)
    public C_DsMailDbSyoriKbn getDsmaildbsyorikbn() {
        return dsmaildbsyorikbn;
    }

    public void setDsmaildbsyorikbn(C_DsMailDbSyoriKbn pDsmaildbsyorikbn) {
        dsmaildbsyorikbn = pDsmaildbsyorikbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenMT_DsMailAddressSpiralYyk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenMT_DsMailAddressSpiralYyk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenMT_DsMailAddressSpiralYyk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}