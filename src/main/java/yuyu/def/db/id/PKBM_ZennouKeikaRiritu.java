package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.def.db.entity.BM_ZennouKeikaRiritu;
import yuyu.def.db.mapping.GenBM_ZennouKeikaRiritu;
import yuyu.def.db.meta.GenQBM_ZennouKeikaRiritu;
import yuyu.def.db.meta.QBM_ZennouKeikaRiritu;

/**
 * 前納経過利率マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ZennouKeikaRiritu}</td><td colspan="3">前納経過利率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKeikatukisuu keikatukisuu}</td><td>経過月数（２桁）</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTekiyoukknfrom tekiyoukknfrom}</td><td>適用期間（自）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTekiyoukknkto tekiyoukknkto}</td><td>適用期間（至）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zennoukeikariritu</td><td>前納経過利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_ZennouKeikaRiritu
 * @see     GenBM_ZennouKeikaRiritu
 * @see     QBM_ZennouKeikaRiritu
 * @see     GenQBM_ZennouKeikaRiritu
 */
public class PKBM_ZennouKeikaRiritu extends AbstractExDBPrimaryKey<BM_ZennouKeikaRiritu, PKBM_ZennouKeikaRiritu> {

    private static final long serialVersionUID = 1L;

    public PKBM_ZennouKeikaRiritu() {
    }

    public PKBM_ZennouKeikaRiritu(
        Integer pKeikatukisuu,
        String pTekiyoukknfrom,
        String pTekiyoukknkto
    ) {
        keikatukisuu = pKeikatukisuu;
        tekiyoukknfrom = pTekiyoukknfrom;
        tekiyoukknkto = pTekiyoukknkto;
    }

    @Transient
    @Override
    public Class<BM_ZennouKeikaRiritu> getEntityClass() {
        return BM_ZennouKeikaRiritu.class;
    }

    private Integer keikatukisuu;

    public Integer getKeikatukisuu() {
        return keikatukisuu;
    }

    public void setKeikatukisuu(Integer pKeikatukisuu) {
        keikatukisuu = pKeikatukisuu;
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