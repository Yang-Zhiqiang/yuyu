package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_RateP2;
import yuyu.def.db.id.PKBM_RateP2;
import yuyu.def.db.meta.GenQBM_RateP2;
import yuyu.def.db.meta.QBM_RateP2;

/**
 * Ｐレートマスタ２ テーブルのマッピング情報クラスで、 {@link BM_RateP2} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_RateP2}</td><td colspan="3">Ｐレートマスタ２</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getPalhokensyuruikigou palhokensyuruikigou}</td><td>ＰＡＬ保険種類記号</td><td align="center">{@link PKBM_RateP2 ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalhokensyuruikigousdicode palhokensyuruikigousdicode}</td><td>ＰＡＬ保険種類記号世代コード</td><td align="center">{@link PKBM_RateP2 ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalyoteiriritu palyoteiriritu}</td><td>ＰＡＬ予定利率</td><td align="center">{@link PKBM_RateP2 ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalpmencode palpmencode}</td><td>ＰＡＬＰ免コード</td><td align="center">{@link PKBM_RateP2 ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalharaikomikaisuu palharaikomikaisuu}</td><td>ＰＡＬ払込回数</td><td align="center">{@link PKBM_RateP2 ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalhhknsei palhhknsei}</td><td>ＰＡＬ被保険者性別</td><td align="center">{@link PKBM_RateP2 ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalkeiyakujihhknnen palkeiyakujihhknnen}</td><td>ＰＡＬ契約時被保険者年令</td><td align="center">{@link PKBM_RateP2 ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalsaimankihyouji palsaimankihyouji}</td><td>ＰＡＬ才満期契約表示</td><td align="center">{@link PKBM_RateP2 ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalhokenkikan palhokenkikan}</td><td>ＰＡＬ保険期間</td><td align="center">{@link PKBM_RateP2 ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalpharaikomikikan palpharaikomikikan}</td><td>ＰＡＬＰ払込期間</td><td align="center">{@link PKBM_RateP2 ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalannaihuyouriyuukbn palannaihuyouriyuukbn}</td><td>ＰＡＬ案内不要理由区分</td><td align="center">{@link PKBM_RateP2 ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getRatetuukasyukbn ratetuukasyukbn}</td><td>レート用通貨種類区分</td><td align="center">{@link PKBM_RateP2 ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getRatedai1hknkkn ratedai1hknkkn}</td><td>レート用第１保険期間</td><td align="center">{@link PKBM_RateP2 ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalryouritukbn palryouritukbn}</td><td>ＰＡＬ料率区分</td><td align="center">{@link PKBM_RateP2 ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPrate prate}</td><td>Ｐレート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getPdatesrate pdatesrate}</td><td>Ｐ建Ｓレート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_RateP2
 * @see     PKBM_RateP2
 * @see     QBM_RateP2
 * @see     GenQBM_RateP2
 */
@MappedSuperclass
@Table(name=GenBM_RateP2.TABLE_NAME)
@IdClass(value=PKBM_RateP2.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenBM_RateP2 extends AbstractExDBEntity<BM_RateP2, PKBM_RateP2> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_RateP2";
    public static final String PALHOKENSYURUIKIGOU      = "palhokensyuruikigou";
    public static final String PALHOKENSYURUIKIGOUSDICODE = "palhokensyuruikigousdicode";
    public static final String PALYOTEIRIRITU           = "palyoteiriritu";
    public static final String PALPMENCODE              = "palpmencode";
    public static final String PALHARAIKOMIKAISUU       = "palharaikomikaisuu";
    public static final String PALHHKNSEI               = "palhhknsei";
    public static final String PALKEIYAKUJIHHKNNEN      = "palkeiyakujihhknnen";
    public static final String PALSAIMANKIHYOUJI        = "palsaimankihyouji";
    public static final String PALHOKENKIKAN            = "palhokenkikan";
    public static final String PALPHARAIKOMIKIKAN       = "palpharaikomikikan";
    public static final String PALANNAIHUYOURIYUUKBN    = "palannaihuyouriyuukbn";
    public static final String RATETUUKASYUKBN          = "ratetuukasyukbn";
    public static final String RATEDAI1HKNKKN           = "ratedai1hknkkn";
    public static final String PALRYOURITUKBN           = "palryouritukbn";
    public static final String PRATE                    = "prate";
    public static final String PDATESRATE               = "pdatesrate";

    private final PKBM_RateP2 primaryKey;

    public GenBM_RateP2() {
        primaryKey = new PKBM_RateP2();
    }

    public GenBM_RateP2(
        String pPalhokensyuruikigou,
        String pPalhokensyuruikigousdicode,
        String pPalyoteiriritu,
        String pPalpmencode,
        String pPalharaikomikaisuu,
        String pPalhhknsei,
        String pPalkeiyakujihhknnen,
        String pPalsaimankihyouji,
        String pPalhokenkikan,
        String pPalpharaikomikikan,
        String pPalannaihuyouriyuukbn,
        String pRatetuukasyukbn,
        String pRatedai1hknkkn,
        String pPalryouritukbn
    ) {
        primaryKey = new PKBM_RateP2(
            pPalhokensyuruikigou,
            pPalhokensyuruikigousdicode,
            pPalyoteiriritu,
            pPalpmencode,
            pPalharaikomikaisuu,
            pPalhhknsei,
            pPalkeiyakujihhknnen,
            pPalsaimankihyouji,
            pPalhokenkikan,
            pPalpharaikomikikan,
            pPalannaihuyouriyuukbn,
            pRatetuukasyukbn,
            pRatedai1hknkkn,
            pPalryouritukbn
        );
    }

    @Transient
    @Override
    public PKBM_RateP2 getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_RateP2> getMetaClass() {
        return QBM_RateP2.class;
    }

    @Id
    @Column(name=GenBM_RateP2.PALHOKENSYURUIKIGOU)
    public String getPalhokensyuruikigou() {
        return getPrimaryKey().getPalhokensyuruikigou();
    }

    public void setPalhokensyuruikigou(String pPalhokensyuruikigou) {
        getPrimaryKey().setPalhokensyuruikigou(pPalhokensyuruikigou);
    }

    @Id
    @Column(name=GenBM_RateP2.PALHOKENSYURUIKIGOUSDICODE)
    public String getPalhokensyuruikigousdicode() {
        return getPrimaryKey().getPalhokensyuruikigousdicode();
    }

    public void setPalhokensyuruikigousdicode(String pPalhokensyuruikigousdicode) {
        getPrimaryKey().setPalhokensyuruikigousdicode(pPalhokensyuruikigousdicode);
    }

    @Id
    @Column(name=GenBM_RateP2.PALYOTEIRIRITU)
    public String getPalyoteiriritu() {
        return getPrimaryKey().getPalyoteiriritu();
    }

    public void setPalyoteiriritu(String pPalyoteiriritu) {
        getPrimaryKey().setPalyoteiriritu(pPalyoteiriritu);
    }

    @Id
    @Column(name=GenBM_RateP2.PALPMENCODE)
    public String getPalpmencode() {
        return getPrimaryKey().getPalpmencode();
    }

    public void setPalpmencode(String pPalpmencode) {
        getPrimaryKey().setPalpmencode(pPalpmencode);
    }

    @Id
    @Column(name=GenBM_RateP2.PALHARAIKOMIKAISUU)
    public String getPalharaikomikaisuu() {
        return getPrimaryKey().getPalharaikomikaisuu();
    }

    public void setPalharaikomikaisuu(String pPalharaikomikaisuu) {
        getPrimaryKey().setPalharaikomikaisuu(pPalharaikomikaisuu);
    }

    @Id
    @Column(name=GenBM_RateP2.PALHHKNSEI)
    public String getPalhhknsei() {
        return getPrimaryKey().getPalhhknsei();
    }

    public void setPalhhknsei(String pPalhhknsei) {
        getPrimaryKey().setPalhhknsei(pPalhhknsei);
    }

    @Id
    @Column(name=GenBM_RateP2.PALKEIYAKUJIHHKNNEN)
    public String getPalkeiyakujihhknnen() {
        return getPrimaryKey().getPalkeiyakujihhknnen();
    }

    public void setPalkeiyakujihhknnen(String pPalkeiyakujihhknnen) {
        getPrimaryKey().setPalkeiyakujihhknnen(pPalkeiyakujihhknnen);
    }

    @Id
    @Column(name=GenBM_RateP2.PALSAIMANKIHYOUJI)
    public String getPalsaimankihyouji() {
        return getPrimaryKey().getPalsaimankihyouji();
    }

    public void setPalsaimankihyouji(String pPalsaimankihyouji) {
        getPrimaryKey().setPalsaimankihyouji(pPalsaimankihyouji);
    }

    @Id
    @Column(name=GenBM_RateP2.PALHOKENKIKAN)
    public String getPalhokenkikan() {
        return getPrimaryKey().getPalhokenkikan();
    }

    public void setPalhokenkikan(String pPalhokenkikan) {
        getPrimaryKey().setPalhokenkikan(pPalhokenkikan);
    }

    @Id
    @Column(name=GenBM_RateP2.PALPHARAIKOMIKIKAN)
    public String getPalpharaikomikikan() {
        return getPrimaryKey().getPalpharaikomikikan();
    }

    public void setPalpharaikomikikan(String pPalpharaikomikikan) {
        getPrimaryKey().setPalpharaikomikikan(pPalpharaikomikikan);
    }

    @Id
    @Column(name=GenBM_RateP2.PALANNAIHUYOURIYUUKBN)
    public String getPalannaihuyouriyuukbn() {
        return getPrimaryKey().getPalannaihuyouriyuukbn();
    }

    public void setPalannaihuyouriyuukbn(String pPalannaihuyouriyuukbn) {
        getPrimaryKey().setPalannaihuyouriyuukbn(pPalannaihuyouriyuukbn);
    }

    @Id
    @Column(name=GenBM_RateP2.RATETUUKASYUKBN)
    public String getRatetuukasyukbn() {
        return getPrimaryKey().getRatetuukasyukbn();
    }

    public void setRatetuukasyukbn(String pRatetuukasyukbn) {
        getPrimaryKey().setRatetuukasyukbn(pRatetuukasyukbn);
    }

    @Id
    @Column(name=GenBM_RateP2.RATEDAI1HKNKKN)
    public String getRatedai1hknkkn() {
        return getPrimaryKey().getRatedai1hknkkn();
    }

    public void setRatedai1hknkkn(String pRatedai1hknkkn) {
        getPrimaryKey().setRatedai1hknkkn(pRatedai1hknkkn);
    }

    @Id
    @Column(name=GenBM_RateP2.PALRYOURITUKBN)
    public String getPalryouritukbn() {
        return getPrimaryKey().getPalryouritukbn();
    }

    public void setPalryouritukbn(String pPalryouritukbn) {
        getPrimaryKey().setPalryouritukbn(pPalryouritukbn);
    }

    private BizNumber prate;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateP2.PRATE)
    public BizNumber getPrate() {
        return prate;
    }

    public void setPrate(BizNumber pPrate) {
        prate = pPrate;
    }

    private BizNumber pdatesrate;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateP2.PDATESRATE)
    public BizNumber getPdatesrate() {
        return pdatesrate;
    }

    public void setPdatesrate(BizNumber pPdatesrate) {
        pdatesrate = pPdatesrate;
    }
}