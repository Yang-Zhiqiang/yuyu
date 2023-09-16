package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_TokuteiKankeiHoujinRn;
import yuyu.def.db.id.PKZT_TokuteiKankeiHoujinRn;
import yuyu.def.db.meta.GenQZT_TokuteiKankeiHoujinRn;
import yuyu.def.db.meta.QZT_TokuteiKankeiHoujinRn;

/**
 * 特定関係法人マスタテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_TokuteiKankeiHoujinRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TokuteiKankeiHoujinRn}</td><td colspan="3">特定関係法人マスタテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnkinyuukikancd zrnkinyuukikancd}</td><td>（連携用）金融機関コード</td><td align="center">{@link PKZT_TokuteiKankeiHoujinRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmeisaibangou zrnmeisaibangou}</td><td>（連携用）明細番号</td><td align="center">{@link PKZT_TokuteiKankeiHoujinRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmarukinhyouji zrnmarukinhyouji}</td><td>（連携用）マル金表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkhjnkjdrtennm zrntkhjnkjdrtennm}</td><td>（連携用）特定関係法人漢字代理店名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitenbetutuuban zrndairitenbetutuuban}</td><td>（連携用）代理店別通番</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanjitokuteikankeinm zrnkanjitokuteikankeinm}</td><td>（連携用）漢字特定関係法人名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuteikankeihoujinnm zrntokuteikankeihoujinnm}</td><td>（連携用）特定関係法人名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkousinymd zrnkousinymd}</td><td>（連携用）更新年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv79 zrnyobiv79}</td><td>（連携用）予備項目Ｖ７９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_TokuteiKankeiHoujinRn
 * @see     PKZT_TokuteiKankeiHoujinRn
 * @see     QZT_TokuteiKankeiHoujinRn
 * @see     GenQZT_TokuteiKankeiHoujinRn
 */
@MappedSuperclass
@Table(name=GenZT_TokuteiKankeiHoujinRn.TABLE_NAME)
@IdClass(value=PKZT_TokuteiKankeiHoujinRn.class)
public abstract class GenZT_TokuteiKankeiHoujinRn extends AbstractExDBEntityForZDB<ZT_TokuteiKankeiHoujinRn, PKZT_TokuteiKankeiHoujinRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_TokuteiKankeiHoujinRn";
    public static final String ZRNKINYUUKIKANCD         = "zrnkinyuukikancd";
    public static final String ZRNMEISAIBANGOU          = "zrnmeisaibangou";
    public static final String ZRNMARUKINHYOUJI         = "zrnmarukinhyouji";
    public static final String ZRNTKHJNKJDRTENNM        = "zrntkhjnkjdrtennm";
    public static final String ZRNDAIRITENBETUTUUBAN    = "zrndairitenbetutuuban";
    public static final String ZRNKANJITOKUTEIKANKEINM  = "zrnkanjitokuteikankeinm";
    public static final String ZRNTOKUTEIKANKEIHOUJINNM = "zrntokuteikankeihoujinnm";
    public static final String ZRNKOUSINYMD             = "zrnkousinymd";
    public static final String ZRNYOBIV79               = "zrnyobiv79";

    private final PKZT_TokuteiKankeiHoujinRn primaryKey;

    public GenZT_TokuteiKankeiHoujinRn() {
        primaryKey = new PKZT_TokuteiKankeiHoujinRn();
    }

    public GenZT_TokuteiKankeiHoujinRn(String pZrnkinyuukikancd, String pZrnmeisaibangou) {
        primaryKey = new PKZT_TokuteiKankeiHoujinRn(pZrnkinyuukikancd, pZrnmeisaibangou);
    }

    @Transient
    @Override
    public PKZT_TokuteiKankeiHoujinRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_TokuteiKankeiHoujinRn> getMetaClass() {
        return QZT_TokuteiKankeiHoujinRn.class;
    }

    @Id
    @Column(name=GenZT_TokuteiKankeiHoujinRn.ZRNKINYUUKIKANCD)
    public String getZrnkinyuukikancd() {
        return getPrimaryKey().getZrnkinyuukikancd();
    }

    public void setZrnkinyuukikancd(String pZrnkinyuukikancd) {
        getPrimaryKey().setZrnkinyuukikancd(pZrnkinyuukikancd);
    }

    @Id
    @Column(name=GenZT_TokuteiKankeiHoujinRn.ZRNMEISAIBANGOU)
    public String getZrnmeisaibangou() {
        return getPrimaryKey().getZrnmeisaibangou();
    }

    public void setZrnmeisaibangou(String pZrnmeisaibangou) {
        getPrimaryKey().setZrnmeisaibangou(pZrnmeisaibangou);
    }

    private String zrnmarukinhyouji;

    @Column(name=GenZT_TokuteiKankeiHoujinRn.ZRNMARUKINHYOUJI)
    public String getZrnmarukinhyouji() {
        return zrnmarukinhyouji;
    }

    public void setZrnmarukinhyouji(String pZrnmarukinhyouji) {
        zrnmarukinhyouji = pZrnmarukinhyouji;
    }

    private String zrntkhjnkjdrtennm;

    @Column(name=GenZT_TokuteiKankeiHoujinRn.ZRNTKHJNKJDRTENNM)
    public String getZrntkhjnkjdrtennm() {
        return zrntkhjnkjdrtennm;
    }

    @DataConvert("toMultiByte")
    public void setZrntkhjnkjdrtennm(String pZrntkhjnkjdrtennm) {
        zrntkhjnkjdrtennm = pZrntkhjnkjdrtennm;
    }

    private String zrndairitenbetutuuban;

    @Column(name=GenZT_TokuteiKankeiHoujinRn.ZRNDAIRITENBETUTUUBAN)
    public String getZrndairitenbetutuuban() {
        return zrndairitenbetutuuban;
    }

    public void setZrndairitenbetutuuban(String pZrndairitenbetutuuban) {
        zrndairitenbetutuuban = pZrndairitenbetutuuban;
    }

    private String zrnkanjitokuteikankeinm;

    @Column(name=GenZT_TokuteiKankeiHoujinRn.ZRNKANJITOKUTEIKANKEINM)
    public String getZrnkanjitokuteikankeinm() {
        return zrnkanjitokuteikankeinm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkanjitokuteikankeinm(String pZrnkanjitokuteikankeinm) {
        zrnkanjitokuteikankeinm = pZrnkanjitokuteikankeinm;
    }

    private String zrntokuteikankeihoujinnm;

    @Column(name=GenZT_TokuteiKankeiHoujinRn.ZRNTOKUTEIKANKEIHOUJINNM)
    public String getZrntokuteikankeihoujinnm() {
        return zrntokuteikankeihoujinnm;
    }

    public void setZrntokuteikankeihoujinnm(String pZrntokuteikankeihoujinnm) {
        zrntokuteikankeihoujinnm = pZrntokuteikankeihoujinnm;
    }

    private String zrnkousinymd;

    @Column(name=GenZT_TokuteiKankeiHoujinRn.ZRNKOUSINYMD)
    public String getZrnkousinymd() {
        return zrnkousinymd;
    }

    public void setZrnkousinymd(String pZrnkousinymd) {
        zrnkousinymd = pZrnkousinymd;
    }

    private String zrnyobiv79;

    @Column(name=GenZT_TokuteiKankeiHoujinRn.ZRNYOBIV79)
    public String getZrnyobiv79() {
        return zrnyobiv79;
    }

    public void setZrnyobiv79(String pZrnyobiv79) {
        zrnyobiv79 = pZrnyobiv79;
    }
}