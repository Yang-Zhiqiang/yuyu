package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.MT_DsLoginKanri;
import yuyu.def.db.mapping.GenMT_DsLoginKanri;
import yuyu.def.db.meta.GenQMT_DsLoginKanri;
import yuyu.def.db.meta.QMT_DsLoginKanri;

/**
 * ＤＳログイン管理テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsLoginKanri}</td><td colspan="3">ＤＳログイン管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syokailoginymd</td><td>初回ログイン年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syokailogintime</td><td>初回ログイン時刻</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syokailoginbaitaikbn</td><td>初回ログイン媒体区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BaitaiKbn C_BaitaiKbn}</td></tr>
 *  <tr><td>saisinloginymd</td><td>最新ログイン年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>saisinlogintime</td><td>最新ログイン時刻</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>saisinloginbaitaikbn</td><td>最新ログイン媒体区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_BaitaiKbn C_BaitaiKbn}</td></tr>
 *  <tr><td>dshnnkakcderrorkaisuu</td><td>ＤＳ本人確認コードエラー回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dskokyakunmerrorkaisuu</td><td>ＤＳ顧客名エラー回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dskokyakuseiymderrorkaisuu</td><td>ＤＳ顧客生年月日エラー回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dskokyakutelnoerrorkaisuu</td><td>ＤＳ顧客電話番号エラー回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsLoginKanri
 * @see     GenMT_DsLoginKanri
 * @see     QMT_DsLoginKanri
 * @see     GenQMT_DsLoginKanri
 */
public class PKMT_DsLoginKanri extends AbstractExDBPrimaryKey<MT_DsLoginKanri, PKMT_DsLoginKanri> {

    private static final long serialVersionUID = 1L;

    public PKMT_DsLoginKanri() {
    }

    public PKMT_DsLoginKanri(String pDskokno) {
        dskokno = pDskokno;
    }

    @Transient
    @Override
    public Class<MT_DsLoginKanri> getEntityClass() {
        return MT_DsLoginKanri.class;
    }

    private String dskokno;

    public String getDskokno() {
        return dskokno;
    }

    public void setDskokno(String pDskokno) {
        dskokno = pDskokno;
    }

}