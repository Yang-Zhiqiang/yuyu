package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_DrtenMisyuSkInfoDataRn;
import yuyu.def.db.mapping.GenZT_DrtenMisyuSkInfoDataRn;
import yuyu.def.db.meta.GenQZT_DrtenMisyuSkInfoDataRn;
import yuyu.def.db.meta.QZT_DrtenMisyuSkInfoDataRn;

/**
 * 代理店未収・失効情報連動データＦテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DrtenMisyuSkInfoDataRn}</td><td colspan="3">代理店未収・失効情報連動データＦテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnbsydrtencd zrnbsydrtencd}</td><td>（連携用）募集代理店コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykymd</td><td>（連携用）契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhnsyugknjkyksynm</td><td>（連携用）編集後漢字契約者名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnknjhhknmei</td><td>（連携用）漢字被保険者名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkykjyutikbn</td><td>（連携用）契約状態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsinkihontikucd</td><td>（連携用）通信先基本地区コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanjitsinkaiadr</td><td>（連携用）漢字通信先下位住所</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntsintelno</td><td>（連携用）通信先電話番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2tsintelno</td><td>（連携用）第２通信先電話番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaebankcd</td><td>（連携用）口座振替銀行番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaesitencd</td><td>（連携用）口座振替支店番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaeyokinkbn</td><td>（連携用）口座振替預金種目区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaekouzano</td><td>（連携用）口座振替口座番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaemeiginm</td><td>（連携用）口座振替名義人名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkaisuukbn</td><td>（連携用）払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv6x5</td><td>（連携用）予備項目Ｖ６＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrn1kaip</td><td>（連携用）１回分保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnexthurikaeyoteigk</td><td>（連携用）次回振替予定金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhrkyykknmnryymd</td><td>（連携用）払込猶予期間満了日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskymd</td><td>（連携用）失効年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjhurikstkkahikbn</td><td>（連携用）自動振替貸付可否区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhukkatumoskahikbn</td><td>（連携用）復活申込可否区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnttdkkigenymd</td><td>（連携用）手続き期限年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhukkatukanoukknmnryymd</td><td>（連携用）復活可能期間満了年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeikatukisuu3keta</td><td>（連携用）経過月数（３桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmisyuuhasseiym</td><td>（連携用）未収発生年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmisyuujiyuu</td><td>（連携用）未収事由</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnhanteiymd zrnhanteiymd}</td><td>（連携用）判定年月日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobin11</td><td>（連携用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x2</td><td>（連携用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnexthurikaeymd</td><td>（連携用）次回振替年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv8x3</td><td>（連携用）予備項目Ｖ８＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnikkatubaraikbn</td><td>（連携用）一括払区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnikkatubaraikaisuu</td><td>（連携用）一括払回数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv55</td><td>（連携用）予備項目Ｖ５５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_DrtenMisyuSkInfoDataRn
 * @see     GenZT_DrtenMisyuSkInfoDataRn
 * @see     QZT_DrtenMisyuSkInfoDataRn
 * @see     GenQZT_DrtenMisyuSkInfoDataRn
 */
public class PKZT_DrtenMisyuSkInfoDataRn extends AbstractExDBPrimaryKey<ZT_DrtenMisyuSkInfoDataRn, PKZT_DrtenMisyuSkInfoDataRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_DrtenMisyuSkInfoDataRn() {
    }

    public PKZT_DrtenMisyuSkInfoDataRn(
        String pZrnsyono,
        String pZrnbsydrtencd,
        String pZrnhanteiymd
    ) {
        zrnsyono = pZrnsyono;
        zrnbsydrtencd = pZrnbsydrtencd;
        zrnhanteiymd = pZrnhanteiymd;
    }

    @Transient
    @Override
    public Class<ZT_DrtenMisyuSkInfoDataRn> getEntityClass() {
        return ZT_DrtenMisyuSkInfoDataRn.class;
    }

    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }
    private String zrnbsydrtencd;

    public String getZrnbsydrtencd() {
        return zrnbsydrtencd;
    }

    public void setZrnbsydrtencd(String pZrnbsydrtencd) {
        zrnbsydrtencd = pZrnbsydrtencd;
    }
    private String zrnhanteiymd;

    public String getZrnhanteiymd() {
        return zrnhanteiymd;
    }

    public void setZrnhanteiymd(String pZrnhanteiymd) {
        zrnhanteiymd = pZrnhanteiymd;
    }

}