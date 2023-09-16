package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SeirituInfoTy;
import yuyu.def.db.mapping.GenZT_SeirituInfoTy;
import yuyu.def.db.meta.GenQZT_SeirituInfoTy;
import yuyu.def.db.meta.QZT_SeirituInfoTy;

/**
 * 成立情報Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SeirituInfoTy}</td><td colspan="3">成立情報Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtykijyunym ztykijyunym}</td><td>（中継用）基準年月</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyseisekiym</td><td>（中継用）成績計上年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhanbainm</td><td>（中継用）販売名称</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatkisisya</td><td>（中継用）扱支社</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknkkn</td><td>（中継用）保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyphrkkikn</td><td>（中継用）Ｐ払込期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysdpdkbn</td><td>（中継用）Ｓ建Ｐ建区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkaisuukbn</td><td>（中継用）払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeirokbn</td><td>（中継用）払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysinkykryouritukbn</td><td>（中継用）新契約用料率区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyduketorihouhoukbn</td><td>（中継用）Ｄ受取方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihons9</td><td>（中継用）基本Ｓ（９桁）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhsys</td><td>（中継用）保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytkbriknsnhrkp</td><td>（中継用）月払換算払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhhknseikbn</td><td>（中継用）被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyaseikbn</td><td>（中継用）契約者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnen2keta</td><td>（中継用）被保険者年令（２桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyanen</td><td>（中継用）契約者年令</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysykgycd</td><td>（中継用）職業コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyakikykarihyj</td><td>（中継用）契約者既契約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyukigou</td><td>（中継用）保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyokaipnyuukinhouhoukbn</td><td>（中継用）初回Ｐ入金方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytoukeiyousinsakbn</td><td>（中継用）統計用診査区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknsynensyuukbn</td><td>（中継用）被保険者年収区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyukeiyakup</td><td>（中継用）主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztybsudirtnatkikeitaikbn</td><td>（中継用）募集代理店扱形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymd</td><td>（中継用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztystdairiseikyuutkykarihyj</td><td>（中継用）指定代理請求特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymannenreihyj</td><td>（中継用）満年令表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikbn1</td><td>（中継用）年金種類区分（１文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynstkarihyj</td><td>（中継用）年金支払特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyaatkioybsydrtencd</td><td>（中継用）Ａ扱者親募集代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybatkioybsydrtencd</td><td>（中継用）Ｂ扱者親募集代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysinkeiyakujiyoteiriritu</td><td>（中継用）新契約時予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztysiteituukakihons</td><td>（中継用）指定通貨建基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyhrktuukakbn</td><td>（中継用）払込通貨区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysiteituukakbn</td><td>（中継用）指定通貨区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrktuukatukiknznhrkp</td><td>（中継用）払込通貨建月換算払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztysiteituukatukiknznhrkp</td><td>（中継用）指定通貨建月換算払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyyennyknrate</td><td>（中継用）円入金レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztygaikanyknrate</td><td>（中継用）外貨入金レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyjyudkaigomehrtkarihyj</td><td>（中継用）重度介護前払特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyksbyensitihsyutkykrate</td><td>（中継用）初期死亡時円換算最低保証特約用為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztysjkkktyouseiriritu</td><td>（中継用）市場価格調整用利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytargettkmkht</td><td>（中継用）ターゲット特約目標値</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyteirituhaibunwari</td><td>（中継用）定率部分配分割合</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzenkizennouhyouji</td><td>（中継用）全期前納表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypwaribikikbn</td><td>（中継用）Ｐ割引区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypwaribikihanteigk</td><td>（中継用）Ｐ割引判定金額</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztydai1hknkkn</td><td>（中継用）第１保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykdrtkykarihyj</td><td>（中継用）契約者代理特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzktrkservicetrkninzuu</td><td>（中継用）ご家族登録サービス登録人数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteikisiharaiarihyj</td><td>（中継用）定期支払特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv6</td><td>（中継用）予備項目Ｖ６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SeirituInfoTy
 * @see     GenZT_SeirituInfoTy
 * @see     QZT_SeirituInfoTy
 * @see     GenQZT_SeirituInfoTy
 */
public class PKZT_SeirituInfoTy extends AbstractExDBPrimaryKey<ZT_SeirituInfoTy, PKZT_SeirituInfoTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_SeirituInfoTy() {
    }

    public PKZT_SeirituInfoTy(String pZtykijyunym, String pZtysyono) {
        ztykijyunym = pZtykijyunym;
        ztysyono = pZtysyono;
    }

    @Transient
    @Override
    public Class<ZT_SeirituInfoTy> getEntityClass() {
        return ZT_SeirituInfoTy.class;
    }

    private String ztykijyunym;

    public String getZtykijyunym() {
        return ztykijyunym;
    }

    public void setZtykijyunym(String pZtykijyunym) {
        ztykijyunym = pZtykijyunym;
    }
    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

}