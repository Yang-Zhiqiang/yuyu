package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.HW_JidouNyknTaisyougaiWk;
import yuyu.def.db.mapping.GenHW_JidouNyknTaisyougaiWk;
import yuyu.def.db.meta.GenQHW_JidouNyknTaisyougaiWk;
import yuyu.def.db.meta.QHW_JidouNyknTaisyougaiWk;

/**
 * 自動入金対象外ワークテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HW_JidouNyknTaisyougaiWk}</td><td colspan="3">自動入金対象外ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getNyksyoriymd nyksyoriymd}</td><td>入金処理日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getItirenno itirenno}</td><td>一連番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nykmosno</td><td>入金用申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>oyadrtencd</td><td>親代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trhkkgk</td><td>取引金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>rstuukasyu</td><td>領収通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nyktyhyoutkbn</td><td>入金帳票出力先区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NyktyhyoutKbn C_NyktyhyoutKbn}</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HW_JidouNyknTaisyougaiWk
 * @see     GenHW_JidouNyknTaisyougaiWk
 * @see     QHW_JidouNyknTaisyougaiWk
 * @see     GenQHW_JidouNyknTaisyougaiWk
 */
public class PKHW_JidouNyknTaisyougaiWk extends AbstractExDBPrimaryKey<HW_JidouNyknTaisyougaiWk, PKHW_JidouNyknTaisyougaiWk> {

    private static final long serialVersionUID = 1L;

    public PKHW_JidouNyknTaisyougaiWk() {
    }

    public PKHW_JidouNyknTaisyougaiWk(BizDate pNyksyoriymd, String pItirenno) {
        nyksyoriymd = pNyksyoriymd;
        itirenno = pItirenno;
    }

    @Transient
    @Override
    public Class<HW_JidouNyknTaisyougaiWk> getEntityClass() {
        return HW_JidouNyknTaisyougaiWk.class;
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