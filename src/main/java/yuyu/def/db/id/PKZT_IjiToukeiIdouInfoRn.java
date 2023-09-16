package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_IjiToukeiIdouInfoRn;
import yuyu.def.db.mapping.GenZT_IjiToukeiIdouInfoRn;
import yuyu.def.db.meta.GenQZT_IjiToukeiIdouInfoRn;
import yuyu.def.db.meta.QZT_IjiToukeiIdouInfoRn;

/**
 * 医事統計異動情報テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_IjiToukeiIdouInfoRn}</td><td colspan="3">医事統計異動情報テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoriymd</td><td>（連携用）処理年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkykmfksnctr zrnkykmfksnctr}</td><td>（連携用）契約ＭＦ更新ＣＴＲ</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnsyukgu</td><td>（連携用）種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnen2keta</td><td>（連携用）被保険者年令（２桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknseikbn</td><td>（連携用）被保険者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykym</td><td>（連携用）契約年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkisnkihons</td><td>（連携用）計算基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnimustiyusbus</td><td>（連携用）医務査定用死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnshrs</td><td>（連携用）支払Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnshrymd</td><td>（連携用）支払年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsymtgenincd</td><td>（連携用）消滅原因コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeikaym</td><td>（連携用）経過年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsbugenincd</td><td>（連携用）死亡原因コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsyym</td><td>（連携用）募集年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2hhknnen</td><td>（連携用）第２被保険者年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmannenreihyj</td><td>（連携用）満年令表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntignmrtisyukgu</td><td>（連携用）逓減マル定種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnentysihyj</td><td>（連携用）被保険者年令調整表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2hhknnentysihyj</td><td>（連携用）第２被保険者年令調整表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnrenseimrtisyukgu</td><td>（連携用）連生マル定種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbnktjitiktkarihyj</td><td>（連携用）分割時定期特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnlivingneedsshrarihyj</td><td>（連携用）リビングニーズ支払有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnlnkeikaym</td><td>（連携用）ＬＮ経過年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnlnshrgenincd</td><td>（連携用）ＬＮ支払原因コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkituenkbn</td><td>（連携用）喫煙区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkituenhonsuu</td><td>（連携用）喫煙本数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngnspshrhyj</td><td>（連携用）がんサポ支払表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngnspshrkeikaym</td><td>（連携用）がんサポ支払経過年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngnspshrgenincd</td><td>（連携用）がんサポ支払原因コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyunyumrtisyukgu</td><td>（連携用）収入マル定種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsysnymd</td><td>（連携用）初診年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsindanymd</td><td>（連携用）診断年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbyoumeicd1</td><td>（連携用）病名コード１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbyoumeicd2</td><td>（連携用）病名コード２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrnaiyoukbn</td><td>（連携用）支払内容区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngituyuknkbn1</td><td>（連携用）該当要件区分１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngituyuknkbn2</td><td>（連携用）該当要件区分２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyeiebnri1</td><td>（連携用）シェイエ分類１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyeiebnri2</td><td>（連携用）シェイエ分類２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnminnesotacd1</td><td>（連携用）ミネソタコード１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnminnesotacd2</td><td>（連携用）ミネソタコード２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnminnesotacd3</td><td>（連携用）ミネソタコード３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnminnesotacd4</td><td>（連携用）ミネソタコード４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnminnesotacd5</td><td>（連携用）ミネソタコード５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmnsisiensindanjiyuu</td><td>（連携用）慢性膵炎診断事由</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknkuhnsindanjiyuu</td><td>（連携用）肝硬変診断事由</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhushrkbn</td><td>（連携用）不支払区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhushrym</td><td>（連携用）不支払年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyuurouhunoukghasseiymd</td><td>（連携用）就労不能介護傷病発生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyuurouhunoukgjyoutaikbn</td><td>（連携用）就労不能介護状態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokoukahikbn</td><td>（連携用）歩行可否区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnngerkahikbn</td><td>（連携用）寝返り可否区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnihukutyakudatukahikbn</td><td>（連携用）衣服着脱可否区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyykkahikbn</td><td>（連携用）入浴可否区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsykmtssyukahikbn</td><td>（連携用）食物摂取可否区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnfktrsmtkahikbn</td><td>（連携用）拭き取り始末可否区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseiketuseiyoukahikbn</td><td>（連携用）清潔整容可否区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyuurouhunoujyoutaikbn</td><td>（連携用）就労不能状態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyuuseisinkinkousokukbn</td><td>（連携用）急性心筋梗塞区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnousottyuukbn</td><td>（連携用）脳卒中区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjinhuzenkbn</td><td>（連携用）腎不全区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhukasyuksyu</td><td>（連携用）付加主契約種類</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkkbn2</td><td>（連携用）特約区分（２文字）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndoumyakusikkankbn</td><td>（連携用）動脈疾患区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsykikjgykbn</td><td>（連携用）職域事業区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaijyokbn</td><td>（連携用）解除区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsymtymd</td><td>（連携用）消滅年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntyuutohukatkhyj</td><td>（連携用）中途付加特約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyoukigjyutigituymd</td><td>（連携用）要介護状態該当年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyoukigjyutigeninkbn</td><td>（連携用）要介護状態原因区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntihougeninkbn</td><td>（連携用）痴呆原因区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyukgusdkbn</td><td>（連携用）種類記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntignmrtisyukgusdkbn</td><td>（連携用）逓減マル定種類記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnrenseimrtisyukgusdkbn</td><td>（連携用）連生マル定種類記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyunyumrtisyukgusdkbn</td><td>（連携用）収入マル定種類記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsbtoukeiidouinfopmenkbn</td><td>（連携用）死亡統計異動情報Ｐ免区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpmenjikohasseiymd</td><td>（連携用）Ｐ免事故発生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyorino2moji</td><td>（連携用）処理番号（２文字）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnksnym</td><td>（連携用）更新年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnikoujisnskbn</td><td>（連携用）移行時診査区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsysnikoujiym</td><td>（連携用）終身移行時年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnijitoukeiyuksnhyj</td><td>（連携用）医事統計用更新表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsotodasiphkbnmnoshyouji</td><td>（連携用）外出Ｐ不可分見直表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnstdsstkjytkyuhyj</td><td>（連携用）外出新特条適用表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnstdssytikbn</td><td>（連携用）外出集定区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbnktgosnzkkyksyono</td><td>（連携用）分割後存続契約証券番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbnkttnknkbn</td><td>（連携用）分割転換区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykjiqpackhyj</td><td>（連携用）契約時Ｑパック表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbnktjisisttkarihyj</td><td>（連携用）分割時災疾特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsotodasipmenkbn</td><td>（連携用）外出Ｐ免区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnstdssnskbn</td><td>（連携用）外出診査区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobisuuti7x1</td><td>（連携用）予備数値７＿１</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnyobisuuti7x2</td><td>（連携用）予備数値７＿２</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnyobimojihan15</td><td>（連携用）予備文字半角１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobimojihan51</td><td>（連携用）予備文字半角５１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_IjiToukeiIdouInfoRn
 * @see     GenZT_IjiToukeiIdouInfoRn
 * @see     QZT_IjiToukeiIdouInfoRn
 * @see     GenQZT_IjiToukeiIdouInfoRn
 */
public class PKZT_IjiToukeiIdouInfoRn extends AbstractExDBPrimaryKey<ZT_IjiToukeiIdouInfoRn, PKZT_IjiToukeiIdouInfoRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_IjiToukeiIdouInfoRn() {
    }

    public PKZT_IjiToukeiIdouInfoRn(String pZrnsyono, Integer pZrnkykmfksnctr) {
        zrnsyono = pZrnsyono;
        zrnkykmfksnctr = pZrnkykmfksnctr;
    }

    @Transient
    @Override
    public Class<ZT_IjiToukeiIdouInfoRn> getEntityClass() {
        return ZT_IjiToukeiIdouInfoRn.class;
    }

    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }
    private Integer zrnkykmfksnctr;

    public Integer getZrnkykmfksnctr() {
        return zrnkykmfksnctr;
    }

    public void setZrnkykmfksnctr(Integer pZrnkykmfksnctr) {
        zrnkykmfksnctr = pZrnkykmfksnctr;
    }

}