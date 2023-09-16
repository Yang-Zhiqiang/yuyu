package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_GinkouMdhnMisyuuInfoFTy;
import yuyu.def.db.mapping.GenZT_GinkouMdhnMisyuuInfoFTy;
import yuyu.def.db.meta.GenQZT_GinkouMdhnMisyuuInfoFTy;
import yuyu.def.db.meta.QZT_GinkouMdhnMisyuuInfoFTy;

/**
 * 銀行窓販未収情報Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_GinkouMdhnMisyuuInfoFTy}</td><td colspan="3">銀行窓販未収情報Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtybsydrtencd ztybsydrtencd}</td><td>（中継用）募集代理店コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv63</td><td>（中継用）予備項目Ｖ６３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydatakbn</td><td>（中継用）データ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtydatasakuseiymd ztydatasakuseiymd}</td><td>（中継用）データ作成日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknkaisyacd</td><td>（中継用）保険会社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyuruicd</td><td>（中継用）保険種類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyonosyuban ztysyonosyuban}</td><td>（中継用）証券番号主番</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyonoedaban</td><td>（中継用）証券番号枝番</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymisyuutatekaekbn</td><td>（中継用）未収立替区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymisyuutatekaeym</td><td>（中継用）未収立替発生年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymisyuukg</td><td>（中継用）未収金額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybnkaisuu</td><td>（中継用）分割回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymisyuujiyuu</td><td>（中継用）未収事由</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjikaidatakousinymd</td><td>（中継用）次回データ更新日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyikkatubaraikbn</td><td>（中継用）一括払区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyikkatubaraikaisuu</td><td>（中継用）一括払回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv28</td><td>（中継用）予備項目Ｖ２８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykosyaareav40</td><td>（中継用）個社領域Ｖ４０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_GinkouMdhnMisyuuInfoFTy
 * @see     GenZT_GinkouMdhnMisyuuInfoFTy
 * @see     QZT_GinkouMdhnMisyuuInfoFTy
 * @see     GenQZT_GinkouMdhnMisyuuInfoFTy
 */
public class PKZT_GinkouMdhnMisyuuInfoFTy extends AbstractExDBPrimaryKey<ZT_GinkouMdhnMisyuuInfoFTy, PKZT_GinkouMdhnMisyuuInfoFTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_GinkouMdhnMisyuuInfoFTy() {
    }

    public PKZT_GinkouMdhnMisyuuInfoFTy(
        String pZtybsydrtencd,
        String pZtydatasakuseiymd,
        String pZtysyonosyuban
    ) {
        ztybsydrtencd = pZtybsydrtencd;
        ztydatasakuseiymd = pZtydatasakuseiymd;
        ztysyonosyuban = pZtysyonosyuban;
    }

    @Transient
    @Override
    public Class<ZT_GinkouMdhnMisyuuInfoFTy> getEntityClass() {
        return ZT_GinkouMdhnMisyuuInfoFTy.class;
    }

    private String ztybsydrtencd;

    public String getZtybsydrtencd() {
        return ztybsydrtencd;
    }

    public void setZtybsydrtencd(String pZtybsydrtencd) {
        ztybsydrtencd = pZtybsydrtencd;
    }
    private String ztydatasakuseiymd;

    public String getZtydatasakuseiymd() {
        return ztydatasakuseiymd;
    }

    public void setZtydatasakuseiymd(String pZtydatasakuseiymd) {
        ztydatasakuseiymd = pZtydatasakuseiymd;
    }
    private String ztysyonosyuban;

    public String getZtysyonosyuban() {
        return ztysyonosyuban;
    }

    public void setZtysyonosyuban(String pZtysyonosyuban) {
        ztysyonosyuban = pZtysyonosyuban;
    }

}