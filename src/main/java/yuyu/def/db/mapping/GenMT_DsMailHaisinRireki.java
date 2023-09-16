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
import yuyu.def.db.entity.MT_DsMailHaisinRireki;
import yuyu.def.db.id.PKMT_DsMailHaisinRireki;
import yuyu.def.db.meta.GenQMT_DsMailHaisinRireki;
import yuyu.def.db.meta.QMT_DsMailHaisinRireki;
import yuyu.def.db.type.UserType_C_DsSousinMailSyubetuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＤＳメール配信履歴テーブル テーブルのマッピング情報クラスで、 {@link MT_DsMailHaisinRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsMailHaisinRireki}</td><td colspan="3">ＤＳメール配信履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDsdatasakuseiymd dsdatasakuseiymd}</td><td>ＤＳデータ作成日</td><td align="center">{@link PKMT_DsMailHaisinRireki ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">{@link PKMT_DsMailHaisinRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDsmailhaisinrenban dsmailhaisinrenban}</td><td>ＤＳメール配信連番</td><td align="center">{@link PKMT_DsMailHaisinRireki ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHaisinjidsmailaddress haisinjidsmailaddress}</td><td>配信時ＤＳメールアドレス</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDssousinno dssousinno}</td><td>ＤＳ送信番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDssousinmailsyubetukbn dssousinmailsyubetukbn}</td><td>ＤＳ送信メール種別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DsSousinMailSyubetuKbn}</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsMailHaisinRireki
 * @see     PKMT_DsMailHaisinRireki
 * @see     QMT_DsMailHaisinRireki
 * @see     GenQMT_DsMailHaisinRireki
 */
@MappedSuperclass
@Table(name=GenMT_DsMailHaisinRireki.TABLE_NAME)
@IdClass(value=PKMT_DsMailHaisinRireki.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_DsSousinMailSyubetuKbn", typeClass=UserType_C_DsSousinMailSyubetuKbn.class)
})
public abstract class GenMT_DsMailHaisinRireki extends AbstractExDBEntity<MT_DsMailHaisinRireki, PKMT_DsMailHaisinRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MT_DsMailHaisinRireki";
    public static final String DSDATASAKUSEIYMD         = "dsdatasakuseiymd";
    public static final String DSKOKNO                  = "dskokno";
    public static final String DSMAILHAISINRENBAN       = "dsmailhaisinrenban";
    public static final String HAISINJIDSMAILADDRESS    = "haisinjidsmailaddress";
    public static final String DSSOUSINNO               = "dssousinno";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String DSSOUSINMAILSYUBETUKBN   = "dssousinmailsyubetukbn";
    public static final String SYONO                    = "syono";

    private final PKMT_DsMailHaisinRireki primaryKey;

    public GenMT_DsMailHaisinRireki() {
        primaryKey = new PKMT_DsMailHaisinRireki();
    }

    public GenMT_DsMailHaisinRireki(
        BizDate pDsdatasakuseiymd,
        String pDskokno,
        Integer pDsmailhaisinrenban
    ) {
        primaryKey = new PKMT_DsMailHaisinRireki(
            pDsdatasakuseiymd,
            pDskokno,
            pDsmailhaisinrenban
        );
    }

    @Transient
    @Override
    public PKMT_DsMailHaisinRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMT_DsMailHaisinRireki> getMetaClass() {
        return QMT_DsMailHaisinRireki.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenMT_DsMailHaisinRireki.DSDATASAKUSEIYMD)
    public BizDate getDsdatasakuseiymd() {
        return getPrimaryKey().getDsdatasakuseiymd();
    }

    public void setDsdatasakuseiymd(BizDate pDsdatasakuseiymd) {
        getPrimaryKey().setDsdatasakuseiymd(pDsdatasakuseiymd);
    }

    @Id
    @Column(name=GenMT_DsMailHaisinRireki.DSKOKNO)
    public String getDskokno() {
        return getPrimaryKey().getDskokno();
    }

    public void setDskokno(String pDskokno) {
        getPrimaryKey().setDskokno(pDskokno);
    }

    @Id
    @Column(name=GenMT_DsMailHaisinRireki.DSMAILHAISINRENBAN)
    public Integer getDsmailhaisinrenban() {
        return getPrimaryKey().getDsmailhaisinrenban();
    }

    public void setDsmailhaisinrenban(Integer pDsmailhaisinrenban) {
        getPrimaryKey().setDsmailhaisinrenban(pDsmailhaisinrenban);
    }

    private String haisinjidsmailaddress;

    @Column(name=GenMT_DsMailHaisinRireki.HAISINJIDSMAILADDRESS)
    public String getHaisinjidsmailaddress() {
        return haisinjidsmailaddress;
    }

    public void setHaisinjidsmailaddress(String pHaisinjidsmailaddress) {
        haisinjidsmailaddress = pHaisinjidsmailaddress;
    }

    private String dssousinno;

    @Column(name=GenMT_DsMailHaisinRireki.DSSOUSINNO)
    public String getDssousinno() {
        return dssousinno;
    }

    public void setDssousinno(String pDssousinno) {
        dssousinno = pDssousinno;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenMT_DsMailHaisinRireki.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenMT_DsMailHaisinRireki.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenMT_DsMailHaisinRireki.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private C_DsSousinMailSyubetuKbn dssousinmailsyubetukbn;

    @Type(type="UserType_C_DsSousinMailSyubetuKbn")
    @Column(name=GenMT_DsMailHaisinRireki.DSSOUSINMAILSYUBETUKBN)
    public C_DsSousinMailSyubetuKbn getDssousinmailsyubetukbn() {
        return dssousinmailsyubetukbn;
    }

    public void setDssousinmailsyubetukbn(C_DsSousinMailSyubetuKbn pDssousinmailsyubetukbn) {
        dssousinmailsyubetukbn = pDssousinmailsyubetukbn;
    }

    private String syono;

    @Column(name=GenMT_DsMailHaisinRireki.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }
}