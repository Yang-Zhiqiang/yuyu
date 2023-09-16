package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.mapping.GenHT_MosnoKanri;
import yuyu.def.db.meta.GenQHT_MosnoKanri;
import yuyu.def.db.meta.QHT_MosnoKanri;

/**
 * 申込番号管理テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_MosnoKanri}</td><td colspan="3">申込番号管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno8keta mosno8keta}</td><td>申込番号（８桁）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>saibankahikbn</td><td>採番可否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KahiKbn C_KahiKbn}</td></tr>
 *  <tr><td>mossykykyoteiymd</td><td>申込消却予定日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>saibanymd</td><td>採番日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_MosnoKanri
 * @see     GenHT_MosnoKanri
 * @see     QHT_MosnoKanri
 * @see     GenQHT_MosnoKanri
 */
public class PKHT_MosnoKanri extends AbstractExDBPrimaryKey<HT_MosnoKanri, PKHT_MosnoKanri> {

    private static final long serialVersionUID = 1L;

    public PKHT_MosnoKanri() {
    }

    public PKHT_MosnoKanri(String pMosno8keta) {
        mosno8keta = pMosno8keta;
    }

    @Transient
    @Override
    public Class<HT_MosnoKanri> getEntityClass() {
        return HT_MosnoKanri.class;
    }

    private String mosno8keta;

    public String getMosno8keta() {
        return mosno8keta;
    }

    public void setMosno8keta(String pMosno8keta) {
        mosno8keta = pMosno8keta;
    }

}