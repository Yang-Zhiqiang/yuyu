package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_NenkinYoteiRiritu;
import yuyu.def.db.mapping.GenBM_NenkinYoteiRiritu;
import yuyu.def.db.meta.GenQBM_NenkinYoteiRiritu;
import yuyu.def.db.meta.QBM_NenkinYoteiRiritu;

/**
 * 年金開始後予定利率マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_NenkinYoteiRiritu}</td><td colspan="3">年金開始後予定利率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getNenkinsyu nenkinsyu}</td><td>年金種類</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">○</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKykfromymd kykfromymd}</td><td>契約日自</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKyktoymd kyktoymd}</td><td>契約日至</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>yoteiriritu</td><td>予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_NenkinYoteiRiritu
 * @see     GenBM_NenkinYoteiRiritu
 * @see     QBM_NenkinYoteiRiritu
 * @see     GenQBM_NenkinYoteiRiritu
 */
public class PKBM_NenkinYoteiRiritu extends AbstractExDBPrimaryKey<BM_NenkinYoteiRiritu, PKBM_NenkinYoteiRiritu> {

    private static final long serialVersionUID = 1L;

    public PKBM_NenkinYoteiRiritu() {
    }

    public PKBM_NenkinYoteiRiritu(
        String pNenkinsyu,
        C_Tuukasyu pTuukasyu,
        BizDate pKykfromymd,
        BizDate pKyktoymd
    ) {
        nenkinsyu = pNenkinsyu;
        tuukasyu = pTuukasyu;
        kykfromymd = pKykfromymd;
        kyktoymd = pKyktoymd;
    }

    @Transient
    @Override
    public Class<BM_NenkinYoteiRiritu> getEntityClass() {
        return BM_NenkinYoteiRiritu.class;
    }

    private String nenkinsyu;

    public String getNenkinsyu() {
        return nenkinsyu;
    }

    public void setNenkinsyu(String pNenkinsyu) {
        nenkinsyu = pNenkinsyu;
    }
    private C_Tuukasyu tuukasyu;

    @org.hibernate.annotations.Type(type="UserType_C_Tuukasyu")
    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
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