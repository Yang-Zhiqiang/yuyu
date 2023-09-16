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
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Htnpkkn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KihonssyuruiKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_SknnkaisikitkKbn;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TokkoudosghtnpKbn;
import yuyu.def.classification.C_TyhyrenrakusikibetuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_SougouTuuti;
import yuyu.def.db.id.PKIT_SougouTuuti;
import yuyu.def.db.meta.GenQIT_SougouTuuti;
import yuyu.def.db.meta.QIT_SougouTuuti;
import yuyu.def.db.type.UserType_C_6daiLdKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_HknkknsmnKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_HrkkknsmnKbn;
import yuyu.def.db.type.UserType_C_Htnpkkn;
import yuyu.def.db.type.UserType_C_KataKbn;
import yuyu.def.db.type.UserType_C_KihonssyuruiKbn;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_KyhgndkataKbn;
import yuyu.def.db.type.UserType_C_PmnjtkKbn;
import yuyu.def.db.type.UserType_C_SknnkaisikitkKbn;
import yuyu.def.db.type.UserType_C_SyukyhkinkataKbn;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_TokkoudosghtnpKbn;
import yuyu.def.db.type.UserType_C_TyhyrenrakusikibetuKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 総合通知テーブル テーブルのマッピング情報クラスで、 {@link IT_SougouTuuti} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_SougouTuuti}</td><td colspan="3">総合通知テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_SougouTuuti ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_SougouTuuti ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">{@link PKIT_SougouTuuti ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTyouhyouprtymd tyouhyouprtymd}</td><td>帳票作成日（印刷用）</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSknnkaisiymd sknnkaisiymd}</td><td>責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyouhnnmsyouken syouhnnmsyouken}</td><td>商品名（証券用）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkj kyknmkj}</td><td>契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknmkjkhukakbn kyknmkjkhukakbn}</td><td>契約者名漢字化不可区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KjkhukaKbn}</td></tr>
 *  <tr><td>{@link #getHhknnmkj hhknnmkj}</td><td>被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnmkjkhukakbn hhknnmkjkhukakbn}</td><td>被保険者名漢字化不可区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KjkhukaKbn}</td></tr>
 *  <tr><td>{@link #getHhknseiymd hhknseiymd}</td><td>被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHhknsei hhknsei}</td><td>被保険者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hhknsei}</td></tr>
 *  <tr><td>{@link #getHhknnen hhknnen}</td><td>被保険者年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSbhenkanuktnmkj sbhenkanuktnmkj}</td><td>死亡返還金受取人氏名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSibouhenkankinuktseiymd sibouhenkankinuktseiymd}</td><td>死亡返還金受取人生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getStdrsknmkj stdrsknmkj}</td><td>指定代理請求人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getStdrskseiymd stdrskseiymd}</td><td>指定代理請求人生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHrkp hrkp}</td><td>払込保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getHrkkeiro hrkkeiro}</td><td>払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getSyutkkbn1 syutkkbn1}</td><td>主契約特約区分_1</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr><td>{@link #getSyutkkbn2 syutkkbn2}</td><td>主契約特約区分_2</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr><td>{@link #getSyutkkbn3 syutkkbn3}</td><td>主契約特約区分_3</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr><td>{@link #getSyutkkbn4 syutkkbn4}</td><td>主契約特約区分_4</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr><td>{@link #getSyutkkbn5 syutkkbn5}</td><td>主契約特約区分_5</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr><td>{@link #getSyutkkbn6 syutkkbn6}</td><td>主契約特約区分_6</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr><td>{@link #getSyutkkbn7 syutkkbn7}</td><td>主契約特約区分_7</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr><td>{@link #getSyutkkbn8 syutkkbn8}</td><td>主契約特約区分_8</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr><td>{@link #getSyutkkbn9 syutkkbn9}</td><td>主契約特約区分_9</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr><td>{@link #getSyutkkbn10 syutkkbn10}</td><td>主契約特約区分_10</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr><td>{@link #getSyouhncd1 syouhncd1}</td><td>商品コード_1</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhncd2 syouhncd2}</td><td>商品コード_2</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhncd3 syouhncd3}</td><td>商品コード_3</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhncd4 syouhncd4}</td><td>商品コード_4</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhncd5 syouhncd5}</td><td>商品コード_5</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhncd6 syouhncd6}</td><td>商品コード_6</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhncd7 syouhncd7}</td><td>商品コード_7</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhncd8 syouhncd8}</td><td>商品コード_8</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhncd9 syouhncd9}</td><td>商品コード_9</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhncd10 syouhncd10}</td><td>商品コード_10</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnsdno1 syouhnsdno1}</td><td>商品世代番号_1</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyouhnsdno2 syouhnsdno2}</td><td>商品世代番号_2</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyouhnsdno3 syouhnsdno3}</td><td>商品世代番号_3</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyouhnsdno4 syouhnsdno4}</td><td>商品世代番号_4</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyouhnsdno5 syouhnsdno5}</td><td>商品世代番号_5</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyouhnsdno6 syouhnsdno6}</td><td>商品世代番号_6</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyouhnsdno7 syouhnsdno7}</td><td>商品世代番号_7</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyouhnsdno8 syouhnsdno8}</td><td>商品世代番号_8</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyouhnsdno9 syouhnsdno9}</td><td>商品世代番号_9</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyouhnsdno10 syouhnsdno10}</td><td>商品世代番号_10</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyksyouhnrenno1 kyksyouhnrenno1}</td><td>契約商品連番_1</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyksyouhnrenno2 kyksyouhnrenno2}</td><td>契約商品連番_2</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyksyouhnrenno3 kyksyouhnrenno3}</td><td>契約商品連番_3</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyksyouhnrenno4 kyksyouhnrenno4}</td><td>契約商品連番_4</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyksyouhnrenno5 kyksyouhnrenno5}</td><td>契約商品連番_5</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyksyouhnrenno6 kyksyouhnrenno6}</td><td>契約商品連番_6</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyksyouhnrenno7 kyksyouhnrenno7}</td><td>契約商品連番_7</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyksyouhnrenno8 kyksyouhnrenno8}</td><td>契約商品連番_8</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyksyouhnrenno9 kyksyouhnrenno9}</td><td>契約商品連番_9</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyksyouhnrenno10 kyksyouhnrenno10}</td><td>契約商品連番_10</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKyhgndkatakbn1 kyhgndkatakbn1}</td><td>給付限度型区分_1</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KyhgndkataKbn}</td></tr>
 *  <tr><td>{@link #getKyhgndkatakbn2 kyhgndkatakbn2}</td><td>給付限度型区分_2</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KyhgndkataKbn}</td></tr>
 *  <tr><td>{@link #getKyhgndkatakbn3 kyhgndkatakbn3}</td><td>給付限度型区分_3</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KyhgndkataKbn}</td></tr>
 *  <tr><td>{@link #getKyhgndkatakbn4 kyhgndkatakbn4}</td><td>給付限度型区分_4</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KyhgndkataKbn}</td></tr>
 *  <tr><td>{@link #getKyhgndkatakbn5 kyhgndkatakbn5}</td><td>給付限度型区分_5</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KyhgndkataKbn}</td></tr>
 *  <tr><td>{@link #getKyhgndkatakbn6 kyhgndkatakbn6}</td><td>給付限度型区分_6</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KyhgndkataKbn}</td></tr>
 *  <tr><td>{@link #getKyhgndkatakbn7 kyhgndkatakbn7}</td><td>給付限度型区分_7</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KyhgndkataKbn}</td></tr>
 *  <tr><td>{@link #getKyhgndkatakbn8 kyhgndkatakbn8}</td><td>給付限度型区分_8</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KyhgndkataKbn}</td></tr>
 *  <tr><td>{@link #getKyhgndkatakbn9 kyhgndkatakbn9}</td><td>給付限度型区分_9</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KyhgndkataKbn}</td></tr>
 *  <tr><td>{@link #getKyhgndkatakbn10 kyhgndkatakbn10}</td><td>給付限度型区分_10</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KyhgndkataKbn}</td></tr>
 *  <tr><td>{@link #getHknkknsmnkbn1 hknkknsmnkbn1}</td><td>保険期間歳満期区分_1</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HknkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getHknkknsmnkbn2 hknkknsmnkbn2}</td><td>保険期間歳満期区分_2</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HknkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getHknkknsmnkbn3 hknkknsmnkbn3}</td><td>保険期間歳満期区分_3</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HknkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getHknkknsmnkbn4 hknkknsmnkbn4}</td><td>保険期間歳満期区分_4</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HknkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getHknkknsmnkbn5 hknkknsmnkbn5}</td><td>保険期間歳満期区分_5</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HknkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getHknkknsmnkbn6 hknkknsmnkbn6}</td><td>保険期間歳満期区分_6</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HknkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getHknkknsmnkbn7 hknkknsmnkbn7}</td><td>保険期間歳満期区分_7</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HknkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getHknkknsmnkbn8 hknkknsmnkbn8}</td><td>保険期間歳満期区分_8</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HknkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getHknkknsmnkbn9 hknkknsmnkbn9}</td><td>保険期間歳満期区分_9</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HknkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getHknkknsmnkbn10 hknkknsmnkbn10}</td><td>保険期間歳満期区分_10</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HknkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getHknkkn1 hknkkn1}</td><td>保険期間_1</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHknkkn2 hknkkn2}</td><td>保険期間_2</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHknkkn3 hknkkn3}</td><td>保険期間_3</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHknkkn4 hknkkn4}</td><td>保険期間_4</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHknkkn5 hknkkn5}</td><td>保険期間_5</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHknkkn6 hknkkn6}</td><td>保険期間_6</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHknkkn7 hknkkn7}</td><td>保険期間_7</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHknkkn8 hknkkn8}</td><td>保険期間_8</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHknkkn9 hknkkn9}</td><td>保険期間_9</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHknkkn10 hknkkn10}</td><td>保険期間_10</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHrkkknsmnkbn1 hrkkknsmnkbn1}</td><td>払込期間歳満期区分_1</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getHrkkknsmnkbn2 hrkkknsmnkbn2}</td><td>払込期間歳満期区分_2</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getHrkkknsmnkbn3 hrkkknsmnkbn3}</td><td>払込期間歳満期区分_3</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getHrkkknsmnkbn4 hrkkknsmnkbn4}</td><td>払込期間歳満期区分_4</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getHrkkknsmnkbn5 hrkkknsmnkbn5}</td><td>払込期間歳満期区分_5</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getHrkkknsmnkbn6 hrkkknsmnkbn6}</td><td>払込期間歳満期区分_6</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getHrkkknsmnkbn7 hrkkknsmnkbn7}</td><td>払込期間歳満期区分_7</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getHrkkknsmnkbn8 hrkkknsmnkbn8}</td><td>払込期間歳満期区分_8</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getHrkkknsmnkbn9 hrkkknsmnkbn9}</td><td>払込期間歳満期区分_9</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getHrkkknsmnkbn10 hrkkknsmnkbn10}</td><td>払込期間歳満期区分_10</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getHrkkkn1 hrkkkn1}</td><td>払込期間_1</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHrkkkn2 hrkkkn2}</td><td>払込期間_2</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHrkkkn3 hrkkkn3}</td><td>払込期間_3</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHrkkkn4 hrkkkn4}</td><td>払込期間_4</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHrkkkn5 hrkkkn5}</td><td>払込期間_5</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHrkkkn6 hrkkkn6}</td><td>払込期間_6</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHrkkkn7 hrkkkn7}</td><td>払込期間_7</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHrkkkn8 hrkkkn8}</td><td>払込期間_8</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHrkkkn9 hrkkkn9}</td><td>払込期間_9</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHrkkkn10 hrkkkn10}</td><td>払込期間_10</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyouhnnm1 syouhnnm1}</td><td>商品名_1</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnnm2 syouhnnm2}</td><td>商品名_2</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnnm3 syouhnnm3}</td><td>商品名_3</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnnm4 syouhnnm4}</td><td>商品名_4</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnnm5 syouhnnm5}</td><td>商品名_5</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnnm6 syouhnnm6}</td><td>商品名_6</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnnm7 syouhnnm7}</td><td>商品名_7</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnnm8 syouhnnm8}</td><td>商品名_8</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnnm9 syouhnnm9}</td><td>商品名_9</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnnm10 syouhnnm10}</td><td>商品名_10</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKihons1 kihons1}</td><td>基本Ｓ_1</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKihons2 kihons2}</td><td>基本Ｓ_2</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKihons3 kihons3}</td><td>基本Ｓ_3</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKihons4 kihons4}</td><td>基本Ｓ_4</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKihons5 kihons5}</td><td>基本Ｓ_5</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKihons6 kihons6}</td><td>基本Ｓ_6</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKihons7 kihons7}</td><td>基本Ｓ_7</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKihons8 kihons8}</td><td>基本Ｓ_8</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKihons9 kihons9}</td><td>基本Ｓ_9</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKihons10 kihons10}</td><td>基本Ｓ_10</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getP1 p1}</td><td>保険料_1</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getP2 p2}</td><td>保険料_2</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getP3 p3}</td><td>保険料_3</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getP4 p4}</td><td>保険料_4</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getP5 p5}</td><td>保険料_5</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getP6 p6}</td><td>保険料_6</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getP7 p7}</td><td>保険料_7</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getP8 p8}</td><td>保険料_8</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getP9 p9}</td><td>保険料_9</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getP10 p10}</td><td>保険料_10</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKihonssyuruikbn1 kihonssyuruikbn1}</td><td>基本Ｓ種類区分_1</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KihonssyuruiKbn}</td></tr>
 *  <tr><td>{@link #getKihonssyuruikbn2 kihonssyuruikbn2}</td><td>基本Ｓ種類区分_2</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KihonssyuruiKbn}</td></tr>
 *  <tr><td>{@link #getKihonssyuruikbn3 kihonssyuruikbn3}</td><td>基本Ｓ種類区分_3</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KihonssyuruiKbn}</td></tr>
 *  <tr><td>{@link #getKihonssyuruikbn4 kihonssyuruikbn4}</td><td>基本Ｓ種類区分_4</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KihonssyuruiKbn}</td></tr>
 *  <tr><td>{@link #getKihonssyuruikbn5 kihonssyuruikbn5}</td><td>基本Ｓ種類区分_5</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KihonssyuruiKbn}</td></tr>
 *  <tr><td>{@link #getKihonssyuruikbn6 kihonssyuruikbn6}</td><td>基本Ｓ種類区分_6</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KihonssyuruiKbn}</td></tr>
 *  <tr><td>{@link #getKihonssyuruikbn7 kihonssyuruikbn7}</td><td>基本Ｓ種類区分_7</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KihonssyuruiKbn}</td></tr>
 *  <tr><td>{@link #getKihonssyuruikbn8 kihonssyuruikbn8}</td><td>基本Ｓ種類区分_8</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KihonssyuruiKbn}</td></tr>
 *  <tr><td>{@link #getKihonssyuruikbn9 kihonssyuruikbn9}</td><td>基本Ｓ種類区分_9</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KihonssyuruiKbn}</td></tr>
 *  <tr><td>{@link #getKihonssyuruikbn10 kihonssyuruikbn10}</td><td>基本Ｓ種類区分_10</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KihonssyuruiKbn}</td></tr>
 *  <tr><td>{@link #getSyukyhkinkatakbn1 syukyhkinkatakbn1}</td><td>手術給付金型区分_1</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyukyhkinkataKbn}</td></tr>
 *  <tr><td>{@link #getSyukyhkinkatakbn2 syukyhkinkatakbn2}</td><td>手術給付金型区分_2</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyukyhkinkataKbn}</td></tr>
 *  <tr><td>{@link #getSyukyhkinkatakbn3 syukyhkinkatakbn3}</td><td>手術給付金型区分_3</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyukyhkinkataKbn}</td></tr>
 *  <tr><td>{@link #getSyukyhkinkatakbn4 syukyhkinkatakbn4}</td><td>手術給付金型区分_4</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyukyhkinkataKbn}</td></tr>
 *  <tr><td>{@link #getSyukyhkinkatakbn5 syukyhkinkatakbn5}</td><td>手術給付金型区分_5</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyukyhkinkataKbn}</td></tr>
 *  <tr><td>{@link #getSyukyhkinkatakbn6 syukyhkinkatakbn6}</td><td>手術給付金型区分_6</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyukyhkinkataKbn}</td></tr>
 *  <tr><td>{@link #getSyukyhkinkatakbn7 syukyhkinkatakbn7}</td><td>手術給付金型区分_7</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyukyhkinkataKbn}</td></tr>
 *  <tr><td>{@link #getSyukyhkinkatakbn8 syukyhkinkatakbn8}</td><td>手術給付金型区分_8</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyukyhkinkataKbn}</td></tr>
 *  <tr><td>{@link #getSyukyhkinkatakbn9 syukyhkinkatakbn9}</td><td>手術給付金型区分_9</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyukyhkinkataKbn}</td></tr>
 *  <tr><td>{@link #getSyukyhkinkatakbn10 syukyhkinkatakbn10}</td><td>手術給付金型区分_10</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyukyhkinkataKbn}</td></tr>
 *  <tr><td>{@link #getRokudaissbtkkyhktkbn1 rokudaissbtkkyhktkbn1}</td><td>６大生活習慣病追加給付型区分_1</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_6daiLdKbn}</td></tr>
 *  <tr><td>{@link #getRokudaissbtkkyhktkbn2 rokudaissbtkkyhktkbn2}</td><td>６大生活習慣病追加給付型区分_2</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_6daiLdKbn}</td></tr>
 *  <tr><td>{@link #getRokudaissbtkkyhktkbn3 rokudaissbtkkyhktkbn3}</td><td>６大生活習慣病追加給付型区分_3</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_6daiLdKbn}</td></tr>
 *  <tr><td>{@link #getRokudaissbtkkyhktkbn4 rokudaissbtkkyhktkbn4}</td><td>６大生活習慣病追加給付型区分_4</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_6daiLdKbn}</td></tr>
 *  <tr><td>{@link #getRokudaissbtkkyhktkbn5 rokudaissbtkkyhktkbn5}</td><td>６大生活習慣病追加給付型区分_5</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_6daiLdKbn}</td></tr>
 *  <tr><td>{@link #getRokudaissbtkkyhktkbn6 rokudaissbtkkyhktkbn6}</td><td>６大生活習慣病追加給付型区分_6</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_6daiLdKbn}</td></tr>
 *  <tr><td>{@link #getRokudaissbtkkyhktkbn7 rokudaissbtkkyhktkbn7}</td><td>６大生活習慣病追加給付型区分_7</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_6daiLdKbn}</td></tr>
 *  <tr><td>{@link #getRokudaissbtkkyhktkbn8 rokudaissbtkkyhktkbn8}</td><td>６大生活習慣病追加給付型区分_8</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_6daiLdKbn}</td></tr>
 *  <tr><td>{@link #getRokudaissbtkkyhktkbn9 rokudaissbtkkyhktkbn9}</td><td>６大生活習慣病追加給付型区分_9</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_6daiLdKbn}</td></tr>
 *  <tr><td>{@link #getRokudaissbtkkyhktkbn10 rokudaissbtkkyhktkbn10}</td><td>６大生活習慣病追加給付型区分_10</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_6daiLdKbn}</td></tr>
 *  <tr><td>{@link #getKhnkyhgk1 khnkyhgk1}</td><td>基本給付金額_1</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKhnkyhgk2 khnkyhgk2}</td><td>基本給付金額_2</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKhnkyhgk3 khnkyhgk3}</td><td>基本給付金額_3</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKhnkyhgk4 khnkyhgk4}</td><td>基本給付金額_4</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKhnkyhgk5 khnkyhgk5}</td><td>基本給付金額_5</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKhnkyhgk6 khnkyhgk6}</td><td>基本給付金額_6</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKhnkyhgk7 khnkyhgk7}</td><td>基本給付金額_7</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKhnkyhgk8 khnkyhgk8}</td><td>基本給付金額_8</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKhnkyhgk9 khnkyhgk9}</td><td>基本給付金額_9</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKhnkyhgk10 khnkyhgk10}</td><td>基本給付金額_10</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTsinyno tsinyno}</td><td>通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr1kj tsinadr1kj}</td><td>通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr2kj tsinadr2kj}</td><td>通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr3kj tsinadr3kj}</td><td>通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsinadr4kj tsinadr4kj}</td><td>通信先住所４（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAitesyono aitesyono}</td><td>相手証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtencd drtencd}</td><td>代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtennmkj drtennmkj}</td><td>代理店名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRkaiyakuhrumukbn rkaiyakuhrumukbn}</td><td>（帳票用）解約返戻金有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getRkaiyakuhr rkaiyakuhr}</td><td>（帳票用）解約返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getRsbhenkan rsbhenkan}</td><td>（帳票用）死亡返還金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getRhtnpbuinm1 rhtnpbuinm1}</td><td>（帳票用）不担保部位名１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHtnpkkn1 htnpkkn1}</td><td>不担保期間１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Htnpkkn}</td></tr>
 *  <tr><td>{@link #getRhtnpbuinm2 rhtnpbuinm2}</td><td>（帳票用）不担保部位名２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHtnpkkn2 htnpkkn2}</td><td>不担保期間２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Htnpkkn}</td></tr>
 *  <tr><td>{@link #getRhtnpbuinm3 rhtnpbuinm3}</td><td>（帳票用）不担保部位名３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHtnpkkn3 htnpkkn3}</td><td>不担保期間３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Htnpkkn}</td></tr>
 *  <tr><td>{@link #getRhtnpbuinm4 rhtnpbuinm4}</td><td>（帳票用）不担保部位名４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHtnpkkn4 htnpkkn4}</td><td>不担保期間４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Htnpkkn}</td></tr>
 *  <tr><td>{@link #getTokkoudosghtnpkbn tokkoudosghtnpkbn}</td><td>特定高度障害不担保区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TokkoudosghtnpKbn}</td></tr>
 *  <tr><td>{@link #getRtratkicd rtratkicd}</td><td>（帳票用）取扱コード</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getRtyouhyoucd rtyouhyoucd}</td><td>（帳票用）帳票コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyhyrenrakusikibetukbn tyhyrenrakusikibetukbn}</td><td>帳票連絡先識別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TyhyrenrakusikibetuKbn}</td></tr>
 *  <tr><td>{@link #getGansknnkaisiymd gansknnkaisiymd}</td><td>がん責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGannyukyhntgk gannyukyhntgk}</td><td>がん入院給付日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKatakbn1 katakbn1}</td><td>型区分_1</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KataKbn}</td></tr>
 *  <tr><td>{@link #getKatakbn2 katakbn2}</td><td>型区分_2</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KataKbn}</td></tr>
 *  <tr><td>{@link #getKatakbn3 katakbn3}</td><td>型区分_3</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KataKbn}</td></tr>
 *  <tr><td>{@link #getKatakbn4 katakbn4}</td><td>型区分_4</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KataKbn}</td></tr>
 *  <tr><td>{@link #getKatakbn5 katakbn5}</td><td>型区分_5</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KataKbn}</td></tr>
 *  <tr><td>{@link #getKatakbn6 katakbn6}</td><td>型区分_6</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KataKbn}</td></tr>
 *  <tr><td>{@link #getKatakbn7 katakbn7}</td><td>型区分_7</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KataKbn}</td></tr>
 *  <tr><td>{@link #getKatakbn8 katakbn8}</td><td>型区分_8</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KataKbn}</td></tr>
 *  <tr><td>{@link #getKatakbn9 katakbn9}</td><td>型区分_9</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KataKbn}</td></tr>
 *  <tr><td>{@link #getKatakbn10 katakbn10}</td><td>型区分_10</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KataKbn}</td></tr>
 *  <tr><td>{@link #getSbhkuktnmkj1 sbhkuktnmkj1}</td><td>死亡保険金受取人氏名（漢字）_1</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSbhkuktnmkj2 sbhkuktnmkj2}</td><td>死亡保険金受取人氏名（漢字）_2</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSbhkuktnmkj3 sbhkuktnmkj3}</td><td>死亡保険金受取人氏名（漢字）_3</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSbhkuktnmkj4 sbhkuktnmkj4}</td><td>死亡保険金受取人氏名（漢字）_4</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSbhkuktnmkj5 sbhkuktnmkj5}</td><td>死亡保険金受取人氏名（漢字）_5</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSbhkuktseiymd1 sbhkuktseiymd1}</td><td>死亡保険金受取人生年月日_1</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSbhkuktseiymd2 sbhkuktseiymd2}</td><td>死亡保険金受取人生年月日_2</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSbhkuktseiymd3 sbhkuktseiymd3}</td><td>死亡保険金受取人生年月日_3</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSbhkuktseiymd4 sbhkuktseiymd4}</td><td>死亡保険金受取人生年月日_4</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSbhkuktseiymd5 sbhkuktseiymd5}</td><td>死亡保険金受取人生年月日_5</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSbhkkukttyoukanin sbhkkukttyoukanin}</td><td>死亡保険金受取人超過人数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSbhktyoukaninbunwari sbhktyoukaninbunwari}</td><td>死亡保険金超過人数分割割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getBnwari1 bnwari1}</td><td>分割割合_1</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getBnwari2 bnwari2}</td><td>分割割合_2</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getBnwari3 bnwari3}</td><td>分割割合_3</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getBnwari4 bnwari4}</td><td>分割割合_4</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getBnwari5 bnwari5}</td><td>分割割合_5</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getPmnjtkkbn pmnjtkkbn}</td><td>保険料免除特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_PmnjtkKbn}</td></tr>
 *  <tr><td>{@link #getMosukeymd mosukeymd}</td><td>申込書受付日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSknnkaisikitkkbn sknnkaisikitkkbn}</td><td>責任開始期特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SknnkaisikitkKbn}</td></tr>
 *  <tr><td>{@link #getKoujyosyoumeirecnum koujyosyoumeirecnum}</td><td>控除証明書レコード数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHksknnkaisiymd hksknnkaisiymd}</td><td>復活責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHkgansknnkaisiymd hkgansknnkaisiymd}</td><td>復活がん責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_SougouTuuti
 * @see     PKIT_SougouTuuti
 * @see     QIT_SougouTuuti
 * @see     GenQIT_SougouTuuti
 */
@MappedSuperclass
@Table(name=GenIT_SougouTuuti.TABLE_NAME)
@IdClass(value=PKIT_SougouTuuti.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_6daiLdKbn", typeClass=UserType_C_6daiLdKbn.class),
    @TypeDef(name="UserType_C_Hhknsei", typeClass=UserType_C_Hhknsei.class),
    @TypeDef(name="UserType_C_HknkknsmnKbn", typeClass=UserType_C_HknkknsmnKbn.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_HrkkknsmnKbn", typeClass=UserType_C_HrkkknsmnKbn.class),
    @TypeDef(name="UserType_C_Htnpkkn", typeClass=UserType_C_Htnpkkn.class),
    @TypeDef(name="UserType_C_KataKbn", typeClass=UserType_C_KataKbn.class),
    @TypeDef(name="UserType_C_KihonssyuruiKbn", typeClass=UserType_C_KihonssyuruiKbn.class),
    @TypeDef(name="UserType_C_KjkhukaKbn", typeClass=UserType_C_KjkhukaKbn.class),
    @TypeDef(name="UserType_C_KyhgndkataKbn", typeClass=UserType_C_KyhgndkataKbn.class),
    @TypeDef(name="UserType_C_PmnjtkKbn", typeClass=UserType_C_PmnjtkKbn.class),
    @TypeDef(name="UserType_C_SknnkaisikitkKbn", typeClass=UserType_C_SknnkaisikitkKbn.class),
    @TypeDef(name="UserType_C_SyukyhkinkataKbn", typeClass=UserType_C_SyukyhkinkataKbn.class),
    @TypeDef(name="UserType_C_SyutkKbn", typeClass=UserType_C_SyutkKbn.class),
    @TypeDef(name="UserType_C_TokkoudosghtnpKbn", typeClass=UserType_C_TokkoudosghtnpKbn.class),
    @TypeDef(name="UserType_C_TyhyrenrakusikibetuKbn", typeClass=UserType_C_TyhyrenrakusikibetuKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenIT_SougouTuuti extends AbstractExDBEntity<IT_SougouTuuti, PKIT_SougouTuuti> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_SougouTuuti";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TYOUHYOUYMD              = "tyouhyouymd";
    public static final String TYOUHYOUPRTYMD           = "tyouhyouprtymd";
    public static final String KYKYMD                   = "kykymd";
    public static final String SKNNKAISIYMD             = "sknnkaisiymd";
    public static final String SYOUHNNMSYOUKEN          = "syouhnnmsyouken";
    public static final String KYKNMKJ                  = "kyknmkj";
    public static final String KYKNMKJKHUKAKBN          = "kyknmkjkhukakbn";
    public static final String HHKNNMKJ                 = "hhknnmkj";
    public static final String HHKNNMKJKHUKAKBN         = "hhknnmkjkhukakbn";
    public static final String HHKNSEIYMD               = "hhknseiymd";
    public static final String HHKNSEI                  = "hhknsei";
    public static final String HHKNNEN                  = "hhknnen";
    public static final String SBHENKANUKTNMKJ          = "sbhenkanuktnmkj";
    public static final String SIBOUHENKANKINUKTSEIYMD  = "sibouhenkankinuktseiymd";
    public static final String STDRSKNMKJ               = "stdrsknmkj";
    public static final String STDRSKSEIYMD             = "stdrskseiymd";
    public static final String HRKP                     = "hrkp";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String HRKKEIRO                 = "hrkkeiro";
    public static final String SYUTKKBN1                = "syutkkbn1";
    public static final String SYUTKKBN2                = "syutkkbn2";
    public static final String SYUTKKBN3                = "syutkkbn3";
    public static final String SYUTKKBN4                = "syutkkbn4";
    public static final String SYUTKKBN5                = "syutkkbn5";
    public static final String SYUTKKBN6                = "syutkkbn6";
    public static final String SYUTKKBN7                = "syutkkbn7";
    public static final String SYUTKKBN8                = "syutkkbn8";
    public static final String SYUTKKBN9                = "syutkkbn9";
    public static final String SYUTKKBN10               = "syutkkbn10";
    public static final String SYOUHNCD1                = "syouhncd1";
    public static final String SYOUHNCD2                = "syouhncd2";
    public static final String SYOUHNCD3                = "syouhncd3";
    public static final String SYOUHNCD4                = "syouhncd4";
    public static final String SYOUHNCD5                = "syouhncd5";
    public static final String SYOUHNCD6                = "syouhncd6";
    public static final String SYOUHNCD7                = "syouhncd7";
    public static final String SYOUHNCD8                = "syouhncd8";
    public static final String SYOUHNCD9                = "syouhncd9";
    public static final String SYOUHNCD10               = "syouhncd10";
    public static final String SYOUHNSDNO1              = "syouhnsdno1";
    public static final String SYOUHNSDNO2              = "syouhnsdno2";
    public static final String SYOUHNSDNO3              = "syouhnsdno3";
    public static final String SYOUHNSDNO4              = "syouhnsdno4";
    public static final String SYOUHNSDNO5              = "syouhnsdno5";
    public static final String SYOUHNSDNO6              = "syouhnsdno6";
    public static final String SYOUHNSDNO7              = "syouhnsdno7";
    public static final String SYOUHNSDNO8              = "syouhnsdno8";
    public static final String SYOUHNSDNO9              = "syouhnsdno9";
    public static final String SYOUHNSDNO10             = "syouhnsdno10";
    public static final String KYKSYOUHNRENNO1          = "kyksyouhnrenno1";
    public static final String KYKSYOUHNRENNO2          = "kyksyouhnrenno2";
    public static final String KYKSYOUHNRENNO3          = "kyksyouhnrenno3";
    public static final String KYKSYOUHNRENNO4          = "kyksyouhnrenno4";
    public static final String KYKSYOUHNRENNO5          = "kyksyouhnrenno5";
    public static final String KYKSYOUHNRENNO6          = "kyksyouhnrenno6";
    public static final String KYKSYOUHNRENNO7          = "kyksyouhnrenno7";
    public static final String KYKSYOUHNRENNO8          = "kyksyouhnrenno8";
    public static final String KYKSYOUHNRENNO9          = "kyksyouhnrenno9";
    public static final String KYKSYOUHNRENNO10         = "kyksyouhnrenno10";
    public static final String KYHGNDKATAKBN1           = "kyhgndkatakbn1";
    public static final String KYHGNDKATAKBN2           = "kyhgndkatakbn2";
    public static final String KYHGNDKATAKBN3           = "kyhgndkatakbn3";
    public static final String KYHGNDKATAKBN4           = "kyhgndkatakbn4";
    public static final String KYHGNDKATAKBN5           = "kyhgndkatakbn5";
    public static final String KYHGNDKATAKBN6           = "kyhgndkatakbn6";
    public static final String KYHGNDKATAKBN7           = "kyhgndkatakbn7";
    public static final String KYHGNDKATAKBN8           = "kyhgndkatakbn8";
    public static final String KYHGNDKATAKBN9           = "kyhgndkatakbn9";
    public static final String KYHGNDKATAKBN10          = "kyhgndkatakbn10";
    public static final String HKNKKNSMNKBN1            = "hknkknsmnkbn1";
    public static final String HKNKKNSMNKBN2            = "hknkknsmnkbn2";
    public static final String HKNKKNSMNKBN3            = "hknkknsmnkbn3";
    public static final String HKNKKNSMNKBN4            = "hknkknsmnkbn4";
    public static final String HKNKKNSMNKBN5            = "hknkknsmnkbn5";
    public static final String HKNKKNSMNKBN6            = "hknkknsmnkbn6";
    public static final String HKNKKNSMNKBN7            = "hknkknsmnkbn7";
    public static final String HKNKKNSMNKBN8            = "hknkknsmnkbn8";
    public static final String HKNKKNSMNKBN9            = "hknkknsmnkbn9";
    public static final String HKNKKNSMNKBN10           = "hknkknsmnkbn10";
    public static final String HKNKKN1                  = "hknkkn1";
    public static final String HKNKKN2                  = "hknkkn2";
    public static final String HKNKKN3                  = "hknkkn3";
    public static final String HKNKKN4                  = "hknkkn4";
    public static final String HKNKKN5                  = "hknkkn5";
    public static final String HKNKKN6                  = "hknkkn6";
    public static final String HKNKKN7                  = "hknkkn7";
    public static final String HKNKKN8                  = "hknkkn8";
    public static final String HKNKKN9                  = "hknkkn9";
    public static final String HKNKKN10                 = "hknkkn10";
    public static final String HRKKKNSMNKBN1            = "hrkkknsmnkbn1";
    public static final String HRKKKNSMNKBN2            = "hrkkknsmnkbn2";
    public static final String HRKKKNSMNKBN3            = "hrkkknsmnkbn3";
    public static final String HRKKKNSMNKBN4            = "hrkkknsmnkbn4";
    public static final String HRKKKNSMNKBN5            = "hrkkknsmnkbn5";
    public static final String HRKKKNSMNKBN6            = "hrkkknsmnkbn6";
    public static final String HRKKKNSMNKBN7            = "hrkkknsmnkbn7";
    public static final String HRKKKNSMNKBN8            = "hrkkknsmnkbn8";
    public static final String HRKKKNSMNKBN9            = "hrkkknsmnkbn9";
    public static final String HRKKKNSMNKBN10           = "hrkkknsmnkbn10";
    public static final String HRKKKN1                  = "hrkkkn1";
    public static final String HRKKKN2                  = "hrkkkn2";
    public static final String HRKKKN3                  = "hrkkkn3";
    public static final String HRKKKN4                  = "hrkkkn4";
    public static final String HRKKKN5                  = "hrkkkn5";
    public static final String HRKKKN6                  = "hrkkkn6";
    public static final String HRKKKN7                  = "hrkkkn7";
    public static final String HRKKKN8                  = "hrkkkn8";
    public static final String HRKKKN9                  = "hrkkkn9";
    public static final String HRKKKN10                 = "hrkkkn10";
    public static final String SYOUHNNM1                = "syouhnnm1";
    public static final String SYOUHNNM2                = "syouhnnm2";
    public static final String SYOUHNNM3                = "syouhnnm3";
    public static final String SYOUHNNM4                = "syouhnnm4";
    public static final String SYOUHNNM5                = "syouhnnm5";
    public static final String SYOUHNNM6                = "syouhnnm6";
    public static final String SYOUHNNM7                = "syouhnnm7";
    public static final String SYOUHNNM8                = "syouhnnm8";
    public static final String SYOUHNNM9                = "syouhnnm9";
    public static final String SYOUHNNM10               = "syouhnnm10";
    public static final String KIHONS1                  = "kihons1";
    public static final String KIHONS2                  = "kihons2";
    public static final String KIHONS3                  = "kihons3";
    public static final String KIHONS4                  = "kihons4";
    public static final String KIHONS5                  = "kihons5";
    public static final String KIHONS6                  = "kihons6";
    public static final String KIHONS7                  = "kihons7";
    public static final String KIHONS8                  = "kihons8";
    public static final String KIHONS9                  = "kihons9";
    public static final String KIHONS10                 = "kihons10";
    public static final String P1                       = "p1";
    public static final String P2                       = "p2";
    public static final String P3                       = "p3";
    public static final String P4                       = "p4";
    public static final String P5                       = "p5";
    public static final String P6                       = "p6";
    public static final String P7                       = "p7";
    public static final String P8                       = "p8";
    public static final String P9                       = "p9";
    public static final String P10                      = "p10";
    public static final String KIHONSSYURUIKBN1         = "kihonssyuruikbn1";
    public static final String KIHONSSYURUIKBN2         = "kihonssyuruikbn2";
    public static final String KIHONSSYURUIKBN3         = "kihonssyuruikbn3";
    public static final String KIHONSSYURUIKBN4         = "kihonssyuruikbn4";
    public static final String KIHONSSYURUIKBN5         = "kihonssyuruikbn5";
    public static final String KIHONSSYURUIKBN6         = "kihonssyuruikbn6";
    public static final String KIHONSSYURUIKBN7         = "kihonssyuruikbn7";
    public static final String KIHONSSYURUIKBN8         = "kihonssyuruikbn8";
    public static final String KIHONSSYURUIKBN9         = "kihonssyuruikbn9";
    public static final String KIHONSSYURUIKBN10        = "kihonssyuruikbn10";
    public static final String SYUKYHKINKATAKBN1        = "syukyhkinkatakbn1";
    public static final String SYUKYHKINKATAKBN2        = "syukyhkinkatakbn2";
    public static final String SYUKYHKINKATAKBN3        = "syukyhkinkatakbn3";
    public static final String SYUKYHKINKATAKBN4        = "syukyhkinkatakbn4";
    public static final String SYUKYHKINKATAKBN5        = "syukyhkinkatakbn5";
    public static final String SYUKYHKINKATAKBN6        = "syukyhkinkatakbn6";
    public static final String SYUKYHKINKATAKBN7        = "syukyhkinkatakbn7";
    public static final String SYUKYHKINKATAKBN8        = "syukyhkinkatakbn8";
    public static final String SYUKYHKINKATAKBN9        = "syukyhkinkatakbn9";
    public static final String SYUKYHKINKATAKBN10       = "syukyhkinkatakbn10";
    public static final String ROKUDAISSBTKKYHKTKBN1    = "rokudaissbtkkyhktkbn1";
    public static final String ROKUDAISSBTKKYHKTKBN2    = "rokudaissbtkkyhktkbn2";
    public static final String ROKUDAISSBTKKYHKTKBN3    = "rokudaissbtkkyhktkbn3";
    public static final String ROKUDAISSBTKKYHKTKBN4    = "rokudaissbtkkyhktkbn4";
    public static final String ROKUDAISSBTKKYHKTKBN5    = "rokudaissbtkkyhktkbn5";
    public static final String ROKUDAISSBTKKYHKTKBN6    = "rokudaissbtkkyhktkbn6";
    public static final String ROKUDAISSBTKKYHKTKBN7    = "rokudaissbtkkyhktkbn7";
    public static final String ROKUDAISSBTKKYHKTKBN8    = "rokudaissbtkkyhktkbn8";
    public static final String ROKUDAISSBTKKYHKTKBN9    = "rokudaissbtkkyhktkbn9";
    public static final String ROKUDAISSBTKKYHKTKBN10   = "rokudaissbtkkyhktkbn10";
    public static final String KHNKYHGK1                = "khnkyhgk1";
    public static final String KHNKYHGK2                = "khnkyhgk2";
    public static final String KHNKYHGK3                = "khnkyhgk3";
    public static final String KHNKYHGK4                = "khnkyhgk4";
    public static final String KHNKYHGK5                = "khnkyhgk5";
    public static final String KHNKYHGK6                = "khnkyhgk6";
    public static final String KHNKYHGK7                = "khnkyhgk7";
    public static final String KHNKYHGK8                = "khnkyhgk8";
    public static final String KHNKYHGK9                = "khnkyhgk9";
    public static final String KHNKYHGK10               = "khnkyhgk10";
    public static final String TSINYNO                  = "tsinyno";
    public static final String TSINADR1KJ               = "tsinadr1kj";
    public static final String TSINADR2KJ               = "tsinadr2kj";
    public static final String TSINADR3KJ               = "tsinadr3kj";
    public static final String TSINADR4KJ               = "tsinadr4kj";
    public static final String AITESYONO                = "aitesyono";
    public static final String DRTENCD                  = "drtencd";
    public static final String DRTENNMKJ                = "drtennmkj";
    public static final String RKAIYAKUHRUMUKBN         = "rkaiyakuhrumukbn";
    public static final String RKAIYAKUHR               = "rkaiyakuhr";
    public static final String RSBHENKAN                = "rsbhenkan";
    public static final String RHTNPBUINM1              = "rhtnpbuinm1";
    public static final String HTNPKKN1                 = "htnpkkn1";
    public static final String RHTNPBUINM2              = "rhtnpbuinm2";
    public static final String HTNPKKN2                 = "htnpkkn2";
    public static final String RHTNPBUINM3              = "rhtnpbuinm3";
    public static final String HTNPKKN3                 = "htnpkkn3";
    public static final String RHTNPBUINM4              = "rhtnpbuinm4";
    public static final String HTNPKKN4                 = "htnpkkn4";
    public static final String TOKKOUDOSGHTNPKBN        = "tokkoudosghtnpkbn";
    public static final String RTRATKICD                = "rtratkicd";
    public static final String RTYOUHYOUCD              = "rtyouhyoucd";
    public static final String TYHYRENRAKUSIKIBETUKBN   = "tyhyrenrakusikibetukbn";
    public static final String GANSKNNKAISIYMD          = "gansknnkaisiymd";
    public static final String GANNYUKYHNTGK            = "gannyukyhntgk";
    public static final String KATAKBN1                 = "katakbn1";
    public static final String KATAKBN2                 = "katakbn2";
    public static final String KATAKBN3                 = "katakbn3";
    public static final String KATAKBN4                 = "katakbn4";
    public static final String KATAKBN5                 = "katakbn5";
    public static final String KATAKBN6                 = "katakbn6";
    public static final String KATAKBN7                 = "katakbn7";
    public static final String KATAKBN8                 = "katakbn8";
    public static final String KATAKBN9                 = "katakbn9";
    public static final String KATAKBN10                = "katakbn10";
    public static final String SBHKUKTNMKJ1             = "sbhkuktnmkj1";
    public static final String SBHKUKTNMKJ2             = "sbhkuktnmkj2";
    public static final String SBHKUKTNMKJ3             = "sbhkuktnmkj3";
    public static final String SBHKUKTNMKJ4             = "sbhkuktnmkj4";
    public static final String SBHKUKTNMKJ5             = "sbhkuktnmkj5";
    public static final String SBHKUKTSEIYMD1           = "sbhkuktseiymd1";
    public static final String SBHKUKTSEIYMD2           = "sbhkuktseiymd2";
    public static final String SBHKUKTSEIYMD3           = "sbhkuktseiymd3";
    public static final String SBHKUKTSEIYMD4           = "sbhkuktseiymd4";
    public static final String SBHKUKTSEIYMD5           = "sbhkuktseiymd5";
    public static final String SBHKKUKTTYOUKANIN        = "sbhkkukttyoukanin";
    public static final String SBHKTYOUKANINBUNWARI     = "sbhktyoukaninbunwari";
    public static final String BNWARI1                  = "bnwari1";
    public static final String BNWARI2                  = "bnwari2";
    public static final String BNWARI3                  = "bnwari3";
    public static final String BNWARI4                  = "bnwari4";
    public static final String BNWARI5                  = "bnwari5";
    public static final String PMNJTKKBN                = "pmnjtkkbn";
    public static final String MOSUKEYMD                = "mosukeymd";
    public static final String SKNNKAISIKITKKBN         = "sknnkaisikitkkbn";
    public static final String KOUJYOSYOUMEIRECNUM      = "koujyosyoumeirecnum";
    public static final String HKSKNNKAISIYMD           = "hksknnkaisiymd";
    public static final String HKGANSKNNKAISIYMD        = "hkgansknnkaisiymd";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_SougouTuuti primaryKey;

    public GenIT_SougouTuuti() {
        primaryKey = new PKIT_SougouTuuti();
    }

    public GenIT_SougouTuuti(
        String pKbnkey,
        String pSyono,
        BizDate pTyouhyouymd
    ) {
        primaryKey = new PKIT_SougouTuuti(
            pKbnkey,
            pSyono,
            pTyouhyouymd
        );
    }

    @Transient
    @Override
    public PKIT_SougouTuuti getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_SougouTuuti> getMetaClass() {
        return QIT_SougouTuuti.class;
    }

    @Id
    @Column(name=GenIT_SougouTuuti.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_SougouTuuti.SYONO)
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
    @Type(type="BizDateType")
    @Column(name=GenIT_SougouTuuti.TYOUHYOUYMD)
    @ValidDate
    public BizDate getTyouhyouymd() {
        return getPrimaryKey().getTyouhyouymd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        getPrimaryKey().setTyouhyouymd(pTyouhyouymd);
    }

    private BizDate tyouhyouprtymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_SougouTuuti.TYOUHYOUPRTYMD)
    public BizDate getTyouhyouprtymd() {
        return tyouhyouprtymd;
    }

    @Trim("both")
    public void setTyouhyouprtymd(BizDate pTyouhyouprtymd) {
        tyouhyouprtymd = pTyouhyouprtymd;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_SougouTuuti.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private BizDate sknnkaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_SougouTuuti.SKNNKAISIYMD)
    public BizDate getSknnkaisiymd() {
        return sknnkaisiymd;
    }

    @Trim("both")
    public void setSknnkaisiymd(BizDate pSknnkaisiymd) {
        sknnkaisiymd = pSknnkaisiymd;
    }

    private String syouhnnmsyouken;

    @Column(name=GenIT_SougouTuuti.SYOUHNNMSYOUKEN)
    public String getSyouhnnmsyouken() {
        return syouhnnmsyouken;
    }

    public void setSyouhnnmsyouken(String pSyouhnnmsyouken) {
        syouhnnmsyouken = pSyouhnnmsyouken;
    }

    private String kyknmkj;

    @Column(name=GenIT_SougouTuuti.KYKNMKJ)
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
    @Column(name=GenIT_SougouTuuti.KYKNMKJKHUKAKBN)
    public C_KjkhukaKbn getKyknmkjkhukakbn() {
        return kyknmkjkhukakbn;
    }

    public void setKyknmkjkhukakbn(C_KjkhukaKbn pKyknmkjkhukakbn) {
        kyknmkjkhukakbn = pKyknmkjkhukakbn;
    }

    private String hhknnmkj;

    @Column(name=GenIT_SougouTuuti.HHKNNMKJ)
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
    @Column(name=GenIT_SougouTuuti.HHKNNMKJKHUKAKBN)
    public C_KjkhukaKbn getHhknnmkjkhukakbn() {
        return hhknnmkjkhukakbn;
    }

    public void setHhknnmkjkhukakbn(C_KjkhukaKbn pHhknnmkjkhukakbn) {
        hhknnmkjkhukakbn = pHhknnmkjkhukakbn;
    }

    private BizDate hhknseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_SougouTuuti.HHKNSEIYMD)
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
    @Column(name=GenIT_SougouTuuti.HHKNSEI)
    public C_Hhknsei getHhknsei() {
        return hhknsei;
    }

    public void setHhknsei(C_Hhknsei pHhknsei) {
        hhknsei = pHhknsei;
    }

    private Integer hhknnen;

    @Column(name=GenIT_SougouTuuti.HHKNNEN)
    @NaturalNumber
    public Integer getHhknnen() {
        return hhknnen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknnen(Integer pHhknnen) {
        hhknnen = pHhknnen;
    }

    private String sbhenkanuktnmkj;

    @Column(name=GenIT_SougouTuuti.SBHENKANUKTNMKJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getSbhenkanuktnmkj() {
        return sbhenkanuktnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSbhenkanuktnmkj(String pSbhenkanuktnmkj) {
        sbhenkanuktnmkj = pSbhenkanuktnmkj;
    }

    private BizDate sibouhenkankinuktseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_SougouTuuti.SIBOUHENKANKINUKTSEIYMD)
    @ValidDate
    public BizDate getSibouhenkankinuktseiymd() {
        return sibouhenkankinuktseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSibouhenkankinuktseiymd(BizDate pSibouhenkankinuktseiymd) {
        sibouhenkankinuktseiymd = pSibouhenkankinuktseiymd;
    }

    private String stdrsknmkj;

    @Column(name=GenIT_SougouTuuti.STDRSKNMKJ)
    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    public String getStdrsknmkj() {
        return stdrsknmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setStdrsknmkj(String pStdrsknmkj) {
        stdrsknmkj = pStdrsknmkj;
    }

    private BizDate stdrskseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_SougouTuuti.STDRSKSEIYMD)
    @ValidDate
    public BizDate getStdrskseiymd() {
        return stdrskseiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setStdrskseiymd(BizDate pStdrskseiymd) {
        stdrskseiymd = pStdrskseiymd;
    }

    private BizCurrency hrkp;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHrkp() {
        return hrkp;
    }

    public void setHrkp(BizCurrency pHrkp) {
        hrkp = pHrkp;
        hrkpValue = null;
        hrkpType  = null;
    }

    transient private BigDecimal hrkpValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HRKP, nullable=true)
    protected BigDecimal getHrkpValue() {
        if (hrkpValue == null && hrkp != null) {
            if (hrkp.isOptional()) return null;
            return hrkp.absolute();
        }
        return hrkpValue;
    }

    protected void setHrkpValue(BigDecimal value) {
        hrkpValue = value;
        hrkp = Optional.fromNullable(toCurrencyType(hrkpType))
            .transform(bizCurrencyTransformer(getHrkpValue()))
            .orNull();
    }

    transient private String hrkpType = null;

    @Column(name=HRKP + "$", nullable=true)
    protected String getHrkpType() {
        if (hrkpType == null && hrkp != null) return hrkp.getType().toString();
        if (hrkpType == null && getHrkpValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hrkp$' should not be NULL."));
        }
        return hrkpType;
    }

    protected void setHrkpType(String type) {
        hrkpType = type;
        hrkp = Optional.fromNullable(toCurrencyType(hrkpType))
            .transform(bizCurrencyTransformer(getHrkpValue()))
            .orNull();
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenIT_SougouTuuti.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_Hrkkeiro hrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenIT_SougouTuuti.HRKKEIRO)
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private C_SyutkKbn syutkkbn1;

    @Type(type="UserType_C_SyutkKbn")
    @Column(name=GenIT_SougouTuuti.SYUTKKBN1)
    public C_SyutkKbn getSyutkkbn1() {
        return syutkkbn1;
    }

    public void setSyutkkbn1(C_SyutkKbn pSyutkkbn1) {
        syutkkbn1 = pSyutkkbn1;
    }

    private C_SyutkKbn syutkkbn2;

    @Type(type="UserType_C_SyutkKbn")
    @Column(name=GenIT_SougouTuuti.SYUTKKBN2)
    public C_SyutkKbn getSyutkkbn2() {
        return syutkkbn2;
    }

    public void setSyutkkbn2(C_SyutkKbn pSyutkkbn2) {
        syutkkbn2 = pSyutkkbn2;
    }

    private C_SyutkKbn syutkkbn3;

    @Type(type="UserType_C_SyutkKbn")
    @Column(name=GenIT_SougouTuuti.SYUTKKBN3)
    public C_SyutkKbn getSyutkkbn3() {
        return syutkkbn3;
    }

    public void setSyutkkbn3(C_SyutkKbn pSyutkkbn3) {
        syutkkbn3 = pSyutkkbn3;
    }

    private C_SyutkKbn syutkkbn4;

    @Type(type="UserType_C_SyutkKbn")
    @Column(name=GenIT_SougouTuuti.SYUTKKBN4)
    public C_SyutkKbn getSyutkkbn4() {
        return syutkkbn4;
    }

    public void setSyutkkbn4(C_SyutkKbn pSyutkkbn4) {
        syutkkbn4 = pSyutkkbn4;
    }

    private C_SyutkKbn syutkkbn5;

    @Type(type="UserType_C_SyutkKbn")
    @Column(name=GenIT_SougouTuuti.SYUTKKBN5)
    public C_SyutkKbn getSyutkkbn5() {
        return syutkkbn5;
    }

    public void setSyutkkbn5(C_SyutkKbn pSyutkkbn5) {
        syutkkbn5 = pSyutkkbn5;
    }

    private C_SyutkKbn syutkkbn6;

    @Type(type="UserType_C_SyutkKbn")
    @Column(name=GenIT_SougouTuuti.SYUTKKBN6)
    public C_SyutkKbn getSyutkkbn6() {
        return syutkkbn6;
    }

    public void setSyutkkbn6(C_SyutkKbn pSyutkkbn6) {
        syutkkbn6 = pSyutkkbn6;
    }

    private C_SyutkKbn syutkkbn7;

    @Type(type="UserType_C_SyutkKbn")
    @Column(name=GenIT_SougouTuuti.SYUTKKBN7)
    public C_SyutkKbn getSyutkkbn7() {
        return syutkkbn7;
    }

    public void setSyutkkbn7(C_SyutkKbn pSyutkkbn7) {
        syutkkbn7 = pSyutkkbn7;
    }

    private C_SyutkKbn syutkkbn8;

    @Type(type="UserType_C_SyutkKbn")
    @Column(name=GenIT_SougouTuuti.SYUTKKBN8)
    public C_SyutkKbn getSyutkkbn8() {
        return syutkkbn8;
    }

    public void setSyutkkbn8(C_SyutkKbn pSyutkkbn8) {
        syutkkbn8 = pSyutkkbn8;
    }

    private C_SyutkKbn syutkkbn9;

    @Type(type="UserType_C_SyutkKbn")
    @Column(name=GenIT_SougouTuuti.SYUTKKBN9)
    public C_SyutkKbn getSyutkkbn9() {
        return syutkkbn9;
    }

    public void setSyutkkbn9(C_SyutkKbn pSyutkkbn9) {
        syutkkbn9 = pSyutkkbn9;
    }

    private C_SyutkKbn syutkkbn10;

    @Type(type="UserType_C_SyutkKbn")
    @Column(name=GenIT_SougouTuuti.SYUTKKBN10)
    public C_SyutkKbn getSyutkkbn10() {
        return syutkkbn10;
    }

    public void setSyutkkbn10(C_SyutkKbn pSyutkkbn10) {
        syutkkbn10 = pSyutkkbn10;
    }

    private String syouhncd1;

    @Column(name=GenIT_SougouTuuti.SYOUHNCD1)
    public String getSyouhncd1() {
        return syouhncd1;
    }

    public void setSyouhncd1(String pSyouhncd1) {
        syouhncd1 = pSyouhncd1;
    }

    private String syouhncd2;

    @Column(name=GenIT_SougouTuuti.SYOUHNCD2)
    public String getSyouhncd2() {
        return syouhncd2;
    }

    public void setSyouhncd2(String pSyouhncd2) {
        syouhncd2 = pSyouhncd2;
    }

    private String syouhncd3;

    @Column(name=GenIT_SougouTuuti.SYOUHNCD3)
    public String getSyouhncd3() {
        return syouhncd3;
    }

    public void setSyouhncd3(String pSyouhncd3) {
        syouhncd3 = pSyouhncd3;
    }

    private String syouhncd4;

    @Column(name=GenIT_SougouTuuti.SYOUHNCD4)
    public String getSyouhncd4() {
        return syouhncd4;
    }

    public void setSyouhncd4(String pSyouhncd4) {
        syouhncd4 = pSyouhncd4;
    }

    private String syouhncd5;

    @Column(name=GenIT_SougouTuuti.SYOUHNCD5)
    public String getSyouhncd5() {
        return syouhncd5;
    }

    public void setSyouhncd5(String pSyouhncd5) {
        syouhncd5 = pSyouhncd5;
    }

    private String syouhncd6;

    @Column(name=GenIT_SougouTuuti.SYOUHNCD6)
    public String getSyouhncd6() {
        return syouhncd6;
    }

    public void setSyouhncd6(String pSyouhncd6) {
        syouhncd6 = pSyouhncd6;
    }

    private String syouhncd7;

    @Column(name=GenIT_SougouTuuti.SYOUHNCD7)
    public String getSyouhncd7() {
        return syouhncd7;
    }

    public void setSyouhncd7(String pSyouhncd7) {
        syouhncd7 = pSyouhncd7;
    }

    private String syouhncd8;

    @Column(name=GenIT_SougouTuuti.SYOUHNCD8)
    public String getSyouhncd8() {
        return syouhncd8;
    }

    public void setSyouhncd8(String pSyouhncd8) {
        syouhncd8 = pSyouhncd8;
    }

    private String syouhncd9;

    @Column(name=GenIT_SougouTuuti.SYOUHNCD9)
    public String getSyouhncd9() {
        return syouhncd9;
    }

    public void setSyouhncd9(String pSyouhncd9) {
        syouhncd9 = pSyouhncd9;
    }

    private String syouhncd10;

    @Column(name=GenIT_SougouTuuti.SYOUHNCD10)
    public String getSyouhncd10() {
        return syouhncd10;
    }

    public void setSyouhncd10(String pSyouhncd10) {
        syouhncd10 = pSyouhncd10;
    }

    private Integer syouhnsdno1;

    @Column(name=GenIT_SougouTuuti.SYOUHNSDNO1)
    public Integer getSyouhnsdno1() {
        return syouhnsdno1;
    }

    public void setSyouhnsdno1(Integer pSyouhnsdno1) {
        syouhnsdno1 = pSyouhnsdno1;
    }

    private Integer syouhnsdno2;

    @Column(name=GenIT_SougouTuuti.SYOUHNSDNO2)
    public Integer getSyouhnsdno2() {
        return syouhnsdno2;
    }

    public void setSyouhnsdno2(Integer pSyouhnsdno2) {
        syouhnsdno2 = pSyouhnsdno2;
    }

    private Integer syouhnsdno3;

    @Column(name=GenIT_SougouTuuti.SYOUHNSDNO3)
    public Integer getSyouhnsdno3() {
        return syouhnsdno3;
    }

    public void setSyouhnsdno3(Integer pSyouhnsdno3) {
        syouhnsdno3 = pSyouhnsdno3;
    }

    private Integer syouhnsdno4;

    @Column(name=GenIT_SougouTuuti.SYOUHNSDNO4)
    public Integer getSyouhnsdno4() {
        return syouhnsdno4;
    }

    public void setSyouhnsdno4(Integer pSyouhnsdno4) {
        syouhnsdno4 = pSyouhnsdno4;
    }

    private Integer syouhnsdno5;

    @Column(name=GenIT_SougouTuuti.SYOUHNSDNO5)
    public Integer getSyouhnsdno5() {
        return syouhnsdno5;
    }

    public void setSyouhnsdno5(Integer pSyouhnsdno5) {
        syouhnsdno5 = pSyouhnsdno5;
    }

    private Integer syouhnsdno6;

    @Column(name=GenIT_SougouTuuti.SYOUHNSDNO6)
    public Integer getSyouhnsdno6() {
        return syouhnsdno6;
    }

    public void setSyouhnsdno6(Integer pSyouhnsdno6) {
        syouhnsdno6 = pSyouhnsdno6;
    }

    private Integer syouhnsdno7;

    @Column(name=GenIT_SougouTuuti.SYOUHNSDNO7)
    public Integer getSyouhnsdno7() {
        return syouhnsdno7;
    }

    public void setSyouhnsdno7(Integer pSyouhnsdno7) {
        syouhnsdno7 = pSyouhnsdno7;
    }

    private Integer syouhnsdno8;

    @Column(name=GenIT_SougouTuuti.SYOUHNSDNO8)
    public Integer getSyouhnsdno8() {
        return syouhnsdno8;
    }

    public void setSyouhnsdno8(Integer pSyouhnsdno8) {
        syouhnsdno8 = pSyouhnsdno8;
    }

    private Integer syouhnsdno9;

    @Column(name=GenIT_SougouTuuti.SYOUHNSDNO9)
    public Integer getSyouhnsdno9() {
        return syouhnsdno9;
    }

    public void setSyouhnsdno9(Integer pSyouhnsdno9) {
        syouhnsdno9 = pSyouhnsdno9;
    }

    private Integer syouhnsdno10;

    @Column(name=GenIT_SougouTuuti.SYOUHNSDNO10)
    public Integer getSyouhnsdno10() {
        return syouhnsdno10;
    }

    public void setSyouhnsdno10(Integer pSyouhnsdno10) {
        syouhnsdno10 = pSyouhnsdno10;
    }

    private Integer kyksyouhnrenno1;

    @Column(name=GenIT_SougouTuuti.KYKSYOUHNRENNO1)
    public Integer getKyksyouhnrenno1() {
        return kyksyouhnrenno1;
    }

    public void setKyksyouhnrenno1(Integer pKyksyouhnrenno1) {
        kyksyouhnrenno1 = pKyksyouhnrenno1;
    }

    private Integer kyksyouhnrenno2;

    @Column(name=GenIT_SougouTuuti.KYKSYOUHNRENNO2)
    public Integer getKyksyouhnrenno2() {
        return kyksyouhnrenno2;
    }

    public void setKyksyouhnrenno2(Integer pKyksyouhnrenno2) {
        kyksyouhnrenno2 = pKyksyouhnrenno2;
    }

    private Integer kyksyouhnrenno3;

    @Column(name=GenIT_SougouTuuti.KYKSYOUHNRENNO3)
    public Integer getKyksyouhnrenno3() {
        return kyksyouhnrenno3;
    }

    public void setKyksyouhnrenno3(Integer pKyksyouhnrenno3) {
        kyksyouhnrenno3 = pKyksyouhnrenno3;
    }

    private Integer kyksyouhnrenno4;

    @Column(name=GenIT_SougouTuuti.KYKSYOUHNRENNO4)
    public Integer getKyksyouhnrenno4() {
        return kyksyouhnrenno4;
    }

    public void setKyksyouhnrenno4(Integer pKyksyouhnrenno4) {
        kyksyouhnrenno4 = pKyksyouhnrenno4;
    }

    private Integer kyksyouhnrenno5;

    @Column(name=GenIT_SougouTuuti.KYKSYOUHNRENNO5)
    public Integer getKyksyouhnrenno5() {
        return kyksyouhnrenno5;
    }

    public void setKyksyouhnrenno5(Integer pKyksyouhnrenno5) {
        kyksyouhnrenno5 = pKyksyouhnrenno5;
    }

    private Integer kyksyouhnrenno6;

    @Column(name=GenIT_SougouTuuti.KYKSYOUHNRENNO6)
    public Integer getKyksyouhnrenno6() {
        return kyksyouhnrenno6;
    }

    public void setKyksyouhnrenno6(Integer pKyksyouhnrenno6) {
        kyksyouhnrenno6 = pKyksyouhnrenno6;
    }

    private Integer kyksyouhnrenno7;

    @Column(name=GenIT_SougouTuuti.KYKSYOUHNRENNO7)
    public Integer getKyksyouhnrenno7() {
        return kyksyouhnrenno7;
    }

    public void setKyksyouhnrenno7(Integer pKyksyouhnrenno7) {
        kyksyouhnrenno7 = pKyksyouhnrenno7;
    }

    private Integer kyksyouhnrenno8;

    @Column(name=GenIT_SougouTuuti.KYKSYOUHNRENNO8)
    public Integer getKyksyouhnrenno8() {
        return kyksyouhnrenno8;
    }

    public void setKyksyouhnrenno8(Integer pKyksyouhnrenno8) {
        kyksyouhnrenno8 = pKyksyouhnrenno8;
    }

    private Integer kyksyouhnrenno9;

    @Column(name=GenIT_SougouTuuti.KYKSYOUHNRENNO9)
    public Integer getKyksyouhnrenno9() {
        return kyksyouhnrenno9;
    }

    public void setKyksyouhnrenno9(Integer pKyksyouhnrenno9) {
        kyksyouhnrenno9 = pKyksyouhnrenno9;
    }

    private Integer kyksyouhnrenno10;

    @Column(name=GenIT_SougouTuuti.KYKSYOUHNRENNO10)
    public Integer getKyksyouhnrenno10() {
        return kyksyouhnrenno10;
    }

    public void setKyksyouhnrenno10(Integer pKyksyouhnrenno10) {
        kyksyouhnrenno10 = pKyksyouhnrenno10;
    }

    private C_KyhgndkataKbn kyhgndkatakbn1;

    @Type(type="UserType_C_KyhgndkataKbn")
    @Column(name=GenIT_SougouTuuti.KYHGNDKATAKBN1)
    public C_KyhgndkataKbn getKyhgndkatakbn1() {
        return kyhgndkatakbn1;
    }

    public void setKyhgndkatakbn1(C_KyhgndkataKbn pKyhgndkatakbn1) {
        kyhgndkatakbn1 = pKyhgndkatakbn1;
    }

    private C_KyhgndkataKbn kyhgndkatakbn2;

    @Type(type="UserType_C_KyhgndkataKbn")
    @Column(name=GenIT_SougouTuuti.KYHGNDKATAKBN2)
    public C_KyhgndkataKbn getKyhgndkatakbn2() {
        return kyhgndkatakbn2;
    }

    public void setKyhgndkatakbn2(C_KyhgndkataKbn pKyhgndkatakbn2) {
        kyhgndkatakbn2 = pKyhgndkatakbn2;
    }

    private C_KyhgndkataKbn kyhgndkatakbn3;

    @Type(type="UserType_C_KyhgndkataKbn")
    @Column(name=GenIT_SougouTuuti.KYHGNDKATAKBN3)
    public C_KyhgndkataKbn getKyhgndkatakbn3() {
        return kyhgndkatakbn3;
    }

    public void setKyhgndkatakbn3(C_KyhgndkataKbn pKyhgndkatakbn3) {
        kyhgndkatakbn3 = pKyhgndkatakbn3;
    }

    private C_KyhgndkataKbn kyhgndkatakbn4;

    @Type(type="UserType_C_KyhgndkataKbn")
    @Column(name=GenIT_SougouTuuti.KYHGNDKATAKBN4)
    public C_KyhgndkataKbn getKyhgndkatakbn4() {
        return kyhgndkatakbn4;
    }

    public void setKyhgndkatakbn4(C_KyhgndkataKbn pKyhgndkatakbn4) {
        kyhgndkatakbn4 = pKyhgndkatakbn4;
    }

    private C_KyhgndkataKbn kyhgndkatakbn5;

    @Type(type="UserType_C_KyhgndkataKbn")
    @Column(name=GenIT_SougouTuuti.KYHGNDKATAKBN5)
    public C_KyhgndkataKbn getKyhgndkatakbn5() {
        return kyhgndkatakbn5;
    }

    public void setKyhgndkatakbn5(C_KyhgndkataKbn pKyhgndkatakbn5) {
        kyhgndkatakbn5 = pKyhgndkatakbn5;
    }

    private C_KyhgndkataKbn kyhgndkatakbn6;

    @Type(type="UserType_C_KyhgndkataKbn")
    @Column(name=GenIT_SougouTuuti.KYHGNDKATAKBN6)
    public C_KyhgndkataKbn getKyhgndkatakbn6() {
        return kyhgndkatakbn6;
    }

    public void setKyhgndkatakbn6(C_KyhgndkataKbn pKyhgndkatakbn6) {
        kyhgndkatakbn6 = pKyhgndkatakbn6;
    }

    private C_KyhgndkataKbn kyhgndkatakbn7;

    @Type(type="UserType_C_KyhgndkataKbn")
    @Column(name=GenIT_SougouTuuti.KYHGNDKATAKBN7)
    public C_KyhgndkataKbn getKyhgndkatakbn7() {
        return kyhgndkatakbn7;
    }

    public void setKyhgndkatakbn7(C_KyhgndkataKbn pKyhgndkatakbn7) {
        kyhgndkatakbn7 = pKyhgndkatakbn7;
    }

    private C_KyhgndkataKbn kyhgndkatakbn8;

    @Type(type="UserType_C_KyhgndkataKbn")
    @Column(name=GenIT_SougouTuuti.KYHGNDKATAKBN8)
    public C_KyhgndkataKbn getKyhgndkatakbn8() {
        return kyhgndkatakbn8;
    }

    public void setKyhgndkatakbn8(C_KyhgndkataKbn pKyhgndkatakbn8) {
        kyhgndkatakbn8 = pKyhgndkatakbn8;
    }

    private C_KyhgndkataKbn kyhgndkatakbn9;

    @Type(type="UserType_C_KyhgndkataKbn")
    @Column(name=GenIT_SougouTuuti.KYHGNDKATAKBN9)
    public C_KyhgndkataKbn getKyhgndkatakbn9() {
        return kyhgndkatakbn9;
    }

    public void setKyhgndkatakbn9(C_KyhgndkataKbn pKyhgndkatakbn9) {
        kyhgndkatakbn9 = pKyhgndkatakbn9;
    }

    private C_KyhgndkataKbn kyhgndkatakbn10;

    @Type(type="UserType_C_KyhgndkataKbn")
    @Column(name=GenIT_SougouTuuti.KYHGNDKATAKBN10)
    public C_KyhgndkataKbn getKyhgndkatakbn10() {
        return kyhgndkatakbn10;
    }

    public void setKyhgndkatakbn10(C_KyhgndkataKbn pKyhgndkatakbn10) {
        kyhgndkatakbn10 = pKyhgndkatakbn10;
    }

    private C_HknkknsmnKbn hknkknsmnkbn1;

    @Type(type="UserType_C_HknkknsmnKbn")
    @Column(name=GenIT_SougouTuuti.HKNKKNSMNKBN1)
    public C_HknkknsmnKbn getHknkknsmnkbn1() {
        return hknkknsmnkbn1;
    }

    public void setHknkknsmnkbn1(C_HknkknsmnKbn pHknkknsmnkbn1) {
        hknkknsmnkbn1 = pHknkknsmnkbn1;
    }

    private C_HknkknsmnKbn hknkknsmnkbn2;

    @Type(type="UserType_C_HknkknsmnKbn")
    @Column(name=GenIT_SougouTuuti.HKNKKNSMNKBN2)
    public C_HknkknsmnKbn getHknkknsmnkbn2() {
        return hknkknsmnkbn2;
    }

    public void setHknkknsmnkbn2(C_HknkknsmnKbn pHknkknsmnkbn2) {
        hknkknsmnkbn2 = pHknkknsmnkbn2;
    }

    private C_HknkknsmnKbn hknkknsmnkbn3;

    @Type(type="UserType_C_HknkknsmnKbn")
    @Column(name=GenIT_SougouTuuti.HKNKKNSMNKBN3)
    public C_HknkknsmnKbn getHknkknsmnkbn3() {
        return hknkknsmnkbn3;
    }

    public void setHknkknsmnkbn3(C_HknkknsmnKbn pHknkknsmnkbn3) {
        hknkknsmnkbn3 = pHknkknsmnkbn3;
    }

    private C_HknkknsmnKbn hknkknsmnkbn4;

    @Type(type="UserType_C_HknkknsmnKbn")
    @Column(name=GenIT_SougouTuuti.HKNKKNSMNKBN4)
    public C_HknkknsmnKbn getHknkknsmnkbn4() {
        return hknkknsmnkbn4;
    }

    public void setHknkknsmnkbn4(C_HknkknsmnKbn pHknkknsmnkbn4) {
        hknkknsmnkbn4 = pHknkknsmnkbn4;
    }

    private C_HknkknsmnKbn hknkknsmnkbn5;

    @Type(type="UserType_C_HknkknsmnKbn")
    @Column(name=GenIT_SougouTuuti.HKNKKNSMNKBN5)
    public C_HknkknsmnKbn getHknkknsmnkbn5() {
        return hknkknsmnkbn5;
    }

    public void setHknkknsmnkbn5(C_HknkknsmnKbn pHknkknsmnkbn5) {
        hknkknsmnkbn5 = pHknkknsmnkbn5;
    }

    private C_HknkknsmnKbn hknkknsmnkbn6;

    @Type(type="UserType_C_HknkknsmnKbn")
    @Column(name=GenIT_SougouTuuti.HKNKKNSMNKBN6)
    public C_HknkknsmnKbn getHknkknsmnkbn6() {
        return hknkknsmnkbn6;
    }

    public void setHknkknsmnkbn6(C_HknkknsmnKbn pHknkknsmnkbn6) {
        hknkknsmnkbn6 = pHknkknsmnkbn6;
    }

    private C_HknkknsmnKbn hknkknsmnkbn7;

    @Type(type="UserType_C_HknkknsmnKbn")
    @Column(name=GenIT_SougouTuuti.HKNKKNSMNKBN7)
    public C_HknkknsmnKbn getHknkknsmnkbn7() {
        return hknkknsmnkbn7;
    }

    public void setHknkknsmnkbn7(C_HknkknsmnKbn pHknkknsmnkbn7) {
        hknkknsmnkbn7 = pHknkknsmnkbn7;
    }

    private C_HknkknsmnKbn hknkknsmnkbn8;

    @Type(type="UserType_C_HknkknsmnKbn")
    @Column(name=GenIT_SougouTuuti.HKNKKNSMNKBN8)
    public C_HknkknsmnKbn getHknkknsmnkbn8() {
        return hknkknsmnkbn8;
    }

    public void setHknkknsmnkbn8(C_HknkknsmnKbn pHknkknsmnkbn8) {
        hknkknsmnkbn8 = pHknkknsmnkbn8;
    }

    private C_HknkknsmnKbn hknkknsmnkbn9;

    @Type(type="UserType_C_HknkknsmnKbn")
    @Column(name=GenIT_SougouTuuti.HKNKKNSMNKBN9)
    public C_HknkknsmnKbn getHknkknsmnkbn9() {
        return hknkknsmnkbn9;
    }

    public void setHknkknsmnkbn9(C_HknkknsmnKbn pHknkknsmnkbn9) {
        hknkknsmnkbn9 = pHknkknsmnkbn9;
    }

    private C_HknkknsmnKbn hknkknsmnkbn10;

    @Type(type="UserType_C_HknkknsmnKbn")
    @Column(name=GenIT_SougouTuuti.HKNKKNSMNKBN10)
    public C_HknkknsmnKbn getHknkknsmnkbn10() {
        return hknkknsmnkbn10;
    }

    public void setHknkknsmnkbn10(C_HknkknsmnKbn pHknkknsmnkbn10) {
        hknkknsmnkbn10 = pHknkknsmnkbn10;
    }

    private Integer hknkkn1;

    @Column(name=GenIT_SougouTuuti.HKNKKN1)
    public Integer getHknkkn1() {
        return hknkkn1;
    }

    public void setHknkkn1(Integer pHknkkn1) {
        hknkkn1 = pHknkkn1;
    }

    private Integer hknkkn2;

    @Column(name=GenIT_SougouTuuti.HKNKKN2)
    public Integer getHknkkn2() {
        return hknkkn2;
    }

    public void setHknkkn2(Integer pHknkkn2) {
        hknkkn2 = pHknkkn2;
    }

    private Integer hknkkn3;

    @Column(name=GenIT_SougouTuuti.HKNKKN3)
    public Integer getHknkkn3() {
        return hknkkn3;
    }

    public void setHknkkn3(Integer pHknkkn3) {
        hknkkn3 = pHknkkn3;
    }

    private Integer hknkkn4;

    @Column(name=GenIT_SougouTuuti.HKNKKN4)
    public Integer getHknkkn4() {
        return hknkkn4;
    }

    public void setHknkkn4(Integer pHknkkn4) {
        hknkkn4 = pHknkkn4;
    }

    private Integer hknkkn5;

    @Column(name=GenIT_SougouTuuti.HKNKKN5)
    public Integer getHknkkn5() {
        return hknkkn5;
    }

    public void setHknkkn5(Integer pHknkkn5) {
        hknkkn5 = pHknkkn5;
    }

    private Integer hknkkn6;

    @Column(name=GenIT_SougouTuuti.HKNKKN6)
    public Integer getHknkkn6() {
        return hknkkn6;
    }

    public void setHknkkn6(Integer pHknkkn6) {
        hknkkn6 = pHknkkn6;
    }

    private Integer hknkkn7;

    @Column(name=GenIT_SougouTuuti.HKNKKN7)
    public Integer getHknkkn7() {
        return hknkkn7;
    }

    public void setHknkkn7(Integer pHknkkn7) {
        hknkkn7 = pHknkkn7;
    }

    private Integer hknkkn8;

    @Column(name=GenIT_SougouTuuti.HKNKKN8)
    public Integer getHknkkn8() {
        return hknkkn8;
    }

    public void setHknkkn8(Integer pHknkkn8) {
        hknkkn8 = pHknkkn8;
    }

    private Integer hknkkn9;

    @Column(name=GenIT_SougouTuuti.HKNKKN9)
    public Integer getHknkkn9() {
        return hknkkn9;
    }

    public void setHknkkn9(Integer pHknkkn9) {
        hknkkn9 = pHknkkn9;
    }

    private Integer hknkkn10;

    @Column(name=GenIT_SougouTuuti.HKNKKN10)
    public Integer getHknkkn10() {
        return hknkkn10;
    }

    public void setHknkkn10(Integer pHknkkn10) {
        hknkkn10 = pHknkkn10;
    }

    private C_HrkkknsmnKbn hrkkknsmnkbn1;

    @Type(type="UserType_C_HrkkknsmnKbn")
    @Column(name=GenIT_SougouTuuti.HRKKKNSMNKBN1)
    public C_HrkkknsmnKbn getHrkkknsmnkbn1() {
        return hrkkknsmnkbn1;
    }

    public void setHrkkknsmnkbn1(C_HrkkknsmnKbn pHrkkknsmnkbn1) {
        hrkkknsmnkbn1 = pHrkkknsmnkbn1;
    }

    private C_HrkkknsmnKbn hrkkknsmnkbn2;

    @Type(type="UserType_C_HrkkknsmnKbn")
    @Column(name=GenIT_SougouTuuti.HRKKKNSMNKBN2)
    public C_HrkkknsmnKbn getHrkkknsmnkbn2() {
        return hrkkknsmnkbn2;
    }

    public void setHrkkknsmnkbn2(C_HrkkknsmnKbn pHrkkknsmnkbn2) {
        hrkkknsmnkbn2 = pHrkkknsmnkbn2;
    }

    private C_HrkkknsmnKbn hrkkknsmnkbn3;

    @Type(type="UserType_C_HrkkknsmnKbn")
    @Column(name=GenIT_SougouTuuti.HRKKKNSMNKBN3)
    public C_HrkkknsmnKbn getHrkkknsmnkbn3() {
        return hrkkknsmnkbn3;
    }

    public void setHrkkknsmnkbn3(C_HrkkknsmnKbn pHrkkknsmnkbn3) {
        hrkkknsmnkbn3 = pHrkkknsmnkbn3;
    }

    private C_HrkkknsmnKbn hrkkknsmnkbn4;

    @Type(type="UserType_C_HrkkknsmnKbn")
    @Column(name=GenIT_SougouTuuti.HRKKKNSMNKBN4)
    public C_HrkkknsmnKbn getHrkkknsmnkbn4() {
        return hrkkknsmnkbn4;
    }

    public void setHrkkknsmnkbn4(C_HrkkknsmnKbn pHrkkknsmnkbn4) {
        hrkkknsmnkbn4 = pHrkkknsmnkbn4;
    }

    private C_HrkkknsmnKbn hrkkknsmnkbn5;

    @Type(type="UserType_C_HrkkknsmnKbn")
    @Column(name=GenIT_SougouTuuti.HRKKKNSMNKBN5)
    public C_HrkkknsmnKbn getHrkkknsmnkbn5() {
        return hrkkknsmnkbn5;
    }

    public void setHrkkknsmnkbn5(C_HrkkknsmnKbn pHrkkknsmnkbn5) {
        hrkkknsmnkbn5 = pHrkkknsmnkbn5;
    }

    private C_HrkkknsmnKbn hrkkknsmnkbn6;

    @Type(type="UserType_C_HrkkknsmnKbn")
    @Column(name=GenIT_SougouTuuti.HRKKKNSMNKBN6)
    public C_HrkkknsmnKbn getHrkkknsmnkbn6() {
        return hrkkknsmnkbn6;
    }

    public void setHrkkknsmnkbn6(C_HrkkknsmnKbn pHrkkknsmnkbn6) {
        hrkkknsmnkbn6 = pHrkkknsmnkbn6;
    }

    private C_HrkkknsmnKbn hrkkknsmnkbn7;

    @Type(type="UserType_C_HrkkknsmnKbn")
    @Column(name=GenIT_SougouTuuti.HRKKKNSMNKBN7)
    public C_HrkkknsmnKbn getHrkkknsmnkbn7() {
        return hrkkknsmnkbn7;
    }

    public void setHrkkknsmnkbn7(C_HrkkknsmnKbn pHrkkknsmnkbn7) {
        hrkkknsmnkbn7 = pHrkkknsmnkbn7;
    }

    private C_HrkkknsmnKbn hrkkknsmnkbn8;

    @Type(type="UserType_C_HrkkknsmnKbn")
    @Column(name=GenIT_SougouTuuti.HRKKKNSMNKBN8)
    public C_HrkkknsmnKbn getHrkkknsmnkbn8() {
        return hrkkknsmnkbn8;
    }

    public void setHrkkknsmnkbn8(C_HrkkknsmnKbn pHrkkknsmnkbn8) {
        hrkkknsmnkbn8 = pHrkkknsmnkbn8;
    }

    private C_HrkkknsmnKbn hrkkknsmnkbn9;

    @Type(type="UserType_C_HrkkknsmnKbn")
    @Column(name=GenIT_SougouTuuti.HRKKKNSMNKBN9)
    public C_HrkkknsmnKbn getHrkkknsmnkbn9() {
        return hrkkknsmnkbn9;
    }

    public void setHrkkknsmnkbn9(C_HrkkknsmnKbn pHrkkknsmnkbn9) {
        hrkkknsmnkbn9 = pHrkkknsmnkbn9;
    }

    private C_HrkkknsmnKbn hrkkknsmnkbn10;

    @Type(type="UserType_C_HrkkknsmnKbn")
    @Column(name=GenIT_SougouTuuti.HRKKKNSMNKBN10)
    public C_HrkkknsmnKbn getHrkkknsmnkbn10() {
        return hrkkknsmnkbn10;
    }

    public void setHrkkknsmnkbn10(C_HrkkknsmnKbn pHrkkknsmnkbn10) {
        hrkkknsmnkbn10 = pHrkkknsmnkbn10;
    }

    private Integer hrkkkn1;

    @Column(name=GenIT_SougouTuuti.HRKKKN1)
    public Integer getHrkkkn1() {
        return hrkkkn1;
    }

    public void setHrkkkn1(Integer pHrkkkn1) {
        hrkkkn1 = pHrkkkn1;
    }

    private Integer hrkkkn2;

    @Column(name=GenIT_SougouTuuti.HRKKKN2)
    public Integer getHrkkkn2() {
        return hrkkkn2;
    }

    public void setHrkkkn2(Integer pHrkkkn2) {
        hrkkkn2 = pHrkkkn2;
    }

    private Integer hrkkkn3;

    @Column(name=GenIT_SougouTuuti.HRKKKN3)
    public Integer getHrkkkn3() {
        return hrkkkn3;
    }

    public void setHrkkkn3(Integer pHrkkkn3) {
        hrkkkn3 = pHrkkkn3;
    }

    private Integer hrkkkn4;

    @Column(name=GenIT_SougouTuuti.HRKKKN4)
    public Integer getHrkkkn4() {
        return hrkkkn4;
    }

    public void setHrkkkn4(Integer pHrkkkn4) {
        hrkkkn4 = pHrkkkn4;
    }

    private Integer hrkkkn5;

    @Column(name=GenIT_SougouTuuti.HRKKKN5)
    public Integer getHrkkkn5() {
        return hrkkkn5;
    }

    public void setHrkkkn5(Integer pHrkkkn5) {
        hrkkkn5 = pHrkkkn5;
    }

    private Integer hrkkkn6;

    @Column(name=GenIT_SougouTuuti.HRKKKN6)
    public Integer getHrkkkn6() {
        return hrkkkn6;
    }

    public void setHrkkkn6(Integer pHrkkkn6) {
        hrkkkn6 = pHrkkkn6;
    }

    private Integer hrkkkn7;

    @Column(name=GenIT_SougouTuuti.HRKKKN7)
    public Integer getHrkkkn7() {
        return hrkkkn7;
    }

    public void setHrkkkn7(Integer pHrkkkn7) {
        hrkkkn7 = pHrkkkn7;
    }

    private Integer hrkkkn8;

    @Column(name=GenIT_SougouTuuti.HRKKKN8)
    public Integer getHrkkkn8() {
        return hrkkkn8;
    }

    public void setHrkkkn8(Integer pHrkkkn8) {
        hrkkkn8 = pHrkkkn8;
    }

    private Integer hrkkkn9;

    @Column(name=GenIT_SougouTuuti.HRKKKN9)
    public Integer getHrkkkn9() {
        return hrkkkn9;
    }

    public void setHrkkkn9(Integer pHrkkkn9) {
        hrkkkn9 = pHrkkkn9;
    }

    private Integer hrkkkn10;

    @Column(name=GenIT_SougouTuuti.HRKKKN10)
    public Integer getHrkkkn10() {
        return hrkkkn10;
    }

    public void setHrkkkn10(Integer pHrkkkn10) {
        hrkkkn10 = pHrkkkn10;
    }

    private String syouhnnm1;

    @Column(name=GenIT_SougouTuuti.SYOUHNNM1)
    public String getSyouhnnm1() {
        return syouhnnm1;
    }

    public void setSyouhnnm1(String pSyouhnnm1) {
        syouhnnm1 = pSyouhnnm1;
    }

    private String syouhnnm2;

    @Column(name=GenIT_SougouTuuti.SYOUHNNM2)
    public String getSyouhnnm2() {
        return syouhnnm2;
    }

    public void setSyouhnnm2(String pSyouhnnm2) {
        syouhnnm2 = pSyouhnnm2;
    }

    private String syouhnnm3;

    @Column(name=GenIT_SougouTuuti.SYOUHNNM3)
    public String getSyouhnnm3() {
        return syouhnnm3;
    }

    public void setSyouhnnm3(String pSyouhnnm3) {
        syouhnnm3 = pSyouhnnm3;
    }

    private String syouhnnm4;

    @Column(name=GenIT_SougouTuuti.SYOUHNNM4)
    public String getSyouhnnm4() {
        return syouhnnm4;
    }

    public void setSyouhnnm4(String pSyouhnnm4) {
        syouhnnm4 = pSyouhnnm4;
    }

    private String syouhnnm5;

    @Column(name=GenIT_SougouTuuti.SYOUHNNM5)
    public String getSyouhnnm5() {
        return syouhnnm5;
    }

    public void setSyouhnnm5(String pSyouhnnm5) {
        syouhnnm5 = pSyouhnnm5;
    }

    private String syouhnnm6;

    @Column(name=GenIT_SougouTuuti.SYOUHNNM6)
    public String getSyouhnnm6() {
        return syouhnnm6;
    }

    public void setSyouhnnm6(String pSyouhnnm6) {
        syouhnnm6 = pSyouhnnm6;
    }

    private String syouhnnm7;

    @Column(name=GenIT_SougouTuuti.SYOUHNNM7)
    public String getSyouhnnm7() {
        return syouhnnm7;
    }

    public void setSyouhnnm7(String pSyouhnnm7) {
        syouhnnm7 = pSyouhnnm7;
    }

    private String syouhnnm8;

    @Column(name=GenIT_SougouTuuti.SYOUHNNM8)
    public String getSyouhnnm8() {
        return syouhnnm8;
    }

    public void setSyouhnnm8(String pSyouhnnm8) {
        syouhnnm8 = pSyouhnnm8;
    }

    private String syouhnnm9;

    @Column(name=GenIT_SougouTuuti.SYOUHNNM9)
    public String getSyouhnnm9() {
        return syouhnnm9;
    }

    public void setSyouhnnm9(String pSyouhnnm9) {
        syouhnnm9 = pSyouhnnm9;
    }

    private String syouhnnm10;

    @Column(name=GenIT_SougouTuuti.SYOUHNNM10)
    public String getSyouhnnm10() {
        return syouhnnm10;
    }

    public void setSyouhnnm10(String pSyouhnnm10) {
        syouhnnm10 = pSyouhnnm10;
    }

    private BizCurrency kihons1;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKihons1() {
        return kihons1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihons1(BizCurrency pKihons1) {
        kihons1 = pKihons1;
        kihons1Value = null;
        kihons1Type  = null;
    }

    transient private BigDecimal kihons1Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIHONS1, nullable=true)
    protected BigDecimal getKihons1Value() {
        if (kihons1Value == null && kihons1 != null) {
            if (kihons1.isOptional()) return null;
            return kihons1.absolute();
        }
        return kihons1Value;
    }

    protected void setKihons1Value(BigDecimal value) {
        kihons1Value = value;
        kihons1 = Optional.fromNullable(toCurrencyType(kihons1Type))
            .transform(bizCurrencyTransformer(getKihons1Value()))
            .orNull();
    }

    transient private String kihons1Type = null;

    @Column(name=KIHONS1 + "$", nullable=true)
    protected String getKihons1Type() {
        if (kihons1Type == null && kihons1 != null) return kihons1.getType().toString();
        if (kihons1Type == null && getKihons1Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kihons1$' should not be NULL."));
        }
        return kihons1Type;
    }

    protected void setKihons1Type(String type) {
        kihons1Type = type;
        kihons1 = Optional.fromNullable(toCurrencyType(kihons1Type))
            .transform(bizCurrencyTransformer(getKihons1Value()))
            .orNull();
    }

    private BizCurrency kihons2;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getKihons2() {
        return kihons2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihons2(BizCurrency pKihons2) {
        kihons2 = pKihons2;
        kihons2Value = null;
        kihons2Type  = null;
    }

    transient private BigDecimal kihons2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIHONS2, nullable=true)
    protected BigDecimal getKihons2Value() {
        if (kihons2Value == null && kihons2 != null) {
            if (kihons2.isOptional()) return null;
            return kihons2.absolute();
        }
        return kihons2Value;
    }

    protected void setKihons2Value(BigDecimal value) {
        kihons2Value = value;
        kihons2 = Optional.fromNullable(toCurrencyType(kihons2Type))
            .transform(bizCurrencyTransformer(getKihons2Value()))
            .orNull();
    }

    transient private String kihons2Type = null;

    @Column(name=KIHONS2 + "$", nullable=true)
    protected String getKihons2Type() {
        if (kihons2Type == null && kihons2 != null) return kihons2.getType().toString();
        if (kihons2Type == null && getKihons2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kihons2$' should not be NULL."));
        }
        return kihons2Type;
    }

    protected void setKihons2Type(String type) {
        kihons2Type = type;
        kihons2 = Optional.fromNullable(toCurrencyType(kihons2Type))
            .transform(bizCurrencyTransformer(getKihons2Value()))
            .orNull();
    }

    private BizCurrency kihons3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKihons3() {
        return kihons3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihons3(BizCurrency pKihons3) {
        kihons3 = pKihons3;
        kihons3Value = null;
        kihons3Type  = null;
    }

    transient private BigDecimal kihons3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIHONS3, nullable=true)
    protected BigDecimal getKihons3Value() {
        if (kihons3Value == null && kihons3 != null) {
            if (kihons3.isOptional()) return null;
            return kihons3.absolute();
        }
        return kihons3Value;
    }

    protected void setKihons3Value(BigDecimal value) {
        kihons3Value = value;
        kihons3 = Optional.fromNullable(toCurrencyType(kihons3Type))
            .transform(bizCurrencyTransformer(getKihons3Value()))
            .orNull();
    }

    transient private String kihons3Type = null;

    @Column(name=KIHONS3 + "$", nullable=true)
    protected String getKihons3Type() {
        if (kihons3Type == null && kihons3 != null) return kihons3.getType().toString();
        if (kihons3Type == null && getKihons3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kihons3$' should not be NULL."));
        }
        return kihons3Type;
    }

    protected void setKihons3Type(String type) {
        kihons3Type = type;
        kihons3 = Optional.fromNullable(toCurrencyType(kihons3Type))
            .transform(bizCurrencyTransformer(getKihons3Value()))
            .orNull();
    }

    private BizCurrency kihons4;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKihons4() {
        return kihons4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihons4(BizCurrency pKihons4) {
        kihons4 = pKihons4;
        kihons4Value = null;
        kihons4Type  = null;
    }

    transient private BigDecimal kihons4Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIHONS4, nullable=true)
    protected BigDecimal getKihons4Value() {
        if (kihons4Value == null && kihons4 != null) {
            if (kihons4.isOptional()) return null;
            return kihons4.absolute();
        }
        return kihons4Value;
    }

    protected void setKihons4Value(BigDecimal value) {
        kihons4Value = value;
        kihons4 = Optional.fromNullable(toCurrencyType(kihons4Type))
            .transform(bizCurrencyTransformer(getKihons4Value()))
            .orNull();
    }

    transient private String kihons4Type = null;

    @Column(name=KIHONS4 + "$", nullable=true)
    protected String getKihons4Type() {
        if (kihons4Type == null && kihons4 != null) return kihons4.getType().toString();
        if (kihons4Type == null && getKihons4Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kihons4$' should not be NULL."));
        }
        return kihons4Type;
    }

    protected void setKihons4Type(String type) {
        kihons4Type = type;
        kihons4 = Optional.fromNullable(toCurrencyType(kihons4Type))
            .transform(bizCurrencyTransformer(getKihons4Value()))
            .orNull();
    }

    private BizCurrency kihons5;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKihons5() {
        return kihons5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihons5(BizCurrency pKihons5) {
        kihons5 = pKihons5;
        kihons5Value = null;
        kihons5Type  = null;
    }

    transient private BigDecimal kihons5Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIHONS5, nullable=true)
    protected BigDecimal getKihons5Value() {
        if (kihons5Value == null && kihons5 != null) {
            if (kihons5.isOptional()) return null;
            return kihons5.absolute();
        }
        return kihons5Value;
    }

    protected void setKihons5Value(BigDecimal value) {
        kihons5Value = value;
        kihons5 = Optional.fromNullable(toCurrencyType(kihons5Type))
            .transform(bizCurrencyTransformer(getKihons5Value()))
            .orNull();
    }

    transient private String kihons5Type = null;

    @Column(name=KIHONS5 + "$", nullable=true)
    protected String getKihons5Type() {
        if (kihons5Type == null && kihons5 != null) return kihons5.getType().toString();
        if (kihons5Type == null && getKihons5Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kihons5$' should not be NULL."));
        }
        return kihons5Type;
    }

    protected void setKihons5Type(String type) {
        kihons5Type = type;
        kihons5 = Optional.fromNullable(toCurrencyType(kihons5Type))
            .transform(bizCurrencyTransformer(getKihons5Value()))
            .orNull();
    }

    private BizCurrency kihons6;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKihons6() {
        return kihons6;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihons6(BizCurrency pKihons6) {
        kihons6 = pKihons6;
        kihons6Value = null;
        kihons6Type  = null;
    }

    transient private BigDecimal kihons6Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIHONS6, nullable=true)
    protected BigDecimal getKihons6Value() {
        if (kihons6Value == null && kihons6 != null) {
            if (kihons6.isOptional()) return null;
            return kihons6.absolute();
        }
        return kihons6Value;
    }

    protected void setKihons6Value(BigDecimal value) {
        kihons6Value = value;
        kihons6 = Optional.fromNullable(toCurrencyType(kihons6Type))
            .transform(bizCurrencyTransformer(getKihons6Value()))
            .orNull();
    }

    transient private String kihons6Type = null;

    @Column(name=KIHONS6 + "$", nullable=true)
    protected String getKihons6Type() {
        if (kihons6Type == null && kihons6 != null) return kihons6.getType().toString();
        if (kihons6Type == null && getKihons6Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kihons6$' should not be NULL."));
        }
        return kihons6Type;
    }

    protected void setKihons6Type(String type) {
        kihons6Type = type;
        kihons6 = Optional.fromNullable(toCurrencyType(kihons6Type))
            .transform(bizCurrencyTransformer(getKihons6Value()))
            .orNull();
    }

    private BizCurrency kihons7;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKihons7() {
        return kihons7;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihons7(BizCurrency pKihons7) {
        kihons7 = pKihons7;
        kihons7Value = null;
        kihons7Type  = null;
    }

    transient private BigDecimal kihons7Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIHONS7, nullable=true)
    protected BigDecimal getKihons7Value() {
        if (kihons7Value == null && kihons7 != null) {
            if (kihons7.isOptional()) return null;
            return kihons7.absolute();
        }
        return kihons7Value;
    }

    protected void setKihons7Value(BigDecimal value) {
        kihons7Value = value;
        kihons7 = Optional.fromNullable(toCurrencyType(kihons7Type))
            .transform(bizCurrencyTransformer(getKihons7Value()))
            .orNull();
    }

    transient private String kihons7Type = null;

    @Column(name=KIHONS7 + "$", nullable=true)
    protected String getKihons7Type() {
        if (kihons7Type == null && kihons7 != null) return kihons7.getType().toString();
        if (kihons7Type == null && getKihons7Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kihons7$' should not be NULL."));
        }
        return kihons7Type;
    }

    protected void setKihons7Type(String type) {
        kihons7Type = type;
        kihons7 = Optional.fromNullable(toCurrencyType(kihons7Type))
            .transform(bizCurrencyTransformer(getKihons7Value()))
            .orNull();
    }

    private BizCurrency kihons8;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKihons8() {
        return kihons8;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihons8(BizCurrency pKihons8) {
        kihons8 = pKihons8;
        kihons8Value = null;
        kihons8Type  = null;
    }

    transient private BigDecimal kihons8Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIHONS8, nullable=true)
    protected BigDecimal getKihons8Value() {
        if (kihons8Value == null && kihons8 != null) {
            if (kihons8.isOptional()) return null;
            return kihons8.absolute();
        }
        return kihons8Value;
    }

    protected void setKihons8Value(BigDecimal value) {
        kihons8Value = value;
        kihons8 = Optional.fromNullable(toCurrencyType(kihons8Type))
            .transform(bizCurrencyTransformer(getKihons8Value()))
            .orNull();
    }

    transient private String kihons8Type = null;

    @Column(name=KIHONS8 + "$", nullable=true)
    protected String getKihons8Type() {
        if (kihons8Type == null && kihons8 != null) return kihons8.getType().toString();
        if (kihons8Type == null && getKihons8Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kihons8$' should not be NULL."));
        }
        return kihons8Type;
    }

    protected void setKihons8Type(String type) {
        kihons8Type = type;
        kihons8 = Optional.fromNullable(toCurrencyType(kihons8Type))
            .transform(bizCurrencyTransformer(getKihons8Value()))
            .orNull();
    }

    private BizCurrency kihons9;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKihons9() {
        return kihons9;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihons9(BizCurrency pKihons9) {
        kihons9 = pKihons9;
        kihons9Value = null;
        kihons9Type  = null;
    }

    transient private BigDecimal kihons9Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIHONS9, nullable=true)
    protected BigDecimal getKihons9Value() {
        if (kihons9Value == null && kihons9 != null) {
            if (kihons9.isOptional()) return null;
            return kihons9.absolute();
        }
        return kihons9Value;
    }

    protected void setKihons9Value(BigDecimal value) {
        kihons9Value = value;
        kihons9 = Optional.fromNullable(toCurrencyType(kihons9Type))
            .transform(bizCurrencyTransformer(getKihons9Value()))
            .orNull();
    }

    transient private String kihons9Type = null;

    @Column(name=KIHONS9 + "$", nullable=true)
    protected String getKihons9Type() {
        if (kihons9Type == null && kihons9 != null) return kihons9.getType().toString();
        if (kihons9Type == null && getKihons9Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kihons9$' should not be NULL."));
        }
        return kihons9Type;
    }

    protected void setKihons9Type(String type) {
        kihons9Type = type;
        kihons9 = Optional.fromNullable(toCurrencyType(kihons9Type))
            .transform(bizCurrencyTransformer(getKihons9Value()))
            .orNull();
    }

    private BizCurrency kihons10;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKihons10() {
        return kihons10;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihons10(BizCurrency pKihons10) {
        kihons10 = pKihons10;
        kihons10Value = null;
        kihons10Type  = null;
    }

    transient private BigDecimal kihons10Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIHONS10, nullable=true)
    protected BigDecimal getKihons10Value() {
        if (kihons10Value == null && kihons10 != null) {
            if (kihons10.isOptional()) return null;
            return kihons10.absolute();
        }
        return kihons10Value;
    }

    protected void setKihons10Value(BigDecimal value) {
        kihons10Value = value;
        kihons10 = Optional.fromNullable(toCurrencyType(kihons10Type))
            .transform(bizCurrencyTransformer(getKihons10Value()))
            .orNull();
    }

    transient private String kihons10Type = null;

    @Column(name=KIHONS10 + "$", nullable=true)
    protected String getKihons10Type() {
        if (kihons10Type == null && kihons10 != null) return kihons10.getType().toString();
        if (kihons10Type == null && getKihons10Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kihons10$' should not be NULL."));
        }
        return kihons10Type;
    }

    protected void setKihons10Type(String type) {
        kihons10Type = type;
        kihons10 = Optional.fromNullable(toCurrencyType(kihons10Type))
            .transform(bizCurrencyTransformer(getKihons10Value()))
            .orNull();
    }

    private BizCurrency p1;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getP1() {
        return p1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setP1(BizCurrency pP1) {
        p1 = pP1;
        p1Value = null;
        p1Type  = null;
    }

    transient private BigDecimal p1Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=P1, nullable=true)
    protected BigDecimal getP1Value() {
        if (p1Value == null && p1 != null) {
            if (p1.isOptional()) return null;
            return p1.absolute();
        }
        return p1Value;
    }

    protected void setP1Value(BigDecimal value) {
        p1Value = value;
        p1 = Optional.fromNullable(toCurrencyType(p1Type))
            .transform(bizCurrencyTransformer(getP1Value()))
            .orNull();
    }

    transient private String p1Type = null;

    @Column(name=P1 + "$", nullable=true)
    protected String getP1Type() {
        if (p1Type == null && p1 != null) return p1.getType().toString();
        if (p1Type == null && getP1Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'p1$' should not be NULL."));
        }
        return p1Type;
    }

    protected void setP1Type(String type) {
        p1Type = type;
        p1 = Optional.fromNullable(toCurrencyType(p1Type))
            .transform(bizCurrencyTransformer(getP1Value()))
            .orNull();
    }

    private BizCurrency p2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getP2() {
        return p2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setP2(BizCurrency pP2) {
        p2 = pP2;
        p2Value = null;
        p2Type  = null;
    }

    transient private BigDecimal p2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=P2, nullable=true)
    protected BigDecimal getP2Value() {
        if (p2Value == null && p2 != null) {
            if (p2.isOptional()) return null;
            return p2.absolute();
        }
        return p2Value;
    }

    protected void setP2Value(BigDecimal value) {
        p2Value = value;
        p2 = Optional.fromNullable(toCurrencyType(p2Type))
            .transform(bizCurrencyTransformer(getP2Value()))
            .orNull();
    }

    transient private String p2Type = null;

    @Column(name=P2 + "$", nullable=true)
    protected String getP2Type() {
        if (p2Type == null && p2 != null) return p2.getType().toString();
        if (p2Type == null && getP2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'p2$' should not be NULL."));
        }
        return p2Type;
    }

    protected void setP2Type(String type) {
        p2Type = type;
        p2 = Optional.fromNullable(toCurrencyType(p2Type))
            .transform(bizCurrencyTransformer(getP2Value()))
            .orNull();
    }

    private BizCurrency p3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getP3() {
        return p3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setP3(BizCurrency pP3) {
        p3 = pP3;
        p3Value = null;
        p3Type  = null;
    }

    transient private BigDecimal p3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=P3, nullable=true)
    protected BigDecimal getP3Value() {
        if (p3Value == null && p3 != null) {
            if (p3.isOptional()) return null;
            return p3.absolute();
        }
        return p3Value;
    }

    protected void setP3Value(BigDecimal value) {
        p3Value = value;
        p3 = Optional.fromNullable(toCurrencyType(p3Type))
            .transform(bizCurrencyTransformer(getP3Value()))
            .orNull();
    }

    transient private String p3Type = null;

    @Column(name=P3 + "$", nullable=true)
    protected String getP3Type() {
        if (p3Type == null && p3 != null) return p3.getType().toString();
        if (p3Type == null && getP3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'p3$' should not be NULL."));
        }
        return p3Type;
    }

    protected void setP3Type(String type) {
        p3Type = type;
        p3 = Optional.fromNullable(toCurrencyType(p3Type))
            .transform(bizCurrencyTransformer(getP3Value()))
            .orNull();
    }

    private BizCurrency p4;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getP4() {
        return p4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setP4(BizCurrency pP4) {
        p4 = pP4;
        p4Value = null;
        p4Type  = null;
    }

    transient private BigDecimal p4Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=P4, nullable=true)
    protected BigDecimal getP4Value() {
        if (p4Value == null && p4 != null) {
            if (p4.isOptional()) return null;
            return p4.absolute();
        }
        return p4Value;
    }

    protected void setP4Value(BigDecimal value) {
        p4Value = value;
        p4 = Optional.fromNullable(toCurrencyType(p4Type))
            .transform(bizCurrencyTransformer(getP4Value()))
            .orNull();
    }

    transient private String p4Type = null;

    @Column(name=P4 + "$", nullable=true)
    protected String getP4Type() {
        if (p4Type == null && p4 != null) return p4.getType().toString();
        if (p4Type == null && getP4Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'p4$' should not be NULL."));
        }
        return p4Type;
    }

    protected void setP4Type(String type) {
        p4Type = type;
        p4 = Optional.fromNullable(toCurrencyType(p4Type))
            .transform(bizCurrencyTransformer(getP4Value()))
            .orNull();
    }

    private BizCurrency p5;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getP5() {
        return p5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setP5(BizCurrency pP5) {
        p5 = pP5;
        p5Value = null;
        p5Type  = null;
    }

    transient private BigDecimal p5Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=P5, nullable=true)
    protected BigDecimal getP5Value() {
        if (p5Value == null && p5 != null) {
            if (p5.isOptional()) return null;
            return p5.absolute();
        }
        return p5Value;
    }

    protected void setP5Value(BigDecimal value) {
        p5Value = value;
        p5 = Optional.fromNullable(toCurrencyType(p5Type))
            .transform(bizCurrencyTransformer(getP5Value()))
            .orNull();
    }

    transient private String p5Type = null;

    @Column(name=P5 + "$", nullable=true)
    protected String getP5Type() {
        if (p5Type == null && p5 != null) return p5.getType().toString();
        if (p5Type == null && getP5Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'p5$' should not be NULL."));
        }
        return p5Type;
    }

    protected void setP5Type(String type) {
        p5Type = type;
        p5 = Optional.fromNullable(toCurrencyType(p5Type))
            .transform(bizCurrencyTransformer(getP5Value()))
            .orNull();
    }

    private BizCurrency p6;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getP6() {
        return p6;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setP6(BizCurrency pP6) {
        p6 = pP6;
        p6Value = null;
        p6Type  = null;
    }

    transient private BigDecimal p6Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=P6, nullable=true)
    protected BigDecimal getP6Value() {
        if (p6Value == null && p6 != null) {
            if (p6.isOptional()) return null;
            return p6.absolute();
        }
        return p6Value;
    }

    protected void setP6Value(BigDecimal value) {
        p6Value = value;
        p6 = Optional.fromNullable(toCurrencyType(p6Type))
            .transform(bizCurrencyTransformer(getP6Value()))
            .orNull();
    }

    transient private String p6Type = null;

    @Column(name=P6 + "$", nullable=true)
    protected String getP6Type() {
        if (p6Type == null && p6 != null) return p6.getType().toString();
        if (p6Type == null && getP6Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'p6$' should not be NULL."));
        }
        return p6Type;
    }

    protected void setP6Type(String type) {
        p6Type = type;
        p6 = Optional.fromNullable(toCurrencyType(p6Type))
            .transform(bizCurrencyTransformer(getP6Value()))
            .orNull();
    }

    private BizCurrency p7;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getP7() {
        return p7;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setP7(BizCurrency pP7) {
        p7 = pP7;
        p7Value = null;
        p7Type  = null;
    }

    transient private BigDecimal p7Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=P7, nullable=true)
    protected BigDecimal getP7Value() {
        if (p7Value == null && p7 != null) {
            if (p7.isOptional()) return null;
            return p7.absolute();
        }
        return p7Value;
    }

    protected void setP7Value(BigDecimal value) {
        p7Value = value;
        p7 = Optional.fromNullable(toCurrencyType(p7Type))
            .transform(bizCurrencyTransformer(getP7Value()))
            .orNull();
    }

    transient private String p7Type = null;

    @Column(name=P7 + "$", nullable=true)
    protected String getP7Type() {
        if (p7Type == null && p7 != null) return p7.getType().toString();
        if (p7Type == null && getP7Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'p7$' should not be NULL."));
        }
        return p7Type;
    }

    protected void setP7Type(String type) {
        p7Type = type;
        p7 = Optional.fromNullable(toCurrencyType(p7Type))
            .transform(bizCurrencyTransformer(getP7Value()))
            .orNull();
    }

    private BizCurrency p8;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getP8() {
        return p8;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setP8(BizCurrency pP8) {
        p8 = pP8;
        p8Value = null;
        p8Type  = null;
    }

    transient private BigDecimal p8Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=P8, nullable=true)
    protected BigDecimal getP8Value() {
        if (p8Value == null && p8 != null) {
            if (p8.isOptional()) return null;
            return p8.absolute();
        }
        return p8Value;
    }

    protected void setP8Value(BigDecimal value) {
        p8Value = value;
        p8 = Optional.fromNullable(toCurrencyType(p8Type))
            .transform(bizCurrencyTransformer(getP8Value()))
            .orNull();
    }

    transient private String p8Type = null;

    @Column(name=P8 + "$", nullable=true)
    protected String getP8Type() {
        if (p8Type == null && p8 != null) return p8.getType().toString();
        if (p8Type == null && getP8Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'p8$' should not be NULL."));
        }
        return p8Type;
    }

    protected void setP8Type(String type) {
        p8Type = type;
        p8 = Optional.fromNullable(toCurrencyType(p8Type))
            .transform(bizCurrencyTransformer(getP8Value()))
            .orNull();
    }

    private BizCurrency p9;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getP9() {
        return p9;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setP9(BizCurrency pP9) {
        p9 = pP9;
        p9Value = null;
        p9Type  = null;
    }

    transient private BigDecimal p9Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=P9, nullable=true)
    protected BigDecimal getP9Value() {
        if (p9Value == null && p9 != null) {
            if (p9.isOptional()) return null;
            return p9.absolute();
        }
        return p9Value;
    }

    protected void setP9Value(BigDecimal value) {
        p9Value = value;
        p9 = Optional.fromNullable(toCurrencyType(p9Type))
            .transform(bizCurrencyTransformer(getP9Value()))
            .orNull();
    }

    transient private String p9Type = null;

    @Column(name=P9 + "$", nullable=true)
    protected String getP9Type() {
        if (p9Type == null && p9 != null) return p9.getType().toString();
        if (p9Type == null && getP9Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'p9$' should not be NULL."));
        }
        return p9Type;
    }

    protected void setP9Type(String type) {
        p9Type = type;
        p9 = Optional.fromNullable(toCurrencyType(p9Type))
            .transform(bizCurrencyTransformer(getP9Value()))
            .orNull();
    }

    private BizCurrency p10;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getP10() {
        return p10;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setP10(BizCurrency pP10) {
        p10 = pP10;
        p10Value = null;
        p10Type  = null;
    }

    transient private BigDecimal p10Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=P10, nullable=true)
    protected BigDecimal getP10Value() {
        if (p10Value == null && p10 != null) {
            if (p10.isOptional()) return null;
            return p10.absolute();
        }
        return p10Value;
    }

    protected void setP10Value(BigDecimal value) {
        p10Value = value;
        p10 = Optional.fromNullable(toCurrencyType(p10Type))
            .transform(bizCurrencyTransformer(getP10Value()))
            .orNull();
    }

    transient private String p10Type = null;

    @Column(name=P10 + "$", nullable=true)
    protected String getP10Type() {
        if (p10Type == null && p10 != null) return p10.getType().toString();
        if (p10Type == null && getP10Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'p10$' should not be NULL."));
        }
        return p10Type;
    }

    protected void setP10Type(String type) {
        p10Type = type;
        p10 = Optional.fromNullable(toCurrencyType(p10Type))
            .transform(bizCurrencyTransformer(getP10Value()))
            .orNull();
    }

    private C_KihonssyuruiKbn kihonssyuruikbn1;

    @Type(type="UserType_C_KihonssyuruiKbn")
    @Column(name=GenIT_SougouTuuti.KIHONSSYURUIKBN1)
    public C_KihonssyuruiKbn getKihonssyuruikbn1() {
        return kihonssyuruikbn1;
    }

    public void setKihonssyuruikbn1(C_KihonssyuruiKbn pKihonssyuruikbn1) {
        kihonssyuruikbn1 = pKihonssyuruikbn1;
    }

    private C_KihonssyuruiKbn kihonssyuruikbn2;

    @Type(type="UserType_C_KihonssyuruiKbn")
    @Column(name=GenIT_SougouTuuti.KIHONSSYURUIKBN2)
    public C_KihonssyuruiKbn getKihonssyuruikbn2() {
        return kihonssyuruikbn2;
    }

    public void setKihonssyuruikbn2(C_KihonssyuruiKbn pKihonssyuruikbn2) {
        kihonssyuruikbn2 = pKihonssyuruikbn2;
    }

    private C_KihonssyuruiKbn kihonssyuruikbn3;

    @Type(type="UserType_C_KihonssyuruiKbn")
    @Column(name=GenIT_SougouTuuti.KIHONSSYURUIKBN3)
    public C_KihonssyuruiKbn getKihonssyuruikbn3() {
        return kihonssyuruikbn3;
    }

    public void setKihonssyuruikbn3(C_KihonssyuruiKbn pKihonssyuruikbn3) {
        kihonssyuruikbn3 = pKihonssyuruikbn3;
    }

    private C_KihonssyuruiKbn kihonssyuruikbn4;

    @Type(type="UserType_C_KihonssyuruiKbn")
    @Column(name=GenIT_SougouTuuti.KIHONSSYURUIKBN4)
    public C_KihonssyuruiKbn getKihonssyuruikbn4() {
        return kihonssyuruikbn4;
    }

    public void setKihonssyuruikbn4(C_KihonssyuruiKbn pKihonssyuruikbn4) {
        kihonssyuruikbn4 = pKihonssyuruikbn4;
    }

    private C_KihonssyuruiKbn kihonssyuruikbn5;

    @Type(type="UserType_C_KihonssyuruiKbn")
    @Column(name=GenIT_SougouTuuti.KIHONSSYURUIKBN5)
    public C_KihonssyuruiKbn getKihonssyuruikbn5() {
        return kihonssyuruikbn5;
    }

    public void setKihonssyuruikbn5(C_KihonssyuruiKbn pKihonssyuruikbn5) {
        kihonssyuruikbn5 = pKihonssyuruikbn5;
    }

    private C_KihonssyuruiKbn kihonssyuruikbn6;

    @Type(type="UserType_C_KihonssyuruiKbn")
    @Column(name=GenIT_SougouTuuti.KIHONSSYURUIKBN6)
    public C_KihonssyuruiKbn getKihonssyuruikbn6() {
        return kihonssyuruikbn6;
    }

    public void setKihonssyuruikbn6(C_KihonssyuruiKbn pKihonssyuruikbn6) {
        kihonssyuruikbn6 = pKihonssyuruikbn6;
    }

    private C_KihonssyuruiKbn kihonssyuruikbn7;

    @Type(type="UserType_C_KihonssyuruiKbn")
    @Column(name=GenIT_SougouTuuti.KIHONSSYURUIKBN7)
    public C_KihonssyuruiKbn getKihonssyuruikbn7() {
        return kihonssyuruikbn7;
    }

    public void setKihonssyuruikbn7(C_KihonssyuruiKbn pKihonssyuruikbn7) {
        kihonssyuruikbn7 = pKihonssyuruikbn7;
    }

    private C_KihonssyuruiKbn kihonssyuruikbn8;

    @Type(type="UserType_C_KihonssyuruiKbn")
    @Column(name=GenIT_SougouTuuti.KIHONSSYURUIKBN8)
    public C_KihonssyuruiKbn getKihonssyuruikbn8() {
        return kihonssyuruikbn8;
    }

    public void setKihonssyuruikbn8(C_KihonssyuruiKbn pKihonssyuruikbn8) {
        kihonssyuruikbn8 = pKihonssyuruikbn8;
    }

    private C_KihonssyuruiKbn kihonssyuruikbn9;

    @Type(type="UserType_C_KihonssyuruiKbn")
    @Column(name=GenIT_SougouTuuti.KIHONSSYURUIKBN9)
    public C_KihonssyuruiKbn getKihonssyuruikbn9() {
        return kihonssyuruikbn9;
    }

    public void setKihonssyuruikbn9(C_KihonssyuruiKbn pKihonssyuruikbn9) {
        kihonssyuruikbn9 = pKihonssyuruikbn9;
    }

    private C_KihonssyuruiKbn kihonssyuruikbn10;

    @Type(type="UserType_C_KihonssyuruiKbn")
    @Column(name=GenIT_SougouTuuti.KIHONSSYURUIKBN10)
    public C_KihonssyuruiKbn getKihonssyuruikbn10() {
        return kihonssyuruikbn10;
    }

    public void setKihonssyuruikbn10(C_KihonssyuruiKbn pKihonssyuruikbn10) {
        kihonssyuruikbn10 = pKihonssyuruikbn10;
    }

    private C_SyukyhkinkataKbn syukyhkinkatakbn1;

    @Type(type="UserType_C_SyukyhkinkataKbn")
    @Column(name=GenIT_SougouTuuti.SYUKYHKINKATAKBN1)
    public C_SyukyhkinkataKbn getSyukyhkinkatakbn1() {
        return syukyhkinkatakbn1;
    }

    public void setSyukyhkinkatakbn1(C_SyukyhkinkataKbn pSyukyhkinkatakbn1) {
        syukyhkinkatakbn1 = pSyukyhkinkatakbn1;
    }

    private C_SyukyhkinkataKbn syukyhkinkatakbn2;

    @Type(type="UserType_C_SyukyhkinkataKbn")
    @Column(name=GenIT_SougouTuuti.SYUKYHKINKATAKBN2)
    public C_SyukyhkinkataKbn getSyukyhkinkatakbn2() {
        return syukyhkinkatakbn2;
    }

    public void setSyukyhkinkatakbn2(C_SyukyhkinkataKbn pSyukyhkinkatakbn2) {
        syukyhkinkatakbn2 = pSyukyhkinkatakbn2;
    }

    private C_SyukyhkinkataKbn syukyhkinkatakbn3;

    @Type(type="UserType_C_SyukyhkinkataKbn")
    @Column(name=GenIT_SougouTuuti.SYUKYHKINKATAKBN3)
    public C_SyukyhkinkataKbn getSyukyhkinkatakbn3() {
        return syukyhkinkatakbn3;
    }

    public void setSyukyhkinkatakbn3(C_SyukyhkinkataKbn pSyukyhkinkatakbn3) {
        syukyhkinkatakbn3 = pSyukyhkinkatakbn3;
    }

    private C_SyukyhkinkataKbn syukyhkinkatakbn4;

    @Type(type="UserType_C_SyukyhkinkataKbn")
    @Column(name=GenIT_SougouTuuti.SYUKYHKINKATAKBN4)
    public C_SyukyhkinkataKbn getSyukyhkinkatakbn4() {
        return syukyhkinkatakbn4;
    }

    public void setSyukyhkinkatakbn4(C_SyukyhkinkataKbn pSyukyhkinkatakbn4) {
        syukyhkinkatakbn4 = pSyukyhkinkatakbn4;
    }

    private C_SyukyhkinkataKbn syukyhkinkatakbn5;

    @Type(type="UserType_C_SyukyhkinkataKbn")
    @Column(name=GenIT_SougouTuuti.SYUKYHKINKATAKBN5)
    public C_SyukyhkinkataKbn getSyukyhkinkatakbn5() {
        return syukyhkinkatakbn5;
    }

    public void setSyukyhkinkatakbn5(C_SyukyhkinkataKbn pSyukyhkinkatakbn5) {
        syukyhkinkatakbn5 = pSyukyhkinkatakbn5;
    }

    private C_SyukyhkinkataKbn syukyhkinkatakbn6;

    @Type(type="UserType_C_SyukyhkinkataKbn")
    @Column(name=GenIT_SougouTuuti.SYUKYHKINKATAKBN6)
    public C_SyukyhkinkataKbn getSyukyhkinkatakbn6() {
        return syukyhkinkatakbn6;
    }

    public void setSyukyhkinkatakbn6(C_SyukyhkinkataKbn pSyukyhkinkatakbn6) {
        syukyhkinkatakbn6 = pSyukyhkinkatakbn6;
    }

    private C_SyukyhkinkataKbn syukyhkinkatakbn7;

    @Type(type="UserType_C_SyukyhkinkataKbn")
    @Column(name=GenIT_SougouTuuti.SYUKYHKINKATAKBN7)
    public C_SyukyhkinkataKbn getSyukyhkinkatakbn7() {
        return syukyhkinkatakbn7;
    }

    public void setSyukyhkinkatakbn7(C_SyukyhkinkataKbn pSyukyhkinkatakbn7) {
        syukyhkinkatakbn7 = pSyukyhkinkatakbn7;
    }

    private C_SyukyhkinkataKbn syukyhkinkatakbn8;

    @Type(type="UserType_C_SyukyhkinkataKbn")
    @Column(name=GenIT_SougouTuuti.SYUKYHKINKATAKBN8)
    public C_SyukyhkinkataKbn getSyukyhkinkatakbn8() {
        return syukyhkinkatakbn8;
    }

    public void setSyukyhkinkatakbn8(C_SyukyhkinkataKbn pSyukyhkinkatakbn8) {
        syukyhkinkatakbn8 = pSyukyhkinkatakbn8;
    }

    private C_SyukyhkinkataKbn syukyhkinkatakbn9;

    @Type(type="UserType_C_SyukyhkinkataKbn")
    @Column(name=GenIT_SougouTuuti.SYUKYHKINKATAKBN9)
    public C_SyukyhkinkataKbn getSyukyhkinkatakbn9() {
        return syukyhkinkatakbn9;
    }

    public void setSyukyhkinkatakbn9(C_SyukyhkinkataKbn pSyukyhkinkatakbn9) {
        syukyhkinkatakbn9 = pSyukyhkinkatakbn9;
    }

    private C_SyukyhkinkataKbn syukyhkinkatakbn10;

    @Type(type="UserType_C_SyukyhkinkataKbn")
    @Column(name=GenIT_SougouTuuti.SYUKYHKINKATAKBN10)
    public C_SyukyhkinkataKbn getSyukyhkinkatakbn10() {
        return syukyhkinkatakbn10;
    }

    public void setSyukyhkinkatakbn10(C_SyukyhkinkataKbn pSyukyhkinkatakbn10) {
        syukyhkinkatakbn10 = pSyukyhkinkatakbn10;
    }

    private C_6daiLdKbn rokudaissbtkkyhktkbn1;

    @Type(type="UserType_C_6daiLdKbn")
    @Column(name=GenIT_SougouTuuti.ROKUDAISSBTKKYHKTKBN1)
    public C_6daiLdKbn getRokudaissbtkkyhktkbn1() {
        return rokudaissbtkkyhktkbn1;
    }

    public void setRokudaissbtkkyhktkbn1(C_6daiLdKbn pRokudaissbtkkyhktkbn1) {
        rokudaissbtkkyhktkbn1 = pRokudaissbtkkyhktkbn1;
    }

    private C_6daiLdKbn rokudaissbtkkyhktkbn2;

    @Type(type="UserType_C_6daiLdKbn")
    @Column(name=GenIT_SougouTuuti.ROKUDAISSBTKKYHKTKBN2)
    public C_6daiLdKbn getRokudaissbtkkyhktkbn2() {
        return rokudaissbtkkyhktkbn2;
    }

    public void setRokudaissbtkkyhktkbn2(C_6daiLdKbn pRokudaissbtkkyhktkbn2) {
        rokudaissbtkkyhktkbn2 = pRokudaissbtkkyhktkbn2;
    }

    private C_6daiLdKbn rokudaissbtkkyhktkbn3;

    @Type(type="UserType_C_6daiLdKbn")
    @Column(name=GenIT_SougouTuuti.ROKUDAISSBTKKYHKTKBN3)
    public C_6daiLdKbn getRokudaissbtkkyhktkbn3() {
        return rokudaissbtkkyhktkbn3;
    }

    public void setRokudaissbtkkyhktkbn3(C_6daiLdKbn pRokudaissbtkkyhktkbn3) {
        rokudaissbtkkyhktkbn3 = pRokudaissbtkkyhktkbn3;
    }

    private C_6daiLdKbn rokudaissbtkkyhktkbn4;

    @Type(type="UserType_C_6daiLdKbn")
    @Column(name=GenIT_SougouTuuti.ROKUDAISSBTKKYHKTKBN4)
    public C_6daiLdKbn getRokudaissbtkkyhktkbn4() {
        return rokudaissbtkkyhktkbn4;
    }

    public void setRokudaissbtkkyhktkbn4(C_6daiLdKbn pRokudaissbtkkyhktkbn4) {
        rokudaissbtkkyhktkbn4 = pRokudaissbtkkyhktkbn4;
    }

    private C_6daiLdKbn rokudaissbtkkyhktkbn5;

    @Type(type="UserType_C_6daiLdKbn")
    @Column(name=GenIT_SougouTuuti.ROKUDAISSBTKKYHKTKBN5)
    public C_6daiLdKbn getRokudaissbtkkyhktkbn5() {
        return rokudaissbtkkyhktkbn5;
    }

    public void setRokudaissbtkkyhktkbn5(C_6daiLdKbn pRokudaissbtkkyhktkbn5) {
        rokudaissbtkkyhktkbn5 = pRokudaissbtkkyhktkbn5;
    }

    private C_6daiLdKbn rokudaissbtkkyhktkbn6;

    @Type(type="UserType_C_6daiLdKbn")
    @Column(name=GenIT_SougouTuuti.ROKUDAISSBTKKYHKTKBN6)
    public C_6daiLdKbn getRokudaissbtkkyhktkbn6() {
        return rokudaissbtkkyhktkbn6;
    }

    public void setRokudaissbtkkyhktkbn6(C_6daiLdKbn pRokudaissbtkkyhktkbn6) {
        rokudaissbtkkyhktkbn6 = pRokudaissbtkkyhktkbn6;
    }

    private C_6daiLdKbn rokudaissbtkkyhktkbn7;

    @Type(type="UserType_C_6daiLdKbn")
    @Column(name=GenIT_SougouTuuti.ROKUDAISSBTKKYHKTKBN7)
    public C_6daiLdKbn getRokudaissbtkkyhktkbn7() {
        return rokudaissbtkkyhktkbn7;
    }

    public void setRokudaissbtkkyhktkbn7(C_6daiLdKbn pRokudaissbtkkyhktkbn7) {
        rokudaissbtkkyhktkbn7 = pRokudaissbtkkyhktkbn7;
    }

    private C_6daiLdKbn rokudaissbtkkyhktkbn8;

    @Type(type="UserType_C_6daiLdKbn")
    @Column(name=GenIT_SougouTuuti.ROKUDAISSBTKKYHKTKBN8)
    public C_6daiLdKbn getRokudaissbtkkyhktkbn8() {
        return rokudaissbtkkyhktkbn8;
    }

    public void setRokudaissbtkkyhktkbn8(C_6daiLdKbn pRokudaissbtkkyhktkbn8) {
        rokudaissbtkkyhktkbn8 = pRokudaissbtkkyhktkbn8;
    }

    private C_6daiLdKbn rokudaissbtkkyhktkbn9;

    @Type(type="UserType_C_6daiLdKbn")
    @Column(name=GenIT_SougouTuuti.ROKUDAISSBTKKYHKTKBN9)
    public C_6daiLdKbn getRokudaissbtkkyhktkbn9() {
        return rokudaissbtkkyhktkbn9;
    }

    public void setRokudaissbtkkyhktkbn9(C_6daiLdKbn pRokudaissbtkkyhktkbn9) {
        rokudaissbtkkyhktkbn9 = pRokudaissbtkkyhktkbn9;
    }

    private C_6daiLdKbn rokudaissbtkkyhktkbn10;

    @Type(type="UserType_C_6daiLdKbn")
    @Column(name=GenIT_SougouTuuti.ROKUDAISSBTKKYHKTKBN10)
    public C_6daiLdKbn getRokudaissbtkkyhktkbn10() {
        return rokudaissbtkkyhktkbn10;
    }

    public void setRokudaissbtkkyhktkbn10(C_6daiLdKbn pRokudaissbtkkyhktkbn10) {
        rokudaissbtkkyhktkbn10 = pRokudaissbtkkyhktkbn10;
    }

    private BizCurrency khnkyhgk1;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKhnkyhgk1() {
        return khnkyhgk1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKhnkyhgk1(BizCurrency pKhnkyhgk1) {
        khnkyhgk1 = pKhnkyhgk1;
        khnkyhgk1Value = null;
        khnkyhgk1Type  = null;
    }

    transient private BigDecimal khnkyhgk1Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KHNKYHGK1, nullable=true)
    protected BigDecimal getKhnkyhgk1Value() {
        if (khnkyhgk1Value == null && khnkyhgk1 != null) {
            if (khnkyhgk1.isOptional()) return null;
            return khnkyhgk1.absolute();
        }
        return khnkyhgk1Value;
    }

    protected void setKhnkyhgk1Value(BigDecimal value) {
        khnkyhgk1Value = value;
        khnkyhgk1 = Optional.fromNullable(toCurrencyType(khnkyhgk1Type))
            .transform(bizCurrencyTransformer(getKhnkyhgk1Value()))
            .orNull();
    }

    transient private String khnkyhgk1Type = null;

    @Column(name=KHNKYHGK1 + "$", nullable=true)
    protected String getKhnkyhgk1Type() {
        if (khnkyhgk1Type == null && khnkyhgk1 != null) return khnkyhgk1.getType().toString();
        if (khnkyhgk1Type == null && getKhnkyhgk1Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'khnkyhgk1$' should not be NULL."));
        }
        return khnkyhgk1Type;
    }

    protected void setKhnkyhgk1Type(String type) {
        khnkyhgk1Type = type;
        khnkyhgk1 = Optional.fromNullable(toCurrencyType(khnkyhgk1Type))
            .transform(bizCurrencyTransformer(getKhnkyhgk1Value()))
            .orNull();
    }

    private BizCurrency khnkyhgk2;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKhnkyhgk2() {
        return khnkyhgk2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKhnkyhgk2(BizCurrency pKhnkyhgk2) {
        khnkyhgk2 = pKhnkyhgk2;
        khnkyhgk2Value = null;
        khnkyhgk2Type  = null;
    }

    transient private BigDecimal khnkyhgk2Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KHNKYHGK2, nullable=true)
    protected BigDecimal getKhnkyhgk2Value() {
        if (khnkyhgk2Value == null && khnkyhgk2 != null) {
            if (khnkyhgk2.isOptional()) return null;
            return khnkyhgk2.absolute();
        }
        return khnkyhgk2Value;
    }

    protected void setKhnkyhgk2Value(BigDecimal value) {
        khnkyhgk2Value = value;
        khnkyhgk2 = Optional.fromNullable(toCurrencyType(khnkyhgk2Type))
            .transform(bizCurrencyTransformer(getKhnkyhgk2Value()))
            .orNull();
    }

    transient private String khnkyhgk2Type = null;

    @Column(name=KHNKYHGK2 + "$", nullable=true)
    protected String getKhnkyhgk2Type() {
        if (khnkyhgk2Type == null && khnkyhgk2 != null) return khnkyhgk2.getType().toString();
        if (khnkyhgk2Type == null && getKhnkyhgk2Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'khnkyhgk2$' should not be NULL."));
        }
        return khnkyhgk2Type;
    }

    protected void setKhnkyhgk2Type(String type) {
        khnkyhgk2Type = type;
        khnkyhgk2 = Optional.fromNullable(toCurrencyType(khnkyhgk2Type))
            .transform(bizCurrencyTransformer(getKhnkyhgk2Value()))
            .orNull();
    }

    private BizCurrency khnkyhgk3;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKhnkyhgk3() {
        return khnkyhgk3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKhnkyhgk3(BizCurrency pKhnkyhgk3) {
        khnkyhgk3 = pKhnkyhgk3;
        khnkyhgk3Value = null;
        khnkyhgk3Type  = null;
    }

    transient private BigDecimal khnkyhgk3Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KHNKYHGK3, nullable=true)
    protected BigDecimal getKhnkyhgk3Value() {
        if (khnkyhgk3Value == null && khnkyhgk3 != null) {
            if (khnkyhgk3.isOptional()) return null;
            return khnkyhgk3.absolute();
        }
        return khnkyhgk3Value;
    }

    protected void setKhnkyhgk3Value(BigDecimal value) {
        khnkyhgk3Value = value;
        khnkyhgk3 = Optional.fromNullable(toCurrencyType(khnkyhgk3Type))
            .transform(bizCurrencyTransformer(getKhnkyhgk3Value()))
            .orNull();
    }

    transient private String khnkyhgk3Type = null;

    @Column(name=KHNKYHGK3 + "$", nullable=true)
    protected String getKhnkyhgk3Type() {
        if (khnkyhgk3Type == null && khnkyhgk3 != null) return khnkyhgk3.getType().toString();
        if (khnkyhgk3Type == null && getKhnkyhgk3Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'khnkyhgk3$' should not be NULL."));
        }
        return khnkyhgk3Type;
    }

    protected void setKhnkyhgk3Type(String type) {
        khnkyhgk3Type = type;
        khnkyhgk3 = Optional.fromNullable(toCurrencyType(khnkyhgk3Type))
            .transform(bizCurrencyTransformer(getKhnkyhgk3Value()))
            .orNull();
    }

    private BizCurrency khnkyhgk4;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKhnkyhgk4() {
        return khnkyhgk4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKhnkyhgk4(BizCurrency pKhnkyhgk4) {
        khnkyhgk4 = pKhnkyhgk4;
        khnkyhgk4Value = null;
        khnkyhgk4Type  = null;
    }

    transient private BigDecimal khnkyhgk4Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KHNKYHGK4, nullable=true)
    protected BigDecimal getKhnkyhgk4Value() {
        if (khnkyhgk4Value == null && khnkyhgk4 != null) {
            if (khnkyhgk4.isOptional()) return null;
            return khnkyhgk4.absolute();
        }
        return khnkyhgk4Value;
    }

    protected void setKhnkyhgk4Value(BigDecimal value) {
        khnkyhgk4Value = value;
        khnkyhgk4 = Optional.fromNullable(toCurrencyType(khnkyhgk4Type))
            .transform(bizCurrencyTransformer(getKhnkyhgk4Value()))
            .orNull();
    }

    transient private String khnkyhgk4Type = null;

    @Column(name=KHNKYHGK4 + "$", nullable=true)
    protected String getKhnkyhgk4Type() {
        if (khnkyhgk4Type == null && khnkyhgk4 != null) return khnkyhgk4.getType().toString();
        if (khnkyhgk4Type == null && getKhnkyhgk4Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'khnkyhgk4$' should not be NULL."));
        }
        return khnkyhgk4Type;
    }

    protected void setKhnkyhgk4Type(String type) {
        khnkyhgk4Type = type;
        khnkyhgk4 = Optional.fromNullable(toCurrencyType(khnkyhgk4Type))
            .transform(bizCurrencyTransformer(getKhnkyhgk4Value()))
            .orNull();
    }

    private BizCurrency khnkyhgk5;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKhnkyhgk5() {
        return khnkyhgk5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKhnkyhgk5(BizCurrency pKhnkyhgk5) {
        khnkyhgk5 = pKhnkyhgk5;
        khnkyhgk5Value = null;
        khnkyhgk5Type  = null;
    }

    transient private BigDecimal khnkyhgk5Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KHNKYHGK5, nullable=true)
    protected BigDecimal getKhnkyhgk5Value() {
        if (khnkyhgk5Value == null && khnkyhgk5 != null) {
            if (khnkyhgk5.isOptional()) return null;
            return khnkyhgk5.absolute();
        }
        return khnkyhgk5Value;
    }

    protected void setKhnkyhgk5Value(BigDecimal value) {
        khnkyhgk5Value = value;
        khnkyhgk5 = Optional.fromNullable(toCurrencyType(khnkyhgk5Type))
            .transform(bizCurrencyTransformer(getKhnkyhgk5Value()))
            .orNull();
    }

    transient private String khnkyhgk5Type = null;

    @Column(name=KHNKYHGK5 + "$", nullable=true)
    protected String getKhnkyhgk5Type() {
        if (khnkyhgk5Type == null && khnkyhgk5 != null) return khnkyhgk5.getType().toString();
        if (khnkyhgk5Type == null && getKhnkyhgk5Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'khnkyhgk5$' should not be NULL."));
        }
        return khnkyhgk5Type;
    }

    protected void setKhnkyhgk5Type(String type) {
        khnkyhgk5Type = type;
        khnkyhgk5 = Optional.fromNullable(toCurrencyType(khnkyhgk5Type))
            .transform(bizCurrencyTransformer(getKhnkyhgk5Value()))
            .orNull();
    }

    private BizCurrency khnkyhgk6;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKhnkyhgk6() {
        return khnkyhgk6;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKhnkyhgk6(BizCurrency pKhnkyhgk6) {
        khnkyhgk6 = pKhnkyhgk6;
        khnkyhgk6Value = null;
        khnkyhgk6Type  = null;
    }

    transient private BigDecimal khnkyhgk6Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KHNKYHGK6, nullable=true)
    protected BigDecimal getKhnkyhgk6Value() {
        if (khnkyhgk6Value == null && khnkyhgk6 != null) {
            if (khnkyhgk6.isOptional()) return null;
            return khnkyhgk6.absolute();
        }
        return khnkyhgk6Value;
    }

    protected void setKhnkyhgk6Value(BigDecimal value) {
        khnkyhgk6Value = value;
        khnkyhgk6 = Optional.fromNullable(toCurrencyType(khnkyhgk6Type))
            .transform(bizCurrencyTransformer(getKhnkyhgk6Value()))
            .orNull();
    }

    transient private String khnkyhgk6Type = null;

    @Column(name=KHNKYHGK6 + "$", nullable=true)
    protected String getKhnkyhgk6Type() {
        if (khnkyhgk6Type == null && khnkyhgk6 != null) return khnkyhgk6.getType().toString();
        if (khnkyhgk6Type == null && getKhnkyhgk6Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'khnkyhgk6$' should not be NULL."));
        }
        return khnkyhgk6Type;
    }

    protected void setKhnkyhgk6Type(String type) {
        khnkyhgk6Type = type;
        khnkyhgk6 = Optional.fromNullable(toCurrencyType(khnkyhgk6Type))
            .transform(bizCurrencyTransformer(getKhnkyhgk6Value()))
            .orNull();
    }

    private BizCurrency khnkyhgk7;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKhnkyhgk7() {
        return khnkyhgk7;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKhnkyhgk7(BizCurrency pKhnkyhgk7) {
        khnkyhgk7 = pKhnkyhgk7;
        khnkyhgk7Value = null;
        khnkyhgk7Type  = null;
    }

    transient private BigDecimal khnkyhgk7Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KHNKYHGK7, nullable=true)
    protected BigDecimal getKhnkyhgk7Value() {
        if (khnkyhgk7Value == null && khnkyhgk7 != null) {
            if (khnkyhgk7.isOptional()) return null;
            return khnkyhgk7.absolute();
        }
        return khnkyhgk7Value;
    }

    protected void setKhnkyhgk7Value(BigDecimal value) {
        khnkyhgk7Value = value;
        khnkyhgk7 = Optional.fromNullable(toCurrencyType(khnkyhgk7Type))
            .transform(bizCurrencyTransformer(getKhnkyhgk7Value()))
            .orNull();
    }

    transient private String khnkyhgk7Type = null;

    @Column(name=KHNKYHGK7 + "$", nullable=true)
    protected String getKhnkyhgk7Type() {
        if (khnkyhgk7Type == null && khnkyhgk7 != null) return khnkyhgk7.getType().toString();
        if (khnkyhgk7Type == null && getKhnkyhgk7Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'khnkyhgk7$' should not be NULL."));
        }
        return khnkyhgk7Type;
    }

    protected void setKhnkyhgk7Type(String type) {
        khnkyhgk7Type = type;
        khnkyhgk7 = Optional.fromNullable(toCurrencyType(khnkyhgk7Type))
            .transform(bizCurrencyTransformer(getKhnkyhgk7Value()))
            .orNull();
    }

    private BizCurrency khnkyhgk8;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKhnkyhgk8() {
        return khnkyhgk8;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKhnkyhgk8(BizCurrency pKhnkyhgk8) {
        khnkyhgk8 = pKhnkyhgk8;
        khnkyhgk8Value = null;
        khnkyhgk8Type  = null;
    }

    transient private BigDecimal khnkyhgk8Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KHNKYHGK8, nullable=true)
    protected BigDecimal getKhnkyhgk8Value() {
        if (khnkyhgk8Value == null && khnkyhgk8 != null) {
            if (khnkyhgk8.isOptional()) return null;
            return khnkyhgk8.absolute();
        }
        return khnkyhgk8Value;
    }

    protected void setKhnkyhgk8Value(BigDecimal value) {
        khnkyhgk8Value = value;
        khnkyhgk8 = Optional.fromNullable(toCurrencyType(khnkyhgk8Type))
            .transform(bizCurrencyTransformer(getKhnkyhgk8Value()))
            .orNull();
    }

    transient private String khnkyhgk8Type = null;

    @Column(name=KHNKYHGK8 + "$", nullable=true)
    protected String getKhnkyhgk8Type() {
        if (khnkyhgk8Type == null && khnkyhgk8 != null) return khnkyhgk8.getType().toString();
        if (khnkyhgk8Type == null && getKhnkyhgk8Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'khnkyhgk8$' should not be NULL."));
        }
        return khnkyhgk8Type;
    }

    protected void setKhnkyhgk8Type(String type) {
        khnkyhgk8Type = type;
        khnkyhgk8 = Optional.fromNullable(toCurrencyType(khnkyhgk8Type))
            .transform(bizCurrencyTransformer(getKhnkyhgk8Value()))
            .orNull();
    }

    private BizCurrency khnkyhgk9;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKhnkyhgk9() {
        return khnkyhgk9;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKhnkyhgk9(BizCurrency pKhnkyhgk9) {
        khnkyhgk9 = pKhnkyhgk9;
        khnkyhgk9Value = null;
        khnkyhgk9Type  = null;
    }

    transient private BigDecimal khnkyhgk9Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KHNKYHGK9, nullable=true)
    protected BigDecimal getKhnkyhgk9Value() {
        if (khnkyhgk9Value == null && khnkyhgk9 != null) {
            if (khnkyhgk9.isOptional()) return null;
            return khnkyhgk9.absolute();
        }
        return khnkyhgk9Value;
    }

    protected void setKhnkyhgk9Value(BigDecimal value) {
        khnkyhgk9Value = value;
        khnkyhgk9 = Optional.fromNullable(toCurrencyType(khnkyhgk9Type))
            .transform(bizCurrencyTransformer(getKhnkyhgk9Value()))
            .orNull();
    }

    transient private String khnkyhgk9Type = null;

    @Column(name=KHNKYHGK9 + "$", nullable=true)
    protected String getKhnkyhgk9Type() {
        if (khnkyhgk9Type == null && khnkyhgk9 != null) return khnkyhgk9.getType().toString();
        if (khnkyhgk9Type == null && getKhnkyhgk9Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'khnkyhgk9$' should not be NULL."));
        }
        return khnkyhgk9Type;
    }

    protected void setKhnkyhgk9Type(String type) {
        khnkyhgk9Type = type;
        khnkyhgk9 = Optional.fromNullable(toCurrencyType(khnkyhgk9Type))
            .transform(bizCurrencyTransformer(getKhnkyhgk9Value()))
            .orNull();
    }

    private BizCurrency khnkyhgk10;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKhnkyhgk10() {
        return khnkyhgk10;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKhnkyhgk10(BizCurrency pKhnkyhgk10) {
        khnkyhgk10 = pKhnkyhgk10;
        khnkyhgk10Value = null;
        khnkyhgk10Type  = null;
    }

    transient private BigDecimal khnkyhgk10Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KHNKYHGK10, nullable=true)
    protected BigDecimal getKhnkyhgk10Value() {
        if (khnkyhgk10Value == null && khnkyhgk10 != null) {
            if (khnkyhgk10.isOptional()) return null;
            return khnkyhgk10.absolute();
        }
        return khnkyhgk10Value;
    }

    protected void setKhnkyhgk10Value(BigDecimal value) {
        khnkyhgk10Value = value;
        khnkyhgk10 = Optional.fromNullable(toCurrencyType(khnkyhgk10Type))
            .transform(bizCurrencyTransformer(getKhnkyhgk10Value()))
            .orNull();
    }

    transient private String khnkyhgk10Type = null;

    @Column(name=KHNKYHGK10 + "$", nullable=true)
    protected String getKhnkyhgk10Type() {
        if (khnkyhgk10Type == null && khnkyhgk10 != null) return khnkyhgk10.getType().toString();
        if (khnkyhgk10Type == null && getKhnkyhgk10Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'khnkyhgk10$' should not be NULL."));
        }
        return khnkyhgk10Type;
    }

    protected void setKhnkyhgk10Type(String type) {
        khnkyhgk10Type = type;
        khnkyhgk10 = Optional.fromNullable(toCurrencyType(khnkyhgk10Type))
            .transform(bizCurrencyTransformer(getKhnkyhgk10Value()))
            .orNull();
    }

    private String tsinyno;

    @Column(name=GenIT_SougouTuuti.TSINYNO)
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

    @Column(name=GenIT_SougouTuuti.TSINADR1KJ)
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

    @Column(name=GenIT_SougouTuuti.TSINADR2KJ)
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

    @Column(name=GenIT_SougouTuuti.TSINADR3KJ)
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

    private String tsinadr4kj;

    @Column(name=GenIT_SougouTuuti.TSINADR4KJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getTsinadr4kj() {
        return tsinadr4kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setTsinadr4kj(String pTsinadr4kj) {
        tsinadr4kj = pTsinadr4kj;
    }

    private String aitesyono;

    @Column(name=GenIT_SougouTuuti.AITESYONO)
    @SyoukenNo
    public String getAitesyono() {
        return aitesyono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setAitesyono(String pAitesyono) {
        aitesyono = pAitesyono;
    }

    private String drtencd;

    @Column(name=GenIT_SougouTuuti.DRTENCD)
    @MaxLength(max=7)
    @AlphaDigit
    public String getDrtencd() {
        return drtencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtencd(String pDrtencd) {
        drtencd = pDrtencd;
    }

    private String drtennmkj;

    @Column(name=GenIT_SougouTuuti.DRTENNMKJ)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    public String getDrtennmkj() {
        return drtennmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setDrtennmkj(String pDrtennmkj) {
        drtennmkj = pDrtennmkj;
    }

    private C_UmuKbn rkaiyakuhrumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_SougouTuuti.RKAIYAKUHRUMUKBN)
    public C_UmuKbn getRkaiyakuhrumukbn() {
        return rkaiyakuhrumukbn;
    }

    public void setRkaiyakuhrumukbn(C_UmuKbn pRkaiyakuhrumukbn) {
        rkaiyakuhrumukbn = pRkaiyakuhrumukbn;
    }

    private BizCurrency rkaiyakuhr;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getRkaiyakuhr() {
        return rkaiyakuhr;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRkaiyakuhr(BizCurrency pRkaiyakuhr) {
        rkaiyakuhr = pRkaiyakuhr;
        rkaiyakuhrValue = null;
        rkaiyakuhrType  = null;
    }

    transient private BigDecimal rkaiyakuhrValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=RKAIYAKUHR, nullable=true)
    protected BigDecimal getRkaiyakuhrValue() {
        if (rkaiyakuhrValue == null && rkaiyakuhr != null) {
            if (rkaiyakuhr.isOptional()) return null;
            return rkaiyakuhr.absolute();
        }
        return rkaiyakuhrValue;
    }

    protected void setRkaiyakuhrValue(BigDecimal value) {
        rkaiyakuhrValue = value;
        rkaiyakuhr = Optional.fromNullable(toCurrencyType(rkaiyakuhrType))
            .transform(bizCurrencyTransformer(getRkaiyakuhrValue()))
            .orNull();
    }

    transient private String rkaiyakuhrType = null;

    @Column(name=RKAIYAKUHR + "$", nullable=true)
    protected String getRkaiyakuhrType() {
        if (rkaiyakuhrType == null && rkaiyakuhr != null) return rkaiyakuhr.getType().toString();
        if (rkaiyakuhrType == null && getRkaiyakuhrValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'rkaiyakuhr$' should not be NULL."));
        }
        return rkaiyakuhrType;
    }

    protected void setRkaiyakuhrType(String type) {
        rkaiyakuhrType = type;
        rkaiyakuhr = Optional.fromNullable(toCurrencyType(rkaiyakuhrType))
            .transform(bizCurrencyTransformer(getRkaiyakuhrValue()))
            .orNull();
    }

    private BizCurrency rsbhenkan;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getRsbhenkan() {
        return rsbhenkan;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRsbhenkan(BizCurrency pRsbhenkan) {
        rsbhenkan = pRsbhenkan;
        rsbhenkanValue = null;
        rsbhenkanType  = null;
    }

    transient private BigDecimal rsbhenkanValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=RSBHENKAN, nullable=true)
    protected BigDecimal getRsbhenkanValue() {
        if (rsbhenkanValue == null && rsbhenkan != null) {
            if (rsbhenkan.isOptional()) return null;
            return rsbhenkan.absolute();
        }
        return rsbhenkanValue;
    }

    protected void setRsbhenkanValue(BigDecimal value) {
        rsbhenkanValue = value;
        rsbhenkan = Optional.fromNullable(toCurrencyType(rsbhenkanType))
            .transform(bizCurrencyTransformer(getRsbhenkanValue()))
            .orNull();
    }

    transient private String rsbhenkanType = null;

    @Column(name=RSBHENKAN + "$", nullable=true)
    protected String getRsbhenkanType() {
        if (rsbhenkanType == null && rsbhenkan != null) return rsbhenkan.getType().toString();
        if (rsbhenkanType == null && getRsbhenkanValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'rsbhenkan$' should not be NULL."));
        }
        return rsbhenkanType;
    }

    protected void setRsbhenkanType(String type) {
        rsbhenkanType = type;
        rsbhenkan = Optional.fromNullable(toCurrencyType(rsbhenkanType))
            .transform(bizCurrencyTransformer(getRsbhenkanValue()))
            .orNull();
    }

    private String rhtnpbuinm1;

    @Column(name=GenIT_SougouTuuti.RHTNPBUINM1)
    public String getRhtnpbuinm1() {
        return rhtnpbuinm1;
    }

    public void setRhtnpbuinm1(String pRhtnpbuinm1) {
        rhtnpbuinm1 = pRhtnpbuinm1;
    }

    private C_Htnpkkn htnpkkn1;

    @Type(type="UserType_C_Htnpkkn")
    @Column(name=GenIT_SougouTuuti.HTNPKKN1)
    public C_Htnpkkn getHtnpkkn1() {
        return htnpkkn1;
    }

    public void setHtnpkkn1(C_Htnpkkn pHtnpkkn1) {
        htnpkkn1 = pHtnpkkn1;
    }

    private String rhtnpbuinm2;

    @Column(name=GenIT_SougouTuuti.RHTNPBUINM2)
    public String getRhtnpbuinm2() {
        return rhtnpbuinm2;
    }

    public void setRhtnpbuinm2(String pRhtnpbuinm2) {
        rhtnpbuinm2 = pRhtnpbuinm2;
    }

    private C_Htnpkkn htnpkkn2;

    @Type(type="UserType_C_Htnpkkn")
    @Column(name=GenIT_SougouTuuti.HTNPKKN2)
    public C_Htnpkkn getHtnpkkn2() {
        return htnpkkn2;
    }

    public void setHtnpkkn2(C_Htnpkkn pHtnpkkn2) {
        htnpkkn2 = pHtnpkkn2;
    }

    private String rhtnpbuinm3;

    @Column(name=GenIT_SougouTuuti.RHTNPBUINM3)
    public String getRhtnpbuinm3() {
        return rhtnpbuinm3;
    }

    public void setRhtnpbuinm3(String pRhtnpbuinm3) {
        rhtnpbuinm3 = pRhtnpbuinm3;
    }

    private C_Htnpkkn htnpkkn3;

    @Type(type="UserType_C_Htnpkkn")
    @Column(name=GenIT_SougouTuuti.HTNPKKN3)
    public C_Htnpkkn getHtnpkkn3() {
        return htnpkkn3;
    }

    public void setHtnpkkn3(C_Htnpkkn pHtnpkkn3) {
        htnpkkn3 = pHtnpkkn3;
    }

    private String rhtnpbuinm4;

    @Column(name=GenIT_SougouTuuti.RHTNPBUINM4)
    public String getRhtnpbuinm4() {
        return rhtnpbuinm4;
    }

    public void setRhtnpbuinm4(String pRhtnpbuinm4) {
        rhtnpbuinm4 = pRhtnpbuinm4;
    }

    private C_Htnpkkn htnpkkn4;

    @Type(type="UserType_C_Htnpkkn")
    @Column(name=GenIT_SougouTuuti.HTNPKKN4)
    public C_Htnpkkn getHtnpkkn4() {
        return htnpkkn4;
    }

    public void setHtnpkkn4(C_Htnpkkn pHtnpkkn4) {
        htnpkkn4 = pHtnpkkn4;
    }

    private C_TokkoudosghtnpKbn tokkoudosghtnpkbn;

    @Type(type="UserType_C_TokkoudosghtnpKbn")
    @Column(name=GenIT_SougouTuuti.TOKKOUDOSGHTNPKBN)
    public C_TokkoudosghtnpKbn getTokkoudosghtnpkbn() {
        return tokkoudosghtnpkbn;
    }

    public void setTokkoudosghtnpkbn(C_TokkoudosghtnpKbn pTokkoudosghtnpkbn) {
        tokkoudosghtnpkbn = pTokkoudosghtnpkbn;
    }

    private Integer rtratkicd;

    @Column(name=GenIT_SougouTuuti.RTRATKICD)
    public Integer getRtratkicd() {
        return rtratkicd;
    }

    public void setRtratkicd(Integer pRtratkicd) {
        rtratkicd = pRtratkicd;
    }

    private String rtyouhyoucd;

    @Column(name=GenIT_SougouTuuti.RTYOUHYOUCD)
    public String getRtyouhyoucd() {
        return rtyouhyoucd;
    }

    public void setRtyouhyoucd(String pRtyouhyoucd) {
        rtyouhyoucd = pRtyouhyoucd;
    }

    private C_TyhyrenrakusikibetuKbn tyhyrenrakusikibetukbn;

    @Type(type="UserType_C_TyhyrenrakusikibetuKbn")
    @Column(name=GenIT_SougouTuuti.TYHYRENRAKUSIKIBETUKBN)
    public C_TyhyrenrakusikibetuKbn getTyhyrenrakusikibetukbn() {
        return tyhyrenrakusikibetukbn;
    }

    public void setTyhyrenrakusikibetukbn(C_TyhyrenrakusikibetuKbn pTyhyrenrakusikibetukbn) {
        tyhyrenrakusikibetukbn = pTyhyrenrakusikibetukbn;
    }

    private BizDate gansknnkaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_SougouTuuti.GANSKNNKAISIYMD)
    public BizDate getGansknnkaisiymd() {
        return gansknnkaisiymd;
    }

    public void setGansknnkaisiymd(BizDate pGansknnkaisiymd) {
        gansknnkaisiymd = pGansknnkaisiymd;
    }

    private BizCurrency gannyukyhntgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getGannyukyhntgk() {
        return gannyukyhntgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGannyukyhntgk(BizCurrency pGannyukyhntgk) {
        gannyukyhntgk = pGannyukyhntgk;
        gannyukyhntgkValue = null;
        gannyukyhntgkType  = null;
    }

    transient private BigDecimal gannyukyhntgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=GANNYUKYHNTGK, nullable=true)
    protected BigDecimal getGannyukyhntgkValue() {
        if (gannyukyhntgkValue == null && gannyukyhntgk != null) {
            if (gannyukyhntgk.isOptional()) return null;
            return gannyukyhntgk.absolute();
        }
        return gannyukyhntgkValue;
    }

    protected void setGannyukyhntgkValue(BigDecimal value) {
        gannyukyhntgkValue = value;
        gannyukyhntgk = Optional.fromNullable(toCurrencyType(gannyukyhntgkType))
            .transform(bizCurrencyTransformer(getGannyukyhntgkValue()))
            .orNull();
    }

    transient private String gannyukyhntgkType = null;

    @Column(name=GANNYUKYHNTGK + "$", nullable=true)
    protected String getGannyukyhntgkType() {
        if (gannyukyhntgkType == null && gannyukyhntgk != null) return gannyukyhntgk.getType().toString();
        if (gannyukyhntgkType == null && getGannyukyhntgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'gannyukyhntgk$' should not be NULL."));
        }
        return gannyukyhntgkType;
    }

    protected void setGannyukyhntgkType(String type) {
        gannyukyhntgkType = type;
        gannyukyhntgk = Optional.fromNullable(toCurrencyType(gannyukyhntgkType))
            .transform(bizCurrencyTransformer(getGannyukyhntgkValue()))
            .orNull();
    }

    private C_KataKbn katakbn1;

    @Type(type="UserType_C_KataKbn")
    @Column(name=GenIT_SougouTuuti.KATAKBN1)
    public C_KataKbn getKatakbn1() {
        return katakbn1;
    }

    public void setKatakbn1(C_KataKbn pKatakbn1) {
        katakbn1 = pKatakbn1;
    }

    private C_KataKbn katakbn2;

    @Type(type="UserType_C_KataKbn")
    @Column(name=GenIT_SougouTuuti.KATAKBN2)
    public C_KataKbn getKatakbn2() {
        return katakbn2;
    }

    public void setKatakbn2(C_KataKbn pKatakbn2) {
        katakbn2 = pKatakbn2;
    }

    private C_KataKbn katakbn3;

    @Type(type="UserType_C_KataKbn")
    @Column(name=GenIT_SougouTuuti.KATAKBN3)
    public C_KataKbn getKatakbn3() {
        return katakbn3;
    }

    public void setKatakbn3(C_KataKbn pKatakbn3) {
        katakbn3 = pKatakbn3;
    }

    private C_KataKbn katakbn4;

    @Type(type="UserType_C_KataKbn")
    @Column(name=GenIT_SougouTuuti.KATAKBN4)
    public C_KataKbn getKatakbn4() {
        return katakbn4;
    }

    public void setKatakbn4(C_KataKbn pKatakbn4) {
        katakbn4 = pKatakbn4;
    }

    private C_KataKbn katakbn5;

    @Type(type="UserType_C_KataKbn")
    @Column(name=GenIT_SougouTuuti.KATAKBN5)
    public C_KataKbn getKatakbn5() {
        return katakbn5;
    }

    public void setKatakbn5(C_KataKbn pKatakbn5) {
        katakbn5 = pKatakbn5;
    }

    private C_KataKbn katakbn6;

    @Type(type="UserType_C_KataKbn")
    @Column(name=GenIT_SougouTuuti.KATAKBN6)
    public C_KataKbn getKatakbn6() {
        return katakbn6;
    }

    public void setKatakbn6(C_KataKbn pKatakbn6) {
        katakbn6 = pKatakbn6;
    }

    private C_KataKbn katakbn7;

    @Type(type="UserType_C_KataKbn")
    @Column(name=GenIT_SougouTuuti.KATAKBN7)
    public C_KataKbn getKatakbn7() {
        return katakbn7;
    }

    public void setKatakbn7(C_KataKbn pKatakbn7) {
        katakbn7 = pKatakbn7;
    }

    private C_KataKbn katakbn8;

    @Type(type="UserType_C_KataKbn")
    @Column(name=GenIT_SougouTuuti.KATAKBN8)
    public C_KataKbn getKatakbn8() {
        return katakbn8;
    }

    public void setKatakbn8(C_KataKbn pKatakbn8) {
        katakbn8 = pKatakbn8;
    }

    private C_KataKbn katakbn9;

    @Type(type="UserType_C_KataKbn")
    @Column(name=GenIT_SougouTuuti.KATAKBN9)
    public C_KataKbn getKatakbn9() {
        return katakbn9;
    }

    public void setKatakbn9(C_KataKbn pKatakbn9) {
        katakbn9 = pKatakbn9;
    }

    private C_KataKbn katakbn10;

    @Type(type="UserType_C_KataKbn")
    @Column(name=GenIT_SougouTuuti.KATAKBN10)
    public C_KataKbn getKatakbn10() {
        return katakbn10;
    }

    public void setKatakbn10(C_KataKbn pKatakbn10) {
        katakbn10 = pKatakbn10;
    }

    private String sbhkuktnmkj1;

    @Column(name=GenIT_SougouTuuti.SBHKUKTNMKJ1)
    public String getSbhkuktnmkj1() {
        return sbhkuktnmkj1;
    }

    public void setSbhkuktnmkj1(String pSbhkuktnmkj1) {
        sbhkuktnmkj1 = pSbhkuktnmkj1;
    }

    private String sbhkuktnmkj2;

    @Column(name=GenIT_SougouTuuti.SBHKUKTNMKJ2)
    public String getSbhkuktnmkj2() {
        return sbhkuktnmkj2;
    }

    public void setSbhkuktnmkj2(String pSbhkuktnmkj2) {
        sbhkuktnmkj2 = pSbhkuktnmkj2;
    }

    private String sbhkuktnmkj3;

    @Column(name=GenIT_SougouTuuti.SBHKUKTNMKJ3)
    public String getSbhkuktnmkj3() {
        return sbhkuktnmkj3;
    }

    public void setSbhkuktnmkj3(String pSbhkuktnmkj3) {
        sbhkuktnmkj3 = pSbhkuktnmkj3;
    }

    private String sbhkuktnmkj4;

    @Column(name=GenIT_SougouTuuti.SBHKUKTNMKJ4)
    public String getSbhkuktnmkj4() {
        return sbhkuktnmkj4;
    }

    public void setSbhkuktnmkj4(String pSbhkuktnmkj4) {
        sbhkuktnmkj4 = pSbhkuktnmkj4;
    }

    private String sbhkuktnmkj5;

    @Column(name=GenIT_SougouTuuti.SBHKUKTNMKJ5)
    public String getSbhkuktnmkj5() {
        return sbhkuktnmkj5;
    }

    public void setSbhkuktnmkj5(String pSbhkuktnmkj5) {
        sbhkuktnmkj5 = pSbhkuktnmkj5;
    }

    private String sbhkuktseiymd1;

    @Column(name=GenIT_SougouTuuti.SBHKUKTSEIYMD1)
    public String getSbhkuktseiymd1() {
        return sbhkuktseiymd1;
    }

    public void setSbhkuktseiymd1(String pSbhkuktseiymd1) {
        sbhkuktseiymd1 = pSbhkuktseiymd1;
    }

    private String sbhkuktseiymd2;

    @Column(name=GenIT_SougouTuuti.SBHKUKTSEIYMD2)
    public String getSbhkuktseiymd2() {
        return sbhkuktseiymd2;
    }

    public void setSbhkuktseiymd2(String pSbhkuktseiymd2) {
        sbhkuktseiymd2 = pSbhkuktseiymd2;
    }

    private String sbhkuktseiymd3;

    @Column(name=GenIT_SougouTuuti.SBHKUKTSEIYMD3)
    public String getSbhkuktseiymd3() {
        return sbhkuktseiymd3;
    }

    public void setSbhkuktseiymd3(String pSbhkuktseiymd3) {
        sbhkuktseiymd3 = pSbhkuktseiymd3;
    }

    private String sbhkuktseiymd4;

    @Column(name=GenIT_SougouTuuti.SBHKUKTSEIYMD4)
    public String getSbhkuktseiymd4() {
        return sbhkuktseiymd4;
    }

    public void setSbhkuktseiymd4(String pSbhkuktseiymd4) {
        sbhkuktseiymd4 = pSbhkuktseiymd4;
    }

    private String sbhkuktseiymd5;

    @Column(name=GenIT_SougouTuuti.SBHKUKTSEIYMD5)
    public String getSbhkuktseiymd5() {
        return sbhkuktseiymd5;
    }

    public void setSbhkuktseiymd5(String pSbhkuktseiymd5) {
        sbhkuktseiymd5 = pSbhkuktseiymd5;
    }

    private Integer sbhkkukttyoukanin;

    @Column(name=GenIT_SougouTuuti.SBHKKUKTTYOUKANIN)
    @Range(min="0", max="99")
    public Integer getSbhkkukttyoukanin() {
        return sbhkkukttyoukanin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbhkkukttyoukanin(Integer pSbhkkukttyoukanin) {
        sbhkkukttyoukanin = pSbhkkukttyoukanin;
    }

    private BizNumber sbhktyoukaninbunwari;

    @Type(type="BizNumberType")
    @Column(name=GenIT_SougouTuuti.SBHKTYOUKANINBUNWARI)
    public BizNumber getSbhktyoukaninbunwari() {
        return sbhktyoukaninbunwari;
    }

    public void setSbhktyoukaninbunwari(BizNumber pSbhktyoukaninbunwari) {
        sbhktyoukaninbunwari = pSbhktyoukaninbunwari;
    }

    private BizNumber bnwari1;

    @Type(type="BizNumberType")
    @Column(name=GenIT_SougouTuuti.BNWARI1)
    public BizNumber getBnwari1() {
        return bnwari1;
    }

    public void setBnwari1(BizNumber pBnwari1) {
        bnwari1 = pBnwari1;
    }

    private BizNumber bnwari2;

    @Type(type="BizNumberType")
    @Column(name=GenIT_SougouTuuti.BNWARI2)
    public BizNumber getBnwari2() {
        return bnwari2;
    }

    public void setBnwari2(BizNumber pBnwari2) {
        bnwari2 = pBnwari2;
    }

    private BizNumber bnwari3;

    @Type(type="BizNumberType")
    @Column(name=GenIT_SougouTuuti.BNWARI3)
    public BizNumber getBnwari3() {
        return bnwari3;
    }

    public void setBnwari3(BizNumber pBnwari3) {
        bnwari3 = pBnwari3;
    }

    private BizNumber bnwari4;

    @Type(type="BizNumberType")
    @Column(name=GenIT_SougouTuuti.BNWARI4)
    public BizNumber getBnwari4() {
        return bnwari4;
    }

    public void setBnwari4(BizNumber pBnwari4) {
        bnwari4 = pBnwari4;
    }

    private BizNumber bnwari5;

    @Type(type="BizNumberType")
    @Column(name=GenIT_SougouTuuti.BNWARI5)
    public BizNumber getBnwari5() {
        return bnwari5;
    }

    public void setBnwari5(BizNumber pBnwari5) {
        bnwari5 = pBnwari5;
    }

    private C_PmnjtkKbn pmnjtkkbn;

    @Type(type="UserType_C_PmnjtkKbn")
    @Column(name=GenIT_SougouTuuti.PMNJTKKBN)
    public C_PmnjtkKbn getPmnjtkkbn() {
        return pmnjtkkbn;
    }

    public void setPmnjtkkbn(C_PmnjtkKbn pPmnjtkkbn) {
        pmnjtkkbn = pPmnjtkkbn;
    }

    private BizDate mosukeymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_SougouTuuti.MOSUKEYMD)
    @ValidDate
    public BizDate getMosukeymd() {
        return mosukeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosukeymd(BizDate pMosukeymd) {
        mosukeymd = pMosukeymd;
    }

    private C_SknnkaisikitkKbn sknnkaisikitkkbn;

    @Type(type="UserType_C_SknnkaisikitkKbn")
    @Column(name=GenIT_SougouTuuti.SKNNKAISIKITKKBN)
    public C_SknnkaisikitkKbn getSknnkaisikitkkbn() {
        return sknnkaisikitkkbn;
    }

    public void setSknnkaisikitkkbn(C_SknnkaisikitkKbn pSknnkaisikitkkbn) {
        sknnkaisikitkkbn = pSknnkaisikitkkbn;
    }

    private Integer koujyosyoumeirecnum;

    @Column(name=GenIT_SougouTuuti.KOUJYOSYOUMEIRECNUM)
    public Integer getKoujyosyoumeirecnum() {
        return koujyosyoumeirecnum;
    }

    public void setKoujyosyoumeirecnum(Integer pKoujyosyoumeirecnum) {
        koujyosyoumeirecnum = pKoujyosyoumeirecnum;
    }

    private BizDate hksknnkaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_SougouTuuti.HKSKNNKAISIYMD)
    public BizDate getHksknnkaisiymd() {
        return hksknnkaisiymd;
    }

    public void setHksknnkaisiymd(BizDate pHksknnkaisiymd) {
        hksknnkaisiymd = pHksknnkaisiymd;
    }

    private BizDate hkgansknnkaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_SougouTuuti.HKGANSKNNKAISIYMD)
    @ValidDate
    public BizDate getHkgansknnkaisiymd() {
        return hkgansknnkaisiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHkgansknnkaisiymd(BizDate pHkgansknnkaisiymd) {
        hkgansknnkaisiymd = pHkgansknnkaisiymd;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_SougouTuuti.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_SougouTuuti.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_SougouTuuti.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}