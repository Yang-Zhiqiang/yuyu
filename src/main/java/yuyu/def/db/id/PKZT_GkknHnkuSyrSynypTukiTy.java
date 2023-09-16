package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_GkknHnkuSyrSynypTukiTy;
import yuyu.def.db.mapping.GenZT_GkknHnkuSyrSynypTukiTy;
import yuyu.def.db.meta.GenQZT_GkknHnkuSyrSynypTukiTy;
import yuyu.def.db.meta.QZT_GkknHnkuSyrSynypTukiTy;

/**
 * 月間変更処理収入Ｐ統計Fテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_GkknHnkuSyrSynypTukiTy}</td><td colspan="3">月間変更処理収入Ｐ統計Fテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyyuukourecordlength</td><td>（中継用）有効レコード長</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyrdwarea</td><td>（中継用）ＲＤＷ領域</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydatakanrino</td><td>（中継用）データ管理番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoricd</td><td>（中継用）処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyrendoukbn</td><td>（中継用）連動区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv1</td><td>（中継用）予備項目Ｖ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyuunoukeirokbn</td><td>（中継用）収納経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuitousisya</td><td>（中継用）出納支社</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyuukinym</td><td>（中継用）集金年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjyuutouym</td><td>（中継用）充当年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjyuutoukaisuu</td><td>（中継用）充当回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennoukbn</td><td>（中継用）前納区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysetkykkbn</td><td>（中継用）セット契約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybankikkatuhyouji</td><td>（中継用）バンク一括表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyrecordkbn</td><td>（中継用）レコード区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytnknmnosjtikbbnjyutukbn</td><td>（中継用）転換見直時定期部分充当区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysetrenseimrtikatakbn</td><td>（中継用）セット連生マル定型区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhaitoukbn</td><td>（中継用）配当区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyukeiyakupwaribikikbnx2</td><td>（中継用）主契約Ｐ割引区分＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysykyktnknyugukbnx2</td><td>（中継用）主契約転換優遇区分＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysetkaigomaruteikatakbn</td><td>（中継用）セット介護マル定型区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydenymd</td><td>（中継用）伝票日付</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyonendosyokaip</td><td>（中継用）初年度初回Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyonendo2kaimeikoup</td><td>（中継用）初年度２回目以降Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyjinendoikoup</td><td>（中継用）次年度以降Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhknsyukigou</td><td>（中継用）保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysaimnkkykhyj</td><td>（中継用）才満期契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknkkn</td><td>（中継用）保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyphrkkikn</td><td>（中継用）Ｐ払込期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhihokensyaagev2</td><td>（中継用）被保険者年令Ｖ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyanen</td><td>（中継用）契約者年令</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymd</td><td>（中継用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseikbn</td><td>（中継用）被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyannaifuyouriyuukbn</td><td>（中継用）案内不要理由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkaisuukbn</td><td>（中継用）払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysdpdkbn</td><td>（中継用）Ｓ建Ｐ建区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyryouritukbn</td><td>（中継用）料率区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytksyuannaikykkbn</td><td>（中継用）特殊案内契約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2hhknnen</td><td>（中継用）第２被保険者年令</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyuruikigousedaikbn</td><td>（中継用）保険種類記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypmenhukakbn</td><td>（中継用）Ｐ免付加区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhosyouikkatumnoshyouji</td><td>（中継用）保障一括見直表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv1x2</td><td>（中継用）予備項目Ｖ１＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihons</td><td>（中継用）基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygoukeitenkans</td><td>（中継用）合計転換Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhngknksaiteihosyukngk</td><td>（中継用）変額年金最低保証金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyaatukaisosikicd</td><td>（中継用）Ａ扱者組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyaatukaikojincd</td><td>（中継用）Ａ扱者個人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyym</td><td>（中継用）募集年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyharaikomip</td><td>（中継用）払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyukeiyakup</td><td>（中継用）主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytokujyoup</td><td>（中継用）特条Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyitibuitijibarais</td><td>（中継用）一部一時払Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyitibuitijibaraip</td><td>（中継用）一部一時払Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygoukeitenkanteikis</td><td>（中継用）合計転換定期Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyuunoukbn</td><td>（中継用）収納区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkykkumkhnsyukosuu</td><td>（中継用）特約項目編集個数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztysiteizukipwarimasihyouji</td><td>（中継用）指定月Ｐ割増表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypwarimasisiteim1</td><td>（中継用）Ｐ割増指定月１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypwarimasisiteim2</td><td>（中継用）Ｐ割増指定月２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysiteimsykykpbairitu</td><td>（中継用）指定月主契約Ｐ倍率</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysiteizukisyukeiyakup</td><td>（中継用）指定月主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysiteizukiharaikomip</td><td>（中継用）指定月払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysaisyuusiteimhrkp</td><td>（中継用）最終指定月払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysaisyuusiteiym</td><td>（中継用）最終指定年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyanniskcd</td><td>（中継用）案内先コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytumitateriritu</td><td>（中継用）積立利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztysitihsyuriritu</td><td>（中継用）最低保証利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztynkgnsritu</td><td>（中継用）年金原資率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztysinnyuukinkbn</td><td>（中継用）新入金区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydfnyuukinkbn</td><td>（中継用）ＤＦ入金区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytorikuzusip</td><td>（中継用）取崩Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykbnkeiriyousegmentcd</td><td>（中継用）区分経理用セグメントコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysykikykjkykym</td><td>（中継用）初回契約時契約年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydfkijyunkingaku</td><td>（中継用）ＤＦ基準金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztystdssytikbn</td><td>（中継用）外出集定区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysotodasimanagehyouji</td><td>（中継用）外出満年令表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysotodasiphkbnmnoshyouji</td><td>（中継用）外出Ｐ不可分見直表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztystdsstkjytkyuhyj</td><td>（中継用）外出新特条適用表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykousinmanryouage</td><td>（中継用）更新満了年令</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknkuzusnzyrttekitkarihyj</td><td>（中継用）健康増進乗率適用特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknkuzusnzyrt</td><td>（中継用）健康増進乗率</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytenkanjiknkuzusnzyrt</td><td>（中継用）転換時健康増進乗率</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypwrbksidhitekiyouhyj</td><td>（中継用）保険料割引制度非適用表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin1x2</td><td>（中継用）数理用予備項目Ｎ１＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzyrthntiyustatuskbn</td><td>（中継用）乗率判定用ステータス区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv9</td><td>（中継用）予備項目Ｖ９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysotodasipmenkbn</td><td>（中継用）外出Ｐ免区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokubetuhosyoukikan</td><td>（中継用）特別保障期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin7</td><td>（中継用）数理用予備項目Ｎ７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyphireilkeisanyoup</td><td>（中継用）Ｐ比例Ｌ計算用Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11</td><td>（中継用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x2</td><td>（中継用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x3</td><td>（中継用）予備項目Ｎ１１＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x4</td><td>（中継用）予備項目Ｎ１１＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztycashlesshyj</td><td>（中継用）キャッシュレス表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykjiqpackhyj</td><td>（中継用）契約時Ｑパック表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytenkanminaosikbn</td><td>（中継用）転換見直区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnentysihyj</td><td>（中継用）被保険者年令調整表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2hhknnentysihyj</td><td>（中継用）第２被保険者年令調整表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyaagetyouseihyj</td><td>（中継用）契約者年令調整表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysykykhokenhoutekiyouhyj</td><td>（中継用）主契約保険法適用表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrimngtkykphrkkaisuukbn</td><td>（中継用）払満後特約Ｐ払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjidoukousinhyouji</td><td>（中継用）自動更新表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin1</td><td>（中継用）数理用予備項目Ｎ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkjykbn</td><td>（中継用）特条区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2tokujyoukbn</td><td>（中継用）第２特条区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyryoumasihyouten</td><td>（中継用）料増標点</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztydai2ryoumasihyouten</td><td>（中継用）第２料増標点</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztysuuriyouyobin2</td><td>（中継用）数理用予備項目Ｎ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin10</td><td>（中継用）数理用予備項目Ｎ１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin10x2</td><td>（中継用）数理用予備項目Ｎ１０＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin10x3</td><td>（中継用）数理用予備項目Ｎ１０＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin10x4</td><td>（中継用）数理用予備項目Ｎ１０＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv10x6</td><td>（中継用）予備項目Ｖ１０＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv10x7</td><td>（中継用）予備項目Ｖ１０＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv10x8</td><td>（中継用）予備項目Ｖ１０＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv10x9</td><td>（中継用）予備項目Ｖ１０＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv10x10</td><td>（中継用）予備項目Ｖ１０＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv10x11</td><td>（中継用）予備項目Ｖ１０＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyuukeitaikbn</td><td>（中継用）募集形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrimngtkykphrkkirkbn</td><td>（中継用）払満後特約Ｐ払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrimngtkykpryurtkbn</td><td>（中継用）払満後特約Ｐ料率区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyukeiyakusyuruicdv3</td><td>（中継用）主契約種類コードＶ３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobin11x5</td><td>（中継用）予備項目Ｎ１１＿５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x6</td><td>（中継用）予備項目Ｎ１１＿６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x7</td><td>（中継用）予備項目Ｎ１１＿７</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x8</td><td>（中継用）予備項目Ｎ１１＿８</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x9</td><td>（中継用）予備項目Ｎ１１＿９</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyraysystemhyj</td><td>（中継用）ＲＡＹシステム表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygaikakbn</td><td>（中継用）外貨区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykjikawaserate</td><td>（中継用）契約時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykykjikawaseratetkyuymd</td><td>（中継用）契約時為替レート適用年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakujiyoteiriritu</td><td>（中継用）契約時予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyenkdtsbujsitihsyukngk</td><td>（中継用）円貨建死亡時最低保証金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynyuukintuukakbn</td><td>（中継用）入金通貨区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuurendourate</td><td>（中継用）指数連動部分割合</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuukbn</td><td>（中継用）指数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynyknjikawaserate</td><td>（中継用）入金時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztynyknjikawaseratetkyuymd</td><td>（中継用）入金時為替レート適用年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysrdai1hknkkn</td><td>（中継用）数理用第１保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin10x5</td><td>（中継用）数理用予備項目Ｎ１０＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytuukasyukbn</td><td>（中継用）通貨種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv9x2</td><td>（中継用）予備項目Ｖ９＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv10x16</td><td>（中継用）予備項目Ｖ１０＿１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkgns</td><td>（中継用）年金原資</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysisuubbntounyuugk</td><td>（中継用）指数部分投入金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysaisinyoteiriritu</td><td>（中継用）最新予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyyobin5</td><td>（中継用）予備項目Ｎ５</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyyobin11x10</td><td>（中継用）予備項目Ｎ１１＿１０</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykiharaikomip</td><td>（中継用）既払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytumitatekin</td><td>（中継用）積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyzennoujiikkatubaraijytgk</td><td>（中継用）前納時一括払充当額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygaikadatenkgns</td><td>（中継用）外貨建年金原資</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygaikadatesyukeiyakup</td><td>（中継用）外貨建主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv1x3</td><td>（中継用）予備項目Ｖ１＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160</td><td>（中継用）特約項目Ｖ１６０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x2</td><td>（中継用）特約項目Ｖ１６０＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x3</td><td>（中継用）特約項目Ｖ１６０＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x4</td><td>（中継用）特約項目Ｖ１６０＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x5</td><td>（中継用）特約項目Ｖ１６０＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x6</td><td>（中継用）特約項目Ｖ１６０＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x7</td><td>（中継用）特約項目Ｖ１６０＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x8</td><td>（中継用）特約項目Ｖ１６０＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x9</td><td>（中継用）特約項目Ｖ１６０＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x10</td><td>（中継用）特約項目Ｖ１６０＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x11</td><td>（中継用）特約項目Ｖ１６０＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x12</td><td>（中継用）特約項目Ｖ１６０＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x13</td><td>（中継用）特約項目Ｖ１６０＿１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x14</td><td>（中継用）特約項目Ｖ１６０＿１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x15</td><td>（中継用）特約項目Ｖ１６０＿１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x16</td><td>（中継用）特約項目Ｖ１６０＿１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x17</td><td>（中継用）特約項目Ｖ１６０＿１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x18</td><td>（中継用）特約項目Ｖ１６０＿１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x19</td><td>（中継用）特約項目Ｖ１６０＿１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x20</td><td>（中継用）特約項目Ｖ１６０＿２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x21</td><td>（中継用）特約項目Ｖ１６０＿２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x22</td><td>（中継用）特約項目Ｖ１６０＿２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x23</td><td>（中継用）特約項目Ｖ１６０＿２３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x24</td><td>（中継用）特約項目Ｖ１６０＿２４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x25</td><td>（中継用）特約項目Ｖ１６０＿２５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x26</td><td>（中継用）特約項目Ｖ１６０＿２６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x27</td><td>（中継用）特約項目Ｖ１６０＿２７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x28</td><td>（中継用）特約項目Ｖ１６０＿２８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x29</td><td>（中継用）特約項目Ｖ１６０＿２９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x30</td><td>（中継用）特約項目Ｖ１６０＿３０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x31</td><td>（中継用）特約項目Ｖ１６０＿３１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x32</td><td>（中継用）特約項目Ｖ１６０＿３２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x33</td><td>（中継用）特約項目Ｖ１６０＿３３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x34</td><td>（中継用）特約項目Ｖ１６０＿３４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x35</td><td>（中継用）特約項目Ｖ１６０＿３５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x36</td><td>（中継用）特約項目Ｖ１６０＿３６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x37</td><td>（中継用）特約項目Ｖ１６０＿３７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x38</td><td>（中継用）特約項目Ｖ１６０＿３８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x39</td><td>（中継用）特約項目Ｖ１６０＿３９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x40</td><td>（中継用）特約項目Ｖ１６０＿４０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x41</td><td>（中継用）特約項目Ｖ１６０＿４１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x42</td><td>（中継用）特約項目Ｖ１６０＿４２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x43</td><td>（中継用）特約項目Ｖ１６０＿４３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x44</td><td>（中継用）特約項目Ｖ１６０＿４４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x45</td><td>（中継用）特約項目Ｖ１６０＿４５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x46</td><td>（中継用）特約項目Ｖ１６０＿４６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x47</td><td>（中継用）特約項目Ｖ１６０＿４７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x48</td><td>（中継用）特約項目Ｖ１６０＿４８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x49</td><td>（中継用）特約項目Ｖ１６０＿４９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukoumokuv160x50</td><td>（中継用）特約項目Ｖ１６０＿５０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_GkknHnkuSyrSynypTukiTy
 * @see     GenZT_GkknHnkuSyrSynypTukiTy
 * @see     QZT_GkknHnkuSyrSynypTukiTy
 * @see     GenQZT_GkknHnkuSyrSynypTukiTy
 */
public class PKZT_GkknHnkuSyrSynypTukiTy extends AbstractExDBPrimaryKey<ZT_GkknHnkuSyrSynypTukiTy, PKZT_GkknHnkuSyrSynypTukiTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_GkknHnkuSyrSynypTukiTy() {
    }

    public PKZT_GkknHnkuSyrSynypTukiTy(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

    @Transient
    @Override
    public Class<ZT_GkknHnkuSyrSynypTukiTy> getEntityClass() {
        return ZT_GkknHnkuSyrSynypTukiTy.class;
    }

    private Integer ztysequenceno;

    public Integer getZtysequenceno() {
        return ztysequenceno;
    }

    public void setZtysequenceno(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

}