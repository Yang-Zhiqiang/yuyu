package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_AiKyuubuByoumeiRn;
import yuyu.def.db.mapping.GenZT_AiKyuubuByoumeiRn;
import yuyu.def.db.meta.GenQZT_AiKyuubuByoumeiRn;
import yuyu.def.db.meta.QZT_AiKyuubuByoumeiRn;

/**
 * あいキューブ病名マスタ送信データテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_AiKyuubuByoumeiRn}</td><td colspan="3">あいキューブ病名マスタ送信データテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnbyoumeitourokuno zrnbyoumeitourokuno}</td><td>（連携用）病名登録番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbyoumei</td><td>（連携用）病名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnbyoumeizenkaku</td><td>（連携用）病名全角</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnbyoumeihurigana</td><td>（連携用）病名フリガナ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbyoumeihuriganakensaku</td><td>（連携用）病名フリガナ検索用</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbyoumeicd</td><td>（連携用）病名コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbyoumeibuicd</td><td>（連携用）病名部位コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngaitoukbn1</td><td>（連携用）該当区分１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngaitoukbn2</td><td>（連携用）該当区分２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngaitoukbn3</td><td>（連携用）該当区分３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngaitoukbn4</td><td>（連携用）該当区分４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngaitoukbn5</td><td>（連携用）該当区分５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntyuuimongon</td><td>（連携用）注意文言</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 * </table>
 * @see     ZT_AiKyuubuByoumeiRn
 * @see     GenZT_AiKyuubuByoumeiRn
 * @see     QZT_AiKyuubuByoumeiRn
 * @see     GenQZT_AiKyuubuByoumeiRn
 */
public class PKZT_AiKyuubuByoumeiRn extends AbstractExDBPrimaryKey<ZT_AiKyuubuByoumeiRn, PKZT_AiKyuubuByoumeiRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_AiKyuubuByoumeiRn() {
    }

    public PKZT_AiKyuubuByoumeiRn(String pZrnbyoumeitourokuno) {
        zrnbyoumeitourokuno = pZrnbyoumeitourokuno;
    }

    @Transient
    @Override
    public Class<ZT_AiKyuubuByoumeiRn> getEntityClass() {
        return ZT_AiKyuubuByoumeiRn.class;
    }

    private String zrnbyoumeitourokuno;

    public String getZrnbyoumeitourokuno() {
        return zrnbyoumeitourokuno;
    }

    public void setZrnbyoumeitourokuno(String pZrnbyoumeitourokuno) {
        zrnbyoumeitourokuno = pZrnbyoumeitourokuno;
    }

}