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
import yuyu.def.classification.C_Dbhanei;
import yuyu.def.db.entity.HW_CreditTrkNgList;
import yuyu.def.db.id.PKHW_CreditTrkNgList;
import yuyu.def.db.meta.GenQHW_CreditTrkNgList;
import yuyu.def.db.meta.QHW_CreditTrkNgList;
import yuyu.def.db.type.UserType_C_Dbhanei;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * クレジットカード会員登録ＮＧリストワークテーブル テーブルのマッピング情報クラスで、 {@link HW_CreditTrkNgList} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HW_CreditTrkNgList}</td><td colspan="3">クレジットカード会員登録ＮＧリストワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">{@link PKHW_CreditTrkNgList ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDatarenno datarenno}</td><td>データ連番</td><td align="center">{@link PKHW_CreditTrkNgList ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditqrerrorcd creditqrerrorcd}</td><td>クレジットカードＱＲエラーコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBluegateerrorcd bluegateerrorcd}</td><td>ＢｌｕｅＧａｔｅエラーコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDbhaneikbn dbhaneikbn}</td><td>ＤＢ反映区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Dbhanei}</td></tr>
 *  <tr><td>{@link #getCredittrkhaneierrriyuu credittrkhaneierrriyuu}</td><td>クレジットカード登録反映エラー理由</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HW_CreditTrkNgList
 * @see     PKHW_CreditTrkNgList
 * @see     QHW_CreditTrkNgList
 * @see     GenQHW_CreditTrkNgList
 */
@MappedSuperclass
@Table(name=GenHW_CreditTrkNgList.TABLE_NAME)
@IdClass(value=PKHW_CreditTrkNgList.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_Dbhanei", typeClass=UserType_C_Dbhanei.class)
})
public abstract class GenHW_CreditTrkNgList extends AbstractExDBEntity<HW_CreditTrkNgList, PKHW_CreditTrkNgList> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HW_CreditTrkNgList";
    public static final String TYOUHYOUYMD              = "tyouhyouymd";
    public static final String DATARENNO                = "datarenno";
    public static final String MOSNO                    = "mosno";
    public static final String CREDITKESSAIYOUNO        = "creditkessaiyouno";
    public static final String CREDITQRERRORCD          = "creditqrerrorcd";
    public static final String BLUEGATEERRORCD          = "bluegateerrorcd";
    public static final String DBHANEIKBN               = "dbhaneikbn";
    public static final String CREDITTRKHANEIERRRIYUU   = "credittrkhaneierrriyuu";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHW_CreditTrkNgList primaryKey;

    public GenHW_CreditTrkNgList() {
        primaryKey = new PKHW_CreditTrkNgList();
    }

    public GenHW_CreditTrkNgList(BizDate pTyouhyouymd, Integer pDatarenno) {
        primaryKey = new PKHW_CreditTrkNgList(pTyouhyouymd, pDatarenno);
    }

    @Transient
    @Override
    public PKHW_CreditTrkNgList getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHW_CreditTrkNgList> getMetaClass() {
        return QHW_CreditTrkNgList.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenHW_CreditTrkNgList.TYOUHYOUYMD)
    @ValidDate
    public BizDate getTyouhyouymd() {
        return getPrimaryKey().getTyouhyouymd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        getPrimaryKey().setTyouhyouymd(pTyouhyouymd);
    }

    @Id
    @Column(name=GenHW_CreditTrkNgList.DATARENNO)
    public Integer getDatarenno() {
        return getPrimaryKey().getDatarenno();
    }

    public void setDatarenno(Integer pDatarenno) {
        getPrimaryKey().setDatarenno(pDatarenno);
    }

    private String mosno;

    @Column(name=GenHW_CreditTrkNgList.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return mosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

    private String creditkessaiyouno;

    @Column(name=GenHW_CreditTrkNgList.CREDITKESSAIYOUNO)
    public String getCreditkessaiyouno() {
        return creditkessaiyouno;
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        creditkessaiyouno = pCreditkessaiyouno;
    }

    private String creditqrerrorcd;

    @Column(name=GenHW_CreditTrkNgList.CREDITQRERRORCD)
    public String getCreditqrerrorcd() {
        return creditqrerrorcd;
    }

    public void setCreditqrerrorcd(String pCreditqrerrorcd) {
        creditqrerrorcd = pCreditqrerrorcd;
    }

    private String bluegateerrorcd;

    @Column(name=GenHW_CreditTrkNgList.BLUEGATEERRORCD)
    public String getBluegateerrorcd() {
        return bluegateerrorcd;
    }

    public void setBluegateerrorcd(String pBluegateerrorcd) {
        bluegateerrorcd = pBluegateerrorcd;
    }

    private C_Dbhanei dbhaneikbn;

    @Type(type="UserType_C_Dbhanei")
    @Column(name=GenHW_CreditTrkNgList.DBHANEIKBN)
    public C_Dbhanei getDbhaneikbn() {
        return dbhaneikbn;
    }

    public void setDbhaneikbn(C_Dbhanei pDbhaneikbn) {
        dbhaneikbn = pDbhaneikbn;
    }

    private String credittrkhaneierrriyuu;

    @Column(name=GenHW_CreditTrkNgList.CREDITTRKHANEIERRRIYUU)
    public String getCredittrkhaneierrriyuu() {
        return credittrkhaneierrriyuu;
    }

    public void setCredittrkhaneierrriyuu(String pCredittrkhaneierrriyuu) {
        credittrkhaneierrriyuu = pCredittrkhaneierrriyuu;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHW_CreditTrkNgList.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHW_CreditTrkNgList.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}