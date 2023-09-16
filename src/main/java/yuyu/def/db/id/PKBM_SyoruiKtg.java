package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.BM_SyoruiKtg;
import yuyu.def.db.mapping.GenBM_SyoruiKtg;
import yuyu.def.db.meta.GenQBM_SyoruiKtg;
import yuyu.def.db.meta.QBM_SyoruiKtg;

/**
 * 書類結合マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_SyoruiKtg}</td><td colspan="3">書類結合マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">○</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKtgsyoruicd ktgsyoruicd}</td><td>結合対象書類コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sortNo</td><td>ソート番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     BM_SyoruiKtg
 * @see     GenBM_SyoruiKtg
 * @see     QBM_SyoruiKtg
 * @see     GenQBM_SyoruiKtg
 */
public class PKBM_SyoruiKtg extends AbstractExDBPrimaryKey<BM_SyoruiKtg, PKBM_SyoruiKtg> {

    private static final long serialVersionUID = 1L;

    public PKBM_SyoruiKtg() {
    }

    public PKBM_SyoruiKtg(C_SyoruiCdKbn pSyoruiCd, String pKtgsyoruicd) {
        syoruiCd = pSyoruiCd;
        ktgsyoruicd = pKtgsyoruicd;
    }

    @Transient
    @Override
    public Class<BM_SyoruiKtg> getEntityClass() {
        return BM_SyoruiKtg.class;
    }

    private C_SyoruiCdKbn syoruiCd;

    @org.hibernate.annotations.Type(type="UserType_C_SyoruiCdKbn")
    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }
    private String ktgsyoruicd;

    public String getKtgsyoruicd() {
        return ktgsyoruicd;
    }

    public void setKtgsyoruicd(String pKtgsyoruicd) {
        ktgsyoruicd = pKtgsyoruicd;
    }

}