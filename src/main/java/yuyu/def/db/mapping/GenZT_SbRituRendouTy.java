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
import yuyu.def.db.entity.ZT_SbRituRendouTy;
import yuyu.def.db.id.PKZT_SbRituRendouTy;
import yuyu.def.db.meta.GenQZT_SbRituRendouTy;
import yuyu.def.db.meta.QZT_SbRituRendouTy;

/**
 * 死亡率用連動Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_SbRituRendouTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SbRituRendouTy}</td><td colspan="3">死亡率用連動Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyobiv12x7 ztyyobiv12x7}</td><td>（中継用）予備項目Ｖ１２＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydatakanrino ztydatakanrino}</td><td>（中継用）データ管理番号</td><td align="center">{@link PKZT_SbRituRendouTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaimnkkykhyj ztysaimnkkykhyj}</td><td>（中継用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrendouyoukikan ztyrendouyoukikan}</td><td>（中継用）連動用期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhihokensyaagev2 ztyhihokensyaagev2}</td><td>（中継用）被保険者年令Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrendouyoukeiyakunengetu ztyrendouyoukeiyakunengetu}</td><td>（中継用）連動用契約年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrendouyoukihons ztyrendouyoukihons}</td><td>（中継用）連動用基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyrendouyousibous ztyrendouyousibous}</td><td>（中継用）連動用死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtytnknitjbrigisbus ztytnknitjbrigisbus}</td><td>（中継用）転換一時払以外死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtytenkanminaosikbn ztytenkanminaosikbn}</td><td>（中継用）転換見直区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrendouyouhrkhouhoukbn ztyrendouyouhrkhouhoukbn}</td><td>（中継用）連動用払込方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrendouyoujyuusyokbn ztyrendouyoujyuusyokbn}</td><td>（中継用）連動用住所区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatukaisosikicd ztyaatukaisosikicd}</td><td>（中継用）Ａ扱者組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrendouyousakugenkikan ztyrendouyousakugenkikan}</td><td>（中継用）連動用削減期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrnduyuryumshyutn ztyrnduyuryumshyutn}</td><td>（中継用）連動用料増標点</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrendouyoubosyuuym ztyrendouyoubosyuuym}</td><td>（中継用）連動用募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin1 ztysuuriyouyobin1}</td><td>（中継用）数理用予備項目Ｎ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykgycd ztysykgycd}</td><td>（中継用）職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhikettisyacd ztydakuhikettisyacd}</td><td>（中継用）諾否決定者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hihokensyahyouji ztydai2hihokensyahyouji}</td><td>（中継用）第２被保険者表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrenseimusntkknyuhyj ztyrenseimusntkknyuhyj}</td><td>（中継用）連生無選択加入表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokubetumaruteiarihyj ztytokubetumaruteiarihyj}</td><td>（中継用）特別マル定有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydougakutenkanhyouji ztydougakutenkanhyouji}</td><td>（中継用）同額転換表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkansentakuhouhoukbn ztytenkansentakuhouhoukbn}</td><td>（中継用）転換選択方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokubetusentakuarikbn ztytokubetusentakuarikbn}</td><td>（中継用）特別選択有区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketteikekkakbn ztyketteikekkakbn}</td><td>（中継用）決定結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakukakuninsyuruikbn ztykeiyakukakuninsyuruikbn}</td><td>（中継用）契約確認種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakukakuninriyuukbn ztykeiyakukakuninriyuukbn}</td><td>（中継用）契約確認理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrendouyoukekkancdx1 ztyrendouyoukekkancdx1}</td><td>（中継用）連動用欠陥コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikanensuux1 ztykeikanensuux1}</td><td>（中継用）経過年数＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyujyutuarihyoujix1 ztysyujyutuarihyoujix1}</td><td>（中継用）手術有表示＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrendouyoukekkancdx2 ztyrendouyoukekkancdx2}</td><td>（中継用）連動用欠陥コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikanensuux2 ztykeikanensuux2}</td><td>（中継用）経過年数＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyujyutuarihyoujix2 ztysyujyutuarihyoujix2}</td><td>（中継用）手術有表示＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaihokenhyouji ztysaihokenhyouji}</td><td>（中継用）再保険表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrnduyusysnhujyusnssyacd ztyrnduyusysnhujyusnssyacd}</td><td>（中継用）連動用初診報状診査者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrndyusysnhujyusnshuhukbn ztyrndyusysnhujyusnshuhukbn}</td><td>（中継用）連動用初診報状診査方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaisinriyuukbn ztysaisinriyuukbn}</td><td>（中継用）再診理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyoutousaisinarihyouji ztynyoutousaisinarihyouji}</td><td>（中継用）尿糖再診有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyoutanpakusaisinarihyj ztynyoutanpakusaisinarihyj}</td><td>（中継用）尿蛋白再診有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhemasaisinarihyouji ztyhemasaisinarihyouji}</td><td>（中継用）ヘマ再診有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykettousaisinarihyouji ztykettousaisinarihyouji}</td><td>（中継用）血糖再診有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysintyousaisinarihyouji ztysintyousaisinarihyouji}</td><td>（中継用）身長再診有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyouisaisinarihyouji ztykyouisaisinarihyouji}</td><td>（中継用）胸囲再診有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhukuisaisinarihyouji ztyhukuisaisinarihyouji}</td><td>（中継用）腹囲再診有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytaijyuusaisinarihyouji ztytaijyuusaisinarihyouji}</td><td>（中継用）体重再診有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuatusaisinarihyouji ztyketuatusaisinarihyouji}</td><td>（中継用）血圧再診有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrndyusisnhujyusnssyacd ztyrndyusisnhujyusnssyacd}</td><td>（中継用）連動用再診報状診査者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrndyusisnhujyusnshuhukbn ztyrndyusisnhujyusnshuhukbn}</td><td>（中継用）連動用再診報状診査方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyoutoukbn ztynyoutoukbn}</td><td>（中継用）尿糖区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv1x2 ztyyobiv1x2}</td><td>（中継用）予備項目Ｖ１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyoutanpakukbn ztynyoutanpakukbn}</td><td>（中継用）尿蛋白区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhemakbn ztyhemakbn}</td><td>（中継用）ヘマ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykettoutikeikajikan ztykettoutikeikajikan}</td><td>（中継用）血糖値経過時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykettouti ztykettouti}</td><td>（中継用）血糖値</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysintyou ztysintyou}</td><td>（中継用）身長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtykyoui ztykyoui}</td><td>（中継用）胸囲</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyhukui ztyhukui}</td><td>（中継用）腹囲</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtytaijyuu ztytaijyuu}</td><td>（中継用）体重</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysaikouketuatu ztysaikouketuatu}</td><td>（中継用）最高血圧</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysaiteiketuatu ztysaiteiketuatu}</td><td>（中継用）最低血圧</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyxsensyokencd ztyxsensyokencd}</td><td>（中継用）Ｘ線所見コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysindenzusyokencd ztysindenzusyokencd}</td><td>（中継用）心電図所見コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrnduyuganteisysnsyokencd ztyrnduyuganteisysnsyokencd}</td><td>（中継用）連動用眼底写真所見コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysinsahouhousiyoukbn ztysinsahouhousiyoukbn}</td><td>（中継用）診査方法使用区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyvipteikihyouji ztyvipteikihyouji}</td><td>（中継用）ＶＩＰ定期表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhoujyounomihyouji ztyhoujyounomihyouji}</td><td>（中継用）報状のみ表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuekikensajissikbn ztyketuekikensajissikbn}</td><td>（中継用）血液検査実施区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruteisyuruikigou ztymaruteisyuruikigou}</td><td>（中継用）マル定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseizonmrtisyuruikgu ztyseizonmrtisyuruikgu}</td><td>（中継用）生存マル定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketusikisoryou ztyketusikisoryou}</td><td>（中継用）血色素量</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtygot ztygot}</td><td>（中継用）ＧＯＴ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtygpt ztygpt}</td><td>（中継用）ＧＰＴ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyganmagtp ztyganmagtp}</td><td>（中継用）ガンマＧＴＰ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysyumisyatkisindenzukbn ztysyumisyatkisindenzukbn}</td><td>（中継用）証明書扱心電図区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykituenkbn ztykituenkbn}</td><td>（中継用）喫煙区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytignmrtisyukgu ztytignmrtisyukgu}</td><td>（中継用）逓減マル定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigenmaruteikikan ztyteigenmaruteikikan}</td><td>（中継用）逓減マル定期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykituenhonsuu ztykituenhonsuu}</td><td>（中継用）喫煙本数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv2 ztyyobiv2}</td><td>（中継用）予備項目Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin1x2 ztysuuriyouyobin1x2}</td><td>（中継用）数理用予備項目Ｎ１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrnduyusppinyuintkykntgk ztyrnduyusppinyuintkykntgk}</td><td>（中継用）連動用疾病入院特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin12 ztysuuriyouyobin12}</td><td>（中継用）数理用予備項目Ｎ１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv2x2 ztyyobiv2x2}</td><td>（中継用）予備項目Ｖ２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin1x3 ztysuuriyouyobin1x3}</td><td>（中継用）数理用予備項目Ｎ１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobin3 ztyyobin3}</td><td>（中継用）予備項目Ｎ３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin12x2 ztysuuriyouyobin12x2}</td><td>（中継用）数理用予備項目Ｎ１２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygoukeiteigenteikitkyks ztygoukeiteigenteikitkyks}</td><td>（中継用）合計逓減定期特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtytigntikbbntnknitjbrs ztytigntikbbntnknitjbrs}</td><td>（中継用）逓減定期部分転換一時払Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtytokuteisippeisetkbn ztytokuteisippeisetkbn}</td><td>（中継用）特定疾病セット区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin2 ztysuuriyouyobin2}</td><td>（中継用）数理用予備項目Ｎ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytaikakukijyunkanwahyouji ztytaikakukijyunkanwahyouji}</td><td>（中継用）体格基準緩和表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhaitoukbn ztyhaitoukbn}</td><td>（中継用）配当区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysnsykrketkbtsntkarihyj ztysnsykrketkbtsntkarihyj}</td><td>（中継用）新種切替特別選択有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatukaikojincd ztyaatukaikojincd}</td><td>（中継用）Ａ扱者個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv1x5 ztyyobiv1x5}</td><td>（中継用）予備項目Ｖ１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymanseisikkansetkbn ztymanseisikkansetkbn}</td><td>（中継用）慢性疾患セット区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygengakutenkankykhyj ztygengakutenkankykhyj}</td><td>（中継用）減額転換契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv2x4 ztyyobiv2x4}</td><td>（中継用）予備項目Ｖ２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfilekbn ztyfilekbn}</td><td>（中継用）ファイル区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv2x5 ztyyobiv2x5}</td><td>（中継用）予備項目Ｖ２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin1x4 ztysuuriyouyobin1x4}</td><td>（中継用）数理用予備項目Ｎ１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobin3x2 ztyyobin3x2}</td><td>（中継用）予備項目Ｎ３＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin12x3 ztysuuriyouyobin12x3}</td><td>（中継用）数理用予備項目Ｎ１２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv2x6 ztyyobiv2x6}</td><td>（中継用）予備項目Ｖ２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin1x5 ztysuuriyouyobin1x5}</td><td>（中継用）数理用予備項目Ｎ１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobin3x3 ztyyobin3x3}</td><td>（中継用）予備項目Ｎ３＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin12x4 ztysuuriyouyobin12x4}</td><td>（中継用）数理用予備項目Ｎ１２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv2x7 ztyyobiv2x7}</td><td>（中継用）予備項目Ｖ２＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin1x6 ztysuuriyouyobin1x6}</td><td>（中継用）数理用予備項目Ｎ１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobin3x4 ztyyobin3x4}</td><td>（中継用）予備項目Ｎ３＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin12x5 ztysuuriyouyobin12x5}</td><td>（中継用）数理用予備項目Ｎ１２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytaikakuhyouten ztytaikakuhyouten}</td><td>（中継用）体格標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtynyoutousykykhyutn ztynyoutousykykhyutn}</td><td>（中継用）尿糖主契約標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtynyoutanpakusykykhyutn ztynyoutanpakusykykhyutn}</td><td>（中継用）尿蛋白主契約標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyketuatutandokuhyouten ztyketuatutandokuhyouten}</td><td>（中継用）血圧単独標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyobin5 ztyyobin5}</td><td>（中継用）予備項目Ｎ５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin9 ztysuuriyouyobin9}</td><td>（中継用）数理用予備項目Ｎ９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobin5x2 ztyyobin5x2}</td><td>（中継用）予備項目Ｎ５＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin9x2 ztysuuriyouyobin9x2}</td><td>（中継用）数理用予備項目Ｎ９＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobin5x3 ztyyobin5x3}</td><td>（中継用）予備項目Ｎ５＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin9x3 ztysuuriyouyobin9x3}</td><td>（中継用）数理用予備項目Ｎ９＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyunyumrtisyukgu ztysyunyumrtisyukgu}</td><td>（中継用）収入マル定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuunyuumaruteikikan ztysyuunyuumaruteikikan}</td><td>（中継用）収入マル定期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuunyuumrtinknengkn5 ztysyuunyuumrtinknengkn5}</td><td>（中継用）収入マル定年金年額Ｎ５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysyuunyuumrtinkshrkkn ztysyuunyuumrtinkshrkkn}</td><td>（中継用）収入マル定年金支払期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin12x6 ztysuuriyouyobin12x6}</td><td>（中継用）数理用予備項目Ｎ１２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhutanpobui1 ztyhutanpobui1}</td><td>（中継用）不担保部位１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnpkkn1 ztyhtnpkkn1}</td><td>（中継用）不担保期間１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhutanpobui2 ztyhutanpobui2}</td><td>（中継用）不担保部位２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnpkkn2 ztyhtnpkkn2}</td><td>（中継用）不担保期間２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyosinnyoutou ztysyosinnyoutou}</td><td>（中継用）初診尿糖</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyosinnyoutanpaku ztysyosinnyoutanpaku}</td><td>（中継用）初診尿蛋白</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyosinnyousenketu ztysyosinnyousenketu}</td><td>（中継用）初診尿潜血</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyosinsaikouketuatu ztysyosinsaikouketuatu}</td><td>（中継用）初診最高血圧</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysyosinsaiteiketuatu ztysyosinsaiteiketuatu}</td><td>（中継用）初診最低血圧</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysaisinnyoutou ztysaisinnyoutou}</td><td>（中継用）再診尿糖</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaisinnyoutanpaku ztysaisinnyoutanpaku}</td><td>（中継用）再診尿蛋白</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaisinnyousenketu ztysaisinnyousenketu}</td><td>（中継用）再診尿潜血</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaisinsaikouketuatu ztysaisinsaikouketuatu}</td><td>（中継用）再診最高血圧</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysaisinsaiteiketuatu ztysaisinsaiteiketuatu}</td><td>（中継用）再診最低血圧</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyketuekikensaijyou1 ztyketuekikensaijyou1}</td><td>（中継用）血液検査異常１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuekikensaijyou2 ztyketuekikensaijyou2}</td><td>（中継用）血液検査異常２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuekikensaijyou3 ztyketuekikensaijyou3}</td><td>（中継用）血液検査異常３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuekikensaijyou4 ztyketuekikensaijyou4}</td><td>（中継用）血液検査異常４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuekikensaijyou5 ztyketuekikensaijyou5}</td><td>（中継用）血液検査異常５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhukasyukeiyakukigou ztyhukasyukeiyakukigou}</td><td>（中継用）付加主契約記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysekininkaisiymd ztysekininkaisiymd}</td><td>（中継用）責任開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyosinmyakuhakusuu ztysyosinmyakuhakusuu}</td><td>（中継用）初診脈拍数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysyosinhuseimyakusuu ztysyosinhuseimyakusuu}</td><td>（中継用）初診不整脈数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysaisinmyakuhakusuu ztysaisinmyakuhakusuu}</td><td>（中継用）再診脈拍数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysaisinhuseimyakusuu ztysaisinhuseimyakusuu}</td><td>（中継用）再診不整脈数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin2x2 ztysuuriyouyobin2x2}</td><td>（中継用）数理用予備項目Ｎ２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysouhyouten ztysouhyouten}</td><td>（中継用）総標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtytoukeiyukykymd ztytoukeiyukykymd}</td><td>（中継用）統計用契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhiketteiriyuucdx1 ztydakuhiketteiriyuucdx1}</td><td>（中継用）諾否決定理由コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhiketteiriyuucdx2 ztydakuhiketteiriyuucdx2}</td><td>（中継用）諾否決定理由コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhiketteiriyuucdx3 ztydakuhiketteiriyuucdx3}</td><td>（中継用）諾否決定理由コード＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhiketteiriyuucdx4 ztydakuhiketteiriyuucdx4}</td><td>（中継用）諾否決定理由コード＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanwamaeryouzouhyouten ztykanwamaeryouzouhyouten}</td><td>（中継用）緩和前料増標点</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyryoumasitokujyoukanwahyj ztyryoumasitokujyoukanwahyj}</td><td>（中継用）料増特条緩和表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnptokujyoukanwahyj ztyhtnptokujyoukanwahyj}</td><td>（中継用）不担保特条緩和表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyuruikigousedaikbn ztyhknsyuruikigousedaikbn}</td><td>（中継用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruteikigousedaikbn ztymaruteikigousedaikbn}</td><td>（中継用）マル定記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseizonmrtikgusdkbn ztyseizonmrtikgusdkbn}</td><td>（中継用）生存マル定記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigenmrtikgusdkbn ztyteigenmrtikgusdkbn}</td><td>（中継用）逓減マル定記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuunyuumrtikgusdkbn ztysyuunyuumrtikgusdkbn}</td><td>（中継用）収入マル定記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv4 ztyyobiv4}</td><td>（中継用）予備項目Ｖ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhksykykkgusdkbn ztyhksykykkgusdkbn}</td><td>（中継用）付加主契約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknsynensyuukbn ztyhhknsynensyuukbn}</td><td>（中継用）被保険者年収区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmentokuyakukbn ztypmentokuyakukbn}</td><td>（中継用）Ｐ免特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmennenkansanp ztypmennenkansanp}</td><td>（中継用）Ｐ免年換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyobiv1x9 ztyyobiv1x9}</td><td>（中継用）予備項目Ｖ１＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyosinsouchol ztysyosinsouchol}</td><td>（中継用）初診総コレステロール</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyosinhdlchol ztysyosinhdlchol}</td><td>（中継用）初診ＨＤＬコレステロール</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyosintyuuseisibou ztysyosintyuuseisibou}</td><td>（中継用）初診中性脂肪</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysysnsyumisyatkikettouti ztysysnsyumisyatkikettouti}</td><td>（中継用）初診証明書扱血糖値</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyosintoukahemogurobin ztysyosintoukahemogurobin}</td><td>（中継用）初診糖化ヘモグロビン</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysyosinnyousan ztysyosinnyousan}</td><td>（中継用）初診尿酸</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysyosinkureatinin ztysyosinkureatinin}</td><td>（中継用）初診クレアチニン</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtybosyuukeirokbn ztybosyuukeirokbn}</td><td>（中継用）募集経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsudirtnatkikeitaikbn ztybsudirtnatkikeitaikbn}</td><td>（中継用）募集代理店扱形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigkyhsitihsyutkykarihyj ztykigkyhsitihsyutkykarihyj}</td><td>（中継用）介護給付最低保証特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmenhutanpobui1 ztypmenhutanpobui1}</td><td>（中継用）Ｐ免不担保部位１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmenhutanpokikan1 ztypmenhutanpokikan1}</td><td>（中継用）Ｐ免不担保期間１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmenhutanpobui2 ztypmenhutanpobui2}</td><td>（中継用）Ｐ免不担保部位２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmenhutanpokikan2 ztypmenhutanpokikan2}</td><td>（中継用）Ｐ免不担保期間２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanyujidatakanrino ztykanyujidatakanrino}</td><td>（中継用）加入時データ管理番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybnktgsnzkkykdatakanrino ztybnktgsnzkkykdatakanrino}</td><td>（中継用）分割後存続契約データ管理番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykjiqpackhyj ztykykjiqpackhyj}</td><td>（中継用）契約時Ｑパック表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x1 ztyhokensyuruikigouyobi1x1}</td><td>（中継用）保険種類記号予備１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x2 ztyhokensyuruikigouyobi1x2}</td><td>（中継用）保険種類記号予備１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x3 ztyhokensyuruikigouyobi1x3}</td><td>（中継用）保険種類記号予備１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x4 ztyhokensyuruikigouyobi1x4}</td><td>（中継用）保険種類記号予備１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x5 ztyhokensyuruikigouyobi1x5}</td><td>（中継用）保険種類記号予備１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x6 ztyhokensyuruikigouyobi1x6}</td><td>（中継用）保険種類記号予備１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x7 ztyhokensyuruikigouyobi1x7}</td><td>（中継用）保険種類記号予備１＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x8 ztyhokensyuruikigouyobi1x8}</td><td>（中継用）保険種類記号予備１＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x9 ztyhokensyuruikigouyobi1x9}</td><td>（中継用）保険種類記号予備１＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x10 ztyhokensyuruikigouyobi1x10}</td><td>（中継用）保険種類記号予備１＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x11 ztyhokensyuruikigouyobi1x11}</td><td>（中継用）保険種類記号予備１＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x12 ztyhokensyuruikigouyobi1x12}</td><td>（中継用）保険種類記号予備１＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x13 ztyhokensyuruikigouyobi1x13}</td><td>（中継用）保険種類記号予備１＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x14 ztyhokensyuruikigouyobi1x14}</td><td>（中継用）保険種類記号予備１＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x15 ztyhokensyuruikigouyobi1x15}</td><td>（中継用）保険種類記号予備１＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x1 ztyhokensyuruikigouyobi2x1}</td><td>（中継用）保険種類記号予備２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x2 ztyhokensyuruikigouyobi2x2}</td><td>（中継用）保険種類記号予備２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x3 ztyhokensyuruikigouyobi2x3}</td><td>（中継用）保険種類記号予備２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x4 ztyhokensyuruikigouyobi2x4}</td><td>（中継用）保険種類記号予備２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x5 ztyhokensyuruikigouyobi2x5}</td><td>（中継用）保険種類記号予備２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x6 ztyhokensyuruikigouyobi2x6}</td><td>（中継用）保険種類記号予備２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x7 ztyhokensyuruikigouyobi2x7}</td><td>（中継用）保険種類記号予備２＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x8 ztyhokensyuruikigouyobi2x8}</td><td>（中継用）保険種類記号予備２＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x9 ztyhokensyuruikigouyobi2x9}</td><td>（中継用）保険種類記号予備２＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x10 ztyhokensyuruikigouyobi2x10}</td><td>（中継用）保険種類記号予備２＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x1 ztyhokensyuruikigouyobi3x1}</td><td>（中継用）保険種類記号予備３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x2 ztyhokensyuruikigouyobi3x2}</td><td>（中継用）保険種類記号予備３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x3 ztyhokensyuruikigouyobi3x3}</td><td>（中継用）保険種類記号予備３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x4 ztyhokensyuruikigouyobi3x4}</td><td>（中継用）保険種類記号予備３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x5 ztyhokensyuruikigouyobi3x5}</td><td>（中継用）保険種類記号予備３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x6 ztyhokensyuruikigouyobi3x6}</td><td>（中継用）保険種類記号予備３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x7 ztyhokensyuruikigouyobi3x7}</td><td>（中継用）保険種類記号予備３＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x8 ztyhokensyuruikigouyobi3x8}</td><td>（中継用）保険種類記号予備３＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x9 ztyhokensyuruikigouyobi3x9}</td><td>（中継用）保険種類記号予備３＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x10 ztyhokensyuruikigouyobi3x10}</td><td>（中継用）保険種類記号予備３＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukigouyobix1 ztytokuyakukigouyobix1}</td><td>（中継用）特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukigouyobix2 ztytokuyakukigouyobix2}</td><td>（中継用）特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukigouyobix3 ztytokuyakukigouyobix3}</td><td>（中継用）特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukigouyobix4 ztytokuyakukigouyobix4}</td><td>（中継用）特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukigouyobix5 ztytokuyakukigouyobix5}</td><td>（中継用）特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruteikigouyobix1 ztymaruteikigouyobix1}</td><td>（中継用）マル定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruteikigouyobix2 ztymaruteikigouyobix2}</td><td>（中継用）マル定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruteikigouyobix3 ztymaruteikigouyobix3}</td><td>（中継用）マル定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruteikigouyobix4 ztymaruteikigouyobix4}</td><td>（中継用）マル定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruteikigouyobix5 ztymaruteikigouyobix5}</td><td>（中継用）マル定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiznmrtikguybx1 ztysiznmrtikguybx1}</td><td>（中継用）生存マル定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiznmrtikguybx2 ztysiznmrtikguybx2}</td><td>（中継用）生存マル定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiznmrtikguybx3 ztysiznmrtikguybx3}</td><td>（中継用）生存マル定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiznmrtikguybx4 ztysiznmrtikguybx4}</td><td>（中継用）生存マル定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiznmrtikguybx5 ztysiznmrtikguybx5}</td><td>（中継用）生存マル定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigenmaruteikigouyobix1 ztyteigenmaruteikigouyobix1}</td><td>（中継用）逓減マル定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigenmaruteikigouyobix2 ztyteigenmaruteikigouyobix2}</td><td>（中継用）逓減マル定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigenmaruteikigouyobix3 ztyteigenmaruteikigouyobix3}</td><td>（中継用）逓減マル定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigenmaruteikigouyobix4 ztyteigenmaruteikigouyobix4}</td><td>（中継用）逓減マル定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigenmaruteikigouyobix5 ztyteigenmaruteikigouyobix5}</td><td>（中継用）逓減マル定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuunyuumrtikguybx1 ztysyuunyuumrtikguybx1}</td><td>（中継用）収入マル定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuunyuumrtikguybx2 ztysyuunyuumrtikguybx2}</td><td>（中継用）収入マル定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuunyuumrtikguybx3 ztysyuunyuumrtikguybx3}</td><td>（中継用）収入マル定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuunyuumrtikguybx4 ztysyuunyuumrtikguybx4}</td><td>（中継用）収入マル定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuunyuumrtikguybx5 ztysyuunyuumrtikguybx5}</td><td>（中継用）収入マル定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin5 ztysuuriyouyobin5}</td><td>（中継用）数理用予備項目Ｎ５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin5x2 ztysuuriyouyobin5x2}</td><td>（中継用）数理用予備項目Ｎ５＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin5x3 ztysuuriyouyobin5x3}</td><td>（中継用）数理用予備項目Ｎ５＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin5x4 ztysuuriyouyobin5x4}</td><td>（中継用）数理用予備項目Ｎ５＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin5x5 ztysuuriyouyobin5x5}</td><td>（中継用）数理用予備項目Ｎ５＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv2x9 ztyyobiv2x9}</td><td>（中継用）予備項目Ｖ２＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobin3x5 ztyyobin3x5}</td><td>（中継用）予備項目Ｎ３＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin1x7 ztysuuriyouyobin1x7}</td><td>（中継用）数理用予備項目Ｎ１＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv1x11 ztyyobiv1x11}</td><td>（中継用）予備項目Ｖ１＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin5x6 ztysuuriyouyobin5x6}</td><td>（中継用）数理用予備項目Ｎ５＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhikettikjynsyrikbnx1 ztydakuhikettikjynsyrikbnx1}</td><td>（中継用）諾否決定基準種類区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhikettikjynsyrikbnx2 ztydakuhikettikjynsyrikbnx2}</td><td>（中継用）諾否決定基準種類区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhikettikjynsyrikbnx3 ztydakuhikettikjynsyrikbnx3}</td><td>（中継用）諾否決定基準種類区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhikettikjynsyrikbnx4 ztydakuhikettikjynsyrikbnx4}</td><td>（中継用）諾否決定基準種類区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhikettikjynsyrikbnx5 ztydakuhikettikjynsyrikbnx5}</td><td>（中継用）諾否決定基準種類区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykdatakanrinox1 ztyhtnknkykdatakanrinox1}</td><td>（中継用）被転換契約データ管理番号＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykdatakanrinox2 ztyhtnknkykdatakanrinox2}</td><td>（中継用）被転換契約データ管理番号＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykdatakanrinox3 ztyhtnknkykdatakanrinox3}</td><td>（中継用）被転換契約データ管理番号＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykdatakanrinox4 ztyhtnknkykdatakanrinox4}</td><td>（中継用）被転換契約データ管理番号＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykdatakanrinox5 ztyhtnknkykdatakanrinox5}</td><td>（中継用）被転換契約データ管理番号＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykdatakanrinox6 ztyhtnknkykdatakanrinox6}</td><td>（中継用）被転換契約データ管理番号＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakusyahoujinkbn ztykeiyakusyahoujinkbn}</td><td>（中継用）契約者法人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin2x3 ztysuuriyouyobin2x3}</td><td>（中継用）数理用予備項目Ｎ２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyujynkttidkhkttikekkacd ztyhyujynkttidkhkttikekkacd}</td><td>（中継用）標準決定諾否決定結果コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyujynkttidkhkttiryucdx1 ztyhyujynkttidkhkttiryucdx1}</td><td>（中継用）標準決定諾否決定理由コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyujynkttidkhkttiryucdx2 ztyhyujynkttidkhkttiryucdx2}</td><td>（中継用）標準決定諾否決定理由コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyujynkttidkhkttiryucdx3 ztyhyujynkttidkhkttiryucdx3}</td><td>（中継用）標準決定諾否決定理由コード＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyujynkttidkhkttiryucdx4 ztyhyujynkttidkhkttiryucdx4}</td><td>（中継用）標準決定諾否決定理由コード＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyujynkttiryumshyutn ztyhyujynkttiryumshyutn}</td><td>（中継用）標準決定料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyhyujynkttisakugenkkn ztyhyujynkttisakugenkkn}</td><td>（中継用）標準決定削減期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysppitkykryumshyutn ztysppitkykryumshyutn}</td><td>（中継用）疾病特約料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyhyujynkttitktbuicdx1 ztyhyujynkttitktbuicdx1}</td><td>（中継用）標準決定特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyujynkttihutanpokknx1 ztyhyujynkttihutanpokknx1}</td><td>（中継用）標準決定不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyujynkttitktbuicdx2 ztyhyujynkttitktbuicdx2}</td><td>（中継用）標準決定特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyujynkttihutanpokknx2 ztyhyujynkttihutanpokknx2}</td><td>（中継用）標準決定不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyoukentukitaisyoukbnx1 ztyjyoukentukitaisyoukbnx1}</td><td>（中継用）条件付対象区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyukntksseigenhyjx1 ztyjyukntksseigenhyjx1}</td><td>（中継用）条件付Ｓ制限表示＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyukntktkyknozokihyjx1 ztyjyukntktkyknozokihyjx1}</td><td>（中継用）条件付特約除き表示＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin1x8 ztysuuriyouyobin1x8}</td><td>（中継用）数理用予備項目Ｎ１＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyoukentukiseigensx1 ztyjyoukentukiseigensx1}</td><td>（中継用）条件付制限Ｓ＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjyoukentukitaisyoukbnx2 ztyjyoukentukitaisyoukbnx2}</td><td>（中継用）条件付対象区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyukntksseigenhyjx2 ztyjyukntksseigenhyjx2}</td><td>（中継用）条件付Ｓ制限表示＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyukntktkyknozokihyjx2 ztyjyukntktkyknozokihyjx2}</td><td>（中継用）条件付特約除き表示＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin1x9 ztysuuriyouyobin1x9}</td><td>（中継用）数理用予備項目Ｎ１＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyoukentukiseigensx2 ztyjyoukentukiseigensx2}</td><td>（中継用）条件付制限Ｓ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjyoukentukitaisyoukbnx3 ztyjyoukentukitaisyoukbnx3}</td><td>（中継用）条件付対象区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyukntksseigenhyjx3 ztyjyukntksseigenhyjx3}</td><td>（中継用）条件付Ｓ制限表示＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyukntktkyknozokihyjx3 ztyjyukntktkyknozokihyjx3}</td><td>（中継用）条件付特約除き表示＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin1x10 ztysuuriyouyobin1x10}</td><td>（中継用）数理用予備項目Ｎ１＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyoukentukiseigensx3 ztyjyoukentukiseigensx3}</td><td>（中継用）条件付制限Ｓ＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjyoukentukitaisyoukbnx4 ztyjyoukentukitaisyoukbnx4}</td><td>（中継用）条件付対象区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyukntksseigenhyjx4 ztyjyukntksseigenhyjx4}</td><td>（中継用）条件付Ｓ制限表示＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyukntktkyknozokihyjx4 ztyjyukntktkyknozokihyjx4}</td><td>（中継用）条件付特約除き表示＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin1x11 ztysuuriyouyobin1x11}</td><td>（中継用）数理用予備項目Ｎ１＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyoukentukiseigensx4 ztyjyoukentukiseigensx4}</td><td>（中継用）条件付制限Ｓ＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjyukntkkigtiksyrihnkuhyj ztyjyukntkkigtiksyrihnkuhyj}</td><td>（中継用）条件付介護定期種類変更表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmensyuruihenkoukbn ztypmensyuruihenkoukbn}</td><td>（中継用）Ｐ免種類変更区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyoukentukitaisyoukbn2x1 ztyjyoukentukitaisyoukbn2x1}</td><td>（中継用）条件付対象区分２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyukntksseigenhyj2x1 ztyjyukntksseigenhyj2x1}</td><td>（中継用）条件付Ｓ制限表示２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyukntktkyknozokihyj2x1 ztyjyukntktkyknozokihyj2x1}</td><td>（中継用）条件付特約除き表示２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin1x12 ztysuuriyouyobin1x12}</td><td>（中継用）数理用予備項目Ｎ１＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyoukentukiseigens2x1 ztyjyoukentukiseigens2x1}</td><td>（中継用）条件付制限Ｓ２＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjyoukentukitaisyoukbn2x2 ztyjyoukentukitaisyoukbn2x2}</td><td>（中継用）条件付対象区分２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyukntksseigenhyj2x2 ztyjyukntksseigenhyj2x2}</td><td>（中継用）条件付Ｓ制限表示２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyukntktkyknozokihyj2x2 ztyjyukntktkyknozokihyj2x2}</td><td>（中継用）条件付特約除き表示２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin1x13 ztysuuriyouyobin1x13}</td><td>（中継用）数理用予備項目Ｎ１＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyoukentukiseigens2x2 ztyjyoukentukiseigens2x2}</td><td>（中継用）条件付制限Ｓ２＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjyoukentukitaisyoukbn2x3 ztyjyoukentukitaisyoukbn2x3}</td><td>（中継用）条件付対象区分２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyukntksseigenhyj2x3 ztyjyukntksseigenhyj2x3}</td><td>（中継用）条件付Ｓ制限表示２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyukntktkyknozokihyj2x3 ztyjyukntktkyknozokihyj2x3}</td><td>（中継用）条件付特約除き表示２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin1x14 ztysuuriyouyobin1x14}</td><td>（中継用）数理用予備項目Ｎ１＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyoukentukiseigens2x3 ztyjyoukentukiseigens2x3}</td><td>（中継用）条件付制限Ｓ２＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjyoukentukitaisyoukbn2x4 ztyjyoukentukitaisyoukbn2x4}</td><td>（中継用）条件付対象区分２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyukntksseigenhyj2x4 ztyjyukntksseigenhyj2x4}</td><td>（中継用）条件付Ｓ制限表示２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyukntktkyknozokihyj2x4 ztyjyukntktkyknozokihyj2x4}</td><td>（中継用）条件付特約除き表示２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin1x15 ztysuuriyouyobin1x15}</td><td>（中継用）数理用予備項目Ｎ１＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyoukentukiseigens2x4 ztyjyoukentukiseigens2x4}</td><td>（中継用）条件付制限Ｓ２＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytktsppiryumshyutn ztytktsppiryumshyutn}</td><td>（中継用）特定疾病料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtytktsppiskgnkkn ztytktsppiskgnkkn}</td><td>（中継用）特定疾病削減期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymnsiskknryumshyutn ztymnsiskknryumshyutn}</td><td>（中継用）慢性疾患料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtymanseisikkansakugenkikan ztymanseisikkansakugenkikan}</td><td>（中継用）慢性疾患削減期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymanseisikkantokuteibuicd ztymanseisikkantokuteibuicd}</td><td>（中継用）慢性疾患特定部位コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymanseisikkanhutanpokikan ztymanseisikkanhutanpokikan}</td><td>（中継用）慢性疾患不担保期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaihokenkbn ztysaihokenkbn}</td><td>（中継用）再保険区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyimustiyusbus ztyimustiyusbus}</td><td>（中継用）医務査定用死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyimusateiyoujissituhsyus ztyimusateiyoujissituhsyus}</td><td>（中継用）医務査定用実質保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyisahtnkngukijissituhsyus ztyisahtnkngukijissituhsyus}</td><td>（中継用）医査被転換合計実質保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyimusateiyoutenkansagakus ztyimusateiyoutenkansagakus}</td><td>（中継用）医務査定用転換差額Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyimusateiyouhanbaikirkbn ztyimusateiyouhanbaikirkbn}</td><td>（中継用）医務査定用販売経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyoyabosyuudairitencd ztyoyabosyuudairitencd}</td><td>（中継用）親募集代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyoubosyuukeitaikbn ztysuuriyoubosyuukeitaikbn}</td><td>（中継用）数理用募集形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhihokensyahokenage ztyhihokensyahokenage}</td><td>（中継用）被保険者保険年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrendouyoumusntkkykhyj ztyrendouyoumusntkkykhyj}</td><td>（中継用）連動用無選択契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv2x11 ztyyobiv2x11}</td><td>（中継用）予備項目Ｖ２＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobin3x6 ztyyobin3x6}</td><td>（中継用）予備項目Ｎ３＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin9x4 ztysuuriyouyobin9x4}</td><td>（中継用）数理用予備項目Ｎ９＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv1x20 ztyyobiv1x20}</td><td>（中継用）予備項目Ｖ１＿２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin5x7 ztysuuriyouyobin5x7}</td><td>（中継用）数理用予備項目Ｎ５＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnentysihyj ztyhhknnentysihyj}</td><td>（中継用）被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysindenzusyokensyousaicd ztysindenzusyokensyousaicd}</td><td>（中継用）心電図所見詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyimstiyuktekknsjsshyj ztyimstiyuktekknsjsshyj}</td><td>（中継用）医務査定用血液検査実施表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuekikensasekkekkyuusu ztyketuekikensasekkekkyuusu}</td><td>（中継用）血液検査赤血球数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyktekknsskkkkyususykncd ztyktekknsskkkkyususykncd}</td><td>（中継用）血液検査赤血球数所見コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuekikensahakkekkyuusu ztyketuekikensahakkekkyuusu}</td><td>（中継用）血液検査白血球数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyktekknshkkkkyususykncd ztyktekknshkkkkyususykncd}</td><td>（中継用）血液検査白血球数所見コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyktekknsketusikisoryou ztyktekknsketusikisoryou}</td><td>（中継用）血液検査血色素量</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyktekknsktsksryusyokencd ztyktekknsktsksryusyokencd}</td><td>（中継用）血液検査血色素量所見コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyktekknshematokuritto ztyktekknshematokuritto}</td><td>（中継用）血液検査ヘマトクリット</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyktekhmtkrttsykncd ztyktekhmtkrttsykncd}</td><td>（中継用）血液ヘマトクリット所見コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuekikensakessyoubansu ztyketuekikensakessyoubansu}</td><td>（中継用）血液検査血小板数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyktekknskssyubnsusyokencd ztyktekknskssyubnsusyokencd}</td><td>（中継用）血液検査血小板数所見コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyktekknskssisutnpkryu ztyktekknskssisutnpkryu}</td><td>（中継用）血液検査血清総蛋白量</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyktekkssisutnpkryusykncd ztyktekkssisutnpkryusykncd}</td><td>（中継用）血液血清総蛋白量所見コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuekikensaarubumin ztyketuekikensaarubumin}</td><td>（中継用）血液検査アルブミン</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyktekknsarubuminsyokencd ztyktekknsarubuminsyokencd}</td><td>（中継用）血液検査アルブミン所見コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuekikensaztt ztyketuekikensaztt}</td><td>（中継用）血液検査ＺＴＴ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyketuekikensazttsyokencd ztyketuekikensazttsyokencd}</td><td>（中継用）血液検査ＺＴＴ所見コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuekikensagot ztyketuekikensagot}</td><td>（中継用）血液検査ＧＯＴ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuekikensagotsyokencd ztyketuekikensagotsyokencd}</td><td>（中継用）血液検査ＧＯＴ所見コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuekikensagpt ztyketuekikensagpt}</td><td>（中継用）血液検査ＧＰＴ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuekikensagptsyokencd ztyketuekikensagptsyokencd}</td><td>（中継用）血液検査ＧＰＴ所見コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuekikensaganmagtp ztyketuekikensaganmagtp}</td><td>（中継用）血液検査ガンマＧＴＰ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuekiganmagtpsyokencd ztyketuekiganmagtpsyokencd}</td><td>（中継用）血液ガンマＧＴＰ所見コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuekikensasouchol ztyketuekikensasouchol}</td><td>（中継用）血液検査総コレステロール</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuekicholsyokencd ztyketuekicholsyokencd}</td><td>（中継用）血液コレステロール所見コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuekikensahdlchol ztyketuekikensahdlchol}</td><td>（中継用）血液検査ＨＤＬコレステロール</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuekikensahdlsyokencd ztyketuekikensahdlsyokencd}</td><td>（中継用）血液検査ＨＤＬ所見コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyktekknstukhmgrbn ztyktekknstukhmgrbn}</td><td>（中継用）血液検査糖化ヘモグロビン</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyktekhmgrbnsykncd ztyktekhmgrbnsykncd}</td><td>（中継用）血液ヘモグロビン所見コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyktekknskorinesuterrze ztyktekknskorinesuterrze}</td><td>（中継用）血液検査コリンエステラーゼ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykorinesuterrzesyokencd ztykorinesuterrzesyokencd}</td><td>（中継用）コリンエステラーゼ所見コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuekikensamcv ztyketuekikensamcv}</td><td>（中継用）血液検査ＭＣＶ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyketuekikensamcvsyokencd ztyketuekikensamcvsyokencd}</td><td>（中継用）血液検査ＭＣＶ所見コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuekikensamch ztyketuekikensamch}</td><td>（中継用）血液検査ＭＣＨ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyketuekikensamchsyokencd ztyketuekikensamchsyokencd}</td><td>（中継用）血液検査ＭＣＨ所見コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuekikensamchc ztyketuekikensamchc}</td><td>（中継用）血液検査ＭＣＨＣ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyketuekikensamchcsyokencd ztyketuekikensamchcsyokencd}</td><td>（中継用）血液検査ＭＣＨＣ所見コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuekikensacea ztyketuekikensacea}</td><td>（中継用）血液検査ＣＥＡ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyketuekikensaceasyokencd ztyketuekikensaceasyokencd}</td><td>（中継用）血液検査ＣＥＡ所見コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuekikensaafp ztyketuekikensaafp}</td><td>（中継用）血液検査ＡＦＰ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyketuekikensaafpsyokencd ztyketuekikensaafpsyokencd}</td><td>（中継用）血液検査ＡＦＰ所見コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuekikensahbskbn ztyketuekikensahbskbn}</td><td>（中継用）血液検査ＨＢＳ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuekikensahbssyokencd ztyketuekikensahbssyokencd}</td><td>（中継用）血液検査ＨＢＳ所見コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuekikensahcvkbn ztyketuekikensahcvkbn}</td><td>（中継用）血液検査ＨＣＶ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketuekikensahcvsyokencd ztyketuekikensahcvsyokencd}</td><td>（中継用）血液検査ＨＣＶ所見コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyimusateiyouknsnsytryskbn ztyimusateiyouknsnsytryskbn}</td><td>（中継用）医務査定用健診書取寄区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyosinldlchol ztysyosinldlchol}</td><td>（中継用）初診ＬＤＬコレステロール</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuteijyoutaihushrhyj ztytokuteijyoutaihushrhyj}</td><td>（中継用）特定状態不支払表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrendouyouosyukeiyakup ztyrendouyouosyukeiyakup}</td><td>（中継用）連動用主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtytokubetuhosyoukikan ztytokubetuhosyoukikan}</td><td>（中継用）特別保障期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrendouyougoukeitenkans ztyrendouyougoukeitenkans}</td><td>（中継用）連動用合計転換Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyrnduyugukitnknkakaku ztyrnduyugukitnknkakaku}</td><td>（中継用）連動用合計転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyrnduyuwnsgukitnknkakaku ztyrnduyuwnsgukitnknkakaku}</td><td>（中継用）連動用Ｗなし合計転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtymostnknkhnbbnjyuturt ztymostnknkhnbbnjyuturt}</td><td>（中継用）申込転換基本部分充当率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyrnduyusykykbbnkhns ztyrnduyusykykbbnkhns}</td><td>（中継用）連動用主契約部分基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyrendouyouyoteiriritu ztyrendouyouyoteiriritu}</td><td>（中継用）連動用予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyknkuzusnzyrt ztyknkuzusnzyrt}</td><td>（中継用）健康増進乗率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv121 ztyyobiv121}</td><td>（中継用）予備項目Ｖ１２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyraysystemhyj ztyraysystemhyj}</td><td>（中継用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygaikakbn ztygaikakbn}</td><td>（中継用）外貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygaikadatekihons ztygaikadatekihons}</td><td>（中継用）外貨建基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatesibous ztygaikadatesibous}</td><td>（中継用）外貨建死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykeiyakujiyoteiriritu ztykeiyakujiyoteiriritu}</td><td>（中継用）契約時予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykawaserate ztykawaserate}</td><td>（中継用）為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykawaseratetekiyouymd ztykawaseratetekiyouymd}</td><td>（中継用）為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyenkdtsbujsitihsyukngk ztyenkdtsbujsitihsyukngk}</td><td>（中継用）円貨建死亡時最低保証金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysrdai1hknkkn ztysrdai1hknkkn}</td><td>（中継用）数理用第１保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin8 ztysuuriyouyobin8}</td><td>（中継用）数理用予備項目Ｎ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin10x2 ztysuuriyouyobin10x2}</td><td>（中継用）数理用予備項目Ｎ１０＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuukasyukbn ztytuukasyukbn}</td><td>（中継用）通貨種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv9 ztyyobiv9}</td><td>（中継用）予備項目Ｖ９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10x4 ztyyobiv10x4}</td><td>（中継用）予備項目Ｖ１０＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobin7 ztyyobin7}</td><td>（中継用）予備項目Ｎ７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyobin7x2 ztyyobin7x2}</td><td>（中継用）予備項目Ｎ７＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyobin7x3 ztyyobin7x3}</td><td>（中継用）予備項目Ｎ７＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyobin7x4 ztyyobin7x4}</td><td>（中継用）予備項目Ｎ７＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyobin7x5 ztyyobin7x5}</td><td>（中継用）予備項目Ｎ７＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyobiv4x2 ztyyobiv4x2}</td><td>（中継用）予備項目Ｖ４＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SbRituRendouTy
 * @see     PKZT_SbRituRendouTy
 * @see     QZT_SbRituRendouTy
 * @see     GenQZT_SbRituRendouTy
 */
@MappedSuperclass
@Table(name=GenZT_SbRituRendouTy.TABLE_NAME)
@IdClass(value=PKZT_SbRituRendouTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_SbRituRendouTy extends AbstractExDBEntity<ZT_SbRituRendouTy, PKZT_SbRituRendouTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SbRituRendouTy";
    public static final String ZTYSEQUENCENO            = "ztysequenceno";
    public static final String ZTYYOBIV12X7             = "ztyyobiv12x7";
    public static final String ZTYDATAKANRINO           = "ztydatakanrino";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYSAIMNKKYKHYJ          = "ztysaimnkkykhyj";
    public static final String ZTYRENDOUYOUKIKAN        = "ztyrendouyoukikan";
    public static final String ZTYHIHOKENSYAAGEV2       = "ztyhihokensyaagev2";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYRENDOUYOUKEIYAKUNENGETU = "ztyrendouyoukeiyakunengetu";
    public static final String ZTYRENDOUYOUKIHONS       = "ztyrendouyoukihons";
    public static final String ZTYRENDOUYOUSIBOUS       = "ztyrendouyousibous";
    public static final String ZTYTNKNITJBRIGISBUS      = "ztytnknitjbrigisbus";
    public static final String ZTYTENKANMINAOSIKBN      = "ztytenkanminaosikbn";
    public static final String ZTYRENDOUYOUHRKHOUHOUKBN = "ztyrendouyouhrkhouhoukbn";
    public static final String ZTYRENDOUYOUJYUUSYOKBN   = "ztyrendouyoujyuusyokbn";
    public static final String ZTYAATUKAISOSIKICD       = "ztyaatukaisosikicd";
    public static final String ZTYRENDOUYOUSAKUGENKIKAN = "ztyrendouyousakugenkikan";
    public static final String ZTYRNDUYURYUMSHYUTN      = "ztyrnduyuryumshyutn";
    public static final String ZTYRENDOUYOUBOSYUUYM     = "ztyrendouyoubosyuuym";
    public static final String ZTYSUURIYOUYOBIN1        = "ztysuuriyouyobin1";
    public static final String ZTYSYKGYCD               = "ztysykgycd";
    public static final String ZTYDAKUHIKETTISYACD      = "ztydakuhikettisyacd";
    public static final String ZTYDAI2HIHOKENSYAHYOUJI  = "ztydai2hihokensyahyouji";
    public static final String ZTYRENSEIMUSNTKKNYUHYJ   = "ztyrenseimusntkknyuhyj";
    public static final String ZTYTOKUBETUMARUTEIARIHYJ = "ztytokubetumaruteiarihyj";
    public static final String ZTYDOUGAKUTENKANHYOUJI   = "ztydougakutenkanhyouji";
    public static final String ZTYTENKANSENTAKUHOUHOUKBN = "ztytenkansentakuhouhoukbn";
    public static final String ZTYTOKUBETUSENTAKUARIKBN = "ztytokubetusentakuarikbn";
    public static final String ZTYKETTEIKEKKAKBN        = "ztyketteikekkakbn";
    public static final String ZTYKEIYAKUKAKUNINSYURUIKBN = "ztykeiyakukakuninsyuruikbn";
    public static final String ZTYKEIYAKUKAKUNINRIYUUKBN = "ztykeiyakukakuninriyuukbn";
    public static final String ZTYRENDOUYOUKEKKANCDX1   = "ztyrendouyoukekkancdx1";
    public static final String ZTYKEIKANENSUUX1         = "ztykeikanensuux1";
    public static final String ZTYSYUJYUTUARIHYOUJIX1   = "ztysyujyutuarihyoujix1";
    public static final String ZTYRENDOUYOUKEKKANCDX2   = "ztyrendouyoukekkancdx2";
    public static final String ZTYKEIKANENSUUX2         = "ztykeikanensuux2";
    public static final String ZTYSYUJYUTUARIHYOUJIX2   = "ztysyujyutuarihyoujix2";
    public static final String ZTYSAIHOKENHYOUJI        = "ztysaihokenhyouji";
    public static final String ZTYRNDUYUSYSNHUJYUSNSSYACD = "ztyrnduyusysnhujyusnssyacd";
    public static final String ZTYRNDYUSYSNHUJYUSNSHUHUKBN = "ztyrndyusysnhujyusnshuhukbn";
    public static final String ZTYSAISINRIYUUKBN        = "ztysaisinriyuukbn";
    public static final String ZTYNYOUTOUSAISINARIHYOUJI = "ztynyoutousaisinarihyouji";
    public static final String ZTYNYOUTANPAKUSAISINARIHYJ = "ztynyoutanpakusaisinarihyj";
    public static final String ZTYHEMASAISINARIHYOUJI   = "ztyhemasaisinarihyouji";
    public static final String ZTYKETTOUSAISINARIHYOUJI = "ztykettousaisinarihyouji";
    public static final String ZTYSINTYOUSAISINARIHYOUJI = "ztysintyousaisinarihyouji";
    public static final String ZTYKYOUISAISINARIHYOUJI  = "ztykyouisaisinarihyouji";
    public static final String ZTYHUKUISAISINARIHYOUJI  = "ztyhukuisaisinarihyouji";
    public static final String ZTYTAIJYUUSAISINARIHYOUJI = "ztytaijyuusaisinarihyouji";
    public static final String ZTYKETUATUSAISINARIHYOUJI = "ztyketuatusaisinarihyouji";
    public static final String ZTYRNDYUSISNHUJYUSNSSYACD = "ztyrndyusisnhujyusnssyacd";
    public static final String ZTYRNDYUSISNHUJYUSNSHUHUKBN = "ztyrndyusisnhujyusnshuhukbn";
    public static final String ZTYNYOUTOUKBN            = "ztynyoutoukbn";
    public static final String ZTYYOBIV1X2              = "ztyyobiv1x2";
    public static final String ZTYNYOUTANPAKUKBN        = "ztynyoutanpakukbn";
    public static final String ZTYHEMAKBN               = "ztyhemakbn";
    public static final String ZTYKETTOUTIKEIKAJIKAN    = "ztykettoutikeikajikan";
    public static final String ZTYKETTOUTI              = "ztykettouti";
    public static final String ZTYSINTYOU               = "ztysintyou";
    public static final String ZTYKYOUI                 = "ztykyoui";
    public static final String ZTYHUKUI                 = "ztyhukui";
    public static final String ZTYTAIJYUU               = "ztytaijyuu";
    public static final String ZTYSAIKOUKETUATU         = "ztysaikouketuatu";
    public static final String ZTYSAITEIKETUATU         = "ztysaiteiketuatu";
    public static final String ZTYXSENSYOKENCD          = "ztyxsensyokencd";
    public static final String ZTYSINDENZUSYOKENCD      = "ztysindenzusyokencd";
    public static final String ZTYRNDUYUGANTEISYSNSYOKENCD = "ztyrnduyuganteisysnsyokencd";
    public static final String ZTYSINSAHOUHOUSIYOUKBN   = "ztysinsahouhousiyoukbn";
    public static final String ZTYVIPTEIKIHYOUJI        = "ztyvipteikihyouji";
    public static final String ZTYHOUJYOUNOMIHYOUJI     = "ztyhoujyounomihyouji";
    public static final String ZTYKETUEKIKENSAJISSIKBN  = "ztyketuekikensajissikbn";
    public static final String ZTYMARUTEISYURUIKIGOU    = "ztymaruteisyuruikigou";
    public static final String ZTYSEIZONMRTISYURUIKGU   = "ztyseizonmrtisyuruikgu";
    public static final String ZTYKETUSIKISORYOU        = "ztyketusikisoryou";
    public static final String ZTYGOT                   = "ztygot";
    public static final String ZTYGPT                   = "ztygpt";
    public static final String ZTYGANMAGTP              = "ztyganmagtp";
    public static final String ZTYSYUMISYATKISINDENZUKBN = "ztysyumisyatkisindenzukbn";
    public static final String ZTYKITUENKBN             = "ztykituenkbn";
    public static final String ZTYTIGNMRTISYUKGU        = "ztytignmrtisyukgu";
    public static final String ZTYTEIGENMARUTEIKIKAN    = "ztyteigenmaruteikikan";
    public static final String ZTYKITUENHONSUU          = "ztykituenhonsuu";
    public static final String ZTYYOBIV2                = "ztyyobiv2";
    public static final String ZTYSUURIYOUYOBIN1X2      = "ztysuuriyouyobin1x2";
    public static final String ZTYRNDUYUSPPINYUINTKYKNTGK = "ztyrnduyusppinyuintkykntgk";
    public static final String ZTYSUURIYOUYOBIN12       = "ztysuuriyouyobin12";
    public static final String ZTYYOBIV2X2              = "ztyyobiv2x2";
    public static final String ZTYSUURIYOUYOBIN1X3      = "ztysuuriyouyobin1x3";
    public static final String ZTYYOBIN3                = "ztyyobin3";
    public static final String ZTYSUURIYOUYOBIN12X2     = "ztysuuriyouyobin12x2";
    public static final String ZTYGOUKEITEIGENTEIKITKYKS = "ztygoukeiteigenteikitkyks";
    public static final String ZTYTIGNTIKBBNTNKNITJBRS  = "ztytigntikbbntnknitjbrs";
    public static final String ZTYTOKUTEISIPPEISETKBN   = "ztytokuteisippeisetkbn";
    public static final String ZTYSUURIYOUYOBIN2        = "ztysuuriyouyobin2";
    public static final String ZTYTAIKAKUKIJYUNKANWAHYOUJI = "ztytaikakukijyunkanwahyouji";
    public static final String ZTYHAITOUKBN             = "ztyhaitoukbn";
    public static final String ZTYSNSYKRKETKBTSNTKARIHYJ = "ztysnsykrketkbtsntkarihyj";
    public static final String ZTYAATUKAIKOJINCD        = "ztyaatukaikojincd";
    public static final String ZTYYOBIV1X5              = "ztyyobiv1x5";
    public static final String ZTYMANSEISIKKANSETKBN    = "ztymanseisikkansetkbn";
    public static final String ZTYGENGAKUTENKANKYKHYJ   = "ztygengakutenkankykhyj";
    public static final String ZTYYOBIV2X4              = "ztyyobiv2x4";
    public static final String ZTYFILEKBN               = "ztyfilekbn";
    public static final String ZTYYOBIV2X5              = "ztyyobiv2x5";
    public static final String ZTYSUURIYOUYOBIN1X4      = "ztysuuriyouyobin1x4";
    public static final String ZTYYOBIN3X2              = "ztyyobin3x2";
    public static final String ZTYSUURIYOUYOBIN12X3     = "ztysuuriyouyobin12x3";
    public static final String ZTYYOBIV2X6              = "ztyyobiv2x6";
    public static final String ZTYSUURIYOUYOBIN1X5      = "ztysuuriyouyobin1x5";
    public static final String ZTYYOBIN3X3              = "ztyyobin3x3";
    public static final String ZTYSUURIYOUYOBIN12X4     = "ztysuuriyouyobin12x4";
    public static final String ZTYYOBIV2X7              = "ztyyobiv2x7";
    public static final String ZTYSUURIYOUYOBIN1X6      = "ztysuuriyouyobin1x6";
    public static final String ZTYYOBIN3X4              = "ztyyobin3x4";
    public static final String ZTYSUURIYOUYOBIN12X5     = "ztysuuriyouyobin12x5";
    public static final String ZTYTAIKAKUHYOUTEN        = "ztytaikakuhyouten";
    public static final String ZTYNYOUTOUSYKYKHYUTN     = "ztynyoutousykykhyutn";
    public static final String ZTYNYOUTANPAKUSYKYKHYUTN = "ztynyoutanpakusykykhyutn";
    public static final String ZTYKETUATUTANDOKUHYOUTEN = "ztyketuatutandokuhyouten";
    public static final String ZTYYOBIN5                = "ztyyobin5";
    public static final String ZTYSUURIYOUYOBIN9        = "ztysuuriyouyobin9";
    public static final String ZTYYOBIN5X2              = "ztyyobin5x2";
    public static final String ZTYSUURIYOUYOBIN9X2      = "ztysuuriyouyobin9x2";
    public static final String ZTYYOBIN5X3              = "ztyyobin5x3";
    public static final String ZTYSUURIYOUYOBIN9X3      = "ztysuuriyouyobin9x3";
    public static final String ZTYSYUNYUMRTISYUKGU      = "ztysyunyumrtisyukgu";
    public static final String ZTYSYUUNYUUMARUTEIKIKAN  = "ztysyuunyuumaruteikikan";
    public static final String ZTYSYUUNYUUMRTINKNENGKN5 = "ztysyuunyuumrtinknengkn5";
    public static final String ZTYSYUUNYUUMRTINKSHRKKN  = "ztysyuunyuumrtinkshrkkn";
    public static final String ZTYSUURIYOUYOBIN12X6     = "ztysuuriyouyobin12x6";
    public static final String ZTYHUTANPOBUI1           = "ztyhutanpobui1";
    public static final String ZTYHTNPKKN1              = "ztyhtnpkkn1";
    public static final String ZTYHUTANPOBUI2           = "ztyhutanpobui2";
    public static final String ZTYHTNPKKN2              = "ztyhtnpkkn2";
    public static final String ZTYSYOSINNYOUTOU         = "ztysyosinnyoutou";
    public static final String ZTYSYOSINNYOUTANPAKU     = "ztysyosinnyoutanpaku";
    public static final String ZTYSYOSINNYOUSENKETU     = "ztysyosinnyousenketu";
    public static final String ZTYSYOSINSAIKOUKETUATU   = "ztysyosinsaikouketuatu";
    public static final String ZTYSYOSINSAITEIKETUATU   = "ztysyosinsaiteiketuatu";
    public static final String ZTYSAISINNYOUTOU         = "ztysaisinnyoutou";
    public static final String ZTYSAISINNYOUTANPAKU     = "ztysaisinnyoutanpaku";
    public static final String ZTYSAISINNYOUSENKETU     = "ztysaisinnyousenketu";
    public static final String ZTYSAISINSAIKOUKETUATU   = "ztysaisinsaikouketuatu";
    public static final String ZTYSAISINSAITEIKETUATU   = "ztysaisinsaiteiketuatu";
    public static final String ZTYKETUEKIKENSAIJYOU1    = "ztyketuekikensaijyou1";
    public static final String ZTYKETUEKIKENSAIJYOU2    = "ztyketuekikensaijyou2";
    public static final String ZTYKETUEKIKENSAIJYOU3    = "ztyketuekikensaijyou3";
    public static final String ZTYKETUEKIKENSAIJYOU4    = "ztyketuekikensaijyou4";
    public static final String ZTYKETUEKIKENSAIJYOU5    = "ztyketuekikensaijyou5";
    public static final String ZTYHUKASYUKEIYAKUKIGOU   = "ztyhukasyukeiyakukigou";
    public static final String ZTYSEKININKAISIYMD       = "ztysekininkaisiymd";
    public static final String ZTYSYOSINMYAKUHAKUSUU    = "ztysyosinmyakuhakusuu";
    public static final String ZTYSYOSINHUSEIMYAKUSUU   = "ztysyosinhuseimyakusuu";
    public static final String ZTYSAISINMYAKUHAKUSUU    = "ztysaisinmyakuhakusuu";
    public static final String ZTYSAISINHUSEIMYAKUSUU   = "ztysaisinhuseimyakusuu";
    public static final String ZTYSUURIYOUYOBIN2X2      = "ztysuuriyouyobin2x2";
    public static final String ZTYSOUHYOUTEN            = "ztysouhyouten";
    public static final String ZTYTOUKEIYUKYKYMD        = "ztytoukeiyukykymd";
    public static final String ZTYDAKUHIKETTEIRIYUUCDX1 = "ztydakuhiketteiriyuucdx1";
    public static final String ZTYDAKUHIKETTEIRIYUUCDX2 = "ztydakuhiketteiriyuucdx2";
    public static final String ZTYDAKUHIKETTEIRIYUUCDX3 = "ztydakuhiketteiriyuucdx3";
    public static final String ZTYDAKUHIKETTEIRIYUUCDX4 = "ztydakuhiketteiriyuucdx4";
    public static final String ZTYKANWAMAERYOUZOUHYOUTEN = "ztykanwamaeryouzouhyouten";
    public static final String ZTYRYOUMASITOKUJYOUKANWAHYJ = "ztyryoumasitokujyoukanwahyj";
    public static final String ZTYHTNPTOKUJYOUKANWAHYJ  = "ztyhtnptokujyoukanwahyj";
    public static final String ZTYHKNSYURUIKIGOUSEDAIKBN = "ztyhknsyuruikigousedaikbn";
    public static final String ZTYMARUTEIKIGOUSEDAIKBN  = "ztymaruteikigousedaikbn";
    public static final String ZTYSEIZONMRTIKGUSDKBN    = "ztyseizonmrtikgusdkbn";
    public static final String ZTYTEIGENMRTIKGUSDKBN    = "ztyteigenmrtikgusdkbn";
    public static final String ZTYSYUUNYUUMRTIKGUSDKBN  = "ztysyuunyuumrtikgusdkbn";
    public static final String ZTYYOBIV4                = "ztyyobiv4";
    public static final String ZTYHKSYKYKKGUSDKBN       = "ztyhksykykkgusdkbn";
    public static final String ZTYHHKNSYNENSYUUKBN      = "ztyhhknsynensyuukbn";
    public static final String ZTYPMENTOKUYAKUKBN       = "ztypmentokuyakukbn";
    public static final String ZTYPMENNENKANSANP        = "ztypmennenkansanp";
    public static final String ZTYYOBIV1X9              = "ztyyobiv1x9";
    public static final String ZTYSYOSINSOUCHOL         = "ztysyosinsouchol";
    public static final String ZTYSYOSINHDLCHOL         = "ztysyosinhdlchol";
    public static final String ZTYSYOSINTYUUSEISIBOU    = "ztysyosintyuuseisibou";
    public static final String ZTYSYSNSYUMISYATKIKETTOUTI = "ztysysnsyumisyatkikettouti";
    public static final String ZTYSYOSINTOUKAHEMOGUROBIN = "ztysyosintoukahemogurobin";
    public static final String ZTYSYOSINNYOUSAN         = "ztysyosinnyousan";
    public static final String ZTYSYOSINKUREATININ      = "ztysyosinkureatinin";
    public static final String ZTYBOSYUUKEIROKBN        = "ztybosyuukeirokbn";
    public static final String ZTYBSUDIRTNATKIKEITAIKBN = "ztybsudirtnatkikeitaikbn";
    public static final String ZTYKIGKYHSITIHSYUTKYKARIHYJ = "ztykigkyhsitihsyutkykarihyj";
    public static final String ZTYPMENHUTANPOBUI1       = "ztypmenhutanpobui1";
    public static final String ZTYPMENHUTANPOKIKAN1     = "ztypmenhutanpokikan1";
    public static final String ZTYPMENHUTANPOBUI2       = "ztypmenhutanpobui2";
    public static final String ZTYPMENHUTANPOKIKAN2     = "ztypmenhutanpokikan2";
    public static final String ZTYKANYUJIDATAKANRINO    = "ztykanyujidatakanrino";
    public static final String ZTYBNKTGSNZKKYKDATAKANRINO = "ztybnktgsnzkkykdatakanrino";
    public static final String ZTYKYKJIQPACKHYJ         = "ztykykjiqpackhyj";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X1 = "ztyhokensyuruikigouyobi1x1";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X2 = "ztyhokensyuruikigouyobi1x2";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X3 = "ztyhokensyuruikigouyobi1x3";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X4 = "ztyhokensyuruikigouyobi1x4";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X5 = "ztyhokensyuruikigouyobi1x5";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X6 = "ztyhokensyuruikigouyobi1x6";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X7 = "ztyhokensyuruikigouyobi1x7";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X8 = "ztyhokensyuruikigouyobi1x8";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X9 = "ztyhokensyuruikigouyobi1x9";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X10 = "ztyhokensyuruikigouyobi1x10";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X11 = "ztyhokensyuruikigouyobi1x11";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X12 = "ztyhokensyuruikigouyobi1x12";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X13 = "ztyhokensyuruikigouyobi1x13";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X14 = "ztyhokensyuruikigouyobi1x14";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X15 = "ztyhokensyuruikigouyobi1x15";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X1 = "ztyhokensyuruikigouyobi2x1";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X2 = "ztyhokensyuruikigouyobi2x2";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X3 = "ztyhokensyuruikigouyobi2x3";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X4 = "ztyhokensyuruikigouyobi2x4";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X5 = "ztyhokensyuruikigouyobi2x5";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X6 = "ztyhokensyuruikigouyobi2x6";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X7 = "ztyhokensyuruikigouyobi2x7";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X8 = "ztyhokensyuruikigouyobi2x8";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X9 = "ztyhokensyuruikigouyobi2x9";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X10 = "ztyhokensyuruikigouyobi2x10";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X1 = "ztyhokensyuruikigouyobi3x1";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X2 = "ztyhokensyuruikigouyobi3x2";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X3 = "ztyhokensyuruikigouyobi3x3";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X4 = "ztyhokensyuruikigouyobi3x4";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X5 = "ztyhokensyuruikigouyobi3x5";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X6 = "ztyhokensyuruikigouyobi3x6";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X7 = "ztyhokensyuruikigouyobi3x7";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X8 = "ztyhokensyuruikigouyobi3x8";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X9 = "ztyhokensyuruikigouyobi3x9";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X10 = "ztyhokensyuruikigouyobi3x10";
    public static final String ZTYTOKUYAKUKIGOUYOBIX1   = "ztytokuyakukigouyobix1";
    public static final String ZTYTOKUYAKUKIGOUYOBIX2   = "ztytokuyakukigouyobix2";
    public static final String ZTYTOKUYAKUKIGOUYOBIX3   = "ztytokuyakukigouyobix3";
    public static final String ZTYTOKUYAKUKIGOUYOBIX4   = "ztytokuyakukigouyobix4";
    public static final String ZTYTOKUYAKUKIGOUYOBIX5   = "ztytokuyakukigouyobix5";
    public static final String ZTYMARUTEIKIGOUYOBIX1    = "ztymaruteikigouyobix1";
    public static final String ZTYMARUTEIKIGOUYOBIX2    = "ztymaruteikigouyobix2";
    public static final String ZTYMARUTEIKIGOUYOBIX3    = "ztymaruteikigouyobix3";
    public static final String ZTYMARUTEIKIGOUYOBIX4    = "ztymaruteikigouyobix4";
    public static final String ZTYMARUTEIKIGOUYOBIX5    = "ztymaruteikigouyobix5";
    public static final String ZTYSIZNMRTIKGUYBX1       = "ztysiznmrtikguybx1";
    public static final String ZTYSIZNMRTIKGUYBX2       = "ztysiznmrtikguybx2";
    public static final String ZTYSIZNMRTIKGUYBX3       = "ztysiznmrtikguybx3";
    public static final String ZTYSIZNMRTIKGUYBX4       = "ztysiznmrtikguybx4";
    public static final String ZTYSIZNMRTIKGUYBX5       = "ztysiznmrtikguybx5";
    public static final String ZTYTEIGENMARUTEIKIGOUYOBIX1 = "ztyteigenmaruteikigouyobix1";
    public static final String ZTYTEIGENMARUTEIKIGOUYOBIX2 = "ztyteigenmaruteikigouyobix2";
    public static final String ZTYTEIGENMARUTEIKIGOUYOBIX3 = "ztyteigenmaruteikigouyobix3";
    public static final String ZTYTEIGENMARUTEIKIGOUYOBIX4 = "ztyteigenmaruteikigouyobix4";
    public static final String ZTYTEIGENMARUTEIKIGOUYOBIX5 = "ztyteigenmaruteikigouyobix5";
    public static final String ZTYSYUUNYUUMRTIKGUYBX1   = "ztysyuunyuumrtikguybx1";
    public static final String ZTYSYUUNYUUMRTIKGUYBX2   = "ztysyuunyuumrtikguybx2";
    public static final String ZTYSYUUNYUUMRTIKGUYBX3   = "ztysyuunyuumrtikguybx3";
    public static final String ZTYSYUUNYUUMRTIKGUYBX4   = "ztysyuunyuumrtikguybx4";
    public static final String ZTYSYUUNYUUMRTIKGUYBX5   = "ztysyuunyuumrtikguybx5";
    public static final String ZTYSUURIYOUYOBIN5        = "ztysuuriyouyobin5";
    public static final String ZTYSUURIYOUYOBIN5X2      = "ztysuuriyouyobin5x2";
    public static final String ZTYSUURIYOUYOBIN5X3      = "ztysuuriyouyobin5x3";
    public static final String ZTYSUURIYOUYOBIN5X4      = "ztysuuriyouyobin5x4";
    public static final String ZTYSUURIYOUYOBIN5X5      = "ztysuuriyouyobin5x5";
    public static final String ZTYYOBIV2X9              = "ztyyobiv2x9";
    public static final String ZTYYOBIN3X5              = "ztyyobin3x5";
    public static final String ZTYSUURIYOUYOBIN1X7      = "ztysuuriyouyobin1x7";
    public static final String ZTYYOBIV1X11             = "ztyyobiv1x11";
    public static final String ZTYSUURIYOUYOBIN5X6      = "ztysuuriyouyobin5x6";
    public static final String ZTYDAKUHIKETTIKJYNSYRIKBNX1 = "ztydakuhikettikjynsyrikbnx1";
    public static final String ZTYDAKUHIKETTIKJYNSYRIKBNX2 = "ztydakuhikettikjynsyrikbnx2";
    public static final String ZTYDAKUHIKETTIKJYNSYRIKBNX3 = "ztydakuhikettikjynsyrikbnx3";
    public static final String ZTYDAKUHIKETTIKJYNSYRIKBNX4 = "ztydakuhikettikjynsyrikbnx4";
    public static final String ZTYDAKUHIKETTIKJYNSYRIKBNX5 = "ztydakuhikettikjynsyrikbnx5";
    public static final String ZTYHTNKNKYKDATAKANRINOX1 = "ztyhtnknkykdatakanrinox1";
    public static final String ZTYHTNKNKYKDATAKANRINOX2 = "ztyhtnknkykdatakanrinox2";
    public static final String ZTYHTNKNKYKDATAKANRINOX3 = "ztyhtnknkykdatakanrinox3";
    public static final String ZTYHTNKNKYKDATAKANRINOX4 = "ztyhtnknkykdatakanrinox4";
    public static final String ZTYHTNKNKYKDATAKANRINOX5 = "ztyhtnknkykdatakanrinox5";
    public static final String ZTYHTNKNKYKDATAKANRINOX6 = "ztyhtnknkykdatakanrinox6";
    public static final String ZTYKEIYAKUSYAHOUJINKBN   = "ztykeiyakusyahoujinkbn";
    public static final String ZTYSUURIYOUYOBIN2X3      = "ztysuuriyouyobin2x3";
    public static final String ZTYHYUJYNKTTIDKHKTTIKEKKACD = "ztyhyujynkttidkhkttikekkacd";
    public static final String ZTYHYUJYNKTTIDKHKTTIRYUCDX1 = "ztyhyujynkttidkhkttiryucdx1";
    public static final String ZTYHYUJYNKTTIDKHKTTIRYUCDX2 = "ztyhyujynkttidkhkttiryucdx2";
    public static final String ZTYHYUJYNKTTIDKHKTTIRYUCDX3 = "ztyhyujynkttidkhkttiryucdx3";
    public static final String ZTYHYUJYNKTTIDKHKTTIRYUCDX4 = "ztyhyujynkttidkhkttiryucdx4";
    public static final String ZTYHYUJYNKTTIRYUMSHYUTN  = "ztyhyujynkttiryumshyutn";
    public static final String ZTYHYUJYNKTTISAKUGENKKN  = "ztyhyujynkttisakugenkkn";
    public static final String ZTYSPPITKYKRYUMSHYUTN    = "ztysppitkykryumshyutn";
    public static final String ZTYHYUJYNKTTITKTBUICDX1  = "ztyhyujynkttitktbuicdx1";
    public static final String ZTYHYUJYNKTTIHUTANPOKKNX1 = "ztyhyujynkttihutanpokknx1";
    public static final String ZTYHYUJYNKTTITKTBUICDX2  = "ztyhyujynkttitktbuicdx2";
    public static final String ZTYHYUJYNKTTIHUTANPOKKNX2 = "ztyhyujynkttihutanpokknx2";
    public static final String ZTYJYOUKENTUKITAISYOUKBNX1 = "ztyjyoukentukitaisyoukbnx1";
    public static final String ZTYJYUKNTKSSEIGENHYJX1   = "ztyjyukntksseigenhyjx1";
    public static final String ZTYJYUKNTKTKYKNOZOKIHYJX1 = "ztyjyukntktkyknozokihyjx1";
    public static final String ZTYSUURIYOUYOBIN1X8      = "ztysuuriyouyobin1x8";
    public static final String ZTYJYOUKENTUKISEIGENSX1  = "ztyjyoukentukiseigensx1";
    public static final String ZTYJYOUKENTUKITAISYOUKBNX2 = "ztyjyoukentukitaisyoukbnx2";
    public static final String ZTYJYUKNTKSSEIGENHYJX2   = "ztyjyukntksseigenhyjx2";
    public static final String ZTYJYUKNTKTKYKNOZOKIHYJX2 = "ztyjyukntktkyknozokihyjx2";
    public static final String ZTYSUURIYOUYOBIN1X9      = "ztysuuriyouyobin1x9";
    public static final String ZTYJYOUKENTUKISEIGENSX2  = "ztyjyoukentukiseigensx2";
    public static final String ZTYJYOUKENTUKITAISYOUKBNX3 = "ztyjyoukentukitaisyoukbnx3";
    public static final String ZTYJYUKNTKSSEIGENHYJX3   = "ztyjyukntksseigenhyjx3";
    public static final String ZTYJYUKNTKTKYKNOZOKIHYJX3 = "ztyjyukntktkyknozokihyjx3";
    public static final String ZTYSUURIYOUYOBIN1X10     = "ztysuuriyouyobin1x10";
    public static final String ZTYJYOUKENTUKISEIGENSX3  = "ztyjyoukentukiseigensx3";
    public static final String ZTYJYOUKENTUKITAISYOUKBNX4 = "ztyjyoukentukitaisyoukbnx4";
    public static final String ZTYJYUKNTKSSEIGENHYJX4   = "ztyjyukntksseigenhyjx4";
    public static final String ZTYJYUKNTKTKYKNOZOKIHYJX4 = "ztyjyukntktkyknozokihyjx4";
    public static final String ZTYSUURIYOUYOBIN1X11     = "ztysuuriyouyobin1x11";
    public static final String ZTYJYOUKENTUKISEIGENSX4  = "ztyjyoukentukiseigensx4";
    public static final String ZTYJYUKNTKKIGTIKSYRIHNKUHYJ = "ztyjyukntkkigtiksyrihnkuhyj";
    public static final String ZTYPMENSYURUIHENKOUKBN   = "ztypmensyuruihenkoukbn";
    public static final String ZTYJYOUKENTUKITAISYOUKBN2X1 = "ztyjyoukentukitaisyoukbn2x1";
    public static final String ZTYJYUKNTKSSEIGENHYJ2X1  = "ztyjyukntksseigenhyj2x1";
    public static final String ZTYJYUKNTKTKYKNOZOKIHYJ2X1 = "ztyjyukntktkyknozokihyj2x1";
    public static final String ZTYSUURIYOUYOBIN1X12     = "ztysuuriyouyobin1x12";
    public static final String ZTYJYOUKENTUKISEIGENS2X1 = "ztyjyoukentukiseigens2x1";
    public static final String ZTYJYOUKENTUKITAISYOUKBN2X2 = "ztyjyoukentukitaisyoukbn2x2";
    public static final String ZTYJYUKNTKSSEIGENHYJ2X2  = "ztyjyukntksseigenhyj2x2";
    public static final String ZTYJYUKNTKTKYKNOZOKIHYJ2X2 = "ztyjyukntktkyknozokihyj2x2";
    public static final String ZTYSUURIYOUYOBIN1X13     = "ztysuuriyouyobin1x13";
    public static final String ZTYJYOUKENTUKISEIGENS2X2 = "ztyjyoukentukiseigens2x2";
    public static final String ZTYJYOUKENTUKITAISYOUKBN2X3 = "ztyjyoukentukitaisyoukbn2x3";
    public static final String ZTYJYUKNTKSSEIGENHYJ2X3  = "ztyjyukntksseigenhyj2x3";
    public static final String ZTYJYUKNTKTKYKNOZOKIHYJ2X3 = "ztyjyukntktkyknozokihyj2x3";
    public static final String ZTYSUURIYOUYOBIN1X14     = "ztysuuriyouyobin1x14";
    public static final String ZTYJYOUKENTUKISEIGENS2X3 = "ztyjyoukentukiseigens2x3";
    public static final String ZTYJYOUKENTUKITAISYOUKBN2X4 = "ztyjyoukentukitaisyoukbn2x4";
    public static final String ZTYJYUKNTKSSEIGENHYJ2X4  = "ztyjyukntksseigenhyj2x4";
    public static final String ZTYJYUKNTKTKYKNOZOKIHYJ2X4 = "ztyjyukntktkyknozokihyj2x4";
    public static final String ZTYSUURIYOUYOBIN1X15     = "ztysuuriyouyobin1x15";
    public static final String ZTYJYOUKENTUKISEIGENS2X4 = "ztyjyoukentukiseigens2x4";
    public static final String ZTYTKTSPPIRYUMSHYUTN     = "ztytktsppiryumshyutn";
    public static final String ZTYTKTSPPISKGNKKN        = "ztytktsppiskgnkkn";
    public static final String ZTYMNSISKKNRYUMSHYUTN    = "ztymnsiskknryumshyutn";
    public static final String ZTYMANSEISIKKANSAKUGENKIKAN = "ztymanseisikkansakugenkikan";
    public static final String ZTYMANSEISIKKANTOKUTEIBUICD = "ztymanseisikkantokuteibuicd";
    public static final String ZTYMANSEISIKKANHUTANPOKIKAN = "ztymanseisikkanhutanpokikan";
    public static final String ZTYSAIHOKENKBN           = "ztysaihokenkbn";
    public static final String ZTYIMUSTIYUSBUS          = "ztyimustiyusbus";
    public static final String ZTYIMUSATEIYOUJISSITUHSYUS = "ztyimusateiyoujissituhsyus";
    public static final String ZTYISAHTNKNGUKIJISSITUHSYUS = "ztyisahtnkngukijissituhsyus";
    public static final String ZTYIMUSATEIYOUTENKANSAGAKUS = "ztyimusateiyoutenkansagakus";
    public static final String ZTYIMUSATEIYOUHANBAIKIRKBN = "ztyimusateiyouhanbaikirkbn";
    public static final String ZTYOYABOSYUUDAIRITENCD   = "ztyoyabosyuudairitencd";
    public static final String ZTYSUURIYOUBOSYUUKEITAIKBN = "ztysuuriyoubosyuukeitaikbn";
    public static final String ZTYHIHOKENSYAHOKENAGE    = "ztyhihokensyahokenage";
    public static final String ZTYRENDOUYOUMUSNTKKYKHYJ = "ztyrendouyoumusntkkykhyj";
    public static final String ZTYYOBIV2X11             = "ztyyobiv2x11";
    public static final String ZTYYOBIN3X6              = "ztyyobin3x6";
    public static final String ZTYSUURIYOUYOBIN9X4      = "ztysuuriyouyobin9x4";
    public static final String ZTYYOBIV1X20             = "ztyyobiv1x20";
    public static final String ZTYSUURIYOUYOBIN5X7      = "ztysuuriyouyobin5x7";
    public static final String ZTYHHKNNENTYSIHYJ        = "ztyhhknnentysihyj";
    public static final String ZTYSINDENZUSYOKENSYOUSAICD = "ztysindenzusyokensyousaicd";
    public static final String ZTYIMSTIYUKTEKKNSJSSHYJ  = "ztyimstiyuktekknsjsshyj";
    public static final String ZTYKETUEKIKENSASEKKEKKYUUSU = "ztyketuekikensasekkekkyuusu";
    public static final String ZTYKTEKKNSSKKKKYUSUSYKNCD = "ztyktekknsskkkkyususykncd";
    public static final String ZTYKETUEKIKENSAHAKKEKKYUUSU = "ztyketuekikensahakkekkyuusu";
    public static final String ZTYKTEKKNSHKKKKYUSUSYKNCD = "ztyktekknshkkkkyususykncd";
    public static final String ZTYKTEKKNSKETUSIKISORYOU = "ztyktekknsketusikisoryou";
    public static final String ZTYKTEKKNSKTSKSRYUSYOKENCD = "ztyktekknsktsksryusyokencd";
    public static final String ZTYKTEKKNSHEMATOKURITTO  = "ztyktekknshematokuritto";
    public static final String ZTYKTEKHMTKRTTSYKNCD     = "ztyktekhmtkrttsykncd";
    public static final String ZTYKETUEKIKENSAKESSYOUBANSU = "ztyketuekikensakessyoubansu";
    public static final String ZTYKTEKKNSKSSYUBNSUSYOKENCD = "ztyktekknskssyubnsusyokencd";
    public static final String ZTYKTEKKNSKSSISUTNPKRYU  = "ztyktekknskssisutnpkryu";
    public static final String ZTYKTEKKSSISUTNPKRYUSYKNCD = "ztyktekkssisutnpkryusykncd";
    public static final String ZTYKETUEKIKENSAARUBUMIN  = "ztyketuekikensaarubumin";
    public static final String ZTYKTEKKNSARUBUMINSYOKENCD = "ztyktekknsarubuminsyokencd";
    public static final String ZTYKETUEKIKENSAZTT       = "ztyketuekikensaztt";
    public static final String ZTYKETUEKIKENSAZTTSYOKENCD = "ztyketuekikensazttsyokencd";
    public static final String ZTYKETUEKIKENSAGOT       = "ztyketuekikensagot";
    public static final String ZTYKETUEKIKENSAGOTSYOKENCD = "ztyketuekikensagotsyokencd";
    public static final String ZTYKETUEKIKENSAGPT       = "ztyketuekikensagpt";
    public static final String ZTYKETUEKIKENSAGPTSYOKENCD = "ztyketuekikensagptsyokencd";
    public static final String ZTYKETUEKIKENSAGANMAGTP  = "ztyketuekikensaganmagtp";
    public static final String ZTYKETUEKIGANMAGTPSYOKENCD = "ztyketuekiganmagtpsyokencd";
    public static final String ZTYKETUEKIKENSASOUCHOL   = "ztyketuekikensasouchol";
    public static final String ZTYKETUEKICHOLSYOKENCD   = "ztyketuekicholsyokencd";
    public static final String ZTYKETUEKIKENSAHDLCHOL   = "ztyketuekikensahdlchol";
    public static final String ZTYKETUEKIKENSAHDLSYOKENCD = "ztyketuekikensahdlsyokencd";
    public static final String ZTYKTEKKNSTUKHMGRBN      = "ztyktekknstukhmgrbn";
    public static final String ZTYKTEKHMGRBNSYKNCD      = "ztyktekhmgrbnsykncd";
    public static final String ZTYKTEKKNSKORINESUTERRZE = "ztyktekknskorinesuterrze";
    public static final String ZTYKORINESUTERRZESYOKENCD = "ztykorinesuterrzesyokencd";
    public static final String ZTYKETUEKIKENSAMCV       = "ztyketuekikensamcv";
    public static final String ZTYKETUEKIKENSAMCVSYOKENCD = "ztyketuekikensamcvsyokencd";
    public static final String ZTYKETUEKIKENSAMCH       = "ztyketuekikensamch";
    public static final String ZTYKETUEKIKENSAMCHSYOKENCD = "ztyketuekikensamchsyokencd";
    public static final String ZTYKETUEKIKENSAMCHC      = "ztyketuekikensamchc";
    public static final String ZTYKETUEKIKENSAMCHCSYOKENCD = "ztyketuekikensamchcsyokencd";
    public static final String ZTYKETUEKIKENSACEA       = "ztyketuekikensacea";
    public static final String ZTYKETUEKIKENSACEASYOKENCD = "ztyketuekikensaceasyokencd";
    public static final String ZTYKETUEKIKENSAAFP       = "ztyketuekikensaafp";
    public static final String ZTYKETUEKIKENSAAFPSYOKENCD = "ztyketuekikensaafpsyokencd";
    public static final String ZTYKETUEKIKENSAHBSKBN    = "ztyketuekikensahbskbn";
    public static final String ZTYKETUEKIKENSAHBSSYOKENCD = "ztyketuekikensahbssyokencd";
    public static final String ZTYKETUEKIKENSAHCVKBN    = "ztyketuekikensahcvkbn";
    public static final String ZTYKETUEKIKENSAHCVSYOKENCD = "ztyketuekikensahcvsyokencd";
    public static final String ZTYIMUSATEIYOUKNSNSYTRYSKBN = "ztyimusateiyouknsnsytryskbn";
    public static final String ZTYSYOSINLDLCHOL         = "ztysyosinldlchol";
    public static final String ZTYTOKUTEIJYOUTAIHUSHRHYJ = "ztytokuteijyoutaihushrhyj";
    public static final String ZTYRENDOUYOUOSYUKEIYAKUP = "ztyrendouyouosyukeiyakup";
    public static final String ZTYTOKUBETUHOSYOUKIKAN   = "ztytokubetuhosyoukikan";
    public static final String ZTYRENDOUYOUGOUKEITENKANS = "ztyrendouyougoukeitenkans";
    public static final String ZTYRNDUYUGUKITNKNKAKAKU  = "ztyrnduyugukitnknkakaku";
    public static final String ZTYRNDUYUWNSGUKITNKNKAKAKU = "ztyrnduyuwnsgukitnknkakaku";
    public static final String ZTYMOSTNKNKHNBBNJYUTURT  = "ztymostnknkhnbbnjyuturt";
    public static final String ZTYRNDUYUSYKYKBBNKHNS    = "ztyrnduyusykykbbnkhns";
    public static final String ZTYRENDOUYOUYOTEIRIRITU  = "ztyrendouyouyoteiriritu";
    public static final String ZTYKNKUZUSNZYRT          = "ztyknkuzusnzyrt";
    public static final String ZTYYOBIV121              = "ztyyobiv121";
    public static final String ZTYRAYSYSTEMHYJ          = "ztyraysystemhyj";
    public static final String ZTYGAIKAKBN              = "ztygaikakbn";
    public static final String ZTYGAIKADATEKIHONS       = "ztygaikadatekihons";
    public static final String ZTYGAIKADATESIBOUS       = "ztygaikadatesibous";
    public static final String ZTYKEIYAKUJIYOTEIRIRITU  = "ztykeiyakujiyoteiriritu";
    public static final String ZTYKAWASERATE            = "ztykawaserate";
    public static final String ZTYKAWASERATETEKIYOUYMD  = "ztykawaseratetekiyouymd";
    public static final String ZTYENKDTSBUJSITIHSYUKNGK = "ztyenkdtsbujsitihsyukngk";
    public static final String ZTYSRDAI1HKNKKN          = "ztysrdai1hknkkn";
    public static final String ZTYSUURIYOUYOBIN8        = "ztysuuriyouyobin8";
    public static final String ZTYSUURIYOUYOBIN10X2     = "ztysuuriyouyobin10x2";
    public static final String ZTYTUUKASYUKBN           = "ztytuukasyukbn";
    public static final String ZTYYOBIV9                = "ztyyobiv9";
    public static final String ZTYYOBIV10X4             = "ztyyobiv10x4";
    public static final String ZTYYOBIN7                = "ztyyobin7";
    public static final String ZTYYOBIN7X2              = "ztyyobin7x2";
    public static final String ZTYYOBIN7X3              = "ztyyobin7x3";
    public static final String ZTYYOBIN7X4              = "ztyyobin7x4";
    public static final String ZTYYOBIN7X5              = "ztyyobin7x5";
    public static final String ZTYYOBIV4X2              = "ztyyobiv4x2";

    private final PKZT_SbRituRendouTy primaryKey;

    public GenZT_SbRituRendouTy() {
        primaryKey = new PKZT_SbRituRendouTy();
    }

    public GenZT_SbRituRendouTy(String pZtydatakanrino) {
        primaryKey = new PKZT_SbRituRendouTy(pZtydatakanrino);
    }

    @Transient
    @Override
    public PKZT_SbRituRendouTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SbRituRendouTy> getMetaClass() {
        return QZT_SbRituRendouTy.class;
    }

    private Integer ztysequenceno;

    @Column(name=GenZT_SbRituRendouTy.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return ztysequenceno;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

    private String ztyyobiv12x7;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIV12X7)
    public String getZtyyobiv12x7() {
        return ztyyobiv12x7;
    }

    public void setZtyyobiv12x7(String pZtyyobiv12x7) {
        ztyyobiv12x7 = pZtyyobiv12x7;
    }

    @Id
    @Column(name=GenZT_SbRituRendouTy.ZTYDATAKANRINO)
    public String getZtydatakanrino() {
        return getPrimaryKey().getZtydatakanrino();
    }

    public void setZtydatakanrino(String pZtydatakanrino) {
        getPrimaryKey().setZtydatakanrino(pZtydatakanrino);
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_SbRituRendouTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztysaimnkkykhyj;

    @Column(name=GenZT_SbRituRendouTy.ZTYSAIMNKKYKHYJ)
    public String getZtysaimnkkykhyj() {
        return ztysaimnkkykhyj;
    }

    public void setZtysaimnkkykhyj(String pZtysaimnkkykhyj) {
        ztysaimnkkykhyj = pZtysaimnkkykhyj;
    }

    private String ztyrendouyoukikan;

    @Column(name=GenZT_SbRituRendouTy.ZTYRENDOUYOUKIKAN)
    public String getZtyrendouyoukikan() {
        return ztyrendouyoukikan;
    }

    public void setZtyrendouyoukikan(String pZtyrendouyoukikan) {
        ztyrendouyoukikan = pZtyrendouyoukikan;
    }

    private String ztyhihokensyaagev2;

    @Column(name=GenZT_SbRituRendouTy.ZTYHIHOKENSYAAGEV2)
    public String getZtyhihokensyaagev2() {
        return ztyhihokensyaagev2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhihokensyaagev2(String pZtyhihokensyaagev2) {
        ztyhihokensyaagev2 = pZtyhihokensyaagev2;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztyrendouyoukeiyakunengetu;

    @Column(name=GenZT_SbRituRendouTy.ZTYRENDOUYOUKEIYAKUNENGETU)
    public String getZtyrendouyoukeiyakunengetu() {
        return ztyrendouyoukeiyakunengetu;
    }

    public void setZtyrendouyoukeiyakunengetu(String pZtyrendouyoukeiyakunengetu) {
        ztyrendouyoukeiyakunengetu = pZtyrendouyoukeiyakunengetu;
    }

    private Integer ztyrendouyoukihons;

    @Column(name=GenZT_SbRituRendouTy.ZTYRENDOUYOUKIHONS)
    public Integer getZtyrendouyoukihons() {
        return ztyrendouyoukihons;
    }

    public void setZtyrendouyoukihons(Integer pZtyrendouyoukihons) {
        ztyrendouyoukihons = pZtyrendouyoukihons;
    }

    private Integer ztyrendouyousibous;

    @Column(name=GenZT_SbRituRendouTy.ZTYRENDOUYOUSIBOUS)
    public Integer getZtyrendouyousibous() {
        return ztyrendouyousibous;
    }

    public void setZtyrendouyousibous(Integer pZtyrendouyousibous) {
        ztyrendouyousibous = pZtyrendouyousibous;
    }

    private Integer ztytnknitjbrigisbus;

    @Column(name=GenZT_SbRituRendouTy.ZTYTNKNITJBRIGISBUS)
    public Integer getZtytnknitjbrigisbus() {
        return ztytnknitjbrigisbus;
    }

    public void setZtytnknitjbrigisbus(Integer pZtytnknitjbrigisbus) {
        ztytnknitjbrigisbus = pZtytnknitjbrigisbus;
    }

    private String ztytenkanminaosikbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYTENKANMINAOSIKBN)
    public String getZtytenkanminaosikbn() {
        return ztytenkanminaosikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytenkanminaosikbn(String pZtytenkanminaosikbn) {
        ztytenkanminaosikbn = pZtytenkanminaosikbn;
    }

    private String ztyrendouyouhrkhouhoukbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYRENDOUYOUHRKHOUHOUKBN)
    public String getZtyrendouyouhrkhouhoukbn() {
        return ztyrendouyouhrkhouhoukbn;
    }

    public void setZtyrendouyouhrkhouhoukbn(String pZtyrendouyouhrkhouhoukbn) {
        ztyrendouyouhrkhouhoukbn = pZtyrendouyouhrkhouhoukbn;
    }

    private String ztyrendouyoujyuusyokbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYRENDOUYOUJYUUSYOKBN)
    public String getZtyrendouyoujyuusyokbn() {
        return ztyrendouyoujyuusyokbn;
    }

    public void setZtyrendouyoujyuusyokbn(String pZtyrendouyoujyuusyokbn) {
        ztyrendouyoujyuusyokbn = pZtyrendouyoujyuusyokbn;
    }

    private String ztyaatukaisosikicd;

    @Column(name=GenZT_SbRituRendouTy.ZTYAATUKAISOSIKICD)
    public String getZtyaatukaisosikicd() {
        return ztyaatukaisosikicd;
    }

    public void setZtyaatukaisosikicd(String pZtyaatukaisosikicd) {
        ztyaatukaisosikicd = pZtyaatukaisosikicd;
    }

    private String ztyrendouyousakugenkikan;

    @Column(name=GenZT_SbRituRendouTy.ZTYRENDOUYOUSAKUGENKIKAN)
    public String getZtyrendouyousakugenkikan() {
        return ztyrendouyousakugenkikan;
    }

    public void setZtyrendouyousakugenkikan(String pZtyrendouyousakugenkikan) {
        ztyrendouyousakugenkikan = pZtyrendouyousakugenkikan;
    }

    private String ztyrnduyuryumshyutn;

    @Column(name=GenZT_SbRituRendouTy.ZTYRNDUYURYUMSHYUTN)
    public String getZtyrnduyuryumshyutn() {
        return ztyrnduyuryumshyutn;
    }

    public void setZtyrnduyuryumshyutn(String pZtyrnduyuryumshyutn) {
        ztyrnduyuryumshyutn = pZtyrnduyuryumshyutn;
    }

    private String ztyrendouyoubosyuuym;

    @Column(name=GenZT_SbRituRendouTy.ZTYRENDOUYOUBOSYUUYM)
    public String getZtyrendouyoubosyuuym() {
        return ztyrendouyoubosyuuym;
    }

    public void setZtyrendouyoubosyuuym(String pZtyrendouyoubosyuuym) {
        ztyrendouyoubosyuuym = pZtyrendouyoubosyuuym;
    }

    private String ztysuuriyouyobin1;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN1)
    public String getZtysuuriyouyobin1() {
        return ztysuuriyouyobin1;
    }

    public void setZtysuuriyouyobin1(String pZtysuuriyouyobin1) {
        ztysuuriyouyobin1 = pZtysuuriyouyobin1;
    }

    private String ztysykgycd;

    @Column(name=GenZT_SbRituRendouTy.ZTYSYKGYCD)
    public String getZtysykgycd() {
        return ztysykgycd;
    }

    public void setZtysykgycd(String pZtysykgycd) {
        ztysykgycd = pZtysykgycd;
    }

    private String ztydakuhikettisyacd;

    @Column(name=GenZT_SbRituRendouTy.ZTYDAKUHIKETTISYACD)
    public String getZtydakuhikettisyacd() {
        return ztydakuhikettisyacd;
    }

    public void setZtydakuhikettisyacd(String pZtydakuhikettisyacd) {
        ztydakuhikettisyacd = pZtydakuhikettisyacd;
    }

    private String ztydai2hihokensyahyouji;

    @Column(name=GenZT_SbRituRendouTy.ZTYDAI2HIHOKENSYAHYOUJI)
    public String getZtydai2hihokensyahyouji() {
        return ztydai2hihokensyahyouji;
    }

    public void setZtydai2hihokensyahyouji(String pZtydai2hihokensyahyouji) {
        ztydai2hihokensyahyouji = pZtydai2hihokensyahyouji;
    }

    private String ztyrenseimusntkknyuhyj;

    @Column(name=GenZT_SbRituRendouTy.ZTYRENSEIMUSNTKKNYUHYJ)
    public String getZtyrenseimusntkknyuhyj() {
        return ztyrenseimusntkknyuhyj;
    }

    public void setZtyrenseimusntkknyuhyj(String pZtyrenseimusntkknyuhyj) {
        ztyrenseimusntkknyuhyj = pZtyrenseimusntkknyuhyj;
    }

    private String ztytokubetumaruteiarihyj;

    @Column(name=GenZT_SbRituRendouTy.ZTYTOKUBETUMARUTEIARIHYJ)
    public String getZtytokubetumaruteiarihyj() {
        return ztytokubetumaruteiarihyj;
    }

    public void setZtytokubetumaruteiarihyj(String pZtytokubetumaruteiarihyj) {
        ztytokubetumaruteiarihyj = pZtytokubetumaruteiarihyj;
    }

    private String ztydougakutenkanhyouji;

    @Column(name=GenZT_SbRituRendouTy.ZTYDOUGAKUTENKANHYOUJI)
    public String getZtydougakutenkanhyouji() {
        return ztydougakutenkanhyouji;
    }

    public void setZtydougakutenkanhyouji(String pZtydougakutenkanhyouji) {
        ztydougakutenkanhyouji = pZtydougakutenkanhyouji;
    }

    private String ztytenkansentakuhouhoukbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYTENKANSENTAKUHOUHOUKBN)
    public String getZtytenkansentakuhouhoukbn() {
        return ztytenkansentakuhouhoukbn;
    }

    public void setZtytenkansentakuhouhoukbn(String pZtytenkansentakuhouhoukbn) {
        ztytenkansentakuhouhoukbn = pZtytenkansentakuhouhoukbn;
    }

    private String ztytokubetusentakuarikbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYTOKUBETUSENTAKUARIKBN)
    public String getZtytokubetusentakuarikbn() {
        return ztytokubetusentakuarikbn;
    }

    public void setZtytokubetusentakuarikbn(String pZtytokubetusentakuarikbn) {
        ztytokubetusentakuarikbn = pZtytokubetusentakuarikbn;
    }

    private String ztyketteikekkakbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETTEIKEKKAKBN)
    public String getZtyketteikekkakbn() {
        return ztyketteikekkakbn;
    }

    public void setZtyketteikekkakbn(String pZtyketteikekkakbn) {
        ztyketteikekkakbn = pZtyketteikekkakbn;
    }

    private String ztykeiyakukakuninsyuruikbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYKEIYAKUKAKUNINSYURUIKBN)
    public String getZtykeiyakukakuninsyuruikbn() {
        return ztykeiyakukakuninsyuruikbn;
    }

    public void setZtykeiyakukakuninsyuruikbn(String pZtykeiyakukakuninsyuruikbn) {
        ztykeiyakukakuninsyuruikbn = pZtykeiyakukakuninsyuruikbn;
    }

    private String ztykeiyakukakuninriyuukbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYKEIYAKUKAKUNINRIYUUKBN)
    public String getZtykeiyakukakuninriyuukbn() {
        return ztykeiyakukakuninriyuukbn;
    }

    public void setZtykeiyakukakuninriyuukbn(String pZtykeiyakukakuninriyuukbn) {
        ztykeiyakukakuninriyuukbn = pZtykeiyakukakuninriyuukbn;
    }

    private String ztyrendouyoukekkancdx1;

    @Column(name=GenZT_SbRituRendouTy.ZTYRENDOUYOUKEKKANCDX1)
    public String getZtyrendouyoukekkancdx1() {
        return ztyrendouyoukekkancdx1;
    }

    public void setZtyrendouyoukekkancdx1(String pZtyrendouyoukekkancdx1) {
        ztyrendouyoukekkancdx1 = pZtyrendouyoukekkancdx1;
    }

    private String ztykeikanensuux1;

    @Column(name=GenZT_SbRituRendouTy.ZTYKEIKANENSUUX1)
    public String getZtykeikanensuux1() {
        return ztykeikanensuux1;
    }

    public void setZtykeikanensuux1(String pZtykeikanensuux1) {
        ztykeikanensuux1 = pZtykeikanensuux1;
    }

    private String ztysyujyutuarihyoujix1;

    @Column(name=GenZT_SbRituRendouTy.ZTYSYUJYUTUARIHYOUJIX1)
    public String getZtysyujyutuarihyoujix1() {
        return ztysyujyutuarihyoujix1;
    }

    public void setZtysyujyutuarihyoujix1(String pZtysyujyutuarihyoujix1) {
        ztysyujyutuarihyoujix1 = pZtysyujyutuarihyoujix1;
    }

    private String ztyrendouyoukekkancdx2;

    @Column(name=GenZT_SbRituRendouTy.ZTYRENDOUYOUKEKKANCDX2)
    public String getZtyrendouyoukekkancdx2() {
        return ztyrendouyoukekkancdx2;
    }

    public void setZtyrendouyoukekkancdx2(String pZtyrendouyoukekkancdx2) {
        ztyrendouyoukekkancdx2 = pZtyrendouyoukekkancdx2;
    }

    private String ztykeikanensuux2;

    @Column(name=GenZT_SbRituRendouTy.ZTYKEIKANENSUUX2)
    public String getZtykeikanensuux2() {
        return ztykeikanensuux2;
    }

    public void setZtykeikanensuux2(String pZtykeikanensuux2) {
        ztykeikanensuux2 = pZtykeikanensuux2;
    }

    private String ztysyujyutuarihyoujix2;

    @Column(name=GenZT_SbRituRendouTy.ZTYSYUJYUTUARIHYOUJIX2)
    public String getZtysyujyutuarihyoujix2() {
        return ztysyujyutuarihyoujix2;
    }

    public void setZtysyujyutuarihyoujix2(String pZtysyujyutuarihyoujix2) {
        ztysyujyutuarihyoujix2 = pZtysyujyutuarihyoujix2;
    }

    private String ztysaihokenhyouji;

    @Column(name=GenZT_SbRituRendouTy.ZTYSAIHOKENHYOUJI)
    public String getZtysaihokenhyouji() {
        return ztysaihokenhyouji;
    }

    public void setZtysaihokenhyouji(String pZtysaihokenhyouji) {
        ztysaihokenhyouji = pZtysaihokenhyouji;
    }

    private String ztyrnduyusysnhujyusnssyacd;

    @Column(name=GenZT_SbRituRendouTy.ZTYRNDUYUSYSNHUJYUSNSSYACD)
    public String getZtyrnduyusysnhujyusnssyacd() {
        return ztyrnduyusysnhujyusnssyacd;
    }

    public void setZtyrnduyusysnhujyusnssyacd(String pZtyrnduyusysnhujyusnssyacd) {
        ztyrnduyusysnhujyusnssyacd = pZtyrnduyusysnhujyusnssyacd;
    }

    private String ztyrndyusysnhujyusnshuhukbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYRNDYUSYSNHUJYUSNSHUHUKBN)
    public String getZtyrndyusysnhujyusnshuhukbn() {
        return ztyrndyusysnhujyusnshuhukbn;
    }

    public void setZtyrndyusysnhujyusnshuhukbn(String pZtyrndyusysnhujyusnshuhukbn) {
        ztyrndyusysnhujyusnshuhukbn = pZtyrndyusysnhujyusnshuhukbn;
    }

    private String ztysaisinriyuukbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYSAISINRIYUUKBN)
    public String getZtysaisinriyuukbn() {
        return ztysaisinriyuukbn;
    }

    public void setZtysaisinriyuukbn(String pZtysaisinriyuukbn) {
        ztysaisinriyuukbn = pZtysaisinriyuukbn;
    }

    private String ztynyoutousaisinarihyouji;

    @Column(name=GenZT_SbRituRendouTy.ZTYNYOUTOUSAISINARIHYOUJI)
    public String getZtynyoutousaisinarihyouji() {
        return ztynyoutousaisinarihyouji;
    }

    public void setZtynyoutousaisinarihyouji(String pZtynyoutousaisinarihyouji) {
        ztynyoutousaisinarihyouji = pZtynyoutousaisinarihyouji;
    }

    private String ztynyoutanpakusaisinarihyj;

    @Column(name=GenZT_SbRituRendouTy.ZTYNYOUTANPAKUSAISINARIHYJ)
    public String getZtynyoutanpakusaisinarihyj() {
        return ztynyoutanpakusaisinarihyj;
    }

    public void setZtynyoutanpakusaisinarihyj(String pZtynyoutanpakusaisinarihyj) {
        ztynyoutanpakusaisinarihyj = pZtynyoutanpakusaisinarihyj;
    }

    private String ztyhemasaisinarihyouji;

    @Column(name=GenZT_SbRituRendouTy.ZTYHEMASAISINARIHYOUJI)
    public String getZtyhemasaisinarihyouji() {
        return ztyhemasaisinarihyouji;
    }

    public void setZtyhemasaisinarihyouji(String pZtyhemasaisinarihyouji) {
        ztyhemasaisinarihyouji = pZtyhemasaisinarihyouji;
    }

    private String ztykettousaisinarihyouji;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETTOUSAISINARIHYOUJI)
    public String getZtykettousaisinarihyouji() {
        return ztykettousaisinarihyouji;
    }

    public void setZtykettousaisinarihyouji(String pZtykettousaisinarihyouji) {
        ztykettousaisinarihyouji = pZtykettousaisinarihyouji;
    }

    private String ztysintyousaisinarihyouji;

    @Column(name=GenZT_SbRituRendouTy.ZTYSINTYOUSAISINARIHYOUJI)
    public String getZtysintyousaisinarihyouji() {
        return ztysintyousaisinarihyouji;
    }

    public void setZtysintyousaisinarihyouji(String pZtysintyousaisinarihyouji) {
        ztysintyousaisinarihyouji = pZtysintyousaisinarihyouji;
    }

    private String ztykyouisaisinarihyouji;

    @Column(name=GenZT_SbRituRendouTy.ZTYKYOUISAISINARIHYOUJI)
    public String getZtykyouisaisinarihyouji() {
        return ztykyouisaisinarihyouji;
    }

    public void setZtykyouisaisinarihyouji(String pZtykyouisaisinarihyouji) {
        ztykyouisaisinarihyouji = pZtykyouisaisinarihyouji;
    }

    private String ztyhukuisaisinarihyouji;

    @Column(name=GenZT_SbRituRendouTy.ZTYHUKUISAISINARIHYOUJI)
    public String getZtyhukuisaisinarihyouji() {
        return ztyhukuisaisinarihyouji;
    }

    public void setZtyhukuisaisinarihyouji(String pZtyhukuisaisinarihyouji) {
        ztyhukuisaisinarihyouji = pZtyhukuisaisinarihyouji;
    }

    private String ztytaijyuusaisinarihyouji;

    @Column(name=GenZT_SbRituRendouTy.ZTYTAIJYUUSAISINARIHYOUJI)
    public String getZtytaijyuusaisinarihyouji() {
        return ztytaijyuusaisinarihyouji;
    }

    public void setZtytaijyuusaisinarihyouji(String pZtytaijyuusaisinarihyouji) {
        ztytaijyuusaisinarihyouji = pZtytaijyuusaisinarihyouji;
    }

    private String ztyketuatusaisinarihyouji;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUATUSAISINARIHYOUJI)
    public String getZtyketuatusaisinarihyouji() {
        return ztyketuatusaisinarihyouji;
    }

    public void setZtyketuatusaisinarihyouji(String pZtyketuatusaisinarihyouji) {
        ztyketuatusaisinarihyouji = pZtyketuatusaisinarihyouji;
    }

    private String ztyrndyusisnhujyusnssyacd;

    @Column(name=GenZT_SbRituRendouTy.ZTYRNDYUSISNHUJYUSNSSYACD)
    public String getZtyrndyusisnhujyusnssyacd() {
        return ztyrndyusisnhujyusnssyacd;
    }

    public void setZtyrndyusisnhujyusnssyacd(String pZtyrndyusisnhujyusnssyacd) {
        ztyrndyusisnhujyusnssyacd = pZtyrndyusisnhujyusnssyacd;
    }

    private String ztyrndyusisnhujyusnshuhukbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYRNDYUSISNHUJYUSNSHUHUKBN)
    public String getZtyrndyusisnhujyusnshuhukbn() {
        return ztyrndyusisnhujyusnshuhukbn;
    }

    public void setZtyrndyusisnhujyusnshuhukbn(String pZtyrndyusisnhujyusnshuhukbn) {
        ztyrndyusisnhujyusnshuhukbn = pZtyrndyusisnhujyusnshuhukbn;
    }

    private String ztynyoutoukbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYNYOUTOUKBN)
    public String getZtynyoutoukbn() {
        return ztynyoutoukbn;
    }

    public void setZtynyoutoukbn(String pZtynyoutoukbn) {
        ztynyoutoukbn = pZtynyoutoukbn;
    }

    private String ztyyobiv1x2;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIV1X2)
    public String getZtyyobiv1x2() {
        return ztyyobiv1x2;
    }

    public void setZtyyobiv1x2(String pZtyyobiv1x2) {
        ztyyobiv1x2 = pZtyyobiv1x2;
    }

    private String ztynyoutanpakukbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYNYOUTANPAKUKBN)
    public String getZtynyoutanpakukbn() {
        return ztynyoutanpakukbn;
    }

    public void setZtynyoutanpakukbn(String pZtynyoutanpakukbn) {
        ztynyoutanpakukbn = pZtynyoutanpakukbn;
    }

    private String ztyhemakbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYHEMAKBN)
    public String getZtyhemakbn() {
        return ztyhemakbn;
    }

    public void setZtyhemakbn(String pZtyhemakbn) {
        ztyhemakbn = pZtyhemakbn;
    }

    private String ztykettoutikeikajikan;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETTOUTIKEIKAJIKAN)
    public String getZtykettoutikeikajikan() {
        return ztykettoutikeikajikan;
    }

    public void setZtykettoutikeikajikan(String pZtykettoutikeikajikan) {
        ztykettoutikeikajikan = pZtykettoutikeikajikan;
    }

    private Integer ztykettouti;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETTOUTI)
    public Integer getZtykettouti() {
        return ztykettouti;
    }

    public void setZtykettouti(Integer pZtykettouti) {
        ztykettouti = pZtykettouti;
    }

    private Integer ztysintyou;

    @Column(name=GenZT_SbRituRendouTy.ZTYSINTYOU)
    public Integer getZtysintyou() {
        return ztysintyou;
    }

    public void setZtysintyou(Integer pZtysintyou) {
        ztysintyou = pZtysintyou;
    }

    private Integer ztykyoui;

    @Column(name=GenZT_SbRituRendouTy.ZTYKYOUI)
    public Integer getZtykyoui() {
        return ztykyoui;
    }

    public void setZtykyoui(Integer pZtykyoui) {
        ztykyoui = pZtykyoui;
    }

    private Integer ztyhukui;

    @Column(name=GenZT_SbRituRendouTy.ZTYHUKUI)
    public Integer getZtyhukui() {
        return ztyhukui;
    }

    public void setZtyhukui(Integer pZtyhukui) {
        ztyhukui = pZtyhukui;
    }

    private Integer ztytaijyuu;

    @Column(name=GenZT_SbRituRendouTy.ZTYTAIJYUU)
    public Integer getZtytaijyuu() {
        return ztytaijyuu;
    }

    public void setZtytaijyuu(Integer pZtytaijyuu) {
        ztytaijyuu = pZtytaijyuu;
    }

    private Integer ztysaikouketuatu;

    @Column(name=GenZT_SbRituRendouTy.ZTYSAIKOUKETUATU)
    public Integer getZtysaikouketuatu() {
        return ztysaikouketuatu;
    }

    public void setZtysaikouketuatu(Integer pZtysaikouketuatu) {
        ztysaikouketuatu = pZtysaikouketuatu;
    }

    private Integer ztysaiteiketuatu;

    @Column(name=GenZT_SbRituRendouTy.ZTYSAITEIKETUATU)
    public Integer getZtysaiteiketuatu() {
        return ztysaiteiketuatu;
    }

    public void setZtysaiteiketuatu(Integer pZtysaiteiketuatu) {
        ztysaiteiketuatu = pZtysaiteiketuatu;
    }

    private String ztyxsensyokencd;

    @Column(name=GenZT_SbRituRendouTy.ZTYXSENSYOKENCD)
    public String getZtyxsensyokencd() {
        return ztyxsensyokencd;
    }

    public void setZtyxsensyokencd(String pZtyxsensyokencd) {
        ztyxsensyokencd = pZtyxsensyokencd;
    }

    private String ztysindenzusyokencd;

    @Column(name=GenZT_SbRituRendouTy.ZTYSINDENZUSYOKENCD)
    public String getZtysindenzusyokencd() {
        return ztysindenzusyokencd;
    }

    public void setZtysindenzusyokencd(String pZtysindenzusyokencd) {
        ztysindenzusyokencd = pZtysindenzusyokencd;
    }

    private String ztyrnduyuganteisysnsyokencd;

    @Column(name=GenZT_SbRituRendouTy.ZTYRNDUYUGANTEISYSNSYOKENCD)
    public String getZtyrnduyuganteisysnsyokencd() {
        return ztyrnduyuganteisysnsyokencd;
    }

    public void setZtyrnduyuganteisysnsyokencd(String pZtyrnduyuganteisysnsyokencd) {
        ztyrnduyuganteisysnsyokencd = pZtyrnduyuganteisysnsyokencd;
    }

    private String ztysinsahouhousiyoukbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYSINSAHOUHOUSIYOUKBN)
    public String getZtysinsahouhousiyoukbn() {
        return ztysinsahouhousiyoukbn;
    }

    public void setZtysinsahouhousiyoukbn(String pZtysinsahouhousiyoukbn) {
        ztysinsahouhousiyoukbn = pZtysinsahouhousiyoukbn;
    }

    private String ztyvipteikihyouji;

    @Column(name=GenZT_SbRituRendouTy.ZTYVIPTEIKIHYOUJI)
    public String getZtyvipteikihyouji() {
        return ztyvipteikihyouji;
    }

    public void setZtyvipteikihyouji(String pZtyvipteikihyouji) {
        ztyvipteikihyouji = pZtyvipteikihyouji;
    }

    private String ztyhoujyounomihyouji;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOUJYOUNOMIHYOUJI)
    public String getZtyhoujyounomihyouji() {
        return ztyhoujyounomihyouji;
    }

    public void setZtyhoujyounomihyouji(String pZtyhoujyounomihyouji) {
        ztyhoujyounomihyouji = pZtyhoujyounomihyouji;
    }

    private String ztyketuekikensajissikbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAJISSIKBN)
    public String getZtyketuekikensajissikbn() {
        return ztyketuekikensajissikbn;
    }

    public void setZtyketuekikensajissikbn(String pZtyketuekikensajissikbn) {
        ztyketuekikensajissikbn = pZtyketuekikensajissikbn;
    }

    private String ztymaruteisyuruikigou;

    @Column(name=GenZT_SbRituRendouTy.ZTYMARUTEISYURUIKIGOU)
    public String getZtymaruteisyuruikigou() {
        return ztymaruteisyuruikigou;
    }

    public void setZtymaruteisyuruikigou(String pZtymaruteisyuruikigou) {
        ztymaruteisyuruikigou = pZtymaruteisyuruikigou;
    }

    private String ztyseizonmrtisyuruikgu;

    @Column(name=GenZT_SbRituRendouTy.ZTYSEIZONMRTISYURUIKGU)
    public String getZtyseizonmrtisyuruikgu() {
        return ztyseizonmrtisyuruikgu;
    }

    public void setZtyseizonmrtisyuruikgu(String pZtyseizonmrtisyuruikgu) {
        ztyseizonmrtisyuruikgu = pZtyseizonmrtisyuruikgu;
    }

    private Integer ztyketusikisoryou;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUSIKISORYOU)
    public Integer getZtyketusikisoryou() {
        return ztyketusikisoryou;
    }

    public void setZtyketusikisoryou(Integer pZtyketusikisoryou) {
        ztyketusikisoryou = pZtyketusikisoryou;
    }

    private Integer ztygot;

    @Column(name=GenZT_SbRituRendouTy.ZTYGOT)
    public Integer getZtygot() {
        return ztygot;
    }

    public void setZtygot(Integer pZtygot) {
        ztygot = pZtygot;
    }

    private Integer ztygpt;

    @Column(name=GenZT_SbRituRendouTy.ZTYGPT)
    public Integer getZtygpt() {
        return ztygpt;
    }

    public void setZtygpt(Integer pZtygpt) {
        ztygpt = pZtygpt;
    }

    private Integer ztyganmagtp;

    @Column(name=GenZT_SbRituRendouTy.ZTYGANMAGTP)
    public Integer getZtyganmagtp() {
        return ztyganmagtp;
    }

    public void setZtyganmagtp(Integer pZtyganmagtp) {
        ztyganmagtp = pZtyganmagtp;
    }

    private String ztysyumisyatkisindenzukbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYSYUMISYATKISINDENZUKBN)
    public String getZtysyumisyatkisindenzukbn() {
        return ztysyumisyatkisindenzukbn;
    }

    public void setZtysyumisyatkisindenzukbn(String pZtysyumisyatkisindenzukbn) {
        ztysyumisyatkisindenzukbn = pZtysyumisyatkisindenzukbn;
    }

    private String ztykituenkbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYKITUENKBN)
    public String getZtykituenkbn() {
        return ztykituenkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykituenkbn(String pZtykituenkbn) {
        ztykituenkbn = pZtykituenkbn;
    }

    private String ztytignmrtisyukgu;

    @Column(name=GenZT_SbRituRendouTy.ZTYTIGNMRTISYUKGU)
    public String getZtytignmrtisyukgu() {
        return ztytignmrtisyukgu;
    }

    public void setZtytignmrtisyukgu(String pZtytignmrtisyukgu) {
        ztytignmrtisyukgu = pZtytignmrtisyukgu;
    }

    private String ztyteigenmaruteikikan;

    @Column(name=GenZT_SbRituRendouTy.ZTYTEIGENMARUTEIKIKAN)
    public String getZtyteigenmaruteikikan() {
        return ztyteigenmaruteikikan;
    }

    public void setZtyteigenmaruteikikan(String pZtyteigenmaruteikikan) {
        ztyteigenmaruteikikan = pZtyteigenmaruteikikan;
    }

    private String ztykituenhonsuu;

    @Column(name=GenZT_SbRituRendouTy.ZTYKITUENHONSUU)
    public String getZtykituenhonsuu() {
        return ztykituenhonsuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykituenhonsuu(String pZtykituenhonsuu) {
        ztykituenhonsuu = pZtykituenhonsuu;
    }

    private String ztyyobiv2;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIV2)
    public String getZtyyobiv2() {
        return ztyyobiv2;
    }

    public void setZtyyobiv2(String pZtyyobiv2) {
        ztyyobiv2 = pZtyyobiv2;
    }

    private String ztysuuriyouyobin1x2;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN1X2)
    public String getZtysuuriyouyobin1x2() {
        return ztysuuriyouyobin1x2;
    }

    public void setZtysuuriyouyobin1x2(String pZtysuuriyouyobin1x2) {
        ztysuuriyouyobin1x2 = pZtysuuriyouyobin1x2;
    }

    private Integer ztyrnduyusppinyuintkykntgk;

    @Column(name=GenZT_SbRituRendouTy.ZTYRNDUYUSPPINYUINTKYKNTGK)
    public Integer getZtyrnduyusppinyuintkykntgk() {
        return ztyrnduyusppinyuintkykntgk;
    }

    public void setZtyrnduyusppinyuintkykntgk(Integer pZtyrnduyusppinyuintkykntgk) {
        ztyrnduyusppinyuintkykntgk = pZtyrnduyusppinyuintkykntgk;
    }

    private String ztysuuriyouyobin12;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN12)
    public String getZtysuuriyouyobin12() {
        return ztysuuriyouyobin12;
    }

    public void setZtysuuriyouyobin12(String pZtysuuriyouyobin12) {
        ztysuuriyouyobin12 = pZtysuuriyouyobin12;
    }

    private String ztyyobiv2x2;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIV2X2)
    public String getZtyyobiv2x2() {
        return ztyyobiv2x2;
    }

    public void setZtyyobiv2x2(String pZtyyobiv2x2) {
        ztyyobiv2x2 = pZtyyobiv2x2;
    }

    private String ztysuuriyouyobin1x3;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN1X3)
    public String getZtysuuriyouyobin1x3() {
        return ztysuuriyouyobin1x3;
    }

    public void setZtysuuriyouyobin1x3(String pZtysuuriyouyobin1x3) {
        ztysuuriyouyobin1x3 = pZtysuuriyouyobin1x3;
    }

    private Integer ztyyobin3;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIN3)
    public Integer getZtyyobin3() {
        return ztyyobin3;
    }

    public void setZtyyobin3(Integer pZtyyobin3) {
        ztyyobin3 = pZtyyobin3;
    }

    private String ztysuuriyouyobin12x2;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN12X2)
    public String getZtysuuriyouyobin12x2() {
        return ztysuuriyouyobin12x2;
    }

    public void setZtysuuriyouyobin12x2(String pZtysuuriyouyobin12x2) {
        ztysuuriyouyobin12x2 = pZtysuuriyouyobin12x2;
    }

    private Integer ztygoukeiteigenteikitkyks;

    @Column(name=GenZT_SbRituRendouTy.ZTYGOUKEITEIGENTEIKITKYKS)
    public Integer getZtygoukeiteigenteikitkyks() {
        return ztygoukeiteigenteikitkyks;
    }

    public void setZtygoukeiteigenteikitkyks(Integer pZtygoukeiteigenteikitkyks) {
        ztygoukeiteigenteikitkyks = pZtygoukeiteigenteikitkyks;
    }

    private Integer ztytigntikbbntnknitjbrs;

    @Column(name=GenZT_SbRituRendouTy.ZTYTIGNTIKBBNTNKNITJBRS)
    public Integer getZtytigntikbbntnknitjbrs() {
        return ztytigntikbbntnknitjbrs;
    }

    public void setZtytigntikbbntnknitjbrs(Integer pZtytigntikbbntnknitjbrs) {
        ztytigntikbbntnknitjbrs = pZtytigntikbbntnknitjbrs;
    }

    private String ztytokuteisippeisetkbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYTOKUTEISIPPEISETKBN)
    public String getZtytokuteisippeisetkbn() {
        return ztytokuteisippeisetkbn;
    }

    public void setZtytokuteisippeisetkbn(String pZtytokuteisippeisetkbn) {
        ztytokuteisippeisetkbn = pZtytokuteisippeisetkbn;
    }

    private String ztysuuriyouyobin2;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN2)
    public String getZtysuuriyouyobin2() {
        return ztysuuriyouyobin2;
    }

    public void setZtysuuriyouyobin2(String pZtysuuriyouyobin2) {
        ztysuuriyouyobin2 = pZtysuuriyouyobin2;
    }

    private String ztytaikakukijyunkanwahyouji;

    @Column(name=GenZT_SbRituRendouTy.ZTYTAIKAKUKIJYUNKANWAHYOUJI)
    public String getZtytaikakukijyunkanwahyouji() {
        return ztytaikakukijyunkanwahyouji;
    }

    public void setZtytaikakukijyunkanwahyouji(String pZtytaikakukijyunkanwahyouji) {
        ztytaikakukijyunkanwahyouji = pZtytaikakukijyunkanwahyouji;
    }

    private String ztyhaitoukbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYHAITOUKBN)
    public String getZtyhaitoukbn() {
        return ztyhaitoukbn;
    }

    public void setZtyhaitoukbn(String pZtyhaitoukbn) {
        ztyhaitoukbn = pZtyhaitoukbn;
    }

    private String ztysnsykrketkbtsntkarihyj;

    @Column(name=GenZT_SbRituRendouTy.ZTYSNSYKRKETKBTSNTKARIHYJ)
    public String getZtysnsykrketkbtsntkarihyj() {
        return ztysnsykrketkbtsntkarihyj;
    }

    public void setZtysnsykrketkbtsntkarihyj(String pZtysnsykrketkbtsntkarihyj) {
        ztysnsykrketkbtsntkarihyj = pZtysnsykrketkbtsntkarihyj;
    }

    private String ztyaatukaikojincd;

    @Column(name=GenZT_SbRituRendouTy.ZTYAATUKAIKOJINCD)
    public String getZtyaatukaikojincd() {
        return ztyaatukaikojincd;
    }

    public void setZtyaatukaikojincd(String pZtyaatukaikojincd) {
        ztyaatukaikojincd = pZtyaatukaikojincd;
    }

    private String ztyyobiv1x5;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIV1X5)
    public String getZtyyobiv1x5() {
        return ztyyobiv1x5;
    }

    public void setZtyyobiv1x5(String pZtyyobiv1x5) {
        ztyyobiv1x5 = pZtyyobiv1x5;
    }

    private String ztymanseisikkansetkbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYMANSEISIKKANSETKBN)
    public String getZtymanseisikkansetkbn() {
        return ztymanseisikkansetkbn;
    }

    public void setZtymanseisikkansetkbn(String pZtymanseisikkansetkbn) {
        ztymanseisikkansetkbn = pZtymanseisikkansetkbn;
    }

    private String ztygengakutenkankykhyj;

    @Column(name=GenZT_SbRituRendouTy.ZTYGENGAKUTENKANKYKHYJ)
    public String getZtygengakutenkankykhyj() {
        return ztygengakutenkankykhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtygengakutenkankykhyj(String pZtygengakutenkankykhyj) {
        ztygengakutenkankykhyj = pZtygengakutenkankykhyj;
    }

    private String ztyyobiv2x4;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIV2X4)
    public String getZtyyobiv2x4() {
        return ztyyobiv2x4;
    }

    public void setZtyyobiv2x4(String pZtyyobiv2x4) {
        ztyyobiv2x4 = pZtyyobiv2x4;
    }

    private String ztyfilekbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYFILEKBN)
    public String getZtyfilekbn() {
        return ztyfilekbn;
    }

    public void setZtyfilekbn(String pZtyfilekbn) {
        ztyfilekbn = pZtyfilekbn;
    }

    private String ztyyobiv2x5;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIV2X5)
    public String getZtyyobiv2x5() {
        return ztyyobiv2x5;
    }

    public void setZtyyobiv2x5(String pZtyyobiv2x5) {
        ztyyobiv2x5 = pZtyyobiv2x5;
    }

    private String ztysuuriyouyobin1x4;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN1X4)
    public String getZtysuuriyouyobin1x4() {
        return ztysuuriyouyobin1x4;
    }

    public void setZtysuuriyouyobin1x4(String pZtysuuriyouyobin1x4) {
        ztysuuriyouyobin1x4 = pZtysuuriyouyobin1x4;
    }

    private Integer ztyyobin3x2;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIN3X2)
    public Integer getZtyyobin3x2() {
        return ztyyobin3x2;
    }

    public void setZtyyobin3x2(Integer pZtyyobin3x2) {
        ztyyobin3x2 = pZtyyobin3x2;
    }

    private String ztysuuriyouyobin12x3;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN12X3)
    public String getZtysuuriyouyobin12x3() {
        return ztysuuriyouyobin12x3;
    }

    public void setZtysuuriyouyobin12x3(String pZtysuuriyouyobin12x3) {
        ztysuuriyouyobin12x3 = pZtysuuriyouyobin12x3;
    }

    private String ztyyobiv2x6;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIV2X6)
    public String getZtyyobiv2x6() {
        return ztyyobiv2x6;
    }

    public void setZtyyobiv2x6(String pZtyyobiv2x6) {
        ztyyobiv2x6 = pZtyyobiv2x6;
    }

    private String ztysuuriyouyobin1x5;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN1X5)
    public String getZtysuuriyouyobin1x5() {
        return ztysuuriyouyobin1x5;
    }

    public void setZtysuuriyouyobin1x5(String pZtysuuriyouyobin1x5) {
        ztysuuriyouyobin1x5 = pZtysuuriyouyobin1x5;
    }

    private Integer ztyyobin3x3;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIN3X3)
    public Integer getZtyyobin3x3() {
        return ztyyobin3x3;
    }

    public void setZtyyobin3x3(Integer pZtyyobin3x3) {
        ztyyobin3x3 = pZtyyobin3x3;
    }

    private String ztysuuriyouyobin12x4;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN12X4)
    public String getZtysuuriyouyobin12x4() {
        return ztysuuriyouyobin12x4;
    }

    public void setZtysuuriyouyobin12x4(String pZtysuuriyouyobin12x4) {
        ztysuuriyouyobin12x4 = pZtysuuriyouyobin12x4;
    }

    private String ztyyobiv2x7;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIV2X7)
    public String getZtyyobiv2x7() {
        return ztyyobiv2x7;
    }

    public void setZtyyobiv2x7(String pZtyyobiv2x7) {
        ztyyobiv2x7 = pZtyyobiv2x7;
    }

    private String ztysuuriyouyobin1x6;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN1X6)
    public String getZtysuuriyouyobin1x6() {
        return ztysuuriyouyobin1x6;
    }

    public void setZtysuuriyouyobin1x6(String pZtysuuriyouyobin1x6) {
        ztysuuriyouyobin1x6 = pZtysuuriyouyobin1x6;
    }

    private Integer ztyyobin3x4;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIN3X4)
    public Integer getZtyyobin3x4() {
        return ztyyobin3x4;
    }

    public void setZtyyobin3x4(Integer pZtyyobin3x4) {
        ztyyobin3x4 = pZtyyobin3x4;
    }

    private String ztysuuriyouyobin12x5;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN12X5)
    public String getZtysuuriyouyobin12x5() {
        return ztysuuriyouyobin12x5;
    }

    public void setZtysuuriyouyobin12x5(String pZtysuuriyouyobin12x5) {
        ztysuuriyouyobin12x5 = pZtysuuriyouyobin12x5;
    }

    private Integer ztytaikakuhyouten;

    @Column(name=GenZT_SbRituRendouTy.ZTYTAIKAKUHYOUTEN)
    public Integer getZtytaikakuhyouten() {
        return ztytaikakuhyouten;
    }

    public void setZtytaikakuhyouten(Integer pZtytaikakuhyouten) {
        ztytaikakuhyouten = pZtytaikakuhyouten;
    }

    private Integer ztynyoutousykykhyutn;

    @Column(name=GenZT_SbRituRendouTy.ZTYNYOUTOUSYKYKHYUTN)
    public Integer getZtynyoutousykykhyutn() {
        return ztynyoutousykykhyutn;
    }

    public void setZtynyoutousykykhyutn(Integer pZtynyoutousykykhyutn) {
        ztynyoutousykykhyutn = pZtynyoutousykykhyutn;
    }

    private Integer ztynyoutanpakusykykhyutn;

    @Column(name=GenZT_SbRituRendouTy.ZTYNYOUTANPAKUSYKYKHYUTN)
    public Integer getZtynyoutanpakusykykhyutn() {
        return ztynyoutanpakusykykhyutn;
    }

    public void setZtynyoutanpakusykykhyutn(Integer pZtynyoutanpakusykykhyutn) {
        ztynyoutanpakusykykhyutn = pZtynyoutanpakusykykhyutn;
    }

    private Integer ztyketuatutandokuhyouten;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUATUTANDOKUHYOUTEN)
    public Integer getZtyketuatutandokuhyouten() {
        return ztyketuatutandokuhyouten;
    }

    public void setZtyketuatutandokuhyouten(Integer pZtyketuatutandokuhyouten) {
        ztyketuatutandokuhyouten = pZtyketuatutandokuhyouten;
    }

    private Integer ztyyobin5;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIN5)
    public Integer getZtyyobin5() {
        return ztyyobin5;
    }

    public void setZtyyobin5(Integer pZtyyobin5) {
        ztyyobin5 = pZtyyobin5;
    }

    private String ztysuuriyouyobin9;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN9)
    public String getZtysuuriyouyobin9() {
        return ztysuuriyouyobin9;
    }

    public void setZtysuuriyouyobin9(String pZtysuuriyouyobin9) {
        ztysuuriyouyobin9 = pZtysuuriyouyobin9;
    }

    private Integer ztyyobin5x2;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIN5X2)
    public Integer getZtyyobin5x2() {
        return ztyyobin5x2;
    }

    public void setZtyyobin5x2(Integer pZtyyobin5x2) {
        ztyyobin5x2 = pZtyyobin5x2;
    }

    private String ztysuuriyouyobin9x2;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN9X2)
    public String getZtysuuriyouyobin9x2() {
        return ztysuuriyouyobin9x2;
    }

    public void setZtysuuriyouyobin9x2(String pZtysuuriyouyobin9x2) {
        ztysuuriyouyobin9x2 = pZtysuuriyouyobin9x2;
    }

    private Integer ztyyobin5x3;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIN5X3)
    public Integer getZtyyobin5x3() {
        return ztyyobin5x3;
    }

    public void setZtyyobin5x3(Integer pZtyyobin5x3) {
        ztyyobin5x3 = pZtyyobin5x3;
    }

    private String ztysuuriyouyobin9x3;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN9X3)
    public String getZtysuuriyouyobin9x3() {
        return ztysuuriyouyobin9x3;
    }

    public void setZtysuuriyouyobin9x3(String pZtysuuriyouyobin9x3) {
        ztysuuriyouyobin9x3 = pZtysuuriyouyobin9x3;
    }

    private String ztysyunyumrtisyukgu;

    @Column(name=GenZT_SbRituRendouTy.ZTYSYUNYUMRTISYUKGU)
    public String getZtysyunyumrtisyukgu() {
        return ztysyunyumrtisyukgu;
    }

    public void setZtysyunyumrtisyukgu(String pZtysyunyumrtisyukgu) {
        ztysyunyumrtisyukgu = pZtysyunyumrtisyukgu;
    }

    private String ztysyuunyuumaruteikikan;

    @Column(name=GenZT_SbRituRendouTy.ZTYSYUUNYUUMARUTEIKIKAN)
    public String getZtysyuunyuumaruteikikan() {
        return ztysyuunyuumaruteikikan;
    }

    public void setZtysyuunyuumaruteikikan(String pZtysyuunyuumaruteikikan) {
        ztysyuunyuumaruteikikan = pZtysyuunyuumaruteikikan;
    }

    private Integer ztysyuunyuumrtinknengkn5;

    @Column(name=GenZT_SbRituRendouTy.ZTYSYUUNYUUMRTINKNENGKN5)
    public Integer getZtysyuunyuumrtinknengkn5() {
        return ztysyuunyuumrtinknengkn5;
    }

    public void setZtysyuunyuumrtinknengkn5(Integer pZtysyuunyuumrtinknengkn5) {
        ztysyuunyuumrtinknengkn5 = pZtysyuunyuumrtinknengkn5;
    }

    private String ztysyuunyuumrtinkshrkkn;

    @Column(name=GenZT_SbRituRendouTy.ZTYSYUUNYUUMRTINKSHRKKN)
    public String getZtysyuunyuumrtinkshrkkn() {
        return ztysyuunyuumrtinkshrkkn;
    }

    public void setZtysyuunyuumrtinkshrkkn(String pZtysyuunyuumrtinkshrkkn) {
        ztysyuunyuumrtinkshrkkn = pZtysyuunyuumrtinkshrkkn;
    }

    private String ztysuuriyouyobin12x6;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN12X6)
    public String getZtysuuriyouyobin12x6() {
        return ztysuuriyouyobin12x6;
    }

    public void setZtysuuriyouyobin12x6(String pZtysuuriyouyobin12x6) {
        ztysuuriyouyobin12x6 = pZtysuuriyouyobin12x6;
    }

    private String ztyhutanpobui1;

    @Column(name=GenZT_SbRituRendouTy.ZTYHUTANPOBUI1)
    public String getZtyhutanpobui1() {
        return ztyhutanpobui1;
    }

    public void setZtyhutanpobui1(String pZtyhutanpobui1) {
        ztyhutanpobui1 = pZtyhutanpobui1;
    }

    private String ztyhtnpkkn1;

    @Column(name=GenZT_SbRituRendouTy.ZTYHTNPKKN1)
    public String getZtyhtnpkkn1() {
        return ztyhtnpkkn1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhtnpkkn1(String pZtyhtnpkkn1) {
        ztyhtnpkkn1 = pZtyhtnpkkn1;
    }

    private String ztyhutanpobui2;

    @Column(name=GenZT_SbRituRendouTy.ZTYHUTANPOBUI2)
    public String getZtyhutanpobui2() {
        return ztyhutanpobui2;
    }

    public void setZtyhutanpobui2(String pZtyhutanpobui2) {
        ztyhutanpobui2 = pZtyhutanpobui2;
    }

    private String ztyhtnpkkn2;

    @Column(name=GenZT_SbRituRendouTy.ZTYHTNPKKN2)
    public String getZtyhtnpkkn2() {
        return ztyhtnpkkn2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhtnpkkn2(String pZtyhtnpkkn2) {
        ztyhtnpkkn2 = pZtyhtnpkkn2;
    }

    private String ztysyosinnyoutou;

    @Column(name=GenZT_SbRituRendouTy.ZTYSYOSINNYOUTOU)
    public String getZtysyosinnyoutou() {
        return ztysyosinnyoutou;
    }

    public void setZtysyosinnyoutou(String pZtysyosinnyoutou) {
        ztysyosinnyoutou = pZtysyosinnyoutou;
    }

    private String ztysyosinnyoutanpaku;

    @Column(name=GenZT_SbRituRendouTy.ZTYSYOSINNYOUTANPAKU)
    public String getZtysyosinnyoutanpaku() {
        return ztysyosinnyoutanpaku;
    }

    public void setZtysyosinnyoutanpaku(String pZtysyosinnyoutanpaku) {
        ztysyosinnyoutanpaku = pZtysyosinnyoutanpaku;
    }

    private String ztysyosinnyousenketu;

    @Column(name=GenZT_SbRituRendouTy.ZTYSYOSINNYOUSENKETU)
    public String getZtysyosinnyousenketu() {
        return ztysyosinnyousenketu;
    }

    public void setZtysyosinnyousenketu(String pZtysyosinnyousenketu) {
        ztysyosinnyousenketu = pZtysyosinnyousenketu;
    }

    private Integer ztysyosinsaikouketuatu;

    @Column(name=GenZT_SbRituRendouTy.ZTYSYOSINSAIKOUKETUATU)
    public Integer getZtysyosinsaikouketuatu() {
        return ztysyosinsaikouketuatu;
    }

    public void setZtysyosinsaikouketuatu(Integer pZtysyosinsaikouketuatu) {
        ztysyosinsaikouketuatu = pZtysyosinsaikouketuatu;
    }

    private Integer ztysyosinsaiteiketuatu;

    @Column(name=GenZT_SbRituRendouTy.ZTYSYOSINSAITEIKETUATU)
    public Integer getZtysyosinsaiteiketuatu() {
        return ztysyosinsaiteiketuatu;
    }

    public void setZtysyosinsaiteiketuatu(Integer pZtysyosinsaiteiketuatu) {
        ztysyosinsaiteiketuatu = pZtysyosinsaiteiketuatu;
    }

    private String ztysaisinnyoutou;

    @Column(name=GenZT_SbRituRendouTy.ZTYSAISINNYOUTOU)
    public String getZtysaisinnyoutou() {
        return ztysaisinnyoutou;
    }

    public void setZtysaisinnyoutou(String pZtysaisinnyoutou) {
        ztysaisinnyoutou = pZtysaisinnyoutou;
    }

    private String ztysaisinnyoutanpaku;

    @Column(name=GenZT_SbRituRendouTy.ZTYSAISINNYOUTANPAKU)
    public String getZtysaisinnyoutanpaku() {
        return ztysaisinnyoutanpaku;
    }

    public void setZtysaisinnyoutanpaku(String pZtysaisinnyoutanpaku) {
        ztysaisinnyoutanpaku = pZtysaisinnyoutanpaku;
    }

    private String ztysaisinnyousenketu;

    @Column(name=GenZT_SbRituRendouTy.ZTYSAISINNYOUSENKETU)
    public String getZtysaisinnyousenketu() {
        return ztysaisinnyousenketu;
    }

    public void setZtysaisinnyousenketu(String pZtysaisinnyousenketu) {
        ztysaisinnyousenketu = pZtysaisinnyousenketu;
    }

    private Integer ztysaisinsaikouketuatu;

    @Column(name=GenZT_SbRituRendouTy.ZTYSAISINSAIKOUKETUATU)
    public Integer getZtysaisinsaikouketuatu() {
        return ztysaisinsaikouketuatu;
    }

    public void setZtysaisinsaikouketuatu(Integer pZtysaisinsaikouketuatu) {
        ztysaisinsaikouketuatu = pZtysaisinsaikouketuatu;
    }

    private Integer ztysaisinsaiteiketuatu;

    @Column(name=GenZT_SbRituRendouTy.ZTYSAISINSAITEIKETUATU)
    public Integer getZtysaisinsaiteiketuatu() {
        return ztysaisinsaiteiketuatu;
    }

    public void setZtysaisinsaiteiketuatu(Integer pZtysaisinsaiteiketuatu) {
        ztysaisinsaiteiketuatu = pZtysaisinsaiteiketuatu;
    }

    private String ztyketuekikensaijyou1;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAIJYOU1)
    public String getZtyketuekikensaijyou1() {
        return ztyketuekikensaijyou1;
    }

    public void setZtyketuekikensaijyou1(String pZtyketuekikensaijyou1) {
        ztyketuekikensaijyou1 = pZtyketuekikensaijyou1;
    }

    private String ztyketuekikensaijyou2;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAIJYOU2)
    public String getZtyketuekikensaijyou2() {
        return ztyketuekikensaijyou2;
    }

    public void setZtyketuekikensaijyou2(String pZtyketuekikensaijyou2) {
        ztyketuekikensaijyou2 = pZtyketuekikensaijyou2;
    }

    private String ztyketuekikensaijyou3;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAIJYOU3)
    public String getZtyketuekikensaijyou3() {
        return ztyketuekikensaijyou3;
    }

    public void setZtyketuekikensaijyou3(String pZtyketuekikensaijyou3) {
        ztyketuekikensaijyou3 = pZtyketuekikensaijyou3;
    }

    private String ztyketuekikensaijyou4;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAIJYOU4)
    public String getZtyketuekikensaijyou4() {
        return ztyketuekikensaijyou4;
    }

    public void setZtyketuekikensaijyou4(String pZtyketuekikensaijyou4) {
        ztyketuekikensaijyou4 = pZtyketuekikensaijyou4;
    }

    private String ztyketuekikensaijyou5;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAIJYOU5)
    public String getZtyketuekikensaijyou5() {
        return ztyketuekikensaijyou5;
    }

    public void setZtyketuekikensaijyou5(String pZtyketuekikensaijyou5) {
        ztyketuekikensaijyou5 = pZtyketuekikensaijyou5;
    }

    private String ztyhukasyukeiyakukigou;

    @Column(name=GenZT_SbRituRendouTy.ZTYHUKASYUKEIYAKUKIGOU)
    public String getZtyhukasyukeiyakukigou() {
        return ztyhukasyukeiyakukigou;
    }

    public void setZtyhukasyukeiyakukigou(String pZtyhukasyukeiyakukigou) {
        ztyhukasyukeiyakukigou = pZtyhukasyukeiyakukigou;
    }

    private String ztysekininkaisiymd;

    @Column(name=GenZT_SbRituRendouTy.ZTYSEKININKAISIYMD)
    public String getZtysekininkaisiymd() {
        return ztysekininkaisiymd;
    }

    public void setZtysekininkaisiymd(String pZtysekininkaisiymd) {
        ztysekininkaisiymd = pZtysekininkaisiymd;
    }

    private Integer ztysyosinmyakuhakusuu;

    @Column(name=GenZT_SbRituRendouTy.ZTYSYOSINMYAKUHAKUSUU)
    public Integer getZtysyosinmyakuhakusuu() {
        return ztysyosinmyakuhakusuu;
    }

    public void setZtysyosinmyakuhakusuu(Integer pZtysyosinmyakuhakusuu) {
        ztysyosinmyakuhakusuu = pZtysyosinmyakuhakusuu;
    }

    private Integer ztysyosinhuseimyakusuu;

    @Column(name=GenZT_SbRituRendouTy.ZTYSYOSINHUSEIMYAKUSUU)
    public Integer getZtysyosinhuseimyakusuu() {
        return ztysyosinhuseimyakusuu;
    }

    public void setZtysyosinhuseimyakusuu(Integer pZtysyosinhuseimyakusuu) {
        ztysyosinhuseimyakusuu = pZtysyosinhuseimyakusuu;
    }

    private Integer ztysaisinmyakuhakusuu;

    @Column(name=GenZT_SbRituRendouTy.ZTYSAISINMYAKUHAKUSUU)
    public Integer getZtysaisinmyakuhakusuu() {
        return ztysaisinmyakuhakusuu;
    }

    public void setZtysaisinmyakuhakusuu(Integer pZtysaisinmyakuhakusuu) {
        ztysaisinmyakuhakusuu = pZtysaisinmyakuhakusuu;
    }

    private Integer ztysaisinhuseimyakusuu;

    @Column(name=GenZT_SbRituRendouTy.ZTYSAISINHUSEIMYAKUSUU)
    public Integer getZtysaisinhuseimyakusuu() {
        return ztysaisinhuseimyakusuu;
    }

    public void setZtysaisinhuseimyakusuu(Integer pZtysaisinhuseimyakusuu) {
        ztysaisinhuseimyakusuu = pZtysaisinhuseimyakusuu;
    }

    private String ztysuuriyouyobin2x2;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN2X2)
    public String getZtysuuriyouyobin2x2() {
        return ztysuuriyouyobin2x2;
    }

    public void setZtysuuriyouyobin2x2(String pZtysuuriyouyobin2x2) {
        ztysuuriyouyobin2x2 = pZtysuuriyouyobin2x2;
    }

    private Integer ztysouhyouten;

    @Column(name=GenZT_SbRituRendouTy.ZTYSOUHYOUTEN)
    public Integer getZtysouhyouten() {
        return ztysouhyouten;
    }

    public void setZtysouhyouten(Integer pZtysouhyouten) {
        ztysouhyouten = pZtysouhyouten;
    }

    private String ztytoukeiyukykymd;

    @Column(name=GenZT_SbRituRendouTy.ZTYTOUKEIYUKYKYMD)
    public String getZtytoukeiyukykymd() {
        return ztytoukeiyukykymd;
    }

    public void setZtytoukeiyukykymd(String pZtytoukeiyukykymd) {
        ztytoukeiyukykymd = pZtytoukeiyukykymd;
    }

    private String ztydakuhiketteiriyuucdx1;

    @Column(name=GenZT_SbRituRendouTy.ZTYDAKUHIKETTEIRIYUUCDX1)
    public String getZtydakuhiketteiriyuucdx1() {
        return ztydakuhiketteiriyuucdx1;
    }

    public void setZtydakuhiketteiriyuucdx1(String pZtydakuhiketteiriyuucdx1) {
        ztydakuhiketteiriyuucdx1 = pZtydakuhiketteiriyuucdx1;
    }

    private String ztydakuhiketteiriyuucdx2;

    @Column(name=GenZT_SbRituRendouTy.ZTYDAKUHIKETTEIRIYUUCDX2)
    public String getZtydakuhiketteiriyuucdx2() {
        return ztydakuhiketteiriyuucdx2;
    }

    public void setZtydakuhiketteiriyuucdx2(String pZtydakuhiketteiriyuucdx2) {
        ztydakuhiketteiriyuucdx2 = pZtydakuhiketteiriyuucdx2;
    }

    private String ztydakuhiketteiriyuucdx3;

    @Column(name=GenZT_SbRituRendouTy.ZTYDAKUHIKETTEIRIYUUCDX3)
    public String getZtydakuhiketteiriyuucdx3() {
        return ztydakuhiketteiriyuucdx3;
    }

    public void setZtydakuhiketteiriyuucdx3(String pZtydakuhiketteiriyuucdx3) {
        ztydakuhiketteiriyuucdx3 = pZtydakuhiketteiriyuucdx3;
    }

    private String ztydakuhiketteiriyuucdx4;

    @Column(name=GenZT_SbRituRendouTy.ZTYDAKUHIKETTEIRIYUUCDX4)
    public String getZtydakuhiketteiriyuucdx4() {
        return ztydakuhiketteiriyuucdx4;
    }

    public void setZtydakuhiketteiriyuucdx4(String pZtydakuhiketteiriyuucdx4) {
        ztydakuhiketteiriyuucdx4 = pZtydakuhiketteiriyuucdx4;
    }

    private String ztykanwamaeryouzouhyouten;

    @Column(name=GenZT_SbRituRendouTy.ZTYKANWAMAERYOUZOUHYOUTEN)
    public String getZtykanwamaeryouzouhyouten() {
        return ztykanwamaeryouzouhyouten;
    }

    public void setZtykanwamaeryouzouhyouten(String pZtykanwamaeryouzouhyouten) {
        ztykanwamaeryouzouhyouten = pZtykanwamaeryouzouhyouten;
    }

    private String ztyryoumasitokujyoukanwahyj;

    @Column(name=GenZT_SbRituRendouTy.ZTYRYOUMASITOKUJYOUKANWAHYJ)
    public String getZtyryoumasitokujyoukanwahyj() {
        return ztyryoumasitokujyoukanwahyj;
    }

    public void setZtyryoumasitokujyoukanwahyj(String pZtyryoumasitokujyoukanwahyj) {
        ztyryoumasitokujyoukanwahyj = pZtyryoumasitokujyoukanwahyj;
    }

    private String ztyhtnptokujyoukanwahyj;

    @Column(name=GenZT_SbRituRendouTy.ZTYHTNPTOKUJYOUKANWAHYJ)
    public String getZtyhtnptokujyoukanwahyj() {
        return ztyhtnptokujyoukanwahyj;
    }

    public void setZtyhtnptokujyoukanwahyj(String pZtyhtnptokujyoukanwahyj) {
        ztyhtnptokujyoukanwahyj = pZtyhtnptokujyoukanwahyj;
    }

    private String ztyhknsyuruikigousedaikbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYHKNSYURUIKIGOUSEDAIKBN)
    public String getZtyhknsyuruikigousedaikbn() {
        return ztyhknsyuruikigousedaikbn;
    }

    public void setZtyhknsyuruikigousedaikbn(String pZtyhknsyuruikigousedaikbn) {
        ztyhknsyuruikigousedaikbn = pZtyhknsyuruikigousedaikbn;
    }

    private String ztymaruteikigousedaikbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYMARUTEIKIGOUSEDAIKBN)
    public String getZtymaruteikigousedaikbn() {
        return ztymaruteikigousedaikbn;
    }

    public void setZtymaruteikigousedaikbn(String pZtymaruteikigousedaikbn) {
        ztymaruteikigousedaikbn = pZtymaruteikigousedaikbn;
    }

    private String ztyseizonmrtikgusdkbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYSEIZONMRTIKGUSDKBN)
    public String getZtyseizonmrtikgusdkbn() {
        return ztyseizonmrtikgusdkbn;
    }

    public void setZtyseizonmrtikgusdkbn(String pZtyseizonmrtikgusdkbn) {
        ztyseizonmrtikgusdkbn = pZtyseizonmrtikgusdkbn;
    }

    private String ztyteigenmrtikgusdkbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYTEIGENMRTIKGUSDKBN)
    public String getZtyteigenmrtikgusdkbn() {
        return ztyteigenmrtikgusdkbn;
    }

    public void setZtyteigenmrtikgusdkbn(String pZtyteigenmrtikgusdkbn) {
        ztyteigenmrtikgusdkbn = pZtyteigenmrtikgusdkbn;
    }

    private String ztysyuunyuumrtikgusdkbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYSYUUNYUUMRTIKGUSDKBN)
    public String getZtysyuunyuumrtikgusdkbn() {
        return ztysyuunyuumrtikgusdkbn;
    }

    public void setZtysyuunyuumrtikgusdkbn(String pZtysyuunyuumrtikgusdkbn) {
        ztysyuunyuumrtikgusdkbn = pZtysyuunyuumrtikgusdkbn;
    }

    private String ztyyobiv4;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIV4)
    public String getZtyyobiv4() {
        return ztyyobiv4;
    }

    public void setZtyyobiv4(String pZtyyobiv4) {
        ztyyobiv4 = pZtyyobiv4;
    }

    private String ztyhksykykkgusdkbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYHKSYKYKKGUSDKBN)
    public String getZtyhksykykkgusdkbn() {
        return ztyhksykykkgusdkbn;
    }

    public void setZtyhksykykkgusdkbn(String pZtyhksykykkgusdkbn) {
        ztyhksykykkgusdkbn = pZtyhksykykkgusdkbn;
    }

    private String ztyhhknsynensyuukbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYHHKNSYNENSYUUKBN)
    public String getZtyhhknsynensyuukbn() {
        return ztyhhknsynensyuukbn;
    }

    public void setZtyhhknsynensyuukbn(String pZtyhhknsynensyuukbn) {
        ztyhhknsynensyuukbn = pZtyhhknsynensyuukbn;
    }

    private String ztypmentokuyakukbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYPMENTOKUYAKUKBN)
    public String getZtypmentokuyakukbn() {
        return ztypmentokuyakukbn;
    }

    public void setZtypmentokuyakukbn(String pZtypmentokuyakukbn) {
        ztypmentokuyakukbn = pZtypmentokuyakukbn;
    }

    private Integer ztypmennenkansanp;

    @Column(name=GenZT_SbRituRendouTy.ZTYPMENNENKANSANP)
    public Integer getZtypmennenkansanp() {
        return ztypmennenkansanp;
    }

    public void setZtypmennenkansanp(Integer pZtypmennenkansanp) {
        ztypmennenkansanp = pZtypmennenkansanp;
    }

    private String ztyyobiv1x9;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIV1X9)
    public String getZtyyobiv1x9() {
        return ztyyobiv1x9;
    }

    public void setZtyyobiv1x9(String pZtyyobiv1x9) {
        ztyyobiv1x9 = pZtyyobiv1x9;
    }

    private String ztysyosinsouchol;

    @Column(name=GenZT_SbRituRendouTy.ZTYSYOSINSOUCHOL)
    public String getZtysyosinsouchol() {
        return ztysyosinsouchol;
    }

    public void setZtysyosinsouchol(String pZtysyosinsouchol) {
        ztysyosinsouchol = pZtysyosinsouchol;
    }

    private String ztysyosinhdlchol;

    @Column(name=GenZT_SbRituRendouTy.ZTYSYOSINHDLCHOL)
    public String getZtysyosinhdlchol() {
        return ztysyosinhdlchol;
    }

    public void setZtysyosinhdlchol(String pZtysyosinhdlchol) {
        ztysyosinhdlchol = pZtysyosinhdlchol;
    }

    private String ztysyosintyuuseisibou;

    @Column(name=GenZT_SbRituRendouTy.ZTYSYOSINTYUUSEISIBOU)
    public String getZtysyosintyuuseisibou() {
        return ztysyosintyuuseisibou;
    }

    public void setZtysyosintyuuseisibou(String pZtysyosintyuuseisibou) {
        ztysyosintyuuseisibou = pZtysyosintyuuseisibou;
    }

    private String ztysysnsyumisyatkikettouti;

    @Column(name=GenZT_SbRituRendouTy.ZTYSYSNSYUMISYATKIKETTOUTI)
    public String getZtysysnsyumisyatkikettouti() {
        return ztysysnsyumisyatkikettouti;
    }

    public void setZtysysnsyumisyatkikettouti(String pZtysysnsyumisyatkikettouti) {
        ztysysnsyumisyatkikettouti = pZtysysnsyumisyatkikettouti;
    }

    private BizNumber ztysyosintoukahemogurobin;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouTy.ZTYSYOSINTOUKAHEMOGUROBIN)
    public BizNumber getZtysyosintoukahemogurobin() {
        return ztysyosintoukahemogurobin;
    }

    public void setZtysyosintoukahemogurobin(BizNumber pZtysyosintoukahemogurobin) {
        ztysyosintoukahemogurobin = pZtysyosintoukahemogurobin;
    }

    private BizNumber ztysyosinnyousan;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouTy.ZTYSYOSINNYOUSAN)
    public BizNumber getZtysyosinnyousan() {
        return ztysyosinnyousan;
    }

    public void setZtysyosinnyousan(BizNumber pZtysyosinnyousan) {
        ztysyosinnyousan = pZtysyosinnyousan;
    }

    private BizNumber ztysyosinkureatinin;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouTy.ZTYSYOSINKUREATININ)
    public BizNumber getZtysyosinkureatinin() {
        return ztysyosinkureatinin;
    }

    public void setZtysyosinkureatinin(BizNumber pZtysyosinkureatinin) {
        ztysyosinkureatinin = pZtysyosinkureatinin;
    }

    private String ztybosyuukeirokbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYBOSYUUKEIROKBN)
    public String getZtybosyuukeirokbn() {
        return ztybosyuukeirokbn;
    }

    public void setZtybosyuukeirokbn(String pZtybosyuukeirokbn) {
        ztybosyuukeirokbn = pZtybosyuukeirokbn;
    }

    private String ztybsudirtnatkikeitaikbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYBSUDIRTNATKIKEITAIKBN)
    public String getZtybsudirtnatkikeitaikbn() {
        return ztybsudirtnatkikeitaikbn;
    }

    public void setZtybsudirtnatkikeitaikbn(String pZtybsudirtnatkikeitaikbn) {
        ztybsudirtnatkikeitaikbn = pZtybsudirtnatkikeitaikbn;
    }

    private String ztykigkyhsitihsyutkykarihyj;

    @Column(name=GenZT_SbRituRendouTy.ZTYKIGKYHSITIHSYUTKYKARIHYJ)
    public String getZtykigkyhsitihsyutkykarihyj() {
        return ztykigkyhsitihsyutkykarihyj;
    }

    public void setZtykigkyhsitihsyutkykarihyj(String pZtykigkyhsitihsyutkykarihyj) {
        ztykigkyhsitihsyutkykarihyj = pZtykigkyhsitihsyutkykarihyj;
    }

    private String ztypmenhutanpobui1;

    @Column(name=GenZT_SbRituRendouTy.ZTYPMENHUTANPOBUI1)
    public String getZtypmenhutanpobui1() {
        return ztypmenhutanpobui1;
    }

    public void setZtypmenhutanpobui1(String pZtypmenhutanpobui1) {
        ztypmenhutanpobui1 = pZtypmenhutanpobui1;
    }

    private String ztypmenhutanpokikan1;

    @Column(name=GenZT_SbRituRendouTy.ZTYPMENHUTANPOKIKAN1)
    public String getZtypmenhutanpokikan1() {
        return ztypmenhutanpokikan1;
    }

    public void setZtypmenhutanpokikan1(String pZtypmenhutanpokikan1) {
        ztypmenhutanpokikan1 = pZtypmenhutanpokikan1;
    }

    private String ztypmenhutanpobui2;

    @Column(name=GenZT_SbRituRendouTy.ZTYPMENHUTANPOBUI2)
    public String getZtypmenhutanpobui2() {
        return ztypmenhutanpobui2;
    }

    public void setZtypmenhutanpobui2(String pZtypmenhutanpobui2) {
        ztypmenhutanpobui2 = pZtypmenhutanpobui2;
    }

    private String ztypmenhutanpokikan2;

    @Column(name=GenZT_SbRituRendouTy.ZTYPMENHUTANPOKIKAN2)
    public String getZtypmenhutanpokikan2() {
        return ztypmenhutanpokikan2;
    }

    public void setZtypmenhutanpokikan2(String pZtypmenhutanpokikan2) {
        ztypmenhutanpokikan2 = pZtypmenhutanpokikan2;
    }

    private String ztykanyujidatakanrino;

    @Column(name=GenZT_SbRituRendouTy.ZTYKANYUJIDATAKANRINO)
    public String getZtykanyujidatakanrino() {
        return ztykanyujidatakanrino;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZtykanyujidatakanrino(String pZtykanyujidatakanrino) {
        ztykanyujidatakanrino = pZtykanyujidatakanrino;
    }

    private String ztybnktgsnzkkykdatakanrino;

    @Column(name=GenZT_SbRituRendouTy.ZTYBNKTGSNZKKYKDATAKANRINO)
    public String getZtybnktgsnzkkykdatakanrino() {
        return ztybnktgsnzkkykdatakanrino;
    }

    public void setZtybnktgsnzkkykdatakanrino(String pZtybnktgsnzkkykdatakanrino) {
        ztybnktgsnzkkykdatakanrino = pZtybnktgsnzkkykdatakanrino;
    }

    private String ztykykjiqpackhyj;

    @Column(name=GenZT_SbRituRendouTy.ZTYKYKJIQPACKHYJ)
    public String getZtykykjiqpackhyj() {
        return ztykykjiqpackhyj;
    }

    public void setZtykykjiqpackhyj(String pZtykykjiqpackhyj) {
        ztykykjiqpackhyj = pZtykykjiqpackhyj;
    }

    private String ztyhokensyuruikigouyobi1x1;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X1)
    public String getZtyhokensyuruikigouyobi1x1() {
        return ztyhokensyuruikigouyobi1x1;
    }

    public void setZtyhokensyuruikigouyobi1x1(String pZtyhokensyuruikigouyobi1x1) {
        ztyhokensyuruikigouyobi1x1 = pZtyhokensyuruikigouyobi1x1;
    }

    private String ztyhokensyuruikigouyobi1x2;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X2)
    public String getZtyhokensyuruikigouyobi1x2() {
        return ztyhokensyuruikigouyobi1x2;
    }

    public void setZtyhokensyuruikigouyobi1x2(String pZtyhokensyuruikigouyobi1x2) {
        ztyhokensyuruikigouyobi1x2 = pZtyhokensyuruikigouyobi1x2;
    }

    private String ztyhokensyuruikigouyobi1x3;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X3)
    public String getZtyhokensyuruikigouyobi1x3() {
        return ztyhokensyuruikigouyobi1x3;
    }

    public void setZtyhokensyuruikigouyobi1x3(String pZtyhokensyuruikigouyobi1x3) {
        ztyhokensyuruikigouyobi1x3 = pZtyhokensyuruikigouyobi1x3;
    }

    private String ztyhokensyuruikigouyobi1x4;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X4)
    public String getZtyhokensyuruikigouyobi1x4() {
        return ztyhokensyuruikigouyobi1x4;
    }

    public void setZtyhokensyuruikigouyobi1x4(String pZtyhokensyuruikigouyobi1x4) {
        ztyhokensyuruikigouyobi1x4 = pZtyhokensyuruikigouyobi1x4;
    }

    private String ztyhokensyuruikigouyobi1x5;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X5)
    public String getZtyhokensyuruikigouyobi1x5() {
        return ztyhokensyuruikigouyobi1x5;
    }

    public void setZtyhokensyuruikigouyobi1x5(String pZtyhokensyuruikigouyobi1x5) {
        ztyhokensyuruikigouyobi1x5 = pZtyhokensyuruikigouyobi1x5;
    }

    private String ztyhokensyuruikigouyobi1x6;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X6)
    public String getZtyhokensyuruikigouyobi1x6() {
        return ztyhokensyuruikigouyobi1x6;
    }

    public void setZtyhokensyuruikigouyobi1x6(String pZtyhokensyuruikigouyobi1x6) {
        ztyhokensyuruikigouyobi1x6 = pZtyhokensyuruikigouyobi1x6;
    }

    private String ztyhokensyuruikigouyobi1x7;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X7)
    public String getZtyhokensyuruikigouyobi1x7() {
        return ztyhokensyuruikigouyobi1x7;
    }

    public void setZtyhokensyuruikigouyobi1x7(String pZtyhokensyuruikigouyobi1x7) {
        ztyhokensyuruikigouyobi1x7 = pZtyhokensyuruikigouyobi1x7;
    }

    private String ztyhokensyuruikigouyobi1x8;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X8)
    public String getZtyhokensyuruikigouyobi1x8() {
        return ztyhokensyuruikigouyobi1x8;
    }

    public void setZtyhokensyuruikigouyobi1x8(String pZtyhokensyuruikigouyobi1x8) {
        ztyhokensyuruikigouyobi1x8 = pZtyhokensyuruikigouyobi1x8;
    }

    private String ztyhokensyuruikigouyobi1x9;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X9)
    public String getZtyhokensyuruikigouyobi1x9() {
        return ztyhokensyuruikigouyobi1x9;
    }

    public void setZtyhokensyuruikigouyobi1x9(String pZtyhokensyuruikigouyobi1x9) {
        ztyhokensyuruikigouyobi1x9 = pZtyhokensyuruikigouyobi1x9;
    }

    private String ztyhokensyuruikigouyobi1x10;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X10)
    public String getZtyhokensyuruikigouyobi1x10() {
        return ztyhokensyuruikigouyobi1x10;
    }

    public void setZtyhokensyuruikigouyobi1x10(String pZtyhokensyuruikigouyobi1x10) {
        ztyhokensyuruikigouyobi1x10 = pZtyhokensyuruikigouyobi1x10;
    }

    private String ztyhokensyuruikigouyobi1x11;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X11)
    public String getZtyhokensyuruikigouyobi1x11() {
        return ztyhokensyuruikigouyobi1x11;
    }

    public void setZtyhokensyuruikigouyobi1x11(String pZtyhokensyuruikigouyobi1x11) {
        ztyhokensyuruikigouyobi1x11 = pZtyhokensyuruikigouyobi1x11;
    }

    private String ztyhokensyuruikigouyobi1x12;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X12)
    public String getZtyhokensyuruikigouyobi1x12() {
        return ztyhokensyuruikigouyobi1x12;
    }

    public void setZtyhokensyuruikigouyobi1x12(String pZtyhokensyuruikigouyobi1x12) {
        ztyhokensyuruikigouyobi1x12 = pZtyhokensyuruikigouyobi1x12;
    }

    private String ztyhokensyuruikigouyobi1x13;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X13)
    public String getZtyhokensyuruikigouyobi1x13() {
        return ztyhokensyuruikigouyobi1x13;
    }

    public void setZtyhokensyuruikigouyobi1x13(String pZtyhokensyuruikigouyobi1x13) {
        ztyhokensyuruikigouyobi1x13 = pZtyhokensyuruikigouyobi1x13;
    }

    private String ztyhokensyuruikigouyobi1x14;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X14)
    public String getZtyhokensyuruikigouyobi1x14() {
        return ztyhokensyuruikigouyobi1x14;
    }

    public void setZtyhokensyuruikigouyobi1x14(String pZtyhokensyuruikigouyobi1x14) {
        ztyhokensyuruikigouyobi1x14 = pZtyhokensyuruikigouyobi1x14;
    }

    private String ztyhokensyuruikigouyobi1x15;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI1X15)
    public String getZtyhokensyuruikigouyobi1x15() {
        return ztyhokensyuruikigouyobi1x15;
    }

    public void setZtyhokensyuruikigouyobi1x15(String pZtyhokensyuruikigouyobi1x15) {
        ztyhokensyuruikigouyobi1x15 = pZtyhokensyuruikigouyobi1x15;
    }

    private String ztyhokensyuruikigouyobi2x1;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI2X1)
    public String getZtyhokensyuruikigouyobi2x1() {
        return ztyhokensyuruikigouyobi2x1;
    }

    public void setZtyhokensyuruikigouyobi2x1(String pZtyhokensyuruikigouyobi2x1) {
        ztyhokensyuruikigouyobi2x1 = pZtyhokensyuruikigouyobi2x1;
    }

    private String ztyhokensyuruikigouyobi2x2;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI2X2)
    public String getZtyhokensyuruikigouyobi2x2() {
        return ztyhokensyuruikigouyobi2x2;
    }

    public void setZtyhokensyuruikigouyobi2x2(String pZtyhokensyuruikigouyobi2x2) {
        ztyhokensyuruikigouyobi2x2 = pZtyhokensyuruikigouyobi2x2;
    }

    private String ztyhokensyuruikigouyobi2x3;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI2X3)
    public String getZtyhokensyuruikigouyobi2x3() {
        return ztyhokensyuruikigouyobi2x3;
    }

    public void setZtyhokensyuruikigouyobi2x3(String pZtyhokensyuruikigouyobi2x3) {
        ztyhokensyuruikigouyobi2x3 = pZtyhokensyuruikigouyobi2x3;
    }

    private String ztyhokensyuruikigouyobi2x4;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI2X4)
    public String getZtyhokensyuruikigouyobi2x4() {
        return ztyhokensyuruikigouyobi2x4;
    }

    public void setZtyhokensyuruikigouyobi2x4(String pZtyhokensyuruikigouyobi2x4) {
        ztyhokensyuruikigouyobi2x4 = pZtyhokensyuruikigouyobi2x4;
    }

    private String ztyhokensyuruikigouyobi2x5;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI2X5)
    public String getZtyhokensyuruikigouyobi2x5() {
        return ztyhokensyuruikigouyobi2x5;
    }

    public void setZtyhokensyuruikigouyobi2x5(String pZtyhokensyuruikigouyobi2x5) {
        ztyhokensyuruikigouyobi2x5 = pZtyhokensyuruikigouyobi2x5;
    }

    private String ztyhokensyuruikigouyobi2x6;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI2X6)
    public String getZtyhokensyuruikigouyobi2x6() {
        return ztyhokensyuruikigouyobi2x6;
    }

    public void setZtyhokensyuruikigouyobi2x6(String pZtyhokensyuruikigouyobi2x6) {
        ztyhokensyuruikigouyobi2x6 = pZtyhokensyuruikigouyobi2x6;
    }

    private String ztyhokensyuruikigouyobi2x7;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI2X7)
    public String getZtyhokensyuruikigouyobi2x7() {
        return ztyhokensyuruikigouyobi2x7;
    }

    public void setZtyhokensyuruikigouyobi2x7(String pZtyhokensyuruikigouyobi2x7) {
        ztyhokensyuruikigouyobi2x7 = pZtyhokensyuruikigouyobi2x7;
    }

    private String ztyhokensyuruikigouyobi2x8;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI2X8)
    public String getZtyhokensyuruikigouyobi2x8() {
        return ztyhokensyuruikigouyobi2x8;
    }

    public void setZtyhokensyuruikigouyobi2x8(String pZtyhokensyuruikigouyobi2x8) {
        ztyhokensyuruikigouyobi2x8 = pZtyhokensyuruikigouyobi2x8;
    }

    private String ztyhokensyuruikigouyobi2x9;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI2X9)
    public String getZtyhokensyuruikigouyobi2x9() {
        return ztyhokensyuruikigouyobi2x9;
    }

    public void setZtyhokensyuruikigouyobi2x9(String pZtyhokensyuruikigouyobi2x9) {
        ztyhokensyuruikigouyobi2x9 = pZtyhokensyuruikigouyobi2x9;
    }

    private String ztyhokensyuruikigouyobi2x10;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI2X10)
    public String getZtyhokensyuruikigouyobi2x10() {
        return ztyhokensyuruikigouyobi2x10;
    }

    public void setZtyhokensyuruikigouyobi2x10(String pZtyhokensyuruikigouyobi2x10) {
        ztyhokensyuruikigouyobi2x10 = pZtyhokensyuruikigouyobi2x10;
    }

    private String ztyhokensyuruikigouyobi3x1;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI3X1)
    public String getZtyhokensyuruikigouyobi3x1() {
        return ztyhokensyuruikigouyobi3x1;
    }

    public void setZtyhokensyuruikigouyobi3x1(String pZtyhokensyuruikigouyobi3x1) {
        ztyhokensyuruikigouyobi3x1 = pZtyhokensyuruikigouyobi3x1;
    }

    private String ztyhokensyuruikigouyobi3x2;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI3X2)
    public String getZtyhokensyuruikigouyobi3x2() {
        return ztyhokensyuruikigouyobi3x2;
    }

    public void setZtyhokensyuruikigouyobi3x2(String pZtyhokensyuruikigouyobi3x2) {
        ztyhokensyuruikigouyobi3x2 = pZtyhokensyuruikigouyobi3x2;
    }

    private String ztyhokensyuruikigouyobi3x3;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI3X3)
    public String getZtyhokensyuruikigouyobi3x3() {
        return ztyhokensyuruikigouyobi3x3;
    }

    public void setZtyhokensyuruikigouyobi3x3(String pZtyhokensyuruikigouyobi3x3) {
        ztyhokensyuruikigouyobi3x3 = pZtyhokensyuruikigouyobi3x3;
    }

    private String ztyhokensyuruikigouyobi3x4;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI3X4)
    public String getZtyhokensyuruikigouyobi3x4() {
        return ztyhokensyuruikigouyobi3x4;
    }

    public void setZtyhokensyuruikigouyobi3x4(String pZtyhokensyuruikigouyobi3x4) {
        ztyhokensyuruikigouyobi3x4 = pZtyhokensyuruikigouyobi3x4;
    }

    private String ztyhokensyuruikigouyobi3x5;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI3X5)
    public String getZtyhokensyuruikigouyobi3x5() {
        return ztyhokensyuruikigouyobi3x5;
    }

    public void setZtyhokensyuruikigouyobi3x5(String pZtyhokensyuruikigouyobi3x5) {
        ztyhokensyuruikigouyobi3x5 = pZtyhokensyuruikigouyobi3x5;
    }

    private String ztyhokensyuruikigouyobi3x6;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI3X6)
    public String getZtyhokensyuruikigouyobi3x6() {
        return ztyhokensyuruikigouyobi3x6;
    }

    public void setZtyhokensyuruikigouyobi3x6(String pZtyhokensyuruikigouyobi3x6) {
        ztyhokensyuruikigouyobi3x6 = pZtyhokensyuruikigouyobi3x6;
    }

    private String ztyhokensyuruikigouyobi3x7;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI3X7)
    public String getZtyhokensyuruikigouyobi3x7() {
        return ztyhokensyuruikigouyobi3x7;
    }

    public void setZtyhokensyuruikigouyobi3x7(String pZtyhokensyuruikigouyobi3x7) {
        ztyhokensyuruikigouyobi3x7 = pZtyhokensyuruikigouyobi3x7;
    }

    private String ztyhokensyuruikigouyobi3x8;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI3X8)
    public String getZtyhokensyuruikigouyobi3x8() {
        return ztyhokensyuruikigouyobi3x8;
    }

    public void setZtyhokensyuruikigouyobi3x8(String pZtyhokensyuruikigouyobi3x8) {
        ztyhokensyuruikigouyobi3x8 = pZtyhokensyuruikigouyobi3x8;
    }

    private String ztyhokensyuruikigouyobi3x9;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI3X9)
    public String getZtyhokensyuruikigouyobi3x9() {
        return ztyhokensyuruikigouyobi3x9;
    }

    public void setZtyhokensyuruikigouyobi3x9(String pZtyhokensyuruikigouyobi3x9) {
        ztyhokensyuruikigouyobi3x9 = pZtyhokensyuruikigouyobi3x9;
    }

    private String ztyhokensyuruikigouyobi3x10;

    @Column(name=GenZT_SbRituRendouTy.ZTYHOKENSYURUIKIGOUYOBI3X10)
    public String getZtyhokensyuruikigouyobi3x10() {
        return ztyhokensyuruikigouyobi3x10;
    }

    public void setZtyhokensyuruikigouyobi3x10(String pZtyhokensyuruikigouyobi3x10) {
        ztyhokensyuruikigouyobi3x10 = pZtyhokensyuruikigouyobi3x10;
    }

    private String ztytokuyakukigouyobix1;

    @Column(name=GenZT_SbRituRendouTy.ZTYTOKUYAKUKIGOUYOBIX1)
    public String getZtytokuyakukigouyobix1() {
        return ztytokuyakukigouyobix1;
    }

    public void setZtytokuyakukigouyobix1(String pZtytokuyakukigouyobix1) {
        ztytokuyakukigouyobix1 = pZtytokuyakukigouyobix1;
    }

    private String ztytokuyakukigouyobix2;

    @Column(name=GenZT_SbRituRendouTy.ZTYTOKUYAKUKIGOUYOBIX2)
    public String getZtytokuyakukigouyobix2() {
        return ztytokuyakukigouyobix2;
    }

    public void setZtytokuyakukigouyobix2(String pZtytokuyakukigouyobix2) {
        ztytokuyakukigouyobix2 = pZtytokuyakukigouyobix2;
    }

    private String ztytokuyakukigouyobix3;

    @Column(name=GenZT_SbRituRendouTy.ZTYTOKUYAKUKIGOUYOBIX3)
    public String getZtytokuyakukigouyobix3() {
        return ztytokuyakukigouyobix3;
    }

    public void setZtytokuyakukigouyobix3(String pZtytokuyakukigouyobix3) {
        ztytokuyakukigouyobix3 = pZtytokuyakukigouyobix3;
    }

    private String ztytokuyakukigouyobix4;

    @Column(name=GenZT_SbRituRendouTy.ZTYTOKUYAKUKIGOUYOBIX4)
    public String getZtytokuyakukigouyobix4() {
        return ztytokuyakukigouyobix4;
    }

    public void setZtytokuyakukigouyobix4(String pZtytokuyakukigouyobix4) {
        ztytokuyakukigouyobix4 = pZtytokuyakukigouyobix4;
    }

    private String ztytokuyakukigouyobix5;

    @Column(name=GenZT_SbRituRendouTy.ZTYTOKUYAKUKIGOUYOBIX5)
    public String getZtytokuyakukigouyobix5() {
        return ztytokuyakukigouyobix5;
    }

    public void setZtytokuyakukigouyobix5(String pZtytokuyakukigouyobix5) {
        ztytokuyakukigouyobix5 = pZtytokuyakukigouyobix5;
    }

    private String ztymaruteikigouyobix1;

    @Column(name=GenZT_SbRituRendouTy.ZTYMARUTEIKIGOUYOBIX1)
    public String getZtymaruteikigouyobix1() {
        return ztymaruteikigouyobix1;
    }

    public void setZtymaruteikigouyobix1(String pZtymaruteikigouyobix1) {
        ztymaruteikigouyobix1 = pZtymaruteikigouyobix1;
    }

    private String ztymaruteikigouyobix2;

    @Column(name=GenZT_SbRituRendouTy.ZTYMARUTEIKIGOUYOBIX2)
    public String getZtymaruteikigouyobix2() {
        return ztymaruteikigouyobix2;
    }

    public void setZtymaruteikigouyobix2(String pZtymaruteikigouyobix2) {
        ztymaruteikigouyobix2 = pZtymaruteikigouyobix2;
    }

    private String ztymaruteikigouyobix3;

    @Column(name=GenZT_SbRituRendouTy.ZTYMARUTEIKIGOUYOBIX3)
    public String getZtymaruteikigouyobix3() {
        return ztymaruteikigouyobix3;
    }

    public void setZtymaruteikigouyobix3(String pZtymaruteikigouyobix3) {
        ztymaruteikigouyobix3 = pZtymaruteikigouyobix3;
    }

    private String ztymaruteikigouyobix4;

    @Column(name=GenZT_SbRituRendouTy.ZTYMARUTEIKIGOUYOBIX4)
    public String getZtymaruteikigouyobix4() {
        return ztymaruteikigouyobix4;
    }

    public void setZtymaruteikigouyobix4(String pZtymaruteikigouyobix4) {
        ztymaruteikigouyobix4 = pZtymaruteikigouyobix4;
    }

    private String ztymaruteikigouyobix5;

    @Column(name=GenZT_SbRituRendouTy.ZTYMARUTEIKIGOUYOBIX5)
    public String getZtymaruteikigouyobix5() {
        return ztymaruteikigouyobix5;
    }

    public void setZtymaruteikigouyobix5(String pZtymaruteikigouyobix5) {
        ztymaruteikigouyobix5 = pZtymaruteikigouyobix5;
    }

    private String ztysiznmrtikguybx1;

    @Column(name=GenZT_SbRituRendouTy.ZTYSIZNMRTIKGUYBX1)
    public String getZtysiznmrtikguybx1() {
        return ztysiznmrtikguybx1;
    }

    public void setZtysiznmrtikguybx1(String pZtysiznmrtikguybx1) {
        ztysiznmrtikguybx1 = pZtysiznmrtikguybx1;
    }

    private String ztysiznmrtikguybx2;

    @Column(name=GenZT_SbRituRendouTy.ZTYSIZNMRTIKGUYBX2)
    public String getZtysiznmrtikguybx2() {
        return ztysiznmrtikguybx2;
    }

    public void setZtysiznmrtikguybx2(String pZtysiznmrtikguybx2) {
        ztysiznmrtikguybx2 = pZtysiznmrtikguybx2;
    }

    private String ztysiznmrtikguybx3;

    @Column(name=GenZT_SbRituRendouTy.ZTYSIZNMRTIKGUYBX3)
    public String getZtysiznmrtikguybx3() {
        return ztysiznmrtikguybx3;
    }

    public void setZtysiznmrtikguybx3(String pZtysiznmrtikguybx3) {
        ztysiznmrtikguybx3 = pZtysiznmrtikguybx3;
    }

    private String ztysiznmrtikguybx4;

    @Column(name=GenZT_SbRituRendouTy.ZTYSIZNMRTIKGUYBX4)
    public String getZtysiznmrtikguybx4() {
        return ztysiznmrtikguybx4;
    }

    public void setZtysiznmrtikguybx4(String pZtysiznmrtikguybx4) {
        ztysiznmrtikguybx4 = pZtysiznmrtikguybx4;
    }

    private String ztysiznmrtikguybx5;

    @Column(name=GenZT_SbRituRendouTy.ZTYSIZNMRTIKGUYBX5)
    public String getZtysiznmrtikguybx5() {
        return ztysiznmrtikguybx5;
    }

    public void setZtysiznmrtikguybx5(String pZtysiznmrtikguybx5) {
        ztysiznmrtikguybx5 = pZtysiznmrtikguybx5;
    }

    private String ztyteigenmaruteikigouyobix1;

    @Column(name=GenZT_SbRituRendouTy.ZTYTEIGENMARUTEIKIGOUYOBIX1)
    public String getZtyteigenmaruteikigouyobix1() {
        return ztyteigenmaruteikigouyobix1;
    }

    public void setZtyteigenmaruteikigouyobix1(String pZtyteigenmaruteikigouyobix1) {
        ztyteigenmaruteikigouyobix1 = pZtyteigenmaruteikigouyobix1;
    }

    private String ztyteigenmaruteikigouyobix2;

    @Column(name=GenZT_SbRituRendouTy.ZTYTEIGENMARUTEIKIGOUYOBIX2)
    public String getZtyteigenmaruteikigouyobix2() {
        return ztyteigenmaruteikigouyobix2;
    }

    public void setZtyteigenmaruteikigouyobix2(String pZtyteigenmaruteikigouyobix2) {
        ztyteigenmaruteikigouyobix2 = pZtyteigenmaruteikigouyobix2;
    }

    private String ztyteigenmaruteikigouyobix3;

    @Column(name=GenZT_SbRituRendouTy.ZTYTEIGENMARUTEIKIGOUYOBIX3)
    public String getZtyteigenmaruteikigouyobix3() {
        return ztyteigenmaruteikigouyobix3;
    }

    public void setZtyteigenmaruteikigouyobix3(String pZtyteigenmaruteikigouyobix3) {
        ztyteigenmaruteikigouyobix3 = pZtyteigenmaruteikigouyobix3;
    }

    private String ztyteigenmaruteikigouyobix4;

    @Column(name=GenZT_SbRituRendouTy.ZTYTEIGENMARUTEIKIGOUYOBIX4)
    public String getZtyteigenmaruteikigouyobix4() {
        return ztyteigenmaruteikigouyobix4;
    }

    public void setZtyteigenmaruteikigouyobix4(String pZtyteigenmaruteikigouyobix4) {
        ztyteigenmaruteikigouyobix4 = pZtyteigenmaruteikigouyobix4;
    }

    private String ztyteigenmaruteikigouyobix5;

    @Column(name=GenZT_SbRituRendouTy.ZTYTEIGENMARUTEIKIGOUYOBIX5)
    public String getZtyteigenmaruteikigouyobix5() {
        return ztyteigenmaruteikigouyobix5;
    }

    public void setZtyteigenmaruteikigouyobix5(String pZtyteigenmaruteikigouyobix5) {
        ztyteigenmaruteikigouyobix5 = pZtyteigenmaruteikigouyobix5;
    }

    private String ztysyuunyuumrtikguybx1;

    @Column(name=GenZT_SbRituRendouTy.ZTYSYUUNYUUMRTIKGUYBX1)
    public String getZtysyuunyuumrtikguybx1() {
        return ztysyuunyuumrtikguybx1;
    }

    public void setZtysyuunyuumrtikguybx1(String pZtysyuunyuumrtikguybx1) {
        ztysyuunyuumrtikguybx1 = pZtysyuunyuumrtikguybx1;
    }

    private String ztysyuunyuumrtikguybx2;

    @Column(name=GenZT_SbRituRendouTy.ZTYSYUUNYUUMRTIKGUYBX2)
    public String getZtysyuunyuumrtikguybx2() {
        return ztysyuunyuumrtikguybx2;
    }

    public void setZtysyuunyuumrtikguybx2(String pZtysyuunyuumrtikguybx2) {
        ztysyuunyuumrtikguybx2 = pZtysyuunyuumrtikguybx2;
    }

    private String ztysyuunyuumrtikguybx3;

    @Column(name=GenZT_SbRituRendouTy.ZTYSYUUNYUUMRTIKGUYBX3)
    public String getZtysyuunyuumrtikguybx3() {
        return ztysyuunyuumrtikguybx3;
    }

    public void setZtysyuunyuumrtikguybx3(String pZtysyuunyuumrtikguybx3) {
        ztysyuunyuumrtikguybx3 = pZtysyuunyuumrtikguybx3;
    }

    private String ztysyuunyuumrtikguybx4;

    @Column(name=GenZT_SbRituRendouTy.ZTYSYUUNYUUMRTIKGUYBX4)
    public String getZtysyuunyuumrtikguybx4() {
        return ztysyuunyuumrtikguybx4;
    }

    public void setZtysyuunyuumrtikguybx4(String pZtysyuunyuumrtikguybx4) {
        ztysyuunyuumrtikguybx4 = pZtysyuunyuumrtikguybx4;
    }

    private String ztysyuunyuumrtikguybx5;

    @Column(name=GenZT_SbRituRendouTy.ZTYSYUUNYUUMRTIKGUYBX5)
    public String getZtysyuunyuumrtikguybx5() {
        return ztysyuunyuumrtikguybx5;
    }

    public void setZtysyuunyuumrtikguybx5(String pZtysyuunyuumrtikguybx5) {
        ztysyuunyuumrtikguybx5 = pZtysyuunyuumrtikguybx5;
    }

    private String ztysuuriyouyobin5;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN5)
    public String getZtysuuriyouyobin5() {
        return ztysuuriyouyobin5;
    }

    public void setZtysuuriyouyobin5(String pZtysuuriyouyobin5) {
        ztysuuriyouyobin5 = pZtysuuriyouyobin5;
    }

    private String ztysuuriyouyobin5x2;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN5X2)
    public String getZtysuuriyouyobin5x2() {
        return ztysuuriyouyobin5x2;
    }

    public void setZtysuuriyouyobin5x2(String pZtysuuriyouyobin5x2) {
        ztysuuriyouyobin5x2 = pZtysuuriyouyobin5x2;
    }

    private String ztysuuriyouyobin5x3;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN5X3)
    public String getZtysuuriyouyobin5x3() {
        return ztysuuriyouyobin5x3;
    }

    public void setZtysuuriyouyobin5x3(String pZtysuuriyouyobin5x3) {
        ztysuuriyouyobin5x3 = pZtysuuriyouyobin5x3;
    }

    private String ztysuuriyouyobin5x4;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN5X4)
    public String getZtysuuriyouyobin5x4() {
        return ztysuuriyouyobin5x4;
    }

    public void setZtysuuriyouyobin5x4(String pZtysuuriyouyobin5x4) {
        ztysuuriyouyobin5x4 = pZtysuuriyouyobin5x4;
    }

    private String ztysuuriyouyobin5x5;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN5X5)
    public String getZtysuuriyouyobin5x5() {
        return ztysuuriyouyobin5x5;
    }

    public void setZtysuuriyouyobin5x5(String pZtysuuriyouyobin5x5) {
        ztysuuriyouyobin5x5 = pZtysuuriyouyobin5x5;
    }

    private String ztyyobiv2x9;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIV2X9)
    public String getZtyyobiv2x9() {
        return ztyyobiv2x9;
    }

    public void setZtyyobiv2x9(String pZtyyobiv2x9) {
        ztyyobiv2x9 = pZtyyobiv2x9;
    }

    private Integer ztyyobin3x5;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIN3X5)
    public Integer getZtyyobin3x5() {
        return ztyyobin3x5;
    }

    public void setZtyyobin3x5(Integer pZtyyobin3x5) {
        ztyyobin3x5 = pZtyyobin3x5;
    }

    private String ztysuuriyouyobin1x7;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN1X7)
    public String getZtysuuriyouyobin1x7() {
        return ztysuuriyouyobin1x7;
    }

    public void setZtysuuriyouyobin1x7(String pZtysuuriyouyobin1x7) {
        ztysuuriyouyobin1x7 = pZtysuuriyouyobin1x7;
    }

    private String ztyyobiv1x11;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIV1X11)
    public String getZtyyobiv1x11() {
        return ztyyobiv1x11;
    }

    public void setZtyyobiv1x11(String pZtyyobiv1x11) {
        ztyyobiv1x11 = pZtyyobiv1x11;
    }

    private String ztysuuriyouyobin5x6;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN5X6)
    public String getZtysuuriyouyobin5x6() {
        return ztysuuriyouyobin5x6;
    }

    public void setZtysuuriyouyobin5x6(String pZtysuuriyouyobin5x6) {
        ztysuuriyouyobin5x6 = pZtysuuriyouyobin5x6;
    }

    private String ztydakuhikettikjynsyrikbnx1;

    @Column(name=GenZT_SbRituRendouTy.ZTYDAKUHIKETTIKJYNSYRIKBNX1)
    public String getZtydakuhikettikjynsyrikbnx1() {
        return ztydakuhikettikjynsyrikbnx1;
    }

    public void setZtydakuhikettikjynsyrikbnx1(String pZtydakuhikettikjynsyrikbnx1) {
        ztydakuhikettikjynsyrikbnx1 = pZtydakuhikettikjynsyrikbnx1;
    }

    private String ztydakuhikettikjynsyrikbnx2;

    @Column(name=GenZT_SbRituRendouTy.ZTYDAKUHIKETTIKJYNSYRIKBNX2)
    public String getZtydakuhikettikjynsyrikbnx2() {
        return ztydakuhikettikjynsyrikbnx2;
    }

    public void setZtydakuhikettikjynsyrikbnx2(String pZtydakuhikettikjynsyrikbnx2) {
        ztydakuhikettikjynsyrikbnx2 = pZtydakuhikettikjynsyrikbnx2;
    }

    private String ztydakuhikettikjynsyrikbnx3;

    @Column(name=GenZT_SbRituRendouTy.ZTYDAKUHIKETTIKJYNSYRIKBNX3)
    public String getZtydakuhikettikjynsyrikbnx3() {
        return ztydakuhikettikjynsyrikbnx3;
    }

    public void setZtydakuhikettikjynsyrikbnx3(String pZtydakuhikettikjynsyrikbnx3) {
        ztydakuhikettikjynsyrikbnx3 = pZtydakuhikettikjynsyrikbnx3;
    }

    private String ztydakuhikettikjynsyrikbnx4;

    @Column(name=GenZT_SbRituRendouTy.ZTYDAKUHIKETTIKJYNSYRIKBNX4)
    public String getZtydakuhikettikjynsyrikbnx4() {
        return ztydakuhikettikjynsyrikbnx4;
    }

    public void setZtydakuhikettikjynsyrikbnx4(String pZtydakuhikettikjynsyrikbnx4) {
        ztydakuhikettikjynsyrikbnx4 = pZtydakuhikettikjynsyrikbnx4;
    }

    private String ztydakuhikettikjynsyrikbnx5;

    @Column(name=GenZT_SbRituRendouTy.ZTYDAKUHIKETTIKJYNSYRIKBNX5)
    public String getZtydakuhikettikjynsyrikbnx5() {
        return ztydakuhikettikjynsyrikbnx5;
    }

    public void setZtydakuhikettikjynsyrikbnx5(String pZtydakuhikettikjynsyrikbnx5) {
        ztydakuhikettikjynsyrikbnx5 = pZtydakuhikettikjynsyrikbnx5;
    }

    private String ztyhtnknkykdatakanrinox1;

    @Column(name=GenZT_SbRituRendouTy.ZTYHTNKNKYKDATAKANRINOX1)
    public String getZtyhtnknkykdatakanrinox1() {
        return ztyhtnknkykdatakanrinox1;
    }

    public void setZtyhtnknkykdatakanrinox1(String pZtyhtnknkykdatakanrinox1) {
        ztyhtnknkykdatakanrinox1 = pZtyhtnknkykdatakanrinox1;
    }

    private String ztyhtnknkykdatakanrinox2;

    @Column(name=GenZT_SbRituRendouTy.ZTYHTNKNKYKDATAKANRINOX2)
    public String getZtyhtnknkykdatakanrinox2() {
        return ztyhtnknkykdatakanrinox2;
    }

    public void setZtyhtnknkykdatakanrinox2(String pZtyhtnknkykdatakanrinox2) {
        ztyhtnknkykdatakanrinox2 = pZtyhtnknkykdatakanrinox2;
    }

    private String ztyhtnknkykdatakanrinox3;

    @Column(name=GenZT_SbRituRendouTy.ZTYHTNKNKYKDATAKANRINOX3)
    public String getZtyhtnknkykdatakanrinox3() {
        return ztyhtnknkykdatakanrinox3;
    }

    public void setZtyhtnknkykdatakanrinox3(String pZtyhtnknkykdatakanrinox3) {
        ztyhtnknkykdatakanrinox3 = pZtyhtnknkykdatakanrinox3;
    }

    private String ztyhtnknkykdatakanrinox4;

    @Column(name=GenZT_SbRituRendouTy.ZTYHTNKNKYKDATAKANRINOX4)
    public String getZtyhtnknkykdatakanrinox4() {
        return ztyhtnknkykdatakanrinox4;
    }

    public void setZtyhtnknkykdatakanrinox4(String pZtyhtnknkykdatakanrinox4) {
        ztyhtnknkykdatakanrinox4 = pZtyhtnknkykdatakanrinox4;
    }

    private String ztyhtnknkykdatakanrinox5;

    @Column(name=GenZT_SbRituRendouTy.ZTYHTNKNKYKDATAKANRINOX5)
    public String getZtyhtnknkykdatakanrinox5() {
        return ztyhtnknkykdatakanrinox5;
    }

    public void setZtyhtnknkykdatakanrinox5(String pZtyhtnknkykdatakanrinox5) {
        ztyhtnknkykdatakanrinox5 = pZtyhtnknkykdatakanrinox5;
    }

    private String ztyhtnknkykdatakanrinox6;

    @Column(name=GenZT_SbRituRendouTy.ZTYHTNKNKYKDATAKANRINOX6)
    public String getZtyhtnknkykdatakanrinox6() {
        return ztyhtnknkykdatakanrinox6;
    }

    public void setZtyhtnknkykdatakanrinox6(String pZtyhtnknkykdatakanrinox6) {
        ztyhtnknkykdatakanrinox6 = pZtyhtnknkykdatakanrinox6;
    }

    private String ztykeiyakusyahoujinkbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYKEIYAKUSYAHOUJINKBN)
    public String getZtykeiyakusyahoujinkbn() {
        return ztykeiyakusyahoujinkbn;
    }

    public void setZtykeiyakusyahoujinkbn(String pZtykeiyakusyahoujinkbn) {
        ztykeiyakusyahoujinkbn = pZtykeiyakusyahoujinkbn;
    }

    private String ztysuuriyouyobin2x3;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN2X3)
    public String getZtysuuriyouyobin2x3() {
        return ztysuuriyouyobin2x3;
    }

    public void setZtysuuriyouyobin2x3(String pZtysuuriyouyobin2x3) {
        ztysuuriyouyobin2x3 = pZtysuuriyouyobin2x3;
    }

    private String ztyhyujynkttidkhkttikekkacd;

    @Column(name=GenZT_SbRituRendouTy.ZTYHYUJYNKTTIDKHKTTIKEKKACD)
    public String getZtyhyujynkttidkhkttikekkacd() {
        return ztyhyujynkttidkhkttikekkacd;
    }

    public void setZtyhyujynkttidkhkttikekkacd(String pZtyhyujynkttidkhkttikekkacd) {
        ztyhyujynkttidkhkttikekkacd = pZtyhyujynkttidkhkttikekkacd;
    }

    private String ztyhyujynkttidkhkttiryucdx1;

    @Column(name=GenZT_SbRituRendouTy.ZTYHYUJYNKTTIDKHKTTIRYUCDX1)
    public String getZtyhyujynkttidkhkttiryucdx1() {
        return ztyhyujynkttidkhkttiryucdx1;
    }

    public void setZtyhyujynkttidkhkttiryucdx1(String pZtyhyujynkttidkhkttiryucdx1) {
        ztyhyujynkttidkhkttiryucdx1 = pZtyhyujynkttidkhkttiryucdx1;
    }

    private String ztyhyujynkttidkhkttiryucdx2;

    @Column(name=GenZT_SbRituRendouTy.ZTYHYUJYNKTTIDKHKTTIRYUCDX2)
    public String getZtyhyujynkttidkhkttiryucdx2() {
        return ztyhyujynkttidkhkttiryucdx2;
    }

    public void setZtyhyujynkttidkhkttiryucdx2(String pZtyhyujynkttidkhkttiryucdx2) {
        ztyhyujynkttidkhkttiryucdx2 = pZtyhyujynkttidkhkttiryucdx2;
    }

    private String ztyhyujynkttidkhkttiryucdx3;

    @Column(name=GenZT_SbRituRendouTy.ZTYHYUJYNKTTIDKHKTTIRYUCDX3)
    public String getZtyhyujynkttidkhkttiryucdx3() {
        return ztyhyujynkttidkhkttiryucdx3;
    }

    public void setZtyhyujynkttidkhkttiryucdx3(String pZtyhyujynkttidkhkttiryucdx3) {
        ztyhyujynkttidkhkttiryucdx3 = pZtyhyujynkttidkhkttiryucdx3;
    }

    private String ztyhyujynkttidkhkttiryucdx4;

    @Column(name=GenZT_SbRituRendouTy.ZTYHYUJYNKTTIDKHKTTIRYUCDX4)
    public String getZtyhyujynkttidkhkttiryucdx4() {
        return ztyhyujynkttidkhkttiryucdx4;
    }

    public void setZtyhyujynkttidkhkttiryucdx4(String pZtyhyujynkttidkhkttiryucdx4) {
        ztyhyujynkttidkhkttiryucdx4 = pZtyhyujynkttidkhkttiryucdx4;
    }

    private Integer ztyhyujynkttiryumshyutn;

    @Column(name=GenZT_SbRituRendouTy.ZTYHYUJYNKTTIRYUMSHYUTN)
    public Integer getZtyhyujynkttiryumshyutn() {
        return ztyhyujynkttiryumshyutn;
    }

    public void setZtyhyujynkttiryumshyutn(Integer pZtyhyujynkttiryumshyutn) {
        ztyhyujynkttiryumshyutn = pZtyhyujynkttiryumshyutn;
    }

    private String ztyhyujynkttisakugenkkn;

    @Column(name=GenZT_SbRituRendouTy.ZTYHYUJYNKTTISAKUGENKKN)
    public String getZtyhyujynkttisakugenkkn() {
        return ztyhyujynkttisakugenkkn;
    }

    public void setZtyhyujynkttisakugenkkn(String pZtyhyujynkttisakugenkkn) {
        ztyhyujynkttisakugenkkn = pZtyhyujynkttisakugenkkn;
    }

    private Integer ztysppitkykryumshyutn;

    @Column(name=GenZT_SbRituRendouTy.ZTYSPPITKYKRYUMSHYUTN)
    public Integer getZtysppitkykryumshyutn() {
        return ztysppitkykryumshyutn;
    }

    public void setZtysppitkykryumshyutn(Integer pZtysppitkykryumshyutn) {
        ztysppitkykryumshyutn = pZtysppitkykryumshyutn;
    }

    private String ztyhyujynkttitktbuicdx1;

    @Column(name=GenZT_SbRituRendouTy.ZTYHYUJYNKTTITKTBUICDX1)
    public String getZtyhyujynkttitktbuicdx1() {
        return ztyhyujynkttitktbuicdx1;
    }

    public void setZtyhyujynkttitktbuicdx1(String pZtyhyujynkttitktbuicdx1) {
        ztyhyujynkttitktbuicdx1 = pZtyhyujynkttitktbuicdx1;
    }

    private String ztyhyujynkttihutanpokknx1;

    @Column(name=GenZT_SbRituRendouTy.ZTYHYUJYNKTTIHUTANPOKKNX1)
    public String getZtyhyujynkttihutanpokknx1() {
        return ztyhyujynkttihutanpokknx1;
    }

    public void setZtyhyujynkttihutanpokknx1(String pZtyhyujynkttihutanpokknx1) {
        ztyhyujynkttihutanpokknx1 = pZtyhyujynkttihutanpokknx1;
    }

    private String ztyhyujynkttitktbuicdx2;

    @Column(name=GenZT_SbRituRendouTy.ZTYHYUJYNKTTITKTBUICDX2)
    public String getZtyhyujynkttitktbuicdx2() {
        return ztyhyujynkttitktbuicdx2;
    }

    public void setZtyhyujynkttitktbuicdx2(String pZtyhyujynkttitktbuicdx2) {
        ztyhyujynkttitktbuicdx2 = pZtyhyujynkttitktbuicdx2;
    }

    private String ztyhyujynkttihutanpokknx2;

    @Column(name=GenZT_SbRituRendouTy.ZTYHYUJYNKTTIHUTANPOKKNX2)
    public String getZtyhyujynkttihutanpokknx2() {
        return ztyhyujynkttihutanpokknx2;
    }

    public void setZtyhyujynkttihutanpokknx2(String pZtyhyujynkttihutanpokknx2) {
        ztyhyujynkttihutanpokknx2 = pZtyhyujynkttihutanpokknx2;
    }

    private String ztyjyoukentukitaisyoukbnx1;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYOUKENTUKITAISYOUKBNX1)
    public String getZtyjyoukentukitaisyoukbnx1() {
        return ztyjyoukentukitaisyoukbnx1;
    }

    public void setZtyjyoukentukitaisyoukbnx1(String pZtyjyoukentukitaisyoukbnx1) {
        ztyjyoukentukitaisyoukbnx1 = pZtyjyoukentukitaisyoukbnx1;
    }

    private String ztyjyukntksseigenhyjx1;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYUKNTKSSEIGENHYJX1)
    public String getZtyjyukntksseigenhyjx1() {
        return ztyjyukntksseigenhyjx1;
    }

    public void setZtyjyukntksseigenhyjx1(String pZtyjyukntksseigenhyjx1) {
        ztyjyukntksseigenhyjx1 = pZtyjyukntksseigenhyjx1;
    }

    private String ztyjyukntktkyknozokihyjx1;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYUKNTKTKYKNOZOKIHYJX1)
    public String getZtyjyukntktkyknozokihyjx1() {
        return ztyjyukntktkyknozokihyjx1;
    }

    public void setZtyjyukntktkyknozokihyjx1(String pZtyjyukntktkyknozokihyjx1) {
        ztyjyukntktkyknozokihyjx1 = pZtyjyukntktkyknozokihyjx1;
    }

    private String ztysuuriyouyobin1x8;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN1X8)
    public String getZtysuuriyouyobin1x8() {
        return ztysuuriyouyobin1x8;
    }

    public void setZtysuuriyouyobin1x8(String pZtysuuriyouyobin1x8) {
        ztysuuriyouyobin1x8 = pZtysuuriyouyobin1x8;
    }

    private Long ztyjyoukentukiseigensx1;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYOUKENTUKISEIGENSX1)
    public Long getZtyjyoukentukiseigensx1() {
        return ztyjyoukentukiseigensx1;
    }

    public void setZtyjyoukentukiseigensx1(Long pZtyjyoukentukiseigensx1) {
        ztyjyoukentukiseigensx1 = pZtyjyoukentukiseigensx1;
    }

    private String ztyjyoukentukitaisyoukbnx2;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYOUKENTUKITAISYOUKBNX2)
    public String getZtyjyoukentukitaisyoukbnx2() {
        return ztyjyoukentukitaisyoukbnx2;
    }

    public void setZtyjyoukentukitaisyoukbnx2(String pZtyjyoukentukitaisyoukbnx2) {
        ztyjyoukentukitaisyoukbnx2 = pZtyjyoukentukitaisyoukbnx2;
    }

    private String ztyjyukntksseigenhyjx2;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYUKNTKSSEIGENHYJX2)
    public String getZtyjyukntksseigenhyjx2() {
        return ztyjyukntksseigenhyjx2;
    }

    public void setZtyjyukntksseigenhyjx2(String pZtyjyukntksseigenhyjx2) {
        ztyjyukntksseigenhyjx2 = pZtyjyukntksseigenhyjx2;
    }

    private String ztyjyukntktkyknozokihyjx2;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYUKNTKTKYKNOZOKIHYJX2)
    public String getZtyjyukntktkyknozokihyjx2() {
        return ztyjyukntktkyknozokihyjx2;
    }

    public void setZtyjyukntktkyknozokihyjx2(String pZtyjyukntktkyknozokihyjx2) {
        ztyjyukntktkyknozokihyjx2 = pZtyjyukntktkyknozokihyjx2;
    }

    private String ztysuuriyouyobin1x9;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN1X9)
    public String getZtysuuriyouyobin1x9() {
        return ztysuuriyouyobin1x9;
    }

    public void setZtysuuriyouyobin1x9(String pZtysuuriyouyobin1x9) {
        ztysuuriyouyobin1x9 = pZtysuuriyouyobin1x9;
    }

    private Long ztyjyoukentukiseigensx2;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYOUKENTUKISEIGENSX2)
    public Long getZtyjyoukentukiseigensx2() {
        return ztyjyoukentukiseigensx2;
    }

    public void setZtyjyoukentukiseigensx2(Long pZtyjyoukentukiseigensx2) {
        ztyjyoukentukiseigensx2 = pZtyjyoukentukiseigensx2;
    }

    private String ztyjyoukentukitaisyoukbnx3;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYOUKENTUKITAISYOUKBNX3)
    public String getZtyjyoukentukitaisyoukbnx3() {
        return ztyjyoukentukitaisyoukbnx3;
    }

    public void setZtyjyoukentukitaisyoukbnx3(String pZtyjyoukentukitaisyoukbnx3) {
        ztyjyoukentukitaisyoukbnx3 = pZtyjyoukentukitaisyoukbnx3;
    }

    private String ztyjyukntksseigenhyjx3;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYUKNTKSSEIGENHYJX3)
    public String getZtyjyukntksseigenhyjx3() {
        return ztyjyukntksseigenhyjx3;
    }

    public void setZtyjyukntksseigenhyjx3(String pZtyjyukntksseigenhyjx3) {
        ztyjyukntksseigenhyjx3 = pZtyjyukntksseigenhyjx3;
    }

    private String ztyjyukntktkyknozokihyjx3;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYUKNTKTKYKNOZOKIHYJX3)
    public String getZtyjyukntktkyknozokihyjx3() {
        return ztyjyukntktkyknozokihyjx3;
    }

    public void setZtyjyukntktkyknozokihyjx3(String pZtyjyukntktkyknozokihyjx3) {
        ztyjyukntktkyknozokihyjx3 = pZtyjyukntktkyknozokihyjx3;
    }

    private String ztysuuriyouyobin1x10;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN1X10)
    public String getZtysuuriyouyobin1x10() {
        return ztysuuriyouyobin1x10;
    }

    public void setZtysuuriyouyobin1x10(String pZtysuuriyouyobin1x10) {
        ztysuuriyouyobin1x10 = pZtysuuriyouyobin1x10;
    }

    private Long ztyjyoukentukiseigensx3;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYOUKENTUKISEIGENSX3)
    public Long getZtyjyoukentukiseigensx3() {
        return ztyjyoukentukiseigensx3;
    }

    public void setZtyjyoukentukiseigensx3(Long pZtyjyoukentukiseigensx3) {
        ztyjyoukentukiseigensx3 = pZtyjyoukentukiseigensx3;
    }

    private String ztyjyoukentukitaisyoukbnx4;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYOUKENTUKITAISYOUKBNX4)
    public String getZtyjyoukentukitaisyoukbnx4() {
        return ztyjyoukentukitaisyoukbnx4;
    }

    public void setZtyjyoukentukitaisyoukbnx4(String pZtyjyoukentukitaisyoukbnx4) {
        ztyjyoukentukitaisyoukbnx4 = pZtyjyoukentukitaisyoukbnx4;
    }

    private String ztyjyukntksseigenhyjx4;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYUKNTKSSEIGENHYJX4)
    public String getZtyjyukntksseigenhyjx4() {
        return ztyjyukntksseigenhyjx4;
    }

    public void setZtyjyukntksseigenhyjx4(String pZtyjyukntksseigenhyjx4) {
        ztyjyukntksseigenhyjx4 = pZtyjyukntksseigenhyjx4;
    }

    private String ztyjyukntktkyknozokihyjx4;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYUKNTKTKYKNOZOKIHYJX4)
    public String getZtyjyukntktkyknozokihyjx4() {
        return ztyjyukntktkyknozokihyjx4;
    }

    public void setZtyjyukntktkyknozokihyjx4(String pZtyjyukntktkyknozokihyjx4) {
        ztyjyukntktkyknozokihyjx4 = pZtyjyukntktkyknozokihyjx4;
    }

    private String ztysuuriyouyobin1x11;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN1X11)
    public String getZtysuuriyouyobin1x11() {
        return ztysuuriyouyobin1x11;
    }

    public void setZtysuuriyouyobin1x11(String pZtysuuriyouyobin1x11) {
        ztysuuriyouyobin1x11 = pZtysuuriyouyobin1x11;
    }

    private Long ztyjyoukentukiseigensx4;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYOUKENTUKISEIGENSX4)
    public Long getZtyjyoukentukiseigensx4() {
        return ztyjyoukentukiseigensx4;
    }

    public void setZtyjyoukentukiseigensx4(Long pZtyjyoukentukiseigensx4) {
        ztyjyoukentukiseigensx4 = pZtyjyoukentukiseigensx4;
    }

    private String ztyjyukntkkigtiksyrihnkuhyj;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYUKNTKKIGTIKSYRIHNKUHYJ)
    public String getZtyjyukntkkigtiksyrihnkuhyj() {
        return ztyjyukntkkigtiksyrihnkuhyj;
    }

    public void setZtyjyukntkkigtiksyrihnkuhyj(String pZtyjyukntkkigtiksyrihnkuhyj) {
        ztyjyukntkkigtiksyrihnkuhyj = pZtyjyukntkkigtiksyrihnkuhyj;
    }

    private String ztypmensyuruihenkoukbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYPMENSYURUIHENKOUKBN)
    public String getZtypmensyuruihenkoukbn() {
        return ztypmensyuruihenkoukbn;
    }

    public void setZtypmensyuruihenkoukbn(String pZtypmensyuruihenkoukbn) {
        ztypmensyuruihenkoukbn = pZtypmensyuruihenkoukbn;
    }

    private String ztyjyoukentukitaisyoukbn2x1;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYOUKENTUKITAISYOUKBN2X1)
    public String getZtyjyoukentukitaisyoukbn2x1() {
        return ztyjyoukentukitaisyoukbn2x1;
    }

    public void setZtyjyoukentukitaisyoukbn2x1(String pZtyjyoukentukitaisyoukbn2x1) {
        ztyjyoukentukitaisyoukbn2x1 = pZtyjyoukentukitaisyoukbn2x1;
    }

    private String ztyjyukntksseigenhyj2x1;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYUKNTKSSEIGENHYJ2X1)
    public String getZtyjyukntksseigenhyj2x1() {
        return ztyjyukntksseigenhyj2x1;
    }

    public void setZtyjyukntksseigenhyj2x1(String pZtyjyukntksseigenhyj2x1) {
        ztyjyukntksseigenhyj2x1 = pZtyjyukntksseigenhyj2x1;
    }

    private String ztyjyukntktkyknozokihyj2x1;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYUKNTKTKYKNOZOKIHYJ2X1)
    public String getZtyjyukntktkyknozokihyj2x1() {
        return ztyjyukntktkyknozokihyj2x1;
    }

    public void setZtyjyukntktkyknozokihyj2x1(String pZtyjyukntktkyknozokihyj2x1) {
        ztyjyukntktkyknozokihyj2x1 = pZtyjyukntktkyknozokihyj2x1;
    }

    private String ztysuuriyouyobin1x12;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN1X12)
    public String getZtysuuriyouyobin1x12() {
        return ztysuuriyouyobin1x12;
    }

    public void setZtysuuriyouyobin1x12(String pZtysuuriyouyobin1x12) {
        ztysuuriyouyobin1x12 = pZtysuuriyouyobin1x12;
    }

    private Long ztyjyoukentukiseigens2x1;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYOUKENTUKISEIGENS2X1)
    public Long getZtyjyoukentukiseigens2x1() {
        return ztyjyoukentukiseigens2x1;
    }

    public void setZtyjyoukentukiseigens2x1(Long pZtyjyoukentukiseigens2x1) {
        ztyjyoukentukiseigens2x1 = pZtyjyoukentukiseigens2x1;
    }

    private String ztyjyoukentukitaisyoukbn2x2;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYOUKENTUKITAISYOUKBN2X2)
    public String getZtyjyoukentukitaisyoukbn2x2() {
        return ztyjyoukentukitaisyoukbn2x2;
    }

    public void setZtyjyoukentukitaisyoukbn2x2(String pZtyjyoukentukitaisyoukbn2x2) {
        ztyjyoukentukitaisyoukbn2x2 = pZtyjyoukentukitaisyoukbn2x2;
    }

    private String ztyjyukntksseigenhyj2x2;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYUKNTKSSEIGENHYJ2X2)
    public String getZtyjyukntksseigenhyj2x2() {
        return ztyjyukntksseigenhyj2x2;
    }

    public void setZtyjyukntksseigenhyj2x2(String pZtyjyukntksseigenhyj2x2) {
        ztyjyukntksseigenhyj2x2 = pZtyjyukntksseigenhyj2x2;
    }

    private String ztyjyukntktkyknozokihyj2x2;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYUKNTKTKYKNOZOKIHYJ2X2)
    public String getZtyjyukntktkyknozokihyj2x2() {
        return ztyjyukntktkyknozokihyj2x2;
    }

    public void setZtyjyukntktkyknozokihyj2x2(String pZtyjyukntktkyknozokihyj2x2) {
        ztyjyukntktkyknozokihyj2x2 = pZtyjyukntktkyknozokihyj2x2;
    }

    private String ztysuuriyouyobin1x13;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN1X13)
    public String getZtysuuriyouyobin1x13() {
        return ztysuuriyouyobin1x13;
    }

    public void setZtysuuriyouyobin1x13(String pZtysuuriyouyobin1x13) {
        ztysuuriyouyobin1x13 = pZtysuuriyouyobin1x13;
    }

    private Long ztyjyoukentukiseigens2x2;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYOUKENTUKISEIGENS2X2)
    public Long getZtyjyoukentukiseigens2x2() {
        return ztyjyoukentukiseigens2x2;
    }

    public void setZtyjyoukentukiseigens2x2(Long pZtyjyoukentukiseigens2x2) {
        ztyjyoukentukiseigens2x2 = pZtyjyoukentukiseigens2x2;
    }

    private String ztyjyoukentukitaisyoukbn2x3;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYOUKENTUKITAISYOUKBN2X3)
    public String getZtyjyoukentukitaisyoukbn2x3() {
        return ztyjyoukentukitaisyoukbn2x3;
    }

    public void setZtyjyoukentukitaisyoukbn2x3(String pZtyjyoukentukitaisyoukbn2x3) {
        ztyjyoukentukitaisyoukbn2x3 = pZtyjyoukentukitaisyoukbn2x3;
    }

    private String ztyjyukntksseigenhyj2x3;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYUKNTKSSEIGENHYJ2X3)
    public String getZtyjyukntksseigenhyj2x3() {
        return ztyjyukntksseigenhyj2x3;
    }

    public void setZtyjyukntksseigenhyj2x3(String pZtyjyukntksseigenhyj2x3) {
        ztyjyukntksseigenhyj2x3 = pZtyjyukntksseigenhyj2x3;
    }

    private String ztyjyukntktkyknozokihyj2x3;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYUKNTKTKYKNOZOKIHYJ2X3)
    public String getZtyjyukntktkyknozokihyj2x3() {
        return ztyjyukntktkyknozokihyj2x3;
    }

    public void setZtyjyukntktkyknozokihyj2x3(String pZtyjyukntktkyknozokihyj2x3) {
        ztyjyukntktkyknozokihyj2x3 = pZtyjyukntktkyknozokihyj2x3;
    }

    private String ztysuuriyouyobin1x14;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN1X14)
    public String getZtysuuriyouyobin1x14() {
        return ztysuuriyouyobin1x14;
    }

    public void setZtysuuriyouyobin1x14(String pZtysuuriyouyobin1x14) {
        ztysuuriyouyobin1x14 = pZtysuuriyouyobin1x14;
    }

    private Long ztyjyoukentukiseigens2x3;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYOUKENTUKISEIGENS2X3)
    public Long getZtyjyoukentukiseigens2x3() {
        return ztyjyoukentukiseigens2x3;
    }

    public void setZtyjyoukentukiseigens2x3(Long pZtyjyoukentukiseigens2x3) {
        ztyjyoukentukiseigens2x3 = pZtyjyoukentukiseigens2x3;
    }

    private String ztyjyoukentukitaisyoukbn2x4;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYOUKENTUKITAISYOUKBN2X4)
    public String getZtyjyoukentukitaisyoukbn2x4() {
        return ztyjyoukentukitaisyoukbn2x4;
    }

    public void setZtyjyoukentukitaisyoukbn2x4(String pZtyjyoukentukitaisyoukbn2x4) {
        ztyjyoukentukitaisyoukbn2x4 = pZtyjyoukentukitaisyoukbn2x4;
    }

    private String ztyjyukntksseigenhyj2x4;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYUKNTKSSEIGENHYJ2X4)
    public String getZtyjyukntksseigenhyj2x4() {
        return ztyjyukntksseigenhyj2x4;
    }

    public void setZtyjyukntksseigenhyj2x4(String pZtyjyukntksseigenhyj2x4) {
        ztyjyukntksseigenhyj2x4 = pZtyjyukntksseigenhyj2x4;
    }

    private String ztyjyukntktkyknozokihyj2x4;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYUKNTKTKYKNOZOKIHYJ2X4)
    public String getZtyjyukntktkyknozokihyj2x4() {
        return ztyjyukntktkyknozokihyj2x4;
    }

    public void setZtyjyukntktkyknozokihyj2x4(String pZtyjyukntktkyknozokihyj2x4) {
        ztyjyukntktkyknozokihyj2x4 = pZtyjyukntktkyknozokihyj2x4;
    }

    private String ztysuuriyouyobin1x15;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN1X15)
    public String getZtysuuriyouyobin1x15() {
        return ztysuuriyouyobin1x15;
    }

    public void setZtysuuriyouyobin1x15(String pZtysuuriyouyobin1x15) {
        ztysuuriyouyobin1x15 = pZtysuuriyouyobin1x15;
    }

    private Long ztyjyoukentukiseigens2x4;

    @Column(name=GenZT_SbRituRendouTy.ZTYJYOUKENTUKISEIGENS2X4)
    public Long getZtyjyoukentukiseigens2x4() {
        return ztyjyoukentukiseigens2x4;
    }

    public void setZtyjyoukentukiseigens2x4(Long pZtyjyoukentukiseigens2x4) {
        ztyjyoukentukiseigens2x4 = pZtyjyoukentukiseigens2x4;
    }

    private Integer ztytktsppiryumshyutn;

    @Column(name=GenZT_SbRituRendouTy.ZTYTKTSPPIRYUMSHYUTN)
    public Integer getZtytktsppiryumshyutn() {
        return ztytktsppiryumshyutn;
    }

    public void setZtytktsppiryumshyutn(Integer pZtytktsppiryumshyutn) {
        ztytktsppiryumshyutn = pZtytktsppiryumshyutn;
    }

    private String ztytktsppiskgnkkn;

    @Column(name=GenZT_SbRituRendouTy.ZTYTKTSPPISKGNKKN)
    public String getZtytktsppiskgnkkn() {
        return ztytktsppiskgnkkn;
    }

    public void setZtytktsppiskgnkkn(String pZtytktsppiskgnkkn) {
        ztytktsppiskgnkkn = pZtytktsppiskgnkkn;
    }

    private Integer ztymnsiskknryumshyutn;

    @Column(name=GenZT_SbRituRendouTy.ZTYMNSISKKNRYUMSHYUTN)
    public Integer getZtymnsiskknryumshyutn() {
        return ztymnsiskknryumshyutn;
    }

    public void setZtymnsiskknryumshyutn(Integer pZtymnsiskknryumshyutn) {
        ztymnsiskknryumshyutn = pZtymnsiskknryumshyutn;
    }

    private String ztymanseisikkansakugenkikan;

    @Column(name=GenZT_SbRituRendouTy.ZTYMANSEISIKKANSAKUGENKIKAN)
    public String getZtymanseisikkansakugenkikan() {
        return ztymanseisikkansakugenkikan;
    }

    public void setZtymanseisikkansakugenkikan(String pZtymanseisikkansakugenkikan) {
        ztymanseisikkansakugenkikan = pZtymanseisikkansakugenkikan;
    }

    private String ztymanseisikkantokuteibuicd;

    @Column(name=GenZT_SbRituRendouTy.ZTYMANSEISIKKANTOKUTEIBUICD)
    public String getZtymanseisikkantokuteibuicd() {
        return ztymanseisikkantokuteibuicd;
    }

    public void setZtymanseisikkantokuteibuicd(String pZtymanseisikkantokuteibuicd) {
        ztymanseisikkantokuteibuicd = pZtymanseisikkantokuteibuicd;
    }

    private String ztymanseisikkanhutanpokikan;

    @Column(name=GenZT_SbRituRendouTy.ZTYMANSEISIKKANHUTANPOKIKAN)
    public String getZtymanseisikkanhutanpokikan() {
        return ztymanseisikkanhutanpokikan;
    }

    public void setZtymanseisikkanhutanpokikan(String pZtymanseisikkanhutanpokikan) {
        ztymanseisikkanhutanpokikan = pZtymanseisikkanhutanpokikan;
    }

    private String ztysaihokenkbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYSAIHOKENKBN)
    public String getZtysaihokenkbn() {
        return ztysaihokenkbn;
    }

    public void setZtysaihokenkbn(String pZtysaihokenkbn) {
        ztysaihokenkbn = pZtysaihokenkbn;
    }

    private Integer ztyimustiyusbus;

    @Column(name=GenZT_SbRituRendouTy.ZTYIMUSTIYUSBUS)
    public Integer getZtyimustiyusbus() {
        return ztyimustiyusbus;
    }

    public void setZtyimustiyusbus(Integer pZtyimustiyusbus) {
        ztyimustiyusbus = pZtyimustiyusbus;
    }

    private Long ztyimusateiyoujissituhsyus;

    @Column(name=GenZT_SbRituRendouTy.ZTYIMUSATEIYOUJISSITUHSYUS)
    public Long getZtyimusateiyoujissituhsyus() {
        return ztyimusateiyoujissituhsyus;
    }

    public void setZtyimusateiyoujissituhsyus(Long pZtyimusateiyoujissituhsyus) {
        ztyimusateiyoujissituhsyus = pZtyimusateiyoujissituhsyus;
    }

    private Long ztyisahtnkngukijissituhsyus;

    @Column(name=GenZT_SbRituRendouTy.ZTYISAHTNKNGUKIJISSITUHSYUS)
    public Long getZtyisahtnkngukijissituhsyus() {
        return ztyisahtnkngukijissituhsyus;
    }

    public void setZtyisahtnkngukijissituhsyus(Long pZtyisahtnkngukijissituhsyus) {
        ztyisahtnkngukijissituhsyus = pZtyisahtnkngukijissituhsyus;
    }

    private Long ztyimusateiyoutenkansagakus;

    @Column(name=GenZT_SbRituRendouTy.ZTYIMUSATEIYOUTENKANSAGAKUS)
    public Long getZtyimusateiyoutenkansagakus() {
        return ztyimusateiyoutenkansagakus;
    }

    public void setZtyimusateiyoutenkansagakus(Long pZtyimusateiyoutenkansagakus) {
        ztyimusateiyoutenkansagakus = pZtyimusateiyoutenkansagakus;
    }

    private String ztyimusateiyouhanbaikirkbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYIMUSATEIYOUHANBAIKIRKBN)
    public String getZtyimusateiyouhanbaikirkbn() {
        return ztyimusateiyouhanbaikirkbn;
    }

    public void setZtyimusateiyouhanbaikirkbn(String pZtyimusateiyouhanbaikirkbn) {
        ztyimusateiyouhanbaikirkbn = pZtyimusateiyouhanbaikirkbn;
    }

    private String ztyoyabosyuudairitencd;

    @Column(name=GenZT_SbRituRendouTy.ZTYOYABOSYUUDAIRITENCD)
    public String getZtyoyabosyuudairitencd() {
        return ztyoyabosyuudairitencd;
    }

    public void setZtyoyabosyuudairitencd(String pZtyoyabosyuudairitencd) {
        ztyoyabosyuudairitencd = pZtyoyabosyuudairitencd;
    }

    private String ztysuuriyoubosyuukeitaikbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUBOSYUUKEITAIKBN)
    public String getZtysuuriyoubosyuukeitaikbn() {
        return ztysuuriyoubosyuukeitaikbn;
    }

    public void setZtysuuriyoubosyuukeitaikbn(String pZtysuuriyoubosyuukeitaikbn) {
        ztysuuriyoubosyuukeitaikbn = pZtysuuriyoubosyuukeitaikbn;
    }

    private String ztyhihokensyahokenage;

    @Column(name=GenZT_SbRituRendouTy.ZTYHIHOKENSYAHOKENAGE)
    public String getZtyhihokensyahokenage() {
        return ztyhihokensyahokenage;
    }

    public void setZtyhihokensyahokenage(String pZtyhihokensyahokenage) {
        ztyhihokensyahokenage = pZtyhihokensyahokenage;
    }

    private String ztyrendouyoumusntkkykhyj;

    @Column(name=GenZT_SbRituRendouTy.ZTYRENDOUYOUMUSNTKKYKHYJ)
    public String getZtyrendouyoumusntkkykhyj() {
        return ztyrendouyoumusntkkykhyj;
    }

    public void setZtyrendouyoumusntkkykhyj(String pZtyrendouyoumusntkkykhyj) {
        ztyrendouyoumusntkkykhyj = pZtyrendouyoumusntkkykhyj;
    }

    private String ztyyobiv2x11;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIV2X11)
    public String getZtyyobiv2x11() {
        return ztyyobiv2x11;
    }

    public void setZtyyobiv2x11(String pZtyyobiv2x11) {
        ztyyobiv2x11 = pZtyyobiv2x11;
    }

    private Integer ztyyobin3x6;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIN3X6)
    public Integer getZtyyobin3x6() {
        return ztyyobin3x6;
    }

    public void setZtyyobin3x6(Integer pZtyyobin3x6) {
        ztyyobin3x6 = pZtyyobin3x6;
    }

    private String ztysuuriyouyobin9x4;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN9X4)
    public String getZtysuuriyouyobin9x4() {
        return ztysuuriyouyobin9x4;
    }

    public void setZtysuuriyouyobin9x4(String pZtysuuriyouyobin9x4) {
        ztysuuriyouyobin9x4 = pZtysuuriyouyobin9x4;
    }

    private String ztyyobiv1x20;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIV1X20)
    public String getZtyyobiv1x20() {
        return ztyyobiv1x20;
    }

    public void setZtyyobiv1x20(String pZtyyobiv1x20) {
        ztyyobiv1x20 = pZtyyobiv1x20;
    }

    private String ztysuuriyouyobin5x7;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN5X7)
    public String getZtysuuriyouyobin5x7() {
        return ztysuuriyouyobin5x7;
    }

    public void setZtysuuriyouyobin5x7(String pZtysuuriyouyobin5x7) {
        ztysuuriyouyobin5x7 = pZtysuuriyouyobin5x7;
    }

    private String ztyhhknnentysihyj;

    @Column(name=GenZT_SbRituRendouTy.ZTYHHKNNENTYSIHYJ)
    public String getZtyhhknnentysihyj() {
        return ztyhhknnentysihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyhhknnentysihyj(String pZtyhhknnentysihyj) {
        ztyhhknnentysihyj = pZtyhhknnentysihyj;
    }

    private String ztysindenzusyokensyousaicd;

    @Column(name=GenZT_SbRituRendouTy.ZTYSINDENZUSYOKENSYOUSAICD)
    public String getZtysindenzusyokensyousaicd() {
        return ztysindenzusyokensyousaicd;
    }

    public void setZtysindenzusyokensyousaicd(String pZtysindenzusyokensyousaicd) {
        ztysindenzusyokensyousaicd = pZtysindenzusyokensyousaicd;
    }

    private String ztyimstiyuktekknsjsshyj;

    @Column(name=GenZT_SbRituRendouTy.ZTYIMSTIYUKTEKKNSJSSHYJ)
    public String getZtyimstiyuktekknsjsshyj() {
        return ztyimstiyuktekknsjsshyj;
    }

    public void setZtyimstiyuktekknsjsshyj(String pZtyimstiyuktekknsjsshyj) {
        ztyimstiyuktekknsjsshyj = pZtyimstiyuktekknsjsshyj;
    }

    private String ztyketuekikensasekkekkyuusu;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSASEKKEKKYUUSU)
    public String getZtyketuekikensasekkekkyuusu() {
        return ztyketuekikensasekkekkyuusu;
    }

    public void setZtyketuekikensasekkekkyuusu(String pZtyketuekikensasekkekkyuusu) {
        ztyketuekikensasekkekkyuusu = pZtyketuekikensasekkekkyuusu;
    }

    private String ztyktekknsskkkkyususykncd;

    @Column(name=GenZT_SbRituRendouTy.ZTYKTEKKNSSKKKKYUSUSYKNCD)
    public String getZtyktekknsskkkkyususykncd() {
        return ztyktekknsskkkkyususykncd;
    }

    public void setZtyktekknsskkkkyususykncd(String pZtyktekknsskkkkyususykncd) {
        ztyktekknsskkkkyususykncd = pZtyktekknsskkkkyususykncd;
    }

    private String ztyketuekikensahakkekkyuusu;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAHAKKEKKYUUSU)
    public String getZtyketuekikensahakkekkyuusu() {
        return ztyketuekikensahakkekkyuusu;
    }

    public void setZtyketuekikensahakkekkyuusu(String pZtyketuekikensahakkekkyuusu) {
        ztyketuekikensahakkekkyuusu = pZtyketuekikensahakkekkyuusu;
    }

    private String ztyktekknshkkkkyususykncd;

    @Column(name=GenZT_SbRituRendouTy.ZTYKTEKKNSHKKKKYUSUSYKNCD)
    public String getZtyktekknshkkkkyususykncd() {
        return ztyktekknshkkkkyususykncd;
    }

    public void setZtyktekknshkkkkyususykncd(String pZtyktekknshkkkkyususykncd) {
        ztyktekknshkkkkyususykncd = pZtyktekknshkkkkyususykncd;
    }

    private BizNumber ztyktekknsketusikisoryou;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouTy.ZTYKTEKKNSKETUSIKISORYOU)
    public BizNumber getZtyktekknsketusikisoryou() {
        return ztyktekknsketusikisoryou;
    }

    public void setZtyktekknsketusikisoryou(BizNumber pZtyktekknsketusikisoryou) {
        ztyktekknsketusikisoryou = pZtyktekknsketusikisoryou;
    }

    private String ztyktekknsktsksryusyokencd;

    @Column(name=GenZT_SbRituRendouTy.ZTYKTEKKNSKTSKSRYUSYOKENCD)
    public String getZtyktekknsktsksryusyokencd() {
        return ztyktekknsktsksryusyokencd;
    }

    public void setZtyktekknsktsksryusyokencd(String pZtyktekknsktsksryusyokencd) {
        ztyktekknsktsksryusyokencd = pZtyktekknsktsksryusyokencd;
    }

    private BizNumber ztyktekknshematokuritto;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouTy.ZTYKTEKKNSHEMATOKURITTO)
    public BizNumber getZtyktekknshematokuritto() {
        return ztyktekknshematokuritto;
    }

    public void setZtyktekknshematokuritto(BizNumber pZtyktekknshematokuritto) {
        ztyktekknshematokuritto = pZtyktekknshematokuritto;
    }

    private String ztyktekhmtkrttsykncd;

    @Column(name=GenZT_SbRituRendouTy.ZTYKTEKHMTKRTTSYKNCD)
    public String getZtyktekhmtkrttsykncd() {
        return ztyktekhmtkrttsykncd;
    }

    public void setZtyktekhmtkrttsykncd(String pZtyktekhmtkrttsykncd) {
        ztyktekhmtkrttsykncd = pZtyktekhmtkrttsykncd;
    }

    private BizNumber ztyketuekikensakessyoubansu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAKESSYOUBANSU)
    public BizNumber getZtyketuekikensakessyoubansu() {
        return ztyketuekikensakessyoubansu;
    }

    public void setZtyketuekikensakessyoubansu(BizNumber pZtyketuekikensakessyoubansu) {
        ztyketuekikensakessyoubansu = pZtyketuekikensakessyoubansu;
    }

    private String ztyktekknskssyubnsusyokencd;

    @Column(name=GenZT_SbRituRendouTy.ZTYKTEKKNSKSSYUBNSUSYOKENCD)
    public String getZtyktekknskssyubnsusyokencd() {
        return ztyktekknskssyubnsusyokencd;
    }

    public void setZtyktekknskssyubnsusyokencd(String pZtyktekknskssyubnsusyokencd) {
        ztyktekknskssyubnsusyokencd = pZtyktekknskssyubnsusyokencd;
    }

    private BizNumber ztyktekknskssisutnpkryu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouTy.ZTYKTEKKNSKSSISUTNPKRYU)
    public BizNumber getZtyktekknskssisutnpkryu() {
        return ztyktekknskssisutnpkryu;
    }

    public void setZtyktekknskssisutnpkryu(BizNumber pZtyktekknskssisutnpkryu) {
        ztyktekknskssisutnpkryu = pZtyktekknskssisutnpkryu;
    }

    private String ztyktekkssisutnpkryusykncd;

    @Column(name=GenZT_SbRituRendouTy.ZTYKTEKKSSISUTNPKRYUSYKNCD)
    public String getZtyktekkssisutnpkryusykncd() {
        return ztyktekkssisutnpkryusykncd;
    }

    public void setZtyktekkssisutnpkryusykncd(String pZtyktekkssisutnpkryusykncd) {
        ztyktekkssisutnpkryusykncd = pZtyktekkssisutnpkryusykncd;
    }

    private BizNumber ztyketuekikensaarubumin;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAARUBUMIN)
    public BizNumber getZtyketuekikensaarubumin() {
        return ztyketuekikensaarubumin;
    }

    public void setZtyketuekikensaarubumin(BizNumber pZtyketuekikensaarubumin) {
        ztyketuekikensaarubumin = pZtyketuekikensaarubumin;
    }

    private String ztyktekknsarubuminsyokencd;

    @Column(name=GenZT_SbRituRendouTy.ZTYKTEKKNSARUBUMINSYOKENCD)
    public String getZtyktekknsarubuminsyokencd() {
        return ztyktekknsarubuminsyokencd;
    }

    public void setZtyktekknsarubuminsyokencd(String pZtyktekknsarubuminsyokencd) {
        ztyktekknsarubuminsyokencd = pZtyktekknsarubuminsyokencd;
    }

    private BizNumber ztyketuekikensaztt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAZTT)
    public BizNumber getZtyketuekikensaztt() {
        return ztyketuekikensaztt;
    }

    public void setZtyketuekikensaztt(BizNumber pZtyketuekikensaztt) {
        ztyketuekikensaztt = pZtyketuekikensaztt;
    }

    private String ztyketuekikensazttsyokencd;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAZTTSYOKENCD)
    public String getZtyketuekikensazttsyokencd() {
        return ztyketuekikensazttsyokencd;
    }

    public void setZtyketuekikensazttsyokencd(String pZtyketuekikensazttsyokencd) {
        ztyketuekikensazttsyokencd = pZtyketuekikensazttsyokencd;
    }

    private String ztyketuekikensagot;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAGOT)
    public String getZtyketuekikensagot() {
        return ztyketuekikensagot;
    }

    public void setZtyketuekikensagot(String pZtyketuekikensagot) {
        ztyketuekikensagot = pZtyketuekikensagot;
    }

    private String ztyketuekikensagotsyokencd;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAGOTSYOKENCD)
    public String getZtyketuekikensagotsyokencd() {
        return ztyketuekikensagotsyokencd;
    }

    public void setZtyketuekikensagotsyokencd(String pZtyketuekikensagotsyokencd) {
        ztyketuekikensagotsyokencd = pZtyketuekikensagotsyokencd;
    }

    private String ztyketuekikensagpt;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAGPT)
    public String getZtyketuekikensagpt() {
        return ztyketuekikensagpt;
    }

    public void setZtyketuekikensagpt(String pZtyketuekikensagpt) {
        ztyketuekikensagpt = pZtyketuekikensagpt;
    }

    private String ztyketuekikensagptsyokencd;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAGPTSYOKENCD)
    public String getZtyketuekikensagptsyokencd() {
        return ztyketuekikensagptsyokencd;
    }

    public void setZtyketuekikensagptsyokencd(String pZtyketuekikensagptsyokencd) {
        ztyketuekikensagptsyokencd = pZtyketuekikensagptsyokencd;
    }

    private String ztyketuekikensaganmagtp;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAGANMAGTP)
    public String getZtyketuekikensaganmagtp() {
        return ztyketuekikensaganmagtp;
    }

    public void setZtyketuekikensaganmagtp(String pZtyketuekikensaganmagtp) {
        ztyketuekikensaganmagtp = pZtyketuekikensaganmagtp;
    }

    private String ztyketuekiganmagtpsyokencd;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIGANMAGTPSYOKENCD)
    public String getZtyketuekiganmagtpsyokencd() {
        return ztyketuekiganmagtpsyokencd;
    }

    public void setZtyketuekiganmagtpsyokencd(String pZtyketuekiganmagtpsyokencd) {
        ztyketuekiganmagtpsyokencd = pZtyketuekiganmagtpsyokencd;
    }

    private String ztyketuekikensasouchol;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSASOUCHOL)
    public String getZtyketuekikensasouchol() {
        return ztyketuekikensasouchol;
    }

    public void setZtyketuekikensasouchol(String pZtyketuekikensasouchol) {
        ztyketuekikensasouchol = pZtyketuekikensasouchol;
    }

    private String ztyketuekicholsyokencd;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKICHOLSYOKENCD)
    public String getZtyketuekicholsyokencd() {
        return ztyketuekicholsyokencd;
    }

    public void setZtyketuekicholsyokencd(String pZtyketuekicholsyokencd) {
        ztyketuekicholsyokencd = pZtyketuekicholsyokencd;
    }

    private String ztyketuekikensahdlchol;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAHDLCHOL)
    public String getZtyketuekikensahdlchol() {
        return ztyketuekikensahdlchol;
    }

    public void setZtyketuekikensahdlchol(String pZtyketuekikensahdlchol) {
        ztyketuekikensahdlchol = pZtyketuekikensahdlchol;
    }

    private String ztyketuekikensahdlsyokencd;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAHDLSYOKENCD)
    public String getZtyketuekikensahdlsyokencd() {
        return ztyketuekikensahdlsyokencd;
    }

    public void setZtyketuekikensahdlsyokencd(String pZtyketuekikensahdlsyokencd) {
        ztyketuekikensahdlsyokencd = pZtyketuekikensahdlsyokencd;
    }

    private BizNumber ztyktekknstukhmgrbn;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouTy.ZTYKTEKKNSTUKHMGRBN)
    public BizNumber getZtyktekknstukhmgrbn() {
        return ztyktekknstukhmgrbn;
    }

    public void setZtyktekknstukhmgrbn(BizNumber pZtyktekknstukhmgrbn) {
        ztyktekknstukhmgrbn = pZtyktekknstukhmgrbn;
    }

    private String ztyktekhmgrbnsykncd;

    @Column(name=GenZT_SbRituRendouTy.ZTYKTEKHMGRBNSYKNCD)
    public String getZtyktekhmgrbnsykncd() {
        return ztyktekhmgrbnsykncd;
    }

    public void setZtyktekhmgrbnsykncd(String pZtyktekhmgrbnsykncd) {
        ztyktekhmgrbnsykncd = pZtyktekhmgrbnsykncd;
    }

    private String ztyktekknskorinesuterrze;

    @Column(name=GenZT_SbRituRendouTy.ZTYKTEKKNSKORINESUTERRZE)
    public String getZtyktekknskorinesuterrze() {
        return ztyktekknskorinesuterrze;
    }

    public void setZtyktekknskorinesuterrze(String pZtyktekknskorinesuterrze) {
        ztyktekknskorinesuterrze = pZtyktekknskorinesuterrze;
    }

    private String ztykorinesuterrzesyokencd;

    @Column(name=GenZT_SbRituRendouTy.ZTYKORINESUTERRZESYOKENCD)
    public String getZtykorinesuterrzesyokencd() {
        return ztykorinesuterrzesyokencd;
    }

    public void setZtykorinesuterrzesyokencd(String pZtykorinesuterrzesyokencd) {
        ztykorinesuterrzesyokencd = pZtykorinesuterrzesyokencd;
    }

    private BizNumber ztyketuekikensamcv;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAMCV)
    public BizNumber getZtyketuekikensamcv() {
        return ztyketuekikensamcv;
    }

    public void setZtyketuekikensamcv(BizNumber pZtyketuekikensamcv) {
        ztyketuekikensamcv = pZtyketuekikensamcv;
    }

    private String ztyketuekikensamcvsyokencd;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAMCVSYOKENCD)
    public String getZtyketuekikensamcvsyokencd() {
        return ztyketuekikensamcvsyokencd;
    }

    public void setZtyketuekikensamcvsyokencd(String pZtyketuekikensamcvsyokencd) {
        ztyketuekikensamcvsyokencd = pZtyketuekikensamcvsyokencd;
    }

    private BizNumber ztyketuekikensamch;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAMCH)
    public BizNumber getZtyketuekikensamch() {
        return ztyketuekikensamch;
    }

    public void setZtyketuekikensamch(BizNumber pZtyketuekikensamch) {
        ztyketuekikensamch = pZtyketuekikensamch;
    }

    private String ztyketuekikensamchsyokencd;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAMCHSYOKENCD)
    public String getZtyketuekikensamchsyokencd() {
        return ztyketuekikensamchsyokencd;
    }

    public void setZtyketuekikensamchsyokencd(String pZtyketuekikensamchsyokencd) {
        ztyketuekikensamchsyokencd = pZtyketuekikensamchsyokencd;
    }

    private BizNumber ztyketuekikensamchc;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAMCHC)
    public BizNumber getZtyketuekikensamchc() {
        return ztyketuekikensamchc;
    }

    public void setZtyketuekikensamchc(BizNumber pZtyketuekikensamchc) {
        ztyketuekikensamchc = pZtyketuekikensamchc;
    }

    private String ztyketuekikensamchcsyokencd;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAMCHCSYOKENCD)
    public String getZtyketuekikensamchcsyokencd() {
        return ztyketuekikensamchcsyokencd;
    }

    public void setZtyketuekikensamchcsyokencd(String pZtyketuekikensamchcsyokencd) {
        ztyketuekikensamchcsyokencd = pZtyketuekikensamchcsyokencd;
    }

    private BizNumber ztyketuekikensacea;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSACEA)
    public BizNumber getZtyketuekikensacea() {
        return ztyketuekikensacea;
    }

    public void setZtyketuekikensacea(BizNumber pZtyketuekikensacea) {
        ztyketuekikensacea = pZtyketuekikensacea;
    }

    private String ztyketuekikensaceasyokencd;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSACEASYOKENCD)
    public String getZtyketuekikensaceasyokencd() {
        return ztyketuekikensaceasyokencd;
    }

    public void setZtyketuekikensaceasyokencd(String pZtyketuekikensaceasyokencd) {
        ztyketuekikensaceasyokencd = pZtyketuekikensaceasyokencd;
    }

    private BizNumber ztyketuekikensaafp;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAAFP)
    public BizNumber getZtyketuekikensaafp() {
        return ztyketuekikensaafp;
    }

    public void setZtyketuekikensaafp(BizNumber pZtyketuekikensaafp) {
        ztyketuekikensaafp = pZtyketuekikensaafp;
    }

    private String ztyketuekikensaafpsyokencd;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAAFPSYOKENCD)
    public String getZtyketuekikensaafpsyokencd() {
        return ztyketuekikensaafpsyokencd;
    }

    public void setZtyketuekikensaafpsyokencd(String pZtyketuekikensaafpsyokencd) {
        ztyketuekikensaafpsyokencd = pZtyketuekikensaafpsyokencd;
    }

    private String ztyketuekikensahbskbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAHBSKBN)
    public String getZtyketuekikensahbskbn() {
        return ztyketuekikensahbskbn;
    }

    public void setZtyketuekikensahbskbn(String pZtyketuekikensahbskbn) {
        ztyketuekikensahbskbn = pZtyketuekikensahbskbn;
    }

    private String ztyketuekikensahbssyokencd;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAHBSSYOKENCD)
    public String getZtyketuekikensahbssyokencd() {
        return ztyketuekikensahbssyokencd;
    }

    public void setZtyketuekikensahbssyokencd(String pZtyketuekikensahbssyokencd) {
        ztyketuekikensahbssyokencd = pZtyketuekikensahbssyokencd;
    }

    private String ztyketuekikensahcvkbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAHCVKBN)
    public String getZtyketuekikensahcvkbn() {
        return ztyketuekikensahcvkbn;
    }

    public void setZtyketuekikensahcvkbn(String pZtyketuekikensahcvkbn) {
        ztyketuekikensahcvkbn = pZtyketuekikensahcvkbn;
    }

    private String ztyketuekikensahcvsyokencd;

    @Column(name=GenZT_SbRituRendouTy.ZTYKETUEKIKENSAHCVSYOKENCD)
    public String getZtyketuekikensahcvsyokencd() {
        return ztyketuekikensahcvsyokencd;
    }

    public void setZtyketuekikensahcvsyokencd(String pZtyketuekikensahcvsyokencd) {
        ztyketuekikensahcvsyokencd = pZtyketuekikensahcvsyokencd;
    }

    private String ztyimusateiyouknsnsytryskbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYIMUSATEIYOUKNSNSYTRYSKBN)
    public String getZtyimusateiyouknsnsytryskbn() {
        return ztyimusateiyouknsnsytryskbn;
    }

    public void setZtyimusateiyouknsnsytryskbn(String pZtyimusateiyouknsnsytryskbn) {
        ztyimusateiyouknsnsytryskbn = pZtyimusateiyouknsnsytryskbn;
    }

    private String ztysyosinldlchol;

    @Column(name=GenZT_SbRituRendouTy.ZTYSYOSINLDLCHOL)
    public String getZtysyosinldlchol() {
        return ztysyosinldlchol;
    }

    public void setZtysyosinldlchol(String pZtysyosinldlchol) {
        ztysyosinldlchol = pZtysyosinldlchol;
    }

    private String ztytokuteijyoutaihushrhyj;

    @Column(name=GenZT_SbRituRendouTy.ZTYTOKUTEIJYOUTAIHUSHRHYJ)
    public String getZtytokuteijyoutaihushrhyj() {
        return ztytokuteijyoutaihushrhyj;
    }

    public void setZtytokuteijyoutaihushrhyj(String pZtytokuteijyoutaihushrhyj) {
        ztytokuteijyoutaihushrhyj = pZtytokuteijyoutaihushrhyj;
    }

    private Integer ztyrendouyouosyukeiyakup;

    @Column(name=GenZT_SbRituRendouTy.ZTYRENDOUYOUOSYUKEIYAKUP)
    public Integer getZtyrendouyouosyukeiyakup() {
        return ztyrendouyouosyukeiyakup;
    }

    public void setZtyrendouyouosyukeiyakup(Integer pZtyrendouyouosyukeiyakup) {
        ztyrendouyouosyukeiyakup = pZtyrendouyouosyukeiyakup;
    }

    private String ztytokubetuhosyoukikan;

    @Column(name=GenZT_SbRituRendouTy.ZTYTOKUBETUHOSYOUKIKAN)
    public String getZtytokubetuhosyoukikan() {
        return ztytokubetuhosyoukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtytokubetuhosyoukikan(String pZtytokubetuhosyoukikan) {
        ztytokubetuhosyoukikan = pZtytokubetuhosyoukikan;
    }

    private Integer ztyrendouyougoukeitenkans;

    @Column(name=GenZT_SbRituRendouTy.ZTYRENDOUYOUGOUKEITENKANS)
    public Integer getZtyrendouyougoukeitenkans() {
        return ztyrendouyougoukeitenkans;
    }

    public void setZtyrendouyougoukeitenkans(Integer pZtyrendouyougoukeitenkans) {
        ztyrendouyougoukeitenkans = pZtyrendouyougoukeitenkans;
    }

    private Integer ztyrnduyugukitnknkakaku;

    @Column(name=GenZT_SbRituRendouTy.ZTYRNDUYUGUKITNKNKAKAKU)
    public Integer getZtyrnduyugukitnknkakaku() {
        return ztyrnduyugukitnknkakaku;
    }

    public void setZtyrnduyugukitnknkakaku(Integer pZtyrnduyugukitnknkakaku) {
        ztyrnduyugukitnknkakaku = pZtyrnduyugukitnknkakaku;
    }

    private Integer ztyrnduyuwnsgukitnknkakaku;

    @Column(name=GenZT_SbRituRendouTy.ZTYRNDUYUWNSGUKITNKNKAKAKU)
    public Integer getZtyrnduyuwnsgukitnknkakaku() {
        return ztyrnduyuwnsgukitnknkakaku;
    }

    public void setZtyrnduyuwnsgukitnknkakaku(Integer pZtyrnduyuwnsgukitnknkakaku) {
        ztyrnduyuwnsgukitnknkakaku = pZtyrnduyuwnsgukitnknkakaku;
    }

    private BizNumber ztymostnknkhnbbnjyuturt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouTy.ZTYMOSTNKNKHNBBNJYUTURT)
    public BizNumber getZtymostnknkhnbbnjyuturt() {
        return ztymostnknkhnbbnjyuturt;
    }

    public void setZtymostnknkhnbbnjyuturt(BizNumber pZtymostnknkhnbbnjyuturt) {
        ztymostnknkhnbbnjyuturt = pZtymostnknkhnbbnjyuturt;
    }

    private Integer ztyrnduyusykykbbnkhns;

    @Column(name=GenZT_SbRituRendouTy.ZTYRNDUYUSYKYKBBNKHNS)
    public Integer getZtyrnduyusykykbbnkhns() {
        return ztyrnduyusykykbbnkhns;
    }

    public void setZtyrnduyusykykbbnkhns(Integer pZtyrnduyusykykbbnkhns) {
        ztyrnduyusykykbbnkhns = pZtyrnduyusykykbbnkhns;
    }

    private BizNumber ztyrendouyouyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouTy.ZTYRENDOUYOUYOTEIRIRITU)
    public BizNumber getZtyrendouyouyoteiriritu() {
        return ztyrendouyouyoteiriritu;
    }

    public void setZtyrendouyouyoteiriritu(BizNumber pZtyrendouyouyoteiriritu) {
        ztyrendouyouyoteiriritu = pZtyrendouyouyoteiriritu;
    }

    private String ztyknkuzusnzyrt;

    @Column(name=GenZT_SbRituRendouTy.ZTYKNKUZUSNZYRT)
    public String getZtyknkuzusnzyrt() {
        return ztyknkuzusnzyrt;
    }

    public void setZtyknkuzusnzyrt(String pZtyknkuzusnzyrt) {
        ztyknkuzusnzyrt = pZtyknkuzusnzyrt;
    }

    private String ztyyobiv121;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIV121)
    public String getZtyyobiv121() {
        return ztyyobiv121;
    }

    public void setZtyyobiv121(String pZtyyobiv121) {
        ztyyobiv121 = pZtyyobiv121;
    }

    private String ztyraysystemhyj;

    @Column(name=GenZT_SbRituRendouTy.ZTYRAYSYSTEMHYJ)
    public String getZtyraysystemhyj() {
        return ztyraysystemhyj;
    }

    public void setZtyraysystemhyj(String pZtyraysystemhyj) {
        ztyraysystemhyj = pZtyraysystemhyj;
    }

    private String ztygaikakbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYGAIKAKBN)
    public String getZtygaikakbn() {
        return ztygaikakbn;
    }

    public void setZtygaikakbn(String pZtygaikakbn) {
        ztygaikakbn = pZtygaikakbn;
    }

    private Long ztygaikadatekihons;

    @Column(name=GenZT_SbRituRendouTy.ZTYGAIKADATEKIHONS)
    public Long getZtygaikadatekihons() {
        return ztygaikadatekihons;
    }

    public void setZtygaikadatekihons(Long pZtygaikadatekihons) {
        ztygaikadatekihons = pZtygaikadatekihons;
    }

    private Long ztygaikadatesibous;

    @Column(name=GenZT_SbRituRendouTy.ZTYGAIKADATESIBOUS)
    public Long getZtygaikadatesibous() {
        return ztygaikadatesibous;
    }

    public void setZtygaikadatesibous(Long pZtygaikadatesibous) {
        ztygaikadatesibous = pZtygaikadatesibous;
    }

    private BizNumber ztykeiyakujiyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouTy.ZTYKEIYAKUJIYOTEIRIRITU)
    public BizNumber getZtykeiyakujiyoteiriritu() {
        return ztykeiyakujiyoteiriritu;
    }

    public void setZtykeiyakujiyoteiriritu(BizNumber pZtykeiyakujiyoteiriritu) {
        ztykeiyakujiyoteiriritu = pZtykeiyakujiyoteiriritu;
    }

    private BizNumber ztykawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouTy.ZTYKAWASERATE)
    public BizNumber getZtykawaserate() {
        return ztykawaserate;
    }

    public void setZtykawaserate(BizNumber pZtykawaserate) {
        ztykawaserate = pZtykawaserate;
    }

    private String ztykawaseratetekiyouymd;

    @Column(name=GenZT_SbRituRendouTy.ZTYKAWASERATETEKIYOUYMD)
    public String getZtykawaseratetekiyouymd() {
        return ztykawaseratetekiyouymd;
    }

    public void setZtykawaseratetekiyouymd(String pZtykawaseratetekiyouymd) {
        ztykawaseratetekiyouymd = pZtykawaseratetekiyouymd;
    }

    private Long ztyenkdtsbujsitihsyukngk;

    @Column(name=GenZT_SbRituRendouTy.ZTYENKDTSBUJSITIHSYUKNGK)
    public Long getZtyenkdtsbujsitihsyukngk() {
        return ztyenkdtsbujsitihsyukngk;
    }

    public void setZtyenkdtsbujsitihsyukngk(Long pZtyenkdtsbujsitihsyukngk) {
        ztyenkdtsbujsitihsyukngk = pZtyenkdtsbujsitihsyukngk;
    }

    private String ztysrdai1hknkkn;

    @Column(name=GenZT_SbRituRendouTy.ZTYSRDAI1HKNKKN)
    public String getZtysrdai1hknkkn() {
        return ztysrdai1hknkkn;
    }

    public void setZtysrdai1hknkkn(String pZtysrdai1hknkkn) {
        ztysrdai1hknkkn = pZtysrdai1hknkkn;
    }

    private String ztysuuriyouyobin8;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN8)
    public String getZtysuuriyouyobin8() {
        return ztysuuriyouyobin8;
    }

    public void setZtysuuriyouyobin8(String pZtysuuriyouyobin8) {
        ztysuuriyouyobin8 = pZtysuuriyouyobin8;
    }

    private String ztysuuriyouyobin10x2;

    @Column(name=GenZT_SbRituRendouTy.ZTYSUURIYOUYOBIN10X2)
    public String getZtysuuriyouyobin10x2() {
        return ztysuuriyouyobin10x2;
    }

    public void setZtysuuriyouyobin10x2(String pZtysuuriyouyobin10x2) {
        ztysuuriyouyobin10x2 = pZtysuuriyouyobin10x2;
    }

    private String ztytuukasyukbn;

    @Column(name=GenZT_SbRituRendouTy.ZTYTUUKASYUKBN)
    public String getZtytuukasyukbn() {
        return ztytuukasyukbn;
    }

    public void setZtytuukasyukbn(String pZtytuukasyukbn) {
        ztytuukasyukbn = pZtytuukasyukbn;
    }

    private String ztyyobiv9;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIV9)
    public String getZtyyobiv9() {
        return ztyyobiv9;
    }

    public void setZtyyobiv9(String pZtyyobiv9) {
        ztyyobiv9 = pZtyyobiv9;
    }

    private String ztyyobiv10x4;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIV10X4)
    public String getZtyyobiv10x4() {
        return ztyyobiv10x4;
    }

    public void setZtyyobiv10x4(String pZtyyobiv10x4) {
        ztyyobiv10x4 = pZtyyobiv10x4;
    }

    private Integer ztyyobin7;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIN7)
    public Integer getZtyyobin7() {
        return ztyyobin7;
    }

    public void setZtyyobin7(Integer pZtyyobin7) {
        ztyyobin7 = pZtyyobin7;
    }

    private Integer ztyyobin7x2;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIN7X2)
    public Integer getZtyyobin7x2() {
        return ztyyobin7x2;
    }

    public void setZtyyobin7x2(Integer pZtyyobin7x2) {
        ztyyobin7x2 = pZtyyobin7x2;
    }

    private Integer ztyyobin7x3;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIN7X3)
    public Integer getZtyyobin7x3() {
        return ztyyobin7x3;
    }

    public void setZtyyobin7x3(Integer pZtyyobin7x3) {
        ztyyobin7x3 = pZtyyobin7x3;
    }

    private Integer ztyyobin7x4;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIN7X4)
    public Integer getZtyyobin7x4() {
        return ztyyobin7x4;
    }

    public void setZtyyobin7x4(Integer pZtyyobin7x4) {
        ztyyobin7x4 = pZtyyobin7x4;
    }

    private Integer ztyyobin7x5;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIN7X5)
    public Integer getZtyyobin7x5() {
        return ztyyobin7x5;
    }

    public void setZtyyobin7x5(Integer pZtyyobin7x5) {
        ztyyobin7x5 = pZtyyobin7x5;
    }

    private String ztyyobiv4x2;

    @Column(name=GenZT_SbRituRendouTy.ZTYYOBIV4X2)
    public String getZtyyobiv4x2() {
        return ztyyobiv4x2;
    }

    public void setZtyyobiv4x2(String pZtyyobiv4x2) {
        ztyyobiv4x2 = pZtyyobiv4x2;
    }
}