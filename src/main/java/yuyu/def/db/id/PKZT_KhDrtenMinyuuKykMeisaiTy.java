package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KhDrtenMinyuuKykMeisaiTy;
import yuyu.def.db.mapping.GenZT_KhDrtenMinyuuKykMeisaiTy;
import yuyu.def.db.meta.GenQZT_KhDrtenMinyuuKykMeisaiTy;
import yuyu.def.db.meta.QZT_KhDrtenMinyuuKykMeisaiTy;

/**
 * 代理店未入契約明細テーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KhDrtenMinyuuKykMeisaiTy}</td><td colspan="3">代理店未入契約明細テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyoriymd ztysyoriymd}</td><td>（中継用）処理年月日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtybsydrtencd ztybsydrtencd}</td><td>（中継用）募集代理店コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyuunincd</td><td>（中継用）募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypjyuutouyymmwareki4keta</td><td>（中継用）保険料充当年月（和暦）（４桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymd</td><td>（中継用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycifcd</td><td>（中継用）ＣＩＦコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyuudrtennmkj</td><td>（中継用）募集代理店名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuujyutuymd</td><td>（中継用）未入充当年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhassinka</td><td>（中継用）発信課</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyym</td><td>（中継用）募集年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydrtnbsyunnmisyou</td><td>（中継用）代理店募集人名称（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykydatkikbn</td><td>（中継用）共同扱区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknmkj35</td><td>（中継用）契約者名（漢字）（３５桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkaisuukbn</td><td>（中継用）払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeirokbn</td><td>（中継用）払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkgk</td><td>（中継用）払込額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyknkimnyuuryu</td><td>（中継用）今回未入理由</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyuuningyouhaiymd</td><td>（中継用）募集人業廃年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaebankcd</td><td>（中継用）口座振替銀行番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaesitencd</td><td>（中継用）口座振替支店番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaeyokinkbn</td><td>（中継用）口座振替預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaekouzano</td><td>（中継用）口座振替口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknyukknmei</td><td>（中継用）金融機関名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknyykknstnmei</td><td>（中継用）金融機関支店名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydantaicd</td><td>（中継用）団体コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjdntnm</td><td>（中継用）漢字団体名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zty30ketahknsyuruimei</td><td>（中継用）３０桁保険種類名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybkofccd</td><td>（中継用）バックオフィスコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhjnkykhyj</td><td>（中継用）法人契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KhDrtenMinyuuKykMeisaiTy
 * @see     GenZT_KhDrtenMinyuuKykMeisaiTy
 * @see     QZT_KhDrtenMinyuuKykMeisaiTy
 * @see     GenQZT_KhDrtenMinyuuKykMeisaiTy
 */
public class PKZT_KhDrtenMinyuuKykMeisaiTy extends AbstractExDBPrimaryKey<ZT_KhDrtenMinyuuKykMeisaiTy, PKZT_KhDrtenMinyuuKykMeisaiTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_KhDrtenMinyuuKykMeisaiTy() {
    }

    public PKZT_KhDrtenMinyuuKykMeisaiTy(
        String pZtysyoriymd,
        String pZtybsydrtencd,
        String pZtysyono
    ) {
        ztysyoriymd = pZtysyoriymd;
        ztybsydrtencd = pZtybsydrtencd;
        ztysyono = pZtysyono;
    }

    @Transient
    @Override
    public Class<ZT_KhDrtenMinyuuKykMeisaiTy> getEntityClass() {
        return ZT_KhDrtenMinyuuKykMeisaiTy.class;
    }

    private String ztysyoriymd;

    public String getZtysyoriymd() {
        return ztysyoriymd;
    }

    public void setZtysyoriymd(String pZtysyoriymd) {
        ztysyoriymd = pZtysyoriymd;
    }
    private String ztybsydrtencd;

    public String getZtybsydrtencd() {
        return ztybsydrtencd;
    }

    public void setZtybsydrtencd(String pZtybsydrtencd) {
        ztybsydrtencd = pZtybsydrtencd;
    }
    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

}