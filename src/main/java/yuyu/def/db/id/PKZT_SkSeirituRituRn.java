package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SkSeirituRituRn;
import yuyu.def.db.mapping.GenZT_SkSeirituRituRn;
import yuyu.def.db.meta.GenQZT_SkSeirituRituRn;
import yuyu.def.db.meta.QZT_SkSeirituRituRn;

/**
 * 新契約成立率Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SkSeirituRituRn}</td><td colspan="3">新契約成立率Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrneigyouhonbusisyacd zrneigyouhonbusisyacd}</td><td>（連携用）営業本部支社コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisyanm</td><td>（連携用）支社名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsosikicd zrnsosikicd}</td><td>（連携用）組織コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanjisosikinm20</td><td>（連携用）漢字組織名（２０文字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnatukaisyadrtenhyouji</td><td>（連携用）扱者代理店表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnatukaikojincd zrnatukaikojincd}</td><td>（連携用）扱者個人コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntansyukukjatukaisyanm</td><td>（連携用）短縮漢字扱者名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnmosno zrnmosno}</td><td>（連携用）申込番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknjhhknmei</td><td>（連携用）漢字被保険者名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhhknnen2keta</td><td>（連携用）被保険者年令（２桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyanen</td><td>（連携用）契約者年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmosym</td><td>（連携用）申込月度</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmosnyuuryokuymd</td><td>（連携用）申込入力年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmoskbn</td><td>（連携用）申込区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmossyoumetukbn</td><td>（連携用）申込消滅区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmossyumtkktymd</td><td>（連携用）申込消滅確定年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkurikosiriyuukbn</td><td>（連携用）繰越理由区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyknzumihyouji</td><td>（連携用）入金済表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyknjkkbn</td><td>（連携用）入金状況区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnketjkkbn</td><td>（連携用）決定状況区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhiktjyoutaikbn</td><td>（連携用）諾否決定状態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkokutiymd</td><td>（連携用）告知年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhjykktkbn</td><td>（連携用）報状告知区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuteikanikokutikbn</td><td>（連携用）特定簡易告知区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhikettikekkacd</td><td>（連携用）諾否決定結果コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsinhsys</td><td>（連携用）新保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnjyunhsys</td><td>（連携用）純保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhsys</td><td>（連携用）保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsoukensuu</td><td>（連携用）総件数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrntoukeihknsyruikbn</td><td>（連携用）統計用保険種類区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkaisuukbn</td><td>（連携用）払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkeirokbn</td><td>（連携用）払込経路区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykktaikbn</td><td>（連携用）契約形態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsudirtnatkikeitaikbn</td><td>（連携用）募集代理店扱形態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokusyujimutoriatukaikbn</td><td>（連携用）特殊事務取扱区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihonhubi</td><td>（連携用）基本不備</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsphubi</td><td>（連携用）ＳＰ不備</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsseigenhubi</td><td>（連携用）Ｓ制限不備</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnayosehumei</td><td>（連携用）名寄不明</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntuusangendoover</td><td>（連携用）通算限度オーバー</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmosketteihoryuu</td><td>（連携用）申込決定保留</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykkakjissityuu</td><td>（連携用）契約確認実施中</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkktketteihoryuu</td><td>（連携用）告知決定保留</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhonsyakethoryuu</td><td>（連携用）本社決定保留</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseiymdhubi</td><td>（連携用）生年月日不備</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnphusoku</td><td>（連携用）Ｐ不足</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsrhuketyu</td><td>（連携用）成立保留受付中</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpkakin</td><td>（連携用）Ｐ過金</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmostoutyakuymd</td><td>（連携用）申込書到着年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkkttoutyakuymd</td><td>（連携用）告知書到着年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsakuseiymd</td><td>（連携用）作成日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyokaipnyuknhuhukbn2</td><td>（連携用）初回Ｐ入金方法区分（２文字）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyokaiharaikomip</td><td>（連携用）初回払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnryousyuuymd</td><td>（連携用）領収年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeiyakukakuninsyuruikbn</td><td>（連携用）契約確認種類区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykkakjkkbn1</td><td>（連携用）契約確認状況区分（１文字）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmusymd</td><td>（連携用）申込年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmossyosakuseiymd</td><td>（連携用）申込書作成年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyosakuseiymd</td><td>（連携用）証券作成年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjkyknm</td><td>（連携用）漢字契約者名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnknkyknm18</td><td>（連携用）カナ契約者名（１８文字）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseirituyoukihontikucd</td><td>（連携用）成立率用基本地区コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmosksnym</td><td>（連携用）申込起算年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyohurimiryou</td><td>（連携用）預振未了</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncreditmiryou</td><td>（連携用）クレカ未了</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzktrkservicekbn</td><td>（連携用）ご家族登録サービス区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykdrtkykarihyj</td><td>（連携用）契約者代理特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnstdairiseikyuutkykarihyj</td><td>（連携用）指定代理請求特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyakkanjyuryouhoukbn</td><td>（連携用）約款受領方法区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyakkanbunsyono</td><td>（連携用）約款文書番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzktuutityokusoukbn</td><td>（連携用）ご家族通知直送区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv36</td><td>（連携用）予備項目Ｖ３６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SkSeirituRituRn
 * @see     GenZT_SkSeirituRituRn
 * @see     QZT_SkSeirituRituRn
 * @see     GenQZT_SkSeirituRituRn
 */
public class PKZT_SkSeirituRituRn extends AbstractExDBPrimaryKey<ZT_SkSeirituRituRn, PKZT_SkSeirituRituRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_SkSeirituRituRn() {
    }

    public PKZT_SkSeirituRituRn(
        String pZrneigyouhonbusisyacd,
        String pZrnsosikicd,
        String pZrnatukaikojincd,
        String pZrnmosno
    ) {
        zrneigyouhonbusisyacd = pZrneigyouhonbusisyacd;
        zrnsosikicd = pZrnsosikicd;
        zrnatukaikojincd = pZrnatukaikojincd;
        zrnmosno = pZrnmosno;
    }

    @Transient
    @Override
    public Class<ZT_SkSeirituRituRn> getEntityClass() {
        return ZT_SkSeirituRituRn.class;
    }

    private String zrneigyouhonbusisyacd;

    public String getZrneigyouhonbusisyacd() {
        return zrneigyouhonbusisyacd;
    }

    public void setZrneigyouhonbusisyacd(String pZrneigyouhonbusisyacd) {
        zrneigyouhonbusisyacd = pZrneigyouhonbusisyacd;
    }
    private String zrnsosikicd;

    public String getZrnsosikicd() {
        return zrnsosikicd;
    }

    public void setZrnsosikicd(String pZrnsosikicd) {
        zrnsosikicd = pZrnsosikicd;
    }
    private String zrnatukaikojincd;

    public String getZrnatukaikojincd() {
        return zrnatukaikojincd;
    }

    public void setZrnatukaikojincd(String pZrnatukaikojincd) {
        zrnatukaikojincd = pZrnatukaikojincd;
    }
    private String zrnmosno;

    public String getZrnmosno() {
        return zrnmosno;
    }

    public void setZrnmosno(String pZrnmosno) {
        zrnmosno = pZrnmosno;
    }

}