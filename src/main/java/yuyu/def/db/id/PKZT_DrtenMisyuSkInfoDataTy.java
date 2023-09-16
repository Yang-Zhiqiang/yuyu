package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_DrtenMisyuSkInfoDataTy;
import yuyu.def.db.mapping.GenZT_DrtenMisyuSkInfoDataTy;
import yuyu.def.db.meta.GenQZT_DrtenMisyuSkInfoDataTy;
import yuyu.def.db.meta.QZT_DrtenMisyuSkInfoDataTy;

/**
 * 代理店未収・失効情報連動データＦテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DrtenMisyuSkInfoDataTy}</td><td colspan="3">代理店未収・失効情報連動データＦテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtybsydrtencd ztybsydrtencd}</td><td>（中継用）募集代理店コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymd</td><td>（中継用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnsyugknjkyksynm</td><td>（中継用）編集後漢字契約者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknjhhknmei</td><td>（中継用）漢字被保険者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykjyutikbn</td><td>（中継用）契約状態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytsinkihontikucd</td><td>（中継用）通信先基本地区コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykanjitsinkaiadr</td><td>（中継用）漢字通信先下位住所</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytsintelno</td><td>（中継用）通信先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2tsintelno</td><td>（中継用）第２通信先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaebankcd</td><td>（中継用）口座振替銀行番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaesitencd</td><td>（中継用）口座振替支店番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaeyokinkbn</td><td>（中継用）口座振替預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaekouzano</td><td>（中継用）口座振替口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaemeiginm</td><td>（中継用）口座振替名義人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkaisuukbn</td><td>（中継用）払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv6x5</td><td>（中継用）予備項目Ｖ６＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zty1kaip</td><td>（中継用）１回分保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynexthurikaeyoteigk</td><td>（中継用）次回振替予定金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhrkyykknmnryymd</td><td>（中継用）払込猶予期間満了日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskymd</td><td>（中継用）失効年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjhurikstkkahikbn</td><td>（中継用）自動振替貸付可否区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhukkatumoskahikbn</td><td>（中継用）復活申込可否区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyttdkkigenymd</td><td>（中継用）手続き期限年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhukkatukanoukknmnryymd</td><td>（中継用）復活可能期間満了年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeikatukisuu3keta</td><td>（中継用）経過月数（３桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymisyuuhasseiym</td><td>（中継用）未収発生年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymisyuujiyuu</td><td>（中継用）未収事由</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyhanteiymd ztyhanteiymd}</td><td>（中継用）判定年月日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobin11</td><td>（中継用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x2</td><td>（中継用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynexthurikaeymd</td><td>（中継用）次回振替年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv8x3</td><td>（中継用）予備項目Ｖ８＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyikkatubaraikbn</td><td>（中継用）一括払区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyikkatubaraikaisuu</td><td>（中継用）一括払回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv55</td><td>（中継用）予備項目Ｖ５５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_DrtenMisyuSkInfoDataTy
 * @see     GenZT_DrtenMisyuSkInfoDataTy
 * @see     QZT_DrtenMisyuSkInfoDataTy
 * @see     GenQZT_DrtenMisyuSkInfoDataTy
 */
public class PKZT_DrtenMisyuSkInfoDataTy extends AbstractExDBPrimaryKey<ZT_DrtenMisyuSkInfoDataTy, PKZT_DrtenMisyuSkInfoDataTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_DrtenMisyuSkInfoDataTy() {
    }

    public PKZT_DrtenMisyuSkInfoDataTy(
        String pZtysyono,
        String pZtybsydrtencd,
        String pZtyhanteiymd
    ) {
        ztysyono = pZtysyono;
        ztybsydrtencd = pZtybsydrtencd;
        ztyhanteiymd = pZtyhanteiymd;
    }

    @Transient
    @Override
    public Class<ZT_DrtenMisyuSkInfoDataTy> getEntityClass() {
        return ZT_DrtenMisyuSkInfoDataTy.class;
    }

    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }
    private String ztybsydrtencd;

    public String getZtybsydrtencd() {
        return ztybsydrtencd;
    }

    public void setZtybsydrtencd(String pZtybsydrtencd) {
        ztybsydrtencd = pZtybsydrtencd;
    }
    private String ztyhanteiymd;

    public String getZtyhanteiymd() {
        return ztyhanteiymd;
    }

    public void setZtyhanteiymd(String pZtyhanteiymd) {
        ztyhanteiymd = pZtyhanteiymd;
    }

}