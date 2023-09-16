package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.BT_Nyknmeisai;
import yuyu.def.db.id.PKBT_Nyknmeisai;
import yuyu.def.db.meta.GenQBT_Nyknmeisai;
import yuyu.def.db.meta.QBT_Nyknmeisai;

/**
 * 入出金明細テーブル テーブルのマッピング情報クラスで、 {@link BT_Nyknmeisai} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_Nyknmeisai}</td><td colspan="3">入出金明細テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getHrkmdatakbn1 hrkmdatakbn1}</td><td>（振込用）データ区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmsyubetucd hrkmsyubetucd}</td><td>（振込用）種別コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmcdkbn hrkmcdkbn}</td><td>（振込用）コード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmsakuseiymd6keta hrkmsakuseiymd6keta}</td><td>（振込用）作成日６桁</td><td align="center">{@link PKBT_Nyknmeisai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmknjyymdfrom6keta hrkmknjyymdfrom6keta}</td><td>（振込用）勘定日（自）６桁</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmknjyymdto6keta hrkmknjyymdto6keta}</td><td>（振込用）勘定日（至）６桁</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmbankcd hrkmbankcd}</td><td>（振込用）銀行番号</td><td align="center">{@link PKBT_Nyknmeisai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmbanknmkn hrkmbanknmkn}</td><td>（振込用）銀行名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmshitencd hrkmshitencd}</td><td>（振込用）支店番号</td><td align="center">{@link PKBT_Nyknmeisai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmsitennmkn hrkmsitennmkn}</td><td>（振込用）支店名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmyobiv3 hrkmyobiv3}</td><td>（振込用）予備項目Ｖ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmyokinkbn hrkmyokinkbn}</td><td>（振込用）預金種目区分</td><td align="center">{@link PKBT_Nyknmeisai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmkouzano hrkmkouzano}</td><td>（振込用）口座番号</td><td align="center">{@link PKBT_Nyknmeisai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmkznmkn hrkmkznmkn}</td><td>（振込用）口座名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmkasikosikbn hrkmkasikosikbn}</td><td>（振込用）貸越区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmtuutyousysykbn hrkmtuutyousysykbn}</td><td>（振込用）通帳・証書区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmtrhkmaezndk hrkmtrhkmaezndk}</td><td>（振込用）取引前残高</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmyobiv63 hrkmyobiv63}</td><td>（振込用）予備項目Ｖ６３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmrenno8 hrkmrenno8}</td><td>（振込用）連番８桁</td><td align="center">{@link PKBT_Nyknmeisai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmdatakbn2 hrkmdatakbn2}</td><td>（振込用）データ区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmsyoukaino hrkmsyoukaino}</td><td>（振込用）照会番号</td><td align="center">{@link PKBT_Nyknmeisai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmknjyymd6keta hrkmknjyymd6keta}</td><td>（振込用）勘定日６桁</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmazkrhrdsymd6keta hrkmazkrhrdsymd6keta}</td><td>（振込用）預入・払出日６桁</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmiribaraikbn hrkmiribaraikbn}</td><td>（振込用）入払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmtrhkkbn hrkmtrhkkbn}</td><td>（振込用）取引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmtrhkgk hrkmtrhkgk}</td><td>（振込用）取引金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmtatenkengk hrkmtatenkengk}</td><td>（振込用）うち他店券金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmkknteijiymd6keta hrkmkknteijiymd6keta}</td><td>（振込用）交換呈示日６桁</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmhwtrhnknymd6keta hrkmhwtrhnknymd6keta}</td><td>（振込用）不渡返還日６桁</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmtgtkgtkbn hrkmtgtkgtkbn}</td><td>（振込用）手形・小切手区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmtgtkgtno hrkmtgtkgtno}</td><td>（振込用）手形・小切手番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmryoutenno hrkmryoutenno}</td><td>（振込用）僚店番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmhrkmirnincd hrkmhrkmirnincd}</td><td>（振込用）振込依頼人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmhrkmirninnm hrkmhrkmirninnm}</td><td>（振込用）振込依頼人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmsimukebanknmkn hrkmsimukebanknmkn}</td><td>（振込用）仕向銀行名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmsimuketennmkn hrkmsimuketennmkn}</td><td>（振込用）仕向店名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmtekiyounaiyou hrkmtekiyounaiyou}</td><td>（振込用）摘要内容</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmediinfo hrkmediinfo}</td><td>（振込用）ＥＤＩ情報</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmyobiv1 hrkmyobiv1}</td><td>（振込用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkmrensakuseiymd6keta hrkmrensakuseiymd6keta}</td><td>（振込用）連動元作成日６桁</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_Nyknmeisai
 * @see     PKBT_Nyknmeisai
 * @see     QBT_Nyknmeisai
 * @see     GenQBT_Nyknmeisai
 */
@MappedSuperclass
@Table(name=GenBT_Nyknmeisai.TABLE_NAME)
@IdClass(value=PKBT_Nyknmeisai.class)
public abstract class GenBT_Nyknmeisai extends AbstractExDBEntity<BT_Nyknmeisai, PKBT_Nyknmeisai> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_Nyknmeisai";
    public static final String HRKMDATAKBN1             = "hrkmdatakbn1";
    public static final String HRKMSYUBETUCD            = "hrkmsyubetucd";
    public static final String HRKMCDKBN                = "hrkmcdkbn";
    public static final String HRKMSAKUSEIYMD6KETA      = "hrkmsakuseiymd6keta";
    public static final String HRKMKNJYYMDFROM6KETA     = "hrkmknjyymdfrom6keta";
    public static final String HRKMKNJYYMDTO6KETA       = "hrkmknjyymdto6keta";
    public static final String HRKMBANKCD               = "hrkmbankcd";
    public static final String HRKMBANKNMKN             = "hrkmbanknmkn";
    public static final String HRKMSHITENCD             = "hrkmshitencd";
    public static final String HRKMSITENNMKN            = "hrkmsitennmkn";
    public static final String HRKMYOBIV3               = "hrkmyobiv3";
    public static final String HRKMYOKINKBN             = "hrkmyokinkbn";
    public static final String HRKMKOUZANO              = "hrkmkouzano";
    public static final String HRKMKZNMKN               = "hrkmkznmkn";
    public static final String HRKMKASIKOSIKBN          = "hrkmkasikosikbn";
    public static final String HRKMTUUTYOUSYSYKBN       = "hrkmtuutyousysykbn";
    public static final String HRKMTRHKMAEZNDK          = "hrkmtrhkmaezndk";
    public static final String HRKMYOBIV63              = "hrkmyobiv63";
    public static final String HRKMRENNO8               = "hrkmrenno8";
    public static final String HRKMDATAKBN2             = "hrkmdatakbn2";
    public static final String HRKMSYOUKAINO            = "hrkmsyoukaino";
    public static final String HRKMKNJYYMD6KETA         = "hrkmknjyymd6keta";
    public static final String HRKMAZKRHRDSYMD6KETA     = "hrkmazkrhrdsymd6keta";
    public static final String HRKMIRIBARAIKBN          = "hrkmiribaraikbn";
    public static final String HRKMTRHKKBN              = "hrkmtrhkkbn";
    public static final String HRKMTRHKGK               = "hrkmtrhkgk";
    public static final String HRKMTATENKENGK           = "hrkmtatenkengk";
    public static final String HRKMKKNTEIJIYMD6KETA     = "hrkmkknteijiymd6keta";
    public static final String HRKMHWTRHNKNYMD6KETA     = "hrkmhwtrhnknymd6keta";
    public static final String HRKMTGTKGTKBN            = "hrkmtgtkgtkbn";
    public static final String HRKMTGTKGTNO             = "hrkmtgtkgtno";
    public static final String HRKMRYOUTENNO            = "hrkmryoutenno";
    public static final String HRKMHRKMIRNINCD          = "hrkmhrkmirnincd";
    public static final String HRKMHRKMIRNINNM          = "hrkmhrkmirninnm";
    public static final String HRKMSIMUKEBANKNMKN       = "hrkmsimukebanknmkn";
    public static final String HRKMSIMUKETENNMKN        = "hrkmsimuketennmkn";
    public static final String HRKMTEKIYOUNAIYOU        = "hrkmtekiyounaiyou";
    public static final String HRKMEDIINFO              = "hrkmediinfo";
    public static final String HRKMYOBIV1               = "hrkmyobiv1";
    public static final String HRKMRENSAKUSEIYMD6KETA   = "hrkmrensakuseiymd6keta";

    private final PKBT_Nyknmeisai primaryKey;

    public GenBT_Nyknmeisai() {
        primaryKey = new PKBT_Nyknmeisai();
    }

    public GenBT_Nyknmeisai(
        String pHrkmsakuseiymd6keta,
        String pHrkmbankcd,
        String pHrkmshitencd,
        String pHrkmyokinkbn,
        String pHrkmkouzano,
        String pHrkmsyoukaino,
        String pHrkmrenno8
    ) {
        primaryKey = new PKBT_Nyknmeisai(
            pHrkmsakuseiymd6keta,
            pHrkmbankcd,
            pHrkmshitencd,
            pHrkmyokinkbn,
            pHrkmkouzano,
            pHrkmsyoukaino,
            pHrkmrenno8
        );
    }

    @Transient
    @Override
    public PKBT_Nyknmeisai getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_Nyknmeisai> getMetaClass() {
        return QBT_Nyknmeisai.class;
    }

    private String hrkmdatakbn1;

    @Column(name=GenBT_Nyknmeisai.HRKMDATAKBN1)
    public String getHrkmdatakbn1() {
        return hrkmdatakbn1;
    }

    public void setHrkmdatakbn1(String pHrkmdatakbn1) {
        hrkmdatakbn1 = pHrkmdatakbn1;
    }

    private String hrkmsyubetucd;

    @Column(name=GenBT_Nyknmeisai.HRKMSYUBETUCD)
    public String getHrkmsyubetucd() {
        return hrkmsyubetucd;
    }

    public void setHrkmsyubetucd(String pHrkmsyubetucd) {
        hrkmsyubetucd = pHrkmsyubetucd;
    }

    private String hrkmcdkbn;

    @Column(name=GenBT_Nyknmeisai.HRKMCDKBN)
    public String getHrkmcdkbn() {
        return hrkmcdkbn;
    }

    public void setHrkmcdkbn(String pHrkmcdkbn) {
        hrkmcdkbn = pHrkmcdkbn;
    }

    @Id
    @Column(name=GenBT_Nyknmeisai.HRKMSAKUSEIYMD6KETA)
    public String getHrkmsakuseiymd6keta() {
        return getPrimaryKey().getHrkmsakuseiymd6keta();
    }

    public void setHrkmsakuseiymd6keta(String pHrkmsakuseiymd6keta) {
        getPrimaryKey().setHrkmsakuseiymd6keta(pHrkmsakuseiymd6keta);
    }

    private String hrkmknjyymdfrom6keta;

    @Column(name=GenBT_Nyknmeisai.HRKMKNJYYMDFROM6KETA)
    public String getHrkmknjyymdfrom6keta() {
        return hrkmknjyymdfrom6keta;
    }

    public void setHrkmknjyymdfrom6keta(String pHrkmknjyymdfrom6keta) {
        hrkmknjyymdfrom6keta = pHrkmknjyymdfrom6keta;
    }

    private String hrkmknjyymdto6keta;

    @Column(name=GenBT_Nyknmeisai.HRKMKNJYYMDTO6KETA)
    public String getHrkmknjyymdto6keta() {
        return hrkmknjyymdto6keta;
    }

    public void setHrkmknjyymdto6keta(String pHrkmknjyymdto6keta) {
        hrkmknjyymdto6keta = pHrkmknjyymdto6keta;
    }

    @Id
    @Column(name=GenBT_Nyknmeisai.HRKMBANKCD)
    public String getHrkmbankcd() {
        return getPrimaryKey().getHrkmbankcd();
    }

    public void setHrkmbankcd(String pHrkmbankcd) {
        getPrimaryKey().setHrkmbankcd(pHrkmbankcd);
    }

    private String hrkmbanknmkn;

    @Column(name=GenBT_Nyknmeisai.HRKMBANKNMKN)
    public String getHrkmbanknmkn() {
        return hrkmbanknmkn;
    }

    public void setHrkmbanknmkn(String pHrkmbanknmkn) {
        hrkmbanknmkn = pHrkmbanknmkn;
    }

    @Id
    @Column(name=GenBT_Nyknmeisai.HRKMSHITENCD)
    public String getHrkmshitencd() {
        return getPrimaryKey().getHrkmshitencd();
    }

    public void setHrkmshitencd(String pHrkmshitencd) {
        getPrimaryKey().setHrkmshitencd(pHrkmshitencd);
    }

    private String hrkmsitennmkn;

    @Column(name=GenBT_Nyknmeisai.HRKMSITENNMKN)
    public String getHrkmsitennmkn() {
        return hrkmsitennmkn;
    }

    public void setHrkmsitennmkn(String pHrkmsitennmkn) {
        hrkmsitennmkn = pHrkmsitennmkn;
    }

    private String hrkmyobiv3;

    @Column(name=GenBT_Nyknmeisai.HRKMYOBIV3)
    public String getHrkmyobiv3() {
        return hrkmyobiv3;
    }

    public void setHrkmyobiv3(String pHrkmyobiv3) {
        hrkmyobiv3 = pHrkmyobiv3;
    }

    @Id
    @Column(name=GenBT_Nyknmeisai.HRKMYOKINKBN)
    public String getHrkmyokinkbn() {
        return getPrimaryKey().getHrkmyokinkbn();
    }

    public void setHrkmyokinkbn(String pHrkmyokinkbn) {
        getPrimaryKey().setHrkmyokinkbn(pHrkmyokinkbn);
    }

    @Id
    @Column(name=GenBT_Nyknmeisai.HRKMKOUZANO)
    public String getHrkmkouzano() {
        return getPrimaryKey().getHrkmkouzano();
    }

    public void setHrkmkouzano(String pHrkmkouzano) {
        getPrimaryKey().setHrkmkouzano(pHrkmkouzano);
    }

    private String hrkmkznmkn;

    @Column(name=GenBT_Nyknmeisai.HRKMKZNMKN)
    public String getHrkmkznmkn() {
        return hrkmkznmkn;
    }

    public void setHrkmkznmkn(String pHrkmkznmkn) {
        hrkmkznmkn = pHrkmkznmkn;
    }

    private String hrkmkasikosikbn;

    @Column(name=GenBT_Nyknmeisai.HRKMKASIKOSIKBN)
    public String getHrkmkasikosikbn() {
        return hrkmkasikosikbn;
    }

    public void setHrkmkasikosikbn(String pHrkmkasikosikbn) {
        hrkmkasikosikbn = pHrkmkasikosikbn;
    }

    private String hrkmtuutyousysykbn;

    @Column(name=GenBT_Nyknmeisai.HRKMTUUTYOUSYSYKBN)
    public String getHrkmtuutyousysykbn() {
        return hrkmtuutyousysykbn;
    }

    public void setHrkmtuutyousysykbn(String pHrkmtuutyousysykbn) {
        hrkmtuutyousysykbn = pHrkmtuutyousysykbn;
    }

    private String hrkmtrhkmaezndk;

    @Column(name=GenBT_Nyknmeisai.HRKMTRHKMAEZNDK)
    public String getHrkmtrhkmaezndk() {
        return hrkmtrhkmaezndk;
    }

    public void setHrkmtrhkmaezndk(String pHrkmtrhkmaezndk) {
        hrkmtrhkmaezndk = pHrkmtrhkmaezndk;
    }

    private String hrkmyobiv63;

    @Column(name=GenBT_Nyknmeisai.HRKMYOBIV63)
    public String getHrkmyobiv63() {
        return hrkmyobiv63;
    }

    public void setHrkmyobiv63(String pHrkmyobiv63) {
        hrkmyobiv63 = pHrkmyobiv63;
    }

    @Id
    @Column(name=GenBT_Nyknmeisai.HRKMRENNO8)
    public String getHrkmrenno8() {
        return getPrimaryKey().getHrkmrenno8();
    }

    public void setHrkmrenno8(String pHrkmrenno8) {
        getPrimaryKey().setHrkmrenno8(pHrkmrenno8);
    }

    private String hrkmdatakbn2;

    @Column(name=GenBT_Nyknmeisai.HRKMDATAKBN2)
    public String getHrkmdatakbn2() {
        return hrkmdatakbn2;
    }

    public void setHrkmdatakbn2(String pHrkmdatakbn2) {
        hrkmdatakbn2 = pHrkmdatakbn2;
    }

    @Id
    @Column(name=GenBT_Nyknmeisai.HRKMSYOUKAINO)
    public String getHrkmsyoukaino() {
        return getPrimaryKey().getHrkmsyoukaino();
    }

    public void setHrkmsyoukaino(String pHrkmsyoukaino) {
        getPrimaryKey().setHrkmsyoukaino(pHrkmsyoukaino);
    }

    private String hrkmknjyymd6keta;

    @Column(name=GenBT_Nyknmeisai.HRKMKNJYYMD6KETA)
    public String getHrkmknjyymd6keta() {
        return hrkmknjyymd6keta;
    }

    public void setHrkmknjyymd6keta(String pHrkmknjyymd6keta) {
        hrkmknjyymd6keta = pHrkmknjyymd6keta;
    }

    private String hrkmazkrhrdsymd6keta;

    @Column(name=GenBT_Nyknmeisai.HRKMAZKRHRDSYMD6KETA)
    public String getHrkmazkrhrdsymd6keta() {
        return hrkmazkrhrdsymd6keta;
    }

    public void setHrkmazkrhrdsymd6keta(String pHrkmazkrhrdsymd6keta) {
        hrkmazkrhrdsymd6keta = pHrkmazkrhrdsymd6keta;
    }

    private String hrkmiribaraikbn;

    @Column(name=GenBT_Nyknmeisai.HRKMIRIBARAIKBN)
    public String getHrkmiribaraikbn() {
        return hrkmiribaraikbn;
    }

    public void setHrkmiribaraikbn(String pHrkmiribaraikbn) {
        hrkmiribaraikbn = pHrkmiribaraikbn;
    }

    private String hrkmtrhkkbn;

    @Column(name=GenBT_Nyknmeisai.HRKMTRHKKBN)
    public String getHrkmtrhkkbn() {
        return hrkmtrhkkbn;
    }

    public void setHrkmtrhkkbn(String pHrkmtrhkkbn) {
        hrkmtrhkkbn = pHrkmtrhkkbn;
    }

    private String hrkmtrhkgk;

    @Column(name=GenBT_Nyknmeisai.HRKMTRHKGK)
    public String getHrkmtrhkgk() {
        return hrkmtrhkgk;
    }

    public void setHrkmtrhkgk(String pHrkmtrhkgk) {
        hrkmtrhkgk = pHrkmtrhkgk;
    }

    private String hrkmtatenkengk;

    @Column(name=GenBT_Nyknmeisai.HRKMTATENKENGK)
    public String getHrkmtatenkengk() {
        return hrkmtatenkengk;
    }

    public void setHrkmtatenkengk(String pHrkmtatenkengk) {
        hrkmtatenkengk = pHrkmtatenkengk;
    }

    private String hrkmkknteijiymd6keta;

    @Column(name=GenBT_Nyknmeisai.HRKMKKNTEIJIYMD6KETA)
    public String getHrkmkknteijiymd6keta() {
        return hrkmkknteijiymd6keta;
    }

    public void setHrkmkknteijiymd6keta(String pHrkmkknteijiymd6keta) {
        hrkmkknteijiymd6keta = pHrkmkknteijiymd6keta;
    }

    private String hrkmhwtrhnknymd6keta;

    @Column(name=GenBT_Nyknmeisai.HRKMHWTRHNKNYMD6KETA)
    public String getHrkmhwtrhnknymd6keta() {
        return hrkmhwtrhnknymd6keta;
    }

    public void setHrkmhwtrhnknymd6keta(String pHrkmhwtrhnknymd6keta) {
        hrkmhwtrhnknymd6keta = pHrkmhwtrhnknymd6keta;
    }

    private String hrkmtgtkgtkbn;

    @Column(name=GenBT_Nyknmeisai.HRKMTGTKGTKBN)
    public String getHrkmtgtkgtkbn() {
        return hrkmtgtkgtkbn;
    }

    public void setHrkmtgtkgtkbn(String pHrkmtgtkgtkbn) {
        hrkmtgtkgtkbn = pHrkmtgtkgtkbn;
    }

    private String hrkmtgtkgtno;

    @Column(name=GenBT_Nyknmeisai.HRKMTGTKGTNO)
    public String getHrkmtgtkgtno() {
        return hrkmtgtkgtno;
    }

    public void setHrkmtgtkgtno(String pHrkmtgtkgtno) {
        hrkmtgtkgtno = pHrkmtgtkgtno;
    }

    private String hrkmryoutenno;

    @Column(name=GenBT_Nyknmeisai.HRKMRYOUTENNO)
    public String getHrkmryoutenno() {
        return hrkmryoutenno;
    }

    public void setHrkmryoutenno(String pHrkmryoutenno) {
        hrkmryoutenno = pHrkmryoutenno;
    }

    private String hrkmhrkmirnincd;

    @Column(name=GenBT_Nyknmeisai.HRKMHRKMIRNINCD)
    public String getHrkmhrkmirnincd() {
        return hrkmhrkmirnincd;
    }

    public void setHrkmhrkmirnincd(String pHrkmhrkmirnincd) {
        hrkmhrkmirnincd = pHrkmhrkmirnincd;
    }

    private String hrkmhrkmirninnm;

    @Column(name=GenBT_Nyknmeisai.HRKMHRKMIRNINNM)
    public String getHrkmhrkmirninnm() {
        return hrkmhrkmirninnm;
    }

    public void setHrkmhrkmirninnm(String pHrkmhrkmirninnm) {
        hrkmhrkmirninnm = pHrkmhrkmirninnm;
    }

    private String hrkmsimukebanknmkn;

    @Column(name=GenBT_Nyknmeisai.HRKMSIMUKEBANKNMKN)
    public String getHrkmsimukebanknmkn() {
        return hrkmsimukebanknmkn;
    }

    public void setHrkmsimukebanknmkn(String pHrkmsimukebanknmkn) {
        hrkmsimukebanknmkn = pHrkmsimukebanknmkn;
    }

    private String hrkmsimuketennmkn;

    @Column(name=GenBT_Nyknmeisai.HRKMSIMUKETENNMKN)
    public String getHrkmsimuketennmkn() {
        return hrkmsimuketennmkn;
    }

    public void setHrkmsimuketennmkn(String pHrkmsimuketennmkn) {
        hrkmsimuketennmkn = pHrkmsimuketennmkn;
    }

    private String hrkmtekiyounaiyou;

    @Column(name=GenBT_Nyknmeisai.HRKMTEKIYOUNAIYOU)
    public String getHrkmtekiyounaiyou() {
        return hrkmtekiyounaiyou;
    }

    public void setHrkmtekiyounaiyou(String pHrkmtekiyounaiyou) {
        hrkmtekiyounaiyou = pHrkmtekiyounaiyou;
    }

    private String hrkmediinfo;

    @Column(name=GenBT_Nyknmeisai.HRKMEDIINFO)
    public String getHrkmediinfo() {
        return hrkmediinfo;
    }

    public void setHrkmediinfo(String pHrkmediinfo) {
        hrkmediinfo = pHrkmediinfo;
    }

    private String hrkmyobiv1;

    @Column(name=GenBT_Nyknmeisai.HRKMYOBIV1)
    public String getHrkmyobiv1() {
        return hrkmyobiv1;
    }

    public void setHrkmyobiv1(String pHrkmyobiv1) {
        hrkmyobiv1 = pHrkmyobiv1;
    }

    private String hrkmrensakuseiymd6keta;

    @Column(name=GenBT_Nyknmeisai.HRKMRENSAKUSEIYMD6KETA)
    public String getHrkmrensakuseiymd6keta() {
        return hrkmrensakuseiymd6keta;
    }

    public void setHrkmrensakuseiymd6keta(String pHrkmrensakuseiymd6keta) {
        hrkmrensakuseiymd6keta = pHrkmrensakuseiymd6keta;
    }
}