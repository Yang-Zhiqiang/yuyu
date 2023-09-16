package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SkCreditTourokukekkaQrTr;
import yuyu.def.db.mapping.GenZT_SkCreditTourokukekkaQrTr;
import yuyu.def.db.meta.GenQZT_SkCreditTourokukekkaQrTr;
import yuyu.def.db.meta.QZT_SkCreditTourokukekkaQrTr;

/**
 * 新契約クレジットカード登録結果（ＱＲ）テーブル（取） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SkCreditTourokukekkaQrTr}</td><td colspan="3">新契約クレジットカード登録結果（ＱＲ）テーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztrrecordkbn</td><td>（取込用）レコード区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrsystemjyusinymd ztrsystemjyusinymd}</td><td>（取込用）システム受信日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrsystemjyusintime ztrsystemjyusintime}</td><td>（取込用）システム受信時刻</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrcreditqrtrkkbn</td><td>（取込用）クレジットカードＱＲ登録区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrcreditqrsousinkbn</td><td>（取込用）クレジットカードＱＲ送信区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrcreditkessaiyouno ztrcreditkessaiyouno}</td><td>（取込用）クレジットカード決済用番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv34</td><td>（取込用）予備項目Ｖ３４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrcreditkaiinno</td><td>（取込用）クレジット会員番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrcardyuukoukigen</td><td>（取込用）カード有効期限</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrauthorigkjyusin</td><td>（取込用）オーソリ金額（受信）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv153</td><td>（取込用）予備項目Ｖ１５３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrtyuumonno</td><td>（取込用）注文番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv50</td><td>（取込用）予備項目Ｖ５０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrbluegateshopid</td><td>（取込用）ＢｌｕｅＧａｔｅショップＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv81</td><td>（取込用）予備項目Ｖ８１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrkessaisyoriymd</td><td>（取込用）決済処理日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv24</td><td>（取込用）予備項目Ｖ２４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrcreditqrerrorcd</td><td>（取込用）クレジットカードＱＲエラーコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrsyouninno7keta</td><td>（取込用）承認番号（７桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrbluegateerrorcd</td><td>（取込用）ＢｌｕｅＧａｔｅエラーコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrhisimukekaisyacd</td><td>（取込用）被仕向会社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrbluegatejyusinymdtime</td><td>（取込用）ＢｌｕｅＧａｔｅ受付日時</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv160</td><td>（取込用）予備項目Ｖ１６０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SkCreditTourokukekkaQrTr
 * @see     GenZT_SkCreditTourokukekkaQrTr
 * @see     QZT_SkCreditTourokukekkaQrTr
 * @see     GenQZT_SkCreditTourokukekkaQrTr
 */
public class PKZT_SkCreditTourokukekkaQrTr extends AbstractExDBPrimaryKey<ZT_SkCreditTourokukekkaQrTr, PKZT_SkCreditTourokukekkaQrTr> {

    private static final long serialVersionUID = 1L;

    public PKZT_SkCreditTourokukekkaQrTr() {
    }

    public PKZT_SkCreditTourokukekkaQrTr(
        String pZtrsystemjyusinymd,
        String pZtrsystemjyusintime,
        String pZtrcreditkessaiyouno
    ) {
        ztrsystemjyusinymd = pZtrsystemjyusinymd;
        ztrsystemjyusintime = pZtrsystemjyusintime;
        ztrcreditkessaiyouno = pZtrcreditkessaiyouno;
    }

    @Transient
    @Override
    public Class<ZT_SkCreditTourokukekkaQrTr> getEntityClass() {
        return ZT_SkCreditTourokukekkaQrTr.class;
    }

    private String ztrsystemjyusinymd;

    public String getZtrsystemjyusinymd() {
        return ztrsystemjyusinymd;
    }

    public void setZtrsystemjyusinymd(String pZtrsystemjyusinymd) {
        ztrsystemjyusinymd = pZtrsystemjyusinymd;
    }
    private String ztrsystemjyusintime;

    public String getZtrsystemjyusintime() {
        return ztrsystemjyusintime;
    }

    public void setZtrsystemjyusintime(String pZtrsystemjyusintime) {
        ztrsystemjyusintime = pZtrsystemjyusintime;
    }
    private String ztrcreditkessaiyouno;

    public String getZtrcreditkessaiyouno() {
        return ztrcreditkessaiyouno;
    }

    public void setZtrcreditkessaiyouno(String pZtrcreditkessaiyouno) {
        ztrcreditkessaiyouno = pZtrcreditkessaiyouno;
    }

}