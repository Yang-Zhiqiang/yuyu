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
import yuyu.def.db.entity.ZT_DrtenTsryInfoTy;
import yuyu.def.db.id.PKZT_DrtenTsryInfoTy;
import yuyu.def.db.meta.GenQZT_DrtenTsryInfoTy;
import yuyu.def.db.meta.QZT_DrtenTsryInfoTy;

/**
 * 代理店手数料情報Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_DrtenTsryInfoTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DrtenTsryInfoTy}</td><td colspan="3">代理店手数料情報Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtydairitencd ztydairitencd}</td><td>（中継用）代理店コード</td><td align="center">{@link PKZT_DrtenTsryInfoTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuunincd ztybosyuunincd}</td><td>（中継用）募集人コード</td><td align="center">{@link PKZT_DrtenTsryInfoTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_DrtenTsryInfoTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakukbn ztykeiyakukbn}</td><td>（中継用）契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakuno ztytokuyakuno}</td><td>（中継用）特約番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyym ztybsyym}</td><td>（中継用）募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykydatkibosyuucd ztykydatkibosyuucd}</td><td>（中継用）共同扱募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseiritujibumoncd ztyseiritujibumoncd}</td><td>（中継用）成立時部門コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseiritujiagutiknrcd ztyseiritujiagutiknrcd}</td><td>（中継用）成立時代理店内管理扱者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv1 ztyyobiv1}</td><td>（中継用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykydeigyouakojincd ztykydeigyouakojincd}</td><td>（中継用）共同扱営業員Ａ扱者個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykydeigyoubkojincd ztykydeigyoubkojincd}</td><td>（中継用）共同扱営業員Ｂ扱者個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskeihyj ztyskeihyj}</td><td>（中継用）新契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydenymd ztydenymd}</td><td>（中継用）伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykikaisyoriymd ztykikaisyoriymd}</td><td>（中継用）機械処理年月日</td><td align="center">{@link PKZT_DrtenTsryInfoTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoricd ztysyoricd}</td><td>（中継用）処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouseijiyuu ztytyouseijiyuu}</td><td>（中継用）調整事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyknmonth ztynyknmonth}</td><td>（中継用）入金月数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysikibetujyunjyo ztysikibetujyunjyo}</td><td>（中継用）識別順序</td><td align="center">{@link PKZT_DrtenTsryInfoTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytnsmacezugkukbn ztytnsmacezugkukbn}</td><td>（中継用）たのしみＡｃｅ増額区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyacezugkkrykkaisiymd ztyacezugkkrykkaisiymd}</td><td>（中継用）Ａｃｅ増額効力開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv4 ztyyobiv4}</td><td>（中継用）予備項目Ｖ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykmfksnctrlkh ztykykmfksnctrlkh}</td><td>（中継用）契約ＭＦ更新ＣＴＲ（保全）</td><td align="center">{@link PKZT_DrtenTsryInfoTy ○}</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydairitenatkikeitaikbn ztydairitenatkikeitaikbn}</td><td>（中継用）代理店扱形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatkiwari ztyatkiwari}</td><td>（中継用）扱割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtydairitenatkinin ztydairitenatkinin}</td><td>（中継用）代理店扱人数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytsrkeisansyukykhsyos ztytsrkeisansyukykhsyos}</td><td>（中継用）手数料計算用主契約保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhtns ztyhtns}</td><td>（中継用）被転換Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykijymods ztykijymods}</td><td>（中継用）計上修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyksnbubunmods ztyksnbubunmods}</td><td>（中継用）加算部分修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtybfrkijymods ztybfrkijymods}</td><td>（中継用）変更前計上修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtybfrksnbubunmods ztybfrksnbubunmods}</td><td>（中継用）変更前加算部分修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyuruikigousedaikbn ztyhknsyuruikigousedaikbn}</td><td>（中継用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksyukgu ztytksyukgu}</td><td>（中継用）特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksyukgusedaikbn ztytksyukgusedaikbn}</td><td>（中継用）特約種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaifuyouriyuukbn ztyannaifuyouriyuukbn}</td><td>（中継用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnen2keta ztyhhknnen2keta}</td><td>（中継用）被保険者年令（２桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknkkn ztyhknkkn}</td><td>（中継用）保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfstkeijyouhtkm ztyfstkeijyouhtkm}</td><td>（中継用）初回計上判定項目</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsrytsryhushrkbn ztytsrytsryhushrkbn}</td><td>（中継用）手数料不支払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybfritijibrzugkp ztybfritijibrzugkp}</td><td>（中継用）変更前一時払増額Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymaruteisyuruikigou ztymaruteisyuruikigou}</td><td>（中継用）マル定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymrtihukakbn ztymrtihukakbn}</td><td>（中継用）マル定付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysznmrtihukakbn ztysznmrtihukakbn}</td><td>（中継用）生存マル定付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigenmrtihukakbn ztyteigenmrtihukakbn}</td><td>（中継用）逓減マル定付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyunyumrtihukakbn ztysyunyumrtihukakbn}</td><td>（中継用）収入マル定付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihukakbn ztykzkmrtihukakbn}</td><td>（中継用）家族マル定付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoksipmrtihukakbn ztytoksipmrtihukakbn}</td><td>（中継用）特定疾病マル定付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoksipmrsyhukakbn ztytoksipmrsyhukakbn}</td><td>（中継用）特定疾病マル終付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymanskknmrtihukakbn ztymanskknmrtihukakbn}</td><td>（中継用）慢性疾患マル定付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigsyunyumrtihukakbn ztykigsyunyumrtihukakbn}</td><td>（中継用）介護収入マル定付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigteigenmrtihukakbn ztykigteigenmrtihukakbn}</td><td>（中継用）介護逓減マル定付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykignktkhukakbn ztykignktkhukakbn}</td><td>（中継用）介護年金特約付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigmrtihukakbn ztykigmrtihukakbn}</td><td>（中継用）介護マル定付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymrtisyukguyobiv1 ztymrtisyukguyobiv1}</td><td>（中継用）マル定種類記号予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymrtisyukguyobiv1x2 ztymrtisyukguyobiv1x2}</td><td>（中継用）マル定種類記号予備項目Ｖ１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymrtisyukguyobiv1x3 ztymrtisyukguyobiv1x3}</td><td>（中継用）マル定種類記号予備項目Ｖ１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymrtisyukguyobiv1x4 ztymrtisyukguyobiv1x4}</td><td>（中継用）マル定種類記号予備項目Ｖ１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymrtisyukguyobiv1x5 ztymrtisyukguyobiv1x5}</td><td>（中継用）マル定種類記号予備項目Ｖ１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv1x2 ztyyobiv1x2}</td><td>（中継用）予備項目Ｖ１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknm ztykyknm}</td><td>（中継用）契約者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkyknm ztykjkyknm}</td><td>（中継用）漢字契約者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknmei ztyhhknmei}</td><td>（中継用）被保険者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknjhhknmei ztyknjhhknmei}</td><td>（中継用）漢字被保険者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirokbn ztyhrkkeirokbn}</td><td>（中継用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyanniskcd ztyanniskcd}</td><td>（中継用）案内先コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykarikeijyoukbn ztykarikeijyoukbn}</td><td>（中継用）仮計上区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuikakeijyouhyj ztytuikakeijyouhyj}</td><td>（中継用）追加計上表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyksnhyj ztyksnhyj}</td><td>（中継用）更新表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2ksnbubunmods ztydai2ksnbubunmods}</td><td>（中継用）第２加算部分修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydai2bfrksnbubunmods ztydai2bfrksnbubunmods}</td><td>（中継用）第２変更前加算部分修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyphrkkikn ztyphrkkikn}</td><td>（中継用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjissyuup ztyjissyuup}</td><td>（中継用）実収Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygntikktgtiryoutkp ztygntikktgtiryoutkp}</td><td>（中継用）限定告知型医療特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtybfrgntikktgtiryoutkp ztybfrgntikktgtiryoutkp}</td><td>（中継用）変更前限定告知型医療特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydairitenkbtinfo1 ztydairitenkbtinfo1}</td><td>（中継用）代理店個別情報１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairitenkbtinfo2 ztydairitenkbtinfo2}</td><td>（中継用）代理店個別情報２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairitenkbtinfo3 ztydairitenkbtinfo3}</td><td>（中継用）代理店個別情報３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisttkp ztysisttkp}</td><td>（中継用）災疾特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyreguardtkp ztyreguardtkp}</td><td>（中継用）リガード特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyvguardtkp ztyvguardtkp}</td><td>（中継用）Ｖガード特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtybfrsisttkp ztybfrsisttkp}</td><td>（中継用）変更前災疾特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtybfrreguardtkp ztybfrreguardtkp}</td><td>（中継用）変更前リガード特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtybfrvguardtkp ztybfrvguardtkp}</td><td>（中継用）変更前Ｖガード特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygtmtv ztygtmtv}</td><td>（中継用）月末Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakup ztysyukeiyakup}</td><td>（中継用）主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtybfrsyup ztybfrsyup}</td><td>（中継用）変更前主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydairitentsratkiwari ztydairitentsratkiwari}</td><td>（中継用）代理店手数料扱割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyseirituymd ztyseirituymd}</td><td>（中継用）成立年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysekininkaisiymd ztysekininkaisiymd}</td><td>（中継用）責任開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycifcd ztycifcd}</td><td>（中継用）ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybankboskykkbn ztybankboskykkbn}</td><td>（中継用）銀行募集契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykjiqpackhyj ztykykjiqpackhyj}</td><td>（中継用）契約時Ｑパック表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitijibrzugkp ztyitijibrzugkp}</td><td>（中継用）一時払増額Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytuuintokuyakup ztytuuintokuyakup}</td><td>（中継用）通院特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtybfrtuuintkp ztybfrtuuintkp}</td><td>（中継用）変更前通院特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysougousonsyoutokuyakup ztysougousonsyoutokuyakup}</td><td>（中継用）総合損傷特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtybfrsugusnsyutkp ztybfrsugusnsyutkp}</td><td>（中継用）変更前総合損傷特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritun5 ztyyoteiriritun5}</td><td>（中継用）予定利率Ｎ５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyouikunenkintokuyakup ztyyouikunenkintokuyakup}</td><td>（中継用）養育年金特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtybfryoiknktkp ztybfryoiknktkp}</td><td>（中継用）変更前養育年金特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygntikktgtiryoutkntgk ztygntikktgtiryoutkntgk}</td><td>（中継用）限定告知型医療特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykyksyaskinmeino ztykyksyaskinmeino}</td><td>（中継用）契約者索引名番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknsakuinmeino ztyhhknsakuinmeino}</td><td>（中継用）被保険者索引名番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysinkykbosyuoyadrtencd ztysinkykbosyuoyadrtencd}</td><td>（中継用）新契約募集時親代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyouhizeiritu ztysyouhizeiritu}</td><td>（中継用）消費税率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtymdhnaisyoumeicd ztymdhnaisyoumeicd}</td><td>（中継用）窓販用愛称名コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycoolingofhyj ztycoolingofhyj}</td><td>（中継用）クーリングオフ表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaimnkkykhyj ztysaimnkkykhyj}</td><td>（中継用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypjytoym ztypjytoym}</td><td>（中継用）Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysskhntihrkkisukbn ztysskhntihrkkisukbn}</td><td>（中継用）成績判定用払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphenkanarihyj ztyphenkanarihyj}</td><td>（中継用）Ｐ返還あり表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhjnkykhyj ztyhjnkykhyj}</td><td>（中継用）法人契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybktgomeisaicalcjyun ztybktgomeisaicalcjyun}</td><td>（中継用）分割後明細計算順</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyikkatubaraikbn ztyikkatubaraikbn}</td><td>（中継用）一括払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyikkatubaraikaisuu ztyikkatubaraikaisuu}</td><td>（中継用）一括払回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktkid ztyuktkid}</td><td>（中継用）受付管理ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigmrsytkp ztykigmrsytkp}</td><td>（中継用）介護マル終特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtybfrkigmrsytkp ztybfrkigmrsytkp}</td><td>（中継用）変更前介護マル終特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykigmrsytkphrkkkn ztykigmrsytkphrkkkn}</td><td>（中継用）介護マル終特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv5 ztyyobiv5}</td><td>（中継用）予備項目Ｖ５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphenkanbfrsyup ztyphenkanbfrsyup}</td><td>（中継用）Ｐ返還用変更前主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin3 ztyyobin3}</td><td>（中継用）予備項目Ｎ３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtytousyokykjikawaserate ztytousyokykjikawaserate}</td><td>（中継用）当初契約時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyobin11 ztyyobin11}</td><td>（中継用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x2 ztyyobin11x2}</td><td>（中継用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x3 ztyyobin11x3}</td><td>（中継用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x4 ztyyobin11x4}</td><td>（中継用）予備項目Ｎ１１＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x5 ztyyobin11x5}</td><td>（中継用）予備項目Ｎ１１＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x6 ztyyobin11x6}</td><td>（中継用）予備項目Ｎ１１＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x7 ztyyobin11x7}</td><td>（中継用）予備項目Ｎ１１＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x8 ztyyobin11x8}</td><td>（中継用）予備項目Ｎ１１＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyshzirtstkjynymd ztyshzirtstkjynymd}</td><td>（中継用）消費税率設定基準年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyaseiymd ztykyksyaseiymd}</td><td>（中継用）契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuukacd ztytuukacd}</td><td>（中継用）通貨コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakupkyktuuka ztysyukeiyakupkyktuuka}</td><td>（中継用）主契約Ｐ（契約通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtybfrsyupkyktuuka ztybfrsyupkyktuuka}</td><td>（中継用）変更前主契約Ｐ（契約通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytekiyoukawaserate7keta ztytekiyoukawaserate7keta}</td><td>（中継用）適用為替レート（７桁）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyobiv22 ztyyobiv22}</td><td>（中継用）予備項目Ｖ２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv83 ztyyobiv83}</td><td>（中継用）予備項目Ｖ８３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_DrtenTsryInfoTy
 * @see     PKZT_DrtenTsryInfoTy
 * @see     QZT_DrtenTsryInfoTy
 * @see     GenQZT_DrtenTsryInfoTy
 */
@MappedSuperclass
@Table(name=GenZT_DrtenTsryInfoTy.TABLE_NAME)
@IdClass(value=PKZT_DrtenTsryInfoTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_DrtenTsryInfoTy extends AbstractExDBEntity<ZT_DrtenTsryInfoTy, PKZT_DrtenTsryInfoTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DrtenTsryInfoTy";
    public static final String ZTYDAIRITENCD            = "ztydairitencd";
    public static final String ZTYBOSYUUNINCD           = "ztybosyuunincd";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYKEIYAKUKBN            = "ztykeiyakukbn";
    public static final String ZTYTOKUYAKUNO            = "ztytokuyakuno";
    public static final String ZTYBSYYM                 = "ztybsyym";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYKYDATKIBOSYUUCD       = "ztykydatkibosyuucd";
    public static final String ZTYSEIRITUJIBUMONCD      = "ztyseiritujibumoncd";
    public static final String ZTYSEIRITUJIAGUTIKNRCD   = "ztyseiritujiagutiknrcd";
    public static final String ZTYYOBIV1                = "ztyyobiv1";
    public static final String ZTYKYDEIGYOUAKOJINCD     = "ztykydeigyouakojincd";
    public static final String ZTYKYDEIGYOUBKOJINCD     = "ztykydeigyoubkojincd";
    public static final String ZTYSKEIHYJ               = "ztyskeihyj";
    public static final String ZTYDENYMD                = "ztydenymd";
    public static final String ZTYKIKAISYORIYMD         = "ztykikaisyoriymd";
    public static final String ZTYSYORICD               = "ztysyoricd";
    public static final String ZTYTYOUSEIJIYUU          = "ztytyouseijiyuu";
    public static final String ZTYNYKNMONTH             = "ztynyknmonth";
    public static final String ZTYSIKIBETUJYUNJYO       = "ztysikibetujyunjyo";
    public static final String ZTYTNSMACEZUGKUKBN       = "ztytnsmacezugkukbn";
    public static final String ZTYACEZUGKKRYKKAISIYMD   = "ztyacezugkkrykkaisiymd";
    public static final String ZTYYOBIV4                = "ztyyobiv4";
    public static final String ZTYKYKMFKSNCTRLKH        = "ztykykmfksnctrlkh";
    public static final String ZTYDAIRITENATKIKEITAIKBN = "ztydairitenatkikeitaikbn";
    public static final String ZTYATKIWARI              = "ztyatkiwari";
    public static final String ZTYDAIRITENATKININ       = "ztydairitenatkinin";
    public static final String ZTYTSRKEISANSYUKYKHSYOS  = "ztytsrkeisansyukykhsyos";
    public static final String ZTYHTNS                  = "ztyhtns";
    public static final String ZTYKIJYMODS              = "ztykijymods";
    public static final String ZTYKSNBUBUNMODS          = "ztyksnbubunmods";
    public static final String ZTYBFRKIJYMODS           = "ztybfrkijymods";
    public static final String ZTYBFRKSNBUBUNMODS       = "ztybfrksnbubunmods";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYHKNSYURUIKIGOUSEDAIKBN = "ztyhknsyuruikigousedaikbn";
    public static final String ZTYTKSYUKGU              = "ztytksyukgu";
    public static final String ZTYTKSYUKGUSEDAIKBN      = "ztytksyukgusedaikbn";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYANNAIFUYOURIYUUKBN    = "ztyannaifuyouriyuukbn";
    public static final String ZTYHHKNNEN2KETA          = "ztyhhknnen2keta";
    public static final String ZTYHKNKKN                = "ztyhknkkn";
    public static final String ZTYFSTKEIJYOUHTKM        = "ztyfstkeijyouhtkm";
    public static final String ZTYTSRYTSRYHUSHRKBN      = "ztytsrytsryhushrkbn";
    public static final String ZTYBFRITIJIBRZUGKP       = "ztybfritijibrzugkp";
    public static final String ZTYMARUTEISYURUIKIGOU    = "ztymaruteisyuruikigou";
    public static final String ZTYMRTIHUKAKBN           = "ztymrtihukakbn";
    public static final String ZTYSZNMRTIHUKAKBN        = "ztysznmrtihukakbn";
    public static final String ZTYTEIGENMRTIHUKAKBN     = "ztyteigenmrtihukakbn";
    public static final String ZTYSYUNYUMRTIHUKAKBN     = "ztysyunyumrtihukakbn";
    public static final String ZTYKZKMRTIHUKAKBN        = "ztykzkmrtihukakbn";
    public static final String ZTYTOKSIPMRTIHUKAKBN     = "ztytoksipmrtihukakbn";
    public static final String ZTYTOKSIPMRSYHUKAKBN     = "ztytoksipmrsyhukakbn";
    public static final String ZTYMANSKKNMRTIHUKAKBN    = "ztymanskknmrtihukakbn";
    public static final String ZTYKIGSYUNYUMRTIHUKAKBN  = "ztykigsyunyumrtihukakbn";
    public static final String ZTYKIGTEIGENMRTIHUKAKBN  = "ztykigteigenmrtihukakbn";
    public static final String ZTYKIGNKTKHUKAKBN        = "ztykignktkhukakbn";
    public static final String ZTYKIGMRTIHUKAKBN        = "ztykigmrtihukakbn";
    public static final String ZTYMRTISYUKGUYOBIV1      = "ztymrtisyukguyobiv1";
    public static final String ZTYMRTISYUKGUYOBIV1X2    = "ztymrtisyukguyobiv1x2";
    public static final String ZTYMRTISYUKGUYOBIV1X3    = "ztymrtisyukguyobiv1x3";
    public static final String ZTYMRTISYUKGUYOBIV1X4    = "ztymrtisyukguyobiv1x4";
    public static final String ZTYMRTISYUKGUYOBIV1X5    = "ztymrtisyukguyobiv1x5";
    public static final String ZTYYOBIV1X2              = "ztyyobiv1x2";
    public static final String ZTYKYKNM                 = "ztykyknm";
    public static final String ZTYKJKYKNM               = "ztykjkyknm";
    public static final String ZTYHHKNMEI               = "ztyhhknmei";
    public static final String ZTYKNJHHKNMEI            = "ztyknjhhknmei";
    public static final String ZTYHRKKEIROKBN           = "ztyhrkkeirokbn";
    public static final String ZTYANNISKCD              = "ztyanniskcd";
    public static final String ZTYKARIKEIJYOUKBN        = "ztykarikeijyoukbn";
    public static final String ZTYTUIKAKEIJYOUHYJ       = "ztytuikakeijyouhyj";
    public static final String ZTYKSNHYJ                = "ztyksnhyj";
    public static final String ZTYDAI2KSNBUBUNMODS      = "ztydai2ksnbubunmods";
    public static final String ZTYDAI2BFRKSNBUBUNMODS   = "ztydai2bfrksnbubunmods";
    public static final String ZTYPHRKKIKN              = "ztyphrkkikn";
    public static final String ZTYJISSYUUP              = "ztyjissyuup";
    public static final String ZTYGNTIKKTGTIRYOUTKP     = "ztygntikktgtiryoutkp";
    public static final String ZTYBFRGNTIKKTGTIRYOUTKP  = "ztybfrgntikktgtiryoutkp";
    public static final String ZTYDAIRITENKBTINFO1      = "ztydairitenkbtinfo1";
    public static final String ZTYDAIRITENKBTINFO2      = "ztydairitenkbtinfo2";
    public static final String ZTYDAIRITENKBTINFO3      = "ztydairitenkbtinfo3";
    public static final String ZTYSISTTKP               = "ztysisttkp";
    public static final String ZTYREGUARDTKP            = "ztyreguardtkp";
    public static final String ZTYVGUARDTKP             = "ztyvguardtkp";
    public static final String ZTYBFRSISTTKP            = "ztybfrsisttkp";
    public static final String ZTYBFRREGUARDTKP         = "ztybfrreguardtkp";
    public static final String ZTYBFRVGUARDTKP          = "ztybfrvguardtkp";
    public static final String ZTYGTMTV                 = "ztygtmtv";
    public static final String ZTYSYUKEIYAKUP           = "ztysyukeiyakup";
    public static final String ZTYBFRSYUP               = "ztybfrsyup";
    public static final String ZTYDAIRITENTSRATKIWARI   = "ztydairitentsratkiwari";
    public static final String ZTYSEIRITUYMD            = "ztyseirituymd";
    public static final String ZTYSEKININKAISIYMD       = "ztysekininkaisiymd";
    public static final String ZTYCIFCD                 = "ztycifcd";
    public static final String ZTYBANKBOSKYKKBN         = "ztybankboskykkbn";
    public static final String ZTYKYKJIQPACKHYJ         = "ztykykjiqpackhyj";
    public static final String ZTYITIJIBRZUGKP          = "ztyitijibrzugkp";
    public static final String ZTYTUUINTOKUYAKUP        = "ztytuuintokuyakup";
    public static final String ZTYBFRTUUINTKP           = "ztybfrtuuintkp";
    public static final String ZTYSOUGOUSONSYOUTOKUYAKUP = "ztysougousonsyoutokuyakup";
    public static final String ZTYBFRSUGUSNSYUTKP       = "ztybfrsugusnsyutkp";
    public static final String ZTYYOTEIRIRITUN5         = "ztyyoteiriritun5";
    public static final String ZTYYOUIKUNENKINTOKUYAKUP = "ztyyouikunenkintokuyakup";
    public static final String ZTYBFRYOIKNKTKP          = "ztybfryoiknktkp";
    public static final String ZTYGNTIKKTGTIRYOUTKNTGK  = "ztygntikktgtiryoutkntgk";
    public static final String ZTYKYKSYASKINMEINO       = "ztykyksyaskinmeino";
    public static final String ZTYHHKNSAKUINMEINO       = "ztyhhknsakuinmeino";
    public static final String ZTYSINKYKBOSYUOYADRTENCD = "ztysinkykbosyuoyadrtencd";
    public static final String ZTYSYOUHIZEIRITU         = "ztysyouhizeiritu";
    public static final String ZTYMDHNAISYOUMEICD       = "ztymdhnaisyoumeicd";
    public static final String ZTYCOOLINGOFHYJ          = "ztycoolingofhyj";
    public static final String ZTYSAIMNKKYKHYJ          = "ztysaimnkkykhyj";
    public static final String ZTYPJYTOYM               = "ztypjytoym";
    public static final String ZTYSSKHNTIHRKKISUKBN     = "ztysskhntihrkkisukbn";
    public static final String ZTYPHENKANARIHYJ         = "ztyphenkanarihyj";
    public static final String ZTYHJNKYKHYJ             = "ztyhjnkykhyj";
    public static final String ZTYBKTGOMEISAICALCJYUN   = "ztybktgomeisaicalcjyun";
    public static final String ZTYIKKATUBARAIKBN        = "ztyikkatubaraikbn";
    public static final String ZTYIKKATUBARAIKAISUU     = "ztyikkatubaraikaisuu";
    public static final String ZTYUKTKID                = "ztyuktkid";
    public static final String ZTYKIGMRSYTKP            = "ztykigmrsytkp";
    public static final String ZTYBFRKIGMRSYTKP         = "ztybfrkigmrsytkp";
    public static final String ZTYKIGMRSYTKPHRKKKN      = "ztykigmrsytkphrkkkn";
    public static final String ZTYYOBIV5                = "ztyyobiv5";
    public static final String ZTYPHENKANBFRSYUP        = "ztyphenkanbfrsyup";
    public static final String ZTYYOBIN3                = "ztyyobin3";
    public static final String ZTYTOUSYOKYKJIKAWASERATE = "ztytousyokykjikawaserate";
    public static final String ZTYYOBIN11               = "ztyyobin11";
    public static final String ZTYYOBIN11X2             = "ztyyobin11x2";
    public static final String ZTYYOBIN11X3             = "ztyyobin11x3";
    public static final String ZTYYOBIN11X4             = "ztyyobin11x4";
    public static final String ZTYYOBIN11X5             = "ztyyobin11x5";
    public static final String ZTYYOBIN11X6             = "ztyyobin11x6";
    public static final String ZTYYOBIN11X7             = "ztyyobin11x7";
    public static final String ZTYYOBIN11X8             = "ztyyobin11x8";
    public static final String ZTYSHZIRTSTKJYNYMD       = "ztyshzirtstkjynymd";
    public static final String ZTYKYKSYASEIYMD          = "ztykyksyaseiymd";
    public static final String ZTYTUUKACD               = "ztytuukacd";
    public static final String ZTYSYUKEIYAKUPKYKTUUKA   = "ztysyukeiyakupkyktuuka";
    public static final String ZTYBFRSYUPKYKTUUKA       = "ztybfrsyupkyktuuka";
    public static final String ZTYTEKIYOUKAWASERATE7KETA = "ztytekiyoukawaserate7keta";
    public static final String ZTYYOBIV22               = "ztyyobiv22";
    public static final String ZTYYOBIV83               = "ztyyobiv83";

    private final PKZT_DrtenTsryInfoTy primaryKey;

    public GenZT_DrtenTsryInfoTy() {
        primaryKey = new PKZT_DrtenTsryInfoTy();
    }

    public GenZT_DrtenTsryInfoTy(
        String pZtydairitencd,
        String pZtybosyuunincd,
        String pZtysyono,
        String pZtykikaisyoriymd,
        Long pZtykykmfksnctrlkh,
        String pZtysikibetujyunjyo
    ) {
        primaryKey = new PKZT_DrtenTsryInfoTy(
            pZtydairitencd,
            pZtybosyuunincd,
            pZtysyono,
            pZtykikaisyoriymd,
            pZtykykmfksnctrlkh,
            pZtysikibetujyunjyo
        );
    }

    @Transient
    @Override
    public PKZT_DrtenTsryInfoTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DrtenTsryInfoTy> getMetaClass() {
        return QZT_DrtenTsryInfoTy.class;
    }

    @Id
    @Column(name=GenZT_DrtenTsryInfoTy.ZTYDAIRITENCD)
    public String getZtydairitencd() {
        return getPrimaryKey().getZtydairitencd();
    }

    public void setZtydairitencd(String pZtydairitencd) {
        getPrimaryKey().setZtydairitencd(pZtydairitencd);
    }

    @Id
    @Column(name=GenZT_DrtenTsryInfoTy.ZTYBOSYUUNINCD)
    public String getZtybosyuunincd() {
        return getPrimaryKey().getZtybosyuunincd();
    }

    public void setZtybosyuunincd(String pZtybosyuunincd) {
        getPrimaryKey().setZtybosyuunincd(pZtybosyuunincd);
    }

    @Id
    @Column(name=GenZT_DrtenTsryInfoTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztykeiyakukbn;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYKEIYAKUKBN)
    public String getZtykeiyakukbn() {
        return ztykeiyakukbn;
    }

    public void setZtykeiyakukbn(String pZtykeiyakukbn) {
        ztykeiyakukbn = pZtykeiyakukbn;
    }

    private String ztytokuyakuno;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYTOKUYAKUNO)
    public String getZtytokuyakuno() {
        return ztytokuyakuno;
    }

    public void setZtytokuyakuno(String pZtytokuyakuno) {
        ztytokuyakuno = pZtytokuyakuno;
    }

    private String ztybsyym;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYBSYYM)
    public String getZtybsyym() {
        return ztybsyym;
    }

    public void setZtybsyym(String pZtybsyym) {
        ztybsyym = pZtybsyym;
    }

    private String ztykykymd;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztykydatkibosyuucd;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYKYDATKIBOSYUUCD)
    public String getZtykydatkibosyuucd() {
        return ztykydatkibosyuucd;
    }

    public void setZtykydatkibosyuucd(String pZtykydatkibosyuucd) {
        ztykydatkibosyuucd = pZtykydatkibosyuucd;
    }

    private String ztyseiritujibumoncd;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYSEIRITUJIBUMONCD)
    public String getZtyseiritujibumoncd() {
        return ztyseiritujibumoncd;
    }

    public void setZtyseiritujibumoncd(String pZtyseiritujibumoncd) {
        ztyseiritujibumoncd = pZtyseiritujibumoncd;
    }

    private String ztyseiritujiagutiknrcd;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYSEIRITUJIAGUTIKNRCD)
    public String getZtyseiritujiagutiknrcd() {
        return ztyseiritujiagutiknrcd;
    }

    public void setZtyseiritujiagutiknrcd(String pZtyseiritujiagutiknrcd) {
        ztyseiritujiagutiknrcd = pZtyseiritujiagutiknrcd;
    }

    private String ztyyobiv1;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYYOBIV1)
    public String getZtyyobiv1() {
        return ztyyobiv1;
    }

    public void setZtyyobiv1(String pZtyyobiv1) {
        ztyyobiv1 = pZtyyobiv1;
    }

    private String ztykydeigyouakojincd;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYKYDEIGYOUAKOJINCD)
    public String getZtykydeigyouakojincd() {
        return ztykydeigyouakojincd;
    }

    public void setZtykydeigyouakojincd(String pZtykydeigyouakojincd) {
        ztykydeigyouakojincd = pZtykydeigyouakojincd;
    }

    private String ztykydeigyoubkojincd;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYKYDEIGYOUBKOJINCD)
    public String getZtykydeigyoubkojincd() {
        return ztykydeigyoubkojincd;
    }

    public void setZtykydeigyoubkojincd(String pZtykydeigyoubkojincd) {
        ztykydeigyoubkojincd = pZtykydeigyoubkojincd;
    }

    private String ztyskeihyj;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYSKEIHYJ)
    public String getZtyskeihyj() {
        return ztyskeihyj;
    }

    public void setZtyskeihyj(String pZtyskeihyj) {
        ztyskeihyj = pZtyskeihyj;
    }

    private String ztydenymd;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYDENYMD)
    public String getZtydenymd() {
        return ztydenymd;
    }

    public void setZtydenymd(String pZtydenymd) {
        ztydenymd = pZtydenymd;
    }

    @Id
    @Column(name=GenZT_DrtenTsryInfoTy.ZTYKIKAISYORIYMD)
    public String getZtykikaisyoriymd() {
        return getPrimaryKey().getZtykikaisyoriymd();
    }

    public void setZtykikaisyoriymd(String pZtykikaisyoriymd) {
        getPrimaryKey().setZtykikaisyoriymd(pZtykikaisyoriymd);
    }

    private String ztysyoricd;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYSYORICD)
    public String getZtysyoricd() {
        return ztysyoricd;
    }

    public void setZtysyoricd(String pZtysyoricd) {
        ztysyoricd = pZtysyoricd;
    }

    private String ztytyouseijiyuu;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYTYOUSEIJIYUU)
    public String getZtytyouseijiyuu() {
        return ztytyouseijiyuu;
    }

    public void setZtytyouseijiyuu(String pZtytyouseijiyuu) {
        ztytyouseijiyuu = pZtytyouseijiyuu;
    }

    private String ztynyknmonth;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYNYKNMONTH)
    public String getZtynyknmonth() {
        return ztynyknmonth;
    }

    public void setZtynyknmonth(String pZtynyknmonth) {
        ztynyknmonth = pZtynyknmonth;
    }

    @Id
    @Column(name=GenZT_DrtenTsryInfoTy.ZTYSIKIBETUJYUNJYO)
    public String getZtysikibetujyunjyo() {
        return getPrimaryKey().getZtysikibetujyunjyo();
    }

    public void setZtysikibetujyunjyo(String pZtysikibetujyunjyo) {
        getPrimaryKey().setZtysikibetujyunjyo(pZtysikibetujyunjyo);
    }

    private String ztytnsmacezugkukbn;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYTNSMACEZUGKUKBN)
    public String getZtytnsmacezugkukbn() {
        return ztytnsmacezugkukbn;
    }

    public void setZtytnsmacezugkukbn(String pZtytnsmacezugkukbn) {
        ztytnsmacezugkukbn = pZtytnsmacezugkukbn;
    }

    private String ztyacezugkkrykkaisiymd;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYACEZUGKKRYKKAISIYMD)
    public String getZtyacezugkkrykkaisiymd() {
        return ztyacezugkkrykkaisiymd;
    }

    public void setZtyacezugkkrykkaisiymd(String pZtyacezugkkrykkaisiymd) {
        ztyacezugkkrykkaisiymd = pZtyacezugkkrykkaisiymd;
    }

    private String ztyyobiv4;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYYOBIV4)
    public String getZtyyobiv4() {
        return ztyyobiv4;
    }

    public void setZtyyobiv4(String pZtyyobiv4) {
        ztyyobiv4 = pZtyyobiv4;
    }

    @Id
    @Column(name=GenZT_DrtenTsryInfoTy.ZTYKYKMFKSNCTRLKH)
    public Long getZtykykmfksnctrlkh() {
        return getPrimaryKey().getZtykykmfksnctrlkh();
    }

    public void setZtykykmfksnctrlkh(Long pZtykykmfksnctrlkh) {
        getPrimaryKey().setZtykykmfksnctrlkh(pZtykykmfksnctrlkh);
    }

    private String ztydairitenatkikeitaikbn;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYDAIRITENATKIKEITAIKBN)
    public String getZtydairitenatkikeitaikbn() {
        return ztydairitenatkikeitaikbn;
    }

    public void setZtydairitenatkikeitaikbn(String pZtydairitenatkikeitaikbn) {
        ztydairitenatkikeitaikbn = pZtydairitenatkikeitaikbn;
    }

    private BizNumber ztyatkiwari;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DrtenTsryInfoTy.ZTYATKIWARI)
    public BizNumber getZtyatkiwari() {
        return ztyatkiwari;
    }

    public void setZtyatkiwari(BizNumber pZtyatkiwari) {
        ztyatkiwari = pZtyatkiwari;
    }

    private Long ztydairitenatkinin;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYDAIRITENATKININ)
    public Long getZtydairitenatkinin() {
        return ztydairitenatkinin;
    }

    public void setZtydairitenatkinin(Long pZtydairitenatkinin) {
        ztydairitenatkinin = pZtydairitenatkinin;
    }

    private Long ztytsrkeisansyukykhsyos;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYTSRKEISANSYUKYKHSYOS)
    public Long getZtytsrkeisansyukykhsyos() {
        return ztytsrkeisansyukykhsyos;
    }

    public void setZtytsrkeisansyukykhsyos(Long pZtytsrkeisansyukykhsyos) {
        ztytsrkeisansyukykhsyos = pZtytsrkeisansyukykhsyos;
    }

    private Long ztyhtns;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYHTNS)
    public Long getZtyhtns() {
        return ztyhtns;
    }

    public void setZtyhtns(Long pZtyhtns) {
        ztyhtns = pZtyhtns;
    }

    private Long ztykijymods;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYKIJYMODS)
    public Long getZtykijymods() {
        return ztykijymods;
    }

    public void setZtykijymods(Long pZtykijymods) {
        ztykijymods = pZtykijymods;
    }

    private Long ztyksnbubunmods;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYKSNBUBUNMODS)
    public Long getZtyksnbubunmods() {
        return ztyksnbubunmods;
    }

    public void setZtyksnbubunmods(Long pZtyksnbubunmods) {
        ztyksnbubunmods = pZtyksnbubunmods;
    }

    private Long ztybfrkijymods;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYBFRKIJYMODS)
    public Long getZtybfrkijymods() {
        return ztybfrkijymods;
    }

    public void setZtybfrkijymods(Long pZtybfrkijymods) {
        ztybfrkijymods = pZtybfrkijymods;
    }

    private Long ztybfrksnbubunmods;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYBFRKSNBUBUNMODS)
    public Long getZtybfrksnbubunmods() {
        return ztybfrksnbubunmods;
    }

    public void setZtybfrksnbubunmods(Long pZtybfrksnbubunmods) {
        ztybfrksnbubunmods = pZtybfrksnbubunmods;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztyhknsyuruikigousedaikbn;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYHKNSYURUIKIGOUSEDAIKBN)
    public String getZtyhknsyuruikigousedaikbn() {
        return ztyhknsyuruikigousedaikbn;
    }

    public void setZtyhknsyuruikigousedaikbn(String pZtyhknsyuruikigousedaikbn) {
        ztyhknsyuruikigousedaikbn = pZtyhknsyuruikigousedaikbn;
    }

    private String ztytksyukgu;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYTKSYUKGU)
    public String getZtytksyukgu() {
        return ztytksyukgu;
    }

    public void setZtytksyukgu(String pZtytksyukgu) {
        ztytksyukgu = pZtytksyukgu;
    }

    private String ztytksyukgusedaikbn;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYTKSYUKGUSEDAIKBN)
    public String getZtytksyukgusedaikbn() {
        return ztytksyukgusedaikbn;
    }

    public void setZtytksyukgusedaikbn(String pZtytksyukgusedaikbn) {
        ztytksyukgusedaikbn = pZtytksyukgusedaikbn;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztyannaifuyouriyuukbn;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYANNAIFUYOURIYUUKBN)
    public String getZtyannaifuyouriyuukbn() {
        return ztyannaifuyouriyuukbn;
    }

    public void setZtyannaifuyouriyuukbn(String pZtyannaifuyouriyuukbn) {
        ztyannaifuyouriyuukbn = pZtyannaifuyouriyuukbn;
    }

    private String ztyhhknnen2keta;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYHHKNNEN2KETA)
    public String getZtyhhknnen2keta() {
        return ztyhhknnen2keta;
    }

    public void setZtyhhknnen2keta(String pZtyhhknnen2keta) {
        ztyhhknnen2keta = pZtyhhknnen2keta;
    }

    private String ztyhknkkn;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYHKNKKN)
    public String getZtyhknkkn() {
        return ztyhknkkn;
    }

    public void setZtyhknkkn(String pZtyhknkkn) {
        ztyhknkkn = pZtyhknkkn;
    }

    private String ztyfstkeijyouhtkm;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYFSTKEIJYOUHTKM)
    public String getZtyfstkeijyouhtkm() {
        return ztyfstkeijyouhtkm;
    }

    public void setZtyfstkeijyouhtkm(String pZtyfstkeijyouhtkm) {
        ztyfstkeijyouhtkm = pZtyfstkeijyouhtkm;
    }

    private String ztytsrytsryhushrkbn;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYTSRYTSRYHUSHRKBN)
    public String getZtytsrytsryhushrkbn() {
        return ztytsrytsryhushrkbn;
    }

    public void setZtytsrytsryhushrkbn(String pZtytsrytsryhushrkbn) {
        ztytsrytsryhushrkbn = pZtytsrytsryhushrkbn;
    }

    private Long ztybfritijibrzugkp;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYBFRITIJIBRZUGKP)
    public Long getZtybfritijibrzugkp() {
        return ztybfritijibrzugkp;
    }

    public void setZtybfritijibrzugkp(Long pZtybfritijibrzugkp) {
        ztybfritijibrzugkp = pZtybfritijibrzugkp;
    }

    private String ztymaruteisyuruikigou;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYMARUTEISYURUIKIGOU)
    public String getZtymaruteisyuruikigou() {
        return ztymaruteisyuruikigou;
    }

    public void setZtymaruteisyuruikigou(String pZtymaruteisyuruikigou) {
        ztymaruteisyuruikigou = pZtymaruteisyuruikigou;
    }

    private String ztymrtihukakbn;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYMRTIHUKAKBN)
    public String getZtymrtihukakbn() {
        return ztymrtihukakbn;
    }

    public void setZtymrtihukakbn(String pZtymrtihukakbn) {
        ztymrtihukakbn = pZtymrtihukakbn;
    }

    private String ztysznmrtihukakbn;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYSZNMRTIHUKAKBN)
    public String getZtysznmrtihukakbn() {
        return ztysznmrtihukakbn;
    }

    public void setZtysznmrtihukakbn(String pZtysznmrtihukakbn) {
        ztysznmrtihukakbn = pZtysznmrtihukakbn;
    }

    private String ztyteigenmrtihukakbn;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYTEIGENMRTIHUKAKBN)
    public String getZtyteigenmrtihukakbn() {
        return ztyteigenmrtihukakbn;
    }

    public void setZtyteigenmrtihukakbn(String pZtyteigenmrtihukakbn) {
        ztyteigenmrtihukakbn = pZtyteigenmrtihukakbn;
    }

    private String ztysyunyumrtihukakbn;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYSYUNYUMRTIHUKAKBN)
    public String getZtysyunyumrtihukakbn() {
        return ztysyunyumrtihukakbn;
    }

    public void setZtysyunyumrtihukakbn(String pZtysyunyumrtihukakbn) {
        ztysyunyumrtihukakbn = pZtysyunyumrtihukakbn;
    }

    private String ztykzkmrtihukakbn;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYKZKMRTIHUKAKBN)
    public String getZtykzkmrtihukakbn() {
        return ztykzkmrtihukakbn;
    }

    public void setZtykzkmrtihukakbn(String pZtykzkmrtihukakbn) {
        ztykzkmrtihukakbn = pZtykzkmrtihukakbn;
    }

    private String ztytoksipmrtihukakbn;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYTOKSIPMRTIHUKAKBN)
    public String getZtytoksipmrtihukakbn() {
        return ztytoksipmrtihukakbn;
    }

    public void setZtytoksipmrtihukakbn(String pZtytoksipmrtihukakbn) {
        ztytoksipmrtihukakbn = pZtytoksipmrtihukakbn;
    }

    private String ztytoksipmrsyhukakbn;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYTOKSIPMRSYHUKAKBN)
    public String getZtytoksipmrsyhukakbn() {
        return ztytoksipmrsyhukakbn;
    }

    public void setZtytoksipmrsyhukakbn(String pZtytoksipmrsyhukakbn) {
        ztytoksipmrsyhukakbn = pZtytoksipmrsyhukakbn;
    }

    private String ztymanskknmrtihukakbn;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYMANSKKNMRTIHUKAKBN)
    public String getZtymanskknmrtihukakbn() {
        return ztymanskknmrtihukakbn;
    }

    public void setZtymanskknmrtihukakbn(String pZtymanskknmrtihukakbn) {
        ztymanskknmrtihukakbn = pZtymanskknmrtihukakbn;
    }

    private String ztykigsyunyumrtihukakbn;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYKIGSYUNYUMRTIHUKAKBN)
    public String getZtykigsyunyumrtihukakbn() {
        return ztykigsyunyumrtihukakbn;
    }

    public void setZtykigsyunyumrtihukakbn(String pZtykigsyunyumrtihukakbn) {
        ztykigsyunyumrtihukakbn = pZtykigsyunyumrtihukakbn;
    }

    private String ztykigteigenmrtihukakbn;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYKIGTEIGENMRTIHUKAKBN)
    public String getZtykigteigenmrtihukakbn() {
        return ztykigteigenmrtihukakbn;
    }

    public void setZtykigteigenmrtihukakbn(String pZtykigteigenmrtihukakbn) {
        ztykigteigenmrtihukakbn = pZtykigteigenmrtihukakbn;
    }

    private String ztykignktkhukakbn;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYKIGNKTKHUKAKBN)
    public String getZtykignktkhukakbn() {
        return ztykignktkhukakbn;
    }

    public void setZtykignktkhukakbn(String pZtykignktkhukakbn) {
        ztykignktkhukakbn = pZtykignktkhukakbn;
    }

    private String ztykigmrtihukakbn;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYKIGMRTIHUKAKBN)
    public String getZtykigmrtihukakbn() {
        return ztykigmrtihukakbn;
    }

    public void setZtykigmrtihukakbn(String pZtykigmrtihukakbn) {
        ztykigmrtihukakbn = pZtykigmrtihukakbn;
    }

    private String ztymrtisyukguyobiv1;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYMRTISYUKGUYOBIV1)
    public String getZtymrtisyukguyobiv1() {
        return ztymrtisyukguyobiv1;
    }

    public void setZtymrtisyukguyobiv1(String pZtymrtisyukguyobiv1) {
        ztymrtisyukguyobiv1 = pZtymrtisyukguyobiv1;
    }

    private String ztymrtisyukguyobiv1x2;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYMRTISYUKGUYOBIV1X2)
    public String getZtymrtisyukguyobiv1x2() {
        return ztymrtisyukguyobiv1x2;
    }

    public void setZtymrtisyukguyobiv1x2(String pZtymrtisyukguyobiv1x2) {
        ztymrtisyukguyobiv1x2 = pZtymrtisyukguyobiv1x2;
    }

    private String ztymrtisyukguyobiv1x3;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYMRTISYUKGUYOBIV1X3)
    public String getZtymrtisyukguyobiv1x3() {
        return ztymrtisyukguyobiv1x3;
    }

    public void setZtymrtisyukguyobiv1x3(String pZtymrtisyukguyobiv1x3) {
        ztymrtisyukguyobiv1x3 = pZtymrtisyukguyobiv1x3;
    }

    private String ztymrtisyukguyobiv1x4;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYMRTISYUKGUYOBIV1X4)
    public String getZtymrtisyukguyobiv1x4() {
        return ztymrtisyukguyobiv1x4;
    }

    public void setZtymrtisyukguyobiv1x4(String pZtymrtisyukguyobiv1x4) {
        ztymrtisyukguyobiv1x4 = pZtymrtisyukguyobiv1x4;
    }

    private String ztymrtisyukguyobiv1x5;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYMRTISYUKGUYOBIV1X5)
    public String getZtymrtisyukguyobiv1x5() {
        return ztymrtisyukguyobiv1x5;
    }

    public void setZtymrtisyukguyobiv1x5(String pZtymrtisyukguyobiv1x5) {
        ztymrtisyukguyobiv1x5 = pZtymrtisyukguyobiv1x5;
    }

    private String ztyyobiv1x2;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYYOBIV1X2)
    public String getZtyyobiv1x2() {
        return ztyyobiv1x2;
    }

    public void setZtyyobiv1x2(String pZtyyobiv1x2) {
        ztyyobiv1x2 = pZtyyobiv1x2;
    }

    private String ztykyknm;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYKYKNM)
    public String getZtykyknm() {
        return ztykyknm;
    }

    public void setZtykyknm(String pZtykyknm) {
        ztykyknm = pZtykyknm;
    }

    private String ztykjkyknm;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYKJKYKNM)
    public String getZtykjkyknm() {
        return ztykjkyknm;
    }

    public void setZtykjkyknm(String pZtykjkyknm) {
        ztykjkyknm = pZtykjkyknm;
    }

    private String ztyhhknmei;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYHHKNMEI)
    public String getZtyhhknmei() {
        return ztyhhknmei;
    }

    public void setZtyhhknmei(String pZtyhhknmei) {
        ztyhhknmei = pZtyhhknmei;
    }

    private String ztyknjhhknmei;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYKNJHHKNMEI)
    public String getZtyknjhhknmei() {
        return ztyknjhhknmei;
    }

    public void setZtyknjhhknmei(String pZtyknjhhknmei) {
        ztyknjhhknmei = pZtyknjhhknmei;
    }

    private String ztyhrkkeirokbn;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYHRKKEIROKBN)
    public String getZtyhrkkeirokbn() {
        return ztyhrkkeirokbn;
    }

    public void setZtyhrkkeirokbn(String pZtyhrkkeirokbn) {
        ztyhrkkeirokbn = pZtyhrkkeirokbn;
    }

    private String ztyanniskcd;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYANNISKCD)
    public String getZtyanniskcd() {
        return ztyanniskcd;
    }

    public void setZtyanniskcd(String pZtyanniskcd) {
        ztyanniskcd = pZtyanniskcd;
    }

    private String ztykarikeijyoukbn;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYKARIKEIJYOUKBN)
    public String getZtykarikeijyoukbn() {
        return ztykarikeijyoukbn;
    }

    public void setZtykarikeijyoukbn(String pZtykarikeijyoukbn) {
        ztykarikeijyoukbn = pZtykarikeijyoukbn;
    }

    private String ztytuikakeijyouhyj;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYTUIKAKEIJYOUHYJ)
    public String getZtytuikakeijyouhyj() {
        return ztytuikakeijyouhyj;
    }

    public void setZtytuikakeijyouhyj(String pZtytuikakeijyouhyj) {
        ztytuikakeijyouhyj = pZtytuikakeijyouhyj;
    }

    private String ztyksnhyj;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYKSNHYJ)
    public String getZtyksnhyj() {
        return ztyksnhyj;
    }

    public void setZtyksnhyj(String pZtyksnhyj) {
        ztyksnhyj = pZtyksnhyj;
    }

    private Long ztydai2ksnbubunmods;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYDAI2KSNBUBUNMODS)
    public Long getZtydai2ksnbubunmods() {
        return ztydai2ksnbubunmods;
    }

    public void setZtydai2ksnbubunmods(Long pZtydai2ksnbubunmods) {
        ztydai2ksnbubunmods = pZtydai2ksnbubunmods;
    }

    private Long ztydai2bfrksnbubunmods;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYDAI2BFRKSNBUBUNMODS)
    public Long getZtydai2bfrksnbubunmods() {
        return ztydai2bfrksnbubunmods;
    }

    public void setZtydai2bfrksnbubunmods(Long pZtydai2bfrksnbubunmods) {
        ztydai2bfrksnbubunmods = pZtydai2bfrksnbubunmods;
    }

    private String ztyphrkkikn;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYPHRKKIKN)
    public String getZtyphrkkikn() {
        return ztyphrkkikn;
    }

    public void setZtyphrkkikn(String pZtyphrkkikn) {
        ztyphrkkikn = pZtyphrkkikn;
    }

    private Long ztyjissyuup;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYJISSYUUP)
    public Long getZtyjissyuup() {
        return ztyjissyuup;
    }

    public void setZtyjissyuup(Long pZtyjissyuup) {
        ztyjissyuup = pZtyjissyuup;
    }

    private Long ztygntikktgtiryoutkp;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYGNTIKKTGTIRYOUTKP)
    public Long getZtygntikktgtiryoutkp() {
        return ztygntikktgtiryoutkp;
    }

    public void setZtygntikktgtiryoutkp(Long pZtygntikktgtiryoutkp) {
        ztygntikktgtiryoutkp = pZtygntikktgtiryoutkp;
    }

    private Long ztybfrgntikktgtiryoutkp;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYBFRGNTIKKTGTIRYOUTKP)
    public Long getZtybfrgntikktgtiryoutkp() {
        return ztybfrgntikktgtiryoutkp;
    }

    public void setZtybfrgntikktgtiryoutkp(Long pZtybfrgntikktgtiryoutkp) {
        ztybfrgntikktgtiryoutkp = pZtybfrgntikktgtiryoutkp;
    }

    private String ztydairitenkbtinfo1;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYDAIRITENKBTINFO1)
    public String getZtydairitenkbtinfo1() {
        return ztydairitenkbtinfo1;
    }

    public void setZtydairitenkbtinfo1(String pZtydairitenkbtinfo1) {
        ztydairitenkbtinfo1 = pZtydairitenkbtinfo1;
    }

    private String ztydairitenkbtinfo2;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYDAIRITENKBTINFO2)
    public String getZtydairitenkbtinfo2() {
        return ztydairitenkbtinfo2;
    }

    public void setZtydairitenkbtinfo2(String pZtydairitenkbtinfo2) {
        ztydairitenkbtinfo2 = pZtydairitenkbtinfo2;
    }

    private String ztydairitenkbtinfo3;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYDAIRITENKBTINFO3)
    public String getZtydairitenkbtinfo3() {
        return ztydairitenkbtinfo3;
    }

    public void setZtydairitenkbtinfo3(String pZtydairitenkbtinfo3) {
        ztydairitenkbtinfo3 = pZtydairitenkbtinfo3;
    }

    private Long ztysisttkp;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYSISTTKP)
    public Long getZtysisttkp() {
        return ztysisttkp;
    }

    public void setZtysisttkp(Long pZtysisttkp) {
        ztysisttkp = pZtysisttkp;
    }

    private Long ztyreguardtkp;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYREGUARDTKP)
    public Long getZtyreguardtkp() {
        return ztyreguardtkp;
    }

    public void setZtyreguardtkp(Long pZtyreguardtkp) {
        ztyreguardtkp = pZtyreguardtkp;
    }

    private Long ztyvguardtkp;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYVGUARDTKP)
    public Long getZtyvguardtkp() {
        return ztyvguardtkp;
    }

    public void setZtyvguardtkp(Long pZtyvguardtkp) {
        ztyvguardtkp = pZtyvguardtkp;
    }

    private Long ztybfrsisttkp;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYBFRSISTTKP)
    public Long getZtybfrsisttkp() {
        return ztybfrsisttkp;
    }

    public void setZtybfrsisttkp(Long pZtybfrsisttkp) {
        ztybfrsisttkp = pZtybfrsisttkp;
    }

    private Long ztybfrreguardtkp;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYBFRREGUARDTKP)
    public Long getZtybfrreguardtkp() {
        return ztybfrreguardtkp;
    }

    public void setZtybfrreguardtkp(Long pZtybfrreguardtkp) {
        ztybfrreguardtkp = pZtybfrreguardtkp;
    }

    private Long ztybfrvguardtkp;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYBFRVGUARDTKP)
    public Long getZtybfrvguardtkp() {
        return ztybfrvguardtkp;
    }

    public void setZtybfrvguardtkp(Long pZtybfrvguardtkp) {
        ztybfrvguardtkp = pZtybfrvguardtkp;
    }

    private Long ztygtmtv;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYGTMTV)
    public Long getZtygtmtv() {
        return ztygtmtv;
    }

    public void setZtygtmtv(Long pZtygtmtv) {
        ztygtmtv = pZtygtmtv;
    }

    private Long ztysyukeiyakup;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYSYUKEIYAKUP)
    public Long getZtysyukeiyakup() {
        return ztysyukeiyakup;
    }

    public void setZtysyukeiyakup(Long pZtysyukeiyakup) {
        ztysyukeiyakup = pZtysyukeiyakup;
    }

    private Long ztybfrsyup;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYBFRSYUP)
    public Long getZtybfrsyup() {
        return ztybfrsyup;
    }

    public void setZtybfrsyup(Long pZtybfrsyup) {
        ztybfrsyup = pZtybfrsyup;
    }

    private BizNumber ztydairitentsratkiwari;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DrtenTsryInfoTy.ZTYDAIRITENTSRATKIWARI)
    public BizNumber getZtydairitentsratkiwari() {
        return ztydairitentsratkiwari;
    }

    public void setZtydairitentsratkiwari(BizNumber pZtydairitentsratkiwari) {
        ztydairitentsratkiwari = pZtydairitentsratkiwari;
    }

    private String ztyseirituymd;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYSEIRITUYMD)
    public String getZtyseirituymd() {
        return ztyseirituymd;
    }

    public void setZtyseirituymd(String pZtyseirituymd) {
        ztyseirituymd = pZtyseirituymd;
    }

    private String ztysekininkaisiymd;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYSEKININKAISIYMD)
    public String getZtysekininkaisiymd() {
        return ztysekininkaisiymd;
    }

    public void setZtysekininkaisiymd(String pZtysekininkaisiymd) {
        ztysekininkaisiymd = pZtysekininkaisiymd;
    }

    private String ztycifcd;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYCIFCD)
    public String getZtycifcd() {
        return ztycifcd;
    }

    public void setZtycifcd(String pZtycifcd) {
        ztycifcd = pZtycifcd;
    }

    private String ztybankboskykkbn;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYBANKBOSKYKKBN)
    public String getZtybankboskykkbn() {
        return ztybankboskykkbn;
    }

    public void setZtybankboskykkbn(String pZtybankboskykkbn) {
        ztybankboskykkbn = pZtybankboskykkbn;
    }

    private String ztykykjiqpackhyj;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYKYKJIQPACKHYJ)
    public String getZtykykjiqpackhyj() {
        return ztykykjiqpackhyj;
    }

    public void setZtykykjiqpackhyj(String pZtykykjiqpackhyj) {
        ztykykjiqpackhyj = pZtykykjiqpackhyj;
    }

    private Long ztyitijibrzugkp;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYITIJIBRZUGKP)
    public Long getZtyitijibrzugkp() {
        return ztyitijibrzugkp;
    }

    public void setZtyitijibrzugkp(Long pZtyitijibrzugkp) {
        ztyitijibrzugkp = pZtyitijibrzugkp;
    }

    private Long ztytuuintokuyakup;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYTUUINTOKUYAKUP)
    public Long getZtytuuintokuyakup() {
        return ztytuuintokuyakup;
    }

    public void setZtytuuintokuyakup(Long pZtytuuintokuyakup) {
        ztytuuintokuyakup = pZtytuuintokuyakup;
    }

    private Long ztybfrtuuintkp;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYBFRTUUINTKP)
    public Long getZtybfrtuuintkp() {
        return ztybfrtuuintkp;
    }

    public void setZtybfrtuuintkp(Long pZtybfrtuuintkp) {
        ztybfrtuuintkp = pZtybfrtuuintkp;
    }

    private Long ztysougousonsyoutokuyakup;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYSOUGOUSONSYOUTOKUYAKUP)
    public Long getZtysougousonsyoutokuyakup() {
        return ztysougousonsyoutokuyakup;
    }

    public void setZtysougousonsyoutokuyakup(Long pZtysougousonsyoutokuyakup) {
        ztysougousonsyoutokuyakup = pZtysougousonsyoutokuyakup;
    }

    private Long ztybfrsugusnsyutkp;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYBFRSUGUSNSYUTKP)
    public Long getZtybfrsugusnsyutkp() {
        return ztybfrsugusnsyutkp;
    }

    public void setZtybfrsugusnsyutkp(Long pZtybfrsugusnsyutkp) {
        ztybfrsugusnsyutkp = pZtybfrsugusnsyutkp;
    }

    private BizNumber ztyyoteiriritun5;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DrtenTsryInfoTy.ZTYYOTEIRIRITUN5)
    public BizNumber getZtyyoteiriritun5() {
        return ztyyoteiriritun5;
    }

    public void setZtyyoteiriritun5(BizNumber pZtyyoteiriritun5) {
        ztyyoteiriritun5 = pZtyyoteiriritun5;
    }

    private Long ztyyouikunenkintokuyakup;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYYOUIKUNENKINTOKUYAKUP)
    public Long getZtyyouikunenkintokuyakup() {
        return ztyyouikunenkintokuyakup;
    }

    public void setZtyyouikunenkintokuyakup(Long pZtyyouikunenkintokuyakup) {
        ztyyouikunenkintokuyakup = pZtyyouikunenkintokuyakup;
    }

    private Long ztybfryoiknktkp;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYBFRYOIKNKTKP)
    public Long getZtybfryoiknktkp() {
        return ztybfryoiknktkp;
    }

    public void setZtybfryoiknktkp(Long pZtybfryoiknktkp) {
        ztybfryoiknktkp = pZtybfryoiknktkp;
    }

    private Long ztygntikktgtiryoutkntgk;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYGNTIKKTGTIRYOUTKNTGK)
    public Long getZtygntikktgtiryoutkntgk() {
        return ztygntikktgtiryoutkntgk;
    }

    public void setZtygntikktgtiryoutkntgk(Long pZtygntikktgtiryoutkntgk) {
        ztygntikktgtiryoutkntgk = pZtygntikktgtiryoutkntgk;
    }

    private String ztykyksyaskinmeino;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYKYKSYASKINMEINO)
    public String getZtykyksyaskinmeino() {
        return ztykyksyaskinmeino;
    }

    public void setZtykyksyaskinmeino(String pZtykyksyaskinmeino) {
        ztykyksyaskinmeino = pZtykyksyaskinmeino;
    }

    private String ztyhhknsakuinmeino;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYHHKNSAKUINMEINO)
    public String getZtyhhknsakuinmeino() {
        return ztyhhknsakuinmeino;
    }

    public void setZtyhhknsakuinmeino(String pZtyhhknsakuinmeino) {
        ztyhhknsakuinmeino = pZtyhhknsakuinmeino;
    }

    private String ztysinkykbosyuoyadrtencd;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYSINKYKBOSYUOYADRTENCD)
    public String getZtysinkykbosyuoyadrtencd() {
        return ztysinkykbosyuoyadrtencd;
    }

    public void setZtysinkykbosyuoyadrtencd(String pZtysinkykbosyuoyadrtencd) {
        ztysinkykbosyuoyadrtencd = pZtysinkykbosyuoyadrtencd;
    }

    private BizNumber ztysyouhizeiritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DrtenTsryInfoTy.ZTYSYOUHIZEIRITU)
    public BizNumber getZtysyouhizeiritu() {
        return ztysyouhizeiritu;
    }

    public void setZtysyouhizeiritu(BizNumber pZtysyouhizeiritu) {
        ztysyouhizeiritu = pZtysyouhizeiritu;
    }

    private String ztymdhnaisyoumeicd;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYMDHNAISYOUMEICD)
    public String getZtymdhnaisyoumeicd() {
        return ztymdhnaisyoumeicd;
    }

    public void setZtymdhnaisyoumeicd(String pZtymdhnaisyoumeicd) {
        ztymdhnaisyoumeicd = pZtymdhnaisyoumeicd;
    }

    private String ztycoolingofhyj;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYCOOLINGOFHYJ)
    public String getZtycoolingofhyj() {
        return ztycoolingofhyj;
    }

    public void setZtycoolingofhyj(String pZtycoolingofhyj) {
        ztycoolingofhyj = pZtycoolingofhyj;
    }

    private String ztysaimnkkykhyj;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYSAIMNKKYKHYJ)
    public String getZtysaimnkkykhyj() {
        return ztysaimnkkykhyj;
    }

    public void setZtysaimnkkykhyj(String pZtysaimnkkykhyj) {
        ztysaimnkkykhyj = pZtysaimnkkykhyj;
    }

    private String ztypjytoym;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYPJYTOYM)
    public String getZtypjytoym() {
        return ztypjytoym;
    }

    public void setZtypjytoym(String pZtypjytoym) {
        ztypjytoym = pZtypjytoym;
    }

    private String ztysskhntihrkkisukbn;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYSSKHNTIHRKKISUKBN)
    public String getZtysskhntihrkkisukbn() {
        return ztysskhntihrkkisukbn;
    }

    public void setZtysskhntihrkkisukbn(String pZtysskhntihrkkisukbn) {
        ztysskhntihrkkisukbn = pZtysskhntihrkkisukbn;
    }

    private String ztyphenkanarihyj;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYPHENKANARIHYJ)
    public String getZtyphenkanarihyj() {
        return ztyphenkanarihyj;
    }

    public void setZtyphenkanarihyj(String pZtyphenkanarihyj) {
        ztyphenkanarihyj = pZtyphenkanarihyj;
    }

    private String ztyhjnkykhyj;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYHJNKYKHYJ)
    public String getZtyhjnkykhyj() {
        return ztyhjnkykhyj;
    }

    public void setZtyhjnkykhyj(String pZtyhjnkykhyj) {
        ztyhjnkykhyj = pZtyhjnkykhyj;
    }

    private String ztybktgomeisaicalcjyun;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYBKTGOMEISAICALCJYUN)
    public String getZtybktgomeisaicalcjyun() {
        return ztybktgomeisaicalcjyun;
    }

    public void setZtybktgomeisaicalcjyun(String pZtybktgomeisaicalcjyun) {
        ztybktgomeisaicalcjyun = pZtybktgomeisaicalcjyun;
    }

    private String ztyikkatubaraikbn;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYIKKATUBARAIKBN)
    public String getZtyikkatubaraikbn() {
        return ztyikkatubaraikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyikkatubaraikbn(String pZtyikkatubaraikbn) {
        ztyikkatubaraikbn = pZtyikkatubaraikbn;
    }

    private String ztyikkatubaraikaisuu;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYIKKATUBARAIKAISUU)
    public String getZtyikkatubaraikaisuu() {
        return ztyikkatubaraikaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyikkatubaraikaisuu(String pZtyikkatubaraikaisuu) {
        ztyikkatubaraikaisuu = pZtyikkatubaraikaisuu;
    }

    private String ztyuktkid;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYUKTKID)
    public String getZtyuktkid() {
        return ztyuktkid;
    }

    public void setZtyuktkid(String pZtyuktkid) {
        ztyuktkid = pZtyuktkid;
    }

    private Long ztykigmrsytkp;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYKIGMRSYTKP)
    public Long getZtykigmrsytkp() {
        return ztykigmrsytkp;
    }

    public void setZtykigmrsytkp(Long pZtykigmrsytkp) {
        ztykigmrsytkp = pZtykigmrsytkp;
    }

    private Long ztybfrkigmrsytkp;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYBFRKIGMRSYTKP)
    public Long getZtybfrkigmrsytkp() {
        return ztybfrkigmrsytkp;
    }

    public void setZtybfrkigmrsytkp(Long pZtybfrkigmrsytkp) {
        ztybfrkigmrsytkp = pZtybfrkigmrsytkp;
    }

    private String ztykigmrsytkphrkkkn;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYKIGMRSYTKPHRKKKN)
    public String getZtykigmrsytkphrkkkn() {
        return ztykigmrsytkphrkkkn;
    }

    public void setZtykigmrsytkphrkkkn(String pZtykigmrsytkphrkkkn) {
        ztykigmrsytkphrkkkn = pZtykigmrsytkphrkkkn;
    }

    private String ztyyobiv5;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYYOBIV5)
    public String getZtyyobiv5() {
        return ztyyobiv5;
    }

    public void setZtyyobiv5(String pZtyyobiv5) {
        ztyyobiv5 = pZtyyobiv5;
    }

    private Long ztyphenkanbfrsyup;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYPHENKANBFRSYUP)
    public Long getZtyphenkanbfrsyup() {
        return ztyphenkanbfrsyup;
    }

    public void setZtyphenkanbfrsyup(Long pZtyphenkanbfrsyup) {
        ztyphenkanbfrsyup = pZtyphenkanbfrsyup;
    }

    private Integer ztyyobin3;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYYOBIN3)
    public Integer getZtyyobin3() {
        return ztyyobin3;
    }

    public void setZtyyobin3(Integer pZtyyobin3) {
        ztyyobin3 = pZtyyobin3;
    }

    private BizNumber ztytousyokykjikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DrtenTsryInfoTy.ZTYTOUSYOKYKJIKAWASERATE)
    public BizNumber getZtytousyokykjikawaserate() {
        return ztytousyokykjikawaserate;
    }

    public void setZtytousyokykjikawaserate(BizNumber pZtytousyokykjikawaserate) {
        ztytousyokykjikawaserate = pZtytousyokykjikawaserate;
    }

    private Long ztyyobin11;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYYOBIN11)
    public Long getZtyyobin11() {
        return ztyyobin11;
    }

    public void setZtyyobin11(Long pZtyyobin11) {
        ztyyobin11 = pZtyyobin11;
    }

    private Long ztyyobin11x2;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYYOBIN11X2)
    public Long getZtyyobin11x2() {
        return ztyyobin11x2;
    }

    public void setZtyyobin11x2(Long pZtyyobin11x2) {
        ztyyobin11x2 = pZtyyobin11x2;
    }

    private Long ztyyobin11x3;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYYOBIN11X3)
    public Long getZtyyobin11x3() {
        return ztyyobin11x3;
    }

    public void setZtyyobin11x3(Long pZtyyobin11x3) {
        ztyyobin11x3 = pZtyyobin11x3;
    }

    private Long ztyyobin11x4;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYYOBIN11X4)
    public Long getZtyyobin11x4() {
        return ztyyobin11x4;
    }

    public void setZtyyobin11x4(Long pZtyyobin11x4) {
        ztyyobin11x4 = pZtyyobin11x4;
    }

    private Long ztyyobin11x5;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYYOBIN11X5)
    public Long getZtyyobin11x5() {
        return ztyyobin11x5;
    }

    public void setZtyyobin11x5(Long pZtyyobin11x5) {
        ztyyobin11x5 = pZtyyobin11x5;
    }

    private Long ztyyobin11x6;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYYOBIN11X6)
    public Long getZtyyobin11x6() {
        return ztyyobin11x6;
    }

    public void setZtyyobin11x6(Long pZtyyobin11x6) {
        ztyyobin11x6 = pZtyyobin11x6;
    }

    private Long ztyyobin11x7;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYYOBIN11X7)
    public Long getZtyyobin11x7() {
        return ztyyobin11x7;
    }

    public void setZtyyobin11x7(Long pZtyyobin11x7) {
        ztyyobin11x7 = pZtyyobin11x7;
    }

    private Long ztyyobin11x8;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYYOBIN11X8)
    public Long getZtyyobin11x8() {
        return ztyyobin11x8;
    }

    public void setZtyyobin11x8(Long pZtyyobin11x8) {
        ztyyobin11x8 = pZtyyobin11x8;
    }

    private String ztyshzirtstkjynymd;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYSHZIRTSTKJYNYMD)
    public String getZtyshzirtstkjynymd() {
        return ztyshzirtstkjynymd;
    }

    public void setZtyshzirtstkjynymd(String pZtyshzirtstkjynymd) {
        ztyshzirtstkjynymd = pZtyshzirtstkjynymd;
    }

    private String ztykyksyaseiymd;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYKYKSYASEIYMD)
    public String getZtykyksyaseiymd() {
        return ztykyksyaseiymd;
    }

    public void setZtykyksyaseiymd(String pZtykyksyaseiymd) {
        ztykyksyaseiymd = pZtykyksyaseiymd;
    }

    private String ztytuukacd;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYTUUKACD)
    public String getZtytuukacd() {
        return ztytuukacd;
    }

    public void setZtytuukacd(String pZtytuukacd) {
        ztytuukacd = pZtytuukacd;
    }

    private Long ztysyukeiyakupkyktuuka;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYSYUKEIYAKUPKYKTUUKA)
    public Long getZtysyukeiyakupkyktuuka() {
        return ztysyukeiyakupkyktuuka;
    }

    public void setZtysyukeiyakupkyktuuka(Long pZtysyukeiyakupkyktuuka) {
        ztysyukeiyakupkyktuuka = pZtysyukeiyakupkyktuuka;
    }

    private Long ztybfrsyupkyktuuka;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYBFRSYUPKYKTUUKA)
    public Long getZtybfrsyupkyktuuka() {
        return ztybfrsyupkyktuuka;
    }

    public void setZtybfrsyupkyktuuka(Long pZtybfrsyupkyktuuka) {
        ztybfrsyupkyktuuka = pZtybfrsyupkyktuuka;
    }

    private BizNumber ztytekiyoukawaserate7keta;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DrtenTsryInfoTy.ZTYTEKIYOUKAWASERATE7KETA)
    public BizNumber getZtytekiyoukawaserate7keta() {
        return ztytekiyoukawaserate7keta;
    }

    public void setZtytekiyoukawaserate7keta(BizNumber pZtytekiyoukawaserate7keta) {
        ztytekiyoukawaserate7keta = pZtytekiyoukawaserate7keta;
    }

    private String ztyyobiv22;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYYOBIV22)
    public String getZtyyobiv22() {
        return ztyyobiv22;
    }

    public void setZtyyobiv22(String pZtyyobiv22) {
        ztyyobiv22 = pZtyyobiv22;
    }

    private String ztyyobiv83;

    @Column(name=GenZT_DrtenTsryInfoTy.ZTYYOBIV83)
    public String getZtyyobiv83() {
        return ztyyobiv83;
    }

    public void setZtyyobiv83(String pZtyyobiv83) {
        ztyyobiv83 = pZtyyobiv83;
    }
}