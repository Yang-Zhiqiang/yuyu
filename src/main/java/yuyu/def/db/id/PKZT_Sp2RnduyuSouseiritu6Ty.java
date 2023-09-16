package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu6Ty;
import yuyu.def.db.mapping.GenZT_Sp2RnduyuSouseiritu6Ty;
import yuyu.def.db.meta.GenQZT_Sp2RnduyuSouseiritu6Ty;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu6Ty;

/**
 * ＳＰ２連動用総成立Fテーブル６（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_Sp2RnduyuSouseiritu6Ty}</td><td colspan="3">ＳＰ２連動用総成立Fテーブル６（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztyktgysyrymd</td><td>（中継用）結合用処理日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyktgysyono ztyktgysyono}</td><td>（中継用）結合用証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyktgyfilerenno</td><td>（中継用）結合用ファイル連番</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyraysystemhyj</td><td>（中継用）ＲＡＹシステム表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygaikakbn</td><td>（中継用）外貨区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykawaserate</td><td>（中継用）為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykawaseratetekiyouymd</td><td>（中継用）為替レート適用年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykjikawaserate</td><td>（中継用）契約時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykykjikawaseratetkyuymd</td><td>（中継用）契約時為替レート適用年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakujiyoteiriritu</td><td>（中継用）契約時予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytumitateriritu</td><td>（中継用）積立利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztysrkyksjkkktyouseiriritu</td><td>（中継用）数理用契約時市場価格調整用利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyenkdtsbujsitihsyukngk</td><td>（中継用）円貨建死亡時最低保証金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykaigomaebaraitkykarihyj</td><td>（中継用）介護前払特約あり表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin1</td><td>（中継用）数理用予備項目Ｎ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysibouhyoukbn</td><td>（中継用）死亡表区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymvatyouseikou</td><td>（中継用）ＭＶＡ調整項</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztynyuukintuukakbn</td><td>（中継用）入金通貨区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhtnknkykliveonearhyj</td><td>（中継用）被転換契約ライブワン有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyliveonepackagesyouhinkbn</td><td>（中継用）ライブワンパッケージ商品区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhtnkngukisisttkknsnp</td><td>（中継用）被転換合計災疾月換算Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztywyendttargetmokuhyouritu</td><td>（中継用）円建Ｗターゲット目標率</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuurendourate</td><td>（中継用）指数連動部分割合</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuukbn</td><td>（中継用）指数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin2</td><td>（中継用）数理用予備項目Ｎ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin10x2</td><td>（中継用）数理用予備項目Ｎ１０＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin10x3</td><td>（中継用）数理用予備項目Ｎ１０＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknzoukaritujygn</td><td>（中継用）積立金増加率上限</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztysetteibairitu</td><td>（中継用）設定倍率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykykymdsisuu</td><td>（中継用）契約日指数</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyrendouritu</td><td>（中継用）連動率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyyobin5</td><td>（中継用）予備項目Ｎ５</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyyobin5x2</td><td>（中継用）予備項目Ｎ５＿２</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyyobiv10x6</td><td>（中継用）予備項目Ｖ１０＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyendttargetkijyunkingaku</td><td>（中継用）円建ターゲット基準金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysisuurentumitatekin</td><td>（中継用）指数連動部分積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytirttmtttumitatekin</td><td>（中継用）定率積立部分積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynksjitirttmttkn</td><td>（中継用）年金開始時定率積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynendomatutirttumitatekin</td><td>（中継用）年度末定率部分積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyuptumitatekin</td><td>（中継用）主契約保険料積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygaikadatenkgns</td><td>（中継用）外貨建年金原資</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytumitatekin</td><td>（中継用）積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykiharaikomip</td><td>（中継用）既払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygaikadatesyukeiyakup</td><td>（中継用）外貨建主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysitivkisnyukykjikwsrate</td><td>（中継用）最低Ｖ計算用契約時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyyobiv16</td><td>（中継用）予備項目Ｖ１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_Sp2RnduyuSouseiritu6Ty
 * @see     GenZT_Sp2RnduyuSouseiritu6Ty
 * @see     QZT_Sp2RnduyuSouseiritu6Ty
 * @see     GenQZT_Sp2RnduyuSouseiritu6Ty
 */
public class PKZT_Sp2RnduyuSouseiritu6Ty extends AbstractExDBPrimaryKey<ZT_Sp2RnduyuSouseiritu6Ty, PKZT_Sp2RnduyuSouseiritu6Ty> {

    private static final long serialVersionUID = 1L;

    public PKZT_Sp2RnduyuSouseiritu6Ty() {
    }

    public PKZT_Sp2RnduyuSouseiritu6Ty(String pZtyktgysyono) {
        ztyktgysyono = pZtyktgysyono;
    }

    @Transient
    @Override
    public Class<ZT_Sp2RnduyuSouseiritu6Ty> getEntityClass() {
        return ZT_Sp2RnduyuSouseiritu6Ty.class;
    }

    private String ztyktgysyono;

    public String getZtyktgysyono() {
        return ztyktgysyono;
    }

    public void setZtyktgysyono(String pZtyktgysyono) {
        ztyktgysyono = pZtyktgysyono;
    }

}