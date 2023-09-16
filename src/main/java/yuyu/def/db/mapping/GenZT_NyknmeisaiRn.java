package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_NyknmeisaiRn;
import yuyu.def.db.id.PKZT_NyknmeisaiRn;
import yuyu.def.db.meta.GenQZT_NyknmeisaiRn;
import yuyu.def.db.meta.QZT_NyknmeisaiRn;

/**
 * 入出金明細テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_NyknmeisaiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_NyknmeisaiRn}</td><td colspan="3">入出金明細テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrndatakbn1 zrndatakbn1}</td><td>（連携用）データ区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyubetucd zrnsyubetucd}</td><td>（連携用）種別コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncdkbn zrncdkbn}</td><td>（連携用）コード区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsakuseiymd6keta zrnsakuseiymd6keta}</td><td>（連携用）作成日６桁</td><td align="center">{@link PKZT_NyknmeisaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknjyymdfrom6keta zrnknjyymdfrom6keta}</td><td>（連携用）勘定日（自）６桁</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknjyymdto6keta zrnknjyymdto6keta}</td><td>（連携用）勘定日（至）６桁</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbankcd zrnbankcd}</td><td>（連携用）銀行番号</td><td align="center">{@link PKZT_NyknmeisaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbanknmkn zrnbanknmkn}</td><td>（連携用）銀行名（カナ）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshitencd zrnshitencd}</td><td>（連携用）支店番号</td><td align="center">{@link PKZT_NyknmeisaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsitennmkn zrnsitennmkn}</td><td>（連携用）支店名（カナ）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv3 zrnyobiv3}</td><td>（連携用）予備項目Ｖ３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyokinkbn zrnyokinkbn}</td><td>（連携用）預金種目区分</td><td align="center">{@link PKZT_NyknmeisaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouzano zrnkouzano}</td><td>（連携用）口座番号</td><td align="center">{@link PKZT_NyknmeisaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkznmkn zrnkznmkn}</td><td>（連携用）口座名（カナ）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkasikosikbn zrnkasikosikbn}</td><td>（連携用）貸越区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuutyousysykbn zrntuutyousysykbn}</td><td>（連携用）通帳・証書区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrhkmaezndk zrntrhkmaezndk}</td><td>（連携用）取引前残高</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv63 zrnyobiv63}</td><td>（連携用）予備項目Ｖ６３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrenno8 zrnrenno8}</td><td>（連携用）連番８桁</td><td align="center">{@link PKZT_NyknmeisaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakbn2 zrndatakbn2}</td><td>（連携用）データ区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoukaino zrnsyoukaino}</td><td>（連携用）照会番号</td><td align="center">{@link PKZT_NyknmeisaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknjyymd6keta zrnknjyymd6keta}</td><td>（連携用）勘定日６桁</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnazkrhrdsymd6keta zrnazkrhrdsymd6keta}</td><td>（連携用）預入・払出日６桁</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrniribaraikbn zrniribaraikbn}</td><td>（連携用）入払区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrhkkbn zrntrhkkbn}</td><td>（連携用）取引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrhkgk zrntrhkgk}</td><td>（連携用）取引金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntatenkengk zrntatenkengk}</td><td>（連携用）うち他店券金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkknteijiymd6keta zrnkknteijiymd6keta}</td><td>（連携用）交換呈示日６桁</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhwtrhnknymd6keta zrnhwtrhnknymd6keta}</td><td>（連携用）不渡返還日６桁</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntgtkgtkbn zrntgtkgtkbn}</td><td>（連携用）手形・小切手区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntgtkgtno zrntgtkgtno}</td><td>（連携用）手形・小切手番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnryoutenno zrnryoutenno}</td><td>（連携用）僚店番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkmirnincd zrnhrkmirnincd}</td><td>（連携用）振込依頼人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkmirninnm zrnhrkmirninnm}</td><td>（連携用）振込依頼人名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimukebanknmkn zrnsimukebanknmkn}</td><td>（連携用）仕向銀行名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimuketennmkn zrnsimuketennmkn}</td><td>（連携用）仕向店名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyounaiyou zrntekiyounaiyou}</td><td>（連携用）摘要内容</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnediinfo zrnediinfo}</td><td>（連携用）EDI情報</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1 zrnyobiv1}</td><td>（連携用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_NyknmeisaiRn
 * @see     PKZT_NyknmeisaiRn
 * @see     QZT_NyknmeisaiRn
 * @see     GenQZT_NyknmeisaiRn
 */
@MappedSuperclass
@Table(name=GenZT_NyknmeisaiRn.TABLE_NAME)
@IdClass(value=PKZT_NyknmeisaiRn.class)
public abstract class GenZT_NyknmeisaiRn extends AbstractExDBEntityForZDB<ZT_NyknmeisaiRn, PKZT_NyknmeisaiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_NyknmeisaiRn";
    public static final String ZRNDATAKBN1              = "zrndatakbn1";
    public static final String ZRNSYUBETUCD             = "zrnsyubetucd";
    public static final String ZRNCDKBN                 = "zrncdkbn";
    public static final String ZRNSAKUSEIYMD6KETA       = "zrnsakuseiymd6keta";
    public static final String ZRNKNJYYMDFROM6KETA      = "zrnknjyymdfrom6keta";
    public static final String ZRNKNJYYMDTO6KETA        = "zrnknjyymdto6keta";
    public static final String ZRNBANKCD                = "zrnbankcd";
    public static final String ZRNBANKNMKN              = "zrnbanknmkn";
    public static final String ZRNSHITENCD              = "zrnshitencd";
    public static final String ZRNSITENNMKN             = "zrnsitennmkn";
    public static final String ZRNYOBIV3                = "zrnyobiv3";
    public static final String ZRNYOKINKBN              = "zrnyokinkbn";
    public static final String ZRNKOUZANO               = "zrnkouzano";
    public static final String ZRNKZNMKN                = "zrnkznmkn";
    public static final String ZRNKASIKOSIKBN           = "zrnkasikosikbn";
    public static final String ZRNTUUTYOUSYSYKBN        = "zrntuutyousysykbn";
    public static final String ZRNTRHKMAEZNDK           = "zrntrhkmaezndk";
    public static final String ZRNYOBIV63               = "zrnyobiv63";
    public static final String ZRNRENNO8                = "zrnrenno8";
    public static final String ZRNDATAKBN2              = "zrndatakbn2";
    public static final String ZRNSYOUKAINO             = "zrnsyoukaino";
    public static final String ZRNKNJYYMD6KETA          = "zrnknjyymd6keta";
    public static final String ZRNAZKRHRDSYMD6KETA      = "zrnazkrhrdsymd6keta";
    public static final String ZRNIRIBARAIKBN           = "zrniribaraikbn";
    public static final String ZRNTRHKKBN               = "zrntrhkkbn";
    public static final String ZRNTRHKGK                = "zrntrhkgk";
    public static final String ZRNTATENKENGK            = "zrntatenkengk";
    public static final String ZRNKKNTEIJIYMD6KETA      = "zrnkknteijiymd6keta";
    public static final String ZRNHWTRHNKNYMD6KETA      = "zrnhwtrhnknymd6keta";
    public static final String ZRNTGTKGTKBN             = "zrntgtkgtkbn";
    public static final String ZRNTGTKGTNO              = "zrntgtkgtno";
    public static final String ZRNRYOUTENNO             = "zrnryoutenno";
    public static final String ZRNHRKMIRNINCD           = "zrnhrkmirnincd";
    public static final String ZRNHRKMIRNINNM           = "zrnhrkmirninnm";
    public static final String ZRNSIMUKEBANKNMKN        = "zrnsimukebanknmkn";
    public static final String ZRNSIMUKETENNMKN         = "zrnsimuketennmkn";
    public static final String ZRNTEKIYOUNAIYOU         = "zrntekiyounaiyou";
    public static final String ZRNEDIINFO               = "zrnediinfo";
    public static final String ZRNYOBIV1                = "zrnyobiv1";

    private final PKZT_NyknmeisaiRn primaryKey;

    public GenZT_NyknmeisaiRn() {
        primaryKey = new PKZT_NyknmeisaiRn();
    }

    public GenZT_NyknmeisaiRn(
        String pZrnsakuseiymd6keta,
        String pZrnbankcd,
        String pZrnshitencd,
        String pZrnyokinkbn,
        String pZrnkouzano,
        String pZrnsyoukaino,
        String pZrnrenno8
    ) {
        primaryKey = new PKZT_NyknmeisaiRn(
            pZrnsakuseiymd6keta,
            pZrnbankcd,
            pZrnshitencd,
            pZrnyokinkbn,
            pZrnkouzano,
            pZrnsyoukaino,
            pZrnrenno8
        );
    }

    @Transient
    @Override
    public PKZT_NyknmeisaiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_NyknmeisaiRn> getMetaClass() {
        return QZT_NyknmeisaiRn.class;
    }

    private String zrndatakbn1;

    @Column(name=GenZT_NyknmeisaiRn.ZRNDATAKBN1)
    public String getZrndatakbn1() {
        return zrndatakbn1;
    }

    public void setZrndatakbn1(String pZrndatakbn1) {
        zrndatakbn1 = pZrndatakbn1;
    }

    private String zrnsyubetucd;

    @Column(name=GenZT_NyknmeisaiRn.ZRNSYUBETUCD)
    public String getZrnsyubetucd() {
        return zrnsyubetucd;
    }

    public void setZrnsyubetucd(String pZrnsyubetucd) {
        zrnsyubetucd = pZrnsyubetucd;
    }

    private String zrncdkbn;

    @Column(name=GenZT_NyknmeisaiRn.ZRNCDKBN)
    public String getZrncdkbn() {
        return zrncdkbn;
    }

    public void setZrncdkbn(String pZrncdkbn) {
        zrncdkbn = pZrncdkbn;
    }

    @Id
    @Column(name=GenZT_NyknmeisaiRn.ZRNSAKUSEIYMD6KETA)
    public String getZrnsakuseiymd6keta() {
        return getPrimaryKey().getZrnsakuseiymd6keta();
    }

    public void setZrnsakuseiymd6keta(String pZrnsakuseiymd6keta) {
        getPrimaryKey().setZrnsakuseiymd6keta(pZrnsakuseiymd6keta);
    }

    private String zrnknjyymdfrom6keta;

    @Column(name=GenZT_NyknmeisaiRn.ZRNKNJYYMDFROM6KETA)
    public String getZrnknjyymdfrom6keta() {
        return zrnknjyymdfrom6keta;
    }

    public void setZrnknjyymdfrom6keta(String pZrnknjyymdfrom6keta) {
        zrnknjyymdfrom6keta = pZrnknjyymdfrom6keta;
    }

    private String zrnknjyymdto6keta;

    @Column(name=GenZT_NyknmeisaiRn.ZRNKNJYYMDTO6KETA)
    public String getZrnknjyymdto6keta() {
        return zrnknjyymdto6keta;
    }

    public void setZrnknjyymdto6keta(String pZrnknjyymdto6keta) {
        zrnknjyymdto6keta = pZrnknjyymdto6keta;
    }

    @Id
    @Column(name=GenZT_NyknmeisaiRn.ZRNBANKCD)
    public String getZrnbankcd() {
        return getPrimaryKey().getZrnbankcd();
    }

    public void setZrnbankcd(String pZrnbankcd) {
        getPrimaryKey().setZrnbankcd(pZrnbankcd);
    }

    private String zrnbanknmkn;

    @Column(name=GenZT_NyknmeisaiRn.ZRNBANKNMKN)
    public String getZrnbanknmkn() {
        return zrnbanknmkn;
    }

    public void setZrnbanknmkn(String pZrnbanknmkn) {
        zrnbanknmkn = pZrnbanknmkn;
    }

    @Id
    @Column(name=GenZT_NyknmeisaiRn.ZRNSHITENCD)
    public String getZrnshitencd() {
        return getPrimaryKey().getZrnshitencd();
    }

    public void setZrnshitencd(String pZrnshitencd) {
        getPrimaryKey().setZrnshitencd(pZrnshitencd);
    }

    private String zrnsitennmkn;

    @Column(name=GenZT_NyknmeisaiRn.ZRNSITENNMKN)
    public String getZrnsitennmkn() {
        return zrnsitennmkn;
    }

    public void setZrnsitennmkn(String pZrnsitennmkn) {
        zrnsitennmkn = pZrnsitennmkn;
    }

    private String zrnyobiv3;

    @Column(name=GenZT_NyknmeisaiRn.ZRNYOBIV3)
    public String getZrnyobiv3() {
        return zrnyobiv3;
    }

    public void setZrnyobiv3(String pZrnyobiv3) {
        zrnyobiv3 = pZrnyobiv3;
    }

    @Id
    @Column(name=GenZT_NyknmeisaiRn.ZRNYOKINKBN)
    public String getZrnyokinkbn() {
        return getPrimaryKey().getZrnyokinkbn();
    }

    public void setZrnyokinkbn(String pZrnyokinkbn) {
        getPrimaryKey().setZrnyokinkbn(pZrnyokinkbn);
    }

    @Id
    @Column(name=GenZT_NyknmeisaiRn.ZRNKOUZANO)
    public String getZrnkouzano() {
        return getPrimaryKey().getZrnkouzano();
    }

    public void setZrnkouzano(String pZrnkouzano) {
        getPrimaryKey().setZrnkouzano(pZrnkouzano);
    }

    private String zrnkznmkn;

    @Column(name=GenZT_NyknmeisaiRn.ZRNKZNMKN)
    public String getZrnkznmkn() {
        return zrnkznmkn;
    }

    public void setZrnkznmkn(String pZrnkznmkn) {
        zrnkznmkn = pZrnkznmkn;
    }

    private String zrnkasikosikbn;

    @Column(name=GenZT_NyknmeisaiRn.ZRNKASIKOSIKBN)
    public String getZrnkasikosikbn() {
        return zrnkasikosikbn;
    }

    public void setZrnkasikosikbn(String pZrnkasikosikbn) {
        zrnkasikosikbn = pZrnkasikosikbn;
    }

    private String zrntuutyousysykbn;

    @Column(name=GenZT_NyknmeisaiRn.ZRNTUUTYOUSYSYKBN)
    public String getZrntuutyousysykbn() {
        return zrntuutyousysykbn;
    }

    public void setZrntuutyousysykbn(String pZrntuutyousysykbn) {
        zrntuutyousysykbn = pZrntuutyousysykbn;
    }

    private String zrntrhkmaezndk;

    @Column(name=GenZT_NyknmeisaiRn.ZRNTRHKMAEZNDK)
    public String getZrntrhkmaezndk() {
        return zrntrhkmaezndk;
    }

    public void setZrntrhkmaezndk(String pZrntrhkmaezndk) {
        zrntrhkmaezndk = pZrntrhkmaezndk;
    }

    private String zrnyobiv63;

    @Column(name=GenZT_NyknmeisaiRn.ZRNYOBIV63)
    public String getZrnyobiv63() {
        return zrnyobiv63;
    }

    public void setZrnyobiv63(String pZrnyobiv63) {
        zrnyobiv63 = pZrnyobiv63;
    }

    @Id
    @Column(name=GenZT_NyknmeisaiRn.ZRNRENNO8)
    public String getZrnrenno8() {
        return getPrimaryKey().getZrnrenno8();
    }

    public void setZrnrenno8(String pZrnrenno8) {
        getPrimaryKey().setZrnrenno8(pZrnrenno8);
    }

    private String zrndatakbn2;

    @Column(name=GenZT_NyknmeisaiRn.ZRNDATAKBN2)
    public String getZrndatakbn2() {
        return zrndatakbn2;
    }

    public void setZrndatakbn2(String pZrndatakbn2) {
        zrndatakbn2 = pZrndatakbn2;
    }

    @Id
    @Column(name=GenZT_NyknmeisaiRn.ZRNSYOUKAINO)
    public String getZrnsyoukaino() {
        return getPrimaryKey().getZrnsyoukaino();
    }

    public void setZrnsyoukaino(String pZrnsyoukaino) {
        getPrimaryKey().setZrnsyoukaino(pZrnsyoukaino);
    }

    private String zrnknjyymd6keta;

    @Column(name=GenZT_NyknmeisaiRn.ZRNKNJYYMD6KETA)
    public String getZrnknjyymd6keta() {
        return zrnknjyymd6keta;
    }

    public void setZrnknjyymd6keta(String pZrnknjyymd6keta) {
        zrnknjyymd6keta = pZrnknjyymd6keta;
    }

    private String zrnazkrhrdsymd6keta;

    @Column(name=GenZT_NyknmeisaiRn.ZRNAZKRHRDSYMD6KETA)
    public String getZrnazkrhrdsymd6keta() {
        return zrnazkrhrdsymd6keta;
    }

    public void setZrnazkrhrdsymd6keta(String pZrnazkrhrdsymd6keta) {
        zrnazkrhrdsymd6keta = pZrnazkrhrdsymd6keta;
    }

    private String zrniribaraikbn;

    @Column(name=GenZT_NyknmeisaiRn.ZRNIRIBARAIKBN)
    public String getZrniribaraikbn() {
        return zrniribaraikbn;
    }

    public void setZrniribaraikbn(String pZrniribaraikbn) {
        zrniribaraikbn = pZrniribaraikbn;
    }

    private String zrntrhkkbn;

    @Column(name=GenZT_NyknmeisaiRn.ZRNTRHKKBN)
    public String getZrntrhkkbn() {
        return zrntrhkkbn;
    }

    public void setZrntrhkkbn(String pZrntrhkkbn) {
        zrntrhkkbn = pZrntrhkkbn;
    }

    private String zrntrhkgk;

    @Column(name=GenZT_NyknmeisaiRn.ZRNTRHKGK)
    public String getZrntrhkgk() {
        return zrntrhkgk;
    }

    public void setZrntrhkgk(String pZrntrhkgk) {
        zrntrhkgk = pZrntrhkgk;
    }

    private String zrntatenkengk;

    @Column(name=GenZT_NyknmeisaiRn.ZRNTATENKENGK)
    public String getZrntatenkengk() {
        return zrntatenkengk;
    }

    public void setZrntatenkengk(String pZrntatenkengk) {
        zrntatenkengk = pZrntatenkengk;
    }

    private String zrnkknteijiymd6keta;

    @Column(name=GenZT_NyknmeisaiRn.ZRNKKNTEIJIYMD6KETA)
    public String getZrnkknteijiymd6keta() {
        return zrnkknteijiymd6keta;
    }

    public void setZrnkknteijiymd6keta(String pZrnkknteijiymd6keta) {
        zrnkknteijiymd6keta = pZrnkknteijiymd6keta;
    }

    private String zrnhwtrhnknymd6keta;

    @Column(name=GenZT_NyknmeisaiRn.ZRNHWTRHNKNYMD6KETA)
    public String getZrnhwtrhnknymd6keta() {
        return zrnhwtrhnknymd6keta;
    }

    public void setZrnhwtrhnknymd6keta(String pZrnhwtrhnknymd6keta) {
        zrnhwtrhnknymd6keta = pZrnhwtrhnknymd6keta;
    }

    private String zrntgtkgtkbn;

    @Column(name=GenZT_NyknmeisaiRn.ZRNTGTKGTKBN)
    public String getZrntgtkgtkbn() {
        return zrntgtkgtkbn;
    }

    public void setZrntgtkgtkbn(String pZrntgtkgtkbn) {
        zrntgtkgtkbn = pZrntgtkgtkbn;
    }

    private String zrntgtkgtno;

    @Column(name=GenZT_NyknmeisaiRn.ZRNTGTKGTNO)
    public String getZrntgtkgtno() {
        return zrntgtkgtno;
    }

    public void setZrntgtkgtno(String pZrntgtkgtno) {
        zrntgtkgtno = pZrntgtkgtno;
    }

    private String zrnryoutenno;

    @Column(name=GenZT_NyknmeisaiRn.ZRNRYOUTENNO)
    public String getZrnryoutenno() {
        return zrnryoutenno;
    }

    public void setZrnryoutenno(String pZrnryoutenno) {
        zrnryoutenno = pZrnryoutenno;
    }

    private String zrnhrkmirnincd;

    @Column(name=GenZT_NyknmeisaiRn.ZRNHRKMIRNINCD)
    public String getZrnhrkmirnincd() {
        return zrnhrkmirnincd;
    }

    public void setZrnhrkmirnincd(String pZrnhrkmirnincd) {
        zrnhrkmirnincd = pZrnhrkmirnincd;
    }

    private String zrnhrkmirninnm;

    @Column(name=GenZT_NyknmeisaiRn.ZRNHRKMIRNINNM)
    public String getZrnhrkmirninnm() {
        return zrnhrkmirninnm;
    }

    public void setZrnhrkmirninnm(String pZrnhrkmirninnm) {
        zrnhrkmirninnm = pZrnhrkmirninnm;
    }

    private String zrnsimukebanknmkn;

    @Column(name=GenZT_NyknmeisaiRn.ZRNSIMUKEBANKNMKN)
    public String getZrnsimukebanknmkn() {
        return zrnsimukebanknmkn;
    }

    public void setZrnsimukebanknmkn(String pZrnsimukebanknmkn) {
        zrnsimukebanknmkn = pZrnsimukebanknmkn;
    }

    private String zrnsimuketennmkn;

    @Column(name=GenZT_NyknmeisaiRn.ZRNSIMUKETENNMKN)
    public String getZrnsimuketennmkn() {
        return zrnsimuketennmkn;
    }

    public void setZrnsimuketennmkn(String pZrnsimuketennmkn) {
        zrnsimuketennmkn = pZrnsimuketennmkn;
    }

    private String zrntekiyounaiyou;

    @Column(name=GenZT_NyknmeisaiRn.ZRNTEKIYOUNAIYOU)
    public String getZrntekiyounaiyou() {
        return zrntekiyounaiyou;
    }

    public void setZrntekiyounaiyou(String pZrntekiyounaiyou) {
        zrntekiyounaiyou = pZrntekiyounaiyou;
    }

    private String zrnediinfo;

    @Column(name=GenZT_NyknmeisaiRn.ZRNEDIINFO)
    public String getZrnediinfo() {
        return zrnediinfo;
    }

    public void setZrnediinfo(String pZrnediinfo) {
        zrnediinfo = pZrnediinfo;
    }

    private String zrnyobiv1;

    @Column(name=GenZT_NyknmeisaiRn.ZRNYOBIV1)
    public String getZrnyobiv1() {
        return zrnyobiv1;
    }

    public void setZrnyobiv1(String pZrnyobiv1) {
        zrnyobiv1 = pZrnyobiv1;
    }
}