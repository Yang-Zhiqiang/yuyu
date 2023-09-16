package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_YuukouKakKekkaFTr;
import yuyu.def.db.mapping.GenZT_YuukouKakKekkaFTr;
import yuyu.def.db.meta.GenQZT_YuukouKakKekkaFTr;
import yuyu.def.db.meta.QZT_YuukouKakKekkaFTr;

/**
 * 有効性確認結果Ｆテーブル（取） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_YuukouKakKekkaFTr}</td><td colspan="3">有効性確認結果Ｆテーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztrrecordkbn</td><td>（取込用）レコード区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv1</td><td>（取込用）予備項目Ｖ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrcreditkessaiyouno ztrcreditkessaiyouno}</td><td>（取込用）クレジットカード決済用番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrdbkeykugirimoji1</td><td>（取込用）ＤＢキー区切り文字１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrdbkeykugirimoji2</td><td>（取込用）ＤＢキー区切り文字２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv32</td><td>（取込用）予備項目Ｖ３２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrcardno</td><td>（取込用）カード番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrcardyuukoukigen</td><td>（取込用）カード有効期限</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryuukouhanteikekka</td><td>（取込用）有効性判定結果</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv59</td><td>（取込用）予備項目Ｖ５９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrcreditkigyoucd</td><td>（取込用）クレジット企業コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv53</td><td>（取込用）予備項目Ｖ５３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_YuukouKakKekkaFTr
 * @see     GenZT_YuukouKakKekkaFTr
 * @see     QZT_YuukouKakKekkaFTr
 * @see     GenQZT_YuukouKakKekkaFTr
 */
public class PKZT_YuukouKakKekkaFTr extends AbstractExDBPrimaryKey<ZT_YuukouKakKekkaFTr, PKZT_YuukouKakKekkaFTr> {

    private static final long serialVersionUID = 1L;

    public PKZT_YuukouKakKekkaFTr() {
    }

    public PKZT_YuukouKakKekkaFTr(String pZtrcreditkessaiyouno) {
        ztrcreditkessaiyouno = pZtrcreditkessaiyouno;
    }

    @Transient
    @Override
    public Class<ZT_YuukouKakKekkaFTr> getEntityClass() {
        return ZT_YuukouKakKekkaFTr.class;
    }

    private String ztrcreditkessaiyouno;

    public String getZtrcreditkessaiyouno() {
        return ztrcreditkessaiyouno;
    }

    public void setZtrcreditkessaiyouno(String pZtrcreditkessaiyouno) {
        ztrcreditkessaiyouno = pZtrcreditkessaiyouno;
    }

}