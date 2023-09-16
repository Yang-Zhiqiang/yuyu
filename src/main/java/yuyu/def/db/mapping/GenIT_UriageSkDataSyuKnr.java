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
import jp.co.slcs.swak.db.hibernate.usertype.BooleanType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.IT_UriageSkDataSyuKnr;
import yuyu.def.db.id.PKIT_UriageSkDataSyuKnr;
import yuyu.def.db.meta.GenQIT_UriageSkDataSyuKnr;
import yuyu.def.db.meta.QIT_UriageSkDataSyuKnr;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 売上請求データ収納管理テーブル テーブルのマッピング情報クラスで、 {@link IT_UriageSkDataSyuKnr} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_UriageSkDataSyuKnr}</td><td colspan="3">売上請求データ収納管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_UriageSkDataSyuKnr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_UriageSkDataSyuKnr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">{@link PKIT_UriageSkDataSyuKnr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUriagenengappi uriagenengappi}</td><td>売上年月日</td><td align="center">{@link PKIT_UriageSkDataSyuKnr ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">{@link PKIT_UriageSkDataSyuKnr ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getCredituriagekekkahaneiymd credituriagekekkahaneiymd}</td><td>クレジットカード売上請求結果反映日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getCredituragskkkmhnkkchkzmflg credituragskkkmhnkkchkzmflg}</td><td>クレジットカード売上請求結果未返却チェック済フラグ</td><td align="center">&nbsp;</td><td align="center">B</td><td>Boolean</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_UriageSkDataSyuKnr
 * @see     PKIT_UriageSkDataSyuKnr
 * @see     QIT_UriageSkDataSyuKnr
 * @see     GenQIT_UriageSkDataSyuKnr
 */
@MappedSuperclass
@Table(name=GenIT_UriageSkDataSyuKnr.TABLE_NAME)
@IdClass(value=PKIT_UriageSkDataSyuKnr.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BooleanType", typeClass=BooleanType.class)
})
public abstract class GenIT_UriageSkDataSyuKnr extends AbstractExDBEntity<IT_UriageSkDataSyuKnr, PKIT_UriageSkDataSyuKnr> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_UriageSkDataSyuKnr";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String CREDITKESSAIYOUNO        = "creditkessaiyouno";
    public static final String URIAGENENGAPPI           = "uriagenengappi";
    public static final String RENNO3KETA               = "renno3keta";
    public static final String CREDITURIAGEKEKKAHANEIYMD = "credituriagekekkahaneiymd";
    public static final String CREDITURAGSKKKMHNKKCHKZMFLG = "credituragskkkmhnkkchkzmflg";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_UriageSkDataSyuKnr primaryKey;

    public GenIT_UriageSkDataSyuKnr() {
        primaryKey = new PKIT_UriageSkDataSyuKnr();
    }

    public GenIT_UriageSkDataSyuKnr(
        String pKbnkey,
        String pSyono,
        String pCreditkessaiyouno,
        BizDate pUriagenengappi,
        Integer pRenno3keta
    ) {
        primaryKey = new PKIT_UriageSkDataSyuKnr(
            pKbnkey,
            pSyono,
            pCreditkessaiyouno,
            pUriagenengappi,
            pRenno3keta
        );
    }

    @Transient
    @Override
    public PKIT_UriageSkDataSyuKnr getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_UriageSkDataSyuKnr> getMetaClass() {
        return QIT_UriageSkDataSyuKnr.class;
    }

    @Id
    @Column(name=GenIT_UriageSkDataSyuKnr.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_UriageSkDataSyuKnr.SYONO)
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
    @Column(name=GenIT_UriageSkDataSyuKnr.CREDITKESSAIYOUNO)
    public String getCreditkessaiyouno() {
        return getPrimaryKey().getCreditkessaiyouno();
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        getPrimaryKey().setCreditkessaiyouno(pCreditkessaiyouno);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenIT_UriageSkDataSyuKnr.URIAGENENGAPPI)
    public BizDate getUriagenengappi() {
        return getPrimaryKey().getUriagenengappi();
    }

    public void setUriagenengappi(BizDate pUriagenengappi) {
        getPrimaryKey().setUriagenengappi(pUriagenengappi);
    }

    @Id
    @Column(name=GenIT_UriageSkDataSyuKnr.RENNO3KETA)
    public Integer getRenno3keta() {
        return getPrimaryKey().getRenno3keta();
    }

    public void setRenno3keta(Integer pRenno3keta) {
        getPrimaryKey().setRenno3keta(pRenno3keta);
    }

    private BizDate credituriagekekkahaneiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_UriageSkDataSyuKnr.CREDITURIAGEKEKKAHANEIYMD)
    public BizDate getCredituriagekekkahaneiymd() {
        return credituriagekekkahaneiymd;
    }

    public void setCredituriagekekkahaneiymd(BizDate pCredituriagekekkahaneiymd) {
        credituriagekekkahaneiymd = pCredituriagekekkahaneiymd;
    }

    private Boolean credituragskkkmhnkkchkzmflg;

    @Type(type="BooleanType")
    @Column(name=GenIT_UriageSkDataSyuKnr.CREDITURAGSKKKMHNKKCHKZMFLG)
    public Boolean getCredituragskkkmhnkkchkzmflg() {
        return credituragskkkmhnkkchkzmflg;
    }

    public void setCredituragskkkmhnkkchkzmflg(Boolean pCredituragskkkmhnkkchkzmflg) {
        credituragskkkmhnkkchkzmflg = pCredituragskkkmhnkkchkzmflg;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_UriageSkDataSyuKnr.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_UriageSkDataSyuKnr.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_UriageSkDataSyuKnr.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}