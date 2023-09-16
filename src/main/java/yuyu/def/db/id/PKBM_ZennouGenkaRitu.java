package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.def.db.entity.BM_ZennouGenkaRitu;
import yuyu.def.db.mapping.GenBM_ZennouGenkaRitu;
import yuyu.def.db.meta.GenQBM_ZennouGenkaRitu;
import yuyu.def.db.meta.QBM_ZennouGenkaRitu;

/**
 * 前納現価率マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ZennouGenkaRitu}</td><td colspan="3">前納現価率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZennounensuu zennounensuu}</td><td>前納年数</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTekiyoukknfrom tekiyoukknfrom}</td><td>適用期間（自）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTekiyoukknkto tekiyoukknkto}</td><td>適用期間（至）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zennougenkaritu</td><td>前納現価率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_ZennouGenkaRitu
 * @see     GenBM_ZennouGenkaRitu
 * @see     QBM_ZennouGenkaRitu
 * @see     GenQBM_ZennouGenkaRitu
 */
public class PKBM_ZennouGenkaRitu extends AbstractExDBPrimaryKey<BM_ZennouGenkaRitu, PKBM_ZennouGenkaRitu> {

    private static final long serialVersionUID = 1L;

    public PKBM_ZennouGenkaRitu() {
    }

    public PKBM_ZennouGenkaRitu(
        Integer pZennounensuu,
        String pTekiyoukknfrom,
        String pTekiyoukknkto
    ) {
        zennounensuu = pZennounensuu;
        tekiyoukknfrom = pTekiyoukknfrom;
        tekiyoukknkto = pTekiyoukknkto;
    }

    @Transient
    @Override
    public Class<BM_ZennouGenkaRitu> getEntityClass() {
        return BM_ZennouGenkaRitu.class;
    }

    private Integer zennounensuu;

    public Integer getZennounensuu() {
        return zennounensuu;
    }

    public void setZennounensuu(Integer pZennounensuu) {
        zennounensuu = pZennounensuu;
    }
    private String tekiyoukknfrom;

    public String getTekiyoukknfrom() {
        return tekiyoukknfrom;
    }

    public void setTekiyoukknfrom(String pTekiyoukknfrom) {
        tekiyoukknfrom = pTekiyoukknfrom;
    }
    private String tekiyoukknkto;

    public String getTekiyoukknkto() {
        return tekiyoukknkto;
    }

    public void setTekiyoukknkto(String pTekiyoukknkto) {
        tekiyoukknkto = pTekiyoukknkto;
    }

}