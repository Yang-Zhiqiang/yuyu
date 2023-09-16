package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SeihoWebIdouListTy;
import yuyu.def.db.mapping.GenZT_SeihoWebIdouListTy;
import yuyu.def.db.meta.GenQZT_SeihoWebIdouListTy;
import yuyu.def.db.meta.QZT_SeihoWebIdouListTy;

/**
 * 生保Ｗｅｂ異動一覧抽出テーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SeihoWebIdouListTy}</td><td colspan="3">生保Ｗｅｂ異動一覧抽出テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysakuseiymd7keta ztysakuseiymd7keta}</td><td>（中継用）作成年月（７桁）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtybsydrtencd ztybsydrtencd}</td><td>（中継用）募集代理店コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytntusycd ztytntusycd}</td><td>（中継用）担当者コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyhasseiymd ztyhasseiymd}</td><td>（中継用）発生日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyidoukbn1 ztyidoukbn1}</td><td>（中継用）異動区分１</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtykydatkikbnkj ztykydatkikbnkj}</td><td>（中継用）共同扱区分（漢字）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtykykyymm ztykykyymm}</td><td>（中継用）契約年月（西暦下２桁）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtycifcd ztycifcd}</td><td>（中継用）ＣＩＦコード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymidasikbn</td><td>（中継用）見出し区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatesakinm</td><td>（中継用）宛先名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhassinka</td><td>（中継用）発信課</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyyymm</td><td>（中継用）募集年月（西暦下２桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytntusynm</td><td>（中継用）担当者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknmkjseihoweb</td><td>（中継用）契約者名（漢字）（生保ＷＥＢ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypjyuutouyymm</td><td>（中継用）保険料充当年月（西暦下２桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkaisuukj</td><td>（中継用）払込回数（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyp11keta</td><td>（中継用）保険料（１１桁）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhrkkeirobtjhmidasi</td><td>（中継用）払込経路別情報見出し</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeirobtjh</td><td>（中継用）払込経路別情報</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytntusyjk</td><td>（中継用）担当者状況</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeirokj</td><td>（中継用）払込経路（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyuruimei</td><td>（中継用）保険種類名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyidoukbn2</td><td>（中継用）異動区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydbskyoteiymd7keta</td><td>（中継用）ＤＢ削除予定年月（７桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygaikakykhrkp</td><td>（中継用）外貨契約払込保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykyktuukasyukbn</td><td>（中継用）契約通貨種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SeihoWebIdouListTy
 * @see     GenZT_SeihoWebIdouListTy
 * @see     QZT_SeihoWebIdouListTy
 * @see     GenQZT_SeihoWebIdouListTy
 */
public class PKZT_SeihoWebIdouListTy extends AbstractExDBPrimaryKey<ZT_SeihoWebIdouListTy, PKZT_SeihoWebIdouListTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_SeihoWebIdouListTy() {
    }

    public PKZT_SeihoWebIdouListTy(
        String pZtysakuseiymd7keta,
        String pZtybsydrtencd,
        String pZtytntusycd,
        String pZtysyono,
        String pZtyhasseiymd,
        String pZtyidoukbn1,
        String pZtykydatkikbnkj,
        String pZtykykyymm,
        String pZtycifcd
    ) {
        ztysakuseiymd7keta = pZtysakuseiymd7keta;
        ztybsydrtencd = pZtybsydrtencd;
        ztytntusycd = pZtytntusycd;
        ztysyono = pZtysyono;
        ztyhasseiymd = pZtyhasseiymd;
        ztyidoukbn1 = pZtyidoukbn1;
        ztykydatkikbnkj = pZtykydatkikbnkj;
        ztykykyymm = pZtykykyymm;
        ztycifcd = pZtycifcd;
    }

    @Transient
    @Override
    public Class<ZT_SeihoWebIdouListTy> getEntityClass() {
        return ZT_SeihoWebIdouListTy.class;
    }

    private String ztysakuseiymd7keta;

    public String getZtysakuseiymd7keta() {
        return ztysakuseiymd7keta;
    }

    public void setZtysakuseiymd7keta(String pZtysakuseiymd7keta) {
        ztysakuseiymd7keta = pZtysakuseiymd7keta;
    }
    private String ztybsydrtencd;

    public String getZtybsydrtencd() {
        return ztybsydrtencd;
    }

    public void setZtybsydrtencd(String pZtybsydrtencd) {
        ztybsydrtencd = pZtybsydrtencd;
    }
    private String ztytntusycd;

    public String getZtytntusycd() {
        return ztytntusycd;
    }

    public void setZtytntusycd(String pZtytntusycd) {
        ztytntusycd = pZtytntusycd;
    }
    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }
    private String ztyhasseiymd;

    public String getZtyhasseiymd() {
        return ztyhasseiymd;
    }

    public void setZtyhasseiymd(String pZtyhasseiymd) {
        ztyhasseiymd = pZtyhasseiymd;
    }
    private String ztyidoukbn1;

    public String getZtyidoukbn1() {
        return ztyidoukbn1;
    }

    public void setZtyidoukbn1(String pZtyidoukbn1) {
        ztyidoukbn1 = pZtyidoukbn1;
    }
    private String ztykydatkikbnkj;

    public String getZtykydatkikbnkj() {
        return ztykydatkikbnkj;
    }

    public void setZtykydatkikbnkj(String pZtykydatkikbnkj) {
        ztykydatkikbnkj = pZtykydatkikbnkj;
    }
    private String ztykykyymm;

    public String getZtykykyymm() {
        return ztykykyymm;
    }

    public void setZtykykyymm(String pZtykykyymm) {
        ztykykyymm = pZtykykyymm;
    }
    private String ztycifcd;

    public String getZtycifcd() {
        return ztycifcd;
    }

    public void setZtycifcd(String pZtycifcd) {
        ztycifcd = pZtycifcd;
    }

}