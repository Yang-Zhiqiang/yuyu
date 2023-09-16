package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_HnsyScrMeigiRn;
import yuyu.def.db.mapping.GenZT_HnsyScrMeigiRn;
import yuyu.def.db.meta.GenQZT_HnsyScrMeigiRn;
import yuyu.def.db.meta.QZT_HnsyScrMeigiRn;

/**
 * 反社スクリーニング用名義データテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_HnsyScrMeigiRn}</td><td colspan="3">反社スクリーニング用名義データテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrnhnsyrecordkbn</td><td>（連携用）反社レコ－ド区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkijyunym</td><td>（連携用）基準年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntaisyounmkn zrntaisyounmkn}</td><td>（連携用）対象者姓名（カナ）</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntaisyounmkj zrntaisyounmkj}</td><td>（連携用）対象者姓名（漢字）</td><td align="center">○</td><td align="center">G</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntaisyouseiymd zrntaisyouseiymd}</td><td>（連携用）対象者生年月日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsnsknewyno</td><td>（連携用）通信先新郵便番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsnsknewtikucd</td><td>（連携用）通信先新地区コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnewyno</td><td>（連携用）被保険者新郵便番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnewtikucd</td><td>（連携用）被保険者新地区コ－ド</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkstkannisknewyno</td><td>（連携用）貸付案内先新郵便番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkstkannisknewtikucd</td><td>（連携用）貸付案内先新地区コ－ド</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndntnewyno</td><td>（連携用）団体新郵便番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndntnewtikucd</td><td>（連携用）団体新地区コ－ド</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkanjitsinkaiadr</td><td>（連携用）漢字通信先下位住所</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntodouhukennm</td><td>（連携用）都道府県名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsigunnm</td><td>（連携用）市郡名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsosikicd1</td><td>（連携用）組織コ－ド１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsosikicd2</td><td>（連携用）組織コ－ド２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsosikicd3</td><td>（連携用）組織コ－ド３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsosikicd4</td><td>（連携用）組織コ－ド４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsosikicd5</td><td>（連携用）組織コ－ド５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknhnsktodouhukencd</td><td>（連携用）被保険者本籍都道府県コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkankeinmkn1</td><td>（連携用）関係者名（カナ）１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkankeinmkn2</td><td>（連携用）関係者名（カナ）２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkankeinmkn3</td><td>（連携用）関係者名（カナ）３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkankeinmkn4</td><td>（連携用）関係者名（カナ）４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkankeinmkn5</td><td>（連携用）関係者名（カナ）５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkankeinmkj1</td><td>（連携用）関係者名（漢字）１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkankeinmkj2</td><td>（連携用）関係者名（漢字）２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkankeinmkj3</td><td>（連携用）関係者名（漢字）３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkankeinmkj4</td><td>（連携用）関係者名（漢字）４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkankeinmkj5</td><td>（連携用）関係者名（漢字）５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkeirokbn</td><td>（連携用）払込経路区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndntcd</td><td>（連携用）団体コ－ド</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndntnm</td><td>（連携用）団体名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndntsyzkcd</td><td>（連携用）団体所属コ－ド</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndntkojincd</td><td>（連携用）団体個人コ－ド</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaebankcd</td><td>（連携用）口座振替銀行番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaesitencd</td><td>（連携用）口座振替支店番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaeyokinkbn</td><td>（連携用）口座振替預金種目区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaekouzano</td><td>（連携用）口座振替口座番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsintelno</td><td>（連携用）通信先電話番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhjncd</td><td>（連携用）法人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhjnjigyosyocd</td><td>（連携用）法人事業所コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsymtymd</td><td>（連携用）消滅年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyokugyoucd</td><td>（連携用）職業コ－ド</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2hhknyno</td><td>（連携用）第２被保険者新郵便番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2hhknnewtikucd</td><td>（連携用）第２被保険者新地区コ－ド</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2hhkntodouhukencd</td><td>（連携用）第２被保険者本籍府県コ－ド</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyokugyoucd2</td><td>（連携用）第２職業コ－ド</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv118</td><td>（連携用）予備項目Ｖ１１８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskinnm</td><td>（連携用）索引姓名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv40</td><td>（連携用）予備項目Ｖ４０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnnayosetaisyousegkbn zrnnayosetaisyousegkbn}</td><td>（連携用）名寄せ対象者ＳＥＧ区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnayosetaisyoukojinkbn</td><td>（連携用）名寄せ対象者個人区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv46</td><td>（連携用）予備項目Ｖ４６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntodouhukencd1</td><td>（連携用）都道府県コード１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntodouhukencd2</td><td>（連携用）都道府県コード２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntodouhukencd3</td><td>（連携用）都道府県コード３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv34</td><td>（連携用）予備項目Ｖ３４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoumetucd</td><td>（連携用）消滅コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsymtymd2</td><td>（連携用）消滅年月日＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbohaiyakkandisp</td><td>（連携用）暴排条項導入約款適用表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmeihenymd</td><td>（連携用）名義変更年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseiymdseitsymd</td><td>（連携用）生年月日性訂正年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzkmrtityuutohukaymd</td><td>（連携用）家族マル定中途付加年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykmfkykknnm</td><td>（連携用）契約ＭＦ契約者カナ姓名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykmfkykkjnm</td><td>（連携用）契約ＭＦ契約者漢字姓名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkykmfkykseiymd</td><td>（連携用）契約ＭＦ契約者生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykmfhhkknnm</td><td>（連携用）契約ＭＦ被保険者カナ姓名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykmfhhkkjnm</td><td>（連携用）契約ＭＦ被保険者漢字姓名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkykmfhhkseiymd</td><td>（連携用）契約ＭＦ被保険者生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykmfdai2knnm</td><td>（連携用）契約ＭＦ第２被カナ姓名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykmfdai2kjnm</td><td>（連携用）契約ＭＦ第２被漢字姓名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkykmfdai2seiymd</td><td>（連携用）契約ＭＦ第２被生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykmfsbuktknnm</td><td>（連携用）契約ＭＦ死亡受取人カナ姓名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykmfsbuktkjnm</td><td>（連携用）契約ＭＦ死亡受取人漢字姓名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkykmfsbuktseiymd</td><td>（連携用）契約ＭＦ死亡受取人生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykmfdai2ktknnm</td><td>（連携用）契約ＭＦ第２受取人カナ姓名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykmfdai2ktkjnm</td><td>（連携用）契約ＭＦ第２受取人漢字姓名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkykmfdai2ktseiymd</td><td>（連携用）契約ＭＦ第２受取人生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykmfmnkktknnm</td><td>（連携用）契約ＭＦ満期受取人カナ姓名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykmfmnkktkjnm</td><td>（連携用）契約ＭＦ満期受取人漢字姓名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkykmfmnkktseiymd</td><td>（連携用）契約ＭＦ満期受取人生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndntcd2</td><td>（連携用）団体コード２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjdntnm</td><td>（連携用）漢字団体名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnrinjikaisouhyouji</td><td>（連携用）臨時回送表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv34x2</td><td>（連携用）予備項目Ｖ３４＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsgtaisyoukbn</td><td>（連携用）照合対象区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv39</td><td>（連携用）予備項目Ｖ３９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyuuseihjnnm</td><td>（連携用）修正法人名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv75</td><td>（連携用）予備項目Ｖ７５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsysyno</td><td>（連携用）証書番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsueokikaisiymd</td><td>（連携用）据置開始年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhasseiriyuukbnscreen</td><td>（連携用）発生理由区分（反社スクリーニング）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsueokijtkbn</td><td>（連携用）据置状態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntaisyoufilekbn</td><td>（連携用）対象ファイル区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbohaiyakkandisp2</td><td>（連携用）暴排条項導入約款適用表示２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmeihenymd2</td><td>（連携用）名義変更年月日２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyoumetucd</td><td>（連携用）年金消滅コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv7</td><td>（連携用）予備項目Ｖ７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv20</td><td>（連携用）予備項目Ｖ２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_HnsyScrMeigiRn
 * @see     GenZT_HnsyScrMeigiRn
 * @see     QZT_HnsyScrMeigiRn
 * @see     GenQZT_HnsyScrMeigiRn
 */
public class PKZT_HnsyScrMeigiRn extends AbstractExDBPrimaryKey<ZT_HnsyScrMeigiRn, PKZT_HnsyScrMeigiRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_HnsyScrMeigiRn() {
    }

    public PKZT_HnsyScrMeigiRn(
        String pZrntaisyounmkn,
        String pZrntaisyounmkj,
        String pZrntaisyouseiymd,
        String pZrnnayosetaisyousegkbn,
        String pZrnsyono
    ) {
        zrntaisyounmkn = pZrntaisyounmkn;
        zrntaisyounmkj = pZrntaisyounmkj;
        zrntaisyouseiymd = pZrntaisyouseiymd;
        zrnnayosetaisyousegkbn = pZrnnayosetaisyousegkbn;
        zrnsyono = pZrnsyono;
    }

    @Transient
    @Override
    public Class<ZT_HnsyScrMeigiRn> getEntityClass() {
        return ZT_HnsyScrMeigiRn.class;
    }

    private String zrntaisyounmkn;

    public String getZrntaisyounmkn() {
        return zrntaisyounmkn;
    }

    public void setZrntaisyounmkn(String pZrntaisyounmkn) {
        zrntaisyounmkn = pZrntaisyounmkn;
    }
    private String zrntaisyounmkj;

    public String getZrntaisyounmkj() {
        return zrntaisyounmkj;
    }

    public void setZrntaisyounmkj(String pZrntaisyounmkj) {
        zrntaisyounmkj = pZrntaisyounmkj;
    }
    private String zrntaisyouseiymd;

    public String getZrntaisyouseiymd() {
        return zrntaisyouseiymd;
    }

    public void setZrntaisyouseiymd(String pZrntaisyouseiymd) {
        zrntaisyouseiymd = pZrntaisyouseiymd;
    }
    private String zrnnayosetaisyousegkbn;

    public String getZrnnayosetaisyousegkbn() {
        return zrnnayosetaisyousegkbn;
    }

    public void setZrnnayosetaisyousegkbn(String pZrnnayosetaisyousegkbn) {
        zrnnayosetaisyousegkbn = pZrnnayosetaisyousegkbn;
    }
    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

}