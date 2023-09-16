package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_SibouKariuketsuke;
import yuyu.def.db.mapping.GenJT_SibouKariuketsuke;
import yuyu.def.db.meta.GenQJT_SibouKariuketsuke;
import yuyu.def.db.meta.QJT_SibouKariuketsuke;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 死亡仮受付テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SibouKariuketsuke}</td><td colspan="3">死亡仮受付テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sibouymd</td><td>死亡日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>geninkbn</td><td>原因区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_GeninKbn C_GeninKbn}</td></tr>
 *  <tr><td>torikesiflg</td><td>取消フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SibouKariuketsuke
 * @see     GenJT_SibouKariuketsuke
 * @see     QJT_SibouKariuketsuke
 * @see     GenQJT_SibouKariuketsuke
 */
public class PKJT_SibouKariuketsuke extends AbstractExDBPrimaryKey<JT_SibouKariuketsuke, PKJT_SibouKariuketsuke> {

    private static final long serialVersionUID = 1L;

    public PKJT_SibouKariuketsuke() {
    }

    public PKJT_SibouKariuketsuke(String pSkno, String pSyono) {
        skno = pSkno;
        syono = pSyono;
    }

    @Transient
    @Override
    public Class<JT_SibouKariuketsuke> getEntityClass() {
        return JT_SibouKariuketsuke.class;
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

}