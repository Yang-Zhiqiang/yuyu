package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_HnsyScrMeigiRn;
import yuyu.def.db.id.PKZT_HnsyScrMeigiRn;
import yuyu.def.db.meta.GenQZT_HnsyScrMeigiRn;
import yuyu.def.db.meta.QZT_HnsyScrMeigiRn;

/**
 * 反社スクリーニング用名義データテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_HnsyScrMeigiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_HnsyScrMeigiRn}</td><td colspan="3">反社スクリーニング用名義データテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnhnsyrecordkbn zrnhnsyrecordkbn}</td><td>（連携用）反社レコ－ド区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkijyunym zrnkijyunym}</td><td>（連携用）基準年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntaisyounmkn zrntaisyounmkn}</td><td>（連携用）対象者姓名（カナ）</td><td align="center">{@link PKZT_HnsyScrMeigiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntaisyounmkj zrntaisyounmkj}</td><td>（連携用）対象者姓名（漢字）</td><td align="center">{@link PKZT_HnsyScrMeigiRn ○}</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntaisyouseiymd zrntaisyouseiymd}</td><td>（連携用）対象者生年月日</td><td align="center">{@link PKZT_HnsyScrMeigiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsnsknewyno zrntsnsknewyno}</td><td>（連携用）通信先新郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsnsknewtikucd zrntsnsknewtikucd}</td><td>（連携用）通信先新地区コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnewyno zrnhhknnewyno}</td><td>（連携用）被保険者新郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnewtikucd zrnhhknnewtikucd}</td><td>（連携用）被保険者新地区コ－ド</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkstkannisknewyno zrnkstkannisknewyno}</td><td>（連携用）貸付案内先新郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkstkannisknewtikucd zrnkstkannisknewtikucd}</td><td>（連携用）貸付案内先新地区コ－ド</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndntnewyno zrndntnewyno}</td><td>（連携用）団体新郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndntnewtikucd zrndntnewtikucd}</td><td>（連携用）団体新地区コ－ド</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanjitsinkaiadr zrnkanjitsinkaiadr}</td><td>（連携用）漢字通信先下位住所</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntodouhukennm zrntodouhukennm}</td><td>（連携用）都道府県名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsigunnm zrnsigunnm}</td><td>（連携用）市郡名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsosikicd1 zrnsosikicd1}</td><td>（連携用）組織コ－ド１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsosikicd2 zrnsosikicd2}</td><td>（連携用）組織コ－ド２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsosikicd3 zrnsosikicd3}</td><td>（連携用）組織コ－ド３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsosikicd4 zrnsosikicd4}</td><td>（連携用）組織コ－ド４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsosikicd5 zrnsosikicd5}</td><td>（連携用）組織コ－ド５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknhnsktodouhukencd zrnhhknhnsktodouhukencd}</td><td>（連携用）被保険者本籍都道府県コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkankeinmkn1 zrnkankeinmkn1}</td><td>（連携用）関係者名（カナ）１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkankeinmkn2 zrnkankeinmkn2}</td><td>（連携用）関係者名（カナ）２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkankeinmkn3 zrnkankeinmkn3}</td><td>（連携用）関係者名（カナ）３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkankeinmkn4 zrnkankeinmkn4}</td><td>（連携用）関係者名（カナ）４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkankeinmkn5 zrnkankeinmkn5}</td><td>（連携用）関係者名（カナ）５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkankeinmkj1 zrnkankeinmkj1}</td><td>（連携用）関係者名（漢字）１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkankeinmkj2 zrnkankeinmkj2}</td><td>（連携用）関係者名（漢字）２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkankeinmkj3 zrnkankeinmkj3}</td><td>（連携用）関係者名（漢字）３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkankeinmkj4 zrnkankeinmkj4}</td><td>（連携用）関係者名（漢字）４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkankeinmkj5 zrnkankeinmkj5}</td><td>（連携用）関係者名（漢字）５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirokbn zrnhrkkeirokbn}</td><td>（連携用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndntcd zrndntcd}</td><td>（連携用）団体コ－ド</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndntnm zrndntnm}</td><td>（連携用）団体名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndntsyzkcd zrndntsyzkcd}</td><td>（連携用）団体所属コ－ド</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndntkojincd zrndntkojincd}</td><td>（連携用）団体個人コ－ド</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaebankcd zrnkzhurikaebankcd}</td><td>（連携用）口座振替銀行番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaesitencd zrnkzhurikaesitencd}</td><td>（連携用）口座振替支店番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaeyokinkbn zrnkzhurikaeyokinkbn}</td><td>（連携用）口座振替預金種目区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhurikaekouzano zrnkzhurikaekouzano}</td><td>（連携用）口座振替口座番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsintelno zrntsintelno}</td><td>（連携用）通信先電話番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhjncd zrnhjncd}</td><td>（連携用）法人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhjnjigyosyocd zrnhjnjigyosyocd}</td><td>（連携用）法人事業所コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsymtymd zrnsymtymd}</td><td>（連携用）消滅年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokugyoucd zrnsyokugyoucd}</td><td>（連携用）職業コ－ド</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hhknyno zrndai2hhknyno}</td><td>（連携用）第２被保険者新郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hhknnewtikucd zrndai2hhknnewtikucd}</td><td>（連携用）第２被保険者新地区コ－ド</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hhkntodouhukencd zrndai2hhkntodouhukencd}</td><td>（連携用）第２被保険者本籍府県コ－ド</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokugyoucd2 zrnsyokugyoucd2}</td><td>（連携用）第２職業コ－ド</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv118 zrnyobiv118}</td><td>（連携用）予備項目Ｖ１１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskinnm zrnskinnm}</td><td>（連携用）索引姓名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv40 zrnyobiv40}</td><td>（連携用）予備項目Ｖ４０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnayosetaisyousegkbn zrnnayosetaisyousegkbn}</td><td>（連携用）名寄せ対象者ＳＥＧ区分</td><td align="center">{@link PKZT_HnsyScrMeigiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnayosetaisyoukojinkbn zrnnayosetaisyoukojinkbn}</td><td>（連携用）名寄せ対象者個人区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv46 zrnyobiv46}</td><td>（連携用）予備項目Ｖ４６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntodouhukencd1 zrntodouhukencd1}</td><td>（連携用）都道府県コード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntodouhukencd2 zrntodouhukencd2}</td><td>（連携用）都道府県コード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntodouhukencd3 zrntodouhukencd3}</td><td>（連携用）都道府県コード３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv34 zrnyobiv34}</td><td>（連携用）予備項目Ｖ３４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_HnsyScrMeigiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoumetucd zrnsyoumetucd}</td><td>（連携用）消滅コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsymtymd2 zrnsymtymd2}</td><td>（連携用）消滅年月日＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbohaiyakkandisp zrnbohaiyakkandisp}</td><td>（連携用）暴排条項導入約款適用表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmeihenymd zrnmeihenymd}</td><td>（連携用）名義変更年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseiymdseitsymd zrnseiymdseitsymd}</td><td>（連携用）生年月日性訂正年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtityuutohukaymd zrnkzkmrtityuutohukaymd}</td><td>（連携用）家族マル定中途付加年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykmfkykknnm zrnkykmfkykknnm}</td><td>（連携用）契約ＭＦ契約者カナ姓名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykmfkykkjnm zrnkykmfkykkjnm}</td><td>（連携用）契約ＭＦ契約者漢字姓名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykmfkykseiymd zrnkykmfkykseiymd}</td><td>（連携用）契約ＭＦ契約者生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykmfhhkknnm zrnkykmfhhkknnm}</td><td>（連携用）契約ＭＦ被保険者カナ姓名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykmfhhkkjnm zrnkykmfhhkkjnm}</td><td>（連携用）契約ＭＦ被保険者漢字姓名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykmfhhkseiymd zrnkykmfhhkseiymd}</td><td>（連携用）契約ＭＦ被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykmfdai2knnm zrnkykmfdai2knnm}</td><td>（連携用）契約ＭＦ第２被カナ姓名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykmfdai2kjnm zrnkykmfdai2kjnm}</td><td>（連携用）契約ＭＦ第２被漢字姓名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykmfdai2seiymd zrnkykmfdai2seiymd}</td><td>（連携用）契約ＭＦ第２被生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykmfsbuktknnm zrnkykmfsbuktknnm}</td><td>（連携用）契約ＭＦ死亡受取人カナ姓名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykmfsbuktkjnm zrnkykmfsbuktkjnm}</td><td>（連携用）契約ＭＦ死亡受取人漢字姓名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykmfsbuktseiymd zrnkykmfsbuktseiymd}</td><td>（連携用）契約ＭＦ死亡受取人生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykmfdai2ktknnm zrnkykmfdai2ktknnm}</td><td>（連携用）契約ＭＦ第２受取人カナ姓名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykmfdai2ktkjnm zrnkykmfdai2ktkjnm}</td><td>（連携用）契約ＭＦ第２受取人漢字姓名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykmfdai2ktseiymd zrnkykmfdai2ktseiymd}</td><td>（連携用）契約ＭＦ第２受取人生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykmfmnkktknnm zrnkykmfmnkktknnm}</td><td>（連携用）契約ＭＦ満期受取人カナ姓名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykmfmnkktkjnm zrnkykmfmnkktkjnm}</td><td>（連携用）契約ＭＦ満期受取人漢字姓名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykmfmnkktseiymd zrnkykmfmnkktseiymd}</td><td>（連携用）契約ＭＦ満期受取人生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndntcd2 zrndntcd2}</td><td>（連携用）団体コード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjdntnm zrnkjdntnm}</td><td>（連携用）漢字団体名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrinjikaisouhyouji zrnrinjikaisouhyouji}</td><td>（連携用）臨時回送表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv34x2 zrnyobiv34x2}</td><td>（連携用）予備項目Ｖ３４＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsgtaisyoukbn zrnsgtaisyoukbn}</td><td>（連携用）照合対象区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv39 zrnyobiv39}</td><td>（連携用）予備項目Ｖ３９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuuseihjnnm zrnsyuuseihjnnm}</td><td>（連携用）修正法人名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv75 zrnyobiv75}</td><td>（連携用）予備項目Ｖ７５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsysyno zrnsysyno}</td><td>（連携用）証書番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsueokikaisiymd zrnsueokikaisiymd}</td><td>（連携用）据置開始年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhasseiriyuukbnscreen zrnhasseiriyuukbnscreen}</td><td>（連携用）発生理由区分（反社スクリーニング）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsueokijtkbn zrnsueokijtkbn}</td><td>（連携用）据置状態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntaisyoufilekbn zrntaisyoufilekbn}</td><td>（連携用）対象ファイル区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbohaiyakkandisp2 zrnbohaiyakkandisp2}</td><td>（連携用）暴排条項導入約款適用表示２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmeihenymd2 zrnmeihenymd2}</td><td>（連携用）名義変更年月日２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyoumetucd zrnnksyoumetucd}</td><td>（連携用）年金消滅コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv7 zrnyobiv7}</td><td>（連携用）予備項目Ｖ７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv20 zrnyobiv20}</td><td>（連携用）予備項目Ｖ２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_HnsyScrMeigiRn
 * @see     PKZT_HnsyScrMeigiRn
 * @see     QZT_HnsyScrMeigiRn
 * @see     GenQZT_HnsyScrMeigiRn
 */
@MappedSuperclass
@Table(name=GenZT_HnsyScrMeigiRn.TABLE_NAME)
@IdClass(value=PKZT_HnsyScrMeigiRn.class)
public abstract class GenZT_HnsyScrMeigiRn extends AbstractExDBEntityForZDB<ZT_HnsyScrMeigiRn, PKZT_HnsyScrMeigiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_HnsyScrMeigiRn";
    public static final String ZRNHNSYRECORDKBN         = "zrnhnsyrecordkbn";
    public static final String ZRNKIJYUNYM              = "zrnkijyunym";
    public static final String ZRNTAISYOUNMKN           = "zrntaisyounmkn";
    public static final String ZRNTAISYOUNMKJ           = "zrntaisyounmkj";
    public static final String ZRNTAISYOUSEIYMD         = "zrntaisyouseiymd";
    public static final String ZRNTSNSKNEWYNO           = "zrntsnsknewyno";
    public static final String ZRNTSNSKNEWTIKUCD        = "zrntsnsknewtikucd";
    public static final String ZRNHHKNNEWYNO            = "zrnhhknnewyno";
    public static final String ZRNHHKNNEWTIKUCD         = "zrnhhknnewtikucd";
    public static final String ZRNKSTKANNISKNEWYNO      = "zrnkstkannisknewyno";
    public static final String ZRNKSTKANNISKNEWTIKUCD   = "zrnkstkannisknewtikucd";
    public static final String ZRNDNTNEWYNO             = "zrndntnewyno";
    public static final String ZRNDNTNEWTIKUCD          = "zrndntnewtikucd";
    public static final String ZRNKANJITSINKAIADR       = "zrnkanjitsinkaiadr";
    public static final String ZRNTODOUHUKENNM          = "zrntodouhukennm";
    public static final String ZRNSIGUNNM               = "zrnsigunnm";
    public static final String ZRNSOSIKICD1             = "zrnsosikicd1";
    public static final String ZRNSOSIKICD2             = "zrnsosikicd2";
    public static final String ZRNSOSIKICD3             = "zrnsosikicd3";
    public static final String ZRNSOSIKICD4             = "zrnsosikicd4";
    public static final String ZRNSOSIKICD5             = "zrnsosikicd5";
    public static final String ZRNHHKNHNSKTODOUHUKENCD  = "zrnhhknhnsktodouhukencd";
    public static final String ZRNKANKEINMKN1           = "zrnkankeinmkn1";
    public static final String ZRNKANKEINMKN2           = "zrnkankeinmkn2";
    public static final String ZRNKANKEINMKN3           = "zrnkankeinmkn3";
    public static final String ZRNKANKEINMKN4           = "zrnkankeinmkn4";
    public static final String ZRNKANKEINMKN5           = "zrnkankeinmkn5";
    public static final String ZRNKANKEINMKJ1           = "zrnkankeinmkj1";
    public static final String ZRNKANKEINMKJ2           = "zrnkankeinmkj2";
    public static final String ZRNKANKEINMKJ3           = "zrnkankeinmkj3";
    public static final String ZRNKANKEINMKJ4           = "zrnkankeinmkj4";
    public static final String ZRNKANKEINMKJ5           = "zrnkankeinmkj5";
    public static final String ZRNHRKKEIROKBN           = "zrnhrkkeirokbn";
    public static final String ZRNDNTCD                 = "zrndntcd";
    public static final String ZRNDNTNM                 = "zrndntnm";
    public static final String ZRNDNTSYZKCD             = "zrndntsyzkcd";
    public static final String ZRNDNTKOJINCD            = "zrndntkojincd";
    public static final String ZRNKZHURIKAEBANKCD       = "zrnkzhurikaebankcd";
    public static final String ZRNKZHURIKAESITENCD      = "zrnkzhurikaesitencd";
    public static final String ZRNKZHURIKAEYOKINKBN     = "zrnkzhurikaeyokinkbn";
    public static final String ZRNKZHURIKAEKOUZANO      = "zrnkzhurikaekouzano";
    public static final String ZRNTSINTELNO             = "zrntsintelno";
    public static final String ZRNHJNCD                 = "zrnhjncd";
    public static final String ZRNHJNJIGYOSYOCD         = "zrnhjnjigyosyocd";
    public static final String ZRNSYMTYMD               = "zrnsymtymd";
    public static final String ZRNSYOKUGYOUCD           = "zrnsyokugyoucd";
    public static final String ZRNDAI2HHKNYNO           = "zrndai2hhknyno";
    public static final String ZRNDAI2HHKNNEWTIKUCD     = "zrndai2hhknnewtikucd";
    public static final String ZRNDAI2HHKNTODOUHUKENCD  = "zrndai2hhkntodouhukencd";
    public static final String ZRNSYOKUGYOUCD2          = "zrnsyokugyoucd2";
    public static final String ZRNYOBIV118              = "zrnyobiv118";
    public static final String ZRNSKINNM                = "zrnskinnm";
    public static final String ZRNYOBIV40               = "zrnyobiv40";
    public static final String ZRNNAYOSETAISYOUSEGKBN   = "zrnnayosetaisyousegkbn";
    public static final String ZRNNAYOSETAISYOUKOJINKBN = "zrnnayosetaisyoukojinkbn";
    public static final String ZRNYOBIV46               = "zrnyobiv46";
    public static final String ZRNTODOUHUKENCD1         = "zrntodouhukencd1";
    public static final String ZRNTODOUHUKENCD2         = "zrntodouhukencd2";
    public static final String ZRNTODOUHUKENCD3         = "zrntodouhukencd3";
    public static final String ZRNYOBIV34               = "zrnyobiv34";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNSYOUMETUCD            = "zrnsyoumetucd";
    public static final String ZRNSYMTYMD2              = "zrnsymtymd2";
    public static final String ZRNBOHAIYAKKANDISP       = "zrnbohaiyakkandisp";
    public static final String ZRNMEIHENYMD             = "zrnmeihenymd";
    public static final String ZRNSEIYMDSEITSYMD        = "zrnseiymdseitsymd";
    public static final String ZRNKZKMRTITYUUTOHUKAYMD  = "zrnkzkmrtityuutohukaymd";
    public static final String ZRNKYKMFKYKKNNM          = "zrnkykmfkykknnm";
    public static final String ZRNKYKMFKYKKJNM          = "zrnkykmfkykkjnm";
    public static final String ZRNKYKMFKYKSEIYMD        = "zrnkykmfkykseiymd";
    public static final String ZRNKYKMFHHKKNNM          = "zrnkykmfhhkknnm";
    public static final String ZRNKYKMFHHKKJNM          = "zrnkykmfhhkkjnm";
    public static final String ZRNKYKMFHHKSEIYMD        = "zrnkykmfhhkseiymd";
    public static final String ZRNKYKMFDAI2KNNM         = "zrnkykmfdai2knnm";
    public static final String ZRNKYKMFDAI2KJNM         = "zrnkykmfdai2kjnm";
    public static final String ZRNKYKMFDAI2SEIYMD       = "zrnkykmfdai2seiymd";
    public static final String ZRNKYKMFSBUKTKNNM        = "zrnkykmfsbuktknnm";
    public static final String ZRNKYKMFSBUKTKJNM        = "zrnkykmfsbuktkjnm";
    public static final String ZRNKYKMFSBUKTSEIYMD      = "zrnkykmfsbuktseiymd";
    public static final String ZRNKYKMFDAI2KTKNNM       = "zrnkykmfdai2ktknnm";
    public static final String ZRNKYKMFDAI2KTKJNM       = "zrnkykmfdai2ktkjnm";
    public static final String ZRNKYKMFDAI2KTSEIYMD     = "zrnkykmfdai2ktseiymd";
    public static final String ZRNKYKMFMNKKTKNNM        = "zrnkykmfmnkktknnm";
    public static final String ZRNKYKMFMNKKTKJNM        = "zrnkykmfmnkktkjnm";
    public static final String ZRNKYKMFMNKKTSEIYMD      = "zrnkykmfmnkktseiymd";
    public static final String ZRNDNTCD2                = "zrndntcd2";
    public static final String ZRNKJDNTNM               = "zrnkjdntnm";
    public static final String ZRNRINJIKAISOUHYOUJI     = "zrnrinjikaisouhyouji";
    public static final String ZRNYOBIV34X2             = "zrnyobiv34x2";
    public static final String ZRNSGTAISYOUKBN          = "zrnsgtaisyoukbn";
    public static final String ZRNYOBIV39               = "zrnyobiv39";
    public static final String ZRNSYUUSEIHJNNM          = "zrnsyuuseihjnnm";
    public static final String ZRNYOBIV75               = "zrnyobiv75";
    public static final String ZRNSYSYNO                = "zrnsysyno";
    public static final String ZRNSUEOKIKAISIYMD        = "zrnsueokikaisiymd";
    public static final String ZRNHASSEIRIYUUKBNSCREEN  = "zrnhasseiriyuukbnscreen";
    public static final String ZRNSUEOKIJTKBN           = "zrnsueokijtkbn";
    public static final String ZRNTAISYOUFILEKBN        = "zrntaisyoufilekbn";
    public static final String ZRNBOHAIYAKKANDISP2      = "zrnbohaiyakkandisp2";
    public static final String ZRNMEIHENYMD2            = "zrnmeihenymd2";
    public static final String ZRNNKSYOUMETUCD          = "zrnnksyoumetucd";
    public static final String ZRNYOBIV7                = "zrnyobiv7";
    public static final String ZRNYOBIV20               = "zrnyobiv20";

    private final PKZT_HnsyScrMeigiRn primaryKey;

    public GenZT_HnsyScrMeigiRn() {
        primaryKey = new PKZT_HnsyScrMeigiRn();
    }

    public GenZT_HnsyScrMeigiRn(
        String pZrntaisyounmkn,
        String pZrntaisyounmkj,
        String pZrntaisyouseiymd,
        String pZrnnayosetaisyousegkbn,
        String pZrnsyono
    ) {
        primaryKey = new PKZT_HnsyScrMeigiRn(
            pZrntaisyounmkn,
            pZrntaisyounmkj,
            pZrntaisyouseiymd,
            pZrnnayosetaisyousegkbn,
            pZrnsyono
        );
    }

    @Transient
    @Override
    public PKZT_HnsyScrMeigiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_HnsyScrMeigiRn> getMetaClass() {
        return QZT_HnsyScrMeigiRn.class;
    }

    private String zrnhnsyrecordkbn;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNHNSYRECORDKBN)
    public String getZrnhnsyrecordkbn() {
        return zrnhnsyrecordkbn;
    }

    public void setZrnhnsyrecordkbn(String pZrnhnsyrecordkbn) {
        zrnhnsyrecordkbn = pZrnhnsyrecordkbn;
    }

    private String zrnkijyunym;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKIJYUNYM)
    public String getZrnkijyunym() {
        return zrnkijyunym;
    }

    public void setZrnkijyunym(String pZrnkijyunym) {
        zrnkijyunym = pZrnkijyunym;
    }

    @Id
    @Column(name=GenZT_HnsyScrMeigiRn.ZRNTAISYOUNMKN)
    public String getZrntaisyounmkn() {
        return getPrimaryKey().getZrntaisyounmkn();
    }

    public void setZrntaisyounmkn(String pZrntaisyounmkn) {
        getPrimaryKey().setZrntaisyounmkn(pZrntaisyounmkn);
    }

    @Id
    @Column(name=GenZT_HnsyScrMeigiRn.ZRNTAISYOUNMKJ)
    public String getZrntaisyounmkj() {
        return getPrimaryKey().getZrntaisyounmkj();
    }

    @DataConvert("toMultiByte")
    public void setZrntaisyounmkj(String pZrntaisyounmkj) {
        getPrimaryKey().setZrntaisyounmkj(pZrntaisyounmkj);
    }

    @Id
    @Column(name=GenZT_HnsyScrMeigiRn.ZRNTAISYOUSEIYMD)
    public String getZrntaisyouseiymd() {
        return getPrimaryKey().getZrntaisyouseiymd();
    }

    public void setZrntaisyouseiymd(String pZrntaisyouseiymd) {
        getPrimaryKey().setZrntaisyouseiymd(pZrntaisyouseiymd);
    }

    private String zrntsnsknewyno;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNTSNSKNEWYNO)
    public String getZrntsnsknewyno() {
        return zrntsnsknewyno;
    }

    public void setZrntsnsknewyno(String pZrntsnsknewyno) {
        zrntsnsknewyno = pZrntsnsknewyno;
    }

    private String zrntsnsknewtikucd;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNTSNSKNEWTIKUCD)
    public String getZrntsnsknewtikucd() {
        return zrntsnsknewtikucd;
    }

    public void setZrntsnsknewtikucd(String pZrntsnsknewtikucd) {
        zrntsnsknewtikucd = pZrntsnsknewtikucd;
    }

    private String zrnhhknnewyno;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNHHKNNEWYNO)
    public String getZrnhhknnewyno() {
        return zrnhhknnewyno;
    }

    public void setZrnhhknnewyno(String pZrnhhknnewyno) {
        zrnhhknnewyno = pZrnhhknnewyno;
    }

    private String zrnhhknnewtikucd;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNHHKNNEWTIKUCD)
    public String getZrnhhknnewtikucd() {
        return zrnhhknnewtikucd;
    }

    public void setZrnhhknnewtikucd(String pZrnhhknnewtikucd) {
        zrnhhknnewtikucd = pZrnhhknnewtikucd;
    }

    private String zrnkstkannisknewyno;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKSTKANNISKNEWYNO)
    public String getZrnkstkannisknewyno() {
        return zrnkstkannisknewyno;
    }

    public void setZrnkstkannisknewyno(String pZrnkstkannisknewyno) {
        zrnkstkannisknewyno = pZrnkstkannisknewyno;
    }

    private String zrnkstkannisknewtikucd;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKSTKANNISKNEWTIKUCD)
    public String getZrnkstkannisknewtikucd() {
        return zrnkstkannisknewtikucd;
    }

    public void setZrnkstkannisknewtikucd(String pZrnkstkannisknewtikucd) {
        zrnkstkannisknewtikucd = pZrnkstkannisknewtikucd;
    }

    private String zrndntnewyno;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNDNTNEWYNO)
    public String getZrndntnewyno() {
        return zrndntnewyno;
    }

    public void setZrndntnewyno(String pZrndntnewyno) {
        zrndntnewyno = pZrndntnewyno;
    }

    private String zrndntnewtikucd;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNDNTNEWTIKUCD)
    public String getZrndntnewtikucd() {
        return zrndntnewtikucd;
    }

    public void setZrndntnewtikucd(String pZrndntnewtikucd) {
        zrndntnewtikucd = pZrndntnewtikucd;
    }

    private String zrnkanjitsinkaiadr;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKANJITSINKAIADR)
    public String getZrnkanjitsinkaiadr() {
        return zrnkanjitsinkaiadr;
    }

    @DataConvert("toMultiByte")
    public void setZrnkanjitsinkaiadr(String pZrnkanjitsinkaiadr) {
        zrnkanjitsinkaiadr = pZrnkanjitsinkaiadr;
    }

    private String zrntodouhukennm;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNTODOUHUKENNM)
    public String getZrntodouhukennm() {
        return zrntodouhukennm;
    }

    public void setZrntodouhukennm(String pZrntodouhukennm) {
        zrntodouhukennm = pZrntodouhukennm;
    }

    private String zrnsigunnm;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNSIGUNNM)
    public String getZrnsigunnm() {
        return zrnsigunnm;
    }

    public void setZrnsigunnm(String pZrnsigunnm) {
        zrnsigunnm = pZrnsigunnm;
    }

    private String zrnsosikicd1;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNSOSIKICD1)
    public String getZrnsosikicd1() {
        return zrnsosikicd1;
    }

    public void setZrnsosikicd1(String pZrnsosikicd1) {
        zrnsosikicd1 = pZrnsosikicd1;
    }

    private String zrnsosikicd2;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNSOSIKICD2)
    public String getZrnsosikicd2() {
        return zrnsosikicd2;
    }

    public void setZrnsosikicd2(String pZrnsosikicd2) {
        zrnsosikicd2 = pZrnsosikicd2;
    }

    private String zrnsosikicd3;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNSOSIKICD3)
    public String getZrnsosikicd3() {
        return zrnsosikicd3;
    }

    public void setZrnsosikicd3(String pZrnsosikicd3) {
        zrnsosikicd3 = pZrnsosikicd3;
    }

    private String zrnsosikicd4;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNSOSIKICD4)
    public String getZrnsosikicd4() {
        return zrnsosikicd4;
    }

    public void setZrnsosikicd4(String pZrnsosikicd4) {
        zrnsosikicd4 = pZrnsosikicd4;
    }

    private String zrnsosikicd5;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNSOSIKICD5)
    public String getZrnsosikicd5() {
        return zrnsosikicd5;
    }

    public void setZrnsosikicd5(String pZrnsosikicd5) {
        zrnsosikicd5 = pZrnsosikicd5;
    }

    private String zrnhhknhnsktodouhukencd;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNHHKNHNSKTODOUHUKENCD)
    public String getZrnhhknhnsktodouhukencd() {
        return zrnhhknhnsktodouhukencd;
    }

    public void setZrnhhknhnsktodouhukencd(String pZrnhhknhnsktodouhukencd) {
        zrnhhknhnsktodouhukencd = pZrnhhknhnsktodouhukencd;
    }

    private String zrnkankeinmkn1;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKANKEINMKN1)
    public String getZrnkankeinmkn1() {
        return zrnkankeinmkn1;
    }

    public void setZrnkankeinmkn1(String pZrnkankeinmkn1) {
        zrnkankeinmkn1 = pZrnkankeinmkn1;
    }

    private String zrnkankeinmkn2;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKANKEINMKN2)
    public String getZrnkankeinmkn2() {
        return zrnkankeinmkn2;
    }

    public void setZrnkankeinmkn2(String pZrnkankeinmkn2) {
        zrnkankeinmkn2 = pZrnkankeinmkn2;
    }

    private String zrnkankeinmkn3;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKANKEINMKN3)
    public String getZrnkankeinmkn3() {
        return zrnkankeinmkn3;
    }

    public void setZrnkankeinmkn3(String pZrnkankeinmkn3) {
        zrnkankeinmkn3 = pZrnkankeinmkn3;
    }

    private String zrnkankeinmkn4;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKANKEINMKN4)
    public String getZrnkankeinmkn4() {
        return zrnkankeinmkn4;
    }

    public void setZrnkankeinmkn4(String pZrnkankeinmkn4) {
        zrnkankeinmkn4 = pZrnkankeinmkn4;
    }

    private String zrnkankeinmkn5;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKANKEINMKN5)
    public String getZrnkankeinmkn5() {
        return zrnkankeinmkn5;
    }

    public void setZrnkankeinmkn5(String pZrnkankeinmkn5) {
        zrnkankeinmkn5 = pZrnkankeinmkn5;
    }

    private String zrnkankeinmkj1;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKANKEINMKJ1)
    public String getZrnkankeinmkj1() {
        return zrnkankeinmkj1;
    }

    @DataConvert("toMultiByte")
    public void setZrnkankeinmkj1(String pZrnkankeinmkj1) {
        zrnkankeinmkj1 = pZrnkankeinmkj1;
    }

    private String zrnkankeinmkj2;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKANKEINMKJ2)
    public String getZrnkankeinmkj2() {
        return zrnkankeinmkj2;
    }

    @DataConvert("toMultiByte")
    public void setZrnkankeinmkj2(String pZrnkankeinmkj2) {
        zrnkankeinmkj2 = pZrnkankeinmkj2;
    }

    private String zrnkankeinmkj3;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKANKEINMKJ3)
    public String getZrnkankeinmkj3() {
        return zrnkankeinmkj3;
    }

    @DataConvert("toMultiByte")
    public void setZrnkankeinmkj3(String pZrnkankeinmkj3) {
        zrnkankeinmkj3 = pZrnkankeinmkj3;
    }

    private String zrnkankeinmkj4;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKANKEINMKJ4)
    public String getZrnkankeinmkj4() {
        return zrnkankeinmkj4;
    }

    @DataConvert("toMultiByte")
    public void setZrnkankeinmkj4(String pZrnkankeinmkj4) {
        zrnkankeinmkj4 = pZrnkankeinmkj4;
    }

    private String zrnkankeinmkj5;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKANKEINMKJ5)
    public String getZrnkankeinmkj5() {
        return zrnkankeinmkj5;
    }

    @DataConvert("toMultiByte")
    public void setZrnkankeinmkj5(String pZrnkankeinmkj5) {
        zrnkankeinmkj5 = pZrnkankeinmkj5;
    }

    private String zrnhrkkeirokbn;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNHRKKEIROKBN)
    public String getZrnhrkkeirokbn() {
        return zrnhrkkeirokbn;
    }

    public void setZrnhrkkeirokbn(String pZrnhrkkeirokbn) {
        zrnhrkkeirokbn = pZrnhrkkeirokbn;
    }

    private String zrndntcd;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNDNTCD)
    public String getZrndntcd() {
        return zrndntcd;
    }

    public void setZrndntcd(String pZrndntcd) {
        zrndntcd = pZrndntcd;
    }

    private String zrndntnm;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNDNTNM)
    public String getZrndntnm() {
        return zrndntnm;
    }

    public void setZrndntnm(String pZrndntnm) {
        zrndntnm = pZrndntnm;
    }

    private String zrndntsyzkcd;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNDNTSYZKCD)
    public String getZrndntsyzkcd() {
        return zrndntsyzkcd;
    }

    public void setZrndntsyzkcd(String pZrndntsyzkcd) {
        zrndntsyzkcd = pZrndntsyzkcd;
    }

    private String zrndntkojincd;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNDNTKOJINCD)
    public String getZrndntkojincd() {
        return zrndntkojincd;
    }

    public void setZrndntkojincd(String pZrndntkojincd) {
        zrndntkojincd = pZrndntkojincd;
    }

    private String zrnkzhurikaebankcd;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKZHURIKAEBANKCD)
    public String getZrnkzhurikaebankcd() {
        return zrnkzhurikaebankcd;
    }

    public void setZrnkzhurikaebankcd(String pZrnkzhurikaebankcd) {
        zrnkzhurikaebankcd = pZrnkzhurikaebankcd;
    }

    private String zrnkzhurikaesitencd;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKZHURIKAESITENCD)
    public String getZrnkzhurikaesitencd() {
        return zrnkzhurikaesitencd;
    }

    public void setZrnkzhurikaesitencd(String pZrnkzhurikaesitencd) {
        zrnkzhurikaesitencd = pZrnkzhurikaesitencd;
    }

    private String zrnkzhurikaeyokinkbn;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKZHURIKAEYOKINKBN)
    public String getZrnkzhurikaeyokinkbn() {
        return zrnkzhurikaeyokinkbn;
    }

    public void setZrnkzhurikaeyokinkbn(String pZrnkzhurikaeyokinkbn) {
        zrnkzhurikaeyokinkbn = pZrnkzhurikaeyokinkbn;
    }

    private String zrnkzhurikaekouzano;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKZHURIKAEKOUZANO)
    public String getZrnkzhurikaekouzano() {
        return zrnkzhurikaekouzano;
    }

    public void setZrnkzhurikaekouzano(String pZrnkzhurikaekouzano) {
        zrnkzhurikaekouzano = pZrnkzhurikaekouzano;
    }

    private String zrntsintelno;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNTSINTELNO)
    public String getZrntsintelno() {
        return zrntsintelno;
    }

    public void setZrntsintelno(String pZrntsintelno) {
        zrntsintelno = pZrntsintelno;
    }

    private String zrnhjncd;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNHJNCD)
    public String getZrnhjncd() {
        return zrnhjncd;
    }

    public void setZrnhjncd(String pZrnhjncd) {
        zrnhjncd = pZrnhjncd;
    }

    private String zrnhjnjigyosyocd;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNHJNJIGYOSYOCD)
    public String getZrnhjnjigyosyocd() {
        return zrnhjnjigyosyocd;
    }

    public void setZrnhjnjigyosyocd(String pZrnhjnjigyosyocd) {
        zrnhjnjigyosyocd = pZrnhjnjigyosyocd;
    }

    private String zrnsymtymd;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNSYMTYMD)
    public String getZrnsymtymd() {
        return zrnsymtymd;
    }

    public void setZrnsymtymd(String pZrnsymtymd) {
        zrnsymtymd = pZrnsymtymd;
    }

    private String zrnsyokugyoucd;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNSYOKUGYOUCD)
    public String getZrnsyokugyoucd() {
        return zrnsyokugyoucd;
    }

    public void setZrnsyokugyoucd(String pZrnsyokugyoucd) {
        zrnsyokugyoucd = pZrnsyokugyoucd;
    }

    private String zrndai2hhknyno;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNDAI2HHKNYNO)
    public String getZrndai2hhknyno() {
        return zrndai2hhknyno;
    }

    public void setZrndai2hhknyno(String pZrndai2hhknyno) {
        zrndai2hhknyno = pZrndai2hhknyno;
    }

    private String zrndai2hhknnewtikucd;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNDAI2HHKNNEWTIKUCD)
    public String getZrndai2hhknnewtikucd() {
        return zrndai2hhknnewtikucd;
    }

    public void setZrndai2hhknnewtikucd(String pZrndai2hhknnewtikucd) {
        zrndai2hhknnewtikucd = pZrndai2hhknnewtikucd;
    }

    private String zrndai2hhkntodouhukencd;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNDAI2HHKNTODOUHUKENCD)
    public String getZrndai2hhkntodouhukencd() {
        return zrndai2hhkntodouhukencd;
    }

    public void setZrndai2hhkntodouhukencd(String pZrndai2hhkntodouhukencd) {
        zrndai2hhkntodouhukencd = pZrndai2hhkntodouhukencd;
    }

    private String zrnsyokugyoucd2;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNSYOKUGYOUCD2)
    public String getZrnsyokugyoucd2() {
        return zrnsyokugyoucd2;
    }

    public void setZrnsyokugyoucd2(String pZrnsyokugyoucd2) {
        zrnsyokugyoucd2 = pZrnsyokugyoucd2;
    }

    private String zrnyobiv118;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNYOBIV118)
    public String getZrnyobiv118() {
        return zrnyobiv118;
    }

    public void setZrnyobiv118(String pZrnyobiv118) {
        zrnyobiv118 = pZrnyobiv118;
    }

    private String zrnskinnm;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNSKINNM)
    public String getZrnskinnm() {
        return zrnskinnm;
    }

    public void setZrnskinnm(String pZrnskinnm) {
        zrnskinnm = pZrnskinnm;
    }

    private String zrnyobiv40;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNYOBIV40)
    public String getZrnyobiv40() {
        return zrnyobiv40;
    }

    public void setZrnyobiv40(String pZrnyobiv40) {
        zrnyobiv40 = pZrnyobiv40;
    }

    @Id
    @Column(name=GenZT_HnsyScrMeigiRn.ZRNNAYOSETAISYOUSEGKBN)
    public String getZrnnayosetaisyousegkbn() {
        return getPrimaryKey().getZrnnayosetaisyousegkbn();
    }

    public void setZrnnayosetaisyousegkbn(String pZrnnayosetaisyousegkbn) {
        getPrimaryKey().setZrnnayosetaisyousegkbn(pZrnnayosetaisyousegkbn);
    }

    private String zrnnayosetaisyoukojinkbn;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNNAYOSETAISYOUKOJINKBN)
    public String getZrnnayosetaisyoukojinkbn() {
        return zrnnayosetaisyoukojinkbn;
    }

    public void setZrnnayosetaisyoukojinkbn(String pZrnnayosetaisyoukojinkbn) {
        zrnnayosetaisyoukojinkbn = pZrnnayosetaisyoukojinkbn;
    }

    private String zrnyobiv46;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNYOBIV46)
    public String getZrnyobiv46() {
        return zrnyobiv46;
    }

    public void setZrnyobiv46(String pZrnyobiv46) {
        zrnyobiv46 = pZrnyobiv46;
    }

    private String zrntodouhukencd1;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNTODOUHUKENCD1)
    public String getZrntodouhukencd1() {
        return zrntodouhukencd1;
    }

    public void setZrntodouhukencd1(String pZrntodouhukencd1) {
        zrntodouhukencd1 = pZrntodouhukencd1;
    }

    private String zrntodouhukencd2;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNTODOUHUKENCD2)
    public String getZrntodouhukencd2() {
        return zrntodouhukencd2;
    }

    public void setZrntodouhukencd2(String pZrntodouhukencd2) {
        zrntodouhukencd2 = pZrntodouhukencd2;
    }

    private String zrntodouhukencd3;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNTODOUHUKENCD3)
    public String getZrntodouhukencd3() {
        return zrntodouhukencd3;
    }

    public void setZrntodouhukencd3(String pZrntodouhukencd3) {
        zrntodouhukencd3 = pZrntodouhukencd3;
    }

    private String zrnyobiv34;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNYOBIV34)
    public String getZrnyobiv34() {
        return zrnyobiv34;
    }

    public void setZrnyobiv34(String pZrnyobiv34) {
        zrnyobiv34 = pZrnyobiv34;
    }

    @Id
    @Column(name=GenZT_HnsyScrMeigiRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnsyoumetucd;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNSYOUMETUCD)
    public String getZrnsyoumetucd() {
        return zrnsyoumetucd;
    }

    public void setZrnsyoumetucd(String pZrnsyoumetucd) {
        zrnsyoumetucd = pZrnsyoumetucd;
    }

    private String zrnsymtymd2;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNSYMTYMD2)
    public String getZrnsymtymd2() {
        return zrnsymtymd2;
    }

    public void setZrnsymtymd2(String pZrnsymtymd2) {
        zrnsymtymd2 = pZrnsymtymd2;
    }

    private String zrnbohaiyakkandisp;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNBOHAIYAKKANDISP)
    public String getZrnbohaiyakkandisp() {
        return zrnbohaiyakkandisp;
    }

    public void setZrnbohaiyakkandisp(String pZrnbohaiyakkandisp) {
        zrnbohaiyakkandisp = pZrnbohaiyakkandisp;
    }

    private String zrnmeihenymd;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNMEIHENYMD)
    public String getZrnmeihenymd() {
        return zrnmeihenymd;
    }

    public void setZrnmeihenymd(String pZrnmeihenymd) {
        zrnmeihenymd = pZrnmeihenymd;
    }

    private String zrnseiymdseitsymd;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNSEIYMDSEITSYMD)
    public String getZrnseiymdseitsymd() {
        return zrnseiymdseitsymd;
    }

    public void setZrnseiymdseitsymd(String pZrnseiymdseitsymd) {
        zrnseiymdseitsymd = pZrnseiymdseitsymd;
    }

    private String zrnkzkmrtityuutohukaymd;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKZKMRTITYUUTOHUKAYMD)
    public String getZrnkzkmrtityuutohukaymd() {
        return zrnkzkmrtityuutohukaymd;
    }

    public void setZrnkzkmrtityuutohukaymd(String pZrnkzkmrtityuutohukaymd) {
        zrnkzkmrtityuutohukaymd = pZrnkzkmrtityuutohukaymd;
    }

    private String zrnkykmfkykknnm;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKYKMFKYKKNNM)
    public String getZrnkykmfkykknnm() {
        return zrnkykmfkykknnm;
    }

    public void setZrnkykmfkykknnm(String pZrnkykmfkykknnm) {
        zrnkykmfkykknnm = pZrnkykmfkykknnm;
    }

    private String zrnkykmfkykkjnm;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKYKMFKYKKJNM)
    public String getZrnkykmfkykkjnm() {
        return zrnkykmfkykkjnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkykmfkykkjnm(String pZrnkykmfkykkjnm) {
        zrnkykmfkykkjnm = pZrnkykmfkykkjnm;
    }

    private String zrnkykmfkykseiymd;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKYKMFKYKSEIYMD)
    public String getZrnkykmfkykseiymd() {
        return zrnkykmfkykseiymd;
    }

    public void setZrnkykmfkykseiymd(String pZrnkykmfkykseiymd) {
        zrnkykmfkykseiymd = pZrnkykmfkykseiymd;
    }

    private String zrnkykmfhhkknnm;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKYKMFHHKKNNM)
    public String getZrnkykmfhhkknnm() {
        return zrnkykmfhhkknnm;
    }

    public void setZrnkykmfhhkknnm(String pZrnkykmfhhkknnm) {
        zrnkykmfhhkknnm = pZrnkykmfhhkknnm;
    }

    private String zrnkykmfhhkkjnm;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKYKMFHHKKJNM)
    public String getZrnkykmfhhkkjnm() {
        return zrnkykmfhhkkjnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkykmfhhkkjnm(String pZrnkykmfhhkkjnm) {
        zrnkykmfhhkkjnm = pZrnkykmfhhkkjnm;
    }

    private String zrnkykmfhhkseiymd;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKYKMFHHKSEIYMD)
    public String getZrnkykmfhhkseiymd() {
        return zrnkykmfhhkseiymd;
    }

    public void setZrnkykmfhhkseiymd(String pZrnkykmfhhkseiymd) {
        zrnkykmfhhkseiymd = pZrnkykmfhhkseiymd;
    }

    private String zrnkykmfdai2knnm;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKYKMFDAI2KNNM)
    public String getZrnkykmfdai2knnm() {
        return zrnkykmfdai2knnm;
    }

    public void setZrnkykmfdai2knnm(String pZrnkykmfdai2knnm) {
        zrnkykmfdai2knnm = pZrnkykmfdai2knnm;
    }

    private String zrnkykmfdai2kjnm;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKYKMFDAI2KJNM)
    public String getZrnkykmfdai2kjnm() {
        return zrnkykmfdai2kjnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkykmfdai2kjnm(String pZrnkykmfdai2kjnm) {
        zrnkykmfdai2kjnm = pZrnkykmfdai2kjnm;
    }

    private String zrnkykmfdai2seiymd;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKYKMFDAI2SEIYMD)
    public String getZrnkykmfdai2seiymd() {
        return zrnkykmfdai2seiymd;
    }

    public void setZrnkykmfdai2seiymd(String pZrnkykmfdai2seiymd) {
        zrnkykmfdai2seiymd = pZrnkykmfdai2seiymd;
    }

    private String zrnkykmfsbuktknnm;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKYKMFSBUKTKNNM)
    public String getZrnkykmfsbuktknnm() {
        return zrnkykmfsbuktknnm;
    }

    public void setZrnkykmfsbuktknnm(String pZrnkykmfsbuktknnm) {
        zrnkykmfsbuktknnm = pZrnkykmfsbuktknnm;
    }

    private String zrnkykmfsbuktkjnm;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKYKMFSBUKTKJNM)
    public String getZrnkykmfsbuktkjnm() {
        return zrnkykmfsbuktkjnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkykmfsbuktkjnm(String pZrnkykmfsbuktkjnm) {
        zrnkykmfsbuktkjnm = pZrnkykmfsbuktkjnm;
    }

    private String zrnkykmfsbuktseiymd;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKYKMFSBUKTSEIYMD)
    public String getZrnkykmfsbuktseiymd() {
        return zrnkykmfsbuktseiymd;
    }

    public void setZrnkykmfsbuktseiymd(String pZrnkykmfsbuktseiymd) {
        zrnkykmfsbuktseiymd = pZrnkykmfsbuktseiymd;
    }

    private String zrnkykmfdai2ktknnm;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKYKMFDAI2KTKNNM)
    public String getZrnkykmfdai2ktknnm() {
        return zrnkykmfdai2ktknnm;
    }

    public void setZrnkykmfdai2ktknnm(String pZrnkykmfdai2ktknnm) {
        zrnkykmfdai2ktknnm = pZrnkykmfdai2ktknnm;
    }

    private String zrnkykmfdai2ktkjnm;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKYKMFDAI2KTKJNM)
    public String getZrnkykmfdai2ktkjnm() {
        return zrnkykmfdai2ktkjnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkykmfdai2ktkjnm(String pZrnkykmfdai2ktkjnm) {
        zrnkykmfdai2ktkjnm = pZrnkykmfdai2ktkjnm;
    }

    private String zrnkykmfdai2ktseiymd;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKYKMFDAI2KTSEIYMD)
    public String getZrnkykmfdai2ktseiymd() {
        return zrnkykmfdai2ktseiymd;
    }

    public void setZrnkykmfdai2ktseiymd(String pZrnkykmfdai2ktseiymd) {
        zrnkykmfdai2ktseiymd = pZrnkykmfdai2ktseiymd;
    }

    private String zrnkykmfmnkktknnm;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKYKMFMNKKTKNNM)
    public String getZrnkykmfmnkktknnm() {
        return zrnkykmfmnkktknnm;
    }

    public void setZrnkykmfmnkktknnm(String pZrnkykmfmnkktknnm) {
        zrnkykmfmnkktknnm = pZrnkykmfmnkktknnm;
    }

    private String zrnkykmfmnkktkjnm;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKYKMFMNKKTKJNM)
    public String getZrnkykmfmnkktkjnm() {
        return zrnkykmfmnkktkjnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkykmfmnkktkjnm(String pZrnkykmfmnkktkjnm) {
        zrnkykmfmnkktkjnm = pZrnkykmfmnkktkjnm;
    }

    private String zrnkykmfmnkktseiymd;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKYKMFMNKKTSEIYMD)
    public String getZrnkykmfmnkktseiymd() {
        return zrnkykmfmnkktseiymd;
    }

    public void setZrnkykmfmnkktseiymd(String pZrnkykmfmnkktseiymd) {
        zrnkykmfmnkktseiymd = pZrnkykmfmnkktseiymd;
    }

    private String zrndntcd2;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNDNTCD2)
    public String getZrndntcd2() {
        return zrndntcd2;
    }

    public void setZrndntcd2(String pZrndntcd2) {
        zrndntcd2 = pZrndntcd2;
    }

    private String zrnkjdntnm;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNKJDNTNM)
    public String getZrnkjdntnm() {
        return zrnkjdntnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjdntnm(String pZrnkjdntnm) {
        zrnkjdntnm = pZrnkjdntnm;
    }

    private String zrnrinjikaisouhyouji;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNRINJIKAISOUHYOUJI)
    public String getZrnrinjikaisouhyouji() {
        return zrnrinjikaisouhyouji;
    }

    public void setZrnrinjikaisouhyouji(String pZrnrinjikaisouhyouji) {
        zrnrinjikaisouhyouji = pZrnrinjikaisouhyouji;
    }

    private String zrnyobiv34x2;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNYOBIV34X2)
    public String getZrnyobiv34x2() {
        return zrnyobiv34x2;
    }

    public void setZrnyobiv34x2(String pZrnyobiv34x2) {
        zrnyobiv34x2 = pZrnyobiv34x2;
    }

    private String zrnsgtaisyoukbn;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNSGTAISYOUKBN)
    public String getZrnsgtaisyoukbn() {
        return zrnsgtaisyoukbn;
    }

    public void setZrnsgtaisyoukbn(String pZrnsgtaisyoukbn) {
        zrnsgtaisyoukbn = pZrnsgtaisyoukbn;
    }

    private String zrnyobiv39;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNYOBIV39)
    public String getZrnyobiv39() {
        return zrnyobiv39;
    }

    public void setZrnyobiv39(String pZrnyobiv39) {
        zrnyobiv39 = pZrnyobiv39;
    }

    private String zrnsyuuseihjnnm;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNSYUUSEIHJNNM)
    public String getZrnsyuuseihjnnm() {
        return zrnsyuuseihjnnm;
    }

    public void setZrnsyuuseihjnnm(String pZrnsyuuseihjnnm) {
        zrnsyuuseihjnnm = pZrnsyuuseihjnnm;
    }

    private String zrnyobiv75;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNYOBIV75)
    public String getZrnyobiv75() {
        return zrnyobiv75;
    }

    public void setZrnyobiv75(String pZrnyobiv75) {
        zrnyobiv75 = pZrnyobiv75;
    }

    private String zrnsysyno;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNSYSYNO)
    public String getZrnsysyno() {
        return zrnsysyno;
    }

    public void setZrnsysyno(String pZrnsysyno) {
        zrnsysyno = pZrnsysyno;
    }

    private String zrnsueokikaisiymd;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNSUEOKIKAISIYMD)
    public String getZrnsueokikaisiymd() {
        return zrnsueokikaisiymd;
    }

    public void setZrnsueokikaisiymd(String pZrnsueokikaisiymd) {
        zrnsueokikaisiymd = pZrnsueokikaisiymd;
    }

    private String zrnhasseiriyuukbnscreen;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNHASSEIRIYUUKBNSCREEN)
    public String getZrnhasseiriyuukbnscreen() {
        return zrnhasseiriyuukbnscreen;
    }

    public void setZrnhasseiriyuukbnscreen(String pZrnhasseiriyuukbnscreen) {
        zrnhasseiriyuukbnscreen = pZrnhasseiriyuukbnscreen;
    }

    private String zrnsueokijtkbn;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNSUEOKIJTKBN)
    public String getZrnsueokijtkbn() {
        return zrnsueokijtkbn;
    }

    public void setZrnsueokijtkbn(String pZrnsueokijtkbn) {
        zrnsueokijtkbn = pZrnsueokijtkbn;
    }

    private String zrntaisyoufilekbn;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNTAISYOUFILEKBN)
    public String getZrntaisyoufilekbn() {
        return zrntaisyoufilekbn;
    }

    public void setZrntaisyoufilekbn(String pZrntaisyoufilekbn) {
        zrntaisyoufilekbn = pZrntaisyoufilekbn;
    }

    private String zrnbohaiyakkandisp2;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNBOHAIYAKKANDISP2)
    public String getZrnbohaiyakkandisp2() {
        return zrnbohaiyakkandisp2;
    }

    public void setZrnbohaiyakkandisp2(String pZrnbohaiyakkandisp2) {
        zrnbohaiyakkandisp2 = pZrnbohaiyakkandisp2;
    }

    private String zrnmeihenymd2;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNMEIHENYMD2)
    public String getZrnmeihenymd2() {
        return zrnmeihenymd2;
    }

    public void setZrnmeihenymd2(String pZrnmeihenymd2) {
        zrnmeihenymd2 = pZrnmeihenymd2;
    }

    private String zrnnksyoumetucd;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNNKSYOUMETUCD)
    public String getZrnnksyoumetucd() {
        return zrnnksyoumetucd;
    }

    public void setZrnnksyoumetucd(String pZrnnksyoumetucd) {
        zrnnksyoumetucd = pZrnnksyoumetucd;
    }

    private String zrnyobiv7;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNYOBIV7)
    public String getZrnyobiv7() {
        return zrnyobiv7;
    }

    public void setZrnyobiv7(String pZrnyobiv7) {
        zrnyobiv7 = pZrnyobiv7;
    }

    private String zrnyobiv20;

    @Column(name=GenZT_HnsyScrMeigiRn.ZRNYOBIV20)
    public String getZrnyobiv20() {
        return zrnyobiv20;
    }

    public void setZrnyobiv20(String pZrnyobiv20) {
        zrnyobiv20 = pZrnyobiv20;
    }
}