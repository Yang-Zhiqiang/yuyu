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
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_CreditTrkhouKbn;
import yuyu.def.db.entity.HW_CreditTrkHaneierrList;
import yuyu.def.db.id.PKHW_CreditTrkHaneierrList;
import yuyu.def.db.meta.GenQHW_CreditTrkHaneierrList;
import yuyu.def.db.meta.QHW_CreditTrkHaneierrList;
import yuyu.def.db.type.UserType_C_CreditTrkhouKbn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * クレジットカード登録反映エラーリストワークテーブル テーブルのマッピング情報クラスで、 {@link HW_CreditTrkHaneierrList} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HW_CreditTrkHaneierrList}</td><td colspan="3">クレジットカード登録反映エラーリストワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">{@link PKHW_CreditTrkHaneierrList ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDatarenno datarenno}</td><td>データ連番</td><td align="center">{@link PKHW_CreditTrkHaneierrList ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCredittrkhoukbn credittrkhoukbn}</td><td>クレジットカード登録方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_CreditTrkhouKbn}</td></tr>
 *  <tr><td>{@link #getSosikicd sosikicd}</td><td>組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCredittrkhaneierrriyuu credittrkhaneierrriyuu}</td><td>クレジットカード登録反映エラー理由</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HW_CreditTrkHaneierrList
 * @see     PKHW_CreditTrkHaneierrList
 * @see     QHW_CreditTrkHaneierrList
 * @see     GenQHW_CreditTrkHaneierrList
 */
@MappedSuperclass
@Table(name=GenHW_CreditTrkHaneierrList.TABLE_NAME)
@IdClass(value=PKHW_CreditTrkHaneierrList.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_CreditTrkhouKbn", typeClass=UserType_C_CreditTrkhouKbn.class)
})
public abstract class GenHW_CreditTrkHaneierrList extends AbstractExDBEntity<HW_CreditTrkHaneierrList, PKHW_CreditTrkHaneierrList> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HW_CreditTrkHaneierrList";
    public static final String TYOUHYOUYMD              = "tyouhyouymd";
    public static final String DATARENNO                = "datarenno";
    public static final String MOSNO                    = "mosno";
    public static final String CREDITTRKHOUKBN          = "credittrkhoukbn";
    public static final String SOSIKICD                 = "sosikicd";
    public static final String CREDITKESSAIYOUNO        = "creditkessaiyouno";
    public static final String CREDITTRKHANEIERRRIYUU   = "credittrkhaneierrriyuu";

    private final PKHW_CreditTrkHaneierrList primaryKey;

    public GenHW_CreditTrkHaneierrList() {
        primaryKey = new PKHW_CreditTrkHaneierrList();
    }

    public GenHW_CreditTrkHaneierrList(BizDate pTyouhyouymd, Integer pDatarenno) {
        primaryKey = new PKHW_CreditTrkHaneierrList(pTyouhyouymd, pDatarenno);
    }

    @Transient
    @Override
    public PKHW_CreditTrkHaneierrList getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHW_CreditTrkHaneierrList> getMetaClass() {
        return QHW_CreditTrkHaneierrList.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenHW_CreditTrkHaneierrList.TYOUHYOUYMD)
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
    @Column(name=GenHW_CreditTrkHaneierrList.DATARENNO)
    public Integer getDatarenno() {
        return getPrimaryKey().getDatarenno();
    }

    public void setDatarenno(Integer pDatarenno) {
        getPrimaryKey().setDatarenno(pDatarenno);
    }

    private String mosno;

    @Column(name=GenHW_CreditTrkHaneierrList.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return mosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

    private C_CreditTrkhouKbn credittrkhoukbn;

    @Type(type="UserType_C_CreditTrkhouKbn")
    @Column(name=GenHW_CreditTrkHaneierrList.CREDITTRKHOUKBN)
    public C_CreditTrkhouKbn getCredittrkhoukbn() {
        return credittrkhoukbn;
    }

    public void setCredittrkhoukbn(C_CreditTrkhouKbn pCredittrkhoukbn) {
        credittrkhoukbn = pCredittrkhoukbn;
    }

    private String sosikicd;

    @Column(name=GenHW_CreditTrkHaneierrList.SOSIKICD)
    @MaxLength(max=7)
    @AlphaDigit
    public String getSosikicd() {
        return sosikicd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSosikicd(String pSosikicd) {
        sosikicd = pSosikicd;
    }

    private String creditkessaiyouno;

    @Column(name=GenHW_CreditTrkHaneierrList.CREDITKESSAIYOUNO)
    public String getCreditkessaiyouno() {
        return creditkessaiyouno;
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        creditkessaiyouno = pCreditkessaiyouno;
    }

    private String credittrkhaneierrriyuu;

    @Column(name=GenHW_CreditTrkHaneierrList.CREDITTRKHANEIERRRIYUU)
    public String getCredittrkhaneierrriyuu() {
        return credittrkhaneierrriyuu;
    }

    public void setCredittrkhaneierrriyuu(String pCredittrkhaneierrriyuu) {
        credittrkhaneierrriyuu = pCredittrkhaneierrriyuu;
    }
}