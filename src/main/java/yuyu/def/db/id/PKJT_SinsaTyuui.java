package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_SinsaTyuui;
import yuyu.def.db.mapping.GenJT_SinsaTyuui;
import yuyu.def.db.meta.GenQJT_SinsaTyuui;
import yuyu.def.db.meta.QJT_SinsaTyuui;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 審査注意テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SinsaTyuui}</td><td colspan="3">審査注意テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sinsatyuui</td><td>審査注意</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sosikinm</td><td>組織名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SinsaTyuui
 * @see     GenJT_SinsaTyuui
 * @see     QJT_SinsaTyuui
 * @see     GenQJT_SinsaTyuui
 */
public class PKJT_SinsaTyuui extends AbstractExDBPrimaryKey<JT_SinsaTyuui, PKJT_SinsaTyuui> {

    private static final long serialVersionUID = 1L;

    public PKJT_SinsaTyuui() {
    }

    public PKJT_SinsaTyuui(String pSyono) {
        syono = pSyono;
    }

    @Transient
    @Override
    public Class<JT_SinsaTyuui> getEntityClass() {
        return JT_SinsaTyuui.class;
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

}