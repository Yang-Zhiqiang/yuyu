package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_HrhnCreditCardTouroku;
import yuyu.def.db.mapping.GenIT_HrhnCreditCardTouroku;
import yuyu.def.db.meta.GenQIT_HrhnCreditCardTouroku;
import yuyu.def.db.meta.QIT_HrhnCreditCardTouroku;

/**
 * 払変クレカ登録テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_HrhnCreditCardTouroku}</td><td colspan="3">払変クレカ登録テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>authorijkkbn</td><td>オーソリ状況区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AuthorijkKbn C_AuthorijkKbn}</td></tr>
 *  <tr><td>cardbrandkbn</td><td>カードブランド区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_CardBrandKbn C_CardBrandKbn}</td></tr>
 *  <tr><td>creditkaiinnosimo4keta</td><td>クレジット会員番号（下４桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_HrhnCreditCardTouroku
 * @see     GenIT_HrhnCreditCardTouroku
 * @see     QIT_HrhnCreditCardTouroku
 * @see     GenQIT_HrhnCreditCardTouroku
 */
public class PKIT_HrhnCreditCardTouroku extends AbstractExDBPrimaryKey<IT_HrhnCreditCardTouroku, PKIT_HrhnCreditCardTouroku> {

    private static final long serialVersionUID = 1L;

    public PKIT_HrhnCreditCardTouroku() {
    }

    public PKIT_HrhnCreditCardTouroku(String pCreditkessaiyouno) {
        creditkessaiyouno = pCreditkessaiyouno;
    }

    @Transient
    @Override
    public Class<IT_HrhnCreditCardTouroku> getEntityClass() {
        return IT_HrhnCreditCardTouroku.class;
    }

    private String creditkessaiyouno;

    public String getCreditkessaiyouno() {
        return creditkessaiyouno;
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        creditkessaiyouno = pCreditkessaiyouno;
    }

}