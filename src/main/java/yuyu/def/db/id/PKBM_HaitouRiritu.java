package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_HaitouRiritu;
import yuyu.def.db.mapping.GenBM_HaitouRiritu;
import yuyu.def.db.meta.GenQBM_HaitouRiritu;
import yuyu.def.db.meta.QBM_HaitouRiritu;

/**
 * 配当利率マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_HaitouRiritu}</td><td colspan="3">配当利率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKijyunfromymd kijyunfromymd}</td><td>基準日自</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKijyuntoymd kijyuntoymd}</td><td>基準日至</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>haitouriritu</td><td>配当利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_HaitouRiritu
 * @see     GenBM_HaitouRiritu
 * @see     QBM_HaitouRiritu
 * @see     GenQBM_HaitouRiritu
 */
public class PKBM_HaitouRiritu extends AbstractExDBPrimaryKey<BM_HaitouRiritu, PKBM_HaitouRiritu> {

    private static final long serialVersionUID = 1L;

    public PKBM_HaitouRiritu() {
    }

    public PKBM_HaitouRiritu(BizDate pKijyunfromymd, BizDate pKijyuntoymd) {
        kijyunfromymd = pKijyunfromymd;
        kijyuntoymd = pKijyuntoymd;
    }

    @Transient
    @Override
    public Class<BM_HaitouRiritu> getEntityClass() {
        return BM_HaitouRiritu.class;
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