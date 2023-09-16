package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_HengakuCfDenpyo;
import yuyu.def.db.mapping.GenIT_HengakuCfDenpyo;
import yuyu.def.db.meta.GenQIT_HengakuCfDenpyo;
import yuyu.def.db.meta.QIT_HengakuCfDenpyo;

/**
 * 変額ＣＦ伝票テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_HengakuCfDenpyo}</td><td colspan="3">変額ＣＦ伝票テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDenrenno denrenno}</td><td>伝票データ連番</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getEdano edano}</td><td>枝番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>unitfundkbn</td><td>ユニットファンド区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UnitFundKbn C_UnitFundKbn}</td></tr>
 *  <tr><td>tantocd</td><td>担当コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TantouCdKbn C_TantouCdKbn}</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>denymd</td><td>伝票日付</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>taisyakukbn</td><td>貸借区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TaisyakuKbn C_TaisyakuKbn}</td></tr>
 *  <tr><td>kanjyoukmkcd</td><td>勘定科目コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kanjyoukmkcd C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>tuukasyu</td><td>通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dengaikagk</td><td>伝票金額（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>denyenkagk</td><td>伝票金額（円）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     IT_HengakuCfDenpyo
 * @see     GenIT_HengakuCfDenpyo
 * @see     QIT_HengakuCfDenpyo
 * @see     GenQIT_HengakuCfDenpyo
 */
public class PKIT_HengakuCfDenpyo extends AbstractExDBPrimaryKey<IT_HengakuCfDenpyo, PKIT_HengakuCfDenpyo> {

    private static final long serialVersionUID = 1L;

    public PKIT_HengakuCfDenpyo() {
    }

    public PKIT_HengakuCfDenpyo(String pDenrenno, Integer pEdano) {
        denrenno = pDenrenno;
        edano = pEdano;
    }

    @Transient
    @Override
    public Class<IT_HengakuCfDenpyo> getEntityClass() {
        return IT_HengakuCfDenpyo.class;
    }

    private String denrenno;

    public String getDenrenno() {
        return denrenno;
    }

    public void setDenrenno(String pDenrenno) {
        denrenno = pDenrenno;
    }
    private Integer edano;

    public Integer getEdano() {
        return edano;
    }

    public void setEdano(Integer pEdano) {
        edano = pEdano;
    }

}