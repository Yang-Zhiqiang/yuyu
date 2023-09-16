package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_HknkykIdouInfoRn;
import yuyu.def.db.mapping.GenZT_HknkykIdouInfoRn;
import yuyu.def.db.meta.GenQZT_HknkykIdouInfoRn;
import yuyu.def.db.meta.QZT_HknkykIdouInfoRn;

/**
 * 保険契約異動情報テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_HknkykIdouInfoRn}</td><td colspan="3">保険契約異動情報テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkyktuukasyu zrnkyktuukasyu}</td><td>（連携用）契約通貨種類</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnidouymd zrnidouymd}</td><td>（連携用）異動日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnidoujiyuukbnzfi zrnidoujiyuukbnzfi}</td><td>（連携用）異動事由区分（資産運用）</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrndatakanrino zrndatakanrino}</td><td>（連携用）データ管理番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnrenno zrnrenno}</td><td>（連携用）連番</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeiyakuymd</td><td>（連携用）契約日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnen2</td><td>（連携用）被保険者年齢Ｃ２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknsei</td><td>（連携用）被保険者性別</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyukigou</td><td>（連携用）保険種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnaisyoumeikbn</td><td>（連携用）愛称名区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzougenkbn</td><td>（連携用）増減区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokenkngk13</td><td>（連携用）保険金額Ｎ１３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnp13</td><td>（連携用）保険料Ｎ１３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnptumitatekin13</td><td>（連携用）保険料積立金Ｎ１３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnkiykhnrikn13</td><td>（連携用）解約返戻金Ｎ１３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnidouhokenkngk</td><td>（連携用）異動保険金額</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnidoup</td><td>（連携用）異動保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnidouptumitatekin</td><td>（連携用）異動保険料積立金</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnidoukiykhnrikn</td><td>（連携用）異動解約返戻金</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnhknkkn</td><td>（連携用）保険期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyoteiriritun5</td><td>（連携用）予定利率Ｎ５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntumitatekinkbn zrntumitatekinkbn}</td><td>（連携用）積立金区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnharaikatakbnkykidou</td><td>（連携用）払方区分（保険契約異動情報）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_HknkykIdouInfoRn
 * @see     GenZT_HknkykIdouInfoRn
 * @see     QZT_HknkykIdouInfoRn
 * @see     GenQZT_HknkykIdouInfoRn
 */
public class PKZT_HknkykIdouInfoRn extends AbstractExDBPrimaryKey<ZT_HknkykIdouInfoRn, PKZT_HknkykIdouInfoRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_HknkykIdouInfoRn() {
    }

    public PKZT_HknkykIdouInfoRn(
        String pZrnkyktuukasyu,
        String pZrnidouymd,
        String pZrnidoujiyuukbnzfi,
        String pZrndatakanrino,
        String pZrnrenno,
        String pZrntumitatekinkbn
    ) {
        zrnkyktuukasyu = pZrnkyktuukasyu;
        zrnidouymd = pZrnidouymd;
        zrnidoujiyuukbnzfi = pZrnidoujiyuukbnzfi;
        zrndatakanrino = pZrndatakanrino;
        zrnrenno = pZrnrenno;
        zrntumitatekinkbn = pZrntumitatekinkbn;
    }

    @Transient
    @Override
    public Class<ZT_HknkykIdouInfoRn> getEntityClass() {
        return ZT_HknkykIdouInfoRn.class;
    }

    private String zrnkyktuukasyu;

    public String getZrnkyktuukasyu() {
        return zrnkyktuukasyu;
    }

    public void setZrnkyktuukasyu(String pZrnkyktuukasyu) {
        zrnkyktuukasyu = pZrnkyktuukasyu;
    }
    private String zrnidouymd;

    public String getZrnidouymd() {
        return zrnidouymd;
    }

    public void setZrnidouymd(String pZrnidouymd) {
        zrnidouymd = pZrnidouymd;
    }
    private String zrnidoujiyuukbnzfi;

    public String getZrnidoujiyuukbnzfi() {
        return zrnidoujiyuukbnzfi;
    }

    public void setZrnidoujiyuukbnzfi(String pZrnidoujiyuukbnzfi) {
        zrnidoujiyuukbnzfi = pZrnidoujiyuukbnzfi;
    }
    private String zrndatakanrino;

    public String getZrndatakanrino() {
        return zrndatakanrino;
    }

    public void setZrndatakanrino(String pZrndatakanrino) {
        zrndatakanrino = pZrndatakanrino;
    }
    private String zrnrenno;

    public String getZrnrenno() {
        return zrnrenno;
    }

    public void setZrnrenno(String pZrnrenno) {
        zrnrenno = pZrnrenno;
    }
    private String zrntumitatekinkbn;

    public String getZrntumitatekinkbn() {
        return zrntumitatekinkbn;
    }

    public void setZrntumitatekinkbn(String pZrntumitatekinkbn) {
        zrntumitatekinkbn = pZrntumitatekinkbn;
    }

}