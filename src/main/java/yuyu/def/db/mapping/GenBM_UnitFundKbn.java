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
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.BM_UnitFundKbn;
import yuyu.def.db.id.PKBM_UnitFundKbn;
import yuyu.def.db.meta.GenQBM_UnitFundKbn;
import yuyu.def.db.meta.QBM_UnitFundKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UnitFundKbn;

/**
 * ユニットファンド区分マスタ テーブルのマッピング情報クラスで、 {@link BM_UnitFundKbn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_UnitFundKbn}</td><td colspan="3">ユニットファンド区分マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_UnitFundKbn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">{@link PKBM_UnitFundKbn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">{@link PKBM_UnitFundKbn ○}</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKBM_UnitFundKbn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getUnitfundkbn unitfundkbn}</td><td>ユニットファンド区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UnitFundKbn}</td></tr>
 * </table>
 * @see     BM_UnitFundKbn
 * @see     PKBM_UnitFundKbn
 * @see     QBM_UnitFundKbn
 * @see     GenQBM_UnitFundKbn
 */
@MappedSuperclass
@Table(name=GenBM_UnitFundKbn.TABLE_NAME)
@IdClass(value=PKBM_UnitFundKbn.class)
@TypeDefs({
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UnitFundKbn", typeClass=UserType_C_UnitFundKbn.class)
})
public abstract class GenBM_UnitFundKbn extends AbstractExDBEntity<BM_UnitFundKbn, PKBM_UnitFundKbn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_UnitFundKbn";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String TUUKASYU                 = "tuukasyu";
    public static final String RENNO                    = "renno";
    public static final String UNITFUNDKBN              = "unitfundkbn";

    private final PKBM_UnitFundKbn primaryKey;

    public GenBM_UnitFundKbn() {
        primaryKey = new PKBM_UnitFundKbn();
    }

    public GenBM_UnitFundKbn(
        String pSyouhncd,
        Integer pSyouhnsdno,
        C_Tuukasyu pTuukasyu,
        Integer pRenno
    ) {
        primaryKey = new PKBM_UnitFundKbn(
            pSyouhncd,
            pSyouhnsdno,
            pTuukasyu,
            pRenno
        );
    }

    @Transient
    @Override
    public PKBM_UnitFundKbn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_UnitFundKbn> getMetaClass() {
        return QBM_UnitFundKbn.class;
    }

    @Id
    @Column(name=GenBM_UnitFundKbn.SYOUHNCD)
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
    @Column(name=GenBM_UnitFundKbn.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return getPrimaryKey().getSyouhnsdno();
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        getPrimaryKey().setSyouhnsdno(pSyouhnsdno);
    }

    @Id
    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBM_UnitFundKbn.TUUKASYU)
    public C_Tuukasyu getTuukasyu() {
        return getPrimaryKey().getTuukasyu();
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        getPrimaryKey().setTuukasyu(pTuukasyu);
    }

    @Id
    @Column(name=GenBM_UnitFundKbn.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private C_UnitFundKbn unitfundkbn;

    @Type(type="UserType_C_UnitFundKbn")
    @Column(name=GenBM_UnitFundKbn.UNITFUNDKBN)
    public C_UnitFundKbn getUnitfundkbn() {
        return unitfundkbn;
    }

    public void setUnitfundkbn(C_UnitFundKbn pUnitfundkbn) {
        unitfundkbn = pUnitfundkbn;
    }
}
