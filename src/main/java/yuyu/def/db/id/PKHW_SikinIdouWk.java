package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.HW_SikinIdouWk;
import yuyu.def.db.mapping.GenHW_SikinIdouWk;
import yuyu.def.db.meta.GenQHW_SikinIdouWk;
import yuyu.def.db.meta.QHW_SikinIdouWk;

/**
 * 資金移動ワークテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HW_SikinIdouWk}</td><td colspan="3">資金移動ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getNyksyoriymd nyksyoriymd}</td><td>入金処理日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getItirenno itirenno}</td><td>一連番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sikinidoumotohonkouzacd</td><td>資金移動元本口座コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sikinidousakihonkouzacd</td><td>資金移動先本口座コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sikinidougaku</td><td>資金移動額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>nykmosno</td><td>入金用申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HW_SikinIdouWk
 * @see     GenHW_SikinIdouWk
 * @see     QHW_SikinIdouWk
 * @see     GenQHW_SikinIdouWk
 */
public class PKHW_SikinIdouWk extends AbstractExDBPrimaryKey<HW_SikinIdouWk, PKHW_SikinIdouWk> {

    private static final long serialVersionUID = 1L;

    public PKHW_SikinIdouWk() {
    }

    public PKHW_SikinIdouWk(BizDate pNyksyoriymd, String pItirenno) {
        nyksyoriymd = pNyksyoriymd;
        itirenno = pItirenno;
    }

    @Transient
    @Override
    public Class<HW_SikinIdouWk> getEntityClass() {
        return HW_SikinIdouWk.class;
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