package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_AuthoriKekkaTr;
import yuyu.def.db.mapping.GenZT_AuthoriKekkaTr;
import yuyu.def.db.meta.GenQZT_AuthoriKekkaTr;
import yuyu.def.db.meta.QZT_AuthoriKekkaTr;

/**
 * オーソリ結果Ｆテーブル（取） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_AuthoriKekkaTr}</td><td colspan="3">オーソリ結果Ｆテーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztrrecordkbn</td><td>（取込用）レコード区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkaiintourokukbn</td><td>（取込用）会員登録区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrcreditkessaiyouno ztrcreditkessaiyouno}</td><td>（取込用）クレジットカード決済用番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv34</td><td>（取込用）予備項目Ｖ３４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrcardno</td><td>（取込用）カード番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrcardyuukoukigen</td><td>（取込用）カード有効期限</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrauthorigkjyusin</td><td>（取込用）オーソリ金額（受信）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrauthorikekkaerrorcd</td><td>（取込用）オーソリ結果エラーコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrbluegateerrorcd</td><td>（取込用）ＢｌｕｅＧａｔｅエラーコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv25</td><td>（取込用）予備項目Ｖ２５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrhisimukekaisyacd</td><td>（取込用）被仕向会社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv5</td><td>（取込用）予備項目Ｖ５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrwentryuserid</td><td>（取込用）ＷエントリユーザＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrerrorcomment</td><td>（取込用）エラーコメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrniniinfo</td><td>（取込用）任意情報</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrskjkssityuumonno</td><td>（取込用）即時決済注文番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrskjkssiauthorigk</td><td>（取込用）即時決済オーソリ金額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrskjkssiyosinkekka</td><td>（取込用）即時決済与信結果</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrskjkssibunruikbn</td><td>（取込用）即時決済分類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrdatasyorijyoukyou</td><td>（取込用）データ処理状況</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrdatajyusinymd ztrdatajyusinymd}</td><td>（取込用）データ受信日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv25x2</td><td>（取込用）予備項目Ｖ２５＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrrenno7 ztrrenno7}</td><td>（取込用）連番７桁</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv33</td><td>（取込用）予備項目Ｖ３３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_AuthoriKekkaTr
 * @see     GenZT_AuthoriKekkaTr
 * @see     QZT_AuthoriKekkaTr
 * @see     GenQZT_AuthoriKekkaTr
 */
public class PKZT_AuthoriKekkaTr extends AbstractExDBPrimaryKey<ZT_AuthoriKekkaTr, PKZT_AuthoriKekkaTr> {

    private static final long serialVersionUID = 1L;

    public PKZT_AuthoriKekkaTr() {
    }

    public PKZT_AuthoriKekkaTr(
        String pZtrrenno7,
        String pZtrcreditkessaiyouno,
        String pZtrdatajyusinymd
    ) {
        ztrrenno7 = pZtrrenno7;
        ztrcreditkessaiyouno = pZtrcreditkessaiyouno;
        ztrdatajyusinymd = pZtrdatajyusinymd;
    }

    @Transient
    @Override
    public Class<ZT_AuthoriKekkaTr> getEntityClass() {
        return ZT_AuthoriKekkaTr.class;
    }

    private String ztrrenno7;

    public String getZtrrenno7() {
        return ztrrenno7;
    }

    public void setZtrrenno7(String pZtrrenno7) {
        ztrrenno7 = pZtrrenno7;
    }
    private String ztrcreditkessaiyouno;

    public String getZtrcreditkessaiyouno() {
        return ztrcreditkessaiyouno;
    }

    public void setZtrcreditkessaiyouno(String pZtrcreditkessaiyouno) {
        ztrcreditkessaiyouno = pZtrcreditkessaiyouno;
    }
    private String ztrdatajyusinymd;

    public String getZtrdatajyusinymd() {
        return ztrdatajyusinymd;
    }

    public void setZtrdatajyusinymd(String pZtrdatajyusinymd) {
        ztrdatajyusinymd = pZtrdatajyusinymd;
    }

}