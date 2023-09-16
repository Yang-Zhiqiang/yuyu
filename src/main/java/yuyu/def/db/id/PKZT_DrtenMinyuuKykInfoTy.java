package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_DrtenMinyuuKykInfoTy;
import yuyu.def.db.mapping.GenZT_DrtenMinyuuKykInfoTy;
import yuyu.def.db.meta.GenQZT_DrtenMinyuuKykInfoTy;
import yuyu.def.db.meta.QZT_DrtenMinyuuKykInfoTy;

/**
 * 代理店未入契約情報Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DrtenMinyuuKykInfoTy}</td><td colspan="3">代理店未入契約情報Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymd</td><td>（中継用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyym</td><td>（中継用）募集年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkaisuukbn</td><td>（中継用）払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeirokbn</td><td>（中継用）払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyuukeikbn</td><td>（中継用）集計区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyukaisuu</td><td>（中継用）未入回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymisyuup</td><td>（中継用）未収Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhsys</td><td>（中継用）保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyuuseis</td><td>（中継用）修正Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyfukkatutyuuikbn</td><td>（中継用）復活注意区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymrarihyj</td><td>（中継用）ＭＲ有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfsttatekaekykhyj</td><td>（中継用）初回立替契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytatekaekjrenzokukaisu</td><td>（中継用）立替計上連続回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeizokutyuuihyouji</td><td>（中継用）継続注意表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyouhinbunruikbn</td><td>（中継用）商品分類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyouhnnmkbn</td><td>（中継用）商品名称区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyukigou</td><td>（中継用）保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjikaipjyuutouym</td><td>（中継用）次回Ｐ充当年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaehurihunokbn</td><td>（中継用）口座振替振替不能理由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyautocalltaisyoukykhyj</td><td>（中継用）オートコール対象契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsudirtnatkikeitaikbn</td><td>（中継用）募集代理店扱形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsydrtencdx1</td><td>（中継用）募集代理店コード＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsydrtencdx2</td><td>（中継用）募集代理店コード＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyikkatubaraikbn</td><td>（中継用）一括払区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyikkatubaraikaisuu</td><td>（中継用）一括払回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv34</td><td>（中継用）予備項目Ｖ３４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_DrtenMinyuuKykInfoTy
 * @see     GenZT_DrtenMinyuuKykInfoTy
 * @see     QZT_DrtenMinyuuKykInfoTy
 * @see     GenQZT_DrtenMinyuuKykInfoTy
 */
public class PKZT_DrtenMinyuuKykInfoTy extends AbstractExDBPrimaryKey<ZT_DrtenMinyuuKykInfoTy, PKZT_DrtenMinyuuKykInfoTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_DrtenMinyuuKykInfoTy() {
    }

    public PKZT_DrtenMinyuuKykInfoTy(String pZtysyono) {
        ztysyono = pZtysyono;
    }

    @Transient
    @Override
    public Class<ZT_DrtenMinyuuKykInfoTy> getEntityClass() {
        return ZT_DrtenMinyuuKykInfoTy.class;
    }

    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

}