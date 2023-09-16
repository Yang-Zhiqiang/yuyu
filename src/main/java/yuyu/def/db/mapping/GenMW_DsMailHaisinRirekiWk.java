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
import yuyu.def.db.entity.MW_DsMailHaisinRirekiWk;
import yuyu.def.db.id.PKMW_DsMailHaisinRirekiWk;
import yuyu.def.db.meta.GenQMW_DsMailHaisinRirekiWk;
import yuyu.def.db.meta.QMW_DsMailHaisinRirekiWk;
import yuyu.def.db.type.UserType_C_DsSousinMailSyubetuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＤＳメール配信履歴ワークテーブル テーブルのマッピング情報クラスで、 {@link MW_DsMailHaisinRirekiWk} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MW_DsMailHaisinRirekiWk}</td><td colspan="3">ＤＳメール配信履歴ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDsdatasakuseiymd dsdatasakuseiymd}</td><td>ＤＳデータ作成日</td><td align="center">{@link PKMW_DsMailHaisinRirekiWk ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">{@link PKMW_DsMailHaisinRirekiWk ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDsmailhaisinrenban dsmailhaisinrenban}</td><td>ＤＳメール配信連番</td><td align="center">{@link PKMW_DsMailHaisinRirekiWk ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHaisinjidsmailaddress haisinjidsmailaddress}</td><td>配信時ＤＳメールアドレス</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDssousinno dssousinno}</td><td>ＤＳ送信番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDssousinmailsyubetukbn dssousinmailsyubetukbn}</td><td>ＤＳ送信メール種別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DsSousinMailSyubetuKbn}</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MW_DsMailHaisinRirekiWk
 * @see     PKMW_DsMailHaisinRirekiWk
 * @see     QMW_DsMailHaisinRirekiWk
 * @see     GenQMW_DsMailHaisinRirekiWk
 */
@MappedSuperclass
@Table(name=GenMW_DsMailHaisinRirekiWk.TABLE_NAME)
@IdClass(value=PKMW_DsMailHaisinRirekiWk.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_DsSousinMailSyubetuKbn", typeClass=UserType_C_DsSousinMailSyubetuKbn.class)
})
public abstract class GenMW_DsMailHaisinRirekiWk extends AbstractExDBEntity<MW_DsMailHaisinRirekiWk, PKMW_DsMailHaisinRirekiWk> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MW_DsMailHaisinRirekiWk";
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

    private final PKMW_DsMailHaisinRirekiWk primaryKey;

    public GenMW_DsMailHaisinRirekiWk() {
        primaryKey = new PKMW_DsMailHaisinRirekiWk();
    }

    public GenMW_DsMailHaisinRirekiWk(
        BizDate pDsdatasakuseiymd,
        String pDskokno,
        Integer pDsmailhaisinrenban
    ) {
        primaryKey = new PKMW_DsMailHaisinRirekiWk(
            pDsdatasakuseiymd,
            pDskokno,
            pDsmailhaisinrenban
        );
    }

    @Transient
    @Override
    public PKMW_DsMailHaisinRirekiWk getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMW_DsMailHaisinRirekiWk> getMetaClass() {
        return QMW_DsMailHaisinRirekiWk.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenMW_DsMailHaisinRirekiWk.DSDATASAKUSEIYMD)
    public BizDate getDsdatasakuseiymd() {
        return getPrimaryKey().getDsdatasakuseiymd();
    }

    public void setDsdatasakuseiymd(BizDate pDsdatasakuseiymd) {
        getPrimaryKey().setDsdatasakuseiymd(pDsdatasakuseiymd);
    }

    @Id
    @Column(name=GenMW_DsMailHaisinRirekiWk.DSKOKNO)
    public String getDskokno() {
        return getPrimaryKey().getDskokno();
    }

    public void setDskokno(String pDskokno) {
        getPrimaryKey().setDskokno(pDskokno);
    }

    @Id
    @Column(name=GenMW_DsMailHaisinRirekiWk.DSMAILHAISINRENBAN)
    public Integer getDsmailhaisinrenban() {
        return getPrimaryKey().getDsmailhaisinrenban();
    }

    public void setDsmailhaisinrenban(Integer pDsmailhaisinrenban) {
        getPrimaryKey().setDsmailhaisinrenban(pDsmailhaisinrenban);
    }

    private String haisinjidsmailaddress;

    @Column(name=GenMW_DsMailHaisinRirekiWk.HAISINJIDSMAILADDRESS)
    public String getHaisinjidsmailaddress() {
        return haisinjidsmailaddress;
    }

    public void setHaisinjidsmailaddress(String pHaisinjidsmailaddress) {
        haisinjidsmailaddress = pHaisinjidsmailaddress;
    }

    private String dssousinno;

    @Column(name=GenMW_DsMailHaisinRirekiWk.DSSOUSINNO)
    public String getDssousinno() {
        return dssousinno;
    }

    public void setDssousinno(String pDssousinno) {
        dssousinno = pDssousinno;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenMW_DsMailHaisinRirekiWk.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenMW_DsMailHaisinRirekiWk.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenMW_DsMailHaisinRirekiWk.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private C_DsSousinMailSyubetuKbn dssousinmailsyubetukbn;

    @Type(type="UserType_C_DsSousinMailSyubetuKbn")
    @Column(name=GenMW_DsMailHaisinRirekiWk.DSSOUSINMAILSYUBETUKBN)
    public C_DsSousinMailSyubetuKbn getDssousinmailsyubetukbn() {
        return dssousinmailsyubetukbn;
    }

    public void setDssousinmailsyubetukbn(C_DsSousinMailSyubetuKbn pDssousinmailsyubetukbn) {
        dssousinmailsyubetukbn = pDssousinmailsyubetukbn;
    }

    private String syono;

    @Column(name=GenMW_DsMailHaisinRirekiWk.SYONO)
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