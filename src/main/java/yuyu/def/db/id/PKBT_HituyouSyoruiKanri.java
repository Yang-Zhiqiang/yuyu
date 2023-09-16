package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.BT_HituyouSyoruiKanri;
import yuyu.def.db.mapping.GenBT_HituyouSyoruiKanri;
import yuyu.def.db.meta.GenQBT_HituyouSyoruiKanri;
import yuyu.def.db.meta.QBT_HituyouSyoruiKanri;

/**
 * 必要書類管理テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_HituyouSyoruiKanri}</td><td colspan="3">必要書類管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">○</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_HituyouSyoruiKanri
 * @see     GenBT_HituyouSyoruiKanri
 * @see     QBT_HituyouSyoruiKanri
 * @see     GenQBT_HituyouSyoruiKanri
 */
public class PKBT_HituyouSyoruiKanri extends AbstractExDBPrimaryKey<BT_HituyouSyoruiKanri, PKBT_HituyouSyoruiKanri> {

    private static final long serialVersionUID = 1L;

    public PKBT_HituyouSyoruiKanri() {
    }

    public PKBT_HituyouSyoruiKanri(String pKouteikanriid, C_SyoruiCdKbn pSyoruiCd) {
        kouteikanriid = pKouteikanriid;
        syoruiCd = pSyoruiCd;
    }

    @Transient
    @Override
    public Class<BT_HituyouSyoruiKanri> getEntityClass() {
        return BT_HituyouSyoruiKanri.class;
    }

    private String kouteikanriid;

    public String getKouteikanriid() {
        return kouteikanriid;
    }

    public void setKouteikanriid(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }
    private C_SyoruiCdKbn syoruiCd;

    @org.hibernate.annotations.Type(type="UserType_C_SyoruiCdKbn")
    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }

}