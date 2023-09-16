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
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_InsizeiShryouhiKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SyoukenUktKbn;
import yuyu.def.classification.C_SyoukenUktMidasiKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TokusyuSyoriNaiyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YakkanJyuryouKbn;
import yuyu.def.db.entity.IT_BAK_HokenSyouken;
import yuyu.def.db.id.PKIT_BAK_HokenSyouken;
import yuyu.def.db.meta.GenQIT_BAK_HokenSyouken;
import yuyu.def.db.meta.QIT_BAK_HokenSyouken;
import yuyu.def.db.type.UserType_C_AisyoumeiKbn;
import yuyu.def.db.type.UserType_C_Channelcd;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_InsizeiShryouhiKbn;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_SinsaihkKbn;
import yuyu.def.db.type.UserType_C_SyoukenUktKbn;
import yuyu.def.db.type.UserType_C_SyoukenUktMidasiKbn;
import yuyu.def.db.type.UserType_C_SyoukensaihkKbn;
import yuyu.def.db.type.UserType_C_TantouCdKbn;
import yuyu.def.db.type.UserType_C_TokusyuSyoriNaiyouKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YakkanJyuryouKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 保険証券バックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_HokenSyouken} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_HokenSyouken}</td><td colspan="3">保険証券バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_HokenSyouken ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_HokenSyouken ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_HokenSyouken ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">{@link PKIT_BAK_HokenSyouken ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSinsaihkkbn sinsaihkkbn}</td><td>新規再発行区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SinsaihkKbn}</td></tr>
 *  <tr><td>{@link #getSyoukensaihkkbn syoukensaihkkbn}</td><td>証券再発行区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoukensaihkKbn}</td></tr>
 *  <tr><td>{@link #getInsizeishryouhikbn insizeishryouhikbn}</td><td>印紙税支払要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_InsizeiShryouhiKbn}</td></tr>
 *  <tr><td>{@link #getHassoukbn hassoukbn}</td><td>発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HassouKbn}</td></tr>
 *  <tr><td>{@link #getKoujyosyoumeiumukbn koujyosyoumeiumukbn}</td><td>控除証明書有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSuiihyouumukbn suiihyouumukbn}</td><td>推移表有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKanryoutuutiumukbn kanryoutuutiumukbn}</td><td>完了通知有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getStdrsktirasidouhuukbn stdrsktirasidouhuukbn}</td><td>被保険者代理人チラシ同封区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getDstirasidouhuukbn dstirasidouhuukbn}</td><td>ＤＳチラシ同封区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getAisyoumeikbn aisyoumeikbn}</td><td>愛称名区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AisyoumeiKbn}</td></tr>
 *  <tr><td>{@link #getSyotnshuyoupostumukbn syotnshuyoupostumukbn}</td><td>証券転送不要郵便有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHyoujiranhidarimsgcd1 hyoujiranhidarimsgcd1}</td><td>表示欄左メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranhidarimsgcd2 hyoujiranhidarimsgcd2}</td><td>表示欄左メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranhidarimsgcd3 hyoujiranhidarimsgcd3}</td><td>表示欄左メッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranhidarimsgcd4 hyoujiranhidarimsgcd4}</td><td>表示欄左メッセージコード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranhidarimsgcd5 hyoujiranhidarimsgcd5}</td><td>表示欄左メッセージコード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranhidarimsgcd6 hyoujiranhidarimsgcd6}</td><td>表示欄左メッセージコード６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranhidarimsgcd7 hyoujiranhidarimsgcd7}</td><td>表示欄左メッセージコード７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranhidarimsgcd8 hyoujiranhidarimsgcd8}</td><td>表示欄左メッセージコード８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranhidarimsgcd9 hyoujiranhidarimsgcd9}</td><td>表示欄左メッセージコード９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranhidarimsgcd10 hyoujiranhidarimsgcd10}</td><td>表示欄左メッセージコード１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranhidarimsgcd11 hyoujiranhidarimsgcd11}</td><td>表示欄左メッセージコード１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranhidarimsgcd12 hyoujiranhidarimsgcd12}</td><td>表示欄左メッセージコード１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranhidarimsgcd13 hyoujiranhidarimsgcd13}</td><td>表示欄左メッセージコード１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranhidarimsgcd14 hyoujiranhidarimsgcd14}</td><td>表示欄左メッセージコード１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranhidarimsgcd15 hyoujiranhidarimsgcd15}</td><td>表示欄左メッセージコード１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranhidarimsgcd16 hyoujiranhidarimsgcd16}</td><td>表示欄左メッセージコード１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranhidarimsgcd17 hyoujiranhidarimsgcd17}</td><td>表示欄左メッセージコード１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranhidarimsgcd18 hyoujiranhidarimsgcd18}</td><td>表示欄左メッセージコード１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranhidarimsgcd19 hyoujiranhidarimsgcd19}</td><td>表示欄左メッセージコード１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranhidarimsgcd20 hyoujiranhidarimsgcd20}</td><td>表示欄左メッセージコード２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranmigiimsgcd1 hyoujiranmigiimsgcd1}</td><td>表示欄右メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranmigiimsgcd2 hyoujiranmigiimsgcd2}</td><td>表示欄右メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranmigiimsgcd3 hyoujiranmigiimsgcd3}</td><td>表示欄右メッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranmigiimsgcd4 hyoujiranmigiimsgcd4}</td><td>表示欄右メッセージコード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranmigiimsgcd5 hyoujiranmigiimsgcd5}</td><td>表示欄右メッセージコード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranmigiimsgcd6 hyoujiranmigiimsgcd6}</td><td>表示欄右メッセージコード６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranmigiimsgcd7 hyoujiranmigiimsgcd7}</td><td>表示欄右メッセージコード７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranmigiimsgcd8 hyoujiranmigiimsgcd8}</td><td>表示欄右メッセージコード８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranmigiimsgcd9 hyoujiranmigiimsgcd9}</td><td>表示欄右メッセージコード９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranmigiimsgcd10 hyoujiranmigiimsgcd10}</td><td>表示欄右メッセージコード１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranmigiimsgcd11 hyoujiranmigiimsgcd11}</td><td>表示欄右メッセージコード１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranmigiimsgcd12 hyoujiranmigiimsgcd12}</td><td>表示欄右メッセージコード１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranmigiimsgcd13 hyoujiranmigiimsgcd13}</td><td>表示欄右メッセージコード１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranmigiimsgcd14 hyoujiranmigiimsgcd14}</td><td>表示欄右メッセージコード１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranmigiimsgcd15 hyoujiranmigiimsgcd15}</td><td>表示欄右メッセージコード１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranmigiimsgcd16 hyoujiranmigiimsgcd16}</td><td>表示欄右メッセージコード１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranmigiimsgcd17 hyoujiranmigiimsgcd17}</td><td>表示欄右メッセージコード１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranmigiimsgcd18 hyoujiranmigiimsgcd18}</td><td>表示欄右メッセージコード１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranmigiimsgcd19 hyoujiranmigiimsgcd19}</td><td>表示欄右メッセージコード１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiranmigiimsgcd20 hyoujiranmigiimsgcd20}</td><td>表示欄右メッセージコード２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujiransknnkaisiymd hyoujiransknnkaisiymd}</td><td>表示欄責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHyoujiranyoteiriritu hyoujiranyoteiriritu}</td><td>表示欄予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHyoujiransjkkktusirrt hyoujiransjkkktusirrt}</td><td>表示欄市場価格調整用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHknsyukigou hknsyukigou}</td><td>保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyohakkouymd syohakkouymd}</td><td>証券発行年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHanbainm hanbainm}</td><td>販売名称</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeisikihknnm seisikihknnm}</td><td>正式保険名称</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKouryokukaisiymd kouryokukaisiymd}</td><td>効力開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkjkhukakbn kyknmkjkhukakbn}</td><td>契約者名漢字化不可区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KjkhukaKbn}</td></tr>
 *  <tr><td>{@link #getHhknnmkj hhknnmkj}</td><td>被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkjkhukakbn hhknnmkjkhukakbn}</td><td>被保険者名漢字化不可区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KjkhukaKbn}</td></tr>
 *  <tr><td>{@link #getHhknseiymd hhknseiymd}</td><td>被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHhknsei hhknsei}</td><td>被保険者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hhknsei}</td></tr>
 *  <tr><td>{@link #getHhknnen hhknnen}</td><td>被保険者年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyoukenuktmidasikbn1 syoukenuktmidasikbn1}</td><td>（証券）受取人見出し区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoukenUktMidasiKbn}</td></tr>
 *  <tr><td>{@link #getSyoukenuktkbn1 syoukenuktkbn1}</td><td>（証券）受取人区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoukenUktKbn}</td></tr>
 *  <tr><td>{@link #getSyoukenuktnm1 syoukenuktnm1}</td><td>（証券）受取人名１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoukenuktbnwari1 syoukenuktbnwari1}</td><td>（証券）受取人分割割合１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSyoukenuktmidasikbn2 syoukenuktmidasikbn2}</td><td>（証券）受取人見出し区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoukenUktMidasiKbn}</td></tr>
 *  <tr><td>{@link #getSyoukenuktkbn2 syoukenuktkbn2}</td><td>（証券）受取人区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoukenUktKbn}</td></tr>
 *  <tr><td>{@link #getSyoukenuktnm2 syoukenuktnm2}</td><td>（証券）受取人名２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoukenuktbnwari2 syoukenuktbnwari2}</td><td>（証券）受取人分割割合２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSyoukenuktmidasikbn3 syoukenuktmidasikbn3}</td><td>（証券）受取人見出し区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoukenUktMidasiKbn}</td></tr>
 *  <tr><td>{@link #getSyoukenuktkbn3 syoukenuktkbn3}</td><td>（証券）受取人区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoukenUktKbn}</td></tr>
 *  <tr><td>{@link #getSyoukenuktnm3 syoukenuktnm3}</td><td>（証券）受取人名３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoukenuktbnwari3 syoukenuktbnwari3}</td><td>（証券）受取人分割割合３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSyoukenuktmidasikbn4 syoukenuktmidasikbn4}</td><td>（証券）受取人見出し区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoukenUktMidasiKbn}</td></tr>
 *  <tr><td>{@link #getSyoukenuktkbn4 syoukenuktkbn4}</td><td>（証券）受取人区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoukenUktKbn}</td></tr>
 *  <tr><td>{@link #getSyoukenuktnm4 syoukenuktnm4}</td><td>（証券）受取人名４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoukenuktbnwari4 syoukenuktbnwari4}</td><td>（証券）受取人分割割合４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSyoukenuktmidasikbn5 syoukenuktmidasikbn5}</td><td>（証券）受取人見出し区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoukenUktMidasiKbn}</td></tr>
 *  <tr><td>{@link #getSyoukenuktkbn5 syoukenuktkbn5}</td><td>（証券）受取人区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoukenUktKbn}</td></tr>
 *  <tr><td>{@link #getSyoukenuktnm5 syoukenuktnm5}</td><td>（証券）受取人名５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoukenuktbnwari5 syoukenuktbnwari5}</td><td>（証券）受取人分割割合５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSyoukenuktmidasikbn6 syoukenuktmidasikbn6}</td><td>（証券）受取人見出し区分６</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoukenUktMidasiKbn}</td></tr>
 *  <tr><td>{@link #getSyoukenuktkbn6 syoukenuktkbn6}</td><td>（証券）受取人区分６</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoukenUktKbn}</td></tr>
 *  <tr><td>{@link #getSyoukenuktnm6 syoukenuktnm6}</td><td>（証券）受取人名６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoukenuktbnwari6 syoukenuktbnwari6}</td><td>（証券）受取人分割割合６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSyoukenuktmidasikbn7 syoukenuktmidasikbn7}</td><td>（証券）受取人見出し区分７</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoukenUktMidasiKbn}</td></tr>
 *  <tr><td>{@link #getSyoukenuktkbn7 syoukenuktkbn7}</td><td>（証券）受取人区分７</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoukenUktKbn}</td></tr>
 *  <tr><td>{@link #getSyoukenuktnm7 syoukenuktnm7}</td><td>（証券）受取人名７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoukenuktbnwari7 syoukenuktbnwari7}</td><td>（証券）受取人分割割合７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSyoukenuktmidasikbn8 syoukenuktmidasikbn8}</td><td>（証券）受取人見出し区分８</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoukenUktMidasiKbn}</td></tr>
 *  <tr><td>{@link #getSyoukenuktkbn8 syoukenuktkbn8}</td><td>（証券）受取人区分８</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoukenUktKbn}</td></tr>
 *  <tr><td>{@link #getSyoukenuktnm8 syoukenuktnm8}</td><td>（証券）受取人名８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoukenuktbnwari8 syoukenuktbnwari8}</td><td>（証券）受取人分割割合８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSyoukenuktmidasikbn9 syoukenuktmidasikbn9}</td><td>（証券）受取人見出し区分９</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoukenUktMidasiKbn}</td></tr>
 *  <tr><td>{@link #getSyoukenuktkbn9 syoukenuktkbn9}</td><td>（証券）受取人区分９</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoukenUktKbn}</td></tr>
 *  <tr><td>{@link #getSyoukenuktnm9 syoukenuktnm9}</td><td>（証券）受取人名９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoukenuktbnwari9 syoukenuktbnwari9}</td><td>（証券）受取人分割割合９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSyoukenuktmidasikbn10 syoukenuktmidasikbn10}</td><td>（証券）受取人見出し区分１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoukenUktMidasiKbn}</td></tr>
 *  <tr><td>{@link #getSyoukenuktkbn10 syoukenuktkbn10}</td><td>（証券）受取人区分１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoukenUktKbn}</td></tr>
 *  <tr><td>{@link #getSyoukenuktnm10 syoukenuktnm10}</td><td>（証券）受取人名１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoukenuktbnwari10 syoukenuktbnwari10}</td><td>（証券）受取人分割割合１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getPmsgcd1 pmsgcd1}</td><td>保険料メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPmsgcd2 pmsgcd2}</td><td>保険料メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPmsgcd3 pmsgcd3}</td><td>保険料メッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPtuukatype ptuukatype}</td><td>保険料通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getHokenryou hokenryou}</td><td>保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getPtuuka ptuuka}</td><td>保険料通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPtokuyakumsgcd ptokuyakumsgcd}</td><td>保険料特約メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getPhrkkknmidasikbn phrkkknmidasikbn}</td><td>保険料払込期間見出し区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkkknmsgkbn hrkkknmsgkbn}</td><td>払込期間メッセージ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkkaisuumsgkbn hrkkaisuumsgkbn}</td><td>払込回数メッセージ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkkitukimsgkbn hrkkitukimsgkbn}</td><td>払込期月メッセージ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHrkhouhoumsgkbn hrkhouhoumsgkbn}</td><td>払込方法メッセージ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkykrenban1 syukyktkykrenban1}</td><td>主契約特約連番１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyukyktkykmsgkbn1 syukyktkykmsgkbn1}</td><td>主契約特約メッセージ区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkyksmsgkbn1 syukyktkyksmsgkbn1}</td><td>主契約特約保険金額メッセージ区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkykhknkknmsgkbn1 syukyktkykhknkknmsgkbn1}</td><td>主契約特約保険期間メッセージ区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkykstuukatype1 syukyktkykstuukatype1}</td><td>主契約特約保険金額通貨タイプ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSyukyktkykhknkngk1 syukyktkykhknkngk1}</td><td>主契約特約保険金額１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyukyktkykdai1hknkkn1 syukyktkykdai1hknkkn1}</td><td>主契約特約第１保険期間１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyukyktkykdai2hknkkn1 syukyktkykdai2hknkkn1}</td><td>主契約特約第２保険期間１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyutkdai1hknkknymdto1 syutkdai1hknkknymdto1}</td><td>主契約特約第１保険期間年月日（至）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyutkdai2hknkknymdto1 syutkdai2hknkknymdto1}</td><td>主契約特約第２保険期間年月日（至）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyukyktkykrenban2 syukyktkykrenban2}</td><td>主契約特約連番２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyukyktkykmsgkbn2 syukyktkykmsgkbn2}</td><td>主契約特約メッセージ区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkyksmsgkbn2 syukyktkyksmsgkbn2}</td><td>主契約特約保険金額メッセージ区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkykhknkknmsgkbn2 syukyktkykhknkknmsgkbn2}</td><td>主契約特約保険期間メッセージ区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkykstuukatype2 syukyktkykstuukatype2}</td><td>主契約特約保険金額通貨タイプ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSyukyktkykhknkngk2 syukyktkykhknkngk2}</td><td>主契約特約保険金額２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyukyktkykdai1hknkkn2 syukyktkykdai1hknkkn2}</td><td>主契約特約第１保険期間２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyukyktkykdai2hknkkn2 syukyktkykdai2hknkkn2}</td><td>主契約特約第２保険期間２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyutkdai1hknkknymdto2 syutkdai1hknkknymdto2}</td><td>主契約特約第１保険期間年月日（至）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyutkdai2hknkknymdto2 syutkdai2hknkknymdto2}</td><td>主契約特約第２保険期間年月日（至）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyukyktkykrenban3 syukyktkykrenban3}</td><td>主契約特約連番３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyukyktkykmsgkbn3 syukyktkykmsgkbn3}</td><td>主契約特約メッセージ区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkyksmsgkbn3 syukyktkyksmsgkbn3}</td><td>主契約特約保険金額メッセージ区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkykhknkknmsgkbn3 syukyktkykhknkknmsgkbn3}</td><td>主契約特約保険期間メッセージ区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkykstuukatype3 syukyktkykstuukatype3}</td><td>主契約特約保険金額通貨タイプ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSyukyktkykhknkngk3 syukyktkykhknkngk3}</td><td>主契約特約保険金額３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyukyktkykdai1hknkkn3 syukyktkykdai1hknkkn3}</td><td>主契約特約第１保険期間３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyukyktkykdai2hknkkn3 syukyktkykdai2hknkkn3}</td><td>主契約特約第２保険期間３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyutkdai1hknkknymdto3 syutkdai1hknkknymdto3}</td><td>主契約特約第１保険期間年月日（至）３</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyutkdai2hknkknymdto3 syutkdai2hknkknymdto3}</td><td>主契約特約第２保険期間年月日（至）３</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyukyktkykrenban4 syukyktkykrenban4}</td><td>主契約特約連番４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyukyktkykmsgkbn4 syukyktkykmsgkbn4}</td><td>主契約特約メッセージ区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkyksmsgkbn4 syukyktkyksmsgkbn4}</td><td>主契約特約保険金額メッセージ区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkykhknkknmsgkbn4 syukyktkykhknkknmsgkbn4}</td><td>主契約特約保険期間メッセージ区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkykstuukatype4 syukyktkykstuukatype4}</td><td>主契約特約保険金額通貨タイプ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSyukyktkykhknkngk4 syukyktkykhknkngk4}</td><td>主契約特約保険金額４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyukyktkykdai1hknkkn4 syukyktkykdai1hknkkn4}</td><td>主契約特約第１保険期間４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyukyktkykdai2hknkkn4 syukyktkykdai2hknkkn4}</td><td>主契約特約第２保険期間４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyutkdai1hknkknymdto4 syutkdai1hknkknymdto4}</td><td>主契約特約第１保険期間年月日（至）４</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyutkdai2hknkknymdto4 syutkdai2hknkknymdto4}</td><td>主契約特約第２保険期間年月日（至）４</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyukyktkykrenban5 syukyktkykrenban5}</td><td>主契約特約連番５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyukyktkykmsgkbn5 syukyktkykmsgkbn5}</td><td>主契約特約メッセージ区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkyksmsgkbn5 syukyktkyksmsgkbn5}</td><td>主契約特約保険金額メッセージ区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkykhknkknmsgkbn5 syukyktkykhknkknmsgkbn5}</td><td>主契約特約保険期間メッセージ区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkykstuukatype5 syukyktkykstuukatype5}</td><td>主契約特約保険金額通貨タイプ５</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSyukyktkykhknkngk5 syukyktkykhknkngk5}</td><td>主契約特約保険金額５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyukyktkykdai1hknkkn5 syukyktkykdai1hknkkn5}</td><td>主契約特約第１保険期間５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyukyktkykdai2hknkkn5 syukyktkykdai2hknkkn5}</td><td>主契約特約第２保険期間５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyutkdai1hknkknymdto5 syutkdai1hknkknymdto5}</td><td>主契約特約第１保険期間年月日（至）５</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyutkdai2hknkknymdto5 syutkdai2hknkknymdto5}</td><td>主契約特約第２保険期間年月日（至）５</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyukyktkykrenban6 syukyktkykrenban6}</td><td>主契約特約連番６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyukyktkykmsgkbn6 syukyktkykmsgkbn6}</td><td>主契約特約メッセージ区分６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkyksmsgkbn6 syukyktkyksmsgkbn6}</td><td>主契約特約保険金額メッセージ区分６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkykhknkknmsgkbn6 syukyktkykhknkknmsgkbn6}</td><td>主契約特約保険期間メッセージ区分６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkykstuukatype6 syukyktkykstuukatype6}</td><td>主契約特約保険金額通貨タイプ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSyukyktkykhknkngk6 syukyktkykhknkngk6}</td><td>主契約特約保険金額６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyukyktkykdai1hknkkn6 syukyktkykdai1hknkkn6}</td><td>主契約特約第１保険期間６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyukyktkykdai2hknkkn6 syukyktkykdai2hknkkn6}</td><td>主契約特約第２保険期間６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyutkdai1hknkknymdto6 syutkdai1hknkknymdto6}</td><td>主契約特約第１保険期間年月日（至）６</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyutkdai2hknkknymdto6 syutkdai2hknkknymdto6}</td><td>主契約特約第２保険期間年月日（至）６</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyukyktkykrenban7 syukyktkykrenban7}</td><td>主契約特約連番７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyukyktkykmsgkbn7 syukyktkykmsgkbn7}</td><td>主契約特約メッセージ区分７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkyksmsgkbn7 syukyktkyksmsgkbn7}</td><td>主契約特約保険金額メッセージ区分７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkykhknkknmsgkbn7 syukyktkykhknkknmsgkbn7}</td><td>主契約特約保険期間メッセージ区分７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkykstuukatype7 syukyktkykstuukatype7}</td><td>主契約特約保険金額通貨タイプ７</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSyukyktkykhknkngk7 syukyktkykhknkngk7}</td><td>主契約特約保険金額７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyukyktkykdai1hknkkn7 syukyktkykdai1hknkkn7}</td><td>主契約特約第１保険期間７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyukyktkykdai2hknkkn7 syukyktkykdai2hknkkn7}</td><td>主契約特約第２保険期間７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyutkdai1hknkknymdto7 syutkdai1hknkknymdto7}</td><td>主契約特約第１保険期間年月日（至）７</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyutkdai2hknkknymdto7 syutkdai2hknkknymdto7}</td><td>主契約特約第２保険期間年月日（至）７</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyukyktkykrenban8 syukyktkykrenban8}</td><td>主契約特約連番８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyukyktkykmsgkbn8 syukyktkykmsgkbn8}</td><td>主契約特約メッセージ区分８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkyksmsgkbn8 syukyktkyksmsgkbn8}</td><td>主契約特約保険金額メッセージ区分８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkykhknkknmsgkbn8 syukyktkykhknkknmsgkbn8}</td><td>主契約特約保険期間メッセージ区分８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkykstuukatype8 syukyktkykstuukatype8}</td><td>主契約特約保険金額通貨タイプ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSyukyktkykhknkngk8 syukyktkykhknkngk8}</td><td>主契約特約保険金額８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyukyktkykdai1hknkkn8 syukyktkykdai1hknkkn8}</td><td>主契約特約第１保険期間８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyukyktkykdai2hknkkn8 syukyktkykdai2hknkkn8}</td><td>主契約特約第２保険期間８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyutkdai1hknkknymdto8 syutkdai1hknkknymdto8}</td><td>主契約特約第１保険期間年月日（至）８</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyutkdai2hknkknymdto8 syutkdai2hknkknymdto8}</td><td>主契約特約第２保険期間年月日（至）８</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyukyktkykrenban9 syukyktkykrenban9}</td><td>主契約特約連番９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyukyktkykmsgkbn9 syukyktkykmsgkbn9}</td><td>主契約特約メッセージ区分９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkyksmsgkbn9 syukyktkyksmsgkbn9}</td><td>主契約特約保険金額メッセージ区分９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkykhknkknmsgkbn9 syukyktkykhknkknmsgkbn9}</td><td>主契約特約保険期間メッセージ区分９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkykstuukatype9 syukyktkykstuukatype9}</td><td>主契約特約保険金額通貨タイプ９</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSyukyktkykhknkngk9 syukyktkykhknkngk9}</td><td>主契約特約保険金額９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyukyktkykdai1hknkkn9 syukyktkykdai1hknkkn9}</td><td>主契約特約第１保険期間９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyukyktkykdai2hknkkn9 syukyktkykdai2hknkkn9}</td><td>主契約特約第２保険期間９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyutkdai1hknkknymdto9 syutkdai1hknkknymdto9}</td><td>主契約特約第１保険期間年月日（至）９</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyutkdai2hknkknymdto9 syutkdai2hknkknymdto9}</td><td>主契約特約第２保険期間年月日（至）９</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyukyktkykrenban10 syukyktkykrenban10}</td><td>主契約特約連番１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyukyktkykmsgkbn10 syukyktkykmsgkbn10}</td><td>主契約特約メッセージ区分１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkyksmsgkbn10 syukyktkyksmsgkbn10}</td><td>主契約特約保険金額メッセージ区分１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkykhknkknmsgkbn10 syukyktkykhknkknmsgkbn10}</td><td>主契約特約保険期間メッセージ区分１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukyktkykstuukatype10 syukyktkykstuukatype10}</td><td>主契約特約保険金額通貨タイプ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSyukyktkykhknkngk10 syukyktkykhknkngk10}</td><td>主契約特約保険金額１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSyukyktkykdai1hknkkn10 syukyktkykdai1hknkkn10}</td><td>主契約特約第１保険期間１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyukyktkykdai2hknkkn10 syukyktkykdai2hknkkn10}</td><td>主契約特約第２保険期間１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyutkdai1hknkknymdto10 syutkdai1hknkknymdto10}</td><td>主契約特約第１保険期間年月日（至）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyutkdai2hknkknymdto10 syutkdai2hknkknymdto10}</td><td>主契約特約第２保険期間年月日（至）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykniyustmsgcd1 kykniyustmsgcd1}</td><td>契約内容欄下メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykniyustmsgcd2 kykniyustmsgcd2}</td><td>契約内容欄下メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykniyustmsgcd3 kykniyustmsgcd3}</td><td>契約内容欄下メッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykniyustmsgcd4 kykniyustmsgcd4}</td><td>契約内容欄下メッセージコード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykniyustmsgcd5 kykniyustmsgcd5}</td><td>契約内容欄下メッセージコード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykniyustmsgcd6 kykniyustmsgcd6}</td><td>契約内容欄下メッセージコード６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykniyustmsgcd7 kykniyustmsgcd7}</td><td>契約内容欄下メッセージコード７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykniyustmsgcd8 kykniyustmsgcd8}</td><td>契約内容欄下メッセージコード８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykniyustmsgcd9 kykniyustmsgcd9}</td><td>契約内容欄下メッセージコード９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykniyustmsgcd10 kykniyustmsgcd10}</td><td>契約内容欄下メッセージコード１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykniyustmsgcd11 kykniyustmsgcd11}</td><td>契約内容欄下メッセージコード１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykniyustmsgcd12 kykniyustmsgcd12}</td><td>契約内容欄下メッセージコード１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykniyustmsgcd13 kykniyustmsgcd13}</td><td>契約内容欄下メッセージコード１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykniyustmsgcd14 kykniyustmsgcd14}</td><td>契約内容欄下メッセージコード１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykniyustmsgcd15 kykniyustmsgcd15}</td><td>契約内容欄下メッセージコード１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykniyustitjbrptuuktype kykniyustitjbrptuuktype}</td><td>契約内容欄下一時払保険料通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getKykniyustitjbrp kykniyustitjbrp}</td><td>契約内容欄下一時払保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getStnaiyouranmsgcd1 stnaiyouranmsgcd1}</td><td>その他内容欄メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStnaiyouranmsgcd2 stnaiyouranmsgcd2}</td><td>その他内容欄メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStnaiyouranmsgcd3 stnaiyouranmsgcd3}</td><td>その他内容欄メッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStnaiyouranmsgcd4 stnaiyouranmsgcd4}</td><td>その他内容欄メッセージコード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStnaiyouranmsgcd5 stnaiyouranmsgcd5}</td><td>その他内容欄メッセージコード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStnaiyouranmsgcd6 stnaiyouranmsgcd6}</td><td>その他内容欄メッセージコード６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStnaiyouranmsgcd7 stnaiyouranmsgcd7}</td><td>その他内容欄メッセージコード７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStnaiyouranmsgcd8 stnaiyouranmsgcd8}</td><td>その他内容欄メッセージコード８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStnaiyouranmsgcd9 stnaiyouranmsgcd9}</td><td>その他内容欄メッセージコード９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStnaiyouranmsgcd10 stnaiyouranmsgcd10}</td><td>その他内容欄メッセージコード１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStnaiyouranmsgcd11 stnaiyouranmsgcd11}</td><td>その他内容欄メッセージコード１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStnaiyouranmsgcd12 stnaiyouranmsgcd12}</td><td>その他内容欄メッセージコード１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStnaiyouranmsgcd13 stnaiyouranmsgcd13}</td><td>その他内容欄メッセージコード１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStnaiyouranmsgcd14 stnaiyouranmsgcd14}</td><td>その他内容欄メッセージコード１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStnaiyouranmsgcd15 stnaiyouranmsgcd15}</td><td>その他内容欄メッセージコード１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStnaiyouranmsgcd16 stnaiyouranmsgcd16}</td><td>その他内容欄メッセージコード１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStnaiyouranmsgcd17 stnaiyouranmsgcd17}</td><td>その他内容欄メッセージコード１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStnaiyouranmsgcd18 stnaiyouranmsgcd18}</td><td>その他内容欄メッセージコード１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStnaiyouranmsgcd19 stnaiyouranmsgcd19}</td><td>その他内容欄メッセージコード１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStnaiyouranmsgcd20 stnaiyouranmsgcd20}</td><td>その他内容欄メッセージコード２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSonotanyransiteituuka sonotanyransiteituuka}</td><td>その他内容欄指定通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSonotanyrannykntuktype sonotanyrannykntuktype}</td><td>その他内容欄入金通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSonotanyrannykntuukap sonotanyrannykntuukap}</td><td>その他内容欄入金通貨保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSonotanyrannykntuukasyu sonotanyrannykntuukasyu}</td><td>その他内容欄入金通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSonotanyranenkhrikmrate sonotanyranenkhrikmrate}</td><td>その他内容欄円貨払込特約レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSonotanyranstigikwsrate sonotanyranstigikwsrate}</td><td>その他内容欄指定外通貨払込特約レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSonotanyrankjnkngktuktype sonotanyrankjnkngktuktype}</td><td>その他内容欄基準金額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSonotanyrankjnkngk sonotanyrankjnkngk}</td><td>その他内容欄基準金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSonotanyrankjnkngkrate sonotanyrankjnkngkrate}</td><td>その他内容欄基準金額換算レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSonotanyrankjnkngktuuka sonotanyrankjnkngktuuka}</td><td>その他内容欄基準金額通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSonotanyranpentuktype sonotanyranpentuktype}</td><td>その他内容欄保険料円換算通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSonotanyranpenknsngk sonotanyranpenknsngk}</td><td>その他内容欄保険料円換算額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSonotanyranmkhwariai sonotanyranmkhwariai}</td><td>その他内容欄目標到達割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSonotanyranytirrt sonotanyranytirrt}</td><td>その他内容欄予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSonotanyransjkkktusirrt sonotanyransjkkktusirrt}</td><td>その他内容欄市場価格調整用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getStnaiyourangaimsgcd stnaiyourangaimsgcd}</td><td>その他内容欄外メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinyno tsinyno}</td><td>通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr1kj tsinadr1kj}</td><td>通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr2kj tsinadr2kj}</td><td>通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr3kj tsinadr3kj}</td><td>通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getShsnmkj shsnmkj}</td><td>送付先氏名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTnknmissmsg tnknmissmsg}</td><td>転換ミスメッセージ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getErrormsgcd errormsgcd}</td><td>エラーメッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSisyacd sisyacd}</td><td>支社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDuhutusnrntousaadrmsgcd duhutusnrntousaadrmsgcd}</td><td>同封通信欄当社住所メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDuhutusnrnsyono duhutusnrnsyono}</td><td>同封通信欄証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getChannelcd channelcd}</td><td>チャネルコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Channelcd}</td></tr>
 *  <tr><td>{@link #getDairitenmidasikbn dairitenmidasikbn}</td><td>代理店見出し区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtennm1kj drtennm1kj}</td><td>代理店名１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtennm2kj drtennm2kj}</td><td>代理店名２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAisatumsgcd aisatumsgcd}</td><td>挨拶メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCcmsgcd ccmsgcd}</td><td>コールセンターメッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHskmsgcd hskmsgcd}</td><td>補足メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHosyounymsgcd hosyounymsgcd}</td><td>保障内容メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHosyounyhihknsyameikanji hosyounyhihknsyameikanji}</td><td>保障内容被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiboumidasimsgcd siboumidasimsgcd}</td><td>死亡保障見出しメッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiboumidasimsgcd2 siboumidasimsgcd2}</td><td>死亡保障見出しメッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiboudai1hknkknmsgcd1 siboudai1hknkknmsgcd1}</td><td>死亡保障第１保険期間メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiboudai1hknkknmsgcd2 siboudai1hknkknmsgcd2}</td><td>死亡保障第１保険期間メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiboudai1hknkknigimsgcd siboudai1hknkknigimsgcd}</td><td>死亡保障第１保険期間不慮以外Ｓ表メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiboudai1hknkknigimsgcd2 siboudai1hknkknigimsgcd2}</td><td>死亡保障第１保険期間不慮以外Ｓ表メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiboudai1hknkknhrsmsgcd siboudai1hknkknhrsmsgcd}</td><td>死亡保障第１保険期間不慮Ｓ表メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiboudai1hknkknhrsmsgcd2 siboudai1hknkknhrsmsgcd2}</td><td>死亡保障第１保険期間不慮Ｓ表メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiboudai1hknkknsmrmsgcd siboudai1hknkknsmrmsgcd}</td><td>死亡保障第１保険期間Ｓ表丸印メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiboudai2hknkknmsgcd1 siboudai2hknkknmsgcd1}</td><td>死亡保障第２保険期間メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiboudai2hknkknmsgcd2 siboudai2hknkknmsgcd2}</td><td>死亡保障第２保険期間メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiboudai2hknkknsmsgcd siboudai2hknkknsmsgcd}</td><td>死亡保障第２保険期間Ｓ表メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiboudai2hknkknsmsgcd2 siboudai2hknkknsmsgcd2}</td><td>死亡保障第２保険期間Ｓ表メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiboudai3hknkknmsgcd1 siboudai3hknkknmsgcd1}</td><td>死亡保障第３保険期間メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiboudai3hknkknmsgcd2 siboudai3hknkknmsgcd2}</td><td>死亡保障第３保険期間メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiboudai1hknkkn siboudai1hknkkn}</td><td>死亡保障第１保険期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSiboudai1hknkknymdto siboudai1hknkknymdto}</td><td>死亡保障第１保険期間年月日（至）</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSibouitjbrpyentuuktype sibouitjbrpyentuuktype}</td><td>死亡保障一時払保険料相当円換算額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSibouitjbrpyentuukgk sibouitjbrpyentuukgk}</td><td>死亡保障一時払保険料相当円換算額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSiboudai1kjnkngktuuktype siboudai1kjnkngktuuktype}</td><td>死亡保障第１基準金額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSiboudai1kjnkngk siboudai1kjnkngk}</td><td>死亡保障第１基準金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSiboudai2hknkkn siboudai2hknkkn}</td><td>死亡保障第２保険期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSiboudai2hknkknymdto siboudai2hknkknymdto}</td><td>死亡保障第２保険期間年月日（至）</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSiboudai2kjnkngktuuktype siboudai2kjnkngktuuktype}</td><td>死亡保障第２基準金額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSiboudai2kjnkngk siboudai2kjnkngk}</td><td>死亡保障第２基準金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSiboudai3kjnkngktuuktype siboudai3kjnkngktuuktype}</td><td>死亡保障第３基準金額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getSiboudai3kjnkngk siboudai3kjnkngk}</td><td>死亡保障第３基準金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1skwsrateyendaka dai1skwsrateyendaka}</td><td>第１死亡保険金額為替レート（円高）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDai1skwsrateyenkijyun dai1skwsrateyenkijyun}</td><td>第１死亡保険金額為替レート（中央値）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDai1skwsrateyenyasu dai1skwsrateyenyasu}</td><td>第１死亡保険金額為替レート（円安）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDai1skeikanensuu01 dai1skeikanensuu01}</td><td>第１死亡保険金額経過年数０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDai1sibousnenoutouymd01 dai1sibousnenoutouymd01}</td><td>第１死亡保険金額年単位応当年月日０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDai1stuuktype01 dai1stuuktype01}</td><td>第１死亡保険金額通貨タイプ０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1s01 dai1s01}</td><td>第１死亡保険金額０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyendakaumu01 dai1syenyendakaumu01}</td><td>第１死亡保険金額（円貨）（円高）丸印有無０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syenyenkijyunumu01 dai1syenyenkijyunumu01}</td><td>第１死亡保険金額（円貨）（中央値）丸印有無０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syenyenyasuumu01 dai1syenyenyasuumu01}</td><td>第１死亡保険金額（円貨）（円安）丸印有無０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syentuuktype01 dai1syentuuktype01}</td><td>第１死亡保険金額（円貨）通貨タイプ０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1syenyendaka01 dai1syenyendaka01}</td><td>第１死亡保険金額（円貨）（円高）０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyenkijyun01 dai1syenyenkijyun01}</td><td>第１死亡保険金額（円貨）（中央値）０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyenyasu01 dai1syenyenyasu01}</td><td>第１死亡保険金額（円貨）（円安）０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1skeikanensuu02 dai1skeikanensuu02}</td><td>第１死亡保険金額経過年数０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDai1sibousnenoutouymd02 dai1sibousnenoutouymd02}</td><td>第１死亡保険金額年単位応当年月日０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDai1stuuktype02 dai1stuuktype02}</td><td>第１死亡保険金額通貨タイプ０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1s02 dai1s02}</td><td>第１死亡保険金額０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyendakaumu02 dai1syenyendakaumu02}</td><td>第１死亡保険金額（円貨）（円高）丸印有無０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syenyenkijyunumu02 dai1syenyenkijyunumu02}</td><td>第１死亡保険金額（円貨）（中央値）丸印有無０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syenyenyasuumu02 dai1syenyenyasuumu02}</td><td>第１死亡保険金額（円貨）（円安）丸印有無０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syentuuktype02 dai1syentuuktype02}</td><td>第１死亡保険金額（円貨）通貨タイプ０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1syenyendaka02 dai1syenyendaka02}</td><td>第１死亡保険金額（円貨）（円高）０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyenkijyun02 dai1syenyenkijyun02}</td><td>第１死亡保険金額（円貨）（中央値）０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyenyasu02 dai1syenyenyasu02}</td><td>第１死亡保険金額（円貨）（円安）０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1skeikanensuu03 dai1skeikanensuu03}</td><td>第１死亡保険金額経過年数０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDai1sibousnenoutouymd03 dai1sibousnenoutouymd03}</td><td>第１死亡保険金額年単位応当年月日０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDai1stuuktype03 dai1stuuktype03}</td><td>第１死亡保険金額通貨タイプ０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1s03 dai1s03}</td><td>第１死亡保険金額０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyendakaumu03 dai1syenyendakaumu03}</td><td>第１死亡保険金額（円貨）（円高）丸印有無０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syenyenkijyunumu03 dai1syenyenkijyunumu03}</td><td>第１死亡保険金額（円貨）（中央値）丸印有無０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syenyenyasuumu03 dai1syenyenyasuumu03}</td><td>第１死亡保険金額（円貨）（円安）丸印有無０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syentuuktype03 dai1syentuuktype03}</td><td>第１死亡保険金額（円貨）通貨タイプ０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1syenyendaka03 dai1syenyendaka03}</td><td>第１死亡保険金額（円貨）（円高）０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyenkijyun03 dai1syenyenkijyun03}</td><td>第１死亡保険金額（円貨）（中央値）０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyenyasu03 dai1syenyenyasu03}</td><td>第１死亡保険金額（円貨）（円安）０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1skeikanensuu04 dai1skeikanensuu04}</td><td>第１死亡保険金額経過年数０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDai1sibousnenoutouymd04 dai1sibousnenoutouymd04}</td><td>第１死亡保険金額年単位応当年月日０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDai1stuuktype04 dai1stuuktype04}</td><td>第１死亡保険金額通貨タイプ０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1s04 dai1s04}</td><td>第１死亡保険金額０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyendakaumu04 dai1syenyendakaumu04}</td><td>第１死亡保険金額（円貨）（円高）丸印有無０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syenyenkijyunumu04 dai1syenyenkijyunumu04}</td><td>第１死亡保険金額（円貨）（中央値）丸印有無０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syenyenyasuumu04 dai1syenyenyasuumu04}</td><td>第１死亡保険金額（円貨）（円安）丸印有無０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syentuuktype04 dai1syentuuktype04}</td><td>第１死亡保険金額（円貨）通貨タイプ０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1syenyendaka04 dai1syenyendaka04}</td><td>第１死亡保険金額（円貨）（円高）０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyenkijyun04 dai1syenyenkijyun04}</td><td>第１死亡保険金額（円貨）（中央値）０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyenyasu04 dai1syenyenyasu04}</td><td>第１死亡保険金額（円貨）（円安）０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1skeikanensuu05 dai1skeikanensuu05}</td><td>第１死亡保険金額経過年数０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDai1sibousnenoutouymd05 dai1sibousnenoutouymd05}</td><td>第１死亡保険金額年単位応当年月日０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDai1stuuktype05 dai1stuuktype05}</td><td>第１死亡保険金額通貨タイプ０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1s05 dai1s05}</td><td>第１死亡保険金額０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyendakaumu05 dai1syenyendakaumu05}</td><td>第１死亡保険金額（円貨）（円高）丸印有無０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syenyenkijyunumu05 dai1syenyenkijyunumu05}</td><td>第１死亡保険金額（円貨）（中央値）丸印有無０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syenyenyasuumu05 dai1syenyenyasuumu05}</td><td>第１死亡保険金額（円貨）（円安）丸印有無０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syentuuktype05 dai1syentuuktype05}</td><td>第１死亡保険金額（円貨）通貨タイプ０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1syenyendaka05 dai1syenyendaka05}</td><td>第１死亡保険金額（円貨）（円高）０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyenkijyun05 dai1syenyenkijyun05}</td><td>第１死亡保険金額（円貨）（中央値）０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyenyasu05 dai1syenyenyasu05}</td><td>第１死亡保険金額（円貨）（円安）０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1skeikanensuu06 dai1skeikanensuu06}</td><td>第１死亡保険金額経過年数０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDai1sibousnenoutouymd06 dai1sibousnenoutouymd06}</td><td>第１死亡保険金額年単位応当年月日０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDai1stuuktype06 dai1stuuktype06}</td><td>第１死亡保険金額通貨タイプ０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1s06 dai1s06}</td><td>第１死亡保険金額０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyendakaumu06 dai1syenyendakaumu06}</td><td>第１死亡保険金額（円貨）（円高）丸印有無０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syenyenkijyunumu06 dai1syenyenkijyunumu06}</td><td>第１死亡保険金額（円貨）（中央値）丸印有無０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syenyenyasuumu06 dai1syenyenyasuumu06}</td><td>第１死亡保険金額（円貨）（円安）丸印有無０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syentuuktype06 dai1syentuuktype06}</td><td>第１死亡保険金額（円貨）通貨タイプ０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1syenyendaka06 dai1syenyendaka06}</td><td>第１死亡保険金額（円貨）（円高）０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyenkijyun06 dai1syenyenkijyun06}</td><td>第１死亡保険金額（円貨）（中央値）０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyenyasu06 dai1syenyenyasu06}</td><td>第１死亡保険金額（円貨）（円安）０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1skeikanensuu07 dai1skeikanensuu07}</td><td>第１死亡保険金額経過年数０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDai1sibousnenoutouymd07 dai1sibousnenoutouymd07}</td><td>第１死亡保険金額年単位応当年月日０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDai1stuuktype07 dai1stuuktype07}</td><td>第１死亡保険金額通貨タイプ０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1s07 dai1s07}</td><td>第１死亡保険金額０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyendakaumu07 dai1syenyendakaumu07}</td><td>第１死亡保険金額（円貨）（円高）丸印有無０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syenyenkijyunumu07 dai1syenyenkijyunumu07}</td><td>第１死亡保険金額（円貨）（中央値）丸印有無０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syenyenyasuumu07 dai1syenyenyasuumu07}</td><td>第１死亡保険金額（円貨）（円安）丸印有無０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syentuuktype07 dai1syentuuktype07}</td><td>第１死亡保険金額（円貨）通貨タイプ０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1syenyendaka07 dai1syenyendaka07}</td><td>第１死亡保険金額（円貨）（円高）０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyenkijyun07 dai1syenyenkijyun07}</td><td>第１死亡保険金額（円貨）（中央値）０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyenyasu07 dai1syenyenyasu07}</td><td>第１死亡保険金額（円貨）（円安）０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1skeikanensuu08 dai1skeikanensuu08}</td><td>第１死亡保険金額経過年数０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDai1sibousnenoutouymd08 dai1sibousnenoutouymd08}</td><td>第１死亡保険金額年単位応当年月日０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDai1stuuktype08 dai1stuuktype08}</td><td>第１死亡保険金額通貨タイプ０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1s08 dai1s08}</td><td>第１死亡保険金額０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyendakaumu08 dai1syenyendakaumu08}</td><td>第１死亡保険金額（円貨）（円高）丸印有無０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syenyenkijyunumu08 dai1syenyenkijyunumu08}</td><td>第１死亡保険金額（円貨）（中央値）丸印有無０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syenyenyasuumu08 dai1syenyenyasuumu08}</td><td>第１死亡保険金額（円貨）（円安）丸印有無０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syentuuktype08 dai1syentuuktype08}</td><td>第１死亡保険金額（円貨）通貨タイプ０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1syenyendaka08 dai1syenyendaka08}</td><td>第１死亡保険金額（円貨）（円高）０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyenkijyun08 dai1syenyenkijyun08}</td><td>第１死亡保険金額（円貨）（中央値）０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyenyasu08 dai1syenyenyasu08}</td><td>第１死亡保険金額（円貨）（円安）０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1skeikanensuu09 dai1skeikanensuu09}</td><td>第１死亡保険金額経過年数０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDai1sibousnenoutouymd09 dai1sibousnenoutouymd09}</td><td>第１死亡保険金額年単位応当年月日０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDai1stuuktype09 dai1stuuktype09}</td><td>第１死亡保険金額通貨タイプ０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1s09 dai1s09}</td><td>第１死亡保険金額０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyendakaumu09 dai1syenyendakaumu09}</td><td>第１死亡保険金額（円貨）（円高）丸印有無０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syenyenkijyunumu09 dai1syenyenkijyunumu09}</td><td>第１死亡保険金額（円貨）（中央値）丸印有無０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syenyenyasuumu09 dai1syenyenyasuumu09}</td><td>第１死亡保険金額（円貨）（円安）丸印有無０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syentuuktype09 dai1syentuuktype09}</td><td>第１死亡保険金額（円貨）通貨タイプ０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1syenyendaka09 dai1syenyendaka09}</td><td>第１死亡保険金額（円貨）（円高）０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyenkijyun09 dai1syenyenkijyun09}</td><td>第１死亡保険金額（円貨）（中央値）０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyenyasu09 dai1syenyenyasu09}</td><td>第１死亡保険金額（円貨）（円安）０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1skeikanensuu10 dai1skeikanensuu10}</td><td>第１死亡保険金額経過年数１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDai1sibousnenoutouymd10 dai1sibousnenoutouymd10}</td><td>第１死亡保険金額年単位応当年月日１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDai1stuuktype10 dai1stuuktype10}</td><td>第１死亡保険金額通貨タイプ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1s10 dai1s10}</td><td>第１死亡保険金額１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyendakaumu10 dai1syenyendakaumu10}</td><td>第１死亡保険金額（円貨）（円高）丸印有無１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syenyenkijyunumu10 dai1syenyenkijyunumu10}</td><td>第１死亡保険金額（円貨）（中央値）丸印有無１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syenyenyasuumu10 dai1syenyenyasuumu10}</td><td>第１死亡保険金額（円貨）（円安）丸印有無１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syentuuktype10 dai1syentuuktype10}</td><td>第１死亡保険金額（円貨）通貨タイプ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1syenyendaka10 dai1syenyendaka10}</td><td>第１死亡保険金額（円貨）（円高）１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyenkijyun10 dai1syenyenkijyun10}</td><td>第１死亡保険金額（円貨）（中央値）１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyenyasu10 dai1syenyenyasu10}</td><td>第１死亡保険金額（円貨）（円安）１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1stuuktypehuryo dai1stuuktypehuryo}</td><td>第１死亡保険金額通貨タイプ（不慮）</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1shuryo dai1shuryo}</td><td>第１死亡保険金額（不慮）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyendakaumuhuryo dai1syenyendakaumuhuryo}</td><td>第１死亡保険金額（円貨）（円高）丸印有無（不慮）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syenyenkjnumuhuryo dai1syenyenkjnumuhuryo}</td><td>第１死亡保険金額（円貨）（中央値）丸印有無（不慮）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syenyenyasuumuhuryo dai1syenyenyasuumuhuryo}</td><td>第１死亡保険金額（円貨）（円安）丸印有無（不慮）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDai1syentuuktypehuryo dai1syentuuktypehuryo}</td><td>第１死亡保険金額（円貨）通貨タイプ（不慮）</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1syenyendakahuryo dai1syenyendakahuryo}</td><td>第１死亡保険金額（円貨）（円高）（不慮）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyenkijyunhuryo dai1syenyenkijyunhuryo}</td><td>第１死亡保険金額（円貨）（中央値）（不慮）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1syenyenyasuhuryo dai1syenyenyasuhuryo}</td><td>第１死亡保険金額（円貨）（円安）（不慮）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getInitsbjiyenkasaiteihsygk initsbjiyenkasaiteihsygk}</td><td>初期死亡時円換算最低保証額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai2stuuktype dai2stuuktype}</td><td>第２死亡保険金額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai2s dai2s}</td><td>第２死亡保険金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai2syentuuktype dai2syentuuktype}</td><td>第２死亡保険金額（円貨）通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai2syenyendaka dai2syenyendaka}</td><td>第２死亡保険金額（円貨）（円高）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai2syenyenkijyun dai2syenyenkijyun}</td><td>第２死亡保険金額（円貨）（中央値）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai2syenyenyasu dai2syenyenyasu}</td><td>第２死亡保険金額（円貨）（円安）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai3stuuktype dai3stuuktype}</td><td>第３死亡保険金額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai3s dai3s}</td><td>第３死亡保険金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai3syentuuktype dai3syentuuktype}</td><td>第３死亡保険金額（円貨）通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai3syenyendaka dai3syenyendaka}</td><td>第３死亡保険金額（円貨）（円高）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai3syenyenkijyun dai3syenyenkijyun}</td><td>第３死亡保険金額（円貨）（中央値）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai3syenyenyasu dai3syenyenyasu}</td><td>第３死亡保険金額（円貨）（円安）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSibouinjiptnkbn sibouinjiptnkbn}</td><td>死亡保障印字パターン</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMkhyouyensysnikoumsgcd mkhyouyensysnikoumsgcd}</td><td>目標到達時円建終身保険移行特約メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMkhyouyensysnikoumsgcd2 mkhyouyensysnikoumsgcd2}</td><td>目標到達時円建終身保険移行特約メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMkhyouyensysnikoumsgcd3 mkhyouyensysnikoumsgcd3}</td><td>目標到達時円建終身保険移行特約メッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMkhyouyensysnikougktype mkhyouyensysnikougktype}</td><td>目標到達時円建終身保険移行特約目標額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getMkhyouyensysnikougk mkhyouyensysnikougk}</td><td>目標到達時円建終身保険移行特約目標額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMkhyouyensysnikouwra mkhyouyensysnikouwra}</td><td>目標到達時円建終身保険移行特約目標割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKaigomaehrtkykmsgcd1 kaigomaehrtkykmsgcd1}</td><td>介護前払特約メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKaigomaehrtkykmsgcd2 kaigomaehrtkykmsgcd2}</td><td>介護前払特約メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKaigomaehrtkykmsgcdst1 kaigomaehrtkykmsgcdst1}</td><td>介護前払特約メッセージコード表下１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKaigomaehrtkykmsgcdst2 kaigomaehrtkykmsgcdst2}</td><td>介護前払特約メッセージコード表下２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKaigomaehruktgkumu kaigomaehruktgkumu}</td><td>介護前払特約受取額一覧有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKaigomaehrtkykkyktuuka kaigomaehrtkykkyktuuka}</td><td>介護前払特約契約通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKaigomaehrtkykstdmsgcd kaigomaehrtkykstdmsgcd}</td><td>介護前払特約指定代理メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugktype kaigomaehrjrugktype}</td><td>介護前払受領額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getKaigomaehrsikuhhknnen01 kaigomaehrsikuhhknnen01}</td><td>介護前払請求日時点被保険者年齢０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKaigomaehrstikkn01 kaigomaehrstikkn01}</td><td>介護前払所定期間０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugk01 kaigomaehrjrugk01}</td><td>介護前払受領額０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrsikuhhknnen02 kaigomaehrsikuhhknnen02}</td><td>介護前払請求日時点被保険者年齢０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKaigomaehrstikkn02 kaigomaehrstikkn02}</td><td>介護前払所定期間０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugk02 kaigomaehrjrugk02}</td><td>介護前払受領額０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrsikuhhknnen03 kaigomaehrsikuhhknnen03}</td><td>介護前払請求日時点被保険者年齢０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKaigomaehrstikkn03 kaigomaehrstikkn03}</td><td>介護前払所定期間０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugk03 kaigomaehrjrugk03}</td><td>介護前払受領額０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrsikuhhknnen04 kaigomaehrsikuhhknnen04}</td><td>介護前払請求日時点被保険者年齢０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKaigomaehrstikkn04 kaigomaehrstikkn04}</td><td>介護前払所定期間０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugk04 kaigomaehrjrugk04}</td><td>介護前払受領額０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrsikuhhknnen05 kaigomaehrsikuhhknnen05}</td><td>介護前払請求日時点被保険者年齢０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKaigomaehrstikkn05 kaigomaehrstikkn05}</td><td>介護前払所定期間０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugk05 kaigomaehrjrugk05}</td><td>介護前払受領額０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrsikuhhknnen06 kaigomaehrsikuhhknnen06}</td><td>介護前払請求日時点被保険者年齢０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKaigomaehrstikkn06 kaigomaehrstikkn06}</td><td>介護前払所定期間０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugk06 kaigomaehrjrugk06}</td><td>介護前払受領額０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrsikuhhknnen07 kaigomaehrsikuhhknnen07}</td><td>介護前払請求日時点被保険者年齢０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKaigomaehrstikkn07 kaigomaehrstikkn07}</td><td>介護前払所定期間０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugk07 kaigomaehrjrugk07}</td><td>介護前払受領額０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrsikuhhknnen08 kaigomaehrsikuhhknnen08}</td><td>介護前払請求日時点被保険者年齢０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKaigomaehrstikkn08 kaigomaehrstikkn08}</td><td>介護前払所定期間０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugk08 kaigomaehrjrugk08}</td><td>介護前払受領額０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrsikuhhknnen09 kaigomaehrsikuhhknnen09}</td><td>介護前払請求日時点被保険者年齢０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKaigomaehrstikkn09 kaigomaehrstikkn09}</td><td>介護前払所定期間０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugk09 kaigomaehrjrugk09}</td><td>介護前払受領額０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrsikuhhknnen10 kaigomaehrsikuhhknnen10}</td><td>介護前払請求日時点被保険者年齢１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKaigomaehrstikkn10 kaigomaehrstikkn10}</td><td>介護前払所定期間１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugk10 kaigomaehrjrugk10}</td><td>介護前払受領額１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHutanhiyustmmsgcdue01 hutanhiyustmmsgcdue01}</td><td>ご負担費用説明欄メッセージコード表上１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHutanhiyustmmsgcdue02 hutanhiyustmmsgcdue02}</td><td>ご負担費用説明欄メッセージコード表上２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHutanhiyustmmsgcdue03 hutanhiyustmmsgcdue03}</td><td>ご負担費用説明欄メッセージコード表上３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHutanhiyustmmsgcdue04 hutanhiyustmmsgcdue04}</td><td>ご負担費用説明欄メッセージコード表上４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHutanhiyustmknsnhyuptn hutanhiyustmknsnhyuptn}</td><td>ご負担費用説明欄換算費用パターン</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHutanhiyustmmsgcdst01 hutanhiyustmmsgcdst01}</td><td>ご負担費用説明欄メッセージコード表下１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHutanhiyustmmsgcdst02 hutanhiyustmmsgcdst02}</td><td>ご負担費用説明欄メッセージコード表下２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHutanhiyustmmsgcdst03 hutanhiyustmmsgcdst03}</td><td>ご負担費用説明欄メッセージコード表下３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStdstmmsgcd stdstmmsgcd}</td><td>指定代理請求特約説明欄メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFstpmsgcd fstpmsgcd}</td><td>初回Ｐご確認欄メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getFstphrkpkngkkeituuktype fstphrkpkngkkeituuktype}</td><td>初回Ｐご確認欄払込保険料合計通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getFstphrkpkngkkei fstphrkpkngkkei}</td><td>初回Ｐご確認欄払込保険料合計</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getFstponegaimsgcd fstponegaimsgcd}</td><td>初回Ｐご確認欄お願いメッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDsmsgcd dsmsgcd}</td><td>スミセイダイレクトサービスメッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnhutaimsgcd1 syouhnhutaimsgcd1}</td><td>商品付帯サービスメッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnhutaimsgcd2 syouhnhutaimsgcd2}</td><td>商品付帯サービスメッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPyentuuktype pyentuuktype}</td><td>保険料円換算額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getPyen pyen}</td><td>保険料円換算額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getToiawasesakihanyoumsgcd toiawasesakihanyoumsgcd}</td><td>問合せ先汎用メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAnnaihanyoumsgcd annaihanyoumsgcd}</td><td>案内汎用メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getWmsgcd1 wmsgcd1}</td><td>解約返戻金メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getWmsgcd2 wmsgcd2}</td><td>解約返戻金メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getWmsgcd3 wmsgcd3}</td><td>解約返戻金メッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getWtyuuijikoumsgcd1 wtyuuijikoumsgcd1}</td><td>解約返戻金注意事項メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getWtyuuijikoumsgcd2 wtyuuijikoumsgcd2}</td><td>解約返戻金注意事項メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getWtyuuijikoumsgcd3 wtyuuijikoumsgcd3}</td><td>解約返戻金注意事項メッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getWtyuuijikoumsgcd4 wtyuuijikoumsgcd4}</td><td>解約返戻金注意事項メッセージコード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getWtyuuijikoumsgcd5 wtyuuijikoumsgcd5}</td><td>解約返戻金注意事項メッセージコード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getWitijibrptuktype witijibrptuktype}</td><td>解約返戻金一時払保険料通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getWitijibrp witijibrp}</td><td>解約返戻金一時払保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getWyenhrkgktuktype wyenhrkgktuktype}</td><td>解約返戻金円貨払込額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getWyenhrkgk wyenhrkgk}</td><td>解約返戻金円貨払込額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getWyenitijibrptuktype wyenitijibrptuktype}</td><td>解約返戻金円換算一時払保険料通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getWyenitijibrp wyenitijibrp}</td><td>解約返戻金円換算一時払保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKoujyosyoumeimsgcd1 koujyosyoumeimsgcd1}</td><td>控除証明説明メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKoujyosyoumeimsgcd2 koujyosyoumeimsgcd2}</td><td>控除証明説明メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKoujyosyoumeimsgcd3 koujyosyoumeimsgcd3}</td><td>控除証明説明メッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKoujyosyoumeihskmsgcd koujyosyoumeihskmsgcd}</td><td>控除証明補足メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkoujyosyoumeihskmsgcd nenkoujyosyoumeihskmsgcd}</td><td>年間控除証明補足メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTokusyusyorinaiyoukbn1 tokusyusyorinaiyoukbn1}</td><td>特殊処理内容区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>{@link #getTokusyusyorinaiyoukbn2 tokusyusyorinaiyoukbn2}</td><td>特殊処理内容区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>{@link #getTokusyusyorinaiyoukbn3 tokusyusyorinaiyoukbn3}</td><td>特殊処理内容区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>{@link #getTokusyusyorinaiyoukbn4 tokusyusyorinaiyoukbn4}</td><td>特殊処理内容区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>{@link #getTokusyusyorinaiyoukbn5 tokusyusyorinaiyoukbn5}</td><td>特殊処理内容区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>{@link #getTokusyusyorinaiyoukbn6 tokusyusyorinaiyoukbn6}</td><td>特殊処理内容区分６</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>{@link #getTokusyusyorinaiyoukbn7 tokusyusyorinaiyoukbn7}</td><td>特殊処理内容区分７</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>{@link #getTokusyusyorinaiyoukbn8 tokusyusyorinaiyoukbn8}</td><td>特殊処理内容区分８</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>{@link #getTokusyusyorinaiyoukbn9 tokusyusyorinaiyoukbn9}</td><td>特殊処理内容区分９</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>{@link #getTokusyusyorinaiyoukbn10 tokusyusyorinaiyoukbn10}</td><td>特殊処理内容区分１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>{@link #getTokusyusyorinaiyoukbn11 tokusyusyorinaiyoukbn11}</td><td>特殊処理内容区分１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>{@link #getTokusyusyorinaiyoukbn12 tokusyusyorinaiyoukbn12}</td><td>特殊処理内容区分１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>{@link #getTokusyusyorinaiyoukbn13 tokusyusyorinaiyoukbn13}</td><td>特殊処理内容区分１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>{@link #getTokusyusyorinaiyoukbn14 tokusyusyorinaiyoukbn14}</td><td>特殊処理内容区分１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>{@link #getTokusyusyorinaiyoukbn15 tokusyusyorinaiyoukbn15}</td><td>特殊処理内容区分１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>{@link #getTokusyusyorinaiyoukbn16 tokusyusyorinaiyoukbn16}</td><td>特殊処理内容区分１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>{@link #getTokusyusyorinaiyoukbn17 tokusyusyorinaiyoukbn17}</td><td>特殊処理内容区分１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TokusyuSyoriNaiyouKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkn kyknmkn}</td><td>契約者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkn hhknnmkn}</td><td>被保険者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSonotanyrannkshrstartymd sonotanyrannkshrstartymd}</td><td>その他内容欄年金支払開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSonotanyrannenkinkkn sonotanyrannenkinkkn}</td><td>その他内容欄年金期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSonotanyranyensysnhkhnkymd sonotanyranyensysnhkhnkymd}</td><td>その他内容欄円建終身保険変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSonotanyrantumitateriritu sonotanyrantumitateriritu}</td><td>その他内容欄積立利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSonotanyrantmttknzkrtjygn sonotanyrantmttknzkrtjygn}</td><td>その他内容欄積立金増加率上限</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSonotanyransetteibairitu sonotanyransetteibairitu}</td><td>その他内容欄設定倍率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSonotanyrantmttkngktuktype sonotanyrantmttkngktuktype}</td><td>その他内容欄積立金額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSonotanyranteiritutmttkngk sonotanyranteiritutmttkngk}</td><td>その他内容欄定率積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSonotanyransisuutmttkngk sonotanyransisuutmttkngk}</td><td>その他内容欄指数積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSonotanyransisuunm sonotanyransisuunm}</td><td>その他内容欄指数名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKgmaehrtkdai1hknkknmnryymd kgmaehrtkdai1hknkknmnryymd}</td><td>介護前払特約第１保険期間満了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getNkmsgcd1 nkmsgcd1}</td><td>年金メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkmsgcd2 nkmsgcd2}</td><td>年金メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkmsgcd3 nkmsgcd3}</td><td>年金メッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkmsgcd4 nkmsgcd4}</td><td>年金メッセージコード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkmsgcd5 nkmsgcd5}</td><td>年金メッセージコード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkmsgcd6 nkmsgcd6}</td><td>年金メッセージコード６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkmsgcd7 nkmsgcd7}</td><td>年金メッセージコード７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkmsgcd8 nkmsgcd8}</td><td>年金メッセージコード８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkmsgcd9 nkmsgcd9}</td><td>年金メッセージコード９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkmsgcd10 nkmsgcd10}</td><td>年金メッセージコード１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiboukyuuhukinmsgcd1 siboukyuuhukinmsgcd1}</td><td>死亡給付金メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiboukyuuhukinmsgcd2 siboukyuuhukinmsgcd2}</td><td>死亡給付金メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiboukyuuhukinmsgcd3 siboukyuuhukinmsgcd3}</td><td>死亡給付金メッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiboukyuuhukinmsgcd4 siboukyuuhukinmsgcd4}</td><td>死亡給付金メッセージコード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiboukyuuhukinmsgcd5 siboukyuuhukinmsgcd5}</td><td>死亡給付金メッセージコード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiboukyuuhukinmsgcd6 siboukyuuhukinmsgcd6}</td><td>死亡給付金メッセージコード６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiboukyuuhukinmsgcd7 siboukyuuhukinmsgcd7}</td><td>死亡給付金メッセージコード７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiboukyuuhukinmsgcd8 siboukyuuhukinmsgcd8}</td><td>死亡給付金メッセージコード８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiboukyuuhukinmsgcd9 siboukyuuhukinmsgcd9}</td><td>死亡給付金メッセージコード９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiboukyuuhukinmsgcd10 siboukyuuhukinmsgcd10}</td><td>死亡給付金メッセージコード１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkshrstartzenymd nkshrstartzenymd}</td><td>年金支払開始日前日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMkhyouyennkhknhentktype mkhyouyennkhknhentktype}</td><td>目標到達時円建年金保険変更特約目標額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMkhyouyennkhknhentkmkhgk mkhyouyennkhknhentkmkhgk}</td><td>目標到達時円建年金保険変更特約目標額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMkhyouyennkhknhentkmkhwari mkhyouyennkhknhentkmkhwari}</td><td>目標到達時円建年金保険変更特約目標割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHaibunwarimsgcd1 haibunwarimsgcd1}</td><td>配分割合メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHaibunwarimsgcd2 haibunwarimsgcd2}</td><td>配分割合メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHaibunwarimsgcd3 haibunwarimsgcd3}</td><td>配分割合メッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTeiritutmtthbnwr teiritutmtthbnwr}</td><td>定率積立部分配分割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisuutmtthbnwr sisuutmtthbnwr}</td><td>指数積立部分配分割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisuuannaimsg1 sisuuannaimsg1}</td><td>指数案内メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSisuuannaimsg2 sisuuannaimsg2}</td><td>指数案内メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSisuuannaimsg3 sisuuannaimsg3}</td><td>指数案内メッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHutanhiyustmytijihiritu hutanhiyustmytijihiritu}</td><td>ご負担費用説明欄予定維持費率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWmsgcd21 wmsgcd21}</td><td>解約返戻金メッセージコード２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getWmsgcd22 wmsgcd22}</td><td>解約返戻金メッセージコード２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getWmsgcd23 wmsgcd23}</td><td>解約返戻金メッセージコード２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getWmsgcd31 wmsgcd31}</td><td>解約返戻金メッセージコード３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getWmsgcd32 wmsgcd32}</td><td>解約返戻金メッセージコード３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getWmsgcd33 wmsgcd33}</td><td>解約返戻金メッセージコード３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getWmsgcdst1 wmsgcdst1}</td><td>解約返戻金メッセージコード表下１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getWtyuuijikoumsgcd6 wtyuuijikoumsgcd6}</td><td>解約返戻金注意事項メッセージコード６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getWtyuuijikoumsgcd7 wtyuuijikoumsgcd7}</td><td>解約返戻金注意事項メッセージコード７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTantocd tantocd}</td><td>担当コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TantouCdKbn}</td></tr>
 *  <tr><td>{@link #getPhrkktuki phrkktuki}</td><td>保険料払込期月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYakkanjyuryouhoukbn yakkanjyuryouhoukbn}</td><td>約款受領方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YakkanJyuryouKbn}</td></tr>
 *  <tr><td>{@link #getYakkanbunsyono yakkanbunsyono}</td><td>約款文書番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiorino siorino}</td><td>しおり番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSioriwebuktriannaimsgcd sioriwebuktriannaimsgcd}</td><td>しおりＷＥＢ受取案内メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSagyoukbn sagyoukbn}</td><td>作業区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSisuuupkaisuu sisuuupkaisuu}</td><td>指数上昇回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisuudownkaisuu sisuudownkaisuu}</td><td>指数下落回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     IT_BAK_HokenSyouken
 * @see     PKIT_BAK_HokenSyouken
 * @see     QIT_BAK_HokenSyouken
 * @see     GenQIT_BAK_HokenSyouken
 */
@MappedSuperclass
@Table(name=GenIT_BAK_HokenSyouken.TABLE_NAME)
@IdClass(value=PKIT_BAK_HokenSyouken.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_AisyoumeiKbn", typeClass=UserType_C_AisyoumeiKbn.class),
    @TypeDef(name="UserType_C_Channelcd", typeClass=UserType_C_Channelcd.class),
    @TypeDef(name="UserType_C_HassouKbn", typeClass=UserType_C_HassouKbn.class),
    @TypeDef(name="UserType_C_Hhknsei", typeClass=UserType_C_Hhknsei.class),
    @TypeDef(name="UserType_C_InsizeiShryouhiKbn", typeClass=UserType_C_InsizeiShryouhiKbn.class),
    @TypeDef(name="UserType_C_KjkhukaKbn", typeClass=UserType_C_KjkhukaKbn.class),
    @TypeDef(name="UserType_C_SinsaihkKbn", typeClass=UserType_C_SinsaihkKbn.class),
    @TypeDef(name="UserType_C_SyoukenUktKbn", typeClass=UserType_C_SyoukenUktKbn.class),
    @TypeDef(name="UserType_C_SyoukenUktMidasiKbn", typeClass=UserType_C_SyoukenUktMidasiKbn.class),
    @TypeDef(name="UserType_C_SyoukensaihkKbn", typeClass=UserType_C_SyoukensaihkKbn.class),
    @TypeDef(name="UserType_C_TantouCdKbn", typeClass=UserType_C_TantouCdKbn.class),
    @TypeDef(name="UserType_C_TokusyuSyoriNaiyouKbn", typeClass=UserType_C_TokusyuSyoriNaiyouKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YakkanJyuryouKbn", typeClass=UserType_C_YakkanJyuryouKbn.class)
})
public abstract class GenIT_BAK_HokenSyouken extends AbstractExDBEntity<IT_BAK_HokenSyouken, PKIT_BAK_HokenSyouken> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_HokenSyouken";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String TYOUHYOUYMD              = "tyouhyouymd";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String SINSAIHKKBN              = "sinsaihkkbn";
    public static final String SYOUKENSAIHKKBN          = "syoukensaihkkbn";
    public static final String INSIZEISHRYOUHIKBN       = "insizeishryouhikbn";
    public static final String HASSOUKBN                = "hassoukbn";
    public static final String KOUJYOSYOUMEIUMUKBN      = "koujyosyoumeiumukbn";
    public static final String SUIIHYOUUMUKBN           = "suiihyouumukbn";
    public static final String KANRYOUTUUTIUMUKBN       = "kanryoutuutiumukbn";
    public static final String STDRSKTIRASIDOUHUUKBN    = "stdrsktirasidouhuukbn";
    public static final String DSTIRASIDOUHUUKBN        = "dstirasidouhuukbn";
    public static final String AISYOUMEIKBN             = "aisyoumeikbn";
    public static final String SYOTNSHUYOUPOSTUMUKBN    = "syotnshuyoupostumukbn";
    public static final String HYOUJIRANHIDARIMSGCD1    = "hyoujiranhidarimsgcd1";
    public static final String HYOUJIRANHIDARIMSGCD2    = "hyoujiranhidarimsgcd2";
    public static final String HYOUJIRANHIDARIMSGCD3    = "hyoujiranhidarimsgcd3";
    public static final String HYOUJIRANHIDARIMSGCD4    = "hyoujiranhidarimsgcd4";
    public static final String HYOUJIRANHIDARIMSGCD5    = "hyoujiranhidarimsgcd5";
    public static final String HYOUJIRANHIDARIMSGCD6    = "hyoujiranhidarimsgcd6";
    public static final String HYOUJIRANHIDARIMSGCD7    = "hyoujiranhidarimsgcd7";
    public static final String HYOUJIRANHIDARIMSGCD8    = "hyoujiranhidarimsgcd8";
    public static final String HYOUJIRANHIDARIMSGCD9    = "hyoujiranhidarimsgcd9";
    public static final String HYOUJIRANHIDARIMSGCD10   = "hyoujiranhidarimsgcd10";
    public static final String HYOUJIRANHIDARIMSGCD11   = "hyoujiranhidarimsgcd11";
    public static final String HYOUJIRANHIDARIMSGCD12   = "hyoujiranhidarimsgcd12";
    public static final String HYOUJIRANHIDARIMSGCD13   = "hyoujiranhidarimsgcd13";
    public static final String HYOUJIRANHIDARIMSGCD14   = "hyoujiranhidarimsgcd14";
    public static final String HYOUJIRANHIDARIMSGCD15   = "hyoujiranhidarimsgcd15";
    public static final String HYOUJIRANHIDARIMSGCD16   = "hyoujiranhidarimsgcd16";
    public static final String HYOUJIRANHIDARIMSGCD17   = "hyoujiranhidarimsgcd17";
    public static final String HYOUJIRANHIDARIMSGCD18   = "hyoujiranhidarimsgcd18";
    public static final String HYOUJIRANHIDARIMSGCD19   = "hyoujiranhidarimsgcd19";
    public static final String HYOUJIRANHIDARIMSGCD20   = "hyoujiranhidarimsgcd20";
    public static final String HYOUJIRANMIGIIMSGCD1     = "hyoujiranmigiimsgcd1";
    public static final String HYOUJIRANMIGIIMSGCD2     = "hyoujiranmigiimsgcd2";
    public static final String HYOUJIRANMIGIIMSGCD3     = "hyoujiranmigiimsgcd3";
    public static final String HYOUJIRANMIGIIMSGCD4     = "hyoujiranmigiimsgcd4";
    public static final String HYOUJIRANMIGIIMSGCD5     = "hyoujiranmigiimsgcd5";
    public static final String HYOUJIRANMIGIIMSGCD6     = "hyoujiranmigiimsgcd6";
    public static final String HYOUJIRANMIGIIMSGCD7     = "hyoujiranmigiimsgcd7";
    public static final String HYOUJIRANMIGIIMSGCD8     = "hyoujiranmigiimsgcd8";
    public static final String HYOUJIRANMIGIIMSGCD9     = "hyoujiranmigiimsgcd9";
    public static final String HYOUJIRANMIGIIMSGCD10    = "hyoujiranmigiimsgcd10";
    public static final String HYOUJIRANMIGIIMSGCD11    = "hyoujiranmigiimsgcd11";
    public static final String HYOUJIRANMIGIIMSGCD12    = "hyoujiranmigiimsgcd12";
    public static final String HYOUJIRANMIGIIMSGCD13    = "hyoujiranmigiimsgcd13";
    public static final String HYOUJIRANMIGIIMSGCD14    = "hyoujiranmigiimsgcd14";
    public static final String HYOUJIRANMIGIIMSGCD15    = "hyoujiranmigiimsgcd15";
    public static final String HYOUJIRANMIGIIMSGCD16    = "hyoujiranmigiimsgcd16";
    public static final String HYOUJIRANMIGIIMSGCD17    = "hyoujiranmigiimsgcd17";
    public static final String HYOUJIRANMIGIIMSGCD18    = "hyoujiranmigiimsgcd18";
    public static final String HYOUJIRANMIGIIMSGCD19    = "hyoujiranmigiimsgcd19";
    public static final String HYOUJIRANMIGIIMSGCD20    = "hyoujiranmigiimsgcd20";
    public static final String HYOUJIRANSKNNKAISIYMD    = "hyoujiransknnkaisiymd";
    public static final String HYOUJIRANYOTEIRIRITU     = "hyoujiranyoteiriritu";
    public static final String HYOUJIRANSJKKKTUSIRRT    = "hyoujiransjkkktusirrt";
    public static final String HKNSYUKIGOU              = "hknsyukigou";
    public static final String SYOHAKKOUYMD             = "syohakkouymd";
    public static final String HANBAINM                 = "hanbainm";
    public static final String SEISIKIHKNNM             = "seisikihknnm";
    public static final String KOURYOKUKAISIYMD         = "kouryokukaisiymd";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String KYKNMKJKHUKAKBN          = "kyknmkjkhukakbn";
    public static final String HHKNNMKJ                 = "hhknnmkj";
    public static final String HHKNNMKJKHUKAKBN         = "hhknnmkjkhukakbn";
    public static final String HHKNSEIYMD               = "hhknseiymd";
    public static final String HHKNSEI                  = "hhknsei";
    public static final String HHKNNEN                  = "hhknnen";
    public static final String SYOUKENUKTMIDASIKBN1     = "syoukenuktmidasikbn1";
    public static final String SYOUKENUKTKBN1           = "syoukenuktkbn1";
    public static final String SYOUKENUKTNM1            = "syoukenuktnm1";
    public static final String SYOUKENUKTBNWARI1        = "syoukenuktbnwari1";
    public static final String SYOUKENUKTMIDASIKBN2     = "syoukenuktmidasikbn2";
    public static final String SYOUKENUKTKBN2           = "syoukenuktkbn2";
    public static final String SYOUKENUKTNM2            = "syoukenuktnm2";
    public static final String SYOUKENUKTBNWARI2        = "syoukenuktbnwari2";
    public static final String SYOUKENUKTMIDASIKBN3     = "syoukenuktmidasikbn3";
    public static final String SYOUKENUKTKBN3           = "syoukenuktkbn3";
    public static final String SYOUKENUKTNM3            = "syoukenuktnm3";
    public static final String SYOUKENUKTBNWARI3        = "syoukenuktbnwari3";
    public static final String SYOUKENUKTMIDASIKBN4     = "syoukenuktmidasikbn4";
    public static final String SYOUKENUKTKBN4           = "syoukenuktkbn4";
    public static final String SYOUKENUKTNM4            = "syoukenuktnm4";
    public static final String SYOUKENUKTBNWARI4        = "syoukenuktbnwari4";
    public static final String SYOUKENUKTMIDASIKBN5     = "syoukenuktmidasikbn5";
    public static final String SYOUKENUKTKBN5           = "syoukenuktkbn5";
    public static final String SYOUKENUKTNM5            = "syoukenuktnm5";
    public static final String SYOUKENUKTBNWARI5        = "syoukenuktbnwari5";
    public static final String SYOUKENUKTMIDASIKBN6     = "syoukenuktmidasikbn6";
    public static final String SYOUKENUKTKBN6           = "syoukenuktkbn6";
    public static final String SYOUKENUKTNM6            = "syoukenuktnm6";
    public static final String SYOUKENUKTBNWARI6        = "syoukenuktbnwari6";
    public static final String SYOUKENUKTMIDASIKBN7     = "syoukenuktmidasikbn7";
    public static final String SYOUKENUKTKBN7           = "syoukenuktkbn7";
    public static final String SYOUKENUKTNM7            = "syoukenuktnm7";
    public static final String SYOUKENUKTBNWARI7        = "syoukenuktbnwari7";
    public static final String SYOUKENUKTMIDASIKBN8     = "syoukenuktmidasikbn8";
    public static final String SYOUKENUKTKBN8           = "syoukenuktkbn8";
    public static final String SYOUKENUKTNM8            = "syoukenuktnm8";
    public static final String SYOUKENUKTBNWARI8        = "syoukenuktbnwari8";
    public static final String SYOUKENUKTMIDASIKBN9     = "syoukenuktmidasikbn9";
    public static final String SYOUKENUKTKBN9           = "syoukenuktkbn9";
    public static final String SYOUKENUKTNM9            = "syoukenuktnm9";
    public static final String SYOUKENUKTBNWARI9        = "syoukenuktbnwari9";
    public static final String SYOUKENUKTMIDASIKBN10    = "syoukenuktmidasikbn10";
    public static final String SYOUKENUKTKBN10          = "syoukenuktkbn10";
    public static final String SYOUKENUKTNM10           = "syoukenuktnm10";
    public static final String SYOUKENUKTBNWARI10       = "syoukenuktbnwari10";
    public static final String PMSGCD1                  = "pmsgcd1";
    public static final String PMSGCD2                  = "pmsgcd2";
    public static final String PMSGCD3                  = "pmsgcd3";
    public static final String PTUUKATYPE               = "ptuukatype";
    public static final String HOKENRYOU                = "hokenryou";
    public static final String PTUUKA                   = "ptuuka";
    public static final String PTOKUYAKUMSGCD           = "ptokuyakumsgcd";
    public static final String KYKYMD                   = "kykymd";
    public static final String PHRKKKNMIDASIKBN         = "phrkkknmidasikbn";
    public static final String HRKKKNMSGKBN             = "hrkkknmsgkbn";
    public static final String HRKKAISUUMSGKBN          = "hrkkaisuumsgkbn";
    public static final String HRKKITUKIMSGKBN          = "hrkkitukimsgkbn";
    public static final String HRKHOUHOUMSGKBN          = "hrkhouhoumsgkbn";
    public static final String SYUKYKTKYKRENBAN1        = "syukyktkykrenban1";
    public static final String SYUKYKTKYKMSGKBN1        = "syukyktkykmsgkbn1";
    public static final String SYUKYKTKYKSMSGKBN1       = "syukyktkyksmsgkbn1";
    public static final String SYUKYKTKYKHKNKKNMSGKBN1  = "syukyktkykhknkknmsgkbn1";
    public static final String SYUKYKTKYKSTUUKATYPE1    = "syukyktkykstuukatype1";
    public static final String SYUKYKTKYKHKNKNGK1       = "syukyktkykhknkngk1";
    public static final String SYUKYKTKYKDAI1HKNKKN1    = "syukyktkykdai1hknkkn1";
    public static final String SYUKYKTKYKDAI2HKNKKN1    = "syukyktkykdai2hknkkn1";
    public static final String SYUTKDAI1HKNKKNYMDTO1    = "syutkdai1hknkknymdto1";
    public static final String SYUTKDAI2HKNKKNYMDTO1    = "syutkdai2hknkknymdto1";
    public static final String SYUKYKTKYKRENBAN2        = "syukyktkykrenban2";
    public static final String SYUKYKTKYKMSGKBN2        = "syukyktkykmsgkbn2";
    public static final String SYUKYKTKYKSMSGKBN2       = "syukyktkyksmsgkbn2";
    public static final String SYUKYKTKYKHKNKKNMSGKBN2  = "syukyktkykhknkknmsgkbn2";
    public static final String SYUKYKTKYKSTUUKATYPE2    = "syukyktkykstuukatype2";
    public static final String SYUKYKTKYKHKNKNGK2       = "syukyktkykhknkngk2";
    public static final String SYUKYKTKYKDAI1HKNKKN2    = "syukyktkykdai1hknkkn2";
    public static final String SYUKYKTKYKDAI2HKNKKN2    = "syukyktkykdai2hknkkn2";
    public static final String SYUTKDAI1HKNKKNYMDTO2    = "syutkdai1hknkknymdto2";
    public static final String SYUTKDAI2HKNKKNYMDTO2    = "syutkdai2hknkknymdto2";
    public static final String SYUKYKTKYKRENBAN3        = "syukyktkykrenban3";
    public static final String SYUKYKTKYKMSGKBN3        = "syukyktkykmsgkbn3";
    public static final String SYUKYKTKYKSMSGKBN3       = "syukyktkyksmsgkbn3";
    public static final String SYUKYKTKYKHKNKKNMSGKBN3  = "syukyktkykhknkknmsgkbn3";
    public static final String SYUKYKTKYKSTUUKATYPE3    = "syukyktkykstuukatype3";
    public static final String SYUKYKTKYKHKNKNGK3       = "syukyktkykhknkngk3";
    public static final String SYUKYKTKYKDAI1HKNKKN3    = "syukyktkykdai1hknkkn3";
    public static final String SYUKYKTKYKDAI2HKNKKN3    = "syukyktkykdai2hknkkn3";
    public static final String SYUTKDAI1HKNKKNYMDTO3    = "syutkdai1hknkknymdto3";
    public static final String SYUTKDAI2HKNKKNYMDTO3    = "syutkdai2hknkknymdto3";
    public static final String SYUKYKTKYKRENBAN4        = "syukyktkykrenban4";
    public static final String SYUKYKTKYKMSGKBN4        = "syukyktkykmsgkbn4";
    public static final String SYUKYKTKYKSMSGKBN4       = "syukyktkyksmsgkbn4";
    public static final String SYUKYKTKYKHKNKKNMSGKBN4  = "syukyktkykhknkknmsgkbn4";
    public static final String SYUKYKTKYKSTUUKATYPE4    = "syukyktkykstuukatype4";
    public static final String SYUKYKTKYKHKNKNGK4       = "syukyktkykhknkngk4";
    public static final String SYUKYKTKYKDAI1HKNKKN4    = "syukyktkykdai1hknkkn4";
    public static final String SYUKYKTKYKDAI2HKNKKN4    = "syukyktkykdai2hknkkn4";
    public static final String SYUTKDAI1HKNKKNYMDTO4    = "syutkdai1hknkknymdto4";
    public static final String SYUTKDAI2HKNKKNYMDTO4    = "syutkdai2hknkknymdto4";
    public static final String SYUKYKTKYKRENBAN5        = "syukyktkykrenban5";
    public static final String SYUKYKTKYKMSGKBN5        = "syukyktkykmsgkbn5";
    public static final String SYUKYKTKYKSMSGKBN5       = "syukyktkyksmsgkbn5";
    public static final String SYUKYKTKYKHKNKKNMSGKBN5  = "syukyktkykhknkknmsgkbn5";
    public static final String SYUKYKTKYKSTUUKATYPE5    = "syukyktkykstuukatype5";
    public static final String SYUKYKTKYKHKNKNGK5       = "syukyktkykhknkngk5";
    public static final String SYUKYKTKYKDAI1HKNKKN5    = "syukyktkykdai1hknkkn5";
    public static final String SYUKYKTKYKDAI2HKNKKN5    = "syukyktkykdai2hknkkn5";
    public static final String SYUTKDAI1HKNKKNYMDTO5    = "syutkdai1hknkknymdto5";
    public static final String SYUTKDAI2HKNKKNYMDTO5    = "syutkdai2hknkknymdto5";
    public static final String SYUKYKTKYKRENBAN6        = "syukyktkykrenban6";
    public static final String SYUKYKTKYKMSGKBN6        = "syukyktkykmsgkbn6";
    public static final String SYUKYKTKYKSMSGKBN6       = "syukyktkyksmsgkbn6";
    public static final String SYUKYKTKYKHKNKKNMSGKBN6  = "syukyktkykhknkknmsgkbn6";
    public static final String SYUKYKTKYKSTUUKATYPE6    = "syukyktkykstuukatype6";
    public static final String SYUKYKTKYKHKNKNGK6       = "syukyktkykhknkngk6";
    public static final String SYUKYKTKYKDAI1HKNKKN6    = "syukyktkykdai1hknkkn6";
    public static final String SYUKYKTKYKDAI2HKNKKN6    = "syukyktkykdai2hknkkn6";
    public static final String SYUTKDAI1HKNKKNYMDTO6    = "syutkdai1hknkknymdto6";
    public static final String SYUTKDAI2HKNKKNYMDTO6    = "syutkdai2hknkknymdto6";
    public static final String SYUKYKTKYKRENBAN7        = "syukyktkykrenban7";
    public static final String SYUKYKTKYKMSGKBN7        = "syukyktkykmsgkbn7";
    public static final String SYUKYKTKYKSMSGKBN7       = "syukyktkyksmsgkbn7";
    public static final String SYUKYKTKYKHKNKKNMSGKBN7  = "syukyktkykhknkknmsgkbn7";
    public static final String SYUKYKTKYKSTUUKATYPE7    = "syukyktkykstuukatype7";
    public static final String SYUKYKTKYKHKNKNGK7       = "syukyktkykhknkngk7";
    public static final String SYUKYKTKYKDAI1HKNKKN7    = "syukyktkykdai1hknkkn7";
    public static final String SYUKYKTKYKDAI2HKNKKN7    = "syukyktkykdai2hknkkn7";
    public static final String SYUTKDAI1HKNKKNYMDTO7    = "syutkdai1hknkknymdto7";
    public static final String SYUTKDAI2HKNKKNYMDTO7    = "syutkdai2hknkknymdto7";
    public static final String SYUKYKTKYKRENBAN8        = "syukyktkykrenban8";
    public static final String SYUKYKTKYKMSGKBN8        = "syukyktkykmsgkbn8";
    public static final String SYUKYKTKYKSMSGKBN8       = "syukyktkyksmsgkbn8";
    public static final String SYUKYKTKYKHKNKKNMSGKBN8  = "syukyktkykhknkknmsgkbn8";
    public static final String SYUKYKTKYKSTUUKATYPE8    = "syukyktkykstuukatype8";
    public static final String SYUKYKTKYKHKNKNGK8       = "syukyktkykhknkngk8";
    public static final String SYUKYKTKYKDAI1HKNKKN8    = "syukyktkykdai1hknkkn8";
    public static final String SYUKYKTKYKDAI2HKNKKN8    = "syukyktkykdai2hknkkn8";
    public static final String SYUTKDAI1HKNKKNYMDTO8    = "syutkdai1hknkknymdto8";
    public static final String SYUTKDAI2HKNKKNYMDTO8    = "syutkdai2hknkknymdto8";
    public static final String SYUKYKTKYKRENBAN9        = "syukyktkykrenban9";
    public static final String SYUKYKTKYKMSGKBN9        = "syukyktkykmsgkbn9";
    public static final String SYUKYKTKYKSMSGKBN9       = "syukyktkyksmsgkbn9";
    public static final String SYUKYKTKYKHKNKKNMSGKBN9  = "syukyktkykhknkknmsgkbn9";
    public static final String SYUKYKTKYKSTUUKATYPE9    = "syukyktkykstuukatype9";
    public static final String SYUKYKTKYKHKNKNGK9       = "syukyktkykhknkngk9";
    public static final String SYUKYKTKYKDAI1HKNKKN9    = "syukyktkykdai1hknkkn9";
    public static final String SYUKYKTKYKDAI2HKNKKN9    = "syukyktkykdai2hknkkn9";
    public static final String SYUTKDAI1HKNKKNYMDTO9    = "syutkdai1hknkknymdto9";
    public static final String SYUTKDAI2HKNKKNYMDTO9    = "syutkdai2hknkknymdto9";
    public static final String SYUKYKTKYKRENBAN10       = "syukyktkykrenban10";
    public static final String SYUKYKTKYKMSGKBN10       = "syukyktkykmsgkbn10";
    public static final String SYUKYKTKYKSMSGKBN10      = "syukyktkyksmsgkbn10";
    public static final String SYUKYKTKYKHKNKKNMSGKBN10 = "syukyktkykhknkknmsgkbn10";
    public static final String SYUKYKTKYKSTUUKATYPE10   = "syukyktkykstuukatype10";
    public static final String SYUKYKTKYKHKNKNGK10      = "syukyktkykhknkngk10";
    public static final String SYUKYKTKYKDAI1HKNKKN10   = "syukyktkykdai1hknkkn10";
    public static final String SYUKYKTKYKDAI2HKNKKN10   = "syukyktkykdai2hknkkn10";
    public static final String SYUTKDAI1HKNKKNYMDTO10   = "syutkdai1hknkknymdto10";
    public static final String SYUTKDAI2HKNKKNYMDTO10   = "syutkdai2hknkknymdto10";
    public static final String KYKNIYUSTMSGCD1          = "kykniyustmsgcd1";
    public static final String KYKNIYUSTMSGCD2          = "kykniyustmsgcd2";
    public static final String KYKNIYUSTMSGCD3          = "kykniyustmsgcd3";
    public static final String KYKNIYUSTMSGCD4          = "kykniyustmsgcd4";
    public static final String KYKNIYUSTMSGCD5          = "kykniyustmsgcd5";
    public static final String KYKNIYUSTMSGCD6          = "kykniyustmsgcd6";
    public static final String KYKNIYUSTMSGCD7          = "kykniyustmsgcd7";
    public static final String KYKNIYUSTMSGCD8          = "kykniyustmsgcd8";
    public static final String KYKNIYUSTMSGCD9          = "kykniyustmsgcd9";
    public static final String KYKNIYUSTMSGCD10         = "kykniyustmsgcd10";
    public static final String KYKNIYUSTMSGCD11         = "kykniyustmsgcd11";
    public static final String KYKNIYUSTMSGCD12         = "kykniyustmsgcd12";
    public static final String KYKNIYUSTMSGCD13         = "kykniyustmsgcd13";
    public static final String KYKNIYUSTMSGCD14         = "kykniyustmsgcd14";
    public static final String KYKNIYUSTMSGCD15         = "kykniyustmsgcd15";
    public static final String KYKNIYUSTITJBRPTUUKTYPE  = "kykniyustitjbrptuuktype";
    public static final String KYKNIYUSTITJBRP          = "kykniyustitjbrp";
    public static final String STNAIYOURANMSGCD1        = "stnaiyouranmsgcd1";
    public static final String STNAIYOURANMSGCD2        = "stnaiyouranmsgcd2";
    public static final String STNAIYOURANMSGCD3        = "stnaiyouranmsgcd3";
    public static final String STNAIYOURANMSGCD4        = "stnaiyouranmsgcd4";
    public static final String STNAIYOURANMSGCD5        = "stnaiyouranmsgcd5";
    public static final String STNAIYOURANMSGCD6        = "stnaiyouranmsgcd6";
    public static final String STNAIYOURANMSGCD7        = "stnaiyouranmsgcd7";
    public static final String STNAIYOURANMSGCD8        = "stnaiyouranmsgcd8";
    public static final String STNAIYOURANMSGCD9        = "stnaiyouranmsgcd9";
    public static final String STNAIYOURANMSGCD10       = "stnaiyouranmsgcd10";
    public static final String STNAIYOURANMSGCD11       = "stnaiyouranmsgcd11";
    public static final String STNAIYOURANMSGCD12       = "stnaiyouranmsgcd12";
    public static final String STNAIYOURANMSGCD13       = "stnaiyouranmsgcd13";
    public static final String STNAIYOURANMSGCD14       = "stnaiyouranmsgcd14";
    public static final String STNAIYOURANMSGCD15       = "stnaiyouranmsgcd15";
    public static final String STNAIYOURANMSGCD16       = "stnaiyouranmsgcd16";
    public static final String STNAIYOURANMSGCD17       = "stnaiyouranmsgcd17";
    public static final String STNAIYOURANMSGCD18       = "stnaiyouranmsgcd18";
    public static final String STNAIYOURANMSGCD19       = "stnaiyouranmsgcd19";
    public static final String STNAIYOURANMSGCD20       = "stnaiyouranmsgcd20";
    public static final String SONOTANYRANSITEITUUKA    = "sonotanyransiteituuka";
    public static final String SONOTANYRANNYKNTUKTYPE   = "sonotanyrannykntuktype";
    public static final String SONOTANYRANNYKNTUUKAP    = "sonotanyrannykntuukap";
    public static final String SONOTANYRANNYKNTUUKASYU  = "sonotanyrannykntuukasyu";
    public static final String SONOTANYRANENKHRIKMRATE  = "sonotanyranenkhrikmrate";
    public static final String SONOTANYRANSTIGIKWSRATE  = "sonotanyranstigikwsrate";
    public static final String SONOTANYRANKJNKNGKTUKTYPE = "sonotanyrankjnkngktuktype";
    public static final String SONOTANYRANKJNKNGK       = "sonotanyrankjnkngk";
    public static final String SONOTANYRANKJNKNGKRATE   = "sonotanyrankjnkngkrate";
    public static final String SONOTANYRANKJNKNGKTUUKA  = "sonotanyrankjnkngktuuka";
    public static final String SONOTANYRANPENTUKTYPE    = "sonotanyranpentuktype";
    public static final String SONOTANYRANPENKNSNGK     = "sonotanyranpenknsngk";
    public static final String SONOTANYRANMKHWARIAI     = "sonotanyranmkhwariai";
    public static final String SONOTANYRANYTIRRT        = "sonotanyranytirrt";
    public static final String SONOTANYRANSJKKKTUSIRRT  = "sonotanyransjkkktusirrt";
    public static final String STNAIYOURANGAIMSGCD      = "stnaiyourangaimsgcd";
    public static final String TSINYNO                  = "tsinyno";
    public static final String TSINADR1KJ               = "tsinadr1kj";
    public static final String TSINADR2KJ               = "tsinadr2kj";
    public static final String TSINADR3KJ               = "tsinadr3kj";
    public static final String SHSNMKJ                  = "shsnmkj";
    public static final String TNKNMISSMSG              = "tnknmissmsg";
    public static final String ERRORMSGCD               = "errormsgcd";
    public static final String SISYACD                  = "sisyacd";
    public static final String DUHUTUSNRNTOUSAADRMSGCD  = "duhutusnrntousaadrmsgcd";
    public static final String DUHUTUSNRNSYONO          = "duhutusnrnsyono";
    public static final String CHANNELCD                = "channelcd";
    public static final String DAIRITENMIDASIKBN        = "dairitenmidasikbn";
    public static final String DRTENNM1KJ               = "drtennm1kj";
    public static final String DRTENNM2KJ               = "drtennm2kj";
    public static final String AISATUMSGCD              = "aisatumsgcd";
    public static final String CCMSGCD                  = "ccmsgcd";
    public static final String HSKMSGCD                 = "hskmsgcd";
    public static final String HOSYOUNYMSGCD            = "hosyounymsgcd";
    public static final String HOSYOUNYHIHKNSYAMEIKANJI = "hosyounyhihknsyameikanji";
    public static final String SIBOUMIDASIMSGCD         = "siboumidasimsgcd";
    public static final String SIBOUMIDASIMSGCD2        = "siboumidasimsgcd2";
    public static final String SIBOUDAI1HKNKKNMSGCD1    = "siboudai1hknkknmsgcd1";
    public static final String SIBOUDAI1HKNKKNMSGCD2    = "siboudai1hknkknmsgcd2";
    public static final String SIBOUDAI1HKNKKNIGIMSGCD  = "siboudai1hknkknigimsgcd";
    public static final String SIBOUDAI1HKNKKNIGIMSGCD2 = "siboudai1hknkknigimsgcd2";
    public static final String SIBOUDAI1HKNKKNHRSMSGCD  = "siboudai1hknkknhrsmsgcd";
    public static final String SIBOUDAI1HKNKKNHRSMSGCD2 = "siboudai1hknkknhrsmsgcd2";
    public static final String SIBOUDAI1HKNKKNSMRMSGCD  = "siboudai1hknkknsmrmsgcd";
    public static final String SIBOUDAI2HKNKKNMSGCD1    = "siboudai2hknkknmsgcd1";
    public static final String SIBOUDAI2HKNKKNMSGCD2    = "siboudai2hknkknmsgcd2";
    public static final String SIBOUDAI2HKNKKNSMSGCD    = "siboudai2hknkknsmsgcd";
    public static final String SIBOUDAI2HKNKKNSMSGCD2   = "siboudai2hknkknsmsgcd2";
    public static final String SIBOUDAI3HKNKKNMSGCD1    = "siboudai3hknkknmsgcd1";
    public static final String SIBOUDAI3HKNKKNMSGCD2    = "siboudai3hknkknmsgcd2";
    public static final String SIBOUDAI1HKNKKN          = "siboudai1hknkkn";
    public static final String SIBOUDAI1HKNKKNYMDTO     = "siboudai1hknkknymdto";
    public static final String SIBOUITJBRPYENTUUKTYPE   = "sibouitjbrpyentuuktype";
    public static final String SIBOUITJBRPYENTUUKGK     = "sibouitjbrpyentuukgk";
    public static final String SIBOUDAI1KJNKNGKTUUKTYPE = "siboudai1kjnkngktuuktype";
    public static final String SIBOUDAI1KJNKNGK         = "siboudai1kjnkngk";
    public static final String SIBOUDAI2HKNKKN          = "siboudai2hknkkn";
    public static final String SIBOUDAI2HKNKKNYMDTO     = "siboudai2hknkknymdto";
    public static final String SIBOUDAI2KJNKNGKTUUKTYPE = "siboudai2kjnkngktuuktype";
    public static final String SIBOUDAI2KJNKNGK         = "siboudai2kjnkngk";
    public static final String SIBOUDAI3KJNKNGKTUUKTYPE = "siboudai3kjnkngktuuktype";
    public static final String SIBOUDAI3KJNKNGK         = "siboudai3kjnkngk";
    public static final String DAI1SKWSRATEYENDAKA      = "dai1skwsrateyendaka";
    public static final String DAI1SKWSRATEYENKIJYUN    = "dai1skwsrateyenkijyun";
    public static final String DAI1SKWSRATEYENYASU      = "dai1skwsrateyenyasu";
    public static final String DAI1SKEIKANENSUU01       = "dai1skeikanensuu01";
    public static final String DAI1SIBOUSNENOUTOUYMD01  = "dai1sibousnenoutouymd01";
    public static final String DAI1STUUKTYPE01          = "dai1stuuktype01";
    public static final String DAI1S01                  = "dai1s01";
    public static final String DAI1SYENYENDAKAUMU01     = "dai1syenyendakaumu01";
    public static final String DAI1SYENYENKIJYUNUMU01   = "dai1syenyenkijyunumu01";
    public static final String DAI1SYENYENYASUUMU01     = "dai1syenyenyasuumu01";
    public static final String DAI1SYENTUUKTYPE01       = "dai1syentuuktype01";
    public static final String DAI1SYENYENDAKA01        = "dai1syenyendaka01";
    public static final String DAI1SYENYENKIJYUN01      = "dai1syenyenkijyun01";
    public static final String DAI1SYENYENYASU01        = "dai1syenyenyasu01";
    public static final String DAI1SKEIKANENSUU02       = "dai1skeikanensuu02";
    public static final String DAI1SIBOUSNENOUTOUYMD02  = "dai1sibousnenoutouymd02";
    public static final String DAI1STUUKTYPE02          = "dai1stuuktype02";
    public static final String DAI1S02                  = "dai1s02";
    public static final String DAI1SYENYENDAKAUMU02     = "dai1syenyendakaumu02";
    public static final String DAI1SYENYENKIJYUNUMU02   = "dai1syenyenkijyunumu02";
    public static final String DAI1SYENYENYASUUMU02     = "dai1syenyenyasuumu02";
    public static final String DAI1SYENTUUKTYPE02       = "dai1syentuuktype02";
    public static final String DAI1SYENYENDAKA02        = "dai1syenyendaka02";
    public static final String DAI1SYENYENKIJYUN02      = "dai1syenyenkijyun02";
    public static final String DAI1SYENYENYASU02        = "dai1syenyenyasu02";
    public static final String DAI1SKEIKANENSUU03       = "dai1skeikanensuu03";
    public static final String DAI1SIBOUSNENOUTOUYMD03  = "dai1sibousnenoutouymd03";
    public static final String DAI1STUUKTYPE03          = "dai1stuuktype03";
    public static final String DAI1S03                  = "dai1s03";
    public static final String DAI1SYENYENDAKAUMU03     = "dai1syenyendakaumu03";
    public static final String DAI1SYENYENKIJYUNUMU03   = "dai1syenyenkijyunumu03";
    public static final String DAI1SYENYENYASUUMU03     = "dai1syenyenyasuumu03";
    public static final String DAI1SYENTUUKTYPE03       = "dai1syentuuktype03";
    public static final String DAI1SYENYENDAKA03        = "dai1syenyendaka03";
    public static final String DAI1SYENYENKIJYUN03      = "dai1syenyenkijyun03";
    public static final String DAI1SYENYENYASU03        = "dai1syenyenyasu03";
    public static final String DAI1SKEIKANENSUU04       = "dai1skeikanensuu04";
    public static final String DAI1SIBOUSNENOUTOUYMD04  = "dai1sibousnenoutouymd04";
    public static final String DAI1STUUKTYPE04          = "dai1stuuktype04";
    public static final String DAI1S04                  = "dai1s04";
    public static final String DAI1SYENYENDAKAUMU04     = "dai1syenyendakaumu04";
    public static final String DAI1SYENYENKIJYUNUMU04   = "dai1syenyenkijyunumu04";
    public static final String DAI1SYENYENYASUUMU04     = "dai1syenyenyasuumu04";
    public static final String DAI1SYENTUUKTYPE04       = "dai1syentuuktype04";
    public static final String DAI1SYENYENDAKA04        = "dai1syenyendaka04";
    public static final String DAI1SYENYENKIJYUN04      = "dai1syenyenkijyun04";
    public static final String DAI1SYENYENYASU04        = "dai1syenyenyasu04";
    public static final String DAI1SKEIKANENSUU05       = "dai1skeikanensuu05";
    public static final String DAI1SIBOUSNENOUTOUYMD05  = "dai1sibousnenoutouymd05";
    public static final String DAI1STUUKTYPE05          = "dai1stuuktype05";
    public static final String DAI1S05                  = "dai1s05";
    public static final String DAI1SYENYENDAKAUMU05     = "dai1syenyendakaumu05";
    public static final String DAI1SYENYENKIJYUNUMU05   = "dai1syenyenkijyunumu05";
    public static final String DAI1SYENYENYASUUMU05     = "dai1syenyenyasuumu05";
    public static final String DAI1SYENTUUKTYPE05       = "dai1syentuuktype05";
    public static final String DAI1SYENYENDAKA05        = "dai1syenyendaka05";
    public static final String DAI1SYENYENKIJYUN05      = "dai1syenyenkijyun05";
    public static final String DAI1SYENYENYASU05        = "dai1syenyenyasu05";
    public static final String DAI1SKEIKANENSUU06       = "dai1skeikanensuu06";
    public static final String DAI1SIBOUSNENOUTOUYMD06  = "dai1sibousnenoutouymd06";
    public static final String DAI1STUUKTYPE06          = "dai1stuuktype06";
    public static final String DAI1S06                  = "dai1s06";
    public static final String DAI1SYENYENDAKAUMU06     = "dai1syenyendakaumu06";
    public static final String DAI1SYENYENKIJYUNUMU06   = "dai1syenyenkijyunumu06";
    public static final String DAI1SYENYENYASUUMU06     = "dai1syenyenyasuumu06";
    public static final String DAI1SYENTUUKTYPE06       = "dai1syentuuktype06";
    public static final String DAI1SYENYENDAKA06        = "dai1syenyendaka06";
    public static final String DAI1SYENYENKIJYUN06      = "dai1syenyenkijyun06";
    public static final String DAI1SYENYENYASU06        = "dai1syenyenyasu06";
    public static final String DAI1SKEIKANENSUU07       = "dai1skeikanensuu07";
    public static final String DAI1SIBOUSNENOUTOUYMD07  = "dai1sibousnenoutouymd07";
    public static final String DAI1STUUKTYPE07          = "dai1stuuktype07";
    public static final String DAI1S07                  = "dai1s07";
    public static final String DAI1SYENYENDAKAUMU07     = "dai1syenyendakaumu07";
    public static final String DAI1SYENYENKIJYUNUMU07   = "dai1syenyenkijyunumu07";
    public static final String DAI1SYENYENYASUUMU07     = "dai1syenyenyasuumu07";
    public static final String DAI1SYENTUUKTYPE07       = "dai1syentuuktype07";
    public static final String DAI1SYENYENDAKA07        = "dai1syenyendaka07";
    public static final String DAI1SYENYENKIJYUN07      = "dai1syenyenkijyun07";
    public static final String DAI1SYENYENYASU07        = "dai1syenyenyasu07";
    public static final String DAI1SKEIKANENSUU08       = "dai1skeikanensuu08";
    public static final String DAI1SIBOUSNENOUTOUYMD08  = "dai1sibousnenoutouymd08";
    public static final String DAI1STUUKTYPE08          = "dai1stuuktype08";
    public static final String DAI1S08                  = "dai1s08";
    public static final String DAI1SYENYENDAKAUMU08     = "dai1syenyendakaumu08";
    public static final String DAI1SYENYENKIJYUNUMU08   = "dai1syenyenkijyunumu08";
    public static final String DAI1SYENYENYASUUMU08     = "dai1syenyenyasuumu08";
    public static final String DAI1SYENTUUKTYPE08       = "dai1syentuuktype08";
    public static final String DAI1SYENYENDAKA08        = "dai1syenyendaka08";
    public static final String DAI1SYENYENKIJYUN08      = "dai1syenyenkijyun08";
    public static final String DAI1SYENYENYASU08        = "dai1syenyenyasu08";
    public static final String DAI1SKEIKANENSUU09       = "dai1skeikanensuu09";
    public static final String DAI1SIBOUSNENOUTOUYMD09  = "dai1sibousnenoutouymd09";
    public static final String DAI1STUUKTYPE09          = "dai1stuuktype09";
    public static final String DAI1S09                  = "dai1s09";
    public static final String DAI1SYENYENDAKAUMU09     = "dai1syenyendakaumu09";
    public static final String DAI1SYENYENKIJYUNUMU09   = "dai1syenyenkijyunumu09";
    public static final String DAI1SYENYENYASUUMU09     = "dai1syenyenyasuumu09";
    public static final String DAI1SYENTUUKTYPE09       = "dai1syentuuktype09";
    public static final String DAI1SYENYENDAKA09        = "dai1syenyendaka09";
    public static final String DAI1SYENYENKIJYUN09      = "dai1syenyenkijyun09";
    public static final String DAI1SYENYENYASU09        = "dai1syenyenyasu09";
    public static final String DAI1SKEIKANENSUU10       = "dai1skeikanensuu10";
    public static final String DAI1SIBOUSNENOUTOUYMD10  = "dai1sibousnenoutouymd10";
    public static final String DAI1STUUKTYPE10          = "dai1stuuktype10";
    public static final String DAI1S10                  = "dai1s10";
    public static final String DAI1SYENYENDAKAUMU10     = "dai1syenyendakaumu10";
    public static final String DAI1SYENYENKIJYUNUMU10   = "dai1syenyenkijyunumu10";
    public static final String DAI1SYENYENYASUUMU10     = "dai1syenyenyasuumu10";
    public static final String DAI1SYENTUUKTYPE10       = "dai1syentuuktype10";
    public static final String DAI1SYENYENDAKA10        = "dai1syenyendaka10";
    public static final String DAI1SYENYENKIJYUN10      = "dai1syenyenkijyun10";
    public static final String DAI1SYENYENYASU10        = "dai1syenyenyasu10";
    public static final String DAI1STUUKTYPEHURYO       = "dai1stuuktypehuryo";
    public static final String DAI1SHURYO               = "dai1shuryo";
    public static final String DAI1SYENYENDAKAUMUHURYO  = "dai1syenyendakaumuhuryo";
    public static final String DAI1SYENYENKJNUMUHURYO   = "dai1syenyenkjnumuhuryo";
    public static final String DAI1SYENYENYASUUMUHURYO  = "dai1syenyenyasuumuhuryo";
    public static final String DAI1SYENTUUKTYPEHURYO    = "dai1syentuuktypehuryo";
    public static final String DAI1SYENYENDAKAHURYO     = "dai1syenyendakahuryo";
    public static final String DAI1SYENYENKIJYUNHURYO   = "dai1syenyenkijyunhuryo";
    public static final String DAI1SYENYENYASUHURYO     = "dai1syenyenyasuhuryo";
    public static final String INITSBJIYENKASAITEIHSYGK = "initsbjiyenkasaiteihsygk";
    public static final String DAI2STUUKTYPE            = "dai2stuuktype";
    public static final String DAI2S                    = "dai2s";
    public static final String DAI2SYENTUUKTYPE         = "dai2syentuuktype";
    public static final String DAI2SYENYENDAKA          = "dai2syenyendaka";
    public static final String DAI2SYENYENKIJYUN        = "dai2syenyenkijyun";
    public static final String DAI2SYENYENYASU          = "dai2syenyenyasu";
    public static final String DAI3STUUKTYPE            = "dai3stuuktype";
    public static final String DAI3S                    = "dai3s";
    public static final String DAI3SYENTUUKTYPE         = "dai3syentuuktype";
    public static final String DAI3SYENYENDAKA          = "dai3syenyendaka";
    public static final String DAI3SYENYENKIJYUN        = "dai3syenyenkijyun";
    public static final String DAI3SYENYENYASU          = "dai3syenyenyasu";
    public static final String SIBOUINJIPTNKBN          = "sibouinjiptnkbn";
    public static final String MKHYOUYENSYSNIKOUMSGCD   = "mkhyouyensysnikoumsgcd";
    public static final String MKHYOUYENSYSNIKOUMSGCD2  = "mkhyouyensysnikoumsgcd2";
    public static final String MKHYOUYENSYSNIKOUMSGCD3  = "mkhyouyensysnikoumsgcd3";
    public static final String MKHYOUYENSYSNIKOUGKTYPE  = "mkhyouyensysnikougktype";
    public static final String MKHYOUYENSYSNIKOUGK      = "mkhyouyensysnikougk";
    public static final String MKHYOUYENSYSNIKOUWRA     = "mkhyouyensysnikouwra";
    public static final String KAIGOMAEHRTKYKMSGCD1     = "kaigomaehrtkykmsgcd1";
    public static final String KAIGOMAEHRTKYKMSGCD2     = "kaigomaehrtkykmsgcd2";
    public static final String KAIGOMAEHRTKYKMSGCDST1   = "kaigomaehrtkykmsgcdst1";
    public static final String KAIGOMAEHRTKYKMSGCDST2   = "kaigomaehrtkykmsgcdst2";
    public static final String KAIGOMAEHRUKTGKUMU       = "kaigomaehruktgkumu";
    public static final String KAIGOMAEHRTKYKKYKTUUKA   = "kaigomaehrtkykkyktuuka";
    public static final String KAIGOMAEHRTKYKSTDMSGCD   = "kaigomaehrtkykstdmsgcd";
    public static final String KAIGOMAEHRJRUGKTYPE      = "kaigomaehrjrugktype";
    public static final String KAIGOMAEHRSIKUHHKNNEN01  = "kaigomaehrsikuhhknnen01";
    public static final String KAIGOMAEHRSTIKKN01       = "kaigomaehrstikkn01";
    public static final String KAIGOMAEHRJRUGK01        = "kaigomaehrjrugk01";
    public static final String KAIGOMAEHRSIKUHHKNNEN02  = "kaigomaehrsikuhhknnen02";
    public static final String KAIGOMAEHRSTIKKN02       = "kaigomaehrstikkn02";
    public static final String KAIGOMAEHRJRUGK02        = "kaigomaehrjrugk02";
    public static final String KAIGOMAEHRSIKUHHKNNEN03  = "kaigomaehrsikuhhknnen03";
    public static final String KAIGOMAEHRSTIKKN03       = "kaigomaehrstikkn03";
    public static final String KAIGOMAEHRJRUGK03        = "kaigomaehrjrugk03";
    public static final String KAIGOMAEHRSIKUHHKNNEN04  = "kaigomaehrsikuhhknnen04";
    public static final String KAIGOMAEHRSTIKKN04       = "kaigomaehrstikkn04";
    public static final String KAIGOMAEHRJRUGK04        = "kaigomaehrjrugk04";
    public static final String KAIGOMAEHRSIKUHHKNNEN05  = "kaigomaehrsikuhhknnen05";
    public static final String KAIGOMAEHRSTIKKN05       = "kaigomaehrstikkn05";
    public static final String KAIGOMAEHRJRUGK05        = "kaigomaehrjrugk05";
    public static final String KAIGOMAEHRSIKUHHKNNEN06  = "kaigomaehrsikuhhknnen06";
    public static final String KAIGOMAEHRSTIKKN06       = "kaigomaehrstikkn06";
    public static final String KAIGOMAEHRJRUGK06        = "kaigomaehrjrugk06";
    public static final String KAIGOMAEHRSIKUHHKNNEN07  = "kaigomaehrsikuhhknnen07";
    public static final String KAIGOMAEHRSTIKKN07       = "kaigomaehrstikkn07";
    public static final String KAIGOMAEHRJRUGK07        = "kaigomaehrjrugk07";
    public static final String KAIGOMAEHRSIKUHHKNNEN08  = "kaigomaehrsikuhhknnen08";
    public static final String KAIGOMAEHRSTIKKN08       = "kaigomaehrstikkn08";
    public static final String KAIGOMAEHRJRUGK08        = "kaigomaehrjrugk08";
    public static final String KAIGOMAEHRSIKUHHKNNEN09  = "kaigomaehrsikuhhknnen09";
    public static final String KAIGOMAEHRSTIKKN09       = "kaigomaehrstikkn09";
    public static final String KAIGOMAEHRJRUGK09        = "kaigomaehrjrugk09";
    public static final String KAIGOMAEHRSIKUHHKNNEN10  = "kaigomaehrsikuhhknnen10";
    public static final String KAIGOMAEHRSTIKKN10       = "kaigomaehrstikkn10";
    public static final String KAIGOMAEHRJRUGK10        = "kaigomaehrjrugk10";
    public static final String HUTANHIYUSTMMSGCDUE01    = "hutanhiyustmmsgcdue01";
    public static final String HUTANHIYUSTMMSGCDUE02    = "hutanhiyustmmsgcdue02";
    public static final String HUTANHIYUSTMMSGCDUE03    = "hutanhiyustmmsgcdue03";
    public static final String HUTANHIYUSTMMSGCDUE04    = "hutanhiyustmmsgcdue04";
    public static final String HUTANHIYUSTMKNSNHYUPTN   = "hutanhiyustmknsnhyuptn";
    public static final String HUTANHIYUSTMMSGCDST01    = "hutanhiyustmmsgcdst01";
    public static final String HUTANHIYUSTMMSGCDST02    = "hutanhiyustmmsgcdst02";
    public static final String HUTANHIYUSTMMSGCDST03    = "hutanhiyustmmsgcdst03";
    public static final String STDSTMMSGCD              = "stdstmmsgcd";
    public static final String FSTPMSGCD                = "fstpmsgcd";
    public static final String FSTPHRKPKNGKKEITUUKTYPE  = "fstphrkpkngkkeituuktype";
    public static final String FSTPHRKPKNGKKEI          = "fstphrkpkngkkei";
    public static final String FSTPONEGAIMSGCD          = "fstponegaimsgcd";
    public static final String DSMSGCD                  = "dsmsgcd";
    public static final String SYOUHNHUTAIMSGCD1        = "syouhnhutaimsgcd1";
    public static final String SYOUHNHUTAIMSGCD2        = "syouhnhutaimsgcd2";
    public static final String PYENTUUKTYPE             = "pyentuuktype";
    public static final String PYEN                     = "pyen";
    public static final String TOIAWASESAKIHANYOUMSGCD  = "toiawasesakihanyoumsgcd";
    public static final String ANNAIHANYOUMSGCD         = "annaihanyoumsgcd";
    public static final String WMSGCD1                  = "wmsgcd1";
    public static final String WMSGCD2                  = "wmsgcd2";
    public static final String WMSGCD3                  = "wmsgcd3";
    public static final String WTYUUIJIKOUMSGCD1        = "wtyuuijikoumsgcd1";
    public static final String WTYUUIJIKOUMSGCD2        = "wtyuuijikoumsgcd2";
    public static final String WTYUUIJIKOUMSGCD3        = "wtyuuijikoumsgcd3";
    public static final String WTYUUIJIKOUMSGCD4        = "wtyuuijikoumsgcd4";
    public static final String WTYUUIJIKOUMSGCD5        = "wtyuuijikoumsgcd5";
    public static final String WITIJIBRPTUKTYPE         = "witijibrptuktype";
    public static final String WITIJIBRP                = "witijibrp";
    public static final String WYENHRKGKTUKTYPE         = "wyenhrkgktuktype";
    public static final String WYENHRKGK                = "wyenhrkgk";
    public static final String WYENITIJIBRPTUKTYPE      = "wyenitijibrptuktype";
    public static final String WYENITIJIBRP             = "wyenitijibrp";
    public static final String KOUJYOSYOUMEIMSGCD1      = "koujyosyoumeimsgcd1";
    public static final String KOUJYOSYOUMEIMSGCD2      = "koujyosyoumeimsgcd2";
    public static final String KOUJYOSYOUMEIMSGCD3      = "koujyosyoumeimsgcd3";
    public static final String KOUJYOSYOUMEIHSKMSGCD    = "koujyosyoumeihskmsgcd";
    public static final String NENKOUJYOSYOUMEIHSKMSGCD = "nenkoujyosyoumeihskmsgcd";
    public static final String TOKUSYUSYORINAIYOUKBN1   = "tokusyusyorinaiyoukbn1";
    public static final String TOKUSYUSYORINAIYOUKBN2   = "tokusyusyorinaiyoukbn2";
    public static final String TOKUSYUSYORINAIYOUKBN3   = "tokusyusyorinaiyoukbn3";
    public static final String TOKUSYUSYORINAIYOUKBN4   = "tokusyusyorinaiyoukbn4";
    public static final String TOKUSYUSYORINAIYOUKBN5   = "tokusyusyorinaiyoukbn5";
    public static final String TOKUSYUSYORINAIYOUKBN6   = "tokusyusyorinaiyoukbn6";
    public static final String TOKUSYUSYORINAIYOUKBN7   = "tokusyusyorinaiyoukbn7";
    public static final String TOKUSYUSYORINAIYOUKBN8   = "tokusyusyorinaiyoukbn8";
    public static final String TOKUSYUSYORINAIYOUKBN9   = "tokusyusyorinaiyoukbn9";
    public static final String TOKUSYUSYORINAIYOUKBN10  = "tokusyusyorinaiyoukbn10";
    public static final String TOKUSYUSYORINAIYOUKBN11  = "tokusyusyorinaiyoukbn11";
    public static final String TOKUSYUSYORINAIYOUKBN12  = "tokusyusyorinaiyoukbn12";
    public static final String TOKUSYUSYORINAIYOUKBN13  = "tokusyusyorinaiyoukbn13";
    public static final String TOKUSYUSYORINAIYOUKBN14  = "tokusyusyorinaiyoukbn14";
    public static final String TOKUSYUSYORINAIYOUKBN15  = "tokusyusyorinaiyoukbn15";
    public static final String TOKUSYUSYORINAIYOUKBN16  = "tokusyusyorinaiyoukbn16";
    public static final String TOKUSYUSYORINAIYOUKBN17  = "tokusyusyorinaiyoukbn17";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String KYKNMKN                  = "kyknmkn";
    public static final String HHKNNMKN                 = "hhknnmkn";
    public static final String SONOTANYRANNKSHRSTARTYMD = "sonotanyrannkshrstartymd";
    public static final String SONOTANYRANNENKINKKN     = "sonotanyrannenkinkkn";
    public static final String SONOTANYRANYENSYSNHKHNKYMD = "sonotanyranyensysnhkhnkymd";
    public static final String SONOTANYRANTUMITATERIRITU = "sonotanyrantumitateriritu";
    public static final String SONOTANYRANTMTTKNZKRTJYGN = "sonotanyrantmttknzkrtjygn";
    public static final String SONOTANYRANSETTEIBAIRITU = "sonotanyransetteibairitu";
    public static final String SONOTANYRANTMTTKNGKTUKTYPE = "sonotanyrantmttkngktuktype";
    public static final String SONOTANYRANTEIRITUTMTTKNGK = "sonotanyranteiritutmttkngk";
    public static final String SONOTANYRANSISUUTMTTKNGK = "sonotanyransisuutmttkngk";
    public static final String SONOTANYRANSISUUNM       = "sonotanyransisuunm";
    public static final String KGMAEHRTKDAI1HKNKKNMNRYYMD = "kgmaehrtkdai1hknkknmnryymd";
    public static final String NKMSGCD1                 = "nkmsgcd1";
    public static final String NKMSGCD2                 = "nkmsgcd2";
    public static final String NKMSGCD3                 = "nkmsgcd3";
    public static final String NKMSGCD4                 = "nkmsgcd4";
    public static final String NKMSGCD5                 = "nkmsgcd5";
    public static final String NKMSGCD6                 = "nkmsgcd6";
    public static final String NKMSGCD7                 = "nkmsgcd7";
    public static final String NKMSGCD8                 = "nkmsgcd8";
    public static final String NKMSGCD9                 = "nkmsgcd9";
    public static final String NKMSGCD10                = "nkmsgcd10";
    public static final String SIBOUKYUUHUKINMSGCD1     = "siboukyuuhukinmsgcd1";
    public static final String SIBOUKYUUHUKINMSGCD2     = "siboukyuuhukinmsgcd2";
    public static final String SIBOUKYUUHUKINMSGCD3     = "siboukyuuhukinmsgcd3";
    public static final String SIBOUKYUUHUKINMSGCD4     = "siboukyuuhukinmsgcd4";
    public static final String SIBOUKYUUHUKINMSGCD5     = "siboukyuuhukinmsgcd5";
    public static final String SIBOUKYUUHUKINMSGCD6     = "siboukyuuhukinmsgcd6";
    public static final String SIBOUKYUUHUKINMSGCD7     = "siboukyuuhukinmsgcd7";
    public static final String SIBOUKYUUHUKINMSGCD8     = "siboukyuuhukinmsgcd8";
    public static final String SIBOUKYUUHUKINMSGCD9     = "siboukyuuhukinmsgcd9";
    public static final String SIBOUKYUUHUKINMSGCD10    = "siboukyuuhukinmsgcd10";
    public static final String NKSHRSTARTZENYMD         = "nkshrstartzenymd";
    public static final String MKHYOUYENNKHKNHENTKTYPE  = "mkhyouyennkhknhentktype";
    public static final String MKHYOUYENNKHKNHENTKMKHGK = "mkhyouyennkhknhentkmkhgk";
    public static final String MKHYOUYENNKHKNHENTKMKHWARI = "mkhyouyennkhknhentkmkhwari";
    public static final String HAIBUNWARIMSGCD1         = "haibunwarimsgcd1";
    public static final String HAIBUNWARIMSGCD2         = "haibunwarimsgcd2";
    public static final String HAIBUNWARIMSGCD3         = "haibunwarimsgcd3";
    public static final String TEIRITUTMTTHBNWR         = "teiritutmtthbnwr";
    public static final String SISUUTMTTHBNWR           = "sisuutmtthbnwr";
    public static final String SISUUANNAIMSG1           = "sisuuannaimsg1";
    public static final String SISUUANNAIMSG2           = "sisuuannaimsg2";
    public static final String SISUUANNAIMSG3           = "sisuuannaimsg3";
    public static final String HUTANHIYUSTMYTIJIHIRITU  = "hutanhiyustmytijihiritu";
    public static final String WMSGCD21                 = "wmsgcd21";
    public static final String WMSGCD22                 = "wmsgcd22";
    public static final String WMSGCD23                 = "wmsgcd23";
    public static final String WMSGCD31                 = "wmsgcd31";
    public static final String WMSGCD32                 = "wmsgcd32";
    public static final String WMSGCD33                 = "wmsgcd33";
    public static final String WMSGCDST1                = "wmsgcdst1";
    public static final String WTYUUIJIKOUMSGCD6        = "wtyuuijikoumsgcd6";
    public static final String WTYUUIJIKOUMSGCD7        = "wtyuuijikoumsgcd7";
    public static final String TANTOCD                  = "tantocd";
    public static final String PHRKKTUKI                = "phrkktuki";
    public static final String YAKKANJYURYOUHOUKBN      = "yakkanjyuryouhoukbn";
    public static final String YAKKANBUNSYONO           = "yakkanbunsyono";
    public static final String SIORINO                  = "siorino";
    public static final String SIORIWEBUKTRIANNAIMSGCD  = "sioriwebuktriannaimsgcd";
    public static final String SAGYOUKBN                = "sagyoukbn";
    public static final String SISUUUPKAISUU            = "sisuuupkaisuu";
    public static final String SISUUDOWNKAISUU          = "sisuudownkaisuu";

    private final PKIT_BAK_HokenSyouken primaryKey;

    public GenIT_BAK_HokenSyouken() {
        primaryKey = new PKIT_BAK_HokenSyouken();
    }

    public GenIT_BAK_HokenSyouken(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        BizDate pTyouhyouymd
    ) {
        primaryKey = new PKIT_BAK_HokenSyouken(
            pKbnkey,
            pSyono,
            pTrkssikibetukey,
            pTyouhyouymd
        );
    }

    @Transient
    @Override
    public PKIT_BAK_HokenSyouken getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_HokenSyouken> getMetaClass() {
        return QIT_BAK_HokenSyouken.class;
    }

    @Id
    @Column(name=GenIT_BAK_HokenSyouken.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_HokenSyouken.SYONO)
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
    @Column(name=GenIT_BAK_HokenSyouken.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.TYOUHYOUYMD)
    @ValidDate
    public BizDate getTyouhyouymd() {
        return getPrimaryKey().getTyouhyouymd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        getPrimaryKey().setTyouhyouymd(pTyouhyouymd);
    }

    private String henkousikibetukey;

    @Column(name=GenIT_BAK_HokenSyouken.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

    private C_SinsaihkKbn sinsaihkkbn;

    @Type(type="UserType_C_SinsaihkKbn")
    @Column(name=GenIT_BAK_HokenSyouken.SINSAIHKKBN)
    public C_SinsaihkKbn getSinsaihkkbn() {
        return sinsaihkkbn;
    }

    public void setSinsaihkkbn(C_SinsaihkKbn pSinsaihkkbn) {
        sinsaihkkbn = pSinsaihkkbn;
    }

    private C_SyoukensaihkKbn syoukensaihkkbn;

    @Type(type="UserType_C_SyoukensaihkKbn")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENSAIHKKBN)
    public C_SyoukensaihkKbn getSyoukensaihkkbn() {
        return syoukensaihkkbn;
    }

    public void setSyoukensaihkkbn(C_SyoukensaihkKbn pSyoukensaihkkbn) {
        syoukensaihkkbn = pSyoukensaihkkbn;
    }

    private C_InsizeiShryouhiKbn insizeishryouhikbn;

    @Type(type="UserType_C_InsizeiShryouhiKbn")
    @Column(name=GenIT_BAK_HokenSyouken.INSIZEISHRYOUHIKBN)
    public C_InsizeiShryouhiKbn getInsizeishryouhikbn() {
        return insizeishryouhikbn;
    }

    public void setInsizeishryouhikbn(C_InsizeiShryouhiKbn pInsizeishryouhikbn) {
        insizeishryouhikbn = pInsizeishryouhikbn;
    }

    private C_HassouKbn hassoukbn;

    @Type(type="UserType_C_HassouKbn")
    @Column(name=GenIT_BAK_HokenSyouken.HASSOUKBN)
    public C_HassouKbn getHassoukbn() {
        return hassoukbn;
    }

    public void setHassoukbn(C_HassouKbn pHassoukbn) {
        hassoukbn = pHassoukbn;
    }

    private C_UmuKbn koujyosyoumeiumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_BAK_HokenSyouken.KOUJYOSYOUMEIUMUKBN)
    public C_UmuKbn getKoujyosyoumeiumukbn() {
        return koujyosyoumeiumukbn;
    }

    public void setKoujyosyoumeiumukbn(C_UmuKbn pKoujyosyoumeiumukbn) {
        koujyosyoumeiumukbn = pKoujyosyoumeiumukbn;
    }

    private C_UmuKbn suiihyouumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_BAK_HokenSyouken.SUIIHYOUUMUKBN)
    public C_UmuKbn getSuiihyouumukbn() {
        return suiihyouumukbn;
    }

    public void setSuiihyouumukbn(C_UmuKbn pSuiihyouumukbn) {
        suiihyouumukbn = pSuiihyouumukbn;
    }

    private C_UmuKbn kanryoutuutiumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_BAK_HokenSyouken.KANRYOUTUUTIUMUKBN)
    public C_UmuKbn getKanryoutuutiumukbn() {
        return kanryoutuutiumukbn;
    }

    public void setKanryoutuutiumukbn(C_UmuKbn pKanryoutuutiumukbn) {
        kanryoutuutiumukbn = pKanryoutuutiumukbn;
    }

    private C_UmuKbn stdrsktirasidouhuukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_BAK_HokenSyouken.STDRSKTIRASIDOUHUUKBN)
    public C_UmuKbn getStdrsktirasidouhuukbn() {
        return stdrsktirasidouhuukbn;
    }

    public void setStdrsktirasidouhuukbn(C_UmuKbn pStdrsktirasidouhuukbn) {
        stdrsktirasidouhuukbn = pStdrsktirasidouhuukbn;
    }

    private C_UmuKbn dstirasidouhuukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_BAK_HokenSyouken.DSTIRASIDOUHUUKBN)
    public C_UmuKbn getDstirasidouhuukbn() {
        return dstirasidouhuukbn;
    }

    public void setDstirasidouhuukbn(C_UmuKbn pDstirasidouhuukbn) {
        dstirasidouhuukbn = pDstirasidouhuukbn;
    }

    private C_AisyoumeiKbn aisyoumeikbn;

    @Type(type="UserType_C_AisyoumeiKbn")
    @Column(name=GenIT_BAK_HokenSyouken.AISYOUMEIKBN)
    public C_AisyoumeiKbn getAisyoumeikbn() {
        return aisyoumeikbn;
    }

    public void setAisyoumeikbn(C_AisyoumeiKbn pAisyoumeikbn) {
        aisyoumeikbn = pAisyoumeikbn;
    }

    private C_UmuKbn syotnshuyoupostumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_BAK_HokenSyouken.SYOTNSHUYOUPOSTUMUKBN)
    public C_UmuKbn getSyotnshuyoupostumukbn() {
        return syotnshuyoupostumukbn;
    }

    public void setSyotnshuyoupostumukbn(C_UmuKbn pSyotnshuyoupostumukbn) {
        syotnshuyoupostumukbn = pSyotnshuyoupostumukbn;
    }

    private String hyoujiranhidarimsgcd1;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANHIDARIMSGCD1)
    public String getHyoujiranhidarimsgcd1() {
        return hyoujiranhidarimsgcd1;
    }

    public void setHyoujiranhidarimsgcd1(String pHyoujiranhidarimsgcd1) {
        hyoujiranhidarimsgcd1 = pHyoujiranhidarimsgcd1;
    }

    private String hyoujiranhidarimsgcd2;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANHIDARIMSGCD2)
    public String getHyoujiranhidarimsgcd2() {
        return hyoujiranhidarimsgcd2;
    }

    public void setHyoujiranhidarimsgcd2(String pHyoujiranhidarimsgcd2) {
        hyoujiranhidarimsgcd2 = pHyoujiranhidarimsgcd2;
    }

    private String hyoujiranhidarimsgcd3;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANHIDARIMSGCD3)
    public String getHyoujiranhidarimsgcd3() {
        return hyoujiranhidarimsgcd3;
    }

    public void setHyoujiranhidarimsgcd3(String pHyoujiranhidarimsgcd3) {
        hyoujiranhidarimsgcd3 = pHyoujiranhidarimsgcd3;
    }

    private String hyoujiranhidarimsgcd4;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANHIDARIMSGCD4)
    public String getHyoujiranhidarimsgcd4() {
        return hyoujiranhidarimsgcd4;
    }

    public void setHyoujiranhidarimsgcd4(String pHyoujiranhidarimsgcd4) {
        hyoujiranhidarimsgcd4 = pHyoujiranhidarimsgcd4;
    }

    private String hyoujiranhidarimsgcd5;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANHIDARIMSGCD5)
    public String getHyoujiranhidarimsgcd5() {
        return hyoujiranhidarimsgcd5;
    }

    public void setHyoujiranhidarimsgcd5(String pHyoujiranhidarimsgcd5) {
        hyoujiranhidarimsgcd5 = pHyoujiranhidarimsgcd5;
    }

    private String hyoujiranhidarimsgcd6;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANHIDARIMSGCD6)
    public String getHyoujiranhidarimsgcd6() {
        return hyoujiranhidarimsgcd6;
    }

    public void setHyoujiranhidarimsgcd6(String pHyoujiranhidarimsgcd6) {
        hyoujiranhidarimsgcd6 = pHyoujiranhidarimsgcd6;
    }

    private String hyoujiranhidarimsgcd7;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANHIDARIMSGCD7)
    public String getHyoujiranhidarimsgcd7() {
        return hyoujiranhidarimsgcd7;
    }

    public void setHyoujiranhidarimsgcd7(String pHyoujiranhidarimsgcd7) {
        hyoujiranhidarimsgcd7 = pHyoujiranhidarimsgcd7;
    }

    private String hyoujiranhidarimsgcd8;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANHIDARIMSGCD8)
    public String getHyoujiranhidarimsgcd8() {
        return hyoujiranhidarimsgcd8;
    }

    public void setHyoujiranhidarimsgcd8(String pHyoujiranhidarimsgcd8) {
        hyoujiranhidarimsgcd8 = pHyoujiranhidarimsgcd8;
    }

    private String hyoujiranhidarimsgcd9;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANHIDARIMSGCD9)
    public String getHyoujiranhidarimsgcd9() {
        return hyoujiranhidarimsgcd9;
    }

    public void setHyoujiranhidarimsgcd9(String pHyoujiranhidarimsgcd9) {
        hyoujiranhidarimsgcd9 = pHyoujiranhidarimsgcd9;
    }

    private String hyoujiranhidarimsgcd10;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANHIDARIMSGCD10)
    public String getHyoujiranhidarimsgcd10() {
        return hyoujiranhidarimsgcd10;
    }

    public void setHyoujiranhidarimsgcd10(String pHyoujiranhidarimsgcd10) {
        hyoujiranhidarimsgcd10 = pHyoujiranhidarimsgcd10;
    }

    private String hyoujiranhidarimsgcd11;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANHIDARIMSGCD11)
    public String getHyoujiranhidarimsgcd11() {
        return hyoujiranhidarimsgcd11;
    }

    public void setHyoujiranhidarimsgcd11(String pHyoujiranhidarimsgcd11) {
        hyoujiranhidarimsgcd11 = pHyoujiranhidarimsgcd11;
    }

    private String hyoujiranhidarimsgcd12;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANHIDARIMSGCD12)
    public String getHyoujiranhidarimsgcd12() {
        return hyoujiranhidarimsgcd12;
    }

    public void setHyoujiranhidarimsgcd12(String pHyoujiranhidarimsgcd12) {
        hyoujiranhidarimsgcd12 = pHyoujiranhidarimsgcd12;
    }

    private String hyoujiranhidarimsgcd13;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANHIDARIMSGCD13)
    public String getHyoujiranhidarimsgcd13() {
        return hyoujiranhidarimsgcd13;
    }

    public void setHyoujiranhidarimsgcd13(String pHyoujiranhidarimsgcd13) {
        hyoujiranhidarimsgcd13 = pHyoujiranhidarimsgcd13;
    }

    private String hyoujiranhidarimsgcd14;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANHIDARIMSGCD14)
    public String getHyoujiranhidarimsgcd14() {
        return hyoujiranhidarimsgcd14;
    }

    public void setHyoujiranhidarimsgcd14(String pHyoujiranhidarimsgcd14) {
        hyoujiranhidarimsgcd14 = pHyoujiranhidarimsgcd14;
    }

    private String hyoujiranhidarimsgcd15;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANHIDARIMSGCD15)
    public String getHyoujiranhidarimsgcd15() {
        return hyoujiranhidarimsgcd15;
    }

    public void setHyoujiranhidarimsgcd15(String pHyoujiranhidarimsgcd15) {
        hyoujiranhidarimsgcd15 = pHyoujiranhidarimsgcd15;
    }

    private String hyoujiranhidarimsgcd16;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANHIDARIMSGCD16)
    public String getHyoujiranhidarimsgcd16() {
        return hyoujiranhidarimsgcd16;
    }

    public void setHyoujiranhidarimsgcd16(String pHyoujiranhidarimsgcd16) {
        hyoujiranhidarimsgcd16 = pHyoujiranhidarimsgcd16;
    }

    private String hyoujiranhidarimsgcd17;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANHIDARIMSGCD17)
    public String getHyoujiranhidarimsgcd17() {
        return hyoujiranhidarimsgcd17;
    }

    public void setHyoujiranhidarimsgcd17(String pHyoujiranhidarimsgcd17) {
        hyoujiranhidarimsgcd17 = pHyoujiranhidarimsgcd17;
    }

    private String hyoujiranhidarimsgcd18;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANHIDARIMSGCD18)
    public String getHyoujiranhidarimsgcd18() {
        return hyoujiranhidarimsgcd18;
    }

    public void setHyoujiranhidarimsgcd18(String pHyoujiranhidarimsgcd18) {
        hyoujiranhidarimsgcd18 = pHyoujiranhidarimsgcd18;
    }

    private String hyoujiranhidarimsgcd19;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANHIDARIMSGCD19)
    public String getHyoujiranhidarimsgcd19() {
        return hyoujiranhidarimsgcd19;
    }

    public void setHyoujiranhidarimsgcd19(String pHyoujiranhidarimsgcd19) {
        hyoujiranhidarimsgcd19 = pHyoujiranhidarimsgcd19;
    }

    private String hyoujiranhidarimsgcd20;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANHIDARIMSGCD20)
    public String getHyoujiranhidarimsgcd20() {
        return hyoujiranhidarimsgcd20;
    }

    public void setHyoujiranhidarimsgcd20(String pHyoujiranhidarimsgcd20) {
        hyoujiranhidarimsgcd20 = pHyoujiranhidarimsgcd20;
    }

    private String hyoujiranmigiimsgcd1;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANMIGIIMSGCD1)
    public String getHyoujiranmigiimsgcd1() {
        return hyoujiranmigiimsgcd1;
    }

    public void setHyoujiranmigiimsgcd1(String pHyoujiranmigiimsgcd1) {
        hyoujiranmigiimsgcd1 = pHyoujiranmigiimsgcd1;
    }

    private String hyoujiranmigiimsgcd2;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANMIGIIMSGCD2)
    public String getHyoujiranmigiimsgcd2() {
        return hyoujiranmigiimsgcd2;
    }

    public void setHyoujiranmigiimsgcd2(String pHyoujiranmigiimsgcd2) {
        hyoujiranmigiimsgcd2 = pHyoujiranmigiimsgcd2;
    }

    private String hyoujiranmigiimsgcd3;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANMIGIIMSGCD3)
    public String getHyoujiranmigiimsgcd3() {
        return hyoujiranmigiimsgcd3;
    }

    public void setHyoujiranmigiimsgcd3(String pHyoujiranmigiimsgcd3) {
        hyoujiranmigiimsgcd3 = pHyoujiranmigiimsgcd3;
    }

    private String hyoujiranmigiimsgcd4;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANMIGIIMSGCD4)
    public String getHyoujiranmigiimsgcd4() {
        return hyoujiranmigiimsgcd4;
    }

    public void setHyoujiranmigiimsgcd4(String pHyoujiranmigiimsgcd4) {
        hyoujiranmigiimsgcd4 = pHyoujiranmigiimsgcd4;
    }

    private String hyoujiranmigiimsgcd5;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANMIGIIMSGCD5)
    public String getHyoujiranmigiimsgcd5() {
        return hyoujiranmigiimsgcd5;
    }

    public void setHyoujiranmigiimsgcd5(String pHyoujiranmigiimsgcd5) {
        hyoujiranmigiimsgcd5 = pHyoujiranmigiimsgcd5;
    }

    private String hyoujiranmigiimsgcd6;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANMIGIIMSGCD6)
    public String getHyoujiranmigiimsgcd6() {
        return hyoujiranmigiimsgcd6;
    }

    public void setHyoujiranmigiimsgcd6(String pHyoujiranmigiimsgcd6) {
        hyoujiranmigiimsgcd6 = pHyoujiranmigiimsgcd6;
    }

    private String hyoujiranmigiimsgcd7;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANMIGIIMSGCD7)
    public String getHyoujiranmigiimsgcd7() {
        return hyoujiranmigiimsgcd7;
    }

    public void setHyoujiranmigiimsgcd7(String pHyoujiranmigiimsgcd7) {
        hyoujiranmigiimsgcd7 = pHyoujiranmigiimsgcd7;
    }

    private String hyoujiranmigiimsgcd8;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANMIGIIMSGCD8)
    public String getHyoujiranmigiimsgcd8() {
        return hyoujiranmigiimsgcd8;
    }

    public void setHyoujiranmigiimsgcd8(String pHyoujiranmigiimsgcd8) {
        hyoujiranmigiimsgcd8 = pHyoujiranmigiimsgcd8;
    }

    private String hyoujiranmigiimsgcd9;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANMIGIIMSGCD9)
    public String getHyoujiranmigiimsgcd9() {
        return hyoujiranmigiimsgcd9;
    }

    public void setHyoujiranmigiimsgcd9(String pHyoujiranmigiimsgcd9) {
        hyoujiranmigiimsgcd9 = pHyoujiranmigiimsgcd9;
    }

    private String hyoujiranmigiimsgcd10;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANMIGIIMSGCD10)
    public String getHyoujiranmigiimsgcd10() {
        return hyoujiranmigiimsgcd10;
    }

    public void setHyoujiranmigiimsgcd10(String pHyoujiranmigiimsgcd10) {
        hyoujiranmigiimsgcd10 = pHyoujiranmigiimsgcd10;
    }

    private String hyoujiranmigiimsgcd11;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANMIGIIMSGCD11)
    public String getHyoujiranmigiimsgcd11() {
        return hyoujiranmigiimsgcd11;
    }

    public void setHyoujiranmigiimsgcd11(String pHyoujiranmigiimsgcd11) {
        hyoujiranmigiimsgcd11 = pHyoujiranmigiimsgcd11;
    }

    private String hyoujiranmigiimsgcd12;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANMIGIIMSGCD12)
    public String getHyoujiranmigiimsgcd12() {
        return hyoujiranmigiimsgcd12;
    }

    public void setHyoujiranmigiimsgcd12(String pHyoujiranmigiimsgcd12) {
        hyoujiranmigiimsgcd12 = pHyoujiranmigiimsgcd12;
    }

    private String hyoujiranmigiimsgcd13;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANMIGIIMSGCD13)
    public String getHyoujiranmigiimsgcd13() {
        return hyoujiranmigiimsgcd13;
    }

    public void setHyoujiranmigiimsgcd13(String pHyoujiranmigiimsgcd13) {
        hyoujiranmigiimsgcd13 = pHyoujiranmigiimsgcd13;
    }

    private String hyoujiranmigiimsgcd14;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANMIGIIMSGCD14)
    public String getHyoujiranmigiimsgcd14() {
        return hyoujiranmigiimsgcd14;
    }

    public void setHyoujiranmigiimsgcd14(String pHyoujiranmigiimsgcd14) {
        hyoujiranmigiimsgcd14 = pHyoujiranmigiimsgcd14;
    }

    private String hyoujiranmigiimsgcd15;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANMIGIIMSGCD15)
    public String getHyoujiranmigiimsgcd15() {
        return hyoujiranmigiimsgcd15;
    }

    public void setHyoujiranmigiimsgcd15(String pHyoujiranmigiimsgcd15) {
        hyoujiranmigiimsgcd15 = pHyoujiranmigiimsgcd15;
    }

    private String hyoujiranmigiimsgcd16;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANMIGIIMSGCD16)
    public String getHyoujiranmigiimsgcd16() {
        return hyoujiranmigiimsgcd16;
    }

    public void setHyoujiranmigiimsgcd16(String pHyoujiranmigiimsgcd16) {
        hyoujiranmigiimsgcd16 = pHyoujiranmigiimsgcd16;
    }

    private String hyoujiranmigiimsgcd17;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANMIGIIMSGCD17)
    public String getHyoujiranmigiimsgcd17() {
        return hyoujiranmigiimsgcd17;
    }

    public void setHyoujiranmigiimsgcd17(String pHyoujiranmigiimsgcd17) {
        hyoujiranmigiimsgcd17 = pHyoujiranmigiimsgcd17;
    }

    private String hyoujiranmigiimsgcd18;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANMIGIIMSGCD18)
    public String getHyoujiranmigiimsgcd18() {
        return hyoujiranmigiimsgcd18;
    }

    public void setHyoujiranmigiimsgcd18(String pHyoujiranmigiimsgcd18) {
        hyoujiranmigiimsgcd18 = pHyoujiranmigiimsgcd18;
    }

    private String hyoujiranmigiimsgcd19;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANMIGIIMSGCD19)
    public String getHyoujiranmigiimsgcd19() {
        return hyoujiranmigiimsgcd19;
    }

    public void setHyoujiranmigiimsgcd19(String pHyoujiranmigiimsgcd19) {
        hyoujiranmigiimsgcd19 = pHyoujiranmigiimsgcd19;
    }

    private String hyoujiranmigiimsgcd20;

    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANMIGIIMSGCD20)
    public String getHyoujiranmigiimsgcd20() {
        return hyoujiranmigiimsgcd20;
    }

    public void setHyoujiranmigiimsgcd20(String pHyoujiranmigiimsgcd20) {
        hyoujiranmigiimsgcd20 = pHyoujiranmigiimsgcd20;
    }

    private BizDate hyoujiransknnkaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANSKNNKAISIYMD)
    public BizDate getHyoujiransknnkaisiymd() {
        return hyoujiransknnkaisiymd;
    }

    public void setHyoujiransknnkaisiymd(BizDate pHyoujiransknnkaisiymd) {
        hyoujiransknnkaisiymd = pHyoujiransknnkaisiymd;
    }

    private BizNumber hyoujiranyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANYOTEIRIRITU)
    public BizNumber getHyoujiranyoteiriritu() {
        return hyoujiranyoteiriritu;
    }

    public void setHyoujiranyoteiriritu(BizNumber pHyoujiranyoteiriritu) {
        hyoujiranyoteiriritu = pHyoujiranyoteiriritu;
    }

    private BizNumber hyoujiransjkkktusirrt;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.HYOUJIRANSJKKKTUSIRRT)
    public BizNumber getHyoujiransjkkktusirrt() {
        return hyoujiransjkkktusirrt;
    }

    public void setHyoujiransjkkktusirrt(BizNumber pHyoujiransjkkktusirrt) {
        hyoujiransjkkktusirrt = pHyoujiransjkkktusirrt;
    }

    private String hknsyukigou;

    @Column(name=GenIT_BAK_HokenSyouken.HKNSYUKIGOU)
    public String getHknsyukigou() {
        return hknsyukigou;
    }

    public void setHknsyukigou(String pHknsyukigou) {
        hknsyukigou = pHknsyukigou;
    }

    private BizDate syohakkouymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.SYOHAKKOUYMD)
    public BizDate getSyohakkouymd() {
        return syohakkouymd;
    }

    public void setSyohakkouymd(BizDate pSyohakkouymd) {
        syohakkouymd = pSyohakkouymd;
    }

    private String hanbainm;

    @Column(name=GenIT_BAK_HokenSyouken.HANBAINM)
    public String getHanbainm() {
        return hanbainm;
    }

    public void setHanbainm(String pHanbainm) {
        hanbainm = pHanbainm;
    }

    private String seisikihknnm;

    @Column(name=GenIT_BAK_HokenSyouken.SEISIKIHKNNM)
    public String getSeisikihknnm() {
        return seisikihknnm;
    }

    public void setSeisikihknnm(String pSeisikihknnm) {
        seisikihknnm = pSeisikihknnm;
    }

    private BizDate kouryokukaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.KOURYOKUKAISIYMD)
    public BizDate getKouryokukaisiymd() {
        return kouryokukaisiymd;
    }

    public void setKouryokukaisiymd(BizDate pKouryokukaisiymd) {
        kouryokukaisiymd = pKouryokukaisiymd;
    }

    private String kyknmkj;

    @Column(name=GenIT_BAK_HokenSyouken.KYKNMKJ)
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

    private C_KjkhukaKbn kyknmkjkhukakbn;

    @Type(type="UserType_C_KjkhukaKbn")
    @Column(name=GenIT_BAK_HokenSyouken.KYKNMKJKHUKAKBN)
    public C_KjkhukaKbn getKyknmkjkhukakbn() {
        return kyknmkjkhukakbn;
    }

    public void setKyknmkjkhukakbn(C_KjkhukaKbn pKyknmkjkhukakbn) {
        kyknmkjkhukakbn = pKyknmkjkhukakbn;
    }

    private String hhknnmkj;

    @Column(name=GenIT_BAK_HokenSyouken.HHKNNMKJ)
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

    private C_KjkhukaKbn hhknnmkjkhukakbn;

    @Type(type="UserType_C_KjkhukaKbn")
    @Column(name=GenIT_BAK_HokenSyouken.HHKNNMKJKHUKAKBN)
    public C_KjkhukaKbn getHhknnmkjkhukakbn() {
        return hhknnmkjkhukakbn;
    }

    public void setHhknnmkjkhukakbn(C_KjkhukaKbn pHhknnmkjkhukakbn) {
        hhknnmkjkhukakbn = pHhknnmkjkhukakbn;
    }

    private BizDate hhknseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.HHKNSEIYMD)
    @ValidDate
    public BizDate getHhknseiymd() {
        return hhknseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknseiymd(BizDate pHhknseiymd) {
        hhknseiymd = pHhknseiymd;
    }

    private C_Hhknsei hhknsei;

    @Type(type="UserType_C_Hhknsei")
    @Column(name=GenIT_BAK_HokenSyouken.HHKNSEI)
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private Integer hhknnen;

    @Column(name=GenIT_BAK_HokenSyouken.HHKNNEN)
    @NaturalNumber
    public Integer getHhknnen() {
        return hhknnen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknnen(Integer pHhknnen) {
        hhknnen = pHhknnen;
    }

    private C_SyoukenUktMidasiKbn syoukenuktmidasikbn1;

    @Type(type="UserType_C_SyoukenUktMidasiKbn")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTMIDASIKBN1)
    public C_SyoukenUktMidasiKbn getSyoukenuktmidasikbn1() {
        return syoukenuktmidasikbn1;
    }

    public void setSyoukenuktmidasikbn1(C_SyoukenUktMidasiKbn pSyoukenuktmidasikbn1) {
        syoukenuktmidasikbn1 = pSyoukenuktmidasikbn1;
    }

    private C_SyoukenUktKbn syoukenuktkbn1;

    @Type(type="UserType_C_SyoukenUktKbn")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTKBN1)
    public C_SyoukenUktKbn getSyoukenuktkbn1() {
        return syoukenuktkbn1;
    }

    public void setSyoukenuktkbn1(C_SyoukenUktKbn pSyoukenuktkbn1) {
        syoukenuktkbn1 = pSyoukenuktkbn1;
    }

    private String syoukenuktnm1;

    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTNM1)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getSyoukenuktnm1() {
        return syoukenuktnm1;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyoukenuktnm1(String pSyoukenuktnm1) {
        syoukenuktnm1 = pSyoukenuktnm1;
    }

    private BizNumber syoukenuktbnwari1;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTBNWARI1)
    public BizNumber getSyoukenuktbnwari1() {
        return syoukenuktbnwari1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoukenuktbnwari1(BizNumber pSyoukenuktbnwari1) {
        syoukenuktbnwari1 = pSyoukenuktbnwari1;
    }

    private C_SyoukenUktMidasiKbn syoukenuktmidasikbn2;

    @Type(type="UserType_C_SyoukenUktMidasiKbn")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTMIDASIKBN2)
    public C_SyoukenUktMidasiKbn getSyoukenuktmidasikbn2() {
        return syoukenuktmidasikbn2;
    }

    public void setSyoukenuktmidasikbn2(C_SyoukenUktMidasiKbn pSyoukenuktmidasikbn2) {
        syoukenuktmidasikbn2 = pSyoukenuktmidasikbn2;
    }

    private C_SyoukenUktKbn syoukenuktkbn2;

    @Type(type="UserType_C_SyoukenUktKbn")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTKBN2)
    public C_SyoukenUktKbn getSyoukenuktkbn2() {
        return syoukenuktkbn2;
    }

    public void setSyoukenuktkbn2(C_SyoukenUktKbn pSyoukenuktkbn2) {
        syoukenuktkbn2 = pSyoukenuktkbn2;
    }

    private String syoukenuktnm2;

    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTNM2)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getSyoukenuktnm2() {
        return syoukenuktnm2;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyoukenuktnm2(String pSyoukenuktnm2) {
        syoukenuktnm2 = pSyoukenuktnm2;
    }

    private BizNumber syoukenuktbnwari2;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTBNWARI2)
    public BizNumber getSyoukenuktbnwari2() {
        return syoukenuktbnwari2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoukenuktbnwari2(BizNumber pSyoukenuktbnwari2) {
        syoukenuktbnwari2 = pSyoukenuktbnwari2;
    }

    private C_SyoukenUktMidasiKbn syoukenuktmidasikbn3;

    @Type(type="UserType_C_SyoukenUktMidasiKbn")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTMIDASIKBN3)
    public C_SyoukenUktMidasiKbn getSyoukenuktmidasikbn3() {
        return syoukenuktmidasikbn3;
    }

    public void setSyoukenuktmidasikbn3(C_SyoukenUktMidasiKbn pSyoukenuktmidasikbn3) {
        syoukenuktmidasikbn3 = pSyoukenuktmidasikbn3;
    }

    private C_SyoukenUktKbn syoukenuktkbn3;

    @Type(type="UserType_C_SyoukenUktKbn")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTKBN3)
    public C_SyoukenUktKbn getSyoukenuktkbn3() {
        return syoukenuktkbn3;
    }

    public void setSyoukenuktkbn3(C_SyoukenUktKbn pSyoukenuktkbn3) {
        syoukenuktkbn3 = pSyoukenuktkbn3;
    }

    private String syoukenuktnm3;

    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTNM3)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getSyoukenuktnm3() {
        return syoukenuktnm3;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyoukenuktnm3(String pSyoukenuktnm3) {
        syoukenuktnm3 = pSyoukenuktnm3;
    }

    private BizNumber syoukenuktbnwari3;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTBNWARI3)
    public BizNumber getSyoukenuktbnwari3() {
        return syoukenuktbnwari3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoukenuktbnwari3(BizNumber pSyoukenuktbnwari3) {
        syoukenuktbnwari3 = pSyoukenuktbnwari3;
    }

    private C_SyoukenUktMidasiKbn syoukenuktmidasikbn4;

    @Type(type="UserType_C_SyoukenUktMidasiKbn")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTMIDASIKBN4)
    public C_SyoukenUktMidasiKbn getSyoukenuktmidasikbn4() {
        return syoukenuktmidasikbn4;
    }

    public void setSyoukenuktmidasikbn4(C_SyoukenUktMidasiKbn pSyoukenuktmidasikbn4) {
        syoukenuktmidasikbn4 = pSyoukenuktmidasikbn4;
    }

    private C_SyoukenUktKbn syoukenuktkbn4;

    @Type(type="UserType_C_SyoukenUktKbn")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTKBN4)
    public C_SyoukenUktKbn getSyoukenuktkbn4() {
        return syoukenuktkbn4;
    }

    public void setSyoukenuktkbn4(C_SyoukenUktKbn pSyoukenuktkbn4) {
        syoukenuktkbn4 = pSyoukenuktkbn4;
    }

    private String syoukenuktnm4;

    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTNM4)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getSyoukenuktnm4() {
        return syoukenuktnm4;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyoukenuktnm4(String pSyoukenuktnm4) {
        syoukenuktnm4 = pSyoukenuktnm4;
    }

    private BizNumber syoukenuktbnwari4;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTBNWARI4)
    public BizNumber getSyoukenuktbnwari4() {
        return syoukenuktbnwari4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoukenuktbnwari4(BizNumber pSyoukenuktbnwari4) {
        syoukenuktbnwari4 = pSyoukenuktbnwari4;
    }

    private C_SyoukenUktMidasiKbn syoukenuktmidasikbn5;

    @Type(type="UserType_C_SyoukenUktMidasiKbn")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTMIDASIKBN5)
    public C_SyoukenUktMidasiKbn getSyoukenuktmidasikbn5() {
        return syoukenuktmidasikbn5;
    }

    public void setSyoukenuktmidasikbn5(C_SyoukenUktMidasiKbn pSyoukenuktmidasikbn5) {
        syoukenuktmidasikbn5 = pSyoukenuktmidasikbn5;
    }

    private C_SyoukenUktKbn syoukenuktkbn5;

    @Type(type="UserType_C_SyoukenUktKbn")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTKBN5)
    public C_SyoukenUktKbn getSyoukenuktkbn5() {
        return syoukenuktkbn5;
    }

    public void setSyoukenuktkbn5(C_SyoukenUktKbn pSyoukenuktkbn5) {
        syoukenuktkbn5 = pSyoukenuktkbn5;
    }

    private String syoukenuktnm5;

    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTNM5)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getSyoukenuktnm5() {
        return syoukenuktnm5;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyoukenuktnm5(String pSyoukenuktnm5) {
        syoukenuktnm5 = pSyoukenuktnm5;
    }

    private BizNumber syoukenuktbnwari5;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTBNWARI5)
    public BizNumber getSyoukenuktbnwari5() {
        return syoukenuktbnwari5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoukenuktbnwari5(BizNumber pSyoukenuktbnwari5) {
        syoukenuktbnwari5 = pSyoukenuktbnwari5;
    }

    private C_SyoukenUktMidasiKbn syoukenuktmidasikbn6;

    @Type(type="UserType_C_SyoukenUktMidasiKbn")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTMIDASIKBN6)
    public C_SyoukenUktMidasiKbn getSyoukenuktmidasikbn6() {
        return syoukenuktmidasikbn6;
    }

    public void setSyoukenuktmidasikbn6(C_SyoukenUktMidasiKbn pSyoukenuktmidasikbn6) {
        syoukenuktmidasikbn6 = pSyoukenuktmidasikbn6;
    }

    private C_SyoukenUktKbn syoukenuktkbn6;

    @Type(type="UserType_C_SyoukenUktKbn")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTKBN6)
    public C_SyoukenUktKbn getSyoukenuktkbn6() {
        return syoukenuktkbn6;
    }

    public void setSyoukenuktkbn6(C_SyoukenUktKbn pSyoukenuktkbn6) {
        syoukenuktkbn6 = pSyoukenuktkbn6;
    }

    private String syoukenuktnm6;

    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTNM6)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getSyoukenuktnm6() {
        return syoukenuktnm6;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyoukenuktnm6(String pSyoukenuktnm6) {
        syoukenuktnm6 = pSyoukenuktnm6;
    }

    private BizNumber syoukenuktbnwari6;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTBNWARI6)
    public BizNumber getSyoukenuktbnwari6() {
        return syoukenuktbnwari6;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoukenuktbnwari6(BizNumber pSyoukenuktbnwari6) {
        syoukenuktbnwari6 = pSyoukenuktbnwari6;
    }

    private C_SyoukenUktMidasiKbn syoukenuktmidasikbn7;

    @Type(type="UserType_C_SyoukenUktMidasiKbn")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTMIDASIKBN7)
    public C_SyoukenUktMidasiKbn getSyoukenuktmidasikbn7() {
        return syoukenuktmidasikbn7;
    }

    public void setSyoukenuktmidasikbn7(C_SyoukenUktMidasiKbn pSyoukenuktmidasikbn7) {
        syoukenuktmidasikbn7 = pSyoukenuktmidasikbn7;
    }

    private C_SyoukenUktKbn syoukenuktkbn7;

    @Type(type="UserType_C_SyoukenUktKbn")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTKBN7)
    public C_SyoukenUktKbn getSyoukenuktkbn7() {
        return syoukenuktkbn7;
    }

    public void setSyoukenuktkbn7(C_SyoukenUktKbn pSyoukenuktkbn7) {
        syoukenuktkbn7 = pSyoukenuktkbn7;
    }

    private String syoukenuktnm7;

    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTNM7)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getSyoukenuktnm7() {
        return syoukenuktnm7;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyoukenuktnm7(String pSyoukenuktnm7) {
        syoukenuktnm7 = pSyoukenuktnm7;
    }

    private BizNumber syoukenuktbnwari7;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTBNWARI7)
    public BizNumber getSyoukenuktbnwari7() {
        return syoukenuktbnwari7;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoukenuktbnwari7(BizNumber pSyoukenuktbnwari7) {
        syoukenuktbnwari7 = pSyoukenuktbnwari7;
    }

    private C_SyoukenUktMidasiKbn syoukenuktmidasikbn8;

    @Type(type="UserType_C_SyoukenUktMidasiKbn")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTMIDASIKBN8)
    public C_SyoukenUktMidasiKbn getSyoukenuktmidasikbn8() {
        return syoukenuktmidasikbn8;
    }

    public void setSyoukenuktmidasikbn8(C_SyoukenUktMidasiKbn pSyoukenuktmidasikbn8) {
        syoukenuktmidasikbn8 = pSyoukenuktmidasikbn8;
    }

    private C_SyoukenUktKbn syoukenuktkbn8;

    @Type(type="UserType_C_SyoukenUktKbn")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTKBN8)
    public C_SyoukenUktKbn getSyoukenuktkbn8() {
        return syoukenuktkbn8;
    }

    public void setSyoukenuktkbn8(C_SyoukenUktKbn pSyoukenuktkbn8) {
        syoukenuktkbn8 = pSyoukenuktkbn8;
    }

    private String syoukenuktnm8;

    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTNM8)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getSyoukenuktnm8() {
        return syoukenuktnm8;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyoukenuktnm8(String pSyoukenuktnm8) {
        syoukenuktnm8 = pSyoukenuktnm8;
    }

    private BizNumber syoukenuktbnwari8;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTBNWARI8)
    public BizNumber getSyoukenuktbnwari8() {
        return syoukenuktbnwari8;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoukenuktbnwari8(BizNumber pSyoukenuktbnwari8) {
        syoukenuktbnwari8 = pSyoukenuktbnwari8;
    }

    private C_SyoukenUktMidasiKbn syoukenuktmidasikbn9;

    @Type(type="UserType_C_SyoukenUktMidasiKbn")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTMIDASIKBN9)
    public C_SyoukenUktMidasiKbn getSyoukenuktmidasikbn9() {
        return syoukenuktmidasikbn9;
    }

    public void setSyoukenuktmidasikbn9(C_SyoukenUktMidasiKbn pSyoukenuktmidasikbn9) {
        syoukenuktmidasikbn9 = pSyoukenuktmidasikbn9;
    }

    private C_SyoukenUktKbn syoukenuktkbn9;

    @Type(type="UserType_C_SyoukenUktKbn")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTKBN9)
    public C_SyoukenUktKbn getSyoukenuktkbn9() {
        return syoukenuktkbn9;
    }

    public void setSyoukenuktkbn9(C_SyoukenUktKbn pSyoukenuktkbn9) {
        syoukenuktkbn9 = pSyoukenuktkbn9;
    }

    private String syoukenuktnm9;

    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTNM9)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getSyoukenuktnm9() {
        return syoukenuktnm9;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyoukenuktnm9(String pSyoukenuktnm9) {
        syoukenuktnm9 = pSyoukenuktnm9;
    }

    private BizNumber syoukenuktbnwari9;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTBNWARI9)
    public BizNumber getSyoukenuktbnwari9() {
        return syoukenuktbnwari9;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoukenuktbnwari9(BizNumber pSyoukenuktbnwari9) {
        syoukenuktbnwari9 = pSyoukenuktbnwari9;
    }

    private C_SyoukenUktMidasiKbn syoukenuktmidasikbn10;

    @Type(type="UserType_C_SyoukenUktMidasiKbn")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTMIDASIKBN10)
    public C_SyoukenUktMidasiKbn getSyoukenuktmidasikbn10() {
        return syoukenuktmidasikbn10;
    }

    public void setSyoukenuktmidasikbn10(C_SyoukenUktMidasiKbn pSyoukenuktmidasikbn10) {
        syoukenuktmidasikbn10 = pSyoukenuktmidasikbn10;
    }

    private C_SyoukenUktKbn syoukenuktkbn10;

    @Type(type="UserType_C_SyoukenUktKbn")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTKBN10)
    public C_SyoukenUktKbn getSyoukenuktkbn10() {
        return syoukenuktkbn10;
    }

    public void setSyoukenuktkbn10(C_SyoukenUktKbn pSyoukenuktkbn10) {
        syoukenuktkbn10 = pSyoukenuktkbn10;
    }

    private String syoukenuktnm10;

    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTNM10)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getSyoukenuktnm10() {
        return syoukenuktnm10;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyoukenuktnm10(String pSyoukenuktnm10) {
        syoukenuktnm10 = pSyoukenuktnm10;
    }

    private BizNumber syoukenuktbnwari10;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.SYOUKENUKTBNWARI10)
    public BizNumber getSyoukenuktbnwari10() {
        return syoukenuktbnwari10;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoukenuktbnwari10(BizNumber pSyoukenuktbnwari10) {
        syoukenuktbnwari10 = pSyoukenuktbnwari10;
    }

    private String pmsgcd1;

    @Column(name=GenIT_BAK_HokenSyouken.PMSGCD1)
    public String getPmsgcd1() {
        return pmsgcd1;
    }

    public void setPmsgcd1(String pPmsgcd1) {
        pmsgcd1 = pPmsgcd1;
    }

    private String pmsgcd2;

    @Column(name=GenIT_BAK_HokenSyouken.PMSGCD2)
    public String getPmsgcd2() {
        return pmsgcd2;
    }

    public void setPmsgcd2(String pPmsgcd2) {
        pmsgcd2 = pPmsgcd2;
    }

    private String pmsgcd3;

    @Column(name=GenIT_BAK_HokenSyouken.PMSGCD3)
    public String getPmsgcd3() {
        return pmsgcd3;
    }

    public void setPmsgcd3(String pPmsgcd3) {
        pmsgcd3 = pPmsgcd3;
    }

    private C_Tuukasyu ptuukatype;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.PTUUKATYPE)
    public C_Tuukasyu getPtuukatype() {
        return ptuukatype;
    }

    public void setPtuukatype(C_Tuukasyu pPtuukatype) {
        ptuukatype = pPtuukatype;
    }

    private BizCurrency hokenryou;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHokenryou() {
        return hokenryou;
    }

    public void setHokenryou(BizCurrency pHokenryou) {
        hokenryou = pHokenryou;
        hokenryouValue = null;
        hokenryouType  = null;
    }

    transient private BigDecimal hokenryouValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HOKENRYOU, nullable=true)
    protected BigDecimal getHokenryouValue() {
        if (hokenryouValue == null && hokenryou != null) {
            if (hokenryou.isOptional()) return null;
            return hokenryou.absolute();
        }
        return hokenryouValue;
    }

    protected void setHokenryouValue(BigDecimal value) {
        hokenryouValue = value;
        hokenryou = Optional.fromNullable(toCurrencyType(hokenryouType))
            .transform(bizCurrencyTransformer(getHokenryouValue()))
            .orNull();
    }

    transient private String hokenryouType = null;

    @Column(name=HOKENRYOU + "$", nullable=true)
    protected String getHokenryouType() {
        if (hokenryouType == null && hokenryou != null) return hokenryou.getType().toString();
        if (hokenryouType == null && getHokenryouValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hokenryou$' should not be NULL."));
        }
        return hokenryouType;
    }

    protected void setHokenryouType(String type) {
        hokenryouType = type;
        hokenryou = Optional.fromNullable(toCurrencyType(hokenryouType))
            .transform(bizCurrencyTransformer(getHokenryouValue()))
            .orNull();
    }

    private String ptuuka;

    @Column(name=GenIT_BAK_HokenSyouken.PTUUKA)
    public String getPtuuka() {
        return ptuuka;
    }

    public void setPtuuka(String pPtuuka) {
        ptuuka = pPtuuka;
    }

    private String ptokuyakumsgcd;

    @Column(name=GenIT_BAK_HokenSyouken.PTOKUYAKUMSGCD)
    public String getPtokuyakumsgcd() {
        return ptokuyakumsgcd;
    }

    public void setPtokuyakumsgcd(String pPtokuyakumsgcd) {
        ptokuyakumsgcd = pPtokuyakumsgcd;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private String phrkkknmidasikbn;

    @Column(name=GenIT_BAK_HokenSyouken.PHRKKKNMIDASIKBN)
    public String getPhrkkknmidasikbn() {
        return phrkkknmidasikbn;
    }

    public void setPhrkkknmidasikbn(String pPhrkkknmidasikbn) {
        phrkkknmidasikbn = pPhrkkknmidasikbn;
    }

    private String hrkkknmsgkbn;

    @Column(name=GenIT_BAK_HokenSyouken.HRKKKNMSGKBN)
    public String getHrkkknmsgkbn() {
        return hrkkknmsgkbn;
    }

    public void setHrkkknmsgkbn(String pHrkkknmsgkbn) {
        hrkkknmsgkbn = pHrkkknmsgkbn;
    }

    private String hrkkaisuumsgkbn;

    @Column(name=GenIT_BAK_HokenSyouken.HRKKAISUUMSGKBN)
    public String getHrkkaisuumsgkbn() {
        return hrkkaisuumsgkbn;
    }

    public void setHrkkaisuumsgkbn(String pHrkkaisuumsgkbn) {
        hrkkaisuumsgkbn = pHrkkaisuumsgkbn;
    }

    private String hrkkitukimsgkbn;

    @Column(name=GenIT_BAK_HokenSyouken.HRKKITUKIMSGKBN)
    public String getHrkkitukimsgkbn() {
        return hrkkitukimsgkbn;
    }

    public void setHrkkitukimsgkbn(String pHrkkitukimsgkbn) {
        hrkkitukimsgkbn = pHrkkitukimsgkbn;
    }

    private String hrkhouhoumsgkbn;

    @Column(name=GenIT_BAK_HokenSyouken.HRKHOUHOUMSGKBN)
    public String getHrkhouhoumsgkbn() {
        return hrkhouhoumsgkbn;
    }

    public void setHrkhouhoumsgkbn(String pHrkhouhoumsgkbn) {
        hrkhouhoumsgkbn = pHrkhouhoumsgkbn;
    }

    private Integer syukyktkykrenban1;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKRENBAN1)
    public Integer getSyukyktkykrenban1() {
        return syukyktkykrenban1;
    }

    public void setSyukyktkykrenban1(Integer pSyukyktkykrenban1) {
        syukyktkykrenban1 = pSyukyktkykrenban1;
    }

    private String syukyktkykmsgkbn1;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKMSGKBN1)
    public String getSyukyktkykmsgkbn1() {
        return syukyktkykmsgkbn1;
    }

    public void setSyukyktkykmsgkbn1(String pSyukyktkykmsgkbn1) {
        syukyktkykmsgkbn1 = pSyukyktkykmsgkbn1;
    }

    private String syukyktkyksmsgkbn1;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKSMSGKBN1)
    public String getSyukyktkyksmsgkbn1() {
        return syukyktkyksmsgkbn1;
    }

    public void setSyukyktkyksmsgkbn1(String pSyukyktkyksmsgkbn1) {
        syukyktkyksmsgkbn1 = pSyukyktkyksmsgkbn1;
    }

    private String syukyktkykhknkknmsgkbn1;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKHKNKKNMSGKBN1)
    public String getSyukyktkykhknkknmsgkbn1() {
        return syukyktkykhknkknmsgkbn1;
    }

    public void setSyukyktkykhknkknmsgkbn1(String pSyukyktkykhknkknmsgkbn1) {
        syukyktkykhknkknmsgkbn1 = pSyukyktkykhknkknmsgkbn1;
    }

    private C_Tuukasyu syukyktkykstuukatype1;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKSTUUKATYPE1)
    public C_Tuukasyu getSyukyktkykstuukatype1() {
        return syukyktkykstuukatype1;
    }

    public void setSyukyktkykstuukatype1(C_Tuukasyu pSyukyktkykstuukatype1) {
        syukyktkykstuukatype1 = pSyukyktkykstuukatype1;
    }

    private BizCurrency syukyktkykhknkngk1;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSyukyktkykhknkngk1() {
        return syukyktkykhknkngk1;
    }

    public void setSyukyktkykhknkngk1(BizCurrency pSyukyktkykhknkngk1) {
        syukyktkykhknkngk1 = pSyukyktkykhknkngk1;
        syukyktkykhknkngk1Value = null;
        syukyktkykhknkngk1Type  = null;
    }

    transient private BigDecimal syukyktkykhknkngk1Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=SYUKYKTKYKHKNKNGK1, nullable=true)
    protected BigDecimal getSyukyktkykhknkngk1Value() {
        if (syukyktkykhknkngk1Value == null && syukyktkykhknkngk1 != null) {
            if (syukyktkykhknkngk1.isOptional()) return null;
            return syukyktkykhknkngk1.absolute();
        }
        return syukyktkykhknkngk1Value;
    }

    protected void setSyukyktkykhknkngk1Value(BigDecimal value) {
        syukyktkykhknkngk1Value = value;
        syukyktkykhknkngk1 = Optional.fromNullable(toCurrencyType(syukyktkykhknkngk1Type))
            .transform(bizCurrencyTransformer(getSyukyktkykhknkngk1Value()))
            .orNull();
    }

    transient private String syukyktkykhknkngk1Type = null;

    @Column(name=SYUKYKTKYKHKNKNGK1 + "$", nullable=true)
    protected String getSyukyktkykhknkngk1Type() {
        if (syukyktkykhknkngk1Type == null && syukyktkykhknkngk1 != null) return syukyktkykhknkngk1.getType().toString();
        if (syukyktkykhknkngk1Type == null && getSyukyktkykhknkngk1Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'syukyktkykhknkngk1$' should not be NULL."));
        }
        return syukyktkykhknkngk1Type;
    }

    protected void setSyukyktkykhknkngk1Type(String type) {
        syukyktkykhknkngk1Type = type;
        syukyktkykhknkngk1 = Optional.fromNullable(toCurrencyType(syukyktkykhknkngk1Type))
            .transform(bizCurrencyTransformer(getSyukyktkykhknkngk1Value()))
            .orNull();
    }

    private Integer syukyktkykdai1hknkkn1;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKDAI1HKNKKN1)
    public Integer getSyukyktkykdai1hknkkn1() {
        return syukyktkykdai1hknkkn1;
    }

    public void setSyukyktkykdai1hknkkn1(Integer pSyukyktkykdai1hknkkn1) {
        syukyktkykdai1hknkkn1 = pSyukyktkykdai1hknkkn1;
    }

    private Integer syukyktkykdai2hknkkn1;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKDAI2HKNKKN1)
    public Integer getSyukyktkykdai2hknkkn1() {
        return syukyktkykdai2hknkkn1;
    }

    public void setSyukyktkykdai2hknkkn1(Integer pSyukyktkykdai2hknkkn1) {
        syukyktkykdai2hknkkn1 = pSyukyktkykdai2hknkkn1;
    }

    private BizDate syutkdai1hknkknymdto1;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.SYUTKDAI1HKNKKNYMDTO1)
    public BizDate getSyutkdai1hknkknymdto1() {
        return syutkdai1hknkknymdto1;
    }

    public void setSyutkdai1hknkknymdto1(BizDate pSyutkdai1hknkknymdto1) {
        syutkdai1hknkknymdto1 = pSyutkdai1hknkknymdto1;
    }

    private BizDate syutkdai2hknkknymdto1;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.SYUTKDAI2HKNKKNYMDTO1)
    public BizDate getSyutkdai2hknkknymdto1() {
        return syutkdai2hknkknymdto1;
    }

    public void setSyutkdai2hknkknymdto1(BizDate pSyutkdai2hknkknymdto1) {
        syutkdai2hknkknymdto1 = pSyutkdai2hknkknymdto1;
    }

    private Integer syukyktkykrenban2;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKRENBAN2)
    public Integer getSyukyktkykrenban2() {
        return syukyktkykrenban2;
    }

    public void setSyukyktkykrenban2(Integer pSyukyktkykrenban2) {
        syukyktkykrenban2 = pSyukyktkykrenban2;
    }

    private String syukyktkykmsgkbn2;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKMSGKBN2)
    public String getSyukyktkykmsgkbn2() {
        return syukyktkykmsgkbn2;
    }

    public void setSyukyktkykmsgkbn2(String pSyukyktkykmsgkbn2) {
        syukyktkykmsgkbn2 = pSyukyktkykmsgkbn2;
    }

    private String syukyktkyksmsgkbn2;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKSMSGKBN2)
    public String getSyukyktkyksmsgkbn2() {
        return syukyktkyksmsgkbn2;
    }

    public void setSyukyktkyksmsgkbn2(String pSyukyktkyksmsgkbn2) {
        syukyktkyksmsgkbn2 = pSyukyktkyksmsgkbn2;
    }

    private String syukyktkykhknkknmsgkbn2;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKHKNKKNMSGKBN2)
    public String getSyukyktkykhknkknmsgkbn2() {
        return syukyktkykhknkknmsgkbn2;
    }

    public void setSyukyktkykhknkknmsgkbn2(String pSyukyktkykhknkknmsgkbn2) {
        syukyktkykhknkknmsgkbn2 = pSyukyktkykhknkknmsgkbn2;
    }

    private C_Tuukasyu syukyktkykstuukatype2;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKSTUUKATYPE2)
    public C_Tuukasyu getSyukyktkykstuukatype2() {
        return syukyktkykstuukatype2;
    }

    public void setSyukyktkykstuukatype2(C_Tuukasyu pSyukyktkykstuukatype2) {
        syukyktkykstuukatype2 = pSyukyktkykstuukatype2;
    }

    private BizCurrency syukyktkykhknkngk2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSyukyktkykhknkngk2() {
        return syukyktkykhknkngk2;
    }

    public void setSyukyktkykhknkngk2(BizCurrency pSyukyktkykhknkngk2) {
        syukyktkykhknkngk2 = pSyukyktkykhknkngk2;
        syukyktkykhknkngk2Value = null;
        syukyktkykhknkngk2Type  = null;
    }

    transient private BigDecimal syukyktkykhknkngk2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=SYUKYKTKYKHKNKNGK2, nullable=true)
    protected BigDecimal getSyukyktkykhknkngk2Value() {
        if (syukyktkykhknkngk2Value == null && syukyktkykhknkngk2 != null) {
            if (syukyktkykhknkngk2.isOptional()) return null;
            return syukyktkykhknkngk2.absolute();
        }
        return syukyktkykhknkngk2Value;
    }

    protected void setSyukyktkykhknkngk2Value(BigDecimal value) {
        syukyktkykhknkngk2Value = value;
        syukyktkykhknkngk2 = Optional.fromNullable(toCurrencyType(syukyktkykhknkngk2Type))
            .transform(bizCurrencyTransformer(getSyukyktkykhknkngk2Value()))
            .orNull();
    }

    transient private String syukyktkykhknkngk2Type = null;

    @Column(name=SYUKYKTKYKHKNKNGK2 + "$", nullable=true)
    protected String getSyukyktkykhknkngk2Type() {
        if (syukyktkykhknkngk2Type == null && syukyktkykhknkngk2 != null) return syukyktkykhknkngk2.getType().toString();
        if (syukyktkykhknkngk2Type == null && getSyukyktkykhknkngk2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'syukyktkykhknkngk2$' should not be NULL."));
        }
        return syukyktkykhknkngk2Type;
    }

    protected void setSyukyktkykhknkngk2Type(String type) {
        syukyktkykhknkngk2Type = type;
        syukyktkykhknkngk2 = Optional.fromNullable(toCurrencyType(syukyktkykhknkngk2Type))
            .transform(bizCurrencyTransformer(getSyukyktkykhknkngk2Value()))
            .orNull();
    }

    private Integer syukyktkykdai1hknkkn2;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKDAI1HKNKKN2)
    public Integer getSyukyktkykdai1hknkkn2() {
        return syukyktkykdai1hknkkn2;
    }

    public void setSyukyktkykdai1hknkkn2(Integer pSyukyktkykdai1hknkkn2) {
        syukyktkykdai1hknkkn2 = pSyukyktkykdai1hknkkn2;
    }

    private Integer syukyktkykdai2hknkkn2;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKDAI2HKNKKN2)
    public Integer getSyukyktkykdai2hknkkn2() {
        return syukyktkykdai2hknkkn2;
    }

    public void setSyukyktkykdai2hknkkn2(Integer pSyukyktkykdai2hknkkn2) {
        syukyktkykdai2hknkkn2 = pSyukyktkykdai2hknkkn2;
    }

    private BizDate syutkdai1hknkknymdto2;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.SYUTKDAI1HKNKKNYMDTO2)
    public BizDate getSyutkdai1hknkknymdto2() {
        return syutkdai1hknkknymdto2;
    }

    public void setSyutkdai1hknkknymdto2(BizDate pSyutkdai1hknkknymdto2) {
        syutkdai1hknkknymdto2 = pSyutkdai1hknkknymdto2;
    }

    private BizDate syutkdai2hknkknymdto2;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.SYUTKDAI2HKNKKNYMDTO2)
    public BizDate getSyutkdai2hknkknymdto2() {
        return syutkdai2hknkknymdto2;
    }

    public void setSyutkdai2hknkknymdto2(BizDate pSyutkdai2hknkknymdto2) {
        syutkdai2hknkknymdto2 = pSyutkdai2hknkknymdto2;
    }

    private Integer syukyktkykrenban3;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKRENBAN3)
    public Integer getSyukyktkykrenban3() {
        return syukyktkykrenban3;
    }

    public void setSyukyktkykrenban3(Integer pSyukyktkykrenban3) {
        syukyktkykrenban3 = pSyukyktkykrenban3;
    }

    private String syukyktkykmsgkbn3;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKMSGKBN3)
    public String getSyukyktkykmsgkbn3() {
        return syukyktkykmsgkbn3;
    }

    public void setSyukyktkykmsgkbn3(String pSyukyktkykmsgkbn3) {
        syukyktkykmsgkbn3 = pSyukyktkykmsgkbn3;
    }

    private String syukyktkyksmsgkbn3;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKSMSGKBN3)
    public String getSyukyktkyksmsgkbn3() {
        return syukyktkyksmsgkbn3;
    }

    public void setSyukyktkyksmsgkbn3(String pSyukyktkyksmsgkbn3) {
        syukyktkyksmsgkbn3 = pSyukyktkyksmsgkbn3;
    }

    private String syukyktkykhknkknmsgkbn3;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKHKNKKNMSGKBN3)
    public String getSyukyktkykhknkknmsgkbn3() {
        return syukyktkykhknkknmsgkbn3;
    }

    public void setSyukyktkykhknkknmsgkbn3(String pSyukyktkykhknkknmsgkbn3) {
        syukyktkykhknkknmsgkbn3 = pSyukyktkykhknkknmsgkbn3;
    }

    private C_Tuukasyu syukyktkykstuukatype3;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKSTUUKATYPE3)
    public C_Tuukasyu getSyukyktkykstuukatype3() {
        return syukyktkykstuukatype3;
    }

    public void setSyukyktkykstuukatype3(C_Tuukasyu pSyukyktkykstuukatype3) {
        syukyktkykstuukatype3 = pSyukyktkykstuukatype3;
    }

    private BizCurrency syukyktkykhknkngk3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSyukyktkykhknkngk3() {
        return syukyktkykhknkngk3;
    }

    public void setSyukyktkykhknkngk3(BizCurrency pSyukyktkykhknkngk3) {
        syukyktkykhknkngk3 = pSyukyktkykhknkngk3;
        syukyktkykhknkngk3Value = null;
        syukyktkykhknkngk3Type  = null;
    }

    transient private BigDecimal syukyktkykhknkngk3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=SYUKYKTKYKHKNKNGK3, nullable=true)
    protected BigDecimal getSyukyktkykhknkngk3Value() {
        if (syukyktkykhknkngk3Value == null && syukyktkykhknkngk3 != null) {
            if (syukyktkykhknkngk3.isOptional()) return null;
            return syukyktkykhknkngk3.absolute();
        }
        return syukyktkykhknkngk3Value;
    }

    protected void setSyukyktkykhknkngk3Value(BigDecimal value) {
        syukyktkykhknkngk3Value = value;
        syukyktkykhknkngk3 = Optional.fromNullable(toCurrencyType(syukyktkykhknkngk3Type))
            .transform(bizCurrencyTransformer(getSyukyktkykhknkngk3Value()))
            .orNull();
    }

    transient private String syukyktkykhknkngk3Type = null;

    @Column(name=SYUKYKTKYKHKNKNGK3 + "$", nullable=true)
    protected String getSyukyktkykhknkngk3Type() {
        if (syukyktkykhknkngk3Type == null && syukyktkykhknkngk3 != null) return syukyktkykhknkngk3.getType().toString();
        if (syukyktkykhknkngk3Type == null && getSyukyktkykhknkngk3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'syukyktkykhknkngk3$' should not be NULL."));
        }
        return syukyktkykhknkngk3Type;
    }

    protected void setSyukyktkykhknkngk3Type(String type) {
        syukyktkykhknkngk3Type = type;
        syukyktkykhknkngk3 = Optional.fromNullable(toCurrencyType(syukyktkykhknkngk3Type))
            .transform(bizCurrencyTransformer(getSyukyktkykhknkngk3Value()))
            .orNull();
    }

    private Integer syukyktkykdai1hknkkn3;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKDAI1HKNKKN3)
    public Integer getSyukyktkykdai1hknkkn3() {
        return syukyktkykdai1hknkkn3;
    }

    public void setSyukyktkykdai1hknkkn3(Integer pSyukyktkykdai1hknkkn3) {
        syukyktkykdai1hknkkn3 = pSyukyktkykdai1hknkkn3;
    }

    private Integer syukyktkykdai2hknkkn3;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKDAI2HKNKKN3)
    public Integer getSyukyktkykdai2hknkkn3() {
        return syukyktkykdai2hknkkn3;
    }

    public void setSyukyktkykdai2hknkkn3(Integer pSyukyktkykdai2hknkkn3) {
        syukyktkykdai2hknkkn3 = pSyukyktkykdai2hknkkn3;
    }

    private BizDate syutkdai1hknkknymdto3;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.SYUTKDAI1HKNKKNYMDTO3)
    public BizDate getSyutkdai1hknkknymdto3() {
        return syutkdai1hknkknymdto3;
    }

    public void setSyutkdai1hknkknymdto3(BizDate pSyutkdai1hknkknymdto3) {
        syutkdai1hknkknymdto3 = pSyutkdai1hknkknymdto3;
    }

    private BizDate syutkdai2hknkknymdto3;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.SYUTKDAI2HKNKKNYMDTO3)
    public BizDate getSyutkdai2hknkknymdto3() {
        return syutkdai2hknkknymdto3;
    }

    public void setSyutkdai2hknkknymdto3(BizDate pSyutkdai2hknkknymdto3) {
        syutkdai2hknkknymdto3 = pSyutkdai2hknkknymdto3;
    }

    private Integer syukyktkykrenban4;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKRENBAN4)
    public Integer getSyukyktkykrenban4() {
        return syukyktkykrenban4;
    }

    public void setSyukyktkykrenban4(Integer pSyukyktkykrenban4) {
        syukyktkykrenban4 = pSyukyktkykrenban4;
    }

    private String syukyktkykmsgkbn4;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKMSGKBN4)
    public String getSyukyktkykmsgkbn4() {
        return syukyktkykmsgkbn4;
    }

    public void setSyukyktkykmsgkbn4(String pSyukyktkykmsgkbn4) {
        syukyktkykmsgkbn4 = pSyukyktkykmsgkbn4;
    }

    private String syukyktkyksmsgkbn4;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKSMSGKBN4)
    public String getSyukyktkyksmsgkbn4() {
        return syukyktkyksmsgkbn4;
    }

    public void setSyukyktkyksmsgkbn4(String pSyukyktkyksmsgkbn4) {
        syukyktkyksmsgkbn4 = pSyukyktkyksmsgkbn4;
    }

    private String syukyktkykhknkknmsgkbn4;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKHKNKKNMSGKBN4)
    public String getSyukyktkykhknkknmsgkbn4() {
        return syukyktkykhknkknmsgkbn4;
    }

    public void setSyukyktkykhknkknmsgkbn4(String pSyukyktkykhknkknmsgkbn4) {
        syukyktkykhknkknmsgkbn4 = pSyukyktkykhknkknmsgkbn4;
    }

    private C_Tuukasyu syukyktkykstuukatype4;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKSTUUKATYPE4)
    public C_Tuukasyu getSyukyktkykstuukatype4() {
        return syukyktkykstuukatype4;
    }

    public void setSyukyktkykstuukatype4(C_Tuukasyu pSyukyktkykstuukatype4) {
        syukyktkykstuukatype4 = pSyukyktkykstuukatype4;
    }

    private BizCurrency syukyktkykhknkngk4;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSyukyktkykhknkngk4() {
        return syukyktkykhknkngk4;
    }

    public void setSyukyktkykhknkngk4(BizCurrency pSyukyktkykhknkngk4) {
        syukyktkykhknkngk4 = pSyukyktkykhknkngk4;
        syukyktkykhknkngk4Value = null;
        syukyktkykhknkngk4Type  = null;
    }

    transient private BigDecimal syukyktkykhknkngk4Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=SYUKYKTKYKHKNKNGK4, nullable=true)
    protected BigDecimal getSyukyktkykhknkngk4Value() {
        if (syukyktkykhknkngk4Value == null && syukyktkykhknkngk4 != null) {
            if (syukyktkykhknkngk4.isOptional()) return null;
            return syukyktkykhknkngk4.absolute();
        }
        return syukyktkykhknkngk4Value;
    }

    protected void setSyukyktkykhknkngk4Value(BigDecimal value) {
        syukyktkykhknkngk4Value = value;
        syukyktkykhknkngk4 = Optional.fromNullable(toCurrencyType(syukyktkykhknkngk4Type))
            .transform(bizCurrencyTransformer(getSyukyktkykhknkngk4Value()))
            .orNull();
    }

    transient private String syukyktkykhknkngk4Type = null;

    @Column(name=SYUKYKTKYKHKNKNGK4 + "$", nullable=true)
    protected String getSyukyktkykhknkngk4Type() {
        if (syukyktkykhknkngk4Type == null && syukyktkykhknkngk4 != null) return syukyktkykhknkngk4.getType().toString();
        if (syukyktkykhknkngk4Type == null && getSyukyktkykhknkngk4Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'syukyktkykhknkngk4$' should not be NULL."));
        }
        return syukyktkykhknkngk4Type;
    }

    protected void setSyukyktkykhknkngk4Type(String type) {
        syukyktkykhknkngk4Type = type;
        syukyktkykhknkngk4 = Optional.fromNullable(toCurrencyType(syukyktkykhknkngk4Type))
            .transform(bizCurrencyTransformer(getSyukyktkykhknkngk4Value()))
            .orNull();
    }

    private Integer syukyktkykdai1hknkkn4;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKDAI1HKNKKN4)
    public Integer getSyukyktkykdai1hknkkn4() {
        return syukyktkykdai1hknkkn4;
    }

    public void setSyukyktkykdai1hknkkn4(Integer pSyukyktkykdai1hknkkn4) {
        syukyktkykdai1hknkkn4 = pSyukyktkykdai1hknkkn4;
    }

    private Integer syukyktkykdai2hknkkn4;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKDAI2HKNKKN4)
    public Integer getSyukyktkykdai2hknkkn4() {
        return syukyktkykdai2hknkkn4;
    }

    public void setSyukyktkykdai2hknkkn4(Integer pSyukyktkykdai2hknkkn4) {
        syukyktkykdai2hknkkn4 = pSyukyktkykdai2hknkkn4;
    }

    private BizDate syutkdai1hknkknymdto4;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.SYUTKDAI1HKNKKNYMDTO4)
    public BizDate getSyutkdai1hknkknymdto4() {
        return syutkdai1hknkknymdto4;
    }

    public void setSyutkdai1hknkknymdto4(BizDate pSyutkdai1hknkknymdto4) {
        syutkdai1hknkknymdto4 = pSyutkdai1hknkknymdto4;
    }

    private BizDate syutkdai2hknkknymdto4;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.SYUTKDAI2HKNKKNYMDTO4)
    public BizDate getSyutkdai2hknkknymdto4() {
        return syutkdai2hknkknymdto4;
    }

    public void setSyutkdai2hknkknymdto4(BizDate pSyutkdai2hknkknymdto4) {
        syutkdai2hknkknymdto4 = pSyutkdai2hknkknymdto4;
    }

    private Integer syukyktkykrenban5;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKRENBAN5)
    public Integer getSyukyktkykrenban5() {
        return syukyktkykrenban5;
    }

    public void setSyukyktkykrenban5(Integer pSyukyktkykrenban5) {
        syukyktkykrenban5 = pSyukyktkykrenban5;
    }

    private String syukyktkykmsgkbn5;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKMSGKBN5)
    public String getSyukyktkykmsgkbn5() {
        return syukyktkykmsgkbn5;
    }

    public void setSyukyktkykmsgkbn5(String pSyukyktkykmsgkbn5) {
        syukyktkykmsgkbn5 = pSyukyktkykmsgkbn5;
    }

    private String syukyktkyksmsgkbn5;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKSMSGKBN5)
    public String getSyukyktkyksmsgkbn5() {
        return syukyktkyksmsgkbn5;
    }

    public void setSyukyktkyksmsgkbn5(String pSyukyktkyksmsgkbn5) {
        syukyktkyksmsgkbn5 = pSyukyktkyksmsgkbn5;
    }

    private String syukyktkykhknkknmsgkbn5;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKHKNKKNMSGKBN5)
    public String getSyukyktkykhknkknmsgkbn5() {
        return syukyktkykhknkknmsgkbn5;
    }

    public void setSyukyktkykhknkknmsgkbn5(String pSyukyktkykhknkknmsgkbn5) {
        syukyktkykhknkknmsgkbn5 = pSyukyktkykhknkknmsgkbn5;
    }

    private C_Tuukasyu syukyktkykstuukatype5;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKSTUUKATYPE5)
    public C_Tuukasyu getSyukyktkykstuukatype5() {
        return syukyktkykstuukatype5;
    }

    public void setSyukyktkykstuukatype5(C_Tuukasyu pSyukyktkykstuukatype5) {
        syukyktkykstuukatype5 = pSyukyktkykstuukatype5;
    }

    private BizCurrency syukyktkykhknkngk5;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSyukyktkykhknkngk5() {
        return syukyktkykhknkngk5;
    }

    public void setSyukyktkykhknkngk5(BizCurrency pSyukyktkykhknkngk5) {
        syukyktkykhknkngk5 = pSyukyktkykhknkngk5;
        syukyktkykhknkngk5Value = null;
        syukyktkykhknkngk5Type  = null;
    }

    transient private BigDecimal syukyktkykhknkngk5Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=SYUKYKTKYKHKNKNGK5, nullable=true)
    protected BigDecimal getSyukyktkykhknkngk5Value() {
        if (syukyktkykhknkngk5Value == null && syukyktkykhknkngk5 != null) {
            if (syukyktkykhknkngk5.isOptional()) return null;
            return syukyktkykhknkngk5.absolute();
        }
        return syukyktkykhknkngk5Value;
    }

    protected void setSyukyktkykhknkngk5Value(BigDecimal value) {
        syukyktkykhknkngk5Value = value;
        syukyktkykhknkngk5 = Optional.fromNullable(toCurrencyType(syukyktkykhknkngk5Type))
            .transform(bizCurrencyTransformer(getSyukyktkykhknkngk5Value()))
            .orNull();
    }

    transient private String syukyktkykhknkngk5Type = null;

    @Column(name=SYUKYKTKYKHKNKNGK5 + "$", nullable=true)
    protected String getSyukyktkykhknkngk5Type() {
        if (syukyktkykhknkngk5Type == null && syukyktkykhknkngk5 != null) return syukyktkykhknkngk5.getType().toString();
        if (syukyktkykhknkngk5Type == null && getSyukyktkykhknkngk5Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'syukyktkykhknkngk5$' should not be NULL."));
        }
        return syukyktkykhknkngk5Type;
    }

    protected void setSyukyktkykhknkngk5Type(String type) {
        syukyktkykhknkngk5Type = type;
        syukyktkykhknkngk5 = Optional.fromNullable(toCurrencyType(syukyktkykhknkngk5Type))
            .transform(bizCurrencyTransformer(getSyukyktkykhknkngk5Value()))
            .orNull();
    }

    private Integer syukyktkykdai1hknkkn5;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKDAI1HKNKKN5)
    public Integer getSyukyktkykdai1hknkkn5() {
        return syukyktkykdai1hknkkn5;
    }

    public void setSyukyktkykdai1hknkkn5(Integer pSyukyktkykdai1hknkkn5) {
        syukyktkykdai1hknkkn5 = pSyukyktkykdai1hknkkn5;
    }

    private Integer syukyktkykdai2hknkkn5;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKDAI2HKNKKN5)
    public Integer getSyukyktkykdai2hknkkn5() {
        return syukyktkykdai2hknkkn5;
    }

    public void setSyukyktkykdai2hknkkn5(Integer pSyukyktkykdai2hknkkn5) {
        syukyktkykdai2hknkkn5 = pSyukyktkykdai2hknkkn5;
    }

    private BizDate syutkdai1hknkknymdto5;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.SYUTKDAI1HKNKKNYMDTO5)
    public BizDate getSyutkdai1hknkknymdto5() {
        return syutkdai1hknkknymdto5;
    }

    public void setSyutkdai1hknkknymdto5(BizDate pSyutkdai1hknkknymdto5) {
        syutkdai1hknkknymdto5 = pSyutkdai1hknkknymdto5;
    }

    private BizDate syutkdai2hknkknymdto5;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.SYUTKDAI2HKNKKNYMDTO5)
    public BizDate getSyutkdai2hknkknymdto5() {
        return syutkdai2hknkknymdto5;
    }

    public void setSyutkdai2hknkknymdto5(BizDate pSyutkdai2hknkknymdto5) {
        syutkdai2hknkknymdto5 = pSyutkdai2hknkknymdto5;
    }

    private Integer syukyktkykrenban6;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKRENBAN6)
    public Integer getSyukyktkykrenban6() {
        return syukyktkykrenban6;
    }

    public void setSyukyktkykrenban6(Integer pSyukyktkykrenban6) {
        syukyktkykrenban6 = pSyukyktkykrenban6;
    }

    private String syukyktkykmsgkbn6;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKMSGKBN6)
    public String getSyukyktkykmsgkbn6() {
        return syukyktkykmsgkbn6;
    }

    public void setSyukyktkykmsgkbn6(String pSyukyktkykmsgkbn6) {
        syukyktkykmsgkbn6 = pSyukyktkykmsgkbn6;
    }

    private String syukyktkyksmsgkbn6;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKSMSGKBN6)
    public String getSyukyktkyksmsgkbn6() {
        return syukyktkyksmsgkbn6;
    }

    public void setSyukyktkyksmsgkbn6(String pSyukyktkyksmsgkbn6) {
        syukyktkyksmsgkbn6 = pSyukyktkyksmsgkbn6;
    }

    private String syukyktkykhknkknmsgkbn6;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKHKNKKNMSGKBN6)
    public String getSyukyktkykhknkknmsgkbn6() {
        return syukyktkykhknkknmsgkbn6;
    }

    public void setSyukyktkykhknkknmsgkbn6(String pSyukyktkykhknkknmsgkbn6) {
        syukyktkykhknkknmsgkbn6 = pSyukyktkykhknkknmsgkbn6;
    }

    private C_Tuukasyu syukyktkykstuukatype6;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKSTUUKATYPE6)
    public C_Tuukasyu getSyukyktkykstuukatype6() {
        return syukyktkykstuukatype6;
    }

    public void setSyukyktkykstuukatype6(C_Tuukasyu pSyukyktkykstuukatype6) {
        syukyktkykstuukatype6 = pSyukyktkykstuukatype6;
    }

    private BizCurrency syukyktkykhknkngk6;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSyukyktkykhknkngk6() {
        return syukyktkykhknkngk6;
    }

    public void setSyukyktkykhknkngk6(BizCurrency pSyukyktkykhknkngk6) {
        syukyktkykhknkngk6 = pSyukyktkykhknkngk6;
        syukyktkykhknkngk6Value = null;
        syukyktkykhknkngk6Type  = null;
    }

    transient private BigDecimal syukyktkykhknkngk6Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=SYUKYKTKYKHKNKNGK6, nullable=true)
    protected BigDecimal getSyukyktkykhknkngk6Value() {
        if (syukyktkykhknkngk6Value == null && syukyktkykhknkngk6 != null) {
            if (syukyktkykhknkngk6.isOptional()) return null;
            return syukyktkykhknkngk6.absolute();
        }
        return syukyktkykhknkngk6Value;
    }

    protected void setSyukyktkykhknkngk6Value(BigDecimal value) {
        syukyktkykhknkngk6Value = value;
        syukyktkykhknkngk6 = Optional.fromNullable(toCurrencyType(syukyktkykhknkngk6Type))
            .transform(bizCurrencyTransformer(getSyukyktkykhknkngk6Value()))
            .orNull();
    }

    transient private String syukyktkykhknkngk6Type = null;

    @Column(name=SYUKYKTKYKHKNKNGK6 + "$", nullable=true)
    protected String getSyukyktkykhknkngk6Type() {
        if (syukyktkykhknkngk6Type == null && syukyktkykhknkngk6 != null) return syukyktkykhknkngk6.getType().toString();
        if (syukyktkykhknkngk6Type == null && getSyukyktkykhknkngk6Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'syukyktkykhknkngk6$' should not be NULL."));
        }
        return syukyktkykhknkngk6Type;
    }

    protected void setSyukyktkykhknkngk6Type(String type) {
        syukyktkykhknkngk6Type = type;
        syukyktkykhknkngk6 = Optional.fromNullable(toCurrencyType(syukyktkykhknkngk6Type))
            .transform(bizCurrencyTransformer(getSyukyktkykhknkngk6Value()))
            .orNull();
    }

    private Integer syukyktkykdai1hknkkn6;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKDAI1HKNKKN6)
    public Integer getSyukyktkykdai1hknkkn6() {
        return syukyktkykdai1hknkkn6;
    }

    public void setSyukyktkykdai1hknkkn6(Integer pSyukyktkykdai1hknkkn6) {
        syukyktkykdai1hknkkn6 = pSyukyktkykdai1hknkkn6;
    }

    private Integer syukyktkykdai2hknkkn6;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKDAI2HKNKKN6)
    public Integer getSyukyktkykdai2hknkkn6() {
        return syukyktkykdai2hknkkn6;
    }

    public void setSyukyktkykdai2hknkkn6(Integer pSyukyktkykdai2hknkkn6) {
        syukyktkykdai2hknkkn6 = pSyukyktkykdai2hknkkn6;
    }

    private BizDate syutkdai1hknkknymdto6;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.SYUTKDAI1HKNKKNYMDTO6)
    public BizDate getSyutkdai1hknkknymdto6() {
        return syutkdai1hknkknymdto6;
    }

    public void setSyutkdai1hknkknymdto6(BizDate pSyutkdai1hknkknymdto6) {
        syutkdai1hknkknymdto6 = pSyutkdai1hknkknymdto6;
    }

    private BizDate syutkdai2hknkknymdto6;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.SYUTKDAI2HKNKKNYMDTO6)
    public BizDate getSyutkdai2hknkknymdto6() {
        return syutkdai2hknkknymdto6;
    }

    public void setSyutkdai2hknkknymdto6(BizDate pSyutkdai2hknkknymdto6) {
        syutkdai2hknkknymdto6 = pSyutkdai2hknkknymdto6;
    }

    private Integer syukyktkykrenban7;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKRENBAN7)
    public Integer getSyukyktkykrenban7() {
        return syukyktkykrenban7;
    }

    public void setSyukyktkykrenban7(Integer pSyukyktkykrenban7) {
        syukyktkykrenban7 = pSyukyktkykrenban7;
    }

    private String syukyktkykmsgkbn7;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKMSGKBN7)
    public String getSyukyktkykmsgkbn7() {
        return syukyktkykmsgkbn7;
    }

    public void setSyukyktkykmsgkbn7(String pSyukyktkykmsgkbn7) {
        syukyktkykmsgkbn7 = pSyukyktkykmsgkbn7;
    }

    private String syukyktkyksmsgkbn7;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKSMSGKBN7)
    public String getSyukyktkyksmsgkbn7() {
        return syukyktkyksmsgkbn7;
    }

    public void setSyukyktkyksmsgkbn7(String pSyukyktkyksmsgkbn7) {
        syukyktkyksmsgkbn7 = pSyukyktkyksmsgkbn7;
    }

    private String syukyktkykhknkknmsgkbn7;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKHKNKKNMSGKBN7)
    public String getSyukyktkykhknkknmsgkbn7() {
        return syukyktkykhknkknmsgkbn7;
    }

    public void setSyukyktkykhknkknmsgkbn7(String pSyukyktkykhknkknmsgkbn7) {
        syukyktkykhknkknmsgkbn7 = pSyukyktkykhknkknmsgkbn7;
    }

    private C_Tuukasyu syukyktkykstuukatype7;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKSTUUKATYPE7)
    public C_Tuukasyu getSyukyktkykstuukatype7() {
        return syukyktkykstuukatype7;
    }

    public void setSyukyktkykstuukatype7(C_Tuukasyu pSyukyktkykstuukatype7) {
        syukyktkykstuukatype7 = pSyukyktkykstuukatype7;
    }

    private BizCurrency syukyktkykhknkngk7;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSyukyktkykhknkngk7() {
        return syukyktkykhknkngk7;
    }

    public void setSyukyktkykhknkngk7(BizCurrency pSyukyktkykhknkngk7) {
        syukyktkykhknkngk7 = pSyukyktkykhknkngk7;
        syukyktkykhknkngk7Value = null;
        syukyktkykhknkngk7Type  = null;
    }

    transient private BigDecimal syukyktkykhknkngk7Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=SYUKYKTKYKHKNKNGK7, nullable=true)
    protected BigDecimal getSyukyktkykhknkngk7Value() {
        if (syukyktkykhknkngk7Value == null && syukyktkykhknkngk7 != null) {
            if (syukyktkykhknkngk7.isOptional()) return null;
            return syukyktkykhknkngk7.absolute();
        }
        return syukyktkykhknkngk7Value;
    }

    protected void setSyukyktkykhknkngk7Value(BigDecimal value) {
        syukyktkykhknkngk7Value = value;
        syukyktkykhknkngk7 = Optional.fromNullable(toCurrencyType(syukyktkykhknkngk7Type))
            .transform(bizCurrencyTransformer(getSyukyktkykhknkngk7Value()))
            .orNull();
    }

    transient private String syukyktkykhknkngk7Type = null;

    @Column(name=SYUKYKTKYKHKNKNGK7 + "$", nullable=true)
    protected String getSyukyktkykhknkngk7Type() {
        if (syukyktkykhknkngk7Type == null && syukyktkykhknkngk7 != null) return syukyktkykhknkngk7.getType().toString();
        if (syukyktkykhknkngk7Type == null && getSyukyktkykhknkngk7Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'syukyktkykhknkngk7$' should not be NULL."));
        }
        return syukyktkykhknkngk7Type;
    }

    protected void setSyukyktkykhknkngk7Type(String type) {
        syukyktkykhknkngk7Type = type;
        syukyktkykhknkngk7 = Optional.fromNullable(toCurrencyType(syukyktkykhknkngk7Type))
            .transform(bizCurrencyTransformer(getSyukyktkykhknkngk7Value()))
            .orNull();
    }

    private Integer syukyktkykdai1hknkkn7;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKDAI1HKNKKN7)
    public Integer getSyukyktkykdai1hknkkn7() {
        return syukyktkykdai1hknkkn7;
    }

    public void setSyukyktkykdai1hknkkn7(Integer pSyukyktkykdai1hknkkn7) {
        syukyktkykdai1hknkkn7 = pSyukyktkykdai1hknkkn7;
    }

    private Integer syukyktkykdai2hknkkn7;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKDAI2HKNKKN7)
    public Integer getSyukyktkykdai2hknkkn7() {
        return syukyktkykdai2hknkkn7;
    }

    public void setSyukyktkykdai2hknkkn7(Integer pSyukyktkykdai2hknkkn7) {
        syukyktkykdai2hknkkn7 = pSyukyktkykdai2hknkkn7;
    }

    private BizDate syutkdai1hknkknymdto7;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.SYUTKDAI1HKNKKNYMDTO7)
    public BizDate getSyutkdai1hknkknymdto7() {
        return syutkdai1hknkknymdto7;
    }

    public void setSyutkdai1hknkknymdto7(BizDate pSyutkdai1hknkknymdto7) {
        syutkdai1hknkknymdto7 = pSyutkdai1hknkknymdto7;
    }

    private BizDate syutkdai2hknkknymdto7;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.SYUTKDAI2HKNKKNYMDTO7)
    public BizDate getSyutkdai2hknkknymdto7() {
        return syutkdai2hknkknymdto7;
    }

    public void setSyutkdai2hknkknymdto7(BizDate pSyutkdai2hknkknymdto7) {
        syutkdai2hknkknymdto7 = pSyutkdai2hknkknymdto7;
    }

    private Integer syukyktkykrenban8;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKRENBAN8)
    public Integer getSyukyktkykrenban8() {
        return syukyktkykrenban8;
    }

    public void setSyukyktkykrenban8(Integer pSyukyktkykrenban8) {
        syukyktkykrenban8 = pSyukyktkykrenban8;
    }

    private String syukyktkykmsgkbn8;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKMSGKBN8)
    public String getSyukyktkykmsgkbn8() {
        return syukyktkykmsgkbn8;
    }

    public void setSyukyktkykmsgkbn8(String pSyukyktkykmsgkbn8) {
        syukyktkykmsgkbn8 = pSyukyktkykmsgkbn8;
    }

    private String syukyktkyksmsgkbn8;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKSMSGKBN8)
    public String getSyukyktkyksmsgkbn8() {
        return syukyktkyksmsgkbn8;
    }

    public void setSyukyktkyksmsgkbn8(String pSyukyktkyksmsgkbn8) {
        syukyktkyksmsgkbn8 = pSyukyktkyksmsgkbn8;
    }

    private String syukyktkykhknkknmsgkbn8;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKHKNKKNMSGKBN8)
    public String getSyukyktkykhknkknmsgkbn8() {
        return syukyktkykhknkknmsgkbn8;
    }

    public void setSyukyktkykhknkknmsgkbn8(String pSyukyktkykhknkknmsgkbn8) {
        syukyktkykhknkknmsgkbn8 = pSyukyktkykhknkknmsgkbn8;
    }

    private C_Tuukasyu syukyktkykstuukatype8;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKSTUUKATYPE8)
    public C_Tuukasyu getSyukyktkykstuukatype8() {
        return syukyktkykstuukatype8;
    }

    public void setSyukyktkykstuukatype8(C_Tuukasyu pSyukyktkykstuukatype8) {
        syukyktkykstuukatype8 = pSyukyktkykstuukatype8;
    }

    private BizCurrency syukyktkykhknkngk8;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSyukyktkykhknkngk8() {
        return syukyktkykhknkngk8;
    }

    public void setSyukyktkykhknkngk8(BizCurrency pSyukyktkykhknkngk8) {
        syukyktkykhknkngk8 = pSyukyktkykhknkngk8;
        syukyktkykhknkngk8Value = null;
        syukyktkykhknkngk8Type  = null;
    }

    transient private BigDecimal syukyktkykhknkngk8Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=SYUKYKTKYKHKNKNGK8, nullable=true)
    protected BigDecimal getSyukyktkykhknkngk8Value() {
        if (syukyktkykhknkngk8Value == null && syukyktkykhknkngk8 != null) {
            if (syukyktkykhknkngk8.isOptional()) return null;
            return syukyktkykhknkngk8.absolute();
        }
        return syukyktkykhknkngk8Value;
    }

    protected void setSyukyktkykhknkngk8Value(BigDecimal value) {
        syukyktkykhknkngk8Value = value;
        syukyktkykhknkngk8 = Optional.fromNullable(toCurrencyType(syukyktkykhknkngk8Type))
            .transform(bizCurrencyTransformer(getSyukyktkykhknkngk8Value()))
            .orNull();
    }

    transient private String syukyktkykhknkngk8Type = null;

    @Column(name=SYUKYKTKYKHKNKNGK8 + "$", nullable=true)
    protected String getSyukyktkykhknkngk8Type() {
        if (syukyktkykhknkngk8Type == null && syukyktkykhknkngk8 != null) return syukyktkykhknkngk8.getType().toString();
        if (syukyktkykhknkngk8Type == null && getSyukyktkykhknkngk8Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'syukyktkykhknkngk8$' should not be NULL."));
        }
        return syukyktkykhknkngk8Type;
    }

    protected void setSyukyktkykhknkngk8Type(String type) {
        syukyktkykhknkngk8Type = type;
        syukyktkykhknkngk8 = Optional.fromNullable(toCurrencyType(syukyktkykhknkngk8Type))
            .transform(bizCurrencyTransformer(getSyukyktkykhknkngk8Value()))
            .orNull();
    }

    private Integer syukyktkykdai1hknkkn8;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKDAI1HKNKKN8)
    public Integer getSyukyktkykdai1hknkkn8() {
        return syukyktkykdai1hknkkn8;
    }

    public void setSyukyktkykdai1hknkkn8(Integer pSyukyktkykdai1hknkkn8) {
        syukyktkykdai1hknkkn8 = pSyukyktkykdai1hknkkn8;
    }

    private Integer syukyktkykdai2hknkkn8;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKDAI2HKNKKN8)
    public Integer getSyukyktkykdai2hknkkn8() {
        return syukyktkykdai2hknkkn8;
    }

    public void setSyukyktkykdai2hknkkn8(Integer pSyukyktkykdai2hknkkn8) {
        syukyktkykdai2hknkkn8 = pSyukyktkykdai2hknkkn8;
    }

    private BizDate syutkdai1hknkknymdto8;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.SYUTKDAI1HKNKKNYMDTO8)
    public BizDate getSyutkdai1hknkknymdto8() {
        return syutkdai1hknkknymdto8;
    }

    public void setSyutkdai1hknkknymdto8(BizDate pSyutkdai1hknkknymdto8) {
        syutkdai1hknkknymdto8 = pSyutkdai1hknkknymdto8;
    }

    private BizDate syutkdai2hknkknymdto8;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.SYUTKDAI2HKNKKNYMDTO8)
    public BizDate getSyutkdai2hknkknymdto8() {
        return syutkdai2hknkknymdto8;
    }

    public void setSyutkdai2hknkknymdto8(BizDate pSyutkdai2hknkknymdto8) {
        syutkdai2hknkknymdto8 = pSyutkdai2hknkknymdto8;
    }

    private Integer syukyktkykrenban9;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKRENBAN9)
    public Integer getSyukyktkykrenban9() {
        return syukyktkykrenban9;
    }

    public void setSyukyktkykrenban9(Integer pSyukyktkykrenban9) {
        syukyktkykrenban9 = pSyukyktkykrenban9;
    }

    private String syukyktkykmsgkbn9;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKMSGKBN9)
    public String getSyukyktkykmsgkbn9() {
        return syukyktkykmsgkbn9;
    }

    public void setSyukyktkykmsgkbn9(String pSyukyktkykmsgkbn9) {
        syukyktkykmsgkbn9 = pSyukyktkykmsgkbn9;
    }

    private String syukyktkyksmsgkbn9;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKSMSGKBN9)
    public String getSyukyktkyksmsgkbn9() {
        return syukyktkyksmsgkbn9;
    }

    public void setSyukyktkyksmsgkbn9(String pSyukyktkyksmsgkbn9) {
        syukyktkyksmsgkbn9 = pSyukyktkyksmsgkbn9;
    }

    private String syukyktkykhknkknmsgkbn9;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKHKNKKNMSGKBN9)
    public String getSyukyktkykhknkknmsgkbn9() {
        return syukyktkykhknkknmsgkbn9;
    }

    public void setSyukyktkykhknkknmsgkbn9(String pSyukyktkykhknkknmsgkbn9) {
        syukyktkykhknkknmsgkbn9 = pSyukyktkykhknkknmsgkbn9;
    }

    private C_Tuukasyu syukyktkykstuukatype9;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKSTUUKATYPE9)
    public C_Tuukasyu getSyukyktkykstuukatype9() {
        return syukyktkykstuukatype9;
    }

    public void setSyukyktkykstuukatype9(C_Tuukasyu pSyukyktkykstuukatype9) {
        syukyktkykstuukatype9 = pSyukyktkykstuukatype9;
    }

    private BizCurrency syukyktkykhknkngk9;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSyukyktkykhknkngk9() {
        return syukyktkykhknkngk9;
    }

    public void setSyukyktkykhknkngk9(BizCurrency pSyukyktkykhknkngk9) {
        syukyktkykhknkngk9 = pSyukyktkykhknkngk9;
        syukyktkykhknkngk9Value = null;
        syukyktkykhknkngk9Type  = null;
    }

    transient private BigDecimal syukyktkykhknkngk9Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=SYUKYKTKYKHKNKNGK9, nullable=true)
    protected BigDecimal getSyukyktkykhknkngk9Value() {
        if (syukyktkykhknkngk9Value == null && syukyktkykhknkngk9 != null) {
            if (syukyktkykhknkngk9.isOptional()) return null;
            return syukyktkykhknkngk9.absolute();
        }
        return syukyktkykhknkngk9Value;
    }

    protected void setSyukyktkykhknkngk9Value(BigDecimal value) {
        syukyktkykhknkngk9Value = value;
        syukyktkykhknkngk9 = Optional.fromNullable(toCurrencyType(syukyktkykhknkngk9Type))
            .transform(bizCurrencyTransformer(getSyukyktkykhknkngk9Value()))
            .orNull();
    }

    transient private String syukyktkykhknkngk9Type = null;

    @Column(name=SYUKYKTKYKHKNKNGK9 + "$", nullable=true)
    protected String getSyukyktkykhknkngk9Type() {
        if (syukyktkykhknkngk9Type == null && syukyktkykhknkngk9 != null) return syukyktkykhknkngk9.getType().toString();
        if (syukyktkykhknkngk9Type == null && getSyukyktkykhknkngk9Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'syukyktkykhknkngk9$' should not be NULL."));
        }
        return syukyktkykhknkngk9Type;
    }

    protected void setSyukyktkykhknkngk9Type(String type) {
        syukyktkykhknkngk9Type = type;
        syukyktkykhknkngk9 = Optional.fromNullable(toCurrencyType(syukyktkykhknkngk9Type))
            .transform(bizCurrencyTransformer(getSyukyktkykhknkngk9Value()))
            .orNull();
    }

    private Integer syukyktkykdai1hknkkn9;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKDAI1HKNKKN9)
    public Integer getSyukyktkykdai1hknkkn9() {
        return syukyktkykdai1hknkkn9;
    }

    public void setSyukyktkykdai1hknkkn9(Integer pSyukyktkykdai1hknkkn9) {
        syukyktkykdai1hknkkn9 = pSyukyktkykdai1hknkkn9;
    }

    private Integer syukyktkykdai2hknkkn9;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKDAI2HKNKKN9)
    public Integer getSyukyktkykdai2hknkkn9() {
        return syukyktkykdai2hknkkn9;
    }

    public void setSyukyktkykdai2hknkkn9(Integer pSyukyktkykdai2hknkkn9) {
        syukyktkykdai2hknkkn9 = pSyukyktkykdai2hknkkn9;
    }

    private BizDate syutkdai1hknkknymdto9;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.SYUTKDAI1HKNKKNYMDTO9)
    public BizDate getSyutkdai1hknkknymdto9() {
        return syutkdai1hknkknymdto9;
    }

    public void setSyutkdai1hknkknymdto9(BizDate pSyutkdai1hknkknymdto9) {
        syutkdai1hknkknymdto9 = pSyutkdai1hknkknymdto9;
    }

    private BizDate syutkdai2hknkknymdto9;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.SYUTKDAI2HKNKKNYMDTO9)
    public BizDate getSyutkdai2hknkknymdto9() {
        return syutkdai2hknkknymdto9;
    }

    public void setSyutkdai2hknkknymdto9(BizDate pSyutkdai2hknkknymdto9) {
        syutkdai2hknkknymdto9 = pSyutkdai2hknkknymdto9;
    }

    private Integer syukyktkykrenban10;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKRENBAN10)
    public Integer getSyukyktkykrenban10() {
        return syukyktkykrenban10;
    }

    public void setSyukyktkykrenban10(Integer pSyukyktkykrenban10) {
        syukyktkykrenban10 = pSyukyktkykrenban10;
    }

    private String syukyktkykmsgkbn10;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKMSGKBN10)
    public String getSyukyktkykmsgkbn10() {
        return syukyktkykmsgkbn10;
    }

    public void setSyukyktkykmsgkbn10(String pSyukyktkykmsgkbn10) {
        syukyktkykmsgkbn10 = pSyukyktkykmsgkbn10;
    }

    private String syukyktkyksmsgkbn10;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKSMSGKBN10)
    public String getSyukyktkyksmsgkbn10() {
        return syukyktkyksmsgkbn10;
    }

    public void setSyukyktkyksmsgkbn10(String pSyukyktkyksmsgkbn10) {
        syukyktkyksmsgkbn10 = pSyukyktkyksmsgkbn10;
    }

    private String syukyktkykhknkknmsgkbn10;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKHKNKKNMSGKBN10)
    public String getSyukyktkykhknkknmsgkbn10() {
        return syukyktkykhknkknmsgkbn10;
    }

    public void setSyukyktkykhknkknmsgkbn10(String pSyukyktkykhknkknmsgkbn10) {
        syukyktkykhknkknmsgkbn10 = pSyukyktkykhknkknmsgkbn10;
    }

    private C_Tuukasyu syukyktkykstuukatype10;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKSTUUKATYPE10)
    public C_Tuukasyu getSyukyktkykstuukatype10() {
        return syukyktkykstuukatype10;
    }

    public void setSyukyktkykstuukatype10(C_Tuukasyu pSyukyktkykstuukatype10) {
        syukyktkykstuukatype10 = pSyukyktkykstuukatype10;
    }

    private BizCurrency syukyktkykhknkngk10;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSyukyktkykhknkngk10() {
        return syukyktkykhknkngk10;
    }

    public void setSyukyktkykhknkngk10(BizCurrency pSyukyktkykhknkngk10) {
        syukyktkykhknkngk10 = pSyukyktkykhknkngk10;
        syukyktkykhknkngk10Value = null;
        syukyktkykhknkngk10Type  = null;
    }

    transient private BigDecimal syukyktkykhknkngk10Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=SYUKYKTKYKHKNKNGK10, nullable=true)
    protected BigDecimal getSyukyktkykhknkngk10Value() {
        if (syukyktkykhknkngk10Value == null && syukyktkykhknkngk10 != null) {
            if (syukyktkykhknkngk10.isOptional()) return null;
            return syukyktkykhknkngk10.absolute();
        }
        return syukyktkykhknkngk10Value;
    }

    protected void setSyukyktkykhknkngk10Value(BigDecimal value) {
        syukyktkykhknkngk10Value = value;
        syukyktkykhknkngk10 = Optional.fromNullable(toCurrencyType(syukyktkykhknkngk10Type))
            .transform(bizCurrencyTransformer(getSyukyktkykhknkngk10Value()))
            .orNull();
    }

    transient private String syukyktkykhknkngk10Type = null;

    @Column(name=SYUKYKTKYKHKNKNGK10 + "$", nullable=true)
    protected String getSyukyktkykhknkngk10Type() {
        if (syukyktkykhknkngk10Type == null && syukyktkykhknkngk10 != null) return syukyktkykhknkngk10.getType().toString();
        if (syukyktkykhknkngk10Type == null && getSyukyktkykhknkngk10Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'syukyktkykhknkngk10$' should not be NULL."));
        }
        return syukyktkykhknkngk10Type;
    }

    protected void setSyukyktkykhknkngk10Type(String type) {
        syukyktkykhknkngk10Type = type;
        syukyktkykhknkngk10 = Optional.fromNullable(toCurrencyType(syukyktkykhknkngk10Type))
            .transform(bizCurrencyTransformer(getSyukyktkykhknkngk10Value()))
            .orNull();
    }

    private Integer syukyktkykdai1hknkkn10;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKDAI1HKNKKN10)
    public Integer getSyukyktkykdai1hknkkn10() {
        return syukyktkykdai1hknkkn10;
    }

    public void setSyukyktkykdai1hknkkn10(Integer pSyukyktkykdai1hknkkn10) {
        syukyktkykdai1hknkkn10 = pSyukyktkykdai1hknkkn10;
    }

    private Integer syukyktkykdai2hknkkn10;

    @Column(name=GenIT_BAK_HokenSyouken.SYUKYKTKYKDAI2HKNKKN10)
    public Integer getSyukyktkykdai2hknkkn10() {
        return syukyktkykdai2hknkkn10;
    }

    public void setSyukyktkykdai2hknkkn10(Integer pSyukyktkykdai2hknkkn10) {
        syukyktkykdai2hknkkn10 = pSyukyktkykdai2hknkkn10;
    }

    private BizDate syutkdai1hknkknymdto10;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.SYUTKDAI1HKNKKNYMDTO10)
    public BizDate getSyutkdai1hknkknymdto10() {
        return syutkdai1hknkknymdto10;
    }

    public void setSyutkdai1hknkknymdto10(BizDate pSyutkdai1hknkknymdto10) {
        syutkdai1hknkknymdto10 = pSyutkdai1hknkknymdto10;
    }

    private BizDate syutkdai2hknkknymdto10;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.SYUTKDAI2HKNKKNYMDTO10)
    public BizDate getSyutkdai2hknkknymdto10() {
        return syutkdai2hknkknymdto10;
    }

    public void setSyutkdai2hknkknymdto10(BizDate pSyutkdai2hknkknymdto10) {
        syutkdai2hknkknymdto10 = pSyutkdai2hknkknymdto10;
    }

    private String kykniyustmsgcd1;

    @Column(name=GenIT_BAK_HokenSyouken.KYKNIYUSTMSGCD1)
    public String getKykniyustmsgcd1() {
        return kykniyustmsgcd1;
    }

    public void setKykniyustmsgcd1(String pKykniyustmsgcd1) {
        kykniyustmsgcd1 = pKykniyustmsgcd1;
    }

    private String kykniyustmsgcd2;

    @Column(name=GenIT_BAK_HokenSyouken.KYKNIYUSTMSGCD2)
    public String getKykniyustmsgcd2() {
        return kykniyustmsgcd2;
    }

    public void setKykniyustmsgcd2(String pKykniyustmsgcd2) {
        kykniyustmsgcd2 = pKykniyustmsgcd2;
    }

    private String kykniyustmsgcd3;

    @Column(name=GenIT_BAK_HokenSyouken.KYKNIYUSTMSGCD3)
    public String getKykniyustmsgcd3() {
        return kykniyustmsgcd3;
    }

    public void setKykniyustmsgcd3(String pKykniyustmsgcd3) {
        kykniyustmsgcd3 = pKykniyustmsgcd3;
    }

    private String kykniyustmsgcd4;

    @Column(name=GenIT_BAK_HokenSyouken.KYKNIYUSTMSGCD4)
    public String getKykniyustmsgcd4() {
        return kykniyustmsgcd4;
    }

    public void setKykniyustmsgcd4(String pKykniyustmsgcd4) {
        kykniyustmsgcd4 = pKykniyustmsgcd4;
    }

    private String kykniyustmsgcd5;

    @Column(name=GenIT_BAK_HokenSyouken.KYKNIYUSTMSGCD5)
    public String getKykniyustmsgcd5() {
        return kykniyustmsgcd5;
    }

    public void setKykniyustmsgcd5(String pKykniyustmsgcd5) {
        kykniyustmsgcd5 = pKykniyustmsgcd5;
    }

    private String kykniyustmsgcd6;

    @Column(name=GenIT_BAK_HokenSyouken.KYKNIYUSTMSGCD6)
    public String getKykniyustmsgcd6() {
        return kykniyustmsgcd6;
    }

    public void setKykniyustmsgcd6(String pKykniyustmsgcd6) {
        kykniyustmsgcd6 = pKykniyustmsgcd6;
    }

    private String kykniyustmsgcd7;

    @Column(name=GenIT_BAK_HokenSyouken.KYKNIYUSTMSGCD7)
    public String getKykniyustmsgcd7() {
        return kykniyustmsgcd7;
    }

    public void setKykniyustmsgcd7(String pKykniyustmsgcd7) {
        kykniyustmsgcd7 = pKykniyustmsgcd7;
    }

    private String kykniyustmsgcd8;

    @Column(name=GenIT_BAK_HokenSyouken.KYKNIYUSTMSGCD8)
    public String getKykniyustmsgcd8() {
        return kykniyustmsgcd8;
    }

    public void setKykniyustmsgcd8(String pKykniyustmsgcd8) {
        kykniyustmsgcd8 = pKykniyustmsgcd8;
    }

    private String kykniyustmsgcd9;

    @Column(name=GenIT_BAK_HokenSyouken.KYKNIYUSTMSGCD9)
    public String getKykniyustmsgcd9() {
        return kykniyustmsgcd9;
    }

    public void setKykniyustmsgcd9(String pKykniyustmsgcd9) {
        kykniyustmsgcd9 = pKykniyustmsgcd9;
    }

    private String kykniyustmsgcd10;

    @Column(name=GenIT_BAK_HokenSyouken.KYKNIYUSTMSGCD10)
    public String getKykniyustmsgcd10() {
        return kykniyustmsgcd10;
    }

    public void setKykniyustmsgcd10(String pKykniyustmsgcd10) {
        kykniyustmsgcd10 = pKykniyustmsgcd10;
    }

    private String kykniyustmsgcd11;

    @Column(name=GenIT_BAK_HokenSyouken.KYKNIYUSTMSGCD11)
    public String getKykniyustmsgcd11() {
        return kykniyustmsgcd11;
    }

    public void setKykniyustmsgcd11(String pKykniyustmsgcd11) {
        kykniyustmsgcd11 = pKykniyustmsgcd11;
    }

    private String kykniyustmsgcd12;

    @Column(name=GenIT_BAK_HokenSyouken.KYKNIYUSTMSGCD12)
    public String getKykniyustmsgcd12() {
        return kykniyustmsgcd12;
    }

    public void setKykniyustmsgcd12(String pKykniyustmsgcd12) {
        kykniyustmsgcd12 = pKykniyustmsgcd12;
    }

    private String kykniyustmsgcd13;

    @Column(name=GenIT_BAK_HokenSyouken.KYKNIYUSTMSGCD13)
    public String getKykniyustmsgcd13() {
        return kykniyustmsgcd13;
    }

    public void setKykniyustmsgcd13(String pKykniyustmsgcd13) {
        kykniyustmsgcd13 = pKykniyustmsgcd13;
    }

    private String kykniyustmsgcd14;

    @Column(name=GenIT_BAK_HokenSyouken.KYKNIYUSTMSGCD14)
    public String getKykniyustmsgcd14() {
        return kykniyustmsgcd14;
    }

    public void setKykniyustmsgcd14(String pKykniyustmsgcd14) {
        kykniyustmsgcd14 = pKykniyustmsgcd14;
    }

    private String kykniyustmsgcd15;

    @Column(name=GenIT_BAK_HokenSyouken.KYKNIYUSTMSGCD15)
    public String getKykniyustmsgcd15() {
        return kykniyustmsgcd15;
    }

    public void setKykniyustmsgcd15(String pKykniyustmsgcd15) {
        kykniyustmsgcd15 = pKykniyustmsgcd15;
    }

    private C_Tuukasyu kykniyustitjbrptuuktype;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.KYKNIYUSTITJBRPTUUKTYPE)
    public C_Tuukasyu getKykniyustitjbrptuuktype() {
        return kykniyustitjbrptuuktype;
    }

    public void setKykniyustitjbrptuuktype(C_Tuukasyu pKykniyustitjbrptuuktype) {
        kykniyustitjbrptuuktype = pKykniyustitjbrptuuktype;
    }

    private BizCurrency kykniyustitjbrp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKykniyustitjbrp() {
        return kykniyustitjbrp;
    }

    public void setKykniyustitjbrp(BizCurrency pKykniyustitjbrp) {
        kykniyustitjbrp = pKykniyustitjbrp;
        kykniyustitjbrpValue = null;
        kykniyustitjbrpType  = null;
    }

    transient private BigDecimal kykniyustitjbrpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KYKNIYUSTITJBRP, nullable=true)
    protected BigDecimal getKykniyustitjbrpValue() {
        if (kykniyustitjbrpValue == null && kykniyustitjbrp != null) {
            if (kykniyustitjbrp.isOptional()) return null;
            return kykniyustitjbrp.absolute();
        }
        return kykniyustitjbrpValue;
    }

    protected void setKykniyustitjbrpValue(BigDecimal value) {
        kykniyustitjbrpValue = value;
        kykniyustitjbrp = Optional.fromNullable(toCurrencyType(kykniyustitjbrpType))
            .transform(bizCurrencyTransformer(getKykniyustitjbrpValue()))
            .orNull();
    }

    transient private String kykniyustitjbrpType = null;

    @Column(name=KYKNIYUSTITJBRP + "$", nullable=true)
    protected String getKykniyustitjbrpType() {
        if (kykniyustitjbrpType == null && kykniyustitjbrp != null) return kykniyustitjbrp.getType().toString();
        if (kykniyustitjbrpType == null && getKykniyustitjbrpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kykniyustitjbrp$' should not be NULL."));
        }
        return kykniyustitjbrpType;
    }

    protected void setKykniyustitjbrpType(String type) {
        kykniyustitjbrpType = type;
        kykniyustitjbrp = Optional.fromNullable(toCurrencyType(kykniyustitjbrpType))
            .transform(bizCurrencyTransformer(getKykniyustitjbrpValue()))
            .orNull();
    }

    private String stnaiyouranmsgcd1;

    @Column(name=GenIT_BAK_HokenSyouken.STNAIYOURANMSGCD1)
    public String getStnaiyouranmsgcd1() {
        return stnaiyouranmsgcd1;
    }

    public void setStnaiyouranmsgcd1(String pStnaiyouranmsgcd1) {
        stnaiyouranmsgcd1 = pStnaiyouranmsgcd1;
    }

    private String stnaiyouranmsgcd2;

    @Column(name=GenIT_BAK_HokenSyouken.STNAIYOURANMSGCD2)
    public String getStnaiyouranmsgcd2() {
        return stnaiyouranmsgcd2;
    }

    public void setStnaiyouranmsgcd2(String pStnaiyouranmsgcd2) {
        stnaiyouranmsgcd2 = pStnaiyouranmsgcd2;
    }

    private String stnaiyouranmsgcd3;

    @Column(name=GenIT_BAK_HokenSyouken.STNAIYOURANMSGCD3)
    public String getStnaiyouranmsgcd3() {
        return stnaiyouranmsgcd3;
    }

    public void setStnaiyouranmsgcd3(String pStnaiyouranmsgcd3) {
        stnaiyouranmsgcd3 = pStnaiyouranmsgcd3;
    }

    private String stnaiyouranmsgcd4;

    @Column(name=GenIT_BAK_HokenSyouken.STNAIYOURANMSGCD4)
    public String getStnaiyouranmsgcd4() {
        return stnaiyouranmsgcd4;
    }

    public void setStnaiyouranmsgcd4(String pStnaiyouranmsgcd4) {
        stnaiyouranmsgcd4 = pStnaiyouranmsgcd4;
    }

    private String stnaiyouranmsgcd5;

    @Column(name=GenIT_BAK_HokenSyouken.STNAIYOURANMSGCD5)
    public String getStnaiyouranmsgcd5() {
        return stnaiyouranmsgcd5;
    }

    public void setStnaiyouranmsgcd5(String pStnaiyouranmsgcd5) {
        stnaiyouranmsgcd5 = pStnaiyouranmsgcd5;
    }

    private String stnaiyouranmsgcd6;

    @Column(name=GenIT_BAK_HokenSyouken.STNAIYOURANMSGCD6)
    public String getStnaiyouranmsgcd6() {
        return stnaiyouranmsgcd6;
    }

    public void setStnaiyouranmsgcd6(String pStnaiyouranmsgcd6) {
        stnaiyouranmsgcd6 = pStnaiyouranmsgcd6;
    }

    private String stnaiyouranmsgcd7;

    @Column(name=GenIT_BAK_HokenSyouken.STNAIYOURANMSGCD7)
    public String getStnaiyouranmsgcd7() {
        return stnaiyouranmsgcd7;
    }

    public void setStnaiyouranmsgcd7(String pStnaiyouranmsgcd7) {
        stnaiyouranmsgcd7 = pStnaiyouranmsgcd7;
    }

    private String stnaiyouranmsgcd8;

    @Column(name=GenIT_BAK_HokenSyouken.STNAIYOURANMSGCD8)
    public String getStnaiyouranmsgcd8() {
        return stnaiyouranmsgcd8;
    }

    public void setStnaiyouranmsgcd8(String pStnaiyouranmsgcd8) {
        stnaiyouranmsgcd8 = pStnaiyouranmsgcd8;
    }

    private String stnaiyouranmsgcd9;

    @Column(name=GenIT_BAK_HokenSyouken.STNAIYOURANMSGCD9)
    public String getStnaiyouranmsgcd9() {
        return stnaiyouranmsgcd9;
    }

    public void setStnaiyouranmsgcd9(String pStnaiyouranmsgcd9) {
        stnaiyouranmsgcd9 = pStnaiyouranmsgcd9;
    }

    private String stnaiyouranmsgcd10;

    @Column(name=GenIT_BAK_HokenSyouken.STNAIYOURANMSGCD10)
    public String getStnaiyouranmsgcd10() {
        return stnaiyouranmsgcd10;
    }

    public void setStnaiyouranmsgcd10(String pStnaiyouranmsgcd10) {
        stnaiyouranmsgcd10 = pStnaiyouranmsgcd10;
    }

    private String stnaiyouranmsgcd11;

    @Column(name=GenIT_BAK_HokenSyouken.STNAIYOURANMSGCD11)
    public String getStnaiyouranmsgcd11() {
        return stnaiyouranmsgcd11;
    }

    public void setStnaiyouranmsgcd11(String pStnaiyouranmsgcd11) {
        stnaiyouranmsgcd11 = pStnaiyouranmsgcd11;
    }

    private String stnaiyouranmsgcd12;

    @Column(name=GenIT_BAK_HokenSyouken.STNAIYOURANMSGCD12)
    public String getStnaiyouranmsgcd12() {
        return stnaiyouranmsgcd12;
    }

    public void setStnaiyouranmsgcd12(String pStnaiyouranmsgcd12) {
        stnaiyouranmsgcd12 = pStnaiyouranmsgcd12;
    }

    private String stnaiyouranmsgcd13;

    @Column(name=GenIT_BAK_HokenSyouken.STNAIYOURANMSGCD13)
    public String getStnaiyouranmsgcd13() {
        return stnaiyouranmsgcd13;
    }

    public void setStnaiyouranmsgcd13(String pStnaiyouranmsgcd13) {
        stnaiyouranmsgcd13 = pStnaiyouranmsgcd13;
    }

    private String stnaiyouranmsgcd14;

    @Column(name=GenIT_BAK_HokenSyouken.STNAIYOURANMSGCD14)
    public String getStnaiyouranmsgcd14() {
        return stnaiyouranmsgcd14;
    }

    public void setStnaiyouranmsgcd14(String pStnaiyouranmsgcd14) {
        stnaiyouranmsgcd14 = pStnaiyouranmsgcd14;
    }

    private String stnaiyouranmsgcd15;

    @Column(name=GenIT_BAK_HokenSyouken.STNAIYOURANMSGCD15)
    public String getStnaiyouranmsgcd15() {
        return stnaiyouranmsgcd15;
    }

    public void setStnaiyouranmsgcd15(String pStnaiyouranmsgcd15) {
        stnaiyouranmsgcd15 = pStnaiyouranmsgcd15;
    }

    private String stnaiyouranmsgcd16;

    @Column(name=GenIT_BAK_HokenSyouken.STNAIYOURANMSGCD16)
    public String getStnaiyouranmsgcd16() {
        return stnaiyouranmsgcd16;
    }

    public void setStnaiyouranmsgcd16(String pStnaiyouranmsgcd16) {
        stnaiyouranmsgcd16 = pStnaiyouranmsgcd16;
    }

    private String stnaiyouranmsgcd17;

    @Column(name=GenIT_BAK_HokenSyouken.STNAIYOURANMSGCD17)
    public String getStnaiyouranmsgcd17() {
        return stnaiyouranmsgcd17;
    }

    public void setStnaiyouranmsgcd17(String pStnaiyouranmsgcd17) {
        stnaiyouranmsgcd17 = pStnaiyouranmsgcd17;
    }

    private String stnaiyouranmsgcd18;

    @Column(name=GenIT_BAK_HokenSyouken.STNAIYOURANMSGCD18)
    public String getStnaiyouranmsgcd18() {
        return stnaiyouranmsgcd18;
    }

    public void setStnaiyouranmsgcd18(String pStnaiyouranmsgcd18) {
        stnaiyouranmsgcd18 = pStnaiyouranmsgcd18;
    }

    private String stnaiyouranmsgcd19;

    @Column(name=GenIT_BAK_HokenSyouken.STNAIYOURANMSGCD19)
    public String getStnaiyouranmsgcd19() {
        return stnaiyouranmsgcd19;
    }

    public void setStnaiyouranmsgcd19(String pStnaiyouranmsgcd19) {
        stnaiyouranmsgcd19 = pStnaiyouranmsgcd19;
    }

    private String stnaiyouranmsgcd20;

    @Column(name=GenIT_BAK_HokenSyouken.STNAIYOURANMSGCD20)
    public String getStnaiyouranmsgcd20() {
        return stnaiyouranmsgcd20;
    }

    public void setStnaiyouranmsgcd20(String pStnaiyouranmsgcd20) {
        stnaiyouranmsgcd20 = pStnaiyouranmsgcd20;
    }

    private String sonotanyransiteituuka;

    @Column(name=GenIT_BAK_HokenSyouken.SONOTANYRANSITEITUUKA)
    public String getSonotanyransiteituuka() {
        return sonotanyransiteituuka;
    }

    public void setSonotanyransiteituuka(String pSonotanyransiteituuka) {
        sonotanyransiteituuka = pSonotanyransiteituuka;
    }

    private C_Tuukasyu sonotanyrannykntuktype;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.SONOTANYRANNYKNTUKTYPE)
    public C_Tuukasyu getSonotanyrannykntuktype() {
        return sonotanyrannykntuktype;
    }

    public void setSonotanyrannykntuktype(C_Tuukasyu pSonotanyrannykntuktype) {
        sonotanyrannykntuktype = pSonotanyrannykntuktype;
    }

    private BizCurrency sonotanyrannykntuukap;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSonotanyrannykntuukap() {
        return sonotanyrannykntuukap;
    }

    public void setSonotanyrannykntuukap(BizCurrency pSonotanyrannykntuukap) {
        sonotanyrannykntuukap = pSonotanyrannykntuukap;
        sonotanyrannykntuukapValue = null;
        sonotanyrannykntuukapType  = null;
    }

    transient private BigDecimal sonotanyrannykntuukapValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SONOTANYRANNYKNTUUKAP, nullable=true)
    protected BigDecimal getSonotanyrannykntuukapValue() {
        if (sonotanyrannykntuukapValue == null && sonotanyrannykntuukap != null) {
            if (sonotanyrannykntuukap.isOptional()) return null;
            return sonotanyrannykntuukap.absolute();
        }
        return sonotanyrannykntuukapValue;
    }

    protected void setSonotanyrannykntuukapValue(BigDecimal value) {
        sonotanyrannykntuukapValue = value;
        sonotanyrannykntuukap = Optional.fromNullable(toCurrencyType(sonotanyrannykntuukapType))
            .transform(bizCurrencyTransformer(getSonotanyrannykntuukapValue()))
            .orNull();
    }

    transient private String sonotanyrannykntuukapType = null;

    @Column(name=SONOTANYRANNYKNTUUKAP + "$", nullable=true)
    protected String getSonotanyrannykntuukapType() {
        if (sonotanyrannykntuukapType == null && sonotanyrannykntuukap != null) return sonotanyrannykntuukap.getType().toString();
        if (sonotanyrannykntuukapType == null && getSonotanyrannykntuukapValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sonotanyrannykntuukap$' should not be NULL."));
        }
        return sonotanyrannykntuukapType;
    }

    protected void setSonotanyrannykntuukapType(String type) {
        sonotanyrannykntuukapType = type;
        sonotanyrannykntuukap = Optional.fromNullable(toCurrencyType(sonotanyrannykntuukapType))
            .transform(bizCurrencyTransformer(getSonotanyrannykntuukapValue()))
            .orNull();
    }

    private String sonotanyrannykntuukasyu;

    @Column(name=GenIT_BAK_HokenSyouken.SONOTANYRANNYKNTUUKASYU)
    public String getSonotanyrannykntuukasyu() {
        return sonotanyrannykntuukasyu;
    }

    public void setSonotanyrannykntuukasyu(String pSonotanyrannykntuukasyu) {
        sonotanyrannykntuukasyu = pSonotanyrannykntuukasyu;
    }

    private BizNumber sonotanyranenkhrikmrate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.SONOTANYRANENKHRIKMRATE)
    public BizNumber getSonotanyranenkhrikmrate() {
        return sonotanyranenkhrikmrate;
    }

    public void setSonotanyranenkhrikmrate(BizNumber pSonotanyranenkhrikmrate) {
        sonotanyranenkhrikmrate = pSonotanyranenkhrikmrate;
    }

    private BizNumber sonotanyranstigikwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.SONOTANYRANSTIGIKWSRATE)
    public BizNumber getSonotanyranstigikwsrate() {
        return sonotanyranstigikwsrate;
    }

    public void setSonotanyranstigikwsrate(BizNumber pSonotanyranstigikwsrate) {
        sonotanyranstigikwsrate = pSonotanyranstigikwsrate;
    }

    private C_Tuukasyu sonotanyrankjnkngktuktype;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.SONOTANYRANKJNKNGKTUKTYPE)
    public C_Tuukasyu getSonotanyrankjnkngktuktype() {
        return sonotanyrankjnkngktuktype;
    }

    public void setSonotanyrankjnkngktuktype(C_Tuukasyu pSonotanyrankjnkngktuktype) {
        sonotanyrankjnkngktuktype = pSonotanyrankjnkngktuktype;
    }

    private BizCurrency sonotanyrankjnkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSonotanyrankjnkngk() {
        return sonotanyrankjnkngk;
    }

    public void setSonotanyrankjnkngk(BizCurrency pSonotanyrankjnkngk) {
        sonotanyrankjnkngk = pSonotanyrankjnkngk;
        sonotanyrankjnkngkValue = null;
        sonotanyrankjnkngkType  = null;
    }

    transient private BigDecimal sonotanyrankjnkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SONOTANYRANKJNKNGK, nullable=true)
    protected BigDecimal getSonotanyrankjnkngkValue() {
        if (sonotanyrankjnkngkValue == null && sonotanyrankjnkngk != null) {
            if (sonotanyrankjnkngk.isOptional()) return null;
            return sonotanyrankjnkngk.absolute();
        }
        return sonotanyrankjnkngkValue;
    }

    protected void setSonotanyrankjnkngkValue(BigDecimal value) {
        sonotanyrankjnkngkValue = value;
        sonotanyrankjnkngk = Optional.fromNullable(toCurrencyType(sonotanyrankjnkngkType))
            .transform(bizCurrencyTransformer(getSonotanyrankjnkngkValue()))
            .orNull();
    }

    transient private String sonotanyrankjnkngkType = null;

    @Column(name=SONOTANYRANKJNKNGK + "$", nullable=true)
    protected String getSonotanyrankjnkngkType() {
        if (sonotanyrankjnkngkType == null && sonotanyrankjnkngk != null) return sonotanyrankjnkngk.getType().toString();
        if (sonotanyrankjnkngkType == null && getSonotanyrankjnkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sonotanyrankjnkngk$' should not be NULL."));
        }
        return sonotanyrankjnkngkType;
    }

    protected void setSonotanyrankjnkngkType(String type) {
        sonotanyrankjnkngkType = type;
        sonotanyrankjnkngk = Optional.fromNullable(toCurrencyType(sonotanyrankjnkngkType))
            .transform(bizCurrencyTransformer(getSonotanyrankjnkngkValue()))
            .orNull();
    }

    private BizNumber sonotanyrankjnkngkrate;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.SONOTANYRANKJNKNGKRATE)
    public BizNumber getSonotanyrankjnkngkrate() {
        return sonotanyrankjnkngkrate;
    }

    public void setSonotanyrankjnkngkrate(BizNumber pSonotanyrankjnkngkrate) {
        sonotanyrankjnkngkrate = pSonotanyrankjnkngkrate;
    }

    private String sonotanyrankjnkngktuuka;

    @Column(name=GenIT_BAK_HokenSyouken.SONOTANYRANKJNKNGKTUUKA)
    public String getSonotanyrankjnkngktuuka() {
        return sonotanyrankjnkngktuuka;
    }

    public void setSonotanyrankjnkngktuuka(String pSonotanyrankjnkngktuuka) {
        sonotanyrankjnkngktuuka = pSonotanyrankjnkngktuuka;
    }

    private C_Tuukasyu sonotanyranpentuktype;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.SONOTANYRANPENTUKTYPE)
    public C_Tuukasyu getSonotanyranpentuktype() {
        return sonotanyranpentuktype;
    }

    public void setSonotanyranpentuktype(C_Tuukasyu pSonotanyranpentuktype) {
        sonotanyranpentuktype = pSonotanyranpentuktype;
    }

    private BizCurrency sonotanyranpenknsngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSonotanyranpenknsngk() {
        return sonotanyranpenknsngk;
    }

    public void setSonotanyranpenknsngk(BizCurrency pSonotanyranpenknsngk) {
        sonotanyranpenknsngk = pSonotanyranpenknsngk;
        sonotanyranpenknsngkValue = null;
        sonotanyranpenknsngkType  = null;
    }

    transient private BigDecimal sonotanyranpenknsngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SONOTANYRANPENKNSNGK, nullable=true)
    protected BigDecimal getSonotanyranpenknsngkValue() {
        if (sonotanyranpenknsngkValue == null && sonotanyranpenknsngk != null) {
            if (sonotanyranpenknsngk.isOptional()) return null;
            return sonotanyranpenknsngk.absolute();
        }
        return sonotanyranpenknsngkValue;
    }

    protected void setSonotanyranpenknsngkValue(BigDecimal value) {
        sonotanyranpenknsngkValue = value;
        sonotanyranpenknsngk = Optional.fromNullable(toCurrencyType(sonotanyranpenknsngkType))
            .transform(bizCurrencyTransformer(getSonotanyranpenknsngkValue()))
            .orNull();
    }

    transient private String sonotanyranpenknsngkType = null;

    @Column(name=SONOTANYRANPENKNSNGK + "$", nullable=true)
    protected String getSonotanyranpenknsngkType() {
        if (sonotanyranpenknsngkType == null && sonotanyranpenknsngk != null) return sonotanyranpenknsngk.getType().toString();
        if (sonotanyranpenknsngkType == null && getSonotanyranpenknsngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sonotanyranpenknsngk$' should not be NULL."));
        }
        return sonotanyranpenknsngkType;
    }

    protected void setSonotanyranpenknsngkType(String type) {
        sonotanyranpenknsngkType = type;
        sonotanyranpenknsngk = Optional.fromNullable(toCurrencyType(sonotanyranpenknsngkType))
            .transform(bizCurrencyTransformer(getSonotanyranpenknsngkValue()))
            .orNull();
    }

    private BizNumber sonotanyranmkhwariai;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.SONOTANYRANMKHWARIAI)
    public BizNumber getSonotanyranmkhwariai() {
        return sonotanyranmkhwariai;
    }

    public void setSonotanyranmkhwariai(BizNumber pSonotanyranmkhwariai) {
        sonotanyranmkhwariai = pSonotanyranmkhwariai;
    }

    private BizNumber sonotanyranytirrt;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.SONOTANYRANYTIRRT)
    public BizNumber getSonotanyranytirrt() {
        return sonotanyranytirrt;
    }

    public void setSonotanyranytirrt(BizNumber pSonotanyranytirrt) {
        sonotanyranytirrt = pSonotanyranytirrt;
    }

    private BizNumber sonotanyransjkkktusirrt;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.SONOTANYRANSJKKKTUSIRRT)
    public BizNumber getSonotanyransjkkktusirrt() {
        return sonotanyransjkkktusirrt;
    }

    public void setSonotanyransjkkktusirrt(BizNumber pSonotanyransjkkktusirrt) {
        sonotanyransjkkktusirrt = pSonotanyransjkkktusirrt;
    }

    private String stnaiyourangaimsgcd;

    @Column(name=GenIT_BAK_HokenSyouken.STNAIYOURANGAIMSGCD)
    public String getStnaiyourangaimsgcd() {
        return stnaiyourangaimsgcd;
    }

    public void setStnaiyourangaimsgcd(String pStnaiyourangaimsgcd) {
        stnaiyourangaimsgcd = pStnaiyourangaimsgcd;
    }

    private String tsinyno;

    @Column(name=GenIT_BAK_HokenSyouken.TSINYNO)
    @Length(length=7)
    @SingleByteStrings
    @Digit
    public String getTsinyno() {
        return tsinyno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTsinyno(String pTsinyno) {
        tsinyno = pTsinyno;
    }

    private String tsinadr1kj;

    @Column(name=GenIT_BAK_HokenSyouken.TSINADR1KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr1kj() {
        return tsinadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr1kj(String pTsinadr1kj) {
        tsinadr1kj = pTsinadr1kj;
    }

    private String tsinadr2kj;

    @Column(name=GenIT_BAK_HokenSyouken.TSINADR2KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr2kj() {
        return tsinadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr2kj(String pTsinadr2kj) {
        tsinadr2kj = pTsinadr2kj;
    }

    private String tsinadr3kj;

    @Column(name=GenIT_BAK_HokenSyouken.TSINADR3KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr3kj() {
        return tsinadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr3kj(String pTsinadr3kj) {
        tsinadr3kj = pTsinadr3kj;
    }

    private String shsnmkj;

    @Column(name=GenIT_BAK_HokenSyouken.SHSNMKJ)
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

    private String tnknmissmsg;

    @Column(name=GenIT_BAK_HokenSyouken.TNKNMISSMSG)
    public String getTnknmissmsg() {
        return tnknmissmsg;
    }

    public void setTnknmissmsg(String pTnknmissmsg) {
        tnknmissmsg = pTnknmissmsg;
    }

    private String errormsgcd;

    @Column(name=GenIT_BAK_HokenSyouken.ERRORMSGCD)
    public String getErrormsgcd() {
        return errormsgcd;
    }

    public void setErrormsgcd(String pErrormsgcd) {
        errormsgcd = pErrormsgcd;
    }

    private String sisyacd;

    @Column(name=GenIT_BAK_HokenSyouken.SISYACD)
    @Length(length=3)
    @SingleByteStrings
    public String getSisyacd() {
        return sisyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSisyacd(String pSisyacd) {
        sisyacd = pSisyacd;
    }

    private String duhutusnrntousaadrmsgcd;

    @Column(name=GenIT_BAK_HokenSyouken.DUHUTUSNRNTOUSAADRMSGCD)
    public String getDuhutusnrntousaadrmsgcd() {
        return duhutusnrntousaadrmsgcd;
    }

    public void setDuhutusnrntousaadrmsgcd(String pDuhutusnrntousaadrmsgcd) {
        duhutusnrntousaadrmsgcd = pDuhutusnrntousaadrmsgcd;
    }

    private String duhutusnrnsyono;

    @Column(name=GenIT_BAK_HokenSyouken.DUHUTUSNRNSYONO)
    public String getDuhutusnrnsyono() {
        return duhutusnrnsyono;
    }

    public void setDuhutusnrnsyono(String pDuhutusnrnsyono) {
        duhutusnrnsyono = pDuhutusnrnsyono;
    }

    private C_Channelcd channelcd;

    @Type(type="UserType_C_Channelcd")
    @Column(name=GenIT_BAK_HokenSyouken.CHANNELCD)
    public C_Channelcd getChannelcd() {
        return channelcd;
    }

    public void setChannelcd(C_Channelcd pChannelcd) {
        channelcd = pChannelcd;
    }

    private String dairitenmidasikbn;

    @Column(name=GenIT_BAK_HokenSyouken.DAIRITENMIDASIKBN)
    public String getDairitenmidasikbn() {
        return dairitenmidasikbn;
    }

    public void setDairitenmidasikbn(String pDairitenmidasikbn) {
        dairitenmidasikbn = pDairitenmidasikbn;
    }

    private String drtennm1kj;

    @Column(name=GenIT_BAK_HokenSyouken.DRTENNM1KJ)
    public String getDrtennm1kj() {
        return drtennm1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setDrtennm1kj(String pDrtennm1kj) {
        drtennm1kj = pDrtennm1kj;
    }

    private String drtennm2kj;

    @Column(name=GenIT_BAK_HokenSyouken.DRTENNM2KJ)
    public String getDrtennm2kj() {
        return drtennm2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setDrtennm2kj(String pDrtennm2kj) {
        drtennm2kj = pDrtennm2kj;
    }

    private String aisatumsgcd;

    @Column(name=GenIT_BAK_HokenSyouken.AISATUMSGCD)
    public String getAisatumsgcd() {
        return aisatumsgcd;
    }

    public void setAisatumsgcd(String pAisatumsgcd) {
        aisatumsgcd = pAisatumsgcd;
    }

    private String ccmsgcd;

    @Column(name=GenIT_BAK_HokenSyouken.CCMSGCD)
    public String getCcmsgcd() {
        return ccmsgcd;
    }

    public void setCcmsgcd(String pCcmsgcd) {
        ccmsgcd = pCcmsgcd;
    }

    private String hskmsgcd;

    @Column(name=GenIT_BAK_HokenSyouken.HSKMSGCD)
    public String getHskmsgcd() {
        return hskmsgcd;
    }

    public void setHskmsgcd(String pHskmsgcd) {
        hskmsgcd = pHskmsgcd;
    }

    private String hosyounymsgcd;

    @Column(name=GenIT_BAK_HokenSyouken.HOSYOUNYMSGCD)
    public String getHosyounymsgcd() {
        return hosyounymsgcd;
    }

    public void setHosyounymsgcd(String pHosyounymsgcd) {
        hosyounymsgcd = pHosyounymsgcd;
    }

    private String hosyounyhihknsyameikanji;

    @Column(name=GenIT_BAK_HokenSyouken.HOSYOUNYHIHKNSYAMEIKANJI)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getHosyounyhihknsyameikanji() {
        return hosyounyhihknsyameikanji;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHosyounyhihknsyameikanji(String pHosyounyhihknsyameikanji) {
        hosyounyhihknsyameikanji = pHosyounyhihknsyameikanji;
    }

    private String siboumidasimsgcd;

    @Column(name=GenIT_BAK_HokenSyouken.SIBOUMIDASIMSGCD)
    public String getSiboumidasimsgcd() {
        return siboumidasimsgcd;
    }

    public void setSiboumidasimsgcd(String pSiboumidasimsgcd) {
        siboumidasimsgcd = pSiboumidasimsgcd;
    }

    private String siboumidasimsgcd2;

    @Column(name=GenIT_BAK_HokenSyouken.SIBOUMIDASIMSGCD2)
    public String getSiboumidasimsgcd2() {
        return siboumidasimsgcd2;
    }

    public void setSiboumidasimsgcd2(String pSiboumidasimsgcd2) {
        siboumidasimsgcd2 = pSiboumidasimsgcd2;
    }

    private String siboudai1hknkknmsgcd1;

    @Column(name=GenIT_BAK_HokenSyouken.SIBOUDAI1HKNKKNMSGCD1)
    public String getSiboudai1hknkknmsgcd1() {
        return siboudai1hknkknmsgcd1;
    }

    public void setSiboudai1hknkknmsgcd1(String pSiboudai1hknkknmsgcd1) {
        siboudai1hknkknmsgcd1 = pSiboudai1hknkknmsgcd1;
    }

    private String siboudai1hknkknmsgcd2;

    @Column(name=GenIT_BAK_HokenSyouken.SIBOUDAI1HKNKKNMSGCD2)
    public String getSiboudai1hknkknmsgcd2() {
        return siboudai1hknkknmsgcd2;
    }

    public void setSiboudai1hknkknmsgcd2(String pSiboudai1hknkknmsgcd2) {
        siboudai1hknkknmsgcd2 = pSiboudai1hknkknmsgcd2;
    }

    private String siboudai1hknkknigimsgcd;

    @Column(name=GenIT_BAK_HokenSyouken.SIBOUDAI1HKNKKNIGIMSGCD)
    public String getSiboudai1hknkknigimsgcd() {
        return siboudai1hknkknigimsgcd;
    }

    public void setSiboudai1hknkknigimsgcd(String pSiboudai1hknkknigimsgcd) {
        siboudai1hknkknigimsgcd = pSiboudai1hknkknigimsgcd;
    }

    private String siboudai1hknkknigimsgcd2;

    @Column(name=GenIT_BAK_HokenSyouken.SIBOUDAI1HKNKKNIGIMSGCD2)
    public String getSiboudai1hknkknigimsgcd2() {
        return siboudai1hknkknigimsgcd2;
    }

    public void setSiboudai1hknkknigimsgcd2(String pSiboudai1hknkknigimsgcd2) {
        siboudai1hknkknigimsgcd2 = pSiboudai1hknkknigimsgcd2;
    }

    private String siboudai1hknkknhrsmsgcd;

    @Column(name=GenIT_BAK_HokenSyouken.SIBOUDAI1HKNKKNHRSMSGCD)
    public String getSiboudai1hknkknhrsmsgcd() {
        return siboudai1hknkknhrsmsgcd;
    }

    public void setSiboudai1hknkknhrsmsgcd(String pSiboudai1hknkknhrsmsgcd) {
        siboudai1hknkknhrsmsgcd = pSiboudai1hknkknhrsmsgcd;
    }

    private String siboudai1hknkknhrsmsgcd2;

    @Column(name=GenIT_BAK_HokenSyouken.SIBOUDAI1HKNKKNHRSMSGCD2)
    public String getSiboudai1hknkknhrsmsgcd2() {
        return siboudai1hknkknhrsmsgcd2;
    }

    public void setSiboudai1hknkknhrsmsgcd2(String pSiboudai1hknkknhrsmsgcd2) {
        siboudai1hknkknhrsmsgcd2 = pSiboudai1hknkknhrsmsgcd2;
    }

    private String siboudai1hknkknsmrmsgcd;

    @Column(name=GenIT_BAK_HokenSyouken.SIBOUDAI1HKNKKNSMRMSGCD)
    public String getSiboudai1hknkknsmrmsgcd() {
        return siboudai1hknkknsmrmsgcd;
    }

    public void setSiboudai1hknkknsmrmsgcd(String pSiboudai1hknkknsmrmsgcd) {
        siboudai1hknkknsmrmsgcd = pSiboudai1hknkknsmrmsgcd;
    }

    private String siboudai2hknkknmsgcd1;

    @Column(name=GenIT_BAK_HokenSyouken.SIBOUDAI2HKNKKNMSGCD1)
    public String getSiboudai2hknkknmsgcd1() {
        return siboudai2hknkknmsgcd1;
    }

    public void setSiboudai2hknkknmsgcd1(String pSiboudai2hknkknmsgcd1) {
        siboudai2hknkknmsgcd1 = pSiboudai2hknkknmsgcd1;
    }

    private String siboudai2hknkknmsgcd2;

    @Column(name=GenIT_BAK_HokenSyouken.SIBOUDAI2HKNKKNMSGCD2)
    public String getSiboudai2hknkknmsgcd2() {
        return siboudai2hknkknmsgcd2;
    }

    public void setSiboudai2hknkknmsgcd2(String pSiboudai2hknkknmsgcd2) {
        siboudai2hknkknmsgcd2 = pSiboudai2hknkknmsgcd2;
    }

    private String siboudai2hknkknsmsgcd;

    @Column(name=GenIT_BAK_HokenSyouken.SIBOUDAI2HKNKKNSMSGCD)
    public String getSiboudai2hknkknsmsgcd() {
        return siboudai2hknkknsmsgcd;
    }

    public void setSiboudai2hknkknsmsgcd(String pSiboudai2hknkknsmsgcd) {
        siboudai2hknkknsmsgcd = pSiboudai2hknkknsmsgcd;
    }

    private String siboudai2hknkknsmsgcd2;

    @Column(name=GenIT_BAK_HokenSyouken.SIBOUDAI2HKNKKNSMSGCD2)
    public String getSiboudai2hknkknsmsgcd2() {
        return siboudai2hknkknsmsgcd2;
    }

    public void setSiboudai2hknkknsmsgcd2(String pSiboudai2hknkknsmsgcd2) {
        siboudai2hknkknsmsgcd2 = pSiboudai2hknkknsmsgcd2;
    }

    private String siboudai3hknkknmsgcd1;

    @Column(name=GenIT_BAK_HokenSyouken.SIBOUDAI3HKNKKNMSGCD1)
    public String getSiboudai3hknkknmsgcd1() {
        return siboudai3hknkknmsgcd1;
    }

    public void setSiboudai3hknkknmsgcd1(String pSiboudai3hknkknmsgcd1) {
        siboudai3hknkknmsgcd1 = pSiboudai3hknkknmsgcd1;
    }

    private String siboudai3hknkknmsgcd2;

    @Column(name=GenIT_BAK_HokenSyouken.SIBOUDAI3HKNKKNMSGCD2)
    public String getSiboudai3hknkknmsgcd2() {
        return siboudai3hknkknmsgcd2;
    }

    public void setSiboudai3hknkknmsgcd2(String pSiboudai3hknkknmsgcd2) {
        siboudai3hknkknmsgcd2 = pSiboudai3hknkknmsgcd2;
    }

    private Integer siboudai1hknkkn;

    @Column(name=GenIT_BAK_HokenSyouken.SIBOUDAI1HKNKKN)
    public Integer getSiboudai1hknkkn() {
        return siboudai1hknkkn;
    }

    public void setSiboudai1hknkkn(Integer pSiboudai1hknkkn) {
        siboudai1hknkkn = pSiboudai1hknkkn;
    }

    private BizDate siboudai1hknkknymdto;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.SIBOUDAI1HKNKKNYMDTO)
    public BizDate getSiboudai1hknkknymdto() {
        return siboudai1hknkknymdto;
    }

    public void setSiboudai1hknkknymdto(BizDate pSiboudai1hknkknymdto) {
        siboudai1hknkknymdto = pSiboudai1hknkknymdto;
    }

    private C_Tuukasyu sibouitjbrpyentuuktype;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.SIBOUITJBRPYENTUUKTYPE)
    public C_Tuukasyu getSibouitjbrpyentuuktype() {
        return sibouitjbrpyentuuktype;
    }

    public void setSibouitjbrpyentuuktype(C_Tuukasyu pSibouitjbrpyentuuktype) {
        sibouitjbrpyentuuktype = pSibouitjbrpyentuuktype;
    }

    private BizCurrency sibouitjbrpyentuukgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSibouitjbrpyentuukgk() {
        return sibouitjbrpyentuukgk;
    }

    public void setSibouitjbrpyentuukgk(BizCurrency pSibouitjbrpyentuukgk) {
        sibouitjbrpyentuukgk = pSibouitjbrpyentuukgk;
        sibouitjbrpyentuukgkValue = null;
        sibouitjbrpyentuukgkType  = null;
    }

    transient private BigDecimal sibouitjbrpyentuukgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SIBOUITJBRPYENTUUKGK, nullable=true)
    protected BigDecimal getSibouitjbrpyentuukgkValue() {
        if (sibouitjbrpyentuukgkValue == null && sibouitjbrpyentuukgk != null) {
            if (sibouitjbrpyentuukgk.isOptional()) return null;
            return sibouitjbrpyentuukgk.absolute();
        }
        return sibouitjbrpyentuukgkValue;
    }

    protected void setSibouitjbrpyentuukgkValue(BigDecimal value) {
        sibouitjbrpyentuukgkValue = value;
        sibouitjbrpyentuukgk = Optional.fromNullable(toCurrencyType(sibouitjbrpyentuukgkType))
            .transform(bizCurrencyTransformer(getSibouitjbrpyentuukgkValue()))
            .orNull();
    }

    transient private String sibouitjbrpyentuukgkType = null;

    @Column(name=SIBOUITJBRPYENTUUKGK + "$", nullable=true)
    protected String getSibouitjbrpyentuukgkType() {
        if (sibouitjbrpyentuukgkType == null && sibouitjbrpyentuukgk != null) return sibouitjbrpyentuukgk.getType().toString();
        if (sibouitjbrpyentuukgkType == null && getSibouitjbrpyentuukgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sibouitjbrpyentuukgk$' should not be NULL."));
        }
        return sibouitjbrpyentuukgkType;
    }

    protected void setSibouitjbrpyentuukgkType(String type) {
        sibouitjbrpyentuukgkType = type;
        sibouitjbrpyentuukgk = Optional.fromNullable(toCurrencyType(sibouitjbrpyentuukgkType))
            .transform(bizCurrencyTransformer(getSibouitjbrpyentuukgkValue()))
            .orNull();
    }

    private C_Tuukasyu siboudai1kjnkngktuuktype;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.SIBOUDAI1KJNKNGKTUUKTYPE)
    public C_Tuukasyu getSiboudai1kjnkngktuuktype() {
        return siboudai1kjnkngktuuktype;
    }

    public void setSiboudai1kjnkngktuuktype(C_Tuukasyu pSiboudai1kjnkngktuuktype) {
        siboudai1kjnkngktuuktype = pSiboudai1kjnkngktuuktype;
    }

    private BizCurrency siboudai1kjnkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSiboudai1kjnkngk() {
        return siboudai1kjnkngk;
    }

    public void setSiboudai1kjnkngk(BizCurrency pSiboudai1kjnkngk) {
        siboudai1kjnkngk = pSiboudai1kjnkngk;
        siboudai1kjnkngkValue = null;
        siboudai1kjnkngkType  = null;
    }

    transient private BigDecimal siboudai1kjnkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SIBOUDAI1KJNKNGK, nullable=true)
    protected BigDecimal getSiboudai1kjnkngkValue() {
        if (siboudai1kjnkngkValue == null && siboudai1kjnkngk != null) {
            if (siboudai1kjnkngk.isOptional()) return null;
            return siboudai1kjnkngk.absolute();
        }
        return siboudai1kjnkngkValue;
    }

    protected void setSiboudai1kjnkngkValue(BigDecimal value) {
        siboudai1kjnkngkValue = value;
        siboudai1kjnkngk = Optional.fromNullable(toCurrencyType(siboudai1kjnkngkType))
            .transform(bizCurrencyTransformer(getSiboudai1kjnkngkValue()))
            .orNull();
    }

    transient private String siboudai1kjnkngkType = null;

    @Column(name=SIBOUDAI1KJNKNGK + "$", nullable=true)
    protected String getSiboudai1kjnkngkType() {
        if (siboudai1kjnkngkType == null && siboudai1kjnkngk != null) return siboudai1kjnkngk.getType().toString();
        if (siboudai1kjnkngkType == null && getSiboudai1kjnkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'siboudai1kjnkngk$' should not be NULL."));
        }
        return siboudai1kjnkngkType;
    }

    protected void setSiboudai1kjnkngkType(String type) {
        siboudai1kjnkngkType = type;
        siboudai1kjnkngk = Optional.fromNullable(toCurrencyType(siboudai1kjnkngkType))
            .transform(bizCurrencyTransformer(getSiboudai1kjnkngkValue()))
            .orNull();
    }

    private Integer siboudai2hknkkn;

    @Column(name=GenIT_BAK_HokenSyouken.SIBOUDAI2HKNKKN)
    public Integer getSiboudai2hknkkn() {
        return siboudai2hknkkn;
    }

    public void setSiboudai2hknkkn(Integer pSiboudai2hknkkn) {
        siboudai2hknkkn = pSiboudai2hknkkn;
    }

    private BizDate siboudai2hknkknymdto;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.SIBOUDAI2HKNKKNYMDTO)
    public BizDate getSiboudai2hknkknymdto() {
        return siboudai2hknkknymdto;
    }

    public void setSiboudai2hknkknymdto(BizDate pSiboudai2hknkknymdto) {
        siboudai2hknkknymdto = pSiboudai2hknkknymdto;
    }

    private C_Tuukasyu siboudai2kjnkngktuuktype;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.SIBOUDAI2KJNKNGKTUUKTYPE)
    public C_Tuukasyu getSiboudai2kjnkngktuuktype() {
        return siboudai2kjnkngktuuktype;
    }

    public void setSiboudai2kjnkngktuuktype(C_Tuukasyu pSiboudai2kjnkngktuuktype) {
        siboudai2kjnkngktuuktype = pSiboudai2kjnkngktuuktype;
    }

    private BizCurrency siboudai2kjnkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSiboudai2kjnkngk() {
        return siboudai2kjnkngk;
    }

    public void setSiboudai2kjnkngk(BizCurrency pSiboudai2kjnkngk) {
        siboudai2kjnkngk = pSiboudai2kjnkngk;
        siboudai2kjnkngkValue = null;
        siboudai2kjnkngkType  = null;
    }

    transient private BigDecimal siboudai2kjnkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SIBOUDAI2KJNKNGK, nullable=true)
    protected BigDecimal getSiboudai2kjnkngkValue() {
        if (siboudai2kjnkngkValue == null && siboudai2kjnkngk != null) {
            if (siboudai2kjnkngk.isOptional()) return null;
            return siboudai2kjnkngk.absolute();
        }
        return siboudai2kjnkngkValue;
    }

    protected void setSiboudai2kjnkngkValue(BigDecimal value) {
        siboudai2kjnkngkValue = value;
        siboudai2kjnkngk = Optional.fromNullable(toCurrencyType(siboudai2kjnkngkType))
            .transform(bizCurrencyTransformer(getSiboudai2kjnkngkValue()))
            .orNull();
    }

    transient private String siboudai2kjnkngkType = null;

    @Column(name=SIBOUDAI2KJNKNGK + "$", nullable=true)
    protected String getSiboudai2kjnkngkType() {
        if (siboudai2kjnkngkType == null && siboudai2kjnkngk != null) return siboudai2kjnkngk.getType().toString();
        if (siboudai2kjnkngkType == null && getSiboudai2kjnkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'siboudai2kjnkngk$' should not be NULL."));
        }
        return siboudai2kjnkngkType;
    }

    protected void setSiboudai2kjnkngkType(String type) {
        siboudai2kjnkngkType = type;
        siboudai2kjnkngk = Optional.fromNullable(toCurrencyType(siboudai2kjnkngkType))
            .transform(bizCurrencyTransformer(getSiboudai2kjnkngkValue()))
            .orNull();
    }

    private C_Tuukasyu siboudai3kjnkngktuuktype;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.SIBOUDAI3KJNKNGKTUUKTYPE)
    public C_Tuukasyu getSiboudai3kjnkngktuuktype() {
        return siboudai3kjnkngktuuktype;
    }

    public void setSiboudai3kjnkngktuuktype(C_Tuukasyu pSiboudai3kjnkngktuuktype) {
        siboudai3kjnkngktuuktype = pSiboudai3kjnkngktuuktype;
    }

    private BizCurrency siboudai3kjnkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSiboudai3kjnkngk() {
        return siboudai3kjnkngk;
    }

    public void setSiboudai3kjnkngk(BizCurrency pSiboudai3kjnkngk) {
        siboudai3kjnkngk = pSiboudai3kjnkngk;
        siboudai3kjnkngkValue = null;
        siboudai3kjnkngkType  = null;
    }

    transient private BigDecimal siboudai3kjnkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SIBOUDAI3KJNKNGK, nullable=true)
    protected BigDecimal getSiboudai3kjnkngkValue() {
        if (siboudai3kjnkngkValue == null && siboudai3kjnkngk != null) {
            if (siboudai3kjnkngk.isOptional()) return null;
            return siboudai3kjnkngk.absolute();
        }
        return siboudai3kjnkngkValue;
    }

    protected void setSiboudai3kjnkngkValue(BigDecimal value) {
        siboudai3kjnkngkValue = value;
        siboudai3kjnkngk = Optional.fromNullable(toCurrencyType(siboudai3kjnkngkType))
            .transform(bizCurrencyTransformer(getSiboudai3kjnkngkValue()))
            .orNull();
    }

    transient private String siboudai3kjnkngkType = null;

    @Column(name=SIBOUDAI3KJNKNGK + "$", nullable=true)
    protected String getSiboudai3kjnkngkType() {
        if (siboudai3kjnkngkType == null && siboudai3kjnkngk != null) return siboudai3kjnkngk.getType().toString();
        if (siboudai3kjnkngkType == null && getSiboudai3kjnkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'siboudai3kjnkngk$' should not be NULL."));
        }
        return siboudai3kjnkngkType;
    }

    protected void setSiboudai3kjnkngkType(String type) {
        siboudai3kjnkngkType = type;
        siboudai3kjnkngk = Optional.fromNullable(toCurrencyType(siboudai3kjnkngkType))
            .transform(bizCurrencyTransformer(getSiboudai3kjnkngkValue()))
            .orNull();
    }

    private BizNumber dai1skwsrateyendaka;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1SKWSRATEYENDAKA)
    public BizNumber getDai1skwsrateyendaka() {
        return dai1skwsrateyendaka;
    }

    public void setDai1skwsrateyendaka(BizNumber pDai1skwsrateyendaka) {
        dai1skwsrateyendaka = pDai1skwsrateyendaka;
    }

    private BizNumber dai1skwsrateyenkijyun;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1SKWSRATEYENKIJYUN)
    public BizNumber getDai1skwsrateyenkijyun() {
        return dai1skwsrateyenkijyun;
    }

    public void setDai1skwsrateyenkijyun(BizNumber pDai1skwsrateyenkijyun) {
        dai1skwsrateyenkijyun = pDai1skwsrateyenkijyun;
    }

    private BizNumber dai1skwsrateyenyasu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1SKWSRATEYENYASU)
    public BizNumber getDai1skwsrateyenyasu() {
        return dai1skwsrateyenyasu;
    }

    public void setDai1skwsrateyenyasu(BizNumber pDai1skwsrateyenyasu) {
        dai1skwsrateyenyasu = pDai1skwsrateyenyasu;
    }

    private Integer dai1skeikanensuu01;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SKEIKANENSUU01)
    public Integer getDai1skeikanensuu01() {
        return dai1skeikanensuu01;
    }

    public void setDai1skeikanensuu01(Integer pDai1skeikanensuu01) {
        dai1skeikanensuu01 = pDai1skeikanensuu01;
    }

    private BizDate dai1sibousnenoutouymd01;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1SIBOUSNENOUTOUYMD01)
    public BizDate getDai1sibousnenoutouymd01() {
        return dai1sibousnenoutouymd01;
    }

    public void setDai1sibousnenoutouymd01(BizDate pDai1sibousnenoutouymd01) {
        dai1sibousnenoutouymd01 = pDai1sibousnenoutouymd01;
    }

    private C_Tuukasyu dai1stuuktype01;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1STUUKTYPE01)
    public C_Tuukasyu getDai1stuuktype01() {
        return dai1stuuktype01;
    }

    public void setDai1stuuktype01(C_Tuukasyu pDai1stuuktype01) {
        dai1stuuktype01 = pDai1stuuktype01;
    }

    private BizCurrency dai1s01;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1s01() {
        return dai1s01;
    }

    public void setDai1s01(BizCurrency pDai1s01) {
        dai1s01 = pDai1s01;
        dai1s01Value = null;
        dai1s01Type  = null;
    }

    transient private BigDecimal dai1s01Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1S01, nullable=true)
    protected BigDecimal getDai1s01Value() {
        if (dai1s01Value == null && dai1s01 != null) {
            if (dai1s01.isOptional()) return null;
            return dai1s01.absolute();
        }
        return dai1s01Value;
    }

    protected void setDai1s01Value(BigDecimal value) {
        dai1s01Value = value;
        dai1s01 = Optional.fromNullable(toCurrencyType(dai1s01Type))
            .transform(bizCurrencyTransformer(getDai1s01Value()))
            .orNull();
    }

    transient private String dai1s01Type = null;

    @Column(name=DAI1S01 + "$", nullable=true)
    protected String getDai1s01Type() {
        if (dai1s01Type == null && dai1s01 != null) return dai1s01.getType().toString();
        if (dai1s01Type == null && getDai1s01Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1s01$' should not be NULL."));
        }
        return dai1s01Type;
    }

    protected void setDai1s01Type(String type) {
        dai1s01Type = type;
        dai1s01 = Optional.fromNullable(toCurrencyType(dai1s01Type))
            .transform(bizCurrencyTransformer(getDai1s01Value()))
            .orNull();
    }

    private String dai1syenyendakaumu01;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENDAKAUMU01)
    public String getDai1syenyendakaumu01() {
        return dai1syenyendakaumu01;
    }

    public void setDai1syenyendakaumu01(String pDai1syenyendakaumu01) {
        dai1syenyendakaumu01 = pDai1syenyendakaumu01;
    }

    private String dai1syenyenkijyunumu01;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENKIJYUNUMU01)
    public String getDai1syenyenkijyunumu01() {
        return dai1syenyenkijyunumu01;
    }

    public void setDai1syenyenkijyunumu01(String pDai1syenyenkijyunumu01) {
        dai1syenyenkijyunumu01 = pDai1syenyenkijyunumu01;
    }

    private String dai1syenyenyasuumu01;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENYASUUMU01)
    public String getDai1syenyenyasuumu01() {
        return dai1syenyenyasuumu01;
    }

    public void setDai1syenyenyasuumu01(String pDai1syenyenyasuumu01) {
        dai1syenyenyasuumu01 = pDai1syenyenyasuumu01;
    }

    private C_Tuukasyu dai1syentuuktype01;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENTUUKTYPE01)
    public C_Tuukasyu getDai1syentuuktype01() {
        return dai1syentuuktype01;
    }

    public void setDai1syentuuktype01(C_Tuukasyu pDai1syentuuktype01) {
        dai1syentuuktype01 = pDai1syentuuktype01;
    }

    private BizCurrency dai1syenyendaka01;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyendaka01() {
        return dai1syenyendaka01;
    }

    public void setDai1syenyendaka01(BizCurrency pDai1syenyendaka01) {
        dai1syenyendaka01 = pDai1syenyendaka01;
        dai1syenyendaka01Value = null;
        dai1syenyendaka01Type  = null;
    }

    transient private BigDecimal dai1syenyendaka01Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENDAKA01, nullable=true)
    protected BigDecimal getDai1syenyendaka01Value() {
        if (dai1syenyendaka01Value == null && dai1syenyendaka01 != null) {
            if (dai1syenyendaka01.isOptional()) return null;
            return dai1syenyendaka01.absolute();
        }
        return dai1syenyendaka01Value;
    }

    protected void setDai1syenyendaka01Value(BigDecimal value) {
        dai1syenyendaka01Value = value;
        dai1syenyendaka01 = Optional.fromNullable(toCurrencyType(dai1syenyendaka01Type))
            .transform(bizCurrencyTransformer(getDai1syenyendaka01Value()))
            .orNull();
    }

    transient private String dai1syenyendaka01Type = null;

    @Column(name=DAI1SYENYENDAKA01 + "$", nullable=true)
    protected String getDai1syenyendaka01Type() {
        if (dai1syenyendaka01Type == null && dai1syenyendaka01 != null) return dai1syenyendaka01.getType().toString();
        if (dai1syenyendaka01Type == null && getDai1syenyendaka01Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyendaka01$' should not be NULL."));
        }
        return dai1syenyendaka01Type;
    }

    protected void setDai1syenyendaka01Type(String type) {
        dai1syenyendaka01Type = type;
        dai1syenyendaka01 = Optional.fromNullable(toCurrencyType(dai1syenyendaka01Type))
            .transform(bizCurrencyTransformer(getDai1syenyendaka01Value()))
            .orNull();
    }

    private BizCurrency dai1syenyenkijyun01;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyenkijyun01() {
        return dai1syenyenkijyun01;
    }

    public void setDai1syenyenkijyun01(BizCurrency pDai1syenyenkijyun01) {
        dai1syenyenkijyun01 = pDai1syenyenkijyun01;
        dai1syenyenkijyun01Value = null;
        dai1syenyenkijyun01Type  = null;
    }

    transient private BigDecimal dai1syenyenkijyun01Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENKIJYUN01, nullable=true)
    protected BigDecimal getDai1syenyenkijyun01Value() {
        if (dai1syenyenkijyun01Value == null && dai1syenyenkijyun01 != null) {
            if (dai1syenyenkijyun01.isOptional()) return null;
            return dai1syenyenkijyun01.absolute();
        }
        return dai1syenyenkijyun01Value;
    }

    protected void setDai1syenyenkijyun01Value(BigDecimal value) {
        dai1syenyenkijyun01Value = value;
        dai1syenyenkijyun01 = Optional.fromNullable(toCurrencyType(dai1syenyenkijyun01Type))
            .transform(bizCurrencyTransformer(getDai1syenyenkijyun01Value()))
            .orNull();
    }

    transient private String dai1syenyenkijyun01Type = null;

    @Column(name=DAI1SYENYENKIJYUN01 + "$", nullable=true)
    protected String getDai1syenyenkijyun01Type() {
        if (dai1syenyenkijyun01Type == null && dai1syenyenkijyun01 != null) return dai1syenyenkijyun01.getType().toString();
        if (dai1syenyenkijyun01Type == null && getDai1syenyenkijyun01Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyenkijyun01$' should not be NULL."));
        }
        return dai1syenyenkijyun01Type;
    }

    protected void setDai1syenyenkijyun01Type(String type) {
        dai1syenyenkijyun01Type = type;
        dai1syenyenkijyun01 = Optional.fromNullable(toCurrencyType(dai1syenyenkijyun01Type))
            .transform(bizCurrencyTransformer(getDai1syenyenkijyun01Value()))
            .orNull();
    }

    private BizCurrency dai1syenyenyasu01;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyenyasu01() {
        return dai1syenyenyasu01;
    }

    public void setDai1syenyenyasu01(BizCurrency pDai1syenyenyasu01) {
        dai1syenyenyasu01 = pDai1syenyenyasu01;
        dai1syenyenyasu01Value = null;
        dai1syenyenyasu01Type  = null;
    }

    transient private BigDecimal dai1syenyenyasu01Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENYASU01, nullable=true)
    protected BigDecimal getDai1syenyenyasu01Value() {
        if (dai1syenyenyasu01Value == null && dai1syenyenyasu01 != null) {
            if (dai1syenyenyasu01.isOptional()) return null;
            return dai1syenyenyasu01.absolute();
        }
        return dai1syenyenyasu01Value;
    }

    protected void setDai1syenyenyasu01Value(BigDecimal value) {
        dai1syenyenyasu01Value = value;
        dai1syenyenyasu01 = Optional.fromNullable(toCurrencyType(dai1syenyenyasu01Type))
            .transform(bizCurrencyTransformer(getDai1syenyenyasu01Value()))
            .orNull();
    }

    transient private String dai1syenyenyasu01Type = null;

    @Column(name=DAI1SYENYENYASU01 + "$", nullable=true)
    protected String getDai1syenyenyasu01Type() {
        if (dai1syenyenyasu01Type == null && dai1syenyenyasu01 != null) return dai1syenyenyasu01.getType().toString();
        if (dai1syenyenyasu01Type == null && getDai1syenyenyasu01Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyenyasu01$' should not be NULL."));
        }
        return dai1syenyenyasu01Type;
    }

    protected void setDai1syenyenyasu01Type(String type) {
        dai1syenyenyasu01Type = type;
        dai1syenyenyasu01 = Optional.fromNullable(toCurrencyType(dai1syenyenyasu01Type))
            .transform(bizCurrencyTransformer(getDai1syenyenyasu01Value()))
            .orNull();
    }

    private Integer dai1skeikanensuu02;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SKEIKANENSUU02)
    public Integer getDai1skeikanensuu02() {
        return dai1skeikanensuu02;
    }

    public void setDai1skeikanensuu02(Integer pDai1skeikanensuu02) {
        dai1skeikanensuu02 = pDai1skeikanensuu02;
    }

    private BizDate dai1sibousnenoutouymd02;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1SIBOUSNENOUTOUYMD02)
    public BizDate getDai1sibousnenoutouymd02() {
        return dai1sibousnenoutouymd02;
    }

    public void setDai1sibousnenoutouymd02(BizDate pDai1sibousnenoutouymd02) {
        dai1sibousnenoutouymd02 = pDai1sibousnenoutouymd02;
    }

    private C_Tuukasyu dai1stuuktype02;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1STUUKTYPE02)
    public C_Tuukasyu getDai1stuuktype02() {
        return dai1stuuktype02;
    }

    public void setDai1stuuktype02(C_Tuukasyu pDai1stuuktype02) {
        dai1stuuktype02 = pDai1stuuktype02;
    }

    private BizCurrency dai1s02;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1s02() {
        return dai1s02;
    }

    public void setDai1s02(BizCurrency pDai1s02) {
        dai1s02 = pDai1s02;
        dai1s02Value = null;
        dai1s02Type  = null;
    }

    transient private BigDecimal dai1s02Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1S02, nullable=true)
    protected BigDecimal getDai1s02Value() {
        if (dai1s02Value == null && dai1s02 != null) {
            if (dai1s02.isOptional()) return null;
            return dai1s02.absolute();
        }
        return dai1s02Value;
    }

    protected void setDai1s02Value(BigDecimal value) {
        dai1s02Value = value;
        dai1s02 = Optional.fromNullable(toCurrencyType(dai1s02Type))
            .transform(bizCurrencyTransformer(getDai1s02Value()))
            .orNull();
    }

    transient private String dai1s02Type = null;

    @Column(name=DAI1S02 + "$", nullable=true)
    protected String getDai1s02Type() {
        if (dai1s02Type == null && dai1s02 != null) return dai1s02.getType().toString();
        if (dai1s02Type == null && getDai1s02Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1s02$' should not be NULL."));
        }
        return dai1s02Type;
    }

    protected void setDai1s02Type(String type) {
        dai1s02Type = type;
        dai1s02 = Optional.fromNullable(toCurrencyType(dai1s02Type))
            .transform(bizCurrencyTransformer(getDai1s02Value()))
            .orNull();
    }

    private String dai1syenyendakaumu02;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENDAKAUMU02)
    public String getDai1syenyendakaumu02() {
        return dai1syenyendakaumu02;
    }

    public void setDai1syenyendakaumu02(String pDai1syenyendakaumu02) {
        dai1syenyendakaumu02 = pDai1syenyendakaumu02;
    }

    private String dai1syenyenkijyunumu02;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENKIJYUNUMU02)
    public String getDai1syenyenkijyunumu02() {
        return dai1syenyenkijyunumu02;
    }

    public void setDai1syenyenkijyunumu02(String pDai1syenyenkijyunumu02) {
        dai1syenyenkijyunumu02 = pDai1syenyenkijyunumu02;
    }

    private String dai1syenyenyasuumu02;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENYASUUMU02)
    public String getDai1syenyenyasuumu02() {
        return dai1syenyenyasuumu02;
    }

    public void setDai1syenyenyasuumu02(String pDai1syenyenyasuumu02) {
        dai1syenyenyasuumu02 = pDai1syenyenyasuumu02;
    }

    private C_Tuukasyu dai1syentuuktype02;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENTUUKTYPE02)
    public C_Tuukasyu getDai1syentuuktype02() {
        return dai1syentuuktype02;
    }

    public void setDai1syentuuktype02(C_Tuukasyu pDai1syentuuktype02) {
        dai1syentuuktype02 = pDai1syentuuktype02;
    }

    private BizCurrency dai1syenyendaka02;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyendaka02() {
        return dai1syenyendaka02;
    }

    public void setDai1syenyendaka02(BizCurrency pDai1syenyendaka02) {
        dai1syenyendaka02 = pDai1syenyendaka02;
        dai1syenyendaka02Value = null;
        dai1syenyendaka02Type  = null;
    }

    transient private BigDecimal dai1syenyendaka02Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENDAKA02, nullable=true)
    protected BigDecimal getDai1syenyendaka02Value() {
        if (dai1syenyendaka02Value == null && dai1syenyendaka02 != null) {
            if (dai1syenyendaka02.isOptional()) return null;
            return dai1syenyendaka02.absolute();
        }
        return dai1syenyendaka02Value;
    }

    protected void setDai1syenyendaka02Value(BigDecimal value) {
        dai1syenyendaka02Value = value;
        dai1syenyendaka02 = Optional.fromNullable(toCurrencyType(dai1syenyendaka02Type))
            .transform(bizCurrencyTransformer(getDai1syenyendaka02Value()))
            .orNull();
    }

    transient private String dai1syenyendaka02Type = null;

    @Column(name=DAI1SYENYENDAKA02 + "$", nullable=true)
    protected String getDai1syenyendaka02Type() {
        if (dai1syenyendaka02Type == null && dai1syenyendaka02 != null) return dai1syenyendaka02.getType().toString();
        if (dai1syenyendaka02Type == null && getDai1syenyendaka02Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyendaka02$' should not be NULL."));
        }
        return dai1syenyendaka02Type;
    }

    protected void setDai1syenyendaka02Type(String type) {
        dai1syenyendaka02Type = type;
        dai1syenyendaka02 = Optional.fromNullable(toCurrencyType(dai1syenyendaka02Type))
            .transform(bizCurrencyTransformer(getDai1syenyendaka02Value()))
            .orNull();
    }

    private BizCurrency dai1syenyenkijyun02;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyenkijyun02() {
        return dai1syenyenkijyun02;
    }

    public void setDai1syenyenkijyun02(BizCurrency pDai1syenyenkijyun02) {
        dai1syenyenkijyun02 = pDai1syenyenkijyun02;
        dai1syenyenkijyun02Value = null;
        dai1syenyenkijyun02Type  = null;
    }

    transient private BigDecimal dai1syenyenkijyun02Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENKIJYUN02, nullable=true)
    protected BigDecimal getDai1syenyenkijyun02Value() {
        if (dai1syenyenkijyun02Value == null && dai1syenyenkijyun02 != null) {
            if (dai1syenyenkijyun02.isOptional()) return null;
            return dai1syenyenkijyun02.absolute();
        }
        return dai1syenyenkijyun02Value;
    }

    protected void setDai1syenyenkijyun02Value(BigDecimal value) {
        dai1syenyenkijyun02Value = value;
        dai1syenyenkijyun02 = Optional.fromNullable(toCurrencyType(dai1syenyenkijyun02Type))
            .transform(bizCurrencyTransformer(getDai1syenyenkijyun02Value()))
            .orNull();
    }

    transient private String dai1syenyenkijyun02Type = null;

    @Column(name=DAI1SYENYENKIJYUN02 + "$", nullable=true)
    protected String getDai1syenyenkijyun02Type() {
        if (dai1syenyenkijyun02Type == null && dai1syenyenkijyun02 != null) return dai1syenyenkijyun02.getType().toString();
        if (dai1syenyenkijyun02Type == null && getDai1syenyenkijyun02Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyenkijyun02$' should not be NULL."));
        }
        return dai1syenyenkijyun02Type;
    }

    protected void setDai1syenyenkijyun02Type(String type) {
        dai1syenyenkijyun02Type = type;
        dai1syenyenkijyun02 = Optional.fromNullable(toCurrencyType(dai1syenyenkijyun02Type))
            .transform(bizCurrencyTransformer(getDai1syenyenkijyun02Value()))
            .orNull();
    }

    private BizCurrency dai1syenyenyasu02;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyenyasu02() {
        return dai1syenyenyasu02;
    }

    public void setDai1syenyenyasu02(BizCurrency pDai1syenyenyasu02) {
        dai1syenyenyasu02 = pDai1syenyenyasu02;
        dai1syenyenyasu02Value = null;
        dai1syenyenyasu02Type  = null;
    }

    transient private BigDecimal dai1syenyenyasu02Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENYASU02, nullable=true)
    protected BigDecimal getDai1syenyenyasu02Value() {
        if (dai1syenyenyasu02Value == null && dai1syenyenyasu02 != null) {
            if (dai1syenyenyasu02.isOptional()) return null;
            return dai1syenyenyasu02.absolute();
        }
        return dai1syenyenyasu02Value;
    }

    protected void setDai1syenyenyasu02Value(BigDecimal value) {
        dai1syenyenyasu02Value = value;
        dai1syenyenyasu02 = Optional.fromNullable(toCurrencyType(dai1syenyenyasu02Type))
            .transform(bizCurrencyTransformer(getDai1syenyenyasu02Value()))
            .orNull();
    }

    transient private String dai1syenyenyasu02Type = null;

    @Column(name=DAI1SYENYENYASU02 + "$", nullable=true)
    protected String getDai1syenyenyasu02Type() {
        if (dai1syenyenyasu02Type == null && dai1syenyenyasu02 != null) return dai1syenyenyasu02.getType().toString();
        if (dai1syenyenyasu02Type == null && getDai1syenyenyasu02Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyenyasu02$' should not be NULL."));
        }
        return dai1syenyenyasu02Type;
    }

    protected void setDai1syenyenyasu02Type(String type) {
        dai1syenyenyasu02Type = type;
        dai1syenyenyasu02 = Optional.fromNullable(toCurrencyType(dai1syenyenyasu02Type))
            .transform(bizCurrencyTransformer(getDai1syenyenyasu02Value()))
            .orNull();
    }

    private Integer dai1skeikanensuu03;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SKEIKANENSUU03)
    public Integer getDai1skeikanensuu03() {
        return dai1skeikanensuu03;
    }

    public void setDai1skeikanensuu03(Integer pDai1skeikanensuu03) {
        dai1skeikanensuu03 = pDai1skeikanensuu03;
    }

    private BizDate dai1sibousnenoutouymd03;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1SIBOUSNENOUTOUYMD03)
    public BizDate getDai1sibousnenoutouymd03() {
        return dai1sibousnenoutouymd03;
    }

    public void setDai1sibousnenoutouymd03(BizDate pDai1sibousnenoutouymd03) {
        dai1sibousnenoutouymd03 = pDai1sibousnenoutouymd03;
    }

    private C_Tuukasyu dai1stuuktype03;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1STUUKTYPE03)
    public C_Tuukasyu getDai1stuuktype03() {
        return dai1stuuktype03;
    }

    public void setDai1stuuktype03(C_Tuukasyu pDai1stuuktype03) {
        dai1stuuktype03 = pDai1stuuktype03;
    }

    private BizCurrency dai1s03;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1s03() {
        return dai1s03;
    }

    public void setDai1s03(BizCurrency pDai1s03) {
        dai1s03 = pDai1s03;
        dai1s03Value = null;
        dai1s03Type  = null;
    }

    transient private BigDecimal dai1s03Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1S03, nullable=true)
    protected BigDecimal getDai1s03Value() {
        if (dai1s03Value == null && dai1s03 != null) {
            if (dai1s03.isOptional()) return null;
            return dai1s03.absolute();
        }
        return dai1s03Value;
    }

    protected void setDai1s03Value(BigDecimal value) {
        dai1s03Value = value;
        dai1s03 = Optional.fromNullable(toCurrencyType(dai1s03Type))
            .transform(bizCurrencyTransformer(getDai1s03Value()))
            .orNull();
    }

    transient private String dai1s03Type = null;

    @Column(name=DAI1S03 + "$", nullable=true)
    protected String getDai1s03Type() {
        if (dai1s03Type == null && dai1s03 != null) return dai1s03.getType().toString();
        if (dai1s03Type == null && getDai1s03Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1s03$' should not be NULL."));
        }
        return dai1s03Type;
    }

    protected void setDai1s03Type(String type) {
        dai1s03Type = type;
        dai1s03 = Optional.fromNullable(toCurrencyType(dai1s03Type))
            .transform(bizCurrencyTransformer(getDai1s03Value()))
            .orNull();
    }

    private String dai1syenyendakaumu03;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENDAKAUMU03)
    public String getDai1syenyendakaumu03() {
        return dai1syenyendakaumu03;
    }

    public void setDai1syenyendakaumu03(String pDai1syenyendakaumu03) {
        dai1syenyendakaumu03 = pDai1syenyendakaumu03;
    }

    private String dai1syenyenkijyunumu03;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENKIJYUNUMU03)
    public String getDai1syenyenkijyunumu03() {
        return dai1syenyenkijyunumu03;
    }

    public void setDai1syenyenkijyunumu03(String pDai1syenyenkijyunumu03) {
        dai1syenyenkijyunumu03 = pDai1syenyenkijyunumu03;
    }

    private String dai1syenyenyasuumu03;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENYASUUMU03)
    public String getDai1syenyenyasuumu03() {
        return dai1syenyenyasuumu03;
    }

    public void setDai1syenyenyasuumu03(String pDai1syenyenyasuumu03) {
        dai1syenyenyasuumu03 = pDai1syenyenyasuumu03;
    }

    private C_Tuukasyu dai1syentuuktype03;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENTUUKTYPE03)
    public C_Tuukasyu getDai1syentuuktype03() {
        return dai1syentuuktype03;
    }

    public void setDai1syentuuktype03(C_Tuukasyu pDai1syentuuktype03) {
        dai1syentuuktype03 = pDai1syentuuktype03;
    }

    private BizCurrency dai1syenyendaka03;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyendaka03() {
        return dai1syenyendaka03;
    }

    public void setDai1syenyendaka03(BizCurrency pDai1syenyendaka03) {
        dai1syenyendaka03 = pDai1syenyendaka03;
        dai1syenyendaka03Value = null;
        dai1syenyendaka03Type  = null;
    }

    transient private BigDecimal dai1syenyendaka03Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENDAKA03, nullable=true)
    protected BigDecimal getDai1syenyendaka03Value() {
        if (dai1syenyendaka03Value == null && dai1syenyendaka03 != null) {
            if (dai1syenyendaka03.isOptional()) return null;
            return dai1syenyendaka03.absolute();
        }
        return dai1syenyendaka03Value;
    }

    protected void setDai1syenyendaka03Value(BigDecimal value) {
        dai1syenyendaka03Value = value;
        dai1syenyendaka03 = Optional.fromNullable(toCurrencyType(dai1syenyendaka03Type))
            .transform(bizCurrencyTransformer(getDai1syenyendaka03Value()))
            .orNull();
    }

    transient private String dai1syenyendaka03Type = null;

    @Column(name=DAI1SYENYENDAKA03 + "$", nullable=true)
    protected String getDai1syenyendaka03Type() {
        if (dai1syenyendaka03Type == null && dai1syenyendaka03 != null) return dai1syenyendaka03.getType().toString();
        if (dai1syenyendaka03Type == null && getDai1syenyendaka03Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyendaka03$' should not be NULL."));
        }
        return dai1syenyendaka03Type;
    }

    protected void setDai1syenyendaka03Type(String type) {
        dai1syenyendaka03Type = type;
        dai1syenyendaka03 = Optional.fromNullable(toCurrencyType(dai1syenyendaka03Type))
            .transform(bizCurrencyTransformer(getDai1syenyendaka03Value()))
            .orNull();
    }

    private BizCurrency dai1syenyenkijyun03;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyenkijyun03() {
        return dai1syenyenkijyun03;
    }

    public void setDai1syenyenkijyun03(BizCurrency pDai1syenyenkijyun03) {
        dai1syenyenkijyun03 = pDai1syenyenkijyun03;
        dai1syenyenkijyun03Value = null;
        dai1syenyenkijyun03Type  = null;
    }

    transient private BigDecimal dai1syenyenkijyun03Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENKIJYUN03, nullable=true)
    protected BigDecimal getDai1syenyenkijyun03Value() {
        if (dai1syenyenkijyun03Value == null && dai1syenyenkijyun03 != null) {
            if (dai1syenyenkijyun03.isOptional()) return null;
            return dai1syenyenkijyun03.absolute();
        }
        return dai1syenyenkijyun03Value;
    }

    protected void setDai1syenyenkijyun03Value(BigDecimal value) {
        dai1syenyenkijyun03Value = value;
        dai1syenyenkijyun03 = Optional.fromNullable(toCurrencyType(dai1syenyenkijyun03Type))
            .transform(bizCurrencyTransformer(getDai1syenyenkijyun03Value()))
            .orNull();
    }

    transient private String dai1syenyenkijyun03Type = null;

    @Column(name=DAI1SYENYENKIJYUN03 + "$", nullable=true)
    protected String getDai1syenyenkijyun03Type() {
        if (dai1syenyenkijyun03Type == null && dai1syenyenkijyun03 != null) return dai1syenyenkijyun03.getType().toString();
        if (dai1syenyenkijyun03Type == null && getDai1syenyenkijyun03Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyenkijyun03$' should not be NULL."));
        }
        return dai1syenyenkijyun03Type;
    }

    protected void setDai1syenyenkijyun03Type(String type) {
        dai1syenyenkijyun03Type = type;
        dai1syenyenkijyun03 = Optional.fromNullable(toCurrencyType(dai1syenyenkijyun03Type))
            .transform(bizCurrencyTransformer(getDai1syenyenkijyun03Value()))
            .orNull();
    }

    private BizCurrency dai1syenyenyasu03;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyenyasu03() {
        return dai1syenyenyasu03;
    }

    public void setDai1syenyenyasu03(BizCurrency pDai1syenyenyasu03) {
        dai1syenyenyasu03 = pDai1syenyenyasu03;
        dai1syenyenyasu03Value = null;
        dai1syenyenyasu03Type  = null;
    }

    transient private BigDecimal dai1syenyenyasu03Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENYASU03, nullable=true)
    protected BigDecimal getDai1syenyenyasu03Value() {
        if (dai1syenyenyasu03Value == null && dai1syenyenyasu03 != null) {
            if (dai1syenyenyasu03.isOptional()) return null;
            return dai1syenyenyasu03.absolute();
        }
        return dai1syenyenyasu03Value;
    }

    protected void setDai1syenyenyasu03Value(BigDecimal value) {
        dai1syenyenyasu03Value = value;
        dai1syenyenyasu03 = Optional.fromNullable(toCurrencyType(dai1syenyenyasu03Type))
            .transform(bizCurrencyTransformer(getDai1syenyenyasu03Value()))
            .orNull();
    }

    transient private String dai1syenyenyasu03Type = null;

    @Column(name=DAI1SYENYENYASU03 + "$", nullable=true)
    protected String getDai1syenyenyasu03Type() {
        if (dai1syenyenyasu03Type == null && dai1syenyenyasu03 != null) return dai1syenyenyasu03.getType().toString();
        if (dai1syenyenyasu03Type == null && getDai1syenyenyasu03Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyenyasu03$' should not be NULL."));
        }
        return dai1syenyenyasu03Type;
    }

    protected void setDai1syenyenyasu03Type(String type) {
        dai1syenyenyasu03Type = type;
        dai1syenyenyasu03 = Optional.fromNullable(toCurrencyType(dai1syenyenyasu03Type))
            .transform(bizCurrencyTransformer(getDai1syenyenyasu03Value()))
            .orNull();
    }

    private Integer dai1skeikanensuu04;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SKEIKANENSUU04)
    public Integer getDai1skeikanensuu04() {
        return dai1skeikanensuu04;
    }

    public void setDai1skeikanensuu04(Integer pDai1skeikanensuu04) {
        dai1skeikanensuu04 = pDai1skeikanensuu04;
    }

    private BizDate dai1sibousnenoutouymd04;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1SIBOUSNENOUTOUYMD04)
    public BizDate getDai1sibousnenoutouymd04() {
        return dai1sibousnenoutouymd04;
    }

    public void setDai1sibousnenoutouymd04(BizDate pDai1sibousnenoutouymd04) {
        dai1sibousnenoutouymd04 = pDai1sibousnenoutouymd04;
    }

    private C_Tuukasyu dai1stuuktype04;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1STUUKTYPE04)
    public C_Tuukasyu getDai1stuuktype04() {
        return dai1stuuktype04;
    }

    public void setDai1stuuktype04(C_Tuukasyu pDai1stuuktype04) {
        dai1stuuktype04 = pDai1stuuktype04;
    }

    private BizCurrency dai1s04;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1s04() {
        return dai1s04;
    }

    public void setDai1s04(BizCurrency pDai1s04) {
        dai1s04 = pDai1s04;
        dai1s04Value = null;
        dai1s04Type  = null;
    }

    transient private BigDecimal dai1s04Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1S04, nullable=true)
    protected BigDecimal getDai1s04Value() {
        if (dai1s04Value == null && dai1s04 != null) {
            if (dai1s04.isOptional()) return null;
            return dai1s04.absolute();
        }
        return dai1s04Value;
    }

    protected void setDai1s04Value(BigDecimal value) {
        dai1s04Value = value;
        dai1s04 = Optional.fromNullable(toCurrencyType(dai1s04Type))
            .transform(bizCurrencyTransformer(getDai1s04Value()))
            .orNull();
    }

    transient private String dai1s04Type = null;

    @Column(name=DAI1S04 + "$", nullable=true)
    protected String getDai1s04Type() {
        if (dai1s04Type == null && dai1s04 != null) return dai1s04.getType().toString();
        if (dai1s04Type == null && getDai1s04Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1s04$' should not be NULL."));
        }
        return dai1s04Type;
    }

    protected void setDai1s04Type(String type) {
        dai1s04Type = type;
        dai1s04 = Optional.fromNullable(toCurrencyType(dai1s04Type))
            .transform(bizCurrencyTransformer(getDai1s04Value()))
            .orNull();
    }

    private String dai1syenyendakaumu04;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENDAKAUMU04)
    public String getDai1syenyendakaumu04() {
        return dai1syenyendakaumu04;
    }

    public void setDai1syenyendakaumu04(String pDai1syenyendakaumu04) {
        dai1syenyendakaumu04 = pDai1syenyendakaumu04;
    }

    private String dai1syenyenkijyunumu04;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENKIJYUNUMU04)
    public String getDai1syenyenkijyunumu04() {
        return dai1syenyenkijyunumu04;
    }

    public void setDai1syenyenkijyunumu04(String pDai1syenyenkijyunumu04) {
        dai1syenyenkijyunumu04 = pDai1syenyenkijyunumu04;
    }

    private String dai1syenyenyasuumu04;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENYASUUMU04)
    public String getDai1syenyenyasuumu04() {
        return dai1syenyenyasuumu04;
    }

    public void setDai1syenyenyasuumu04(String pDai1syenyenyasuumu04) {
        dai1syenyenyasuumu04 = pDai1syenyenyasuumu04;
    }

    private C_Tuukasyu dai1syentuuktype04;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENTUUKTYPE04)
    public C_Tuukasyu getDai1syentuuktype04() {
        return dai1syentuuktype04;
    }

    public void setDai1syentuuktype04(C_Tuukasyu pDai1syentuuktype04) {
        dai1syentuuktype04 = pDai1syentuuktype04;
    }

    private BizCurrency dai1syenyendaka04;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyendaka04() {
        return dai1syenyendaka04;
    }

    public void setDai1syenyendaka04(BizCurrency pDai1syenyendaka04) {
        dai1syenyendaka04 = pDai1syenyendaka04;
        dai1syenyendaka04Value = null;
        dai1syenyendaka04Type  = null;
    }

    transient private BigDecimal dai1syenyendaka04Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENDAKA04, nullable=true)
    protected BigDecimal getDai1syenyendaka04Value() {
        if (dai1syenyendaka04Value == null && dai1syenyendaka04 != null) {
            if (dai1syenyendaka04.isOptional()) return null;
            return dai1syenyendaka04.absolute();
        }
        return dai1syenyendaka04Value;
    }

    protected void setDai1syenyendaka04Value(BigDecimal value) {
        dai1syenyendaka04Value = value;
        dai1syenyendaka04 = Optional.fromNullable(toCurrencyType(dai1syenyendaka04Type))
            .transform(bizCurrencyTransformer(getDai1syenyendaka04Value()))
            .orNull();
    }

    transient private String dai1syenyendaka04Type = null;

    @Column(name=DAI1SYENYENDAKA04 + "$", nullable=true)
    protected String getDai1syenyendaka04Type() {
        if (dai1syenyendaka04Type == null && dai1syenyendaka04 != null) return dai1syenyendaka04.getType().toString();
        if (dai1syenyendaka04Type == null && getDai1syenyendaka04Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyendaka04$' should not be NULL."));
        }
        return dai1syenyendaka04Type;
    }

    protected void setDai1syenyendaka04Type(String type) {
        dai1syenyendaka04Type = type;
        dai1syenyendaka04 = Optional.fromNullable(toCurrencyType(dai1syenyendaka04Type))
            .transform(bizCurrencyTransformer(getDai1syenyendaka04Value()))
            .orNull();
    }

    private BizCurrency dai1syenyenkijyun04;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyenkijyun04() {
        return dai1syenyenkijyun04;
    }

    public void setDai1syenyenkijyun04(BizCurrency pDai1syenyenkijyun04) {
        dai1syenyenkijyun04 = pDai1syenyenkijyun04;
        dai1syenyenkijyun04Value = null;
        dai1syenyenkijyun04Type  = null;
    }

    transient private BigDecimal dai1syenyenkijyun04Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENKIJYUN04, nullable=true)
    protected BigDecimal getDai1syenyenkijyun04Value() {
        if (dai1syenyenkijyun04Value == null && dai1syenyenkijyun04 != null) {
            if (dai1syenyenkijyun04.isOptional()) return null;
            return dai1syenyenkijyun04.absolute();
        }
        return dai1syenyenkijyun04Value;
    }

    protected void setDai1syenyenkijyun04Value(BigDecimal value) {
        dai1syenyenkijyun04Value = value;
        dai1syenyenkijyun04 = Optional.fromNullable(toCurrencyType(dai1syenyenkijyun04Type))
            .transform(bizCurrencyTransformer(getDai1syenyenkijyun04Value()))
            .orNull();
    }

    transient private String dai1syenyenkijyun04Type = null;

    @Column(name=DAI1SYENYENKIJYUN04 + "$", nullable=true)
    protected String getDai1syenyenkijyun04Type() {
        if (dai1syenyenkijyun04Type == null && dai1syenyenkijyun04 != null) return dai1syenyenkijyun04.getType().toString();
        if (dai1syenyenkijyun04Type == null && getDai1syenyenkijyun04Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyenkijyun04$' should not be NULL."));
        }
        return dai1syenyenkijyun04Type;
    }

    protected void setDai1syenyenkijyun04Type(String type) {
        dai1syenyenkijyun04Type = type;
        dai1syenyenkijyun04 = Optional.fromNullable(toCurrencyType(dai1syenyenkijyun04Type))
            .transform(bizCurrencyTransformer(getDai1syenyenkijyun04Value()))
            .orNull();
    }

    private BizCurrency dai1syenyenyasu04;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyenyasu04() {
        return dai1syenyenyasu04;
    }

    public void setDai1syenyenyasu04(BizCurrency pDai1syenyenyasu04) {
        dai1syenyenyasu04 = pDai1syenyenyasu04;
        dai1syenyenyasu04Value = null;
        dai1syenyenyasu04Type  = null;
    }

    transient private BigDecimal dai1syenyenyasu04Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENYASU04, nullable=true)
    protected BigDecimal getDai1syenyenyasu04Value() {
        if (dai1syenyenyasu04Value == null && dai1syenyenyasu04 != null) {
            if (dai1syenyenyasu04.isOptional()) return null;
            return dai1syenyenyasu04.absolute();
        }
        return dai1syenyenyasu04Value;
    }

    protected void setDai1syenyenyasu04Value(BigDecimal value) {
        dai1syenyenyasu04Value = value;
        dai1syenyenyasu04 = Optional.fromNullable(toCurrencyType(dai1syenyenyasu04Type))
            .transform(bizCurrencyTransformer(getDai1syenyenyasu04Value()))
            .orNull();
    }

    transient private String dai1syenyenyasu04Type = null;

    @Column(name=DAI1SYENYENYASU04 + "$", nullable=true)
    protected String getDai1syenyenyasu04Type() {
        if (dai1syenyenyasu04Type == null && dai1syenyenyasu04 != null) return dai1syenyenyasu04.getType().toString();
        if (dai1syenyenyasu04Type == null && getDai1syenyenyasu04Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyenyasu04$' should not be NULL."));
        }
        return dai1syenyenyasu04Type;
    }

    protected void setDai1syenyenyasu04Type(String type) {
        dai1syenyenyasu04Type = type;
        dai1syenyenyasu04 = Optional.fromNullable(toCurrencyType(dai1syenyenyasu04Type))
            .transform(bizCurrencyTransformer(getDai1syenyenyasu04Value()))
            .orNull();
    }

    private Integer dai1skeikanensuu05;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SKEIKANENSUU05)
    public Integer getDai1skeikanensuu05() {
        return dai1skeikanensuu05;
    }

    public void setDai1skeikanensuu05(Integer pDai1skeikanensuu05) {
        dai1skeikanensuu05 = pDai1skeikanensuu05;
    }

    private BizDate dai1sibousnenoutouymd05;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1SIBOUSNENOUTOUYMD05)
    public BizDate getDai1sibousnenoutouymd05() {
        return dai1sibousnenoutouymd05;
    }

    public void setDai1sibousnenoutouymd05(BizDate pDai1sibousnenoutouymd05) {
        dai1sibousnenoutouymd05 = pDai1sibousnenoutouymd05;
    }

    private C_Tuukasyu dai1stuuktype05;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1STUUKTYPE05)
    public C_Tuukasyu getDai1stuuktype05() {
        return dai1stuuktype05;
    }

    public void setDai1stuuktype05(C_Tuukasyu pDai1stuuktype05) {
        dai1stuuktype05 = pDai1stuuktype05;
    }

    private BizCurrency dai1s05;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1s05() {
        return dai1s05;
    }

    public void setDai1s05(BizCurrency pDai1s05) {
        dai1s05 = pDai1s05;
        dai1s05Value = null;
        dai1s05Type  = null;
    }

    transient private BigDecimal dai1s05Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1S05, nullable=true)
    protected BigDecimal getDai1s05Value() {
        if (dai1s05Value == null && dai1s05 != null) {
            if (dai1s05.isOptional()) return null;
            return dai1s05.absolute();
        }
        return dai1s05Value;
    }

    protected void setDai1s05Value(BigDecimal value) {
        dai1s05Value = value;
        dai1s05 = Optional.fromNullable(toCurrencyType(dai1s05Type))
            .transform(bizCurrencyTransformer(getDai1s05Value()))
            .orNull();
    }

    transient private String dai1s05Type = null;

    @Column(name=DAI1S05 + "$", nullable=true)
    protected String getDai1s05Type() {
        if (dai1s05Type == null && dai1s05 != null) return dai1s05.getType().toString();
        if (dai1s05Type == null && getDai1s05Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1s05$' should not be NULL."));
        }
        return dai1s05Type;
    }

    protected void setDai1s05Type(String type) {
        dai1s05Type = type;
        dai1s05 = Optional.fromNullable(toCurrencyType(dai1s05Type))
            .transform(bizCurrencyTransformer(getDai1s05Value()))
            .orNull();
    }

    private String dai1syenyendakaumu05;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENDAKAUMU05)
    public String getDai1syenyendakaumu05() {
        return dai1syenyendakaumu05;
    }

    public void setDai1syenyendakaumu05(String pDai1syenyendakaumu05) {
        dai1syenyendakaumu05 = pDai1syenyendakaumu05;
    }

    private String dai1syenyenkijyunumu05;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENKIJYUNUMU05)
    public String getDai1syenyenkijyunumu05() {
        return dai1syenyenkijyunumu05;
    }

    public void setDai1syenyenkijyunumu05(String pDai1syenyenkijyunumu05) {
        dai1syenyenkijyunumu05 = pDai1syenyenkijyunumu05;
    }

    private String dai1syenyenyasuumu05;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENYASUUMU05)
    public String getDai1syenyenyasuumu05() {
        return dai1syenyenyasuumu05;
    }

    public void setDai1syenyenyasuumu05(String pDai1syenyenyasuumu05) {
        dai1syenyenyasuumu05 = pDai1syenyenyasuumu05;
    }

    private C_Tuukasyu dai1syentuuktype05;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENTUUKTYPE05)
    public C_Tuukasyu getDai1syentuuktype05() {
        return dai1syentuuktype05;
    }

    public void setDai1syentuuktype05(C_Tuukasyu pDai1syentuuktype05) {
        dai1syentuuktype05 = pDai1syentuuktype05;
    }

    private BizCurrency dai1syenyendaka05;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyendaka05() {
        return dai1syenyendaka05;
    }

    public void setDai1syenyendaka05(BizCurrency pDai1syenyendaka05) {
        dai1syenyendaka05 = pDai1syenyendaka05;
        dai1syenyendaka05Value = null;
        dai1syenyendaka05Type  = null;
    }

    transient private BigDecimal dai1syenyendaka05Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENDAKA05, nullable=true)
    protected BigDecimal getDai1syenyendaka05Value() {
        if (dai1syenyendaka05Value == null && dai1syenyendaka05 != null) {
            if (dai1syenyendaka05.isOptional()) return null;
            return dai1syenyendaka05.absolute();
        }
        return dai1syenyendaka05Value;
    }

    protected void setDai1syenyendaka05Value(BigDecimal value) {
        dai1syenyendaka05Value = value;
        dai1syenyendaka05 = Optional.fromNullable(toCurrencyType(dai1syenyendaka05Type))
            .transform(bizCurrencyTransformer(getDai1syenyendaka05Value()))
            .orNull();
    }

    transient private String dai1syenyendaka05Type = null;

    @Column(name=DAI1SYENYENDAKA05 + "$", nullable=true)
    protected String getDai1syenyendaka05Type() {
        if (dai1syenyendaka05Type == null && dai1syenyendaka05 != null) return dai1syenyendaka05.getType().toString();
        if (dai1syenyendaka05Type == null && getDai1syenyendaka05Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyendaka05$' should not be NULL."));
        }
        return dai1syenyendaka05Type;
    }

    protected void setDai1syenyendaka05Type(String type) {
        dai1syenyendaka05Type = type;
        dai1syenyendaka05 = Optional.fromNullable(toCurrencyType(dai1syenyendaka05Type))
            .transform(bizCurrencyTransformer(getDai1syenyendaka05Value()))
            .orNull();
    }

    private BizCurrency dai1syenyenkijyun05;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyenkijyun05() {
        return dai1syenyenkijyun05;
    }

    public void setDai1syenyenkijyun05(BizCurrency pDai1syenyenkijyun05) {
        dai1syenyenkijyun05 = pDai1syenyenkijyun05;
        dai1syenyenkijyun05Value = null;
        dai1syenyenkijyun05Type  = null;
    }

    transient private BigDecimal dai1syenyenkijyun05Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENKIJYUN05, nullable=true)
    protected BigDecimal getDai1syenyenkijyun05Value() {
        if (dai1syenyenkijyun05Value == null && dai1syenyenkijyun05 != null) {
            if (dai1syenyenkijyun05.isOptional()) return null;
            return dai1syenyenkijyun05.absolute();
        }
        return dai1syenyenkijyun05Value;
    }

    protected void setDai1syenyenkijyun05Value(BigDecimal value) {
        dai1syenyenkijyun05Value = value;
        dai1syenyenkijyun05 = Optional.fromNullable(toCurrencyType(dai1syenyenkijyun05Type))
            .transform(bizCurrencyTransformer(getDai1syenyenkijyun05Value()))
            .orNull();
    }

    transient private String dai1syenyenkijyun05Type = null;

    @Column(name=DAI1SYENYENKIJYUN05 + "$", nullable=true)
    protected String getDai1syenyenkijyun05Type() {
        if (dai1syenyenkijyun05Type == null && dai1syenyenkijyun05 != null) return dai1syenyenkijyun05.getType().toString();
        if (dai1syenyenkijyun05Type == null && getDai1syenyenkijyun05Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyenkijyun05$' should not be NULL."));
        }
        return dai1syenyenkijyun05Type;
    }

    protected void setDai1syenyenkijyun05Type(String type) {
        dai1syenyenkijyun05Type = type;
        dai1syenyenkijyun05 = Optional.fromNullable(toCurrencyType(dai1syenyenkijyun05Type))
            .transform(bizCurrencyTransformer(getDai1syenyenkijyun05Value()))
            .orNull();
    }

    private BizCurrency dai1syenyenyasu05;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyenyasu05() {
        return dai1syenyenyasu05;
    }

    public void setDai1syenyenyasu05(BizCurrency pDai1syenyenyasu05) {
        dai1syenyenyasu05 = pDai1syenyenyasu05;
        dai1syenyenyasu05Value = null;
        dai1syenyenyasu05Type  = null;
    }

    transient private BigDecimal dai1syenyenyasu05Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENYASU05, nullable=true)
    protected BigDecimal getDai1syenyenyasu05Value() {
        if (dai1syenyenyasu05Value == null && dai1syenyenyasu05 != null) {
            if (dai1syenyenyasu05.isOptional()) return null;
            return dai1syenyenyasu05.absolute();
        }
        return dai1syenyenyasu05Value;
    }

    protected void setDai1syenyenyasu05Value(BigDecimal value) {
        dai1syenyenyasu05Value = value;
        dai1syenyenyasu05 = Optional.fromNullable(toCurrencyType(dai1syenyenyasu05Type))
            .transform(bizCurrencyTransformer(getDai1syenyenyasu05Value()))
            .orNull();
    }

    transient private String dai1syenyenyasu05Type = null;

    @Column(name=DAI1SYENYENYASU05 + "$", nullable=true)
    protected String getDai1syenyenyasu05Type() {
        if (dai1syenyenyasu05Type == null && dai1syenyenyasu05 != null) return dai1syenyenyasu05.getType().toString();
        if (dai1syenyenyasu05Type == null && getDai1syenyenyasu05Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyenyasu05$' should not be NULL."));
        }
        return dai1syenyenyasu05Type;
    }

    protected void setDai1syenyenyasu05Type(String type) {
        dai1syenyenyasu05Type = type;
        dai1syenyenyasu05 = Optional.fromNullable(toCurrencyType(dai1syenyenyasu05Type))
            .transform(bizCurrencyTransformer(getDai1syenyenyasu05Value()))
            .orNull();
    }

    private Integer dai1skeikanensuu06;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SKEIKANENSUU06)
    public Integer getDai1skeikanensuu06() {
        return dai1skeikanensuu06;
    }

    public void setDai1skeikanensuu06(Integer pDai1skeikanensuu06) {
        dai1skeikanensuu06 = pDai1skeikanensuu06;
    }

    private BizDate dai1sibousnenoutouymd06;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1SIBOUSNENOUTOUYMD06)
    public BizDate getDai1sibousnenoutouymd06() {
        return dai1sibousnenoutouymd06;
    }

    public void setDai1sibousnenoutouymd06(BizDate pDai1sibousnenoutouymd06) {
        dai1sibousnenoutouymd06 = pDai1sibousnenoutouymd06;
    }

    private C_Tuukasyu dai1stuuktype06;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1STUUKTYPE06)
    public C_Tuukasyu getDai1stuuktype06() {
        return dai1stuuktype06;
    }

    public void setDai1stuuktype06(C_Tuukasyu pDai1stuuktype06) {
        dai1stuuktype06 = pDai1stuuktype06;
    }

    private BizCurrency dai1s06;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1s06() {
        return dai1s06;
    }

    public void setDai1s06(BizCurrency pDai1s06) {
        dai1s06 = pDai1s06;
        dai1s06Value = null;
        dai1s06Type  = null;
    }

    transient private BigDecimal dai1s06Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1S06, nullable=true)
    protected BigDecimal getDai1s06Value() {
        if (dai1s06Value == null && dai1s06 != null) {
            if (dai1s06.isOptional()) return null;
            return dai1s06.absolute();
        }
        return dai1s06Value;
    }

    protected void setDai1s06Value(BigDecimal value) {
        dai1s06Value = value;
        dai1s06 = Optional.fromNullable(toCurrencyType(dai1s06Type))
            .transform(bizCurrencyTransformer(getDai1s06Value()))
            .orNull();
    }

    transient private String dai1s06Type = null;

    @Column(name=DAI1S06 + "$", nullable=true)
    protected String getDai1s06Type() {
        if (dai1s06Type == null && dai1s06 != null) return dai1s06.getType().toString();
        if (dai1s06Type == null && getDai1s06Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1s06$' should not be NULL."));
        }
        return dai1s06Type;
    }

    protected void setDai1s06Type(String type) {
        dai1s06Type = type;
        dai1s06 = Optional.fromNullable(toCurrencyType(dai1s06Type))
            .transform(bizCurrencyTransformer(getDai1s06Value()))
            .orNull();
    }

    private String dai1syenyendakaumu06;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENDAKAUMU06)
    public String getDai1syenyendakaumu06() {
        return dai1syenyendakaumu06;
    }

    public void setDai1syenyendakaumu06(String pDai1syenyendakaumu06) {
        dai1syenyendakaumu06 = pDai1syenyendakaumu06;
    }

    private String dai1syenyenkijyunumu06;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENKIJYUNUMU06)
    public String getDai1syenyenkijyunumu06() {
        return dai1syenyenkijyunumu06;
    }

    public void setDai1syenyenkijyunumu06(String pDai1syenyenkijyunumu06) {
        dai1syenyenkijyunumu06 = pDai1syenyenkijyunumu06;
    }

    private String dai1syenyenyasuumu06;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENYASUUMU06)
    public String getDai1syenyenyasuumu06() {
        return dai1syenyenyasuumu06;
    }

    public void setDai1syenyenyasuumu06(String pDai1syenyenyasuumu06) {
        dai1syenyenyasuumu06 = pDai1syenyenyasuumu06;
    }

    private C_Tuukasyu dai1syentuuktype06;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENTUUKTYPE06)
    public C_Tuukasyu getDai1syentuuktype06() {
        return dai1syentuuktype06;
    }

    public void setDai1syentuuktype06(C_Tuukasyu pDai1syentuuktype06) {
        dai1syentuuktype06 = pDai1syentuuktype06;
    }

    private BizCurrency dai1syenyendaka06;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyendaka06() {
        return dai1syenyendaka06;
    }

    public void setDai1syenyendaka06(BizCurrency pDai1syenyendaka06) {
        dai1syenyendaka06 = pDai1syenyendaka06;
        dai1syenyendaka06Value = null;
        dai1syenyendaka06Type  = null;
    }

    transient private BigDecimal dai1syenyendaka06Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENDAKA06, nullable=true)
    protected BigDecimal getDai1syenyendaka06Value() {
        if (dai1syenyendaka06Value == null && dai1syenyendaka06 != null) {
            if (dai1syenyendaka06.isOptional()) return null;
            return dai1syenyendaka06.absolute();
        }
        return dai1syenyendaka06Value;
    }

    protected void setDai1syenyendaka06Value(BigDecimal value) {
        dai1syenyendaka06Value = value;
        dai1syenyendaka06 = Optional.fromNullable(toCurrencyType(dai1syenyendaka06Type))
            .transform(bizCurrencyTransformer(getDai1syenyendaka06Value()))
            .orNull();
    }

    transient private String dai1syenyendaka06Type = null;

    @Column(name=DAI1SYENYENDAKA06 + "$", nullable=true)
    protected String getDai1syenyendaka06Type() {
        if (dai1syenyendaka06Type == null && dai1syenyendaka06 != null) return dai1syenyendaka06.getType().toString();
        if (dai1syenyendaka06Type == null && getDai1syenyendaka06Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyendaka06$' should not be NULL."));
        }
        return dai1syenyendaka06Type;
    }

    protected void setDai1syenyendaka06Type(String type) {
        dai1syenyendaka06Type = type;
        dai1syenyendaka06 = Optional.fromNullable(toCurrencyType(dai1syenyendaka06Type))
            .transform(bizCurrencyTransformer(getDai1syenyendaka06Value()))
            .orNull();
    }

    private BizCurrency dai1syenyenkijyun06;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyenkijyun06() {
        return dai1syenyenkijyun06;
    }

    public void setDai1syenyenkijyun06(BizCurrency pDai1syenyenkijyun06) {
        dai1syenyenkijyun06 = pDai1syenyenkijyun06;
        dai1syenyenkijyun06Value = null;
        dai1syenyenkijyun06Type  = null;
    }

    transient private BigDecimal dai1syenyenkijyun06Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENKIJYUN06, nullable=true)
    protected BigDecimal getDai1syenyenkijyun06Value() {
        if (dai1syenyenkijyun06Value == null && dai1syenyenkijyun06 != null) {
            if (dai1syenyenkijyun06.isOptional()) return null;
            return dai1syenyenkijyun06.absolute();
        }
        return dai1syenyenkijyun06Value;
    }

    protected void setDai1syenyenkijyun06Value(BigDecimal value) {
        dai1syenyenkijyun06Value = value;
        dai1syenyenkijyun06 = Optional.fromNullable(toCurrencyType(dai1syenyenkijyun06Type))
            .transform(bizCurrencyTransformer(getDai1syenyenkijyun06Value()))
            .orNull();
    }

    transient private String dai1syenyenkijyun06Type = null;

    @Column(name=DAI1SYENYENKIJYUN06 + "$", nullable=true)
    protected String getDai1syenyenkijyun06Type() {
        if (dai1syenyenkijyun06Type == null && dai1syenyenkijyun06 != null) return dai1syenyenkijyun06.getType().toString();
        if (dai1syenyenkijyun06Type == null && getDai1syenyenkijyun06Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyenkijyun06$' should not be NULL."));
        }
        return dai1syenyenkijyun06Type;
    }

    protected void setDai1syenyenkijyun06Type(String type) {
        dai1syenyenkijyun06Type = type;
        dai1syenyenkijyun06 = Optional.fromNullable(toCurrencyType(dai1syenyenkijyun06Type))
            .transform(bizCurrencyTransformer(getDai1syenyenkijyun06Value()))
            .orNull();
    }

    private BizCurrency dai1syenyenyasu06;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyenyasu06() {
        return dai1syenyenyasu06;
    }

    public void setDai1syenyenyasu06(BizCurrency pDai1syenyenyasu06) {
        dai1syenyenyasu06 = pDai1syenyenyasu06;
        dai1syenyenyasu06Value = null;
        dai1syenyenyasu06Type  = null;
    }

    transient private BigDecimal dai1syenyenyasu06Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENYASU06, nullable=true)
    protected BigDecimal getDai1syenyenyasu06Value() {
        if (dai1syenyenyasu06Value == null && dai1syenyenyasu06 != null) {
            if (dai1syenyenyasu06.isOptional()) return null;
            return dai1syenyenyasu06.absolute();
        }
        return dai1syenyenyasu06Value;
    }

    protected void setDai1syenyenyasu06Value(BigDecimal value) {
        dai1syenyenyasu06Value = value;
        dai1syenyenyasu06 = Optional.fromNullable(toCurrencyType(dai1syenyenyasu06Type))
            .transform(bizCurrencyTransformer(getDai1syenyenyasu06Value()))
            .orNull();
    }

    transient private String dai1syenyenyasu06Type = null;

    @Column(name=DAI1SYENYENYASU06 + "$", nullable=true)
    protected String getDai1syenyenyasu06Type() {
        if (dai1syenyenyasu06Type == null && dai1syenyenyasu06 != null) return dai1syenyenyasu06.getType().toString();
        if (dai1syenyenyasu06Type == null && getDai1syenyenyasu06Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyenyasu06$' should not be NULL."));
        }
        return dai1syenyenyasu06Type;
    }

    protected void setDai1syenyenyasu06Type(String type) {
        dai1syenyenyasu06Type = type;
        dai1syenyenyasu06 = Optional.fromNullable(toCurrencyType(dai1syenyenyasu06Type))
            .transform(bizCurrencyTransformer(getDai1syenyenyasu06Value()))
            .orNull();
    }

    private Integer dai1skeikanensuu07;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SKEIKANENSUU07)
    public Integer getDai1skeikanensuu07() {
        return dai1skeikanensuu07;
    }

    public void setDai1skeikanensuu07(Integer pDai1skeikanensuu07) {
        dai1skeikanensuu07 = pDai1skeikanensuu07;
    }

    private BizDate dai1sibousnenoutouymd07;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1SIBOUSNENOUTOUYMD07)
    public BizDate getDai1sibousnenoutouymd07() {
        return dai1sibousnenoutouymd07;
    }

    public void setDai1sibousnenoutouymd07(BizDate pDai1sibousnenoutouymd07) {
        dai1sibousnenoutouymd07 = pDai1sibousnenoutouymd07;
    }

    private C_Tuukasyu dai1stuuktype07;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1STUUKTYPE07)
    public C_Tuukasyu getDai1stuuktype07() {
        return dai1stuuktype07;
    }

    public void setDai1stuuktype07(C_Tuukasyu pDai1stuuktype07) {
        dai1stuuktype07 = pDai1stuuktype07;
    }

    private BizCurrency dai1s07;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1s07() {
        return dai1s07;
    }

    public void setDai1s07(BizCurrency pDai1s07) {
        dai1s07 = pDai1s07;
        dai1s07Value = null;
        dai1s07Type  = null;
    }

    transient private BigDecimal dai1s07Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1S07, nullable=true)
    protected BigDecimal getDai1s07Value() {
        if (dai1s07Value == null && dai1s07 != null) {
            if (dai1s07.isOptional()) return null;
            return dai1s07.absolute();
        }
        return dai1s07Value;
    }

    protected void setDai1s07Value(BigDecimal value) {
        dai1s07Value = value;
        dai1s07 = Optional.fromNullable(toCurrencyType(dai1s07Type))
            .transform(bizCurrencyTransformer(getDai1s07Value()))
            .orNull();
    }

    transient private String dai1s07Type = null;

    @Column(name=DAI1S07 + "$", nullable=true)
    protected String getDai1s07Type() {
        if (dai1s07Type == null && dai1s07 != null) return dai1s07.getType().toString();
        if (dai1s07Type == null && getDai1s07Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1s07$' should not be NULL."));
        }
        return dai1s07Type;
    }

    protected void setDai1s07Type(String type) {
        dai1s07Type = type;
        dai1s07 = Optional.fromNullable(toCurrencyType(dai1s07Type))
            .transform(bizCurrencyTransformer(getDai1s07Value()))
            .orNull();
    }

    private String dai1syenyendakaumu07;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENDAKAUMU07)
    public String getDai1syenyendakaumu07() {
        return dai1syenyendakaumu07;
    }

    public void setDai1syenyendakaumu07(String pDai1syenyendakaumu07) {
        dai1syenyendakaumu07 = pDai1syenyendakaumu07;
    }

    private String dai1syenyenkijyunumu07;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENKIJYUNUMU07)
    public String getDai1syenyenkijyunumu07() {
        return dai1syenyenkijyunumu07;
    }

    public void setDai1syenyenkijyunumu07(String pDai1syenyenkijyunumu07) {
        dai1syenyenkijyunumu07 = pDai1syenyenkijyunumu07;
    }

    private String dai1syenyenyasuumu07;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENYASUUMU07)
    public String getDai1syenyenyasuumu07() {
        return dai1syenyenyasuumu07;
    }

    public void setDai1syenyenyasuumu07(String pDai1syenyenyasuumu07) {
        dai1syenyenyasuumu07 = pDai1syenyenyasuumu07;
    }

    private C_Tuukasyu dai1syentuuktype07;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENTUUKTYPE07)
    public C_Tuukasyu getDai1syentuuktype07() {
        return dai1syentuuktype07;
    }

    public void setDai1syentuuktype07(C_Tuukasyu pDai1syentuuktype07) {
        dai1syentuuktype07 = pDai1syentuuktype07;
    }

    private BizCurrency dai1syenyendaka07;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyendaka07() {
        return dai1syenyendaka07;
    }

    public void setDai1syenyendaka07(BizCurrency pDai1syenyendaka07) {
        dai1syenyendaka07 = pDai1syenyendaka07;
        dai1syenyendaka07Value = null;
        dai1syenyendaka07Type  = null;
    }

    transient private BigDecimal dai1syenyendaka07Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENDAKA07, nullable=true)
    protected BigDecimal getDai1syenyendaka07Value() {
        if (dai1syenyendaka07Value == null && dai1syenyendaka07 != null) {
            if (dai1syenyendaka07.isOptional()) return null;
            return dai1syenyendaka07.absolute();
        }
        return dai1syenyendaka07Value;
    }

    protected void setDai1syenyendaka07Value(BigDecimal value) {
        dai1syenyendaka07Value = value;
        dai1syenyendaka07 = Optional.fromNullable(toCurrencyType(dai1syenyendaka07Type))
            .transform(bizCurrencyTransformer(getDai1syenyendaka07Value()))
            .orNull();
    }

    transient private String dai1syenyendaka07Type = null;

    @Column(name=DAI1SYENYENDAKA07 + "$", nullable=true)
    protected String getDai1syenyendaka07Type() {
        if (dai1syenyendaka07Type == null && dai1syenyendaka07 != null) return dai1syenyendaka07.getType().toString();
        if (dai1syenyendaka07Type == null && getDai1syenyendaka07Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyendaka07$' should not be NULL."));
        }
        return dai1syenyendaka07Type;
    }

    protected void setDai1syenyendaka07Type(String type) {
        dai1syenyendaka07Type = type;
        dai1syenyendaka07 = Optional.fromNullable(toCurrencyType(dai1syenyendaka07Type))
            .transform(bizCurrencyTransformer(getDai1syenyendaka07Value()))
            .orNull();
    }

    private BizCurrency dai1syenyenkijyun07;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyenkijyun07() {
        return dai1syenyenkijyun07;
    }

    public void setDai1syenyenkijyun07(BizCurrency pDai1syenyenkijyun07) {
        dai1syenyenkijyun07 = pDai1syenyenkijyun07;
        dai1syenyenkijyun07Value = null;
        dai1syenyenkijyun07Type  = null;
    }

    transient private BigDecimal dai1syenyenkijyun07Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENKIJYUN07, nullable=true)
    protected BigDecimal getDai1syenyenkijyun07Value() {
        if (dai1syenyenkijyun07Value == null && dai1syenyenkijyun07 != null) {
            if (dai1syenyenkijyun07.isOptional()) return null;
            return dai1syenyenkijyun07.absolute();
        }
        return dai1syenyenkijyun07Value;
    }

    protected void setDai1syenyenkijyun07Value(BigDecimal value) {
        dai1syenyenkijyun07Value = value;
        dai1syenyenkijyun07 = Optional.fromNullable(toCurrencyType(dai1syenyenkijyun07Type))
            .transform(bizCurrencyTransformer(getDai1syenyenkijyun07Value()))
            .orNull();
    }

    transient private String dai1syenyenkijyun07Type = null;

    @Column(name=DAI1SYENYENKIJYUN07 + "$", nullable=true)
    protected String getDai1syenyenkijyun07Type() {
        if (dai1syenyenkijyun07Type == null && dai1syenyenkijyun07 != null) return dai1syenyenkijyun07.getType().toString();
        if (dai1syenyenkijyun07Type == null && getDai1syenyenkijyun07Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyenkijyun07$' should not be NULL."));
        }
        return dai1syenyenkijyun07Type;
    }

    protected void setDai1syenyenkijyun07Type(String type) {
        dai1syenyenkijyun07Type = type;
        dai1syenyenkijyun07 = Optional.fromNullable(toCurrencyType(dai1syenyenkijyun07Type))
            .transform(bizCurrencyTransformer(getDai1syenyenkijyun07Value()))
            .orNull();
    }

    private BizCurrency dai1syenyenyasu07;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyenyasu07() {
        return dai1syenyenyasu07;
    }

    public void setDai1syenyenyasu07(BizCurrency pDai1syenyenyasu07) {
        dai1syenyenyasu07 = pDai1syenyenyasu07;
        dai1syenyenyasu07Value = null;
        dai1syenyenyasu07Type  = null;
    }

    transient private BigDecimal dai1syenyenyasu07Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENYASU07, nullable=true)
    protected BigDecimal getDai1syenyenyasu07Value() {
        if (dai1syenyenyasu07Value == null && dai1syenyenyasu07 != null) {
            if (dai1syenyenyasu07.isOptional()) return null;
            return dai1syenyenyasu07.absolute();
        }
        return dai1syenyenyasu07Value;
    }

    protected void setDai1syenyenyasu07Value(BigDecimal value) {
        dai1syenyenyasu07Value = value;
        dai1syenyenyasu07 = Optional.fromNullable(toCurrencyType(dai1syenyenyasu07Type))
            .transform(bizCurrencyTransformer(getDai1syenyenyasu07Value()))
            .orNull();
    }

    transient private String dai1syenyenyasu07Type = null;

    @Column(name=DAI1SYENYENYASU07 + "$", nullable=true)
    protected String getDai1syenyenyasu07Type() {
        if (dai1syenyenyasu07Type == null && dai1syenyenyasu07 != null) return dai1syenyenyasu07.getType().toString();
        if (dai1syenyenyasu07Type == null && getDai1syenyenyasu07Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyenyasu07$' should not be NULL."));
        }
        return dai1syenyenyasu07Type;
    }

    protected void setDai1syenyenyasu07Type(String type) {
        dai1syenyenyasu07Type = type;
        dai1syenyenyasu07 = Optional.fromNullable(toCurrencyType(dai1syenyenyasu07Type))
            .transform(bizCurrencyTransformer(getDai1syenyenyasu07Value()))
            .orNull();
    }

    private Integer dai1skeikanensuu08;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SKEIKANENSUU08)
    public Integer getDai1skeikanensuu08() {
        return dai1skeikanensuu08;
    }

    public void setDai1skeikanensuu08(Integer pDai1skeikanensuu08) {
        dai1skeikanensuu08 = pDai1skeikanensuu08;
    }

    private BizDate dai1sibousnenoutouymd08;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1SIBOUSNENOUTOUYMD08)
    public BizDate getDai1sibousnenoutouymd08() {
        return dai1sibousnenoutouymd08;
    }

    public void setDai1sibousnenoutouymd08(BizDate pDai1sibousnenoutouymd08) {
        dai1sibousnenoutouymd08 = pDai1sibousnenoutouymd08;
    }

    private C_Tuukasyu dai1stuuktype08;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1STUUKTYPE08)
    public C_Tuukasyu getDai1stuuktype08() {
        return dai1stuuktype08;
    }

    public void setDai1stuuktype08(C_Tuukasyu pDai1stuuktype08) {
        dai1stuuktype08 = pDai1stuuktype08;
    }

    private BizCurrency dai1s08;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1s08() {
        return dai1s08;
    }

    public void setDai1s08(BizCurrency pDai1s08) {
        dai1s08 = pDai1s08;
        dai1s08Value = null;
        dai1s08Type  = null;
    }

    transient private BigDecimal dai1s08Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1S08, nullable=true)
    protected BigDecimal getDai1s08Value() {
        if (dai1s08Value == null && dai1s08 != null) {
            if (dai1s08.isOptional()) return null;
            return dai1s08.absolute();
        }
        return dai1s08Value;
    }

    protected void setDai1s08Value(BigDecimal value) {
        dai1s08Value = value;
        dai1s08 = Optional.fromNullable(toCurrencyType(dai1s08Type))
            .transform(bizCurrencyTransformer(getDai1s08Value()))
            .orNull();
    }

    transient private String dai1s08Type = null;

    @Column(name=DAI1S08 + "$", nullable=true)
    protected String getDai1s08Type() {
        if (dai1s08Type == null && dai1s08 != null) return dai1s08.getType().toString();
        if (dai1s08Type == null && getDai1s08Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1s08$' should not be NULL."));
        }
        return dai1s08Type;
    }

    protected void setDai1s08Type(String type) {
        dai1s08Type = type;
        dai1s08 = Optional.fromNullable(toCurrencyType(dai1s08Type))
            .transform(bizCurrencyTransformer(getDai1s08Value()))
            .orNull();
    }

    private String dai1syenyendakaumu08;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENDAKAUMU08)
    public String getDai1syenyendakaumu08() {
        return dai1syenyendakaumu08;
    }

    public void setDai1syenyendakaumu08(String pDai1syenyendakaumu08) {
        dai1syenyendakaumu08 = pDai1syenyendakaumu08;
    }

    private String dai1syenyenkijyunumu08;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENKIJYUNUMU08)
    public String getDai1syenyenkijyunumu08() {
        return dai1syenyenkijyunumu08;
    }

    public void setDai1syenyenkijyunumu08(String pDai1syenyenkijyunumu08) {
        dai1syenyenkijyunumu08 = pDai1syenyenkijyunumu08;
    }

    private String dai1syenyenyasuumu08;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENYASUUMU08)
    public String getDai1syenyenyasuumu08() {
        return dai1syenyenyasuumu08;
    }

    public void setDai1syenyenyasuumu08(String pDai1syenyenyasuumu08) {
        dai1syenyenyasuumu08 = pDai1syenyenyasuumu08;
    }

    private C_Tuukasyu dai1syentuuktype08;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENTUUKTYPE08)
    public C_Tuukasyu getDai1syentuuktype08() {
        return dai1syentuuktype08;
    }

    public void setDai1syentuuktype08(C_Tuukasyu pDai1syentuuktype08) {
        dai1syentuuktype08 = pDai1syentuuktype08;
    }

    private BizCurrency dai1syenyendaka08;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyendaka08() {
        return dai1syenyendaka08;
    }

    public void setDai1syenyendaka08(BizCurrency pDai1syenyendaka08) {
        dai1syenyendaka08 = pDai1syenyendaka08;
        dai1syenyendaka08Value = null;
        dai1syenyendaka08Type  = null;
    }

    transient private BigDecimal dai1syenyendaka08Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENDAKA08, nullable=true)
    protected BigDecimal getDai1syenyendaka08Value() {
        if (dai1syenyendaka08Value == null && dai1syenyendaka08 != null) {
            if (dai1syenyendaka08.isOptional()) return null;
            return dai1syenyendaka08.absolute();
        }
        return dai1syenyendaka08Value;
    }

    protected void setDai1syenyendaka08Value(BigDecimal value) {
        dai1syenyendaka08Value = value;
        dai1syenyendaka08 = Optional.fromNullable(toCurrencyType(dai1syenyendaka08Type))
            .transform(bizCurrencyTransformer(getDai1syenyendaka08Value()))
            .orNull();
    }

    transient private String dai1syenyendaka08Type = null;

    @Column(name=DAI1SYENYENDAKA08 + "$", nullable=true)
    protected String getDai1syenyendaka08Type() {
        if (dai1syenyendaka08Type == null && dai1syenyendaka08 != null) return dai1syenyendaka08.getType().toString();
        if (dai1syenyendaka08Type == null && getDai1syenyendaka08Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyendaka08$' should not be NULL."));
        }
        return dai1syenyendaka08Type;
    }

    protected void setDai1syenyendaka08Type(String type) {
        dai1syenyendaka08Type = type;
        dai1syenyendaka08 = Optional.fromNullable(toCurrencyType(dai1syenyendaka08Type))
            .transform(bizCurrencyTransformer(getDai1syenyendaka08Value()))
            .orNull();
    }

    private BizCurrency dai1syenyenkijyun08;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyenkijyun08() {
        return dai1syenyenkijyun08;
    }

    public void setDai1syenyenkijyun08(BizCurrency pDai1syenyenkijyun08) {
        dai1syenyenkijyun08 = pDai1syenyenkijyun08;
        dai1syenyenkijyun08Value = null;
        dai1syenyenkijyun08Type  = null;
    }

    transient private BigDecimal dai1syenyenkijyun08Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENKIJYUN08, nullable=true)
    protected BigDecimal getDai1syenyenkijyun08Value() {
        if (dai1syenyenkijyun08Value == null && dai1syenyenkijyun08 != null) {
            if (dai1syenyenkijyun08.isOptional()) return null;
            return dai1syenyenkijyun08.absolute();
        }
        return dai1syenyenkijyun08Value;
    }

    protected void setDai1syenyenkijyun08Value(BigDecimal value) {
        dai1syenyenkijyun08Value = value;
        dai1syenyenkijyun08 = Optional.fromNullable(toCurrencyType(dai1syenyenkijyun08Type))
            .transform(bizCurrencyTransformer(getDai1syenyenkijyun08Value()))
            .orNull();
    }

    transient private String dai1syenyenkijyun08Type = null;

    @Column(name=DAI1SYENYENKIJYUN08 + "$", nullable=true)
    protected String getDai1syenyenkijyun08Type() {
        if (dai1syenyenkijyun08Type == null && dai1syenyenkijyun08 != null) return dai1syenyenkijyun08.getType().toString();
        if (dai1syenyenkijyun08Type == null && getDai1syenyenkijyun08Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyenkijyun08$' should not be NULL."));
        }
        return dai1syenyenkijyun08Type;
    }

    protected void setDai1syenyenkijyun08Type(String type) {
        dai1syenyenkijyun08Type = type;
        dai1syenyenkijyun08 = Optional.fromNullable(toCurrencyType(dai1syenyenkijyun08Type))
            .transform(bizCurrencyTransformer(getDai1syenyenkijyun08Value()))
            .orNull();
    }

    private BizCurrency dai1syenyenyasu08;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyenyasu08() {
        return dai1syenyenyasu08;
    }

    public void setDai1syenyenyasu08(BizCurrency pDai1syenyenyasu08) {
        dai1syenyenyasu08 = pDai1syenyenyasu08;
        dai1syenyenyasu08Value = null;
        dai1syenyenyasu08Type  = null;
    }

    transient private BigDecimal dai1syenyenyasu08Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENYASU08, nullable=true)
    protected BigDecimal getDai1syenyenyasu08Value() {
        if (dai1syenyenyasu08Value == null && dai1syenyenyasu08 != null) {
            if (dai1syenyenyasu08.isOptional()) return null;
            return dai1syenyenyasu08.absolute();
        }
        return dai1syenyenyasu08Value;
    }

    protected void setDai1syenyenyasu08Value(BigDecimal value) {
        dai1syenyenyasu08Value = value;
        dai1syenyenyasu08 = Optional.fromNullable(toCurrencyType(dai1syenyenyasu08Type))
            .transform(bizCurrencyTransformer(getDai1syenyenyasu08Value()))
            .orNull();
    }

    transient private String dai1syenyenyasu08Type = null;

    @Column(name=DAI1SYENYENYASU08 + "$", nullable=true)
    protected String getDai1syenyenyasu08Type() {
        if (dai1syenyenyasu08Type == null && dai1syenyenyasu08 != null) return dai1syenyenyasu08.getType().toString();
        if (dai1syenyenyasu08Type == null && getDai1syenyenyasu08Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyenyasu08$' should not be NULL."));
        }
        return dai1syenyenyasu08Type;
    }

    protected void setDai1syenyenyasu08Type(String type) {
        dai1syenyenyasu08Type = type;
        dai1syenyenyasu08 = Optional.fromNullable(toCurrencyType(dai1syenyenyasu08Type))
            .transform(bizCurrencyTransformer(getDai1syenyenyasu08Value()))
            .orNull();
    }

    private Integer dai1skeikanensuu09;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SKEIKANENSUU09)
    public Integer getDai1skeikanensuu09() {
        return dai1skeikanensuu09;
    }

    public void setDai1skeikanensuu09(Integer pDai1skeikanensuu09) {
        dai1skeikanensuu09 = pDai1skeikanensuu09;
    }

    private BizDate dai1sibousnenoutouymd09;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1SIBOUSNENOUTOUYMD09)
    public BizDate getDai1sibousnenoutouymd09() {
        return dai1sibousnenoutouymd09;
    }

    public void setDai1sibousnenoutouymd09(BizDate pDai1sibousnenoutouymd09) {
        dai1sibousnenoutouymd09 = pDai1sibousnenoutouymd09;
    }

    private C_Tuukasyu dai1stuuktype09;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1STUUKTYPE09)
    public C_Tuukasyu getDai1stuuktype09() {
        return dai1stuuktype09;
    }

    public void setDai1stuuktype09(C_Tuukasyu pDai1stuuktype09) {
        dai1stuuktype09 = pDai1stuuktype09;
    }

    private BizCurrency dai1s09;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1s09() {
        return dai1s09;
    }

    public void setDai1s09(BizCurrency pDai1s09) {
        dai1s09 = pDai1s09;
        dai1s09Value = null;
        dai1s09Type  = null;
    }

    transient private BigDecimal dai1s09Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1S09, nullable=true)
    protected BigDecimal getDai1s09Value() {
        if (dai1s09Value == null && dai1s09 != null) {
            if (dai1s09.isOptional()) return null;
            return dai1s09.absolute();
        }
        return dai1s09Value;
    }

    protected void setDai1s09Value(BigDecimal value) {
        dai1s09Value = value;
        dai1s09 = Optional.fromNullable(toCurrencyType(dai1s09Type))
            .transform(bizCurrencyTransformer(getDai1s09Value()))
            .orNull();
    }

    transient private String dai1s09Type = null;

    @Column(name=DAI1S09 + "$", nullable=true)
    protected String getDai1s09Type() {
        if (dai1s09Type == null && dai1s09 != null) return dai1s09.getType().toString();
        if (dai1s09Type == null && getDai1s09Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1s09$' should not be NULL."));
        }
        return dai1s09Type;
    }

    protected void setDai1s09Type(String type) {
        dai1s09Type = type;
        dai1s09 = Optional.fromNullable(toCurrencyType(dai1s09Type))
            .transform(bizCurrencyTransformer(getDai1s09Value()))
            .orNull();
    }

    private String dai1syenyendakaumu09;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENDAKAUMU09)
    public String getDai1syenyendakaumu09() {
        return dai1syenyendakaumu09;
    }

    public void setDai1syenyendakaumu09(String pDai1syenyendakaumu09) {
        dai1syenyendakaumu09 = pDai1syenyendakaumu09;
    }

    private String dai1syenyenkijyunumu09;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENKIJYUNUMU09)
    public String getDai1syenyenkijyunumu09() {
        return dai1syenyenkijyunumu09;
    }

    public void setDai1syenyenkijyunumu09(String pDai1syenyenkijyunumu09) {
        dai1syenyenkijyunumu09 = pDai1syenyenkijyunumu09;
    }

    private String dai1syenyenyasuumu09;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENYASUUMU09)
    public String getDai1syenyenyasuumu09() {
        return dai1syenyenyasuumu09;
    }

    public void setDai1syenyenyasuumu09(String pDai1syenyenyasuumu09) {
        dai1syenyenyasuumu09 = pDai1syenyenyasuumu09;
    }

    private C_Tuukasyu dai1syentuuktype09;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENTUUKTYPE09)
    public C_Tuukasyu getDai1syentuuktype09() {
        return dai1syentuuktype09;
    }

    public void setDai1syentuuktype09(C_Tuukasyu pDai1syentuuktype09) {
        dai1syentuuktype09 = pDai1syentuuktype09;
    }

    private BizCurrency dai1syenyendaka09;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyendaka09() {
        return dai1syenyendaka09;
    }

    public void setDai1syenyendaka09(BizCurrency pDai1syenyendaka09) {
        dai1syenyendaka09 = pDai1syenyendaka09;
        dai1syenyendaka09Value = null;
        dai1syenyendaka09Type  = null;
    }

    transient private BigDecimal dai1syenyendaka09Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENDAKA09, nullable=true)
    protected BigDecimal getDai1syenyendaka09Value() {
        if (dai1syenyendaka09Value == null && dai1syenyendaka09 != null) {
            if (dai1syenyendaka09.isOptional()) return null;
            return dai1syenyendaka09.absolute();
        }
        return dai1syenyendaka09Value;
    }

    protected void setDai1syenyendaka09Value(BigDecimal value) {
        dai1syenyendaka09Value = value;
        dai1syenyendaka09 = Optional.fromNullable(toCurrencyType(dai1syenyendaka09Type))
            .transform(bizCurrencyTransformer(getDai1syenyendaka09Value()))
            .orNull();
    }

    transient private String dai1syenyendaka09Type = null;

    @Column(name=DAI1SYENYENDAKA09 + "$", nullable=true)
    protected String getDai1syenyendaka09Type() {
        if (dai1syenyendaka09Type == null && dai1syenyendaka09 != null) return dai1syenyendaka09.getType().toString();
        if (dai1syenyendaka09Type == null && getDai1syenyendaka09Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyendaka09$' should not be NULL."));
        }
        return dai1syenyendaka09Type;
    }

    protected void setDai1syenyendaka09Type(String type) {
        dai1syenyendaka09Type = type;
        dai1syenyendaka09 = Optional.fromNullable(toCurrencyType(dai1syenyendaka09Type))
            .transform(bizCurrencyTransformer(getDai1syenyendaka09Value()))
            .orNull();
    }

    private BizCurrency dai1syenyenkijyun09;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyenkijyun09() {
        return dai1syenyenkijyun09;
    }

    public void setDai1syenyenkijyun09(BizCurrency pDai1syenyenkijyun09) {
        dai1syenyenkijyun09 = pDai1syenyenkijyun09;
        dai1syenyenkijyun09Value = null;
        dai1syenyenkijyun09Type  = null;
    }

    transient private BigDecimal dai1syenyenkijyun09Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENKIJYUN09, nullable=true)
    protected BigDecimal getDai1syenyenkijyun09Value() {
        if (dai1syenyenkijyun09Value == null && dai1syenyenkijyun09 != null) {
            if (dai1syenyenkijyun09.isOptional()) return null;
            return dai1syenyenkijyun09.absolute();
        }
        return dai1syenyenkijyun09Value;
    }

    protected void setDai1syenyenkijyun09Value(BigDecimal value) {
        dai1syenyenkijyun09Value = value;
        dai1syenyenkijyun09 = Optional.fromNullable(toCurrencyType(dai1syenyenkijyun09Type))
            .transform(bizCurrencyTransformer(getDai1syenyenkijyun09Value()))
            .orNull();
    }

    transient private String dai1syenyenkijyun09Type = null;

    @Column(name=DAI1SYENYENKIJYUN09 + "$", nullable=true)
    protected String getDai1syenyenkijyun09Type() {
        if (dai1syenyenkijyun09Type == null && dai1syenyenkijyun09 != null) return dai1syenyenkijyun09.getType().toString();
        if (dai1syenyenkijyun09Type == null && getDai1syenyenkijyun09Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyenkijyun09$' should not be NULL."));
        }
        return dai1syenyenkijyun09Type;
    }

    protected void setDai1syenyenkijyun09Type(String type) {
        dai1syenyenkijyun09Type = type;
        dai1syenyenkijyun09 = Optional.fromNullable(toCurrencyType(dai1syenyenkijyun09Type))
            .transform(bizCurrencyTransformer(getDai1syenyenkijyun09Value()))
            .orNull();
    }

    private BizCurrency dai1syenyenyasu09;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyenyasu09() {
        return dai1syenyenyasu09;
    }

    public void setDai1syenyenyasu09(BizCurrency pDai1syenyenyasu09) {
        dai1syenyenyasu09 = pDai1syenyenyasu09;
        dai1syenyenyasu09Value = null;
        dai1syenyenyasu09Type  = null;
    }

    transient private BigDecimal dai1syenyenyasu09Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENYASU09, nullable=true)
    protected BigDecimal getDai1syenyenyasu09Value() {
        if (dai1syenyenyasu09Value == null && dai1syenyenyasu09 != null) {
            if (dai1syenyenyasu09.isOptional()) return null;
            return dai1syenyenyasu09.absolute();
        }
        return dai1syenyenyasu09Value;
    }

    protected void setDai1syenyenyasu09Value(BigDecimal value) {
        dai1syenyenyasu09Value = value;
        dai1syenyenyasu09 = Optional.fromNullable(toCurrencyType(dai1syenyenyasu09Type))
            .transform(bizCurrencyTransformer(getDai1syenyenyasu09Value()))
            .orNull();
    }

    transient private String dai1syenyenyasu09Type = null;

    @Column(name=DAI1SYENYENYASU09 + "$", nullable=true)
    protected String getDai1syenyenyasu09Type() {
        if (dai1syenyenyasu09Type == null && dai1syenyenyasu09 != null) return dai1syenyenyasu09.getType().toString();
        if (dai1syenyenyasu09Type == null && getDai1syenyenyasu09Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyenyasu09$' should not be NULL."));
        }
        return dai1syenyenyasu09Type;
    }

    protected void setDai1syenyenyasu09Type(String type) {
        dai1syenyenyasu09Type = type;
        dai1syenyenyasu09 = Optional.fromNullable(toCurrencyType(dai1syenyenyasu09Type))
            .transform(bizCurrencyTransformer(getDai1syenyenyasu09Value()))
            .orNull();
    }

    private Integer dai1skeikanensuu10;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SKEIKANENSUU10)
    public Integer getDai1skeikanensuu10() {
        return dai1skeikanensuu10;
    }

    public void setDai1skeikanensuu10(Integer pDai1skeikanensuu10) {
        dai1skeikanensuu10 = pDai1skeikanensuu10;
    }

    private BizDate dai1sibousnenoutouymd10;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1SIBOUSNENOUTOUYMD10)
    public BizDate getDai1sibousnenoutouymd10() {
        return dai1sibousnenoutouymd10;
    }

    public void setDai1sibousnenoutouymd10(BizDate pDai1sibousnenoutouymd10) {
        dai1sibousnenoutouymd10 = pDai1sibousnenoutouymd10;
    }

    private C_Tuukasyu dai1stuuktype10;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1STUUKTYPE10)
    public C_Tuukasyu getDai1stuuktype10() {
        return dai1stuuktype10;
    }

    public void setDai1stuuktype10(C_Tuukasyu pDai1stuuktype10) {
        dai1stuuktype10 = pDai1stuuktype10;
    }

    private BizCurrency dai1s10;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1s10() {
        return dai1s10;
    }

    public void setDai1s10(BizCurrency pDai1s10) {
        dai1s10 = pDai1s10;
        dai1s10Value = null;
        dai1s10Type  = null;
    }

    transient private BigDecimal dai1s10Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1S10, nullable=true)
    protected BigDecimal getDai1s10Value() {
        if (dai1s10Value == null && dai1s10 != null) {
            if (dai1s10.isOptional()) return null;
            return dai1s10.absolute();
        }
        return dai1s10Value;
    }

    protected void setDai1s10Value(BigDecimal value) {
        dai1s10Value = value;
        dai1s10 = Optional.fromNullable(toCurrencyType(dai1s10Type))
            .transform(bizCurrencyTransformer(getDai1s10Value()))
            .orNull();
    }

    transient private String dai1s10Type = null;

    @Column(name=DAI1S10 + "$", nullable=true)
    protected String getDai1s10Type() {
        if (dai1s10Type == null && dai1s10 != null) return dai1s10.getType().toString();
        if (dai1s10Type == null && getDai1s10Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1s10$' should not be NULL."));
        }
        return dai1s10Type;
    }

    protected void setDai1s10Type(String type) {
        dai1s10Type = type;
        dai1s10 = Optional.fromNullable(toCurrencyType(dai1s10Type))
            .transform(bizCurrencyTransformer(getDai1s10Value()))
            .orNull();
    }

    private String dai1syenyendakaumu10;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENDAKAUMU10)
    public String getDai1syenyendakaumu10() {
        return dai1syenyendakaumu10;
    }

    public void setDai1syenyendakaumu10(String pDai1syenyendakaumu10) {
        dai1syenyendakaumu10 = pDai1syenyendakaumu10;
    }

    private String dai1syenyenkijyunumu10;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENKIJYUNUMU10)
    public String getDai1syenyenkijyunumu10() {
        return dai1syenyenkijyunumu10;
    }

    public void setDai1syenyenkijyunumu10(String pDai1syenyenkijyunumu10) {
        dai1syenyenkijyunumu10 = pDai1syenyenkijyunumu10;
    }

    private String dai1syenyenyasuumu10;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENYASUUMU10)
    public String getDai1syenyenyasuumu10() {
        return dai1syenyenyasuumu10;
    }

    public void setDai1syenyenyasuumu10(String pDai1syenyenyasuumu10) {
        dai1syenyenyasuumu10 = pDai1syenyenyasuumu10;
    }

    private C_Tuukasyu dai1syentuuktype10;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENTUUKTYPE10)
    public C_Tuukasyu getDai1syentuuktype10() {
        return dai1syentuuktype10;
    }

    public void setDai1syentuuktype10(C_Tuukasyu pDai1syentuuktype10) {
        dai1syentuuktype10 = pDai1syentuuktype10;
    }

    private BizCurrency dai1syenyendaka10;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyendaka10() {
        return dai1syenyendaka10;
    }

    public void setDai1syenyendaka10(BizCurrency pDai1syenyendaka10) {
        dai1syenyendaka10 = pDai1syenyendaka10;
        dai1syenyendaka10Value = null;
        dai1syenyendaka10Type  = null;
    }

    transient private BigDecimal dai1syenyendaka10Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENDAKA10, nullable=true)
    protected BigDecimal getDai1syenyendaka10Value() {
        if (dai1syenyendaka10Value == null && dai1syenyendaka10 != null) {
            if (dai1syenyendaka10.isOptional()) return null;
            return dai1syenyendaka10.absolute();
        }
        return dai1syenyendaka10Value;
    }

    protected void setDai1syenyendaka10Value(BigDecimal value) {
        dai1syenyendaka10Value = value;
        dai1syenyendaka10 = Optional.fromNullable(toCurrencyType(dai1syenyendaka10Type))
            .transform(bizCurrencyTransformer(getDai1syenyendaka10Value()))
            .orNull();
    }

    transient private String dai1syenyendaka10Type = null;

    @Column(name=DAI1SYENYENDAKA10 + "$", nullable=true)
    protected String getDai1syenyendaka10Type() {
        if (dai1syenyendaka10Type == null && dai1syenyendaka10 != null) return dai1syenyendaka10.getType().toString();
        if (dai1syenyendaka10Type == null && getDai1syenyendaka10Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyendaka10$' should not be NULL."));
        }
        return dai1syenyendaka10Type;
    }

    protected void setDai1syenyendaka10Type(String type) {
        dai1syenyendaka10Type = type;
        dai1syenyendaka10 = Optional.fromNullable(toCurrencyType(dai1syenyendaka10Type))
            .transform(bizCurrencyTransformer(getDai1syenyendaka10Value()))
            .orNull();
    }

    private BizCurrency dai1syenyenkijyun10;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyenkijyun10() {
        return dai1syenyenkijyun10;
    }

    public void setDai1syenyenkijyun10(BizCurrency pDai1syenyenkijyun10) {
        dai1syenyenkijyun10 = pDai1syenyenkijyun10;
        dai1syenyenkijyun10Value = null;
        dai1syenyenkijyun10Type  = null;
    }

    transient private BigDecimal dai1syenyenkijyun10Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENKIJYUN10, nullable=true)
    protected BigDecimal getDai1syenyenkijyun10Value() {
        if (dai1syenyenkijyun10Value == null && dai1syenyenkijyun10 != null) {
            if (dai1syenyenkijyun10.isOptional()) return null;
            return dai1syenyenkijyun10.absolute();
        }
        return dai1syenyenkijyun10Value;
    }

    protected void setDai1syenyenkijyun10Value(BigDecimal value) {
        dai1syenyenkijyun10Value = value;
        dai1syenyenkijyun10 = Optional.fromNullable(toCurrencyType(dai1syenyenkijyun10Type))
            .transform(bizCurrencyTransformer(getDai1syenyenkijyun10Value()))
            .orNull();
    }

    transient private String dai1syenyenkijyun10Type = null;

    @Column(name=DAI1SYENYENKIJYUN10 + "$", nullable=true)
    protected String getDai1syenyenkijyun10Type() {
        if (dai1syenyenkijyun10Type == null && dai1syenyenkijyun10 != null) return dai1syenyenkijyun10.getType().toString();
        if (dai1syenyenkijyun10Type == null && getDai1syenyenkijyun10Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyenkijyun10$' should not be NULL."));
        }
        return dai1syenyenkijyun10Type;
    }

    protected void setDai1syenyenkijyun10Type(String type) {
        dai1syenyenkijyun10Type = type;
        dai1syenyenkijyun10 = Optional.fromNullable(toCurrencyType(dai1syenyenkijyun10Type))
            .transform(bizCurrencyTransformer(getDai1syenyenkijyun10Value()))
            .orNull();
    }

    private BizCurrency dai1syenyenyasu10;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyenyasu10() {
        return dai1syenyenyasu10;
    }

    public void setDai1syenyenyasu10(BizCurrency pDai1syenyenyasu10) {
        dai1syenyenyasu10 = pDai1syenyenyasu10;
        dai1syenyenyasu10Value = null;
        dai1syenyenyasu10Type  = null;
    }

    transient private BigDecimal dai1syenyenyasu10Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENYASU10, nullable=true)
    protected BigDecimal getDai1syenyenyasu10Value() {
        if (dai1syenyenyasu10Value == null && dai1syenyenyasu10 != null) {
            if (dai1syenyenyasu10.isOptional()) return null;
            return dai1syenyenyasu10.absolute();
        }
        return dai1syenyenyasu10Value;
    }

    protected void setDai1syenyenyasu10Value(BigDecimal value) {
        dai1syenyenyasu10Value = value;
        dai1syenyenyasu10 = Optional.fromNullable(toCurrencyType(dai1syenyenyasu10Type))
            .transform(bizCurrencyTransformer(getDai1syenyenyasu10Value()))
            .orNull();
    }

    transient private String dai1syenyenyasu10Type = null;

    @Column(name=DAI1SYENYENYASU10 + "$", nullable=true)
    protected String getDai1syenyenyasu10Type() {
        if (dai1syenyenyasu10Type == null && dai1syenyenyasu10 != null) return dai1syenyenyasu10.getType().toString();
        if (dai1syenyenyasu10Type == null && getDai1syenyenyasu10Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyenyasu10$' should not be NULL."));
        }
        return dai1syenyenyasu10Type;
    }

    protected void setDai1syenyenyasu10Type(String type) {
        dai1syenyenyasu10Type = type;
        dai1syenyenyasu10 = Optional.fromNullable(toCurrencyType(dai1syenyenyasu10Type))
            .transform(bizCurrencyTransformer(getDai1syenyenyasu10Value()))
            .orNull();
    }

    private C_Tuukasyu dai1stuuktypehuryo;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1STUUKTYPEHURYO)
    public C_Tuukasyu getDai1stuuktypehuryo() {
        return dai1stuuktypehuryo;
    }

    public void setDai1stuuktypehuryo(C_Tuukasyu pDai1stuuktypehuryo) {
        dai1stuuktypehuryo = pDai1stuuktypehuryo;
    }

    private BizCurrency dai1shuryo;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1shuryo() {
        return dai1shuryo;
    }

    public void setDai1shuryo(BizCurrency pDai1shuryo) {
        dai1shuryo = pDai1shuryo;
        dai1shuryoValue = null;
        dai1shuryoType  = null;
    }

    transient private BigDecimal dai1shuryoValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SHURYO, nullable=true)
    protected BigDecimal getDai1shuryoValue() {
        if (dai1shuryoValue == null && dai1shuryo != null) {
            if (dai1shuryo.isOptional()) return null;
            return dai1shuryo.absolute();
        }
        return dai1shuryoValue;
    }

    protected void setDai1shuryoValue(BigDecimal value) {
        dai1shuryoValue = value;
        dai1shuryo = Optional.fromNullable(toCurrencyType(dai1shuryoType))
            .transform(bizCurrencyTransformer(getDai1shuryoValue()))
            .orNull();
    }

    transient private String dai1shuryoType = null;

    @Column(name=DAI1SHURYO + "$", nullable=true)
    protected String getDai1shuryoType() {
        if (dai1shuryoType == null && dai1shuryo != null) return dai1shuryo.getType().toString();
        if (dai1shuryoType == null && getDai1shuryoValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1shuryo$' should not be NULL."));
        }
        return dai1shuryoType;
    }

    protected void setDai1shuryoType(String type) {
        dai1shuryoType = type;
        dai1shuryo = Optional.fromNullable(toCurrencyType(dai1shuryoType))
            .transform(bizCurrencyTransformer(getDai1shuryoValue()))
            .orNull();
    }

    private String dai1syenyendakaumuhuryo;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENDAKAUMUHURYO)
    public String getDai1syenyendakaumuhuryo() {
        return dai1syenyendakaumuhuryo;
    }

    public void setDai1syenyendakaumuhuryo(String pDai1syenyendakaumuhuryo) {
        dai1syenyendakaumuhuryo = pDai1syenyendakaumuhuryo;
    }

    private String dai1syenyenkjnumuhuryo;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENKJNUMUHURYO)
    public String getDai1syenyenkjnumuhuryo() {
        return dai1syenyenkjnumuhuryo;
    }

    public void setDai1syenyenkjnumuhuryo(String pDai1syenyenkjnumuhuryo) {
        dai1syenyenkjnumuhuryo = pDai1syenyenkjnumuhuryo;
    }

    private String dai1syenyenyasuumuhuryo;

    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENYENYASUUMUHURYO)
    public String getDai1syenyenyasuumuhuryo() {
        return dai1syenyenyasuumuhuryo;
    }

    public void setDai1syenyenyasuumuhuryo(String pDai1syenyenyasuumuhuryo) {
        dai1syenyenyasuumuhuryo = pDai1syenyenyasuumuhuryo;
    }

    private C_Tuukasyu dai1syentuuktypehuryo;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.DAI1SYENTUUKTYPEHURYO)
    public C_Tuukasyu getDai1syentuuktypehuryo() {
        return dai1syentuuktypehuryo;
    }

    public void setDai1syentuuktypehuryo(C_Tuukasyu pDai1syentuuktypehuryo) {
        dai1syentuuktypehuryo = pDai1syentuuktypehuryo;
    }

    private BizCurrency dai1syenyendakahuryo;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyendakahuryo() {
        return dai1syenyendakahuryo;
    }

    public void setDai1syenyendakahuryo(BizCurrency pDai1syenyendakahuryo) {
        dai1syenyendakahuryo = pDai1syenyendakahuryo;
        dai1syenyendakahuryoValue = null;
        dai1syenyendakahuryoType  = null;
    }

    transient private BigDecimal dai1syenyendakahuryoValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENDAKAHURYO, nullable=true)
    protected BigDecimal getDai1syenyendakahuryoValue() {
        if (dai1syenyendakahuryoValue == null && dai1syenyendakahuryo != null) {
            if (dai1syenyendakahuryo.isOptional()) return null;
            return dai1syenyendakahuryo.absolute();
        }
        return dai1syenyendakahuryoValue;
    }

    protected void setDai1syenyendakahuryoValue(BigDecimal value) {
        dai1syenyendakahuryoValue = value;
        dai1syenyendakahuryo = Optional.fromNullable(toCurrencyType(dai1syenyendakahuryoType))
            .transform(bizCurrencyTransformer(getDai1syenyendakahuryoValue()))
            .orNull();
    }

    transient private String dai1syenyendakahuryoType = null;

    @Column(name=DAI1SYENYENDAKAHURYO + "$", nullable=true)
    protected String getDai1syenyendakahuryoType() {
        if (dai1syenyendakahuryoType == null && dai1syenyendakahuryo != null) return dai1syenyendakahuryo.getType().toString();
        if (dai1syenyendakahuryoType == null && getDai1syenyendakahuryoValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyendakahuryo$' should not be NULL."));
        }
        return dai1syenyendakahuryoType;
    }

    protected void setDai1syenyendakahuryoType(String type) {
        dai1syenyendakahuryoType = type;
        dai1syenyendakahuryo = Optional.fromNullable(toCurrencyType(dai1syenyendakahuryoType))
            .transform(bizCurrencyTransformer(getDai1syenyendakahuryoValue()))
            .orNull();
    }

    private BizCurrency dai1syenyenkijyunhuryo;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyenkijyunhuryo() {
        return dai1syenyenkijyunhuryo;
    }

    public void setDai1syenyenkijyunhuryo(BizCurrency pDai1syenyenkijyunhuryo) {
        dai1syenyenkijyunhuryo = pDai1syenyenkijyunhuryo;
        dai1syenyenkijyunhuryoValue = null;
        dai1syenyenkijyunhuryoType  = null;
    }

    transient private BigDecimal dai1syenyenkijyunhuryoValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENKIJYUNHURYO, nullable=true)
    protected BigDecimal getDai1syenyenkijyunhuryoValue() {
        if (dai1syenyenkijyunhuryoValue == null && dai1syenyenkijyunhuryo != null) {
            if (dai1syenyenkijyunhuryo.isOptional()) return null;
            return dai1syenyenkijyunhuryo.absolute();
        }
        return dai1syenyenkijyunhuryoValue;
    }

    protected void setDai1syenyenkijyunhuryoValue(BigDecimal value) {
        dai1syenyenkijyunhuryoValue = value;
        dai1syenyenkijyunhuryo = Optional.fromNullable(toCurrencyType(dai1syenyenkijyunhuryoType))
            .transform(bizCurrencyTransformer(getDai1syenyenkijyunhuryoValue()))
            .orNull();
    }

    transient private String dai1syenyenkijyunhuryoType = null;

    @Column(name=DAI1SYENYENKIJYUNHURYO + "$", nullable=true)
    protected String getDai1syenyenkijyunhuryoType() {
        if (dai1syenyenkijyunhuryoType == null && dai1syenyenkijyunhuryo != null) return dai1syenyenkijyunhuryo.getType().toString();
        if (dai1syenyenkijyunhuryoType == null && getDai1syenyenkijyunhuryoValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyenkijyunhuryo$' should not be NULL."));
        }
        return dai1syenyenkijyunhuryoType;
    }

    protected void setDai1syenyenkijyunhuryoType(String type) {
        dai1syenyenkijyunhuryoType = type;
        dai1syenyenkijyunhuryo = Optional.fromNullable(toCurrencyType(dai1syenyenkijyunhuryoType))
            .transform(bizCurrencyTransformer(getDai1syenyenkijyunhuryoValue()))
            .orNull();
    }

    private BizCurrency dai1syenyenyasuhuryo;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1syenyenyasuhuryo() {
        return dai1syenyenyasuhuryo;
    }

    public void setDai1syenyenyasuhuryo(BizCurrency pDai1syenyenyasuhuryo) {
        dai1syenyenyasuhuryo = pDai1syenyenyasuhuryo;
        dai1syenyenyasuhuryoValue = null;
        dai1syenyenyasuhuryoType  = null;
    }

    transient private BigDecimal dai1syenyenyasuhuryoValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SYENYENYASUHURYO, nullable=true)
    protected BigDecimal getDai1syenyenyasuhuryoValue() {
        if (dai1syenyenyasuhuryoValue == null && dai1syenyenyasuhuryo != null) {
            if (dai1syenyenyasuhuryo.isOptional()) return null;
            return dai1syenyenyasuhuryo.absolute();
        }
        return dai1syenyenyasuhuryoValue;
    }

    protected void setDai1syenyenyasuhuryoValue(BigDecimal value) {
        dai1syenyenyasuhuryoValue = value;
        dai1syenyenyasuhuryo = Optional.fromNullable(toCurrencyType(dai1syenyenyasuhuryoType))
            .transform(bizCurrencyTransformer(getDai1syenyenyasuhuryoValue()))
            .orNull();
    }

    transient private String dai1syenyenyasuhuryoType = null;

    @Column(name=DAI1SYENYENYASUHURYO + "$", nullable=true)
    protected String getDai1syenyenyasuhuryoType() {
        if (dai1syenyenyasuhuryoType == null && dai1syenyenyasuhuryo != null) return dai1syenyenyasuhuryo.getType().toString();
        if (dai1syenyenyasuhuryoType == null && getDai1syenyenyasuhuryoValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1syenyenyasuhuryo$' should not be NULL."));
        }
        return dai1syenyenyasuhuryoType;
    }

    protected void setDai1syenyenyasuhuryoType(String type) {
        dai1syenyenyasuhuryoType = type;
        dai1syenyenyasuhuryo = Optional.fromNullable(toCurrencyType(dai1syenyenyasuhuryoType))
            .transform(bizCurrencyTransformer(getDai1syenyenyasuhuryoValue()))
            .orNull();
    }

    private BizCurrency initsbjiyenkasaiteihsygk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getInitsbjiyenkasaiteihsygk() {
        return initsbjiyenkasaiteihsygk;
    }

    public void setInitsbjiyenkasaiteihsygk(BizCurrency pInitsbjiyenkasaiteihsygk) {
        initsbjiyenkasaiteihsygk = pInitsbjiyenkasaiteihsygk;
        initsbjiyenkasaiteihsygkValue = null;
        initsbjiyenkasaiteihsygkType  = null;
    }

    transient private BigDecimal initsbjiyenkasaiteihsygkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=INITSBJIYENKASAITEIHSYGK, nullable=true)
    protected BigDecimal getInitsbjiyenkasaiteihsygkValue() {
        if (initsbjiyenkasaiteihsygkValue == null && initsbjiyenkasaiteihsygk != null) {
            if (initsbjiyenkasaiteihsygk.isOptional()) return null;
            return initsbjiyenkasaiteihsygk.absolute();
        }
        return initsbjiyenkasaiteihsygkValue;
    }

    protected void setInitsbjiyenkasaiteihsygkValue(BigDecimal value) {
        initsbjiyenkasaiteihsygkValue = value;
        initsbjiyenkasaiteihsygk = Optional.fromNullable(toCurrencyType(initsbjiyenkasaiteihsygkType))
            .transform(bizCurrencyTransformer(getInitsbjiyenkasaiteihsygkValue()))
            .orNull();
    }

    transient private String initsbjiyenkasaiteihsygkType = null;

    @Column(name=INITSBJIYENKASAITEIHSYGK + "$", nullable=true)
    protected String getInitsbjiyenkasaiteihsygkType() {
        if (initsbjiyenkasaiteihsygkType == null && initsbjiyenkasaiteihsygk != null) return initsbjiyenkasaiteihsygk.getType().toString();
        if (initsbjiyenkasaiteihsygkType == null && getInitsbjiyenkasaiteihsygkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'initsbjiyenkasaiteihsygk$' should not be NULL."));
        }
        return initsbjiyenkasaiteihsygkType;
    }

    protected void setInitsbjiyenkasaiteihsygkType(String type) {
        initsbjiyenkasaiteihsygkType = type;
        initsbjiyenkasaiteihsygk = Optional.fromNullable(toCurrencyType(initsbjiyenkasaiteihsygkType))
            .transform(bizCurrencyTransformer(getInitsbjiyenkasaiteihsygkValue()))
            .orNull();
    }

    private C_Tuukasyu dai2stuuktype;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.DAI2STUUKTYPE)
    public C_Tuukasyu getDai2stuuktype() {
        return dai2stuuktype;
    }

    public void setDai2stuuktype(C_Tuukasyu pDai2stuuktype) {
        dai2stuuktype = pDai2stuuktype;
    }

    private BizCurrency dai2s;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai2s() {
        return dai2s;
    }

    public void setDai2s(BizCurrency pDai2s) {
        dai2s = pDai2s;
        dai2sValue = null;
        dai2sType  = null;
    }

    transient private BigDecimal dai2sValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI2S, nullable=true)
    protected BigDecimal getDai2sValue() {
        if (dai2sValue == null && dai2s != null) {
            if (dai2s.isOptional()) return null;
            return dai2s.absolute();
        }
        return dai2sValue;
    }

    protected void setDai2sValue(BigDecimal value) {
        dai2sValue = value;
        dai2s = Optional.fromNullable(toCurrencyType(dai2sType))
            .transform(bizCurrencyTransformer(getDai2sValue()))
            .orNull();
    }

    transient private String dai2sType = null;

    @Column(name=DAI2S + "$", nullable=true)
    protected String getDai2sType() {
        if (dai2sType == null && dai2s != null) return dai2s.getType().toString();
        if (dai2sType == null && getDai2sValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai2s$' should not be NULL."));
        }
        return dai2sType;
    }

    protected void setDai2sType(String type) {
        dai2sType = type;
        dai2s = Optional.fromNullable(toCurrencyType(dai2sType))
            .transform(bizCurrencyTransformer(getDai2sValue()))
            .orNull();
    }

    private C_Tuukasyu dai2syentuuktype;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.DAI2SYENTUUKTYPE)
    public C_Tuukasyu getDai2syentuuktype() {
        return dai2syentuuktype;
    }

    public void setDai2syentuuktype(C_Tuukasyu pDai2syentuuktype) {
        dai2syentuuktype = pDai2syentuuktype;
    }

    private BizCurrency dai2syenyendaka;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai2syenyendaka() {
        return dai2syenyendaka;
    }

    public void setDai2syenyendaka(BizCurrency pDai2syenyendaka) {
        dai2syenyendaka = pDai2syenyendaka;
        dai2syenyendakaValue = null;
        dai2syenyendakaType  = null;
    }

    transient private BigDecimal dai2syenyendakaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI2SYENYENDAKA, nullable=true)
    protected BigDecimal getDai2syenyendakaValue() {
        if (dai2syenyendakaValue == null && dai2syenyendaka != null) {
            if (dai2syenyendaka.isOptional()) return null;
            return dai2syenyendaka.absolute();
        }
        return dai2syenyendakaValue;
    }

    protected void setDai2syenyendakaValue(BigDecimal value) {
        dai2syenyendakaValue = value;
        dai2syenyendaka = Optional.fromNullable(toCurrencyType(dai2syenyendakaType))
            .transform(bizCurrencyTransformer(getDai2syenyendakaValue()))
            .orNull();
    }

    transient private String dai2syenyendakaType = null;

    @Column(name=DAI2SYENYENDAKA + "$", nullable=true)
    protected String getDai2syenyendakaType() {
        if (dai2syenyendakaType == null && dai2syenyendaka != null) return dai2syenyendaka.getType().toString();
        if (dai2syenyendakaType == null && getDai2syenyendakaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai2syenyendaka$' should not be NULL."));
        }
        return dai2syenyendakaType;
    }

    protected void setDai2syenyendakaType(String type) {
        dai2syenyendakaType = type;
        dai2syenyendaka = Optional.fromNullable(toCurrencyType(dai2syenyendakaType))
            .transform(bizCurrencyTransformer(getDai2syenyendakaValue()))
            .orNull();
    }

    private BizCurrency dai2syenyenkijyun;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai2syenyenkijyun() {
        return dai2syenyenkijyun;
    }

    public void setDai2syenyenkijyun(BizCurrency pDai2syenyenkijyun) {
        dai2syenyenkijyun = pDai2syenyenkijyun;
        dai2syenyenkijyunValue = null;
        dai2syenyenkijyunType  = null;
    }

    transient private BigDecimal dai2syenyenkijyunValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI2SYENYENKIJYUN, nullable=true)
    protected BigDecimal getDai2syenyenkijyunValue() {
        if (dai2syenyenkijyunValue == null && dai2syenyenkijyun != null) {
            if (dai2syenyenkijyun.isOptional()) return null;
            return dai2syenyenkijyun.absolute();
        }
        return dai2syenyenkijyunValue;
    }

    protected void setDai2syenyenkijyunValue(BigDecimal value) {
        dai2syenyenkijyunValue = value;
        dai2syenyenkijyun = Optional.fromNullable(toCurrencyType(dai2syenyenkijyunType))
            .transform(bizCurrencyTransformer(getDai2syenyenkijyunValue()))
            .orNull();
    }

    transient private String dai2syenyenkijyunType = null;

    @Column(name=DAI2SYENYENKIJYUN + "$", nullable=true)
    protected String getDai2syenyenkijyunType() {
        if (dai2syenyenkijyunType == null && dai2syenyenkijyun != null) return dai2syenyenkijyun.getType().toString();
        if (dai2syenyenkijyunType == null && getDai2syenyenkijyunValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai2syenyenkijyun$' should not be NULL."));
        }
        return dai2syenyenkijyunType;
    }

    protected void setDai2syenyenkijyunType(String type) {
        dai2syenyenkijyunType = type;
        dai2syenyenkijyun = Optional.fromNullable(toCurrencyType(dai2syenyenkijyunType))
            .transform(bizCurrencyTransformer(getDai2syenyenkijyunValue()))
            .orNull();
    }

    private BizCurrency dai2syenyenyasu;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai2syenyenyasu() {
        return dai2syenyenyasu;
    }

    public void setDai2syenyenyasu(BizCurrency pDai2syenyenyasu) {
        dai2syenyenyasu = pDai2syenyenyasu;
        dai2syenyenyasuValue = null;
        dai2syenyenyasuType  = null;
    }

    transient private BigDecimal dai2syenyenyasuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI2SYENYENYASU, nullable=true)
    protected BigDecimal getDai2syenyenyasuValue() {
        if (dai2syenyenyasuValue == null && dai2syenyenyasu != null) {
            if (dai2syenyenyasu.isOptional()) return null;
            return dai2syenyenyasu.absolute();
        }
        return dai2syenyenyasuValue;
    }

    protected void setDai2syenyenyasuValue(BigDecimal value) {
        dai2syenyenyasuValue = value;
        dai2syenyenyasu = Optional.fromNullable(toCurrencyType(dai2syenyenyasuType))
            .transform(bizCurrencyTransformer(getDai2syenyenyasuValue()))
            .orNull();
    }

    transient private String dai2syenyenyasuType = null;

    @Column(name=DAI2SYENYENYASU + "$", nullable=true)
    protected String getDai2syenyenyasuType() {
        if (dai2syenyenyasuType == null && dai2syenyenyasu != null) return dai2syenyenyasu.getType().toString();
        if (dai2syenyenyasuType == null && getDai2syenyenyasuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai2syenyenyasu$' should not be NULL."));
        }
        return dai2syenyenyasuType;
    }

    protected void setDai2syenyenyasuType(String type) {
        dai2syenyenyasuType = type;
        dai2syenyenyasu = Optional.fromNullable(toCurrencyType(dai2syenyenyasuType))
            .transform(bizCurrencyTransformer(getDai2syenyenyasuValue()))
            .orNull();
    }

    private C_Tuukasyu dai3stuuktype;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.DAI3STUUKTYPE)
    public C_Tuukasyu getDai3stuuktype() {
        return dai3stuuktype;
    }

    public void setDai3stuuktype(C_Tuukasyu pDai3stuuktype) {
        dai3stuuktype = pDai3stuuktype;
    }

    private BizCurrency dai3s;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai3s() {
        return dai3s;
    }

    public void setDai3s(BizCurrency pDai3s) {
        dai3s = pDai3s;
        dai3sValue = null;
        dai3sType  = null;
    }

    transient private BigDecimal dai3sValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI3S, nullable=true)
    protected BigDecimal getDai3sValue() {
        if (dai3sValue == null && dai3s != null) {
            if (dai3s.isOptional()) return null;
            return dai3s.absolute();
        }
        return dai3sValue;
    }

    protected void setDai3sValue(BigDecimal value) {
        dai3sValue = value;
        dai3s = Optional.fromNullable(toCurrencyType(dai3sType))
            .transform(bizCurrencyTransformer(getDai3sValue()))
            .orNull();
    }

    transient private String dai3sType = null;

    @Column(name=DAI3S + "$", nullable=true)
    protected String getDai3sType() {
        if (dai3sType == null && dai3s != null) return dai3s.getType().toString();
        if (dai3sType == null && getDai3sValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai3s$' should not be NULL."));
        }
        return dai3sType;
    }

    protected void setDai3sType(String type) {
        dai3sType = type;
        dai3s = Optional.fromNullable(toCurrencyType(dai3sType))
            .transform(bizCurrencyTransformer(getDai3sValue()))
            .orNull();
    }

    private C_Tuukasyu dai3syentuuktype;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.DAI3SYENTUUKTYPE)
    public C_Tuukasyu getDai3syentuuktype() {
        return dai3syentuuktype;
    }

    public void setDai3syentuuktype(C_Tuukasyu pDai3syentuuktype) {
        dai3syentuuktype = pDai3syentuuktype;
    }

    private BizCurrency dai3syenyendaka;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai3syenyendaka() {
        return dai3syenyendaka;
    }

    public void setDai3syenyendaka(BizCurrency pDai3syenyendaka) {
        dai3syenyendaka = pDai3syenyendaka;
        dai3syenyendakaValue = null;
        dai3syenyendakaType  = null;
    }

    transient private BigDecimal dai3syenyendakaValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI3SYENYENDAKA, nullable=true)
    protected BigDecimal getDai3syenyendakaValue() {
        if (dai3syenyendakaValue == null && dai3syenyendaka != null) {
            if (dai3syenyendaka.isOptional()) return null;
            return dai3syenyendaka.absolute();
        }
        return dai3syenyendakaValue;
    }

    protected void setDai3syenyendakaValue(BigDecimal value) {
        dai3syenyendakaValue = value;
        dai3syenyendaka = Optional.fromNullable(toCurrencyType(dai3syenyendakaType))
            .transform(bizCurrencyTransformer(getDai3syenyendakaValue()))
            .orNull();
    }

    transient private String dai3syenyendakaType = null;

    @Column(name=DAI3SYENYENDAKA + "$", nullable=true)
    protected String getDai3syenyendakaType() {
        if (dai3syenyendakaType == null && dai3syenyendaka != null) return dai3syenyendaka.getType().toString();
        if (dai3syenyendakaType == null && getDai3syenyendakaValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai3syenyendaka$' should not be NULL."));
        }
        return dai3syenyendakaType;
    }

    protected void setDai3syenyendakaType(String type) {
        dai3syenyendakaType = type;
        dai3syenyendaka = Optional.fromNullable(toCurrencyType(dai3syenyendakaType))
            .transform(bizCurrencyTransformer(getDai3syenyendakaValue()))
            .orNull();
    }

    private BizCurrency dai3syenyenkijyun;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai3syenyenkijyun() {
        return dai3syenyenkijyun;
    }

    public void setDai3syenyenkijyun(BizCurrency pDai3syenyenkijyun) {
        dai3syenyenkijyun = pDai3syenyenkijyun;
        dai3syenyenkijyunValue = null;
        dai3syenyenkijyunType  = null;
    }

    transient private BigDecimal dai3syenyenkijyunValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI3SYENYENKIJYUN, nullable=true)
    protected BigDecimal getDai3syenyenkijyunValue() {
        if (dai3syenyenkijyunValue == null && dai3syenyenkijyun != null) {
            if (dai3syenyenkijyun.isOptional()) return null;
            return dai3syenyenkijyun.absolute();
        }
        return dai3syenyenkijyunValue;
    }

    protected void setDai3syenyenkijyunValue(BigDecimal value) {
        dai3syenyenkijyunValue = value;
        dai3syenyenkijyun = Optional.fromNullable(toCurrencyType(dai3syenyenkijyunType))
            .transform(bizCurrencyTransformer(getDai3syenyenkijyunValue()))
            .orNull();
    }

    transient private String dai3syenyenkijyunType = null;

    @Column(name=DAI3SYENYENKIJYUN + "$", nullable=true)
    protected String getDai3syenyenkijyunType() {
        if (dai3syenyenkijyunType == null && dai3syenyenkijyun != null) return dai3syenyenkijyun.getType().toString();
        if (dai3syenyenkijyunType == null && getDai3syenyenkijyunValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai3syenyenkijyun$' should not be NULL."));
        }
        return dai3syenyenkijyunType;
    }

    protected void setDai3syenyenkijyunType(String type) {
        dai3syenyenkijyunType = type;
        dai3syenyenkijyun = Optional.fromNullable(toCurrencyType(dai3syenyenkijyunType))
            .transform(bizCurrencyTransformer(getDai3syenyenkijyunValue()))
            .orNull();
    }

    private BizCurrency dai3syenyenyasu;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai3syenyenyasu() {
        return dai3syenyenyasu;
    }

    public void setDai3syenyenyasu(BizCurrency pDai3syenyenyasu) {
        dai3syenyenyasu = pDai3syenyenyasu;
        dai3syenyenyasuValue = null;
        dai3syenyenyasuType  = null;
    }

    transient private BigDecimal dai3syenyenyasuValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI3SYENYENYASU, nullable=true)
    protected BigDecimal getDai3syenyenyasuValue() {
        if (dai3syenyenyasuValue == null && dai3syenyenyasu != null) {
            if (dai3syenyenyasu.isOptional()) return null;
            return dai3syenyenyasu.absolute();
        }
        return dai3syenyenyasuValue;
    }

    protected void setDai3syenyenyasuValue(BigDecimal value) {
        dai3syenyenyasuValue = value;
        dai3syenyenyasu = Optional.fromNullable(toCurrencyType(dai3syenyenyasuType))
            .transform(bizCurrencyTransformer(getDai3syenyenyasuValue()))
            .orNull();
    }

    transient private String dai3syenyenyasuType = null;

    @Column(name=DAI3SYENYENYASU + "$", nullable=true)
    protected String getDai3syenyenyasuType() {
        if (dai3syenyenyasuType == null && dai3syenyenyasu != null) return dai3syenyenyasu.getType().toString();
        if (dai3syenyenyasuType == null && getDai3syenyenyasuValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai3syenyenyasu$' should not be NULL."));
        }
        return dai3syenyenyasuType;
    }

    protected void setDai3syenyenyasuType(String type) {
        dai3syenyenyasuType = type;
        dai3syenyenyasu = Optional.fromNullable(toCurrencyType(dai3syenyenyasuType))
            .transform(bizCurrencyTransformer(getDai3syenyenyasuValue()))
            .orNull();
    }

    private String sibouinjiptnkbn;

    @Column(name=GenIT_BAK_HokenSyouken.SIBOUINJIPTNKBN)
    public String getSibouinjiptnkbn() {
        return sibouinjiptnkbn;
    }

    public void setSibouinjiptnkbn(String pSibouinjiptnkbn) {
        sibouinjiptnkbn = pSibouinjiptnkbn;
    }

    private String mkhyouyensysnikoumsgcd;

    @Column(name=GenIT_BAK_HokenSyouken.MKHYOUYENSYSNIKOUMSGCD)
    public String getMkhyouyensysnikoumsgcd() {
        return mkhyouyensysnikoumsgcd;
    }

    public void setMkhyouyensysnikoumsgcd(String pMkhyouyensysnikoumsgcd) {
        mkhyouyensysnikoumsgcd = pMkhyouyensysnikoumsgcd;
    }

    private String mkhyouyensysnikoumsgcd2;

    @Column(name=GenIT_BAK_HokenSyouken.MKHYOUYENSYSNIKOUMSGCD2)
    public String getMkhyouyensysnikoumsgcd2() {
        return mkhyouyensysnikoumsgcd2;
    }

    public void setMkhyouyensysnikoumsgcd2(String pMkhyouyensysnikoumsgcd2) {
        mkhyouyensysnikoumsgcd2 = pMkhyouyensysnikoumsgcd2;
    }

    private String mkhyouyensysnikoumsgcd3;

    @Column(name=GenIT_BAK_HokenSyouken.MKHYOUYENSYSNIKOUMSGCD3)
    public String getMkhyouyensysnikoumsgcd3() {
        return mkhyouyensysnikoumsgcd3;
    }

    public void setMkhyouyensysnikoumsgcd3(String pMkhyouyensysnikoumsgcd3) {
        mkhyouyensysnikoumsgcd3 = pMkhyouyensysnikoumsgcd3;
    }

    private C_Tuukasyu mkhyouyensysnikougktype;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.MKHYOUYENSYSNIKOUGKTYPE)
    public C_Tuukasyu getMkhyouyensysnikougktype() {
        return mkhyouyensysnikougktype;
    }

    public void setMkhyouyensysnikougktype(C_Tuukasyu pMkhyouyensysnikougktype) {
        mkhyouyensysnikougktype = pMkhyouyensysnikougktype;
    }

    private BizCurrency mkhyouyensysnikougk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMkhyouyensysnikougk() {
        return mkhyouyensysnikougk;
    }

    public void setMkhyouyensysnikougk(BizCurrency pMkhyouyensysnikougk) {
        mkhyouyensysnikougk = pMkhyouyensysnikougk;
        mkhyouyensysnikougkValue = null;
        mkhyouyensysnikougkType  = null;
    }

    transient private BigDecimal mkhyouyensysnikougkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MKHYOUYENSYSNIKOUGK, nullable=true)
    protected BigDecimal getMkhyouyensysnikougkValue() {
        if (mkhyouyensysnikougkValue == null && mkhyouyensysnikougk != null) {
            if (mkhyouyensysnikougk.isOptional()) return null;
            return mkhyouyensysnikougk.absolute();
        }
        return mkhyouyensysnikougkValue;
    }

    protected void setMkhyouyensysnikougkValue(BigDecimal value) {
        mkhyouyensysnikougkValue = value;
        mkhyouyensysnikougk = Optional.fromNullable(toCurrencyType(mkhyouyensysnikougkType))
            .transform(bizCurrencyTransformer(getMkhyouyensysnikougkValue()))
            .orNull();
    }

    transient private String mkhyouyensysnikougkType = null;

    @Column(name=MKHYOUYENSYSNIKOUGK + "$", nullable=true)
    protected String getMkhyouyensysnikougkType() {
        if (mkhyouyensysnikougkType == null && mkhyouyensysnikougk != null) return mkhyouyensysnikougk.getType().toString();
        if (mkhyouyensysnikougkType == null && getMkhyouyensysnikougkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mkhyouyensysnikougk$' should not be NULL."));
        }
        return mkhyouyensysnikougkType;
    }

    protected void setMkhyouyensysnikougkType(String type) {
        mkhyouyensysnikougkType = type;
        mkhyouyensysnikougk = Optional.fromNullable(toCurrencyType(mkhyouyensysnikougkType))
            .transform(bizCurrencyTransformer(getMkhyouyensysnikougkValue()))
            .orNull();
    }

    private BizNumber mkhyouyensysnikouwra;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.MKHYOUYENSYSNIKOUWRA)
    public BizNumber getMkhyouyensysnikouwra() {
        return mkhyouyensysnikouwra;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMkhyouyensysnikouwra(BizNumber pMkhyouyensysnikouwra) {
        mkhyouyensysnikouwra = pMkhyouyensysnikouwra;
    }

    private String kaigomaehrtkykmsgcd1;

    @Column(name=GenIT_BAK_HokenSyouken.KAIGOMAEHRTKYKMSGCD1)
    public String getKaigomaehrtkykmsgcd1() {
        return kaigomaehrtkykmsgcd1;
    }

    public void setKaigomaehrtkykmsgcd1(String pKaigomaehrtkykmsgcd1) {
        kaigomaehrtkykmsgcd1 = pKaigomaehrtkykmsgcd1;
    }

    private String kaigomaehrtkykmsgcd2;

    @Column(name=GenIT_BAK_HokenSyouken.KAIGOMAEHRTKYKMSGCD2)
    public String getKaigomaehrtkykmsgcd2() {
        return kaigomaehrtkykmsgcd2;
    }

    public void setKaigomaehrtkykmsgcd2(String pKaigomaehrtkykmsgcd2) {
        kaigomaehrtkykmsgcd2 = pKaigomaehrtkykmsgcd2;
    }

    private String kaigomaehrtkykmsgcdst1;

    @Column(name=GenIT_BAK_HokenSyouken.KAIGOMAEHRTKYKMSGCDST1)
    public String getKaigomaehrtkykmsgcdst1() {
        return kaigomaehrtkykmsgcdst1;
    }

    public void setKaigomaehrtkykmsgcdst1(String pKaigomaehrtkykmsgcdst1) {
        kaigomaehrtkykmsgcdst1 = pKaigomaehrtkykmsgcdst1;
    }

    private String kaigomaehrtkykmsgcdst2;

    @Column(name=GenIT_BAK_HokenSyouken.KAIGOMAEHRTKYKMSGCDST2)
    public String getKaigomaehrtkykmsgcdst2() {
        return kaigomaehrtkykmsgcdst2;
    }

    public void setKaigomaehrtkykmsgcdst2(String pKaigomaehrtkykmsgcdst2) {
        kaigomaehrtkykmsgcdst2 = pKaigomaehrtkykmsgcdst2;
    }

    private String kaigomaehruktgkumu;

    @Column(name=GenIT_BAK_HokenSyouken.KAIGOMAEHRUKTGKUMU)
    public String getKaigomaehruktgkumu() {
        return kaigomaehruktgkumu;
    }

    public void setKaigomaehruktgkumu(String pKaigomaehruktgkumu) {
        kaigomaehruktgkumu = pKaigomaehruktgkumu;
    }

    private String kaigomaehrtkykkyktuuka;

    @Column(name=GenIT_BAK_HokenSyouken.KAIGOMAEHRTKYKKYKTUUKA)
    public String getKaigomaehrtkykkyktuuka() {
        return kaigomaehrtkykkyktuuka;
    }

    public void setKaigomaehrtkykkyktuuka(String pKaigomaehrtkykkyktuuka) {
        kaigomaehrtkykkyktuuka = pKaigomaehrtkykkyktuuka;
    }

    private String kaigomaehrtkykstdmsgcd;

    @Column(name=GenIT_BAK_HokenSyouken.KAIGOMAEHRTKYKSTDMSGCD)
    public String getKaigomaehrtkykstdmsgcd() {
        return kaigomaehrtkykstdmsgcd;
    }

    public void setKaigomaehrtkykstdmsgcd(String pKaigomaehrtkykstdmsgcd) {
        kaigomaehrtkykstdmsgcd = pKaigomaehrtkykstdmsgcd;
    }

    private C_Tuukasyu kaigomaehrjrugktype;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.KAIGOMAEHRJRUGKTYPE)
    public C_Tuukasyu getKaigomaehrjrugktype() {
        return kaigomaehrjrugktype;
    }

    public void setKaigomaehrjrugktype(C_Tuukasyu pKaigomaehrjrugktype) {
        kaigomaehrjrugktype = pKaigomaehrjrugktype;
    }

    private Integer kaigomaehrsikuhhknnen01;

    @Column(name=GenIT_BAK_HokenSyouken.KAIGOMAEHRSIKUHHKNNEN01)
    public Integer getKaigomaehrsikuhhknnen01() {
        return kaigomaehrsikuhhknnen01;
    }

    public void setKaigomaehrsikuhhknnen01(Integer pKaigomaehrsikuhhknnen01) {
        kaigomaehrsikuhhknnen01 = pKaigomaehrsikuhhknnen01;
    }

    private BizNumber kaigomaehrstikkn01;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.KAIGOMAEHRSTIKKN01)
    public BizNumber getKaigomaehrstikkn01() {
        return kaigomaehrstikkn01;
    }

    public void setKaigomaehrstikkn01(BizNumber pKaigomaehrstikkn01) {
        kaigomaehrstikkn01 = pKaigomaehrstikkn01;
    }

    private BizCurrency kaigomaehrjrugk01;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugk01() {
        return kaigomaehrjrugk01;
    }

    public void setKaigomaehrjrugk01(BizCurrency pKaigomaehrjrugk01) {
        kaigomaehrjrugk01 = pKaigomaehrjrugk01;
        kaigomaehrjrugk01Value = null;
        kaigomaehrjrugk01Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugk01Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGK01, nullable=true)
    protected BigDecimal getKaigomaehrjrugk01Value() {
        if (kaigomaehrjrugk01Value == null && kaigomaehrjrugk01 != null) {
            if (kaigomaehrjrugk01.isOptional()) return null;
            return kaigomaehrjrugk01.absolute();
        }
        return kaigomaehrjrugk01Value;
    }

    protected void setKaigomaehrjrugk01Value(BigDecimal value) {
        kaigomaehrjrugk01Value = value;
        kaigomaehrjrugk01 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugk01Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugk01Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugk01Type = null;

    @Column(name=KAIGOMAEHRJRUGK01 + "$", nullable=true)
    protected String getKaigomaehrjrugk01Type() {
        if (kaigomaehrjrugk01Type == null && kaigomaehrjrugk01 != null) return kaigomaehrjrugk01.getType().toString();
        if (kaigomaehrjrugk01Type == null && getKaigomaehrjrugk01Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugk01$' should not be NULL."));
        }
        return kaigomaehrjrugk01Type;
    }

    protected void setKaigomaehrjrugk01Type(String type) {
        kaigomaehrjrugk01Type = type;
        kaigomaehrjrugk01 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugk01Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugk01Value()))
            .orNull();
    }

    private Integer kaigomaehrsikuhhknnen02;

    @Column(name=GenIT_BAK_HokenSyouken.KAIGOMAEHRSIKUHHKNNEN02)
    public Integer getKaigomaehrsikuhhknnen02() {
        return kaigomaehrsikuhhknnen02;
    }

    public void setKaigomaehrsikuhhknnen02(Integer pKaigomaehrsikuhhknnen02) {
        kaigomaehrsikuhhknnen02 = pKaigomaehrsikuhhknnen02;
    }

    private BizNumber kaigomaehrstikkn02;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.KAIGOMAEHRSTIKKN02)
    public BizNumber getKaigomaehrstikkn02() {
        return kaigomaehrstikkn02;
    }

    public void setKaigomaehrstikkn02(BizNumber pKaigomaehrstikkn02) {
        kaigomaehrstikkn02 = pKaigomaehrstikkn02;
    }

    private BizCurrency kaigomaehrjrugk02;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugk02() {
        return kaigomaehrjrugk02;
    }

    public void setKaigomaehrjrugk02(BizCurrency pKaigomaehrjrugk02) {
        kaigomaehrjrugk02 = pKaigomaehrjrugk02;
        kaigomaehrjrugk02Value = null;
        kaigomaehrjrugk02Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugk02Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGK02, nullable=true)
    protected BigDecimal getKaigomaehrjrugk02Value() {
        if (kaigomaehrjrugk02Value == null && kaigomaehrjrugk02 != null) {
            if (kaigomaehrjrugk02.isOptional()) return null;
            return kaigomaehrjrugk02.absolute();
        }
        return kaigomaehrjrugk02Value;
    }

    protected void setKaigomaehrjrugk02Value(BigDecimal value) {
        kaigomaehrjrugk02Value = value;
        kaigomaehrjrugk02 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugk02Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugk02Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugk02Type = null;

    @Column(name=KAIGOMAEHRJRUGK02 + "$", nullable=true)
    protected String getKaigomaehrjrugk02Type() {
        if (kaigomaehrjrugk02Type == null && kaigomaehrjrugk02 != null) return kaigomaehrjrugk02.getType().toString();
        if (kaigomaehrjrugk02Type == null && getKaigomaehrjrugk02Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugk02$' should not be NULL."));
        }
        return kaigomaehrjrugk02Type;
    }

    protected void setKaigomaehrjrugk02Type(String type) {
        kaigomaehrjrugk02Type = type;
        kaigomaehrjrugk02 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugk02Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugk02Value()))
            .orNull();
    }

    private Integer kaigomaehrsikuhhknnen03;

    @Column(name=GenIT_BAK_HokenSyouken.KAIGOMAEHRSIKUHHKNNEN03)
    public Integer getKaigomaehrsikuhhknnen03() {
        return kaigomaehrsikuhhknnen03;
    }

    public void setKaigomaehrsikuhhknnen03(Integer pKaigomaehrsikuhhknnen03) {
        kaigomaehrsikuhhknnen03 = pKaigomaehrsikuhhknnen03;
    }

    private BizNumber kaigomaehrstikkn03;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.KAIGOMAEHRSTIKKN03)
    public BizNumber getKaigomaehrstikkn03() {
        return kaigomaehrstikkn03;
    }

    public void setKaigomaehrstikkn03(BizNumber pKaigomaehrstikkn03) {
        kaigomaehrstikkn03 = pKaigomaehrstikkn03;
    }

    private BizCurrency kaigomaehrjrugk03;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugk03() {
        return kaigomaehrjrugk03;
    }

    public void setKaigomaehrjrugk03(BizCurrency pKaigomaehrjrugk03) {
        kaigomaehrjrugk03 = pKaigomaehrjrugk03;
        kaigomaehrjrugk03Value = null;
        kaigomaehrjrugk03Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugk03Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGK03, nullable=true)
    protected BigDecimal getKaigomaehrjrugk03Value() {
        if (kaigomaehrjrugk03Value == null && kaigomaehrjrugk03 != null) {
            if (kaigomaehrjrugk03.isOptional()) return null;
            return kaigomaehrjrugk03.absolute();
        }
        return kaigomaehrjrugk03Value;
    }

    protected void setKaigomaehrjrugk03Value(BigDecimal value) {
        kaigomaehrjrugk03Value = value;
        kaigomaehrjrugk03 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugk03Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugk03Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugk03Type = null;

    @Column(name=KAIGOMAEHRJRUGK03 + "$", nullable=true)
    protected String getKaigomaehrjrugk03Type() {
        if (kaigomaehrjrugk03Type == null && kaigomaehrjrugk03 != null) return kaigomaehrjrugk03.getType().toString();
        if (kaigomaehrjrugk03Type == null && getKaigomaehrjrugk03Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugk03$' should not be NULL."));
        }
        return kaigomaehrjrugk03Type;
    }

    protected void setKaigomaehrjrugk03Type(String type) {
        kaigomaehrjrugk03Type = type;
        kaigomaehrjrugk03 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugk03Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugk03Value()))
            .orNull();
    }

    private Integer kaigomaehrsikuhhknnen04;

    @Column(name=GenIT_BAK_HokenSyouken.KAIGOMAEHRSIKUHHKNNEN04)
    public Integer getKaigomaehrsikuhhknnen04() {
        return kaigomaehrsikuhhknnen04;
    }

    public void setKaigomaehrsikuhhknnen04(Integer pKaigomaehrsikuhhknnen04) {
        kaigomaehrsikuhhknnen04 = pKaigomaehrsikuhhknnen04;
    }

    private BizNumber kaigomaehrstikkn04;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.KAIGOMAEHRSTIKKN04)
    public BizNumber getKaigomaehrstikkn04() {
        return kaigomaehrstikkn04;
    }

    public void setKaigomaehrstikkn04(BizNumber pKaigomaehrstikkn04) {
        kaigomaehrstikkn04 = pKaigomaehrstikkn04;
    }

    private BizCurrency kaigomaehrjrugk04;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugk04() {
        return kaigomaehrjrugk04;
    }

    public void setKaigomaehrjrugk04(BizCurrency pKaigomaehrjrugk04) {
        kaigomaehrjrugk04 = pKaigomaehrjrugk04;
        kaigomaehrjrugk04Value = null;
        kaigomaehrjrugk04Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugk04Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGK04, nullable=true)
    protected BigDecimal getKaigomaehrjrugk04Value() {
        if (kaigomaehrjrugk04Value == null && kaigomaehrjrugk04 != null) {
            if (kaigomaehrjrugk04.isOptional()) return null;
            return kaigomaehrjrugk04.absolute();
        }
        return kaigomaehrjrugk04Value;
    }

    protected void setKaigomaehrjrugk04Value(BigDecimal value) {
        kaigomaehrjrugk04Value = value;
        kaigomaehrjrugk04 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugk04Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugk04Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugk04Type = null;

    @Column(name=KAIGOMAEHRJRUGK04 + "$", nullable=true)
    protected String getKaigomaehrjrugk04Type() {
        if (kaigomaehrjrugk04Type == null && kaigomaehrjrugk04 != null) return kaigomaehrjrugk04.getType().toString();
        if (kaigomaehrjrugk04Type == null && getKaigomaehrjrugk04Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugk04$' should not be NULL."));
        }
        return kaigomaehrjrugk04Type;
    }

    protected void setKaigomaehrjrugk04Type(String type) {
        kaigomaehrjrugk04Type = type;
        kaigomaehrjrugk04 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugk04Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugk04Value()))
            .orNull();
    }

    private Integer kaigomaehrsikuhhknnen05;

    @Column(name=GenIT_BAK_HokenSyouken.KAIGOMAEHRSIKUHHKNNEN05)
    public Integer getKaigomaehrsikuhhknnen05() {
        return kaigomaehrsikuhhknnen05;
    }

    public void setKaigomaehrsikuhhknnen05(Integer pKaigomaehrsikuhhknnen05) {
        kaigomaehrsikuhhknnen05 = pKaigomaehrsikuhhknnen05;
    }

    private BizNumber kaigomaehrstikkn05;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.KAIGOMAEHRSTIKKN05)
    public BizNumber getKaigomaehrstikkn05() {
        return kaigomaehrstikkn05;
    }

    public void setKaigomaehrstikkn05(BizNumber pKaigomaehrstikkn05) {
        kaigomaehrstikkn05 = pKaigomaehrstikkn05;
    }

    private BizCurrency kaigomaehrjrugk05;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugk05() {
        return kaigomaehrjrugk05;
    }

    public void setKaigomaehrjrugk05(BizCurrency pKaigomaehrjrugk05) {
        kaigomaehrjrugk05 = pKaigomaehrjrugk05;
        kaigomaehrjrugk05Value = null;
        kaigomaehrjrugk05Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugk05Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGK05, nullable=true)
    protected BigDecimal getKaigomaehrjrugk05Value() {
        if (kaigomaehrjrugk05Value == null && kaigomaehrjrugk05 != null) {
            if (kaigomaehrjrugk05.isOptional()) return null;
            return kaigomaehrjrugk05.absolute();
        }
        return kaigomaehrjrugk05Value;
    }

    protected void setKaigomaehrjrugk05Value(BigDecimal value) {
        kaigomaehrjrugk05Value = value;
        kaigomaehrjrugk05 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugk05Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugk05Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugk05Type = null;

    @Column(name=KAIGOMAEHRJRUGK05 + "$", nullable=true)
    protected String getKaigomaehrjrugk05Type() {
        if (kaigomaehrjrugk05Type == null && kaigomaehrjrugk05 != null) return kaigomaehrjrugk05.getType().toString();
        if (kaigomaehrjrugk05Type == null && getKaigomaehrjrugk05Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugk05$' should not be NULL."));
        }
        return kaigomaehrjrugk05Type;
    }

    protected void setKaigomaehrjrugk05Type(String type) {
        kaigomaehrjrugk05Type = type;
        kaigomaehrjrugk05 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugk05Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugk05Value()))
            .orNull();
    }

    private Integer kaigomaehrsikuhhknnen06;

    @Column(name=GenIT_BAK_HokenSyouken.KAIGOMAEHRSIKUHHKNNEN06)
    public Integer getKaigomaehrsikuhhknnen06() {
        return kaigomaehrsikuhhknnen06;
    }

    public void setKaigomaehrsikuhhknnen06(Integer pKaigomaehrsikuhhknnen06) {
        kaigomaehrsikuhhknnen06 = pKaigomaehrsikuhhknnen06;
    }

    private BizNumber kaigomaehrstikkn06;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.KAIGOMAEHRSTIKKN06)
    public BizNumber getKaigomaehrstikkn06() {
        return kaigomaehrstikkn06;
    }

    public void setKaigomaehrstikkn06(BizNumber pKaigomaehrstikkn06) {
        kaigomaehrstikkn06 = pKaigomaehrstikkn06;
    }

    private BizCurrency kaigomaehrjrugk06;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugk06() {
        return kaigomaehrjrugk06;
    }

    public void setKaigomaehrjrugk06(BizCurrency pKaigomaehrjrugk06) {
        kaigomaehrjrugk06 = pKaigomaehrjrugk06;
        kaigomaehrjrugk06Value = null;
        kaigomaehrjrugk06Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugk06Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGK06, nullable=true)
    protected BigDecimal getKaigomaehrjrugk06Value() {
        if (kaigomaehrjrugk06Value == null && kaigomaehrjrugk06 != null) {
            if (kaigomaehrjrugk06.isOptional()) return null;
            return kaigomaehrjrugk06.absolute();
        }
        return kaigomaehrjrugk06Value;
    }

    protected void setKaigomaehrjrugk06Value(BigDecimal value) {
        kaigomaehrjrugk06Value = value;
        kaigomaehrjrugk06 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugk06Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugk06Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugk06Type = null;

    @Column(name=KAIGOMAEHRJRUGK06 + "$", nullable=true)
    protected String getKaigomaehrjrugk06Type() {
        if (kaigomaehrjrugk06Type == null && kaigomaehrjrugk06 != null) return kaigomaehrjrugk06.getType().toString();
        if (kaigomaehrjrugk06Type == null && getKaigomaehrjrugk06Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugk06$' should not be NULL."));
        }
        return kaigomaehrjrugk06Type;
    }

    protected void setKaigomaehrjrugk06Type(String type) {
        kaigomaehrjrugk06Type = type;
        kaigomaehrjrugk06 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugk06Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugk06Value()))
            .orNull();
    }

    private Integer kaigomaehrsikuhhknnen07;

    @Column(name=GenIT_BAK_HokenSyouken.KAIGOMAEHRSIKUHHKNNEN07)
    public Integer getKaigomaehrsikuhhknnen07() {
        return kaigomaehrsikuhhknnen07;
    }

    public void setKaigomaehrsikuhhknnen07(Integer pKaigomaehrsikuhhknnen07) {
        kaigomaehrsikuhhknnen07 = pKaigomaehrsikuhhknnen07;
    }

    private BizNumber kaigomaehrstikkn07;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.KAIGOMAEHRSTIKKN07)
    public BizNumber getKaigomaehrstikkn07() {
        return kaigomaehrstikkn07;
    }

    public void setKaigomaehrstikkn07(BizNumber pKaigomaehrstikkn07) {
        kaigomaehrstikkn07 = pKaigomaehrstikkn07;
    }

    private BizCurrency kaigomaehrjrugk07;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugk07() {
        return kaigomaehrjrugk07;
    }

    public void setKaigomaehrjrugk07(BizCurrency pKaigomaehrjrugk07) {
        kaigomaehrjrugk07 = pKaigomaehrjrugk07;
        kaigomaehrjrugk07Value = null;
        kaigomaehrjrugk07Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugk07Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGK07, nullable=true)
    protected BigDecimal getKaigomaehrjrugk07Value() {
        if (kaigomaehrjrugk07Value == null && kaigomaehrjrugk07 != null) {
            if (kaigomaehrjrugk07.isOptional()) return null;
            return kaigomaehrjrugk07.absolute();
        }
        return kaigomaehrjrugk07Value;
    }

    protected void setKaigomaehrjrugk07Value(BigDecimal value) {
        kaigomaehrjrugk07Value = value;
        kaigomaehrjrugk07 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugk07Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugk07Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugk07Type = null;

    @Column(name=KAIGOMAEHRJRUGK07 + "$", nullable=true)
    protected String getKaigomaehrjrugk07Type() {
        if (kaigomaehrjrugk07Type == null && kaigomaehrjrugk07 != null) return kaigomaehrjrugk07.getType().toString();
        if (kaigomaehrjrugk07Type == null && getKaigomaehrjrugk07Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugk07$' should not be NULL."));
        }
        return kaigomaehrjrugk07Type;
    }

    protected void setKaigomaehrjrugk07Type(String type) {
        kaigomaehrjrugk07Type = type;
        kaigomaehrjrugk07 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugk07Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugk07Value()))
            .orNull();
    }

    private Integer kaigomaehrsikuhhknnen08;

    @Column(name=GenIT_BAK_HokenSyouken.KAIGOMAEHRSIKUHHKNNEN08)
    public Integer getKaigomaehrsikuhhknnen08() {
        return kaigomaehrsikuhhknnen08;
    }

    public void setKaigomaehrsikuhhknnen08(Integer pKaigomaehrsikuhhknnen08) {
        kaigomaehrsikuhhknnen08 = pKaigomaehrsikuhhknnen08;
    }

    private BizNumber kaigomaehrstikkn08;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.KAIGOMAEHRSTIKKN08)
    public BizNumber getKaigomaehrstikkn08() {
        return kaigomaehrstikkn08;
    }

    public void setKaigomaehrstikkn08(BizNumber pKaigomaehrstikkn08) {
        kaigomaehrstikkn08 = pKaigomaehrstikkn08;
    }

    private BizCurrency kaigomaehrjrugk08;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugk08() {
        return kaigomaehrjrugk08;
    }

    public void setKaigomaehrjrugk08(BizCurrency pKaigomaehrjrugk08) {
        kaigomaehrjrugk08 = pKaigomaehrjrugk08;
        kaigomaehrjrugk08Value = null;
        kaigomaehrjrugk08Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugk08Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGK08, nullable=true)
    protected BigDecimal getKaigomaehrjrugk08Value() {
        if (kaigomaehrjrugk08Value == null && kaigomaehrjrugk08 != null) {
            if (kaigomaehrjrugk08.isOptional()) return null;
            return kaigomaehrjrugk08.absolute();
        }
        return kaigomaehrjrugk08Value;
    }

    protected void setKaigomaehrjrugk08Value(BigDecimal value) {
        kaigomaehrjrugk08Value = value;
        kaigomaehrjrugk08 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugk08Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugk08Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugk08Type = null;

    @Column(name=KAIGOMAEHRJRUGK08 + "$", nullable=true)
    protected String getKaigomaehrjrugk08Type() {
        if (kaigomaehrjrugk08Type == null && kaigomaehrjrugk08 != null) return kaigomaehrjrugk08.getType().toString();
        if (kaigomaehrjrugk08Type == null && getKaigomaehrjrugk08Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugk08$' should not be NULL."));
        }
        return kaigomaehrjrugk08Type;
    }

    protected void setKaigomaehrjrugk08Type(String type) {
        kaigomaehrjrugk08Type = type;
        kaigomaehrjrugk08 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugk08Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugk08Value()))
            .orNull();
    }

    private Integer kaigomaehrsikuhhknnen09;

    @Column(name=GenIT_BAK_HokenSyouken.KAIGOMAEHRSIKUHHKNNEN09)
    public Integer getKaigomaehrsikuhhknnen09() {
        return kaigomaehrsikuhhknnen09;
    }

    public void setKaigomaehrsikuhhknnen09(Integer pKaigomaehrsikuhhknnen09) {
        kaigomaehrsikuhhknnen09 = pKaigomaehrsikuhhknnen09;
    }

    private BizNumber kaigomaehrstikkn09;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.KAIGOMAEHRSTIKKN09)
    public BizNumber getKaigomaehrstikkn09() {
        return kaigomaehrstikkn09;
    }

    public void setKaigomaehrstikkn09(BizNumber pKaigomaehrstikkn09) {
        kaigomaehrstikkn09 = pKaigomaehrstikkn09;
    }

    private BizCurrency kaigomaehrjrugk09;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugk09() {
        return kaigomaehrjrugk09;
    }

    public void setKaigomaehrjrugk09(BizCurrency pKaigomaehrjrugk09) {
        kaigomaehrjrugk09 = pKaigomaehrjrugk09;
        kaigomaehrjrugk09Value = null;
        kaigomaehrjrugk09Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugk09Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGK09, nullable=true)
    protected BigDecimal getKaigomaehrjrugk09Value() {
        if (kaigomaehrjrugk09Value == null && kaigomaehrjrugk09 != null) {
            if (kaigomaehrjrugk09.isOptional()) return null;
            return kaigomaehrjrugk09.absolute();
        }
        return kaigomaehrjrugk09Value;
    }

    protected void setKaigomaehrjrugk09Value(BigDecimal value) {
        kaigomaehrjrugk09Value = value;
        kaigomaehrjrugk09 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugk09Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugk09Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugk09Type = null;

    @Column(name=KAIGOMAEHRJRUGK09 + "$", nullable=true)
    protected String getKaigomaehrjrugk09Type() {
        if (kaigomaehrjrugk09Type == null && kaigomaehrjrugk09 != null) return kaigomaehrjrugk09.getType().toString();
        if (kaigomaehrjrugk09Type == null && getKaigomaehrjrugk09Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugk09$' should not be NULL."));
        }
        return kaigomaehrjrugk09Type;
    }

    protected void setKaigomaehrjrugk09Type(String type) {
        kaigomaehrjrugk09Type = type;
        kaigomaehrjrugk09 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugk09Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugk09Value()))
            .orNull();
    }

    private Integer kaigomaehrsikuhhknnen10;

    @Column(name=GenIT_BAK_HokenSyouken.KAIGOMAEHRSIKUHHKNNEN10)
    public Integer getKaigomaehrsikuhhknnen10() {
        return kaigomaehrsikuhhknnen10;
    }

    public void setKaigomaehrsikuhhknnen10(Integer pKaigomaehrsikuhhknnen10) {
        kaigomaehrsikuhhknnen10 = pKaigomaehrsikuhhknnen10;
    }

    private BizNumber kaigomaehrstikkn10;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.KAIGOMAEHRSTIKKN10)
    public BizNumber getKaigomaehrstikkn10() {
        return kaigomaehrstikkn10;
    }

    public void setKaigomaehrstikkn10(BizNumber pKaigomaehrstikkn10) {
        kaigomaehrstikkn10 = pKaigomaehrstikkn10;
    }

    private BizCurrency kaigomaehrjrugk10;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugk10() {
        return kaigomaehrjrugk10;
    }

    public void setKaigomaehrjrugk10(BizCurrency pKaigomaehrjrugk10) {
        kaigomaehrjrugk10 = pKaigomaehrjrugk10;
        kaigomaehrjrugk10Value = null;
        kaigomaehrjrugk10Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugk10Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGK10, nullable=true)
    protected BigDecimal getKaigomaehrjrugk10Value() {
        if (kaigomaehrjrugk10Value == null && kaigomaehrjrugk10 != null) {
            if (kaigomaehrjrugk10.isOptional()) return null;
            return kaigomaehrjrugk10.absolute();
        }
        return kaigomaehrjrugk10Value;
    }

    protected void setKaigomaehrjrugk10Value(BigDecimal value) {
        kaigomaehrjrugk10Value = value;
        kaigomaehrjrugk10 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugk10Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugk10Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugk10Type = null;

    @Column(name=KAIGOMAEHRJRUGK10 + "$", nullable=true)
    protected String getKaigomaehrjrugk10Type() {
        if (kaigomaehrjrugk10Type == null && kaigomaehrjrugk10 != null) return kaigomaehrjrugk10.getType().toString();
        if (kaigomaehrjrugk10Type == null && getKaigomaehrjrugk10Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugk10$' should not be NULL."));
        }
        return kaigomaehrjrugk10Type;
    }

    protected void setKaigomaehrjrugk10Type(String type) {
        kaigomaehrjrugk10Type = type;
        kaigomaehrjrugk10 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugk10Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugk10Value()))
            .orNull();
    }

    private String hutanhiyustmmsgcdue01;

    @Column(name=GenIT_BAK_HokenSyouken.HUTANHIYUSTMMSGCDUE01)
    public String getHutanhiyustmmsgcdue01() {
        return hutanhiyustmmsgcdue01;
    }

    public void setHutanhiyustmmsgcdue01(String pHutanhiyustmmsgcdue01) {
        hutanhiyustmmsgcdue01 = pHutanhiyustmmsgcdue01;
    }

    private String hutanhiyustmmsgcdue02;

    @Column(name=GenIT_BAK_HokenSyouken.HUTANHIYUSTMMSGCDUE02)
    public String getHutanhiyustmmsgcdue02() {
        return hutanhiyustmmsgcdue02;
    }

    public void setHutanhiyustmmsgcdue02(String pHutanhiyustmmsgcdue02) {
        hutanhiyustmmsgcdue02 = pHutanhiyustmmsgcdue02;
    }

    private String hutanhiyustmmsgcdue03;

    @Column(name=GenIT_BAK_HokenSyouken.HUTANHIYUSTMMSGCDUE03)
    public String getHutanhiyustmmsgcdue03() {
        return hutanhiyustmmsgcdue03;
    }

    public void setHutanhiyustmmsgcdue03(String pHutanhiyustmmsgcdue03) {
        hutanhiyustmmsgcdue03 = pHutanhiyustmmsgcdue03;
    }

    private String hutanhiyustmmsgcdue04;

    @Column(name=GenIT_BAK_HokenSyouken.HUTANHIYUSTMMSGCDUE04)
    public String getHutanhiyustmmsgcdue04() {
        return hutanhiyustmmsgcdue04;
    }

    public void setHutanhiyustmmsgcdue04(String pHutanhiyustmmsgcdue04) {
        hutanhiyustmmsgcdue04 = pHutanhiyustmmsgcdue04;
    }

    private String hutanhiyustmknsnhyuptn;

    @Column(name=GenIT_BAK_HokenSyouken.HUTANHIYUSTMKNSNHYUPTN)
    public String getHutanhiyustmknsnhyuptn() {
        return hutanhiyustmknsnhyuptn;
    }

    public void setHutanhiyustmknsnhyuptn(String pHutanhiyustmknsnhyuptn) {
        hutanhiyustmknsnhyuptn = pHutanhiyustmknsnhyuptn;
    }

    private String hutanhiyustmmsgcdst01;

    @Column(name=GenIT_BAK_HokenSyouken.HUTANHIYUSTMMSGCDST01)
    public String getHutanhiyustmmsgcdst01() {
        return hutanhiyustmmsgcdst01;
    }

    public void setHutanhiyustmmsgcdst01(String pHutanhiyustmmsgcdst01) {
        hutanhiyustmmsgcdst01 = pHutanhiyustmmsgcdst01;
    }

    private String hutanhiyustmmsgcdst02;

    @Column(name=GenIT_BAK_HokenSyouken.HUTANHIYUSTMMSGCDST02)
    public String getHutanhiyustmmsgcdst02() {
        return hutanhiyustmmsgcdst02;
    }

    public void setHutanhiyustmmsgcdst02(String pHutanhiyustmmsgcdst02) {
        hutanhiyustmmsgcdst02 = pHutanhiyustmmsgcdst02;
    }

    private String hutanhiyustmmsgcdst03;

    @Column(name=GenIT_BAK_HokenSyouken.HUTANHIYUSTMMSGCDST03)
    public String getHutanhiyustmmsgcdst03() {
        return hutanhiyustmmsgcdst03;
    }

    public void setHutanhiyustmmsgcdst03(String pHutanhiyustmmsgcdst03) {
        hutanhiyustmmsgcdst03 = pHutanhiyustmmsgcdst03;
    }

    private String stdstmmsgcd;

    @Column(name=GenIT_BAK_HokenSyouken.STDSTMMSGCD)
    public String getStdstmmsgcd() {
        return stdstmmsgcd;
    }

    public void setStdstmmsgcd(String pStdstmmsgcd) {
        stdstmmsgcd = pStdstmmsgcd;
    }

    private String fstpmsgcd;

    @Column(name=GenIT_BAK_HokenSyouken.FSTPMSGCD)
    public String getFstpmsgcd() {
        return fstpmsgcd;
    }

    public void setFstpmsgcd(String pFstpmsgcd) {
        fstpmsgcd = pFstpmsgcd;
    }

    private C_Tuukasyu fstphrkpkngkkeituuktype;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.FSTPHRKPKNGKKEITUUKTYPE)
    public C_Tuukasyu getFstphrkpkngkkeituuktype() {
        return fstphrkpkngkkeituuktype;
    }

    public void setFstphrkpkngkkeituuktype(C_Tuukasyu pFstphrkpkngkkeituuktype) {
        fstphrkpkngkkeituuktype = pFstphrkpkngkkeituuktype;
    }

    private BizCurrency fstphrkpkngkkei;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getFstphrkpkngkkei() {
        return fstphrkpkngkkei;
    }

    public void setFstphrkpkngkkei(BizCurrency pFstphrkpkngkkei) {
        fstphrkpkngkkei = pFstphrkpkngkkei;
        fstphrkpkngkkeiValue = null;
        fstphrkpkngkkeiType  = null;
    }

    transient private BigDecimal fstphrkpkngkkeiValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=FSTPHRKPKNGKKEI, nullable=true)
    protected BigDecimal getFstphrkpkngkkeiValue() {
        if (fstphrkpkngkkeiValue == null && fstphrkpkngkkei != null) {
            if (fstphrkpkngkkei.isOptional()) return null;
            return fstphrkpkngkkei.absolute();
        }
        return fstphrkpkngkkeiValue;
    }

    protected void setFstphrkpkngkkeiValue(BigDecimal value) {
        fstphrkpkngkkeiValue = value;
        fstphrkpkngkkei = Optional.fromNullable(toCurrencyType(fstphrkpkngkkeiType))
            .transform(bizCurrencyTransformer(getFstphrkpkngkkeiValue()))
            .orNull();
    }

    transient private String fstphrkpkngkkeiType = null;

    @Column(name=FSTPHRKPKNGKKEI + "$", nullable=true)
    protected String getFstphrkpkngkkeiType() {
        if (fstphrkpkngkkeiType == null && fstphrkpkngkkei != null) return fstphrkpkngkkei.getType().toString();
        if (fstphrkpkngkkeiType == null && getFstphrkpkngkkeiValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'fstphrkpkngkkei$' should not be NULL."));
        }
        return fstphrkpkngkkeiType;
    }

    protected void setFstphrkpkngkkeiType(String type) {
        fstphrkpkngkkeiType = type;
        fstphrkpkngkkei = Optional.fromNullable(toCurrencyType(fstphrkpkngkkeiType))
            .transform(bizCurrencyTransformer(getFstphrkpkngkkeiValue()))
            .orNull();
    }

    private String fstponegaimsgcd;

    @Column(name=GenIT_BAK_HokenSyouken.FSTPONEGAIMSGCD)
    public String getFstponegaimsgcd() {
        return fstponegaimsgcd;
    }

    public void setFstponegaimsgcd(String pFstponegaimsgcd) {
        fstponegaimsgcd = pFstponegaimsgcd;
    }

    private String dsmsgcd;

    @Column(name=GenIT_BAK_HokenSyouken.DSMSGCD)
    public String getDsmsgcd() {
        return dsmsgcd;
    }

    public void setDsmsgcd(String pDsmsgcd) {
        dsmsgcd = pDsmsgcd;
    }

    private String syouhnhutaimsgcd1;

    @Column(name=GenIT_BAK_HokenSyouken.SYOUHNHUTAIMSGCD1)
    public String getSyouhnhutaimsgcd1() {
        return syouhnhutaimsgcd1;
    }

    public void setSyouhnhutaimsgcd1(String pSyouhnhutaimsgcd1) {
        syouhnhutaimsgcd1 = pSyouhnhutaimsgcd1;
    }

    private String syouhnhutaimsgcd2;

    @Column(name=GenIT_BAK_HokenSyouken.SYOUHNHUTAIMSGCD2)
    public String getSyouhnhutaimsgcd2() {
        return syouhnhutaimsgcd2;
    }

    public void setSyouhnhutaimsgcd2(String pSyouhnhutaimsgcd2) {
        syouhnhutaimsgcd2 = pSyouhnhutaimsgcd2;
    }

    private C_Tuukasyu pyentuuktype;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.PYENTUUKTYPE)
    public C_Tuukasyu getPyentuuktype() {
        return pyentuuktype;
    }

    public void setPyentuuktype(C_Tuukasyu pPyentuuktype) {
        pyentuuktype = pPyentuuktype;
    }

    private BizCurrency pyen;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getPyen() {
        return pyen;
    }

    public void setPyen(BizCurrency pPyen) {
        pyen = pPyen;
        pyenValue = null;
        pyenType  = null;
    }

    transient private BigDecimal pyenValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=PYEN, nullable=true)
    protected BigDecimal getPyenValue() {
        if (pyenValue == null && pyen != null) {
            if (pyen.isOptional()) return null;
            return pyen.absolute();
        }
        return pyenValue;
    }

    protected void setPyenValue(BigDecimal value) {
        pyenValue = value;
        pyen = Optional.fromNullable(toCurrencyType(pyenType))
            .transform(bizCurrencyTransformer(getPyenValue()))
            .orNull();
    }

    transient private String pyenType = null;

    @Column(name=PYEN + "$", nullable=true)
    protected String getPyenType() {
        if (pyenType == null && pyen != null) return pyen.getType().toString();
        if (pyenType == null && getPyenValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'pyen$' should not be NULL."));
        }
        return pyenType;
    }

    protected void setPyenType(String type) {
        pyenType = type;
        pyen = Optional.fromNullable(toCurrencyType(pyenType))
            .transform(bizCurrencyTransformer(getPyenValue()))
            .orNull();
    }

    private String toiawasesakihanyoumsgcd;

    @Column(name=GenIT_BAK_HokenSyouken.TOIAWASESAKIHANYOUMSGCD)
    public String getToiawasesakihanyoumsgcd() {
        return toiawasesakihanyoumsgcd;
    }

    public void setToiawasesakihanyoumsgcd(String pToiawasesakihanyoumsgcd) {
        toiawasesakihanyoumsgcd = pToiawasesakihanyoumsgcd;
    }

    private String annaihanyoumsgcd;

    @Column(name=GenIT_BAK_HokenSyouken.ANNAIHANYOUMSGCD)
    public String getAnnaihanyoumsgcd() {
        return annaihanyoumsgcd;
    }

    public void setAnnaihanyoumsgcd(String pAnnaihanyoumsgcd) {
        annaihanyoumsgcd = pAnnaihanyoumsgcd;
    }

    private String wmsgcd1;

    @Column(name=GenIT_BAK_HokenSyouken.WMSGCD1)
    public String getWmsgcd1() {
        return wmsgcd1;
    }

    public void setWmsgcd1(String pWmsgcd1) {
        wmsgcd1 = pWmsgcd1;
    }

    private String wmsgcd2;

    @Column(name=GenIT_BAK_HokenSyouken.WMSGCD2)
    public String getWmsgcd2() {
        return wmsgcd2;
    }

    public void setWmsgcd2(String pWmsgcd2) {
        wmsgcd2 = pWmsgcd2;
    }

    private String wmsgcd3;

    @Column(name=GenIT_BAK_HokenSyouken.WMSGCD3)
    public String getWmsgcd3() {
        return wmsgcd3;
    }

    public void setWmsgcd3(String pWmsgcd3) {
        wmsgcd3 = pWmsgcd3;
    }

    private String wtyuuijikoumsgcd1;

    @Column(name=GenIT_BAK_HokenSyouken.WTYUUIJIKOUMSGCD1)
    public String getWtyuuijikoumsgcd1() {
        return wtyuuijikoumsgcd1;
    }

    public void setWtyuuijikoumsgcd1(String pWtyuuijikoumsgcd1) {
        wtyuuijikoumsgcd1 = pWtyuuijikoumsgcd1;
    }

    private String wtyuuijikoumsgcd2;

    @Column(name=GenIT_BAK_HokenSyouken.WTYUUIJIKOUMSGCD2)
    public String getWtyuuijikoumsgcd2() {
        return wtyuuijikoumsgcd2;
    }

    public void setWtyuuijikoumsgcd2(String pWtyuuijikoumsgcd2) {
        wtyuuijikoumsgcd2 = pWtyuuijikoumsgcd2;
    }

    private String wtyuuijikoumsgcd3;

    @Column(name=GenIT_BAK_HokenSyouken.WTYUUIJIKOUMSGCD3)
    public String getWtyuuijikoumsgcd3() {
        return wtyuuijikoumsgcd3;
    }

    public void setWtyuuijikoumsgcd3(String pWtyuuijikoumsgcd3) {
        wtyuuijikoumsgcd3 = pWtyuuijikoumsgcd3;
    }

    private String wtyuuijikoumsgcd4;

    @Column(name=GenIT_BAK_HokenSyouken.WTYUUIJIKOUMSGCD4)
    public String getWtyuuijikoumsgcd4() {
        return wtyuuijikoumsgcd4;
    }

    public void setWtyuuijikoumsgcd4(String pWtyuuijikoumsgcd4) {
        wtyuuijikoumsgcd4 = pWtyuuijikoumsgcd4;
    }

    private String wtyuuijikoumsgcd5;

    @Column(name=GenIT_BAK_HokenSyouken.WTYUUIJIKOUMSGCD5)
    public String getWtyuuijikoumsgcd5() {
        return wtyuuijikoumsgcd5;
    }

    public void setWtyuuijikoumsgcd5(String pWtyuuijikoumsgcd5) {
        wtyuuijikoumsgcd5 = pWtyuuijikoumsgcd5;
    }

    private C_Tuukasyu witijibrptuktype;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.WITIJIBRPTUKTYPE)
    public C_Tuukasyu getWitijibrptuktype() {
        return witijibrptuktype;
    }

    public void setWitijibrptuktype(C_Tuukasyu pWitijibrptuktype) {
        witijibrptuktype = pWitijibrptuktype;
    }

    private BizCurrency witijibrp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getWitijibrp() {
        return witijibrp;
    }

    public void setWitijibrp(BizCurrency pWitijibrp) {
        witijibrp = pWitijibrp;
        witijibrpValue = null;
        witijibrpType  = null;
    }

    transient private BigDecimal witijibrpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=WITIJIBRP, nullable=true)
    protected BigDecimal getWitijibrpValue() {
        if (witijibrpValue == null && witijibrp != null) {
            if (witijibrp.isOptional()) return null;
            return witijibrp.absolute();
        }
        return witijibrpValue;
    }

    protected void setWitijibrpValue(BigDecimal value) {
        witijibrpValue = value;
        witijibrp = Optional.fromNullable(toCurrencyType(witijibrpType))
            .transform(bizCurrencyTransformer(getWitijibrpValue()))
            .orNull();
    }

    transient private String witijibrpType = null;

    @Column(name=WITIJIBRP + "$", nullable=true)
    protected String getWitijibrpType() {
        if (witijibrpType == null && witijibrp != null) return witijibrp.getType().toString();
        if (witijibrpType == null && getWitijibrpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'witijibrp$' should not be NULL."));
        }
        return witijibrpType;
    }

    protected void setWitijibrpType(String type) {
        witijibrpType = type;
        witijibrp = Optional.fromNullable(toCurrencyType(witijibrpType))
            .transform(bizCurrencyTransformer(getWitijibrpValue()))
            .orNull();
    }

    private C_Tuukasyu wyenhrkgktuktype;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.WYENHRKGKTUKTYPE)
    public C_Tuukasyu getWyenhrkgktuktype() {
        return wyenhrkgktuktype;
    }

    public void setWyenhrkgktuktype(C_Tuukasyu pWyenhrkgktuktype) {
        wyenhrkgktuktype = pWyenhrkgktuktype;
    }

    private BizCurrency wyenhrkgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getWyenhrkgk() {
        return wyenhrkgk;
    }

    public void setWyenhrkgk(BizCurrency pWyenhrkgk) {
        wyenhrkgk = pWyenhrkgk;
        wyenhrkgkValue = null;
        wyenhrkgkType  = null;
    }

    transient private BigDecimal wyenhrkgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=WYENHRKGK, nullable=true)
    protected BigDecimal getWyenhrkgkValue() {
        if (wyenhrkgkValue == null && wyenhrkgk != null) {
            if (wyenhrkgk.isOptional()) return null;
            return wyenhrkgk.absolute();
        }
        return wyenhrkgkValue;
    }

    protected void setWyenhrkgkValue(BigDecimal value) {
        wyenhrkgkValue = value;
        wyenhrkgk = Optional.fromNullable(toCurrencyType(wyenhrkgkType))
            .transform(bizCurrencyTransformer(getWyenhrkgkValue()))
            .orNull();
    }

    transient private String wyenhrkgkType = null;

    @Column(name=WYENHRKGK + "$", nullable=true)
    protected String getWyenhrkgkType() {
        if (wyenhrkgkType == null && wyenhrkgk != null) return wyenhrkgk.getType().toString();
        if (wyenhrkgkType == null && getWyenhrkgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'wyenhrkgk$' should not be NULL."));
        }
        return wyenhrkgkType;
    }

    protected void setWyenhrkgkType(String type) {
        wyenhrkgkType = type;
        wyenhrkgk = Optional.fromNullable(toCurrencyType(wyenhrkgkType))
            .transform(bizCurrencyTransformer(getWyenhrkgkValue()))
            .orNull();
    }

    private C_Tuukasyu wyenitijibrptuktype;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyouken.WYENITIJIBRPTUKTYPE)
    public C_Tuukasyu getWyenitijibrptuktype() {
        return wyenitijibrptuktype;
    }

    public void setWyenitijibrptuktype(C_Tuukasyu pWyenitijibrptuktype) {
        wyenitijibrptuktype = pWyenitijibrptuktype;
    }

    private BizCurrency wyenitijibrp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getWyenitijibrp() {
        return wyenitijibrp;
    }

    public void setWyenitijibrp(BizCurrency pWyenitijibrp) {
        wyenitijibrp = pWyenitijibrp;
        wyenitijibrpValue = null;
        wyenitijibrpType  = null;
    }

    transient private BigDecimal wyenitijibrpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=WYENITIJIBRP, nullable=true)
    protected BigDecimal getWyenitijibrpValue() {
        if (wyenitijibrpValue == null && wyenitijibrp != null) {
            if (wyenitijibrp.isOptional()) return null;
            return wyenitijibrp.absolute();
        }
        return wyenitijibrpValue;
    }

    protected void setWyenitijibrpValue(BigDecimal value) {
        wyenitijibrpValue = value;
        wyenitijibrp = Optional.fromNullable(toCurrencyType(wyenitijibrpType))
            .transform(bizCurrencyTransformer(getWyenitijibrpValue()))
            .orNull();
    }

    transient private String wyenitijibrpType = null;

    @Column(name=WYENITIJIBRP + "$", nullable=true)
    protected String getWyenitijibrpType() {
        if (wyenitijibrpType == null && wyenitijibrp != null) return wyenitijibrp.getType().toString();
        if (wyenitijibrpType == null && getWyenitijibrpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'wyenitijibrp$' should not be NULL."));
        }
        return wyenitijibrpType;
    }

    protected void setWyenitijibrpType(String type) {
        wyenitijibrpType = type;
        wyenitijibrp = Optional.fromNullable(toCurrencyType(wyenitijibrpType))
            .transform(bizCurrencyTransformer(getWyenitijibrpValue()))
            .orNull();
    }

    private String koujyosyoumeimsgcd1;

    @Column(name=GenIT_BAK_HokenSyouken.KOUJYOSYOUMEIMSGCD1)
    public String getKoujyosyoumeimsgcd1() {
        return koujyosyoumeimsgcd1;
    }

    public void setKoujyosyoumeimsgcd1(String pKoujyosyoumeimsgcd1) {
        koujyosyoumeimsgcd1 = pKoujyosyoumeimsgcd1;
    }

    private String koujyosyoumeimsgcd2;

    @Column(name=GenIT_BAK_HokenSyouken.KOUJYOSYOUMEIMSGCD2)
    public String getKoujyosyoumeimsgcd2() {
        return koujyosyoumeimsgcd2;
    }

    public void setKoujyosyoumeimsgcd2(String pKoujyosyoumeimsgcd2) {
        koujyosyoumeimsgcd2 = pKoujyosyoumeimsgcd2;
    }

    private String koujyosyoumeimsgcd3;

    @Column(name=GenIT_BAK_HokenSyouken.KOUJYOSYOUMEIMSGCD3)
    public String getKoujyosyoumeimsgcd3() {
        return koujyosyoumeimsgcd3;
    }

    public void setKoujyosyoumeimsgcd3(String pKoujyosyoumeimsgcd3) {
        koujyosyoumeimsgcd3 = pKoujyosyoumeimsgcd3;
    }

    private String koujyosyoumeihskmsgcd;

    @Column(name=GenIT_BAK_HokenSyouken.KOUJYOSYOUMEIHSKMSGCD)
    public String getKoujyosyoumeihskmsgcd() {
        return koujyosyoumeihskmsgcd;
    }

    public void setKoujyosyoumeihskmsgcd(String pKoujyosyoumeihskmsgcd) {
        koujyosyoumeihskmsgcd = pKoujyosyoumeihskmsgcd;
    }

    private String nenkoujyosyoumeihskmsgcd;

    @Column(name=GenIT_BAK_HokenSyouken.NENKOUJYOSYOUMEIHSKMSGCD)
    public String getNenkoujyosyoumeihskmsgcd() {
        return nenkoujyosyoumeihskmsgcd;
    }

    public void setNenkoujyosyoumeihskmsgcd(String pNenkoujyosyoumeihskmsgcd) {
        nenkoujyosyoumeihskmsgcd = pNenkoujyosyoumeihskmsgcd;
    }

    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn1;

    @Type(type="UserType_C_TokusyuSyoriNaiyouKbn")
    @Column(name=GenIT_BAK_HokenSyouken.TOKUSYUSYORINAIYOUKBN1)
    public C_TokusyuSyoriNaiyouKbn getTokusyusyorinaiyoukbn1() {
        return tokusyusyorinaiyoukbn1;
    }

    public void setTokusyusyorinaiyoukbn1(C_TokusyuSyoriNaiyouKbn pTokusyusyorinaiyoukbn1) {
        tokusyusyorinaiyoukbn1 = pTokusyusyorinaiyoukbn1;
    }

    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn2;

    @Type(type="UserType_C_TokusyuSyoriNaiyouKbn")
    @Column(name=GenIT_BAK_HokenSyouken.TOKUSYUSYORINAIYOUKBN2)
    public C_TokusyuSyoriNaiyouKbn getTokusyusyorinaiyoukbn2() {
        return tokusyusyorinaiyoukbn2;
    }

    public void setTokusyusyorinaiyoukbn2(C_TokusyuSyoriNaiyouKbn pTokusyusyorinaiyoukbn2) {
        tokusyusyorinaiyoukbn2 = pTokusyusyorinaiyoukbn2;
    }

    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn3;

    @Type(type="UserType_C_TokusyuSyoriNaiyouKbn")
    @Column(name=GenIT_BAK_HokenSyouken.TOKUSYUSYORINAIYOUKBN3)
    public C_TokusyuSyoriNaiyouKbn getTokusyusyorinaiyoukbn3() {
        return tokusyusyorinaiyoukbn3;
    }

    public void setTokusyusyorinaiyoukbn3(C_TokusyuSyoriNaiyouKbn pTokusyusyorinaiyoukbn3) {
        tokusyusyorinaiyoukbn3 = pTokusyusyorinaiyoukbn3;
    }

    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn4;

    @Type(type="UserType_C_TokusyuSyoriNaiyouKbn")
    @Column(name=GenIT_BAK_HokenSyouken.TOKUSYUSYORINAIYOUKBN4)
    public C_TokusyuSyoriNaiyouKbn getTokusyusyorinaiyoukbn4() {
        return tokusyusyorinaiyoukbn4;
    }

    public void setTokusyusyorinaiyoukbn4(C_TokusyuSyoriNaiyouKbn pTokusyusyorinaiyoukbn4) {
        tokusyusyorinaiyoukbn4 = pTokusyusyorinaiyoukbn4;
    }

    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn5;

    @Type(type="UserType_C_TokusyuSyoriNaiyouKbn")
    @Column(name=GenIT_BAK_HokenSyouken.TOKUSYUSYORINAIYOUKBN5)
    public C_TokusyuSyoriNaiyouKbn getTokusyusyorinaiyoukbn5() {
        return tokusyusyorinaiyoukbn5;
    }

    public void setTokusyusyorinaiyoukbn5(C_TokusyuSyoriNaiyouKbn pTokusyusyorinaiyoukbn5) {
        tokusyusyorinaiyoukbn5 = pTokusyusyorinaiyoukbn5;
    }

    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn6;

    @Type(type="UserType_C_TokusyuSyoriNaiyouKbn")
    @Column(name=GenIT_BAK_HokenSyouken.TOKUSYUSYORINAIYOUKBN6)
    public C_TokusyuSyoriNaiyouKbn getTokusyusyorinaiyoukbn6() {
        return tokusyusyorinaiyoukbn6;
    }

    public void setTokusyusyorinaiyoukbn6(C_TokusyuSyoriNaiyouKbn pTokusyusyorinaiyoukbn6) {
        tokusyusyorinaiyoukbn6 = pTokusyusyorinaiyoukbn6;
    }

    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn7;

    @Type(type="UserType_C_TokusyuSyoriNaiyouKbn")
    @Column(name=GenIT_BAK_HokenSyouken.TOKUSYUSYORINAIYOUKBN7)
    public C_TokusyuSyoriNaiyouKbn getTokusyusyorinaiyoukbn7() {
        return tokusyusyorinaiyoukbn7;
    }

    public void setTokusyusyorinaiyoukbn7(C_TokusyuSyoriNaiyouKbn pTokusyusyorinaiyoukbn7) {
        tokusyusyorinaiyoukbn7 = pTokusyusyorinaiyoukbn7;
    }

    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn8;

    @Type(type="UserType_C_TokusyuSyoriNaiyouKbn")
    @Column(name=GenIT_BAK_HokenSyouken.TOKUSYUSYORINAIYOUKBN8)
    public C_TokusyuSyoriNaiyouKbn getTokusyusyorinaiyoukbn8() {
        return tokusyusyorinaiyoukbn8;
    }

    public void setTokusyusyorinaiyoukbn8(C_TokusyuSyoriNaiyouKbn pTokusyusyorinaiyoukbn8) {
        tokusyusyorinaiyoukbn8 = pTokusyusyorinaiyoukbn8;
    }

    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn9;

    @Type(type="UserType_C_TokusyuSyoriNaiyouKbn")
    @Column(name=GenIT_BAK_HokenSyouken.TOKUSYUSYORINAIYOUKBN9)
    public C_TokusyuSyoriNaiyouKbn getTokusyusyorinaiyoukbn9() {
        return tokusyusyorinaiyoukbn9;
    }

    public void setTokusyusyorinaiyoukbn9(C_TokusyuSyoriNaiyouKbn pTokusyusyorinaiyoukbn9) {
        tokusyusyorinaiyoukbn9 = pTokusyusyorinaiyoukbn9;
    }

    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn10;

    @Type(type="UserType_C_TokusyuSyoriNaiyouKbn")
    @Column(name=GenIT_BAK_HokenSyouken.TOKUSYUSYORINAIYOUKBN10)
    public C_TokusyuSyoriNaiyouKbn getTokusyusyorinaiyoukbn10() {
        return tokusyusyorinaiyoukbn10;
    }

    public void setTokusyusyorinaiyoukbn10(C_TokusyuSyoriNaiyouKbn pTokusyusyorinaiyoukbn10) {
        tokusyusyorinaiyoukbn10 = pTokusyusyorinaiyoukbn10;
    }

    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn11;

    @Type(type="UserType_C_TokusyuSyoriNaiyouKbn")
    @Column(name=GenIT_BAK_HokenSyouken.TOKUSYUSYORINAIYOUKBN11)
    public C_TokusyuSyoriNaiyouKbn getTokusyusyorinaiyoukbn11() {
        return tokusyusyorinaiyoukbn11;
    }

    public void setTokusyusyorinaiyoukbn11(C_TokusyuSyoriNaiyouKbn pTokusyusyorinaiyoukbn11) {
        tokusyusyorinaiyoukbn11 = pTokusyusyorinaiyoukbn11;
    }

    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn12;

    @Type(type="UserType_C_TokusyuSyoriNaiyouKbn")
    @Column(name=GenIT_BAK_HokenSyouken.TOKUSYUSYORINAIYOUKBN12)
    public C_TokusyuSyoriNaiyouKbn getTokusyusyorinaiyoukbn12() {
        return tokusyusyorinaiyoukbn12;
    }

    public void setTokusyusyorinaiyoukbn12(C_TokusyuSyoriNaiyouKbn pTokusyusyorinaiyoukbn12) {
        tokusyusyorinaiyoukbn12 = pTokusyusyorinaiyoukbn12;
    }

    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn13;

    @Type(type="UserType_C_TokusyuSyoriNaiyouKbn")
    @Column(name=GenIT_BAK_HokenSyouken.TOKUSYUSYORINAIYOUKBN13)
    public C_TokusyuSyoriNaiyouKbn getTokusyusyorinaiyoukbn13() {
        return tokusyusyorinaiyoukbn13;
    }

    public void setTokusyusyorinaiyoukbn13(C_TokusyuSyoriNaiyouKbn pTokusyusyorinaiyoukbn13) {
        tokusyusyorinaiyoukbn13 = pTokusyusyorinaiyoukbn13;
    }

    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn14;

    @Type(type="UserType_C_TokusyuSyoriNaiyouKbn")
    @Column(name=GenIT_BAK_HokenSyouken.TOKUSYUSYORINAIYOUKBN14)
    public C_TokusyuSyoriNaiyouKbn getTokusyusyorinaiyoukbn14() {
        return tokusyusyorinaiyoukbn14;
    }

    public void setTokusyusyorinaiyoukbn14(C_TokusyuSyoriNaiyouKbn pTokusyusyorinaiyoukbn14) {
        tokusyusyorinaiyoukbn14 = pTokusyusyorinaiyoukbn14;
    }

    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn15;

    @Type(type="UserType_C_TokusyuSyoriNaiyouKbn")
    @Column(name=GenIT_BAK_HokenSyouken.TOKUSYUSYORINAIYOUKBN15)
    public C_TokusyuSyoriNaiyouKbn getTokusyusyorinaiyoukbn15() {
        return tokusyusyorinaiyoukbn15;
    }

    public void setTokusyusyorinaiyoukbn15(C_TokusyuSyoriNaiyouKbn pTokusyusyorinaiyoukbn15) {
        tokusyusyorinaiyoukbn15 = pTokusyusyorinaiyoukbn15;
    }

    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn16;

    @Type(type="UserType_C_TokusyuSyoriNaiyouKbn")
    @Column(name=GenIT_BAK_HokenSyouken.TOKUSYUSYORINAIYOUKBN16)
    public C_TokusyuSyoriNaiyouKbn getTokusyusyorinaiyoukbn16() {
        return tokusyusyorinaiyoukbn16;
    }

    public void setTokusyusyorinaiyoukbn16(C_TokusyuSyoriNaiyouKbn pTokusyusyorinaiyoukbn16) {
        tokusyusyorinaiyoukbn16 = pTokusyusyorinaiyoukbn16;
    }

    private C_TokusyuSyoriNaiyouKbn tokusyusyorinaiyoukbn17;

    @Type(type="UserType_C_TokusyuSyoriNaiyouKbn")
    @Column(name=GenIT_BAK_HokenSyouken.TOKUSYUSYORINAIYOUKBN17)
    public C_TokusyuSyoriNaiyouKbn getTokusyusyorinaiyoukbn17() {
        return tokusyusyorinaiyoukbn17;
    }

    public void setTokusyusyorinaiyoukbn17(C_TokusyuSyoriNaiyouKbn pTokusyusyorinaiyoukbn17) {
        tokusyusyorinaiyoukbn17 = pTokusyusyorinaiyoukbn17;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_HokenSyouken.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_HokenSyouken.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_HokenSyouken.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private String kyknmkn;

    @Column(name=GenIT_BAK_HokenSyouken.KYKNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKyknmkn() {
        return kyknmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKyknmkn(String pKyknmkn) {
        kyknmkn = pKyknmkn;
    }

    private String hhknnmkn;

    @Column(name=GenIT_BAK_HokenSyouken.HHKNNMKN)
    @MaxLength(max=18)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getHhknnmkn() {
        return hhknnmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkn(String pHhknnmkn) {
        hhknnmkn = pHhknnmkn;
    }

    private BizDate sonotanyrannkshrstartymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.SONOTANYRANNKSHRSTARTYMD)
    public BizDate getSonotanyrannkshrstartymd() {
        return sonotanyrannkshrstartymd;
    }

    public void setSonotanyrannkshrstartymd(BizDate pSonotanyrannkshrstartymd) {
        sonotanyrannkshrstartymd = pSonotanyrannkshrstartymd;
    }

    private BizNumber sonotanyrannenkinkkn;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.SONOTANYRANNENKINKKN)
    public BizNumber getSonotanyrannenkinkkn() {
        return sonotanyrannenkinkkn;
    }

    public void setSonotanyrannenkinkkn(BizNumber pSonotanyrannenkinkkn) {
        sonotanyrannenkinkkn = pSonotanyrannenkinkkn;
    }

    private BizDate sonotanyranyensysnhkhnkymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.SONOTANYRANYENSYSNHKHNKYMD)
    public BizDate getSonotanyranyensysnhkhnkymd() {
        return sonotanyranyensysnhkhnkymd;
    }

    public void setSonotanyranyensysnhkhnkymd(BizDate pSonotanyranyensysnhkhnkymd) {
        sonotanyranyensysnhkhnkymd = pSonotanyranyensysnhkhnkymd;
    }

    private BizNumber sonotanyrantumitateriritu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.SONOTANYRANTUMITATERIRITU)
    public BizNumber getSonotanyrantumitateriritu() {
        return sonotanyrantumitateriritu;
    }

    public void setSonotanyrantumitateriritu(BizNumber pSonotanyrantumitateriritu) {
        sonotanyrantumitateriritu = pSonotanyrantumitateriritu;
    }

    private BizNumber sonotanyrantmttknzkrtjygn;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.SONOTANYRANTMTTKNZKRTJYGN)
    public BizNumber getSonotanyrantmttknzkrtjygn() {
        return sonotanyrantmttknzkrtjygn;
    }

    public void setSonotanyrantmttknzkrtjygn(BizNumber pSonotanyrantmttknzkrtjygn) {
        sonotanyrantmttknzkrtjygn = pSonotanyrantmttknzkrtjygn;
    }

    private BizNumber sonotanyransetteibairitu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.SONOTANYRANSETTEIBAIRITU)
    public BizNumber getSonotanyransetteibairitu() {
        return sonotanyransetteibairitu;
    }

    public void setSonotanyransetteibairitu(BizNumber pSonotanyransetteibairitu) {
        sonotanyransetteibairitu = pSonotanyransetteibairitu;
    }

    private String sonotanyrantmttkngktuktype;

    @Column(name=GenIT_BAK_HokenSyouken.SONOTANYRANTMTTKNGKTUKTYPE)
    public String getSonotanyrantmttkngktuktype() {
        return sonotanyrantmttkngktuktype;
    }

    public void setSonotanyrantmttkngktuktype(String pSonotanyrantmttkngktuktype) {
        sonotanyrantmttkngktuktype = pSonotanyrantmttkngktuktype;
    }

    private BizCurrency sonotanyranteiritutmttkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSonotanyranteiritutmttkngk() {
        return sonotanyranteiritutmttkngk;
    }

    public void setSonotanyranteiritutmttkngk(BizCurrency pSonotanyranteiritutmttkngk) {
        sonotanyranteiritutmttkngk = pSonotanyranteiritutmttkngk;
        sonotanyranteiritutmttkngkValue = null;
        sonotanyranteiritutmttkngkType  = null;
    }

    transient private BigDecimal sonotanyranteiritutmttkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SONOTANYRANTEIRITUTMTTKNGK, nullable=true)
    protected BigDecimal getSonotanyranteiritutmttkngkValue() {
        if (sonotanyranteiritutmttkngkValue == null && sonotanyranteiritutmttkngk != null) {
            if (sonotanyranteiritutmttkngk.isOptional()) return null;
            return sonotanyranteiritutmttkngk.absolute();
        }
        return sonotanyranteiritutmttkngkValue;
    }

    protected void setSonotanyranteiritutmttkngkValue(BigDecimal value) {
        sonotanyranteiritutmttkngkValue = value;
        sonotanyranteiritutmttkngk = Optional.fromNullable(toCurrencyType(sonotanyranteiritutmttkngkType))
            .transform(bizCurrencyTransformer(getSonotanyranteiritutmttkngkValue()))
            .orNull();
    }

    transient private String sonotanyranteiritutmttkngkType = null;

    @Column(name=SONOTANYRANTEIRITUTMTTKNGK + "$", nullable=true)
    protected String getSonotanyranteiritutmttkngkType() {
        if (sonotanyranteiritutmttkngkType == null && sonotanyranteiritutmttkngk != null) return sonotanyranteiritutmttkngk.getType().toString();
        if (sonotanyranteiritutmttkngkType == null && getSonotanyranteiritutmttkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sonotanyranteiritutmttkngk$' should not be NULL."));
        }
        return sonotanyranteiritutmttkngkType;
    }

    protected void setSonotanyranteiritutmttkngkType(String type) {
        sonotanyranteiritutmttkngkType = type;
        sonotanyranteiritutmttkngk = Optional.fromNullable(toCurrencyType(sonotanyranteiritutmttkngkType))
            .transform(bizCurrencyTransformer(getSonotanyranteiritutmttkngkValue()))
            .orNull();
    }

    private BizCurrency sonotanyransisuutmttkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSonotanyransisuutmttkngk() {
        return sonotanyransisuutmttkngk;
    }

    public void setSonotanyransisuutmttkngk(BizCurrency pSonotanyransisuutmttkngk) {
        sonotanyransisuutmttkngk = pSonotanyransisuutmttkngk;
        sonotanyransisuutmttkngkValue = null;
        sonotanyransisuutmttkngkType  = null;
    }

    transient private BigDecimal sonotanyransisuutmttkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SONOTANYRANSISUUTMTTKNGK, nullable=true)
    protected BigDecimal getSonotanyransisuutmttkngkValue() {
        if (sonotanyransisuutmttkngkValue == null && sonotanyransisuutmttkngk != null) {
            if (sonotanyransisuutmttkngk.isOptional()) return null;
            return sonotanyransisuutmttkngk.absolute();
        }
        return sonotanyransisuutmttkngkValue;
    }

    protected void setSonotanyransisuutmttkngkValue(BigDecimal value) {
        sonotanyransisuutmttkngkValue = value;
        sonotanyransisuutmttkngk = Optional.fromNullable(toCurrencyType(sonotanyransisuutmttkngkType))
            .transform(bizCurrencyTransformer(getSonotanyransisuutmttkngkValue()))
            .orNull();
    }

    transient private String sonotanyransisuutmttkngkType = null;

    @Column(name=SONOTANYRANSISUUTMTTKNGK + "$", nullable=true)
    protected String getSonotanyransisuutmttkngkType() {
        if (sonotanyransisuutmttkngkType == null && sonotanyransisuutmttkngk != null) return sonotanyransisuutmttkngk.getType().toString();
        if (sonotanyransisuutmttkngkType == null && getSonotanyransisuutmttkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sonotanyransisuutmttkngk$' should not be NULL."));
        }
        return sonotanyransisuutmttkngkType;
    }

    protected void setSonotanyransisuutmttkngkType(String type) {
        sonotanyransisuutmttkngkType = type;
        sonotanyransisuutmttkngk = Optional.fromNullable(toCurrencyType(sonotanyransisuutmttkngkType))
            .transform(bizCurrencyTransformer(getSonotanyransisuutmttkngkValue()))
            .orNull();
    }

    private String sonotanyransisuunm;

    @Column(name=GenIT_BAK_HokenSyouken.SONOTANYRANSISUUNM)
    public String getSonotanyransisuunm() {
        return sonotanyransisuunm;
    }

    public void setSonotanyransisuunm(String pSonotanyransisuunm) {
        sonotanyransisuunm = pSonotanyransisuunm;
    }

    private BizDate kgmaehrtkdai1hknkknmnryymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyouken.KGMAEHRTKDAI1HKNKKNMNRYYMD)
    public BizDate getKgmaehrtkdai1hknkknmnryymd() {
        return kgmaehrtkdai1hknkknmnryymd;
    }

    public void setKgmaehrtkdai1hknkknmnryymd(BizDate pKgmaehrtkdai1hknkknmnryymd) {
        kgmaehrtkdai1hknkknmnryymd = pKgmaehrtkdai1hknkknmnryymd;
    }

    private String nkmsgcd1;

    @Column(name=GenIT_BAK_HokenSyouken.NKMSGCD1)
    public String getNkmsgcd1() {
        return nkmsgcd1;
    }

    public void setNkmsgcd1(String pNkmsgcd1) {
        nkmsgcd1 = pNkmsgcd1;
    }

    private String nkmsgcd2;

    @Column(name=GenIT_BAK_HokenSyouken.NKMSGCD2)
    public String getNkmsgcd2() {
        return nkmsgcd2;
    }

    public void setNkmsgcd2(String pNkmsgcd2) {
        nkmsgcd2 = pNkmsgcd2;
    }

    private String nkmsgcd3;

    @Column(name=GenIT_BAK_HokenSyouken.NKMSGCD3)
    public String getNkmsgcd3() {
        return nkmsgcd3;
    }

    public void setNkmsgcd3(String pNkmsgcd3) {
        nkmsgcd3 = pNkmsgcd3;
    }

    private String nkmsgcd4;

    @Column(name=GenIT_BAK_HokenSyouken.NKMSGCD4)
    public String getNkmsgcd4() {
        return nkmsgcd4;
    }

    public void setNkmsgcd4(String pNkmsgcd4) {
        nkmsgcd4 = pNkmsgcd4;
    }

    private String nkmsgcd5;

    @Column(name=GenIT_BAK_HokenSyouken.NKMSGCD5)
    public String getNkmsgcd5() {
        return nkmsgcd5;
    }

    public void setNkmsgcd5(String pNkmsgcd5) {
        nkmsgcd5 = pNkmsgcd5;
    }

    private String nkmsgcd6;

    @Column(name=GenIT_BAK_HokenSyouken.NKMSGCD6)
    public String getNkmsgcd6() {
        return nkmsgcd6;
    }

    public void setNkmsgcd6(String pNkmsgcd6) {
        nkmsgcd6 = pNkmsgcd6;
    }

    private String nkmsgcd7;

    @Column(name=GenIT_BAK_HokenSyouken.NKMSGCD7)
    public String getNkmsgcd7() {
        return nkmsgcd7;
    }

    public void setNkmsgcd7(String pNkmsgcd7) {
        nkmsgcd7 = pNkmsgcd7;
    }

    private String nkmsgcd8;

    @Column(name=GenIT_BAK_HokenSyouken.NKMSGCD8)
    public String getNkmsgcd8() {
        return nkmsgcd8;
    }

    public void setNkmsgcd8(String pNkmsgcd8) {
        nkmsgcd8 = pNkmsgcd8;
    }

    private String nkmsgcd9;

    @Column(name=GenIT_BAK_HokenSyouken.NKMSGCD9)
    public String getNkmsgcd9() {
        return nkmsgcd9;
    }

    public void setNkmsgcd9(String pNkmsgcd9) {
        nkmsgcd9 = pNkmsgcd9;
    }

    private String nkmsgcd10;

    @Column(name=GenIT_BAK_HokenSyouken.NKMSGCD10)
    public String getNkmsgcd10() {
        return nkmsgcd10;
    }

    public void setNkmsgcd10(String pNkmsgcd10) {
        nkmsgcd10 = pNkmsgcd10;
    }

    private String siboukyuuhukinmsgcd1;

    @Column(name=GenIT_BAK_HokenSyouken.SIBOUKYUUHUKINMSGCD1)
    public String getSiboukyuuhukinmsgcd1() {
        return siboukyuuhukinmsgcd1;
    }

    public void setSiboukyuuhukinmsgcd1(String pSiboukyuuhukinmsgcd1) {
        siboukyuuhukinmsgcd1 = pSiboukyuuhukinmsgcd1;
    }

    private String siboukyuuhukinmsgcd2;

    @Column(name=GenIT_BAK_HokenSyouken.SIBOUKYUUHUKINMSGCD2)
    public String getSiboukyuuhukinmsgcd2() {
        return siboukyuuhukinmsgcd2;
    }

    public void setSiboukyuuhukinmsgcd2(String pSiboukyuuhukinmsgcd2) {
        siboukyuuhukinmsgcd2 = pSiboukyuuhukinmsgcd2;
    }

    private String siboukyuuhukinmsgcd3;

    @Column(name=GenIT_BAK_HokenSyouken.SIBOUKYUUHUKINMSGCD3)
    public String getSiboukyuuhukinmsgcd3() {
        return siboukyuuhukinmsgcd3;
    }

    public void setSiboukyuuhukinmsgcd3(String pSiboukyuuhukinmsgcd3) {
        siboukyuuhukinmsgcd3 = pSiboukyuuhukinmsgcd3;
    }

    private String siboukyuuhukinmsgcd4;

    @Column(name=GenIT_BAK_HokenSyouken.SIBOUKYUUHUKINMSGCD4)
    public String getSiboukyuuhukinmsgcd4() {
        return siboukyuuhukinmsgcd4;
    }

    public void setSiboukyuuhukinmsgcd4(String pSiboukyuuhukinmsgcd4) {
        siboukyuuhukinmsgcd4 = pSiboukyuuhukinmsgcd4;
    }

    private String siboukyuuhukinmsgcd5;

    @Column(name=GenIT_BAK_HokenSyouken.SIBOUKYUUHUKINMSGCD5)
    public String getSiboukyuuhukinmsgcd5() {
        return siboukyuuhukinmsgcd5;
    }

    public void setSiboukyuuhukinmsgcd5(String pSiboukyuuhukinmsgcd5) {
        siboukyuuhukinmsgcd5 = pSiboukyuuhukinmsgcd5;
    }

    private String siboukyuuhukinmsgcd6;

    @Column(name=GenIT_BAK_HokenSyouken.SIBOUKYUUHUKINMSGCD6)
    public String getSiboukyuuhukinmsgcd6() {
        return siboukyuuhukinmsgcd6;
    }

    public void setSiboukyuuhukinmsgcd6(String pSiboukyuuhukinmsgcd6) {
        siboukyuuhukinmsgcd6 = pSiboukyuuhukinmsgcd6;
    }

    private String siboukyuuhukinmsgcd7;

    @Column(name=GenIT_BAK_HokenSyouken.SIBOUKYUUHUKINMSGCD7)
    public String getSiboukyuuhukinmsgcd7() {
        return siboukyuuhukinmsgcd7;
    }

    public void setSiboukyuuhukinmsgcd7(String pSiboukyuuhukinmsgcd7) {
        siboukyuuhukinmsgcd7 = pSiboukyuuhukinmsgcd7;
    }

    private String siboukyuuhukinmsgcd8;

    @Column(name=GenIT_BAK_HokenSyouken.SIBOUKYUUHUKINMSGCD8)
    public String getSiboukyuuhukinmsgcd8() {
        return siboukyuuhukinmsgcd8;
    }

    public void setSiboukyuuhukinmsgcd8(String pSiboukyuuhukinmsgcd8) {
        siboukyuuhukinmsgcd8 = pSiboukyuuhukinmsgcd8;
    }

    private String siboukyuuhukinmsgcd9;

    @Column(name=GenIT_BAK_HokenSyouken.SIBOUKYUUHUKINMSGCD9)
    public String getSiboukyuuhukinmsgcd9() {
        return siboukyuuhukinmsgcd9;
    }

    public void setSiboukyuuhukinmsgcd9(String pSiboukyuuhukinmsgcd9) {
        siboukyuuhukinmsgcd9 = pSiboukyuuhukinmsgcd9;
    }

    private String siboukyuuhukinmsgcd10;

    @Column(name=GenIT_BAK_HokenSyouken.SIBOUKYUUHUKINMSGCD10)
    public String getSiboukyuuhukinmsgcd10() {
        return siboukyuuhukinmsgcd10;
    }

    public void setSiboukyuuhukinmsgcd10(String pSiboukyuuhukinmsgcd10) {
        siboukyuuhukinmsgcd10 = pSiboukyuuhukinmsgcd10;
    }

    private String nkshrstartzenymd;

    @Column(name=GenIT_BAK_HokenSyouken.NKSHRSTARTZENYMD)
    public String getNkshrstartzenymd() {
        return nkshrstartzenymd;
    }

    public void setNkshrstartzenymd(String pNkshrstartzenymd) {
        nkshrstartzenymd = pNkshrstartzenymd;
    }

    private String mkhyouyennkhknhentktype;

    @Column(name=GenIT_BAK_HokenSyouken.MKHYOUYENNKHKNHENTKTYPE)
    public String getMkhyouyennkhknhentktype() {
        return mkhyouyennkhknhentktype;
    }

    public void setMkhyouyennkhknhentktype(String pMkhyouyennkhknhentktype) {
        mkhyouyennkhknhentktype = pMkhyouyennkhknhentktype;
    }

    private BizCurrency mkhyouyennkhknhentkmkhgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMkhyouyennkhknhentkmkhgk() {
        return mkhyouyennkhknhentkmkhgk;
    }

    public void setMkhyouyennkhknhentkmkhgk(BizCurrency pMkhyouyennkhknhentkmkhgk) {
        mkhyouyennkhknhentkmkhgk = pMkhyouyennkhknhentkmkhgk;
        mkhyouyennkhknhentkmkhgkValue = null;
        mkhyouyennkhknhentkmkhgkType  = null;
    }

    transient private BigDecimal mkhyouyennkhknhentkmkhgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MKHYOUYENNKHKNHENTKMKHGK, nullable=true)
    protected BigDecimal getMkhyouyennkhknhentkmkhgkValue() {
        if (mkhyouyennkhknhentkmkhgkValue == null && mkhyouyennkhknhentkmkhgk != null) {
            if (mkhyouyennkhknhentkmkhgk.isOptional()) return null;
            return mkhyouyennkhknhentkmkhgk.absolute();
        }
        return mkhyouyennkhknhentkmkhgkValue;
    }

    protected void setMkhyouyennkhknhentkmkhgkValue(BigDecimal value) {
        mkhyouyennkhknhentkmkhgkValue = value;
        mkhyouyennkhknhentkmkhgk = Optional.fromNullable(toCurrencyType(mkhyouyennkhknhentkmkhgkType))
            .transform(bizCurrencyTransformer(getMkhyouyennkhknhentkmkhgkValue()))
            .orNull();
    }

    transient private String mkhyouyennkhknhentkmkhgkType = null;

    @Column(name=MKHYOUYENNKHKNHENTKMKHGK + "$", nullable=true)
    protected String getMkhyouyennkhknhentkmkhgkType() {
        if (mkhyouyennkhknhentkmkhgkType == null && mkhyouyennkhknhentkmkhgk != null) return mkhyouyennkhknhentkmkhgk.getType().toString();
        if (mkhyouyennkhknhentkmkhgkType == null && getMkhyouyennkhknhentkmkhgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mkhyouyennkhknhentkmkhgk$' should not be NULL."));
        }
        return mkhyouyennkhknhentkmkhgkType;
    }

    protected void setMkhyouyennkhknhentkmkhgkType(String type) {
        mkhyouyennkhknhentkmkhgkType = type;
        mkhyouyennkhknhentkmkhgk = Optional.fromNullable(toCurrencyType(mkhyouyennkhknhentkmkhgkType))
            .transform(bizCurrencyTransformer(getMkhyouyennkhknhentkmkhgkValue()))
            .orNull();
    }

    private BizNumber mkhyouyennkhknhentkmkhwari;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.MKHYOUYENNKHKNHENTKMKHWARI)
    public BizNumber getMkhyouyennkhknhentkmkhwari() {
        return mkhyouyennkhknhentkmkhwari;
    }

    public void setMkhyouyennkhknhentkmkhwari(BizNumber pMkhyouyennkhknhentkmkhwari) {
        mkhyouyennkhknhentkmkhwari = pMkhyouyennkhknhentkmkhwari;
    }

    private String haibunwarimsgcd1;

    @Column(name=GenIT_BAK_HokenSyouken.HAIBUNWARIMSGCD1)
    public String getHaibunwarimsgcd1() {
        return haibunwarimsgcd1;
    }

    public void setHaibunwarimsgcd1(String pHaibunwarimsgcd1) {
        haibunwarimsgcd1 = pHaibunwarimsgcd1;
    }

    private String haibunwarimsgcd2;

    @Column(name=GenIT_BAK_HokenSyouken.HAIBUNWARIMSGCD2)
    public String getHaibunwarimsgcd2() {
        return haibunwarimsgcd2;
    }

    public void setHaibunwarimsgcd2(String pHaibunwarimsgcd2) {
        haibunwarimsgcd2 = pHaibunwarimsgcd2;
    }

    private String haibunwarimsgcd3;

    @Column(name=GenIT_BAK_HokenSyouken.HAIBUNWARIMSGCD3)
    public String getHaibunwarimsgcd3() {
        return haibunwarimsgcd3;
    }

    public void setHaibunwarimsgcd3(String pHaibunwarimsgcd3) {
        haibunwarimsgcd3 = pHaibunwarimsgcd3;
    }

    private BizNumber teiritutmtthbnwr;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.TEIRITUTMTTHBNWR)
    public BizNumber getTeiritutmtthbnwr() {
        return teiritutmtthbnwr;
    }

    public void setTeiritutmtthbnwr(BizNumber pTeiritutmtthbnwr) {
        teiritutmtthbnwr = pTeiritutmtthbnwr;
    }

    private BizNumber sisuutmtthbnwr;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.SISUUTMTTHBNWR)
    public BizNumber getSisuutmtthbnwr() {
        return sisuutmtthbnwr;
    }

    public void setSisuutmtthbnwr(BizNumber pSisuutmtthbnwr) {
        sisuutmtthbnwr = pSisuutmtthbnwr;
    }

    private String sisuuannaimsg1;

    @Column(name=GenIT_BAK_HokenSyouken.SISUUANNAIMSG1)
    public String getSisuuannaimsg1() {
        return sisuuannaimsg1;
    }

    public void setSisuuannaimsg1(String pSisuuannaimsg1) {
        sisuuannaimsg1 = pSisuuannaimsg1;
    }

    private String sisuuannaimsg2;

    @Column(name=GenIT_BAK_HokenSyouken.SISUUANNAIMSG2)
    public String getSisuuannaimsg2() {
        return sisuuannaimsg2;
    }

    public void setSisuuannaimsg2(String pSisuuannaimsg2) {
        sisuuannaimsg2 = pSisuuannaimsg2;
    }

    private String sisuuannaimsg3;

    @Column(name=GenIT_BAK_HokenSyouken.SISUUANNAIMSG3)
    public String getSisuuannaimsg3() {
        return sisuuannaimsg3;
    }

    public void setSisuuannaimsg3(String pSisuuannaimsg3) {
        sisuuannaimsg3 = pSisuuannaimsg3;
    }

    private BizNumber hutanhiyustmytijihiritu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.HUTANHIYUSTMYTIJIHIRITU)
    public BizNumber getHutanhiyustmytijihiritu() {
        return hutanhiyustmytijihiritu;
    }

    public void setHutanhiyustmytijihiritu(BizNumber pHutanhiyustmytijihiritu) {
        hutanhiyustmytijihiritu = pHutanhiyustmytijihiritu;
    }

    private String wmsgcd21;

    @Column(name=GenIT_BAK_HokenSyouken.WMSGCD21)
    public String getWmsgcd21() {
        return wmsgcd21;
    }

    public void setWmsgcd21(String pWmsgcd21) {
        wmsgcd21 = pWmsgcd21;
    }

    private String wmsgcd22;

    @Column(name=GenIT_BAK_HokenSyouken.WMSGCD22)
    public String getWmsgcd22() {
        return wmsgcd22;
    }

    public void setWmsgcd22(String pWmsgcd22) {
        wmsgcd22 = pWmsgcd22;
    }

    private String wmsgcd23;

    @Column(name=GenIT_BAK_HokenSyouken.WMSGCD23)
    public String getWmsgcd23() {
        return wmsgcd23;
    }

    public void setWmsgcd23(String pWmsgcd23) {
        wmsgcd23 = pWmsgcd23;
    }

    private String wmsgcd31;

    @Column(name=GenIT_BAK_HokenSyouken.WMSGCD31)
    public String getWmsgcd31() {
        return wmsgcd31;
    }

    public void setWmsgcd31(String pWmsgcd31) {
        wmsgcd31 = pWmsgcd31;
    }

    private String wmsgcd32;

    @Column(name=GenIT_BAK_HokenSyouken.WMSGCD32)
    public String getWmsgcd32() {
        return wmsgcd32;
    }

    public void setWmsgcd32(String pWmsgcd32) {
        wmsgcd32 = pWmsgcd32;
    }

    private String wmsgcd33;

    @Column(name=GenIT_BAK_HokenSyouken.WMSGCD33)
    public String getWmsgcd33() {
        return wmsgcd33;
    }

    public void setWmsgcd33(String pWmsgcd33) {
        wmsgcd33 = pWmsgcd33;
    }

    private String wmsgcdst1;

    @Column(name=GenIT_BAK_HokenSyouken.WMSGCDST1)
    public String getWmsgcdst1() {
        return wmsgcdst1;
    }

    public void setWmsgcdst1(String pWmsgcdst1) {
        wmsgcdst1 = pWmsgcdst1;
    }

    private String wtyuuijikoumsgcd6;

    @Column(name=GenIT_BAK_HokenSyouken.WTYUUIJIKOUMSGCD6)
    public String getWtyuuijikoumsgcd6() {
        return wtyuuijikoumsgcd6;
    }

    public void setWtyuuijikoumsgcd6(String pWtyuuijikoumsgcd6) {
        wtyuuijikoumsgcd6 = pWtyuuijikoumsgcd6;
    }

    private String wtyuuijikoumsgcd7;

    @Column(name=GenIT_BAK_HokenSyouken.WTYUUIJIKOUMSGCD7)
    public String getWtyuuijikoumsgcd7() {
        return wtyuuijikoumsgcd7;
    }

    public void setWtyuuijikoumsgcd7(String pWtyuuijikoumsgcd7) {
        wtyuuijikoumsgcd7 = pWtyuuijikoumsgcd7;
    }

    private C_TantouCdKbn tantocd;

    @Type(type="UserType_C_TantouCdKbn")
    @Column(name=GenIT_BAK_HokenSyouken.TANTOCD)
    public C_TantouCdKbn getTantocd() {
        return tantocd;
    }

    public void setTantocd(C_TantouCdKbn pTantocd) {
        tantocd = pTantocd;
    }

    private String phrkktuki;

    @Column(name=GenIT_BAK_HokenSyouken.PHRKKTUKI)
    public String getPhrkktuki() {
        return phrkktuki;
    }

    public void setPhrkktuki(String pPhrkktuki) {
        phrkktuki = pPhrkktuki;
    }

    private C_YakkanJyuryouKbn yakkanjyuryouhoukbn;

    @Type(type="UserType_C_YakkanJyuryouKbn")
    @Column(name=GenIT_BAK_HokenSyouken.YAKKANJYURYOUHOUKBN)
    public C_YakkanJyuryouKbn getYakkanjyuryouhoukbn() {
        return yakkanjyuryouhoukbn;
    }

    public void setYakkanjyuryouhoukbn(C_YakkanJyuryouKbn pYakkanjyuryouhoukbn) {
        yakkanjyuryouhoukbn = pYakkanjyuryouhoukbn;
    }

    private String yakkanbunsyono;

    @Column(name=GenIT_BAK_HokenSyouken.YAKKANBUNSYONO)
    public String getYakkanbunsyono() {
        return yakkanbunsyono;
    }

    public void setYakkanbunsyono(String pYakkanbunsyono) {
        yakkanbunsyono = pYakkanbunsyono;
    }

    private String siorino;

    @Column(name=GenIT_BAK_HokenSyouken.SIORINO)
    public String getSiorino() {
        return siorino;
    }

    public void setSiorino(String pSiorino) {
        siorino = pSiorino;
    }

    private String sioriwebuktriannaimsgcd;

    @Column(name=GenIT_BAK_HokenSyouken.SIORIWEBUKTRIANNAIMSGCD)
    public String getSioriwebuktriannaimsgcd() {
        return sioriwebuktriannaimsgcd;
    }

    public void setSioriwebuktriannaimsgcd(String pSioriwebuktriannaimsgcd) {
        sioriwebuktriannaimsgcd = pSioriwebuktriannaimsgcd;
    }

    private String sagyoukbn;

    @Column(name=GenIT_BAK_HokenSyouken.SAGYOUKBN)
    public String getSagyoukbn() {
        return sagyoukbn;
    }

    public void setSagyoukbn(String pSagyoukbn) {
        sagyoukbn = pSagyoukbn;
    }

    private BizNumber sisuuupkaisuu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.SISUUUPKAISUU)
    public BizNumber getSisuuupkaisuu() {
        return sisuuupkaisuu;
    }

    public void setSisuuupkaisuu(BizNumber pSisuuupkaisuu) {
        sisuuupkaisuu = pSisuuupkaisuu;
    }

    private BizNumber sisuudownkaisuu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyouken.SISUUDOWNKAISUU)
    public BizNumber getSisuudownkaisuu() {
        return sisuudownkaisuu;
    }

    public void setSisuudownkaisuu(BizNumber pSisuudownkaisuu) {
        sisuudownkaisuu = pSisuudownkaisuu;
    }
}