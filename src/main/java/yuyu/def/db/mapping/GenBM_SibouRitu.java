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
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.db.entity.BM_SibouRitu;
import yuyu.def.db.id.PKBM_SibouRitu;
import yuyu.def.db.meta.GenQBM_SibouRitu;
import yuyu.def.db.meta.QBM_SibouRitu;
import yuyu.def.db.type.UserType_C_Seibetu;

/**
 * 死亡率マスタ テーブルのマッピング情報クラスで、 {@link BM_SibouRitu} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_SibouRitu}</td><td colspan="3">死亡率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getRyouritusdno ryouritusdno}</td><td>料率世代番号</td><td align="center">{@link PKBM_SibouRitu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeibetu seibetu}</td><td>性別</td><td align="center">{@link PKBM_SibouRitu ○}</td><td align="center">V</td><td>{@link C_Seibetu}</td></tr>
 *  <tr><td>{@link #getNenrei nenrei}</td><td>年齢</td><td align="center">{@link PKBM_SibouRitu ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSibouritu1 sibouritu1}</td><td>死亡率１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSibouritu2 sibouritu2}</td><td>死亡率２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKaiyakuritu1 kaiyakuritu1}</td><td>解約率１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_SibouRitu
 * @see     PKBM_SibouRitu
 * @see     QBM_SibouRitu
 * @see     GenQBM_SibouRitu
 */
@MappedSuperclass
@Table(name=GenBM_SibouRitu.TABLE_NAME)
@IdClass(value=PKBM_SibouRitu.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Seibetu", typeClass=UserType_C_Seibetu.class)
})
public abstract class GenBM_SibouRitu extends AbstractExDBEntity<BM_SibouRitu, PKBM_SibouRitu> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_SibouRitu";
    public static final String RYOURITUSDNO             = "ryouritusdno";
    public static final String SEIBETU                  = "seibetu";
    public static final String NENREI                   = "nenrei";
    public static final String SIBOURITU1               = "sibouritu1";
    public static final String SIBOURITU2               = "sibouritu2";
    public static final String KAIYAKURITU1             = "kaiyakuritu1";

    private final PKBM_SibouRitu primaryKey;

    public GenBM_SibouRitu() {
        primaryKey = new PKBM_SibouRitu();
    }

    public GenBM_SibouRitu(
        String pRyouritusdno,
        C_Seibetu pSeibetu,
        Integer pNenrei
    ) {
        primaryKey = new PKBM_SibouRitu(
            pRyouritusdno,
            pSeibetu,
            pNenrei
        );
    }

    @Transient
    @Override
    public PKBM_SibouRitu getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_SibouRitu> getMetaClass() {
        return QBM_SibouRitu.class;
    }

    @Id
    @Column(name=GenBM_SibouRitu.RYOURITUSDNO)
    public String getRyouritusdno() {
        return getPrimaryKey().getRyouritusdno();
    }

    public void setRyouritusdno(String pRyouritusdno) {
        getPrimaryKey().setRyouritusdno(pRyouritusdno);
    }

    @Id
    @Type(type="UserType_C_Seibetu")
    @Column(name=GenBM_SibouRitu.SEIBETU)
    public C_Seibetu getSeibetu() {
        return getPrimaryKey().getSeibetu();
    }

    public void setSeibetu(C_Seibetu pSeibetu) {
        getPrimaryKey().setSeibetu(pSeibetu);
    }

    @Id
    @Column(name=GenBM_SibouRitu.NENREI)
    public Integer getNenrei() {
        return getPrimaryKey().getNenrei();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNenrei(Integer pNenrei) {
        getPrimaryKey().setNenrei(pNenrei);
    }

    private BizNumber sibouritu1;

    @Type(type="BizNumberType")
    @Column(name=GenBM_SibouRitu.SIBOURITU1)
    public BizNumber getSibouritu1() {
        return sibouritu1;
    }

    public void setSibouritu1(BizNumber pSibouritu1) {
        sibouritu1 = pSibouritu1;
    }

    private BizNumber sibouritu2;

    @Type(type="BizNumberType")
    @Column(name=GenBM_SibouRitu.SIBOURITU2)
    public BizNumber getSibouritu2() {
        return sibouritu2;
    }

    public void setSibouritu2(BizNumber pSibouritu2) {
        sibouritu2 = pSibouritu2;
    }

    private BizNumber kaiyakuritu1;

    @Type(type="BizNumberType")
    @Column(name=GenBM_SibouRitu.KAIYAKURITU1)
    public BizNumber getKaiyakuritu1() {
        return kaiyakuritu1;
    }

    public void setKaiyakuritu1(BizNumber pKaiyakuritu1) {
        kaiyakuritu1 = pKaiyakuritu1;
    }
}