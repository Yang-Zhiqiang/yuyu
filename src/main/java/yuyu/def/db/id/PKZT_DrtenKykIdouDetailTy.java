package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_DrtenKykIdouDetailTy;
import yuyu.def.db.mapping.GenZT_DrtenKykIdouDetailTy;
import yuyu.def.db.meta.GenQZT_DrtenKykIdouDetailTy;
import yuyu.def.db.meta.QZT_DrtenKykIdouDetailTy;

/**
 * 代理店契約異動明細テーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DrtenKykIdouDetailTy}</td><td colspan="3">代理店契約異動明細テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztykinyuukikancd</td><td>（中継用）金融機関コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykinyuukikansitencd</td><td>（中継用）金融機関支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtybsydrtencd ztybsydrtencd}</td><td>（中継用）募集代理店コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycifcd</td><td>（中継用）ＣＩＦコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtybosyuunincd ztybosyuunincd}</td><td>（中継用）募集人コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyidouhasseiymd ztyidouhasseiymd}</td><td>（中継用）異動発生年月日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykmfksnctrlkh</td><td>（中継用）契約ＭＦ更新ＣＴＲ（保全）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyoricd</td><td>（中継用）処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyidoukbn ztyidoukbn}</td><td>（中継用）異動区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyym</td><td>（中継用）募集年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykydatkikbn</td><td>（中継用）共同扱区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymd</td><td>（中継用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjikaipjyuutouym</td><td>（中継用）次回Ｐ充当年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkaisuukbn</td><td>（中継用）払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeirokbn</td><td>（中継用）払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyanniskcd</td><td>（中継用）案内先コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydntcd</td><td>（中継用）団体コ－ド</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyharaikomip</td><td>（中継用）払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykjsyagaihknnm</td><td>（中継用）漢字社外向け保険名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytelno</td><td>（中継用）電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhensyuubosyuudrtennm</td><td>（中継用）編集後漢字募集代理店名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknmkjdirtnkykido</td><td>（中継用）契約者名（漢字）（代理店契約異動明細）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjdntnm</td><td>（中継用）漢字団体名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaebankcd</td><td>（中継用）口座振替銀行番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaesitencd</td><td>（中継用）口座振替支店番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaeyokinkbn</td><td>（中継用）口座振替預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaekouzano</td><td>（中継用）口座振替口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyoyabosyuudairitencd</td><td>（中継用）親募集代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsydrtenkanrisosikicd</td><td>（中継用）募集代理店管理組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyuudairitengyousyukbn</td><td>（中継用）募集代理店業種区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyuudrtennmkj</td><td>（中継用）募集代理店名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydoujitusyoricount</td><td>（中継用）同日処理回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhjnkykhyj</td><td>（中継用）法人契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhjnnmkj</td><td>（中継用）法人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyuhrkkaisuukbn</td><td>（中継用）表示用主契約払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyikkatubaraikbn</td><td>（中継用）一括払区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyikkatubaraikaisuu</td><td>（中継用）一括払回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv103</td><td>（中継用）予備項目Ｖ１０３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_DrtenKykIdouDetailTy
 * @see     GenZT_DrtenKykIdouDetailTy
 * @see     QZT_DrtenKykIdouDetailTy
 * @see     GenQZT_DrtenKykIdouDetailTy
 */
public class PKZT_DrtenKykIdouDetailTy extends AbstractExDBPrimaryKey<ZT_DrtenKykIdouDetailTy, PKZT_DrtenKykIdouDetailTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_DrtenKykIdouDetailTy() {
    }

    public PKZT_DrtenKykIdouDetailTy(
        String pZtybsydrtencd,
        String pZtybosyuunincd,
        String pZtysyono,
        String pZtyidouhasseiymd,
        String pZtyidoukbn
    ) {
        ztybsydrtencd = pZtybsydrtencd;
        ztybosyuunincd = pZtybosyuunincd;
        ztysyono = pZtysyono;
        ztyidouhasseiymd = pZtyidouhasseiymd;
        ztyidoukbn = pZtyidoukbn;
    }

    @Transient
    @Override
    public Class<ZT_DrtenKykIdouDetailTy> getEntityClass() {
        return ZT_DrtenKykIdouDetailTy.class;
    }

    private String ztybsydrtencd;

    public String getZtybsydrtencd() {
        return ztybsydrtencd;
    }

    public void setZtybsydrtencd(String pZtybsydrtencd) {
        ztybsydrtencd = pZtybsydrtencd;
    }
    private String ztybosyuunincd;

    public String getZtybosyuunincd() {
        return ztybosyuunincd;
    }

    public void setZtybosyuunincd(String pZtybosyuunincd) {
        ztybosyuunincd = pZtybosyuunincd;
    }
    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }
    private String ztyidouhasseiymd;

    public String getZtyidouhasseiymd() {
        return ztyidouhasseiymd;
    }

    public void setZtyidouhasseiymd(String pZtyidouhasseiymd) {
        ztyidouhasseiymd = pZtyidouhasseiymd;
    }
    private String ztyidoukbn;

    public String getZtyidoukbn() {
        return ztyidoukbn;
    }

    public void setZtyidoukbn(String pZtyidoukbn) {
        ztyidoukbn = pZtyidoukbn;
    }

}