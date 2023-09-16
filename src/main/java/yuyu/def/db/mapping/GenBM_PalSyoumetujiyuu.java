package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_BetukutiKeiyakuKbn;
import yuyu.def.db.entity.BM_PalSyoumetujiyuu;
import yuyu.def.db.id.PKBM_PalSyoumetujiyuu;
import yuyu.def.db.meta.GenQBM_PalSyoumetujiyuu;
import yuyu.def.db.meta.QBM_PalSyoumetujiyuu;
import yuyu.def.db.type.UserType_C_BetukutiKeiyakuKbn;

/**
 * ＰＡＬ消滅事由マスタ テーブルのマッピング情報クラスで、 {@link BM_PalSyoumetujiyuu} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_PalSyoumetujiyuu}</td><td colspan="3">ＰＡＬ消滅事由マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getPalsyoumetucd palsyoumetucd}</td><td>ＰＡＬ消滅コード</td><td align="center">{@link PKBM_PalSyoumetujiyuu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBetukutikeiyakukbn betukutikeiyakukbn}</td><td>別口契約区分</td><td align="center">{@link PKBM_PalSyoumetujiyuu ○}</td><td align="center">V</td><td>{@link C_BetukutiKeiyakuKbn}</td></tr>
 *  <tr><td>{@link #getSyoumetujiyuuname syoumetujiyuuname}</td><td>消滅事由名称</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_PalSyoumetujiyuu
 * @see     PKBM_PalSyoumetujiyuu
 * @see     QBM_PalSyoumetujiyuu
 * @see     GenQBM_PalSyoumetujiyuu
 */
@MappedSuperclass
@Table(name=GenBM_PalSyoumetujiyuu.TABLE_NAME)
@IdClass(value=PKBM_PalSyoumetujiyuu.class)
@TypeDefs({
    @TypeDef(name="UserType_C_BetukutiKeiyakuKbn", typeClass=UserType_C_BetukutiKeiyakuKbn.class)
})
public abstract class GenBM_PalSyoumetujiyuu extends AbstractExDBEntity<BM_PalSyoumetujiyuu, PKBM_PalSyoumetujiyuu> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_PalSyoumetujiyuu";
    public static final String PALSYOUMETUCD            = "palsyoumetucd";
    public static final String BETUKUTIKEIYAKUKBN       = "betukutikeiyakukbn";
    public static final String SYOUMETUJIYUUNAME        = "syoumetujiyuuname";

    private final PKBM_PalSyoumetujiyuu primaryKey;

    public GenBM_PalSyoumetujiyuu() {
        primaryKey = new PKBM_PalSyoumetujiyuu();
    }

    public GenBM_PalSyoumetujiyuu(String pPalsyoumetucd, C_BetukutiKeiyakuKbn pBetukutikeiyakukbn) {
        primaryKey = new PKBM_PalSyoumetujiyuu(pPalsyoumetucd, pBetukutikeiyakukbn);
    }

    @Transient
    @Override
    public PKBM_PalSyoumetujiyuu getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_PalSyoumetujiyuu> getMetaClass() {
        return QBM_PalSyoumetujiyuu.class;
    }

    @Id
    @Column(name=GenBM_PalSyoumetujiyuu.PALSYOUMETUCD)
    public String getPalsyoumetucd() {
        return getPrimaryKey().getPalsyoumetucd();
    }

    public void setPalsyoumetucd(String pPalsyoumetucd) {
        getPrimaryKey().setPalsyoumetucd(pPalsyoumetucd);
    }

    @Id
    @Type(type="UserType_C_BetukutiKeiyakuKbn")
    @Column(name=GenBM_PalSyoumetujiyuu.BETUKUTIKEIYAKUKBN)
    public C_BetukutiKeiyakuKbn getBetukutikeiyakukbn() {
        return getPrimaryKey().getBetukutikeiyakukbn();
    }

    public void setBetukutikeiyakukbn(C_BetukutiKeiyakuKbn pBetukutikeiyakukbn) {
        getPrimaryKey().setBetukutikeiyakukbn(pBetukutikeiyakukbn);
    }

    private String syoumetujiyuuname;

    @Column(name=GenBM_PalSyoumetujiyuu.SYOUMETUJIYUUNAME)
    public String getSyoumetujiyuuname() {
        return syoumetujiyuuname;
    }

    public void setSyoumetujiyuuname(String pSyoumetujiyuuname) {
        syoumetujiyuuname = pSyoumetujiyuuname;
    }
}
