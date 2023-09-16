package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SkSeirituRituTy;
import yuyu.def.db.mapping.GenZT_SkSeirituRituTy;
import yuyu.def.db.meta.GenQZT_SkSeirituRituTy;
import yuyu.def.db.meta.QZT_SkSeirituRituTy;

/**
 * 新契約成立率Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SkSeirituRituTy}</td><td colspan="3">新契約成立率Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyeigyouhonbusisyacd ztyeigyouhonbusisyacd}</td><td>（中継用）営業本部支社コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisyanm</td><td>（中継用）支社名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysosikicd ztysosikicd}</td><td>（中継用）組織コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykanjisosikinm20</td><td>（中継用）漢字組織名（２０文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatukaisyadrtenhyouji</td><td>（中継用）扱者代理店表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyatukaikojincd ztyatukaikojincd}</td><td>（中継用）扱者個人コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytansyukukjatukaisyanm</td><td>（中継用）短縮漢字扱者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtymosno ztymosno}</td><td>（中継用）申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknjhhknmei</td><td>（中継用）漢字被保険者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnen2keta</td><td>（中継用）被保険者年令（２桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyanen</td><td>（中継用）契約者年令</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymosym</td><td>（中継用）申込月度</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymosnyuuryokuymd</td><td>（中継用）申込入力年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymoskbn</td><td>（中継用）申込区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymossyoumetukbn</td><td>（中継用）申込消滅区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymossyumtkktymd</td><td>（中継用）申込消滅確定年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykurikosiriyuukbn</td><td>（中継用）繰越理由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynyknzumihyouji</td><td>（中継用）入金済表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynyknjkkbn</td><td>（中継用）入金状況区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyketjkkbn</td><td>（中継用）決定状況区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhiktjyoutaikbn</td><td>（中継用）諾否決定状態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykokutiymd</td><td>（中継用）告知年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhjykktkbn</td><td>（中継用）報状告知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuteikanikokutikbn</td><td>（中継用）特定簡易告知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhikettikekkacd</td><td>（中継用）諾否決定結果コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysinhsys</td><td>（中継用）新保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyjyunhsys</td><td>（中継用）純保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhsys</td><td>（中継用）保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysoukensuu</td><td>（中継用）総件数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztytoukeihknsyruikbn</td><td>（中継用）統計用保険種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkaisuukbn</td><td>（中継用）払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeirokbn</td><td>（中継用）払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykktaikbn</td><td>（中継用）契約形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsudirtnatkikeitaikbn</td><td>（中継用）募集代理店扱形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokusyujimutoriatukaikbn</td><td>（中継用）特殊事務取扱区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihonhubi</td><td>（中継用）基本不備</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysphubi</td><td>（中継用）ＳＰ不備</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysseigenhubi</td><td>（中継用）Ｓ制限不備</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynayosehumei</td><td>（中継用）名寄不明</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytuusangendoover</td><td>（中継用）通算限度オーバー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymosketteihoryuu</td><td>（中継用）申込決定保留</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykkakjissityuu</td><td>（中継用）契約確認実施中</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykktketteihoryuu</td><td>（中継用）告知決定保留</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhonsyakethoryuu</td><td>（中継用）本社決定保留</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyseiymdhubi</td><td>（中継用）生年月日不備</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyphusoku</td><td>（中継用）Ｐ不足</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysrhuketyu</td><td>（中継用）成立保留受付中</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypkakin</td><td>（中継用）Ｐ過金</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymostoutyakuymd</td><td>（中継用）申込書到着年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykkttoutyakuymd</td><td>（中継用）告知書到着年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysakuseiymd</td><td>（中継用）作成日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyokaipnyuknhuhukbn2</td><td>（中継用）初回Ｐ入金方法区分（２文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyokaiharaikomip</td><td>（中継用）初回払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyryousyuuymd</td><td>（中継用）領収年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakukakuninsyuruikbn</td><td>（中継用）契約確認種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykkakjkkbn1</td><td>（中継用）契約確認状況区分（1文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymusymd</td><td>（中継用）申込年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymossyosakuseiymd</td><td>（中継用）申込書作成年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyosakuseiymd</td><td>（中継用）証券作成年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkyknm</td><td>（中継用）漢字契約者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknkyknm18</td><td>（中継用）カナ契約者名（１８文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyseirituyoukihontikucd</td><td>（中継用）成立率用基本地区コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymosksnym</td><td>（中継用）申込起算年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyohurimiryou</td><td>（中継用）預振未了</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycreditmiryou</td><td>（中継用）クレカ未了</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzktrkservicekbn</td><td>（中継用）ご家族登録サービス区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykdrtkykarihyj</td><td>（中継用）契約者代理特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztystdairiseikyuutkykarihyj</td><td>（中継用）指定代理請求特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyakkanjyuryouhoukbn</td><td>（中継用）約款受領方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyakkanbunsyono</td><td>（中継用）約款文書番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzktuutityokusoukbn</td><td>（中継用）ご家族通知直送区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv36</td><td>（中継用）予備項目Ｖ３６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SkSeirituRituTy
 * @see     GenZT_SkSeirituRituTy
 * @see     QZT_SkSeirituRituTy
 * @see     GenQZT_SkSeirituRituTy
 */
public class PKZT_SkSeirituRituTy extends AbstractExDBPrimaryKey<ZT_SkSeirituRituTy, PKZT_SkSeirituRituTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_SkSeirituRituTy() {
    }

    public PKZT_SkSeirituRituTy(
        String pZtyeigyouhonbusisyacd,
        String pZtysosikicd,
        String pZtyatukaikojincd,
        String pZtymosno
    ) {
        ztyeigyouhonbusisyacd = pZtyeigyouhonbusisyacd;
        ztysosikicd = pZtysosikicd;
        ztyatukaikojincd = pZtyatukaikojincd;
        ztymosno = pZtymosno;
    }

    @Transient
    @Override
    public Class<ZT_SkSeirituRituTy> getEntityClass() {
        return ZT_SkSeirituRituTy.class;
    }

    private String ztyeigyouhonbusisyacd;

    public String getZtyeigyouhonbusisyacd() {
        return ztyeigyouhonbusisyacd;
    }

    public void setZtyeigyouhonbusisyacd(String pZtyeigyouhonbusisyacd) {
        ztyeigyouhonbusisyacd = pZtyeigyouhonbusisyacd;
    }
    private String ztysosikicd;

    public String getZtysosikicd() {
        return ztysosikicd;
    }

    public void setZtysosikicd(String pZtysosikicd) {
        ztysosikicd = pZtysosikicd;
    }
    private String ztyatukaikojincd;

    public String getZtyatukaikojincd() {
        return ztyatukaikojincd;
    }

    public void setZtyatukaikojincd(String pZtyatukaikojincd) {
        ztyatukaikojincd = pZtyatukaikojincd;
    }
    private String ztymosno;

    public String getZtymosno() {
        return ztymosno;
    }

    public void setZtymosno(String pZtymosno) {
        ztymosno = pZtymosno;
    }

}