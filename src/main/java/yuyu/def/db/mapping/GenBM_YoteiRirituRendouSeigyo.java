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
import yuyu.def.db.entity.BM_YoteiRirituRendouSeigyo;
import yuyu.def.db.id.PKBM_YoteiRirituRendouSeigyo;
import yuyu.def.db.meta.GenQBM_YoteiRirituRendouSeigyo;
import yuyu.def.db.meta.QBM_YoteiRirituRendouSeigyo;

/**
 * 予定利率連動制御マスタ テーブルのマッピング情報クラスで、 {@link BM_YoteiRirituRendouSeigyo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_YoteiRirituRendouSeigyo}</td><td colspan="3">予定利率連動制御マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getYoteirirituhanteidfrom yoteirirituhanteidfrom}</td><td>予定利率作成判定日（自）</td><td align="center">{@link PKBM_YoteiRirituRendouSeigyo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYoteirirituhanteidto yoteirirituhanteidto}</td><td>予定利率作成判定日（至）</td><td align="center">{@link PKBM_YoteiRirituRendouSeigyo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_YoteiRirituRendouSeigyo ○}</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_YoteiRirituRendouSeigyo
 * @see     PKBM_YoteiRirituRendouSeigyo
 * @see     QBM_YoteiRirituRendouSeigyo
 * @see     GenQBM_YoteiRirituRendouSeigyo
 */
@MappedSuperclass
@Table(name=GenBM_YoteiRirituRendouSeigyo.TABLE_NAME)
@IdClass(value=PKBM_YoteiRirituRendouSeigyo.class)
public abstract class GenBM_YoteiRirituRendouSeigyo extends AbstractExDBEntity<BM_YoteiRirituRendouSeigyo, PKBM_YoteiRirituRendouSeigyo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_YoteiRirituRendouSeigyo";
    public static final String YOTEIRIRITUHANTEIDFROM   = "yoteirirituhanteidfrom";
    public static final String YOTEIRIRITUHANTEIDTO     = "yoteirirituhanteidto";
    public static final String SYOUHNCD                 = "syouhncd";

    private final PKBM_YoteiRirituRendouSeigyo primaryKey;

    public GenBM_YoteiRirituRendouSeigyo() {
        primaryKey = new PKBM_YoteiRirituRendouSeigyo();
    }

    public GenBM_YoteiRirituRendouSeigyo(
        String pYoteirirituhanteidfrom,
        String pYoteirirituhanteidto,
        String pSyouhncd
    ) {
        primaryKey = new PKBM_YoteiRirituRendouSeigyo(
            pYoteirirituhanteidfrom,
            pYoteirirituhanteidto,
            pSyouhncd
        );
    }

    @Transient
    @Override
    public PKBM_YoteiRirituRendouSeigyo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_YoteiRirituRendouSeigyo> getMetaClass() {
        return QBM_YoteiRirituRendouSeigyo.class;
    }

    @Id
    @Column(name=GenBM_YoteiRirituRendouSeigyo.YOTEIRIRITUHANTEIDFROM)
    public String getYoteirirituhanteidfrom() {
        return getPrimaryKey().getYoteirirituhanteidfrom();
    }

    public void setYoteirirituhanteidfrom(String pYoteirirituhanteidfrom) {
        getPrimaryKey().setYoteirirituhanteidfrom(pYoteirirituhanteidfrom);
    }

    @Id
    @Column(name=GenBM_YoteiRirituRendouSeigyo.YOTEIRIRITUHANTEIDTO)
    public String getYoteirirituhanteidto() {
        return getPrimaryKey().getYoteirirituhanteidto();
    }

    public void setYoteirirituhanteidto(String pYoteirirituhanteidto) {
        getPrimaryKey().setYoteirirituhanteidto(pYoteirirituhanteidto);
    }

    @Id
    @Column(name=GenBM_YoteiRirituRendouSeigyo.SYOUHNCD)
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
}