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
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.db.entity.BM_ChkKhnKyhKgBairitu;
import yuyu.def.db.id.PKBM_ChkKhnKyhKgBairitu;
import yuyu.def.db.meta.GenQBM_ChkKhnKyhKgBairitu;
import yuyu.def.db.meta.QBM_ChkKhnKyhKgBairitu;
import yuyu.def.db.type.UserType_C_KhnkyhkgbairituKbn;

/**
 * 基本給付金額倍率チェックマスタ テーブルのマッピング情報クラスで、 {@link BM_ChkKhnKyhKgBairitu} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkKhnKyhKgBairitu}</td><td colspan="3">基本給付金額倍率チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_ChkKhnKyhKgBairitu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">{@link PKBM_ChkKhnKyhKgBairitu ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">{@link PKBM_ChkKhnKyhKgBairitu ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKhnkyhkgbairitukbn khnkyhkgbairitukbn}</td><td>基本給付金額倍率区分</td><td align="center">{@link PKBM_ChkKhnKyhKgBairitu ○}</td><td align="center">V</td><td>{@link C_KhnkyhkgbairituKbn}</td></tr>
 * </table>
 * @see     BM_ChkKhnKyhKgBairitu
 * @see     PKBM_ChkKhnKyhKgBairitu
 * @see     QBM_ChkKhnKyhKgBairitu
 * @see     GenQBM_ChkKhnKyhKgBairitu
 */
@MappedSuperclass
@Table(name=GenBM_ChkKhnKyhKgBairitu.TABLE_NAME)
@IdClass(value=PKBM_ChkKhnKyhKgBairitu.class)
@TypeDefs({
    @TypeDef(name="UserType_C_KhnkyhkgbairituKbn", typeClass=UserType_C_KhnkyhkgbairituKbn.class)
})
public abstract class GenBM_ChkKhnKyhKgBairitu extends AbstractExDBEntity<BM_ChkKhnKyhKgBairitu, PKBM_ChkKhnKyhKgBairitu> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ChkKhnKyhKgBairitu";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYUSYOUHNSDNOFROM        = "syusyouhnsdnofrom";
    public static final String SYUSYOUHNSDNOTO          = "syusyouhnsdnoto";
    public static final String KHNKYHKGBAIRITUKBN       = "khnkyhkgbairitukbn";

    private final PKBM_ChkKhnKyhKgBairitu primaryKey;

    public GenBM_ChkKhnKyhKgBairitu() {
        primaryKey = new PKBM_ChkKhnKyhKgBairitu();
    }

    public GenBM_ChkKhnKyhKgBairitu(
        String pSyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        C_KhnkyhkgbairituKbn pKhnkyhkgbairitukbn
    ) {
        primaryKey = new PKBM_ChkKhnKyhKgBairitu(
            pSyouhncd,
            pSyusyouhnsdnofrom,
            pSyusyouhnsdnoto,
            pKhnkyhkgbairitukbn
        );
    }

    @Transient
    @Override
    public PKBM_ChkKhnKyhKgBairitu getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ChkKhnKyhKgBairitu> getMetaClass() {
        return QBM_ChkKhnKyhKgBairitu.class;
    }

    @Id
    @Column(name=GenBM_ChkKhnKyhKgBairitu.SYOUHNCD)
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
    @Column(name=GenBM_ChkKhnKyhKgBairitu.SYUSYOUHNSDNOFROM)
    public Integer getSyusyouhnsdnofrom() {
        return getPrimaryKey().getSyusyouhnsdnofrom();
    }

    public void setSyusyouhnsdnofrom(Integer pSyusyouhnsdnofrom) {
        getPrimaryKey().setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
    }

    @Id
    @Column(name=GenBM_ChkKhnKyhKgBairitu.SYUSYOUHNSDNOTO)
    public Integer getSyusyouhnsdnoto() {
        return getPrimaryKey().getSyusyouhnsdnoto();
    }

    public void setSyusyouhnsdnoto(Integer pSyusyouhnsdnoto) {
        getPrimaryKey().setSyusyouhnsdnoto(pSyusyouhnsdnoto);
    }

    @Id
    @Type(type="UserType_C_KhnkyhkgbairituKbn")
    @Column(name=GenBM_ChkKhnKyhKgBairitu.KHNKYHKGBAIRITUKBN)
    public C_KhnkyhkgbairituKbn getKhnkyhkgbairitukbn() {
        return getPrimaryKey().getKhnkyhkgbairitukbn();
    }

    public void setKhnkyhkgbairitukbn(C_KhnkyhkgbairituKbn pKhnkyhkgbairitukbn) {
        getPrimaryKey().setKhnkyhkgbairitukbn(pKhnkyhkgbairitukbn);
    }
}
