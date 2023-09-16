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
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_KaiyakuKoujyoRitu;
import yuyu.def.db.id.PKBM_KaiyakuKoujyoRitu;
import yuyu.def.db.meta.GenQBM_KaiyakuKoujyoRitu;
import yuyu.def.db.meta.QBM_KaiyakuKoujyoRitu;

/**
 * 解約控除率マスタ テーブルのマッピング情報クラスで、 {@link BM_KaiyakuKoujyoRitu} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_KaiyakuKoujyoRitu}</td><td colspan="3">解約控除率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_KaiyakuKoujyoRitu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRyouritusdno ryouritusdno}</td><td>料率世代番号</td><td align="center">{@link PKBM_KaiyakuKoujyoRitu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKaiyakukjtkybr1 kaiyakukjtkybr1}</td><td>解約控除適用分類１</td><td align="center">{@link PKBM_KaiyakuKoujyoRitu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKaiyakukjtkybr2 kaiyakukjtkybr2}</td><td>解約控除適用分類２</td><td align="center">{@link PKBM_KaiyakuKoujyoRitu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKeikanensuu keikanensuu}</td><td>経過年数</td><td align="center">{@link PKBM_KaiyakuKoujyoRitu ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKaiyakukoujyoritu kaiyakukoujyoritu}</td><td>解約控除率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_KaiyakuKoujyoRitu
 * @see     PKBM_KaiyakuKoujyoRitu
 * @see     QBM_KaiyakuKoujyoRitu
 * @see     GenQBM_KaiyakuKoujyoRitu
 */
@MappedSuperclass
@Table(name=GenBM_KaiyakuKoujyoRitu.TABLE_NAME)
@IdClass(value=PKBM_KaiyakuKoujyoRitu.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenBM_KaiyakuKoujyoRitu extends AbstractExDBEntity<BM_KaiyakuKoujyoRitu, PKBM_KaiyakuKoujyoRitu> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_KaiyakuKoujyoRitu";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String RYOURITUSDNO             = "ryouritusdno";
    public static final String KAIYAKUKJTKYBR1          = "kaiyakukjtkybr1";
    public static final String KAIYAKUKJTKYBR2          = "kaiyakukjtkybr2";
    public static final String KEIKANENSUU              = "keikanensuu";
    public static final String KAIYAKUKOUJYORITU        = "kaiyakukoujyoritu";

    private final PKBM_KaiyakuKoujyoRitu primaryKey;

    public GenBM_KaiyakuKoujyoRitu() {
        primaryKey = new PKBM_KaiyakuKoujyoRitu();
    }

    public GenBM_KaiyakuKoujyoRitu(
        String pSyouhncd,
        String pRyouritusdno,
        String pKaiyakukjtkybr1,
        String pKaiyakukjtkybr2,
        Integer pKeikanensuu
    ) {
        primaryKey = new PKBM_KaiyakuKoujyoRitu(
            pSyouhncd,
            pRyouritusdno,
            pKaiyakukjtkybr1,
            pKaiyakukjtkybr2,
            pKeikanensuu
        );
    }

    @Transient
    @Override
    public PKBM_KaiyakuKoujyoRitu getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_KaiyakuKoujyoRitu> getMetaClass() {
        return QBM_KaiyakuKoujyoRitu.class;
    }

    @Id
    @Column(name=GenBM_KaiyakuKoujyoRitu.SYOUHNCD)
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
    @Column(name=GenBM_KaiyakuKoujyoRitu.RYOURITUSDNO)
    public String getRyouritusdno() {
        return getPrimaryKey().getRyouritusdno();
    }

    public void setRyouritusdno(String pRyouritusdno) {
        getPrimaryKey().setRyouritusdno(pRyouritusdno);
    }

    @Id
    @Column(name=GenBM_KaiyakuKoujyoRitu.KAIYAKUKJTKYBR1)
    public String getKaiyakukjtkybr1() {
        return getPrimaryKey().getKaiyakukjtkybr1();
    }

    public void setKaiyakukjtkybr1(String pKaiyakukjtkybr1) {
        getPrimaryKey().setKaiyakukjtkybr1(pKaiyakukjtkybr1);
    }

    @Id
    @Column(name=GenBM_KaiyakuKoujyoRitu.KAIYAKUKJTKYBR2)
    public String getKaiyakukjtkybr2() {
        return getPrimaryKey().getKaiyakukjtkybr2();
    }

    public void setKaiyakukjtkybr2(String pKaiyakukjtkybr2) {
        getPrimaryKey().setKaiyakukjtkybr2(pKaiyakukjtkybr2);
    }

    @Id
    @Column(name=GenBM_KaiyakuKoujyoRitu.KEIKANENSUU)
    public Integer getKeikanensuu() {
        return getPrimaryKey().getKeikanensuu();
    }

    public void setKeikanensuu(Integer pKeikanensuu) {
        getPrimaryKey().setKeikanensuu(pKeikanensuu);
    }

    private BizNumber kaiyakukoujyoritu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_KaiyakuKoujyoRitu.KAIYAKUKOUJYORITU)
    public BizNumber getKaiyakukoujyoritu() {
        return kaiyakukoujyoritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKaiyakukoujyoritu(BizNumber pKaiyakukoujyoritu) {
        kaiyakukoujyoritu = pKaiyakukoujyoritu;
    }
}