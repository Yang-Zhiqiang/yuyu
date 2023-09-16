package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KoujyoSyoumeiTy;
import yuyu.def.db.mapping.GenZT_KoujyoSyoumeiTy;
import yuyu.def.db.meta.GenQZT_KoujyoSyoumeiTy;
import yuyu.def.db.meta.QZT_KoujyoSyoumeiTy;

/**
 * 控除証明書Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KoujyoSyoumeiTy}</td><td colspan="3">控除証明書Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztysyoruicd</td><td>（中継用）書類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhassoukbn</td><td>（中継用）発送区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyodouhuukbn</td><td>（中継用）証券同封区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysikibetuno</td><td>（中継用）識別番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykoujyosyoumeisentakukbn</td><td>（中継用）控除証明選択区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv43</td><td>（中継用）予備項目Ｖ４３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshskyno</td><td>（中継用）送付先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshskadr1kj</td><td>（中継用）送付先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshskadr2kj</td><td>（中継用）送付先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshskadr3kj</td><td>（中継用）送付先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshsnmkj</td><td>（中継用）送付先名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv1</td><td>（中継用）予備項目Ｖ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknmkn</td><td>（中継用）契約者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyuktnmkn</td><td>（中継用）受取人名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawsosikikj</td><td>（中継用）問合せ先組織名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawyno</td><td>（中継用）問合せ先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawadr1kj</td><td>（中継用）問合せ先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawadr2kj</td><td>（中継用）問合せ先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawadr3kj</td><td>（中継用）問合せ先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawtelnov14</td><td>（中継用）問合せ先電話番号Ｖ１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawteluktkkanou1</td><td>（中継用）問合せ先電話受付可能時間１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawteluktkkanou2</td><td>（中継用）問合せ先電話受付可能時間２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2tawsosikinmkj</td><td>（中継用）第２問合せ先組織名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2tawtelno</td><td>（中継用）第２問合せ先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysclatosyono</td><td>（中継用）スクランブル後証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysakunm15keta ztysakunm15keta}</td><td>（中継用）作成番号（１５桁）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv48</td><td>（中継用）予備項目Ｖ４８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknmkj</td><td>（中継用）契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoumeinndseireki</td><td>（中継用）証明年度（西暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyuktnmknmeikj</td><td>（中継用）受取人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinuktseiymdseireki</td><td>（中継用）年金受取人生年月日（西暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyono3</td><td>（中継用）証券番号３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyurui</td><td>（中継用）保険種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynknshrynnm</td><td>（中継用）年金支払期間（数）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymdseireki</td><td>（中継用）契約年月日（西暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhtkinuthoukbn</td><td>（中継用）配当金受取方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknkknnm</td><td>（中継用）保険期間（数）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkshrstartymdseireki</td><td>（中継用）年金支払開始日（西暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyphrkkkn</td><td>（中継用）保険料払込期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkaisuunm</td><td>（中継用）払込回数（数）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjnnkkoujyum</td><td>（中継用）個人年金控除有無</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyuktmidasi</td><td>（中継用）受取人見出し</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymidasisub</td><td>（中継用）見出し副題</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykoujyosyoumeifreearea</td><td>（中継用）控除証明書フリーエリア</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykoujyosyoumeimsgkbn</td><td>（中継用）控除証明メッセージ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv12</td><td>（中継用）予備項目Ｖ１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyippanseimeip</td><td>（中継用）一般生命保険料（新制度）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyippanhaitoukin</td><td>（中継用）一般配当金（新制度）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyippansyoumeigk</td><td>（中継用）一般証明額（新制度）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaigoiryoup</td><td>（中継用）介護医療保険料（新制度）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaigoiryoud</td><td>（中継用）介護医療配当金（新制度）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaigoiryousmgk</td><td>（中継用）介護医療証明額（新制度）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinp</td><td>（中継用）年金保険料（新制度）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkind</td><td>（中継用）年金配当金（新制度）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinsmgk</td><td>（中継用）年金証明額（新制度）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynewhknjytukikan</td><td>（中継用）新制度保険充当期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyphrkkknjyoutai</td><td>（中継用）保険料払込状態</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoumeiymdseireki</td><td>（中継用）証明日（西暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenippanseimeip</td><td>（中継用）年間一般生命保険料（新制度）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenippand</td><td>（中継用）年間一般配当金（新制度）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenippansymgk</td><td>（中継用）年間一般証明額（新制度）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkaigoiryoup</td><td>（中継用）年間介護医療保険料（新制度）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkaigoiryoud</td><td>（中継用）年間介護医療配当金（新制度）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyneniryousymgk</td><td>（中継用）年間介護医療証明額（新制度）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynennenkinp</td><td>（中継用）年間年金保険料（新制度）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynennenkind</td><td>（中継用）年間年金配当金（新制度）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynennenkinsmgk</td><td>（中継用）年間年金証明額（新制度）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv24</td><td>（中継用）予備項目Ｖ２４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KoujyoSyoumeiTy
 * @see     GenZT_KoujyoSyoumeiTy
 * @see     QZT_KoujyoSyoumeiTy
 * @see     GenQZT_KoujyoSyoumeiTy
 */
public class PKZT_KoujyoSyoumeiTy extends AbstractExDBPrimaryKey<ZT_KoujyoSyoumeiTy, PKZT_KoujyoSyoumeiTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_KoujyoSyoumeiTy() {
    }

    public PKZT_KoujyoSyoumeiTy(
        String pZtytyouhyouymd,
        String pZtysyono,
        String pZtysakunm15keta
    ) {
        ztytyouhyouymd = pZtytyouhyouymd;
        ztysyono = pZtysyono;
        ztysakunm15keta = pZtysakunm15keta;
    }

    @Transient
    @Override
    public Class<ZT_KoujyoSyoumeiTy> getEntityClass() {
        return ZT_KoujyoSyoumeiTy.class;
    }

    private String ztytyouhyouymd;

    public String getZtytyouhyouymd() {
        return ztytyouhyouymd;
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        ztytyouhyouymd = pZtytyouhyouymd;
    }
    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }
    private String ztysakunm15keta;

    public String getZtysakunm15keta() {
        return ztysakunm15keta;
    }

    public void setZtysakunm15keta(String pZtysakunm15keta) {
        ztysakunm15keta = pZtysakunm15keta;
    }

}