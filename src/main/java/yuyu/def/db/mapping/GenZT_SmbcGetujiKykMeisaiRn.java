package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_SmbcGetujiKykMeisaiRn;
import yuyu.def.db.id.PKZT_SmbcGetujiKykMeisaiRn;
import yuyu.def.db.meta.GenQZT_SmbcGetujiKykMeisaiRn;
import yuyu.def.db.meta.QZT_SmbcGetujiKykMeisaiRn;

/**
 * ＳＭＢＣ月次契約明細Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SmbcGetujiKykMeisaiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SmbcGetujiKykMeisaiRn}</td><td colspan="3">ＳＭＢＣ月次契約明細Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrndatakijyunymd zrndatakijyunymd}</td><td>（連携用）データ基準年月日</td><td align="center">{@link PKZT_SmbcGetujiKykMeisaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakijyunym zrndatakijyunym}</td><td>（連携用）データ基準年月</td><td align="center">{@link PKZT_SmbcGetujiKykMeisaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_SmbcGetujiKykMeisaiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatukaidirtncd zrnaatukaidirtncd}</td><td>（連携用）Ａ扱代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbatukaidirtncd zrnbatukaidirtncd}</td><td>（連携用）Ｂ扱代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatukaibosyuunincd zrnaatukaibosyuunincd}</td><td>（連携用）Ａ扱募集人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbatukaibosyuunincd zrnbatukaibosyuunincd}</td><td>（連携用）Ｂ扱募集人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruikigousedaikbn zrnhknsyuruikigousedaikbn}</td><td>（連携用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmdhnaisyoumeicd zrnmdhnaisyoumeicd}</td><td>（連携用）窓販用愛称名コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuukacdsmbcgetuji zrntuukacdsmbcgetuji}</td><td>（連携用）通貨コード（ＳＭＢＣ月次契約Ｆ）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkhuhukbn zrnhrkhuhukbn}</td><td>（連携用）払込方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknmknsmbcgetuji zrnkyknmknsmbcgetuji}</td><td>（連携用）契約者名（カナ）（ＳＭＢＣ月次契約Ｆ）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknmkjsmbcgetuji zrnkyknmkjsmbcgetuji}</td><td>（連携用）契約者名（漢字）（ＳＭＢＣ月次契約Ｆ）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnmkjsmbcgetuji zrnhhknnmkjsmbcgetuji}</td><td>（連携用）被保険者名（漢字）（ＳＭＢＣ月次契約Ｆ）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitijibrp zrnitijibrp}</td><td>（連携用）一時払保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngoukeip2 zrngoukeip2}</td><td>（連携用）合計保険料２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzenkizennoup zrnzenkizennoup}</td><td>（連携用）全期前納保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntumitatekngk zrntumitatekngk}</td><td>（連携用）積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntargettktoutatubi zrntargettktoutatubi}</td><td>（連携用）ターゲット到達日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmokuhyouti zrnmokuhyouti}</td><td>（連携用）目標値</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmokuhyoukngk zrnmokuhyoukngk}</td><td>（連携用）目標金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaiyakuhr zrnkaiyakuhr}</td><td>（連携用）解約返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhrkpjyuutouym zrnhrkpjyuutouym}</td><td>（連携用）払込保険料充当年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihrpruikeigk zrnkihrpruikeigk}</td><td>（連携用）既払保険料累計額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntousyokykjikawaserate zrntousyokykjikawaserate}</td><td>（連携用）当初契約時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmankiymd zrnmankiymd}</td><td>（連携用）満期年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnikkatubaraikbn zrnikkatubaraikbn}</td><td>（連携用）一括払区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnikkatubaraikaisuu zrnikkatubaraikaisuu}</td><td>（連携用）一括払回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv56 zrnyobiv56}</td><td>（連携用）予備項目Ｖ５６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngmeigyoubijikawaserate zrngmeigyoubijikawaserate}</td><td>（連携用）月末営業日時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyobiv16 zrnyobiv16}</td><td>（連携用）予備項目Ｖ１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsymtymd zrnsymtymd}</td><td>（連携用）消滅年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngetumatuymdidouw zrngetumatuymdidouw}</td><td>（連携用）月末日異動解約返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngetumatuymdsibous zrngetumatuymdsibous}</td><td>（連携用）月末日死亡保険金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv53 zrnyobiv53}</td><td>（連携用）予備項目Ｖ５３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SmbcGetujiKykMeisaiRn
 * @see     PKZT_SmbcGetujiKykMeisaiRn
 * @see     QZT_SmbcGetujiKykMeisaiRn
 * @see     GenQZT_SmbcGetujiKykMeisaiRn
 */
@MappedSuperclass
@Table(name=GenZT_SmbcGetujiKykMeisaiRn.TABLE_NAME)
@IdClass(value=PKZT_SmbcGetujiKykMeisaiRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_SmbcGetujiKykMeisaiRn extends AbstractExDBEntityForZDB<ZT_SmbcGetujiKykMeisaiRn, PKZT_SmbcGetujiKykMeisaiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SmbcGetujiKykMeisaiRn";
    public static final String ZRNDATAKIJYUNYMD         = "zrndatakijyunymd";
    public static final String ZRNDATAKIJYUNYM          = "zrndatakijyunym";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNAATUKAIDIRTNCD        = "zrnaatukaidirtncd";
    public static final String ZRNBATUKAIDIRTNCD        = "zrnbatukaidirtncd";
    public static final String ZRNAATUKAIBOSYUUNINCD    = "zrnaatukaibosyuunincd";
    public static final String ZRNBATUKAIBOSYUUNINCD    = "zrnbatukaibosyuunincd";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNHKNSYURUIKIGOUSEDAIKBN = "zrnhknsyuruikigousedaikbn";
    public static final String ZRNMDHNAISYOUMEICD       = "zrnmdhnaisyoumeicd";
    public static final String ZRNTUUKACDSMBCGETUJI     = "zrntuukacdsmbcgetuji";
    public static final String ZRNHRKHUHUKBN            = "zrnhrkhuhukbn";
    public static final String ZRNKYKNMKNSMBCGETUJI     = "zrnkyknmknsmbcgetuji";
    public static final String ZRNKYKNMKJSMBCGETUJI     = "zrnkyknmkjsmbcgetuji";
    public static final String ZRNHHKNNMKJSMBCGETUJI    = "zrnhhknnmkjsmbcgetuji";
    public static final String ZRNITIJIBRP              = "zrnitijibrp";
    public static final String ZRNGOUKEIP2              = "zrngoukeip2";
    public static final String ZRNZENKIZENNOUP          = "zrnzenkizennoup";
    public static final String ZRNTUMITATEKNGK          = "zrntumitatekngk";
    public static final String ZRNTARGETTKTOUTATUBI     = "zrntargettktoutatubi";
    public static final String ZRNMOKUHYOUTI            = "zrnmokuhyouti";
    public static final String ZRNMOKUHYOUKNGK          = "zrnmokuhyoukngk";
    public static final String ZRNKAIYAKUHR             = "zrnkaiyakuhr";
    public static final String ZRNHRKPJYUUTOUYM         = "zrnhrkpjyuutouym";
    public static final String ZRNKIHRPRUIKEIGK         = "zrnkihrpruikeigk";
    public static final String ZRNTOUSYOKYKJIKAWASERATE = "zrntousyokykjikawaserate";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNMANKIYMD              = "zrnmankiymd";
    public static final String ZRNIKKATUBARAIKBN        = "zrnikkatubaraikbn";
    public static final String ZRNIKKATUBARAIKAISUU     = "zrnikkatubaraikaisuu";
    public static final String ZRNYOBIV56               = "zrnyobiv56";
    public static final String ZRNGMEIGYOUBIJIKAWASERATE = "zrngmeigyoubijikawaserate";
    public static final String ZRNYOBIV16               = "zrnyobiv16";
    public static final String ZRNSYMTYMD               = "zrnsymtymd";
    public static final String ZRNGETUMATUYMDIDOUW      = "zrngetumatuymdidouw";
    public static final String ZRNGETUMATUYMDSIBOUS     = "zrngetumatuymdsibous";
    public static final String ZRNYOBIV53               = "zrnyobiv53";

    private final PKZT_SmbcGetujiKykMeisaiRn primaryKey;

    public GenZT_SmbcGetujiKykMeisaiRn() {
        primaryKey = new PKZT_SmbcGetujiKykMeisaiRn();
    }

    public GenZT_SmbcGetujiKykMeisaiRn(
        String pZrndatakijyunymd,
        String pZrndatakijyunym,
        String pZrnsyono
    ) {
        primaryKey = new PKZT_SmbcGetujiKykMeisaiRn(
            pZrndatakijyunymd,
            pZrndatakijyunym,
            pZrnsyono
        );
    }

    @Transient
    @Override
    public PKZT_SmbcGetujiKykMeisaiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SmbcGetujiKykMeisaiRn> getMetaClass() {
        return QZT_SmbcGetujiKykMeisaiRn.class;
    }

    @Id
    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNDATAKIJYUNYMD)
    public String getZrndatakijyunymd() {
        return getPrimaryKey().getZrndatakijyunymd();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrndatakijyunymd(String pZrndatakijyunymd) {
        getPrimaryKey().setZrndatakijyunymd(pZrndatakijyunymd);
    }

    @Id
    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNDATAKIJYUNYM)
    public String getZrndatakijyunym() {
        return getPrimaryKey().getZrndatakijyunym();
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrndatakijyunym(String pZrndatakijyunym) {
        getPrimaryKey().setZrndatakijyunym(pZrndatakijyunym);
    }

    @Id
    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnaatukaidirtncd;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNAATUKAIDIRTNCD)
    public String getZrnaatukaidirtncd() {
        return zrnaatukaidirtncd;
    }

    public void setZrnaatukaidirtncd(String pZrnaatukaidirtncd) {
        zrnaatukaidirtncd = pZrnaatukaidirtncd;
    }

    private String zrnbatukaidirtncd;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNBATUKAIDIRTNCD)
    public String getZrnbatukaidirtncd() {
        return zrnbatukaidirtncd;
    }

    public void setZrnbatukaidirtncd(String pZrnbatukaidirtncd) {
        zrnbatukaidirtncd = pZrnbatukaidirtncd;
    }

    private String zrnaatukaibosyuunincd;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNAATUKAIBOSYUUNINCD)
    public String getZrnaatukaibosyuunincd() {
        return zrnaatukaibosyuunincd;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnaatukaibosyuunincd(String pZrnaatukaibosyuunincd) {
        zrnaatukaibosyuunincd = pZrnaatukaibosyuunincd;
    }

    private String zrnbatukaibosyuunincd;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNBATUKAIBOSYUUNINCD)
    public String getZrnbatukaibosyuunincd() {
        return zrnbatukaibosyuunincd;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnbatukaibosyuunincd(String pZrnbatukaibosyuunincd) {
        zrnbatukaibosyuunincd = pZrnbatukaibosyuunincd;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnhknsyuruikigousedaikbn;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNHKNSYURUIKIGOUSEDAIKBN)
    public String getZrnhknsyuruikigousedaikbn() {
        return zrnhknsyuruikigousedaikbn;
    }

    public void setZrnhknsyuruikigousedaikbn(String pZrnhknsyuruikigousedaikbn) {
        zrnhknsyuruikigousedaikbn = pZrnhknsyuruikigousedaikbn;
    }

    private String zrnmdhnaisyoumeicd;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNMDHNAISYOUMEICD)
    public String getZrnmdhnaisyoumeicd() {
        return zrnmdhnaisyoumeicd;
    }

    public void setZrnmdhnaisyoumeicd(String pZrnmdhnaisyoumeicd) {
        zrnmdhnaisyoumeicd = pZrnmdhnaisyoumeicd;
    }

    private String zrntuukacdsmbcgetuji;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNTUUKACDSMBCGETUJI)
    public String getZrntuukacdsmbcgetuji() {
        return zrntuukacdsmbcgetuji;
    }

    public void setZrntuukacdsmbcgetuji(String pZrntuukacdsmbcgetuji) {
        zrntuukacdsmbcgetuji = pZrntuukacdsmbcgetuji;
    }

    private String zrnhrkhuhukbn;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNHRKHUHUKBN)
    public String getZrnhrkhuhukbn() {
        return zrnhrkhuhukbn;
    }

    public void setZrnhrkhuhukbn(String pZrnhrkhuhukbn) {
        zrnhrkhuhukbn = pZrnhrkhuhukbn;
    }

    private String zrnkyknmknsmbcgetuji;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNKYKNMKNSMBCGETUJI)
    public String getZrnkyknmknsmbcgetuji() {
        return zrnkyknmknsmbcgetuji;
    }

    public void setZrnkyknmknsmbcgetuji(String pZrnkyknmknsmbcgetuji) {
        zrnkyknmknsmbcgetuji = pZrnkyknmknsmbcgetuji;
    }

    private String zrnkyknmkjsmbcgetuji;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNKYKNMKJSMBCGETUJI)
    public String getZrnkyknmkjsmbcgetuji() {
        return zrnkyknmkjsmbcgetuji;
    }

    @DataConvert("toMultiByte")
    public void setZrnkyknmkjsmbcgetuji(String pZrnkyknmkjsmbcgetuji) {
        zrnkyknmkjsmbcgetuji = pZrnkyknmkjsmbcgetuji;
    }

    private String zrnhhknnmkjsmbcgetuji;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNHHKNNMKJSMBCGETUJI)
    public String getZrnhhknnmkjsmbcgetuji() {
        return zrnhhknnmkjsmbcgetuji;
    }

    @DataConvert("toMultiByte")
    public void setZrnhhknnmkjsmbcgetuji(String pZrnhhknnmkjsmbcgetuji) {
        zrnhhknnmkjsmbcgetuji = pZrnhhknnmkjsmbcgetuji;
    }

    private Long zrnitijibrp;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNITIJIBRP)
    public Long getZrnitijibrp() {
        return zrnitijibrp;
    }

    public void setZrnitijibrp(Long pZrnitijibrp) {
        zrnitijibrp = pZrnitijibrp;
    }

    private Long zrngoukeip2;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNGOUKEIP2)
    public Long getZrngoukeip2() {
        return zrngoukeip2;
    }

    public void setZrngoukeip2(Long pZrngoukeip2) {
        zrngoukeip2 = pZrngoukeip2;
    }

    private Long zrnzenkizennoup;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNZENKIZENNOUP)
    public Long getZrnzenkizennoup() {
        return zrnzenkizennoup;
    }

    public void setZrnzenkizennoup(Long pZrnzenkizennoup) {
        zrnzenkizennoup = pZrnzenkizennoup;
    }

    private Long zrntumitatekngk;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNTUMITATEKNGK)
    public Long getZrntumitatekngk() {
        return zrntumitatekngk;
    }

    public void setZrntumitatekngk(Long pZrntumitatekngk) {
        zrntumitatekngk = pZrntumitatekngk;
    }

    private String zrntargettktoutatubi;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNTARGETTKTOUTATUBI)
    public String getZrntargettktoutatubi() {
        return zrntargettktoutatubi;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntargettktoutatubi(String pZrntargettktoutatubi) {
        zrntargettktoutatubi = pZrntargettktoutatubi;
    }

    private Long zrnmokuhyouti;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNMOKUHYOUTI)
    public Long getZrnmokuhyouti() {
        return zrnmokuhyouti;
    }

    public void setZrnmokuhyouti(Long pZrnmokuhyouti) {
        zrnmokuhyouti = pZrnmokuhyouti;
    }

    private Long zrnmokuhyoukngk;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNMOKUHYOUKNGK)
    public Long getZrnmokuhyoukngk() {
        return zrnmokuhyoukngk;
    }

    public void setZrnmokuhyoukngk(Long pZrnmokuhyoukngk) {
        zrnmokuhyoukngk = pZrnmokuhyoukngk;
    }

    private Long zrnkaiyakuhr;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNKAIYAKUHR)
    public Long getZrnkaiyakuhr() {
        return zrnkaiyakuhr;
    }

    public void setZrnkaiyakuhr(Long pZrnkaiyakuhr) {
        zrnkaiyakuhr = pZrnkaiyakuhr;
    }

    private String zrnhrkpjyuutouym;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNHRKPJYUUTOUYM)
    public String getZrnhrkpjyuutouym() {
        return zrnhrkpjyuutouym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnhrkpjyuutouym(String pZrnhrkpjyuutouym) {
        zrnhrkpjyuutouym = pZrnhrkpjyuutouym;
    }

    private Long zrnkihrpruikeigk;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNKIHRPRUIKEIGK)
    public Long getZrnkihrpruikeigk() {
        return zrnkihrpruikeigk;
    }

    public void setZrnkihrpruikeigk(Long pZrnkihrpruikeigk) {
        zrnkihrpruikeigk = pZrnkihrpruikeigk;
    }

    private BizNumber zrntousyokykjikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNTOUSYOKYKJIKAWASERATE)
    public BizNumber getZrntousyokykjikawaserate() {
        return zrntousyokykjikawaserate;
    }

    public void setZrntousyokykjikawaserate(BizNumber pZrntousyokykjikawaserate) {
        zrntousyokykjikawaserate = pZrntousyokykjikawaserate;
    }

    private String zrnkykymd;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnmankiymd;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNMANKIYMD)
    public String getZrnmankiymd() {
        return zrnmankiymd;
    }

    public void setZrnmankiymd(String pZrnmankiymd) {
        zrnmankiymd = pZrnmankiymd;
    }

    private String zrnikkatubaraikbn;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNIKKATUBARAIKBN)
    public String getZrnikkatubaraikbn() {
        return zrnikkatubaraikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnikkatubaraikbn(String pZrnikkatubaraikbn) {
        zrnikkatubaraikbn = pZrnikkatubaraikbn;
    }

    private String zrnikkatubaraikaisuu;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNIKKATUBARAIKAISUU)
    public String getZrnikkatubaraikaisuu() {
        return zrnikkatubaraikaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnikkatubaraikaisuu(String pZrnikkatubaraikaisuu) {
        zrnikkatubaraikaisuu = pZrnikkatubaraikaisuu;
    }

    private String zrnyobiv56;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNYOBIV56)
    public String getZrnyobiv56() {
        return zrnyobiv56;
    }

    public void setZrnyobiv56(String pZrnyobiv56) {
        zrnyobiv56 = pZrnyobiv56;
    }

    private BizNumber zrngmeigyoubijikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNGMEIGYOUBIJIKAWASERATE)
    public BizNumber getZrngmeigyoubijikawaserate() {
        return zrngmeigyoubijikawaserate;
    }

    public void setZrngmeigyoubijikawaserate(BizNumber pZrngmeigyoubijikawaserate) {
        zrngmeigyoubijikawaserate = pZrngmeigyoubijikawaserate;
    }

    private String zrnyobiv16;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNYOBIV16)
    public String getZrnyobiv16() {
        return zrnyobiv16;
    }

    public void setZrnyobiv16(String pZrnyobiv16) {
        zrnyobiv16 = pZrnyobiv16;
    }

    private String zrnsymtymd;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNSYMTYMD)
    public String getZrnsymtymd() {
        return zrnsymtymd;
    }

    public void setZrnsymtymd(String pZrnsymtymd) {
        zrnsymtymd = pZrnsymtymd;
    }

    private Long zrngetumatuymdidouw;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNGETUMATUYMDIDOUW)
    public Long getZrngetumatuymdidouw() {
        return zrngetumatuymdidouw;
    }

    public void setZrngetumatuymdidouw(Long pZrngetumatuymdidouw) {
        zrngetumatuymdidouw = pZrngetumatuymdidouw;
    }

    private Long zrngetumatuymdsibous;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNGETUMATUYMDSIBOUS)
    public Long getZrngetumatuymdsibous() {
        return zrngetumatuymdsibous;
    }

    public void setZrngetumatuymdsibous(Long pZrngetumatuymdsibous) {
        zrngetumatuymdsibous = pZrngetumatuymdsibous;
    }

    private String zrnyobiv53;

    @Column(name=GenZT_SmbcGetujiKykMeisaiRn.ZRNYOBIV53)
    public String getZrnyobiv53() {
        return zrnyobiv53;
    }

    public void setZrnyobiv53(String pZrnyobiv53) {
        zrnyobiv53 = pZrnyobiv53;
    }
}