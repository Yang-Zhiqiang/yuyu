package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_AuthoriKekkaRn;
import yuyu.def.db.mapping.GenZT_AuthoriKekkaRn;
import yuyu.def.db.meta.GenQZT_AuthoriKekkaRn;
import yuyu.def.db.meta.QZT_AuthoriKekkaRn;

/**
 * オーソリ結果Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_AuthoriKekkaRn}</td><td colspan="3">オーソリ結果Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrnrecordkbn</td><td>（連携用）レコード区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiintourokukbn</td><td>（連携用）会員登録区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrncreditkessaiyouno zrncreditkessaiyouno}</td><td>（連携用）クレジットカード決済用番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv34</td><td>（連携用）予備項目Ｖ３４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncardno</td><td>（連携用）カード番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncardyuukoukigen</td><td>（連携用）カード有効期限</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnauthorigkjyusin</td><td>（連携用）オーソリ金額（受信）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnauthorikekkaerrorcd</td><td>（連携用）オーソリ結果エラーコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbluegateerrorcd</td><td>（連携用）ＢｌｕｅＧａｔｅエラーコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv25</td><td>（連携用）予備項目Ｖ２５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhisimukekaisyacd</td><td>（連携用）被仕向会社コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv5</td><td>（連携用）予備項目Ｖ５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwentryuserid</td><td>（連携用）ＷエントリユーザＩＤ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnerrorcomment</td><td>（連携用）エラーコメント</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnniniinfo</td><td>（連携用）任意情報</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskjkssityuumonno</td><td>（連携用）即時決済注文番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskjkssiauthorigk</td><td>（連携用）即時決済オーソリ金額</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskjkssiyosinkekka</td><td>（連携用）即時決済与信結果</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskjkssibunruikbn</td><td>（連携用）即時決済分類区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndatasyorijyoukyou</td><td>（連携用）データ処理状況</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrndatajyusinymd zrndatajyusinymd}</td><td>（連携用）データ受信日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv25x2</td><td>（連携用）予備項目Ｖ２５＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnrenno7 zrnrenno7}</td><td>（連携用）連番７桁</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv33</td><td>（連携用）予備項目Ｖ３３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_AuthoriKekkaRn
 * @see     GenZT_AuthoriKekkaRn
 * @see     QZT_AuthoriKekkaRn
 * @see     GenQZT_AuthoriKekkaRn
 */
public class PKZT_AuthoriKekkaRn extends AbstractExDBPrimaryKey<ZT_AuthoriKekkaRn, PKZT_AuthoriKekkaRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_AuthoriKekkaRn() {
    }

    public PKZT_AuthoriKekkaRn(
        String pZrnrenno7,
        String pZrncreditkessaiyouno,
        String pZrndatajyusinymd
    ) {
        zrnrenno7 = pZrnrenno7;
        zrncreditkessaiyouno = pZrncreditkessaiyouno;
        zrndatajyusinymd = pZrndatajyusinymd;
    }

    @Transient
    @Override
    public Class<ZT_AuthoriKekkaRn> getEntityClass() {
        return ZT_AuthoriKekkaRn.class;
    }

    private String zrnrenno7;

    public String getZrnrenno7() {
        return zrnrenno7;
    }

    public void setZrnrenno7(String pZrnrenno7) {
        zrnrenno7 = pZrnrenno7;
    }
    private String zrncreditkessaiyouno;

    public String getZrncreditkessaiyouno() {
        return zrncreditkessaiyouno;
    }

    public void setZrncreditkessaiyouno(String pZrncreditkessaiyouno) {
        zrncreditkessaiyouno = pZrncreditkessaiyouno;
    }
    private String zrndatajyusinymd;

    public String getZrndatajyusinymd() {
        return zrndatajyusinymd;
    }

    public void setZrndatajyusinymd(String pZrndatajyusinymd) {
        zrndatajyusinymd = pZrndatajyusinymd;
    }

}