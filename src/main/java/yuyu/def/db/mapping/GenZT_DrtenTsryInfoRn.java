package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_DrtenTsryInfoRn;
import yuyu.def.db.id.PKZT_DrtenTsryInfoRn;
import yuyu.def.db.meta.GenQZT_DrtenTsryInfoRn;
import yuyu.def.db.meta.QZT_DrtenTsryInfoRn;

/**
 * 代理店手数料情報Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_DrtenTsryInfoRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DrtenTsryInfoRn}</td><td colspan="3">代理店手数料情報Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrndairitencd zrndairitencd}</td><td>（連携用）代理店コード</td><td align="center">{@link PKZT_DrtenTsryInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuunincd zrnbosyuunincd}</td><td>（連携用）募集人コード</td><td align="center">{@link PKZT_DrtenTsryInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_DrtenTsryInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakukbn zrnkeiyakukbn}</td><td>（連携用）契約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakuno zrntokuyakuno}</td><td>（連携用）特約番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyym zrnbsyym}</td><td>（連携用）募集年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkydatkibosyuucd zrnkydatkibosyuucd}</td><td>（連携用）共同扱募集人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseiritujibumoncd zrnseiritujibumoncd}</td><td>（連携用）成立時部門コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseiritujiagutiknrcd zrnseiritujiagutiknrcd}</td><td>（連携用）成立時代理店内管理扱者コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1 zrnyobiv1}</td><td>（連携用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkydeigyouakojincd zrnkydeigyouakojincd}</td><td>（連携用）共同扱営業員Ａ扱者個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkydeigyoubkojincd zrnkydeigyoubkojincd}</td><td>（連携用）共同扱営業員Ｂ扱者個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskeihyj zrnskeihyj}</td><td>（連携用）新契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndenymd zrndenymd}</td><td>（連携用）伝票日付</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkikaisyoriymd zrnkikaisyoriymd}</td><td>（連携用）機械処理年月日</td><td align="center">{@link PKZT_DrtenTsryInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoricd zrnsyoricd}</td><td>（連携用）処理コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouseijiyuu zrntyouseijiyuu}</td><td>（連携用）調整事由</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyknmonth zrnnyknmonth}</td><td>（連携用）入金月数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsikibetujyunjyo zrnsikibetujyunjyo}</td><td>（連携用）識別順序</td><td align="center">{@link PKZT_DrtenTsryInfoRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntnsmacezugkukbn zrntnsmacezugkukbn}</td><td>（連携用）たのしみＡｃｅ増額区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnacezugkkrykkaisiymd zrnacezugkkrykkaisiymd}</td><td>（連携用）Ａｃｅ増額効力開始年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv4 zrnyobiv4}</td><td>（連携用）予備項目Ｖ４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykmfksnctrlkh zrnkykmfksnctrlkh}</td><td>（連携用）契約ＭＦ更新ＣＴＲ（保全）</td><td align="center">{@link PKZT_DrtenTsryInfoRn ○}</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndairitenatkikeitaikbn zrndairitenatkikeitaikbn}</td><td>（連携用）代理店扱形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatkiwari zrnatkiwari}</td><td>（連携用）扱割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrndairitenatkinin zrndairitenatkinin}</td><td>（連携用）代理店扱人数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntsrkeisansyukykhsyos zrntsrkeisansyukykhsyos}</td><td>（連携用）手数料計算用主契約保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhtns zrnhtns}</td><td>（連携用）被転換Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkijymods zrnkijymods}</td><td>（連携用）計上修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnksnbubunmods zrnksnbubunmods}</td><td>（連携用）加算部分修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnbfrkijymods zrnbfrkijymods}</td><td>（連携用）変更前計上修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnbfrksnbubunmods zrnbfrksnbubunmods}</td><td>（連携用）変更前加算部分修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruikigousedaikbn zrnhknsyuruikigousedaikbn}</td><td>（連携用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksyukgu zrntksyukgu}</td><td>（連携用）特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksyukgusedaikbn zrntksyukgusedaikbn}</td><td>（連携用）特約種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaifuyouriyuukbn zrnannaifuyouriyuukbn}</td><td>（連携用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnen2keta zrnhhknnen2keta}</td><td>（連携用）被保険者年令（２桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknkkn zrnhknkkn}</td><td>（連携用）保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfstkeijyouhtkm zrnfstkeijyouhtkm}</td><td>（連携用）初回計上判定項目</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsrytsryhushrkbn zrntsrytsryhushrkbn}</td><td>（連携用）手数料不支払区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbfritijibrzugkp zrnbfritijibrzugkp}</td><td>（連携用）変更前一時払増額Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmaruteisyuruikigou zrnmaruteisyuruikigou}</td><td>（連携用）マル定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmrtihukakbn zrnmrtihukakbn}</td><td>（連携用）マル定付加区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsznmrtihukakbn zrnsznmrtihukakbn}</td><td>（連携用）生存マル定付加区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigenmrtihukakbn zrnteigenmrtihukakbn}</td><td>（連携用）逓減マル定付加区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyunyumrtihukakbn zrnsyunyumrtihukakbn}</td><td>（連携用）収入マル定付加区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihukakbn zrnkzkmrtihukakbn}</td><td>（連携用）家族マル定付加区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoksipmrtihukakbn zrntoksipmrtihukakbn}</td><td>（連携用）特定疾病マル定付加区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoksipmrsyhukakbn zrntoksipmrsyhukakbn}</td><td>（連携用）特定疾病マル終付加区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmanskknmrtihukakbn zrnmanskknmrtihukakbn}</td><td>（連携用）慢性疾患マル定付加区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigsyunyumrtihukakbn zrnkigsyunyumrtihukakbn}</td><td>（連携用）介護収入マル定付加区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigteigenmrtihukakbn zrnkigteigenmrtihukakbn}</td><td>（連携用）介護逓減マル定付加区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkignktkhukakbn zrnkignktkhukakbn}</td><td>（連携用）介護年金特約付加区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigmrtihukakbn zrnkigmrtihukakbn}</td><td>（連携用）介護マル定付加区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmrtisyukguyobiv1 zrnmrtisyukguyobiv1}</td><td>（連携用）マル定種類記号予備１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmrtisyukguyobiv1x2 zrnmrtisyukguyobiv1x2}</td><td>（連携用）マル定種類記号予備２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmrtisyukguyobiv1x3 zrnmrtisyukguyobiv1x3}</td><td>（連携用）マル定種類記号予備３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmrtisyukguyobiv1x4 zrnmrtisyukguyobiv1x4}</td><td>（連携用）マル定種類記号予備４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmrtisyukguyobiv1x5 zrnmrtisyukguyobiv1x5}</td><td>（連携用）マル定種類記号予備５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1x2 zrnyobiv1x2}</td><td>（連携用）予備項目Ｖ１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknm zrnkyknm}</td><td>（連携用）契約者名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkyknm zrnkjkyknm}</td><td>（連携用）漢字契約者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknmei zrnhhknmei}</td><td>（連携用）被保険者名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknjhhknmei zrnknjhhknmei}</td><td>（連携用）漢字被保険者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirokbn zrnhrkkeirokbn}</td><td>（連携用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnanniskcd zrnanniskcd}</td><td>（連携用）案内先コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkarikeijyoukbn zrnkarikeijyoukbn}</td><td>（連携用）仮計上区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuikakeijyouhyj zrntuikakeijyouhyj}</td><td>（連携用）追加計上表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnksnhyj zrnksnhyj}</td><td>（連携用）更新表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2ksnbubunmods zrndai2ksnbubunmods}</td><td>（連携用）第２加算部分修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndai2bfrksnbubunmods zrndai2bfrksnbubunmods}</td><td>（連携用）第２変更前加算部分修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnphrkkikn zrnphrkkikn}</td><td>（連携用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjissyuup zrnjissyuup}</td><td>（連携用）実収Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngntikktgtiryoutkp zrngntikktgtiryoutkp}</td><td>（連携用）限定告知型医療特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnbfrgntikktgtiryoutkp zrnbfrgntikktgtiryoutkp}</td><td>（連携用）変更前限定告知型医療特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndairitenkbtinfo1 zrndairitenkbtinfo1}</td><td>（連携用）代理店個別情報１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitenkbtinfo2 zrndairitenkbtinfo2}</td><td>（連携用）代理店個別情報２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitenkbtinfo3 zrndairitenkbtinfo3}</td><td>（連携用）代理店個別情報３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisttkp zrnsisttkp}</td><td>（連携用）災疾特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnreguardtkp zrnreguardtkp}</td><td>（連携用）リガード特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnvguardtkp zrnvguardtkp}</td><td>（連携用）Ｖガード特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnbfrsisttkp zrnbfrsisttkp}</td><td>（連携用）変更前災疾特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnbfrreguardtkp zrnbfrreguardtkp}</td><td>（連携用）変更前リガード特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnbfrvguardtkp zrnbfrvguardtkp}</td><td>（連携用）変更前Ｖガード特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngtmtv zrngtmtv}</td><td>（連携用）月末Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakup zrnsyukeiyakup}</td><td>（連携用）主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnbfrsyup zrnbfrsyup}</td><td>（連携用）変更前主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndairitentsratkiwari zrndairitentsratkiwari}</td><td>（連携用）代理店手数料扱割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnseirituymd zrnseirituymd}</td><td>（連携用）成立年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsekininkaisiymd zrnsekininkaisiymd}</td><td>（連携用）責任開始年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncifcd zrncifcd}</td><td>（連携用）ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbankboskykkbn zrnbankboskykkbn}</td><td>（連携用）銀行募集契約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykjiqpackhyj zrnkykjiqpackhyj}</td><td>（連携用）契約時Ｑパック表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitijibrzugkp zrnitijibrzugkp}</td><td>（連携用）一時払増額Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntuuintokuyakup zrntuuintokuyakup}</td><td>（連携用）通院特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnbfrtuuintkp zrnbfrtuuintkp}</td><td>（連携用）変更前通院特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsougousonsyoutokuyakup zrnsougousonsyoutokuyakup}</td><td>（連携用）総合損傷特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnbfrsugusnsyutkp zrnbfrsugusnsyutkp}</td><td>（連携用）変更前総合損傷特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritun5 zrnyoteiriritun5}</td><td>（連携用）予定利率Ｎ５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyouikunenkintokuyakup zrnyouikunenkintokuyakup}</td><td>（連携用）養育年金特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnbfryoiknktkp zrnbfryoiknktkp}</td><td>（連携用）変更前養育年金特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngntikktgtiryoutkntgk zrngntikktgtiryoutkntgk}</td><td>（連携用）限定告知型医療特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkyksyaskinmeino zrnkyksyaskinmeino}</td><td>（連携用）契約者索引名番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknsakuinmeino zrnhhknsakuinmeino}</td><td>（連携用）被保険者索引名番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsinkykbosyuoyadrtencd zrnsinkykbosyuoyadrtencd}</td><td>（連携用）新契約募集時親代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyouhizeiritu zrnsyouhizeiritu}</td><td>（連携用）消費税率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnmdhnaisyoumeicd zrnmdhnaisyoumeicd}</td><td>（連携用）窓販用愛称名コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncoolingofhyj zrncoolingofhyj}</td><td>（連携用）クーリングオフ表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaimnkkykhyj zrnsaimnkkykhyj}</td><td>（連携用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpjytoym zrnpjytoym}</td><td>（連携用）Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsskhntihrkkisukbn zrnsskhntihrkkisukbn}</td><td>（連携用）成績判定用払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphenkanarihyj zrnphenkanarihyj}</td><td>（連携用）Ｐ返還あり表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhjnkykhyj zrnhjnkykhyj}</td><td>（連携用）法人契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbktgomeisaicalcjyun zrnbktgomeisaicalcjyun}</td><td>（連携用）分割後明細計算順</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnikkatubaraikbn zrnikkatubaraikbn}</td><td>（連携用）一括払区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnikkatubaraikaisuu zrnikkatubaraikaisuu}</td><td>（連携用）一括払回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktkid zrnuktkid}</td><td>（連携用）受付管理ＩＤ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigmrsytkp zrnkigmrsytkp}</td><td>（連携用）介護マル終特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnbfrkigmrsytkp zrnbfrkigmrsytkp}</td><td>（連携用）変更前介護マル終特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkigmrsytkphrkkkn zrnkigmrsytkphrkkkn}</td><td>（連携用）介護マル終特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv5 zrnyobiv5}</td><td>（連携用）予備項目Ｖ５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphenkanbfrsyup zrnphenkanbfrsyup}</td><td>（連携用）Ｐ返還用変更前主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin3 zrnyobin3}</td><td>（連携用）予備項目Ｎ３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrntousyokykjikawaserate zrntousyokykjikawaserate}</td><td>（連携用）当初契約時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyobin11 zrnyobin11}</td><td>（連携用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x2 zrnyobin11x2}</td><td>（連携用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x3 zrnyobin11x3}</td><td>（連携用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x4 zrnyobin11x4}</td><td>（連携用）予備項目Ｎ１１＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x5 zrnyobin11x5}</td><td>（連携用）予備項目Ｎ１１＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x6 zrnyobin11x6}</td><td>（連携用）予備項目Ｎ１１＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x7 zrnyobin11x7}</td><td>（連携用）予備項目Ｎ１１＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobin11x8 zrnyobin11x8}</td><td>（連携用）予備項目Ｎ１１＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnshzirtstkjynymd zrnshzirtstkjynymd}</td><td>（連携用）消費税率設定基準年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyaseiymd zrnkyksyaseiymd}</td><td>（連携用）契約者生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuukacd zrntuukacd}</td><td>（連携用）通貨コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakupkyktuuka zrnsyukeiyakupkyktuuka}</td><td>（連携用）主契約Ｐ（契約通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnbfrsyupkyktuuka zrnbfrsyupkyktuuka}</td><td>（連携用）変更前主契約Ｐ（契約通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntekiyoukawaserate7keta zrntekiyoukawaserate7keta}</td><td>（連携用）適用為替レート（７桁）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyobiv22 zrnyobiv22}</td><td>（連携用）予備項目Ｖ２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv83 zrnyobiv83}</td><td>（連携用）予備項目Ｖ８３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_DrtenTsryInfoRn
 * @see     PKZT_DrtenTsryInfoRn
 * @see     QZT_DrtenTsryInfoRn
 * @see     GenQZT_DrtenTsryInfoRn
 */
@MappedSuperclass
@Table(name=GenZT_DrtenTsryInfoRn.TABLE_NAME)
@IdClass(value=PKZT_DrtenTsryInfoRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_DrtenTsryInfoRn extends AbstractExDBEntityForZDB<ZT_DrtenTsryInfoRn, PKZT_DrtenTsryInfoRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DrtenTsryInfoRn";
    public static final String ZRNDAIRITENCD            = "zrndairitencd";
    public static final String ZRNBOSYUUNINCD           = "zrnbosyuunincd";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNKEIYAKUKBN            = "zrnkeiyakukbn";
    public static final String ZRNTOKUYAKUNO            = "zrntokuyakuno";
    public static final String ZRNBSYYM                 = "zrnbsyym";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNKYDATKIBOSYUUCD       = "zrnkydatkibosyuucd";
    public static final String ZRNSEIRITUJIBUMONCD      = "zrnseiritujibumoncd";
    public static final String ZRNSEIRITUJIAGUTIKNRCD   = "zrnseiritujiagutiknrcd";
    public static final String ZRNYOBIV1                = "zrnyobiv1";
    public static final String ZRNKYDEIGYOUAKOJINCD     = "zrnkydeigyouakojincd";
    public static final String ZRNKYDEIGYOUBKOJINCD     = "zrnkydeigyoubkojincd";
    public static final String ZRNSKEIHYJ               = "zrnskeihyj";
    public static final String ZRNDENYMD                = "zrndenymd";
    public static final String ZRNKIKAISYORIYMD         = "zrnkikaisyoriymd";
    public static final String ZRNSYORICD               = "zrnsyoricd";
    public static final String ZRNTYOUSEIJIYUU          = "zrntyouseijiyuu";
    public static final String ZRNNYKNMONTH             = "zrnnyknmonth";
    public static final String ZRNSIKIBETUJYUNJYO       = "zrnsikibetujyunjyo";
    public static final String ZRNTNSMACEZUGKUKBN       = "zrntnsmacezugkukbn";
    public static final String ZRNACEZUGKKRYKKAISIYMD   = "zrnacezugkkrykkaisiymd";
    public static final String ZRNYOBIV4                = "zrnyobiv4";
    public static final String ZRNKYKMFKSNCTRLKH        = "zrnkykmfksnctrlkh";
    public static final String ZRNDAIRITENATKIKEITAIKBN = "zrndairitenatkikeitaikbn";
    public static final String ZRNATKIWARI              = "zrnatkiwari";
    public static final String ZRNDAIRITENATKININ       = "zrndairitenatkinin";
    public static final String ZRNTSRKEISANSYUKYKHSYOS  = "zrntsrkeisansyukykhsyos";
    public static final String ZRNHTNS                  = "zrnhtns";
    public static final String ZRNKIJYMODS              = "zrnkijymods";
    public static final String ZRNKSNBUBUNMODS          = "zrnksnbubunmods";
    public static final String ZRNBFRKIJYMODS           = "zrnbfrkijymods";
    public static final String ZRNBFRKSNBUBUNMODS       = "zrnbfrksnbubunmods";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNHKNSYURUIKIGOUSEDAIKBN = "zrnhknsyuruikigousedaikbn";
    public static final String ZRNTKSYUKGU              = "zrntksyukgu";
    public static final String ZRNTKSYUKGUSEDAIKBN      = "zrntksyukgusedaikbn";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNANNAIFUYOURIYUUKBN    = "zrnannaifuyouriyuukbn";
    public static final String ZRNHHKNNEN2KETA          = "zrnhhknnen2keta";
    public static final String ZRNHKNKKN                = "zrnhknkkn";
    public static final String ZRNFSTKEIJYOUHTKM        = "zrnfstkeijyouhtkm";
    public static final String ZRNTSRYTSRYHUSHRKBN      = "zrntsrytsryhushrkbn";
    public static final String ZRNBFRITIJIBRZUGKP       = "zrnbfritijibrzugkp";
    public static final String ZRNMARUTEISYURUIKIGOU    = "zrnmaruteisyuruikigou";
    public static final String ZRNMRTIHUKAKBN           = "zrnmrtihukakbn";
    public static final String ZRNSZNMRTIHUKAKBN        = "zrnsznmrtihukakbn";
    public static final String ZRNTEIGENMRTIHUKAKBN     = "zrnteigenmrtihukakbn";
    public static final String ZRNSYUNYUMRTIHUKAKBN     = "zrnsyunyumrtihukakbn";
    public static final String ZRNKZKMRTIHUKAKBN        = "zrnkzkmrtihukakbn";
    public static final String ZRNTOKSIPMRTIHUKAKBN     = "zrntoksipmrtihukakbn";
    public static final String ZRNTOKSIPMRSYHUKAKBN     = "zrntoksipmrsyhukakbn";
    public static final String ZRNMANSKKNMRTIHUKAKBN    = "zrnmanskknmrtihukakbn";
    public static final String ZRNKIGSYUNYUMRTIHUKAKBN  = "zrnkigsyunyumrtihukakbn";
    public static final String ZRNKIGTEIGENMRTIHUKAKBN  = "zrnkigteigenmrtihukakbn";
    public static final String ZRNKIGNKTKHUKAKBN        = "zrnkignktkhukakbn";
    public static final String ZRNKIGMRTIHUKAKBN        = "zrnkigmrtihukakbn";
    public static final String ZRNMRTISYUKGUYOBIV1      = "zrnmrtisyukguyobiv1";
    public static final String ZRNMRTISYUKGUYOBIV1X2    = "zrnmrtisyukguyobiv1x2";
    public static final String ZRNMRTISYUKGUYOBIV1X3    = "zrnmrtisyukguyobiv1x3";
    public static final String ZRNMRTISYUKGUYOBIV1X4    = "zrnmrtisyukguyobiv1x4";
    public static final String ZRNMRTISYUKGUYOBIV1X5    = "zrnmrtisyukguyobiv1x5";
    public static final String ZRNYOBIV1X2              = "zrnyobiv1x2";
    public static final String ZRNKYKNM                 = "zrnkyknm";
    public static final String ZRNKJKYKNM               = "zrnkjkyknm";
    public static final String ZRNHHKNMEI               = "zrnhhknmei";
    public static final String ZRNKNJHHKNMEI            = "zrnknjhhknmei";
    public static final String ZRNHRKKEIROKBN           = "zrnhrkkeirokbn";
    public static final String ZRNANNISKCD              = "zrnanniskcd";
    public static final String ZRNKARIKEIJYOUKBN        = "zrnkarikeijyoukbn";
    public static final String ZRNTUIKAKEIJYOUHYJ       = "zrntuikakeijyouhyj";
    public static final String ZRNKSNHYJ                = "zrnksnhyj";
    public static final String ZRNDAI2KSNBUBUNMODS      = "zrndai2ksnbubunmods";
    public static final String ZRNDAI2BFRKSNBUBUNMODS   = "zrndai2bfrksnbubunmods";
    public static final String ZRNPHRKKIKN              = "zrnphrkkikn";
    public static final String ZRNJISSYUUP              = "zrnjissyuup";
    public static final String ZRNGNTIKKTGTIRYOUTKP     = "zrngntikktgtiryoutkp";
    public static final String ZRNBFRGNTIKKTGTIRYOUTKP  = "zrnbfrgntikktgtiryoutkp";
    public static final String ZRNDAIRITENKBTINFO1      = "zrndairitenkbtinfo1";
    public static final String ZRNDAIRITENKBTINFO2      = "zrndairitenkbtinfo2";
    public static final String ZRNDAIRITENKBTINFO3      = "zrndairitenkbtinfo3";
    public static final String ZRNSISTTKP               = "zrnsisttkp";
    public static final String ZRNREGUARDTKP            = "zrnreguardtkp";
    public static final String ZRNVGUARDTKP             = "zrnvguardtkp";
    public static final String ZRNBFRSISTTKP            = "zrnbfrsisttkp";
    public static final String ZRNBFRREGUARDTKP         = "zrnbfrreguardtkp";
    public static final String ZRNBFRVGUARDTKP          = "zrnbfrvguardtkp";
    public static final String ZRNGTMTV                 = "zrngtmtv";
    public static final String ZRNSYUKEIYAKUP           = "zrnsyukeiyakup";
    public static final String ZRNBFRSYUP               = "zrnbfrsyup";
    public static final String ZRNDAIRITENTSRATKIWARI   = "zrndairitentsratkiwari";
    public static final String ZRNSEIRITUYMD            = "zrnseirituymd";
    public static final String ZRNSEKININKAISIYMD       = "zrnsekininkaisiymd";
    public static final String ZRNCIFCD                 = "zrncifcd";
    public static final String ZRNBANKBOSKYKKBN         = "zrnbankboskykkbn";
    public static final String ZRNKYKJIQPACKHYJ         = "zrnkykjiqpackhyj";
    public static final String ZRNITIJIBRZUGKP          = "zrnitijibrzugkp";
    public static final String ZRNTUUINTOKUYAKUP        = "zrntuuintokuyakup";
    public static final String ZRNBFRTUUINTKP           = "zrnbfrtuuintkp";
    public static final String ZRNSOUGOUSONSYOUTOKUYAKUP = "zrnsougousonsyoutokuyakup";
    public static final String ZRNBFRSUGUSNSYUTKP       = "zrnbfrsugusnsyutkp";
    public static final String ZRNYOTEIRIRITUN5         = "zrnyoteiriritun5";
    public static final String ZRNYOUIKUNENKINTOKUYAKUP = "zrnyouikunenkintokuyakup";
    public static final String ZRNBFRYOIKNKTKP          = "zrnbfryoiknktkp";
    public static final String ZRNGNTIKKTGTIRYOUTKNTGK  = "zrngntikktgtiryoutkntgk";
    public static final String ZRNKYKSYASKINMEINO       = "zrnkyksyaskinmeino";
    public static final String ZRNHHKNSAKUINMEINO       = "zrnhhknsakuinmeino";
    public static final String ZRNSINKYKBOSYUOYADRTENCD = "zrnsinkykbosyuoyadrtencd";
    public static final String ZRNSYOUHIZEIRITU         = "zrnsyouhizeiritu";
    public static final String ZRNMDHNAISYOUMEICD       = "zrnmdhnaisyoumeicd";
    public static final String ZRNCOOLINGOFHYJ          = "zrncoolingofhyj";
    public static final String ZRNSAIMNKKYKHYJ          = "zrnsaimnkkykhyj";
    public static final String ZRNPJYTOYM               = "zrnpjytoym";
    public static final String ZRNSSKHNTIHRKKISUKBN     = "zrnsskhntihrkkisukbn";
    public static final String ZRNPHENKANARIHYJ         = "zrnphenkanarihyj";
    public static final String ZRNHJNKYKHYJ             = "zrnhjnkykhyj";
    public static final String ZRNBKTGOMEISAICALCJYUN   = "zrnbktgomeisaicalcjyun";
    public static final String ZRNIKKATUBARAIKBN        = "zrnikkatubaraikbn";
    public static final String ZRNIKKATUBARAIKAISUU     = "zrnikkatubaraikaisuu";
    public static final String ZRNUKTKID                = "zrnuktkid";
    public static final String ZRNKIGMRSYTKP            = "zrnkigmrsytkp";
    public static final String ZRNBFRKIGMRSYTKP         = "zrnbfrkigmrsytkp";
    public static final String ZRNKIGMRSYTKPHRKKKN      = "zrnkigmrsytkphrkkkn";
    public static final String ZRNYOBIV5                = "zrnyobiv5";
    public static final String ZRNPHENKANBFRSYUP        = "zrnphenkanbfrsyup";
    public static final String ZRNYOBIN3                = "zrnyobin3";
    public static final String ZRNTOUSYOKYKJIKAWASERATE = "zrntousyokykjikawaserate";
    public static final String ZRNYOBIN11               = "zrnyobin11";
    public static final String ZRNYOBIN11X2             = "zrnyobin11x2";
    public static final String ZRNYOBIN11X3             = "zrnyobin11x3";
    public static final String ZRNYOBIN11X4             = "zrnyobin11x4";
    public static final String ZRNYOBIN11X5             = "zrnyobin11x5";
    public static final String ZRNYOBIN11X6             = "zrnyobin11x6";
    public static final String ZRNYOBIN11X7             = "zrnyobin11x7";
    public static final String ZRNYOBIN11X8             = "zrnyobin11x8";
    public static final String ZRNSHZIRTSTKJYNYMD       = "zrnshzirtstkjynymd";
    public static final String ZRNKYKSYASEIYMD          = "zrnkyksyaseiymd";
    public static final String ZRNTUUKACD               = "zrntuukacd";
    public static final String ZRNSYUKEIYAKUPKYKTUUKA   = "zrnsyukeiyakupkyktuuka";
    public static final String ZRNBFRSYUPKYKTUUKA       = "zrnbfrsyupkyktuuka";
    public static final String ZRNTEKIYOUKAWASERATE7KETA = "zrntekiyoukawaserate7keta";
    public static final String ZRNYOBIV22               = "zrnyobiv22";
    public static final String ZRNYOBIV83               = "zrnyobiv83";

    private final PKZT_DrtenTsryInfoRn primaryKey;

    public GenZT_DrtenTsryInfoRn() {
        primaryKey = new PKZT_DrtenTsryInfoRn();
    }

    public GenZT_DrtenTsryInfoRn(
        String pZrndairitencd,
        String pZrnbosyuunincd,
        String pZrnsyono,
        String pZrnkikaisyoriymd,
        Long pZrnkykmfksnctrlkh,
        String pZrnsikibetujyunjyo
    ) {
        primaryKey = new PKZT_DrtenTsryInfoRn(
            pZrndairitencd,
            pZrnbosyuunincd,
            pZrnsyono,
            pZrnkikaisyoriymd,
            pZrnkykmfksnctrlkh,
            pZrnsikibetujyunjyo
        );
    }

    @Transient
    @Override
    public PKZT_DrtenTsryInfoRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DrtenTsryInfoRn> getMetaClass() {
        return QZT_DrtenTsryInfoRn.class;
    }

    @Id
    @Column(name=GenZT_DrtenTsryInfoRn.ZRNDAIRITENCD)
    public String getZrndairitencd() {
        return getPrimaryKey().getZrndairitencd();
    }

    public void setZrndairitencd(String pZrndairitencd) {
        getPrimaryKey().setZrndairitencd(pZrndairitencd);
    }

    @Id
    @Column(name=GenZT_DrtenTsryInfoRn.ZRNBOSYUUNINCD)
    public String getZrnbosyuunincd() {
        return getPrimaryKey().getZrnbosyuunincd();
    }

    public void setZrnbosyuunincd(String pZrnbosyuunincd) {
        getPrimaryKey().setZrnbosyuunincd(pZrnbosyuunincd);
    }

    @Id
    @Column(name=GenZT_DrtenTsryInfoRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnkeiyakukbn;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNKEIYAKUKBN)
    public String getZrnkeiyakukbn() {
        return zrnkeiyakukbn;
    }

    public void setZrnkeiyakukbn(String pZrnkeiyakukbn) {
        zrnkeiyakukbn = pZrnkeiyakukbn;
    }

    private String zrntokuyakuno;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNTOKUYAKUNO)
    public String getZrntokuyakuno() {
        return zrntokuyakuno;
    }

    public void setZrntokuyakuno(String pZrntokuyakuno) {
        zrntokuyakuno = pZrntokuyakuno;
    }

    private String zrnbsyym;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNBSYYM)
    public String getZrnbsyym() {
        return zrnbsyym;
    }

    public void setZrnbsyym(String pZrnbsyym) {
        zrnbsyym = pZrnbsyym;
    }

    private String zrnkykymd;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnkydatkibosyuucd;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNKYDATKIBOSYUUCD)
    public String getZrnkydatkibosyuucd() {
        return zrnkydatkibosyuucd;
    }

    public void setZrnkydatkibosyuucd(String pZrnkydatkibosyuucd) {
        zrnkydatkibosyuucd = pZrnkydatkibosyuucd;
    }

    private String zrnseiritujibumoncd;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNSEIRITUJIBUMONCD)
    public String getZrnseiritujibumoncd() {
        return zrnseiritujibumoncd;
    }

    public void setZrnseiritujibumoncd(String pZrnseiritujibumoncd) {
        zrnseiritujibumoncd = pZrnseiritujibumoncd;
    }

    private String zrnseiritujiagutiknrcd;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNSEIRITUJIAGUTIKNRCD)
    public String getZrnseiritujiagutiknrcd() {
        return zrnseiritujiagutiknrcd;
    }

    public void setZrnseiritujiagutiknrcd(String pZrnseiritujiagutiknrcd) {
        zrnseiritujiagutiknrcd = pZrnseiritujiagutiknrcd;
    }

    private String zrnyobiv1;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNYOBIV1)
    public String getZrnyobiv1() {
        return zrnyobiv1;
    }

    public void setZrnyobiv1(String pZrnyobiv1) {
        zrnyobiv1 = pZrnyobiv1;
    }

    private String zrnkydeigyouakojincd;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNKYDEIGYOUAKOJINCD)
    public String getZrnkydeigyouakojincd() {
        return zrnkydeigyouakojincd;
    }

    public void setZrnkydeigyouakojincd(String pZrnkydeigyouakojincd) {
        zrnkydeigyouakojincd = pZrnkydeigyouakojincd;
    }

    private String zrnkydeigyoubkojincd;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNKYDEIGYOUBKOJINCD)
    public String getZrnkydeigyoubkojincd() {
        return zrnkydeigyoubkojincd;
    }

    public void setZrnkydeigyoubkojincd(String pZrnkydeigyoubkojincd) {
        zrnkydeigyoubkojincd = pZrnkydeigyoubkojincd;
    }

    private String zrnskeihyj;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNSKEIHYJ)
    public String getZrnskeihyj() {
        return zrnskeihyj;
    }

    public void setZrnskeihyj(String pZrnskeihyj) {
        zrnskeihyj = pZrnskeihyj;
    }

    private String zrndenymd;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNDENYMD)
    public String getZrndenymd() {
        return zrndenymd;
    }

    public void setZrndenymd(String pZrndenymd) {
        zrndenymd = pZrndenymd;
    }

    @Id
    @Column(name=GenZT_DrtenTsryInfoRn.ZRNKIKAISYORIYMD)
    public String getZrnkikaisyoriymd() {
        return getPrimaryKey().getZrnkikaisyoriymd();
    }

    public void setZrnkikaisyoriymd(String pZrnkikaisyoriymd) {
        getPrimaryKey().setZrnkikaisyoriymd(pZrnkikaisyoriymd);
    }

    private String zrnsyoricd;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNSYORICD)
    public String getZrnsyoricd() {
        return zrnsyoricd;
    }

    public void setZrnsyoricd(String pZrnsyoricd) {
        zrnsyoricd = pZrnsyoricd;
    }

    private String zrntyouseijiyuu;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNTYOUSEIJIYUU)
    public String getZrntyouseijiyuu() {
        return zrntyouseijiyuu;
    }

    public void setZrntyouseijiyuu(String pZrntyouseijiyuu) {
        zrntyouseijiyuu = pZrntyouseijiyuu;
    }

    private String zrnnyknmonth;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNNYKNMONTH)
    public String getZrnnyknmonth() {
        return zrnnyknmonth;
    }

    public void setZrnnyknmonth(String pZrnnyknmonth) {
        zrnnyknmonth = pZrnnyknmonth;
    }

    @Id
    @Column(name=GenZT_DrtenTsryInfoRn.ZRNSIKIBETUJYUNJYO)
    public String getZrnsikibetujyunjyo() {
        return getPrimaryKey().getZrnsikibetujyunjyo();
    }

    public void setZrnsikibetujyunjyo(String pZrnsikibetujyunjyo) {
        getPrimaryKey().setZrnsikibetujyunjyo(pZrnsikibetujyunjyo);
    }

    private String zrntnsmacezugkukbn;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNTNSMACEZUGKUKBN)
    public String getZrntnsmacezugkukbn() {
        return zrntnsmacezugkukbn;
    }

    public void setZrntnsmacezugkukbn(String pZrntnsmacezugkukbn) {
        zrntnsmacezugkukbn = pZrntnsmacezugkukbn;
    }

    private String zrnacezugkkrykkaisiymd;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNACEZUGKKRYKKAISIYMD)
    public String getZrnacezugkkrykkaisiymd() {
        return zrnacezugkkrykkaisiymd;
    }

    public void setZrnacezugkkrykkaisiymd(String pZrnacezugkkrykkaisiymd) {
        zrnacezugkkrykkaisiymd = pZrnacezugkkrykkaisiymd;
    }

    private String zrnyobiv4;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNYOBIV4)
    public String getZrnyobiv4() {
        return zrnyobiv4;
    }

    public void setZrnyobiv4(String pZrnyobiv4) {
        zrnyobiv4 = pZrnyobiv4;
    }

    @Id
    @Column(name=GenZT_DrtenTsryInfoRn.ZRNKYKMFKSNCTRLKH)
    public Long getZrnkykmfksnctrlkh() {
        return getPrimaryKey().getZrnkykmfksnctrlkh();
    }

    public void setZrnkykmfksnctrlkh(Long pZrnkykmfksnctrlkh) {
        getPrimaryKey().setZrnkykmfksnctrlkh(pZrnkykmfksnctrlkh);
    }

    private String zrndairitenatkikeitaikbn;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNDAIRITENATKIKEITAIKBN)
    public String getZrndairitenatkikeitaikbn() {
        return zrndairitenatkikeitaikbn;
    }

    public void setZrndairitenatkikeitaikbn(String pZrndairitenatkikeitaikbn) {
        zrndairitenatkikeitaikbn = pZrndairitenatkikeitaikbn;
    }

    private BizNumber zrnatkiwari;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DrtenTsryInfoRn.ZRNATKIWARI)
    public BizNumber getZrnatkiwari() {
        return zrnatkiwari;
    }

    public void setZrnatkiwari(BizNumber pZrnatkiwari) {
        zrnatkiwari = pZrnatkiwari;
    }

    private Long zrndairitenatkinin;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNDAIRITENATKININ)
    public Long getZrndairitenatkinin() {
        return zrndairitenatkinin;
    }

    public void setZrndairitenatkinin(Long pZrndairitenatkinin) {
        zrndairitenatkinin = pZrndairitenatkinin;
    }

    private Long zrntsrkeisansyukykhsyos;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNTSRKEISANSYUKYKHSYOS)
    public Long getZrntsrkeisansyukykhsyos() {
        return zrntsrkeisansyukykhsyos;
    }

    public void setZrntsrkeisansyukykhsyos(Long pZrntsrkeisansyukykhsyos) {
        zrntsrkeisansyukykhsyos = pZrntsrkeisansyukykhsyos;
    }

    private Long zrnhtns;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNHTNS)
    public Long getZrnhtns() {
        return zrnhtns;
    }

    public void setZrnhtns(Long pZrnhtns) {
        zrnhtns = pZrnhtns;
    }

    private Long zrnkijymods;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNKIJYMODS)
    public Long getZrnkijymods() {
        return zrnkijymods;
    }

    public void setZrnkijymods(Long pZrnkijymods) {
        zrnkijymods = pZrnkijymods;
    }

    private Long zrnksnbubunmods;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNKSNBUBUNMODS)
    public Long getZrnksnbubunmods() {
        return zrnksnbubunmods;
    }

    public void setZrnksnbubunmods(Long pZrnksnbubunmods) {
        zrnksnbubunmods = pZrnksnbubunmods;
    }

    private Long zrnbfrkijymods;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNBFRKIJYMODS)
    public Long getZrnbfrkijymods() {
        return zrnbfrkijymods;
    }

    public void setZrnbfrkijymods(Long pZrnbfrkijymods) {
        zrnbfrkijymods = pZrnbfrkijymods;
    }

    private Long zrnbfrksnbubunmods;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNBFRKSNBUBUNMODS)
    public Long getZrnbfrksnbubunmods() {
        return zrnbfrksnbubunmods;
    }

    public void setZrnbfrksnbubunmods(Long pZrnbfrksnbubunmods) {
        zrnbfrksnbubunmods = pZrnbfrksnbubunmods;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnhknsyuruikigousedaikbn;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNHKNSYURUIKIGOUSEDAIKBN)
    public String getZrnhknsyuruikigousedaikbn() {
        return zrnhknsyuruikigousedaikbn;
    }

    public void setZrnhknsyuruikigousedaikbn(String pZrnhknsyuruikigousedaikbn) {
        zrnhknsyuruikigousedaikbn = pZrnhknsyuruikigousedaikbn;
    }

    private String zrntksyukgu;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNTKSYUKGU)
    public String getZrntksyukgu() {
        return zrntksyukgu;
    }

    public void setZrntksyukgu(String pZrntksyukgu) {
        zrntksyukgu = pZrntksyukgu;
    }

    private String zrntksyukgusedaikbn;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNTKSYUKGUSEDAIKBN)
    public String getZrntksyukgusedaikbn() {
        return zrntksyukgusedaikbn;
    }

    public void setZrntksyukgusedaikbn(String pZrntksyukgusedaikbn) {
        zrntksyukgusedaikbn = pZrntksyukgusedaikbn;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private String zrnannaifuyouriyuukbn;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNANNAIFUYOURIYUUKBN)
    public String getZrnannaifuyouriyuukbn() {
        return zrnannaifuyouriyuukbn;
    }

    public void setZrnannaifuyouriyuukbn(String pZrnannaifuyouriyuukbn) {
        zrnannaifuyouriyuukbn = pZrnannaifuyouriyuukbn;
    }

    private String zrnhhknnen2keta;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNHHKNNEN2KETA)
    public String getZrnhhknnen2keta() {
        return zrnhhknnen2keta;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhhknnen2keta(String pZrnhhknnen2keta) {
        zrnhhknnen2keta = pZrnhhknnen2keta;
    }

    private String zrnhknkkn;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNHKNKKN)
    public String getZrnhknkkn() {
        return zrnhknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhknkkn(String pZrnhknkkn) {
        zrnhknkkn = pZrnhknkkn;
    }

    private String zrnfstkeijyouhtkm;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNFSTKEIJYOUHTKM)
    public String getZrnfstkeijyouhtkm() {
        return zrnfstkeijyouhtkm;
    }

    public void setZrnfstkeijyouhtkm(String pZrnfstkeijyouhtkm) {
        zrnfstkeijyouhtkm = pZrnfstkeijyouhtkm;
    }

    private String zrntsrytsryhushrkbn;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNTSRYTSRYHUSHRKBN)
    public String getZrntsrytsryhushrkbn() {
        return zrntsrytsryhushrkbn;
    }

    public void setZrntsrytsryhushrkbn(String pZrntsrytsryhushrkbn) {
        zrntsrytsryhushrkbn = pZrntsrytsryhushrkbn;
    }

    private Long zrnbfritijibrzugkp;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNBFRITIJIBRZUGKP)
    public Long getZrnbfritijibrzugkp() {
        return zrnbfritijibrzugkp;
    }

    public void setZrnbfritijibrzugkp(Long pZrnbfritijibrzugkp) {
        zrnbfritijibrzugkp = pZrnbfritijibrzugkp;
    }

    private String zrnmaruteisyuruikigou;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNMARUTEISYURUIKIGOU)
    public String getZrnmaruteisyuruikigou() {
        return zrnmaruteisyuruikigou;
    }

    public void setZrnmaruteisyuruikigou(String pZrnmaruteisyuruikigou) {
        zrnmaruteisyuruikigou = pZrnmaruteisyuruikigou;
    }

    private String zrnmrtihukakbn;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNMRTIHUKAKBN)
    public String getZrnmrtihukakbn() {
        return zrnmrtihukakbn;
    }

    public void setZrnmrtihukakbn(String pZrnmrtihukakbn) {
        zrnmrtihukakbn = pZrnmrtihukakbn;
    }

    private String zrnsznmrtihukakbn;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNSZNMRTIHUKAKBN)
    public String getZrnsznmrtihukakbn() {
        return zrnsznmrtihukakbn;
    }

    public void setZrnsznmrtihukakbn(String pZrnsznmrtihukakbn) {
        zrnsznmrtihukakbn = pZrnsznmrtihukakbn;
    }

    private String zrnteigenmrtihukakbn;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNTEIGENMRTIHUKAKBN)
    public String getZrnteigenmrtihukakbn() {
        return zrnteigenmrtihukakbn;
    }

    public void setZrnteigenmrtihukakbn(String pZrnteigenmrtihukakbn) {
        zrnteigenmrtihukakbn = pZrnteigenmrtihukakbn;
    }

    private String zrnsyunyumrtihukakbn;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNSYUNYUMRTIHUKAKBN)
    public String getZrnsyunyumrtihukakbn() {
        return zrnsyunyumrtihukakbn;
    }

    public void setZrnsyunyumrtihukakbn(String pZrnsyunyumrtihukakbn) {
        zrnsyunyumrtihukakbn = pZrnsyunyumrtihukakbn;
    }

    private String zrnkzkmrtihukakbn;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNKZKMRTIHUKAKBN)
    public String getZrnkzkmrtihukakbn() {
        return zrnkzkmrtihukakbn;
    }

    public void setZrnkzkmrtihukakbn(String pZrnkzkmrtihukakbn) {
        zrnkzkmrtihukakbn = pZrnkzkmrtihukakbn;
    }

    private String zrntoksipmrtihukakbn;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNTOKSIPMRTIHUKAKBN)
    public String getZrntoksipmrtihukakbn() {
        return zrntoksipmrtihukakbn;
    }

    public void setZrntoksipmrtihukakbn(String pZrntoksipmrtihukakbn) {
        zrntoksipmrtihukakbn = pZrntoksipmrtihukakbn;
    }

    private String zrntoksipmrsyhukakbn;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNTOKSIPMRSYHUKAKBN)
    public String getZrntoksipmrsyhukakbn() {
        return zrntoksipmrsyhukakbn;
    }

    public void setZrntoksipmrsyhukakbn(String pZrntoksipmrsyhukakbn) {
        zrntoksipmrsyhukakbn = pZrntoksipmrsyhukakbn;
    }

    private String zrnmanskknmrtihukakbn;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNMANSKKNMRTIHUKAKBN)
    public String getZrnmanskknmrtihukakbn() {
        return zrnmanskknmrtihukakbn;
    }

    public void setZrnmanskknmrtihukakbn(String pZrnmanskknmrtihukakbn) {
        zrnmanskknmrtihukakbn = pZrnmanskknmrtihukakbn;
    }

    private String zrnkigsyunyumrtihukakbn;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNKIGSYUNYUMRTIHUKAKBN)
    public String getZrnkigsyunyumrtihukakbn() {
        return zrnkigsyunyumrtihukakbn;
    }

    public void setZrnkigsyunyumrtihukakbn(String pZrnkigsyunyumrtihukakbn) {
        zrnkigsyunyumrtihukakbn = pZrnkigsyunyumrtihukakbn;
    }

    private String zrnkigteigenmrtihukakbn;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNKIGTEIGENMRTIHUKAKBN)
    public String getZrnkigteigenmrtihukakbn() {
        return zrnkigteigenmrtihukakbn;
    }

    public void setZrnkigteigenmrtihukakbn(String pZrnkigteigenmrtihukakbn) {
        zrnkigteigenmrtihukakbn = pZrnkigteigenmrtihukakbn;
    }

    private String zrnkignktkhukakbn;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNKIGNKTKHUKAKBN)
    public String getZrnkignktkhukakbn() {
        return zrnkignktkhukakbn;
    }

    public void setZrnkignktkhukakbn(String pZrnkignktkhukakbn) {
        zrnkignktkhukakbn = pZrnkignktkhukakbn;
    }

    private String zrnkigmrtihukakbn;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNKIGMRTIHUKAKBN)
    public String getZrnkigmrtihukakbn() {
        return zrnkigmrtihukakbn;
    }

    public void setZrnkigmrtihukakbn(String pZrnkigmrtihukakbn) {
        zrnkigmrtihukakbn = pZrnkigmrtihukakbn;
    }

    private String zrnmrtisyukguyobiv1;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNMRTISYUKGUYOBIV1)
    public String getZrnmrtisyukguyobiv1() {
        return zrnmrtisyukguyobiv1;
    }

    public void setZrnmrtisyukguyobiv1(String pZrnmrtisyukguyobiv1) {
        zrnmrtisyukguyobiv1 = pZrnmrtisyukguyobiv1;
    }

    private String zrnmrtisyukguyobiv1x2;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNMRTISYUKGUYOBIV1X2)
    public String getZrnmrtisyukguyobiv1x2() {
        return zrnmrtisyukguyobiv1x2;
    }

    public void setZrnmrtisyukguyobiv1x2(String pZrnmrtisyukguyobiv1x2) {
        zrnmrtisyukguyobiv1x2 = pZrnmrtisyukguyobiv1x2;
    }

    private String zrnmrtisyukguyobiv1x3;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNMRTISYUKGUYOBIV1X3)
    public String getZrnmrtisyukguyobiv1x3() {
        return zrnmrtisyukguyobiv1x3;
    }

    public void setZrnmrtisyukguyobiv1x3(String pZrnmrtisyukguyobiv1x3) {
        zrnmrtisyukguyobiv1x3 = pZrnmrtisyukguyobiv1x3;
    }

    private String zrnmrtisyukguyobiv1x4;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNMRTISYUKGUYOBIV1X4)
    public String getZrnmrtisyukguyobiv1x4() {
        return zrnmrtisyukguyobiv1x4;
    }

    public void setZrnmrtisyukguyobiv1x4(String pZrnmrtisyukguyobiv1x4) {
        zrnmrtisyukguyobiv1x4 = pZrnmrtisyukguyobiv1x4;
    }

    private String zrnmrtisyukguyobiv1x5;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNMRTISYUKGUYOBIV1X5)
    public String getZrnmrtisyukguyobiv1x5() {
        return zrnmrtisyukguyobiv1x5;
    }

    public void setZrnmrtisyukguyobiv1x5(String pZrnmrtisyukguyobiv1x5) {
        zrnmrtisyukguyobiv1x5 = pZrnmrtisyukguyobiv1x5;
    }

    private String zrnyobiv1x2;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNYOBIV1X2)
    public String getZrnyobiv1x2() {
        return zrnyobiv1x2;
    }

    public void setZrnyobiv1x2(String pZrnyobiv1x2) {
        zrnyobiv1x2 = pZrnyobiv1x2;
    }

    private String zrnkyknm;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNKYKNM)
    public String getZrnkyknm() {
        return zrnkyknm;
    }

    public void setZrnkyknm(String pZrnkyknm) {
        zrnkyknm = pZrnkyknm;
    }

    private String zrnkjkyknm;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNKJKYKNM)
    public String getZrnkjkyknm() {
        return zrnkjkyknm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkyknm(String pZrnkjkyknm) {
        zrnkjkyknm = pZrnkjkyknm;
    }

    private String zrnhhknmei;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNHHKNMEI)
    public String getZrnhhknmei() {
        return zrnhhknmei;
    }

    public void setZrnhhknmei(String pZrnhhknmei) {
        zrnhhknmei = pZrnhhknmei;
    }

    private String zrnknjhhknmei;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNKNJHHKNMEI)
    public String getZrnknjhhknmei() {
        return zrnknjhhknmei;
    }

    @DataConvert("toMultiByte")
    public void setZrnknjhhknmei(String pZrnknjhhknmei) {
        zrnknjhhknmei = pZrnknjhhknmei;
    }

    private String zrnhrkkeirokbn;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNHRKKEIROKBN)
    public String getZrnhrkkeirokbn() {
        return zrnhrkkeirokbn;
    }

    public void setZrnhrkkeirokbn(String pZrnhrkkeirokbn) {
        zrnhrkkeirokbn = pZrnhrkkeirokbn;
    }

    private String zrnanniskcd;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNANNISKCD)
    public String getZrnanniskcd() {
        return zrnanniskcd;
    }

    public void setZrnanniskcd(String pZrnanniskcd) {
        zrnanniskcd = pZrnanniskcd;
    }

    private String zrnkarikeijyoukbn;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNKARIKEIJYOUKBN)
    public String getZrnkarikeijyoukbn() {
        return zrnkarikeijyoukbn;
    }

    public void setZrnkarikeijyoukbn(String pZrnkarikeijyoukbn) {
        zrnkarikeijyoukbn = pZrnkarikeijyoukbn;
    }

    private String zrntuikakeijyouhyj;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNTUIKAKEIJYOUHYJ)
    public String getZrntuikakeijyouhyj() {
        return zrntuikakeijyouhyj;
    }

    public void setZrntuikakeijyouhyj(String pZrntuikakeijyouhyj) {
        zrntuikakeijyouhyj = pZrntuikakeijyouhyj;
    }

    private String zrnksnhyj;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNKSNHYJ)
    public String getZrnksnhyj() {
        return zrnksnhyj;
    }

    public void setZrnksnhyj(String pZrnksnhyj) {
        zrnksnhyj = pZrnksnhyj;
    }

    private Long zrndai2ksnbubunmods;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNDAI2KSNBUBUNMODS)
    public Long getZrndai2ksnbubunmods() {
        return zrndai2ksnbubunmods;
    }

    public void setZrndai2ksnbubunmods(Long pZrndai2ksnbubunmods) {
        zrndai2ksnbubunmods = pZrndai2ksnbubunmods;
    }

    private Long zrndai2bfrksnbubunmods;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNDAI2BFRKSNBUBUNMODS)
    public Long getZrndai2bfrksnbubunmods() {
        return zrndai2bfrksnbubunmods;
    }

    public void setZrndai2bfrksnbubunmods(Long pZrndai2bfrksnbubunmods) {
        zrndai2bfrksnbubunmods = pZrndai2bfrksnbubunmods;
    }

    private String zrnphrkkikn;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNPHRKKIKN)
    public String getZrnphrkkikn() {
        return zrnphrkkikn;
    }

    public void setZrnphrkkikn(String pZrnphrkkikn) {
        zrnphrkkikn = pZrnphrkkikn;
    }

    private Long zrnjissyuup;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNJISSYUUP)
    public Long getZrnjissyuup() {
        return zrnjissyuup;
    }

    public void setZrnjissyuup(Long pZrnjissyuup) {
        zrnjissyuup = pZrnjissyuup;
    }

    private Long zrngntikktgtiryoutkp;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNGNTIKKTGTIRYOUTKP)
    public Long getZrngntikktgtiryoutkp() {
        return zrngntikktgtiryoutkp;
    }

    public void setZrngntikktgtiryoutkp(Long pZrngntikktgtiryoutkp) {
        zrngntikktgtiryoutkp = pZrngntikktgtiryoutkp;
    }

    private Long zrnbfrgntikktgtiryoutkp;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNBFRGNTIKKTGTIRYOUTKP)
    public Long getZrnbfrgntikktgtiryoutkp() {
        return zrnbfrgntikktgtiryoutkp;
    }

    public void setZrnbfrgntikktgtiryoutkp(Long pZrnbfrgntikktgtiryoutkp) {
        zrnbfrgntikktgtiryoutkp = pZrnbfrgntikktgtiryoutkp;
    }

    private String zrndairitenkbtinfo1;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNDAIRITENKBTINFO1)
    public String getZrndairitenkbtinfo1() {
        return zrndairitenkbtinfo1;
    }

    public void setZrndairitenkbtinfo1(String pZrndairitenkbtinfo1) {
        zrndairitenkbtinfo1 = pZrndairitenkbtinfo1;
    }

    private String zrndairitenkbtinfo2;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNDAIRITENKBTINFO2)
    public String getZrndairitenkbtinfo2() {
        return zrndairitenkbtinfo2;
    }

    public void setZrndairitenkbtinfo2(String pZrndairitenkbtinfo2) {
        zrndairitenkbtinfo2 = pZrndairitenkbtinfo2;
    }

    private String zrndairitenkbtinfo3;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNDAIRITENKBTINFO3)
    public String getZrndairitenkbtinfo3() {
        return zrndairitenkbtinfo3;
    }

    public void setZrndairitenkbtinfo3(String pZrndairitenkbtinfo3) {
        zrndairitenkbtinfo3 = pZrndairitenkbtinfo3;
    }

    private Long zrnsisttkp;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNSISTTKP)
    public Long getZrnsisttkp() {
        return zrnsisttkp;
    }

    public void setZrnsisttkp(Long pZrnsisttkp) {
        zrnsisttkp = pZrnsisttkp;
    }

    private Long zrnreguardtkp;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNREGUARDTKP)
    public Long getZrnreguardtkp() {
        return zrnreguardtkp;
    }

    public void setZrnreguardtkp(Long pZrnreguardtkp) {
        zrnreguardtkp = pZrnreguardtkp;
    }

    private Long zrnvguardtkp;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNVGUARDTKP)
    public Long getZrnvguardtkp() {
        return zrnvguardtkp;
    }

    public void setZrnvguardtkp(Long pZrnvguardtkp) {
        zrnvguardtkp = pZrnvguardtkp;
    }

    private Long zrnbfrsisttkp;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNBFRSISTTKP)
    public Long getZrnbfrsisttkp() {
        return zrnbfrsisttkp;
    }

    public void setZrnbfrsisttkp(Long pZrnbfrsisttkp) {
        zrnbfrsisttkp = pZrnbfrsisttkp;
    }

    private Long zrnbfrreguardtkp;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNBFRREGUARDTKP)
    public Long getZrnbfrreguardtkp() {
        return zrnbfrreguardtkp;
    }

    public void setZrnbfrreguardtkp(Long pZrnbfrreguardtkp) {
        zrnbfrreguardtkp = pZrnbfrreguardtkp;
    }

    private Long zrnbfrvguardtkp;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNBFRVGUARDTKP)
    public Long getZrnbfrvguardtkp() {
        return zrnbfrvguardtkp;
    }

    public void setZrnbfrvguardtkp(Long pZrnbfrvguardtkp) {
        zrnbfrvguardtkp = pZrnbfrvguardtkp;
    }

    private Long zrngtmtv;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNGTMTV)
    public Long getZrngtmtv() {
        return zrngtmtv;
    }

    public void setZrngtmtv(Long pZrngtmtv) {
        zrngtmtv = pZrngtmtv;
    }

    private Long zrnsyukeiyakup;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNSYUKEIYAKUP)
    public Long getZrnsyukeiyakup() {
        return zrnsyukeiyakup;
    }

    public void setZrnsyukeiyakup(Long pZrnsyukeiyakup) {
        zrnsyukeiyakup = pZrnsyukeiyakup;
    }

    private Long zrnbfrsyup;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNBFRSYUP)
    public Long getZrnbfrsyup() {
        return zrnbfrsyup;
    }

    public void setZrnbfrsyup(Long pZrnbfrsyup) {
        zrnbfrsyup = pZrnbfrsyup;
    }

    private BizNumber zrndairitentsratkiwari;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DrtenTsryInfoRn.ZRNDAIRITENTSRATKIWARI)
    public BizNumber getZrndairitentsratkiwari() {
        return zrndairitentsratkiwari;
    }

    public void setZrndairitentsratkiwari(BizNumber pZrndairitentsratkiwari) {
        zrndairitentsratkiwari = pZrndairitentsratkiwari;
    }

    private String zrnseirituymd;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNSEIRITUYMD)
    public String getZrnseirituymd() {
        return zrnseirituymd;
    }

    public void setZrnseirituymd(String pZrnseirituymd) {
        zrnseirituymd = pZrnseirituymd;
    }

    private String zrnsekininkaisiymd;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNSEKININKAISIYMD)
    public String getZrnsekininkaisiymd() {
        return zrnsekininkaisiymd;
    }

    public void setZrnsekininkaisiymd(String pZrnsekininkaisiymd) {
        zrnsekininkaisiymd = pZrnsekininkaisiymd;
    }

    private String zrncifcd;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNCIFCD)
    public String getZrncifcd() {
        return zrncifcd;
    }

    public void setZrncifcd(String pZrncifcd) {
        zrncifcd = pZrncifcd;
    }

    private String zrnbankboskykkbn;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNBANKBOSKYKKBN)
    public String getZrnbankboskykkbn() {
        return zrnbankboskykkbn;
    }

    public void setZrnbankboskykkbn(String pZrnbankboskykkbn) {
        zrnbankboskykkbn = pZrnbankboskykkbn;
    }

    private String zrnkykjiqpackhyj;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNKYKJIQPACKHYJ)
    public String getZrnkykjiqpackhyj() {
        return zrnkykjiqpackhyj;
    }

    public void setZrnkykjiqpackhyj(String pZrnkykjiqpackhyj) {
        zrnkykjiqpackhyj = pZrnkykjiqpackhyj;
    }

    private Long zrnitijibrzugkp;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNITIJIBRZUGKP)
    public Long getZrnitijibrzugkp() {
        return zrnitijibrzugkp;
    }

    public void setZrnitijibrzugkp(Long pZrnitijibrzugkp) {
        zrnitijibrzugkp = pZrnitijibrzugkp;
    }

    private Long zrntuuintokuyakup;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNTUUINTOKUYAKUP)
    public Long getZrntuuintokuyakup() {
        return zrntuuintokuyakup;
    }

    public void setZrntuuintokuyakup(Long pZrntuuintokuyakup) {
        zrntuuintokuyakup = pZrntuuintokuyakup;
    }

    private Long zrnbfrtuuintkp;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNBFRTUUINTKP)
    public Long getZrnbfrtuuintkp() {
        return zrnbfrtuuintkp;
    }

    public void setZrnbfrtuuintkp(Long pZrnbfrtuuintkp) {
        zrnbfrtuuintkp = pZrnbfrtuuintkp;
    }

    private Long zrnsougousonsyoutokuyakup;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNSOUGOUSONSYOUTOKUYAKUP)
    public Long getZrnsougousonsyoutokuyakup() {
        return zrnsougousonsyoutokuyakup;
    }

    public void setZrnsougousonsyoutokuyakup(Long pZrnsougousonsyoutokuyakup) {
        zrnsougousonsyoutokuyakup = pZrnsougousonsyoutokuyakup;
    }

    private Long zrnbfrsugusnsyutkp;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNBFRSUGUSNSYUTKP)
    public Long getZrnbfrsugusnsyutkp() {
        return zrnbfrsugusnsyutkp;
    }

    public void setZrnbfrsugusnsyutkp(Long pZrnbfrsugusnsyutkp) {
        zrnbfrsugusnsyutkp = pZrnbfrsugusnsyutkp;
    }

    private BizNumber zrnyoteiriritun5;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DrtenTsryInfoRn.ZRNYOTEIRIRITUN5)
    public BizNumber getZrnyoteiriritun5() {
        return zrnyoteiriritun5;
    }

    public void setZrnyoteiriritun5(BizNumber pZrnyoteiriritun5) {
        zrnyoteiriritun5 = pZrnyoteiriritun5;
    }

    private Long zrnyouikunenkintokuyakup;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNYOUIKUNENKINTOKUYAKUP)
    public Long getZrnyouikunenkintokuyakup() {
        return zrnyouikunenkintokuyakup;
    }

    public void setZrnyouikunenkintokuyakup(Long pZrnyouikunenkintokuyakup) {
        zrnyouikunenkintokuyakup = pZrnyouikunenkintokuyakup;
    }

    private Long zrnbfryoiknktkp;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNBFRYOIKNKTKP)
    public Long getZrnbfryoiknktkp() {
        return zrnbfryoiknktkp;
    }

    public void setZrnbfryoiknktkp(Long pZrnbfryoiknktkp) {
        zrnbfryoiknktkp = pZrnbfryoiknktkp;
    }

    private Long zrngntikktgtiryoutkntgk;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNGNTIKKTGTIRYOUTKNTGK)
    public Long getZrngntikktgtiryoutkntgk() {
        return zrngntikktgtiryoutkntgk;
    }

    public void setZrngntikktgtiryoutkntgk(Long pZrngntikktgtiryoutkntgk) {
        zrngntikktgtiryoutkntgk = pZrngntikktgtiryoutkntgk;
    }

    private String zrnkyksyaskinmeino;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNKYKSYASKINMEINO)
    public String getZrnkyksyaskinmeino() {
        return zrnkyksyaskinmeino;
    }

    public void setZrnkyksyaskinmeino(String pZrnkyksyaskinmeino) {
        zrnkyksyaskinmeino = pZrnkyksyaskinmeino;
    }

    private String zrnhhknsakuinmeino;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNHHKNSAKUINMEINO)
    public String getZrnhhknsakuinmeino() {
        return zrnhhknsakuinmeino;
    }

    public void setZrnhhknsakuinmeino(String pZrnhhknsakuinmeino) {
        zrnhhknsakuinmeino = pZrnhhknsakuinmeino;
    }

    private String zrnsinkykbosyuoyadrtencd;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNSINKYKBOSYUOYADRTENCD)
    public String getZrnsinkykbosyuoyadrtencd() {
        return zrnsinkykbosyuoyadrtencd;
    }

    public void setZrnsinkykbosyuoyadrtencd(String pZrnsinkykbosyuoyadrtencd) {
        zrnsinkykbosyuoyadrtencd = pZrnsinkykbosyuoyadrtencd;
    }

    private BizNumber zrnsyouhizeiritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DrtenTsryInfoRn.ZRNSYOUHIZEIRITU)
    public BizNumber getZrnsyouhizeiritu() {
        return zrnsyouhizeiritu;
    }

    public void setZrnsyouhizeiritu(BizNumber pZrnsyouhizeiritu) {
        zrnsyouhizeiritu = pZrnsyouhizeiritu;
    }

    private String zrnmdhnaisyoumeicd;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNMDHNAISYOUMEICD)
    public String getZrnmdhnaisyoumeicd() {
        return zrnmdhnaisyoumeicd;
    }

    public void setZrnmdhnaisyoumeicd(String pZrnmdhnaisyoumeicd) {
        zrnmdhnaisyoumeicd = pZrnmdhnaisyoumeicd;
    }

    private String zrncoolingofhyj;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNCOOLINGOFHYJ)
    public String getZrncoolingofhyj() {
        return zrncoolingofhyj;
    }

    public void setZrncoolingofhyj(String pZrncoolingofhyj) {
        zrncoolingofhyj = pZrncoolingofhyj;
    }

    private String zrnsaimnkkykhyj;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNSAIMNKKYKHYJ)
    public String getZrnsaimnkkykhyj() {
        return zrnsaimnkkykhyj;
    }

    public void setZrnsaimnkkykhyj(String pZrnsaimnkkykhyj) {
        zrnsaimnkkykhyj = pZrnsaimnkkykhyj;
    }

    private String zrnpjytoym;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNPJYTOYM)
    public String getZrnpjytoym() {
        return zrnpjytoym;
    }

    public void setZrnpjytoym(String pZrnpjytoym) {
        zrnpjytoym = pZrnpjytoym;
    }

    private String zrnsskhntihrkkisukbn;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNSSKHNTIHRKKISUKBN)
    public String getZrnsskhntihrkkisukbn() {
        return zrnsskhntihrkkisukbn;
    }

    public void setZrnsskhntihrkkisukbn(String pZrnsskhntihrkkisukbn) {
        zrnsskhntihrkkisukbn = pZrnsskhntihrkkisukbn;
    }

    private String zrnphenkanarihyj;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNPHENKANARIHYJ)
    public String getZrnphenkanarihyj() {
        return zrnphenkanarihyj;
    }

    public void setZrnphenkanarihyj(String pZrnphenkanarihyj) {
        zrnphenkanarihyj = pZrnphenkanarihyj;
    }

    private String zrnhjnkykhyj;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNHJNKYKHYJ)
    public String getZrnhjnkykhyj() {
        return zrnhjnkykhyj;
    }

    public void setZrnhjnkykhyj(String pZrnhjnkykhyj) {
        zrnhjnkykhyj = pZrnhjnkykhyj;
    }

    private String zrnbktgomeisaicalcjyun;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNBKTGOMEISAICALCJYUN)
    public String getZrnbktgomeisaicalcjyun() {
        return zrnbktgomeisaicalcjyun;
    }

    public void setZrnbktgomeisaicalcjyun(String pZrnbktgomeisaicalcjyun) {
        zrnbktgomeisaicalcjyun = pZrnbktgomeisaicalcjyun;
    }

    private String zrnikkatubaraikbn;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNIKKATUBARAIKBN)
    public String getZrnikkatubaraikbn() {
        return zrnikkatubaraikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnikkatubaraikbn(String pZrnikkatubaraikbn) {
        zrnikkatubaraikbn = pZrnikkatubaraikbn;
    }

    private String zrnikkatubaraikaisuu;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNIKKATUBARAIKAISUU)
    public String getZrnikkatubaraikaisuu() {
        return zrnikkatubaraikaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnikkatubaraikaisuu(String pZrnikkatubaraikaisuu) {
        zrnikkatubaraikaisuu = pZrnikkatubaraikaisuu;
    }

    private String zrnuktkid;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNUKTKID)
    public String getZrnuktkid() {
        return zrnuktkid;
    }

    public void setZrnuktkid(String pZrnuktkid) {
        zrnuktkid = pZrnuktkid;
    }

    private Long zrnkigmrsytkp;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNKIGMRSYTKP)
    public Long getZrnkigmrsytkp() {
        return zrnkigmrsytkp;
    }

    public void setZrnkigmrsytkp(Long pZrnkigmrsytkp) {
        zrnkigmrsytkp = pZrnkigmrsytkp;
    }

    private Long zrnbfrkigmrsytkp;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNBFRKIGMRSYTKP)
    public Long getZrnbfrkigmrsytkp() {
        return zrnbfrkigmrsytkp;
    }

    public void setZrnbfrkigmrsytkp(Long pZrnbfrkigmrsytkp) {
        zrnbfrkigmrsytkp = pZrnbfrkigmrsytkp;
    }

    private String zrnkigmrsytkphrkkkn;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNKIGMRSYTKPHRKKKN)
    public String getZrnkigmrsytkphrkkkn() {
        return zrnkigmrsytkphrkkkn;
    }

    public void setZrnkigmrsytkphrkkkn(String pZrnkigmrsytkphrkkkn) {
        zrnkigmrsytkphrkkkn = pZrnkigmrsytkphrkkkn;
    }

    private String zrnyobiv5;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNYOBIV5)
    public String getZrnyobiv5() {
        return zrnyobiv5;
    }

    public void setZrnyobiv5(String pZrnyobiv5) {
        zrnyobiv5 = pZrnyobiv5;
    }

    private Long zrnphenkanbfrsyup;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNPHENKANBFRSYUP)
    public Long getZrnphenkanbfrsyup() {
        return zrnphenkanbfrsyup;
    }

    public void setZrnphenkanbfrsyup(Long pZrnphenkanbfrsyup) {
        zrnphenkanbfrsyup = pZrnphenkanbfrsyup;
    }

    private Integer zrnyobin3;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNYOBIN3)
    public Integer getZrnyobin3() {
        return zrnyobin3;
    }

    public void setZrnyobin3(Integer pZrnyobin3) {
        zrnyobin3 = pZrnyobin3;
    }

    private BizNumber zrntousyokykjikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DrtenTsryInfoRn.ZRNTOUSYOKYKJIKAWASERATE)
    public BizNumber getZrntousyokykjikawaserate() {
        return zrntousyokykjikawaserate;
    }

    public void setZrntousyokykjikawaserate(BizNumber pZrntousyokykjikawaserate) {
        zrntousyokykjikawaserate = pZrntousyokykjikawaserate;
    }

    private Long zrnyobin11;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNYOBIN11)
    public Long getZrnyobin11() {
        return zrnyobin11;
    }

    public void setZrnyobin11(Long pZrnyobin11) {
        zrnyobin11 = pZrnyobin11;
    }

    private Long zrnyobin11x2;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNYOBIN11X2)
    public Long getZrnyobin11x2() {
        return zrnyobin11x2;
    }

    public void setZrnyobin11x2(Long pZrnyobin11x2) {
        zrnyobin11x2 = pZrnyobin11x2;
    }

    private Long zrnyobin11x3;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNYOBIN11X3)
    public Long getZrnyobin11x3() {
        return zrnyobin11x3;
    }

    public void setZrnyobin11x3(Long pZrnyobin11x3) {
        zrnyobin11x3 = pZrnyobin11x3;
    }

    private Long zrnyobin11x4;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNYOBIN11X4)
    public Long getZrnyobin11x4() {
        return zrnyobin11x4;
    }

    public void setZrnyobin11x4(Long pZrnyobin11x4) {
        zrnyobin11x4 = pZrnyobin11x4;
    }

    private Long zrnyobin11x5;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNYOBIN11X5)
    public Long getZrnyobin11x5() {
        return zrnyobin11x5;
    }

    public void setZrnyobin11x5(Long pZrnyobin11x5) {
        zrnyobin11x5 = pZrnyobin11x5;
    }

    private Long zrnyobin11x6;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNYOBIN11X6)
    public Long getZrnyobin11x6() {
        return zrnyobin11x6;
    }

    public void setZrnyobin11x6(Long pZrnyobin11x6) {
        zrnyobin11x6 = pZrnyobin11x6;
    }

    private Long zrnyobin11x7;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNYOBIN11X7)
    public Long getZrnyobin11x7() {
        return zrnyobin11x7;
    }

    public void setZrnyobin11x7(Long pZrnyobin11x7) {
        zrnyobin11x7 = pZrnyobin11x7;
    }

    private Long zrnyobin11x8;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNYOBIN11X8)
    public Long getZrnyobin11x8() {
        return zrnyobin11x8;
    }

    public void setZrnyobin11x8(Long pZrnyobin11x8) {
        zrnyobin11x8 = pZrnyobin11x8;
    }

    private String zrnshzirtstkjynymd;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNSHZIRTSTKJYNYMD)
    public String getZrnshzirtstkjynymd() {
        return zrnshzirtstkjynymd;
    }

    public void setZrnshzirtstkjynymd(String pZrnshzirtstkjynymd) {
        zrnshzirtstkjynymd = pZrnshzirtstkjynymd;
    }

    private String zrnkyksyaseiymd;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNKYKSYASEIYMD)
    public String getZrnkyksyaseiymd() {
        return zrnkyksyaseiymd;
    }

    public void setZrnkyksyaseiymd(String pZrnkyksyaseiymd) {
        zrnkyksyaseiymd = pZrnkyksyaseiymd;
    }

    private String zrntuukacd;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNTUUKACD)
    public String getZrntuukacd() {
        return zrntuukacd;
    }

    public void setZrntuukacd(String pZrntuukacd) {
        zrntuukacd = pZrntuukacd;
    }

    private Long zrnsyukeiyakupkyktuuka;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNSYUKEIYAKUPKYKTUUKA)
    public Long getZrnsyukeiyakupkyktuuka() {
        return zrnsyukeiyakupkyktuuka;
    }

    public void setZrnsyukeiyakupkyktuuka(Long pZrnsyukeiyakupkyktuuka) {
        zrnsyukeiyakupkyktuuka = pZrnsyukeiyakupkyktuuka;
    }

    private Long zrnbfrsyupkyktuuka;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNBFRSYUPKYKTUUKA)
    public Long getZrnbfrsyupkyktuuka() {
        return zrnbfrsyupkyktuuka;
    }

    public void setZrnbfrsyupkyktuuka(Long pZrnbfrsyupkyktuuka) {
        zrnbfrsyupkyktuuka = pZrnbfrsyupkyktuuka;
    }

    private BizNumber zrntekiyoukawaserate7keta;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DrtenTsryInfoRn.ZRNTEKIYOUKAWASERATE7KETA)
    public BizNumber getZrntekiyoukawaserate7keta() {
        return zrntekiyoukawaserate7keta;
    }

    public void setZrntekiyoukawaserate7keta(BizNumber pZrntekiyoukawaserate7keta) {
        zrntekiyoukawaserate7keta = pZrntekiyoukawaserate7keta;
    }

    private String zrnyobiv22;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNYOBIV22)
    public String getZrnyobiv22() {
        return zrnyobiv22;
    }

    public void setZrnyobiv22(String pZrnyobiv22) {
        zrnyobiv22 = pZrnyobiv22;
    }

    private String zrnyobiv83;

    @Column(name=GenZT_DrtenTsryInfoRn.ZRNYOBIV83)
    public String getZrnyobiv83() {
        return zrnyobiv83;
    }

    public void setZrnyobiv83(String pZrnyobiv83) {
        zrnyobiv83 = pZrnyobiv83;
    }
}