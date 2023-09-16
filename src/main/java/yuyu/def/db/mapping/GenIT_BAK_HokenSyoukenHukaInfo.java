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
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_BAK_HokenSyoukenHukaInfo;
import yuyu.def.db.id.PKIT_BAK_HokenSyoukenHukaInfo;
import yuyu.def.db.meta.GenQIT_BAK_HokenSyoukenHukaInfo;
import yuyu.def.db.meta.QIT_BAK_HokenSyoukenHukaInfo;
import yuyu.def.db.type.UserType_C_Seibetu;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;
import yuyu.infr.validation.constraints.Tel;

/**
 * 保険証券付加情報データバックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_HokenSyoukenHukaInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_HokenSyoukenHukaInfo}</td><td colspan="3">保険証券付加情報データバックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_HokenSyoukenHukaInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_HokenSyoukenHukaInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_HokenSyoukenHukaInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">{@link PKIT_BAK_HokenSyoukenHukaInfo ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNksyuruinmsyouken nksyuruinmsyouken}</td><td>年金種類名称（証券用）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTeikiikkatubaraitukisuu teikiikkatubaraitukisuu}</td><td>定期一括払月数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZnntikiktbriyhrkgktuktype znntikiktbriyhrkgktuktype}</td><td>前納定期一括払円貨払込額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getZnntikiktbriyenhrkgk znntikiktbriyenhrkgk}</td><td>前納定期一括払円貨払込額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getZnnkai2 znnkai2}</td><td>前納回数（２桁）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHutanhiyustmkyakkjrtmin hutanhiyustmkyakkjrtmin}</td><td>ご負担費用説明欄解約控除率最小</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHutanhiyustmkyakkjrtmax hutanhiyustmkyakkjrtmax}</td><td>ご負担費用説明欄解約控除率最大</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getFstpznnkngktuktype fstpznnkngktuktype}</td><td>初回Ｐご確認欄前納金額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getFstpznnkngk fstpznnkngk}</td><td>初回Ｐご確認欄前納金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDskjnkngkktuktype dskjnkngkktuktype}</td><td>ＤＳ基準金額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDskjnkngk dskjnkngk}</td><td>ＤＳ基準金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getTikiktbriyhrkgktuktype tikiktbriyhrkgktuktype}</td><td>定期一括払円貨払込額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getTikiktbriyenhrkgk tikiktbriyenhrkgk}</td><td>定期一括払円貨払込額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKzktirasidouhuukbn1 kzktirasidouhuukbn1}</td><td>ご家族登録チラシ１同封区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKzktirasidouhuukbn2 kzktirasidouhuukbn2}</td><td>ご家族登録チラシ２同封区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKykdairitirasidouhuukbn kykdairitirasidouhuukbn}</td><td>保険契約者代理人チラシ同封区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSkhtirasidouhuukbn skhtirasidouhuukbn}</td><td>債権法チラシ同封区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getYakkannewoldkbn yakkannewoldkbn}</td><td>約款新旧区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzktourokuservicemsg1 kzktourokuservicemsg1}</td><td>ご家族登録サービスメッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzktourokuservicemsg2 kzktourokuservicemsg2}</td><td>ご家族登録サービスメッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzktourokuservicemsg3 kzktourokuservicemsg3}</td><td>ご家族登録サービスメッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzktourokuservicemsg4 kzktourokuservicemsg4}</td><td>ご家族登録サービスメッセージコード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzktourokuservicemsg5 kzktourokuservicemsg5}</td><td>ご家族登録サービスメッセージコード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzktourokuservicemsg6 kzktourokuservicemsg6}</td><td>ご家族登録サービスメッセージコード６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzktourokuservicemsg7 kzktourokuservicemsg7}</td><td>ご家族登録サービスメッセージコード７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzktourokuservicemsg8 kzktourokuservicemsg8}</td><td>ご家族登録サービスメッセージコード８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzknmkj118 trkkzknmkj118}</td><td>登録家族名１（１８桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzksei1 trkkzksei1}</td><td>登録家族性別１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Seibetu}</td></tr>
 *  <tr><td>{@link #getTrkkzkseiymd1 trkkzkseiymd1}</td><td>登録家族生年月日１</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTrkkzkyno1 trkkzkyno1}</td><td>登録家族郵便番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzkadr1kj1 trkkzkadr1kj1}</td><td>登録家族住所１（漢字）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzkadr2kj1 trkkzkadr2kj1}</td><td>登録家族住所２（漢字）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzkadr3kj1 trkkzkadr3kj1}</td><td>登録家族住所３（漢字）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzktelno1 trkkzktelno1}</td><td>登録家族電話番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzksei2 trkkzksei2}</td><td>登録家族性別２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Seibetu}</td></tr>
 *  <tr><td>{@link #getTrkkzknmkj218 trkkzknmkj218}</td><td>登録家族名２（１８桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzkseiymd2 trkkzkseiymd2}</td><td>登録家族生年月日２</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTrkkzkyno2 trkkzkyno2}</td><td>登録家族郵便番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzkadr1kj2 trkkzkadr1kj2}</td><td>登録家族住所１（漢字）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzkadr2kj2 trkkzkadr2kj2}</td><td>登録家族住所２（漢字）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzkadr3kj2 trkkzkadr3kj2}</td><td>登録家族住所３（漢字）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkkzktelno2 trkkzktelno2}</td><td>登録家族電話番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykdairinm18 kykdairinm18}</td><td>契約者代理人名（１８桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhkndairinm hhkndairinm}</td><td>被保険者代理人氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRendouritu rendouritu}</td><td>連動率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTeikisiharaikin teikisiharaikin}</td><td>定期支払金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgkyentype dai1sbjiuktgkyentype}</td><td>第１死亡時受取額（円貨）通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1zennouzndk01 dai1zennouzndk01}</td><td>第１前納残高０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1zennouzndktype01 dai1zennouzndktype01}</td><td>第１前納残高通貨タイプ０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgk01 dai1sbjiuktgk01}</td><td>第１死亡時受取額０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgktype01 dai1sbjiuktgktype01}</td><td>第１死亡時受取額通貨タイプ０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgkyendaka01 dai1sbjiuktgkyendaka01}</td><td>第１死亡時受取額（円貨）（円高）０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgkyenkijyun01 dai1sbjiuktgkyenkijyun01}</td><td>第１死亡時受取額（円貨）（中央値）０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgkyenyasu01 dai1sbjiuktgkyenyasu01}</td><td>第１死亡時受取額（円貨）（円安）０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1zennouzndk02 dai1zennouzndk02}</td><td>第１前納残高０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1zennouzndktype02 dai1zennouzndktype02}</td><td>第１前納残高通貨タイプ０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgk02 dai1sbjiuktgk02}</td><td>第１死亡時受取額０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgktype02 dai1sbjiuktgktype02}</td><td>第１死亡時受取額通貨タイプ０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgkyendaka02 dai1sbjiuktgkyendaka02}</td><td>第１死亡時受取額（円貨）（円高）０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgkyenkijyun02 dai1sbjiuktgkyenkijyun02}</td><td>第１死亡時受取額（円貨）（中央値）０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgkyenyasu02 dai1sbjiuktgkyenyasu02}</td><td>第１死亡時受取額（円貨）（円安）０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1zennouzndk03 dai1zennouzndk03}</td><td>第１前納残高０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1zennouzndktype03 dai1zennouzndktype03}</td><td>第１前納残高通貨タイプ０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgk03 dai1sbjiuktgk03}</td><td>第１死亡時受取額０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgktype03 dai1sbjiuktgktype03}</td><td>第１死亡時受取額通貨タイプ０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgkyendaka03 dai1sbjiuktgkyendaka03}</td><td>第１死亡時受取額（円貨）（円高）０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgkyenkijyun03 dai1sbjiuktgkyenkijyun03}</td><td>第１死亡時受取額（円貨）（中央値）０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgkyenyasu03 dai1sbjiuktgkyenyasu03}</td><td>第１死亡時受取額（円貨）（円安）０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1zennouzndk04 dai1zennouzndk04}</td><td>第１前納残高０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1zennouzndktype04 dai1zennouzndktype04}</td><td>第１前納残高通貨タイプ０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgk04 dai1sbjiuktgk04}</td><td>第１死亡時受取額０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgktype04 dai1sbjiuktgktype04}</td><td>第１死亡時受取額通貨タイプ０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgkyendaka04 dai1sbjiuktgkyendaka04}</td><td>第１死亡時受取額（円貨）（円高）０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgkyenkijyun04 dai1sbjiuktgkyenkijyun04}</td><td>第１死亡時受取額（円貨）（中央値）０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgkyenyasu04 dai1sbjiuktgkyenyasu04}</td><td>第１死亡時受取額（円貨）（円安）０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1zennouzndk05 dai1zennouzndk05}</td><td>第１前納残高０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1zennouzndktype05 dai1zennouzndktype05}</td><td>第１前納残高通貨タイプ０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgk05 dai1sbjiuktgk05}</td><td>第１死亡時受取額０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgktype05 dai1sbjiuktgktype05}</td><td>第１死亡時受取額通貨タイプ０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgkyendaka05 dai1sbjiuktgkyendaka05}</td><td>第１死亡時受取額（円貨）（円高）０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgkyenkijyun05 dai1sbjiuktgkyenkijyun05}</td><td>第１死亡時受取額（円貨）（中央値）０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgkyenyasu05 dai1sbjiuktgkyenyasu05}</td><td>第１死亡時受取額（円貨）（円安）０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1zennouzndk06 dai1zennouzndk06}</td><td>第１前納残高０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1zennouzndktype06 dai1zennouzndktype06}</td><td>第１前納残高通貨タイプ０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgk06 dai1sbjiuktgk06}</td><td>第１死亡時受取額０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgktype06 dai1sbjiuktgktype06}</td><td>第１死亡時受取額通貨タイプ０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgkyendaka06 dai1sbjiuktgkyendaka06}</td><td>第１死亡時受取額（円貨）（円高）０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgkyenkijyun06 dai1sbjiuktgkyenkijyun06}</td><td>第１死亡時受取額（円貨）（中央値）０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getDai1sbjiuktgkyenyasu06 dai1sbjiuktgkyenyasu06}</td><td>第１死亡時受取額（円貨）（円安）０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkydaka01 kaigomaehrjrugkydaka01}</td><td>介護前払受領額０１（円高）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkydaka02 kaigomaehrjrugkydaka02}</td><td>介護前払受領額０２（円高）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkydaka03 kaigomaehrjrugkydaka03}</td><td>介護前払受領額０３（円高）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkydaka04 kaigomaehrjrugkydaka04}</td><td>介護前払受領額０４（円高）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkydaka05 kaigomaehrjrugkydaka05}</td><td>介護前払受領額０５（円高）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkydaka06 kaigomaehrjrugkydaka06}</td><td>介護前払受領額０６（円高）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkydaka07 kaigomaehrjrugkydaka07}</td><td>介護前払受領額０７（円高）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkydaka08 kaigomaehrjrugkydaka08}</td><td>介護前払受領額０８（円高）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkydaka09 kaigomaehrjrugkydaka09}</td><td>介護前払受領額０９（円高）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkydaka10 kaigomaehrjrugkydaka10}</td><td>介護前払受領額１０（円高）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkykijyun01 kaigomaehrjrugkykijyun01}</td><td>介護前払受領額０１（中央値）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkykijyun02 kaigomaehrjrugkykijyun02}</td><td>介護前払受領額０２（中央値）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkykijyun03 kaigomaehrjrugkykijyun03}</td><td>介護前払受領額０３（中央値）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkykijyun04 kaigomaehrjrugkykijyun04}</td><td>介護前払受領額０４（中央値）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkykijyun05 kaigomaehrjrugkykijyun05}</td><td>介護前払受領額０５（中央値）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkykijyun06 kaigomaehrjrugkykijyun06}</td><td>介護前払受領額０６（中央値）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkykijyun07 kaigomaehrjrugkykijyun07}</td><td>介護前払受領額０７（中央値）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkykijyun08 kaigomaehrjrugkykijyun08}</td><td>介護前払受領額０８（中央値）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkykijyun09 kaigomaehrjrugkykijyun09}</td><td>介護前払受領額０９（中央値）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkykijyun10 kaigomaehrjrugkykijyun10}</td><td>介護前払受領額１０（中央値）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkyyasu01 kaigomaehrjrugkyyasu01}</td><td>介護前払受領額０１（円安）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkyyasu02 kaigomaehrjrugkyyasu02}</td><td>介護前払受領額０２（円安）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkyyasu03 kaigomaehrjrugkyyasu03}</td><td>介護前払受領額０３（円安）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkyyasu04 kaigomaehrjrugkyyasu04}</td><td>介護前払受領額０４（円安）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkyyasu05 kaigomaehrjrugkyyasu05}</td><td>介護前払受領額０５（円安）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkyyasu06 kaigomaehrjrugkyyasu06}</td><td>介護前払受領額０６（円安）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkyyasu07 kaigomaehrjrugkyyasu07}</td><td>介護前払受領額０７（円安）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkyyasu08 kaigomaehrjrugkyyasu08}</td><td>介護前払受領額０８（円安）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkyyasu09 kaigomaehrjrugkyyasu09}</td><td>介護前払受領額０９（円安）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaigomaehrjrugkyyasu10 kaigomaehrjrugkyyasu10}</td><td>介護前払受領額１０（円安）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 * </table>
 * @see     IT_BAK_HokenSyoukenHukaInfo
 * @see     PKIT_BAK_HokenSyoukenHukaInfo
 * @see     QIT_BAK_HokenSyoukenHukaInfo
 * @see     GenQIT_BAK_HokenSyoukenHukaInfo
 */
@MappedSuperclass
@Table(name=GenIT_BAK_HokenSyoukenHukaInfo.TABLE_NAME)
@IdClass(value=PKIT_BAK_HokenSyoukenHukaInfo.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Seibetu", typeClass=UserType_C_Seibetu.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenIT_BAK_HokenSyoukenHukaInfo extends AbstractExDBEntity<IT_BAK_HokenSyoukenHukaInfo, PKIT_BAK_HokenSyoukenHukaInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_HokenSyoukenHukaInfo";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String TYOUHYOUYMD              = "tyouhyouymd";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String NKSYURUINMSYOUKEN        = "nksyuruinmsyouken";
    public static final String TEIKIIKKATUBARAITUKISUU  = "teikiikkatubaraitukisuu";
    public static final String ZNNTIKIKTBRIYHRKGKTUKTYPE = "znntikiktbriyhrkgktuktype";
    public static final String ZNNTIKIKTBRIYENHRKGK     = "znntikiktbriyenhrkgk";
    public static final String ZNNKAI2                  = "znnkai2";
    public static final String HUTANHIYUSTMKYAKKJRTMIN  = "hutanhiyustmkyakkjrtmin";
    public static final String HUTANHIYUSTMKYAKKJRTMAX  = "hutanhiyustmkyakkjrtmax";
    public static final String FSTPZNNKNGKTUKTYPE       = "fstpznnkngktuktype";
    public static final String FSTPZNNKNGK              = "fstpznnkngk";
    public static final String DSKJNKNGKKTUKTYPE        = "dskjnkngkktuktype";
    public static final String DSKJNKNGK                = "dskjnkngk";
    public static final String TIKIKTBRIYHRKGKTUKTYPE   = "tikiktbriyhrkgktuktype";
    public static final String TIKIKTBRIYENHRKGK        = "tikiktbriyenhrkgk";
    public static final String KZKTIRASIDOUHUUKBN1      = "kzktirasidouhuukbn1";
    public static final String KZKTIRASIDOUHUUKBN2      = "kzktirasidouhuukbn2";
    public static final String KYKDAIRITIRASIDOUHUUKBN  = "kykdairitirasidouhuukbn";
    public static final String SKHTIRASIDOUHUUKBN       = "skhtirasidouhuukbn";
    public static final String YAKKANNEWOLDKBN          = "yakkannewoldkbn";
    public static final String KZKTOUROKUSERVICEMSG1    = "kzktourokuservicemsg1";
    public static final String KZKTOUROKUSERVICEMSG2    = "kzktourokuservicemsg2";
    public static final String KZKTOUROKUSERVICEMSG3    = "kzktourokuservicemsg3";
    public static final String KZKTOUROKUSERVICEMSG4    = "kzktourokuservicemsg4";
    public static final String KZKTOUROKUSERVICEMSG5    = "kzktourokuservicemsg5";
    public static final String KZKTOUROKUSERVICEMSG6    = "kzktourokuservicemsg6";
    public static final String KZKTOUROKUSERVICEMSG7    = "kzktourokuservicemsg7";
    public static final String KZKTOUROKUSERVICEMSG8    = "kzktourokuservicemsg8";
    public static final String TRKKZKNMKJ118            = "trkkzknmkj118";
    public static final String TRKKZKSEI1               = "trkkzksei1";
    public static final String TRKKZKSEIYMD1            = "trkkzkseiymd1";
    public static final String TRKKZKYNO1               = "trkkzkyno1";
    public static final String TRKKZKADR1KJ1            = "trkkzkadr1kj1";
    public static final String TRKKZKADR2KJ1            = "trkkzkadr2kj1";
    public static final String TRKKZKADR3KJ1            = "trkkzkadr3kj1";
    public static final String TRKKZKTELNO1             = "trkkzktelno1";
    public static final String TRKKZKSEI2               = "trkkzksei2";
    public static final String TRKKZKNMKJ218            = "trkkzknmkj218";
    public static final String TRKKZKSEIYMD2            = "trkkzkseiymd2";
    public static final String TRKKZKYNO2               = "trkkzkyno2";
    public static final String TRKKZKADR1KJ2            = "trkkzkadr1kj2";
    public static final String TRKKZKADR2KJ2            = "trkkzkadr2kj2";
    public static final String TRKKZKADR3KJ2            = "trkkzkadr3kj2";
    public static final String TRKKZKTELNO2             = "trkkzktelno2";
    public static final String KYKDAIRINM18             = "kykdairinm18";
    public static final String HHKNDAIRINM              = "hhkndairinm";
    public static final String RENDOURITU               = "rendouritu";
    public static final String TEIKISIHARAIKIN          = "teikisiharaikin";
    public static final String DAI1SBJIUKTGKYENTYPE     = "dai1sbjiuktgkyentype";
    public static final String DAI1ZENNOUZNDK01         = "dai1zennouzndk01";
    public static final String DAI1ZENNOUZNDKTYPE01     = "dai1zennouzndktype01";
    public static final String DAI1SBJIUKTGK01          = "dai1sbjiuktgk01";
    public static final String DAI1SBJIUKTGKTYPE01      = "dai1sbjiuktgktype01";
    public static final String DAI1SBJIUKTGKYENDAKA01   = "dai1sbjiuktgkyendaka01";
    public static final String DAI1SBJIUKTGKYENKIJYUN01 = "dai1sbjiuktgkyenkijyun01";
    public static final String DAI1SBJIUKTGKYENYASU01   = "dai1sbjiuktgkyenyasu01";
    public static final String DAI1ZENNOUZNDK02         = "dai1zennouzndk02";
    public static final String DAI1ZENNOUZNDKTYPE02     = "dai1zennouzndktype02";
    public static final String DAI1SBJIUKTGK02          = "dai1sbjiuktgk02";
    public static final String DAI1SBJIUKTGKTYPE02      = "dai1sbjiuktgktype02";
    public static final String DAI1SBJIUKTGKYENDAKA02   = "dai1sbjiuktgkyendaka02";
    public static final String DAI1SBJIUKTGKYENKIJYUN02 = "dai1sbjiuktgkyenkijyun02";
    public static final String DAI1SBJIUKTGKYENYASU02   = "dai1sbjiuktgkyenyasu02";
    public static final String DAI1ZENNOUZNDK03         = "dai1zennouzndk03";
    public static final String DAI1ZENNOUZNDKTYPE03     = "dai1zennouzndktype03";
    public static final String DAI1SBJIUKTGK03          = "dai1sbjiuktgk03";
    public static final String DAI1SBJIUKTGKTYPE03      = "dai1sbjiuktgktype03";
    public static final String DAI1SBJIUKTGKYENDAKA03   = "dai1sbjiuktgkyendaka03";
    public static final String DAI1SBJIUKTGKYENKIJYUN03 = "dai1sbjiuktgkyenkijyun03";
    public static final String DAI1SBJIUKTGKYENYASU03   = "dai1sbjiuktgkyenyasu03";
    public static final String DAI1ZENNOUZNDK04         = "dai1zennouzndk04";
    public static final String DAI1ZENNOUZNDKTYPE04     = "dai1zennouzndktype04";
    public static final String DAI1SBJIUKTGK04          = "dai1sbjiuktgk04";
    public static final String DAI1SBJIUKTGKTYPE04      = "dai1sbjiuktgktype04";
    public static final String DAI1SBJIUKTGKYENDAKA04   = "dai1sbjiuktgkyendaka04";
    public static final String DAI1SBJIUKTGKYENKIJYUN04 = "dai1sbjiuktgkyenkijyun04";
    public static final String DAI1SBJIUKTGKYENYASU04   = "dai1sbjiuktgkyenyasu04";
    public static final String DAI1ZENNOUZNDK05         = "dai1zennouzndk05";
    public static final String DAI1ZENNOUZNDKTYPE05     = "dai1zennouzndktype05";
    public static final String DAI1SBJIUKTGK05          = "dai1sbjiuktgk05";
    public static final String DAI1SBJIUKTGKTYPE05      = "dai1sbjiuktgktype05";
    public static final String DAI1SBJIUKTGKYENDAKA05   = "dai1sbjiuktgkyendaka05";
    public static final String DAI1SBJIUKTGKYENKIJYUN05 = "dai1sbjiuktgkyenkijyun05";
    public static final String DAI1SBJIUKTGKYENYASU05   = "dai1sbjiuktgkyenyasu05";
    public static final String DAI1ZENNOUZNDK06         = "dai1zennouzndk06";
    public static final String DAI1ZENNOUZNDKTYPE06     = "dai1zennouzndktype06";
    public static final String DAI1SBJIUKTGK06          = "dai1sbjiuktgk06";
    public static final String DAI1SBJIUKTGKTYPE06      = "dai1sbjiuktgktype06";
    public static final String DAI1SBJIUKTGKYENDAKA06   = "dai1sbjiuktgkyendaka06";
    public static final String DAI1SBJIUKTGKYENKIJYUN06 = "dai1sbjiuktgkyenkijyun06";
    public static final String DAI1SBJIUKTGKYENYASU06   = "dai1sbjiuktgkyenyasu06";
    public static final String KAIGOMAEHRJRUGKYDAKA01   = "kaigomaehrjrugkydaka01";
    public static final String KAIGOMAEHRJRUGKYDAKA02   = "kaigomaehrjrugkydaka02";
    public static final String KAIGOMAEHRJRUGKYDAKA03   = "kaigomaehrjrugkydaka03";
    public static final String KAIGOMAEHRJRUGKYDAKA04   = "kaigomaehrjrugkydaka04";
    public static final String KAIGOMAEHRJRUGKYDAKA05   = "kaigomaehrjrugkydaka05";
    public static final String KAIGOMAEHRJRUGKYDAKA06   = "kaigomaehrjrugkydaka06";
    public static final String KAIGOMAEHRJRUGKYDAKA07   = "kaigomaehrjrugkydaka07";
    public static final String KAIGOMAEHRJRUGKYDAKA08   = "kaigomaehrjrugkydaka08";
    public static final String KAIGOMAEHRJRUGKYDAKA09   = "kaigomaehrjrugkydaka09";
    public static final String KAIGOMAEHRJRUGKYDAKA10   = "kaigomaehrjrugkydaka10";
    public static final String KAIGOMAEHRJRUGKYKIJYUN01 = "kaigomaehrjrugkykijyun01";
    public static final String KAIGOMAEHRJRUGKYKIJYUN02 = "kaigomaehrjrugkykijyun02";
    public static final String KAIGOMAEHRJRUGKYKIJYUN03 = "kaigomaehrjrugkykijyun03";
    public static final String KAIGOMAEHRJRUGKYKIJYUN04 = "kaigomaehrjrugkykijyun04";
    public static final String KAIGOMAEHRJRUGKYKIJYUN05 = "kaigomaehrjrugkykijyun05";
    public static final String KAIGOMAEHRJRUGKYKIJYUN06 = "kaigomaehrjrugkykijyun06";
    public static final String KAIGOMAEHRJRUGKYKIJYUN07 = "kaigomaehrjrugkykijyun07";
    public static final String KAIGOMAEHRJRUGKYKIJYUN08 = "kaigomaehrjrugkykijyun08";
    public static final String KAIGOMAEHRJRUGKYKIJYUN09 = "kaigomaehrjrugkykijyun09";
    public static final String KAIGOMAEHRJRUGKYKIJYUN10 = "kaigomaehrjrugkykijyun10";
    public static final String KAIGOMAEHRJRUGKYYASU01   = "kaigomaehrjrugkyyasu01";
    public static final String KAIGOMAEHRJRUGKYYASU02   = "kaigomaehrjrugkyyasu02";
    public static final String KAIGOMAEHRJRUGKYYASU03   = "kaigomaehrjrugkyyasu03";
    public static final String KAIGOMAEHRJRUGKYYASU04   = "kaigomaehrjrugkyyasu04";
    public static final String KAIGOMAEHRJRUGKYYASU05   = "kaigomaehrjrugkyyasu05";
    public static final String KAIGOMAEHRJRUGKYYASU06   = "kaigomaehrjrugkyyasu06";
    public static final String KAIGOMAEHRJRUGKYYASU07   = "kaigomaehrjrugkyyasu07";
    public static final String KAIGOMAEHRJRUGKYYASU08   = "kaigomaehrjrugkyyasu08";
    public static final String KAIGOMAEHRJRUGKYYASU09   = "kaigomaehrjrugkyyasu09";
    public static final String KAIGOMAEHRJRUGKYYASU10   = "kaigomaehrjrugkyyasu10";

    private final PKIT_BAK_HokenSyoukenHukaInfo primaryKey;

    public GenIT_BAK_HokenSyoukenHukaInfo() {
        primaryKey = new PKIT_BAK_HokenSyoukenHukaInfo();
    }

    public GenIT_BAK_HokenSyoukenHukaInfo(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        BizDate pTyouhyouymd
    ) {
        primaryKey = new PKIT_BAK_HokenSyoukenHukaInfo(
            pKbnkey,
            pSyono,
            pTrkssikibetukey,
            pTyouhyouymd
        );
    }

    @Transient
    @Override
    public PKIT_BAK_HokenSyoukenHukaInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_HokenSyoukenHukaInfo> getMetaClass() {
        return QIT_BAK_HokenSyoukenHukaInfo.class;
    }

    @Id
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.SYONO)
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
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.TYOUHYOUYMD)
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

    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

    private String nksyuruinmsyouken;

    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.NKSYURUINMSYOUKEN)
    public String getNksyuruinmsyouken() {
        return nksyuruinmsyouken;
    }

    public void setNksyuruinmsyouken(String pNksyuruinmsyouken) {
        nksyuruinmsyouken = pNksyuruinmsyouken;
    }

    private Integer teikiikkatubaraitukisuu;

    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.TEIKIIKKATUBARAITUKISUU)
    public Integer getTeikiikkatubaraitukisuu() {
        return teikiikkatubaraitukisuu;
    }

    public void setTeikiikkatubaraitukisuu(Integer pTeikiikkatubaraitukisuu) {
        teikiikkatubaraitukisuu = pTeikiikkatubaraitukisuu;
    }

    private C_Tuukasyu znntikiktbriyhrkgktuktype;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.ZNNTIKIKTBRIYHRKGKTUKTYPE)
    public C_Tuukasyu getZnntikiktbriyhrkgktuktype() {
        return znntikiktbriyhrkgktuktype;
    }

    public void setZnntikiktbriyhrkgktuktype(C_Tuukasyu pZnntikiktbriyhrkgktuktype) {
        znntikiktbriyhrkgktuktype = pZnntikiktbriyhrkgktuktype;
    }

    private BizCurrency znntikiktbriyenhrkgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZnntikiktbriyenhrkgk() {
        return znntikiktbriyenhrkgk;
    }

    public void setZnntikiktbriyenhrkgk(BizCurrency pZnntikiktbriyenhrkgk) {
        znntikiktbriyenhrkgk = pZnntikiktbriyenhrkgk;
        znntikiktbriyenhrkgkValue = null;
        znntikiktbriyenhrkgkType  = null;
    }

    transient private BigDecimal znntikiktbriyenhrkgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZNNTIKIKTBRIYENHRKGK, nullable=true)
    protected BigDecimal getZnntikiktbriyenhrkgkValue() {
        if (znntikiktbriyenhrkgkValue == null && znntikiktbriyenhrkgk != null) {
            if (znntikiktbriyenhrkgk.isOptional()) return null;
            return znntikiktbriyenhrkgk.absolute();
        }
        return znntikiktbriyenhrkgkValue;
    }

    protected void setZnntikiktbriyenhrkgkValue(BigDecimal value) {
        znntikiktbriyenhrkgkValue = value;
        znntikiktbriyenhrkgk = Optional.fromNullable(toCurrencyType(znntikiktbriyenhrkgkType))
            .transform(bizCurrencyTransformer(getZnntikiktbriyenhrkgkValue()))
            .orNull();
    }

    transient private String znntikiktbriyenhrkgkType = null;

    @Column(name=ZNNTIKIKTBRIYENHRKGK + "$", nullable=true)
    protected String getZnntikiktbriyenhrkgkType() {
        if (znntikiktbriyenhrkgkType == null && znntikiktbriyenhrkgk != null) return znntikiktbriyenhrkgk.getType().toString();
        if (znntikiktbriyenhrkgkType == null && getZnntikiktbriyenhrkgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'znntikiktbriyenhrkgk$' should not be NULL."));
        }
        return znntikiktbriyenhrkgkType;
    }

    protected void setZnntikiktbriyenhrkgkType(String type) {
        znntikiktbriyenhrkgkType = type;
        znntikiktbriyenhrkgk = Optional.fromNullable(toCurrencyType(znntikiktbriyenhrkgkType))
            .transform(bizCurrencyTransformer(getZnntikiktbriyenhrkgkValue()))
            .orNull();
    }

    private Integer znnkai2;

    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.ZNNKAI2)
    public Integer getZnnkai2() {
        return znnkai2;
    }

    public void setZnnkai2(Integer pZnnkai2) {
        znnkai2 = pZnnkai2;
    }

    private BizNumber hutanhiyustmkyakkjrtmin;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.HUTANHIYUSTMKYAKKJRTMIN)
    public BizNumber getHutanhiyustmkyakkjrtmin() {
        return hutanhiyustmkyakkjrtmin;
    }

    public void setHutanhiyustmkyakkjrtmin(BizNumber pHutanhiyustmkyakkjrtmin) {
        hutanhiyustmkyakkjrtmin = pHutanhiyustmkyakkjrtmin;
    }

    private BizNumber hutanhiyustmkyakkjrtmax;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.HUTANHIYUSTMKYAKKJRTMAX)
    public BizNumber getHutanhiyustmkyakkjrtmax() {
        return hutanhiyustmkyakkjrtmax;
    }

    public void setHutanhiyustmkyakkjrtmax(BizNumber pHutanhiyustmkyakkjrtmax) {
        hutanhiyustmkyakkjrtmax = pHutanhiyustmkyakkjrtmax;
    }

    private C_Tuukasyu fstpznnkngktuktype;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.FSTPZNNKNGKTUKTYPE)
    public C_Tuukasyu getFstpznnkngktuktype() {
        return fstpznnkngktuktype;
    }

    public void setFstpznnkngktuktype(C_Tuukasyu pFstpznnkngktuktype) {
        fstpznnkngktuktype = pFstpznnkngktuktype;
    }

    private BizCurrency fstpznnkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getFstpznnkngk() {
        return fstpznnkngk;
    }

    public void setFstpznnkngk(BizCurrency pFstpznnkngk) {
        fstpznnkngk = pFstpznnkngk;
        fstpznnkngkValue = null;
        fstpznnkngkType  = null;
    }

    transient private BigDecimal fstpznnkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=FSTPZNNKNGK, nullable=true)
    protected BigDecimal getFstpznnkngkValue() {
        if (fstpznnkngkValue == null && fstpznnkngk != null) {
            if (fstpznnkngk.isOptional()) return null;
            return fstpznnkngk.absolute();
        }
        return fstpznnkngkValue;
    }

    protected void setFstpznnkngkValue(BigDecimal value) {
        fstpznnkngkValue = value;
        fstpznnkngk = Optional.fromNullable(toCurrencyType(fstpznnkngkType))
            .transform(bizCurrencyTransformer(getFstpznnkngkValue()))
            .orNull();
    }

    transient private String fstpznnkngkType = null;

    @Column(name=FSTPZNNKNGK + "$", nullable=true)
    protected String getFstpznnkngkType() {
        if (fstpznnkngkType == null && fstpznnkngk != null) return fstpznnkngk.getType().toString();
        if (fstpznnkngkType == null && getFstpznnkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'fstpznnkngk$' should not be NULL."));
        }
        return fstpznnkngkType;
    }

    protected void setFstpznnkngkType(String type) {
        fstpznnkngkType = type;
        fstpznnkngk = Optional.fromNullable(toCurrencyType(fstpznnkngkType))
            .transform(bizCurrencyTransformer(getFstpznnkngkValue()))
            .orNull();
    }

    private C_Tuukasyu dskjnkngkktuktype;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.DSKJNKNGKKTUKTYPE)
    public C_Tuukasyu getDskjnkngkktuktype() {
        return dskjnkngkktuktype;
    }

    public void setDskjnkngkktuktype(C_Tuukasyu pDskjnkngkktuktype) {
        dskjnkngkktuktype = pDskjnkngkktuktype;
    }

    private BizCurrency dskjnkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDskjnkngk() {
        return dskjnkngk;
    }

    public void setDskjnkngk(BizCurrency pDskjnkngk) {
        dskjnkngk = pDskjnkngk;
        dskjnkngkValue = null;
        dskjnkngkType  = null;
    }

    transient private BigDecimal dskjnkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=DSKJNKNGK, nullable=true)
    protected BigDecimal getDskjnkngkValue() {
        if (dskjnkngkValue == null && dskjnkngk != null) {
            if (dskjnkngk.isOptional()) return null;
            return dskjnkngk.absolute();
        }
        return dskjnkngkValue;
    }

    protected void setDskjnkngkValue(BigDecimal value) {
        dskjnkngkValue = value;
        dskjnkngk = Optional.fromNullable(toCurrencyType(dskjnkngkType))
            .transform(bizCurrencyTransformer(getDskjnkngkValue()))
            .orNull();
    }

    transient private String dskjnkngkType = null;

    @Column(name=DSKJNKNGK + "$", nullable=true)
    protected String getDskjnkngkType() {
        if (dskjnkngkType == null && dskjnkngk != null) return dskjnkngk.getType().toString();
        if (dskjnkngkType == null && getDskjnkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dskjnkngk$' should not be NULL."));
        }
        return dskjnkngkType;
    }

    protected void setDskjnkngkType(String type) {
        dskjnkngkType = type;
        dskjnkngk = Optional.fromNullable(toCurrencyType(dskjnkngkType))
            .transform(bizCurrencyTransformer(getDskjnkngkValue()))
            .orNull();
    }

    private C_Tuukasyu tikiktbriyhrkgktuktype;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.TIKIKTBRIYHRKGKTUKTYPE)
    public C_Tuukasyu getTikiktbriyhrkgktuktype() {
        return tikiktbriyhrkgktuktype;
    }

    public void setTikiktbriyhrkgktuktype(C_Tuukasyu pTikiktbriyhrkgktuktype) {
        tikiktbriyhrkgktuktype = pTikiktbriyhrkgktuktype;
    }

    private BizCurrency tikiktbriyenhrkgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTikiktbriyenhrkgk() {
        return tikiktbriyenhrkgk;
    }

    public void setTikiktbriyenhrkgk(BizCurrency pTikiktbriyenhrkgk) {
        tikiktbriyenhrkgk = pTikiktbriyenhrkgk;
        tikiktbriyenhrkgkValue = null;
        tikiktbriyenhrkgkType  = null;
    }

    transient private BigDecimal tikiktbriyenhrkgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TIKIKTBRIYENHRKGK, nullable=true)
    protected BigDecimal getTikiktbriyenhrkgkValue() {
        if (tikiktbriyenhrkgkValue == null && tikiktbriyenhrkgk != null) {
            if (tikiktbriyenhrkgk.isOptional()) return null;
            return tikiktbriyenhrkgk.absolute();
        }
        return tikiktbriyenhrkgkValue;
    }

    protected void setTikiktbriyenhrkgkValue(BigDecimal value) {
        tikiktbriyenhrkgkValue = value;
        tikiktbriyenhrkgk = Optional.fromNullable(toCurrencyType(tikiktbriyenhrkgkType))
            .transform(bizCurrencyTransformer(getTikiktbriyenhrkgkValue()))
            .orNull();
    }

    transient private String tikiktbriyenhrkgkType = null;

    @Column(name=TIKIKTBRIYENHRKGK + "$", nullable=true)
    protected String getTikiktbriyenhrkgkType() {
        if (tikiktbriyenhrkgkType == null && tikiktbriyenhrkgk != null) return tikiktbriyenhrkgk.getType().toString();
        if (tikiktbriyenhrkgkType == null && getTikiktbriyenhrkgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tikiktbriyenhrkgk$' should not be NULL."));
        }
        return tikiktbriyenhrkgkType;
    }

    protected void setTikiktbriyenhrkgkType(String type) {
        tikiktbriyenhrkgkType = type;
        tikiktbriyenhrkgk = Optional.fromNullable(toCurrencyType(tikiktbriyenhrkgkType))
            .transform(bizCurrencyTransformer(getTikiktbriyenhrkgkValue()))
            .orNull();
    }

    private C_UmuKbn kzktirasidouhuukbn1;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.KZKTIRASIDOUHUUKBN1)
    public C_UmuKbn getKzktirasidouhuukbn1() {
        return kzktirasidouhuukbn1;
    }

    public void setKzktirasidouhuukbn1(C_UmuKbn pKzktirasidouhuukbn1) {
        kzktirasidouhuukbn1 = pKzktirasidouhuukbn1;
    }

    private C_UmuKbn kzktirasidouhuukbn2;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.KZKTIRASIDOUHUUKBN2)
    public C_UmuKbn getKzktirasidouhuukbn2() {
        return kzktirasidouhuukbn2;
    }

    public void setKzktirasidouhuukbn2(C_UmuKbn pKzktirasidouhuukbn2) {
        kzktirasidouhuukbn2 = pKzktirasidouhuukbn2;
    }

    private C_UmuKbn kykdairitirasidouhuukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.KYKDAIRITIRASIDOUHUUKBN)
    public C_UmuKbn getKykdairitirasidouhuukbn() {
        return kykdairitirasidouhuukbn;
    }

    public void setKykdairitirasidouhuukbn(C_UmuKbn pKykdairitirasidouhuukbn) {
        kykdairitirasidouhuukbn = pKykdairitirasidouhuukbn;
    }

    private C_UmuKbn skhtirasidouhuukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.SKHTIRASIDOUHUUKBN)
    public C_UmuKbn getSkhtirasidouhuukbn() {
        return skhtirasidouhuukbn;
    }

    public void setSkhtirasidouhuukbn(C_UmuKbn pSkhtirasidouhuukbn) {
        skhtirasidouhuukbn = pSkhtirasidouhuukbn;
    }

    private String yakkannewoldkbn;

    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.YAKKANNEWOLDKBN)
    public String getYakkannewoldkbn() {
        return yakkannewoldkbn;
    }

    public void setYakkannewoldkbn(String pYakkannewoldkbn) {
        yakkannewoldkbn = pYakkannewoldkbn;
    }

    private String kzktourokuservicemsg1;

    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.KZKTOUROKUSERVICEMSG1)
    public String getKzktourokuservicemsg1() {
        return kzktourokuservicemsg1;
    }

    public void setKzktourokuservicemsg1(String pKzktourokuservicemsg1) {
        kzktourokuservicemsg1 = pKzktourokuservicemsg1;
    }

    private String kzktourokuservicemsg2;

    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.KZKTOUROKUSERVICEMSG2)
    public String getKzktourokuservicemsg2() {
        return kzktourokuservicemsg2;
    }

    public void setKzktourokuservicemsg2(String pKzktourokuservicemsg2) {
        kzktourokuservicemsg2 = pKzktourokuservicemsg2;
    }

    private String kzktourokuservicemsg3;

    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.KZKTOUROKUSERVICEMSG3)
    public String getKzktourokuservicemsg3() {
        return kzktourokuservicemsg3;
    }

    public void setKzktourokuservicemsg3(String pKzktourokuservicemsg3) {
        kzktourokuservicemsg3 = pKzktourokuservicemsg3;
    }

    private String kzktourokuservicemsg4;

    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.KZKTOUROKUSERVICEMSG4)
    public String getKzktourokuservicemsg4() {
        return kzktourokuservicemsg4;
    }

    public void setKzktourokuservicemsg4(String pKzktourokuservicemsg4) {
        kzktourokuservicemsg4 = pKzktourokuservicemsg4;
    }

    private String kzktourokuservicemsg5;

    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.KZKTOUROKUSERVICEMSG5)
    public String getKzktourokuservicemsg5() {
        return kzktourokuservicemsg5;
    }

    public void setKzktourokuservicemsg5(String pKzktourokuservicemsg5) {
        kzktourokuservicemsg5 = pKzktourokuservicemsg5;
    }

    private String kzktourokuservicemsg6;

    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.KZKTOUROKUSERVICEMSG6)
    public String getKzktourokuservicemsg6() {
        return kzktourokuservicemsg6;
    }

    public void setKzktourokuservicemsg6(String pKzktourokuservicemsg6) {
        kzktourokuservicemsg6 = pKzktourokuservicemsg6;
    }

    private String kzktourokuservicemsg7;

    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.KZKTOUROKUSERVICEMSG7)
    public String getKzktourokuservicemsg7() {
        return kzktourokuservicemsg7;
    }

    public void setKzktourokuservicemsg7(String pKzktourokuservicemsg7) {
        kzktourokuservicemsg7 = pKzktourokuservicemsg7;
    }

    private String kzktourokuservicemsg8;

    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.KZKTOUROKUSERVICEMSG8)
    public String getKzktourokuservicemsg8() {
        return kzktourokuservicemsg8;
    }

    public void setKzktourokuservicemsg8(String pKzktourokuservicemsg8) {
        kzktourokuservicemsg8 = pKzktourokuservicemsg8;
    }

    private String trkkzknmkj118;

    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.TRKKZKNMKJ118)
    public String getTrkkzknmkj118() {
        return trkkzknmkj118;
    }

    public void setTrkkzknmkj118(String pTrkkzknmkj118) {
        trkkzknmkj118 = pTrkkzknmkj118;
    }

    private C_Seibetu trkkzksei1;

    @Type(type="UserType_C_Seibetu")
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.TRKKZKSEI1)
    public C_Seibetu getTrkkzksei1() {
        return trkkzksei1;
    }

    public void setTrkkzksei1(C_Seibetu pTrkkzksei1) {
        trkkzksei1 = pTrkkzksei1;
    }

    private BizDate trkkzkseiymd1;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.TRKKZKSEIYMD1)
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

    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.TRKKZKYNO1)
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

    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.TRKKZKADR1KJ1)
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

    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.TRKKZKADR2KJ1)
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

    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.TRKKZKADR3KJ1)
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

    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.TRKKZKTELNO1)
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

    private C_Seibetu trkkzksei2;

    @Type(type="UserType_C_Seibetu")
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.TRKKZKSEI2)
    public C_Seibetu getTrkkzksei2() {
        return trkkzksei2;
    }

    public void setTrkkzksei2(C_Seibetu pTrkkzksei2) {
        trkkzksei2 = pTrkkzksei2;
    }

    private String trkkzknmkj218;

    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.TRKKZKNMKJ218)
    public String getTrkkzknmkj218() {
        return trkkzknmkj218;
    }

    public void setTrkkzknmkj218(String pTrkkzknmkj218) {
        trkkzknmkj218 = pTrkkzknmkj218;
    }

    private BizDate trkkzkseiymd2;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.TRKKZKSEIYMD2)
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

    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.TRKKZKYNO2)
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

    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.TRKKZKADR1KJ2)
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

    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.TRKKZKADR2KJ2)
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

    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.TRKKZKADR3KJ2)
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

    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.TRKKZKTELNO2)
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

    private String kykdairinm18;

    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.KYKDAIRINM18)
    public String getKykdairinm18() {
        return kykdairinm18;
    }

    public void setKykdairinm18(String pKykdairinm18) {
        kykdairinm18 = pKykdairinm18;
    }

    private String hhkndairinm;

    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.HHKNDAIRINM)
    public String getHhkndairinm() {
        return hhkndairinm;
    }

    public void setHhkndairinm(String pHhkndairinm) {
        hhkndairinm = pHhkndairinm;
    }

    private BizNumber rendouritu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.RENDOURITU)
    public BizNumber getRendouritu() {
        return rendouritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setRendouritu(BizNumber pRendouritu) {
        rendouritu = pRendouritu;
    }

    private BizCurrency teikisiharaikin;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTeikisiharaikin() {
        return teikisiharaikin;
    }

    public void setTeikisiharaikin(BizCurrency pTeikisiharaikin) {
        teikisiharaikin = pTeikisiharaikin;
        teikisiharaikinValue = null;
        teikisiharaikinType  = null;
    }

    transient private BigDecimal teikisiharaikinValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TEIKISIHARAIKIN, nullable=true)
    protected BigDecimal getTeikisiharaikinValue() {
        if (teikisiharaikinValue == null && teikisiharaikin != null) {
            if (teikisiharaikin.isOptional()) return null;
            return teikisiharaikin.absolute();
        }
        return teikisiharaikinValue;
    }

    protected void setTeikisiharaikinValue(BigDecimal value) {
        teikisiharaikinValue = value;
        teikisiharaikin = Optional.fromNullable(toCurrencyType(teikisiharaikinType))
            .transform(bizCurrencyTransformer(getTeikisiharaikinValue()))
            .orNull();
    }

    transient private String teikisiharaikinType = null;

    @Column(name=TEIKISIHARAIKIN + "$", nullable=true)
    protected String getTeikisiharaikinType() {
        if (teikisiharaikinType == null && teikisiharaikin != null) return teikisiharaikin.getType().toString();
        if (teikisiharaikinType == null && getTeikisiharaikinValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'teikisiharaikin$' should not be NULL."));
        }
        return teikisiharaikinType;
    }

    protected void setTeikisiharaikinType(String type) {
        teikisiharaikinType = type;
        teikisiharaikin = Optional.fromNullable(toCurrencyType(teikisiharaikinType))
            .transform(bizCurrencyTransformer(getTeikisiharaikinValue()))
            .orNull();
    }

    private C_Tuukasyu dai1sbjiuktgkyentype;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.DAI1SBJIUKTGKYENTYPE)
    public C_Tuukasyu getDai1sbjiuktgkyentype() {
        return dai1sbjiuktgkyentype;
    }

    public void setDai1sbjiuktgkyentype(C_Tuukasyu pDai1sbjiuktgkyentype) {
        dai1sbjiuktgkyentype = pDai1sbjiuktgkyentype;
    }

    private BizCurrency dai1zennouzndk01;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1zennouzndk01() {
        return dai1zennouzndk01;
    }

    public void setDai1zennouzndk01(BizCurrency pDai1zennouzndk01) {
        dai1zennouzndk01 = pDai1zennouzndk01;
        dai1zennouzndk01Value = null;
        dai1zennouzndk01Type  = null;
    }

    transient private BigDecimal dai1zennouzndk01Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1ZENNOUZNDK01, nullable=true)
    protected BigDecimal getDai1zennouzndk01Value() {
        if (dai1zennouzndk01Value == null && dai1zennouzndk01 != null) {
            if (dai1zennouzndk01.isOptional()) return null;
            return dai1zennouzndk01.absolute();
        }
        return dai1zennouzndk01Value;
    }

    protected void setDai1zennouzndk01Value(BigDecimal value) {
        dai1zennouzndk01Value = value;
        dai1zennouzndk01 = Optional.fromNullable(toCurrencyType(dai1zennouzndk01Type))
            .transform(bizCurrencyTransformer(getDai1zennouzndk01Value()))
            .orNull();
    }

    transient private String dai1zennouzndk01Type = null;

    @Column(name=DAI1ZENNOUZNDK01 + "$", nullable=true)
    protected String getDai1zennouzndk01Type() {
        if (dai1zennouzndk01Type == null && dai1zennouzndk01 != null) return dai1zennouzndk01.getType().toString();
        if (dai1zennouzndk01Type == null && getDai1zennouzndk01Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1zennouzndk01$' should not be NULL."));
        }
        return dai1zennouzndk01Type;
    }

    protected void setDai1zennouzndk01Type(String type) {
        dai1zennouzndk01Type = type;
        dai1zennouzndk01 = Optional.fromNullable(toCurrencyType(dai1zennouzndk01Type))
            .transform(bizCurrencyTransformer(getDai1zennouzndk01Value()))
            .orNull();
    }

    private C_Tuukasyu dai1zennouzndktype01;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.DAI1ZENNOUZNDKTYPE01)
    public C_Tuukasyu getDai1zennouzndktype01() {
        return dai1zennouzndktype01;
    }

    public void setDai1zennouzndktype01(C_Tuukasyu pDai1zennouzndktype01) {
        dai1zennouzndktype01 = pDai1zennouzndktype01;
    }

    private BizCurrency dai1sbjiuktgk01;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1sbjiuktgk01() {
        return dai1sbjiuktgk01;
    }

    public void setDai1sbjiuktgk01(BizCurrency pDai1sbjiuktgk01) {
        dai1sbjiuktgk01 = pDai1sbjiuktgk01;
        dai1sbjiuktgk01Value = null;
        dai1sbjiuktgk01Type  = null;
    }

    transient private BigDecimal dai1sbjiuktgk01Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SBJIUKTGK01, nullable=true)
    protected BigDecimal getDai1sbjiuktgk01Value() {
        if (dai1sbjiuktgk01Value == null && dai1sbjiuktgk01 != null) {
            if (dai1sbjiuktgk01.isOptional()) return null;
            return dai1sbjiuktgk01.absolute();
        }
        return dai1sbjiuktgk01Value;
    }

    protected void setDai1sbjiuktgk01Value(BigDecimal value) {
        dai1sbjiuktgk01Value = value;
        dai1sbjiuktgk01 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgk01Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgk01Value()))
            .orNull();
    }

    transient private String dai1sbjiuktgk01Type = null;

    @Column(name=DAI1SBJIUKTGK01 + "$", nullable=true)
    protected String getDai1sbjiuktgk01Type() {
        if (dai1sbjiuktgk01Type == null && dai1sbjiuktgk01 != null) return dai1sbjiuktgk01.getType().toString();
        if (dai1sbjiuktgk01Type == null && getDai1sbjiuktgk01Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1sbjiuktgk01$' should not be NULL."));
        }
        return dai1sbjiuktgk01Type;
    }

    protected void setDai1sbjiuktgk01Type(String type) {
        dai1sbjiuktgk01Type = type;
        dai1sbjiuktgk01 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgk01Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgk01Value()))
            .orNull();
    }

    private C_Tuukasyu dai1sbjiuktgktype01;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.DAI1SBJIUKTGKTYPE01)
    public C_Tuukasyu getDai1sbjiuktgktype01() {
        return dai1sbjiuktgktype01;
    }

    public void setDai1sbjiuktgktype01(C_Tuukasyu pDai1sbjiuktgktype01) {
        dai1sbjiuktgktype01 = pDai1sbjiuktgktype01;
    }

    private BizCurrency dai1sbjiuktgkyendaka01;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1sbjiuktgkyendaka01() {
        return dai1sbjiuktgkyendaka01;
    }

    public void setDai1sbjiuktgkyendaka01(BizCurrency pDai1sbjiuktgkyendaka01) {
        dai1sbjiuktgkyendaka01 = pDai1sbjiuktgkyendaka01;
        dai1sbjiuktgkyendaka01Value = null;
        dai1sbjiuktgkyendaka01Type  = null;
    }

    transient private BigDecimal dai1sbjiuktgkyendaka01Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SBJIUKTGKYENDAKA01, nullable=true)
    protected BigDecimal getDai1sbjiuktgkyendaka01Value() {
        if (dai1sbjiuktgkyendaka01Value == null && dai1sbjiuktgkyendaka01 != null) {
            if (dai1sbjiuktgkyendaka01.isOptional()) return null;
            return dai1sbjiuktgkyendaka01.absolute();
        }
        return dai1sbjiuktgkyendaka01Value;
    }

    protected void setDai1sbjiuktgkyendaka01Value(BigDecimal value) {
        dai1sbjiuktgkyendaka01Value = value;
        dai1sbjiuktgkyendaka01 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyendaka01Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyendaka01Value()))
            .orNull();
    }

    transient private String dai1sbjiuktgkyendaka01Type = null;

    @Column(name=DAI1SBJIUKTGKYENDAKA01 + "$", nullable=true)
    protected String getDai1sbjiuktgkyendaka01Type() {
        if (dai1sbjiuktgkyendaka01Type == null && dai1sbjiuktgkyendaka01 != null) return dai1sbjiuktgkyendaka01.getType().toString();
        if (dai1sbjiuktgkyendaka01Type == null && getDai1sbjiuktgkyendaka01Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1sbjiuktgkyendaka01$' should not be NULL."));
        }
        return dai1sbjiuktgkyendaka01Type;
    }

    protected void setDai1sbjiuktgkyendaka01Type(String type) {
        dai1sbjiuktgkyendaka01Type = type;
        dai1sbjiuktgkyendaka01 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyendaka01Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyendaka01Value()))
            .orNull();
    }

    private BizCurrency dai1sbjiuktgkyenkijyun01;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1sbjiuktgkyenkijyun01() {
        return dai1sbjiuktgkyenkijyun01;
    }

    public void setDai1sbjiuktgkyenkijyun01(BizCurrency pDai1sbjiuktgkyenkijyun01) {
        dai1sbjiuktgkyenkijyun01 = pDai1sbjiuktgkyenkijyun01;
        dai1sbjiuktgkyenkijyun01Value = null;
        dai1sbjiuktgkyenkijyun01Type  = null;
    }

    transient private BigDecimal dai1sbjiuktgkyenkijyun01Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SBJIUKTGKYENKIJYUN01, nullable=true)
    protected BigDecimal getDai1sbjiuktgkyenkijyun01Value() {
        if (dai1sbjiuktgkyenkijyun01Value == null && dai1sbjiuktgkyenkijyun01 != null) {
            if (dai1sbjiuktgkyenkijyun01.isOptional()) return null;
            return dai1sbjiuktgkyenkijyun01.absolute();
        }
        return dai1sbjiuktgkyenkijyun01Value;
    }

    protected void setDai1sbjiuktgkyenkijyun01Value(BigDecimal value) {
        dai1sbjiuktgkyenkijyun01Value = value;
        dai1sbjiuktgkyenkijyun01 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyenkijyun01Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyenkijyun01Value()))
            .orNull();
    }

    transient private String dai1sbjiuktgkyenkijyun01Type = null;

    @Column(name=DAI1SBJIUKTGKYENKIJYUN01 + "$", nullable=true)
    protected String getDai1sbjiuktgkyenkijyun01Type() {
        if (dai1sbjiuktgkyenkijyun01Type == null && dai1sbjiuktgkyenkijyun01 != null) return dai1sbjiuktgkyenkijyun01.getType().toString();
        if (dai1sbjiuktgkyenkijyun01Type == null && getDai1sbjiuktgkyenkijyun01Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1sbjiuktgkyenkijyun01$' should not be NULL."));
        }
        return dai1sbjiuktgkyenkijyun01Type;
    }

    protected void setDai1sbjiuktgkyenkijyun01Type(String type) {
        dai1sbjiuktgkyenkijyun01Type = type;
        dai1sbjiuktgkyenkijyun01 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyenkijyun01Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyenkijyun01Value()))
            .orNull();
    }

    private BizCurrency dai1sbjiuktgkyenyasu01;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1sbjiuktgkyenyasu01() {
        return dai1sbjiuktgkyenyasu01;
    }

    public void setDai1sbjiuktgkyenyasu01(BizCurrency pDai1sbjiuktgkyenyasu01) {
        dai1sbjiuktgkyenyasu01 = pDai1sbjiuktgkyenyasu01;
        dai1sbjiuktgkyenyasu01Value = null;
        dai1sbjiuktgkyenyasu01Type  = null;
    }

    transient private BigDecimal dai1sbjiuktgkyenyasu01Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SBJIUKTGKYENYASU01, nullable=true)
    protected BigDecimal getDai1sbjiuktgkyenyasu01Value() {
        if (dai1sbjiuktgkyenyasu01Value == null && dai1sbjiuktgkyenyasu01 != null) {
            if (dai1sbjiuktgkyenyasu01.isOptional()) return null;
            return dai1sbjiuktgkyenyasu01.absolute();
        }
        return dai1sbjiuktgkyenyasu01Value;
    }

    protected void setDai1sbjiuktgkyenyasu01Value(BigDecimal value) {
        dai1sbjiuktgkyenyasu01Value = value;
        dai1sbjiuktgkyenyasu01 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyenyasu01Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyenyasu01Value()))
            .orNull();
    }

    transient private String dai1sbjiuktgkyenyasu01Type = null;

    @Column(name=DAI1SBJIUKTGKYENYASU01 + "$", nullable=true)
    protected String getDai1sbjiuktgkyenyasu01Type() {
        if (dai1sbjiuktgkyenyasu01Type == null && dai1sbjiuktgkyenyasu01 != null) return dai1sbjiuktgkyenyasu01.getType().toString();
        if (dai1sbjiuktgkyenyasu01Type == null && getDai1sbjiuktgkyenyasu01Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1sbjiuktgkyenyasu01$' should not be NULL."));
        }
        return dai1sbjiuktgkyenyasu01Type;
    }

    protected void setDai1sbjiuktgkyenyasu01Type(String type) {
        dai1sbjiuktgkyenyasu01Type = type;
        dai1sbjiuktgkyenyasu01 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyenyasu01Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyenyasu01Value()))
            .orNull();
    }

    private BizCurrency dai1zennouzndk02;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1zennouzndk02() {
        return dai1zennouzndk02;
    }

    public void setDai1zennouzndk02(BizCurrency pDai1zennouzndk02) {
        dai1zennouzndk02 = pDai1zennouzndk02;
        dai1zennouzndk02Value = null;
        dai1zennouzndk02Type  = null;
    }

    transient private BigDecimal dai1zennouzndk02Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1ZENNOUZNDK02, nullable=true)
    protected BigDecimal getDai1zennouzndk02Value() {
        if (dai1zennouzndk02Value == null && dai1zennouzndk02 != null) {
            if (dai1zennouzndk02.isOptional()) return null;
            return dai1zennouzndk02.absolute();
        }
        return dai1zennouzndk02Value;
    }

    protected void setDai1zennouzndk02Value(BigDecimal value) {
        dai1zennouzndk02Value = value;
        dai1zennouzndk02 = Optional.fromNullable(toCurrencyType(dai1zennouzndk02Type))
            .transform(bizCurrencyTransformer(getDai1zennouzndk02Value()))
            .orNull();
    }

    transient private String dai1zennouzndk02Type = null;

    @Column(name=DAI1ZENNOUZNDK02 + "$", nullable=true)
    protected String getDai1zennouzndk02Type() {
        if (dai1zennouzndk02Type == null && dai1zennouzndk02 != null) return dai1zennouzndk02.getType().toString();
        if (dai1zennouzndk02Type == null && getDai1zennouzndk02Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1zennouzndk02$' should not be NULL."));
        }
        return dai1zennouzndk02Type;
    }

    protected void setDai1zennouzndk02Type(String type) {
        dai1zennouzndk02Type = type;
        dai1zennouzndk02 = Optional.fromNullable(toCurrencyType(dai1zennouzndk02Type))
            .transform(bizCurrencyTransformer(getDai1zennouzndk02Value()))
            .orNull();
    }

    private C_Tuukasyu dai1zennouzndktype02;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.DAI1ZENNOUZNDKTYPE02)
    public C_Tuukasyu getDai1zennouzndktype02() {
        return dai1zennouzndktype02;
    }

    public void setDai1zennouzndktype02(C_Tuukasyu pDai1zennouzndktype02) {
        dai1zennouzndktype02 = pDai1zennouzndktype02;
    }

    private BizCurrency dai1sbjiuktgk02;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1sbjiuktgk02() {
        return dai1sbjiuktgk02;
    }

    public void setDai1sbjiuktgk02(BizCurrency pDai1sbjiuktgk02) {
        dai1sbjiuktgk02 = pDai1sbjiuktgk02;
        dai1sbjiuktgk02Value = null;
        dai1sbjiuktgk02Type  = null;
    }

    transient private BigDecimal dai1sbjiuktgk02Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SBJIUKTGK02, nullable=true)
    protected BigDecimal getDai1sbjiuktgk02Value() {
        if (dai1sbjiuktgk02Value == null && dai1sbjiuktgk02 != null) {
            if (dai1sbjiuktgk02.isOptional()) return null;
            return dai1sbjiuktgk02.absolute();
        }
        return dai1sbjiuktgk02Value;
    }

    protected void setDai1sbjiuktgk02Value(BigDecimal value) {
        dai1sbjiuktgk02Value = value;
        dai1sbjiuktgk02 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgk02Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgk02Value()))
            .orNull();
    }

    transient private String dai1sbjiuktgk02Type = null;

    @Column(name=DAI1SBJIUKTGK02 + "$", nullable=true)
    protected String getDai1sbjiuktgk02Type() {
        if (dai1sbjiuktgk02Type == null && dai1sbjiuktgk02 != null) return dai1sbjiuktgk02.getType().toString();
        if (dai1sbjiuktgk02Type == null && getDai1sbjiuktgk02Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1sbjiuktgk02$' should not be NULL."));
        }
        return dai1sbjiuktgk02Type;
    }

    protected void setDai1sbjiuktgk02Type(String type) {
        dai1sbjiuktgk02Type = type;
        dai1sbjiuktgk02 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgk02Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgk02Value()))
            .orNull();
    }

    private C_Tuukasyu dai1sbjiuktgktype02;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.DAI1SBJIUKTGKTYPE02)
    public C_Tuukasyu getDai1sbjiuktgktype02() {
        return dai1sbjiuktgktype02;
    }

    public void setDai1sbjiuktgktype02(C_Tuukasyu pDai1sbjiuktgktype02) {
        dai1sbjiuktgktype02 = pDai1sbjiuktgktype02;
    }

    private BizCurrency dai1sbjiuktgkyendaka02;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1sbjiuktgkyendaka02() {
        return dai1sbjiuktgkyendaka02;
    }

    public void setDai1sbjiuktgkyendaka02(BizCurrency pDai1sbjiuktgkyendaka02) {
        dai1sbjiuktgkyendaka02 = pDai1sbjiuktgkyendaka02;
        dai1sbjiuktgkyendaka02Value = null;
        dai1sbjiuktgkyendaka02Type  = null;
    }

    transient private BigDecimal dai1sbjiuktgkyendaka02Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SBJIUKTGKYENDAKA02, nullable=true)
    protected BigDecimal getDai1sbjiuktgkyendaka02Value() {
        if (dai1sbjiuktgkyendaka02Value == null && dai1sbjiuktgkyendaka02 != null) {
            if (dai1sbjiuktgkyendaka02.isOptional()) return null;
            return dai1sbjiuktgkyendaka02.absolute();
        }
        return dai1sbjiuktgkyendaka02Value;
    }

    protected void setDai1sbjiuktgkyendaka02Value(BigDecimal value) {
        dai1sbjiuktgkyendaka02Value = value;
        dai1sbjiuktgkyendaka02 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyendaka02Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyendaka02Value()))
            .orNull();
    }

    transient private String dai1sbjiuktgkyendaka02Type = null;

    @Column(name=DAI1SBJIUKTGKYENDAKA02 + "$", nullable=true)
    protected String getDai1sbjiuktgkyendaka02Type() {
        if (dai1sbjiuktgkyendaka02Type == null && dai1sbjiuktgkyendaka02 != null) return dai1sbjiuktgkyendaka02.getType().toString();
        if (dai1sbjiuktgkyendaka02Type == null && getDai1sbjiuktgkyendaka02Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1sbjiuktgkyendaka02$' should not be NULL."));
        }
        return dai1sbjiuktgkyendaka02Type;
    }

    protected void setDai1sbjiuktgkyendaka02Type(String type) {
        dai1sbjiuktgkyendaka02Type = type;
        dai1sbjiuktgkyendaka02 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyendaka02Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyendaka02Value()))
            .orNull();
    }

    private BizCurrency dai1sbjiuktgkyenkijyun02;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1sbjiuktgkyenkijyun02() {
        return dai1sbjiuktgkyenkijyun02;
    }

    public void setDai1sbjiuktgkyenkijyun02(BizCurrency pDai1sbjiuktgkyenkijyun02) {
        dai1sbjiuktgkyenkijyun02 = pDai1sbjiuktgkyenkijyun02;
        dai1sbjiuktgkyenkijyun02Value = null;
        dai1sbjiuktgkyenkijyun02Type  = null;
    }

    transient private BigDecimal dai1sbjiuktgkyenkijyun02Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SBJIUKTGKYENKIJYUN02, nullable=true)
    protected BigDecimal getDai1sbjiuktgkyenkijyun02Value() {
        if (dai1sbjiuktgkyenkijyun02Value == null && dai1sbjiuktgkyenkijyun02 != null) {
            if (dai1sbjiuktgkyenkijyun02.isOptional()) return null;
            return dai1sbjiuktgkyenkijyun02.absolute();
        }
        return dai1sbjiuktgkyenkijyun02Value;
    }

    protected void setDai1sbjiuktgkyenkijyun02Value(BigDecimal value) {
        dai1sbjiuktgkyenkijyun02Value = value;
        dai1sbjiuktgkyenkijyun02 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyenkijyun02Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyenkijyun02Value()))
            .orNull();
    }

    transient private String dai1sbjiuktgkyenkijyun02Type = null;

    @Column(name=DAI1SBJIUKTGKYENKIJYUN02 + "$", nullable=true)
    protected String getDai1sbjiuktgkyenkijyun02Type() {
        if (dai1sbjiuktgkyenkijyun02Type == null && dai1sbjiuktgkyenkijyun02 != null) return dai1sbjiuktgkyenkijyun02.getType().toString();
        if (dai1sbjiuktgkyenkijyun02Type == null && getDai1sbjiuktgkyenkijyun02Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1sbjiuktgkyenkijyun02$' should not be NULL."));
        }
        return dai1sbjiuktgkyenkijyun02Type;
    }

    protected void setDai1sbjiuktgkyenkijyun02Type(String type) {
        dai1sbjiuktgkyenkijyun02Type = type;
        dai1sbjiuktgkyenkijyun02 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyenkijyun02Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyenkijyun02Value()))
            .orNull();
    }

    private BizCurrency dai1sbjiuktgkyenyasu02;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1sbjiuktgkyenyasu02() {
        return dai1sbjiuktgkyenyasu02;
    }

    public void setDai1sbjiuktgkyenyasu02(BizCurrency pDai1sbjiuktgkyenyasu02) {
        dai1sbjiuktgkyenyasu02 = pDai1sbjiuktgkyenyasu02;
        dai1sbjiuktgkyenyasu02Value = null;
        dai1sbjiuktgkyenyasu02Type  = null;
    }

    transient private BigDecimal dai1sbjiuktgkyenyasu02Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SBJIUKTGKYENYASU02, nullable=true)
    protected BigDecimal getDai1sbjiuktgkyenyasu02Value() {
        if (dai1sbjiuktgkyenyasu02Value == null && dai1sbjiuktgkyenyasu02 != null) {
            if (dai1sbjiuktgkyenyasu02.isOptional()) return null;
            return dai1sbjiuktgkyenyasu02.absolute();
        }
        return dai1sbjiuktgkyenyasu02Value;
    }

    protected void setDai1sbjiuktgkyenyasu02Value(BigDecimal value) {
        dai1sbjiuktgkyenyasu02Value = value;
        dai1sbjiuktgkyenyasu02 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyenyasu02Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyenyasu02Value()))
            .orNull();
    }

    transient private String dai1sbjiuktgkyenyasu02Type = null;

    @Column(name=DAI1SBJIUKTGKYENYASU02 + "$", nullable=true)
    protected String getDai1sbjiuktgkyenyasu02Type() {
        if (dai1sbjiuktgkyenyasu02Type == null && dai1sbjiuktgkyenyasu02 != null) return dai1sbjiuktgkyenyasu02.getType().toString();
        if (dai1sbjiuktgkyenyasu02Type == null && getDai1sbjiuktgkyenyasu02Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1sbjiuktgkyenyasu02$' should not be NULL."));
        }
        return dai1sbjiuktgkyenyasu02Type;
    }

    protected void setDai1sbjiuktgkyenyasu02Type(String type) {
        dai1sbjiuktgkyenyasu02Type = type;
        dai1sbjiuktgkyenyasu02 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyenyasu02Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyenyasu02Value()))
            .orNull();
    }

    private BizCurrency dai1zennouzndk03;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1zennouzndk03() {
        return dai1zennouzndk03;
    }

    public void setDai1zennouzndk03(BizCurrency pDai1zennouzndk03) {
        dai1zennouzndk03 = pDai1zennouzndk03;
        dai1zennouzndk03Value = null;
        dai1zennouzndk03Type  = null;
    }

    transient private BigDecimal dai1zennouzndk03Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1ZENNOUZNDK03, nullable=true)
    protected BigDecimal getDai1zennouzndk03Value() {
        if (dai1zennouzndk03Value == null && dai1zennouzndk03 != null) {
            if (dai1zennouzndk03.isOptional()) return null;
            return dai1zennouzndk03.absolute();
        }
        return dai1zennouzndk03Value;
    }

    protected void setDai1zennouzndk03Value(BigDecimal value) {
        dai1zennouzndk03Value = value;
        dai1zennouzndk03 = Optional.fromNullable(toCurrencyType(dai1zennouzndk03Type))
            .transform(bizCurrencyTransformer(getDai1zennouzndk03Value()))
            .orNull();
    }

    transient private String dai1zennouzndk03Type = null;

    @Column(name=DAI1ZENNOUZNDK03 + "$", nullable=true)
    protected String getDai1zennouzndk03Type() {
        if (dai1zennouzndk03Type == null && dai1zennouzndk03 != null) return dai1zennouzndk03.getType().toString();
        if (dai1zennouzndk03Type == null && getDai1zennouzndk03Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1zennouzndk03$' should not be NULL."));
        }
        return dai1zennouzndk03Type;
    }

    protected void setDai1zennouzndk03Type(String type) {
        dai1zennouzndk03Type = type;
        dai1zennouzndk03 = Optional.fromNullable(toCurrencyType(dai1zennouzndk03Type))
            .transform(bizCurrencyTransformer(getDai1zennouzndk03Value()))
            .orNull();
    }

    private C_Tuukasyu dai1zennouzndktype03;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.DAI1ZENNOUZNDKTYPE03)
    public C_Tuukasyu getDai1zennouzndktype03() {
        return dai1zennouzndktype03;
    }

    public void setDai1zennouzndktype03(C_Tuukasyu pDai1zennouzndktype03) {
        dai1zennouzndktype03 = pDai1zennouzndktype03;
    }

    private BizCurrency dai1sbjiuktgk03;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1sbjiuktgk03() {
        return dai1sbjiuktgk03;
    }

    public void setDai1sbjiuktgk03(BizCurrency pDai1sbjiuktgk03) {
        dai1sbjiuktgk03 = pDai1sbjiuktgk03;
        dai1sbjiuktgk03Value = null;
        dai1sbjiuktgk03Type  = null;
    }

    transient private BigDecimal dai1sbjiuktgk03Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SBJIUKTGK03, nullable=true)
    protected BigDecimal getDai1sbjiuktgk03Value() {
        if (dai1sbjiuktgk03Value == null && dai1sbjiuktgk03 != null) {
            if (dai1sbjiuktgk03.isOptional()) return null;
            return dai1sbjiuktgk03.absolute();
        }
        return dai1sbjiuktgk03Value;
    }

    protected void setDai1sbjiuktgk03Value(BigDecimal value) {
        dai1sbjiuktgk03Value = value;
        dai1sbjiuktgk03 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgk03Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgk03Value()))
            .orNull();
    }

    transient private String dai1sbjiuktgk03Type = null;

    @Column(name=DAI1SBJIUKTGK03 + "$", nullable=true)
    protected String getDai1sbjiuktgk03Type() {
        if (dai1sbjiuktgk03Type == null && dai1sbjiuktgk03 != null) return dai1sbjiuktgk03.getType().toString();
        if (dai1sbjiuktgk03Type == null && getDai1sbjiuktgk03Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1sbjiuktgk03$' should not be NULL."));
        }
        return dai1sbjiuktgk03Type;
    }

    protected void setDai1sbjiuktgk03Type(String type) {
        dai1sbjiuktgk03Type = type;
        dai1sbjiuktgk03 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgk03Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgk03Value()))
            .orNull();
    }

    private C_Tuukasyu dai1sbjiuktgktype03;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.DAI1SBJIUKTGKTYPE03)
    public C_Tuukasyu getDai1sbjiuktgktype03() {
        return dai1sbjiuktgktype03;
    }

    public void setDai1sbjiuktgktype03(C_Tuukasyu pDai1sbjiuktgktype03) {
        dai1sbjiuktgktype03 = pDai1sbjiuktgktype03;
    }

    private BizCurrency dai1sbjiuktgkyendaka03;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1sbjiuktgkyendaka03() {
        return dai1sbjiuktgkyendaka03;
    }

    public void setDai1sbjiuktgkyendaka03(BizCurrency pDai1sbjiuktgkyendaka03) {
        dai1sbjiuktgkyendaka03 = pDai1sbjiuktgkyendaka03;
        dai1sbjiuktgkyendaka03Value = null;
        dai1sbjiuktgkyendaka03Type  = null;
    }

    transient private BigDecimal dai1sbjiuktgkyendaka03Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SBJIUKTGKYENDAKA03, nullable=true)
    protected BigDecimal getDai1sbjiuktgkyendaka03Value() {
        if (dai1sbjiuktgkyendaka03Value == null && dai1sbjiuktgkyendaka03 != null) {
            if (dai1sbjiuktgkyendaka03.isOptional()) return null;
            return dai1sbjiuktgkyendaka03.absolute();
        }
        return dai1sbjiuktgkyendaka03Value;
    }

    protected void setDai1sbjiuktgkyendaka03Value(BigDecimal value) {
        dai1sbjiuktgkyendaka03Value = value;
        dai1sbjiuktgkyendaka03 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyendaka03Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyendaka03Value()))
            .orNull();
    }

    transient private String dai1sbjiuktgkyendaka03Type = null;

    @Column(name=DAI1SBJIUKTGKYENDAKA03 + "$", nullable=true)
    protected String getDai1sbjiuktgkyendaka03Type() {
        if (dai1sbjiuktgkyendaka03Type == null && dai1sbjiuktgkyendaka03 != null) return dai1sbjiuktgkyendaka03.getType().toString();
        if (dai1sbjiuktgkyendaka03Type == null && getDai1sbjiuktgkyendaka03Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1sbjiuktgkyendaka03$' should not be NULL."));
        }
        return dai1sbjiuktgkyendaka03Type;
    }

    protected void setDai1sbjiuktgkyendaka03Type(String type) {
        dai1sbjiuktgkyendaka03Type = type;
        dai1sbjiuktgkyendaka03 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyendaka03Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyendaka03Value()))
            .orNull();
    }

    private BizCurrency dai1sbjiuktgkyenkijyun03;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1sbjiuktgkyenkijyun03() {
        return dai1sbjiuktgkyenkijyun03;
    }

    public void setDai1sbjiuktgkyenkijyun03(BizCurrency pDai1sbjiuktgkyenkijyun03) {
        dai1sbjiuktgkyenkijyun03 = pDai1sbjiuktgkyenkijyun03;
        dai1sbjiuktgkyenkijyun03Value = null;
        dai1sbjiuktgkyenkijyun03Type  = null;
    }

    transient private BigDecimal dai1sbjiuktgkyenkijyun03Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SBJIUKTGKYENKIJYUN03, nullable=true)
    protected BigDecimal getDai1sbjiuktgkyenkijyun03Value() {
        if (dai1sbjiuktgkyenkijyun03Value == null && dai1sbjiuktgkyenkijyun03 != null) {
            if (dai1sbjiuktgkyenkijyun03.isOptional()) return null;
            return dai1sbjiuktgkyenkijyun03.absolute();
        }
        return dai1sbjiuktgkyenkijyun03Value;
    }

    protected void setDai1sbjiuktgkyenkijyun03Value(BigDecimal value) {
        dai1sbjiuktgkyenkijyun03Value = value;
        dai1sbjiuktgkyenkijyun03 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyenkijyun03Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyenkijyun03Value()))
            .orNull();
    }

    transient private String dai1sbjiuktgkyenkijyun03Type = null;

    @Column(name=DAI1SBJIUKTGKYENKIJYUN03 + "$", nullable=true)
    protected String getDai1sbjiuktgkyenkijyun03Type() {
        if (dai1sbjiuktgkyenkijyun03Type == null && dai1sbjiuktgkyenkijyun03 != null) return dai1sbjiuktgkyenkijyun03.getType().toString();
        if (dai1sbjiuktgkyenkijyun03Type == null && getDai1sbjiuktgkyenkijyun03Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1sbjiuktgkyenkijyun03$' should not be NULL."));
        }
        return dai1sbjiuktgkyenkijyun03Type;
    }

    protected void setDai1sbjiuktgkyenkijyun03Type(String type) {
        dai1sbjiuktgkyenkijyun03Type = type;
        dai1sbjiuktgkyenkijyun03 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyenkijyun03Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyenkijyun03Value()))
            .orNull();
    }

    private BizCurrency dai1sbjiuktgkyenyasu03;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1sbjiuktgkyenyasu03() {
        return dai1sbjiuktgkyenyasu03;
    }

    public void setDai1sbjiuktgkyenyasu03(BizCurrency pDai1sbjiuktgkyenyasu03) {
        dai1sbjiuktgkyenyasu03 = pDai1sbjiuktgkyenyasu03;
        dai1sbjiuktgkyenyasu03Value = null;
        dai1sbjiuktgkyenyasu03Type  = null;
    }

    transient private BigDecimal dai1sbjiuktgkyenyasu03Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SBJIUKTGKYENYASU03, nullable=true)
    protected BigDecimal getDai1sbjiuktgkyenyasu03Value() {
        if (dai1sbjiuktgkyenyasu03Value == null && dai1sbjiuktgkyenyasu03 != null) {
            if (dai1sbjiuktgkyenyasu03.isOptional()) return null;
            return dai1sbjiuktgkyenyasu03.absolute();
        }
        return dai1sbjiuktgkyenyasu03Value;
    }

    protected void setDai1sbjiuktgkyenyasu03Value(BigDecimal value) {
        dai1sbjiuktgkyenyasu03Value = value;
        dai1sbjiuktgkyenyasu03 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyenyasu03Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyenyasu03Value()))
            .orNull();
    }

    transient private String dai1sbjiuktgkyenyasu03Type = null;

    @Column(name=DAI1SBJIUKTGKYENYASU03 + "$", nullable=true)
    protected String getDai1sbjiuktgkyenyasu03Type() {
        if (dai1sbjiuktgkyenyasu03Type == null && dai1sbjiuktgkyenyasu03 != null) return dai1sbjiuktgkyenyasu03.getType().toString();
        if (dai1sbjiuktgkyenyasu03Type == null && getDai1sbjiuktgkyenyasu03Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1sbjiuktgkyenyasu03$' should not be NULL."));
        }
        return dai1sbjiuktgkyenyasu03Type;
    }

    protected void setDai1sbjiuktgkyenyasu03Type(String type) {
        dai1sbjiuktgkyenyasu03Type = type;
        dai1sbjiuktgkyenyasu03 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyenyasu03Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyenyasu03Value()))
            .orNull();
    }

    private BizCurrency dai1zennouzndk04;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1zennouzndk04() {
        return dai1zennouzndk04;
    }

    public void setDai1zennouzndk04(BizCurrency pDai1zennouzndk04) {
        dai1zennouzndk04 = pDai1zennouzndk04;
        dai1zennouzndk04Value = null;
        dai1zennouzndk04Type  = null;
    }

    transient private BigDecimal dai1zennouzndk04Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1ZENNOUZNDK04, nullable=true)
    protected BigDecimal getDai1zennouzndk04Value() {
        if (dai1zennouzndk04Value == null && dai1zennouzndk04 != null) {
            if (dai1zennouzndk04.isOptional()) return null;
            return dai1zennouzndk04.absolute();
        }
        return dai1zennouzndk04Value;
    }

    protected void setDai1zennouzndk04Value(BigDecimal value) {
        dai1zennouzndk04Value = value;
        dai1zennouzndk04 = Optional.fromNullable(toCurrencyType(dai1zennouzndk04Type))
            .transform(bizCurrencyTransformer(getDai1zennouzndk04Value()))
            .orNull();
    }

    transient private String dai1zennouzndk04Type = null;

    @Column(name=DAI1ZENNOUZNDK04 + "$", nullable=true)
    protected String getDai1zennouzndk04Type() {
        if (dai1zennouzndk04Type == null && dai1zennouzndk04 != null) return dai1zennouzndk04.getType().toString();
        if (dai1zennouzndk04Type == null && getDai1zennouzndk04Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1zennouzndk04$' should not be NULL."));
        }
        return dai1zennouzndk04Type;
    }

    protected void setDai1zennouzndk04Type(String type) {
        dai1zennouzndk04Type = type;
        dai1zennouzndk04 = Optional.fromNullable(toCurrencyType(dai1zennouzndk04Type))
            .transform(bizCurrencyTransformer(getDai1zennouzndk04Value()))
            .orNull();
    }

    private C_Tuukasyu dai1zennouzndktype04;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.DAI1ZENNOUZNDKTYPE04)
    public C_Tuukasyu getDai1zennouzndktype04() {
        return dai1zennouzndktype04;
    }

    public void setDai1zennouzndktype04(C_Tuukasyu pDai1zennouzndktype04) {
        dai1zennouzndktype04 = pDai1zennouzndktype04;
    }

    private BizCurrency dai1sbjiuktgk04;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1sbjiuktgk04() {
        return dai1sbjiuktgk04;
    }

    public void setDai1sbjiuktgk04(BizCurrency pDai1sbjiuktgk04) {
        dai1sbjiuktgk04 = pDai1sbjiuktgk04;
        dai1sbjiuktgk04Value = null;
        dai1sbjiuktgk04Type  = null;
    }

    transient private BigDecimal dai1sbjiuktgk04Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SBJIUKTGK04, nullable=true)
    protected BigDecimal getDai1sbjiuktgk04Value() {
        if (dai1sbjiuktgk04Value == null && dai1sbjiuktgk04 != null) {
            if (dai1sbjiuktgk04.isOptional()) return null;
            return dai1sbjiuktgk04.absolute();
        }
        return dai1sbjiuktgk04Value;
    }

    protected void setDai1sbjiuktgk04Value(BigDecimal value) {
        dai1sbjiuktgk04Value = value;
        dai1sbjiuktgk04 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgk04Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgk04Value()))
            .orNull();
    }

    transient private String dai1sbjiuktgk04Type = null;

    @Column(name=DAI1SBJIUKTGK04 + "$", nullable=true)
    protected String getDai1sbjiuktgk04Type() {
        if (dai1sbjiuktgk04Type == null && dai1sbjiuktgk04 != null) return dai1sbjiuktgk04.getType().toString();
        if (dai1sbjiuktgk04Type == null && getDai1sbjiuktgk04Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1sbjiuktgk04$' should not be NULL."));
        }
        return dai1sbjiuktgk04Type;
    }

    protected void setDai1sbjiuktgk04Type(String type) {
        dai1sbjiuktgk04Type = type;
        dai1sbjiuktgk04 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgk04Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgk04Value()))
            .orNull();
    }

    private C_Tuukasyu dai1sbjiuktgktype04;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.DAI1SBJIUKTGKTYPE04)
    public C_Tuukasyu getDai1sbjiuktgktype04() {
        return dai1sbjiuktgktype04;
    }

    public void setDai1sbjiuktgktype04(C_Tuukasyu pDai1sbjiuktgktype04) {
        dai1sbjiuktgktype04 = pDai1sbjiuktgktype04;
    }

    private BizCurrency dai1sbjiuktgkyendaka04;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1sbjiuktgkyendaka04() {
        return dai1sbjiuktgkyendaka04;
    }

    public void setDai1sbjiuktgkyendaka04(BizCurrency pDai1sbjiuktgkyendaka04) {
        dai1sbjiuktgkyendaka04 = pDai1sbjiuktgkyendaka04;
        dai1sbjiuktgkyendaka04Value = null;
        dai1sbjiuktgkyendaka04Type  = null;
    }

    transient private BigDecimal dai1sbjiuktgkyendaka04Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SBJIUKTGKYENDAKA04, nullable=true)
    protected BigDecimal getDai1sbjiuktgkyendaka04Value() {
        if (dai1sbjiuktgkyendaka04Value == null && dai1sbjiuktgkyendaka04 != null) {
            if (dai1sbjiuktgkyendaka04.isOptional()) return null;
            return dai1sbjiuktgkyendaka04.absolute();
        }
        return dai1sbjiuktgkyendaka04Value;
    }

    protected void setDai1sbjiuktgkyendaka04Value(BigDecimal value) {
        dai1sbjiuktgkyendaka04Value = value;
        dai1sbjiuktgkyendaka04 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyendaka04Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyendaka04Value()))
            .orNull();
    }

    transient private String dai1sbjiuktgkyendaka04Type = null;

    @Column(name=DAI1SBJIUKTGKYENDAKA04 + "$", nullable=true)
    protected String getDai1sbjiuktgkyendaka04Type() {
        if (dai1sbjiuktgkyendaka04Type == null && dai1sbjiuktgkyendaka04 != null) return dai1sbjiuktgkyendaka04.getType().toString();
        if (dai1sbjiuktgkyendaka04Type == null && getDai1sbjiuktgkyendaka04Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1sbjiuktgkyendaka04$' should not be NULL."));
        }
        return dai1sbjiuktgkyendaka04Type;
    }

    protected void setDai1sbjiuktgkyendaka04Type(String type) {
        dai1sbjiuktgkyendaka04Type = type;
        dai1sbjiuktgkyendaka04 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyendaka04Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyendaka04Value()))
            .orNull();
    }

    private BizCurrency dai1sbjiuktgkyenkijyun04;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1sbjiuktgkyenkijyun04() {
        return dai1sbjiuktgkyenkijyun04;
    }

    public void setDai1sbjiuktgkyenkijyun04(BizCurrency pDai1sbjiuktgkyenkijyun04) {
        dai1sbjiuktgkyenkijyun04 = pDai1sbjiuktgkyenkijyun04;
        dai1sbjiuktgkyenkijyun04Value = null;
        dai1sbjiuktgkyenkijyun04Type  = null;
    }

    transient private BigDecimal dai1sbjiuktgkyenkijyun04Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SBJIUKTGKYENKIJYUN04, nullable=true)
    protected BigDecimal getDai1sbjiuktgkyenkijyun04Value() {
        if (dai1sbjiuktgkyenkijyun04Value == null && dai1sbjiuktgkyenkijyun04 != null) {
            if (dai1sbjiuktgkyenkijyun04.isOptional()) return null;
            return dai1sbjiuktgkyenkijyun04.absolute();
        }
        return dai1sbjiuktgkyenkijyun04Value;
    }

    protected void setDai1sbjiuktgkyenkijyun04Value(BigDecimal value) {
        dai1sbjiuktgkyenkijyun04Value = value;
        dai1sbjiuktgkyenkijyun04 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyenkijyun04Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyenkijyun04Value()))
            .orNull();
    }

    transient private String dai1sbjiuktgkyenkijyun04Type = null;

    @Column(name=DAI1SBJIUKTGKYENKIJYUN04 + "$", nullable=true)
    protected String getDai1sbjiuktgkyenkijyun04Type() {
        if (dai1sbjiuktgkyenkijyun04Type == null && dai1sbjiuktgkyenkijyun04 != null) return dai1sbjiuktgkyenkijyun04.getType().toString();
        if (dai1sbjiuktgkyenkijyun04Type == null && getDai1sbjiuktgkyenkijyun04Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1sbjiuktgkyenkijyun04$' should not be NULL."));
        }
        return dai1sbjiuktgkyenkijyun04Type;
    }

    protected void setDai1sbjiuktgkyenkijyun04Type(String type) {
        dai1sbjiuktgkyenkijyun04Type = type;
        dai1sbjiuktgkyenkijyun04 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyenkijyun04Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyenkijyun04Value()))
            .orNull();
    }

    private BizCurrency dai1sbjiuktgkyenyasu04;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1sbjiuktgkyenyasu04() {
        return dai1sbjiuktgkyenyasu04;
    }

    public void setDai1sbjiuktgkyenyasu04(BizCurrency pDai1sbjiuktgkyenyasu04) {
        dai1sbjiuktgkyenyasu04 = pDai1sbjiuktgkyenyasu04;
        dai1sbjiuktgkyenyasu04Value = null;
        dai1sbjiuktgkyenyasu04Type  = null;
    }

    transient private BigDecimal dai1sbjiuktgkyenyasu04Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SBJIUKTGKYENYASU04, nullable=true)
    protected BigDecimal getDai1sbjiuktgkyenyasu04Value() {
        if (dai1sbjiuktgkyenyasu04Value == null && dai1sbjiuktgkyenyasu04 != null) {
            if (dai1sbjiuktgkyenyasu04.isOptional()) return null;
            return dai1sbjiuktgkyenyasu04.absolute();
        }
        return dai1sbjiuktgkyenyasu04Value;
    }

    protected void setDai1sbjiuktgkyenyasu04Value(BigDecimal value) {
        dai1sbjiuktgkyenyasu04Value = value;
        dai1sbjiuktgkyenyasu04 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyenyasu04Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyenyasu04Value()))
            .orNull();
    }

    transient private String dai1sbjiuktgkyenyasu04Type = null;

    @Column(name=DAI1SBJIUKTGKYENYASU04 + "$", nullable=true)
    protected String getDai1sbjiuktgkyenyasu04Type() {
        if (dai1sbjiuktgkyenyasu04Type == null && dai1sbjiuktgkyenyasu04 != null) return dai1sbjiuktgkyenyasu04.getType().toString();
        if (dai1sbjiuktgkyenyasu04Type == null && getDai1sbjiuktgkyenyasu04Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1sbjiuktgkyenyasu04$' should not be NULL."));
        }
        return dai1sbjiuktgkyenyasu04Type;
    }

    protected void setDai1sbjiuktgkyenyasu04Type(String type) {
        dai1sbjiuktgkyenyasu04Type = type;
        dai1sbjiuktgkyenyasu04 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyenyasu04Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyenyasu04Value()))
            .orNull();
    }

    private BizCurrency dai1zennouzndk05;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1zennouzndk05() {
        return dai1zennouzndk05;
    }

    public void setDai1zennouzndk05(BizCurrency pDai1zennouzndk05) {
        dai1zennouzndk05 = pDai1zennouzndk05;
        dai1zennouzndk05Value = null;
        dai1zennouzndk05Type  = null;
    }

    transient private BigDecimal dai1zennouzndk05Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1ZENNOUZNDK05, nullable=true)
    protected BigDecimal getDai1zennouzndk05Value() {
        if (dai1zennouzndk05Value == null && dai1zennouzndk05 != null) {
            if (dai1zennouzndk05.isOptional()) return null;
            return dai1zennouzndk05.absolute();
        }
        return dai1zennouzndk05Value;
    }

    protected void setDai1zennouzndk05Value(BigDecimal value) {
        dai1zennouzndk05Value = value;
        dai1zennouzndk05 = Optional.fromNullable(toCurrencyType(dai1zennouzndk05Type))
            .transform(bizCurrencyTransformer(getDai1zennouzndk05Value()))
            .orNull();
    }

    transient private String dai1zennouzndk05Type = null;

    @Column(name=DAI1ZENNOUZNDK05 + "$", nullable=true)
    protected String getDai1zennouzndk05Type() {
        if (dai1zennouzndk05Type == null && dai1zennouzndk05 != null) return dai1zennouzndk05.getType().toString();
        if (dai1zennouzndk05Type == null && getDai1zennouzndk05Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1zennouzndk05$' should not be NULL."));
        }
        return dai1zennouzndk05Type;
    }

    protected void setDai1zennouzndk05Type(String type) {
        dai1zennouzndk05Type = type;
        dai1zennouzndk05 = Optional.fromNullable(toCurrencyType(dai1zennouzndk05Type))
            .transform(bizCurrencyTransformer(getDai1zennouzndk05Value()))
            .orNull();
    }

    private C_Tuukasyu dai1zennouzndktype05;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.DAI1ZENNOUZNDKTYPE05)
    public C_Tuukasyu getDai1zennouzndktype05() {
        return dai1zennouzndktype05;
    }

    public void setDai1zennouzndktype05(C_Tuukasyu pDai1zennouzndktype05) {
        dai1zennouzndktype05 = pDai1zennouzndktype05;
    }

    private BizCurrency dai1sbjiuktgk05;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1sbjiuktgk05() {
        return dai1sbjiuktgk05;
    }

    public void setDai1sbjiuktgk05(BizCurrency pDai1sbjiuktgk05) {
        dai1sbjiuktgk05 = pDai1sbjiuktgk05;
        dai1sbjiuktgk05Value = null;
        dai1sbjiuktgk05Type  = null;
    }

    transient private BigDecimal dai1sbjiuktgk05Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SBJIUKTGK05, nullable=true)
    protected BigDecimal getDai1sbjiuktgk05Value() {
        if (dai1sbjiuktgk05Value == null && dai1sbjiuktgk05 != null) {
            if (dai1sbjiuktgk05.isOptional()) return null;
            return dai1sbjiuktgk05.absolute();
        }
        return dai1sbjiuktgk05Value;
    }

    protected void setDai1sbjiuktgk05Value(BigDecimal value) {
        dai1sbjiuktgk05Value = value;
        dai1sbjiuktgk05 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgk05Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgk05Value()))
            .orNull();
    }

    transient private String dai1sbjiuktgk05Type = null;

    @Column(name=DAI1SBJIUKTGK05 + "$", nullable=true)
    protected String getDai1sbjiuktgk05Type() {
        if (dai1sbjiuktgk05Type == null && dai1sbjiuktgk05 != null) return dai1sbjiuktgk05.getType().toString();
        if (dai1sbjiuktgk05Type == null && getDai1sbjiuktgk05Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1sbjiuktgk05$' should not be NULL."));
        }
        return dai1sbjiuktgk05Type;
    }

    protected void setDai1sbjiuktgk05Type(String type) {
        dai1sbjiuktgk05Type = type;
        dai1sbjiuktgk05 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgk05Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgk05Value()))
            .orNull();
    }

    private C_Tuukasyu dai1sbjiuktgktype05;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.DAI1SBJIUKTGKTYPE05)
    public C_Tuukasyu getDai1sbjiuktgktype05() {
        return dai1sbjiuktgktype05;
    }

    public void setDai1sbjiuktgktype05(C_Tuukasyu pDai1sbjiuktgktype05) {
        dai1sbjiuktgktype05 = pDai1sbjiuktgktype05;
    }

    private BizCurrency dai1sbjiuktgkyendaka05;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1sbjiuktgkyendaka05() {
        return dai1sbjiuktgkyendaka05;
    }

    public void setDai1sbjiuktgkyendaka05(BizCurrency pDai1sbjiuktgkyendaka05) {
        dai1sbjiuktgkyendaka05 = pDai1sbjiuktgkyendaka05;
        dai1sbjiuktgkyendaka05Value = null;
        dai1sbjiuktgkyendaka05Type  = null;
    }

    transient private BigDecimal dai1sbjiuktgkyendaka05Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SBJIUKTGKYENDAKA05, nullable=true)
    protected BigDecimal getDai1sbjiuktgkyendaka05Value() {
        if (dai1sbjiuktgkyendaka05Value == null && dai1sbjiuktgkyendaka05 != null) {
            if (dai1sbjiuktgkyendaka05.isOptional()) return null;
            return dai1sbjiuktgkyendaka05.absolute();
        }
        return dai1sbjiuktgkyendaka05Value;
    }

    protected void setDai1sbjiuktgkyendaka05Value(BigDecimal value) {
        dai1sbjiuktgkyendaka05Value = value;
        dai1sbjiuktgkyendaka05 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyendaka05Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyendaka05Value()))
            .orNull();
    }

    transient private String dai1sbjiuktgkyendaka05Type = null;

    @Column(name=DAI1SBJIUKTGKYENDAKA05 + "$", nullable=true)
    protected String getDai1sbjiuktgkyendaka05Type() {
        if (dai1sbjiuktgkyendaka05Type == null && dai1sbjiuktgkyendaka05 != null) return dai1sbjiuktgkyendaka05.getType().toString();
        if (dai1sbjiuktgkyendaka05Type == null && getDai1sbjiuktgkyendaka05Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1sbjiuktgkyendaka05$' should not be NULL."));
        }
        return dai1sbjiuktgkyendaka05Type;
    }

    protected void setDai1sbjiuktgkyendaka05Type(String type) {
        dai1sbjiuktgkyendaka05Type = type;
        dai1sbjiuktgkyendaka05 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyendaka05Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyendaka05Value()))
            .orNull();
    }

    private BizCurrency dai1sbjiuktgkyenkijyun05;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1sbjiuktgkyenkijyun05() {
        return dai1sbjiuktgkyenkijyun05;
    }

    public void setDai1sbjiuktgkyenkijyun05(BizCurrency pDai1sbjiuktgkyenkijyun05) {
        dai1sbjiuktgkyenkijyun05 = pDai1sbjiuktgkyenkijyun05;
        dai1sbjiuktgkyenkijyun05Value = null;
        dai1sbjiuktgkyenkijyun05Type  = null;
    }

    transient private BigDecimal dai1sbjiuktgkyenkijyun05Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SBJIUKTGKYENKIJYUN05, nullable=true)
    protected BigDecimal getDai1sbjiuktgkyenkijyun05Value() {
        if (dai1sbjiuktgkyenkijyun05Value == null && dai1sbjiuktgkyenkijyun05 != null) {
            if (dai1sbjiuktgkyenkijyun05.isOptional()) return null;
            return dai1sbjiuktgkyenkijyun05.absolute();
        }
        return dai1sbjiuktgkyenkijyun05Value;
    }

    protected void setDai1sbjiuktgkyenkijyun05Value(BigDecimal value) {
        dai1sbjiuktgkyenkijyun05Value = value;
        dai1sbjiuktgkyenkijyun05 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyenkijyun05Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyenkijyun05Value()))
            .orNull();
    }

    transient private String dai1sbjiuktgkyenkijyun05Type = null;

    @Column(name=DAI1SBJIUKTGKYENKIJYUN05 + "$", nullable=true)
    protected String getDai1sbjiuktgkyenkijyun05Type() {
        if (dai1sbjiuktgkyenkijyun05Type == null && dai1sbjiuktgkyenkijyun05 != null) return dai1sbjiuktgkyenkijyun05.getType().toString();
        if (dai1sbjiuktgkyenkijyun05Type == null && getDai1sbjiuktgkyenkijyun05Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1sbjiuktgkyenkijyun05$' should not be NULL."));
        }
        return dai1sbjiuktgkyenkijyun05Type;
    }

    protected void setDai1sbjiuktgkyenkijyun05Type(String type) {
        dai1sbjiuktgkyenkijyun05Type = type;
        dai1sbjiuktgkyenkijyun05 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyenkijyun05Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyenkijyun05Value()))
            .orNull();
    }

    private BizCurrency dai1sbjiuktgkyenyasu05;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1sbjiuktgkyenyasu05() {
        return dai1sbjiuktgkyenyasu05;
    }

    public void setDai1sbjiuktgkyenyasu05(BizCurrency pDai1sbjiuktgkyenyasu05) {
        dai1sbjiuktgkyenyasu05 = pDai1sbjiuktgkyenyasu05;
        dai1sbjiuktgkyenyasu05Value = null;
        dai1sbjiuktgkyenyasu05Type  = null;
    }

    transient private BigDecimal dai1sbjiuktgkyenyasu05Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SBJIUKTGKYENYASU05, nullable=true)
    protected BigDecimal getDai1sbjiuktgkyenyasu05Value() {
        if (dai1sbjiuktgkyenyasu05Value == null && dai1sbjiuktgkyenyasu05 != null) {
            if (dai1sbjiuktgkyenyasu05.isOptional()) return null;
            return dai1sbjiuktgkyenyasu05.absolute();
        }
        return dai1sbjiuktgkyenyasu05Value;
    }

    protected void setDai1sbjiuktgkyenyasu05Value(BigDecimal value) {
        dai1sbjiuktgkyenyasu05Value = value;
        dai1sbjiuktgkyenyasu05 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyenyasu05Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyenyasu05Value()))
            .orNull();
    }

    transient private String dai1sbjiuktgkyenyasu05Type = null;

    @Column(name=DAI1SBJIUKTGKYENYASU05 + "$", nullable=true)
    protected String getDai1sbjiuktgkyenyasu05Type() {
        if (dai1sbjiuktgkyenyasu05Type == null && dai1sbjiuktgkyenyasu05 != null) return dai1sbjiuktgkyenyasu05.getType().toString();
        if (dai1sbjiuktgkyenyasu05Type == null && getDai1sbjiuktgkyenyasu05Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1sbjiuktgkyenyasu05$' should not be NULL."));
        }
        return dai1sbjiuktgkyenyasu05Type;
    }

    protected void setDai1sbjiuktgkyenyasu05Type(String type) {
        dai1sbjiuktgkyenyasu05Type = type;
        dai1sbjiuktgkyenyasu05 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyenyasu05Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyenyasu05Value()))
            .orNull();
    }

    private BizCurrency dai1zennouzndk06;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1zennouzndk06() {
        return dai1zennouzndk06;
    }

    public void setDai1zennouzndk06(BizCurrency pDai1zennouzndk06) {
        dai1zennouzndk06 = pDai1zennouzndk06;
        dai1zennouzndk06Value = null;
        dai1zennouzndk06Type  = null;
    }

    transient private BigDecimal dai1zennouzndk06Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1ZENNOUZNDK06, nullable=true)
    protected BigDecimal getDai1zennouzndk06Value() {
        if (dai1zennouzndk06Value == null && dai1zennouzndk06 != null) {
            if (dai1zennouzndk06.isOptional()) return null;
            return dai1zennouzndk06.absolute();
        }
        return dai1zennouzndk06Value;
    }

    protected void setDai1zennouzndk06Value(BigDecimal value) {
        dai1zennouzndk06Value = value;
        dai1zennouzndk06 = Optional.fromNullable(toCurrencyType(dai1zennouzndk06Type))
            .transform(bizCurrencyTransformer(getDai1zennouzndk06Value()))
            .orNull();
    }

    transient private String dai1zennouzndk06Type = null;

    @Column(name=DAI1ZENNOUZNDK06 + "$", nullable=true)
    protected String getDai1zennouzndk06Type() {
        if (dai1zennouzndk06Type == null && dai1zennouzndk06 != null) return dai1zennouzndk06.getType().toString();
        if (dai1zennouzndk06Type == null && getDai1zennouzndk06Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1zennouzndk06$' should not be NULL."));
        }
        return dai1zennouzndk06Type;
    }

    protected void setDai1zennouzndk06Type(String type) {
        dai1zennouzndk06Type = type;
        dai1zennouzndk06 = Optional.fromNullable(toCurrencyType(dai1zennouzndk06Type))
            .transform(bizCurrencyTransformer(getDai1zennouzndk06Value()))
            .orNull();
    }

    private C_Tuukasyu dai1zennouzndktype06;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.DAI1ZENNOUZNDKTYPE06)
    public C_Tuukasyu getDai1zennouzndktype06() {
        return dai1zennouzndktype06;
    }

    public void setDai1zennouzndktype06(C_Tuukasyu pDai1zennouzndktype06) {
        dai1zennouzndktype06 = pDai1zennouzndktype06;
    }

    private BizCurrency dai1sbjiuktgk06;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1sbjiuktgk06() {
        return dai1sbjiuktgk06;
    }

    public void setDai1sbjiuktgk06(BizCurrency pDai1sbjiuktgk06) {
        dai1sbjiuktgk06 = pDai1sbjiuktgk06;
        dai1sbjiuktgk06Value = null;
        dai1sbjiuktgk06Type  = null;
    }

    transient private BigDecimal dai1sbjiuktgk06Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SBJIUKTGK06, nullable=true)
    protected BigDecimal getDai1sbjiuktgk06Value() {
        if (dai1sbjiuktgk06Value == null && dai1sbjiuktgk06 != null) {
            if (dai1sbjiuktgk06.isOptional()) return null;
            return dai1sbjiuktgk06.absolute();
        }
        return dai1sbjiuktgk06Value;
    }

    protected void setDai1sbjiuktgk06Value(BigDecimal value) {
        dai1sbjiuktgk06Value = value;
        dai1sbjiuktgk06 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgk06Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgk06Value()))
            .orNull();
    }

    transient private String dai1sbjiuktgk06Type = null;

    @Column(name=DAI1SBJIUKTGK06 + "$", nullable=true)
    protected String getDai1sbjiuktgk06Type() {
        if (dai1sbjiuktgk06Type == null && dai1sbjiuktgk06 != null) return dai1sbjiuktgk06.getType().toString();
        if (dai1sbjiuktgk06Type == null && getDai1sbjiuktgk06Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1sbjiuktgk06$' should not be NULL."));
        }
        return dai1sbjiuktgk06Type;
    }

    protected void setDai1sbjiuktgk06Type(String type) {
        dai1sbjiuktgk06Type = type;
        dai1sbjiuktgk06 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgk06Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgk06Value()))
            .orNull();
    }

    private C_Tuukasyu dai1sbjiuktgktype06;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenIT_BAK_HokenSyoukenHukaInfo.DAI1SBJIUKTGKTYPE06)
    public C_Tuukasyu getDai1sbjiuktgktype06() {
        return dai1sbjiuktgktype06;
    }

    public void setDai1sbjiuktgktype06(C_Tuukasyu pDai1sbjiuktgktype06) {
        dai1sbjiuktgktype06 = pDai1sbjiuktgktype06;
    }

    private BizCurrency dai1sbjiuktgkyendaka06;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1sbjiuktgkyendaka06() {
        return dai1sbjiuktgkyendaka06;
    }

    public void setDai1sbjiuktgkyendaka06(BizCurrency pDai1sbjiuktgkyendaka06) {
        dai1sbjiuktgkyendaka06 = pDai1sbjiuktgkyendaka06;
        dai1sbjiuktgkyendaka06Value = null;
        dai1sbjiuktgkyendaka06Type  = null;
    }

    transient private BigDecimal dai1sbjiuktgkyendaka06Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SBJIUKTGKYENDAKA06, nullable=true)
    protected BigDecimal getDai1sbjiuktgkyendaka06Value() {
        if (dai1sbjiuktgkyendaka06Value == null && dai1sbjiuktgkyendaka06 != null) {
            if (dai1sbjiuktgkyendaka06.isOptional()) return null;
            return dai1sbjiuktgkyendaka06.absolute();
        }
        return dai1sbjiuktgkyendaka06Value;
    }

    protected void setDai1sbjiuktgkyendaka06Value(BigDecimal value) {
        dai1sbjiuktgkyendaka06Value = value;
        dai1sbjiuktgkyendaka06 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyendaka06Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyendaka06Value()))
            .orNull();
    }

    transient private String dai1sbjiuktgkyendaka06Type = null;

    @Column(name=DAI1SBJIUKTGKYENDAKA06 + "$", nullable=true)
    protected String getDai1sbjiuktgkyendaka06Type() {
        if (dai1sbjiuktgkyendaka06Type == null && dai1sbjiuktgkyendaka06 != null) return dai1sbjiuktgkyendaka06.getType().toString();
        if (dai1sbjiuktgkyendaka06Type == null && getDai1sbjiuktgkyendaka06Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1sbjiuktgkyendaka06$' should not be NULL."));
        }
        return dai1sbjiuktgkyendaka06Type;
    }

    protected void setDai1sbjiuktgkyendaka06Type(String type) {
        dai1sbjiuktgkyendaka06Type = type;
        dai1sbjiuktgkyendaka06 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyendaka06Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyendaka06Value()))
            .orNull();
    }

    private BizCurrency dai1sbjiuktgkyenkijyun06;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1sbjiuktgkyenkijyun06() {
        return dai1sbjiuktgkyenkijyun06;
    }

    public void setDai1sbjiuktgkyenkijyun06(BizCurrency pDai1sbjiuktgkyenkijyun06) {
        dai1sbjiuktgkyenkijyun06 = pDai1sbjiuktgkyenkijyun06;
        dai1sbjiuktgkyenkijyun06Value = null;
        dai1sbjiuktgkyenkijyun06Type  = null;
    }

    transient private BigDecimal dai1sbjiuktgkyenkijyun06Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SBJIUKTGKYENKIJYUN06, nullable=true)
    protected BigDecimal getDai1sbjiuktgkyenkijyun06Value() {
        if (dai1sbjiuktgkyenkijyun06Value == null && dai1sbjiuktgkyenkijyun06 != null) {
            if (dai1sbjiuktgkyenkijyun06.isOptional()) return null;
            return dai1sbjiuktgkyenkijyun06.absolute();
        }
        return dai1sbjiuktgkyenkijyun06Value;
    }

    protected void setDai1sbjiuktgkyenkijyun06Value(BigDecimal value) {
        dai1sbjiuktgkyenkijyun06Value = value;
        dai1sbjiuktgkyenkijyun06 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyenkijyun06Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyenkijyun06Value()))
            .orNull();
    }

    transient private String dai1sbjiuktgkyenkijyun06Type = null;

    @Column(name=DAI1SBJIUKTGKYENKIJYUN06 + "$", nullable=true)
    protected String getDai1sbjiuktgkyenkijyun06Type() {
        if (dai1sbjiuktgkyenkijyun06Type == null && dai1sbjiuktgkyenkijyun06 != null) return dai1sbjiuktgkyenkijyun06.getType().toString();
        if (dai1sbjiuktgkyenkijyun06Type == null && getDai1sbjiuktgkyenkijyun06Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1sbjiuktgkyenkijyun06$' should not be NULL."));
        }
        return dai1sbjiuktgkyenkijyun06Type;
    }

    protected void setDai1sbjiuktgkyenkijyun06Type(String type) {
        dai1sbjiuktgkyenkijyun06Type = type;
        dai1sbjiuktgkyenkijyun06 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyenkijyun06Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyenkijyun06Value()))
            .orNull();
    }

    private BizCurrency dai1sbjiuktgkyenyasu06;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getDai1sbjiuktgkyenyasu06() {
        return dai1sbjiuktgkyenyasu06;
    }

    public void setDai1sbjiuktgkyenyasu06(BizCurrency pDai1sbjiuktgkyenyasu06) {
        dai1sbjiuktgkyenyasu06 = pDai1sbjiuktgkyenyasu06;
        dai1sbjiuktgkyenyasu06Value = null;
        dai1sbjiuktgkyenyasu06Type  = null;
    }

    transient private BigDecimal dai1sbjiuktgkyenyasu06Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=DAI1SBJIUKTGKYENYASU06, nullable=true)
    protected BigDecimal getDai1sbjiuktgkyenyasu06Value() {
        if (dai1sbjiuktgkyenyasu06Value == null && dai1sbjiuktgkyenyasu06 != null) {
            if (dai1sbjiuktgkyenyasu06.isOptional()) return null;
            return dai1sbjiuktgkyenyasu06.absolute();
        }
        return dai1sbjiuktgkyenyasu06Value;
    }

    protected void setDai1sbjiuktgkyenyasu06Value(BigDecimal value) {
        dai1sbjiuktgkyenyasu06Value = value;
        dai1sbjiuktgkyenyasu06 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyenyasu06Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyenyasu06Value()))
            .orNull();
    }

    transient private String dai1sbjiuktgkyenyasu06Type = null;

    @Column(name=DAI1SBJIUKTGKYENYASU06 + "$", nullable=true)
    protected String getDai1sbjiuktgkyenyasu06Type() {
        if (dai1sbjiuktgkyenyasu06Type == null && dai1sbjiuktgkyenyasu06 != null) return dai1sbjiuktgkyenyasu06.getType().toString();
        if (dai1sbjiuktgkyenyasu06Type == null && getDai1sbjiuktgkyenyasu06Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'dai1sbjiuktgkyenyasu06$' should not be NULL."));
        }
        return dai1sbjiuktgkyenyasu06Type;
    }

    protected void setDai1sbjiuktgkyenyasu06Type(String type) {
        dai1sbjiuktgkyenyasu06Type = type;
        dai1sbjiuktgkyenyasu06 = Optional.fromNullable(toCurrencyType(dai1sbjiuktgkyenyasu06Type))
            .transform(bizCurrencyTransformer(getDai1sbjiuktgkyenyasu06Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkydaka01;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkydaka01() {
        return kaigomaehrjrugkydaka01;
    }

    public void setKaigomaehrjrugkydaka01(BizCurrency pKaigomaehrjrugkydaka01) {
        kaigomaehrjrugkydaka01 = pKaigomaehrjrugkydaka01;
        kaigomaehrjrugkydaka01Value = null;
        kaigomaehrjrugkydaka01Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkydaka01Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYDAKA01, nullable=true)
    protected BigDecimal getKaigomaehrjrugkydaka01Value() {
        if (kaigomaehrjrugkydaka01Value == null && kaigomaehrjrugkydaka01 != null) {
            if (kaigomaehrjrugkydaka01.isOptional()) return null;
            return kaigomaehrjrugkydaka01.absolute();
        }
        return kaigomaehrjrugkydaka01Value;
    }

    protected void setKaigomaehrjrugkydaka01Value(BigDecimal value) {
        kaigomaehrjrugkydaka01Value = value;
        kaigomaehrjrugkydaka01 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkydaka01Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkydaka01Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkydaka01Type = null;

    @Column(name=KAIGOMAEHRJRUGKYDAKA01 + "$", nullable=true)
    protected String getKaigomaehrjrugkydaka01Type() {
        if (kaigomaehrjrugkydaka01Type == null && kaigomaehrjrugkydaka01 != null) return kaigomaehrjrugkydaka01.getType().toString();
        if (kaigomaehrjrugkydaka01Type == null && getKaigomaehrjrugkydaka01Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkydaka01$' should not be NULL."));
        }
        return kaigomaehrjrugkydaka01Type;
    }

    protected void setKaigomaehrjrugkydaka01Type(String type) {
        kaigomaehrjrugkydaka01Type = type;
        kaigomaehrjrugkydaka01 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkydaka01Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkydaka01Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkydaka02;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkydaka02() {
        return kaigomaehrjrugkydaka02;
    }

    public void setKaigomaehrjrugkydaka02(BizCurrency pKaigomaehrjrugkydaka02) {
        kaigomaehrjrugkydaka02 = pKaigomaehrjrugkydaka02;
        kaigomaehrjrugkydaka02Value = null;
        kaigomaehrjrugkydaka02Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkydaka02Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYDAKA02, nullable=true)
    protected BigDecimal getKaigomaehrjrugkydaka02Value() {
        if (kaigomaehrjrugkydaka02Value == null && kaigomaehrjrugkydaka02 != null) {
            if (kaigomaehrjrugkydaka02.isOptional()) return null;
            return kaigomaehrjrugkydaka02.absolute();
        }
        return kaigomaehrjrugkydaka02Value;
    }

    protected void setKaigomaehrjrugkydaka02Value(BigDecimal value) {
        kaigomaehrjrugkydaka02Value = value;
        kaigomaehrjrugkydaka02 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkydaka02Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkydaka02Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkydaka02Type = null;

    @Column(name=KAIGOMAEHRJRUGKYDAKA02 + "$", nullable=true)
    protected String getKaigomaehrjrugkydaka02Type() {
        if (kaigomaehrjrugkydaka02Type == null && kaigomaehrjrugkydaka02 != null) return kaigomaehrjrugkydaka02.getType().toString();
        if (kaigomaehrjrugkydaka02Type == null && getKaigomaehrjrugkydaka02Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkydaka02$' should not be NULL."));
        }
        return kaigomaehrjrugkydaka02Type;
    }

    protected void setKaigomaehrjrugkydaka02Type(String type) {
        kaigomaehrjrugkydaka02Type = type;
        kaigomaehrjrugkydaka02 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkydaka02Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkydaka02Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkydaka03;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkydaka03() {
        return kaigomaehrjrugkydaka03;
    }

    public void setKaigomaehrjrugkydaka03(BizCurrency pKaigomaehrjrugkydaka03) {
        kaigomaehrjrugkydaka03 = pKaigomaehrjrugkydaka03;
        kaigomaehrjrugkydaka03Value = null;
        kaigomaehrjrugkydaka03Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkydaka03Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYDAKA03, nullable=true)
    protected BigDecimal getKaigomaehrjrugkydaka03Value() {
        if (kaigomaehrjrugkydaka03Value == null && kaigomaehrjrugkydaka03 != null) {
            if (kaigomaehrjrugkydaka03.isOptional()) return null;
            return kaigomaehrjrugkydaka03.absolute();
        }
        return kaigomaehrjrugkydaka03Value;
    }

    protected void setKaigomaehrjrugkydaka03Value(BigDecimal value) {
        kaigomaehrjrugkydaka03Value = value;
        kaigomaehrjrugkydaka03 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkydaka03Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkydaka03Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkydaka03Type = null;

    @Column(name=KAIGOMAEHRJRUGKYDAKA03 + "$", nullable=true)
    protected String getKaigomaehrjrugkydaka03Type() {
        if (kaigomaehrjrugkydaka03Type == null && kaigomaehrjrugkydaka03 != null) return kaigomaehrjrugkydaka03.getType().toString();
        if (kaigomaehrjrugkydaka03Type == null && getKaigomaehrjrugkydaka03Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkydaka03$' should not be NULL."));
        }
        return kaigomaehrjrugkydaka03Type;
    }

    protected void setKaigomaehrjrugkydaka03Type(String type) {
        kaigomaehrjrugkydaka03Type = type;
        kaigomaehrjrugkydaka03 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkydaka03Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkydaka03Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkydaka04;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkydaka04() {
        return kaigomaehrjrugkydaka04;
    }

    public void setKaigomaehrjrugkydaka04(BizCurrency pKaigomaehrjrugkydaka04) {
        kaigomaehrjrugkydaka04 = pKaigomaehrjrugkydaka04;
        kaigomaehrjrugkydaka04Value = null;
        kaigomaehrjrugkydaka04Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkydaka04Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYDAKA04, nullable=true)
    protected BigDecimal getKaigomaehrjrugkydaka04Value() {
        if (kaigomaehrjrugkydaka04Value == null && kaigomaehrjrugkydaka04 != null) {
            if (kaigomaehrjrugkydaka04.isOptional()) return null;
            return kaigomaehrjrugkydaka04.absolute();
        }
        return kaigomaehrjrugkydaka04Value;
    }

    protected void setKaigomaehrjrugkydaka04Value(BigDecimal value) {
        kaigomaehrjrugkydaka04Value = value;
        kaigomaehrjrugkydaka04 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkydaka04Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkydaka04Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkydaka04Type = null;

    @Column(name=KAIGOMAEHRJRUGKYDAKA04 + "$", nullable=true)
    protected String getKaigomaehrjrugkydaka04Type() {
        if (kaigomaehrjrugkydaka04Type == null && kaigomaehrjrugkydaka04 != null) return kaigomaehrjrugkydaka04.getType().toString();
        if (kaigomaehrjrugkydaka04Type == null && getKaigomaehrjrugkydaka04Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkydaka04$' should not be NULL."));
        }
        return kaigomaehrjrugkydaka04Type;
    }

    protected void setKaigomaehrjrugkydaka04Type(String type) {
        kaigomaehrjrugkydaka04Type = type;
        kaigomaehrjrugkydaka04 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkydaka04Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkydaka04Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkydaka05;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkydaka05() {
        return kaigomaehrjrugkydaka05;
    }

    public void setKaigomaehrjrugkydaka05(BizCurrency pKaigomaehrjrugkydaka05) {
        kaigomaehrjrugkydaka05 = pKaigomaehrjrugkydaka05;
        kaigomaehrjrugkydaka05Value = null;
        kaigomaehrjrugkydaka05Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkydaka05Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYDAKA05, nullable=true)
    protected BigDecimal getKaigomaehrjrugkydaka05Value() {
        if (kaigomaehrjrugkydaka05Value == null && kaigomaehrjrugkydaka05 != null) {
            if (kaigomaehrjrugkydaka05.isOptional()) return null;
            return kaigomaehrjrugkydaka05.absolute();
        }
        return kaigomaehrjrugkydaka05Value;
    }

    protected void setKaigomaehrjrugkydaka05Value(BigDecimal value) {
        kaigomaehrjrugkydaka05Value = value;
        kaigomaehrjrugkydaka05 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkydaka05Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkydaka05Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkydaka05Type = null;

    @Column(name=KAIGOMAEHRJRUGKYDAKA05 + "$", nullable=true)
    protected String getKaigomaehrjrugkydaka05Type() {
        if (kaigomaehrjrugkydaka05Type == null && kaigomaehrjrugkydaka05 != null) return kaigomaehrjrugkydaka05.getType().toString();
        if (kaigomaehrjrugkydaka05Type == null && getKaigomaehrjrugkydaka05Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkydaka05$' should not be NULL."));
        }
        return kaigomaehrjrugkydaka05Type;
    }

    protected void setKaigomaehrjrugkydaka05Type(String type) {
        kaigomaehrjrugkydaka05Type = type;
        kaigomaehrjrugkydaka05 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkydaka05Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkydaka05Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkydaka06;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkydaka06() {
        return kaigomaehrjrugkydaka06;
    }

    public void setKaigomaehrjrugkydaka06(BizCurrency pKaigomaehrjrugkydaka06) {
        kaigomaehrjrugkydaka06 = pKaigomaehrjrugkydaka06;
        kaigomaehrjrugkydaka06Value = null;
        kaigomaehrjrugkydaka06Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkydaka06Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYDAKA06, nullable=true)
    protected BigDecimal getKaigomaehrjrugkydaka06Value() {
        if (kaigomaehrjrugkydaka06Value == null && kaigomaehrjrugkydaka06 != null) {
            if (kaigomaehrjrugkydaka06.isOptional()) return null;
            return kaigomaehrjrugkydaka06.absolute();
        }
        return kaigomaehrjrugkydaka06Value;
    }

    protected void setKaigomaehrjrugkydaka06Value(BigDecimal value) {
        kaigomaehrjrugkydaka06Value = value;
        kaigomaehrjrugkydaka06 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkydaka06Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkydaka06Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkydaka06Type = null;

    @Column(name=KAIGOMAEHRJRUGKYDAKA06 + "$", nullable=true)
    protected String getKaigomaehrjrugkydaka06Type() {
        if (kaigomaehrjrugkydaka06Type == null && kaigomaehrjrugkydaka06 != null) return kaigomaehrjrugkydaka06.getType().toString();
        if (kaigomaehrjrugkydaka06Type == null && getKaigomaehrjrugkydaka06Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkydaka06$' should not be NULL."));
        }
        return kaigomaehrjrugkydaka06Type;
    }

    protected void setKaigomaehrjrugkydaka06Type(String type) {
        kaigomaehrjrugkydaka06Type = type;
        kaigomaehrjrugkydaka06 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkydaka06Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkydaka06Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkydaka07;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkydaka07() {
        return kaigomaehrjrugkydaka07;
    }

    public void setKaigomaehrjrugkydaka07(BizCurrency pKaigomaehrjrugkydaka07) {
        kaigomaehrjrugkydaka07 = pKaigomaehrjrugkydaka07;
        kaigomaehrjrugkydaka07Value = null;
        kaigomaehrjrugkydaka07Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkydaka07Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYDAKA07, nullable=true)
    protected BigDecimal getKaigomaehrjrugkydaka07Value() {
        if (kaigomaehrjrugkydaka07Value == null && kaigomaehrjrugkydaka07 != null) {
            if (kaigomaehrjrugkydaka07.isOptional()) return null;
            return kaigomaehrjrugkydaka07.absolute();
        }
        return kaigomaehrjrugkydaka07Value;
    }

    protected void setKaigomaehrjrugkydaka07Value(BigDecimal value) {
        kaigomaehrjrugkydaka07Value = value;
        kaigomaehrjrugkydaka07 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkydaka07Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkydaka07Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkydaka07Type = null;

    @Column(name=KAIGOMAEHRJRUGKYDAKA07 + "$", nullable=true)
    protected String getKaigomaehrjrugkydaka07Type() {
        if (kaigomaehrjrugkydaka07Type == null && kaigomaehrjrugkydaka07 != null) return kaigomaehrjrugkydaka07.getType().toString();
        if (kaigomaehrjrugkydaka07Type == null && getKaigomaehrjrugkydaka07Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkydaka07$' should not be NULL."));
        }
        return kaigomaehrjrugkydaka07Type;
    }

    protected void setKaigomaehrjrugkydaka07Type(String type) {
        kaigomaehrjrugkydaka07Type = type;
        kaigomaehrjrugkydaka07 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkydaka07Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkydaka07Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkydaka08;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkydaka08() {
        return kaigomaehrjrugkydaka08;
    }

    public void setKaigomaehrjrugkydaka08(BizCurrency pKaigomaehrjrugkydaka08) {
        kaigomaehrjrugkydaka08 = pKaigomaehrjrugkydaka08;
        kaigomaehrjrugkydaka08Value = null;
        kaigomaehrjrugkydaka08Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkydaka08Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYDAKA08, nullable=true)
    protected BigDecimal getKaigomaehrjrugkydaka08Value() {
        if (kaigomaehrjrugkydaka08Value == null && kaigomaehrjrugkydaka08 != null) {
            if (kaigomaehrjrugkydaka08.isOptional()) return null;
            return kaigomaehrjrugkydaka08.absolute();
        }
        return kaigomaehrjrugkydaka08Value;
    }

    protected void setKaigomaehrjrugkydaka08Value(BigDecimal value) {
        kaigomaehrjrugkydaka08Value = value;
        kaigomaehrjrugkydaka08 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkydaka08Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkydaka08Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkydaka08Type = null;

    @Column(name=KAIGOMAEHRJRUGKYDAKA08 + "$", nullable=true)
    protected String getKaigomaehrjrugkydaka08Type() {
        if (kaigomaehrjrugkydaka08Type == null && kaigomaehrjrugkydaka08 != null) return kaigomaehrjrugkydaka08.getType().toString();
        if (kaigomaehrjrugkydaka08Type == null && getKaigomaehrjrugkydaka08Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkydaka08$' should not be NULL."));
        }
        return kaigomaehrjrugkydaka08Type;
    }

    protected void setKaigomaehrjrugkydaka08Type(String type) {
        kaigomaehrjrugkydaka08Type = type;
        kaigomaehrjrugkydaka08 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkydaka08Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkydaka08Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkydaka09;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkydaka09() {
        return kaigomaehrjrugkydaka09;
    }

    public void setKaigomaehrjrugkydaka09(BizCurrency pKaigomaehrjrugkydaka09) {
        kaigomaehrjrugkydaka09 = pKaigomaehrjrugkydaka09;
        kaigomaehrjrugkydaka09Value = null;
        kaigomaehrjrugkydaka09Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkydaka09Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYDAKA09, nullable=true)
    protected BigDecimal getKaigomaehrjrugkydaka09Value() {
        if (kaigomaehrjrugkydaka09Value == null && kaigomaehrjrugkydaka09 != null) {
            if (kaigomaehrjrugkydaka09.isOptional()) return null;
            return kaigomaehrjrugkydaka09.absolute();
        }
        return kaigomaehrjrugkydaka09Value;
    }

    protected void setKaigomaehrjrugkydaka09Value(BigDecimal value) {
        kaigomaehrjrugkydaka09Value = value;
        kaigomaehrjrugkydaka09 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkydaka09Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkydaka09Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkydaka09Type = null;

    @Column(name=KAIGOMAEHRJRUGKYDAKA09 + "$", nullable=true)
    protected String getKaigomaehrjrugkydaka09Type() {
        if (kaigomaehrjrugkydaka09Type == null && kaigomaehrjrugkydaka09 != null) return kaigomaehrjrugkydaka09.getType().toString();
        if (kaigomaehrjrugkydaka09Type == null && getKaigomaehrjrugkydaka09Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkydaka09$' should not be NULL."));
        }
        return kaigomaehrjrugkydaka09Type;
    }

    protected void setKaigomaehrjrugkydaka09Type(String type) {
        kaigomaehrjrugkydaka09Type = type;
        kaigomaehrjrugkydaka09 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkydaka09Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkydaka09Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkydaka10;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkydaka10() {
        return kaigomaehrjrugkydaka10;
    }

    public void setKaigomaehrjrugkydaka10(BizCurrency pKaigomaehrjrugkydaka10) {
        kaigomaehrjrugkydaka10 = pKaigomaehrjrugkydaka10;
        kaigomaehrjrugkydaka10Value = null;
        kaigomaehrjrugkydaka10Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkydaka10Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYDAKA10, nullable=true)
    protected BigDecimal getKaigomaehrjrugkydaka10Value() {
        if (kaigomaehrjrugkydaka10Value == null && kaigomaehrjrugkydaka10 != null) {
            if (kaigomaehrjrugkydaka10.isOptional()) return null;
            return kaigomaehrjrugkydaka10.absolute();
        }
        return kaigomaehrjrugkydaka10Value;
    }

    protected void setKaigomaehrjrugkydaka10Value(BigDecimal value) {
        kaigomaehrjrugkydaka10Value = value;
        kaigomaehrjrugkydaka10 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkydaka10Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkydaka10Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkydaka10Type = null;

    @Column(name=KAIGOMAEHRJRUGKYDAKA10 + "$", nullable=true)
    protected String getKaigomaehrjrugkydaka10Type() {
        if (kaigomaehrjrugkydaka10Type == null && kaigomaehrjrugkydaka10 != null) return kaigomaehrjrugkydaka10.getType().toString();
        if (kaigomaehrjrugkydaka10Type == null && getKaigomaehrjrugkydaka10Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkydaka10$' should not be NULL."));
        }
        return kaigomaehrjrugkydaka10Type;
    }

    protected void setKaigomaehrjrugkydaka10Type(String type) {
        kaigomaehrjrugkydaka10Type = type;
        kaigomaehrjrugkydaka10 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkydaka10Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkydaka10Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkykijyun01;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkykijyun01() {
        return kaigomaehrjrugkykijyun01;
    }

    public void setKaigomaehrjrugkykijyun01(BizCurrency pKaigomaehrjrugkykijyun01) {
        kaigomaehrjrugkykijyun01 = pKaigomaehrjrugkykijyun01;
        kaigomaehrjrugkykijyun01Value = null;
        kaigomaehrjrugkykijyun01Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkykijyun01Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYKIJYUN01, nullable=true)
    protected BigDecimal getKaigomaehrjrugkykijyun01Value() {
        if (kaigomaehrjrugkykijyun01Value == null && kaigomaehrjrugkykijyun01 != null) {
            if (kaigomaehrjrugkykijyun01.isOptional()) return null;
            return kaigomaehrjrugkykijyun01.absolute();
        }
        return kaigomaehrjrugkykijyun01Value;
    }

    protected void setKaigomaehrjrugkykijyun01Value(BigDecimal value) {
        kaigomaehrjrugkykijyun01Value = value;
        kaigomaehrjrugkykijyun01 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkykijyun01Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkykijyun01Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkykijyun01Type = null;

    @Column(name=KAIGOMAEHRJRUGKYKIJYUN01 + "$", nullable=true)
    protected String getKaigomaehrjrugkykijyun01Type() {
        if (kaigomaehrjrugkykijyun01Type == null && kaigomaehrjrugkykijyun01 != null) return kaigomaehrjrugkykijyun01.getType().toString();
        if (kaigomaehrjrugkykijyun01Type == null && getKaigomaehrjrugkykijyun01Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkykijyun01$' should not be NULL."));
        }
        return kaigomaehrjrugkykijyun01Type;
    }

    protected void setKaigomaehrjrugkykijyun01Type(String type) {
        kaigomaehrjrugkykijyun01Type = type;
        kaigomaehrjrugkykijyun01 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkykijyun01Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkykijyun01Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkykijyun02;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkykijyun02() {
        return kaigomaehrjrugkykijyun02;
    }

    public void setKaigomaehrjrugkykijyun02(BizCurrency pKaigomaehrjrugkykijyun02) {
        kaigomaehrjrugkykijyun02 = pKaigomaehrjrugkykijyun02;
        kaigomaehrjrugkykijyun02Value = null;
        kaigomaehrjrugkykijyun02Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkykijyun02Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYKIJYUN02, nullable=true)
    protected BigDecimal getKaigomaehrjrugkykijyun02Value() {
        if (kaigomaehrjrugkykijyun02Value == null && kaigomaehrjrugkykijyun02 != null) {
            if (kaigomaehrjrugkykijyun02.isOptional()) return null;
            return kaigomaehrjrugkykijyun02.absolute();
        }
        return kaigomaehrjrugkykijyun02Value;
    }

    protected void setKaigomaehrjrugkykijyun02Value(BigDecimal value) {
        kaigomaehrjrugkykijyun02Value = value;
        kaigomaehrjrugkykijyun02 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkykijyun02Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkykijyun02Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkykijyun02Type = null;

    @Column(name=KAIGOMAEHRJRUGKYKIJYUN02 + "$", nullable=true)
    protected String getKaigomaehrjrugkykijyun02Type() {
        if (kaigomaehrjrugkykijyun02Type == null && kaigomaehrjrugkykijyun02 != null) return kaigomaehrjrugkykijyun02.getType().toString();
        if (kaigomaehrjrugkykijyun02Type == null && getKaigomaehrjrugkykijyun02Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkykijyun02$' should not be NULL."));
        }
        return kaigomaehrjrugkykijyun02Type;
    }

    protected void setKaigomaehrjrugkykijyun02Type(String type) {
        kaigomaehrjrugkykijyun02Type = type;
        kaigomaehrjrugkykijyun02 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkykijyun02Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkykijyun02Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkykijyun03;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkykijyun03() {
        return kaigomaehrjrugkykijyun03;
    }

    public void setKaigomaehrjrugkykijyun03(BizCurrency pKaigomaehrjrugkykijyun03) {
        kaigomaehrjrugkykijyun03 = pKaigomaehrjrugkykijyun03;
        kaigomaehrjrugkykijyun03Value = null;
        kaigomaehrjrugkykijyun03Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkykijyun03Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYKIJYUN03, nullable=true)
    protected BigDecimal getKaigomaehrjrugkykijyun03Value() {
        if (kaigomaehrjrugkykijyun03Value == null && kaigomaehrjrugkykijyun03 != null) {
            if (kaigomaehrjrugkykijyun03.isOptional()) return null;
            return kaigomaehrjrugkykijyun03.absolute();
        }
        return kaigomaehrjrugkykijyun03Value;
    }

    protected void setKaigomaehrjrugkykijyun03Value(BigDecimal value) {
        kaigomaehrjrugkykijyun03Value = value;
        kaigomaehrjrugkykijyun03 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkykijyun03Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkykijyun03Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkykijyun03Type = null;

    @Column(name=KAIGOMAEHRJRUGKYKIJYUN03 + "$", nullable=true)
    protected String getKaigomaehrjrugkykijyun03Type() {
        if (kaigomaehrjrugkykijyun03Type == null && kaigomaehrjrugkykijyun03 != null) return kaigomaehrjrugkykijyun03.getType().toString();
        if (kaigomaehrjrugkykijyun03Type == null && getKaigomaehrjrugkykijyun03Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkykijyun03$' should not be NULL."));
        }
        return kaigomaehrjrugkykijyun03Type;
    }

    protected void setKaigomaehrjrugkykijyun03Type(String type) {
        kaigomaehrjrugkykijyun03Type = type;
        kaigomaehrjrugkykijyun03 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkykijyun03Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkykijyun03Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkykijyun04;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkykijyun04() {
        return kaigomaehrjrugkykijyun04;
    }

    public void setKaigomaehrjrugkykijyun04(BizCurrency pKaigomaehrjrugkykijyun04) {
        kaigomaehrjrugkykijyun04 = pKaigomaehrjrugkykijyun04;
        kaigomaehrjrugkykijyun04Value = null;
        kaigomaehrjrugkykijyun04Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkykijyun04Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYKIJYUN04, nullable=true)
    protected BigDecimal getKaigomaehrjrugkykijyun04Value() {
        if (kaigomaehrjrugkykijyun04Value == null && kaigomaehrjrugkykijyun04 != null) {
            if (kaigomaehrjrugkykijyun04.isOptional()) return null;
            return kaigomaehrjrugkykijyun04.absolute();
        }
        return kaigomaehrjrugkykijyun04Value;
    }

    protected void setKaigomaehrjrugkykijyun04Value(BigDecimal value) {
        kaigomaehrjrugkykijyun04Value = value;
        kaigomaehrjrugkykijyun04 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkykijyun04Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkykijyun04Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkykijyun04Type = null;

    @Column(name=KAIGOMAEHRJRUGKYKIJYUN04 + "$", nullable=true)
    protected String getKaigomaehrjrugkykijyun04Type() {
        if (kaigomaehrjrugkykijyun04Type == null && kaigomaehrjrugkykijyun04 != null) return kaigomaehrjrugkykijyun04.getType().toString();
        if (kaigomaehrjrugkykijyun04Type == null && getKaigomaehrjrugkykijyun04Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkykijyun04$' should not be NULL."));
        }
        return kaigomaehrjrugkykijyun04Type;
    }

    protected void setKaigomaehrjrugkykijyun04Type(String type) {
        kaigomaehrjrugkykijyun04Type = type;
        kaigomaehrjrugkykijyun04 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkykijyun04Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkykijyun04Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkykijyun05;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkykijyun05() {
        return kaigomaehrjrugkykijyun05;
    }

    public void setKaigomaehrjrugkykijyun05(BizCurrency pKaigomaehrjrugkykijyun05) {
        kaigomaehrjrugkykijyun05 = pKaigomaehrjrugkykijyun05;
        kaigomaehrjrugkykijyun05Value = null;
        kaigomaehrjrugkykijyun05Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkykijyun05Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYKIJYUN05, nullable=true)
    protected BigDecimal getKaigomaehrjrugkykijyun05Value() {
        if (kaigomaehrjrugkykijyun05Value == null && kaigomaehrjrugkykijyun05 != null) {
            if (kaigomaehrjrugkykijyun05.isOptional()) return null;
            return kaigomaehrjrugkykijyun05.absolute();
        }
        return kaigomaehrjrugkykijyun05Value;
    }

    protected void setKaigomaehrjrugkykijyun05Value(BigDecimal value) {
        kaigomaehrjrugkykijyun05Value = value;
        kaigomaehrjrugkykijyun05 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkykijyun05Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkykijyun05Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkykijyun05Type = null;

    @Column(name=KAIGOMAEHRJRUGKYKIJYUN05 + "$", nullable=true)
    protected String getKaigomaehrjrugkykijyun05Type() {
        if (kaigomaehrjrugkykijyun05Type == null && kaigomaehrjrugkykijyun05 != null) return kaigomaehrjrugkykijyun05.getType().toString();
        if (kaigomaehrjrugkykijyun05Type == null && getKaigomaehrjrugkykijyun05Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkykijyun05$' should not be NULL."));
        }
        return kaigomaehrjrugkykijyun05Type;
    }

    protected void setKaigomaehrjrugkykijyun05Type(String type) {
        kaigomaehrjrugkykijyun05Type = type;
        kaigomaehrjrugkykijyun05 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkykijyun05Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkykijyun05Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkykijyun06;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkykijyun06() {
        return kaigomaehrjrugkykijyun06;
    }

    public void setKaigomaehrjrugkykijyun06(BizCurrency pKaigomaehrjrugkykijyun06) {
        kaigomaehrjrugkykijyun06 = pKaigomaehrjrugkykijyun06;
        kaigomaehrjrugkykijyun06Value = null;
        kaigomaehrjrugkykijyun06Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkykijyun06Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYKIJYUN06, nullable=true)
    protected BigDecimal getKaigomaehrjrugkykijyun06Value() {
        if (kaigomaehrjrugkykijyun06Value == null && kaigomaehrjrugkykijyun06 != null) {
            if (kaigomaehrjrugkykijyun06.isOptional()) return null;
            return kaigomaehrjrugkykijyun06.absolute();
        }
        return kaigomaehrjrugkykijyun06Value;
    }

    protected void setKaigomaehrjrugkykijyun06Value(BigDecimal value) {
        kaigomaehrjrugkykijyun06Value = value;
        kaigomaehrjrugkykijyun06 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkykijyun06Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkykijyun06Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkykijyun06Type = null;

    @Column(name=KAIGOMAEHRJRUGKYKIJYUN06 + "$", nullable=true)
    protected String getKaigomaehrjrugkykijyun06Type() {
        if (kaigomaehrjrugkykijyun06Type == null && kaigomaehrjrugkykijyun06 != null) return kaigomaehrjrugkykijyun06.getType().toString();
        if (kaigomaehrjrugkykijyun06Type == null && getKaigomaehrjrugkykijyun06Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkykijyun06$' should not be NULL."));
        }
        return kaigomaehrjrugkykijyun06Type;
    }

    protected void setKaigomaehrjrugkykijyun06Type(String type) {
        kaigomaehrjrugkykijyun06Type = type;
        kaigomaehrjrugkykijyun06 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkykijyun06Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkykijyun06Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkykijyun07;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkykijyun07() {
        return kaigomaehrjrugkykijyun07;
    }

    public void setKaigomaehrjrugkykijyun07(BizCurrency pKaigomaehrjrugkykijyun07) {
        kaigomaehrjrugkykijyun07 = pKaigomaehrjrugkykijyun07;
        kaigomaehrjrugkykijyun07Value = null;
        kaigomaehrjrugkykijyun07Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkykijyun07Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYKIJYUN07, nullable=true)
    protected BigDecimal getKaigomaehrjrugkykijyun07Value() {
        if (kaigomaehrjrugkykijyun07Value == null && kaigomaehrjrugkykijyun07 != null) {
            if (kaigomaehrjrugkykijyun07.isOptional()) return null;
            return kaigomaehrjrugkykijyun07.absolute();
        }
        return kaigomaehrjrugkykijyun07Value;
    }

    protected void setKaigomaehrjrugkykijyun07Value(BigDecimal value) {
        kaigomaehrjrugkykijyun07Value = value;
        kaigomaehrjrugkykijyun07 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkykijyun07Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkykijyun07Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkykijyun07Type = null;

    @Column(name=KAIGOMAEHRJRUGKYKIJYUN07 + "$", nullable=true)
    protected String getKaigomaehrjrugkykijyun07Type() {
        if (kaigomaehrjrugkykijyun07Type == null && kaigomaehrjrugkykijyun07 != null) return kaigomaehrjrugkykijyun07.getType().toString();
        if (kaigomaehrjrugkykijyun07Type == null && getKaigomaehrjrugkykijyun07Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkykijyun07$' should not be NULL."));
        }
        return kaigomaehrjrugkykijyun07Type;
    }

    protected void setKaigomaehrjrugkykijyun07Type(String type) {
        kaigomaehrjrugkykijyun07Type = type;
        kaigomaehrjrugkykijyun07 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkykijyun07Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkykijyun07Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkykijyun08;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkykijyun08() {
        return kaigomaehrjrugkykijyun08;
    }

    public void setKaigomaehrjrugkykijyun08(BizCurrency pKaigomaehrjrugkykijyun08) {
        kaigomaehrjrugkykijyun08 = pKaigomaehrjrugkykijyun08;
        kaigomaehrjrugkykijyun08Value = null;
        kaigomaehrjrugkykijyun08Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkykijyun08Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYKIJYUN08, nullable=true)
    protected BigDecimal getKaigomaehrjrugkykijyun08Value() {
        if (kaigomaehrjrugkykijyun08Value == null && kaigomaehrjrugkykijyun08 != null) {
            if (kaigomaehrjrugkykijyun08.isOptional()) return null;
            return kaigomaehrjrugkykijyun08.absolute();
        }
        return kaigomaehrjrugkykijyun08Value;
    }

    protected void setKaigomaehrjrugkykijyun08Value(BigDecimal value) {
        kaigomaehrjrugkykijyun08Value = value;
        kaigomaehrjrugkykijyun08 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkykijyun08Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkykijyun08Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkykijyun08Type = null;

    @Column(name=KAIGOMAEHRJRUGKYKIJYUN08 + "$", nullable=true)
    protected String getKaigomaehrjrugkykijyun08Type() {
        if (kaigomaehrjrugkykijyun08Type == null && kaigomaehrjrugkykijyun08 != null) return kaigomaehrjrugkykijyun08.getType().toString();
        if (kaigomaehrjrugkykijyun08Type == null && getKaigomaehrjrugkykijyun08Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkykijyun08$' should not be NULL."));
        }
        return kaigomaehrjrugkykijyun08Type;
    }

    protected void setKaigomaehrjrugkykijyun08Type(String type) {
        kaigomaehrjrugkykijyun08Type = type;
        kaigomaehrjrugkykijyun08 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkykijyun08Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkykijyun08Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkykijyun09;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkykijyun09() {
        return kaigomaehrjrugkykijyun09;
    }

    public void setKaigomaehrjrugkykijyun09(BizCurrency pKaigomaehrjrugkykijyun09) {
        kaigomaehrjrugkykijyun09 = pKaigomaehrjrugkykijyun09;
        kaigomaehrjrugkykijyun09Value = null;
        kaigomaehrjrugkykijyun09Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkykijyun09Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYKIJYUN09, nullable=true)
    protected BigDecimal getKaigomaehrjrugkykijyun09Value() {
        if (kaigomaehrjrugkykijyun09Value == null && kaigomaehrjrugkykijyun09 != null) {
            if (kaigomaehrjrugkykijyun09.isOptional()) return null;
            return kaigomaehrjrugkykijyun09.absolute();
        }
        return kaigomaehrjrugkykijyun09Value;
    }

    protected void setKaigomaehrjrugkykijyun09Value(BigDecimal value) {
        kaigomaehrjrugkykijyun09Value = value;
        kaigomaehrjrugkykijyun09 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkykijyun09Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkykijyun09Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkykijyun09Type = null;

    @Column(name=KAIGOMAEHRJRUGKYKIJYUN09 + "$", nullable=true)
    protected String getKaigomaehrjrugkykijyun09Type() {
        if (kaigomaehrjrugkykijyun09Type == null && kaigomaehrjrugkykijyun09 != null) return kaigomaehrjrugkykijyun09.getType().toString();
        if (kaigomaehrjrugkykijyun09Type == null && getKaigomaehrjrugkykijyun09Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkykijyun09$' should not be NULL."));
        }
        return kaigomaehrjrugkykijyun09Type;
    }

    protected void setKaigomaehrjrugkykijyun09Type(String type) {
        kaigomaehrjrugkykijyun09Type = type;
        kaigomaehrjrugkykijyun09 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkykijyun09Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkykijyun09Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkykijyun10;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkykijyun10() {
        return kaigomaehrjrugkykijyun10;
    }

    public void setKaigomaehrjrugkykijyun10(BizCurrency pKaigomaehrjrugkykijyun10) {
        kaigomaehrjrugkykijyun10 = pKaigomaehrjrugkykijyun10;
        kaigomaehrjrugkykijyun10Value = null;
        kaigomaehrjrugkykijyun10Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkykijyun10Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYKIJYUN10, nullable=true)
    protected BigDecimal getKaigomaehrjrugkykijyun10Value() {
        if (kaigomaehrjrugkykijyun10Value == null && kaigomaehrjrugkykijyun10 != null) {
            if (kaigomaehrjrugkykijyun10.isOptional()) return null;
            return kaigomaehrjrugkykijyun10.absolute();
        }
        return kaigomaehrjrugkykijyun10Value;
    }

    protected void setKaigomaehrjrugkykijyun10Value(BigDecimal value) {
        kaigomaehrjrugkykijyun10Value = value;
        kaigomaehrjrugkykijyun10 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkykijyun10Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkykijyun10Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkykijyun10Type = null;

    @Column(name=KAIGOMAEHRJRUGKYKIJYUN10 + "$", nullable=true)
    protected String getKaigomaehrjrugkykijyun10Type() {
        if (kaigomaehrjrugkykijyun10Type == null && kaigomaehrjrugkykijyun10 != null) return kaigomaehrjrugkykijyun10.getType().toString();
        if (kaigomaehrjrugkykijyun10Type == null && getKaigomaehrjrugkykijyun10Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkykijyun10$' should not be NULL."));
        }
        return kaigomaehrjrugkykijyun10Type;
    }

    protected void setKaigomaehrjrugkykijyun10Type(String type) {
        kaigomaehrjrugkykijyun10Type = type;
        kaigomaehrjrugkykijyun10 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkykijyun10Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkykijyun10Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkyyasu01;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkyyasu01() {
        return kaigomaehrjrugkyyasu01;
    }

    public void setKaigomaehrjrugkyyasu01(BizCurrency pKaigomaehrjrugkyyasu01) {
        kaigomaehrjrugkyyasu01 = pKaigomaehrjrugkyyasu01;
        kaigomaehrjrugkyyasu01Value = null;
        kaigomaehrjrugkyyasu01Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkyyasu01Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYYASU01, nullable=true)
    protected BigDecimal getKaigomaehrjrugkyyasu01Value() {
        if (kaigomaehrjrugkyyasu01Value == null && kaigomaehrjrugkyyasu01 != null) {
            if (kaigomaehrjrugkyyasu01.isOptional()) return null;
            return kaigomaehrjrugkyyasu01.absolute();
        }
        return kaigomaehrjrugkyyasu01Value;
    }

    protected void setKaigomaehrjrugkyyasu01Value(BigDecimal value) {
        kaigomaehrjrugkyyasu01Value = value;
        kaigomaehrjrugkyyasu01 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkyyasu01Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkyyasu01Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkyyasu01Type = null;

    @Column(name=KAIGOMAEHRJRUGKYYASU01 + "$", nullable=true)
    protected String getKaigomaehrjrugkyyasu01Type() {
        if (kaigomaehrjrugkyyasu01Type == null && kaigomaehrjrugkyyasu01 != null) return kaigomaehrjrugkyyasu01.getType().toString();
        if (kaigomaehrjrugkyyasu01Type == null && getKaigomaehrjrugkyyasu01Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkyyasu01$' should not be NULL."));
        }
        return kaigomaehrjrugkyyasu01Type;
    }

    protected void setKaigomaehrjrugkyyasu01Type(String type) {
        kaigomaehrjrugkyyasu01Type = type;
        kaigomaehrjrugkyyasu01 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkyyasu01Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkyyasu01Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkyyasu02;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkyyasu02() {
        return kaigomaehrjrugkyyasu02;
    }

    public void setKaigomaehrjrugkyyasu02(BizCurrency pKaigomaehrjrugkyyasu02) {
        kaigomaehrjrugkyyasu02 = pKaigomaehrjrugkyyasu02;
        kaigomaehrjrugkyyasu02Value = null;
        kaigomaehrjrugkyyasu02Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkyyasu02Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYYASU02, nullable=true)
    protected BigDecimal getKaigomaehrjrugkyyasu02Value() {
        if (kaigomaehrjrugkyyasu02Value == null && kaigomaehrjrugkyyasu02 != null) {
            if (kaigomaehrjrugkyyasu02.isOptional()) return null;
            return kaigomaehrjrugkyyasu02.absolute();
        }
        return kaigomaehrjrugkyyasu02Value;
    }

    protected void setKaigomaehrjrugkyyasu02Value(BigDecimal value) {
        kaigomaehrjrugkyyasu02Value = value;
        kaigomaehrjrugkyyasu02 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkyyasu02Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkyyasu02Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkyyasu02Type = null;

    @Column(name=KAIGOMAEHRJRUGKYYASU02 + "$", nullable=true)
    protected String getKaigomaehrjrugkyyasu02Type() {
        if (kaigomaehrjrugkyyasu02Type == null && kaigomaehrjrugkyyasu02 != null) return kaigomaehrjrugkyyasu02.getType().toString();
        if (kaigomaehrjrugkyyasu02Type == null && getKaigomaehrjrugkyyasu02Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkyyasu02$' should not be NULL."));
        }
        return kaigomaehrjrugkyyasu02Type;
    }

    protected void setKaigomaehrjrugkyyasu02Type(String type) {
        kaigomaehrjrugkyyasu02Type = type;
        kaigomaehrjrugkyyasu02 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkyyasu02Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkyyasu02Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkyyasu03;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkyyasu03() {
        return kaigomaehrjrugkyyasu03;
    }

    public void setKaigomaehrjrugkyyasu03(BizCurrency pKaigomaehrjrugkyyasu03) {
        kaigomaehrjrugkyyasu03 = pKaigomaehrjrugkyyasu03;
        kaigomaehrjrugkyyasu03Value = null;
        kaigomaehrjrugkyyasu03Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkyyasu03Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYYASU03, nullable=true)
    protected BigDecimal getKaigomaehrjrugkyyasu03Value() {
        if (kaigomaehrjrugkyyasu03Value == null && kaigomaehrjrugkyyasu03 != null) {
            if (kaigomaehrjrugkyyasu03.isOptional()) return null;
            return kaigomaehrjrugkyyasu03.absolute();
        }
        return kaigomaehrjrugkyyasu03Value;
    }

    protected void setKaigomaehrjrugkyyasu03Value(BigDecimal value) {
        kaigomaehrjrugkyyasu03Value = value;
        kaigomaehrjrugkyyasu03 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkyyasu03Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkyyasu03Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkyyasu03Type = null;

    @Column(name=KAIGOMAEHRJRUGKYYASU03 + "$", nullable=true)
    protected String getKaigomaehrjrugkyyasu03Type() {
        if (kaigomaehrjrugkyyasu03Type == null && kaigomaehrjrugkyyasu03 != null) return kaigomaehrjrugkyyasu03.getType().toString();
        if (kaigomaehrjrugkyyasu03Type == null && getKaigomaehrjrugkyyasu03Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkyyasu03$' should not be NULL."));
        }
        return kaigomaehrjrugkyyasu03Type;
    }

    protected void setKaigomaehrjrugkyyasu03Type(String type) {
        kaigomaehrjrugkyyasu03Type = type;
        kaigomaehrjrugkyyasu03 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkyyasu03Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkyyasu03Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkyyasu04;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkyyasu04() {
        return kaigomaehrjrugkyyasu04;
    }

    public void setKaigomaehrjrugkyyasu04(BizCurrency pKaigomaehrjrugkyyasu04) {
        kaigomaehrjrugkyyasu04 = pKaigomaehrjrugkyyasu04;
        kaigomaehrjrugkyyasu04Value = null;
        kaigomaehrjrugkyyasu04Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkyyasu04Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYYASU04, nullable=true)
    protected BigDecimal getKaigomaehrjrugkyyasu04Value() {
        if (kaigomaehrjrugkyyasu04Value == null && kaigomaehrjrugkyyasu04 != null) {
            if (kaigomaehrjrugkyyasu04.isOptional()) return null;
            return kaigomaehrjrugkyyasu04.absolute();
        }
        return kaigomaehrjrugkyyasu04Value;
    }

    protected void setKaigomaehrjrugkyyasu04Value(BigDecimal value) {
        kaigomaehrjrugkyyasu04Value = value;
        kaigomaehrjrugkyyasu04 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkyyasu04Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkyyasu04Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkyyasu04Type = null;

    @Column(name=KAIGOMAEHRJRUGKYYASU04 + "$", nullable=true)
    protected String getKaigomaehrjrugkyyasu04Type() {
        if (kaigomaehrjrugkyyasu04Type == null && kaigomaehrjrugkyyasu04 != null) return kaigomaehrjrugkyyasu04.getType().toString();
        if (kaigomaehrjrugkyyasu04Type == null && getKaigomaehrjrugkyyasu04Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkyyasu04$' should not be NULL."));
        }
        return kaigomaehrjrugkyyasu04Type;
    }

    protected void setKaigomaehrjrugkyyasu04Type(String type) {
        kaigomaehrjrugkyyasu04Type = type;
        kaigomaehrjrugkyyasu04 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkyyasu04Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkyyasu04Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkyyasu05;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkyyasu05() {
        return kaigomaehrjrugkyyasu05;
    }

    public void setKaigomaehrjrugkyyasu05(BizCurrency pKaigomaehrjrugkyyasu05) {
        kaigomaehrjrugkyyasu05 = pKaigomaehrjrugkyyasu05;
        kaigomaehrjrugkyyasu05Value = null;
        kaigomaehrjrugkyyasu05Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkyyasu05Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYYASU05, nullable=true)
    protected BigDecimal getKaigomaehrjrugkyyasu05Value() {
        if (kaigomaehrjrugkyyasu05Value == null && kaigomaehrjrugkyyasu05 != null) {
            if (kaigomaehrjrugkyyasu05.isOptional()) return null;
            return kaigomaehrjrugkyyasu05.absolute();
        }
        return kaigomaehrjrugkyyasu05Value;
    }

    protected void setKaigomaehrjrugkyyasu05Value(BigDecimal value) {
        kaigomaehrjrugkyyasu05Value = value;
        kaigomaehrjrugkyyasu05 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkyyasu05Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkyyasu05Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkyyasu05Type = null;

    @Column(name=KAIGOMAEHRJRUGKYYASU05 + "$", nullable=true)
    protected String getKaigomaehrjrugkyyasu05Type() {
        if (kaigomaehrjrugkyyasu05Type == null && kaigomaehrjrugkyyasu05 != null) return kaigomaehrjrugkyyasu05.getType().toString();
        if (kaigomaehrjrugkyyasu05Type == null && getKaigomaehrjrugkyyasu05Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkyyasu05$' should not be NULL."));
        }
        return kaigomaehrjrugkyyasu05Type;
    }

    protected void setKaigomaehrjrugkyyasu05Type(String type) {
        kaigomaehrjrugkyyasu05Type = type;
        kaigomaehrjrugkyyasu05 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkyyasu05Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkyyasu05Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkyyasu06;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkyyasu06() {
        return kaigomaehrjrugkyyasu06;
    }

    public void setKaigomaehrjrugkyyasu06(BizCurrency pKaigomaehrjrugkyyasu06) {
        kaigomaehrjrugkyyasu06 = pKaigomaehrjrugkyyasu06;
        kaigomaehrjrugkyyasu06Value = null;
        kaigomaehrjrugkyyasu06Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkyyasu06Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYYASU06, nullable=true)
    protected BigDecimal getKaigomaehrjrugkyyasu06Value() {
        if (kaigomaehrjrugkyyasu06Value == null && kaigomaehrjrugkyyasu06 != null) {
            if (kaigomaehrjrugkyyasu06.isOptional()) return null;
            return kaigomaehrjrugkyyasu06.absolute();
        }
        return kaigomaehrjrugkyyasu06Value;
    }

    protected void setKaigomaehrjrugkyyasu06Value(BigDecimal value) {
        kaigomaehrjrugkyyasu06Value = value;
        kaigomaehrjrugkyyasu06 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkyyasu06Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkyyasu06Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkyyasu06Type = null;

    @Column(name=KAIGOMAEHRJRUGKYYASU06 + "$", nullable=true)
    protected String getKaigomaehrjrugkyyasu06Type() {
        if (kaigomaehrjrugkyyasu06Type == null && kaigomaehrjrugkyyasu06 != null) return kaigomaehrjrugkyyasu06.getType().toString();
        if (kaigomaehrjrugkyyasu06Type == null && getKaigomaehrjrugkyyasu06Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkyyasu06$' should not be NULL."));
        }
        return kaigomaehrjrugkyyasu06Type;
    }

    protected void setKaigomaehrjrugkyyasu06Type(String type) {
        kaigomaehrjrugkyyasu06Type = type;
        kaigomaehrjrugkyyasu06 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkyyasu06Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkyyasu06Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkyyasu07;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkyyasu07() {
        return kaigomaehrjrugkyyasu07;
    }

    public void setKaigomaehrjrugkyyasu07(BizCurrency pKaigomaehrjrugkyyasu07) {
        kaigomaehrjrugkyyasu07 = pKaigomaehrjrugkyyasu07;
        kaigomaehrjrugkyyasu07Value = null;
        kaigomaehrjrugkyyasu07Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkyyasu07Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYYASU07, nullable=true)
    protected BigDecimal getKaigomaehrjrugkyyasu07Value() {
        if (kaigomaehrjrugkyyasu07Value == null && kaigomaehrjrugkyyasu07 != null) {
            if (kaigomaehrjrugkyyasu07.isOptional()) return null;
            return kaigomaehrjrugkyyasu07.absolute();
        }
        return kaigomaehrjrugkyyasu07Value;
    }

    protected void setKaigomaehrjrugkyyasu07Value(BigDecimal value) {
        kaigomaehrjrugkyyasu07Value = value;
        kaigomaehrjrugkyyasu07 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkyyasu07Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkyyasu07Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkyyasu07Type = null;

    @Column(name=KAIGOMAEHRJRUGKYYASU07 + "$", nullable=true)
    protected String getKaigomaehrjrugkyyasu07Type() {
        if (kaigomaehrjrugkyyasu07Type == null && kaigomaehrjrugkyyasu07 != null) return kaigomaehrjrugkyyasu07.getType().toString();
        if (kaigomaehrjrugkyyasu07Type == null && getKaigomaehrjrugkyyasu07Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkyyasu07$' should not be NULL."));
        }
        return kaigomaehrjrugkyyasu07Type;
    }

    protected void setKaigomaehrjrugkyyasu07Type(String type) {
        kaigomaehrjrugkyyasu07Type = type;
        kaigomaehrjrugkyyasu07 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkyyasu07Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkyyasu07Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkyyasu08;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkyyasu08() {
        return kaigomaehrjrugkyyasu08;
    }

    public void setKaigomaehrjrugkyyasu08(BizCurrency pKaigomaehrjrugkyyasu08) {
        kaigomaehrjrugkyyasu08 = pKaigomaehrjrugkyyasu08;
        kaigomaehrjrugkyyasu08Value = null;
        kaigomaehrjrugkyyasu08Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkyyasu08Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYYASU08, nullable=true)
    protected BigDecimal getKaigomaehrjrugkyyasu08Value() {
        if (kaigomaehrjrugkyyasu08Value == null && kaigomaehrjrugkyyasu08 != null) {
            if (kaigomaehrjrugkyyasu08.isOptional()) return null;
            return kaigomaehrjrugkyyasu08.absolute();
        }
        return kaigomaehrjrugkyyasu08Value;
    }

    protected void setKaigomaehrjrugkyyasu08Value(BigDecimal value) {
        kaigomaehrjrugkyyasu08Value = value;
        kaigomaehrjrugkyyasu08 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkyyasu08Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkyyasu08Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkyyasu08Type = null;

    @Column(name=KAIGOMAEHRJRUGKYYASU08 + "$", nullable=true)
    protected String getKaigomaehrjrugkyyasu08Type() {
        if (kaigomaehrjrugkyyasu08Type == null && kaigomaehrjrugkyyasu08 != null) return kaigomaehrjrugkyyasu08.getType().toString();
        if (kaigomaehrjrugkyyasu08Type == null && getKaigomaehrjrugkyyasu08Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkyyasu08$' should not be NULL."));
        }
        return kaigomaehrjrugkyyasu08Type;
    }

    protected void setKaigomaehrjrugkyyasu08Type(String type) {
        kaigomaehrjrugkyyasu08Type = type;
        kaigomaehrjrugkyyasu08 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkyyasu08Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkyyasu08Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkyyasu09;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkyyasu09() {
        return kaigomaehrjrugkyyasu09;
    }

    public void setKaigomaehrjrugkyyasu09(BizCurrency pKaigomaehrjrugkyyasu09) {
        kaigomaehrjrugkyyasu09 = pKaigomaehrjrugkyyasu09;
        kaigomaehrjrugkyyasu09Value = null;
        kaigomaehrjrugkyyasu09Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkyyasu09Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYYASU09, nullable=true)
    protected BigDecimal getKaigomaehrjrugkyyasu09Value() {
        if (kaigomaehrjrugkyyasu09Value == null && kaigomaehrjrugkyyasu09 != null) {
            if (kaigomaehrjrugkyyasu09.isOptional()) return null;
            return kaigomaehrjrugkyyasu09.absolute();
        }
        return kaigomaehrjrugkyyasu09Value;
    }

    protected void setKaigomaehrjrugkyyasu09Value(BigDecimal value) {
        kaigomaehrjrugkyyasu09Value = value;
        kaigomaehrjrugkyyasu09 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkyyasu09Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkyyasu09Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkyyasu09Type = null;

    @Column(name=KAIGOMAEHRJRUGKYYASU09 + "$", nullable=true)
    protected String getKaigomaehrjrugkyyasu09Type() {
        if (kaigomaehrjrugkyyasu09Type == null && kaigomaehrjrugkyyasu09 != null) return kaigomaehrjrugkyyasu09.getType().toString();
        if (kaigomaehrjrugkyyasu09Type == null && getKaigomaehrjrugkyyasu09Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkyyasu09$' should not be NULL."));
        }
        return kaigomaehrjrugkyyasu09Type;
    }

    protected void setKaigomaehrjrugkyyasu09Type(String type) {
        kaigomaehrjrugkyyasu09Type = type;
        kaigomaehrjrugkyyasu09 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkyyasu09Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkyyasu09Value()))
            .orNull();
    }

    private BizCurrency kaigomaehrjrugkyyasu10;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaigomaehrjrugkyyasu10() {
        return kaigomaehrjrugkyyasu10;
    }

    public void setKaigomaehrjrugkyyasu10(BizCurrency pKaigomaehrjrugkyyasu10) {
        kaigomaehrjrugkyyasu10 = pKaigomaehrjrugkyyasu10;
        kaigomaehrjrugkyyasu10Value = null;
        kaigomaehrjrugkyyasu10Type  = null;
    }

    transient private BigDecimal kaigomaehrjrugkyyasu10Value = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIGOMAEHRJRUGKYYASU10, nullable=true)
    protected BigDecimal getKaigomaehrjrugkyyasu10Value() {
        if (kaigomaehrjrugkyyasu10Value == null && kaigomaehrjrugkyyasu10 != null) {
            if (kaigomaehrjrugkyyasu10.isOptional()) return null;
            return kaigomaehrjrugkyyasu10.absolute();
        }
        return kaigomaehrjrugkyyasu10Value;
    }

    protected void setKaigomaehrjrugkyyasu10Value(BigDecimal value) {
        kaigomaehrjrugkyyasu10Value = value;
        kaigomaehrjrugkyyasu10 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkyyasu10Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkyyasu10Value()))
            .orNull();
    }

    transient private String kaigomaehrjrugkyyasu10Type = null;

    @Column(name=KAIGOMAEHRJRUGKYYASU10 + "$", nullable=true)
    protected String getKaigomaehrjrugkyyasu10Type() {
        if (kaigomaehrjrugkyyasu10Type == null && kaigomaehrjrugkyyasu10 != null) return kaigomaehrjrugkyyasu10.getType().toString();
        if (kaigomaehrjrugkyyasu10Type == null && getKaigomaehrjrugkyyasu10Value() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaigomaehrjrugkyyasu10$' should not be NULL."));
        }
        return kaigomaehrjrugkyyasu10Type;
    }

    protected void setKaigomaehrjrugkyyasu10Type(String type) {
        kaigomaehrjrugkyyasu10Type = type;
        kaigomaehrjrugkyyasu10 = Optional.fromNullable(toCurrencyType(kaigomaehrjrugkyyasu10Type))
            .transform(bizCurrencyTransformer(getKaigomaehrjrugkyyasu10Value()))
            .orNull();
    }
}