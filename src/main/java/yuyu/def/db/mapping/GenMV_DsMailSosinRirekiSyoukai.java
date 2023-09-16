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
import yuyu.def.db.entity.MV_DsMailSosinRirekiSyoukai;
import yuyu.def.db.id.PKMV_DsMailSosinRirekiSyoukai;
import yuyu.def.db.meta.GenQMV_DsMailSosinRirekiSyoukai;
import yuyu.def.db.meta.QMV_DsMailSosinRirekiSyoukai;
import yuyu.def.db.type.UserType_C_DsSousinMailSyubetuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＤＳメール送信履歴照会ビュー テーブルのマッピング情報クラスで、 {@link MV_DsMailSosinRirekiSyoukai} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MV_DsMailSosinRirekiSyoukai}</td><td colspan="3">ＤＳメール送信履歴照会ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDsdatasakuseiymd dsdatasakuseiymd}</td><td>ＤＳデータ作成日</td><td align="center">{@link PKMV_DsMailSosinRirekiSyoukai ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">{@link PKMV_DsMailSosinRirekiSyoukai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDsmailhaisinrenban dsmailhaisinrenban}</td><td>ＤＳメール配信連番</td><td align="center">{@link PKMV_DsMailSosinRirekiSyoukai ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDssousinmailsyubetukbn dssousinmailsyubetukbn}</td><td>ＤＳ送信メール種別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DsSousinMailSyubetuKbn}</td></tr>
 *  <tr><td>{@link #getHaisinjidsmailaddress haisinjidsmailaddress}</td><td>配信時ＤＳメールアドレス</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDssousinno dssousinno}</td><td>ＤＳ送信番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHaisinerrorcount haisinerrorcount}</td><td>配信エラーカウント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MV_DsMailSosinRirekiSyoukai
 * @see     PKMV_DsMailSosinRirekiSyoukai
 * @see     QMV_DsMailSosinRirekiSyoukai
 * @see     GenQMV_DsMailSosinRirekiSyoukai
 */
@MappedSuperclass
@Table(name=GenMV_DsMailSosinRirekiSyoukai.TABLE_NAME)
@IdClass(value=PKMV_DsMailSosinRirekiSyoukai.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_DsSousinMailSyubetuKbn", typeClass=UserType_C_DsSousinMailSyubetuKbn.class)
})
public abstract class GenMV_DsMailSosinRirekiSyoukai extends AbstractExDBEntity<MV_DsMailSosinRirekiSyoukai, PKMV_DsMailSosinRirekiSyoukai> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MV_DsMailSosinRirekiSyoukai";
    public static final String DSDATASAKUSEIYMD         = "dsdatasakuseiymd";
    public static final String DSKOKNO                  = "dskokno";
    public static final String DSMAILHAISINRENBAN       = "dsmailhaisinrenban";
    public static final String SYONO                    = "syono";
    public static final String DSSOUSINMAILSYUBETUKBN   = "dssousinmailsyubetukbn";
    public static final String HAISINJIDSMAILADDRESS    = "haisinjidsmailaddress";
    public static final String DSSOUSINNO               = "dssousinno";
    public static final String HAISINERRORCOUNT         = "haisinerrorcount";

    private final PKMV_DsMailSosinRirekiSyoukai primaryKey;

    public GenMV_DsMailSosinRirekiSyoukai() {
        primaryKey = new PKMV_DsMailSosinRirekiSyoukai();
    }

    public GenMV_DsMailSosinRirekiSyoukai(
        BizDate pDsdatasakuseiymd,
        String pDskokno,
        Integer pDsmailhaisinrenban
    ) {
        primaryKey = new PKMV_DsMailSosinRirekiSyoukai(
            pDsdatasakuseiymd,
            pDskokno,
            pDsmailhaisinrenban
        );
    }

    @Transient
    @Override
    public PKMV_DsMailSosinRirekiSyoukai getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMV_DsMailSosinRirekiSyoukai> getMetaClass() {
        return QMV_DsMailSosinRirekiSyoukai.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenMV_DsMailSosinRirekiSyoukai.DSDATASAKUSEIYMD)
    public BizDate getDsdatasakuseiymd() {
        return getPrimaryKey().getDsdatasakuseiymd();
    }

    public void setDsdatasakuseiymd(BizDate pDsdatasakuseiymd) {
        getPrimaryKey().setDsdatasakuseiymd(pDsdatasakuseiymd);
    }

    @Id
    @Column(name=GenMV_DsMailSosinRirekiSyoukai.DSKOKNO)
    public String getDskokno() {
        return getPrimaryKey().getDskokno();
    }

    public void setDskokno(String pDskokno) {
        getPrimaryKey().setDskokno(pDskokno);
    }

    @Id
    @Column(name=GenMV_DsMailSosinRirekiSyoukai.DSMAILHAISINRENBAN)
    public Integer getDsmailhaisinrenban() {
        return getPrimaryKey().getDsmailhaisinrenban();
    }

    public void setDsmailhaisinrenban(Integer pDsmailhaisinrenban) {
        getPrimaryKey().setDsmailhaisinrenban(pDsmailhaisinrenban);
    }

    private String syono;

    @Column(name=GenMV_DsMailSosinRirekiSyoukai.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private C_DsSousinMailSyubetuKbn dssousinmailsyubetukbn;

    @Type(type="UserType_C_DsSousinMailSyubetuKbn")
    @Column(name=GenMV_DsMailSosinRirekiSyoukai.DSSOUSINMAILSYUBETUKBN)
    public C_DsSousinMailSyubetuKbn getDssousinmailsyubetukbn() {
        return dssousinmailsyubetukbn;
    }

    public void setDssousinmailsyubetukbn(C_DsSousinMailSyubetuKbn pDssousinmailsyubetukbn) {
        dssousinmailsyubetukbn = pDssousinmailsyubetukbn;
    }

    private String haisinjidsmailaddress;

    @Column(name=GenMV_DsMailSosinRirekiSyoukai.HAISINJIDSMAILADDRESS)
    public String getHaisinjidsmailaddress() {
        return haisinjidsmailaddress;
    }

    public void setHaisinjidsmailaddress(String pHaisinjidsmailaddress) {
        haisinjidsmailaddress = pHaisinjidsmailaddress;
    }

    private String dssousinno;

    @Column(name=GenMV_DsMailSosinRirekiSyoukai.DSSOUSINNO)
    public String getDssousinno() {
        return dssousinno;
    }

    public void setDssousinno(String pDssousinno) {
        dssousinno = pDssousinno;
    }

    private String haisinerrorcount;

    @Column(name=GenMV_DsMailSosinRirekiSyoukai.HAISINERRORCOUNT)
    public String getHaisinerrorcount() {
        return haisinerrorcount;
    }

    public void setHaisinerrorcount(String pHaisinerrorcount) {
        haisinerrorcount = pHaisinerrorcount;
    }
}