package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_SkSeirituRituRn;
import yuyu.def.db.id.PKZT_SkSeirituRituRn;
import yuyu.def.db.meta.GenQZT_SkSeirituRituRn;
import yuyu.def.db.meta.QZT_SkSeirituRituRn;

/**
 * 新契約成立率Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SkSeirituRituRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SkSeirituRituRn}</td><td colspan="3">新契約成立率Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrneigyouhonbusisyacd zrneigyouhonbusisyacd}</td><td>（連携用）営業本部支社コード</td><td align="center">{@link PKZT_SkSeirituRituRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisyanm zrnsisyanm}</td><td>（連携用）支社名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsosikicd zrnsosikicd}</td><td>（連携用）組織コード</td><td align="center">{@link PKZT_SkSeirituRituRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanjisosikinm20 zrnkanjisosikinm20}</td><td>（連携用）漢字組織名（２０文字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatukaisyadrtenhyouji zrnatukaisyadrtenhyouji}</td><td>（連携用）扱者代理店表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatukaikojincd zrnatukaikojincd}</td><td>（連携用）扱者個人コード</td><td align="center">{@link PKZT_SkSeirituRituRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntansyukukjatukaisyanm zrntansyukukjatukaisyanm}</td><td>（連携用）短縮漢字扱者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmosno zrnmosno}</td><td>（連携用）申込番号</td><td align="center">{@link PKZT_SkSeirituRituRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknjhhknmei zrnknjhhknmei}</td><td>（連携用）漢字被保険者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnen2keta zrnhhknnen2keta}</td><td>（連携用）被保険者年令（２桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyanen zrnkyksyanen}</td><td>（連携用）契約者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmosym zrnmosym}</td><td>（連携用）申込月度</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmosnyuuryokuymd zrnmosnyuuryokuymd}</td><td>（連携用）申込入力年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmoskbn zrnmoskbn}</td><td>（連携用）申込区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmossyoumetukbn zrnmossyoumetukbn}</td><td>（連携用）申込消滅区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmossyumtkktymd zrnmossyumtkktymd}</td><td>（連携用）申込消滅確定年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkurikosiriyuukbn zrnkurikosiriyuukbn}</td><td>（連携用）繰越理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyknzumihyouji zrnnyknzumihyouji}</td><td>（連携用）入金済表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyknjkkbn zrnnyknjkkbn}</td><td>（連携用）入金状況区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketjkkbn zrnketjkkbn}</td><td>（連携用）決定状況区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhiktjyoutaikbn zrndakuhiktjyoutaikbn}</td><td>（連携用）諾否決定状態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkokutiymd zrnkokutiymd}</td><td>（連携用）告知年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhjykktkbn zrnhjykktkbn}</td><td>（連携用）報状告知区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuteikanikokutikbn zrntokuteikanikokutikbn}</td><td>（連携用）特定簡易告知区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhikettikekkacd zrndakuhikettikekkacd}</td><td>（連携用）諾否決定結果コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsinhsys zrnsinhsys}</td><td>（連携用）新保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnjyunhsys zrnjyunhsys}</td><td>（連携用）純保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhsys zrnhsys}</td><td>（連携用）保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsoukensuu zrnsoukensuu}</td><td>（連携用）総件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrntoukeihknsyruikbn zrntoukeihknsyruikbn}</td><td>（連携用）統計用保険種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirokbn zrnhrkkeirokbn}</td><td>（連携用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykktaikbn zrnkykktaikbn}</td><td>（連携用）契約形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsudirtnatkikeitaikbn zrnbsudirtnatkikeitaikbn}</td><td>（連携用）募集代理店扱形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokusyujimutoriatukaikbn zrntokusyujimutoriatukaikbn}</td><td>（連携用）特殊事務取扱区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihonhubi zrnkihonhubi}</td><td>（連携用）基本不備</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsphubi zrnsphubi}</td><td>（連携用）ＳＰ不備</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsseigenhubi zrnsseigenhubi}</td><td>（連携用）Ｓ制限不備</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnayosehumei zrnnayosehumei}</td><td>（連携用）名寄不明</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuusangendoover zrntuusangendoover}</td><td>（連携用）通算限度オーバー</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmosketteihoryuu zrnmosketteihoryuu}</td><td>（連携用）申込決定保留</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykkakjissityuu zrnkykkakjissityuu}</td><td>（連携用）契約確認実施中</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkktketteihoryuu zrnkktketteihoryuu}</td><td>（連携用）告知決定保留</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhonsyakethoryuu zrnhonsyakethoryuu}</td><td>（連携用）本社決定保留</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseiymdhubi zrnseiymdhubi}</td><td>（連携用）生年月日不備</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphusoku zrnphusoku}</td><td>（連携用）Ｐ不足</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsrhuketyu zrnsrhuketyu}</td><td>（連携用）成立保留受付中</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpkakin zrnpkakin}</td><td>（連携用）Ｐ過金</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmostoutyakuymd zrnmostoutyakuymd}</td><td>（連携用）申込書到着年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkkttoutyakuymd zrnkkttoutyakuymd}</td><td>（連携用）告知書到着年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsakuseiymd zrnsakuseiymd}</td><td>（連携用）作成日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokaipnyuknhuhukbn2 zrnsyokaipnyuknhuhukbn2}</td><td>（連携用）初回Ｐ入金方法区分（２文字）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokaiharaikomip zrnsyokaiharaikomip}</td><td>（連携用）初回払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnryousyuuymd zrnryousyuuymd}</td><td>（連携用）領収年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakukakuninsyuruikbn zrnkeiyakukakuninsyuruikbn}</td><td>（連携用）契約確認種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykkakjkkbn1 zrnkykkakjkkbn1}</td><td>（連携用）契約確認状況区分（１文字）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmusymd zrnmusymd}</td><td>（連携用）申込年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmossyosakuseiymd zrnmossyosakuseiymd}</td><td>（連携用）申込書作成年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyosakuseiymd zrnsyosakuseiymd}</td><td>（連携用）証券作成年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkyknm zrnkjkyknm}</td><td>（連携用）漢字契約者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknkyknm18 zrnknkyknm18}</td><td>（連携用）カナ契約者名（１８文字）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseirituyoukihontikucd zrnseirituyoukihontikucd}</td><td>（連携用）成立率用基本地区コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmosksnym zrnmosksnym}</td><td>（連携用）申込起算年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyohurimiryou zrnyohurimiryou}</td><td>（連携用）預振未了</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncreditmiryou zrncreditmiryou}</td><td>（連携用）クレカ未了</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzktrkservicekbn zrnkzktrkservicekbn}</td><td>（連携用）ご家族登録サービス区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykdrtkykarihyj zrnkykdrtkykarihyj}</td><td>（連携用）契約者代理特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstdairiseikyuutkykarihyj zrnstdairiseikyuutkykarihyj}</td><td>（連携用）指定代理請求特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyakkanjyuryouhoukbn zrnyakkanjyuryouhoukbn}</td><td>（連携用）約款受領方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyakkanbunsyono zrnyakkanbunsyono}</td><td>（連携用）約款文書番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzktuutityokusoukbn zrnkzktuutityokusoukbn}</td><td>（連携用）ご家族通知直送区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv36 zrnyobiv36}</td><td>（連携用）予備項目Ｖ３６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SkSeirituRituRn
 * @see     PKZT_SkSeirituRituRn
 * @see     QZT_SkSeirituRituRn
 * @see     GenQZT_SkSeirituRituRn
 */
@MappedSuperclass
@Table(name=GenZT_SkSeirituRituRn.TABLE_NAME)
@IdClass(value=PKZT_SkSeirituRituRn.class)
public abstract class GenZT_SkSeirituRituRn extends AbstractExDBEntityForZDB<ZT_SkSeirituRituRn, PKZT_SkSeirituRituRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SkSeirituRituRn";
    public static final String ZRNEIGYOUHONBUSISYACD    = "zrneigyouhonbusisyacd";
    public static final String ZRNSISYANM               = "zrnsisyanm";
    public static final String ZRNSOSIKICD              = "zrnsosikicd";
    public static final String ZRNKANJISOSIKINM20       = "zrnkanjisosikinm20";
    public static final String ZRNATUKAISYADRTENHYOUJI  = "zrnatukaisyadrtenhyouji";
    public static final String ZRNATUKAIKOJINCD         = "zrnatukaikojincd";
    public static final String ZRNTANSYUKUKJATUKAISYANM = "zrntansyukukjatukaisyanm";
    public static final String ZRNMOSNO                 = "zrnmosno";
    public static final String ZRNKNJHHKNMEI            = "zrnknjhhknmei";
    public static final String ZRNHHKNNEN2KETA          = "zrnhhknnen2keta";
    public static final String ZRNKYKSYANEN             = "zrnkyksyanen";
    public static final String ZRNMOSYM                 = "zrnmosym";
    public static final String ZRNMOSNYUURYOKUYMD       = "zrnmosnyuuryokuymd";
    public static final String ZRNMOSKBN                = "zrnmoskbn";
    public static final String ZRNMOSSYOUMETUKBN        = "zrnmossyoumetukbn";
    public static final String ZRNMOSSYUMTKKTYMD        = "zrnmossyumtkktymd";
    public static final String ZRNKURIKOSIRIYUUKBN      = "zrnkurikosiriyuukbn";
    public static final String ZRNNYKNZUMIHYOUJI        = "zrnnyknzumihyouji";
    public static final String ZRNNYKNJKKBN             = "zrnnyknjkkbn";
    public static final String ZRNKETJKKBN              = "zrnketjkkbn";
    public static final String ZRNDAKUHIKTJYOUTAIKBN    = "zrndakuhiktjyoutaikbn";
    public static final String ZRNKOKUTIYMD             = "zrnkokutiymd";
    public static final String ZRNHJYKKTKBN             = "zrnhjykktkbn";
    public static final String ZRNTOKUTEIKANIKOKUTIKBN  = "zrntokuteikanikokutikbn";
    public static final String ZRNDAKUHIKETTIKEKKACD    = "zrndakuhikettikekkacd";
    public static final String ZRNSINHSYS               = "zrnsinhsys";
    public static final String ZRNJYUNHSYS              = "zrnjyunhsys";
    public static final String ZRNHSYS                  = "zrnhsys";
    public static final String ZRNSOUKENSUU             = "zrnsoukensuu";
    public static final String ZRNTOUKEIHKNSYRUIKBN     = "zrntoukeihknsyruikbn";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNHRKKEIROKBN           = "zrnhrkkeirokbn";
    public static final String ZRNKYKKTAIKBN            = "zrnkykktaikbn";
    public static final String ZRNBSUDIRTNATKIKEITAIKBN = "zrnbsudirtnatkikeitaikbn";
    public static final String ZRNTOKUSYUJIMUTORIATUKAIKBN = "zrntokusyujimutoriatukaikbn";
    public static final String ZRNKIHONHUBI             = "zrnkihonhubi";
    public static final String ZRNSPHUBI                = "zrnsphubi";
    public static final String ZRNSSEIGENHUBI           = "zrnsseigenhubi";
    public static final String ZRNNAYOSEHUMEI           = "zrnnayosehumei";
    public static final String ZRNTUUSANGENDOOVER       = "zrntuusangendoover";
    public static final String ZRNMOSKETTEIHORYUU       = "zrnmosketteihoryuu";
    public static final String ZRNKYKKAKJISSITYUU       = "zrnkykkakjissityuu";
    public static final String ZRNKKTKETTEIHORYUU       = "zrnkktketteihoryuu";
    public static final String ZRNHONSYAKETHORYUU       = "zrnhonsyakethoryuu";
    public static final String ZRNSEIYMDHUBI            = "zrnseiymdhubi";
    public static final String ZRNPHUSOKU               = "zrnphusoku";
    public static final String ZRNSRHUKETYU             = "zrnsrhuketyu";
    public static final String ZRNPKAKIN                = "zrnpkakin";
    public static final String ZRNMOSTOUTYAKUYMD        = "zrnmostoutyakuymd";
    public static final String ZRNKKTTOUTYAKUYMD        = "zrnkkttoutyakuymd";
    public static final String ZRNSAKUSEIYMD            = "zrnsakuseiymd";
    public static final String ZRNSYOKAIPNYUKNHUHUKBN2  = "zrnsyokaipnyuknhuhukbn2";
    public static final String ZRNSYOKAIHARAIKOMIP      = "zrnsyokaiharaikomip";
    public static final String ZRNRYOUSYUUYMD           = "zrnryousyuuymd";
    public static final String ZRNKEIYAKUKAKUNINSYURUIKBN = "zrnkeiyakukakuninsyuruikbn";
    public static final String ZRNKYKKAKJKKBN1          = "zrnkykkakjkkbn1";
    public static final String ZRNMUSYMD                = "zrnmusymd";
    public static final String ZRNMOSSYOSAKUSEIYMD      = "zrnmossyosakuseiymd";
    public static final String ZRNSYOSAKUSEIYMD         = "zrnsyosakuseiymd";
    public static final String ZRNKJKYKNM               = "zrnkjkyknm";
    public static final String ZRNKNKYKNM18             = "zrnknkyknm18";
    public static final String ZRNSEIRITUYOUKIHONTIKUCD = "zrnseirituyoukihontikucd";
    public static final String ZRNMOSKSNYM              = "zrnmosksnym";
    public static final String ZRNYOHURIMIRYOU          = "zrnyohurimiryou";
    public static final String ZRNCREDITMIRYOU          = "zrncreditmiryou";
    public static final String ZRNKZKTRKSERVICEKBN      = "zrnkzktrkservicekbn";
    public static final String ZRNKYKDRTKYKARIHYJ       = "zrnkykdrtkykarihyj";
    public static final String ZRNSTDAIRISEIKYUUTKYKARIHYJ = "zrnstdairiseikyuutkykarihyj";
    public static final String ZRNYAKKANJYURYOUHOUKBN   = "zrnyakkanjyuryouhoukbn";
    public static final String ZRNYAKKANBUNSYONO        = "zrnyakkanbunsyono";
    public static final String ZRNKZKTUUTITYOKUSOUKBN   = "zrnkzktuutityokusoukbn";
    public static final String ZRNYOBIV36               = "zrnyobiv36";

    private final PKZT_SkSeirituRituRn primaryKey;

    public GenZT_SkSeirituRituRn() {
        primaryKey = new PKZT_SkSeirituRituRn();
    }

    public GenZT_SkSeirituRituRn(
        String pZrneigyouhonbusisyacd,
        String pZrnsosikicd,
        String pZrnatukaikojincd,
        String pZrnmosno
    ) {
        primaryKey = new PKZT_SkSeirituRituRn(
            pZrneigyouhonbusisyacd,
            pZrnsosikicd,
            pZrnatukaikojincd,
            pZrnmosno
        );
    }

    @Transient
    @Override
    public PKZT_SkSeirituRituRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SkSeirituRituRn> getMetaClass() {
        return QZT_SkSeirituRituRn.class;
    }

    @Id
    @Column(name=GenZT_SkSeirituRituRn.ZRNEIGYOUHONBUSISYACD)
    public String getZrneigyouhonbusisyacd() {
        return getPrimaryKey().getZrneigyouhonbusisyacd();
    }

    public void setZrneigyouhonbusisyacd(String pZrneigyouhonbusisyacd) {
        getPrimaryKey().setZrneigyouhonbusisyacd(pZrneigyouhonbusisyacd);
    }

    private String zrnsisyanm;

    @Column(name=GenZT_SkSeirituRituRn.ZRNSISYANM)
    public String getZrnsisyanm() {
        return zrnsisyanm;
    }

    @DataConvert("toMultiByte")
    public void setZrnsisyanm(String pZrnsisyanm) {
        zrnsisyanm = pZrnsisyanm;
    }

    @Id
    @Column(name=GenZT_SkSeirituRituRn.ZRNSOSIKICD)
    public String getZrnsosikicd() {
        return getPrimaryKey().getZrnsosikicd();
    }

    public void setZrnsosikicd(String pZrnsosikicd) {
        getPrimaryKey().setZrnsosikicd(pZrnsosikicd);
    }

    private String zrnkanjisosikinm20;

    @Column(name=GenZT_SkSeirituRituRn.ZRNKANJISOSIKINM20)
    public String getZrnkanjisosikinm20() {
        return zrnkanjisosikinm20;
    }

    @DataConvert("toMultiByte")
    public void setZrnkanjisosikinm20(String pZrnkanjisosikinm20) {
        zrnkanjisosikinm20 = pZrnkanjisosikinm20;
    }

    private String zrnatukaisyadrtenhyouji;

    @Column(name=GenZT_SkSeirituRituRn.ZRNATUKAISYADRTENHYOUJI)
    public String getZrnatukaisyadrtenhyouji() {
        return zrnatukaisyadrtenhyouji;
    }

    public void setZrnatukaisyadrtenhyouji(String pZrnatukaisyadrtenhyouji) {
        zrnatukaisyadrtenhyouji = pZrnatukaisyadrtenhyouji;
    }

    @Id
    @Column(name=GenZT_SkSeirituRituRn.ZRNATUKAIKOJINCD)
    public String getZrnatukaikojincd() {
        return getPrimaryKey().getZrnatukaikojincd();
    }

    public void setZrnatukaikojincd(String pZrnatukaikojincd) {
        getPrimaryKey().setZrnatukaikojincd(pZrnatukaikojincd);
    }

    private String zrntansyukukjatukaisyanm;

    @Column(name=GenZT_SkSeirituRituRn.ZRNTANSYUKUKJATUKAISYANM)
    public String getZrntansyukukjatukaisyanm() {
        return zrntansyukukjatukaisyanm;
    }

    @DataConvert("toMultiByte")
    public void setZrntansyukukjatukaisyanm(String pZrntansyukukjatukaisyanm) {
        zrntansyukukjatukaisyanm = pZrntansyukukjatukaisyanm;
    }

    @Id
    @Column(name=GenZT_SkSeirituRituRn.ZRNMOSNO)
    public String getZrnmosno() {
        return getPrimaryKey().getZrnmosno();
    }

    public void setZrnmosno(String pZrnmosno) {
        getPrimaryKey().setZrnmosno(pZrnmosno);
    }

    private String zrnknjhhknmei;

    @Column(name=GenZT_SkSeirituRituRn.ZRNKNJHHKNMEI)
    public String getZrnknjhhknmei() {
        return zrnknjhhknmei;
    }

    @DataConvert("toMultiByte")
    public void setZrnknjhhknmei(String pZrnknjhhknmei) {
        zrnknjhhknmei = pZrnknjhhknmei;
    }

    private String zrnhhknnen2keta;

    @Column(name=GenZT_SkSeirituRituRn.ZRNHHKNNEN2KETA)
    public String getZrnhhknnen2keta() {
        return zrnhhknnen2keta;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhhknnen2keta(String pZrnhhknnen2keta) {
        zrnhhknnen2keta = pZrnhhknnen2keta;
    }

    private String zrnkyksyanen;

    @Column(name=GenZT_SkSeirituRituRn.ZRNKYKSYANEN)
    public String getZrnkyksyanen() {
        return zrnkyksyanen;
    }

    public void setZrnkyksyanen(String pZrnkyksyanen) {
        zrnkyksyanen = pZrnkyksyanen;
    }

    private String zrnmosym;

    @Column(name=GenZT_SkSeirituRituRn.ZRNMOSYM)
    public String getZrnmosym() {
        return zrnmosym;
    }

    public void setZrnmosym(String pZrnmosym) {
        zrnmosym = pZrnmosym;
    }

    private String zrnmosnyuuryokuymd;

    @Column(name=GenZT_SkSeirituRituRn.ZRNMOSNYUURYOKUYMD)
    public String getZrnmosnyuuryokuymd() {
        return zrnmosnyuuryokuymd;
    }

    public void setZrnmosnyuuryokuymd(String pZrnmosnyuuryokuymd) {
        zrnmosnyuuryokuymd = pZrnmosnyuuryokuymd;
    }

    private String zrnmoskbn;

    @Column(name=GenZT_SkSeirituRituRn.ZRNMOSKBN)
    public String getZrnmoskbn() {
        return zrnmoskbn;
    }

    public void setZrnmoskbn(String pZrnmoskbn) {
        zrnmoskbn = pZrnmoskbn;
    }

    private String zrnmossyoumetukbn;

    @Column(name=GenZT_SkSeirituRituRn.ZRNMOSSYOUMETUKBN)
    public String getZrnmossyoumetukbn() {
        return zrnmossyoumetukbn;
    }

    public void setZrnmossyoumetukbn(String pZrnmossyoumetukbn) {
        zrnmossyoumetukbn = pZrnmossyoumetukbn;
    }

    private String zrnmossyumtkktymd;

    @Column(name=GenZT_SkSeirituRituRn.ZRNMOSSYUMTKKTYMD)
    public String getZrnmossyumtkktymd() {
        return zrnmossyumtkktymd;
    }

    public void setZrnmossyumtkktymd(String pZrnmossyumtkktymd) {
        zrnmossyumtkktymd = pZrnmossyumtkktymd;
    }

    private String zrnkurikosiriyuukbn;

    @Column(name=GenZT_SkSeirituRituRn.ZRNKURIKOSIRIYUUKBN)
    public String getZrnkurikosiriyuukbn() {
        return zrnkurikosiriyuukbn;
    }

    public void setZrnkurikosiriyuukbn(String pZrnkurikosiriyuukbn) {
        zrnkurikosiriyuukbn = pZrnkurikosiriyuukbn;
    }

    private String zrnnyknzumihyouji;

    @Column(name=GenZT_SkSeirituRituRn.ZRNNYKNZUMIHYOUJI)
    public String getZrnnyknzumihyouji() {
        return zrnnyknzumihyouji;
    }

    public void setZrnnyknzumihyouji(String pZrnnyknzumihyouji) {
        zrnnyknzumihyouji = pZrnnyknzumihyouji;
    }

    private String zrnnyknjkkbn;

    @Column(name=GenZT_SkSeirituRituRn.ZRNNYKNJKKBN)
    public String getZrnnyknjkkbn() {
        return zrnnyknjkkbn;
    }

    public void setZrnnyknjkkbn(String pZrnnyknjkkbn) {
        zrnnyknjkkbn = pZrnnyknjkkbn;
    }

    private String zrnketjkkbn;

    @Column(name=GenZT_SkSeirituRituRn.ZRNKETJKKBN)
    public String getZrnketjkkbn() {
        return zrnketjkkbn;
    }

    public void setZrnketjkkbn(String pZrnketjkkbn) {
        zrnketjkkbn = pZrnketjkkbn;
    }

    private String zrndakuhiktjyoutaikbn;

    @Column(name=GenZT_SkSeirituRituRn.ZRNDAKUHIKTJYOUTAIKBN)
    public String getZrndakuhiktjyoutaikbn() {
        return zrndakuhiktjyoutaikbn;
    }

    public void setZrndakuhiktjyoutaikbn(String pZrndakuhiktjyoutaikbn) {
        zrndakuhiktjyoutaikbn = pZrndakuhiktjyoutaikbn;
    }

    private String zrnkokutiymd;

    @Column(name=GenZT_SkSeirituRituRn.ZRNKOKUTIYMD)
    public String getZrnkokutiymd() {
        return zrnkokutiymd;
    }

    public void setZrnkokutiymd(String pZrnkokutiymd) {
        zrnkokutiymd = pZrnkokutiymd;
    }

    private String zrnhjykktkbn;

    @Column(name=GenZT_SkSeirituRituRn.ZRNHJYKKTKBN)
    public String getZrnhjykktkbn() {
        return zrnhjykktkbn;
    }

    public void setZrnhjykktkbn(String pZrnhjykktkbn) {
        zrnhjykktkbn = pZrnhjykktkbn;
    }

    private String zrntokuteikanikokutikbn;

    @Column(name=GenZT_SkSeirituRituRn.ZRNTOKUTEIKANIKOKUTIKBN)
    public String getZrntokuteikanikokutikbn() {
        return zrntokuteikanikokutikbn;
    }

    public void setZrntokuteikanikokutikbn(String pZrntokuteikanikokutikbn) {
        zrntokuteikanikokutikbn = pZrntokuteikanikokutikbn;
    }

    private String zrndakuhikettikekkacd;

    @Column(name=GenZT_SkSeirituRituRn.ZRNDAKUHIKETTIKEKKACD)
    public String getZrndakuhikettikekkacd() {
        return zrndakuhikettikekkacd;
    }

    public void setZrndakuhikettikekkacd(String pZrndakuhikettikekkacd) {
        zrndakuhikettikekkacd = pZrndakuhikettikekkacd;
    }

    private Long zrnsinhsys;

    @Column(name=GenZT_SkSeirituRituRn.ZRNSINHSYS)
    public Long getZrnsinhsys() {
        return zrnsinhsys;
    }

    public void setZrnsinhsys(Long pZrnsinhsys) {
        zrnsinhsys = pZrnsinhsys;
    }

    private Long zrnjyunhsys;

    @Column(name=GenZT_SkSeirituRituRn.ZRNJYUNHSYS)
    public Long getZrnjyunhsys() {
        return zrnjyunhsys;
    }

    public void setZrnjyunhsys(Long pZrnjyunhsys) {
        zrnjyunhsys = pZrnjyunhsys;
    }

    private Long zrnhsys;

    @Column(name=GenZT_SkSeirituRituRn.ZRNHSYS)
    public Long getZrnhsys() {
        return zrnhsys;
    }

    public void setZrnhsys(Long pZrnhsys) {
        zrnhsys = pZrnhsys;
    }

    private Integer zrnsoukensuu;

    @Column(name=GenZT_SkSeirituRituRn.ZRNSOUKENSUU)
    public Integer getZrnsoukensuu() {
        return zrnsoukensuu;
    }

    public void setZrnsoukensuu(Integer pZrnsoukensuu) {
        zrnsoukensuu = pZrnsoukensuu;
    }

    private String zrntoukeihknsyruikbn;

    @Column(name=GenZT_SkSeirituRituRn.ZRNTOUKEIHKNSYRUIKBN)
    public String getZrntoukeihknsyruikbn() {
        return zrntoukeihknsyruikbn;
    }

    public void setZrntoukeihknsyruikbn(String pZrntoukeihknsyruikbn) {
        zrntoukeihknsyruikbn = pZrntoukeihknsyruikbn;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_SkSeirituRituRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private String zrnhrkkeirokbn;

    @Column(name=GenZT_SkSeirituRituRn.ZRNHRKKEIROKBN)
    public String getZrnhrkkeirokbn() {
        return zrnhrkkeirokbn;
    }

    public void setZrnhrkkeirokbn(String pZrnhrkkeirokbn) {
        zrnhrkkeirokbn = pZrnhrkkeirokbn;
    }

    private String zrnkykktaikbn;

    @Column(name=GenZT_SkSeirituRituRn.ZRNKYKKTAIKBN)
    public String getZrnkykktaikbn() {
        return zrnkykktaikbn;
    }

    public void setZrnkykktaikbn(String pZrnkykktaikbn) {
        zrnkykktaikbn = pZrnkykktaikbn;
    }

    private String zrnbsudirtnatkikeitaikbn;

    @Column(name=GenZT_SkSeirituRituRn.ZRNBSUDIRTNATKIKEITAIKBN)
    public String getZrnbsudirtnatkikeitaikbn() {
        return zrnbsudirtnatkikeitaikbn;
    }

    public void setZrnbsudirtnatkikeitaikbn(String pZrnbsudirtnatkikeitaikbn) {
        zrnbsudirtnatkikeitaikbn = pZrnbsudirtnatkikeitaikbn;
    }

    private String zrntokusyujimutoriatukaikbn;

    @Column(name=GenZT_SkSeirituRituRn.ZRNTOKUSYUJIMUTORIATUKAIKBN)
    public String getZrntokusyujimutoriatukaikbn() {
        return zrntokusyujimutoriatukaikbn;
    }

    public void setZrntokusyujimutoriatukaikbn(String pZrntokusyujimutoriatukaikbn) {
        zrntokusyujimutoriatukaikbn = pZrntokusyujimutoriatukaikbn;
    }

    private String zrnkihonhubi;

    @Column(name=GenZT_SkSeirituRituRn.ZRNKIHONHUBI)
    public String getZrnkihonhubi() {
        return zrnkihonhubi;
    }

    public void setZrnkihonhubi(String pZrnkihonhubi) {
        zrnkihonhubi = pZrnkihonhubi;
    }

    private String zrnsphubi;

    @Column(name=GenZT_SkSeirituRituRn.ZRNSPHUBI)
    public String getZrnsphubi() {
        return zrnsphubi;
    }

    public void setZrnsphubi(String pZrnsphubi) {
        zrnsphubi = pZrnsphubi;
    }

    private String zrnsseigenhubi;

    @Column(name=GenZT_SkSeirituRituRn.ZRNSSEIGENHUBI)
    public String getZrnsseigenhubi() {
        return zrnsseigenhubi;
    }

    public void setZrnsseigenhubi(String pZrnsseigenhubi) {
        zrnsseigenhubi = pZrnsseigenhubi;
    }

    private String zrnnayosehumei;

    @Column(name=GenZT_SkSeirituRituRn.ZRNNAYOSEHUMEI)
    public String getZrnnayosehumei() {
        return zrnnayosehumei;
    }

    public void setZrnnayosehumei(String pZrnnayosehumei) {
        zrnnayosehumei = pZrnnayosehumei;
    }

    private String zrntuusangendoover;

    @Column(name=GenZT_SkSeirituRituRn.ZRNTUUSANGENDOOVER)
    public String getZrntuusangendoover() {
        return zrntuusangendoover;
    }

    public void setZrntuusangendoover(String pZrntuusangendoover) {
        zrntuusangendoover = pZrntuusangendoover;
    }

    private String zrnmosketteihoryuu;

    @Column(name=GenZT_SkSeirituRituRn.ZRNMOSKETTEIHORYUU)
    public String getZrnmosketteihoryuu() {
        return zrnmosketteihoryuu;
    }

    public void setZrnmosketteihoryuu(String pZrnmosketteihoryuu) {
        zrnmosketteihoryuu = pZrnmosketteihoryuu;
    }

    private String zrnkykkakjissityuu;

    @Column(name=GenZT_SkSeirituRituRn.ZRNKYKKAKJISSITYUU)
    public String getZrnkykkakjissityuu() {
        return zrnkykkakjissityuu;
    }

    public void setZrnkykkakjissityuu(String pZrnkykkakjissityuu) {
        zrnkykkakjissityuu = pZrnkykkakjissityuu;
    }

    private String zrnkktketteihoryuu;

    @Column(name=GenZT_SkSeirituRituRn.ZRNKKTKETTEIHORYUU)
    public String getZrnkktketteihoryuu() {
        return zrnkktketteihoryuu;
    }

    public void setZrnkktketteihoryuu(String pZrnkktketteihoryuu) {
        zrnkktketteihoryuu = pZrnkktketteihoryuu;
    }

    private String zrnhonsyakethoryuu;

    @Column(name=GenZT_SkSeirituRituRn.ZRNHONSYAKETHORYUU)
    public String getZrnhonsyakethoryuu() {
        return zrnhonsyakethoryuu;
    }

    public void setZrnhonsyakethoryuu(String pZrnhonsyakethoryuu) {
        zrnhonsyakethoryuu = pZrnhonsyakethoryuu;
    }

    private String zrnseiymdhubi;

    @Column(name=GenZT_SkSeirituRituRn.ZRNSEIYMDHUBI)
    public String getZrnseiymdhubi() {
        return zrnseiymdhubi;
    }

    public void setZrnseiymdhubi(String pZrnseiymdhubi) {
        zrnseiymdhubi = pZrnseiymdhubi;
    }

    private String zrnphusoku;

    @Column(name=GenZT_SkSeirituRituRn.ZRNPHUSOKU)
    public String getZrnphusoku() {
        return zrnphusoku;
    }

    public void setZrnphusoku(String pZrnphusoku) {
        zrnphusoku = pZrnphusoku;
    }

    private String zrnsrhuketyu;

    @Column(name=GenZT_SkSeirituRituRn.ZRNSRHUKETYU)
    public String getZrnsrhuketyu() {
        return zrnsrhuketyu;
    }

    public void setZrnsrhuketyu(String pZrnsrhuketyu) {
        zrnsrhuketyu = pZrnsrhuketyu;
    }

    private String zrnpkakin;

    @Column(name=GenZT_SkSeirituRituRn.ZRNPKAKIN)
    public String getZrnpkakin() {
        return zrnpkakin;
    }

    public void setZrnpkakin(String pZrnpkakin) {
        zrnpkakin = pZrnpkakin;
    }

    private String zrnmostoutyakuymd;

    @Column(name=GenZT_SkSeirituRituRn.ZRNMOSTOUTYAKUYMD)
    public String getZrnmostoutyakuymd() {
        return zrnmostoutyakuymd;
    }

    public void setZrnmostoutyakuymd(String pZrnmostoutyakuymd) {
        zrnmostoutyakuymd = pZrnmostoutyakuymd;
    }

    private String zrnkkttoutyakuymd;

    @Column(name=GenZT_SkSeirituRituRn.ZRNKKTTOUTYAKUYMD)
    public String getZrnkkttoutyakuymd() {
        return zrnkkttoutyakuymd;
    }

    public void setZrnkkttoutyakuymd(String pZrnkkttoutyakuymd) {
        zrnkkttoutyakuymd = pZrnkkttoutyakuymd;
    }

    private String zrnsakuseiymd;

    @Column(name=GenZT_SkSeirituRituRn.ZRNSAKUSEIYMD)
    public String getZrnsakuseiymd() {
        return zrnsakuseiymd;
    }

    public void setZrnsakuseiymd(String pZrnsakuseiymd) {
        zrnsakuseiymd = pZrnsakuseiymd;
    }

    private String zrnsyokaipnyuknhuhukbn2;

    @Column(name=GenZT_SkSeirituRituRn.ZRNSYOKAIPNYUKNHUHUKBN2)
    public String getZrnsyokaipnyuknhuhukbn2() {
        return zrnsyokaipnyuknhuhukbn2;
    }

    public void setZrnsyokaipnyuknhuhukbn2(String pZrnsyokaipnyuknhuhukbn2) {
        zrnsyokaipnyuknhuhukbn2 = pZrnsyokaipnyuknhuhukbn2;
    }

    private Long zrnsyokaiharaikomip;

    @Column(name=GenZT_SkSeirituRituRn.ZRNSYOKAIHARAIKOMIP)
    public Long getZrnsyokaiharaikomip() {
        return zrnsyokaiharaikomip;
    }

    public void setZrnsyokaiharaikomip(Long pZrnsyokaiharaikomip) {
        zrnsyokaiharaikomip = pZrnsyokaiharaikomip;
    }

    private String zrnryousyuuymd;

    @Column(name=GenZT_SkSeirituRituRn.ZRNRYOUSYUUYMD)
    public String getZrnryousyuuymd() {
        return zrnryousyuuymd;
    }

    public void setZrnryousyuuymd(String pZrnryousyuuymd) {
        zrnryousyuuymd = pZrnryousyuuymd;
    }

    private String zrnkeiyakukakuninsyuruikbn;

    @Column(name=GenZT_SkSeirituRituRn.ZRNKEIYAKUKAKUNINSYURUIKBN)
    public String getZrnkeiyakukakuninsyuruikbn() {
        return zrnkeiyakukakuninsyuruikbn;
    }

    public void setZrnkeiyakukakuninsyuruikbn(String pZrnkeiyakukakuninsyuruikbn) {
        zrnkeiyakukakuninsyuruikbn = pZrnkeiyakukakuninsyuruikbn;
    }

    private String zrnkykkakjkkbn1;

    @Column(name=GenZT_SkSeirituRituRn.ZRNKYKKAKJKKBN1)
    public String getZrnkykkakjkkbn1() {
        return zrnkykkakjkkbn1;
    }

    public void setZrnkykkakjkkbn1(String pZrnkykkakjkkbn1) {
        zrnkykkakjkkbn1 = pZrnkykkakjkkbn1;
    }

    private String zrnmusymd;

    @Column(name=GenZT_SkSeirituRituRn.ZRNMUSYMD)
    public String getZrnmusymd() {
        return zrnmusymd;
    }

    public void setZrnmusymd(String pZrnmusymd) {
        zrnmusymd = pZrnmusymd;
    }

    private String zrnmossyosakuseiymd;

    @Column(name=GenZT_SkSeirituRituRn.ZRNMOSSYOSAKUSEIYMD)
    public String getZrnmossyosakuseiymd() {
        return zrnmossyosakuseiymd;
    }

    public void setZrnmossyosakuseiymd(String pZrnmossyosakuseiymd) {
        zrnmossyosakuseiymd = pZrnmossyosakuseiymd;
    }

    private String zrnsyosakuseiymd;

    @Column(name=GenZT_SkSeirituRituRn.ZRNSYOSAKUSEIYMD)
    public String getZrnsyosakuseiymd() {
        return zrnsyosakuseiymd;
    }

    public void setZrnsyosakuseiymd(String pZrnsyosakuseiymd) {
        zrnsyosakuseiymd = pZrnsyosakuseiymd;
    }

    private String zrnkjkyknm;

    @Column(name=GenZT_SkSeirituRituRn.ZRNKJKYKNM)
    public String getZrnkjkyknm() {
        return zrnkjkyknm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkyknm(String pZrnkjkyknm) {
        zrnkjkyknm = pZrnkjkyknm;
    }

    private String zrnknkyknm18;

    @Column(name=GenZT_SkSeirituRituRn.ZRNKNKYKNM18)
    public String getZrnknkyknm18() {
        return zrnknkyknm18;
    }

    public void setZrnknkyknm18(String pZrnknkyknm18) {
        zrnknkyknm18 = pZrnknkyknm18;
    }

    private String zrnseirituyoukihontikucd;

    @Column(name=GenZT_SkSeirituRituRn.ZRNSEIRITUYOUKIHONTIKUCD)
    public String getZrnseirituyoukihontikucd() {
        return zrnseirituyoukihontikucd;
    }

    public void setZrnseirituyoukihontikucd(String pZrnseirituyoukihontikucd) {
        zrnseirituyoukihontikucd = pZrnseirituyoukihontikucd;
    }

    private String zrnmosksnym;

    @Column(name=GenZT_SkSeirituRituRn.ZRNMOSKSNYM)
    public String getZrnmosksnym() {
        return zrnmosksnym;
    }

    public void setZrnmosksnym(String pZrnmosksnym) {
        zrnmosksnym = pZrnmosksnym;
    }

    private String zrnyohurimiryou;

    @Column(name=GenZT_SkSeirituRituRn.ZRNYOHURIMIRYOU)
    public String getZrnyohurimiryou() {
        return zrnyohurimiryou;
    }

    public void setZrnyohurimiryou(String pZrnyohurimiryou) {
        zrnyohurimiryou = pZrnyohurimiryou;
    }

    private String zrncreditmiryou;

    @Column(name=GenZT_SkSeirituRituRn.ZRNCREDITMIRYOU)
    public String getZrncreditmiryou() {
        return zrncreditmiryou;
    }

    public void setZrncreditmiryou(String pZrncreditmiryou) {
        zrncreditmiryou = pZrncreditmiryou;
    }

    private String zrnkzktrkservicekbn;

    @Column(name=GenZT_SkSeirituRituRn.ZRNKZKTRKSERVICEKBN)
    public String getZrnkzktrkservicekbn() {
        return zrnkzktrkservicekbn;
    }

    public void setZrnkzktrkservicekbn(String pZrnkzktrkservicekbn) {
        zrnkzktrkservicekbn = pZrnkzktrkservicekbn;
    }

    private String zrnkykdrtkykarihyj;

    @Column(name=GenZT_SkSeirituRituRn.ZRNKYKDRTKYKARIHYJ)
    public String getZrnkykdrtkykarihyj() {
        return zrnkykdrtkykarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkykdrtkykarihyj(String pZrnkykdrtkykarihyj) {
        zrnkykdrtkykarihyj = pZrnkykdrtkykarihyj;
    }

    private String zrnstdairiseikyuutkykarihyj;

    @Column(name=GenZT_SkSeirituRituRn.ZRNSTDAIRISEIKYUUTKYKARIHYJ)
    public String getZrnstdairiseikyuutkykarihyj() {
        return zrnstdairiseikyuutkykarihyj;
    }

    public void setZrnstdairiseikyuutkykarihyj(String pZrnstdairiseikyuutkykarihyj) {
        zrnstdairiseikyuutkykarihyj = pZrnstdairiseikyuutkykarihyj;
    }

    private String zrnyakkanjyuryouhoukbn;

    @Column(name=GenZT_SkSeirituRituRn.ZRNYAKKANJYURYOUHOUKBN)
    public String getZrnyakkanjyuryouhoukbn() {
        return zrnyakkanjyuryouhoukbn;
    }

    public void setZrnyakkanjyuryouhoukbn(String pZrnyakkanjyuryouhoukbn) {
        zrnyakkanjyuryouhoukbn = pZrnyakkanjyuryouhoukbn;
    }

    private String zrnyakkanbunsyono;

    @Column(name=GenZT_SkSeirituRituRn.ZRNYAKKANBUNSYONO)
    public String getZrnyakkanbunsyono() {
        return zrnyakkanbunsyono;
    }

    public void setZrnyakkanbunsyono(String pZrnyakkanbunsyono) {
        zrnyakkanbunsyono = pZrnyakkanbunsyono;
    }

    private String zrnkzktuutityokusoukbn;

    @Column(name=GenZT_SkSeirituRituRn.ZRNKZKTUUTITYOKUSOUKBN)
    public String getZrnkzktuutityokusoukbn() {
        return zrnkzktuutityokusoukbn;
    }

    public void setZrnkzktuutityokusoukbn(String pZrnkzktuutityokusoukbn) {
        zrnkzktuutityokusoukbn = pZrnkzktuutityokusoukbn;
    }

    private String zrnyobiv36;

    @Column(name=GenZT_SkSeirituRituRn.ZRNYOBIV36)
    public String getZrnyobiv36() {
        return zrnyobiv36;
    }

    public void setZrnyobiv36(String pZrnyobiv36) {
        zrnyobiv36 = pZrnyobiv36;
    }
}