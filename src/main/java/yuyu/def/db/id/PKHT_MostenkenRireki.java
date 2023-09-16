package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_MostenkenRireki;
import yuyu.def.db.mapping.GenHT_MostenkenRireki;
import yuyu.def.db.meta.GenQHT_MostenkenRireki;
import yuyu.def.db.meta.QHT_MostenkenRireki;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 申込点検履歴テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_MostenkenRireki}</td><td colspan="3">申込点検履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sateiketsyorinmkbn</td><td>査定・決定処理名区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SateiketsyorinmKbn C_SateiketsyorinmKbn}</td></tr>
 *  <tr><td>mostenkenkekkakbn</td><td>申込点検結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyorikekkaKbn C_SyorikekkaKbn}</td></tr>
 *  <tr><td>tnsketsyacd</td><td>転送先決定者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ketsyacd</td><td>決定者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>palketsyacd</td><td>ＰＡＬ決定者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mostenkencomment</td><td>申込点検コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_MostenkenRireki
 * @see     GenHT_MostenkenRireki
 * @see     QHT_MostenkenRireki
 * @see     GenQHT_MostenkenRireki
 */
public class PKHT_MostenkenRireki extends AbstractExDBPrimaryKey<HT_MostenkenRireki, PKHT_MostenkenRireki> {

    private static final long serialVersionUID = 1L;

    public PKHT_MostenkenRireki() {
    }

    public PKHT_MostenkenRireki(String pMosno, Integer pRenno) {
        mosno = pMosno;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<HT_MostenkenRireki> getEntityClass() {
        return HT_MostenkenRireki.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}