package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_BetukutiKeiyakuKbn;
import yuyu.def.db.entity.BM_PalSyoumetujiyuu;
import yuyu.def.db.mapping.GenBM_PalSyoumetujiyuu;
import yuyu.def.db.meta.GenQBM_PalSyoumetujiyuu;
import yuyu.def.db.meta.QBM_PalSyoumetujiyuu;

/**
 * ＰＡＬ消滅事由マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_PalSyoumetujiyuu}</td><td colspan="3">ＰＡＬ消滅事由マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalsyoumetucd palsyoumetucd}</td><td>ＰＡＬ消滅コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getBetukutikeiyakukbn betukutikeiyakukbn}</td><td>別口契約区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_BetukutiKeiyakuKbn}</td></tr>
 *  <tr><td>syoumetujiyuuname</td><td>消滅事由名称</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_PalSyoumetujiyuu
 * @see     GenBM_PalSyoumetujiyuu
 * @see     QBM_PalSyoumetujiyuu
 * @see     GenQBM_PalSyoumetujiyuu
 */
public class PKBM_PalSyoumetujiyuu extends AbstractExDBPrimaryKey<BM_PalSyoumetujiyuu, PKBM_PalSyoumetujiyuu> {

    private static final long serialVersionUID = 1L;

    public PKBM_PalSyoumetujiyuu() {
    }

    public PKBM_PalSyoumetujiyuu(String pPalsyoumetucd, C_BetukutiKeiyakuKbn pBetukutikeiyakukbn) {
        palsyoumetucd = pPalsyoumetucd;
        betukutikeiyakukbn = pBetukutikeiyakukbn;
    }

    @Transient
    @Override
    public Class<BM_PalSyoumetujiyuu> getEntityClass() {
        return BM_PalSyoumetujiyuu.class;
    }

    private String palsyoumetucd;

    public String getPalsyoumetucd() {
        return palsyoumetucd;
    }

    public void setPalsyoumetucd(String pPalsyoumetucd) {
        palsyoumetucd = pPalsyoumetucd;
    }
    private C_BetukutiKeiyakuKbn betukutikeiyakukbn;

    @org.hibernate.annotations.Type(type="UserType_C_BetukutiKeiyakuKbn")
    public C_BetukutiKeiyakuKbn getBetukutikeiyakukbn() {
        return betukutikeiyakukbn;
    }

    public void setBetukutikeiyakukbn(C_BetukutiKeiyakuKbn pBetukutikeiyakukbn) {
        betukutikeiyakukbn = pBetukutikeiyakukbn;
    }

}