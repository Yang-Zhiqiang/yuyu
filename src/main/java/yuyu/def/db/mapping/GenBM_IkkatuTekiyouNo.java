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
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.def.db.entity.BM_IkkatuTekiyouNo;
import yuyu.def.db.id.PKBM_IkkatuTekiyouNo;
import yuyu.def.db.meta.GenQBM_IkkatuTekiyouNo;
import yuyu.def.db.meta.QBM_IkkatuTekiyouNo;

/**
 * 一括払適用番号マスタ テーブルのマッピング情報クラスで、 {@link BM_IkkatuTekiyouNo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_IkkatuTekiyouNo}</td><td colspan="3">一括払適用番号マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_IkkatuTekiyouNo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRyouritusdno ryouritusdno}</td><td>料率世代番号</td><td align="center">{@link PKBM_IkkatuTekiyouNo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIkttekiyouno ikttekiyouno}</td><td>一括払適用番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     BM_IkkatuTekiyouNo
 * @see     PKBM_IkkatuTekiyouNo
 * @see     QBM_IkkatuTekiyouNo
 * @see     GenQBM_IkkatuTekiyouNo
 */
@MappedSuperclass
@Table(name=GenBM_IkkatuTekiyouNo.TABLE_NAME)
@IdClass(value=PKBM_IkkatuTekiyouNo.class)
public abstract class GenBM_IkkatuTekiyouNo extends AbstractExDBEntity<BM_IkkatuTekiyouNo, PKBM_IkkatuTekiyouNo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_IkkatuTekiyouNo";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String RYOURITUSDNO             = "ryouritusdno";
    public static final String IKTTEKIYOUNO             = "ikttekiyouno";

    private final PKBM_IkkatuTekiyouNo primaryKey;

    public GenBM_IkkatuTekiyouNo() {
        primaryKey = new PKBM_IkkatuTekiyouNo();
    }

    public GenBM_IkkatuTekiyouNo(String pSyouhncd, String pRyouritusdno) {
        primaryKey = new PKBM_IkkatuTekiyouNo(pSyouhncd, pRyouritusdno);
    }

    @Transient
    @Override
    public PKBM_IkkatuTekiyouNo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_IkkatuTekiyouNo> getMetaClass() {
        return QBM_IkkatuTekiyouNo.class;
    }

    @Id
    @Column(name=GenBM_IkkatuTekiyouNo.SYOUHNCD)
    @MaxLength(max=4)
    @SingleByteStrings
    public String getSyouhncd() {
        return getPrimaryKey().getSyouhncd();
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        getPrimaryKey().setSyouhncd(pSyouhncd);
    }

    @Id
    @Column(name=GenBM_IkkatuTekiyouNo.RYOURITUSDNO)
    public String getRyouritusdno() {
        return getPrimaryKey().getRyouritusdno();
    }

    public void setRyouritusdno(String pRyouritusdno) {
        getPrimaryKey().setRyouritusdno(pRyouritusdno);
    }

    private Integer ikttekiyouno;

    @Column(name=GenBM_IkkatuTekiyouNo.IKTTEKIYOUNO)
    public Integer getIkttekiyouno() {
        return ikttekiyouno;
    }

    public void setIkttekiyouno(Integer pIkttekiyouno) {
        ikttekiyouno = pIkttekiyouno;
    }
}