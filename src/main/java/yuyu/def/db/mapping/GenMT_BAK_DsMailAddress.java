package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.Pattern;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DsMailSousinJyoutaiKbn;
import yuyu.def.classification.C_DsMailSousinTeisiRiyuuKbn;
import yuyu.def.classification.C_DsMailTourokuJyoutaiKbn;
import yuyu.def.db.entity.MT_BAK_DsMailAddress;
import yuyu.def.db.id.PKMT_BAK_DsMailAddress;
import yuyu.def.db.meta.GenQMT_BAK_DsMailAddress;
import yuyu.def.db.meta.QMT_BAK_DsMailAddress;
import yuyu.def.db.type.UserType_C_DsMailSousinJyoutaiKbn;
import yuyu.def.db.type.UserType_C_DsMailSousinTeisiRiyuuKbn;
import yuyu.def.db.type.UserType_C_DsMailTourokuJyoutaiKbn;

/**
 * ＤＳメールアドレスバックアップテーブル テーブルのマッピング情報クラスで、 {@link MT_BAK_DsMailAddress} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_BAK_DsMailAddress}</td><td colspan="3">ＤＳメールアドレスバックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">{@link PKMT_BAK_DsMailAddress ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDsmailaddressrenban dsmailaddressrenban}</td><td>ＤＳメールアドレス連番</td><td align="center">{@link PKMT_BAK_DsMailAddress ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKMT_BAK_DsMailAddress ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDsmailtourokujyoutaikbn dsmailtourokujyoutaikbn}</td><td>ＤＳメール登録状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DsMailTourokuJyoutaiKbn}</td></tr>
 *  <tr><td>{@link #getDsmailaddress dsmailaddress}</td><td>ＤＳメールアドレス</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDsmailsousinjyoutaikbn dsmailsousinjyoutaikbn}</td><td>ＤＳメール送信状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DsMailSousinJyoutaiKbn}</td></tr>
 *  <tr><td>{@link #getDsmailsousintisrykbn dsmailsousintisrykbn}</td><td>ＤＳメール送信停止理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DsMailSousinTeisiRiyuuKbn}</td></tr>
 *  <tr><td>{@link #getDstourokuymdtime dstourokuymdtime}</td><td>ＤＳ登録日時</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDskousinymdtime dskousinymdtime}</td><td>ＤＳ更新日時</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_BAK_DsMailAddress
 * @see     PKMT_BAK_DsMailAddress
 * @see     QMT_BAK_DsMailAddress
 * @see     GenQMT_BAK_DsMailAddress
 */
@MappedSuperclass
@Table(name=GenMT_BAK_DsMailAddress.TABLE_NAME)
@IdClass(value=PKMT_BAK_DsMailAddress.class)
@TypeDefs({
    @TypeDef(name="UserType_C_DsMailSousinJyoutaiKbn", typeClass=UserType_C_DsMailSousinJyoutaiKbn.class),
    @TypeDef(name="UserType_C_DsMailSousinTeisiRiyuuKbn", typeClass=UserType_C_DsMailSousinTeisiRiyuuKbn.class),
    @TypeDef(name="UserType_C_DsMailTourokuJyoutaiKbn", typeClass=UserType_C_DsMailTourokuJyoutaiKbn.class)
})
public abstract class GenMT_BAK_DsMailAddress extends AbstractExDBEntity<MT_BAK_DsMailAddress, PKMT_BAK_DsMailAddress> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MT_BAK_DsMailAddress";
    public static final String DSKOKNO                  = "dskokno";
    public static final String DSMAILADDRESSRENBAN      = "dsmailaddressrenban";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String DSMAILTOUROKUJYOUTAIKBN  = "dsmailtourokujyoutaikbn";
    public static final String DSMAILADDRESS            = "dsmailaddress";
    public static final String DSMAILSOUSINJYOUTAIKBN   = "dsmailsousinjyoutaikbn";
    public static final String DSMAILSOUSINTISRYKBN     = "dsmailsousintisrykbn";
    public static final String DSTOUROKUYMDTIME         = "dstourokuymdtime";
    public static final String DSKOUSINYMDTIME          = "dskousinymdtime";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKMT_BAK_DsMailAddress primaryKey;

    public GenMT_BAK_DsMailAddress() {
        primaryKey = new PKMT_BAK_DsMailAddress();
    }

    public GenMT_BAK_DsMailAddress(
        String pDskokno,
        Integer pDsmailaddressrenban,
        String pTrkssikibetukey
    ) {
        primaryKey = new PKMT_BAK_DsMailAddress(
            pDskokno,
            pDsmailaddressrenban,
            pTrkssikibetukey
        );
    }

    @Transient
    @Override
    public PKMT_BAK_DsMailAddress getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMT_BAK_DsMailAddress> getMetaClass() {
        return QMT_BAK_DsMailAddress.class;
    }

    @Id
    @Column(name=GenMT_BAK_DsMailAddress.DSKOKNO)
    public String getDskokno() {
        return getPrimaryKey().getDskokno();
    }

    public void setDskokno(String pDskokno) {
        getPrimaryKey().setDskokno(pDskokno);
    }

    @Id
    @Column(name=GenMT_BAK_DsMailAddress.DSMAILADDRESSRENBAN)
    public Integer getDsmailaddressrenban() {
        return getPrimaryKey().getDsmailaddressrenban();
    }

    public void setDsmailaddressrenban(Integer pDsmailaddressrenban) {
        getPrimaryKey().setDsmailaddressrenban(pDsmailaddressrenban);
    }

    @Id
    @Column(name=GenMT_BAK_DsMailAddress.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    private C_DsMailTourokuJyoutaiKbn dsmailtourokujyoutaikbn;

    @Type(type="UserType_C_DsMailTourokuJyoutaiKbn")
    @Column(name=GenMT_BAK_DsMailAddress.DSMAILTOUROKUJYOUTAIKBN)
    public C_DsMailTourokuJyoutaiKbn getDsmailtourokujyoutaikbn() {
        return dsmailtourokujyoutaikbn;
    }

    public void setDsmailtourokujyoutaikbn(C_DsMailTourokuJyoutaiKbn pDsmailtourokujyoutaikbn) {
        dsmailtourokujyoutaikbn = pDsmailtourokujyoutaikbn;
    }

    private String dsmailaddress;

    @Column(name=GenMT_BAK_DsMailAddress.DSMAILADDRESS)
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

    private C_DsMailSousinJyoutaiKbn dsmailsousinjyoutaikbn;

    @Type(type="UserType_C_DsMailSousinJyoutaiKbn")
    @Column(name=GenMT_BAK_DsMailAddress.DSMAILSOUSINJYOUTAIKBN)
    public C_DsMailSousinJyoutaiKbn getDsmailsousinjyoutaikbn() {
        return dsmailsousinjyoutaikbn;
    }

    public void setDsmailsousinjyoutaikbn(C_DsMailSousinJyoutaiKbn pDsmailsousinjyoutaikbn) {
        dsmailsousinjyoutaikbn = pDsmailsousinjyoutaikbn;
    }

    private C_DsMailSousinTeisiRiyuuKbn dsmailsousintisrykbn;

    @Type(type="UserType_C_DsMailSousinTeisiRiyuuKbn")
    @Column(name=GenMT_BAK_DsMailAddress.DSMAILSOUSINTISRYKBN)
    public C_DsMailSousinTeisiRiyuuKbn getDsmailsousintisrykbn() {
        return dsmailsousintisrykbn;
    }

    public void setDsmailsousintisrykbn(C_DsMailSousinTeisiRiyuuKbn pDsmailsousintisrykbn) {
        dsmailsousintisrykbn = pDsmailsousintisrykbn;
    }

    private String dstourokuymdtime;

    @Column(name=GenMT_BAK_DsMailAddress.DSTOUROKUYMDTIME)
    public String getDstourokuymdtime() {
        return dstourokuymdtime;
    }

    public void setDstourokuymdtime(String pDstourokuymdtime) {
        dstourokuymdtime = pDstourokuymdtime;
    }

    private String dskousinymdtime;

    @Column(name=GenMT_BAK_DsMailAddress.DSKOUSINYMDTIME)
    public String getDskousinymdtime() {
        return dskousinymdtime;
    }

    public void setDskousinymdtime(String pDskousinymdtime) {
        dskousinymdtime = pDskousinymdtime;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenMT_BAK_DsMailAddress.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenMT_BAK_DsMailAddress.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenMT_BAK_DsMailAddress.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}