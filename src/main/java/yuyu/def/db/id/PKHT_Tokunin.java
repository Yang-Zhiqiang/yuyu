package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_Tokunin;
import yuyu.def.db.mapping.GenHT_Tokunin;
import yuyu.def.db.meta.GenQHT_Tokunin;
import yuyu.def.db.meta.QHT_Tokunin;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 特認テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_Tokunin}</td><td colspan="3">特認テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>spgndtknkbn</td><td>ＳＰ限度特認区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SpgndtknKbn C_SpgndtknKbn}</td></tr>
 *  <tr><td>nenkkntknkbn</td><td>年齢期間特認区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NenkkntknKbn C_NenkkntknKbn}</td></tr>
 *  <tr><td>tsngndtknkbn</td><td>通算限度特認区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TsngndtknKbn C_TsngndtknKbn}</td></tr>
 *  <tr><td>sentakuinfotknkbn</td><td>選択情報特認区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SentakuinfotknKbn C_SentakuinfotknKbn}</td></tr>
 *  <tr><td>syorisimetknkbn</td><td>処理締切日特認区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyorisimetknKbn C_SyorisimetknKbn}</td></tr>
 *  <tr><td>kzmeigitknkbn</td><td>口座名義人特認区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KzmeigitknKbn C_KzmeigitknKbn}</td></tr>
 *  <tr><td>massitknkbn</td><td>末子特認区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MassitknKbn C_MassitknKbn}</td></tr>
 *  <tr><td>kakoymdkyytknkbn</td><td>過去日付許容特認区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KakoymdkyytknKbn C_KakoymdkyytknKbn}</td></tr>
 *  <tr><td>saiteiptknkbn</td><td>最低P特認区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SaiteiptknKbn C_SaiteiptknKbn}</td></tr>
 *  <tr><td>yoteiriritutknkbn</td><td>予定利率特認区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YoteiriritutknKbn C_YoteiriritutknKbn}</td></tr>
 *  <tr><td>nenreiuptknkbn</td><td>年齢アップ特認区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NenreiuptknKbn C_NenreiuptknKbn}</td></tr>
 *  <tr><td>signalkaihikbn</td><td>シグナル回避区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SignalkaihiKbn C_SignalkaihiKbn}</td></tr>
 *  <tr><td>ikkatuyouptknkbn</td><td>一括要Ｐ特認区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_IkkatuyouptknKbn C_IkkatuyouptknKbn}</td></tr>
 *  <tr><td>sonotatknkbn</td><td>その他特認区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SonotaTokuninKbn C_SonotaTokuninKbn}</td></tr>
 *  <tr><td>ketsyacd</td><td>決定者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_Tokunin
 * @see     GenHT_Tokunin
 * @see     QHT_Tokunin
 * @see     GenQHT_Tokunin
 */
public class PKHT_Tokunin extends AbstractExDBPrimaryKey<HT_Tokunin, PKHT_Tokunin> {

    private static final long serialVersionUID = 1L;

    public PKHT_Tokunin() {
    }

    public PKHT_Tokunin(String pMosno) {
        mosno = pMosno;
    }

    @Transient
    @Override
    public Class<HT_Tokunin> getEntityClass() {
        return HT_Tokunin.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

}