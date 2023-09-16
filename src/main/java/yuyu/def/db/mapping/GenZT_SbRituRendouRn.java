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
import yuyu.def.db.entity.ZT_SbRituRendouRn;
import yuyu.def.db.id.PKZT_SbRituRendouRn;
import yuyu.def.db.meta.GenQZT_SbRituRendouRn;
import yuyu.def.db.meta.QZT_SbRituRendouRn;

/**
 * 死亡率用連動Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SbRituRendouRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SbRituRendouRn}</td><td colspan="3">死亡率用連動Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyobiv12x7 zrnyobiv12x7}</td><td>（連携用）予備項目Ｖ１２＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndatakanrino zrndatakanrino}</td><td>（連携用）データ管理番号</td><td align="center">{@link PKZT_SbRituRendouRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaimnkkykhyj zrnsaimnkkykhyj}</td><td>（連携用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrendouyoukikan zrnrendouyoukikan}</td><td>（連携用）連動用期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhihokensyaagev2 zrnhihokensyaagev2}</td><td>（連携用）被保険者年令Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrendouyoukeiyakunengetu zrnrendouyoukeiyakunengetu}</td><td>（連携用）連動用契約年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrendouyoukihons zrnrendouyoukihons}</td><td>（連携用）連動用基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnrendouyousibous zrnrendouyousibous}</td><td>（連携用）連動用死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrntnknitjbrigisbus zrntnknitjbrigisbus}</td><td>（連携用）転換一時払以外死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrntenkanminaosikbn zrntenkanminaosikbn}</td><td>（連携用）転換見直区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrendouyouhrkhouhoukbn zrnrendouyouhrkhouhoukbn}</td><td>（連携用）連動用払込方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrendouyoujyuusyokbn zrnrendouyoujyuusyokbn}</td><td>（連携用）連動用住所区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatukaisosikicd zrnaatukaisosikicd}</td><td>（連携用）Ａ扱者組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrendouyousakugenkikan zrnrendouyousakugenkikan}</td><td>（連携用）連動用削減期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrnduyuryumshyutn zrnrnduyuryumshyutn}</td><td>（連携用）連動用料増標点</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrendouyoubosyuuym zrnrendouyoubosyuuym}</td><td>（連携用）連動用募集年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin1 zrnsuuriyouyobin1}</td><td>（連携用）数理用予備項目Ｎ１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykgycd zrnsykgycd}</td><td>（連携用）職業コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhikettisyacd zrndakuhikettisyacd}</td><td>（連携用）諾否決定者コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hihokensyahyouji zrndai2hihokensyahyouji}</td><td>（連携用）第２被保険者表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrenseimusntkknyuhyj zrnrenseimusntkknyuhyj}</td><td>（連携用）連生無選択加入表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokubetumaruteiarihyj zrntokubetumaruteiarihyj}</td><td>（連携用）特別マル定有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndougakutenkanhyouji zrndougakutenkanhyouji}</td><td>（連携用）同額転換表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkansentakuhouhoukbn zrntenkansentakuhouhoukbn}</td><td>（連携用）転換選択方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokubetusentakuarikbn zrntokubetusentakuarikbn}</td><td>（連携用）特別選択有区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketteikekkakbn zrnketteikekkakbn}</td><td>（連携用）決定結果区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakukakuninsyuruikbn zrnkeiyakukakuninsyuruikbn}</td><td>（連携用）契約確認種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakukakuninriyuukbn zrnkeiyakukakuninriyuukbn}</td><td>（連携用）契約確認理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrendouyoukekkancdx1 zrnrendouyoukekkancdx1}</td><td>（連携用）連動用欠陥コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikanensuux1 zrnkeikanensuux1}</td><td>（連携用）経過年数＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyujyutuarihyoujix1 zrnsyujyutuarihyoujix1}</td><td>（連携用）手術有表示＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrendouyoukekkancdx2 zrnrendouyoukekkancdx2}</td><td>（連携用）連動用欠陥コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikanensuux2 zrnkeikanensuux2}</td><td>（連携用）経過年数＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyujyutuarihyoujix2 zrnsyujyutuarihyoujix2}</td><td>（連携用）手術有表示＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaihokenhyouji zrnsaihokenhyouji}</td><td>（連携用）再保険表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrnduyusysnhujyusnssyacd zrnrnduyusysnhujyusnssyacd}</td><td>（連携用）連動用初診報状診査者コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrndyusysnhujyusnshuhukbn zrnrndyusysnhujyusnshuhukbn}</td><td>（連携用）連動用初診報状診査方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaisinriyuukbn zrnsaisinriyuukbn}</td><td>（連携用）再診理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyoutousaisinarihyouji zrnnyoutousaisinarihyouji}</td><td>（連携用）尿糖再診有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyoutanpakusaisinarihyj zrnnyoutanpakusaisinarihyj}</td><td>（連携用）尿蛋白再診有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhemasaisinarihyouji zrnhemasaisinarihyouji}</td><td>（連携用）ヘマ再診有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkettousaisinarihyouji zrnkettousaisinarihyouji}</td><td>（連携用）血糖再診有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsintyousaisinarihyouji zrnsintyousaisinarihyouji}</td><td>（連携用）身長再診有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyouisaisinarihyouji zrnkyouisaisinarihyouji}</td><td>（連携用）胸囲再診有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhukuisaisinarihyouji zrnhukuisaisinarihyouji}</td><td>（連携用）腹囲再診有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntaijyuusaisinarihyouji zrntaijyuusaisinarihyouji}</td><td>（連携用）体重再診有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuatusaisinarihyouji zrnketuatusaisinarihyouji}</td><td>（連携用）血圧再診有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrndyusisnhujyusnssyacd zrnrndyusisnhujyusnssyacd}</td><td>（連携用）連動用再診報状診査者コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrndyusisnhujyusnshuhukbn zrnrndyusisnhujyusnshuhukbn}</td><td>（連携用）連動用再診報状診査方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyoutoukbn zrnnyoutoukbn}</td><td>（連携用）尿糖区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1x2 zrnyobiv1x2}</td><td>（連携用）予備項目Ｖ１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyoutanpakukbn zrnnyoutanpakukbn}</td><td>（連携用）尿蛋白区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhemakbn zrnhemakbn}</td><td>（連携用）ヘマ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkettoutikeikajikan zrnkettoutikeikajikan}</td><td>（連携用）血糖値経過時間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkettouti zrnkettouti}</td><td>（連携用）血糖値</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsintyou zrnsintyou}</td><td>（連携用）身長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnkyoui zrnkyoui}</td><td>（連携用）胸囲</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnhukui zrnhukui}</td><td>（連携用）腹囲</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrntaijyuu zrntaijyuu}</td><td>（連携用）体重</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsaikouketuatu zrnsaikouketuatu}</td><td>（連携用）最高血圧</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsaiteiketuatu zrnsaiteiketuatu}</td><td>（連携用）最低血圧</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnxsensyokencd zrnxsensyokencd}</td><td>（連携用）Ｘ線所見コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsindenzusyokencd zrnsindenzusyokencd}</td><td>（連携用）心電図所見コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrnduyuganteisysnsyokencd zrnrnduyuganteisysnsyokencd}</td><td>（連携用）連動用眼底写真所見コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsinsahouhousiyoukbn zrnsinsahouhousiyoukbn}</td><td>（連携用）診査方法使用区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnvipteikihyouji zrnvipteikihyouji}</td><td>（連携用）ＶＩＰ定期表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhoujyounomihyouji zrnhoujyounomihyouji}</td><td>（連携用）報状のみ表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuekikensajissikbn zrnketuekikensajissikbn}</td><td>（連携用）血液検査実施区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruteisyuruikigou zrnmaruteisyuruikigou}</td><td>（連携用）マル定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseizonmrtisyuruikgu zrnseizonmrtisyuruikgu}</td><td>（連携用）生存マル定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketusikisoryou zrnketusikisoryou}</td><td>（連携用）血色素量</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrngot zrngot}</td><td>（連携用）ＧＯＴ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrngpt zrngpt}</td><td>（連携用）ＧＰＴ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnganmagtp zrnganmagtp}</td><td>（連携用）ガンマＧＴＰ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsyumisyatkisindenzukbn zrnsyumisyatkisindenzukbn}</td><td>（連携用）証明書扱心電図区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkituenkbn zrnkituenkbn}</td><td>（連携用）喫煙区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntignmrtisyukgu zrntignmrtisyukgu}</td><td>（連携用）逓減マル定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigenmaruteikikan zrnteigenmaruteikikan}</td><td>（連携用）逓減マル定期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkituenhonsuu zrnkituenhonsuu}</td><td>（連携用）喫煙本数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2 zrnyobiv2}</td><td>（連携用）予備項目Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin1x2 zrnsuuriyouyobin1x2}</td><td>（連携用）数理用予備項目Ｎ１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrnduyusppinyuintkykntgk zrnrnduyusppinyuintkykntgk}</td><td>（連携用）連動用疾病入院特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin12 zrnsuuriyouyobin12}</td><td>（連携用）数理用予備項目Ｎ１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2x2 zrnyobiv2x2}</td><td>（連携用）予備項目Ｖ２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin1x3 zrnsuuriyouyobin1x3}</td><td>（連携用）数理用予備項目Ｎ１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobin3 zrnyobin3}</td><td>（連携用）予備項目Ｎ３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin12x2 zrnsuuriyouyobin12x2}</td><td>（連携用）数理用予備項目Ｎ１２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngoukeiteigenteikitkyks zrngoukeiteigenteikitkyks}</td><td>（連携用）合計逓減定期特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrntigntikbbntnknitjbrs zrntigntikbbntnknitjbrs}</td><td>（連携用）逓減定期部分転換一時払Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrntokuteisippeisetkbn zrntokuteisippeisetkbn}</td><td>（連携用）特定疾病セット区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin2 zrnsuuriyouyobin2}</td><td>（連携用）数理用予備項目Ｎ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntaikakukijyunkanwahyouji zrntaikakukijyunkanwahyouji}</td><td>（連携用）体格基準緩和表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhaitoukbn zrnhaitoukbn}</td><td>（連携用）配当区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsnsykrketkbtsntkarihyj zrnsnsykrketkbtsntkarihyj}</td><td>（連携用）新種切替特別選択有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatukaikojincd zrnaatukaikojincd}</td><td>（連携用）Ａ扱者個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1x5 zrnyobiv1x5}</td><td>（連携用）予備項目Ｖ１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmanseisikkansetkbn zrnmanseisikkansetkbn}</td><td>（連携用）慢性疾患セット区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngengakutenkankykhyj zrngengakutenkankykhyj}</td><td>（連携用）減額転換契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2x4 zrnyobiv2x4}</td><td>（連携用）予備項目Ｖ２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfilekbn zrnfilekbn}</td><td>（連携用）ファイル区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2x5 zrnyobiv2x5}</td><td>（連携用）予備項目Ｖ２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin1x4 zrnsuuriyouyobin1x4}</td><td>（連携用）数理用予備項目Ｎ１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobin3x2 zrnyobin3x2}</td><td>（連携用）予備項目Ｎ３＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin12x3 zrnsuuriyouyobin12x3}</td><td>（連携用）数理用予備項目Ｎ１２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2x6 zrnyobiv2x6}</td><td>（連携用）予備項目Ｖ２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin1x5 zrnsuuriyouyobin1x5}</td><td>（連携用）数理用予備項目Ｎ１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobin3x3 zrnyobin3x3}</td><td>（連携用）予備項目Ｎ３＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin12x4 zrnsuuriyouyobin12x4}</td><td>（連携用）数理用予備項目Ｎ１２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2x7 zrnyobiv2x7}</td><td>（連携用）予備項目Ｖ２＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin1x6 zrnsuuriyouyobin1x6}</td><td>（連携用）数理用予備項目Ｎ１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobin3x4 zrnyobin3x4}</td><td>（連携用）予備項目Ｎ３＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin12x5 zrnsuuriyouyobin12x5}</td><td>（連携用）数理用予備項目Ｎ１２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntaikakuhyouten zrntaikakuhyouten}</td><td>（連携用）体格標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnnyoutousykykhyutn zrnnyoutousykykhyutn}</td><td>（連携用）尿糖主契約標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnnyoutanpakusykykhyutn zrnnyoutanpakusykykhyutn}</td><td>（連携用）尿蛋白主契約標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnketuatutandokuhyouten zrnketuatutandokuhyouten}</td><td>（連携用）血圧単独標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyobin5 zrnyobin5}</td><td>（連携用）予備項目Ｎ５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin9 zrnsuuriyouyobin9}</td><td>（連携用）数理用予備項目Ｎ９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobin5x2 zrnyobin5x2}</td><td>（連携用）予備項目Ｎ５＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin9x2 zrnsuuriyouyobin9x2}</td><td>（連携用）数理用予備項目Ｎ９＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobin5x3 zrnyobin5x3}</td><td>（連携用）予備項目Ｎ５＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin9x3 zrnsuuriyouyobin9x3}</td><td>（連携用）数理用予備項目Ｎ９＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyunyumrtisyukgu zrnsyunyumrtisyukgu}</td><td>（連携用）収入マル定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuunyuumaruteikikan zrnsyuunyuumaruteikikan}</td><td>（連携用）収入マル定期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuunyuumrtinknengkn5 zrnsyuunyuumrtinknengkn5}</td><td>（連携用）収入マル定年金年額Ｎ５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsyuunyuumrtinkshrkkn zrnsyuunyuumrtinkshrkkn}</td><td>（連携用）収入マル定年金支払期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin12x6 zrnsuuriyouyobin12x6}</td><td>（連携用）数理用予備項目Ｎ１２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhutanpobui1 zrnhutanpobui1}</td><td>（連携用）不担保部位１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnpkkn1 zrnhtnpkkn1}</td><td>（連携用）不担保期間１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhutanpobui2 zrnhutanpobui2}</td><td>（連携用）不担保部位２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnpkkn2 zrnhtnpkkn2}</td><td>（連携用）不担保期間２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyosinnyoutou zrnsyosinnyoutou}</td><td>（連携用）初診尿糖</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyosinnyoutanpaku zrnsyosinnyoutanpaku}</td><td>（連携用）初診尿蛋白</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyosinnyousenketu zrnsyosinnyousenketu}</td><td>（連携用）初診尿潜血</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyosinsaikouketuatu zrnsyosinsaikouketuatu}</td><td>（連携用）初診最高血圧</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsyosinsaiteiketuatu zrnsyosinsaiteiketuatu}</td><td>（連携用）初診最低血圧</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsaisinnyoutou zrnsaisinnyoutou}</td><td>（連携用）再診尿糖</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaisinnyoutanpaku zrnsaisinnyoutanpaku}</td><td>（連携用）再診尿蛋白</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaisinnyousenketu zrnsaisinnyousenketu}</td><td>（連携用）再診尿潜血</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaisinsaikouketuatu zrnsaisinsaikouketuatu}</td><td>（連携用）再診最高血圧</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsaisinsaiteiketuatu zrnsaisinsaiteiketuatu}</td><td>（連携用）再診最低血圧</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnketuekikensaijyou1 zrnketuekikensaijyou1}</td><td>（連携用）血液検査異常１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuekikensaijyou2 zrnketuekikensaijyou2}</td><td>（連携用）血液検査異常２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuekikensaijyou3 zrnketuekikensaijyou3}</td><td>（連携用）血液検査異常３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuekikensaijyou4 zrnketuekikensaijyou4}</td><td>（連携用）血液検査異常４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuekikensaijyou5 zrnketuekikensaijyou5}</td><td>（連携用）血液検査異常５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhukasyukeiyakukigou zrnhukasyukeiyakukigou}</td><td>（連携用）付加主契約記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsekininkaisiymd zrnsekininkaisiymd}</td><td>（連携用）責任開始年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyosinmyakuhakusuu zrnsyosinmyakuhakusuu}</td><td>（連携用）初診脈拍数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsyosinhuseimyakusuu zrnsyosinhuseimyakusuu}</td><td>（連携用）初診不整脈数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsaisinmyakuhakusuu zrnsaisinmyakuhakusuu}</td><td>（連携用）再診脈拍数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsaisinhuseimyakusuu zrnsaisinhuseimyakusuu}</td><td>（連携用）再診不整脈数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin2x2 zrnsuuriyouyobin2x2}</td><td>（連携用）数理用予備項目Ｎ２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsouhyouten zrnsouhyouten}</td><td>（連携用）総標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrntoukeiyukykymd zrntoukeiyukykymd}</td><td>（連携用）統計用契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhiketteiriyuucdx1 zrndakuhiketteiriyuucdx1}</td><td>（連携用）諾否決定理由コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhiketteiriyuucdx2 zrndakuhiketteiriyuucdx2}</td><td>（連携用）諾否決定理由コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhiketteiriyuucdx3 zrndakuhiketteiriyuucdx3}</td><td>（連携用）諾否決定理由コード＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhiketteiriyuucdx4 zrndakuhiketteiriyuucdx4}</td><td>（連携用）諾否決定理由コード＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanwamaeryouzouhyouten zrnkanwamaeryouzouhyouten}</td><td>（連携用）緩和前料増標点</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnryoumasitokujyoukanwahyj zrnryoumasitokujyoukanwahyj}</td><td>（連携用）料増特条緩和表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnptokujyoukanwahyj zrnhtnptokujyoukanwahyj}</td><td>（連携用）不担保特条緩和表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruikigousedaikbn zrnhknsyuruikigousedaikbn}</td><td>（連携用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruteikigousedaikbn zrnmaruteikigousedaikbn}</td><td>（連携用）マル定記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseizonmrtikgusdkbn zrnseizonmrtikgusdkbn}</td><td>（連携用）生存マル定記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigenmrtikgusdkbn zrnteigenmrtikgusdkbn}</td><td>（連携用）逓減マル定記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuunyuumrtikgusdkbn zrnsyuunyuumrtikgusdkbn}</td><td>（連携用）収入マル定記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv4 zrnyobiv4}</td><td>（連携用）予備項目Ｖ４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhksykykkgusdkbn zrnhksykykkgusdkbn}</td><td>（連携用）付加主契約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknsynensyuukbn zrnhhknsynensyuukbn}</td><td>（連携用）被保険者年収区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmentokuyakukbn zrnpmentokuyakukbn}</td><td>（連携用）Ｐ免特約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmennenkansanp zrnpmennenkansanp}</td><td>（連携用）Ｐ免年換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyobiv1x9 zrnyobiv1x9}</td><td>（連携用）予備項目Ｖ１＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyosinsouchol zrnsyosinsouchol}</td><td>（連携用）初診総コレステロール</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyosinhdlchol zrnsyosinhdlchol}</td><td>（連携用）初診ＨＤＬコレステロール</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyosintyuuseisibou zrnsyosintyuuseisibou}</td><td>（連携用）初診中性脂肪</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsysnsyumisyatkikettouti zrnsysnsyumisyatkikettouti}</td><td>（連携用）初診証明書扱血糖値</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyosintoukahemogurobin zrnsyosintoukahemogurobin}</td><td>（連携用）初診糖化ヘモグロビン</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsyosinnyousan zrnsyosinnyousan}</td><td>（連携用）初診尿酸</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsyosinkureatinin zrnsyosinkureatinin}</td><td>（連携用）初診クレアチニン</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnbosyuukeirokbn zrnbosyuukeirokbn}</td><td>（連携用）募集経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsudirtnatkikeitaikbn zrnbsudirtnatkikeitaikbn}</td><td>（連携用）募集代理店扱形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigkyhsitihsyutkykarihyj zrnkigkyhsitihsyutkykarihyj}</td><td>（連携用）介護給付最低保証特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmenhutanpobui1 zrnpmenhutanpobui1}</td><td>（連携用）Ｐ免不担保部位１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmenhutanpokikan1 zrnpmenhutanpokikan1}</td><td>（連携用）Ｐ免不担保期間１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmenhutanpobui2 zrnpmenhutanpobui2}</td><td>（連携用）Ｐ免不担保部位２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmenhutanpokikan2 zrnpmenhutanpokikan2}</td><td>（連携用）Ｐ免不担保期間２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanyujidatakanrino zrnkanyujidatakanrino}</td><td>（連携用）加入時データ管理番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbnktgsnzkkykdatakanrino zrnbnktgsnzkkykdatakanrino}</td><td>（連携用）分割後存続契約データ管理番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykjiqpackhyj zrnkykjiqpackhyj}</td><td>（連携用）契約時Ｑパック表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x1 zrnhokensyuruikigouyobi1x1}</td><td>（連携用）保険種類記号予備１＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x2 zrnhokensyuruikigouyobi1x2}</td><td>（連携用）保険種類記号予備１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x3 zrnhokensyuruikigouyobi1x3}</td><td>（連携用）保険種類記号予備１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x4 zrnhokensyuruikigouyobi1x4}</td><td>（連携用）保険種類記号予備１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x5 zrnhokensyuruikigouyobi1x5}</td><td>（連携用）保険種類記号予備１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x6 zrnhokensyuruikigouyobi1x6}</td><td>（連携用）保険種類記号予備１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x7 zrnhokensyuruikigouyobi1x7}</td><td>（連携用）保険種類記号予備１＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x8 zrnhokensyuruikigouyobi1x8}</td><td>（連携用）保険種類記号予備１＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x9 zrnhokensyuruikigouyobi1x9}</td><td>（連携用）保険種類記号予備１＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x10 zrnhokensyuruikigouyobi1x10}</td><td>（連携用）保険種類記号予備１＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x11 zrnhokensyuruikigouyobi1x11}</td><td>（連携用）保険種類記号予備１＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x12 zrnhokensyuruikigouyobi1x12}</td><td>（連携用）保険種類記号予備１＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x13 zrnhokensyuruikigouyobi1x13}</td><td>（連携用）保険種類記号予備１＿１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x14 zrnhokensyuruikigouyobi1x14}</td><td>（連携用）保険種類記号予備１＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x15 zrnhokensyuruikigouyobi1x15}</td><td>（連携用）保険種類記号予備１＿１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x1 zrnhokensyuruikigouyobi2x1}</td><td>（連携用）保険種類記号予備２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x2 zrnhokensyuruikigouyobi2x2}</td><td>（連携用）保険種類記号予備２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x3 zrnhokensyuruikigouyobi2x3}</td><td>（連携用）保険種類記号予備２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x4 zrnhokensyuruikigouyobi2x4}</td><td>（連携用）保険種類記号予備２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x5 zrnhokensyuruikigouyobi2x5}</td><td>（連携用）保険種類記号予備２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x6 zrnhokensyuruikigouyobi2x6}</td><td>（連携用）保険種類記号予備２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x7 zrnhokensyuruikigouyobi2x7}</td><td>（連携用）保険種類記号予備２＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x8 zrnhokensyuruikigouyobi2x8}</td><td>（連携用）保険種類記号予備２＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x9 zrnhokensyuruikigouyobi2x9}</td><td>（連携用）保険種類記号予備２＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x10 zrnhokensyuruikigouyobi2x10}</td><td>（連携用）保険種類記号予備２＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x1 zrnhokensyuruikigouyobi3x1}</td><td>（連携用）保険種類記号予備３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x2 zrnhokensyuruikigouyobi3x2}</td><td>（連携用）保険種類記号予備３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x3 zrnhokensyuruikigouyobi3x3}</td><td>（連携用）保険種類記号予備３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x4 zrnhokensyuruikigouyobi3x4}</td><td>（連携用）保険種類記号予備３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x5 zrnhokensyuruikigouyobi3x5}</td><td>（連携用）保険種類記号予備３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x6 zrnhokensyuruikigouyobi3x6}</td><td>（連携用）保険種類記号予備３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x7 zrnhokensyuruikigouyobi3x7}</td><td>（連携用）保険種類記号予備３＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x8 zrnhokensyuruikigouyobi3x8}</td><td>（連携用）保険種類記号予備３＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x9 zrnhokensyuruikigouyobi3x9}</td><td>（連携用）保険種類記号予備３＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x10 zrnhokensyuruikigouyobi3x10}</td><td>（連携用）保険種類記号予備３＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukigouyobix1 zrntokuyakukigouyobix1}</td><td>（連携用）特約記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukigouyobix2 zrntokuyakukigouyobix2}</td><td>（連携用）特約記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukigouyobix3 zrntokuyakukigouyobix3}</td><td>（連携用）特約記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukigouyobix4 zrntokuyakukigouyobix4}</td><td>（連携用）特約記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakukigouyobix5 zrntokuyakukigouyobix5}</td><td>（連携用）特約記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruteikigouyobix1 zrnmaruteikigouyobix1}</td><td>（連携用）マル定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruteikigouyobix2 zrnmaruteikigouyobix2}</td><td>（連携用）マル定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruteikigouyobix3 zrnmaruteikigouyobix3}</td><td>（連携用）マル定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruteikigouyobix4 zrnmaruteikigouyobix4}</td><td>（連携用）マル定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruteikigouyobix5 zrnmaruteikigouyobix5}</td><td>（連携用）マル定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiznmrtikguybx1 zrnsiznmrtikguybx1}</td><td>（連携用）生存マル定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiznmrtikguybx2 zrnsiznmrtikguybx2}</td><td>（連携用）生存マル定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiznmrtikguybx3 zrnsiznmrtikguybx3}</td><td>（連携用）生存マル定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiznmrtikguybx4 zrnsiznmrtikguybx4}</td><td>（連携用）生存マル定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiznmrtikguybx5 zrnsiznmrtikguybx5}</td><td>（連携用）生存マル定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigenmaruteikigouyobix1 zrnteigenmaruteikigouyobix1}</td><td>（連携用）逓減マル定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigenmaruteikigouyobix2 zrnteigenmaruteikigouyobix2}</td><td>（連携用）逓減マル定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigenmaruteikigouyobix3 zrnteigenmaruteikigouyobix3}</td><td>（連携用）逓減マル定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigenmaruteikigouyobix4 zrnteigenmaruteikigouyobix4}</td><td>（連携用）逓減マル定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigenmaruteikigouyobix5 zrnteigenmaruteikigouyobix5}</td><td>（連携用）逓減マル定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuunyuumrtikguybx1 zrnsyuunyuumrtikguybx1}</td><td>（連携用）収入マル定記号予備＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuunyuumrtikguybx2 zrnsyuunyuumrtikguybx2}</td><td>（連携用）収入マル定記号予備＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuunyuumrtikguybx3 zrnsyuunyuumrtikguybx3}</td><td>（連携用）収入マル定記号予備＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuunyuumrtikguybx4 zrnsyuunyuumrtikguybx4}</td><td>（連携用）収入マル定記号予備＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuunyuumrtikguybx5 zrnsyuunyuumrtikguybx5}</td><td>（連携用）収入マル定記号予備＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin5 zrnsuuriyouyobin5}</td><td>（連携用）数理用予備項目Ｎ５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin5x2 zrnsuuriyouyobin5x2}</td><td>（連携用）数理用予備項目Ｎ５＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin5x3 zrnsuuriyouyobin5x3}</td><td>（連携用）数理用予備項目Ｎ５＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin5x4 zrnsuuriyouyobin5x4}</td><td>（連携用）数理用予備項目Ｎ５＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin5x5 zrnsuuriyouyobin5x5}</td><td>（連携用）数理用予備項目Ｎ５＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2x9 zrnyobiv2x9}</td><td>（連携用）予備項目Ｖ２＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobin3x5 zrnyobin3x5}</td><td>（連携用）予備項目Ｎ３＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin1x7 zrnsuuriyouyobin1x7}</td><td>（連携用）数理用予備項目Ｎ１＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1x11 zrnyobiv1x11}</td><td>（連携用）予備項目Ｖ１＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin5x6 zrnsuuriyouyobin5x6}</td><td>（連携用）数理用予備項目Ｎ５＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhikettikjynsyrikbnx1 zrndakuhikettikjynsyrikbnx1}</td><td>（連携用）諾否決定基準種類区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhikettikjynsyrikbnx2 zrndakuhikettikjynsyrikbnx2}</td><td>（連携用）諾否決定基準種類区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhikettikjynsyrikbnx3 zrndakuhikettikjynsyrikbnx3}</td><td>（連携用）諾否決定基準種類区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhikettikjynsyrikbnx4 zrndakuhikettikjynsyrikbnx4}</td><td>（連携用）諾否決定基準種類区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhikettikjynsyrikbnx5 zrndakuhikettikjynsyrikbnx5}</td><td>（連携用）諾否決定基準種類区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykdatakanrinox1 zrnhtnknkykdatakanrinox1}</td><td>（連携用）被転換契約データ管理番号＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykdatakanrinox2 zrnhtnknkykdatakanrinox2}</td><td>（連携用）被転換契約データ管理番号＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykdatakanrinox3 zrnhtnknkykdatakanrinox3}</td><td>（連携用）被転換契約データ管理番号＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykdatakanrinox4 zrnhtnknkykdatakanrinox4}</td><td>（連携用）被転換契約データ管理番号＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykdatakanrinox5 zrnhtnknkykdatakanrinox5}</td><td>（連携用）被転換契約データ管理番号＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykdatakanrinox6 zrnhtnknkykdatakanrinox6}</td><td>（連携用）被転換契約データ管理番号＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakusyahoujinkbn zrnkeiyakusyahoujinkbn}</td><td>（連携用）契約者法人区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin2x3 zrnsuuriyouyobin2x3}</td><td>（連携用）数理用予備項目Ｎ２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyujynkttidkhkttikekkacd zrnhyujynkttidkhkttikekkacd}</td><td>（連携用）標準決定諾否決定結果コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyujynkttidkhkttiryucdx1 zrnhyujynkttidkhkttiryucdx1}</td><td>（連携用）標準決定諾否決定理由コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyujynkttidkhkttiryucdx2 zrnhyujynkttidkhkttiryucdx2}</td><td>（連携用）標準決定諾否決定理由コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyujynkttidkhkttiryucdx3 zrnhyujynkttidkhkttiryucdx3}</td><td>（連携用）標準決定諾否決定理由コード＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyujynkttidkhkttiryucdx4 zrnhyujynkttidkhkttiryucdx4}</td><td>（連携用）標準決定諾否決定理由コード＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyujynkttiryumshyutn zrnhyujynkttiryumshyutn}</td><td>（連携用）標準決定料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnhyujynkttisakugenkkn zrnhyujynkttisakugenkkn}</td><td>（連携用）標準決定削減期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsppitkykryumshyutn zrnsppitkykryumshyutn}</td><td>（連携用）疾病特約料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnhyujynkttitktbuicdx1 zrnhyujynkttitktbuicdx1}</td><td>（連携用）標準決定特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyujynkttihutanpokknx1 zrnhyujynkttihutanpokknx1}</td><td>（連携用）標準決定不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyujynkttitktbuicdx2 zrnhyujynkttitktbuicdx2}</td><td>（連携用）標準決定特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyujynkttihutanpokknx2 zrnhyujynkttihutanpokknx2}</td><td>（連携用）標準決定不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyoukentukitaisyoukbnx1 zrnjyoukentukitaisyoukbnx1}</td><td>（連携用）条件付対象区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyukntksseigenhyjx1 zrnjyukntksseigenhyjx1}</td><td>（連携用）条件付Ｓ制限表示＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyukntktkyknozokihyjx1 zrnjyukntktkyknozokihyjx1}</td><td>（連携用）条件付特約除き表示＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin1x8 zrnsuuriyouyobin1x8}</td><td>（連携用）数理用予備項目Ｎ１＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyoukentukiseigensx1 zrnjyoukentukiseigensx1}</td><td>（連携用）条件付制限Ｓ＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnjyoukentukitaisyoukbnx2 zrnjyoukentukitaisyoukbnx2}</td><td>（連携用）条件付対象区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyukntksseigenhyjx2 zrnjyukntksseigenhyjx2}</td><td>（連携用）条件付Ｓ制限表示＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyukntktkyknozokihyjx2 zrnjyukntktkyknozokihyjx2}</td><td>（連携用）条件付特約除き表示＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin1x9 zrnsuuriyouyobin1x9}</td><td>（連携用）数理用予備項目Ｎ１＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyoukentukiseigensx2 zrnjyoukentukiseigensx2}</td><td>（連携用）条件付制限Ｓ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnjyoukentukitaisyoukbnx3 zrnjyoukentukitaisyoukbnx3}</td><td>（連携用）条件付対象区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyukntksseigenhyjx3 zrnjyukntksseigenhyjx3}</td><td>（連携用）条件付Ｓ制限表示＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyukntktkyknozokihyjx3 zrnjyukntktkyknozokihyjx3}</td><td>（連携用）条件付特約除き表示＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin1x10 zrnsuuriyouyobin1x10}</td><td>（連携用）数理用予備項目Ｎ１＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyoukentukiseigensx3 zrnjyoukentukiseigensx3}</td><td>（連携用）条件付制限Ｓ＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnjyoukentukitaisyoukbnx4 zrnjyoukentukitaisyoukbnx4}</td><td>（連携用）条件付対象区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyukntksseigenhyjx4 zrnjyukntksseigenhyjx4}</td><td>（連携用）条件付Ｓ制限表示＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyukntktkyknozokihyjx4 zrnjyukntktkyknozokihyjx4}</td><td>（連携用）条件付特約除き表示＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin1x11 zrnsuuriyouyobin1x11}</td><td>（連携用）数理用予備項目Ｎ１＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyoukentukiseigensx4 zrnjyoukentukiseigensx4}</td><td>（連携用）条件付制限Ｓ＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnjyukntkkigtiksyrihnkuhyj zrnjyukntkkigtiksyrihnkuhyj}</td><td>（連携用）条件付介護定期種類変更表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmensyuruihenkoukbn zrnpmensyuruihenkoukbn}</td><td>（連携用）Ｐ免種類変更区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyoukentukitaisyoukbn2x1 zrnjyoukentukitaisyoukbn2x1}</td><td>（連携用）条件付対象区分２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyukntksseigenhyj2x1 zrnjyukntksseigenhyj2x1}</td><td>（連携用）条件付Ｓ制限表示２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyukntktkyknozokihyj2x1 zrnjyukntktkyknozokihyj2x1}</td><td>（連携用）条件付特約除き表示２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin1x12 zrnsuuriyouyobin1x12}</td><td>（連携用）数理用予備項目Ｎ１＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyoukentukiseigens2x1 zrnjyoukentukiseigens2x1}</td><td>（連携用）条件付制限Ｓ２＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnjyoukentukitaisyoukbn2x2 zrnjyoukentukitaisyoukbn2x2}</td><td>（連携用）条件付対象区分２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyukntksseigenhyj2x2 zrnjyukntksseigenhyj2x2}</td><td>（連携用）条件付Ｓ制限表示２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyukntktkyknozokihyj2x2 zrnjyukntktkyknozokihyj2x2}</td><td>（連携用）条件付特約除き表示２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin1x13 zrnsuuriyouyobin1x13}</td><td>（連携用）数理用予備項目Ｎ１＿１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyoukentukiseigens2x2 zrnjyoukentukiseigens2x2}</td><td>（連携用）条件付制限Ｓ２＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnjyoukentukitaisyoukbn2x3 zrnjyoukentukitaisyoukbn2x3}</td><td>（連携用）条件付対象区分２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyukntksseigenhyj2x3 zrnjyukntksseigenhyj2x3}</td><td>（連携用）条件付Ｓ制限表示２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyukntktkyknozokihyj2x3 zrnjyukntktkyknozokihyj2x3}</td><td>（連携用）条件付特約除き表示２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin1x14 zrnsuuriyouyobin1x14}</td><td>（連携用）数理用予備項目Ｎ１＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyoukentukiseigens2x3 zrnjyoukentukiseigens2x3}</td><td>（連携用）条件付制限Ｓ２＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnjyoukentukitaisyoukbn2x4 zrnjyoukentukitaisyoukbn2x4}</td><td>（連携用）条件付対象区分２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyukntksseigenhyj2x4 zrnjyukntksseigenhyj2x4}</td><td>（連携用）条件付Ｓ制限表示２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyukntktkyknozokihyj2x4 zrnjyukntktkyknozokihyj2x4}</td><td>（連携用）条件付特約除き表示２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin1x15 zrnsuuriyouyobin1x15}</td><td>（連携用）数理用予備項目Ｎ１＿１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyoukentukiseigens2x4 zrnjyoukentukiseigens2x4}</td><td>（連携用）条件付制限Ｓ２＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntktsppiryumshyutn zrntktsppiryumshyutn}</td><td>（連携用）特定疾病料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrntktsppiskgnkkn zrntktsppiskgnkkn}</td><td>（連携用）特定疾病削減期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmnsiskknryumshyutn zrnmnsiskknryumshyutn}</td><td>（連携用）慢性疾患料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnmanseisikkansakugenkikan zrnmanseisikkansakugenkikan}</td><td>（連携用）慢性疾患削減期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmanseisikkantokuteibuicd zrnmanseisikkantokuteibuicd}</td><td>（連携用）慢性疾患特定部位コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmanseisikkanhutanpokikan zrnmanseisikkanhutanpokikan}</td><td>（連携用）慢性疾患不担保期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaihokenkbn zrnsaihokenkbn}</td><td>（連携用）再保険区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnimustiyusbus zrnimustiyusbus}</td><td>（連携用）医務査定用死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnimusateiyoujissituhsyus zrnimusateiyoujissituhsyus}</td><td>（連携用）医務査定用実質保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnisahtnkngukijissituhsyus zrnisahtnkngukijissituhsyus}</td><td>（連携用）医査被転換合計実質保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnimusateiyoutenkansagakus zrnimusateiyoutenkansagakus}</td><td>（連携用）医務査定用転換差額Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnimusateiyouhanbaikirkbn zrnimusateiyouhanbaikirkbn}</td><td>（連携用）医務査定用販売経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnoyabosyuudairitencd zrnoyabosyuudairitencd}</td><td>（連携用）親募集代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyoubosyuukeitaikbn zrnsuuriyoubosyuukeitaikbn}</td><td>（連携用）数理用募集形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhihokensyahokenage zrnhihokensyahokenage}</td><td>（連携用）被保険者保険年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrendouyoumusntkkykhyj zrnrendouyoumusntkkykhyj}</td><td>（連携用）連動用無選択契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2x11 zrnyobiv2x11}</td><td>（連携用）予備項目Ｖ２＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobin3x6 zrnyobin3x6}</td><td>（連携用）予備項目Ｎ３＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin9x4 zrnsuuriyouyobin9x4}</td><td>（連携用）数理用予備項目Ｎ９＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1x20 zrnyobiv1x20}</td><td>（連携用）予備項目Ｖ１＿２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin5x7 zrnsuuriyouyobin5x7}</td><td>（連携用）数理用予備項目Ｎ５＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnentysihyj zrnhhknnentysihyj}</td><td>（連携用）被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsindenzusyokensyousaicd zrnsindenzusyokensyousaicd}</td><td>（連携用）心電図所見詳細コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnimstiyuktekknsjsshyj zrnimstiyuktekknsjsshyj}</td><td>（連携用）医務査定用血液検査実施表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuekikensasekkekkyuusu zrnketuekikensasekkekkyuusu}</td><td>（連携用）血液検査赤血球数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnktekknsskkkkyususykncd zrnktekknsskkkkyususykncd}</td><td>（連携用）血液検査赤血球数所見コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuekikensahakkekkyuusu zrnketuekikensahakkekkyuusu}</td><td>（連携用）血液検査白血球数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnktekknshkkkkyususykncd zrnktekknshkkkkyususykncd}</td><td>（連携用）血液検査白血球数所見コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnktekknsketusikisoryou zrnktekknsketusikisoryou}</td><td>（連携用）血液検査血色素量</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnktekknsktsksryusyokencd zrnktekknsktsksryusyokencd}</td><td>（連携用）血液検査血色素量所見コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnktekknshematokuritto zrnktekknshematokuritto}</td><td>（連携用）血液検査ヘマトクリット</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnktekhmtkrttsykncd zrnktekhmtkrttsykncd}</td><td>（連携用）血液ヘマトクリット所見コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuekikensakessyoubansu zrnketuekikensakessyoubansu}</td><td>（連携用）血液検査血小板数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnktekknskssyubnsusyokencd zrnktekknskssyubnsusyokencd}</td><td>（連携用）血液検査血小板数所見コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnktekknskssisutnpkryu zrnktekknskssisutnpkryu}</td><td>（連携用）血液検査血清総蛋白量</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnktekkssisutnpkryusykncd zrnktekkssisutnpkryusykncd}</td><td>（連携用）血液血清総蛋白量所見コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuekikensaarubumin zrnketuekikensaarubumin}</td><td>（連携用）血液検査アルブミン</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnktekknsarubuminsyokencd zrnktekknsarubuminsyokencd}</td><td>（連携用）血液検査アルブミン所見コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuekikensaztt zrnketuekikensaztt}</td><td>（連携用）血液検査ＺＴＴ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnketuekikensazttsyokencd zrnketuekikensazttsyokencd}</td><td>（連携用）血液検査ＺＴＴ所見コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuekikensagot zrnketuekikensagot}</td><td>（連携用）血液検査ＧＯＴ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuekikensagotsyokencd zrnketuekikensagotsyokencd}</td><td>（連携用）血液検査ＧＯＴ所見コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuekikensagpt zrnketuekikensagpt}</td><td>（連携用）血液検査ＧＰＴ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuekikensagptsyokencd zrnketuekikensagptsyokencd}</td><td>（連携用）血液検査ＧＰＴ所見コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuekikensaganmagtp zrnketuekikensaganmagtp}</td><td>（連携用）血液検査ガンマＧＴＰ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuekiganmagtpsyokencd zrnketuekiganmagtpsyokencd}</td><td>（連携用）血液ガンマＧＴＰ所見コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuekikensasouchol zrnketuekikensasouchol}</td><td>（連携用）血液検査総コレステロール</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuekicholsyokencd zrnketuekicholsyokencd}</td><td>（連携用）血液コレステロール所見コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuekikensahdlchol zrnketuekikensahdlchol}</td><td>（連携用）血液検査ＨＤＬコレステロール</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuekikensahdlsyokencd zrnketuekikensahdlsyokencd}</td><td>（連携用）血液検査ＨＤＬ所見コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnktekknstukhmgrbn zrnktekknstukhmgrbn}</td><td>（連携用）血液検査糖化ヘモグロビン</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnktekhmgrbnsykncd zrnktekhmgrbnsykncd}</td><td>（連携用）血液ヘモグロビン所見コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnktekknskorinesuterrze zrnktekknskorinesuterrze}</td><td>（連携用）血液検査コリンエステラーゼ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkorinesuterrzesyokencd zrnkorinesuterrzesyokencd}</td><td>（連携用）コリンエステラーゼ所見コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuekikensamcv zrnketuekikensamcv}</td><td>（連携用）血液検査ＭＣＶ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnketuekikensamcvsyokencd zrnketuekikensamcvsyokencd}</td><td>（連携用）血液検査ＭＣＶ所見コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuekikensamch zrnketuekikensamch}</td><td>（連携用）血液検査ＭＣＨ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnketuekikensamchsyokencd zrnketuekikensamchsyokencd}</td><td>（連携用）血液検査ＭＣＨ所見コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuekikensamchc zrnketuekikensamchc}</td><td>（連携用）血液検査ＭＣＨＣ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnketuekikensamchcsyokencd zrnketuekikensamchcsyokencd}</td><td>（連携用）血液検査ＭＣＨＣ所見コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuekikensacea zrnketuekikensacea}</td><td>（連携用）血液検査ＣＥＡ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnketuekikensaceasyokencd zrnketuekikensaceasyokencd}</td><td>（連携用）血液検査ＣＥＡ所見コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuekikensaafp zrnketuekikensaafp}</td><td>（連携用）血液検査ＡＦＰ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnketuekikensaafpsyokencd zrnketuekikensaafpsyokencd}</td><td>（連携用）血液検査ＡＦＰ所見コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuekikensahbskbn zrnketuekikensahbskbn}</td><td>（連携用）血液検査ＨＢＳ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuekikensahbssyokencd zrnketuekikensahbssyokencd}</td><td>（連携用）血液検査ＨＢＳ所見コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuekikensahcvkbn zrnketuekikensahcvkbn}</td><td>（連携用）血液検査ＨＣＶ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketuekikensahcvsyokencd zrnketuekikensahcvsyokencd}</td><td>（連携用）血液検査ＨＣＶ所見コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnimusateiyouknsnsytryskbn zrnimusateiyouknsnsytryskbn}</td><td>（連携用）医務査定用健診書取寄区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyosinldlchol zrnsyosinldlchol}</td><td>（連携用）初診ＬＤＬコレステロール</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuteijyoutaihushrhyj zrntokuteijyoutaihushrhyj}</td><td>（連携用）特定状態不支払表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrendouyouosyukeiyakup zrnrendouyouosyukeiyakup}</td><td>（連携用）連動用主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrntokubetuhosyoukikan zrntokubetuhosyoukikan}</td><td>（連携用）特別保障期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrendouyougoukeitenkans zrnrendouyougoukeitenkans}</td><td>（連携用）連動用合計転換Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnrnduyugukitnknkakaku zrnrnduyugukitnknkakaku}</td><td>（連携用）連動用合計転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnrnduyuwnsgukitnknkakaku zrnrnduyuwnsgukitnknkakaku}</td><td>（連携用）連動用Ｗなし合計転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnmostnknkhnbbnjyuturt zrnmostnknkhnbbnjyuturt}</td><td>（連携用）申込転換基本部分充当率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnrnduyusykykbbnkhns zrnrnduyusykykbbnkhns}</td><td>（連携用）連動用主契約部分基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnrendouyouyoteiriritu zrnrendouyouyoteiriritu}</td><td>（連携用）連動用予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnknkuzusnzyrt zrnknkuzusnzyrt}</td><td>（連携用）健康増進乗率</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv121 zrnyobiv121}</td><td>（連携用）予備項目Ｖ１２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnraysystemhyj zrnraysystemhyj}</td><td>（連携用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngaikakbn zrngaikakbn}</td><td>（連携用）外貨区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngaikadatekihons zrngaikadatekihons}</td><td>（連携用）外貨建基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatesibous zrngaikadatesibous}</td><td>（連携用）外貨建死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkeiyakujiyoteiriritu zrnkeiyakujiyoteiriritu}</td><td>（連携用）契約時予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkawaserate zrnkawaserate}</td><td>（連携用）為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkawaseratetekiyouymd zrnkawaseratetekiyouymd}</td><td>（連携用）為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnenkdtsbujsitihsyukngk zrnenkdtsbujsitihsyukngk}</td><td>（連携用）円貨建死亡時最低保証金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsrdai1hknkkn zrnsrdai1hknkkn}</td><td>（連携用）数理用第１保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin8 zrnsuuriyouyobin8}</td><td>（連携用）数理用予備項目Ｎ８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin10x2 zrnsuuriyouyobin10x2}</td><td>（連携用）数理用予備項目Ｎ１０＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuukasyukbn zrntuukasyukbn}</td><td>（連携用）通貨種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv9 zrnyobiv9}</td><td>（連携用）予備項目Ｖ９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10x4 zrnyobiv10x4}</td><td>（連携用）予備項目Ｖ１０＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobin7 zrnyobin7}</td><td>（連携用）予備項目Ｎ７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyobin7x2 zrnyobin7x2}</td><td>（連携用）予備項目Ｎ７＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyobin7x3 zrnyobin7x3}</td><td>（連携用）予備項目Ｎ７＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyobin7x4 zrnyobin7x4}</td><td>（連携用）予備項目Ｎ７＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyobin7x5 zrnyobin7x5}</td><td>（連携用）予備項目Ｎ７＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyobiv4x2 zrnyobiv4x2}</td><td>（連携用）予備項目Ｖ４＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SbRituRendouRn
 * @see     PKZT_SbRituRendouRn
 * @see     QZT_SbRituRendouRn
 * @see     GenQZT_SbRituRendouRn
 */
@MappedSuperclass
@Table(name=GenZT_SbRituRendouRn.TABLE_NAME)
@IdClass(value=PKZT_SbRituRendouRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_SbRituRendouRn extends AbstractExDBEntityForZDB<ZT_SbRituRendouRn, PKZT_SbRituRendouRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SbRituRendouRn";
    public static final String ZRNSEQUENCENO            = "zrnsequenceno";
    public static final String ZRNYOBIV12X7             = "zrnyobiv12x7";
    public static final String ZRNDATAKANRINO           = "zrndatakanrino";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNSAIMNKKYKHYJ          = "zrnsaimnkkykhyj";
    public static final String ZRNRENDOUYOUKIKAN        = "zrnrendouyoukikan";
    public static final String ZRNHIHOKENSYAAGEV2       = "zrnhihokensyaagev2";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNRENDOUYOUKEIYAKUNENGETU = "zrnrendouyoukeiyakunengetu";
    public static final String ZRNRENDOUYOUKIHONS       = "zrnrendouyoukihons";
    public static final String ZRNRENDOUYOUSIBOUS       = "zrnrendouyousibous";
    public static final String ZRNTNKNITJBRIGISBUS      = "zrntnknitjbrigisbus";
    public static final String ZRNTENKANMINAOSIKBN      = "zrntenkanminaosikbn";
    public static final String ZRNRENDOUYOUHRKHOUHOUKBN = "zrnrendouyouhrkhouhoukbn";
    public static final String ZRNRENDOUYOUJYUUSYOKBN   = "zrnrendouyoujyuusyokbn";
    public static final String ZRNAATUKAISOSIKICD       = "zrnaatukaisosikicd";
    public static final String ZRNRENDOUYOUSAKUGENKIKAN = "zrnrendouyousakugenkikan";
    public static final String ZRNRNDUYURYUMSHYUTN      = "zrnrnduyuryumshyutn";
    public static final String ZRNRENDOUYOUBOSYUUYM     = "zrnrendouyoubosyuuym";
    public static final String ZRNSUURIYOUYOBIN1        = "zrnsuuriyouyobin1";
    public static final String ZRNSYKGYCD               = "zrnsykgycd";
    public static final String ZRNDAKUHIKETTISYACD      = "zrndakuhikettisyacd";
    public static final String ZRNDAI2HIHOKENSYAHYOUJI  = "zrndai2hihokensyahyouji";
    public static final String ZRNRENSEIMUSNTKKNYUHYJ   = "zrnrenseimusntkknyuhyj";
    public static final String ZRNTOKUBETUMARUTEIARIHYJ = "zrntokubetumaruteiarihyj";
    public static final String ZRNDOUGAKUTENKANHYOUJI   = "zrndougakutenkanhyouji";
    public static final String ZRNTENKANSENTAKUHOUHOUKBN = "zrntenkansentakuhouhoukbn";
    public static final String ZRNTOKUBETUSENTAKUARIKBN = "zrntokubetusentakuarikbn";
    public static final String ZRNKETTEIKEKKAKBN        = "zrnketteikekkakbn";
    public static final String ZRNKEIYAKUKAKUNINSYURUIKBN = "zrnkeiyakukakuninsyuruikbn";
    public static final String ZRNKEIYAKUKAKUNINRIYUUKBN = "zrnkeiyakukakuninriyuukbn";
    public static final String ZRNRENDOUYOUKEKKANCDX1   = "zrnrendouyoukekkancdx1";
    public static final String ZRNKEIKANENSUUX1         = "zrnkeikanensuux1";
    public static final String ZRNSYUJYUTUARIHYOUJIX1   = "zrnsyujyutuarihyoujix1";
    public static final String ZRNRENDOUYOUKEKKANCDX2   = "zrnrendouyoukekkancdx2";
    public static final String ZRNKEIKANENSUUX2         = "zrnkeikanensuux2";
    public static final String ZRNSYUJYUTUARIHYOUJIX2   = "zrnsyujyutuarihyoujix2";
    public static final String ZRNSAIHOKENHYOUJI        = "zrnsaihokenhyouji";
    public static final String ZRNRNDUYUSYSNHUJYUSNSSYACD = "zrnrnduyusysnhujyusnssyacd";
    public static final String ZRNRNDYUSYSNHUJYUSNSHUHUKBN = "zrnrndyusysnhujyusnshuhukbn";
    public static final String ZRNSAISINRIYUUKBN        = "zrnsaisinriyuukbn";
    public static final String ZRNNYOUTOUSAISINARIHYOUJI = "zrnnyoutousaisinarihyouji";
    public static final String ZRNNYOUTANPAKUSAISINARIHYJ = "zrnnyoutanpakusaisinarihyj";
    public static final String ZRNHEMASAISINARIHYOUJI   = "zrnhemasaisinarihyouji";
    public static final String ZRNKETTOUSAISINARIHYOUJI = "zrnkettousaisinarihyouji";
    public static final String ZRNSINTYOUSAISINARIHYOUJI = "zrnsintyousaisinarihyouji";
    public static final String ZRNKYOUISAISINARIHYOUJI  = "zrnkyouisaisinarihyouji";
    public static final String ZRNHUKUISAISINARIHYOUJI  = "zrnhukuisaisinarihyouji";
    public static final String ZRNTAIJYUUSAISINARIHYOUJI = "zrntaijyuusaisinarihyouji";
    public static final String ZRNKETUATUSAISINARIHYOUJI = "zrnketuatusaisinarihyouji";
    public static final String ZRNRNDYUSISNHUJYUSNSSYACD = "zrnrndyusisnhujyusnssyacd";
    public static final String ZRNRNDYUSISNHUJYUSNSHUHUKBN = "zrnrndyusisnhujyusnshuhukbn";
    public static final String ZRNNYOUTOUKBN            = "zrnnyoutoukbn";
    public static final String ZRNYOBIV1X2              = "zrnyobiv1x2";
    public static final String ZRNNYOUTANPAKUKBN        = "zrnnyoutanpakukbn";
    public static final String ZRNHEMAKBN               = "zrnhemakbn";
    public static final String ZRNKETTOUTIKEIKAJIKAN    = "zrnkettoutikeikajikan";
    public static final String ZRNKETTOUTI              = "zrnkettouti";
    public static final String ZRNSINTYOU               = "zrnsintyou";
    public static final String ZRNKYOUI                 = "zrnkyoui";
    public static final String ZRNHUKUI                 = "zrnhukui";
    public static final String ZRNTAIJYUU               = "zrntaijyuu";
    public static final String ZRNSAIKOUKETUATU         = "zrnsaikouketuatu";
    public static final String ZRNSAITEIKETUATU         = "zrnsaiteiketuatu";
    public static final String ZRNXSENSYOKENCD          = "zrnxsensyokencd";
    public static final String ZRNSINDENZUSYOKENCD      = "zrnsindenzusyokencd";
    public static final String ZRNRNDUYUGANTEISYSNSYOKENCD = "zrnrnduyuganteisysnsyokencd";
    public static final String ZRNSINSAHOUHOUSIYOUKBN   = "zrnsinsahouhousiyoukbn";
    public static final String ZRNVIPTEIKIHYOUJI        = "zrnvipteikihyouji";
    public static final String ZRNHOUJYOUNOMIHYOUJI     = "zrnhoujyounomihyouji";
    public static final String ZRNKETUEKIKENSAJISSIKBN  = "zrnketuekikensajissikbn";
    public static final String ZRNMARUTEISYURUIKIGOU    = "zrnmaruteisyuruikigou";
    public static final String ZRNSEIZONMRTISYURUIKGU   = "zrnseizonmrtisyuruikgu";
    public static final String ZRNKETUSIKISORYOU        = "zrnketusikisoryou";
    public static final String ZRNGOT                   = "zrngot";
    public static final String ZRNGPT                   = "zrngpt";
    public static final String ZRNGANMAGTP              = "zrnganmagtp";
    public static final String ZRNSYUMISYATKISINDENZUKBN = "zrnsyumisyatkisindenzukbn";
    public static final String ZRNKITUENKBN             = "zrnkituenkbn";
    public static final String ZRNTIGNMRTISYUKGU        = "zrntignmrtisyukgu";
    public static final String ZRNTEIGENMARUTEIKIKAN    = "zrnteigenmaruteikikan";
    public static final String ZRNKITUENHONSUU          = "zrnkituenhonsuu";
    public static final String ZRNYOBIV2                = "zrnyobiv2";
    public static final String ZRNSUURIYOUYOBIN1X2      = "zrnsuuriyouyobin1x2";
    public static final String ZRNRNDUYUSPPINYUINTKYKNTGK = "zrnrnduyusppinyuintkykntgk";
    public static final String ZRNSUURIYOUYOBIN12       = "zrnsuuriyouyobin12";
    public static final String ZRNYOBIV2X2              = "zrnyobiv2x2";
    public static final String ZRNSUURIYOUYOBIN1X3      = "zrnsuuriyouyobin1x3";
    public static final String ZRNYOBIN3                = "zrnyobin3";
    public static final String ZRNSUURIYOUYOBIN12X2     = "zrnsuuriyouyobin12x2";
    public static final String ZRNGOUKEITEIGENTEIKITKYKS = "zrngoukeiteigenteikitkyks";
    public static final String ZRNTIGNTIKBBNTNKNITJBRS  = "zrntigntikbbntnknitjbrs";
    public static final String ZRNTOKUTEISIPPEISETKBN   = "zrntokuteisippeisetkbn";
    public static final String ZRNSUURIYOUYOBIN2        = "zrnsuuriyouyobin2";
    public static final String ZRNTAIKAKUKIJYUNKANWAHYOUJI = "zrntaikakukijyunkanwahyouji";
    public static final String ZRNHAITOUKBN             = "zrnhaitoukbn";
    public static final String ZRNSNSYKRKETKBTSNTKARIHYJ = "zrnsnsykrketkbtsntkarihyj";
    public static final String ZRNAATUKAIKOJINCD        = "zrnaatukaikojincd";
    public static final String ZRNYOBIV1X5              = "zrnyobiv1x5";
    public static final String ZRNMANSEISIKKANSETKBN    = "zrnmanseisikkansetkbn";
    public static final String ZRNGENGAKUTENKANKYKHYJ   = "zrngengakutenkankykhyj";
    public static final String ZRNYOBIV2X4              = "zrnyobiv2x4";
    public static final String ZRNFILEKBN               = "zrnfilekbn";
    public static final String ZRNYOBIV2X5              = "zrnyobiv2x5";
    public static final String ZRNSUURIYOUYOBIN1X4      = "zrnsuuriyouyobin1x4";
    public static final String ZRNYOBIN3X2              = "zrnyobin3x2";
    public static final String ZRNSUURIYOUYOBIN12X3     = "zrnsuuriyouyobin12x3";
    public static final String ZRNYOBIV2X6              = "zrnyobiv2x6";
    public static final String ZRNSUURIYOUYOBIN1X5      = "zrnsuuriyouyobin1x5";
    public static final String ZRNYOBIN3X3              = "zrnyobin3x3";
    public static final String ZRNSUURIYOUYOBIN12X4     = "zrnsuuriyouyobin12x4";
    public static final String ZRNYOBIV2X7              = "zrnyobiv2x7";
    public static final String ZRNSUURIYOUYOBIN1X6      = "zrnsuuriyouyobin1x6";
    public static final String ZRNYOBIN3X4              = "zrnyobin3x4";
    public static final String ZRNSUURIYOUYOBIN12X5     = "zrnsuuriyouyobin12x5";
    public static final String ZRNTAIKAKUHYOUTEN        = "zrntaikakuhyouten";
    public static final String ZRNNYOUTOUSYKYKHYUTN     = "zrnnyoutousykykhyutn";
    public static final String ZRNNYOUTANPAKUSYKYKHYUTN = "zrnnyoutanpakusykykhyutn";
    public static final String ZRNKETUATUTANDOKUHYOUTEN = "zrnketuatutandokuhyouten";
    public static final String ZRNYOBIN5                = "zrnyobin5";
    public static final String ZRNSUURIYOUYOBIN9        = "zrnsuuriyouyobin9";
    public static final String ZRNYOBIN5X2              = "zrnyobin5x2";
    public static final String ZRNSUURIYOUYOBIN9X2      = "zrnsuuriyouyobin9x2";
    public static final String ZRNYOBIN5X3              = "zrnyobin5x3";
    public static final String ZRNSUURIYOUYOBIN9X3      = "zrnsuuriyouyobin9x3";
    public static final String ZRNSYUNYUMRTISYUKGU      = "zrnsyunyumrtisyukgu";
    public static final String ZRNSYUUNYUUMARUTEIKIKAN  = "zrnsyuunyuumaruteikikan";
    public static final String ZRNSYUUNYUUMRTINKNENGKN5 = "zrnsyuunyuumrtinknengkn5";
    public static final String ZRNSYUUNYUUMRTINKSHRKKN  = "zrnsyuunyuumrtinkshrkkn";
    public static final String ZRNSUURIYOUYOBIN12X6     = "zrnsuuriyouyobin12x6";
    public static final String ZRNHUTANPOBUI1           = "zrnhutanpobui1";
    public static final String ZRNHTNPKKN1              = "zrnhtnpkkn1";
    public static final String ZRNHUTANPOBUI2           = "zrnhutanpobui2";
    public static final String ZRNHTNPKKN2              = "zrnhtnpkkn2";
    public static final String ZRNSYOSINNYOUTOU         = "zrnsyosinnyoutou";
    public static final String ZRNSYOSINNYOUTANPAKU     = "zrnsyosinnyoutanpaku";
    public static final String ZRNSYOSINNYOUSENKETU     = "zrnsyosinnyousenketu";
    public static final String ZRNSYOSINSAIKOUKETUATU   = "zrnsyosinsaikouketuatu";
    public static final String ZRNSYOSINSAITEIKETUATU   = "zrnsyosinsaiteiketuatu";
    public static final String ZRNSAISINNYOUTOU         = "zrnsaisinnyoutou";
    public static final String ZRNSAISINNYOUTANPAKU     = "zrnsaisinnyoutanpaku";
    public static final String ZRNSAISINNYOUSENKETU     = "zrnsaisinnyousenketu";
    public static final String ZRNSAISINSAIKOUKETUATU   = "zrnsaisinsaikouketuatu";
    public static final String ZRNSAISINSAITEIKETUATU   = "zrnsaisinsaiteiketuatu";
    public static final String ZRNKETUEKIKENSAIJYOU1    = "zrnketuekikensaijyou1";
    public static final String ZRNKETUEKIKENSAIJYOU2    = "zrnketuekikensaijyou2";
    public static final String ZRNKETUEKIKENSAIJYOU3    = "zrnketuekikensaijyou3";
    public static final String ZRNKETUEKIKENSAIJYOU4    = "zrnketuekikensaijyou4";
    public static final String ZRNKETUEKIKENSAIJYOU5    = "zrnketuekikensaijyou5";
    public static final String ZRNHUKASYUKEIYAKUKIGOU   = "zrnhukasyukeiyakukigou";
    public static final String ZRNSEKININKAISIYMD       = "zrnsekininkaisiymd";
    public static final String ZRNSYOSINMYAKUHAKUSUU    = "zrnsyosinmyakuhakusuu";
    public static final String ZRNSYOSINHUSEIMYAKUSUU   = "zrnsyosinhuseimyakusuu";
    public static final String ZRNSAISINMYAKUHAKUSUU    = "zrnsaisinmyakuhakusuu";
    public static final String ZRNSAISINHUSEIMYAKUSUU   = "zrnsaisinhuseimyakusuu";
    public static final String ZRNSUURIYOUYOBIN2X2      = "zrnsuuriyouyobin2x2";
    public static final String ZRNSOUHYOUTEN            = "zrnsouhyouten";
    public static final String ZRNTOUKEIYUKYKYMD        = "zrntoukeiyukykymd";
    public static final String ZRNDAKUHIKETTEIRIYUUCDX1 = "zrndakuhiketteiriyuucdx1";
    public static final String ZRNDAKUHIKETTEIRIYUUCDX2 = "zrndakuhiketteiriyuucdx2";
    public static final String ZRNDAKUHIKETTEIRIYUUCDX3 = "zrndakuhiketteiriyuucdx3";
    public static final String ZRNDAKUHIKETTEIRIYUUCDX4 = "zrndakuhiketteiriyuucdx4";
    public static final String ZRNKANWAMAERYOUZOUHYOUTEN = "zrnkanwamaeryouzouhyouten";
    public static final String ZRNRYOUMASITOKUJYOUKANWAHYJ = "zrnryoumasitokujyoukanwahyj";
    public static final String ZRNHTNPTOKUJYOUKANWAHYJ  = "zrnhtnptokujyoukanwahyj";
    public static final String ZRNHKNSYURUIKIGOUSEDAIKBN = "zrnhknsyuruikigousedaikbn";
    public static final String ZRNMARUTEIKIGOUSEDAIKBN  = "zrnmaruteikigousedaikbn";
    public static final String ZRNSEIZONMRTIKGUSDKBN    = "zrnseizonmrtikgusdkbn";
    public static final String ZRNTEIGENMRTIKGUSDKBN    = "zrnteigenmrtikgusdkbn";
    public static final String ZRNSYUUNYUUMRTIKGUSDKBN  = "zrnsyuunyuumrtikgusdkbn";
    public static final String ZRNYOBIV4                = "zrnyobiv4";
    public static final String ZRNHKSYKYKKGUSDKBN       = "zrnhksykykkgusdkbn";
    public static final String ZRNHHKNSYNENSYUUKBN      = "zrnhhknsynensyuukbn";
    public static final String ZRNPMENTOKUYAKUKBN       = "zrnpmentokuyakukbn";
    public static final String ZRNPMENNENKANSANP        = "zrnpmennenkansanp";
    public static final String ZRNYOBIV1X9              = "zrnyobiv1x9";
    public static final String ZRNSYOSINSOUCHOL         = "zrnsyosinsouchol";
    public static final String ZRNSYOSINHDLCHOL         = "zrnsyosinhdlchol";
    public static final String ZRNSYOSINTYUUSEISIBOU    = "zrnsyosintyuuseisibou";
    public static final String ZRNSYSNSYUMISYATKIKETTOUTI = "zrnsysnsyumisyatkikettouti";
    public static final String ZRNSYOSINTOUKAHEMOGUROBIN = "zrnsyosintoukahemogurobin";
    public static final String ZRNSYOSINNYOUSAN         = "zrnsyosinnyousan";
    public static final String ZRNSYOSINKUREATININ      = "zrnsyosinkureatinin";
    public static final String ZRNBOSYUUKEIROKBN        = "zrnbosyuukeirokbn";
    public static final String ZRNBSUDIRTNATKIKEITAIKBN = "zrnbsudirtnatkikeitaikbn";
    public static final String ZRNKIGKYHSITIHSYUTKYKARIHYJ = "zrnkigkyhsitihsyutkykarihyj";
    public static final String ZRNPMENHUTANPOBUI1       = "zrnpmenhutanpobui1";
    public static final String ZRNPMENHUTANPOKIKAN1     = "zrnpmenhutanpokikan1";
    public static final String ZRNPMENHUTANPOBUI2       = "zrnpmenhutanpobui2";
    public static final String ZRNPMENHUTANPOKIKAN2     = "zrnpmenhutanpokikan2";
    public static final String ZRNKANYUJIDATAKANRINO    = "zrnkanyujidatakanrino";
    public static final String ZRNBNKTGSNZKKYKDATAKANRINO = "zrnbnktgsnzkkykdatakanrino";
    public static final String ZRNKYKJIQPACKHYJ         = "zrnkykjiqpackhyj";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X1 = "zrnhokensyuruikigouyobi1x1";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X2 = "zrnhokensyuruikigouyobi1x2";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X3 = "zrnhokensyuruikigouyobi1x3";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X4 = "zrnhokensyuruikigouyobi1x4";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X5 = "zrnhokensyuruikigouyobi1x5";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X6 = "zrnhokensyuruikigouyobi1x6";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X7 = "zrnhokensyuruikigouyobi1x7";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X8 = "zrnhokensyuruikigouyobi1x8";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X9 = "zrnhokensyuruikigouyobi1x9";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X10 = "zrnhokensyuruikigouyobi1x10";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X11 = "zrnhokensyuruikigouyobi1x11";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X12 = "zrnhokensyuruikigouyobi1x12";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X13 = "zrnhokensyuruikigouyobi1x13";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X14 = "zrnhokensyuruikigouyobi1x14";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X15 = "zrnhokensyuruikigouyobi1x15";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X1 = "zrnhokensyuruikigouyobi2x1";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X2 = "zrnhokensyuruikigouyobi2x2";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X3 = "zrnhokensyuruikigouyobi2x3";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X4 = "zrnhokensyuruikigouyobi2x4";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X5 = "zrnhokensyuruikigouyobi2x5";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X6 = "zrnhokensyuruikigouyobi2x6";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X7 = "zrnhokensyuruikigouyobi2x7";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X8 = "zrnhokensyuruikigouyobi2x8";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X9 = "zrnhokensyuruikigouyobi2x9";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X10 = "zrnhokensyuruikigouyobi2x10";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X1 = "zrnhokensyuruikigouyobi3x1";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X2 = "zrnhokensyuruikigouyobi3x2";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X3 = "zrnhokensyuruikigouyobi3x3";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X4 = "zrnhokensyuruikigouyobi3x4";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X5 = "zrnhokensyuruikigouyobi3x5";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X6 = "zrnhokensyuruikigouyobi3x6";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X7 = "zrnhokensyuruikigouyobi3x7";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X8 = "zrnhokensyuruikigouyobi3x8";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X9 = "zrnhokensyuruikigouyobi3x9";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X10 = "zrnhokensyuruikigouyobi3x10";
    public static final String ZRNTOKUYAKUKIGOUYOBIX1   = "zrntokuyakukigouyobix1";
    public static final String ZRNTOKUYAKUKIGOUYOBIX2   = "zrntokuyakukigouyobix2";
    public static final String ZRNTOKUYAKUKIGOUYOBIX3   = "zrntokuyakukigouyobix3";
    public static final String ZRNTOKUYAKUKIGOUYOBIX4   = "zrntokuyakukigouyobix4";
    public static final String ZRNTOKUYAKUKIGOUYOBIX5   = "zrntokuyakukigouyobix5";
    public static final String ZRNMARUTEIKIGOUYOBIX1    = "zrnmaruteikigouyobix1";
    public static final String ZRNMARUTEIKIGOUYOBIX2    = "zrnmaruteikigouyobix2";
    public static final String ZRNMARUTEIKIGOUYOBIX3    = "zrnmaruteikigouyobix3";
    public static final String ZRNMARUTEIKIGOUYOBIX4    = "zrnmaruteikigouyobix4";
    public static final String ZRNMARUTEIKIGOUYOBIX5    = "zrnmaruteikigouyobix5";
    public static final String ZRNSIZNMRTIKGUYBX1       = "zrnsiznmrtikguybx1";
    public static final String ZRNSIZNMRTIKGUYBX2       = "zrnsiznmrtikguybx2";
    public static final String ZRNSIZNMRTIKGUYBX3       = "zrnsiznmrtikguybx3";
    public static final String ZRNSIZNMRTIKGUYBX4       = "zrnsiznmrtikguybx4";
    public static final String ZRNSIZNMRTIKGUYBX5       = "zrnsiznmrtikguybx5";
    public static final String ZRNTEIGENMARUTEIKIGOUYOBIX1 = "zrnteigenmaruteikigouyobix1";
    public static final String ZRNTEIGENMARUTEIKIGOUYOBIX2 = "zrnteigenmaruteikigouyobix2";
    public static final String ZRNTEIGENMARUTEIKIGOUYOBIX3 = "zrnteigenmaruteikigouyobix3";
    public static final String ZRNTEIGENMARUTEIKIGOUYOBIX4 = "zrnteigenmaruteikigouyobix4";
    public static final String ZRNTEIGENMARUTEIKIGOUYOBIX5 = "zrnteigenmaruteikigouyobix5";
    public static final String ZRNSYUUNYUUMRTIKGUYBX1   = "zrnsyuunyuumrtikguybx1";
    public static final String ZRNSYUUNYUUMRTIKGUYBX2   = "zrnsyuunyuumrtikguybx2";
    public static final String ZRNSYUUNYUUMRTIKGUYBX3   = "zrnsyuunyuumrtikguybx3";
    public static final String ZRNSYUUNYUUMRTIKGUYBX4   = "zrnsyuunyuumrtikguybx4";
    public static final String ZRNSYUUNYUUMRTIKGUYBX5   = "zrnsyuunyuumrtikguybx5";
    public static final String ZRNSUURIYOUYOBIN5        = "zrnsuuriyouyobin5";
    public static final String ZRNSUURIYOUYOBIN5X2      = "zrnsuuriyouyobin5x2";
    public static final String ZRNSUURIYOUYOBIN5X3      = "zrnsuuriyouyobin5x3";
    public static final String ZRNSUURIYOUYOBIN5X4      = "zrnsuuriyouyobin5x4";
    public static final String ZRNSUURIYOUYOBIN5X5      = "zrnsuuriyouyobin5x5";
    public static final String ZRNYOBIV2X9              = "zrnyobiv2x9";
    public static final String ZRNYOBIN3X5              = "zrnyobin3x5";
    public static final String ZRNSUURIYOUYOBIN1X7      = "zrnsuuriyouyobin1x7";
    public static final String ZRNYOBIV1X11             = "zrnyobiv1x11";
    public static final String ZRNSUURIYOUYOBIN5X6      = "zrnsuuriyouyobin5x6";
    public static final String ZRNDAKUHIKETTIKJYNSYRIKBNX1 = "zrndakuhikettikjynsyrikbnx1";
    public static final String ZRNDAKUHIKETTIKJYNSYRIKBNX2 = "zrndakuhikettikjynsyrikbnx2";
    public static final String ZRNDAKUHIKETTIKJYNSYRIKBNX3 = "zrndakuhikettikjynsyrikbnx3";
    public static final String ZRNDAKUHIKETTIKJYNSYRIKBNX4 = "zrndakuhikettikjynsyrikbnx4";
    public static final String ZRNDAKUHIKETTIKJYNSYRIKBNX5 = "zrndakuhikettikjynsyrikbnx5";
    public static final String ZRNHTNKNKYKDATAKANRINOX1 = "zrnhtnknkykdatakanrinox1";
    public static final String ZRNHTNKNKYKDATAKANRINOX2 = "zrnhtnknkykdatakanrinox2";
    public static final String ZRNHTNKNKYKDATAKANRINOX3 = "zrnhtnknkykdatakanrinox3";
    public static final String ZRNHTNKNKYKDATAKANRINOX4 = "zrnhtnknkykdatakanrinox4";
    public static final String ZRNHTNKNKYKDATAKANRINOX5 = "zrnhtnknkykdatakanrinox5";
    public static final String ZRNHTNKNKYKDATAKANRINOX6 = "zrnhtnknkykdatakanrinox6";
    public static final String ZRNKEIYAKUSYAHOUJINKBN   = "zrnkeiyakusyahoujinkbn";
    public static final String ZRNSUURIYOUYOBIN2X3      = "zrnsuuriyouyobin2x3";
    public static final String ZRNHYUJYNKTTIDKHKTTIKEKKACD = "zrnhyujynkttidkhkttikekkacd";
    public static final String ZRNHYUJYNKTTIDKHKTTIRYUCDX1 = "zrnhyujynkttidkhkttiryucdx1";
    public static final String ZRNHYUJYNKTTIDKHKTTIRYUCDX2 = "zrnhyujynkttidkhkttiryucdx2";
    public static final String ZRNHYUJYNKTTIDKHKTTIRYUCDX3 = "zrnhyujynkttidkhkttiryucdx3";
    public static final String ZRNHYUJYNKTTIDKHKTTIRYUCDX4 = "zrnhyujynkttidkhkttiryucdx4";
    public static final String ZRNHYUJYNKTTIRYUMSHYUTN  = "zrnhyujynkttiryumshyutn";
    public static final String ZRNHYUJYNKTTISAKUGENKKN  = "zrnhyujynkttisakugenkkn";
    public static final String ZRNSPPITKYKRYUMSHYUTN    = "zrnsppitkykryumshyutn";
    public static final String ZRNHYUJYNKTTITKTBUICDX1  = "zrnhyujynkttitktbuicdx1";
    public static final String ZRNHYUJYNKTTIHUTANPOKKNX1 = "zrnhyujynkttihutanpokknx1";
    public static final String ZRNHYUJYNKTTITKTBUICDX2  = "zrnhyujynkttitktbuicdx2";
    public static final String ZRNHYUJYNKTTIHUTANPOKKNX2 = "zrnhyujynkttihutanpokknx2";
    public static final String ZRNJYOUKENTUKITAISYOUKBNX1 = "zrnjyoukentukitaisyoukbnx1";
    public static final String ZRNJYUKNTKSSEIGENHYJX1   = "zrnjyukntksseigenhyjx1";
    public static final String ZRNJYUKNTKTKYKNOZOKIHYJX1 = "zrnjyukntktkyknozokihyjx1";
    public static final String ZRNSUURIYOUYOBIN1X8      = "zrnsuuriyouyobin1x8";
    public static final String ZRNJYOUKENTUKISEIGENSX1  = "zrnjyoukentukiseigensx1";
    public static final String ZRNJYOUKENTUKITAISYOUKBNX2 = "zrnjyoukentukitaisyoukbnx2";
    public static final String ZRNJYUKNTKSSEIGENHYJX2   = "zrnjyukntksseigenhyjx2";
    public static final String ZRNJYUKNTKTKYKNOZOKIHYJX2 = "zrnjyukntktkyknozokihyjx2";
    public static final String ZRNSUURIYOUYOBIN1X9      = "zrnsuuriyouyobin1x9";
    public static final String ZRNJYOUKENTUKISEIGENSX2  = "zrnjyoukentukiseigensx2";
    public static final String ZRNJYOUKENTUKITAISYOUKBNX3 = "zrnjyoukentukitaisyoukbnx3";
    public static final String ZRNJYUKNTKSSEIGENHYJX3   = "zrnjyukntksseigenhyjx3";
    public static final String ZRNJYUKNTKTKYKNOZOKIHYJX3 = "zrnjyukntktkyknozokihyjx3";
    public static final String ZRNSUURIYOUYOBIN1X10     = "zrnsuuriyouyobin1x10";
    public static final String ZRNJYOUKENTUKISEIGENSX3  = "zrnjyoukentukiseigensx3";
    public static final String ZRNJYOUKENTUKITAISYOUKBNX4 = "zrnjyoukentukitaisyoukbnx4";
    public static final String ZRNJYUKNTKSSEIGENHYJX4   = "zrnjyukntksseigenhyjx4";
    public static final String ZRNJYUKNTKTKYKNOZOKIHYJX4 = "zrnjyukntktkyknozokihyjx4";
    public static final String ZRNSUURIYOUYOBIN1X11     = "zrnsuuriyouyobin1x11";
    public static final String ZRNJYOUKENTUKISEIGENSX4  = "zrnjyoukentukiseigensx4";
    public static final String ZRNJYUKNTKKIGTIKSYRIHNKUHYJ = "zrnjyukntkkigtiksyrihnkuhyj";
    public static final String ZRNPMENSYURUIHENKOUKBN   = "zrnpmensyuruihenkoukbn";
    public static final String ZRNJYOUKENTUKITAISYOUKBN2X1 = "zrnjyoukentukitaisyoukbn2x1";
    public static final String ZRNJYUKNTKSSEIGENHYJ2X1  = "zrnjyukntksseigenhyj2x1";
    public static final String ZRNJYUKNTKTKYKNOZOKIHYJ2X1 = "zrnjyukntktkyknozokihyj2x1";
    public static final String ZRNSUURIYOUYOBIN1X12     = "zrnsuuriyouyobin1x12";
    public static final String ZRNJYOUKENTUKISEIGENS2X1 = "zrnjyoukentukiseigens2x1";
    public static final String ZRNJYOUKENTUKITAISYOUKBN2X2 = "zrnjyoukentukitaisyoukbn2x2";
    public static final String ZRNJYUKNTKSSEIGENHYJ2X2  = "zrnjyukntksseigenhyj2x2";
    public static final String ZRNJYUKNTKTKYKNOZOKIHYJ2X2 = "zrnjyukntktkyknozokihyj2x2";
    public static final String ZRNSUURIYOUYOBIN1X13     = "zrnsuuriyouyobin1x13";
    public static final String ZRNJYOUKENTUKISEIGENS2X2 = "zrnjyoukentukiseigens2x2";
    public static final String ZRNJYOUKENTUKITAISYOUKBN2X3 = "zrnjyoukentukitaisyoukbn2x3";
    public static final String ZRNJYUKNTKSSEIGENHYJ2X3  = "zrnjyukntksseigenhyj2x3";
    public static final String ZRNJYUKNTKTKYKNOZOKIHYJ2X3 = "zrnjyukntktkyknozokihyj2x3";
    public static final String ZRNSUURIYOUYOBIN1X14     = "zrnsuuriyouyobin1x14";
    public static final String ZRNJYOUKENTUKISEIGENS2X3 = "zrnjyoukentukiseigens2x3";
    public static final String ZRNJYOUKENTUKITAISYOUKBN2X4 = "zrnjyoukentukitaisyoukbn2x4";
    public static final String ZRNJYUKNTKSSEIGENHYJ2X4  = "zrnjyukntksseigenhyj2x4";
    public static final String ZRNJYUKNTKTKYKNOZOKIHYJ2X4 = "zrnjyukntktkyknozokihyj2x4";
    public static final String ZRNSUURIYOUYOBIN1X15     = "zrnsuuriyouyobin1x15";
    public static final String ZRNJYOUKENTUKISEIGENS2X4 = "zrnjyoukentukiseigens2x4";
    public static final String ZRNTKTSPPIRYUMSHYUTN     = "zrntktsppiryumshyutn";
    public static final String ZRNTKTSPPISKGNKKN        = "zrntktsppiskgnkkn";
    public static final String ZRNMNSISKKNRYUMSHYUTN    = "zrnmnsiskknryumshyutn";
    public static final String ZRNMANSEISIKKANSAKUGENKIKAN = "zrnmanseisikkansakugenkikan";
    public static final String ZRNMANSEISIKKANTOKUTEIBUICD = "zrnmanseisikkantokuteibuicd";
    public static final String ZRNMANSEISIKKANHUTANPOKIKAN = "zrnmanseisikkanhutanpokikan";
    public static final String ZRNSAIHOKENKBN           = "zrnsaihokenkbn";
    public static final String ZRNIMUSTIYUSBUS          = "zrnimustiyusbus";
    public static final String ZRNIMUSATEIYOUJISSITUHSYUS = "zrnimusateiyoujissituhsyus";
    public static final String ZRNISAHTNKNGUKIJISSITUHSYUS = "zrnisahtnkngukijissituhsyus";
    public static final String ZRNIMUSATEIYOUTENKANSAGAKUS = "zrnimusateiyoutenkansagakus";
    public static final String ZRNIMUSATEIYOUHANBAIKIRKBN = "zrnimusateiyouhanbaikirkbn";
    public static final String ZRNOYABOSYUUDAIRITENCD   = "zrnoyabosyuudairitencd";
    public static final String ZRNSUURIYOUBOSYUUKEITAIKBN = "zrnsuuriyoubosyuukeitaikbn";
    public static final String ZRNHIHOKENSYAHOKENAGE    = "zrnhihokensyahokenage";
    public static final String ZRNRENDOUYOUMUSNTKKYKHYJ = "zrnrendouyoumusntkkykhyj";
    public static final String ZRNYOBIV2X11             = "zrnyobiv2x11";
    public static final String ZRNYOBIN3X6              = "zrnyobin3x6";
    public static final String ZRNSUURIYOUYOBIN9X4      = "zrnsuuriyouyobin9x4";
    public static final String ZRNYOBIV1X20             = "zrnyobiv1x20";
    public static final String ZRNSUURIYOUYOBIN5X7      = "zrnsuuriyouyobin5x7";
    public static final String ZRNHHKNNENTYSIHYJ        = "zrnhhknnentysihyj";
    public static final String ZRNSINDENZUSYOKENSYOUSAICD = "zrnsindenzusyokensyousaicd";
    public static final String ZRNIMSTIYUKTEKKNSJSSHYJ  = "zrnimstiyuktekknsjsshyj";
    public static final String ZRNKETUEKIKENSASEKKEKKYUUSU = "zrnketuekikensasekkekkyuusu";
    public static final String ZRNKTEKKNSSKKKKYUSUSYKNCD = "zrnktekknsskkkkyususykncd";
    public static final String ZRNKETUEKIKENSAHAKKEKKYUUSU = "zrnketuekikensahakkekkyuusu";
    public static final String ZRNKTEKKNSHKKKKYUSUSYKNCD = "zrnktekknshkkkkyususykncd";
    public static final String ZRNKTEKKNSKETUSIKISORYOU = "zrnktekknsketusikisoryou";
    public static final String ZRNKTEKKNSKTSKSRYUSYOKENCD = "zrnktekknsktsksryusyokencd";
    public static final String ZRNKTEKKNSHEMATOKURITTO  = "zrnktekknshematokuritto";
    public static final String ZRNKTEKHMTKRTTSYKNCD     = "zrnktekhmtkrttsykncd";
    public static final String ZRNKETUEKIKENSAKESSYOUBANSU = "zrnketuekikensakessyoubansu";
    public static final String ZRNKTEKKNSKSSYUBNSUSYOKENCD = "zrnktekknskssyubnsusyokencd";
    public static final String ZRNKTEKKNSKSSISUTNPKRYU  = "zrnktekknskssisutnpkryu";
    public static final String ZRNKTEKKSSISUTNPKRYUSYKNCD = "zrnktekkssisutnpkryusykncd";
    public static final String ZRNKETUEKIKENSAARUBUMIN  = "zrnketuekikensaarubumin";
    public static final String ZRNKTEKKNSARUBUMINSYOKENCD = "zrnktekknsarubuminsyokencd";
    public static final String ZRNKETUEKIKENSAZTT       = "zrnketuekikensaztt";
    public static final String ZRNKETUEKIKENSAZTTSYOKENCD = "zrnketuekikensazttsyokencd";
    public static final String ZRNKETUEKIKENSAGOT       = "zrnketuekikensagot";
    public static final String ZRNKETUEKIKENSAGOTSYOKENCD = "zrnketuekikensagotsyokencd";
    public static final String ZRNKETUEKIKENSAGPT       = "zrnketuekikensagpt";
    public static final String ZRNKETUEKIKENSAGPTSYOKENCD = "zrnketuekikensagptsyokencd";
    public static final String ZRNKETUEKIKENSAGANMAGTP  = "zrnketuekikensaganmagtp";
    public static final String ZRNKETUEKIGANMAGTPSYOKENCD = "zrnketuekiganmagtpsyokencd";
    public static final String ZRNKETUEKIKENSASOUCHOL   = "zrnketuekikensasouchol";
    public static final String ZRNKETUEKICHOLSYOKENCD   = "zrnketuekicholsyokencd";
    public static final String ZRNKETUEKIKENSAHDLCHOL   = "zrnketuekikensahdlchol";
    public static final String ZRNKETUEKIKENSAHDLSYOKENCD = "zrnketuekikensahdlsyokencd";
    public static final String ZRNKTEKKNSTUKHMGRBN      = "zrnktekknstukhmgrbn";
    public static final String ZRNKTEKHMGRBNSYKNCD      = "zrnktekhmgrbnsykncd";
    public static final String ZRNKTEKKNSKORINESUTERRZE = "zrnktekknskorinesuterrze";
    public static final String ZRNKORINESUTERRZESYOKENCD = "zrnkorinesuterrzesyokencd";
    public static final String ZRNKETUEKIKENSAMCV       = "zrnketuekikensamcv";
    public static final String ZRNKETUEKIKENSAMCVSYOKENCD = "zrnketuekikensamcvsyokencd";
    public static final String ZRNKETUEKIKENSAMCH       = "zrnketuekikensamch";
    public static final String ZRNKETUEKIKENSAMCHSYOKENCD = "zrnketuekikensamchsyokencd";
    public static final String ZRNKETUEKIKENSAMCHC      = "zrnketuekikensamchc";
    public static final String ZRNKETUEKIKENSAMCHCSYOKENCD = "zrnketuekikensamchcsyokencd";
    public static final String ZRNKETUEKIKENSACEA       = "zrnketuekikensacea";
    public static final String ZRNKETUEKIKENSACEASYOKENCD = "zrnketuekikensaceasyokencd";
    public static final String ZRNKETUEKIKENSAAFP       = "zrnketuekikensaafp";
    public static final String ZRNKETUEKIKENSAAFPSYOKENCD = "zrnketuekikensaafpsyokencd";
    public static final String ZRNKETUEKIKENSAHBSKBN    = "zrnketuekikensahbskbn";
    public static final String ZRNKETUEKIKENSAHBSSYOKENCD = "zrnketuekikensahbssyokencd";
    public static final String ZRNKETUEKIKENSAHCVKBN    = "zrnketuekikensahcvkbn";
    public static final String ZRNKETUEKIKENSAHCVSYOKENCD = "zrnketuekikensahcvsyokencd";
    public static final String ZRNIMUSATEIYOUKNSNSYTRYSKBN = "zrnimusateiyouknsnsytryskbn";
    public static final String ZRNSYOSINLDLCHOL         = "zrnsyosinldlchol";
    public static final String ZRNTOKUTEIJYOUTAIHUSHRHYJ = "zrntokuteijyoutaihushrhyj";
    public static final String ZRNRENDOUYOUOSYUKEIYAKUP = "zrnrendouyouosyukeiyakup";
    public static final String ZRNTOKUBETUHOSYOUKIKAN   = "zrntokubetuhosyoukikan";
    public static final String ZRNRENDOUYOUGOUKEITENKANS = "zrnrendouyougoukeitenkans";
    public static final String ZRNRNDUYUGUKITNKNKAKAKU  = "zrnrnduyugukitnknkakaku";
    public static final String ZRNRNDUYUWNSGUKITNKNKAKAKU = "zrnrnduyuwnsgukitnknkakaku";
    public static final String ZRNMOSTNKNKHNBBNJYUTURT  = "zrnmostnknkhnbbnjyuturt";
    public static final String ZRNRNDUYUSYKYKBBNKHNS    = "zrnrnduyusykykbbnkhns";
    public static final String ZRNRENDOUYOUYOTEIRIRITU  = "zrnrendouyouyoteiriritu";
    public static final String ZRNKNKUZUSNZYRT          = "zrnknkuzusnzyrt";
    public static final String ZRNYOBIV121              = "zrnyobiv121";
    public static final String ZRNRAYSYSTEMHYJ          = "zrnraysystemhyj";
    public static final String ZRNGAIKAKBN              = "zrngaikakbn";
    public static final String ZRNGAIKADATEKIHONS       = "zrngaikadatekihons";
    public static final String ZRNGAIKADATESIBOUS       = "zrngaikadatesibous";
    public static final String ZRNKEIYAKUJIYOTEIRIRITU  = "zrnkeiyakujiyoteiriritu";
    public static final String ZRNKAWASERATE            = "zrnkawaserate";
    public static final String ZRNKAWASERATETEKIYOUYMD  = "zrnkawaseratetekiyouymd";
    public static final String ZRNENKDTSBUJSITIHSYUKNGK = "zrnenkdtsbujsitihsyukngk";
    public static final String ZRNSRDAI1HKNKKN          = "zrnsrdai1hknkkn";
    public static final String ZRNSUURIYOUYOBIN8        = "zrnsuuriyouyobin8";
    public static final String ZRNSUURIYOUYOBIN10X2     = "zrnsuuriyouyobin10x2";
    public static final String ZRNTUUKASYUKBN           = "zrntuukasyukbn";
    public static final String ZRNYOBIV9                = "zrnyobiv9";
    public static final String ZRNYOBIV10X4             = "zrnyobiv10x4";
    public static final String ZRNYOBIN7                = "zrnyobin7";
    public static final String ZRNYOBIN7X2              = "zrnyobin7x2";
    public static final String ZRNYOBIN7X3              = "zrnyobin7x3";
    public static final String ZRNYOBIN7X4              = "zrnyobin7x4";
    public static final String ZRNYOBIN7X5              = "zrnyobin7x5";
    public static final String ZRNYOBIV4X2              = "zrnyobiv4x2";

    private final PKZT_SbRituRendouRn primaryKey;

    public GenZT_SbRituRendouRn() {
        primaryKey = new PKZT_SbRituRendouRn();
    }

    public GenZT_SbRituRendouRn(String pZrndatakanrino) {
        primaryKey = new PKZT_SbRituRendouRn(pZrndatakanrino);
    }

    @Transient
    @Override
    public PKZT_SbRituRendouRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SbRituRendouRn> getMetaClass() {
        return QZT_SbRituRendouRn.class;
    }

    private Integer zrnsequenceno;

    @Column(name=GenZT_SbRituRendouRn.ZRNSEQUENCENO)
    public Integer getZrnsequenceno() {
        return zrnsequenceno;
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        zrnsequenceno = pZrnsequenceno;
    }

    private String zrnyobiv12x7;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIV12X7)
    public String getZrnyobiv12x7() {
        return zrnyobiv12x7;
    }

    public void setZrnyobiv12x7(String pZrnyobiv12x7) {
        zrnyobiv12x7 = pZrnyobiv12x7;
    }

    @Id
    @Column(name=GenZT_SbRituRendouRn.ZRNDATAKANRINO)
    public String getZrndatakanrino() {
        return getPrimaryKey().getZrndatakanrino();
    }

    public void setZrndatakanrino(String pZrndatakanrino) {
        getPrimaryKey().setZrndatakanrino(pZrndatakanrino);
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_SbRituRendouRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnsaimnkkykhyj;

    @Column(name=GenZT_SbRituRendouRn.ZRNSAIMNKKYKHYJ)
    public String getZrnsaimnkkykhyj() {
        return zrnsaimnkkykhyj;
    }

    public void setZrnsaimnkkykhyj(String pZrnsaimnkkykhyj) {
        zrnsaimnkkykhyj = pZrnsaimnkkykhyj;
    }

    private String zrnrendouyoukikan;

    @Column(name=GenZT_SbRituRendouRn.ZRNRENDOUYOUKIKAN)
    public String getZrnrendouyoukikan() {
        return zrnrendouyoukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnrendouyoukikan(String pZrnrendouyoukikan) {
        zrnrendouyoukikan = pZrnrendouyoukikan;
    }

    private String zrnhihokensyaagev2;

    @Column(name=GenZT_SbRituRendouRn.ZRNHIHOKENSYAAGEV2)
    public String getZrnhihokensyaagev2() {
        return zrnhihokensyaagev2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhihokensyaagev2(String pZrnhihokensyaagev2) {
        zrnhihokensyaagev2 = pZrnhihokensyaagev2;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnrendouyoukeiyakunengetu;

    @Column(name=GenZT_SbRituRendouRn.ZRNRENDOUYOUKEIYAKUNENGETU)
    public String getZrnrendouyoukeiyakunengetu() {
        return zrnrendouyoukeiyakunengetu;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnrendouyoukeiyakunengetu(String pZrnrendouyoukeiyakunengetu) {
        zrnrendouyoukeiyakunengetu = pZrnrendouyoukeiyakunengetu;
    }

    private Integer zrnrendouyoukihons;

    @Column(name=GenZT_SbRituRendouRn.ZRNRENDOUYOUKIHONS)
    public Integer getZrnrendouyoukihons() {
        return zrnrendouyoukihons;
    }

    public void setZrnrendouyoukihons(Integer pZrnrendouyoukihons) {
        zrnrendouyoukihons = pZrnrendouyoukihons;
    }

    private Integer zrnrendouyousibous;

    @Column(name=GenZT_SbRituRendouRn.ZRNRENDOUYOUSIBOUS)
    public Integer getZrnrendouyousibous() {
        return zrnrendouyousibous;
    }

    public void setZrnrendouyousibous(Integer pZrnrendouyousibous) {
        zrnrendouyousibous = pZrnrendouyousibous;
    }

    private Integer zrntnknitjbrigisbus;

    @Column(name=GenZT_SbRituRendouRn.ZRNTNKNITJBRIGISBUS)
    public Integer getZrntnknitjbrigisbus() {
        return zrntnknitjbrigisbus;
    }

    public void setZrntnknitjbrigisbus(Integer pZrntnknitjbrigisbus) {
        zrntnknitjbrigisbus = pZrntnknitjbrigisbus;
    }

    private String zrntenkanminaosikbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNTENKANMINAOSIKBN)
    public String getZrntenkanminaosikbn() {
        return zrntenkanminaosikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntenkanminaosikbn(String pZrntenkanminaosikbn) {
        zrntenkanminaosikbn = pZrntenkanminaosikbn;
    }

    private String zrnrendouyouhrkhouhoukbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNRENDOUYOUHRKHOUHOUKBN)
    public String getZrnrendouyouhrkhouhoukbn() {
        return zrnrendouyouhrkhouhoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnrendouyouhrkhouhoukbn(String pZrnrendouyouhrkhouhoukbn) {
        zrnrendouyouhrkhouhoukbn = pZrnrendouyouhrkhouhoukbn;
    }

    private String zrnrendouyoujyuusyokbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNRENDOUYOUJYUUSYOKBN)
    public String getZrnrendouyoujyuusyokbn() {
        return zrnrendouyoujyuusyokbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnrendouyoujyuusyokbn(String pZrnrendouyoujyuusyokbn) {
        zrnrendouyoujyuusyokbn = pZrnrendouyoujyuusyokbn;
    }

    private String zrnaatukaisosikicd;

    @Column(name=GenZT_SbRituRendouRn.ZRNAATUKAISOSIKICD)
    public String getZrnaatukaisosikicd() {
        return zrnaatukaisosikicd;
    }

    public void setZrnaatukaisosikicd(String pZrnaatukaisosikicd) {
        zrnaatukaisosikicd = pZrnaatukaisosikicd;
    }

    private String zrnrendouyousakugenkikan;

    @Column(name=GenZT_SbRituRendouRn.ZRNRENDOUYOUSAKUGENKIKAN)
    public String getZrnrendouyousakugenkikan() {
        return zrnrendouyousakugenkikan;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnrendouyousakugenkikan(String pZrnrendouyousakugenkikan) {
        zrnrendouyousakugenkikan = pZrnrendouyousakugenkikan;
    }

    private String zrnrnduyuryumshyutn;

    @Column(name=GenZT_SbRituRendouRn.ZRNRNDUYURYUMSHYUTN)
    public String getZrnrnduyuryumshyutn() {
        return zrnrnduyuryumshyutn;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnrnduyuryumshyutn(String pZrnrnduyuryumshyutn) {
        zrnrnduyuryumshyutn = pZrnrnduyuryumshyutn;
    }

    private String zrnrendouyoubosyuuym;

    @Column(name=GenZT_SbRituRendouRn.ZRNRENDOUYOUBOSYUUYM)
    public String getZrnrendouyoubosyuuym() {
        return zrnrendouyoubosyuuym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnrendouyoubosyuuym(String pZrnrendouyoubosyuuym) {
        zrnrendouyoubosyuuym = pZrnrendouyoubosyuuym;
    }

    private String zrnsuuriyouyobin1;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN1)
    public String getZrnsuuriyouyobin1() {
        return zrnsuuriyouyobin1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuuriyouyobin1(String pZrnsuuriyouyobin1) {
        zrnsuuriyouyobin1 = pZrnsuuriyouyobin1;
    }

    private String zrnsykgycd;

    @Column(name=GenZT_SbRituRendouRn.ZRNSYKGYCD)
    public String getZrnsykgycd() {
        return zrnsykgycd;
    }

    public void setZrnsykgycd(String pZrnsykgycd) {
        zrnsykgycd = pZrnsykgycd;
    }

    private String zrndakuhikettisyacd;

    @Column(name=GenZT_SbRituRendouRn.ZRNDAKUHIKETTISYACD)
    public String getZrndakuhikettisyacd() {
        return zrndakuhikettisyacd;
    }

    public void setZrndakuhikettisyacd(String pZrndakuhikettisyacd) {
        zrndakuhikettisyacd = pZrndakuhikettisyacd;
    }

    private String zrndai2hihokensyahyouji;

    @Column(name=GenZT_SbRituRendouRn.ZRNDAI2HIHOKENSYAHYOUJI)
    public String getZrndai2hihokensyahyouji() {
        return zrndai2hihokensyahyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndai2hihokensyahyouji(String pZrndai2hihokensyahyouji) {
        zrndai2hihokensyahyouji = pZrndai2hihokensyahyouji;
    }

    private String zrnrenseimusntkknyuhyj;

    @Column(name=GenZT_SbRituRendouRn.ZRNRENSEIMUSNTKKNYUHYJ)
    public String getZrnrenseimusntkknyuhyj() {
        return zrnrenseimusntkknyuhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnrenseimusntkknyuhyj(String pZrnrenseimusntkknyuhyj) {
        zrnrenseimusntkknyuhyj = pZrnrenseimusntkknyuhyj;
    }

    private String zrntokubetumaruteiarihyj;

    @Column(name=GenZT_SbRituRendouRn.ZRNTOKUBETUMARUTEIARIHYJ)
    public String getZrntokubetumaruteiarihyj() {
        return zrntokubetumaruteiarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokubetumaruteiarihyj(String pZrntokubetumaruteiarihyj) {
        zrntokubetumaruteiarihyj = pZrntokubetumaruteiarihyj;
    }

    private String zrndougakutenkanhyouji;

    @Column(name=GenZT_SbRituRendouRn.ZRNDOUGAKUTENKANHYOUJI)
    public String getZrndougakutenkanhyouji() {
        return zrndougakutenkanhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndougakutenkanhyouji(String pZrndougakutenkanhyouji) {
        zrndougakutenkanhyouji = pZrndougakutenkanhyouji;
    }

    private String zrntenkansentakuhouhoukbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNTENKANSENTAKUHOUHOUKBN)
    public String getZrntenkansentakuhouhoukbn() {
        return zrntenkansentakuhouhoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntenkansentakuhouhoukbn(String pZrntenkansentakuhouhoukbn) {
        zrntenkansentakuhouhoukbn = pZrntenkansentakuhouhoukbn;
    }

    private String zrntokubetusentakuarikbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNTOKUBETUSENTAKUARIKBN)
    public String getZrntokubetusentakuarikbn() {
        return zrntokubetusentakuarikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokubetusentakuarikbn(String pZrntokubetusentakuarikbn) {
        zrntokubetusentakuarikbn = pZrntokubetusentakuarikbn;
    }

    private String zrnketteikekkakbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETTEIKEKKAKBN)
    public String getZrnketteikekkakbn() {
        return zrnketteikekkakbn;
    }

    public void setZrnketteikekkakbn(String pZrnketteikekkakbn) {
        zrnketteikekkakbn = pZrnketteikekkakbn;
    }

    private String zrnkeiyakukakuninsyuruikbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNKEIYAKUKAKUNINSYURUIKBN)
    public String getZrnkeiyakukakuninsyuruikbn() {
        return zrnkeiyakukakuninsyuruikbn;
    }

    public void setZrnkeiyakukakuninsyuruikbn(String pZrnkeiyakukakuninsyuruikbn) {
        zrnkeiyakukakuninsyuruikbn = pZrnkeiyakukakuninsyuruikbn;
    }

    private String zrnkeiyakukakuninriyuukbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNKEIYAKUKAKUNINRIYUUKBN)
    public String getZrnkeiyakukakuninriyuukbn() {
        return zrnkeiyakukakuninriyuukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkeiyakukakuninriyuukbn(String pZrnkeiyakukakuninriyuukbn) {
        zrnkeiyakukakuninriyuukbn = pZrnkeiyakukakuninriyuukbn;
    }

    private String zrnrendouyoukekkancdx1;

    @Column(name=GenZT_SbRituRendouRn.ZRNRENDOUYOUKEKKANCDX1)
    public String getZrnrendouyoukekkancdx1() {
        return zrnrendouyoukekkancdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 5)
    public void setZrnrendouyoukekkancdx1(String pZrnrendouyoukekkancdx1) {
        zrnrendouyoukekkancdx1 = pZrnrendouyoukekkancdx1;
    }

    private String zrnkeikanensuux1;

    @Column(name=GenZT_SbRituRendouRn.ZRNKEIKANENSUUX1)
    public String getZrnkeikanensuux1() {
        return zrnkeikanensuux1;
    }

    public void setZrnkeikanensuux1(String pZrnkeikanensuux1) {
        zrnkeikanensuux1 = pZrnkeikanensuux1;
    }

    private String zrnsyujyutuarihyoujix1;

    @Column(name=GenZT_SbRituRendouRn.ZRNSYUJYUTUARIHYOUJIX1)
    public String getZrnsyujyutuarihyoujix1() {
        return zrnsyujyutuarihyoujix1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyujyutuarihyoujix1(String pZrnsyujyutuarihyoujix1) {
        zrnsyujyutuarihyoujix1 = pZrnsyujyutuarihyoujix1;
    }

    private String zrnrendouyoukekkancdx2;

    @Column(name=GenZT_SbRituRendouRn.ZRNRENDOUYOUKEKKANCDX2)
    public String getZrnrendouyoukekkancdx2() {
        return zrnrendouyoukekkancdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 5)
    public void setZrnrendouyoukekkancdx2(String pZrnrendouyoukekkancdx2) {
        zrnrendouyoukekkancdx2 = pZrnrendouyoukekkancdx2;
    }

    private String zrnkeikanensuux2;

    @Column(name=GenZT_SbRituRendouRn.ZRNKEIKANENSUUX2)
    public String getZrnkeikanensuux2() {
        return zrnkeikanensuux2;
    }

    public void setZrnkeikanensuux2(String pZrnkeikanensuux2) {
        zrnkeikanensuux2 = pZrnkeikanensuux2;
    }

    private String zrnsyujyutuarihyoujix2;

    @Column(name=GenZT_SbRituRendouRn.ZRNSYUJYUTUARIHYOUJIX2)
    public String getZrnsyujyutuarihyoujix2() {
        return zrnsyujyutuarihyoujix2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyujyutuarihyoujix2(String pZrnsyujyutuarihyoujix2) {
        zrnsyujyutuarihyoujix2 = pZrnsyujyutuarihyoujix2;
    }

    private String zrnsaihokenhyouji;

    @Column(name=GenZT_SbRituRendouRn.ZRNSAIHOKENHYOUJI)
    public String getZrnsaihokenhyouji() {
        return zrnsaihokenhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsaihokenhyouji(String pZrnsaihokenhyouji) {
        zrnsaihokenhyouji = pZrnsaihokenhyouji;
    }

    private String zrnrnduyusysnhujyusnssyacd;

    @Column(name=GenZT_SbRituRendouRn.ZRNRNDUYUSYSNHUJYUSNSSYACD)
    public String getZrnrnduyusysnhujyusnssyacd() {
        return zrnrnduyusysnhujyusnssyacd;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnrnduyusysnhujyusnssyacd(String pZrnrnduyusysnhujyusnssyacd) {
        zrnrnduyusysnhujyusnssyacd = pZrnrnduyusysnhujyusnssyacd;
    }

    private String zrnrndyusysnhujyusnshuhukbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNRNDYUSYSNHUJYUSNSHUHUKBN)
    public String getZrnrndyusysnhujyusnshuhukbn() {
        return zrnrndyusysnhujyusnshuhukbn;
    }

    public void setZrnrndyusysnhujyusnshuhukbn(String pZrnrndyusysnhujyusnshuhukbn) {
        zrnrndyusysnhujyusnshuhukbn = pZrnrndyusysnhujyusnshuhukbn;
    }

    private String zrnsaisinriyuukbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNSAISINRIYUUKBN)
    public String getZrnsaisinriyuukbn() {
        return zrnsaisinriyuukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsaisinriyuukbn(String pZrnsaisinriyuukbn) {
        zrnsaisinriyuukbn = pZrnsaisinriyuukbn;
    }

    private String zrnnyoutousaisinarihyouji;

    @Column(name=GenZT_SbRituRendouRn.ZRNNYOUTOUSAISINARIHYOUJI)
    public String getZrnnyoutousaisinarihyouji() {
        return zrnnyoutousaisinarihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnyoutousaisinarihyouji(String pZrnnyoutousaisinarihyouji) {
        zrnnyoutousaisinarihyouji = pZrnnyoutousaisinarihyouji;
    }

    private String zrnnyoutanpakusaisinarihyj;

    @Column(name=GenZT_SbRituRendouRn.ZRNNYOUTANPAKUSAISINARIHYJ)
    public String getZrnnyoutanpakusaisinarihyj() {
        return zrnnyoutanpakusaisinarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnyoutanpakusaisinarihyj(String pZrnnyoutanpakusaisinarihyj) {
        zrnnyoutanpakusaisinarihyj = pZrnnyoutanpakusaisinarihyj;
    }

    private String zrnhemasaisinarihyouji;

    @Column(name=GenZT_SbRituRendouRn.ZRNHEMASAISINARIHYOUJI)
    public String getZrnhemasaisinarihyouji() {
        return zrnhemasaisinarihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhemasaisinarihyouji(String pZrnhemasaisinarihyouji) {
        zrnhemasaisinarihyouji = pZrnhemasaisinarihyouji;
    }

    private String zrnkettousaisinarihyouji;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETTOUSAISINARIHYOUJI)
    public String getZrnkettousaisinarihyouji() {
        return zrnkettousaisinarihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkettousaisinarihyouji(String pZrnkettousaisinarihyouji) {
        zrnkettousaisinarihyouji = pZrnkettousaisinarihyouji;
    }

    private String zrnsintyousaisinarihyouji;

    @Column(name=GenZT_SbRituRendouRn.ZRNSINTYOUSAISINARIHYOUJI)
    public String getZrnsintyousaisinarihyouji() {
        return zrnsintyousaisinarihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsintyousaisinarihyouji(String pZrnsintyousaisinarihyouji) {
        zrnsintyousaisinarihyouji = pZrnsintyousaisinarihyouji;
    }

    private String zrnkyouisaisinarihyouji;

    @Column(name=GenZT_SbRituRendouRn.ZRNKYOUISAISINARIHYOUJI)
    public String getZrnkyouisaisinarihyouji() {
        return zrnkyouisaisinarihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkyouisaisinarihyouji(String pZrnkyouisaisinarihyouji) {
        zrnkyouisaisinarihyouji = pZrnkyouisaisinarihyouji;
    }

    private String zrnhukuisaisinarihyouji;

    @Column(name=GenZT_SbRituRendouRn.ZRNHUKUISAISINARIHYOUJI)
    public String getZrnhukuisaisinarihyouji() {
        return zrnhukuisaisinarihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhukuisaisinarihyouji(String pZrnhukuisaisinarihyouji) {
        zrnhukuisaisinarihyouji = pZrnhukuisaisinarihyouji;
    }

    private String zrntaijyuusaisinarihyouji;

    @Column(name=GenZT_SbRituRendouRn.ZRNTAIJYUUSAISINARIHYOUJI)
    public String getZrntaijyuusaisinarihyouji() {
        return zrntaijyuusaisinarihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntaijyuusaisinarihyouji(String pZrntaijyuusaisinarihyouji) {
        zrntaijyuusaisinarihyouji = pZrntaijyuusaisinarihyouji;
    }

    private String zrnketuatusaisinarihyouji;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUATUSAISINARIHYOUJI)
    public String getZrnketuatusaisinarihyouji() {
        return zrnketuatusaisinarihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnketuatusaisinarihyouji(String pZrnketuatusaisinarihyouji) {
        zrnketuatusaisinarihyouji = pZrnketuatusaisinarihyouji;
    }

    private String zrnrndyusisnhujyusnssyacd;

    @Column(name=GenZT_SbRituRendouRn.ZRNRNDYUSISNHUJYUSNSSYACD)
    public String getZrnrndyusisnhujyusnssyacd() {
        return zrnrndyusisnhujyusnssyacd;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnrndyusisnhujyusnssyacd(String pZrnrndyusisnhujyusnssyacd) {
        zrnrndyusisnhujyusnssyacd = pZrnrndyusisnhujyusnssyacd;
    }

    private String zrnrndyusisnhujyusnshuhukbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNRNDYUSISNHUJYUSNSHUHUKBN)
    public String getZrnrndyusisnhujyusnshuhukbn() {
        return zrnrndyusisnhujyusnshuhukbn;
    }

    public void setZrnrndyusisnhujyusnshuhukbn(String pZrnrndyusisnhujyusnshuhukbn) {
        zrnrndyusisnhujyusnshuhukbn = pZrnrndyusisnhujyusnshuhukbn;
    }

    private String zrnnyoutoukbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNNYOUTOUKBN)
    public String getZrnnyoutoukbn() {
        return zrnnyoutoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnyoutoukbn(String pZrnnyoutoukbn) {
        zrnnyoutoukbn = pZrnnyoutoukbn;
    }

    private String zrnyobiv1x2;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIV1X2)
    public String getZrnyobiv1x2() {
        return zrnyobiv1x2;
    }

    public void setZrnyobiv1x2(String pZrnyobiv1x2) {
        zrnyobiv1x2 = pZrnyobiv1x2;
    }

    private String zrnnyoutanpakukbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNNYOUTANPAKUKBN)
    public String getZrnnyoutanpakukbn() {
        return zrnnyoutanpakukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnyoutanpakukbn(String pZrnnyoutanpakukbn) {
        zrnnyoutanpakukbn = pZrnnyoutanpakukbn;
    }

    private String zrnhemakbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNHEMAKBN)
    public String getZrnhemakbn() {
        return zrnhemakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhemakbn(String pZrnhemakbn) {
        zrnhemakbn = pZrnhemakbn;
    }

    private String zrnkettoutikeikajikan;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETTOUTIKEIKAJIKAN)
    public String getZrnkettoutikeikajikan() {
        return zrnkettoutikeikajikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkettoutikeikajikan(String pZrnkettoutikeikajikan) {
        zrnkettoutikeikajikan = pZrnkettoutikeikajikan;
    }

    private Integer zrnkettouti;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETTOUTI)
    public Integer getZrnkettouti() {
        return zrnkettouti;
    }

    public void setZrnkettouti(Integer pZrnkettouti) {
        zrnkettouti = pZrnkettouti;
    }

    private Integer zrnsintyou;

    @Column(name=GenZT_SbRituRendouRn.ZRNSINTYOU)
    public Integer getZrnsintyou() {
        return zrnsintyou;
    }

    public void setZrnsintyou(Integer pZrnsintyou) {
        zrnsintyou = pZrnsintyou;
    }

    private Integer zrnkyoui;

    @Column(name=GenZT_SbRituRendouRn.ZRNKYOUI)
    public Integer getZrnkyoui() {
        return zrnkyoui;
    }

    public void setZrnkyoui(Integer pZrnkyoui) {
        zrnkyoui = pZrnkyoui;
    }

    private Integer zrnhukui;

    @Column(name=GenZT_SbRituRendouRn.ZRNHUKUI)
    public Integer getZrnhukui() {
        return zrnhukui;
    }

    public void setZrnhukui(Integer pZrnhukui) {
        zrnhukui = pZrnhukui;
    }

    private Integer zrntaijyuu;

    @Column(name=GenZT_SbRituRendouRn.ZRNTAIJYUU)
    public Integer getZrntaijyuu() {
        return zrntaijyuu;
    }

    public void setZrntaijyuu(Integer pZrntaijyuu) {
        zrntaijyuu = pZrntaijyuu;
    }

    private Integer zrnsaikouketuatu;

    @Column(name=GenZT_SbRituRendouRn.ZRNSAIKOUKETUATU)
    public Integer getZrnsaikouketuatu() {
        return zrnsaikouketuatu;
    }

    public void setZrnsaikouketuatu(Integer pZrnsaikouketuatu) {
        zrnsaikouketuatu = pZrnsaikouketuatu;
    }

    private Integer zrnsaiteiketuatu;

    @Column(name=GenZT_SbRituRendouRn.ZRNSAITEIKETUATU)
    public Integer getZrnsaiteiketuatu() {
        return zrnsaiteiketuatu;
    }

    public void setZrnsaiteiketuatu(Integer pZrnsaiteiketuatu) {
        zrnsaiteiketuatu = pZrnsaiteiketuatu;
    }

    private String zrnxsensyokencd;

    @Column(name=GenZT_SbRituRendouRn.ZRNXSENSYOKENCD)
    public String getZrnxsensyokencd() {
        return zrnxsensyokencd;
    }

    public void setZrnxsensyokencd(String pZrnxsensyokencd) {
        zrnxsensyokencd = pZrnxsensyokencd;
    }

    private String zrnsindenzusyokencd;

    @Column(name=GenZT_SbRituRendouRn.ZRNSINDENZUSYOKENCD)
    public String getZrnsindenzusyokencd() {
        return zrnsindenzusyokencd;
    }

    public void setZrnsindenzusyokencd(String pZrnsindenzusyokencd) {
        zrnsindenzusyokencd = pZrnsindenzusyokencd;
    }

    private String zrnrnduyuganteisysnsyokencd;

    @Column(name=GenZT_SbRituRendouRn.ZRNRNDUYUGANTEISYSNSYOKENCD)
    public String getZrnrnduyuganteisysnsyokencd() {
        return zrnrnduyuganteisysnsyokencd;
    }

    public void setZrnrnduyuganteisysnsyokencd(String pZrnrnduyuganteisysnsyokencd) {
        zrnrnduyuganteisysnsyokencd = pZrnrnduyuganteisysnsyokencd;
    }

    private String zrnsinsahouhousiyoukbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNSINSAHOUHOUSIYOUKBN)
    public String getZrnsinsahouhousiyoukbn() {
        return zrnsinsahouhousiyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsinsahouhousiyoukbn(String pZrnsinsahouhousiyoukbn) {
        zrnsinsahouhousiyoukbn = pZrnsinsahouhousiyoukbn;
    }

    private String zrnvipteikihyouji;

    @Column(name=GenZT_SbRituRendouRn.ZRNVIPTEIKIHYOUJI)
    public String getZrnvipteikihyouji() {
        return zrnvipteikihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnvipteikihyouji(String pZrnvipteikihyouji) {
        zrnvipteikihyouji = pZrnvipteikihyouji;
    }

    private String zrnhoujyounomihyouji;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOUJYOUNOMIHYOUJI)
    public String getZrnhoujyounomihyouji() {
        return zrnhoujyounomihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhoujyounomihyouji(String pZrnhoujyounomihyouji) {
        zrnhoujyounomihyouji = pZrnhoujyounomihyouji;
    }

    private String zrnketuekikensajissikbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAJISSIKBN)
    public String getZrnketuekikensajissikbn() {
        return zrnketuekikensajissikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnketuekikensajissikbn(String pZrnketuekikensajissikbn) {
        zrnketuekikensajissikbn = pZrnketuekikensajissikbn;
    }

    private String zrnmaruteisyuruikigou;

    @Column(name=GenZT_SbRituRendouRn.ZRNMARUTEISYURUIKIGOU)
    public String getZrnmaruteisyuruikigou() {
        return zrnmaruteisyuruikigou;
    }

    public void setZrnmaruteisyuruikigou(String pZrnmaruteisyuruikigou) {
        zrnmaruteisyuruikigou = pZrnmaruteisyuruikigou;
    }

    private String zrnseizonmrtisyuruikgu;

    @Column(name=GenZT_SbRituRendouRn.ZRNSEIZONMRTISYURUIKGU)
    public String getZrnseizonmrtisyuruikgu() {
        return zrnseizonmrtisyuruikgu;
    }

    public void setZrnseizonmrtisyuruikgu(String pZrnseizonmrtisyuruikgu) {
        zrnseizonmrtisyuruikgu = pZrnseizonmrtisyuruikgu;
    }

    private Integer zrnketusikisoryou;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUSIKISORYOU)
    public Integer getZrnketusikisoryou() {
        return zrnketusikisoryou;
    }

    public void setZrnketusikisoryou(Integer pZrnketusikisoryou) {
        zrnketusikisoryou = pZrnketusikisoryou;
    }

    private Integer zrngot;

    @Column(name=GenZT_SbRituRendouRn.ZRNGOT)
    public Integer getZrngot() {
        return zrngot;
    }

    public void setZrngot(Integer pZrngot) {
        zrngot = pZrngot;
    }

    private Integer zrngpt;

    @Column(name=GenZT_SbRituRendouRn.ZRNGPT)
    public Integer getZrngpt() {
        return zrngpt;
    }

    public void setZrngpt(Integer pZrngpt) {
        zrngpt = pZrngpt;
    }

    private Integer zrnganmagtp;

    @Column(name=GenZT_SbRituRendouRn.ZRNGANMAGTP)
    public Integer getZrnganmagtp() {
        return zrnganmagtp;
    }

    public void setZrnganmagtp(Integer pZrnganmagtp) {
        zrnganmagtp = pZrnganmagtp;
    }

    private String zrnsyumisyatkisindenzukbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNSYUMISYATKISINDENZUKBN)
    public String getZrnsyumisyatkisindenzukbn() {
        return zrnsyumisyatkisindenzukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyumisyatkisindenzukbn(String pZrnsyumisyatkisindenzukbn) {
        zrnsyumisyatkisindenzukbn = pZrnsyumisyatkisindenzukbn;
    }

    private String zrnkituenkbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNKITUENKBN)
    public String getZrnkituenkbn() {
        return zrnkituenkbn;
    }

    public void setZrnkituenkbn(String pZrnkituenkbn) {
        zrnkituenkbn = pZrnkituenkbn;
    }

    private String zrntignmrtisyukgu;

    @Column(name=GenZT_SbRituRendouRn.ZRNTIGNMRTISYUKGU)
    public String getZrntignmrtisyukgu() {
        return zrntignmrtisyukgu;
    }

    public void setZrntignmrtisyukgu(String pZrntignmrtisyukgu) {
        zrntignmrtisyukgu = pZrntignmrtisyukgu;
    }

    private String zrnteigenmaruteikikan;

    @Column(name=GenZT_SbRituRendouRn.ZRNTEIGENMARUTEIKIKAN)
    public String getZrnteigenmaruteikikan() {
        return zrnteigenmaruteikikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnteigenmaruteikikan(String pZrnteigenmaruteikikan) {
        zrnteigenmaruteikikan = pZrnteigenmaruteikikan;
    }

    private String zrnkituenhonsuu;

    @Column(name=GenZT_SbRituRendouRn.ZRNKITUENHONSUU)
    public String getZrnkituenhonsuu() {
        return zrnkituenhonsuu;
    }

    public void setZrnkituenhonsuu(String pZrnkituenhonsuu) {
        zrnkituenhonsuu = pZrnkituenhonsuu;
    }

    private String zrnyobiv2;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIV2)
    public String getZrnyobiv2() {
        return zrnyobiv2;
    }

    public void setZrnyobiv2(String pZrnyobiv2) {
        zrnyobiv2 = pZrnyobiv2;
    }

    private String zrnsuuriyouyobin1x2;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN1X2)
    public String getZrnsuuriyouyobin1x2() {
        return zrnsuuriyouyobin1x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuuriyouyobin1x2(String pZrnsuuriyouyobin1x2) {
        zrnsuuriyouyobin1x2 = pZrnsuuriyouyobin1x2;
    }

    private Integer zrnrnduyusppinyuintkykntgk;

    @Column(name=GenZT_SbRituRendouRn.ZRNRNDUYUSPPINYUINTKYKNTGK)
    public Integer getZrnrnduyusppinyuintkykntgk() {
        return zrnrnduyusppinyuintkykntgk;
    }

    public void setZrnrnduyusppinyuintkykntgk(Integer pZrnrnduyusppinyuintkykntgk) {
        zrnrnduyusppinyuintkykntgk = pZrnrnduyusppinyuintkykntgk;
    }

    private String zrnsuuriyouyobin12;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN12)
    public String getZrnsuuriyouyobin12() {
        return zrnsuuriyouyobin12;
    }

    @Padding(mode = "left", padChar = '0', length = 12)
    public void setZrnsuuriyouyobin12(String pZrnsuuriyouyobin12) {
        zrnsuuriyouyobin12 = pZrnsuuriyouyobin12;
    }

    private String zrnyobiv2x2;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIV2X2)
    public String getZrnyobiv2x2() {
        return zrnyobiv2x2;
    }

    public void setZrnyobiv2x2(String pZrnyobiv2x2) {
        zrnyobiv2x2 = pZrnyobiv2x2;
    }

    private String zrnsuuriyouyobin1x3;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN1X3)
    public String getZrnsuuriyouyobin1x3() {
        return zrnsuuriyouyobin1x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuuriyouyobin1x3(String pZrnsuuriyouyobin1x3) {
        zrnsuuriyouyobin1x3 = pZrnsuuriyouyobin1x3;
    }

    private Integer zrnyobin3;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIN3)
    public Integer getZrnyobin3() {
        return zrnyobin3;
    }

    public void setZrnyobin3(Integer pZrnyobin3) {
        zrnyobin3 = pZrnyobin3;
    }

    private String zrnsuuriyouyobin12x2;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN12X2)
    public String getZrnsuuriyouyobin12x2() {
        return zrnsuuriyouyobin12x2;
    }

    @Padding(mode = "left", padChar = '0', length = 12)
    public void setZrnsuuriyouyobin12x2(String pZrnsuuriyouyobin12x2) {
        zrnsuuriyouyobin12x2 = pZrnsuuriyouyobin12x2;
    }

    private Integer zrngoukeiteigenteikitkyks;

    @Column(name=GenZT_SbRituRendouRn.ZRNGOUKEITEIGENTEIKITKYKS)
    public Integer getZrngoukeiteigenteikitkyks() {
        return zrngoukeiteigenteikitkyks;
    }

    public void setZrngoukeiteigenteikitkyks(Integer pZrngoukeiteigenteikitkyks) {
        zrngoukeiteigenteikitkyks = pZrngoukeiteigenteikitkyks;
    }

    private Integer zrntigntikbbntnknitjbrs;

    @Column(name=GenZT_SbRituRendouRn.ZRNTIGNTIKBBNTNKNITJBRS)
    public Integer getZrntigntikbbntnknitjbrs() {
        return zrntigntikbbntnknitjbrs;
    }

    public void setZrntigntikbbntnknitjbrs(Integer pZrntigntikbbntnknitjbrs) {
        zrntigntikbbntnknitjbrs = pZrntigntikbbntnknitjbrs;
    }

    private String zrntokuteisippeisetkbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNTOKUTEISIPPEISETKBN)
    public String getZrntokuteisippeisetkbn() {
        return zrntokuteisippeisetkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuteisippeisetkbn(String pZrntokuteisippeisetkbn) {
        zrntokuteisippeisetkbn = pZrntokuteisippeisetkbn;
    }

    private String zrnsuuriyouyobin2;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN2)
    public String getZrnsuuriyouyobin2() {
        return zrnsuuriyouyobin2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsuuriyouyobin2(String pZrnsuuriyouyobin2) {
        zrnsuuriyouyobin2 = pZrnsuuriyouyobin2;
    }

    private String zrntaikakukijyunkanwahyouji;

    @Column(name=GenZT_SbRituRendouRn.ZRNTAIKAKUKIJYUNKANWAHYOUJI)
    public String getZrntaikakukijyunkanwahyouji() {
        return zrntaikakukijyunkanwahyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntaikakukijyunkanwahyouji(String pZrntaikakukijyunkanwahyouji) {
        zrntaikakukijyunkanwahyouji = pZrntaikakukijyunkanwahyouji;
    }

    private String zrnhaitoukbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNHAITOUKBN)
    public String getZrnhaitoukbn() {
        return zrnhaitoukbn;
    }

    public void setZrnhaitoukbn(String pZrnhaitoukbn) {
        zrnhaitoukbn = pZrnhaitoukbn;
    }

    private String zrnsnsykrketkbtsntkarihyj;

    @Column(name=GenZT_SbRituRendouRn.ZRNSNSYKRKETKBTSNTKARIHYJ)
    public String getZrnsnsykrketkbtsntkarihyj() {
        return zrnsnsykrketkbtsntkarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsnsykrketkbtsntkarihyj(String pZrnsnsykrketkbtsntkarihyj) {
        zrnsnsykrketkbtsntkarihyj = pZrnsnsykrketkbtsntkarihyj;
    }

    private String zrnaatukaikojincd;

    @Column(name=GenZT_SbRituRendouRn.ZRNAATUKAIKOJINCD)
    public String getZrnaatukaikojincd() {
        return zrnaatukaikojincd;
    }

    public void setZrnaatukaikojincd(String pZrnaatukaikojincd) {
        zrnaatukaikojincd = pZrnaatukaikojincd;
    }

    private String zrnyobiv1x5;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIV1X5)
    public String getZrnyobiv1x5() {
        return zrnyobiv1x5;
    }

    public void setZrnyobiv1x5(String pZrnyobiv1x5) {
        zrnyobiv1x5 = pZrnyobiv1x5;
    }

    private String zrnmanseisikkansetkbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNMANSEISIKKANSETKBN)
    public String getZrnmanseisikkansetkbn() {
        return zrnmanseisikkansetkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmanseisikkansetkbn(String pZrnmanseisikkansetkbn) {
        zrnmanseisikkansetkbn = pZrnmanseisikkansetkbn;
    }

    private String zrngengakutenkankykhyj;

    @Column(name=GenZT_SbRituRendouRn.ZRNGENGAKUTENKANKYKHYJ)
    public String getZrngengakutenkankykhyj() {
        return zrngengakutenkankykhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngengakutenkankykhyj(String pZrngengakutenkankykhyj) {
        zrngengakutenkankykhyj = pZrngengakutenkankykhyj;
    }

    private String zrnyobiv2x4;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIV2X4)
    public String getZrnyobiv2x4() {
        return zrnyobiv2x4;
    }

    public void setZrnyobiv2x4(String pZrnyobiv2x4) {
        zrnyobiv2x4 = pZrnyobiv2x4;
    }

    private String zrnfilekbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNFILEKBN)
    public String getZrnfilekbn() {
        return zrnfilekbn;
    }

    public void setZrnfilekbn(String pZrnfilekbn) {
        zrnfilekbn = pZrnfilekbn;
    }

    private String zrnyobiv2x5;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIV2X5)
    public String getZrnyobiv2x5() {
        return zrnyobiv2x5;
    }

    public void setZrnyobiv2x5(String pZrnyobiv2x5) {
        zrnyobiv2x5 = pZrnyobiv2x5;
    }

    private String zrnsuuriyouyobin1x4;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN1X4)
    public String getZrnsuuriyouyobin1x4() {
        return zrnsuuriyouyobin1x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuuriyouyobin1x4(String pZrnsuuriyouyobin1x4) {
        zrnsuuriyouyobin1x4 = pZrnsuuriyouyobin1x4;
    }

    private Integer zrnyobin3x2;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIN3X2)
    public Integer getZrnyobin3x2() {
        return zrnyobin3x2;
    }

    public void setZrnyobin3x2(Integer pZrnyobin3x2) {
        zrnyobin3x2 = pZrnyobin3x2;
    }

    private String zrnsuuriyouyobin12x3;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN12X3)
    public String getZrnsuuriyouyobin12x3() {
        return zrnsuuriyouyobin12x3;
    }

    @Padding(mode = "left", padChar = '0', length = 12)
    public void setZrnsuuriyouyobin12x3(String pZrnsuuriyouyobin12x3) {
        zrnsuuriyouyobin12x3 = pZrnsuuriyouyobin12x3;
    }

    private String zrnyobiv2x6;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIV2X6)
    public String getZrnyobiv2x6() {
        return zrnyobiv2x6;
    }

    public void setZrnyobiv2x6(String pZrnyobiv2x6) {
        zrnyobiv2x6 = pZrnyobiv2x6;
    }

    private String zrnsuuriyouyobin1x5;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN1X5)
    public String getZrnsuuriyouyobin1x5() {
        return zrnsuuriyouyobin1x5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuuriyouyobin1x5(String pZrnsuuriyouyobin1x5) {
        zrnsuuriyouyobin1x5 = pZrnsuuriyouyobin1x5;
    }

    private Integer zrnyobin3x3;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIN3X3)
    public Integer getZrnyobin3x3() {
        return zrnyobin3x3;
    }

    public void setZrnyobin3x3(Integer pZrnyobin3x3) {
        zrnyobin3x3 = pZrnyobin3x3;
    }

    private String zrnsuuriyouyobin12x4;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN12X4)
    public String getZrnsuuriyouyobin12x4() {
        return zrnsuuriyouyobin12x4;
    }

    @Padding(mode = "left", padChar = '0', length = 12)
    public void setZrnsuuriyouyobin12x4(String pZrnsuuriyouyobin12x4) {
        zrnsuuriyouyobin12x4 = pZrnsuuriyouyobin12x4;
    }

    private String zrnyobiv2x7;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIV2X7)
    public String getZrnyobiv2x7() {
        return zrnyobiv2x7;
    }

    public void setZrnyobiv2x7(String pZrnyobiv2x7) {
        zrnyobiv2x7 = pZrnyobiv2x7;
    }

    private String zrnsuuriyouyobin1x6;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN1X6)
    public String getZrnsuuriyouyobin1x6() {
        return zrnsuuriyouyobin1x6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuuriyouyobin1x6(String pZrnsuuriyouyobin1x6) {
        zrnsuuriyouyobin1x6 = pZrnsuuriyouyobin1x6;
    }

    private Integer zrnyobin3x4;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIN3X4)
    public Integer getZrnyobin3x4() {
        return zrnyobin3x4;
    }

    public void setZrnyobin3x4(Integer pZrnyobin3x4) {
        zrnyobin3x4 = pZrnyobin3x4;
    }

    private String zrnsuuriyouyobin12x5;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN12X5)
    public String getZrnsuuriyouyobin12x5() {
        return zrnsuuriyouyobin12x5;
    }

    @Padding(mode = "left", padChar = '0', length = 12)
    public void setZrnsuuriyouyobin12x5(String pZrnsuuriyouyobin12x5) {
        zrnsuuriyouyobin12x5 = pZrnsuuriyouyobin12x5;
    }

    private Integer zrntaikakuhyouten;

    @Column(name=GenZT_SbRituRendouRn.ZRNTAIKAKUHYOUTEN)
    public Integer getZrntaikakuhyouten() {
        return zrntaikakuhyouten;
    }

    public void setZrntaikakuhyouten(Integer pZrntaikakuhyouten) {
        zrntaikakuhyouten = pZrntaikakuhyouten;
    }

    private Integer zrnnyoutousykykhyutn;

    @Column(name=GenZT_SbRituRendouRn.ZRNNYOUTOUSYKYKHYUTN)
    public Integer getZrnnyoutousykykhyutn() {
        return zrnnyoutousykykhyutn;
    }

    public void setZrnnyoutousykykhyutn(Integer pZrnnyoutousykykhyutn) {
        zrnnyoutousykykhyutn = pZrnnyoutousykykhyutn;
    }

    private Integer zrnnyoutanpakusykykhyutn;

    @Column(name=GenZT_SbRituRendouRn.ZRNNYOUTANPAKUSYKYKHYUTN)
    public Integer getZrnnyoutanpakusykykhyutn() {
        return zrnnyoutanpakusykykhyutn;
    }

    public void setZrnnyoutanpakusykykhyutn(Integer pZrnnyoutanpakusykykhyutn) {
        zrnnyoutanpakusykykhyutn = pZrnnyoutanpakusykykhyutn;
    }

    private Integer zrnketuatutandokuhyouten;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUATUTANDOKUHYOUTEN)
    public Integer getZrnketuatutandokuhyouten() {
        return zrnketuatutandokuhyouten;
    }

    public void setZrnketuatutandokuhyouten(Integer pZrnketuatutandokuhyouten) {
        zrnketuatutandokuhyouten = pZrnketuatutandokuhyouten;
    }

    private Integer zrnyobin5;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIN5)
    public Integer getZrnyobin5() {
        return zrnyobin5;
    }

    public void setZrnyobin5(Integer pZrnyobin5) {
        zrnyobin5 = pZrnyobin5;
    }

    private String zrnsuuriyouyobin9;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN9)
    public String getZrnsuuriyouyobin9() {
        return zrnsuuriyouyobin9;
    }

    @Padding(mode = "left", padChar = '0', length = 9)
    public void setZrnsuuriyouyobin9(String pZrnsuuriyouyobin9) {
        zrnsuuriyouyobin9 = pZrnsuuriyouyobin9;
    }

    private Integer zrnyobin5x2;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIN5X2)
    public Integer getZrnyobin5x2() {
        return zrnyobin5x2;
    }

    public void setZrnyobin5x2(Integer pZrnyobin5x2) {
        zrnyobin5x2 = pZrnyobin5x2;
    }

    private String zrnsuuriyouyobin9x2;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN9X2)
    public String getZrnsuuriyouyobin9x2() {
        return zrnsuuriyouyobin9x2;
    }

    @Padding(mode = "left", padChar = '0', length = 9)
    public void setZrnsuuriyouyobin9x2(String pZrnsuuriyouyobin9x2) {
        zrnsuuriyouyobin9x2 = pZrnsuuriyouyobin9x2;
    }

    private Integer zrnyobin5x3;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIN5X3)
    public Integer getZrnyobin5x3() {
        return zrnyobin5x3;
    }

    public void setZrnyobin5x3(Integer pZrnyobin5x3) {
        zrnyobin5x3 = pZrnyobin5x3;
    }

    private String zrnsuuriyouyobin9x3;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN9X3)
    public String getZrnsuuriyouyobin9x3() {
        return zrnsuuriyouyobin9x3;
    }

    @Padding(mode = "left", padChar = '0', length = 9)
    public void setZrnsuuriyouyobin9x3(String pZrnsuuriyouyobin9x3) {
        zrnsuuriyouyobin9x3 = pZrnsuuriyouyobin9x3;
    }

    private String zrnsyunyumrtisyukgu;

    @Column(name=GenZT_SbRituRendouRn.ZRNSYUNYUMRTISYUKGU)
    public String getZrnsyunyumrtisyukgu() {
        return zrnsyunyumrtisyukgu;
    }

    public void setZrnsyunyumrtisyukgu(String pZrnsyunyumrtisyukgu) {
        zrnsyunyumrtisyukgu = pZrnsyunyumrtisyukgu;
    }

    private String zrnsyuunyuumaruteikikan;

    @Column(name=GenZT_SbRituRendouRn.ZRNSYUUNYUUMARUTEIKIKAN)
    public String getZrnsyuunyuumaruteikikan() {
        return zrnsyuunyuumaruteikikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsyuunyuumaruteikikan(String pZrnsyuunyuumaruteikikan) {
        zrnsyuunyuumaruteikikan = pZrnsyuunyuumaruteikikan;
    }

    private Integer zrnsyuunyuumrtinknengkn5;

    @Column(name=GenZT_SbRituRendouRn.ZRNSYUUNYUUMRTINKNENGKN5)
    public Integer getZrnsyuunyuumrtinknengkn5() {
        return zrnsyuunyuumrtinknengkn5;
    }

    public void setZrnsyuunyuumrtinknengkn5(Integer pZrnsyuunyuumrtinknengkn5) {
        zrnsyuunyuumrtinknengkn5 = pZrnsyuunyuumrtinknengkn5;
    }

    private String zrnsyuunyuumrtinkshrkkn;

    @Column(name=GenZT_SbRituRendouRn.ZRNSYUUNYUUMRTINKSHRKKN)
    public String getZrnsyuunyuumrtinkshrkkn() {
        return zrnsyuunyuumrtinkshrkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsyuunyuumrtinkshrkkn(String pZrnsyuunyuumrtinkshrkkn) {
        zrnsyuunyuumrtinkshrkkn = pZrnsyuunyuumrtinkshrkkn;
    }

    private String zrnsuuriyouyobin12x6;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN12X6)
    public String getZrnsuuriyouyobin12x6() {
        return zrnsuuriyouyobin12x6;
    }

    @Padding(mode = "left", padChar = '0', length = 12)
    public void setZrnsuuriyouyobin12x6(String pZrnsuuriyouyobin12x6) {
        zrnsuuriyouyobin12x6 = pZrnsuuriyouyobin12x6;
    }

    private String zrnhutanpobui1;

    @Column(name=GenZT_SbRituRendouRn.ZRNHUTANPOBUI1)
    public String getZrnhutanpobui1() {
        return zrnhutanpobui1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhutanpobui1(String pZrnhutanpobui1) {
        zrnhutanpobui1 = pZrnhutanpobui1;
    }

    private String zrnhtnpkkn1;

    @Column(name=GenZT_SbRituRendouRn.ZRNHTNPKKN1)
    public String getZrnhtnpkkn1() {
        return zrnhtnpkkn1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhtnpkkn1(String pZrnhtnpkkn1) {
        zrnhtnpkkn1 = pZrnhtnpkkn1;
    }

    private String zrnhutanpobui2;

    @Column(name=GenZT_SbRituRendouRn.ZRNHUTANPOBUI2)
    public String getZrnhutanpobui2() {
        return zrnhutanpobui2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhutanpobui2(String pZrnhutanpobui2) {
        zrnhutanpobui2 = pZrnhutanpobui2;
    }

    private String zrnhtnpkkn2;

    @Column(name=GenZT_SbRituRendouRn.ZRNHTNPKKN2)
    public String getZrnhtnpkkn2() {
        return zrnhtnpkkn2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhtnpkkn2(String pZrnhtnpkkn2) {
        zrnhtnpkkn2 = pZrnhtnpkkn2;
    }

    private String zrnsyosinnyoutou;

    @Column(name=GenZT_SbRituRendouRn.ZRNSYOSINNYOUTOU)
    public String getZrnsyosinnyoutou() {
        return zrnsyosinnyoutou;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyosinnyoutou(String pZrnsyosinnyoutou) {
        zrnsyosinnyoutou = pZrnsyosinnyoutou;
    }

    private String zrnsyosinnyoutanpaku;

    @Column(name=GenZT_SbRituRendouRn.ZRNSYOSINNYOUTANPAKU)
    public String getZrnsyosinnyoutanpaku() {
        return zrnsyosinnyoutanpaku;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyosinnyoutanpaku(String pZrnsyosinnyoutanpaku) {
        zrnsyosinnyoutanpaku = pZrnsyosinnyoutanpaku;
    }

    private String zrnsyosinnyousenketu;

    @Column(name=GenZT_SbRituRendouRn.ZRNSYOSINNYOUSENKETU)
    public String getZrnsyosinnyousenketu() {
        return zrnsyosinnyousenketu;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyosinnyousenketu(String pZrnsyosinnyousenketu) {
        zrnsyosinnyousenketu = pZrnsyosinnyousenketu;
    }

    private Integer zrnsyosinsaikouketuatu;

    @Column(name=GenZT_SbRituRendouRn.ZRNSYOSINSAIKOUKETUATU)
    public Integer getZrnsyosinsaikouketuatu() {
        return zrnsyosinsaikouketuatu;
    }

    public void setZrnsyosinsaikouketuatu(Integer pZrnsyosinsaikouketuatu) {
        zrnsyosinsaikouketuatu = pZrnsyosinsaikouketuatu;
    }

    private Integer zrnsyosinsaiteiketuatu;

    @Column(name=GenZT_SbRituRendouRn.ZRNSYOSINSAITEIKETUATU)
    public Integer getZrnsyosinsaiteiketuatu() {
        return zrnsyosinsaiteiketuatu;
    }

    public void setZrnsyosinsaiteiketuatu(Integer pZrnsyosinsaiteiketuatu) {
        zrnsyosinsaiteiketuatu = pZrnsyosinsaiteiketuatu;
    }

    private String zrnsaisinnyoutou;

    @Column(name=GenZT_SbRituRendouRn.ZRNSAISINNYOUTOU)
    public String getZrnsaisinnyoutou() {
        return zrnsaisinnyoutou;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsaisinnyoutou(String pZrnsaisinnyoutou) {
        zrnsaisinnyoutou = pZrnsaisinnyoutou;
    }

    private String zrnsaisinnyoutanpaku;

    @Column(name=GenZT_SbRituRendouRn.ZRNSAISINNYOUTANPAKU)
    public String getZrnsaisinnyoutanpaku() {
        return zrnsaisinnyoutanpaku;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsaisinnyoutanpaku(String pZrnsaisinnyoutanpaku) {
        zrnsaisinnyoutanpaku = pZrnsaisinnyoutanpaku;
    }

    private String zrnsaisinnyousenketu;

    @Column(name=GenZT_SbRituRendouRn.ZRNSAISINNYOUSENKETU)
    public String getZrnsaisinnyousenketu() {
        return zrnsaisinnyousenketu;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsaisinnyousenketu(String pZrnsaisinnyousenketu) {
        zrnsaisinnyousenketu = pZrnsaisinnyousenketu;
    }

    private Integer zrnsaisinsaikouketuatu;

    @Column(name=GenZT_SbRituRendouRn.ZRNSAISINSAIKOUKETUATU)
    public Integer getZrnsaisinsaikouketuatu() {
        return zrnsaisinsaikouketuatu;
    }

    public void setZrnsaisinsaikouketuatu(Integer pZrnsaisinsaikouketuatu) {
        zrnsaisinsaikouketuatu = pZrnsaisinsaikouketuatu;
    }

    private Integer zrnsaisinsaiteiketuatu;

    @Column(name=GenZT_SbRituRendouRn.ZRNSAISINSAITEIKETUATU)
    public Integer getZrnsaisinsaiteiketuatu() {
        return zrnsaisinsaiteiketuatu;
    }

    public void setZrnsaisinsaiteiketuatu(Integer pZrnsaisinsaiteiketuatu) {
        zrnsaisinsaiteiketuatu = pZrnsaisinsaiteiketuatu;
    }

    private String zrnketuekikensaijyou1;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAIJYOU1)
    public String getZrnketuekikensaijyou1() {
        return zrnketuekikensaijyou1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnketuekikensaijyou1(String pZrnketuekikensaijyou1) {
        zrnketuekikensaijyou1 = pZrnketuekikensaijyou1;
    }

    private String zrnketuekikensaijyou2;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAIJYOU2)
    public String getZrnketuekikensaijyou2() {
        return zrnketuekikensaijyou2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnketuekikensaijyou2(String pZrnketuekikensaijyou2) {
        zrnketuekikensaijyou2 = pZrnketuekikensaijyou2;
    }

    private String zrnketuekikensaijyou3;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAIJYOU3)
    public String getZrnketuekikensaijyou3() {
        return zrnketuekikensaijyou3;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnketuekikensaijyou3(String pZrnketuekikensaijyou3) {
        zrnketuekikensaijyou3 = pZrnketuekikensaijyou3;
    }

    private String zrnketuekikensaijyou4;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAIJYOU4)
    public String getZrnketuekikensaijyou4() {
        return zrnketuekikensaijyou4;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnketuekikensaijyou4(String pZrnketuekikensaijyou4) {
        zrnketuekikensaijyou4 = pZrnketuekikensaijyou4;
    }

    private String zrnketuekikensaijyou5;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAIJYOU5)
    public String getZrnketuekikensaijyou5() {
        return zrnketuekikensaijyou5;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnketuekikensaijyou5(String pZrnketuekikensaijyou5) {
        zrnketuekikensaijyou5 = pZrnketuekikensaijyou5;
    }

    private String zrnhukasyukeiyakukigou;

    @Column(name=GenZT_SbRituRendouRn.ZRNHUKASYUKEIYAKUKIGOU)
    public String getZrnhukasyukeiyakukigou() {
        return zrnhukasyukeiyakukigou;
    }

    public void setZrnhukasyukeiyakukigou(String pZrnhukasyukeiyakukigou) {
        zrnhukasyukeiyakukigou = pZrnhukasyukeiyakukigou;
    }

    private String zrnsekininkaisiymd;

    @Column(name=GenZT_SbRituRendouRn.ZRNSEKININKAISIYMD)
    public String getZrnsekininkaisiymd() {
        return zrnsekininkaisiymd;
    }

    public void setZrnsekininkaisiymd(String pZrnsekininkaisiymd) {
        zrnsekininkaisiymd = pZrnsekininkaisiymd;
    }

    private Integer zrnsyosinmyakuhakusuu;

    @Column(name=GenZT_SbRituRendouRn.ZRNSYOSINMYAKUHAKUSUU)
    public Integer getZrnsyosinmyakuhakusuu() {
        return zrnsyosinmyakuhakusuu;
    }

    public void setZrnsyosinmyakuhakusuu(Integer pZrnsyosinmyakuhakusuu) {
        zrnsyosinmyakuhakusuu = pZrnsyosinmyakuhakusuu;
    }

    private Integer zrnsyosinhuseimyakusuu;

    @Column(name=GenZT_SbRituRendouRn.ZRNSYOSINHUSEIMYAKUSUU)
    public Integer getZrnsyosinhuseimyakusuu() {
        return zrnsyosinhuseimyakusuu;
    }

    public void setZrnsyosinhuseimyakusuu(Integer pZrnsyosinhuseimyakusuu) {
        zrnsyosinhuseimyakusuu = pZrnsyosinhuseimyakusuu;
    }

    private Integer zrnsaisinmyakuhakusuu;

    @Column(name=GenZT_SbRituRendouRn.ZRNSAISINMYAKUHAKUSUU)
    public Integer getZrnsaisinmyakuhakusuu() {
        return zrnsaisinmyakuhakusuu;
    }

    public void setZrnsaisinmyakuhakusuu(Integer pZrnsaisinmyakuhakusuu) {
        zrnsaisinmyakuhakusuu = pZrnsaisinmyakuhakusuu;
    }

    private Integer zrnsaisinhuseimyakusuu;

    @Column(name=GenZT_SbRituRendouRn.ZRNSAISINHUSEIMYAKUSUU)
    public Integer getZrnsaisinhuseimyakusuu() {
        return zrnsaisinhuseimyakusuu;
    }

    public void setZrnsaisinhuseimyakusuu(Integer pZrnsaisinhuseimyakusuu) {
        zrnsaisinhuseimyakusuu = pZrnsaisinhuseimyakusuu;
    }

    private String zrnsuuriyouyobin2x2;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN2X2)
    public String getZrnsuuriyouyobin2x2() {
        return zrnsuuriyouyobin2x2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsuuriyouyobin2x2(String pZrnsuuriyouyobin2x2) {
        zrnsuuriyouyobin2x2 = pZrnsuuriyouyobin2x2;
    }

    private Integer zrnsouhyouten;

    @Column(name=GenZT_SbRituRendouRn.ZRNSOUHYOUTEN)
    public Integer getZrnsouhyouten() {
        return zrnsouhyouten;
    }

    public void setZrnsouhyouten(Integer pZrnsouhyouten) {
        zrnsouhyouten = pZrnsouhyouten;
    }

    private String zrntoukeiyukykymd;

    @Column(name=GenZT_SbRituRendouRn.ZRNTOUKEIYUKYKYMD)
    public String getZrntoukeiyukykymd() {
        return zrntoukeiyukykymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntoukeiyukykymd(String pZrntoukeiyukykymd) {
        zrntoukeiyukykymd = pZrntoukeiyukykymd;
    }

    private String zrndakuhiketteiriyuucdx1;

    @Column(name=GenZT_SbRituRendouRn.ZRNDAKUHIKETTEIRIYUUCDX1)
    public String getZrndakuhiketteiriyuucdx1() {
        return zrndakuhiketteiriyuucdx1;
    }

    public void setZrndakuhiketteiriyuucdx1(String pZrndakuhiketteiriyuucdx1) {
        zrndakuhiketteiriyuucdx1 = pZrndakuhiketteiriyuucdx1;
    }

    private String zrndakuhiketteiriyuucdx2;

    @Column(name=GenZT_SbRituRendouRn.ZRNDAKUHIKETTEIRIYUUCDX2)
    public String getZrndakuhiketteiriyuucdx2() {
        return zrndakuhiketteiriyuucdx2;
    }

    public void setZrndakuhiketteiriyuucdx2(String pZrndakuhiketteiriyuucdx2) {
        zrndakuhiketteiriyuucdx2 = pZrndakuhiketteiriyuucdx2;
    }

    private String zrndakuhiketteiriyuucdx3;

    @Column(name=GenZT_SbRituRendouRn.ZRNDAKUHIKETTEIRIYUUCDX3)
    public String getZrndakuhiketteiriyuucdx3() {
        return zrndakuhiketteiriyuucdx3;
    }

    public void setZrndakuhiketteiriyuucdx3(String pZrndakuhiketteiriyuucdx3) {
        zrndakuhiketteiriyuucdx3 = pZrndakuhiketteiriyuucdx3;
    }

    private String zrndakuhiketteiriyuucdx4;

    @Column(name=GenZT_SbRituRendouRn.ZRNDAKUHIKETTEIRIYUUCDX4)
    public String getZrndakuhiketteiriyuucdx4() {
        return zrndakuhiketteiriyuucdx4;
    }

    public void setZrndakuhiketteiriyuucdx4(String pZrndakuhiketteiriyuucdx4) {
        zrndakuhiketteiriyuucdx4 = pZrndakuhiketteiriyuucdx4;
    }

    private String zrnkanwamaeryouzouhyouten;

    @Column(name=GenZT_SbRituRendouRn.ZRNKANWAMAERYOUZOUHYOUTEN)
    public String getZrnkanwamaeryouzouhyouten() {
        return zrnkanwamaeryouzouhyouten;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnkanwamaeryouzouhyouten(String pZrnkanwamaeryouzouhyouten) {
        zrnkanwamaeryouzouhyouten = pZrnkanwamaeryouzouhyouten;
    }

    private String zrnryoumasitokujyoukanwahyj;

    @Column(name=GenZT_SbRituRendouRn.ZRNRYOUMASITOKUJYOUKANWAHYJ)
    public String getZrnryoumasitokujyoukanwahyj() {
        return zrnryoumasitokujyoukanwahyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnryoumasitokujyoukanwahyj(String pZrnryoumasitokujyoukanwahyj) {
        zrnryoumasitokujyoukanwahyj = pZrnryoumasitokujyoukanwahyj;
    }

    private String zrnhtnptokujyoukanwahyj;

    @Column(name=GenZT_SbRituRendouRn.ZRNHTNPTOKUJYOUKANWAHYJ)
    public String getZrnhtnptokujyoukanwahyj() {
        return zrnhtnptokujyoukanwahyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnptokujyoukanwahyj(String pZrnhtnptokujyoukanwahyj) {
        zrnhtnptokujyoukanwahyj = pZrnhtnptokujyoukanwahyj;
    }

    private String zrnhknsyuruikigousedaikbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNHKNSYURUIKIGOUSEDAIKBN)
    public String getZrnhknsyuruikigousedaikbn() {
        return zrnhknsyuruikigousedaikbn;
    }

    public void setZrnhknsyuruikigousedaikbn(String pZrnhknsyuruikigousedaikbn) {
        zrnhknsyuruikigousedaikbn = pZrnhknsyuruikigousedaikbn;
    }

    private String zrnmaruteikigousedaikbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNMARUTEIKIGOUSEDAIKBN)
    public String getZrnmaruteikigousedaikbn() {
        return zrnmaruteikigousedaikbn;
    }

    public void setZrnmaruteikigousedaikbn(String pZrnmaruteikigousedaikbn) {
        zrnmaruteikigousedaikbn = pZrnmaruteikigousedaikbn;
    }

    private String zrnseizonmrtikgusdkbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNSEIZONMRTIKGUSDKBN)
    public String getZrnseizonmrtikgusdkbn() {
        return zrnseizonmrtikgusdkbn;
    }

    public void setZrnseizonmrtikgusdkbn(String pZrnseizonmrtikgusdkbn) {
        zrnseizonmrtikgusdkbn = pZrnseizonmrtikgusdkbn;
    }

    private String zrnteigenmrtikgusdkbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNTEIGENMRTIKGUSDKBN)
    public String getZrnteigenmrtikgusdkbn() {
        return zrnteigenmrtikgusdkbn;
    }

    public void setZrnteigenmrtikgusdkbn(String pZrnteigenmrtikgusdkbn) {
        zrnteigenmrtikgusdkbn = pZrnteigenmrtikgusdkbn;
    }

    private String zrnsyuunyuumrtikgusdkbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNSYUUNYUUMRTIKGUSDKBN)
    public String getZrnsyuunyuumrtikgusdkbn() {
        return zrnsyuunyuumrtikgusdkbn;
    }

    public void setZrnsyuunyuumrtikgusdkbn(String pZrnsyuunyuumrtikgusdkbn) {
        zrnsyuunyuumrtikgusdkbn = pZrnsyuunyuumrtikgusdkbn;
    }

    private String zrnyobiv4;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIV4)
    public String getZrnyobiv4() {
        return zrnyobiv4;
    }

    public void setZrnyobiv4(String pZrnyobiv4) {
        zrnyobiv4 = pZrnyobiv4;
    }

    private String zrnhksykykkgusdkbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNHKSYKYKKGUSDKBN)
    public String getZrnhksykykkgusdkbn() {
        return zrnhksykykkgusdkbn;
    }

    public void setZrnhksykykkgusdkbn(String pZrnhksykykkgusdkbn) {
        zrnhksykykkgusdkbn = pZrnhksykykkgusdkbn;
    }

    private String zrnhhknsynensyuukbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNHHKNSYNENSYUUKBN)
    public String getZrnhhknsynensyuukbn() {
        return zrnhhknsynensyuukbn;
    }

    public void setZrnhhknsynensyuukbn(String pZrnhhknsynensyuukbn) {
        zrnhhknsynensyuukbn = pZrnhhknsynensyuukbn;
    }

    private String zrnpmentokuyakukbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNPMENTOKUYAKUKBN)
    public String getZrnpmentokuyakukbn() {
        return zrnpmentokuyakukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnpmentokuyakukbn(String pZrnpmentokuyakukbn) {
        zrnpmentokuyakukbn = pZrnpmentokuyakukbn;
    }

    private Integer zrnpmennenkansanp;

    @Column(name=GenZT_SbRituRendouRn.ZRNPMENNENKANSANP)
    public Integer getZrnpmennenkansanp() {
        return zrnpmennenkansanp;
    }

    public void setZrnpmennenkansanp(Integer pZrnpmennenkansanp) {
        zrnpmennenkansanp = pZrnpmennenkansanp;
    }

    private String zrnyobiv1x9;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIV1X9)
    public String getZrnyobiv1x9() {
        return zrnyobiv1x9;
    }

    public void setZrnyobiv1x9(String pZrnyobiv1x9) {
        zrnyobiv1x9 = pZrnyobiv1x9;
    }

    private String zrnsyosinsouchol;

    @Column(name=GenZT_SbRituRendouRn.ZRNSYOSINSOUCHOL)
    public String getZrnsyosinsouchol() {
        return zrnsyosinsouchol;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnsyosinsouchol(String pZrnsyosinsouchol) {
        zrnsyosinsouchol = pZrnsyosinsouchol;
    }

    private String zrnsyosinhdlchol;

    @Column(name=GenZT_SbRituRendouRn.ZRNSYOSINHDLCHOL)
    public String getZrnsyosinhdlchol() {
        return zrnsyosinhdlchol;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnsyosinhdlchol(String pZrnsyosinhdlchol) {
        zrnsyosinhdlchol = pZrnsyosinhdlchol;
    }

    private String zrnsyosintyuuseisibou;

    @Column(name=GenZT_SbRituRendouRn.ZRNSYOSINTYUUSEISIBOU)
    public String getZrnsyosintyuuseisibou() {
        return zrnsyosintyuuseisibou;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnsyosintyuuseisibou(String pZrnsyosintyuuseisibou) {
        zrnsyosintyuuseisibou = pZrnsyosintyuuseisibou;
    }

    private String zrnsysnsyumisyatkikettouti;

    @Column(name=GenZT_SbRituRendouRn.ZRNSYSNSYUMISYATKIKETTOUTI)
    public String getZrnsysnsyumisyatkikettouti() {
        return zrnsysnsyumisyatkikettouti;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnsysnsyumisyatkikettouti(String pZrnsysnsyumisyatkikettouti) {
        zrnsysnsyumisyatkikettouti = pZrnsysnsyumisyatkikettouti;
    }

    private BizNumber zrnsyosintoukahemogurobin;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouRn.ZRNSYOSINTOUKAHEMOGUROBIN)
    public BizNumber getZrnsyosintoukahemogurobin() {
        return zrnsyosintoukahemogurobin;
    }

    public void setZrnsyosintoukahemogurobin(BizNumber pZrnsyosintoukahemogurobin) {
        zrnsyosintoukahemogurobin = pZrnsyosintoukahemogurobin;
    }

    private BizNumber zrnsyosinnyousan;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouRn.ZRNSYOSINNYOUSAN)
    public BizNumber getZrnsyosinnyousan() {
        return zrnsyosinnyousan;
    }

    public void setZrnsyosinnyousan(BizNumber pZrnsyosinnyousan) {
        zrnsyosinnyousan = pZrnsyosinnyousan;
    }

    private BizNumber zrnsyosinkureatinin;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouRn.ZRNSYOSINKUREATININ)
    public BizNumber getZrnsyosinkureatinin() {
        return zrnsyosinkureatinin;
    }

    public void setZrnsyosinkureatinin(BizNumber pZrnsyosinkureatinin) {
        zrnsyosinkureatinin = pZrnsyosinkureatinin;
    }

    private String zrnbosyuukeirokbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNBOSYUUKEIROKBN)
    public String getZrnbosyuukeirokbn() {
        return zrnbosyuukeirokbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnbosyuukeirokbn(String pZrnbosyuukeirokbn) {
        zrnbosyuukeirokbn = pZrnbosyuukeirokbn;
    }

    private String zrnbsudirtnatkikeitaikbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNBSUDIRTNATKIKEITAIKBN)
    public String getZrnbsudirtnatkikeitaikbn() {
        return zrnbsudirtnatkikeitaikbn;
    }

    public void setZrnbsudirtnatkikeitaikbn(String pZrnbsudirtnatkikeitaikbn) {
        zrnbsudirtnatkikeitaikbn = pZrnbsudirtnatkikeitaikbn;
    }

    private String zrnkigkyhsitihsyutkykarihyj;

    @Column(name=GenZT_SbRituRendouRn.ZRNKIGKYHSITIHSYUTKYKARIHYJ)
    public String getZrnkigkyhsitihsyutkykarihyj() {
        return zrnkigkyhsitihsyutkykarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkigkyhsitihsyutkykarihyj(String pZrnkigkyhsitihsyutkykarihyj) {
        zrnkigkyhsitihsyutkykarihyj = pZrnkigkyhsitihsyutkykarihyj;
    }

    private String zrnpmenhutanpobui1;

    @Column(name=GenZT_SbRituRendouRn.ZRNPMENHUTANPOBUI1)
    public String getZrnpmenhutanpobui1() {
        return zrnpmenhutanpobui1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnpmenhutanpobui1(String pZrnpmenhutanpobui1) {
        zrnpmenhutanpobui1 = pZrnpmenhutanpobui1;
    }

    private String zrnpmenhutanpokikan1;

    @Column(name=GenZT_SbRituRendouRn.ZRNPMENHUTANPOKIKAN1)
    public String getZrnpmenhutanpokikan1() {
        return zrnpmenhutanpokikan1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnpmenhutanpokikan1(String pZrnpmenhutanpokikan1) {
        zrnpmenhutanpokikan1 = pZrnpmenhutanpokikan1;
    }

    private String zrnpmenhutanpobui2;

    @Column(name=GenZT_SbRituRendouRn.ZRNPMENHUTANPOBUI2)
    public String getZrnpmenhutanpobui2() {
        return zrnpmenhutanpobui2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnpmenhutanpobui2(String pZrnpmenhutanpobui2) {
        zrnpmenhutanpobui2 = pZrnpmenhutanpobui2;
    }

    private String zrnpmenhutanpokikan2;

    @Column(name=GenZT_SbRituRendouRn.ZRNPMENHUTANPOKIKAN2)
    public String getZrnpmenhutanpokikan2() {
        return zrnpmenhutanpokikan2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnpmenhutanpokikan2(String pZrnpmenhutanpokikan2) {
        zrnpmenhutanpokikan2 = pZrnpmenhutanpokikan2;
    }

    private String zrnkanyujidatakanrino;

    @Column(name=GenZT_SbRituRendouRn.ZRNKANYUJIDATAKANRINO)
    public String getZrnkanyujidatakanrino() {
        return zrnkanyujidatakanrino;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnkanyujidatakanrino(String pZrnkanyujidatakanrino) {
        zrnkanyujidatakanrino = pZrnkanyujidatakanrino;
    }

    private String zrnbnktgsnzkkykdatakanrino;

    @Column(name=GenZT_SbRituRendouRn.ZRNBNKTGSNZKKYKDATAKANRINO)
    public String getZrnbnktgsnzkkykdatakanrino() {
        return zrnbnktgsnzkkykdatakanrino;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnbnktgsnzkkykdatakanrino(String pZrnbnktgsnzkkykdatakanrino) {
        zrnbnktgsnzkkykdatakanrino = pZrnbnktgsnzkkykdatakanrino;
    }

    private String zrnkykjiqpackhyj;

    @Column(name=GenZT_SbRituRendouRn.ZRNKYKJIQPACKHYJ)
    public String getZrnkykjiqpackhyj() {
        return zrnkykjiqpackhyj;
    }

    public void setZrnkykjiqpackhyj(String pZrnkykjiqpackhyj) {
        zrnkykjiqpackhyj = pZrnkykjiqpackhyj;
    }

    private String zrnhokensyuruikigouyobi1x1;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X1)
    public String getZrnhokensyuruikigouyobi1x1() {
        return zrnhokensyuruikigouyobi1x1;
    }

    public void setZrnhokensyuruikigouyobi1x1(String pZrnhokensyuruikigouyobi1x1) {
        zrnhokensyuruikigouyobi1x1 = pZrnhokensyuruikigouyobi1x1;
    }

    private String zrnhokensyuruikigouyobi1x2;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X2)
    public String getZrnhokensyuruikigouyobi1x2() {
        return zrnhokensyuruikigouyobi1x2;
    }

    public void setZrnhokensyuruikigouyobi1x2(String pZrnhokensyuruikigouyobi1x2) {
        zrnhokensyuruikigouyobi1x2 = pZrnhokensyuruikigouyobi1x2;
    }

    private String zrnhokensyuruikigouyobi1x3;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X3)
    public String getZrnhokensyuruikigouyobi1x3() {
        return zrnhokensyuruikigouyobi1x3;
    }

    public void setZrnhokensyuruikigouyobi1x3(String pZrnhokensyuruikigouyobi1x3) {
        zrnhokensyuruikigouyobi1x3 = pZrnhokensyuruikigouyobi1x3;
    }

    private String zrnhokensyuruikigouyobi1x4;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X4)
    public String getZrnhokensyuruikigouyobi1x4() {
        return zrnhokensyuruikigouyobi1x4;
    }

    public void setZrnhokensyuruikigouyobi1x4(String pZrnhokensyuruikigouyobi1x4) {
        zrnhokensyuruikigouyobi1x4 = pZrnhokensyuruikigouyobi1x4;
    }

    private String zrnhokensyuruikigouyobi1x5;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X5)
    public String getZrnhokensyuruikigouyobi1x5() {
        return zrnhokensyuruikigouyobi1x5;
    }

    public void setZrnhokensyuruikigouyobi1x5(String pZrnhokensyuruikigouyobi1x5) {
        zrnhokensyuruikigouyobi1x5 = pZrnhokensyuruikigouyobi1x5;
    }

    private String zrnhokensyuruikigouyobi1x6;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X6)
    public String getZrnhokensyuruikigouyobi1x6() {
        return zrnhokensyuruikigouyobi1x6;
    }

    public void setZrnhokensyuruikigouyobi1x6(String pZrnhokensyuruikigouyobi1x6) {
        zrnhokensyuruikigouyobi1x6 = pZrnhokensyuruikigouyobi1x6;
    }

    private String zrnhokensyuruikigouyobi1x7;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X7)
    public String getZrnhokensyuruikigouyobi1x7() {
        return zrnhokensyuruikigouyobi1x7;
    }

    public void setZrnhokensyuruikigouyobi1x7(String pZrnhokensyuruikigouyobi1x7) {
        zrnhokensyuruikigouyobi1x7 = pZrnhokensyuruikigouyobi1x7;
    }

    private String zrnhokensyuruikigouyobi1x8;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X8)
    public String getZrnhokensyuruikigouyobi1x8() {
        return zrnhokensyuruikigouyobi1x8;
    }

    public void setZrnhokensyuruikigouyobi1x8(String pZrnhokensyuruikigouyobi1x8) {
        zrnhokensyuruikigouyobi1x8 = pZrnhokensyuruikigouyobi1x8;
    }

    private String zrnhokensyuruikigouyobi1x9;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X9)
    public String getZrnhokensyuruikigouyobi1x9() {
        return zrnhokensyuruikigouyobi1x9;
    }

    public void setZrnhokensyuruikigouyobi1x9(String pZrnhokensyuruikigouyobi1x9) {
        zrnhokensyuruikigouyobi1x9 = pZrnhokensyuruikigouyobi1x9;
    }

    private String zrnhokensyuruikigouyobi1x10;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X10)
    public String getZrnhokensyuruikigouyobi1x10() {
        return zrnhokensyuruikigouyobi1x10;
    }

    public void setZrnhokensyuruikigouyobi1x10(String pZrnhokensyuruikigouyobi1x10) {
        zrnhokensyuruikigouyobi1x10 = pZrnhokensyuruikigouyobi1x10;
    }

    private String zrnhokensyuruikigouyobi1x11;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X11)
    public String getZrnhokensyuruikigouyobi1x11() {
        return zrnhokensyuruikigouyobi1x11;
    }

    public void setZrnhokensyuruikigouyobi1x11(String pZrnhokensyuruikigouyobi1x11) {
        zrnhokensyuruikigouyobi1x11 = pZrnhokensyuruikigouyobi1x11;
    }

    private String zrnhokensyuruikigouyobi1x12;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X12)
    public String getZrnhokensyuruikigouyobi1x12() {
        return zrnhokensyuruikigouyobi1x12;
    }

    public void setZrnhokensyuruikigouyobi1x12(String pZrnhokensyuruikigouyobi1x12) {
        zrnhokensyuruikigouyobi1x12 = pZrnhokensyuruikigouyobi1x12;
    }

    private String zrnhokensyuruikigouyobi1x13;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X13)
    public String getZrnhokensyuruikigouyobi1x13() {
        return zrnhokensyuruikigouyobi1x13;
    }

    public void setZrnhokensyuruikigouyobi1x13(String pZrnhokensyuruikigouyobi1x13) {
        zrnhokensyuruikigouyobi1x13 = pZrnhokensyuruikigouyobi1x13;
    }

    private String zrnhokensyuruikigouyobi1x14;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X14)
    public String getZrnhokensyuruikigouyobi1x14() {
        return zrnhokensyuruikigouyobi1x14;
    }

    public void setZrnhokensyuruikigouyobi1x14(String pZrnhokensyuruikigouyobi1x14) {
        zrnhokensyuruikigouyobi1x14 = pZrnhokensyuruikigouyobi1x14;
    }

    private String zrnhokensyuruikigouyobi1x15;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI1X15)
    public String getZrnhokensyuruikigouyobi1x15() {
        return zrnhokensyuruikigouyobi1x15;
    }

    public void setZrnhokensyuruikigouyobi1x15(String pZrnhokensyuruikigouyobi1x15) {
        zrnhokensyuruikigouyobi1x15 = pZrnhokensyuruikigouyobi1x15;
    }

    private String zrnhokensyuruikigouyobi2x1;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI2X1)
    public String getZrnhokensyuruikigouyobi2x1() {
        return zrnhokensyuruikigouyobi2x1;
    }

    public void setZrnhokensyuruikigouyobi2x1(String pZrnhokensyuruikigouyobi2x1) {
        zrnhokensyuruikigouyobi2x1 = pZrnhokensyuruikigouyobi2x1;
    }

    private String zrnhokensyuruikigouyobi2x2;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI2X2)
    public String getZrnhokensyuruikigouyobi2x2() {
        return zrnhokensyuruikigouyobi2x2;
    }

    public void setZrnhokensyuruikigouyobi2x2(String pZrnhokensyuruikigouyobi2x2) {
        zrnhokensyuruikigouyobi2x2 = pZrnhokensyuruikigouyobi2x2;
    }

    private String zrnhokensyuruikigouyobi2x3;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI2X3)
    public String getZrnhokensyuruikigouyobi2x3() {
        return zrnhokensyuruikigouyobi2x3;
    }

    public void setZrnhokensyuruikigouyobi2x3(String pZrnhokensyuruikigouyobi2x3) {
        zrnhokensyuruikigouyobi2x3 = pZrnhokensyuruikigouyobi2x3;
    }

    private String zrnhokensyuruikigouyobi2x4;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI2X4)
    public String getZrnhokensyuruikigouyobi2x4() {
        return zrnhokensyuruikigouyobi2x4;
    }

    public void setZrnhokensyuruikigouyobi2x4(String pZrnhokensyuruikigouyobi2x4) {
        zrnhokensyuruikigouyobi2x4 = pZrnhokensyuruikigouyobi2x4;
    }

    private String zrnhokensyuruikigouyobi2x5;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI2X5)
    public String getZrnhokensyuruikigouyobi2x5() {
        return zrnhokensyuruikigouyobi2x5;
    }

    public void setZrnhokensyuruikigouyobi2x5(String pZrnhokensyuruikigouyobi2x5) {
        zrnhokensyuruikigouyobi2x5 = pZrnhokensyuruikigouyobi2x5;
    }

    private String zrnhokensyuruikigouyobi2x6;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI2X6)
    public String getZrnhokensyuruikigouyobi2x6() {
        return zrnhokensyuruikigouyobi2x6;
    }

    public void setZrnhokensyuruikigouyobi2x6(String pZrnhokensyuruikigouyobi2x6) {
        zrnhokensyuruikigouyobi2x6 = pZrnhokensyuruikigouyobi2x6;
    }

    private String zrnhokensyuruikigouyobi2x7;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI2X7)
    public String getZrnhokensyuruikigouyobi2x7() {
        return zrnhokensyuruikigouyobi2x7;
    }

    public void setZrnhokensyuruikigouyobi2x7(String pZrnhokensyuruikigouyobi2x7) {
        zrnhokensyuruikigouyobi2x7 = pZrnhokensyuruikigouyobi2x7;
    }

    private String zrnhokensyuruikigouyobi2x8;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI2X8)
    public String getZrnhokensyuruikigouyobi2x8() {
        return zrnhokensyuruikigouyobi2x8;
    }

    public void setZrnhokensyuruikigouyobi2x8(String pZrnhokensyuruikigouyobi2x8) {
        zrnhokensyuruikigouyobi2x8 = pZrnhokensyuruikigouyobi2x8;
    }

    private String zrnhokensyuruikigouyobi2x9;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI2X9)
    public String getZrnhokensyuruikigouyobi2x9() {
        return zrnhokensyuruikigouyobi2x9;
    }

    public void setZrnhokensyuruikigouyobi2x9(String pZrnhokensyuruikigouyobi2x9) {
        zrnhokensyuruikigouyobi2x9 = pZrnhokensyuruikigouyobi2x9;
    }

    private String zrnhokensyuruikigouyobi2x10;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI2X10)
    public String getZrnhokensyuruikigouyobi2x10() {
        return zrnhokensyuruikigouyobi2x10;
    }

    public void setZrnhokensyuruikigouyobi2x10(String pZrnhokensyuruikigouyobi2x10) {
        zrnhokensyuruikigouyobi2x10 = pZrnhokensyuruikigouyobi2x10;
    }

    private String zrnhokensyuruikigouyobi3x1;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI3X1)
    public String getZrnhokensyuruikigouyobi3x1() {
        return zrnhokensyuruikigouyobi3x1;
    }

    public void setZrnhokensyuruikigouyobi3x1(String pZrnhokensyuruikigouyobi3x1) {
        zrnhokensyuruikigouyobi3x1 = pZrnhokensyuruikigouyobi3x1;
    }

    private String zrnhokensyuruikigouyobi3x2;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI3X2)
    public String getZrnhokensyuruikigouyobi3x2() {
        return zrnhokensyuruikigouyobi3x2;
    }

    public void setZrnhokensyuruikigouyobi3x2(String pZrnhokensyuruikigouyobi3x2) {
        zrnhokensyuruikigouyobi3x2 = pZrnhokensyuruikigouyobi3x2;
    }

    private String zrnhokensyuruikigouyobi3x3;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI3X3)
    public String getZrnhokensyuruikigouyobi3x3() {
        return zrnhokensyuruikigouyobi3x3;
    }

    public void setZrnhokensyuruikigouyobi3x3(String pZrnhokensyuruikigouyobi3x3) {
        zrnhokensyuruikigouyobi3x3 = pZrnhokensyuruikigouyobi3x3;
    }

    private String zrnhokensyuruikigouyobi3x4;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI3X4)
    public String getZrnhokensyuruikigouyobi3x4() {
        return zrnhokensyuruikigouyobi3x4;
    }

    public void setZrnhokensyuruikigouyobi3x4(String pZrnhokensyuruikigouyobi3x4) {
        zrnhokensyuruikigouyobi3x4 = pZrnhokensyuruikigouyobi3x4;
    }

    private String zrnhokensyuruikigouyobi3x5;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI3X5)
    public String getZrnhokensyuruikigouyobi3x5() {
        return zrnhokensyuruikigouyobi3x5;
    }

    public void setZrnhokensyuruikigouyobi3x5(String pZrnhokensyuruikigouyobi3x5) {
        zrnhokensyuruikigouyobi3x5 = pZrnhokensyuruikigouyobi3x5;
    }

    private String zrnhokensyuruikigouyobi3x6;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI3X6)
    public String getZrnhokensyuruikigouyobi3x6() {
        return zrnhokensyuruikigouyobi3x6;
    }

    public void setZrnhokensyuruikigouyobi3x6(String pZrnhokensyuruikigouyobi3x6) {
        zrnhokensyuruikigouyobi3x6 = pZrnhokensyuruikigouyobi3x6;
    }

    private String zrnhokensyuruikigouyobi3x7;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI3X7)
    public String getZrnhokensyuruikigouyobi3x7() {
        return zrnhokensyuruikigouyobi3x7;
    }

    public void setZrnhokensyuruikigouyobi3x7(String pZrnhokensyuruikigouyobi3x7) {
        zrnhokensyuruikigouyobi3x7 = pZrnhokensyuruikigouyobi3x7;
    }

    private String zrnhokensyuruikigouyobi3x8;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI3X8)
    public String getZrnhokensyuruikigouyobi3x8() {
        return zrnhokensyuruikigouyobi3x8;
    }

    public void setZrnhokensyuruikigouyobi3x8(String pZrnhokensyuruikigouyobi3x8) {
        zrnhokensyuruikigouyobi3x8 = pZrnhokensyuruikigouyobi3x8;
    }

    private String zrnhokensyuruikigouyobi3x9;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI3X9)
    public String getZrnhokensyuruikigouyobi3x9() {
        return zrnhokensyuruikigouyobi3x9;
    }

    public void setZrnhokensyuruikigouyobi3x9(String pZrnhokensyuruikigouyobi3x9) {
        zrnhokensyuruikigouyobi3x9 = pZrnhokensyuruikigouyobi3x9;
    }

    private String zrnhokensyuruikigouyobi3x10;

    @Column(name=GenZT_SbRituRendouRn.ZRNHOKENSYURUIKIGOUYOBI3X10)
    public String getZrnhokensyuruikigouyobi3x10() {
        return zrnhokensyuruikigouyobi3x10;
    }

    public void setZrnhokensyuruikigouyobi3x10(String pZrnhokensyuruikigouyobi3x10) {
        zrnhokensyuruikigouyobi3x10 = pZrnhokensyuruikigouyobi3x10;
    }

    private String zrntokuyakukigouyobix1;

    @Column(name=GenZT_SbRituRendouRn.ZRNTOKUYAKUKIGOUYOBIX1)
    public String getZrntokuyakukigouyobix1() {
        return zrntokuyakukigouyobix1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuyakukigouyobix1(String pZrntokuyakukigouyobix1) {
        zrntokuyakukigouyobix1 = pZrntokuyakukigouyobix1;
    }

    private String zrntokuyakukigouyobix2;

    @Column(name=GenZT_SbRituRendouRn.ZRNTOKUYAKUKIGOUYOBIX2)
    public String getZrntokuyakukigouyobix2() {
        return zrntokuyakukigouyobix2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuyakukigouyobix2(String pZrntokuyakukigouyobix2) {
        zrntokuyakukigouyobix2 = pZrntokuyakukigouyobix2;
    }

    private String zrntokuyakukigouyobix3;

    @Column(name=GenZT_SbRituRendouRn.ZRNTOKUYAKUKIGOUYOBIX3)
    public String getZrntokuyakukigouyobix3() {
        return zrntokuyakukigouyobix3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuyakukigouyobix3(String pZrntokuyakukigouyobix3) {
        zrntokuyakukigouyobix3 = pZrntokuyakukigouyobix3;
    }

    private String zrntokuyakukigouyobix4;

    @Column(name=GenZT_SbRituRendouRn.ZRNTOKUYAKUKIGOUYOBIX4)
    public String getZrntokuyakukigouyobix4() {
        return zrntokuyakukigouyobix4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuyakukigouyobix4(String pZrntokuyakukigouyobix4) {
        zrntokuyakukigouyobix4 = pZrntokuyakukigouyobix4;
    }

    private String zrntokuyakukigouyobix5;

    @Column(name=GenZT_SbRituRendouRn.ZRNTOKUYAKUKIGOUYOBIX5)
    public String getZrntokuyakukigouyobix5() {
        return zrntokuyakukigouyobix5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuyakukigouyobix5(String pZrntokuyakukigouyobix5) {
        zrntokuyakukigouyobix5 = pZrntokuyakukigouyobix5;
    }

    private String zrnmaruteikigouyobix1;

    @Column(name=GenZT_SbRituRendouRn.ZRNMARUTEIKIGOUYOBIX1)
    public String getZrnmaruteikigouyobix1() {
        return zrnmaruteikigouyobix1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmaruteikigouyobix1(String pZrnmaruteikigouyobix1) {
        zrnmaruteikigouyobix1 = pZrnmaruteikigouyobix1;
    }

    private String zrnmaruteikigouyobix2;

    @Column(name=GenZT_SbRituRendouRn.ZRNMARUTEIKIGOUYOBIX2)
    public String getZrnmaruteikigouyobix2() {
        return zrnmaruteikigouyobix2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmaruteikigouyobix2(String pZrnmaruteikigouyobix2) {
        zrnmaruteikigouyobix2 = pZrnmaruteikigouyobix2;
    }

    private String zrnmaruteikigouyobix3;

    @Column(name=GenZT_SbRituRendouRn.ZRNMARUTEIKIGOUYOBIX3)
    public String getZrnmaruteikigouyobix3() {
        return zrnmaruteikigouyobix3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmaruteikigouyobix3(String pZrnmaruteikigouyobix3) {
        zrnmaruteikigouyobix3 = pZrnmaruteikigouyobix3;
    }

    private String zrnmaruteikigouyobix4;

    @Column(name=GenZT_SbRituRendouRn.ZRNMARUTEIKIGOUYOBIX4)
    public String getZrnmaruteikigouyobix4() {
        return zrnmaruteikigouyobix4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmaruteikigouyobix4(String pZrnmaruteikigouyobix4) {
        zrnmaruteikigouyobix4 = pZrnmaruteikigouyobix4;
    }

    private String zrnmaruteikigouyobix5;

    @Column(name=GenZT_SbRituRendouRn.ZRNMARUTEIKIGOUYOBIX5)
    public String getZrnmaruteikigouyobix5() {
        return zrnmaruteikigouyobix5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmaruteikigouyobix5(String pZrnmaruteikigouyobix5) {
        zrnmaruteikigouyobix5 = pZrnmaruteikigouyobix5;
    }

    private String zrnsiznmrtikguybx1;

    @Column(name=GenZT_SbRituRendouRn.ZRNSIZNMRTIKGUYBX1)
    public String getZrnsiznmrtikguybx1() {
        return zrnsiznmrtikguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiznmrtikguybx1(String pZrnsiznmrtikguybx1) {
        zrnsiznmrtikguybx1 = pZrnsiznmrtikguybx1;
    }

    private String zrnsiznmrtikguybx2;

    @Column(name=GenZT_SbRituRendouRn.ZRNSIZNMRTIKGUYBX2)
    public String getZrnsiznmrtikguybx2() {
        return zrnsiznmrtikguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiznmrtikguybx2(String pZrnsiznmrtikguybx2) {
        zrnsiznmrtikguybx2 = pZrnsiznmrtikguybx2;
    }

    private String zrnsiznmrtikguybx3;

    @Column(name=GenZT_SbRituRendouRn.ZRNSIZNMRTIKGUYBX3)
    public String getZrnsiznmrtikguybx3() {
        return zrnsiznmrtikguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiznmrtikguybx3(String pZrnsiznmrtikguybx3) {
        zrnsiznmrtikguybx3 = pZrnsiznmrtikguybx3;
    }

    private String zrnsiznmrtikguybx4;

    @Column(name=GenZT_SbRituRendouRn.ZRNSIZNMRTIKGUYBX4)
    public String getZrnsiznmrtikguybx4() {
        return zrnsiznmrtikguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiznmrtikguybx4(String pZrnsiznmrtikguybx4) {
        zrnsiznmrtikguybx4 = pZrnsiznmrtikguybx4;
    }

    private String zrnsiznmrtikguybx5;

    @Column(name=GenZT_SbRituRendouRn.ZRNSIZNMRTIKGUYBX5)
    public String getZrnsiznmrtikguybx5() {
        return zrnsiznmrtikguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiznmrtikguybx5(String pZrnsiznmrtikguybx5) {
        zrnsiznmrtikguybx5 = pZrnsiznmrtikguybx5;
    }

    private String zrnteigenmaruteikigouyobix1;

    @Column(name=GenZT_SbRituRendouRn.ZRNTEIGENMARUTEIKIGOUYOBIX1)
    public String getZrnteigenmaruteikigouyobix1() {
        return zrnteigenmaruteikigouyobix1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnteigenmaruteikigouyobix1(String pZrnteigenmaruteikigouyobix1) {
        zrnteigenmaruteikigouyobix1 = pZrnteigenmaruteikigouyobix1;
    }

    private String zrnteigenmaruteikigouyobix2;

    @Column(name=GenZT_SbRituRendouRn.ZRNTEIGENMARUTEIKIGOUYOBIX2)
    public String getZrnteigenmaruteikigouyobix2() {
        return zrnteigenmaruteikigouyobix2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnteigenmaruteikigouyobix2(String pZrnteigenmaruteikigouyobix2) {
        zrnteigenmaruteikigouyobix2 = pZrnteigenmaruteikigouyobix2;
    }

    private String zrnteigenmaruteikigouyobix3;

    @Column(name=GenZT_SbRituRendouRn.ZRNTEIGENMARUTEIKIGOUYOBIX3)
    public String getZrnteigenmaruteikigouyobix3() {
        return zrnteigenmaruteikigouyobix3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnteigenmaruteikigouyobix3(String pZrnteigenmaruteikigouyobix3) {
        zrnteigenmaruteikigouyobix3 = pZrnteigenmaruteikigouyobix3;
    }

    private String zrnteigenmaruteikigouyobix4;

    @Column(name=GenZT_SbRituRendouRn.ZRNTEIGENMARUTEIKIGOUYOBIX4)
    public String getZrnteigenmaruteikigouyobix4() {
        return zrnteigenmaruteikigouyobix4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnteigenmaruteikigouyobix4(String pZrnteigenmaruteikigouyobix4) {
        zrnteigenmaruteikigouyobix4 = pZrnteigenmaruteikigouyobix4;
    }

    private String zrnteigenmaruteikigouyobix5;

    @Column(name=GenZT_SbRituRendouRn.ZRNTEIGENMARUTEIKIGOUYOBIX5)
    public String getZrnteigenmaruteikigouyobix5() {
        return zrnteigenmaruteikigouyobix5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnteigenmaruteikigouyobix5(String pZrnteigenmaruteikigouyobix5) {
        zrnteigenmaruteikigouyobix5 = pZrnteigenmaruteikigouyobix5;
    }

    private String zrnsyuunyuumrtikguybx1;

    @Column(name=GenZT_SbRituRendouRn.ZRNSYUUNYUUMRTIKGUYBX1)
    public String getZrnsyuunyuumrtikguybx1() {
        return zrnsyuunyuumrtikguybx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyuunyuumrtikguybx1(String pZrnsyuunyuumrtikguybx1) {
        zrnsyuunyuumrtikguybx1 = pZrnsyuunyuumrtikguybx1;
    }

    private String zrnsyuunyuumrtikguybx2;

    @Column(name=GenZT_SbRituRendouRn.ZRNSYUUNYUUMRTIKGUYBX2)
    public String getZrnsyuunyuumrtikguybx2() {
        return zrnsyuunyuumrtikguybx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyuunyuumrtikguybx2(String pZrnsyuunyuumrtikguybx2) {
        zrnsyuunyuumrtikguybx2 = pZrnsyuunyuumrtikguybx2;
    }

    private String zrnsyuunyuumrtikguybx3;

    @Column(name=GenZT_SbRituRendouRn.ZRNSYUUNYUUMRTIKGUYBX3)
    public String getZrnsyuunyuumrtikguybx3() {
        return zrnsyuunyuumrtikguybx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyuunyuumrtikguybx3(String pZrnsyuunyuumrtikguybx3) {
        zrnsyuunyuumrtikguybx3 = pZrnsyuunyuumrtikguybx3;
    }

    private String zrnsyuunyuumrtikguybx4;

    @Column(name=GenZT_SbRituRendouRn.ZRNSYUUNYUUMRTIKGUYBX4)
    public String getZrnsyuunyuumrtikguybx4() {
        return zrnsyuunyuumrtikguybx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyuunyuumrtikguybx4(String pZrnsyuunyuumrtikguybx4) {
        zrnsyuunyuumrtikguybx4 = pZrnsyuunyuumrtikguybx4;
    }

    private String zrnsyuunyuumrtikguybx5;

    @Column(name=GenZT_SbRituRendouRn.ZRNSYUUNYUUMRTIKGUYBX5)
    public String getZrnsyuunyuumrtikguybx5() {
        return zrnsyuunyuumrtikguybx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyuunyuumrtikguybx5(String pZrnsyuunyuumrtikguybx5) {
        zrnsyuunyuumrtikguybx5 = pZrnsyuunyuumrtikguybx5;
    }

    private String zrnsuuriyouyobin5;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN5)
    public String getZrnsuuriyouyobin5() {
        return zrnsuuriyouyobin5;
    }

    @Padding(mode = "left", padChar = '0', length = 5)
    public void setZrnsuuriyouyobin5(String pZrnsuuriyouyobin5) {
        zrnsuuriyouyobin5 = pZrnsuuriyouyobin5;
    }

    private String zrnsuuriyouyobin5x2;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN5X2)
    public String getZrnsuuriyouyobin5x2() {
        return zrnsuuriyouyobin5x2;
    }

    @Padding(mode = "left", padChar = '0', length = 5)
    public void setZrnsuuriyouyobin5x2(String pZrnsuuriyouyobin5x2) {
        zrnsuuriyouyobin5x2 = pZrnsuuriyouyobin5x2;
    }

    private String zrnsuuriyouyobin5x3;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN5X3)
    public String getZrnsuuriyouyobin5x3() {
        return zrnsuuriyouyobin5x3;
    }

    @Padding(mode = "left", padChar = '0', length = 5)
    public void setZrnsuuriyouyobin5x3(String pZrnsuuriyouyobin5x3) {
        zrnsuuriyouyobin5x3 = pZrnsuuriyouyobin5x3;
    }

    private String zrnsuuriyouyobin5x4;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN5X4)
    public String getZrnsuuriyouyobin5x4() {
        return zrnsuuriyouyobin5x4;
    }

    @Padding(mode = "left", padChar = '0', length = 5)
    public void setZrnsuuriyouyobin5x4(String pZrnsuuriyouyobin5x4) {
        zrnsuuriyouyobin5x4 = pZrnsuuriyouyobin5x4;
    }

    private String zrnsuuriyouyobin5x5;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN5X5)
    public String getZrnsuuriyouyobin5x5() {
        return zrnsuuriyouyobin5x5;
    }

    @Padding(mode = "left", padChar = '0', length = 5)
    public void setZrnsuuriyouyobin5x5(String pZrnsuuriyouyobin5x5) {
        zrnsuuriyouyobin5x5 = pZrnsuuriyouyobin5x5;
    }

    private String zrnyobiv2x9;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIV2X9)
    public String getZrnyobiv2x9() {
        return zrnyobiv2x9;
    }

    public void setZrnyobiv2x9(String pZrnyobiv2x9) {
        zrnyobiv2x9 = pZrnyobiv2x9;
    }

    private Integer zrnyobin3x5;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIN3X5)
    public Integer getZrnyobin3x5() {
        return zrnyobin3x5;
    }

    public void setZrnyobin3x5(Integer pZrnyobin3x5) {
        zrnyobin3x5 = pZrnyobin3x5;
    }

    private String zrnsuuriyouyobin1x7;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN1X7)
    public String getZrnsuuriyouyobin1x7() {
        return zrnsuuriyouyobin1x7;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuuriyouyobin1x7(String pZrnsuuriyouyobin1x7) {
        zrnsuuriyouyobin1x7 = pZrnsuuriyouyobin1x7;
    }

    private String zrnyobiv1x11;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIV1X11)
    public String getZrnyobiv1x11() {
        return zrnyobiv1x11;
    }

    public void setZrnyobiv1x11(String pZrnyobiv1x11) {
        zrnyobiv1x11 = pZrnyobiv1x11;
    }

    private String zrnsuuriyouyobin5x6;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN5X6)
    public String getZrnsuuriyouyobin5x6() {
        return zrnsuuriyouyobin5x6;
    }

    @Padding(mode = "left", padChar = '0', length = 5)
    public void setZrnsuuriyouyobin5x6(String pZrnsuuriyouyobin5x6) {
        zrnsuuriyouyobin5x6 = pZrnsuuriyouyobin5x6;
    }

    private String zrndakuhikettikjynsyrikbnx1;

    @Column(name=GenZT_SbRituRendouRn.ZRNDAKUHIKETTIKJYNSYRIKBNX1)
    public String getZrndakuhikettikjynsyrikbnx1() {
        return zrndakuhikettikjynsyrikbnx1;
    }

    public void setZrndakuhikettikjynsyrikbnx1(String pZrndakuhikettikjynsyrikbnx1) {
        zrndakuhikettikjynsyrikbnx1 = pZrndakuhikettikjynsyrikbnx1;
    }

    private String zrndakuhikettikjynsyrikbnx2;

    @Column(name=GenZT_SbRituRendouRn.ZRNDAKUHIKETTIKJYNSYRIKBNX2)
    public String getZrndakuhikettikjynsyrikbnx2() {
        return zrndakuhikettikjynsyrikbnx2;
    }

    public void setZrndakuhikettikjynsyrikbnx2(String pZrndakuhikettikjynsyrikbnx2) {
        zrndakuhikettikjynsyrikbnx2 = pZrndakuhikettikjynsyrikbnx2;
    }

    private String zrndakuhikettikjynsyrikbnx3;

    @Column(name=GenZT_SbRituRendouRn.ZRNDAKUHIKETTIKJYNSYRIKBNX3)
    public String getZrndakuhikettikjynsyrikbnx3() {
        return zrndakuhikettikjynsyrikbnx3;
    }

    public void setZrndakuhikettikjynsyrikbnx3(String pZrndakuhikettikjynsyrikbnx3) {
        zrndakuhikettikjynsyrikbnx3 = pZrndakuhikettikjynsyrikbnx3;
    }

    private String zrndakuhikettikjynsyrikbnx4;

    @Column(name=GenZT_SbRituRendouRn.ZRNDAKUHIKETTIKJYNSYRIKBNX4)
    public String getZrndakuhikettikjynsyrikbnx4() {
        return zrndakuhikettikjynsyrikbnx4;
    }

    public void setZrndakuhikettikjynsyrikbnx4(String pZrndakuhikettikjynsyrikbnx4) {
        zrndakuhikettikjynsyrikbnx4 = pZrndakuhikettikjynsyrikbnx4;
    }

    private String zrndakuhikettikjynsyrikbnx5;

    @Column(name=GenZT_SbRituRendouRn.ZRNDAKUHIKETTIKJYNSYRIKBNX5)
    public String getZrndakuhikettikjynsyrikbnx5() {
        return zrndakuhikettikjynsyrikbnx5;
    }

    public void setZrndakuhikettikjynsyrikbnx5(String pZrndakuhikettikjynsyrikbnx5) {
        zrndakuhikettikjynsyrikbnx5 = pZrndakuhikettikjynsyrikbnx5;
    }

    private String zrnhtnknkykdatakanrinox1;

    @Column(name=GenZT_SbRituRendouRn.ZRNHTNKNKYKDATAKANRINOX1)
    public String getZrnhtnknkykdatakanrinox1() {
        return zrnhtnknkykdatakanrinox1;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnhtnknkykdatakanrinox1(String pZrnhtnknkykdatakanrinox1) {
        zrnhtnknkykdatakanrinox1 = pZrnhtnknkykdatakanrinox1;
    }

    private String zrnhtnknkykdatakanrinox2;

    @Column(name=GenZT_SbRituRendouRn.ZRNHTNKNKYKDATAKANRINOX2)
    public String getZrnhtnknkykdatakanrinox2() {
        return zrnhtnknkykdatakanrinox2;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnhtnknkykdatakanrinox2(String pZrnhtnknkykdatakanrinox2) {
        zrnhtnknkykdatakanrinox2 = pZrnhtnknkykdatakanrinox2;
    }

    private String zrnhtnknkykdatakanrinox3;

    @Column(name=GenZT_SbRituRendouRn.ZRNHTNKNKYKDATAKANRINOX3)
    public String getZrnhtnknkykdatakanrinox3() {
        return zrnhtnknkykdatakanrinox3;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnhtnknkykdatakanrinox3(String pZrnhtnknkykdatakanrinox3) {
        zrnhtnknkykdatakanrinox3 = pZrnhtnknkykdatakanrinox3;
    }

    private String zrnhtnknkykdatakanrinox4;

    @Column(name=GenZT_SbRituRendouRn.ZRNHTNKNKYKDATAKANRINOX4)
    public String getZrnhtnknkykdatakanrinox4() {
        return zrnhtnknkykdatakanrinox4;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnhtnknkykdatakanrinox4(String pZrnhtnknkykdatakanrinox4) {
        zrnhtnknkykdatakanrinox4 = pZrnhtnknkykdatakanrinox4;
    }

    private String zrnhtnknkykdatakanrinox5;

    @Column(name=GenZT_SbRituRendouRn.ZRNHTNKNKYKDATAKANRINOX5)
    public String getZrnhtnknkykdatakanrinox5() {
        return zrnhtnknkykdatakanrinox5;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnhtnknkykdatakanrinox5(String pZrnhtnknkykdatakanrinox5) {
        zrnhtnknkykdatakanrinox5 = pZrnhtnknkykdatakanrinox5;
    }

    private String zrnhtnknkykdatakanrinox6;

    @Column(name=GenZT_SbRituRendouRn.ZRNHTNKNKYKDATAKANRINOX6)
    public String getZrnhtnknkykdatakanrinox6() {
        return zrnhtnknkykdatakanrinox6;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnhtnknkykdatakanrinox6(String pZrnhtnknkykdatakanrinox6) {
        zrnhtnknkykdatakanrinox6 = pZrnhtnknkykdatakanrinox6;
    }

    private String zrnkeiyakusyahoujinkbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNKEIYAKUSYAHOUJINKBN)
    public String getZrnkeiyakusyahoujinkbn() {
        return zrnkeiyakusyahoujinkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkeiyakusyahoujinkbn(String pZrnkeiyakusyahoujinkbn) {
        zrnkeiyakusyahoujinkbn = pZrnkeiyakusyahoujinkbn;
    }

    private String zrnsuuriyouyobin2x3;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN2X3)
    public String getZrnsuuriyouyobin2x3() {
        return zrnsuuriyouyobin2x3;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsuuriyouyobin2x3(String pZrnsuuriyouyobin2x3) {
        zrnsuuriyouyobin2x3 = pZrnsuuriyouyobin2x3;
    }

    private String zrnhyujynkttidkhkttikekkacd;

    @Column(name=GenZT_SbRituRendouRn.ZRNHYUJYNKTTIDKHKTTIKEKKACD)
    public String getZrnhyujynkttidkhkttikekkacd() {
        return zrnhyujynkttidkhkttikekkacd;
    }

    public void setZrnhyujynkttidkhkttikekkacd(String pZrnhyujynkttidkhkttikekkacd) {
        zrnhyujynkttidkhkttikekkacd = pZrnhyujynkttidkhkttikekkacd;
    }

    private String zrnhyujynkttidkhkttiryucdx1;

    @Column(name=GenZT_SbRituRendouRn.ZRNHYUJYNKTTIDKHKTTIRYUCDX1)
    public String getZrnhyujynkttidkhkttiryucdx1() {
        return zrnhyujynkttidkhkttiryucdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhyujynkttidkhkttiryucdx1(String pZrnhyujynkttidkhkttiryucdx1) {
        zrnhyujynkttidkhkttiryucdx1 = pZrnhyujynkttidkhkttiryucdx1;
    }

    private String zrnhyujynkttidkhkttiryucdx2;

    @Column(name=GenZT_SbRituRendouRn.ZRNHYUJYNKTTIDKHKTTIRYUCDX2)
    public String getZrnhyujynkttidkhkttiryucdx2() {
        return zrnhyujynkttidkhkttiryucdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhyujynkttidkhkttiryucdx2(String pZrnhyujynkttidkhkttiryucdx2) {
        zrnhyujynkttidkhkttiryucdx2 = pZrnhyujynkttidkhkttiryucdx2;
    }

    private String zrnhyujynkttidkhkttiryucdx3;

    @Column(name=GenZT_SbRituRendouRn.ZRNHYUJYNKTTIDKHKTTIRYUCDX3)
    public String getZrnhyujynkttidkhkttiryucdx3() {
        return zrnhyujynkttidkhkttiryucdx3;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhyujynkttidkhkttiryucdx3(String pZrnhyujynkttidkhkttiryucdx3) {
        zrnhyujynkttidkhkttiryucdx3 = pZrnhyujynkttidkhkttiryucdx3;
    }

    private String zrnhyujynkttidkhkttiryucdx4;

    @Column(name=GenZT_SbRituRendouRn.ZRNHYUJYNKTTIDKHKTTIRYUCDX4)
    public String getZrnhyujynkttidkhkttiryucdx4() {
        return zrnhyujynkttidkhkttiryucdx4;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhyujynkttidkhkttiryucdx4(String pZrnhyujynkttidkhkttiryucdx4) {
        zrnhyujynkttidkhkttiryucdx4 = pZrnhyujynkttidkhkttiryucdx4;
    }

    private Integer zrnhyujynkttiryumshyutn;

    @Column(name=GenZT_SbRituRendouRn.ZRNHYUJYNKTTIRYUMSHYUTN)
    public Integer getZrnhyujynkttiryumshyutn() {
        return zrnhyujynkttiryumshyutn;
    }

    public void setZrnhyujynkttiryumshyutn(Integer pZrnhyujynkttiryumshyutn) {
        zrnhyujynkttiryumshyutn = pZrnhyujynkttiryumshyutn;
    }

    private String zrnhyujynkttisakugenkkn;

    @Column(name=GenZT_SbRituRendouRn.ZRNHYUJYNKTTISAKUGENKKN)
    public String getZrnhyujynkttisakugenkkn() {
        return zrnhyujynkttisakugenkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhyujynkttisakugenkkn(String pZrnhyujynkttisakugenkkn) {
        zrnhyujynkttisakugenkkn = pZrnhyujynkttisakugenkkn;
    }

    private Integer zrnsppitkykryumshyutn;

    @Column(name=GenZT_SbRituRendouRn.ZRNSPPITKYKRYUMSHYUTN)
    public Integer getZrnsppitkykryumshyutn() {
        return zrnsppitkykryumshyutn;
    }

    public void setZrnsppitkykryumshyutn(Integer pZrnsppitkykryumshyutn) {
        zrnsppitkykryumshyutn = pZrnsppitkykryumshyutn;
    }

    private String zrnhyujynkttitktbuicdx1;

    @Column(name=GenZT_SbRituRendouRn.ZRNHYUJYNKTTITKTBUICDX1)
    public String getZrnhyujynkttitktbuicdx1() {
        return zrnhyujynkttitktbuicdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhyujynkttitktbuicdx1(String pZrnhyujynkttitktbuicdx1) {
        zrnhyujynkttitktbuicdx1 = pZrnhyujynkttitktbuicdx1;
    }

    private String zrnhyujynkttihutanpokknx1;

    @Column(name=GenZT_SbRituRendouRn.ZRNHYUJYNKTTIHUTANPOKKNX1)
    public String getZrnhyujynkttihutanpokknx1() {
        return zrnhyujynkttihutanpokknx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhyujynkttihutanpokknx1(String pZrnhyujynkttihutanpokknx1) {
        zrnhyujynkttihutanpokknx1 = pZrnhyujynkttihutanpokknx1;
    }

    private String zrnhyujynkttitktbuicdx2;

    @Column(name=GenZT_SbRituRendouRn.ZRNHYUJYNKTTITKTBUICDX2)
    public String getZrnhyujynkttitktbuicdx2() {
        return zrnhyujynkttitktbuicdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhyujynkttitktbuicdx2(String pZrnhyujynkttitktbuicdx2) {
        zrnhyujynkttitktbuicdx2 = pZrnhyujynkttitktbuicdx2;
    }

    private String zrnhyujynkttihutanpokknx2;

    @Column(name=GenZT_SbRituRendouRn.ZRNHYUJYNKTTIHUTANPOKKNX2)
    public String getZrnhyujynkttihutanpokknx2() {
        return zrnhyujynkttihutanpokknx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhyujynkttihutanpokknx2(String pZrnhyujynkttihutanpokknx2) {
        zrnhyujynkttihutanpokknx2 = pZrnhyujynkttihutanpokknx2;
    }

    private String zrnjyoukentukitaisyoukbnx1;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYOUKENTUKITAISYOUKBNX1)
    public String getZrnjyoukentukitaisyoukbnx1() {
        return zrnjyoukentukitaisyoukbnx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjyoukentukitaisyoukbnx1(String pZrnjyoukentukitaisyoukbnx1) {
        zrnjyoukentukitaisyoukbnx1 = pZrnjyoukentukitaisyoukbnx1;
    }

    private String zrnjyukntksseigenhyjx1;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYUKNTKSSEIGENHYJX1)
    public String getZrnjyukntksseigenhyjx1() {
        return zrnjyukntksseigenhyjx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjyukntksseigenhyjx1(String pZrnjyukntksseigenhyjx1) {
        zrnjyukntksseigenhyjx1 = pZrnjyukntksseigenhyjx1;
    }

    private String zrnjyukntktkyknozokihyjx1;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYUKNTKTKYKNOZOKIHYJX1)
    public String getZrnjyukntktkyknozokihyjx1() {
        return zrnjyukntktkyknozokihyjx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjyukntktkyknozokihyjx1(String pZrnjyukntktkyknozokihyjx1) {
        zrnjyukntktkyknozokihyjx1 = pZrnjyukntktkyknozokihyjx1;
    }

    private String zrnsuuriyouyobin1x8;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN1X8)
    public String getZrnsuuriyouyobin1x8() {
        return zrnsuuriyouyobin1x8;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuuriyouyobin1x8(String pZrnsuuriyouyobin1x8) {
        zrnsuuriyouyobin1x8 = pZrnsuuriyouyobin1x8;
    }

    private Long zrnjyoukentukiseigensx1;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYOUKENTUKISEIGENSX1)
    public Long getZrnjyoukentukiseigensx1() {
        return zrnjyoukentukiseigensx1;
    }

    public void setZrnjyoukentukiseigensx1(Long pZrnjyoukentukiseigensx1) {
        zrnjyoukentukiseigensx1 = pZrnjyoukentukiseigensx1;
    }

    private String zrnjyoukentukitaisyoukbnx2;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYOUKENTUKITAISYOUKBNX2)
    public String getZrnjyoukentukitaisyoukbnx2() {
        return zrnjyoukentukitaisyoukbnx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjyoukentukitaisyoukbnx2(String pZrnjyoukentukitaisyoukbnx2) {
        zrnjyoukentukitaisyoukbnx2 = pZrnjyoukentukitaisyoukbnx2;
    }

    private String zrnjyukntksseigenhyjx2;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYUKNTKSSEIGENHYJX2)
    public String getZrnjyukntksseigenhyjx2() {
        return zrnjyukntksseigenhyjx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjyukntksseigenhyjx2(String pZrnjyukntksseigenhyjx2) {
        zrnjyukntksseigenhyjx2 = pZrnjyukntksseigenhyjx2;
    }

    private String zrnjyukntktkyknozokihyjx2;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYUKNTKTKYKNOZOKIHYJX2)
    public String getZrnjyukntktkyknozokihyjx2() {
        return zrnjyukntktkyknozokihyjx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjyukntktkyknozokihyjx2(String pZrnjyukntktkyknozokihyjx2) {
        zrnjyukntktkyknozokihyjx2 = pZrnjyukntktkyknozokihyjx2;
    }

    private String zrnsuuriyouyobin1x9;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN1X9)
    public String getZrnsuuriyouyobin1x9() {
        return zrnsuuriyouyobin1x9;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuuriyouyobin1x9(String pZrnsuuriyouyobin1x9) {
        zrnsuuriyouyobin1x9 = pZrnsuuriyouyobin1x9;
    }

    private Long zrnjyoukentukiseigensx2;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYOUKENTUKISEIGENSX2)
    public Long getZrnjyoukentukiseigensx2() {
        return zrnjyoukentukiseigensx2;
    }

    public void setZrnjyoukentukiseigensx2(Long pZrnjyoukentukiseigensx2) {
        zrnjyoukentukiseigensx2 = pZrnjyoukentukiseigensx2;
    }

    private String zrnjyoukentukitaisyoukbnx3;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYOUKENTUKITAISYOUKBNX3)
    public String getZrnjyoukentukitaisyoukbnx3() {
        return zrnjyoukentukitaisyoukbnx3;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjyoukentukitaisyoukbnx3(String pZrnjyoukentukitaisyoukbnx3) {
        zrnjyoukentukitaisyoukbnx3 = pZrnjyoukentukitaisyoukbnx3;
    }

    private String zrnjyukntksseigenhyjx3;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYUKNTKSSEIGENHYJX3)
    public String getZrnjyukntksseigenhyjx3() {
        return zrnjyukntksseigenhyjx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjyukntksseigenhyjx3(String pZrnjyukntksseigenhyjx3) {
        zrnjyukntksseigenhyjx3 = pZrnjyukntksseigenhyjx3;
    }

    private String zrnjyukntktkyknozokihyjx3;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYUKNTKTKYKNOZOKIHYJX3)
    public String getZrnjyukntktkyknozokihyjx3() {
        return zrnjyukntktkyknozokihyjx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjyukntktkyknozokihyjx3(String pZrnjyukntktkyknozokihyjx3) {
        zrnjyukntktkyknozokihyjx3 = pZrnjyukntktkyknozokihyjx3;
    }

    private String zrnsuuriyouyobin1x10;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN1X10)
    public String getZrnsuuriyouyobin1x10() {
        return zrnsuuriyouyobin1x10;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuuriyouyobin1x10(String pZrnsuuriyouyobin1x10) {
        zrnsuuriyouyobin1x10 = pZrnsuuriyouyobin1x10;
    }

    private Long zrnjyoukentukiseigensx3;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYOUKENTUKISEIGENSX3)
    public Long getZrnjyoukentukiseigensx3() {
        return zrnjyoukentukiseigensx3;
    }

    public void setZrnjyoukentukiseigensx3(Long pZrnjyoukentukiseigensx3) {
        zrnjyoukentukiseigensx3 = pZrnjyoukentukiseigensx3;
    }

    private String zrnjyoukentukitaisyoukbnx4;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYOUKENTUKITAISYOUKBNX4)
    public String getZrnjyoukentukitaisyoukbnx4() {
        return zrnjyoukentukitaisyoukbnx4;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjyoukentukitaisyoukbnx4(String pZrnjyoukentukitaisyoukbnx4) {
        zrnjyoukentukitaisyoukbnx4 = pZrnjyoukentukitaisyoukbnx4;
    }

    private String zrnjyukntksseigenhyjx4;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYUKNTKSSEIGENHYJX4)
    public String getZrnjyukntksseigenhyjx4() {
        return zrnjyukntksseigenhyjx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjyukntksseigenhyjx4(String pZrnjyukntksseigenhyjx4) {
        zrnjyukntksseigenhyjx4 = pZrnjyukntksseigenhyjx4;
    }

    private String zrnjyukntktkyknozokihyjx4;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYUKNTKTKYKNOZOKIHYJX4)
    public String getZrnjyukntktkyknozokihyjx4() {
        return zrnjyukntktkyknozokihyjx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjyukntktkyknozokihyjx4(String pZrnjyukntktkyknozokihyjx4) {
        zrnjyukntktkyknozokihyjx4 = pZrnjyukntktkyknozokihyjx4;
    }

    private String zrnsuuriyouyobin1x11;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN1X11)
    public String getZrnsuuriyouyobin1x11() {
        return zrnsuuriyouyobin1x11;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuuriyouyobin1x11(String pZrnsuuriyouyobin1x11) {
        zrnsuuriyouyobin1x11 = pZrnsuuriyouyobin1x11;
    }

    private Long zrnjyoukentukiseigensx4;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYOUKENTUKISEIGENSX4)
    public Long getZrnjyoukentukiseigensx4() {
        return zrnjyoukentukiseigensx4;
    }

    public void setZrnjyoukentukiseigensx4(Long pZrnjyoukentukiseigensx4) {
        zrnjyoukentukiseigensx4 = pZrnjyoukentukiseigensx4;
    }

    private String zrnjyukntkkigtiksyrihnkuhyj;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYUKNTKKIGTIKSYRIHNKUHYJ)
    public String getZrnjyukntkkigtiksyrihnkuhyj() {
        return zrnjyukntkkigtiksyrihnkuhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjyukntkkigtiksyrihnkuhyj(String pZrnjyukntkkigtiksyrihnkuhyj) {
        zrnjyukntkkigtiksyrihnkuhyj = pZrnjyukntkkigtiksyrihnkuhyj;
    }

    private String zrnpmensyuruihenkoukbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNPMENSYURUIHENKOUKBN)
    public String getZrnpmensyuruihenkoukbn() {
        return zrnpmensyuruihenkoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnpmensyuruihenkoukbn(String pZrnpmensyuruihenkoukbn) {
        zrnpmensyuruihenkoukbn = pZrnpmensyuruihenkoukbn;
    }

    private String zrnjyoukentukitaisyoukbn2x1;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYOUKENTUKITAISYOUKBN2X1)
    public String getZrnjyoukentukitaisyoukbn2x1() {
        return zrnjyoukentukitaisyoukbn2x1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjyoukentukitaisyoukbn2x1(String pZrnjyoukentukitaisyoukbn2x1) {
        zrnjyoukentukitaisyoukbn2x1 = pZrnjyoukentukitaisyoukbn2x1;
    }

    private String zrnjyukntksseigenhyj2x1;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYUKNTKSSEIGENHYJ2X1)
    public String getZrnjyukntksseigenhyj2x1() {
        return zrnjyukntksseigenhyj2x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjyukntksseigenhyj2x1(String pZrnjyukntksseigenhyj2x1) {
        zrnjyukntksseigenhyj2x1 = pZrnjyukntksseigenhyj2x1;
    }

    private String zrnjyukntktkyknozokihyj2x1;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYUKNTKTKYKNOZOKIHYJ2X1)
    public String getZrnjyukntktkyknozokihyj2x1() {
        return zrnjyukntktkyknozokihyj2x1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjyukntktkyknozokihyj2x1(String pZrnjyukntktkyknozokihyj2x1) {
        zrnjyukntktkyknozokihyj2x1 = pZrnjyukntktkyknozokihyj2x1;
    }

    private String zrnsuuriyouyobin1x12;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN1X12)
    public String getZrnsuuriyouyobin1x12() {
        return zrnsuuriyouyobin1x12;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuuriyouyobin1x12(String pZrnsuuriyouyobin1x12) {
        zrnsuuriyouyobin1x12 = pZrnsuuriyouyobin1x12;
    }

    private Long zrnjyoukentukiseigens2x1;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYOUKENTUKISEIGENS2X1)
    public Long getZrnjyoukentukiseigens2x1() {
        return zrnjyoukentukiseigens2x1;
    }

    public void setZrnjyoukentukiseigens2x1(Long pZrnjyoukentukiseigens2x1) {
        zrnjyoukentukiseigens2x1 = pZrnjyoukentukiseigens2x1;
    }

    private String zrnjyoukentukitaisyoukbn2x2;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYOUKENTUKITAISYOUKBN2X2)
    public String getZrnjyoukentukitaisyoukbn2x2() {
        return zrnjyoukentukitaisyoukbn2x2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjyoukentukitaisyoukbn2x2(String pZrnjyoukentukitaisyoukbn2x2) {
        zrnjyoukentukitaisyoukbn2x2 = pZrnjyoukentukitaisyoukbn2x2;
    }

    private String zrnjyukntksseigenhyj2x2;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYUKNTKSSEIGENHYJ2X2)
    public String getZrnjyukntksseigenhyj2x2() {
        return zrnjyukntksseigenhyj2x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjyukntksseigenhyj2x2(String pZrnjyukntksseigenhyj2x2) {
        zrnjyukntksseigenhyj2x2 = pZrnjyukntksseigenhyj2x2;
    }

    private String zrnjyukntktkyknozokihyj2x2;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYUKNTKTKYKNOZOKIHYJ2X2)
    public String getZrnjyukntktkyknozokihyj2x2() {
        return zrnjyukntktkyknozokihyj2x2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjyukntktkyknozokihyj2x2(String pZrnjyukntktkyknozokihyj2x2) {
        zrnjyukntktkyknozokihyj2x2 = pZrnjyukntktkyknozokihyj2x2;
    }

    private String zrnsuuriyouyobin1x13;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN1X13)
    public String getZrnsuuriyouyobin1x13() {
        return zrnsuuriyouyobin1x13;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuuriyouyobin1x13(String pZrnsuuriyouyobin1x13) {
        zrnsuuriyouyobin1x13 = pZrnsuuriyouyobin1x13;
    }

    private Long zrnjyoukentukiseigens2x2;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYOUKENTUKISEIGENS2X2)
    public Long getZrnjyoukentukiseigens2x2() {
        return zrnjyoukentukiseigens2x2;
    }

    public void setZrnjyoukentukiseigens2x2(Long pZrnjyoukentukiseigens2x2) {
        zrnjyoukentukiseigens2x2 = pZrnjyoukentukiseigens2x2;
    }

    private String zrnjyoukentukitaisyoukbn2x3;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYOUKENTUKITAISYOUKBN2X3)
    public String getZrnjyoukentukitaisyoukbn2x3() {
        return zrnjyoukentukitaisyoukbn2x3;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjyoukentukitaisyoukbn2x3(String pZrnjyoukentukitaisyoukbn2x3) {
        zrnjyoukentukitaisyoukbn2x3 = pZrnjyoukentukitaisyoukbn2x3;
    }

    private String zrnjyukntksseigenhyj2x3;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYUKNTKSSEIGENHYJ2X3)
    public String getZrnjyukntksseigenhyj2x3() {
        return zrnjyukntksseigenhyj2x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjyukntksseigenhyj2x3(String pZrnjyukntksseigenhyj2x3) {
        zrnjyukntksseigenhyj2x3 = pZrnjyukntksseigenhyj2x3;
    }

    private String zrnjyukntktkyknozokihyj2x3;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYUKNTKTKYKNOZOKIHYJ2X3)
    public String getZrnjyukntktkyknozokihyj2x3() {
        return zrnjyukntktkyknozokihyj2x3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjyukntktkyknozokihyj2x3(String pZrnjyukntktkyknozokihyj2x3) {
        zrnjyukntktkyknozokihyj2x3 = pZrnjyukntktkyknozokihyj2x3;
    }

    private String zrnsuuriyouyobin1x14;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN1X14)
    public String getZrnsuuriyouyobin1x14() {
        return zrnsuuriyouyobin1x14;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuuriyouyobin1x14(String pZrnsuuriyouyobin1x14) {
        zrnsuuriyouyobin1x14 = pZrnsuuriyouyobin1x14;
    }

    private Long zrnjyoukentukiseigens2x3;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYOUKENTUKISEIGENS2X3)
    public Long getZrnjyoukentukiseigens2x3() {
        return zrnjyoukentukiseigens2x3;
    }

    public void setZrnjyoukentukiseigens2x3(Long pZrnjyoukentukiseigens2x3) {
        zrnjyoukentukiseigens2x3 = pZrnjyoukentukiseigens2x3;
    }

    private String zrnjyoukentukitaisyoukbn2x4;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYOUKENTUKITAISYOUKBN2X4)
    public String getZrnjyoukentukitaisyoukbn2x4() {
        return zrnjyoukentukitaisyoukbn2x4;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnjyoukentukitaisyoukbn2x4(String pZrnjyoukentukitaisyoukbn2x4) {
        zrnjyoukentukitaisyoukbn2x4 = pZrnjyoukentukitaisyoukbn2x4;
    }

    private String zrnjyukntksseigenhyj2x4;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYUKNTKSSEIGENHYJ2X4)
    public String getZrnjyukntksseigenhyj2x4() {
        return zrnjyukntksseigenhyj2x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjyukntksseigenhyj2x4(String pZrnjyukntksseigenhyj2x4) {
        zrnjyukntksseigenhyj2x4 = pZrnjyukntksseigenhyj2x4;
    }

    private String zrnjyukntktkyknozokihyj2x4;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYUKNTKTKYKNOZOKIHYJ2X4)
    public String getZrnjyukntktkyknozokihyj2x4() {
        return zrnjyukntktkyknozokihyj2x4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjyukntktkyknozokihyj2x4(String pZrnjyukntktkyknozokihyj2x4) {
        zrnjyukntktkyknozokihyj2x4 = pZrnjyukntktkyknozokihyj2x4;
    }

    private String zrnsuuriyouyobin1x15;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN1X15)
    public String getZrnsuuriyouyobin1x15() {
        return zrnsuuriyouyobin1x15;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuuriyouyobin1x15(String pZrnsuuriyouyobin1x15) {
        zrnsuuriyouyobin1x15 = pZrnsuuriyouyobin1x15;
    }

    private Long zrnjyoukentukiseigens2x4;

    @Column(name=GenZT_SbRituRendouRn.ZRNJYOUKENTUKISEIGENS2X4)
    public Long getZrnjyoukentukiseigens2x4() {
        return zrnjyoukentukiseigens2x4;
    }

    public void setZrnjyoukentukiseigens2x4(Long pZrnjyoukentukiseigens2x4) {
        zrnjyoukentukiseigens2x4 = pZrnjyoukentukiseigens2x4;
    }

    private Integer zrntktsppiryumshyutn;

    @Column(name=GenZT_SbRituRendouRn.ZRNTKTSPPIRYUMSHYUTN)
    public Integer getZrntktsppiryumshyutn() {
        return zrntktsppiryumshyutn;
    }

    public void setZrntktsppiryumshyutn(Integer pZrntktsppiryumshyutn) {
        zrntktsppiryumshyutn = pZrntktsppiryumshyutn;
    }

    private String zrntktsppiskgnkkn;

    @Column(name=GenZT_SbRituRendouRn.ZRNTKTSPPISKGNKKN)
    public String getZrntktsppiskgnkkn() {
        return zrntktsppiskgnkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntktsppiskgnkkn(String pZrntktsppiskgnkkn) {
        zrntktsppiskgnkkn = pZrntktsppiskgnkkn;
    }

    private Integer zrnmnsiskknryumshyutn;

    @Column(name=GenZT_SbRituRendouRn.ZRNMNSISKKNRYUMSHYUTN)
    public Integer getZrnmnsiskknryumshyutn() {
        return zrnmnsiskknryumshyutn;
    }

    public void setZrnmnsiskknryumshyutn(Integer pZrnmnsiskknryumshyutn) {
        zrnmnsiskknryumshyutn = pZrnmnsiskknryumshyutn;
    }

    private String zrnmanseisikkansakugenkikan;

    @Column(name=GenZT_SbRituRendouRn.ZRNMANSEISIKKANSAKUGENKIKAN)
    public String getZrnmanseisikkansakugenkikan() {
        return zrnmanseisikkansakugenkikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnmanseisikkansakugenkikan(String pZrnmanseisikkansakugenkikan) {
        zrnmanseisikkansakugenkikan = pZrnmanseisikkansakugenkikan;
    }

    private String zrnmanseisikkantokuteibuicd;

    @Column(name=GenZT_SbRituRendouRn.ZRNMANSEISIKKANTOKUTEIBUICD)
    public String getZrnmanseisikkantokuteibuicd() {
        return zrnmanseisikkantokuteibuicd;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnmanseisikkantokuteibuicd(String pZrnmanseisikkantokuteibuicd) {
        zrnmanseisikkantokuteibuicd = pZrnmanseisikkantokuteibuicd;
    }

    private String zrnmanseisikkanhutanpokikan;

    @Column(name=GenZT_SbRituRendouRn.ZRNMANSEISIKKANHUTANPOKIKAN)
    public String getZrnmanseisikkanhutanpokikan() {
        return zrnmanseisikkanhutanpokikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnmanseisikkanhutanpokikan(String pZrnmanseisikkanhutanpokikan) {
        zrnmanseisikkanhutanpokikan = pZrnmanseisikkanhutanpokikan;
    }

    private String zrnsaihokenkbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNSAIHOKENKBN)
    public String getZrnsaihokenkbn() {
        return zrnsaihokenkbn;
    }

    public void setZrnsaihokenkbn(String pZrnsaihokenkbn) {
        zrnsaihokenkbn = pZrnsaihokenkbn;
    }

    private Integer zrnimustiyusbus;

    @Column(name=GenZT_SbRituRendouRn.ZRNIMUSTIYUSBUS)
    public Integer getZrnimustiyusbus() {
        return zrnimustiyusbus;
    }

    public void setZrnimustiyusbus(Integer pZrnimustiyusbus) {
        zrnimustiyusbus = pZrnimustiyusbus;
    }

    private Long zrnimusateiyoujissituhsyus;

    @Column(name=GenZT_SbRituRendouRn.ZRNIMUSATEIYOUJISSITUHSYUS)
    public Long getZrnimusateiyoujissituhsyus() {
        return zrnimusateiyoujissituhsyus;
    }

    public void setZrnimusateiyoujissituhsyus(Long pZrnimusateiyoujissituhsyus) {
        zrnimusateiyoujissituhsyus = pZrnimusateiyoujissituhsyus;
    }

    private Long zrnisahtnkngukijissituhsyus;

    @Column(name=GenZT_SbRituRendouRn.ZRNISAHTNKNGUKIJISSITUHSYUS)
    public Long getZrnisahtnkngukijissituhsyus() {
        return zrnisahtnkngukijissituhsyus;
    }

    public void setZrnisahtnkngukijissituhsyus(Long pZrnisahtnkngukijissituhsyus) {
        zrnisahtnkngukijissituhsyus = pZrnisahtnkngukijissituhsyus;
    }

    private Long zrnimusateiyoutenkansagakus;

    @Column(name=GenZT_SbRituRendouRn.ZRNIMUSATEIYOUTENKANSAGAKUS)
    public Long getZrnimusateiyoutenkansagakus() {
        return zrnimusateiyoutenkansagakus;
    }

    public void setZrnimusateiyoutenkansagakus(Long pZrnimusateiyoutenkansagakus) {
        zrnimusateiyoutenkansagakus = pZrnimusateiyoutenkansagakus;
    }

    private String zrnimusateiyouhanbaikirkbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNIMUSATEIYOUHANBAIKIRKBN)
    public String getZrnimusateiyouhanbaikirkbn() {
        return zrnimusateiyouhanbaikirkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnimusateiyouhanbaikirkbn(String pZrnimusateiyouhanbaikirkbn) {
        zrnimusateiyouhanbaikirkbn = pZrnimusateiyouhanbaikirkbn;
    }

    private String zrnoyabosyuudairitencd;

    @Column(name=GenZT_SbRituRendouRn.ZRNOYABOSYUUDAIRITENCD)
    public String getZrnoyabosyuudairitencd() {
        return zrnoyabosyuudairitencd;
    }

    public void setZrnoyabosyuudairitencd(String pZrnoyabosyuudairitencd) {
        zrnoyabosyuudairitencd = pZrnoyabosyuudairitencd;
    }

    private String zrnsuuriyoubosyuukeitaikbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUBOSYUUKEITAIKBN)
    public String getZrnsuuriyoubosyuukeitaikbn() {
        return zrnsuuriyoubosyuukeitaikbn;
    }

    public void setZrnsuuriyoubosyuukeitaikbn(String pZrnsuuriyoubosyuukeitaikbn) {
        zrnsuuriyoubosyuukeitaikbn = pZrnsuuriyoubosyuukeitaikbn;
    }

    private String zrnhihokensyahokenage;

    @Column(name=GenZT_SbRituRendouRn.ZRNHIHOKENSYAHOKENAGE)
    public String getZrnhihokensyahokenage() {
        return zrnhihokensyahokenage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhihokensyahokenage(String pZrnhihokensyahokenage) {
        zrnhihokensyahokenage = pZrnhihokensyahokenage;
    }

    private String zrnrendouyoumusntkkykhyj;

    @Column(name=GenZT_SbRituRendouRn.ZRNRENDOUYOUMUSNTKKYKHYJ)
    public String getZrnrendouyoumusntkkykhyj() {
        return zrnrendouyoumusntkkykhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnrendouyoumusntkkykhyj(String pZrnrendouyoumusntkkykhyj) {
        zrnrendouyoumusntkkykhyj = pZrnrendouyoumusntkkykhyj;
    }

    private String zrnyobiv2x11;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIV2X11)
    public String getZrnyobiv2x11() {
        return zrnyobiv2x11;
    }

    public void setZrnyobiv2x11(String pZrnyobiv2x11) {
        zrnyobiv2x11 = pZrnyobiv2x11;
    }

    private Integer zrnyobin3x6;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIN3X6)
    public Integer getZrnyobin3x6() {
        return zrnyobin3x6;
    }

    public void setZrnyobin3x6(Integer pZrnyobin3x6) {
        zrnyobin3x6 = pZrnyobin3x6;
    }

    private String zrnsuuriyouyobin9x4;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN9X4)
    public String getZrnsuuriyouyobin9x4() {
        return zrnsuuriyouyobin9x4;
    }

    @Padding(mode = "left", padChar = '0', length = 9)
    public void setZrnsuuriyouyobin9x4(String pZrnsuuriyouyobin9x4) {
        zrnsuuriyouyobin9x4 = pZrnsuuriyouyobin9x4;
    }

    private String zrnyobiv1x20;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIV1X20)
    public String getZrnyobiv1x20() {
        return zrnyobiv1x20;
    }

    public void setZrnyobiv1x20(String pZrnyobiv1x20) {
        zrnyobiv1x20 = pZrnyobiv1x20;
    }

    private String zrnsuuriyouyobin5x7;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN5X7)
    public String getZrnsuuriyouyobin5x7() {
        return zrnsuuriyouyobin5x7;
    }

    @Padding(mode = "left", padChar = '0', length = 5)
    public void setZrnsuuriyouyobin5x7(String pZrnsuuriyouyobin5x7) {
        zrnsuuriyouyobin5x7 = pZrnsuuriyouyobin5x7;
    }

    private String zrnhhknnentysihyj;

    @Column(name=GenZT_SbRituRendouRn.ZRNHHKNNENTYSIHYJ)
    public String getZrnhhknnentysihyj() {
        return zrnhhknnentysihyj;
    }

    public void setZrnhhknnentysihyj(String pZrnhhknnentysihyj) {
        zrnhhknnentysihyj = pZrnhhknnentysihyj;
    }

    private String zrnsindenzusyokensyousaicd;

    @Column(name=GenZT_SbRituRendouRn.ZRNSINDENZUSYOKENSYOUSAICD)
    public String getZrnsindenzusyokensyousaicd() {
        return zrnsindenzusyokensyousaicd;
    }

    public void setZrnsindenzusyokensyousaicd(String pZrnsindenzusyokensyousaicd) {
        zrnsindenzusyokensyousaicd = pZrnsindenzusyokensyousaicd;
    }

    private String zrnimstiyuktekknsjsshyj;

    @Column(name=GenZT_SbRituRendouRn.ZRNIMSTIYUKTEKKNSJSSHYJ)
    public String getZrnimstiyuktekknsjsshyj() {
        return zrnimstiyuktekknsjsshyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnimstiyuktekknsjsshyj(String pZrnimstiyuktekknsjsshyj) {
        zrnimstiyuktekknsjsshyj = pZrnimstiyuktekknsjsshyj;
    }

    private String zrnketuekikensasekkekkyuusu;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSASEKKEKKYUUSU)
    public String getZrnketuekikensasekkekkyuusu() {
        return zrnketuekikensasekkekkyuusu;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnketuekikensasekkekkyuusu(String pZrnketuekikensasekkekkyuusu) {
        zrnketuekikensasekkekkyuusu = pZrnketuekikensasekkekkyuusu;
    }

    private String zrnktekknsskkkkyususykncd;

    @Column(name=GenZT_SbRituRendouRn.ZRNKTEKKNSSKKKKYUSUSYKNCD)
    public String getZrnktekknsskkkkyususykncd() {
        return zrnktekknsskkkkyususykncd;
    }

    public void setZrnktekknsskkkkyususykncd(String pZrnktekknsskkkkyususykncd) {
        zrnktekknsskkkkyususykncd = pZrnktekknsskkkkyususykncd;
    }

    private String zrnketuekikensahakkekkyuusu;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAHAKKEKKYUUSU)
    public String getZrnketuekikensahakkekkyuusu() {
        return zrnketuekikensahakkekkyuusu;
    }

    @Padding(mode = "left", padChar = '0', length = 5)
    public void setZrnketuekikensahakkekkyuusu(String pZrnketuekikensahakkekkyuusu) {
        zrnketuekikensahakkekkyuusu = pZrnketuekikensahakkekkyuusu;
    }

    private String zrnktekknshkkkkyususykncd;

    @Column(name=GenZT_SbRituRendouRn.ZRNKTEKKNSHKKKKYUSUSYKNCD)
    public String getZrnktekknshkkkkyususykncd() {
        return zrnktekknshkkkkyususykncd;
    }

    public void setZrnktekknshkkkkyususykncd(String pZrnktekknshkkkkyususykncd) {
        zrnktekknshkkkkyususykncd = pZrnktekknshkkkkyususykncd;
    }

    private BizNumber zrnktekknsketusikisoryou;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouRn.ZRNKTEKKNSKETUSIKISORYOU)
    public BizNumber getZrnktekknsketusikisoryou() {
        return zrnktekknsketusikisoryou;
    }

    public void setZrnktekknsketusikisoryou(BizNumber pZrnktekknsketusikisoryou) {
        zrnktekknsketusikisoryou = pZrnktekknsketusikisoryou;
    }

    private String zrnktekknsktsksryusyokencd;

    @Column(name=GenZT_SbRituRendouRn.ZRNKTEKKNSKTSKSRYUSYOKENCD)
    public String getZrnktekknsktsksryusyokencd() {
        return zrnktekknsktsksryusyokencd;
    }

    public void setZrnktekknsktsksryusyokencd(String pZrnktekknsktsksryusyokencd) {
        zrnktekknsktsksryusyokencd = pZrnktekknsktsksryusyokencd;
    }

    private BizNumber zrnktekknshematokuritto;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouRn.ZRNKTEKKNSHEMATOKURITTO)
    public BizNumber getZrnktekknshematokuritto() {
        return zrnktekknshematokuritto;
    }

    public void setZrnktekknshematokuritto(BizNumber pZrnktekknshematokuritto) {
        zrnktekknshematokuritto = pZrnktekknshematokuritto;
    }

    private String zrnktekhmtkrttsykncd;

    @Column(name=GenZT_SbRituRendouRn.ZRNKTEKHMTKRTTSYKNCD)
    public String getZrnktekhmtkrttsykncd() {
        return zrnktekhmtkrttsykncd;
    }

    public void setZrnktekhmtkrttsykncd(String pZrnktekhmtkrttsykncd) {
        zrnktekhmtkrttsykncd = pZrnktekhmtkrttsykncd;
    }

    private BizNumber zrnketuekikensakessyoubansu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAKESSYOUBANSU)
    public BizNumber getZrnketuekikensakessyoubansu() {
        return zrnketuekikensakessyoubansu;
    }

    public void setZrnketuekikensakessyoubansu(BizNumber pZrnketuekikensakessyoubansu) {
        zrnketuekikensakessyoubansu = pZrnketuekikensakessyoubansu;
    }

    private String zrnktekknskssyubnsusyokencd;

    @Column(name=GenZT_SbRituRendouRn.ZRNKTEKKNSKSSYUBNSUSYOKENCD)
    public String getZrnktekknskssyubnsusyokencd() {
        return zrnktekknskssyubnsusyokencd;
    }

    public void setZrnktekknskssyubnsusyokencd(String pZrnktekknskssyubnsusyokencd) {
        zrnktekknskssyubnsusyokencd = pZrnktekknskssyubnsusyokencd;
    }

    private BizNumber zrnktekknskssisutnpkryu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouRn.ZRNKTEKKNSKSSISUTNPKRYU)
    public BizNumber getZrnktekknskssisutnpkryu() {
        return zrnktekknskssisutnpkryu;
    }

    public void setZrnktekknskssisutnpkryu(BizNumber pZrnktekknskssisutnpkryu) {
        zrnktekknskssisutnpkryu = pZrnktekknskssisutnpkryu;
    }

    private String zrnktekkssisutnpkryusykncd;

    @Column(name=GenZT_SbRituRendouRn.ZRNKTEKKSSISUTNPKRYUSYKNCD)
    public String getZrnktekkssisutnpkryusykncd() {
        return zrnktekkssisutnpkryusykncd;
    }

    public void setZrnktekkssisutnpkryusykncd(String pZrnktekkssisutnpkryusykncd) {
        zrnktekkssisutnpkryusykncd = pZrnktekkssisutnpkryusykncd;
    }

    private BizNumber zrnketuekikensaarubumin;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAARUBUMIN)
    public BizNumber getZrnketuekikensaarubumin() {
        return zrnketuekikensaarubumin;
    }

    public void setZrnketuekikensaarubumin(BizNumber pZrnketuekikensaarubumin) {
        zrnketuekikensaarubumin = pZrnketuekikensaarubumin;
    }

    private String zrnktekknsarubuminsyokencd;

    @Column(name=GenZT_SbRituRendouRn.ZRNKTEKKNSARUBUMINSYOKENCD)
    public String getZrnktekknsarubuminsyokencd() {
        return zrnktekknsarubuminsyokencd;
    }

    public void setZrnktekknsarubuminsyokencd(String pZrnktekknsarubuminsyokencd) {
        zrnktekknsarubuminsyokencd = pZrnktekknsarubuminsyokencd;
    }

    private BizNumber zrnketuekikensaztt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAZTT)
    public BizNumber getZrnketuekikensaztt() {
        return zrnketuekikensaztt;
    }

    public void setZrnketuekikensaztt(BizNumber pZrnketuekikensaztt) {
        zrnketuekikensaztt = pZrnketuekikensaztt;
    }

    private String zrnketuekikensazttsyokencd;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAZTTSYOKENCD)
    public String getZrnketuekikensazttsyokencd() {
        return zrnketuekikensazttsyokencd;
    }

    public void setZrnketuekikensazttsyokencd(String pZrnketuekikensazttsyokencd) {
        zrnketuekikensazttsyokencd = pZrnketuekikensazttsyokencd;
    }

    private String zrnketuekikensagot;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAGOT)
    public String getZrnketuekikensagot() {
        return zrnketuekikensagot;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnketuekikensagot(String pZrnketuekikensagot) {
        zrnketuekikensagot = pZrnketuekikensagot;
    }

    private String zrnketuekikensagotsyokencd;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAGOTSYOKENCD)
    public String getZrnketuekikensagotsyokencd() {
        return zrnketuekikensagotsyokencd;
    }

    public void setZrnketuekikensagotsyokencd(String pZrnketuekikensagotsyokencd) {
        zrnketuekikensagotsyokencd = pZrnketuekikensagotsyokencd;
    }

    private String zrnketuekikensagpt;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAGPT)
    public String getZrnketuekikensagpt() {
        return zrnketuekikensagpt;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnketuekikensagpt(String pZrnketuekikensagpt) {
        zrnketuekikensagpt = pZrnketuekikensagpt;
    }

    private String zrnketuekikensagptsyokencd;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAGPTSYOKENCD)
    public String getZrnketuekikensagptsyokencd() {
        return zrnketuekikensagptsyokencd;
    }

    public void setZrnketuekikensagptsyokencd(String pZrnketuekikensagptsyokencd) {
        zrnketuekikensagptsyokencd = pZrnketuekikensagptsyokencd;
    }

    private String zrnketuekikensaganmagtp;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAGANMAGTP)
    public String getZrnketuekikensaganmagtp() {
        return zrnketuekikensaganmagtp;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnketuekikensaganmagtp(String pZrnketuekikensaganmagtp) {
        zrnketuekikensaganmagtp = pZrnketuekikensaganmagtp;
    }

    private String zrnketuekiganmagtpsyokencd;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIGANMAGTPSYOKENCD)
    public String getZrnketuekiganmagtpsyokencd() {
        return zrnketuekiganmagtpsyokencd;
    }

    public void setZrnketuekiganmagtpsyokencd(String pZrnketuekiganmagtpsyokencd) {
        zrnketuekiganmagtpsyokencd = pZrnketuekiganmagtpsyokencd;
    }

    private String zrnketuekikensasouchol;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSASOUCHOL)
    public String getZrnketuekikensasouchol() {
        return zrnketuekikensasouchol;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnketuekikensasouchol(String pZrnketuekikensasouchol) {
        zrnketuekikensasouchol = pZrnketuekikensasouchol;
    }

    private String zrnketuekicholsyokencd;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKICHOLSYOKENCD)
    public String getZrnketuekicholsyokencd() {
        return zrnketuekicholsyokencd;
    }

    public void setZrnketuekicholsyokencd(String pZrnketuekicholsyokencd) {
        zrnketuekicholsyokencd = pZrnketuekicholsyokencd;
    }

    private String zrnketuekikensahdlchol;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAHDLCHOL)
    public String getZrnketuekikensahdlchol() {
        return zrnketuekikensahdlchol;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnketuekikensahdlchol(String pZrnketuekikensahdlchol) {
        zrnketuekikensahdlchol = pZrnketuekikensahdlchol;
    }

    private String zrnketuekikensahdlsyokencd;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAHDLSYOKENCD)
    public String getZrnketuekikensahdlsyokencd() {
        return zrnketuekikensahdlsyokencd;
    }

    public void setZrnketuekikensahdlsyokencd(String pZrnketuekikensahdlsyokencd) {
        zrnketuekikensahdlsyokencd = pZrnketuekikensahdlsyokencd;
    }

    private BizNumber zrnktekknstukhmgrbn;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouRn.ZRNKTEKKNSTUKHMGRBN)
    public BizNumber getZrnktekknstukhmgrbn() {
        return zrnktekknstukhmgrbn;
    }

    public void setZrnktekknstukhmgrbn(BizNumber pZrnktekknstukhmgrbn) {
        zrnktekknstukhmgrbn = pZrnktekknstukhmgrbn;
    }

    private String zrnktekhmgrbnsykncd;

    @Column(name=GenZT_SbRituRendouRn.ZRNKTEKHMGRBNSYKNCD)
    public String getZrnktekhmgrbnsykncd() {
        return zrnktekhmgrbnsykncd;
    }

    public void setZrnktekhmgrbnsykncd(String pZrnktekhmgrbnsykncd) {
        zrnktekhmgrbnsykncd = pZrnktekhmgrbnsykncd;
    }

    private String zrnktekknskorinesuterrze;

    @Column(name=GenZT_SbRituRendouRn.ZRNKTEKKNSKORINESUTERRZE)
    public String getZrnktekknskorinesuterrze() {
        return zrnktekknskorinesuterrze;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnktekknskorinesuterrze(String pZrnktekknskorinesuterrze) {
        zrnktekknskorinesuterrze = pZrnktekknskorinesuterrze;
    }

    private String zrnkorinesuterrzesyokencd;

    @Column(name=GenZT_SbRituRendouRn.ZRNKORINESUTERRZESYOKENCD)
    public String getZrnkorinesuterrzesyokencd() {
        return zrnkorinesuterrzesyokencd;
    }

    public void setZrnkorinesuterrzesyokencd(String pZrnkorinesuterrzesyokencd) {
        zrnkorinesuterrzesyokencd = pZrnkorinesuterrzesyokencd;
    }

    private BizNumber zrnketuekikensamcv;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAMCV)
    public BizNumber getZrnketuekikensamcv() {
        return zrnketuekikensamcv;
    }

    public void setZrnketuekikensamcv(BizNumber pZrnketuekikensamcv) {
        zrnketuekikensamcv = pZrnketuekikensamcv;
    }

    private String zrnketuekikensamcvsyokencd;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAMCVSYOKENCD)
    public String getZrnketuekikensamcvsyokencd() {
        return zrnketuekikensamcvsyokencd;
    }

    public void setZrnketuekikensamcvsyokencd(String pZrnketuekikensamcvsyokencd) {
        zrnketuekikensamcvsyokencd = pZrnketuekikensamcvsyokencd;
    }

    private BizNumber zrnketuekikensamch;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAMCH)
    public BizNumber getZrnketuekikensamch() {
        return zrnketuekikensamch;
    }

    public void setZrnketuekikensamch(BizNumber pZrnketuekikensamch) {
        zrnketuekikensamch = pZrnketuekikensamch;
    }

    private String zrnketuekikensamchsyokencd;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAMCHSYOKENCD)
    public String getZrnketuekikensamchsyokencd() {
        return zrnketuekikensamchsyokencd;
    }

    public void setZrnketuekikensamchsyokencd(String pZrnketuekikensamchsyokencd) {
        zrnketuekikensamchsyokencd = pZrnketuekikensamchsyokencd;
    }

    private BizNumber zrnketuekikensamchc;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAMCHC)
    public BizNumber getZrnketuekikensamchc() {
        return zrnketuekikensamchc;
    }

    public void setZrnketuekikensamchc(BizNumber pZrnketuekikensamchc) {
        zrnketuekikensamchc = pZrnketuekikensamchc;
    }

    private String zrnketuekikensamchcsyokencd;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAMCHCSYOKENCD)
    public String getZrnketuekikensamchcsyokencd() {
        return zrnketuekikensamchcsyokencd;
    }

    public void setZrnketuekikensamchcsyokencd(String pZrnketuekikensamchcsyokencd) {
        zrnketuekikensamchcsyokencd = pZrnketuekikensamchcsyokencd;
    }

    private BizNumber zrnketuekikensacea;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSACEA)
    public BizNumber getZrnketuekikensacea() {
        return zrnketuekikensacea;
    }

    public void setZrnketuekikensacea(BizNumber pZrnketuekikensacea) {
        zrnketuekikensacea = pZrnketuekikensacea;
    }

    private String zrnketuekikensaceasyokencd;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSACEASYOKENCD)
    public String getZrnketuekikensaceasyokencd() {
        return zrnketuekikensaceasyokencd;
    }

    public void setZrnketuekikensaceasyokencd(String pZrnketuekikensaceasyokencd) {
        zrnketuekikensaceasyokencd = pZrnketuekikensaceasyokencd;
    }

    private BizNumber zrnketuekikensaafp;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAAFP)
    public BizNumber getZrnketuekikensaafp() {
        return zrnketuekikensaafp;
    }

    public void setZrnketuekikensaafp(BizNumber pZrnketuekikensaafp) {
        zrnketuekikensaafp = pZrnketuekikensaafp;
    }

    private String zrnketuekikensaafpsyokencd;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAAFPSYOKENCD)
    public String getZrnketuekikensaafpsyokencd() {
        return zrnketuekikensaafpsyokencd;
    }

    public void setZrnketuekikensaafpsyokencd(String pZrnketuekikensaafpsyokencd) {
        zrnketuekikensaafpsyokencd = pZrnketuekikensaafpsyokencd;
    }

    private String zrnketuekikensahbskbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAHBSKBN)
    public String getZrnketuekikensahbskbn() {
        return zrnketuekikensahbskbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnketuekikensahbskbn(String pZrnketuekikensahbskbn) {
        zrnketuekikensahbskbn = pZrnketuekikensahbskbn;
    }

    private String zrnketuekikensahbssyokencd;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAHBSSYOKENCD)
    public String getZrnketuekikensahbssyokencd() {
        return zrnketuekikensahbssyokencd;
    }

    public void setZrnketuekikensahbssyokencd(String pZrnketuekikensahbssyokencd) {
        zrnketuekikensahbssyokencd = pZrnketuekikensahbssyokencd;
    }

    private String zrnketuekikensahcvkbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAHCVKBN)
    public String getZrnketuekikensahcvkbn() {
        return zrnketuekikensahcvkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnketuekikensahcvkbn(String pZrnketuekikensahcvkbn) {
        zrnketuekikensahcvkbn = pZrnketuekikensahcvkbn;
    }

    private String zrnketuekikensahcvsyokencd;

    @Column(name=GenZT_SbRituRendouRn.ZRNKETUEKIKENSAHCVSYOKENCD)
    public String getZrnketuekikensahcvsyokencd() {
        return zrnketuekikensahcvsyokencd;
    }

    public void setZrnketuekikensahcvsyokencd(String pZrnketuekikensahcvsyokencd) {
        zrnketuekikensahcvsyokencd = pZrnketuekikensahcvsyokencd;
    }

    private String zrnimusateiyouknsnsytryskbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNIMUSATEIYOUKNSNSYTRYSKBN)
    public String getZrnimusateiyouknsnsytryskbn() {
        return zrnimusateiyouknsnsytryskbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnimusateiyouknsnsytryskbn(String pZrnimusateiyouknsnsytryskbn) {
        zrnimusateiyouknsnsytryskbn = pZrnimusateiyouknsnsytryskbn;
    }

    private String zrnsyosinldlchol;

    @Column(name=GenZT_SbRituRendouRn.ZRNSYOSINLDLCHOL)
    public String getZrnsyosinldlchol() {
        return zrnsyosinldlchol;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnsyosinldlchol(String pZrnsyosinldlchol) {
        zrnsyosinldlchol = pZrnsyosinldlchol;
    }

    private String zrntokuteijyoutaihushrhyj;

    @Column(name=GenZT_SbRituRendouRn.ZRNTOKUTEIJYOUTAIHUSHRHYJ)
    public String getZrntokuteijyoutaihushrhyj() {
        return zrntokuteijyoutaihushrhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuteijyoutaihushrhyj(String pZrntokuteijyoutaihushrhyj) {
        zrntokuteijyoutaihushrhyj = pZrntokuteijyoutaihushrhyj;
    }

    private Integer zrnrendouyouosyukeiyakup;

    @Column(name=GenZT_SbRituRendouRn.ZRNRENDOUYOUOSYUKEIYAKUP)
    public Integer getZrnrendouyouosyukeiyakup() {
        return zrnrendouyouosyukeiyakup;
    }

    public void setZrnrendouyouosyukeiyakup(Integer pZrnrendouyouosyukeiyakup) {
        zrnrendouyouosyukeiyakup = pZrnrendouyouosyukeiyakup;
    }

    private String zrntokubetuhosyoukikan;

    @Column(name=GenZT_SbRituRendouRn.ZRNTOKUBETUHOSYOUKIKAN)
    public String getZrntokubetuhosyoukikan() {
        return zrntokubetuhosyoukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntokubetuhosyoukikan(String pZrntokubetuhosyoukikan) {
        zrntokubetuhosyoukikan = pZrntokubetuhosyoukikan;
    }

    private Integer zrnrendouyougoukeitenkans;

    @Column(name=GenZT_SbRituRendouRn.ZRNRENDOUYOUGOUKEITENKANS)
    public Integer getZrnrendouyougoukeitenkans() {
        return zrnrendouyougoukeitenkans;
    }

    public void setZrnrendouyougoukeitenkans(Integer pZrnrendouyougoukeitenkans) {
        zrnrendouyougoukeitenkans = pZrnrendouyougoukeitenkans;
    }

    private Integer zrnrnduyugukitnknkakaku;

    @Column(name=GenZT_SbRituRendouRn.ZRNRNDUYUGUKITNKNKAKAKU)
    public Integer getZrnrnduyugukitnknkakaku() {
        return zrnrnduyugukitnknkakaku;
    }

    public void setZrnrnduyugukitnknkakaku(Integer pZrnrnduyugukitnknkakaku) {
        zrnrnduyugukitnknkakaku = pZrnrnduyugukitnknkakaku;
    }

    private Integer zrnrnduyuwnsgukitnknkakaku;

    @Column(name=GenZT_SbRituRendouRn.ZRNRNDUYUWNSGUKITNKNKAKAKU)
    public Integer getZrnrnduyuwnsgukitnknkakaku() {
        return zrnrnduyuwnsgukitnknkakaku;
    }

    public void setZrnrnduyuwnsgukitnknkakaku(Integer pZrnrnduyuwnsgukitnknkakaku) {
        zrnrnduyuwnsgukitnknkakaku = pZrnrnduyuwnsgukitnknkakaku;
    }

    private BizNumber zrnmostnknkhnbbnjyuturt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouRn.ZRNMOSTNKNKHNBBNJYUTURT)
    public BizNumber getZrnmostnknkhnbbnjyuturt() {
        return zrnmostnknkhnbbnjyuturt;
    }

    public void setZrnmostnknkhnbbnjyuturt(BizNumber pZrnmostnknkhnbbnjyuturt) {
        zrnmostnknkhnbbnjyuturt = pZrnmostnknkhnbbnjyuturt;
    }

    private Integer zrnrnduyusykykbbnkhns;

    @Column(name=GenZT_SbRituRendouRn.ZRNRNDUYUSYKYKBBNKHNS)
    public Integer getZrnrnduyusykykbbnkhns() {
        return zrnrnduyusykykbbnkhns;
    }

    public void setZrnrnduyusykykbbnkhns(Integer pZrnrnduyusykykbbnkhns) {
        zrnrnduyusykykbbnkhns = pZrnrnduyusykykbbnkhns;
    }

    private BizNumber zrnrendouyouyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouRn.ZRNRENDOUYOUYOTEIRIRITU)
    public BizNumber getZrnrendouyouyoteiriritu() {
        return zrnrendouyouyoteiriritu;
    }

    public void setZrnrendouyouyoteiriritu(BizNumber pZrnrendouyouyoteiriritu) {
        zrnrendouyouyoteiriritu = pZrnrendouyouyoteiriritu;
    }

    private String zrnknkuzusnzyrt;

    @Column(name=GenZT_SbRituRendouRn.ZRNKNKUZUSNZYRT)
    public String getZrnknkuzusnzyrt() {
        return zrnknkuzusnzyrt;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnknkuzusnzyrt(String pZrnknkuzusnzyrt) {
        zrnknkuzusnzyrt = pZrnknkuzusnzyrt;
    }

    private String zrnyobiv121;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIV121)
    public String getZrnyobiv121() {
        return zrnyobiv121;
    }

    public void setZrnyobiv121(String pZrnyobiv121) {
        zrnyobiv121 = pZrnyobiv121;
    }

    private String zrnraysystemhyj;

    @Column(name=GenZT_SbRituRendouRn.ZRNRAYSYSTEMHYJ)
    public String getZrnraysystemhyj() {
        return zrnraysystemhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnraysystemhyj(String pZrnraysystemhyj) {
        zrnraysystemhyj = pZrnraysystemhyj;
    }

    private String zrngaikakbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNGAIKAKBN)
    public String getZrngaikakbn() {
        return zrngaikakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngaikakbn(String pZrngaikakbn) {
        zrngaikakbn = pZrngaikakbn;
    }

    private Long zrngaikadatekihons;

    @Column(name=GenZT_SbRituRendouRn.ZRNGAIKADATEKIHONS)
    public Long getZrngaikadatekihons() {
        return zrngaikadatekihons;
    }

    public void setZrngaikadatekihons(Long pZrngaikadatekihons) {
        zrngaikadatekihons = pZrngaikadatekihons;
    }

    private Long zrngaikadatesibous;

    @Column(name=GenZT_SbRituRendouRn.ZRNGAIKADATESIBOUS)
    public Long getZrngaikadatesibous() {
        return zrngaikadatesibous;
    }

    public void setZrngaikadatesibous(Long pZrngaikadatesibous) {
        zrngaikadatesibous = pZrngaikadatesibous;
    }

    private BizNumber zrnkeiyakujiyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouRn.ZRNKEIYAKUJIYOTEIRIRITU)
    public BizNumber getZrnkeiyakujiyoteiriritu() {
        return zrnkeiyakujiyoteiriritu;
    }

    public void setZrnkeiyakujiyoteiriritu(BizNumber pZrnkeiyakujiyoteiriritu) {
        zrnkeiyakujiyoteiriritu = pZrnkeiyakujiyoteiriritu;
    }

    private BizNumber zrnkawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SbRituRendouRn.ZRNKAWASERATE)
    public BizNumber getZrnkawaserate() {
        return zrnkawaserate;
    }

    public void setZrnkawaserate(BizNumber pZrnkawaserate) {
        zrnkawaserate = pZrnkawaserate;
    }

    private String zrnkawaseratetekiyouymd;

    @Column(name=GenZT_SbRituRendouRn.ZRNKAWASERATETEKIYOUYMD)
    public String getZrnkawaseratetekiyouymd() {
        return zrnkawaseratetekiyouymd;
    }

    public void setZrnkawaseratetekiyouymd(String pZrnkawaseratetekiyouymd) {
        zrnkawaseratetekiyouymd = pZrnkawaseratetekiyouymd;
    }

    private Long zrnenkdtsbujsitihsyukngk;

    @Column(name=GenZT_SbRituRendouRn.ZRNENKDTSBUJSITIHSYUKNGK)
    public Long getZrnenkdtsbujsitihsyukngk() {
        return zrnenkdtsbujsitihsyukngk;
    }

    public void setZrnenkdtsbujsitihsyukngk(Long pZrnenkdtsbujsitihsyukngk) {
        zrnenkdtsbujsitihsyukngk = pZrnenkdtsbujsitihsyukngk;
    }

    private String zrnsrdai1hknkkn;

    @Column(name=GenZT_SbRituRendouRn.ZRNSRDAI1HKNKKN)
    public String getZrnsrdai1hknkkn() {
        return zrnsrdai1hknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsrdai1hknkkn(String pZrnsrdai1hknkkn) {
        zrnsrdai1hknkkn = pZrnsrdai1hknkkn;
    }

    private String zrnsuuriyouyobin8;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN8)
    public String getZrnsuuriyouyobin8() {
        return zrnsuuriyouyobin8;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnsuuriyouyobin8(String pZrnsuuriyouyobin8) {
        zrnsuuriyouyobin8 = pZrnsuuriyouyobin8;
    }

    private String zrnsuuriyouyobin10x2;

    @Column(name=GenZT_SbRituRendouRn.ZRNSUURIYOUYOBIN10X2)
    public String getZrnsuuriyouyobin10x2() {
        return zrnsuuriyouyobin10x2;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnsuuriyouyobin10x2(String pZrnsuuriyouyobin10x2) {
        zrnsuuriyouyobin10x2 = pZrnsuuriyouyobin10x2;
    }

    private String zrntuukasyukbn;

    @Column(name=GenZT_SbRituRendouRn.ZRNTUUKASYUKBN)
    public String getZrntuukasyukbn() {
        return zrntuukasyukbn;
    }

    public void setZrntuukasyukbn(String pZrntuukasyukbn) {
        zrntuukasyukbn = pZrntuukasyukbn;
    }

    private String zrnyobiv9;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIV9)
    public String getZrnyobiv9() {
        return zrnyobiv9;
    }

    public void setZrnyobiv9(String pZrnyobiv9) {
        zrnyobiv9 = pZrnyobiv9;
    }

    private String zrnyobiv10x4;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIV10X4)
    public String getZrnyobiv10x4() {
        return zrnyobiv10x4;
    }

    public void setZrnyobiv10x4(String pZrnyobiv10x4) {
        zrnyobiv10x4 = pZrnyobiv10x4;
    }

    private Integer zrnyobin7;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIN7)
    public Integer getZrnyobin7() {
        return zrnyobin7;
    }

    public void setZrnyobin7(Integer pZrnyobin7) {
        zrnyobin7 = pZrnyobin7;
    }

    private Integer zrnyobin7x2;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIN7X2)
    public Integer getZrnyobin7x2() {
        return zrnyobin7x2;
    }

    public void setZrnyobin7x2(Integer pZrnyobin7x2) {
        zrnyobin7x2 = pZrnyobin7x2;
    }

    private Integer zrnyobin7x3;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIN7X3)
    public Integer getZrnyobin7x3() {
        return zrnyobin7x3;
    }

    public void setZrnyobin7x3(Integer pZrnyobin7x3) {
        zrnyobin7x3 = pZrnyobin7x3;
    }

    private Integer zrnyobin7x4;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIN7X4)
    public Integer getZrnyobin7x4() {
        return zrnyobin7x4;
    }

    public void setZrnyobin7x4(Integer pZrnyobin7x4) {
        zrnyobin7x4 = pZrnyobin7x4;
    }

    private Integer zrnyobin7x5;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIN7X5)
    public Integer getZrnyobin7x5() {
        return zrnyobin7x5;
    }

    public void setZrnyobin7x5(Integer pZrnyobin7x5) {
        zrnyobin7x5 = pZrnyobin7x5;
    }

    private String zrnyobiv4x2;

    @Column(name=GenZT_SbRituRendouRn.ZRNYOBIV4X2)
    public String getZrnyobiv4x2() {
        return zrnyobiv4x2;
    }

    public void setZrnyobiv4x2(String pZrnyobiv4x2) {
        zrnyobiv4x2 = pZrnyobiv4x2;
    }
}