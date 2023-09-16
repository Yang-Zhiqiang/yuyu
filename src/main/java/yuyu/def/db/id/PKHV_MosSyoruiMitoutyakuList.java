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
import yuyu.def.db.entity.HV_MosSyoruiMitoutyakuList;
import yuyu.def.db.mapping.GenHV_MosSyoruiMitoutyakuList;
import yuyu.def.db.meta.GenQHV_MosSyoruiMitoutyakuList;
import yuyu.def.db.meta.QHV_MosSyoruiMitoutyakuList;

/**
 * 申込書類未到着リスト情報ビュー のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HV_MosSyoruiMitoutyakuList}</td><td colspan="3">申込書類未到着リスト情報ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getItirenno itirenno}</td><td>一連番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nykmosno</td><td>入金用申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bankcd</td><td>銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitencd</td><td>支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>simukebanknmkn</td><td>仕向銀行名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>simukebanknmeiji</td><td>仕向銀行名（英字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>simuketennmkn</td><td>仕向店名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>simuketennmeiji</td><td>仕向店名（英字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>knjyymd</td><td>勘定日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>trhkkgk</td><td>取引金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dengk</td><td>伝票金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tuukasyu</td><td>通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>hrkmirninnm</td><td>振込依頼人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>oyadrtencd</td><td>親代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nyuukinoyadrtennm</td><td>入金用親代理店名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mostokusokuumu</td><td>申込書類督促有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>siteituuka</td><td>指定通貨</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>hrkmnykndatarenmotoKbn</td><td>振込入金データ連携元区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HrkmnykndatarenmotoKbn C_HrkmnykndatarenmotoKbn}</td></tr>
 *  <tr><td>syouhnno</td><td>商品番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nyktyhyoutkbn</td><td>入金帳票出力先区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NyktyhyoutKbn C_NyktyhyoutKbn}</td></tr>
 * </table>
 * @see     HV_MosSyoruiMitoutyakuList
 * @see     GenHV_MosSyoruiMitoutyakuList
 * @see     QHV_MosSyoruiMitoutyakuList
 * @see     GenQHV_MosSyoruiMitoutyakuList
 */
public class PKHV_MosSyoruiMitoutyakuList extends AbstractExDBPrimaryKey<HV_MosSyoruiMitoutyakuList, PKHV_MosSyoruiMitoutyakuList> {

    private static final long serialVersionUID = 1L;

    public PKHV_MosSyoruiMitoutyakuList() {
    }

    public PKHV_MosSyoruiMitoutyakuList(BizDate pSyoriYmd, String pItirenno) {
        syoriYmd = pSyoriYmd;
        itirenno = pItirenno;
    }

    @Transient
    @Override
    public Class<HV_MosSyoruiMitoutyakuList> getEntityClass() {
        return HV_MosSyoruiMitoutyakuList.class;
    }

    private BizDate syoriYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }
    private String itirenno;

    public String getItirenno() {
        return itirenno;
    }

    public void setItirenno(String pItirenno) {
        itirenno = pItirenno;
    }

}