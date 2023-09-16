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
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_YuukouKbn;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.def.db.id.PKAS_KinouMode;
import yuyu.def.db.meta.GenQAS_KinouMode;
import yuyu.def.db.meta.QAS_KinouMode;
import yuyu.def.db.type.UserType_C_KahiKbn;
import yuyu.def.db.type.UserType_C_YuukouKbn;

/**
 * 機能モード基幹テーブル テーブルのマッピング情報クラスで、 {@link AS_KinouMode} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AS_KinouMode}</td><td colspan="3">機能モード基幹テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">{@link PKAS_KinouMode ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKinouModeId kinouModeId}</td><td>機能モードＩＤ</td><td align="center">{@link PKAS_KinouMode ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKinouModeNm kinouModeNm}</td><td>機能モード名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSortNo sortNo}</td><td>ソート番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getYuukouKbn yuukouKbn}</td><td>有効区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YuukouKbn}</td></tr>
 *  <tr><td>{@link #getYuukouKaisiYmd yuukouKaisiYmd}</td><td>有効開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKadouTimeGroupCd kadouTimeGroupCd}</td><td>稼働時間グループコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBatchHeisouKahiKbn batchHeisouKahiKbn}</td><td>バッチ並走可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KahiKbn}</td></tr>
 * </table>
 * @see     AS_KinouMode
 * @see     PKAS_KinouMode
 * @see     QAS_KinouMode
 * @see     GenQAS_KinouMode
 */
@MappedSuperclass
@Table(name=GenAS_KinouMode.TABLE_NAME)
@IdClass(value=PKAS_KinouMode.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_KahiKbn", typeClass=UserType_C_KahiKbn.class),
    @TypeDef(name="UserType_C_YuukouKbn", typeClass=UserType_C_YuukouKbn.class)
})
public abstract class GenAS_KinouMode extends AbstractExDBEntity<AS_KinouMode, PKAS_KinouMode> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AS_KinouMode";
    public static final String KINOUID                  = "kinouId";
    public static final String KINOUMODEID              = "kinouModeId";
    public static final String KINOUMODENM              = "kinouModeNm";
    public static final String SORTNO                   = "sortNo";
    public static final String YUUKOUKBN                = "yuukouKbn";
    public static final String YUUKOUKAISIYMD           = "yuukouKaisiYmd";
    public static final String KADOUTIMEGROUPCD         = "kadouTimeGroupCd";
    public static final String BATCHHEISOUKAHIKBN       = "batchHeisouKahiKbn";

    private final PKAS_KinouMode primaryKey;

    public GenAS_KinouMode() {
        primaryKey = new PKAS_KinouMode();
    }

    public GenAS_KinouMode(String pKinouId, String pKinouModeId) {
        primaryKey = new PKAS_KinouMode(pKinouId, pKinouModeId);
    }

    @Transient
    @Override
    public PKAS_KinouMode getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAS_KinouMode> getMetaClass() {
        return QAS_KinouMode.class;
    }

    @Id
    @Column(name=GenAS_KinouMode.KINOUID)
    public String getKinouId() {
        return getPrimaryKey().getKinouId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouId(String pKinouId) {
        getPrimaryKey().setKinouId(pKinouId);
    }

    @Id
    @Column(name=GenAS_KinouMode.KINOUMODEID)
    public String getKinouModeId() {
        return getPrimaryKey().getKinouModeId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouModeId(String pKinouModeId) {
        getPrimaryKey().setKinouModeId(pKinouModeId);
    }

    private String kinouModeNm;

    @Column(name=GenAS_KinouMode.KINOUMODENM)
    public String getKinouModeNm() {
        return kinouModeNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKinouModeNm(String pKinouModeNm) {
        kinouModeNm = pKinouModeNm;
    }

    private Integer sortNo;

    @Column(name=GenAS_KinouMode.SORTNO)
    public Integer getSortNo() {
        return sortNo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSortNo(Integer pSortNo) {
        sortNo = pSortNo;
    }

    private C_YuukouKbn yuukouKbn;

    @Type(type="UserType_C_YuukouKbn")
    @Column(name=GenAS_KinouMode.YUUKOUKBN)
    public C_YuukouKbn getYuukouKbn() {
        return yuukouKbn;
    }

    public void setYuukouKbn(C_YuukouKbn pYuukouKbn) {
        yuukouKbn = pYuukouKbn;
    }

    private BizDate yuukouKaisiYmd;

    @Type(type="BizDateType")
    @Column(name=GenAS_KinouMode.YUUKOUKAISIYMD)
    @ValidDate
    public BizDate getYuukouKaisiYmd() {
        return yuukouKaisiYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYuukouKaisiYmd(BizDate pYuukouKaisiYmd) {
        yuukouKaisiYmd = pYuukouKaisiYmd;
    }

    private String kadouTimeGroupCd;

    @Column(name=GenAS_KinouMode.KADOUTIMEGROUPCD)
    @MaxLength(max=20)
    @AlphaDigit
    public String getKadouTimeGroupCd() {
        return kadouTimeGroupCd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKadouTimeGroupCd(String pKadouTimeGroupCd) {
        kadouTimeGroupCd = pKadouTimeGroupCd;
    }

    private C_KahiKbn batchHeisouKahiKbn;

    @Type(type="UserType_C_KahiKbn")
    @Column(name=GenAS_KinouMode.BATCHHEISOUKAHIKBN)
    public C_KahiKbn getBatchHeisouKahiKbn() {
        return batchHeisouKahiKbn;
    }

    public void setBatchHeisouKahiKbn(C_KahiKbn pBatchHeisouKahiKbn) {
        batchHeisouKahiKbn = pBatchHeisouKahiKbn;
    }
}
