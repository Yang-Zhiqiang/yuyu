package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.BM_DairitenSyougou;
import yuyu.def.db.id.PKBM_DairitenSyougou;
import yuyu.def.db.meta.GenQBM_DairitenSyougou;
import yuyu.def.db.meta.QBM_DairitenSyougou;

/**
 * 代理店法人商号マスタ テーブルのマッピング情報クラスで、 {@link BM_DairitenSyougou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_DairitenSyougou}</td><td colspan="3">代理店法人商号マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDrtencd drtencd}</td><td>代理店コード</td><td align="center">{@link PKBM_DairitenSyougou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKanjihoujinsyougou kanjihoujinsyougou}</td><td>漢字法人商号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_DairitenSyougou
 * @see     PKBM_DairitenSyougou
 * @see     QBM_DairitenSyougou
 * @see     GenQBM_DairitenSyougou
 */
@MappedSuperclass
@Table(name=GenBM_DairitenSyougou.TABLE_NAME)
@IdClass(value=PKBM_DairitenSyougou.class)
public abstract class GenBM_DairitenSyougou extends AbstractExDBEntity<BM_DairitenSyougou, PKBM_DairitenSyougou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_DairitenSyougou";
    public static final String DRTENCD                  = "drtencd";
    public static final String KANJIHOUJINSYOUGOU       = "kanjihoujinsyougou";

    private final PKBM_DairitenSyougou primaryKey;

    public GenBM_DairitenSyougou() {
        primaryKey = new PKBM_DairitenSyougou();
    }

    public GenBM_DairitenSyougou(String pDrtencd) {
        primaryKey = new PKBM_DairitenSyougou(pDrtencd);
    }

    @Transient
    @Override
    public PKBM_DairitenSyougou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_DairitenSyougou> getMetaClass() {
        return QBM_DairitenSyougou.class;
    }

    @Id
    @Column(name=GenBM_DairitenSyougou.DRTENCD)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDrtencd() {
        return getPrimaryKey().getDrtencd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtencd(String pDrtencd) {
        getPrimaryKey().setDrtencd(pDrtencd);
    }

    private String kanjihoujinsyougou;

    @Column(name=GenBM_DairitenSyougou.KANJIHOUJINSYOUGOU)
    public String getKanjihoujinsyougou() {
        return kanjihoujinsyougou;
    }

    public void setKanjihoujinsyougou(String pKanjihoujinsyougou) {
        kanjihoujinsyougou = pKanjihoujinsyougou;
    }
}
