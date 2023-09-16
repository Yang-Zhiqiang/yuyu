package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr6Rn;
import yuyu.def.db.mapping.GenZT_Skeiksnbsgetujisr6Rn;
import yuyu.def.db.meta.GenQZT_Skeiksnbsgetujisr6Rn;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr6Rn;

/**
 * 新契約決算ベース月次成立Ｆテーブル６（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_Skeiksnbsgetujisr6Rn}</td><td colspan="3">新契約決算ベース月次成立Ｆテーブル６（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrnktgysyrymd</td><td>（連携用）結合用処理日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnktgysyono zrnktgysyono}</td><td>（連携用）結合用証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnktgyfilerenno</td><td>（連携用）結合用ファイル連番</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnraysystemhyj</td><td>（連携用）ＲＡＹシステム表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngaikakbn</td><td>（連携用）外貨区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkawaserate</td><td>（連携用）為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnkawaseratetekiyouymd</td><td>（連携用）為替レート適用年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykjikawaserate</td><td>（連携用）契約時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnkykjikawaseratetkyuymd</td><td>（連携用）契約時為替レート適用年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeiyakujiyoteiriritu</td><td>（連携用）契約時予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntumitateriritu</td><td>（連携用）積立利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnsrkyksjkkktyouseiriritu</td><td>（連携用）数理用契約時市場価格調整用利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnenkdtsbujsitihsyukngk</td><td>（連携用）円貨建死亡時最低保証金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkaigomaebaraitkykarihyj</td><td>（連携用）介護前払特約あり表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuuriyouyobin1</td><td>（連携用）数理用予備項目Ｎ１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsibouhyoukbn</td><td>（連携用）死亡表区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmvatyouseikou</td><td>（連携用）ＭＶＡ調整項</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnnyuukintuukakbn</td><td>（連携用）入金通貨区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnknkykliveonearhyj</td><td>（連携用）被転換契約ライブワン有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnliveonepackagesyouhinkbn</td><td>（連携用）ライブワンパッケージ商品区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtnkngukisisttkknsnp</td><td>（連携用）被転換合計災疾月換算Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnwyendttargetmokuhyouritu</td><td>（連携用）円建Ｗターゲット目標率</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuurendourate</td><td>（連携用）指数連動部分割合</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuukbn</td><td>（連携用）指数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsrdai1hknkkn</td><td>（連携用）数理用第１保険期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuuriyouyobin10x2</td><td>（連携用）数理用予備項目Ｎ１０＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuuriyouyobin10x3</td><td>（連携用）数理用予備項目Ｎ１０＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknzoukaritujygn</td><td>（連携用）積立金増加率上限</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnsetteibairitu</td><td>（連携用）設定倍率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnkykymdsisuu</td><td>（連携用）契約日指数</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnrendouritu</td><td>（連携用）連動率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnyobin5</td><td>（連携用）予備項目Ｎ５</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnyobin5x2</td><td>（連携用）予備項目Ｎ５＿２</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrntuukasyukbn</td><td>（連携用）通貨種類区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv9x2</td><td>（連携用）予備項目Ｖ９＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyendttargetkijyunkingaku</td><td>（連携用）円建ターゲット基準金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsisuurentumitatekin</td><td>（連携用）指数連動部分積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntirttmtttumitatekin</td><td>（連携用）定率積立部分積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnksjitirttmttkn</td><td>（連携用）年金開始時定率積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnendomatutirttumitatekin</td><td>（連携用）年度末定率部分積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyuptumitatekin</td><td>（連携用）主契約保険料積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngaikadatenkgns</td><td>（連携用）外貨建年金原資</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntumitatekin</td><td>（連携用）積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkiharaikomip</td><td>（連携用）既払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngaikadatesyukeiyakup</td><td>（連携用）外貨建主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsitivkisnyukykjikwsrate</td><td>（連携用）最低Ｖ計算用契約時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnyobiv16</td><td>（連携用）予備項目Ｖ１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_Skeiksnbsgetujisr6Rn
 * @see     GenZT_Skeiksnbsgetujisr6Rn
 * @see     QZT_Skeiksnbsgetujisr6Rn
 * @see     GenQZT_Skeiksnbsgetujisr6Rn
 */
public class PKZT_Skeiksnbsgetujisr6Rn extends AbstractExDBPrimaryKey<ZT_Skeiksnbsgetujisr6Rn, PKZT_Skeiksnbsgetujisr6Rn> {

    private static final long serialVersionUID = 1L;

    public PKZT_Skeiksnbsgetujisr6Rn() {
    }

    public PKZT_Skeiksnbsgetujisr6Rn(String pZrnktgysyono) {
        zrnktgysyono = pZrnktgysyono;
    }

    @Transient
    @Override
    public Class<ZT_Skeiksnbsgetujisr6Rn> getEntityClass() {
        return ZT_Skeiksnbsgetujisr6Rn.class;
    }

    private String zrnktgysyono;

    public String getZrnktgysyono() {
        return zrnktgysyono;
    }

    public void setZrnktgysyono(String pZrnktgysyono) {
        zrnktgysyono = pZrnktgysyono;
    }

}