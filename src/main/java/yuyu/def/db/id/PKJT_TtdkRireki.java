package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.def.db.mapping.GenJT_TtdkRireki;
import yuyu.def.db.meta.GenQJT_TtdkRireki;
import yuyu.def.db.meta.QJT_TtdkRireki;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 手続履歴テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_TtdkRireki}</td><td colspan="3">手続履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTtdkrrkskbtkey ttdkrrkskbtkey}</td><td>手続履歴識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syorisosikicd</td><td>処理組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>jimukakuteiumukbn</td><td>事務確定有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_JimukakuteiKbn C_JimukakuteiKbn}</td></tr>
 *  <tr><td>seikyuurirekino</td><td>請求履歴番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>shrsikibetukey</td><td>支払識別キー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sateisyouninskbtkey</td><td>査定承認識別キー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syanaicomment</td><td>社内用コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_TtdkRireki
 * @see     GenJT_TtdkRireki
 * @see     QJT_TtdkRireki
 * @see     GenQJT_TtdkRireki
 */
public class PKJT_TtdkRireki extends AbstractExDBPrimaryKey<JT_TtdkRireki, PKJT_TtdkRireki> {

    private static final long serialVersionUID = 1L;

    public PKJT_TtdkRireki() {
    }

    public PKJT_TtdkRireki(
        String pSkno,
        String pSyono,
        String pTtdkrrkskbtkey
    ) {
        skno = pSkno;
        syono = pSyono;
        ttdkrrkskbtkey = pTtdkrrkskbtkey;
    }

    @Transient
    @Override
    public Class<JT_TtdkRireki> getEntityClass() {
        return JT_TtdkRireki.class;
    }

    private String skno;

    public String getSkno() {
        return skno;
    }

    public void setSkno(String pSkno) {
        skno = pSkno;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private String ttdkrrkskbtkey;

    public String getTtdkrrkskbtkey() {
        return ttdkrrkskbtkey;
    }

    public void setTtdkrrkskbtkey(String pTtdkrrkskbtkey) {
        ttdkrrkskbtkey = pTtdkrrkskbtkey;
    }

}