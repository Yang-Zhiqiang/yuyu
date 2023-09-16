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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.CurrencyLenght;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.PositiveNumberBizCalcble;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BknTyousaFSyoriKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HubiJyoukyouKbn;
import yuyu.def.classification.C_HushrGeninKbn;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SeisankinKanritukaKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SyouhnsyuruiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.id.PKJT_SiBikinkanri;
import yuyu.def.db.meta.GenQJT_SiBikinkanri;
import yuyu.def.db.meta.QJT_SiBikinkanri;
import yuyu.def.db.type.UserType_C_BknJkuKbn;
import yuyu.def.db.type.UserType_C_BknTyousaFSyoriKbn;
import yuyu.def.db.type.UserType_C_BkncdKbn;
import yuyu.def.db.type.UserType_C_BknrigiKbn;
import yuyu.def.db.type.UserType_C_HokenkinsyuruiKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_HubiJyoukyouKbn;
import yuyu.def.db.type.UserType_C_HushrGeninKbn;
import yuyu.def.db.type.UserType_C_NoinitUmuKbn;
import yuyu.def.db.type.UserType_C_SUketoriHouhouKbn;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_SeikyuuSyubetu;
import yuyu.def.db.type.UserType_C_SeisankinKanritukaKbn;
import yuyu.def.db.type.UserType_C_ShrKekkaKbn;
import yuyu.def.db.type.UserType_C_SiinKbn;
import yuyu.def.db.type.UserType_C_SyouhnsyuruiKbn;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 保険金給付金備金管理テーブル テーブルのマッピング情報クラスで、 {@link JT_SiBikinkanri} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SiBikinkanri}</td><td colspan="3">保険金給付金備金管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_SiBikinkanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_SiBikinkanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKessankijyunymd kessankijyunymd}</td><td>決算基準日</td><td align="center">{@link PKJT_SiBikinkanri ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getBkncdkbn bkncdkbn}</td><td>備金コード区分</td><td align="center">{@link PKJT_SiBikinkanri ○}</td><td align="center">V</td><td>{@link C_BkncdKbn}</td></tr>
 *  <tr><td>{@link #getBknkktymd bknkktymd}</td><td>備金確定日</td><td align="center">{@link PKJT_SiBikinkanri ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyuuhucd kyuuhucd}</td><td>給付コード</td><td align="center">{@link PKJT_SiBikinkanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBknrigikbn bknrigikbn}</td><td>備金例外区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BknrigiKbn}</td></tr>
 *  <tr><td>{@link #getSeikyuusyubetu seikyuusyubetu}</td><td>請求種別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SeikyuuSyubetu}</td></tr>
 *  <tr><td>{@link #getCalckijyunymd calckijyunymd}</td><td>計算基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyoruiukeymd syoruiukeymd}</td><td>書類受付日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHubikanryouymd hubikanryouymd}</td><td>不備完了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyouhnsyuruikbn syouhnsyuruikbn}</td><td>商品種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyouhnsyuruiKbn}</td></tr>
 *  <tr><td>{@link #getSyutkkbn syutkkbn}</td><td>主契約特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr><td>{@link #getSisyacd sisyacd}</td><td>支社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKbnkeirisegcd kbnkeirisegcd}</td><td>区分経理用セグメントコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyuuhuname kyuuhuname}</td><td>給付名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBkngk bkngk}</td><td>備金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKihons kihons}</td><td>基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrumu shrumu}</td><td>支払有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSinsaumukbn sinsaumukbn}</td><td>診査有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSoukiumukbn soukiumukbn}</td><td>早期有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSyoumetuumukbn syoumetuumukbn}</td><td>消滅有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHubijyoukyoukbn hubijyoukyoukbn}</td><td>不備状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HubiJyoukyouKbn}</td></tr>
 *  <tr><td>{@link #getBknjkukbn bknjkukbn}</td><td>備金時効区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BknJkuKbn}</td></tr>
 *  <tr><td>{@link #getShrsyoriymd shrsyoriymd}</td><td>支払処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getTyakkinymd tyakkinymd}</td><td>着金日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyktuukasyu kyktuukasyu}</td><td>契約通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getShrtuukasyu shrtuukasyu}</td><td>支払通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getShrgk shrgk}</td><td>支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getShrkwsratekjnymd shrkwsratekjnymd}</td><td>支払時為替レート基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrkwsrate shrkwsrate}</td><td>支払時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSitihsyutkyumaeyenhknkngk sitihsyutkyumaeyenhknkngk}</td><td>最低保証適用前円換算保険金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getInitsbjiyenkasaiteihsygk initsbjiyenkasaiteihsygk}</td><td>初期死亡時円換算最低保証額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSiboukaritrkymd siboukaritrkymd}</td><td>死亡仮受付登録日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getShrkekkakbn shrkekkakbn}</td><td>支払結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ShrKekkaKbn}</td></tr>
 *  <tr><td>{@link #getHushrgeninkbn hushrgeninkbn}</td><td>不支払原因区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HushrGeninKbn}</td></tr>
 *  <tr><td>{@link #getSiinkbn siinkbn}</td><td>死因区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SiinKbn}</td></tr>
 *  <tr><td>{@link #getKinoussnm kinoussnm}</td><td>機能詳細名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSuketorihouhoukbn suketorihouhoukbn}</td><td>保険金受取方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SUketoriHouhouKbn}</td></tr>
 *  <tr><td>{@link #getTutakngk tutakngk}</td><td>積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYentutakngk yentutakngk}</td><td>円換算積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getKaiyakuhr kaiyakuhr}</td><td>解約返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkaiyakuhr yenkaiyakuhr}</td><td>円換算解約返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGengkumukbn gengkumukbn}</td><td>減額有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NoinitUmuKbn}</td></tr>
 *  <tr><td>{@link #getGengkymd gengkymd}</td><td>減額日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getJisatumensekiumukbn jisatumensekiumukbn}</td><td>自殺免責有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSyuukeiyoubkncdkbn syuukeiyoubkncdkbn}</td><td>集計用備金コード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BkncdKbn}</td></tr>
 *  <tr><td>{@link #getHokenkinsyuruikbn hokenkinsyuruikbn}</td><td>保険金種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HokenkinsyuruiKbn}</td></tr>
 *  <tr><td>{@link #getBkntyousafsyorikbn bkntyousafsyorikbn}</td><td>備金調査ファイル処理区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BknTyousaFSyoriKbn}</td></tr>
 *  <tr><td>{@link #getBknkktinnd bknkktinnd}</td><td>備金確定年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBknkktiym bknkktiym}</td><td>備金確定年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getKykymd kykymd}</td><td>契約日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getZennouseisankinumukbn zennouseisankinumukbn}</td><td>前納精算金有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getZennouseisankgk zennouseisankgk}</td><td>前納精算金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkazennouseisankgk yenkazennouseisankgk}</td><td>円貨前納精算金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMikeikapumukbn mikeikapumukbn}</td><td>未経過保険料有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getMikeikap mikeikap}</td><td>未経過保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkamikeikap yenkamikeikap}</td><td>円貨未経過保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMisyuupumukbn misyuupumukbn}</td><td>未収保険料有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getMisyuupjyuutouym misyuupjyuutouym}</td><td>未収保険料充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getHrkp hrkp}</td><td>払込保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMisyuup misyuup}</td><td>未収保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkamisyuup yenkamisyuup}</td><td>円貨未収保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getSyonendojikaiikoup syonendojikaiikoup}</td><td>初年度次回以降Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkasyonendojikaiikoup yenkasyonendojikaiikoup}</td><td>円貨初年度次回以降Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getJinendoikoup jinendoikoup}</td><td>次年度以降Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkajinendoikoup yenkajinendoikoup}</td><td>円貨次年度以降Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getSeisankgk seisankgk}</td><td>精算金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getYenkaseisankgk yenkaseisankgk}</td><td>円貨精算金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getMsyupknrtuukakbn msyupknrtuukakbn}</td><td>未収Ｐ管理通貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SeisankinKanritukaKbn}</td></tr>
 *  <tr><td>{@link #getMikeikapknrtuukakbn mikeikapknrtuukakbn}</td><td>未経過Ｐ管理通貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SeisankinKanritukaKbn}</td></tr>
 *  <tr><td>{@link #getZnnusisnkinknrtuukakbn znnusisnkinknrtuukakbn}</td><td>前納精算金管理通貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SeisankinKanritukaKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SiBikinkanri
 * @see     PKJT_SiBikinkanri
 * @see     QJT_SiBikinkanri
 * @see     GenQJT_SiBikinkanri
 */
@MappedSuperclass
@Table(name=GenJT_SiBikinkanri.TABLE_NAME)
@IdClass(value=PKJT_SiBikinkanri.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_BknJkuKbn", typeClass=UserType_C_BknJkuKbn.class),
    @TypeDef(name="UserType_C_BknTyousaFSyoriKbn", typeClass=UserType_C_BknTyousaFSyoriKbn.class),
    @TypeDef(name="UserType_C_BkncdKbn", typeClass=UserType_C_BkncdKbn.class),
    @TypeDef(name="UserType_C_BknrigiKbn", typeClass=UserType_C_BknrigiKbn.class),
    @TypeDef(name="UserType_C_HokenkinsyuruiKbn", typeClass=UserType_C_HokenkinsyuruiKbn.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_HubiJyoukyouKbn", typeClass=UserType_C_HubiJyoukyouKbn.class),
    @TypeDef(name="UserType_C_HushrGeninKbn", typeClass=UserType_C_HushrGeninKbn.class),
    @TypeDef(name="UserType_C_NoinitUmuKbn", typeClass=UserType_C_NoinitUmuKbn.class),
    @TypeDef(name="UserType_C_SUketoriHouhouKbn", typeClass=UserType_C_SUketoriHouhouKbn.class),
    @TypeDef(name="UserType_C_Segcd", typeClass=UserType_C_Segcd.class),
    @TypeDef(name="UserType_C_SeikyuuSyubetu", typeClass=UserType_C_SeikyuuSyubetu.class),
    @TypeDef(name="UserType_C_SeisankinKanritukaKbn", typeClass=UserType_C_SeisankinKanritukaKbn.class),
    @TypeDef(name="UserType_C_ShrKekkaKbn", typeClass=UserType_C_ShrKekkaKbn.class),
    @TypeDef(name="UserType_C_SiinKbn", typeClass=UserType_C_SiinKbn.class),
    @TypeDef(name="UserType_C_SyouhnsyuruiKbn", typeClass=UserType_C_SyouhnsyuruiKbn.class),
    @TypeDef(name="UserType_C_SyutkKbn", typeClass=UserType_C_SyutkKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenJT_SiBikinkanri extends AbstractExDBEntity<JT_SiBikinkanri, PKJT_SiBikinkanri> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_SiBikinkanri";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String KESSANKIJYUNYMD          = "kessankijyunymd";
    public static final String BKNCDKBN                 = "bkncdkbn";
    public static final String BKNKKTYMD                = "bknkktymd";
    public static final String KYUUHUCD                 = "kyuuhucd";
    public static final String BKNRIGIKBN               = "bknrigikbn";
    public static final String SEIKYUUSYUBETU           = "seikyuusyubetu";
    public static final String CALCKIJYUNYMD            = "calckijyunymd";
    public static final String SYORUIUKEYMD             = "syoruiukeymd";
    public static final String HUBIKANRYOUYMD           = "hubikanryouymd";
    public static final String SYOUHNSYURUIKBN          = "syouhnsyuruikbn";
    public static final String SYUTKKBN                 = "syutkkbn";
    public static final String SISYACD                  = "sisyacd";
    public static final String KBNKEIRISEGCD            = "kbnkeirisegcd";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String KYUUHUNAME               = "kyuuhuname";
    public static final String BKNGK                    = "bkngk";
    public static final String KIHONS                   = "kihons";
    public static final String SHRUMU                   = "shrumu";
    public static final String SINSAUMUKBN              = "sinsaumukbn";
    public static final String SOUKIUMUKBN              = "soukiumukbn";
    public static final String SYOUMETUUMUKBN           = "syoumetuumukbn";
    public static final String HUBIJYOUKYOUKBN          = "hubijyoukyoukbn";
    public static final String BKNJKUKBN                = "bknjkukbn";
    public static final String SHRSYORIYMD              = "shrsyoriymd";
    public static final String TYAKKINYMD               = "tyakkinymd";
    public static final String KYKTUUKASYU              = "kyktuukasyu";
    public static final String SHRTUUKASYU              = "shrtuukasyu";
    public static final String SHRGK                    = "shrgk";
    public static final String SHRKWSRATEKJNYMD         = "shrkwsratekjnymd";
    public static final String SHRKWSRATE               = "shrkwsrate";
    public static final String SITIHSYUTKYUMAEYENHKNKNGK = "sitihsyutkyumaeyenhknkngk";
    public static final String INITSBJIYENKASAITEIHSYGK = "initsbjiyenkasaiteihsygk";
    public static final String SIBOUKARITRKYMD          = "siboukaritrkymd";
    public static final String SHRKEKKAKBN              = "shrkekkakbn";
    public static final String HUSHRGENINKBN            = "hushrgeninkbn";
    public static final String SIINKBN                  = "siinkbn";
    public static final String KINOUSSNM                = "kinoussnm";
    public static final String SUKETORIHOUHOUKBN        = "suketorihouhoukbn";
    public static final String TUTAKNGK                 = "tutakngk";
    public static final String YENTUTAKNGK              = "yentutakngk";
    public static final String KAIYAKUHR                = "kaiyakuhr";
    public static final String YENKAIYAKUHR             = "yenkaiyakuhr";
    public static final String GENGKUMUKBN              = "gengkumukbn";
    public static final String GENGKYMD                 = "gengkymd";
    public static final String JISATUMENSEKIUMUKBN      = "jisatumensekiumukbn";
    public static final String SYUUKEIYOUBKNCDKBN       = "syuukeiyoubkncdkbn";
    public static final String HOKENKINSYURUIKBN        = "hokenkinsyuruikbn";
    public static final String BKNTYOUSAFSYORIKBN       = "bkntyousafsyorikbn";
    public static final String BKNKKTINND               = "bknkktinnd";
    public static final String BKNKKTIYM                = "bknkktiym";
    public static final String KYKYMD                   = "kykymd";
    public static final String ZENNOUSEISANKINUMUKBN    = "zennouseisankinumukbn";
    public static final String ZENNOUSEISANKGK          = "zennouseisankgk";
    public static final String YENKAZENNOUSEISANKGK     = "yenkazennouseisankgk";
    public static final String MIKEIKAPUMUKBN           = "mikeikapumukbn";
    public static final String MIKEIKAP                 = "mikeikap";
    public static final String YENKAMIKEIKAP            = "yenkamikeikap";
    public static final String MISYUUPUMUKBN            = "misyuupumukbn";
    public static final String MISYUUPJYUUTOUYM         = "misyuupjyuutouym";
    public static final String HRKP                     = "hrkp";
    public static final String MISYUUP                  = "misyuup";
    public static final String YENKAMISYUUP             = "yenkamisyuup";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String SYONENDOJIKAIIKOUP       = "syonendojikaiikoup";
    public static final String YENKASYONENDOJIKAIIKOUP  = "yenkasyonendojikaiikoup";
    public static final String JINENDOIKOUP             = "jinendoikoup";
    public static final String YENKAJINENDOIKOUP        = "yenkajinendoikoup";
    public static final String SEISANKGK                = "seisankgk";
    public static final String YENKASEISANKGK           = "yenkaseisankgk";
    public static final String MSYUPKNRTUUKAKBN         = "msyupknrtuukakbn";
    public static final String MIKEIKAPKNRTUUKAKBN      = "mikeikapknrtuukakbn";
    public static final String ZNNUSISNKINKNRTUUKAKBN   = "znnusisnkinknrtuukakbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_SiBikinkanri primaryKey;

    public GenJT_SiBikinkanri() {
        primaryKey = new PKJT_SiBikinkanri();
    }

    public GenJT_SiBikinkanri(
        String pSkno,
        String pSyono,
        BizDate pKessankijyunymd,
        C_BkncdKbn pBkncdkbn,
        BizDate pBknkktymd,
        String pKyuuhucd
    ) {
        primaryKey = new PKJT_SiBikinkanri(
            pSkno,
            pSyono,
            pKessankijyunymd,
            pBkncdkbn,
            pBknkktymd,
            pKyuuhucd
        );
    }

    @Transient
    @Override
    public PKJT_SiBikinkanri getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_SiBikinkanri> getMetaClass() {
        return QJT_SiBikinkanri.class;
    }

    @Id
    @Column(name=GenJT_SiBikinkanri.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_SiBikinkanri.SYONO)
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
    @Column(name=GenJT_SiBikinkanri.KESSANKIJYUNYMD)
    @ValidDate
    public BizDate getKessankijyunymd() {
        return getPrimaryKey().getKessankijyunymd();
    }

    @Trim("both")
    public void setKessankijyunymd(BizDate pKessankijyunymd) {
        getPrimaryKey().setKessankijyunymd(pKessankijyunymd);
    }

    @Id
    @Type(type="UserType_C_BkncdKbn")
    @Column(name=GenJT_SiBikinkanri.BKNCDKBN)
    public C_BkncdKbn getBkncdkbn() {
        return getPrimaryKey().getBkncdkbn();
    }

    public void setBkncdkbn(C_BkncdKbn pBkncdkbn) {
        getPrimaryKey().setBkncdkbn(pBkncdkbn);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenJT_SiBikinkanri.BKNKKTYMD)
    @ValidDate
    public BizDate getBknkktymd() {
        return getPrimaryKey().getBknkktymd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBknkktymd(BizDate pBknkktymd) {
        getPrimaryKey().setBknkktymd(pBknkktymd);
    }

    @Id
    @Column(name=GenJT_SiBikinkanri.KYUUHUCD)
    public String getKyuuhucd() {
        return getPrimaryKey().getKyuuhucd();
    }

    public void setKyuuhucd(String pKyuuhucd) {
        getPrimaryKey().setKyuuhucd(pKyuuhucd);
    }

    private C_BknrigiKbn bknrigikbn;

    @Type(type="UserType_C_BknrigiKbn")
    @Column(name=GenJT_SiBikinkanri.BKNRIGIKBN)
    public C_BknrigiKbn getBknrigikbn() {
        return bknrigikbn;
    }

    public void setBknrigikbn(C_BknrigiKbn pBknrigikbn) {
        bknrigikbn = pBknrigikbn;
    }

    private C_SeikyuuSyubetu seikyuusyubetu;

    @Type(type="UserType_C_SeikyuuSyubetu")
    @Column(name=GenJT_SiBikinkanri.SEIKYUUSYUBETU)
    public C_SeikyuuSyubetu getSeikyuusyubetu() {
        return seikyuusyubetu;
    }

    public void setSeikyuusyubetu(C_SeikyuuSyubetu pSeikyuusyubetu) {
        seikyuusyubetu = pSeikyuusyubetu;
    }

    private BizDate calckijyunymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiBikinkanri.CALCKIJYUNYMD)
    @ValidDate
    public BizDate getCalckijyunymd() {
        return calckijyunymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCalckijyunymd(BizDate pCalckijyunymd) {
        calckijyunymd = pCalckijyunymd;
    }

    private BizDate syoruiukeymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiBikinkanri.SYORUIUKEYMD)
    @ValidDate
    public BizDate getSyoruiukeymd() {
        return syoruiukeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoruiukeymd(BizDate pSyoruiukeymd) {
        syoruiukeymd = pSyoruiukeymd;
    }

    private BizDate hubikanryouymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiBikinkanri.HUBIKANRYOUYMD)
    @ValidDate
    public BizDate getHubikanryouymd() {
        return hubikanryouymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHubikanryouymd(BizDate pHubikanryouymd) {
        hubikanryouymd = pHubikanryouymd;
    }

    private C_SyouhnsyuruiKbn syouhnsyuruikbn;

    @Type(type="UserType_C_SyouhnsyuruiKbn")
    @Column(name=GenJT_SiBikinkanri.SYOUHNSYURUIKBN)
    public C_SyouhnsyuruiKbn getSyouhnsyuruikbn() {
        return syouhnsyuruikbn;
    }

    public void setSyouhnsyuruikbn(C_SyouhnsyuruiKbn pSyouhnsyuruikbn) {
        syouhnsyuruikbn = pSyouhnsyuruikbn;
    }

    private C_SyutkKbn syutkkbn;

    @Type(type="UserType_C_SyutkKbn")
    @Column(name=GenJT_SiBikinkanri.SYUTKKBN)
    public C_SyutkKbn getSyutkkbn() {
        return syutkkbn;
    }

    public void setSyutkkbn(C_SyutkKbn pSyutkkbn) {
        syutkkbn = pSyutkkbn;
    }

    private String sisyacd;

    @Column(name=GenJT_SiBikinkanri.SISYACD)
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

    private C_Segcd kbnkeirisegcd;

    @Type(type="UserType_C_Segcd")
    @Column(name=GenJT_SiBikinkanri.KBNKEIRISEGCD)
    public C_Segcd getKbnkeirisegcd() {
        return kbnkeirisegcd;
    }

    public void setKbnkeirisegcd(C_Segcd pKbnkeirisegcd) {
        kbnkeirisegcd = pKbnkeirisegcd;
    }

    private String syouhncd;

    @Column(name=GenJT_SiBikinkanri.SYOUHNCD)
    @MaxLength(max=4)
    @SingleByteStrings
    public String getSyouhncd() {
        return syouhncd;
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }

    private String kyuuhuname;

    @Column(name=GenJT_SiBikinkanri.KYUUHUNAME)
    public String getKyuuhuname() {
        return kyuuhuname;
    }

    public void setKyuuhuname(String pKyuuhuname) {
        kyuuhuname = pKyuuhuname;
    }

    private BizCurrency bkngk;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    public BizCurrency getBkngk() {
        return bkngk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBkngk(BizCurrency pBkngk) {
        bkngk = pBkngk;
        bkngkValue = null;
        bkngkType  = null;
    }

    transient private BigDecimal bkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=BKNGK, nullable=true)
    protected BigDecimal getBkngkValue() {
        if (bkngkValue == null && bkngk != null) {
            if (bkngk.isOptional()) return null;
            return bkngk.absolute();
        }
        return bkngkValue;
    }

    protected void setBkngkValue(BigDecimal value) {
        bkngkValue = value;
        bkngk = Optional.fromNullable(toCurrencyType(bkngkType))
            .transform(bizCurrencyTransformer(getBkngkValue()))
            .orNull();
    }

    transient private String bkngkType = null;

    @Column(name=BKNGK + "$", nullable=true)
    protected String getBkngkType() {
        if (bkngkType == null && bkngk != null) return bkngk.getType().toString();
        if (bkngkType == null && getBkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'bkngk$' should not be NULL."));
        }
        return bkngkType;
    }

    protected void setBkngkType(String type) {
        bkngkType = type;
        bkngk = Optional.fromNullable(toCurrencyType(bkngkType))
            .transform(bizCurrencyTransformer(getBkngkValue()))
            .orNull();
    }

    private BizCurrency kihons;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    public BizCurrency getKihons() {
        return kihons;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKihons(BizCurrency pKihons) {
        kihons = pKihons;
        kihonsValue = null;
        kihonsType  = null;
    }

    transient private BigDecimal kihonsValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KIHONS, nullable=true)
    protected BigDecimal getKihonsValue() {
        if (kihonsValue == null && kihons != null) {
            if (kihons.isOptional()) return null;
            return kihons.absolute();
        }
        return kihonsValue;
    }

    protected void setKihonsValue(BigDecimal value) {
        kihonsValue = value;
        kihons = Optional.fromNullable(toCurrencyType(kihonsType))
            .transform(bizCurrencyTransformer(getKihonsValue()))
            .orNull();
    }

    transient private String kihonsType = null;

    @Column(name=KIHONS + "$", nullable=true)
    protected String getKihonsType() {
        if (kihonsType == null && kihons != null) return kihons.getType().toString();
        if (kihonsType == null && getKihonsValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kihons$' should not be NULL."));
        }
        return kihonsType;
    }

    protected void setKihonsType(String type) {
        kihonsType = type;
        kihons = Optional.fromNullable(toCurrencyType(kihonsType))
            .transform(bizCurrencyTransformer(getKihonsValue()))
            .orNull();
    }

    private C_UmuKbn shrumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SiBikinkanri.SHRUMU)
    public C_UmuKbn getShrumu() {
        return shrumu;
    }

    public void setShrumu(C_UmuKbn pShrumu) {
        shrumu = pShrumu;
    }

    private C_UmuKbn sinsaumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SiBikinkanri.SINSAUMUKBN)
    public C_UmuKbn getSinsaumukbn() {
        return sinsaumukbn;
    }

    public void setSinsaumukbn(C_UmuKbn pSinsaumukbn) {
        sinsaumukbn = pSinsaumukbn;
    }

    private C_UmuKbn soukiumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SiBikinkanri.SOUKIUMUKBN)
    public C_UmuKbn getSoukiumukbn() {
        return soukiumukbn;
    }

    public void setSoukiumukbn(C_UmuKbn pSoukiumukbn) {
        soukiumukbn = pSoukiumukbn;
    }

    private C_UmuKbn syoumetuumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SiBikinkanri.SYOUMETUUMUKBN)
    public C_UmuKbn getSyoumetuumukbn() {
        return syoumetuumukbn;
    }

    public void setSyoumetuumukbn(C_UmuKbn pSyoumetuumukbn) {
        syoumetuumukbn = pSyoumetuumukbn;
    }

    private C_HubiJyoukyouKbn hubijyoukyoukbn;

    @Type(type="UserType_C_HubiJyoukyouKbn")
    @Column(name=GenJT_SiBikinkanri.HUBIJYOUKYOUKBN)
    public C_HubiJyoukyouKbn getHubijyoukyoukbn() {
        return hubijyoukyoukbn;
    }

    public void setHubijyoukyoukbn(C_HubiJyoukyouKbn pHubijyoukyoukbn) {
        hubijyoukyoukbn = pHubijyoukyoukbn;
    }

    private C_BknJkuKbn bknjkukbn;

    @Type(type="UserType_C_BknJkuKbn")
    @Column(name=GenJT_SiBikinkanri.BKNJKUKBN)
    public C_BknJkuKbn getBknjkukbn() {
        return bknjkukbn;
    }

    public void setBknjkukbn(C_BknJkuKbn pBknjkukbn) {
        bknjkukbn = pBknjkukbn;
    }

    private BizDate shrsyoriymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiBikinkanri.SHRSYORIYMD)
    @ValidDate
    public BizDate getShrsyoriymd() {
        return shrsyoriymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrsyoriymd(BizDate pShrsyoriymd) {
        shrsyoriymd = pShrsyoriymd;
    }

    private BizDate tyakkinymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiBikinkanri.TYAKKINYMD)
    @ValidDate
    public BizDate getTyakkinymd() {
        return tyakkinymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyakkinymd(BizDate pTyakkinymd) {
        tyakkinymd = pTyakkinymd;
    }

    private C_Tuukasyu kyktuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenJT_SiBikinkanri.KYKTUUKASYU)
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    private C_Tuukasyu shrtuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenJT_SiBikinkanri.SHRTUUKASYU)
    public C_Tuukasyu getShrtuukasyu() {
        return shrtuukasyu;
    }

    public void setShrtuukasyu(C_Tuukasyu pShrtuukasyu) {
        shrtuukasyu = pShrtuukasyu;
    }

    private BizCurrency shrgk;

    @Type(type="BizCurrencyType")
    @Transient
    @CurrencyLenght(length=13)
    @PositiveNumberBizCalcble
    public BizCurrency getShrgk() {
        return shrgk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setShrgk(BizCurrency pShrgk) {
        shrgk = pShrgk;
        shrgkValue = null;
        shrgkType  = null;
    }

    transient private BigDecimal shrgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SHRGK, nullable=true)
    protected BigDecimal getShrgkValue() {
        if (shrgkValue == null && shrgk != null) {
            if (shrgk.isOptional()) return null;
            return shrgk.absolute();
        }
        return shrgkValue;
    }

    protected void setShrgkValue(BigDecimal value) {
        shrgkValue = value;
        shrgk = Optional.fromNullable(toCurrencyType(shrgkType))
            .transform(bizCurrencyTransformer(getShrgkValue()))
            .orNull();
    }

    transient private String shrgkType = null;

    @Column(name=SHRGK + "$", nullable=true)
    protected String getShrgkType() {
        if (shrgkType == null && shrgk != null) return shrgk.getType().toString();
        if (shrgkType == null && getShrgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'shrgk$' should not be NULL."));
        }
        return shrgkType;
    }

    protected void setShrgkType(String type) {
        shrgkType = type;
        shrgk = Optional.fromNullable(toCurrencyType(shrgkType))
            .transform(bizCurrencyTransformer(getShrgkValue()))
            .orNull();
    }

    private BizDate shrkwsratekjnymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiBikinkanri.SHRKWSRATEKJNYMD)
    public BizDate getShrkwsratekjnymd() {
        return shrkwsratekjnymd;
    }

    public void setShrkwsratekjnymd(BizDate pShrkwsratekjnymd) {
        shrkwsratekjnymd = pShrkwsratekjnymd;
    }

    private BizNumber shrkwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenJT_SiBikinkanri.SHRKWSRATE)
    public BizNumber getShrkwsrate() {
        return shrkwsrate;
    }

    public void setShrkwsrate(BizNumber pShrkwsrate) {
        shrkwsrate = pShrkwsrate;
    }

    private BizCurrency sitihsyutkyumaeyenhknkngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSitihsyutkyumaeyenhknkngk() {
        return sitihsyutkyumaeyenhknkngk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSitihsyutkyumaeyenhknkngk(BizCurrency pSitihsyutkyumaeyenhknkngk) {
        sitihsyutkyumaeyenhknkngk = pSitihsyutkyumaeyenhknkngk;
        sitihsyutkyumaeyenhknkngkValue = null;
        sitihsyutkyumaeyenhknkngkType  = null;
    }

    transient private BigDecimal sitihsyutkyumaeyenhknkngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SITIHSYUTKYUMAEYENHKNKNGK, nullable=true)
    protected BigDecimal getSitihsyutkyumaeyenhknkngkValue() {
        if (sitihsyutkyumaeyenhknkngkValue == null && sitihsyutkyumaeyenhknkngk != null) {
            if (sitihsyutkyumaeyenhknkngk.isOptional()) return null;
            return sitihsyutkyumaeyenhknkngk.absolute();
        }
        return sitihsyutkyumaeyenhknkngkValue;
    }

    protected void setSitihsyutkyumaeyenhknkngkValue(BigDecimal value) {
        sitihsyutkyumaeyenhknkngkValue = value;
        sitihsyutkyumaeyenhknkngk = Optional.fromNullable(toCurrencyType(sitihsyutkyumaeyenhknkngkType))
            .transform(bizCurrencyTransformer(getSitihsyutkyumaeyenhknkngkValue()))
            .orNull();
    }

    transient private String sitihsyutkyumaeyenhknkngkType = null;

    @Column(name=SITIHSYUTKYUMAEYENHKNKNGK + "$", nullable=true)
    protected String getSitihsyutkyumaeyenhknkngkType() {
        if (sitihsyutkyumaeyenhknkngkType == null && sitihsyutkyumaeyenhknkngk != null) return sitihsyutkyumaeyenhknkngk.getType().toString();
        if (sitihsyutkyumaeyenhknkngkType == null && getSitihsyutkyumaeyenhknkngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'sitihsyutkyumaeyenhknkngk$' should not be NULL."));
        }
        return sitihsyutkyumaeyenhknkngkType;
    }

    protected void setSitihsyutkyumaeyenhknkngkType(String type) {
        sitihsyutkyumaeyenhknkngkType = type;
        sitihsyutkyumaeyenhknkngk = Optional.fromNullable(toCurrencyType(sitihsyutkyumaeyenhknkngkType))
            .transform(bizCurrencyTransformer(getSitihsyutkyumaeyenhknkngkValue()))
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

    private BizDate siboukaritrkymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiBikinkanri.SIBOUKARITRKYMD)
    @ValidDate
    public BizDate getSiboukaritrkymd() {
        return siboukaritrkymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSiboukaritrkymd(BizDate pSiboukaritrkymd) {
        siboukaritrkymd = pSiboukaritrkymd;
    }

    private C_ShrKekkaKbn shrkekkakbn;

    @Type(type="UserType_C_ShrKekkaKbn")
    @Column(name=GenJT_SiBikinkanri.SHRKEKKAKBN)
    public C_ShrKekkaKbn getShrkekkakbn() {
        return shrkekkakbn;
    }

    public void setShrkekkakbn(C_ShrKekkaKbn pShrkekkakbn) {
        shrkekkakbn = pShrkekkakbn;
    }

    private C_HushrGeninKbn hushrgeninkbn;

    @Type(type="UserType_C_HushrGeninKbn")
    @Column(name=GenJT_SiBikinkanri.HUSHRGENINKBN)
    public C_HushrGeninKbn getHushrgeninkbn() {
        return hushrgeninkbn;
    }

    public void setHushrgeninkbn(C_HushrGeninKbn pHushrgeninkbn) {
        hushrgeninkbn = pHushrgeninkbn;
    }

    private C_SiinKbn siinkbn;

    @Type(type="UserType_C_SiinKbn")
    @Column(name=GenJT_SiBikinkanri.SIINKBN)
    public C_SiinKbn getSiinkbn() {
        return siinkbn;
    }

    public void setSiinkbn(C_SiinKbn pSiinkbn) {
        siinkbn = pSiinkbn;
    }

    private String kinoussnm;

    @Column(name=GenJT_SiBikinkanri.KINOUSSNM)
    public String getKinoussnm() {
        return kinoussnm;
    }

    public void setKinoussnm(String pKinoussnm) {
        kinoussnm = pKinoussnm;
    }

    private C_SUketoriHouhouKbn suketorihouhoukbn;

    @Type(type="UserType_C_SUketoriHouhouKbn")
    @Column(name=GenJT_SiBikinkanri.SUKETORIHOUHOUKBN)
    public C_SUketoriHouhouKbn getSuketorihouhoukbn() {
        return suketorihouhoukbn;
    }

    public void setSuketorihouhoukbn(C_SUketoriHouhouKbn pSuketorihouhoukbn) {
        suketorihouhoukbn = pSuketorihouhoukbn;
    }

    private BizCurrency tutakngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTutakngk() {
        return tutakngk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTutakngk(BizCurrency pTutakngk) {
        tutakngk = pTutakngk;
        tutakngkValue = null;
        tutakngkType  = null;
    }

    transient private BigDecimal tutakngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TUTAKNGK, nullable=true)
    protected BigDecimal getTutakngkValue() {
        if (tutakngkValue == null && tutakngk != null) {
            if (tutakngk.isOptional()) return null;
            return tutakngk.absolute();
        }
        return tutakngkValue;
    }

    protected void setTutakngkValue(BigDecimal value) {
        tutakngkValue = value;
        tutakngk = Optional.fromNullable(toCurrencyType(tutakngkType))
            .transform(bizCurrencyTransformer(getTutakngkValue()))
            .orNull();
    }

    transient private String tutakngkType = null;

    @Column(name=TUTAKNGK + "$", nullable=true)
    protected String getTutakngkType() {
        if (tutakngkType == null && tutakngk != null) return tutakngk.getType().toString();
        if (tutakngkType == null && getTutakngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tutakngk$' should not be NULL."));
        }
        return tutakngkType;
    }

    protected void setTutakngkType(String type) {
        tutakngkType = type;
        tutakngk = Optional.fromNullable(toCurrencyType(tutakngkType))
            .transform(bizCurrencyTransformer(getTutakngkValue()))
            .orNull();
    }

    private BizCurrency yentutakngk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYentutakngk() {
        return yentutakngk;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYentutakngk(BizCurrency pYentutakngk) {
        yentutakngk = pYentutakngk;
        yentutakngkValue = null;
        yentutakngkType  = null;
    }

    transient private BigDecimal yentutakngkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENTUTAKNGK, nullable=true)
    protected BigDecimal getYentutakngkValue() {
        if (yentutakngkValue == null && yentutakngk != null) {
            if (yentutakngk.isOptional()) return null;
            return yentutakngk.absolute();
        }
        return yentutakngkValue;
    }

    protected void setYentutakngkValue(BigDecimal value) {
        yentutakngkValue = value;
        yentutakngk = Optional.fromNullable(toCurrencyType(yentutakngkType))
            .transform(bizCurrencyTransformer(getYentutakngkValue()))
            .orNull();
    }

    transient private String yentutakngkType = null;

    @Column(name=YENTUTAKNGK + "$", nullable=true)
    protected String getYentutakngkType() {
        if (yentutakngkType == null && yentutakngk != null) return yentutakngk.getType().toString();
        if (yentutakngkType == null && getYentutakngkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yentutakngk$' should not be NULL."));
        }
        return yentutakngkType;
    }

    protected void setYentutakngkType(String type) {
        yentutakngkType = type;
        yentutakngk = Optional.fromNullable(toCurrencyType(yentutakngkType))
            .transform(bizCurrencyTransformer(getYentutakngkValue()))
            .orNull();
    }

    private BizCurrency kaiyakuhr;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getKaiyakuhr() {
        return kaiyakuhr;
    }

    public void setKaiyakuhr(BizCurrency pKaiyakuhr) {
        kaiyakuhr = pKaiyakuhr;
        kaiyakuhrValue = null;
        kaiyakuhrType  = null;
    }

    transient private BigDecimal kaiyakuhrValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=KAIYAKUHR, nullable=true)
    protected BigDecimal getKaiyakuhrValue() {
        if (kaiyakuhrValue == null && kaiyakuhr != null) {
            if (kaiyakuhr.isOptional()) return null;
            return kaiyakuhr.absolute();
        }
        return kaiyakuhrValue;
    }

    protected void setKaiyakuhrValue(BigDecimal value) {
        kaiyakuhrValue = value;
        kaiyakuhr = Optional.fromNullable(toCurrencyType(kaiyakuhrType))
            .transform(bizCurrencyTransformer(getKaiyakuhrValue()))
            .orNull();
    }

    transient private String kaiyakuhrType = null;

    @Column(name=KAIYAKUHR + "$", nullable=true)
    protected String getKaiyakuhrType() {
        if (kaiyakuhrType == null && kaiyakuhr != null) return kaiyakuhr.getType().toString();
        if (kaiyakuhrType == null && getKaiyakuhrValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'kaiyakuhr$' should not be NULL."));
        }
        return kaiyakuhrType;
    }

    protected void setKaiyakuhrType(String type) {
        kaiyakuhrType = type;
        kaiyakuhr = Optional.fromNullable(toCurrencyType(kaiyakuhrType))
            .transform(bizCurrencyTransformer(getKaiyakuhrValue()))
            .orNull();
    }

    private BizCurrency yenkaiyakuhr;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkaiyakuhr() {
        return yenkaiyakuhr;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkaiyakuhr(BizCurrency pYenkaiyakuhr) {
        yenkaiyakuhr = pYenkaiyakuhr;
        yenkaiyakuhrValue = null;
        yenkaiyakuhrType  = null;
    }

    transient private BigDecimal yenkaiyakuhrValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKAIYAKUHR, nullable=true)
    protected BigDecimal getYenkaiyakuhrValue() {
        if (yenkaiyakuhrValue == null && yenkaiyakuhr != null) {
            if (yenkaiyakuhr.isOptional()) return null;
            return yenkaiyakuhr.absolute();
        }
        return yenkaiyakuhrValue;
    }

    protected void setYenkaiyakuhrValue(BigDecimal value) {
        yenkaiyakuhrValue = value;
        yenkaiyakuhr = Optional.fromNullable(toCurrencyType(yenkaiyakuhrType))
            .transform(bizCurrencyTransformer(getYenkaiyakuhrValue()))
            .orNull();
    }

    transient private String yenkaiyakuhrType = null;

    @Column(name=YENKAIYAKUHR + "$", nullable=true)
    protected String getYenkaiyakuhrType() {
        if (yenkaiyakuhrType == null && yenkaiyakuhr != null) return yenkaiyakuhr.getType().toString();
        if (yenkaiyakuhrType == null && getYenkaiyakuhrValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkaiyakuhr$' should not be NULL."));
        }
        return yenkaiyakuhrType;
    }

    protected void setYenkaiyakuhrType(String type) {
        yenkaiyakuhrType = type;
        yenkaiyakuhr = Optional.fromNullable(toCurrencyType(yenkaiyakuhrType))
            .transform(bizCurrencyTransformer(getYenkaiyakuhrValue()))
            .orNull();
    }

    private C_NoinitUmuKbn gengkumukbn;

    @Type(type="UserType_C_NoinitUmuKbn")
    @Column(name=GenJT_SiBikinkanri.GENGKUMUKBN)
    public C_NoinitUmuKbn getGengkumukbn() {
        return gengkumukbn;
    }

    public void setGengkumukbn(C_NoinitUmuKbn pGengkumukbn) {
        gengkumukbn = pGengkumukbn;
    }

    private BizDate gengkymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiBikinkanri.GENGKYMD)
    @ValidDate
    public BizDate getGengkymd() {
        return gengkymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setGengkymd(BizDate pGengkymd) {
        gengkymd = pGengkymd;
    }

    private C_UmuKbn jisatumensekiumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SiBikinkanri.JISATUMENSEKIUMUKBN)
    public C_UmuKbn getJisatumensekiumukbn() {
        return jisatumensekiumukbn;
    }

    public void setJisatumensekiumukbn(C_UmuKbn pJisatumensekiumukbn) {
        jisatumensekiumukbn = pJisatumensekiumukbn;
    }

    private C_BkncdKbn syuukeiyoubkncdkbn;

    @Type(type="UserType_C_BkncdKbn")
    @Column(name=GenJT_SiBikinkanri.SYUUKEIYOUBKNCDKBN)
    public C_BkncdKbn getSyuukeiyoubkncdkbn() {
        return syuukeiyoubkncdkbn;
    }

    public void setSyuukeiyoubkncdkbn(C_BkncdKbn pSyuukeiyoubkncdkbn) {
        syuukeiyoubkncdkbn = pSyuukeiyoubkncdkbn;
    }

    private C_HokenkinsyuruiKbn hokenkinsyuruikbn;

    @Type(type="UserType_C_HokenkinsyuruiKbn")
    @Column(name=GenJT_SiBikinkanri.HOKENKINSYURUIKBN)
    public C_HokenkinsyuruiKbn getHokenkinsyuruikbn() {
        return hokenkinsyuruikbn;
    }

    public void setHokenkinsyuruikbn(C_HokenkinsyuruiKbn pHokenkinsyuruikbn) {
        hokenkinsyuruikbn = pHokenkinsyuruikbn;
    }

    private C_BknTyousaFSyoriKbn bkntyousafsyorikbn;

    @Type(type="UserType_C_BknTyousaFSyoriKbn")
    @Column(name=GenJT_SiBikinkanri.BKNTYOUSAFSYORIKBN)
    public C_BknTyousaFSyoriKbn getBkntyousafsyorikbn() {
        return bkntyousafsyorikbn;
    }

    public void setBkntyousafsyorikbn(C_BknTyousaFSyoriKbn pBkntyousafsyorikbn) {
        bkntyousafsyorikbn = pBkntyousafsyorikbn;
    }

    private String bknkktinnd;

    @Column(name=GenJT_SiBikinkanri.BKNKKTINND)
    public String getBknkktinnd() {
        return bknkktinnd;
    }

    public void setBknkktinnd(String pBknkktinnd) {
        bknkktinnd = pBknkktinnd;
    }

    private BizDateYM bknkktiym;

    @Type(type="BizDateYMType")
    @Column(name=GenJT_SiBikinkanri.BKNKKTIYM)
    public BizDateYM getBknkktiym() {
        return bknkktiym;
    }

    public void setBknkktiym(BizDateYM pBknkktiym) {
        bknkktiym = pBknkktiym;
    }

    private BizDate kykymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SiBikinkanri.KYKYMD)
    public BizDate getKykymd() {
        return kykymd;
    }

    @Trim("both")
    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }

    private C_UmuKbn zennouseisankinumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SiBikinkanri.ZENNOUSEISANKINUMUKBN)
    public C_UmuKbn getZennouseisankinumukbn() {
        return zennouseisankinumukbn;
    }

    public void setZennouseisankinumukbn(C_UmuKbn pZennouseisankinumukbn) {
        zennouseisankinumukbn = pZennouseisankinumukbn;
    }

    private BizCurrency zennouseisankgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getZennouseisankgk() {
        return zennouseisankgk;
    }

    public void setZennouseisankgk(BizCurrency pZennouseisankgk) {
        zennouseisankgk = pZennouseisankgk;
        zennouseisankgkValue = null;
        zennouseisankgkType  = null;
    }

    transient private BigDecimal zennouseisankgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=ZENNOUSEISANKGK, nullable=true)
    protected BigDecimal getZennouseisankgkValue() {
        if (zennouseisankgkValue == null && zennouseisankgk != null) {
            if (zennouseisankgk.isOptional()) return null;
            return zennouseisankgk.absolute();
        }
        return zennouseisankgkValue;
    }

    protected void setZennouseisankgkValue(BigDecimal value) {
        zennouseisankgkValue = value;
        zennouseisankgk = Optional.fromNullable(toCurrencyType(zennouseisankgkType))
            .transform(bizCurrencyTransformer(getZennouseisankgkValue()))
            .orNull();
    }

    transient private String zennouseisankgkType = null;

    @Column(name=ZENNOUSEISANKGK + "$", nullable=true)
    protected String getZennouseisankgkType() {
        if (zennouseisankgkType == null && zennouseisankgk != null) return zennouseisankgk.getType().toString();
        if (zennouseisankgkType == null && getZennouseisankgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'zennouseisankgk$' should not be NULL."));
        }
        return zennouseisankgkType;
    }

    protected void setZennouseisankgkType(String type) {
        zennouseisankgkType = type;
        zennouseisankgk = Optional.fromNullable(toCurrencyType(zennouseisankgkType))
            .transform(bizCurrencyTransformer(getZennouseisankgkValue()))
            .orNull();
    }

    private BizCurrency yenkazennouseisankgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkazennouseisankgk() {
        return yenkazennouseisankgk;
    }

    public void setYenkazennouseisankgk(BizCurrency pYenkazennouseisankgk) {
        yenkazennouseisankgk = pYenkazennouseisankgk;
        yenkazennouseisankgkValue = null;
        yenkazennouseisankgkType  = null;
    }

    transient private BigDecimal yenkazennouseisankgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKAZENNOUSEISANKGK, nullable=true)
    protected BigDecimal getYenkazennouseisankgkValue() {
        if (yenkazennouseisankgkValue == null && yenkazennouseisankgk != null) {
            if (yenkazennouseisankgk.isOptional()) return null;
            return yenkazennouseisankgk.absolute();
        }
        return yenkazennouseisankgkValue;
    }

    protected void setYenkazennouseisankgkValue(BigDecimal value) {
        yenkazennouseisankgkValue = value;
        yenkazennouseisankgk = Optional.fromNullable(toCurrencyType(yenkazennouseisankgkType))
            .transform(bizCurrencyTransformer(getYenkazennouseisankgkValue()))
            .orNull();
    }

    transient private String yenkazennouseisankgkType = null;

    @Column(name=YENKAZENNOUSEISANKGK + "$", nullable=true)
    protected String getYenkazennouseisankgkType() {
        if (yenkazennouseisankgkType == null && yenkazennouseisankgk != null) return yenkazennouseisankgk.getType().toString();
        if (yenkazennouseisankgkType == null && getYenkazennouseisankgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkazennouseisankgk$' should not be NULL."));
        }
        return yenkazennouseisankgkType;
    }

    protected void setYenkazennouseisankgkType(String type) {
        yenkazennouseisankgkType = type;
        yenkazennouseisankgk = Optional.fromNullable(toCurrencyType(yenkazennouseisankgkType))
            .transform(bizCurrencyTransformer(getYenkazennouseisankgkValue()))
            .orNull();
    }

    private C_UmuKbn mikeikapumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SiBikinkanri.MIKEIKAPUMUKBN)
    public C_UmuKbn getMikeikapumukbn() {
        return mikeikapumukbn;
    }

    public void setMikeikapumukbn(C_UmuKbn pMikeikapumukbn) {
        mikeikapumukbn = pMikeikapumukbn;
    }

    private BizCurrency mikeikap;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMikeikap() {
        return mikeikap;
    }

    public void setMikeikap(BizCurrency pMikeikap) {
        mikeikap = pMikeikap;
        mikeikapValue = null;
        mikeikapType  = null;
    }

    transient private BigDecimal mikeikapValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MIKEIKAP, nullable=true)
    protected BigDecimal getMikeikapValue() {
        if (mikeikapValue == null && mikeikap != null) {
            if (mikeikap.isOptional()) return null;
            return mikeikap.absolute();
        }
        return mikeikapValue;
    }

    protected void setMikeikapValue(BigDecimal value) {
        mikeikapValue = value;
        mikeikap = Optional.fromNullable(toCurrencyType(mikeikapType))
            .transform(bizCurrencyTransformer(getMikeikapValue()))
            .orNull();
    }

    transient private String mikeikapType = null;

    @Column(name=MIKEIKAP + "$", nullable=true)
    protected String getMikeikapType() {
        if (mikeikapType == null && mikeikap != null) return mikeikap.getType().toString();
        if (mikeikapType == null && getMikeikapValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'mikeikap$' should not be NULL."));
        }
        return mikeikapType;
    }

    protected void setMikeikapType(String type) {
        mikeikapType = type;
        mikeikap = Optional.fromNullable(toCurrencyType(mikeikapType))
            .transform(bizCurrencyTransformer(getMikeikapValue()))
            .orNull();
    }

    private BizCurrency yenkamikeikap;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkamikeikap() {
        return yenkamikeikap;
    }

    public void setYenkamikeikap(BizCurrency pYenkamikeikap) {
        yenkamikeikap = pYenkamikeikap;
        yenkamikeikapValue = null;
        yenkamikeikapType  = null;
    }

    transient private BigDecimal yenkamikeikapValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKAMIKEIKAP, nullable=true)
    protected BigDecimal getYenkamikeikapValue() {
        if (yenkamikeikapValue == null && yenkamikeikap != null) {
            if (yenkamikeikap.isOptional()) return null;
            return yenkamikeikap.absolute();
        }
        return yenkamikeikapValue;
    }

    protected void setYenkamikeikapValue(BigDecimal value) {
        yenkamikeikapValue = value;
        yenkamikeikap = Optional.fromNullable(toCurrencyType(yenkamikeikapType))
            .transform(bizCurrencyTransformer(getYenkamikeikapValue()))
            .orNull();
    }

    transient private String yenkamikeikapType = null;

    @Column(name=YENKAMIKEIKAP + "$", nullable=true)
    protected String getYenkamikeikapType() {
        if (yenkamikeikapType == null && yenkamikeikap != null) return yenkamikeikap.getType().toString();
        if (yenkamikeikapType == null && getYenkamikeikapValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkamikeikap$' should not be NULL."));
        }
        return yenkamikeikapType;
    }

    protected void setYenkamikeikapType(String type) {
        yenkamikeikapType = type;
        yenkamikeikap = Optional.fromNullable(toCurrencyType(yenkamikeikapType))
            .transform(bizCurrencyTransformer(getYenkamikeikapValue()))
            .orNull();
    }

    private C_UmuKbn misyuupumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJT_SiBikinkanri.MISYUUPUMUKBN)
    public C_UmuKbn getMisyuupumukbn() {
        return misyuupumukbn;
    }

    public void setMisyuupumukbn(C_UmuKbn pMisyuupumukbn) {
        misyuupumukbn = pMisyuupumukbn;
    }

    private BizDateYM misyuupjyuutouym;

    @Type(type="BizDateYMType")
    @Column(name=GenJT_SiBikinkanri.MISYUUPJYUUTOUYM)
    public BizDateYM getMisyuupjyuutouym() {
        return misyuupjyuutouym;
    }

    public void setMisyuupjyuutouym(BizDateYM pMisyuupjyuutouym) {
        misyuupjyuutouym = pMisyuupjyuutouym;
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

    private BizCurrency misyuup;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getMisyuup() {
        return misyuup;
    }

    public void setMisyuup(BizCurrency pMisyuup) {
        misyuup = pMisyuup;
        misyuupValue = null;
        misyuupType  = null;
    }

    transient private BigDecimal misyuupValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=MISYUUP, nullable=true)
    protected BigDecimal getMisyuupValue() {
        if (misyuupValue == null && misyuup != null) {
            if (misyuup.isOptional()) return null;
            return misyuup.absolute();
        }
        return misyuupValue;
    }

    protected void setMisyuupValue(BigDecimal value) {
        misyuupValue = value;
        misyuup = Optional.fromNullable(toCurrencyType(misyuupType))
            .transform(bizCurrencyTransformer(getMisyuupValue()))
            .orNull();
    }

    transient private String misyuupType = null;

    @Column(name=MISYUUP + "$", nullable=true)
    protected String getMisyuupType() {
        if (misyuupType == null && misyuup != null) return misyuup.getType().toString();
        if (misyuupType == null && getMisyuupValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'misyuup$' should not be NULL."));
        }
        return misyuupType;
    }

    protected void setMisyuupType(String type) {
        misyuupType = type;
        misyuup = Optional.fromNullable(toCurrencyType(misyuupType))
            .transform(bizCurrencyTransformer(getMisyuupValue()))
            .orNull();
    }

    private BizCurrency yenkamisyuup;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkamisyuup() {
        return yenkamisyuup;
    }

    public void setYenkamisyuup(BizCurrency pYenkamisyuup) {
        yenkamisyuup = pYenkamisyuup;
        yenkamisyuupValue = null;
        yenkamisyuupType  = null;
    }

    transient private BigDecimal yenkamisyuupValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKAMISYUUP, nullable=true)
    protected BigDecimal getYenkamisyuupValue() {
        if (yenkamisyuupValue == null && yenkamisyuup != null) {
            if (yenkamisyuup.isOptional()) return null;
            return yenkamisyuup.absolute();
        }
        return yenkamisyuupValue;
    }

    protected void setYenkamisyuupValue(BigDecimal value) {
        yenkamisyuupValue = value;
        yenkamisyuup = Optional.fromNullable(toCurrencyType(yenkamisyuupType))
            .transform(bizCurrencyTransformer(getYenkamisyuupValue()))
            .orNull();
    }

    transient private String yenkamisyuupType = null;

    @Column(name=YENKAMISYUUP + "$", nullable=true)
    protected String getYenkamisyuupType() {
        if (yenkamisyuupType == null && yenkamisyuup != null) return yenkamisyuup.getType().toString();
        if (yenkamisyuupType == null && getYenkamisyuupValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkamisyuup$' should not be NULL."));
        }
        return yenkamisyuupType;
    }

    protected void setYenkamisyuupType(String type) {
        yenkamisyuupType = type;
        yenkamisyuup = Optional.fromNullable(toCurrencyType(yenkamisyuupType))
            .transform(bizCurrencyTransformer(getYenkamisyuupValue()))
            .orNull();
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenJT_SiBikinkanri.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private BizCurrency syonendojikaiikoup;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSyonendojikaiikoup() {
        return syonendojikaiikoup;
    }

    public void setSyonendojikaiikoup(BizCurrency pSyonendojikaiikoup) {
        syonendojikaiikoup = pSyonendojikaiikoup;
        syonendojikaiikoupValue = null;
        syonendojikaiikoupType  = null;
    }

    transient private BigDecimal syonendojikaiikoupValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SYONENDOJIKAIIKOUP, nullable=true)
    protected BigDecimal getSyonendojikaiikoupValue() {
        if (syonendojikaiikoupValue == null && syonendojikaiikoup != null) {
            if (syonendojikaiikoup.isOptional()) return null;
            return syonendojikaiikoup.absolute();
        }
        return syonendojikaiikoupValue;
    }

    protected void setSyonendojikaiikoupValue(BigDecimal value) {
        syonendojikaiikoupValue = value;
        syonendojikaiikoup = Optional.fromNullable(toCurrencyType(syonendojikaiikoupType))
            .transform(bizCurrencyTransformer(getSyonendojikaiikoupValue()))
            .orNull();
    }

    transient private String syonendojikaiikoupType = null;

    @Column(name=SYONENDOJIKAIIKOUP + "$", nullable=true)
    protected String getSyonendojikaiikoupType() {
        if (syonendojikaiikoupType == null && syonendojikaiikoup != null) return syonendojikaiikoup.getType().toString();
        if (syonendojikaiikoupType == null && getSyonendojikaiikoupValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'syonendojikaiikoup$' should not be NULL."));
        }
        return syonendojikaiikoupType;
    }

    protected void setSyonendojikaiikoupType(String type) {
        syonendojikaiikoupType = type;
        syonendojikaiikoup = Optional.fromNullable(toCurrencyType(syonendojikaiikoupType))
            .transform(bizCurrencyTransformer(getSyonendojikaiikoupValue()))
            .orNull();
    }

    private BizCurrency yenkasyonendojikaiikoup;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkasyonendojikaiikoup() {
        return yenkasyonendojikaiikoup;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkasyonendojikaiikoup(BizCurrency pYenkasyonendojikaiikoup) {
        yenkasyonendojikaiikoup = pYenkasyonendojikaiikoup;
        yenkasyonendojikaiikoupValue = null;
        yenkasyonendojikaiikoupType  = null;
    }

    transient private BigDecimal yenkasyonendojikaiikoupValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKASYONENDOJIKAIIKOUP, nullable=true)
    protected BigDecimal getYenkasyonendojikaiikoupValue() {
        if (yenkasyonendojikaiikoupValue == null && yenkasyonendojikaiikoup != null) {
            if (yenkasyonendojikaiikoup.isOptional()) return null;
            return yenkasyonendojikaiikoup.absolute();
        }
        return yenkasyonendojikaiikoupValue;
    }

    protected void setYenkasyonendojikaiikoupValue(BigDecimal value) {
        yenkasyonendojikaiikoupValue = value;
        yenkasyonendojikaiikoup = Optional.fromNullable(toCurrencyType(yenkasyonendojikaiikoupType))
            .transform(bizCurrencyTransformer(getYenkasyonendojikaiikoupValue()))
            .orNull();
    }

    transient private String yenkasyonendojikaiikoupType = null;

    @Column(name=YENKASYONENDOJIKAIIKOUP + "$", nullable=true)
    protected String getYenkasyonendojikaiikoupType() {
        if (yenkasyonendojikaiikoupType == null && yenkasyonendojikaiikoup != null) return yenkasyonendojikaiikoup.getType().toString();
        if (yenkasyonendojikaiikoupType == null && getYenkasyonendojikaiikoupValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkasyonendojikaiikoup$' should not be NULL."));
        }
        return yenkasyonendojikaiikoupType;
    }

    protected void setYenkasyonendojikaiikoupType(String type) {
        yenkasyonendojikaiikoupType = type;
        yenkasyonendojikaiikoup = Optional.fromNullable(toCurrencyType(yenkasyonendojikaiikoupType))
            .transform(bizCurrencyTransformer(getYenkasyonendojikaiikoupValue()))
            .orNull();
    }

    private BizCurrency jinendoikoup;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getJinendoikoup() {
        return jinendoikoup;
    }

    public void setJinendoikoup(BizCurrency pJinendoikoup) {
        jinendoikoup = pJinendoikoup;
        jinendoikoupValue = null;
        jinendoikoupType  = null;
    }

    transient private BigDecimal jinendoikoupValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=JINENDOIKOUP, nullable=true)
    protected BigDecimal getJinendoikoupValue() {
        if (jinendoikoupValue == null && jinendoikoup != null) {
            if (jinendoikoup.isOptional()) return null;
            return jinendoikoup.absolute();
        }
        return jinendoikoupValue;
    }

    protected void setJinendoikoupValue(BigDecimal value) {
        jinendoikoupValue = value;
        jinendoikoup = Optional.fromNullable(toCurrencyType(jinendoikoupType))
            .transform(bizCurrencyTransformer(getJinendoikoupValue()))
            .orNull();
    }

    transient private String jinendoikoupType = null;

    @Column(name=JINENDOIKOUP + "$", nullable=true)
    protected String getJinendoikoupType() {
        if (jinendoikoupType == null && jinendoikoup != null) return jinendoikoup.getType().toString();
        if (jinendoikoupType == null && getJinendoikoupValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'jinendoikoup$' should not be NULL."));
        }
        return jinendoikoupType;
    }

    protected void setJinendoikoupType(String type) {
        jinendoikoupType = type;
        jinendoikoup = Optional.fromNullable(toCurrencyType(jinendoikoupType))
            .transform(bizCurrencyTransformer(getJinendoikoupValue()))
            .orNull();
    }

    private BizCurrency yenkajinendoikoup;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkajinendoikoup() {
        return yenkajinendoikoup;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setYenkajinendoikoup(BizCurrency pYenkajinendoikoup) {
        yenkajinendoikoup = pYenkajinendoikoup;
        yenkajinendoikoupValue = null;
        yenkajinendoikoupType  = null;
    }

    transient private BigDecimal yenkajinendoikoupValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKAJINENDOIKOUP, nullable=true)
    protected BigDecimal getYenkajinendoikoupValue() {
        if (yenkajinendoikoupValue == null && yenkajinendoikoup != null) {
            if (yenkajinendoikoup.isOptional()) return null;
            return yenkajinendoikoup.absolute();
        }
        return yenkajinendoikoupValue;
    }

    protected void setYenkajinendoikoupValue(BigDecimal value) {
        yenkajinendoikoupValue = value;
        yenkajinendoikoup = Optional.fromNullable(toCurrencyType(yenkajinendoikoupType))
            .transform(bizCurrencyTransformer(getYenkajinendoikoupValue()))
            .orNull();
    }

    transient private String yenkajinendoikoupType = null;

    @Column(name=YENKAJINENDOIKOUP + "$", nullable=true)
    protected String getYenkajinendoikoupType() {
        if (yenkajinendoikoupType == null && yenkajinendoikoup != null) return yenkajinendoikoup.getType().toString();
        if (yenkajinendoikoupType == null && getYenkajinendoikoupValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkajinendoikoup$' should not be NULL."));
        }
        return yenkajinendoikoupType;
    }

    protected void setYenkajinendoikoupType(String type) {
        yenkajinendoikoupType = type;
        yenkajinendoikoup = Optional.fromNullable(toCurrencyType(yenkajinendoikoupType))
            .transform(bizCurrencyTransformer(getYenkajinendoikoupValue()))
            .orNull();
    }

    private BizCurrency seisankgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getSeisankgk() {
        return seisankgk;
    }

    public void setSeisankgk(BizCurrency pSeisankgk) {
        seisankgk = pSeisankgk;
        seisankgkValue = null;
        seisankgkType  = null;
    }

    transient private BigDecimal seisankgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=SEISANKGK, nullable=true)
    protected BigDecimal getSeisankgkValue() {
        if (seisankgkValue == null && seisankgk != null) {
            if (seisankgk.isOptional()) return null;
            return seisankgk.absolute();
        }
        return seisankgkValue;
    }

    protected void setSeisankgkValue(BigDecimal value) {
        seisankgkValue = value;
        seisankgk = Optional.fromNullable(toCurrencyType(seisankgkType))
            .transform(bizCurrencyTransformer(getSeisankgkValue()))
            .orNull();
    }

    transient private String seisankgkType = null;

    @Column(name=SEISANKGK + "$", nullable=true)
    protected String getSeisankgkType() {
        if (seisankgkType == null && seisankgk != null) return seisankgk.getType().toString();
        if (seisankgkType == null && getSeisankgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'seisankgk$' should not be NULL."));
        }
        return seisankgkType;
    }

    protected void setSeisankgkType(String type) {
        seisankgkType = type;
        seisankgk = Optional.fromNullable(toCurrencyType(seisankgkType))
            .transform(bizCurrencyTransformer(getSeisankgkValue()))
            .orNull();
    }

    private BizCurrency yenkaseisankgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getYenkaseisankgk() {
        return yenkaseisankgk;
    }

    public void setYenkaseisankgk(BizCurrency pYenkaseisankgk) {
        yenkaseisankgk = pYenkaseisankgk;
        yenkaseisankgkValue = null;
        yenkaseisankgkType  = null;
    }

    transient private BigDecimal yenkaseisankgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=YENKASEISANKGK, nullable=true)
    protected BigDecimal getYenkaseisankgkValue() {
        if (yenkaseisankgkValue == null && yenkaseisankgk != null) {
            if (yenkaseisankgk.isOptional()) return null;
            return yenkaseisankgk.absolute();
        }
        return yenkaseisankgkValue;
    }

    protected void setYenkaseisankgkValue(BigDecimal value) {
        yenkaseisankgkValue = value;
        yenkaseisankgk = Optional.fromNullable(toCurrencyType(yenkaseisankgkType))
            .transform(bizCurrencyTransformer(getYenkaseisankgkValue()))
            .orNull();
    }

    transient private String yenkaseisankgkType = null;

    @Column(name=YENKASEISANKGK + "$", nullable=true)
    protected String getYenkaseisankgkType() {
        if (yenkaseisankgkType == null && yenkaseisankgk != null) return yenkaseisankgk.getType().toString();
        if (yenkaseisankgkType == null && getYenkaseisankgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'yenkaseisankgk$' should not be NULL."));
        }
        return yenkaseisankgkType;
    }

    protected void setYenkaseisankgkType(String type) {
        yenkaseisankgkType = type;
        yenkaseisankgk = Optional.fromNullable(toCurrencyType(yenkaseisankgkType))
            .transform(bizCurrencyTransformer(getYenkaseisankgkValue()))
            .orNull();
    }

    private C_SeisankinKanritukaKbn msyupknrtuukakbn;

    @Type(type="UserType_C_SeisankinKanritukaKbn")
    @Column(name=GenJT_SiBikinkanri.MSYUPKNRTUUKAKBN)
    public C_SeisankinKanritukaKbn getMsyupknrtuukakbn() {
        return msyupknrtuukakbn;
    }

    public void setMsyupknrtuukakbn(C_SeisankinKanritukaKbn pMsyupknrtuukakbn) {
        msyupknrtuukakbn = pMsyupknrtuukakbn;
    }

    private C_SeisankinKanritukaKbn mikeikapknrtuukakbn;

    @Type(type="UserType_C_SeisankinKanritukaKbn")
    @Column(name=GenJT_SiBikinkanri.MIKEIKAPKNRTUUKAKBN)
    public C_SeisankinKanritukaKbn getMikeikapknrtuukakbn() {
        return mikeikapknrtuukakbn;
    }

    public void setMikeikapknrtuukakbn(C_SeisankinKanritukaKbn pMikeikapknrtuukakbn) {
        mikeikapknrtuukakbn = pMikeikapknrtuukakbn;
    }

    private C_SeisankinKanritukaKbn znnusisnkinknrtuukakbn;

    @Type(type="UserType_C_SeisankinKanritukaKbn")
    @Column(name=GenJT_SiBikinkanri.ZNNUSISNKINKNRTUUKAKBN)
    public C_SeisankinKanritukaKbn getZnnusisnkinknrtuukakbn() {
        return znnusisnkinknrtuukakbn;
    }

    public void setZnnusisnkinknrtuukakbn(C_SeisankinKanritukaKbn pZnnusisnkinknrtuukakbn) {
        znnusisnkinknrtuukakbn = pZnnusisnkinknrtuukakbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenJT_SiBikinkanri.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_SiBikinkanri.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_SiBikinkanri.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}