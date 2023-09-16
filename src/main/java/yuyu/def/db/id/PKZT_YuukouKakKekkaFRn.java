package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_YuukouKakKekkaFRn;
import yuyu.def.db.mapping.GenZT_YuukouKakKekkaFRn;
import yuyu.def.db.meta.GenQZT_YuukouKakKekkaFRn;
import yuyu.def.db.meta.QZT_YuukouKakKekkaFRn;

/**
 * 有効性確認結果Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_YuukouKakKekkaFRn}</td><td colspan="3">有効性確認結果Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrnrecordkbn</td><td>（連携用）レコード区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv1</td><td>（連携用）予備項目Ｖ１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrncreditkessaiyouno zrncreditkessaiyouno}</td><td>（連携用）クレジットカード決済用番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndbkeykugirimoji1</td><td>（連携用）ＤＢキー区切り文字１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndbkeykugirimoji2</td><td>（連携用）ＤＢキー区切り文字２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv32</td><td>（連携用）予備項目Ｖ３２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncardno</td><td>（連携用）カード番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncardyuukoukigen</td><td>（連携用）カード有効期限</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyuukouhanteikekka</td><td>（連携用）有効性判定結果</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv59</td><td>（連携用）予備項目Ｖ５９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncreditkigyoucd</td><td>（連携用）クレジット企業コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv53</td><td>（連携用）予備項目Ｖ５３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_YuukouKakKekkaFRn
 * @see     GenZT_YuukouKakKekkaFRn
 * @see     QZT_YuukouKakKekkaFRn
 * @see     GenQZT_YuukouKakKekkaFRn
 */
public class PKZT_YuukouKakKekkaFRn extends AbstractExDBPrimaryKey<ZT_YuukouKakKekkaFRn, PKZT_YuukouKakKekkaFRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_YuukouKakKekkaFRn() {
    }

    public PKZT_YuukouKakKekkaFRn(String pZrncreditkessaiyouno) {
        zrncreditkessaiyouno = pZrncreditkessaiyouno;
    }

    @Transient
    @Override
    public Class<ZT_YuukouKakKekkaFRn> getEntityClass() {
        return ZT_YuukouKakKekkaFRn.class;
    }

    private String zrncreditkessaiyouno;

    public String getZrncreditkessaiyouno() {
        return zrncreditkessaiyouno;
    }

    public void setZrncreditkessaiyouno(String pZrncreditkessaiyouno) {
        zrncreditkessaiyouno = pZrncreditkessaiyouno;
    }

}