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
import yuyu.def.classification.C_KataKbn;
import yuyu.def.db.entity.BM_KyhNitigakuBairitu;
import yuyu.def.db.id.PKBM_KyhNitigakuBairitu;
import yuyu.def.db.meta.GenQBM_KyhNitigakuBairitu;
import yuyu.def.db.meta.QBM_KyhNitigakuBairitu;
import yuyu.def.db.type.UserType_C_KataKbn;

/**
 * 給付日額倍率マスタ テーブルのマッピング情報クラスで、 {@link BM_KyhNitigakuBairitu} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_KyhNitigakuBairitu}</td><td colspan="3">給付日額倍率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_KyhNitigakuBairitu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">{@link PKBM_KyhNitigakuBairitu ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKatakbn katakbn}</td><td>型区分</td><td align="center">{@link PKBM_KyhNitigakuBairitu ○}</td><td align="center">V</td><td>{@link C_KataKbn}</td></tr>
 *  <tr><td>{@link #getKyhngbairitu kyhngbairitu}</td><td>給付日額倍率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_KyhNitigakuBairitu
 * @see     PKBM_KyhNitigakuBairitu
 * @see     QBM_KyhNitigakuBairitu
 * @see     GenQBM_KyhNitigakuBairitu
 */
@MappedSuperclass
@Table(name=GenBM_KyhNitigakuBairitu.TABLE_NAME)
@IdClass(value=PKBM_KyhNitigakuBairitu.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_KataKbn", typeClass=UserType_C_KataKbn.class)
})
public abstract class GenBM_KyhNitigakuBairitu extends AbstractExDBEntity<BM_KyhNitigakuBairitu, PKBM_KyhNitigakuBairitu> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_KyhNitigakuBairitu";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String KATAKBN                  = "katakbn";
    public static final String KYHNGBAIRITU             = "kyhngbairitu";

    private final PKBM_KyhNitigakuBairitu primaryKey;

    public GenBM_KyhNitigakuBairitu() {
        primaryKey = new PKBM_KyhNitigakuBairitu();
    }

    public GenBM_KyhNitigakuBairitu(
        String pSyouhncd,
        Integer pSyouhnsdno,
        C_KataKbn pKatakbn
    ) {
        primaryKey = new PKBM_KyhNitigakuBairitu(
            pSyouhncd,
            pSyouhnsdno,
            pKatakbn
        );
    }

    @Transient
    @Override
    public PKBM_KyhNitigakuBairitu getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_KyhNitigakuBairitu> getMetaClass() {
        return QBM_KyhNitigakuBairitu.class;
    }

    @Id
    @Column(name=GenBM_KyhNitigakuBairitu.SYOUHNCD)
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
    @Column(name=GenBM_KyhNitigakuBairitu.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return getPrimaryKey().getSyouhnsdno();
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        getPrimaryKey().setSyouhnsdno(pSyouhnsdno);
    }

    @Id
    @Type(type="UserType_C_KataKbn")
    @Column(name=GenBM_KyhNitigakuBairitu.KATAKBN)
    public C_KataKbn getKatakbn() {
        return getPrimaryKey().getKatakbn();
    }

    public void setKatakbn(C_KataKbn pKatakbn) {
        getPrimaryKey().setKatakbn(pKatakbn);
    }

    private BizNumber kyhngbairitu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_KyhNitigakuBairitu.KYHNGBAIRITU)
    public BizNumber getKyhngbairitu() {
        return kyhngbairitu;
    }

    public void setKyhngbairitu(BizNumber pKyhngbairitu) {
        kyhngbairitu = pKyhngbairitu;
    }
}
