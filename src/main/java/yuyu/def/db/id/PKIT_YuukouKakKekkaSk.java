package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_YuukouKakKekkaSk;
import yuyu.def.db.mapping.GenIT_YuukouKakKekkaSk;
import yuyu.def.db.meta.GenQIT_YuukouKakKekkaSk;
import yuyu.def.db.meta.QIT_YuukouKakKekkaSk;

/**
 * 有効性確認結果（新契約）テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_YuukouKakKekkaSk}</td><td colspan="3">有効性確認結果（新契約）テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno</td><td>クレジットカード番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>cardyuukoukigen4keta</td><td>クレジットカード有効期限（４桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>credityuukoukakym</td><td>クレジットカード有効確認年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>credityuukoukakkekka</td><td>クレジットカード有効確認結果</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Yuukoukakkekka C_Yuukoukakkekka}</td></tr>
 *  <tr><td>creditkigyoucd</td><td>クレジットカード企業コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_YuukouKakKekkaSk
 * @see     GenIT_YuukouKakKekkaSk
 * @see     QIT_YuukouKakKekkaSk
 * @see     GenQIT_YuukouKakKekkaSk
 */
public class PKIT_YuukouKakKekkaSk extends AbstractExDBPrimaryKey<IT_YuukouKakKekkaSk, PKIT_YuukouKakKekkaSk> {

    private static final long serialVersionUID = 1L;

    public PKIT_YuukouKakKekkaSk() {
    }

    public PKIT_YuukouKakKekkaSk(String pCreditkessaiyouno) {
        creditkessaiyouno = pCreditkessaiyouno;
    }

    @Transient
    @Override
    public Class<IT_YuukouKakKekkaSk> getEntityClass() {
        return IT_YuukouKakKekkaSk.class;
    }

    private String creditkessaiyouno;

    public String getCreditkessaiyouno() {
        return creditkessaiyouno;
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        creditkessaiyouno = pCreditkessaiyouno;
    }

}