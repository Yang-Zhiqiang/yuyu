package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.mapping.GenBM_TantouCd;
import yuyu.def.db.meta.GenQBM_TantouCd;
import yuyu.def.db.meta.QBM_TantouCd;

/**
 * 担当コードマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_TantouCd}</td><td colspan="3">担当コードマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getTantocd tantocd}</td><td>担当コード</td><td align="center">○</td><td align="center">V</td><td>{@link C_TantouCdKbn}</td></tr>
 *  <tr><td>busitucd</td><td>部・室コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tantounm</td><td>担当名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>busitunm</td><td>部・室名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_TantouCd
 * @see     GenBM_TantouCd
 * @see     QBM_TantouCd
 * @see     GenQBM_TantouCd
 */
public class PKBM_TantouCd extends AbstractExDBPrimaryKey<BM_TantouCd, PKBM_TantouCd> {

    private static final long serialVersionUID = 1L;

    public PKBM_TantouCd() {
    }

    public PKBM_TantouCd(C_TantouCdKbn pTantocd) {
        tantocd = pTantocd;
    }

    @Transient
    @Override
    public Class<BM_TantouCd> getEntityClass() {
        return BM_TantouCd.class;
    }

    private C_TantouCdKbn tantocd;

    @org.hibernate.annotations.Type(type="UserType_C_TantouCdKbn")
    public C_TantouCdKbn getTantocd() {
        return tantocd;
    }

    public void setTantocd(C_TantouCdKbn pTantocd) {
        tantocd = pTantocd;
    }

}