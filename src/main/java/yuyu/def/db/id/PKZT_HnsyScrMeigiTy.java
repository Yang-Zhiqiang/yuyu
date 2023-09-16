package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_HnsyScrMeigiTy;
import yuyu.def.db.mapping.GenZT_HnsyScrMeigiTy;
import yuyu.def.db.meta.GenQZT_HnsyScrMeigiTy;
import yuyu.def.db.meta.QZT_HnsyScrMeigiTy;

/**
 * 反社スクリーニング用名義データテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_HnsyScrMeigiTy}</td><td colspan="3">反社スクリーニング用名義データテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztyhnsyrecordkbn</td><td>（中継用）反社レコ－ド区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykijyunym</td><td>（中継用）基準年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytaisyounmkn ztytaisyounmkn}</td><td>（中継用）対象者姓名（カナ）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytaisyounmkj ztytaisyounmkj}</td><td>（中継用）対象者姓名（漢字）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytaisyouseiymd ztytaisyouseiymd}</td><td>（中継用）対象者生年月日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytsnsknewyno</td><td>（中継用）通信先新郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytsnsknewtikucd</td><td>（中継用）通信先新地区コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnewyno</td><td>（中継用）被保険者新郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnewtikucd</td><td>（中継用）被保険者新地区コ－ド</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykstkannisknewyno</td><td>（中継用）貸付案内先新郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykstkannisknewtikucd</td><td>（中継用）貸付案内先新地区コ－ド</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydntnewyno</td><td>（中継用）団体新郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydntnewtikucd</td><td>（中継用）団体新地区コ－ド</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykanjitsinkaiadr</td><td>（中継用）漢字通信先下位住所</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytodouhukennm</td><td>（中継用）都道府県名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysigunnm</td><td>（中継用）市郡名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysosikicd1</td><td>（中継用）組織コ－ド１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysosikicd2</td><td>（中継用）組織コ－ド２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysosikicd3</td><td>（中継用）組織コ－ド３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysosikicd4</td><td>（中継用）組織コ－ド４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysosikicd5</td><td>（中継用）組織コ－ド５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknhnsktodouhukencd</td><td>（中継用）被保険者本籍都道府県コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykankeinmkn1</td><td>（中継用）関係者名（カナ）１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykankeinmkn2</td><td>（中継用）関係者名（カナ）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykankeinmkn3</td><td>（中継用）関係者名（カナ）３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykankeinmkn4</td><td>（中継用）関係者名（カナ）４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykankeinmkn5</td><td>（中継用）関係者名（カナ）５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykankeinmkj1</td><td>（中継用）関係者名（漢字）１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykankeinmkj2</td><td>（中継用）関係者名（漢字）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykankeinmkj3</td><td>（中継用）関係者名（漢字）３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykankeinmkj4</td><td>（中継用）関係者名（漢字）４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykankeinmkj5</td><td>（中継用）関係者名（漢字）５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeirokbn</td><td>（中継用）払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydntcd</td><td>（中継用）団体コ－ド</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydntnm</td><td>（中継用）団体名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydntsyzkcd</td><td>（中継用）団体所属コ－ド</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydntkojincd</td><td>（中継用）団体個人コ－ド</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaebankcd</td><td>（中継用）口座振替銀行番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaesitencd</td><td>（中継用）口座振替支店番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaeyokinkbn</td><td>（中継用）口座振替預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaekouzano</td><td>（中継用）口座振替口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytsintelno</td><td>（中継用）通信先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhjncd</td><td>（中継用）法人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhjnjigyosyocd</td><td>（中継用）法人事業所コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysymtymd</td><td>（中継用）消滅年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyokugyoucd</td><td>（中継用）職業コ－ド</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2hhknyno</td><td>（中継用）第２被保険者新郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2hhknnewtikucd</td><td>（中継用）第２被保険者新地区コ－ド</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2hhkntodouhukencd</td><td>（中継用）第２被保険者本籍府県コ－ド</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyokugyoucd2</td><td>（中継用）第２職業コ－ド</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv118</td><td>（中継用）予備項目Ｖ１１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskinnm</td><td>（中継用）索引姓名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv40</td><td>（中継用）予備項目Ｖ４０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtynayosetaisyousegkbn ztynayosetaisyousegkbn}</td><td>（中継用）名寄せ対象者ＳＥＧ区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynayosetaisyoukojinkbn</td><td>（中継用）名寄せ対象者個人区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv46</td><td>（中継用）予備項目Ｖ４６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytodouhukencd1</td><td>（中継用）都道府県コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytodouhukencd2</td><td>（中継用）都道府県コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytodouhukencd3</td><td>（中継用）都道府県コード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv34</td><td>（中継用）予備項目Ｖ３４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoumetucd</td><td>（中継用）消滅コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysymtymd2</td><td>（中継用）消滅年月日＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybohaiyakkandisp</td><td>（中継用）暴排条項導入約款適用表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymeihenymd</td><td>（中継用）名義変更年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyseiymdseitsymd</td><td>（中継用）生年月日性訂正年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzkmrtityuutohukaymd</td><td>（中継用）家族マル定中途付加年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykmfkykknnm</td><td>（中継用）契約ＭＦ契約者カナ姓名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykmfkykkjnm</td><td>（中継用）契約ＭＦ契約者漢字姓名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykmfkykseiymd</td><td>（中継用）契約ＭＦ契約者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykmfhhkknnm</td><td>（中継用）契約ＭＦ被保険者カナ姓名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykmfhhkkjnm</td><td>（中継用）契約ＭＦ被保険者漢字姓名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykmfhhkseiymd</td><td>（中継用）契約ＭＦ被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykmfdai2knnm</td><td>（中継用）契約ＭＦ第２被カナ姓名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykmfdai2kjnm</td><td>（中継用）契約ＭＦ第２被漢字姓名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykmfdai2seiymd</td><td>（中継用）契約ＭＦ第２被生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykmfsbuktknnm</td><td>（中継用）契約ＭＦ死亡受取人カナ姓名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykmfsbuktkjnm</td><td>（中継用）契約ＭＦ死亡受取人漢字姓名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykmfsbuktseiymd</td><td>（中継用）契約ＭＦ死亡受取人生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykmfdai2ktknnm</td><td>（中継用）契約ＭＦ第２受取人カナ姓名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykmfdai2ktkjnm</td><td>（中継用）契約ＭＦ第２受取人漢字姓名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykmfdai2ktseiymd</td><td>（中継用）契約ＭＦ第２受取人生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykmfmnkktknnm</td><td>（中継用）契約ＭＦ満期受取人カナ姓名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykmfmnkktkjnm</td><td>（中継用）契約ＭＦ満期受取人漢字姓名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykmfmnkktseiymd</td><td>（中継用）契約ＭＦ満期受取人生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydntcd2</td><td>（中継用）団体コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjdntnm</td><td>（中継用）漢字団体名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyrinjikaisouhyouji</td><td>（中継用）臨時回送表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv34x2</td><td>（中継用）予備項目Ｖ３４＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysgtaisyoukbn</td><td>（中継用）照合対象区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv39</td><td>（中継用）予備項目Ｖ３９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyuuseihjnnm</td><td>（中継用）修正法人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv75</td><td>（中継用）予備項目Ｖ７５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysysyno</td><td>（中継用）証書番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysueokikaisiymd</td><td>（中継用）据置開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhasseiriyuukbnscreen</td><td>（中継用）発生理由区分（反社スクリーニング）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysueokijtkbn</td><td>（中継用）据置状態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytaisyoufilekbn</td><td>（中継用）対象ファイル区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybohaiyakkandisp2</td><td>（中継用）暴排条項導入約款適用表示２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymeihenymd2</td><td>（中継用）名義変更年月日２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyoumetucd</td><td>（中継用）年金消滅コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv7</td><td>（中継用）予備項目Ｖ７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv20</td><td>（中継用）予備項目Ｖ２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_HnsyScrMeigiTy
 * @see     GenZT_HnsyScrMeigiTy
 * @see     QZT_HnsyScrMeigiTy
 * @see     GenQZT_HnsyScrMeigiTy
 */
public class PKZT_HnsyScrMeigiTy extends AbstractExDBPrimaryKey<ZT_HnsyScrMeigiTy, PKZT_HnsyScrMeigiTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_HnsyScrMeigiTy() {
    }

    public PKZT_HnsyScrMeigiTy(
        String pZtytaisyounmkn,
        String pZtytaisyounmkj,
        String pZtytaisyouseiymd,
        String pZtynayosetaisyousegkbn,
        String pZtysyono
    ) {
        ztytaisyounmkn = pZtytaisyounmkn;
        ztytaisyounmkj = pZtytaisyounmkj;
        ztytaisyouseiymd = pZtytaisyouseiymd;
        ztynayosetaisyousegkbn = pZtynayosetaisyousegkbn;
        ztysyono = pZtysyono;
    }

    @Transient
    @Override
    public Class<ZT_HnsyScrMeigiTy> getEntityClass() {
        return ZT_HnsyScrMeigiTy.class;
    }

    private String ztytaisyounmkn;

    public String getZtytaisyounmkn() {
        return ztytaisyounmkn;
    }

    public void setZtytaisyounmkn(String pZtytaisyounmkn) {
        ztytaisyounmkn = pZtytaisyounmkn;
    }
    private String ztytaisyounmkj;

    public String getZtytaisyounmkj() {
        return ztytaisyounmkj;
    }

    public void setZtytaisyounmkj(String pZtytaisyounmkj) {
        ztytaisyounmkj = pZtytaisyounmkj;
    }
    private String ztytaisyouseiymd;

    public String getZtytaisyouseiymd() {
        return ztytaisyouseiymd;
    }

    public void setZtytaisyouseiymd(String pZtytaisyouseiymd) {
        ztytaisyouseiymd = pZtytaisyouseiymd;
    }
    private String ztynayosetaisyousegkbn;

    public String getZtynayosetaisyousegkbn() {
        return ztynayosetaisyousegkbn;
    }

    public void setZtynayosetaisyousegkbn(String pZtynayosetaisyousegkbn) {
        ztynayosetaisyousegkbn = pZtynayosetaisyousegkbn;
    }
    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

}