package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_SisuuRendouRn;
import yuyu.def.db.id.PKZT_SisuuRendouRn;
import yuyu.def.db.meta.GenQZT_SisuuRendouRn;
import yuyu.def.db.meta.QZT_SisuuRendouRn;

/**
 * 指数連動Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SisuuRendouRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SisuuRendouRn}</td><td colspan="3">指数連動Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrntorikomiyousisuukbn zrntorikomiyousisuukbn}</td><td>（連携用）取込用指数区分</td><td align="center">{@link PKZT_SisuuRendouRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuukouhyouymd zrnsisuukouhyouymd}</td><td>（連携用）指数公表日</td><td align="center">{@link PKZT_SisuuRendouRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntorikomiyousisuu zrntorikomiyousisuu}</td><td>（連携用）取込用指数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisuucalckijyunymd zrnsisuucalckijyunymd}</td><td>（連携用）指数計算基準日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobin11x40 zrnyobin11x40}</td><td>（連携用）予備項目Ｎ１１＿４０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobiv71 zrnyobiv71}</td><td>（連携用）予備項目Ｖ７１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SisuuRendouRn
 * @see     PKZT_SisuuRendouRn
 * @see     QZT_SisuuRendouRn
 * @see     GenQZT_SisuuRendouRn
 */
@MappedSuperclass
@Table(name=GenZT_SisuuRendouRn.TABLE_NAME)
@IdClass(value=PKZT_SisuuRendouRn.class)
public abstract class GenZT_SisuuRendouRn extends AbstractExDBEntityForZDB<ZT_SisuuRendouRn, PKZT_SisuuRendouRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SisuuRendouRn";
    public static final String ZRNTORIKOMIYOUSISUUKBN   = "zrntorikomiyousisuukbn";
    public static final String ZRNSISUUKOUHYOUYMD       = "zrnsisuukouhyouymd";
    public static final String ZRNTORIKOMIYOUSISUU      = "zrntorikomiyousisuu";
    public static final String ZRNSISUUCALCKIJYUNYMD    = "zrnsisuucalckijyunymd";
    public static final String ZRNYOBIN11X40            = "zrnyobin11x40";
    public static final String ZRNYOBIV71               = "zrnyobiv71";

    private final PKZT_SisuuRendouRn primaryKey;

    public GenZT_SisuuRendouRn() {
        primaryKey = new PKZT_SisuuRendouRn();
    }

    public GenZT_SisuuRendouRn(String pZrntorikomiyousisuukbn, String pZrnsisuukouhyouymd) {
        primaryKey = new PKZT_SisuuRendouRn(pZrntorikomiyousisuukbn, pZrnsisuukouhyouymd);
    }

    @Transient
    @Override
    public PKZT_SisuuRendouRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SisuuRendouRn> getMetaClass() {
        return QZT_SisuuRendouRn.class;
    }

    @Id
    @Column(name=GenZT_SisuuRendouRn.ZRNTORIKOMIYOUSISUUKBN)
    public String getZrntorikomiyousisuukbn() {
        return getPrimaryKey().getZrntorikomiyousisuukbn();
    }

    public void setZrntorikomiyousisuukbn(String pZrntorikomiyousisuukbn) {
        getPrimaryKey().setZrntorikomiyousisuukbn(pZrntorikomiyousisuukbn);
    }

    @Id
    @Column(name=GenZT_SisuuRendouRn.ZRNSISUUKOUHYOUYMD)
    public String getZrnsisuukouhyouymd() {
        return getPrimaryKey().getZrnsisuukouhyouymd();
    }

    public void setZrnsisuukouhyouymd(String pZrnsisuukouhyouymd) {
        getPrimaryKey().setZrnsisuukouhyouymd(pZrnsisuukouhyouymd);
    }

    private Double zrntorikomiyousisuu;

    @Column(name=GenZT_SisuuRendouRn.ZRNTORIKOMIYOUSISUU)
    public Double getZrntorikomiyousisuu() {
        return zrntorikomiyousisuu;
    }

    public void setZrntorikomiyousisuu(Double pZrntorikomiyousisuu) {
        zrntorikomiyousisuu = pZrntorikomiyousisuu;
    }

    private String zrnsisuucalckijyunymd;

    @Column(name=GenZT_SisuuRendouRn.ZRNSISUUCALCKIJYUNYMD)
    public String getZrnsisuucalckijyunymd() {
        return zrnsisuucalckijyunymd;
    }

    public void setZrnsisuucalckijyunymd(String pZrnsisuucalckijyunymd) {
        zrnsisuucalckijyunymd = pZrnsisuucalckijyunymd;
    }

    private Double zrnyobin11x40;

    @Column(name=GenZT_SisuuRendouRn.ZRNYOBIN11X40)
    public Double getZrnyobin11x40() {
        return zrnyobin11x40;
    }

    public void setZrnyobin11x40(Double pZrnyobin11x40) {
        zrnyobin11x40 = pZrnyobin11x40;
    }

    private String zrnyobiv71;

    @Column(name=GenZT_SisuuRendouRn.ZRNYOBIV71)
    public String getZrnyobiv71() {
        return zrnyobiv71;
    }

    public void setZrnyobiv71(String pZrnyobiv71) {
        zrnyobiv71 = pZrnyobiv71;
    }
}