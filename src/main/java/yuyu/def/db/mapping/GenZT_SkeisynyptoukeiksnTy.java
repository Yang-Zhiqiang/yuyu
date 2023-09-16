package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_SkeisynyptoukeiksnTy;
import yuyu.def.db.id.PKZT_SkeisynyptoukeiksnTy;
import yuyu.def.db.meta.GenQZT_SkeisynyptoukeiksnTy;
import yuyu.def.db.meta.QZT_SkeisynyptoukeiksnTy;

/**
 * 新契約収入Ｐ統計決算Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_SkeisynyptoukeiksnTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SkeisynyptoukeiksnTy}</td><td colspan="3">新契約収入Ｐ統計決算Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKZT_SkeisynyptoukeiksnTy ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyuukourecordlength ztyyuukourecordlength}</td><td>（中継用）有効レコード長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyrdwarea ztyrdwarea}</td><td>（中継用）ＲＤＷ領域</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydatakanrino ztydatakanrino}</td><td>（中継用）データ管理番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoricd ztysyoricd}</td><td>（中継用）処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrendoukbn ztyrendoukbn}</td><td>（中継用）連動区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv1 ztyyobiv1}</td><td>（中継用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuunoukeirokbn ztysyuunoukeirokbn}</td><td>（中継用）収納経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuitousisya ztysuitousisya}</td><td>（中継用）出納支社</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuukinym ztysyuukinym}</td><td>（中継用）集金年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyuutouym ztyjyuutouym}</td><td>（中継用）充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyuutoukaisuu ztyjyuutoukaisuu}</td><td>（中継用）充当回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennoukbn ztyzennoukbn}</td><td>（中継用）前納区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetkykkbn ztysetkykkbn}</td><td>（中継用）セット契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybankikkatuhyouji ztybankikkatuhyouji}</td><td>（中継用）バンク一括表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrecordkbn ztyrecordkbn}</td><td>（中継用）レコード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytnknmnosjtikbbnjyutukbn ztytnknmnosjtikbbnjyutukbn}</td><td>（中継用）転換見直時定期部分充当区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetrenseimrtikatakbn ztysetrenseimrtikatakbn}</td><td>（中継用）セット連生マル定型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhaitoukbn ztyhaitoukbn}</td><td>（中継用）配当区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakupwaribikikbnx2 ztysyukeiyakupwaribikikbnx2}</td><td>（中継用）主契約Ｐ割引区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykyktnknyugukbnx2 ztysykyktnknyugukbnx2}</td><td>（中継用）主契約転換優遇区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetkaigomaruteikatakbn ztysetkaigomaruteikatakbn}</td><td>（中継用）セット介護マル定型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydenymd ztydenymd}</td><td>（中継用）伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyonendosyokaip ztysyonendosyokaip}</td><td>（中継用）初年度初回Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyonendo2kaimeikoup ztysyonendo2kaimeikoup}</td><td>（中継用）初年度２回目以降Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjinendoikoup ztyjinendoikoup}</td><td>（中継用）次年度以降Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaimnkkykhyj ztysaimnkkykhyj}</td><td>（中継用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknkkn ztyhknkkn}</td><td>（中継用）保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkkikn ztyphrkkikn}</td><td>（中継用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhihokensyaagev2 ztyhihokensyaagev2}</td><td>（中継用）被保険者年令Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyanen ztykyksyanen}</td><td>（中継用）契約者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaifuyouriyuukbn ztyannaifuyouriyuukbn}</td><td>（中継用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysdpdkbn ztysdpdkbn}</td><td>（中継用）Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyryouritukbn ztyryouritukbn}</td><td>（中継用）料率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksyuannaikykkbn ztytksyuannaikykkbn}</td><td>（中継用）特殊案内契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hhknnen ztydai2hhknnen}</td><td>（中継用）第２被保険者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyuruikigousedaikbn ztyhknsyuruikigousedaikbn}</td><td>（中継用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmenhukakbn ztypmenhukakbn}</td><td>（中継用）Ｐ免付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhosyouikkatumnoshyouji ztyhosyouikkatumnoshyouji}</td><td>（中継用）保障一括見直表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv1x2 ztyyobiv1x2}</td><td>（中継用）予備項目Ｖ１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihons ztykihons}</td><td>（中継用）基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygoukeitenkans ztygoukeitenkans}</td><td>（中継用）合計転換Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhngknksaiteihosyukngk ztyhngknksaiteihosyukngk}</td><td>（中継用）変額年金最低保証金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyaatukaisosikicd ztyaatukaisosikicd}</td><td>（中継用）Ａ扱者組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatukaikojincd ztyaatukaikojincd}</td><td>（中継用）Ａ扱者個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyym ztybsyym}</td><td>（中継用）募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyharaikomip ztyharaikomip}</td><td>（中継用）払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakup ztysyukeiyakup}</td><td>（中継用）主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytokujyoup ztytokujyoup}</td><td>（中継用）特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyitibuitijibarais ztyitibuitijibarais}</td><td>（中継用）一部一時払Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyitibuitijibaraip ztyitibuitijibaraip}</td><td>（中継用）一部一時払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygoukeitenkanteikis ztygoukeitenkanteikis}</td><td>（中継用）合計転換定期Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyuunoukbn ztysyuunoukbn}</td><td>（中継用）収納区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkykkumkhnsyukosuu ztytkykkumkhnsyukosuu}</td><td>（中継用）特約項目編集個数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysiteizukipwarimasihyouji ztysiteizukipwarimasihyouji}</td><td>（中継用）指定月Ｐ割増表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypwarimasisiteim1 ztypwarimasisiteim1}</td><td>（中継用）Ｐ割増指定月１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypwarimasisiteim2 ztypwarimasisiteim2}</td><td>（中継用）Ｐ割増指定月２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiteimsykykpbairitu ztysiteimsykykpbairitu}</td><td>（中継用）指定月主契約Ｐ倍率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiteizukisyukeiyakup ztysiteizukisyukeiyakup}</td><td>（中継用）指定月主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysiteizukiharaikomip ztysiteizukiharaikomip}</td><td>（中継用）指定月払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysaisyuusiteimhrkp ztysaisyuusiteimhrkp}</td><td>（中継用）最終指定月払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysaisyuusiteiym ztysaisyuusiteiym}</td><td>（中継用）最終指定年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyanniskcd ztyanniskcd}</td><td>（中継用）案内先コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytumitateriritu ztytumitateriritu}</td><td>（中継用）積立利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysitihsyuriritu ztysitihsyuriritu}</td><td>（中継用）最低保証利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtynkgnsritu ztynkgnsritu}</td><td>（中継用）年金原資率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysinnyuukinkbn ztysinnyuukinkbn}</td><td>（中継用）新入金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydfnyuukinkbn ztydfnyuukinkbn}</td><td>（中継用）ＤＦ入金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytorikuzusip ztytorikuzusip}</td><td>（中継用）取崩Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyousegmentcd ztykbnkeiriyousegmentcd}</td><td>（中継用）区分経理用セグメントコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykikykjkykym ztysykikykjkykym}</td><td>（中継用）初回契約時契約年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydfkijyunkingaku ztydfkijyunkingaku}</td><td>（中継用）ＤＦ基準金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtystdssytikbn ztystdssytikbn}</td><td>（中継用）外出集定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysotodasimanagehyouji ztysotodasimanagehyouji}</td><td>（中継用）外出満年令表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysotodasiphkbnmnoshyouji ztysotodasiphkbnmnoshyouji}</td><td>（中継用）外出Ｐ不可分見直表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystdsstkjytkyuhyj ztystdsstkjytkyuhyj}</td><td>（中継用）外出新特条適用表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykousinmanryouage ztykousinmanryouage}</td><td>（中継用）更新満了年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknkuzusnzyrttekitkarihyj ztyknkuzusnzyrttekitkarihyj}</td><td>（中継用）健康増進乗率適用特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknkuzusnzyrt ztyknkuzusnzyrt}</td><td>（中継用）健康増進乗率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkanjiknkuzusnzyrt ztytenkanjiknkuzusnzyrt}</td><td>（中継用）転換時健康増進乗率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypwrbksidhitekiyouhyj ztypwrbksidhitekiyouhyj}</td><td>（中継用）保険料割引制度非適用表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin1x2 ztysuuriyouyobin1x2}</td><td>（中継用）数理用予備項目Ｎ１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzyrthntiyustatuskbn ztyzyrthntiyustatuskbn}</td><td>（中継用）乗率判定用ステータス区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv9 ztyyobiv9}</td><td>（中継用）予備項目Ｖ９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysotodasipmenkbn ztysotodasipmenkbn}</td><td>（中継用）外出Ｐ免区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokubetuhosyoukikan ztytokubetuhosyoukikan}</td><td>（中継用）特別保障期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin7 ztysuuriyouyobin7}</td><td>（中継用）数理用予備項目Ｎ７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphireilkeisanyoup ztyphireilkeisanyoup}</td><td>（中継用）Ｐ比例Ｌ計算用Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11 ztyyobin11}</td><td>（中継用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x2 ztyyobin11x2}</td><td>（中継用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x3 ztyyobin11x3}</td><td>（中継用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x4 ztyyobin11x4}</td><td>（中継用）予備項目Ｎ１１＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtycashlesshyj ztycashlesshyj}</td><td>（中継用）キャッシュレス表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykjiqpackhyj ztykykjiqpackhyj}</td><td>（中継用）契約時Ｑパック表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkanminaosikbn ztytenkanminaosikbn}</td><td>（中継用）転換見直区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnentysihyj ztyhhknnentysihyj}</td><td>（中継用）被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hhknnentysihyj ztydai2hhknnentysihyj}</td><td>（中継用）第２被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyaagetyouseihyj ztykyksyaagetyouseihyj}</td><td>（中継用）契約者年令調整表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykykhokenhoutekiyouhyj ztysykykhokenhoutekiyouhyj}</td><td>（中継用）主契約保険法適用表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrimngtkykphrkkaisuukbn ztyhrimngtkykphrkkaisuukbn}</td><td>（中継用）払満後特約Ｐ払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjidoukousinhyouji ztyjidoukousinhyouji}</td><td>（中継用）自動更新表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin1 ztysuuriyouyobin1}</td><td>（中継用）数理用予備項目Ｎ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkjykbn ztytkjykbn}</td><td>（中継用）特条区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2tokujyoukbn ztydai2tokujyoukbn}</td><td>（中継用）第２特条区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyryoumasihyouten ztyryoumasihyouten}</td><td>（中継用）料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtydai2ryoumasihyouten ztydai2ryoumasihyouten}</td><td>（中継用）第２料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin2 ztysuuriyouyobin2}</td><td>（中継用）数理用予備項目Ｎ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin10 ztysuuriyouyobin10}</td><td>（中継用）数理用予備項目Ｎ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin10x2 ztysuuriyouyobin10x2}</td><td>（中継用）数理用予備項目Ｎ１０＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin10x3 ztysuuriyouyobin10x3}</td><td>（中継用）数理用予備項目Ｎ１０＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin10x4 ztysuuriyouyobin10x4}</td><td>（中継用）数理用予備項目Ｎ１０＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10x6 ztyyobiv10x6}</td><td>（中継用）予備項目Ｖ１０＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10x7 ztyyobiv10x7}</td><td>（中継用）予備項目Ｖ１０＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10x8 ztyyobiv10x8}</td><td>（中継用）予備項目Ｖ１０＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10x9 ztyyobiv10x9}</td><td>（中継用）予備項目Ｖ１０＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10x10 ztyyobiv10x10}</td><td>（中継用）予備項目Ｖ１０＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10x11 ztyyobiv10x11}</td><td>（中継用）予備項目Ｖ１０＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuukeitaikbn ztybosyuukeitaikbn}</td><td>（中継用）募集形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrimngtkykphrkkirkbn ztyhrimngtkykphrkkirkbn}</td><td>（中継用）払満後特約Ｐ払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrimngtkykpryurtkbn ztyhrimngtkykpryurtkbn}</td><td>（中継用）払満後特約Ｐ料率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakusyuruicdv3 ztysyukeiyakusyuruicdv3}</td><td>（中継用）主契約種類コードＶ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobin11x5 ztyyobin11x5}</td><td>（中継用）予備項目Ｎ１１＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x6 ztyyobin11x6}</td><td>（中継用）予備項目Ｎ１１＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x7 ztyyobin11x7}</td><td>（中継用）予備項目Ｎ１１＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x8 ztyyobin11x8}</td><td>（中継用）予備項目Ｎ１１＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x9 ztyyobin11x9}</td><td>（中継用）予備項目Ｎ１１＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyraysystemhyj ztyraysystemhyj}</td><td>（中継用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygaikakbn ztygaikakbn}</td><td>（中継用）外貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykjikawaserate ztykykjikawaserate}</td><td>（中継用）契約時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykykjikawaseratetkyuymd ztykykjikawaseratetkyuymd}</td><td>（中継用）契約時為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakujiyoteiriritu ztykeiyakujiyoteiriritu}</td><td>（中継用）契約時予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyenkdtsbujsitihsyukngk ztyenkdtsbujsitihsyukngk}</td><td>（中継用）円貨建死亡時最低保証金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynyuukintuukakbn ztynyuukintuukakbn}</td><td>（中継用）入金通貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuurendourate ztysisuurendourate}</td><td>（中継用）指数連動部分割合</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuukbn ztysisuukbn}</td><td>（中継用）指数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyknjikawaserate ztynyknjikawaserate}</td><td>（中継用）入金時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtynyknjikawaseratetkyuymd ztynyknjikawaseratetkyuymd}</td><td>（中継用）入金時為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysrdai1hknkkn ztysrdai1hknkkn}</td><td>（中継用）数理用第１保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin10x5 ztysuuriyouyobin10x5}</td><td>（中継用）数理用予備項目Ｎ１０＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuukasyukbn ztytuukasyukbn}</td><td>（中継用）通貨種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv9x2 ztyyobiv9x2}</td><td>（中継用）予備項目Ｖ９＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10x16 ztyyobiv10x16}</td><td>（中継用）予備項目Ｖ１０＿１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkgns ztynkgns}</td><td>（中継用）年金原資</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysisuubbntounyuugk ztysisuubbntounyuugk}</td><td>（中継用）指数部分投入金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysaisinyoteiriritu ztysaisinyoteiriritu}</td><td>（中継用）最新予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyobin5 ztyyobin5}</td><td>（中継用）予備項目Ｎ５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyobin11x10 ztyyobin11x10}</td><td>（中継用）予備項目Ｎ１１＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykiharaikomip ztykiharaikomip}</td><td>（中継用）既払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytumitatekin ztytumitatekin}</td><td>（中継用）積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzennoujiikkatubaraijytgk ztyzennoujiikkatubaraijytgk}</td><td>（中継用）前納時一括払充当額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatenkgns ztygaikadatenkgns}</td><td>（中継用）外貨建年金原資</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatesyukeiyakup ztygaikadatesyukeiyakup}</td><td>（中継用）外貨建主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv1x3 ztyyobiv1x3}</td><td>（中継用）予備項目Ｖ１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160 ztytokuyakukoumokuv160}</td><td>（中継用）特約項目Ｖ１６０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x2 ztytokuyakukoumokuv160x2}</td><td>（中継用）特約項目Ｖ１６０＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x3 ztytokuyakukoumokuv160x3}</td><td>（中継用）特約項目Ｖ１６０＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x4 ztytokuyakukoumokuv160x4}</td><td>（中継用）特約項目Ｖ１６０＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x5 ztytokuyakukoumokuv160x5}</td><td>（中継用）特約項目Ｖ１６０＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x6 ztytokuyakukoumokuv160x6}</td><td>（中継用）特約項目Ｖ１６０＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x7 ztytokuyakukoumokuv160x7}</td><td>（中継用）特約項目Ｖ１６０＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x8 ztytokuyakukoumokuv160x8}</td><td>（中継用）特約項目Ｖ１６０＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x9 ztytokuyakukoumokuv160x9}</td><td>（中継用）特約項目Ｖ１６０＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x10 ztytokuyakukoumokuv160x10}</td><td>（中継用）特約項目Ｖ１６０＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x11 ztytokuyakukoumokuv160x11}</td><td>（中継用）特約項目Ｖ１６０＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x12 ztytokuyakukoumokuv160x12}</td><td>（中継用）特約項目Ｖ１６０＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x13 ztytokuyakukoumokuv160x13}</td><td>（中継用）特約項目Ｖ１６０＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x14 ztytokuyakukoumokuv160x14}</td><td>（中継用）特約項目Ｖ１６０＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x15 ztytokuyakukoumokuv160x15}</td><td>（中継用）特約項目Ｖ１６０＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x16 ztytokuyakukoumokuv160x16}</td><td>（中継用）特約項目Ｖ１６０＿１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x17 ztytokuyakukoumokuv160x17}</td><td>（中継用）特約項目Ｖ１６０＿１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x18 ztytokuyakukoumokuv160x18}</td><td>（中継用）特約項目Ｖ１６０＿１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x19 ztytokuyakukoumokuv160x19}</td><td>（中継用）特約項目Ｖ１６０＿１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x20 ztytokuyakukoumokuv160x20}</td><td>（中継用）特約項目Ｖ１６０＿２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x21 ztytokuyakukoumokuv160x21}</td><td>（中継用）特約項目Ｖ１６０＿２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x22 ztytokuyakukoumokuv160x22}</td><td>（中継用）特約項目Ｖ１６０＿２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x23 ztytokuyakukoumokuv160x23}</td><td>（中継用）特約項目Ｖ１６０＿２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x24 ztytokuyakukoumokuv160x24}</td><td>（中継用）特約項目Ｖ１６０＿２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x25 ztytokuyakukoumokuv160x25}</td><td>（中継用）特約項目Ｖ１６０＿２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x26 ztytokuyakukoumokuv160x26}</td><td>（中継用）特約項目Ｖ１６０＿２６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x27 ztytokuyakukoumokuv160x27}</td><td>（中継用）特約項目Ｖ１６０＿２７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x28 ztytokuyakukoumokuv160x28}</td><td>（中継用）特約項目Ｖ１６０＿２８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x29 ztytokuyakukoumokuv160x29}</td><td>（中継用）特約項目Ｖ１６０＿２９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x30 ztytokuyakukoumokuv160x30}</td><td>（中継用）特約項目Ｖ１６０＿３０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x31 ztytokuyakukoumokuv160x31}</td><td>（中継用）特約項目Ｖ１６０＿３１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x32 ztytokuyakukoumokuv160x32}</td><td>（中継用）特約項目Ｖ１６０＿３２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x33 ztytokuyakukoumokuv160x33}</td><td>（中継用）特約項目Ｖ１６０＿３３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x34 ztytokuyakukoumokuv160x34}</td><td>（中継用）特約項目Ｖ１６０＿３４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x35 ztytokuyakukoumokuv160x35}</td><td>（中継用）特約項目Ｖ１６０＿３５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x36 ztytokuyakukoumokuv160x36}</td><td>（中継用）特約項目Ｖ１６０＿３６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x37 ztytokuyakukoumokuv160x37}</td><td>（中継用）特約項目Ｖ１６０＿３７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x38 ztytokuyakukoumokuv160x38}</td><td>（中継用）特約項目Ｖ１６０＿３８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x39 ztytokuyakukoumokuv160x39}</td><td>（中継用）特約項目Ｖ１６０＿３９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x40 ztytokuyakukoumokuv160x40}</td><td>（中継用）特約項目Ｖ１６０＿４０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x41 ztytokuyakukoumokuv160x41}</td><td>（中継用）特約項目Ｖ１６０＿４１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x42 ztytokuyakukoumokuv160x42}</td><td>（中継用）特約項目Ｖ１６０＿４２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x43 ztytokuyakukoumokuv160x43}</td><td>（中継用）特約項目Ｖ１６０＿４３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x44 ztytokuyakukoumokuv160x44}</td><td>（中継用）特約項目Ｖ１６０＿４４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x45 ztytokuyakukoumokuv160x45}</td><td>（中継用）特約項目Ｖ１６０＿４５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x46 ztytokuyakukoumokuv160x46}</td><td>（中継用）特約項目Ｖ１６０＿４６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x47 ztytokuyakukoumokuv160x47}</td><td>（中継用）特約項目Ｖ１６０＿４７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x48 ztytokuyakukoumokuv160x48}</td><td>（中継用）特約項目Ｖ１６０＿４８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x49 ztytokuyakukoumokuv160x49}</td><td>（中継用）特約項目Ｖ１６０＿４９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv160x50 ztytokuyakukoumokuv160x50}</td><td>（中継用）特約項目Ｖ１６０＿５０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SkeisynyptoukeiksnTy
 * @see     PKZT_SkeisynyptoukeiksnTy
 * @see     QZT_SkeisynyptoukeiksnTy
 * @see     GenQZT_SkeisynyptoukeiksnTy
 */
@MappedSuperclass
@Table(name=GenZT_SkeisynyptoukeiksnTy.TABLE_NAME)
@IdClass(value=PKZT_SkeisynyptoukeiksnTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_SkeisynyptoukeiksnTy extends AbstractExDBEntity<ZT_SkeisynyptoukeiksnTy, PKZT_SkeisynyptoukeiksnTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SkeisynyptoukeiksnTy";
    public static final String ZTYSEQUENCENO            = "ztysequenceno";
    public static final String ZTYYUUKOURECORDLENGTH    = "ztyyuukourecordlength";
    public static final String ZTYRDWAREA               = "ztyrdwarea";
    public static final String ZTYDATAKANRINO           = "ztydatakanrino";
    public static final String ZTYSYORICD               = "ztysyoricd";
    public static final String ZTYRENDOUKBN             = "ztyrendoukbn";
    public static final String ZTYYOBIV1                = "ztyyobiv1";
    public static final String ZTYSYUUNOUKEIROKBN       = "ztysyuunoukeirokbn";
    public static final String ZTYSUITOUSISYA           = "ztysuitousisya";
    public static final String ZTYSYUUKINYM             = "ztysyuukinym";
    public static final String ZTYJYUUTOUYM             = "ztyjyuutouym";
    public static final String ZTYJYUUTOUKAISUU         = "ztyjyuutoukaisuu";
    public static final String ZTYZENNOUKBN             = "ztyzennoukbn";
    public static final String ZTYSETKYKKBN             = "ztysetkykkbn";
    public static final String ZTYBANKIKKATUHYOUJI      = "ztybankikkatuhyouji";
    public static final String ZTYRECORDKBN             = "ztyrecordkbn";
    public static final String ZTYTNKNMNOSJTIKBBNJYUTUKBN = "ztytnknmnosjtikbbnjyutukbn";
    public static final String ZTYSETRENSEIMRTIKATAKBN  = "ztysetrenseimrtikatakbn";
    public static final String ZTYHAITOUKBN             = "ztyhaitoukbn";
    public static final String ZTYSYUKEIYAKUPWARIBIKIKBNX2 = "ztysyukeiyakupwaribikikbnx2";
    public static final String ZTYSYKYKTNKNYUGUKBNX2    = "ztysykyktnknyugukbnx2";
    public static final String ZTYSETKAIGOMARUTEIKATAKBN = "ztysetkaigomaruteikatakbn";
    public static final String ZTYDENYMD                = "ztydenymd";
    public static final String ZTYSYONENDOSYOKAIP       = "ztysyonendosyokaip";
    public static final String ZTYSYONENDO2KAIMEIKOUP   = "ztysyonendo2kaimeikoup";
    public static final String ZTYJINENDOIKOUP          = "ztyjinendoikoup";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYSAIMNKKYKHYJ          = "ztysaimnkkykhyj";
    public static final String ZTYHKNKKN                = "ztyhknkkn";
    public static final String ZTYPHRKKIKN              = "ztyphrkkikn";
    public static final String ZTYHIHOKENSYAAGEV2       = "ztyhihokensyaagev2";
    public static final String ZTYKYKSYANEN             = "ztykyksyanen";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYANNAIFUYOURIYUUKBN    = "ztyannaifuyouriyuukbn";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYSDPDKBN               = "ztysdpdkbn";
    public static final String ZTYRYOURITUKBN           = "ztyryouritukbn";
    public static final String ZTYTKSYUANNAIKYKKBN      = "ztytksyuannaikykkbn";
    public static final String ZTYDAI2HHKNNEN           = "ztydai2hhknnen";
    public static final String ZTYHKNSYURUIKIGOUSEDAIKBN = "ztyhknsyuruikigousedaikbn";
    public static final String ZTYPMENHUKAKBN           = "ztypmenhukakbn";
    public static final String ZTYHOSYOUIKKATUMNOSHYOUJI = "ztyhosyouikkatumnoshyouji";
    public static final String ZTYYOBIV1X2              = "ztyyobiv1x2";
    public static final String ZTYKIHONS                = "ztykihons";
    public static final String ZTYGOUKEITENKANS         = "ztygoukeitenkans";
    public static final String ZTYHNGKNKSAITEIHOSYUKNGK = "ztyhngknksaiteihosyukngk";
    public static final String ZTYAATUKAISOSIKICD       = "ztyaatukaisosikicd";
    public static final String ZTYAATUKAIKOJINCD        = "ztyaatukaikojincd";
    public static final String ZTYBSYYM                 = "ztybsyym";
    public static final String ZTYHARAIKOMIP            = "ztyharaikomip";
    public static final String ZTYSYUKEIYAKUP           = "ztysyukeiyakup";
    public static final String ZTYTOKUJYOUP             = "ztytokujyoup";
    public static final String ZTYITIBUITIJIBARAIS      = "ztyitibuitijibarais";
    public static final String ZTYITIBUITIJIBARAIP      = "ztyitibuitijibaraip";
    public static final String ZTYGOUKEITENKANTEIKIS    = "ztygoukeitenkanteikis";
    public static final String ZTYSYUUNOUKBN            = "ztysyuunoukbn";
    public static final String ZTYTKYKKUMKHNSYUKOSUU    = "ztytkykkumkhnsyukosuu";
    public static final String ZTYSITEIZUKIPWARIMASIHYOUJI = "ztysiteizukipwarimasihyouji";
    public static final String ZTYPWARIMASISITEIM1      = "ztypwarimasisiteim1";
    public static final String ZTYPWARIMASISITEIM2      = "ztypwarimasisiteim2";
    public static final String ZTYSITEIMSYKYKPBAIRITU   = "ztysiteimsykykpbairitu";
    public static final String ZTYSITEIZUKISYUKEIYAKUP  = "ztysiteizukisyukeiyakup";
    public static final String ZTYSITEIZUKIHARAIKOMIP   = "ztysiteizukiharaikomip";
    public static final String ZTYSAISYUUSITEIMHRKP     = "ztysaisyuusiteimhrkp";
    public static final String ZTYSAISYUUSITEIYM        = "ztysaisyuusiteiym";
    public static final String ZTYANNISKCD              = "ztyanniskcd";
    public static final String ZTYTUMITATERIRITU        = "ztytumitateriritu";
    public static final String ZTYSITIHSYURIRITU        = "ztysitihsyuriritu";
    public static final String ZTYNKGNSRITU             = "ztynkgnsritu";
    public static final String ZTYSINNYUUKINKBN         = "ztysinnyuukinkbn";
    public static final String ZTYDFNYUUKINKBN          = "ztydfnyuukinkbn";
    public static final String ZTYTORIKUZUSIP           = "ztytorikuzusip";
    public static final String ZTYKBNKEIRIYOUSEGMENTCD  = "ztykbnkeiriyousegmentcd";
    public static final String ZTYSYKIKYKJKYKYM         = "ztysykikykjkykym";
    public static final String ZTYDFKIJYUNKINGAKU       = "ztydfkijyunkingaku";
    public static final String ZTYSTDSSYTIKBN           = "ztystdssytikbn";
    public static final String ZTYSOTODASIMANAGEHYOUJI  = "ztysotodasimanagehyouji";
    public static final String ZTYSOTODASIPHKBNMNOSHYOUJI = "ztysotodasiphkbnmnoshyouji";
    public static final String ZTYSTDSSTKJYTKYUHYJ      = "ztystdsstkjytkyuhyj";
    public static final String ZTYKOUSINMANRYOUAGE      = "ztykousinmanryouage";
    public static final String ZTYKNKUZUSNZYRTTEKITKARIHYJ = "ztyknkuzusnzyrttekitkarihyj";
    public static final String ZTYKNKUZUSNZYRT          = "ztyknkuzusnzyrt";
    public static final String ZTYTENKANJIKNKUZUSNZYRT  = "ztytenkanjiknkuzusnzyrt";
    public static final String ZTYPWRBKSIDHITEKIYOUHYJ  = "ztypwrbksidhitekiyouhyj";
    public static final String ZTYSUURIYOUYOBIN1X2      = "ztysuuriyouyobin1x2";
    public static final String ZTYZYRTHNTIYUSTATUSKBN   = "ztyzyrthntiyustatuskbn";
    public static final String ZTYYOBIV9                = "ztyyobiv9";
    public static final String ZTYSOTODASIPMENKBN       = "ztysotodasipmenkbn";
    public static final String ZTYTOKUBETUHOSYOUKIKAN   = "ztytokubetuhosyoukikan";
    public static final String ZTYSUURIYOUYOBIN7        = "ztysuuriyouyobin7";
    public static final String ZTYPHIREILKEISANYOUP     = "ztyphireilkeisanyoup";
    public static final String ZTYYOBIN11               = "ztyyobin11";
    public static final String ZTYYOBIN11X2             = "ztyyobin11x2";
    public static final String ZTYYOBIN11X3             = "ztyyobin11x3";
    public static final String ZTYYOBIN11X4             = "ztyyobin11x4";
    public static final String ZTYCASHLESSHYJ           = "ztycashlesshyj";
    public static final String ZTYKYKJIQPACKHYJ         = "ztykykjiqpackhyj";
    public static final String ZTYTENKANMINAOSIKBN      = "ztytenkanminaosikbn";
    public static final String ZTYHHKNNENTYSIHYJ        = "ztyhhknnentysihyj";
    public static final String ZTYDAI2HHKNNENTYSIHYJ    = "ztydai2hhknnentysihyj";
    public static final String ZTYKYKSYAAGETYOUSEIHYJ   = "ztykyksyaagetyouseihyj";
    public static final String ZTYSYKYKHOKENHOUTEKIYOUHYJ = "ztysykykhokenhoutekiyouhyj";
    public static final String ZTYHRIMNGTKYKPHRKKAISUUKBN = "ztyhrimngtkykphrkkaisuukbn";
    public static final String ZTYJIDOUKOUSINHYOUJI     = "ztyjidoukousinhyouji";
    public static final String ZTYSUURIYOUYOBIN1        = "ztysuuriyouyobin1";
    public static final String ZTYTKJYKBN               = "ztytkjykbn";
    public static final String ZTYDAI2TOKUJYOUKBN       = "ztydai2tokujyoukbn";
    public static final String ZTYRYOUMASIHYOUTEN       = "ztyryoumasihyouten";
    public static final String ZTYDAI2RYOUMASIHYOUTEN   = "ztydai2ryoumasihyouten";
    public static final String ZTYSUURIYOUYOBIN2        = "ztysuuriyouyobin2";
    public static final String ZTYSUURIYOUYOBIN10       = "ztysuuriyouyobin10";
    public static final String ZTYSUURIYOUYOBIN10X2     = "ztysuuriyouyobin10x2";
    public static final String ZTYSUURIYOUYOBIN10X3     = "ztysuuriyouyobin10x3";
    public static final String ZTYSUURIYOUYOBIN10X4     = "ztysuuriyouyobin10x4";
    public static final String ZTYYOBIV10X6             = "ztyyobiv10x6";
    public static final String ZTYYOBIV10X7             = "ztyyobiv10x7";
    public static final String ZTYYOBIV10X8             = "ztyyobiv10x8";
    public static final String ZTYYOBIV10X9             = "ztyyobiv10x9";
    public static final String ZTYYOBIV10X10            = "ztyyobiv10x10";
    public static final String ZTYYOBIV10X11            = "ztyyobiv10x11";
    public static final String ZTYBOSYUUKEITAIKBN       = "ztybosyuukeitaikbn";
    public static final String ZTYHRIMNGTKYKPHRKKIRKBN  = "ztyhrimngtkykphrkkirkbn";
    public static final String ZTYHRIMNGTKYKPRYURTKBN   = "ztyhrimngtkykpryurtkbn";
    public static final String ZTYSYUKEIYAKUSYURUICDV3  = "ztysyukeiyakusyuruicdv3";
    public static final String ZTYYOBIN11X5             = "ztyyobin11x5";
    public static final String ZTYYOBIN11X6             = "ztyyobin11x6";
    public static final String ZTYYOBIN11X7             = "ztyyobin11x7";
    public static final String ZTYYOBIN11X8             = "ztyyobin11x8";
    public static final String ZTYYOBIN11X9             = "ztyyobin11x9";
    public static final String ZTYRAYSYSTEMHYJ          = "ztyraysystemhyj";
    public static final String ZTYGAIKAKBN              = "ztygaikakbn";
    public static final String ZTYKYKJIKAWASERATE       = "ztykykjikawaserate";
    public static final String ZTYKYKJIKAWASERATETKYUYMD = "ztykykjikawaseratetkyuymd";
    public static final String ZTYKEIYAKUJIYOTEIRIRITU  = "ztykeiyakujiyoteiriritu";
    public static final String ZTYENKDTSBUJSITIHSYUKNGK = "ztyenkdtsbujsitihsyukngk";
    public static final String ZTYNYUUKINTUUKAKBN       = "ztynyuukintuukakbn";
    public static final String ZTYSISUURENDOURATE       = "ztysisuurendourate";
    public static final String ZTYSISUUKBN              = "ztysisuukbn";
    public static final String ZTYNYKNJIKAWASERATE      = "ztynyknjikawaserate";
    public static final String ZTYNYKNJIKAWASERATETKYUYMD = "ztynyknjikawaseratetkyuymd";
    public static final String ZTYSRDAI1HKNKKN          = "ztysrdai1hknkkn";
    public static final String ZTYSUURIYOUYOBIN10X5     = "ztysuuriyouyobin10x5";
    public static final String ZTYTUUKASYUKBN           = "ztytuukasyukbn";
    public static final String ZTYYOBIV9X2              = "ztyyobiv9x2";
    public static final String ZTYYOBIV10X16            = "ztyyobiv10x16";
    public static final String ZTYNKGNS                 = "ztynkgns";
    public static final String ZTYSISUUBBNTOUNYUUGK     = "ztysisuubbntounyuugk";
    public static final String ZTYSAISINYOTEIRIRITU     = "ztysaisinyoteiriritu";
    public static final String ZTYYOBIN5                = "ztyyobin5";
    public static final String ZTYYOBIN11X10            = "ztyyobin11x10";
    public static final String ZTYKIHARAIKOMIP          = "ztykiharaikomip";
    public static final String ZTYTUMITATEKIN           = "ztytumitatekin";
    public static final String ZTYZENNOUJIIKKATUBARAIJYTGK = "ztyzennoujiikkatubaraijytgk";
    public static final String ZTYGAIKADATENKGNS        = "ztygaikadatenkgns";
    public static final String ZTYGAIKADATESYUKEIYAKUP  = "ztygaikadatesyukeiyakup";
    public static final String ZTYYOBIV1X3              = "ztyyobiv1x3";
    public static final String ZTYTOKUYAKUKOUMOKUV160   = "ztytokuyakukoumokuv160";
    public static final String ZTYTOKUYAKUKOUMOKUV160X2 = "ztytokuyakukoumokuv160x2";
    public static final String ZTYTOKUYAKUKOUMOKUV160X3 = "ztytokuyakukoumokuv160x3";
    public static final String ZTYTOKUYAKUKOUMOKUV160X4 = "ztytokuyakukoumokuv160x4";
    public static final String ZTYTOKUYAKUKOUMOKUV160X5 = "ztytokuyakukoumokuv160x5";
    public static final String ZTYTOKUYAKUKOUMOKUV160X6 = "ztytokuyakukoumokuv160x6";
    public static final String ZTYTOKUYAKUKOUMOKUV160X7 = "ztytokuyakukoumokuv160x7";
    public static final String ZTYTOKUYAKUKOUMOKUV160X8 = "ztytokuyakukoumokuv160x8";
    public static final String ZTYTOKUYAKUKOUMOKUV160X9 = "ztytokuyakukoumokuv160x9";
    public static final String ZTYTOKUYAKUKOUMOKUV160X10 = "ztytokuyakukoumokuv160x10";
    public static final String ZTYTOKUYAKUKOUMOKUV160X11 = "ztytokuyakukoumokuv160x11";
    public static final String ZTYTOKUYAKUKOUMOKUV160X12 = "ztytokuyakukoumokuv160x12";
    public static final String ZTYTOKUYAKUKOUMOKUV160X13 = "ztytokuyakukoumokuv160x13";
    public static final String ZTYTOKUYAKUKOUMOKUV160X14 = "ztytokuyakukoumokuv160x14";
    public static final String ZTYTOKUYAKUKOUMOKUV160X15 = "ztytokuyakukoumokuv160x15";
    public static final String ZTYTOKUYAKUKOUMOKUV160X16 = "ztytokuyakukoumokuv160x16";
    public static final String ZTYTOKUYAKUKOUMOKUV160X17 = "ztytokuyakukoumokuv160x17";
    public static final String ZTYTOKUYAKUKOUMOKUV160X18 = "ztytokuyakukoumokuv160x18";
    public static final String ZTYTOKUYAKUKOUMOKUV160X19 = "ztytokuyakukoumokuv160x19";
    public static final String ZTYTOKUYAKUKOUMOKUV160X20 = "ztytokuyakukoumokuv160x20";
    public static final String ZTYTOKUYAKUKOUMOKUV160X21 = "ztytokuyakukoumokuv160x21";
    public static final String ZTYTOKUYAKUKOUMOKUV160X22 = "ztytokuyakukoumokuv160x22";
    public static final String ZTYTOKUYAKUKOUMOKUV160X23 = "ztytokuyakukoumokuv160x23";
    public static final String ZTYTOKUYAKUKOUMOKUV160X24 = "ztytokuyakukoumokuv160x24";
    public static final String ZTYTOKUYAKUKOUMOKUV160X25 = "ztytokuyakukoumokuv160x25";
    public static final String ZTYTOKUYAKUKOUMOKUV160X26 = "ztytokuyakukoumokuv160x26";
    public static final String ZTYTOKUYAKUKOUMOKUV160X27 = "ztytokuyakukoumokuv160x27";
    public static final String ZTYTOKUYAKUKOUMOKUV160X28 = "ztytokuyakukoumokuv160x28";
    public static final String ZTYTOKUYAKUKOUMOKUV160X29 = "ztytokuyakukoumokuv160x29";
    public static final String ZTYTOKUYAKUKOUMOKUV160X30 = "ztytokuyakukoumokuv160x30";
    public static final String ZTYTOKUYAKUKOUMOKUV160X31 = "ztytokuyakukoumokuv160x31";
    public static final String ZTYTOKUYAKUKOUMOKUV160X32 = "ztytokuyakukoumokuv160x32";
    public static final String ZTYTOKUYAKUKOUMOKUV160X33 = "ztytokuyakukoumokuv160x33";
    public static final String ZTYTOKUYAKUKOUMOKUV160X34 = "ztytokuyakukoumokuv160x34";
    public static final String ZTYTOKUYAKUKOUMOKUV160X35 = "ztytokuyakukoumokuv160x35";
    public static final String ZTYTOKUYAKUKOUMOKUV160X36 = "ztytokuyakukoumokuv160x36";
    public static final String ZTYTOKUYAKUKOUMOKUV160X37 = "ztytokuyakukoumokuv160x37";
    public static final String ZTYTOKUYAKUKOUMOKUV160X38 = "ztytokuyakukoumokuv160x38";
    public static final String ZTYTOKUYAKUKOUMOKUV160X39 = "ztytokuyakukoumokuv160x39";
    public static final String ZTYTOKUYAKUKOUMOKUV160X40 = "ztytokuyakukoumokuv160x40";
    public static final String ZTYTOKUYAKUKOUMOKUV160X41 = "ztytokuyakukoumokuv160x41";
    public static final String ZTYTOKUYAKUKOUMOKUV160X42 = "ztytokuyakukoumokuv160x42";
    public static final String ZTYTOKUYAKUKOUMOKUV160X43 = "ztytokuyakukoumokuv160x43";
    public static final String ZTYTOKUYAKUKOUMOKUV160X44 = "ztytokuyakukoumokuv160x44";
    public static final String ZTYTOKUYAKUKOUMOKUV160X45 = "ztytokuyakukoumokuv160x45";
    public static final String ZTYTOKUYAKUKOUMOKUV160X46 = "ztytokuyakukoumokuv160x46";
    public static final String ZTYTOKUYAKUKOUMOKUV160X47 = "ztytokuyakukoumokuv160x47";
    public static final String ZTYTOKUYAKUKOUMOKUV160X48 = "ztytokuyakukoumokuv160x48";
    public static final String ZTYTOKUYAKUKOUMOKUV160X49 = "ztytokuyakukoumokuv160x49";
    public static final String ZTYTOKUYAKUKOUMOKUV160X50 = "ztytokuyakukoumokuv160x50";

    private final PKZT_SkeisynyptoukeiksnTy primaryKey;

    public GenZT_SkeisynyptoukeiksnTy() {
        primaryKey = new PKZT_SkeisynyptoukeiksnTy();
    }

    public GenZT_SkeisynyptoukeiksnTy(Integer pZtysequenceno) {
        primaryKey = new PKZT_SkeisynyptoukeiksnTy(pZtysequenceno);
    }

    @Transient
    @Override
    public PKZT_SkeisynyptoukeiksnTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SkeisynyptoukeiksnTy> getMetaClass() {
        return QZT_SkeisynyptoukeiksnTy.class;
    }

    @Id
    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private Integer ztyyuukourecordlength;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYYUUKOURECORDLENGTH)
    public Integer getZtyyuukourecordlength() {
        return ztyyuukourecordlength;
    }

    public void setZtyyuukourecordlength(Integer pZtyyuukourecordlength) {
        ztyyuukourecordlength = pZtyyuukourecordlength;
    }

    private String ztyrdwarea;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYRDWAREA)
    public String getZtyrdwarea() {
        return ztyrdwarea;
    }

    public void setZtyrdwarea(String pZtyrdwarea) {
        ztyrdwarea = pZtyrdwarea;
    }

    private String ztydatakanrino;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYDATAKANRINO)
    public String getZtydatakanrino() {
        return ztydatakanrino;
    }

    public void setZtydatakanrino(String pZtydatakanrino) {
        ztydatakanrino = pZtydatakanrino;
    }

    private String ztysyoricd;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSYORICD)
    public String getZtysyoricd() {
        return ztysyoricd;
    }

    public void setZtysyoricd(String pZtysyoricd) {
        ztysyoricd = pZtysyoricd;
    }

    private String ztyrendoukbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYRENDOUKBN)
    public String getZtyrendoukbn() {
        return ztyrendoukbn;
    }

    public void setZtyrendoukbn(String pZtyrendoukbn) {
        ztyrendoukbn = pZtyrendoukbn;
    }

    private String ztyyobiv1;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYYOBIV1)
    public String getZtyyobiv1() {
        return ztyyobiv1;
    }

    public void setZtyyobiv1(String pZtyyobiv1) {
        ztyyobiv1 = pZtyyobiv1;
    }

    private String ztysyuunoukeirokbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSYUUNOUKEIROKBN)
    public String getZtysyuunoukeirokbn() {
        return ztysyuunoukeirokbn;
    }

    public void setZtysyuunoukeirokbn(String pZtysyuunoukeirokbn) {
        ztysyuunoukeirokbn = pZtysyuunoukeirokbn;
    }

    private String ztysuitousisya;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSUITOUSISYA)
    public String getZtysuitousisya() {
        return ztysuitousisya;
    }

    public void setZtysuitousisya(String pZtysuitousisya) {
        ztysuitousisya = pZtysuitousisya;
    }

    private String ztysyuukinym;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSYUUKINYM)
    public String getZtysyuukinym() {
        return ztysyuukinym;
    }

    public void setZtysyuukinym(String pZtysyuukinym) {
        ztysyuukinym = pZtysyuukinym;
    }

    private String ztyjyuutouym;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYJYUUTOUYM)
    public String getZtyjyuutouym() {
        return ztyjyuutouym;
    }

    public void setZtyjyuutouym(String pZtyjyuutouym) {
        ztyjyuutouym = pZtyjyuutouym;
    }

    private String ztyjyuutoukaisuu;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYJYUUTOUKAISUU)
    public String getZtyjyuutoukaisuu() {
        return ztyjyuutoukaisuu;
    }

    public void setZtyjyuutoukaisuu(String pZtyjyuutoukaisuu) {
        ztyjyuutoukaisuu = pZtyjyuutoukaisuu;
    }

    private String ztyzennoukbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYZENNOUKBN)
    public String getZtyzennoukbn() {
        return ztyzennoukbn;
    }

    public void setZtyzennoukbn(String pZtyzennoukbn) {
        ztyzennoukbn = pZtyzennoukbn;
    }

    private String ztysetkykkbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSETKYKKBN)
    public String getZtysetkykkbn() {
        return ztysetkykkbn;
    }

    public void setZtysetkykkbn(String pZtysetkykkbn) {
        ztysetkykkbn = pZtysetkykkbn;
    }

    private String ztybankikkatuhyouji;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYBANKIKKATUHYOUJI)
    public String getZtybankikkatuhyouji() {
        return ztybankikkatuhyouji;
    }

    public void setZtybankikkatuhyouji(String pZtybankikkatuhyouji) {
        ztybankikkatuhyouji = pZtybankikkatuhyouji;
    }

    private String ztyrecordkbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYRECORDKBN)
    public String getZtyrecordkbn() {
        return ztyrecordkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyrecordkbn(String pZtyrecordkbn) {
        ztyrecordkbn = pZtyrecordkbn;
    }

    private String ztytnknmnosjtikbbnjyutukbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTNKNMNOSJTIKBBNJYUTUKBN)
    public String getZtytnknmnosjtikbbnjyutukbn() {
        return ztytnknmnosjtikbbnjyutukbn;
    }

    public void setZtytnknmnosjtikbbnjyutukbn(String pZtytnknmnosjtikbbnjyutukbn) {
        ztytnknmnosjtikbbnjyutukbn = pZtytnknmnosjtikbbnjyutukbn;
    }

    private String ztysetrenseimrtikatakbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSETRENSEIMRTIKATAKBN)
    public String getZtysetrenseimrtikatakbn() {
        return ztysetrenseimrtikatakbn;
    }

    public void setZtysetrenseimrtikatakbn(String pZtysetrenseimrtikatakbn) {
        ztysetrenseimrtikatakbn = pZtysetrenseimrtikatakbn;
    }

    private String ztyhaitoukbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYHAITOUKBN)
    public String getZtyhaitoukbn() {
        return ztyhaitoukbn;
    }

    public void setZtyhaitoukbn(String pZtyhaitoukbn) {
        ztyhaitoukbn = pZtyhaitoukbn;
    }

    private String ztysyukeiyakupwaribikikbnx2;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSYUKEIYAKUPWARIBIKIKBNX2)
    public String getZtysyukeiyakupwaribikikbnx2() {
        return ztysyukeiyakupwaribikikbnx2;
    }

    public void setZtysyukeiyakupwaribikikbnx2(String pZtysyukeiyakupwaribikikbnx2) {
        ztysyukeiyakupwaribikikbnx2 = pZtysyukeiyakupwaribikikbnx2;
    }

    private String ztysykyktnknyugukbnx2;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSYKYKTNKNYUGUKBNX2)
    public String getZtysykyktnknyugukbnx2() {
        return ztysykyktnknyugukbnx2;
    }

    public void setZtysykyktnknyugukbnx2(String pZtysykyktnknyugukbnx2) {
        ztysykyktnknyugukbnx2 = pZtysykyktnknyugukbnx2;
    }

    private String ztysetkaigomaruteikatakbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSETKAIGOMARUTEIKATAKBN)
    public String getZtysetkaigomaruteikatakbn() {
        return ztysetkaigomaruteikatakbn;
    }

    public void setZtysetkaigomaruteikatakbn(String pZtysetkaigomaruteikatakbn) {
        ztysetkaigomaruteikatakbn = pZtysetkaigomaruteikatakbn;
    }

    private String ztydenymd;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYDENYMD)
    public String getZtydenymd() {
        return ztydenymd;
    }

    public void setZtydenymd(String pZtydenymd) {
        ztydenymd = pZtydenymd;
    }

    private Long ztysyonendosyokaip;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSYONENDOSYOKAIP)
    public Long getZtysyonendosyokaip() {
        return ztysyonendosyokaip;
    }

    public void setZtysyonendosyokaip(Long pZtysyonendosyokaip) {
        ztysyonendosyokaip = pZtysyonendosyokaip;
    }

    private Long ztysyonendo2kaimeikoup;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSYONENDO2KAIMEIKOUP)
    public Long getZtysyonendo2kaimeikoup() {
        return ztysyonendo2kaimeikoup;
    }

    public void setZtysyonendo2kaimeikoup(Long pZtysyonendo2kaimeikoup) {
        ztysyonendo2kaimeikoup = pZtysyonendo2kaimeikoup;
    }

    private Long ztyjinendoikoup;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYJINENDOIKOUP)
    public Long getZtyjinendoikoup() {
        return ztyjinendoikoup;
    }

    public void setZtyjinendoikoup(Long pZtyjinendoikoup) {
        ztyjinendoikoup = pZtyjinendoikoup;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztysaimnkkykhyj;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSAIMNKKYKHYJ)
    public String getZtysaimnkkykhyj() {
        return ztysaimnkkykhyj;
    }

    public void setZtysaimnkkykhyj(String pZtysaimnkkykhyj) {
        ztysaimnkkykhyj = pZtysaimnkkykhyj;
    }

    private String ztyhknkkn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYHKNKKN)
    public String getZtyhknkkn() {
        return ztyhknkkn;
    }

    public void setZtyhknkkn(String pZtyhknkkn) {
        ztyhknkkn = pZtyhknkkn;
    }

    private String ztyphrkkikn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYPHRKKIKN)
    public String getZtyphrkkikn() {
        return ztyphrkkikn;
    }

    public void setZtyphrkkikn(String pZtyphrkkikn) {
        ztyphrkkikn = pZtyphrkkikn;
    }

    private String ztyhihokensyaagev2;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYHIHOKENSYAAGEV2)
    public String getZtyhihokensyaagev2() {
        return ztyhihokensyaagev2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhihokensyaagev2(String pZtyhihokensyaagev2) {
        ztyhihokensyaagev2 = pZtyhihokensyaagev2;
    }

    private String ztykyksyanen;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYKYKSYANEN)
    public String getZtykyksyanen() {
        return ztykyksyanen;
    }

    public void setZtykyksyanen(String pZtykyksyanen) {
        ztykyksyanen = pZtykyksyanen;
    }

    private String ztykykymd;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztyannaifuyouriyuukbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYANNAIFUYOURIYUUKBN)
    public String getZtyannaifuyouriyuukbn() {
        return ztyannaifuyouriyuukbn;
    }

    public void setZtyannaifuyouriyuukbn(String pZtyannaifuyouriyuukbn) {
        ztyannaifuyouriyuukbn = pZtyannaifuyouriyuukbn;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztysdpdkbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSDPDKBN)
    public String getZtysdpdkbn() {
        return ztysdpdkbn;
    }

    public void setZtysdpdkbn(String pZtysdpdkbn) {
        ztysdpdkbn = pZtysdpdkbn;
    }

    private String ztyryouritukbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYRYOURITUKBN)
    public String getZtyryouritukbn() {
        return ztyryouritukbn;
    }

    public void setZtyryouritukbn(String pZtyryouritukbn) {
        ztyryouritukbn = pZtyryouritukbn;
    }

    private String ztytksyuannaikykkbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTKSYUANNAIKYKKBN)
    public String getZtytksyuannaikykkbn() {
        return ztytksyuannaikykkbn;
    }

    public void setZtytksyuannaikykkbn(String pZtytksyuannaikykkbn) {
        ztytksyuannaikykkbn = pZtytksyuannaikykkbn;
    }

    private String ztydai2hhknnen;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYDAI2HHKNNEN)
    public String getZtydai2hhknnen() {
        return ztydai2hhknnen;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtydai2hhknnen(String pZtydai2hhknnen) {
        ztydai2hhknnen = pZtydai2hhknnen;
    }

    private String ztyhknsyuruikigousedaikbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYHKNSYURUIKIGOUSEDAIKBN)
    public String getZtyhknsyuruikigousedaikbn() {
        return ztyhknsyuruikigousedaikbn;
    }

    public void setZtyhknsyuruikigousedaikbn(String pZtyhknsyuruikigousedaikbn) {
        ztyhknsyuruikigousedaikbn = pZtyhknsyuruikigousedaikbn;
    }

    private String ztypmenhukakbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYPMENHUKAKBN)
    public String getZtypmenhukakbn() {
        return ztypmenhukakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtypmenhukakbn(String pZtypmenhukakbn) {
        ztypmenhukakbn = pZtypmenhukakbn;
    }

    private String ztyhosyouikkatumnoshyouji;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYHOSYOUIKKATUMNOSHYOUJI)
    public String getZtyhosyouikkatumnoshyouji() {
        return ztyhosyouikkatumnoshyouji;
    }

    public void setZtyhosyouikkatumnoshyouji(String pZtyhosyouikkatumnoshyouji) {
        ztyhosyouikkatumnoshyouji = pZtyhosyouikkatumnoshyouji;
    }

    private String ztyyobiv1x2;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYYOBIV1X2)
    public String getZtyyobiv1x2() {
        return ztyyobiv1x2;
    }

    public void setZtyyobiv1x2(String pZtyyobiv1x2) {
        ztyyobiv1x2 = pZtyyobiv1x2;
    }

    private Long ztykihons;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYKIHONS)
    public Long getZtykihons() {
        return ztykihons;
    }

    public void setZtykihons(Long pZtykihons) {
        ztykihons = pZtykihons;
    }

    private Long ztygoukeitenkans;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYGOUKEITENKANS)
    public Long getZtygoukeitenkans() {
        return ztygoukeitenkans;
    }

    public void setZtygoukeitenkans(Long pZtygoukeitenkans) {
        ztygoukeitenkans = pZtygoukeitenkans;
    }

    private Long ztyhngknksaiteihosyukngk;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYHNGKNKSAITEIHOSYUKNGK)
    public Long getZtyhngknksaiteihosyukngk() {
        return ztyhngknksaiteihosyukngk;
    }

    public void setZtyhngknksaiteihosyukngk(Long pZtyhngknksaiteihosyukngk) {
        ztyhngknksaiteihosyukngk = pZtyhngknksaiteihosyukngk;
    }

    private String ztyaatukaisosikicd;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYAATUKAISOSIKICD)
    public String getZtyaatukaisosikicd() {
        return ztyaatukaisosikicd;
    }

    public void setZtyaatukaisosikicd(String pZtyaatukaisosikicd) {
        ztyaatukaisosikicd = pZtyaatukaisosikicd;
    }

    private String ztyaatukaikojincd;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYAATUKAIKOJINCD)
    public String getZtyaatukaikojincd() {
        return ztyaatukaikojincd;
    }

    public void setZtyaatukaikojincd(String pZtyaatukaikojincd) {
        ztyaatukaikojincd = pZtyaatukaikojincd;
    }

    private String ztybsyym;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYBSYYM)
    public String getZtybsyym() {
        return ztybsyym;
    }

    public void setZtybsyym(String pZtybsyym) {
        ztybsyym = pZtybsyym;
    }

    private Long ztyharaikomip;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYHARAIKOMIP)
    public Long getZtyharaikomip() {
        return ztyharaikomip;
    }

    public void setZtyharaikomip(Long pZtyharaikomip) {
        ztyharaikomip = pZtyharaikomip;
    }

    private Long ztysyukeiyakup;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSYUKEIYAKUP)
    public Long getZtysyukeiyakup() {
        return ztysyukeiyakup;
    }

    public void setZtysyukeiyakup(Long pZtysyukeiyakup) {
        ztysyukeiyakup = pZtysyukeiyakup;
    }

    private Long ztytokujyoup;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUJYOUP)
    public Long getZtytokujyoup() {
        return ztytokujyoup;
    }

    public void setZtytokujyoup(Long pZtytokujyoup) {
        ztytokujyoup = pZtytokujyoup;
    }

    private Long ztyitibuitijibarais;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYITIBUITIJIBARAIS)
    public Long getZtyitibuitijibarais() {
        return ztyitibuitijibarais;
    }

    public void setZtyitibuitijibarais(Long pZtyitibuitijibarais) {
        ztyitibuitijibarais = pZtyitibuitijibarais;
    }

    private Long ztyitibuitijibaraip;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYITIBUITIJIBARAIP)
    public Long getZtyitibuitijibaraip() {
        return ztyitibuitijibaraip;
    }

    public void setZtyitibuitijibaraip(Long pZtyitibuitijibaraip) {
        ztyitibuitijibaraip = pZtyitibuitijibaraip;
    }

    private Long ztygoukeitenkanteikis;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYGOUKEITENKANTEIKIS)
    public Long getZtygoukeitenkanteikis() {
        return ztygoukeitenkanteikis;
    }

    public void setZtygoukeitenkanteikis(Long pZtygoukeitenkanteikis) {
        ztygoukeitenkanteikis = pZtygoukeitenkanteikis;
    }

    private String ztysyuunoukbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSYUUNOUKBN)
    public String getZtysyuunoukbn() {
        return ztysyuunoukbn;
    }

    public void setZtysyuunoukbn(String pZtysyuunoukbn) {
        ztysyuunoukbn = pZtysyuunoukbn;
    }

    private Integer ztytkykkumkhnsyukosuu;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTKYKKUMKHNSYUKOSUU)
    public Integer getZtytkykkumkhnsyukosuu() {
        return ztytkykkumkhnsyukosuu;
    }

    public void setZtytkykkumkhnsyukosuu(Integer pZtytkykkumkhnsyukosuu) {
        ztytkykkumkhnsyukosuu = pZtytkykkumkhnsyukosuu;
    }

    private String ztysiteizukipwarimasihyouji;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSITEIZUKIPWARIMASIHYOUJI)
    public String getZtysiteizukipwarimasihyouji() {
        return ztysiteizukipwarimasihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysiteizukipwarimasihyouji(String pZtysiteizukipwarimasihyouji) {
        ztysiteizukipwarimasihyouji = pZtysiteizukipwarimasihyouji;
    }

    private String ztypwarimasisiteim1;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYPWARIMASISITEIM1)
    public String getZtypwarimasisiteim1() {
        return ztypwarimasisiteim1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtypwarimasisiteim1(String pZtypwarimasisiteim1) {
        ztypwarimasisiteim1 = pZtypwarimasisiteim1;
    }

    private String ztypwarimasisiteim2;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYPWARIMASISITEIM2)
    public String getZtypwarimasisiteim2() {
        return ztypwarimasisiteim2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtypwarimasisiteim2(String pZtypwarimasisiteim2) {
        ztypwarimasisiteim2 = pZtypwarimasisiteim2;
    }

    private String ztysiteimsykykpbairitu;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSITEIMSYKYKPBAIRITU)
    public String getZtysiteimsykykpbairitu() {
        return ztysiteimsykykpbairitu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtysiteimsykykpbairitu(String pZtysiteimsykykpbairitu) {
        ztysiteimsykykpbairitu = pZtysiteimsykykpbairitu;
    }

    private Long ztysiteizukisyukeiyakup;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSITEIZUKISYUKEIYAKUP)
    public Long getZtysiteizukisyukeiyakup() {
        return ztysiteizukisyukeiyakup;
    }

    public void setZtysiteizukisyukeiyakup(Long pZtysiteizukisyukeiyakup) {
        ztysiteizukisyukeiyakup = pZtysiteizukisyukeiyakup;
    }

    private Long ztysiteizukiharaikomip;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSITEIZUKIHARAIKOMIP)
    public Long getZtysiteizukiharaikomip() {
        return ztysiteizukiharaikomip;
    }

    public void setZtysiteizukiharaikomip(Long pZtysiteizukiharaikomip) {
        ztysiteizukiharaikomip = pZtysiteizukiharaikomip;
    }

    private Long ztysaisyuusiteimhrkp;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSAISYUUSITEIMHRKP)
    public Long getZtysaisyuusiteimhrkp() {
        return ztysaisyuusiteimhrkp;
    }

    public void setZtysaisyuusiteimhrkp(Long pZtysaisyuusiteimhrkp) {
        ztysaisyuusiteimhrkp = pZtysaisyuusiteimhrkp;
    }

    private String ztysaisyuusiteiym;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSAISYUUSITEIYM)
    public String getZtysaisyuusiteiym() {
        return ztysaisyuusiteiym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZtysaisyuusiteiym(String pZtysaisyuusiteiym) {
        ztysaisyuusiteiym = pZtysaisyuusiteiym;
    }

    private String ztyanniskcd;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYANNISKCD)
    public String getZtyanniskcd() {
        return ztyanniskcd;
    }

    public void setZtyanniskcd(String pZtyanniskcd) {
        ztyanniskcd = pZtyanniskcd;
    }

    private BizNumber ztytumitateriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTUMITATERIRITU)
    public BizNumber getZtytumitateriritu() {
        return ztytumitateriritu;
    }

    public void setZtytumitateriritu(BizNumber pZtytumitateriritu) {
        ztytumitateriritu = pZtytumitateriritu;
    }

    private BizNumber ztysitihsyuriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSITIHSYURIRITU)
    public BizNumber getZtysitihsyuriritu() {
        return ztysitihsyuriritu;
    }

    public void setZtysitihsyuriritu(BizNumber pZtysitihsyuriritu) {
        ztysitihsyuriritu = pZtysitihsyuriritu;
    }

    private BizNumber ztynkgnsritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYNKGNSRITU)
    public BizNumber getZtynkgnsritu() {
        return ztynkgnsritu;
    }

    public void setZtynkgnsritu(BizNumber pZtynkgnsritu) {
        ztynkgnsritu = pZtynkgnsritu;
    }

    private String ztysinnyuukinkbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSINNYUUKINKBN)
    public String getZtysinnyuukinkbn() {
        return ztysinnyuukinkbn;
    }

    public void setZtysinnyuukinkbn(String pZtysinnyuukinkbn) {
        ztysinnyuukinkbn = pZtysinnyuukinkbn;
    }

    private String ztydfnyuukinkbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYDFNYUUKINKBN)
    public String getZtydfnyuukinkbn() {
        return ztydfnyuukinkbn;
    }

    public void setZtydfnyuukinkbn(String pZtydfnyuukinkbn) {
        ztydfnyuukinkbn = pZtydfnyuukinkbn;
    }

    private Long ztytorikuzusip;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTORIKUZUSIP)
    public Long getZtytorikuzusip() {
        return ztytorikuzusip;
    }

    public void setZtytorikuzusip(Long pZtytorikuzusip) {
        ztytorikuzusip = pZtytorikuzusip;
    }

    private String ztykbnkeiriyousegmentcd;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYKBNKEIRIYOUSEGMENTCD)
    public String getZtykbnkeiriyousegmentcd() {
        return ztykbnkeiriyousegmentcd;
    }

    public void setZtykbnkeiriyousegmentcd(String pZtykbnkeiriyousegmentcd) {
        ztykbnkeiriyousegmentcd = pZtykbnkeiriyousegmentcd;
    }

    private String ztysykikykjkykym;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSYKIKYKJKYKYM)
    public String getZtysykikykjkykym() {
        return ztysykikykjkykym;
    }

    public void setZtysykikykjkykym(String pZtysykikykjkykym) {
        ztysykikykjkykym = pZtysykikykjkykym;
    }

    private Long ztydfkijyunkingaku;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYDFKIJYUNKINGAKU)
    public Long getZtydfkijyunkingaku() {
        return ztydfkijyunkingaku;
    }

    public void setZtydfkijyunkingaku(Long pZtydfkijyunkingaku) {
        ztydfkijyunkingaku = pZtydfkijyunkingaku;
    }

    private String ztystdssytikbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSTDSSYTIKBN)
    public String getZtystdssytikbn() {
        return ztystdssytikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtystdssytikbn(String pZtystdssytikbn) {
        ztystdssytikbn = pZtystdssytikbn;
    }

    private String ztysotodasimanagehyouji;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSOTODASIMANAGEHYOUJI)
    public String getZtysotodasimanagehyouji() {
        return ztysotodasimanagehyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysotodasimanagehyouji(String pZtysotodasimanagehyouji) {
        ztysotodasimanagehyouji = pZtysotodasimanagehyouji;
    }

    private String ztysotodasiphkbnmnoshyouji;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSOTODASIPHKBNMNOSHYOUJI)
    public String getZtysotodasiphkbnmnoshyouji() {
        return ztysotodasiphkbnmnoshyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysotodasiphkbnmnoshyouji(String pZtysotodasiphkbnmnoshyouji) {
        ztysotodasiphkbnmnoshyouji = pZtysotodasiphkbnmnoshyouji;
    }

    private String ztystdsstkjytkyuhyj;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSTDSSTKJYTKYUHYJ)
    public String getZtystdsstkjytkyuhyj() {
        return ztystdsstkjytkyuhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtystdsstkjytkyuhyj(String pZtystdsstkjytkyuhyj) {
        ztystdsstkjytkyuhyj = pZtystdsstkjytkyuhyj;
    }

    private String ztykousinmanryouage;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYKOUSINMANRYOUAGE)
    public String getZtykousinmanryouage() {
        return ztykousinmanryouage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykousinmanryouage(String pZtykousinmanryouage) {
        ztykousinmanryouage = pZtykousinmanryouage;
    }

    private String ztyknkuzusnzyrttekitkarihyj;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYKNKUZUSNZYRTTEKITKARIHYJ)
    public String getZtyknkuzusnzyrttekitkarihyj() {
        return ztyknkuzusnzyrttekitkarihyj;
    }

    public void setZtyknkuzusnzyrttekitkarihyj(String pZtyknkuzusnzyrttekitkarihyj) {
        ztyknkuzusnzyrttekitkarihyj = pZtyknkuzusnzyrttekitkarihyj;
    }

    private String ztyknkuzusnzyrt;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYKNKUZUSNZYRT)
    public String getZtyknkuzusnzyrt() {
        return ztyknkuzusnzyrt;
    }

    public void setZtyknkuzusnzyrt(String pZtyknkuzusnzyrt) {
        ztyknkuzusnzyrt = pZtyknkuzusnzyrt;
    }

    private String ztytenkanjiknkuzusnzyrt;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTENKANJIKNKUZUSNZYRT)
    public String getZtytenkanjiknkuzusnzyrt() {
        return ztytenkanjiknkuzusnzyrt;
    }

    public void setZtytenkanjiknkuzusnzyrt(String pZtytenkanjiknkuzusnzyrt) {
        ztytenkanjiknkuzusnzyrt = pZtytenkanjiknkuzusnzyrt;
    }

    private String ztypwrbksidhitekiyouhyj;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYPWRBKSIDHITEKIYOUHYJ)
    public String getZtypwrbksidhitekiyouhyj() {
        return ztypwrbksidhitekiyouhyj;
    }

    public void setZtypwrbksidhitekiyouhyj(String pZtypwrbksidhitekiyouhyj) {
        ztypwrbksidhitekiyouhyj = pZtypwrbksidhitekiyouhyj;
    }

    private String ztysuuriyouyobin1x2;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSUURIYOUYOBIN1X2)
    public String getZtysuuriyouyobin1x2() {
        return ztysuuriyouyobin1x2;
    }

    public void setZtysuuriyouyobin1x2(String pZtysuuriyouyobin1x2) {
        ztysuuriyouyobin1x2 = pZtysuuriyouyobin1x2;
    }

    private String ztyzyrthntiyustatuskbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYZYRTHNTIYUSTATUSKBN)
    public String getZtyzyrthntiyustatuskbn() {
        return ztyzyrthntiyustatuskbn;
    }

    public void setZtyzyrthntiyustatuskbn(String pZtyzyrthntiyustatuskbn) {
        ztyzyrthntiyustatuskbn = pZtyzyrthntiyustatuskbn;
    }

    private String ztyyobiv9;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYYOBIV9)
    public String getZtyyobiv9() {
        return ztyyobiv9;
    }

    public void setZtyyobiv9(String pZtyyobiv9) {
        ztyyobiv9 = pZtyyobiv9;
    }

    private String ztysotodasipmenkbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSOTODASIPMENKBN)
    public String getZtysotodasipmenkbn() {
        return ztysotodasipmenkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysotodasipmenkbn(String pZtysotodasipmenkbn) {
        ztysotodasipmenkbn = pZtysotodasipmenkbn;
    }

    private String ztytokubetuhosyoukikan;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUBETUHOSYOUKIKAN)
    public String getZtytokubetuhosyoukikan() {
        return ztytokubetuhosyoukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtytokubetuhosyoukikan(String pZtytokubetuhosyoukikan) {
        ztytokubetuhosyoukikan = pZtytokubetuhosyoukikan;
    }

    private String ztysuuriyouyobin7;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSUURIYOUYOBIN7)
    public String getZtysuuriyouyobin7() {
        return ztysuuriyouyobin7;
    }

    public void setZtysuuriyouyobin7(String pZtysuuriyouyobin7) {
        ztysuuriyouyobin7 = pZtysuuriyouyobin7;
    }

    private Long ztyphireilkeisanyoup;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYPHIREILKEISANYOUP)
    public Long getZtyphireilkeisanyoup() {
        return ztyphireilkeisanyoup;
    }

    public void setZtyphireilkeisanyoup(Long pZtyphireilkeisanyoup) {
        ztyphireilkeisanyoup = pZtyphireilkeisanyoup;
    }

    private Long ztyyobin11;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYYOBIN11)
    public Long getZtyyobin11() {
        return ztyyobin11;
    }

    public void setZtyyobin11(Long pZtyyobin11) {
        ztyyobin11 = pZtyyobin11;
    }

    private Long ztyyobin11x2;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYYOBIN11X2)
    public Long getZtyyobin11x2() {
        return ztyyobin11x2;
    }

    public void setZtyyobin11x2(Long pZtyyobin11x2) {
        ztyyobin11x2 = pZtyyobin11x2;
    }

    private Long ztyyobin11x3;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYYOBIN11X3)
    public Long getZtyyobin11x3() {
        return ztyyobin11x3;
    }

    public void setZtyyobin11x3(Long pZtyyobin11x3) {
        ztyyobin11x3 = pZtyyobin11x3;
    }

    private Long ztyyobin11x4;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYYOBIN11X4)
    public Long getZtyyobin11x4() {
        return ztyyobin11x4;
    }

    public void setZtyyobin11x4(Long pZtyyobin11x4) {
        ztyyobin11x4 = pZtyyobin11x4;
    }

    private String ztycashlesshyj;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYCASHLESSHYJ)
    public String getZtycashlesshyj() {
        return ztycashlesshyj;
    }

    public void setZtycashlesshyj(String pZtycashlesshyj) {
        ztycashlesshyj = pZtycashlesshyj;
    }

    private String ztykykjiqpackhyj;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYKYKJIQPACKHYJ)
    public String getZtykykjiqpackhyj() {
        return ztykykjiqpackhyj;
    }

    public void setZtykykjiqpackhyj(String pZtykykjiqpackhyj) {
        ztykykjiqpackhyj = pZtykykjiqpackhyj;
    }

    private String ztytenkanminaosikbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTENKANMINAOSIKBN)
    public String getZtytenkanminaosikbn() {
        return ztytenkanminaosikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytenkanminaosikbn(String pZtytenkanminaosikbn) {
        ztytenkanminaosikbn = pZtytenkanminaosikbn;
    }

    private String ztyhhknnentysihyj;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYHHKNNENTYSIHYJ)
    public String getZtyhhknnentysihyj() {
        return ztyhhknnentysihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyhhknnentysihyj(String pZtyhhknnentysihyj) {
        ztyhhknnentysihyj = pZtyhhknnentysihyj;
    }

    private String ztydai2hhknnentysihyj;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYDAI2HHKNNENTYSIHYJ)
    public String getZtydai2hhknnentysihyj() {
        return ztydai2hhknnentysihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtydai2hhknnentysihyj(String pZtydai2hhknnentysihyj) {
        ztydai2hhknnentysihyj = pZtydai2hhknnentysihyj;
    }

    private String ztykyksyaagetyouseihyj;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYKYKSYAAGETYOUSEIHYJ)
    public String getZtykyksyaagetyouseihyj() {
        return ztykyksyaagetyouseihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykyksyaagetyouseihyj(String pZtykyksyaagetyouseihyj) {
        ztykyksyaagetyouseihyj = pZtykyksyaagetyouseihyj;
    }

    private String ztysykykhokenhoutekiyouhyj;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSYKYKHOKENHOUTEKIYOUHYJ)
    public String getZtysykykhokenhoutekiyouhyj() {
        return ztysykykhokenhoutekiyouhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysykykhokenhoutekiyouhyj(String pZtysykykhokenhoutekiyouhyj) {
        ztysykykhokenhoutekiyouhyj = pZtysykykhokenhoutekiyouhyj;
    }

    private String ztyhrimngtkykphrkkaisuukbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYHRIMNGTKYKPHRKKAISUUKBN)
    public String getZtyhrimngtkykphrkkaisuukbn() {
        return ztyhrimngtkykphrkkaisuukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyhrimngtkykphrkkaisuukbn(String pZtyhrimngtkykphrkkaisuukbn) {
        ztyhrimngtkykphrkkaisuukbn = pZtyhrimngtkykphrkkaisuukbn;
    }

    private String ztyjidoukousinhyouji;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYJIDOUKOUSINHYOUJI)
    public String getZtyjidoukousinhyouji() {
        return ztyjidoukousinhyouji;
    }

    public void setZtyjidoukousinhyouji(String pZtyjidoukousinhyouji) {
        ztyjidoukousinhyouji = pZtyjidoukousinhyouji;
    }

    private String ztysuuriyouyobin1;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSUURIYOUYOBIN1)
    public String getZtysuuriyouyobin1() {
        return ztysuuriyouyobin1;
    }

    public void setZtysuuriyouyobin1(String pZtysuuriyouyobin1) {
        ztysuuriyouyobin1 = pZtysuuriyouyobin1;
    }

    private String ztytkjykbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTKJYKBN)
    public String getZtytkjykbn() {
        return ztytkjykbn;
    }

    public void setZtytkjykbn(String pZtytkjykbn) {
        ztytkjykbn = pZtytkjykbn;
    }

    private String ztydai2tokujyoukbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYDAI2TOKUJYOUKBN)
    public String getZtydai2tokujyoukbn() {
        return ztydai2tokujyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtydai2tokujyoukbn(String pZtydai2tokujyoukbn) {
        ztydai2tokujyoukbn = pZtydai2tokujyoukbn;
    }

    private Integer ztyryoumasihyouten;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYRYOUMASIHYOUTEN)
    public Integer getZtyryoumasihyouten() {
        return ztyryoumasihyouten;
    }

    public void setZtyryoumasihyouten(Integer pZtyryoumasihyouten) {
        ztyryoumasihyouten = pZtyryoumasihyouten;
    }

    private Integer ztydai2ryoumasihyouten;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYDAI2RYOUMASIHYOUTEN)
    public Integer getZtydai2ryoumasihyouten() {
        return ztydai2ryoumasihyouten;
    }

    public void setZtydai2ryoumasihyouten(Integer pZtydai2ryoumasihyouten) {
        ztydai2ryoumasihyouten = pZtydai2ryoumasihyouten;
    }

    private String ztysuuriyouyobin2;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSUURIYOUYOBIN2)
    public String getZtysuuriyouyobin2() {
        return ztysuuriyouyobin2;
    }

    public void setZtysuuriyouyobin2(String pZtysuuriyouyobin2) {
        ztysuuriyouyobin2 = pZtysuuriyouyobin2;
    }

    private String ztysuuriyouyobin10;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSUURIYOUYOBIN10)
    public String getZtysuuriyouyobin10() {
        return ztysuuriyouyobin10;
    }

    public void setZtysuuriyouyobin10(String pZtysuuriyouyobin10) {
        ztysuuriyouyobin10 = pZtysuuriyouyobin10;
    }

    private String ztysuuriyouyobin10x2;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSUURIYOUYOBIN10X2)
    public String getZtysuuriyouyobin10x2() {
        return ztysuuriyouyobin10x2;
    }

    public void setZtysuuriyouyobin10x2(String pZtysuuriyouyobin10x2) {
        ztysuuriyouyobin10x2 = pZtysuuriyouyobin10x2;
    }

    private String ztysuuriyouyobin10x3;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSUURIYOUYOBIN10X3)
    public String getZtysuuriyouyobin10x3() {
        return ztysuuriyouyobin10x3;
    }

    public void setZtysuuriyouyobin10x3(String pZtysuuriyouyobin10x3) {
        ztysuuriyouyobin10x3 = pZtysuuriyouyobin10x3;
    }

    private String ztysuuriyouyobin10x4;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSUURIYOUYOBIN10X4)
    public String getZtysuuriyouyobin10x4() {
        return ztysuuriyouyobin10x4;
    }

    public void setZtysuuriyouyobin10x4(String pZtysuuriyouyobin10x4) {
        ztysuuriyouyobin10x4 = pZtysuuriyouyobin10x4;
    }

    private String ztyyobiv10x6;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYYOBIV10X6)
    public String getZtyyobiv10x6() {
        return ztyyobiv10x6;
    }

    public void setZtyyobiv10x6(String pZtyyobiv10x6) {
        ztyyobiv10x6 = pZtyyobiv10x6;
    }

    private String ztyyobiv10x7;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYYOBIV10X7)
    public String getZtyyobiv10x7() {
        return ztyyobiv10x7;
    }

    public void setZtyyobiv10x7(String pZtyyobiv10x7) {
        ztyyobiv10x7 = pZtyyobiv10x7;
    }

    private String ztyyobiv10x8;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYYOBIV10X8)
    public String getZtyyobiv10x8() {
        return ztyyobiv10x8;
    }

    public void setZtyyobiv10x8(String pZtyyobiv10x8) {
        ztyyobiv10x8 = pZtyyobiv10x8;
    }

    private String ztyyobiv10x9;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYYOBIV10X9)
    public String getZtyyobiv10x9() {
        return ztyyobiv10x9;
    }

    public void setZtyyobiv10x9(String pZtyyobiv10x9) {
        ztyyobiv10x9 = pZtyyobiv10x9;
    }

    private String ztyyobiv10x10;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYYOBIV10X10)
    public String getZtyyobiv10x10() {
        return ztyyobiv10x10;
    }

    public void setZtyyobiv10x10(String pZtyyobiv10x10) {
        ztyyobiv10x10 = pZtyyobiv10x10;
    }

    private String ztyyobiv10x11;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYYOBIV10X11)
    public String getZtyyobiv10x11() {
        return ztyyobiv10x11;
    }

    public void setZtyyobiv10x11(String pZtyyobiv10x11) {
        ztyyobiv10x11 = pZtyyobiv10x11;
    }

    private String ztybosyuukeitaikbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYBOSYUUKEITAIKBN)
    public String getZtybosyuukeitaikbn() {
        return ztybosyuukeitaikbn;
    }

    public void setZtybosyuukeitaikbn(String pZtybosyuukeitaikbn) {
        ztybosyuukeitaikbn = pZtybosyuukeitaikbn;
    }

    private String ztyhrimngtkykphrkkirkbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYHRIMNGTKYKPHRKKIRKBN)
    public String getZtyhrimngtkykphrkkirkbn() {
        return ztyhrimngtkykphrkkirkbn;
    }

    public void setZtyhrimngtkykphrkkirkbn(String pZtyhrimngtkykphrkkirkbn) {
        ztyhrimngtkykphrkkirkbn = pZtyhrimngtkykphrkkirkbn;
    }

    private String ztyhrimngtkykpryurtkbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYHRIMNGTKYKPRYURTKBN)
    public String getZtyhrimngtkykpryurtkbn() {
        return ztyhrimngtkykpryurtkbn;
    }

    public void setZtyhrimngtkykpryurtkbn(String pZtyhrimngtkykpryurtkbn) {
        ztyhrimngtkykpryurtkbn = pZtyhrimngtkykpryurtkbn;
    }

    private String ztysyukeiyakusyuruicdv3;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSYUKEIYAKUSYURUICDV3)
    public String getZtysyukeiyakusyuruicdv3() {
        return ztysyukeiyakusyuruicdv3;
    }

    public void setZtysyukeiyakusyuruicdv3(String pZtysyukeiyakusyuruicdv3) {
        ztysyukeiyakusyuruicdv3 = pZtysyukeiyakusyuruicdv3;
    }

    private Long ztyyobin11x5;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYYOBIN11X5)
    public Long getZtyyobin11x5() {
        return ztyyobin11x5;
    }

    public void setZtyyobin11x5(Long pZtyyobin11x5) {
        ztyyobin11x5 = pZtyyobin11x5;
    }

    private Long ztyyobin11x6;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYYOBIN11X6)
    public Long getZtyyobin11x6() {
        return ztyyobin11x6;
    }

    public void setZtyyobin11x6(Long pZtyyobin11x6) {
        ztyyobin11x6 = pZtyyobin11x6;
    }

    private Long ztyyobin11x7;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYYOBIN11X7)
    public Long getZtyyobin11x7() {
        return ztyyobin11x7;
    }

    public void setZtyyobin11x7(Long pZtyyobin11x7) {
        ztyyobin11x7 = pZtyyobin11x7;
    }

    private Long ztyyobin11x8;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYYOBIN11X8)
    public Long getZtyyobin11x8() {
        return ztyyobin11x8;
    }

    public void setZtyyobin11x8(Long pZtyyobin11x8) {
        ztyyobin11x8 = pZtyyobin11x8;
    }

    private Long ztyyobin11x9;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYYOBIN11X9)
    public Long getZtyyobin11x9() {
        return ztyyobin11x9;
    }

    public void setZtyyobin11x9(Long pZtyyobin11x9) {
        ztyyobin11x9 = pZtyyobin11x9;
    }

    private String ztyraysystemhyj;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYRAYSYSTEMHYJ)
    public String getZtyraysystemhyj() {
        return ztyraysystemhyj;
    }

    public void setZtyraysystemhyj(String pZtyraysystemhyj) {
        ztyraysystemhyj = pZtyraysystemhyj;
    }

    private String ztygaikakbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYGAIKAKBN)
    public String getZtygaikakbn() {
        return ztygaikakbn;
    }

    public void setZtygaikakbn(String pZtygaikakbn) {
        ztygaikakbn = pZtygaikakbn;
    }

    private BizNumber ztykykjikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYKYKJIKAWASERATE)
    public BizNumber getZtykykjikawaserate() {
        return ztykykjikawaserate;
    }

    public void setZtykykjikawaserate(BizNumber pZtykykjikawaserate) {
        ztykykjikawaserate = pZtykykjikawaserate;
    }

    private String ztykykjikawaseratetkyuymd;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYKYKJIKAWASERATETKYUYMD)
    public String getZtykykjikawaseratetkyuymd() {
        return ztykykjikawaseratetkyuymd;
    }

    public void setZtykykjikawaseratetkyuymd(String pZtykykjikawaseratetkyuymd) {
        ztykykjikawaseratetkyuymd = pZtykykjikawaseratetkyuymd;
    }

    private BizNumber ztykeiyakujiyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYKEIYAKUJIYOTEIRIRITU)
    public BizNumber getZtykeiyakujiyoteiriritu() {
        return ztykeiyakujiyoteiriritu;
    }

    public void setZtykeiyakujiyoteiriritu(BizNumber pZtykeiyakujiyoteiriritu) {
        ztykeiyakujiyoteiriritu = pZtykeiyakujiyoteiriritu;
    }

    private Long ztyenkdtsbujsitihsyukngk;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYENKDTSBUJSITIHSYUKNGK)
    public Long getZtyenkdtsbujsitihsyukngk() {
        return ztyenkdtsbujsitihsyukngk;
    }

    public void setZtyenkdtsbujsitihsyukngk(Long pZtyenkdtsbujsitihsyukngk) {
        ztyenkdtsbujsitihsyukngk = pZtyenkdtsbujsitihsyukngk;
    }

    private String ztynyuukintuukakbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYNYUUKINTUUKAKBN)
    public String getZtynyuukintuukakbn() {
        return ztynyuukintuukakbn;
    }

    public void setZtynyuukintuukakbn(String pZtynyuukintuukakbn) {
        ztynyuukintuukakbn = pZtynyuukintuukakbn;
    }

    private String ztysisuurendourate;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSISUURENDOURATE)
    public String getZtysisuurendourate() {
        return ztysisuurendourate;
    }

    public void setZtysisuurendourate(String pZtysisuurendourate) {
        ztysisuurendourate = pZtysisuurendourate;
    }

    private String ztysisuukbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSISUUKBN)
    public String getZtysisuukbn() {
        return ztysisuukbn;
    }

    public void setZtysisuukbn(String pZtysisuukbn) {
        ztysisuukbn = pZtysisuukbn;
    }

    private BizNumber ztynyknjikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYNYKNJIKAWASERATE)
    public BizNumber getZtynyknjikawaserate() {
        return ztynyknjikawaserate;
    }

    public void setZtynyknjikawaserate(BizNumber pZtynyknjikawaserate) {
        ztynyknjikawaserate = pZtynyknjikawaserate;
    }

    private String ztynyknjikawaseratetkyuymd;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYNYKNJIKAWASERATETKYUYMD)
    public String getZtynyknjikawaseratetkyuymd() {
        return ztynyknjikawaseratetkyuymd;
    }

    public void setZtynyknjikawaseratetkyuymd(String pZtynyknjikawaseratetkyuymd) {
        ztynyknjikawaseratetkyuymd = pZtynyknjikawaseratetkyuymd;
    }

    private String ztysrdai1hknkkn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSRDAI1HKNKKN)
    public String getZtysrdai1hknkkn() {
        return ztysrdai1hknkkn;
    }

    public void setZtysrdai1hknkkn(String pZtysrdai1hknkkn) {
        ztysrdai1hknkkn = pZtysrdai1hknkkn;
    }

    private String ztysuuriyouyobin10x5;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSUURIYOUYOBIN10X5)
    public String getZtysuuriyouyobin10x5() {
        return ztysuuriyouyobin10x5;
    }

    public void setZtysuuriyouyobin10x5(String pZtysuuriyouyobin10x5) {
        ztysuuriyouyobin10x5 = pZtysuuriyouyobin10x5;
    }

    private String ztytuukasyukbn;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTUUKASYUKBN)
    public String getZtytuukasyukbn() {
        return ztytuukasyukbn;
    }

    public void setZtytuukasyukbn(String pZtytuukasyukbn) {
        ztytuukasyukbn = pZtytuukasyukbn;
    }

    private String ztyyobiv9x2;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYYOBIV9X2)
    public String getZtyyobiv9x2() {
        return ztyyobiv9x2;
    }

    public void setZtyyobiv9x2(String pZtyyobiv9x2) {
        ztyyobiv9x2 = pZtyyobiv9x2;
    }

    private String ztyyobiv10x16;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYYOBIV10X16)
    public String getZtyyobiv10x16() {
        return ztyyobiv10x16;
    }

    public void setZtyyobiv10x16(String pZtyyobiv10x16) {
        ztyyobiv10x16 = pZtyyobiv10x16;
    }

    private Long ztynkgns;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYNKGNS)
    public Long getZtynkgns() {
        return ztynkgns;
    }

    public void setZtynkgns(Long pZtynkgns) {
        ztynkgns = pZtynkgns;
    }

    private Long ztysisuubbntounyuugk;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSISUUBBNTOUNYUUGK)
    public Long getZtysisuubbntounyuugk() {
        return ztysisuubbntounyuugk;
    }

    public void setZtysisuubbntounyuugk(Long pZtysisuubbntounyuugk) {
        ztysisuubbntounyuugk = pZtysisuubbntounyuugk;
    }

    private BizNumber ztysaisinyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYSAISINYOTEIRIRITU)
    public BizNumber getZtysaisinyoteiriritu() {
        return ztysaisinyoteiriritu;
    }

    public void setZtysaisinyoteiriritu(BizNumber pZtysaisinyoteiriritu) {
        ztysaisinyoteiriritu = pZtysaisinyoteiriritu;
    }

    private Integer ztyyobin5;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYYOBIN5)
    public Integer getZtyyobin5() {
        return ztyyobin5;
    }

    public void setZtyyobin5(Integer pZtyyobin5) {
        ztyyobin5 = pZtyyobin5;
    }

    private Long ztyyobin11x10;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYYOBIN11X10)
    public Long getZtyyobin11x10() {
        return ztyyobin11x10;
    }

    public void setZtyyobin11x10(Long pZtyyobin11x10) {
        ztyyobin11x10 = pZtyyobin11x10;
    }

    private Long ztykiharaikomip;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYKIHARAIKOMIP)
    public Long getZtykiharaikomip() {
        return ztykiharaikomip;
    }

    public void setZtykiharaikomip(Long pZtykiharaikomip) {
        ztykiharaikomip = pZtykiharaikomip;
    }

    private Long ztytumitatekin;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTUMITATEKIN)
    public Long getZtytumitatekin() {
        return ztytumitatekin;
    }

    public void setZtytumitatekin(Long pZtytumitatekin) {
        ztytumitatekin = pZtytumitatekin;
    }

    private Long ztyzennoujiikkatubaraijytgk;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYZENNOUJIIKKATUBARAIJYTGK)
    public Long getZtyzennoujiikkatubaraijytgk() {
        return ztyzennoujiikkatubaraijytgk;
    }

    public void setZtyzennoujiikkatubaraijytgk(Long pZtyzennoujiikkatubaraijytgk) {
        ztyzennoujiikkatubaraijytgk = pZtyzennoujiikkatubaraijytgk;
    }

    private Long ztygaikadatenkgns;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYGAIKADATENKGNS)
    public Long getZtygaikadatenkgns() {
        return ztygaikadatenkgns;
    }

    public void setZtygaikadatenkgns(Long pZtygaikadatenkgns) {
        ztygaikadatenkgns = pZtygaikadatenkgns;
    }

    private Long ztygaikadatesyukeiyakup;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYGAIKADATESYUKEIYAKUP)
    public Long getZtygaikadatesyukeiyakup() {
        return ztygaikadatesyukeiyakup;
    }

    public void setZtygaikadatesyukeiyakup(Long pZtygaikadatesyukeiyakup) {
        ztygaikadatesyukeiyakup = pZtygaikadatesyukeiyakup;
    }

    private String ztyyobiv1x3;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYYOBIV1X3)
    public String getZtyyobiv1x3() {
        return ztyyobiv1x3;
    }

    public void setZtyyobiv1x3(String pZtyyobiv1x3) {
        ztyyobiv1x3 = pZtyyobiv1x3;
    }

    private String ztytokuyakukoumokuv160;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160)
    public String getZtytokuyakukoumokuv160() {
        return ztytokuyakukoumokuv160;
    }

    public void setZtytokuyakukoumokuv160(String pZtytokuyakukoumokuv160) {
        ztytokuyakukoumokuv160 = pZtytokuyakukoumokuv160;
    }

    private String ztytokuyakukoumokuv160x2;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X2)
    public String getZtytokuyakukoumokuv160x2() {
        return ztytokuyakukoumokuv160x2;
    }

    public void setZtytokuyakukoumokuv160x2(String pZtytokuyakukoumokuv160x2) {
        ztytokuyakukoumokuv160x2 = pZtytokuyakukoumokuv160x2;
    }

    private String ztytokuyakukoumokuv160x3;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X3)
    public String getZtytokuyakukoumokuv160x3() {
        return ztytokuyakukoumokuv160x3;
    }

    public void setZtytokuyakukoumokuv160x3(String pZtytokuyakukoumokuv160x3) {
        ztytokuyakukoumokuv160x3 = pZtytokuyakukoumokuv160x3;
    }

    private String ztytokuyakukoumokuv160x4;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X4)
    public String getZtytokuyakukoumokuv160x4() {
        return ztytokuyakukoumokuv160x4;
    }

    public void setZtytokuyakukoumokuv160x4(String pZtytokuyakukoumokuv160x4) {
        ztytokuyakukoumokuv160x4 = pZtytokuyakukoumokuv160x4;
    }

    private String ztytokuyakukoumokuv160x5;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X5)
    public String getZtytokuyakukoumokuv160x5() {
        return ztytokuyakukoumokuv160x5;
    }

    public void setZtytokuyakukoumokuv160x5(String pZtytokuyakukoumokuv160x5) {
        ztytokuyakukoumokuv160x5 = pZtytokuyakukoumokuv160x5;
    }

    private String ztytokuyakukoumokuv160x6;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X6)
    public String getZtytokuyakukoumokuv160x6() {
        return ztytokuyakukoumokuv160x6;
    }

    public void setZtytokuyakukoumokuv160x6(String pZtytokuyakukoumokuv160x6) {
        ztytokuyakukoumokuv160x6 = pZtytokuyakukoumokuv160x6;
    }

    private String ztytokuyakukoumokuv160x7;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X7)
    public String getZtytokuyakukoumokuv160x7() {
        return ztytokuyakukoumokuv160x7;
    }

    public void setZtytokuyakukoumokuv160x7(String pZtytokuyakukoumokuv160x7) {
        ztytokuyakukoumokuv160x7 = pZtytokuyakukoumokuv160x7;
    }

    private String ztytokuyakukoumokuv160x8;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X8)
    public String getZtytokuyakukoumokuv160x8() {
        return ztytokuyakukoumokuv160x8;
    }

    public void setZtytokuyakukoumokuv160x8(String pZtytokuyakukoumokuv160x8) {
        ztytokuyakukoumokuv160x8 = pZtytokuyakukoumokuv160x8;
    }

    private String ztytokuyakukoumokuv160x9;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X9)
    public String getZtytokuyakukoumokuv160x9() {
        return ztytokuyakukoumokuv160x9;
    }

    public void setZtytokuyakukoumokuv160x9(String pZtytokuyakukoumokuv160x9) {
        ztytokuyakukoumokuv160x9 = pZtytokuyakukoumokuv160x9;
    }

    private String ztytokuyakukoumokuv160x10;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X10)
    public String getZtytokuyakukoumokuv160x10() {
        return ztytokuyakukoumokuv160x10;
    }

    public void setZtytokuyakukoumokuv160x10(String pZtytokuyakukoumokuv160x10) {
        ztytokuyakukoumokuv160x10 = pZtytokuyakukoumokuv160x10;
    }

    private String ztytokuyakukoumokuv160x11;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X11)
    public String getZtytokuyakukoumokuv160x11() {
        return ztytokuyakukoumokuv160x11;
    }

    public void setZtytokuyakukoumokuv160x11(String pZtytokuyakukoumokuv160x11) {
        ztytokuyakukoumokuv160x11 = pZtytokuyakukoumokuv160x11;
    }

    private String ztytokuyakukoumokuv160x12;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X12)
    public String getZtytokuyakukoumokuv160x12() {
        return ztytokuyakukoumokuv160x12;
    }

    public void setZtytokuyakukoumokuv160x12(String pZtytokuyakukoumokuv160x12) {
        ztytokuyakukoumokuv160x12 = pZtytokuyakukoumokuv160x12;
    }

    private String ztytokuyakukoumokuv160x13;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X13)
    public String getZtytokuyakukoumokuv160x13() {
        return ztytokuyakukoumokuv160x13;
    }

    public void setZtytokuyakukoumokuv160x13(String pZtytokuyakukoumokuv160x13) {
        ztytokuyakukoumokuv160x13 = pZtytokuyakukoumokuv160x13;
    }

    private String ztytokuyakukoumokuv160x14;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X14)
    public String getZtytokuyakukoumokuv160x14() {
        return ztytokuyakukoumokuv160x14;
    }

    public void setZtytokuyakukoumokuv160x14(String pZtytokuyakukoumokuv160x14) {
        ztytokuyakukoumokuv160x14 = pZtytokuyakukoumokuv160x14;
    }

    private String ztytokuyakukoumokuv160x15;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X15)
    public String getZtytokuyakukoumokuv160x15() {
        return ztytokuyakukoumokuv160x15;
    }

    public void setZtytokuyakukoumokuv160x15(String pZtytokuyakukoumokuv160x15) {
        ztytokuyakukoumokuv160x15 = pZtytokuyakukoumokuv160x15;
    }

    private String ztytokuyakukoumokuv160x16;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X16)
    public String getZtytokuyakukoumokuv160x16() {
        return ztytokuyakukoumokuv160x16;
    }

    public void setZtytokuyakukoumokuv160x16(String pZtytokuyakukoumokuv160x16) {
        ztytokuyakukoumokuv160x16 = pZtytokuyakukoumokuv160x16;
    }

    private String ztytokuyakukoumokuv160x17;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X17)
    public String getZtytokuyakukoumokuv160x17() {
        return ztytokuyakukoumokuv160x17;
    }

    public void setZtytokuyakukoumokuv160x17(String pZtytokuyakukoumokuv160x17) {
        ztytokuyakukoumokuv160x17 = pZtytokuyakukoumokuv160x17;
    }

    private String ztytokuyakukoumokuv160x18;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X18)
    public String getZtytokuyakukoumokuv160x18() {
        return ztytokuyakukoumokuv160x18;
    }

    public void setZtytokuyakukoumokuv160x18(String pZtytokuyakukoumokuv160x18) {
        ztytokuyakukoumokuv160x18 = pZtytokuyakukoumokuv160x18;
    }

    private String ztytokuyakukoumokuv160x19;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X19)
    public String getZtytokuyakukoumokuv160x19() {
        return ztytokuyakukoumokuv160x19;
    }

    public void setZtytokuyakukoumokuv160x19(String pZtytokuyakukoumokuv160x19) {
        ztytokuyakukoumokuv160x19 = pZtytokuyakukoumokuv160x19;
    }

    private String ztytokuyakukoumokuv160x20;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X20)
    public String getZtytokuyakukoumokuv160x20() {
        return ztytokuyakukoumokuv160x20;
    }

    public void setZtytokuyakukoumokuv160x20(String pZtytokuyakukoumokuv160x20) {
        ztytokuyakukoumokuv160x20 = pZtytokuyakukoumokuv160x20;
    }

    private String ztytokuyakukoumokuv160x21;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X21)
    public String getZtytokuyakukoumokuv160x21() {
        return ztytokuyakukoumokuv160x21;
    }

    public void setZtytokuyakukoumokuv160x21(String pZtytokuyakukoumokuv160x21) {
        ztytokuyakukoumokuv160x21 = pZtytokuyakukoumokuv160x21;
    }

    private String ztytokuyakukoumokuv160x22;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X22)
    public String getZtytokuyakukoumokuv160x22() {
        return ztytokuyakukoumokuv160x22;
    }

    public void setZtytokuyakukoumokuv160x22(String pZtytokuyakukoumokuv160x22) {
        ztytokuyakukoumokuv160x22 = pZtytokuyakukoumokuv160x22;
    }

    private String ztytokuyakukoumokuv160x23;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X23)
    public String getZtytokuyakukoumokuv160x23() {
        return ztytokuyakukoumokuv160x23;
    }

    public void setZtytokuyakukoumokuv160x23(String pZtytokuyakukoumokuv160x23) {
        ztytokuyakukoumokuv160x23 = pZtytokuyakukoumokuv160x23;
    }

    private String ztytokuyakukoumokuv160x24;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X24)
    public String getZtytokuyakukoumokuv160x24() {
        return ztytokuyakukoumokuv160x24;
    }

    public void setZtytokuyakukoumokuv160x24(String pZtytokuyakukoumokuv160x24) {
        ztytokuyakukoumokuv160x24 = pZtytokuyakukoumokuv160x24;
    }

    private String ztytokuyakukoumokuv160x25;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X25)
    public String getZtytokuyakukoumokuv160x25() {
        return ztytokuyakukoumokuv160x25;
    }

    public void setZtytokuyakukoumokuv160x25(String pZtytokuyakukoumokuv160x25) {
        ztytokuyakukoumokuv160x25 = pZtytokuyakukoumokuv160x25;
    }

    private String ztytokuyakukoumokuv160x26;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X26)
    public String getZtytokuyakukoumokuv160x26() {
        return ztytokuyakukoumokuv160x26;
    }

    public void setZtytokuyakukoumokuv160x26(String pZtytokuyakukoumokuv160x26) {
        ztytokuyakukoumokuv160x26 = pZtytokuyakukoumokuv160x26;
    }

    private String ztytokuyakukoumokuv160x27;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X27)
    public String getZtytokuyakukoumokuv160x27() {
        return ztytokuyakukoumokuv160x27;
    }

    public void setZtytokuyakukoumokuv160x27(String pZtytokuyakukoumokuv160x27) {
        ztytokuyakukoumokuv160x27 = pZtytokuyakukoumokuv160x27;
    }

    private String ztytokuyakukoumokuv160x28;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X28)
    public String getZtytokuyakukoumokuv160x28() {
        return ztytokuyakukoumokuv160x28;
    }

    public void setZtytokuyakukoumokuv160x28(String pZtytokuyakukoumokuv160x28) {
        ztytokuyakukoumokuv160x28 = pZtytokuyakukoumokuv160x28;
    }

    private String ztytokuyakukoumokuv160x29;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X29)
    public String getZtytokuyakukoumokuv160x29() {
        return ztytokuyakukoumokuv160x29;
    }

    public void setZtytokuyakukoumokuv160x29(String pZtytokuyakukoumokuv160x29) {
        ztytokuyakukoumokuv160x29 = pZtytokuyakukoumokuv160x29;
    }

    private String ztytokuyakukoumokuv160x30;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X30)
    public String getZtytokuyakukoumokuv160x30() {
        return ztytokuyakukoumokuv160x30;
    }

    public void setZtytokuyakukoumokuv160x30(String pZtytokuyakukoumokuv160x30) {
        ztytokuyakukoumokuv160x30 = pZtytokuyakukoumokuv160x30;
    }

    private String ztytokuyakukoumokuv160x31;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X31)
    public String getZtytokuyakukoumokuv160x31() {
        return ztytokuyakukoumokuv160x31;
    }

    public void setZtytokuyakukoumokuv160x31(String pZtytokuyakukoumokuv160x31) {
        ztytokuyakukoumokuv160x31 = pZtytokuyakukoumokuv160x31;
    }

    private String ztytokuyakukoumokuv160x32;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X32)
    public String getZtytokuyakukoumokuv160x32() {
        return ztytokuyakukoumokuv160x32;
    }

    public void setZtytokuyakukoumokuv160x32(String pZtytokuyakukoumokuv160x32) {
        ztytokuyakukoumokuv160x32 = pZtytokuyakukoumokuv160x32;
    }

    private String ztytokuyakukoumokuv160x33;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X33)
    public String getZtytokuyakukoumokuv160x33() {
        return ztytokuyakukoumokuv160x33;
    }

    public void setZtytokuyakukoumokuv160x33(String pZtytokuyakukoumokuv160x33) {
        ztytokuyakukoumokuv160x33 = pZtytokuyakukoumokuv160x33;
    }

    private String ztytokuyakukoumokuv160x34;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X34)
    public String getZtytokuyakukoumokuv160x34() {
        return ztytokuyakukoumokuv160x34;
    }

    public void setZtytokuyakukoumokuv160x34(String pZtytokuyakukoumokuv160x34) {
        ztytokuyakukoumokuv160x34 = pZtytokuyakukoumokuv160x34;
    }

    private String ztytokuyakukoumokuv160x35;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X35)
    public String getZtytokuyakukoumokuv160x35() {
        return ztytokuyakukoumokuv160x35;
    }

    public void setZtytokuyakukoumokuv160x35(String pZtytokuyakukoumokuv160x35) {
        ztytokuyakukoumokuv160x35 = pZtytokuyakukoumokuv160x35;
    }

    private String ztytokuyakukoumokuv160x36;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X36)
    public String getZtytokuyakukoumokuv160x36() {
        return ztytokuyakukoumokuv160x36;
    }

    public void setZtytokuyakukoumokuv160x36(String pZtytokuyakukoumokuv160x36) {
        ztytokuyakukoumokuv160x36 = pZtytokuyakukoumokuv160x36;
    }

    private String ztytokuyakukoumokuv160x37;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X37)
    public String getZtytokuyakukoumokuv160x37() {
        return ztytokuyakukoumokuv160x37;
    }

    public void setZtytokuyakukoumokuv160x37(String pZtytokuyakukoumokuv160x37) {
        ztytokuyakukoumokuv160x37 = pZtytokuyakukoumokuv160x37;
    }

    private String ztytokuyakukoumokuv160x38;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X38)
    public String getZtytokuyakukoumokuv160x38() {
        return ztytokuyakukoumokuv160x38;
    }

    public void setZtytokuyakukoumokuv160x38(String pZtytokuyakukoumokuv160x38) {
        ztytokuyakukoumokuv160x38 = pZtytokuyakukoumokuv160x38;
    }

    private String ztytokuyakukoumokuv160x39;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X39)
    public String getZtytokuyakukoumokuv160x39() {
        return ztytokuyakukoumokuv160x39;
    }

    public void setZtytokuyakukoumokuv160x39(String pZtytokuyakukoumokuv160x39) {
        ztytokuyakukoumokuv160x39 = pZtytokuyakukoumokuv160x39;
    }

    private String ztytokuyakukoumokuv160x40;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X40)
    public String getZtytokuyakukoumokuv160x40() {
        return ztytokuyakukoumokuv160x40;
    }

    public void setZtytokuyakukoumokuv160x40(String pZtytokuyakukoumokuv160x40) {
        ztytokuyakukoumokuv160x40 = pZtytokuyakukoumokuv160x40;
    }

    private String ztytokuyakukoumokuv160x41;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X41)
    public String getZtytokuyakukoumokuv160x41() {
        return ztytokuyakukoumokuv160x41;
    }

    public void setZtytokuyakukoumokuv160x41(String pZtytokuyakukoumokuv160x41) {
        ztytokuyakukoumokuv160x41 = pZtytokuyakukoumokuv160x41;
    }

    private String ztytokuyakukoumokuv160x42;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X42)
    public String getZtytokuyakukoumokuv160x42() {
        return ztytokuyakukoumokuv160x42;
    }

    public void setZtytokuyakukoumokuv160x42(String pZtytokuyakukoumokuv160x42) {
        ztytokuyakukoumokuv160x42 = pZtytokuyakukoumokuv160x42;
    }

    private String ztytokuyakukoumokuv160x43;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X43)
    public String getZtytokuyakukoumokuv160x43() {
        return ztytokuyakukoumokuv160x43;
    }

    public void setZtytokuyakukoumokuv160x43(String pZtytokuyakukoumokuv160x43) {
        ztytokuyakukoumokuv160x43 = pZtytokuyakukoumokuv160x43;
    }

    private String ztytokuyakukoumokuv160x44;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X44)
    public String getZtytokuyakukoumokuv160x44() {
        return ztytokuyakukoumokuv160x44;
    }

    public void setZtytokuyakukoumokuv160x44(String pZtytokuyakukoumokuv160x44) {
        ztytokuyakukoumokuv160x44 = pZtytokuyakukoumokuv160x44;
    }

    private String ztytokuyakukoumokuv160x45;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X45)
    public String getZtytokuyakukoumokuv160x45() {
        return ztytokuyakukoumokuv160x45;
    }

    public void setZtytokuyakukoumokuv160x45(String pZtytokuyakukoumokuv160x45) {
        ztytokuyakukoumokuv160x45 = pZtytokuyakukoumokuv160x45;
    }

    private String ztytokuyakukoumokuv160x46;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X46)
    public String getZtytokuyakukoumokuv160x46() {
        return ztytokuyakukoumokuv160x46;
    }

    public void setZtytokuyakukoumokuv160x46(String pZtytokuyakukoumokuv160x46) {
        ztytokuyakukoumokuv160x46 = pZtytokuyakukoumokuv160x46;
    }

    private String ztytokuyakukoumokuv160x47;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X47)
    public String getZtytokuyakukoumokuv160x47() {
        return ztytokuyakukoumokuv160x47;
    }

    public void setZtytokuyakukoumokuv160x47(String pZtytokuyakukoumokuv160x47) {
        ztytokuyakukoumokuv160x47 = pZtytokuyakukoumokuv160x47;
    }

    private String ztytokuyakukoumokuv160x48;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X48)
    public String getZtytokuyakukoumokuv160x48() {
        return ztytokuyakukoumokuv160x48;
    }

    public void setZtytokuyakukoumokuv160x48(String pZtytokuyakukoumokuv160x48) {
        ztytokuyakukoumokuv160x48 = pZtytokuyakukoumokuv160x48;
    }

    private String ztytokuyakukoumokuv160x49;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X49)
    public String getZtytokuyakukoumokuv160x49() {
        return ztytokuyakukoumokuv160x49;
    }

    public void setZtytokuyakukoumokuv160x49(String pZtytokuyakukoumokuv160x49) {
        ztytokuyakukoumokuv160x49 = pZtytokuyakukoumokuv160x49;
    }

    private String ztytokuyakukoumokuv160x50;

    @Column(name=GenZT_SkeisynyptoukeiksnTy.ZTYTOKUYAKUKOUMOKUV160X50)
    public String getZtytokuyakukoumokuv160x50() {
        return ztytokuyakukoumokuv160x50;
    }

    public void setZtytokuyakukoumokuv160x50(String pZtytokuyakukoumokuv160x50) {
        ztytokuyakukoumokuv160x50 = pZtytokuyakukoumokuv160x50;
    }
}