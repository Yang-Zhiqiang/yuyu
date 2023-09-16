package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KoujyoSyoumeiRn;
import yuyu.def.db.mapping.GenZT_KoujyoSyoumeiRn;
import yuyu.def.db.meta.GenQZT_KoujyoSyoumeiRn;
import yuyu.def.db.meta.QZT_KoujyoSyoumeiRn;

/**
 * 控除証明書Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KoujyoSyoumeiRn}</td><td colspan="3">控除証明書Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrnsyoruicd</td><td>（連携用）書類コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhassoukbn</td><td>（連携用）発送区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyodouhuukbn</td><td>（連携用）証券同封区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsikibetuno</td><td>（連携用）識別番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkoujyosyoumeisentakukbn</td><td>（連携用）控除証明選択区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv43</td><td>（連携用）予備項目Ｖ４３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshskyno</td><td>（連携用）送付先郵便番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshskadr1kj</td><td>（連携用）送付先住所１（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshskadr2kj</td><td>（連携用）送付先住所２（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshskadr3kj</td><td>（連携用）送付先住所３（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshsnmkj</td><td>（連携用）送付先名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv1</td><td>（連携用）予備項目Ｖ１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyknmkn</td><td>（連携用）契約者名（カナ）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnuktnmkn</td><td>（連携用）受取人名（カナ）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntawsosikikj</td><td>（連携用）問合せ先組織名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntawyno</td><td>（連携用）問合せ先郵便番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntawadr1kj</td><td>（連携用）問合せ先住所１（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntawadr2kj</td><td>（連携用）問合せ先住所２（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntawadr3kj</td><td>（連携用）問合せ先住所３（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntawtelnov14</td><td>（連携用）問合せ先電話番号Ｖ１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntawteluktkkanou1</td><td>（連携用）問合せ先電話受付可能時間１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntawteluktkkanou2</td><td>（連携用）問合せ先電話受付可能時間２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndai2tawsosikinmkj</td><td>（連携用）第２問合せ先組織名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndai2tawtelno</td><td>（連携用）第２問合せ先電話番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsclatosyono</td><td>（連携用）スクランブル後証券番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsakunm15keta zrnsakunm15keta}</td><td>（連携用）作成番号（１５桁）</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv48</td><td>（連携用）予備項目Ｖ４８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyknmkj</td><td>（連携用）契約者名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsyoumeinndseireki</td><td>（連携用）証明年度（西暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnuktnmknmeikj</td><td>（連携用）受取人名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnnenkinuktseiymdseireki</td><td>（連携用）年金受取人生年月日（西暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsyono3</td><td>（連携用）証券番号３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyurui</td><td>（連携用）保険種類</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnnknshrynnm</td><td>（連携用）年金支払期間（数）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykymdseireki</td><td>（連携用）契約年月日（西暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhtkinuthoukbn</td><td>（連携用）配当金受取方法区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknkknnm</td><td>（連携用）保険期間（数）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkshrstartymdseireki</td><td>（連携用）年金支払開始日（西暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnphrkkkn</td><td>（連携用）保険料払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkaisuunm</td><td>（連携用）払込回数（数）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjnnkkoujyum</td><td>（連携用）個人年金控除有無</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnuktmidasi</td><td>（連携用）受取人見出し</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnmidasisub</td><td>（連携用）見出し副題</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkoujyosyoumeifreearea</td><td>（連携用）控除証明書フリーエリア</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkoujyosyoumeimsgkbn</td><td>（連携用）控除証明メッセージ区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv12</td><td>（連携用）予備項目Ｖ１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnippanseimeip</td><td>（連携用）一般生命保険料（新制度）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnippanhaitoukin</td><td>（連携用）一般配当金（新制度）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnippansyoumeigk</td><td>（連携用）一般証明額（新制度）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaigoiryoup</td><td>（連携用）介護医療保険料（新制度）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaigoiryoud</td><td>（連携用）介護医療配当金（新制度）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaigoiryousmgk</td><td>（連携用）介護医療証明額（新制度）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinp</td><td>（連携用）年金保険料（新制度）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkind</td><td>（連携用）年金配当金（新制度）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinsmgk</td><td>（連携用）年金証明額（新制度）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnewhknjytukikan</td><td>（連携用）新制度保険充当期間</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnphrkkknjyoutai</td><td>（連携用）保険料払込状態</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsyoumeiymdseireki</td><td>（連携用）証明日（西暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnnenippanseimeip</td><td>（連携用）年間一般生命保険料（新制度）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenippand</td><td>（連携用）年間一般配当金（新制度）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenippansymgk</td><td>（連携用）年間一般証明額（新制度）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkaigoiryoup</td><td>（連携用）年間介護医療保険料（新制度）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkaigoiryoud</td><td>（連携用）年間介護医療配当金（新制度）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnneniryousymgk</td><td>（連携用）年間介護医療証明額（新制度）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnennenkinp</td><td>（連携用）年間年金保険料（新制度）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnennenkind</td><td>（連携用）年間年金配当金（新制度）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnennenkinsmgk</td><td>（連携用）年間年金証明額（新制度）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv24</td><td>（連携用）予備項目Ｖ２４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KoujyoSyoumeiRn
 * @see     GenZT_KoujyoSyoumeiRn
 * @see     QZT_KoujyoSyoumeiRn
 * @see     GenQZT_KoujyoSyoumeiRn
 */
public class PKZT_KoujyoSyoumeiRn extends AbstractExDBPrimaryKey<ZT_KoujyoSyoumeiRn, PKZT_KoujyoSyoumeiRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_KoujyoSyoumeiRn() {
    }

    public PKZT_KoujyoSyoumeiRn(
        String pZrntyouhyouymd,
        String pZrnsyono,
        String pZrnsakunm15keta
    ) {
        zrntyouhyouymd = pZrntyouhyouymd;
        zrnsyono = pZrnsyono;
        zrnsakunm15keta = pZrnsakunm15keta;
    }

    @Transient
    @Override
    public Class<ZT_KoujyoSyoumeiRn> getEntityClass() {
        return ZT_KoujyoSyoumeiRn.class;
    }

    private String zrntyouhyouymd;

    public String getZrntyouhyouymd() {
        return zrntyouhyouymd;
    }

    public void setZrntyouhyouymd(String pZrntyouhyouymd) {
        zrntyouhyouymd = pZrntyouhyouymd;
    }
    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }
    private String zrnsakunm15keta;

    public String getZrnsakunm15keta() {
        return zrnsakunm15keta;
    }

    public void setZrnsakunm15keta(String pZrnsakunm15keta) {
        zrnsakunm15keta = pZrnsakunm15keta;
    }

}