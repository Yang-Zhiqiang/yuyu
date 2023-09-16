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
import yuyu.def.db.entity.BM_YoteiRiritu2;
import yuyu.def.db.mapping.GenBM_YoteiRiritu2;
import yuyu.def.db.meta.GenQBM_YoteiRiritu2;
import yuyu.def.db.meta.QBM_YoteiRiritu2;

/**
 * 予定利率マスタ２ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_YoteiRiritu2}</td><td colspan="3">予定利率マスタ２</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getYoteiriritutkybr1 yoteiriritutkybr1}</td><td>予定利率適用分類１</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getYoteiriritutkybr2 yoteiriritutkybr2}</td><td>予定利率適用分類２</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKijyunfromymd kijyunfromymd}</td><td>基準日自</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKijyuntoymd kijyuntoymd}</td><td>基準日至</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>tuukasyu</td><td>通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>yoteiriritu</td><td>予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>tumitateriritu</td><td>積立利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>tmttknzoukaritujygn</td><td>積立金増加率上限</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>setteibairitu</td><td>設定倍率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>loadinghnkgtumitateriritu</td><td>ローディング変更後積立利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>rendouritu</td><td>連動率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_YoteiRiritu2
 * @see     GenBM_YoteiRiritu2
 * @see     QBM_YoteiRiritu2
 * @see     GenQBM_YoteiRiritu2
 */
public class PKBM_YoteiRiritu2 extends AbstractExDBPrimaryKey<BM_YoteiRiritu2, PKBM_YoteiRiritu2> {

    private static final long serialVersionUID = 1L;

    public PKBM_YoteiRiritu2() {
    }

    public PKBM_YoteiRiritu2(
        String pSyouhncd,
        String pYoteiriritutkybr1,
        String pYoteiriritutkybr2,
        BizDate pKijyunfromymd,
        BizDate pKijyuntoymd
    ) {
        syouhncd = pSyouhncd;
        yoteiriritutkybr1 = pYoteiriritutkybr1;
        yoteiriritutkybr2 = pYoteiriritutkybr2;
        kijyunfromymd = pKijyunfromymd;
        kijyuntoymd = pKijyuntoymd;
    }

    @Transient
    @Override
    public Class<BM_YoteiRiritu2> getEntityClass() {
        return BM_YoteiRiritu2.class;
    }

    private String syouhncd;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }
    private String yoteiriritutkybr1;

    public String getYoteiriritutkybr1() {
        return yoteiriritutkybr1;
    }

    public void setYoteiriritutkybr1(String pYoteiriritutkybr1) {
        yoteiriritutkybr1 = pYoteiriritutkybr1;
    }
    private String yoteiriritutkybr2;

    public String getYoteiriritutkybr2() {
        return yoteiriritutkybr2;
    }

    public void setYoteiriritutkybr2(String pYoteiriritutkybr2) {
        yoteiriritutkybr2 = pYoteiriritutkybr2;
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