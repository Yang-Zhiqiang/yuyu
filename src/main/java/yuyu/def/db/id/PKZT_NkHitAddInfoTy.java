package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_NkHitAddInfoTy;
import yuyu.def.db.mapping.GenZT_NkHitAddInfoTy;
import yuyu.def.db.meta.GenQZT_NkHitAddInfoTy;
import yuyu.def.db.meta.QZT_NkHitAddInfoTy;

/**
 * 年金配当所要額追加情報反映テーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_NkHitAddInfoTy}</td><td colspan="3">年金配当所要額追加情報反映テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtynksyousyono ztynksyousyono}</td><td>（中継用）年金証書番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyratekbn</td><td>（中継用）レート区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykariwariate4nenmae</td><td>（中継用）仮割当（４年前）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykariwariate3nenmae</td><td>（中継用）仮割当（３年前）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykariwariate2nenmae</td><td>（中継用）仮割当（２年前）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykariwariate1nenmae</td><td>（中継用）仮割当（１年前）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11</td><td>（中継用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x2</td><td>（中継用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x3</td><td>（中継用）予備項目Ｎ１１＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x4</td><td>（中継用）予備項目Ｎ１１＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv40</td><td>（中継用）予備項目Ｖ４０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_NkHitAddInfoTy
 * @see     GenZT_NkHitAddInfoTy
 * @see     QZT_NkHitAddInfoTy
 * @see     GenQZT_NkHitAddInfoTy
 */
public class PKZT_NkHitAddInfoTy extends AbstractExDBPrimaryKey<ZT_NkHitAddInfoTy, PKZT_NkHitAddInfoTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_NkHitAddInfoTy() {
    }

    public PKZT_NkHitAddInfoTy(String pZtynksyousyono) {
        ztynksyousyono = pZtynksyousyono;
    }

    @Transient
    @Override
    public Class<ZT_NkHitAddInfoTy> getEntityClass() {
        return ZT_NkHitAddInfoTy.class;
    }

    private String ztynksyousyono;

    public String getZtynksyousyono() {
        return ztynksyousyono;
    }

    public void setZtynksyousyono(String pZtynksyousyono) {
        ztynksyousyono = pZtynksyousyono;
    }

}