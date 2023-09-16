package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_IkkatuTekiyouNo2;
import yuyu.def.db.id.PKBM_IkkatuTekiyouNo2;
import yuyu.def.db.meta.GenQBM_IkkatuTekiyouNo2;
import yuyu.def.db.meta.QBM_IkkatuTekiyouNo2;

/**
 * 一括払適用番号マスタ２ テーブルのマッピング情報クラスで、 {@link BM_IkkatuTekiyouNo2} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_IkkatuTekiyouNo2}</td><td colspan="3">一括払適用番号マスタ２</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_IkkatuTekiyouNo2 ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRyouritusdno ryouritusdno}</td><td>料率世代番号</td><td align="center">{@link PKBM_IkkatuTekiyouNo2 ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYoteiriritu yoteiriritu}</td><td>予定利率</td><td align="center">{@link PKBM_IkkatuTekiyouNo2 ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getIkttekiyoubr1 ikttekiyoubr1}</td><td>一括払適用分類１</td><td align="center">{@link PKBM_IkkatuTekiyouNo2 ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIkttekiyoubr2 ikttekiyoubr2}</td><td>一括払適用分類２</td><td align="center">{@link PKBM_IkkatuTekiyouNo2 ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIkttekiyoubr3 ikttekiyoubr3}</td><td>一括払適用分類３</td><td align="center">{@link PKBM_IkkatuTekiyouNo2 ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIkttekiyouno ikttekiyouno}</td><td>一括払適用番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     BM_IkkatuTekiyouNo2
 * @see     PKBM_IkkatuTekiyouNo2
 * @see     QBM_IkkatuTekiyouNo2
 * @see     GenQBM_IkkatuTekiyouNo2
 */
@MappedSuperclass
@Table(name=GenBM_IkkatuTekiyouNo2.TABLE_NAME)
@IdClass(value=PKBM_IkkatuTekiyouNo2.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenBM_IkkatuTekiyouNo2 extends AbstractExDBEntity<BM_IkkatuTekiyouNo2, PKBM_IkkatuTekiyouNo2> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_IkkatuTekiyouNo2";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String RYOURITUSDNO             = "ryouritusdno";
    public static final String YOTEIRIRITU              = "yoteiriritu";
    public static final String IKTTEKIYOUBR1            = "ikttekiyoubr1";
    public static final String IKTTEKIYOUBR2            = "ikttekiyoubr2";
    public static final String IKTTEKIYOUBR3            = "ikttekiyoubr3";
    public static final String IKTTEKIYOUNO             = "ikttekiyouno";

    private final PKBM_IkkatuTekiyouNo2 primaryKey;

    public GenBM_IkkatuTekiyouNo2() {
        primaryKey = new PKBM_IkkatuTekiyouNo2();
    }

    public GenBM_IkkatuTekiyouNo2(
        String pSyouhncd,
        String pRyouritusdno,
        BizNumber pYoteiriritu,
        String pIkttekiyoubr1,
        String pIkttekiyoubr2,
        String pIkttekiyoubr3
    ) {
        primaryKey = new PKBM_IkkatuTekiyouNo2(
            pSyouhncd,
            pRyouritusdno,
            pYoteiriritu,
            pIkttekiyoubr1,
            pIkttekiyoubr2,
            pIkttekiyoubr3
        );
    }

    @Transient
    @Override
    public PKBM_IkkatuTekiyouNo2 getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_IkkatuTekiyouNo2> getMetaClass() {
        return QBM_IkkatuTekiyouNo2.class;
    }

    @Id
    @Column(name=GenBM_IkkatuTekiyouNo2.SYOUHNCD)
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
    @Column(name=GenBM_IkkatuTekiyouNo2.RYOURITUSDNO)
    public String getRyouritusdno() {
        return getPrimaryKey().getRyouritusdno();
    }

    public void setRyouritusdno(String pRyouritusdno) {
        getPrimaryKey().setRyouritusdno(pRyouritusdno);
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_IkkatuTekiyouNo2.YOTEIRIRITU)
    public BizNumber getYoteiriritu() {
        return getPrimaryKey().getYoteiriritu();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYoteiriritu(BizNumber pYoteiriritu) {
        getPrimaryKey().setYoteiriritu(pYoteiriritu);
    }

    @Id
    @Column(name=GenBM_IkkatuTekiyouNo2.IKTTEKIYOUBR1)
    public String getIkttekiyoubr1() {
        return getPrimaryKey().getIkttekiyoubr1();
    }

    public void setIkttekiyoubr1(String pIkttekiyoubr1) {
        getPrimaryKey().setIkttekiyoubr1(pIkttekiyoubr1);
    }

    @Id
    @Column(name=GenBM_IkkatuTekiyouNo2.IKTTEKIYOUBR2)
    public String getIkttekiyoubr2() {
        return getPrimaryKey().getIkttekiyoubr2();
    }

    public void setIkttekiyoubr2(String pIkttekiyoubr2) {
        getPrimaryKey().setIkttekiyoubr2(pIkttekiyoubr2);
    }

    @Id
    @Column(name=GenBM_IkkatuTekiyouNo2.IKTTEKIYOUBR3)
    public String getIkttekiyoubr3() {
        return getPrimaryKey().getIkttekiyoubr3();
    }

    public void setIkttekiyoubr3(String pIkttekiyoubr3) {
        getPrimaryKey().setIkttekiyoubr3(pIkttekiyoubr3);
    }

    private Integer ikttekiyouno;

    @Column(name=GenBM_IkkatuTekiyouNo2.IKTTEKIYOUNO)
    public Integer getIkttekiyouno() {
        return ikttekiyouno;
    }

    public void setIkttekiyouno(Integer pIkttekiyouno) {
        ikttekiyouno = pIkttekiyouno;
    }
}