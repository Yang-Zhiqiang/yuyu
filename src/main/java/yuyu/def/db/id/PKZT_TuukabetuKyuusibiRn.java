package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_TuukabetuKyuusibiRn;
import yuyu.def.db.mapping.GenZT_TuukabetuKyuusibiRn;
import yuyu.def.db.meta.GenQZT_TuukabetuKyuusibiRn;
import yuyu.def.db.meta.QZT_TuukabetuKyuusibiRn;

/**
 * 通貨別休止日取扱休止日Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TuukabetuKyuusibiRn}</td><td colspan="3">通貨別休止日取扱休止日Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntekiyouymd zrntekiyouymd}</td><td>（連携用）適用年月日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnenkyuusibikbn</td><td>（連携用）円休止日区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbeidorukyuusibikbn</td><td>（連携用）米ドル休止日区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrneurkyuusibikbn</td><td>（連携用）ユーロ休止日区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngoudorukyuusibikbn</td><td>（連携用）豪ドル休止日区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_TuukabetuKyuusibiRn
 * @see     GenZT_TuukabetuKyuusibiRn
 * @see     QZT_TuukabetuKyuusibiRn
 * @see     GenQZT_TuukabetuKyuusibiRn
 */
public class PKZT_TuukabetuKyuusibiRn extends AbstractExDBPrimaryKey<ZT_TuukabetuKyuusibiRn, PKZT_TuukabetuKyuusibiRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_TuukabetuKyuusibiRn() {
    }

    public PKZT_TuukabetuKyuusibiRn(String pZrntekiyouymd) {
        zrntekiyouymd = pZrntekiyouymd;
    }

    @Transient
    @Override
    public Class<ZT_TuukabetuKyuusibiRn> getEntityClass() {
        return ZT_TuukabetuKyuusibiRn.class;
    }

    private String zrntekiyouymd;

    public String getZrntekiyouymd() {
        return zrntekiyouymd;
    }

    public void setZrntekiyouymd(String pZrntekiyouymd) {
        zrntekiyouymd = pZrntekiyouymd;
    }

}