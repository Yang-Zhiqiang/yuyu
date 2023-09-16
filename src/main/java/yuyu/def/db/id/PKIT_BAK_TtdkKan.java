package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_BAK_TtdkKan;
import yuyu.def.db.mapping.GenIT_BAK_TtdkKan;
import yuyu.def.db.meta.GenQIT_BAK_TtdkKan;
import yuyu.def.db.meta.QIT_BAK_TtdkKan;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 手続完了バックアップテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_TtdkKan}</td><td colspan="3">手続完了バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoruiCd</td><td>書類コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoruiCdKbn C_SyoruiCdKbn}</td></tr>
 *  <tr><td>tyouhyouymd</td><td>帳票作成日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hassoukbn</td><td>発送区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HassouKbn C_HassouKbn}</td></tr>
 *  <tr><td>tantousitukbn</td><td>担当室区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TantousituKbn C_TantousituKbn}</td></tr>
 *  <tr><td>syoukendhumukbn</td><td>証券同封有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>shskyno</td><td>送付先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shsadr1kj</td><td>送付先住所１（漢字）（３０桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shsadr2kj</td><td>送付先住所２（漢字）（３０桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shsadr3kj</td><td>送付先住所３（漢字）（３０桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shsnmkj</td><td>送付先氏名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shsnmkj2</td><td>送付先氏名（漢字）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawasesosikinmkj</td><td>問合せ先組織名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawaseyno</td><td>問合せ先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawaseadr1kj</td><td>問合せ先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawaseadr2kj</td><td>問合せ先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawaseadr3kj</td><td>問合せ先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawasekaisyanmkj</td><td>問合せ先会社名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawasetelno</td><td>問合せ先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawaseteluktkkanou1</td><td>問合せ先電話受付可能時間１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawaseteluktkkanou2</td><td>問合せ先電話受付可能時間２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tetudukisyukbn</td><td>手続種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TetudukisyuKbn C_TetudukisyuKbn}</td></tr>
 *  <tr><td>shrumu</td><td>支払有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>syorikbn</td><td>処理区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoriKbn C_SyoriKbn}</td></tr>
 *  <tr><td>kyknmkj</td><td>契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syouhnnm</td><td>商品名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnmkj</td><td>被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yenshrtktekiumu</td><td>円支払特約適用有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>ttdknaiyouumukbn</td><td>手続内容有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>ttdknaiyou1</td><td>手続内容１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdknaiyou2</td><td>手続内容２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdknaiyou3</td><td>手続内容３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdknaiyou4</td><td>手続内容４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdknaiyou5</td><td>手続内容５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdknaiyou6</td><td>手続内容６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdknaiyou7</td><td>手続内容７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdknaiyou8</td><td>手続内容８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdknaiyou9</td><td>手続内容９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdknaiyou10</td><td>手続内容１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shrymd</td><td>支払日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>calckijyunymd</td><td>計算基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kaiykymd</td><td>解約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>shrtuukasyu</td><td>支払通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>shrtuukasyuryk</td><td>支払通貨種類略称</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shrgkkei</td><td>支払額合計</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hnkngk</td><td>返金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hnkntuukasyu</td><td>返金通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>hnknymd</td><td>返金日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>shrtienrsk</td><td>支払遅延利息</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tekiyou1</td><td>摘要１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tekiyou2</td><td>摘要２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tekiyou3</td><td>摘要３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tekiyou4</td><td>摘要４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tekiyou5</td><td>摘要５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tekiyou6</td><td>摘要６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tekiyou7</td><td>摘要７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tekiyou8</td><td>摘要８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tekiyou9</td><td>摘要９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tekiyou10</td><td>摘要１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kngkmeisai1</td><td>金額明細１</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kngkmeisai2</td><td>金額明細２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kngkmeisai3</td><td>金額明細３</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kngkmeisai4</td><td>金額明細４</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kngkmeisai5</td><td>金額明細５</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kngkmeisai6</td><td>金額明細６</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kngkmeisai7</td><td>金額明細７</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kngkmeisai8</td><td>金額明細８</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kngkmeisai9</td><td>金額明細９</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kngkmeisai10</td><td>金額明細１０</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kngkmisituukasyu1</td><td>金額明細通貨種類１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>kngkmisituukasyu2</td><td>金額明細通貨種類２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>kngkmisituukasyu3</td><td>金額明細通貨種類３</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>kngkmisituukasyu4</td><td>金額明細通貨種類４</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>kngkmisituukasyu5</td><td>金額明細通貨種類５</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>kngkmisituukasyu6</td><td>金額明細通貨種類６</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>kngkmisituukasyu7</td><td>金額明細通貨種類７</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>kngkmisituukasyu8</td><td>金額明細通貨種類８</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>kngkmisituukasyu9</td><td>金額明細通貨種類９</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>kngkmisituukasyu10</td><td>金額明細通貨種類１０</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>bikou1</td><td>備考１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bikou2</td><td>備考２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bikou3</td><td>備考３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bikou4</td><td>備考４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bikou5</td><td>備考５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bikou6</td><td>備考６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bikou7</td><td>備考７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bikou8</td><td>備考８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bikou9</td><td>備考９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bikou10</td><td>備考１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bankcd</td><td>銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitencd</td><td>支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>banknmkj</td><td>銀行名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitennmkj</td><td>支店名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yokinkbn</td><td>預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YokinKbn C_YokinKbn}</td></tr>
 *  <tr><td>kouzano</td><td>口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzsyuruikbn</td><td>口座種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KouzasyuruiKbn C_KouzasyuruiKbn}</td></tr>
 *  <tr><td>kzmeiginmkn</td><td>口座名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>soukinsakisiteikbn</td><td>送金先指定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SoukinsakisiteiKbn C_SoukinsakisiteiKbn}</td></tr>
 *  <tr><td>htsiryosyukbn</td><td>法定資料種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HtsiryosyuKbn C_HtsiryosyuKbn}</td></tr>
 *  <tr><td>synykngk</td><td>収入金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>htykeihi</td><td>必要経費</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kaiyakujiyuu</td><td>解約事由</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kaiyakujiyuu C_Kaiyakujiyuu}</td></tr>
 *  <tr><td>zeimumongonoutkbn</td><td>税務文言出力区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>zeimumongon1</td><td>税務文言１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zeimumongon2</td><td>税務文言２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zeimumongon3</td><td>税務文言３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zeimumongon4</td><td>税務文言４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zeimumongon5</td><td>税務文言５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongonhyoudai</td><td>お知らせ文言表題</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon1</td><td>お知らせ文言１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon2</td><td>お知らせ文言２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon3</td><td>お知らせ文言３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon4</td><td>お知らせ文言４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon5</td><td>お知らせ文言５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon6</td><td>お知らせ文言６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon7</td><td>お知らせ文言７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon8</td><td>お知らせ文言８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon9</td><td>お知らせ文言９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon10</td><td>お知らせ文言１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon11</td><td>お知らせ文言１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon12</td><td>お知らせ文言１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon13</td><td>お知らせ文言１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon14</td><td>お知らせ文言１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon15</td><td>お知らせ文言１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon16</td><td>お知らせ文言１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon17</td><td>お知らせ文言１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon18</td><td>お知らせ文言１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon19</td><td>お知らせ文言１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon20</td><td>お知らせ文言２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon21</td><td>お知らせ文言２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon22</td><td>お知らせ文言２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon23</td><td>お知らせ文言２３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon24</td><td>お知らせ文言２４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon25</td><td>お知らせ文言２５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon26</td><td>お知らせ文言２６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon27</td><td>お知らせ文言２７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon28</td><td>お知らせ文言２８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon29</td><td>お知らせ文言２９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon30</td><td>お知らせ文言３０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon31</td><td>お知らせ文言３１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon32</td><td>お知らせ文言３２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon33</td><td>お知らせ文言３３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon34</td><td>お知らせ文言３４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon35</td><td>お知らせ文言３５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon36</td><td>お知らせ文言３６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon37</td><td>お知らせ文言３７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon38</td><td>お知らせ文言３８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon39</td><td>お知らせ文言３９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon40</td><td>お知らせ文言４０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon41</td><td>お知らせ文言４１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon42</td><td>お知らせ文言４２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon43</td><td>お知らせ文言４３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon44</td><td>お知らせ文言４４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon45</td><td>お知らせ文言４５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon46</td><td>お知らせ文言４６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon47</td><td>お知らせ文言４７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon48</td><td>お知らせ文言４８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon49</td><td>お知らせ文言４９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osirasemongon50</td><td>お知らせ文言５０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>osiraseinjihuyouhyouji</td><td>お知らせ印字不要表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shrkykhtykeihi</td><td>支払時契約者必要経費</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kykhnkkaisuu</td><td>契約者変更回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zeimunaiyouhensyuctrlkbn</td><td>税務内容編集制御区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ZeimuNaiyouHnsyuCtrlKbn C_ZeimuNaiyouHnsyuCtrlKbn}</td></tr>
 *  <tr><td>kykniyuhnkkbn</td><td>契約内容変更区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KykniyuhenkouKbn C_KykniyuhenkouKbn}</td></tr>
 *  <tr><td>kykniyuhnkymd</td><td>契約内容変更日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kykniyuhnkinfo</td><td>契約内容変更情報</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykniyuhnkgkhugou1</td><td>契約内容変更金額明細符号１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HugouKbn C_HugouKbn}</td></tr>
 *  <tr><td>kykniyuhnkkngk1</td><td>契約内容変更金額１</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kykniyuhnkkngktuksyu1</td><td>契約内容変更金額通貨種類１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>kykniyuhnkkngkhugou2</td><td>契約内容変更金額明細符号２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HugouKbn C_HugouKbn}</td></tr>
 *  <tr><td>kykniyuhnkkngk2</td><td>契約内容変更金額２</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kykniyuhnkkngktuksyu2</td><td>契約内容変更金額通貨種類２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>gsbnrkztsaeki</td><td>源泉分離課税対象差益</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>shrkngkmeisaihugou1</td><td>支払金額明細符号１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HugouKbn C_HugouKbn}</td></tr>
 *  <tr><td>shrkngkmeisaihugou2</td><td>支払金額明細符号２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HugouKbn C_HugouKbn}</td></tr>
 *  <tr><td>shrkngkmeisaihugou3</td><td>支払金額明細符号３</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HugouKbn C_HugouKbn}</td></tr>
 *  <tr><td>shrkngkmeisaihugou4</td><td>支払金額明細符号４</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HugouKbn C_HugouKbn}</td></tr>
 *  <tr><td>shrkngkmeisaihugou5</td><td>支払金額明細符号５</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HugouKbn C_HugouKbn}</td></tr>
 *  <tr><td>shrkngkmeisaihugou6</td><td>支払金額明細符号６</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HugouKbn C_HugouKbn}</td></tr>
 *  <tr><td>shrkngkmeisaihugou7</td><td>支払金額明細符号７</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HugouKbn C_HugouKbn}</td></tr>
 *  <tr><td>shrkngkmeisaihugou8</td><td>支払金額明細符号８</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HugouKbn C_HugouKbn}</td></tr>
 *  <tr><td>shrkngkmeisaihugou9</td><td>支払金額明細符号９</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HugouKbn C_HugouKbn}</td></tr>
 *  <tr><td>shrkngkmeisaihugou10</td><td>支払金額明細符号１０</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HugouKbn C_HugouKbn}</td></tr>
 *  <tr><td>documentid</td><td>ドキュメントＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sksmongonkbn1</td><td>請求書文言区分１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SksmongonKbn C_SksmongonKbn}</td></tr>
 *  <tr><td>sksmongonkbn2</td><td>請求書文言区分２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SksmongonKbn C_SksmongonKbn}</td></tr>
 *  <tr><td>toritugisyasyozokunm</td><td>取次者所属名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toritugisyakjncd</td><td>取次者個人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toritugisyanm</td><td>取次者氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hozonKikan</td><td>保存期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>shrnaiyouhskmongon1</td><td>支払内容補足文言１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shrnaiyouhskmongon2</td><td>支払内容補足文言２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yendthnkzeimuinfohskkbn</td><td>円建変更時税務情報補足区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YendthnkzeimuinfohskKbn C_YendthnkzeimuinfohskKbn}</td></tr>
 *  <tr><td>yuuyokkntyoukaumu</td><td>猶予期間超過有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>tsintelno</td><td>通信先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dseisanshrttdknm</td><td>Ｄ精算支払手続名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzkkbn1</td><td>登録家族区分１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TrkKzkKbn C_TrkKzkKbn}</td></tr>
 *  <tr><td>trkkzknmkj1</td><td>登録家族名（漢字）１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzksei1</td><td>登録家族性別１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Seibetu C_Seibetu}</td></tr>
 *  <tr><td>trkkzkseiymd1</td><td>登録家族生年月日１</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>trkkzkyno1</td><td>登録家族郵便番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzkadr1kj1</td><td>登録家族住所１（漢字）１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzkadr2kj1</td><td>登録家族住所２（漢字）１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzkadr3kj1</td><td>登録家族住所３（漢字）１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzktelno1</td><td>登録家族電話番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzktelnomtrkhyouji1</td><td>登録家族電話番号未登録表示１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzktdk1</td><td>登録家族続柄１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tdk C_Tdk}</td></tr>
 *  <tr><td>trkkzkkbn2</td><td>登録家族区分２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TrkKzkKbn C_TrkKzkKbn}</td></tr>
 *  <tr><td>trkkzknmkj2</td><td>登録家族名（漢字）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzksei2</td><td>登録家族性別２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Seibetu C_Seibetu}</td></tr>
 *  <tr><td>trkkzkseiymd2</td><td>登録家族生年月日２</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>trkkzkyno2</td><td>登録家族郵便番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzkadr1kj2</td><td>登録家族住所１（漢字）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzkadr2kj2</td><td>登録家族住所２（漢字）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzkadr3kj2</td><td>登録家族住所３（漢字）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzktelno2</td><td>登録家族電話番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trkkzktdk2</td><td>登録家族続柄２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tdk C_Tdk}</td></tr>
 *  <tr><td>kykdairinmkj</td><td>契約者代理人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykomttutkbn</td><td>契約者用表通知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzkomttutkbn1</td><td>家族１用表通知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzkomttutkbn2</td><td>家族２用表通知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhkomttutkbn</td><td>被保険者用表通知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhkdromttutkbn</td><td>被保険者代理人用表通知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykdairiomttutkbn</td><td>契約者代理人用表通知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykurtutkbn</td><td>契約者用裏通知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzkurtutkbn1</td><td>家族１用裏通知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzkurtutkbn2</td><td>家族２用裏通知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhkdrurtutkbn</td><td>被保険者代理人用裏通知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykdairiurtutkbn</td><td>契約者代理人用裏通知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykaistmsgkbn</td><td>契約者用挨拶ＭＳＧ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzkaistmsgkbn1</td><td>家族１用挨拶ＭＳＧ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzkaistmsgkbn2</td><td>家族２用挨拶ＭＳＧ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhkaistmsgkbn</td><td>被保険者用挨拶ＭＳＧ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhkdraistmsgkbn</td><td>被保険者代理人用挨拶ＭＳＧ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykdairiaistmsgkbn</td><td>契約者代理人用挨拶ＭＳＧ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sakujyokzknmkj</td><td>削除家族名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ttdknaiyoukbn</td><td>手続内容区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzktaisyoukykkbn</td><td>家族用対象契約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhkdrtaisyoukykkbn</td><td>被保険者代理人用対象契約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykdairitaisyoukykkbn</td><td>契約者代理人用対象契約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>moshnkniymsgkbn1</td><td>申込変更内容ＭＳＧ区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykmoshnkniymsg2</td><td>契約者用申込変更内容ＭＳＧ区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzkmoshnkniymsg21</td><td>家族１用申込変更内容ＭＳＧ区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzkmoshnkniymsg22</td><td>家族２用申込変更内容ＭＳＧ区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhkdrmoshnkniymsg2</td><td>被保険者代理人用申込変更内容ＭＳＧ区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykdairimoshnkniymsg2</td><td>契約者代理人用申込変更内容ＭＳＧ区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykdrmsgkbn</td><td>契約者代理ＭＳＧ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykhhkdrmsg</td><td>契約者用被保険者代理ＭＳＧ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzkhhkdrmsg1</td><td>家族１用被保険者代理ＭＳＧ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzkhhkdrmsg2</td><td>家族２用被保険者代理ＭＳＧ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhkdrnmkj</td><td>被保険者代理人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>duhubutumsg</td><td>同封物ＭＳＧ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>duhubutumsg1</td><td>同封物ＭＳＧ区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>duhubutumsg2</td><td>同封物ＭＳＧ区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>duhubutumsg3</td><td>同封物ＭＳＧ区分３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>duhubutumsg4</td><td>同封物ＭＳＧ区分４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>duhubutumsg5</td><td>同封物ＭＳＧ区分５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>duhubutumsg6</td><td>同封物ＭＳＧ区分６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>duhubutumsg7</td><td>同封物ＭＳＧ区分７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykigaidhbtmsg1</td><td>契約者以外用同封物ＭＳＧ区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykigaidhbtmsg2</td><td>契約者以外用同封物ＭＳＧ区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykigaidhbtmsg3</td><td>契約者以外用同封物ＭＳＧ区分３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykigaidhbtmsg4</td><td>契約者以外用同封物ＭＳＧ区分４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kiyakuhunyuuhyouji</td><td>規約封入表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yakkankiyakuhunyuuhyouji</td><td>約款規約封入表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyktrktrshuunyuuhyouji</td><td>登録チラシ封入表示（契）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzktrktrshuunyuuhyouji1</td><td>登録チラシ封入表示（家族１）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzktrktrshuunyuuhyouji2</td><td>登録チラシ封入表示（家族２）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykdrhuunyuuhyouji</td><td>契約者代理封入表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhkdrhuunyuuhyouji</td><td>被保険者代理封入表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykdairinmkj2</td><td>契約者代理人名（漢字）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykdrseiymd</td><td>契約者代理人生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kykdryno</td><td>契約者代理人郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykdradr1kj</td><td>契約者代理人住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykdradr2kj</td><td>契約者代理人住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykdradr3kj</td><td>契約者代理人住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykdrtelno</td><td>契約者代理人電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhkdrnmkj2</td><td>被保険者代理人名（漢字）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhkdrseiymd</td><td>被保険者代理人生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hhkdryno</td><td>被保険者代理人郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhkdradr1kj</td><td>被保険者代理人住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhkdradr2kj</td><td>被保険者代理人住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhkdradr3kj</td><td>被保険者代理人住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhkdrtelno</td><td>被保険者代理人電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhkdrtelnomtrkhyouji</td><td>被保険者代理人電話番号未登録表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>khsyono2</td><td>（契約保全）証券番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>khsyono3</td><td>（契約保全）証券番号３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>khsyono4</td><td>（契約保全）証券番号４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>khsyono5</td><td>（契約保全）証券番号５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>khsyono6</td><td>（契約保全）証券番号６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>khsyono7</td><td>（契約保全）証券番号７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>khsyono8</td><td>（契約保全）証券番号８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>khsyono9</td><td>（契約保全）証券番号９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>khsyono10</td><td>（契約保全）証券番号１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>khmosno1</td><td>（契約保全）申込番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>khmosno2</td><td>（契約保全）申込番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>khmosno3</td><td>（契約保全）申込番号３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>khmosno4</td><td>（契約保全）申込番号４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>khmosno5</td><td>（契約保全）申込番号５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>khmosno6</td><td>（契約保全）申込番号６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>khmosno7</td><td>（契約保全）申込番号７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>khmosno8</td><td>（契約保全）申込番号８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>khmosno9</td><td>（契約保全）申込番号９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>khmosno10</td><td>（契約保全）申込番号１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hnsnhutouhuunyuuhyouji</td><td>返信用封筒封入表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_TtdkKan
 * @see     GenIT_BAK_TtdkKan
 * @see     QIT_BAK_TtdkKan
 * @see     GenQIT_BAK_TtdkKan
 */
public class PKIT_BAK_TtdkKan extends AbstractExDBPrimaryKey<IT_BAK_TtdkKan, PKIT_BAK_TtdkKan> {

    private static final long serialVersionUID = 1L;

    public PKIT_BAK_TtdkKan() {
    }

    public PKIT_BAK_TtdkKan(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        String pHenkousikibetukey
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        trkssikibetukey = pTrkssikibetukey;
        henkousikibetukey = pHenkousikibetukey;
    }

    @Transient
    @Override
    public Class<IT_BAK_TtdkKan> getEntityClass() {
        return IT_BAK_TtdkKan.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private String trkssikibetukey;

    public String getTrkssikibetukey() {
        return trkssikibetukey;
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        trkssikibetukey = pTrkssikibetukey;
    }
    private String henkousikibetukey;

    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

}