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
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.db.entity.BM_ChkKyuuhuKata;
import yuyu.def.db.id.PKBM_ChkKyuuhuKata;
import yuyu.def.db.meta.GenQBM_ChkKyuuhuKata;
import yuyu.def.db.meta.QBM_ChkKyuuhuKata;
import yuyu.def.db.type.UserType_C_KyhgndkataKbn;

/**
 * 給付型チェックマスタ テーブルのマッピング情報クラスで、 {@link BM_ChkKyuuhuKata} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkKyuuhuKata}</td><td colspan="3">給付型チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_ChkKyuuhuKata ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">{@link PKBM_ChkKyuuhuKata ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">{@link PKBM_ChkKyuuhuKata ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyhkatakbn kyhkatakbn}</td><td>給付型区分</td><td align="center">{@link PKBM_ChkKyuuhuKata ○}</td><td align="center">V</td><td>{@link C_KyhgndkataKbn}</td></tr>
 * </table>
 * @see     BM_ChkKyuuhuKata
 * @see     PKBM_ChkKyuuhuKata
 * @see     QBM_ChkKyuuhuKata
 * @see     GenQBM_ChkKyuuhuKata
 */
@MappedSuperclass
@Table(name=GenBM_ChkKyuuhuKata.TABLE_NAME)
@IdClass(value=PKBM_ChkKyuuhuKata.class)
@TypeDefs({
    @TypeDef(name="UserType_C_KyhgndkataKbn", typeClass=UserType_C_KyhgndkataKbn.class)
})
public abstract class GenBM_ChkKyuuhuKata extends AbstractExDBEntity<BM_ChkKyuuhuKata, PKBM_ChkKyuuhuKata> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ChkKyuuhuKata";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYUSYOUHNSDNOFROM        = "syusyouhnsdnofrom";
    public static final String SYUSYOUHNSDNOTO          = "syusyouhnsdnoto";
    public static final String KYHKATAKBN               = "kyhkatakbn";

    private final PKBM_ChkKyuuhuKata primaryKey;

    public GenBM_ChkKyuuhuKata() {
        primaryKey = new PKBM_ChkKyuuhuKata();
    }

    public GenBM_ChkKyuuhuKata(
        String pSyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        C_KyhgndkataKbn pKyhkatakbn
    ) {
        primaryKey = new PKBM_ChkKyuuhuKata(
            pSyouhncd,
            pSyusyouhnsdnofrom,
            pSyusyouhnsdnoto,
            pKyhkatakbn
        );
    }

    @Transient
    @Override
    public PKBM_ChkKyuuhuKata getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ChkKyuuhuKata> getMetaClass() {
        return QBM_ChkKyuuhuKata.class;
    }

    @Id
    @Column(name=GenBM_ChkKyuuhuKata.SYOUHNCD)
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
    @Column(name=GenBM_ChkKyuuhuKata.SYUSYOUHNSDNOFROM)
    public Integer getSyusyouhnsdnofrom() {
        return getPrimaryKey().getSyusyouhnsdnofrom();
    }

    public void setSyusyouhnsdnofrom(Integer pSyusyouhnsdnofrom) {
        getPrimaryKey().setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
    }

    @Id
    @Column(name=GenBM_ChkKyuuhuKata.SYUSYOUHNSDNOTO)
    public Integer getSyusyouhnsdnoto() {
        return getPrimaryKey().getSyusyouhnsdnoto();
    }

    public void setSyusyouhnsdnoto(Integer pSyusyouhnsdnoto) {
        getPrimaryKey().setSyusyouhnsdnoto(pSyusyouhnsdnoto);
    }

    @Id
    @Type(type="UserType_C_KyhgndkataKbn")
    @Column(name=GenBM_ChkKyuuhuKata.KYHKATAKBN)
    public C_KyhgndkataKbn getKyhkatakbn() {
        return getPrimaryKey().getKyhkatakbn();
    }

    public void setKyhkatakbn(C_KyhgndkataKbn pKyhkatakbn) {
        getPrimaryKey().setKyhkatakbn(pKyhkatakbn);
    }
}
