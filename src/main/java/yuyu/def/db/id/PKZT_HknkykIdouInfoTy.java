package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_HknkykIdouInfoTy;
import yuyu.def.db.mapping.GenZT_HknkykIdouInfoTy;
import yuyu.def.db.meta.GenQZT_HknkykIdouInfoTy;
import yuyu.def.db.meta.QZT_HknkykIdouInfoTy;

/**
 * 保険契約異動情報テーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_HknkykIdouInfoTy}</td><td colspan="3">保険契約異動情報テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtykyktuukasyu ztykyktuukasyu}</td><td>（中継用）契約通貨種類</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyidouymd ztyidouymd}</td><td>（中継用）異動日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyidoujiyuukbnzfi ztyidoujiyuukbnzfi}</td><td>（中継用）異動事由区分（資産運用）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtydatakanrino ztydatakanrino}</td><td>（中継用）データ管理番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyrenno ztyrenno}</td><td>（中継用）連番</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakuymd</td><td>（中継用）契約日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnen2</td><td>（中継用）被保険者年齢Ｖ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknsei</td><td>（中継用）被保険者性別</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyukigou</td><td>（中継用）保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyaisyoumeikbn</td><td>（中継用）愛称名区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzougenkbn</td><td>（中継用）増減区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokenkngk13</td><td>（中継用）保険金額Ｎ１３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyp13</td><td>（中継用）保険料Ｎ１３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyptumitatekin13</td><td>（中継用）保険料積立金Ｎ１３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykiykhnrikn13</td><td>（中継用）解約返戻金Ｎ１３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyidouhokenkngk</td><td>（中継用）異動保険金額</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyidoup</td><td>（中継用）異動保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyidouptumitatekin</td><td>（中継用）異動保険料積立金</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyidoukiykhnrikn</td><td>（中継用）異動解約返戻金</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyhknkkn</td><td>（中継用）保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoteiriritun5</td><td>（中継用）予定利率Ｎ５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytumitatekinkbn ztytumitatekinkbn}</td><td>（中継用）積立金区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyharaikatakbnkykidou</td><td>（中継用）払方区分（保険契約異動情報）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_HknkykIdouInfoTy
 * @see     GenZT_HknkykIdouInfoTy
 * @see     QZT_HknkykIdouInfoTy
 * @see     GenQZT_HknkykIdouInfoTy
 */
public class PKZT_HknkykIdouInfoTy extends AbstractExDBPrimaryKey<ZT_HknkykIdouInfoTy, PKZT_HknkykIdouInfoTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_HknkykIdouInfoTy() {
    }

    public PKZT_HknkykIdouInfoTy(
        String pZtykyktuukasyu,
        String pZtyidouymd,
        String pZtyidoujiyuukbnzfi,
        String pZtydatakanrino,
        String pZtyrenno,
        String pZtytumitatekinkbn
    ) {
        ztykyktuukasyu = pZtykyktuukasyu;
        ztyidouymd = pZtyidouymd;
        ztyidoujiyuukbnzfi = pZtyidoujiyuukbnzfi;
        ztydatakanrino = pZtydatakanrino;
        ztyrenno = pZtyrenno;
        ztytumitatekinkbn = pZtytumitatekinkbn;
    }

    @Transient
    @Override
    public Class<ZT_HknkykIdouInfoTy> getEntityClass() {
        return ZT_HknkykIdouInfoTy.class;
    }

    private String ztykyktuukasyu;

    public String getZtykyktuukasyu() {
        return ztykyktuukasyu;
    }

    public void setZtykyktuukasyu(String pZtykyktuukasyu) {
        ztykyktuukasyu = pZtykyktuukasyu;
    }
    private String ztyidouymd;

    public String getZtyidouymd() {
        return ztyidouymd;
    }

    public void setZtyidouymd(String pZtyidouymd) {
        ztyidouymd = pZtyidouymd;
    }
    private String ztyidoujiyuukbnzfi;

    public String getZtyidoujiyuukbnzfi() {
        return ztyidoujiyuukbnzfi;
    }

    public void setZtyidoujiyuukbnzfi(String pZtyidoujiyuukbnzfi) {
        ztyidoujiyuukbnzfi = pZtyidoujiyuukbnzfi;
    }
    private String ztydatakanrino;

    public String getZtydatakanrino() {
        return ztydatakanrino;
    }

    public void setZtydatakanrino(String pZtydatakanrino) {
        ztydatakanrino = pZtydatakanrino;
    }
    private String ztyrenno;

    public String getZtyrenno() {
        return ztyrenno;
    }

    public void setZtyrenno(String pZtyrenno) {
        ztyrenno = pZtyrenno;
    }
    private String ztytumitatekinkbn;

    public String getZtytumitatekinkbn() {
        return ztytumitatekinkbn;
    }

    public void setZtytumitatekinkbn(String pZtytumitatekinkbn) {
        ztytumitatekinkbn = pZtytumitatekinkbn;
    }

}