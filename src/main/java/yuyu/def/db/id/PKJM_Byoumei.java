package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JM_Byoumei;
import yuyu.def.db.mapping.GenJM_Byoumei;
import yuyu.def.db.meta.GenQJM_Byoumei;
import yuyu.def.db.meta.QJM_Byoumei;

/**
 * 病名マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JM_Byoumei}</td><td colspan="3">病名マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getByoumeitourokuno byoumeitourokuno}</td><td>病名登録番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>byoumeikj</td><td>病名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>byoumeizenkaku</td><td>病名全角</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>byoumeikn</td><td>病名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>byoumeiknkensaku</td><td>病名（カナ）検索用</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>byoumeicd</td><td>病名コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gaitoukbn1</td><td>該当区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gaitoukbn2</td><td>該当区分２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ByoumeiGaitouKbn2 C_ByoumeiGaitouKbn2}</td></tr>
 *  <tr><td>gaitoukbn3</td><td>該当区分３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gaitoukbn4</td><td>該当区分４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gaitoukbn5</td><td>該当区分５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tyuuimongon</td><td>注意文言</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JM_Byoumei
 * @see     GenJM_Byoumei
 * @see     QJM_Byoumei
 * @see     GenQJM_Byoumei
 */
public class PKJM_Byoumei extends AbstractExDBPrimaryKey<JM_Byoumei, PKJM_Byoumei> {

    private static final long serialVersionUID = 1L;

    public PKJM_Byoumei() {
    }

    public PKJM_Byoumei(String pByoumeitourokuno) {
        byoumeitourokuno = pByoumeitourokuno;
    }

    @Transient
    @Override
    public Class<JM_Byoumei> getEntityClass() {
        return JM_Byoumei.class;
    }

    private String byoumeitourokuno;

    public String getByoumeitourokuno() {
        return byoumeitourokuno;
    }

    public void setByoumeitourokuno(String pByoumeitourokuno) {
        byoumeitourokuno = pByoumeitourokuno;
    }

}