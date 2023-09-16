package yuyu.def.db.mapping;

import com.google.common.base.Optional;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.AlphaDigitOrExceptionCode;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_HugouKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KykniyuhenkouKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SksmongonKbn;
import yuyu.def.classification.C_SoukinsakisiteiKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TantousituKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YendthnkzeimuinfohskKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_ZeimuNaiyouHnsyuCtrlKbn;
import yuyu.def.db.entity.IT_BAK_TtdkKan;
import yuyu.def.db.id.PKIT_BAK_TtdkKan;
import yuyu.def.db.meta.GenQIT_BAK_TtdkKan;
import yuyu.def.db.meta.QIT_BAK_TtdkKan;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HtsiryosyuKbn;
import yuyu.def.db.type.UserType_C_HugouKbn;
import yuyu.def.db.type.UserType_C_Kaiyakujiyuu;
import yuyu.def.db.type.UserType_C_KouzasyuruiKbn;
import yuyu.def.db.type.UserType_C_KykniyuhenkouKbn;
import yuyu.def.db.type.UserType_C_Seibetu;
import yuyu.def.db.type.UserType_C_SksmongonKbn;
import yuyu.def.db.type.UserType_C_SoukinsakisiteiKbn;
import yuyu.def.db.type.UserType_C_SyoriKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.def.db.type.UserType_C_TantousituKbn;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_TetudukisyuKbn;
import yuyu.def.db.type.UserType_C_TrkKzkKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YendthnkzeimuinfohskKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.def.db.type.UserType_C_ZeimuNaiyouHnsyuCtrlKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 手続完了バックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_TtdkKan} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_TtdkKan}</td><td colspan="3">手続完了バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_TtdkKan ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_TtdkKan ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_TtdkKan ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">{@link PKIT_BAK_TtdkKan ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHassoukbn hassoukbn}</td><td>発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassouKbn}</td></tr>
 *  <tr><td>{@link #getTantousitukbn tantousitukbn}</td><td>担当室区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TantousituKbn}</td></tr>
 *  <tr><td>{@link #getSyoukendhumukbn syoukendhumukbn}</td><td>証券同封有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getShskyno shskyno}</td><td>送付先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr1kj shsadr1kj}</td><td>送付先住所１（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr2kj shsadr2kj}</td><td>送付先住所２（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsadr3kj shsadr3kj}</td><td>送付先住所３（漢字）（３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsnmkj shsnmkj}</td><td>送付先氏名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsnmkj2 shsnmkj2}</td><td>送付先氏名（漢字）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasesosikinmkj toiawasesosikinmkj}</td><td>問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseyno toiawaseyno}</td><td>問合せ先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseadr1kj toiawaseadr1kj}</td><td>問合せ先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseadr2kj toiawaseadr2kj}</td><td>問合せ先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseadr3kj toiawaseadr3kj}</td><td>問合せ先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasekaisyanmkj toiawasekaisyanmkj}</td><td>問合せ先会社名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawasetelno toiawasetelno}</td><td>問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseteluktkkanou1 toiawaseteluktkkanou1}</td><td>問合せ先電話受付可能時間１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToiawaseteluktkkanou2 toiawaseteluktkkanou2}</td><td>問合せ先電話受付可能時間２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTetudukisyukbn tetudukisyukbn}</td><td>手続種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TetudukisyuKbn}</td></tr>
 *  <tr><td>{@link #getShrumu shrumu}</td><td>支払有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSyorikbn syorikbn}</td><td>処理区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoriKbn}</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyouhnnm syouhnnm}</td><td>商品名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkj hhknnmkj}</td><td>被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYenshrtktekiumu yenshrtktekiumu}</td><td>円支払特約適用有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTtdknaiyouumukbn ttdknaiyouumukbn}</td><td>手続内容有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTtdknaiyou1 ttdknaiyou1}</td><td>手続内容１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdknaiyou2 ttdknaiyou2}</td><td>手続内容２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdknaiyou3 ttdknaiyou3}</td><td>手続内容３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdknaiyou4 ttdknaiyou4}</td><td>手続内容４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdknaiyou5 ttdknaiyou5}</td><td>手続内容５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdknaiyou6 ttdknaiyou6}</td><td>手続内容６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdknaiyou7 ttdknaiyou7}</td><td>手続内容７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdknaiyou8 ttdknaiyou8}</td><td>手続内容８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdknaiyou9 ttdknaiyou9}</td><td>手続内容９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdknaiyou10 ttdknaiyou10}</td><td>手続内容１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShrymd shrymd}</td><td>支払日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getCalckijyunymd calckijyunymd}</td><td>計算基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKaiykymd kaiykymd}</td><td>解約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrtuukasyu shrtuukasyu}</td><td>支払通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getShrtuukasyuryk shrtuukasyuryk}</td><td>支払通貨種類略称</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShrgkkei shrgkkei}</td><td>支払額合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHnkngk hnkngk}</td><td>返金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHnkntuukasyu hnkntuukasyu}</td><td>返金通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getHnknymd hnknymd}</td><td>返金日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrtienrsk shrtienrsk}</td><td>支払遅延利息</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTekiyou1 tekiyou1}</td><td>摘要１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTekiyou2 tekiyou2}</td><td>摘要２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTekiyou3 tekiyou3}</td><td>摘要３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTekiyou4 tekiyou4}</td><td>摘要４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTekiyou5 tekiyou5}</td><td>摘要５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTekiyou6 tekiyou6}</td><td>摘要６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTekiyou7 tekiyou7}</td><td>摘要７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTekiyou8 tekiyou8}</td><td>摘要８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTekiyou9 tekiyou9}</td><td>摘要９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTekiyou10 tekiyou10}</td><td>摘要１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKngkmeisai1 kngkmeisai1}</td><td>金額明細１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKngkmeisai2 kngkmeisai2}</td><td>金額明細２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKngkmeisai3 kngkmeisai3}</td><td>金額明細３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKngkmeisai4 kngkmeisai4}</td><td>金額明細４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKngkmeisai5 kngkmeisai5}</td><td>金額明細５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKngkmeisai6 kngkmeisai6}</td><td>金額明細６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKngkmeisai7 kngkmeisai7}</td><td>金額明細７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKngkmeisai8 kngkmeisai8}</td><td>金額明細８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKngkmeisai9 kngkmeisai9}</td><td>金額明細９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKngkmeisai10 kngkmeisai10}</td><td>金額明細１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKngkmisituukasyu1 kngkmisituukasyu1}</td><td>金額明細通貨種類１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getKngkmisituukasyu2 kngkmisituukasyu2}</td><td>金額明細通貨種類２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getKngkmisituukasyu3 kngkmisituukasyu3}</td><td>金額明細通貨種類３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getKngkmisituukasyu4 kngkmisituukasyu4}</td><td>金額明細通貨種類４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getKngkmisituukasyu5 kngkmisituukasyu5}</td><td>金額明細通貨種類５</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getKngkmisituukasyu6 kngkmisituukasyu6}</td><td>金額明細通貨種類６</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getKngkmisituukasyu7 kngkmisituukasyu7}</td><td>金額明細通貨種類７</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getKngkmisituukasyu8 kngkmisituukasyu8}</td><td>金額明細通貨種類８</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getKngkmisituukasyu9 kngkmisituukasyu9}</td><td>金額明細通貨種類９</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getKngkmisituukasyu10 kngkmisituukasyu10}</td><td>金額明細通貨種類１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getBikou1 bikou1}</td><td>備考１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBikou2 bikou2}</td><td>備考２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBikou3 bikou3}</td><td>備考３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBikou4 bikou4}</td><td>備考４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBikou5 bikou5}</td><td>備考５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBikou6 bikou6}</td><td>備考６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBikou7 bikou7}</td><td>備考７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBikou8 bikou8}</td><td>備考８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBikou9 bikou9}</td><td>備考９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBikou10 bikou10}</td><td>備考１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBanknmkj banknmkj}</td><td>銀行名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitennmkj sitennmkj}</td><td>支店名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzsyuruikbn kzsyuruikbn}</td><td>口座種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KouzasyuruiKbn}</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSoukinsakisiteikbn soukinsakisiteikbn}</td><td>送金先指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SoukinsakisiteiKbn}</td></tr>
 *  <tr><td>{@link #getHtsiryosyukbn htsiryosyukbn}</td><td>法定資料種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HtsiryosyuKbn}</td></tr>
 *  <tr><td>{@link #getSynykngk synykngk}</td><td>収入金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHtykeihi htykeihi}</td><td>必要経費</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaiyakujiyuu kaiyakujiyuu}</td><td>解約事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kaiyakujiyuu}</td></tr>
 *  <tr><td>{@link #getZeimumongonoutkbn zeimumongonoutkbn}</td><td>税務文言出力区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getZeimumongon1 zeimumongon1}</td><td>税務文言１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZeimumongon2 zeimumongon2}</td><td>税務文言２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZeimumongon3 zeimumongon3}</td><td>税務文言３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZeimumongon4 zeimumongon4}</td><td>税務文言４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZeimumongon5 zeimumongon5}</td><td>税務文言５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongonhyoudai osirasemongonhyoudai}</td><td>お知らせ文言表題</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon1 osirasemongon1}</td><td>お知らせ文言１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon2 osirasemongon2}</td><td>お知らせ文言２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon3 osirasemongon3}</td><td>お知らせ文言３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon4 osirasemongon4}</td><td>お知らせ文言４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon5 osirasemongon5}</td><td>お知らせ文言５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon6 osirasemongon6}</td><td>お知らせ文言６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon7 osirasemongon7}</td><td>お知らせ文言７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon8 osirasemongon8}</td><td>お知らせ文言８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon9 osirasemongon9}</td><td>お知らせ文言９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon10 osirasemongon10}</td><td>お知らせ文言１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon11 osirasemongon11}</td><td>お知らせ文言１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon12 osirasemongon12}</td><td>お知らせ文言１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon13 osirasemongon13}</td><td>お知らせ文言１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon14 osirasemongon14}</td><td>お知らせ文言１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon15 osirasemongon15}</td><td>お知らせ文言１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon16 osirasemongon16}</td><td>お知らせ文言１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon17 osirasemongon17}</td><td>お知らせ文言１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon18 osirasemongon18}</td><td>お知らせ文言１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon19 osirasemongon19}</td><td>お知らせ文言１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon20 osirasemongon20}</td><td>お知らせ文言２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon21 osirasemongon21}</td><td>お知らせ文言２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon22 osirasemongon22}</td><td>お知らせ文言２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon23 osirasemongon23}</td><td>お知らせ文言２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon24 osirasemongon24}</td><td>お知らせ文言２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon25 osirasemongon25}</td><td>お知らせ文言２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon26 osirasemongon26}</td><td>お知らせ文言２６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon27 osirasemongon27}</td><td>お知らせ文言２７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon28 osirasemongon28}</td><td>お知らせ文言２８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon29 osirasemongon29}</td><td>お知らせ文言２９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon30 osirasemongon30}</td><td>お知らせ文言３０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon31 osirasemongon31}</td><td>お知らせ文言３１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon32 osirasemongon32}</td><td>お知らせ文言３２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon33 osirasemongon33}</td><td>お知らせ文言３３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon34 osirasemongon34}</td><td>お知らせ文言３４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon35 osirasemongon35}</td><td>お知らせ文言３５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon36 osirasemongon36}</td><td>お知らせ文言３６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon37 osirasemongon37}</td><td>お知らせ文言３７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon38 osirasemongon38}</td><td>お知らせ文言３８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon39 osirasemongon39}</td><td>お知らせ文言３９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon40 osirasemongon40}</td><td>お知らせ文言４０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon41 osirasemongon41}</td><td>お知らせ文言４１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon42 osirasemongon42}</td><td>お知らせ文言４２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon43 osirasemongon43}</td><td>お知らせ文言４３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon44 osirasemongon44}</td><td>お知らせ文言４４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon45 osirasemongon45}</td><td>お知らせ文言４５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon46 osirasemongon46}</td><td>お知らせ文言４６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon47 osirasemongon47}</td><td>お知らせ文言４７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon48 osirasemongon48}</td><td>お知らせ文言４８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon49 osirasemongon49}</td><td>お知らせ文言４９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsirasemongon50 osirasemongon50}</td><td>お知らせ文言５０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getOsiraseinjihuyouhyouji osiraseinjihuyouhyouji}</td><td>お知らせ印字不要表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShrkykhtykeihi shrkykhtykeihi}</td><td>支払時契約者必要経費</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKykhnkkaisuu kykhnkkaisuu}</td><td>契約者変更回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZeimunaiyouhensyuctrlkbn zeimunaiyouhensyuctrlkbn}</td><td>税務内容編集制御区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ZeimuNaiyouHnsyuCtrlKbn}</td></tr>
 *  <tr><td>{@link #getKykniyuhnkkbn kykniyuhnkkbn}</td><td>契約内容変更区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KykniyuhenkouKbn}</td></tr>
 *  <tr><td>{@link #getKykniyuhnkymd kykniyuhnkymd}</td><td>契約内容変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykniyuhnkinfo kykniyuhnkinfo}</td><td>契約内容変更情報</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykniyuhnkgkhugou1 kykniyuhnkgkhugou1}</td><td>契約内容変更金額明細符号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HugouKbn}</td></tr>
 *  <tr><td>{@link #getKykniyuhnkkngk1 kykniyuhnkkngk1}</td><td>契約内容変更金額１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKykniyuhnkkngktuksyu1 kykniyuhnkkngktuksyu1}</td><td>契約内容変更金額通貨種類１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getKykniyuhnkkngkhugou2 kykniyuhnkkngkhugou2}</td><td>契約内容変更金額明細符号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HugouKbn}</td></tr>
 *  <tr><td>{@link #getKykniyuhnkkngk2 kykniyuhnkkngk2}</td><td>契約内容変更金額２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKykniyuhnkkngktuksyu2 kykniyuhnkkngktuksyu2}</td><td>契約内容変更金額通貨種類２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getGsbnrkztsaeki gsbnrkztsaeki}</td><td>源泉分離課税対象差益</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrkngkmeisaihugou1 shrkngkmeisaihugou1}</td><td>支払金額明細符号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HugouKbn}</td></tr>
 *  <tr><td>{@link #getShrkngkmeisaihugou2 shrkngkmeisaihugou2}</td><td>支払金額明細符号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HugouKbn}</td></tr>
 *  <tr><td>{@link #getShrkngkmeisaihugou3 shrkngkmeisaihugou3}</td><td>支払金額明細符号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HugouKbn}</td></tr>
 *  <tr><td>{@link #getShrkngkmeisaihugou4 shrkngkmeisaihugou4}</td><td>支払金額明細符号４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HugouKbn}</td></tr>
 *  <tr><td>{@link #getShrkngkmeisaihugou5 shrkngkmeisaihugou5}</td><td>支払金額明細符号５</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HugouKbn}</td></tr>
 *  <tr><td>{@link #getShrkngkmeisaihugou6 shrkngkmeisaihugou6}</td><td>支払金額明細符号６</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HugouKbn}</td></tr>
 *  <tr><td>{@link #getShrkngkmeisaihugou7 shrkngkmeisaihugou7}</td><td>支払金額明細符号７</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HugouKbn}</td></tr>
 *  <tr><td>{@link #getShrkngkmeisaihugou8 shrkngkmeisaihugou8}</td><td>支払金額明細符号８</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HugouKbn}</td></tr>
 *  <tr><td>{@link #getShrkngkmeisaihugou9 shrkngkmeisaihugou9}</td><td>支払金額明細符号９</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HugouKbn}</td></tr>
 *  <tr><td>{@link #getShrkngkmeisaihugou10 shrkngkmeisaihugou10}</td><td>支払金額明細符号１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HugouKbn}</td></tr>
 *  <tr><td>{@link #getDocumentid documentid}</td><td>ドキュメントＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSksmongonkbn1 sksmongonkbn1}</td><td>請求書文言区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SksmongonKbn}</td></tr>
 *  <tr><td>{@link #getSksmongonkbn2 sksmongonkbn2}</td><td>請求書文言区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SksmongonKbn}</td></tr>
 *  <tr><td>{@link #getToritugisyasyozokunm toritugisyasyozokunm}</td><td>取次者所属名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToritugisyakjncd toritugisyakjncd}</td><td>取次者個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getToritugisyanm toritugisyanm}</td><td>取次者氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHozonKikan hozonKikan}</td><td>保存期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getShrnaiyouhskmongon1 shrnaiyouhskmongon1}</td><td>支払内容補足文言１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShrnaiyouhskmongon2 shrnaiyouhskmongon2}</td><td>支払内容補足文言２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYendthnkzeimuinfohskkbn yendthnkzeimuinfohskkbn}</td><td>円建変更時税務情報補足区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YendthnkzeimuinfohskKbn}</td></tr>
 *  <tr><td>{@link #getYuuyokkntyoukaumu yuuyokkntyoukaumu}</td><td>猶予期間超過有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTsintelno tsintelno}</td><td>通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDseisanshrttdknm dseisanshrttdknm}</td><td>Ｄ精算支払手続名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzkkbn1 trkkzkkbn1}</td><td>登録家族区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TrkKzkKbn}</td></tr>
 *  <tr><td>{@link #getTrkkzknmkj1 trkkzknmkj1}</td><td>登録家族名（漢字）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzksei1 trkkzksei1}</td><td>登録家族性別１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Seibetu}</td></tr>
 *  <tr><td>{@link #getTrkkzkseiymd1 trkkzkseiymd1}</td><td>登録家族生年月日１</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTrkkzkyno1 trkkzkyno1}</td><td>登録家族郵便番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzkadr1kj1 trkkzkadr1kj1}</td><td>登録家族住所１（漢字）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzkadr2kj1 trkkzkadr2kj1}</td><td>登録家族住所２（漢字）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzkadr3kj1 trkkzkadr3kj1}</td><td>登録家族住所３（漢字）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzktelno1 trkkzktelno1}</td><td>登録家族電話番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzktelnomtrkhyouji1 trkkzktelnomtrkhyouji1}</td><td>登録家族電話番号未登録表示１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzktdk1 trkkzktdk1}</td><td>登録家族続柄１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tdk}</td></tr>
 *  <tr><td>{@link #getTrkkzkkbn2 trkkzkkbn2}</td><td>登録家族区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TrkKzkKbn}</td></tr>
 *  <tr><td>{@link #getTrkkzknmkj2 trkkzknmkj2}</td><td>登録家族名（漢字）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzksei2 trkkzksei2}</td><td>登録家族性別２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Seibetu}</td></tr>
 *  <tr><td>{@link #getTrkkzkseiymd2 trkkzkseiymd2}</td><td>登録家族生年月日２</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTrkkzkyno2 trkkzkyno2}</td><td>登録家族郵便番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzkadr1kj2 trkkzkadr1kj2}</td><td>登録家族住所１（漢字）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzkadr2kj2 trkkzkadr2kj2}</td><td>登録家族住所２（漢字）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzkadr3kj2 trkkzkadr3kj2}</td><td>登録家族住所３（漢字）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzktelno2 trkkzktelno2}</td><td>登録家族電話番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzktdk2 trkkzktdk2}</td><td>登録家族続柄２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tdk}</td></tr>
 *  <tr><td>{@link #getKykdairinmkj kykdairinmkj}</td><td>契約者代理人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykomttutkbn kykomttutkbn}</td><td>契約者用表通知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzkomttutkbn1 kzkomttutkbn1}</td><td>家族１用表通知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzkomttutkbn2 kzkomttutkbn2}</td><td>家族２用表通知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhkomttutkbn hhkomttutkbn}</td><td>被保険者用表通知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhkdromttutkbn hhkdromttutkbn}</td><td>被保険者代理人用表通知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykdairiomttutkbn kykdairiomttutkbn}</td><td>契約者代理人用表通知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykurtutkbn kykurtutkbn}</td><td>契約者用裏通知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzkurtutkbn1 kzkurtutkbn1}</td><td>家族１用裏通知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzkurtutkbn2 kzkurtutkbn2}</td><td>家族２用裏通知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhkdrurtutkbn hhkdrurtutkbn}</td><td>被保険者代理人用裏通知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykdairiurtutkbn kykdairiurtutkbn}</td><td>契約者代理人用裏通知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykaistmsgkbn kykaistmsgkbn}</td><td>契約者用挨拶ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzkaistmsgkbn1 kzkaistmsgkbn1}</td><td>家族１用挨拶ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzkaistmsgkbn2 kzkaistmsgkbn2}</td><td>家族２用挨拶ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhkaistmsgkbn hhkaistmsgkbn}</td><td>被保険者用挨拶ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhkdraistmsgkbn hhkdraistmsgkbn}</td><td>被保険者代理人用挨拶ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykdairiaistmsgkbn kykdairiaistmsgkbn}</td><td>契約者代理人用挨拶ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSakujyokzknmkj sakujyokzknmkj}</td><td>削除家族名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdknaiyoukbn ttdknaiyoukbn}</td><td>手続内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzktaisyoukykkbn kzktaisyoukykkbn}</td><td>家族用対象契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhkdrtaisyoukykkbn hhkdrtaisyoukykkbn}</td><td>被保険者代理人用対象契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykdairitaisyoukykkbn kykdairitaisyoukykkbn}</td><td>契約者代理人用対象契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMoshnkniymsgkbn1 moshnkniymsgkbn1}</td><td>申込変更内容ＭＳＧ区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykmoshnkniymsg2 kykmoshnkniymsg2}</td><td>契約者用申込変更内容ＭＳＧ区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzkmoshnkniymsg21 kzkmoshnkniymsg21}</td><td>家族１用申込変更内容ＭＳＧ区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzkmoshnkniymsg22 kzkmoshnkniymsg22}</td><td>家族２用申込変更内容ＭＳＧ区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhkdrmoshnkniymsg2 hhkdrmoshnkniymsg2}</td><td>被保険者代理人用申込変更内容ＭＳＧ区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykdairimoshnkniymsg2 kykdairimoshnkniymsg2}</td><td>契約者代理人用申込変更内容ＭＳＧ区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykdrmsgkbn kykdrmsgkbn}</td><td>契約者代理ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykhhkdrmsg kykhhkdrmsg}</td><td>契約者用被保険者代理ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzkhhkdrmsg1 kzkhhkdrmsg1}</td><td>家族１用被保険者代理ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzkhhkdrmsg2 kzkhhkdrmsg2}</td><td>家族２用被保険者代理ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhkdrnmkj hhkdrnmkj}</td><td>被保険者代理人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDuhubutumsg duhubutumsg}</td><td>同封物ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDuhubutumsg1 duhubutumsg1}</td><td>同封物ＭＳＧ区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDuhubutumsg2 duhubutumsg2}</td><td>同封物ＭＳＧ区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDuhubutumsg3 duhubutumsg3}</td><td>同封物ＭＳＧ区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDuhubutumsg4 duhubutumsg4}</td><td>同封物ＭＳＧ区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDuhubutumsg5 duhubutumsg5}</td><td>同封物ＭＳＧ区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDuhubutumsg6 duhubutumsg6}</td><td>同封物ＭＳＧ区分６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDuhubutumsg7 duhubutumsg7}</td><td>同封物ＭＳＧ区分７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykigaidhbtmsg1 kykigaidhbtmsg1}</td><td>契約者以外用同封物ＭＳＧ区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykigaidhbtmsg2 kykigaidhbtmsg2}</td><td>契約者以外用同封物ＭＳＧ区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykigaidhbtmsg3 kykigaidhbtmsg3}</td><td>契約者以外用同封物ＭＳＧ区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykigaidhbtmsg4 kykigaidhbtmsg4}</td><td>契約者以外用同封物ＭＳＧ区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKiyakuhunyuuhyouji kiyakuhunyuuhyouji}</td><td>規約封入表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYakkankiyakuhunyuuhyouji yakkankiyakuhunyuuhyouji}</td><td>約款規約封入表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyktrktrshuunyuuhyouji kyktrktrshuunyuuhyouji}</td><td>登録チラシ封入表示（契）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzktrktrshuunyuuhyouji1 kzktrktrshuunyuuhyouji1}</td><td>登録チラシ封入表示（家族１）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzktrktrshuunyuuhyouji2 kzktrktrshuunyuuhyouji2}</td><td>登録チラシ封入表示（家族２）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykdrhuunyuuhyouji kykdrhuunyuuhyouji}</td><td>契約者代理封入表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhkdrhuunyuuhyouji hhkdrhuunyuuhyouji}</td><td>被保険者代理封入表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykdairinmkj2 kykdairinmkj2}</td><td>契約者代理人名（漢字）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykdrseiymd kykdrseiymd}</td><td>契約者代理人生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykdryno kykdryno}</td><td>契約者代理人郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykdradr1kj kykdradr1kj}</td><td>契約者代理人住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykdradr2kj kykdradr2kj}</td><td>契約者代理人住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykdradr3kj kykdradr3kj}</td><td>契約者代理人住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykdrtelno kykdrtelno}</td><td>契約者代理人電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhkdrnmkj2 hhkdrnmkj2}</td><td>被保険者代理人名（漢字）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhkdrseiymd hhkdrseiymd}</td><td>被保険者代理人生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHhkdryno hhkdryno}</td><td>被保険者代理人郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhkdradr1kj hhkdradr1kj}</td><td>被保険者代理人住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhkdradr2kj hhkdradr2kj}</td><td>被保険者代理人住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhkdradr3kj hhkdradr3kj}</td><td>被保険者代理人住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhkdrtelno hhkdrtelno}</td><td>被保険者代理人電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhkdrtelnomtrkhyouji hhkdrtelnomtrkhyouji}</td><td>被保険者代理人電話番号未登録表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKhsyono2 khsyono2}</td><td>（契約保全）証券番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKhsyono3 khsyono3}</td><td>（契約保全）証券番号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKhsyono4 khsyono4}</td><td>（契約保全）証券番号４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKhsyono5 khsyono5}</td><td>（契約保全）証券番号５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKhsyono6 khsyono6}</td><td>（契約保全）証券番号６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKhsyono7 khsyono7}</td><td>（契約保全）証券番号７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKhsyono8 khsyono8}</td><td>（契約保全）証券番号８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKhsyono9 khsyono9}</td><td>（契約保全）証券番号９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKhsyono10 khsyono10}</td><td>（契約保全）証券番号１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKhmosno1 khmosno1}</td><td>（契約保全）申込番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKhmosno2 khmosno2}</td><td>（契約保全）申込番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKhmosno3 khmosno3}</td><td>（契約保全）申込番号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKhmosno4 khmosno4}</td><td>（契約保全）申込番号４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKhmosno5 khmosno5}</td><td>（契約保全）申込番号５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKhmosno6 khmosno6}</td><td>（契約保全）申込番号６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKhmosno7 khmosno7}</td><td>（契約保全）申込番号７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKhmosno8 khmosno8}</td><td>（契約保全）申込番号８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKhmosno9 khmosno9}</td><td>（契約保全）申込番号９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKhmosno10 khmosno10}</td><td>（契約保全）申込番号１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHnsnhutouhuunyuuhyouji hnsnhutouhuunyuuhyouji}</td><td>返信用封筒封入表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_TtdkKan
 * @see     PKIT_BAK_TtdkKan
 * @see     QIT_BAK_TtdkKan
 * @see     GenQIT_BAK_TtdkKan
 */
@MappedSuperclass
@Table(name=GenIT_BAK_TtdkKan.TABLE_NAME)
@IdClass(value=PKIT_BAK_TtdkKan.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HassouKbn", typeClass=UserType_C_HassouKbn.class),
    @TypeDef(name="UserType_C_HtsiryosyuKbn", typeClass=UserType_C_HtsiryosyuKbn.class),
    @TypeDef(name="UserType_C_HugouKbn", typeClass=UserType_C_HugouKbn.class),
    @TypeDef(name="UserType_C_Kaiyakujiyuu", typeClass=UserType_C_Kaiyakujiyuu.class),
    @TypeDef(name="UserType_C_KouzasyuruiKbn", typeClass=UserType_C_KouzasyuruiKbn.class),
    @TypeDef(name="UserType_C_KykniyuhenkouKbn", typeClass=UserType_C_KykniyuhenkouKbn.class),
    @TypeDef(name="UserType_C_Seibetu", typeClass=UserType_C_Seibetu.class),
    @TypeDef(name="UserType_C_SksmongonKbn", typeClass=UserType_C_SksmongonKbn.class),
    @TypeDef(name="UserType_C_SoukinsakisiteiKbn", typeClass=UserType_C_SoukinsakisiteiKbn.class),
    @TypeDef(name="UserType_C_SyoriKbn", typeClass=UserType_C_SyoriKbn.class),
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class),
    @TypeDef(name="UserType_C_TantousituKbn", typeClass=UserType_C_TantousituKbn.class),
    @TypeDef(name="UserType_C_Tdk", typeClass=UserType_C_Tdk.class),
    @TypeDef(name="UserType_C_TetudukisyuKbn", typeClass=UserType_C_TetudukisyuKbn.class),
    @TypeDef(name="UserType_C_TrkKzkKbn", typeClass=UserType_C_TrkKzkKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YendthnkzeimuinfohskKbn", typeClass=UserType_C_YendthnkzeimuinfohskKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class),
    @TypeDef(name="UserType_C_ZeimuNaiyouHnsyuCtrlKbn", typeClass=UserType_C_ZeimuNaiyouHnsyuCtrlKbn.class)
})
public abstract class GenIT_BAK_TtdkKan extends AbstractExDBEntity<IT_BAK_TtdkKan, PKIT_BAK_TtdkKan> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_TtdkKan";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String SYORUICD                 = "syoruiCd";
    public static final String TYOUHYOUYMD              = "tyouhyouymd";
    public static final String HASSOUKBN                = "hassoukbn";
    public static final String TANTOUSITUKBN            = "tantousitukbn";
    public static final String SYOUKENDHUMUKBN          = "syoukendhumukbn";
    public static final String SHSKYNO                  = "shskyno";
    public static final String SHSADR1KJ                = "shsadr1kj";
    public static final String SHSADR2KJ                = "shsadr2kj";
    public static final String SHSADR3KJ                = "shsadr3kj";
    public static final String SHSNMKJ                  = "shsnmkj";
    public static final String SHSNMKJ2                 = "shsnmkj2";
    public static final String TOIAWASESOSIKINMKJ       = "toiawasesosikinmkj";
    public static final String TOIAWASEYNO              = "toiawaseyno";
    public static final String TOIAWASEADR1KJ           = "toiawaseadr1kj";
    public static final String TOIAWASEADR2KJ           = "toiawaseadr2kj";
    public static final String TOIAWASEADR3KJ           = "toiawaseadr3kj";
    public static final String TOIAWASEKAISYANMKJ       = "toiawasekaisyanmkj";
    public static final String TOIAWASETELNO            = "toiawasetelno";
    public static final String TOIAWASETELUKTKKANOU1    = "toiawaseteluktkkanou1";
    public static final String TOIAWASETELUKTKKANOU2    = "toiawaseteluktkkanou2";
    public static final String TETUDUKISYUKBN           = "tetudukisyukbn";
    public static final String SHRUMU                   = "shrumu";
    public static final String SYORIKBN                 = "syorikbn";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String KYKYMD                   = "kykymd";
    public static final String SYOUHNNM                 = "syouhnnm";
    public static final String HHKNNMKJ                 = "hhknnmkj";
    public static final String YENSHRTKTEKIUMU          = "yenshrtktekiumu";
    public static final String TTDKNAIYOUUMUKBN         = "ttdknaiyouumukbn";
    public static final String TTDKNAIYOU1              = "ttdknaiyou1";
    public static final String TTDKNAIYOU2              = "ttdknaiyou2";
    public static final String TTDKNAIYOU3              = "ttdknaiyou3";
    public static final String TTDKNAIYOU4              = "ttdknaiyou4";
    public static final String TTDKNAIYOU5              = "ttdknaiyou5";
    public static final String TTDKNAIYOU6              = "ttdknaiyou6";
    public static final String TTDKNAIYOU7              = "ttdknaiyou7";
    public static final String TTDKNAIYOU8              = "ttdknaiyou8";
    public static final String TTDKNAIYOU9              = "ttdknaiyou9";
    public static final String TTDKNAIYOU10             = "ttdknaiyou10";
    public static final String SHRYMD                   = "shrymd";
    public static final String CALCKIJYUNYMD            = "calckijyunymd";
    public static final String KAIYKYMD                 = "kaiykymd";
    public static final String SHRTUUKASYU              = "shrtuukasyu";
    public static final String SHRTUUKASYURYK           = "shrtuukasyuryk";
    public static final String SHRGKKEI                 = "shrgkkei";
    public static final String HNKNGK                   = "hnkngk";
    public static final String HNKNTUUKASYU             = "hnkntuukasyu";
    public static final String HNKNYMD                  = "hnknymd";
    public static final String SHRTIENRSK               = "shrtienrsk";
    public static final String TEKIYOU1                 = "tekiyou1";
    public static final String TEKIYOU2                 = "tekiyou2";
    public static final String TEKIYOU3                 = "tekiyou3";
    public static final String TEKIYOU4                 = "tekiyou4";
    public static final String TEKIYOU5                 = "tekiyou5";
    public static final String TEKIYOU6                 = "tekiyou6";
    public static final String TEKIYOU7                 = "tekiyou7";
    public static final String TEKIYOU8                 = "tekiyou8";
    public static final String TEKIYOU9                 = "tekiyou9";
    public static final String TEKIYOU10                = "tekiyou10";
    public static final String KNGKMEISAI1              = "kngkmeisai1";
    public static final String KNGKMEISAI2              = "kngkmeisai2";
    public static final String KNGKMEISAI3              = "kngkmeisai3";
    public static final String KNGKMEISAI4              = "kngkmeisai4";
    public static final String KNGKMEISAI5              = "kngkmeisai5";
    public static final String KNGKMEISAI6              = "kngkmeisai6";
    public static final String KNGKMEISAI7              = "kngkmeisai7";
    public static final String KNGKMEISAI8              = "kngkmeisai8";
    public static final String KNGKMEISAI9              = "kngkmeisai9";
    public static final String KNGKMEISAI10             = "kngkmeisai10";
    public static final String KNGKMISITUUKASYU1        = "kngkmisituukasyu1";
    public static final String KNGKMISITUUKASYU2        = "kngkmisituukasyu2";
    public static final String KNGKMISITUUKASYU3        = "kngkmisituukasyu3";
    public static final String KNGKMISITUUKASYU4        = "kngkmisituukasyu4";
    public static final String KNGKMISITUUKASYU5        = "kngkmisituukasyu5";
    public static final String KNGKMISITUUKASYU6        = "kngkmisituukasyu6";
    public static final String KNGKMISITUUKASYU7        = "kngkmisituukasyu7";
    public static final String KNGKMISITUUKASYU8        = "kngkmisituukasyu8";
    public static final String KNGKMISITUUKASYU9        = "kngkmisituukasyu9";
    public static final String KNGKMISITUUKASYU10       = "kngkmisituukasyu10";
    public static final String BIKOU1                   = "bikou1";
    public static final String BIKOU2                   = "bikou2";
    public static final String BIKOU3                   = "bikou3";
    public static final String BIKOU4                   = "bikou4";
    public static final String BIKOU5                   = "bikou5";
    public static final String BIKOU6                   = "bikou6";
    public static final String BIKOU7                   = "bikou7";
    public static final String BIKOU8                   = "bikou8";
    public static final String BIKOU9                   = "bikou9";
    public static final String BIKOU10                  = "bikou10";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String BANKNMKJ                 = "banknmkj";
    public static final String SITENNMKJ                = "sitennmkj";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String KZSYURUIKBN              = "kzsyuruikbn";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String SOUKINSAKISITEIKBN       = "soukinsakisiteikbn";
    public static final String HTSIRYOSYUKBN            = "htsiryosyukbn";
    public static final String SYNYKNGK                 = "synykngk";
    public static final String HTYKEIHI                 = "htykeihi";
    public static final String KAIYAKUJIYUU             = "kaiyakujiyuu";
    public static final String ZEIMUMONGONOUTKBN        = "zeimumongonoutkbn";
    public static final String ZEIMUMONGON1             = "zeimumongon1";
    public static final String ZEIMUMONGON2             = "zeimumongon2";
    public static final String ZEIMUMONGON3             = "zeimumongon3";
    public static final String ZEIMUMONGON4             = "zeimumongon4";
    public static final String ZEIMUMONGON5             = "zeimumongon5";
    public static final String OSIRASEMONGONHYOUDAI     = "osirasemongonhyoudai";
    public static final String OSIRASEMONGON1           = "osirasemongon1";
    public static final String OSIRASEMONGON2           = "osirasemongon2";
    public static final String OSIRASEMONGON3           = "osirasemongon3";
    public static final String OSIRASEMONGON4           = "osirasemongon4";
    public static final String OSIRASEMONGON5           = "osirasemongon5";
    public static final String OSIRASEMONGON6           = "osirasemongon6";
    public static final String OSIRASEMONGON7           = "osirasemongon7";
    public static final String OSIRASEMONGON8           = "osirasemongon8";
    public static final String OSIRASEMONGON9           = "osirasemongon9";
    public static final String OSIRASEMONGON10          = "osirasemongon10";
    public static final String OSIRASEMONGON11          = "osirasemongon11";
    public static final String OSIRASEMONGON12          = "osirasemongon12";
    public static final String OSIRASEMONGON13          = "osirasemongon13";
    public static final String OSIRASEMONGON14          = "osirasemongon14";
    public static final String OSIRASEMONGON15          = "osirasemongon15";
    public static final String OSIRASEMONGON16          = "osirasemongon16";
    public static final String OSIRASEMONGON17          = "osirasemongon17";
    public static final String OSIRASEMONGON18          = "osirasemongon18";
    public static final String OSIRASEMONGON19          = "osirasemongon19";
    public static final String OSIRASEMONGON20          = "osirasemongon20";
    public static final String OSIRASEMONGON21          = "osirasemongon21";
    public static final String OSIRASEMONGON22          = "osirasemongon22";
    public static final String OSIRASEMONGON23          = "osirasemongon23";
    public static final String OSIRASEMONGON24          = "osirasemongon24";
    public static final String OSIRASEMONGON25          = "osirasemongon25";
    public static final String OSIRASEMONGON26          = "osirasemongon26";
    public static final String OSIRASEMONGON27          = "osirasemongon27";
    public static final String OSIRASEMONGON28          = "osirasemongon28";
    public static final String OSIRASEMONGON29          = "osirasemongon29";
    public static final String OSIRASEMONGON30          = "osirasemongon30";
    public static final String OSIRASEMONGON31          = "osirasemongon31";
    public static final String OSIRASEMONGON32          = "osirasemongon32";
    public static final String OSIRASEMONGON33          = "osirasemongon33";
    public static final String OSIRASEMONGON34          = "osirasemongon34";
    public static final String OSIRASEMONGON35          = "osirasemongon35";
    public static final String OSIRASEMONGON36          = "osirasemongon36";
    public static final String OSIRASEMONGON37          = "osirasemongon37";
    public static final String OSIRASEMONGON38          = "osirasemongon38";
    public static final String OSIRASEMONGON39          = "osirasemongon39";
    public static final String OSIRASEMONGON40          = "osirasemongon40";
    public static final String OSIRASEMONGON41          = "osirasemongon41";
    public static final String OSIRASEMONGON42          = "osirasemongon42";
    public static final String OSIRASEMONGON43          = "osirasemongon43";
    public static final String OSIRASEMONGON44          = "osirasemongon44";
    public static final String OSIRASEMONGON45          = "osirasemongon45";
    public static final String OSIRASEMONGON46          = "osirasemongon46";
    public static final String OSIRASEMONGON47          = "osirasemongon47";
    public static final String OSIRASEMONGON48          = "osirasemongon48";
    public static final String OSIRASEMONGON49          = "osirasemongon49";
    public static final String OSIRASEMONGON50          = "osirasemongon50";
    public static final String OSIRASEINJIHUYOUHYOUJI   = "osiraseinjihuyouhyouji";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String SHRKYKHTYKEIHI           = "shrkykhtykeihi";
    public static final String KYKHNKKAISUU             = "kykhnkkaisuu";
    public static final String ZEIMUNAIYOUHENSYUCTRLKBN = "zeimunaiyouhensyuctrlkbn";
    public static final String KYKNIYUHNKKBN            = "kykniyuhnkkbn";
    public static final String KYKNIYUHNKYMD            = "kykniyuhnkymd";
    public static final String KYKNIYUHNKINFO           = "kykniyuhnkinfo";
    public static final String KYKNIYUHNKGKHUGOU1       = "kykniyuhnkgkhugou1";
    public static final String KYKNIYUHNKKNGK1          = "kykniyuhnkkngk1";
    public static final String KYKNIYUHNKKNGKTUKSYU1    = "kykniyuhnkkngktuksyu1";
    public static final String KYKNIYUHNKKNGKHUGOU2     = "kykniyuhnkkngkhugou2";
    public static final String KYKNIYUHNKKNGK2          = "kykniyuhnkkngk2";
    public static final String KYKNIYUHNKKNGKTUKSYU2    = "kykniyuhnkkngktuksyu2";
    public static final String GSBNRKZTSAEKI            = "gsbnrkztsaeki";
    public static final String SHRKNGKMEISAIHUGOU1      = "shrkngkmeisaihugou1";
    public static final String SHRKNGKMEISAIHUGOU2      = "shrkngkmeisaihugou2";
    public static final String SHRKNGKMEISAIHUGOU3      = "shrkngkmeisaihugou3";
    public static final String SHRKNGKMEISAIHUGOU4      = "shrkngkmeisaihugou4";
    public static final String SHRKNGKMEISAIHUGOU5      = "shrkngkmeisaihugou5";
    public static final String SHRKNGKMEISAIHUGOU6      = "shrkngkmeisaihugou6";
    public static final String SHRKNGKMEISAIHUGOU7      = "shrkngkmeisaihugou7";
    public static final String SHRKNGKMEISAIHUGOU8      = "shrkngkmeisaihugou8";
    public static final String SHRKNGKMEISAIHUGOU9      = "shrkngkmeisaihugou9";
    public static final String SHRKNGKMEISAIHUGOU10     = "shrkngkmeisaihugou10";
    public static final String DOCUMENTID               = "documentid";
    public static final String SKSMONGONKBN1            = "sksmongonkbn1";
    public static final String SKSMONGONKBN2            = "sksmongonkbn2";
    public static final String TORITUGISYASYOZOKUNM     = "toritugisyasyozokunm";
    public static final String TORITUGISYAKJNCD         = "toritugisyakjncd";
    public static final String TORITUGISYANM            = "toritugisyanm";
    public static final String HOZONKIKAN               = "hozonKikan";
    public static final String SHRNAIYOUHSKMONGON1      = "shrnaiyouhskmongon1";
    public static final String SHRNAIYOUHSKMONGON2      = "shrnaiyouhskmongon2";
    public static final String YENDTHNKZEIMUINFOHSKKBN  = "yendthnkzeimuinfohskkbn";
    public static final String YUUYOKKNTYOUKAUMU        = "yuuyokkntyoukaumu";
    public static final String TSINTELNO                = "tsintelno";
    public static final String DSEISANSHRTTDKNM         = "dseisanshrttdknm";
    public static final String TRKKZKKBN1               = "trkkzkkbn1";
    public static final String TRKKZKNMKJ1              = "trkkzknmkj1";
    public static final String TRKKZKSEI1               = "trkkzksei1";
    public static final String TRKKZKSEIYMD1            = "trkkzkseiymd1";
    public static final String TRKKZKYNO1               = "trkkzkyno1";
    public static final String TRKKZKADR1KJ1            = "trkkzkadr1kj1";
    public static final String TRKKZKADR2KJ1            = "trkkzkadr2kj1";
    public static final String TRKKZKADR3KJ1            = "trkkzkadr3kj1";
    public static final String TRKKZKTELNO1             = "trkkzktelno1";
    public static final String TRKKZKTELNOMTRKHYOUJI1   = "trkkzktelnomtrkhyouji1";
    public static final String TRKKZKTDK1               = "trkkzktdk1";
    public static final String TRKKZKKBN2               = "trkkzkkbn2";
    public static final String TRKKZKNMKJ2              = "trkkzknmkj2";
    public static final String TRKKZKSEI2               = "trkkzksei2";
    public static final String TRKKZKSEIYMD2            = "trkkzkseiymd2";
    public static final String TRKKZKYNO2               = "trkkzkyno2";
    public static final String TRKKZKADR1KJ2            = "trkkzkadr1kj2";
    public static final String TRKKZKADR2KJ2            = "trkkzkadr2kj2";
    public static final String TRKKZKADR3KJ2            = "trkkzkadr3kj2";
    public static final String TRKKZKTELNO2             = "trkkzktelno2";
    public static final String TRKKZKTDK2               = "trkkzktdk2";
    public static final String KYKDAIRINMKJ             = "kykdairinmkj";
    public static final String KYKOMTTUTKBN             = "kykomttutkbn";
    public static final String KZKOMTTUTKBN1            = "kzkomttutkbn1";
    public static final String KZKOMTTUTKBN2            = "kzkomttutkbn2";
    public static final String HHKOMTTUTKBN             = "hhkomttutkbn";
    public static final String HHKDROMTTUTKBN           = "hhkdromttutkbn";
    public static final String KYKDAIRIOMTTUTKBN        = "kykdairiomttutkbn";
    public static final String KYKURTUTKBN              = "kykurtutkbn";
    public static final String KZKURTUTKBN1             = "kzkurtutkbn1";
    public static final String KZKURTUTKBN2             = "kzkurtutkbn2";
    public static final String HHKDRURTUTKBN            = "hhkdrurtutkbn";
    public static final String KYKDAIRIURTUTKBN         = "kykdairiurtutkbn";
    public static final String KYKAISTMSGKBN            = "kykaistmsgkbn";
    public static final String KZKAISTMSGKBN1           = "kzkaistmsgkbn1";
    public static final String KZKAISTMSGKBN2           = "kzkaistmsgkbn2";
    public static final String HHKAISTMSGKBN            = "hhkaistmsgkbn";
    public static final String HHKDRAISTMSGKBN          = "hhkdraistmsgkbn";
    public static final String KYKDAIRIAISTMSGKBN       = "kykdairiaistmsgkbn";
    public static final String SAKUJYOKZKNMKJ           = "sakujyokzknmkj";
    public static final String TTDKNAIYOUKBN            = "ttdknaiyoukbn";
    public static final String KZKTAISYOUKYKKBN         = "kzktaisyoukykkbn";
    public static final String HHKDRTAISYOUKYKKBN       = "hhkdrtaisyoukykkbn";
    public static final String KYKDAIRITAISYOUKYKKBN    = "kykdairitaisyoukykkbn";
    public static final String MOSHNKNIYMSGKBN1         = "moshnkniymsgkbn1";
    public static final String KYKMOSHNKNIYMSG2         = "kykmoshnkniymsg2";
    public static final String KZKMOSHNKNIYMSG21        = "kzkmoshnkniymsg21";
    public static final String KZKMOSHNKNIYMSG22        = "kzkmoshnkniymsg22";
    public static final String HHKDRMOSHNKNIYMSG2       = "hhkdrmoshnkniymsg2";
    public static final String KYKDAIRIMOSHNKNIYMSG2    = "kykdairimoshnkniymsg2";
    public static final String KYKDRMSGKBN              = "kykdrmsgkbn";
    public static final String KYKHHKDRMSG              = "kykhhkdrmsg";
    public static final String KZKHHKDRMSG1             = "kzkhhkdrmsg1";
    public static final String KZKHHKDRMSG2             = "kzkhhkdrmsg2";
    public static final String HHKDRNMKJ                = "hhkdrnmkj";
    public static final String DUHUBUTUMSG              = "duhubutumsg";
    public static final String DUHUBUTUMSG1             = "duhubutumsg1";
    public static final String DUHUBUTUMSG2             = "duhubutumsg2";
    public static final String DUHUBUTUMSG3             = "duhubutumsg3";
    public static final String DUHUBUTUMSG4             = "duhubutumsg4";
    public static final String DUHUBUTUMSG5             = "duhubutumsg5";
    public static final String DUHUBUTUMSG6             = "duhubutumsg6";
    public static final String DUHUBUTUMSG7             = "duhubutumsg7";
    public static final String KYKIGAIDHBTMSG1          = "kykigaidhbtmsg1";
    public static final String KYKIGAIDHBTMSG2          = "kykigaidhbtmsg2";
    public static final String KYKIGAIDHBTMSG3          = "kykigaidhbtmsg3";
    public static final String KYKIGAIDHBTMSG4          = "kykigaidhbtmsg4";
    public static final String KIYAKUHUNYUUHYOUJI       = "kiyakuhunyuuhyouji";
    public static final String YAKKANKIYAKUHUNYUUHYOUJI = "yakkankiyakuhunyuuhyouji";
    public static final String KYKTRKTRSHUUNYUUHYOUJI   = "kyktrktrshuunyuuhyouji";
    public static final String KZKTRKTRSHUUNYUUHYOUJI1  = "kzktrktrshuunyuuhyouji1";
    public static final String KZKTRKTRSHUUNYUUHYOUJI2  = "kzktrktrshuunyuuhyouji2";
    public static final String KYKDRHUUNYUUHYOUJI       = "kykdrhuunyuuhyouji";
    public static final String HHKDRHUUNYUUHYOUJI       = "hhkdrhuunyuuhyouji";
    public static final String KYKDAIRINMKJ2            = "kykdairinmkj2";
    public static final String KYKDRSEIYMD              = "kykdrseiymd";
    public static final String KYKDRYNO                 = "kykdryno";
    public static final String KYKDRADR1KJ              = "kykdradr1kj";
    public static final String KYKDRADR2KJ              = "kykdradr2kj";
    public static final String KYKDRADR3KJ              = "kykdradr3kj";
    public static final String KYKDRTELNO               = "kykdrtelno";
    public static final String HHKDRNMKJ2               = "hhkdrnmkj2";
    public static final String HHKDRSEIYMD              = "hhkdrseiymd";
    public static final String HHKDRYNO                 = "hhkdryno";
    public static final String HHKDRADR1KJ              = "hhkdradr1kj";
    public static final String HHKDRADR2KJ              = "hhkdradr2kj";
    public static final String HHKDRADR3KJ              = "hhkdradr3kj";
    public static final String HHKDRTELNO               = "hhkdrtelno";
    public static final String HHKDRTELNOMTRKHYOUJI     = "hhkdrtelnomtrkhyouji";
    public static final String KHSYONO2                 = "khsyono2";
    public static final String KHSYONO3                 = "khsyono3";
    public static final String KHSYONO4                 = "khsyono4";
    public static final String KHSYONO5                 = "khsyono5";
    public static final String KHSYONO6                 = "khsyono6";
    public static final String KHSYONO7                 = "khsyono7";
    public static final String KHSYONO8                 = "khsyono8";
    public static final String KHSYONO9                 = "khsyono9";
    public static final String KHSYONO10                = "khsyono10";
    public static final String KHMOSNO1                 = "khmosno1";
    public static final String KHMOSNO2                 = "khmosno2";
    public static final String KHMOSNO3                 = "khmosno3";
    public static final String KHMOSNO4                 = "khmosno4";
    public static final String KHMOSNO5                 = "khmosno5";
    public static final String KHMOSNO6                 = "khmosno6";
    public static final String KHMOSNO7                 = "khmosno7";
    public static final String KHMOSNO8                 = "khmosno8";
    public static final String KHMOSNO9                 = "khmosno9";
    public static final String KHMOSNO10                = "khmosno10";
    public static final String HNSNHUTOUHUUNYUUHYOUJI   = "hnsnhutouhuunyuuhyouji";

    private final PKIT_BAK_TtdkKan primaryKey;

    public GenIT_BAK_TtdkKan() {
        primaryKey = new PKIT_BAK_TtdkKan();
    }

    public GenIT_BAK_TtdkKan(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        String pHenkousikibetukey
    ) {
        primaryKey = new PKIT_BAK_TtdkKan(
            pKbnkey,
            pSyono,
            pTrkssikibetukey,
            pHenkousikibetukey
        );
    }

    @Transient
    @Override
    public PKIT_BAK_TtdkKan getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_TtdkKan> getMetaClass() {
        return QIT_BAK_TtdkKan.class;
    }

    @Id
    @Column(name=GenIT_BAK_TtdkKan.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_TtdkKan.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    @Id
    @Column(name=GenIT_BAK_TtdkKan.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    @Id
    @Column(name=GenIT_BAK_TtdkKan.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return getPrimaryKey().getHenkousikibetukey();
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        getPrimaryKey().setHenkousikibetukey(pHenkousikibetukey);
    }

    private C_SyoruiCdKbn syoruiCd;

    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenIT_BAK_TtdkKan.SYORUICD)
    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }

    private BizDate tyouhyouymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_TtdkKan.TYOUHYOUYMD)
    @ValidDate
    public BizDate getTyouhyouymd() {
        return tyouhyouymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        tyouhyouymd = pTyouhyouymd;
    }

    private C_HassouKbn hassoukbn;

    @Type(type="UserType_C_HassouKbn")
    @Column(name=GenIT_BAK_TtdkKan.HASSOUKBN)
    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    private C_TantousituKbn tantousitukbn;

    @Type(type="UserType_C_TantousituKbn")
    @Column(name=GenIT_BAK_TtdkKan.TANTOUSITUKBN)
    public C_TantousituKbn getTantousitukbn() {
        return tantousitukbn;
    }

    public void setTantousitukbn(C_TantousituKbn pTantousitukbn) {
        tantousitukbn = pTantousitukbn;
    }

    private C_UmuKbn syoukendhumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_BAK_TtdkKan.SYOUKENDHUMUKBN)
    public C_UmuKbn getSyoukendhumukbn() {
        return syoukendhumukbn;
    }

    public void setSyoukendhumukbn(C_UmuKbn pSyoukendhumukbn) {
        syoukendhumukbn = pSyoukendhumukbn;
    }

    private String shskyno;

    @Column(name=GenIT_BAK_TtdkKan.SHSKYNO)
    @Length(length=7)
    @Digit
    public String getShskyno() {
        return shskyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShskyno(String pShskyno) {
        shskyno = pShskyno;
    }

    private String shsadr1kj;

    @Column(name=GenIT_BAK_TtdkKan.SHSADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsadr1kj() {
        return shsadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr1kj(String pShsadr1kj) {
        shsadr1kj = pShsadr1kj;
    }

    private String shsadr2kj;

    @Column(name=GenIT_BAK_TtdkKan.SHSADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsadr2kj() {
        return shsadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr2kj(String pShsadr2kj) {
        shsadr2kj = pShsadr2kj;
    }

    private String shsadr3kj;

    @Column(name=GenIT_BAK_TtdkKan.SHSADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsadr3kj() {
        return shsadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsadr3kj(String pShsadr3kj) {
        shsadr3kj = pShsadr3kj;
    }

    private String shsnmkj;

    @Column(name=GenIT_BAK_TtdkKan.SHSNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsnmkj() {
        return shsnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsnmkj(String pShsnmkj) {
        shsnmkj = pShsnmkj;
    }

    private String shsnmkj2;

    @Column(name=GenIT_BAK_TtdkKan.SHSNMKJ2)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getShsnmkj2() {
        return shsnmkj2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setShsnmkj2(String pShsnmkj2) {
        shsnmkj2 = pShsnmkj2;
    }

    private String toiawasesosikinmkj;

    @Column(name=GenIT_BAK_TtdkKan.TOIAWASESOSIKINMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getToiawasesosikinmkj() {
        return toiawasesosikinmkj;
    }

    @DataConvert("toMultiByte")
    public void setToiawasesosikinmkj(String pToiawasesosikinmkj) {
        toiawasesosikinmkj = pToiawasesosikinmkj;
    }

    private String toiawaseyno;

    @Column(name=GenIT_BAK_TtdkKan.TOIAWASEYNO)
    public String getToiawaseyno() {
        return toiawaseyno;
    }

    public void setToiawaseyno(String pToiawaseyno) {
        toiawaseyno = pToiawaseyno;
    }

    private String toiawaseadr1kj;

    @Column(name=GenIT_BAK_TtdkKan.TOIAWASEADR1KJ)
    public String getToiawaseadr1kj() {
        return toiawaseadr1kj;
    }

    public void setToiawaseadr1kj(String pToiawaseadr1kj) {
        toiawaseadr1kj = pToiawaseadr1kj;
    }

    private String toiawaseadr2kj;

    @Column(name=GenIT_BAK_TtdkKan.TOIAWASEADR2KJ)
    public String getToiawaseadr2kj() {
        return toiawaseadr2kj;
    }

    public void setToiawaseadr2kj(String pToiawaseadr2kj) {
        toiawaseadr2kj = pToiawaseadr2kj;
    }

    private String toiawaseadr3kj;

    @Column(name=GenIT_BAK_TtdkKan.TOIAWASEADR3KJ)
    public String getToiawaseadr3kj() {
        return toiawaseadr3kj;
    }

    public void setToiawaseadr3kj(String pToiawaseadr3kj) {
        toiawaseadr3kj = pToiawaseadr3kj;
    }

    private String toiawasekaisyanmkj;

    @Column(name=GenIT_BAK_TtdkKan.TOIAWASEKAISYANMKJ)
    public String getToiawasekaisyanmkj() {
        return toiawasekaisyanmkj;
    }

    public void setToiawasekaisyanmkj(String pToiawasekaisyanmkj) {
        toiawasekaisyanmkj = pToiawasekaisyanmkj;
    }

    private String toiawasetelno;

    @Column(name=GenIT_BAK_TtdkKan.TOIAWASETELNO)
    @AlphaDigitOrExceptionCode(except=("-()"))
    @MaxLength(max=14)
    public String getToiawasetelno() {
        return toiawasetelno;
    }

    @DataConvert("toSingleByte")
    public void setToiawasetelno(String pToiawasetelno) {
        toiawasetelno = pToiawasetelno;
    }

    private String toiawaseteluktkkanou1;

    @Column(name=GenIT_BAK_TtdkKan.TOIAWASETELUKTKKANOU1)
    public String getToiawaseteluktkkanou1() {
        return toiawaseteluktkkanou1;
    }

    public void setToiawaseteluktkkanou1(String pToiawaseteluktkkanou1) {
        toiawaseteluktkkanou1 = pToiawaseteluktkkanou1;
    }

    private String toiawaseteluktkkanou2;

    @Column(name=GenIT_BAK_TtdkKan.TOIAWASETELUKTKKANOU2)
    public String getToiawaseteluktkkanou2() {
        return toiawaseteluktkkanou2;
    }

    public void setToiawaseteluktkkanou2(String pToiawaseteluktkkanou2) {
        toiawaseteluktkkanou2 = pToiawaseteluktkkanou2;
    }

    private C_TetudukisyuKbn tetudukisyukbn;

    @Type(type="UserType_C_TetudukisyuKbn")
    @Column(name=GenIT_BAK_TtdkKan.TETUDUKISYUKBN)
    public C_TetudukisyuKbn getTetudukisyukbn() {
        return tetudukisyukbn;
    }

    public void setTetudukisyukbn(C_TetudukisyuKbn pTetudukisyukbn) {
        tetudukisyukbn = pTetudukisyukbn;
    }

    private C_UmuKbn shrumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_BAK_TtdkKan.SHRUMU)
    public C_UmuKbn getShrumu() {
        return shrumu;
    }

    public void setShrumu(C_UmuKbn pShrumu) {
        shrumu = pShrumu;
    }

    private C_SyoriKbn syorikbn;

    @Type(type="UserType_C_SyoriKbn")
    @Column(name=GenIT_BAK_TtdkKan.SYORIKBN)
    public C_SyoriKbn getSyorikbn() {
        return syorikbn;
    }

    public void setSyorikbn(C_SyoriKbn pSyorikbn) {
        syorikbn = pSyorikbn;
    }

    private String kyknmkj;

    @Column(name=GenIT_BAK_TtdkKan.KYKNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getKyknmkj() {
        return kyknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkj(String pKyknmkj) {
        kyknmkj = pKyknmkj;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_TtdkKan.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private String syouhnnm;

    @Column(name=GenIT_BAK_TtdkKan.SYOUHNNM)
    @MaxLength(max=40)
    @MultiByteStrings
    @InvalidCharacter
    public String getSyouhnnm() {
        return syouhnnm;
    }

    @Trim("right")
    public void setSyouhnnm(String pSyouhnnm) {
        syouhnnm = pSyouhnnm;
    }

    private String hhknnmkj;

    @Column(name=GenIT_BAK_TtdkKan.HHKNNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhknnmkj() {
        return hhknnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkj(String pHhknnmkj) {
        hhknnmkj = pHhknnmkj;
    }

    private C_UmuKbn yenshrtktekiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_BAK_TtdkKan.YENSHRTKTEKIUMU)
    public C_UmuKbn getYenshrtktekiumu() {
        return yenshrtktekiumu;
    }

    public void setYenshrtktekiumu(C_UmuKbn pYenshrtktekiumu) {
        yenshrtktekiumu = pYenshrtktekiumu;
    }

    private C_UmuKbn ttdknaiyouumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_BAK_TtdkKan.TTDKNAIYOUUMUKBN)
    public C_UmuKbn getTtdknaiyouumukbn() {
        return ttdknaiyouumukbn;
    }

    public void setTtdknaiyouumukbn(C_UmuKbn pTtdknaiyouumukbn) {
        ttdknaiyouumukbn = pTtdknaiyouumukbn;
    }

    private String ttdknaiyou1;

    @Column(name=GenIT_BAK_TtdkKan.TTDKNAIYOU1)
    public String getTtdknaiyou1() {
        return ttdknaiyou1;
    }

    public void setTtdknaiyou1(String pTtdknaiyou1) {
        ttdknaiyou1 = pTtdknaiyou1;
    }

    private String ttdknaiyou2;

    @Column(name=GenIT_BAK_TtdkKan.TTDKNAIYOU2)
    public String getTtdknaiyou2() {
        return ttdknaiyou2;
    }

    public void setTtdknaiyou2(String pTtdknaiyou2) {
        ttdknaiyou2 = pTtdknaiyou2;
    }

    private String ttdknaiyou3;

    @Column(name=GenIT_BAK_TtdkKan.TTDKNAIYOU3)
    public String getTtdknaiyou3() {
        return ttdknaiyou3;
    }

    public void setTtdknaiyou3(String pTtdknaiyou3) {
        ttdknaiyou3 = pTtdknaiyou3;
    }

    private String ttdknaiyou4;

    @Column(name=GenIT_BAK_TtdkKan.TTDKNAIYOU4)
    public String getTtdknaiyou4() {
        return ttdknaiyou4;
    }

    public void setTtdknaiyou4(String pTtdknaiyou4) {
        ttdknaiyou4 = pTtdknaiyou4;
    }

    private String ttdknaiyou5;

    @Column(name=GenIT_BAK_TtdkKan.TTDKNAIYOU5)
    public String getTtdknaiyou5() {
        return ttdknaiyou5;
    }

    public void setTtdknaiyou5(String pTtdknaiyou5) {
        ttdknaiyou5 = pTtdknaiyou5;
    }

    private String ttdknaiyou6;

    @Column(name=GenIT_BAK_TtdkKan.TTDKNAIYOU6)
    public String getTtdknaiyou6() {
        return ttdknaiyou6;
    }

    public void setTtdknaiyou6(String pTtdknaiyou6) {
        ttdknaiyou6 = pTtdknaiyou6;
    }

    private String ttdknaiyou7;

    @Column(name=GenIT_BAK_TtdkKan.TTDKNAIYOU7)
    public String getTtdknaiyou7() {
        return ttdknaiyou7;
    }

    public void setTtdknaiyou7(String pTtdknaiyou7) {
        ttdknaiyou7 = pTtdknaiyou7;
    }

    private String ttdknaiyou8;

    @Column(name=GenIT_BAK_TtdkKan.TTDKNAIYOU8)
    public String getTtdknaiyou8() {
        return ttdknaiyou8;
    }

    public void setTtdknaiyou8(String pTtdknaiyou8) {
        ttdknaiyou8 = pTtdknaiyou8;
    }

    private String ttdknaiyou9;

    @Column(name=GenIT_BAK_TtdkKan.TTDKNAIYOU9)
    public String getTtdknaiyou9() {
        return ttdknaiyou9;
    }

    public void setTtdknaiyou9(String pTtdknaiyou9) {
        ttdknaiyou9 = pTtdknaiyou9;
    }

    private String ttdknaiyou10;

    @Column(name=GenIT_BAK_TtdkKan.TTDKNAIYOU10)
    public String getTtdknaiyou10() {
        return ttdknaiyou10;
    }

    public void setTtdknaiyou10(String pTtdknaiyou10) {
        ttdknaiyou10 = pTtdknaiyou10;
    }

    private BizDate shrymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_TtdkKan.SHRYMD)
    @ValidDate
    public BizDate getShrymd() {
        return shrymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrymd(BizDate pShrymd) {
        shrymd = pShrymd;
    }

    private BizDate calckijyunymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_TtdkKan.CALCKIJYUNYMD)
    @ValidDate
    public BizDate getCalckijyunymd() {
        return calckijyunymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCalckijyunymd(BizDate pCalckijyunymd) {
        calckijyunymd = pCalckijyunymd;
    }

    private BizDate kaiykymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_TtdkKan.KAIYKYMD)
    @ValidDate
    public BizDate getKaiykymd() {
        return kaiykymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKaiykymd(BizDate pKaiykymd) {
        kaiykymd = pKaiykymd;
    }

    private C_Tuukasyu shrtuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_TtdkKan.SHRTUUKASYU)
    public C_Tuukasyu getShrtuukasyu() {
        return shrtuukasyu;
    }

    public void setShrtuukasyu(C_Tuukasyu pShrtuukasyu) {
        shrtuukasyu = pShrtuukasyu;
    }

    private String shrtuukasyuryk;

    @Column(name=GenIT_BAK_TtdkKan.SHRTUUKASYURYK)
    public String getShrtuukasyuryk() {
        return shrtuukasyuryk;
    }

    public void setShrtuukasyuryk(String pShrtuukasyuryk) {
        shrtuukasyuryk = pShrtuukasyuryk;
    }

    private BizCurrency shrgkkei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrgkkei() {
        return shrgkkei;
    }

    public void setShrgkkei(BizCurrency pShrgkkei) {
        shrgkkei = pShrgkkei;
        shrgkkeiValue = null;
        shrgkkeiType  = null;
    }

    transient private BigDecimal shrgkkeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRGKKEI, nullable=true)
    protected BigDecimal getShrgkkeiValue() {
        if (shrgkkeiValue == null && shrgkkei != null) {
            if (shrgkkei.isOptional()) return null;
            return shrgkkei.absolute();
        }
        return shrgkkeiValue;
    }

    protected void setShrgkkeiValue(BigDecimal value) {
        shrgkkeiValue = value;
        shrgkkei = Optional.fromNullable(toCurrencyType(shrgkkeiType))
            .transform(bizCurrencyTransformer(getShrgkkeiValue()))
            .orNull();
    }

    transient private String shrgkkeiType = null;

    @Column(name=SHRGKKEI + "$", nullable=true)
    protected String getShrgkkeiType() {
        if (shrgkkeiType == null && shrgkkei != null) return shrgkkei.getType().toString();
        if (shrgkkeiType == null && getShrgkkeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrgkkei$' should not be NULL."));
        }
        return shrgkkeiType;
    }

    protected void setShrgkkeiType(String type) {
        shrgkkeiType = type;
        shrgkkei = Optional.fromNullable(toCurrencyType(shrgkkeiType))
            .transform(bizCurrencyTransformer(getShrgkkeiValue()))
            .orNull();
    }

    private BizCurrency hnkngk;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getHnkngk() {
        return hnkngk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHnkngk(BizCurrency pHnkngk) {
        hnkngk = pHnkngk;
        hnkngkValue = null;
        hnkngkType  = null;
    }

    transient private BigDecimal hnkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HNKNGK, nullable=true)
    protected BigDecimal getHnkngkValue() {
        if (hnkngkValue == null && hnkngk != null) {
            if (hnkngk.isOptional()) return null;
            return hnkngk.absolute();
        }
        return hnkngkValue;
    }

    protected void setHnkngkValue(BigDecimal value) {
        hnkngkValue = value;
        hnkngk = Optional.fromNullable(toCurrencyType(hnkngkType))
            .transform(bizCurrencyTransformer(getHnkngkValue()))
            .orNull();
    }

    transient private String hnkngkType = null;

    @Column(name=HNKNGK + "$", nullable=true)
    protected String getHnkngkType() {
        if (hnkngkType == null && hnkngk != null) return hnkngk.getType().toString();
        if (hnkngkType == null && getHnkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hnkngk$' should not be NULL."));
        }
        return hnkngkType;
    }

    protected void setHnkngkType(String type) {
        hnkngkType = type;
        hnkngk = Optional.fromNullable(toCurrencyType(hnkngkType))
            .transform(bizCurrencyTransformer(getHnkngkValue()))
            .orNull();
    }

    private C_Tuukasyu hnkntuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_TtdkKan.HNKNTUUKASYU)
    public C_Tuukasyu getHnkntuukasyu() {
        return hnkntuukasyu;
    }

    public void setHnkntuukasyu(C_Tuukasyu pHnkntuukasyu) {
        hnkntuukasyu = pHnkntuukasyu;
    }

    private BizDate hnknymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_TtdkKan.HNKNYMD)
    public BizDate getHnknymd() {
        return hnknymd;
    }

    public void setHnknymd(BizDate pHnknymd) {
        hnknymd = pHnknymd;
    }

    private BizCurrency shrtienrsk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrtienrsk() {
        return shrtienrsk;
    }

    public void setShrtienrsk(BizCurrency pShrtienrsk) {
        shrtienrsk = pShrtienrsk;
        shrtienrskValue = null;
        shrtienrskType  = null;
    }

    transient private BigDecimal shrtienrskValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRTIENRSK, nullable=true)
    protected BigDecimal getShrtienrskValue() {
        if (shrtienrskValue == null && shrtienrsk != null) {
            if (shrtienrsk.isOptional()) return null;
            return shrtienrsk.absolute();
        }
        return shrtienrskValue;
    }

    protected void setShrtienrskValue(BigDecimal value) {
        shrtienrskValue = value;
        shrtienrsk = Optional.fromNullable(toCurrencyType(shrtienrskType))
            .transform(bizCurrencyTransformer(getShrtienrskValue()))
            .orNull();
    }

    transient private String shrtienrskType = null;

    @Column(name=SHRTIENRSK + "$", nullable=true)
    protected String getShrtienrskType() {
        if (shrtienrskType == null && shrtienrsk != null) return shrtienrsk.getType().toString();
        if (shrtienrskType == null && getShrtienrskValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrtienrsk$' should not be NULL."));
        }
        return shrtienrskType;
    }

    protected void setShrtienrskType(String type) {
        shrtienrskType = type;
        shrtienrsk = Optional.fromNullable(toCurrencyType(shrtienrskType))
            .transform(bizCurrencyTransformer(getShrtienrskValue()))
            .orNull();
    }

    private String tekiyou1;

    @Column(name=GenIT_BAK_TtdkKan.TEKIYOU1)
    public String getTekiyou1() {
        return tekiyou1;
    }

    public void setTekiyou1(String pTekiyou1) {
        tekiyou1 = pTekiyou1;
    }

    private String tekiyou2;

    @Column(name=GenIT_BAK_TtdkKan.TEKIYOU2)
    public String getTekiyou2() {
        return tekiyou2;
    }

    public void setTekiyou2(String pTekiyou2) {
        tekiyou2 = pTekiyou2;
    }

    private String tekiyou3;

    @Column(name=GenIT_BAK_TtdkKan.TEKIYOU3)
    public String getTekiyou3() {
        return tekiyou3;
    }

    public void setTekiyou3(String pTekiyou3) {
        tekiyou3 = pTekiyou3;
    }

    private String tekiyou4;

    @Column(name=GenIT_BAK_TtdkKan.TEKIYOU4)
    public String getTekiyou4() {
        return tekiyou4;
    }

    public void setTekiyou4(String pTekiyou4) {
        tekiyou4 = pTekiyou4;
    }

    private String tekiyou5;

    @Column(name=GenIT_BAK_TtdkKan.TEKIYOU5)
    public String getTekiyou5() {
        return tekiyou5;
    }

    public void setTekiyou5(String pTekiyou5) {
        tekiyou5 = pTekiyou5;
    }

    private String tekiyou6;

    @Column(name=GenIT_BAK_TtdkKan.TEKIYOU6)
    public String getTekiyou6() {
        return tekiyou6;
    }

    public void setTekiyou6(String pTekiyou6) {
        tekiyou6 = pTekiyou6;
    }

    private String tekiyou7;

    @Column(name=GenIT_BAK_TtdkKan.TEKIYOU7)
    public String getTekiyou7() {
        return tekiyou7;
    }

    public void setTekiyou7(String pTekiyou7) {
        tekiyou7 = pTekiyou7;
    }

    private String tekiyou8;

    @Column(name=GenIT_BAK_TtdkKan.TEKIYOU8)
    public String getTekiyou8() {
        return tekiyou8;
    }

    public void setTekiyou8(String pTekiyou8) {
        tekiyou8 = pTekiyou8;
    }

    private String tekiyou9;

    @Column(name=GenIT_BAK_TtdkKan.TEKIYOU9)
    public String getTekiyou9() {
        return tekiyou9;
    }

    public void setTekiyou9(String pTekiyou9) {
        tekiyou9 = pTekiyou9;
    }

    private String tekiyou10;

    @Column(name=GenIT_BAK_TtdkKan.TEKIYOU10)
    public String getTekiyou10() {
        return tekiyou10;
    }

    public void setTekiyou10(String pTekiyou10) {
        tekiyou10 = pTekiyou10;
    }

    private BizCurrency kngkmeisai1;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKngkmeisai1() {
        return kngkmeisai1;
    }

    public void setKngkmeisai1(BizCurrency pKngkmeisai1) {
        kngkmeisai1 = pKngkmeisai1;
        kngkmeisai1Value = null;
        kngkmeisai1Type  = null;
    }

    transient private BigDecimal kngkmeisai1Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KNGKMEISAI1, nullable=true)
    protected BigDecimal getKngkmeisai1Value() {
        if (kngkmeisai1Value == null && kngkmeisai1 != null) {
            if (kngkmeisai1.isOptional()) return null;
            return kngkmeisai1.absolute();
        }
        return kngkmeisai1Value;
    }

    protected void setKngkmeisai1Value(BigDecimal value) {
        kngkmeisai1Value = value;
        kngkmeisai1 = Optional.fromNullable(toCurrencyType(kngkmeisai1Type))
            .transform(bizCurrencyTransformer(getKngkmeisai1Value()))
            .orNull();
    }

    transient private String kngkmeisai1Type = null;

    @Column(name=KNGKMEISAI1 + "$", nullable=true)
    protected String getKngkmeisai1Type() {
        if (kngkmeisai1Type == null && kngkmeisai1 != null) return kngkmeisai1.getType().toString();
        if (kngkmeisai1Type == null && getKngkmeisai1Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kngkmeisai1$' should not be NULL."));
        }
        return kngkmeisai1Type;
    }

    protected void setKngkmeisai1Type(String type) {
        kngkmeisai1Type = type;
        kngkmeisai1 = Optional.fromNullable(toCurrencyType(kngkmeisai1Type))
            .transform(bizCurrencyTransformer(getKngkmeisai1Value()))
            .orNull();
    }

    private BizCurrency kngkmeisai2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKngkmeisai2() {
        return kngkmeisai2;
    }

    public void setKngkmeisai2(BizCurrency pKngkmeisai2) {
        kngkmeisai2 = pKngkmeisai2;
        kngkmeisai2Value = null;
        kngkmeisai2Type  = null;
    }

    transient private BigDecimal kngkmeisai2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KNGKMEISAI2, nullable=true)
    protected BigDecimal getKngkmeisai2Value() {
        if (kngkmeisai2Value == null && kngkmeisai2 != null) {
            if (kngkmeisai2.isOptional()) return null;
            return kngkmeisai2.absolute();
        }
        return kngkmeisai2Value;
    }

    protected void setKngkmeisai2Value(BigDecimal value) {
        kngkmeisai2Value = value;
        kngkmeisai2 = Optional.fromNullable(toCurrencyType(kngkmeisai2Type))
            .transform(bizCurrencyTransformer(getKngkmeisai2Value()))
            .orNull();
    }

    transient private String kngkmeisai2Type = null;

    @Column(name=KNGKMEISAI2 + "$", nullable=true)
    protected String getKngkmeisai2Type() {
        if (kngkmeisai2Type == null && kngkmeisai2 != null) return kngkmeisai2.getType().toString();
        if (kngkmeisai2Type == null && getKngkmeisai2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kngkmeisai2$' should not be NULL."));
        }
        return kngkmeisai2Type;
    }

    protected void setKngkmeisai2Type(String type) {
        kngkmeisai2Type = type;
        kngkmeisai2 = Optional.fromNullable(toCurrencyType(kngkmeisai2Type))
            .transform(bizCurrencyTransformer(getKngkmeisai2Value()))
            .orNull();
    }

    private BizCurrency kngkmeisai3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKngkmeisai3() {
        return kngkmeisai3;
    }

    public void setKngkmeisai3(BizCurrency pKngkmeisai3) {
        kngkmeisai3 = pKngkmeisai3;
        kngkmeisai3Value = null;
        kngkmeisai3Type  = null;
    }

    transient private BigDecimal kngkmeisai3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KNGKMEISAI3, nullable=true)
    protected BigDecimal getKngkmeisai3Value() {
        if (kngkmeisai3Value == null && kngkmeisai3 != null) {
            if (kngkmeisai3.isOptional()) return null;
            return kngkmeisai3.absolute();
        }
        return kngkmeisai3Value;
    }

    protected void setKngkmeisai3Value(BigDecimal value) {
        kngkmeisai3Value = value;
        kngkmeisai3 = Optional.fromNullable(toCurrencyType(kngkmeisai3Type))
            .transform(bizCurrencyTransformer(getKngkmeisai3Value()))
            .orNull();
    }

    transient private String kngkmeisai3Type = null;

    @Column(name=KNGKMEISAI3 + "$", nullable=true)
    protected String getKngkmeisai3Type() {
        if (kngkmeisai3Type == null && kngkmeisai3 != null) return kngkmeisai3.getType().toString();
        if (kngkmeisai3Type == null && getKngkmeisai3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kngkmeisai3$' should not be NULL."));
        }
        return kngkmeisai3Type;
    }

    protected void setKngkmeisai3Type(String type) {
        kngkmeisai3Type = type;
        kngkmeisai3 = Optional.fromNullable(toCurrencyType(kngkmeisai3Type))
            .transform(bizCurrencyTransformer(getKngkmeisai3Value()))
            .orNull();
    }

    private BizCurrency kngkmeisai4;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKngkmeisai4() {
        return kngkmeisai4;
    }

    public void setKngkmeisai4(BizCurrency pKngkmeisai4) {
        kngkmeisai4 = pKngkmeisai4;
        kngkmeisai4Value = null;
        kngkmeisai4Type  = null;
    }

    transient private BigDecimal kngkmeisai4Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KNGKMEISAI4, nullable=true)
    protected BigDecimal getKngkmeisai4Value() {
        if (kngkmeisai4Value == null && kngkmeisai4 != null) {
            if (kngkmeisai4.isOptional()) return null;
            return kngkmeisai4.absolute();
        }
        return kngkmeisai4Value;
    }

    protected void setKngkmeisai4Value(BigDecimal value) {
        kngkmeisai4Value = value;
        kngkmeisai4 = Optional.fromNullable(toCurrencyType(kngkmeisai4Type))
            .transform(bizCurrencyTransformer(getKngkmeisai4Value()))
            .orNull();
    }

    transient private String kngkmeisai4Type = null;

    @Column(name=KNGKMEISAI4 + "$", nullable=true)
    protected String getKngkmeisai4Type() {
        if (kngkmeisai4Type == null && kngkmeisai4 != null) return kngkmeisai4.getType().toString();
        if (kngkmeisai4Type == null && getKngkmeisai4Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kngkmeisai4$' should not be NULL."));
        }
        return kngkmeisai4Type;
    }

    protected void setKngkmeisai4Type(String type) {
        kngkmeisai4Type = type;
        kngkmeisai4 = Optional.fromNullable(toCurrencyType(kngkmeisai4Type))
            .transform(bizCurrencyTransformer(getKngkmeisai4Value()))
            .orNull();
    }

    private BizCurrency kngkmeisai5;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKngkmeisai5() {
        return kngkmeisai5;
    }

    public void setKngkmeisai5(BizCurrency pKngkmeisai5) {
        kngkmeisai5 = pKngkmeisai5;
        kngkmeisai5Value = null;
        kngkmeisai5Type  = null;
    }

    transient private BigDecimal kngkmeisai5Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KNGKMEISAI5, nullable=true)
    protected BigDecimal getKngkmeisai5Value() {
        if (kngkmeisai5Value == null && kngkmeisai5 != null) {
            if (kngkmeisai5.isOptional()) return null;
            return kngkmeisai5.absolute();
        }
        return kngkmeisai5Value;
    }

    protected void setKngkmeisai5Value(BigDecimal value) {
        kngkmeisai5Value = value;
        kngkmeisai5 = Optional.fromNullable(toCurrencyType(kngkmeisai5Type))
            .transform(bizCurrencyTransformer(getKngkmeisai5Value()))
            .orNull();
    }

    transient private String kngkmeisai5Type = null;

    @Column(name=KNGKMEISAI5 + "$", nullable=true)
    protected String getKngkmeisai5Type() {
        if (kngkmeisai5Type == null && kngkmeisai5 != null) return kngkmeisai5.getType().toString();
        if (kngkmeisai5Type == null && getKngkmeisai5Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kngkmeisai5$' should not be NULL."));
        }
        return kngkmeisai5Type;
    }

    protected void setKngkmeisai5Type(String type) {
        kngkmeisai5Type = type;
        kngkmeisai5 = Optional.fromNullable(toCurrencyType(kngkmeisai5Type))
            .transform(bizCurrencyTransformer(getKngkmeisai5Value()))
            .orNull();
    }

    private BizCurrency kngkmeisai6;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKngkmeisai6() {
        return kngkmeisai6;
    }

    public void setKngkmeisai6(BizCurrency pKngkmeisai6) {
        kngkmeisai6 = pKngkmeisai6;
        kngkmeisai6Value = null;
        kngkmeisai6Type  = null;
    }

    transient private BigDecimal kngkmeisai6Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KNGKMEISAI6, nullable=true)
    protected BigDecimal getKngkmeisai6Value() {
        if (kngkmeisai6Value == null && kngkmeisai6 != null) {
            if (kngkmeisai6.isOptional()) return null;
            return kngkmeisai6.absolute();
        }
        return kngkmeisai6Value;
    }

    protected void setKngkmeisai6Value(BigDecimal value) {
        kngkmeisai6Value = value;
        kngkmeisai6 = Optional.fromNullable(toCurrencyType(kngkmeisai6Type))
            .transform(bizCurrencyTransformer(getKngkmeisai6Value()))
            .orNull();
    }

    transient private String kngkmeisai6Type = null;

    @Column(name=KNGKMEISAI6 + "$", nullable=true)
    protected String getKngkmeisai6Type() {
        if (kngkmeisai6Type == null && kngkmeisai6 != null) return kngkmeisai6.getType().toString();
        if (kngkmeisai6Type == null && getKngkmeisai6Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kngkmeisai6$' should not be NULL."));
        }
        return kngkmeisai6Type;
    }

    protected void setKngkmeisai6Type(String type) {
        kngkmeisai6Type = type;
        kngkmeisai6 = Optional.fromNullable(toCurrencyType(kngkmeisai6Type))
            .transform(bizCurrencyTransformer(getKngkmeisai6Value()))
            .orNull();
    }

    private BizCurrency kngkmeisai7;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKngkmeisai7() {
        return kngkmeisai7;
    }

    public void setKngkmeisai7(BizCurrency pKngkmeisai7) {
        kngkmeisai7 = pKngkmeisai7;
        kngkmeisai7Value = null;
        kngkmeisai7Type  = null;
    }

    transient private BigDecimal kngkmeisai7Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KNGKMEISAI7, nullable=true)
    protected BigDecimal getKngkmeisai7Value() {
        if (kngkmeisai7Value == null && kngkmeisai7 != null) {
            if (kngkmeisai7.isOptional()) return null;
            return kngkmeisai7.absolute();
        }
        return kngkmeisai7Value;
    }

    protected void setKngkmeisai7Value(BigDecimal value) {
        kngkmeisai7Value = value;
        kngkmeisai7 = Optional.fromNullable(toCurrencyType(kngkmeisai7Type))
            .transform(bizCurrencyTransformer(getKngkmeisai7Value()))
            .orNull();
    }

    transient private String kngkmeisai7Type = null;

    @Column(name=KNGKMEISAI7 + "$", nullable=true)
    protected String getKngkmeisai7Type() {
        if (kngkmeisai7Type == null && kngkmeisai7 != null) return kngkmeisai7.getType().toString();
        if (kngkmeisai7Type == null && getKngkmeisai7Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kngkmeisai7$' should not be NULL."));
        }
        return kngkmeisai7Type;
    }

    protected void setKngkmeisai7Type(String type) {
        kngkmeisai7Type = type;
        kngkmeisai7 = Optional.fromNullable(toCurrencyType(kngkmeisai7Type))
            .transform(bizCurrencyTransformer(getKngkmeisai7Value()))
            .orNull();
    }

    private BizCurrency kngkmeisai8;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKngkmeisai8() {
        return kngkmeisai8;
    }

    public void setKngkmeisai8(BizCurrency pKngkmeisai8) {
        kngkmeisai8 = pKngkmeisai8;
        kngkmeisai8Value = null;
        kngkmeisai8Type  = null;
    }

    transient private BigDecimal kngkmeisai8Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KNGKMEISAI8, nullable=true)
    protected BigDecimal getKngkmeisai8Value() {
        if (kngkmeisai8Value == null && kngkmeisai8 != null) {
            if (kngkmeisai8.isOptional()) return null;
            return kngkmeisai8.absolute();
        }
        return kngkmeisai8Value;
    }

    protected void setKngkmeisai8Value(BigDecimal value) {
        kngkmeisai8Value = value;
        kngkmeisai8 = Optional.fromNullable(toCurrencyType(kngkmeisai8Type))
            .transform(bizCurrencyTransformer(getKngkmeisai8Value()))
            .orNull();
    }

    transient private String kngkmeisai8Type = null;

    @Column(name=KNGKMEISAI8 + "$", nullable=true)
    protected String getKngkmeisai8Type() {
        if (kngkmeisai8Type == null && kngkmeisai8 != null) return kngkmeisai8.getType().toString();
        if (kngkmeisai8Type == null && getKngkmeisai8Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kngkmeisai8$' should not be NULL."));
        }
        return kngkmeisai8Type;
    }

    protected void setKngkmeisai8Type(String type) {
        kngkmeisai8Type = type;
        kngkmeisai8 = Optional.fromNullable(toCurrencyType(kngkmeisai8Type))
            .transform(bizCurrencyTransformer(getKngkmeisai8Value()))
            .orNull();
    }

    private BizCurrency kngkmeisai9;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKngkmeisai9() {
        return kngkmeisai9;
    }

    public void setKngkmeisai9(BizCurrency pKngkmeisai9) {
        kngkmeisai9 = pKngkmeisai9;
        kngkmeisai9Value = null;
        kngkmeisai9Type  = null;
    }

    transient private BigDecimal kngkmeisai9Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KNGKMEISAI9, nullable=true)
    protected BigDecimal getKngkmeisai9Value() {
        if (kngkmeisai9Value == null && kngkmeisai9 != null) {
            if (kngkmeisai9.isOptional()) return null;
            return kngkmeisai9.absolute();
        }
        return kngkmeisai9Value;
    }

    protected void setKngkmeisai9Value(BigDecimal value) {
        kngkmeisai9Value = value;
        kngkmeisai9 = Optional.fromNullable(toCurrencyType(kngkmeisai9Type))
            .transform(bizCurrencyTransformer(getKngkmeisai9Value()))
            .orNull();
    }

    transient private String kngkmeisai9Type = null;

    @Column(name=KNGKMEISAI9 + "$", nullable=true)
    protected String getKngkmeisai9Type() {
        if (kngkmeisai9Type == null && kngkmeisai9 != null) return kngkmeisai9.getType().toString();
        if (kngkmeisai9Type == null && getKngkmeisai9Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kngkmeisai9$' should not be NULL."));
        }
        return kngkmeisai9Type;
    }

    protected void setKngkmeisai9Type(String type) {
        kngkmeisai9Type = type;
        kngkmeisai9 = Optional.fromNullable(toCurrencyType(kngkmeisai9Type))
            .transform(bizCurrencyTransformer(getKngkmeisai9Value()))
            .orNull();
    }

    private BizCurrency kngkmeisai10;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKngkmeisai10() {
        return kngkmeisai10;
    }

    public void setKngkmeisai10(BizCurrency pKngkmeisai10) {
        kngkmeisai10 = pKngkmeisai10;
        kngkmeisai10Value = null;
        kngkmeisai10Type  = null;
    }

    transient private BigDecimal kngkmeisai10Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KNGKMEISAI10, nullable=true)
    protected BigDecimal getKngkmeisai10Value() {
        if (kngkmeisai10Value == null && kngkmeisai10 != null) {
            if (kngkmeisai10.isOptional()) return null;
            return kngkmeisai10.absolute();
        }
        return kngkmeisai10Value;
    }

    protected void setKngkmeisai10Value(BigDecimal value) {
        kngkmeisai10Value = value;
        kngkmeisai10 = Optional.fromNullable(toCurrencyType(kngkmeisai10Type))
            .transform(bizCurrencyTransformer(getKngkmeisai10Value()))
            .orNull();
    }

    transient private String kngkmeisai10Type = null;

    @Column(name=KNGKMEISAI10 + "$", nullable=true)
    protected String getKngkmeisai10Type() {
        if (kngkmeisai10Type == null && kngkmeisai10 != null) return kngkmeisai10.getType().toString();
        if (kngkmeisai10Type == null && getKngkmeisai10Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kngkmeisai10$' should not be NULL."));
        }
        return kngkmeisai10Type;
    }

    protected void setKngkmeisai10Type(String type) {
        kngkmeisai10Type = type;
        kngkmeisai10 = Optional.fromNullable(toCurrencyType(kngkmeisai10Type))
            .transform(bizCurrencyTransformer(getKngkmeisai10Value()))
            .orNull();
    }

    private C_Tuukasyu kngkmisituukasyu1;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_TtdkKan.KNGKMISITUUKASYU1)
    public C_Tuukasyu getKngkmisituukasyu1() {
        return kngkmisituukasyu1;
    }

    public void setKngkmisituukasyu1(C_Tuukasyu pKngkmisituukasyu1) {
        kngkmisituukasyu1 = pKngkmisituukasyu1;
    }

    private C_Tuukasyu kngkmisituukasyu2;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_TtdkKan.KNGKMISITUUKASYU2)
    public C_Tuukasyu getKngkmisituukasyu2() {
        return kngkmisituukasyu2;
    }

    public void setKngkmisituukasyu2(C_Tuukasyu pKngkmisituukasyu2) {
        kngkmisituukasyu2 = pKngkmisituukasyu2;
    }

    private C_Tuukasyu kngkmisituukasyu3;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_TtdkKan.KNGKMISITUUKASYU3)
    public C_Tuukasyu getKngkmisituukasyu3() {
        return kngkmisituukasyu3;
    }

    public void setKngkmisituukasyu3(C_Tuukasyu pKngkmisituukasyu3) {
        kngkmisituukasyu3 = pKngkmisituukasyu3;
    }

    private C_Tuukasyu kngkmisituukasyu4;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_TtdkKan.KNGKMISITUUKASYU4)
    public C_Tuukasyu getKngkmisituukasyu4() {
        return kngkmisituukasyu4;
    }

    public void setKngkmisituukasyu4(C_Tuukasyu pKngkmisituukasyu4) {
        kngkmisituukasyu4 = pKngkmisituukasyu4;
    }

    private C_Tuukasyu kngkmisituukasyu5;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_TtdkKan.KNGKMISITUUKASYU5)
    public C_Tuukasyu getKngkmisituukasyu5() {
        return kngkmisituukasyu5;
    }

    public void setKngkmisituukasyu5(C_Tuukasyu pKngkmisituukasyu5) {
        kngkmisituukasyu5 = pKngkmisituukasyu5;
    }

    private C_Tuukasyu kngkmisituukasyu6;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_TtdkKan.KNGKMISITUUKASYU6)
    public C_Tuukasyu getKngkmisituukasyu6() {
        return kngkmisituukasyu6;
    }

    public void setKngkmisituukasyu6(C_Tuukasyu pKngkmisituukasyu6) {
        kngkmisituukasyu6 = pKngkmisituukasyu6;
    }

    private C_Tuukasyu kngkmisituukasyu7;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_TtdkKan.KNGKMISITUUKASYU7)
    public C_Tuukasyu getKngkmisituukasyu7() {
        return kngkmisituukasyu7;
    }

    public void setKngkmisituukasyu7(C_Tuukasyu pKngkmisituukasyu7) {
        kngkmisituukasyu7 = pKngkmisituukasyu7;
    }

    private C_Tuukasyu kngkmisituukasyu8;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_TtdkKan.KNGKMISITUUKASYU8)
    public C_Tuukasyu getKngkmisituukasyu8() {
        return kngkmisituukasyu8;
    }

    public void setKngkmisituukasyu8(C_Tuukasyu pKngkmisituukasyu8) {
        kngkmisituukasyu8 = pKngkmisituukasyu8;
    }

    private C_Tuukasyu kngkmisituukasyu9;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_TtdkKan.KNGKMISITUUKASYU9)
    public C_Tuukasyu getKngkmisituukasyu9() {
        return kngkmisituukasyu9;
    }

    public void setKngkmisituukasyu9(C_Tuukasyu pKngkmisituukasyu9) {
        kngkmisituukasyu9 = pKngkmisituukasyu9;
    }

    private C_Tuukasyu kngkmisituukasyu10;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_TtdkKan.KNGKMISITUUKASYU10)
    public C_Tuukasyu getKngkmisituukasyu10() {
        return kngkmisituukasyu10;
    }

    public void setKngkmisituukasyu10(C_Tuukasyu pKngkmisituukasyu10) {
        kngkmisituukasyu10 = pKngkmisituukasyu10;
    }

    private String bikou1;

    @Column(name=GenIT_BAK_TtdkKan.BIKOU1)
    public String getBikou1() {
        return bikou1;
    }

    public void setBikou1(String pBikou1) {
        bikou1 = pBikou1;
    }

    private String bikou2;

    @Column(name=GenIT_BAK_TtdkKan.BIKOU2)
    public String getBikou2() {
        return bikou2;
    }

    public void setBikou2(String pBikou2) {
        bikou2 = pBikou2;
    }

    private String bikou3;

    @Column(name=GenIT_BAK_TtdkKan.BIKOU3)
    public String getBikou3() {
        return bikou3;
    }

    public void setBikou3(String pBikou3) {
        bikou3 = pBikou3;
    }

    private String bikou4;

    @Column(name=GenIT_BAK_TtdkKan.BIKOU4)
    public String getBikou4() {
        return bikou4;
    }

    public void setBikou4(String pBikou4) {
        bikou4 = pBikou4;
    }

    private String bikou5;

    @Column(name=GenIT_BAK_TtdkKan.BIKOU5)
    public String getBikou5() {
        return bikou5;
    }

    public void setBikou5(String pBikou5) {
        bikou5 = pBikou5;
    }

    private String bikou6;

    @Column(name=GenIT_BAK_TtdkKan.BIKOU6)
    public String getBikou6() {
        return bikou6;
    }

    public void setBikou6(String pBikou6) {
        bikou6 = pBikou6;
    }

    private String bikou7;

    @Column(name=GenIT_BAK_TtdkKan.BIKOU7)
    public String getBikou7() {
        return bikou7;
    }

    public void setBikou7(String pBikou7) {
        bikou7 = pBikou7;
    }

    private String bikou8;

    @Column(name=GenIT_BAK_TtdkKan.BIKOU8)
    public String getBikou8() {
        return bikou8;
    }

    public void setBikou8(String pBikou8) {
        bikou8 = pBikou8;
    }

    private String bikou9;

    @Column(name=GenIT_BAK_TtdkKan.BIKOU9)
    public String getBikou9() {
        return bikou9;
    }

    public void setBikou9(String pBikou9) {
        bikou9 = pBikou9;
    }

    private String bikou10;

    @Column(name=GenIT_BAK_TtdkKan.BIKOU10)
    public String getBikou10() {
        return bikou10;
    }

    public void setBikou10(String pBikou10) {
        bikou10 = pBikou10;
    }

    private String bankcd;

    @Column(name=GenIT_BAK_TtdkKan.BANKCD)
    @Length(length=4)
    @Digit
    public String getBankcd() {
        return bankcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBankcd(String pBankcd) {
        bankcd = pBankcd;
    }

    private String sitencd;

    @Column(name=GenIT_BAK_TtdkKan.SITENCD)
    @Length(length=3)
    @Digit
    public String getSitencd() {
        return sitencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSitencd(String pSitencd) {
        sitencd = pSitencd;
    }

    private String banknmkj;

    @Column(name=GenIT_BAK_TtdkKan.BANKNMKJ)
    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    public String getBanknmkj() {
        return banknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setBanknmkj(String pBanknmkj) {
        banknmkj = pBanknmkj;
    }

    private String sitennmkj;

    @Column(name=GenIT_BAK_TtdkKan.SITENNMKJ)
    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    public String getSitennmkj() {
        return sitennmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSitennmkj(String pSitennmkj) {
        sitennmkj = pSitennmkj;
    }

    private C_YokinKbn yokinkbn;

    @Type(type="UserType_C_YokinKbn")
    @Column(name=GenIT_BAK_TtdkKan.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenIT_BAK_TtdkKan.KOUZANO)
    @MaxLength(max=12)
    @HostInvalidCharacter
    public String getKouzano() {
        return kouzano;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKouzano(String pKouzano) {
        kouzano = pKouzano;
    }

    private C_KouzasyuruiKbn kzsyuruikbn;

    @Type(type="UserType_C_KouzasyuruiKbn")
    @Column(name=GenIT_BAK_TtdkKan.KZSYURUIKBN)
    public C_KouzasyuruiKbn getKzsyuruikbn() {
        return kzsyuruikbn;
    }

    public void setKzsyuruikbn(C_KouzasyuruiKbn pKzsyuruikbn) {
        kzsyuruikbn = pKzsyuruikbn;
    }

    private String kzmeiginmkn;

    @Column(name=GenIT_BAK_TtdkKan.KZMEIGINMKN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKzmeiginmkn() {
        return kzmeiginmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKzmeiginmkn(String pKzmeiginmkn) {
        kzmeiginmkn = pKzmeiginmkn;
    }

    private C_SoukinsakisiteiKbn soukinsakisiteikbn;

    @Type(type="UserType_C_SoukinsakisiteiKbn")
    @Column(name=GenIT_BAK_TtdkKan.SOUKINSAKISITEIKBN)
    public C_SoukinsakisiteiKbn getSoukinsakisiteikbn() {
        return soukinsakisiteikbn;
    }

    public void setSoukinsakisiteikbn(C_SoukinsakisiteiKbn pSoukinsakisiteikbn) {
        soukinsakisiteikbn = pSoukinsakisiteikbn;
    }

    private C_HtsiryosyuKbn htsiryosyukbn;

    @Type(type="UserType_C_HtsiryosyuKbn")
    @Column(name=GenIT_BAK_TtdkKan.HTSIRYOSYUKBN)
    public C_HtsiryosyuKbn getHtsiryosyukbn() {
        return htsiryosyukbn;
    }

    public void setHtsiryosyukbn(C_HtsiryosyuKbn pHtsiryosyukbn) {
        htsiryosyukbn = pHtsiryosyukbn;
    }

    private BizCurrency synykngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSynykngk() {
        return synykngk;
    }

    public void setSynykngk(BizCurrency pSynykngk) {
        synykngk = pSynykngk;
        synykngkValue = null;
        synykngkType  = null;
    }

    transient private BigDecimal synykngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SYNYKNGK, nullable=true)
    protected BigDecimal getSynykngkValue() {
        if (synykngkValue == null && synykngk != null) {
            if (synykngk.isOptional()) return null;
            return synykngk.absolute();
        }
        return synykngkValue;
    }

    protected void setSynykngkValue(BigDecimal value) {
        synykngkValue = value;
        synykngk = Optional.fromNullable(toCurrencyType(synykngkType))
            .transform(bizCurrencyTransformer(getSynykngkValue()))
            .orNull();
    }

    transient private String synykngkType = null;

    @Column(name=SYNYKNGK + "$", nullable=true)
    protected String getSynykngkType() {
        if (synykngkType == null && synykngk != null) return synykngk.getType().toString();
        if (synykngkType == null && getSynykngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'synykngk$' should not be NULL."));
        }
        return synykngkType;
    }

    protected void setSynykngkType(String type) {
        synykngkType = type;
        synykngk = Optional.fromNullable(toCurrencyType(synykngkType))
            .transform(bizCurrencyTransformer(getSynykngkValue()))
            .orNull();
    }

    private BizCurrency htykeihi;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHtykeihi() {
        return htykeihi;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHtykeihi(BizCurrency pHtykeihi) {
        htykeihi = pHtykeihi;
        htykeihiValue = null;
        htykeihiType  = null;
    }

    transient private BigDecimal htykeihiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HTYKEIHI, nullable=true)
    protected BigDecimal getHtykeihiValue() {
        if (htykeihiValue == null && htykeihi != null) {
            if (htykeihi.isOptional()) return null;
            return htykeihi.absolute();
        }
        return htykeihiValue;
    }

    protected void setHtykeihiValue(BigDecimal value) {
        htykeihiValue = value;
        htykeihi = Optional.fromNullable(toCurrencyType(htykeihiType))
            .transform(bizCurrencyTransformer(getHtykeihiValue()))
            .orNull();
    }

    transient private String htykeihiType = null;

    @Column(name=HTYKEIHI + "$", nullable=true)
    protected String getHtykeihiType() {
        if (htykeihiType == null && htykeihi != null) return htykeihi.getType().toString();
        if (htykeihiType == null && getHtykeihiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'htykeihi$' should not be NULL."));
        }
        return htykeihiType;
    }

    protected void setHtykeihiType(String type) {
        htykeihiType = type;
        htykeihi = Optional.fromNullable(toCurrencyType(htykeihiType))
            .transform(bizCurrencyTransformer(getHtykeihiValue()))
            .orNull();
    }

    private C_Kaiyakujiyuu kaiyakujiyuu;

    @Type(type="UserType_C_Kaiyakujiyuu")
    @Column(name=GenIT_BAK_TtdkKan.KAIYAKUJIYUU)
    public C_Kaiyakujiyuu getKaiyakujiyuu() {
        return kaiyakujiyuu;
    }

    public void setKaiyakujiyuu(C_Kaiyakujiyuu pKaiyakujiyuu) {
        kaiyakujiyuu = pKaiyakujiyuu;
    }

    private C_UmuKbn zeimumongonoutkbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_BAK_TtdkKan.ZEIMUMONGONOUTKBN)
    public C_UmuKbn getZeimumongonoutkbn() {
        return zeimumongonoutkbn;
    }

    public void setZeimumongonoutkbn(C_UmuKbn pZeimumongonoutkbn) {
        zeimumongonoutkbn = pZeimumongonoutkbn;
    }

    private String zeimumongon1;

    @Column(name=GenIT_BAK_TtdkKan.ZEIMUMONGON1)
    public String getZeimumongon1() {
        return zeimumongon1;
    }

    public void setZeimumongon1(String pZeimumongon1) {
        zeimumongon1 = pZeimumongon1;
    }

    private String zeimumongon2;

    @Column(name=GenIT_BAK_TtdkKan.ZEIMUMONGON2)
    public String getZeimumongon2() {
        return zeimumongon2;
    }

    public void setZeimumongon2(String pZeimumongon2) {
        zeimumongon2 = pZeimumongon2;
    }

    private String zeimumongon3;

    @Column(name=GenIT_BAK_TtdkKan.ZEIMUMONGON3)
    public String getZeimumongon3() {
        return zeimumongon3;
    }

    public void setZeimumongon3(String pZeimumongon3) {
        zeimumongon3 = pZeimumongon3;
    }

    private String zeimumongon4;

    @Column(name=GenIT_BAK_TtdkKan.ZEIMUMONGON4)
    public String getZeimumongon4() {
        return zeimumongon4;
    }

    public void setZeimumongon4(String pZeimumongon4) {
        zeimumongon4 = pZeimumongon4;
    }

    private String zeimumongon5;

    @Column(name=GenIT_BAK_TtdkKan.ZEIMUMONGON5)
    public String getZeimumongon5() {
        return zeimumongon5;
    }

    public void setZeimumongon5(String pZeimumongon5) {
        zeimumongon5 = pZeimumongon5;
    }

    private String osirasemongonhyoudai;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGONHYOUDAI)
    public String getOsirasemongonhyoudai() {
        return osirasemongonhyoudai;
    }

    public void setOsirasemongonhyoudai(String pOsirasemongonhyoudai) {
        osirasemongonhyoudai = pOsirasemongonhyoudai;
    }

    private String osirasemongon1;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON1)
    public String getOsirasemongon1() {
        return osirasemongon1;
    }

    public void setOsirasemongon1(String pOsirasemongon1) {
        osirasemongon1 = pOsirasemongon1;
    }

    private String osirasemongon2;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON2)
    public String getOsirasemongon2() {
        return osirasemongon2;
    }

    public void setOsirasemongon2(String pOsirasemongon2) {
        osirasemongon2 = pOsirasemongon2;
    }

    private String osirasemongon3;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON3)
    public String getOsirasemongon3() {
        return osirasemongon3;
    }

    public void setOsirasemongon3(String pOsirasemongon3) {
        osirasemongon3 = pOsirasemongon3;
    }

    private String osirasemongon4;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON4)
    public String getOsirasemongon4() {
        return osirasemongon4;
    }

    public void setOsirasemongon4(String pOsirasemongon4) {
        osirasemongon4 = pOsirasemongon4;
    }

    private String osirasemongon5;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON5)
    public String getOsirasemongon5() {
        return osirasemongon5;
    }

    public void setOsirasemongon5(String pOsirasemongon5) {
        osirasemongon5 = pOsirasemongon5;
    }

    private String osirasemongon6;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON6)
    public String getOsirasemongon6() {
        return osirasemongon6;
    }

    public void setOsirasemongon6(String pOsirasemongon6) {
        osirasemongon6 = pOsirasemongon6;
    }

    private String osirasemongon7;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON7)
    public String getOsirasemongon7() {
        return osirasemongon7;
    }

    public void setOsirasemongon7(String pOsirasemongon7) {
        osirasemongon7 = pOsirasemongon7;
    }

    private String osirasemongon8;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON8)
    public String getOsirasemongon8() {
        return osirasemongon8;
    }

    public void setOsirasemongon8(String pOsirasemongon8) {
        osirasemongon8 = pOsirasemongon8;
    }

    private String osirasemongon9;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON9)
    public String getOsirasemongon9() {
        return osirasemongon9;
    }

    public void setOsirasemongon9(String pOsirasemongon9) {
        osirasemongon9 = pOsirasemongon9;
    }

    private String osirasemongon10;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON10)
    public String getOsirasemongon10() {
        return osirasemongon10;
    }

    public void setOsirasemongon10(String pOsirasemongon10) {
        osirasemongon10 = pOsirasemongon10;
    }

    private String osirasemongon11;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON11)
    public String getOsirasemongon11() {
        return osirasemongon11;
    }

    public void setOsirasemongon11(String pOsirasemongon11) {
        osirasemongon11 = pOsirasemongon11;
    }

    private String osirasemongon12;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON12)
    public String getOsirasemongon12() {
        return osirasemongon12;
    }

    public void setOsirasemongon12(String pOsirasemongon12) {
        osirasemongon12 = pOsirasemongon12;
    }

    private String osirasemongon13;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON13)
    public String getOsirasemongon13() {
        return osirasemongon13;
    }

    public void setOsirasemongon13(String pOsirasemongon13) {
        osirasemongon13 = pOsirasemongon13;
    }

    private String osirasemongon14;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON14)
    public String getOsirasemongon14() {
        return osirasemongon14;
    }

    public void setOsirasemongon14(String pOsirasemongon14) {
        osirasemongon14 = pOsirasemongon14;
    }

    private String osirasemongon15;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON15)
    public String getOsirasemongon15() {
        return osirasemongon15;
    }

    public void setOsirasemongon15(String pOsirasemongon15) {
        osirasemongon15 = pOsirasemongon15;
    }

    private String osirasemongon16;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON16)
    public String getOsirasemongon16() {
        return osirasemongon16;
    }

    public void setOsirasemongon16(String pOsirasemongon16) {
        osirasemongon16 = pOsirasemongon16;
    }

    private String osirasemongon17;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON17)
    public String getOsirasemongon17() {
        return osirasemongon17;
    }

    public void setOsirasemongon17(String pOsirasemongon17) {
        osirasemongon17 = pOsirasemongon17;
    }

    private String osirasemongon18;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON18)
    public String getOsirasemongon18() {
        return osirasemongon18;
    }

    public void setOsirasemongon18(String pOsirasemongon18) {
        osirasemongon18 = pOsirasemongon18;
    }

    private String osirasemongon19;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON19)
    public String getOsirasemongon19() {
        return osirasemongon19;
    }

    public void setOsirasemongon19(String pOsirasemongon19) {
        osirasemongon19 = pOsirasemongon19;
    }

    private String osirasemongon20;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON20)
    public String getOsirasemongon20() {
        return osirasemongon20;
    }

    public void setOsirasemongon20(String pOsirasemongon20) {
        osirasemongon20 = pOsirasemongon20;
    }

    private String osirasemongon21;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON21)
    public String getOsirasemongon21() {
        return osirasemongon21;
    }

    public void setOsirasemongon21(String pOsirasemongon21) {
        osirasemongon21 = pOsirasemongon21;
    }

    private String osirasemongon22;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON22)
    public String getOsirasemongon22() {
        return osirasemongon22;
    }

    public void setOsirasemongon22(String pOsirasemongon22) {
        osirasemongon22 = pOsirasemongon22;
    }

    private String osirasemongon23;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON23)
    public String getOsirasemongon23() {
        return osirasemongon23;
    }

    public void setOsirasemongon23(String pOsirasemongon23) {
        osirasemongon23 = pOsirasemongon23;
    }

    private String osirasemongon24;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON24)
    public String getOsirasemongon24() {
        return osirasemongon24;
    }

    public void setOsirasemongon24(String pOsirasemongon24) {
        osirasemongon24 = pOsirasemongon24;
    }

    private String osirasemongon25;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON25)
    public String getOsirasemongon25() {
        return osirasemongon25;
    }

    public void setOsirasemongon25(String pOsirasemongon25) {
        osirasemongon25 = pOsirasemongon25;
    }

    private String osirasemongon26;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON26)
    public String getOsirasemongon26() {
        return osirasemongon26;
    }

    public void setOsirasemongon26(String pOsirasemongon26) {
        osirasemongon26 = pOsirasemongon26;
    }

    private String osirasemongon27;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON27)
    public String getOsirasemongon27() {
        return osirasemongon27;
    }

    public void setOsirasemongon27(String pOsirasemongon27) {
        osirasemongon27 = pOsirasemongon27;
    }

    private String osirasemongon28;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON28)
    public String getOsirasemongon28() {
        return osirasemongon28;
    }

    public void setOsirasemongon28(String pOsirasemongon28) {
        osirasemongon28 = pOsirasemongon28;
    }

    private String osirasemongon29;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON29)
    public String getOsirasemongon29() {
        return osirasemongon29;
    }

    public void setOsirasemongon29(String pOsirasemongon29) {
        osirasemongon29 = pOsirasemongon29;
    }

    private String osirasemongon30;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON30)
    public String getOsirasemongon30() {
        return osirasemongon30;
    }

    public void setOsirasemongon30(String pOsirasemongon30) {
        osirasemongon30 = pOsirasemongon30;
    }

    private String osirasemongon31;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON31)
    public String getOsirasemongon31() {
        return osirasemongon31;
    }

    public void setOsirasemongon31(String pOsirasemongon31) {
        osirasemongon31 = pOsirasemongon31;
    }

    private String osirasemongon32;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON32)
    public String getOsirasemongon32() {
        return osirasemongon32;
    }

    public void setOsirasemongon32(String pOsirasemongon32) {
        osirasemongon32 = pOsirasemongon32;
    }

    private String osirasemongon33;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON33)
    public String getOsirasemongon33() {
        return osirasemongon33;
    }

    public void setOsirasemongon33(String pOsirasemongon33) {
        osirasemongon33 = pOsirasemongon33;
    }

    private String osirasemongon34;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON34)
    public String getOsirasemongon34() {
        return osirasemongon34;
    }

    public void setOsirasemongon34(String pOsirasemongon34) {
        osirasemongon34 = pOsirasemongon34;
    }

    private String osirasemongon35;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON35)
    public String getOsirasemongon35() {
        return osirasemongon35;
    }

    public void setOsirasemongon35(String pOsirasemongon35) {
        osirasemongon35 = pOsirasemongon35;
    }

    private String osirasemongon36;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON36)
    public String getOsirasemongon36() {
        return osirasemongon36;
    }

    public void setOsirasemongon36(String pOsirasemongon36) {
        osirasemongon36 = pOsirasemongon36;
    }

    private String osirasemongon37;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON37)
    public String getOsirasemongon37() {
        return osirasemongon37;
    }

    public void setOsirasemongon37(String pOsirasemongon37) {
        osirasemongon37 = pOsirasemongon37;
    }

    private String osirasemongon38;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON38)
    public String getOsirasemongon38() {
        return osirasemongon38;
    }

    public void setOsirasemongon38(String pOsirasemongon38) {
        osirasemongon38 = pOsirasemongon38;
    }

    private String osirasemongon39;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON39)
    public String getOsirasemongon39() {
        return osirasemongon39;
    }

    public void setOsirasemongon39(String pOsirasemongon39) {
        osirasemongon39 = pOsirasemongon39;
    }

    private String osirasemongon40;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON40)
    public String getOsirasemongon40() {
        return osirasemongon40;
    }

    public void setOsirasemongon40(String pOsirasemongon40) {
        osirasemongon40 = pOsirasemongon40;
    }

    private String osirasemongon41;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON41)
    public String getOsirasemongon41() {
        return osirasemongon41;
    }

    public void setOsirasemongon41(String pOsirasemongon41) {
        osirasemongon41 = pOsirasemongon41;
    }

    private String osirasemongon42;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON42)
    public String getOsirasemongon42() {
        return osirasemongon42;
    }

    public void setOsirasemongon42(String pOsirasemongon42) {
        osirasemongon42 = pOsirasemongon42;
    }

    private String osirasemongon43;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON43)
    public String getOsirasemongon43() {
        return osirasemongon43;
    }

    public void setOsirasemongon43(String pOsirasemongon43) {
        osirasemongon43 = pOsirasemongon43;
    }

    private String osirasemongon44;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON44)
    public String getOsirasemongon44() {
        return osirasemongon44;
    }

    public void setOsirasemongon44(String pOsirasemongon44) {
        osirasemongon44 = pOsirasemongon44;
    }

    private String osirasemongon45;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON45)
    public String getOsirasemongon45() {
        return osirasemongon45;
    }

    public void setOsirasemongon45(String pOsirasemongon45) {
        osirasemongon45 = pOsirasemongon45;
    }

    private String osirasemongon46;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON46)
    public String getOsirasemongon46() {
        return osirasemongon46;
    }

    public void setOsirasemongon46(String pOsirasemongon46) {
        osirasemongon46 = pOsirasemongon46;
    }

    private String osirasemongon47;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON47)
    public String getOsirasemongon47() {
        return osirasemongon47;
    }

    public void setOsirasemongon47(String pOsirasemongon47) {
        osirasemongon47 = pOsirasemongon47;
    }

    private String osirasemongon48;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON48)
    public String getOsirasemongon48() {
        return osirasemongon48;
    }

    public void setOsirasemongon48(String pOsirasemongon48) {
        osirasemongon48 = pOsirasemongon48;
    }

    private String osirasemongon49;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON49)
    public String getOsirasemongon49() {
        return osirasemongon49;
    }

    public void setOsirasemongon49(String pOsirasemongon49) {
        osirasemongon49 = pOsirasemongon49;
    }

    private String osirasemongon50;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEMONGON50)
    public String getOsirasemongon50() {
        return osirasemongon50;
    }

    public void setOsirasemongon50(String pOsirasemongon50) {
        osirasemongon50 = pOsirasemongon50;
    }

    private String osiraseinjihuyouhyouji;

    @Column(name=GenIT_BAK_TtdkKan.OSIRASEINJIHUYOUHYOUJI)
    public String getOsiraseinjihuyouhyouji() {
        return osiraseinjihuyouhyouji;
    }

    public void setOsiraseinjihuyouhyouji(String pOsiraseinjihuyouhyouji) {
        osiraseinjihuyouhyouji = pOsiraseinjihuyouhyouji;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_TtdkKan.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_TtdkKan.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_TtdkKan.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private BizCurrency shrkykhtykeihi;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getShrkykhtykeihi() {
        return shrkykhtykeihi;
    }

    public void setShrkykhtykeihi(BizCurrency pShrkykhtykeihi) {
        shrkykhtykeihi = pShrkykhtykeihi;
        shrkykhtykeihiValue = null;
        shrkykhtykeihiType  = null;
    }

    transient private BigDecimal shrkykhtykeihiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRKYKHTYKEIHI, nullable=true)
    protected BigDecimal getShrkykhtykeihiValue() {
        if (shrkykhtykeihiValue == null && shrkykhtykeihi != null) {
            if (shrkykhtykeihi.isOptional()) return null;
            return shrkykhtykeihi.absolute();
        }
        return shrkykhtykeihiValue;
    }

    protected void setShrkykhtykeihiValue(BigDecimal value) {
        shrkykhtykeihiValue = value;
        shrkykhtykeihi = Optional.fromNullable(toCurrencyType(shrkykhtykeihiType))
            .transform(bizCurrencyTransformer(getShrkykhtykeihiValue()))
            .orNull();
    }

    transient private String shrkykhtykeihiType = null;

    @Column(name=SHRKYKHTYKEIHI + "$", nullable=true)
    protected String getShrkykhtykeihiType() {
        if (shrkykhtykeihiType == null && shrkykhtykeihi != null) return shrkykhtykeihi.getType().toString();
        if (shrkykhtykeihiType == null && getShrkykhtykeihiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrkykhtykeihi$' should not be NULL."));
        }
        return shrkykhtykeihiType;
    }

    protected void setShrkykhtykeihiType(String type) {
        shrkykhtykeihiType = type;
        shrkykhtykeihi = Optional.fromNullable(toCurrencyType(shrkykhtykeihiType))
            .transform(bizCurrencyTransformer(getShrkykhtykeihiValue()))
            .orNull();
    }

    private Integer kykhnkkaisuu;

    @Column(name=GenIT_BAK_TtdkKan.KYKHNKKAISUU)
    public Integer getKykhnkkaisuu() {
        return kykhnkkaisuu;
    }

    public void setKykhnkkaisuu(Integer pKykhnkkaisuu) {
        kykhnkkaisuu = pKykhnkkaisuu;
    }

    private C_ZeimuNaiyouHnsyuCtrlKbn zeimunaiyouhensyuctrlkbn;

    @Type(type="UserType_C_ZeimuNaiyouHnsyuCtrlKbn")
    @Column(name=GenIT_BAK_TtdkKan.ZEIMUNAIYOUHENSYUCTRLKBN)
    public C_ZeimuNaiyouHnsyuCtrlKbn getZeimunaiyouhensyuctrlkbn() {
        return zeimunaiyouhensyuctrlkbn;
    }

    public void setZeimunaiyouhensyuctrlkbn(C_ZeimuNaiyouHnsyuCtrlKbn pZeimunaiyouhensyuctrlkbn) {
        zeimunaiyouhensyuctrlkbn = pZeimunaiyouhensyuctrlkbn;
    }

    private C_KykniyuhenkouKbn kykniyuhnkkbn;

    @Type(type="UserType_C_KykniyuhenkouKbn")
    @Column(name=GenIT_BAK_TtdkKan.KYKNIYUHNKKBN)
    public C_KykniyuhenkouKbn getKykniyuhnkkbn() {
        return kykniyuhnkkbn;
    }

    public void setKykniyuhnkkbn(C_KykniyuhenkouKbn pKykniyuhnkkbn) {
        kykniyuhnkkbn = pKykniyuhnkkbn;
    }

    private BizDate kykniyuhnkymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_TtdkKan.KYKNIYUHNKYMD)
    public BizDate getKykniyuhnkymd() {
        return kykniyuhnkymd;
    }

    public void setKykniyuhnkymd(BizDate pKykniyuhnkymd) {
        kykniyuhnkymd = pKykniyuhnkymd;
    }

    private String kykniyuhnkinfo;

    @Column(name=GenIT_BAK_TtdkKan.KYKNIYUHNKINFO)
    public String getKykniyuhnkinfo() {
        return kykniyuhnkinfo;
    }

    public void setKykniyuhnkinfo(String pKykniyuhnkinfo) {
        kykniyuhnkinfo = pKykniyuhnkinfo;
    }

    private C_HugouKbn kykniyuhnkgkhugou1;

    @Type(type="UserType_C_HugouKbn")
    @Column(name=GenIT_BAK_TtdkKan.KYKNIYUHNKGKHUGOU1)
    public C_HugouKbn getKykniyuhnkgkhugou1() {
        return kykniyuhnkgkhugou1;
    }

    public void setKykniyuhnkgkhugou1(C_HugouKbn pKykniyuhnkgkhugou1) {
        kykniyuhnkgkhugou1 = pKykniyuhnkgkhugou1;
    }

    private BizCurrency kykniyuhnkkngk1;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKykniyuhnkkngk1() {
        return kykniyuhnkkngk1;
    }

    public void setKykniyuhnkkngk1(BizCurrency pKykniyuhnkkngk1) {
        kykniyuhnkkngk1 = pKykniyuhnkkngk1;
        kykniyuhnkkngk1Value = null;
        kykniyuhnkkngk1Type  = null;
    }

    transient private BigDecimal kykniyuhnkkngk1Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KYKNIYUHNKKNGK1, nullable=true)
    protected BigDecimal getKykniyuhnkkngk1Value() {
        if (kykniyuhnkkngk1Value == null && kykniyuhnkkngk1 != null) {
            if (kykniyuhnkkngk1.isOptional()) return null;
            return kykniyuhnkkngk1.absolute();
        }
        return kykniyuhnkkngk1Value;
    }

    protected void setKykniyuhnkkngk1Value(BigDecimal value) {
        kykniyuhnkkngk1Value = value;
        kykniyuhnkkngk1 = Optional.fromNullable(toCurrencyType(kykniyuhnkkngk1Type))
            .transform(bizCurrencyTransformer(getKykniyuhnkkngk1Value()))
            .orNull();
    }

    transient private String kykniyuhnkkngk1Type = null;

    @Column(name=KYKNIYUHNKKNGK1 + "$", nullable=true)
    protected String getKykniyuhnkkngk1Type() {
        if (kykniyuhnkkngk1Type == null && kykniyuhnkkngk1 != null) return kykniyuhnkkngk1.getType().toString();
        if (kykniyuhnkkngk1Type == null && getKykniyuhnkkngk1Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kykniyuhnkkngk1$' should not be NULL."));
        }
        return kykniyuhnkkngk1Type;
    }

    protected void setKykniyuhnkkngk1Type(String type) {
        kykniyuhnkkngk1Type = type;
        kykniyuhnkkngk1 = Optional.fromNullable(toCurrencyType(kykniyuhnkkngk1Type))
            .transform(bizCurrencyTransformer(getKykniyuhnkkngk1Value()))
            .orNull();
    }

    private C_Tuukasyu kykniyuhnkkngktuksyu1;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_TtdkKan.KYKNIYUHNKKNGKTUKSYU1)
    public C_Tuukasyu getKykniyuhnkkngktuksyu1() {
        return kykniyuhnkkngktuksyu1;
    }

    public void setKykniyuhnkkngktuksyu1(C_Tuukasyu pKykniyuhnkkngktuksyu1) {
        kykniyuhnkkngktuksyu1 = pKykniyuhnkkngktuksyu1;
    }

    private C_HugouKbn kykniyuhnkkngkhugou2;

    @Type(type="UserType_C_HugouKbn")
    @Column(name=GenIT_BAK_TtdkKan.KYKNIYUHNKKNGKHUGOU2)
    public C_HugouKbn getKykniyuhnkkngkhugou2() {
        return kykniyuhnkkngkhugou2;
    }

    public void setKykniyuhnkkngkhugou2(C_HugouKbn pKykniyuhnkkngkhugou2) {
        kykniyuhnkkngkhugou2 = pKykniyuhnkkngkhugou2;
    }

    private BizCurrency kykniyuhnkkngk2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKykniyuhnkkngk2() {
        return kykniyuhnkkngk2;
    }

    public void setKykniyuhnkkngk2(BizCurrency pKykniyuhnkkngk2) {
        kykniyuhnkkngk2 = pKykniyuhnkkngk2;
        kykniyuhnkkngk2Value = null;
        kykniyuhnkkngk2Type  = null;
    }

    transient private BigDecimal kykniyuhnkkngk2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KYKNIYUHNKKNGK2, nullable=true)
    protected BigDecimal getKykniyuhnkkngk2Value() {
        if (kykniyuhnkkngk2Value == null && kykniyuhnkkngk2 != null) {
            if (kykniyuhnkkngk2.isOptional()) return null;
            return kykniyuhnkkngk2.absolute();
        }
        return kykniyuhnkkngk2Value;
    }

    protected void setKykniyuhnkkngk2Value(BigDecimal value) {
        kykniyuhnkkngk2Value = value;
        kykniyuhnkkngk2 = Optional.fromNullable(toCurrencyType(kykniyuhnkkngk2Type))
            .transform(bizCurrencyTransformer(getKykniyuhnkkngk2Value()))
            .orNull();
    }

    transient private String kykniyuhnkkngk2Type = null;

    @Column(name=KYKNIYUHNKKNGK2 + "$", nullable=true)
    protected String getKykniyuhnkkngk2Type() {
        if (kykniyuhnkkngk2Type == null && kykniyuhnkkngk2 != null) return kykniyuhnkkngk2.getType().toString();
        if (kykniyuhnkkngk2Type == null && getKykniyuhnkkngk2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kykniyuhnkkngk2$' should not be NULL."));
        }
        return kykniyuhnkkngk2Type;
    }

    protected void setKykniyuhnkkngk2Type(String type) {
        kykniyuhnkkngk2Type = type;
        kykniyuhnkkngk2 = Optional.fromNullable(toCurrencyType(kykniyuhnkkngk2Type))
            .transform(bizCurrencyTransformer(getKykniyuhnkkngk2Value()))
            .orNull();
    }

    private C_Tuukasyu kykniyuhnkkngktuksyu2;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_TtdkKan.KYKNIYUHNKKNGKTUKSYU2)
    public C_Tuukasyu getKykniyuhnkkngktuksyu2() {
        return kykniyuhnkkngktuksyu2;
    }

    public void setKykniyuhnkkngktuksyu2(C_Tuukasyu pKykniyuhnkkngktuksyu2) {
        kykniyuhnkkngktuksyu2 = pKykniyuhnkkngktuksyu2;
    }

    private BizCurrency gsbnrkztsaeki;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGsbnrkztsaeki() {
        return gsbnrkztsaeki;
    }

    public void setGsbnrkztsaeki(BizCurrency pGsbnrkztsaeki) {
        gsbnrkztsaeki = pGsbnrkztsaeki;
        gsbnrkztsaekiValue = null;
        gsbnrkztsaekiType  = null;
    }

    transient private BigDecimal gsbnrkztsaekiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GSBNRKZTSAEKI, nullable=true)
    protected BigDecimal getGsbnrkztsaekiValue() {
        if (gsbnrkztsaekiValue == null && gsbnrkztsaeki != null) {
            if (gsbnrkztsaeki.isOptional()) return null;
            return gsbnrkztsaeki.absolute();
        }
        return gsbnrkztsaekiValue;
    }

    protected void setGsbnrkztsaekiValue(BigDecimal value) {
        gsbnrkztsaekiValue = value;
        gsbnrkztsaeki = Optional.fromNullable(toCurrencyType(gsbnrkztsaekiType))
            .transform(bizCurrencyTransformer(getGsbnrkztsaekiValue()))
            .orNull();
    }

    transient private String gsbnrkztsaekiType = null;

    @Column(name=GSBNRKZTSAEKI + "$", nullable=true)
    protected String getGsbnrkztsaekiType() {
        if (gsbnrkztsaekiType == null && gsbnrkztsaeki != null) return gsbnrkztsaeki.getType().toString();
        if (gsbnrkztsaekiType == null && getGsbnrkztsaekiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gsbnrkztsaeki$' should not be NULL."));
        }
        return gsbnrkztsaekiType;
    }

    protected void setGsbnrkztsaekiType(String type) {
        gsbnrkztsaekiType = type;
        gsbnrkztsaeki = Optional.fromNullable(toCurrencyType(gsbnrkztsaekiType))
            .transform(bizCurrencyTransformer(getGsbnrkztsaekiValue()))
            .orNull();
    }

    private C_HugouKbn shrkngkmeisaihugou1;

    @Type(type="UserType_C_HugouKbn")
    @Column(name=GenIT_BAK_TtdkKan.SHRKNGKMEISAIHUGOU1)
    public C_HugouKbn getShrkngkmeisaihugou1() {
        return shrkngkmeisaihugou1;
    }

    public void setShrkngkmeisaihugou1(C_HugouKbn pShrkngkmeisaihugou1) {
        shrkngkmeisaihugou1 = pShrkngkmeisaihugou1;
    }

    private C_HugouKbn shrkngkmeisaihugou2;

    @Type(type="UserType_C_HugouKbn")
    @Column(name=GenIT_BAK_TtdkKan.SHRKNGKMEISAIHUGOU2)
    public C_HugouKbn getShrkngkmeisaihugou2() {
        return shrkngkmeisaihugou2;
    }

    public void setShrkngkmeisaihugou2(C_HugouKbn pShrkngkmeisaihugou2) {
        shrkngkmeisaihugou2 = pShrkngkmeisaihugou2;
    }

    private C_HugouKbn shrkngkmeisaihugou3;

    @Type(type="UserType_C_HugouKbn")
    @Column(name=GenIT_BAK_TtdkKan.SHRKNGKMEISAIHUGOU3)
    public C_HugouKbn getShrkngkmeisaihugou3() {
        return shrkngkmeisaihugou3;
    }

    public void setShrkngkmeisaihugou3(C_HugouKbn pShrkngkmeisaihugou3) {
        shrkngkmeisaihugou3 = pShrkngkmeisaihugou3;
    }

    private C_HugouKbn shrkngkmeisaihugou4;

    @Type(type="UserType_C_HugouKbn")
    @Column(name=GenIT_BAK_TtdkKan.SHRKNGKMEISAIHUGOU4)
    public C_HugouKbn getShrkngkmeisaihugou4() {
        return shrkngkmeisaihugou4;
    }

    public void setShrkngkmeisaihugou4(C_HugouKbn pShrkngkmeisaihugou4) {
        shrkngkmeisaihugou4 = pShrkngkmeisaihugou4;
    }

    private C_HugouKbn shrkngkmeisaihugou5;

    @Type(type="UserType_C_HugouKbn")
    @Column(name=GenIT_BAK_TtdkKan.SHRKNGKMEISAIHUGOU5)
    public C_HugouKbn getShrkngkmeisaihugou5() {
        return shrkngkmeisaihugou5;
    }

    public void setShrkngkmeisaihugou5(C_HugouKbn pShrkngkmeisaihugou5) {
        shrkngkmeisaihugou5 = pShrkngkmeisaihugou5;
    }

    private C_HugouKbn shrkngkmeisaihugou6;

    @Type(type="UserType_C_HugouKbn")
    @Column(name=GenIT_BAK_TtdkKan.SHRKNGKMEISAIHUGOU6)
    public C_HugouKbn getShrkngkmeisaihugou6() {
        return shrkngkmeisaihugou6;
    }

    public void setShrkngkmeisaihugou6(C_HugouKbn pShrkngkmeisaihugou6) {
        shrkngkmeisaihugou6 = pShrkngkmeisaihugou6;
    }

    private C_HugouKbn shrkngkmeisaihugou7;

    @Type(type="UserType_C_HugouKbn")
    @Column(name=GenIT_BAK_TtdkKan.SHRKNGKMEISAIHUGOU7)
    public C_HugouKbn getShrkngkmeisaihugou7() {
        return shrkngkmeisaihugou7;
    }

    public void setShrkngkmeisaihugou7(C_HugouKbn pShrkngkmeisaihugou7) {
        shrkngkmeisaihugou7 = pShrkngkmeisaihugou7;
    }

    private C_HugouKbn shrkngkmeisaihugou8;

    @Type(type="UserType_C_HugouKbn")
    @Column(name=GenIT_BAK_TtdkKan.SHRKNGKMEISAIHUGOU8)
    public C_HugouKbn getShrkngkmeisaihugou8() {
        return shrkngkmeisaihugou8;
    }

    public void setShrkngkmeisaihugou8(C_HugouKbn pShrkngkmeisaihugou8) {
        shrkngkmeisaihugou8 = pShrkngkmeisaihugou8;
    }

    private C_HugouKbn shrkngkmeisaihugou9;

    @Type(type="UserType_C_HugouKbn")
    @Column(name=GenIT_BAK_TtdkKan.SHRKNGKMEISAIHUGOU9)
    public C_HugouKbn getShrkngkmeisaihugou9() {
        return shrkngkmeisaihugou9;
    }

    public void setShrkngkmeisaihugou9(C_HugouKbn pShrkngkmeisaihugou9) {
        shrkngkmeisaihugou9 = pShrkngkmeisaihugou9;
    }

    private C_HugouKbn shrkngkmeisaihugou10;

    @Type(type="UserType_C_HugouKbn")
    @Column(name=GenIT_BAK_TtdkKan.SHRKNGKMEISAIHUGOU10)
    public C_HugouKbn getShrkngkmeisaihugou10() {
        return shrkngkmeisaihugou10;
    }

    public void setShrkngkmeisaihugou10(C_HugouKbn pShrkngkmeisaihugou10) {
        shrkngkmeisaihugou10 = pShrkngkmeisaihugou10;
    }

    private String documentid;

    @Column(name=GenIT_BAK_TtdkKan.DOCUMENTID)
    @MaxLength(max=24)
    @SingleByteStrings
    public String getDocumentid() {
        return documentid;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDocumentid(String pDocumentid) {
        documentid = pDocumentid;
    }

    private C_SksmongonKbn sksmongonkbn1;

    @Type(type="UserType_C_SksmongonKbn")
    @Column(name=GenIT_BAK_TtdkKan.SKSMONGONKBN1)
    public C_SksmongonKbn getSksmongonkbn1() {
        return sksmongonkbn1;
    }

    public void setSksmongonkbn1(C_SksmongonKbn pSksmongonkbn1) {
        sksmongonkbn1 = pSksmongonkbn1;
    }

    private C_SksmongonKbn sksmongonkbn2;

    @Type(type="UserType_C_SksmongonKbn")
    @Column(name=GenIT_BAK_TtdkKan.SKSMONGONKBN2)
    public C_SksmongonKbn getSksmongonkbn2() {
        return sksmongonkbn2;
    }

    public void setSksmongonkbn2(C_SksmongonKbn pSksmongonkbn2) {
        sksmongonkbn2 = pSksmongonkbn2;
    }

    private String toritugisyasyozokunm;

    @Column(name=GenIT_BAK_TtdkKan.TORITUGISYASYOZOKUNM)
    public String getToritugisyasyozokunm() {
        return toritugisyasyozokunm;
    }

    public void setToritugisyasyozokunm(String pToritugisyasyozokunm) {
        toritugisyasyozokunm = pToritugisyasyozokunm;
    }

    private String toritugisyakjncd;

    @Column(name=GenIT_BAK_TtdkKan.TORITUGISYAKJNCD)
    public String getToritugisyakjncd() {
        return toritugisyakjncd;
    }

    public void setToritugisyakjncd(String pToritugisyakjncd) {
        toritugisyakjncd = pToritugisyakjncd;
    }

    private String toritugisyanm;

    @Column(name=GenIT_BAK_TtdkKan.TORITUGISYANM)
    public String getToritugisyanm() {
        return toritugisyanm;
    }

    public void setToritugisyanm(String pToritugisyanm) {
        toritugisyanm = pToritugisyanm;
    }

    private Integer hozonKikan;

    @Column(name=GenIT_BAK_TtdkKan.HOZONKIKAN)
    public Integer getHozonKikan() {
        return hozonKikan;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHozonKikan(Integer pHozonKikan) {
        hozonKikan = pHozonKikan;
    }

    private String shrnaiyouhskmongon1;

    @Column(name=GenIT_BAK_TtdkKan.SHRNAIYOUHSKMONGON1)
    public String getShrnaiyouhskmongon1() {
        return shrnaiyouhskmongon1;
    }

    public void setShrnaiyouhskmongon1(String pShrnaiyouhskmongon1) {
        shrnaiyouhskmongon1 = pShrnaiyouhskmongon1;
    }

    private String shrnaiyouhskmongon2;

    @Column(name=GenIT_BAK_TtdkKan.SHRNAIYOUHSKMONGON2)
    public String getShrnaiyouhskmongon2() {
        return shrnaiyouhskmongon2;
    }

    public void setShrnaiyouhskmongon2(String pShrnaiyouhskmongon2) {
        shrnaiyouhskmongon2 = pShrnaiyouhskmongon2;
    }

    private C_YendthnkzeimuinfohskKbn yendthnkzeimuinfohskkbn;

    @Type(type="UserType_C_YendthnkzeimuinfohskKbn")
    @Column(name=GenIT_BAK_TtdkKan.YENDTHNKZEIMUINFOHSKKBN)
    public C_YendthnkzeimuinfohskKbn getYendthnkzeimuinfohskkbn() {
        return yendthnkzeimuinfohskkbn;
    }

    public void setYendthnkzeimuinfohskkbn(C_YendthnkzeimuinfohskKbn pYendthnkzeimuinfohskkbn) {
        yendthnkzeimuinfohskkbn = pYendthnkzeimuinfohskkbn;
    }

    private C_UmuKbn yuuyokkntyoukaumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_BAK_TtdkKan.YUUYOKKNTYOUKAUMU)
    public C_UmuKbn getYuuyokkntyoukaumu() {
        return yuuyokkntyoukaumu;
    }

    public void setYuuyokkntyoukaumu(C_UmuKbn pYuuyokkntyoukaumu) {
        yuuyokkntyoukaumu = pYuuyokkntyoukaumu;
    }

    private String tsintelno;

    @Column(name=GenIT_BAK_TtdkKan.TSINTELNO)
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    public String getTsintelno() {
        return tsintelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTsintelno(String pTsintelno) {
        tsintelno = pTsintelno;
    }

    private String dseisanshrttdknm;

    @Column(name=GenIT_BAK_TtdkKan.DSEISANSHRTTDKNM)
    public String getDseisanshrttdknm() {
        return dseisanshrttdknm;
    }

    public void setDseisanshrttdknm(String pDseisanshrttdknm) {
        dseisanshrttdknm = pDseisanshrttdknm;
    }

    private C_TrkKzkKbn trkkzkkbn1;

    @Type(type="UserType_C_TrkKzkKbn")
    @Column(name=GenIT_BAK_TtdkKan.TRKKZKKBN1)
    public C_TrkKzkKbn getTrkkzkkbn1() {
        return trkkzkkbn1;
    }

    public void setTrkkzkkbn1(C_TrkKzkKbn pTrkkzkkbn1) {
        trkkzkkbn1 = pTrkkzkkbn1;
    }

    private String trkkzknmkj1;

    @Column(name=GenIT_BAK_TtdkKan.TRKKZKNMKJ1)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getTrkkzknmkj1() {
        return trkkzknmkj1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTrkkzknmkj1(String pTrkkzknmkj1) {
        trkkzknmkj1 = pTrkkzknmkj1;
    }

    private C_Seibetu trkkzksei1;

    @Type(type="UserType_C_Seibetu")
    @Column(name=GenIT_BAK_TtdkKan.TRKKZKSEI1)
    public C_Seibetu getTrkkzksei1() {
        return trkkzksei1;
    }

    public void setTrkkzksei1(C_Seibetu pTrkkzksei1) {
        trkkzksei1 = pTrkkzksei1;
    }

    private BizDate trkkzkseiymd1;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_TtdkKan.TRKKZKSEIYMD1)
    @ValidDate
    public BizDate getTrkkzkseiymd1() {
        return trkkzkseiymd1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrkkzkseiymd1(BizDate pTrkkzkseiymd1) {
        trkkzkseiymd1 = pTrkkzkseiymd1;
    }

    private String trkkzkyno1;

    @Column(name=GenIT_BAK_TtdkKan.TRKKZKYNO1)
    @Length(length=7)
    @SingleByteStrings
    @Digit
    public String getTrkkzkyno1() {
        return trkkzkyno1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrkkzkyno1(String pTrkkzkyno1) {
        trkkzkyno1 = pTrkkzkyno1;
    }

    private String trkkzkadr1kj1;

    @Column(name=GenIT_BAK_TtdkKan.TRKKZKADR1KJ1)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTrkkzkadr1kj1() {
        return trkkzkadr1kj1;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTrkkzkadr1kj1(String pTrkkzkadr1kj1) {
        trkkzkadr1kj1 = pTrkkzkadr1kj1;
    }

    private String trkkzkadr2kj1;

    @Column(name=GenIT_BAK_TtdkKan.TRKKZKADR2KJ1)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTrkkzkadr2kj1() {
        return trkkzkadr2kj1;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTrkkzkadr2kj1(String pTrkkzkadr2kj1) {
        trkkzkadr2kj1 = pTrkkzkadr2kj1;
    }

    private String trkkzkadr3kj1;

    @Column(name=GenIT_BAK_TtdkKan.TRKKZKADR3KJ1)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTrkkzkadr3kj1() {
        return trkkzkadr3kj1;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTrkkzkadr3kj1(String pTrkkzkadr3kj1) {
        trkkzkadr3kj1 = pTrkkzkadr3kj1;
    }

    private String trkkzktelno1;

    @Column(name=GenIT_BAK_TtdkKan.TRKKZKTELNO1)
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    public String getTrkkzktelno1() {
        return trkkzktelno1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrkkzktelno1(String pTrkkzktelno1) {
        trkkzktelno1 = pTrkkzktelno1;
    }

    private String trkkzktelnomtrkhyouji1;

    @Column(name=GenIT_BAK_TtdkKan.TRKKZKTELNOMTRKHYOUJI1)
    public String getTrkkzktelnomtrkhyouji1() {
        return trkkzktelnomtrkhyouji1;
    }

    public void setTrkkzktelnomtrkhyouji1(String pTrkkzktelnomtrkhyouji1) {
        trkkzktelnomtrkhyouji1 = pTrkkzktelnomtrkhyouji1;
    }

    private C_Tdk trkkzktdk1;

    @Type(type="UserType_C_Tdk")
    @Column(name=GenIT_BAK_TtdkKan.TRKKZKTDK1)
    public C_Tdk getTrkkzktdk1() {
        return trkkzktdk1;
    }

    public void setTrkkzktdk1(C_Tdk pTrkkzktdk1) {
        trkkzktdk1 = pTrkkzktdk1;
    }

    private C_TrkKzkKbn trkkzkkbn2;

    @Type(type="UserType_C_TrkKzkKbn")
    @Column(name=GenIT_BAK_TtdkKan.TRKKZKKBN2)
    public C_TrkKzkKbn getTrkkzkkbn2() {
        return trkkzkkbn2;
    }

    public void setTrkkzkkbn2(C_TrkKzkKbn pTrkkzkkbn2) {
        trkkzkkbn2 = pTrkkzkkbn2;
    }

    private String trkkzknmkj2;

    @Column(name=GenIT_BAK_TtdkKan.TRKKZKNMKJ2)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getTrkkzknmkj2() {
        return trkkzknmkj2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTrkkzknmkj2(String pTrkkzknmkj2) {
        trkkzknmkj2 = pTrkkzknmkj2;
    }

    private C_Seibetu trkkzksei2;

    @Type(type="UserType_C_Seibetu")
    @Column(name=GenIT_BAK_TtdkKan.TRKKZKSEI2)
    public C_Seibetu getTrkkzksei2() {
        return trkkzksei2;
    }

    public void setTrkkzksei2(C_Seibetu pTrkkzksei2) {
        trkkzksei2 = pTrkkzksei2;
    }

    private BizDate trkkzkseiymd2;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_TtdkKan.TRKKZKSEIYMD2)
    @ValidDate
    public BizDate getTrkkzkseiymd2() {
        return trkkzkseiymd2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrkkzkseiymd2(BizDate pTrkkzkseiymd2) {
        trkkzkseiymd2 = pTrkkzkseiymd2;
    }

    private String trkkzkyno2;

    @Column(name=GenIT_BAK_TtdkKan.TRKKZKYNO2)
    @Length(length=7)
    @SingleByteStrings
    @Digit
    public String getTrkkzkyno2() {
        return trkkzkyno2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrkkzkyno2(String pTrkkzkyno2) {
        trkkzkyno2 = pTrkkzkyno2;
    }

    private String trkkzkadr1kj2;

    @Column(name=GenIT_BAK_TtdkKan.TRKKZKADR1KJ2)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTrkkzkadr1kj2() {
        return trkkzkadr1kj2;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTrkkzkadr1kj2(String pTrkkzkadr1kj2) {
        trkkzkadr1kj2 = pTrkkzkadr1kj2;
    }

    private String trkkzkadr2kj2;

    @Column(name=GenIT_BAK_TtdkKan.TRKKZKADR2KJ2)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTrkkzkadr2kj2() {
        return trkkzkadr2kj2;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTrkkzkadr2kj2(String pTrkkzkadr2kj2) {
        trkkzkadr2kj2 = pTrkkzkadr2kj2;
    }

    private String trkkzkadr3kj2;

    @Column(name=GenIT_BAK_TtdkKan.TRKKZKADR3KJ2)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTrkkzkadr3kj2() {
        return trkkzkadr3kj2;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTrkkzkadr3kj2(String pTrkkzkadr3kj2) {
        trkkzkadr3kj2 = pTrkkzkadr3kj2;
    }

    private String trkkzktelno2;

    @Column(name=GenIT_BAK_TtdkKan.TRKKZKTELNO2)
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    public String getTrkkzktelno2() {
        return trkkzktelno2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTrkkzktelno2(String pTrkkzktelno2) {
        trkkzktelno2 = pTrkkzktelno2;
    }

    private C_Tdk trkkzktdk2;

    @Type(type="UserType_C_Tdk")
    @Column(name=GenIT_BAK_TtdkKan.TRKKZKTDK2)
    public C_Tdk getTrkkzktdk2() {
        return trkkzktdk2;
    }

    public void setTrkkzktdk2(C_Tdk pTrkkzktdk2) {
        trkkzktdk2 = pTrkkzktdk2;
    }

    private String kykdairinmkj;

    @Column(name=GenIT_BAK_TtdkKan.KYKDAIRINMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getKykdairinmkj() {
        return kykdairinmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKykdairinmkj(String pKykdairinmkj) {
        kykdairinmkj = pKykdairinmkj;
    }

    private String kykomttutkbn;

    @Column(name=GenIT_BAK_TtdkKan.KYKOMTTUTKBN)
    public String getKykomttutkbn() {
        return kykomttutkbn;
    }

    public void setKykomttutkbn(String pKykomttutkbn) {
        kykomttutkbn = pKykomttutkbn;
    }

    private String kzkomttutkbn1;

    @Column(name=GenIT_BAK_TtdkKan.KZKOMTTUTKBN1)
    public String getKzkomttutkbn1() {
        return kzkomttutkbn1;
    }

    public void setKzkomttutkbn1(String pKzkomttutkbn1) {
        kzkomttutkbn1 = pKzkomttutkbn1;
    }

    private String kzkomttutkbn2;

    @Column(name=GenIT_BAK_TtdkKan.KZKOMTTUTKBN2)
    public String getKzkomttutkbn2() {
        return kzkomttutkbn2;
    }

    public void setKzkomttutkbn2(String pKzkomttutkbn2) {
        kzkomttutkbn2 = pKzkomttutkbn2;
    }

    private String hhkomttutkbn;

    @Column(name=GenIT_BAK_TtdkKan.HHKOMTTUTKBN)
    public String getHhkomttutkbn() {
        return hhkomttutkbn;
    }

    public void setHhkomttutkbn(String pHhkomttutkbn) {
        hhkomttutkbn = pHhkomttutkbn;
    }

    private String hhkdromttutkbn;

    @Column(name=GenIT_BAK_TtdkKan.HHKDROMTTUTKBN)
    public String getHhkdromttutkbn() {
        return hhkdromttutkbn;
    }

    public void setHhkdromttutkbn(String pHhkdromttutkbn) {
        hhkdromttutkbn = pHhkdromttutkbn;
    }

    private String kykdairiomttutkbn;

    @Column(name=GenIT_BAK_TtdkKan.KYKDAIRIOMTTUTKBN)
    public String getKykdairiomttutkbn() {
        return kykdairiomttutkbn;
    }

    public void setKykdairiomttutkbn(String pKykdairiomttutkbn) {
        kykdairiomttutkbn = pKykdairiomttutkbn;
    }

    private String kykurtutkbn;

    @Column(name=GenIT_BAK_TtdkKan.KYKURTUTKBN)
    public String getKykurtutkbn() {
        return kykurtutkbn;
    }

    public void setKykurtutkbn(String pKykurtutkbn) {
        kykurtutkbn = pKykurtutkbn;
    }

    private String kzkurtutkbn1;

    @Column(name=GenIT_BAK_TtdkKan.KZKURTUTKBN1)
    public String getKzkurtutkbn1() {
        return kzkurtutkbn1;
    }

    public void setKzkurtutkbn1(String pKzkurtutkbn1) {
        kzkurtutkbn1 = pKzkurtutkbn1;
    }

    private String kzkurtutkbn2;

    @Column(name=GenIT_BAK_TtdkKan.KZKURTUTKBN2)
    public String getKzkurtutkbn2() {
        return kzkurtutkbn2;
    }

    public void setKzkurtutkbn2(String pKzkurtutkbn2) {
        kzkurtutkbn2 = pKzkurtutkbn2;
    }

    private String hhkdrurtutkbn;

    @Column(name=GenIT_BAK_TtdkKan.HHKDRURTUTKBN)
    public String getHhkdrurtutkbn() {
        return hhkdrurtutkbn;
    }

    public void setHhkdrurtutkbn(String pHhkdrurtutkbn) {
        hhkdrurtutkbn = pHhkdrurtutkbn;
    }

    private String kykdairiurtutkbn;

    @Column(name=GenIT_BAK_TtdkKan.KYKDAIRIURTUTKBN)
    public String getKykdairiurtutkbn() {
        return kykdairiurtutkbn;
    }

    public void setKykdairiurtutkbn(String pKykdairiurtutkbn) {
        kykdairiurtutkbn = pKykdairiurtutkbn;
    }

    private String kykaistmsgkbn;

    @Column(name=GenIT_BAK_TtdkKan.KYKAISTMSGKBN)
    public String getKykaistmsgkbn() {
        return kykaistmsgkbn;
    }

    public void setKykaistmsgkbn(String pKykaistmsgkbn) {
        kykaistmsgkbn = pKykaistmsgkbn;
    }

    private String kzkaistmsgkbn1;

    @Column(name=GenIT_BAK_TtdkKan.KZKAISTMSGKBN1)
    public String getKzkaistmsgkbn1() {
        return kzkaistmsgkbn1;
    }

    public void setKzkaistmsgkbn1(String pKzkaistmsgkbn1) {
        kzkaistmsgkbn1 = pKzkaistmsgkbn1;
    }

    private String kzkaistmsgkbn2;

    @Column(name=GenIT_BAK_TtdkKan.KZKAISTMSGKBN2)
    public String getKzkaistmsgkbn2() {
        return kzkaistmsgkbn2;
    }

    public void setKzkaistmsgkbn2(String pKzkaistmsgkbn2) {
        kzkaistmsgkbn2 = pKzkaistmsgkbn2;
    }

    private String hhkaistmsgkbn;

    @Column(name=GenIT_BAK_TtdkKan.HHKAISTMSGKBN)
    public String getHhkaistmsgkbn() {
        return hhkaistmsgkbn;
    }

    public void setHhkaistmsgkbn(String pHhkaistmsgkbn) {
        hhkaistmsgkbn = pHhkaistmsgkbn;
    }

    private String hhkdraistmsgkbn;

    @Column(name=GenIT_BAK_TtdkKan.HHKDRAISTMSGKBN)
    public String getHhkdraistmsgkbn() {
        return hhkdraistmsgkbn;
    }

    public void setHhkdraistmsgkbn(String pHhkdraistmsgkbn) {
        hhkdraistmsgkbn = pHhkdraistmsgkbn;
    }

    private String kykdairiaistmsgkbn;

    @Column(name=GenIT_BAK_TtdkKan.KYKDAIRIAISTMSGKBN)
    public String getKykdairiaistmsgkbn() {
        return kykdairiaistmsgkbn;
    }

    public void setKykdairiaistmsgkbn(String pKykdairiaistmsgkbn) {
        kykdairiaistmsgkbn = pKykdairiaistmsgkbn;
    }

    private String sakujyokzknmkj;

    @Column(name=GenIT_BAK_TtdkKan.SAKUJYOKZKNMKJ)
    public String getSakujyokzknmkj() {
        return sakujyokzknmkj;
    }

    public void setSakujyokzknmkj(String pSakujyokzknmkj) {
        sakujyokzknmkj = pSakujyokzknmkj;
    }

    private String ttdknaiyoukbn;

    @Column(name=GenIT_BAK_TtdkKan.TTDKNAIYOUKBN)
    public String getTtdknaiyoukbn() {
        return ttdknaiyoukbn;
    }

    public void setTtdknaiyoukbn(String pTtdknaiyoukbn) {
        ttdknaiyoukbn = pTtdknaiyoukbn;
    }

    private String kzktaisyoukykkbn;

    @Column(name=GenIT_BAK_TtdkKan.KZKTAISYOUKYKKBN)
    public String getKzktaisyoukykkbn() {
        return kzktaisyoukykkbn;
    }

    public void setKzktaisyoukykkbn(String pKzktaisyoukykkbn) {
        kzktaisyoukykkbn = pKzktaisyoukykkbn;
    }

    private String hhkdrtaisyoukykkbn;

    @Column(name=GenIT_BAK_TtdkKan.HHKDRTAISYOUKYKKBN)
    public String getHhkdrtaisyoukykkbn() {
        return hhkdrtaisyoukykkbn;
    }

    public void setHhkdrtaisyoukykkbn(String pHhkdrtaisyoukykkbn) {
        hhkdrtaisyoukykkbn = pHhkdrtaisyoukykkbn;
    }

    private String kykdairitaisyoukykkbn;

    @Column(name=GenIT_BAK_TtdkKan.KYKDAIRITAISYOUKYKKBN)
    public String getKykdairitaisyoukykkbn() {
        return kykdairitaisyoukykkbn;
    }

    public void setKykdairitaisyoukykkbn(String pKykdairitaisyoukykkbn) {
        kykdairitaisyoukykkbn = pKykdairitaisyoukykkbn;
    }

    private String moshnkniymsgkbn1;

    @Column(name=GenIT_BAK_TtdkKan.MOSHNKNIYMSGKBN1)
    public String getMoshnkniymsgkbn1() {
        return moshnkniymsgkbn1;
    }

    public void setMoshnkniymsgkbn1(String pMoshnkniymsgkbn1) {
        moshnkniymsgkbn1 = pMoshnkniymsgkbn1;
    }

    private String kykmoshnkniymsg2;

    @Column(name=GenIT_BAK_TtdkKan.KYKMOSHNKNIYMSG2)
    public String getKykmoshnkniymsg2() {
        return kykmoshnkniymsg2;
    }

    public void setKykmoshnkniymsg2(String pKykmoshnkniymsg2) {
        kykmoshnkniymsg2 = pKykmoshnkniymsg2;
    }

    private String kzkmoshnkniymsg21;

    @Column(name=GenIT_BAK_TtdkKan.KZKMOSHNKNIYMSG21)
    public String getKzkmoshnkniymsg21() {
        return kzkmoshnkniymsg21;
    }

    public void setKzkmoshnkniymsg21(String pKzkmoshnkniymsg21) {
        kzkmoshnkniymsg21 = pKzkmoshnkniymsg21;
    }

    private String kzkmoshnkniymsg22;

    @Column(name=GenIT_BAK_TtdkKan.KZKMOSHNKNIYMSG22)
    public String getKzkmoshnkniymsg22() {
        return kzkmoshnkniymsg22;
    }

    public void setKzkmoshnkniymsg22(String pKzkmoshnkniymsg22) {
        kzkmoshnkniymsg22 = pKzkmoshnkniymsg22;
    }

    private String hhkdrmoshnkniymsg2;

    @Column(name=GenIT_BAK_TtdkKan.HHKDRMOSHNKNIYMSG2)
    public String getHhkdrmoshnkniymsg2() {
        return hhkdrmoshnkniymsg2;
    }

    public void setHhkdrmoshnkniymsg2(String pHhkdrmoshnkniymsg2) {
        hhkdrmoshnkniymsg2 = pHhkdrmoshnkniymsg2;
    }

    private String kykdairimoshnkniymsg2;

    @Column(name=GenIT_BAK_TtdkKan.KYKDAIRIMOSHNKNIYMSG2)
    public String getKykdairimoshnkniymsg2() {
        return kykdairimoshnkniymsg2;
    }

    public void setKykdairimoshnkniymsg2(String pKykdairimoshnkniymsg2) {
        kykdairimoshnkniymsg2 = pKykdairimoshnkniymsg2;
    }

    private String kykdrmsgkbn;

    @Column(name=GenIT_BAK_TtdkKan.KYKDRMSGKBN)
    public String getKykdrmsgkbn() {
        return kykdrmsgkbn;
    }

    public void setKykdrmsgkbn(String pKykdrmsgkbn) {
        kykdrmsgkbn = pKykdrmsgkbn;
    }

    private String kykhhkdrmsg;

    @Column(name=GenIT_BAK_TtdkKan.KYKHHKDRMSG)
    public String getKykhhkdrmsg() {
        return kykhhkdrmsg;
    }

    public void setKykhhkdrmsg(String pKykhhkdrmsg) {
        kykhhkdrmsg = pKykhhkdrmsg;
    }

    private String kzkhhkdrmsg1;

    @Column(name=GenIT_BAK_TtdkKan.KZKHHKDRMSG1)
    public String getKzkhhkdrmsg1() {
        return kzkhhkdrmsg1;
    }

    public void setKzkhhkdrmsg1(String pKzkhhkdrmsg1) {
        kzkhhkdrmsg1 = pKzkhhkdrmsg1;
    }

    private String kzkhhkdrmsg2;

    @Column(name=GenIT_BAK_TtdkKan.KZKHHKDRMSG2)
    public String getKzkhhkdrmsg2() {
        return kzkhhkdrmsg2;
    }

    public void setKzkhhkdrmsg2(String pKzkhhkdrmsg2) {
        kzkhhkdrmsg2 = pKzkhhkdrmsg2;
    }

    private String hhkdrnmkj;

    @Column(name=GenIT_BAK_TtdkKan.HHKDRNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhkdrnmkj() {
        return hhkdrnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhkdrnmkj(String pHhkdrnmkj) {
        hhkdrnmkj = pHhkdrnmkj;
    }

    private String duhubutumsg;

    @Column(name=GenIT_BAK_TtdkKan.DUHUBUTUMSG)
    public String getDuhubutumsg() {
        return duhubutumsg;
    }

    public void setDuhubutumsg(String pDuhubutumsg) {
        duhubutumsg = pDuhubutumsg;
    }

    private String duhubutumsg1;

    @Column(name=GenIT_BAK_TtdkKan.DUHUBUTUMSG1)
    public String getDuhubutumsg1() {
        return duhubutumsg1;
    }

    public void setDuhubutumsg1(String pDuhubutumsg1) {
        duhubutumsg1 = pDuhubutumsg1;
    }

    private String duhubutumsg2;

    @Column(name=GenIT_BAK_TtdkKan.DUHUBUTUMSG2)
    public String getDuhubutumsg2() {
        return duhubutumsg2;
    }

    public void setDuhubutumsg2(String pDuhubutumsg2) {
        duhubutumsg2 = pDuhubutumsg2;
    }

    private String duhubutumsg3;

    @Column(name=GenIT_BAK_TtdkKan.DUHUBUTUMSG3)
    public String getDuhubutumsg3() {
        return duhubutumsg3;
    }

    public void setDuhubutumsg3(String pDuhubutumsg3) {
        duhubutumsg3 = pDuhubutumsg3;
    }

    private String duhubutumsg4;

    @Column(name=GenIT_BAK_TtdkKan.DUHUBUTUMSG4)
    public String getDuhubutumsg4() {
        return duhubutumsg4;
    }

    public void setDuhubutumsg4(String pDuhubutumsg4) {
        duhubutumsg4 = pDuhubutumsg4;
    }

    private String duhubutumsg5;

    @Column(name=GenIT_BAK_TtdkKan.DUHUBUTUMSG5)
    public String getDuhubutumsg5() {
        return duhubutumsg5;
    }

    public void setDuhubutumsg5(String pDuhubutumsg5) {
        duhubutumsg5 = pDuhubutumsg5;
    }

    private String duhubutumsg6;

    @Column(name=GenIT_BAK_TtdkKan.DUHUBUTUMSG6)
    public String getDuhubutumsg6() {
        return duhubutumsg6;
    }

    public void setDuhubutumsg6(String pDuhubutumsg6) {
        duhubutumsg6 = pDuhubutumsg6;
    }

    private String duhubutumsg7;

    @Column(name=GenIT_BAK_TtdkKan.DUHUBUTUMSG7)
    public String getDuhubutumsg7() {
        return duhubutumsg7;
    }

    public void setDuhubutumsg7(String pDuhubutumsg7) {
        duhubutumsg7 = pDuhubutumsg7;
    }

    private String kykigaidhbtmsg1;

    @Column(name=GenIT_BAK_TtdkKan.KYKIGAIDHBTMSG1)
    public String getKykigaidhbtmsg1() {
        return kykigaidhbtmsg1;
    }

    public void setKykigaidhbtmsg1(String pKykigaidhbtmsg1) {
        kykigaidhbtmsg1 = pKykigaidhbtmsg1;
    }

    private String kykigaidhbtmsg2;

    @Column(name=GenIT_BAK_TtdkKan.KYKIGAIDHBTMSG2)
    public String getKykigaidhbtmsg2() {
        return kykigaidhbtmsg2;
    }

    public void setKykigaidhbtmsg2(String pKykigaidhbtmsg2) {
        kykigaidhbtmsg2 = pKykigaidhbtmsg2;
    }

    private String kykigaidhbtmsg3;

    @Column(name=GenIT_BAK_TtdkKan.KYKIGAIDHBTMSG3)
    public String getKykigaidhbtmsg3() {
        return kykigaidhbtmsg3;
    }

    public void setKykigaidhbtmsg3(String pKykigaidhbtmsg3) {
        kykigaidhbtmsg3 = pKykigaidhbtmsg3;
    }

    private String kykigaidhbtmsg4;

    @Column(name=GenIT_BAK_TtdkKan.KYKIGAIDHBTMSG4)
    public String getKykigaidhbtmsg4() {
        return kykigaidhbtmsg4;
    }

    public void setKykigaidhbtmsg4(String pKykigaidhbtmsg4) {
        kykigaidhbtmsg4 = pKykigaidhbtmsg4;
    }

    private String kiyakuhunyuuhyouji;

    @Column(name=GenIT_BAK_TtdkKan.KIYAKUHUNYUUHYOUJI)
    public String getKiyakuhunyuuhyouji() {
        return kiyakuhunyuuhyouji;
    }

    public void setKiyakuhunyuuhyouji(String pKiyakuhunyuuhyouji) {
        kiyakuhunyuuhyouji = pKiyakuhunyuuhyouji;
    }

    private String yakkankiyakuhunyuuhyouji;

    @Column(name=GenIT_BAK_TtdkKan.YAKKANKIYAKUHUNYUUHYOUJI)
    public String getYakkankiyakuhunyuuhyouji() {
        return yakkankiyakuhunyuuhyouji;
    }

    public void setYakkankiyakuhunyuuhyouji(String pYakkankiyakuhunyuuhyouji) {
        yakkankiyakuhunyuuhyouji = pYakkankiyakuhunyuuhyouji;
    }

    private String kyktrktrshuunyuuhyouji;

    @Column(name=GenIT_BAK_TtdkKan.KYKTRKTRSHUUNYUUHYOUJI)
    public String getKyktrktrshuunyuuhyouji() {
        return kyktrktrshuunyuuhyouji;
    }

    public void setKyktrktrshuunyuuhyouji(String pKyktrktrshuunyuuhyouji) {
        kyktrktrshuunyuuhyouji = pKyktrktrshuunyuuhyouji;
    }

    private String kzktrktrshuunyuuhyouji1;

    @Column(name=GenIT_BAK_TtdkKan.KZKTRKTRSHUUNYUUHYOUJI1)
    public String getKzktrktrshuunyuuhyouji1() {
        return kzktrktrshuunyuuhyouji1;
    }

    public void setKzktrktrshuunyuuhyouji1(String pKzktrktrshuunyuuhyouji1) {
        kzktrktrshuunyuuhyouji1 = pKzktrktrshuunyuuhyouji1;
    }

    private String kzktrktrshuunyuuhyouji2;

    @Column(name=GenIT_BAK_TtdkKan.KZKTRKTRSHUUNYUUHYOUJI2)
    public String getKzktrktrshuunyuuhyouji2() {
        return kzktrktrshuunyuuhyouji2;
    }

    public void setKzktrktrshuunyuuhyouji2(String pKzktrktrshuunyuuhyouji2) {
        kzktrktrshuunyuuhyouji2 = pKzktrktrshuunyuuhyouji2;
    }

    private String kykdrhuunyuuhyouji;

    @Column(name=GenIT_BAK_TtdkKan.KYKDRHUUNYUUHYOUJI)
    public String getKykdrhuunyuuhyouji() {
        return kykdrhuunyuuhyouji;
    }

    public void setKykdrhuunyuuhyouji(String pKykdrhuunyuuhyouji) {
        kykdrhuunyuuhyouji = pKykdrhuunyuuhyouji;
    }

    private String hhkdrhuunyuuhyouji;

    @Column(name=GenIT_BAK_TtdkKan.HHKDRHUUNYUUHYOUJI)
    public String getHhkdrhuunyuuhyouji() {
        return hhkdrhuunyuuhyouji;
    }

    public void setHhkdrhuunyuuhyouji(String pHhkdrhuunyuuhyouji) {
        hhkdrhuunyuuhyouji = pHhkdrhuunyuuhyouji;
    }

    private String kykdairinmkj2;

    @Column(name=GenIT_BAK_TtdkKan.KYKDAIRINMKJ2)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getKykdairinmkj2() {
        return kykdairinmkj2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKykdairinmkj2(String pKykdairinmkj2) {
        kykdairinmkj2 = pKykdairinmkj2;
    }

    private BizDate kykdrseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_TtdkKan.KYKDRSEIYMD)
    @ValidDate
    public BizDate getKykdrseiymd() {
        return kykdrseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykdrseiymd(BizDate pKykdrseiymd) {
        kykdrseiymd = pKykdrseiymd;
    }

    private String kykdryno;

    @Column(name=GenIT_BAK_TtdkKan.KYKDRYNO)
    @Length(length=7)
    @Digit
    public String getKykdryno() {
        return kykdryno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykdryno(String pKykdryno) {
        kykdryno = pKykdryno;
    }

    private String kykdradr1kj;

    @Column(name=GenIT_BAK_TtdkKan.KYKDRADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getKykdradr1kj() {
        return kykdradr1kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKykdradr1kj(String pKykdradr1kj) {
        kykdradr1kj = pKykdradr1kj;
    }

    private String kykdradr2kj;

    @Column(name=GenIT_BAK_TtdkKan.KYKDRADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getKykdradr2kj() {
        return kykdradr2kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKykdradr2kj(String pKykdradr2kj) {
        kykdradr2kj = pKykdradr2kj;
    }

    private String kykdradr3kj;

    @Column(name=GenIT_BAK_TtdkKan.KYKDRADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getKykdradr3kj() {
        return kykdradr3kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKykdradr3kj(String pKykdradr3kj) {
        kykdradr3kj = pKykdradr3kj;
    }

    private String kykdrtelno;

    @Column(name=GenIT_BAK_TtdkKan.KYKDRTELNO)
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    public String getKykdrtelno() {
        return kykdrtelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKykdrtelno(String pKykdrtelno) {
        kykdrtelno = pKykdrtelno;
    }

    private String hhkdrnmkj2;

    @Column(name=GenIT_BAK_TtdkKan.HHKDRNMKJ2)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhkdrnmkj2() {
        return hhkdrnmkj2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhkdrnmkj2(String pHhkdrnmkj2) {
        hhkdrnmkj2 = pHhkdrnmkj2;
    }

    private BizDate hhkdrseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_TtdkKan.HHKDRSEIYMD)
    @ValidDate
    public BizDate getHhkdrseiymd() {
        return hhkdrseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhkdrseiymd(BizDate pHhkdrseiymd) {
        hhkdrseiymd = pHhkdrseiymd;
    }

    private String hhkdryno;

    @Column(name=GenIT_BAK_TtdkKan.HHKDRYNO)
    public String getHhkdryno() {
        return hhkdryno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhkdryno(String pHhkdryno) {
        hhkdryno = pHhkdryno;
    }

    private String hhkdradr1kj;

    @Column(name=GenIT_BAK_TtdkKan.HHKDRADR1KJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhkdradr1kj() {
        return hhkdradr1kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setHhkdradr1kj(String pHhkdradr1kj) {
        hhkdradr1kj = pHhkdradr1kj;
    }

    private String hhkdradr2kj;

    @Column(name=GenIT_BAK_TtdkKan.HHKDRADR2KJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhkdradr2kj() {
        return hhkdradr2kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setHhkdradr2kj(String pHhkdradr2kj) {
        hhkdradr2kj = pHhkdradr2kj;
    }

    private String hhkdradr3kj;

    @Column(name=GenIT_BAK_TtdkKan.HHKDRADR3KJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getHhkdradr3kj() {
        return hhkdradr3kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setHhkdradr3kj(String pHhkdradr3kj) {
        hhkdradr3kj = pHhkdradr3kj;
    }

    private String hhkdrtelno;

    @Column(name=GenIT_BAK_TtdkKan.HHKDRTELNO)
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    public String getHhkdrtelno() {
        return hhkdrtelno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhkdrtelno(String pHhkdrtelno) {
        hhkdrtelno = pHhkdrtelno;
    }

    private String hhkdrtelnomtrkhyouji;

    @Column(name=GenIT_BAK_TtdkKan.HHKDRTELNOMTRKHYOUJI)
    public String getHhkdrtelnomtrkhyouji() {
        return hhkdrtelnomtrkhyouji;
    }

    public void setHhkdrtelnomtrkhyouji(String pHhkdrtelnomtrkhyouji) {
        hhkdrtelnomtrkhyouji = pHhkdrtelnomtrkhyouji;
    }

    private String khsyono2;

    @Column(name=GenIT_BAK_TtdkKan.KHSYONO2)
    public String getKhsyono2() {
        return khsyono2;
    }

    public void setKhsyono2(String pKhsyono2) {
        khsyono2 = pKhsyono2;
    }

    private String khsyono3;

    @Column(name=GenIT_BAK_TtdkKan.KHSYONO3)
    public String getKhsyono3() {
        return khsyono3;
    }

    public void setKhsyono3(String pKhsyono3) {
        khsyono3 = pKhsyono3;
    }

    private String khsyono4;

    @Column(name=GenIT_BAK_TtdkKan.KHSYONO4)
    public String getKhsyono4() {
        return khsyono4;
    }

    public void setKhsyono4(String pKhsyono4) {
        khsyono4 = pKhsyono4;
    }

    private String khsyono5;

    @Column(name=GenIT_BAK_TtdkKan.KHSYONO5)
    public String getKhsyono5() {
        return khsyono5;
    }

    public void setKhsyono5(String pKhsyono5) {
        khsyono5 = pKhsyono5;
    }

    private String khsyono6;

    @Column(name=GenIT_BAK_TtdkKan.KHSYONO6)
    public String getKhsyono6() {
        return khsyono6;
    }

    public void setKhsyono6(String pKhsyono6) {
        khsyono6 = pKhsyono6;
    }

    private String khsyono7;

    @Column(name=GenIT_BAK_TtdkKan.KHSYONO7)
    public String getKhsyono7() {
        return khsyono7;
    }

    public void setKhsyono7(String pKhsyono7) {
        khsyono7 = pKhsyono7;
    }

    private String khsyono8;

    @Column(name=GenIT_BAK_TtdkKan.KHSYONO8)
    public String getKhsyono8() {
        return khsyono8;
    }

    public void setKhsyono8(String pKhsyono8) {
        khsyono8 = pKhsyono8;
    }

    private String khsyono9;

    @Column(name=GenIT_BAK_TtdkKan.KHSYONO9)
    public String getKhsyono9() {
        return khsyono9;
    }

    public void setKhsyono9(String pKhsyono9) {
        khsyono9 = pKhsyono9;
    }

    private String khsyono10;

    @Column(name=GenIT_BAK_TtdkKan.KHSYONO10)
    public String getKhsyono10() {
        return khsyono10;
    }

    public void setKhsyono10(String pKhsyono10) {
        khsyono10 = pKhsyono10;
    }

    private String khmosno1;

    @Column(name=GenIT_BAK_TtdkKan.KHMOSNO1)
    public String getKhmosno1() {
        return khmosno1;
    }

    public void setKhmosno1(String pKhmosno1) {
        khmosno1 = pKhmosno1;
    }

    private String khmosno2;

    @Column(name=GenIT_BAK_TtdkKan.KHMOSNO2)
    public String getKhmosno2() {
        return khmosno2;
    }

    public void setKhmosno2(String pKhmosno2) {
        khmosno2 = pKhmosno2;
    }

    private String khmosno3;

    @Column(name=GenIT_BAK_TtdkKan.KHMOSNO3)
    public String getKhmosno3() {
        return khmosno3;
    }

    public void setKhmosno3(String pKhmosno3) {
        khmosno3 = pKhmosno3;
    }

    private String khmosno4;

    @Column(name=GenIT_BAK_TtdkKan.KHMOSNO4)
    public String getKhmosno4() {
        return khmosno4;
    }

    public void setKhmosno4(String pKhmosno4) {
        khmosno4 = pKhmosno4;
    }

    private String khmosno5;

    @Column(name=GenIT_BAK_TtdkKan.KHMOSNO5)
    public String getKhmosno5() {
        return khmosno5;
    }

    public void setKhmosno5(String pKhmosno5) {
        khmosno5 = pKhmosno5;
    }

    private String khmosno6;

    @Column(name=GenIT_BAK_TtdkKan.KHMOSNO6)
    public String getKhmosno6() {
        return khmosno6;
    }

    public void setKhmosno6(String pKhmosno6) {
        khmosno6 = pKhmosno6;
    }

    private String khmosno7;

    @Column(name=GenIT_BAK_TtdkKan.KHMOSNO7)
    public String getKhmosno7() {
        return khmosno7;
    }

    public void setKhmosno7(String pKhmosno7) {
        khmosno7 = pKhmosno7;
    }

    private String khmosno8;

    @Column(name=GenIT_BAK_TtdkKan.KHMOSNO8)
    public String getKhmosno8() {
        return khmosno8;
    }

    public void setKhmosno8(String pKhmosno8) {
        khmosno8 = pKhmosno8;
    }

    private String khmosno9;

    @Column(name=GenIT_BAK_TtdkKan.KHMOSNO9)
    public String getKhmosno9() {
        return khmosno9;
    }

    public void setKhmosno9(String pKhmosno9) {
        khmosno9 = pKhmosno9;
    }

    private String khmosno10;

    @Column(name=GenIT_BAK_TtdkKan.KHMOSNO10)
    public String getKhmosno10() {
        return khmosno10;
    }

    public void setKhmosno10(String pKhmosno10) {
        khmosno10 = pKhmosno10;
    }

    private String hnsnhutouhuunyuuhyouji;

    @Column(name=GenIT_BAK_TtdkKan.HNSNHUTOUHUUNYUUHYOUJI)
    public String getHnsnhutouhuunyuuhyouji() {
        return hnsnhutouhuunyuuhyouji;
    }

    public void setHnsnhutouhuunyuuhyouji(String pHnsnhutouhuunyuuhyouji) {
        hnsnhutouhuunyuuhyouji = pHnsnhutouhuunyuuhyouji;
    }
}