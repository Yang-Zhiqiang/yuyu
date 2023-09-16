package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SeihoWebIdouListRn;
import yuyu.def.db.mapping.GenZT_SeihoWebIdouListRn;
import yuyu.def.db.meta.GenQZT_SeihoWebIdouListRn;
import yuyu.def.db.meta.QZT_SeihoWebIdouListRn;

/**
 * 生保Ｗｅｂ異動一覧抽出テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SeihoWebIdouListRn}</td><td colspan="3">生保Ｗｅｂ異動一覧抽出テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsakuseiymd7keta zrnsakuseiymd7keta}</td><td>（連携用）作成年月（７桁）</td><td align="center">○</td><td align="center">N</td><td>Long</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnbsydrtencd zrnbsydrtencd}</td><td>（連携用）募集代理店コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntntusycd zrntntusycd}</td><td>（連携用）担当者コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnhasseiymd zrnhasseiymd}</td><td>（連携用）発生日</td><td align="center">○</td><td align="center">G</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnidoukbn1 zrnidoukbn1}</td><td>（連携用）異動区分１</td><td align="center">○</td><td align="center">G</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkydatkikbnkj zrnkydatkikbnkj}</td><td>（連携用）共同扱区分（漢字）</td><td align="center">○</td><td align="center">G</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkykyymm zrnkykyymm}</td><td>（連携用）契約年月（西暦下２桁）</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrncifcd zrncifcd}</td><td>（連携用）ＣＩＦコード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmidasikbn</td><td>（連携用）見出し区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnatesakinm</td><td>（連携用）宛先名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhassinka</td><td>（連携用）発信課</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnbsyyymm</td><td>（連携用）募集年月（西暦下２桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntntusynm</td><td>（連携用）担当者名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkyknmkjseihoweb</td><td>（連携用）契約者名（漢字）（生保ＷＥＢ）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnpjyuutouyymm</td><td>（連携用）保険料充当年月（西暦下２桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkaisuukj</td><td>（連携用）払込回数（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnp11keta</td><td>（連携用）保険料（１１桁）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhrkkeirobtjhmidasi</td><td>（連携用）払込経路別情報見出し</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkeirobtjh</td><td>（連携用）払込経路別情報</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntntusyjk</td><td>（連携用）担当者状況</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkeirokj</td><td>（連携用）払込経路（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhknsyuruimei</td><td>（連携用）保険種類名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnidoukbn2</td><td>（連携用）異動区分２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndbskyoteiymd7keta</td><td>（連携用）ＤＢ削除予定年月（７桁）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngaikakykhrkp</td><td>（連携用）外貨契約払込保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnkyktuukasyukbn</td><td>（連携用）契約通貨種類区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SeihoWebIdouListRn
 * @see     GenZT_SeihoWebIdouListRn
 * @see     QZT_SeihoWebIdouListRn
 * @see     GenQZT_SeihoWebIdouListRn
 */
public class PKZT_SeihoWebIdouListRn extends AbstractExDBPrimaryKey<ZT_SeihoWebIdouListRn, PKZT_SeihoWebIdouListRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_SeihoWebIdouListRn() {
    }

    public PKZT_SeihoWebIdouListRn(
        Long pZrnsakuseiymd7keta,
        String pZrnbsydrtencd,
        String pZrntntusycd,
        String pZrnsyono,
        String pZrnhasseiymd,
        String pZrnidoukbn1,
        String pZrnkydatkikbnkj,
        String pZrnkykyymm,
        String pZrncifcd
    ) {
        zrnsakuseiymd7keta = pZrnsakuseiymd7keta;
        zrnbsydrtencd = pZrnbsydrtencd;
        zrntntusycd = pZrntntusycd;
        zrnsyono = pZrnsyono;
        zrnhasseiymd = pZrnhasseiymd;
        zrnidoukbn1 = pZrnidoukbn1;
        zrnkydatkikbnkj = pZrnkydatkikbnkj;
        zrnkykyymm = pZrnkykyymm;
        zrncifcd = pZrncifcd;
    }

    @Transient
    @Override
    public Class<ZT_SeihoWebIdouListRn> getEntityClass() {
        return ZT_SeihoWebIdouListRn.class;
    }

    private Long zrnsakuseiymd7keta;

    public Long getZrnsakuseiymd7keta() {
        return zrnsakuseiymd7keta;
    }

    public void setZrnsakuseiymd7keta(Long pZrnsakuseiymd7keta) {
        zrnsakuseiymd7keta = pZrnsakuseiymd7keta;
    }
    private String zrnbsydrtencd;

    public String getZrnbsydrtencd() {
        return zrnbsydrtencd;
    }

    public void setZrnbsydrtencd(String pZrnbsydrtencd) {
        zrnbsydrtencd = pZrnbsydrtencd;
    }
    private String zrntntusycd;

    public String getZrntntusycd() {
        return zrntntusycd;
    }

    public void setZrntntusycd(String pZrntntusycd) {
        zrntntusycd = pZrntntusycd;
    }
    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }
    private String zrnhasseiymd;

    public String getZrnhasseiymd() {
        return zrnhasseiymd;
    }

    public void setZrnhasseiymd(String pZrnhasseiymd) {
        zrnhasseiymd = pZrnhasseiymd;
    }
    private String zrnidoukbn1;

    public String getZrnidoukbn1() {
        return zrnidoukbn1;
    }

    public void setZrnidoukbn1(String pZrnidoukbn1) {
        zrnidoukbn1 = pZrnidoukbn1;
    }
    private String zrnkydatkikbnkj;

    public String getZrnkydatkikbnkj() {
        return zrnkydatkikbnkj;
    }

    public void setZrnkydatkikbnkj(String pZrnkydatkikbnkj) {
        zrnkydatkikbnkj = pZrnkydatkikbnkj;
    }
    private String zrnkykyymm;

    public String getZrnkykyymm() {
        return zrnkykyymm;
    }

    public void setZrnkykyymm(String pZrnkykyymm) {
        zrnkykyymm = pZrnkykyymm;
    }
    private String zrncifcd;

    public String getZrncifcd() {
        return zrncifcd;
    }

    public void setZrncifcd(String pZrncifcd) {
        zrncifcd = pZrncifcd;
    }

}