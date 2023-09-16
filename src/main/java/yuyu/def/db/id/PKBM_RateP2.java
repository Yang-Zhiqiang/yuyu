package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BM_RateP2;
import yuyu.def.db.mapping.GenBM_RateP2;
import yuyu.def.db.meta.GenQBM_RateP2;
import yuyu.def.db.meta.QBM_RateP2;

/**
 * Ｐレートマスタ２ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_RateP2}</td><td colspan="3">Ｐレートマスタ２</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalhokensyuruikigou palhokensyuruikigou}</td><td>ＰＡＬ保険種類記号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalhokensyuruikigousdicode palhokensyuruikigousdicode}</td><td>ＰＡＬ保険種類記号世代コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalyoteiriritu palyoteiriritu}</td><td>ＰＡＬ予定利率</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalpmencode palpmencode}</td><td>ＰＡＬＰ免コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalharaikomikaisuu palharaikomikaisuu}</td><td>ＰＡＬ払込回数</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalhhknsei palhhknsei}</td><td>ＰＡＬ被保険者性別</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalkeiyakujihhknnen palkeiyakujihhknnen}</td><td>ＰＡＬ契約時被保険者年令</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalsaimankihyouji palsaimankihyouji}</td><td>ＰＡＬ才満期契約表示</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalhokenkikan palhokenkikan}</td><td>ＰＡＬ保険期間</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalpharaikomikikan palpharaikomikikan}</td><td>ＰＡＬＰ払込期間</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalannaihuyouriyuukbn palannaihuyouriyuukbn}</td><td>ＰＡＬ案内不要理由区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRatetuukasyukbn ratetuukasyukbn}</td><td>レート用通貨種類区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRatedai1hknkkn ratedai1hknkkn}</td><td>レート用第１保険期間</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalryouritukbn palryouritukbn}</td><td>ＰＡＬ料率区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>prate</td><td>Ｐレート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>pdatesrate</td><td>Ｐ建Ｓレート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_RateP2
 * @see     GenBM_RateP2
 * @see     QBM_RateP2
 * @see     GenQBM_RateP2
 */
public class PKBM_RateP2 extends AbstractExDBPrimaryKey<BM_RateP2, PKBM_RateP2> {

    private static final long serialVersionUID = 1L;

    public PKBM_RateP2() {
    }

    public PKBM_RateP2(
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
        palhokensyuruikigou = pPalhokensyuruikigou;
        palhokensyuruikigousdicode = pPalhokensyuruikigousdicode;
        palyoteiriritu = pPalyoteiriritu;
        palpmencode = pPalpmencode;
        palharaikomikaisuu = pPalharaikomikaisuu;
        palhhknsei = pPalhhknsei;
        palkeiyakujihhknnen = pPalkeiyakujihhknnen;
        palsaimankihyouji = pPalsaimankihyouji;
        palhokenkikan = pPalhokenkikan;
        palpharaikomikikan = pPalpharaikomikikan;
        palannaihuyouriyuukbn = pPalannaihuyouriyuukbn;
        ratetuukasyukbn = pRatetuukasyukbn;
        ratedai1hknkkn = pRatedai1hknkkn;
        palryouritukbn = pPalryouritukbn;
    }

    @Transient
    @Override
    public Class<BM_RateP2> getEntityClass() {
        return BM_RateP2.class;
    }

    private String palhokensyuruikigou;

    public String getPalhokensyuruikigou() {
        return palhokensyuruikigou;
    }

    public void setPalhokensyuruikigou(String pPalhokensyuruikigou) {
        palhokensyuruikigou = pPalhokensyuruikigou;
    }
    private String palhokensyuruikigousdicode;

    public String getPalhokensyuruikigousdicode() {
        return palhokensyuruikigousdicode;
    }

    public void setPalhokensyuruikigousdicode(String pPalhokensyuruikigousdicode) {
        palhokensyuruikigousdicode = pPalhokensyuruikigousdicode;
    }
    private String palyoteiriritu;

    public String getPalyoteiriritu() {
        return palyoteiriritu;
    }

    public void setPalyoteiriritu(String pPalyoteiriritu) {
        palyoteiriritu = pPalyoteiriritu;
    }
    private String palpmencode;

    public String getPalpmencode() {
        return palpmencode;
    }

    public void setPalpmencode(String pPalpmencode) {
        palpmencode = pPalpmencode;
    }
    private String palharaikomikaisuu;

    public String getPalharaikomikaisuu() {
        return palharaikomikaisuu;
    }

    public void setPalharaikomikaisuu(String pPalharaikomikaisuu) {
        palharaikomikaisuu = pPalharaikomikaisuu;
    }
    private String palhhknsei;

    public String getPalhhknsei() {
        return palhhknsei;
    }

    public void setPalhhknsei(String pPalhhknsei) {
        palhhknsei = pPalhhknsei;
    }
    private String palkeiyakujihhknnen;

    public String getPalkeiyakujihhknnen() {
        return palkeiyakujihhknnen;
    }

    public void setPalkeiyakujihhknnen(String pPalkeiyakujihhknnen) {
        palkeiyakujihhknnen = pPalkeiyakujihhknnen;
    }
    private String palsaimankihyouji;

    public String getPalsaimankihyouji() {
        return palsaimankihyouji;
    }

    public void setPalsaimankihyouji(String pPalsaimankihyouji) {
        palsaimankihyouji = pPalsaimankihyouji;
    }
    private String palhokenkikan;

    public String getPalhokenkikan() {
        return palhokenkikan;
    }

    public void setPalhokenkikan(String pPalhokenkikan) {
        palhokenkikan = pPalhokenkikan;
    }
    private String palpharaikomikikan;

    public String getPalpharaikomikikan() {
        return palpharaikomikikan;
    }

    public void setPalpharaikomikikan(String pPalpharaikomikikan) {
        palpharaikomikikan = pPalpharaikomikikan;
    }
    private String palannaihuyouriyuukbn;

    public String getPalannaihuyouriyuukbn() {
        return palannaihuyouriyuukbn;
    }

    public void setPalannaihuyouriyuukbn(String pPalannaihuyouriyuukbn) {
        palannaihuyouriyuukbn = pPalannaihuyouriyuukbn;
    }
    private String ratetuukasyukbn;

    public String getRatetuukasyukbn() {
        return ratetuukasyukbn;
    }

    public void setRatetuukasyukbn(String pRatetuukasyukbn) {
        ratetuukasyukbn = pRatetuukasyukbn;
    }
    private String ratedai1hknkkn;

    public String getRatedai1hknkkn() {
        return ratedai1hknkkn;
    }

    public void setRatedai1hknkkn(String pRatedai1hknkkn) {
        ratedai1hknkkn = pRatedai1hknkkn;
    }
    private String palryouritukbn;

    public String getPalryouritukbn() {
        return palryouritukbn;
    }

    public void setPalryouritukbn(String pPalryouritukbn) {
        palryouritukbn = pPalryouritukbn;
    }

}