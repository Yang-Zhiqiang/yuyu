package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_DrtenTsryInfoRn;
import yuyu.def.db.mapping.GenZT_DrtenTsryInfoRn;
import yuyu.def.db.meta.GenQZT_DrtenTsryInfoRn;
import yuyu.def.db.meta.QZT_DrtenTsryInfoRn;

/**
 * 代理店手数料情報Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DrtenTsryInfoRn}</td><td colspan="3">代理店手数料情報Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrndairitencd zrndairitencd}</td><td>（連携用）代理店コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnbosyuunincd zrnbosyuunincd}</td><td>（連携用）募集人コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeiyakukbn</td><td>（連携用）契約区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakuno</td><td>（連携用）特約番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsyym</td><td>（連携用）募集年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykymd</td><td>（連携用）契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkydatkibosyuucd</td><td>（連携用）共同扱募集人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseiritujibumoncd</td><td>（連携用）成立時部門コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseiritujiagutiknrcd</td><td>（連携用）成立時代理店内管理扱者コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv1</td><td>（連携用）予備項目Ｖ１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkydeigyouakojincd</td><td>（連携用）共同扱営業員Ａ扱者個人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkydeigyoubkojincd</td><td>（連携用）共同扱営業員Ｂ扱者個人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskeihyj</td><td>（連携用）新契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndenymd</td><td>（連携用）伝票日付</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkikaisyoriymd zrnkikaisyoriymd}</td><td>（連携用）機械処理年月日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoricd</td><td>（連携用）処理コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntyouseijiyuu</td><td>（連携用）調整事由</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyknmonth</td><td>（連携用）入金月数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsikibetujyunjyo zrnsikibetujyunjyo}</td><td>（連携用）識別順序</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntnsmacezugkukbn</td><td>（連携用）たのしみＡｃｅ増額区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnacezugkkrykkaisiymd</td><td>（連携用）Ａｃｅ増額効力開始年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv4</td><td>（連携用）予備項目Ｖ４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkykmfksnctrlkh zrnkykmfksnctrlkh}</td><td>（連携用）契約ＭＦ更新ＣＴＲ（保全）</td><td align="center">○</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrndairitenatkikeitaikbn</td><td>（連携用）代理店扱形態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnatkiwari</td><td>（連携用）扱割合</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrndairitenatkinin</td><td>（連携用）代理店扱人数</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntsrkeisansyukykhsyos</td><td>（連携用）手数料計算用主契約保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhtns</td><td>（連携用）被転換Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkijymods</td><td>（連携用）計上修正Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnksnbubunmods</td><td>（連携用）加算部分修正Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnbfrkijymods</td><td>（連携用）変更前計上修正Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnbfrksnbubunmods</td><td>（連携用）変更前加算部分修正Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhknsyukigou</td><td>（連携用）保険種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyuruikigousedaikbn</td><td>（連携用）保険種類記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntksyukgu</td><td>（連携用）特約種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntksyukgusedaikbn</td><td>（連携用）特約種類記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkaisuukbn</td><td>（連携用）払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnannaifuyouriyuukbn</td><td>（連携用）案内不要理由区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnen2keta</td><td>（連携用）被保険者年令（２桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknkkn</td><td>（連携用）保険期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnfstkeijyouhtkm</td><td>（連携用）初回計上判定項目</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsrytsryhushrkbn</td><td>（連携用）手数料不支払区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbfritijibrzugkp</td><td>（連携用）変更前一時払増額Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnmaruteisyuruikigou</td><td>（連携用）マル定種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmrtihukakbn</td><td>（連携用）マル定付加区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsznmrtihukakbn</td><td>（連携用）生存マル定付加区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteigenmrtihukakbn</td><td>（連携用）逓減マル定付加区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyunyumrtihukakbn</td><td>（連携用）収入マル定付加区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzkmrtihukakbn</td><td>（連携用）家族マル定付加区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntoksipmrtihukakbn</td><td>（連携用）特定疾病マル定付加区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntoksipmrsyhukakbn</td><td>（連携用）特定疾病マル終付加区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmanskknmrtihukakbn</td><td>（連携用）慢性疾患マル定付加区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkigsyunyumrtihukakbn</td><td>（連携用）介護収入マル定付加区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkigteigenmrtihukakbn</td><td>（連携用）介護逓減マル定付加区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkignktkhukakbn</td><td>（連携用）介護年金特約付加区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkigmrtihukakbn</td><td>（連携用）介護マル定付加区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmrtisyukguyobiv1</td><td>（連携用）マル定種類記号予備１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmrtisyukguyobiv1x2</td><td>（連携用）マル定種類記号予備２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmrtisyukguyobiv1x3</td><td>（連携用）マル定種類記号予備３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmrtisyukguyobiv1x4</td><td>（連携用）マル定種類記号予備４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmrtisyukguyobiv1x5</td><td>（連携用）マル定種類記号予備５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv1x2</td><td>（連携用）予備項目Ｖ１＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyknm</td><td>（連携用）契約者名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjkyknm</td><td>（連携用）漢字契約者名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhhknmei</td><td>（連携用）被保険者名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknjhhknmei</td><td>（連携用）漢字被保険者名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkeirokbn</td><td>（連携用）払込経路区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnanniskcd</td><td>（連携用）案内先コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkarikeijyoukbn</td><td>（連携用）仮計上区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntuikakeijyouhyj</td><td>（連携用）追加計上表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnksnhyj</td><td>（連携用）更新表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2ksnbubunmods</td><td>（連携用）第２加算部分修正Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrndai2bfrksnbubunmods</td><td>（連携用）第２変更前加算部分修正Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnphrkkikn</td><td>（連携用）Ｐ払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjissyuup</td><td>（連携用）実収Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngntikktgtiryoutkp</td><td>（連携用）限定告知型医療特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnbfrgntikktgtiryoutkp</td><td>（連携用）変更前限定告知型医療特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrndairitenkbtinfo1</td><td>（連携用）代理店個別情報１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitenkbtinfo2</td><td>（連携用）代理店個別情報２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitenkbtinfo3</td><td>（連携用）代理店個別情報３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisttkp</td><td>（連携用）災疾特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnreguardtkp</td><td>（連携用）リガード特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnvguardtkp</td><td>（連携用）Ｖガード特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnbfrsisttkp</td><td>（連携用）変更前災疾特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnbfrreguardtkp</td><td>（連携用）変更前リガード特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnbfrvguardtkp</td><td>（連携用）変更前Ｖガード特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngtmtv</td><td>（連携用）月末Ｖ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyukeiyakup</td><td>（連携用）主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnbfrsyup</td><td>（連携用）変更前主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrndairitentsratkiwari</td><td>（連携用）代理店手数料扱割合</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnseirituymd</td><td>（連携用）成立年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsekininkaisiymd</td><td>（連携用）責任開始年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncifcd</td><td>（連携用）ＣＩＦコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbankboskykkbn</td><td>（連携用）銀行募集契約区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykjiqpackhyj</td><td>（連携用）契約時Ｑパック表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnitijibrzugkp</td><td>（連携用）一時払増額Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntuuintokuyakup</td><td>（連携用）通院特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnbfrtuuintkp</td><td>（連携用）変更前通院特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsougousonsyoutokuyakup</td><td>（連携用）総合損傷特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnbfrsugusnsyutkp</td><td>（連携用）変更前総合損傷特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyoteiriritun5</td><td>（連携用）予定利率Ｎ５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnyouikunenkintokuyakup</td><td>（連携用）養育年金特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnbfryoiknktkp</td><td>（連携用）変更前養育年金特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrngntikktgtiryoutkntgk</td><td>（連携用）限定告知型医療特約日額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkyksyaskinmeino</td><td>（連携用）契約者索引名番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknsakuinmeino</td><td>（連携用）被保険者索引名番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsinkykbosyuoyadrtencd</td><td>（連携用）新契約募集時親代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyouhizeiritu</td><td>（連携用）消費税率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnmdhnaisyoumeicd</td><td>（連携用）窓販用愛称名コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncoolingofhyj</td><td>（連携用）クーリングオフ表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsaimnkkykhyj</td><td>（連携用）才満期契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpjytoym</td><td>（連携用）Ｐ充当年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsskhntihrkkisukbn</td><td>（連携用）成績判定用払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnphenkanarihyj</td><td>（連携用）Ｐ返還あり表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhjnkykhyj</td><td>（連携用）法人契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbktgomeisaicalcjyun</td><td>（連携用）分割後明細計算順</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnikkatubaraikbn</td><td>（連携用）一括払区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnikkatubaraikaisuu</td><td>（連携用）一括払回数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnuktkid</td><td>（連携用）受付管理ＩＤ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkigmrsytkp</td><td>（連携用）介護マル終特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnbfrkigmrsytkp</td><td>（連携用）変更前介護マル終特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkigmrsytkphrkkkn</td><td>（連携用）介護マル終特約Ｐ払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv5</td><td>（連携用）予備項目Ｖ５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnphenkanbfrsyup</td><td>（連携用）Ｐ返還用変更前主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin3</td><td>（連携用）予備項目Ｎ３</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrntousyokykjikawaserate</td><td>（連携用）当初契約時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnyobin11</td><td>（連携用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x2</td><td>（連携用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x3</td><td>（連携用）予備項目Ｎ１１＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x4</td><td>（連携用）予備項目Ｎ１１＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x5</td><td>（連携用）予備項目Ｎ１１＿５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x6</td><td>（連携用）予備項目Ｎ１１＿６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x7</td><td>（連携用）予備項目Ｎ１１＿７</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobin11x8</td><td>（連携用）予備項目Ｎ１１＿８</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnshzirtstkjynymd</td><td>（連携用）消費税率設定基準年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyaseiymd</td><td>（連携用）契約者生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntuukacd</td><td>（連携用）通貨コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyukeiyakupkyktuuka</td><td>（連携用）主契約Ｐ（契約通貨）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnbfrsyupkyktuuka</td><td>（連携用）変更前主契約Ｐ（契約通貨）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntekiyoukawaserate7keta</td><td>（連携用）適用為替レート（７桁）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnyobiv22</td><td>（連携用）予備項目Ｖ２２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv83</td><td>（連携用）予備項目Ｖ８３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_DrtenTsryInfoRn
 * @see     GenZT_DrtenTsryInfoRn
 * @see     QZT_DrtenTsryInfoRn
 * @see     GenQZT_DrtenTsryInfoRn
 */
public class PKZT_DrtenTsryInfoRn extends AbstractExDBPrimaryKey<ZT_DrtenTsryInfoRn, PKZT_DrtenTsryInfoRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_DrtenTsryInfoRn() {
    }

    public PKZT_DrtenTsryInfoRn(
        String pZrndairitencd,
        String pZrnbosyuunincd,
        String pZrnsyono,
        String pZrnkikaisyoriymd,
        Long pZrnkykmfksnctrlkh,
        String pZrnsikibetujyunjyo
    ) {
        zrndairitencd = pZrndairitencd;
        zrnbosyuunincd = pZrnbosyuunincd;
        zrnsyono = pZrnsyono;
        zrnkikaisyoriymd = pZrnkikaisyoriymd;
        zrnkykmfksnctrlkh = pZrnkykmfksnctrlkh;
        zrnsikibetujyunjyo = pZrnsikibetujyunjyo;
    }

    @Transient
    @Override
    public Class<ZT_DrtenTsryInfoRn> getEntityClass() {
        return ZT_DrtenTsryInfoRn.class;
    }

    private String zrndairitencd;

    public String getZrndairitencd() {
        return zrndairitencd;
    }

    public void setZrndairitencd(String pZrndairitencd) {
        zrndairitencd = pZrndairitencd;
    }
    private String zrnbosyuunincd;

    public String getZrnbosyuunincd() {
        return zrnbosyuunincd;
    }

    public void setZrnbosyuunincd(String pZrnbosyuunincd) {
        zrnbosyuunincd = pZrnbosyuunincd;
    }
    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }
    private String zrnkikaisyoriymd;

    public String getZrnkikaisyoriymd() {
        return zrnkikaisyoriymd;
    }

    public void setZrnkikaisyoriymd(String pZrnkikaisyoriymd) {
        zrnkikaisyoriymd = pZrnkikaisyoriymd;
    }
    private Long zrnkykmfksnctrlkh;

    public Long getZrnkykmfksnctrlkh() {
        return zrnkykmfksnctrlkh;
    }

    public void setZrnkykmfksnctrlkh(Long pZrnkykmfksnctrlkh) {
        zrnkykmfksnctrlkh = pZrnkykmfksnctrlkh;
    }
    private String zrnsikibetujyunjyo;

    public String getZrnsikibetujyunjyo() {
        return zrnsikibetujyunjyo;
    }

    public void setZrnsikibetujyunjyo(String pZrnsikibetujyunjyo) {
        zrnsikibetujyunjyo = pZrnsikibetujyunjyo;
    }

}