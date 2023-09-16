package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_HnsyScrMeigiTy;
import yuyu.def.db.id.PKZT_HnsyScrMeigiTy;
import yuyu.def.db.meta.GenQZT_HnsyScrMeigiTy;
import yuyu.def.db.meta.QZT_HnsyScrMeigiTy;

/**
 * 反社スクリーニング用名義データテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_HnsyScrMeigiTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_HnsyScrMeigiTy}</td><td colspan="3">反社スクリーニング用名義データテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtyhnsyrecordkbn ztyhnsyrecordkbn}</td><td>（中継用）反社レコ－ド区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykijyunym ztykijyunym}</td><td>（中継用）基準年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytaisyounmkn ztytaisyounmkn}</td><td>（中継用）対象者姓名（カナ）</td><td align="center">{@link PKZT_HnsyScrMeigiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytaisyounmkj ztytaisyounmkj}</td><td>（中継用）対象者姓名（漢字）</td><td align="center">{@link PKZT_HnsyScrMeigiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytaisyouseiymd ztytaisyouseiymd}</td><td>（中継用）対象者生年月日</td><td align="center">{@link PKZT_HnsyScrMeigiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsnsknewyno ztytsnsknewyno}</td><td>（中継用）通信先新郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsnsknewtikucd ztytsnsknewtikucd}</td><td>（中継用）通信先新地区コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnewyno ztyhhknnewyno}</td><td>（中継用）被保険者新郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnewtikucd ztyhhknnewtikucd}</td><td>（中継用）被保険者新地区コ－ド</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykstkannisknewyno ztykstkannisknewyno}</td><td>（中継用）貸付案内先新郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykstkannisknewtikucd ztykstkannisknewtikucd}</td><td>（中継用）貸付案内先新地区コ－ド</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydntnewyno ztydntnewyno}</td><td>（中継用）団体新郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydntnewtikucd ztydntnewtikucd}</td><td>（中継用）団体新地区コ－ド</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanjitsinkaiadr ztykanjitsinkaiadr}</td><td>（中継用）漢字通信先下位住所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytodouhukennm ztytodouhukennm}</td><td>（中継用）都道府県名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysigunnm ztysigunnm}</td><td>（中継用）市郡名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysosikicd1 ztysosikicd1}</td><td>（中継用）組織コ－ド１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysosikicd2 ztysosikicd2}</td><td>（中継用）組織コ－ド２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysosikicd3 ztysosikicd3}</td><td>（中継用）組織コ－ド３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysosikicd4 ztysosikicd4}</td><td>（中継用）組織コ－ド４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysosikicd5 ztysosikicd5}</td><td>（中継用）組織コ－ド５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknhnsktodouhukencd ztyhhknhnsktodouhukencd}</td><td>（中継用）被保険者本籍都道府県コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykankeinmkn1 ztykankeinmkn1}</td><td>（中継用）関係者名（カナ）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykankeinmkn2 ztykankeinmkn2}</td><td>（中継用）関係者名（カナ）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykankeinmkn3 ztykankeinmkn3}</td><td>（中継用）関係者名（カナ）３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykankeinmkn4 ztykankeinmkn4}</td><td>（中継用）関係者名（カナ）４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykankeinmkn5 ztykankeinmkn5}</td><td>（中継用）関係者名（カナ）５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykankeinmkj1 ztykankeinmkj1}</td><td>（中継用）関係者名（漢字）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykankeinmkj2 ztykankeinmkj2}</td><td>（中継用）関係者名（漢字）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykankeinmkj3 ztykankeinmkj3}</td><td>（中継用）関係者名（漢字）３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykankeinmkj4 ztykankeinmkj4}</td><td>（中継用）関係者名（漢字）４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykankeinmkj5 ztykankeinmkj5}</td><td>（中継用）関係者名（漢字）５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirokbn ztyhrkkeirokbn}</td><td>（中継用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydntcd ztydntcd}</td><td>（中継用）団体コ－ド</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydntnm ztydntnm}</td><td>（中継用）団体名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydntsyzkcd ztydntsyzkcd}</td><td>（中継用）団体所属コ－ド</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydntkojincd ztydntkojincd}</td><td>（中継用）団体個人コ－ド</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaebankcd ztykzhurikaebankcd}</td><td>（中継用）口座振替銀行番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaesitencd ztykzhurikaesitencd}</td><td>（中継用）口座振替支店番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaeyokinkbn ztykzhurikaeyokinkbn}</td><td>（中継用）口座振替預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhurikaekouzano ztykzhurikaekouzano}</td><td>（中継用）口座振替口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsintelno ztytsintelno}</td><td>（中継用）通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhjncd ztyhjncd}</td><td>（中継用）法人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhjnjigyosyocd ztyhjnjigyosyocd}</td><td>（中継用）法人事業所コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysymtymd ztysymtymd}</td><td>（中継用）消滅年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokugyoucd ztysyokugyoucd}</td><td>（中継用）職業コ－ド</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hhknyno ztydai2hhknyno}</td><td>（中継用）第２被保険者新郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hhknnewtikucd ztydai2hhknnewtikucd}</td><td>（中継用）第２被保険者新地区コ－ド</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hhkntodouhukencd ztydai2hhkntodouhukencd}</td><td>（中継用）第２被保険者本籍府県コ－ド</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokugyoucd2 ztysyokugyoucd2}</td><td>（中継用）第２職業コ－ド</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv118 ztyyobiv118}</td><td>（中継用）予備項目Ｖ１１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskinnm ztyskinnm}</td><td>（中継用）索引姓名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv40 ztyyobiv40}</td><td>（中継用）予備項目Ｖ４０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynayosetaisyousegkbn ztynayosetaisyousegkbn}</td><td>（中継用）名寄せ対象者ＳＥＧ区分</td><td align="center">{@link PKZT_HnsyScrMeigiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynayosetaisyoukojinkbn ztynayosetaisyoukojinkbn}</td><td>（中継用）名寄せ対象者個人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv46 ztyyobiv46}</td><td>（中継用）予備項目Ｖ４６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytodouhukencd1 ztytodouhukencd1}</td><td>（中継用）都道府県コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytodouhukencd2 ztytodouhukencd2}</td><td>（中継用）都道府県コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytodouhukencd3 ztytodouhukencd3}</td><td>（中継用）都道府県コード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv34 ztyyobiv34}</td><td>（中継用）予備項目Ｖ３４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_HnsyScrMeigiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoumetucd ztysyoumetucd}</td><td>（中継用）消滅コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysymtymd2 ztysymtymd2}</td><td>（中継用）消滅年月日＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybohaiyakkandisp ztybohaiyakkandisp}</td><td>（中継用）暴排条項導入約款適用表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymeihenymd ztymeihenymd}</td><td>（中継用）名義変更年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseiymdseitsymd ztyseiymdseitsymd}</td><td>（中継用）生年月日性訂正年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtityuutohukaymd ztykzkmrtityuutohukaymd}</td><td>（中継用）家族マル定中途付加年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykmfkykknnm ztykykmfkykknnm}</td><td>（中継用）契約ＭＦ契約者カナ姓名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykmfkykkjnm ztykykmfkykkjnm}</td><td>（中継用）契約ＭＦ契約者漢字姓名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykmfkykseiymd ztykykmfkykseiymd}</td><td>（中継用）契約ＭＦ契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykmfhhkknnm ztykykmfhhkknnm}</td><td>（中継用）契約ＭＦ被保険者カナ姓名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykmfhhkkjnm ztykykmfhhkkjnm}</td><td>（中継用）契約ＭＦ被保険者漢字姓名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykmfhhkseiymd ztykykmfhhkseiymd}</td><td>（中継用）契約ＭＦ被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykmfdai2knnm ztykykmfdai2knnm}</td><td>（中継用）契約ＭＦ第２被カナ姓名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykmfdai2kjnm ztykykmfdai2kjnm}</td><td>（中継用）契約ＭＦ第２被漢字姓名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykmfdai2seiymd ztykykmfdai2seiymd}</td><td>（中継用）契約ＭＦ第２被生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykmfsbuktknnm ztykykmfsbuktknnm}</td><td>（中継用）契約ＭＦ死亡受取人カナ姓名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykmfsbuktkjnm ztykykmfsbuktkjnm}</td><td>（中継用）契約ＭＦ死亡受取人漢字姓名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykmfsbuktseiymd ztykykmfsbuktseiymd}</td><td>（中継用）契約ＭＦ死亡受取人生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykmfdai2ktknnm ztykykmfdai2ktknnm}</td><td>（中継用）契約ＭＦ第２受取人カナ姓名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykmfdai2ktkjnm ztykykmfdai2ktkjnm}</td><td>（中継用）契約ＭＦ第２受取人漢字姓名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykmfdai2ktseiymd ztykykmfdai2ktseiymd}</td><td>（中継用）契約ＭＦ第２受取人生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykmfmnkktknnm ztykykmfmnkktknnm}</td><td>（中継用）契約ＭＦ満期受取人カナ姓名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykmfmnkktkjnm ztykykmfmnkktkjnm}</td><td>（中継用）契約ＭＦ満期受取人漢字姓名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykmfmnkktseiymd ztykykmfmnkktseiymd}</td><td>（中継用）契約ＭＦ満期受取人生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydntcd2 ztydntcd2}</td><td>（中継用）団体コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjdntnm ztykjdntnm}</td><td>（中継用）漢字団体名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrinjikaisouhyouji ztyrinjikaisouhyouji}</td><td>（中継用）臨時回送表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv34x2 ztyyobiv34x2}</td><td>（中継用）予備項目Ｖ３４＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysgtaisyoukbn ztysgtaisyoukbn}</td><td>（中継用）照合対象区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv39 ztyyobiv39}</td><td>（中継用）予備項目Ｖ３９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuuseihjnnm ztysyuuseihjnnm}</td><td>（中継用）修正法人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv75 ztyyobiv75}</td><td>（中継用）予備項目Ｖ７５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysysyno ztysysyno}</td><td>（中継用）証書番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysueokikaisiymd ztysueokikaisiymd}</td><td>（中継用）据置開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhasseiriyuukbnscreen ztyhasseiriyuukbnscreen}</td><td>（中継用）発生理由区分（反社スクリーニング）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysueokijtkbn ztysueokijtkbn}</td><td>（中継用）据置状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytaisyoufilekbn ztytaisyoufilekbn}</td><td>（中継用）対象ファイル区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybohaiyakkandisp2 ztybohaiyakkandisp2}</td><td>（中継用）暴排条項導入約款適用表示２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymeihenymd2 ztymeihenymd2}</td><td>（中継用）名義変更年月日２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyoumetucd ztynksyoumetucd}</td><td>（中継用）年金消滅コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv7 ztyyobiv7}</td><td>（中継用）予備項目Ｖ７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv20 ztyyobiv20}</td><td>（中継用）予備項目Ｖ２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_HnsyScrMeigiTy
 * @see     PKZT_HnsyScrMeigiTy
 * @see     QZT_HnsyScrMeigiTy
 * @see     GenQZT_HnsyScrMeigiTy
 */
@MappedSuperclass
@Table(name=GenZT_HnsyScrMeigiTy.TABLE_NAME)
@IdClass(value=PKZT_HnsyScrMeigiTy.class)
public abstract class GenZT_HnsyScrMeigiTy extends AbstractExDBEntity<ZT_HnsyScrMeigiTy, PKZT_HnsyScrMeigiTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_HnsyScrMeigiTy";
    public static final String ZTYHNSYRECORDKBN         = "ztyhnsyrecordkbn";
    public static final String ZTYKIJYUNYM              = "ztykijyunym";
    public static final String ZTYTAISYOUNMKN           = "ztytaisyounmkn";
    public static final String ZTYTAISYOUNMKJ           = "ztytaisyounmkj";
    public static final String ZTYTAISYOUSEIYMD         = "ztytaisyouseiymd";
    public static final String ZTYTSNSKNEWYNO           = "ztytsnsknewyno";
    public static final String ZTYTSNSKNEWTIKUCD        = "ztytsnsknewtikucd";
    public static final String ZTYHHKNNEWYNO            = "ztyhhknnewyno";
    public static final String ZTYHHKNNEWTIKUCD         = "ztyhhknnewtikucd";
    public static final String ZTYKSTKANNISKNEWYNO      = "ztykstkannisknewyno";
    public static final String ZTYKSTKANNISKNEWTIKUCD   = "ztykstkannisknewtikucd";
    public static final String ZTYDNTNEWYNO             = "ztydntnewyno";
    public static final String ZTYDNTNEWTIKUCD          = "ztydntnewtikucd";
    public static final String ZTYKANJITSINKAIADR       = "ztykanjitsinkaiadr";
    public static final String ZTYTODOUHUKENNM          = "ztytodouhukennm";
    public static final String ZTYSIGUNNM               = "ztysigunnm";
    public static final String ZTYSOSIKICD1             = "ztysosikicd1";
    public static final String ZTYSOSIKICD2             = "ztysosikicd2";
    public static final String ZTYSOSIKICD3             = "ztysosikicd3";
    public static final String ZTYSOSIKICD4             = "ztysosikicd4";
    public static final String ZTYSOSIKICD5             = "ztysosikicd5";
    public static final String ZTYHHKNHNSKTODOUHUKENCD  = "ztyhhknhnsktodouhukencd";
    public static final String ZTYKANKEINMKN1           = "ztykankeinmkn1";
    public static final String ZTYKANKEINMKN2           = "ztykankeinmkn2";
    public static final String ZTYKANKEINMKN3           = "ztykankeinmkn3";
    public static final String ZTYKANKEINMKN4           = "ztykankeinmkn4";
    public static final String ZTYKANKEINMKN5           = "ztykankeinmkn5";
    public static final String ZTYKANKEINMKJ1           = "ztykankeinmkj1";
    public static final String ZTYKANKEINMKJ2           = "ztykankeinmkj2";
    public static final String ZTYKANKEINMKJ3           = "ztykankeinmkj3";
    public static final String ZTYKANKEINMKJ4           = "ztykankeinmkj4";
    public static final String ZTYKANKEINMKJ5           = "ztykankeinmkj5";
    public static final String ZTYHRKKEIROKBN           = "ztyhrkkeirokbn";
    public static final String ZTYDNTCD                 = "ztydntcd";
    public static final String ZTYDNTNM                 = "ztydntnm";
    public static final String ZTYDNTSYZKCD             = "ztydntsyzkcd";
    public static final String ZTYDNTKOJINCD            = "ztydntkojincd";
    public static final String ZTYKZHURIKAEBANKCD       = "ztykzhurikaebankcd";
    public static final String ZTYKZHURIKAESITENCD      = "ztykzhurikaesitencd";
    public static final String ZTYKZHURIKAEYOKINKBN     = "ztykzhurikaeyokinkbn";
    public static final String ZTYKZHURIKAEKOUZANO      = "ztykzhurikaekouzano";
    public static final String ZTYTSINTELNO             = "ztytsintelno";
    public static final String ZTYHJNCD                 = "ztyhjncd";
    public static final String ZTYHJNJIGYOSYOCD         = "ztyhjnjigyosyocd";
    public static final String ZTYSYMTYMD               = "ztysymtymd";
    public static final String ZTYSYOKUGYOUCD           = "ztysyokugyoucd";
    public static final String ZTYDAI2HHKNYNO           = "ztydai2hhknyno";
    public static final String ZTYDAI2HHKNNEWTIKUCD     = "ztydai2hhknnewtikucd";
    public static final String ZTYDAI2HHKNTODOUHUKENCD  = "ztydai2hhkntodouhukencd";
    public static final String ZTYSYOKUGYOUCD2          = "ztysyokugyoucd2";
    public static final String ZTYYOBIV118              = "ztyyobiv118";
    public static final String ZTYSKINNM                = "ztyskinnm";
    public static final String ZTYYOBIV40               = "ztyyobiv40";
    public static final String ZTYNAYOSETAISYOUSEGKBN   = "ztynayosetaisyousegkbn";
    public static final String ZTYNAYOSETAISYOUKOJINKBN = "ztynayosetaisyoukojinkbn";
    public static final String ZTYYOBIV46               = "ztyyobiv46";
    public static final String ZTYTODOUHUKENCD1         = "ztytodouhukencd1";
    public static final String ZTYTODOUHUKENCD2         = "ztytodouhukencd2";
    public static final String ZTYTODOUHUKENCD3         = "ztytodouhukencd3";
    public static final String ZTYYOBIV34               = "ztyyobiv34";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYSYOUMETUCD            = "ztysyoumetucd";
    public static final String ZTYSYMTYMD2              = "ztysymtymd2";
    public static final String ZTYBOHAIYAKKANDISP       = "ztybohaiyakkandisp";
    public static final String ZTYMEIHENYMD             = "ztymeihenymd";
    public static final String ZTYSEIYMDSEITSYMD        = "ztyseiymdseitsymd";
    public static final String ZTYKZKMRTITYUUTOHUKAYMD  = "ztykzkmrtityuutohukaymd";
    public static final String ZTYKYKMFKYKKNNM          = "ztykykmfkykknnm";
    public static final String ZTYKYKMFKYKKJNM          = "ztykykmfkykkjnm";
    public static final String ZTYKYKMFKYKSEIYMD        = "ztykykmfkykseiymd";
    public static final String ZTYKYKMFHHKKNNM          = "ztykykmfhhkknnm";
    public static final String ZTYKYKMFHHKKJNM          = "ztykykmfhhkkjnm";
    public static final String ZTYKYKMFHHKSEIYMD        = "ztykykmfhhkseiymd";
    public static final String ZTYKYKMFDAI2KNNM         = "ztykykmfdai2knnm";
    public static final String ZTYKYKMFDAI2KJNM         = "ztykykmfdai2kjnm";
    public static final String ZTYKYKMFDAI2SEIYMD       = "ztykykmfdai2seiymd";
    public static final String ZTYKYKMFSBUKTKNNM        = "ztykykmfsbuktknnm";
    public static final String ZTYKYKMFSBUKTKJNM        = "ztykykmfsbuktkjnm";
    public static final String ZTYKYKMFSBUKTSEIYMD      = "ztykykmfsbuktseiymd";
    public static final String ZTYKYKMFDAI2KTKNNM       = "ztykykmfdai2ktknnm";
    public static final String ZTYKYKMFDAI2KTKJNM       = "ztykykmfdai2ktkjnm";
    public static final String ZTYKYKMFDAI2KTSEIYMD     = "ztykykmfdai2ktseiymd";
    public static final String ZTYKYKMFMNKKTKNNM        = "ztykykmfmnkktknnm";
    public static final String ZTYKYKMFMNKKTKJNM        = "ztykykmfmnkktkjnm";
    public static final String ZTYKYKMFMNKKTSEIYMD      = "ztykykmfmnkktseiymd";
    public static final String ZTYDNTCD2                = "ztydntcd2";
    public static final String ZTYKJDNTNM               = "ztykjdntnm";
    public static final String ZTYRINJIKAISOUHYOUJI     = "ztyrinjikaisouhyouji";
    public static final String ZTYYOBIV34X2             = "ztyyobiv34x2";
    public static final String ZTYSGTAISYOUKBN          = "ztysgtaisyoukbn";
    public static final String ZTYYOBIV39               = "ztyyobiv39";
    public static final String ZTYSYUUSEIHJNNM          = "ztysyuuseihjnnm";
    public static final String ZTYYOBIV75               = "ztyyobiv75";
    public static final String ZTYSYSYNO                = "ztysysyno";
    public static final String ZTYSUEOKIKAISIYMD        = "ztysueokikaisiymd";
    public static final String ZTYHASSEIRIYUUKBNSCREEN  = "ztyhasseiriyuukbnscreen";
    public static final String ZTYSUEOKIJTKBN           = "ztysueokijtkbn";
    public static final String ZTYTAISYOUFILEKBN        = "ztytaisyoufilekbn";
    public static final String ZTYBOHAIYAKKANDISP2      = "ztybohaiyakkandisp2";
    public static final String ZTYMEIHENYMD2            = "ztymeihenymd2";
    public static final String ZTYNKSYOUMETUCD          = "ztynksyoumetucd";
    public static final String ZTYYOBIV7                = "ztyyobiv7";
    public static final String ZTYYOBIV20               = "ztyyobiv20";

    private final PKZT_HnsyScrMeigiTy primaryKey;

    public GenZT_HnsyScrMeigiTy() {
        primaryKey = new PKZT_HnsyScrMeigiTy();
    }

    public GenZT_HnsyScrMeigiTy(
        String pZtytaisyounmkn,
        String pZtytaisyounmkj,
        String pZtytaisyouseiymd,
        String pZtynayosetaisyousegkbn,
        String pZtysyono
    ) {
        primaryKey = new PKZT_HnsyScrMeigiTy(
            pZtytaisyounmkn,
            pZtytaisyounmkj,
            pZtytaisyouseiymd,
            pZtynayosetaisyousegkbn,
            pZtysyono
        );
    }

    @Transient
    @Override
    public PKZT_HnsyScrMeigiTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_HnsyScrMeigiTy> getMetaClass() {
        return QZT_HnsyScrMeigiTy.class;
    }

    private String ztyhnsyrecordkbn;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYHNSYRECORDKBN)
    public String getZtyhnsyrecordkbn() {
        return ztyhnsyrecordkbn;
    }

    public void setZtyhnsyrecordkbn(String pZtyhnsyrecordkbn) {
        ztyhnsyrecordkbn = pZtyhnsyrecordkbn;
    }

    private String ztykijyunym;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKIJYUNYM)
    public String getZtykijyunym() {
        return ztykijyunym;
    }

    public void setZtykijyunym(String pZtykijyunym) {
        ztykijyunym = pZtykijyunym;
    }

    @Id
    @Column(name=GenZT_HnsyScrMeigiTy.ZTYTAISYOUNMKN)
    public String getZtytaisyounmkn() {
        return getPrimaryKey().getZtytaisyounmkn();
    }

    public void setZtytaisyounmkn(String pZtytaisyounmkn) {
        getPrimaryKey().setZtytaisyounmkn(pZtytaisyounmkn);
    }

    @Id
    @Column(name=GenZT_HnsyScrMeigiTy.ZTYTAISYOUNMKJ)
    public String getZtytaisyounmkj() {
        return getPrimaryKey().getZtytaisyounmkj();
    }

    public void setZtytaisyounmkj(String pZtytaisyounmkj) {
        getPrimaryKey().setZtytaisyounmkj(pZtytaisyounmkj);
    }

    @Id
    @Column(name=GenZT_HnsyScrMeigiTy.ZTYTAISYOUSEIYMD)
    public String getZtytaisyouseiymd() {
        return getPrimaryKey().getZtytaisyouseiymd();
    }

    public void setZtytaisyouseiymd(String pZtytaisyouseiymd) {
        getPrimaryKey().setZtytaisyouseiymd(pZtytaisyouseiymd);
    }

    private String ztytsnsknewyno;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYTSNSKNEWYNO)
    public String getZtytsnsknewyno() {
        return ztytsnsknewyno;
    }

    public void setZtytsnsknewyno(String pZtytsnsknewyno) {
        ztytsnsknewyno = pZtytsnsknewyno;
    }

    private String ztytsnsknewtikucd;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYTSNSKNEWTIKUCD)
    public String getZtytsnsknewtikucd() {
        return ztytsnsknewtikucd;
    }

    public void setZtytsnsknewtikucd(String pZtytsnsknewtikucd) {
        ztytsnsknewtikucd = pZtytsnsknewtikucd;
    }

    private String ztyhhknnewyno;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYHHKNNEWYNO)
    public String getZtyhhknnewyno() {
        return ztyhhknnewyno;
    }

    public void setZtyhhknnewyno(String pZtyhhknnewyno) {
        ztyhhknnewyno = pZtyhhknnewyno;
    }

    private String ztyhhknnewtikucd;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYHHKNNEWTIKUCD)
    public String getZtyhhknnewtikucd() {
        return ztyhhknnewtikucd;
    }

    public void setZtyhhknnewtikucd(String pZtyhhknnewtikucd) {
        ztyhhknnewtikucd = pZtyhhknnewtikucd;
    }

    private String ztykstkannisknewyno;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKSTKANNISKNEWYNO)
    public String getZtykstkannisknewyno() {
        return ztykstkannisknewyno;
    }

    public void setZtykstkannisknewyno(String pZtykstkannisknewyno) {
        ztykstkannisknewyno = pZtykstkannisknewyno;
    }

    private String ztykstkannisknewtikucd;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKSTKANNISKNEWTIKUCD)
    public String getZtykstkannisknewtikucd() {
        return ztykstkannisknewtikucd;
    }

    public void setZtykstkannisknewtikucd(String pZtykstkannisknewtikucd) {
        ztykstkannisknewtikucd = pZtykstkannisknewtikucd;
    }

    private String ztydntnewyno;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYDNTNEWYNO)
    public String getZtydntnewyno() {
        return ztydntnewyno;
    }

    public void setZtydntnewyno(String pZtydntnewyno) {
        ztydntnewyno = pZtydntnewyno;
    }

    private String ztydntnewtikucd;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYDNTNEWTIKUCD)
    public String getZtydntnewtikucd() {
        return ztydntnewtikucd;
    }

    public void setZtydntnewtikucd(String pZtydntnewtikucd) {
        ztydntnewtikucd = pZtydntnewtikucd;
    }

    private String ztykanjitsinkaiadr;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKANJITSINKAIADR)
    public String getZtykanjitsinkaiadr() {
        return ztykanjitsinkaiadr;
    }

    public void setZtykanjitsinkaiadr(String pZtykanjitsinkaiadr) {
        ztykanjitsinkaiadr = pZtykanjitsinkaiadr;
    }

    private String ztytodouhukennm;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYTODOUHUKENNM)
    public String getZtytodouhukennm() {
        return ztytodouhukennm;
    }

    public void setZtytodouhukennm(String pZtytodouhukennm) {
        ztytodouhukennm = pZtytodouhukennm;
    }

    private String ztysigunnm;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYSIGUNNM)
    public String getZtysigunnm() {
        return ztysigunnm;
    }

    public void setZtysigunnm(String pZtysigunnm) {
        ztysigunnm = pZtysigunnm;
    }

    private String ztysosikicd1;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYSOSIKICD1)
    public String getZtysosikicd1() {
        return ztysosikicd1;
    }

    public void setZtysosikicd1(String pZtysosikicd1) {
        ztysosikicd1 = pZtysosikicd1;
    }

    private String ztysosikicd2;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYSOSIKICD2)
    public String getZtysosikicd2() {
        return ztysosikicd2;
    }

    public void setZtysosikicd2(String pZtysosikicd2) {
        ztysosikicd2 = pZtysosikicd2;
    }

    private String ztysosikicd3;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYSOSIKICD3)
    public String getZtysosikicd3() {
        return ztysosikicd3;
    }

    public void setZtysosikicd3(String pZtysosikicd3) {
        ztysosikicd3 = pZtysosikicd3;
    }

    private String ztysosikicd4;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYSOSIKICD4)
    public String getZtysosikicd4() {
        return ztysosikicd4;
    }

    public void setZtysosikicd4(String pZtysosikicd4) {
        ztysosikicd4 = pZtysosikicd4;
    }

    private String ztysosikicd5;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYSOSIKICD5)
    public String getZtysosikicd5() {
        return ztysosikicd5;
    }

    public void setZtysosikicd5(String pZtysosikicd5) {
        ztysosikicd5 = pZtysosikicd5;
    }

    private String ztyhhknhnsktodouhukencd;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYHHKNHNSKTODOUHUKENCD)
    public String getZtyhhknhnsktodouhukencd() {
        return ztyhhknhnsktodouhukencd;
    }

    public void setZtyhhknhnsktodouhukencd(String pZtyhhknhnsktodouhukencd) {
        ztyhhknhnsktodouhukencd = pZtyhhknhnsktodouhukencd;
    }

    private String ztykankeinmkn1;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKANKEINMKN1)
    public String getZtykankeinmkn1() {
        return ztykankeinmkn1;
    }

    public void setZtykankeinmkn1(String pZtykankeinmkn1) {
        ztykankeinmkn1 = pZtykankeinmkn1;
    }

    private String ztykankeinmkn2;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKANKEINMKN2)
    public String getZtykankeinmkn2() {
        return ztykankeinmkn2;
    }

    public void setZtykankeinmkn2(String pZtykankeinmkn2) {
        ztykankeinmkn2 = pZtykankeinmkn2;
    }

    private String ztykankeinmkn3;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKANKEINMKN3)
    public String getZtykankeinmkn3() {
        return ztykankeinmkn3;
    }

    public void setZtykankeinmkn3(String pZtykankeinmkn3) {
        ztykankeinmkn3 = pZtykankeinmkn3;
    }

    private String ztykankeinmkn4;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKANKEINMKN4)
    public String getZtykankeinmkn4() {
        return ztykankeinmkn4;
    }

    public void setZtykankeinmkn4(String pZtykankeinmkn4) {
        ztykankeinmkn4 = pZtykankeinmkn4;
    }

    private String ztykankeinmkn5;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKANKEINMKN5)
    public String getZtykankeinmkn5() {
        return ztykankeinmkn5;
    }

    public void setZtykankeinmkn5(String pZtykankeinmkn5) {
        ztykankeinmkn5 = pZtykankeinmkn5;
    }

    private String ztykankeinmkj1;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKANKEINMKJ1)
    public String getZtykankeinmkj1() {
        return ztykankeinmkj1;
    }

    public void setZtykankeinmkj1(String pZtykankeinmkj1) {
        ztykankeinmkj1 = pZtykankeinmkj1;
    }

    private String ztykankeinmkj2;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKANKEINMKJ2)
    public String getZtykankeinmkj2() {
        return ztykankeinmkj2;
    }

    public void setZtykankeinmkj2(String pZtykankeinmkj2) {
        ztykankeinmkj2 = pZtykankeinmkj2;
    }

    private String ztykankeinmkj3;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKANKEINMKJ3)
    public String getZtykankeinmkj3() {
        return ztykankeinmkj3;
    }

    public void setZtykankeinmkj3(String pZtykankeinmkj3) {
        ztykankeinmkj3 = pZtykankeinmkj3;
    }

    private String ztykankeinmkj4;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKANKEINMKJ4)
    public String getZtykankeinmkj4() {
        return ztykankeinmkj4;
    }

    public void setZtykankeinmkj4(String pZtykankeinmkj4) {
        ztykankeinmkj4 = pZtykankeinmkj4;
    }

    private String ztykankeinmkj5;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKANKEINMKJ5)
    public String getZtykankeinmkj5() {
        return ztykankeinmkj5;
    }

    public void setZtykankeinmkj5(String pZtykankeinmkj5) {
        ztykankeinmkj5 = pZtykankeinmkj5;
    }

    private String ztyhrkkeirokbn;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYHRKKEIROKBN)
    public String getZtyhrkkeirokbn() {
        return ztyhrkkeirokbn;
    }

    public void setZtyhrkkeirokbn(String pZtyhrkkeirokbn) {
        ztyhrkkeirokbn = pZtyhrkkeirokbn;
    }

    private String ztydntcd;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYDNTCD)
    public String getZtydntcd() {
        return ztydntcd;
    }

    public void setZtydntcd(String pZtydntcd) {
        ztydntcd = pZtydntcd;
    }

    private String ztydntnm;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYDNTNM)
    public String getZtydntnm() {
        return ztydntnm;
    }

    public void setZtydntnm(String pZtydntnm) {
        ztydntnm = pZtydntnm;
    }

    private String ztydntsyzkcd;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYDNTSYZKCD)
    public String getZtydntsyzkcd() {
        return ztydntsyzkcd;
    }

    public void setZtydntsyzkcd(String pZtydntsyzkcd) {
        ztydntsyzkcd = pZtydntsyzkcd;
    }

    private String ztydntkojincd;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYDNTKOJINCD)
    public String getZtydntkojincd() {
        return ztydntkojincd;
    }

    public void setZtydntkojincd(String pZtydntkojincd) {
        ztydntkojincd = pZtydntkojincd;
    }

    private String ztykzhurikaebankcd;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKZHURIKAEBANKCD)
    public String getZtykzhurikaebankcd() {
        return ztykzhurikaebankcd;
    }

    public void setZtykzhurikaebankcd(String pZtykzhurikaebankcd) {
        ztykzhurikaebankcd = pZtykzhurikaebankcd;
    }

    private String ztykzhurikaesitencd;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKZHURIKAESITENCD)
    public String getZtykzhurikaesitencd() {
        return ztykzhurikaesitencd;
    }

    public void setZtykzhurikaesitencd(String pZtykzhurikaesitencd) {
        ztykzhurikaesitencd = pZtykzhurikaesitencd;
    }

    private String ztykzhurikaeyokinkbn;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKZHURIKAEYOKINKBN)
    public String getZtykzhurikaeyokinkbn() {
        return ztykzhurikaeyokinkbn;
    }

    public void setZtykzhurikaeyokinkbn(String pZtykzhurikaeyokinkbn) {
        ztykzhurikaeyokinkbn = pZtykzhurikaeyokinkbn;
    }

    private String ztykzhurikaekouzano;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKZHURIKAEKOUZANO)
    public String getZtykzhurikaekouzano() {
        return ztykzhurikaekouzano;
    }

    public void setZtykzhurikaekouzano(String pZtykzhurikaekouzano) {
        ztykzhurikaekouzano = pZtykzhurikaekouzano;
    }

    private String ztytsintelno;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYTSINTELNO)
    public String getZtytsintelno() {
        return ztytsintelno;
    }

    public void setZtytsintelno(String pZtytsintelno) {
        ztytsintelno = pZtytsintelno;
    }

    private String ztyhjncd;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYHJNCD)
    public String getZtyhjncd() {
        return ztyhjncd;
    }

    public void setZtyhjncd(String pZtyhjncd) {
        ztyhjncd = pZtyhjncd;
    }

    private String ztyhjnjigyosyocd;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYHJNJIGYOSYOCD)
    public String getZtyhjnjigyosyocd() {
        return ztyhjnjigyosyocd;
    }

    public void setZtyhjnjigyosyocd(String pZtyhjnjigyosyocd) {
        ztyhjnjigyosyocd = pZtyhjnjigyosyocd;
    }

    private String ztysymtymd;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYSYMTYMD)
    public String getZtysymtymd() {
        return ztysymtymd;
    }

    public void setZtysymtymd(String pZtysymtymd) {
        ztysymtymd = pZtysymtymd;
    }

    private String ztysyokugyoucd;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYSYOKUGYOUCD)
    public String getZtysyokugyoucd() {
        return ztysyokugyoucd;
    }

    public void setZtysyokugyoucd(String pZtysyokugyoucd) {
        ztysyokugyoucd = pZtysyokugyoucd;
    }

    private String ztydai2hhknyno;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYDAI2HHKNYNO)
    public String getZtydai2hhknyno() {
        return ztydai2hhknyno;
    }

    public void setZtydai2hhknyno(String pZtydai2hhknyno) {
        ztydai2hhknyno = pZtydai2hhknyno;
    }

    private String ztydai2hhknnewtikucd;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYDAI2HHKNNEWTIKUCD)
    public String getZtydai2hhknnewtikucd() {
        return ztydai2hhknnewtikucd;
    }

    public void setZtydai2hhknnewtikucd(String pZtydai2hhknnewtikucd) {
        ztydai2hhknnewtikucd = pZtydai2hhknnewtikucd;
    }

    private String ztydai2hhkntodouhukencd;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYDAI2HHKNTODOUHUKENCD)
    public String getZtydai2hhkntodouhukencd() {
        return ztydai2hhkntodouhukencd;
    }

    public void setZtydai2hhkntodouhukencd(String pZtydai2hhkntodouhukencd) {
        ztydai2hhkntodouhukencd = pZtydai2hhkntodouhukencd;
    }

    private String ztysyokugyoucd2;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYSYOKUGYOUCD2)
    public String getZtysyokugyoucd2() {
        return ztysyokugyoucd2;
    }

    public void setZtysyokugyoucd2(String pZtysyokugyoucd2) {
        ztysyokugyoucd2 = pZtysyokugyoucd2;
    }

    private String ztyyobiv118;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYYOBIV118)
    public String getZtyyobiv118() {
        return ztyyobiv118;
    }

    public void setZtyyobiv118(String pZtyyobiv118) {
        ztyyobiv118 = pZtyyobiv118;
    }

    private String ztyskinnm;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYSKINNM)
    public String getZtyskinnm() {
        return ztyskinnm;
    }

    public void setZtyskinnm(String pZtyskinnm) {
        ztyskinnm = pZtyskinnm;
    }

    private String ztyyobiv40;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYYOBIV40)
    public String getZtyyobiv40() {
        return ztyyobiv40;
    }

    public void setZtyyobiv40(String pZtyyobiv40) {
        ztyyobiv40 = pZtyyobiv40;
    }

    @Id
    @Column(name=GenZT_HnsyScrMeigiTy.ZTYNAYOSETAISYOUSEGKBN)
    public String getZtynayosetaisyousegkbn() {
        return getPrimaryKey().getZtynayosetaisyousegkbn();
    }

    public void setZtynayosetaisyousegkbn(String pZtynayosetaisyousegkbn) {
        getPrimaryKey().setZtynayosetaisyousegkbn(pZtynayosetaisyousegkbn);
    }

    private String ztynayosetaisyoukojinkbn;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYNAYOSETAISYOUKOJINKBN)
    public String getZtynayosetaisyoukojinkbn() {
        return ztynayosetaisyoukojinkbn;
    }

    public void setZtynayosetaisyoukojinkbn(String pZtynayosetaisyoukojinkbn) {
        ztynayosetaisyoukojinkbn = pZtynayosetaisyoukojinkbn;
    }

    private String ztyyobiv46;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYYOBIV46)
    public String getZtyyobiv46() {
        return ztyyobiv46;
    }

    public void setZtyyobiv46(String pZtyyobiv46) {
        ztyyobiv46 = pZtyyobiv46;
    }

    private String ztytodouhukencd1;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYTODOUHUKENCD1)
    public String getZtytodouhukencd1() {
        return ztytodouhukencd1;
    }

    public void setZtytodouhukencd1(String pZtytodouhukencd1) {
        ztytodouhukencd1 = pZtytodouhukencd1;
    }

    private String ztytodouhukencd2;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYTODOUHUKENCD2)
    public String getZtytodouhukencd2() {
        return ztytodouhukencd2;
    }

    public void setZtytodouhukencd2(String pZtytodouhukencd2) {
        ztytodouhukencd2 = pZtytodouhukencd2;
    }

    private String ztytodouhukencd3;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYTODOUHUKENCD3)
    public String getZtytodouhukencd3() {
        return ztytodouhukencd3;
    }

    public void setZtytodouhukencd3(String pZtytodouhukencd3) {
        ztytodouhukencd3 = pZtytodouhukencd3;
    }

    private String ztyyobiv34;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYYOBIV34)
    public String getZtyyobiv34() {
        return ztyyobiv34;
    }

    public void setZtyyobiv34(String pZtyyobiv34) {
        ztyyobiv34 = pZtyyobiv34;
    }

    @Id
    @Column(name=GenZT_HnsyScrMeigiTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztysyoumetucd;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYSYOUMETUCD)
    public String getZtysyoumetucd() {
        return ztysyoumetucd;
    }

    public void setZtysyoumetucd(String pZtysyoumetucd) {
        ztysyoumetucd = pZtysyoumetucd;
    }

    private String ztysymtymd2;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYSYMTYMD2)
    public String getZtysymtymd2() {
        return ztysymtymd2;
    }

    public void setZtysymtymd2(String pZtysymtymd2) {
        ztysymtymd2 = pZtysymtymd2;
    }

    private String ztybohaiyakkandisp;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYBOHAIYAKKANDISP)
    public String getZtybohaiyakkandisp() {
        return ztybohaiyakkandisp;
    }

    public void setZtybohaiyakkandisp(String pZtybohaiyakkandisp) {
        ztybohaiyakkandisp = pZtybohaiyakkandisp;
    }

    private String ztymeihenymd;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYMEIHENYMD)
    public String getZtymeihenymd() {
        return ztymeihenymd;
    }

    public void setZtymeihenymd(String pZtymeihenymd) {
        ztymeihenymd = pZtymeihenymd;
    }

    private String ztyseiymdseitsymd;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYSEIYMDSEITSYMD)
    public String getZtyseiymdseitsymd() {
        return ztyseiymdseitsymd;
    }

    public void setZtyseiymdseitsymd(String pZtyseiymdseitsymd) {
        ztyseiymdseitsymd = pZtyseiymdseitsymd;
    }

    private String ztykzkmrtityuutohukaymd;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKZKMRTITYUUTOHUKAYMD)
    public String getZtykzkmrtityuutohukaymd() {
        return ztykzkmrtityuutohukaymd;
    }

    public void setZtykzkmrtityuutohukaymd(String pZtykzkmrtityuutohukaymd) {
        ztykzkmrtityuutohukaymd = pZtykzkmrtityuutohukaymd;
    }

    private String ztykykmfkykknnm;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKYKMFKYKKNNM)
    public String getZtykykmfkykknnm() {
        return ztykykmfkykknnm;
    }

    public void setZtykykmfkykknnm(String pZtykykmfkykknnm) {
        ztykykmfkykknnm = pZtykykmfkykknnm;
    }

    private String ztykykmfkykkjnm;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKYKMFKYKKJNM)
    public String getZtykykmfkykkjnm() {
        return ztykykmfkykkjnm;
    }

    public void setZtykykmfkykkjnm(String pZtykykmfkykkjnm) {
        ztykykmfkykkjnm = pZtykykmfkykkjnm;
    }

    private String ztykykmfkykseiymd;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKYKMFKYKSEIYMD)
    public String getZtykykmfkykseiymd() {
        return ztykykmfkykseiymd;
    }

    public void setZtykykmfkykseiymd(String pZtykykmfkykseiymd) {
        ztykykmfkykseiymd = pZtykykmfkykseiymd;
    }

    private String ztykykmfhhkknnm;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKYKMFHHKKNNM)
    public String getZtykykmfhhkknnm() {
        return ztykykmfhhkknnm;
    }

    public void setZtykykmfhhkknnm(String pZtykykmfhhkknnm) {
        ztykykmfhhkknnm = pZtykykmfhhkknnm;
    }

    private String ztykykmfhhkkjnm;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKYKMFHHKKJNM)
    public String getZtykykmfhhkkjnm() {
        return ztykykmfhhkkjnm;
    }

    public void setZtykykmfhhkkjnm(String pZtykykmfhhkkjnm) {
        ztykykmfhhkkjnm = pZtykykmfhhkkjnm;
    }

    private String ztykykmfhhkseiymd;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKYKMFHHKSEIYMD)
    public String getZtykykmfhhkseiymd() {
        return ztykykmfhhkseiymd;
    }

    public void setZtykykmfhhkseiymd(String pZtykykmfhhkseiymd) {
        ztykykmfhhkseiymd = pZtykykmfhhkseiymd;
    }

    private String ztykykmfdai2knnm;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKYKMFDAI2KNNM)
    public String getZtykykmfdai2knnm() {
        return ztykykmfdai2knnm;
    }

    public void setZtykykmfdai2knnm(String pZtykykmfdai2knnm) {
        ztykykmfdai2knnm = pZtykykmfdai2knnm;
    }

    private String ztykykmfdai2kjnm;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKYKMFDAI2KJNM)
    public String getZtykykmfdai2kjnm() {
        return ztykykmfdai2kjnm;
    }

    public void setZtykykmfdai2kjnm(String pZtykykmfdai2kjnm) {
        ztykykmfdai2kjnm = pZtykykmfdai2kjnm;
    }

    private String ztykykmfdai2seiymd;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKYKMFDAI2SEIYMD)
    public String getZtykykmfdai2seiymd() {
        return ztykykmfdai2seiymd;
    }

    public void setZtykykmfdai2seiymd(String pZtykykmfdai2seiymd) {
        ztykykmfdai2seiymd = pZtykykmfdai2seiymd;
    }

    private String ztykykmfsbuktknnm;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKYKMFSBUKTKNNM)
    public String getZtykykmfsbuktknnm() {
        return ztykykmfsbuktknnm;
    }

    public void setZtykykmfsbuktknnm(String pZtykykmfsbuktknnm) {
        ztykykmfsbuktknnm = pZtykykmfsbuktknnm;
    }

    private String ztykykmfsbuktkjnm;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKYKMFSBUKTKJNM)
    public String getZtykykmfsbuktkjnm() {
        return ztykykmfsbuktkjnm;
    }

    public void setZtykykmfsbuktkjnm(String pZtykykmfsbuktkjnm) {
        ztykykmfsbuktkjnm = pZtykykmfsbuktkjnm;
    }

    private String ztykykmfsbuktseiymd;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKYKMFSBUKTSEIYMD)
    public String getZtykykmfsbuktseiymd() {
        return ztykykmfsbuktseiymd;
    }

    public void setZtykykmfsbuktseiymd(String pZtykykmfsbuktseiymd) {
        ztykykmfsbuktseiymd = pZtykykmfsbuktseiymd;
    }

    private String ztykykmfdai2ktknnm;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKYKMFDAI2KTKNNM)
    public String getZtykykmfdai2ktknnm() {
        return ztykykmfdai2ktknnm;
    }

    public void setZtykykmfdai2ktknnm(String pZtykykmfdai2ktknnm) {
        ztykykmfdai2ktknnm = pZtykykmfdai2ktknnm;
    }

    private String ztykykmfdai2ktkjnm;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKYKMFDAI2KTKJNM)
    public String getZtykykmfdai2ktkjnm() {
        return ztykykmfdai2ktkjnm;
    }

    public void setZtykykmfdai2ktkjnm(String pZtykykmfdai2ktkjnm) {
        ztykykmfdai2ktkjnm = pZtykykmfdai2ktkjnm;
    }

    private String ztykykmfdai2ktseiymd;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKYKMFDAI2KTSEIYMD)
    public String getZtykykmfdai2ktseiymd() {
        return ztykykmfdai2ktseiymd;
    }

    public void setZtykykmfdai2ktseiymd(String pZtykykmfdai2ktseiymd) {
        ztykykmfdai2ktseiymd = pZtykykmfdai2ktseiymd;
    }

    private String ztykykmfmnkktknnm;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKYKMFMNKKTKNNM)
    public String getZtykykmfmnkktknnm() {
        return ztykykmfmnkktknnm;
    }

    public void setZtykykmfmnkktknnm(String pZtykykmfmnkktknnm) {
        ztykykmfmnkktknnm = pZtykykmfmnkktknnm;
    }

    private String ztykykmfmnkktkjnm;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKYKMFMNKKTKJNM)
    public String getZtykykmfmnkktkjnm() {
        return ztykykmfmnkktkjnm;
    }

    public void setZtykykmfmnkktkjnm(String pZtykykmfmnkktkjnm) {
        ztykykmfmnkktkjnm = pZtykykmfmnkktkjnm;
    }

    private String ztykykmfmnkktseiymd;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKYKMFMNKKTSEIYMD)
    public String getZtykykmfmnkktseiymd() {
        return ztykykmfmnkktseiymd;
    }

    public void setZtykykmfmnkktseiymd(String pZtykykmfmnkktseiymd) {
        ztykykmfmnkktseiymd = pZtykykmfmnkktseiymd;
    }

    private String ztydntcd2;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYDNTCD2)
    public String getZtydntcd2() {
        return ztydntcd2;
    }

    public void setZtydntcd2(String pZtydntcd2) {
        ztydntcd2 = pZtydntcd2;
    }

    private String ztykjdntnm;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYKJDNTNM)
    public String getZtykjdntnm() {
        return ztykjdntnm;
    }

    public void setZtykjdntnm(String pZtykjdntnm) {
        ztykjdntnm = pZtykjdntnm;
    }

    private String ztyrinjikaisouhyouji;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYRINJIKAISOUHYOUJI)
    public String getZtyrinjikaisouhyouji() {
        return ztyrinjikaisouhyouji;
    }

    public void setZtyrinjikaisouhyouji(String pZtyrinjikaisouhyouji) {
        ztyrinjikaisouhyouji = pZtyrinjikaisouhyouji;
    }

    private String ztyyobiv34x2;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYYOBIV34X2)
    public String getZtyyobiv34x2() {
        return ztyyobiv34x2;
    }

    public void setZtyyobiv34x2(String pZtyyobiv34x2) {
        ztyyobiv34x2 = pZtyyobiv34x2;
    }

    private String ztysgtaisyoukbn;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYSGTAISYOUKBN)
    public String getZtysgtaisyoukbn() {
        return ztysgtaisyoukbn;
    }

    public void setZtysgtaisyoukbn(String pZtysgtaisyoukbn) {
        ztysgtaisyoukbn = pZtysgtaisyoukbn;
    }

    private String ztyyobiv39;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYYOBIV39)
    public String getZtyyobiv39() {
        return ztyyobiv39;
    }

    public void setZtyyobiv39(String pZtyyobiv39) {
        ztyyobiv39 = pZtyyobiv39;
    }

    private String ztysyuuseihjnnm;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYSYUUSEIHJNNM)
    public String getZtysyuuseihjnnm() {
        return ztysyuuseihjnnm;
    }

    public void setZtysyuuseihjnnm(String pZtysyuuseihjnnm) {
        ztysyuuseihjnnm = pZtysyuuseihjnnm;
    }

    private String ztyyobiv75;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYYOBIV75)
    public String getZtyyobiv75() {
        return ztyyobiv75;
    }

    public void setZtyyobiv75(String pZtyyobiv75) {
        ztyyobiv75 = pZtyyobiv75;
    }

    private String ztysysyno;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYSYSYNO)
    public String getZtysysyno() {
        return ztysysyno;
    }

    public void setZtysysyno(String pZtysysyno) {
        ztysysyno = pZtysysyno;
    }

    private String ztysueokikaisiymd;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYSUEOKIKAISIYMD)
    public String getZtysueokikaisiymd() {
        return ztysueokikaisiymd;
    }

    public void setZtysueokikaisiymd(String pZtysueokikaisiymd) {
        ztysueokikaisiymd = pZtysueokikaisiymd;
    }

    private String ztyhasseiriyuukbnscreen;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYHASSEIRIYUUKBNSCREEN)
    public String getZtyhasseiriyuukbnscreen() {
        return ztyhasseiriyuukbnscreen;
    }

    public void setZtyhasseiriyuukbnscreen(String pZtyhasseiriyuukbnscreen) {
        ztyhasseiriyuukbnscreen = pZtyhasseiriyuukbnscreen;
    }

    private String ztysueokijtkbn;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYSUEOKIJTKBN)
    public String getZtysueokijtkbn() {
        return ztysueokijtkbn;
    }

    public void setZtysueokijtkbn(String pZtysueokijtkbn) {
        ztysueokijtkbn = pZtysueokijtkbn;
    }

    private String ztytaisyoufilekbn;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYTAISYOUFILEKBN)
    public String getZtytaisyoufilekbn() {
        return ztytaisyoufilekbn;
    }

    public void setZtytaisyoufilekbn(String pZtytaisyoufilekbn) {
        ztytaisyoufilekbn = pZtytaisyoufilekbn;
    }

    private String ztybohaiyakkandisp2;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYBOHAIYAKKANDISP2)
    public String getZtybohaiyakkandisp2() {
        return ztybohaiyakkandisp2;
    }

    public void setZtybohaiyakkandisp2(String pZtybohaiyakkandisp2) {
        ztybohaiyakkandisp2 = pZtybohaiyakkandisp2;
    }

    private String ztymeihenymd2;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYMEIHENYMD2)
    public String getZtymeihenymd2() {
        return ztymeihenymd2;
    }

    public void setZtymeihenymd2(String pZtymeihenymd2) {
        ztymeihenymd2 = pZtymeihenymd2;
    }

    private String ztynksyoumetucd;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYNKSYOUMETUCD)
    public String getZtynksyoumetucd() {
        return ztynksyoumetucd;
    }

    public void setZtynksyoumetucd(String pZtynksyoumetucd) {
        ztynksyoumetucd = pZtynksyoumetucd;
    }

    private String ztyyobiv7;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYYOBIV7)
    public String getZtyyobiv7() {
        return ztyyobiv7;
    }

    public void setZtyyobiv7(String pZtyyobiv7) {
        ztyyobiv7 = pZtyyobiv7;
    }

    private String ztyyobiv20;

    @Column(name=GenZT_HnsyScrMeigiTy.ZTYYOBIV20)
    public String getZtyyobiv20() {
        return ztyyobiv20;
    }

    public void setZtyyobiv20(String pZtyyobiv20) {
        ztyyobiv20 = pZtyyobiv20;
    }
}
