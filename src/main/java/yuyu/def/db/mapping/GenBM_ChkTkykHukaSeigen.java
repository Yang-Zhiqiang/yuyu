package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_ChkTkykHukaSeigen;
import yuyu.def.db.id.PKBM_ChkTkykHukaSeigen;
import yuyu.def.db.meta.GenQBM_ChkTkykHukaSeigen;
import yuyu.def.db.meta.QBM_ChkTkykHukaSeigen;

/**
 * 特約付加制限チェックマスタ テーブルのマッピング情報クラスで、 {@link BM_ChkTkykHukaSeigen} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkTkykHukaSeigen}</td><td colspan="3">特約付加制限チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyusyouhncd syusyouhncd}</td><td>主契約商品コード</td><td align="center">{@link PKBM_ChkTkykHukaSeigen ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">{@link PKBM_ChkTkykHukaSeigen ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">{@link PKBM_ChkTkykHukaSeigen ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSntkhoukbnfrom sntkhoukbnfrom}</td><td>選択方法区分自</td><td align="center">{@link PKBM_ChkTkykHukaSeigen ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSntkhoukbnto sntkhoukbnto}</td><td>選択方法区分至</td><td align="center">{@link PKBM_ChkTkykHukaSeigen ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHhknfromnen hhknfromnen}</td><td>被保険者年齢自</td><td align="center">{@link PKBM_ChkTkykHukaSeigen ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHhkntonen hhkntonen}</td><td>被保険者年齢至</td><td align="center">{@link PKBM_ChkTkykHukaSeigen ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTksyouhncd tksyouhncd}</td><td>特約商品コード</td><td align="center">{@link PKBM_ChkTkykHukaSeigen ○}</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_ChkTkykHukaSeigen
 * @see     PKBM_ChkTkykHukaSeigen
 * @see     QBM_ChkTkykHukaSeigen
 * @see     GenQBM_ChkTkykHukaSeigen
 */
@MappedSuperclass
@Table(name=GenBM_ChkTkykHukaSeigen.TABLE_NAME)
@IdClass(value=PKBM_ChkTkykHukaSeigen.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenBM_ChkTkykHukaSeigen extends AbstractExDBEntity<BM_ChkTkykHukaSeigen, PKBM_ChkTkykHukaSeigen> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ChkTkykHukaSeigen";
    public static final String SYUSYOUHNCD              = "syusyouhncd";
    public static final String SYUSYOUHNSDNOFROM        = "syusyouhnsdnofrom";
    public static final String SYUSYOUHNSDNOTO          = "syusyouhnsdnoto";
    public static final String SNTKHOUKBNFROM           = "sntkhoukbnfrom";
    public static final String SNTKHOUKBNTO             = "sntkhoukbnto";
    public static final String HHKNFROMNEN              = "hhknfromnen";
    public static final String HHKNTONEN                = "hhkntonen";
    public static final String TKSYOUHNCD               = "tksyouhncd";

    private final PKBM_ChkTkykHukaSeigen primaryKey;

    public GenBM_ChkTkykHukaSeigen() {
        primaryKey = new PKBM_ChkTkykHukaSeigen();
    }

    public GenBM_ChkTkykHukaSeigen(
        String pSyusyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        Integer pSntkhoukbnfrom,
        Integer pSntkhoukbnto,
        BizNumber pHhknfromnen,
        BizNumber pHhkntonen,
        String pTksyouhncd
    ) {
        primaryKey = new PKBM_ChkTkykHukaSeigen(
            pSyusyouhncd,
            pSyusyouhnsdnofrom,
            pSyusyouhnsdnoto,
            pSntkhoukbnfrom,
            pSntkhoukbnto,
            pHhknfromnen,
            pHhkntonen,
            pTksyouhncd
        );
    }

    @Transient
    @Override
    public PKBM_ChkTkykHukaSeigen getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ChkTkykHukaSeigen> getMetaClass() {
        return QBM_ChkTkykHukaSeigen.class;
    }

    @Id
    @Column(name=GenBM_ChkTkykHukaSeigen.SYUSYOUHNCD)
    public String getSyusyouhncd() {
        return getPrimaryKey().getSyusyouhncd();
    }

    public void setSyusyouhncd(String pSyusyouhncd) {
        getPrimaryKey().setSyusyouhncd(pSyusyouhncd);
    }

    @Id
    @Column(name=GenBM_ChkTkykHukaSeigen.SYUSYOUHNSDNOFROM)
    public Integer getSyusyouhnsdnofrom() {
        return getPrimaryKey().getSyusyouhnsdnofrom();
    }

    public void setSyusyouhnsdnofrom(Integer pSyusyouhnsdnofrom) {
        getPrimaryKey().setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
    }

    @Id
    @Column(name=GenBM_ChkTkykHukaSeigen.SYUSYOUHNSDNOTO)
    public Integer getSyusyouhnsdnoto() {
        return getPrimaryKey().getSyusyouhnsdnoto();
    }

    public void setSyusyouhnsdnoto(Integer pSyusyouhnsdnoto) {
        getPrimaryKey().setSyusyouhnsdnoto(pSyusyouhnsdnoto);
    }

    @Id
    @Column(name=GenBM_ChkTkykHukaSeigen.SNTKHOUKBNFROM)
    public Integer getSntkhoukbnfrom() {
        return getPrimaryKey().getSntkhoukbnfrom();
    }

    public void setSntkhoukbnfrom(Integer pSntkhoukbnfrom) {
        getPrimaryKey().setSntkhoukbnfrom(pSntkhoukbnfrom);
    }

    @Id
    @Column(name=GenBM_ChkTkykHukaSeigen.SNTKHOUKBNTO)
    public Integer getSntkhoukbnto() {
        return getPrimaryKey().getSntkhoukbnto();
    }

    public void setSntkhoukbnto(Integer pSntkhoukbnto) {
        getPrimaryKey().setSntkhoukbnto(pSntkhoukbnto);
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkTkykHukaSeigen.HHKNFROMNEN)
    public BizNumber getHhknfromnen() {
        return getPrimaryKey().getHhknfromnen();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknfromnen(BizNumber pHhknfromnen) {
        getPrimaryKey().setHhknfromnen(pHhknfromnen);
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkTkykHukaSeigen.HHKNTONEN)
    public BizNumber getHhkntonen() {
        return getPrimaryKey().getHhkntonen();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhkntonen(BizNumber pHhkntonen) {
        getPrimaryKey().setHhkntonen(pHhkntonen);
    }

    @Id
    @Column(name=GenBM_ChkTkykHukaSeigen.TKSYOUHNCD)
    public String getTksyouhncd() {
        return getPrimaryKey().getTksyouhncd();
    }

    public void setTksyouhncd(String pTksyouhncd) {
        getPrimaryKey().setTksyouhncd(pTksyouhncd);
    }
}
