package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KzhuriAnnaiUlfTy;
import yuyu.def.db.mapping.GenZT_KzhuriAnnaiUlfTy;
import yuyu.def.db.meta.GenQZT_KzhuriAnnaiUlfTy;
import yuyu.def.db.meta.QZT_KzhuriAnnaiUlfTy;

/**
 * 口座振替案内ＵＬＦテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KzhuriAnnaiUlfTy}</td><td colspan="3">口座振替案内ＵＬＦテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydantaicd</td><td>（中継用）団体コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaebankcd</td><td>（中継用）口座振替銀行番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaesitencd</td><td>（中継用）口座振替支店番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaeyokinkbn</td><td>（中継用）口座振替預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaekouzano</td><td>（中継用）口座振替口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaeannaikbn</td><td>（中継用）口座振替案内区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhurikaeymd</td><td>（中継用）振替年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyrsgaku</td><td>（中継用）領収金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyjyuutouym ztyjyuutouym}</td><td>（中継用）充当年月</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjyuutounensuu</td><td>（中継用）充当年数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjyuutoutukisuu</td><td>（中継用）充当月数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydantaikobetukbn</td><td>（中継用）団体個別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymd</td><td>（中継用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyukigou</td><td>（中継用）保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynyknaiyou</td><td>（中継用）入金内容</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyaatukaisosikicd</td><td>（中継用）Ａ扱者組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkaisuukbn</td><td>（中継用）払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaetkbtannaihyj</td><td>（中継用）口座振替特別案内表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkgk</td><td>（中継用）払込額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11</td><td>（中継用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x2</td><td>（中継用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x3</td><td>（中継用）予備項目Ｎ１１＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytsnsknewyno</td><td>（中継用）通信先新郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytsnsknewtikucd</td><td>（中継用）通信先新地区コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyaatukaikojincd</td><td>（中継用）Ａ扱者個人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyym</td><td>（中継用）募集年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteikeisyouhinhyj</td><td>（中継用）提携商品表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzmeiginmei</td><td>（中継用）口座名義人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeizokup</td><td>（中継用）継続保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyiktwaribikikgk</td><td>（中継用）一括割引額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykeizokupnaiyoukbn</td><td>（中継用）継続Ｐ内容区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhisaijiannaitsghyj</td><td>（中継用）被災時案内対象外表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydaisyono</td><td>（中継用）代表証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurisyuudaikokbn</td><td>（中継用）口座振替収納代行会社区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv17</td><td>（中継用）予備項目Ｖ１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KzhuriAnnaiUlfTy
 * @see     GenZT_KzhuriAnnaiUlfTy
 * @see     QZT_KzhuriAnnaiUlfTy
 * @see     GenQZT_KzhuriAnnaiUlfTy
 */
public class PKZT_KzhuriAnnaiUlfTy extends AbstractExDBPrimaryKey<ZT_KzhuriAnnaiUlfTy, PKZT_KzhuriAnnaiUlfTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_KzhuriAnnaiUlfTy() {
    }

    public PKZT_KzhuriAnnaiUlfTy(String pZtysyono, String pZtyjyuutouym) {
        ztysyono = pZtysyono;
        ztyjyuutouym = pZtyjyuutouym;
    }

    @Transient
    @Override
    public Class<ZT_KzhuriAnnaiUlfTy> getEntityClass() {
        return ZT_KzhuriAnnaiUlfTy.class;
    }

    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }
    private String ztyjyuutouym;

    public String getZtyjyuutouym() {
        return ztyjyuutouym;
    }

    public void setZtyjyuutouym(String pZtyjyuutouym) {
        ztyjyuutouym = pZtyjyuutouym;
    }

}