package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_SjkkkTyouseiyouRiritu2;
import yuyu.def.db.mapping.GenBM_SjkkkTyouseiyouRiritu2;
import yuyu.def.db.meta.GenQBM_SjkkkTyouseiyouRiritu2;
import yuyu.def.db.meta.QBM_SjkkkTyouseiyouRiritu2;

/**
 * 市場価格調整用利率マスタ２ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_SjkkkTyouseiyouRiritu2}</td><td colspan="3">市場価格調整用利率マスタ２</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSjkkktyouseiriritutkybr1 sjkkktyouseiriritutkybr1}</td><td>市場価格調整用利率適用分類１</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSjkkktyouseiriritutkybr2 sjkkktyouseiriritutkybr2}</td><td>市場価格調整用利率適用分類２</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKijyunfromymd kijyunfromymd}</td><td>基準日自</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKijyuntoymd kijyuntoymd}</td><td>基準日至</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>tuukasyu</td><td>通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>sjkkktyouseiyouriritu</td><td>市場価格調整用利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_SjkkkTyouseiyouRiritu2
 * @see     GenBM_SjkkkTyouseiyouRiritu2
 * @see     QBM_SjkkkTyouseiyouRiritu2
 * @see     GenQBM_SjkkkTyouseiyouRiritu2
 */
public class PKBM_SjkkkTyouseiyouRiritu2 extends AbstractExDBPrimaryKey<BM_SjkkkTyouseiyouRiritu2, PKBM_SjkkkTyouseiyouRiritu2> {

    private static final long serialVersionUID = 1L;

    public PKBM_SjkkkTyouseiyouRiritu2() {
    }

    public PKBM_SjkkkTyouseiyouRiritu2(
        String pSyouhncd,
        String pSjkkktyouseiriritutkybr1,
        String pSjkkktyouseiriritutkybr2,
        BizDate pKijyunfromymd,
        BizDate pKijyuntoymd
    ) {
        syouhncd = pSyouhncd;
        sjkkktyouseiriritutkybr1 = pSjkkktyouseiriritutkybr1;
        sjkkktyouseiriritutkybr2 = pSjkkktyouseiriritutkybr2;
        kijyunfromymd = pKijyunfromymd;
        kijyuntoymd = pKijyuntoymd;
    }

    @Transient
    @Override
    public Class<BM_SjkkkTyouseiyouRiritu2> getEntityClass() {
        return BM_SjkkkTyouseiyouRiritu2.class;
    }

    private String syouhncd;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }
    private String sjkkktyouseiriritutkybr1;

    public String getSjkkktyouseiriritutkybr1() {
        return sjkkktyouseiriritutkybr1;
    }

    public void setSjkkktyouseiriritutkybr1(String pSjkkktyouseiriritutkybr1) {
        sjkkktyouseiriritutkybr1 = pSjkkktyouseiriritutkybr1;
    }
    private String sjkkktyouseiriritutkybr2;

    public String getSjkkktyouseiriritutkybr2() {
        return sjkkktyouseiriritutkybr2;
    }

    public void setSjkkktyouseiriritutkybr2(String pSjkkktyouseiriritutkybr2) {
        sjkkktyouseiriritutkybr2 = pSjkkktyouseiriritutkybr2;
    }
    private BizDate kijyunfromymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getKijyunfromymd() {
        return kijyunfromymd;
    }

    public void setKijyunfromymd(BizDate pKijyunfromymd) {
        kijyunfromymd = pKijyunfromymd;
    }
    private BizDate kijyuntoymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getKijyuntoymd() {
        return kijyuntoymd;
    }

    public void setKijyuntoymd(BizDate pKijyuntoymd) {
        kijyuntoymd = pKijyuntoymd;
    }

}