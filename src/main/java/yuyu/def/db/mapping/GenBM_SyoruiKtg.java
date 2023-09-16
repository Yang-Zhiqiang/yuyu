package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.BM_SyoruiKtg;
import yuyu.def.db.id.PKBM_SyoruiKtg;
import yuyu.def.db.meta.GenQBM_SyoruiKtg;
import yuyu.def.db.meta.QBM_SyoruiKtg;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;

/**
 * 書類結合マスタ テーブルのマッピング情報クラスで、 {@link BM_SyoruiKtg} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_SyoruiKtg}</td><td colspan="3">書類結合マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">{@link PKBM_SyoruiKtg ○}</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getKtgsyoruicd ktgsyoruicd}</td><td>結合対象書類コード</td><td align="center">{@link PKBM_SyoruiKtg ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSortNo sortNo}</td><td>ソート番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     BM_SyoruiKtg
 * @see     PKBM_SyoruiKtg
 * @see     QBM_SyoruiKtg
 * @see     GenQBM_SyoruiKtg
 */
@MappedSuperclass
@Table(name=GenBM_SyoruiKtg.TABLE_NAME)
@IdClass(value=PKBM_SyoruiKtg.class)
@TypeDefs({
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class)
})
public abstract class GenBM_SyoruiKtg extends AbstractExDBEntity<BM_SyoruiKtg, PKBM_SyoruiKtg> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_SyoruiKtg";
    public static final String SYORUICD                 = "syoruiCd";
    public static final String KTGSYORUICD              = "ktgsyoruicd";
    public static final String SORTNO                   = "sortNo";

    private final PKBM_SyoruiKtg primaryKey;

    public GenBM_SyoruiKtg() {
        primaryKey = new PKBM_SyoruiKtg();
    }

    public GenBM_SyoruiKtg(C_SyoruiCdKbn pSyoruiCd, String pKtgsyoruicd) {
        primaryKey = new PKBM_SyoruiKtg(pSyoruiCd, pKtgsyoruicd);
    }

    @Transient
    @Override
    public PKBM_SyoruiKtg getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_SyoruiKtg> getMetaClass() {
        return QBM_SyoruiKtg.class;
    }

    @Id
    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenBM_SyoruiKtg.SYORUICD)
    public C_SyoruiCdKbn getSyoruiCd() {
        return getPrimaryKey().getSyoruiCd();
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        getPrimaryKey().setSyoruiCd(pSyoruiCd);
    }

    @Id
    @Column(name=GenBM_SyoruiKtg.KTGSYORUICD)
    public String getKtgsyoruicd() {
        return getPrimaryKey().getKtgsyoruicd();
    }

    public void setKtgsyoruicd(String pKtgsyoruicd) {
        getPrimaryKey().setKtgsyoruicd(pKtgsyoruicd);
    }

    private Integer sortNo;

    @Column(name=GenBM_SyoruiKtg.SORTNO)
    public Integer getSortNo() {
        return sortNo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSortNo(Integer pSortNo) {
        sortNo = pSortNo;
    }
}