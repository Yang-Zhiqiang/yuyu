package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_HaitouRiritu;
import yuyu.def.db.id.PKBM_HaitouRiritu;
import yuyu.def.db.meta.GenQBM_HaitouRiritu;
import yuyu.def.db.meta.QBM_HaitouRiritu;

/**
 * 配当利率マスタ テーブルのマッピング情報クラスで、 {@link BM_HaitouRiritu} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_HaitouRiritu}</td><td colspan="3">配当利率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKijyunfromymd kijyunfromymd}</td><td>基準日自</td><td align="center">{@link PKBM_HaitouRiritu ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKijyuntoymd kijyuntoymd}</td><td>基準日至</td><td align="center">{@link PKBM_HaitouRiritu ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHaitouriritu haitouriritu}</td><td>配当利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_HaitouRiritu
 * @see     PKBM_HaitouRiritu
 * @see     QBM_HaitouRiritu
 * @see     GenQBM_HaitouRiritu
 */
@MappedSuperclass
@Table(name=GenBM_HaitouRiritu.TABLE_NAME)
@IdClass(value=PKBM_HaitouRiritu.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenBM_HaitouRiritu extends AbstractExDBEntity<BM_HaitouRiritu, PKBM_HaitouRiritu> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_HaitouRiritu";
    public static final String KIJYUNFROMYMD            = "kijyunfromymd";
    public static final String KIJYUNTOYMD              = "kijyuntoymd";
    public static final String HAITOURIRITU             = "haitouriritu";

    private final PKBM_HaitouRiritu primaryKey;

    public GenBM_HaitouRiritu() {
        primaryKey = new PKBM_HaitouRiritu();
    }

    public GenBM_HaitouRiritu(BizDate pKijyunfromymd, BizDate pKijyuntoymd) {
        primaryKey = new PKBM_HaitouRiritu(pKijyunfromymd, pKijyuntoymd);
    }

    @Transient
    @Override
    public PKBM_HaitouRiritu getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_HaitouRiritu> getMetaClass() {
        return QBM_HaitouRiritu.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBM_HaitouRiritu.KIJYUNFROMYMD)
    public BizDate getKijyunfromymd() {
        return getPrimaryKey().getKijyunfromymd();
    }

    public void setKijyunfromymd(BizDate pKijyunfromymd) {
        getPrimaryKey().setKijyunfromymd(pKijyunfromymd);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenBM_HaitouRiritu.KIJYUNTOYMD)
    public BizDate getKijyuntoymd() {
        return getPrimaryKey().getKijyuntoymd();
    }

    public void setKijyuntoymd(BizDate pKijyuntoymd) {
        getPrimaryKey().setKijyuntoymd(pKijyuntoymd);
    }

    private BizNumber haitouriritu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_HaitouRiritu.HAITOURIRITU)
    public BizNumber getHaitouriritu() {
        return haitouriritu;
    }

    public void setHaitouriritu(BizNumber pHaitouriritu) {
        haitouriritu = pHaitouriritu;
    }
}