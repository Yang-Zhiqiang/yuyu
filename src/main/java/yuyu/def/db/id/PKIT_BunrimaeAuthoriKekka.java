package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_BunrimaeAuthoriKekka;
import yuyu.def.db.mapping.GenIT_BunrimaeAuthoriKekka;
import yuyu.def.db.meta.GenQIT_BunrimaeAuthoriKekka;
import yuyu.def.db.meta.QIT_BunrimaeAuthoriKekka;

/**
 * 分離前オーソリ結果テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BunrimaeAuthoriKekka}</td><td colspan="3">分離前オーソリ結果テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getCreditkessaiyouno creditkessaiyouno}</td><td>クレジットカード決済用番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDatajyusinymd datajyusinymd}</td><td>データ受信日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kaiintourokukbn</td><td>会員登録区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno</td><td>クレジットカード番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>cardyuukoukigen4keta</td><td>クレジットカード有効期限（４桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>authorigk7keta</td><td>オーソリ金額（７桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>authorikekkaerrorcd</td><td>オーソリ結果エラーコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bluegateerrorcd</td><td>ＢｌｕｅＧａｔｅエラーコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hisimukekaisyacd</td><td>被仕向会社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>wentryuserid</td><td>ＷエントリユーザＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>errorcomment</td><td>エラーコメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>niniinfo</td><td>任意情報</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>datasyorijyoukyou</td><td>データ処理状況</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BunrimaeAuthoriKekka
 * @see     GenIT_BunrimaeAuthoriKekka
 * @see     QIT_BunrimaeAuthoriKekka
 * @see     GenQIT_BunrimaeAuthoriKekka
 */
public class PKIT_BunrimaeAuthoriKekka extends AbstractExDBPrimaryKey<IT_BunrimaeAuthoriKekka, PKIT_BunrimaeAuthoriKekka> {

    private static final long serialVersionUID = 1L;

    public PKIT_BunrimaeAuthoriKekka() {
    }

    public PKIT_BunrimaeAuthoriKekka(String pCreditkessaiyouno, String pDatajyusinymd) {
        creditkessaiyouno = pCreditkessaiyouno;
        datajyusinymd = pDatajyusinymd;
    }

    @Transient
    @Override
    public Class<IT_BunrimaeAuthoriKekka> getEntityClass() {
        return IT_BunrimaeAuthoriKekka.class;
    }

    private String creditkessaiyouno;

    public String getCreditkessaiyouno() {
        return creditkessaiyouno;
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        creditkessaiyouno = pCreditkessaiyouno;
    }
    private String datajyusinymd;

    public String getDatajyusinymd() {
        return datajyusinymd;
    }

    public void setDatajyusinymd(String pDatajyusinymd) {
        datajyusinymd = pDatajyusinymd;
    }

}