package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.mapping.GenBT_DenpyoData;
import yuyu.def.db.meta.GenQBT_DenpyoData;
import yuyu.def.db.meta.QBT_DenpyoData;

/**
 * 経理伝票データテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_DenpyoData}</td><td colspan="3">経理伝票データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDensyskbn densyskbn}</td><td>伝票用システム区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_DensysKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDenrenno denrenno}</td><td>伝票データ連番</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getEdano edano}</td><td>枝番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>keirisyono</td><td>経理用証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>huridenatesakicd</td><td>振替伝票宛先部課コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tantocd</td><td>担当コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TantouCdKbn C_TantouCdKbn}</td></tr>
 *  <tr><td>denymd</td><td>伝票日付</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>taisyakukbn</td><td>貸借区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TaisyakuKbn C_TaisyakuKbn}</td></tr>
 *  <tr><td>kanjyoukmkcd</td><td>勘定科目コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kanjyoukmkcd C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>suitoubumoncd</td><td>出納部門コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tuukasyu</td><td>通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>dengaikagk</td><td>伝票金額（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>denkawaserate</td><td>伝票用為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>denyenkagk</td><td>伝票金額（円）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>huridenskskbn</td><td>振替伝票作成区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HuridensksKbn C_HuridensksKbn}</td></tr>
 *  <tr><td>denhnknhoukbn</td><td>伝票用返金方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DenhnknhouKbn C_DenhnknhouKbn}</td></tr>
 *  <tr><td>denshrhoukbn</td><td>伝票用支払方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DenshrhouKbn C_DenshrhouKbn}</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syoricd</td><td>処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syorisosikicd</td><td>処理組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>seg1cd</td><td>セグメント１コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Segcd C_Segcd}</td></tr>
 *  <tr><td>seg2cd</td><td>セグメント２コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Segcd C_Segcd}</td></tr>
 *  <tr><td>kessantyouseikbn</td><td>決算調整区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KessantyouseiKbn C_KessantyouseiKbn}</td></tr>
 *  <tr><td>naibukeiyakukbn</td><td>内部契約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NaibuKeiyakuKbn C_NaibuKeiyakuKbn}</td></tr>
 *  <tr><td>tekiyoukbn</td><td>摘要区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TekiyouKbn C_TekiyouKbn}</td></tr>
 *  <tr><td>densyorikbn</td><td>伝票処理区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DensyoriKbn C_DensyoriKbn}</td></tr>
 *  <tr><td>aatsukaishasuitososhikicd</td><td>Ａ扱者出納組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>bosyuuym</td><td>募集年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>aatsukaishasoshikicd</td><td>Ａ扱者組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>aatkisyadaibosyuucd</td><td>Ａ扱者代表募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syusyouhncd</td><td>主契約商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnsdno</td><td>商品世代番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>sdpdkbn</td><td>Ｓ建Ｐ建区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Sdpd C_Sdpd}</td></tr>
 *  <tr><td>hrkkaisuu</td><td>払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>hrkkeiro</td><td>払込経路</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkeiro C_Hrkkeiro}</td></tr>
 *  <tr><td>sknnkaisiymd</td><td>責任開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>mosymd</td><td>申込日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hnknriyuukbn</td><td>返金理由区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HenkinriyuuKbn C_HenkinriyuuKbn}</td></tr>
 *  <tr><td>fstpryosyuymd</td><td>初回Ｐ領収日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>aatkisyabosyuucd</td><td>Ａ扱者募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ryouritusdno</td><td>料率世代番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kakokawaserateshiteiflg</td><td>過去為替レート指定フラグ</td><td>&nbsp;</td><td align="center">B</td><td>Boolean</td></tr>
 *  <tr><td>kakokawaserateshiteiymd</td><td>過去為替レート指定年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kyktuukasyu</td><td>契約通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>keiyakutuukagk</td><td>契約通貨金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dengyoumucd</td><td>伝票用業務コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kawasetekiyokbn</td><td>為替適用区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KawasetekiyoKbn C_KawasetekiyoKbn}</td></tr>
 *  <tr><td>denkarikanjyono</td><td>伝票用仮勘定番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>taisyakutyouseiflg</td><td>貸借調整フラグ</td><td>&nbsp;</td><td align="center">B</td><td>Boolean</td></tr>
 *  <tr><td>hijynbrsikinidouyoukbn</td><td>平準払資金移動要区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HijynbrsikinidouyouKbn C_HijynbrsikinidouyouKbn}</td></tr>
 *  <tr><td>hijynbrsikinidougk</td><td>平準払資金移動金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>densyorisyousaikbn</td><td>伝票用処理詳細区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DenSyorisyousaiKbn C_DenSyorisyousaiKbn}</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_DenpyoData
 * @see     GenBT_DenpyoData
 * @see     QBT_DenpyoData
 * @see     GenQBT_DenpyoData
 */
public class PKBT_DenpyoData extends AbstractExDBPrimaryKey<BT_DenpyoData, PKBT_DenpyoData> {

    private static final long serialVersionUID = 1L;

    public PKBT_DenpyoData() {
    }

    public PKBT_DenpyoData(
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
    public Class<BT_DenpyoData> getEntityClass() {
        return BT_DenpyoData.class;
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