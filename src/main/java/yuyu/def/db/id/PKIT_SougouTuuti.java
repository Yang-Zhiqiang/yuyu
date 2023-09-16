package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.IT_SougouTuuti;
import yuyu.def.db.mapping.GenIT_SougouTuuti;
import yuyu.def.db.meta.GenQIT_SougouTuuti;
import yuyu.def.db.meta.QIT_SougouTuuti;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 総合通知テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_SougouTuuti}</td><td colspan="3">総合通知テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>tyouhyouprtymd</td><td>帳票作成日（印刷用）</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sknnkaisiymd</td><td>責任開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syouhnnmsyouken</td><td>商品名（証券用）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknmkj</td><td>契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknmkjkhukakbn</td><td>契約者名漢字化不可区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KjkhukaKbn C_KjkhukaKbn}</td></tr>
 *  <tr><td>hhknnmkj</td><td>被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnmkjkhukakbn</td><td>被保険者名漢字化不可区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KjkhukaKbn C_KjkhukaKbn}</td></tr>
 *  <tr><td>hhknseiymd</td><td>被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hhknsei</td><td>被保険者性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hhknsei C_Hhknsei}</td></tr>
 *  <tr><td>hhknnen</td><td>被保険者年齢</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>sbhenkanuktnmkj</td><td>死亡返還金受取人氏名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sibouhenkankinuktseiymd</td><td>死亡返還金受取人生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>stdrsknmkj</td><td>指定代理請求人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stdrskseiymd</td><td>指定代理請求人生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hrkp</td><td>払込保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hrkkaisuu</td><td>払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>hrkkeiro</td><td>払込経路</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkeiro C_Hrkkeiro}</td></tr>
 *  <tr><td>syutkkbn1</td><td>主契約特約区分_1</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyutkKbn C_SyutkKbn}</td></tr>
 *  <tr><td>syutkkbn2</td><td>主契約特約区分_2</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyutkKbn C_SyutkKbn}</td></tr>
 *  <tr><td>syutkkbn3</td><td>主契約特約区分_3</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyutkKbn C_SyutkKbn}</td></tr>
 *  <tr><td>syutkkbn4</td><td>主契約特約区分_4</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyutkKbn C_SyutkKbn}</td></tr>
 *  <tr><td>syutkkbn5</td><td>主契約特約区分_5</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyutkKbn C_SyutkKbn}</td></tr>
 *  <tr><td>syutkkbn6</td><td>主契約特約区分_6</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyutkKbn C_SyutkKbn}</td></tr>
 *  <tr><td>syutkkbn7</td><td>主契約特約区分_7</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyutkKbn C_SyutkKbn}</td></tr>
 *  <tr><td>syutkkbn8</td><td>主契約特約区分_8</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyutkKbn C_SyutkKbn}</td></tr>
 *  <tr><td>syutkkbn9</td><td>主契約特約区分_9</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyutkKbn C_SyutkKbn}</td></tr>
 *  <tr><td>syutkkbn10</td><td>主契約特約区分_10</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyutkKbn C_SyutkKbn}</td></tr>
 *  <tr><td>syouhncd1</td><td>商品コード_1</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhncd2</td><td>商品コード_2</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhncd3</td><td>商品コード_3</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhncd4</td><td>商品コード_4</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhncd5</td><td>商品コード_5</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhncd6</td><td>商品コード_6</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhncd7</td><td>商品コード_7</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhncd8</td><td>商品コード_8</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhncd9</td><td>商品コード_9</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhncd10</td><td>商品コード_10</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnsdno1</td><td>商品世代番号_1</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syouhnsdno2</td><td>商品世代番号_2</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syouhnsdno3</td><td>商品世代番号_3</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syouhnsdno4</td><td>商品世代番号_4</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syouhnsdno5</td><td>商品世代番号_5</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syouhnsdno6</td><td>商品世代番号_6</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syouhnsdno7</td><td>商品世代番号_7</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syouhnsdno8</td><td>商品世代番号_8</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syouhnsdno9</td><td>商品世代番号_9</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syouhnsdno10</td><td>商品世代番号_10</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kyksyouhnrenno1</td><td>契約商品連番_1</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kyksyouhnrenno2</td><td>契約商品連番_2</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kyksyouhnrenno3</td><td>契約商品連番_3</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kyksyouhnrenno4</td><td>契約商品連番_4</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kyksyouhnrenno5</td><td>契約商品連番_5</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kyksyouhnrenno6</td><td>契約商品連番_6</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kyksyouhnrenno7</td><td>契約商品連番_7</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kyksyouhnrenno8</td><td>契約商品連番_8</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kyksyouhnrenno9</td><td>契約商品連番_9</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kyksyouhnrenno10</td><td>契約商品連番_10</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kyhgndkatakbn1</td><td>給付限度型区分_1</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KyhgndkataKbn C_KyhgndkataKbn}</td></tr>
 *  <tr><td>kyhgndkatakbn2</td><td>給付限度型区分_2</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KyhgndkataKbn C_KyhgndkataKbn}</td></tr>
 *  <tr><td>kyhgndkatakbn3</td><td>給付限度型区分_3</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KyhgndkataKbn C_KyhgndkataKbn}</td></tr>
 *  <tr><td>kyhgndkatakbn4</td><td>給付限度型区分_4</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KyhgndkataKbn C_KyhgndkataKbn}</td></tr>
 *  <tr><td>kyhgndkatakbn5</td><td>給付限度型区分_5</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KyhgndkataKbn C_KyhgndkataKbn}</td></tr>
 *  <tr><td>kyhgndkatakbn6</td><td>給付限度型区分_6</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KyhgndkataKbn C_KyhgndkataKbn}</td></tr>
 *  <tr><td>kyhgndkatakbn7</td><td>給付限度型区分_7</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KyhgndkataKbn C_KyhgndkataKbn}</td></tr>
 *  <tr><td>kyhgndkatakbn8</td><td>給付限度型区分_8</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KyhgndkataKbn C_KyhgndkataKbn}</td></tr>
 *  <tr><td>kyhgndkatakbn9</td><td>給付限度型区分_9</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KyhgndkataKbn C_KyhgndkataKbn}</td></tr>
 *  <tr><td>kyhgndkatakbn10</td><td>給付限度型区分_10</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KyhgndkataKbn C_KyhgndkataKbn}</td></tr>
 *  <tr><td>hknkknsmnkbn1</td><td>保険期間歳満期区分_1</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HknkknsmnKbn C_HknkknsmnKbn}</td></tr>
 *  <tr><td>hknkknsmnkbn2</td><td>保険期間歳満期区分_2</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HknkknsmnKbn C_HknkknsmnKbn}</td></tr>
 *  <tr><td>hknkknsmnkbn3</td><td>保険期間歳満期区分_3</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HknkknsmnKbn C_HknkknsmnKbn}</td></tr>
 *  <tr><td>hknkknsmnkbn4</td><td>保険期間歳満期区分_4</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HknkknsmnKbn C_HknkknsmnKbn}</td></tr>
 *  <tr><td>hknkknsmnkbn5</td><td>保険期間歳満期区分_5</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HknkknsmnKbn C_HknkknsmnKbn}</td></tr>
 *  <tr><td>hknkknsmnkbn6</td><td>保険期間歳満期区分_6</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HknkknsmnKbn C_HknkknsmnKbn}</td></tr>
 *  <tr><td>hknkknsmnkbn7</td><td>保険期間歳満期区分_7</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HknkknsmnKbn C_HknkknsmnKbn}</td></tr>
 *  <tr><td>hknkknsmnkbn8</td><td>保険期間歳満期区分_8</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HknkknsmnKbn C_HknkknsmnKbn}</td></tr>
 *  <tr><td>hknkknsmnkbn9</td><td>保険期間歳満期区分_9</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HknkknsmnKbn C_HknkknsmnKbn}</td></tr>
 *  <tr><td>hknkknsmnkbn10</td><td>保険期間歳満期区分_10</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HknkknsmnKbn C_HknkknsmnKbn}</td></tr>
 *  <tr><td>hknkkn1</td><td>保険期間_1</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hknkkn2</td><td>保険期間_2</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hknkkn3</td><td>保険期間_3</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hknkkn4</td><td>保険期間_4</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hknkkn5</td><td>保険期間_5</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hknkkn6</td><td>保険期間_6</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hknkkn7</td><td>保険期間_7</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hknkkn8</td><td>保険期間_8</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hknkkn9</td><td>保険期間_9</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hknkkn10</td><td>保険期間_10</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hrkkknsmnkbn1</td><td>払込期間歳満期区分_1</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HrkkknsmnKbn C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>hrkkknsmnkbn2</td><td>払込期間歳満期区分_2</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HrkkknsmnKbn C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>hrkkknsmnkbn3</td><td>払込期間歳満期区分_3</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HrkkknsmnKbn C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>hrkkknsmnkbn4</td><td>払込期間歳満期区分_4</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HrkkknsmnKbn C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>hrkkknsmnkbn5</td><td>払込期間歳満期区分_5</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HrkkknsmnKbn C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>hrkkknsmnkbn6</td><td>払込期間歳満期区分_6</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HrkkknsmnKbn C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>hrkkknsmnkbn7</td><td>払込期間歳満期区分_7</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HrkkknsmnKbn C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>hrkkknsmnkbn8</td><td>払込期間歳満期区分_8</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HrkkknsmnKbn C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>hrkkknsmnkbn9</td><td>払込期間歳満期区分_9</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HrkkknsmnKbn C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>hrkkknsmnkbn10</td><td>払込期間歳満期区分_10</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HrkkknsmnKbn C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>hrkkkn1</td><td>払込期間_1</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hrkkkn2</td><td>払込期間_2</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hrkkkn3</td><td>払込期間_3</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hrkkkn4</td><td>払込期間_4</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hrkkkn5</td><td>払込期間_5</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hrkkkn6</td><td>払込期間_6</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hrkkkn7</td><td>払込期間_7</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hrkkkn8</td><td>払込期間_8</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hrkkkn9</td><td>払込期間_9</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hrkkkn10</td><td>払込期間_10</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syouhnnm1</td><td>商品名_1</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnnm2</td><td>商品名_2</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnnm3</td><td>商品名_3</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnnm4</td><td>商品名_4</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnnm5</td><td>商品名_5</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnnm6</td><td>商品名_6</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnnm7</td><td>商品名_7</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnnm8</td><td>商品名_8</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnnm9</td><td>商品名_9</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnnm10</td><td>商品名_10</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kihons1</td><td>基本Ｓ_1</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kihons2</td><td>基本Ｓ_2</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kihons3</td><td>基本Ｓ_3</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kihons4</td><td>基本Ｓ_4</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kihons5</td><td>基本Ｓ_5</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kihons6</td><td>基本Ｓ_6</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kihons7</td><td>基本Ｓ_7</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kihons8</td><td>基本Ｓ_8</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kihons9</td><td>基本Ｓ_9</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kihons10</td><td>基本Ｓ_10</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>p1</td><td>保険料_1</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>p2</td><td>保険料_2</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>p3</td><td>保険料_3</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>p4</td><td>保険料_4</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>p5</td><td>保険料_5</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>p6</td><td>保険料_6</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>p7</td><td>保険料_7</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>p8</td><td>保険料_8</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>p9</td><td>保険料_9</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>p10</td><td>保険料_10</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kihonssyuruikbn1</td><td>基本Ｓ種類区分_1</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KihonssyuruiKbn C_KihonssyuruiKbn}</td></tr>
 *  <tr><td>kihonssyuruikbn2</td><td>基本Ｓ種類区分_2</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KihonssyuruiKbn C_KihonssyuruiKbn}</td></tr>
 *  <tr><td>kihonssyuruikbn3</td><td>基本Ｓ種類区分_3</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KihonssyuruiKbn C_KihonssyuruiKbn}</td></tr>
 *  <tr><td>kihonssyuruikbn4</td><td>基本Ｓ種類区分_4</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KihonssyuruiKbn C_KihonssyuruiKbn}</td></tr>
 *  <tr><td>kihonssyuruikbn5</td><td>基本Ｓ種類区分_5</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KihonssyuruiKbn C_KihonssyuruiKbn}</td></tr>
 *  <tr><td>kihonssyuruikbn6</td><td>基本Ｓ種類区分_6</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KihonssyuruiKbn C_KihonssyuruiKbn}</td></tr>
 *  <tr><td>kihonssyuruikbn7</td><td>基本Ｓ種類区分_7</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KihonssyuruiKbn C_KihonssyuruiKbn}</td></tr>
 *  <tr><td>kihonssyuruikbn8</td><td>基本Ｓ種類区分_8</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KihonssyuruiKbn C_KihonssyuruiKbn}</td></tr>
 *  <tr><td>kihonssyuruikbn9</td><td>基本Ｓ種類区分_9</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KihonssyuruiKbn C_KihonssyuruiKbn}</td></tr>
 *  <tr><td>kihonssyuruikbn10</td><td>基本Ｓ種類区分_10</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KihonssyuruiKbn C_KihonssyuruiKbn}</td></tr>
 *  <tr><td>syukyhkinkatakbn1</td><td>手術給付金型区分_1</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyukyhkinkataKbn C_SyukyhkinkataKbn}</td></tr>
 *  <tr><td>syukyhkinkatakbn2</td><td>手術給付金型区分_2</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyukyhkinkataKbn C_SyukyhkinkataKbn}</td></tr>
 *  <tr><td>syukyhkinkatakbn3</td><td>手術給付金型区分_3</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyukyhkinkataKbn C_SyukyhkinkataKbn}</td></tr>
 *  <tr><td>syukyhkinkatakbn4</td><td>手術給付金型区分_4</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyukyhkinkataKbn C_SyukyhkinkataKbn}</td></tr>
 *  <tr><td>syukyhkinkatakbn5</td><td>手術給付金型区分_5</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyukyhkinkataKbn C_SyukyhkinkataKbn}</td></tr>
 *  <tr><td>syukyhkinkatakbn6</td><td>手術給付金型区分_6</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyukyhkinkataKbn C_SyukyhkinkataKbn}</td></tr>
 *  <tr><td>syukyhkinkatakbn7</td><td>手術給付金型区分_7</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyukyhkinkataKbn C_SyukyhkinkataKbn}</td></tr>
 *  <tr><td>syukyhkinkatakbn8</td><td>手術給付金型区分_8</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyukyhkinkataKbn C_SyukyhkinkataKbn}</td></tr>
 *  <tr><td>syukyhkinkatakbn9</td><td>手術給付金型区分_9</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyukyhkinkataKbn C_SyukyhkinkataKbn}</td></tr>
 *  <tr><td>syukyhkinkatakbn10</td><td>手術給付金型区分_10</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyukyhkinkataKbn C_SyukyhkinkataKbn}</td></tr>
 *  <tr><td>rokudaissbtkkyhktkbn1</td><td>６大生活習慣病追加給付型区分_1</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_6daiLdKbn C_6daiLdKbn}</td></tr>
 *  <tr><td>rokudaissbtkkyhktkbn2</td><td>６大生活習慣病追加給付型区分_2</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_6daiLdKbn C_6daiLdKbn}</td></tr>
 *  <tr><td>rokudaissbtkkyhktkbn3</td><td>６大生活習慣病追加給付型区分_3</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_6daiLdKbn C_6daiLdKbn}</td></tr>
 *  <tr><td>rokudaissbtkkyhktkbn4</td><td>６大生活習慣病追加給付型区分_4</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_6daiLdKbn C_6daiLdKbn}</td></tr>
 *  <tr><td>rokudaissbtkkyhktkbn5</td><td>６大生活習慣病追加給付型区分_5</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_6daiLdKbn C_6daiLdKbn}</td></tr>
 *  <tr><td>rokudaissbtkkyhktkbn6</td><td>６大生活習慣病追加給付型区分_6</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_6daiLdKbn C_6daiLdKbn}</td></tr>
 *  <tr><td>rokudaissbtkkyhktkbn7</td><td>６大生活習慣病追加給付型区分_7</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_6daiLdKbn C_6daiLdKbn}</td></tr>
 *  <tr><td>rokudaissbtkkyhktkbn8</td><td>６大生活習慣病追加給付型区分_8</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_6daiLdKbn C_6daiLdKbn}</td></tr>
 *  <tr><td>rokudaissbtkkyhktkbn9</td><td>６大生活習慣病追加給付型区分_9</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_6daiLdKbn C_6daiLdKbn}</td></tr>
 *  <tr><td>rokudaissbtkkyhktkbn10</td><td>６大生活習慣病追加給付型区分_10</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_6daiLdKbn C_6daiLdKbn}</td></tr>
 *  <tr><td>khnkyhgk1</td><td>基本給付金額_1</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>khnkyhgk2</td><td>基本給付金額_2</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>khnkyhgk3</td><td>基本給付金額_3</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>khnkyhgk4</td><td>基本給付金額_4</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>khnkyhgk5</td><td>基本給付金額_5</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>khnkyhgk6</td><td>基本給付金額_6</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>khnkyhgk7</td><td>基本給付金額_7</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>khnkyhgk8</td><td>基本給付金額_8</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>khnkyhgk9</td><td>基本給付金額_9</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>khnkyhgk10</td><td>基本給付金額_10</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tsinyno</td><td>通信先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr1kj</td><td>通信先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr2kj</td><td>通信先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr3kj</td><td>通信先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr4kj</td><td>通信先住所４（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>aitesyono</td><td>相手証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtencd</td><td>代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtennmkj</td><td>代理店名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rkaiyakuhrumukbn</td><td>（帳票用）解約返戻金有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>rkaiyakuhr</td><td>（帳票用）解約返戻金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>rsbhenkan</td><td>（帳票用）死亡返還金</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>rhtnpbuinm1</td><td>（帳票用）不担保部位名１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>htnpkkn1</td><td>不担保期間１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Htnpkkn C_Htnpkkn}</td></tr>
 *  <tr><td>rhtnpbuinm2</td><td>（帳票用）不担保部位名２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>htnpkkn2</td><td>不担保期間２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Htnpkkn C_Htnpkkn}</td></tr>
 *  <tr><td>rhtnpbuinm3</td><td>（帳票用）不担保部位名３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>htnpkkn3</td><td>不担保期間３</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Htnpkkn C_Htnpkkn}</td></tr>
 *  <tr><td>rhtnpbuinm4</td><td>（帳票用）不担保部位名４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>htnpkkn4</td><td>不担保期間４</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Htnpkkn C_Htnpkkn}</td></tr>
 *  <tr><td>tokkoudosghtnpkbn</td><td>特定高度障害不担保区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TokkoudosghtnpKbn C_TokkoudosghtnpKbn}</td></tr>
 *  <tr><td>rtratkicd</td><td>（帳票用）取扱コード</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>rtyouhyoucd</td><td>（帳票用）帳票コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tyhyrenrakusikibetukbn</td><td>帳票連絡先識別区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TyhyrenrakusikibetuKbn C_TyhyrenrakusikibetuKbn}</td></tr>
 *  <tr><td>gansknnkaisiymd</td><td>がん責任開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gannyukyhntgk</td><td>がん入院給付日額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>katakbn1</td><td>型区分_1</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KataKbn C_KataKbn}</td></tr>
 *  <tr><td>katakbn2</td><td>型区分_2</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KataKbn C_KataKbn}</td></tr>
 *  <tr><td>katakbn3</td><td>型区分_3</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KataKbn C_KataKbn}</td></tr>
 *  <tr><td>katakbn4</td><td>型区分_4</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KataKbn C_KataKbn}</td></tr>
 *  <tr><td>katakbn5</td><td>型区分_5</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KataKbn C_KataKbn}</td></tr>
 *  <tr><td>katakbn6</td><td>型区分_6</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KataKbn C_KataKbn}</td></tr>
 *  <tr><td>katakbn7</td><td>型区分_7</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KataKbn C_KataKbn}</td></tr>
 *  <tr><td>katakbn8</td><td>型区分_8</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KataKbn C_KataKbn}</td></tr>
 *  <tr><td>katakbn9</td><td>型区分_9</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KataKbn C_KataKbn}</td></tr>
 *  <tr><td>katakbn10</td><td>型区分_10</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KataKbn C_KataKbn}</td></tr>
 *  <tr><td>sbhkuktnmkj1</td><td>死亡保険金受取人氏名（漢字）_1</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sbhkuktnmkj2</td><td>死亡保険金受取人氏名（漢字）_2</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sbhkuktnmkj3</td><td>死亡保険金受取人氏名（漢字）_3</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sbhkuktnmkj4</td><td>死亡保険金受取人氏名（漢字）_4</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sbhkuktnmkj5</td><td>死亡保険金受取人氏名（漢字）_5</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sbhkuktseiymd1</td><td>死亡保険金受取人生年月日_1</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sbhkuktseiymd2</td><td>死亡保険金受取人生年月日_2</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sbhkuktseiymd3</td><td>死亡保険金受取人生年月日_3</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sbhkuktseiymd4</td><td>死亡保険金受取人生年月日_4</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sbhkuktseiymd5</td><td>死亡保険金受取人生年月日_5</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sbhkkukttyoukanin</td><td>死亡保険金受取人超過人数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>sbhktyoukaninbunwari</td><td>死亡保険金超過人数分割割合</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>bnwari1</td><td>分割割合_1</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>bnwari2</td><td>分割割合_2</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>bnwari3</td><td>分割割合_3</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>bnwari4</td><td>分割割合_4</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>bnwari5</td><td>分割割合_5</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>pmnjtkkbn</td><td>保険料免除特約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_PmnjtkKbn C_PmnjtkKbn}</td></tr>
 *  <tr><td>mosukeymd</td><td>申込書受付日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sknnkaisikitkkbn</td><td>責任開始期特約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SknnkaisikitkKbn C_SknnkaisikitkKbn}</td></tr>
 *  <tr><td>koujyosyoumeirecnum</td><td>控除証明書レコード数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hksknnkaisiymd</td><td>復活責任開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hkgansknnkaisiymd</td><td>復活がん責任開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_SougouTuuti
 * @see     GenIT_SougouTuuti
 * @see     QIT_SougouTuuti
 * @see     GenQIT_SougouTuuti
 */
public class PKIT_SougouTuuti extends AbstractExDBPrimaryKey<IT_SougouTuuti, PKIT_SougouTuuti> {

    private static final long serialVersionUID = 1L;

    public PKIT_SougouTuuti() {
    }

    public PKIT_SougouTuuti(
        String pKbnkey,
        String pSyono,
        BizDate pTyouhyouymd
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        tyouhyouymd = pTyouhyouymd;
    }

    @Transient
    @Override
    public Class<IT_SougouTuuti> getEntityClass() {
        return IT_SougouTuuti.class;
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
    private BizDate tyouhyouymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getTyouhyouymd() {
        return tyouhyouymd;
    }

    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        tyouhyouymd = pTyouhyouymd;
    }

}