package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SkCreditTourokukekkaQrRn;
import yuyu.def.db.mapping.GenZT_SkCreditTourokukekkaQrRn;
import yuyu.def.db.meta.GenQZT_SkCreditTourokukekkaQrRn;
import yuyu.def.db.meta.QZT_SkCreditTourokukekkaQrRn;

/**
 * 新契約クレジットカード登録結果（ＱＲ）テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SkCreditTourokukekkaQrRn}</td><td colspan="3">新契約クレジットカード登録結果（ＱＲ）テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrnrecordkbn</td><td>（連携用）レコード区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsystemjyusinymd zrnsystemjyusinymd}</td><td>（連携用）システム受信日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsystemjyusintime zrnsystemjyusintime}</td><td>（連携用）システム受信時刻</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncreditqrtrkkbn</td><td>（連携用）クレジットカードＱＲ登録区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncreditqrsousinkbn</td><td>（連携用）クレジットカードＱＲ送信区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrncreditkessaiyouno zrncreditkessaiyouno}</td><td>（連携用）クレジットカード決済用番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv34</td><td>（連携用）予備項目Ｖ３４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncreditkaiinno</td><td>（連携用）クレジット会員番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncardyuukoukigen</td><td>（連携用）カード有効期限</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnauthorigkjyusin</td><td>（連携用）オーソリ金額（受信）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv153</td><td>（連携用）予備項目Ｖ１５３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntyuumonno</td><td>（連携用）注文番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv50</td><td>（連携用）予備項目Ｖ５０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbluegateshopid</td><td>（連携用）ＢｌｕｅＧａｔｅショップＩＤ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv81</td><td>（連携用）予備項目Ｖ８１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkessaisyoriymd</td><td>（連携用）決済処理日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv24</td><td>（連携用）予備項目Ｖ２４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncreditqrerrorcd</td><td>（連携用）クレジットカードＱＲエラーコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyouninno7keta</td><td>（連携用）承認番号（７桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbluegateerrorcd</td><td>（連携用）ＢｌｕｅＧａｔｅエラーコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhisimukekaisyacd</td><td>（連携用）被仕向会社コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbluegatejyusinymdtime</td><td>（連携用）ＢｌｕｅＧａｔｅ受付日時</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv160</td><td>（連携用）予備項目Ｖ１６０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SkCreditTourokukekkaQrRn
 * @see     GenZT_SkCreditTourokukekkaQrRn
 * @see     QZT_SkCreditTourokukekkaQrRn
 * @see     GenQZT_SkCreditTourokukekkaQrRn
 */
public class PKZT_SkCreditTourokukekkaQrRn extends AbstractExDBPrimaryKey<ZT_SkCreditTourokukekkaQrRn, PKZT_SkCreditTourokukekkaQrRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_SkCreditTourokukekkaQrRn() {
    }

    public PKZT_SkCreditTourokukekkaQrRn(
        String pZrnsystemjyusinymd,
        String pZrnsystemjyusintime,
        String pZrncreditkessaiyouno
    ) {
        zrnsystemjyusinymd = pZrnsystemjyusinymd;
        zrnsystemjyusintime = pZrnsystemjyusintime;
        zrncreditkessaiyouno = pZrncreditkessaiyouno;
    }

    @Transient
    @Override
    public Class<ZT_SkCreditTourokukekkaQrRn> getEntityClass() {
        return ZT_SkCreditTourokukekkaQrRn.class;
    }

    private String zrnsystemjyusinymd;

    public String getZrnsystemjyusinymd() {
        return zrnsystemjyusinymd;
    }

    public void setZrnsystemjyusinymd(String pZrnsystemjyusinymd) {
        zrnsystemjyusinymd = pZrnsystemjyusinymd;
    }
    private String zrnsystemjyusintime;

    public String getZrnsystemjyusintime() {
        return zrnsystemjyusintime;
    }

    public void setZrnsystemjyusintime(String pZrnsystemjyusintime) {
        zrnsystemjyusintime = pZrnsystemjyusintime;
    }
    private String zrncreditkessaiyouno;

    public String getZrncreditkessaiyouno() {
        return zrncreditkessaiyouno;
    }

    public void setZrncreditkessaiyouno(String pZrncreditkessaiyouno) {
        zrncreditkessaiyouno = pZrncreditkessaiyouno;
    }

}