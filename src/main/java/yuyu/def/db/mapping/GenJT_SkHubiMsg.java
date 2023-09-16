package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_MsgSyubetu;
import yuyu.def.db.entity.JT_SkHubiMsg;
import yuyu.def.db.id.PKJT_SkHubiMsg;
import yuyu.def.db.meta.GenQJT_SkHubiMsg;
import yuyu.def.db.meta.QJT_SkHubiMsg;
import yuyu.def.db.type.UserType_C_MsgSyubetu;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 請求不備テーブル テーブルのマッピング情報クラスで、 {@link JT_SkHubiMsg} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SkHubiMsg}</td><td colspan="3">請求不備テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_SkHubiMsg ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_SkHubiMsg ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">{@link PKJT_SkHubiMsg ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">{@link PKJT_SkHubiMsg ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getUketukeno uketukeno}</td><td>受付番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getMsgsyubetu msgsyubetu}</td><td>メッセージ種別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MsgSyubetu}</td></tr>
 *  <tr><td>{@link #getHubimsgid hubimsgid}</td><td>不備メッセージＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHubimsg hubimsg}</td><td>不備メッセージ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SkHubiMsg
 * @see     PKJT_SkHubiMsg
 * @see     QJT_SkHubiMsg
 * @see     GenQJT_SkHubiMsg
 */
@MappedSuperclass
@Table(name=GenJT_SkHubiMsg.TABLE_NAME)
@IdClass(value=PKJT_SkHubiMsg.class)
@TypeDefs({
    @TypeDef(name="UserType_C_MsgSyubetu", typeClass=UserType_C_MsgSyubetu.class)
})
public abstract class GenJT_SkHubiMsg extends AbstractExDBEntity<JT_SkHubiMsg, PKJT_SkHubiMsg> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_SkHubiMsg";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String SEIKYUURIREKINO          = "seikyuurirekino";
    public static final String RENNO3KETA               = "renno3keta";
    public static final String UKETUKENO                = "uketukeno";
    public static final String MSGSYUBETU               = "msgsyubetu";
    public static final String HUBIMSGID                = "hubimsgid";
    public static final String HUBIMSG                  = "hubimsg";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";

    private final PKJT_SkHubiMsg primaryKey;

    public GenJT_SkHubiMsg() {
        primaryKey = new PKJT_SkHubiMsg();
    }

    public GenJT_SkHubiMsg(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino,
        Integer pRenno3keta
    ) {
        primaryKey = new PKJT_SkHubiMsg(
            pSkno,
            pSyono,
            pSeikyuurirekino,
            pRenno3keta
        );
    }

    @Transient
    @Override
    public PKJT_SkHubiMsg getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_SkHubiMsg> getMetaClass() {
        return QJT_SkHubiMsg.class;
    }

    @Id
    @Column(name=GenJT_SkHubiMsg.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_SkHubiMsg.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    @Id
    @Column(name=GenJT_SkHubiMsg.SEIKYUURIREKINO)
    public Integer getSeikyuurirekino() {
        return getPrimaryKey().getSeikyuurirekino();
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        getPrimaryKey().setSeikyuurirekino(pSeikyuurirekino);
    }

    @Id
    @Column(name=GenJT_SkHubiMsg.RENNO3KETA)
    public Integer getRenno3keta() {
        return getPrimaryKey().getRenno3keta();
    }

    public void setRenno3keta(Integer pRenno3keta) {
        getPrimaryKey().setRenno3keta(pRenno3keta);
    }

    private Integer uketukeno;

    @Column(name=GenJT_SkHubiMsg.UKETUKENO)
    public Integer getUketukeno() {
        return uketukeno;
    }

    public void setUketukeno(Integer pUketukeno) {
        uketukeno = pUketukeno;
    }

    private C_MsgSyubetu msgsyubetu;

    @Type(type="UserType_C_MsgSyubetu")
    @Column(name=GenJT_SkHubiMsg.MSGSYUBETU)
    public C_MsgSyubetu getMsgsyubetu() {
        return msgsyubetu;
    }

    public void setMsgsyubetu(C_MsgSyubetu pMsgsyubetu) {
        msgsyubetu = pMsgsyubetu;
    }

    private String hubimsgid;

    @Column(name=GenJT_SkHubiMsg.HUBIMSGID)
    public String getHubimsgid() {
        return hubimsgid;
    }

    public void setHubimsgid(String pHubimsgid) {
        hubimsgid = pHubimsgid;
    }

    private String hubimsg;

    @Column(name=GenJT_SkHubiMsg.HUBIMSG)
    public String getHubimsg() {
        return hubimsg;
    }

    public void setHubimsg(String pHubimsg) {
        hubimsg = pHubimsg;
    }

    private String kossyoricd;

    @Column(name=GenJT_SkHubiMsg.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_SkHubiMsg.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }
}