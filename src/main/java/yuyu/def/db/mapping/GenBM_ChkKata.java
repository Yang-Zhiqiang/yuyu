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
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_ChkKata;
import yuyu.def.db.id.PKBM_ChkKata;
import yuyu.def.db.meta.GenQBM_ChkKata;
import yuyu.def.db.meta.QBM_ChkKata;
import yuyu.def.db.type.UserType_C_KataKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 型区分チェックマスタ テーブルのマッピング情報クラスで、 {@link BM_ChkKata} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkKata}</td><td colspan="3">型区分チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_ChkKata ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">{@link PKBM_ChkKata ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">{@link PKBM_ChkKata ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTktanbrumu tktanbrumu}</td><td>特約短期払有無</td><td align="center">{@link PKBM_ChkKata ○}</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKatakbn katakbn}</td><td>型区分</td><td align="center">{@link PKBM_ChkKata ○}</td><td align="center">V</td><td>{@link C_KataKbn}</td></tr>
 * </table>
 * @see     BM_ChkKata
 * @see     PKBM_ChkKata
 * @see     QBM_ChkKata
 * @see     GenQBM_ChkKata
 */
@MappedSuperclass
@Table(name=GenBM_ChkKata.TABLE_NAME)
@IdClass(value=PKBM_ChkKata.class)
@TypeDefs({
    @TypeDef(name="UserType_C_KataKbn", typeClass=UserType_C_KataKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenBM_ChkKata extends AbstractExDBEntity<BM_ChkKata, PKBM_ChkKata> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ChkKata";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYUSYOUHNSDNOFROM        = "syusyouhnsdnofrom";
    public static final String SYUSYOUHNSDNOTO          = "syusyouhnsdnoto";
    public static final String TKTANBRUMU               = "tktanbrumu";
    public static final String KATAKBN                  = "katakbn";

    private final PKBM_ChkKata primaryKey;

    public GenBM_ChkKata() {
        primaryKey = new PKBM_ChkKata();
    }

    public GenBM_ChkKata(
        String pSyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        C_UmuKbn pTktanbrumu,
        C_KataKbn pKatakbn
    ) {
        primaryKey = new PKBM_ChkKata(
            pSyouhncd,
            pSyusyouhnsdnofrom,
            pSyusyouhnsdnoto,
            pTktanbrumu,
            pKatakbn
        );
    }

    @Transient
    @Override
    public PKBM_ChkKata getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ChkKata> getMetaClass() {
        return QBM_ChkKata.class;
    }

    @Id
    @Column(name=GenBM_ChkKata.SYOUHNCD)
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
    @Column(name=GenBM_ChkKata.SYUSYOUHNSDNOFROM)
    public Integer getSyusyouhnsdnofrom() {
        return getPrimaryKey().getSyusyouhnsdnofrom();
    }

    public void setSyusyouhnsdnofrom(Integer pSyusyouhnsdnofrom) {
        getPrimaryKey().setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
    }

    @Id
    @Column(name=GenBM_ChkKata.SYUSYOUHNSDNOTO)
    public Integer getSyusyouhnsdnoto() {
        return getPrimaryKey().getSyusyouhnsdnoto();
    }

    public void setSyusyouhnsdnoto(Integer pSyusyouhnsdnoto) {
        getPrimaryKey().setSyusyouhnsdnoto(pSyusyouhnsdnoto);
    }

    @Id
    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_ChkKata.TKTANBRUMU)
    public C_UmuKbn getTktanbrumu() {
        return getPrimaryKey().getTktanbrumu();
    }

    public void setTktanbrumu(C_UmuKbn pTktanbrumu) {
        getPrimaryKey().setTktanbrumu(pTktanbrumu);
    }

    @Id
    @Type(type="UserType_C_KataKbn")
    @Column(name=GenBM_ChkKata.KATAKBN)
    public C_KataKbn getKatakbn() {
        return getPrimaryKey().getKatakbn();
    }

    public void setKatakbn(C_KataKbn pKatakbn) {
        getPrimaryKey().setKatakbn(pKatakbn);
    }
}
