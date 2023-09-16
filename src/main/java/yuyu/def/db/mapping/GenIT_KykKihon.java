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
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYType;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_Aplkahi;
import yuyu.def.classification.C_Boskykjyoutai;
import yuyu.def.classification.C_DirectServiceMosKbn;
import yuyu.def.classification.C_DntryourituKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_HonninkakuninSyoruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KijiKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.classification.C_NkIkouzumiKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SinsaKbn;
import yuyu.def.classification.C_SkSyoukenSksKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TrhkjiKakKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YakkanJyuryouKbn;
import yuyu.def.classification.C_YnkHrkmgkAnniTuutiKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.id.PKIT_KykKihon;
import yuyu.def.db.meta.GenQIT_KykKihon;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.type.UserType_C_AisyoumeiKbn;
import yuyu.def.db.type.UserType_C_Aplkahi;
import yuyu.def.db.type.UserType_C_Boskykjyoutai;
import yuyu.def.db.type.UserType_C_DirectServiceMosKbn;
import yuyu.def.db.type.UserType_C_DntryourituKbn;
import yuyu.def.db.type.UserType_C_FstphrkkeiroKbn;
import yuyu.def.db.type.UserType_C_HaitouKbn;
import yuyu.def.db.type.UserType_C_HaitoukinuketorihouKbn;
import yuyu.def.db.type.UserType_C_HonninkakuninSyoruiKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_KijiKbn;
import yuyu.def.db.type.UserType_C_MosUketukeKbn;
import yuyu.def.db.type.UserType_C_NensyuuKbn;
import yuyu.def.db.type.UserType_C_NkIkouzumiKbn;
import yuyu.def.db.type.UserType_C_Sdpd;
import yuyu.def.db.type.UserType_C_SinsaKbn;
import yuyu.def.db.type.UserType_C_SkSyoukenSksKbn;
import yuyu.def.db.type.UserType_C_SntkhouKbn;
import yuyu.def.db.type.UserType_C_StknsetKbn;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_TrhkjiKakKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YakkanJyuryouKbn;
import yuyu.def.db.type.UserType_C_YnkHrkmgkAnniTuutiKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約基本テーブル テーブルのマッピング情報クラスで、 {@link IT_KykKihon} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KykKihon}</td><td colspan="3">契約基本テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_KykKihon ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_KykKihon ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getAitesyono aitesyono}</td><td>相手証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHaitoukbn haitoukbn}</td><td>配当区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HaitouKbn}</td></tr>
 *  <tr><td>{@link #getHrkkaisuu hrkkaisuu}</td><td>払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkaisuu}</td></tr>
 *  <tr><td>{@link #getHrkkeiro hrkkeiro}</td><td>払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Hrkkeiro}</td></tr>
 *  <tr><td>{@link #getSdpdkbn sdpdkbn}</td><td>Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Sdpd}</td></tr>
 *  <tr><td>{@link #getDntryouritukbn dntryouritukbn}</td><td>団体料率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DntryourituKbn}</td></tr>
 *  <tr><td>{@link #getDntcd dntcd}</td><td>団体コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSntkhoukbn sntkhoukbn}</td><td>選択方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SntkhouKbn}</td></tr>
 *  <tr><td>{@link #getSinsakbn sinsakbn}</td><td>診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SinsaKbn}</td></tr>
 *  <tr><td>{@link #getMosymd mosymd}</td><td>申込日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKktymd kktymd}</td><td>告知日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getFstpnyknymd fstpnyknymd}</td><td>初回保険料入金日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMosukeymd mosukeymd}</td><td>申込書受付日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getMosjimosuktymd mosjimosuktymd}</td><td>申込時申込書受付日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSeirituymd seirituymd}</td><td>成立日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getItiprsymd itiprsymd}</td><td>１Ｐ領収予定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHrkp hrkp}</td><td>払込保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getBosyuuym bosyuuym}</td><td>募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getSeisekiym seisekiym}</td><td>成績計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getSkeikeijyouym skeikeijyouym}</td><td>新契約計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getPlancd plancd}</td><td>プランコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPlanrenno planrenno}</td><td>プラン連番</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getAisyoumeikbn aisyoumeikbn}</td><td>愛称名区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_AisyoumeiKbn}</td></tr>
 *  <tr><td>{@link #getSyusaiumu syusaiumu}</td><td>出再有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getStknsetkbn stknsetkbn}</td><td>質権設定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_StknsetKbn}</td></tr>
 *  <tr><td>{@link #getKykksykjyumu kykksykjyumu}</td><td>契約者貸付約定有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKykksumu kykksumu}</td><td>契約者貸付有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getAplkahikbn aplkahikbn}</td><td>ＡＰＬ可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Aplkahi}</td></tr>
 *  <tr><td>{@link #getAplumu aplumu}</td><td>ＡＰＬ有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getFstphrkkeirokbn fstphrkkeirokbn}</td><td>初回保険料払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_FstphrkkeiroKbn}</td></tr>
 *  <tr><td>{@link #getHaitounendo haitounendo}</td><td>配当年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateY</td></tr>
 *  <tr><td>{@link #getHaitoukinuketorihoukbn haitoukinuketorihoukbn}</td><td>配当金受取方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HaitoukinuketorihouKbn}</td></tr>
 *  <tr><td>{@link #getTratkityuiumu tratkityuiumu}</td><td>取扱注意有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTratkityuiuny tratkityuiuny}</td><td>取扱注意内容</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSbuktnin sbuktnin}</td><td>死亡受取人人数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getGansindankakuteiymd gansindankakuteiymd}</td><td>がん診断確定日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMosuketukekbn mosuketukekbn}</td><td>申込受付区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MosUketukeKbn}</td></tr>
 *  <tr><td>{@link #getKijikbn kijikbn}</td><td>記事区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KijiKbn}</td></tr>
 *  <tr><td>{@link #getHhknsykgycd hhknsykgycd}</td><td>被保険者職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHhknnensyuukbn hhknnensyuukbn}</td><td>被保険者年収区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NensyuuKbn}</td></tr>
 *  <tr><td>{@link #getDrtenkanritodoufukencd drtenkanritodoufukencd}</td><td>代理店管理都道府県コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCifcd cifcd}</td><td>ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSmbckanriid smbckanriid}</td><td>ＳＭＢＣ受付管理ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTsryhshrkykumukbn tsryhshrkykumukbn}</td><td>手数料不支払契約有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKykhonninkakninsyoruikbn kykhonninkakninsyoruikbn}</td><td>契約者本人確認書類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HonninkakuninSyoruiKbn}</td></tr>
 *  <tr><td>{@link #getSkskknhonninkakninsyoruikbn skskknhonninkakninsyoruikbn}</td><td>親権者後見人本人確認書類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HonninkakuninSyoruiKbn}</td></tr>
 *  <tr><td>{@link #getBoskykjyoutai boskykjyoutai}</td><td>募集契約状態</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Boskykjyoutai}</td></tr>
 *  <tr><td>{@link #getKanyuusyano kanyuusyano}</td><td>加入者番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getDrctservicemoskbn drctservicemoskbn}</td><td>ダイレクトサービス申込区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DirectServiceMosKbn}</td></tr>
 *  <tr><td>{@link #getSksyoukenskskbn sksyoukenskskbn}</td><td>新契約証券作成区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SkSyoukenSksKbn}</td></tr>
 *  <tr><td>{@link #getSinkyksyokensakuseiymd sinkyksyokensakuseiymd}</td><td>新契約証券作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyoyousinkyksyohakkouymd syoyousinkyksyohakkouymd}</td><td>証券用新契約証券発行日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSkjmosno skjmosno}</td><td>新契約時申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNkuikosumikbn nkuikosumikbn}</td><td>年金移行済区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NkIkouzumiKbn}</td></tr>
 *  <tr><td>{@link #getSyhenkouymd syhenkouymd}</td><td>最終変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getLastsyosaihkymd lastsyosaihkymd}</td><td>最終証券再発行日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getLastmeihenymd lastmeihenymd}</td><td>最終名義変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getLastkykmeighnkymd lastkykmeighnkymd}</td><td>最終契約者名義変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getLastsbukthenymd lastsbukthenymd}</td><td>最終死亡受取人変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getLastkyknmseiymdhenkouymd lastkyknmseiymdhenkouymd}</td><td>最終契約者名生年月日変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getLastkyknmkanakjteiymd lastkyknmkanakjteiymd}</td><td>最終契約者名仮名漢字訂正日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getLasttsinynohenkouymd lasttsinynohenkouymd}</td><td>最終通信先郵便番号変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getLastjyuuhenymd lastjyuuhenymd}</td><td>最終住所変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeiritujitrhkjikakkbn seiritujitrhkjikakkbn}</td><td>成立時取引時確認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TrhkjiKakKbn}</td></tr>
 *  <tr><td>{@link #getTikiktbrisyuruikbn tikiktbrisyuruikbn}</td><td>定期一括払種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>{@link #getYakkanjyuryouhoukbn yakkanjyuryouhoukbn}</td><td>約款受領方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YakkanJyuryouKbn}</td></tr>
 *  <tr><td>{@link #getYakkanbunsyono yakkanbunsyono}</td><td>約款文書番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSiorino siorino}</td><td>しおり番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYnkhrkmgkannituutikbn ynkhrkmgkannituutikbn}</td><td>円貨払込額案内通知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YnkHrkmgkAnniTuutiKbn}</td></tr>
 * </table>
 * @see     IT_KykKihon
 * @see     PKIT_KykKihon
 * @see     QIT_KykKihon
 * @see     GenQIT_KykKihon
 */
@MappedSuperclass
@Table(name=GenIT_KykKihon.TABLE_NAME)
@IdClass(value=PKIT_KykKihon.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="BizDateYType", typeClass=BizDateYType.class),
    @TypeDef(name="UserType_C_AisyoumeiKbn", typeClass=UserType_C_AisyoumeiKbn.class),
    @TypeDef(name="UserType_C_Aplkahi", typeClass=UserType_C_Aplkahi.class),
    @TypeDef(name="UserType_C_Boskykjyoutai", typeClass=UserType_C_Boskykjyoutai.class),
    @TypeDef(name="UserType_C_DirectServiceMosKbn", typeClass=UserType_C_DirectServiceMosKbn.class),
    @TypeDef(name="UserType_C_DntryourituKbn", typeClass=UserType_C_DntryourituKbn.class),
    @TypeDef(name="UserType_C_FstphrkkeiroKbn", typeClass=UserType_C_FstphrkkeiroKbn.class),
    @TypeDef(name="UserType_C_HaitouKbn", typeClass=UserType_C_HaitouKbn.class),
    @TypeDef(name="UserType_C_HaitoukinuketorihouKbn", typeClass=UserType_C_HaitoukinuketorihouKbn.class),
    @TypeDef(name="UserType_C_HonninkakuninSyoruiKbn", typeClass=UserType_C_HonninkakuninSyoruiKbn.class),
    @TypeDef(name="UserType_C_Hrkkaisuu", typeClass=UserType_C_Hrkkaisuu.class),
    @TypeDef(name="UserType_C_Hrkkeiro", typeClass=UserType_C_Hrkkeiro.class),
    @TypeDef(name="UserType_C_KijiKbn", typeClass=UserType_C_KijiKbn.class),
    @TypeDef(name="UserType_C_MosUketukeKbn", typeClass=UserType_C_MosUketukeKbn.class),
    @TypeDef(name="UserType_C_NensyuuKbn", typeClass=UserType_C_NensyuuKbn.class),
    @TypeDef(name="UserType_C_NkIkouzumiKbn", typeClass=UserType_C_NkIkouzumiKbn.class),
    @TypeDef(name="UserType_C_Sdpd", typeClass=UserType_C_Sdpd.class),
    @TypeDef(name="UserType_C_SinsaKbn", typeClass=UserType_C_SinsaKbn.class),
    @TypeDef(name="UserType_C_SkSyoukenSksKbn", typeClass=UserType_C_SkSyoukenSksKbn.class),
    @TypeDef(name="UserType_C_SntkhouKbn", typeClass=UserType_C_SntkhouKbn.class),
    @TypeDef(name="UserType_C_StknsetKbn", typeClass=UserType_C_StknsetKbn.class),
    @TypeDef(name="UserType_C_TkiktbrisyuruiKbn", typeClass=UserType_C_TkiktbrisyuruiKbn.class),
    @TypeDef(name="UserType_C_TrhkjiKakKbn", typeClass=UserType_C_TrhkjiKakKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YakkanJyuryouKbn", typeClass=UserType_C_YakkanJyuryouKbn.class),
    @TypeDef(name="UserType_C_YnkHrkmgkAnniTuutiKbn", typeClass=UserType_C_YnkHrkmgkAnniTuutiKbn.class)
})
public abstract class GenIT_KykKihon extends AbstractExDBEntity<IT_KykKihon, PKIT_KykKihon> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KykKihon";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String AITESYONO                = "aitesyono";
    public static final String HAITOUKBN                = "haitoukbn";
    public static final String HRKKAISUU                = "hrkkaisuu";
    public static final String HRKKEIRO                 = "hrkkeiro";
    public static final String SDPDKBN                  = "sdpdkbn";
    public static final String DNTRYOURITUKBN           = "dntryouritukbn";
    public static final String DNTCD                    = "dntcd";
    public static final String SNTKHOUKBN               = "sntkhoukbn";
    public static final String SINSAKBN                 = "sinsakbn";
    public static final String MOSYMD                   = "mosymd";
    public static final String KKTYMD                   = "kktymd";
    public static final String FSTPNYKNYMD              = "fstpnyknymd";
    public static final String MOSUKEYMD                = "mosukeymd";
    public static final String MOSJIMOSUKTYMD           = "mosjimosuktymd";
    public static final String SEIRITUYMD               = "seirituymd";
    public static final String ITIPRSYMD                = "itiprsymd";
    public static final String HRKP                     = "hrkp";
    public static final String BOSYUUYM                 = "bosyuuym";
    public static final String SEISEKIYM                = "seisekiym";
    public static final String SKEIKEIJYOUYM            = "skeikeijyouym";
    public static final String PLANCD                   = "plancd";
    public static final String PLANRENNO                = "planrenno";
    public static final String AISYOUMEIKBN             = "aisyoumeikbn";
    public static final String SYUSAIUMU                = "syusaiumu";
    public static final String STKNSETKBN               = "stknsetkbn";
    public static final String KYKKSYKJYUMU             = "kykksykjyumu";
    public static final String KYKKSUMU                 = "kykksumu";
    public static final String APLKAHIKBN               = "aplkahikbn";
    public static final String APLUMU                   = "aplumu";
    public static final String FSTPHRKKEIROKBN          = "fstphrkkeirokbn";
    public static final String HAITOUNENDO              = "haitounendo";
    public static final String HAITOUKINUKETORIHOUKBN   = "haitoukinuketorihoukbn";
    public static final String TRATKITYUIUMU            = "tratkityuiumu";
    public static final String TRATKITYUIUNY            = "tratkityuiuny";
    public static final String SBUKTNIN                 = "sbuktnin";
    public static final String GANSINDANKAKUTEIYMD      = "gansindankakuteiymd";
    public static final String MOSUKETUKEKBN            = "mosuketukekbn";
    public static final String KIJIKBN                  = "kijikbn";
    public static final String HHKNSYKGYCD              = "hhknsykgycd";
    public static final String HHKNNENSYUUKBN           = "hhknnensyuukbn";
    public static final String DRTENKANRITODOUFUKENCD   = "drtenkanritodoufukencd";
    public static final String CIFCD                    = "cifcd";
    public static final String SMBCKANRIID              = "smbckanriid";
    public static final String TSRYHSHRKYKUMUKBN        = "tsryhshrkykumukbn";
    public static final String KYKHONNINKAKNINSYORUIKBN = "kykhonninkakninsyoruikbn";
    public static final String SKSKKNHONNINKAKNINSYORUIKBN = "skskknhonninkakninsyoruikbn";
    public static final String BOSKYKJYOUTAI            = "boskykjyoutai";
    public static final String KANYUUSYANO              = "kanyuusyano";
    public static final String DRCTSERVICEMOSKBN        = "drctservicemoskbn";
    public static final String SKSYOUKENSKSKBN          = "sksyoukenskskbn";
    public static final String SINKYKSYOKENSAKUSEIYMD   = "sinkyksyokensakuseiymd";
    public static final String SYOYOUSINKYKSYOHAKKOUYMD = "syoyousinkyksyohakkouymd";
    public static final String SKJMOSNO                 = "skjmosno";
    public static final String NKUIKOSUMIKBN            = "nkuikosumikbn";
    public static final String SYHENKOUYMD              = "syhenkouymd";
    public static final String LASTSYOSAIHKYMD          = "lastsyosaihkymd";
    public static final String LASTMEIHENYMD            = "lastmeihenymd";
    public static final String LASTKYKMEIGHNKYMD        = "lastkykmeighnkymd";
    public static final String LASTSBUKTHENYMD          = "lastsbukthenymd";
    public static final String LASTKYKNMSEIYMDHENKOUYMD = "lastkyknmseiymdhenkouymd";
    public static final String LASTKYKNMKANAKJTEIYMD    = "lastkyknmkanakjteiymd";
    public static final String LASTTSINYNOHENKOUYMD     = "lasttsinynohenkouymd";
    public static final String LASTJYUUHENYMD           = "lastjyuuhenymd";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String SEIRITUJITRHKJIKAKKBN    = "seiritujitrhkjikakkbn";
    public static final String TIKIKTBRISYURUIKBN       = "tikiktbrisyuruikbn";
    public static final String YAKKANJYURYOUHOUKBN      = "yakkanjyuryouhoukbn";
    public static final String YAKKANBUNSYONO           = "yakkanbunsyono";
    public static final String SIORINO                  = "siorino";
    public static final String YNKHRKMGKANNITUUTIKBN    = "ynkhrkmgkannituutikbn";

    private final PKIT_KykKihon primaryKey;

    public GenIT_KykKihon() {
        primaryKey = new PKIT_KykKihon();
    }

    public GenIT_KykKihon(String pKbnkey, String pSyono) {
        primaryKey = new PKIT_KykKihon(pKbnkey, pSyono);
    }

    @Transient
    @Override
    public PKIT_KykKihon getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KykKihon> getMetaClass() {
        return QIT_KykKihon.class;
    }

    @Id
    @Column(name=GenIT_KykKihon.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_KykKihon.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    private String aitesyono;

    @Column(name=GenIT_KykKihon.AITESYONO)
    @SyoukenNo
    public String getAitesyono() {
        return aitesyono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setAitesyono(String pAitesyono) {
        aitesyono = pAitesyono;
    }

    private C_HaitouKbn haitoukbn;

    @Type(type="UserType_C_HaitouKbn")
    @Column(name=GenIT_KykKihon.HAITOUKBN)
    public C_HaitouKbn getHaitoukbn() {
        return haitoukbn;
    }

    public void setHaitoukbn(C_HaitouKbn pHaitoukbn) {
        haitoukbn = pHaitoukbn;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Type(type="UserType_C_Hrkkaisuu")
    @Column(name=GenIT_KykKihon.HRKKAISUU)
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    private C_Hrkkeiro hrkkeiro;

    @Type(type="UserType_C_Hrkkeiro")
    @Column(name=GenIT_KykKihon.HRKKEIRO)
    public C_Hrkkeiro getHrkkeiro() {
        return hrkkeiro;
    }

    public void setHrkkeiro(C_Hrkkeiro pHrkkeiro) {
        hrkkeiro = pHrkkeiro;
    }

    private C_Sdpd sdpdkbn;

    @Type(type="UserType_C_Sdpd")
    @Column(name=GenIT_KykKihon.SDPDKBN)
    public C_Sdpd getSdpdkbn() {
        return sdpdkbn;
    }

    public void setSdpdkbn(C_Sdpd pSdpdkbn) {
        sdpdkbn = pSdpdkbn;
    }

    private C_DntryourituKbn dntryouritukbn;

    @Type(type="UserType_C_DntryourituKbn")
    @Column(name=GenIT_KykKihon.DNTRYOURITUKBN)
    public C_DntryourituKbn getDntryouritukbn() {
        return dntryouritukbn;
    }

    public void setDntryouritukbn(C_DntryourituKbn pDntryouritukbn) {
        dntryouritukbn = pDntryouritukbn;
    }

    private String dntcd;

    @Column(name=GenIT_KykKihon.DNTCD)
    @MaxLength(max=8)
    @AlphaDigit
    public String getDntcd() {
        return dntcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDntcd(String pDntcd) {
        dntcd = pDntcd;
    }

    private C_SntkhouKbn sntkhoukbn;

    @Type(type="UserType_C_SntkhouKbn")
    @Column(name=GenIT_KykKihon.SNTKHOUKBN)
    public C_SntkhouKbn getSntkhoukbn() {
        return sntkhoukbn;
    }

    public void setSntkhoukbn(C_SntkhouKbn pSntkhoukbn) {
        sntkhoukbn = pSntkhoukbn;
    }

    private C_SinsaKbn sinsakbn;

    @Type(type="UserType_C_SinsaKbn")
    @Column(name=GenIT_KykKihon.SINSAKBN)
    public C_SinsaKbn getSinsakbn() {
        return sinsakbn;
    }

    public void setSinsakbn(C_SinsaKbn pSinsakbn) {
        sinsakbn = pSinsakbn;
    }

    private BizDate mosymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykKihon.MOSYMD)
    @ValidDate
    public BizDate getMosymd() {
        return mosymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosymd(BizDate pMosymd) {
        mosymd = pMosymd;
    }

    private BizDate kktymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykKihon.KKTYMD)
    @ValidDate
    public BizDate getKktymd() {
        return kktymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKktymd(BizDate pKktymd) {
        kktymd = pKktymd;
    }

    private BizDate fstpnyknymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykKihon.FSTPNYKNYMD)
    public BizDate getFstpnyknymd() {
        return fstpnyknymd;
    }

    public void setFstpnyknymd(BizDate pFstpnyknymd) {
        fstpnyknymd = pFstpnyknymd;
    }

    private BizDate mosukeymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykKihon.MOSUKEYMD)
    @ValidDate
    public BizDate getMosukeymd() {
        return mosukeymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosukeymd(BizDate pMosukeymd) {
        mosukeymd = pMosukeymd;
    }

    private BizDate mosjimosuktymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykKihon.MOSJIMOSUKTYMD)
    public BizDate getMosjimosuktymd() {
        return mosjimosuktymd;
    }

    @Trim("both")
    public void setMosjimosuktymd(BizDate pMosjimosuktymd) {
        mosjimosuktymd = pMosjimosuktymd;
    }

    private BizDate seirituymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykKihon.SEIRITUYMD)
    public BizDate getSeirituymd() {
        return seirituymd;
    }

    @Trim("both")
    public void setSeirituymd(BizDate pSeirituymd) {
        seirituymd = pSeirituymd;
    }

    private BizDate itiprsymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykKihon.ITIPRSYMD)
    @ValidDate
    public BizDate getItiprsymd() {
        return itiprsymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setItiprsymd(BizDate pItiprsymd) {
        itiprsymd = pItiprsymd;
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

    private BizDateYM bosyuuym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_KykKihon.BOSYUUYM)
    @ValidDateYm
    public BizDateYM getBosyuuym() {
        return bosyuuym;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBosyuuym(BizDateYM pBosyuuym) {
        bosyuuym = pBosyuuym;
    }

    private BizDateYM seisekiym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_KykKihon.SEISEKIYM)
    public BizDateYM getSeisekiym() {
        return seisekiym;
    }

    @Trim("both")
    public void setSeisekiym(BizDateYM pSeisekiym) {
        seisekiym = pSeisekiym;
    }

    private BizDateYM skeikeijyouym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_KykKihon.SKEIKEIJYOUYM)
    public BizDateYM getSkeikeijyouym() {
        return skeikeijyouym;
    }

    @Trim("both")
    public void setSkeikeijyouym(BizDateYM pSkeikeijyouym) {
        skeikeijyouym = pSkeikeijyouym;
    }

    private String plancd;

    @Column(name=GenIT_KykKihon.PLANCD)
    @MaxLength(max=10)
    @AlphaDigit
    public String getPlancd() {
        return plancd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPlancd(String pPlancd) {
        plancd = pPlancd;
    }

    private Integer planrenno;

    @Column(name=GenIT_KykKihon.PLANRENNO)
    public Integer getPlanrenno() {
        return planrenno;
    }

    public void setPlanrenno(Integer pPlanrenno) {
        planrenno = pPlanrenno;
    }

    private C_AisyoumeiKbn aisyoumeikbn;

    @Type(type="UserType_C_AisyoumeiKbn")
    @Column(name=GenIT_KykKihon.AISYOUMEIKBN)
    public C_AisyoumeiKbn getAisyoumeikbn() {
        return aisyoumeikbn;
    }

    public void setAisyoumeikbn(C_AisyoumeiKbn pAisyoumeikbn) {
        aisyoumeikbn = pAisyoumeikbn;
    }

    private C_UmuKbn syusaiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykKihon.SYUSAIUMU)
    public C_UmuKbn getSyusaiumu() {
        return syusaiumu;
    }

    public void setSyusaiumu(C_UmuKbn pSyusaiumu) {
        syusaiumu = pSyusaiumu;
    }

    private C_StknsetKbn stknsetkbn;

    @Type(type="UserType_C_StknsetKbn")
    @Column(name=GenIT_KykKihon.STKNSETKBN)
    public C_StknsetKbn getStknsetkbn() {
        return stknsetkbn;
    }

    public void setStknsetkbn(C_StknsetKbn pStknsetkbn) {
        stknsetkbn = pStknsetkbn;
    }

    private C_UmuKbn kykksykjyumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykKihon.KYKKSYKJYUMU)
    public C_UmuKbn getKykksykjyumu() {
        return kykksykjyumu;
    }

    public void setKykksykjyumu(C_UmuKbn pKykksykjyumu) {
        kykksykjyumu = pKykksykjyumu;
    }

    private C_UmuKbn kykksumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykKihon.KYKKSUMU)
    public C_UmuKbn getKykksumu() {
        return kykksumu;
    }

    public void setKykksumu(C_UmuKbn pKykksumu) {
        kykksumu = pKykksumu;
    }

    private C_Aplkahi aplkahikbn;

    @Type(type="UserType_C_Aplkahi")
    @Column(name=GenIT_KykKihon.APLKAHIKBN)
    public C_Aplkahi getAplkahikbn() {
        return aplkahikbn;
    }

    public void setAplkahikbn(C_Aplkahi pAplkahikbn) {
        aplkahikbn = pAplkahikbn;
    }

    private C_UmuKbn aplumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykKihon.APLUMU)
    public C_UmuKbn getAplumu() {
        return aplumu;
    }

    public void setAplumu(C_UmuKbn pAplumu) {
        aplumu = pAplumu;
    }

    private C_FstphrkkeiroKbn fstphrkkeirokbn;

    @Type(type="UserType_C_FstphrkkeiroKbn")
    @Column(name=GenIT_KykKihon.FSTPHRKKEIROKBN)
    public C_FstphrkkeiroKbn getFstphrkkeirokbn() {
        return fstphrkkeirokbn;
    }

    public void setFstphrkkeirokbn(C_FstphrkkeiroKbn pFstphrkkeirokbn) {
        fstphrkkeirokbn = pFstphrkkeirokbn;
    }

    private BizDateY haitounendo;

    @Type(type="BizDateYType")
    @Column(name=GenIT_KykKihon.HAITOUNENDO)
    public BizDateY getHaitounendo() {
        return haitounendo;
    }

    public void setHaitounendo(BizDateY pHaitounendo) {
        haitounendo = pHaitounendo;
    }

    private C_HaitoukinuketorihouKbn haitoukinuketorihoukbn;

    @Type(type="UserType_C_HaitoukinuketorihouKbn")
    @Column(name=GenIT_KykKihon.HAITOUKINUKETORIHOUKBN)
    public C_HaitoukinuketorihouKbn getHaitoukinuketorihoukbn() {
        return haitoukinuketorihoukbn;
    }

    public void setHaitoukinuketorihoukbn(C_HaitoukinuketorihouKbn pHaitoukinuketorihoukbn) {
        haitoukinuketorihoukbn = pHaitoukinuketorihoukbn;
    }

    private C_UmuKbn tratkityuiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykKihon.TRATKITYUIUMU)
    public C_UmuKbn getTratkityuiumu() {
        return tratkityuiumu;
    }

    public void setTratkityuiumu(C_UmuKbn pTratkityuiumu) {
        tratkityuiumu = pTratkityuiumu;
    }

    private String tratkityuiuny;

    @Column(name=GenIT_KykKihon.TRATKITYUIUNY)
    public String getTratkityuiuny() {
        return tratkityuiuny;
    }

    public void setTratkityuiuny(String pTratkityuiuny) {
        tratkityuiuny = pTratkityuiuny;
    }

    private Integer sbuktnin;

    @Column(name=GenIT_KykKihon.SBUKTNIN)
    @Range(min="0", max="99")
    public Integer getSbuktnin() {
        return sbuktnin;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSbuktnin(Integer pSbuktnin) {
        sbuktnin = pSbuktnin;
    }

    private String gansindankakuteiymd;

    @Column(name=GenIT_KykKihon.GANSINDANKAKUTEIYMD)
    public String getGansindankakuteiymd() {
        return gansindankakuteiymd;
    }

    @DataConvert("toSingleByte")
    public void setGansindankakuteiymd(String pGansindankakuteiymd) {
        gansindankakuteiymd = pGansindankakuteiymd;
    }

    private C_MosUketukeKbn mosuketukekbn;

    @Type(type="UserType_C_MosUketukeKbn")
    @Column(name=GenIT_KykKihon.MOSUKETUKEKBN)
    public C_MosUketukeKbn getMosuketukekbn() {
        return mosuketukekbn;
    }

    public void setMosuketukekbn(C_MosUketukeKbn pMosuketukekbn) {
        mosuketukekbn = pMosuketukekbn;
    }

    private C_KijiKbn kijikbn;

    @Type(type="UserType_C_KijiKbn")
    @Column(name=GenIT_KykKihon.KIJIKBN)
    public C_KijiKbn getKijikbn() {
        return kijikbn;
    }

    public void setKijikbn(C_KijiKbn pKijikbn) {
        kijikbn = pKijikbn;
    }

    private String hhknsykgycd;

    @Column(name=GenIT_KykKihon.HHKNSYKGYCD)
    @MaxLength(max=3)
    @AlphaDigit
    @HostInvalidCharacter
    public String getHhknsykgycd() {
        return hhknsykgycd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknsykgycd(String pHhknsykgycd) {
        hhknsykgycd = pHhknsykgycd;
    }

    private C_NensyuuKbn hhknnensyuukbn;

    @Type(type="UserType_C_NensyuuKbn")
    @Column(name=GenIT_KykKihon.HHKNNENSYUUKBN)
    public C_NensyuuKbn getHhknnensyuukbn() {
        return hhknnensyuukbn;
    }

    public void setHhknnensyuukbn(C_NensyuuKbn pHhknnensyuukbn) {
        hhknnensyuukbn = pHhknnensyuukbn;
    }

    private String drtenkanritodoufukencd;

    @Column(name=GenIT_KykKihon.DRTENKANRITODOUFUKENCD)
    public String getDrtenkanritodoufukencd() {
        return drtenkanritodoufukencd;
    }

    public void setDrtenkanritodoufukencd(String pDrtenkanritodoufukencd) {
        drtenkanritodoufukencd = pDrtenkanritodoufukencd;
    }

    private String cifcd;

    @Column(name=GenIT_KykKihon.CIFCD)
    @MaxLength(max=15)
    @AlphaDigit
    @HostInvalidCharacter
    public String getCifcd() {
        return cifcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCifcd(String pCifcd) {
        cifcd = pCifcd;
    }

    private String smbckanriid;

    @Column(name=GenIT_KykKihon.SMBCKANRIID)
    public String getSmbckanriid() {
        return smbckanriid;
    }

    public void setSmbckanriid(String pSmbckanriid) {
        smbckanriid = pSmbckanriid;
    }

    private C_UmuKbn tsryhshrkykumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenIT_KykKihon.TSRYHSHRKYKUMUKBN)
    public C_UmuKbn getTsryhshrkykumukbn() {
        return tsryhshrkykumukbn;
    }

    public void setTsryhshrkykumukbn(C_UmuKbn pTsryhshrkykumukbn) {
        tsryhshrkykumukbn = pTsryhshrkykumukbn;
    }

    private C_HonninkakuninSyoruiKbn kykhonninkakninsyoruikbn;

    @Type(type="UserType_C_HonninkakuninSyoruiKbn")
    @Column(name=GenIT_KykKihon.KYKHONNINKAKNINSYORUIKBN)
    public C_HonninkakuninSyoruiKbn getKykhonninkakninsyoruikbn() {
        return kykhonninkakninsyoruikbn;
    }

    public void setKykhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn pKykhonninkakninsyoruikbn) {
        kykhonninkakninsyoruikbn = pKykhonninkakninsyoruikbn;
    }

    private C_HonninkakuninSyoruiKbn skskknhonninkakninsyoruikbn;

    @Type(type="UserType_C_HonninkakuninSyoruiKbn")
    @Column(name=GenIT_KykKihon.SKSKKNHONNINKAKNINSYORUIKBN)
    public C_HonninkakuninSyoruiKbn getSkskknhonninkakninsyoruikbn() {
        return skskknhonninkakninsyoruikbn;
    }

    public void setSkskknhonninkakninsyoruikbn(C_HonninkakuninSyoruiKbn pSkskknhonninkakninsyoruikbn) {
        skskknhonninkakninsyoruikbn = pSkskknhonninkakninsyoruikbn;
    }

    private C_Boskykjyoutai boskykjyoutai;

    @Type(type="UserType_C_Boskykjyoutai")
    @Column(name=GenIT_KykKihon.BOSKYKJYOUTAI)
    public C_Boskykjyoutai getBoskykjyoutai() {
        return boskykjyoutai;
    }

    public void setBoskykjyoutai(C_Boskykjyoutai pBoskykjyoutai) {
        boskykjyoutai = pBoskykjyoutai;
    }

    private Long kanyuusyano;

    @Column(name=GenIT_KykKihon.KANYUUSYANO)
    public Long getKanyuusyano() {
        return kanyuusyano;
    }

    public void setKanyuusyano(Long pKanyuusyano) {
        kanyuusyano = pKanyuusyano;
    }

    private C_DirectServiceMosKbn drctservicemoskbn;

    @Type(type="UserType_C_DirectServiceMosKbn")
    @Column(name=GenIT_KykKihon.DRCTSERVICEMOSKBN)
    public C_DirectServiceMosKbn getDrctservicemoskbn() {
        return drctservicemoskbn;
    }

    public void setDrctservicemoskbn(C_DirectServiceMosKbn pDrctservicemoskbn) {
        drctservicemoskbn = pDrctservicemoskbn;
    }

    private C_SkSyoukenSksKbn sksyoukenskskbn;

    @Type(type="UserType_C_SkSyoukenSksKbn")
    @Column(name=GenIT_KykKihon.SKSYOUKENSKSKBN)
    public C_SkSyoukenSksKbn getSksyoukenskskbn() {
        return sksyoukenskskbn;
    }

    public void setSksyoukenskskbn(C_SkSyoukenSksKbn pSksyoukenskskbn) {
        sksyoukenskskbn = pSksyoukenskskbn;
    }

    private BizDate sinkyksyokensakuseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykKihon.SINKYKSYOKENSAKUSEIYMD)
    public BizDate getSinkyksyokensakuseiymd() {
        return sinkyksyokensakuseiymd;
    }

    public void setSinkyksyokensakuseiymd(BizDate pSinkyksyokensakuseiymd) {
        sinkyksyokensakuseiymd = pSinkyksyokensakuseiymd;
    }

    private BizDate syoyousinkyksyohakkouymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykKihon.SYOYOUSINKYKSYOHAKKOUYMD)
    public BizDate getSyoyousinkyksyohakkouymd() {
        return syoyousinkyksyohakkouymd;
    }

    public void setSyoyousinkyksyohakkouymd(BizDate pSyoyousinkyksyohakkouymd) {
        syoyousinkyksyohakkouymd = pSyoyousinkyksyohakkouymd;
    }

    private String skjmosno;

    @Column(name=GenIT_KykKihon.SKJMOSNO)
    public String getSkjmosno() {
        return skjmosno;
    }

    public void setSkjmosno(String pSkjmosno) {
        skjmosno = pSkjmosno;
    }

    private C_NkIkouzumiKbn nkuikosumikbn;

    @Type(type="UserType_C_NkIkouzumiKbn")
    @Column(name=GenIT_KykKihon.NKUIKOSUMIKBN)
    public C_NkIkouzumiKbn getNkuikosumikbn() {
        return nkuikosumikbn;
    }

    public void setNkuikosumikbn(C_NkIkouzumiKbn pNkuikosumikbn) {
        nkuikosumikbn = pNkuikosumikbn;
    }

    private BizDate syhenkouymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykKihon.SYHENKOUYMD)
    public BizDate getSyhenkouymd() {
        return syhenkouymd;
    }

    @Trim("both")
    public void setSyhenkouymd(BizDate pSyhenkouymd) {
        syhenkouymd = pSyhenkouymd;
    }

    private BizDate lastsyosaihkymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykKihon.LASTSYOSAIHKYMD)
    public BizDate getLastsyosaihkymd() {
        return lastsyosaihkymd;
    }

    @Trim("both")
    public void setLastsyosaihkymd(BizDate pLastsyosaihkymd) {
        lastsyosaihkymd = pLastsyosaihkymd;
    }

    private BizDate lastmeihenymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykKihon.LASTMEIHENYMD)
    public BizDate getLastmeihenymd() {
        return lastmeihenymd;
    }

    @Trim("both")
    public void setLastmeihenymd(BizDate pLastmeihenymd) {
        lastmeihenymd = pLastmeihenymd;
    }

    private BizDate lastkykmeighnkymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykKihon.LASTKYKMEIGHNKYMD)
    public BizDate getLastkykmeighnkymd() {
        return lastkykmeighnkymd;
    }

    public void setLastkykmeighnkymd(BizDate pLastkykmeighnkymd) {
        lastkykmeighnkymd = pLastkykmeighnkymd;
    }

    private BizDate lastsbukthenymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykKihon.LASTSBUKTHENYMD)
    public BizDate getLastsbukthenymd() {
        return lastsbukthenymd;
    }

    public void setLastsbukthenymd(BizDate pLastsbukthenymd) {
        lastsbukthenymd = pLastsbukthenymd;
    }

    private BizDate lastkyknmseiymdhenkouymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykKihon.LASTKYKNMSEIYMDHENKOUYMD)
    public BizDate getLastkyknmseiymdhenkouymd() {
        return lastkyknmseiymdhenkouymd;
    }

    public void setLastkyknmseiymdhenkouymd(BizDate pLastkyknmseiymdhenkouymd) {
        lastkyknmseiymdhenkouymd = pLastkyknmseiymdhenkouymd;
    }

    private BizDate lastkyknmkanakjteiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykKihon.LASTKYKNMKANAKJTEIYMD)
    public BizDate getLastkyknmkanakjteiymd() {
        return lastkyknmkanakjteiymd;
    }

    public void setLastkyknmkanakjteiymd(BizDate pLastkyknmkanakjteiymd) {
        lastkyknmkanakjteiymd = pLastkyknmkanakjteiymd;
    }

    private BizDate lasttsinynohenkouymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykKihon.LASTTSINYNOHENKOUYMD)
    public BizDate getLasttsinynohenkouymd() {
        return lasttsinynohenkouymd;
    }

    public void setLasttsinynohenkouymd(BizDate pLasttsinynohenkouymd) {
        lasttsinynohenkouymd = pLasttsinynohenkouymd;
    }

    private BizDate lastjyuuhenymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_KykKihon.LASTJYUUHENYMD)
    public BizDate getLastjyuuhenymd() {
        return lastjyuuhenymd;
    }

    @Trim("both")
    public void setLastjyuuhenymd(BizDate pLastjyuuhenymd) {
        lastjyuuhenymd = pLastjyuuhenymd;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KykKihon.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KykKihon.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KykKihon.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private C_TrhkjiKakKbn seiritujitrhkjikakkbn;

    @Type(type="UserType_C_TrhkjiKakKbn")
    @Column(name=GenIT_KykKihon.SEIRITUJITRHKJIKAKKBN)
    public C_TrhkjiKakKbn getSeiritujitrhkjikakkbn() {
        return seiritujitrhkjikakkbn;
    }

    public void setSeiritujitrhkjikakkbn(C_TrhkjiKakKbn pSeiritujitrhkjikakkbn) {
        seiritujitrhkjikakkbn = pSeiritujitrhkjikakkbn;
    }

    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    @Type(type="UserType_C_TkiktbrisyuruiKbn")
    @Column(name=GenIT_KykKihon.TIKIKTBRISYURUIKBN)
    public C_TkiktbrisyuruiKbn getTikiktbrisyuruikbn() {
        return tikiktbrisyuruikbn;
    }

    public void setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn) {
        tikiktbrisyuruikbn = pTikiktbrisyuruikbn;
    }

    private C_YakkanJyuryouKbn yakkanjyuryouhoukbn;

    @Type(type="UserType_C_YakkanJyuryouKbn")
    @Column(name=GenIT_KykKihon.YAKKANJYURYOUHOUKBN)
    public C_YakkanJyuryouKbn getYakkanjyuryouhoukbn() {
        return yakkanjyuryouhoukbn;
    }

    public void setYakkanjyuryouhoukbn(C_YakkanJyuryouKbn pYakkanjyuryouhoukbn) {
        yakkanjyuryouhoukbn = pYakkanjyuryouhoukbn;
    }

    private String yakkanbunsyono;

    @Column(name=GenIT_KykKihon.YAKKANBUNSYONO)
    public String getYakkanbunsyono() {
        return yakkanbunsyono;
    }

    public void setYakkanbunsyono(String pYakkanbunsyono) {
        yakkanbunsyono = pYakkanbunsyono;
    }

    private String siorino;

    @Column(name=GenIT_KykKihon.SIORINO)
    public String getSiorino() {
        return siorino;
    }

    public void setSiorino(String pSiorino) {
        siorino = pSiorino;
    }

    private C_YnkHrkmgkAnniTuutiKbn ynkhrkmgkannituutikbn;

    @Type(type="UserType_C_YnkHrkmgkAnniTuutiKbn")
    @Column(name=GenIT_KykKihon.YNKHRKMGKANNITUUTIKBN)
    public C_YnkHrkmgkAnniTuutiKbn getYnkhrkmgkannituutikbn() {
        return ynkhrkmgkannituutikbn;
    }

    public void setYnkhrkmgkannituutikbn(C_YnkHrkmgkAnniTuutiKbn pYnkhrkmgkannituutikbn) {
        ynkhrkmgkannituutikbn = pYnkhrkmgkannituutikbn;
    }
}