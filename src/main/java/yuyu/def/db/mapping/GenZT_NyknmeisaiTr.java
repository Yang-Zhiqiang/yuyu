package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_NyknmeisaiTr;
import yuyu.def.db.id.PKZT_NyknmeisaiTr;
import yuyu.def.db.meta.GenQZT_NyknmeisaiTr;
import yuyu.def.db.meta.QZT_NyknmeisaiTr;

/**
 * 入出金明細テーブル（取） テーブルのマッピング情報クラスで、 {@link ZT_NyknmeisaiTr} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_NyknmeisaiTr}</td><td colspan="3">入出金明細テーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtrdatakbn1 ztrdatakbn1}</td><td>（取込用）データ区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsyubetucd ztrsyubetucd}</td><td>（取込用）種別コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrcdkbn ztrcdkbn}</td><td>（取込用）コード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsakuseiymd6keta ztrsakuseiymd6keta}</td><td>（取込用）作成日６桁</td><td align="center">{@link PKZT_NyknmeisaiTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrknjyymdfrom6keta ztrknjyymdfrom6keta}</td><td>（取込用）勘定日（自）６桁</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrknjyymdto6keta ztrknjyymdto6keta}</td><td>（取込用）勘定日（至）６桁</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrbankcd ztrbankcd}</td><td>（取込用）銀行番号</td><td align="center">{@link PKZT_NyknmeisaiTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrbanknmkn ztrbanknmkn}</td><td>（取込用）銀行名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrshitencd ztrshitencd}</td><td>（取込用）支店番号</td><td align="center">{@link PKZT_NyknmeisaiTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsitennmkn ztrsitennmkn}</td><td>（取込用）支店名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv3 ztryobiv3}</td><td>（取込用）予備項目Ｖ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryokinkbn ztryokinkbn}</td><td>（取込用）預金種目区分</td><td align="center">{@link PKZT_NyknmeisaiTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkouzano ztrkouzano}</td><td>（取込用）口座番号</td><td align="center">{@link PKZT_NyknmeisaiTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkznmkn ztrkznmkn}</td><td>（取込用）口座名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkasikosikbn ztrkasikosikbn}</td><td>（取込用）貸越区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrtuutyousysykbn ztrtuutyousysykbn}</td><td>（取込用）通帳・証書区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrtrhkmaezndk ztrtrhkmaezndk}</td><td>（取込用）取引前残高</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv63 ztryobiv63}</td><td>（取込用）予備項目Ｖ６３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrrenno8 ztrrenno8}</td><td>（取込用）連番８桁</td><td align="center">{@link PKZT_NyknmeisaiTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrdatakbn2 ztrdatakbn2}</td><td>（取込用）データ区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsyoukaino ztrsyoukaino}</td><td>（取込用）照会番号</td><td align="center">{@link PKZT_NyknmeisaiTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrknjyymd6keta ztrknjyymd6keta}</td><td>（取込用）勘定日６桁</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrazkrhrdsymd6keta ztrazkrhrdsymd6keta}</td><td>（取込用）預入・払出日６桁</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtriribaraikbn ztriribaraikbn}</td><td>（取込用）入払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrtrhkkbn ztrtrhkkbn}</td><td>（取込用）取引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrtrhkgk ztrtrhkgk}</td><td>（取込用）取引金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrtatenkengk ztrtatenkengk}</td><td>（取込用）うち他店券金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrkknteijiymd6keta ztrkknteijiymd6keta}</td><td>（取込用）交換呈示日６桁</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrhwtrhnknymd6keta ztrhwtrhnknymd6keta}</td><td>（取込用）不渡返還日６桁</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrtgtkgtkbn ztrtgtkgtkbn}</td><td>（取込用）手形・小切手区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrtgtkgtno ztrtgtkgtno}</td><td>（取込用）手形・小切手番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrryoutenno ztrryoutenno}</td><td>（取込用）僚店番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrhrkmirnincd ztrhrkmirnincd}</td><td>（取込用）振込依頼人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrhrkmirninnm ztrhrkmirninnm}</td><td>（取込用）振込依頼人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsimukebanknmkn ztrsimukebanknmkn}</td><td>（取込用）仕向銀行名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrsimuketennmkn ztrsimuketennmkn}</td><td>（取込用）仕向店名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrtekiyounaiyou ztrtekiyounaiyou}</td><td>（取込用）摘要内容</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrediinfo ztrediinfo}</td><td>（取込用）ＥＤＩ情報</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv1 ztryobiv1}</td><td>（取込用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_NyknmeisaiTr
 * @see     PKZT_NyknmeisaiTr
 * @see     QZT_NyknmeisaiTr
 * @see     GenQZT_NyknmeisaiTr
 */
@MappedSuperclass
@Table(name=GenZT_NyknmeisaiTr.TABLE_NAME)
@IdClass(value=PKZT_NyknmeisaiTr.class)
public abstract class GenZT_NyknmeisaiTr extends AbstractExDBEntity<ZT_NyknmeisaiTr, PKZT_NyknmeisaiTr> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_NyknmeisaiTr";
    public static final String ZTRDATAKBN1              = "ztrdatakbn1";
    public static final String ZTRSYUBETUCD             = "ztrsyubetucd";
    public static final String ZTRCDKBN                 = "ztrcdkbn";
    public static final String ZTRSAKUSEIYMD6KETA       = "ztrsakuseiymd6keta";
    public static final String ZTRKNJYYMDFROM6KETA      = "ztrknjyymdfrom6keta";
    public static final String ZTRKNJYYMDTO6KETA        = "ztrknjyymdto6keta";
    public static final String ZTRBANKCD                = "ztrbankcd";
    public static final String ZTRBANKNMKN              = "ztrbanknmkn";
    public static final String ZTRSHITENCD              = "ztrshitencd";
    public static final String ZTRSITENNMKN             = "ztrsitennmkn";
    public static final String ZTRYOBIV3                = "ztryobiv3";
    public static final String ZTRYOKINKBN              = "ztryokinkbn";
    public static final String ZTRKOUZANO               = "ztrkouzano";
    public static final String ZTRKZNMKN                = "ztrkznmkn";
    public static final String ZTRKASIKOSIKBN           = "ztrkasikosikbn";
    public static final String ZTRTUUTYOUSYSYKBN        = "ztrtuutyousysykbn";
    public static final String ZTRTRHKMAEZNDK           = "ztrtrhkmaezndk";
    public static final String ZTRYOBIV63               = "ztryobiv63";
    public static final String ZTRRENNO8                = "ztrrenno8";
    public static final String ZTRDATAKBN2              = "ztrdatakbn2";
    public static final String ZTRSYOUKAINO             = "ztrsyoukaino";
    public static final String ZTRKNJYYMD6KETA          = "ztrknjyymd6keta";
    public static final String ZTRAZKRHRDSYMD6KETA      = "ztrazkrhrdsymd6keta";
    public static final String ZTRIRIBARAIKBN           = "ztriribaraikbn";
    public static final String ZTRTRHKKBN               = "ztrtrhkkbn";
    public static final String ZTRTRHKGK                = "ztrtrhkgk";
    public static final String ZTRTATENKENGK            = "ztrtatenkengk";
    public static final String ZTRKKNTEIJIYMD6KETA      = "ztrkknteijiymd6keta";
    public static final String ZTRHWTRHNKNYMD6KETA      = "ztrhwtrhnknymd6keta";
    public static final String ZTRTGTKGTKBN             = "ztrtgtkgtkbn";
    public static final String ZTRTGTKGTNO              = "ztrtgtkgtno";
    public static final String ZTRRYOUTENNO             = "ztrryoutenno";
    public static final String ZTRHRKMIRNINCD           = "ztrhrkmirnincd";
    public static final String ZTRHRKMIRNINNM           = "ztrhrkmirninnm";
    public static final String ZTRSIMUKEBANKNMKN        = "ztrsimukebanknmkn";
    public static final String ZTRSIMUKETENNMKN         = "ztrsimuketennmkn";
    public static final String ZTRTEKIYOUNAIYOU         = "ztrtekiyounaiyou";
    public static final String ZTREDIINFO               = "ztrediinfo";
    public static final String ZTRYOBIV1                = "ztryobiv1";

    private final PKZT_NyknmeisaiTr primaryKey;

    public GenZT_NyknmeisaiTr() {
        primaryKey = new PKZT_NyknmeisaiTr();
    }

    public GenZT_NyknmeisaiTr(
        String pZtrsakuseiymd6keta,
        String pZtrbankcd,
        String pZtrshitencd,
        String pZtryokinkbn,
        String pZtrkouzano,
        String pZtrsyoukaino,
        String pZtrrenno8
    ) {
        primaryKey = new PKZT_NyknmeisaiTr(
            pZtrsakuseiymd6keta,
            pZtrbankcd,
            pZtrshitencd,
            pZtryokinkbn,
            pZtrkouzano,
            pZtrsyoukaino,
            pZtrrenno8
        );
    }

    @Transient
    @Override
    public PKZT_NyknmeisaiTr getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_NyknmeisaiTr> getMetaClass() {
        return QZT_NyknmeisaiTr.class;
    }

    private String ztrdatakbn1;

    @Column(name=GenZT_NyknmeisaiTr.ZTRDATAKBN1)
    public String getZtrdatakbn1() {
        return ztrdatakbn1;
    }

    public void setZtrdatakbn1(String pZtrdatakbn1) {
        ztrdatakbn1 = pZtrdatakbn1;
    }

    private String ztrsyubetucd;

    @Column(name=GenZT_NyknmeisaiTr.ZTRSYUBETUCD)
    public String getZtrsyubetucd() {
        return ztrsyubetucd;
    }

    public void setZtrsyubetucd(String pZtrsyubetucd) {
        ztrsyubetucd = pZtrsyubetucd;
    }

    private String ztrcdkbn;

    @Column(name=GenZT_NyknmeisaiTr.ZTRCDKBN)
    public String getZtrcdkbn() {
        return ztrcdkbn;
    }

    public void setZtrcdkbn(String pZtrcdkbn) {
        ztrcdkbn = pZtrcdkbn;
    }

    @Id
    @Column(name=GenZT_NyknmeisaiTr.ZTRSAKUSEIYMD6KETA)
    public String getZtrsakuseiymd6keta() {
        return getPrimaryKey().getZtrsakuseiymd6keta();
    }

    public void setZtrsakuseiymd6keta(String pZtrsakuseiymd6keta) {
        getPrimaryKey().setZtrsakuseiymd6keta(pZtrsakuseiymd6keta);
    }

    private String ztrknjyymdfrom6keta;

    @Column(name=GenZT_NyknmeisaiTr.ZTRKNJYYMDFROM6KETA)
    public String getZtrknjyymdfrom6keta() {
        return ztrknjyymdfrom6keta;
    }

    public void setZtrknjyymdfrom6keta(String pZtrknjyymdfrom6keta) {
        ztrknjyymdfrom6keta = pZtrknjyymdfrom6keta;
    }

    private String ztrknjyymdto6keta;

    @Column(name=GenZT_NyknmeisaiTr.ZTRKNJYYMDTO6KETA)
    public String getZtrknjyymdto6keta() {
        return ztrknjyymdto6keta;
    }

    public void setZtrknjyymdto6keta(String pZtrknjyymdto6keta) {
        ztrknjyymdto6keta = pZtrknjyymdto6keta;
    }

    @Id
    @Column(name=GenZT_NyknmeisaiTr.ZTRBANKCD)
    public String getZtrbankcd() {
        return getPrimaryKey().getZtrbankcd();
    }

    public void setZtrbankcd(String pZtrbankcd) {
        getPrimaryKey().setZtrbankcd(pZtrbankcd);
    }

    private String ztrbanknmkn;

    @Column(name=GenZT_NyknmeisaiTr.ZTRBANKNMKN)
    public String getZtrbanknmkn() {
        return ztrbanknmkn;
    }

    public void setZtrbanknmkn(String pZtrbanknmkn) {
        ztrbanknmkn = pZtrbanknmkn;
    }

    @Id
    @Column(name=GenZT_NyknmeisaiTr.ZTRSHITENCD)
    public String getZtrshitencd() {
        return getPrimaryKey().getZtrshitencd();
    }

    public void setZtrshitencd(String pZtrshitencd) {
        getPrimaryKey().setZtrshitencd(pZtrshitencd);
    }

    private String ztrsitennmkn;

    @Column(name=GenZT_NyknmeisaiTr.ZTRSITENNMKN)
    public String getZtrsitennmkn() {
        return ztrsitennmkn;
    }

    public void setZtrsitennmkn(String pZtrsitennmkn) {
        ztrsitennmkn = pZtrsitennmkn;
    }

    private String ztryobiv3;

    @Column(name=GenZT_NyknmeisaiTr.ZTRYOBIV3)
    public String getZtryobiv3() {
        return ztryobiv3;
    }

    public void setZtryobiv3(String pZtryobiv3) {
        ztryobiv3 = pZtryobiv3;
    }

    @Id
    @Column(name=GenZT_NyknmeisaiTr.ZTRYOKINKBN)
    public String getZtryokinkbn() {
        return getPrimaryKey().getZtryokinkbn();
    }

    public void setZtryokinkbn(String pZtryokinkbn) {
        getPrimaryKey().setZtryokinkbn(pZtryokinkbn);
    }

    @Id
    @Column(name=GenZT_NyknmeisaiTr.ZTRKOUZANO)
    public String getZtrkouzano() {
        return getPrimaryKey().getZtrkouzano();
    }

    public void setZtrkouzano(String pZtrkouzano) {
        getPrimaryKey().setZtrkouzano(pZtrkouzano);
    }

    private String ztrkznmkn;

    @Column(name=GenZT_NyknmeisaiTr.ZTRKZNMKN)
    public String getZtrkznmkn() {
        return ztrkznmkn;
    }

    public void setZtrkznmkn(String pZtrkznmkn) {
        ztrkznmkn = pZtrkznmkn;
    }

    private String ztrkasikosikbn;

    @Column(name=GenZT_NyknmeisaiTr.ZTRKASIKOSIKBN)
    public String getZtrkasikosikbn() {
        return ztrkasikosikbn;
    }

    public void setZtrkasikosikbn(String pZtrkasikosikbn) {
        ztrkasikosikbn = pZtrkasikosikbn;
    }

    private String ztrtuutyousysykbn;

    @Column(name=GenZT_NyknmeisaiTr.ZTRTUUTYOUSYSYKBN)
    public String getZtrtuutyousysykbn() {
        return ztrtuutyousysykbn;
    }

    public void setZtrtuutyousysykbn(String pZtrtuutyousysykbn) {
        ztrtuutyousysykbn = pZtrtuutyousysykbn;
    }

    private String ztrtrhkmaezndk;

    @Column(name=GenZT_NyknmeisaiTr.ZTRTRHKMAEZNDK)
    public String getZtrtrhkmaezndk() {
        return ztrtrhkmaezndk;
    }

    public void setZtrtrhkmaezndk(String pZtrtrhkmaezndk) {
        ztrtrhkmaezndk = pZtrtrhkmaezndk;
    }

    private String ztryobiv63;

    @Column(name=GenZT_NyknmeisaiTr.ZTRYOBIV63)
    public String getZtryobiv63() {
        return ztryobiv63;
    }

    public void setZtryobiv63(String pZtryobiv63) {
        ztryobiv63 = pZtryobiv63;
    }

    @Id
    @Column(name=GenZT_NyknmeisaiTr.ZTRRENNO8)
    public String getZtrrenno8() {
        return getPrimaryKey().getZtrrenno8();
    }

    public void setZtrrenno8(String pZtrrenno8) {
        getPrimaryKey().setZtrrenno8(pZtrrenno8);
    }

    private String ztrdatakbn2;

    @Column(name=GenZT_NyknmeisaiTr.ZTRDATAKBN2)
    public String getZtrdatakbn2() {
        return ztrdatakbn2;
    }

    public void setZtrdatakbn2(String pZtrdatakbn2) {
        ztrdatakbn2 = pZtrdatakbn2;
    }

    @Id
    @Column(name=GenZT_NyknmeisaiTr.ZTRSYOUKAINO)
    public String getZtrsyoukaino() {
        return getPrimaryKey().getZtrsyoukaino();
    }

    public void setZtrsyoukaino(String pZtrsyoukaino) {
        getPrimaryKey().setZtrsyoukaino(pZtrsyoukaino);
    }

    private String ztrknjyymd6keta;

    @Column(name=GenZT_NyknmeisaiTr.ZTRKNJYYMD6KETA)
    public String getZtrknjyymd6keta() {
        return ztrknjyymd6keta;
    }

    public void setZtrknjyymd6keta(String pZtrknjyymd6keta) {
        ztrknjyymd6keta = pZtrknjyymd6keta;
    }

    private String ztrazkrhrdsymd6keta;

    @Column(name=GenZT_NyknmeisaiTr.ZTRAZKRHRDSYMD6KETA)
    public String getZtrazkrhrdsymd6keta() {
        return ztrazkrhrdsymd6keta;
    }

    public void setZtrazkrhrdsymd6keta(String pZtrazkrhrdsymd6keta) {
        ztrazkrhrdsymd6keta = pZtrazkrhrdsymd6keta;
    }

    private String ztriribaraikbn;

    @Column(name=GenZT_NyknmeisaiTr.ZTRIRIBARAIKBN)
    public String getZtriribaraikbn() {
        return ztriribaraikbn;
    }

    public void setZtriribaraikbn(String pZtriribaraikbn) {
        ztriribaraikbn = pZtriribaraikbn;
    }

    private String ztrtrhkkbn;

    @Column(name=GenZT_NyknmeisaiTr.ZTRTRHKKBN)
    public String getZtrtrhkkbn() {
        return ztrtrhkkbn;
    }

    public void setZtrtrhkkbn(String pZtrtrhkkbn) {
        ztrtrhkkbn = pZtrtrhkkbn;
    }

    private String ztrtrhkgk;

    @Column(name=GenZT_NyknmeisaiTr.ZTRTRHKGK)
    public String getZtrtrhkgk() {
        return ztrtrhkgk;
    }

    public void setZtrtrhkgk(String pZtrtrhkgk) {
        ztrtrhkgk = pZtrtrhkgk;
    }

    private String ztrtatenkengk;

    @Column(name=GenZT_NyknmeisaiTr.ZTRTATENKENGK)
    public String getZtrtatenkengk() {
        return ztrtatenkengk;
    }

    public void setZtrtatenkengk(String pZtrtatenkengk) {
        ztrtatenkengk = pZtrtatenkengk;
    }

    private String ztrkknteijiymd6keta;

    @Column(name=GenZT_NyknmeisaiTr.ZTRKKNTEIJIYMD6KETA)
    public String getZtrkknteijiymd6keta() {
        return ztrkknteijiymd6keta;
    }

    public void setZtrkknteijiymd6keta(String pZtrkknteijiymd6keta) {
        ztrkknteijiymd6keta = pZtrkknteijiymd6keta;
    }

    private String ztrhwtrhnknymd6keta;

    @Column(name=GenZT_NyknmeisaiTr.ZTRHWTRHNKNYMD6KETA)
    public String getZtrhwtrhnknymd6keta() {
        return ztrhwtrhnknymd6keta;
    }

    public void setZtrhwtrhnknymd6keta(String pZtrhwtrhnknymd6keta) {
        ztrhwtrhnknymd6keta = pZtrhwtrhnknymd6keta;
    }

    private String ztrtgtkgtkbn;

    @Column(name=GenZT_NyknmeisaiTr.ZTRTGTKGTKBN)
    public String getZtrtgtkgtkbn() {
        return ztrtgtkgtkbn;
    }

    public void setZtrtgtkgtkbn(String pZtrtgtkgtkbn) {
        ztrtgtkgtkbn = pZtrtgtkgtkbn;
    }

    private String ztrtgtkgtno;

    @Column(name=GenZT_NyknmeisaiTr.ZTRTGTKGTNO)
    public String getZtrtgtkgtno() {
        return ztrtgtkgtno;
    }

    public void setZtrtgtkgtno(String pZtrtgtkgtno) {
        ztrtgtkgtno = pZtrtgtkgtno;
    }

    private String ztrryoutenno;

    @Column(name=GenZT_NyknmeisaiTr.ZTRRYOUTENNO)
    public String getZtrryoutenno() {
        return ztrryoutenno;
    }

    public void setZtrryoutenno(String pZtrryoutenno) {
        ztrryoutenno = pZtrryoutenno;
    }

    private String ztrhrkmirnincd;

    @Column(name=GenZT_NyknmeisaiTr.ZTRHRKMIRNINCD)
    public String getZtrhrkmirnincd() {
        return ztrhrkmirnincd;
    }

    public void setZtrhrkmirnincd(String pZtrhrkmirnincd) {
        ztrhrkmirnincd = pZtrhrkmirnincd;
    }

    private String ztrhrkmirninnm;

    @Column(name=GenZT_NyknmeisaiTr.ZTRHRKMIRNINNM)
    public String getZtrhrkmirninnm() {
        return ztrhrkmirninnm;
    }

    public void setZtrhrkmirninnm(String pZtrhrkmirninnm) {
        ztrhrkmirninnm = pZtrhrkmirninnm;
    }

    private String ztrsimukebanknmkn;

    @Column(name=GenZT_NyknmeisaiTr.ZTRSIMUKEBANKNMKN)
    public String getZtrsimukebanknmkn() {
        return ztrsimukebanknmkn;
    }

    public void setZtrsimukebanknmkn(String pZtrsimukebanknmkn) {
        ztrsimukebanknmkn = pZtrsimukebanknmkn;
    }

    private String ztrsimuketennmkn;

    @Column(name=GenZT_NyknmeisaiTr.ZTRSIMUKETENNMKN)
    public String getZtrsimuketennmkn() {
        return ztrsimuketennmkn;
    }

    public void setZtrsimuketennmkn(String pZtrsimuketennmkn) {
        ztrsimuketennmkn = pZtrsimuketennmkn;
    }

    private String ztrtekiyounaiyou;

    @Column(name=GenZT_NyknmeisaiTr.ZTRTEKIYOUNAIYOU)
    public String getZtrtekiyounaiyou() {
        return ztrtekiyounaiyou;
    }

    public void setZtrtekiyounaiyou(String pZtrtekiyounaiyou) {
        ztrtekiyounaiyou = pZtrtekiyounaiyou;
    }

    private String ztrediinfo;

    @Column(name=GenZT_NyknmeisaiTr.ZTREDIINFO)
    public String getZtrediinfo() {
        return ztrediinfo;
    }

    public void setZtrediinfo(String pZtrediinfo) {
        ztrediinfo = pZtrediinfo;
    }

    private String ztryobiv1;

    @Column(name=GenZT_NyknmeisaiTr.ZTRYOBIV1)
    public String getZtryobiv1() {
        return ztryobiv1;
    }

    public void setZtryobiv1(String pZtryobiv1) {
        ztryobiv1 = pZtryobiv1;
    }
}