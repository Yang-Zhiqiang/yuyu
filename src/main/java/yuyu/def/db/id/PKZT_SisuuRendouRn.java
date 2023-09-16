package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SisuuRendouRn;
import yuyu.def.db.mapping.GenZT_SisuuRendouRn;
import yuyu.def.db.meta.GenQZT_SisuuRendouRn;
import yuyu.def.db.meta.QZT_SisuuRendouRn;

/**
 * 指数連動Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SisuuRendouRn}</td><td colspan="3">指数連動Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntorikomiyousisuukbn zrntorikomiyousisuukbn}</td><td>（連携用）取込用指数区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsisuukouhyouymd zrnsisuukouhyouymd}</td><td>（連携用）指数公表日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntorikomiyousisuu</td><td>（連携用）取込用指数</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisuucalckijyunymd</td><td>（連携用）指数計算基準日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobin11x40</td><td>（連携用）予備項目Ｎ１１＿４０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobiv71</td><td>（連携用）予備項目Ｖ７１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SisuuRendouRn
 * @see     GenZT_SisuuRendouRn
 * @see     QZT_SisuuRendouRn
 * @see     GenQZT_SisuuRendouRn
 */
public class PKZT_SisuuRendouRn extends AbstractExDBPrimaryKey<ZT_SisuuRendouRn, PKZT_SisuuRendouRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_SisuuRendouRn() {
    }

    public PKZT_SisuuRendouRn(String pZrntorikomiyousisuukbn, String pZrnsisuukouhyouymd) {
        zrntorikomiyousisuukbn = pZrntorikomiyousisuukbn;
        zrnsisuukouhyouymd = pZrnsisuukouhyouymd;
    }

    @Transient
    @Override
    public Class<ZT_SisuuRendouRn> getEntityClass() {
        return ZT_SisuuRendouRn.class;
    }

    private String zrntorikomiyousisuukbn;

    public String getZrntorikomiyousisuukbn() {
        return zrntorikomiyousisuukbn;
    }

    public void setZrntorikomiyousisuukbn(String pZrntorikomiyousisuukbn) {
        zrntorikomiyousisuukbn = pZrntorikomiyousisuukbn;
    }
    private String zrnsisuukouhyouymd;

    public String getZrnsisuukouhyouymd() {
        return zrnsisuukouhyouymd;
    }

    public void setZrnsisuukouhyouymd(String pZrnsisuukouhyouymd) {
        zrnsisuukouhyouymd = pZrnsisuukouhyouymd;
    }

}