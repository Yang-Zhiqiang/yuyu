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
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.db.entity.MT_DsHaisinErrorList2;
import yuyu.def.db.id.PKMT_DsHaisinErrorList2;
import yuyu.def.db.meta.GenQMT_DsHaisinErrorList2;
import yuyu.def.db.meta.QMT_DsHaisinErrorList2;
import yuyu.def.db.type.UserType_C_DsSousinMailSyubetuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＤＳ配信エラーリスト２テーブル テーブルのマッピング情報クラスで、 {@link MT_DsHaisinErrorList2} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsHaisinErrorList2}</td><td colspan="3">ＤＳ配信エラーリスト２テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDsdatasakuseiymd dsdatasakuseiymd}</td><td>ＤＳデータ作成日</td><td align="center">{@link PKMT_DsHaisinErrorList2 ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDsmailhaisinrenban dsmailhaisinrenban}</td><td>ＤＳメール配信連番</td><td align="center">{@link PKMT_DsHaisinErrorList2 ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDsmailaddressrenban dsmailaddressrenban}</td><td>ＤＳメールアドレス連番</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDssousinmailsyubetukbn dssousinmailsyubetukbn}</td><td>ＤＳ送信メール種別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DsSousinMailSyubetuKbn}</td></tr>
 *  <tr><td>{@link #getDssousinno dssousinno}</td><td>ＤＳ送信番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHaisinjidsmailaddress haisinjidsmailaddress}</td><td>配信時ＤＳメールアドレス</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDsmailsousinymd dsmailsousinymd}</td><td>ＤＳメール送信日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDsmailsakujyoymd dsmailsakujyoymd}</td><td>ＤＳメール削除日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHaisinerrorcount haisinerrorcount}</td><td>配信エラーカウント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHaisinerrorcount2 haisinerrorcount2}</td><td>配信エラーカウント２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsHaisinErrorList2
 * @see     PKMT_DsHaisinErrorList2
 * @see     QMT_DsHaisinErrorList2
 * @see     GenQMT_DsHaisinErrorList2
 */
@MappedSuperclass
@Table(name=GenMT_DsHaisinErrorList2.TABLE_NAME)
@IdClass(value=PKMT_DsHaisinErrorList2.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_DsSousinMailSyubetuKbn", typeClass=UserType_C_DsSousinMailSyubetuKbn.class)
})
public abstract class GenMT_DsHaisinErrorList2 extends AbstractExDBEntity<MT_DsHaisinErrorList2, PKMT_DsHaisinErrorList2> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MT_DsHaisinErrorList2";
    public static final String DSDATASAKUSEIYMD         = "dsdatasakuseiymd";
    public static final String DSMAILHAISINRENBAN       = "dsmailhaisinrenban";
    public static final String DSKOKNO                  = "dskokno";
    public static final String DSMAILADDRESSRENBAN      = "dsmailaddressrenban";
    public static final String DSSOUSINMAILSYUBETUKBN   = "dssousinmailsyubetukbn";
    public static final String DSSOUSINNO               = "dssousinno";
    public static final String SYONO                    = "syono";
    public static final String HAISINJIDSMAILADDRESS    = "haisinjidsmailaddress";
    public static final String DSMAILSOUSINYMD          = "dsmailsousinymd";
    public static final String DSMAILSAKUJYOYMD         = "dsmailsakujyoymd";
    public static final String HAISINERRORCOUNT         = "haisinerrorcount";
    public static final String HAISINERRORCOUNT2        = "haisinerrorcount2";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKMT_DsHaisinErrorList2 primaryKey;

    public GenMT_DsHaisinErrorList2() {
        primaryKey = new PKMT_DsHaisinErrorList2();
    }

    public GenMT_DsHaisinErrorList2(BizDate pDsdatasakuseiymd, Integer pDsmailhaisinrenban) {
        primaryKey = new PKMT_DsHaisinErrorList2(pDsdatasakuseiymd, pDsmailhaisinrenban);
    }

    @Transient
    @Override
    public PKMT_DsHaisinErrorList2 getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMT_DsHaisinErrorList2> getMetaClass() {
        return QMT_DsHaisinErrorList2.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenMT_DsHaisinErrorList2.DSDATASAKUSEIYMD)
    public BizDate getDsdatasakuseiymd() {
        return getPrimaryKey().getDsdatasakuseiymd();
    }

    public void setDsdatasakuseiymd(BizDate pDsdatasakuseiymd) {
        getPrimaryKey().setDsdatasakuseiymd(pDsdatasakuseiymd);
    }

    @Id
    @Column(name=GenMT_DsHaisinErrorList2.DSMAILHAISINRENBAN)
    public Integer getDsmailhaisinrenban() {
        return getPrimaryKey().getDsmailhaisinrenban();
    }

    public void setDsmailhaisinrenban(Integer pDsmailhaisinrenban) {
        getPrimaryKey().setDsmailhaisinrenban(pDsmailhaisinrenban);
    }

    private String dskokno;

    @Column(name=GenMT_DsHaisinErrorList2.DSKOKNO)
    public String getDskokno() {
        return dskokno;
    }

    public void setDskokno(String pDskokno) {
        dskokno = pDskokno;
    }

    private Integer dsmailaddressrenban;

    @Column(name=GenMT_DsHaisinErrorList2.DSMAILADDRESSRENBAN)
    public Integer getDsmailaddressrenban() {
        return dsmailaddressrenban;
    }

    public void setDsmailaddressrenban(Integer pDsmailaddressrenban) {
        dsmailaddressrenban = pDsmailaddressrenban;
    }

    private C_DsSousinMailSyubetuKbn dssousinmailsyubetukbn;

    @Type(type="UserType_C_DsSousinMailSyubetuKbn")
    @Column(name=GenMT_DsHaisinErrorList2.DSSOUSINMAILSYUBETUKBN)
    public C_DsSousinMailSyubetuKbn getDssousinmailsyubetukbn() {
        return dssousinmailsyubetukbn;
    }

    public void setDssousinmailsyubetukbn(C_DsSousinMailSyubetuKbn pDssousinmailsyubetukbn) {
        dssousinmailsyubetukbn = pDssousinmailsyubetukbn;
    }

    private String dssousinno;

    @Column(name=GenMT_DsHaisinErrorList2.DSSOUSINNO)
    public String getDssousinno() {
        return dssousinno;
    }

    public void setDssousinno(String pDssousinno) {
        dssousinno = pDssousinno;
    }

    private String syono;

    @Column(name=GenMT_DsHaisinErrorList2.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private String haisinjidsmailaddress;

    @Column(name=GenMT_DsHaisinErrorList2.HAISINJIDSMAILADDRESS)
    public String getHaisinjidsmailaddress() {
        return haisinjidsmailaddress;
    }

    public void setHaisinjidsmailaddress(String pHaisinjidsmailaddress) {
        haisinjidsmailaddress = pHaisinjidsmailaddress;
    }

    private BizDate dsmailsousinymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_DsHaisinErrorList2.DSMAILSOUSINYMD)
    public BizDate getDsmailsousinymd() {
        return dsmailsousinymd;
    }

    public void setDsmailsousinymd(BizDate pDsmailsousinymd) {
        dsmailsousinymd = pDsmailsousinymd;
    }

    private BizDate dsmailsakujyoymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_DsHaisinErrorList2.DSMAILSAKUJYOYMD)
    public BizDate getDsmailsakujyoymd() {
        return dsmailsakujyoymd;
    }

    public void setDsmailsakujyoymd(BizDate pDsmailsakujyoymd) {
        dsmailsakujyoymd = pDsmailsakujyoymd;
    }

    private String haisinerrorcount;

    @Column(name=GenMT_DsHaisinErrorList2.HAISINERRORCOUNT)
    public String getHaisinerrorcount() {
        return haisinerrorcount;
    }

    public void setHaisinerrorcount(String pHaisinerrorcount) {
        haisinerrorcount = pHaisinerrorcount;
    }

    private String haisinerrorcount2;

    @Column(name=GenMT_DsHaisinErrorList2.HAISINERRORCOUNT2)
    public String getHaisinerrorcount2() {
        return haisinerrorcount2;
    }

    public void setHaisinerrorcount2(String pHaisinerrorcount2) {
        haisinerrorcount2 = pHaisinerrorcount2;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenMT_DsHaisinErrorList2.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenMT_DsHaisinErrorList2.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenMT_DsHaisinErrorList2.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}