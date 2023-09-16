package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KessanKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_JidouSyuunouMeisai;
import yuyu.def.db.mapping.GenHT_JidouSyuunouMeisai;
import yuyu.def.db.meta.GenQHT_JidouSyuunouMeisai;
import yuyu.def.db.meta.QHT_JidouSyuunouMeisai;

/**
 * 自動収納照合明細テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_JidouSyuunouMeisai}</td><td colspan="3">自動収納照合明細テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKessankbn kessankbn}</td><td>決算区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_KessanKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRstuukasyu rstuukasyu}</td><td>領収通貨種類</td><td align="center">○</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>sgittikensuu</td><td>照合一致件数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>sgittigk</td><td>照合一致金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>sgittigkyen</td><td>照合一致金額（円）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>sghuittikensuu</td><td>照合不一致件数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>sghuittigk</td><td>照合不一致金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mostrkskensuu</td><td>申込取消件数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>mostrksgk</td><td>申込取消金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yuukoukknkeikakensuu</td><td>有効期間経過件数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>yuukoukknkeikagk</td><td>有効期間経過金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yokukurikosikensuu</td><td>翌日繰越件数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>yokukurikosigk</td><td>翌日繰越金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yokukurikosigkyen</td><td>翌日繰越金額（円）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>jnykntsgkensuu</td><td>自動入金対象外件数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>jnykntsggk</td><td>自動入金対象外金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tjkensuu</td><td>当日件数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tjgk</td><td>当日金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tjgkyen</td><td>当日金額（円）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>zenjitukurikosikensuu</td><td>前日繰越件数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zenjitukurikosigk</td><td>前日繰越金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hrkmtsrykensuu</td><td>振込手数料件数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hrkmtsrykingk</td><td>振込手数料金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_JidouSyuunouMeisai
 * @see     GenHT_JidouSyuunouMeisai
 * @see     QHT_JidouSyuunouMeisai
 * @see     GenQHT_JidouSyuunouMeisai
 */
public class PKHT_JidouSyuunouMeisai extends AbstractExDBPrimaryKey<HT_JidouSyuunouMeisai, PKHT_JidouSyuunouMeisai> {

    private static final long serialVersionUID = 1L;

    public PKHT_JidouSyuunouMeisai() {
    }

    public PKHT_JidouSyuunouMeisai(
        BizDate pSyoriYmd,
        C_KessanKbn pKessankbn,
        C_Tuukasyu pRstuukasyu
    ) {
        syoriYmd = pSyoriYmd;
        kessankbn = pKessankbn;
        rstuukasyu = pRstuukasyu;
    }

    @Transient
    @Override
    public Class<HT_JidouSyuunouMeisai> getEntityClass() {
        return HT_JidouSyuunouMeisai.class;
    }

    private BizDate syoriYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }
    private C_KessanKbn kessankbn;

    @org.hibernate.annotations.Type(type="UserType_C_KessanKbn")
    public C_KessanKbn getKessankbn() {
        return kessankbn;
    }

    public void setKessankbn(C_KessanKbn pKessankbn) {
        kessankbn = pKessankbn;
    }
    private C_Tuukasyu rstuukasyu;

    @org.hibernate.annotations.Type(type="UserType_C_Tuukasyu")
    public C_Tuukasyu getRstuukasyu() {
        return rstuukasyu;
    }

    public void setRstuukasyu(C_Tuukasyu pRstuukasyu) {
        rstuukasyu = pRstuukasyu;
    }

}