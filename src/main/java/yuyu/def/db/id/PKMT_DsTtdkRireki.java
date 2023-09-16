package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.MT_DsTtdkRireki;
import yuyu.def.db.mapping.GenMT_DsTtdkRireki;
import yuyu.def.db.meta.GenQMT_DsTtdkRireki;
import yuyu.def.db.meta.QMT_DsTtdkRireki;

/**
 * ＤＳ手続履歴テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsTtdkRireki}</td><td colspan="3">ＤＳ手続履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dssyorikbn</td><td>ＤＳ処理区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DsSyoriKbn C_DsSyoriKbn}</td></tr>
 *  <tr><td>henkourrkumu</td><td>変更履歴有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsTtdkRireki
 * @see     GenMT_DsTtdkRireki
 * @see     QMT_DsTtdkRireki
 * @see     GenQMT_DsTtdkRireki
 */
public class PKMT_DsTtdkRireki extends AbstractExDBPrimaryKey<MT_DsTtdkRireki, PKMT_DsTtdkRireki> {

    private static final long serialVersionUID = 1L;

    public PKMT_DsTtdkRireki() {
    }

    public PKMT_DsTtdkRireki(String pDskokno, String pHenkousikibetukey) {
        dskokno = pDskokno;
        henkousikibetukey = pHenkousikibetukey;
    }

    @Transient
    @Override
    public Class<MT_DsTtdkRireki> getEntityClass() {
        return MT_DsTtdkRireki.class;
    }

    private String dskokno;

    public String getDskokno() {
        return dskokno;
    }

    public void setDskokno(String pDskokno) {
        dskokno = pDskokno;
    }
    private String henkousikibetukey;

    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

}