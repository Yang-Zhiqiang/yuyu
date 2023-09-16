package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_GkknHnkuSyrSynypTukiRn;
import yuyu.def.db.mapping.GenZT_GkknHnkuSyrSynypTukiRn;
import yuyu.def.db.meta.GenQZT_GkknHnkuSyrSynypTukiRn;
import yuyu.def.db.meta.QZT_GkknHnkuSyrSynypTukiRn;

/**
 * 月間変更処理収入Ｐ統計Fテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_GkknHnkuSyrSynypTukiRn}</td><td colspan="3">月間変更処理収入Ｐ統計Fテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnyuukourecordlength</td><td>（連携用）有効レコード長</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnrdwarea</td><td>（連携用）ＲＤＷ領域</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndatakanrino</td><td>（連携用）データ管理番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoricd</td><td>（連携用）処理コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnrendoukbn</td><td>（連携用）連動区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv1</td><td>（連携用）予備項目Ｖ１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyuunoukeirokbn</td><td>（連携用）収納経路区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuitousisya</td><td>（連携用）出納支社</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyuukinym</td><td>（連携用）集金年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjyuutouym</td><td>（連携用）充当年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjyuutoukaisuu</td><td>（連携用）充当回数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennoukbn</td><td>（連携用）前納区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsetkykkbn</td><td>（連携用）セット契約区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbankikkatuhyouji</td><td>（連携用）バンク一括表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnrecordkbn</td><td>（連携用）レコード区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntnknmnosjtikbbnjyutukbn</td><td>（連携用）転換見直時定期部分充当区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsetrenseimrtikatakbn</td><td>（連携用）セット連生マル定型区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhaitoukbn</td><td>（連携用）配当区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyukeiyakupwaribikikbnx2</td><td>（連携用）主契約Ｐ割引区分＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsykyktnknyugukbnx2</td><td>（連携用）主契約転換優遇区分＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsetkaigomaruteikatakbn</td><td>（連携用）セット介護マル定型区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndenymd</td><td>（連携用）伝票日付</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyonendosyokaip</td><td>（連携用）初年度初回Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyonendo2kaimeikoup</td><td>（連携用）初年度２回目以降Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnjinendoikoup</td><td>（連携用）次年度以降Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhknsyukigou</td><td>（連携用）保険種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsaimnkkykhyj</td><td>（連携用）才満期契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknkkn</td><td>（連携用）保険期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnphrkkikn</td><td>（連携用）Ｐ払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhihokensyaagev2</td><td>（連携用）被保険者年令Ｖ２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyanen</td><td>（連携用）契約者年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykymd</td><td>（連携用）契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknseikbn</td><td>（連携用）被保険者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnannaifuyouriyuukbn</td><td>（連携用）案内不要理由区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkaisuukbn</td><td>（連携用）払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsdpdkbn</td><td>（連携用）Ｓ建Ｐ建区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnryouritukbn</td><td>（連携用）料率区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntksyuannaikykkbn</td><td>（連携用）特殊案内契約区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2hhknnen</td><td>（連携用）第２被保険者年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyuruikigousedaikbn</td><td>（連携用）保険種類記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpmenhukakbn</td><td>（連携用）Ｐ免付加区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhosyouikkatumnoshyouji</td><td>（連携用）保障一括見直表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv1x2</td><td>（連携用）予備項目Ｖ１＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihons</td><td>（連携用）基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngoukeitenkans</td><td>（連携用）合計転換Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhngknksaiteihosyukngk</td><td>（連携用）変額年金最低保証金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnaatukaisosikicd</td><td>（連携用）Ａ扱者組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnaatukaikojincd</td><td>（連携用）Ａ扱者個人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsyym</td><td>（連携用）募集年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnharaikomip</td><td>（連携用）払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyukeiyakup</td><td>（連携用）主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntokujyoup</td><td>（連携用）特条Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnitibuitijibarais</td><td>（連携用）一部一時払Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnitibuitijibaraip</td><td>（連携用）一部一時払Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngoukeitenkanteikis</td><td>（連携用）合計転換定期Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyuunoukbn</td><td>（連携用）収納区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkykkumkhnsyukosuu</td><td>（連携用）特約項目編集個数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnsiteizukipwarimasihyouji</td><td>（連携用）指定月Ｐ割増表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpwarimasisiteim1</td><td>（連携用）Ｐ割増指定月１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpwarimasisiteim2</td><td>（連携用）Ｐ割増指定月２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiteimsykykpbairitu</td><td>（連携用）指定月主契約Ｐ倍率</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiteizukisyukeiyakup</td><td>（連携用）指定月主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsiteizukiharaikomip</td><td>（連携用）指定月払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsaisyuusiteimhrkp</td><td>（連携用）最終指定月払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsaisyuusiteiym</td><td>（連携用）最終指定年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnanniskcd</td><td>（連携用）案内先コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntumitateriritu</td><td>（連携用）積立利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnsitihsyuriritu</td><td>（連携用）最低保証利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnnkgnsritu</td><td>（連携用）年金原資率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnsinnyuukinkbn</td><td>（連携用）新入金区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndfnyuukinkbn</td><td>（連携用）ＤＦ入金区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntorikuzusip</td><td>（連携用）取崩Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkbnkeiriyousegmentcd</td><td>（連携用）区分経理用セグメントコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsykikykjkykym</td><td>（連携用）初回契約時契約年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndfkijyunkingaku</td><td>（連携用）ＤＦ基準金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnstdssytikbn</td><td>（連携用）外出集定区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsotodasimanagehyouji</td><td>（連携用）外出満年令表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsotodasiphkbnmnoshyouji</td><td>（連携用）外出Ｐ不可分見直表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnstdsstkjytkyuhyj</td><td>（連携用）外出新特条適用表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkousinmanryouage</td><td>（連携用）更新満了年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknkuzusnzyrttekitkarihyj</td><td>（連携用）健康増進乗率適用特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknkuzusnzyrt</td><td>（連携用）健康増進乗率</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntenkanjiknkuzusnzyrt</td><td>（連携用）転換時健康増進乗率</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpwrbksidhitekiyouhyj</td><td>（連携用）保険料割引制度非適用表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuuriyouyobin1x2</td><td>（連携用）数理用予備項目Ｎ１＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzyrthntiyustatuskbn</td><td>（連携用）乗率判定用ステータス区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv9</td><td>（連携用）予備項目Ｖ９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsotodasipmenkbn</td><td>（連携用）外出Ｐ免区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokubetuhosyoukikan</td><td>（連携用）特別保障期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuuriyouyobin7</td><td>（連携用）数理用予備項目Ｎ７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnphireilkeisanyoup</td><td>（連携用）Ｐ比例Ｌ計算用Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11</td><td>（連携用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x2</td><td>（連携用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x3</td><td>（連携用）予備項目Ｎ１１＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x4</td><td>（連携用）予備項目Ｎ１１＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrncashlesshyj</td><td>（連携用）キャッシュレス表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykjiqpackhyj</td><td>（連携用）契約時Ｑパック表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntenkanminaosikbn</td><td>（連携用）転換見直区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnentysihyj</td><td>（連携用）被保険者年令調整表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2hhknnentysihyj</td><td>（連携用）第２被保険者年令調整表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyaagetyouseihyj</td><td>（連携用）契約者年令調整表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsykykhokenhoutekiyouhyj</td><td>（連携用）主契約保険法適用表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrimngtkykphrkkaisuukbn</td><td>（連携用）払満後特約Ｐ払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjidoukousinhyouji</td><td>（連携用）自動更新表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuuriyouyobin1</td><td>（連携用）数理用予備項目Ｎ１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkjykbn</td><td>（連携用）特条区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2tokujyoukbn</td><td>（連携用）第２特条区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnryoumasihyouten</td><td>（連携用）料増標点</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrndai2ryoumasihyouten</td><td>（連携用）第２料増標点</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnsuuriyouyobin2</td><td>（連携用）数理用予備項目Ｎ２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuuriyouyobin10</td><td>（連携用）数理用予備項目Ｎ１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuuriyouyobin10x2</td><td>（連携用）数理用予備項目Ｎ１０＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuuriyouyobin10x3</td><td>（連携用）数理用予備項目Ｎ１０＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuuriyouyobin10x4</td><td>（連携用）数理用予備項目Ｎ１０＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv10x6</td><td>（連携用）予備項目Ｖ１０＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv10x7</td><td>（連携用）予備項目Ｖ１０＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv10x8</td><td>（連携用）予備項目Ｖ１０＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv10x9</td><td>（連携用）予備項目Ｖ１０＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv10x10</td><td>（連携用）予備項目Ｖ１０＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv10x11</td><td>（連携用）予備項目Ｖ１０＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuukeitaikbn</td><td>（連携用）募集形態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrimngtkykphrkkirkbn</td><td>（連携用）払満後特約Ｐ払込経路区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrimngtkykpryurtkbn</td><td>（連携用）払満後特約Ｐ料率区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyukeiyakusyuruicdv3</td><td>（連携用）主契約種類コードＶ３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobin11x5</td><td>（連携用）予備項目Ｎ１１＿５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x6</td><td>（連携用）予備項目Ｎ１１＿６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x7</td><td>（連携用）予備項目Ｎ１１＿７</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x8</td><td>（連携用）予備項目Ｎ１１＿８</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x9</td><td>（連携用）予備項目Ｎ１１＿９</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnraysystemhyj</td><td>（連携用）ＲＡＹシステム表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngaikakbn</td><td>（連携用）外貨区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykjikawaserate</td><td>（連携用）契約時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnkykjikawaseratetkyuymd</td><td>（連携用）契約時為替レート適用年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeiyakujiyoteiriritu</td><td>（連携用）契約時予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnenkdtsbujsitihsyukngk</td><td>（連携用）円貨建死亡時最低保証金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnyuukintuukakbn</td><td>（連携用）入金通貨区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuurendourate</td><td>（連携用）指数連動部分割合</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuukbn</td><td>（連携用）指数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyknjikawaserate</td><td>（連携用）入金時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnnyknjikawaseratetkyuymd</td><td>（連携用）入金時為替レート適用年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsrdai1hknkkn</td><td>（連携用）数理用第１保険期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuuriyouyobin10x5</td><td>（連携用）数理用予備項目Ｎ１０＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntuukasyukbn</td><td>（連携用）通貨種類区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv9x2</td><td>（連携用）予備項目Ｖ９＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv10x16</td><td>（連携用）予備項目Ｖ１０＿１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkgns</td><td>（連携用）年金原資</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsisuubbntounyuugk</td><td>（連携用）指数部分投入金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsaisinyoteiriritu</td><td>（連携用）最新予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnyobin5</td><td>（連携用）予備項目Ｎ５</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnyobin11x10</td><td>（連携用）予備項目Ｎ１１＿１０</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkiharaikomip</td><td>（連携用）既払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntumitatekin</td><td>（連携用）積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnzennoujiikkatubaraijytgk</td><td>（連携用）前納時一括払充当額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngaikadatenkgns</td><td>（連携用）外貨建年金原資</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngaikadatesyukeiyakup</td><td>（連携用）外貨建主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv1x3</td><td>（連携用）予備項目Ｖ１＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160</td><td>（連携用）特約項目Ｖ１６０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x2</td><td>（連携用）特約項目Ｖ１６０＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x3</td><td>（連携用）特約項目Ｖ１６０＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x4</td><td>（連携用）特約項目Ｖ１６０＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x5</td><td>（連携用）特約項目Ｖ１６０＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x6</td><td>（連携用）特約項目Ｖ１６０＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x7</td><td>（連携用）特約項目Ｖ１６０＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x8</td><td>（連携用）特約項目Ｖ１６０＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x9</td><td>（連携用）特約項目Ｖ１６０＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x10</td><td>（連携用）特約項目Ｖ１６０＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x11</td><td>（連携用）特約項目Ｖ１６０＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x12</td><td>（連携用）特約項目Ｖ１６０＿１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x13</td><td>（連携用）特約項目Ｖ１６０＿１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x14</td><td>（連携用）特約項目Ｖ１６０＿１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x15</td><td>（連携用）特約項目Ｖ１６０＿１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x16</td><td>（連携用）特約項目Ｖ１６０＿１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x17</td><td>（連携用）特約項目Ｖ１６０＿１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x18</td><td>（連携用）特約項目Ｖ１６０＿１８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x19</td><td>（連携用）特約項目Ｖ１６０＿１９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x20</td><td>（連携用）特約項目Ｖ１６０＿２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x21</td><td>（連携用）特約項目Ｖ１６０＿２１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x22</td><td>（連携用）特約項目Ｖ１６０＿２２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x23</td><td>（連携用）特約項目Ｖ１６０＿２３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x24</td><td>（連携用）特約項目Ｖ１６０＿２４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x25</td><td>（連携用）特約項目Ｖ１６０＿２５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x26</td><td>（連携用）特約項目Ｖ１６０＿２６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x27</td><td>（連携用）特約項目Ｖ１６０＿２７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x28</td><td>（連携用）特約項目Ｖ１６０＿２８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x29</td><td>（連携用）特約項目Ｖ１６０＿２９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x30</td><td>（連携用）特約項目Ｖ１６０＿３０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x31</td><td>（連携用）特約項目Ｖ１６０＿３１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x32</td><td>（連携用）特約項目Ｖ１６０＿３２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x33</td><td>（連携用）特約項目Ｖ１６０＿３３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x34</td><td>（連携用）特約項目Ｖ１６０＿３４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x35</td><td>（連携用）特約項目Ｖ１６０＿３５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x36</td><td>（連携用）特約項目Ｖ１６０＿３６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x37</td><td>（連携用）特約項目Ｖ１６０＿３７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x38</td><td>（連携用）特約項目Ｖ１６０＿３８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x39</td><td>（連携用）特約項目Ｖ１６０＿３９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x40</td><td>（連携用）特約項目Ｖ１６０＿４０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x41</td><td>（連携用）特約項目Ｖ１６０＿４１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x42</td><td>（連携用）特約項目Ｖ１６０＿４２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x43</td><td>（連携用）特約項目Ｖ１６０＿４３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x44</td><td>（連携用）特約項目Ｖ１６０＿４４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x45</td><td>（連携用）特約項目Ｖ１６０＿４５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x46</td><td>（連携用）特約項目Ｖ１６０＿４６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x47</td><td>（連携用）特約項目Ｖ１６０＿４７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x48</td><td>（連携用）特約項目Ｖ１６０＿４８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x49</td><td>（連携用）特約項目Ｖ１６０＿４９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakukoumokuv160x50</td><td>（連携用）特約項目Ｖ１６０＿５０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_GkknHnkuSyrSynypTukiRn
 * @see     GenZT_GkknHnkuSyrSynypTukiRn
 * @see     QZT_GkknHnkuSyrSynypTukiRn
 * @see     GenQZT_GkknHnkuSyrSynypTukiRn
 */
public class PKZT_GkknHnkuSyrSynypTukiRn extends AbstractExDBPrimaryKey<ZT_GkknHnkuSyrSynypTukiRn, PKZT_GkknHnkuSyrSynypTukiRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_GkknHnkuSyrSynypTukiRn() {
    }

    public PKZT_GkknHnkuSyrSynypTukiRn(Integer pZrnsequenceno) {
        zrnsequenceno = pZrnsequenceno;
    }

    @Transient
    @Override
    public Class<ZT_GkknHnkuSyrSynypTukiRn> getEntityClass() {
        return ZT_GkknHnkuSyrSynypTukiRn.class;
    }

    private Integer zrnsequenceno;

    public Integer getZrnsequenceno() {
        return zrnsequenceno;
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        zrnsequenceno = pZrnsequenceno;
    }

}