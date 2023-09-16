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
import yuyu.def.classification.C_HhknNenKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_YoteiRiritu;
import yuyu.def.db.mapping.GenBM_YoteiRiritu;
import yuyu.def.db.meta.GenQBM_YoteiRiritu;
import yuyu.def.db.meta.QBM_YoteiRiritu;

/**
 * 予定利率マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_YoteiRiritu}</td><td colspan="3">予定利率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">○</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHhknnenkbn hhknnenkbn}</td><td>被保険者年齢区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_HhknNenKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKykfromymd kykfromymd}</td><td>契約日自</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKyktoymd kyktoymd}</td><td>契約日至</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>yoteiriritu</td><td>予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_YoteiRiritu
 * @see     GenBM_YoteiRiritu
 * @see     QBM_YoteiRiritu
 * @see     GenQBM_YoteiRiritu
 */
public class PKBM_YoteiRiritu extends AbstractExDBPrimaryKey<BM_YoteiRiritu, PKBM_YoteiRiritu> {

    private static final long serialVersionUID = 1L;

    public PKBM_YoteiRiritu() {
    }

    public PKBM_YoteiRiritu(
        String pSyouhncd,
        C_Tuukasyu pTuukasyu,
        C_HhknNenKbn pHhknnenkbn,
        BizDate pKykfromymd,
        BizDate pKyktoymd
    ) {
        syouhncd = pSyouhncd;
        tuukasyu = pTuukasyu;
        hhknnenkbn = pHhknnenkbn;
        kykfromymd = pKykfromymd;
        kyktoymd = pKyktoymd;
    }

    @Transient
    @Override
    public Class<BM_YoteiRiritu> getEntityClass() {
        return BM_YoteiRiritu.class;
    }

    private String syouhncd;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }
    private C_Tuukasyu tuukasyu;

    @org.hibernate.annotations.Type(type="UserType_C_Tuukasyu")
    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }
    private C_HhknNenKbn hhknnenkbn;

    @org.hibernate.annotations.Type(type="UserType_C_HhknNenKbn")
    public C_HhknNenKbn getHhknnenkbn() {
        return hhknnenkbn;
    }

    public void setHhknnenkbn(C_HhknNenKbn pHhknnenkbn) {
        hhknnenkbn = pHhknnenkbn;
    }
    private BizDate kykfromymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getKykfromymd() {
        return kykfromymd;
    }

    public void setKykfromymd(BizDate pKykfromymd) {
        kykfromymd = pKykfromymd;
    }
    private BizDate kyktoymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getKyktoymd() {
        return kyktoymd;
    }

    public void setKyktoymd(BizDate pKyktoymd) {
        kyktoymd = pKyktoymd;
    }

}