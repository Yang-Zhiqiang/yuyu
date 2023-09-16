package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BM_SikinIdouListCsvFLayout;
import yuyu.def.db.mapping.GenBM_SikinIdouListCsvFLayout;
import yuyu.def.db.meta.GenQBM_SikinIdouListCsvFLayout;
import yuyu.def.db.meta.QBM_SikinIdouListCsvFLayout;

/**
 * 資金移動リストＣＳＶファイルレイアウトマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_SikinIdouListCsvFLayout}</td><td colspan="3">資金移動リストＣＳＶファイルレイアウトマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getHyoujijyun hyoujijyun}</td><td>表示順</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>sikinidoulistkbn</td><td>資金移動リスト区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SikinidoulistKbn C_SikinidoulistKbn}</td></tr>
 *  <tr><td>syukkinkouzatuukasyu</td><td>出金口座通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>syukkinkouzano</td><td>出金口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukkinkouzakbn</td><td>出金口座区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SikinidoukouzaKbn C_SikinidoukouzaKbn}</td></tr>
 *  <tr><td>nyuukinkouzatuukasyu</td><td>入金口座通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>nyuukinkouzano</td><td>入金口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nyuukinkouzakbn</td><td>入金口座区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SikinidoukouzaKbn C_SikinidoukouzaKbn}</td></tr>
 * </table>
 * @see     BM_SikinIdouListCsvFLayout
 * @see     GenBM_SikinIdouListCsvFLayout
 * @see     QBM_SikinIdouListCsvFLayout
 * @see     GenQBM_SikinIdouListCsvFLayout
 */
public class PKBM_SikinIdouListCsvFLayout extends AbstractExDBPrimaryKey<BM_SikinIdouListCsvFLayout, PKBM_SikinIdouListCsvFLayout> {

    private static final long serialVersionUID = 1L;

    public PKBM_SikinIdouListCsvFLayout() {
    }

    public PKBM_SikinIdouListCsvFLayout(Integer pHyoujijyun) {
        hyoujijyun = pHyoujijyun;
    }

    @Transient
    @Override
    public Class<BM_SikinIdouListCsvFLayout> getEntityClass() {
        return BM_SikinIdouListCsvFLayout.class;
    }

    private Integer hyoujijyun;

    public Integer getHyoujijyun() {
        return hyoujijyun;
    }

    public void setHyoujijyun(Integer pHyoujijyun) {
        hyoujijyun = pHyoujijyun;
    }

}