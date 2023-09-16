package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BT_KbtKarikanjyou;
import yuyu.def.db.mapping.GenBT_KbtKarikanjyou;
import yuyu.def.db.meta.GenQBT_KbtKarikanjyou;
import yuyu.def.db.meta.QBT_KbtKarikanjyou;

/**
 * 個別仮勘定テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_KbtKarikanjyou}</td><td colspan="3">個別仮勘定テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbtkarikanjyouskbtkey kbtkarikanjyouskbtkey}</td><td>個別仮勘定識別キー</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>densyskbn</td><td>伝票用システム区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DensysKbn C_DensysKbn}</td></tr>
 *  <tr><td>denrenno</td><td>伝票データ連番</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>edano</td><td>枝番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>keirisyono</td><td>経理用証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nyuukinkakusyouno</td><td>入金確証番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hurikaedenskssyoriymd</td><td>振替伝票作成処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>denymd</td><td>伝票日付</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>huridenatesakicd</td><td>振替伝票宛先部課コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>taisyakukbn</td><td>貸借区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TaisyakuKbn C_TaisyakuKbn}</td></tr>
 *  <tr><td>kanjyoukmkcd</td><td>勘定科目コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kanjyoukmkcd C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>denyenkagk</td><td>伝票金額（円）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syoricd</td><td>処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syorisosikicd</td><td>処理組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kbtkarikanjyoukbn</td><td>個別仮勘定区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kskmkanryouymd</td><td>消込完了年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>seg1cd</td><td>セグメント１コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Segcd C_Segcd}</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     BT_KbtKarikanjyou
 * @see     GenBT_KbtKarikanjyou
 * @see     QBT_KbtKarikanjyou
 * @see     GenQBT_KbtKarikanjyou
 */
public class PKBT_KbtKarikanjyou extends AbstractExDBPrimaryKey<BT_KbtKarikanjyou, PKBT_KbtKarikanjyou> {

    private static final long serialVersionUID = 1L;

    public PKBT_KbtKarikanjyou() {
    }

    public PKBT_KbtKarikanjyou(BizNumber pKbtkarikanjyouskbtkey) {
        kbtkarikanjyouskbtkey = pKbtkarikanjyouskbtkey;
    }

    @Transient
    @Override
    public Class<BT_KbtKarikanjyou> getEntityClass() {
        return BT_KbtKarikanjyou.class;
    }

    private BizNumber kbtkarikanjyouskbtkey;

    @org.hibernate.annotations.Type(type="BizNumberType")
    public BizNumber getKbtkarikanjyouskbtkey() {
        return kbtkarikanjyouskbtkey;
    }

    public void setKbtkarikanjyouskbtkey(BizNumber pKbtkarikanjyouskbtkey) {
        kbtkarikanjyouskbtkey = pKbtkarikanjyouskbtkey;
    }

}