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
import yuyu.def.db.entity.ZT_SkeisynyptoukeiksnRn;
import yuyu.def.db.id.PKZT_SkeisynyptoukeiksnRn;
import yuyu.def.db.meta.GenQZT_SkeisynyptoukeiksnRn;
import yuyu.def.db.meta.QZT_SkeisynyptoukeiksnRn;

/**
 * 新契約収入Ｐ統計決算Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SkeisynyptoukeiksnRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SkeisynyptoukeiksnRn}</td><td colspan="3">新契約収入Ｐ統計決算Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">{@link PKZT_SkeisynyptoukeiksnRn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyuukourecordlength zrnyuukourecordlength}</td><td>（連携用）有効レコード長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnrdwarea zrnrdwarea}</td><td>（連携用）ＲＤＷ領域</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakanrino zrndatakanrino}</td><td>（連携用）データ管理番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoricd zrnsyoricd}</td><td>（連携用）処理コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrendoukbn zrnrendoukbn}</td><td>（連携用）連動区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1 zrnyobiv1}</td><td>（連携用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuunoukeirokbn zrnsyuunoukeirokbn}</td><td>（連携用）収納経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuitousisya zrnsuitousisya}</td><td>（連携用）出納支社</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuukinym zrnsyuukinym}</td><td>（連携用）集金年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyuutouym zrnjyuutouym}</td><td>（連携用）充当年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyuutoukaisuu zrnjyuutoukaisuu}</td><td>（連携用）充当回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennoukbn zrnzennoukbn}</td><td>（連携用）前納区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetkykkbn zrnsetkykkbn}</td><td>（連携用）セット契約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbankikkatuhyouji zrnbankikkatuhyouji}</td><td>（連携用）バンク一括表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrecordkbn zrnrecordkbn}</td><td>（連携用）レコード区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntnknmnosjtikbbnjyutukbn zrntnknmnosjtikbbnjyutukbn}</td><td>（連携用）転換見直時定期部分充当区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetrenseimrtikatakbn zrnsetrenseimrtikatakbn}</td><td>（連携用）セット連生マル定型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhaitoukbn zrnhaitoukbn}</td><td>（連携用）配当区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakupwaribikikbnx2 zrnsyukeiyakupwaribikikbnx2}</td><td>（連携用）主契約Ｐ割引区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykyktnknyugukbnx2 zrnsykyktnknyugukbnx2}</td><td>（連携用）主契約転換優遇区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetkaigomaruteikatakbn zrnsetkaigomaruteikatakbn}</td><td>（連携用）セット介護マル定型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndenymd zrndenymd}</td><td>（連携用）伝票日付</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyonendosyokaip zrnsyonendosyokaip}</td><td>（連携用）初年度初回Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyonendo2kaimeikoup zrnsyonendo2kaimeikoup}</td><td>（連携用）初年度２回目以降Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnjinendoikoup zrnjinendoikoup}</td><td>（連携用）次年度以降Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaimnkkykhyj zrnsaimnkkykhyj}</td><td>（連携用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknkkn zrnhknkkn}</td><td>（連携用）保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkkikn zrnphrkkikn}</td><td>（連携用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhihokensyaagev2 zrnhihokensyaagev2}</td><td>（連携用）被保険者年令Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyanen zrnkyksyanen}</td><td>（連携用）契約者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaifuyouriyuukbn zrnannaifuyouriyuukbn}</td><td>（連携用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsdpdkbn zrnsdpdkbn}</td><td>（連携用）Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnryouritukbn zrnryouritukbn}</td><td>（連携用）料率区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksyuannaikykkbn zrntksyuannaikykkbn}</td><td>（連携用）特殊案内契約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hhknnen zrndai2hhknnen}</td><td>（連携用）第２被保険者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruikigousedaikbn zrnhknsyuruikigousedaikbn}</td><td>（連携用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmenhukakbn zrnpmenhukakbn}</td><td>（連携用）Ｐ免付加区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhosyouikkatumnoshyouji zrnhosyouikkatumnoshyouji}</td><td>（連携用）保障一括見直表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1x2 zrnyobiv1x2}</td><td>（連携用）予備項目Ｖ１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihons zrnkihons}</td><td>（連携用）基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngoukeitenkans zrngoukeitenkans}</td><td>（連携用）合計転換Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhngknksaiteihosyukngk zrnhngknksaiteihosyukngk}</td><td>（連携用）変額年金最低保証金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnaatukaisosikicd zrnaatukaisosikicd}</td><td>（連携用）Ａ扱者組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatukaikojincd zrnaatukaikojincd}</td><td>（連携用）Ａ扱者個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyym zrnbsyym}</td><td>（連携用）募集年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnharaikomip zrnharaikomip}</td><td>（連携用）払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakup zrnsyukeiyakup}</td><td>（連携用）主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntokujyoup zrntokujyoup}</td><td>（連携用）特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnitibuitijibarais zrnitibuitijibarais}</td><td>（連携用）一部一時払Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnitibuitijibaraip zrnitibuitijibaraip}</td><td>（連携用）一部一時払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngoukeitenkanteikis zrngoukeitenkanteikis}</td><td>（連携用）合計転換定期Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyuunoukbn zrnsyuunoukbn}</td><td>（連携用）収納区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkykkumkhnsyukosuu zrntkykkumkhnsyukosuu}</td><td>（連携用）特約項目編集個数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsiteizukipwarimasihyouji zrnsiteizukipwarimasihyouji}</td><td>（連携用）指定月Ｐ割増表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpwarimasisiteim1 zrnpwarimasisiteim1}</td><td>（連携用）Ｐ割増指定月１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpwarimasisiteim2 zrnpwarimasisiteim2}</td><td>（連携用）Ｐ割増指定月２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiteimsykykpbairitu zrnsiteimsykykpbairitu}</td><td>（連携用）指定月主契約Ｐ倍率</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiteizukisyukeiyakup zrnsiteizukisyukeiyakup}</td><td>（連携用）指定月主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsiteizukiharaikomip zrnsiteizukiharaikomip}</td><td>（連携用）指定月払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsaisyuusiteimhrkp zrnsaisyuusiteimhrkp}</td><td>（連携用）最終指定月払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsaisyuusiteiym zrnsaisyuusiteiym}</td><td>（連携用）最終指定年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnanniskcd zrnanniskcd}</td><td>（連携用）案内先コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntumitateriritu zrntumitateriritu}</td><td>（連携用）積立利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsitihsyuriritu zrnsitihsyuriritu}</td><td>（連携用）最低保証利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnnkgnsritu zrnnkgnsritu}</td><td>（連携用）年金原資率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsinnyuukinkbn zrnsinnyuukinkbn}</td><td>（連携用）新入金区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndfnyuukinkbn zrndfnyuukinkbn}</td><td>（連携用）ＤＦ入金区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntorikuzusip zrntorikuzusip}</td><td>（連携用）取崩Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkbnkeiriyousegmentcd zrnkbnkeiriyousegmentcd}</td><td>（連携用）区分経理用セグメントコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykikykjkykym zrnsykikykjkykym}</td><td>（連携用）初回契約時契約年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndfkijyunkingaku zrndfkijyunkingaku}</td><td>（連携用）ＤＦ基準金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnstdssytikbn zrnstdssytikbn}</td><td>（連携用）外出集定区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsotodasimanagehyouji zrnsotodasimanagehyouji}</td><td>（連携用）外出満年令表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsotodasiphkbnmnoshyouji zrnsotodasiphkbnmnoshyouji}</td><td>（連携用）外出Ｐ不可分見直表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstdsstkjytkyuhyj zrnstdsstkjytkyuhyj}</td><td>（連携用）外出新特条適用表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkousinmanryouage zrnkousinmanryouage}</td><td>（連携用）更新満了年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknkuzusnzyrttekitkarihyj zrnknkuzusnzyrttekitkarihyj}</td><td>（連携用）健康増進乗率適用特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknkuzusnzyrt zrnknkuzusnzyrt}</td><td>（連携用）健康増進乗率</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkanjiknkuzusnzyrt zrntenkanjiknkuzusnzyrt}</td><td>（連携用）転換時健康増進乗率</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpwrbksidhitekiyouhyj zrnpwrbksidhitekiyouhyj}</td><td>（連携用）保険料割引制度非適用表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin1x2 zrnsuuriyouyobin1x2}</td><td>（連携用）数理用予備項目Ｎ１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzyrthntiyustatuskbn zrnzyrthntiyustatuskbn}</td><td>（連携用）乗率判定用ステータス区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv9 zrnyobiv9}</td><td>（連携用）予備項目Ｖ９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsotodasipmenkbn zrnsotodasipmenkbn}</td><td>（連携用）外出Ｐ免区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokubetuhosyoukikan zrntokubetuhosyoukikan}</td><td>（連携用）特別保障期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin7 zrnsuuriyouyobin7}</td><td>（連携用）数理用予備項目Ｎ７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphireilkeisanyoup zrnphireilkeisanyoup}</td><td>（連携用）Ｐ比例Ｌ計算用Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11 zrnyobin11}</td><td>（連携用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x2 zrnyobin11x2}</td><td>（連携用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x3 zrnyobin11x3}</td><td>（連携用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x4 zrnyobin11x4}</td><td>（連携用）予備項目Ｎ１１＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrncashlesshyj zrncashlesshyj}</td><td>（連携用）キャッシュレス表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykjiqpackhyj zrnkykjiqpackhyj}</td><td>（連携用）契約時Ｑパック表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkanminaosikbn zrntenkanminaosikbn}</td><td>（連携用）転換見直区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnentysihyj zrnhhknnentysihyj}</td><td>（連携用）被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hhknnentysihyj zrndai2hhknnentysihyj}</td><td>（連携用）第２被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyaagetyouseihyj zrnkyksyaagetyouseihyj}</td><td>（連携用）契約者年令調整表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykykhokenhoutekiyouhyj zrnsykykhokenhoutekiyouhyj}</td><td>（連携用）主契約保険法適用表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrimngtkykphrkkaisuukbn zrnhrimngtkykphrkkaisuukbn}</td><td>（連携用）払満後特約Ｐ払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjidoukousinhyouji zrnjidoukousinhyouji}</td><td>（連携用）自動更新表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin1 zrnsuuriyouyobin1}</td><td>（連携用）数理用予備項目Ｎ１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkjykbn zrntkjykbn}</td><td>（連携用）特条区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2tokujyoukbn zrndai2tokujyoukbn}</td><td>（連携用）第２特条区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnryoumasihyouten zrnryoumasihyouten}</td><td>（連携用）料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrndai2ryoumasihyouten zrndai2ryoumasihyouten}</td><td>（連携用）第２料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin2 zrnsuuriyouyobin2}</td><td>（連携用）数理用予備項目Ｎ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin10 zrnsuuriyouyobin10}</td><td>（連携用）数理用予備項目Ｎ１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin10x2 zrnsuuriyouyobin10x2}</td><td>（連携用）数理用予備項目Ｎ１０＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin10x3 zrnsuuriyouyobin10x3}</td><td>（連携用）数理用予備項目Ｎ１０＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin10x4 zrnsuuriyouyobin10x4}</td><td>（連携用）数理用予備項目Ｎ１０＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10x6 zrnyobiv10x6}</td><td>（連携用）予備項目Ｖ１０＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10x7 zrnyobiv10x7}</td><td>（連携用）予備項目Ｖ１０＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10x8 zrnyobiv10x8}</td><td>（連携用）予備項目Ｖ１０＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10x9 zrnyobiv10x9}</td><td>（連携用）予備項目Ｖ１０＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10x10 zrnyobiv10x10}</td><td>（連携用）予備項目Ｖ１０＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10x11 zrnyobiv10x11}</td><td>（連携用）予備項目Ｖ１０＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuukeitaikbn zrnbosyuukeitaikbn}</td><td>（連携用）募集形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrimngtkykphrkkirkbn zrnhrimngtkykphrkkirkbn}</td><td>（連携用）払満後特約Ｐ払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrimngtkykpryurtkbn zrnhrimngtkykpryurtkbn}</td><td>（連携用）払満後特約Ｐ料率区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakusyuruicdv3 zrnsyukeiyakusyuruicdv3}</td><td>（連携用）主契約種類コードＶ３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobin11x5 zrnyobin11x5}</td><td>（連携用）予備項目Ｎ１１＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x6 zrnyobin11x6}</td><td>（連携用）予備項目Ｎ１１＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x7 zrnyobin11x7}</td><td>（連携用）予備項目Ｎ１１＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x8 zrnyobin11x8}</td><td>（連携用）予備項目Ｎ１１＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x9 zrnyobin11x9}</td><td>（連携用）予備項目Ｎ１１＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnraysystemhyj zrnraysystemhyj}</td><td>（連携用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngaikakbn zrngaikakbn}</td><td>（連携用）外貨区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykjikawaserate zrnkykjikawaserate}</td><td>（連携用）契約時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkykjikawaseratetkyuymd zrnkykjikawaseratetkyuymd}</td><td>（連携用）契約時為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakujiyoteiriritu zrnkeiyakujiyoteiriritu}</td><td>（連携用）契約時予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnenkdtsbujsitihsyukngk zrnenkdtsbujsitihsyukngk}</td><td>（連携用）円貨建死亡時最低保証金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnyuukintuukakbn zrnnyuukintuukakbn}</td><td>（連携用）入金通貨区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuurendourate zrnsisuurendourate}</td><td>（連携用）指数連動部分割合</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuukbn zrnsisuukbn}</td><td>（連携用）指数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyknjikawaserate zrnnyknjikawaserate}</td><td>（連携用）入金時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnnyknjikawaseratetkyuymd zrnnyknjikawaseratetkyuymd}</td><td>（連携用）入金時為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsrdai1hknkkn zrnsrdai1hknkkn}</td><td>（連携用）数理用第１保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin10x5 zrnsuuriyouyobin10x5}</td><td>（連携用）数理用予備項目Ｎ１０＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuukasyukbn zrntuukasyukbn}</td><td>（連携用）通貨種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv9x2 zrnyobiv9x2}</td><td>（連携用）予備項目Ｖ９＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10x16 zrnyobiv10x16}</td><td>（連携用）予備項目Ｖ１０＿１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkgns zrnnkgns}</td><td>（連携用）年金原資</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsisuubbntounyuugk zrnsisuubbntounyuugk}</td><td>（連携用）指数部分投入金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsaisinyoteiriritu zrnsaisinyoteiriritu}</td><td>（連携用）最新予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyobin5 zrnyobin5}</td><td>（連携用）予備項目Ｎ５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyobin11x10 zrnyobin11x10}</td><td>（連携用）予備項目Ｎ１１＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkiharaikomip zrnkiharaikomip}</td><td>（連携用）既払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntumitatekin zrntumitatekin}</td><td>（連携用）積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnzennoujiikkatubaraijytgk zrnzennoujiikkatubaraijytgk}</td><td>（連携用）前納時一括払充当額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatenkgns zrngaikadatenkgns}</td><td>（連携用）外貨建年金原資</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatesyukeiyakup zrngaikadatesyukeiyakup}</td><td>（連携用）外貨建主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv1x3 zrnyobiv1x3}</td><td>（連携用）予備項目Ｖ１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160 zrntokuyakukoumokuv160}</td><td>（連携用）特約項目Ｖ１６０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x2 zrntokuyakukoumokuv160x2}</td><td>（連携用）特約項目Ｖ１６０＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x3 zrntokuyakukoumokuv160x3}</td><td>（連携用）特約項目Ｖ１６０＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x4 zrntokuyakukoumokuv160x4}</td><td>（連携用）特約項目Ｖ１６０＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x5 zrntokuyakukoumokuv160x5}</td><td>（連携用）特約項目Ｖ１６０＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x6 zrntokuyakukoumokuv160x6}</td><td>（連携用）特約項目Ｖ１６０＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x7 zrntokuyakukoumokuv160x7}</td><td>（連携用）特約項目Ｖ１６０＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x8 zrntokuyakukoumokuv160x8}</td><td>（連携用）特約項目Ｖ１６０＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x9 zrntokuyakukoumokuv160x9}</td><td>（連携用）特約項目Ｖ１６０＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x10 zrntokuyakukoumokuv160x10}</td><td>（連携用）特約項目Ｖ１６０＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x11 zrntokuyakukoumokuv160x11}</td><td>（連携用）特約項目Ｖ１６０＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x12 zrntokuyakukoumokuv160x12}</td><td>（連携用）特約項目Ｖ１６０＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x13 zrntokuyakukoumokuv160x13}</td><td>（連携用）特約項目Ｖ１６０＿１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x14 zrntokuyakukoumokuv160x14}</td><td>（連携用）特約項目Ｖ１６０＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x15 zrntokuyakukoumokuv160x15}</td><td>（連携用）特約項目Ｖ１６０＿１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x16 zrntokuyakukoumokuv160x16}</td><td>（連携用）特約項目Ｖ１６０＿１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x17 zrntokuyakukoumokuv160x17}</td><td>（連携用）特約項目Ｖ１６０＿１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x18 zrntokuyakukoumokuv160x18}</td><td>（連携用）特約項目Ｖ１６０＿１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x19 zrntokuyakukoumokuv160x19}</td><td>（連携用）特約項目Ｖ１６０＿１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x20 zrntokuyakukoumokuv160x20}</td><td>（連携用）特約項目Ｖ１６０＿２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x21 zrntokuyakukoumokuv160x21}</td><td>（連携用）特約項目Ｖ１６０＿２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x22 zrntokuyakukoumokuv160x22}</td><td>（連携用）特約項目Ｖ１６０＿２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x23 zrntokuyakukoumokuv160x23}</td><td>（連携用）特約項目Ｖ１６０＿２３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x24 zrntokuyakukoumokuv160x24}</td><td>（連携用）特約項目Ｖ１６０＿２４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x25 zrntokuyakukoumokuv160x25}</td><td>（連携用）特約項目Ｖ１６０＿２５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x26 zrntokuyakukoumokuv160x26}</td><td>（連携用）特約項目Ｖ１６０＿２６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x27 zrntokuyakukoumokuv160x27}</td><td>（連携用）特約項目Ｖ１６０＿２７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x28 zrntokuyakukoumokuv160x28}</td><td>（連携用）特約項目Ｖ１６０＿２８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x29 zrntokuyakukoumokuv160x29}</td><td>（連携用）特約項目Ｖ１６０＿２９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x30 zrntokuyakukoumokuv160x30}</td><td>（連携用）特約項目Ｖ１６０＿３０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x31 zrntokuyakukoumokuv160x31}</td><td>（連携用）特約項目Ｖ１６０＿３１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x32 zrntokuyakukoumokuv160x32}</td><td>（連携用）特約項目Ｖ１６０＿３２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x33 zrntokuyakukoumokuv160x33}</td><td>（連携用）特約項目Ｖ１６０＿３３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x34 zrntokuyakukoumokuv160x34}</td><td>（連携用）特約項目Ｖ１６０＿３４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x35 zrntokuyakukoumokuv160x35}</td><td>（連携用）特約項目Ｖ１６０＿３５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x36 zrntokuyakukoumokuv160x36}</td><td>（連携用）特約項目Ｖ１６０＿３６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x37 zrntokuyakukoumokuv160x37}</td><td>（連携用）特約項目Ｖ１６０＿３７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x38 zrntokuyakukoumokuv160x38}</td><td>（連携用）特約項目Ｖ１６０＿３８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x39 zrntokuyakukoumokuv160x39}</td><td>（連携用）特約項目Ｖ１６０＿３９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x40 zrntokuyakukoumokuv160x40}</td><td>（連携用）特約項目Ｖ１６０＿４０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x41 zrntokuyakukoumokuv160x41}</td><td>（連携用）特約項目Ｖ１６０＿４１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x42 zrntokuyakukoumokuv160x42}</td><td>（連携用）特約項目Ｖ１６０＿４２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x43 zrntokuyakukoumokuv160x43}</td><td>（連携用）特約項目Ｖ１６０＿４３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x44 zrntokuyakukoumokuv160x44}</td><td>（連携用）特約項目Ｖ１６０＿４４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x45 zrntokuyakukoumokuv160x45}</td><td>（連携用）特約項目Ｖ１６０＿４５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x46 zrntokuyakukoumokuv160x46}</td><td>（連携用）特約項目Ｖ１６０＿４６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x47 zrntokuyakukoumokuv160x47}</td><td>（連携用）特約項目Ｖ１６０＿４７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x48 zrntokuyakukoumokuv160x48}</td><td>（連携用）特約項目Ｖ１６０＿４８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x49 zrntokuyakukoumokuv160x49}</td><td>（連携用）特約項目Ｖ１６０＿４９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukoumokuv160x50 zrntokuyakukoumokuv160x50}</td><td>（連携用）特約項目Ｖ１６０＿５０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SkeisynyptoukeiksnRn
 * @see     PKZT_SkeisynyptoukeiksnRn
 * @see     QZT_SkeisynyptoukeiksnRn
 * @see     GenQZT_SkeisynyptoukeiksnRn
 */
@MappedSuperclass
@Table(name=GenZT_SkeisynyptoukeiksnRn.TABLE_NAME)
@IdClass(value=PKZT_SkeisynyptoukeiksnRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_SkeisynyptoukeiksnRn extends AbstractExDBEntityForZDB<ZT_SkeisynyptoukeiksnRn, PKZT_SkeisynyptoukeiksnRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SkeisynyptoukeiksnRn";
    public static final String ZRNSEQUENCENO            = "zrnsequenceno";
    public static final String ZRNYUUKOURECORDLENGTH    = "zrnyuukourecordlength";
    public static final String ZRNRDWAREA               = "zrnrdwarea";
    public static final String ZRNDATAKANRINO           = "zrndatakanrino";
    public static final String ZRNSYORICD               = "zrnsyoricd";
    public static final String ZRNRENDOUKBN             = "zrnrendoukbn";
    public static final String ZRNYOBIV1                = "zrnyobiv1";
    public static final String ZRNSYUUNOUKEIROKBN       = "zrnsyuunoukeirokbn";
    public static final String ZRNSUITOUSISYA           = "zrnsuitousisya";
    public static final String ZRNSYUUKINYM             = "zrnsyuukinym";
    public static final String ZRNJYUUTOUYM             = "zrnjyuutouym";
    public static final String ZRNJYUUTOUKAISUU         = "zrnjyuutoukaisuu";
    public static final String ZRNZENNOUKBN             = "zrnzennoukbn";
    public static final String ZRNSETKYKKBN             = "zrnsetkykkbn";
    public static final String ZRNBANKIKKATUHYOUJI      = "zrnbankikkatuhyouji";
    public static final String ZRNRECORDKBN             = "zrnrecordkbn";
    public static final String ZRNTNKNMNOSJTIKBBNJYUTUKBN = "zrntnknmnosjtikbbnjyutukbn";
    public static final String ZRNSETRENSEIMRTIKATAKBN  = "zrnsetrenseimrtikatakbn";
    public static final String ZRNHAITOUKBN             = "zrnhaitoukbn";
    public static final String ZRNSYUKEIYAKUPWARIBIKIKBNX2 = "zrnsyukeiyakupwaribikikbnx2";
    public static final String ZRNSYKYKTNKNYUGUKBNX2    = "zrnsykyktnknyugukbnx2";
    public static final String ZRNSETKAIGOMARUTEIKATAKBN = "zrnsetkaigomaruteikatakbn";
    public static final String ZRNDENYMD                = "zrndenymd";
    public static final String ZRNSYONENDOSYOKAIP       = "zrnsyonendosyokaip";
    public static final String ZRNSYONENDO2KAIMEIKOUP   = "zrnsyonendo2kaimeikoup";
    public static final String ZRNJINENDOIKOUP          = "zrnjinendoikoup";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNSAIMNKKYKHYJ          = "zrnsaimnkkykhyj";
    public static final String ZRNHKNKKN                = "zrnhknkkn";
    public static final String ZRNPHRKKIKN              = "zrnphrkkikn";
    public static final String ZRNHIHOKENSYAAGEV2       = "zrnhihokensyaagev2";
    public static final String ZRNKYKSYANEN             = "zrnkyksyanen";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNANNAIFUYOURIYUUKBN    = "zrnannaifuyouriyuukbn";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNSDPDKBN               = "zrnsdpdkbn";
    public static final String ZRNRYOURITUKBN           = "zrnryouritukbn";
    public static final String ZRNTKSYUANNAIKYKKBN      = "zrntksyuannaikykkbn";
    public static final String ZRNDAI2HHKNNEN           = "zrndai2hhknnen";
    public static final String ZRNHKNSYURUIKIGOUSEDAIKBN = "zrnhknsyuruikigousedaikbn";
    public static final String ZRNPMENHUKAKBN           = "zrnpmenhukakbn";
    public static final String ZRNHOSYOUIKKATUMNOSHYOUJI = "zrnhosyouikkatumnoshyouji";
    public static final String ZRNYOBIV1X2              = "zrnyobiv1x2";
    public static final String ZRNKIHONS                = "zrnkihons";
    public static final String ZRNGOUKEITENKANS         = "zrngoukeitenkans";
    public static final String ZRNHNGKNKSAITEIHOSYUKNGK = "zrnhngknksaiteihosyukngk";
    public static final String ZRNAATUKAISOSIKICD       = "zrnaatukaisosikicd";
    public static final String ZRNAATUKAIKOJINCD        = "zrnaatukaikojincd";
    public static final String ZRNBSYYM                 = "zrnbsyym";
    public static final String ZRNHARAIKOMIP            = "zrnharaikomip";
    public static final String ZRNSYUKEIYAKUP           = "zrnsyukeiyakup";
    public static final String ZRNTOKUJYOUP             = "zrntokujyoup";
    public static final String ZRNITIBUITIJIBARAIS      = "zrnitibuitijibarais";
    public static final String ZRNITIBUITIJIBARAIP      = "zrnitibuitijibaraip";
    public static final String ZRNGOUKEITENKANTEIKIS    = "zrngoukeitenkanteikis";
    public static final String ZRNSYUUNOUKBN            = "zrnsyuunoukbn";
    public static final String ZRNTKYKKUMKHNSYUKOSUU    = "zrntkykkumkhnsyukosuu";
    public static final String ZRNSITEIZUKIPWARIMASIHYOUJI = "zrnsiteizukipwarimasihyouji";
    public static final String ZRNPWARIMASISITEIM1      = "zrnpwarimasisiteim1";
    public static final String ZRNPWARIMASISITEIM2      = "zrnpwarimasisiteim2";
    public static final String ZRNSITEIMSYKYKPBAIRITU   = "zrnsiteimsykykpbairitu";
    public static final String ZRNSITEIZUKISYUKEIYAKUP  = "zrnsiteizukisyukeiyakup";
    public static final String ZRNSITEIZUKIHARAIKOMIP   = "zrnsiteizukiharaikomip";
    public static final String ZRNSAISYUUSITEIMHRKP     = "zrnsaisyuusiteimhrkp";
    public static final String ZRNSAISYUUSITEIYM        = "zrnsaisyuusiteiym";
    public static final String ZRNANNISKCD              = "zrnanniskcd";
    public static final String ZRNTUMITATERIRITU        = "zrntumitateriritu";
    public static final String ZRNSITIHSYURIRITU        = "zrnsitihsyuriritu";
    public static final String ZRNNKGNSRITU             = "zrnnkgnsritu";
    public static final String ZRNSINNYUUKINKBN         = "zrnsinnyuukinkbn";
    public static final String ZRNDFNYUUKINKBN          = "zrndfnyuukinkbn";
    public static final String ZRNTORIKUZUSIP           = "zrntorikuzusip";
    public static final String ZRNKBNKEIRIYOUSEGMENTCD  = "zrnkbnkeiriyousegmentcd";
    public static final String ZRNSYKIKYKJKYKYM         = "zrnsykikykjkykym";
    public static final String ZRNDFKIJYUNKINGAKU       = "zrndfkijyunkingaku";
    public static final String ZRNSTDSSYTIKBN           = "zrnstdssytikbn";
    public static final String ZRNSOTODASIMANAGEHYOUJI  = "zrnsotodasimanagehyouji";
    public static final String ZRNSOTODASIPHKBNMNOSHYOUJI = "zrnsotodasiphkbnmnoshyouji";
    public static final String ZRNSTDSSTKJYTKYUHYJ      = "zrnstdsstkjytkyuhyj";
    public static final String ZRNKOUSINMANRYOUAGE      = "zrnkousinmanryouage";
    public static final String ZRNKNKUZUSNZYRTTEKITKARIHYJ = "zrnknkuzusnzyrttekitkarihyj";
    public static final String ZRNKNKUZUSNZYRT          = "zrnknkuzusnzyrt";
    public static final String ZRNTENKANJIKNKUZUSNZYRT  = "zrntenkanjiknkuzusnzyrt";
    public static final String ZRNPWRBKSIDHITEKIYOUHYJ  = "zrnpwrbksidhitekiyouhyj";
    public static final String ZRNSUURIYOUYOBIN1X2      = "zrnsuuriyouyobin1x2";
    public static final String ZRNZYRTHNTIYUSTATUSKBN   = "zrnzyrthntiyustatuskbn";
    public static final String ZRNYOBIV9                = "zrnyobiv9";
    public static final String ZRNSOTODASIPMENKBN       = "zrnsotodasipmenkbn";
    public static final String ZRNTOKUBETUHOSYOUKIKAN   = "zrntokubetuhosyoukikan";
    public static final String ZRNSUURIYOUYOBIN7        = "zrnsuuriyouyobin7";
    public static final String ZRNPHIREILKEISANYOUP     = "zrnphireilkeisanyoup";
    public static final String ZRNYOBIN11               = "zrnyobin11";
    public static final String ZRNYOBIN11X2             = "zrnyobin11x2";
    public static final String ZRNYOBIN11X3             = "zrnyobin11x3";
    public static final String ZRNYOBIN11X4             = "zrnyobin11x4";
    public static final String ZRNCASHLESSHYJ           = "zrncashlesshyj";
    public static final String ZRNKYKJIQPACKHYJ         = "zrnkykjiqpackhyj";
    public static final String ZRNTENKANMINAOSIKBN      = "zrntenkanminaosikbn";
    public static final String ZRNHHKNNENTYSIHYJ        = "zrnhhknnentysihyj";
    public static final String ZRNDAI2HHKNNENTYSIHYJ    = "zrndai2hhknnentysihyj";
    public static final String ZRNKYKSYAAGETYOUSEIHYJ   = "zrnkyksyaagetyouseihyj";
    public static final String ZRNSYKYKHOKENHOUTEKIYOUHYJ = "zrnsykykhokenhoutekiyouhyj";
    public static final String ZRNHRIMNGTKYKPHRKKAISUUKBN = "zrnhrimngtkykphrkkaisuukbn";
    public static final String ZRNJIDOUKOUSINHYOUJI     = "zrnjidoukousinhyouji";
    public static final String ZRNSUURIYOUYOBIN1        = "zrnsuuriyouyobin1";
    public static final String ZRNTKJYKBN               = "zrntkjykbn";
    public static final String ZRNDAI2TOKUJYOUKBN       = "zrndai2tokujyoukbn";
    public static final String ZRNRYOUMASIHYOUTEN       = "zrnryoumasihyouten";
    public static final String ZRNDAI2RYOUMASIHYOUTEN   = "zrndai2ryoumasihyouten";
    public static final String ZRNSUURIYOUYOBIN2        = "zrnsuuriyouyobin2";
    public static final String ZRNSUURIYOUYOBIN10       = "zrnsuuriyouyobin10";
    public static final String ZRNSUURIYOUYOBIN10X2     = "zrnsuuriyouyobin10x2";
    public static final String ZRNSUURIYOUYOBIN10X3     = "zrnsuuriyouyobin10x3";
    public static final String ZRNSUURIYOUYOBIN10X4     = "zrnsuuriyouyobin10x4";
    public static final String ZRNYOBIV10X6             = "zrnyobiv10x6";
    public static final String ZRNYOBIV10X7             = "zrnyobiv10x7";
    public static final String ZRNYOBIV10X8             = "zrnyobiv10x8";
    public static final String ZRNYOBIV10X9             = "zrnyobiv10x9";
    public static final String ZRNYOBIV10X10            = "zrnyobiv10x10";
    public static final String ZRNYOBIV10X11            = "zrnyobiv10x11";
    public static final String ZRNBOSYUUKEITAIKBN       = "zrnbosyuukeitaikbn";
    public static final String ZRNHRIMNGTKYKPHRKKIRKBN  = "zrnhrimngtkykphrkkirkbn";
    public static final String ZRNHRIMNGTKYKPRYURTKBN   = "zrnhrimngtkykpryurtkbn";
    public static final String ZRNSYUKEIYAKUSYURUICDV3  = "zrnsyukeiyakusyuruicdv3";
    public static final String ZRNYOBIN11X5             = "zrnyobin11x5";
    public static final String ZRNYOBIN11X6             = "zrnyobin11x6";
    public static final String ZRNYOBIN11X7             = "zrnyobin11x7";
    public static final String ZRNYOBIN11X8             = "zrnyobin11x8";
    public static final String ZRNYOBIN11X9             = "zrnyobin11x9";
    public static final String ZRNRAYSYSTEMHYJ          = "zrnraysystemhyj";
    public static final String ZRNGAIKAKBN              = "zrngaikakbn";
    public static final String ZRNKYKJIKAWASERATE       = "zrnkykjikawaserate";
    public static final String ZRNKYKJIKAWASERATETKYUYMD = "zrnkykjikawaseratetkyuymd";
    public static final String ZRNKEIYAKUJIYOTEIRIRITU  = "zrnkeiyakujiyoteiriritu";
    public static final String ZRNENKDTSBUJSITIHSYUKNGK = "zrnenkdtsbujsitihsyukngk";
    public static final String ZRNNYUUKINTUUKAKBN       = "zrnnyuukintuukakbn";
    public static final String ZRNSISUURENDOURATE       = "zrnsisuurendourate";
    public static final String ZRNSISUUKBN              = "zrnsisuukbn";
    public static final String ZRNNYKNJIKAWASERATE      = "zrnnyknjikawaserate";
    public static final String ZRNNYKNJIKAWASERATETKYUYMD = "zrnnyknjikawaseratetkyuymd";
    public static final String ZRNSRDAI1HKNKKN          = "zrnsrdai1hknkkn";
    public static final String ZRNSUURIYOUYOBIN10X5     = "zrnsuuriyouyobin10x5";
    public static final String ZRNTUUKASYUKBN           = "zrntuukasyukbn";
    public static final String ZRNYOBIV9X2              = "zrnyobiv9x2";
    public static final String ZRNYOBIV10X16            = "zrnyobiv10x16";
    public static final String ZRNNKGNS                 = "zrnnkgns";
    public static final String ZRNSISUUBBNTOUNYUUGK     = "zrnsisuubbntounyuugk";
    public static final String ZRNSAISINYOTEIRIRITU     = "zrnsaisinyoteiriritu";
    public static final String ZRNYOBIN5                = "zrnyobin5";
    public static final String ZRNYOBIN11X10            = "zrnyobin11x10";
    public static final String ZRNKIHARAIKOMIP          = "zrnkiharaikomip";
    public static final String ZRNTUMITATEKIN           = "zrntumitatekin";
    public static final String ZRNZENNOUJIIKKATUBARAIJYTGK = "zrnzennoujiikkatubaraijytgk";
    public static final String ZRNGAIKADATENKGNS        = "zrngaikadatenkgns";
    public static final String ZRNGAIKADATESYUKEIYAKUP  = "zrngaikadatesyukeiyakup";
    public static final String ZRNYOBIV1X3              = "zrnyobiv1x3";
    public static final String ZRNTOKUYAKUKOUMOKUV160   = "zrntokuyakukoumokuv160";
    public static final String ZRNTOKUYAKUKOUMOKUV160X2 = "zrntokuyakukoumokuv160x2";
    public static final String ZRNTOKUYAKUKOUMOKUV160X3 = "zrntokuyakukoumokuv160x3";
    public static final String ZRNTOKUYAKUKOUMOKUV160X4 = "zrntokuyakukoumokuv160x4";
    public static final String ZRNTOKUYAKUKOUMOKUV160X5 = "zrntokuyakukoumokuv160x5";
    public static final String ZRNTOKUYAKUKOUMOKUV160X6 = "zrntokuyakukoumokuv160x6";
    public static final String ZRNTOKUYAKUKOUMOKUV160X7 = "zrntokuyakukoumokuv160x7";
    public static final String ZRNTOKUYAKUKOUMOKUV160X8 = "zrntokuyakukoumokuv160x8";
    public static final String ZRNTOKUYAKUKOUMOKUV160X9 = "zrntokuyakukoumokuv160x9";
    public static final String ZRNTOKUYAKUKOUMOKUV160X10 = "zrntokuyakukoumokuv160x10";
    public static final String ZRNTOKUYAKUKOUMOKUV160X11 = "zrntokuyakukoumokuv160x11";
    public static final String ZRNTOKUYAKUKOUMOKUV160X12 = "zrntokuyakukoumokuv160x12";
    public static final String ZRNTOKUYAKUKOUMOKUV160X13 = "zrntokuyakukoumokuv160x13";
    public static final String ZRNTOKUYAKUKOUMOKUV160X14 = "zrntokuyakukoumokuv160x14";
    public static final String ZRNTOKUYAKUKOUMOKUV160X15 = "zrntokuyakukoumokuv160x15";
    public static final String ZRNTOKUYAKUKOUMOKUV160X16 = "zrntokuyakukoumokuv160x16";
    public static final String ZRNTOKUYAKUKOUMOKUV160X17 = "zrntokuyakukoumokuv160x17";
    public static final String ZRNTOKUYAKUKOUMOKUV160X18 = "zrntokuyakukoumokuv160x18";
    public static final String ZRNTOKUYAKUKOUMOKUV160X19 = "zrntokuyakukoumokuv160x19";
    public static final String ZRNTOKUYAKUKOUMOKUV160X20 = "zrntokuyakukoumokuv160x20";
    public static final String ZRNTOKUYAKUKOUMOKUV160X21 = "zrntokuyakukoumokuv160x21";
    public static final String ZRNTOKUYAKUKOUMOKUV160X22 = "zrntokuyakukoumokuv160x22";
    public static final String ZRNTOKUYAKUKOUMOKUV160X23 = "zrntokuyakukoumokuv160x23";
    public static final String ZRNTOKUYAKUKOUMOKUV160X24 = "zrntokuyakukoumokuv160x24";
    public static final String ZRNTOKUYAKUKOUMOKUV160X25 = "zrntokuyakukoumokuv160x25";
    public static final String ZRNTOKUYAKUKOUMOKUV160X26 = "zrntokuyakukoumokuv160x26";
    public static final String ZRNTOKUYAKUKOUMOKUV160X27 = "zrntokuyakukoumokuv160x27";
    public static final String ZRNTOKUYAKUKOUMOKUV160X28 = "zrntokuyakukoumokuv160x28";
    public static final String ZRNTOKUYAKUKOUMOKUV160X29 = "zrntokuyakukoumokuv160x29";
    public static final String ZRNTOKUYAKUKOUMOKUV160X30 = "zrntokuyakukoumokuv160x30";
    public static final String ZRNTOKUYAKUKOUMOKUV160X31 = "zrntokuyakukoumokuv160x31";
    public static final String ZRNTOKUYAKUKOUMOKUV160X32 = "zrntokuyakukoumokuv160x32";
    public static final String ZRNTOKUYAKUKOUMOKUV160X33 = "zrntokuyakukoumokuv160x33";
    public static final String ZRNTOKUYAKUKOUMOKUV160X34 = "zrntokuyakukoumokuv160x34";
    public static final String ZRNTOKUYAKUKOUMOKUV160X35 = "zrntokuyakukoumokuv160x35";
    public static final String ZRNTOKUYAKUKOUMOKUV160X36 = "zrntokuyakukoumokuv160x36";
    public static final String ZRNTOKUYAKUKOUMOKUV160X37 = "zrntokuyakukoumokuv160x37";
    public static final String ZRNTOKUYAKUKOUMOKUV160X38 = "zrntokuyakukoumokuv160x38";
    public static final String ZRNTOKUYAKUKOUMOKUV160X39 = "zrntokuyakukoumokuv160x39";
    public static final String ZRNTOKUYAKUKOUMOKUV160X40 = "zrntokuyakukoumokuv160x40";
    public static final String ZRNTOKUYAKUKOUMOKUV160X41 = "zrntokuyakukoumokuv160x41";
    public static final String ZRNTOKUYAKUKOUMOKUV160X42 = "zrntokuyakukoumokuv160x42";
    public static final String ZRNTOKUYAKUKOUMOKUV160X43 = "zrntokuyakukoumokuv160x43";
    public static final String ZRNTOKUYAKUKOUMOKUV160X44 = "zrntokuyakukoumokuv160x44";
    public static final String ZRNTOKUYAKUKOUMOKUV160X45 = "zrntokuyakukoumokuv160x45";
    public static final String ZRNTOKUYAKUKOUMOKUV160X46 = "zrntokuyakukoumokuv160x46";
    public static final String ZRNTOKUYAKUKOUMOKUV160X47 = "zrntokuyakukoumokuv160x47";
    public static final String ZRNTOKUYAKUKOUMOKUV160X48 = "zrntokuyakukoumokuv160x48";
    public static final String ZRNTOKUYAKUKOUMOKUV160X49 = "zrntokuyakukoumokuv160x49";
    public static final String ZRNTOKUYAKUKOUMOKUV160X50 = "zrntokuyakukoumokuv160x50";

    private final PKZT_SkeisynyptoukeiksnRn primaryKey;

    public GenZT_SkeisynyptoukeiksnRn() {
        primaryKey = new PKZT_SkeisynyptoukeiksnRn();
    }

    public GenZT_SkeisynyptoukeiksnRn(Integer pZrnsequenceno) {
        primaryKey = new PKZT_SkeisynyptoukeiksnRn(pZrnsequenceno);
    }

    @Transient
    @Override
    public PKZT_SkeisynyptoukeiksnRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SkeisynyptoukeiksnRn> getMetaClass() {
        return QZT_SkeisynyptoukeiksnRn.class;
    }

    @Id
    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSEQUENCENO)
    public Integer getZrnsequenceno() {
        return getPrimaryKey().getZrnsequenceno();
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        getPrimaryKey().setZrnsequenceno(pZrnsequenceno);
    }

    private Integer zrnyuukourecordlength;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNYUUKOURECORDLENGTH)
    public Integer getZrnyuukourecordlength() {
        return zrnyuukourecordlength;
    }

    public void setZrnyuukourecordlength(Integer pZrnyuukourecordlength) {
        zrnyuukourecordlength = pZrnyuukourecordlength;
    }

    private String zrnrdwarea;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNRDWAREA)
    public String getZrnrdwarea() {
        return zrnrdwarea;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnrdwarea(String pZrnrdwarea) {
        zrnrdwarea = pZrnrdwarea;
    }

    private String zrndatakanrino;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNDATAKANRINO)
    public String getZrndatakanrino() {
        return zrndatakanrino;
    }

    public void setZrndatakanrino(String pZrndatakanrino) {
        zrndatakanrino = pZrndatakanrino;
    }

    private String zrnsyoricd;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSYORICD)
    public String getZrnsyoricd() {
        return zrnsyoricd;
    }

    public void setZrnsyoricd(String pZrnsyoricd) {
        zrnsyoricd = pZrnsyoricd;
    }

    private String zrnrendoukbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNRENDOUKBN)
    public String getZrnrendoukbn() {
        return zrnrendoukbn;
    }

    public void setZrnrendoukbn(String pZrnrendoukbn) {
        zrnrendoukbn = pZrnrendoukbn;
    }

    private String zrnyobiv1;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNYOBIV1)
    public String getZrnyobiv1() {
        return zrnyobiv1;
    }

    public void setZrnyobiv1(String pZrnyobiv1) {
        zrnyobiv1 = pZrnyobiv1;
    }

    private String zrnsyuunoukeirokbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSYUUNOUKEIROKBN)
    public String getZrnsyuunoukeirokbn() {
        return zrnsyuunoukeirokbn;
    }

    public void setZrnsyuunoukeirokbn(String pZrnsyuunoukeirokbn) {
        zrnsyuunoukeirokbn = pZrnsyuunoukeirokbn;
    }

    private String zrnsuitousisya;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSUITOUSISYA)
    public String getZrnsuitousisya() {
        return zrnsuitousisya;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnsuitousisya(String pZrnsuitousisya) {
        zrnsuitousisya = pZrnsuitousisya;
    }

    private String zrnsyuukinym;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSYUUKINYM)
    public String getZrnsyuukinym() {
        return zrnsyuukinym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnsyuukinym(String pZrnsyuukinym) {
        zrnsyuukinym = pZrnsyuukinym;
    }

    private String zrnjyuutouym;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNJYUUTOUYM)
    public String getZrnjyuutouym() {
        return zrnjyuutouym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnjyuutouym(String pZrnjyuutouym) {
        zrnjyuutouym = pZrnjyuutouym;
    }

    private String zrnjyuutoukaisuu;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNJYUUTOUKAISUU)
    public String getZrnjyuutoukaisuu() {
        return zrnjyuutoukaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnjyuutoukaisuu(String pZrnjyuutoukaisuu) {
        zrnjyuutoukaisuu = pZrnjyuutoukaisuu;
    }

    private String zrnzennoukbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNZENNOUKBN)
    public String getZrnzennoukbn() {
        return zrnzennoukbn;
    }

    public void setZrnzennoukbn(String pZrnzennoukbn) {
        zrnzennoukbn = pZrnzennoukbn;
    }

    private String zrnsetkykkbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSETKYKKBN)
    public String getZrnsetkykkbn() {
        return zrnsetkykkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsetkykkbn(String pZrnsetkykkbn) {
        zrnsetkykkbn = pZrnsetkykkbn;
    }

    private String zrnbankikkatuhyouji;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNBANKIKKATUHYOUJI)
    public String getZrnbankikkatuhyouji() {
        return zrnbankikkatuhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnbankikkatuhyouji(String pZrnbankikkatuhyouji) {
        zrnbankikkatuhyouji = pZrnbankikkatuhyouji;
    }

    private String zrnrecordkbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNRECORDKBN)
    public String getZrnrecordkbn() {
        return zrnrecordkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnrecordkbn(String pZrnrecordkbn) {
        zrnrecordkbn = pZrnrecordkbn;
    }

    private String zrntnknmnosjtikbbnjyutukbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTNKNMNOSJTIKBBNJYUTUKBN)
    public String getZrntnknmnosjtikbbnjyutukbn() {
        return zrntnknmnosjtikbbnjyutukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntnknmnosjtikbbnjyutukbn(String pZrntnknmnosjtikbbnjyutukbn) {
        zrntnknmnosjtikbbnjyutukbn = pZrntnknmnosjtikbbnjyutukbn;
    }

    private String zrnsetrenseimrtikatakbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSETRENSEIMRTIKATAKBN)
    public String getZrnsetrenseimrtikatakbn() {
        return zrnsetrenseimrtikatakbn;
    }

    public void setZrnsetrenseimrtikatakbn(String pZrnsetrenseimrtikatakbn) {
        zrnsetrenseimrtikatakbn = pZrnsetrenseimrtikatakbn;
    }

    private String zrnhaitoukbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNHAITOUKBN)
    public String getZrnhaitoukbn() {
        return zrnhaitoukbn;
    }

    public void setZrnhaitoukbn(String pZrnhaitoukbn) {
        zrnhaitoukbn = pZrnhaitoukbn;
    }

    private String zrnsyukeiyakupwaribikikbnx2;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSYUKEIYAKUPWARIBIKIKBNX2)
    public String getZrnsyukeiyakupwaribikikbnx2() {
        return zrnsyukeiyakupwaribikikbnx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyukeiyakupwaribikikbnx2(String pZrnsyukeiyakupwaribikikbnx2) {
        zrnsyukeiyakupwaribikikbnx2 = pZrnsyukeiyakupwaribikikbnx2;
    }

    private String zrnsykyktnknyugukbnx2;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSYKYKTNKNYUGUKBNX2)
    public String getZrnsykyktnknyugukbnx2() {
        return zrnsykyktnknyugukbnx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsykyktnknyugukbnx2(String pZrnsykyktnknyugukbnx2) {
        zrnsykyktnknyugukbnx2 = pZrnsykyktnknyugukbnx2;
    }

    private String zrnsetkaigomaruteikatakbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSETKAIGOMARUTEIKATAKBN)
    public String getZrnsetkaigomaruteikatakbn() {
        return zrnsetkaigomaruteikatakbn;
    }

    public void setZrnsetkaigomaruteikatakbn(String pZrnsetkaigomaruteikatakbn) {
        zrnsetkaigomaruteikatakbn = pZrnsetkaigomaruteikatakbn;
    }

    private String zrndenymd;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNDENYMD)
    public String getZrndenymd() {
        return zrndenymd;
    }

    public void setZrndenymd(String pZrndenymd) {
        zrndenymd = pZrndenymd;
    }

    private Long zrnsyonendosyokaip;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSYONENDOSYOKAIP)
    public Long getZrnsyonendosyokaip() {
        return zrnsyonendosyokaip;
    }

    public void setZrnsyonendosyokaip(Long pZrnsyonendosyokaip) {
        zrnsyonendosyokaip = pZrnsyonendosyokaip;
    }

    private Long zrnsyonendo2kaimeikoup;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSYONENDO2KAIMEIKOUP)
    public Long getZrnsyonendo2kaimeikoup() {
        return zrnsyonendo2kaimeikoup;
    }

    public void setZrnsyonendo2kaimeikoup(Long pZrnsyonendo2kaimeikoup) {
        zrnsyonendo2kaimeikoup = pZrnsyonendo2kaimeikoup;
    }

    private Long zrnjinendoikoup;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNJINENDOIKOUP)
    public Long getZrnjinendoikoup() {
        return zrnjinendoikoup;
    }

    public void setZrnjinendoikoup(Long pZrnjinendoikoup) {
        zrnjinendoikoup = pZrnjinendoikoup;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnsaimnkkykhyj;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSAIMNKKYKHYJ)
    public String getZrnsaimnkkykhyj() {
        return zrnsaimnkkykhyj;
    }

    public void setZrnsaimnkkykhyj(String pZrnsaimnkkykhyj) {
        zrnsaimnkkykhyj = pZrnsaimnkkykhyj;
    }

    private String zrnhknkkn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNHKNKKN)
    public String getZrnhknkkn() {
        return zrnhknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhknkkn(String pZrnhknkkn) {
        zrnhknkkn = pZrnhknkkn;
    }

    private String zrnphrkkikn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNPHRKKIKN)
    public String getZrnphrkkikn() {
        return zrnphrkkikn;
    }

    public void setZrnphrkkikn(String pZrnphrkkikn) {
        zrnphrkkikn = pZrnphrkkikn;
    }

    private String zrnhihokensyaagev2;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNHIHOKENSYAAGEV2)
    public String getZrnhihokensyaagev2() {
        return zrnhihokensyaagev2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhihokensyaagev2(String pZrnhihokensyaagev2) {
        zrnhihokensyaagev2 = pZrnhihokensyaagev2;
    }

    private String zrnkyksyanen;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNKYKSYANEN)
    public String getZrnkyksyanen() {
        return zrnkyksyanen;
    }

    public void setZrnkyksyanen(String pZrnkyksyanen) {
        zrnkyksyanen = pZrnkyksyanen;
    }

    private String zrnkykymd;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnannaifuyouriyuukbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNANNAIFUYOURIYUUKBN)
    public String getZrnannaifuyouriyuukbn() {
        return zrnannaifuyouriyuukbn;
    }

    public void setZrnannaifuyouriyuukbn(String pZrnannaifuyouriyuukbn) {
        zrnannaifuyouriyuukbn = pZrnannaifuyouriyuukbn;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private String zrnsdpdkbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSDPDKBN)
    public String getZrnsdpdkbn() {
        return zrnsdpdkbn;
    }

    public void setZrnsdpdkbn(String pZrnsdpdkbn) {
        zrnsdpdkbn = pZrnsdpdkbn;
    }

    private String zrnryouritukbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNRYOURITUKBN)
    public String getZrnryouritukbn() {
        return zrnryouritukbn;
    }

    public void setZrnryouritukbn(String pZrnryouritukbn) {
        zrnryouritukbn = pZrnryouritukbn;
    }

    private String zrntksyuannaikykkbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTKSYUANNAIKYKKBN)
    public String getZrntksyuannaikykkbn() {
        return zrntksyuannaikykkbn;
    }

    public void setZrntksyuannaikykkbn(String pZrntksyuannaikykkbn) {
        zrntksyuannaikykkbn = pZrntksyuannaikykkbn;
    }

    private String zrndai2hhknnen;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNDAI2HHKNNEN)
    public String getZrndai2hhknnen() {
        return zrndai2hhknnen;
    }

    public void setZrndai2hhknnen(String pZrndai2hhknnen) {
        zrndai2hhknnen = pZrndai2hhknnen;
    }

    private String zrnhknsyuruikigousedaikbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNHKNSYURUIKIGOUSEDAIKBN)
    public String getZrnhknsyuruikigousedaikbn() {
        return zrnhknsyuruikigousedaikbn;
    }

    public void setZrnhknsyuruikigousedaikbn(String pZrnhknsyuruikigousedaikbn) {
        zrnhknsyuruikigousedaikbn = pZrnhknsyuruikigousedaikbn;
    }

    private String zrnpmenhukakbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNPMENHUKAKBN)
    public String getZrnpmenhukakbn() {
        return zrnpmenhukakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnpmenhukakbn(String pZrnpmenhukakbn) {
        zrnpmenhukakbn = pZrnpmenhukakbn;
    }

    private String zrnhosyouikkatumnoshyouji;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNHOSYOUIKKATUMNOSHYOUJI)
    public String getZrnhosyouikkatumnoshyouji() {
        return zrnhosyouikkatumnoshyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhosyouikkatumnoshyouji(String pZrnhosyouikkatumnoshyouji) {
        zrnhosyouikkatumnoshyouji = pZrnhosyouikkatumnoshyouji;
    }

    private String zrnyobiv1x2;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNYOBIV1X2)
    public String getZrnyobiv1x2() {
        return zrnyobiv1x2;
    }

    public void setZrnyobiv1x2(String pZrnyobiv1x2) {
        zrnyobiv1x2 = pZrnyobiv1x2;
    }

    private Long zrnkihons;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNKIHONS)
    public Long getZrnkihons() {
        return zrnkihons;
    }

    public void setZrnkihons(Long pZrnkihons) {
        zrnkihons = pZrnkihons;
    }

    private Long zrngoukeitenkans;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNGOUKEITENKANS)
    public Long getZrngoukeitenkans() {
        return zrngoukeitenkans;
    }

    public void setZrngoukeitenkans(Long pZrngoukeitenkans) {
        zrngoukeitenkans = pZrngoukeitenkans;
    }

    private Long zrnhngknksaiteihosyukngk;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNHNGKNKSAITEIHOSYUKNGK)
    public Long getZrnhngknksaiteihosyukngk() {
        return zrnhngknksaiteihosyukngk;
    }

    public void setZrnhngknksaiteihosyukngk(Long pZrnhngknksaiteihosyukngk) {
        zrnhngknksaiteihosyukngk = pZrnhngknksaiteihosyukngk;
    }

    private String zrnaatukaisosikicd;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNAATUKAISOSIKICD)
    public String getZrnaatukaisosikicd() {
        return zrnaatukaisosikicd;
    }

    public void setZrnaatukaisosikicd(String pZrnaatukaisosikicd) {
        zrnaatukaisosikicd = pZrnaatukaisosikicd;
    }

    private String zrnaatukaikojincd;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNAATUKAIKOJINCD)
    public String getZrnaatukaikojincd() {
        return zrnaatukaikojincd;
    }

    public void setZrnaatukaikojincd(String pZrnaatukaikojincd) {
        zrnaatukaikojincd = pZrnaatukaikojincd;
    }

    private String zrnbsyym;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNBSYYM)
    public String getZrnbsyym() {
        return zrnbsyym;
    }

    public void setZrnbsyym(String pZrnbsyym) {
        zrnbsyym = pZrnbsyym;
    }

    private Long zrnharaikomip;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNHARAIKOMIP)
    public Long getZrnharaikomip() {
        return zrnharaikomip;
    }

    public void setZrnharaikomip(Long pZrnharaikomip) {
        zrnharaikomip = pZrnharaikomip;
    }

    private Long zrnsyukeiyakup;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSYUKEIYAKUP)
    public Long getZrnsyukeiyakup() {
        return zrnsyukeiyakup;
    }

    public void setZrnsyukeiyakup(Long pZrnsyukeiyakup) {
        zrnsyukeiyakup = pZrnsyukeiyakup;
    }

    private Long zrntokujyoup;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUJYOUP)
    public Long getZrntokujyoup() {
        return zrntokujyoup;
    }

    public void setZrntokujyoup(Long pZrntokujyoup) {
        zrntokujyoup = pZrntokujyoup;
    }

    private Long zrnitibuitijibarais;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNITIBUITIJIBARAIS)
    public Long getZrnitibuitijibarais() {
        return zrnitibuitijibarais;
    }

    public void setZrnitibuitijibarais(Long pZrnitibuitijibarais) {
        zrnitibuitijibarais = pZrnitibuitijibarais;
    }

    private Long zrnitibuitijibaraip;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNITIBUITIJIBARAIP)
    public Long getZrnitibuitijibaraip() {
        return zrnitibuitijibaraip;
    }

    public void setZrnitibuitijibaraip(Long pZrnitibuitijibaraip) {
        zrnitibuitijibaraip = pZrnitibuitijibaraip;
    }

    private Long zrngoukeitenkanteikis;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNGOUKEITENKANTEIKIS)
    public Long getZrngoukeitenkanteikis() {
        return zrngoukeitenkanteikis;
    }

    public void setZrngoukeitenkanteikis(Long pZrngoukeitenkanteikis) {
        zrngoukeitenkanteikis = pZrngoukeitenkanteikis;
    }

    private String zrnsyuunoukbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSYUUNOUKBN)
    public String getZrnsyuunoukbn() {
        return zrnsyuunoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnsyuunoukbn(String pZrnsyuunoukbn) {
        zrnsyuunoukbn = pZrnsyuunoukbn;
    }

    private Integer zrntkykkumkhnsyukosuu;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTKYKKUMKHNSYUKOSUU)
    public Integer getZrntkykkumkhnsyukosuu() {
        return zrntkykkumkhnsyukosuu;
    }

    public void setZrntkykkumkhnsyukosuu(Integer pZrntkykkumkhnsyukosuu) {
        zrntkykkumkhnsyukosuu = pZrntkykkumkhnsyukosuu;
    }

    private String zrnsiteizukipwarimasihyouji;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSITEIZUKIPWARIMASIHYOUJI)
    public String getZrnsiteizukipwarimasihyouji() {
        return zrnsiteizukipwarimasihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiteizukipwarimasihyouji(String pZrnsiteizukipwarimasihyouji) {
        zrnsiteizukipwarimasihyouji = pZrnsiteizukipwarimasihyouji;
    }

    private String zrnpwarimasisiteim1;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNPWARIMASISITEIM1)
    public String getZrnpwarimasisiteim1() {
        return zrnpwarimasisiteim1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnpwarimasisiteim1(String pZrnpwarimasisiteim1) {
        zrnpwarimasisiteim1 = pZrnpwarimasisiteim1;
    }

    private String zrnpwarimasisiteim2;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNPWARIMASISITEIM2)
    public String getZrnpwarimasisiteim2() {
        return zrnpwarimasisiteim2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnpwarimasisiteim2(String pZrnpwarimasisiteim2) {
        zrnpwarimasisiteim2 = pZrnpwarimasisiteim2;
    }

    private String zrnsiteimsykykpbairitu;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSITEIMSYKYKPBAIRITU)
    public String getZrnsiteimsykykpbairitu() {
        return zrnsiteimsykykpbairitu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsiteimsykykpbairitu(String pZrnsiteimsykykpbairitu) {
        zrnsiteimsykykpbairitu = pZrnsiteimsykykpbairitu;
    }

    private Long zrnsiteizukisyukeiyakup;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSITEIZUKISYUKEIYAKUP)
    public Long getZrnsiteizukisyukeiyakup() {
        return zrnsiteizukisyukeiyakup;
    }

    public void setZrnsiteizukisyukeiyakup(Long pZrnsiteizukisyukeiyakup) {
        zrnsiteizukisyukeiyakup = pZrnsiteizukisyukeiyakup;
    }

    private Long zrnsiteizukiharaikomip;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSITEIZUKIHARAIKOMIP)
    public Long getZrnsiteizukiharaikomip() {
        return zrnsiteizukiharaikomip;
    }

    public void setZrnsiteizukiharaikomip(Long pZrnsiteizukiharaikomip) {
        zrnsiteizukiharaikomip = pZrnsiteizukiharaikomip;
    }

    private Long zrnsaisyuusiteimhrkp;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSAISYUUSITEIMHRKP)
    public Long getZrnsaisyuusiteimhrkp() {
        return zrnsaisyuusiteimhrkp;
    }

    public void setZrnsaisyuusiteimhrkp(Long pZrnsaisyuusiteimhrkp) {
        zrnsaisyuusiteimhrkp = pZrnsaisyuusiteimhrkp;
    }

    private String zrnsaisyuusiteiym;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSAISYUUSITEIYM)
    public String getZrnsaisyuusiteiym() {
        return zrnsaisyuusiteiym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnsaisyuusiteiym(String pZrnsaisyuusiteiym) {
        zrnsaisyuusiteiym = pZrnsaisyuusiteiym;
    }

    private String zrnanniskcd;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNANNISKCD)
    public String getZrnanniskcd() {
        return zrnanniskcd;
    }

    public void setZrnanniskcd(String pZrnanniskcd) {
        zrnanniskcd = pZrnanniskcd;
    }

    private BizNumber zrntumitateriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTUMITATERIRITU)
    public BizNumber getZrntumitateriritu() {
        return zrntumitateriritu;
    }

    public void setZrntumitateriritu(BizNumber pZrntumitateriritu) {
        zrntumitateriritu = pZrntumitateriritu;
    }

    private BizNumber zrnsitihsyuriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSITIHSYURIRITU)
    public BizNumber getZrnsitihsyuriritu() {
        return zrnsitihsyuriritu;
    }

    public void setZrnsitihsyuriritu(BizNumber pZrnsitihsyuriritu) {
        zrnsitihsyuriritu = pZrnsitihsyuriritu;
    }

    private BizNumber zrnnkgnsritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNNKGNSRITU)
    public BizNumber getZrnnkgnsritu() {
        return zrnnkgnsritu;
    }

    public void setZrnnkgnsritu(BizNumber pZrnnkgnsritu) {
        zrnnkgnsritu = pZrnnkgnsritu;
    }

    private String zrnsinnyuukinkbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSINNYUUKINKBN)
    public String getZrnsinnyuukinkbn() {
        return zrnsinnyuukinkbn;
    }

    public void setZrnsinnyuukinkbn(String pZrnsinnyuukinkbn) {
        zrnsinnyuukinkbn = pZrnsinnyuukinkbn;
    }

    private String zrndfnyuukinkbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNDFNYUUKINKBN)
    public String getZrndfnyuukinkbn() {
        return zrndfnyuukinkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndfnyuukinkbn(String pZrndfnyuukinkbn) {
        zrndfnyuukinkbn = pZrndfnyuukinkbn;
    }

    private Long zrntorikuzusip;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTORIKUZUSIP)
    public Long getZrntorikuzusip() {
        return zrntorikuzusip;
    }

    public void setZrntorikuzusip(Long pZrntorikuzusip) {
        zrntorikuzusip = pZrntorikuzusip;
    }

    private String zrnkbnkeiriyousegmentcd;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNKBNKEIRIYOUSEGMENTCD)
    public String getZrnkbnkeiriyousegmentcd() {
        return zrnkbnkeiriyousegmentcd;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnkbnkeiriyousegmentcd(String pZrnkbnkeiriyousegmentcd) {
        zrnkbnkeiriyousegmentcd = pZrnkbnkeiriyousegmentcd;
    }

    private String zrnsykikykjkykym;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSYKIKYKJKYKYM)
    public String getZrnsykikykjkykym() {
        return zrnsykikykjkykym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnsykikykjkykym(String pZrnsykikykjkykym) {
        zrnsykikykjkykym = pZrnsykikykjkykym;
    }

    private Long zrndfkijyunkingaku;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNDFKIJYUNKINGAKU)
    public Long getZrndfkijyunkingaku() {
        return zrndfkijyunkingaku;
    }

    public void setZrndfkijyunkingaku(Long pZrndfkijyunkingaku) {
        zrndfkijyunkingaku = pZrndfkijyunkingaku;
    }

    private String zrnstdssytikbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSTDSSYTIKBN)
    public String getZrnstdssytikbn() {
        return zrnstdssytikbn;
    }

    public void setZrnstdssytikbn(String pZrnstdssytikbn) {
        zrnstdssytikbn = pZrnstdssytikbn;
    }

    private String zrnsotodasimanagehyouji;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSOTODASIMANAGEHYOUJI)
    public String getZrnsotodasimanagehyouji() {
        return zrnsotodasimanagehyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsotodasimanagehyouji(String pZrnsotodasimanagehyouji) {
        zrnsotodasimanagehyouji = pZrnsotodasimanagehyouji;
    }

    private String zrnsotodasiphkbnmnoshyouji;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSOTODASIPHKBNMNOSHYOUJI)
    public String getZrnsotodasiphkbnmnoshyouji() {
        return zrnsotodasiphkbnmnoshyouji;
    }

    public void setZrnsotodasiphkbnmnoshyouji(String pZrnsotodasiphkbnmnoshyouji) {
        zrnsotodasiphkbnmnoshyouji = pZrnsotodasiphkbnmnoshyouji;
    }

    private String zrnstdsstkjytkyuhyj;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSTDSSTKJYTKYUHYJ)
    public String getZrnstdsstkjytkyuhyj() {
        return zrnstdsstkjytkyuhyj;
    }

    public void setZrnstdsstkjytkyuhyj(String pZrnstdsstkjytkyuhyj) {
        zrnstdsstkjytkyuhyj = pZrnstdsstkjytkyuhyj;
    }

    private String zrnkousinmanryouage;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNKOUSINMANRYOUAGE)
    public String getZrnkousinmanryouage() {
        return zrnkousinmanryouage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkousinmanryouage(String pZrnkousinmanryouage) {
        zrnkousinmanryouage = pZrnkousinmanryouage;
    }

    private String zrnknkuzusnzyrttekitkarihyj;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNKNKUZUSNZYRTTEKITKARIHYJ)
    public String getZrnknkuzusnzyrttekitkarihyj() {
        return zrnknkuzusnzyrttekitkarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnknkuzusnzyrttekitkarihyj(String pZrnknkuzusnzyrttekitkarihyj) {
        zrnknkuzusnzyrttekitkarihyj = pZrnknkuzusnzyrttekitkarihyj;
    }

    private String zrnknkuzusnzyrt;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNKNKUZUSNZYRT)
    public String getZrnknkuzusnzyrt() {
        return zrnknkuzusnzyrt;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnknkuzusnzyrt(String pZrnknkuzusnzyrt) {
        zrnknkuzusnzyrt = pZrnknkuzusnzyrt;
    }

    private String zrntenkanjiknkuzusnzyrt;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTENKANJIKNKUZUSNZYRT)
    public String getZrntenkanjiknkuzusnzyrt() {
        return zrntenkanjiknkuzusnzyrt;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrntenkanjiknkuzusnzyrt(String pZrntenkanjiknkuzusnzyrt) {
        zrntenkanjiknkuzusnzyrt = pZrntenkanjiknkuzusnzyrt;
    }

    private String zrnpwrbksidhitekiyouhyj;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNPWRBKSIDHITEKIYOUHYJ)
    public String getZrnpwrbksidhitekiyouhyj() {
        return zrnpwrbksidhitekiyouhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnpwrbksidhitekiyouhyj(String pZrnpwrbksidhitekiyouhyj) {
        zrnpwrbksidhitekiyouhyj = pZrnpwrbksidhitekiyouhyj;
    }

    private String zrnsuuriyouyobin1x2;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSUURIYOUYOBIN1X2)
    public String getZrnsuuriyouyobin1x2() {
        return zrnsuuriyouyobin1x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuuriyouyobin1x2(String pZrnsuuriyouyobin1x2) {
        zrnsuuriyouyobin1x2 = pZrnsuuriyouyobin1x2;
    }

    private String zrnzyrthntiyustatuskbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNZYRTHNTIYUSTATUSKBN)
    public String getZrnzyrthntiyustatuskbn() {
        return zrnzyrthntiyustatuskbn;
    }

    public void setZrnzyrthntiyustatuskbn(String pZrnzyrthntiyustatuskbn) {
        zrnzyrthntiyustatuskbn = pZrnzyrthntiyustatuskbn;
    }

    private String zrnyobiv9;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNYOBIV9)
    public String getZrnyobiv9() {
        return zrnyobiv9;
    }

    public void setZrnyobiv9(String pZrnyobiv9) {
        zrnyobiv9 = pZrnyobiv9;
    }

    private String zrnsotodasipmenkbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSOTODASIPMENKBN)
    public String getZrnsotodasipmenkbn() {
        return zrnsotodasipmenkbn;
    }

    public void setZrnsotodasipmenkbn(String pZrnsotodasipmenkbn) {
        zrnsotodasipmenkbn = pZrnsotodasipmenkbn;
    }

    private String zrntokubetuhosyoukikan;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUBETUHOSYOUKIKAN)
    public String getZrntokubetuhosyoukikan() {
        return zrntokubetuhosyoukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntokubetuhosyoukikan(String pZrntokubetuhosyoukikan) {
        zrntokubetuhosyoukikan = pZrntokubetuhosyoukikan;
    }

    private String zrnsuuriyouyobin7;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSUURIYOUYOBIN7)
    public String getZrnsuuriyouyobin7() {
        return zrnsuuriyouyobin7;
    }

    @Padding(mode = "left", padChar = '0', length = 7)
    public void setZrnsuuriyouyobin7(String pZrnsuuriyouyobin7) {
        zrnsuuriyouyobin7 = pZrnsuuriyouyobin7;
    }

    private Long zrnphireilkeisanyoup;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNPHIREILKEISANYOUP)
    public Long getZrnphireilkeisanyoup() {
        return zrnphireilkeisanyoup;
    }

    public void setZrnphireilkeisanyoup(Long pZrnphireilkeisanyoup) {
        zrnphireilkeisanyoup = pZrnphireilkeisanyoup;
    }

    private Long zrnyobin11;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNYOBIN11)
    public Long getZrnyobin11() {
        return zrnyobin11;
    }

    public void setZrnyobin11(Long pZrnyobin11) {
        zrnyobin11 = pZrnyobin11;
    }

    private Long zrnyobin11x2;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNYOBIN11X2)
    public Long getZrnyobin11x2() {
        return zrnyobin11x2;
    }

    public void setZrnyobin11x2(Long pZrnyobin11x2) {
        zrnyobin11x2 = pZrnyobin11x2;
    }

    private Long zrnyobin11x3;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNYOBIN11X3)
    public Long getZrnyobin11x3() {
        return zrnyobin11x3;
    }

    public void setZrnyobin11x3(Long pZrnyobin11x3) {
        zrnyobin11x3 = pZrnyobin11x3;
    }

    private Long zrnyobin11x4;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNYOBIN11X4)
    public Long getZrnyobin11x4() {
        return zrnyobin11x4;
    }

    public void setZrnyobin11x4(Long pZrnyobin11x4) {
        zrnyobin11x4 = pZrnyobin11x4;
    }

    private String zrncashlesshyj;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNCASHLESSHYJ)
    public String getZrncashlesshyj() {
        return zrncashlesshyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrncashlesshyj(String pZrncashlesshyj) {
        zrncashlesshyj = pZrncashlesshyj;
    }

    private String zrnkykjiqpackhyj;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNKYKJIQPACKHYJ)
    public String getZrnkykjiqpackhyj() {
        return zrnkykjiqpackhyj;
    }

    public void setZrnkykjiqpackhyj(String pZrnkykjiqpackhyj) {
        zrnkykjiqpackhyj = pZrnkykjiqpackhyj;
    }

    private String zrntenkanminaosikbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTENKANMINAOSIKBN)
    public String getZrntenkanminaosikbn() {
        return zrntenkanminaosikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntenkanminaosikbn(String pZrntenkanminaosikbn) {
        zrntenkanminaosikbn = pZrntenkanminaosikbn;
    }

    private String zrnhhknnentysihyj;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNHHKNNENTYSIHYJ)
    public String getZrnhhknnentysihyj() {
        return zrnhhknnentysihyj;
    }

    public void setZrnhhknnentysihyj(String pZrnhhknnentysihyj) {
        zrnhhknnentysihyj = pZrnhhknnentysihyj;
    }

    private String zrndai2hhknnentysihyj;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNDAI2HHKNNENTYSIHYJ)
    public String getZrndai2hhknnentysihyj() {
        return zrndai2hhknnentysihyj;
    }

    public void setZrndai2hhknnentysihyj(String pZrndai2hhknnentysihyj) {
        zrndai2hhknnentysihyj = pZrndai2hhknnentysihyj;
    }

    private String zrnkyksyaagetyouseihyj;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNKYKSYAAGETYOUSEIHYJ)
    public String getZrnkyksyaagetyouseihyj() {
        return zrnkyksyaagetyouseihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkyksyaagetyouseihyj(String pZrnkyksyaagetyouseihyj) {
        zrnkyksyaagetyouseihyj = pZrnkyksyaagetyouseihyj;
    }

    private String zrnsykykhokenhoutekiyouhyj;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSYKYKHOKENHOUTEKIYOUHYJ)
    public String getZrnsykykhokenhoutekiyouhyj() {
        return zrnsykykhokenhoutekiyouhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsykykhokenhoutekiyouhyj(String pZrnsykykhokenhoutekiyouhyj) {
        zrnsykykhokenhoutekiyouhyj = pZrnsykykhokenhoutekiyouhyj;
    }

    private String zrnhrimngtkykphrkkaisuukbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNHRIMNGTKYKPHRKKAISUUKBN)
    public String getZrnhrimngtkykphrkkaisuukbn() {
        return zrnhrimngtkykphrkkaisuukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhrimngtkykphrkkaisuukbn(String pZrnhrimngtkykphrkkaisuukbn) {
        zrnhrimngtkykphrkkaisuukbn = pZrnhrimngtkykphrkkaisuukbn;
    }

    private String zrnjidoukousinhyouji;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNJIDOUKOUSINHYOUJI)
    public String getZrnjidoukousinhyouji() {
        return zrnjidoukousinhyouji;
    }

    public void setZrnjidoukousinhyouji(String pZrnjidoukousinhyouji) {
        zrnjidoukousinhyouji = pZrnjidoukousinhyouji;
    }

    private String zrnsuuriyouyobin1;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSUURIYOUYOBIN1)
    public String getZrnsuuriyouyobin1() {
        return zrnsuuriyouyobin1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuuriyouyobin1(String pZrnsuuriyouyobin1) {
        zrnsuuriyouyobin1 = pZrnsuuriyouyobin1;
    }

    private String zrntkjykbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTKJYKBN)
    public String getZrntkjykbn() {
        return zrntkjykbn;
    }

    public void setZrntkjykbn(String pZrntkjykbn) {
        zrntkjykbn = pZrntkjykbn;
    }

    private String zrndai2tokujyoukbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNDAI2TOKUJYOUKBN)
    public String getZrndai2tokujyoukbn() {
        return zrndai2tokujyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndai2tokujyoukbn(String pZrndai2tokujyoukbn) {
        zrndai2tokujyoukbn = pZrndai2tokujyoukbn;
    }

    private Integer zrnryoumasihyouten;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNRYOUMASIHYOUTEN)
    public Integer getZrnryoumasihyouten() {
        return zrnryoumasihyouten;
    }

    public void setZrnryoumasihyouten(Integer pZrnryoumasihyouten) {
        zrnryoumasihyouten = pZrnryoumasihyouten;
    }

    private Integer zrndai2ryoumasihyouten;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNDAI2RYOUMASIHYOUTEN)
    public Integer getZrndai2ryoumasihyouten() {
        return zrndai2ryoumasihyouten;
    }

    public void setZrndai2ryoumasihyouten(Integer pZrndai2ryoumasihyouten) {
        zrndai2ryoumasihyouten = pZrndai2ryoumasihyouten;
    }

    private String zrnsuuriyouyobin2;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSUURIYOUYOBIN2)
    public String getZrnsuuriyouyobin2() {
        return zrnsuuriyouyobin2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsuuriyouyobin2(String pZrnsuuriyouyobin2) {
        zrnsuuriyouyobin2 = pZrnsuuriyouyobin2;
    }

    private String zrnsuuriyouyobin10;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSUURIYOUYOBIN10)
    public String getZrnsuuriyouyobin10() {
        return zrnsuuriyouyobin10;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnsuuriyouyobin10(String pZrnsuuriyouyobin10) {
        zrnsuuriyouyobin10 = pZrnsuuriyouyobin10;
    }

    private String zrnsuuriyouyobin10x2;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSUURIYOUYOBIN10X2)
    public String getZrnsuuriyouyobin10x2() {
        return zrnsuuriyouyobin10x2;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnsuuriyouyobin10x2(String pZrnsuuriyouyobin10x2) {
        zrnsuuriyouyobin10x2 = pZrnsuuriyouyobin10x2;
    }

    private String zrnsuuriyouyobin10x3;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSUURIYOUYOBIN10X3)
    public String getZrnsuuriyouyobin10x3() {
        return zrnsuuriyouyobin10x3;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnsuuriyouyobin10x3(String pZrnsuuriyouyobin10x3) {
        zrnsuuriyouyobin10x3 = pZrnsuuriyouyobin10x3;
    }

    private String zrnsuuriyouyobin10x4;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSUURIYOUYOBIN10X4)
    public String getZrnsuuriyouyobin10x4() {
        return zrnsuuriyouyobin10x4;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnsuuriyouyobin10x4(String pZrnsuuriyouyobin10x4) {
        zrnsuuriyouyobin10x4 = pZrnsuuriyouyobin10x4;
    }

    private String zrnyobiv10x6;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNYOBIV10X6)
    public String getZrnyobiv10x6() {
        return zrnyobiv10x6;
    }

    public void setZrnyobiv10x6(String pZrnyobiv10x6) {
        zrnyobiv10x6 = pZrnyobiv10x6;
    }

    private String zrnyobiv10x7;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNYOBIV10X7)
    public String getZrnyobiv10x7() {
        return zrnyobiv10x7;
    }

    public void setZrnyobiv10x7(String pZrnyobiv10x7) {
        zrnyobiv10x7 = pZrnyobiv10x7;
    }

    private String zrnyobiv10x8;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNYOBIV10X8)
    public String getZrnyobiv10x8() {
        return zrnyobiv10x8;
    }

    public void setZrnyobiv10x8(String pZrnyobiv10x8) {
        zrnyobiv10x8 = pZrnyobiv10x8;
    }

    private String zrnyobiv10x9;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNYOBIV10X9)
    public String getZrnyobiv10x9() {
        return zrnyobiv10x9;
    }

    public void setZrnyobiv10x9(String pZrnyobiv10x9) {
        zrnyobiv10x9 = pZrnyobiv10x9;
    }

    private String zrnyobiv10x10;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNYOBIV10X10)
    public String getZrnyobiv10x10() {
        return zrnyobiv10x10;
    }

    public void setZrnyobiv10x10(String pZrnyobiv10x10) {
        zrnyobiv10x10 = pZrnyobiv10x10;
    }

    private String zrnyobiv10x11;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNYOBIV10X11)
    public String getZrnyobiv10x11() {
        return zrnyobiv10x11;
    }

    public void setZrnyobiv10x11(String pZrnyobiv10x11) {
        zrnyobiv10x11 = pZrnyobiv10x11;
    }

    private String zrnbosyuukeitaikbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNBOSYUUKEITAIKBN)
    public String getZrnbosyuukeitaikbn() {
        return zrnbosyuukeitaikbn;
    }

    public void setZrnbosyuukeitaikbn(String pZrnbosyuukeitaikbn) {
        zrnbosyuukeitaikbn = pZrnbosyuukeitaikbn;
    }

    private String zrnhrimngtkykphrkkirkbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNHRIMNGTKYKPHRKKIRKBN)
    public String getZrnhrimngtkykphrkkirkbn() {
        return zrnhrimngtkykphrkkirkbn;
    }

    public void setZrnhrimngtkykphrkkirkbn(String pZrnhrimngtkykphrkkirkbn) {
        zrnhrimngtkykphrkkirkbn = pZrnhrimngtkykphrkkirkbn;
    }

    private String zrnhrimngtkykpryurtkbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNHRIMNGTKYKPRYURTKBN)
    public String getZrnhrimngtkykpryurtkbn() {
        return zrnhrimngtkykpryurtkbn;
    }

    public void setZrnhrimngtkykpryurtkbn(String pZrnhrimngtkykpryurtkbn) {
        zrnhrimngtkykpryurtkbn = pZrnhrimngtkykpryurtkbn;
    }

    private String zrnsyukeiyakusyuruicdv3;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSYUKEIYAKUSYURUICDV3)
    public String getZrnsyukeiyakusyuruicdv3() {
        return zrnsyukeiyakusyuruicdv3;
    }

    public void setZrnsyukeiyakusyuruicdv3(String pZrnsyukeiyakusyuruicdv3) {
        zrnsyukeiyakusyuruicdv3 = pZrnsyukeiyakusyuruicdv3;
    }

    private Long zrnyobin11x5;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNYOBIN11X5)
    public Long getZrnyobin11x5() {
        return zrnyobin11x5;
    }

    public void setZrnyobin11x5(Long pZrnyobin11x5) {
        zrnyobin11x5 = pZrnyobin11x5;
    }

    private Long zrnyobin11x6;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNYOBIN11X6)
    public Long getZrnyobin11x6() {
        return zrnyobin11x6;
    }

    public void setZrnyobin11x6(Long pZrnyobin11x6) {
        zrnyobin11x6 = pZrnyobin11x6;
    }

    private Long zrnyobin11x7;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNYOBIN11X7)
    public Long getZrnyobin11x7() {
        return zrnyobin11x7;
    }

    public void setZrnyobin11x7(Long pZrnyobin11x7) {
        zrnyobin11x7 = pZrnyobin11x7;
    }

    private Long zrnyobin11x8;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNYOBIN11X8)
    public Long getZrnyobin11x8() {
        return zrnyobin11x8;
    }

    public void setZrnyobin11x8(Long pZrnyobin11x8) {
        zrnyobin11x8 = pZrnyobin11x8;
    }

    private Long zrnyobin11x9;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNYOBIN11X9)
    public Long getZrnyobin11x9() {
        return zrnyobin11x9;
    }

    public void setZrnyobin11x9(Long pZrnyobin11x9) {
        zrnyobin11x9 = pZrnyobin11x9;
    }

    private String zrnraysystemhyj;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNRAYSYSTEMHYJ)
    public String getZrnraysystemhyj() {
        return zrnraysystemhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnraysystemhyj(String pZrnraysystemhyj) {
        zrnraysystemhyj = pZrnraysystemhyj;
    }

    private String zrngaikakbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNGAIKAKBN)
    public String getZrngaikakbn() {
        return zrngaikakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngaikakbn(String pZrngaikakbn) {
        zrngaikakbn = pZrngaikakbn;
    }

    private BizNumber zrnkykjikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNKYKJIKAWASERATE)
    public BizNumber getZrnkykjikawaserate() {
        return zrnkykjikawaserate;
    }

    public void setZrnkykjikawaserate(BizNumber pZrnkykjikawaserate) {
        zrnkykjikawaserate = pZrnkykjikawaserate;
    }

    private String zrnkykjikawaseratetkyuymd;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNKYKJIKAWASERATETKYUYMD)
    public String getZrnkykjikawaseratetkyuymd() {
        return zrnkykjikawaseratetkyuymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnkykjikawaseratetkyuymd(String pZrnkykjikawaseratetkyuymd) {
        zrnkykjikawaseratetkyuymd = pZrnkykjikawaseratetkyuymd;
    }

    private BizNumber zrnkeiyakujiyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNKEIYAKUJIYOTEIRIRITU)
    public BizNumber getZrnkeiyakujiyoteiriritu() {
        return zrnkeiyakujiyoteiriritu;
    }

    public void setZrnkeiyakujiyoteiriritu(BizNumber pZrnkeiyakujiyoteiriritu) {
        zrnkeiyakujiyoteiriritu = pZrnkeiyakujiyoteiriritu;
    }

    private Long zrnenkdtsbujsitihsyukngk;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNENKDTSBUJSITIHSYUKNGK)
    public Long getZrnenkdtsbujsitihsyukngk() {
        return zrnenkdtsbujsitihsyukngk;
    }

    public void setZrnenkdtsbujsitihsyukngk(Long pZrnenkdtsbujsitihsyukngk) {
        zrnenkdtsbujsitihsyukngk = pZrnenkdtsbujsitihsyukngk;
    }

    private String zrnnyuukintuukakbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNNYUUKINTUUKAKBN)
    public String getZrnnyuukintuukakbn() {
        return zrnnyuukintuukakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnyuukintuukakbn(String pZrnnyuukintuukakbn) {
        zrnnyuukintuukakbn = pZrnnyuukintuukakbn;
    }

    private String zrnsisuurendourate;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSISUURENDOURATE)
    public String getZrnsisuurendourate() {
        return zrnsisuurendourate;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnsisuurendourate(String pZrnsisuurendourate) {
        zrnsisuurendourate = pZrnsisuurendourate;
    }

    private String zrnsisuukbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSISUUKBN)
    public String getZrnsisuukbn() {
        return zrnsisuukbn;
    }

    public void setZrnsisuukbn(String pZrnsisuukbn) {
        zrnsisuukbn = pZrnsisuukbn;
    }

    private BizNumber zrnnyknjikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNNYKNJIKAWASERATE)
    public BizNumber getZrnnyknjikawaserate() {
        return zrnnyknjikawaserate;
    }

    public void setZrnnyknjikawaserate(BizNumber pZrnnyknjikawaserate) {
        zrnnyknjikawaserate = pZrnnyknjikawaserate;
    }

    private String zrnnyknjikawaseratetkyuymd;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNNYKNJIKAWASERATETKYUYMD)
    public String getZrnnyknjikawaseratetkyuymd() {
        return zrnnyknjikawaseratetkyuymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnnyknjikawaseratetkyuymd(String pZrnnyknjikawaseratetkyuymd) {
        zrnnyknjikawaseratetkyuymd = pZrnnyknjikawaseratetkyuymd;
    }

    private String zrnsrdai1hknkkn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSRDAI1HKNKKN)
    public String getZrnsrdai1hknkkn() {
        return zrnsrdai1hknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsrdai1hknkkn(String pZrnsrdai1hknkkn) {
        zrnsrdai1hknkkn = pZrnsrdai1hknkkn;
    }

    private String zrnsuuriyouyobin10x5;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSUURIYOUYOBIN10X5)
    public String getZrnsuuriyouyobin10x5() {
        return zrnsuuriyouyobin10x5;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnsuuriyouyobin10x5(String pZrnsuuriyouyobin10x5) {
        zrnsuuriyouyobin10x5 = pZrnsuuriyouyobin10x5;
    }

    private String zrntuukasyukbn;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTUUKASYUKBN)
    public String getZrntuukasyukbn() {
        return zrntuukasyukbn;
    }

    public void setZrntuukasyukbn(String pZrntuukasyukbn) {
        zrntuukasyukbn = pZrntuukasyukbn;
    }

    private String zrnyobiv9x2;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNYOBIV9X2)
    public String getZrnyobiv9x2() {
        return zrnyobiv9x2;
    }

    public void setZrnyobiv9x2(String pZrnyobiv9x2) {
        zrnyobiv9x2 = pZrnyobiv9x2;
    }

    private String zrnyobiv10x16;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNYOBIV10X16)
    public String getZrnyobiv10x16() {
        return zrnyobiv10x16;
    }

    public void setZrnyobiv10x16(String pZrnyobiv10x16) {
        zrnyobiv10x16 = pZrnyobiv10x16;
    }

    private Long zrnnkgns;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNNKGNS)
    public Long getZrnnkgns() {
        return zrnnkgns;
    }

    public void setZrnnkgns(Long pZrnnkgns) {
        zrnnkgns = pZrnnkgns;
    }

    private Long zrnsisuubbntounyuugk;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSISUUBBNTOUNYUUGK)
    public Long getZrnsisuubbntounyuugk() {
        return zrnsisuubbntounyuugk;
    }

    public void setZrnsisuubbntounyuugk(Long pZrnsisuubbntounyuugk) {
        zrnsisuubbntounyuugk = pZrnsisuubbntounyuugk;
    }

    private BizNumber zrnsaisinyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNSAISINYOTEIRIRITU)
    public BizNumber getZrnsaisinyoteiriritu() {
        return zrnsaisinyoteiriritu;
    }

    public void setZrnsaisinyoteiriritu(BizNumber pZrnsaisinyoteiriritu) {
        zrnsaisinyoteiriritu = pZrnsaisinyoteiriritu;
    }

    private Integer zrnyobin5;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNYOBIN5)
    public Integer getZrnyobin5() {
        return zrnyobin5;
    }

    public void setZrnyobin5(Integer pZrnyobin5) {
        zrnyobin5 = pZrnyobin5;
    }

    private Long zrnyobin11x10;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNYOBIN11X10)
    public Long getZrnyobin11x10() {
        return zrnyobin11x10;
    }

    public void setZrnyobin11x10(Long pZrnyobin11x10) {
        zrnyobin11x10 = pZrnyobin11x10;
    }

    private Long zrnkiharaikomip;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNKIHARAIKOMIP)
    public Long getZrnkiharaikomip() {
        return zrnkiharaikomip;
    }

    public void setZrnkiharaikomip(Long pZrnkiharaikomip) {
        zrnkiharaikomip = pZrnkiharaikomip;
    }

    private Long zrntumitatekin;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTUMITATEKIN)
    public Long getZrntumitatekin() {
        return zrntumitatekin;
    }

    public void setZrntumitatekin(Long pZrntumitatekin) {
        zrntumitatekin = pZrntumitatekin;
    }

    private Long zrnzennoujiikkatubaraijytgk;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNZENNOUJIIKKATUBARAIJYTGK)
    public Long getZrnzennoujiikkatubaraijytgk() {
        return zrnzennoujiikkatubaraijytgk;
    }

    public void setZrnzennoujiikkatubaraijytgk(Long pZrnzennoujiikkatubaraijytgk) {
        zrnzennoujiikkatubaraijytgk = pZrnzennoujiikkatubaraijytgk;
    }

    private Long zrngaikadatenkgns;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNGAIKADATENKGNS)
    public Long getZrngaikadatenkgns() {
        return zrngaikadatenkgns;
    }

    public void setZrngaikadatenkgns(Long pZrngaikadatenkgns) {
        zrngaikadatenkgns = pZrngaikadatenkgns;
    }

    private Long zrngaikadatesyukeiyakup;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNGAIKADATESYUKEIYAKUP)
    public Long getZrngaikadatesyukeiyakup() {
        return zrngaikadatesyukeiyakup;
    }

    public void setZrngaikadatesyukeiyakup(Long pZrngaikadatesyukeiyakup) {
        zrngaikadatesyukeiyakup = pZrngaikadatesyukeiyakup;
    }

    private String zrnyobiv1x3;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNYOBIV1X3)
    public String getZrnyobiv1x3() {
        return zrnyobiv1x3;
    }

    public void setZrnyobiv1x3(String pZrnyobiv1x3) {
        zrnyobiv1x3 = pZrnyobiv1x3;
    }

    private String zrntokuyakukoumokuv160;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160)
    public String getZrntokuyakukoumokuv160() {
        return zrntokuyakukoumokuv160;
    }

    public void setZrntokuyakukoumokuv160(String pZrntokuyakukoumokuv160) {
        zrntokuyakukoumokuv160 = pZrntokuyakukoumokuv160;
    }

    private String zrntokuyakukoumokuv160x2;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X2)
    public String getZrntokuyakukoumokuv160x2() {
        return zrntokuyakukoumokuv160x2;
    }

    public void setZrntokuyakukoumokuv160x2(String pZrntokuyakukoumokuv160x2) {
        zrntokuyakukoumokuv160x2 = pZrntokuyakukoumokuv160x2;
    }

    private String zrntokuyakukoumokuv160x3;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X3)
    public String getZrntokuyakukoumokuv160x3() {
        return zrntokuyakukoumokuv160x3;
    }

    public void setZrntokuyakukoumokuv160x3(String pZrntokuyakukoumokuv160x3) {
        zrntokuyakukoumokuv160x3 = pZrntokuyakukoumokuv160x3;
    }

    private String zrntokuyakukoumokuv160x4;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X4)
    public String getZrntokuyakukoumokuv160x4() {
        return zrntokuyakukoumokuv160x4;
    }

    public void setZrntokuyakukoumokuv160x4(String pZrntokuyakukoumokuv160x4) {
        zrntokuyakukoumokuv160x4 = pZrntokuyakukoumokuv160x4;
    }

    private String zrntokuyakukoumokuv160x5;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X5)
    public String getZrntokuyakukoumokuv160x5() {
        return zrntokuyakukoumokuv160x5;
    }

    public void setZrntokuyakukoumokuv160x5(String pZrntokuyakukoumokuv160x5) {
        zrntokuyakukoumokuv160x5 = pZrntokuyakukoumokuv160x5;
    }

    private String zrntokuyakukoumokuv160x6;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X6)
    public String getZrntokuyakukoumokuv160x6() {
        return zrntokuyakukoumokuv160x6;
    }

    public void setZrntokuyakukoumokuv160x6(String pZrntokuyakukoumokuv160x6) {
        zrntokuyakukoumokuv160x6 = pZrntokuyakukoumokuv160x6;
    }

    private String zrntokuyakukoumokuv160x7;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X7)
    public String getZrntokuyakukoumokuv160x7() {
        return zrntokuyakukoumokuv160x7;
    }

    public void setZrntokuyakukoumokuv160x7(String pZrntokuyakukoumokuv160x7) {
        zrntokuyakukoumokuv160x7 = pZrntokuyakukoumokuv160x7;
    }

    private String zrntokuyakukoumokuv160x8;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X8)
    public String getZrntokuyakukoumokuv160x8() {
        return zrntokuyakukoumokuv160x8;
    }

    public void setZrntokuyakukoumokuv160x8(String pZrntokuyakukoumokuv160x8) {
        zrntokuyakukoumokuv160x8 = pZrntokuyakukoumokuv160x8;
    }

    private String zrntokuyakukoumokuv160x9;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X9)
    public String getZrntokuyakukoumokuv160x9() {
        return zrntokuyakukoumokuv160x9;
    }

    public void setZrntokuyakukoumokuv160x9(String pZrntokuyakukoumokuv160x9) {
        zrntokuyakukoumokuv160x9 = pZrntokuyakukoumokuv160x9;
    }

    private String zrntokuyakukoumokuv160x10;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X10)
    public String getZrntokuyakukoumokuv160x10() {
        return zrntokuyakukoumokuv160x10;
    }

    public void setZrntokuyakukoumokuv160x10(String pZrntokuyakukoumokuv160x10) {
        zrntokuyakukoumokuv160x10 = pZrntokuyakukoumokuv160x10;
    }

    private String zrntokuyakukoumokuv160x11;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X11)
    public String getZrntokuyakukoumokuv160x11() {
        return zrntokuyakukoumokuv160x11;
    }

    public void setZrntokuyakukoumokuv160x11(String pZrntokuyakukoumokuv160x11) {
        zrntokuyakukoumokuv160x11 = pZrntokuyakukoumokuv160x11;
    }

    private String zrntokuyakukoumokuv160x12;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X12)
    public String getZrntokuyakukoumokuv160x12() {
        return zrntokuyakukoumokuv160x12;
    }

    public void setZrntokuyakukoumokuv160x12(String pZrntokuyakukoumokuv160x12) {
        zrntokuyakukoumokuv160x12 = pZrntokuyakukoumokuv160x12;
    }

    private String zrntokuyakukoumokuv160x13;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X13)
    public String getZrntokuyakukoumokuv160x13() {
        return zrntokuyakukoumokuv160x13;
    }

    public void setZrntokuyakukoumokuv160x13(String pZrntokuyakukoumokuv160x13) {
        zrntokuyakukoumokuv160x13 = pZrntokuyakukoumokuv160x13;
    }

    private String zrntokuyakukoumokuv160x14;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X14)
    public String getZrntokuyakukoumokuv160x14() {
        return zrntokuyakukoumokuv160x14;
    }

    public void setZrntokuyakukoumokuv160x14(String pZrntokuyakukoumokuv160x14) {
        zrntokuyakukoumokuv160x14 = pZrntokuyakukoumokuv160x14;
    }

    private String zrntokuyakukoumokuv160x15;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X15)
    public String getZrntokuyakukoumokuv160x15() {
        return zrntokuyakukoumokuv160x15;
    }

    public void setZrntokuyakukoumokuv160x15(String pZrntokuyakukoumokuv160x15) {
        zrntokuyakukoumokuv160x15 = pZrntokuyakukoumokuv160x15;
    }

    private String zrntokuyakukoumokuv160x16;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X16)
    public String getZrntokuyakukoumokuv160x16() {
        return zrntokuyakukoumokuv160x16;
    }

    public void setZrntokuyakukoumokuv160x16(String pZrntokuyakukoumokuv160x16) {
        zrntokuyakukoumokuv160x16 = pZrntokuyakukoumokuv160x16;
    }

    private String zrntokuyakukoumokuv160x17;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X17)
    public String getZrntokuyakukoumokuv160x17() {
        return zrntokuyakukoumokuv160x17;
    }

    public void setZrntokuyakukoumokuv160x17(String pZrntokuyakukoumokuv160x17) {
        zrntokuyakukoumokuv160x17 = pZrntokuyakukoumokuv160x17;
    }

    private String zrntokuyakukoumokuv160x18;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X18)
    public String getZrntokuyakukoumokuv160x18() {
        return zrntokuyakukoumokuv160x18;
    }

    public void setZrntokuyakukoumokuv160x18(String pZrntokuyakukoumokuv160x18) {
        zrntokuyakukoumokuv160x18 = pZrntokuyakukoumokuv160x18;
    }

    private String zrntokuyakukoumokuv160x19;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X19)
    public String getZrntokuyakukoumokuv160x19() {
        return zrntokuyakukoumokuv160x19;
    }

    public void setZrntokuyakukoumokuv160x19(String pZrntokuyakukoumokuv160x19) {
        zrntokuyakukoumokuv160x19 = pZrntokuyakukoumokuv160x19;
    }

    private String zrntokuyakukoumokuv160x20;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X20)
    public String getZrntokuyakukoumokuv160x20() {
        return zrntokuyakukoumokuv160x20;
    }

    public void setZrntokuyakukoumokuv160x20(String pZrntokuyakukoumokuv160x20) {
        zrntokuyakukoumokuv160x20 = pZrntokuyakukoumokuv160x20;
    }

    private String zrntokuyakukoumokuv160x21;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X21)
    public String getZrntokuyakukoumokuv160x21() {
        return zrntokuyakukoumokuv160x21;
    }

    public void setZrntokuyakukoumokuv160x21(String pZrntokuyakukoumokuv160x21) {
        zrntokuyakukoumokuv160x21 = pZrntokuyakukoumokuv160x21;
    }

    private String zrntokuyakukoumokuv160x22;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X22)
    public String getZrntokuyakukoumokuv160x22() {
        return zrntokuyakukoumokuv160x22;
    }

    public void setZrntokuyakukoumokuv160x22(String pZrntokuyakukoumokuv160x22) {
        zrntokuyakukoumokuv160x22 = pZrntokuyakukoumokuv160x22;
    }

    private String zrntokuyakukoumokuv160x23;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X23)
    public String getZrntokuyakukoumokuv160x23() {
        return zrntokuyakukoumokuv160x23;
    }

    public void setZrntokuyakukoumokuv160x23(String pZrntokuyakukoumokuv160x23) {
        zrntokuyakukoumokuv160x23 = pZrntokuyakukoumokuv160x23;
    }

    private String zrntokuyakukoumokuv160x24;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X24)
    public String getZrntokuyakukoumokuv160x24() {
        return zrntokuyakukoumokuv160x24;
    }

    public void setZrntokuyakukoumokuv160x24(String pZrntokuyakukoumokuv160x24) {
        zrntokuyakukoumokuv160x24 = pZrntokuyakukoumokuv160x24;
    }

    private String zrntokuyakukoumokuv160x25;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X25)
    public String getZrntokuyakukoumokuv160x25() {
        return zrntokuyakukoumokuv160x25;
    }

    public void setZrntokuyakukoumokuv160x25(String pZrntokuyakukoumokuv160x25) {
        zrntokuyakukoumokuv160x25 = pZrntokuyakukoumokuv160x25;
    }

    private String zrntokuyakukoumokuv160x26;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X26)
    public String getZrntokuyakukoumokuv160x26() {
        return zrntokuyakukoumokuv160x26;
    }

    public void setZrntokuyakukoumokuv160x26(String pZrntokuyakukoumokuv160x26) {
        zrntokuyakukoumokuv160x26 = pZrntokuyakukoumokuv160x26;
    }

    private String zrntokuyakukoumokuv160x27;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X27)
    public String getZrntokuyakukoumokuv160x27() {
        return zrntokuyakukoumokuv160x27;
    }

    public void setZrntokuyakukoumokuv160x27(String pZrntokuyakukoumokuv160x27) {
        zrntokuyakukoumokuv160x27 = pZrntokuyakukoumokuv160x27;
    }

    private String zrntokuyakukoumokuv160x28;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X28)
    public String getZrntokuyakukoumokuv160x28() {
        return zrntokuyakukoumokuv160x28;
    }

    public void setZrntokuyakukoumokuv160x28(String pZrntokuyakukoumokuv160x28) {
        zrntokuyakukoumokuv160x28 = pZrntokuyakukoumokuv160x28;
    }

    private String zrntokuyakukoumokuv160x29;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X29)
    public String getZrntokuyakukoumokuv160x29() {
        return zrntokuyakukoumokuv160x29;
    }

    public void setZrntokuyakukoumokuv160x29(String pZrntokuyakukoumokuv160x29) {
        zrntokuyakukoumokuv160x29 = pZrntokuyakukoumokuv160x29;
    }

    private String zrntokuyakukoumokuv160x30;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X30)
    public String getZrntokuyakukoumokuv160x30() {
        return zrntokuyakukoumokuv160x30;
    }

    public void setZrntokuyakukoumokuv160x30(String pZrntokuyakukoumokuv160x30) {
        zrntokuyakukoumokuv160x30 = pZrntokuyakukoumokuv160x30;
    }

    private String zrntokuyakukoumokuv160x31;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X31)
    public String getZrntokuyakukoumokuv160x31() {
        return zrntokuyakukoumokuv160x31;
    }

    public void setZrntokuyakukoumokuv160x31(String pZrntokuyakukoumokuv160x31) {
        zrntokuyakukoumokuv160x31 = pZrntokuyakukoumokuv160x31;
    }

    private String zrntokuyakukoumokuv160x32;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X32)
    public String getZrntokuyakukoumokuv160x32() {
        return zrntokuyakukoumokuv160x32;
    }

    public void setZrntokuyakukoumokuv160x32(String pZrntokuyakukoumokuv160x32) {
        zrntokuyakukoumokuv160x32 = pZrntokuyakukoumokuv160x32;
    }

    private String zrntokuyakukoumokuv160x33;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X33)
    public String getZrntokuyakukoumokuv160x33() {
        return zrntokuyakukoumokuv160x33;
    }

    public void setZrntokuyakukoumokuv160x33(String pZrntokuyakukoumokuv160x33) {
        zrntokuyakukoumokuv160x33 = pZrntokuyakukoumokuv160x33;
    }

    private String zrntokuyakukoumokuv160x34;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X34)
    public String getZrntokuyakukoumokuv160x34() {
        return zrntokuyakukoumokuv160x34;
    }

    public void setZrntokuyakukoumokuv160x34(String pZrntokuyakukoumokuv160x34) {
        zrntokuyakukoumokuv160x34 = pZrntokuyakukoumokuv160x34;
    }

    private String zrntokuyakukoumokuv160x35;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X35)
    public String getZrntokuyakukoumokuv160x35() {
        return zrntokuyakukoumokuv160x35;
    }

    public void setZrntokuyakukoumokuv160x35(String pZrntokuyakukoumokuv160x35) {
        zrntokuyakukoumokuv160x35 = pZrntokuyakukoumokuv160x35;
    }

    private String zrntokuyakukoumokuv160x36;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X36)
    public String getZrntokuyakukoumokuv160x36() {
        return zrntokuyakukoumokuv160x36;
    }

    public void setZrntokuyakukoumokuv160x36(String pZrntokuyakukoumokuv160x36) {
        zrntokuyakukoumokuv160x36 = pZrntokuyakukoumokuv160x36;
    }

    private String zrntokuyakukoumokuv160x37;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X37)
    public String getZrntokuyakukoumokuv160x37() {
        return zrntokuyakukoumokuv160x37;
    }

    public void setZrntokuyakukoumokuv160x37(String pZrntokuyakukoumokuv160x37) {
        zrntokuyakukoumokuv160x37 = pZrntokuyakukoumokuv160x37;
    }

    private String zrntokuyakukoumokuv160x38;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X38)
    public String getZrntokuyakukoumokuv160x38() {
        return zrntokuyakukoumokuv160x38;
    }

    public void setZrntokuyakukoumokuv160x38(String pZrntokuyakukoumokuv160x38) {
        zrntokuyakukoumokuv160x38 = pZrntokuyakukoumokuv160x38;
    }

    private String zrntokuyakukoumokuv160x39;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X39)
    public String getZrntokuyakukoumokuv160x39() {
        return zrntokuyakukoumokuv160x39;
    }

    public void setZrntokuyakukoumokuv160x39(String pZrntokuyakukoumokuv160x39) {
        zrntokuyakukoumokuv160x39 = pZrntokuyakukoumokuv160x39;
    }

    private String zrntokuyakukoumokuv160x40;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X40)
    public String getZrntokuyakukoumokuv160x40() {
        return zrntokuyakukoumokuv160x40;
    }

    public void setZrntokuyakukoumokuv160x40(String pZrntokuyakukoumokuv160x40) {
        zrntokuyakukoumokuv160x40 = pZrntokuyakukoumokuv160x40;
    }

    private String zrntokuyakukoumokuv160x41;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X41)
    public String getZrntokuyakukoumokuv160x41() {
        return zrntokuyakukoumokuv160x41;
    }

    public void setZrntokuyakukoumokuv160x41(String pZrntokuyakukoumokuv160x41) {
        zrntokuyakukoumokuv160x41 = pZrntokuyakukoumokuv160x41;
    }

    private String zrntokuyakukoumokuv160x42;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X42)
    public String getZrntokuyakukoumokuv160x42() {
        return zrntokuyakukoumokuv160x42;
    }

    public void setZrntokuyakukoumokuv160x42(String pZrntokuyakukoumokuv160x42) {
        zrntokuyakukoumokuv160x42 = pZrntokuyakukoumokuv160x42;
    }

    private String zrntokuyakukoumokuv160x43;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X43)
    public String getZrntokuyakukoumokuv160x43() {
        return zrntokuyakukoumokuv160x43;
    }

    public void setZrntokuyakukoumokuv160x43(String pZrntokuyakukoumokuv160x43) {
        zrntokuyakukoumokuv160x43 = pZrntokuyakukoumokuv160x43;
    }

    private String zrntokuyakukoumokuv160x44;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X44)
    public String getZrntokuyakukoumokuv160x44() {
        return zrntokuyakukoumokuv160x44;
    }

    public void setZrntokuyakukoumokuv160x44(String pZrntokuyakukoumokuv160x44) {
        zrntokuyakukoumokuv160x44 = pZrntokuyakukoumokuv160x44;
    }

    private String zrntokuyakukoumokuv160x45;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X45)
    public String getZrntokuyakukoumokuv160x45() {
        return zrntokuyakukoumokuv160x45;
    }

    public void setZrntokuyakukoumokuv160x45(String pZrntokuyakukoumokuv160x45) {
        zrntokuyakukoumokuv160x45 = pZrntokuyakukoumokuv160x45;
    }

    private String zrntokuyakukoumokuv160x46;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X46)
    public String getZrntokuyakukoumokuv160x46() {
        return zrntokuyakukoumokuv160x46;
    }

    public void setZrntokuyakukoumokuv160x46(String pZrntokuyakukoumokuv160x46) {
        zrntokuyakukoumokuv160x46 = pZrntokuyakukoumokuv160x46;
    }

    private String zrntokuyakukoumokuv160x47;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X47)
    public String getZrntokuyakukoumokuv160x47() {
        return zrntokuyakukoumokuv160x47;
    }

    public void setZrntokuyakukoumokuv160x47(String pZrntokuyakukoumokuv160x47) {
        zrntokuyakukoumokuv160x47 = pZrntokuyakukoumokuv160x47;
    }

    private String zrntokuyakukoumokuv160x48;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X48)
    public String getZrntokuyakukoumokuv160x48() {
        return zrntokuyakukoumokuv160x48;
    }

    public void setZrntokuyakukoumokuv160x48(String pZrntokuyakukoumokuv160x48) {
        zrntokuyakukoumokuv160x48 = pZrntokuyakukoumokuv160x48;
    }

    private String zrntokuyakukoumokuv160x49;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X49)
    public String getZrntokuyakukoumokuv160x49() {
        return zrntokuyakukoumokuv160x49;
    }

    public void setZrntokuyakukoumokuv160x49(String pZrntokuyakukoumokuv160x49) {
        zrntokuyakukoumokuv160x49 = pZrntokuyakukoumokuv160x49;
    }

    private String zrntokuyakukoumokuv160x50;

    @Column(name=GenZT_SkeisynyptoukeiksnRn.ZRNTOKUYAKUKOUMOKUV160X50)
    public String getZrntokuyakukoumokuv160x50() {
        return zrntokuyakukoumokuv160x50;
    }

    public void setZrntokuyakukoumokuv160x50(String pZrntokuyakukoumokuv160x50) {
        zrntokuyakukoumokuv160x50 = pZrntokuyakukoumokuv160x50;
    }
}