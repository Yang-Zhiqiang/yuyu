package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_SkSeirituRituTy;
import yuyu.def.db.id.PKZT_SkSeirituRituTy;
import yuyu.def.db.meta.GenQZT_SkSeirituRituTy;
import yuyu.def.db.meta.QZT_SkSeirituRituTy;

/**
 * 新契約成立率Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_SkSeirituRituTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SkSeirituRituTy}</td><td colspan="3">新契約成立率Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtyeigyouhonbusisyacd ztyeigyouhonbusisyacd}</td><td>（中継用）営業本部支社コード</td><td align="center">{@link PKZT_SkSeirituRituTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisyanm ztysisyanm}</td><td>（中継用）支社名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysosikicd ztysosikicd}</td><td>（中継用）組織コード</td><td align="center">{@link PKZT_SkSeirituRituTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanjisosikinm20 ztykanjisosikinm20}</td><td>（中継用）漢字組織名（２０文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatukaisyadrtenhyouji ztyatukaisyadrtenhyouji}</td><td>（中継用）扱者代理店表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatukaikojincd ztyatukaikojincd}</td><td>（中継用）扱者個人コード</td><td align="center">{@link PKZT_SkSeirituRituTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytansyukukjatukaisyanm ztytansyukukjatukaisyanm}</td><td>（中継用）短縮漢字扱者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymosno ztymosno}</td><td>（中継用）申込番号</td><td align="center">{@link PKZT_SkSeirituRituTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknjhhknmei ztyknjhhknmei}</td><td>（中継用）漢字被保険者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnen2keta ztyhhknnen2keta}</td><td>（中継用）被保険者年令（２桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyanen ztykyksyanen}</td><td>（中継用）契約者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymosym ztymosym}</td><td>（中継用）申込月度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymosnyuuryokuymd ztymosnyuuryokuymd}</td><td>（中継用）申込入力年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymoskbn ztymoskbn}</td><td>（中継用）申込区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymossyoumetukbn ztymossyoumetukbn}</td><td>（中継用）申込消滅区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymossyumtkktymd ztymossyumtkktymd}</td><td>（中継用）申込消滅確定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykurikosiriyuukbn ztykurikosiriyuukbn}</td><td>（中継用）繰越理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyknzumihyouji ztynyknzumihyouji}</td><td>（中継用）入金済表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyknjkkbn ztynyknjkkbn}</td><td>（中継用）入金状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketjkkbn ztyketjkkbn}</td><td>（中継用）決定状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhiktjyoutaikbn ztydakuhiktjyoutaikbn}</td><td>（中継用）諾否決定状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykokutiymd ztykokutiymd}</td><td>（中継用）告知年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhjykktkbn ztyhjykktkbn}</td><td>（中継用）報状告知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuteikanikokutikbn ztytokuteikanikokutikbn}</td><td>（中継用）特定簡易告知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhikettikekkacd ztydakuhikettikekkacd}</td><td>（中継用）諾否決定結果コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysinhsys ztysinhsys}</td><td>（中継用）新保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjyunhsys ztyjyunhsys}</td><td>（中継用）純保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhsys ztyhsys}</td><td>（中継用）保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysoukensuu ztysoukensuu}</td><td>（中継用）総件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtytoukeihknsyruikbn ztytoukeihknsyruikbn}</td><td>（中継用）統計用保険種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirokbn ztyhrkkeirokbn}</td><td>（中継用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykktaikbn ztykykktaikbn}</td><td>（中継用）契約形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsudirtnatkikeitaikbn ztybsudirtnatkikeitaikbn}</td><td>（中継用）募集代理店扱形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokusyujimutoriatukaikbn ztytokusyujimutoriatukaikbn}</td><td>（中継用）特殊事務取扱区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihonhubi ztykihonhubi}</td><td>（中継用）基本不備</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysphubi ztysphubi}</td><td>（中継用）ＳＰ不備</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysseigenhubi ztysseigenhubi}</td><td>（中継用）Ｓ制限不備</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynayosehumei ztynayosehumei}</td><td>（中継用）名寄不明</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuusangendoover ztytuusangendoover}</td><td>（中継用）通算限度オーバー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymosketteihoryuu ztymosketteihoryuu}</td><td>（中継用）申込決定保留</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykkakjissityuu ztykykkakjissityuu}</td><td>（中継用）契約確認実施中</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykktketteihoryuu ztykktketteihoryuu}</td><td>（中継用）告知決定保留</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhonsyakethoryuu ztyhonsyakethoryuu}</td><td>（中継用）本社決定保留</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseiymdhubi ztyseiymdhubi}</td><td>（中継用）生年月日不備</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphusoku ztyphusoku}</td><td>（中継用）Ｐ不足</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysrhuketyu ztysrhuketyu}</td><td>（中継用）成立保留受付中</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypkakin ztypkakin}</td><td>（中継用）Ｐ過金</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymostoutyakuymd ztymostoutyakuymd}</td><td>（中継用）申込書到着年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykkttoutyakuymd ztykkttoutyakuymd}</td><td>（中継用）告知書到着年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysakuseiymd ztysakuseiymd}</td><td>（中継用）作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokaipnyuknhuhukbn2 ztysyokaipnyuknhuhukbn2}</td><td>（中継用）初回Ｐ入金方法区分（２文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokaiharaikomip ztysyokaiharaikomip}</td><td>（中継用）初回払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyryousyuuymd ztyryousyuuymd}</td><td>（中継用）領収年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakukakuninsyuruikbn ztykeiyakukakuninsyuruikbn}</td><td>（中継用）契約確認種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykkakjkkbn1 ztykykkakjkkbn1}</td><td>（中継用）契約確認状況区分（1文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymusymd ztymusymd}</td><td>（中継用）申込年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymossyosakuseiymd ztymossyosakuseiymd}</td><td>（中継用）申込書作成年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyosakuseiymd ztysyosakuseiymd}</td><td>（中継用）証券作成年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkyknm ztykjkyknm}</td><td>（中継用）漢字契約者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknkyknm18 ztyknkyknm18}</td><td>（中継用）カナ契約者名（１８文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseirituyoukihontikucd ztyseirituyoukihontikucd}</td><td>（中継用）成立率用基本地区コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymosksnym ztymosksnym}</td><td>（中継用）申込起算年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyohurimiryou ztyyohurimiryou}</td><td>（中継用）預振未了</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycreditmiryou ztycreditmiryou}</td><td>（中継用）クレカ未了</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktrkservicekbn ztykzktrkservicekbn}</td><td>（中継用）ご家族登録サービス区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykdrtkykarihyj ztykykdrtkykarihyj}</td><td>（中継用）契約者代理特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystdairiseikyuutkykarihyj ztystdairiseikyuutkykarihyj}</td><td>（中継用）指定代理請求特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyakkanjyuryouhoukbn ztyyakkanjyuryouhoukbn}</td><td>（中継用）約款受領方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyakkanbunsyono ztyyakkanbunsyono}</td><td>（中継用）約款文書番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktuutityokusoukbn ztykzktuutityokusoukbn}</td><td>（中継用）ご家族通知直送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv36 ztyyobiv36}</td><td>（中継用）予備項目Ｖ３６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SkSeirituRituTy
 * @see     PKZT_SkSeirituRituTy
 * @see     QZT_SkSeirituRituTy
 * @see     GenQZT_SkSeirituRituTy
 */
@MappedSuperclass
@Table(name=GenZT_SkSeirituRituTy.TABLE_NAME)
@IdClass(value=PKZT_SkSeirituRituTy.class)
public abstract class GenZT_SkSeirituRituTy extends AbstractExDBEntity<ZT_SkSeirituRituTy, PKZT_SkSeirituRituTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SkSeirituRituTy";
    public static final String ZTYEIGYOUHONBUSISYACD    = "ztyeigyouhonbusisyacd";
    public static final String ZTYSISYANM               = "ztysisyanm";
    public static final String ZTYSOSIKICD              = "ztysosikicd";
    public static final String ZTYKANJISOSIKINM20       = "ztykanjisosikinm20";
    public static final String ZTYATUKAISYADRTENHYOUJI  = "ztyatukaisyadrtenhyouji";
    public static final String ZTYATUKAIKOJINCD         = "ztyatukaikojincd";
    public static final String ZTYTANSYUKUKJATUKAISYANM = "ztytansyukukjatukaisyanm";
    public static final String ZTYMOSNO                 = "ztymosno";
    public static final String ZTYKNJHHKNMEI            = "ztyknjhhknmei";
    public static final String ZTYHHKNNEN2KETA          = "ztyhhknnen2keta";
    public static final String ZTYKYKSYANEN             = "ztykyksyanen";
    public static final String ZTYMOSYM                 = "ztymosym";
    public static final String ZTYMOSNYUURYOKUYMD       = "ztymosnyuuryokuymd";
    public static final String ZTYMOSKBN                = "ztymoskbn";
    public static final String ZTYMOSSYOUMETUKBN        = "ztymossyoumetukbn";
    public static final String ZTYMOSSYUMTKKTYMD        = "ztymossyumtkktymd";
    public static final String ZTYKURIKOSIRIYUUKBN      = "ztykurikosiriyuukbn";
    public static final String ZTYNYKNZUMIHYOUJI        = "ztynyknzumihyouji";
    public static final String ZTYNYKNJKKBN             = "ztynyknjkkbn";
    public static final String ZTYKETJKKBN              = "ztyketjkkbn";
    public static final String ZTYDAKUHIKTJYOUTAIKBN    = "ztydakuhiktjyoutaikbn";
    public static final String ZTYKOKUTIYMD             = "ztykokutiymd";
    public static final String ZTYHJYKKTKBN             = "ztyhjykktkbn";
    public static final String ZTYTOKUTEIKANIKOKUTIKBN  = "ztytokuteikanikokutikbn";
    public static final String ZTYDAKUHIKETTIKEKKACD    = "ztydakuhikettikekkacd";
    public static final String ZTYSINHSYS               = "ztysinhsys";
    public static final String ZTYJYUNHSYS              = "ztyjyunhsys";
    public static final String ZTYHSYS                  = "ztyhsys";
    public static final String ZTYSOUKENSUU             = "ztysoukensuu";
    public static final String ZTYTOUKEIHKNSYRUIKBN     = "ztytoukeihknsyruikbn";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYHRKKEIROKBN           = "ztyhrkkeirokbn";
    public static final String ZTYKYKKTAIKBN            = "ztykykktaikbn";
    public static final String ZTYBSUDIRTNATKIKEITAIKBN = "ztybsudirtnatkikeitaikbn";
    public static final String ZTYTOKUSYUJIMUTORIATUKAIKBN = "ztytokusyujimutoriatukaikbn";
    public static final String ZTYKIHONHUBI             = "ztykihonhubi";
    public static final String ZTYSPHUBI                = "ztysphubi";
    public static final String ZTYSSEIGENHUBI           = "ztysseigenhubi";
    public static final String ZTYNAYOSEHUMEI           = "ztynayosehumei";
    public static final String ZTYTUUSANGENDOOVER       = "ztytuusangendoover";
    public static final String ZTYMOSKETTEIHORYUU       = "ztymosketteihoryuu";
    public static final String ZTYKYKKAKJISSITYUU       = "ztykykkakjissityuu";
    public static final String ZTYKKTKETTEIHORYUU       = "ztykktketteihoryuu";
    public static final String ZTYHONSYAKETHORYUU       = "ztyhonsyakethoryuu";
    public static final String ZTYSEIYMDHUBI            = "ztyseiymdhubi";
    public static final String ZTYPHUSOKU               = "ztyphusoku";
    public static final String ZTYSRHUKETYU             = "ztysrhuketyu";
    public static final String ZTYPKAKIN                = "ztypkakin";
    public static final String ZTYMOSTOUTYAKUYMD        = "ztymostoutyakuymd";
    public static final String ZTYKKTTOUTYAKUYMD        = "ztykkttoutyakuymd";
    public static final String ZTYSAKUSEIYMD            = "ztysakuseiymd";
    public static final String ZTYSYOKAIPNYUKNHUHUKBN2  = "ztysyokaipnyuknhuhukbn2";
    public static final String ZTYSYOKAIHARAIKOMIP      = "ztysyokaiharaikomip";
    public static final String ZTYRYOUSYUUYMD           = "ztyryousyuuymd";
    public static final String ZTYKEIYAKUKAKUNINSYURUIKBN = "ztykeiyakukakuninsyuruikbn";
    public static final String ZTYKYKKAKJKKBN1          = "ztykykkakjkkbn1";
    public static final String ZTYMUSYMD                = "ztymusymd";
    public static final String ZTYMOSSYOSAKUSEIYMD      = "ztymossyosakuseiymd";
    public static final String ZTYSYOSAKUSEIYMD         = "ztysyosakuseiymd";
    public static final String ZTYKJKYKNM               = "ztykjkyknm";
    public static final String ZTYKNKYKNM18             = "ztyknkyknm18";
    public static final String ZTYSEIRITUYOUKIHONTIKUCD = "ztyseirituyoukihontikucd";
    public static final String ZTYMOSKSNYM              = "ztymosksnym";
    public static final String ZTYYOHURIMIRYOU          = "ztyyohurimiryou";
    public static final String ZTYCREDITMIRYOU          = "ztycreditmiryou";
    public static final String ZTYKZKTRKSERVICEKBN      = "ztykzktrkservicekbn";
    public static final String ZTYKYKDRTKYKARIHYJ       = "ztykykdrtkykarihyj";
    public static final String ZTYSTDAIRISEIKYUUTKYKARIHYJ = "ztystdairiseikyuutkykarihyj";
    public static final String ZTYYAKKANJYURYOUHOUKBN   = "ztyyakkanjyuryouhoukbn";
    public static final String ZTYYAKKANBUNSYONO        = "ztyyakkanbunsyono";
    public static final String ZTYKZKTUUTITYOKUSOUKBN   = "ztykzktuutityokusoukbn";
    public static final String ZTYYOBIV36               = "ztyyobiv36";

    private final PKZT_SkSeirituRituTy primaryKey;

    public GenZT_SkSeirituRituTy() {
        primaryKey = new PKZT_SkSeirituRituTy();
    }

    public GenZT_SkSeirituRituTy(
        String pZtyeigyouhonbusisyacd,
        String pZtysosikicd,
        String pZtyatukaikojincd,
        String pZtymosno
    ) {
        primaryKey = new PKZT_SkSeirituRituTy(
            pZtyeigyouhonbusisyacd,
            pZtysosikicd,
            pZtyatukaikojincd,
            pZtymosno
        );
    }

    @Transient
    @Override
    public PKZT_SkSeirituRituTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SkSeirituRituTy> getMetaClass() {
        return QZT_SkSeirituRituTy.class;
    }

    @Id
    @Column(name=GenZT_SkSeirituRituTy.ZTYEIGYOUHONBUSISYACD)
    public String getZtyeigyouhonbusisyacd() {
        return getPrimaryKey().getZtyeigyouhonbusisyacd();
    }

    public void setZtyeigyouhonbusisyacd(String pZtyeigyouhonbusisyacd) {
        getPrimaryKey().setZtyeigyouhonbusisyacd(pZtyeigyouhonbusisyacd);
    }

    private String ztysisyanm;

    @Column(name=GenZT_SkSeirituRituTy.ZTYSISYANM)
    public String getZtysisyanm() {
        return ztysisyanm;
    }

    public void setZtysisyanm(String pZtysisyanm) {
        ztysisyanm = pZtysisyanm;
    }

    @Id
    @Column(name=GenZT_SkSeirituRituTy.ZTYSOSIKICD)
    public String getZtysosikicd() {
        return getPrimaryKey().getZtysosikicd();
    }

    public void setZtysosikicd(String pZtysosikicd) {
        getPrimaryKey().setZtysosikicd(pZtysosikicd);
    }

    private String ztykanjisosikinm20;

    @Column(name=GenZT_SkSeirituRituTy.ZTYKANJISOSIKINM20)
    public String getZtykanjisosikinm20() {
        return ztykanjisosikinm20;
    }

    public void setZtykanjisosikinm20(String pZtykanjisosikinm20) {
        ztykanjisosikinm20 = pZtykanjisosikinm20;
    }

    private String ztyatukaisyadrtenhyouji;

    @Column(name=GenZT_SkSeirituRituTy.ZTYATUKAISYADRTENHYOUJI)
    public String getZtyatukaisyadrtenhyouji() {
        return ztyatukaisyadrtenhyouji;
    }

    public void setZtyatukaisyadrtenhyouji(String pZtyatukaisyadrtenhyouji) {
        ztyatukaisyadrtenhyouji = pZtyatukaisyadrtenhyouji;
    }

    @Id
    @Column(name=GenZT_SkSeirituRituTy.ZTYATUKAIKOJINCD)
    public String getZtyatukaikojincd() {
        return getPrimaryKey().getZtyatukaikojincd();
    }

    public void setZtyatukaikojincd(String pZtyatukaikojincd) {
        getPrimaryKey().setZtyatukaikojincd(pZtyatukaikojincd);
    }

    private String ztytansyukukjatukaisyanm;

    @Column(name=GenZT_SkSeirituRituTy.ZTYTANSYUKUKJATUKAISYANM)
    public String getZtytansyukukjatukaisyanm() {
        return ztytansyukukjatukaisyanm;
    }

    public void setZtytansyukukjatukaisyanm(String pZtytansyukukjatukaisyanm) {
        ztytansyukukjatukaisyanm = pZtytansyukukjatukaisyanm;
    }

    @Id
    @Column(name=GenZT_SkSeirituRituTy.ZTYMOSNO)
    public String getZtymosno() {
        return getPrimaryKey().getZtymosno();
    }

    public void setZtymosno(String pZtymosno) {
        getPrimaryKey().setZtymosno(pZtymosno);
    }

    private String ztyknjhhknmei;

    @Column(name=GenZT_SkSeirituRituTy.ZTYKNJHHKNMEI)
    public String getZtyknjhhknmei() {
        return ztyknjhhknmei;
    }

    public void setZtyknjhhknmei(String pZtyknjhhknmei) {
        ztyknjhhknmei = pZtyknjhhknmei;
    }

    private String ztyhhknnen2keta;

    @Column(name=GenZT_SkSeirituRituTy.ZTYHHKNNEN2KETA)
    public String getZtyhhknnen2keta() {
        return ztyhhknnen2keta;
    }

    public void setZtyhhknnen2keta(String pZtyhhknnen2keta) {
        ztyhhknnen2keta = pZtyhhknnen2keta;
    }

    private String ztykyksyanen;

    @Column(name=GenZT_SkSeirituRituTy.ZTYKYKSYANEN)
    public String getZtykyksyanen() {
        return ztykyksyanen;
    }

    public void setZtykyksyanen(String pZtykyksyanen) {
        ztykyksyanen = pZtykyksyanen;
    }

    private String ztymosym;

    @Column(name=GenZT_SkSeirituRituTy.ZTYMOSYM)
    public String getZtymosym() {
        return ztymosym;
    }

    public void setZtymosym(String pZtymosym) {
        ztymosym = pZtymosym;
    }

    private String ztymosnyuuryokuymd;

    @Column(name=GenZT_SkSeirituRituTy.ZTYMOSNYUURYOKUYMD)
    public String getZtymosnyuuryokuymd() {
        return ztymosnyuuryokuymd;
    }

    public void setZtymosnyuuryokuymd(String pZtymosnyuuryokuymd) {
        ztymosnyuuryokuymd = pZtymosnyuuryokuymd;
    }

    private String ztymoskbn;

    @Column(name=GenZT_SkSeirituRituTy.ZTYMOSKBN)
    public String getZtymoskbn() {
        return ztymoskbn;
    }

    public void setZtymoskbn(String pZtymoskbn) {
        ztymoskbn = pZtymoskbn;
    }

    private String ztymossyoumetukbn;

    @Column(name=GenZT_SkSeirituRituTy.ZTYMOSSYOUMETUKBN)
    public String getZtymossyoumetukbn() {
        return ztymossyoumetukbn;
    }

    public void setZtymossyoumetukbn(String pZtymossyoumetukbn) {
        ztymossyoumetukbn = pZtymossyoumetukbn;
    }

    private String ztymossyumtkktymd;

    @Column(name=GenZT_SkSeirituRituTy.ZTYMOSSYUMTKKTYMD)
    public String getZtymossyumtkktymd() {
        return ztymossyumtkktymd;
    }

    public void setZtymossyumtkktymd(String pZtymossyumtkktymd) {
        ztymossyumtkktymd = pZtymossyumtkktymd;
    }

    private String ztykurikosiriyuukbn;

    @Column(name=GenZT_SkSeirituRituTy.ZTYKURIKOSIRIYUUKBN)
    public String getZtykurikosiriyuukbn() {
        return ztykurikosiriyuukbn;
    }

    public void setZtykurikosiriyuukbn(String pZtykurikosiriyuukbn) {
        ztykurikosiriyuukbn = pZtykurikosiriyuukbn;
    }

    private String ztynyknzumihyouji;

    @Column(name=GenZT_SkSeirituRituTy.ZTYNYKNZUMIHYOUJI)
    public String getZtynyknzumihyouji() {
        return ztynyknzumihyouji;
    }

    public void setZtynyknzumihyouji(String pZtynyknzumihyouji) {
        ztynyknzumihyouji = pZtynyknzumihyouji;
    }

    private String ztynyknjkkbn;

    @Column(name=GenZT_SkSeirituRituTy.ZTYNYKNJKKBN)
    public String getZtynyknjkkbn() {
        return ztynyknjkkbn;
    }

    public void setZtynyknjkkbn(String pZtynyknjkkbn) {
        ztynyknjkkbn = pZtynyknjkkbn;
    }

    private String ztyketjkkbn;

    @Column(name=GenZT_SkSeirituRituTy.ZTYKETJKKBN)
    public String getZtyketjkkbn() {
        return ztyketjkkbn;
    }

    public void setZtyketjkkbn(String pZtyketjkkbn) {
        ztyketjkkbn = pZtyketjkkbn;
    }

    private String ztydakuhiktjyoutaikbn;

    @Column(name=GenZT_SkSeirituRituTy.ZTYDAKUHIKTJYOUTAIKBN)
    public String getZtydakuhiktjyoutaikbn() {
        return ztydakuhiktjyoutaikbn;
    }

    public void setZtydakuhiktjyoutaikbn(String pZtydakuhiktjyoutaikbn) {
        ztydakuhiktjyoutaikbn = pZtydakuhiktjyoutaikbn;
    }

    private String ztykokutiymd;

    @Column(name=GenZT_SkSeirituRituTy.ZTYKOKUTIYMD)
    public String getZtykokutiymd() {
        return ztykokutiymd;
    }

    public void setZtykokutiymd(String pZtykokutiymd) {
        ztykokutiymd = pZtykokutiymd;
    }

    private String ztyhjykktkbn;

    @Column(name=GenZT_SkSeirituRituTy.ZTYHJYKKTKBN)
    public String getZtyhjykktkbn() {
        return ztyhjykktkbn;
    }

    public void setZtyhjykktkbn(String pZtyhjykktkbn) {
        ztyhjykktkbn = pZtyhjykktkbn;
    }

    private String ztytokuteikanikokutikbn;

    @Column(name=GenZT_SkSeirituRituTy.ZTYTOKUTEIKANIKOKUTIKBN)
    public String getZtytokuteikanikokutikbn() {
        return ztytokuteikanikokutikbn;
    }

    public void setZtytokuteikanikokutikbn(String pZtytokuteikanikokutikbn) {
        ztytokuteikanikokutikbn = pZtytokuteikanikokutikbn;
    }

    private String ztydakuhikettikekkacd;

    @Column(name=GenZT_SkSeirituRituTy.ZTYDAKUHIKETTIKEKKACD)
    public String getZtydakuhikettikekkacd() {
        return ztydakuhikettikekkacd;
    }

    public void setZtydakuhikettikekkacd(String pZtydakuhikettikekkacd) {
        ztydakuhikettikekkacd = pZtydakuhikettikekkacd;
    }

    private Long ztysinhsys;

    @Column(name=GenZT_SkSeirituRituTy.ZTYSINHSYS)
    public Long getZtysinhsys() {
        return ztysinhsys;
    }

    public void setZtysinhsys(Long pZtysinhsys) {
        ztysinhsys = pZtysinhsys;
    }

    private Long ztyjyunhsys;

    @Column(name=GenZT_SkSeirituRituTy.ZTYJYUNHSYS)
    public Long getZtyjyunhsys() {
        return ztyjyunhsys;
    }

    public void setZtyjyunhsys(Long pZtyjyunhsys) {
        ztyjyunhsys = pZtyjyunhsys;
    }

    private Long ztyhsys;

    @Column(name=GenZT_SkSeirituRituTy.ZTYHSYS)
    public Long getZtyhsys() {
        return ztyhsys;
    }

    public void setZtyhsys(Long pZtyhsys) {
        ztyhsys = pZtyhsys;
    }

    private Integer ztysoukensuu;

    @Column(name=GenZT_SkSeirituRituTy.ZTYSOUKENSUU)
    public Integer getZtysoukensuu() {
        return ztysoukensuu;
    }

    public void setZtysoukensuu(Integer pZtysoukensuu) {
        ztysoukensuu = pZtysoukensuu;
    }

    private String ztytoukeihknsyruikbn;

    @Column(name=GenZT_SkSeirituRituTy.ZTYTOUKEIHKNSYRUIKBN)
    public String getZtytoukeihknsyruikbn() {
        return ztytoukeihknsyruikbn;
    }

    public void setZtytoukeihknsyruikbn(String pZtytoukeihknsyruikbn) {
        ztytoukeihknsyruikbn = pZtytoukeihknsyruikbn;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_SkSeirituRituTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztyhrkkeirokbn;

    @Column(name=GenZT_SkSeirituRituTy.ZTYHRKKEIROKBN)
    public String getZtyhrkkeirokbn() {
        return ztyhrkkeirokbn;
    }

    public void setZtyhrkkeirokbn(String pZtyhrkkeirokbn) {
        ztyhrkkeirokbn = pZtyhrkkeirokbn;
    }

    private String ztykykktaikbn;

    @Column(name=GenZT_SkSeirituRituTy.ZTYKYKKTAIKBN)
    public String getZtykykktaikbn() {
        return ztykykktaikbn;
    }

    public void setZtykykktaikbn(String pZtykykktaikbn) {
        ztykykktaikbn = pZtykykktaikbn;
    }

    private String ztybsudirtnatkikeitaikbn;

    @Column(name=GenZT_SkSeirituRituTy.ZTYBSUDIRTNATKIKEITAIKBN)
    public String getZtybsudirtnatkikeitaikbn() {
        return ztybsudirtnatkikeitaikbn;
    }

    public void setZtybsudirtnatkikeitaikbn(String pZtybsudirtnatkikeitaikbn) {
        ztybsudirtnatkikeitaikbn = pZtybsudirtnatkikeitaikbn;
    }

    private String ztytokusyujimutoriatukaikbn;

    @Column(name=GenZT_SkSeirituRituTy.ZTYTOKUSYUJIMUTORIATUKAIKBN)
    public String getZtytokusyujimutoriatukaikbn() {
        return ztytokusyujimutoriatukaikbn;
    }

    public void setZtytokusyujimutoriatukaikbn(String pZtytokusyujimutoriatukaikbn) {
        ztytokusyujimutoriatukaikbn = pZtytokusyujimutoriatukaikbn;
    }

    private String ztykihonhubi;

    @Column(name=GenZT_SkSeirituRituTy.ZTYKIHONHUBI)
    public String getZtykihonhubi() {
        return ztykihonhubi;
    }

    public void setZtykihonhubi(String pZtykihonhubi) {
        ztykihonhubi = pZtykihonhubi;
    }

    private String ztysphubi;

    @Column(name=GenZT_SkSeirituRituTy.ZTYSPHUBI)
    public String getZtysphubi() {
        return ztysphubi;
    }

    public void setZtysphubi(String pZtysphubi) {
        ztysphubi = pZtysphubi;
    }

    private String ztysseigenhubi;

    @Column(name=GenZT_SkSeirituRituTy.ZTYSSEIGENHUBI)
    public String getZtysseigenhubi() {
        return ztysseigenhubi;
    }

    public void setZtysseigenhubi(String pZtysseigenhubi) {
        ztysseigenhubi = pZtysseigenhubi;
    }

    private String ztynayosehumei;

    @Column(name=GenZT_SkSeirituRituTy.ZTYNAYOSEHUMEI)
    public String getZtynayosehumei() {
        return ztynayosehumei;
    }

    public void setZtynayosehumei(String pZtynayosehumei) {
        ztynayosehumei = pZtynayosehumei;
    }

    private String ztytuusangendoover;

    @Column(name=GenZT_SkSeirituRituTy.ZTYTUUSANGENDOOVER)
    public String getZtytuusangendoover() {
        return ztytuusangendoover;
    }

    public void setZtytuusangendoover(String pZtytuusangendoover) {
        ztytuusangendoover = pZtytuusangendoover;
    }

    private String ztymosketteihoryuu;

    @Column(name=GenZT_SkSeirituRituTy.ZTYMOSKETTEIHORYUU)
    public String getZtymosketteihoryuu() {
        return ztymosketteihoryuu;
    }

    public void setZtymosketteihoryuu(String pZtymosketteihoryuu) {
        ztymosketteihoryuu = pZtymosketteihoryuu;
    }

    private String ztykykkakjissityuu;

    @Column(name=GenZT_SkSeirituRituTy.ZTYKYKKAKJISSITYUU)
    public String getZtykykkakjissityuu() {
        return ztykykkakjissityuu;
    }

    public void setZtykykkakjissityuu(String pZtykykkakjissityuu) {
        ztykykkakjissityuu = pZtykykkakjissityuu;
    }

    private String ztykktketteihoryuu;

    @Column(name=GenZT_SkSeirituRituTy.ZTYKKTKETTEIHORYUU)
    public String getZtykktketteihoryuu() {
        return ztykktketteihoryuu;
    }

    public void setZtykktketteihoryuu(String pZtykktketteihoryuu) {
        ztykktketteihoryuu = pZtykktketteihoryuu;
    }

    private String ztyhonsyakethoryuu;

    @Column(name=GenZT_SkSeirituRituTy.ZTYHONSYAKETHORYUU)
    public String getZtyhonsyakethoryuu() {
        return ztyhonsyakethoryuu;
    }

    public void setZtyhonsyakethoryuu(String pZtyhonsyakethoryuu) {
        ztyhonsyakethoryuu = pZtyhonsyakethoryuu;
    }

    private String ztyseiymdhubi;

    @Column(name=GenZT_SkSeirituRituTy.ZTYSEIYMDHUBI)
    public String getZtyseiymdhubi() {
        return ztyseiymdhubi;
    }

    public void setZtyseiymdhubi(String pZtyseiymdhubi) {
        ztyseiymdhubi = pZtyseiymdhubi;
    }

    private String ztyphusoku;

    @Column(name=GenZT_SkSeirituRituTy.ZTYPHUSOKU)
    public String getZtyphusoku() {
        return ztyphusoku;
    }

    public void setZtyphusoku(String pZtyphusoku) {
        ztyphusoku = pZtyphusoku;
    }

    private String ztysrhuketyu;

    @Column(name=GenZT_SkSeirituRituTy.ZTYSRHUKETYU)
    public String getZtysrhuketyu() {
        return ztysrhuketyu;
    }

    public void setZtysrhuketyu(String pZtysrhuketyu) {
        ztysrhuketyu = pZtysrhuketyu;
    }

    private String ztypkakin;

    @Column(name=GenZT_SkSeirituRituTy.ZTYPKAKIN)
    public String getZtypkakin() {
        return ztypkakin;
    }

    public void setZtypkakin(String pZtypkakin) {
        ztypkakin = pZtypkakin;
    }

    private String ztymostoutyakuymd;

    @Column(name=GenZT_SkSeirituRituTy.ZTYMOSTOUTYAKUYMD)
    public String getZtymostoutyakuymd() {
        return ztymostoutyakuymd;
    }

    public void setZtymostoutyakuymd(String pZtymostoutyakuymd) {
        ztymostoutyakuymd = pZtymostoutyakuymd;
    }

    private String ztykkttoutyakuymd;

    @Column(name=GenZT_SkSeirituRituTy.ZTYKKTTOUTYAKUYMD)
    public String getZtykkttoutyakuymd() {
        return ztykkttoutyakuymd;
    }

    public void setZtykkttoutyakuymd(String pZtykkttoutyakuymd) {
        ztykkttoutyakuymd = pZtykkttoutyakuymd;
    }

    private String ztysakuseiymd;

    @Column(name=GenZT_SkSeirituRituTy.ZTYSAKUSEIYMD)
    public String getZtysakuseiymd() {
        return ztysakuseiymd;
    }

    public void setZtysakuseiymd(String pZtysakuseiymd) {
        ztysakuseiymd = pZtysakuseiymd;
    }

    private String ztysyokaipnyuknhuhukbn2;

    @Column(name=GenZT_SkSeirituRituTy.ZTYSYOKAIPNYUKNHUHUKBN2)
    public String getZtysyokaipnyuknhuhukbn2() {
        return ztysyokaipnyuknhuhukbn2;
    }

    public void setZtysyokaipnyuknhuhukbn2(String pZtysyokaipnyuknhuhukbn2) {
        ztysyokaipnyuknhuhukbn2 = pZtysyokaipnyuknhuhukbn2;
    }

    private Long ztysyokaiharaikomip;

    @Column(name=GenZT_SkSeirituRituTy.ZTYSYOKAIHARAIKOMIP)
    public Long getZtysyokaiharaikomip() {
        return ztysyokaiharaikomip;
    }

    public void setZtysyokaiharaikomip(Long pZtysyokaiharaikomip) {
        ztysyokaiharaikomip = pZtysyokaiharaikomip;
    }

    private String ztyryousyuuymd;

    @Column(name=GenZT_SkSeirituRituTy.ZTYRYOUSYUUYMD)
    public String getZtyryousyuuymd() {
        return ztyryousyuuymd;
    }

    public void setZtyryousyuuymd(String pZtyryousyuuymd) {
        ztyryousyuuymd = pZtyryousyuuymd;
    }

    private String ztykeiyakukakuninsyuruikbn;

    @Column(name=GenZT_SkSeirituRituTy.ZTYKEIYAKUKAKUNINSYURUIKBN)
    public String getZtykeiyakukakuninsyuruikbn() {
        return ztykeiyakukakuninsyuruikbn;
    }

    public void setZtykeiyakukakuninsyuruikbn(String pZtykeiyakukakuninsyuruikbn) {
        ztykeiyakukakuninsyuruikbn = pZtykeiyakukakuninsyuruikbn;
    }

    private String ztykykkakjkkbn1;

    @Column(name=GenZT_SkSeirituRituTy.ZTYKYKKAKJKKBN1)
    public String getZtykykkakjkkbn1() {
        return ztykykkakjkkbn1;
    }

    public void setZtykykkakjkkbn1(String pZtykykkakjkkbn1) {
        ztykykkakjkkbn1 = pZtykykkakjkkbn1;
    }

    private String ztymusymd;

    @Column(name=GenZT_SkSeirituRituTy.ZTYMUSYMD)
    public String getZtymusymd() {
        return ztymusymd;
    }

    public void setZtymusymd(String pZtymusymd) {
        ztymusymd = pZtymusymd;
    }

    private String ztymossyosakuseiymd;

    @Column(name=GenZT_SkSeirituRituTy.ZTYMOSSYOSAKUSEIYMD)
    public String getZtymossyosakuseiymd() {
        return ztymossyosakuseiymd;
    }

    public void setZtymossyosakuseiymd(String pZtymossyosakuseiymd) {
        ztymossyosakuseiymd = pZtymossyosakuseiymd;
    }

    private String ztysyosakuseiymd;

    @Column(name=GenZT_SkSeirituRituTy.ZTYSYOSAKUSEIYMD)
    public String getZtysyosakuseiymd() {
        return ztysyosakuseiymd;
    }

    public void setZtysyosakuseiymd(String pZtysyosakuseiymd) {
        ztysyosakuseiymd = pZtysyosakuseiymd;
    }

    private String ztykjkyknm;

    @Column(name=GenZT_SkSeirituRituTy.ZTYKJKYKNM)
    public String getZtykjkyknm() {
        return ztykjkyknm;
    }

    public void setZtykjkyknm(String pZtykjkyknm) {
        ztykjkyknm = pZtykjkyknm;
    }

    private String ztyknkyknm18;

    @Column(name=GenZT_SkSeirituRituTy.ZTYKNKYKNM18)
    public String getZtyknkyknm18() {
        return ztyknkyknm18;
    }

    public void setZtyknkyknm18(String pZtyknkyknm18) {
        ztyknkyknm18 = pZtyknkyknm18;
    }

    private String ztyseirituyoukihontikucd;

    @Column(name=GenZT_SkSeirituRituTy.ZTYSEIRITUYOUKIHONTIKUCD)
    public String getZtyseirituyoukihontikucd() {
        return ztyseirituyoukihontikucd;
    }

    public void setZtyseirituyoukihontikucd(String pZtyseirituyoukihontikucd) {
        ztyseirituyoukihontikucd = pZtyseirituyoukihontikucd;
    }

    private String ztymosksnym;

    @Column(name=GenZT_SkSeirituRituTy.ZTYMOSKSNYM)
    public String getZtymosksnym() {
        return ztymosksnym;
    }

    public void setZtymosksnym(String pZtymosksnym) {
        ztymosksnym = pZtymosksnym;
    }

    private String ztyyohurimiryou;

    @Column(name=GenZT_SkSeirituRituTy.ZTYYOHURIMIRYOU)
    public String getZtyyohurimiryou() {
        return ztyyohurimiryou;
    }

    public void setZtyyohurimiryou(String pZtyyohurimiryou) {
        ztyyohurimiryou = pZtyyohurimiryou;
    }

    private String ztycreditmiryou;

    @Column(name=GenZT_SkSeirituRituTy.ZTYCREDITMIRYOU)
    public String getZtycreditmiryou() {
        return ztycreditmiryou;
    }

    public void setZtycreditmiryou(String pZtycreditmiryou) {
        ztycreditmiryou = pZtycreditmiryou;
    }

    private String ztykzktrkservicekbn;

    @Column(name=GenZT_SkSeirituRituTy.ZTYKZKTRKSERVICEKBN)
    public String getZtykzktrkservicekbn() {
        return ztykzktrkservicekbn;
    }

    public void setZtykzktrkservicekbn(String pZtykzktrkservicekbn) {
        ztykzktrkservicekbn = pZtykzktrkservicekbn;
    }

    private String ztykykdrtkykarihyj;

    @Column(name=GenZT_SkSeirituRituTy.ZTYKYKDRTKYKARIHYJ)
    public String getZtykykdrtkykarihyj() {
        return ztykykdrtkykarihyj;
    }

    public void setZtykykdrtkykarihyj(String pZtykykdrtkykarihyj) {
        ztykykdrtkykarihyj = pZtykykdrtkykarihyj;
    }

    private String ztystdairiseikyuutkykarihyj;

    @Column(name=GenZT_SkSeirituRituTy.ZTYSTDAIRISEIKYUUTKYKARIHYJ)
    public String getZtystdairiseikyuutkykarihyj() {
        return ztystdairiseikyuutkykarihyj;
    }

    public void setZtystdairiseikyuutkykarihyj(String pZtystdairiseikyuutkykarihyj) {
        ztystdairiseikyuutkykarihyj = pZtystdairiseikyuutkykarihyj;
    }

    private String ztyyakkanjyuryouhoukbn;

    @Column(name=GenZT_SkSeirituRituTy.ZTYYAKKANJYURYOUHOUKBN)
    public String getZtyyakkanjyuryouhoukbn() {
        return ztyyakkanjyuryouhoukbn;
    }

    public void setZtyyakkanjyuryouhoukbn(String pZtyyakkanjyuryouhoukbn) {
        ztyyakkanjyuryouhoukbn = pZtyyakkanjyuryouhoukbn;
    }

    private String ztyyakkanbunsyono;

    @Column(name=GenZT_SkSeirituRituTy.ZTYYAKKANBUNSYONO)
    public String getZtyyakkanbunsyono() {
        return ztyyakkanbunsyono;
    }

    public void setZtyyakkanbunsyono(String pZtyyakkanbunsyono) {
        ztyyakkanbunsyono = pZtyyakkanbunsyono;
    }

    private String ztykzktuutityokusoukbn;

    @Column(name=GenZT_SkSeirituRituTy.ZTYKZKTUUTITYOKUSOUKBN)
    public String getZtykzktuutityokusoukbn() {
        return ztykzktuutityokusoukbn;
    }

    public void setZtykzktuutityokusoukbn(String pZtykzktuutityokusoukbn) {
        ztykzktuutityokusoukbn = pZtykzktuutityokusoukbn;
    }

    private String ztyyobiv36;

    @Column(name=GenZT_SkSeirituRituTy.ZTYYOBIV36)
    public String getZtyyobiv36() {
        return ztyyobiv36;
    }

    public void setZtyyobiv36(String pZtyyobiv36) {
        ztyyobiv36 = pZtyyobiv36;
    }
}