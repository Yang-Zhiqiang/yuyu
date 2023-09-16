package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.MT_DsTorihikiyouAnsyono;
import yuyu.def.db.mapping.GenMT_DsTorihikiyouAnsyono;
import yuyu.def.db.meta.GenQMT_DsTorihikiyouAnsyono;
import yuyu.def.db.meta.QMT_DsTorihikiyouAnsyono;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＤＳ特定取引用暗証番号テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsTorihikiyouAnsyono}</td><td colspan="3">ＤＳ特定取引用暗証番号テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tokuteitrhkansyono</td><td>特定取引用暗証番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tktrhkansyonoerrorkaisuu</td><td>特定取引用暗証番号エラー回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>setymd</td><td>設定年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsTorihikiyouAnsyono
 * @see     GenMT_DsTorihikiyouAnsyono
 * @see     QMT_DsTorihikiyouAnsyono
 * @see     GenQMT_DsTorihikiyouAnsyono
 */
public class PKMT_DsTorihikiyouAnsyono extends AbstractExDBPrimaryKey<MT_DsTorihikiyouAnsyono, PKMT_DsTorihikiyouAnsyono> {

    private static final long serialVersionUID = 1L;

    public PKMT_DsTorihikiyouAnsyono() {
    }

    public PKMT_DsTorihikiyouAnsyono(String pDskokno, String pSyono) {
        dskokno = pDskokno;
        syono = pSyono;
    }

    @Transient
    @Override
    public Class<MT_DsTorihikiyouAnsyono> getEntityClass() {
        return MT_DsTorihikiyouAnsyono.class;
    }

    private String dskokno;

    public String getDskokno() {
        return dskokno;
    }

    public void setDskokno(String pDskokno) {
        dskokno = pDskokno;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

}