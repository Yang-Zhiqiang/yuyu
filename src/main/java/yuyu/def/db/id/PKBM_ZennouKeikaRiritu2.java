package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ZennouKeikaRiritu2;
import yuyu.def.db.mapping.GenBM_ZennouKeikaRiritu2;
import yuyu.def.db.meta.GenQBM_ZennouKeikaRiritu2;
import yuyu.def.db.meta.QBM_ZennouKeikaRiritu2;

/**
 * 前納経過利率マスタ２ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ZennouKeikaRiritu2}</td><td colspan="3">前納経過利率マスタ２</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">○</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZennoutkybr1 zennoutkybr1}</td><td>前納適用分類１</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZennoutkybr2 zennoutkybr2}</td><td>前納適用分類２</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZennoutkybr3 zennoutkybr3}</td><td>前納適用分類３</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKeikatukisuu keikatukisuu}</td><td>経過月数（２桁）</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTekiyoukknfrom tekiyoukknfrom}</td><td>適用期間（自）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTekiyoukknkto tekiyoukknkto}</td><td>適用期間（至）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zennoukeikariritu</td><td>前納経過利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_ZennouKeikaRiritu2
 * @see     GenBM_ZennouKeikaRiritu2
 * @see     QBM_ZennouKeikaRiritu2
 * @see     GenQBM_ZennouKeikaRiritu2
 */
public class PKBM_ZennouKeikaRiritu2 extends AbstractExDBPrimaryKey<BM_ZennouKeikaRiritu2, PKBM_ZennouKeikaRiritu2> {

    private static final long serialVersionUID = 1L;

    public PKBM_ZennouKeikaRiritu2() {
    }

    public PKBM_ZennouKeikaRiritu2(
        C_Tuukasyu pTuukasyu,
        String pZennoutkybr1,
        String pZennoutkybr2,
        String pZennoutkybr3,
        Integer pKeikatukisuu,
        String pTekiyoukknfrom,
        String pTekiyoukknkto
    ) {
        tuukasyu = pTuukasyu;
        zennoutkybr1 = pZennoutkybr1;
        zennoutkybr2 = pZennoutkybr2;
        zennoutkybr3 = pZennoutkybr3;
        keikatukisuu = pKeikatukisuu;
        tekiyoukknfrom = pTekiyoukknfrom;
        tekiyoukknkto = pTekiyoukknkto;
    }

    @Transient
    @Override
    public Class<BM_ZennouKeikaRiritu2> getEntityClass() {
        return BM_ZennouKeikaRiritu2.class;
    }

    private C_Tuukasyu tuukasyu;

    @org.hibernate.annotations.Type(type="UserType_C_Tuukasyu")
    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }
    private String zennoutkybr1;

    public String getZennoutkybr1() {
        return zennoutkybr1;
    }

    public void setZennoutkybr1(String pZennoutkybr1) {
        zennoutkybr1 = pZennoutkybr1;
    }
    private String zennoutkybr2;

    public String getZennoutkybr2() {
        return zennoutkybr2;
    }

    public void setZennoutkybr2(String pZennoutkybr2) {
        zennoutkybr2 = pZennoutkybr2;
    }
    private String zennoutkybr3;

    public String getZennoutkybr3() {
        return zennoutkybr3;
    }

    public void setZennoutkybr3(String pZennoutkybr3) {
        zennoutkybr3 = pZennoutkybr3;
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