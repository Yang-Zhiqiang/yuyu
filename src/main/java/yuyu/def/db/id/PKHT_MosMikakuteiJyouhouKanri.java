package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_MosMikakuteiJyouhouKanri;
import yuyu.def.db.mapping.GenHT_MosMikakuteiJyouhouKanri;
import yuyu.def.db.meta.GenQHT_MosMikakuteiJyouhouKanri;
import yuyu.def.db.meta.QHT_MosMikakuteiJyouhouKanri;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 申込未確定情報管理テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_MosMikakuteiJyouhouKanri}</td><td colspan="3">申込未確定情報管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>jimutetuzukicd</td><td>事務手続コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>skeijimukbn</td><td>新契約事務区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SkeijimuKbn C_SkeijimuKbn}</td></tr>
 *  <tr><td>mosuketukekbn</td><td>申込受付区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MosUketukeKbn C_MosUketukeKbn}</td></tr>
 *  <tr><td>hknsyuruino</td><td>保険種類番号</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HknsyuruiNo C_HknsyuruiNo}</td></tr>
 *  <tr><td>dairitencd1</td><td>代理店コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dairitencd2</td><td>代理店コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>jimuyoucd</td><td>事務用コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>doujimosumu</td><td>同時申込有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syorizumiflg</td><td>処理済フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Syorizumiflg C_Syorizumiflg}</td></tr>
 *  <tr><td>sakujoyoteiymd</td><td>削除予定日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>setmosno1</td><td>セット申込番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_MosMikakuteiJyouhouKanri
 * @see     GenHT_MosMikakuteiJyouhouKanri
 * @see     QHT_MosMikakuteiJyouhouKanri
 * @see     GenQHT_MosMikakuteiJyouhouKanri
 */
public class PKHT_MosMikakuteiJyouhouKanri extends AbstractExDBPrimaryKey<HT_MosMikakuteiJyouhouKanri, PKHT_MosMikakuteiJyouhouKanri> {

    private static final long serialVersionUID = 1L;

    public PKHT_MosMikakuteiJyouhouKanri() {
    }

    public PKHT_MosMikakuteiJyouhouKanri(String pMosno) {
        mosno = pMosno;
    }

    @Transient
    @Override
    public Class<HT_MosMikakuteiJyouhouKanri> getEntityClass() {
        return HT_MosMikakuteiJyouhouKanri.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

}