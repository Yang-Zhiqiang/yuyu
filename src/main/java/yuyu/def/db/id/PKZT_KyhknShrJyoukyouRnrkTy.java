package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KyhknShrJyoukyouRnrkTy;
import yuyu.def.db.mapping.GenZT_KyhknShrJyoukyouRnrkTy;
import yuyu.def.db.meta.GenQZT_KyhknShrJyoukyouRnrkTy;
import yuyu.def.db.meta.QZT_KyhknShrJyoukyouRnrkTy;

/**
 * 給付金支払状況連絡Fテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KyhknShrJyoukyouRnrkTy}</td><td colspan="3">給付金支払状況連絡Fテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyyobiv12</td><td>（中継用）予備項目Ｖ１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydatakanrino</td><td>（中継用）データ管理番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv4</td><td>（中継用）予備項目Ｖ４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytksyukgu</td><td>（中継用）特約種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakugatakbn</td><td>（中継用）特約型区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukisi</td><td>（中継用）特約期始</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyukigou</td><td>（中継用）保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytyuutohukakbn</td><td>（中継用）中途付加区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhyoukataikbn</td><td>（中継用）標下体区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatukaisisyatodouhukencd</td><td>（中継用）扱支社都道府県コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakusinkyuukbn</td><td>（中継用）特約新旧区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyym</td><td>（中継用）募集年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkykdai2hihokensyahyj</td><td>（中継用）特約第２被保険者表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuteisippeisethyj</td><td>（中継用）特定疾病セット表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjyusyousyaseibetukbn</td><td>（中継用）受傷者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykazokujyusyousyakbn</td><td>（中継用）家族受傷者区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakunen</td><td>（中継用）契約年令</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymannenreihyj</td><td>（中継用）満年令表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnentysihyj</td><td>（中継用）被保険者年令調整表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv2</td><td>（中継用）予備項目Ｖ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyuuhukbn</td><td>（中継用）給付区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysiharaijyoutaikbn</td><td>（中継用）支払状態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyouincd</td><td>（中継用）消因コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjikohasseiymd2</td><td>（中継用）事故発生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyougaikoteiymd</td><td>（中継用）傷害固定年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynyuuinymd</td><td>（中継用）入院年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrymd</td><td>（中継用）支払年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyuuhuwariai</td><td>（中継用）給付割合</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysiharaikingakun9</td><td>（中継用）支払金額Ｎ９</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztykyoukaihoukokuyoukingaku</td><td>（中継用）協会報告用金額</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztytuuinkakujyuuhukakbn</td><td>（中継用）通院カク充付加区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykangohukahyj</td><td>（中継用）看護付加表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysonsyoukyuuhukinkbn</td><td>（中継用）損傷給付金区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysiboukoudosyougaicd</td><td>（中継用）死亡高度障害コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyokikyuuhutandokushrhyj</td><td>（中継用）初期給付単独支払表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykakuseikyuuhukbn</td><td>（中継用）カク成給付区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysoukikeakyuuhutuusankisu</td><td>（中継用）早期ケア給付通算回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyonendokyuuhuwariai</td><td>（中継用）初年度給付割合</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyonendosiharaihyj</td><td>（中継用）初年度支払表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv4x2</td><td>（中継用）予備項目Ｖ４＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykousingohasseihyj</td><td>（中継用）更新後発生表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybyoumeicd1</td><td>（中継用）病名コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybyoumeicd2</td><td>（中継用）病名コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysaigaigenincd</td><td>（中継用）災害原因コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyougaitoukyuugou</td><td>（中継用）障害等級号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyujyutucd</td><td>（中継用）手術コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyujyutumeicd</td><td>（中継用）手術名コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytuuinkangogeninkbn</td><td>（中継用）通院看護原因区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyundoukisonsyoukbn</td><td>（中継用）運動器損傷区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyganmensonsyoukbn</td><td>（中継用）顔面損傷区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysonsyougeninkbn</td><td>（中継用）損傷原因区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykikensportskbn</td><td>（中継用）危険スポーツ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv2x2</td><td>（中継用）予備項目Ｖ２＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysiharainissuukbn</td><td>（中継用）支払日数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykakuseikatakbn</td><td>（中継用）カク成型区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyuukeirokbn</td><td>（中継用）募集経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypmenhutanpohyj</td><td>（中継用）Ｐ免不担保表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykousinkbn</td><td>（中継用）更新区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykusnmetkyksykipjyutuym</td><td>（中継用）更新前特約初回Ｐ充当年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytoukeiyousinsakbn</td><td>（中継用）統計用診査区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypmenhukakbn</td><td>（中継用）Ｐ免付加区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypmenkbnv2</td><td>（中継用）Ｐ免区分Ｖ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyketteikijyunkanwakbn</td><td>（中継用）決定基準緩和区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyuruikigousedaikbn</td><td>（中継用）保険種類記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakukigousedaikbn</td><td>（中継用）特約記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysotodasipmenkbn</td><td>（中継用）外出Ｐ免区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztystdssnskbn</td><td>（中継用）外出診査区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysotodasikousinkbn</td><td>（中継用）外出更新区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyuukeitaikbn</td><td>（中継用）募集形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv5</td><td>（中継用）予備項目Ｖ５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyqpackhyj</td><td>（中継用）Ｑパック表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybunkatukbn</td><td>（中継用）分割区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytenkanhosyouminaosikbn</td><td>（中継用）転換保障見直区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykousinmaesiharaihyj</td><td>（中継用）更新前支払表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydouitunyuuinno</td><td>（中継用）同一入院番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyujyutujinyuuinkbn</td><td>（中継用）手術時入院区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyujyutusyuruikbn</td><td>（中継用）手術種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygannyuuinkbn</td><td>（中継用）がん入院区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokenhoutekiyouhyouji</td><td>（中継用）保険法適用表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysotodasiphkbnmnoshyouji</td><td>（中継用）外出Ｐ不可分見直表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuteijyoutaihushrhyj</td><td>（中継用）特定状態不支払表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisyacd</td><td>（中継用）支社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysykgycd</td><td>（中継用）職業コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobiv11</td><td>（中継用）数理用予備項目Ｖ１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoukaigojyoutaikaisiymd</td><td>（中継用）要介護状態開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoukaigojyoutaiendymd</td><td>（中継用）要介護状態終了年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyrendouyousntkjyubbnhyj</td><td>（中継用）連動用新特条部分表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymusentakukeiyakukbn</td><td>（中継用）無選択契約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymaruteiskeijihukahyj</td><td>（中継用）マル定新契約時付加表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytoliplhyj</td><td>（中継用）ＴＯＬＩＰＬ表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztystdssytikbn</td><td>（中継用）外出集定区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhisei</td><td>（中継用）被性</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyobin9</td><td>（中継用）数理予備項目Ｎ９</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztysaigaisibousiharaikngk</td><td>（中継用）災害死亡支払金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytokuyakuhinen</td><td>（中継用）特約被年令</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygnykbttryukyuhkntusnkisu</td><td>（中継用）がん薬物治療給付金通算回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztygansyuruikbn</td><td>（中継用）がん種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyganyakubutusyuruikbn</td><td>（中継用）がん薬物種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyuuroukigjyujtjyutikbn</td><td>（中継用）就労介護充実状態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyuuroukigjyujtgeninkbn</td><td>（中継用）就労介護充実原因区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykigjyujtjyoutaigeninkbn</td><td>（中継用）介護充実状態原因区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysykmtssyukahikbn</td><td>（中継用）食物摂取可否区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfktrsmtkahikbn</td><td>（中継用）拭き取り始末可否区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokoukahikbn</td><td>（中継用）歩行可否区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynyykkahikbn</td><td>（中継用）入浴可否区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyihukutyakudatukahikbn</td><td>（中継用）衣服着脱可否区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyngerkahikbn</td><td>（中継用）寝返り可否区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyseiketuseiyoukahikbn</td><td>（中継用）清潔整容可否区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynintisyougeninkbn</td><td>（中継用）認知症原因区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyuruhnujyujtjyutikbn</td><td>（中継用）就労不能充実状態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuteisyougaikbn</td><td>（中継用）特定障害区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydatakanrino2</td><td>（中継用）データ管理番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydatakanrino3</td><td>（中継用）データ管理番号３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknkuzusnzyrttekitkarihyj</td><td>（中継用）健康増進乗率適用特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybluekeizokuhyouji</td><td>（中継用）Ｂｌｕｅ継続表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzyrthntiyustatuskbn</td><td>（中継用）乗率判定用ステータス区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzyrthntiyustatuskbnx2</td><td>（中継用）乗率判定用ステータス区分＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzyrthntiyustatuskbnx3</td><td>（中継用）乗率判定用ステータス区分＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzyrthntiyustatuskbnx4</td><td>（中継用）乗率判定用ステータス区分＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzyrthntiyustatuskbnx5</td><td>（中継用）乗率判定用ステータス区分＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknkuzusnzyrt</td><td>（中継用）健康増進乗率</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknkuzusnzyrtx2</td><td>（中継用）健康増進乗率＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysinkeiyakujivithkhyouji</td><td>（中継用）新契約時Ｖｉｔ保険表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypwrbksidhitekiyouhyj</td><td>（中継用）保険料割引制度非適用表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymd</td><td>（中継用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuuriyouyobin4</td><td>（中継用）数理用予備項目Ｎ４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyraysystemhyj</td><td>（中継用）ＲＡＹシステム表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygaikakbn</td><td>（中継用）外貨区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykawaserate</td><td>（中継用）為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykawaseratetekiyouymd</td><td>（中継用）為替レート適用年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakujiyoteiriritu</td><td>（中継用）契約時予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztygaikadatesiharais</td><td>（中継用）外貨建支払Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygaikadatesyukeiyakus</td><td>（中継用）外貨建主契約Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygaikadatesyukeiyakup</td><td>（中継用）外貨建主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyenkdtsbujsitihsyukngk</td><td>（中継用）円貨建死亡時最低保証金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysuuriyouyobin10</td><td>（中継用）数理用予備項目Ｎ１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv10x2</td><td>（中継用）予備項目Ｖ１０＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymvatyouseigow</td><td>（中継用）ＭＶＡ調整後Ｗ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztymvakeisanjisknnjynbkn</td><td>（中継用）ＭＶＡ計算時責任準備金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv6</td><td>（中継用）予備項目Ｖ６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KyhknShrJyoukyouRnrkTy
 * @see     GenZT_KyhknShrJyoukyouRnrkTy
 * @see     QZT_KyhknShrJyoukyouRnrkTy
 * @see     GenQZT_KyhknShrJyoukyouRnrkTy
 */
public class PKZT_KyhknShrJyoukyouRnrkTy extends AbstractExDBPrimaryKey<ZT_KyhknShrJyoukyouRnrkTy, PKZT_KyhknShrJyoukyouRnrkTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_KyhknShrJyoukyouRnrkTy() {
    }

    public PKZT_KyhknShrJyoukyouRnrkTy(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

    @Transient
    @Override
    public Class<ZT_KyhknShrJyoukyouRnrkTy> getEntityClass() {
        return ZT_KyhknShrJyoukyouRnrkTy.class;
    }

    private Integer ztysequenceno;

    public Integer getZtysequenceno() {
        return ztysequenceno;
    }

    public void setZtysequenceno(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

}