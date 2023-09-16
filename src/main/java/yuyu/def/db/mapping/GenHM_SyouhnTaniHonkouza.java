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
import yuyu.def.db.entity.HM_SyouhnTaniHonkouza;
import yuyu.def.db.id.PKHM_SyouhnTaniHonkouza;
import yuyu.def.db.meta.GenQHM_SyouhnTaniHonkouza;
import yuyu.def.db.meta.QHM_SyouhnTaniHonkouza;

/**
 * 商品単位本口座マスタ テーブルのマッピング情報クラスで、 {@link HM_SyouhnTaniHonkouza} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_SyouhnTaniHonkouza}</td><td colspan="3">商品単位本口座マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKHM_SyouhnTaniHonkouza ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHonkouzacd honkouzacd}</td><td>本口座コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HM_SyouhnTaniHonkouza
 * @see     PKHM_SyouhnTaniHonkouza
 * @see     QHM_SyouhnTaniHonkouza
 * @see     GenQHM_SyouhnTaniHonkouza
 */
@MappedSuperclass
@Table(name=GenHM_SyouhnTaniHonkouza.TABLE_NAME)
@IdClass(value=PKHM_SyouhnTaniHonkouza.class)
public abstract class GenHM_SyouhnTaniHonkouza extends AbstractExDBEntity<HM_SyouhnTaniHonkouza, PKHM_SyouhnTaniHonkouza> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HM_SyouhnTaniHonkouza";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String HONKOUZACD               = "honkouzacd";

    private final PKHM_SyouhnTaniHonkouza primaryKey;

    public GenHM_SyouhnTaniHonkouza() {
        primaryKey = new PKHM_SyouhnTaniHonkouza();
    }

    public GenHM_SyouhnTaniHonkouza(String pSyouhncd) {
        primaryKey = new PKHM_SyouhnTaniHonkouza(pSyouhncd);
    }

    @Transient
    @Override
    public PKHM_SyouhnTaniHonkouza getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHM_SyouhnTaniHonkouza> getMetaClass() {
        return QHM_SyouhnTaniHonkouza.class;
    }

    @Id
    @Column(name=GenHM_SyouhnTaniHonkouza.SYOUHNCD)
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

    private String honkouzacd;

    @Column(name=GenHM_SyouhnTaniHonkouza.HONKOUZACD)
    public String getHonkouzacd() {
        return honkouzacd;
    }

    public void setHonkouzacd(String pHonkouzacd) {
        honkouzacd = pHonkouzacd;
    }
}