package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_TumitateYosokuTy;
import yuyu.def.db.mapping.GenZT_TumitateYosokuTy;
import yuyu.def.db.meta.GenQZT_TumitateYosokuTy;
import yuyu.def.db.meta.QZT_TumitateYosokuTy;

/**
 * 積立金額予測ファイルテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TumitateYosokuTy}</td><td colspan="3">積立金額予測ファイルテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtykeiyakuymd ztykeiyakuymd}</td><td>（中継用）契約日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytysytymd ztytysytymd}</td><td>（中継用）抽出日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtykyktuukasyu ztykyktuukasyu}</td><td>（中継用）契約通貨種類</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyhknkkn ztyhknkkn}</td><td>（中継用）保険期間</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytmttknsyuruikbn ztytmttknsyuruikbn}</td><td>（中継用）積立金種類区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysisuukbn ztysisuukbn}</td><td>（中継用）指数区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknysktaisyoukensuu</td><td>（中継用）積立金予測対象件数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztykyktuukakyktmttkngk</td><td>（中継用）契約通貨建契約時積立金額</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykyktuukakisitmttkngk</td><td>（中継用）契約通貨建期始積立金額</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykyktuukaysktmttkngk</td><td>（中継用）契約通貨建予測積立金額</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     ZT_TumitateYosokuTy
 * @see     GenZT_TumitateYosokuTy
 * @see     QZT_TumitateYosokuTy
 * @see     GenQZT_TumitateYosokuTy
 */
public class PKZT_TumitateYosokuTy extends AbstractExDBPrimaryKey<ZT_TumitateYosokuTy, PKZT_TumitateYosokuTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_TumitateYosokuTy() {
    }

    public PKZT_TumitateYosokuTy(
        String pZtyhknsyukigou,
        String pZtykeiyakuymd,
        String pZtytysytymd,
        String pZtykyktuukasyu,
        String pZtyhknkkn,
        String pZtytmttknsyuruikbn,
        String pZtysisuukbn
    ) {
        ztyhknsyukigou = pZtyhknsyukigou;
        ztykeiyakuymd = pZtykeiyakuymd;
        ztytysytymd = pZtytysytymd;
        ztykyktuukasyu = pZtykyktuukasyu;
        ztyhknkkn = pZtyhknkkn;
        ztytmttknsyuruikbn = pZtytmttknsyuruikbn;
        ztysisuukbn = pZtysisuukbn;
    }

    @Transient
    @Override
    public Class<ZT_TumitateYosokuTy> getEntityClass() {
        return ZT_TumitateYosokuTy.class;
    }

    private String ztyhknsyukigou;

    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }
    private String ztykeiyakuymd;

    public String getZtykeiyakuymd() {
        return ztykeiyakuymd;
    }

    public void setZtykeiyakuymd(String pZtykeiyakuymd) {
        ztykeiyakuymd = pZtykeiyakuymd;
    }
    private String ztytysytymd;

    public String getZtytysytymd() {
        return ztytysytymd;
    }

    public void setZtytysytymd(String pZtytysytymd) {
        ztytysytymd = pZtytysytymd;
    }
    private String ztykyktuukasyu;

    public String getZtykyktuukasyu() {
        return ztykyktuukasyu;
    }

    public void setZtykyktuukasyu(String pZtykyktuukasyu) {
        ztykyktuukasyu = pZtykyktuukasyu;
    }
    private String ztyhknkkn;

    public String getZtyhknkkn() {
        return ztyhknkkn;
    }

    public void setZtyhknkkn(String pZtyhknkkn) {
        ztyhknkkn = pZtyhknkkn;
    }
    private String ztytmttknsyuruikbn;

    public String getZtytmttknsyuruikbn() {
        return ztytmttknsyuruikbn;
    }

    public void setZtytmttknsyuruikbn(String pZtytmttknsyuruikbn) {
        ztytmttknsyuruikbn = pZtytmttknsyuruikbn;
    }
    private String ztysisuukbn;

    public String getZtysisuukbn() {
        return ztysisuukbn;
    }

    public void setZtysisuukbn(String pZtysisuukbn) {
        ztysisuukbn = pZtysisuukbn;
    }

}