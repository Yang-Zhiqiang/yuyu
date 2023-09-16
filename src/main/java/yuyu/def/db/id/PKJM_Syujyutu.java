package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JM_Syujyutu;
import yuyu.def.db.mapping.GenJM_Syujyutu;
import yuyu.def.db.meta.GenQJM_Syujyutu;
import yuyu.def.db.meta.QJM_Syujyutu;

/**
 * 手術マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JM_Syujyutu}</td><td colspan="3">手術マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyujyututourokuno syujyututourokuno}</td><td>手術登録番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kjcd1</td><td>Ｋ・Ｊコード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kjcd2</td><td>Ｋ・Ｊコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kjcd3</td><td>Ｋ・Ｊコード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syujyutunmkn</td><td>手術名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syujyutunmkj</td><td>手術名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>jyouken</td><td>条件</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syujyutubunruicd</td><td>手術分類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JM_Syujyutu
 * @see     GenJM_Syujyutu
 * @see     QJM_Syujyutu
 * @see     GenQJM_Syujyutu
 */
public class PKJM_Syujyutu extends AbstractExDBPrimaryKey<JM_Syujyutu, PKJM_Syujyutu> {

    private static final long serialVersionUID = 1L;

    public PKJM_Syujyutu() {
    }

    public PKJM_Syujyutu(String pSyujyututourokuno) {
        syujyututourokuno = pSyujyututourokuno;
    }

    @Transient
    @Override
    public Class<JM_Syujyutu> getEntityClass() {
        return JM_Syujyutu.class;
    }

    private String syujyututourokuno;

    public String getSyujyututourokuno() {
        return syujyututourokuno;
    }

    public void setSyujyututourokuno(String pSyujyututourokuno) {
        syujyututourokuno = pSyujyututourokuno;
    }

}