package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.db.entity.BT_SinkeiyakuHurikaeDen;
import yuyu.def.db.mapping.GenBT_SinkeiyakuHurikaeDen;
import yuyu.def.db.meta.GenQBT_SinkeiyakuHurikaeDen;
import yuyu.def.db.meta.QBT_SinkeiyakuHurikaeDen;

/**
 * 新契約振替伝票作成用テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_SinkeiyakuHurikaeDen}</td><td colspan="3">新契約振替伝票作成用テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDensyskbn densyskbn}</td><td>伝票用システム区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_DensysKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDenrenno denrenno}</td><td>伝票データ連番</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getEdano edano}</td><td>枝番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>torihikino</td><td>取引番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>keirisyskbn</td><td>経理システム区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KeirisysKbn C_KeirisysKbn}</td></tr>
 *  <tr><td>keirisyono</td><td>経理用証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>huridenatesakicd</td><td>振替伝票宛先部課コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tantocd</td><td>担当コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TantouCdKbn C_TantouCdKbn}</td></tr>
 *  <tr><td>denymd</td><td>伝票日付</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>taisyakukbn</td><td>貸借区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TaisyakuKbn C_TaisyakuKbn}</td></tr>
 *  <tr><td>kanjyoukmkcd</td><td>勘定科目コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kanjyoukmkcd C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>denkanjokamokucd</td><td>伝票用勘定科目コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kanjyoukmkgroupkbn</td><td>勘定科目グループ区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KanjyoukmkgroupKbn C_KanjyoukmkgroupKbn}</td></tr>
 *  <tr><td>suitoubumoncd</td><td>出納部門コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>denyenkagk</td><td>伝票金額（円）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>naibukeiyakukbn</td><td>内部契約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NaibuKeiyakuKbn C_NaibuKeiyakuKbn}</td></tr>
 *  <tr><td>tekiyoukbn</td><td>摘要区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TekiyouKbn C_TekiyouKbn}</td></tr>
 *  <tr><td>tekiyoucd</td><td>摘要コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>huridenpyoukyktuukakbn</td><td>振替伝票用契約通貨区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HuriDenpyouKykTuukaKbn C_HuriDenpyouKykTuukaKbn}</td></tr>
 *  <tr><td>tuukasyu</td><td>通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dengyoumucd</td><td>伝票用業務コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_SinkeiyakuHurikaeDen
 * @see     GenBT_SinkeiyakuHurikaeDen
 * @see     QBT_SinkeiyakuHurikaeDen
 * @see     GenQBT_SinkeiyakuHurikaeDen
 */
public class PKBT_SinkeiyakuHurikaeDen extends AbstractExDBPrimaryKey<BT_SinkeiyakuHurikaeDen, PKBT_SinkeiyakuHurikaeDen> {

    private static final long serialVersionUID = 1L;

    public PKBT_SinkeiyakuHurikaeDen() {
    }

    public PKBT_SinkeiyakuHurikaeDen(
        C_DensysKbn pDensyskbn,
        String pDenrenno,
        Integer pEdano
    ) {
        densyskbn = pDensyskbn;
        denrenno = pDenrenno;
        edano = pEdano;
    }

    @Transient
    @Override
    public Class<BT_SinkeiyakuHurikaeDen> getEntityClass() {
        return BT_SinkeiyakuHurikaeDen.class;
    }

    private C_DensysKbn densyskbn;

    @org.hibernate.annotations.Type(type="UserType_C_DensysKbn")
    public C_DensysKbn getDensyskbn() {
        return densyskbn;
    }

    public void setDensyskbn(C_DensysKbn pDensyskbn) {
        densyskbn = pDensyskbn;
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