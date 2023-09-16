package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.HW_MosMatiKknKeikaWk;
import yuyu.def.db.mapping.GenHW_MosMatiKknKeikaWk;
import yuyu.def.db.meta.GenQHW_MosMatiKknKeikaWk;
import yuyu.def.db.meta.QHW_MosMatiKknKeikaWk;

/**
 * 申込書入力待期間経過ワークテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HW_MosMatiKknKeikaWk}</td><td colspan="3">申込書入力待期間経過ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getNyksyoriymd nyksyoriymd}</td><td>入金処理日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getItirenno itirenno}</td><td>一連番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>oyadrtencd</td><td>親代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>knjyymd</td><td>勘定日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>mosno</td><td>申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmirninnm</td><td>振込依頼人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trhkkgk</td><td>取引金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>rstuukasyu</td><td>領収通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nyuukinoyadrtennm</td><td>入金用親代理店名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmnykndatarenmotoKbn</td><td>振込入金データ連携元区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HrkmnykndatarenmotoKbn C_HrkmnykndatarenmotoKbn}</td></tr>
 *  <tr><td>nyktyhyoutkbn</td><td>入金帳票出力先区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NyktyhyoutKbn C_NyktyhyoutKbn}</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HW_MosMatiKknKeikaWk
 * @see     GenHW_MosMatiKknKeikaWk
 * @see     QHW_MosMatiKknKeikaWk
 * @see     GenQHW_MosMatiKknKeikaWk
 */
public class PKHW_MosMatiKknKeikaWk extends AbstractExDBPrimaryKey<HW_MosMatiKknKeikaWk, PKHW_MosMatiKknKeikaWk> {

    private static final long serialVersionUID = 1L;

    public PKHW_MosMatiKknKeikaWk() {
    }

    public PKHW_MosMatiKknKeikaWk(BizDate pNyksyoriymd, String pItirenno) {
        nyksyoriymd = pNyksyoriymd;
        itirenno = pItirenno;
    }

    @Transient
    @Override
    public Class<HW_MosMatiKknKeikaWk> getEntityClass() {
        return HW_MosMatiKknKeikaWk.class;
    }

    private BizDate nyksyoriymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getNyksyoriymd() {
        return nyksyoriymd;
    }

    public void setNyksyoriymd(BizDate pNyksyoriymd) {
        nyksyoriymd = pNyksyoriymd;
    }
    private String itirenno;

    public String getItirenno() {
        return itirenno;
    }

    public void setItirenno(String pItirenno) {
        itirenno = pItirenno;
    }

}