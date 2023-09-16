package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_DrtenMisyuSkInfoDataRn;
import yuyu.def.db.id.PKZT_DrtenMisyuSkInfoDataRn;
import yuyu.def.db.meta.GenQZT_DrtenMisyuSkInfoDataRn;
import yuyu.def.db.meta.QZT_DrtenMisyuSkInfoDataRn;

/**
 * 代理店未収・失効情報連動データＦテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_DrtenMisyuSkInfoDataRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DrtenMisyuSkInfoDataRn}</td><td colspan="3">代理店未収・失効情報連動データＦテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_DrtenMisyuSkInfoDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsydrtencd zrnbsydrtencd}</td><td>（連携用）募集代理店コード</td><td align="center">{@link PKZT_DrtenMisyuSkInfoDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnsyugknjkyksynm zrnhnsyugknjkyksynm}</td><td>（連携用）編集後漢字契約者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknjhhknmei zrnknjhhknmei}</td><td>（連携用）漢字被保険者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykjyutikbn zrnkykjyutikbn}</td><td>（連携用）契約状態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsinkihontikucd zrntsinkihontikucd}</td><td>（連携用）通信先基本地区コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanjitsinkaiadr zrnkanjitsinkaiadr}</td><td>（連携用）漢字通信先下位住所</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsintelno zrntsintelno}</td><td>（連携用）通信先電話番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2tsintelno zrndai2tsintelno}</td><td>（連携用）第２通信先電話番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaebankcd zrnkzhurikaebankcd}</td><td>（連携用）口座振替銀行番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaesitencd zrnkzhurikaesitencd}</td><td>（連携用）口座振替支店番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaeyokinkbn zrnkzhurikaeyokinkbn}</td><td>（連携用）口座振替預金種目区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaekouzano zrnkzhurikaekouzano}</td><td>（連携用）口座振替口座番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaemeiginm zrnkzhurikaemeiginm}</td><td>（連携用）口座振替名義人名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv6x5 zrnyobiv6x5}</td><td>（連携用）予備項目Ｖ６＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrn1kaip zrn1kaip}</td><td>（連携用）１回分保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnexthurikaeyoteigk zrnnexthurikaeyoteigk}</td><td>（連携用）次回振替予定金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhrkyykknmnryymd zrnhrkyykknmnryymd}</td><td>（連携用）払込猶予期間満了日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskymd zrnskymd}</td><td>（連携用）失効年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjhurikstkkahikbn zrnjhurikstkkahikbn}</td><td>（連携用）自動振替貸付可否区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhukkatumoskahikbn zrnhukkatumoskahikbn}</td><td>（連携用）復活申込可否区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnttdkkigenymd zrnttdkkigenymd}</td><td>（連携用）手続き期限年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhukkatukanoukknmnryymd zrnhukkatukanoukknmnryymd}</td><td>（連携用）復活可能期間満了年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikatukisuu3keta zrnkeikatukisuu3keta}</td><td>（連携用）経過月数（３桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmisyuuhasseiym zrnmisyuuhasseiym}</td><td>（連携用）未収発生年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmisyuujiyuu zrnmisyuujiyuu}</td><td>（連携用）未収事由</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhanteiymd zrnhanteiymd}</td><td>（連携用）判定年月日</td><td align="center">{@link PKZT_DrtenMisyuSkInfoDataRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobin11 zrnyobin11}</td><td>（連携用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x2 zrnyobin11x2}</td><td>（連携用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnexthurikaeymd zrnnexthurikaeymd}</td><td>（連携用）次回振替年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8x3 zrnyobiv8x3}</td><td>（連携用）予備項目Ｖ８＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnikkatubaraikbn zrnikkatubaraikbn}</td><td>（連携用）一括払区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnikkatubaraikaisuu zrnikkatubaraikaisuu}</td><td>（連携用）一括払回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv55 zrnyobiv55}</td><td>（連携用）予備項目Ｖ５５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_DrtenMisyuSkInfoDataRn
 * @see     PKZT_DrtenMisyuSkInfoDataRn
 * @see     QZT_DrtenMisyuSkInfoDataRn
 * @see     GenQZT_DrtenMisyuSkInfoDataRn
 */
@MappedSuperclass
@Table(name=GenZT_DrtenMisyuSkInfoDataRn.TABLE_NAME)
@IdClass(value=PKZT_DrtenMisyuSkInfoDataRn.class)
public abstract class GenZT_DrtenMisyuSkInfoDataRn extends AbstractExDBEntityForZDB<ZT_DrtenMisyuSkInfoDataRn, PKZT_DrtenMisyuSkInfoDataRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DrtenMisyuSkInfoDataRn";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNBSYDRTENCD            = "zrnbsydrtencd";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNHNSYUGKNJKYKSYNM      = "zrnhnsyugknjkyksynm";
    public static final String ZRNKNJHHKNMEI            = "zrnknjhhknmei";
    public static final String ZRNKYKJYUTIKBN           = "zrnkykjyutikbn";
    public static final String ZRNTSINKIHONTIKUCD       = "zrntsinkihontikucd";
    public static final String ZRNKANJITSINKAIADR       = "zrnkanjitsinkaiadr";
    public static final String ZRNTSINTELNO             = "zrntsintelno";
    public static final String ZRNDAI2TSINTELNO         = "zrndai2tsintelno";
    public static final String ZRNKZHURIKAEBANKCD       = "zrnkzhurikaebankcd";
    public static final String ZRNKZHURIKAESITENCD      = "zrnkzhurikaesitencd";
    public static final String ZRNKZHURIKAEYOKINKBN     = "zrnkzhurikaeyokinkbn";
    public static final String ZRNKZHURIKAEKOUZANO      = "zrnkzhurikaekouzano";
    public static final String ZRNKZHURIKAEMEIGINM      = "zrnkzhurikaemeiginm";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNYOBIV6X5              = "zrnyobiv6x5";
    public static final String ZRN1KAIP                 = "zrn1kaip";
    public static final String ZRNNEXTHURIKAEYOTEIGK    = "zrnnexthurikaeyoteigk";
    public static final String ZRNHRKYYKKNMNRYYMD       = "zrnhrkyykknmnryymd";
    public static final String ZRNSKYMD                 = "zrnskymd";
    public static final String ZRNJHURIKSTKKAHIKBN      = "zrnjhurikstkkahikbn";
    public static final String ZRNHUKKATUMOSKAHIKBN     = "zrnhukkatumoskahikbn";
    public static final String ZRNTTDKKIGENYMD          = "zrnttdkkigenymd";
    public static final String ZRNHUKKATUKANOUKKNMNRYYMD = "zrnhukkatukanoukknmnryymd";
    public static final String ZRNKEIKATUKISUU3KETA     = "zrnkeikatukisuu3keta";
    public static final String ZRNMISYUUHASSEIYM        = "zrnmisyuuhasseiym";
    public static final String ZRNMISYUUJIYUU           = "zrnmisyuujiyuu";
    public static final String ZRNHANTEIYMD             = "zrnhanteiymd";
    public static final String ZRNYOBIN11               = "zrnyobin11";
    public static final String ZRNYOBIN11X2             = "zrnyobin11x2";
    public static final String ZRNNEXTHURIKAEYMD        = "zrnnexthurikaeymd";
    public static final String ZRNYOBIV8X3              = "zrnyobiv8x3";
    public static final String ZRNIKKATUBARAIKBN        = "zrnikkatubaraikbn";
    public static final String ZRNIKKATUBARAIKAISUU     = "zrnikkatubaraikaisuu";
    public static final String ZRNYOBIV55               = "zrnyobiv55";

    private final PKZT_DrtenMisyuSkInfoDataRn primaryKey;

    public GenZT_DrtenMisyuSkInfoDataRn() {
        primaryKey = new PKZT_DrtenMisyuSkInfoDataRn();
    }

    public GenZT_DrtenMisyuSkInfoDataRn(
        String pZrnsyono,
        String pZrnbsydrtencd,
        String pZrnhanteiymd
    ) {
        primaryKey = new PKZT_DrtenMisyuSkInfoDataRn(
            pZrnsyono,
            pZrnbsydrtencd,
            pZrnhanteiymd
        );
    }

    @Transient
    @Override
    public PKZT_DrtenMisyuSkInfoDataRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DrtenMisyuSkInfoDataRn> getMetaClass() {
        return QZT_DrtenMisyuSkInfoDataRn.class;
    }

    @Id
    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    @Id
    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNBSYDRTENCD)
    public String getZrnbsydrtencd() {
        return getPrimaryKey().getZrnbsydrtencd();
    }

    public void setZrnbsydrtencd(String pZrnbsydrtencd) {
        getPrimaryKey().setZrnbsydrtencd(pZrnbsydrtencd);
    }

    private String zrnkykymd;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnhnsyugknjkyksynm;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNHNSYUGKNJKYKSYNM)
    public String getZrnhnsyugknjkyksynm() {
        return zrnhnsyugknjkyksynm;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnsyugknjkyksynm(String pZrnhnsyugknjkyksynm) {
        zrnhnsyugknjkyksynm = pZrnhnsyugknjkyksynm;
    }

    private String zrnknjhhknmei;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNKNJHHKNMEI)
    public String getZrnknjhhknmei() {
        return zrnknjhhknmei;
    }

    @DataConvert("toMultiByte")
    public void setZrnknjhhknmei(String pZrnknjhhknmei) {
        zrnknjhhknmei = pZrnknjhhknmei;
    }

    private String zrnkykjyutikbn;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNKYKJYUTIKBN)
    public String getZrnkykjyutikbn() {
        return zrnkykjyutikbn;
    }

    public void setZrnkykjyutikbn(String pZrnkykjyutikbn) {
        zrnkykjyutikbn = pZrnkykjyutikbn;
    }

    private String zrntsinkihontikucd;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNTSINKIHONTIKUCD)
    public String getZrntsinkihontikucd() {
        return zrntsinkihontikucd;
    }

    public void setZrntsinkihontikucd(String pZrntsinkihontikucd) {
        zrntsinkihontikucd = pZrntsinkihontikucd;
    }

    private String zrnkanjitsinkaiadr;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNKANJITSINKAIADR)
    public String getZrnkanjitsinkaiadr() {
        return zrnkanjitsinkaiadr;
    }

    @DataConvert("toMultiByte")
    public void setZrnkanjitsinkaiadr(String pZrnkanjitsinkaiadr) {
        zrnkanjitsinkaiadr = pZrnkanjitsinkaiadr;
    }

    private String zrntsintelno;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNTSINTELNO)
    public String getZrntsintelno() {
        return zrntsintelno;
    }

    public void setZrntsintelno(String pZrntsintelno) {
        zrntsintelno = pZrntsintelno;
    }

    private String zrndai2tsintelno;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNDAI2TSINTELNO)
    public String getZrndai2tsintelno() {
        return zrndai2tsintelno;
    }

    public void setZrndai2tsintelno(String pZrndai2tsintelno) {
        zrndai2tsintelno = pZrndai2tsintelno;
    }

    private String zrnkzhurikaebankcd;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNKZHURIKAEBANKCD)
    public String getZrnkzhurikaebankcd() {
        return zrnkzhurikaebankcd;
    }

    public void setZrnkzhurikaebankcd(String pZrnkzhurikaebankcd) {
        zrnkzhurikaebankcd = pZrnkzhurikaebankcd;
    }

    private String zrnkzhurikaesitencd;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNKZHURIKAESITENCD)
    public String getZrnkzhurikaesitencd() {
        return zrnkzhurikaesitencd;
    }

    public void setZrnkzhurikaesitencd(String pZrnkzhurikaesitencd) {
        zrnkzhurikaesitencd = pZrnkzhurikaesitencd;
    }

    private String zrnkzhurikaeyokinkbn;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNKZHURIKAEYOKINKBN)
    public String getZrnkzhurikaeyokinkbn() {
        return zrnkzhurikaeyokinkbn;
    }

    public void setZrnkzhurikaeyokinkbn(String pZrnkzhurikaeyokinkbn) {
        zrnkzhurikaeyokinkbn = pZrnkzhurikaeyokinkbn;
    }

    private String zrnkzhurikaekouzano;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNKZHURIKAEKOUZANO)
    public String getZrnkzhurikaekouzano() {
        return zrnkzhurikaekouzano;
    }

    public void setZrnkzhurikaekouzano(String pZrnkzhurikaekouzano) {
        zrnkzhurikaekouzano = pZrnkzhurikaekouzano;
    }

    private String zrnkzhurikaemeiginm;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNKZHURIKAEMEIGINM)
    public String getZrnkzhurikaemeiginm() {
        return zrnkzhurikaemeiginm;
    }

    public void setZrnkzhurikaemeiginm(String pZrnkzhurikaemeiginm) {
        zrnkzhurikaemeiginm = pZrnkzhurikaemeiginm;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private String zrnyobiv6x5;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNYOBIV6X5)
    public String getZrnyobiv6x5() {
        return zrnyobiv6x5;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnyobiv6x5(String pZrnyobiv6x5) {
        zrnyobiv6x5 = pZrnyobiv6x5;
    }

    private Long zrn1kaip;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRN1KAIP)
    public Long getZrn1kaip() {
        return zrn1kaip;
    }

    public void setZrn1kaip(Long pZrn1kaip) {
        zrn1kaip = pZrn1kaip;
    }

    private Long zrnnexthurikaeyoteigk;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNNEXTHURIKAEYOTEIGK)
    public Long getZrnnexthurikaeyoteigk() {
        return zrnnexthurikaeyoteigk;
    }

    public void setZrnnexthurikaeyoteigk(Long pZrnnexthurikaeyoteigk) {
        zrnnexthurikaeyoteigk = pZrnnexthurikaeyoteigk;
    }

    private String zrnhrkyykknmnryymd;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNHRKYYKKNMNRYYMD)
    public String getZrnhrkyykknmnryymd() {
        return zrnhrkyykknmnryymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnhrkyykknmnryymd(String pZrnhrkyykknmnryymd) {
        zrnhrkyykknmnryymd = pZrnhrkyykknmnryymd;
    }

    private String zrnskymd;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNSKYMD)
    public String getZrnskymd() {
        return zrnskymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnskymd(String pZrnskymd) {
        zrnskymd = pZrnskymd;
    }

    private String zrnjhurikstkkahikbn;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNJHURIKSTKKAHIKBN)
    public String getZrnjhurikstkkahikbn() {
        return zrnjhurikstkkahikbn;
    }

    public void setZrnjhurikstkkahikbn(String pZrnjhurikstkkahikbn) {
        zrnjhurikstkkahikbn = pZrnjhurikstkkahikbn;
    }

    private String zrnhukkatumoskahikbn;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNHUKKATUMOSKAHIKBN)
    public String getZrnhukkatumoskahikbn() {
        return zrnhukkatumoskahikbn;
    }

    public void setZrnhukkatumoskahikbn(String pZrnhukkatumoskahikbn) {
        zrnhukkatumoskahikbn = pZrnhukkatumoskahikbn;
    }

    private String zrnttdkkigenymd;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNTTDKKIGENYMD)
    public String getZrnttdkkigenymd() {
        return zrnttdkkigenymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnttdkkigenymd(String pZrnttdkkigenymd) {
        zrnttdkkigenymd = pZrnttdkkigenymd;
    }

    private String zrnhukkatukanoukknmnryymd;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNHUKKATUKANOUKKNMNRYYMD)
    public String getZrnhukkatukanoukknmnryymd() {
        return zrnhukkatukanoukknmnryymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnhukkatukanoukknmnryymd(String pZrnhukkatukanoukknmnryymd) {
        zrnhukkatukanoukknmnryymd = pZrnhukkatukanoukknmnryymd;
    }

    private String zrnkeikatukisuu3keta;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNKEIKATUKISUU3KETA)
    public String getZrnkeikatukisuu3keta() {
        return zrnkeikatukisuu3keta;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnkeikatukisuu3keta(String pZrnkeikatukisuu3keta) {
        zrnkeikatukisuu3keta = pZrnkeikatukisuu3keta;
    }

    private String zrnmisyuuhasseiym;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNMISYUUHASSEIYM)
    public String getZrnmisyuuhasseiym() {
        return zrnmisyuuhasseiym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnmisyuuhasseiym(String pZrnmisyuuhasseiym) {
        zrnmisyuuhasseiym = pZrnmisyuuhasseiym;
    }

    private String zrnmisyuujiyuu;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNMISYUUJIYUU)
    public String getZrnmisyuujiyuu() {
        return zrnmisyuujiyuu;
    }

    public void setZrnmisyuujiyuu(String pZrnmisyuujiyuu) {
        zrnmisyuujiyuu = pZrnmisyuujiyuu;
    }

    @Id
    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNHANTEIYMD)
    public String getZrnhanteiymd() {
        return getPrimaryKey().getZrnhanteiymd();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnhanteiymd(String pZrnhanteiymd) {
        getPrimaryKey().setZrnhanteiymd(pZrnhanteiymd);
    }

    private Long zrnyobin11;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNYOBIN11)
    public Long getZrnyobin11() {
        return zrnyobin11;
    }

    public void setZrnyobin11(Long pZrnyobin11) {
        zrnyobin11 = pZrnyobin11;
    }

    private Long zrnyobin11x2;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNYOBIN11X2)
    public Long getZrnyobin11x2() {
        return zrnyobin11x2;
    }

    public void setZrnyobin11x2(Long pZrnyobin11x2) {
        zrnyobin11x2 = pZrnyobin11x2;
    }

    private String zrnnexthurikaeymd;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNNEXTHURIKAEYMD)
    public String getZrnnexthurikaeymd() {
        return zrnnexthurikaeymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnnexthurikaeymd(String pZrnnexthurikaeymd) {
        zrnnexthurikaeymd = pZrnnexthurikaeymd;
    }

    private String zrnyobiv8x3;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNYOBIV8X3)
    public String getZrnyobiv8x3() {
        return zrnyobiv8x3;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnyobiv8x3(String pZrnyobiv8x3) {
        zrnyobiv8x3 = pZrnyobiv8x3;
    }

    private String zrnikkatubaraikbn;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNIKKATUBARAIKBN)
    public String getZrnikkatubaraikbn() {
        return zrnikkatubaraikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnikkatubaraikbn(String pZrnikkatubaraikbn) {
        zrnikkatubaraikbn = pZrnikkatubaraikbn;
    }

    private String zrnikkatubaraikaisuu;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNIKKATUBARAIKAISUU)
    public String getZrnikkatubaraikaisuu() {
        return zrnikkatubaraikaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnikkatubaraikaisuu(String pZrnikkatubaraikaisuu) {
        zrnikkatubaraikaisuu = pZrnikkatubaraikaisuu;
    }

    private String zrnyobiv55;

    @Column(name=GenZT_DrtenMisyuSkInfoDataRn.ZRNYOBIV55)
    public String getZrnyobiv55() {
        return zrnyobiv55;
    }

    public void setZrnyobiv55(String pZrnyobiv55) {
        zrnyobiv55 = pZrnyobiv55;
    }
}