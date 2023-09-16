package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_DrtenTsryInfoTy;
import yuyu.def.db.mapping.GenZT_DrtenTsryInfoTy;
import yuyu.def.db.meta.GenQZT_DrtenTsryInfoTy;
import yuyu.def.db.meta.QZT_DrtenTsryInfoTy;

/**
 * 代理店手数料情報Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DrtenTsryInfoTy}</td><td colspan="3">代理店手数料情報Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtydairitencd ztydairitencd}</td><td>（中継用）代理店コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtybosyuunincd ztybosyuunincd}</td><td>（中継用）募集人コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakukbn</td><td>（中継用）契約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakuno</td><td>（中継用）特約番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyym</td><td>（中継用）募集年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymd</td><td>（中継用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykydatkibosyuucd</td><td>（中継用）共同扱募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyseiritujibumoncd</td><td>（中継用）成立時部門コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyseiritujiagutiknrcd</td><td>（中継用）成立時代理店内管理扱者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv1</td><td>（中継用）予備項目Ｖ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykydeigyouakojincd</td><td>（中継用）共同扱営業員Ａ扱者個人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykydeigyoubkojincd</td><td>（中継用）共同扱営業員Ｂ扱者個人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskeihyj</td><td>（中継用）新契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydenymd</td><td>（中継用）伝票日付</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtykikaisyoriymd ztykikaisyoriymd}</td><td>（中継用）機械処理年月日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoricd</td><td>（中継用）処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytyouseijiyuu</td><td>（中継用）調整事由</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynyknmonth</td><td>（中継用）入金月数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysikibetujyunjyo ztysikibetujyunjyo}</td><td>（中継用）識別順序</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytnsmacezugkukbn</td><td>（中継用）たのしみＡｃｅ増額区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyacezugkkrykkaisiymd</td><td>（中継用）Ａｃｅ増額効力開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv4</td><td>（中継用）予備項目Ｖ４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtykykmfksnctrlkh ztykykmfksnctrlkh}</td><td>（中継用）契約ＭＦ更新ＣＴＲ（保全）</td><td align="center">○</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztydairitenatkikeitaikbn</td><td>（中継用）代理店扱形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatkiwari</td><td>（中継用）扱割合</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztydairitenatkinin</td><td>（中継用）代理店扱人数</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytsrkeisansyukykhsyos</td><td>（中継用）手数料計算用主契約保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhtns</td><td>（中継用）被転換Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykijymods</td><td>（中継用）計上修正Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyksnbubunmods</td><td>（中継用）加算部分修正Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztybfrkijymods</td><td>（中継用）変更前計上修正Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztybfrksnbubunmods</td><td>（中継用）変更前加算部分修正Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhknsyukigou</td><td>（中継用）保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyuruikigousedaikbn</td><td>（中継用）保険種類記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytksyukgu</td><td>（中継用）特約種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytksyukgusedaikbn</td><td>（中継用）特約種類記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkaisuukbn</td><td>（中継用）払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyannaifuyouriyuukbn</td><td>（中継用）案内不要理由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnen2keta</td><td>（中継用）被保険者年令（２桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknkkn</td><td>（中継用）保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfstkeijyouhtkm</td><td>（中継用）初回計上判定項目</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytsrytsryhushrkbn</td><td>（中継用）手数料不支払区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybfritijibrzugkp</td><td>（中継用）変更前一時払増額Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztymaruteisyuruikigou</td><td>（中継用）マル定種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymrtihukakbn</td><td>（中継用）マル定付加区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysznmrtihukakbn</td><td>（中継用）生存マル定付加区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteigenmrtihukakbn</td><td>（中継用）逓減マル定付加区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyunyumrtihukakbn</td><td>（中継用）収入マル定付加区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzkmrtihukakbn</td><td>（中継用）家族マル定付加区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytoksipmrtihukakbn</td><td>（中継用）特定疾病マル定付加区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytoksipmrsyhukakbn</td><td>（中継用）特定疾病マル終付加区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymanskknmrtihukakbn</td><td>（中継用）慢性疾患マル定付加区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykigsyunyumrtihukakbn</td><td>（中継用）介護収入マル定付加区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykigteigenmrtihukakbn</td><td>（中継用）介護逓減マル定付加区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykignktkhukakbn</td><td>（中継用）介護年金特約付加区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykigmrtihukakbn</td><td>（中継用）介護マル定付加区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymrtisyukguyobiv1</td><td>（中継用）マル定種類記号予備項目Ｖ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymrtisyukguyobiv1x2</td><td>（中継用）マル定種類記号予備項目Ｖ１＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymrtisyukguyobiv1x3</td><td>（中継用）マル定種類記号予備項目Ｖ１＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymrtisyukguyobiv1x4</td><td>（中継用）マル定種類記号予備項目Ｖ１＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymrtisyukguyobiv1x5</td><td>（中継用）マル定種類記号予備項目Ｖ１＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv1x2</td><td>（中継用）予備項目Ｖ１＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknm</td><td>（中継用）契約者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkyknm</td><td>（中継用）漢字契約者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknmei</td><td>（中継用）被保険者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknjhhknmei</td><td>（中継用）漢字被保険者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeirokbn</td><td>（中継用）払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyanniskcd</td><td>（中継用）案内先コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykarikeijyoukbn</td><td>（中継用）仮計上区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytuikakeijyouhyj</td><td>（中継用）追加計上表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyksnhyj</td><td>（中継用）更新表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2ksnbubunmods</td><td>（中継用）第２加算部分修正Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztydai2bfrksnbubunmods</td><td>（中継用）第２変更前加算部分修正Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyphrkkikn</td><td>（中継用）Ｐ払込期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjissyuup</td><td>（中継用）実収Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygntikktgtiryoutkp</td><td>（中継用）限定告知型医療特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztybfrgntikktgtiryoutkp</td><td>（中継用）変更前限定告知型医療特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztydairitenkbtinfo1</td><td>（中継用）代理店個別情報１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydairitenkbtinfo2</td><td>（中継用）代理店個別情報２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydairitenkbtinfo3</td><td>（中継用）代理店個別情報３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisttkp</td><td>（中継用）災疾特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyreguardtkp</td><td>（中継用）リガード特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyvguardtkp</td><td>（中継用）Ｖガード特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztybfrsisttkp</td><td>（中継用）変更前災疾特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztybfrreguardtkp</td><td>（中継用）変更前リガード特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztybfrvguardtkp</td><td>（中継用）変更前Ｖガード特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygtmtv</td><td>（中継用）月末Ｖ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyukeiyakup</td><td>（中継用）主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztybfrsyup</td><td>（中継用）変更前主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztydairitentsratkiwari</td><td>（中継用）代理店手数料扱割合</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyseirituymd</td><td>（中継用）成立年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysekininkaisiymd</td><td>（中継用）責任開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycifcd</td><td>（中継用）ＣＩＦコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybankboskykkbn</td><td>（中継用）銀行募集契約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykjiqpackhyj</td><td>（中継用）契約時Ｑパック表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyitijibrzugkp</td><td>（中継用）一時払増額Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytuuintokuyakup</td><td>（中継用）通院特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztybfrtuuintkp</td><td>（中継用）変更前通院特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysougousonsyoutokuyakup</td><td>（中継用）総合損傷特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztybfrsugusnsyutkp</td><td>（中継用）変更前総合損傷特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyoteiriritun5</td><td>（中継用）予定利率Ｎ５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyyouikunenkintokuyakup</td><td>（中継用）養育年金特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztybfryoiknktkp</td><td>（中継用）変更前養育年金特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztygntikktgtiryoutkntgk</td><td>（中継用）限定告知型医療特約日額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykyksyaskinmeino</td><td>（中継用）契約者索引名番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknsakuinmeino</td><td>（中継用）被保険者索引名番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysinkykbosyuoyadrtencd</td><td>（中継用）新契約募集時親代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyouhizeiritu</td><td>（中継用）消費税率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztymdhnaisyoumeicd</td><td>（中継用）窓販用愛称名コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycoolingofhyj</td><td>（中継用）クーリングオフ表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysaimnkkykhyj</td><td>（中継用）才満期契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypjytoym</td><td>（中継用）Ｐ充当年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysskhntihrkkisukbn</td><td>（中継用）成績判定用払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyphenkanarihyj</td><td>（中継用）Ｐ返還あり表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhjnkykhyj</td><td>（中継用）法人契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybktgomeisaicalcjyun</td><td>（中継用）分割後明細計算順</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyikkatubaraikbn</td><td>（中継用）一括払区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyikkatubaraikaisuu</td><td>（中継用）一括払回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyuktkid</td><td>（中継用）受付管理ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykigmrsytkp</td><td>（中継用）介護マル終特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztybfrkigmrsytkp</td><td>（中継用）変更前介護マル終特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykigmrsytkphrkkkn</td><td>（中継用）介護マル終特約Ｐ払込期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv5</td><td>（中継用）予備項目Ｖ５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyphenkanbfrsyup</td><td>（中継用）Ｐ返還用変更前主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin3</td><td>（中継用）予備項目Ｎ３</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztytousyokykjikawaserate</td><td>（中継用）当初契約時為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyyobin11</td><td>（中継用）予備項目Ｎ１１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x2</td><td>（中継用）予備項目Ｎ１１＿２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x3</td><td>（中継用）予備項目Ｎ１１＿３</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x4</td><td>（中継用）予備項目Ｎ１１＿４</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x5</td><td>（中継用）予備項目Ｎ１１＿５</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x6</td><td>（中継用）予備項目Ｎ１１＿６</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x7</td><td>（中継用）予備項目Ｎ１１＿７</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobin11x8</td><td>（中継用）予備項目Ｎ１１＿８</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyshzirtstkjynymd</td><td>（中継用）消費税率設定基準年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyaseiymd</td><td>（中継用）契約者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytuukacd</td><td>（中継用）通貨コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyukeiyakupkyktuuka</td><td>（中継用）主契約Ｐ（契約通貨）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztybfrsyupkyktuuka</td><td>（中継用）変更前主契約Ｐ（契約通貨）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytekiyoukawaserate7keta</td><td>（中継用）適用為替レート（７桁）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyyobiv22</td><td>（中継用）予備項目Ｖ２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv83</td><td>（中継用）予備項目Ｖ８３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_DrtenTsryInfoTy
 * @see     GenZT_DrtenTsryInfoTy
 * @see     QZT_DrtenTsryInfoTy
 * @see     GenQZT_DrtenTsryInfoTy
 */
public class PKZT_DrtenTsryInfoTy extends AbstractExDBPrimaryKey<ZT_DrtenTsryInfoTy, PKZT_DrtenTsryInfoTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_DrtenTsryInfoTy() {
    }

    public PKZT_DrtenTsryInfoTy(
        String pZtydairitencd,
        String pZtybosyuunincd,
        String pZtysyono,
        String pZtykikaisyoriymd,
        Long pZtykykmfksnctrlkh,
        String pZtysikibetujyunjyo
    ) {
        ztydairitencd = pZtydairitencd;
        ztybosyuunincd = pZtybosyuunincd;
        ztysyono = pZtysyono;
        ztykikaisyoriymd = pZtykikaisyoriymd;
        ztykykmfksnctrlkh = pZtykykmfksnctrlkh;
        ztysikibetujyunjyo = pZtysikibetujyunjyo;
    }

    @Transient
    @Override
    public Class<ZT_DrtenTsryInfoTy> getEntityClass() {
        return ZT_DrtenTsryInfoTy.class;
    }

    private String ztydairitencd;

    public String getZtydairitencd() {
        return ztydairitencd;
    }

    public void setZtydairitencd(String pZtydairitencd) {
        ztydairitencd = pZtydairitencd;
    }
    private String ztybosyuunincd;

    public String getZtybosyuunincd() {
        return ztybosyuunincd;
    }

    public void setZtybosyuunincd(String pZtybosyuunincd) {
        ztybosyuunincd = pZtybosyuunincd;
    }
    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }
    private String ztykikaisyoriymd;

    public String getZtykikaisyoriymd() {
        return ztykikaisyoriymd;
    }

    public void setZtykikaisyoriymd(String pZtykikaisyoriymd) {
        ztykikaisyoriymd = pZtykikaisyoriymd;
    }
    private Long ztykykmfksnctrlkh;

    public Long getZtykykmfksnctrlkh() {
        return ztykykmfksnctrlkh;
    }

    public void setZtykykmfksnctrlkh(Long pZtykykmfksnctrlkh) {
        ztykykmfksnctrlkh = pZtykykmfksnctrlkh;
    }
    private String ztysikibetujyunjyo;

    public String getZtysikibetujyunjyo() {
        return ztysikibetujyunjyo;
    }

    public void setZtysikibetujyunjyo(String pZtysikibetujyunjyo) {
        ztysikibetujyunjyo = pZtysikibetujyunjyo;
    }

}