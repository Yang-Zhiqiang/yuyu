package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_SmbcGetujiKykMeisaiTy;
import yuyu.def.db.id.PKZT_SmbcGetujiKykMeisaiTy;
import yuyu.def.db.meta.GenQZT_SmbcGetujiKykMeisaiTy;
import yuyu.def.db.meta.QZT_SmbcGetujiKykMeisaiTy;

/**
 * ＳＭＢＣ月次契約明細Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_SmbcGetujiKykMeisaiTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SmbcGetujiKykMeisaiTy}</td><td colspan="3">ＳＭＢＣ月次契約明細Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtydatakijyunymd ztydatakijyunymd}</td><td>（中継用）データ基準年月日</td><td align="center">{@link PKZT_SmbcGetujiKykMeisaiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydatakijyunym ztydatakijyunym}</td><td>（中継用）データ基準年月</td><td align="center">{@link PKZT_SmbcGetujiKykMeisaiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_SmbcGetujiKykMeisaiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatukaidirtncd ztyaatukaidirtncd}</td><td>（中継用）Ａ扱代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybatukaidirtncd ztybatukaidirtncd}</td><td>（中継用）Ｂ扱代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatukaibosyuunincd ztyaatukaibosyuunincd}</td><td>（中継用）Ａ扱募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybatukaibosyuunincd ztybatukaibosyuunincd}</td><td>（中継用）Ｂ扱募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyuruikigousedaikbn ztyhknsyuruikigousedaikbn}</td><td>（中継用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymdhnaisyoumeicd ztymdhnaisyoumeicd}</td><td>（中継用）窓販用愛称名コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuukacdsmbcgetuji ztytuukacdsmbcgetuji}</td><td>（中継用）通貨コード（ＳＭＢＣ月次契約Ｆ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkhuhukbn ztyhrkhuhukbn}</td><td>（中継用）払込方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknmknsmbcgetuji ztykyknmknsmbcgetuji}</td><td>（中継用）契約者名（カナ）（ＳＭＢＣ月次契約Ｆ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknmkjsmbcgetuji ztykyknmkjsmbcgetuji}</td><td>（中継用）契約者名（漢字）（ＳＭＢＣ月次契約Ｆ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnmkjsmbcgetuji ztyhhknnmkjsmbcgetuji}</td><td>（中継用）被保険者名（漢字）（ＳＭＢＣ月次契約Ｆ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitijibrp ztyitijibrp}</td><td>（中継用）一時払保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygoukeip2 ztygoukeip2}</td><td>（中継用）合計保険料２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzenkizennoup ztyzenkizennoup}</td><td>（中継用）全期前納保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytumitatekngk ztytumitatekngk}</td><td>（中継用）積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytargettktoutatubi ztytargettktoutatubi}</td><td>（中継用）ターゲット到達日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymokuhyouti ztymokuhyouti}</td><td>（中継用）目標値</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymokuhyoukngk ztymokuhyoukngk}</td><td>（中継用）目標金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaiyakuhr ztykaiyakuhr}</td><td>（中継用）解約返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhrkpjyuutouym ztyhrkpjyuutouym}</td><td>（中継用）払込保険料充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihrpruikeigk ztykihrpruikeigk}</td><td>（中継用）既払保険料累計額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytousyokykjikawaserate ztytousyokykjikawaserate}</td><td>（中継用）当初契約時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymankiymd ztymankiymd}</td><td>（中継用）満期年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyikkatubaraikbn ztyikkatubaraikbn}</td><td>（中継用）一括払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyikkatubaraikaisuu ztyikkatubaraikaisuu}</td><td>（中継用）一括払回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv56 ztyyobiv56}</td><td>（中継用）予備項目Ｖ５６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygmeigyoubijikawaserate ztygmeigyoubijikawaserate}</td><td>（中継用）月末営業日時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyobiv16 ztyyobiv16}</td><td>（中継用）予備項目Ｖ１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysymtymd ztysymtymd}</td><td>（中継用）消滅年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygetumatuymdidouw ztygetumatuymdidouw}</td><td>（中継用）月末日異動解約返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygetumatuymdsibous ztygetumatuymdsibous}</td><td>（中継用）月末日死亡保険金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv53 ztyyobiv53}</td><td>（中継用）予備項目Ｖ５３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SmbcGetujiKykMeisaiTy
 * @see     PKZT_SmbcGetujiKykMeisaiTy
 * @see     QZT_SmbcGetujiKykMeisaiTy
 * @see     GenQZT_SmbcGetujiKykMeisaiTy
 */
@MappedSuperclass
@Table(name=GenZT_SmbcGetujiKykMeisaiTy.TABLE_NAME)
@IdClass(value=PKZT_SmbcGetujiKykMeisaiTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_SmbcGetujiKykMeisaiTy extends AbstractExDBEntity<ZT_SmbcGetujiKykMeisaiTy, PKZT_SmbcGetujiKykMeisaiTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SmbcGetujiKykMeisaiTy";
    public static final String ZTYDATAKIJYUNYMD         = "ztydatakijyunymd";
    public static final String ZTYDATAKIJYUNYM          = "ztydatakijyunym";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYAATUKAIDIRTNCD        = "ztyaatukaidirtncd";
    public static final String ZTYBATUKAIDIRTNCD        = "ztybatukaidirtncd";
    public static final String ZTYAATUKAIBOSYUUNINCD    = "ztyaatukaibosyuunincd";
    public static final String ZTYBATUKAIBOSYUUNINCD    = "ztybatukaibosyuunincd";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYHKNSYURUIKIGOUSEDAIKBN = "ztyhknsyuruikigousedaikbn";
    public static final String ZTYMDHNAISYOUMEICD       = "ztymdhnaisyoumeicd";
    public static final String ZTYTUUKACDSMBCGETUJI     = "ztytuukacdsmbcgetuji";
    public static final String ZTYHRKHUHUKBN            = "ztyhrkhuhukbn";
    public static final String ZTYKYKNMKNSMBCGETUJI     = "ztykyknmknsmbcgetuji";
    public static final String ZTYKYKNMKJSMBCGETUJI     = "ztykyknmkjsmbcgetuji";
    public static final String ZTYHHKNNMKJSMBCGETUJI    = "ztyhhknnmkjsmbcgetuji";
    public static final String ZTYITIJIBRP              = "ztyitijibrp";
    public static final String ZTYGOUKEIP2              = "ztygoukeip2";
    public static final String ZTYZENKIZENNOUP          = "ztyzenkizennoup";
    public static final String ZTYTUMITATEKNGK          = "ztytumitatekngk";
    public static final String ZTYTARGETTKTOUTATUBI     = "ztytargettktoutatubi";
    public static final String ZTYMOKUHYOUTI            = "ztymokuhyouti";
    public static final String ZTYMOKUHYOUKNGK          = "ztymokuhyoukngk";
    public static final String ZTYKAIYAKUHR             = "ztykaiyakuhr";
    public static final String ZTYHRKPJYUUTOUYM         = "ztyhrkpjyuutouym";
    public static final String ZTYKIHRPRUIKEIGK         = "ztykihrpruikeigk";
    public static final String ZTYTOUSYOKYKJIKAWASERATE = "ztytousyokykjikawaserate";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYMANKIYMD              = "ztymankiymd";
    public static final String ZTYIKKATUBARAIKBN        = "ztyikkatubaraikbn";
    public static final String ZTYIKKATUBARAIKAISUU     = "ztyikkatubaraikaisuu";
    public static final String ZTYYOBIV56               = "ztyyobiv56";
    public static final String ZTYGMEIGYOUBIJIKAWASERATE = "ztygmeigyoubijikawaserate";
    public static final String ZTYYOBIV16               = "ztyyobiv16";
    public static final String ZTYSYMTYMD               = "ztysymtymd";
    public static final String ZTYGETUMATUYMDIDOUW      = "ztygetumatuymdidouw";
    public static final String ZTYGETUMATUYMDSIBOUS     = "ztygetumatuymdsibous";
    public static final String ZTYYOBIV53               = "ztyyobiv53";

    private final PKZT_SmbcGetujiKykMeisaiTy primaryKey;

    public GenZT_SmbcGetujiKykMeisaiTy() {
        primaryKey = new PKZT_SmbcGetujiKykMeisaiTy();
    }

    public GenZT_SmbcGetujiKykMeisaiTy(
        String pZtydatakijyunymd,
        String pZtydatakijyunym,
        String pZtysyono
    ) {
        primaryKey = new PKZT_SmbcGetujiKykMeisaiTy(
            pZtydatakijyunymd,
            pZtydatakijyunym,
            pZtysyono
        );
    }

    @Transient
    @Override
    public PKZT_SmbcGetujiKykMeisaiTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SmbcGetujiKykMeisaiTy> getMetaClass() {
        return QZT_SmbcGetujiKykMeisaiTy.class;
    }

    @Id
    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYDATAKIJYUNYMD)
    public String getZtydatakijyunymd() {
        return getPrimaryKey().getZtydatakijyunymd();
    }

    public void setZtydatakijyunymd(String pZtydatakijyunymd) {
        getPrimaryKey().setZtydatakijyunymd(pZtydatakijyunymd);
    }

    @Id
    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYDATAKIJYUNYM)
    public String getZtydatakijyunym() {
        return getPrimaryKey().getZtydatakijyunym();
    }

    public void setZtydatakijyunym(String pZtydatakijyunym) {
        getPrimaryKey().setZtydatakijyunym(pZtydatakijyunym);
    }

    @Id
    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztyaatukaidirtncd;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYAATUKAIDIRTNCD)
    public String getZtyaatukaidirtncd() {
        return ztyaatukaidirtncd;
    }

    public void setZtyaatukaidirtncd(String pZtyaatukaidirtncd) {
        ztyaatukaidirtncd = pZtyaatukaidirtncd;
    }

    private String ztybatukaidirtncd;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYBATUKAIDIRTNCD)
    public String getZtybatukaidirtncd() {
        return ztybatukaidirtncd;
    }

    public void setZtybatukaidirtncd(String pZtybatukaidirtncd) {
        ztybatukaidirtncd = pZtybatukaidirtncd;
    }

    private String ztyaatukaibosyuunincd;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYAATUKAIBOSYUUNINCD)
    public String getZtyaatukaibosyuunincd() {
        return ztyaatukaibosyuunincd;
    }

    public void setZtyaatukaibosyuunincd(String pZtyaatukaibosyuunincd) {
        ztyaatukaibosyuunincd = pZtyaatukaibosyuunincd;
    }

    private String ztybatukaibosyuunincd;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYBATUKAIBOSYUUNINCD)
    public String getZtybatukaibosyuunincd() {
        return ztybatukaibosyuunincd;
    }

    public void setZtybatukaibosyuunincd(String pZtybatukaibosyuunincd) {
        ztybatukaibosyuunincd = pZtybatukaibosyuunincd;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztyhknsyuruikigousedaikbn;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYHKNSYURUIKIGOUSEDAIKBN)
    public String getZtyhknsyuruikigousedaikbn() {
        return ztyhknsyuruikigousedaikbn;
    }

    public void setZtyhknsyuruikigousedaikbn(String pZtyhknsyuruikigousedaikbn) {
        ztyhknsyuruikigousedaikbn = pZtyhknsyuruikigousedaikbn;
    }

    private String ztymdhnaisyoumeicd;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYMDHNAISYOUMEICD)
    public String getZtymdhnaisyoumeicd() {
        return ztymdhnaisyoumeicd;
    }

    public void setZtymdhnaisyoumeicd(String pZtymdhnaisyoumeicd) {
        ztymdhnaisyoumeicd = pZtymdhnaisyoumeicd;
    }

    private String ztytuukacdsmbcgetuji;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYTUUKACDSMBCGETUJI)
    public String getZtytuukacdsmbcgetuji() {
        return ztytuukacdsmbcgetuji;
    }

    public void setZtytuukacdsmbcgetuji(String pZtytuukacdsmbcgetuji) {
        ztytuukacdsmbcgetuji = pZtytuukacdsmbcgetuji;
    }

    private String ztyhrkhuhukbn;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYHRKHUHUKBN)
    public String getZtyhrkhuhukbn() {
        return ztyhrkhuhukbn;
    }

    public void setZtyhrkhuhukbn(String pZtyhrkhuhukbn) {
        ztyhrkhuhukbn = pZtyhrkhuhukbn;
    }

    private String ztykyknmknsmbcgetuji;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYKYKNMKNSMBCGETUJI)
    public String getZtykyknmknsmbcgetuji() {
        return ztykyknmknsmbcgetuji;
    }

    public void setZtykyknmknsmbcgetuji(String pZtykyknmknsmbcgetuji) {
        ztykyknmknsmbcgetuji = pZtykyknmknsmbcgetuji;
    }

    private String ztykyknmkjsmbcgetuji;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYKYKNMKJSMBCGETUJI)
    public String getZtykyknmkjsmbcgetuji() {
        return ztykyknmkjsmbcgetuji;
    }

    public void setZtykyknmkjsmbcgetuji(String pZtykyknmkjsmbcgetuji) {
        ztykyknmkjsmbcgetuji = pZtykyknmkjsmbcgetuji;
    }

    private String ztyhhknnmkjsmbcgetuji;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYHHKNNMKJSMBCGETUJI)
    public String getZtyhhknnmkjsmbcgetuji() {
        return ztyhhknnmkjsmbcgetuji;
    }

    public void setZtyhhknnmkjsmbcgetuji(String pZtyhhknnmkjsmbcgetuji) {
        ztyhhknnmkjsmbcgetuji = pZtyhhknnmkjsmbcgetuji;
    }

    private Long ztyitijibrp;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYITIJIBRP)
    public Long getZtyitijibrp() {
        return ztyitijibrp;
    }

    public void setZtyitijibrp(Long pZtyitijibrp) {
        ztyitijibrp = pZtyitijibrp;
    }

    private Long ztygoukeip2;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYGOUKEIP2)
    public Long getZtygoukeip2() {
        return ztygoukeip2;
    }

    public void setZtygoukeip2(Long pZtygoukeip2) {
        ztygoukeip2 = pZtygoukeip2;
    }

    private Long ztyzenkizennoup;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYZENKIZENNOUP)
    public Long getZtyzenkizennoup() {
        return ztyzenkizennoup;
    }

    public void setZtyzenkizennoup(Long pZtyzenkizennoup) {
        ztyzenkizennoup = pZtyzenkizennoup;
    }

    private Long ztytumitatekngk;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYTUMITATEKNGK)
    public Long getZtytumitatekngk() {
        return ztytumitatekngk;
    }

    public void setZtytumitatekngk(Long pZtytumitatekngk) {
        ztytumitatekngk = pZtytumitatekngk;
    }

    private String ztytargettktoutatubi;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYTARGETTKTOUTATUBI)
    public String getZtytargettktoutatubi() {
        return ztytargettktoutatubi;
    }

    public void setZtytargettktoutatubi(String pZtytargettktoutatubi) {
        ztytargettktoutatubi = pZtytargettktoutatubi;
    }

    private Long ztymokuhyouti;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYMOKUHYOUTI)
    public Long getZtymokuhyouti() {
        return ztymokuhyouti;
    }

    public void setZtymokuhyouti(Long pZtymokuhyouti) {
        ztymokuhyouti = pZtymokuhyouti;
    }

    private Long ztymokuhyoukngk;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYMOKUHYOUKNGK)
    public Long getZtymokuhyoukngk() {
        return ztymokuhyoukngk;
    }

    public void setZtymokuhyoukngk(Long pZtymokuhyoukngk) {
        ztymokuhyoukngk = pZtymokuhyoukngk;
    }

    private Long ztykaiyakuhr;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYKAIYAKUHR)
    public Long getZtykaiyakuhr() {
        return ztykaiyakuhr;
    }

    public void setZtykaiyakuhr(Long pZtykaiyakuhr) {
        ztykaiyakuhr = pZtykaiyakuhr;
    }

    private String ztyhrkpjyuutouym;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYHRKPJYUUTOUYM)
    public String getZtyhrkpjyuutouym() {
        return ztyhrkpjyuutouym;
    }

    public void setZtyhrkpjyuutouym(String pZtyhrkpjyuutouym) {
        ztyhrkpjyuutouym = pZtyhrkpjyuutouym;
    }

    private Long ztykihrpruikeigk;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYKIHRPRUIKEIGK)
    public Long getZtykihrpruikeigk() {
        return ztykihrpruikeigk;
    }

    public void setZtykihrpruikeigk(Long pZtykihrpruikeigk) {
        ztykihrpruikeigk = pZtykihrpruikeigk;
    }

    private BizNumber ztytousyokykjikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYTOUSYOKYKJIKAWASERATE)
    public BizNumber getZtytousyokykjikawaserate() {
        return ztytousyokykjikawaserate;
    }

    public void setZtytousyokykjikawaserate(BizNumber pZtytousyokykjikawaserate) {
        ztytousyokykjikawaserate = pZtytousyokykjikawaserate;
    }

    private String ztykykymd;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztymankiymd;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYMANKIYMD)
    public String getZtymankiymd() {
        return ztymankiymd;
    }

    public void setZtymankiymd(String pZtymankiymd) {
        ztymankiymd = pZtymankiymd;
    }

    private String ztyikkatubaraikbn;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYIKKATUBARAIKBN)
    public String getZtyikkatubaraikbn() {
        return ztyikkatubaraikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyikkatubaraikbn(String pZtyikkatubaraikbn) {
        ztyikkatubaraikbn = pZtyikkatubaraikbn;
    }

    private String ztyikkatubaraikaisuu;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYIKKATUBARAIKAISUU)
    public String getZtyikkatubaraikaisuu() {
        return ztyikkatubaraikaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyikkatubaraikaisuu(String pZtyikkatubaraikaisuu) {
        ztyikkatubaraikaisuu = pZtyikkatubaraikaisuu;
    }

    private String ztyyobiv56;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYYOBIV56)
    public String getZtyyobiv56() {
        return ztyyobiv56;
    }

    public void setZtyyobiv56(String pZtyyobiv56) {
        ztyyobiv56 = pZtyyobiv56;
    }

    private BizNumber ztygmeigyoubijikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYGMEIGYOUBIJIKAWASERATE)
    public BizNumber getZtygmeigyoubijikawaserate() {
        return ztygmeigyoubijikawaserate;
    }

    public void setZtygmeigyoubijikawaserate(BizNumber pZtygmeigyoubijikawaserate) {
        ztygmeigyoubijikawaserate = pZtygmeigyoubijikawaserate;
    }

    private String ztyyobiv16;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYYOBIV16)
    public String getZtyyobiv16() {
        return ztyyobiv16;
    }

    public void setZtyyobiv16(String pZtyyobiv16) {
        ztyyobiv16 = pZtyyobiv16;
    }

    private String ztysymtymd;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYSYMTYMD)
    public String getZtysymtymd() {
        return ztysymtymd;
    }

    public void setZtysymtymd(String pZtysymtymd) {
        ztysymtymd = pZtysymtymd;
    }

    private Long ztygetumatuymdidouw;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYGETUMATUYMDIDOUW)
    public Long getZtygetumatuymdidouw() {
        return ztygetumatuymdidouw;
    }

    public void setZtygetumatuymdidouw(Long pZtygetumatuymdidouw) {
        ztygetumatuymdidouw = pZtygetumatuymdidouw;
    }

    private Long ztygetumatuymdsibous;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYGETUMATUYMDSIBOUS)
    public Long getZtygetumatuymdsibous() {
        return ztygetumatuymdsibous;
    }

    public void setZtygetumatuymdsibous(Long pZtygetumatuymdsibous) {
        ztygetumatuymdsibous = pZtygetumatuymdsibous;
    }

    private String ztyyobiv53;

    @Column(name=GenZT_SmbcGetujiKykMeisaiTy.ZTYYOBIV53)
    public String getZtyyobiv53() {
        return ztyyobiv53;
    }

    public void setZtyyobiv53(String pZtyyobiv53) {
        ztyyobiv53 = pZtyyobiv53;
    }
}