package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_CreditHnknTuutiTy;
import yuyu.def.db.mapping.GenZT_CreditHnknTuutiTy;
import yuyu.def.db.meta.GenQZT_CreditHnknTuutiTy;
import yuyu.def.db.meta.QZT_CreditHnknTuutiTy;

/**
 * クレカ返金通知テーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_CreditHnknTuutiTy}</td><td colspan="3">クレカ返金通知テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztysyoruicd</td><td>（中継用）書類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhassoukbn</td><td>（中継用）発送区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytyouhyouymdkj</td><td>（中継用）帳票作成日（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysikibetuno ztysikibetuno}</td><td>（中継用）識別番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv14</td><td>（中継用）予備項目Ｖ１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyansyuyouyobin10</td><td>（中継用）案内収納用予備項目Ｎ１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshskyno</td><td>（中継用）送付先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshskadr1kj</td><td>（中継用）送付先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshskadr2kj</td><td>（中継用）送付先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshskadr3kj</td><td>（中継用）送付先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshsnmkj</td><td>（中継用）送付先名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv43</td><td>（中継用）予備項目Ｖ４３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyansyuyouyobin10x2</td><td>（中継用）案内収納用予備項目Ｎ１０＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
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
 *  <tr><td>ztysakunm15keta</td><td>（中継用）作成番号（１５桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv62</td><td>（中継用）予備項目Ｖ６２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyansyuyouyobin10x3</td><td>（中継用）案内収納用予備項目Ｎ１０＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsgmongon1</td><td>（中継用）返金メッセージ文言１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsgmongon2</td><td>（中継用）返金メッセージ文言２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsgmongon3</td><td>（中継用）返金メッセージ文言３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsgmongon4</td><td>（中継用）返金メッセージ文言４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsgmongon5</td><td>（中継用）返金メッセージ文言５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsgmongon6</td><td>（中継用）返金メッセージ文言６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsgmongon7</td><td>（中継用）返金メッセージ文言７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsgmongon8</td><td>（中継用）返金メッセージ文言８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsgmongon9</td><td>（中継用）返金メッセージ文言９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsgmongon10</td><td>（中継用）返金メッセージ文言１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv128</td><td>（中継用）予備項目Ｖ１２８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyansyuyouyobin10x4</td><td>（中継用）案内収納用予備項目Ｎ１０＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytuutisakuseiymdv32</td><td>（中継用）通知作成年月日Ｖ３２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv64</td><td>（中継用）予備項目Ｖ６４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyansyuyouyobin10x5</td><td>（中継用）案内収納用予備項目Ｎ１０＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknnaiyoumongon1</td><td>（中継用）返金内容文言１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknnaiyoumongon2</td><td>（中継用）返金内容文言２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknnaiyoumongon3</td><td>（中継用）返金内容文言３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknnaiyoumongon4</td><td>（中継用）返金内容文言４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknnaiyoumongon5</td><td>（中継用）返金内容文言５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknnaiyoumongon6</td><td>（中継用）返金内容文言６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknnaiyoumongon7</td><td>（中継用）返金内容文言７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknnaiyoumongon8</td><td>（中継用）返金内容文言８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv128x2</td><td>（中継用）予備項目Ｖ１２８＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyansyuyouyobin10x6</td><td>（中継用）案内収納用予備項目Ｎ１０＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsghsk1</td><td>（中継用）返金メッセージ補足１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsghsk2</td><td>（中継用）返金メッセージ補足２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsghsk3</td><td>（中継用）返金メッセージ補足３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsghsk4</td><td>（中継用）返金メッセージ補足４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsghsk5</td><td>（中継用）返金メッセージ補足５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsghsk6</td><td>（中継用）返金メッセージ補足６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsghsk7</td><td>（中継用）返金メッセージ補足７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsghsk8</td><td>（中継用）返金メッセージ補足８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsghsk9</td><td>（中継用）返金メッセージ補足９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsghsk10</td><td>（中継用）返金メッセージ補足１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsghsk11</td><td>（中継用）返金メッセージ補足１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsghsk12</td><td>（中継用）返金メッセージ補足１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsghsk13</td><td>（中継用）返金メッセージ補足１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsghsk14</td><td>（中継用）返金メッセージ補足１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsghsk15</td><td>（中継用）返金メッセージ補足１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsghsk16</td><td>（中継用）返金メッセージ補足１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsghsk17</td><td>（中継用）返金メッセージ補足１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsghsk18</td><td>（中継用）返金メッセージ補足１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsghsk19</td><td>（中継用）返金メッセージ補足１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnknmsghsk20</td><td>（中継用）返金メッセージ補足２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv128x3</td><td>（中継用）予備項目Ｖ１２８＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyansyuyouyobin10x7</td><td>（中継用）案内収納用予備項目Ｎ１０＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_CreditHnknTuutiTy
 * @see     GenZT_CreditHnknTuutiTy
 * @see     QZT_CreditHnknTuutiTy
 * @see     GenQZT_CreditHnknTuutiTy
 */
public class PKZT_CreditHnknTuutiTy extends AbstractExDBPrimaryKey<ZT_CreditHnknTuutiTy, PKZT_CreditHnknTuutiTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_CreditHnknTuutiTy() {
    }

    public PKZT_CreditHnknTuutiTy(
        String pZtysyono,
        String pZtytyouhyouymd,
        String pZtysikibetuno
    ) {
        ztysyono = pZtysyono;
        ztytyouhyouymd = pZtytyouhyouymd;
        ztysikibetuno = pZtysikibetuno;
    }

    @Transient
    @Override
    public Class<ZT_CreditHnknTuutiTy> getEntityClass() {
        return ZT_CreditHnknTuutiTy.class;
    }

    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }
    private String ztytyouhyouymd;

    public String getZtytyouhyouymd() {
        return ztytyouhyouymd;
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        ztytyouhyouymd = pZtytyouhyouymd;
    }
    private String ztysikibetuno;

    public String getZtysikibetuno() {
        return ztysikibetuno;
    }

    public void setZtysikibetuno(String pZtysikibetuno) {
        ztysikibetuno = pZtysikibetuno;
    }

}