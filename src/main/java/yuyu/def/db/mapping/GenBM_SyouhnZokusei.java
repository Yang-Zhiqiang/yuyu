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
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DrtSyouhinSikibetuKbn;
import yuyu.def.classification.C_Gwhensyuuoutjyuni;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HknkknBunruiKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_IjitoukeiHokensyuruiKbn;
import yuyu.def.classification.C_IsatoukeiHokensyuruicd;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_Kaiyakuhrtype;
import yuyu.def.classification.C_KihonssyuruiKbn;
import yuyu.def.classification.C_KokutiKbn;
import yuyu.def.classification.C_KoujyosyoumeipKbn;
import yuyu.def.classification.C_MousideIkouKbn;
import yuyu.def.classification.C_Nstkumu;
import yuyu.def.classification.C_PWaribikiKbn;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ShrtysyhknsyuKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TargetTkHukaKanouKbn;
import yuyu.def.classification.C_TkthknsyruitsnKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TyksenhokanhouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YoteirirituhendouKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.id.PKBM_SyouhnZokusei;
import yuyu.def.db.meta.GenQBM_SyouhnZokusei;
import yuyu.def.db.meta.QBM_SyouhnZokusei;
import yuyu.def.db.type.UserType_C_DrtSyouhinSikibetuKbn;
import yuyu.def.db.type.UserType_C_Gwhensyuuoutjyuni;
import yuyu.def.db.type.UserType_C_HaitouKbn;
import yuyu.def.db.type.UserType_C_HknkknBunruiKbn;
import yuyu.def.db.type.UserType_C_HknsyuruiNo;
import yuyu.def.db.type.UserType_C_IjitoukeiHokensyuruiKbn;
import yuyu.def.db.type.UserType_C_IsatoukeiHokensyuruicd;
import yuyu.def.db.type.UserType_C_KahiKbn;
import yuyu.def.db.type.UserType_C_Kaiyakuhrtype;
import yuyu.def.db.type.UserType_C_KihonssyuruiKbn;
import yuyu.def.db.type.UserType_C_KokutiKbn;
import yuyu.def.db.type.UserType_C_KoujyosyoumeipKbn;
import yuyu.def.db.type.UserType_C_MousideIkouKbn;
import yuyu.def.db.type.UserType_C_Nstkumu;
import yuyu.def.db.type.UserType_C_PWaribikiKbn;
import yuyu.def.db.type.UserType_C_PtratkituukasiteiKbn;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_ShrtysyhknsyuKbn;
import yuyu.def.db.type.UserType_C_Sisuukbn;
import yuyu.def.db.type.UserType_C_Sknenkinsyu;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_TargetTkHukaKanouKbn;
import yuyu.def.db.type.UserType_C_TkthknsyruitsnKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_TyksenhokanhouKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YoteirirituhendouKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 商品属性マスタ テーブルのマッピング情報クラスで、 {@link BM_SyouhnZokusei} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_SyouhnZokusei}</td><td colspan="3">商品属性マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_SyouhnZokusei ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">{@link PKBM_SyouhnZokusei ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getRyouritusdno ryouritusdno}</td><td>料率世代番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyohnsortno syohnsortno}</td><td>商品ソート番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getMossyohnsortno mossyohnsortno}</td><td>申込書商品ソート番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyouhnnm syouhnnm}</td><td>商品名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnnmryaku syouhnnmryaku}</td><td>商品名（略称）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnnmryaku5 syouhnnmryaku5}</td><td>商品名（略称）_5</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnnmsyouken syouhnnmsyouken}</td><td>商品名（証券用）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnnmworklist syouhnnmworklist}</td><td>商品名（ワークリスト用）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKykfromymd kykfromymd}</td><td>契約日自</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKyktoymd kyktoymd}</td><td>契約日至</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHyoujifromymd hyoujifromymd}</td><td>表示日自</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getHyoujitoymd hyoujitoymd}</td><td>表示日至</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyutkkbn syutkkbn}</td><td>主契約特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyutkKbn}</td></tr>
 *  <tr><td>{@link #getHknsyuruino hknsyuruino}</td><td>保険種類番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HknsyuruiNo}</td></tr>
 *  <tr><td>{@link #getToukeiyouhokensyuruikbn toukeiyouhokensyuruikbn}</td><td>統計用保険種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getIjitoukeihokensyuruikbn ijitoukeihokensyuruikbn}</td><td>医事統計用保険種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_IjitoukeiHokensyuruiKbn}</td></tr>
 *  <tr><td>{@link #getIsatoukeihokensyuruicd isatoukeihokensyuruicd}</td><td>医査統計用保険種類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_IsatoukeiHokensyuruicd}</td></tr>
 *  <tr><td>{@link #getYoteirirituhendoukbn yoteirirituhendoukbn}</td><td>予定利率変動区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YoteirirituhendouKbn}</td></tr>
 *  <tr><td>{@link #getYoteirirituhosyoukkn yoteirirituhosyoukkn}</td><td>予定利率保証期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getYoteirirituminhosyouritu yoteirirituminhosyouritu}</td><td>予定利率最低保証率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getNkgnshosyouritu nkgnshosyouritu}</td><td>年金原資最低保証率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDai1hknkkn dai1hknkkn}</td><td>第１保険期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDrtsyouhinsikibetukbn drtsyouhinsikibetukbn}</td><td>代理店商品識別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DrtSyouhinSikibetuKbn}</td></tr>
 *  <tr><td>{@link #getDrthrkhouhoukbn drthrkhouhoukbn}</td><td>代理店払込方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDrtplannmkbn drtplannmkbn}</td><td>代理店プラン名区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getPtratkituukasiteikbn ptratkituukasiteikbn}</td><td>保険料取扱通貨指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_PtratkituukasiteiKbn}</td></tr>
 *  <tr><td>{@link #getJikounensuu jikounensuu}</td><td>時効年数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getNtgksbairitu ntgksbairitu}</td><td>日額Ｓ倍率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSbhkuktumu sbhkuktumu}</td><td>死亡保険金受取有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSbkyuuhukinuktumu sbkyuuhukinuktumu}</td><td>死亡給付金受取有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSbhnknuktumu sbhnknuktumu}</td><td>死亡返還金受取有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSbuktumu sbuktumu}</td><td>死亡受取有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getMnkuktumu mnkuktumu}</td><td>満期受取有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSiteidairiumu siteidairiumu}</td><td>指定代理人有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKktumu kktumu}</td><td>告知有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHjyumu hjyumu}</td><td>報状有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getMusenumu musenumu}</td><td>無選択有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSyokugyoukktumu syokugyoukktumu}</td><td>職業告知有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKokutikbn kokutikbn}</td><td>告知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KokutiKbn}</td></tr>
 *  <tr><td>{@link #getSdumu sdumu}</td><td>Ｓ建有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getPdumu pdumu}</td><td>Ｐ建有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getGijipdumu gijipdumu}</td><td>擬似Ｐ建有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHokenkngkyakujyouumu hokenkngkyakujyouumu}</td><td>保険金額約定有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHaitoukbn haitoukbn}</td><td>配当区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HaitouKbn}</td></tr>
 *  <tr><td>{@link #getTeikisiharaikinumu teikisiharaikinumu}</td><td>定期支払金有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKyhkataumu kyhkataumu}</td><td>給付型有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSyukyhkinkataumu syukyhkinkataumu}</td><td>手術給付金型有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getRokudaildumu rokudaildumu}</td><td>６大生活習慣病追加給付型有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKhnkyhkgbairituumu khnkyhkgbairituumu}</td><td>基本給付金額倍率有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getItijibrumu itijibrumu}</td><td>一時払有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHeijyunbaraiumu heijyunbaraiumu}</td><td>平準払有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getZennouumu zennouumu}</td><td>前納有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getItibuzennoutekiumu itibuzennoutekiumu}</td><td>一部前納適用有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getZenkizennoutekiumu zenkizennoutekiumu}</td><td>全期前納適用有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getIkkatubaraiumu ikkatubaraiumu}</td><td>一括払有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTeikiikkatubaraiumu teikiikkatubaraiumu}</td><td>定期一括払有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getPwaribikikbn pwaribikikbn}</td><td>保険料割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_PWaribikiKbn}</td></tr>
 *  <tr><td>{@link #getTkjyrmtekiumu tkjyrmtekiumu}</td><td>特条料増適用有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTkjyskgntekiumu tkjyskgntekiumu}</td><td>特条削減適用有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHtnpbuitekiumu htnpbuitekiumu}</td><td>不担保部位適用有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTokkoudosghtnptekiumu tokkoudosghtnptekiumu}</td><td>特定高度障害不担保適用有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getJkntekiumu jkntekiumu}</td><td>条件付適用有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getLivtkumu livtkumu}</td><td>リビングニーズ特約有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKzktourokuserviceumu kzktourokuserviceumu}</td><td>家族登録サービス有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getStdrsktkumu stdrsktkumu}</td><td>被保険者代理特約有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKykdrtkykumu kykdrtkykumu}</td><td>契約者代理特約有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getPmnjtkumu pmnjtkumu}</td><td>保険料免除特約有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSknnkaisikitkumu sknnkaisikitkumu}</td><td>責任開始期特約有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getGaikatatkiumu gaikatatkiumu}</td><td>外貨取扱有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHengakuumu hengakuumu}</td><td>変額保険有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getNsikoutkumu nsikoutkumu}</td><td>年金支払移行特約有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getNstkumu nstkumu}</td><td>年金支払特約有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Nstkumu}</td></tr>
 *  <tr><td>{@link #getSyksbyensitihsyutktekiumu syksbyensitihsyutktekiumu}</td><td>初期死亡時円換算最低保証特約適用有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getJyudkaigomehrtktekiumu jyudkaigomehrtktekiumu}</td><td>重度介護前払特約適用有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getStknumu stknumu}</td><td>質権有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getApltekiumu apltekiumu}</td><td>ＡＰＬ適用有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getJgyiktumu jgyiktumu}</td><td>事業一括有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHutuusbhsyumu hutuusbhsyumu}</td><td>普通死亡保障有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSgsbhsyumu sgsbhsyumu}</td><td>災害死亡保障有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSougouiryhsyumu sougouiryhsyumu}</td><td>総合医療保障有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSyuusinhknumu syuusinhknumu}</td><td>終身保険有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getYrhknumu yrhknumu}</td><td>養老保険有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getNkhknumu nkhknumu}</td><td>年金保険有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSipnyukyhumu sipnyukyhumu}</td><td>疾病入院給付有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSgnyukyhumu sgnyukyhumu}</td><td>災害入院給付有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSjnyukyhumu sjnyukyhumu}</td><td>成人病入院給付有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getGannyukyhumu gannyukyhumu}</td><td>がん入院給付有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKihonsntgkumu kihonsntgkumu}</td><td>基本Ｓ日額有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getGansdkyhumu gansdkyhumu}</td><td>がん診断給付有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getGanhsyngumu ganhsyngumu}</td><td>がん保障日額有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getEightysaimnrytkumu eightysaimnrytkumu}</td><td>８０歳満了特約有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSaiteisknwtkumu saiteisknwtkumu}</td><td>最低Ｓ緩和特約有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getDountgkchkumu dountgkchkumu}</td><td>同一日額チェック有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getDoukknchkumu doukknchkumu}</td><td>同一期間チェック有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getDoukatachkumu doukatachkumu}</td><td>同一型チェック有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTyouhukuknyumu tyouhukuknyumu}</td><td>重複加入チェック有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getStsnumu stsnumu}</td><td>Ｓ通算有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getNkgnstuusanumu nkgnstuusanumu}</td><td>年金原資通算有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getNenbtsousbustuusanumu nenbtsousbustuusanumu}</td><td>年齢別総死亡Ｓ通算有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSoukktjituhsgktuusanumu soukktjituhsgktuusanumu}</td><td>総告知書実質保障額通算有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getMsnynenbtsbustuusanumu msnynenbtsbustuusanumu}</td><td>未成年用年齢別死亡Ｓ通算有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKktjituhsgk1tuusanumu kktjituhsgk1tuusanumu}</td><td>告知書実保障額１通算有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKktjituhsgk2tuusanumu kktjituhsgk2tuusanumu}</td><td>告知書実保障額２通算有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getItijibrptsnumu itijibrptsnumu}</td><td>一時払Ｐ通算有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTkthknsyruitsnkbn tkthknsyruitsnkbn}</td><td>特定保険種類通算区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TkthknsyruitsnKbn}</td></tr>
 *  <tr><td>{@link #getYenhrkgktuusansiyouumu yenhrkgktuusansiyouumu}</td><td>円貨払込金額通算使用有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKykdrtentuusanumu kykdrtentuusanumu}</td><td>契約者同一代理店通算有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getPyennykntktekiumu pyennykntktekiumu}</td><td>保険料円入金特約適用有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getYenshrtktekiumu yenshrtktekiumu}</td><td>円支払特約適用有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getGaikanyuukintktekiumu gaikanyuukintktekiumu}</td><td>外貨入金特約適用有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKnrrenkatasyouhnumu knrrenkatasyouhnumu}</td><td>金利連動型商品有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getGstsumu gstsumu}</td><td>源泉徴収対象有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getNenmnryumu nenmnryumu}</td><td>年満了取扱有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKaiyakuhrtype kaiyakuhrtype}</td><td>解約返戻金支払タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kaiyakuhrtype}</td></tr>
 *  <tr><td>{@link #getKaiyakuhrbairitu kaiyakuhrbairitu}</td><td>解約返戻金倍率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHukkatukanouy hukkatukanouy}</td><td>復活可能年数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHukkatukanoum hukkatukanoum}</td><td>復活可能月数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getPratetani pratetani}</td><td>Ｐレート単位</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVratetani vratetani}</td><td>Ｖレート単位</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWratetani wratetani}</td><td>Ｗレート単位</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKihonssyuruikbn kihonssyuruikbn}</td><td>基本Ｓ種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KihonssyuruiKbn}</td></tr>
 *  <tr><td>{@link #getGengakukahikbn gengakukahikbn}</td><td>基本Ｓ減額可否区分</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getPgengakukahikbn pgengakukahikbn}</td><td>保険料減額可否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KahiKbn}</td></tr>
 *  <tr><td>{@link #getHjnkykumukbn hjnkykumukbn}</td><td>法人契約有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getCreditcardhrtekiumu creditcardhrtekiumu}</td><td>クレジットカード払適用有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKouzahurikaebaraitekiumu kouzahurikaebaraitekiumu}</td><td>口座振替払適用有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTsnshrgndgkhyoujiumu tsnshrgndgkhyoujiumu}</td><td>通算支払限度額表示有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTsnshrgndgk tsnshrgndgk}</td><td>通算支払限度額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getItjsytkkziumu itjsytkkziumu}</td><td>一時所得課税有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getGansknnkaisiymdumu gansknnkaisiymdumu}</td><td>がん責任開始日有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getGansknnkaisikeikanisuu gansknnkaisikeikanisuu}</td><td>がん責任開始経過日数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getGantkhktctrlumu gantkhktctrlumu}</td><td>がん特約復活制御有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getIktpcalcssketasuu iktpcalcssketasuu}</td><td>一括払Ｐ計算小数桁数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTratkikanousinsahou tratkikanousinsahou}</td><td>取扱可能診査方法</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKostratkiumu kostratkiumu}</td><td>更新取扱有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKosmnrynen kosmnrynen}</td><td>更新満了年齢</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getShrtysysksumu shrtysysksumu}</td><td>支払調書作成有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getShrtysyhknsyukbn shrtysyhknsyukbn}</td><td>支払調書保険種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ShrtysyhknsyuKbn}</td></tr>
 *  <tr><td>{@link #getSynndkyfknshrskgnumu synndkyfknshrskgnumu}</td><td>初年度給付金支払削減有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getDai1hknkknsbsyokuseiumu dai1hknkknsbsyokuseiumu}</td><td>第１保険期間中死亡保険金額抑制有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHknkknbunruikbn hknkknbunruikbn}</td><td>保険期間分類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HknkknBunruiKbn}</td></tr>
 *  <tr><td>{@link #getMvatekiumu mvatekiumu}</td><td>ＭＶＡ適用有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getMvatekikkn mvatekikkn}</td><td>ＭＶＡ適用期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getMvatyouseijikou mvatyouseijikou}</td><td>ＭＶＡ調整項</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKaiyakukoujyoritutekiumu kaiyakukoujyoritutekiumu}</td><td>解約控除率適用有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKaiyakukoujyoritutekikkn kaiyakukoujyoritutekikkn}</td><td>解約控除率適用期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTkbripfgk tkbripfgk}</td><td>月払Ｐｆ金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getHnnnbripfgk hnnnbripfgk}</td><td>半年払Ｐｆ金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getNnbripfgk nnbripfgk}</td><td>年払Ｐｆ金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>{@link #getGwhensyuuoutjyuni gwhensyuuoutjyuni}</td><td>ＧＷ編集出力順位</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Gwhensyuuoutjyuni}</td></tr>
 *  <tr><td>{@link #getKoujyosyoumeipkbn koujyosyoumeipkbn}</td><td>控除証明保険料区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KoujyosyoumeipKbn}</td></tr>
 *  <tr><td>{@link #getZeiseitekikakuumu zeiseitekikakuumu}</td><td>税制適格有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getFatcataisyouumu fatcataisyouumu}</td><td>ＦＡＴＣＡ対象有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getAeoitaisyouumu aeoitaisyouumu}</td><td>ＡＥＯＩ対象有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHouteityotkseiumu houteityotkseiumu}</td><td>法定貯蓄性有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSeg1cd seg1cd}</td><td>セグメント１コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>{@link #getSeg2cd seg2cd}</td><td>セグメント２コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>{@link #getGwhknsyurui gwhknsyurui}</td><td>ＧＷ＿保険種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGwhosyucd gwhosyucd}</td><td>ＧＷ＿保種コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGwsyouhncd gwsyouhncd}</td><td>ＧＷ＿商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGwsyouhnnm gwsyouhnnm}</td><td>ＧＷ＿商品名称</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHknsyuruikoujyosyoumei hknsyuruikoujyosyoumei}</td><td>保険種類（控除証明書）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSknenkinsyu sknenkinsyu}</td><td>新契約年金種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Sknenkinsyu}</td></tr>
 *  <tr><td>{@link #getNkuktumu nkuktumu}</td><td>年金受取有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTmttknhaibunwarisiteiumu tmttknhaibunwarisiteiumu}</td><td>積立金配分割合指定有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTargettkhukakanoukbn targettkhukakanoukbn}</td><td>ターゲット特約付加可能区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TargetTkHukaKanouKbn}</td></tr>
 *  <tr><td>{@link #getMousideikoukbn mousideikoukbn}</td><td>申出移行区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MousideIkouKbn}</td></tr>
 *  <tr><td>{@link #getYendthnksyouhncd yendthnksyouhncd}</td><td>円建変更後商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSisuukbn sisuukbn}</td><td>指数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Sisuukbn}</td></tr>
 *  <tr><td>{@link #getTyksenhokanhoukbn tyksenhokanhoukbn}</td><td>直線補間方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TyksenhokanhouKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_SyouhnZokusei
 * @see     PKBM_SyouhnZokusei
 * @see     QBM_SyouhnZokusei
 * @see     GenQBM_SyouhnZokusei
 */
@MappedSuperclass
@Table(name=GenBM_SyouhnZokusei.TABLE_NAME)
@IdClass(value=PKBM_SyouhnZokusei.class)
@TypeDefs({
    @TypeDef(name="BizCurrencyType", typeClass=BizCurrencyType.class),
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_DrtSyouhinSikibetuKbn", typeClass=UserType_C_DrtSyouhinSikibetuKbn.class),
    @TypeDef(name="UserType_C_Gwhensyuuoutjyuni", typeClass=UserType_C_Gwhensyuuoutjyuni.class),
    @TypeDef(name="UserType_C_HaitouKbn", typeClass=UserType_C_HaitouKbn.class),
    @TypeDef(name="UserType_C_HknkknBunruiKbn", typeClass=UserType_C_HknkknBunruiKbn.class),
    @TypeDef(name="UserType_C_HknsyuruiNo", typeClass=UserType_C_HknsyuruiNo.class),
    @TypeDef(name="UserType_C_IjitoukeiHokensyuruiKbn", typeClass=UserType_C_IjitoukeiHokensyuruiKbn.class),
    @TypeDef(name="UserType_C_IsatoukeiHokensyuruicd", typeClass=UserType_C_IsatoukeiHokensyuruicd.class),
    @TypeDef(name="UserType_C_KahiKbn", typeClass=UserType_C_KahiKbn.class),
    @TypeDef(name="UserType_C_Kaiyakuhrtype", typeClass=UserType_C_Kaiyakuhrtype.class),
    @TypeDef(name="UserType_C_KihonssyuruiKbn", typeClass=UserType_C_KihonssyuruiKbn.class),
    @TypeDef(name="UserType_C_KokutiKbn", typeClass=UserType_C_KokutiKbn.class),
    @TypeDef(name="UserType_C_KoujyosyoumeipKbn", typeClass=UserType_C_KoujyosyoumeipKbn.class),
    @TypeDef(name="UserType_C_MousideIkouKbn", typeClass=UserType_C_MousideIkouKbn.class),
    @TypeDef(name="UserType_C_Nstkumu", typeClass=UserType_C_Nstkumu.class),
    @TypeDef(name="UserType_C_PWaribikiKbn", typeClass=UserType_C_PWaribikiKbn.class),
    @TypeDef(name="UserType_C_PtratkituukasiteiKbn", typeClass=UserType_C_PtratkituukasiteiKbn.class),
    @TypeDef(name="UserType_C_Segcd", typeClass=UserType_C_Segcd.class),
    @TypeDef(name="UserType_C_ShrtysyhknsyuKbn", typeClass=UserType_C_ShrtysyhknsyuKbn.class),
    @TypeDef(name="UserType_C_Sisuukbn", typeClass=UserType_C_Sisuukbn.class),
    @TypeDef(name="UserType_C_Sknenkinsyu", typeClass=UserType_C_Sknenkinsyu.class),
    @TypeDef(name="UserType_C_SyutkKbn", typeClass=UserType_C_SyutkKbn.class),
    @TypeDef(name="UserType_C_TargetTkHukaKanouKbn", typeClass=UserType_C_TargetTkHukaKanouKbn.class),
    @TypeDef(name="UserType_C_TkthknsyruitsnKbn", typeClass=UserType_C_TkthknsyruitsnKbn.class),
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class),
    @TypeDef(name="UserType_C_TyksenhokanhouKbn", typeClass=UserType_C_TyksenhokanhouKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YoteirirituhendouKbn", typeClass=UserType_C_YoteirirituhendouKbn.class)
})
public abstract class GenBM_SyouhnZokusei extends AbstractExDBEntity<BM_SyouhnZokusei, PKBM_SyouhnZokusei> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_SyouhnZokusei";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String RYOURITUSDNO             = "ryouritusdno";
    public static final String SYOHNSORTNO              = "syohnsortno";
    public static final String MOSSYOHNSORTNO           = "mossyohnsortno";
    public static final String SYOUHNNM                 = "syouhnnm";
    public static final String SYOUHNNMRYAKU            = "syouhnnmryaku";
    public static final String SYOUHNNMRYAKU5           = "syouhnnmryaku5";
    public static final String SYOUHNNMSYOUKEN          = "syouhnnmsyouken";
    public static final String SYOUHNNMWORKLIST         = "syouhnnmworklist";
    public static final String KYKFROMYMD               = "kykfromymd";
    public static final String KYKTOYMD                 = "kyktoymd";
    public static final String HYOUJIFROMYMD            = "hyoujifromymd";
    public static final String HYOUJITOYMD              = "hyoujitoymd";
    public static final String SYUTKKBN                 = "syutkkbn";
    public static final String HKNSYURUINO              = "hknsyuruino";
    public static final String TOUKEIYOUHOKENSYURUIKBN  = "toukeiyouhokensyuruikbn";
    public static final String IJITOUKEIHOKENSYURUIKBN  = "ijitoukeihokensyuruikbn";
    public static final String ISATOUKEIHOKENSYURUICD   = "isatoukeihokensyuruicd";
    public static final String YOTEIRIRITUHENDOUKBN     = "yoteirirituhendoukbn";
    public static final String YOTEIRIRITUHOSYOUKKN     = "yoteirirituhosyoukkn";
    public static final String YOTEIRIRITUMINHOSYOURITU = "yoteirirituminhosyouritu";
    public static final String NKGNSHOSYOURITU          = "nkgnshosyouritu";
    public static final String DAI1HKNKKN               = "dai1hknkkn";
    public static final String DRTSYOUHINSIKIBETUKBN    = "drtsyouhinsikibetukbn";
    public static final String DRTHRKHOUHOUKBN          = "drthrkhouhoukbn";
    public static final String DRTPLANNMKBN             = "drtplannmkbn";
    public static final String TUUKASYU                 = "tuukasyu";
    public static final String PTRATKITUUKASITEIKBN     = "ptratkituukasiteikbn";
    public static final String JIKOUNENSUU              = "jikounensuu";
    public static final String NTGKSBAIRITU             = "ntgksbairitu";
    public static final String SBHKUKTUMU               = "sbhkuktumu";
    public static final String SBKYUUHUKINUKTUMU        = "sbkyuuhukinuktumu";
    public static final String SBHNKNUKTUMU             = "sbhnknuktumu";
    public static final String SBUKTUMU                 = "sbuktumu";
    public static final String MNKUKTUMU                = "mnkuktumu";
    public static final String SITEIDAIRIUMU            = "siteidairiumu";
    public static final String KKTUMU                   = "kktumu";
    public static final String HJYUMU                   = "hjyumu";
    public static final String MUSENUMU                 = "musenumu";
    public static final String SYOKUGYOUKKTUMU          = "syokugyoukktumu";
    public static final String KOKUTIKBN                = "kokutikbn";
    public static final String SDUMU                    = "sdumu";
    public static final String PDUMU                    = "pdumu";
    public static final String GIJIPDUMU                = "gijipdumu";
    public static final String HOKENKNGKYAKUJYOUUMU     = "hokenkngkyakujyouumu";
    public static final String HAITOUKBN                = "haitoukbn";
    public static final String TEIKISIHARAIKINUMU       = "teikisiharaikinumu";
    public static final String KYHKATAUMU               = "kyhkataumu";
    public static final String SYUKYHKINKATAUMU         = "syukyhkinkataumu";
    public static final String ROKUDAILDUMU             = "rokudaildumu";
    public static final String KHNKYHKGBAIRITUUMU       = "khnkyhkgbairituumu";
    public static final String ITIJIBRUMU               = "itijibrumu";
    public static final String HEIJYUNBARAIUMU          = "heijyunbaraiumu";
    public static final String ZENNOUUMU                = "zennouumu";
    public static final String ITIBUZENNOUTEKIUMU       = "itibuzennoutekiumu";
    public static final String ZENKIZENNOUTEKIUMU       = "zenkizennoutekiumu";
    public static final String IKKATUBARAIUMU           = "ikkatubaraiumu";
    public static final String TEIKIIKKATUBARAIUMU      = "teikiikkatubaraiumu";
    public static final String PWARIBIKIKBN             = "pwaribikikbn";
    public static final String TKJYRMTEKIUMU            = "tkjyrmtekiumu";
    public static final String TKJYSKGNTEKIUMU          = "tkjyskgntekiumu";
    public static final String HTNPBUITEKIUMU           = "htnpbuitekiumu";
    public static final String TOKKOUDOSGHTNPTEKIUMU    = "tokkoudosghtnptekiumu";
    public static final String JKNTEKIUMU               = "jkntekiumu";
    public static final String LIVTKUMU                 = "livtkumu";
    public static final String KZKTOUROKUSERVICEUMU     = "kzktourokuserviceumu";
    public static final String STDRSKTKUMU              = "stdrsktkumu";
    public static final String KYKDRTKYKUMU             = "kykdrtkykumu";
    public static final String PMNJTKUMU                = "pmnjtkumu";
    public static final String SKNNKAISIKITKUMU         = "sknnkaisikitkumu";
    public static final String GAIKATATKIUMU            = "gaikatatkiumu";
    public static final String HENGAKUUMU               = "hengakuumu";
    public static final String NSIKOUTKUMU              = "nsikoutkumu";
    public static final String NSTKUMU                  = "nstkumu";
    public static final String SYKSBYENSITIHSYUTKTEKIUMU = "syksbyensitihsyutktekiumu";
    public static final String JYUDKAIGOMEHRTKTEKIUMU   = "jyudkaigomehrtktekiumu";
    public static final String STKNUMU                  = "stknumu";
    public static final String APLTEKIUMU               = "apltekiumu";
    public static final String JGYIKTUMU                = "jgyiktumu";
    public static final String HUTUUSBHSYUMU            = "hutuusbhsyumu";
    public static final String SGSBHSYUMU               = "sgsbhsyumu";
    public static final String SOUGOUIRYHSYUMU          = "sougouiryhsyumu";
    public static final String SYUUSINHKNUMU            = "syuusinhknumu";
    public static final String YRHKNUMU                 = "yrhknumu";
    public static final String NKHKNUMU                 = "nkhknumu";
    public static final String SIPNYUKYHUMU             = "sipnyukyhumu";
    public static final String SGNYUKYHUMU              = "sgnyukyhumu";
    public static final String SJNYUKYHUMU              = "sjnyukyhumu";
    public static final String GANNYUKYHUMU             = "gannyukyhumu";
    public static final String KIHONSNTGKUMU            = "kihonsntgkumu";
    public static final String GANSDKYHUMU              = "gansdkyhumu";
    public static final String GANHSYNGUMU              = "ganhsyngumu";
    public static final String EIGHTYSAIMNRYTKUMU       = "eightysaimnrytkumu";
    public static final String SAITEISKNWTKUMU          = "saiteisknwtkumu";
    public static final String DOUNTGKCHKUMU            = "dountgkchkumu";
    public static final String DOUKKNCHKUMU             = "doukknchkumu";
    public static final String DOUKATACHKUMU            = "doukatachkumu";
    public static final String TYOUHUKUKNYUMU           = "tyouhukuknyumu";
    public static final String STSNUMU                  = "stsnumu";
    public static final String NKGNSTUUSANUMU           = "nkgnstuusanumu";
    public static final String NENBTSOUSBUSTUUSANUMU    = "nenbtsousbustuusanumu";
    public static final String SOUKKTJITUHSGKTUUSANUMU  = "soukktjituhsgktuusanumu";
    public static final String MSNYNENBTSBUSTUUSANUMU   = "msnynenbtsbustuusanumu";
    public static final String KKTJITUHSGK1TUUSANUMU    = "kktjituhsgk1tuusanumu";
    public static final String KKTJITUHSGK2TUUSANUMU    = "kktjituhsgk2tuusanumu";
    public static final String ITIJIBRPTSNUMU           = "itijibrptsnumu";
    public static final String TKTHKNSYRUITSNKBN        = "tkthknsyruitsnkbn";
    public static final String YENHRKGKTUUSANSIYOUUMU   = "yenhrkgktuusansiyouumu";
    public static final String KYKDRTENTUUSANUMU        = "kykdrtentuusanumu";
    public static final String PYENNYKNTKTEKIUMU        = "pyennykntktekiumu";
    public static final String YENSHRTKTEKIUMU          = "yenshrtktekiumu";
    public static final String GAIKANYUUKINTKTEKIUMU    = "gaikanyuukintktekiumu";
    public static final String KNRRENKATASYOUHNUMU      = "knrrenkatasyouhnumu";
    public static final String GSTSUMU                  = "gstsumu";
    public static final String NENMNRYUMU               = "nenmnryumu";
    public static final String KAIYAKUHRTYPE            = "kaiyakuhrtype";
    public static final String KAIYAKUHRBAIRITU         = "kaiyakuhrbairitu";
    public static final String HUKKATUKANOUY            = "hukkatukanouy";
    public static final String HUKKATUKANOUM            = "hukkatukanoum";
    public static final String PRATETANI                = "pratetani";
    public static final String VRATETANI                = "vratetani";
    public static final String WRATETANI                = "wratetani";
    public static final String KIHONSSYURUIKBN          = "kihonssyuruikbn";
    public static final String GENGAKUKAHIKBN           = "gengakukahikbn";
    public static final String PGENGAKUKAHIKBN          = "pgengakukahikbn";
    public static final String HJNKYKUMUKBN             = "hjnkykumukbn";
    public static final String CREDITCARDHRTEKIUMU      = "creditcardhrtekiumu";
    public static final String KOUZAHURIKAEBARAITEKIUMU = "kouzahurikaebaraitekiumu";
    public static final String TSNSHRGNDGKHYOUJIUMU     = "tsnshrgndgkhyoujiumu";
    public static final String TSNSHRGNDGK              = "tsnshrgndgk";
    public static final String ITJSYTKKZIUMU            = "itjsytkkziumu";
    public static final String GANSKNNKAISIYMDUMU       = "gansknnkaisiymdumu";
    public static final String GANSKNNKAISIKEIKANISUU   = "gansknnkaisikeikanisuu";
    public static final String GANTKHKTCTRLUMU          = "gantkhktctrlumu";
    public static final String IKTPCALCSSKETASUU        = "iktpcalcssketasuu";
    public static final String TRATKIKANOUSINSAHOU      = "tratkikanousinsahou";
    public static final String KOSTRATKIUMU             = "kostratkiumu";
    public static final String KOSMNRYNEN               = "kosmnrynen";
    public static final String SHRTYSYSKSUMU            = "shrtysysksumu";
    public static final String SHRTYSYHKNSYUKBN         = "shrtysyhknsyukbn";
    public static final String SYNNDKYFKNSHRSKGNUMU     = "synndkyfknshrskgnumu";
    public static final String DAI1HKNKKNSBSYOKUSEIUMU  = "dai1hknkknsbsyokuseiumu";
    public static final String HKNKKNBUNRUIKBN          = "hknkknbunruikbn";
    public static final String MVATEKIUMU               = "mvatekiumu";
    public static final String MVATEKIKKN               = "mvatekikkn";
    public static final String MVATYOUSEIJIKOU          = "mvatyouseijikou";
    public static final String KAIYAKUKOUJYORITUTEKIUMU = "kaiyakukoujyoritutekiumu";
    public static final String KAIYAKUKOUJYORITUTEKIKKN = "kaiyakukoujyoritutekikkn";
    public static final String TKBRIPFGK                = "tkbripfgk";
    public static final String HNNNBRIPFGK              = "hnnnbripfgk";
    public static final String NNBRIPFGK                = "nnbripfgk";
    public static final String GWHENSYUUOUTJYUNI        = "gwhensyuuoutjyuni";
    public static final String KOUJYOSYOUMEIPKBN        = "koujyosyoumeipkbn";
    public static final String ZEISEITEKIKAKUUMU        = "zeiseitekikakuumu";
    public static final String FATCATAISYOUUMU          = "fatcataisyouumu";
    public static final String AEOITAISYOUUMU           = "aeoitaisyouumu";
    public static final String HOUTEITYOTKSEIUMU        = "houteityotkseiumu";
    public static final String SEG1CD                   = "seg1cd";
    public static final String SEG2CD                   = "seg2cd";
    public static final String GWHKNSYURUI              = "gwhknsyurui";
    public static final String GWHOSYUCD                = "gwhosyucd";
    public static final String GWSYOUHNCD               = "gwsyouhncd";
    public static final String GWSYOUHNNM               = "gwsyouhnnm";
    public static final String HKNSYURUIKOUJYOSYOUMEI   = "hknsyuruikoujyosyoumei";
    public static final String SKNENKINSYU              = "sknenkinsyu";
    public static final String NKUKTUMU                 = "nkuktumu";
    public static final String TMTTKNHAIBUNWARISITEIUMU = "tmttknhaibunwarisiteiumu";
    public static final String TARGETTKHUKAKANOUKBN     = "targettkhukakanoukbn";
    public static final String MOUSIDEIKOUKBN           = "mousideikoukbn";
    public static final String YENDTHNKSYOUHNCD         = "yendthnksyouhncd";
    public static final String SISUUKBN                 = "sisuukbn";
    public static final String TYKSENHOKANHOUKBN        = "tyksenhokanhoukbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKBM_SyouhnZokusei primaryKey;

    public GenBM_SyouhnZokusei() {
        primaryKey = new PKBM_SyouhnZokusei();
    }

    public GenBM_SyouhnZokusei(String pSyouhncd, Integer pSyouhnsdno) {
        primaryKey = new PKBM_SyouhnZokusei(pSyouhncd, pSyouhnsdno);
    }

    @Transient
    @Override
    public PKBM_SyouhnZokusei getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_SyouhnZokusei> getMetaClass() {
        return QBM_SyouhnZokusei.class;
    }

    @Id
    @Column(name=GenBM_SyouhnZokusei.SYOUHNCD)
    @MaxLength(max=4)
    @SingleByteStrings
    public String getSyouhncd() {
        return getPrimaryKey().getSyouhncd();
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        getPrimaryKey().setSyouhncd(pSyouhncd);
    }

    @Id
    @Column(name=GenBM_SyouhnZokusei.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return getPrimaryKey().getSyouhnsdno();
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        getPrimaryKey().setSyouhnsdno(pSyouhnsdno);
    }

    private String ryouritusdno;

    @Column(name=GenBM_SyouhnZokusei.RYOURITUSDNO)
    public String getRyouritusdno() {
        return ryouritusdno;
    }

    public void setRyouritusdno(String pRyouritusdno) {
        ryouritusdno = pRyouritusdno;
    }

    private Integer syohnsortno;

    @Column(name=GenBM_SyouhnZokusei.SYOHNSORTNO)
    public Integer getSyohnsortno() {
        return syohnsortno;
    }

    public void setSyohnsortno(Integer pSyohnsortno) {
        syohnsortno = pSyohnsortno;
    }

    private Integer mossyohnsortno;

    @Column(name=GenBM_SyouhnZokusei.MOSSYOHNSORTNO)
    public Integer getMossyohnsortno() {
        return mossyohnsortno;
    }

    public void setMossyohnsortno(Integer pMossyohnsortno) {
        mossyohnsortno = pMossyohnsortno;
    }

    private String syouhnnm;

    @Column(name=GenBM_SyouhnZokusei.SYOUHNNM)
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

    private String syouhnnmryaku;

    @Column(name=GenBM_SyouhnZokusei.SYOUHNNMRYAKU)
    public String getSyouhnnmryaku() {
        return syouhnnmryaku;
    }

    public void setSyouhnnmryaku(String pSyouhnnmryaku) {
        syouhnnmryaku = pSyouhnnmryaku;
    }

    private String syouhnnmryaku5;

    @Column(name=GenBM_SyouhnZokusei.SYOUHNNMRYAKU5)
    public String getSyouhnnmryaku5() {
        return syouhnnmryaku5;
    }

    public void setSyouhnnmryaku5(String pSyouhnnmryaku5) {
        syouhnnmryaku5 = pSyouhnnmryaku5;
    }

    private String syouhnnmsyouken;

    @Column(name=GenBM_SyouhnZokusei.SYOUHNNMSYOUKEN)
    public String getSyouhnnmsyouken() {
        return syouhnnmsyouken;
    }

    public void setSyouhnnmsyouken(String pSyouhnnmsyouken) {
        syouhnnmsyouken = pSyouhnnmsyouken;
    }

    private String syouhnnmworklist;

    @Column(name=GenBM_SyouhnZokusei.SYOUHNNMWORKLIST)
    public String getSyouhnnmworklist() {
        return syouhnnmworklist;
    }

    public void setSyouhnnmworklist(String pSyouhnnmworklist) {
        syouhnnmworklist = pSyouhnnmworklist;
    }

    private BizDate kykfromymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_SyouhnZokusei.KYKFROMYMD)
    public BizDate getKykfromymd() {
        return kykfromymd;
    }

    public void setKykfromymd(BizDate pKykfromymd) {
        kykfromymd = pKykfromymd;
    }

    private BizDate kyktoymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_SyouhnZokusei.KYKTOYMD)
    public BizDate getKyktoymd() {
        return kyktoymd;
    }

    public void setKyktoymd(BizDate pKyktoymd) {
        kyktoymd = pKyktoymd;
    }

    private BizDate hyoujifromymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_SyouhnZokusei.HYOUJIFROMYMD)
    @ValidDate
    public BizDate getHyoujifromymd() {
        return hyoujifromymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHyoujifromymd(BizDate pHyoujifromymd) {
        hyoujifromymd = pHyoujifromymd;
    }

    private BizDate hyoujitoymd;

    @Type(type="BizDateType")
    @Column(name=GenBM_SyouhnZokusei.HYOUJITOYMD)
    @ValidDate
    public BizDate getHyoujitoymd() {
        return hyoujitoymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHyoujitoymd(BizDate pHyoujitoymd) {
        hyoujitoymd = pHyoujitoymd;
    }

    private C_SyutkKbn syutkkbn;

    @Type(type="UserType_C_SyutkKbn")
    @Column(name=GenBM_SyouhnZokusei.SYUTKKBN)
    public C_SyutkKbn getSyutkkbn() {
        return syutkkbn;
    }

    public void setSyutkkbn(C_SyutkKbn pSyutkkbn) {
        syutkkbn = pSyutkkbn;
    }

    private C_HknsyuruiNo hknsyuruino;

    @Type(type="UserType_C_HknsyuruiNo")
    @Column(name=GenBM_SyouhnZokusei.HKNSYURUINO)
    public C_HknsyuruiNo getHknsyuruino() {
        return hknsyuruino;
    }

    public void setHknsyuruino(C_HknsyuruiNo pHknsyuruino) {
        hknsyuruino = pHknsyuruino;
    }

    private String toukeiyouhokensyuruikbn;

    @Column(name=GenBM_SyouhnZokusei.TOUKEIYOUHOKENSYURUIKBN)
    public String getToukeiyouhokensyuruikbn() {
        return toukeiyouhokensyuruikbn;
    }

    public void setToukeiyouhokensyuruikbn(String pToukeiyouhokensyuruikbn) {
        toukeiyouhokensyuruikbn = pToukeiyouhokensyuruikbn;
    }

    private C_IjitoukeiHokensyuruiKbn ijitoukeihokensyuruikbn;

    @Type(type="UserType_C_IjitoukeiHokensyuruiKbn")
    @Column(name=GenBM_SyouhnZokusei.IJITOUKEIHOKENSYURUIKBN)
    public C_IjitoukeiHokensyuruiKbn getIjitoukeihokensyuruikbn() {
        return ijitoukeihokensyuruikbn;
    }

    public void setIjitoukeihokensyuruikbn(C_IjitoukeiHokensyuruiKbn pIjitoukeihokensyuruikbn) {
        ijitoukeihokensyuruikbn = pIjitoukeihokensyuruikbn;
    }

    private C_IsatoukeiHokensyuruicd isatoukeihokensyuruicd;

    @Type(type="UserType_C_IsatoukeiHokensyuruicd")
    @Column(name=GenBM_SyouhnZokusei.ISATOUKEIHOKENSYURUICD)
    public C_IsatoukeiHokensyuruicd getIsatoukeihokensyuruicd() {
        return isatoukeihokensyuruicd;
    }

    public void setIsatoukeihokensyuruicd(C_IsatoukeiHokensyuruicd pIsatoukeihokensyuruicd) {
        isatoukeihokensyuruicd = pIsatoukeihokensyuruicd;
    }

    private C_YoteirirituhendouKbn yoteirirituhendoukbn;

    @Type(type="UserType_C_YoteirirituhendouKbn")
    @Column(name=GenBM_SyouhnZokusei.YOTEIRIRITUHENDOUKBN)
    public C_YoteirirituhendouKbn getYoteirirituhendoukbn() {
        return yoteirirituhendoukbn;
    }

    public void setYoteirirituhendoukbn(C_YoteirirituhendouKbn pYoteirirituhendoukbn) {
        yoteirirituhendoukbn = pYoteirirituhendoukbn;
    }

    private Integer yoteirirituhosyoukkn;

    @Column(name=GenBM_SyouhnZokusei.YOTEIRIRITUHOSYOUKKN)
    public Integer getYoteirirituhosyoukkn() {
        return yoteirirituhosyoukkn;
    }

    public void setYoteirirituhosyoukkn(Integer pYoteirirituhosyoukkn) {
        yoteirirituhosyoukkn = pYoteirirituhosyoukkn;
    }

    private BizNumber yoteirirituminhosyouritu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_SyouhnZokusei.YOTEIRIRITUMINHOSYOURITU)
    public BizNumber getYoteirirituminhosyouritu() {
        return yoteirirituminhosyouritu;
    }

    public void setYoteirirituminhosyouritu(BizNumber pYoteirirituminhosyouritu) {
        yoteirirituminhosyouritu = pYoteirirituminhosyouritu;
    }

    private Integer nkgnshosyouritu;

    @Column(name=GenBM_SyouhnZokusei.NKGNSHOSYOURITU)
    public Integer getNkgnshosyouritu() {
        return nkgnshosyouritu;
    }

    public void setNkgnshosyouritu(Integer pNkgnshosyouritu) {
        nkgnshosyouritu = pNkgnshosyouritu;
    }

    private Integer dai1hknkkn;

    @Column(name=GenBM_SyouhnZokusei.DAI1HKNKKN)
    @Range(min="0", max="99")
    public Integer getDai1hknkkn() {
        return dai1hknkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDai1hknkkn(Integer pDai1hknkkn) {
        dai1hknkkn = pDai1hknkkn;
    }

    private C_DrtSyouhinSikibetuKbn drtsyouhinsikibetukbn;

    @Type(type="UserType_C_DrtSyouhinSikibetuKbn")
    @Column(name=GenBM_SyouhnZokusei.DRTSYOUHINSIKIBETUKBN)
    public C_DrtSyouhinSikibetuKbn getDrtsyouhinsikibetukbn() {
        return drtsyouhinsikibetukbn;
    }

    public void setDrtsyouhinsikibetukbn(C_DrtSyouhinSikibetuKbn pDrtsyouhinsikibetukbn) {
        drtsyouhinsikibetukbn = pDrtsyouhinsikibetukbn;
    }

    private String drthrkhouhoukbn;

    @Column(name=GenBM_SyouhnZokusei.DRTHRKHOUHOUKBN)
    public String getDrthrkhouhoukbn() {
        return drthrkhouhoukbn;
    }

    public void setDrthrkhouhoukbn(String pDrthrkhouhoukbn) {
        drthrkhouhoukbn = pDrthrkhouhoukbn;
    }

    private String drtplannmkbn;

    @Column(name=GenBM_SyouhnZokusei.DRTPLANNMKBN)
    public String getDrtplannmkbn() {
        return drtplannmkbn;
    }

    public void setDrtplannmkbn(String pDrtplannmkbn) {
        drtplannmkbn = pDrtplannmkbn;
    }

    private C_Tuukasyu tuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenBM_SyouhnZokusei.TUUKASYU)
    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }

    private C_PtratkituukasiteiKbn ptratkituukasiteikbn;

    @Type(type="UserType_C_PtratkituukasiteiKbn")
    @Column(name=GenBM_SyouhnZokusei.PTRATKITUUKASITEIKBN)
    public C_PtratkituukasiteiKbn getPtratkituukasiteikbn() {
        return ptratkituukasiteikbn;
    }

    public void setPtratkituukasiteikbn(C_PtratkituukasiteiKbn pPtratkituukasiteikbn) {
        ptratkituukasiteikbn = pPtratkituukasiteikbn;
    }

    private Integer jikounensuu;

    @Column(name=GenBM_SyouhnZokusei.JIKOUNENSUU)
    public Integer getJikounensuu() {
        return jikounensuu;
    }

    public void setJikounensuu(Integer pJikounensuu) {
        jikounensuu = pJikounensuu;
    }

    private BizNumber ntgksbairitu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_SyouhnZokusei.NTGKSBAIRITU)
    public BizNumber getNtgksbairitu() {
        return ntgksbairitu;
    }

    public void setNtgksbairitu(BizNumber pNtgksbairitu) {
        ntgksbairitu = pNtgksbairitu;
    }

    private C_UmuKbn sbhkuktumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.SBHKUKTUMU)
    public C_UmuKbn getSbhkuktumu() {
        return sbhkuktumu;
    }

    public void setSbhkuktumu(C_UmuKbn pSbhkuktumu) {
        sbhkuktumu = pSbhkuktumu;
    }

    private C_UmuKbn sbkyuuhukinuktumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.SBKYUUHUKINUKTUMU)
    public C_UmuKbn getSbkyuuhukinuktumu() {
        return sbkyuuhukinuktumu;
    }

    public void setSbkyuuhukinuktumu(C_UmuKbn pSbkyuuhukinuktumu) {
        sbkyuuhukinuktumu = pSbkyuuhukinuktumu;
    }

    private C_UmuKbn sbhnknuktumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.SBHNKNUKTUMU)
    public C_UmuKbn getSbhnknuktumu() {
        return sbhnknuktumu;
    }

    public void setSbhnknuktumu(C_UmuKbn pSbhnknuktumu) {
        sbhnknuktumu = pSbhnknuktumu;
    }

    private C_UmuKbn sbuktumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.SBUKTUMU)
    public C_UmuKbn getSbuktumu() {
        return sbuktumu;
    }

    public void setSbuktumu(C_UmuKbn pSbuktumu) {
        sbuktumu = pSbuktumu;
    }

    private C_UmuKbn mnkuktumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.MNKUKTUMU)
    public C_UmuKbn getMnkuktumu() {
        return mnkuktumu;
    }

    public void setMnkuktumu(C_UmuKbn pMnkuktumu) {
        mnkuktumu = pMnkuktumu;
    }

    private C_UmuKbn siteidairiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.SITEIDAIRIUMU)
    public C_UmuKbn getSiteidairiumu() {
        return siteidairiumu;
    }

    public void setSiteidairiumu(C_UmuKbn pSiteidairiumu) {
        siteidairiumu = pSiteidairiumu;
    }

    private C_UmuKbn kktumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.KKTUMU)
    public C_UmuKbn getKktumu() {
        return kktumu;
    }

    public void setKktumu(C_UmuKbn pKktumu) {
        kktumu = pKktumu;
    }

    private C_UmuKbn hjyumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.HJYUMU)
    public C_UmuKbn getHjyumu() {
        return hjyumu;
    }

    public void setHjyumu(C_UmuKbn pHjyumu) {
        hjyumu = pHjyumu;
    }

    private C_UmuKbn musenumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.MUSENUMU)
    public C_UmuKbn getMusenumu() {
        return musenumu;
    }

    public void setMusenumu(C_UmuKbn pMusenumu) {
        musenumu = pMusenumu;
    }

    private C_UmuKbn syokugyoukktumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.SYOKUGYOUKKTUMU)
    public C_UmuKbn getSyokugyoukktumu() {
        return syokugyoukktumu;
    }

    public void setSyokugyoukktumu(C_UmuKbn pSyokugyoukktumu) {
        syokugyoukktumu = pSyokugyoukktumu;
    }

    private C_KokutiKbn kokutikbn;

    @Type(type="UserType_C_KokutiKbn")
    @Column(name=GenBM_SyouhnZokusei.KOKUTIKBN)
    public C_KokutiKbn getKokutikbn() {
        return kokutikbn;
    }

    public void setKokutikbn(C_KokutiKbn pKokutikbn) {
        kokutikbn = pKokutikbn;
    }

    private C_UmuKbn sdumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.SDUMU)
    public C_UmuKbn getSdumu() {
        return sdumu;
    }

    public void setSdumu(C_UmuKbn pSdumu) {
        sdumu = pSdumu;
    }

    private C_UmuKbn pdumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.PDUMU)
    public C_UmuKbn getPdumu() {
        return pdumu;
    }

    public void setPdumu(C_UmuKbn pPdumu) {
        pdumu = pPdumu;
    }

    private C_UmuKbn gijipdumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.GIJIPDUMU)
    public C_UmuKbn getGijipdumu() {
        return gijipdumu;
    }

    public void setGijipdumu(C_UmuKbn pGijipdumu) {
        gijipdumu = pGijipdumu;
    }

    private C_UmuKbn hokenkngkyakujyouumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.HOKENKNGKYAKUJYOUUMU)
    public C_UmuKbn getHokenkngkyakujyouumu() {
        return hokenkngkyakujyouumu;
    }

    public void setHokenkngkyakujyouumu(C_UmuKbn pHokenkngkyakujyouumu) {
        hokenkngkyakujyouumu = pHokenkngkyakujyouumu;
    }

    private C_HaitouKbn haitoukbn;

    @Type(type="UserType_C_HaitouKbn")
    @Column(name=GenBM_SyouhnZokusei.HAITOUKBN)
    public C_HaitouKbn getHaitoukbn() {
        return haitoukbn;
    }

    public void setHaitoukbn(C_HaitouKbn pHaitoukbn) {
        haitoukbn = pHaitoukbn;
    }

    private C_UmuKbn teikisiharaikinumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.TEIKISIHARAIKINUMU)
    public C_UmuKbn getTeikisiharaikinumu() {
        return teikisiharaikinumu;
    }

    public void setTeikisiharaikinumu(C_UmuKbn pTeikisiharaikinumu) {
        teikisiharaikinumu = pTeikisiharaikinumu;
    }

    private C_UmuKbn kyhkataumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.KYHKATAUMU)
    public C_UmuKbn getKyhkataumu() {
        return kyhkataumu;
    }

    public void setKyhkataumu(C_UmuKbn pKyhkataumu) {
        kyhkataumu = pKyhkataumu;
    }

    private C_UmuKbn syukyhkinkataumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.SYUKYHKINKATAUMU)
    public C_UmuKbn getSyukyhkinkataumu() {
        return syukyhkinkataumu;
    }

    public void setSyukyhkinkataumu(C_UmuKbn pSyukyhkinkataumu) {
        syukyhkinkataumu = pSyukyhkinkataumu;
    }

    private C_UmuKbn rokudaildumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.ROKUDAILDUMU)
    public C_UmuKbn getRokudaildumu() {
        return rokudaildumu;
    }

    public void setRokudaildumu(C_UmuKbn pRokudaildumu) {
        rokudaildumu = pRokudaildumu;
    }

    private C_UmuKbn khnkyhkgbairituumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.KHNKYHKGBAIRITUUMU)
    public C_UmuKbn getKhnkyhkgbairituumu() {
        return khnkyhkgbairituumu;
    }

    public void setKhnkyhkgbairituumu(C_UmuKbn pKhnkyhkgbairituumu) {
        khnkyhkgbairituumu = pKhnkyhkgbairituumu;
    }

    private C_UmuKbn itijibrumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.ITIJIBRUMU)
    public C_UmuKbn getItijibrumu() {
        return itijibrumu;
    }

    public void setItijibrumu(C_UmuKbn pItijibrumu) {
        itijibrumu = pItijibrumu;
    }

    private C_UmuKbn heijyunbaraiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.HEIJYUNBARAIUMU)
    public C_UmuKbn getHeijyunbaraiumu() {
        return heijyunbaraiumu;
    }

    public void setHeijyunbaraiumu(C_UmuKbn pHeijyunbaraiumu) {
        heijyunbaraiumu = pHeijyunbaraiumu;
    }

    private C_UmuKbn zennouumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.ZENNOUUMU)
    public C_UmuKbn getZennouumu() {
        return zennouumu;
    }

    public void setZennouumu(C_UmuKbn pZennouumu) {
        zennouumu = pZennouumu;
    }

    private C_UmuKbn itibuzennoutekiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.ITIBUZENNOUTEKIUMU)
    public C_UmuKbn getItibuzennoutekiumu() {
        return itibuzennoutekiumu;
    }

    public void setItibuzennoutekiumu(C_UmuKbn pItibuzennoutekiumu) {
        itibuzennoutekiumu = pItibuzennoutekiumu;
    }

    private C_UmuKbn zenkizennoutekiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.ZENKIZENNOUTEKIUMU)
    public C_UmuKbn getZenkizennoutekiumu() {
        return zenkizennoutekiumu;
    }

    public void setZenkizennoutekiumu(C_UmuKbn pZenkizennoutekiumu) {
        zenkizennoutekiumu = pZenkizennoutekiumu;
    }

    private C_UmuKbn ikkatubaraiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.IKKATUBARAIUMU)
    public C_UmuKbn getIkkatubaraiumu() {
        return ikkatubaraiumu;
    }

    public void setIkkatubaraiumu(C_UmuKbn pIkkatubaraiumu) {
        ikkatubaraiumu = pIkkatubaraiumu;
    }

    private C_UmuKbn teikiikkatubaraiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.TEIKIIKKATUBARAIUMU)
    public C_UmuKbn getTeikiikkatubaraiumu() {
        return teikiikkatubaraiumu;
    }

    public void setTeikiikkatubaraiumu(C_UmuKbn pTeikiikkatubaraiumu) {
        teikiikkatubaraiumu = pTeikiikkatubaraiumu;
    }

    private C_PWaribikiKbn pwaribikikbn;

    @Type(type="UserType_C_PWaribikiKbn")
    @Column(name=GenBM_SyouhnZokusei.PWARIBIKIKBN)
    public C_PWaribikiKbn getPwaribikikbn() {
        return pwaribikikbn;
    }

    public void setPwaribikikbn(C_PWaribikiKbn pPwaribikikbn) {
        pwaribikikbn = pPwaribikikbn;
    }

    private C_UmuKbn tkjyrmtekiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.TKJYRMTEKIUMU)
    public C_UmuKbn getTkjyrmtekiumu() {
        return tkjyrmtekiumu;
    }

    public void setTkjyrmtekiumu(C_UmuKbn pTkjyrmtekiumu) {
        tkjyrmtekiumu = pTkjyrmtekiumu;
    }

    private C_UmuKbn tkjyskgntekiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.TKJYSKGNTEKIUMU)
    public C_UmuKbn getTkjyskgntekiumu() {
        return tkjyskgntekiumu;
    }

    public void setTkjyskgntekiumu(C_UmuKbn pTkjyskgntekiumu) {
        tkjyskgntekiumu = pTkjyskgntekiumu;
    }

    private C_UmuKbn htnpbuitekiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.HTNPBUITEKIUMU)
    public C_UmuKbn getHtnpbuitekiumu() {
        return htnpbuitekiumu;
    }

    public void setHtnpbuitekiumu(C_UmuKbn pHtnpbuitekiumu) {
        htnpbuitekiumu = pHtnpbuitekiumu;
    }

    private C_UmuKbn tokkoudosghtnptekiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.TOKKOUDOSGHTNPTEKIUMU)
    public C_UmuKbn getTokkoudosghtnptekiumu() {
        return tokkoudosghtnptekiumu;
    }

    public void setTokkoudosghtnptekiumu(C_UmuKbn pTokkoudosghtnptekiumu) {
        tokkoudosghtnptekiumu = pTokkoudosghtnptekiumu;
    }

    private C_UmuKbn jkntekiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.JKNTEKIUMU)
    public C_UmuKbn getJkntekiumu() {
        return jkntekiumu;
    }

    public void setJkntekiumu(C_UmuKbn pJkntekiumu) {
        jkntekiumu = pJkntekiumu;
    }

    private C_UmuKbn livtkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.LIVTKUMU)
    public C_UmuKbn getLivtkumu() {
        return livtkumu;
    }

    public void setLivtkumu(C_UmuKbn pLivtkumu) {
        livtkumu = pLivtkumu;
    }

    private C_UmuKbn kzktourokuserviceumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.KZKTOUROKUSERVICEUMU)
    public C_UmuKbn getKzktourokuserviceumu() {
        return kzktourokuserviceumu;
    }

    public void setKzktourokuserviceumu(C_UmuKbn pKzktourokuserviceumu) {
        kzktourokuserviceumu = pKzktourokuserviceumu;
    }

    private C_UmuKbn stdrsktkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.STDRSKTKUMU)
    public C_UmuKbn getStdrsktkumu() {
        return stdrsktkumu;
    }

    public void setStdrsktkumu(C_UmuKbn pStdrsktkumu) {
        stdrsktkumu = pStdrsktkumu;
    }

    private C_UmuKbn kykdrtkykumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.KYKDRTKYKUMU)
    public C_UmuKbn getKykdrtkykumu() {
        return kykdrtkykumu;
    }

    public void setKykdrtkykumu(C_UmuKbn pKykdrtkykumu) {
        kykdrtkykumu = pKykdrtkykumu;
    }

    private C_UmuKbn pmnjtkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.PMNJTKUMU)
    public C_UmuKbn getPmnjtkumu() {
        return pmnjtkumu;
    }

    public void setPmnjtkumu(C_UmuKbn pPmnjtkumu) {
        pmnjtkumu = pPmnjtkumu;
    }

    private C_UmuKbn sknnkaisikitkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.SKNNKAISIKITKUMU)
    public C_UmuKbn getSknnkaisikitkumu() {
        return sknnkaisikitkumu;
    }

    public void setSknnkaisikitkumu(C_UmuKbn pSknnkaisikitkumu) {
        sknnkaisikitkumu = pSknnkaisikitkumu;
    }

    private C_UmuKbn gaikatatkiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.GAIKATATKIUMU)
    public C_UmuKbn getGaikatatkiumu() {
        return gaikatatkiumu;
    }

    public void setGaikatatkiumu(C_UmuKbn pGaikatatkiumu) {
        gaikatatkiumu = pGaikatatkiumu;
    }

    private C_UmuKbn hengakuumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.HENGAKUUMU)
    public C_UmuKbn getHengakuumu() {
        return hengakuumu;
    }

    public void setHengakuumu(C_UmuKbn pHengakuumu) {
        hengakuumu = pHengakuumu;
    }

    private C_UmuKbn nsikoutkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.NSIKOUTKUMU)
    public C_UmuKbn getNsikoutkumu() {
        return nsikoutkumu;
    }

    public void setNsikoutkumu(C_UmuKbn pNsikoutkumu) {
        nsikoutkumu = pNsikoutkumu;
    }

    private C_Nstkumu nstkumu;

    @Type(type="UserType_C_Nstkumu")
    @Column(name=GenBM_SyouhnZokusei.NSTKUMU)
    public C_Nstkumu getNstkumu() {
        return nstkumu;
    }

    public void setNstkumu(C_Nstkumu pNstkumu) {
        nstkumu = pNstkumu;
    }

    private C_UmuKbn syksbyensitihsyutktekiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.SYKSBYENSITIHSYUTKTEKIUMU)
    public C_UmuKbn getSyksbyensitihsyutktekiumu() {
        return syksbyensitihsyutktekiumu;
    }

    public void setSyksbyensitihsyutktekiumu(C_UmuKbn pSyksbyensitihsyutktekiumu) {
        syksbyensitihsyutktekiumu = pSyksbyensitihsyutktekiumu;
    }

    private C_UmuKbn jyudkaigomehrtktekiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.JYUDKAIGOMEHRTKTEKIUMU)
    public C_UmuKbn getJyudkaigomehrtktekiumu() {
        return jyudkaigomehrtktekiumu;
    }

    public void setJyudkaigomehrtktekiumu(C_UmuKbn pJyudkaigomehrtktekiumu) {
        jyudkaigomehrtktekiumu = pJyudkaigomehrtktekiumu;
    }

    private C_UmuKbn stknumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.STKNUMU)
    public C_UmuKbn getStknumu() {
        return stknumu;
    }

    public void setStknumu(C_UmuKbn pStknumu) {
        stknumu = pStknumu;
    }

    private C_UmuKbn apltekiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.APLTEKIUMU)
    public C_UmuKbn getApltekiumu() {
        return apltekiumu;
    }

    public void setApltekiumu(C_UmuKbn pApltekiumu) {
        apltekiumu = pApltekiumu;
    }

    private C_UmuKbn jgyiktumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.JGYIKTUMU)
    public C_UmuKbn getJgyiktumu() {
        return jgyiktumu;
    }

    public void setJgyiktumu(C_UmuKbn pJgyiktumu) {
        jgyiktumu = pJgyiktumu;
    }

    private C_UmuKbn hutuusbhsyumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.HUTUUSBHSYUMU)
    public C_UmuKbn getHutuusbhsyumu() {
        return hutuusbhsyumu;
    }

    public void setHutuusbhsyumu(C_UmuKbn pHutuusbhsyumu) {
        hutuusbhsyumu = pHutuusbhsyumu;
    }

    private C_UmuKbn sgsbhsyumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.SGSBHSYUMU)
    public C_UmuKbn getSgsbhsyumu() {
        return sgsbhsyumu;
    }

    public void setSgsbhsyumu(C_UmuKbn pSgsbhsyumu) {
        sgsbhsyumu = pSgsbhsyumu;
    }

    private C_UmuKbn sougouiryhsyumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.SOUGOUIRYHSYUMU)
    public C_UmuKbn getSougouiryhsyumu() {
        return sougouiryhsyumu;
    }

    public void setSougouiryhsyumu(C_UmuKbn pSougouiryhsyumu) {
        sougouiryhsyumu = pSougouiryhsyumu;
    }

    private C_UmuKbn syuusinhknumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.SYUUSINHKNUMU)
    public C_UmuKbn getSyuusinhknumu() {
        return syuusinhknumu;
    }

    public void setSyuusinhknumu(C_UmuKbn pSyuusinhknumu) {
        syuusinhknumu = pSyuusinhknumu;
    }

    private C_UmuKbn yrhknumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.YRHKNUMU)
    public C_UmuKbn getYrhknumu() {
        return yrhknumu;
    }

    public void setYrhknumu(C_UmuKbn pYrhknumu) {
        yrhknumu = pYrhknumu;
    }

    private C_UmuKbn nkhknumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.NKHKNUMU)
    public C_UmuKbn getNkhknumu() {
        return nkhknumu;
    }

    public void setNkhknumu(C_UmuKbn pNkhknumu) {
        nkhknumu = pNkhknumu;
    }

    private C_UmuKbn sipnyukyhumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.SIPNYUKYHUMU)
    public C_UmuKbn getSipnyukyhumu() {
        return sipnyukyhumu;
    }

    public void setSipnyukyhumu(C_UmuKbn pSipnyukyhumu) {
        sipnyukyhumu = pSipnyukyhumu;
    }

    private C_UmuKbn sgnyukyhumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.SGNYUKYHUMU)
    public C_UmuKbn getSgnyukyhumu() {
        return sgnyukyhumu;
    }

    public void setSgnyukyhumu(C_UmuKbn pSgnyukyhumu) {
        sgnyukyhumu = pSgnyukyhumu;
    }

    private C_UmuKbn sjnyukyhumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.SJNYUKYHUMU)
    public C_UmuKbn getSjnyukyhumu() {
        return sjnyukyhumu;
    }

    public void setSjnyukyhumu(C_UmuKbn pSjnyukyhumu) {
        sjnyukyhumu = pSjnyukyhumu;
    }

    private C_UmuKbn gannyukyhumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.GANNYUKYHUMU)
    public C_UmuKbn getGannyukyhumu() {
        return gannyukyhumu;
    }

    public void setGannyukyhumu(C_UmuKbn pGannyukyhumu) {
        gannyukyhumu = pGannyukyhumu;
    }

    private C_UmuKbn kihonsntgkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.KIHONSNTGKUMU)
    public C_UmuKbn getKihonsntgkumu() {
        return kihonsntgkumu;
    }

    public void setKihonsntgkumu(C_UmuKbn pKihonsntgkumu) {
        kihonsntgkumu = pKihonsntgkumu;
    }

    private C_UmuKbn gansdkyhumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.GANSDKYHUMU)
    public C_UmuKbn getGansdkyhumu() {
        return gansdkyhumu;
    }

    public void setGansdkyhumu(C_UmuKbn pGansdkyhumu) {
        gansdkyhumu = pGansdkyhumu;
    }

    private C_UmuKbn ganhsyngumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.GANHSYNGUMU)
    public C_UmuKbn getGanhsyngumu() {
        return ganhsyngumu;
    }

    public void setGanhsyngumu(C_UmuKbn pGanhsyngumu) {
        ganhsyngumu = pGanhsyngumu;
    }

    private C_UmuKbn eightysaimnrytkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.EIGHTYSAIMNRYTKUMU)
    public C_UmuKbn getEightysaimnrytkumu() {
        return eightysaimnrytkumu;
    }

    public void setEightysaimnrytkumu(C_UmuKbn pEightysaimnrytkumu) {
        eightysaimnrytkumu = pEightysaimnrytkumu;
    }

    private C_UmuKbn saiteisknwtkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.SAITEISKNWTKUMU)
    public C_UmuKbn getSaiteisknwtkumu() {
        return saiteisknwtkumu;
    }

    public void setSaiteisknwtkumu(C_UmuKbn pSaiteisknwtkumu) {
        saiteisknwtkumu = pSaiteisknwtkumu;
    }

    private C_UmuKbn dountgkchkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.DOUNTGKCHKUMU)
    public C_UmuKbn getDountgkchkumu() {
        return dountgkchkumu;
    }

    public void setDountgkchkumu(C_UmuKbn pDountgkchkumu) {
        dountgkchkumu = pDountgkchkumu;
    }

    private C_UmuKbn doukknchkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.DOUKKNCHKUMU)
    public C_UmuKbn getDoukknchkumu() {
        return doukknchkumu;
    }

    public void setDoukknchkumu(C_UmuKbn pDoukknchkumu) {
        doukknchkumu = pDoukknchkumu;
    }

    private C_UmuKbn doukatachkumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.DOUKATACHKUMU)
    public C_UmuKbn getDoukatachkumu() {
        return doukatachkumu;
    }

    public void setDoukatachkumu(C_UmuKbn pDoukatachkumu) {
        doukatachkumu = pDoukatachkumu;
    }

    private C_UmuKbn tyouhukuknyumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.TYOUHUKUKNYUMU)
    public C_UmuKbn getTyouhukuknyumu() {
        return tyouhukuknyumu;
    }

    public void setTyouhukuknyumu(C_UmuKbn pTyouhukuknyumu) {
        tyouhukuknyumu = pTyouhukuknyumu;
    }

    private C_UmuKbn stsnumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.STSNUMU)
    public C_UmuKbn getStsnumu() {
        return stsnumu;
    }

    public void setStsnumu(C_UmuKbn pStsnumu) {
        stsnumu = pStsnumu;
    }

    private C_UmuKbn nkgnstuusanumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.NKGNSTUUSANUMU)
    public C_UmuKbn getNkgnstuusanumu() {
        return nkgnstuusanumu;
    }

    public void setNkgnstuusanumu(C_UmuKbn pNkgnstuusanumu) {
        nkgnstuusanumu = pNkgnstuusanumu;
    }

    private C_UmuKbn nenbtsousbustuusanumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.NENBTSOUSBUSTUUSANUMU)
    public C_UmuKbn getNenbtsousbustuusanumu() {
        return nenbtsousbustuusanumu;
    }

    public void setNenbtsousbustuusanumu(C_UmuKbn pNenbtsousbustuusanumu) {
        nenbtsousbustuusanumu = pNenbtsousbustuusanumu;
    }

    private C_UmuKbn soukktjituhsgktuusanumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.SOUKKTJITUHSGKTUUSANUMU)
    public C_UmuKbn getSoukktjituhsgktuusanumu() {
        return soukktjituhsgktuusanumu;
    }

    public void setSoukktjituhsgktuusanumu(C_UmuKbn pSoukktjituhsgktuusanumu) {
        soukktjituhsgktuusanumu = pSoukktjituhsgktuusanumu;
    }

    private C_UmuKbn msnynenbtsbustuusanumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.MSNYNENBTSBUSTUUSANUMU)
    public C_UmuKbn getMsnynenbtsbustuusanumu() {
        return msnynenbtsbustuusanumu;
    }

    public void setMsnynenbtsbustuusanumu(C_UmuKbn pMsnynenbtsbustuusanumu) {
        msnynenbtsbustuusanumu = pMsnynenbtsbustuusanumu;
    }

    private C_UmuKbn kktjituhsgk1tuusanumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.KKTJITUHSGK1TUUSANUMU)
    public C_UmuKbn getKktjituhsgk1tuusanumu() {
        return kktjituhsgk1tuusanumu;
    }

    public void setKktjituhsgk1tuusanumu(C_UmuKbn pKktjituhsgk1tuusanumu) {
        kktjituhsgk1tuusanumu = pKktjituhsgk1tuusanumu;
    }

    private C_UmuKbn kktjituhsgk2tuusanumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.KKTJITUHSGK2TUUSANUMU)
    public C_UmuKbn getKktjituhsgk2tuusanumu() {
        return kktjituhsgk2tuusanumu;
    }

    public void setKktjituhsgk2tuusanumu(C_UmuKbn pKktjituhsgk2tuusanumu) {
        kktjituhsgk2tuusanumu = pKktjituhsgk2tuusanumu;
    }

    private C_UmuKbn itijibrptsnumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.ITIJIBRPTSNUMU)
    public C_UmuKbn getItijibrptsnumu() {
        return itijibrptsnumu;
    }

    public void setItijibrptsnumu(C_UmuKbn pItijibrptsnumu) {
        itijibrptsnumu = pItijibrptsnumu;
    }

    private C_TkthknsyruitsnKbn tkthknsyruitsnkbn;

    @Type(type="UserType_C_TkthknsyruitsnKbn")
    @Column(name=GenBM_SyouhnZokusei.TKTHKNSYRUITSNKBN)
    public C_TkthknsyruitsnKbn getTkthknsyruitsnkbn() {
        return tkthknsyruitsnkbn;
    }

    public void setTkthknsyruitsnkbn(C_TkthknsyruitsnKbn pTkthknsyruitsnkbn) {
        tkthknsyruitsnkbn = pTkthknsyruitsnkbn;
    }

    private C_UmuKbn yenhrkgktuusansiyouumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.YENHRKGKTUUSANSIYOUUMU)
    public C_UmuKbn getYenhrkgktuusansiyouumu() {
        return yenhrkgktuusansiyouumu;
    }

    public void setYenhrkgktuusansiyouumu(C_UmuKbn pYenhrkgktuusansiyouumu) {
        yenhrkgktuusansiyouumu = pYenhrkgktuusansiyouumu;
    }

    private C_UmuKbn kykdrtentuusanumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.KYKDRTENTUUSANUMU)
    public C_UmuKbn getKykdrtentuusanumu() {
        return kykdrtentuusanumu;
    }

    public void setKykdrtentuusanumu(C_UmuKbn pKykdrtentuusanumu) {
        kykdrtentuusanumu = pKykdrtentuusanumu;
    }

    private C_UmuKbn pyennykntktekiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.PYENNYKNTKTEKIUMU)
    public C_UmuKbn getPyennykntktekiumu() {
        return pyennykntktekiumu;
    }

    public void setPyennykntktekiumu(C_UmuKbn pPyennykntktekiumu) {
        pyennykntktekiumu = pPyennykntktekiumu;
    }

    private C_UmuKbn yenshrtktekiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.YENSHRTKTEKIUMU)
    public C_UmuKbn getYenshrtktekiumu() {
        return yenshrtktekiumu;
    }

    public void setYenshrtktekiumu(C_UmuKbn pYenshrtktekiumu) {
        yenshrtktekiumu = pYenshrtktekiumu;
    }

    private C_UmuKbn gaikanyuukintktekiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.GAIKANYUUKINTKTEKIUMU)
    public C_UmuKbn getGaikanyuukintktekiumu() {
        return gaikanyuukintktekiumu;
    }

    public void setGaikanyuukintktekiumu(C_UmuKbn pGaikanyuukintktekiumu) {
        gaikanyuukintktekiumu = pGaikanyuukintktekiumu;
    }

    private C_UmuKbn knrrenkatasyouhnumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.KNRRENKATASYOUHNUMU)
    public C_UmuKbn getKnrrenkatasyouhnumu() {
        return knrrenkatasyouhnumu;
    }

    public void setKnrrenkatasyouhnumu(C_UmuKbn pKnrrenkatasyouhnumu) {
        knrrenkatasyouhnumu = pKnrrenkatasyouhnumu;
    }

    private C_UmuKbn gstsumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.GSTSUMU)
    public C_UmuKbn getGstsumu() {
        return gstsumu;
    }

    public void setGstsumu(C_UmuKbn pGstsumu) {
        gstsumu = pGstsumu;
    }

    private C_UmuKbn nenmnryumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.NENMNRYUMU)
    public C_UmuKbn getNenmnryumu() {
        return nenmnryumu;
    }

    public void setNenmnryumu(C_UmuKbn pNenmnryumu) {
        nenmnryumu = pNenmnryumu;
    }

    private C_Kaiyakuhrtype kaiyakuhrtype;

    @Type(type="UserType_C_Kaiyakuhrtype")
    @Column(name=GenBM_SyouhnZokusei.KAIYAKUHRTYPE)
    public C_Kaiyakuhrtype getKaiyakuhrtype() {
        return kaiyakuhrtype;
    }

    public void setKaiyakuhrtype(C_Kaiyakuhrtype pKaiyakuhrtype) {
        kaiyakuhrtype = pKaiyakuhrtype;
    }

    private BizNumber kaiyakuhrbairitu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_SyouhnZokusei.KAIYAKUHRBAIRITU)
    public BizNumber getKaiyakuhrbairitu() {
        return kaiyakuhrbairitu;
    }

    public void setKaiyakuhrbairitu(BizNumber pKaiyakuhrbairitu) {
        kaiyakuhrbairitu = pKaiyakuhrbairitu;
    }

    private Integer hukkatukanouy;

    @Column(name=GenBM_SyouhnZokusei.HUKKATUKANOUY)
    public Integer getHukkatukanouy() {
        return hukkatukanouy;
    }

    public void setHukkatukanouy(Integer pHukkatukanouy) {
        hukkatukanouy = pHukkatukanouy;
    }

    private Integer hukkatukanoum;

    @Column(name=GenBM_SyouhnZokusei.HUKKATUKANOUM)
    public Integer getHukkatukanoum() {
        return hukkatukanoum;
    }

    public void setHukkatukanoum(Integer pHukkatukanoum) {
        hukkatukanoum = pHukkatukanoum;
    }

    private BizNumber pratetani;

    @Type(type="BizNumberType")
    @Column(name=GenBM_SyouhnZokusei.PRATETANI)
    public BizNumber getPratetani() {
        return pratetani;
    }

    public void setPratetani(BizNumber pPratetani) {
        pratetani = pPratetani;
    }

    private BizNumber vratetani;

    @Type(type="BizNumberType")
    @Column(name=GenBM_SyouhnZokusei.VRATETANI)
    public BizNumber getVratetani() {
        return vratetani;
    }

    public void setVratetani(BizNumber pVratetani) {
        vratetani = pVratetani;
    }

    private BizNumber wratetani;

    @Type(type="BizNumberType")
    @Column(name=GenBM_SyouhnZokusei.WRATETANI)
    public BizNumber getWratetani() {
        return wratetani;
    }

    public void setWratetani(BizNumber pWratetani) {
        wratetani = pWratetani;
    }

    private C_KihonssyuruiKbn kihonssyuruikbn;

    @Type(type="UserType_C_KihonssyuruiKbn")
    @Column(name=GenBM_SyouhnZokusei.KIHONSSYURUIKBN)
    public C_KihonssyuruiKbn getKihonssyuruikbn() {
        return kihonssyuruikbn;
    }

    public void setKihonssyuruikbn(C_KihonssyuruiKbn pKihonssyuruikbn) {
        kihonssyuruikbn = pKihonssyuruikbn;
    }

    private Integer gengakukahikbn;

    @Column(name=GenBM_SyouhnZokusei.GENGAKUKAHIKBN)
    public Integer getGengakukahikbn() {
        return gengakukahikbn;
    }

    public void setGengakukahikbn(Integer pGengakukahikbn) {
        gengakukahikbn = pGengakukahikbn;
    }

    private C_KahiKbn pgengakukahikbn;

    @Type(type="UserType_C_KahiKbn")
    @Column(name=GenBM_SyouhnZokusei.PGENGAKUKAHIKBN)
    public C_KahiKbn getPgengakukahikbn() {
        return pgengakukahikbn;
    }

    public void setPgengakukahikbn(C_KahiKbn pPgengakukahikbn) {
        pgengakukahikbn = pPgengakukahikbn;
    }

    private C_UmuKbn hjnkykumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.HJNKYKUMUKBN)
    public C_UmuKbn getHjnkykumukbn() {
        return hjnkykumukbn;
    }

    public void setHjnkykumukbn(C_UmuKbn pHjnkykumukbn) {
        hjnkykumukbn = pHjnkykumukbn;
    }

    private C_UmuKbn creditcardhrtekiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.CREDITCARDHRTEKIUMU)
    public C_UmuKbn getCreditcardhrtekiumu() {
        return creditcardhrtekiumu;
    }

    public void setCreditcardhrtekiumu(C_UmuKbn pCreditcardhrtekiumu) {
        creditcardhrtekiumu = pCreditcardhrtekiumu;
    }

    private C_UmuKbn kouzahurikaebaraitekiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.KOUZAHURIKAEBARAITEKIUMU)
    public C_UmuKbn getKouzahurikaebaraitekiumu() {
        return kouzahurikaebaraitekiumu;
    }

    public void setKouzahurikaebaraitekiumu(C_UmuKbn pKouzahurikaebaraitekiumu) {
        kouzahurikaebaraitekiumu = pKouzahurikaebaraitekiumu;
    }

    private C_UmuKbn tsnshrgndgkhyoujiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.TSNSHRGNDGKHYOUJIUMU)
    public C_UmuKbn getTsnshrgndgkhyoujiumu() {
        return tsnshrgndgkhyoujiumu;
    }

    public void setTsnshrgndgkhyoujiumu(C_UmuKbn pTsnshrgndgkhyoujiumu) {
        tsnshrgndgkhyoujiumu = pTsnshrgndgkhyoujiumu;
    }

    private BizCurrency tsnshrgndgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTsnshrgndgk() {
        return tsnshrgndgk;
    }

    public void setTsnshrgndgk(BizCurrency pTsnshrgndgk) {
        tsnshrgndgk = pTsnshrgndgk;
        tsnshrgndgkValue = null;
        tsnshrgndgkType  = null;
    }

    transient private BigDecimal tsnshrgndgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TSNSHRGNDGK, nullable=true)
    protected BigDecimal getTsnshrgndgkValue() {
        if (tsnshrgndgkValue == null && tsnshrgndgk != null) {
            if (tsnshrgndgk.isOptional()) return null;
            return tsnshrgndgk.absolute();
        }
        return tsnshrgndgkValue;
    }

    protected void setTsnshrgndgkValue(BigDecimal value) {
        tsnshrgndgkValue = value;
        tsnshrgndgk = Optional.fromNullable(toCurrencyType(tsnshrgndgkType))
            .transform(bizCurrencyTransformer(getTsnshrgndgkValue()))
            .orNull();
    }

    transient private String tsnshrgndgkType = null;

    @Column(name=TSNSHRGNDGK + "$", nullable=true)
    protected String getTsnshrgndgkType() {
        if (tsnshrgndgkType == null && tsnshrgndgk != null) return tsnshrgndgk.getType().toString();
        if (tsnshrgndgkType == null && getTsnshrgndgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tsnshrgndgk$' should not be NULL."));
        }
        return tsnshrgndgkType;
    }

    protected void setTsnshrgndgkType(String type) {
        tsnshrgndgkType = type;
        tsnshrgndgk = Optional.fromNullable(toCurrencyType(tsnshrgndgkType))
            .transform(bizCurrencyTransformer(getTsnshrgndgkValue()))
            .orNull();
    }

    private C_UmuKbn itjsytkkziumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.ITJSYTKKZIUMU)
    public C_UmuKbn getItjsytkkziumu() {
        return itjsytkkziumu;
    }

    public void setItjsytkkziumu(C_UmuKbn pItjsytkkziumu) {
        itjsytkkziumu = pItjsytkkziumu;
    }

    private C_UmuKbn gansknnkaisiymdumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.GANSKNNKAISIYMDUMU)
    public C_UmuKbn getGansknnkaisiymdumu() {
        return gansknnkaisiymdumu;
    }

    public void setGansknnkaisiymdumu(C_UmuKbn pGansknnkaisiymdumu) {
        gansknnkaisiymdumu = pGansknnkaisiymdumu;
    }

    private Integer gansknnkaisikeikanisuu;

    @Column(name=GenBM_SyouhnZokusei.GANSKNNKAISIKEIKANISUU)
    public Integer getGansknnkaisikeikanisuu() {
        return gansknnkaisikeikanisuu;
    }

    public void setGansknnkaisikeikanisuu(Integer pGansknnkaisikeikanisuu) {
        gansknnkaisikeikanisuu = pGansknnkaisikeikanisuu;
    }

    private C_UmuKbn gantkhktctrlumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.GANTKHKTCTRLUMU)
    public C_UmuKbn getGantkhktctrlumu() {
        return gantkhktctrlumu;
    }

    public void setGantkhktctrlumu(C_UmuKbn pGantkhktctrlumu) {
        gantkhktctrlumu = pGantkhktctrlumu;
    }

    private Integer iktpcalcssketasuu;

    @Column(name=GenBM_SyouhnZokusei.IKTPCALCSSKETASUU)
    public Integer getIktpcalcssketasuu() {
        return iktpcalcssketasuu;
    }

    public void setIktpcalcssketasuu(Integer pIktpcalcssketasuu) {
        iktpcalcssketasuu = pIktpcalcssketasuu;
    }

    private String tratkikanousinsahou;

    @Column(name=GenBM_SyouhnZokusei.TRATKIKANOUSINSAHOU)
    public String getTratkikanousinsahou() {
        return tratkikanousinsahou;
    }

    public void setTratkikanousinsahou(String pTratkikanousinsahou) {
        tratkikanousinsahou = pTratkikanousinsahou;
    }

    private C_UmuKbn kostratkiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.KOSTRATKIUMU)
    public C_UmuKbn getKostratkiumu() {
        return kostratkiumu;
    }

    public void setKostratkiumu(C_UmuKbn pKostratkiumu) {
        kostratkiumu = pKostratkiumu;
    }

    private Integer kosmnrynen;

    @Column(name=GenBM_SyouhnZokusei.KOSMNRYNEN)
    public Integer getKosmnrynen() {
        return kosmnrynen;
    }

    public void setKosmnrynen(Integer pKosmnrynen) {
        kosmnrynen = pKosmnrynen;
    }

    private C_UmuKbn shrtysysksumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.SHRTYSYSKSUMU)
    public C_UmuKbn getShrtysysksumu() {
        return shrtysysksumu;
    }

    public void setShrtysysksumu(C_UmuKbn pShrtysysksumu) {
        shrtysysksumu = pShrtysysksumu;
    }

    private C_ShrtysyhknsyuKbn shrtysyhknsyukbn;

    @Type(type="UserType_C_ShrtysyhknsyuKbn")
    @Column(name=GenBM_SyouhnZokusei.SHRTYSYHKNSYUKBN)
    public C_ShrtysyhknsyuKbn getShrtysyhknsyukbn() {
        return shrtysyhknsyukbn;
    }

    public void setShrtysyhknsyukbn(C_ShrtysyhknsyuKbn pShrtysyhknsyukbn) {
        shrtysyhknsyukbn = pShrtysyhknsyukbn;
    }

    private C_UmuKbn synndkyfknshrskgnumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.SYNNDKYFKNSHRSKGNUMU)
    public C_UmuKbn getSynndkyfknshrskgnumu() {
        return synndkyfknshrskgnumu;
    }

    public void setSynndkyfknshrskgnumu(C_UmuKbn pSynndkyfknshrskgnumu) {
        synndkyfknshrskgnumu = pSynndkyfknshrskgnumu;
    }

    private C_UmuKbn dai1hknkknsbsyokuseiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.DAI1HKNKKNSBSYOKUSEIUMU)
    public C_UmuKbn getDai1hknkknsbsyokuseiumu() {
        return dai1hknkknsbsyokuseiumu;
    }

    public void setDai1hknkknsbsyokuseiumu(C_UmuKbn pDai1hknkknsbsyokuseiumu) {
        dai1hknkknsbsyokuseiumu = pDai1hknkknsbsyokuseiumu;
    }

    private C_HknkknBunruiKbn hknkknbunruikbn;

    @Type(type="UserType_C_HknkknBunruiKbn")
    @Column(name=GenBM_SyouhnZokusei.HKNKKNBUNRUIKBN)
    public C_HknkknBunruiKbn getHknkknbunruikbn() {
        return hknkknbunruikbn;
    }

    public void setHknkknbunruikbn(C_HknkknBunruiKbn pHknkknbunruikbn) {
        hknkknbunruikbn = pHknkknbunruikbn;
    }

    private C_UmuKbn mvatekiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.MVATEKIUMU)
    public C_UmuKbn getMvatekiumu() {
        return mvatekiumu;
    }

    public void setMvatekiumu(C_UmuKbn pMvatekiumu) {
        mvatekiumu = pMvatekiumu;
    }

    private Integer mvatekikkn;

    @Column(name=GenBM_SyouhnZokusei.MVATEKIKKN)
    @Range(min="0", max="99")
    public Integer getMvatekikkn() {
        return mvatekikkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMvatekikkn(Integer pMvatekikkn) {
        mvatekikkn = pMvatekikkn;
    }

    private BizNumber mvatyouseijikou;

    @Type(type="BizNumberType")
    @Column(name=GenBM_SyouhnZokusei.MVATYOUSEIJIKOU)
    public BizNumber getMvatyouseijikou() {
        return mvatyouseijikou;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMvatyouseijikou(BizNumber pMvatyouseijikou) {
        mvatyouseijikou = pMvatyouseijikou;
    }

    private C_UmuKbn kaiyakukoujyoritutekiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.KAIYAKUKOUJYORITUTEKIUMU)
    public C_UmuKbn getKaiyakukoujyoritutekiumu() {
        return kaiyakukoujyoritutekiumu;
    }

    public void setKaiyakukoujyoritutekiumu(C_UmuKbn pKaiyakukoujyoritutekiumu) {
        kaiyakukoujyoritutekiumu = pKaiyakukoujyoritutekiumu;
    }

    private Integer kaiyakukoujyoritutekikkn;

    @Column(name=GenBM_SyouhnZokusei.KAIYAKUKOUJYORITUTEKIKKN)
    @Range(min="0", max="99")
    public Integer getKaiyakukoujyoritutekikkn() {
        return kaiyakukoujyoritutekikkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKaiyakukoujyoritutekikkn(Integer pKaiyakukoujyoritutekikkn) {
        kaiyakukoujyoritutekikkn = pKaiyakukoujyoritutekikkn;
    }

    private BizCurrency tkbripfgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getTkbripfgk() {
        return tkbripfgk;
    }

    public void setTkbripfgk(BizCurrency pTkbripfgk) {
        tkbripfgk = pTkbripfgk;
        tkbripfgkValue = null;
        tkbripfgkType  = null;
    }

    transient private BigDecimal tkbripfgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=TKBRIPFGK, nullable=true)
    protected BigDecimal getTkbripfgkValue() {
        if (tkbripfgkValue == null && tkbripfgk != null) {
            if (tkbripfgk.isOptional()) return null;
            return tkbripfgk.absolute();
        }
        return tkbripfgkValue;
    }

    protected void setTkbripfgkValue(BigDecimal value) {
        tkbripfgkValue = value;
        tkbripfgk = Optional.fromNullable(toCurrencyType(tkbripfgkType))
            .transform(bizCurrencyTransformer(getTkbripfgkValue()))
            .orNull();
    }

    transient private String tkbripfgkType = null;

    @Column(name=TKBRIPFGK + "$", nullable=true)
    protected String getTkbripfgkType() {
        if (tkbripfgkType == null && tkbripfgk != null) return tkbripfgk.getType().toString();
        if (tkbripfgkType == null && getTkbripfgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'tkbripfgk$' should not be NULL."));
        }
        return tkbripfgkType;
    }

    protected void setTkbripfgkType(String type) {
        tkbripfgkType = type;
        tkbripfgk = Optional.fromNullable(toCurrencyType(tkbripfgkType))
            .transform(bizCurrencyTransformer(getTkbripfgkValue()))
            .orNull();
    }

    private BizCurrency hnnnbripfgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getHnnnbripfgk() {
        return hnnnbripfgk;
    }

    public void setHnnnbripfgk(BizCurrency pHnnnbripfgk) {
        hnnnbripfgk = pHnnnbripfgk;
        hnnnbripfgkValue = null;
        hnnnbripfgkType  = null;
    }

    transient private BigDecimal hnnnbripfgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=HNNNBRIPFGK, nullable=true)
    protected BigDecimal getHnnnbripfgkValue() {
        if (hnnnbripfgkValue == null && hnnnbripfgk != null) {
            if (hnnnbripfgk.isOptional()) return null;
            return hnnnbripfgk.absolute();
        }
        return hnnnbripfgkValue;
    }

    protected void setHnnnbripfgkValue(BigDecimal value) {
        hnnnbripfgkValue = value;
        hnnnbripfgk = Optional.fromNullable(toCurrencyType(hnnnbripfgkType))
            .transform(bizCurrencyTransformer(getHnnnbripfgkValue()))
            .orNull();
    }

    transient private String hnnnbripfgkType = null;

    @Column(name=HNNNBRIPFGK + "$", nullable=true)
    protected String getHnnnbripfgkType() {
        if (hnnnbripfgkType == null && hnnnbripfgk != null) return hnnnbripfgk.getType().toString();
        if (hnnnbripfgkType == null && getHnnnbripfgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'hnnnbripfgk$' should not be NULL."));
        }
        return hnnnbripfgkType;
    }

    protected void setHnnnbripfgkType(String type) {
        hnnnbripfgkType = type;
        hnnnbripfgk = Optional.fromNullable(toCurrencyType(hnnnbripfgkType))
            .transform(bizCurrencyTransformer(getHnnnbripfgkValue()))
            .orNull();
    }

    private BizCurrency nnbripfgk;

    @Type(type="BizCurrencyType")
    @Transient
    public BizCurrency getNnbripfgk() {
        return nnbripfgk;
    }

    public void setNnbripfgk(BizCurrency pNnbripfgk) {
        nnbripfgk = pNnbripfgk;
        nnbripfgkValue = null;
        nnbripfgkType  = null;
    }

    transient private BigDecimal nnbripfgkValue = null;

    @SuppressWarnings("deprecation")
    @Column(name=NNBRIPFGK, nullable=true)
    protected BigDecimal getNnbripfgkValue() {
        if (nnbripfgkValue == null && nnbripfgk != null) {
            if (nnbripfgk.isOptional()) return null;
            return nnbripfgk.absolute();
        }
        return nnbripfgkValue;
    }

    protected void setNnbripfgkValue(BigDecimal value) {
        nnbripfgkValue = value;
        nnbripfgk = Optional.fromNullable(toCurrencyType(nnbripfgkType))
            .transform(bizCurrencyTransformer(getNnbripfgkValue()))
            .orNull();
    }

    transient private String nnbripfgkType = null;

    @Column(name=NNBRIPFGK + "$", nullable=true)
    protected String getNnbripfgkType() {
        if (nnbripfgkType == null && nnbripfgk != null) return nnbripfgk.getType().toString();
        if (nnbripfgkType == null && getNnbripfgkValue() != null) {
            throw new RuntimeException(new SQLException("BizCurrency field 'nnbripfgk$' should not be NULL."));
        }
        return nnbripfgkType;
    }

    protected void setNnbripfgkType(String type) {
        nnbripfgkType = type;
        nnbripfgk = Optional.fromNullable(toCurrencyType(nnbripfgkType))
            .transform(bizCurrencyTransformer(getNnbripfgkValue()))
            .orNull();
    }

    private C_Gwhensyuuoutjyuni gwhensyuuoutjyuni;

    @Type(type="UserType_C_Gwhensyuuoutjyuni")
    @Column(name=GenBM_SyouhnZokusei.GWHENSYUUOUTJYUNI)
    public C_Gwhensyuuoutjyuni getGwhensyuuoutjyuni() {
        return gwhensyuuoutjyuni;
    }

    public void setGwhensyuuoutjyuni(C_Gwhensyuuoutjyuni pGwhensyuuoutjyuni) {
        gwhensyuuoutjyuni = pGwhensyuuoutjyuni;
    }

    private C_KoujyosyoumeipKbn koujyosyoumeipkbn;

    @Type(type="UserType_C_KoujyosyoumeipKbn")
    @Column(name=GenBM_SyouhnZokusei.KOUJYOSYOUMEIPKBN)
    public C_KoujyosyoumeipKbn getKoujyosyoumeipkbn() {
        return koujyosyoumeipkbn;
    }

    public void setKoujyosyoumeipkbn(C_KoujyosyoumeipKbn pKoujyosyoumeipkbn) {
        koujyosyoumeipkbn = pKoujyosyoumeipkbn;
    }

    private C_UmuKbn zeiseitekikakuumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.ZEISEITEKIKAKUUMU)
    public C_UmuKbn getZeiseitekikakuumu() {
        return zeiseitekikakuumu;
    }

    public void setZeiseitekikakuumu(C_UmuKbn pZeiseitekikakuumu) {
        zeiseitekikakuumu = pZeiseitekikakuumu;
    }

    private C_UmuKbn fatcataisyouumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.FATCATAISYOUUMU)
    public C_UmuKbn getFatcataisyouumu() {
        return fatcataisyouumu;
    }

    public void setFatcataisyouumu(C_UmuKbn pFatcataisyouumu) {
        fatcataisyouumu = pFatcataisyouumu;
    }

    private C_UmuKbn aeoitaisyouumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.AEOITAISYOUUMU)
    public C_UmuKbn getAeoitaisyouumu() {
        return aeoitaisyouumu;
    }

    public void setAeoitaisyouumu(C_UmuKbn pAeoitaisyouumu) {
        aeoitaisyouumu = pAeoitaisyouumu;
    }

    private C_UmuKbn houteityotkseiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.HOUTEITYOTKSEIUMU)
    public C_UmuKbn getHouteityotkseiumu() {
        return houteityotkseiumu;
    }

    public void setHouteityotkseiumu(C_UmuKbn pHouteityotkseiumu) {
        houteityotkseiumu = pHouteityotkseiumu;
    }

    private C_Segcd seg1cd;

    @Type(type="UserType_C_Segcd")
    @Column(name=GenBM_SyouhnZokusei.SEG1CD)
    public C_Segcd getSeg1cd() {
        return seg1cd;
    }

    public void setSeg1cd(C_Segcd pSeg1cd) {
        seg1cd = pSeg1cd;
    }

    private C_Segcd seg2cd;

    @Type(type="UserType_C_Segcd")
    @Column(name=GenBM_SyouhnZokusei.SEG2CD)
    public C_Segcd getSeg2cd() {
        return seg2cd;
    }

    public void setSeg2cd(C_Segcd pSeg2cd) {
        seg2cd = pSeg2cd;
    }

    private String gwhknsyurui;

    @Column(name=GenBM_SyouhnZokusei.GWHKNSYURUI)
    public String getGwhknsyurui() {
        return gwhknsyurui;
    }

    public void setGwhknsyurui(String pGwhknsyurui) {
        gwhknsyurui = pGwhknsyurui;
    }

    private String gwhosyucd;

    @Column(name=GenBM_SyouhnZokusei.GWHOSYUCD)
    public String getGwhosyucd() {
        return gwhosyucd;
    }

    public void setGwhosyucd(String pGwhosyucd) {
        gwhosyucd = pGwhosyucd;
    }

    private String gwsyouhncd;

    @Column(name=GenBM_SyouhnZokusei.GWSYOUHNCD)
    public String getGwsyouhncd() {
        return gwsyouhncd;
    }

    public void setGwsyouhncd(String pGwsyouhncd) {
        gwsyouhncd = pGwsyouhncd;
    }

    private String gwsyouhnnm;

    @Column(name=GenBM_SyouhnZokusei.GWSYOUHNNM)
    public String getGwsyouhnnm() {
        return gwsyouhnnm;
    }

    public void setGwsyouhnnm(String pGwsyouhnnm) {
        gwsyouhnnm = pGwsyouhnnm;
    }

    private String hknsyuruikoujyosyoumei;

    @Column(name=GenBM_SyouhnZokusei.HKNSYURUIKOUJYOSYOUMEI)
    public String getHknsyuruikoujyosyoumei() {
        return hknsyuruikoujyosyoumei;
    }

    public void setHknsyuruikoujyosyoumei(String pHknsyuruikoujyosyoumei) {
        hknsyuruikoujyosyoumei = pHknsyuruikoujyosyoumei;
    }

    private C_Sknenkinsyu sknenkinsyu;

    @Type(type="UserType_C_Sknenkinsyu")
    @Column(name=GenBM_SyouhnZokusei.SKNENKINSYU)
    public C_Sknenkinsyu getSknenkinsyu() {
        return sknenkinsyu;
    }

    public void setSknenkinsyu(C_Sknenkinsyu pSknenkinsyu) {
        sknenkinsyu = pSknenkinsyu;
    }

    private C_UmuKbn nkuktumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.NKUKTUMU)
    public C_UmuKbn getNkuktumu() {
        return nkuktumu;
    }

    public void setNkuktumu(C_UmuKbn pNkuktumu) {
        nkuktumu = pNkuktumu;
    }

    private C_UmuKbn tmttknhaibunwarisiteiumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SyouhnZokusei.TMTTKNHAIBUNWARISITEIUMU)
    public C_UmuKbn getTmttknhaibunwarisiteiumu() {
        return tmttknhaibunwarisiteiumu;
    }

    public void setTmttknhaibunwarisiteiumu(C_UmuKbn pTmttknhaibunwarisiteiumu) {
        tmttknhaibunwarisiteiumu = pTmttknhaibunwarisiteiumu;
    }

    private C_TargetTkHukaKanouKbn targettkhukakanoukbn;

    @Type(type="UserType_C_TargetTkHukaKanouKbn")
    @Column(name=GenBM_SyouhnZokusei.TARGETTKHUKAKANOUKBN)
    public C_TargetTkHukaKanouKbn getTargettkhukakanoukbn() {
        return targettkhukakanoukbn;
    }

    public void setTargettkhukakanoukbn(C_TargetTkHukaKanouKbn pTargettkhukakanoukbn) {
        targettkhukakanoukbn = pTargettkhukakanoukbn;
    }

    private C_MousideIkouKbn mousideikoukbn;

    @Type(type="UserType_C_MousideIkouKbn")
    @Column(name=GenBM_SyouhnZokusei.MOUSIDEIKOUKBN)
    public C_MousideIkouKbn getMousideikoukbn() {
        return mousideikoukbn;
    }

    public void setMousideikoukbn(C_MousideIkouKbn pMousideikoukbn) {
        mousideikoukbn = pMousideikoukbn;
    }

    private String yendthnksyouhncd;

    @Column(name=GenBM_SyouhnZokusei.YENDTHNKSYOUHNCD)
    public String getYendthnksyouhncd() {
        return yendthnksyouhncd;
    }

    public void setYendthnksyouhncd(String pYendthnksyouhncd) {
        yendthnksyouhncd = pYendthnksyouhncd;
    }

    private C_Sisuukbn sisuukbn;

    @Type(type="UserType_C_Sisuukbn")
    @Column(name=GenBM_SyouhnZokusei.SISUUKBN)
    public C_Sisuukbn getSisuukbn() {
        return sisuukbn;
    }

    public void setSisuukbn(C_Sisuukbn pSisuukbn) {
        sisuukbn = pSisuukbn;
    }

    private C_TyksenhokanhouKbn tyksenhokanhoukbn;

    @Type(type="UserType_C_TyksenhokanhouKbn")
    @Column(name=GenBM_SyouhnZokusei.TYKSENHOKANHOUKBN)
    public C_TyksenhokanhouKbn getTyksenhokanhoukbn() {
        return tyksenhokanhoukbn;
    }

    public void setTyksenhokanhoukbn(C_TyksenhokanhouKbn pTyksenhokanhoukbn) {
        tyksenhokanhoukbn = pTyksenhokanhoukbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenBM_SyouhnZokusei.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBM_SyouhnZokusei.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBM_SyouhnZokusei.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}