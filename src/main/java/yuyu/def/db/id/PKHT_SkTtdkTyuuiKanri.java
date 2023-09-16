package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_SkTtdkTyuuiKanri;
import yuyu.def.db.mapping.GenHT_SkTtdkTyuuiKanri;
import yuyu.def.db.meta.GenQHT_SkTtdkTyuuiKanri;
import yuyu.def.db.meta.QHT_SkTtdkTyuuiKanri;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 新契約手続注意管理テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SkTtdkTyuuiKanri}</td><td colspan="3">新契約手続注意管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>skeittdkkinkyuyouhikbn</td><td>新契約手続緊急要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YouhiKbn C_YouhiKbn}</td></tr>
 *  <tr><td>skeittdktyuuiyouhikbn</td><td>新契約手続注意要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YouhiKbn C_YouhiKbn}</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SkTtdkTyuuiKanri
 * @see     GenHT_SkTtdkTyuuiKanri
 * @see     QHT_SkTtdkTyuuiKanri
 * @see     GenQHT_SkTtdkTyuuiKanri
 */
public class PKHT_SkTtdkTyuuiKanri extends AbstractExDBPrimaryKey<HT_SkTtdkTyuuiKanri, PKHT_SkTtdkTyuuiKanri> {

    private static final long serialVersionUID = 1L;

    public PKHT_SkTtdkTyuuiKanri() {
    }

    public PKHT_SkTtdkTyuuiKanri(String pMosno) {
        mosno = pMosno;
    }

    @Transient
    @Override
    public Class<HT_SkTtdkTyuuiKanri> getEntityClass() {
        return HT_SkTtdkTyuuiKanri.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

}